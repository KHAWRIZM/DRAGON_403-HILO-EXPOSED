package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class Response<T extends Result> {
    private Result zza;

    public Response() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T getResult() {
        return (T) this.zza;
    }

    public void setResult(T t10) {
        this.zza = t10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Response(T t10) {
        this.zza = t10;
    }
}
