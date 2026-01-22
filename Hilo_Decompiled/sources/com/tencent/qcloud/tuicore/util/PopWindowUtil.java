package com.tencent.qcloud.tuicore.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.qcloud.tuicore.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class PopWindowUtil {
    public static AlertDialog buildFullScreenDialog(Activity activity) {
        if (activity.isDestroyed()) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.TUIKit_AlertDialogStyle);
        builder.setTitle("");
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        create.getWindow().setDimAmount(0.0f);
        create.setCanceledOnTouchOutside(true);
        create.show();
        create.getWindow().setLayout(-1, -1);
        create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return create;
    }

    public static PopupWindow popupWindow(View view, View view2, int i, int i2) {
        PopupWindow popupWindow = new PopupWindow(view, -2, -2);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(-1360073216));
        popupWindow.showAtLocation(view, 49, i, i2);
        return popupWindow;
    }

    public static PopupWindow popupWindowAndShow(View view, View view2, int i, int i2) {
        PopupWindow popupWindow = new PopupWindow(view);
        popupWindow.setWidth(i);
        popupWindow.setHeight(i2);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.showAsDropDown(view2, 0, -10);
        return popupWindow;
    }
}
