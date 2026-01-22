package z4;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class k implements j, LifecycleObserver {

    /* renamed from: a, reason: collision with root package name */
    private final Set f١٩٤٤٦a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    private final Lifecycle f١٩٤٤٧b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Lifecycle lifecycle) {
        this.f١٩٤٤٧b = lifecycle;
        lifecycle.addObserver(this);
    }

    @Override // z4.j
    public void a(l lVar) {
        this.f١٩٤٤٦a.remove(lVar);
    }

    @Override // z4.j
    public void b(l lVar) {
        this.f١٩٤٤٦a.add(lVar);
        if (this.f١٩٤٤٧b.getState() == Lifecycle.State.DESTROYED) {
            lVar.onDestroy();
        } else if (this.f١٩٤٤٧b.getState().isAtLeast(Lifecycle.State.STARTED)) {
            lVar.onStart();
        } else {
            lVar.onStop();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        Iterator it = f5.l.k(this.f١٩٤٤٦a).iterator();
        while (it.hasNext()) {
            ((l) it.next()).onDestroy();
        }
        lifecycleOwner.getLifecycle().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(LifecycleOwner lifecycleOwner) {
        Iterator it = f5.l.k(this.f١٩٤٤٦a).iterator();
        while (it.hasNext()) {
            ((l) it.next()).onStart();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(LifecycleOwner lifecycleOwner) {
        Iterator it = f5.l.k(this.f١٩٤٤٦a).iterator();
        while (it.hasNext()) {
            ((l) it.next()).onStop();
        }
    }
}
