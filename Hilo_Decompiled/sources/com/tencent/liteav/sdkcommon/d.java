package com.tencent.liteav.sdkcommon;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class d implements Runnable {
    private final DashboardManager a;

    private d(DashboardManager dashboardManager) {
        this.a = dashboardManager;
    }

    public static Runnable a(DashboardManager dashboardManager) {
        return new d(dashboardManager);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.removeAllDashboardInternal();
    }
}
