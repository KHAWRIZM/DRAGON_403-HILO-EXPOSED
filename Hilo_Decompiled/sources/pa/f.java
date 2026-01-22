package pa;

import android.view.animation.Interpolator;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Arrays;
import pa.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    int f١٦٩٩٥a;

    /* renamed from: b, reason: collision with root package name */
    e f١٦٩٩٦b;

    /* renamed from: c, reason: collision with root package name */
    e f١٦٩٩٧c;

    /* renamed from: d, reason: collision with root package name */
    Interpolator f١٦٩٩٨d;

    /* renamed from: e, reason: collision with root package name */
    ArrayList f١٦٩٩٩e;

    /* renamed from: f, reason: collision with root package name */
    h f١٧٠٠٠f;

    public f(e... eVarArr) {
        this.f١٦٩٩٥a = eVarArr.length;
        ArrayList arrayList = new ArrayList();
        this.f١٦٩٩٩e = arrayList;
        arrayList.addAll(Arrays.asList(eVarArr));
        this.f١٦٩٩٦b = (e) this.f١٦٩٩٩e.get(0);
        e eVar = (e) this.f١٦٩٩٩e.get(this.f١٦٩٩٥a - 1);
        this.f١٦٩٩٧c = eVar;
        this.f١٦٩٩٨d = eVar.c();
    }

    public static f b(float... fArr) {
        int length = fArr.length;
        e.a[] aVarArr = new e.a[Math.max(length, 2)];
        if (length == 1) {
            aVarArr[0] = (e.a) e.e(DownloadProgress.UNKNOWN_PROGRESS);
            aVarArr[1] = (e.a) e.f(1.0f, fArr[0]);
        } else {
            aVarArr[0] = (e.a) e.f(DownloadProgress.UNKNOWN_PROGRESS, fArr[0]);
            for (int i10 = 1; i10 < length; i10++) {
                aVarArr[i10] = (e.a) e.f(i10 / (length - 1), fArr[i10]);
            }
        }
        return new c(aVarArr);
    }

    /* renamed from: a */
    public abstract f clone();

    public void c(h hVar) {
        this.f١٧٠٠٠f = hVar;
    }

    public String toString() {
        String str = " ";
        for (int i10 = 0; i10 < this.f١٦٩٩٥a; i10++) {
            str = str + ((e) this.f١٦٩٩٩e.get(i10)).d() + "  ";
        }
        return str;
    }
}
