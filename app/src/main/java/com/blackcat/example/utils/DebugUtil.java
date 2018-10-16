package com.blackcat.example.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

//在代码中要打印log,就直接DebugUtil.debug(....).然后如果发布的时候,就直接把这个类的DEBUG 改成false,这样所有的log就不会再打印在控制台.
public class DebugUtil {
    public static final boolean DEBUG = true;

    public static void toast(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    public static void debug(String tag, String msg) {
        if (DEBUG) {
            Log.d(getClassAndMethodName()+tag, msg);
        }
    }

    public static void debug(String msg) {
        if (DEBUG) {
            Log.d(getClassAndMethodName(), msg);
        }
    }

    public static void error(String tag, String error) {

        if (DEBUG) {

            Log.e(getClassAndMethodName()+tag, error);
        }
    }

    public static void error(String error) {

        if (DEBUG) {

            Log.e(getClassAndMethodName(), error);
        }
    }
    /**
     * 获取有类名与方法名
     * @return
     */
    private static String getClassAndMethodName() {
        /**
         * Throwable().getStackTrace()获取的是程序运行的堆栈信息，也就是程序运行到此处的流程，以及所有方法的信息
         * 这里我们为什么取2呢？0是代表createMessage方法信息，1是代表上一层方法的信息，这里我们
         * 取它是上两层方法的信息
         */
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        String fullClassName = stackTraceElement.getClassName();
        String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
        return className + "." + stackTraceElement.getMethodName() + "()-------";
    }
}