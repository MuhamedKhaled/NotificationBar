package com.mohamed.notificationbar;

import android.animation.AnimatorSet;
import android.view.Gravity;

import com.mohamed.notificationbar.Interface.CustomViewInitializer;
import com.mohamed.notificationbar.Interface.OnActionClickListener;

public class Params {

    public String title;
    public String message;
    public String action;
    public boolean enableSwipeToDismiss = true;
    public boolean enableAutoDismiss = true;
    public int iconResId;
    public int backgroundColor;
    public int titleColor;
    public int messageColor;
    public int actionColor;
    public long duration = 2000;
    public int notificationPosition = Gravity.TOP;
    public int customViewResource;
    public int animationInTop = R.anim.slide_in_from_top;
    public int animationInBottom = R.anim.slide_in_from_bottom;
    public int animationOutTop = R.anim.slide_out_to_top;
    public int animationOutBottom = R.anim.slide_out_to_bottom;
    public CustomViewInitializer viewInitializer;
    public OnActionClickListener onActionClickListener;
    public AnimatorSet iconAnimator;
}
