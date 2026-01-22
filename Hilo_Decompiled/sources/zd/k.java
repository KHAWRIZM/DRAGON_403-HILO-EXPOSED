package zd;

import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class k {
    public static void a(io.reactivex.rxjava3.core.e0 e0Var) {
        fe.f fVar = new fe.f();
        ud.q qVar = new ud.q(rd.a.g(), fVar, fVar, rd.a.g());
        e0Var.subscribe(qVar);
        fe.e.a(fVar, qVar);
        Throwable th = fVar.f١٤٢٩٩a;
        if (th == null) {
        } else {
            throw fe.j.g(th);
        }
    }

    public static void b(io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.g0 g0Var) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        ud.h hVar = new ud.h(linkedBlockingQueue);
        g0Var.onSubscribe(hVar);
        e0Var.subscribe(hVar);
        while (!hVar.isDisposed()) {
            Object poll = linkedBlockingQueue.poll();
            if (poll == null) {
                try {
                    poll = linkedBlockingQueue.take();
                } catch (InterruptedException e10) {
                    hVar.dispose();
                    g0Var.onError(e10);
                    return;
                }
            }
            if (hVar.isDisposed() || poll == ud.h.f١٨٢٩٥b || fe.m.c(poll, g0Var)) {
                return;
            }
        }
    }

    public static void c(io.reactivex.rxjava3.core.e0 e0Var, pd.g gVar, pd.g gVar2, pd.a aVar) {
        Objects.requireNonNull(gVar, "onNext is null");
        Objects.requireNonNull(gVar2, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        b(e0Var, new ud.q(gVar, gVar2, aVar, rd.a.g()));
    }
}
