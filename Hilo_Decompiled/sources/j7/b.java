package j7;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b extends k {

    /* renamed from: a, reason: collision with root package name */
    private final long f١٥٢٦٩a;

    /* renamed from: b, reason: collision with root package name */
    private final b7.p f١٥٢٧٠b;

    /* renamed from: c, reason: collision with root package name */
    private final b7.i f١٥٢٧١c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(long j10, b7.p pVar, b7.i iVar) {
        this.f١٥٢٦٩a = j10;
        if (pVar != null) {
            this.f١٥٢٧٠b = pVar;
            if (iVar != null) {
                this.f١٥٢٧١c = iVar;
                return;
            }
            throw new NullPointerException("Null event");
        }
        throw new NullPointerException("Null transportContext");
    }

    @Override // j7.k
    public b7.i b() {
        return this.f١٥٢٧١c;
    }

    @Override // j7.k
    public long c() {
        return this.f١٥٢٦٩a;
    }

    @Override // j7.k
    public b7.p d() {
        return this.f١٥٢٧٠b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (this.f١٥٢٦٩a == kVar.c() && this.f١٥٢٧٠b.equals(kVar.d()) && this.f١٥٢٧١c.equals(kVar.b())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f١٥٢٦٩a;
        return this.f١٥٢٧١c.hashCode() ^ ((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f١٥٢٧٠b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f١٥٢٦٩a + ", transportContext=" + this.f١٥٢٧٠b + ", event=" + this.f١٥٢٧١c + "}";
    }
}
