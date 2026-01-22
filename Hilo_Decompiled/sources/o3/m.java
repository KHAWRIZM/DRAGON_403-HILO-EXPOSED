package o3;

import android.graphics.Path;
import java.util.List;
import n3.s;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class m extends a {

    /* renamed from: i, reason: collision with root package name */
    private final s3.o f١٦٥٠٧i;

    /* renamed from: j, reason: collision with root package name */
    private final Path f١٦٥٠٨j;

    /* renamed from: k, reason: collision with root package name */
    private Path f١٦٥٠٩k;

    /* renamed from: l, reason: collision with root package name */
    private Path f١٦٥١٠l;

    /* renamed from: m, reason: collision with root package name */
    private List f١٦٥١١m;

    public m(List list) {
        super(list);
        this.f١٦٥٠٧i = new s3.o();
        this.f١٦٥٠٨j = new Path();
    }

    @Override // o3.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Path i(y3.a aVar, float f10) {
        s3.o oVar;
        Path path;
        s3.o oVar2 = (s3.o) aVar.f١٩١١٧b;
        s3.o oVar3 = (s3.o) aVar.f١٩١١٨c;
        s3.o oVar4 = this.f١٦٥٠٧i;
        if (oVar3 == null) {
            oVar = oVar2;
        } else {
            oVar = oVar3;
        }
        oVar4.c(oVar2, oVar, f10);
        s3.o oVar5 = this.f١٦٥٠٧i;
        List list = this.f١٦٥١١m;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                oVar5 = ((s) this.f١٦٥١١m.get(size)).e(oVar5);
            }
        }
        x3.k.h(oVar5, this.f١٦٥٠٨j);
        if (this.f١٦٤٧٥e != null) {
            if (this.f١٦٥٠٩k == null) {
                this.f١٦٥٠٩k = new Path();
                this.f١٦٥١٠l = new Path();
            }
            x3.k.h(oVar2, this.f١٦٥٠٩k);
            if (oVar3 != null) {
                x3.k.h(oVar3, this.f١٦٥١٠l);
            }
            y3.c cVar = this.f١٦٤٧٥e;
            float f11 = aVar.f١٩١٢٢g;
            float floatValue = aVar.f١٩١٢٣h.floatValue();
            Path path2 = this.f١٦٥٠٩k;
            if (oVar3 == null) {
                path = path2;
            } else {
                path = this.f١٦٥١٠l;
            }
            return (Path) cVar.b(f11, floatValue, path2, path, f10, e(), f());
        }
        return this.f١٦٥٠٨j;
    }

    public void r(List list) {
        this.f١٦٥١١m = list;
    }
}
