package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Insets;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.R;
import androidx.core.view.d2;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class q1 {

    /* renamed from: a, reason: collision with root package name */
    private e f٣٠١٣a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class b {
        public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
        public static final int DISPATCH_MODE_STOP = 0;
        WindowInsets mDispachedInsets;
        private final int mDispatchMode;

        public b(int i10) {
            this.mDispatchMode = i10;
        }

        public final int getDispatchMode() {
            return this.mDispatchMode;
        }

        public abstract void onEnd(q1 q1Var);

        public void onPrepare(q1 q1Var) {
        }

        public abstract d2 onProgress(d2 d2Var, List list);

        public a onStart(q1 q1Var, a aVar) {
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c extends e {

        /* renamed from: e, reason: collision with root package name */
        private static final Interpolator f٣٠١٦e = new PathInterpolator(DownloadProgress.UNKNOWN_PROGRESS, 1.1f, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);

        /* renamed from: f, reason: collision with root package name */
        private static final Interpolator f٣٠١٧f = new z2.a();

        /* renamed from: g, reason: collision with root package name */
        private static final Interpolator f٣٠١٨g = new DecelerateInterpolator();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public static class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a, reason: collision with root package name */
            final b f٣٠١٩a;

            /* renamed from: b, reason: collision with root package name */
            private d2 f٣٠٢٠b;

            /* renamed from: androidx.core.view.q1$c$a$a, reason: collision with other inner class name */
            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
            class C٠٠٢٩a implements ValueAnimator.AnimatorUpdateListener {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ q1 f٣٠٢١a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ d2 f٣٠٢٢b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ d2 f٣٠٢٣c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f٣٠٢٤d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ View f٣٠٢٥e;

                C٠٠٢٩a(q1 q1Var, d2 d2Var, d2 d2Var2, int i10, View view) {
                    this.f٣٠٢١a = q1Var;
                    this.f٣٠٢٢b = d2Var;
                    this.f٣٠٢٣c = d2Var2;
                    this.f٣٠٢٤d = i10;
                    this.f٣٠٢٥e = view;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f٣٠٢١a.e(valueAnimator.getAnimatedFraction());
                    c.k(this.f٣٠٢٥e, c.o(this.f٣٠٢٢b, this.f٣٠٢٣c, this.f٣٠٢١a.b(), this.f٣٠٢٤d), Collections.singletonList(this.f٣٠٢١a));
                }
            }

            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
            class b extends AnimatorListenerAdapter {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ q1 f٣٠٢٧a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ View f٣٠٢٨b;

                b(q1 q1Var, View view) {
                    this.f٣٠٢٧a = q1Var;
                    this.f٣٠٢٨b = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    this.f٣٠٢٧a.e(1.0f);
                    c.i(this.f٣٠٢٨b, this.f٣٠٢٧a);
                }
            }

            /* renamed from: androidx.core.view.q1$c$a$c, reason: collision with other inner class name */
            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
            class RunnableC٠٠٣٠c implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ View f٣٠٣٠a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ q1 f٣٠٣١b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ a f٣٠٣٢c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ValueAnimator f٣٠٣٣d;

                RunnableC٠٠٣٠c(View view, q1 q1Var, a aVar, ValueAnimator valueAnimator) {
                    this.f٣٠٣٠a = view;
                    this.f٣٠٣١b = q1Var;
                    this.f٣٠٣٢c = aVar;
                    this.f٣٠٣٣d = valueAnimator;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c.l(this.f٣٠٣٠a, this.f٣٠٣١b, this.f٣٠٣٢c);
                    this.f٣٠٣٣d.start();
                }
            }

            a(View view, b bVar) {
                d2 d2Var;
                this.f٣٠١٩a = bVar;
                d2 K = d1.K(view);
                if (K != null) {
                    d2Var = new d2.b(K).a();
                } else {
                    d2Var = null;
                }
                this.f٣٠٢٠b = d2Var;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                if (!view.isLaidOut()) {
                    this.f٣٠٢٠b = d2.y(windowInsets, view);
                    return c.m(view, windowInsets);
                }
                d2 y10 = d2.y(windowInsets, view);
                if (this.f٣٠٢٠b == null) {
                    this.f٣٠٢٠b = d1.K(view);
                }
                if (this.f٣٠٢٠b == null) {
                    this.f٣٠٢٠b = y10;
                    return c.m(view, windowInsets);
                }
                b n10 = c.n(view);
                if (n10 != null && Objects.equals(n10.mDispachedInsets, windowInsets)) {
                    return c.m(view, windowInsets);
                }
                int e10 = c.e(y10, this.f٣٠٢٠b);
                if (e10 == 0) {
                    return c.m(view, windowInsets);
                }
                d2 d2Var = this.f٣٠٢٠b;
                q1 q1Var = new q1(e10, c.g(e10, y10, d2Var), 160L);
                q1Var.e(DownloadProgress.UNKNOWN_PROGRESS);
                ValueAnimator duration = ValueAnimator.ofFloat(DownloadProgress.UNKNOWN_PROGRESS, 1.0f).setDuration(q1Var.a());
                a f10 = c.f(y10, d2Var, e10);
                c.j(view, q1Var, windowInsets, false);
                duration.addUpdateListener(new C٠٠٢٩a(q1Var, y10, d2Var, e10, view));
                duration.addListener(new b(q1Var, view));
                m0.a(view, new RunnableC٠٠٣٠c(view, q1Var, f10, duration));
                this.f٣٠٢٠b = y10;
                return c.m(view, windowInsets);
            }
        }

        c(int i10, Interpolator interpolator, long j10) {
            super(i10, interpolator, j10);
        }

        static int e(d2 d2Var, d2 d2Var2) {
            int i10 = 0;
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if (!d2Var.f(i11).equals(d2Var2.f(i11))) {
                    i10 |= i11;
                }
            }
            return i10;
        }

        static a f(d2 d2Var, d2 d2Var2, int i10) {
            androidx.core.graphics.b0 f10 = d2Var.f(i10);
            androidx.core.graphics.b0 f11 = d2Var2.f(i10);
            return new a(androidx.core.graphics.b0.b(Math.min(f10.f٢٧٩٣a, f11.f٢٧٩٣a), Math.min(f10.f٢٧٩٤b, f11.f٢٧٩٤b), Math.min(f10.f٢٧٩٥c, f11.f٢٧٩٥c), Math.min(f10.f٢٧٩٦d, f11.f٢٧٩٦d)), androidx.core.graphics.b0.b(Math.max(f10.f٢٧٩٣a, f11.f٢٧٩٣a), Math.max(f10.f٢٧٩٤b, f11.f٢٧٩٤b), Math.max(f10.f٢٧٩٥c, f11.f٢٧٩٥c), Math.max(f10.f٢٧٩٦d, f11.f٢٧٩٦d)));
        }

        static Interpolator g(int i10, d2 d2Var, d2 d2Var2) {
            if ((i10 & 8) != 0) {
                if (d2Var.f(d2.m.b()).f٢٧٩٦d > d2Var2.f(d2.m.b()).f٢٧٩٦d) {
                    return f٣٠١٦e;
                }
                return f٣٠١٧f;
            }
            return f٣٠١٨g;
        }

        private static View.OnApplyWindowInsetsListener h(View view, b bVar) {
            return new a(view, bVar);
        }

        static void i(View view, q1 q1Var) {
            b n10 = n(view);
            if (n10 != null) {
                n10.onEnd(q1Var);
                if (n10.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    i(viewGroup.getChildAt(i10), q1Var);
                }
            }
        }

        static void j(View view, q1 q1Var, WindowInsets windowInsets, boolean z10) {
            b n10 = n(view);
            if (n10 != null) {
                n10.mDispachedInsets = windowInsets;
                if (!z10) {
                    n10.onPrepare(q1Var);
                    if (n10.getDispatchMode() == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    j(viewGroup.getChildAt(i10), q1Var, windowInsets, z10);
                }
            }
        }

        static void k(View view, d2 d2Var, List list) {
            b n10 = n(view);
            if (n10 != null) {
                d2Var = n10.onProgress(d2Var, list);
                if (n10.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    k(viewGroup.getChildAt(i10), d2Var, list);
                }
            }
        }

        static void l(View view, q1 q1Var, a aVar) {
            b n10 = n(view);
            if (n10 != null) {
                n10.onStart(q1Var, aVar);
                if (n10.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    l(viewGroup.getChildAt(i10), q1Var, aVar);
                }
            }
        }

        static WindowInsets m(View view, WindowInsets windowInsets) {
            if (view.getTag(R.id.tag_on_apply_window_listener) != null) {
                return windowInsets;
            }
            return view.onApplyWindowInsets(windowInsets);
        }

        static b n(View view) {
            Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
            if (tag instanceof a) {
                return ((a) tag).f٣٠١٩a;
            }
            return null;
        }

        static d2 o(d2 d2Var, d2 d2Var2, float f10, int i10) {
            d2.b bVar = new d2.b(d2Var);
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) == 0) {
                    bVar.b(i11, d2Var.f(i11));
                } else {
                    androidx.core.graphics.b0 f11 = d2Var.f(i11);
                    androidx.core.graphics.b0 f12 = d2Var2.f(i11);
                    float f13 = 1.0f - f10;
                    bVar.b(i11, d2.p(f11, (int) (((f11.f٢٧٩٣a - f12.f٢٧٩٣a) * f13) + 0.5d), (int) (((f11.f٢٧٩٤b - f12.f٢٧٩٤b) * f13) + 0.5d), (int) (((f11.f٢٧٩٥c - f12.f٢٧٩٥c) * f13) + 0.5d), (int) (((f11.f٢٧٩٦d - f12.f٢٧٩٦d) * f13) + 0.5d)));
                }
            }
            return bVar.a();
        }

        static void p(View view, b bVar) {
            Object tag = view.getTag(R.id.tag_on_apply_window_listener);
            if (bVar == null) {
                view.setTag(R.id.tag_window_insets_animation_callback, null);
                if (tag == null) {
                    view.setOnApplyWindowInsetsListener(null);
                    return;
                }
                return;
            }
            View.OnApplyWindowInsetsListener h10 = h(view, bVar);
            view.setTag(R.id.tag_window_insets_animation_callback, h10);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(h10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private final int f٣٠٤٠a;

        /* renamed from: b, reason: collision with root package name */
        private float f٣٠٤١b;

        /* renamed from: c, reason: collision with root package name */
        private final Interpolator f٣٠٤٢c;

        /* renamed from: d, reason: collision with root package name */
        private final long f٣٠٤٣d;

        e(int i10, Interpolator interpolator, long j10) {
            this.f٣٠٤٠a = i10;
            this.f٣٠٤٢c = interpolator;
            this.f٣٠٤٣d = j10;
        }

        public long a() {
            return this.f٣٠٤٣d;
        }

        public float b() {
            Interpolator interpolator = this.f٣٠٤٢c;
            if (interpolator != null) {
                return interpolator.getInterpolation(this.f٣٠٤١b);
            }
            return this.f٣٠٤١b;
        }

        public int c() {
            return this.f٣٠٤٠a;
        }

        public void d(float f10) {
            this.f٣٠٤١b = f10;
        }
    }

    public q1(int i10, Interpolator interpolator, long j10) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f٣٠١٣a = new d(i10, interpolator, j10);
        } else {
            this.f٣٠١٣a = new c(i10, interpolator, j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(View view, b bVar) {
        if (Build.VERSION.SDK_INT >= 30) {
            d.h(view, bVar);
        } else {
            c.p(view, bVar);
        }
    }

    static q1 f(WindowInsetsAnimation windowInsetsAnimation) {
        return new q1(windowInsetsAnimation);
    }

    public long a() {
        return this.f٣٠١٣a.a();
    }

    public float b() {
        return this.f٣٠١٣a.b();
    }

    public int c() {
        return this.f٣٠١٣a.c();
    }

    public void e(float f10) {
        this.f٣٠١٣a.d(f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d extends e {

        /* renamed from: e, reason: collision with root package name */
        private final WindowInsetsAnimation f٣٠٣٥e;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public static class a extends WindowInsetsAnimation$Callback {

            /* renamed from: a, reason: collision with root package name */
            private final b f٣٠٣٦a;

            /* renamed from: b, reason: collision with root package name */
            private List f٣٠٣٧b;

            /* renamed from: c, reason: collision with root package name */
            private ArrayList f٣٠٣٨c;

            /* renamed from: d, reason: collision with root package name */
            private final HashMap f٣٠٣٩d;

            a(b bVar) {
                super(bVar.getDispatchMode());
                this.f٣٠٣٩d = new HashMap();
                this.f٣٠٣٦a = bVar;
            }

            private q1 a(WindowInsetsAnimation windowInsetsAnimation) {
                q1 q1Var = (q1) this.f٣٠٣٩d.get(windowInsetsAnimation);
                if (q1Var == null) {
                    q1 f10 = q1.f(windowInsetsAnimation);
                    this.f٣٠٣٩d.put(windowInsetsAnimation, f10);
                    return f10;
                }
                return q1Var;
            }

            public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.f٣٠٣٦a.onEnd(a(windowInsetsAnimation));
                this.f٣٠٣٩d.remove(windowInsetsAnimation);
            }

            public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.f٣٠٣٦a.onPrepare(a(windowInsetsAnimation));
            }

            public WindowInsets onProgress(WindowInsets windowInsets, List list) {
                float fraction;
                ArrayList arrayList = this.f٣٠٣٨c;
                if (arrayList == null) {
                    ArrayList arrayList2 = new ArrayList(list.size());
                    this.f٣٠٣٨c = arrayList2;
                    this.f٣٠٣٧b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation a10 = b2.a(list.get(size));
                    q1 a11 = a(a10);
                    fraction = a10.getFraction();
                    a11.e(fraction);
                    this.f٣٠٣٨c.add(a11);
                }
                return this.f٣٠٣٦a.onProgress(d2.x(windowInsets), this.f٣٠٣٧b).w();
            }

            public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                return this.f٣٠٣٦a.onStart(a(windowInsetsAnimation), a.d(bounds)).c();
            }
        }

        d(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.f٣٠٣٥e = windowInsetsAnimation;
        }

        public static WindowInsetsAnimation.Bounds e(a aVar) {
            a2.a();
            return z1.a(aVar.a().f(), aVar.b().f());
        }

        public static androidx.core.graphics.b0 f(WindowInsetsAnimation.Bounds bounds) {
            Insets upperBound;
            upperBound = bounds.getUpperBound();
            return androidx.core.graphics.b0.e(upperBound);
        }

        public static androidx.core.graphics.b0 g(WindowInsetsAnimation.Bounds bounds) {
            Insets lowerBound;
            lowerBound = bounds.getLowerBound();
            return androidx.core.graphics.b0.e(lowerBound);
        }

        public static void h(View view, b bVar) {
            a aVar;
            if (bVar != null) {
                aVar = new a(bVar);
            } else {
                aVar = null;
            }
            view.setWindowInsetsAnimationCallback(aVar);
        }

        @Override // androidx.core.view.q1.e
        public long a() {
            long durationMillis;
            durationMillis = this.f٣٠٣٥e.getDurationMillis();
            return durationMillis;
        }

        @Override // androidx.core.view.q1.e
        public float b() {
            float interpolatedFraction;
            interpolatedFraction = this.f٣٠٣٥e.getInterpolatedFraction();
            return interpolatedFraction;
        }

        @Override // androidx.core.view.q1.e
        public int c() {
            int typeMask;
            typeMask = this.f٣٠٣٥e.getTypeMask();
            return typeMask;
        }

        @Override // androidx.core.view.q1.e
        public void d(float f10) {
            this.f٣٠٣٥e.setFraction(f10);
        }

        d(int i10, Interpolator interpolator, long j10) {
            this(y1.a(i10, interpolator, j10));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.core.graphics.b0 f٣٠١٤a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.core.graphics.b0 f٣٠١٥b;

        public a(androidx.core.graphics.b0 b0Var, androidx.core.graphics.b0 b0Var2) {
            this.f٣٠١٤a = b0Var;
            this.f٣٠١٥b = b0Var2;
        }

        public static a d(WindowInsetsAnimation.Bounds bounds) {
            return new a(bounds);
        }

        public androidx.core.graphics.b0 a() {
            return this.f٣٠١٤a;
        }

        public androidx.core.graphics.b0 b() {
            return this.f٣٠١٥b;
        }

        public WindowInsetsAnimation.Bounds c() {
            return d.e(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.f٣٠١٤a + " upper=" + this.f٣٠١٥b + "}";
        }

        private a(WindowInsetsAnimation.Bounds bounds) {
            this.f٣٠١٤a = d.g(bounds);
            this.f٣٠١٥b = d.f(bounds);
        }
    }

    private q1(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (Build.VERSION.SDK_INT >= 30) {
            this.f٣٠١٣a = new d(windowInsetsAnimation);
        }
    }
}
