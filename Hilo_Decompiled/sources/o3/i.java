package o3;

import android.graphics.Path;
import android.graphics.PointF;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class i extends y3.a {

    /* renamed from: q, reason: collision with root package name */
    private Path f١٦٤٩٨q;

    /* renamed from: r, reason: collision with root package name */
    private final y3.a f١٦٤٩٩r;

    public i(com.airbnb.lottie.j jVar, y3.a aVar) {
        super(jVar, (PointF) aVar.f١٩١١٧b, (PointF) aVar.f١٩١١٨c, aVar.f١٩١١٩d, aVar.f١٩١٢٠e, aVar.f١٩١٢١f, aVar.f١٩١٢٢g, aVar.f١٩١٢٣h);
        this.f١٦٤٩٩r = aVar;
        j();
    }

    public void j() {
        boolean z10;
        Object obj;
        Object obj2;
        Object obj3 = this.f١٩١١٨c;
        if (obj3 != null && (obj2 = this.f١٩١١٧b) != null && ((PointF) obj2).equals(((PointF) obj3).x, ((PointF) obj3).y)) {
            z10 = true;
        } else {
            z10 = false;
        }
        Object obj4 = this.f١٩١١٧b;
        if (obj4 != null && (obj = this.f١٩١١٨c) != null && !z10) {
            y3.a aVar = this.f١٦٤٩٩r;
            this.f١٦٤٩٨q = x3.l.d((PointF) obj4, (PointF) obj, aVar.f١٩١٣٠o, aVar.f١٩١٣١p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path k() {
        return this.f١٦٤٩٨q;
    }
}
