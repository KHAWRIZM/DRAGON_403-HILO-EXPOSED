package androidx.transition;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    private static k f٤٣٧٠a = new androidx.transition.a();

    /* renamed from: b, reason: collision with root package name */
    private static ThreadLocal f٤٣٧١b = new ThreadLocal();

    /* renamed from: c, reason: collision with root package name */
    static ArrayList f٤٣٧٢c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        k f٤٣٧٣a;

        /* renamed from: b, reason: collision with root package name */
        ViewGroup f٤٣٧٤b;

        /* renamed from: androidx.transition.x$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class C٠٠٥٧a extends w {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ androidx.collection.a f٤٣٧٥a;

            C٠٠٥٧a(androidx.collection.a aVar) {
                this.f٤٣٧٥a = aVar;
            }

            @Override // androidx.transition.w, androidx.transition.k.i
            public void i(k kVar) {
                ((ArrayList) this.f٤٣٧٥a.get(a.this.f٤٣٧٤b)).remove(kVar);
                kVar.c0(this);
            }
        }

        a(k kVar, ViewGroup viewGroup) {
            this.f٤٣٧٣a = kVar;
            this.f٤٣٧٤b = viewGroup;
        }

        private void a() {
            this.f٤٣٧٤b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f٤٣٧٤b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!x.f٤٣٧٢c.remove(this.f٤٣٧٤b)) {
                return true;
            }
            androidx.collection.a d10 = x.d();
            ArrayList arrayList = (ArrayList) d10.get(this.f٤٣٧٤b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                d10.put(this.f٤٣٧٤b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f٤٣٧٣a);
            this.f٤٣٧٣a.c(new C٠٠٥٧a(d10));
            this.f٤٣٧٣a.l(this.f٤٣٧٤b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((k) it.next()).e0(this.f٤٣٧٤b);
                }
            }
            this.f٤٣٧٣a.a0(this.f٤٣٧٤b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            x.f٤٣٧٢c.remove(this.f٤٣٧٤b);
            ArrayList arrayList = (ArrayList) x.d().get(this.f٤٣٧٤b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((k) it.next()).e0(this.f٤٣٧٤b);
                }
            }
            this.f٤٣٧٣a.m(true);
        }
    }

    public static void a(ViewGroup viewGroup) {
        b(viewGroup, null);
    }

    public static void b(ViewGroup viewGroup, k kVar) {
        if (!f٤٣٧٢c.contains(viewGroup) && viewGroup.isLaidOut()) {
            f٤٣٧٢c.add(viewGroup);
            if (kVar == null) {
                kVar = f٤٣٧٠a;
            }
            k clone = kVar.clone();
            f(viewGroup, clone);
            j.b(viewGroup, null);
            e(viewGroup, clone);
        }
    }

    public static z c(ViewGroup viewGroup, k kVar) {
        if (f٤٣٧٢c.contains(viewGroup) || !viewGroup.isLaidOut() || Build.VERSION.SDK_INT < 34) {
            return null;
        }
        if (kVar.O()) {
            f٤٣٧٢c.add(viewGroup);
            k clone = kVar.clone();
            a0 a0Var = new a0();
            a0Var.s0(clone);
            f(viewGroup, a0Var);
            j.b(viewGroup, null);
            e(viewGroup, a0Var);
            viewGroup.invalidate();
            return a0Var.q();
        }
        throw new IllegalArgumentException("The Transition must support seeking.");
    }

    static androidx.collection.a d() {
        androidx.collection.a aVar;
        WeakReference weakReference = (WeakReference) f٤٣٧١b.get();
        if (weakReference != null && (aVar = (androidx.collection.a) weakReference.get()) != null) {
            return aVar;
        }
        androidx.collection.a aVar2 = new androidx.collection.a();
        f٤٣٧١b.set(new WeakReference(aVar2));
        return aVar2;
    }

    private static void e(ViewGroup viewGroup, k kVar) {
        if (kVar != null && viewGroup != null) {
            a aVar = new a(kVar, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    private static void f(ViewGroup viewGroup, k kVar) {
        ArrayList arrayList = (ArrayList) d().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((k) it.next()).Z(viewGroup);
            }
        }
        if (kVar != null) {
            kVar.l(viewGroup, true);
        }
        j.a(viewGroup);
    }
}
