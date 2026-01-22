package com.alibaba.sdk.android.logger.b;

import com.alibaba.sdk.android.logger.LogLevel;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final LogLevel f٦٤٣٢a = LogLevel.WARN;

    /* renamed from: b, reason: collision with root package name */
    private boolean f٦٤٣٣b = true;

    /* renamed from: c, reason: collision with root package name */
    private LogLevel f٦٤٣٤c = f٦٤٣٢a;

    public void a(LogLevel logLevel) {
        this.f٦٤٣٤c = logLevel;
    }

    public boolean b(LogLevel logLevel) {
        return this.f٦٤٣٣b && logLevel.ordinal() >= this.f٦٤٣٤c.ordinal();
    }

    public void a(boolean z10) {
        this.f٦٤٣٣b = z10;
    }
}
