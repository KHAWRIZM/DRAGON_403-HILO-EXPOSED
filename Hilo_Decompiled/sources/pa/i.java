package pa;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.HashMap;
import pa.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class i extends pa.a {

    /* renamed from: b, reason: collision with root package name */
    long f١٧٠٢٥b;

    /* renamed from: h, reason: collision with root package name */
    private long f١٧٠٣١h;

    /* renamed from: s, reason: collision with root package name */
    pa.g[] f١٧٠٤٢s;

    /* renamed from: t, reason: collision with root package name */
    HashMap f١٧٠٤٣t;

    /* renamed from: u, reason: collision with root package name */
    private static ThreadLocal f١٧٠١٩u = new ThreadLocal();

    /* renamed from: v, reason: collision with root package name */
    private static final ThreadLocal f١٧٠٢٠v = new a();

    /* renamed from: w, reason: collision with root package name */
    private static final ThreadLocal f١٧٠٢١w = new b();

    /* renamed from: x, reason: collision with root package name */
    private static final ThreadLocal f١٧٠٢٢x = new c();

    /* renamed from: y, reason: collision with root package name */
    private static final ThreadLocal f١٧٠٢٣y = new d();

    /* renamed from: z, reason: collision with root package name */
    private static final ThreadLocal f١٧٠٢٤z = new e();
    private static final Interpolator A = new AccelerateDecelerateInterpolator();

    /* renamed from: B, reason: collision with root package name */
    private static final h f١٧٠١٨B = new pa.d();
    private static final h C = new pa.b();
    private static long D = 10;

    /* renamed from: c, reason: collision with root package name */
    long f١٧٠٢٦c = -1;

    /* renamed from: d, reason: collision with root package name */
    private boolean f١٧٠٢٧d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f١٧٠٢٨e = 0;

    /* renamed from: f, reason: collision with root package name */
    private float f١٧٠٢٩f = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: g, reason: collision with root package name */
    private boolean f١٧٠٣٠g = false;

    /* renamed from: i, reason: collision with root package name */
    int f١٧٠٣٢i = 0;

    /* renamed from: j, reason: collision with root package name */
    private boolean f١٧٠٣٣j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f١٧٠٣٤k = false;

    /* renamed from: l, reason: collision with root package name */
    boolean f١٧٠٣٥l = false;

    /* renamed from: m, reason: collision with root package name */
    private long f١٧٠٣٦m = 300;

    /* renamed from: n, reason: collision with root package name */
    private long f١٧٠٣٧n = 0;

    /* renamed from: o, reason: collision with root package name */
    private int f١٧٠٣٨o = 0;

    /* renamed from: p, reason: collision with root package name */
    private int f١٧٠٣٩p = 1;

    /* renamed from: q, reason: collision with root package name */
    private Interpolator f١٧٠٤٠q = A;

    /* renamed from: r, reason: collision with root package name */
    private ArrayList f١٧٠٤١r = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList initialValue() {
            return new ArrayList();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class b extends ThreadLocal {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList initialValue() {
            return new ArrayList();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class c extends ThreadLocal {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList initialValue() {
            return new ArrayList();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class d extends ThreadLocal {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList initialValue() {
            return new ArrayList();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class e extends ThreadLocal {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList initialValue() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class f extends Handler {
        private f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z10;
            ArrayList arrayList = (ArrayList) i.f١٧٠٢٠v.get();
            ArrayList arrayList2 = (ArrayList) i.f١٧٠٢٢x.get();
            int i10 = message.what;
            if (i10 != 0) {
                if (i10 == 1) {
                    z10 = true;
                } else {
                    return;
                }
            } else {
                ArrayList arrayList3 = (ArrayList) i.f١٧٠٢١w.get();
                if (arrayList.size() <= 0 && arrayList2.size() <= 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                while (arrayList3.size() > 0) {
                    ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    int size = arrayList4.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        i iVar = (i) arrayList4.get(i11);
                        if (iVar.f١٧٠٣٧n == 0) {
                            iVar.F();
                        } else {
                            arrayList2.add(iVar);
                        }
                    }
                }
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            ArrayList arrayList5 = (ArrayList) i.f١٧٠٢٤z.get();
            ArrayList arrayList6 = (ArrayList) i.f١٧٠٢٣y.get();
            int size2 = arrayList2.size();
            for (int i12 = 0; i12 < size2; i12++) {
                i iVar2 = (i) arrayList2.get(i12);
                if (iVar2.r(currentAnimationTimeMillis)) {
                    arrayList5.add(iVar2);
                }
            }
            int size3 = arrayList5.size();
            if (size3 > 0) {
                for (int i13 = 0; i13 < size3; i13++) {
                    i iVar3 = (i) arrayList5.get(i13);
                    iVar3.F();
                    iVar3.f١٧٠٣٣j = true;
                    arrayList2.remove(iVar3);
                }
                arrayList5.clear();
            }
            int size4 = arrayList.size();
            int i14 = 0;
            while (i14 < size4) {
                i iVar4 = (i) arrayList.get(i14);
                if (iVar4.p(currentAnimationTimeMillis)) {
                    arrayList6.add(iVar4);
                }
                if (arrayList.size() == size4) {
                    i14++;
                } else {
                    size4--;
                    arrayList6.remove(iVar4);
                }
            }
            if (arrayList6.size() > 0) {
                for (int i15 = 0; i15 < arrayList6.size(); i15++) {
                    ((i) arrayList6.get(i15)).s();
                }
                arrayList6.clear();
            }
            if (z10) {
                if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
                    sendEmptyMessageDelayed(1, Math.max(0L, i.D - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
                }
            }
        }

        /* synthetic */ f(a aVar) {
            this();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface g {
        void a(i iVar);
    }

    private void E(boolean z10) {
        if (Looper.myLooper() != null) {
            this.f١٧٠٢٧d = z10;
            this.f١٧٠٢٨e = 0;
            this.f١٧٠٣٢i = 0;
            this.f١٧٠٣٤k = true;
            this.f١٧٠٣٠g = false;
            ((ArrayList) f١٧٠٢١w.get()).add(this);
            if (this.f١٧٠٣٧n == 0) {
                y(v());
                this.f١٧٠٣٢i = 0;
                this.f١٧٠٣٣j = true;
                ArrayList arrayList = this.f١٦٩٨٥a;
                if (arrayList != null) {
                    ArrayList arrayList2 = (ArrayList) arrayList.clone();
                    int size = arrayList2.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        ((a.InterfaceC٠٢٠٩a) arrayList2.get(i10)).b(this);
                    }
                }
            }
            f fVar = (f) f١٧٠١٩u.get();
            if (fVar == null) {
                fVar = new f(null);
                f١٧٠١٩u.set(fVar);
            }
            fVar.sendEmptyMessage(0);
            return;
        }
        throw new AndroidRuntimeException("Animators may only be run on Looper threads");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        ArrayList arrayList;
        w();
        ((ArrayList) f١٧٠٢٠v.get()).add(this);
        if (this.f١٧٠٣٧n > 0 && (arrayList = this.f١٦٩٨٥a) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((a.InterfaceC٠٢٠٩a) arrayList2.get(i10)).b(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r(long j10) {
        if (!this.f١٧٠٣٠g) {
            this.f١٧٠٣٠g = true;
            this.f١٧٠٣١h = j10;
            return false;
        }
        long j11 = j10 - this.f١٧٠٣١h;
        long j12 = this.f١٧٠٣٧n;
        if (j11 > j12) {
            this.f١٧٠٢٥b = j10 - (j11 - j12);
            this.f١٧٠٣٢i = 1;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        ArrayList arrayList;
        ((ArrayList) f١٧٠٢٠v.get()).remove(this);
        ((ArrayList) f١٧٠٢١w.get()).remove(this);
        ((ArrayList) f١٧٠٢٢x.get()).remove(this);
        this.f١٧٠٣٢i = 0;
        if (this.f١٧٠٣٣j && (arrayList = this.f١٦٩٨٥a) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((a.InterfaceC٠٢٠٩a) arrayList2.get(i10)).c(this);
            }
        }
        this.f١٧٠٣٣j = false;
        this.f١٧٠٣٤k = false;
    }

    public static i x(float... fArr) {
        i iVar = new i();
        iVar.A(fArr);
        return iVar;
    }

    public void A(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            pa.g[] gVarArr = this.f١٧٠٤٢s;
            if (gVarArr != null && gVarArr.length != 0) {
                gVarArr[0].g(fArr);
            } else {
                C(pa.g.f("", fArr));
            }
            this.f١٧٠٣٥l = false;
        }
    }

    public void B(Interpolator interpolator) {
        if (interpolator != null) {
            this.f١٧٠٤٠q = interpolator;
        } else {
            this.f١٧٠٤٠q = new LinearInterpolator();
        }
    }

    public void C(pa.g... gVarArr) {
        int length = gVarArr.length;
        this.f١٧٠٤٢s = gVarArr;
        this.f١٧٠٤٣t = new HashMap(length);
        for (pa.g gVar : gVarArr) {
            this.f١٧٠٤٣t.put(gVar.d(), gVar);
        }
        this.f١٧٠٣٥l = false;
    }

    public void D() {
        E(false);
    }

    public void n(g gVar) {
        if (this.f١٧٠٤١r == null) {
            this.f١٧٠٤١r = new ArrayList();
        }
        this.f١٧٠٤١r.add(gVar);
    }

    void o(float f10) {
        float interpolation = this.f١٧٠٤٠q.getInterpolation(f10);
        this.f١٧٠٢٩f = interpolation;
        int length = this.f١٧٠٤٢s.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f١٧٠٤٢s[i10].a(interpolation);
        }
        ArrayList arrayList = this.f١٧٠٤١r;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((g) this.f١٧٠٤١r.get(i11)).a(this);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean p(long j10) {
        float f10;
        boolean z10 = true;
        if (this.f١٧٠٣٢i == 0) {
            this.f١٧٠٣٢i = 1;
            long j11 = this.f١٧٠٢٦c;
            if (j11 < 0) {
                this.f١٧٠٢٥b = j10;
            } else {
                this.f١٧٠٢٥b = j10 - j11;
                this.f١٧٠٢٦c = -1L;
            }
        }
        int i10 = this.f١٧٠٣٢i;
        if (i10 != 1 && i10 != 2) {
            return false;
        }
        long j12 = this.f١٧٠٣٦m;
        if (j12 > 0) {
            f10 = ((float) (j10 - this.f١٧٠٢٥b)) / ((float) j12);
        } else {
            f10 = 1.0f;
        }
        if (f10 >= 1.0f) {
            int i11 = this.f١٧٠٢٨e;
            int i12 = this.f١٧٠٣٨o;
            if (i11 >= i12 && i12 != -1) {
                f10 = Math.min(f10, 1.0f);
                if (this.f١٧٠٢٧d) {
                    f10 = 1.0f - f10;
                }
                o(f10);
                return z10;
            }
            ArrayList arrayList = this.f١٦٩٨٥a;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i13 = 0; i13 < size; i13++) {
                    ((a.InterfaceC٠٢٠٩a) this.f١٦٩٨٥a.get(i13)).a(this);
                }
            }
            if (this.f١٧٠٣٩p == 2) {
                this.f١٧٠٢٧d = !this.f١٧٠٢٧d;
            }
            this.f١٧٠٢٨e += (int) f10;
            f10 %= 1.0f;
            this.f١٧٠٢٥b += this.f١٧٠٣٦m;
        }
        z10 = false;
        if (this.f١٧٠٢٧d) {
        }
        o(f10);
        return z10;
    }

    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public i clone() {
        i iVar = (i) super.b();
        ArrayList arrayList = this.f١٧٠٤١r;
        if (arrayList != null) {
            iVar.f١٧٠٤١r = new ArrayList();
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                iVar.f١٧٠٤١r.add(arrayList.get(i10));
            }
        }
        iVar.f١٧٠٢٦c = -1L;
        iVar.f١٧٠٢٧d = false;
        iVar.f١٧٠٢٨e = 0;
        iVar.f١٧٠٣٥l = false;
        iVar.f١٧٠٣٢i = 0;
        iVar.f١٧٠٣٠g = false;
        pa.g[] gVarArr = this.f١٧٠٤٢s;
        if (gVarArr != null) {
            int length = gVarArr.length;
            iVar.f١٧٠٤٢s = new pa.g[length];
            iVar.f١٧٠٤٣t = new HashMap(length);
            for (int i11 = 0; i11 < length; i11++) {
                pa.g clone = gVarArr[i11].clone();
                iVar.f١٧٠٤٢s[i11] = clone;
                iVar.f١٧٠٤٣t.put(clone.d(), clone);
            }
        }
        return iVar;
    }

    public float t() {
        return this.f١٧٠٢٩f;
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.f١٧٠٤٢s != null) {
            for (int i10 = 0; i10 < this.f١٧٠٤٢s.length; i10++) {
                str = str + "\n    " + this.f١٧٠٤٢s[i10].toString();
            }
        }
        return str;
    }

    public Object u() {
        pa.g[] gVarArr = this.f١٧٠٤٢s;
        if (gVarArr != null && gVarArr.length > 0) {
            return gVarArr[0].c();
        }
        return null;
    }

    public long v() {
        if (this.f١٧٠٣٥l && this.f١٧٠٣٢i != 0) {
            return AnimationUtils.currentAnimationTimeMillis() - this.f١٧٠٢٥b;
        }
        return 0L;
    }

    void w() {
        if (!this.f١٧٠٣٥l) {
            int length = this.f١٧٠٤٢s.length;
            for (int i10 = 0; i10 < length; i10++) {
                this.f١٧٠٤٢s[i10].e();
            }
            this.f١٧٠٣٥l = true;
        }
    }

    public void y(long j10) {
        w();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f١٧٠٣٢i != 1) {
            this.f١٧٠٢٦c = j10;
            this.f١٧٠٣٢i = 2;
        }
        this.f١٧٠٢٥b = currentAnimationTimeMillis - j10;
        p(currentAnimationTimeMillis);
    }

    public i z(long j10) {
        if (j10 >= 0) {
            this.f١٧٠٣٦m = j10;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j10);
    }
}
