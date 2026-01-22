package com.amazonaws.async;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface Callback<R> {
    void onError(Exception exc);

    void onResult(R r10);
}
