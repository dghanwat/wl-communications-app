package com.worldline.comm.Utils;


import android.content.Context;
import android.widget.Toast;

public class UTIL {
    public static void showShortToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

    }
}
