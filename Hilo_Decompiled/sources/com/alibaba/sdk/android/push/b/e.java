package com.alibaba.sdk.android.push.b;

import com.alibaba.sdk.android.push.PushControlService;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class e implements PushControlService {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final e f٦٥٦٢a = new e();
    }

    private e() {
    }

    public static e a() {
        return a.f٦٥٦٢a;
    }

    @Override // com.alibaba.sdk.android.push.PushControlService
    public void disconnect() {
        com.alibaba.sdk.android.push.g.a.a().f();
    }

    @Override // com.alibaba.sdk.android.push.PushControlService
    public boolean isConnected() {
        return com.alibaba.sdk.android.push.g.a.a().c();
    }

    @Override // com.alibaba.sdk.android.push.PushControlService
    public void reconnect() {
        com.alibaba.sdk.android.push.g.a.a().d();
    }

    @Override // com.alibaba.sdk.android.push.PushControlService
    public void reset() {
        com.alibaba.sdk.android.push.g.a.a().e();
    }

    @Override // com.alibaba.sdk.android.push.PushControlService
    public void setConnectionChangeListener(PushControlService.ConnectionChangeListener connectionChangeListener) {
        com.alibaba.sdk.android.push.g.a.a().a(connectionChangeListener);
    }
}
