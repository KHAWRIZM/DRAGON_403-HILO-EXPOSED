package c5;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.amazonaws.services.s3.internal.Constants;
import com.liulishuo.okdownload.DownloadTask;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f5.l;
import java.util.Map;
import m4.m;
import v4.o;
import v4.w;
import v4.y;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private int f٥٨٣٥a;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f٥٨٣٩e;

    /* renamed from: f, reason: collision with root package name */
    private int f٥٨٤٠f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f٥٨٤١g;

    /* renamed from: h, reason: collision with root package name */
    private int f٥٨٤٢h;

    /* renamed from: m, reason: collision with root package name */
    private boolean f٥٨٤٧m;

    /* renamed from: o, reason: collision with root package name */
    private Drawable f٥٨٤٩o;

    /* renamed from: p, reason: collision with root package name */
    private int f٥٨٥٠p;

    /* renamed from: t, reason: collision with root package name */
    private boolean f٥٨٥٤t;

    /* renamed from: u, reason: collision with root package name */
    private Resources.Theme f٥٨٥٥u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f٥٨٥٦v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f٥٨٥٧w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f٥٨٥٨x;

    /* renamed from: z, reason: collision with root package name */
    private boolean f٥٨٦٠z;

    /* renamed from: b, reason: collision with root package name */
    private float f٥٨٣٦b = 1.0f;

    /* renamed from: c, reason: collision with root package name */
    private o4.j f٥٨٣٧c = o4.j.f١٦٦٤٠e;

    /* renamed from: d, reason: collision with root package name */
    private com.bumptech.glide.f f٥٨٣٨d = com.bumptech.glide.f.NORMAL;

    /* renamed from: i, reason: collision with root package name */
    private boolean f٥٨٤٣i = true;

    /* renamed from: j, reason: collision with root package name */
    private int f٥٨٤٤j = -1;

    /* renamed from: k, reason: collision with root package name */
    private int f٥٨٤٥k = -1;

    /* renamed from: l, reason: collision with root package name */
    private m4.f f٥٨٤٦l = e5.c.a();

    /* renamed from: n, reason: collision with root package name */
    private boolean f٥٨٤٨n = true;

    /* renamed from: q, reason: collision with root package name */
    private m4.i f٥٨٥١q = new m4.i();

    /* renamed from: r, reason: collision with root package name */
    private Map f٥٨٥٢r = new f5.b();

    /* renamed from: s, reason: collision with root package name */
    private Class f٥٨٥٣s = Object.class;

    /* renamed from: y, reason: collision with root package name */
    private boolean f٥٨٥٩y = true;

    private boolean J(int i10) {
        return K(this.f٥٨٣٥a, i10);
    }

    private static boolean K(int i10, int i11) {
        if ((i10 & i11) != 0) {
            return true;
        }
        return false;
    }

    private a T(o oVar, m mVar) {
        return b0(oVar, mVar, false);
    }

    private a a0(o oVar, m mVar) {
        return b0(oVar, mVar, true);
    }

    private a b0(o oVar, m mVar, boolean z10) {
        a V;
        if (z10) {
            V = m0(oVar, mVar);
        } else {
            V = V(oVar, mVar);
        }
        V.f٥٨٥٩y = true;
        return V;
    }

    public final Resources.Theme A() {
        return this.f٥٨٥٥u;
    }

    public final Map B() {
        return this.f٥٨٥٢r;
    }

    public final boolean C() {
        return this.f٥٨٦٠z;
    }

    public final boolean D() {
        return this.f٥٨٥٧w;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean E() {
        return this.f٥٨٥٦v;
    }

    public final boolean F(a aVar) {
        if (Float.compare(aVar.f٥٨٣٦b, this.f٥٨٣٦b) == 0 && this.f٥٨٤٠f == aVar.f٥٨٤٠f && l.e(this.f٥٨٣٩e, aVar.f٥٨٣٩e) && this.f٥٨٤٢h == aVar.f٥٨٤٢h && l.e(this.f٥٨٤١g, aVar.f٥٨٤١g) && this.f٥٨٥٠p == aVar.f٥٨٥٠p && l.e(this.f٥٨٤٩o, aVar.f٥٨٤٩o) && this.f٥٨٤٣i == aVar.f٥٨٤٣i && this.f٥٨٤٤j == aVar.f٥٨٤٤j && this.f٥٨٤٥k == aVar.f٥٨٤٥k && this.f٥٨٤٧m == aVar.f٥٨٤٧m && this.f٥٨٤٨n == aVar.f٥٨٤٨n && this.f٥٨٥٧w == aVar.f٥٨٥٧w && this.f٥٨٥٨x == aVar.f٥٨٥٨x && this.f٥٨٣٧c.equals(aVar.f٥٨٣٧c) && this.f٥٨٣٨d == aVar.f٥٨٣٨d && this.f٥٨٥١q.equals(aVar.f٥٨٥١q) && this.f٥٨٥٢r.equals(aVar.f٥٨٥٢r) && this.f٥٨٥٣s.equals(aVar.f٥٨٥٣s) && l.e(this.f٥٨٤٦l, aVar.f٥٨٤٦l) && l.e(this.f٥٨٥٥u, aVar.f٥٨٥٥u)) {
            return true;
        }
        return false;
    }

    public final boolean G() {
        return this.f٥٨٤٣i;
    }

    public final boolean H() {
        return J(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean I() {
        return this.f٥٨٥٩y;
    }

    public final boolean L() {
        return this.f٥٨٤٨n;
    }

    public final boolean M() {
        return this.f٥٨٤٧m;
    }

    public final boolean N() {
        return J(2048);
    }

    public final boolean O() {
        return l.v(this.f٥٨٤٥k, this.f٥٨٤٤j);
    }

    public a P() {
        this.f٥٨٥٤t = true;
        return c0();
    }

    public a Q() {
        return V(o.f١٨٥٣٨e, new v4.k());
    }

    public a R() {
        return T(o.f١٨٥٣٧d, new v4.l());
    }

    public a S() {
        return T(o.f١٨٥٣٦c, new y());
    }

    public a U(Class cls, m mVar) {
        return j0(cls, mVar, false);
    }

    final a V(o oVar, m mVar) {
        if (this.f٥٨٥٦v) {
            return clone().V(oVar, mVar);
        }
        i(oVar);
        return l0(mVar, false);
    }

    public a W(int i10, int i11) {
        if (this.f٥٨٥٦v) {
            return clone().W(i10, i11);
        }
        this.f٥٨٤٥k = i10;
        this.f٥٨٤٤j = i11;
        this.f٥٨٣٥a |= 512;
        return d0();
    }

    public a X(int i10) {
        if (this.f٥٨٥٦v) {
            return clone().X(i10);
        }
        this.f٥٨٤٢h = i10;
        int i11 = this.f٥٨٣٥a | 128;
        this.f٥٨٤١g = null;
        this.f٥٨٣٥a = i11 & (-65);
        return d0();
    }

    public a Y(com.bumptech.glide.f fVar) {
        if (this.f٥٨٥٦v) {
            return clone().Y(fVar);
        }
        this.f٥٨٣٨d = (com.bumptech.glide.f) f5.k.d(fVar);
        this.f٥٨٣٥a |= 8;
        return d0();
    }

    a Z(m4.h hVar) {
        if (this.f٥٨٥٦v) {
            return clone().Z(hVar);
        }
        this.f٥٨٥١q.c(hVar);
        return d0();
    }

    public a a(a aVar) {
        if (this.f٥٨٥٦v) {
            return clone().a(aVar);
        }
        if (K(aVar.f٥٨٣٥a, 2)) {
            this.f٥٨٣٦b = aVar.f٥٨٣٦b;
        }
        if (K(aVar.f٥٨٣٥a, 262144)) {
            this.f٥٨٥٧w = aVar.f٥٨٥٧w;
        }
        if (K(aVar.f٥٨٣٥a, Constants.MB)) {
            this.f٥٨٦٠z = aVar.f٥٨٦٠z;
        }
        if (K(aVar.f٥٨٣٥a, 4)) {
            this.f٥٨٣٧c = aVar.f٥٨٣٧c;
        }
        if (K(aVar.f٥٨٣٥a, 8)) {
            this.f٥٨٣٨d = aVar.f٥٨٣٨d;
        }
        if (K(aVar.f٥٨٣٥a, 16)) {
            this.f٥٨٣٩e = aVar.f٥٨٣٩e;
            this.f٥٨٤٠f = 0;
            this.f٥٨٣٥a &= -33;
        }
        if (K(aVar.f٥٨٣٥a, 32)) {
            this.f٥٨٤٠f = aVar.f٥٨٤٠f;
            this.f٥٨٣٩e = null;
            this.f٥٨٣٥a &= -17;
        }
        if (K(aVar.f٥٨٣٥a, 64)) {
            this.f٥٨٤١g = aVar.f٥٨٤١g;
            this.f٥٨٤٢h = 0;
            this.f٥٨٣٥a &= -129;
        }
        if (K(aVar.f٥٨٣٥a, 128)) {
            this.f٥٨٤٢h = aVar.f٥٨٤٢h;
            this.f٥٨٤١g = null;
            this.f٥٨٣٥a &= -65;
        }
        if (K(aVar.f٥٨٣٥a, 256)) {
            this.f٥٨٤٣i = aVar.f٥٨٤٣i;
        }
        if (K(aVar.f٥٨٣٥a, 512)) {
            this.f٥٨٤٥k = aVar.f٥٨٤٥k;
            this.f٥٨٤٤j = aVar.f٥٨٤٤j;
        }
        if (K(aVar.f٥٨٣٥a, 1024)) {
            this.f٥٨٤٦l = aVar.f٥٨٤٦l;
        }
        if (K(aVar.f٥٨٣٥a, 4096)) {
            this.f٥٨٥٣s = aVar.f٥٨٥٣s;
        }
        if (K(aVar.f٥٨٣٥a, 8192)) {
            this.f٥٨٤٩o = aVar.f٥٨٤٩o;
            this.f٥٨٥٠p = 0;
            this.f٥٨٣٥a &= -16385;
        }
        if (K(aVar.f٥٨٣٥a, DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE)) {
            this.f٥٨٥٠p = aVar.f٥٨٥٠p;
            this.f٥٨٤٩o = null;
            this.f٥٨٣٥a &= -8193;
        }
        if (K(aVar.f٥٨٣٥a, 32768)) {
            this.f٥٨٥٥u = aVar.f٥٨٥٥u;
        }
        if (K(aVar.f٥٨٣٥a, 65536)) {
            this.f٥٨٤٨n = aVar.f٥٨٤٨n;
        }
        if (K(aVar.f٥٨٣٥a, anetwork.channel.unified.e.MAX_RSP_BUFFER_LENGTH)) {
            this.f٥٨٤٧m = aVar.f٥٨٤٧m;
        }
        if (K(aVar.f٥٨٣٥a, 2048)) {
            this.f٥٨٥٢r.putAll(aVar.f٥٨٥٢r);
            this.f٥٨٥٩y = aVar.f٥٨٥٩y;
        }
        if (K(aVar.f٥٨٣٥a, anet.channel.bytes.a.MAX_POOL_SIZE)) {
            this.f٥٨٥٨x = aVar.f٥٨٥٨x;
        }
        if (!this.f٥٨٤٨n) {
            this.f٥٨٥٢r.clear();
            int i10 = this.f٥٨٣٥a;
            this.f٥٨٤٧m = false;
            this.f٥٨٣٥a = i10 & (-133121);
            this.f٥٨٥٩y = true;
        }
        this.f٥٨٣٥a |= aVar.f٥٨٣٥a;
        this.f٥٨٥١q.b(aVar.f٥٨٥١q);
        return d0();
    }

    public a b() {
        if (this.f٥٨٥٤t && !this.f٥٨٥٦v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.f٥٨٥٦v = true;
        return P();
    }

    public a c() {
        return m0(o.f١٨٥٣٨e, new v4.k());
    }

    public a d() {
        return a0(o.f١٨٥٣٧d, new v4.l());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final a d0() {
        if (!this.f٥٨٥٤t) {
            return c0();
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    @Override // 
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a clone() {
        try {
            a aVar = (a) super.clone();
            m4.i iVar = new m4.i();
            aVar.f٥٨٥١q = iVar;
            iVar.b(this.f٥٨٥١q);
            f5.b bVar = new f5.b();
            aVar.f٥٨٥٢r = bVar;
            bVar.putAll(this.f٥٨٥٢r);
            aVar.f٥٨٥٤t = false;
            aVar.f٥٨٥٦v = false;
            return aVar;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    public a e0(m4.h hVar, Object obj) {
        if (this.f٥٨٥٦v) {
            return clone().e0(hVar, obj);
        }
        f5.k.d(hVar);
        f5.k.d(obj);
        this.f٥٨٥١q.d(hVar, obj);
        return d0();
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return F((a) obj);
        }
        return false;
    }

    public a f(Class cls) {
        if (this.f٥٨٥٦v) {
            return clone().f(cls);
        }
        this.f٥٨٥٣s = (Class) f5.k.d(cls);
        this.f٥٨٣٥a |= 4096;
        return d0();
    }

    public a f0(m4.f fVar) {
        if (this.f٥٨٥٦v) {
            return clone().f0(fVar);
        }
        this.f٥٨٤٦l = (m4.f) f5.k.d(fVar);
        this.f٥٨٣٥a |= 1024;
        return d0();
    }

    public a g(o4.j jVar) {
        if (this.f٥٨٥٦v) {
            return clone().g(jVar);
        }
        this.f٥٨٣٧c = (o4.j) f5.k.d(jVar);
        this.f٥٨٣٥a |= 4;
        return d0();
    }

    public a g0(float f10) {
        if (this.f٥٨٥٦v) {
            return clone().g0(f10);
        }
        if (f10 >= DownloadProgress.UNKNOWN_PROGRESS && f10 <= 1.0f) {
            this.f٥٨٣٦b = f10;
            this.f٥٨٣٥a |= 2;
            return d0();
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    public a h() {
        if (this.f٥٨٥٦v) {
            return clone().h();
        }
        this.f٥٨٥٢r.clear();
        int i10 = this.f٥٨٣٥a;
        this.f٥٨٤٧m = false;
        this.f٥٨٤٨n = false;
        this.f٥٨٣٥a = (i10 & (-133121)) | 65536;
        this.f٥٨٥٩y = true;
        return d0();
    }

    public a h0(boolean z10) {
        if (this.f٥٨٥٦v) {
            return clone().h0(true);
        }
        this.f٥٨٤٣i = !z10;
        this.f٥٨٣٥a |= 256;
        return d0();
    }

    public int hashCode() {
        return l.q(this.f٥٨٥٥u, l.q(this.f٥٨٤٦l, l.q(this.f٥٨٥٣s, l.q(this.f٥٨٥٢r, l.q(this.f٥٨٥١q, l.q(this.f٥٨٣٨d, l.q(this.f٥٨٣٧c, l.r(this.f٥٨٥٨x, l.r(this.f٥٨٥٧w, l.r(this.f٥٨٤٨n, l.r(this.f٥٨٤٧m, l.p(this.f٥٨٤٥k, l.p(this.f٥٨٤٤j, l.r(this.f٥٨٤٣i, l.q(this.f٥٨٤٩o, l.p(this.f٥٨٥٠p, l.q(this.f٥٨٤١g, l.p(this.f٥٨٤٢h, l.q(this.f٥٨٣٩e, l.p(this.f٥٨٤٠f, l.m(this.f٥٨٣٦b)))))))))))))))))))));
    }

    public a i(o oVar) {
        return e0(o.f١٨٥٤١h, f5.k.d(oVar));
    }

    public a i0(Resources.Theme theme) {
        if (this.f٥٨٥٦v) {
            return clone().i0(theme);
        }
        this.f٥٨٥٥u = theme;
        if (theme != null) {
            this.f٥٨٣٥a |= 32768;
            return e0(com.bumptech.glide.load.resource.drawable.k.f٧٤٦٤b, theme);
        }
        this.f٥٨٣٥a &= -32769;
        return Z(com.bumptech.glide.load.resource.drawable.k.f٧٤٦٤b);
    }

    public a j(int i10) {
        if (this.f٥٨٥٦v) {
            return clone().j(i10);
        }
        this.f٥٨٤٠f = i10;
        int i11 = this.f٥٨٣٥a | 32;
        this.f٥٨٣٩e = null;
        this.f٥٨٣٥a = i11 & (-17);
        return d0();
    }

    a j0(Class cls, m mVar, boolean z10) {
        if (this.f٥٨٥٦v) {
            return clone().j0(cls, mVar, z10);
        }
        f5.k.d(cls);
        f5.k.d(mVar);
        this.f٥٨٥٢r.put(cls, mVar);
        int i10 = this.f٥٨٣٥a;
        this.f٥٨٤٨n = true;
        this.f٥٨٣٥a = 67584 | i10;
        this.f٥٨٥٩y = false;
        if (z10) {
            this.f٥٨٣٥a = i10 | 198656;
            this.f٥٨٤٧m = true;
        }
        return d0();
    }

    public a k() {
        return a0(o.f١٨٥٣٦c, new y());
    }

    public a k0(m mVar) {
        return l0(mVar, true);
    }

    public final o4.j l() {
        return this.f٥٨٣٧c;
    }

    a l0(m mVar, boolean z10) {
        if (this.f٥٨٥٦v) {
            return clone().l0(mVar, z10);
        }
        w wVar = new w(mVar, z10);
        j0(Bitmap.class, mVar, z10);
        j0(Drawable.class, wVar, z10);
        j0(BitmapDrawable.class, wVar.a(), z10);
        j0(com.bumptech.glide.load.resource.gif.c.class, new com.bumptech.glide.load.resource.gif.f(mVar), z10);
        return d0();
    }

    public final int m() {
        return this.f٥٨٤٠f;
    }

    final a m0(o oVar, m mVar) {
        if (this.f٥٨٥٦v) {
            return clone().m0(oVar, mVar);
        }
        i(oVar);
        return k0(mVar);
    }

    public final Drawable n() {
        return this.f٥٨٣٩e;
    }

    public a n0(m... mVarArr) {
        if (mVarArr.length > 1) {
            return l0(new m4.g(mVarArr), true);
        }
        if (mVarArr.length == 1) {
            return k0(mVarArr[0]);
        }
        return d0();
    }

    public final Drawable o() {
        return this.f٥٨٤٩o;
    }

    public a o0(boolean z10) {
        if (this.f٥٨٥٦v) {
            return clone().o0(z10);
        }
        this.f٥٨٦٠z = z10;
        this.f٥٨٣٥a |= Constants.MB;
        return d0();
    }

    public final int p() {
        return this.f٥٨٥٠p;
    }

    public final boolean q() {
        return this.f٥٨٥٨x;
    }

    public final m4.i r() {
        return this.f٥٨٥١q;
    }

    public final int s() {
        return this.f٥٨٤٤j;
    }

    public final int t() {
        return this.f٥٨٤٥k;
    }

    public final Drawable u() {
        return this.f٥٨٤١g;
    }

    public final int v() {
        return this.f٥٨٤٢h;
    }

    public final com.bumptech.glide.f w() {
        return this.f٥٨٣٨d;
    }

    public final Class x() {
        return this.f٥٨٥٣s;
    }

    public final m4.f y() {
        return this.f٥٨٤٦l;
    }

    public final float z() {
        return this.f٥٨٣٦b;
    }

    private a c0() {
        return this;
    }
}
