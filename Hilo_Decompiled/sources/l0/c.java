package l0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final String f١٥٦٨٥a;

    public c(String str) {
        this.f١٥٦٨٥a = str;
    }

    public abstract void a();

    public abstract void c();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f١٥٦٨٥a);
        try {
            a();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        } finally {
            Thread.currentThread().setName(name);
            c();
        }
    }
}
