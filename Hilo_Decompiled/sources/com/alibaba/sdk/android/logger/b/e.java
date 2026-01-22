package com.alibaba.sdk.android.logger.b;

import com.alibaba.sdk.android.logger.ILogger;
import com.alibaba.sdk.android.logger.ILoggerWithControl;
import com.alibaba.sdk.android.logger.LogLevel;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class e implements ILogger {

    /* renamed from: a, reason: collision with root package name */
    private static final ILogger f٦٤٣٧a = new d();

    /* renamed from: b, reason: collision with root package name */
    private ILogger f٦٤٣٨b = f٦٤٣٧a;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<ILogger> f٦٤٣٩c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private b f٦٤٤٠d;

    public e(b bVar) {
        this.f٦٤٤٠d = bVar;
    }

    public void a(ILogger iLogger) {
        if (iLogger == null) {
            iLogger = f٦٤٣٧a;
        }
        this.f٦٤٣٨b = iLogger;
    }

    public void b(ILogger iLogger) {
        if (iLogger != null) {
            this.f٦٤٣٩c.add(iLogger);
        }
    }

    public void c(ILogger iLogger) {
        if (iLogger != null) {
            this.f٦٤٣٩c.remove(iLogger);
        }
    }

    @Override // com.alibaba.sdk.android.logger.ILogger
    public void print(LogLevel logLevel, String str, String str2) {
        if (a(this.f٦٤٣٨b, logLevel)) {
            try {
                this.f٦٤٣٨b.print(logLevel, str, str2);
            } catch (Throwable unused) {
            }
        }
        try {
            Iterator<ILogger> it = this.f٦٤٣٩c.iterator();
            while (it.hasNext()) {
                ILogger next = it.next();
                if (a(next, logLevel)) {
                    try {
                        next.print(logLevel, str, str2);
                    } catch (Throwable unused2) {
                    }
                }
            }
        } catch (Throwable unused3) {
        }
    }

    private boolean a(ILogger iLogger, LogLevel logLevel) {
        if (iLogger == null || !(iLogger instanceof ILoggerWithControl)) {
            return this.f٦٤٤٠d.b(logLevel);
        }
        try {
            if (((ILoggerWithControl) iLogger).isEnabled()) {
                return ((ILoggerWithControl) iLogger).isPrint(logLevel);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean a(LogLevel logLevel) {
        if (a(this.f٦٤٣٨b, logLevel)) {
            return true;
        }
        try {
            Iterator<ILogger> it = this.f٦٤٣٩c.iterator();
            while (it.hasNext()) {
                if (a(it.next(), logLevel)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
