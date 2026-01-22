package r3;

import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class i implements m {

    /* renamed from: a, reason: collision with root package name */
    private final b f١٧٣٢٣a;

    /* renamed from: b, reason: collision with root package name */
    private final b f١٧٣٢٤b;

    public i(b bVar, b bVar2) {
        this.f١٧٣٢٣a = bVar;
        this.f١٧٣٢٤b = bVar2;
    }

    @Override // r3.m
    public o3.a a() {
        return new o3.n(this.f١٧٣٢٣a.a(), this.f١٧٣٢٤b.a());
    }

    @Override // r3.m
    public List b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // r3.m
    public boolean isStatic() {
        if (this.f١٧٣٢٣a.isStatic() && this.f١٧٣٢٤b.isStatic()) {
            return true;
        }
        return false;
    }
}
