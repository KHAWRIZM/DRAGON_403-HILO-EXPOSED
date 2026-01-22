package com.alibaba.sdk.android.push.b;

import com.alibaba.sdk.android.error.ErrorCode;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private ErrorCode f٦٥٦٣a;

    public f(ErrorCode errorCode) {
        super(errorCode.toShortString());
        this.f٦٥٦٣a = errorCode;
    }

    public ErrorCode a() {
        return this.f٦٥٦٣a;
    }
}
