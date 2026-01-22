package com.tencent.qcloud.tuicore.util;

import android.R;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qcloud.tuicore.ServiceInitializer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ToastUtil {
    private static Toast toast;

    public static void toastLongMessage(String str) {
        toastMessage(str, true);
    }

    private static void toastMessage(final String str, final boolean z) {
        BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuicore.util.ToastUtil.1
            @Override // java.lang.Runnable
            public void run() {
                TextView textView;
                if (ToastUtil.toast != null) {
                    ToastUtil.toast.cancel();
                    ToastUtil.toast = null;
                }
                ToastUtil.toast = Toast.makeText(ServiceInitializer.getAppContext(), str, z ? 1 : 0);
                View view = ToastUtil.toast.getView();
                if (view != null && (textView = (TextView) view.findViewById(R.id.message)) != null) {
                    textView.setGravity(17);
                }
                ToastUtil.toast.show();
            }
        });
    }

    public static void toastShortMessage(String str) {
        toastMessage(str, false);
    }
}
