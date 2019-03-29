package com.blackcat.example.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentActivity;

import com.bumptech.glide.Glide;


/**
 * Created by blackcat on 2019/3/27.15.28
 */
public class GlideUtils {
    public static void laodImg(Context context, Application application, Activity activity, FragmentActivity fragmentActivity) {

        if (context instanceof Context) {
         DebugUtil.error("-----context=context");
        }
        if (context instanceof Application) {
            DebugUtil.error("-----context=Application");
        }
        if (context instanceof Activity) {
            DebugUtil.error("-----context=Activity");

        }
        if (context instanceof FragmentActivity) {
            DebugUtil.error("-----context=FragmentActivity");
        }

        if (application instanceof Context) {
            DebugUtil.error("-----application=context");
        }
        if (application instanceof Application) {
            DebugUtil.error("-----application=Application");
        }

        if (activity instanceof Context) {
            DebugUtil.error("-----activity=context");
        }

        if (activity instanceof Activity) {
            DebugUtil.error("-----activity=Activity");

        }
        if (activity instanceof FragmentActivity) {
            DebugUtil.error("-----activity=FragmentActivity");
        }

        if (fragmentActivity instanceof Context) {
            DebugUtil.error("-----fragmentActivity=context");
        }

        if (fragmentActivity instanceof Activity) {
            DebugUtil.error("-----fragmentActivity=Activity");

        }
        if (fragmentActivity instanceof FragmentActivity) {
            DebugUtil.error("-----fragmentActivity=FragmentActivity");
        }
        laodImg(context);
    }

    public static void laodImg(Context context) {

        if (context instanceof Context) {
            DebugUtil.error("-----2context=context");
        }
        if (context instanceof Application) {
            DebugUtil.error("-----2context=Application");
        }
        if (context instanceof Activity) {
            DebugUtil.error("-----2context=Activity");

        }
        if (context instanceof FragmentActivity) {
            DebugUtil.error("-----2context=FragmentActivity");
        }
    }
}
