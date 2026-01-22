package f;

import tech.sud.gip.core.ISudListenerReportStatsEvent;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f١٤٠١٩a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f١٤٠٢٠b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f١٤٠٢١c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f١٤٠٢٢d;

    public b(String str, boolean z10, String str2, int i10) {
        this.f١٤٠١٩a = str;
        this.f١٤٠٢٠b = z10;
        this.f١٤٠٢١c = str2;
        this.f١٤٠٢٢d = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e.d.f١٣٧١٩b.r(this.f١٤٠١٩a, this.f١٤٠٢٠b);
        ISudListenerReportStatsEvent iSudListenerReportStatsEvent = d.f١٤٠٢٤b;
        if (iSudListenerReportStatsEvent != null) {
            iSudListenerReportStatsEvent.onReportStatsEvent(this.f١٤٠٢١c, this.f١٤٠٢٢d, this.f١٤٠١٩a);
        }
    }
}
