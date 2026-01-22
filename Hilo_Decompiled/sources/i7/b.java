package i7;

import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class b extends f {

    /* renamed from: a, reason: collision with root package name */
    private final l7.a f١٤٦١٤a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f١٤٦١٥b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(l7.a aVar, Map map) {
        if (aVar != null) {
            this.f١٤٦١٤a = aVar;
            if (map != null) {
                this.f١٤٦١٥b = map;
                return;
            }
            throw new NullPointerException("Null values");
        }
        throw new NullPointerException("Null clock");
    }

    @Override // i7.f
    l7.a e() {
        return this.f١٤٦١٤a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f١٤٦١٤a.equals(fVar.e()) && this.f١٤٦١٥b.equals(fVar.h())) {
            return true;
        }
        return false;
    }

    @Override // i7.f
    Map h() {
        return this.f١٤٦١٥b;
    }

    public int hashCode() {
        return ((this.f١٤٦١٤a.hashCode() ^ 1000003) * 1000003) ^ this.f١٤٦١٥b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f١٤٦١٤a + ", values=" + this.f١٤٦١٥b + "}";
    }
}
