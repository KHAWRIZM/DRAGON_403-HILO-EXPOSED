package b7;

import java.util.concurrent.Executor;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class n implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f٥٥٢٥a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f٥٥٢٦a;

        a(Runnable runnable) {
            this.f٥٥٢٦a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f٥٥٢٦a.run();
            } catch (Exception e10) {
                f7.a.d("Executor", "Background execution failure.", e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Executor executor) {
        this.f٥٥٢٥a = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f٥٥٢٥a.execute(new a(runnable));
    }
}
