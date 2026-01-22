package be;

import java.util.concurrent.atomic.AtomicReference;
import sd.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class a implements i {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference f٥٦٠٧a = new AtomicReference();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference f٥٦٠٨b = new AtomicReference();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: be.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class C٠٠٧٠a extends AtomicReference {
        private static final long serialVersionUID = 2404266111789071508L;

        /* renamed from: a, reason: collision with root package name */
        private Object f٥٦٠٩a;

        C٠٠٧٠a() {
        }

        public Object a() {
            Object b10 = b();
            e(null);
            return b10;
        }

        public Object b() {
            return this.f٥٦٠٩a;
        }

        public C٠٠٧٠a c() {
            return (C٠٠٧٠a) get();
        }

        public void d(C٠٠٧٠a r12) {
            lazySet(r12);
        }

        public void e(Object obj) {
            this.f٥٦٠٩a = obj;
        }

        C٠٠٧٠a(Object obj) {
            e(obj);
        }
    }

    public a() {
        C٠٠٧٠a r02 = new C٠٠٧٠a();
        e(r02);
        f(r02);
    }

    C٠٠٧٠a b() {
        return (C٠٠٧٠a) this.f٥٦٠٨b.get();
    }

    C٠٠٧٠a c() {
        return (C٠٠٧٠a) this.f٥٦٠٨b.get();
    }

    @Override // sd.j
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    C٠٠٧٠a d() {
        return (C٠٠٧٠a) this.f٥٦٠٧a.get();
    }

    void e(C٠٠٧٠a r22) {
        this.f٥٦٠٨b.lazySet(r22);
    }

    C٠٠٧٠a f(C٠٠٧٠a r22) {
        return (C٠٠٧٠a) this.f٥٦٠٧a.getAndSet(r22);
    }

    @Override // sd.j
    public boolean isEmpty() {
        if (c() == d()) {
            return true;
        }
        return false;
    }

    @Override // sd.j
    public boolean offer(Object obj) {
        if (obj != null) {
            C٠٠٧٠a r02 = new C٠٠٧٠a(obj);
            f(r02).d(r02);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // sd.i, sd.j
    public Object poll() {
        C٠٠٧٠a c10;
        C٠٠٧٠a b10 = b();
        C٠٠٧٠a c11 = b10.c();
        if (c11 != null) {
            Object a10 = c11.a();
            e(c11);
            return a10;
        }
        if (b10 == d()) {
            return null;
        }
        do {
            c10 = b10.c();
        } while (c10 == null);
        Object a11 = c10.a();
        e(c10);
        return a11;
    }
}
