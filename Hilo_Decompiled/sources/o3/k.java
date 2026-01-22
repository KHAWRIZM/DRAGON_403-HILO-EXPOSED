package o3;

import android.graphics.PointF;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class k extends g {

    /* renamed from: i, reason: collision with root package name */
    private final PointF f١٦٥٠٥i;

    public k(List list) {
        super(list);
        this.f١٦٥٠٥i = new PointF();
    }

    @Override // o3.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF i(y3.a aVar, float f10) {
        return j(aVar, f10, f10, f10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // o3.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public PointF j(y3.a aVar, float f10, float f11, float f12) {
        Object obj;
        PointF pointF;
        Object obj2 = aVar.f١٩١١٧b;
        if (obj2 != null && (obj = aVar.f١٩١١٨c) != null) {
            PointF pointF2 = (PointF) obj2;
            PointF pointF3 = (PointF) obj;
            y3.c cVar = this.f١٦٤٧٥e;
            if (cVar != null && (pointF = (PointF) cVar.b(aVar.f١٩١٢٢g, aVar.f١٩١٢٣h.floatValue(), pointF2, pointF3, f10, e(), f())) != null) {
                return pointF;
            }
            PointF pointF4 = this.f١٦٥٠٥i;
            float f13 = pointF2.x;
            float f14 = f13 + (f11 * (pointF3.x - f13));
            float f15 = pointF2.y;
            pointF4.set(f14, f15 + (f12 * (pointF3.y - f15)));
            return this.f١٦٥٠٥i;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
