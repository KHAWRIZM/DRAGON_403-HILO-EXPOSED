package v2;

import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import v2.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c {

    /* renamed from: j, reason: collision with root package name */
    private static final ThreadLocal f١٨٣٤٠j = new ThreadLocal();

    /* renamed from: e, reason: collision with root package name */
    private k f١٨٣٤٥e;

    /* renamed from: i, reason: collision with root package name */
    public e f١٨٣٤٩i;

    /* renamed from: a, reason: collision with root package name */
    private final SimpleArrayMap f١٨٣٤١a = new SimpleArrayMap();

    /* renamed from: b, reason: collision with root package name */
    final ArrayList f١٨٣٤٢b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final b f١٨٣٤٣c = new b();

    /* renamed from: d, reason: collision with root package name */
    private final Runnable f١٨٣٤٤d = new Runnable() { // from class: v2.b
        @Override // java.lang.Runnable
        public final void run() {
            c.this.k();
        }
    };

    /* renamed from: f, reason: collision with root package name */
    long f١٨٣٤٦f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f١٨٣٤٧g = false;

    /* renamed from: h, reason: collision with root package name */
    public float f١٨٣٤٨h = 1.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b {
        private b() {
        }

        void a() {
            c.this.f١٨٣٤٦f = SystemClock.uptimeMillis();
            c cVar = c.this;
            cVar.f(cVar.f١٨٣٤٦f);
            if (c.this.f١٨٣٤٢b.size() > 0) {
                c.this.f١٨٣٤٥e.a(c.this.f١٨٣٤٤d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v2.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface InterfaceC٠٢٣٧c {
        boolean a(long j10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class d implements e {

        /* renamed from: a, reason: collision with root package name */
        ValueAnimator.DurationScaleChangeListener f١٨٣٥١a;

        public d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(float f10) {
            c.this.f١٨٣٤٨h = f10;
        }

        @Override // v2.c.e
        public boolean register() {
            boolean registerDurationScaleChangeListener;
            if (this.f١٨٣٥١a == null) {
                ValueAnimator.DurationScaleChangeListener durationScaleChangeListener = new ValueAnimator.DurationScaleChangeListener() { // from class: v2.f
                    @Override // android.animation.ValueAnimator.DurationScaleChangeListener
                    public final void onChanged(float f10) {
                        c.d.this.b(f10);
                    }
                };
                this.f١٨٣٥١a = durationScaleChangeListener;
                registerDurationScaleChangeListener = ValueAnimator.registerDurationScaleChangeListener(durationScaleChangeListener);
                return registerDurationScaleChangeListener;
            }
            return true;
        }

        @Override // v2.c.e
        public boolean unregister() {
            boolean unregisterDurationScaleChangeListener;
            unregisterDurationScaleChangeListener = ValueAnimator.unregisterDurationScaleChangeListener(this.f١٨٣٥١a);
            this.f١٨٣٥١a = null;
            return unregisterDurationScaleChangeListener;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface e {
        boolean register();

        boolean unregister();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static final class f implements k {

        /* renamed from: a, reason: collision with root package name */
        private final Choreographer f١٨٣٥٣a = Choreographer.getInstance();

        /* renamed from: b, reason: collision with root package name */
        private final Looper f١٨٣٥٤b = Looper.myLooper();

        f() {
        }

        @Override // v2.k
        public void a(final Runnable runnable) {
            this.f١٨٣٥٣a.postFrameCallback(new Choreographer.FrameCallback() { // from class: v2.g
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j10) {
                    runnable.run();
                }
            });
        }

        @Override // v2.k
        public boolean b() {
            if (Thread.currentThread() == this.f١٨٣٥٤b.getThread()) {
                return true;
            }
            return false;
        }
    }

    public c(k kVar) {
        this.f١٨٣٤٥e = kVar;
    }

    private void e() {
        if (this.f١٨٣٤٧g) {
            for (int size = this.f١٨٣٤٢b.size() - 1; size >= 0; size--) {
                if (this.f١٨٣٤٢b.get(size) == null) {
                    this.f١٨٣٤٢b.remove(size);
                }
            }
            if (this.f١٨٣٤٢b.size() == 0 && Build.VERSION.SDK_INT >= 33) {
                this.f١٨٣٤٩i.unregister();
            }
            this.f١٨٣٤٧g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c h() {
        ThreadLocal threadLocal = f١٨٣٤٠j;
        if (threadLocal.get() == null) {
            threadLocal.set(new c(new f()));
        }
        return (c) threadLocal.get();
    }

    private boolean i(InterfaceC٠٢٣٧c r52, long j10) {
        Long l10 = (Long) this.f١٨٣٤١a.get(r52);
        if (l10 == null) {
            return true;
        }
        if (l10.longValue() < j10) {
            this.f١٨٣٤١a.remove(r52);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        this.f١٨٣٤٣c.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(InterfaceC٠٢٣٧c r42, long j10) {
        float durationScale;
        if (this.f١٨٣٤٢b.size() == 0) {
            this.f١٨٣٤٥e.a(this.f١٨٣٤٤d);
            if (Build.VERSION.SDK_INT >= 33) {
                durationScale = ValueAnimator.getDurationScale();
                this.f١٨٣٤٨h = durationScale;
                if (this.f١٨٣٤٩i == null) {
                    this.f١٨٣٤٩i = new d();
                }
                this.f١٨٣٤٩i.register();
            }
        }
        if (!this.f١٨٣٤٢b.contains(r42)) {
            this.f١٨٣٤٢b.add(r42);
        }
        if (j10 > 0) {
            this.f١٨٣٤١a.put(r42, Long.valueOf(SystemClock.uptimeMillis() + j10));
        }
    }

    void f(long j10) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i10 = 0; i10 < this.f١٨٣٤٢b.size(); i10++) {
            InterfaceC٠٢٣٧c r32 = (InterfaceC٠٢٣٧c) this.f١٨٣٤٢b.get(i10);
            if (r32 != null && i(r32, uptimeMillis)) {
                r32.a(j10);
            }
        }
        e();
    }

    public float g() {
        return this.f١٨٣٤٨h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.f١٨٣٤٥e.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(InterfaceC٠٢٣٧c r32) {
        this.f١٨٣٤١a.remove(r32);
        int indexOf = this.f١٨٣٤٢b.indexOf(r32);
        if (indexOf >= 0) {
            this.f١٨٣٤٢b.set(indexOf, null);
            this.f١٨٣٤٧g = true;
        }
    }
}
