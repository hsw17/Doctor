package com.wd.mvplibrary.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * describe:ToastUtils
 * date:2019/11/6
 * author:任(Lenovo)
 * function:
 */
public class ToastUtils {
    private static Toast mToast;

    public static void init(Context context) {
        mToast = Toast.makeText(context, null, Toast.LENGTH_SHORT);
    }

    public static void show(int resId) {
        mToast.setText(resId);
        mToast.show();
    }

    public static void show(String charSequence) {
        mToast.setText(charSequence);
        mToast.show();
    }
}
