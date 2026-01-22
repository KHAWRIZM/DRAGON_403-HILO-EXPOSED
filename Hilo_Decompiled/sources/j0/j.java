package j0;

import java.util.ArrayList;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.ISudListenerPreloadMGPkg;
import tech.sud.gip.core.PkgDownloadStatus;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class j extends x0.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f.a f١٥٠٨٩a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f١٥٠٩٠b;

    public j(l lVar, f.a aVar) {
        this.f١٥٠٩٠b = lVar;
        this.f١٥٠٨٩a = aVar;
    }

    @Override // re.a
    public final void b(String str, wf.e eVar) {
        l lVar = this.f١٥٠٩٠b;
        ArrayList arrayList = lVar.f١٥٠٩٥b;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((ISudListenerPreloadMGPkg) obj).onPreloadSuccess(lVar.f١٥٠٩٤a);
        }
        lVar.f١٥٠٩٦c = false;
        lVar.f١٥٠٩٥b.clear();
        u uVar = lVar.f١٥١٠١h;
        if (uVar != null) {
            uVar.f١٥١٢٧a.f١٥١٢٩a.remove(Long.valueOf(lVar.f١٥٠٩٤a));
        }
        f.a aVar = this.f١٥٠٨٩a;
        aVar.f١٤٠٠٢e = 0;
        aVar.f١٤٠٠٣f = "success";
        aVar.f١٤٠١١n = eVar;
        String str2 = f.d.f١٤٠٢٣a;
        ThreadUtils.postUITask(new f.b(aVar.toString(), false, aVar.f١٣٩٩٨a, 0));
    }

    @Override // re.a
    public final void c(long j10, long j11, PkgDownloadStatus pkgDownloadStatus) {
        l lVar = this.f١٥٠٩٠b;
        lVar.f١٥٠٩٩f = j10;
        lVar.f١٥١٠٠g = j11;
        ArrayList arrayList = lVar.f١٥٠٩٥b;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((ISudListenerPreloadMGPkg) arrayList.get(i10)).onPreloadStatus(lVar.f١٥٠٩٤a, j10, j11, pkgDownloadStatus);
        }
    }

    @Override // re.a
    public final void e(int i10, String str, wf.e eVar) {
        this.f١٥٠٩٠b.a(i10, str);
        f.a aVar = this.f١٥٠٨٩a;
        aVar.f١٤٠٠٢e = i10;
        if (str != null) {
            aVar.f١٤٠٠٣f = str;
        }
        aVar.f١٤٠١١n = eVar;
        String str2 = f.d.f١٤٠٢٣a;
        ThreadUtils.postUITask(new f.b(aVar.toString(), false, aVar.f١٣٩٩٨a, i10));
    }
}
