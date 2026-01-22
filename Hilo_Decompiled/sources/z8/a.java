package z8;

import com.amazonaws.services.s3.internal.Constants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class a {

    /* renamed from: h, reason: collision with root package name */
    public static final a f١٩٥٠٢h = new a(4201, 4096, 1);

    /* renamed from: i, reason: collision with root package name */
    public static final a f١٩٥٠٣i = new a(1033, 1024, 1);

    /* renamed from: j, reason: collision with root package name */
    public static final a f١٩٥٠٤j;

    /* renamed from: k, reason: collision with root package name */
    public static final a f١٩٥٠٥k;

    /* renamed from: l, reason: collision with root package name */
    public static final a f١٩٥٠٦l;

    /* renamed from: m, reason: collision with root package name */
    public static final a f١٩٥٠٧m;

    /* renamed from: n, reason: collision with root package name */
    public static final a f١٩٥٠٨n;

    /* renamed from: o, reason: collision with root package name */
    public static final a f١٩٥٠٩o;

    /* renamed from: a, reason: collision with root package name */
    private final int[] f١٩٥١٠a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f١٩٥١١b;

    /* renamed from: c, reason: collision with root package name */
    private final b f١٩٥١٢c;

    /* renamed from: d, reason: collision with root package name */
    private final b f١٩٥١٣d;

    /* renamed from: e, reason: collision with root package name */
    private final int f١٩٥١٤e;

    /* renamed from: f, reason: collision with root package name */
    private final int f١٩٥١٥f;

    /* renamed from: g, reason: collision with root package name */
    private final int f١٩٥١٦g;

    static {
        a aVar = new a(67, 64, 1);
        f١٩٥٠٤j = aVar;
        f١٩٥٠٥k = new a(19, 16, 1);
        f١٩٥٠٦l = new a(285, 256, 0);
        a aVar2 = new a(Constants.BUCKET_REDIRECT_STATUS_CODE, 256, 1);
        f١٩٥٠٧m = aVar2;
        f١٩٥٠٨n = aVar2;
        f١٩٥٠٩o = aVar;
    }

    public a(int i10, int i11, int i12) {
        this.f١٩٥١٥f = i10;
        this.f١٩٥١٤e = i11;
        this.f١٩٥١٦g = i12;
        this.f١٩٥١٠a = new int[i11];
        this.f١٩٥١١b = new int[i11];
        int i13 = 1;
        for (int i14 = 0; i14 < i11; i14++) {
            this.f١٩٥١٠a[i14] = i13;
            i13 <<= 1;
            if (i13 >= i11) {
                i13 = (i13 ^ i10) & (i11 - 1);
            }
        }
        for (int i15 = 0; i15 < i11 - 1; i15++) {
            this.f١٩٥١١b[this.f١٩٥١٠a[i15]] = i15;
        }
        this.f١٩٥١٢c = new b(this, new int[]{0});
        this.f١٩٥١٣d = new b(this, new int[]{1});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i10, int i11) {
        return i10 ^ i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b b(int i10, int i11) {
        if (i10 >= 0) {
            if (i11 == 0) {
                return this.f١٩٥١٢c;
            }
            int[] iArr = new int[i10 + 1];
            iArr[0] = i11;
            return new b(this, iArr);
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i10) {
        return this.f١٩٥١٠a[i10];
    }

    public int d() {
        return this.f١٩٥١٦g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b e() {
        return this.f١٩٥١٢c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f(int i10) {
        if (i10 != 0) {
            return this.f١٩٥١٠a[(this.f١٩٥١٤e - this.f١٩٥١١b[i10]) - 1];
        }
        throw new ArithmeticException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g(int i10) {
        if (i10 != 0) {
            return this.f١٩٥١١b[i10];
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(int i10, int i11) {
        if (i10 != 0 && i11 != 0) {
            int[] iArr = this.f١٩٥١٠a;
            int[] iArr2 = this.f١٩٥١١b;
            return iArr[(iArr2[i10] + iArr2[i11]) % (this.f١٩٥١٤e - 1)];
        }
        return 0;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f١٩٥١٥f) + ',' + this.f١٩٥١٤e + ')';
    }
}
