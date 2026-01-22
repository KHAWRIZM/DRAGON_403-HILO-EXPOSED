package de;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class d extends c {
    public void onError(Throwable th) {
        if (this.f١٣٧٠٣a == null) {
            this.f١٣٧٠٤b = th;
        } else {
            ie.a.s(th);
        }
        countDown();
    }

    public void onNext(Object obj) {
        if (this.f١٣٧٠٣a == null) {
            this.f١٣٧٠٣a = obj;
            this.f١٣٧٠٥c.cancel();
            countDown();
        }
    }
}
