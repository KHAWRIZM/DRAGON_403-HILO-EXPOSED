package com.tencent.qcloud.tuicore.interfaces;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class TUICallback {
    public static void onError(TUICallback tUICallback, int i, String str) {
        if (tUICallback != null) {
            tUICallback.onError(i, str);
        }
    }

    public static void onSuccess(TUICallback tUICallback) {
        if (tUICallback != null) {
            tUICallback.onSuccess();
        }
    }

    public abstract void onError(int i, String str);

    public abstract void onSuccess();
}
