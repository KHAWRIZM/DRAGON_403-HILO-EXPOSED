package ce;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class i extends a implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public i(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f٦٠٢٤b = Thread.currentThread();
        try {
            this.f٦٠٢٣a.run();
            this.f٦٠٢٤b = null;
        } catch (Throwable th) {
            this.f٦٠٢٤b = null;
            dispose();
            ie.a.s(th);
            throw th;
        }
    }
}
