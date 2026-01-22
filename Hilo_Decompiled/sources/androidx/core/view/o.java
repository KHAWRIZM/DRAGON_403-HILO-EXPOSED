package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private final Context f٢٩٩٨a;

    /* renamed from: b, reason: collision with root package name */
    private final p f٢٩٩٩b;

    /* renamed from: c, reason: collision with root package name */
    private final b f٣٠٠٠c;

    /* renamed from: d, reason: collision with root package name */
    private final a f٣٠٠١d;

    /* renamed from: e, reason: collision with root package name */
    private VelocityTracker f٣٠٠٢e;

    /* renamed from: f, reason: collision with root package name */
    private float f٣٠٠٣f;

    /* renamed from: g, reason: collision with root package name */
    private int f٣٠٠٤g;

    /* renamed from: h, reason: collision with root package name */
    private int f٣٠٠٥h;

    /* renamed from: i, reason: collision with root package name */
    private int f٣٠٠٦i;

    /* renamed from: j, reason: collision with root package name */
    private final int[] f٣٠٠٧j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface a {
        float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface b {
        void a(Context context, int[] iArr, MotionEvent motionEvent, int i10);
    }

    public o(Context context, p pVar) {
        this(context, pVar, new b() { // from class: androidx.core.view.m
            @Override // androidx.core.view.o.b
            public final void a(Context context2, int[] iArr, MotionEvent motionEvent, int i10) {
                o.c(context2, iArr, motionEvent, i10);
            }
        }, new a() { // from class: androidx.core.view.n
            @Override // androidx.core.view.o.a
            public final float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i10) {
                float f10;
                f10 = o.f(velocityTracker, motionEvent, i10);
                return f10;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, int[] iArr, MotionEvent motionEvent, int i10) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        iArr[0] = g1.i(context, viewConfiguration, motionEvent.getDeviceId(), i10, motionEvent.getSource());
        iArr[1] = g1.h(context, viewConfiguration, motionEvent.getDeviceId(), i10, motionEvent.getSource());
    }

    private boolean d(MotionEvent motionEvent, int i10) {
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        if (this.f٣٠٠٥h == source && this.f٣٠٠٦i == deviceId && this.f٣٠٠٤g == i10) {
            return false;
        }
        this.f٣٠٠٠c.a(this.f٢٩٩٨a, this.f٣٠٠٧j, motionEvent, i10);
        this.f٣٠٠٥h = source;
        this.f٣٠٠٦i = deviceId;
        this.f٣٠٠٤g = i10;
        return true;
    }

    private float e(MotionEvent motionEvent, int i10) {
        if (this.f٣٠٠٢e == null) {
            this.f٣٠٠٢e = VelocityTracker.obtain();
        }
        return this.f٣٠٠١d.a(this.f٣٠٠٢e, motionEvent, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float f(VelocityTracker velocityTracker, MotionEvent motionEvent, int i10) {
        z0.a(velocityTracker, motionEvent);
        z0.b(velocityTracker, 1000);
        return z0.d(velocityTracker, i10);
    }

    public void g(MotionEvent motionEvent, int i10) {
        boolean d10 = d(motionEvent, i10);
        if (this.f٣٠٠٧j[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.f٣٠٠٢e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f٣٠٠٢e = null;
                return;
            }
            return;
        }
        float e10 = e(motionEvent, i10) * this.f٢٩٩٩b.b();
        float signum = Math.signum(e10);
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        if (d10 || (signum != Math.signum(this.f٣٠٠٣f) && signum != DownloadProgress.UNKNOWN_PROGRESS)) {
            this.f٢٩٩٩b.c();
        }
        float abs = Math.abs(e10);
        int[] iArr = this.f٣٠٠٧j;
        if (abs < iArr[0]) {
            return;
        }
        float max = Math.max(-r6, Math.min(e10, iArr[1]));
        if (this.f٢٩٩٩b.a(max)) {
            f10 = max;
        }
        this.f٣٠٠٣f = f10;
    }

    o(Context context, p pVar, b bVar, a aVar) {
        this.f٣٠٠٤g = -1;
        this.f٣٠٠٥h = -1;
        this.f٣٠٠٦i = -1;
        this.f٣٠٠٧j = new int[]{Integer.MAX_VALUE, 0};
        this.f٢٩٩٨a = context;
        this.f٢٩٩٩b = pVar;
        this.f٣٠٠٠c = bVar;
        this.f٣٠٠١d = aVar;
    }
}
