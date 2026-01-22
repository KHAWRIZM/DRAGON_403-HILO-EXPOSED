package o4;

import androidx.core.util.Pools;
import g5.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class u implements v, a.f {

    /* renamed from: e, reason: collision with root package name */
    private static final Pools.Pool f١٦٧٣١e = g5.a.d(20, new a());

    /* renamed from: a, reason: collision with root package name */
    private final g5.c f١٦٧٣٢a = g5.c.a();

    /* renamed from: b, reason: collision with root package name */
    private v f١٦٧٣٣b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f١٦٧٣٤c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f١٦٧٣٥d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements a.d {
        a() {
        }

        @Override // g5.a.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public u a() {
            return new u();
        }
    }

    u() {
    }

    private void b(v vVar) {
        this.f١٦٧٣٥d = false;
        this.f١٦٧٣٤c = true;
        this.f١٦٧٣٣b = vVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static u c(v vVar) {
        u uVar = (u) f5.k.d((u) f١٦٧٣١e.acquire());
        uVar.b(vVar);
        return uVar;
    }

    private void d() {
        this.f١٦٧٣٣b = null;
        f١٦٧٣١e.release(this);
    }

    @Override // g5.a.f
    public g5.c a() {
        return this.f١٦٧٣٢a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void e() {
        this.f١٦٧٣٢a.c();
        if (this.f١٦٧٣٤c) {
            this.f١٦٧٣٤c = false;
            if (this.f١٦٧٣٥d) {
                recycle();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    @Override // o4.v
    public Object get() {
        return this.f١٦٧٣٣b.get();
    }

    @Override // o4.v
    public Class getResourceClass() {
        return this.f١٦٧٣٣b.getResourceClass();
    }

    @Override // o4.v
    public int getSize() {
        return this.f١٦٧٣٣b.getSize();
    }

    @Override // o4.v
    public synchronized void recycle() {
        this.f١٦٧٣٢a.c();
        this.f١٦٧٣٥d = true;
        if (!this.f١٦٧٣٤c) {
            this.f١٦٧٣٣b.recycle();
            d();
        }
    }
}
