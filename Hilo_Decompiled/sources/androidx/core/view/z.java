package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f٣٠٥٦a;

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f٣٠٥٧b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final Map f٣٠٥٨c = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final Lifecycle f٣٠٥٩a;

        /* renamed from: b, reason: collision with root package name */
        private LifecycleEventObserver f٣٠٦٠b;

        a(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
            this.f٣٠٥٩a = lifecycle;
            this.f٣٠٦٠b = lifecycleEventObserver;
            lifecycle.addObserver(lifecycleEventObserver);
        }

        void a() {
            this.f٣٠٥٩a.removeObserver(this.f٣٠٦٠b);
            this.f٣٠٦٠b = null;
        }
    }

    public z(Runnable runnable) {
        this.f٣٠٥٦a = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(b0 b0Var, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            l(b0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Lifecycle.State state, b0 b0Var, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.upTo(state)) {
            c(b0Var);
            return;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            l(b0Var);
        } else if (event == Lifecycle.Event.downFrom(state)) {
            this.f٣٠٥٧b.remove(b0Var);
            this.f٣٠٥٦a.run();
        }
    }

    public void c(b0 b0Var) {
        this.f٣٠٥٧b.add(b0Var);
        this.f٣٠٥٦a.run();
    }

    public void d(final b0 b0Var, LifecycleOwner lifecycleOwner) {
        c(b0Var);
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        a aVar = (a) this.f٣٠٥٨c.remove(b0Var);
        if (aVar != null) {
            aVar.a();
        }
        this.f٣٠٥٨c.put(b0Var, new a(lifecycle, new LifecycleEventObserver() { // from class: androidx.core.view.y
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                z.this.f(b0Var, lifecycleOwner2, event);
            }
        }));
    }

    public void e(final b0 b0Var, LifecycleOwner lifecycleOwner, final Lifecycle.State state) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        a aVar = (a) this.f٣٠٥٨c.remove(b0Var);
        if (aVar != null) {
            aVar.a();
        }
        this.f٣٠٥٨c.put(b0Var, new a(lifecycle, new LifecycleEventObserver() { // from class: androidx.core.view.x
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                z.this.g(state, b0Var, lifecycleOwner2, event);
            }
        }));
    }

    public void h(Menu menu, MenuInflater menuInflater) {
        Iterator it = this.f٣٠٥٧b.iterator();
        while (it.hasNext()) {
            ((b0) it.next()).onCreateMenu(menu, menuInflater);
        }
    }

    public void i(Menu menu) {
        Iterator it = this.f٣٠٥٧b.iterator();
        while (it.hasNext()) {
            ((b0) it.next()).onMenuClosed(menu);
        }
    }

    public boolean j(MenuItem menuItem) {
        Iterator it = this.f٣٠٥٧b.iterator();
        while (it.hasNext()) {
            if (((b0) it.next()).onMenuItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void k(Menu menu) {
        Iterator it = this.f٣٠٥٧b.iterator();
        while (it.hasNext()) {
            ((b0) it.next()).onPrepareMenu(menu);
        }
    }

    public void l(b0 b0Var) {
        this.f٣٠٥٧b.remove(b0Var);
        a aVar = (a) this.f٣٠٥٨c.remove(b0Var);
        if (aVar != null) {
            aVar.a();
        }
        this.f٣٠٥٦a.run();
    }
}
