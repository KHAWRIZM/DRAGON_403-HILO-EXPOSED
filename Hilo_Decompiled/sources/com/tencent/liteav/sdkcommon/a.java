package com.tencent.liteav.sdkcommon;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class a implements Runnable {
    private final DashboardManager a;
    private final boolean b;

    private a(DashboardManager dashboardManager, boolean z) {
        this.a = dashboardManager;
        this.b = z;
    }

    public static Runnable a(DashboardManager dashboardManager, boolean z) {
        return new a(dashboardManager, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.showDashboardInternal(this.b);
    }
}
