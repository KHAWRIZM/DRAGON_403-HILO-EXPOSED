package c5;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface e {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public enum a {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);


        /* renamed from: a, reason: collision with root package name */
        private final boolean f٥٨٧٣a;

        a(boolean z10) {
            this.f٥٨٧٣a = z10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean c() {
            return this.f٥٨٧٣a;
        }
    }

    boolean a();

    boolean b(d dVar);

    boolean c(d dVar);

    void d(d dVar);

    e getRoot();

    void h(d dVar);

    boolean i(d dVar);
}
