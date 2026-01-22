package w;

import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f١٨٦٤٧a;

    public e(ArrayList arrayList) {
        this.f١٨٦٤٧a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.f١٨٦٤٧a;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            n0.e eVar = (n0.e) obj;
            eVar.f١٦١٢٧p.i(eVar, 3, null);
        }
    }
}
