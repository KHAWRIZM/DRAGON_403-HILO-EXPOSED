package o3;

import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final List f١٦٤٩٥a;

    /* renamed from: b, reason: collision with root package name */
    private final List f١٦٤٩٦b;

    /* renamed from: c, reason: collision with root package name */
    private final List f١٦٤٩٧c;

    public h(List list) {
        this.f١٦٤٩٧c = list;
        this.f١٦٤٩٥a = new ArrayList(list.size());
        this.f١٦٤٩٦b = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            this.f١٦٤٩٥a.add(((s3.i) list.get(i10)).b().a());
            this.f١٦٤٩٦b.add(((s3.i) list.get(i10)).c().a());
        }
    }

    public List a() {
        return this.f١٦٤٩٥a;
    }

    public List b() {
        return this.f١٦٤٩٧c;
    }

    public List c() {
        return this.f١٦٤٩٦b;
    }
}
