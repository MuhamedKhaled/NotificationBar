package com.mohamed.notificationbar;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.mohamed.notificationbar.Interface.NotificationBarDismissListener;

public class NotificationBar {

    public static final int TOP = Gravity.TOP;
    public static final int BOTTOM = Gravity.BOTTOM;

    private Notification notificationView;
    private final Activity context;

    private NotificationBar(Activity context, Params params) {
        this.context = context;
        if (params == null) {
            // since params is null, this notification object can only be used to dismiss
            // existing notification
            dismiss();
            return;
        }

        //notificationView = new Notification(context);
       // notificationView.setParams(params);
    }


    public static NotificationBuilder build(Activity activity) {
        return new NotificationBuilder(activity);
    }

    public static void dismiss(Activity activity) {
        new NotificationBar(activity, null);
    }

    private void dismiss() {
        final ViewGroup decorView = (ViewGroup) context.getWindow().getDecorView();
        final ViewGroup content = decorView.findViewById(android.R.id.content);

        removeFromParent(decorView);
        removeFromParent(content);
    }

    private void show(){
        if (notificationView!=null){
            final ViewGroup decorView = (ViewGroup) context.getWindow().getDecorView();
            final ViewGroup content = decorView.findViewById(android.R.id.content);

            if (notificationView.getParent() == null) {
                ViewGroup parent = notificationView.getLayoutGravity() == Gravity.BOTTOM ?
                        content : decorView;
                addNotification(parent, notificationView);
            }
        }
    }

    private void addNotification(final ViewGroup parent, final Notification notification) {
        if (notification.getParent() != null) {
            return;
        }

        // if exists, remove existing cookie
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            if (child instanceof Notification) {
                ((Notification) child).dismiss(new NotificationBarDismissListener() {
                    @Override
                    public void onDismiss() {
                        parent.addView(notification);
                    }
                });
                return;
            }
        }

        parent.addView(notification);
    }
    private void removeFromParent(ViewGroup parent) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            if (child instanceof Notification) {
                ((Notification) child).dismiss();
                return;
            }
        }

    }

}

