package de;

import fe.j;
import io.reactivex.rxjava3.core.i;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class c extends CountDownLatch implements i {

    /* renamed from: a, reason: collision with root package name */
    Object f١٣٧٠٣a;

    /* renamed from: b, reason: collision with root package name */
    Throwable f١٣٧٠٤b;

    /* renamed from: c, reason: collision with root package name */
    kf.c f١٣٧٠٥c;

    /* renamed from: d, reason: collision with root package name */
    volatile boolean f١٣٧٠٦d;

    public c() {
        super(1);
    }

    public final Object a() {
        if (getCount() != 0) {
            try {
                fe.e.b();
                await();
            } catch (InterruptedException e10) {
                kf.c cVar = this.f١٣٧٠٥c;
                this.f١٣٧٠٥c = ee.c.CANCELLED;
                if (cVar != null) {
                    cVar.cancel();
                }
                throw j.g(e10);
            }
        }
        Throwable th = this.f١٣٧٠٤b;
        if (th == null) {
            return this.f١٣٧٠٣a;
        }
        throw j.g(th);
    }

    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.i
    public final void onSubscribe(kf.c cVar) {
        if (ee.c.h(this.f١٣٧٠٥c, cVar)) {
            this.f١٣٧٠٥c = cVar;
            if (!this.f١٣٧٠٦d) {
                cVar.request(LongCompanionObject.MAX_VALUE);
                if (this.f١٣٧٠٦d) {
                    this.f١٣٧٠٥c = ee.c.CANCELLED;
                    cVar.cancel();
                }
            }
        }
    }
}
