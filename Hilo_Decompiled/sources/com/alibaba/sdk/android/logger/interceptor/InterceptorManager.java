package com.alibaba.sdk.android.logger.interceptor;

import com.alibaba.sdk.android.logger.LogLevel;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class InterceptorManager {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<ILogInterceptor> f٦٤٤٧a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<c> f٦٤٤٨b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private a f٦٤٤٩c;

    /* renamed from: d, reason: collision with root package name */
    private b f٦٤٥٠d;

    public InterceptorManager(a aVar, b bVar) {
        this.f٦٤٤٩c = aVar;
        this.f٦٤٥٠d = bVar;
    }

    public InterceptorManager a() {
        InterceptorManager interceptorManager = new InterceptorManager(this.f٦٤٤٩c, this.f٦٤٥٠d);
        interceptorManager.f٦٤٤٧a.addAll(this.f٦٤٤٧a);
        interceptorManager.f٦٤٤٨b.addAll(this.f٦٤٤٨b);
        return interceptorManager;
    }

    public void toNextLogInterceptor(int i10, LogLevel logLevel, String str, Object[] objArr) {
        int i11 = i10 + 1;
        if (i11 >= this.f٦٤٤٧a.size()) {
            this.f٦٤٤٩c.handle(this, i11, logLevel, str, objArr);
        } else {
            this.f٦٤٤٧a.get(i11).handle(this, i11, logLevel, str, objArr);
        }
    }

    public void toNextLoggerInterceptor(int i10, LogLevel logLevel, String str, String str2) {
        int i11 = i10 + 1;
        if (i11 >= this.f٦٤٤٨b.size()) {
            this.f٦٤٥٠d.a(this, i11, logLevel, str, str2);
        } else {
            this.f٦٤٤٨b.get(i11).a(this, i11, logLevel, str, str2);
        }
    }

    public void a(LogLevel logLevel, String str, Object[] objArr) {
        toNextLogInterceptor(-1, logLevel, str, objArr);
    }

    public void a(ILogInterceptor iLogInterceptor) {
        this.f٦٤٤٧a.add(iLogInterceptor);
    }

    public void a(c cVar) {
        this.f٦٤٤٨b.add(cVar);
    }
}
