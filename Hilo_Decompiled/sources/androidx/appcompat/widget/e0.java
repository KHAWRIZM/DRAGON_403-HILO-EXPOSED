package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class e0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final float f١٤٩٣a;

    /* renamed from: b, reason: collision with root package name */
    private final int f١٤٩٤b;

    /* renamed from: c, reason: collision with root package name */
    private final int f١٤٩٥c;

    /* renamed from: d, reason: collision with root package name */
    final View f١٤٩٦d;

    /* renamed from: e, reason: collision with root package name */
    private Runnable f١٤٩٧e;

    /* renamed from: f, reason: collision with root package name */
    private Runnable f١٤٩٨f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f١٤٩٩g;

    /* renamed from: h, reason: collision with root package name */
    private int f١٥٠٠h;

    /* renamed from: i, reason: collision with root package name */
    private final int[] f١٥٠١i = new int[2];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = e0.this.f١٤٩٦d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.e();
        }
    }

    public e0(View view) {
        this.f١٤٩٦d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f١٤٩٣a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f١٤٩٤b = tapTimeout;
        this.f١٤٩٥c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.f١٤٩٨f;
        if (runnable != null) {
            this.f١٤٩٦d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f١٤٩٧e;
        if (runnable2 != null) {
            this.f١٤٩٦d.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) {
        DropDownListView dropDownListView;
        boolean z10;
        View view = this.f١٤٩٦d;
        androidx.appcompat.view.menu.o b10 = b();
        if (b10 == null || !b10.isShowing() || (dropDownListView = (DropDownListView) b10.n()) == null || !dropDownListView.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, obtainNoHistory);
        j(dropDownListView, obtainNoHistory);
        boolean e10 = dropDownListView.e(obtainNoHistory, this.f١٥٠٠h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1 && actionMasked != 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!e10 || !z10) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
    
        if (r1 != 3) goto L٢٨;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean g(MotionEvent motionEvent) {
        View view = this.f١٤٩٦d;
        if (!view.isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f١٥٠٠h);
                    if (findPointerIndex >= 0 && !h(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f١٤٩٣a)) {
                        a();
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                        return true;
                    }
                }
            }
            a();
        } else {
            this.f١٥٠٠h = motionEvent.getPointerId(0);
            if (this.f١٤٩٧e == null) {
                this.f١٤٩٧e = new a();
            }
            view.postDelayed(this.f١٤٩٧e, this.f١٤٩٤b);
            if (this.f١٤٩٨f == null) {
                this.f١٤٩٨f = new b();
            }
            view.postDelayed(this.f١٤٩٨f, this.f١٤٩٥c);
        }
        return false;
    }

    private static boolean h(View view, float f10, float f11, float f12) {
        float f13 = -f12;
        if (f10 >= f13 && f11 >= f13 && f10 < (view.getRight() - view.getLeft()) + f12 && f11 < (view.getBottom() - view.getTop()) + f12) {
            return true;
        }
        return false;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f١٥٠١i);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f١٥٠١i);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    public abstract androidx.appcompat.view.menu.o b();

    protected abstract boolean c();

    protected boolean d() {
        androidx.appcompat.view.menu.o b10 = b();
        if (b10 != null && b10.isShowing()) {
            b10.dismiss();
            return true;
        }
        return true;
    }

    void e() {
        a();
        View view = this.f١٤٩٦d;
        if (!view.isEnabled() || view.isLongClickable() || !c()) {
            return;
        }
        view.getParent().requestDisallowInterceptTouchEvent(true);
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 0);
        view.onTouchEvent(obtain);
        obtain.recycle();
        this.f١٤٩٩g = true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z10;
        boolean z11 = this.f١٤٩٩g;
        if (z11) {
            if (!f(motionEvent) && d()) {
                z10 = false;
            } else {
                z10 = true;
            }
        } else {
            if (g(motionEvent) && c()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 0);
                this.f١٤٩٦d.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f١٤٩٩g = z10;
        if (z10 || z11) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f١٤٩٩g = false;
        this.f١٥٠٠h = -1;
        Runnable runnable = this.f١٤٩٧e;
        if (runnable != null) {
            this.f١٤٩٦d.removeCallbacks(runnable);
        }
    }
}
