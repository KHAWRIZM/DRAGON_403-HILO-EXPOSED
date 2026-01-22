package z6;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class a extends d {

    /* renamed from: a, reason: collision with root package name */
    private final Integer f١٩٤٩٢a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f١٩٤٩٣b;

    /* renamed from: c, reason: collision with root package name */
    private final f f١٩٤٩٤c;

    /* renamed from: d, reason: collision with root package name */
    private final g f١٩٤٩٥d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Integer num, Object obj, f fVar, g gVar, e eVar) {
        this.f١٩٤٩٢a = num;
        if (obj != null) {
            this.f١٩٤٩٣b = obj;
            if (fVar != null) {
                this.f١٩٤٩٤c = fVar;
                this.f١٩٤٩٥d = gVar;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    @Override // z6.d
    public Integer a() {
        return this.f١٩٤٩٢a;
    }

    @Override // z6.d
    public e b() {
        return null;
    }

    @Override // z6.d
    public Object c() {
        return this.f١٩٤٩٣b;
    }

    @Override // z6.d
    public f d() {
        return this.f١٩٤٩٤c;
    }

    @Override // z6.d
    public g e() {
        return this.f١٩٤٩٥d;
    }

    public boolean equals(Object obj) {
        g gVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        Integer num = this.f١٩٤٩٢a;
        if (num != null ? num.equals(dVar.a()) : dVar.a() == null) {
            if (this.f١٩٤٩٣b.equals(dVar.c()) && this.f١٩٤٩٤c.equals(dVar.d()) && ((gVar = this.f١٩٤٩٥d) != null ? gVar.equals(dVar.e()) : dVar.e() == null)) {
                dVar.b();
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        Integer num = this.f١٩٤٩٢a;
        int i10 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int hashCode2 = (((((hashCode ^ 1000003) * 1000003) ^ this.f١٩٤٩٣b.hashCode()) * 1000003) ^ this.f١٩٤٩٤c.hashCode()) * 1000003;
        g gVar = this.f١٩٤٩٥d;
        if (gVar != null) {
            i10 = gVar.hashCode();
        }
        return (hashCode2 ^ i10) * 1000003;
    }

    public String toString() {
        return "Event{code=" + this.f١٩٤٩٢a + ", payload=" + this.f١٩٤٩٣b + ", priority=" + this.f١٩٤٩٤c + ", productData=" + this.f١٩٤٩٥d + ", eventContext=" + ((Object) null) + "}";
    }
}
