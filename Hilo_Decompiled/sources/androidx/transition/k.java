package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.os.Build;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.collection.LongSparseArray;
import androidx.core.util.Consumer;
import androidx.core.view.d1;
import androidx.transition.k;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.LongCompanionObject;
import v2.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class k implements Cloneable {
    private static final Animator[] L = new Animator[0];
    private static final int[] M = {2, 1, 3, 4};
    private static final androidx.transition.h N = new a();
    private static ThreadLocal O = new ThreadLocal();
    private f F;
    private androidx.collection.a G;
    long I;
    h J;
    long K;

    /* renamed from: t, reason: collision with root package name */
    private ArrayList f٤٣١٧t;

    /* renamed from: u, reason: collision with root package name */
    private ArrayList f٤٣١٨u;

    /* renamed from: v, reason: collision with root package name */
    private i[] f٤٣١٩v;

    /* renamed from: a, reason: collision with root package name */
    private String f٤٢٩٨a = getClass().getName();

    /* renamed from: b, reason: collision with root package name */
    private long f٤٢٩٩b = -1;

    /* renamed from: c, reason: collision with root package name */
    long f٤٣٠٠c = -1;

    /* renamed from: d, reason: collision with root package name */
    private TimeInterpolator f٤٣٠١d = null;

    /* renamed from: e, reason: collision with root package name */
    ArrayList f٤٣٠٢e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    ArrayList f٤٣٠٣f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private ArrayList f٤٣٠٤g = null;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList f٤٣٠٥h = null;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList f٤٣٠٦i = null;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList f٤٣٠٧j = null;

    /* renamed from: k, reason: collision with root package name */
    private ArrayList f٤٣٠٨k = null;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList f٤٣٠٩l = null;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList f٤٣١٠m = null;

    /* renamed from: n, reason: collision with root package name */
    private ArrayList f٤٣١١n = null;

    /* renamed from: o, reason: collision with root package name */
    private ArrayList f٤٣١٢o = null;

    /* renamed from: p, reason: collision with root package name */
    private d0 f٤٣١٣p = new d0();

    /* renamed from: q, reason: collision with root package name */
    private d0 f٤٣١٤q = new d0();

    /* renamed from: r, reason: collision with root package name */
    a0 f٤٣١٥r = null;

    /* renamed from: s, reason: collision with root package name */
    private int[] f٤٣١٦s = M;

    /* renamed from: w, reason: collision with root package name */
    boolean f٤٣٢٠w = false;

    /* renamed from: x, reason: collision with root package name */
    ArrayList f٤٣٢١x = new ArrayList();

    /* renamed from: y, reason: collision with root package name */
    private Animator[] f٤٣٢٢y = L;

    /* renamed from: z, reason: collision with root package name */
    int f٤٣٢٣z = 0;
    private boolean A = false;

    /* renamed from: B, reason: collision with root package name */
    boolean f٤٢٩٧B = false;
    private k C = null;
    private ArrayList D = null;
    ArrayList E = new ArrayList();
    private androidx.transition.h H = N;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a extends androidx.transition.h {
        a() {
        }

        @Override // androidx.transition.h
        public Path a(float f10, float f11, float f12, float f13) {
            Path path = new Path();
            path.moveTo(f10, f11);
            path.lineTo(f12, f13);
            return path;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.collection.a f٤٣٢٤a;

        b(androidx.collection.a aVar) {
            this.f٤٣٢٤a = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f٤٣٢٤a.remove(animator);
            k.this.f٤٣٢١x.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            k.this.f٤٣٢١x.add(animator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            k.this.r();
            animator.removeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        View f٤٣٢٧a;

        /* renamed from: b, reason: collision with root package name */
        String f٤٣٢٨b;

        /* renamed from: c, reason: collision with root package name */
        c0 f٤٣٢٩c;

        /* renamed from: d, reason: collision with root package name */
        WindowId f٤٣٣٠d;

        /* renamed from: e, reason: collision with root package name */
        k f٤٣٣١e;

        /* renamed from: f, reason: collision with root package name */
        Animator f٤٣٣٢f;

        d(View view, String str, k kVar, WindowId windowId, c0 c0Var, Animator animator) {
            this.f٤٣٢٧a = view;
            this.f٤٣٢٨b = str;
            this.f٤٣٢٩c = c0Var;
            this.f٤٣٣٠d = windowId;
            this.f٤٣٣١e = kVar;
            this.f٤٣٣٢f = animator;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class e {
        static ArrayList a(ArrayList arrayList, Object obj) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            if (!arrayList.contains(obj)) {
                arrayList.add(obj);
            }
            return arrayList;
        }

        static ArrayList b(ArrayList arrayList, Object obj) {
            if (arrayList != null) {
                arrayList.remove(obj);
                if (arrayList.isEmpty()) {
                    return null;
                }
                return arrayList;
            }
            return arrayList;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class f {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class g {
        static long a(Animator animator) {
            long totalDuration;
            totalDuration = animator.getTotalDuration();
            return totalDuration;
        }

        static void b(Animator animator, long j10) {
            ((AnimatorSet) animator).setCurrentPlayTime(j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class h extends w implements z, h.r {

        /* renamed from: d, reason: collision with root package name */
        private boolean f٤٣٣٦d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f٤٣٣٧e;

        /* renamed from: f, reason: collision with root package name */
        private v2.l f٤٣٣٨f;

        /* renamed from: i, reason: collision with root package name */
        private Runnable f٤٣٤١i;

        /* renamed from: a, reason: collision with root package name */
        private long f٤٣٣٣a = -1;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList f٤٣٣٤b = null;

        /* renamed from: c, reason: collision with root package name */
        private ArrayList f٤٣٣٥c = null;

        /* renamed from: g, reason: collision with root package name */
        private Consumer[] f٤٣٣٩g = null;

        /* renamed from: h, reason: collision with root package name */
        private final e0 f٤٣٤٠h = new e0();

        h() {
        }

        private void n() {
            ArrayList arrayList = this.f٤٣٣٥c;
            if (arrayList != null && !arrayList.isEmpty()) {
                int size = this.f٤٣٣٥c.size();
                if (this.f٤٣٣٩g == null) {
                    this.f٤٣٣٩g = new Consumer[size];
                }
                Consumer[] consumerArr = (Consumer[]) this.f٤٣٣٥c.toArray(this.f٤٣٣٩g);
                this.f٤٣٣٩g = null;
                for (int i10 = 0; i10 < size; i10++) {
                    consumerArr[i10].accept(this);
                    consumerArr[i10] = null;
                }
                this.f٤٣٣٩g = consumerArr;
            }
        }

        private void o() {
            if (this.f٤٣٣٨f != null) {
                return;
            }
            this.f٤٣٤٠h.a(AnimationUtils.currentAnimationTimeMillis(), (float) this.f٤٣٣٣a);
            this.f٤٣٣٨f = new v2.l(new v2.j());
            v2.m mVar = new v2.m();
            mVar.f(1.0f);
            mVar.h(200.0f);
            this.f٤٣٣٨f.y(mVar);
            this.f٤٣٣٨f.o((float) this.f٤٣٣٣a);
            this.f٤٣٣٨f.c(this);
            this.f٤٣٣٨f.p(this.f٤٣٤٠h.b());
            this.f٤٣٣٨f.k((float) (c() + 1));
            this.f٤٣٣٨f.l(-1.0f);
            this.f٤٣٣٨f.m(4.0f);
            this.f٤٣٣٨f.b(new h.q() { // from class: androidx.transition.n
                @Override // v2.h.q
                public final void a(v2.h hVar, boolean z10, float f10, float f11) {
                    k.h.this.q(hVar, z10, f10, f11);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(v2.h hVar, boolean z10, float f10, float f11) {
            if (!z10) {
                if (f10 < 1.0f) {
                    long c10 = c();
                    k u02 = ((a0) k.this).u0(0);
                    k kVar = u02.C;
                    u02.C = null;
                    k.this.h0(-1L, this.f٤٣٣٣a);
                    k.this.h0(c10, -1L);
                    this.f٤٣٣٣a = c10;
                    Runnable runnable = this.f٤٣٤١i;
                    if (runnable != null) {
                        runnable.run();
                    }
                    k.this.E.clear();
                    if (kVar != null) {
                        kVar.Y(j.f٤٣٤٤b, true);
                        return;
                    }
                    return;
                }
                k.this.Y(j.f٤٣٤٤b, false);
            }
        }

        @Override // androidx.transition.z
        public void a() {
            o();
            this.f٤٣٣٨f.u((float) (c() + 1));
        }

        @Override // androidx.transition.z
        public long c() {
            return k.this.K();
        }

        @Override // androidx.transition.z
        public void f(long j10) {
            if (this.f٤٣٣٨f == null) {
                if (j10 != this.f٤٣٣٣a && isReady()) {
                    if (!this.f٤٣٣٧e) {
                        if (j10 == 0 && this.f٤٣٣٣a > 0) {
                            j10 = -1;
                        } else {
                            long c10 = c();
                            if (j10 == c10 && this.f٤٣٣٣a < c10) {
                                j10 = 1 + c10;
                            }
                        }
                        long j11 = this.f٤٣٣٣a;
                        if (j10 != j11) {
                            k.this.h0(j10, j11);
                            this.f٤٣٣٣a = j10;
                        }
                    }
                    n();
                    this.f٤٣٤٠h.a(AnimationUtils.currentAnimationTimeMillis(), (float) j10);
                    return;
                }
                return;
            }
            throw new IllegalStateException("setCurrentPlayTimeMillis() called after animation has been started");
        }

        @Override // v2.h.r
        public void h(v2.h hVar, float f10, float f11) {
            long max = Math.max(-1L, Math.min(c() + 1, Math.round(f10)));
            k.this.h0(max, this.f٤٣٣٣a);
            this.f٤٣٣٣a = max;
            n();
        }

        @Override // androidx.transition.z
        public boolean isReady() {
            return this.f٤٣٣٦d;
        }

        @Override // androidx.transition.z
        public void j(Runnable runnable) {
            this.f٤٣٤١i = runnable;
            o();
            this.f٤٣٣٨f.u(DownloadProgress.UNKNOWN_PROGRESS);
        }

        @Override // androidx.transition.w, androidx.transition.k.i
        public void k(k kVar) {
            this.f٤٣٣٧e = true;
        }

        void p() {
            long j10 = 0;
            if (c() == 0) {
                j10 = 1;
            }
            k.this.h0(j10, this.f٤٣٣٣a);
            this.f٤٣٣٣a = j10;
        }

        public void r() {
            this.f٤٣٣٦d = true;
            ArrayList arrayList = this.f٤٣٣٤b;
            if (arrayList != null) {
                this.f٤٣٣٤b = null;
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    ((Consumer) arrayList.get(i10)).accept(this);
                }
            }
            n();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface i {
        void b(k kVar);

        void d(k kVar);

        void e(k kVar);

        void g(k kVar, boolean z10);

        void i(k kVar);

        void k(k kVar);

        void l(k kVar, boolean z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface j {

        /* renamed from: a, reason: collision with root package name */
        public static final j f٤٣٤٣a = new j() { // from class: androidx.transition.p
            @Override // androidx.transition.k.j
            public final void a(k.i iVar, k kVar, boolean z10) {
                iVar.l(kVar, z10);
            }
        };

        /* renamed from: b, reason: collision with root package name */
        public static final j f٤٣٤٤b = new j() { // from class: androidx.transition.q
            @Override // androidx.transition.k.j
            public final void a(k.i iVar, k kVar, boolean z10) {
                iVar.g(kVar, z10);
            }
        };

        /* renamed from: c, reason: collision with root package name */
        public static final j f٤٣٤٥c = new j() { // from class: androidx.transition.s
            @Override // androidx.transition.k.j
            public final void a(k.i iVar, k kVar, boolean z10) {
                iVar.k(kVar);
            }
        };

        /* renamed from: d, reason: collision with root package name */
        public static final j f٤٣٤٦d = new j() { // from class: androidx.transition.t
            @Override // androidx.transition.k.j
            public final void a(k.i iVar, k kVar, boolean z10) {
                iVar.e(kVar);
            }
        };

        /* renamed from: e, reason: collision with root package name */
        public static final j f٤٣٤٧e = new j() { // from class: androidx.transition.u
            @Override // androidx.transition.k.j
            public final void a(k.i iVar, k kVar, boolean z10) {
                iVar.b(kVar);
            }
        };

        void a(i iVar, k kVar, boolean z10);
    }

    private static androidx.collection.a E() {
        androidx.collection.a aVar = (androidx.collection.a) O.get();
        if (aVar == null) {
            androidx.collection.a aVar2 = new androidx.collection.a();
            O.set(aVar2);
            return aVar2;
        }
        return aVar;
    }

    private static boolean R(c0 c0Var, c0 c0Var2, String str) {
        Object obj = c0Var.f٤٢٥٨a.get(str);
        Object obj2 = c0Var2.f٤٢٥٨a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj != null && obj2 != null) {
            return !obj.equals(obj2);
        }
        return true;
    }

    private void S(androidx.collection.a aVar, androidx.collection.a aVar2, SparseArray sparseArray, SparseArray sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = (View) sparseArray.valueAt(i10);
            if (view2 != null && Q(view2) && (view = (View) sparseArray2.get(sparseArray.keyAt(i10))) != null && Q(view)) {
                c0 c0Var = (c0) aVar.get(view2);
                c0 c0Var2 = (c0) aVar2.get(view);
                if (c0Var != null && c0Var2 != null) {
                    this.f٤٣١٧t.add(c0Var);
                    this.f٤٣١٨u.add(c0Var2);
                    aVar.remove(view2);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void T(androidx.collection.a aVar, androidx.collection.a aVar2) {
        c0 c0Var;
        for (int size = aVar.getSize() - 1; size >= 0; size--) {
            View view = (View) aVar.keyAt(size);
            if (view != null && Q(view) && (c0Var = (c0) aVar2.remove(view)) != null && Q(c0Var.f٤٢٥٩b)) {
                this.f٤٣١٧t.add((c0) aVar.removeAt(size));
                this.f٤٣١٨u.add(c0Var);
            }
        }
    }

    private void U(androidx.collection.a aVar, androidx.collection.a aVar2, LongSparseArray longSparseArray, LongSparseArray longSparseArray2) {
        View view;
        int size = longSparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = (View) longSparseArray.valueAt(i10);
            if (view2 != null && Q(view2) && (view = (View) longSparseArray2.get(longSparseArray.keyAt(i10))) != null && Q(view)) {
                c0 c0Var = (c0) aVar.get(view2);
                c0 c0Var2 = (c0) aVar2.get(view);
                if (c0Var != null && c0Var2 != null) {
                    this.f٤٣١٧t.add(c0Var);
                    this.f٤٣١٨u.add(c0Var2);
                    aVar.remove(view2);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void V(androidx.collection.a aVar, androidx.collection.a aVar2, androidx.collection.a aVar3, androidx.collection.a aVar4) {
        View view;
        int size = aVar3.getSize();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = (View) aVar3.valueAt(i10);
            if (view2 != null && Q(view2) && (view = (View) aVar4.get(aVar3.keyAt(i10))) != null && Q(view)) {
                c0 c0Var = (c0) aVar.get(view2);
                c0 c0Var2 = (c0) aVar2.get(view);
                if (c0Var != null && c0Var2 != null) {
                    this.f٤٣١٧t.add(c0Var);
                    this.f٤٣١٨u.add(c0Var2);
                    aVar.remove(view2);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void W(d0 d0Var, d0 d0Var2) {
        androidx.collection.a aVar = new androidx.collection.a(d0Var.f٤٢٦٣a);
        androidx.collection.a aVar2 = new androidx.collection.a(d0Var2.f٤٢٦٣a);
        int i10 = 0;
        while (true) {
            int[] iArr = this.f٤٣١٦s;
            if (i10 < iArr.length) {
                int i11 = iArr[i10];
                if (i11 != 1) {
                    if (i11 != 2) {
                        if (i11 != 3) {
                            if (i11 == 4) {
                                U(aVar, aVar2, d0Var.f٤٢٦٥c, d0Var2.f٤٢٦٥c);
                            }
                        } else {
                            S(aVar, aVar2, d0Var.f٤٢٦٤b, d0Var2.f٤٢٦٤b);
                        }
                    } else {
                        V(aVar, aVar2, d0Var.f٤٢٦٦d, d0Var2.f٤٢٦٦d);
                    }
                } else {
                    T(aVar, aVar2);
                }
                i10++;
            } else {
                e(aVar, aVar2);
                return;
            }
        }
    }

    private void X(k kVar, j jVar, boolean z10) {
        k kVar2 = this.C;
        if (kVar2 != null) {
            kVar2.X(kVar, jVar, z10);
        }
        ArrayList arrayList = this.D;
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = this.D.size();
            i[] iVarArr = this.f٤٣١٩v;
            if (iVarArr == null) {
                iVarArr = new i[size];
            }
            this.f٤٣١٩v = null;
            i[] iVarArr2 = (i[]) this.D.toArray(iVarArr);
            for (int i10 = 0; i10 < size; i10++) {
                jVar.a(iVarArr2[i10], kVar, z10);
                iVarArr2[i10] = null;
            }
            this.f٤٣١٩v = iVarArr2;
        }
    }

    private void e(androidx.collection.a aVar, androidx.collection.a aVar2) {
        for (int i10 = 0; i10 < aVar.getSize(); i10++) {
            c0 c0Var = (c0) aVar.valueAt(i10);
            if (Q(c0Var.f٤٢٥٩b)) {
                this.f٤٣١٧t.add(c0Var);
                this.f٤٣١٨u.add(null);
            }
        }
        for (int i11 = 0; i11 < aVar2.getSize(); i11++) {
            c0 c0Var2 = (c0) aVar2.valueAt(i11);
            if (Q(c0Var2.f٤٢٥٩b)) {
                this.f٤٣١٨u.add(c0Var2);
                this.f٤٣١٧t.add(null);
            }
        }
    }

    private static void f(d0 d0Var, View view, c0 c0Var) {
        d0Var.f٤٢٦٣a.put(view, c0Var);
        int id = view.getId();
        if (id >= 0) {
            if (d0Var.f٤٢٦٤b.indexOfKey(id) >= 0) {
                d0Var.f٤٢٦٤b.put(id, null);
            } else {
                d0Var.f٤٢٦٤b.put(id, view);
            }
        }
        String M2 = d1.M(view);
        if (M2 != null) {
            if (d0Var.f٤٢٦٦d.containsKey(M2)) {
                d0Var.f٤٢٦٦d.put(M2, null);
            } else {
                d0Var.f٤٢٦٦d.put(M2, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (d0Var.f٤٢٦٥c.indexOfKey(itemIdAtPosition) >= 0) {
                    View view2 = (View) d0Var.f٤٢٦٥c.get(itemIdAtPosition);
                    if (view2 != null) {
                        view2.setHasTransientState(false);
                        d0Var.f٤٢٦٥c.put(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                view.setHasTransientState(true);
                d0Var.f٤٢٦٥c.put(itemIdAtPosition, view);
            }
        }
    }

    private void f0(Animator animator, androidx.collection.a aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            g(animator);
        }
    }

    private void i(View view, boolean z10) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList arrayList = this.f٤٣٠٦i;
        if (arrayList != null && arrayList.contains(Integer.valueOf(id))) {
            return;
        }
        ArrayList arrayList2 = this.f٤٣٠٧j;
        if (arrayList2 != null && arrayList2.contains(view)) {
            return;
        }
        ArrayList arrayList3 = this.f٤٣٠٨k;
        if (arrayList3 != null) {
            int size = arrayList3.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((Class) this.f٤٣٠٨k.get(i10)).isInstance(view)) {
                    return;
                }
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            c0 c0Var = new c0(view);
            if (z10) {
                k(c0Var);
            } else {
                h(c0Var);
            }
            c0Var.f٤٢٦٠c.add(this);
            j(c0Var);
            if (z10) {
                f(this.f٤٣١٣p, view, c0Var);
            } else {
                f(this.f٤٣١٤q, view, c0Var);
            }
        }
        if (view instanceof ViewGroup) {
            ArrayList arrayList4 = this.f٤٣١٠m;
            if (arrayList4 != null && arrayList4.contains(Integer.valueOf(id))) {
                return;
            }
            ArrayList arrayList5 = this.f٤٣١١n;
            if (arrayList5 != null && arrayList5.contains(view)) {
                return;
            }
            ArrayList arrayList6 = this.f٤٣١٢o;
            if (arrayList6 != null) {
                int size2 = arrayList6.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    if (((Class) this.f٤٣١٢o.get(i11)).isInstance(view)) {
                        return;
                    }
                }
            }
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                i(viewGroup.getChildAt(i12), z10);
            }
        }
    }

    private ArrayList u(ArrayList arrayList, Class cls, boolean z10) {
        if (cls != null) {
            if (z10) {
                return e.a(arrayList, cls);
            }
            return e.b(arrayList, cls);
        }
        return arrayList;
    }

    private ArrayList v(ArrayList arrayList, View view, boolean z10) {
        if (view != null) {
            if (z10) {
                return e.a(arrayList, view);
            }
            return e.b(arrayList, view);
        }
        return arrayList;
    }

    public String A() {
        return this.f٤٢٩٨a;
    }

    public androidx.transition.h B() {
        return this.H;
    }

    public y C() {
        return null;
    }

    public final k D() {
        a0 a0Var = this.f٤٣١٥r;
        if (a0Var != null) {
            return a0Var.D();
        }
        return this;
    }

    public long F() {
        return this.f٤٢٩٩b;
    }

    public List G() {
        return this.f٤٣٠٢e;
    }

    public List H() {
        return this.f٤٣٠٤g;
    }

    public List I() {
        return this.f٤٣٠٥h;
    }

    public List J() {
        return this.f٤٣٠٣f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long K() {
        return this.I;
    }

    public String[] L() {
        return null;
    }

    public c0 M(View view, boolean z10) {
        d0 d0Var;
        a0 a0Var = this.f٤٣١٥r;
        if (a0Var != null) {
            return a0Var.M(view, z10);
        }
        if (z10) {
            d0Var = this.f٤٣١٣p;
        } else {
            d0Var = this.f٤٣١٤q;
        }
        return (c0) d0Var.f٤٢٦٣a.get(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean N() {
        return !this.f٤٣٢١x.isEmpty();
    }

    public boolean O() {
        return false;
    }

    public boolean P(c0 c0Var, c0 c0Var2) {
        if (c0Var == null || c0Var2 == null) {
            return false;
        }
        String[] L2 = L();
        if (L2 != null) {
            for (String str : L2) {
                if (!R(c0Var, c0Var2, str)) {
                }
            }
            return false;
        }
        Iterator it = c0Var.f٤٢٥٨a.keySet().iterator();
        while (it.hasNext()) {
            if (R(c0Var, c0Var2, (String) it.next())) {
            }
        }
        return false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Q(View view) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int id = view.getId();
        ArrayList arrayList3 = this.f٤٣٠٦i;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList arrayList4 = this.f٤٣٠٧j;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList arrayList5 = this.f٤٣٠٨k;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((Class) this.f٤٣٠٨k.get(i10)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f٤٣٠٩l != null && d1.M(view) != null && this.f٤٣٠٩l.contains(d1.M(view))) {
            return false;
        }
        if ((this.f٤٣٠٢e.size() == 0 && this.f٤٣٠٣f.size() == 0 && (((arrayList = this.f٤٣٠٥h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f٤٣٠٤g) == null || arrayList2.isEmpty()))) || this.f٤٣٠٢e.contains(Integer.valueOf(id)) || this.f٤٣٠٣f.contains(view)) {
            return true;
        }
        ArrayList arrayList6 = this.f٤٣٠٤g;
        if (arrayList6 != null && arrayList6.contains(d1.M(view))) {
            return true;
        }
        if (this.f٤٣٠٥h != null) {
            for (int i11 = 0; i11 < this.f٤٣٠٥h.size(); i11++) {
                if (((Class) this.f٤٣٠٥h.get(i11)).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(j jVar, boolean z10) {
        X(this, jVar, z10);
    }

    public void Z(View view) {
        if (!this.f٤٢٩٧B) {
            int size = this.f٤٣٢١x.size();
            Animator[] animatorArr = (Animator[]) this.f٤٣٢١x.toArray(this.f٤٣٢٢y);
            this.f٤٣٢٢y = L;
            for (int i10 = size - 1; i10 >= 0; i10--) {
                Animator animator = animatorArr[i10];
                animatorArr[i10] = null;
                animator.pause();
            }
            this.f٤٣٢٢y = animatorArr;
            Y(j.f٤٣٤٦d, false);
            this.A = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a0(ViewGroup viewGroup) {
        d dVar;
        this.f٤٣١٧t = new ArrayList();
        this.f٤٣١٨u = new ArrayList();
        W(this.f٤٣١٣p, this.f٤٣١٤q);
        androidx.collection.a E = E();
        int size = E.getSize();
        WindowId windowId = viewGroup.getWindowId();
        for (int i10 = size - 1; i10 >= 0; i10--) {
            Animator animator = (Animator) E.keyAt(i10);
            if (animator != null && (dVar = (d) E.get(animator)) != null && dVar.f٤٣٢٧a != null && windowId.equals(dVar.f٤٣٣٠d)) {
                c0 c0Var = dVar.f٤٣٢٩c;
                View view = dVar.f٤٣٢٧a;
                c0 M2 = M(view, true);
                c0 z10 = z(view, true);
                if (M2 == null && z10 == null) {
                    z10 = (c0) this.f٤٣١٤q.f٤٢٦٣a.get(view);
                }
                if ((M2 != null || z10 != null) && dVar.f٤٣٣١e.P(c0Var, z10)) {
                    k kVar = dVar.f٤٣٣١e;
                    if (kVar.D().J != null) {
                        animator.cancel();
                        kVar.f٤٣٢١x.remove(animator);
                        E.remove(animator);
                        if (kVar.f٤٣٢١x.size() == 0) {
                            kVar.Y(j.f٤٣٤٥c, false);
                            if (!kVar.f٤٢٩٧B) {
                                kVar.f٤٢٩٧B = true;
                                kVar.Y(j.f٤٣٤٤b, false);
                            }
                        }
                    } else if (!animator.isRunning() && !animator.isStarted()) {
                        E.remove(animator);
                    } else {
                        animator.cancel();
                    }
                }
            }
        }
        p(viewGroup, this.f٤٣١٣p, this.f٤٣١٤q, this.f٤٣١٧t, this.f٤٣١٨u);
        if (this.J == null) {
            g0();
        } else if (Build.VERSION.SDK_INT >= 34) {
            b0();
            this.J.p();
            this.J.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b0() {
        androidx.collection.a E = E();
        this.I = 0L;
        for (int i10 = 0; i10 < this.E.size(); i10++) {
            Animator animator = (Animator) this.E.get(i10);
            d dVar = (d) E.get(animator);
            if (animator != null && dVar != null) {
                if (w() >= 0) {
                    dVar.f٤٣٣٢f.setDuration(w());
                }
                if (F() >= 0) {
                    dVar.f٤٣٣٢f.setStartDelay(F() + dVar.f٤٣٣٢f.getStartDelay());
                }
                if (y() != null) {
                    dVar.f٤٣٣٢f.setInterpolator(y());
                }
                this.f٤٣٢١x.add(animator);
                this.I = Math.max(this.I, g.a(animator));
            }
        }
        this.E.clear();
    }

    public k c(i iVar) {
        if (this.D == null) {
            this.D = new ArrayList();
        }
        this.D.add(iVar);
        return this;
    }

    public k c0(i iVar) {
        k kVar;
        ArrayList arrayList = this.D;
        if (arrayList == null) {
            return this;
        }
        if (!arrayList.remove(iVar) && (kVar = this.C) != null) {
            kVar.c0(iVar);
        }
        if (this.D.size() == 0) {
            this.D = null;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cancel() {
        int size = this.f٤٣٢١x.size();
        Animator[] animatorArr = (Animator[]) this.f٤٣٢١x.toArray(this.f٤٣٢٢y);
        this.f٤٣٢٢y = L;
        for (int i10 = size - 1; i10 >= 0; i10--) {
            Animator animator = animatorArr[i10];
            animatorArr[i10] = null;
            animator.cancel();
        }
        this.f٤٣٢٢y = animatorArr;
        Y(j.f٤٣٤٥c, false);
    }

    public k d(View view) {
        this.f٤٣٠٣f.add(view);
        return this;
    }

    public k d0(View view) {
        this.f٤٣٠٣f.remove(view);
        return this;
    }

    public void e0(View view) {
        if (this.A) {
            if (!this.f٤٢٩٧B) {
                int size = this.f٤٣٢١x.size();
                Animator[] animatorArr = (Animator[]) this.f٤٣٢١x.toArray(this.f٤٣٢٢y);
                this.f٤٣٢٢y = L;
                for (int i10 = size - 1; i10 >= 0; i10--) {
                    Animator animator = animatorArr[i10];
                    animatorArr[i10] = null;
                    animator.resume();
                }
                this.f٤٣٢٢y = animatorArr;
                Y(j.f٤٣٤٧e, false);
            }
            this.A = false;
        }
    }

    protected void g(Animator animator) {
        if (animator == null) {
            r();
            return;
        }
        if (w() >= 0) {
            animator.setDuration(w());
        }
        if (F() >= 0) {
            animator.setStartDelay(F() + animator.getStartDelay());
        }
        if (y() != null) {
            animator.setInterpolator(y());
        }
        animator.addListener(new c());
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g0() {
        o0();
        androidx.collection.a E = E();
        Iterator it = this.E.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (E.containsKey(animator)) {
                o0();
                f0(animator, E);
            }
        }
        this.E.clear();
        r();
    }

    public abstract void h(c0 c0Var);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h0(long j10, long j11) {
        boolean z10;
        long K = K();
        int i10 = 0;
        if (j10 < j11) {
            z10 = true;
        } else {
            z10 = false;
        }
        if ((j11 < 0 && j10 >= 0) || (j11 > K && j10 <= K)) {
            this.f٤٢٩٧B = false;
            Y(j.f٤٣٤٣a, z10);
        }
        int size = this.f٤٣٢١x.size();
        Animator[] animatorArr = (Animator[]) this.f٤٣٢١x.toArray(this.f٤٣٢٢y);
        this.f٤٣٢٢y = L;
        while (i10 < size) {
            Animator animator = animatorArr[i10];
            animatorArr[i10] = null;
            g.b(animator, Math.min(Math.max(0L, j10), g.a(animator)));
            i10++;
            z10 = z10;
        }
        boolean z11 = z10;
        this.f٤٣٢٢y = animatorArr;
        if ((j10 > K && j11 <= K) || (j10 < 0 && j11 >= 0)) {
            if (j10 > K) {
                this.f٤٢٩٧B = true;
            }
            Y(j.f٤٣٤٤b, z11);
        }
    }

    public k i0(long j10) {
        this.f٤٣٠٠c = j10;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(c0 c0Var) {
    }

    public void j0(f fVar) {
        this.F = fVar;
    }

    public abstract void k(c0 c0Var);

    public k k0(TimeInterpolator timeInterpolator) {
        this.f٤٣٠١d = timeInterpolator;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(ViewGroup viewGroup, boolean z10) {
        ArrayList arrayList;
        ArrayList arrayList2;
        androidx.collection.a aVar;
        m(z10);
        if ((this.f٤٣٠٢e.size() <= 0 && this.f٤٣٠٣f.size() <= 0) || (((arrayList = this.f٤٣٠٤g) != null && !arrayList.isEmpty()) || ((arrayList2 = this.f٤٣٠٥h) != null && !arrayList2.isEmpty()))) {
            i(viewGroup, z10);
        } else {
            for (int i10 = 0; i10 < this.f٤٣٠٢e.size(); i10++) {
                View findViewById = viewGroup.findViewById(((Integer) this.f٤٣٠٢e.get(i10)).intValue());
                if (findViewById != null) {
                    c0 c0Var = new c0(findViewById);
                    if (z10) {
                        k(c0Var);
                    } else {
                        h(c0Var);
                    }
                    c0Var.f٤٢٦٠c.add(this);
                    j(c0Var);
                    if (z10) {
                        f(this.f٤٣١٣p, findViewById, c0Var);
                    } else {
                        f(this.f٤٣١٤q, findViewById, c0Var);
                    }
                }
            }
            for (int i11 = 0; i11 < this.f٤٣٠٣f.size(); i11++) {
                View view = (View) this.f٤٣٠٣f.get(i11);
                c0 c0Var2 = new c0(view);
                if (z10) {
                    k(c0Var2);
                } else {
                    h(c0Var2);
                }
                c0Var2.f٤٢٦٠c.add(this);
                j(c0Var2);
                if (z10) {
                    f(this.f٤٣١٣p, view, c0Var2);
                } else {
                    f(this.f٤٣١٤q, view, c0Var2);
                }
            }
        }
        if (!z10 && (aVar = this.G) != null) {
            int size = aVar.getSize();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i12 = 0; i12 < size; i12++) {
                arrayList3.add((View) this.f٤٣١٣p.f٤٢٦٦d.remove((String) this.G.keyAt(i12)));
            }
            for (int i13 = 0; i13 < size; i13++) {
                View view2 = (View) arrayList3.get(i13);
                if (view2 != null) {
                    this.f٤٣١٣p.f٤٢٦٦d.put((String) this.G.valueAt(i13), view2);
                }
            }
        }
    }

    public void l0(androidx.transition.h hVar) {
        if (hVar == null) {
            this.H = N;
        } else {
            this.H = hVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(boolean z10) {
        if (z10) {
            this.f٤٣١٣p.f٤٢٦٣a.clear();
            this.f٤٣١٣p.f٤٢٦٤b.clear();
            this.f٤٣١٣p.f٤٢٦٥c.clear();
        } else {
            this.f٤٣١٤q.f٤٢٦٣a.clear();
            this.f٤٣١٤q.f٤٢٦٤b.clear();
            this.f٤٣١٤q.f٤٢٦٥c.clear();
        }
    }

    public void m0(y yVar) {
    }

    @Override // 
    /* renamed from: n */
    public k clone() {
        try {
            k kVar = (k) super.clone();
            kVar.E = new ArrayList();
            kVar.f٤٣١٣p = new d0();
            kVar.f٤٣١٤q = new d0();
            kVar.f٤٣١٧t = null;
            kVar.f٤٣١٨u = null;
            kVar.J = null;
            kVar.C = this;
            kVar.D = null;
            return kVar;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    public k n0(long j10) {
        this.f٤٢٩٩b = j10;
        return this;
    }

    public Animator o(ViewGroup viewGroup, c0 c0Var, c0 c0Var2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o0() {
        if (this.f٤٣٢٣z == 0) {
            Y(j.f٤٣٤٣a, false);
            this.f٤٢٩٧B = false;
        }
        this.f٤٣٢٣z++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ViewGroup viewGroup, d0 d0Var, d0 d0Var2, ArrayList arrayList, ArrayList arrayList2) {
        boolean z10;
        Animator o10;
        View view;
        Animator animator;
        c0 c0Var;
        int i10;
        Animator animator2;
        c0 c0Var2;
        androidx.collection.a E = E();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        if (D().J != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i11 = 0;
        while (i11 < size) {
            c0 c0Var3 = (c0) arrayList.get(i11);
            c0 c0Var4 = (c0) arrayList2.get(i11);
            if (c0Var3 != null && !c0Var3.f٤٢٦٠c.contains(this)) {
                c0Var3 = null;
            }
            if (c0Var4 != null && !c0Var4.f٤٢٦٠c.contains(this)) {
                c0Var4 = null;
            }
            if ((c0Var3 != null || c0Var4 != null) && ((c0Var3 == null || c0Var4 == null || P(c0Var3, c0Var4)) && (o10 = o(viewGroup, c0Var3, c0Var4)) != null)) {
                if (c0Var4 != null) {
                    View view2 = c0Var4.f٤٢٥٩b;
                    String[] L2 = L();
                    if (L2 != null && L2.length > 0) {
                        c0Var2 = new c0(view2);
                        c0 c0Var5 = (c0) d0Var2.f٤٢٦٣a.get(view2);
                        if (c0Var5 != null) {
                            int i12 = 0;
                            while (i12 < L2.length) {
                                Map map = c0Var2.f٤٢٥٨a;
                                String str = L2[i12];
                                map.put(str, c0Var5.f٤٢٥٨a.get(str));
                                i12++;
                                L2 = L2;
                            }
                        }
                        int size2 = E.getSize();
                        int i13 = 0;
                        while (true) {
                            if (i13 < size2) {
                                d dVar = (d) E.get((Animator) E.keyAt(i13));
                                if (dVar.f٤٣٢٩c != null && dVar.f٤٣٢٧a == view2 && dVar.f٤٣٢٨b.equals(A()) && dVar.f٤٣٢٩c.equals(c0Var2)) {
                                    animator2 = null;
                                    break;
                                }
                                i13++;
                            } else {
                                animator2 = o10;
                                break;
                            }
                        }
                    } else {
                        animator2 = o10;
                        c0Var2 = null;
                    }
                    view = view2;
                    animator = animator2;
                    c0Var = c0Var2;
                } else {
                    view = c0Var3.f٤٢٥٩b;
                    animator = o10;
                    c0Var = null;
                }
                if (animator != null) {
                    i10 = size;
                    d dVar2 = new d(view, A(), this, viewGroup.getWindowId(), c0Var, animator);
                    if (z10) {
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.play(animator);
                        animator = animatorSet;
                    }
                    E.put(animator, dVar2);
                    this.E.add(animator);
                    i11++;
                    size = i10;
                }
            }
            i10 = size;
            i11++;
            size = i10;
        }
        if (sparseIntArray.size() != 0) {
            for (int i14 = 0; i14 < sparseIntArray.size(); i14++) {
                d dVar3 = (d) E.get((Animator) this.E.get(sparseIntArray.keyAt(i14)));
                dVar3.f٤٣٣٢f.setStartDelay((sparseIntArray.valueAt(i14) - LongCompanionObject.MAX_VALUE) + dVar3.f٤٣٣٢f.getStartDelay());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String p0(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.f٤٣٠٠c != -1) {
            sb.append("dur(");
            sb.append(this.f٤٣٠٠c);
            sb.append(") ");
        }
        if (this.f٤٢٩٩b != -1) {
            sb.append("dly(");
            sb.append(this.f٤٢٩٩b);
            sb.append(") ");
        }
        if (this.f٤٣٠١d != null) {
            sb.append("interp(");
            sb.append(this.f٤٣٠١d);
            sb.append(") ");
        }
        if (this.f٤٣٠٢e.size() > 0 || this.f٤٣٠٣f.size() > 0) {
            sb.append("tgts(");
            if (this.f٤٣٠٢e.size() > 0) {
                for (int i10 = 0; i10 < this.f٤٣٠٢e.size(); i10++) {
                    if (i10 > 0) {
                        sb.append(", ");
                    }
                    sb.append(this.f٤٣٠٢e.get(i10));
                }
            }
            if (this.f٤٣٠٣f.size() > 0) {
                for (int i11 = 0; i11 < this.f٤٣٠٣f.size(); i11++) {
                    if (i11 > 0) {
                        sb.append(", ");
                    }
                    sb.append(this.f٤٣٠٣f.get(i11));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z q() {
        h hVar = new h();
        this.J = hVar;
        c(hVar);
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r() {
        int i10 = this.f٤٣٢٣z - 1;
        this.f٤٣٢٣z = i10;
        if (i10 == 0) {
            Y(j.f٤٣٤٤b, false);
            for (int i11 = 0; i11 < this.f٤٣١٣p.f٤٢٦٥c.size(); i11++) {
                View view = (View) this.f٤٣١٣p.f٤٢٦٥c.valueAt(i11);
                if (view != null) {
                    view.setHasTransientState(false);
                }
            }
            for (int i12 = 0; i12 < this.f٤٣١٤q.f٤٢٦٥c.size(); i12++) {
                View view2 = (View) this.f٤٣١٤q.f٤٢٦٥c.valueAt(i12);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                }
            }
            this.f٤٢٩٧B = true;
        }
    }

    public k s(View view, boolean z10) {
        this.f٤٣٠٧j = v(this.f٤٣٠٧j, view, z10);
        return this;
    }

    public k t(Class cls, boolean z10) {
        this.f٤٣٠٨k = u(this.f٤٣٠٨k, cls, z10);
        return this;
    }

    public String toString() {
        return p0("");
    }

    public long w() {
        return this.f٤٣٠٠c;
    }

    public f x() {
        return this.F;
    }

    public TimeInterpolator y() {
        return this.f٤٣٠١d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0 z(View view, boolean z10) {
        ArrayList arrayList;
        ArrayList arrayList2;
        a0 a0Var = this.f٤٣١٥r;
        if (a0Var != null) {
            return a0Var.z(view, z10);
        }
        if (z10) {
            arrayList = this.f٤٣١٧t;
        } else {
            arrayList = this.f٤٣١٨u;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 < size) {
                c0 c0Var = (c0) arrayList.get(i10);
                if (c0Var == null) {
                    return null;
                }
                if (c0Var.f٤٢٥٩b == view) {
                    break;
                }
                i10++;
            } else {
                i10 = -1;
                break;
            }
        }
        if (i10 < 0) {
            return null;
        }
        if (z10) {
            arrayList2 = this.f٤٣١٨u;
        } else {
            arrayList2 = this.f٤٣١٧t;
        }
        return (c0) arrayList2.get(i10);
    }
}
