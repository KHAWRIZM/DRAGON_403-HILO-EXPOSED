package g5;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class c {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class b extends c {

        /* renamed from: a, reason: collision with root package name */
        private volatile boolean f١٤٤٢٩a;

        b() {
            super();
        }

        @Override // g5.c
        public void b(boolean z10) {
            this.f١٤٤٢٩a = z10;
        }

        @Override // g5.c
        public void c() {
            if (!this.f١٤٤٢٩a) {
            } else {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public static c a() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(boolean z10);

    public abstract void c();

    private c() {
    }
}
