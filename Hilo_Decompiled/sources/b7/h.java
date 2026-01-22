package b7;

import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private final z6.c f٥٥٢١a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f٥٥٢٢b;

    public h(z6.c cVar, byte[] bArr) {
        if (cVar != null) {
            if (bArr != null) {
                this.f٥٥٢١a = cVar;
                this.f٥٥٢٢b = bArr;
                return;
            }
            throw new NullPointerException("bytes is null");
        }
        throw new NullPointerException("encoding is null");
    }

    public byte[] a() {
        return this.f٥٥٢٢b;
    }

    public z6.c b() {
        return this.f٥٥٢١a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (!this.f٥٥٢١a.equals(hVar.f٥٥٢١a)) {
            return false;
        }
        return Arrays.equals(this.f٥٥٢٢b, hVar.f٥٥٢٢b);
    }

    public int hashCode() {
        return ((this.f٥٥٢١a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f٥٥٢٢b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f٥٥٢١a + ", bytes=[...]}";
    }
}
