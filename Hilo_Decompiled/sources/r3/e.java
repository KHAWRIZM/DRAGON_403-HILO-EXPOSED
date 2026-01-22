package r3;

import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class e implements m {

    /* renamed from: a, reason: collision with root package name */
    private final List f١٧٣٢٢a;

    public e(List list) {
        this.f١٧٣٢٢a = list;
    }

    @Override // r3.m
    public o3.a a() {
        if (((y3.a) this.f١٧٣٢٢a.get(0)).i()) {
            return new o3.k(this.f١٧٣٢٢a);
        }
        return new o3.j(this.f١٧٣٢٢a);
    }

    @Override // r3.m
    public List b() {
        return this.f١٧٣٢٢a;
    }

    @Override // r3.m
    public boolean isStatic() {
        if (this.f١٧٣٢٢a.size() != 1 || !((y3.a) this.f١٧٣٢٢a.get(0)).i()) {
            return false;
        }
        return true;
    }
}
