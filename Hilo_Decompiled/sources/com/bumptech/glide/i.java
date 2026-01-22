package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import f5.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class i extends c5.a implements Cloneable {
    protected static final c5.h O = (c5.h) ((c5.h) ((c5.h) new c5.h().g(o4.j.f١٦٦٣٨c)).Y(f.LOW)).h0(true);
    private final Context A;

    /* renamed from: B, reason: collision with root package name */
    private final j f٧٢٧٩B;
    private final Class C;
    private final Glide D;
    private final c E;
    private k F;
    private Object G;
    private List H;
    private i I;
    private i J;
    private Float K;
    private boolean L = true;
    private boolean M;
    private boolean N;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f٧٢٨٠a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f٧٢٨١b;

        static {
            int[] iArr = new int[f.values().length];
            f٧٢٨١b = iArr;
            try {
                iArr[f.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f٧٢٨١b[f.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f٧٢٨١b[f.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f٧٢٨١b[f.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f٧٢٨٠a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f٧٢٨٠a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f٧٢٨٠a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f٧٢٨٠a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f٧٢٨٠a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f٧٢٨٠a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f٧٢٨٠a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f٧٢٨٠a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(Glide glide, j jVar, Class cls, Context context) {
        this.D = glide;
        this.f٧٢٧٩B = jVar;
        this.C = cls;
        this.A = context;
        this.F = jVar.l(cls);
        this.E = glide.getGlideContext();
        y0(jVar.j());
        a(jVar.k());
    }

    private com.bumptech.glide.request.target.j B0(com.bumptech.glide.request.target.j jVar, c5.g gVar, c5.a aVar, Executor executor) {
        f5.k.d(jVar);
        if (this.M) {
            c5.d s02 = s0(jVar, gVar, aVar, executor);
            c5.d request = jVar.getRequest();
            if (s02.f(request) && !E0(aVar, request)) {
                if (!((c5.d) f5.k.d(request)).isRunning()) {
                    request.j();
                }
                return jVar;
            }
            this.f٧٢٧٩B.f(jVar);
            jVar.setRequest(s02);
            this.f٧٢٧٩B.w(jVar, s02);
            return jVar;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    private boolean E0(c5.a aVar, c5.d dVar) {
        if (!aVar.G() && dVar.g()) {
            return true;
        }
        return false;
    }

    private i L0(Object obj) {
        if (E()) {
            return clone().L0(obj);
        }
        this.G = obj;
        this.M = true;
        return (i) d0();
    }

    private i M0(Uri uri, i iVar) {
        if (uri != null && "android.resource".equals(uri.getScheme())) {
            return r0(iVar);
        }
        return iVar;
    }

    private c5.d N0(Object obj, com.bumptech.glide.request.target.j jVar, c5.g gVar, c5.a aVar, c5.e eVar, k kVar, f fVar, int i10, int i11, Executor executor) {
        Context context = this.A;
        c cVar = this.E;
        return c5.j.x(context, cVar, obj, this.G, this.C, aVar, i10, i11, fVar, jVar, gVar, this.H, eVar, cVar.f(), kVar.b(), executor);
    }

    private i r0(i iVar) {
        return (i) ((i) iVar.i0(this.A.getTheme())).f0(e5.a.a(this.A));
    }

    private c5.d s0(com.bumptech.glide.request.target.j jVar, c5.g gVar, c5.a aVar, Executor executor) {
        return t0(new Object(), jVar, gVar, null, this.F, aVar.w(), aVar.t(), aVar.s(), aVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private c5.d t0(Object obj, com.bumptech.glide.request.target.j jVar, c5.g gVar, c5.e eVar, k kVar, f fVar, int i10, int i11, c5.a aVar, Executor executor) {
        c5.e eVar2;
        c5.e eVar3;
        if (this.J != null) {
            eVar3 = new c5.b(obj, eVar);
            eVar2 = eVar3;
        } else {
            eVar2 = null;
            eVar3 = eVar;
        }
        c5.d u02 = u0(obj, jVar, gVar, eVar3, kVar, fVar, i10, i11, aVar, executor);
        if (eVar2 == null) {
            return u02;
        }
        int t10 = this.J.t();
        int s10 = this.J.s();
        if (l.v(i10, i11) && !this.J.O()) {
            t10 = aVar.t();
            s10 = aVar.s();
        }
        i iVar = this.J;
        c5.b bVar = eVar2;
        bVar.o(u02, iVar.t0(obj, jVar, gVar, bVar, iVar.F, iVar.w(), t10, s10, this.J, executor));
        return bVar;
    }

    private c5.d u0(Object obj, com.bumptech.glide.request.target.j jVar, c5.g gVar, c5.e eVar, k kVar, f fVar, int i10, int i11, c5.a aVar, Executor executor) {
        k kVar2;
        f x02;
        i iVar = this.I;
        if (iVar != null) {
            if (!this.N) {
                k kVar3 = iVar.F;
                if (iVar.L) {
                    kVar2 = kVar;
                } else {
                    kVar2 = kVar3;
                }
                if (iVar.H()) {
                    x02 = this.I.w();
                } else {
                    x02 = x0(fVar);
                }
                f fVar2 = x02;
                int t10 = this.I.t();
                int s10 = this.I.s();
                if (l.v(i10, i11) && !this.I.O()) {
                    t10 = aVar.t();
                    s10 = aVar.s();
                }
                c5.k kVar4 = new c5.k(obj, eVar);
                c5.d N0 = N0(obj, jVar, gVar, aVar, kVar4, kVar, fVar, i10, i11, executor);
                this.N = true;
                i iVar2 = this.I;
                c5.d t02 = iVar2.t0(obj, jVar, gVar, kVar4, kVar2, fVar2, t10, s10, iVar2, executor);
                this.N = false;
                kVar4.n(N0, t02);
                return kVar4;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        if (this.K != null) {
            c5.k kVar5 = new c5.k(obj, eVar);
            kVar5.n(N0(obj, jVar, gVar, aVar, kVar5, kVar, fVar, i10, i11, executor), N0(obj, jVar, gVar, aVar.clone().g0(this.K.floatValue()), kVar5, kVar, x0(fVar), i10, i11, executor));
            return kVar5;
        }
        return N0(obj, jVar, gVar, aVar, eVar, kVar, fVar, i10, i11, executor);
    }

    private f x0(f fVar) {
        int i10 = a.f٧٢٨١b[fVar.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3 && i10 != 4) {
                    throw new IllegalArgumentException("unknown priority: " + w());
                }
                return f.IMMEDIATE;
            }
            return f.HIGH;
        }
        return f.NORMAL;
    }

    private void y0(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            p0((c5.g) it.next());
        }
    }

    public com.bumptech.glide.request.target.j A0(com.bumptech.glide.request.target.j jVar) {
        return C0(jVar, null, f5.e.b());
    }

    com.bumptech.glide.request.target.j C0(com.bumptech.glide.request.target.j jVar, c5.g gVar, Executor executor) {
        return B0(jVar, gVar, this, executor);
    }

    public com.bumptech.glide.request.target.k D0(ImageView imageView) {
        c5.a aVar;
        l.b();
        f5.k.d(imageView);
        if (!N() && L() && imageView.getScaleType() != null) {
            switch (a.f٧٢٨٠a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVar = clone().Q();
                    break;
                case 2:
                    aVar = clone().R();
                    break;
                case 3:
                case 4:
                case 5:
                    aVar = clone().S();
                    break;
                case 6:
                    aVar = clone().R();
                    break;
            }
            return (com.bumptech.glide.request.target.k) B0(this.E.a(imageView, this.C), null, aVar, f5.e.b());
        }
        aVar = this;
        return (com.bumptech.glide.request.target.k) B0(this.E.a(imageView, this.C), null, aVar, f5.e.b());
    }

    public i F0(c5.g gVar) {
        if (E()) {
            return clone().F0(gVar);
        }
        this.H = null;
        return p0(gVar);
    }

    public i G0(Bitmap bitmap) {
        return L0(bitmap).a(c5.h.r0(o4.j.f١٦٦٣٧b));
    }

    public i H0(Uri uri) {
        return M0(uri, L0(uri));
    }

    public i I0(Integer num) {
        return r0(L0(num));
    }

    public i J0(Object obj) {
        return L0(obj);
    }

    public i K0(String str) {
        return L0(str);
    }

    public com.bumptech.glide.request.target.j O0() {
        return P0(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public com.bumptech.glide.request.target.j P0(int i10, int i11) {
        return A0(com.bumptech.glide.request.target.h.b(this.f٧٢٧٩B, i10, i11));
    }

    public c5.c Q0() {
        return R0(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public c5.c R0(int i10, int i11) {
        c5.f fVar = new c5.f(i10, i11);
        return (c5.c) C0(fVar, fVar, f5.e.a());
    }

    public i S0(i iVar) {
        if (E()) {
            return clone().S0(iVar);
        }
        this.I = iVar;
        return (i) d0();
    }

    public i T0(k kVar) {
        if (E()) {
            return clone().T0(kVar);
        }
        this.F = (k) f5.k.d(kVar);
        this.L = false;
        return (i) d0();
    }

    @Override // c5.a
    public boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (!super.equals(iVar) || !Objects.equals(this.C, iVar.C) || !this.F.equals(iVar.F) || !Objects.equals(this.G, iVar.G) || !Objects.equals(this.H, iVar.H) || !Objects.equals(this.I, iVar.I) || !Objects.equals(this.J, iVar.J) || !Objects.equals(this.K, iVar.K) || this.L != iVar.L || this.M != iVar.M) {
            return false;
        }
        return true;
    }

    @Override // c5.a
    public int hashCode() {
        return l.r(this.M, l.r(this.L, l.q(this.K, l.q(this.J, l.q(this.I, l.q(this.H, l.q(this.G, l.q(this.F, l.q(this.C, super.hashCode())))))))));
    }

    public i p0(c5.g gVar) {
        if (E()) {
            return clone().p0(gVar);
        }
        if (gVar != null) {
            if (this.H == null) {
                this.H = new ArrayList();
            }
            this.H.add(gVar);
        }
        return (i) d0();
    }

    @Override // c5.a
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public i a(c5.a aVar) {
        f5.k.d(aVar);
        return (i) super.a(aVar);
    }

    @Override // c5.a
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public i clone() {
        i iVar = (i) super.clone();
        iVar.F = iVar.F.clone();
        if (iVar.H != null) {
            iVar.H = new ArrayList(iVar.H);
        }
        i iVar2 = iVar.I;
        if (iVar2 != null) {
            iVar.I = iVar2.clone();
        }
        i iVar3 = iVar.J;
        if (iVar3 != null) {
            iVar.J = iVar3.clone();
        }
        return iVar;
    }

    public i w0(i iVar) {
        if (E()) {
            return clone().w0(iVar);
        }
        this.J = iVar;
        return (i) d0();
    }

    public c5.c z0(int i10, int i11) {
        return R0(i10, i11);
    }
}
