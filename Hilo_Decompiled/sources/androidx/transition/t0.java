package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.k;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class t0 extends k {
    private static final String[] Q = {"android:visibility:visibility", "android:visibility:parent"};
    private int P = 3;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a extends AnimatorListenerAdapter implements k.i {

        /* renamed from: a, reason: collision with root package name */
        private final View f٤٣٥٣a;

        /* renamed from: b, reason: collision with root package name */
        private final int f٤٣٥٤b;

        /* renamed from: c, reason: collision with root package name */
        private final ViewGroup f٤٣٥٥c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f٤٣٥٦d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f٤٣٥٧e;

        /* renamed from: f, reason: collision with root package name */
        boolean f٤٣٥٨f = false;

        a(View view, int i10, boolean z10) {
            this.f٤٣٥٣a = view;
            this.f٤٣٥٤b = i10;
            this.f٤٣٥٥c = (ViewGroup) view.getParent();
            this.f٤٣٥٦d = z10;
            c(true);
        }

        private void a() {
            if (!this.f٤٣٥٨f) {
                g0.f(this.f٤٣٥٣a, this.f٤٣٥٤b);
                ViewGroup viewGroup = this.f٤٣٥٥c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            c(false);
        }

        private void c(boolean z10) {
            ViewGroup viewGroup;
            if (this.f٤٣٥٦d && this.f٤٣٥٧e != z10 && (viewGroup = this.f٤٣٥٥c) != null) {
                this.f٤٣٥٧e = z10;
                f0.b(viewGroup, z10);
            }
        }

        @Override // androidx.transition.k.i
        public void b(k kVar) {
            c(true);
            if (!this.f٤٣٥٨f) {
                g0.f(this.f٤٣٥٣a, 0);
            }
        }

        @Override // androidx.transition.k.i
        public void d(k kVar) {
        }

        @Override // androidx.transition.k.i
        public void e(k kVar) {
            c(false);
            if (!this.f٤٣٥٨f) {
                g0.f(this.f٤٣٥٣a, this.f٤٣٥٤b);
            }
        }

        @Override // androidx.transition.k.i
        public /* synthetic */ void g(k kVar, boolean z10) {
            o.a(this, kVar, z10);
        }

        @Override // androidx.transition.k.i
        public void i(k kVar) {
            kVar.c0(this);
        }

        @Override // androidx.transition.k.i
        public void k(k kVar) {
        }

        @Override // androidx.transition.k.i
        public /* synthetic */ void l(k kVar, boolean z10) {
            o.b(this, kVar, z10);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f٤٣٥٨f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z10) {
            if (z10) {
                return;
            }
            a();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z10) {
            if (z10) {
                g0.f(this.f٤٣٥٣a, 0);
                ViewGroup viewGroup = this.f٤٣٥٥c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b extends AnimatorListenerAdapter implements k.i {

        /* renamed from: a, reason: collision with root package name */
        private final ViewGroup f٤٣٥٩a;

        /* renamed from: b, reason: collision with root package name */
        private final View f٤٣٦٠b;

        /* renamed from: c, reason: collision with root package name */
        private final View f٤٣٦١c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f٤٣٦٢d = true;

        b(ViewGroup viewGroup, View view, View view2) {
            this.f٤٣٥٩a = viewGroup;
            this.f٤٣٦٠b = view;
            this.f٤٣٦١c = view2;
        }

        private void a() {
            this.f٤٣٦١c.setTag(R.id.save_overlay_view, null);
            this.f٤٣٥٩a.getOverlay().remove(this.f٤٣٦٠b);
            this.f٤٣٦٢d = false;
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
            kVar.c0(this);
        }

        @Override // androidx.transition.k.i
        public void k(k kVar) {
            if (this.f٤٣٦٢d) {
                a();
            }
        }

        @Override // androidx.transition.k.i
        public /* synthetic */ void l(k kVar, boolean z10) {
            o.b(this, kVar, z10);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f٤٣٥٩a.getOverlay().remove(this.f٤٣٦٠b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.f٤٣٦٠b.getParent() == null) {
                this.f٤٣٥٩a.getOverlay().add(this.f٤٣٦٠b);
            } else {
                t0.this.cancel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z10) {
            if (z10) {
                this.f٤٣٦١c.setTag(R.id.save_overlay_view, this.f٤٣٦٠b);
                this.f٤٣٥٩a.getOverlay().add(this.f٤٣٦٠b);
                this.f٤٣٦٢d = true;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z10) {
            if (z10) {
                return;
            }
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        boolean f٤٣٦٤a;

        /* renamed from: b, reason: collision with root package name */
        boolean f٤٣٦٥b;

        /* renamed from: c, reason: collision with root package name */
        int f٤٣٦٦c;

        /* renamed from: d, reason: collision with root package name */
        int f٤٣٦٧d;

        /* renamed from: e, reason: collision with root package name */
        ViewGroup f٤٣٦٨e;

        /* renamed from: f, reason: collision with root package name */
        ViewGroup f٤٣٦٩f;

        c() {
        }
    }

    private void q0(c0 c0Var) {
        c0Var.f٤٢٥٨a.put("android:visibility:visibility", Integer.valueOf(c0Var.f٤٢٥٩b.getVisibility()));
        c0Var.f٤٢٥٨a.put("android:visibility:parent", c0Var.f٤٢٥٩b.getParent());
        int[] iArr = new int[2];
        c0Var.f٤٢٥٩b.getLocationOnScreen(iArr);
        c0Var.f٤٢٥٨a.put("android:visibility:screenLocation", iArr);
    }

    private c r0(c0 c0Var, c0 c0Var2) {
        c cVar = new c();
        cVar.f٤٣٦٤a = false;
        cVar.f٤٣٦٥b = false;
        if (c0Var != null && c0Var.f٤٢٥٨a.containsKey("android:visibility:visibility")) {
            cVar.f٤٣٦٦c = ((Integer) c0Var.f٤٢٥٨a.get("android:visibility:visibility")).intValue();
            cVar.f٤٣٦٨e = (ViewGroup) c0Var.f٤٢٥٨a.get("android:visibility:parent");
        } else {
            cVar.f٤٣٦٦c = -1;
            cVar.f٤٣٦٨e = null;
        }
        if (c0Var2 != null && c0Var2.f٤٢٥٨a.containsKey("android:visibility:visibility")) {
            cVar.f٤٣٦٧d = ((Integer) c0Var2.f٤٢٥٨a.get("android:visibility:visibility")).intValue();
            cVar.f٤٣٦٩f = (ViewGroup) c0Var2.f٤٢٥٨a.get("android:visibility:parent");
        } else {
            cVar.f٤٣٦٧d = -1;
            cVar.f٤٣٦٩f = null;
        }
        if (c0Var != null && c0Var2 != null) {
            int i10 = cVar.f٤٣٦٦c;
            int i11 = cVar.f٤٣٦٧d;
            if (i10 == i11 && cVar.f٤٣٦٨e == cVar.f٤٣٦٩f) {
                return cVar;
            }
            if (i10 != i11) {
                if (i10 == 0) {
                    cVar.f٤٣٦٥b = false;
                    cVar.f٤٣٦٤a = true;
                } else if (i11 == 0) {
                    cVar.f٤٣٦٥b = true;
                    cVar.f٤٣٦٤a = true;
                }
            } else if (cVar.f٤٣٦٩f == null) {
                cVar.f٤٣٦٥b = false;
                cVar.f٤٣٦٤a = true;
            } else if (cVar.f٤٣٦٨e == null) {
                cVar.f٤٣٦٥b = true;
                cVar.f٤٣٦٤a = true;
            }
        } else if (c0Var == null && cVar.f٤٣٦٧d == 0) {
            cVar.f٤٣٦٥b = true;
            cVar.f٤٣٦٤a = true;
        } else if (c0Var2 == null && cVar.f٤٣٦٦c == 0) {
            cVar.f٤٣٦٥b = false;
            cVar.f٤٣٦٤a = true;
        }
        return cVar;
    }

    @Override // androidx.transition.k
    public String[] L() {
        return Q;
    }

    @Override // androidx.transition.k
    public boolean P(c0 c0Var, c0 c0Var2) {
        if (c0Var == null && c0Var2 == null) {
            return false;
        }
        if (c0Var != null && c0Var2 != null && c0Var2.f٤٢٥٨a.containsKey("android:visibility:visibility") != c0Var.f٤٢٥٨a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c r02 = r0(c0Var, c0Var2);
        if (!r02.f٤٣٦٤a) {
            return false;
        }
        if (r02.f٤٣٦٦c != 0 && r02.f٤٣٦٧d != 0) {
            return false;
        }
        return true;
    }

    @Override // androidx.transition.k
    public void h(c0 c0Var) {
        q0(c0Var);
    }

    @Override // androidx.transition.k
    public void k(c0 c0Var) {
        q0(c0Var);
    }

    @Override // androidx.transition.k
    public Animator o(ViewGroup viewGroup, c0 c0Var, c0 c0Var2) {
        c r02 = r0(c0Var, c0Var2);
        if (r02.f٤٣٦٤a) {
            if (r02.f٤٣٦٨e != null || r02.f٤٣٦٩f != null) {
                if (r02.f٤٣٦٥b) {
                    return t0(viewGroup, c0Var, r02.f٤٣٦٦c, c0Var2, r02.f٤٣٦٧d);
                }
                return v0(viewGroup, c0Var, r02.f٤٣٦٦c, c0Var2, r02.f٤٣٦٧d);
            }
            return null;
        }
        return null;
    }

    public abstract Animator s0(ViewGroup viewGroup, View view, c0 c0Var, c0 c0Var2);

    public Animator t0(ViewGroup viewGroup, c0 c0Var, int i10, c0 c0Var2, int i11) {
        if ((this.P & 1) != 1 || c0Var2 == null) {
            return null;
        }
        if (c0Var == null) {
            View view = (View) c0Var2.f٤٢٥٩b.getParent();
            if (r0(z(view, false), M(view, false)).f٤٣٦٤a) {
                return null;
            }
        }
        return s0(viewGroup, c0Var2.f٤٢٥٩b, c0Var, c0Var2);
    }

    public abstract Animator u0(ViewGroup viewGroup, View view, c0 c0Var, c0 c0Var2);

    /* JADX WARN: Code restructure failed: missing block: B:51:0x008f, code lost:
    
        if (r17.f٤٣٢٠w != false) goto L٤٤;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Animator v0(ViewGroup viewGroup, c0 c0Var, int i10, c0 c0Var2, int i11) {
        View view;
        View view2;
        boolean z10;
        boolean z11;
        View view3;
        if ((this.P & 2) != 2 || c0Var == null) {
            return null;
        }
        View view4 = c0Var.f٤٢٥٩b;
        if (c0Var2 != null) {
            view = c0Var2.f٤٢٥٩b;
        } else {
            view = null;
        }
        int i12 = R.id.save_overlay_view;
        View view5 = (View) view4.getTag(i12);
        if (view5 != null) {
            view3 = null;
            z11 = true;
        } else if (view != null && view.getParent() != null) {
            if (i11 == 4 || view4 == view) {
                view2 = view;
                z10 = false;
                view = null;
                if (z10) {
                }
                z11 = false;
                View view6 = view2;
                view5 = view;
                view3 = view6;
            }
            view = null;
            view2 = null;
            z10 = true;
            if (z10) {
            }
            z11 = false;
            View view62 = view2;
            view5 = view;
            view3 = view62;
        } else {
            if (view != null) {
                view2 = null;
                z10 = false;
                if (z10) {
                    if (view4.getParent() != null) {
                        if (view4.getParent() instanceof View) {
                            View view7 = (View) view4.getParent();
                            if (!r0(M(view7, true), z(view7, true)).f٤٣٦٤a) {
                                view = b0.a(viewGroup, view4, view7);
                            } else {
                                int id = view7.getId();
                                if (view7.getParent() == null) {
                                    if (id != -1) {
                                        if (viewGroup.findViewById(id) != null) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                    view3 = view2;
                    z11 = false;
                    view5 = view4;
                }
                z11 = false;
                View view622 = view2;
                view5 = view;
                view3 = view622;
            }
            view = null;
            view2 = null;
            z10 = true;
            if (z10) {
            }
            z11 = false;
            View view6222 = view2;
            view5 = view;
            view3 = view6222;
        }
        if (view5 != null) {
            if (!z11) {
                int[] iArr = (int[]) c0Var.f٤٢٥٨a.get("android:visibility:screenLocation");
                int i13 = iArr[0];
                int i14 = iArr[1];
                int[] iArr2 = new int[2];
                viewGroup.getLocationOnScreen(iArr2);
                view5.offsetLeftAndRight((i13 - iArr2[0]) - view5.getLeft());
                view5.offsetTopAndBottom((i14 - iArr2[1]) - view5.getTop());
                viewGroup.getOverlay().add(view5);
            }
            Animator u02 = u0(viewGroup, view5, c0Var, c0Var2);
            if (!z11) {
                if (u02 == null) {
                    viewGroup.getOverlay().remove(view5);
                } else {
                    view4.setTag(i12, view5);
                    b bVar = new b(viewGroup, view5, view4);
                    u02.addListener(bVar);
                    u02.addPauseListener(bVar);
                    D().c(bVar);
                }
            }
            return u02;
        }
        if (view3 == null) {
            return null;
        }
        int visibility = view3.getVisibility();
        g0.f(view3, 0);
        Animator u03 = u0(viewGroup, view3, c0Var, c0Var2);
        if (u03 != null) {
            a aVar = new a(view3, i11, true);
            u03.addListener(aVar);
            D().c(aVar);
        } else {
            g0.f(view3, visibility);
        }
        return u03;
    }

    public void w0(int i10) {
        if ((i10 & (-4)) == 0) {
            this.P = i10;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }
}
