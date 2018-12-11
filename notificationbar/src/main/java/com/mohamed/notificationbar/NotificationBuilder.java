package com.mohamed.notificationbar;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.support.annotation.AnimRes;
import android.support.annotation.AnimatorRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.view.Gravity;

import com.mohamed.notificationbar.Interface.CustomViewInitializer;
import com.mohamed.notificationbar.Interface.OnActionClickListener;

public class NotificationBuilder {

    private final Params params = new Params();
    private final Activity context;
    /**
     * Create a Builder for an Notification.
     */
    NotificationBuilder(Activity activity) {
        this.context = activity;
    }
    public NotificationBuilder setIcon(@DrawableRes int iconResId) {
        params.iconResId = iconResId;
        return this;
    }

    public NotificationBuilder setTitle(String title) {
        params.title = title;
        return this;
    }

    public NotificationBuilder setTitle(@StringRes int resId) {
        params.title = context.getString(resId);
        return this;
    }


    public NotificationBuilder setMessage(String message) {
        params.message = message;
        return this;
    }

    public NotificationBuilder setMessage(@StringRes int resId) {
        params.message = context.getString(resId);
        return this;
    }

    public NotificationBuilder setDuration(long duration) {
        params.duration = duration;
        return this;
    }

    public NotificationBuilder setTitleColor(@ColorRes int titleColor) {
        params.titleColor = titleColor;
        return this;
    }

    public NotificationBuilder setMessageColor(@ColorRes int messageColor) {
        params.messageColor = messageColor;
        return this;
    }

    public NotificationBuilder setBackgroundColor(@ColorRes int backgroundColor) {
        params.backgroundColor = backgroundColor;
        return this;
    }

    public NotificationBuilder setActionColor(@ColorRes int actionColor) {
        params.actionColor = actionColor;
        return this;
    }

    public NotificationBuilder setAction(String action, OnActionClickListener onActionClickListener) {
        params.action = action;
        params.onActionClickListener = onActionClickListener;
        return this;
    }

    public NotificationBuilder setIconAnimation(@AnimatorRes int iconAnimation){
        params.iconAnimator = (AnimatorSet) AnimatorInflater.loadAnimator(context,iconAnimation);
        return this;
    }

    public NotificationBuilder setAction(@StringRes int resId, OnActionClickListener onActionClickListener) {
        params.action = context.getString(resId);
        params.onActionClickListener = onActionClickListener;
        return this;
    }

    /**
     * Sets Notification position
     *
     * @param notificationPosition Cookie position, use either CookieBar.TOP or CookieBar.BOTTOM
     * @return NotificationBuilder
     */
    public NotificationBuilder setNotificationPosition(int notificationPosition) {
        params.notificationPosition = notificationPosition;
        return this;
    }

    public NotificationBuilder setCustomView(@LayoutRes int customView) {
        params.customViewResource = customView;
        return this;
    }

    public NotificationBuilder setCustomViewInitializer(CustomViewInitializer viewInitializer) {
        params.viewInitializer = viewInitializer;
        return this;
    }


    public NotificationBuilder setAnimationIn(@AnimRes int topAnimation, @AnimRes int bottomAnimation) {
        params.animationInTop = topAnimation;
        params.animationInBottom = bottomAnimation;
        return this;
    }

    public NotificationBuilder setAnimationOut(@AnimRes int topAnimation, @AnimRes int bottomAnimation) {
        params.animationOutTop = topAnimation;
        params.animationOutBottom = bottomAnimation;
        return this;
    }

    public NotificationBuilder setEnableAutoDismiss(boolean enableAutoDismiss) {
        params.enableAutoDismiss = enableAutoDismiss;
        return this;
    }

    public NotificationBuilder setSwipeToDismiss(boolean enableSwipeToDismiss) {
        params.enableSwipeToDismiss = enableSwipeToDismiss;
        return this;
    }

    public NotificationBar create() {
        return new NotificationBar(context, params);
    }

    public NotificationBar show() {
        final NotificationBar notification = create();
        notification.show();
        return notification;
    }




}
