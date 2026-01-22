package o3;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class j extends g {

    /* renamed from: i, reason: collision with root package name */
    private final PointF f١٦٥٠٠i;

    /* renamed from: j, reason: collision with root package name */
    private final float[] f١٦٥٠١j;

    /* renamed from: k, reason: collision with root package name */
    private final float[] f١٦٥٠٢k;

    /* renamed from: l, reason: collision with root package name */
    private final PathMeasure f١٦٥٠٣l;

    /* renamed from: m, reason: collision with root package name */
    private i f١٦٥٠٤m;

    public j(List list) {
        super(list);
        this.f١٦٥٠٠i = new PointF();
        this.f١٦٥٠١j = new float[2];
        this.f١٦٥٠٢k = new float[2];
        this.f١٦٥٠٣l = new PathMeasure();
    }

    @Override // o3.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF i(y3.a aVar, float f10) {
        PointF pointF;
        i iVar = (i) aVar;
        Path k10 = iVar.k();
        if (k10 == null) {
            return (PointF) aVar.f١٩١١٧b;
        }
        y3.c cVar = this.f١٦٤٧٥e;
        if (cVar != null && (pointF = (PointF) cVar.b(iVar.f١٩١٢٢g, iVar.f١٩١٢٣h.floatValue(), (PointF) iVar.f١٩١١٧b, (PointF) iVar.f١٩١١٨c, e(), f10, f())) != null) {
            return pointF;
        }
        if (this.f١٦٥٠٤m != iVar) {
            this.f١٦٥٠٣l.setPath(k10, false);
            this.f١٦٥٠٤m = iVar;
        }
        float length = this.f١٦٥٠٣l.getLength();
        float f11 = f10 * length;
        this.f١٦٥٠٣l.getPosTan(f11, this.f١٦٥٠١j, this.f١٦٥٠٢k);
        PointF pointF2 = this.f١٦٥٠٠i;
        float[] fArr = this.f١٦٥٠١j;
        pointF2.set(fArr[0], fArr[1]);
        if (f11 < DownloadProgress.UNKNOWN_PROGRESS) {
            PointF pointF3 = this.f١٦٥٠٠i;
            float[] fArr2 = this.f١٦٥٠٢k;
            pointF3.offset(fArr2[0] * f11, fArr2[1] * f11);
        } else if (f11 > length) {
            PointF pointF4 = this.f١٦٥٠٠i;
            float[] fArr3 = this.f١٦٥٠٢k;
            float f12 = f11 - length;
            pointF4.offset(fArr3[0] * f12, fArr3[1] * f12);
        }
        return this.f١٦٥٠٠i;
    }
}
