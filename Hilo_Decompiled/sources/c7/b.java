package c7;

import c7.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class b extends g {

    /* renamed from: a, reason: collision with root package name */
    private final g.a f٥٩٣٤a;

    /* renamed from: b, reason: collision with root package name */
    private final long f٥٩٣٥b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(g.a aVar, long j10) {
        if (aVar != null) {
            this.f٥٩٣٤a = aVar;
            this.f٥٩٣٥b = j10;
            return;
        }
        throw new NullPointerException("Null status");
    }

    @Override // c7.g
    public long b() {
        return this.f٥٩٣٥b;
    }

    @Override // c7.g
    public g.a c() {
        return this.f٥٩٣٤a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f٥٩٣٤a.equals(gVar.c()) && this.f٥٩٣٥b == gVar.b()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.f٥٩٣٤a.hashCode() ^ 1000003) * 1000003;
        long j10 = this.f٥٩٣٥b;
        return hashCode ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f٥٩٣٤a + ", nextRequestWaitMillis=" + this.f٥٩٣٥b + "}";
    }
}
