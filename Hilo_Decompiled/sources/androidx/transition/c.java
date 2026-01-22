package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.k;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c extends k {
    private static final String[] Q = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property R = new a(PointF.class, "topLeft");
    private static final Property S = new b(PointF.class, "bottomRight");
    private static final Property T = new C٠٠٥٦c(PointF.class, "bottomRight");
    private static final Property U = new d(PointF.class, "topLeft");
    private static final Property V = new e(PointF.class, "position");
    private static final androidx.transition.i W = new androidx.transition.i();
    private boolean P = false;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(i iVar, PointF pointF) {
            iVar.c(pointF);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b extends Property {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(i iVar, PointF pointF) {
            iVar.a(pointF);
        }
    }

    /* renamed from: androidx.transition.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class C٠٠٥٦c extends Property {
        C٠٠٥٦c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            g0.d(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class d extends Property {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            g0.d(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class e extends Property {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            g0.d(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f٤٢٣٣a;
        private final i mViewBounds;

        f(i iVar) {
            this.f٤٢٣٣a = iVar;
            this.mViewBounds = iVar;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class g extends AnimatorListenerAdapter implements k.i {

        /* renamed from: a, reason: collision with root package name */
        private final View f٤٢٣٥a;

        /* renamed from: b, reason: collision with root package name */
        private final Rect f٤٢٣٦b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f٤٢٣٧c;

        /* renamed from: d, reason: collision with root package name */
        private final Rect f٤٢٣٨d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f٤٢٣٩e;

        /* renamed from: f, reason: collision with root package name */
        private final int f٤٢٤٠f;

        /* renamed from: g, reason: collision with root package name */
        private final int f٤٢٤١g;

        /* renamed from: h, reason: collision with root package name */
        private final int f٤٢٤٢h;

        /* renamed from: i, reason: collision with root package name */
        private final int f٤٢٤٣i;

        /* renamed from: j, reason: collision with root package name */
        private final int f٤٢٤٤j;

        /* renamed from: k, reason: collision with root package name */
        private final int f٤٢٤٥k;

        /* renamed from: l, reason: collision with root package name */
        private final int f٤٢٤٦l;

        /* renamed from: m, reason: collision with root package name */
        private final int f٤٢٤٧m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f٤٢٤٨n;

        g(View view, Rect rect, boolean z10, Rect rect2, boolean z11, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            this.f٤٢٣٥a = view;
            this.f٤٢٣٦b = rect;
            this.f٤٢٣٧c = z10;
            this.f٤٢٣٨d = rect2;
            this.f٤٢٣٩e = z11;
            this.f٤٢٤٠f = i10;
            this.f٤٢٤١g = i11;
            this.f٤٢٤٢h = i12;
            this.f٤٢٤٣i = i13;
            this.f٤٢٤٤j = i14;
            this.f٤٢٤٥k = i15;
            this.f٤٢٤٦l = i16;
            this.f٤٢٤٧m = i17;
        }

        @Override // androidx.transition.k.i
        public void b(k kVar) {
            View view = this.f٤٢٣٥a;
            int i10 = R.id.transition_clip;
            Rect rect = (Rect) view.getTag(i10);
            this.f٤٢٣٥a.setTag(i10, null);
            this.f٤٢٣٥a.setClipBounds(rect);
        }

        @Override // androidx.transition.k.i
        public void d(k kVar) {
        }

        @Override // androidx.transition.k.i
        public void e(k kVar) {
            Rect rect;
            this.f٤٢٣٥a.setTag(R.id.transition_clip, this.f٤٢٣٥a.getClipBounds());
            if (this.f٤٢٣٩e) {
                rect = null;
            } else {
                rect = this.f٤٢٣٨d;
            }
            this.f٤٢٣٥a.setClipBounds(rect);
        }

        @Override // androidx.transition.k.i
        public /* synthetic */ void g(k kVar, boolean z10) {
            o.a(this, kVar, z10);
        }

        @Override // androidx.transition.k.i
        public void i(k kVar) {
        }

        @Override // androidx.transition.k.i
        public void k(k kVar) {
            this.f٤٢٤٨n = true;
        }

        @Override // androidx.transition.k.i
        public /* synthetic */ void l(k kVar, boolean z10) {
            o.b(this, kVar, z10);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            onAnimationStart(animator, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z10) {
            if (this.f٤٢٤٨n) {
                return;
            }
            Rect rect = null;
            if (z10) {
                if (!this.f٤٢٣٧c) {
                    rect = this.f٤٢٣٦b;
                }
            } else if (!this.f٤٢٣٩e) {
                rect = this.f٤٢٣٨d;
            }
            this.f٤٢٣٥a.setClipBounds(rect);
            if (z10) {
                g0.d(this.f٤٢٣٥a, this.f٤٢٤٠f, this.f٤٢٤١g, this.f٤٢٤٢h, this.f٤٢٤٣i);
            } else {
                g0.d(this.f٤٢٣٥a, this.f٤٢٤٤j, this.f٤٢٤٥k, this.f٤٢٤٦l, this.f٤٢٤٧m);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z10) {
            int max = Math.max(this.f٤٢٤٢h - this.f٤٢٤٠f, this.f٤٢٤٦l - this.f٤٢٤٤j);
            int max2 = Math.max(this.f٤٢٤٣i - this.f٤٢٤١g, this.f٤٢٤٧m - this.f٤٢٤٥k);
            int i10 = z10 ? this.f٤٢٤٤j : this.f٤٢٤٠f;
            int i11 = z10 ? this.f٤٢٤٥k : this.f٤٢٤١g;
            g0.d(this.f٤٢٣٥a, i10, i11, max + i10, max2 + i11);
            this.f٤٢٣٥a.setClipBounds(z10 ? this.f٤٢٣٨d : this.f٤٢٣٦b);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class h extends w {

        /* renamed from: a, reason: collision with root package name */
        boolean f٤٢٤٩a = false;

        /* renamed from: b, reason: collision with root package name */
        final ViewGroup f٤٢٥٠b;

        h(ViewGroup viewGroup) {
            this.f٤٢٥٠b = viewGroup;
        }

        @Override // androidx.transition.w, androidx.transition.k.i
        public void b(k kVar) {
            f0.b(this.f٤٢٥٠b, true);
        }

        @Override // androidx.transition.w, androidx.transition.k.i
        public void e(k kVar) {
            f0.b(this.f٤٢٥٠b, false);
        }

        @Override // androidx.transition.w, androidx.transition.k.i
        public void i(k kVar) {
            if (!this.f٤٢٤٩a) {
                f0.b(this.f٤٢٥٠b, false);
            }
            kVar.c0(this);
        }

        @Override // androidx.transition.w, androidx.transition.k.i
        public void k(k kVar) {
            f0.b(this.f٤٢٥٠b, false);
            this.f٤٢٤٩a = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        private int f٤٢٥١a;

        /* renamed from: b, reason: collision with root package name */
        private int f٤٢٥٢b;

        /* renamed from: c, reason: collision with root package name */
        private int f٤٢٥٣c;

        /* renamed from: d, reason: collision with root package name */
        private int f٤٢٥٤d;

        /* renamed from: e, reason: collision with root package name */
        private final View f٤٢٥٥e;

        /* renamed from: f, reason: collision with root package name */
        private int f٤٢٥٦f;

        /* renamed from: g, reason: collision with root package name */
        private int f٤٢٥٧g;

        i(View view) {
            this.f٤٢٥٥e = view;
        }

        private void b() {
            g0.d(this.f٤٢٥٥e, this.f٤٢٥١a, this.f٤٢٥٢b, this.f٤٢٥٣c, this.f٤٢٥٤d);
            this.f٤٢٥٦f = 0;
            this.f٤٢٥٧g = 0;
        }

        void a(PointF pointF) {
            this.f٤٢٥٣c = Math.round(pointF.x);
            this.f٤٢٥٤d = Math.round(pointF.y);
            int i10 = this.f٤٢٥٧g + 1;
            this.f٤٢٥٧g = i10;
            if (this.f٤٢٥٦f == i10) {
                b();
            }
        }

        void c(PointF pointF) {
            this.f٤٢٥١a = Math.round(pointF.x);
            this.f٤٢٥٢b = Math.round(pointF.y);
            int i10 = this.f٤٢٥٦f + 1;
            this.f٤٢٥٦f = i10;
            if (i10 == this.f٤٢٥٧g) {
                b();
            }
        }
    }

    private void q0(c0 c0Var) {
        View view = c0Var.f٤٢٥٩b;
        if (view.isLaidOut() || view.getWidth() != 0 || view.getHeight() != 0) {
            c0Var.f٤٢٥٨a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            c0Var.f٤٢٥٨a.put("android:changeBounds:parent", c0Var.f٤٢٥٩b.getParent());
            if (this.P) {
                c0Var.f٤٢٥٨a.put("android:changeBounds:clip", view.getClipBounds());
            }
        }
    }

    @Override // androidx.transition.k
    public String[] L() {
        return Q;
    }

    @Override // androidx.transition.k
    public boolean O() {
        return true;
    }

    @Override // androidx.transition.k
    public void h(c0 c0Var) {
        q0(c0Var);
    }

    @Override // androidx.transition.k
    public void k(c0 c0Var) {
        Rect rect;
        q0(c0Var);
        if (this.P && (rect = (Rect) c0Var.f٤٢٥٩b.getTag(R.id.transition_clip)) != null) {
            c0Var.f٤٢٥٨a.put("android:changeBounds:clip", rect);
        }
    }

    @Override // androidx.transition.k
    public Animator o(ViewGroup viewGroup, c0 c0Var, c0 c0Var2) {
        int i10;
        View view;
        int i11;
        int i12;
        int i13;
        ObjectAnimator a10;
        boolean z10;
        int i14;
        boolean z11;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator c10;
        if (c0Var == null || c0Var2 == null) {
            return null;
        }
        Map map = c0Var.f٤٢٥٨a;
        Map map2 = c0Var2.f٤٢٥٨a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = c0Var2.f٤٢٥٩b;
        Rect rect2 = (Rect) c0Var.f٤٢٥٨a.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) c0Var2.f٤٢٥٨a.get("android:changeBounds:bounds");
        int i15 = rect2.left;
        int i16 = rect3.left;
        int i17 = rect2.top;
        int i18 = rect3.top;
        int i19 = rect2.right;
        int i20 = rect3.right;
        int i21 = rect2.bottom;
        int i22 = rect3.bottom;
        int i23 = i19 - i15;
        int i24 = i21 - i17;
        int i25 = i20 - i16;
        int i26 = i22 - i18;
        Rect rect4 = (Rect) c0Var.f٤٢٥٨a.get("android:changeBounds:clip");
        Rect rect5 = (Rect) c0Var2.f٤٢٥٨a.get("android:changeBounds:clip");
        if ((i23 != 0 && i24 != 0) || (i25 != 0 && i26 != 0)) {
            if (i15 == i16 && i17 == i18) {
                i10 = 0;
            } else {
                i10 = 1;
            }
            if (i19 != i20 || i21 != i22) {
                i10++;
            }
        } else {
            i10 = 0;
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i10++;
        }
        if (i10 > 0) {
            if (!this.P) {
                view = view2;
                g0.d(view, i15, i17, i19, i21);
                if (i10 == 2) {
                    if (i23 == i25 && i24 == i26) {
                        c10 = androidx.transition.g.a(view, V, B().a(i15, i17, i16, i18));
                    } else {
                        i iVar = new i(view);
                        ObjectAnimator a11 = androidx.transition.g.a(iVar, R, B().a(i15, i17, i16, i18));
                        ObjectAnimator a12 = androidx.transition.g.a(iVar, S, B().a(i19, i21, i20, i22));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(a11, a12);
                        animatorSet.addListener(new f(iVar));
                        c10 = animatorSet;
                    }
                } else if (i15 == i16 && i17 == i18) {
                    c10 = androidx.transition.g.a(view, T, B().a(i19, i21, i20, i22));
                } else {
                    c10 = androidx.transition.g.a(view, U, B().a(i15, i17, i16, i18));
                }
            } else {
                view = view2;
                g0.d(view, i15, i17, Math.max(i23, i25) + i15, i17 + Math.max(i24, i26));
                if (i15 == i16 && i17 == i18) {
                    i11 = i20;
                    i12 = i19;
                    i13 = i17;
                    a10 = null;
                } else {
                    i11 = i20;
                    i12 = i19;
                    i13 = i17;
                    a10 = androidx.transition.g.a(view, V, B().a(i15, i17, i16, i18));
                }
                if (rect4 == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    i14 = 0;
                    rect4 = new Rect(0, 0, i23, i24);
                } else {
                    i14 = 0;
                }
                Rect rect6 = rect4;
                if (rect5 == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    rect = new Rect(i14, i14, i25, i26);
                } else {
                    rect = rect5;
                }
                if (!rect6.equals(rect)) {
                    view.setClipBounds(rect6);
                    androidx.transition.i iVar2 = W;
                    Object[] objArr = new Object[2];
                    objArr[i14] = rect6;
                    objArr[1] = rect;
                    objectAnimator = ObjectAnimator.ofObject(view, "clipBounds", iVar2, objArr);
                    g gVar = new g(view, rect6, z10, rect, z11, i15, i13, i12, i21, i16, i18, i11, i22);
                    objectAnimator.addListener(gVar);
                    c(gVar);
                } else {
                    objectAnimator = null;
                }
                c10 = b0.c(a10, objectAnimator);
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                f0.b(viewGroup4, true);
                D().c(new h(viewGroup4));
            }
            return c10;
        }
        return null;
    }
}
