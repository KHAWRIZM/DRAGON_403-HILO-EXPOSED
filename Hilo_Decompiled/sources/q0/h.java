package q0;

import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class h implements c0.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f١٧٠٨١a;

    public h(a aVar) {
        this.f١٧٠٨١a = aVar;
    }

    @Override // c0.i
    public final void onCompleted(String str) {
        ArrayList arrayList = this.f١٧٠٨١a.f١٧٠٤٨b.f١٧٠٧٦z;
        if (arrayList != null) {
            arrayList.remove(this);
        }
        this.f١٧٠٨١a.f١٧٠٤٨b.notifyStateChange("a2ms-ai-common", str, null);
    }
}
