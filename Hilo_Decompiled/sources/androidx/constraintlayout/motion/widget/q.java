package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class q {
    private static final float[][] G = {new float[]{0.5f, DownloadProgress.UNKNOWN_PROGRESS}, new float[]{DownloadProgress.UNKNOWN_PROGRESS, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{DownloadProgress.UNKNOWN_PROGRESS, 0.5f}, new float[]{1.0f, 0.5f}};
    private static final float[][] H = {new float[]{DownloadProgress.UNKNOWN_PROGRESS, -1.0f}, new float[]{DownloadProgress.UNKNOWN_PROGRESS, 1.0f}, new float[]{-1.0f, DownloadProgress.UNKNOWN_PROGRESS}, new float[]{1.0f, DownloadProgress.UNKNOWN_PROGRESS}, new float[]{-1.0f, DownloadProgress.UNKNOWN_PROGRESS}, new float[]{1.0f, DownloadProgress.UNKNOWN_PROGRESS}};

    /* renamed from: r, reason: collision with root package name */
    private float f٢١٢٧r;

    /* renamed from: s, reason: collision with root package name */
    private float f٢١٢٨s;

    /* renamed from: t, reason: collision with root package name */
    private final MotionLayout f٢١٢٩t;

    /* renamed from: a, reason: collision with root package name */
    private int f٢١١٠a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f٢١١١b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f٢١١٢c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f٢١١٣d = -1;

    /* renamed from: e, reason: collision with root package name */
    private int f٢١١٤e = -1;

    /* renamed from: f, reason: collision with root package name */
    private int f٢١١٥f = -1;

    /* renamed from: g, reason: collision with root package name */
    private float f٢١١٦g = 0.5f;

    /* renamed from: h, reason: collision with root package name */
    private float f٢١١٧h = 0.5f;

    /* renamed from: i, reason: collision with root package name */
    float f٢١١٨i = 0.5f;

    /* renamed from: j, reason: collision with root package name */
    float f٢١١٩j = 0.5f;

    /* renamed from: k, reason: collision with root package name */
    private int f٢١٢٠k = -1;

    /* renamed from: l, reason: collision with root package name */
    boolean f٢١٢١l = false;

    /* renamed from: m, reason: collision with root package name */
    private float f٢١٢٢m = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: n, reason: collision with root package name */
    private float f٢١٢٣n = 1.0f;

    /* renamed from: o, reason: collision with root package name */
    private boolean f٢١٢٤o = false;

    /* renamed from: p, reason: collision with root package name */
    private float[] f٢١٢٥p = new float[2];

    /* renamed from: q, reason: collision with root package name */
    private int[] f٢١٢٦q = new int[2];

    /* renamed from: u, reason: collision with root package name */
    private float f٢١٣٠u = 4.0f;

    /* renamed from: v, reason: collision with root package name */
    private float f٢١٣١v = 1.2f;

    /* renamed from: w, reason: collision with root package name */
    private boolean f٢١٣٢w = true;

    /* renamed from: x, reason: collision with root package name */
    private float f٢١٣٣x = 1.0f;

    /* renamed from: y, reason: collision with root package name */
    private int f٢١٣٤y = 0;

    /* renamed from: z, reason: collision with root package name */
    private float f٢١٣٥z = 10.0f;
    private float A = 10.0f;

    /* renamed from: B, reason: collision with root package name */
    private float f٢١٠٩B = 1.0f;
    private float C = Float.NaN;
    private float D = Float.NaN;
    private int E = 0;
    private int F = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements View.OnTouchListener {
        a(q qVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b implements NestedScrollView.e {
        b(q qVar) {
        }

        @Override // androidx.core.widget.NestedScrollView.e
        public void a(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.f٢١٢٩t = motionLayout;
        c(context, Xml.asAttributeSet(xmlPullParser));
    }

    private void b(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            if (index == R.styleable.OnSwipe_touchAnchorId) {
                this.f٢١١٣d = typedArray.getResourceId(index, this.f٢١١٣d);
            } else if (index == R.styleable.OnSwipe_touchAnchorSide) {
                int i11 = typedArray.getInt(index, this.f٢١١٠a);
                this.f٢١١٠a = i11;
                float[] fArr = G[i11];
                this.f٢١١٧h = fArr[0];
                this.f٢١١٦g = fArr[1];
            } else if (index == R.styleable.OnSwipe_dragDirection) {
                int i12 = typedArray.getInt(index, this.f٢١١١b);
                this.f٢١١١b = i12;
                float[][] fArr2 = H;
                if (i12 < fArr2.length) {
                    float[] fArr3 = fArr2[i12];
                    this.f٢١٢٢m = fArr3[0];
                    this.f٢١٢٣n = fArr3[1];
                } else {
                    this.f٢١٢٣n = Float.NaN;
                    this.f٢١٢٢m = Float.NaN;
                    this.f٢١٢١l = true;
                }
            } else if (index == R.styleable.OnSwipe_maxVelocity) {
                this.f٢١٣٠u = typedArray.getFloat(index, this.f٢١٣٠u);
            } else if (index == R.styleable.OnSwipe_maxAcceleration) {
                this.f٢١٣١v = typedArray.getFloat(index, this.f٢١٣١v);
            } else if (index == R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.f٢١٣٢w = typedArray.getBoolean(index, this.f٢١٣٢w);
            } else if (index == R.styleable.OnSwipe_dragScale) {
                this.f٢١٣٣x = typedArray.getFloat(index, this.f٢١٣٣x);
            } else if (index == R.styleable.OnSwipe_dragThreshold) {
                this.f٢١٣٥z = typedArray.getFloat(index, this.f٢١٣٥z);
            } else if (index == R.styleable.OnSwipe_touchRegionId) {
                this.f٢١١٤e = typedArray.getResourceId(index, this.f٢١١٤e);
            } else if (index == R.styleable.OnSwipe_onTouchUp) {
                this.f٢١١٢c = typedArray.getInt(index, this.f٢١١٢c);
            } else if (index == R.styleable.OnSwipe_nestedScrollFlags) {
                this.f٢١٣٤y = typedArray.getInteger(index, 0);
            } else if (index == R.styleable.OnSwipe_limitBoundsTo) {
                this.f٢١١٥f = typedArray.getResourceId(index, 0);
            } else if (index == R.styleable.OnSwipe_rotationCenterId) {
                this.f٢١٢٠k = typedArray.getResourceId(index, this.f٢١٢٠k);
            } else if (index == R.styleable.OnSwipe_springDamping) {
                this.A = typedArray.getFloat(index, this.A);
            } else if (index == R.styleable.OnSwipe_springMass) {
                this.f٢١٠٩B = typedArray.getFloat(index, this.f٢١٠٩B);
            } else if (index == R.styleable.OnSwipe_springStiffness) {
                this.C = typedArray.getFloat(index, this.C);
            } else if (index == R.styleable.OnSwipe_springStopThreshold) {
                this.D = typedArray.getFloat(index, this.D);
            } else if (index == R.styleable.OnSwipe_springBoundary) {
                this.E = typedArray.getInt(index, this.E);
            } else if (index == R.styleable.OnSwipe_autoCompleteMode) {
                this.F = typedArray.getInt(index, this.F);
            }
        }
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OnSwipe);
        b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        View view;
        int i10 = this.f٢١١٣d;
        if (i10 != -1) {
            view = this.f٢١٢٩t.findViewById(i10);
            if (view == null) {
                Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + androidx.constraintlayout.motion.widget.a.c(this.f٢١٢٩t.getContext(), this.f٢١١٣d));
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new a(this));
            nestedScrollView.setOnScrollChangeListener(new b(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a(float f10, float f11) {
        return (f10 * this.f٢١٢٢m) + (f11 * this.f٢١٢٣n);
    }

    public int d() {
        return this.F;
    }

    public int e() {
        return this.f٢١٣٤y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RectF f(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i10 = this.f٢١١٥f;
        if (i10 == -1 || (findViewById = viewGroup.findViewById(i10)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float g() {
        return this.f٢١٣١v;
    }

    public float h() {
        return this.f٢١٣٠u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        return this.f٢١٣٢w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j(float f10, float f11) {
        this.f٢١٢٩t.W(this.f٢١١٣d, this.f٢١٢٩t.getProgress(), this.f٢١١٧h, this.f٢١١٦g, this.f٢١٢٥p);
        float f12 = this.f٢١٢٢m;
        if (f12 != DownloadProgress.UNKNOWN_PROGRESS) {
            float[] fArr = this.f٢١٢٥p;
            if (fArr[0] == DownloadProgress.UNKNOWN_PROGRESS) {
                fArr[0] = 1.0E-7f;
            }
            return (f10 * f12) / fArr[0];
        }
        float[] fArr2 = this.f٢١٢٥p;
        if (fArr2[1] == DownloadProgress.UNKNOWN_PROGRESS) {
            fArr2[1] = 1.0E-7f;
        }
        return (f11 * this.f٢١٢٣n) / fArr2[1];
    }

    public int k() {
        return this.E;
    }

    public float l() {
        return this.A;
    }

    public float m() {
        return this.f٢١٠٩B;
    }

    public float n() {
        return this.C;
    }

    public float o() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RectF p(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i10 = this.f٢١١٤e;
        if (i10 == -1 || (findViewById = viewGroup.findViewById(i10)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        return this.f٢١١٤e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        return this.f٢١٢٤o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(MotionEvent motionEvent, MotionLayout.h hVar, int i10, p pVar) {
        float f10;
        float f11;
        int i11;
        float f12;
        float f13;
        boolean z10;
        float f14;
        if (this.f٢١٢١l) {
            t(motionEvent, hVar, i10, pVar);
            return;
        }
        hVar.a(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float rawY = motionEvent.getRawY() - this.f٢١٢٨s;
                    float rawX = motionEvent.getRawX() - this.f٢١٢٧r;
                    if (Math.abs((this.f٢١٢٢m * rawX) + (this.f٢١٢٣n * rawY)) > this.f٢١٣٥z || this.f٢١٢٤o) {
                        float progress = this.f٢١٢٩t.getProgress();
                        if (!this.f٢١٢٤o) {
                            this.f٢١٢٤o = true;
                            this.f٢١٢٩t.setProgress(progress);
                        }
                        int i12 = this.f٢١١٣d;
                        if (i12 != -1) {
                            this.f٢١٢٩t.W(i12, progress, this.f٢١١٧h, this.f٢١١٦g, this.f٢١٢٥p);
                        } else {
                            float min = Math.min(this.f٢١٢٩t.getWidth(), this.f٢١٢٩t.getHeight());
                            float[] fArr = this.f٢١٢٥p;
                            fArr[1] = this.f٢١٢٣n * min;
                            fArr[0] = min * this.f٢١٢٢m;
                        }
                        float f15 = this.f٢١٢٢m;
                        float[] fArr2 = this.f٢١٢٥p;
                        if (Math.abs(((f15 * fArr2[0]) + (this.f٢١٢٣n * fArr2[1])) * this.f٢١٣٣x) < 0.01d) {
                            float[] fArr3 = this.f٢١٢٥p;
                            fArr3[0] = 0.01f;
                            fArr3[1] = 0.01f;
                        }
                        if (this.f٢١٢٢m != DownloadProgress.UNKNOWN_PROGRESS) {
                            f13 = rawX / this.f٢١٢٥p[0];
                        } else {
                            f13 = rawY / this.f٢١٢٥p[1];
                        }
                        float max = Math.max(Math.min(progress + f13, 1.0f), DownloadProgress.UNKNOWN_PROGRESS);
                        if (this.f٢١١٢c == 6) {
                            max = Math.max(max, 0.01f);
                        }
                        if (this.f٢١١٢c == 7) {
                            max = Math.min(max, 0.99f);
                        }
                        float progress2 = this.f٢١٢٩t.getProgress();
                        if (max != progress2) {
                            if (progress2 == DownloadProgress.UNKNOWN_PROGRESS || progress2 == 1.0f) {
                                MotionLayout motionLayout = this.f٢١٢٩t;
                                if (progress2 == DownloadProgress.UNKNOWN_PROGRESS) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                motionLayout.R(z10);
                            }
                            this.f٢١٢٩t.setProgress(max);
                            hVar.d(1000);
                            float c10 = hVar.c();
                            float b10 = hVar.b();
                            if (this.f٢١٢٢m != DownloadProgress.UNKNOWN_PROGRESS) {
                                f14 = c10 / this.f٢١٢٥p[0];
                            } else {
                                f14 = b10 / this.f٢١٢٥p[1];
                            }
                            this.f٢١٢٩t.f١٨٤٦d = f14;
                        } else {
                            this.f٢١٢٩t.f١٨٤٦d = DownloadProgress.UNKNOWN_PROGRESS;
                        }
                        this.f٢١٢٧r = motionEvent.getRawX();
                        this.f٢١٢٨s = motionEvent.getRawY();
                        return;
                    }
                    return;
                }
                return;
            }
            this.f٢١٢٤o = false;
            hVar.d(1000);
            float c11 = hVar.c();
            float b11 = hVar.b();
            float progress3 = this.f٢١٢٩t.getProgress();
            int i13 = this.f٢١١٣d;
            if (i13 != -1) {
                this.f٢١٢٩t.W(i13, progress3, this.f٢١١٧h, this.f٢١١٦g, this.f٢١٢٥p);
            } else {
                float min2 = Math.min(this.f٢١٢٩t.getWidth(), this.f٢١٢٩t.getHeight());
                float[] fArr4 = this.f٢١٢٥p;
                fArr4[1] = this.f٢١٢٣n * min2;
                fArr4[0] = min2 * this.f٢١٢٢m;
            }
            float f16 = this.f٢١٢٢m;
            float[] fArr5 = this.f٢١٢٥p;
            float f17 = fArr5[0];
            float f18 = fArr5[1];
            if (f16 != DownloadProgress.UNKNOWN_PROGRESS) {
                f10 = c11 / f17;
            } else {
                f10 = b11 / f18;
            }
            if (!Float.isNaN(f10)) {
                f11 = (f10 / 3.0f) + progress3;
            } else {
                f11 = progress3;
            }
            if (f11 != DownloadProgress.UNKNOWN_PROGRESS && f11 != 1.0f && (i11 = this.f٢١١٢c) != 3) {
                if (f11 < 0.5d) {
                    f12 = DownloadProgress.UNKNOWN_PROGRESS;
                } else {
                    f12 = 1.0f;
                }
                if (i11 == 6) {
                    if (progress3 + f10 < DownloadProgress.UNKNOWN_PROGRESS) {
                        f10 = Math.abs(f10);
                    }
                    f12 = 1.0f;
                }
                if (this.f٢١١٢c == 7) {
                    if (progress3 + f10 > 1.0f) {
                        f10 = -Math.abs(f10);
                    }
                    f12 = DownloadProgress.UNKNOWN_PROGRESS;
                }
                this.f٢١٢٩t.m0(this.f٢١١٢c, f12, f10);
                if (DownloadProgress.UNKNOWN_PROGRESS >= progress3 || 1.0f <= progress3) {
                    this.f٢١٢٩t.setState(MotionLayout.l.FINISHED);
                    return;
                }
                return;
            }
            if (DownloadProgress.UNKNOWN_PROGRESS >= f11 || 1.0f <= f11) {
                this.f٢١٢٩t.setState(MotionLayout.l.FINISHED);
                return;
            }
            return;
        }
        this.f٢١٢٧r = motionEvent.getRawX();
        this.f٢١٢٨s = motionEvent.getRawY();
        this.f٢١٢٤o = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0297  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void t(MotionEvent motionEvent, MotionLayout.h hVar, int i10, p pVar) {
        float left;
        float f10;
        int top;
        int bottom;
        int i11;
        float degrees;
        float f11;
        int i12;
        float f12;
        hVar.a(motionEvent);
        int action = motionEvent.getAction();
        boolean z10 = false;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    motionEvent.getRawY();
                    motionEvent.getRawX();
                    float width = this.f٢١٢٩t.getWidth() / 2.0f;
                    float height = this.f٢١٢٩t.getHeight() / 2.0f;
                    int i13 = this.f٢١٢٠k;
                    if (i13 != -1) {
                        View findViewById = this.f٢١٢٩t.findViewById(i13);
                        this.f٢١٢٩t.getLocationOnScreen(this.f٢١٢٦q);
                        height = ((findViewById.getTop() + findViewById.getBottom()) / 2.0f) + this.f٢١٢٦q[1];
                        width = this.f٢١٢٦q[0] + ((findViewById.getLeft() + findViewById.getRight()) / 2.0f);
                    } else {
                        int i14 = this.f٢١١٣d;
                        if (i14 != -1) {
                            if (this.f٢١٢٩t.findViewById(this.f٢١٢٩t.Y(i14).h()) == null) {
                                Log.e("TouchResponse", "could not find view to animate to");
                            } else {
                                this.f٢١٢٩t.getLocationOnScreen(this.f٢١٢٦q);
                                width = this.f٢١٢٦q[0] + ((r12.getLeft() + r12.getRight()) / 2.0f);
                                height = this.f٢١٢٦q[1] + ((r12.getTop() + r12.getBottom()) / 2.0f);
                            }
                        }
                    }
                    float rawX = motionEvent.getRawX() - width;
                    float rawY = motionEvent.getRawY() - height;
                    float atan2 = (float) (((Math.atan2(motionEvent.getRawY() - height, motionEvent.getRawX() - width) - Math.atan2(this.f٢١٢٨s - height, this.f٢١٢٧r - width)) * 180.0d) / 3.141592653589793d);
                    if (atan2 > 330.0f) {
                        atan2 -= 360.0f;
                    } else if (atan2 < -330.0f) {
                        atan2 += 360.0f;
                    }
                    if (Math.abs(atan2) > 0.01d || this.f٢١٢٤o) {
                        float progress = this.f٢١٢٩t.getProgress();
                        if (!this.f٢١٢٤o) {
                            this.f٢١٢٤o = true;
                            this.f٢١٢٩t.setProgress(progress);
                        }
                        int i15 = this.f٢١١٣d;
                        if (i15 != -1) {
                            this.f٢١٢٩t.W(i15, progress, this.f٢١١٧h, this.f٢١١٦g, this.f٢١٢٥p);
                            this.f٢١٢٥p[1] = (float) Math.toDegrees(r3[1]);
                        } else {
                            this.f٢١٢٥p[1] = 360.0f;
                        }
                        float max = Math.max(Math.min(progress + ((atan2 * this.f٢١٣٣x) / this.f٢١٢٥p[1]), 1.0f), DownloadProgress.UNKNOWN_PROGRESS);
                        float progress2 = this.f٢١٢٩t.getProgress();
                        if (max != progress2) {
                            if (progress2 == DownloadProgress.UNKNOWN_PROGRESS || progress2 == 1.0f) {
                                MotionLayout motionLayout = this.f٢١٢٩t;
                                if (progress2 == DownloadProgress.UNKNOWN_PROGRESS) {
                                    z10 = true;
                                }
                                motionLayout.R(z10);
                            }
                            this.f٢١٢٩t.setProgress(max);
                            hVar.d(1000);
                            float c10 = hVar.c();
                            double b10 = hVar.b();
                            double d10 = c10;
                            this.f٢١٢٩t.f١٨٤٦d = (float) Math.toDegrees((float) ((Math.hypot(b10, d10) * Math.sin(Math.atan2(b10, d10) - r8)) / Math.hypot(rawX, rawY)));
                        } else {
                            this.f٢١٢٩t.f١٨٤٦d = DownloadProgress.UNKNOWN_PROGRESS;
                        }
                        this.f٢١٢٧r = motionEvent.getRawX();
                        this.f٢١٢٨s = motionEvent.getRawY();
                        return;
                    }
                    return;
                }
                return;
            }
            this.f٢١٢٤o = false;
            hVar.d(16);
            float c11 = hVar.c();
            float b11 = hVar.b();
            float progress3 = this.f٢١٢٩t.getProgress();
            float width2 = this.f٢١٢٩t.getWidth() / 2.0f;
            float height2 = this.f٢١٢٩t.getHeight() / 2.0f;
            int i16 = this.f٢١٢٠k;
            if (i16 != -1) {
                View findViewById2 = this.f٢١٢٩t.findViewById(i16);
                this.f٢١٢٩t.getLocationOnScreen(this.f٢١٢٦q);
                left = this.f٢١٢٦q[0] + ((findViewById2.getLeft() + findViewById2.getRight()) / 2.0f);
                f10 = this.f٢١٢٦q[1];
                top = findViewById2.getTop();
                bottom = findViewById2.getBottom();
            } else {
                int i17 = this.f٢١١٣d;
                if (i17 != -1) {
                    View findViewById3 = this.f٢١٢٩t.findViewById(this.f٢١٢٩t.Y(i17).h());
                    this.f٢١٢٩t.getLocationOnScreen(this.f٢١٢٦q);
                    left = this.f٢١٢٦q[0] + ((findViewById3.getLeft() + findViewById3.getRight()) / 2.0f);
                    f10 = this.f٢١٢٦q[1];
                    top = findViewById3.getTop();
                    bottom = findViewById3.getBottom();
                }
                float rawX2 = motionEvent.getRawX() - width2;
                double degrees2 = Math.toDegrees(Math.atan2(motionEvent.getRawY() - height2, rawX2));
                i11 = this.f٢١١٣d;
                if (i11 == -1) {
                    this.f٢١٢٩t.W(i11, progress3, this.f٢١١٧h, this.f٢١١٦g, this.f٢١٢٥p);
                    this.f٢١٢٥p[1] = (float) Math.toDegrees(r3[1]);
                } else {
                    this.f٢١٢٥p[1] = 360.0f;
                }
                degrees = ((float) (Math.toDegrees(Math.atan2(b11 + r2, c11 + rawX2)) - degrees2)) * 62.5f;
                if (Float.isNaN(degrees)) {
                    f11 = (((degrees * 3.0f) * this.f٢١٣٣x) / this.f٢١٢٥p[1]) + progress3;
                } else {
                    f11 = progress3;
                }
                if (f11 == DownloadProgress.UNKNOWN_PROGRESS && f11 != 1.0f && (i12 = this.f٢١١٢c) != 3) {
                    float f13 = (degrees * this.f٢١٣٣x) / this.f٢١٢٥p[1];
                    if (f11 < 0.5d) {
                        f12 = DownloadProgress.UNKNOWN_PROGRESS;
                    } else {
                        f12 = 1.0f;
                    }
                    if (i12 == 6) {
                        if (progress3 + f13 < DownloadProgress.UNKNOWN_PROGRESS) {
                            f13 = Math.abs(f13);
                        }
                        f12 = 1.0f;
                    }
                    if (this.f٢١١٢c == 7) {
                        if (progress3 + f13 > 1.0f) {
                            f13 = -Math.abs(f13);
                        }
                        f12 = DownloadProgress.UNKNOWN_PROGRESS;
                    }
                    this.f٢١٢٩t.m0(this.f٢١١٢c, f12, f13 * 3.0f);
                    if (DownloadProgress.UNKNOWN_PROGRESS >= progress3 || 1.0f <= progress3) {
                        this.f٢١٢٩t.setState(MotionLayout.l.FINISHED);
                        return;
                    }
                    return;
                }
                if (DownloadProgress.UNKNOWN_PROGRESS < f11 || 1.0f <= f11) {
                    this.f٢١٢٩t.setState(MotionLayout.l.FINISHED);
                    return;
                }
                return;
            }
            height2 = f10 + ((top + bottom) / 2.0f);
            width2 = left;
            float rawX22 = motionEvent.getRawX() - width2;
            double degrees22 = Math.toDegrees(Math.atan2(motionEvent.getRawY() - height2, rawX22));
            i11 = this.f٢١١٣d;
            if (i11 == -1) {
            }
            degrees = ((float) (Math.toDegrees(Math.atan2(b11 + r2, c11 + rawX22)) - degrees22)) * 62.5f;
            if (Float.isNaN(degrees)) {
            }
            if (f11 == DownloadProgress.UNKNOWN_PROGRESS) {
            }
            if (DownloadProgress.UNKNOWN_PROGRESS < f11) {
            }
            this.f٢١٢٩t.setState(MotionLayout.l.FINISHED);
            return;
        }
        this.f٢١٢٧r = motionEvent.getRawX();
        this.f٢١٢٨s = motionEvent.getRawY();
        this.f٢١٢٤o = false;
    }

    public String toString() {
        if (Float.isNaN(this.f٢١٢٢m)) {
            return "rotation";
        }
        return this.f٢١٢٢m + " , " + this.f٢١٢٣n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(float f10, float f11) {
        float f12;
        float progress = this.f٢١٢٩t.getProgress();
        if (!this.f٢١٢٤o) {
            this.f٢١٢٤o = true;
            this.f٢١٢٩t.setProgress(progress);
        }
        this.f٢١٢٩t.W(this.f٢١١٣d, progress, this.f٢١١٧h, this.f٢١١٦g, this.f٢١٢٥p);
        float f13 = this.f٢١٢٢m;
        float[] fArr = this.f٢١٢٥p;
        if (Math.abs((f13 * fArr[0]) + (this.f٢١٢٣n * fArr[1])) < 0.01d) {
            float[] fArr2 = this.f٢١٢٥p;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f14 = this.f٢١٢٢m;
        if (f14 != DownloadProgress.UNKNOWN_PROGRESS) {
            f12 = (f10 * f14) / this.f٢١٢٥p[0];
        } else {
            f12 = (f11 * this.f٢١٢٣n) / this.f٢١٢٥p[1];
        }
        float max = Math.max(Math.min(progress + f12, 1.0f), DownloadProgress.UNKNOWN_PROGRESS);
        if (max != this.f٢١٢٩t.getProgress()) {
            this.f٢١٢٩t.setProgress(max);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(float f10, float f11) {
        float f12;
        boolean z10;
        boolean z11 = false;
        this.f٢١٢٤o = false;
        float progress = this.f٢١٢٩t.getProgress();
        this.f٢١٢٩t.W(this.f٢١١٣d, progress, this.f٢١١٧h, this.f٢١١٦g, this.f٢١٢٥p);
        float f13 = this.f٢١٢٢m;
        float[] fArr = this.f٢١٢٥p;
        float f14 = fArr[0];
        float f15 = this.f٢١٢٣n;
        float f16 = fArr[1];
        float f17 = DownloadProgress.UNKNOWN_PROGRESS;
        if (f13 != DownloadProgress.UNKNOWN_PROGRESS) {
            f12 = (f10 * f13) / f14;
        } else {
            f12 = (f11 * f15) / f16;
        }
        if (!Float.isNaN(f12)) {
            progress += f12 / 3.0f;
        }
        if (progress != DownloadProgress.UNKNOWN_PROGRESS) {
            if (progress != 1.0f) {
                z10 = true;
            } else {
                z10 = false;
            }
            int i10 = this.f٢١١٢c;
            if (i10 != 3) {
                z11 = true;
            }
            if (z11 & z10) {
                MotionLayout motionLayout = this.f٢١٢٩t;
                if (progress >= 0.5d) {
                    f17 = 1.0f;
                }
                motionLayout.m0(i10, f17, f12);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(float f10, float f11) {
        this.f٢١٢٧r = f10;
        this.f٢١٢٨s = f11;
    }

    public void x(boolean z10) {
        if (z10) {
            float[][] fArr = H;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = G;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = H;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = G;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[] fArr5 = G[this.f٢١١٠a];
        this.f٢١١٧h = fArr5[0];
        this.f٢١١٦g = fArr5[1];
        int i10 = this.f٢١١١b;
        float[][] fArr6 = H;
        if (i10 >= fArr6.length) {
            return;
        }
        float[] fArr7 = fArr6[i10];
        this.f٢١٢٢m = fArr7[0];
        this.f٢١٢٣n = fArr7[1];
    }

    public void y(int i10) {
        this.f٢١١٢c = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(float f10, float f11) {
        this.f٢١٢٧r = f10;
        this.f٢١٢٨s = f11;
        this.f٢١٢٤o = false;
    }
}
