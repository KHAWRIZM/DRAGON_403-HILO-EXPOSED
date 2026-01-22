package androidx.appcompat.widget;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class j0 {

    /* renamed from: a, reason: collision with root package name */
    private int f١٥٦٧a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f١٥٦٨b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f١٥٦٩c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    private int f١٥٧٠d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    private int f١٥٧١e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f١٥٧٢f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f١٥٧٣g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f١٥٧٤h = false;

    public int a() {
        if (this.f١٥٧٣g) {
            return this.f١٥٦٧a;
        }
        return this.f١٥٦٨b;
    }

    public int b() {
        return this.f١٥٦٧a;
    }

    public int c() {
        return this.f١٥٦٨b;
    }

    public int d() {
        if (this.f١٥٧٣g) {
            return this.f١٥٦٨b;
        }
        return this.f١٥٦٧a;
    }

    public void e(int i10, int i11) {
        this.f١٥٧٤h = false;
        if (i10 != Integer.MIN_VALUE) {
            this.f١٥٧١e = i10;
            this.f١٥٦٧a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f١٥٧٢f = i11;
            this.f١٥٦٨b = i11;
        }
    }

    public void f(boolean z10) {
        if (z10 == this.f١٥٧٣g) {
            return;
        }
        this.f١٥٧٣g = z10;
        if (this.f١٥٧٤h) {
            if (z10) {
                int i10 = this.f١٥٧٠d;
                if (i10 == Integer.MIN_VALUE) {
                    i10 = this.f١٥٧١e;
                }
                this.f١٥٦٧a = i10;
                int i11 = this.f١٥٦٩c;
                if (i11 == Integer.MIN_VALUE) {
                    i11 = this.f١٥٧٢f;
                }
                this.f١٥٦٨b = i11;
                return;
            }
            int i12 = this.f١٥٦٩c;
            if (i12 == Integer.MIN_VALUE) {
                i12 = this.f١٥٧١e;
            }
            this.f١٥٦٧a = i12;
            int i13 = this.f١٥٧٠d;
            if (i13 == Integer.MIN_VALUE) {
                i13 = this.f١٥٧٢f;
            }
            this.f١٥٦٨b = i13;
            return;
        }
        this.f١٥٦٧a = this.f١٥٧١e;
        this.f١٥٦٨b = this.f١٥٧٢f;
    }

    public void g(int i10, int i11) {
        this.f١٥٦٩c = i10;
        this.f١٥٧٠d = i11;
        this.f١٥٧٤h = true;
        if (this.f١٥٧٣g) {
            if (i11 != Integer.MIN_VALUE) {
                this.f١٥٦٧a = i11;
            }
            if (i10 != Integer.MIN_VALUE) {
                this.f١٥٦٨b = i10;
                return;
            }
            return;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f١٥٦٧a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f١٥٦٨b = i11;
        }
    }
}
