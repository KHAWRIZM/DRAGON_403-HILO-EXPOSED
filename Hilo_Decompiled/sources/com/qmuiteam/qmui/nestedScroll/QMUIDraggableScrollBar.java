package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.d1;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qmuiteam.qmui.R;
import ic.e;
import ic.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIDraggableScrollBar extends View {

    /* renamed from: a, reason: collision with root package name */
    private int[] f١٢٨٢٠a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f١٢٨٢١b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f١٢٨٢٢c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٢٨٢٣d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٢٨٢٤e;

    /* renamed from: f, reason: collision with root package name */
    private long f١٢٨٢٥f;

    /* renamed from: g, reason: collision with root package name */
    private float f١٢٨٢٦g;

    /* renamed from: h, reason: collision with root package name */
    private float f١٢٨٢٧h;

    /* renamed from: i, reason: collision with root package name */
    private Runnable f١٢٨٢٨i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f١٢٨٢٩j;

    /* renamed from: k, reason: collision with root package name */
    private b f١٢٨٣٠k;

    /* renamed from: l, reason: collision with root package name */
    private int f١٢٨٣١l;

    /* renamed from: m, reason: collision with root package name */
    private float f١٢٨٣٢m;

    /* renamed from: n, reason: collision with root package name */
    private int f١٢٨٣٣n;

    /* renamed from: o, reason: collision with root package name */
    private int f١٢٨٣٤o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f١٢٨٣٥p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f١٢٨٣٦q;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QMUIDraggableScrollBar.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface b {
        void f();

        void h();

        void k(float f10);
    }

    public QMUIDraggableScrollBar(Context context) {
        this(context, null);
    }

    private void b(Drawable drawable, float f10) {
        float b10 = g.b(((f10 - getScrollBarTopMargin()) - this.f١٢٨٣٢m) / (((getHeight() - getScrollBarBottomMargin()) - getScrollBarTopMargin()) - drawable.getIntrinsicHeight()), DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        b bVar = this.f١٢٨٣٠k;
        if (bVar != null) {
            bVar.k(b10);
        }
        setPercentInternal(b10);
    }

    private void setPercentInternal(float f10) {
        this.f١٢٨٢٧h = f10;
        invalidate();
    }

    public void a() {
        if (this.f١٢٨٢٢c == null) {
            this.f١٢٨٢٢c = androidx.core.content.a.getDrawable(getContext(), R.drawable.qmui_icon_scroll_bar);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j10 = currentTimeMillis - this.f١٢٨٢٥f;
        int i10 = this.f١٢٨٢٤e;
        if (j10 > i10) {
            this.f١٢٨٢٥f = currentTimeMillis - i10;
        }
        d1.h0(this);
    }

    protected int getScrollBarBottomMargin() {
        return 0;
    }

    protected int getScrollBarTopMargin() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d2  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onDraw(Canvas canvas) {
        int i10;
        int i11;
        int i12;
        super.onDraw(canvas);
        Drawable drawable = this.f١٢٨٢٢c;
        if (drawable == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            if (this.f١٢٨٣٦q) {
                long currentTimeMillis = System.currentTimeMillis() - this.f١٢٨٢٥f;
                int i13 = this.f١٢٨٢٤e;
                if (currentTimeMillis < i13) {
                    this.f١٢٨٢٦g = (((float) currentTimeMillis) * 1.0f) / i13;
                } else {
                    long j10 = currentTimeMillis - i13;
                    int i14 = this.f١٢٨٢٣d;
                    if (j10 < i14) {
                        this.f١٢٨٢٦g = 1.0f;
                        i10 = (int) (i14 - (currentTimeMillis - i13));
                    } else {
                        long j11 = (currentTimeMillis - i13) - i14;
                        if (j11 < i13) {
                            this.f١٢٨٢٦g = 1.0f - ((((float) j11) * 1.0f) / i13);
                        } else {
                            this.f١٢٨٢٦g = DownloadProgress.UNKNOWN_PROGRESS;
                            i10 = -1;
                        }
                    }
                    if (this.f١٢٨٢٦g <= DownloadProgress.UNKNOWN_PROGRESS) {
                        return;
                    }
                }
                i10 = 0;
                if (this.f١٢٨٢٦g <= DownloadProgress.UNKNOWN_PROGRESS) {
                }
            } else {
                this.f١٢٨٢٦g = 1.0f;
                i10 = -1;
            }
            drawable.setAlpha((int) (this.f١٢٨٢٦g * 255.0f));
            int height = (getHeight() - getScrollBarTopMargin()) - getScrollBarBottomMargin();
            int width = getWidth();
            int scrollBarTopMargin = getScrollBarTopMargin() + ((int) ((height - intrinsicHeight) * this.f١٢٨٢٧h));
            int i15 = width - intrinsicWidth;
            if (!this.f١٢٨٢٩j && (i12 = this.f١٢٨٣١l) > 0 && this.f١٢٨٣٥p) {
                int i16 = scrollBarTopMargin - i12;
                int i17 = this.f١٢٨٣٤o;
                if (i16 > i17 && i16 < this.f١٢٨٣٣n) {
                    scrollBarTopMargin = i12 + i17;
                } else if (i16 < (-i17) && i16 > (-this.f١٢٨٣٣n)) {
                    scrollBarTopMargin = i12 - i17;
                }
                i11 = 0;
                i10 = 0;
                drawable.setBounds(i11, i11, intrinsicWidth, intrinsicHeight);
                canvas.save();
                canvas.translate(i15, scrollBarTopMargin);
                drawable.draw(canvas);
                canvas.restore();
                this.f١٢٨٣١l = scrollBarTopMargin;
                if (i10 != 0) {
                    invalidate();
                    return;
                } else {
                    if (i10 > 0) {
                        d1.j0(this, this.f١٢٨٢٨i, i10);
                        return;
                    }
                    return;
                }
            }
            i11 = 0;
            drawable.setBounds(i11, i11, intrinsicWidth, intrinsicHeight);
            canvas.save();
            canvas.translate(i15, scrollBarTopMargin);
            drawable.draw(canvas);
            canvas.restore();
            this.f١٢٨٣١l = scrollBarTopMargin;
            if (i10 != 0) {
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        Drawable drawable = this.f١٢٨٢٢c;
        if (drawable == null) {
            super.onMeasure(i10, i11);
        } else {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(drawable.getIntrinsicWidth(), 1073741824), i11);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable drawable = this.f١٢٨٢٢c;
        if (drawable == null) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (action == 0) {
            this.f١٢٨٢٩j = false;
            if (this.f١٢٨٢٦g > DownloadProgress.UNKNOWN_PROGRESS && x10 > getWidth() - drawable.getIntrinsicWidth()) {
                if (y10 >= this.f١٢٨٣١l && y10 <= r1 + drawable.getIntrinsicHeight()) {
                    this.f١٢٨٣٢m = y10 - this.f١٢٨٣١l;
                    getParent().requestDisallowInterceptTouchEvent(true);
                    this.f١٢٨٢٩j = true;
                    b bVar = this.f١٢٨٣٠k;
                    if (bVar != null) {
                        bVar.h();
                        this.f١٢٨٢٢c.setState(this.f١٢٨٢٠a);
                    }
                }
            }
        } else if (action == 2) {
            if (this.f١٢٨٢٩j) {
                getParent().requestDisallowInterceptTouchEvent(true);
                b(drawable, y10);
            }
        } else if ((action == 1 || action == 3) && this.f١٢٨٢٩j) {
            this.f١٢٨٢٩j = false;
            b(drawable, y10);
            b bVar2 = this.f١٢٨٣٠k;
            if (bVar2 != null) {
                bVar2.f();
                this.f١٢٨٢٢c.setState(this.f١٢٨٢١b);
            }
        }
        return this.f١٢٨٢٩j;
    }

    public void setAdjustDistanceWithAnimation(boolean z10) {
        this.f١٢٨٣٥p = z10;
    }

    public void setCallback(b bVar) {
        this.f١٢٨٣٠k = bVar;
    }

    public void setDragDrawable(Drawable drawable) {
        this.f١٢٨٢٢c = drawable.mutate();
        invalidate();
    }

    public void setEnableFadeInAndOut(boolean z10) {
        this.f١٢٨٣٦q = z10;
    }

    public void setKeepShownTime(int i10) {
        this.f١٢٨٢٣d = i10;
    }

    public void setPercent(float f10) {
        if (!this.f١٢٨٢٩j) {
            setPercentInternal(f10);
        }
    }

    public void setTransitionDuration(int i10) {
        this.f١٢٨٢٤e = i10;
    }

    public QMUIDraggableScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٢٨٢٠a = new int[]{android.R.attr.state_pressed};
        this.f١٢٨٢١b = new int[0];
        this.f١٢٨٢٣d = 800;
        this.f١٢٨٢٤e = 100;
        this.f١٢٨٢٥f = 0L;
        this.f١٢٨٢٦g = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٨٢٧h = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٨٢٨i = new a();
        this.f١٢٨٢٩j = false;
        this.f١٢٨٣١l = -1;
        this.f١٢٨٣٢m = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٨٣٣n = e.a(getContext(), 20);
        this.f١٢٨٣٤o = e.a(getContext(), 4);
        this.f١٢٨٣٥p = true;
        this.f١٢٨٣٦q = true;
    }
}
