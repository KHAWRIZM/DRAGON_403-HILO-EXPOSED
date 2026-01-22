package a7;

import a7.q;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class g extends q {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f٣١٤a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f٣١٥b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static final class b extends q.a {

        /* renamed from: a, reason: collision with root package name */
        private byte[] f٣١٦a;

        /* renamed from: b, reason: collision with root package name */
        private byte[] f٣١٧b;

        @Override // a7.q.a
        public q a() {
            return new g(this.f٣١٦a, this.f٣١٧b);
        }

        @Override // a7.q.a
        public q.a b(byte[] bArr) {
            this.f٣١٦a = bArr;
            return this;
        }

        @Override // a7.q.a
        public q.a c(byte[] bArr) {
            this.f٣١٧b = bArr;
            return this;
        }
    }

    @Override // a7.q
    public byte[] b() {
        return this.f٣١٤a;
    }

    @Override // a7.q
    public byte[] c() {
        return this.f٣١٥b;
    }

    public boolean equals(Object obj) {
        byte[] b10;
        byte[] c10;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        byte[] bArr = this.f٣١٤a;
        boolean z10 = qVar instanceof g;
        if (z10) {
            b10 = ((g) qVar).f٣١٤a;
        } else {
            b10 = qVar.b();
        }
        if (Arrays.equals(bArr, b10)) {
            byte[] bArr2 = this.f٣١٥b;
            if (z10) {
                c10 = ((g) qVar).f٣١٥b;
            } else {
                c10 = qVar.c();
            }
            if (Arrays.equals(bArr2, c10)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.f٣١٤a) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f٣١٥b);
    }

    public String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.f٣١٤a) + ", encryptedBlob=" + Arrays.toString(this.f٣١٥b) + "}";
    }

    private g(byte[] bArr, byte[] bArr2) {
        this.f٣١٤a = bArr;
        this.f٣١٥b = bArr2;
    }
}
