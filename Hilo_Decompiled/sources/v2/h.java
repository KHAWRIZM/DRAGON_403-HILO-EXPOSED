package v2;

import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.d1;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import v2.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class h implements c.InterfaceC٠٢٣٧c {

    /* renamed from: a, reason: collision with root package name */
    float f١٨٣٧٠a;

    /* renamed from: b, reason: collision with root package name */
    float f١٨٣٧١b;

    /* renamed from: c, reason: collision with root package name */
    boolean f١٨٣٧٢c;

    /* renamed from: d, reason: collision with root package name */
    final Object f١٨٣٧٣d;

    /* renamed from: e, reason: collision with root package name */
    final v2.i f١٨٣٧٤e;

    /* renamed from: f, reason: collision with root package name */
    boolean f١٨٣٧٥f;

    /* renamed from: g, reason: collision with root package name */
    float f١٨٣٧٦g;

    /* renamed from: h, reason: collision with root package name */
    float f١٨٣٧٧h;

    /* renamed from: i, reason: collision with root package name */
    private long f١٨٣٧٨i;

    /* renamed from: j, reason: collision with root package name */
    private float f١٨٣٧٩j;

    /* renamed from: k, reason: collision with root package name */
    private final ArrayList f١٨٣٨٠k;

    /* renamed from: l, reason: collision with root package name */
    private final ArrayList f١٨٣٨١l;

    /* renamed from: m, reason: collision with root package name */
    private v2.c f١٨٣٨٢m;

    /* renamed from: n, reason: collision with root package name */
    public static final s f١٨٣٥٧n = new g("translationX");

    /* renamed from: o, reason: collision with root package name */
    public static final s f١٨٣٥٨o = new C٠٢٣٨h("translationY");

    /* renamed from: p, reason: collision with root package name */
    public static final s f١٨٣٥٩p = new i("translationZ");

    /* renamed from: q, reason: collision with root package name */
    public static final s f١٨٣٦٠q = new j("scaleX");

    /* renamed from: r, reason: collision with root package name */
    public static final s f١٨٣٦١r = new k("scaleY");

    /* renamed from: s, reason: collision with root package name */
    public static final s f١٨٣٦٢s = new l("rotation");

    /* renamed from: t, reason: collision with root package name */
    public static final s f١٨٣٦٣t = new m("rotationX");

    /* renamed from: u, reason: collision with root package name */
    public static final s f١٨٣٦٤u = new n("rotationY");

    /* renamed from: v, reason: collision with root package name */
    public static final s f١٨٣٦٥v = new o("x");

    /* renamed from: w, reason: collision with root package name */
    public static final s f١٨٣٦٦w = new a("y");

    /* renamed from: x, reason: collision with root package name */
    public static final s f١٨٣٦٧x = new b("z");

    /* renamed from: y, reason: collision with root package name */
    public static final s f١٨٣٦٨y = new c("alpha");

    /* renamed from: z, reason: collision with root package name */
    public static final s f١٨٣٦٩z = new d("scrollX");
    public static final s A = new e("scrollY");

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a extends s {
        a(String str) {
            super(str, null);
        }

        @Override // v2.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getY();
        }

        @Override // v2.i
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setY(f10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b extends s {
        b(String str) {
            super(str, null);
        }

        @Override // v2.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return d1.Q(view);
        }

        @Override // v2.i
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            d1.M0(view, f10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class c extends s {
        c(String str) {
            super(str, null);
        }

        @Override // v2.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getAlpha();
        }

        @Override // v2.i
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setAlpha(f10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class d extends s {
        d(String str) {
            super(str, null);
        }

        @Override // v2.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollX();
        }

        @Override // v2.i
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setScrollX((int) f10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class e extends s {
        e(String str) {
            super(str, null);
        }

        @Override // v2.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollY();
        }

        @Override // v2.i
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setScrollY((int) f10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class f extends v2.i {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ v2.j f١٨٣٨٣b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, v2.j jVar) {
            super(str);
            this.f١٨٣٨٣b = jVar;
        }

        @Override // v2.i
        public float a(Object obj) {
            return this.f١٨٣٨٣b.a();
        }

        @Override // v2.i
        public void b(Object obj, float f10) {
            this.f١٨٣٨٣b.b(f10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class g extends s {
        g(String str) {
            super(str, null);
        }

        @Override // v2.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationX();
        }

        @Override // v2.i
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setTranslationX(f10);
        }
    }

    /* renamed from: v2.h$h, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class C٠٢٣٨h extends s {
        C٠٢٣٨h(String str) {
            super(str, null);
        }

        @Override // v2.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationY();
        }

        @Override // v2.i
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setTranslationY(f10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class i extends s {
        i(String str) {
            super(str, null);
        }

        @Override // v2.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return d1.N(view);
        }

        @Override // v2.i
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            d1.K0(view, f10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class j extends s {
        j(String str) {
            super(str, null);
        }

        @Override // v2.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleX();
        }

        @Override // v2.i
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setScaleX(f10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class k extends s {
        k(String str) {
            super(str, null);
        }

        @Override // v2.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleY();
        }

        @Override // v2.i
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setScaleY(f10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class l extends s {
        l(String str) {
            super(str, null);
        }

        @Override // v2.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotation();
        }

        @Override // v2.i
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setRotation(f10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class m extends s {
        m(String str) {
            super(str, null);
        }

        @Override // v2.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationX();
        }

        @Override // v2.i
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setRotationX(f10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class n extends s {
        n(String str) {
            super(str, null);
        }

        @Override // v2.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationY();
        }

        @Override // v2.i
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setRotationY(f10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class o extends s {
        o(String str) {
            super(str, null);
        }

        @Override // v2.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getX();
        }

        @Override // v2.i
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setX(f10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class p {

        /* renamed from: a, reason: collision with root package name */
        float f١٨٣٨٥a;

        /* renamed from: b, reason: collision with root package name */
        float f١٨٣٨٦b;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface q {
        void a(h hVar, boolean z10, float f10, float f11);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface r {
        void h(h hVar, float f10, float f11);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class s extends v2.i {
        /* synthetic */ s(String str, g gVar) {
            this(str);
        }

        private s(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(v2.j jVar) {
        this.f١٨٣٧٠a = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٣٧١b = Float.MAX_VALUE;
        this.f١٨٣٧٢c = false;
        this.f١٨٣٧٥f = false;
        this.f١٨٣٧٦g = Float.MAX_VALUE;
        this.f١٨٣٧٧h = -Float.MAX_VALUE;
        this.f١٨٣٧٨i = 0L;
        this.f١٨٣٨٠k = new ArrayList();
        this.f١٨٣٨١l = new ArrayList();
        this.f١٨٣٧٣d = null;
        this.f١٨٣٧٤e = new f("FloatValueHolder", jVar);
        this.f١٨٣٧٩j = 1.0f;
    }

    private void d(boolean z10) {
        this.f١٨٣٧٥f = false;
        e().l(this);
        this.f١٨٣٧٨i = 0L;
        this.f١٨٣٧٢c = false;
        for (int i10 = 0; i10 < this.f١٨٣٨٠k.size(); i10++) {
            if (this.f١٨٣٨٠k.get(i10) != null) {
                ((q) this.f١٨٣٨٠k.get(i10)).a(this, z10, this.f١٨٣٧١b, this.f١٨٣٧٠a);
            }
        }
        j(this.f١٨٣٨٠k);
    }

    private float f() {
        return this.f١٨٣٧٤e.a(this.f١٨٣٧٣d);
    }

    private static void i(ArrayList arrayList, Object obj) {
        int indexOf = arrayList.indexOf(obj);
        if (indexOf >= 0) {
            arrayList.set(indexOf, null);
        }
    }

    private static void j(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void s() {
        if (!this.f١٨٣٧٥f) {
            this.f١٨٣٧٥f = true;
            if (!this.f١٨٣٧٢c) {
                this.f١٨٣٧١b = f();
            }
            float f10 = this.f١٨٣٧١b;
            if (f10 <= this.f١٨٣٧٦g && f10 >= this.f١٨٣٧٧h) {
                e().d(this, 0L);
                return;
            }
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
    }

    @Override // v2.c.InterfaceC٠٢٣٧c
    public boolean a(long j10) {
        long j11;
        long j12 = this.f١٨٣٧٨i;
        if (j12 == 0) {
            this.f١٨٣٧٨i = j10;
            n(this.f١٨٣٧١b);
            return false;
        }
        long j13 = j10 - j12;
        this.f١٨٣٧٨i = j10;
        float g10 = e().g();
        if (g10 == DownloadProgress.UNKNOWN_PROGRESS) {
            j11 = 2147483647L;
        } else {
            j11 = ((float) j13) / g10;
        }
        boolean t10 = t(j11);
        float min = Math.min(this.f١٨٣٧١b, this.f١٨٣٧٦g);
        this.f١٨٣٧١b = min;
        float max = Math.max(min, this.f١٨٣٧٧h);
        this.f١٨٣٧١b = max;
        n(max);
        if (t10) {
            d(false);
        }
        return t10;
    }

    public h b(q qVar) {
        if (!this.f١٨٣٨٠k.contains(qVar)) {
            this.f١٨٣٨٠k.add(qVar);
        }
        return this;
    }

    public h c(r rVar) {
        if (!h()) {
            if (!this.f١٨٣٨١l.contains(rVar)) {
                this.f١٨٣٨١l.add(rVar);
            }
            return this;
        }
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    }

    public v2.c e() {
        v2.c cVar = this.f١٨٣٨٢m;
        if (cVar == null) {
            return v2.c.h();
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float g() {
        return this.f١٨٣٧٩j * 0.75f;
    }

    public boolean h() {
        return this.f١٨٣٧٥f;
    }

    public h k(float f10) {
        this.f١٨٣٧٦g = f10;
        return this;
    }

    public h l(float f10) {
        this.f١٨٣٧٧h = f10;
        return this;
    }

    public h m(float f10) {
        if (f10 > DownloadProgress.UNKNOWN_PROGRESS) {
            this.f١٨٣٧٩j = f10;
            q(f10 * 0.75f);
            return this;
        }
        throw new IllegalArgumentException("Minimum visible change must be positive.");
    }

    void n(float f10) {
        this.f١٨٣٧٤e.b(this.f١٨٣٧٣d, f10);
        for (int i10 = 0; i10 < this.f١٨٣٨١l.size(); i10++) {
            if (this.f١٨٣٨١l.get(i10) != null) {
                ((r) this.f١٨٣٨١l.get(i10)).h(this, this.f١٨٣٧١b, this.f١٨٣٧٠a);
            }
        }
        j(this.f١٨٣٨١l);
    }

    public h o(float f10) {
        this.f١٨٣٧١b = f10;
        this.f١٨٣٧٢c = true;
        return this;
    }

    public h p(float f10) {
        this.f١٨٣٧٠a = f10;
        return this;
    }

    abstract void q(float f10);

    public void r() {
        if (e().j()) {
            if (!this.f١٨٣٧٥f) {
                s();
                return;
            }
            return;
        }
        throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
    }

    public void removeEndListener(q qVar) {
        i(this.f١٨٣٨٠k, qVar);
    }

    public void removeUpdateListener(r rVar) {
        i(this.f١٨٣٨١l, rVar);
    }

    abstract boolean t(long j10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Object obj, v2.i iVar) {
        this.f١٨٣٧٠a = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٣٧١b = Float.MAX_VALUE;
        this.f١٨٣٧٢c = false;
        this.f١٨٣٧٥f = false;
        this.f١٨٣٧٦g = Float.MAX_VALUE;
        this.f١٨٣٧٧h = -Float.MAX_VALUE;
        this.f١٨٣٧٨i = 0L;
        this.f١٨٣٨٠k = new ArrayList();
        this.f١٨٣٨١l = new ArrayList();
        this.f١٨٣٧٣d = obj;
        this.f١٨٣٧٤e = iVar;
        if (iVar != f١٨٣٦٢s && iVar != f١٨٣٦٣t && iVar != f١٨٣٦٤u) {
            if (iVar == f١٨٣٦٨y) {
                this.f١٨٣٧٩j = 0.00390625f;
                return;
            } else if (iVar != f١٨٣٦٠q && iVar != f١٨٣٦١r) {
                this.f١٨٣٧٩j = 1.0f;
                return;
            } else {
                this.f١٨٣٧٩j = 0.002f;
                return;
            }
        }
        this.f١٨٣٧٩j = 0.1f;
    }
}
