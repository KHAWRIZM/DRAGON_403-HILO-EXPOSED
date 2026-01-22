package com.alibaba.sdk.android.push.common.util.a;

import com.alibaba.sdk.android.error.ErrorCode;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private final ErrorCode f٦٦١٥a;

    public a(ErrorCode errorCode) {
        super(errorCode.toShortString());
        this.f٦٦١٥a = errorCode;
    }

    public ErrorCode a() {
        return this.f٦٦١٥a;
    }
}
