package c7;

import c7.f;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class a extends f {

    /* renamed from: a, reason: collision with root package name */
    private final Iterable f٥٩٣٠a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f٥٩٣١b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static final class b extends f.a {

        /* renamed from: a, reason: collision with root package name */
        private Iterable f٥٩٣٢a;

        /* renamed from: b, reason: collision with root package name */
        private byte[] f٥٩٣٣b;

        @Override // c7.f.a
        public f a() {
            String str = "";
            if (this.f٥٩٣٢a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new a(this.f٥٩٣٢a, this.f٥٩٣٣b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // c7.f.a
        public f.a b(Iterable iterable) {
            if (iterable != null) {
                this.f٥٩٣٢a = iterable;
                return this;
            }
            throw new NullPointerException("Null events");
        }

        @Override // c7.f.a
        public f.a c(byte[] bArr) {
            this.f٥٩٣٣b = bArr;
            return this;
        }
    }

    @Override // c7.f
    public Iterable b() {
        return this.f٥٩٣٠a;
    }

    @Override // c7.f
    public byte[] c() {
        return this.f٥٩٣١b;
    }

    public boolean equals(Object obj) {
        byte[] c10;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f٥٩٣٠a.equals(fVar.b())) {
            byte[] bArr = this.f٥٩٣١b;
            if (fVar instanceof a) {
                c10 = ((a) fVar).f٥٩٣١b;
            } else {
                c10 = fVar.c();
            }
            if (Arrays.equals(bArr, c10)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f٥٩٣٠a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f٥٩٣١b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f٥٩٣٠a + ", extras=" + Arrays.toString(this.f٥٩٣١b) + "}";
    }

    private a(Iterable iterable, byte[] bArr) {
        this.f٥٩٣٠a = iterable;
        this.f٥٩٣١b = bArr;
    }
}
