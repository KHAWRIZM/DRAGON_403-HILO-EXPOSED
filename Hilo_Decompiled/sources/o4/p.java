package o4;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class p implements v {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f١٦٧٠٩a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f١٦٧١٠b;

    /* renamed from: c, reason: collision with root package name */
    private final v f١٦٧١١c;

    /* renamed from: d, reason: collision with root package name */
    private final a f١٦٧١٢d;

    /* renamed from: e, reason: collision with root package name */
    private final m4.f f١٦٧١٣e;

    /* renamed from: f, reason: collision with root package name */
    private int f١٦٧١٤f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f١٦٧١٥g;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    interface a {
        void c(m4.f fVar, p pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(v vVar, boolean z10, boolean z11, m4.f fVar, a aVar) {
        this.f١٦٧١١c = (v) f5.k.d(vVar);
        this.f١٦٧٠٩a = z10;
        this.f١٦٧١٠b = z11;
        this.f١٦٧١٣e = fVar;
        this.f١٦٧١٢d = (a) f5.k.d(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a() {
        if (!this.f١٦٧١٥g) {
            this.f١٦٧١٤f++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v b() {
        return this.f١٦٧١١c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f١٦٧٠٩a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        boolean z10;
        synchronized (this) {
            int i10 = this.f١٦٧١٤f;
            if (i10 > 0) {
                z10 = true;
                int i11 = i10 - 1;
                this.f١٦٧١٤f = i11;
                if (i11 != 0) {
                    z10 = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z10) {
            this.f١٦٧١٢d.c(this.f١٦٧١٣e, this);
        }
    }

    @Override // o4.v
    public Object get() {
        return this.f١٦٧١١c.get();
    }

    @Override // o4.v
    public Class getResourceClass() {
        return this.f١٦٧١١c.getResourceClass();
    }

    @Override // o4.v
    public int getSize() {
        return this.f١٦٧١١c.getSize();
    }

    @Override // o4.v
    public synchronized void recycle() {
        if (this.f١٦٧١٤f <= 0) {
            if (!this.f١٦٧١٥g) {
                this.f١٦٧١٥g = true;
                if (this.f١٦٧١٠b) {
                    this.f١٦٧١١c.recycle();
                }
            } else {
                throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f١٦٧٠٩a + ", listener=" + this.f١٦٧١٢d + ", key=" + this.f١٦٧١٣e + ", acquired=" + this.f١٦٧١٤f + ", isRecycled=" + this.f١٦٧١٥g + ", resource=" + this.f١٦٧١١c + '}';
    }
}
