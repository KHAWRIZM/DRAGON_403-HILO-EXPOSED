package com.tencent.liteav.sdkcommon;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class b implements Runnable {
    private final DashboardManager a;
    private final String b;

    private b(DashboardManager dashboardManager, String str) {
        this.a = dashboardManager;
        this.b = str;
    }

    public static Runnable a(DashboardManager dashboardManager, String str) {
        return new b(dashboardManager, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.addDashboardInternal(this.b);
    }
}
