package fe;

import java.util.concurrent.CountDownLatch;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class f extends CountDownLatch implements pd.g, pd.a {

    /* renamed from: a, reason: collision with root package name */
    public Throwable f١٤٢٩٩a;

    public f() {
        super(1);
    }

    @Override // pd.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(Throwable th) {
        this.f١٤٢٩٩a = th;
        countDown();
    }

    @Override // pd.a
    public void run() {
        countDown();
    }
}
