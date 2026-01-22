package androidx.transition;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.b;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.transition.k;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f extends FragmentTransitionImpl {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a extends k.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f٤٢٧٣a;

        a(Rect rect) {
            this.f٤٢٧٣a = rect;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b implements k.i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f٤٢٧٥a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f٤٢٧٦b;

        b(View view, ArrayList arrayList) {
            this.f٤٢٧٥a = view;
            this.f٤٢٧٦b = arrayList;
        }

        @Override // androidx.transition.k.i
        public void b(k kVar) {
        }

        @Override // androidx.transition.k.i
        public void d(k kVar) {
            kVar.c0(this);
            kVar.c(this);
        }

        @Override // androidx.transition.k.i
        public void e(k kVar) {
        }

        @Override // androidx.transition.k.i
        public /* synthetic */ void g(k kVar, boolean z10) {
            o.a(this, kVar, z10);
        }

        @Override // androidx.transition.k.i
        public void i(k kVar) {
            kVar.c0(this);
            this.f٤٢٧٥a.setVisibility(8);
            int size = this.f٤٢٧٦b.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((View) this.f٤٢٧٦b.get(i10)).setVisibility(0);
            }
        }

        @Override // androidx.transition.k.i
        public void k(k kVar) {
        }

        @Override // androidx.transition.k.i
        public /* synthetic */ void l(k kVar, boolean z10) {
            o.b(this, kVar, z10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class c extends w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f٤٢٧٨a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f٤٢٧٩b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f٤٢٨٠c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f٤٢٨١d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f٤٢٨٢e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f٤٢٨٣f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f٤٢٧٨a = obj;
            this.f٤٢٧٩b = arrayList;
            this.f٤٢٨٠c = obj2;
            this.f٤٢٨١d = arrayList2;
            this.f٤٢٨٢e = obj3;
            this.f٤٢٨٣f = arrayList3;
        }

        @Override // androidx.transition.w, androidx.transition.k.i
        public void d(k kVar) {
            Object obj = this.f٤٢٧٨a;
            if (obj != null) {
                f.this.replaceTargets(obj, this.f٤٢٧٩b, null);
            }
            Object obj2 = this.f٤٢٨٠c;
            if (obj2 != null) {
                f.this.replaceTargets(obj2, this.f٤٢٨١d, null);
            }
            Object obj3 = this.f٤٢٨٢e;
            if (obj3 != null) {
                f.this.replaceTargets(obj3, this.f٤٢٨٣f, null);
            }
        }

        @Override // androidx.transition.w, androidx.transition.k.i
        public void i(k kVar) {
            kVar.c0(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class d implements k.i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f٤٢٨٥a;

        d(Runnable runnable) {
            this.f٤٢٨٥a = runnable;
        }

        @Override // androidx.transition.k.i
        public void b(k kVar) {
        }

        @Override // androidx.transition.k.i
        public void d(k kVar) {
        }

        @Override // androidx.transition.k.i
        public void e(k kVar) {
        }

        @Override // androidx.transition.k.i
        public /* synthetic */ void g(k kVar, boolean z10) {
            o.a(this, kVar, z10);
        }

        @Override // androidx.transition.k.i
        public void i(k kVar) {
            this.f٤٢٨٥a.run();
        }

        @Override // androidx.transition.k.i
        public void k(k kVar) {
        }

        @Override // androidx.transition.k.i
        public /* synthetic */ void l(k kVar, boolean z10) {
            o.b(this, kVar, z10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class e extends k.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f٤٢٨٧a;

        e(Rect rect) {
            this.f٤٢٨٧a = rect;
        }
    }

    private static boolean b(k kVar) {
        if (FragmentTransitionImpl.isNullOrEmpty(kVar.G()) && FragmentTransitionImpl.isNullOrEmpty(kVar.H()) && FragmentTransitionImpl.isNullOrEmpty(kVar.I())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Runnable runnable, k kVar, Runnable runnable2) {
        if (runnable == null) {
            kVar.cancel();
            runnable2.run();
        } else {
            runnable.run();
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTarget(Object obj, View view) {
        if (obj != null) {
            ((k) obj).d(view);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTargets(Object obj, ArrayList arrayList) {
        k kVar = (k) obj;
        if (kVar == null) {
            return;
        }
        int i10 = 0;
        if (kVar instanceof a0) {
            a0 a0Var = (a0) kVar;
            int v02 = a0Var.v0();
            while (i10 < v02) {
                addTargets(a0Var.u0(i10), arrayList);
                i10++;
            }
            return;
        }
        if (!b(kVar) && FragmentTransitionImpl.isNullOrEmpty(kVar.J())) {
            int size = arrayList.size();
            while (i10 < size) {
                kVar.d((View) arrayList.get(i10));
                i10++;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void animateToEnd(Object obj) {
        ((z) obj).a();
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void animateToStart(Object obj, Runnable runnable) {
        ((z) obj).j(runnable);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void beginDelayedTransition(ViewGroup viewGroup, Object obj) {
        x.b(viewGroup, (k) obj);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public boolean canHandle(Object obj) {
        return obj instanceof k;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object cloneTransition(Object obj) {
        if (obj != null) {
            return ((k) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object controlDelayedTransition(ViewGroup viewGroup, Object obj) {
        return x.c(viewGroup, (k) obj);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public boolean isSeekingSupported() {
        return true;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3) {
        k kVar = (k) obj;
        k kVar2 = (k) obj2;
        k kVar3 = (k) obj3;
        if (kVar != null && kVar2 != null) {
            kVar = new a0().s0(kVar).s0(kVar2).B0(1);
        } else if (kVar == null) {
            if (kVar2 != null) {
                kVar = kVar2;
            } else {
                kVar = null;
            }
        }
        if (kVar3 != null) {
            a0 a0Var = new a0();
            if (kVar != null) {
                a0Var.s0(kVar);
            }
            a0Var.s0(kVar3);
            return a0Var;
        }
        return kVar;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object mergeTransitionsTogether(Object obj, Object obj2, Object obj3) {
        a0 a0Var = new a0();
        if (obj != null) {
            a0Var.s0((k) obj);
        }
        if (obj2 != null) {
            a0Var.s0((k) obj2);
        }
        if (obj3 != null) {
            a0Var.s0((k) obj3);
        }
        return a0Var;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void removeTarget(Object obj, View view) {
        if (obj != null) {
            ((k) obj).d0(view);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void replaceTargets(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        int size;
        k kVar = (k) obj;
        int i10 = 0;
        if (kVar instanceof a0) {
            a0 a0Var = (a0) kVar;
            int v02 = a0Var.v0();
            while (i10 < v02) {
                replaceTargets(a0Var.u0(i10), arrayList, arrayList2);
                i10++;
            }
            return;
        }
        if (!b(kVar)) {
            List J = kVar.J();
            if (J.size() == arrayList.size() && J.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    size = 0;
                } else {
                    size = arrayList2.size();
                }
                while (i10 < size) {
                    kVar.d((View) arrayList2.get(i10));
                    i10++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    kVar.d0((View) arrayList.get(size2));
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleHideFragmentView(Object obj, View view, ArrayList arrayList) {
        ((k) obj).c(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleRemoveTargets(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((k) obj).c(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setCurrentPlayTime(Object obj, float f10) {
        z zVar = (z) obj;
        if (zVar.isReady()) {
            long c10 = f10 * ((float) zVar.c());
            if (c10 == 0) {
                c10 = 1;
            }
            if (c10 == zVar.c()) {
                c10 = zVar.c() - 1;
            }
            zVar.f(c10);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            getBoundsOnScreen(view, rect);
            ((k) obj).j0(new a(rect));
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setListenerForTransitionEnd(Fragment fragment, Object obj, androidx.core.os.b bVar, Runnable runnable) {
        setListenerForTransitionEnd(fragment, obj, bVar, null, runnable);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setSharedElementTargets(Object obj, View view, ArrayList arrayList) {
        a0 a0Var = (a0) obj;
        List J = a0Var.J();
        J.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            FragmentTransitionImpl.bfsAddViewChildren(J, (View) arrayList.get(i10));
        }
        J.add(view);
        arrayList.add(view);
        addTargets(a0Var, arrayList);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void swapSharedElementTargets(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        a0 a0Var = (a0) obj;
        if (a0Var != null) {
            a0Var.J().clear();
            a0Var.J().addAll(arrayList2);
            replaceTargets(a0Var, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object wrapTransitionInSet(Object obj) {
        if (obj == null) {
            return null;
        }
        a0 a0Var = new a0();
        a0Var.s0((k) obj);
        return a0Var;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public boolean isSeekingSupported(Object obj) {
        boolean O = ((k) obj).O();
        if (!O) {
            Log.v(FragmentManager.TAG, "Predictive back not available for AndroidX Transition " + obj + ". Please enable seeking support for the designated transition by overriding isSeekingSupported().");
        }
        return O;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setListenerForTransitionEnd(Fragment fragment, Object obj, androidx.core.os.b bVar, final Runnable runnable, final Runnable runnable2) {
        final k kVar = (k) obj;
        bVar.setOnCancelListener(new b.a() { // from class: androidx.transition.e
            @Override // androidx.core.os.b.a
            public final void onCancel() {
                f.c(runnable, kVar, runnable2);
            }
        });
        kVar.c(new d(runnable2));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(Object obj, Rect rect) {
        if (obj != null) {
            ((k) obj).j0(new e(rect));
        }
    }
}
