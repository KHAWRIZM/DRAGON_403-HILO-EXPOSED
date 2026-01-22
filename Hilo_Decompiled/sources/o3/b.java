package o3;

import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b extends g {
    public b(List list) {
        super(list);
    }

    public int q() {
        return r(b(), d());
    }

    public int r(y3.a aVar, float f10) {
        Float f11;
        Integer num;
        if (aVar.f١٩١١٧b != null && aVar.f١٩١١٨c != null) {
            y3.c cVar = this.f١٦٤٧٥e;
            if (cVar != null && (f11 = aVar.f١٩١٢٣h) != null && (num = (Integer) cVar.b(aVar.f١٩١٢٢g, f11.floatValue(), (Integer) aVar.f١٩١١٧b, (Integer) aVar.f١٩١١٨c, f10, e(), f())) != null) {
                return num.intValue();
            }
            return x3.d.c(x3.k.b(f10, DownloadProgress.UNKNOWN_PROGRESS, 1.0f), ((Integer) aVar.f١٩١١٧b).intValue(), ((Integer) aVar.f١٩١١٨c).intValue());
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // o3.a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Integer i(y3.a aVar, float f10) {
        return Integer.valueOf(r(aVar, f10));
    }
}
