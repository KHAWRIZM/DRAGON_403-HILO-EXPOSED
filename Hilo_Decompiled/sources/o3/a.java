package o3;

import android.view.animation.Interpolator;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a {

    /* renamed from: c, reason: collision with root package name */
    private final d f١٦٤٧٣c;

    /* renamed from: e, reason: collision with root package name */
    protected y3.c f١٦٤٧٥e;

    /* renamed from: a, reason: collision with root package name */
    final List f١٦٤٧١a = new ArrayList(1);

    /* renamed from: b, reason: collision with root package name */
    private boolean f١٦٤٧٢b = false;

    /* renamed from: d, reason: collision with root package name */
    protected float f١٦٤٧٤d = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: f, reason: collision with root package name */
    private Object f١٦٤٧٦f = null;

    /* renamed from: g, reason: collision with root package name */
    private float f١٦٤٧٧g = -1.0f;

    /* renamed from: h, reason: collision with root package name */
    private float f١٦٤٧٨h = -1.0f;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface b {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class c implements d {
        private c() {
        }

        @Override // o3.a.d
        public boolean a(float f10) {
            throw new IllegalStateException("not implemented");
        }

        @Override // o3.a.d
        public y3.a b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // o3.a.d
        public boolean c(float f10) {
            return false;
        }

        @Override // o3.a.d
        public float d() {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }

        @Override // o3.a.d
        public float e() {
            return 1.0f;
        }

        @Override // o3.a.d
        public boolean isEmpty() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface d {
        boolean a(float f10);

        y3.a b();

        boolean c(float f10);

        float d();

        float e();

        boolean isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class e implements d {

        /* renamed from: a, reason: collision with root package name */
        private final List f١٦٤٧٩a;

        /* renamed from: c, reason: collision with root package name */
        private y3.a f١٦٤٨١c = null;

        /* renamed from: d, reason: collision with root package name */
        private float f١٦٤٨٢d = -1.0f;

        /* renamed from: b, reason: collision with root package name */
        private y3.a f١٦٤٨٠b = f(DownloadProgress.UNKNOWN_PROGRESS);

        e(List list) {
            this.f١٦٤٧٩a = list;
        }

        private y3.a f(float f10) {
            List list = this.f١٦٤٧٩a;
            y3.a aVar = (y3.a) list.get(list.size() - 1);
            if (f10 >= aVar.f()) {
                return aVar;
            }
            for (int size = this.f١٦٤٧٩a.size() - 2; size >= 1; size--) {
                y3.a aVar2 = (y3.a) this.f١٦٤٧٩a.get(size);
                if (this.f١٦٤٨٠b != aVar2 && aVar2.a(f10)) {
                    return aVar2;
                }
            }
            return (y3.a) this.f١٦٤٧٩a.get(0);
        }

        @Override // o3.a.d
        public boolean a(float f10) {
            y3.a aVar = this.f١٦٤٨١c;
            y3.a aVar2 = this.f١٦٤٨٠b;
            if (aVar == aVar2 && this.f١٦٤٨٢d == f10) {
                return true;
            }
            this.f١٦٤٨١c = aVar2;
            this.f١٦٤٨٢d = f10;
            return false;
        }

        @Override // o3.a.d
        public y3.a b() {
            return this.f١٦٤٨٠b;
        }

        @Override // o3.a.d
        public boolean c(float f10) {
            if (this.f١٦٤٨٠b.a(f10)) {
                return !this.f١٦٤٨٠b.i();
            }
            this.f١٦٤٨٠b = f(f10);
            return true;
        }

        @Override // o3.a.d
        public float d() {
            return ((y3.a) this.f١٦٤٧٩a.get(0)).f();
        }

        @Override // o3.a.d
        public float e() {
            return ((y3.a) this.f١٦٤٧٩a.get(r0.size() - 1)).c();
        }

        @Override // o3.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class f implements d {

        /* renamed from: a, reason: collision with root package name */
        private final y3.a f١٦٤٨٣a;

        /* renamed from: b, reason: collision with root package name */
        private float f١٦٤٨٤b = -1.0f;

        f(List list) {
            this.f١٦٤٨٣a = (y3.a) list.get(0);
        }

        @Override // o3.a.d
        public boolean a(float f10) {
            if (this.f١٦٤٨٤b == f10) {
                return true;
            }
            this.f١٦٤٨٤b = f10;
            return false;
        }

        @Override // o3.a.d
        public y3.a b() {
            return this.f١٦٤٨٣a;
        }

        @Override // o3.a.d
        public boolean c(float f10) {
            return !this.f١٦٤٨٣a.i();
        }

        @Override // o3.a.d
        public float d() {
            return this.f١٦٤٨٣a.f();
        }

        @Override // o3.a.d
        public float e() {
            return this.f١٦٤٨٣a.c();
        }

        @Override // o3.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List list) {
        this.f١٦٤٧٣c = p(list);
    }

    private float g() {
        if (this.f١٦٤٧٧g == -1.0f) {
            this.f١٦٤٧٧g = this.f١٦٤٧٣c.d();
        }
        return this.f١٦٤٧٧g;
    }

    private static d p(List list) {
        if (list.isEmpty()) {
            return new c();
        }
        if (list.size() == 1) {
            return new f(list);
        }
        return new e(list);
    }

    public void a(b bVar) {
        this.f١٦٤٧١a.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public y3.a b() {
        com.airbnb.lottie.e.b("BaseKeyframeAnimation#getCurrentKeyframe");
        y3.a b10 = this.f١٦٤٧٣c.b();
        com.airbnb.lottie.e.c("BaseKeyframeAnimation#getCurrentKeyframe");
        return b10;
    }

    float c() {
        if (this.f١٦٤٧٨h == -1.0f) {
            this.f١٦٤٧٨h = this.f١٦٤٧٣c.e();
        }
        return this.f١٦٤٧٨h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float d() {
        y3.a b10 = b();
        if (b10 != null && !b10.i()) {
            return b10.f١٩١١٩d.getInterpolation(e());
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        if (this.f١٦٤٧٢b) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        y3.a b10 = b();
        if (b10.i()) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        return (this.f١٦٤٧٤d - b10.f()) / (b10.c() - b10.f());
    }

    public float f() {
        return this.f١٦٤٧٤d;
    }

    public Object h() {
        Object i10;
        float e10 = e();
        if (this.f١٦٤٧٥e == null && this.f١٦٤٧٣c.a(e10)) {
            return this.f١٦٤٧٦f;
        }
        y3.a b10 = b();
        Interpolator interpolator = b10.f١٩١٢٠e;
        if (interpolator != null && b10.f١٩١٢١f != null) {
            i10 = j(b10, e10, interpolator.getInterpolation(e10), b10.f١٩١٢١f.getInterpolation(e10));
        } else {
            i10 = i(b10, d());
        }
        this.f١٦٤٧٦f = i10;
        return i10;
    }

    abstract Object i(y3.a aVar, float f10);

    protected Object j(y3.a aVar, float f10, float f11, float f12) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public boolean k() {
        if (this.f١٦٤٧٥e != null) {
            return true;
        }
        return false;
    }

    public void l() {
        com.airbnb.lottie.e.b("BaseKeyframeAnimation#notifyListeners");
        for (int i10 = 0; i10 < this.f١٦٤٧١a.size(); i10++) {
            ((b) this.f١٦٤٧١a.get(i10)).a();
        }
        com.airbnb.lottie.e.c("BaseKeyframeAnimation#notifyListeners");
    }

    public void m() {
        this.f١٦٤٧٢b = true;
    }

    public void n(float f10) {
        com.airbnb.lottie.e.b("BaseKeyframeAnimation#setProgress");
        if (this.f١٦٤٧٣c.isEmpty()) {
            com.airbnb.lottie.e.c("BaseKeyframeAnimation#setProgress");
            return;
        }
        if (f10 < g()) {
            f10 = g();
        } else if (f10 > c()) {
            f10 = c();
        }
        if (f10 == this.f١٦٤٧٤d) {
            com.airbnb.lottie.e.c("BaseKeyframeAnimation#setProgress");
            return;
        }
        this.f١٦٤٧٤d = f10;
        if (this.f١٦٤٧٣c.c(f10)) {
            l();
        }
        com.airbnb.lottie.e.c("BaseKeyframeAnimation#setProgress");
    }

    public void o(y3.c cVar) {
        y3.c cVar2 = this.f١٦٤٧٥e;
        if (cVar2 != null) {
            cVar2.c(null);
        }
        this.f١٦٤٧٥e = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}
