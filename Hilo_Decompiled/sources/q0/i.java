package q0;

import c0.k;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class i implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f١٧٠٨٢a;

    public i(a aVar) {
        this.f١٧٠٨٢a = aVar;
    }

    @Override // c0.k
    public final void a(String str) {
        ArrayList arrayList = this.f١٧٠٨٢a.f١٧٠٤٨b.f١٧٠٧٦z;
        if (arrayList != null) {
            arrayList.remove(this);
        }
        this.f١٧٠٨٢a.f١٧٠٤٨b.notifyStateChange("a2ms-ai-sse", str, null);
    }

    @Override // c0.k
    public final void onCompleted() {
        ArrayList arrayList = this.f١٧٠٨٢a.f١٧٠٤٨b.f١٧٠٧٦z;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(this);
    }

    @Override // c0.k
    public final void onSseLine(String str) {
        this.f١٧٠٨٢a.f١٧٠٤٨b.notifyStateChange("a2ms-ai-sse", str, null);
    }
}
