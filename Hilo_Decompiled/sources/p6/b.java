package p6;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import kotlin.KotlinVersion;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f١٦٨٩٤a = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f١٦٨٩٥b = 0;

    /* renamed from: c, reason: collision with root package name */
    private final ScaleGestureDetector f١٦٨٩٦c;

    /* renamed from: d, reason: collision with root package name */
    private VelocityTracker f١٦٨٩٧d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f١٦٨٩٨e;

    /* renamed from: f, reason: collision with root package name */
    private float f١٦٨٩٩f;

    /* renamed from: g, reason: collision with root package name */
    private float f١٦٩٠٠g;

    /* renamed from: h, reason: collision with root package name */
    private final float f١٦٩٠١h;

    /* renamed from: i, reason: collision with root package name */
    private final float f١٦٩٠٢i;

    /* renamed from: j, reason: collision with root package name */
    private c f١٦٩٠٣j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, c cVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f١٦٩٠٢i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f١٦٩٠١h = viewConfiguration.getScaledTouchSlop();
        this.f١٦٩٠٣j = cVar;
        this.f١٦٨٩٦c = new ScaleGestureDetector(context, new a());
    }

    private float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f١٦٨٩٥b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f١٦٨٩٥b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    private boolean g(MotionEvent motionEvent) {
        boolean z10;
        int i10;
        int action = motionEvent.getAction() & KotlinVersion.MAX_COMPONENT_VALUE;
        int i11 = 0;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action == 6) {
                            int b10 = l.b(motionEvent.getAction());
                            if (motionEvent.getPointerId(b10) == this.f١٦٨٩٤a) {
                                if (b10 == 0) {
                                    i10 = 1;
                                } else {
                                    i10 = 0;
                                }
                                this.f١٦٨٩٤a = motionEvent.getPointerId(i10);
                                this.f١٦٨٩٩f = motionEvent.getX(i10);
                                this.f١٦٩٠٠g = motionEvent.getY(i10);
                            }
                        }
                    } else {
                        this.f١٦٨٩٤a = -1;
                        VelocityTracker velocityTracker = this.f١٦٨٩٧d;
                        if (velocityTracker != null) {
                            velocityTracker.recycle();
                            this.f١٦٨٩٧d = null;
                        }
                    }
                } else {
                    float b11 = b(motionEvent);
                    float c10 = c(motionEvent);
                    float f10 = b11 - this.f١٦٨٩٩f;
                    float f11 = c10 - this.f١٦٩٠٠g;
                    if (!this.f١٦٨٩٨e) {
                        if (Math.sqrt((f10 * f10) + (f11 * f11)) >= this.f١٦٩٠١h) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        this.f١٦٨٩٨e = z10;
                    }
                    if (this.f١٦٨٩٨e) {
                        this.f١٦٩٠٣j.onDrag(f10, f11);
                        this.f١٦٨٩٩f = b11;
                        this.f١٦٩٠٠g = c10;
                        VelocityTracker velocityTracker2 = this.f١٦٨٩٧d;
                        if (velocityTracker2 != null) {
                            velocityTracker2.addMovement(motionEvent);
                        }
                    }
                }
            } else {
                this.f١٦٨٩٤a = -1;
                if (this.f١٦٨٩٨e && this.f١٦٨٩٧d != null) {
                    this.f١٦٨٩٩f = b(motionEvent);
                    this.f١٦٩٠٠g = c(motionEvent);
                    this.f١٦٨٩٧d.addMovement(motionEvent);
                    this.f١٦٨٩٧d.computeCurrentVelocity(1000);
                    float xVelocity = this.f١٦٨٩٧d.getXVelocity();
                    float yVelocity = this.f١٦٨٩٧d.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f١٦٩٠٢i) {
                        this.f١٦٩٠٣j.onFling(this.f١٦٨٩٩f, this.f١٦٩٠٠g, -xVelocity, -yVelocity);
                    }
                }
                VelocityTracker velocityTracker3 = this.f١٦٨٩٧d;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.f١٦٨٩٧d = null;
                }
            }
        } else {
            this.f١٦٨٩٤a = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f١٦٨٩٧d = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.f١٦٨٩٩f = b(motionEvent);
            this.f١٦٩٠٠g = c(motionEvent);
            this.f١٦٨٩٨e = false;
        }
        int i12 = this.f١٦٨٩٤a;
        if (i12 != -1) {
            i11 = i12;
        }
        this.f١٦٨٩٥b = motionEvent.findPointerIndex(i11);
        return true;
    }

    public boolean d() {
        return this.f١٦٨٩٨e;
    }

    public boolean e() {
        return this.f١٦٨٩٦c.isInProgress();
    }

    public boolean f(MotionEvent motionEvent) {
        try {
            this.f١٦٨٩٦c.onTouchEvent(motionEvent);
            return g(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements ScaleGestureDetector.OnScaleGestureListener {
        a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (!Float.isNaN(scaleFactor) && !Float.isInfinite(scaleFactor)) {
                if (scaleFactor >= DownloadProgress.UNKNOWN_PROGRESS) {
                    b.this.f١٦٩٠٣j.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }
}
