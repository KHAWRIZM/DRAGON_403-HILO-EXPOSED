package o3;

import android.graphics.PointF;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Collections;
import o3.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class n extends a {

    /* renamed from: i, reason: collision with root package name */
    private final PointF f١٦٥١٢i;

    /* renamed from: j, reason: collision with root package name */
    private final PointF f١٦٥١٣j;

    /* renamed from: k, reason: collision with root package name */
    private final a f١٦٥١٤k;

    /* renamed from: l, reason: collision with root package name */
    private final a f١٦٥١٥l;

    /* renamed from: m, reason: collision with root package name */
    protected y3.c f١٦٥١٦m;

    /* renamed from: n, reason: collision with root package name */
    protected y3.c f١٦٥١٧n;

    public n(a aVar, a aVar2) {
        super(Collections.emptyList());
        this.f١٦٥١٢i = new PointF();
        this.f١٦٥١٣j = new PointF();
        this.f١٦٥١٤k = aVar;
        this.f١٦٥١٥l = aVar2;
        n(f());
    }

    @Override // o3.a
    public void n(float f10) {
        this.f١٦٥١٤k.n(f10);
        this.f١٦٥١٥l.n(f10);
        this.f١٦٥١٢i.set(((Float) this.f١٦٥١٤k.h()).floatValue(), ((Float) this.f١٦٥١٥l.h()).floatValue());
        for (int i10 = 0; i10 < this.f١٦٤٧١a.size(); i10++) {
            ((a.b) this.f١٦٤٧١a.get(i10)).a();
        }
    }

    @Override // o3.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF h() {
        return i(null, DownloadProgress.UNKNOWN_PROGRESS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // o3.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public PointF i(y3.a aVar, float f10) {
        Float f11;
        y3.a b10;
        float floatValue;
        y3.a b11;
        float floatValue2;
        Float f12 = null;
        if (this.f١٦٥١٦m != null && (b11 = this.f١٦٥١٤k.b()) != null) {
            float d10 = this.f١٦٥١٤k.d();
            Float f13 = b11.f١٩١٢٣h;
            y3.c cVar = this.f١٦٥١٦m;
            float f14 = b11.f١٩١٢٢g;
            if (f13 == null) {
                floatValue2 = f14;
            } else {
                floatValue2 = f13.floatValue();
            }
            f11 = (Float) cVar.b(f14, floatValue2, (Float) b11.f١٩١١٧b, (Float) b11.f١٩١١٨c, f10, f10, d10);
        } else {
            f11 = null;
        }
        if (this.f١٦٥١٧n != null && (b10 = this.f١٦٥١٥l.b()) != null) {
            float d11 = this.f١٦٥١٥l.d();
            Float f15 = b10.f١٩١٢٣h;
            y3.c cVar2 = this.f١٦٥١٧n;
            float f16 = b10.f١٩١٢٢g;
            if (f15 == null) {
                floatValue = f16;
            } else {
                floatValue = f15.floatValue();
            }
            f12 = (Float) cVar2.b(f16, floatValue, (Float) b10.f١٩١١٧b, (Float) b10.f١٩١١٨c, f10, f10, d11);
        }
        if (f11 == null) {
            this.f١٦٥١٣j.set(this.f١٦٥١٢i.x, DownloadProgress.UNKNOWN_PROGRESS);
        } else {
            this.f١٦٥١٣j.set(f11.floatValue(), DownloadProgress.UNKNOWN_PROGRESS);
        }
        if (f12 == null) {
            PointF pointF = this.f١٦٥١٣j;
            pointF.set(pointF.x, this.f١٦٥١٢i.y);
        } else {
            PointF pointF2 = this.f١٦٥١٣j;
            pointF2.set(pointF2.x, f12.floatValue());
        }
        return this.f١٦٥١٣j;
    }

    public void s(y3.c cVar) {
        y3.c cVar2 = this.f١٦٥١٦m;
        if (cVar2 != null) {
            cVar2.c(null);
        }
        this.f١٦٥١٦m = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    public void t(y3.c cVar) {
        y3.c cVar2 = this.f١٦٥١٧n;
        if (cVar2 != null) {
            cVar2.c(null);
        }
        this.f١٦٥١٧n = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}
