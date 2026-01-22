package com.qmuiteam.qmui.qqface;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.qqface.a;
import ic.e;
import ic.g;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIQQFaceView extends View {
    private int A;

    /* renamed from: B, reason: collision with root package name */
    private int f١٢٨٤١B;
    private int C;
    private b D;
    private boolean E;
    private boolean F;
    private Typeface G;
    private int H;
    private int I;
    private int J;
    private final int[] K;
    private boolean L;
    private ColorStateList M;
    private int N;
    d O;
    private boolean P;
    private int Q;
    private int R;
    private int S;
    private boolean T;
    private int U;
    private int V;
    private int W;

    /* renamed from: a, reason: collision with root package name */
    private CharSequence f١٢٨٤٢a;

    /* renamed from: a0, reason: collision with root package name */
    private int f١٢٨٤٣a0;

    /* renamed from: b, reason: collision with root package name */
    private a.c f١٢٨٤٤b;

    /* renamed from: b0, reason: collision with root package name */
    private int f١٢٨٤٥b0;

    /* renamed from: c, reason: collision with root package name */
    private com.qmuiteam.qmui.qqface.a f١٢٨٤٦c;

    /* renamed from: c0, reason: collision with root package name */
    private int f١٢٨٤٧c0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f١٢٨٤٨d;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f١٢٨٤٩d0;

    /* renamed from: e, reason: collision with root package name */
    private TextPaint f١٢٨٥٠e;

    /* renamed from: e0, reason: collision with root package name */
    private int f١٢٨٥١e0;

    /* renamed from: f, reason: collision with root package name */
    private Paint f١٢٨٥٢f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f١٢٨٥٣f0;

    /* renamed from: g, reason: collision with root package name */
    private int f١٢٨٥٤g;

    /* renamed from: g0, reason: collision with root package name */
    private int f١٢٨٥٥g0;

    /* renamed from: h, reason: collision with root package name */
    private ColorStateList f١٢٨٥٦h;

    /* renamed from: i, reason: collision with root package name */
    private int f١٢٨٥٧i;

    /* renamed from: j, reason: collision with root package name */
    private int f١٢٨٥٨j;

    /* renamed from: k, reason: collision with root package name */
    private int f١٢٨٥٩k;

    /* renamed from: l, reason: collision with root package name */
    private int f١٢٨٦٠l;

    /* renamed from: m, reason: collision with root package name */
    private int f١٢٨٦١m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f١٢٨٦٢n;

    /* renamed from: o, reason: collision with root package name */
    private int f١٢٨٦٣o;

    /* renamed from: p, reason: collision with root package name */
    private HashMap f١٢٨٦٤p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f١٢٨٦٥q;

    /* renamed from: r, reason: collision with root package name */
    private Rect f١٢٨٦٦r;

    /* renamed from: s, reason: collision with root package name */
    private String f١٢٨٦٧s;

    /* renamed from: t, reason: collision with root package name */
    private ColorStateList f١٢٨٦٨t;

    /* renamed from: u, reason: collision with root package name */
    private ColorStateList f١٢٨٦٩u;

    /* renamed from: v, reason: collision with root package name */
    private int f١٢٨٧٠v;

    /* renamed from: w, reason: collision with root package name */
    private int f١٢٨٧١w;

    /* renamed from: x, reason: collision with root package name */
    private TextUtils.TruncateAt f١٢٨٧٢x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f١٢٨٧٣y;

    /* renamed from: z, reason: collision with root package name */
    private int f١٢٨٧٤z;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QMUIQQFaceView.this.D != null) {
                QMUIQQFaceView.this.D.run();
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference f١٢٨٧٦a;

        public b(d dVar) {
            this.f١٢٨٧٦a = new WeakReference(dVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = (d) this.f١٢٨٧٦a.get();
            if (dVar != null) {
                dVar.d(false);
                dVar.a();
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface c {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        private com.qmuiteam.qmui.link.a f١٢٨٧٧a;

        /* renamed from: b, reason: collision with root package name */
        private int f١٢٨٧٨b = -1;

        /* renamed from: c, reason: collision with root package name */
        private int f١٢٨٧٩c = -1;

        /* renamed from: d, reason: collision with root package name */
        private int f١٢٨٨٠d = -1;

        /* renamed from: e, reason: collision with root package name */
        private int f١٢٨٨١e = -1;

        public d(com.qmuiteam.qmui.link.a aVar) {
            this.f١٢٨٧٧a = aVar;
        }

        public void a() {
            int paddingTop = QMUIQQFaceView.this.getPaddingTop();
            int i10 = this.f١٢٨٨٠d;
            if (i10 > 1) {
                paddingTop += (i10 - 1) * (QMUIQQFaceView.this.f١٢٨٥٨j + QMUIQQFaceView.this.f١٢٨٥٧i);
            }
            int i11 = ((this.f١٢٨٨١e - 1) * (QMUIQQFaceView.this.f١٢٨٥٨j + QMUIQQFaceView.this.f١٢٨٥٧i)) + paddingTop + QMUIQQFaceView.this.f١٢٨٥٨j;
            Rect rect = new Rect();
            rect.top = paddingTop;
            rect.bottom = i11;
            rect.left = QMUIQQFaceView.this.getPaddingLeft();
            rect.right = QMUIQQFaceView.this.getWidth() - QMUIQQFaceView.this.getPaddingRight();
            if (this.f١٢٨٨٠d == this.f١٢٨٨١e) {
                rect.left = this.f١٢٨٧٨b;
                rect.right = this.f١٢٨٧٩c;
            }
            QMUIQQFaceView.this.invalidate(rect);
        }

        public void b() {
            this.f١٢٨٧٧a.onClick(QMUIQQFaceView.this);
        }

        public boolean c(int i10, int i11) {
            int paddingTop = QMUIQQFaceView.this.getPaddingTop();
            int i12 = this.f١٢٨٨٠d;
            if (i12 > 1) {
                paddingTop += (i12 - 1) * (QMUIQQFaceView.this.f١٢٨٥٨j + QMUIQQFaceView.this.f١٢٨٥٧i);
            }
            int paddingTop2 = ((this.f١٢٨٨١e - 1) * (QMUIQQFaceView.this.f١٢٨٥٨j + QMUIQQFaceView.this.f١٢٨٥٧i)) + QMUIQQFaceView.this.getPaddingTop() + QMUIQQFaceView.this.f١٢٨٥٨j;
            if (i11 < paddingTop || i11 > paddingTop2) {
                return false;
            }
            if (this.f١٢٨٨٠d == this.f١٢٨٨١e) {
                if (i10 >= this.f١٢٨٧٨b && i10 <= this.f١٢٨٧٩c) {
                    return true;
                }
                return false;
            }
            int i13 = paddingTop + QMUIQQFaceView.this.f١٢٨٥٨j;
            int i14 = paddingTop2 - QMUIQQFaceView.this.f١٢٨٥٨j;
            if (i11 > i13 && i11 < i14) {
                if (this.f١٢٨٨١e - this.f١٢٨٨٠d != 1) {
                    return true;
                }
                if (i10 >= this.f١٢٨٧٨b && i10 <= this.f١٢٨٧٩c) {
                    return true;
                }
                return false;
            }
            if (i11 <= i13) {
                if (i10 >= this.f١٢٨٧٨b) {
                    return true;
                }
                return false;
            }
            if (i10 <= this.f١٢٨٧٩c) {
                return true;
            }
            return false;
        }

        public void d(boolean z10) {
            this.f١٢٨٧٧a.a(z10);
        }
    }

    public QMUIQQFaceView(Context context) {
        this(context, null);
    }

    private void A(CharSequence charSequence, boolean z10) {
        com.qmuiteam.qmui.qqface.a aVar;
        if (z10 && g.g(charSequence, this.f١٢٨٤٢a)) {
            return;
        }
        this.f١٢٨٤٢a = charSequence;
        setContentDescription(charSequence);
        if (this.f١٢٨٤٨d && this.f١٢٨٤٦c == null) {
            throw new RuntimeException("mCompiler == null");
        }
        this.f١٢٨٦٤p.clear();
        if (g.f(this.f١٢٨٤٢a)) {
            this.f١٢٨٤٤b = null;
            requestLayout();
            invalidate();
            return;
        }
        if (this.f١٢٨٤٨d && (aVar = this.f١٢٨٤٦c) != null) {
            a.c b10 = aVar.b(this.f١٢٨٤٢a);
            this.f١٢٨٤٤b = b10;
            List b11 = b10.b();
            if (b11 != null) {
                for (int i10 = 0; i10 < b11.size(); i10++) {
                    a.b bVar = (a.b) b11.get(i10);
                    if (bVar.k() == a.d.SPAN) {
                        HashMap hashMap = this.f١٢٨٦٤p;
                        bVar.j();
                        hashMap.put(bVar, new d(null));
                    }
                }
            }
        } else {
            this.f١٢٨٤٤b = new a.c(0, this.f١٢٨٤٢a.length());
            String[] split = this.f١٢٨٤٢a.toString().split("\\n");
            for (int i11 = 0; i11 < split.length; i11++) {
                this.f١٢٨٤٤b.a(a.b.d(split[i11]));
                if (i11 != split.length - 1) {
                    this.f١٢٨٤٤b.a(a.b.b());
                }
            }
        }
        this.T = true;
        if (getLayoutParams() == null) {
            return;
        }
        if (getLayoutParams().width != -2 && getLayoutParams().height != -2) {
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            if (getWidth() > paddingLeft && getHeight() > paddingBottom) {
                this.f١٢٨٦٣o = 0;
                e(getWidth());
                int i12 = this.f١٢٨٧٤z;
                int height = getHeight() - paddingBottom;
                int i13 = this.f١٢٨٥٧i;
                g(Math.min((height + i13) / (this.f١٢٨٥٨j + i13), this.f١٢٨٦١m));
                if (i12 == this.f١٢٨٧٤z) {
                    invalidate();
                    return;
                } else {
                    requestLayout();
                    invalidate();
                    return;
                }
            }
            return;
        }
        requestLayout();
        invalidate();
    }

    private void B(int i10, int i11) {
        C(i10, false, i11);
    }

    private void C(int i10, boolean z10, int i11) {
        int i12;
        TextUtils.TruncateAt truncateAt;
        if (z10 && ((truncateAt = this.f١٢٨٧٢x) == null || truncateAt == TextUtils.TruncateAt.END)) {
            i12 = this.H;
        } else {
            i12 = 0;
        }
        int i13 = i12 + this.f١٢٨٥٧i;
        int i14 = this.f١٢٨٤٥b0 + 1;
        this.f١٢٨٤٥b0 = i14;
        if (this.f١٢٨٧٣y) {
            TextUtils.TruncateAt truncateAt2 = this.f١٢٨٧٢x;
            if (truncateAt2 == TextUtils.TruncateAt.START) {
                if (i14 > (this.f١٢٨٦٣o - this.f١٢٨٧٤z) + 1) {
                    this.f١٢٨٤٣a0 += this.f١٢٨٥٨j + i13;
                }
            } else if (truncateAt2 == TextUtils.TruncateAt.MIDDLE) {
                if (!this.f١٢٨٥٣f0 || this.f١٢٨٥١e0 == -1) {
                    this.f١٢٨٤٣a0 += this.f١٢٨٥٨j + i13;
                }
            } else {
                this.f١٢٨٤٣a0 += this.f١٢٨٥٨j + i13;
            }
            if (truncateAt2 != null && truncateAt2 != TextUtils.TruncateAt.END && this.f١٢٨٤٣a0 > getHeight() - getPaddingBottom()) {
                yb.b.a("QMUIQQFaceView", "draw outside the visible height, the ellipsize is inaccurate: mEllipsize = %s; mCurrentDrawLine = %d; mNeedDrawLine = %d;viewWidth = %d; viewHeight = %d; paddingLeft = %d; paddingRight = %d; paddingTop = %d; paddingBottom = %d; text = %s", this.f١٢٨٧٢x.name(), Integer.valueOf(this.f١٢٨٤٥b0), Integer.valueOf(this.f١٢٨٧٤z), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()), Integer.valueOf(getPaddingLeft()), Integer.valueOf(getPaddingRight()), Integer.valueOf(getPaddingTop()), Integer.valueOf(getPaddingBottom()), this.f١٢٨٤٢a);
            }
        } else {
            this.f١٢٨٤٣a0 += this.f١٢٨٥٨j + i13;
        }
        z(i10, i11);
    }

    private void f(List list, int i10) {
        int i11;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i10 - getPaddingRight();
        for (int i12 = 0; i12 < list.size() && !this.E; i12++) {
            if (this.R <= this.f١٢٨٦١m || this.f١٢٨٧٢x != TextUtils.TruncateAt.END) {
                a.b bVar = (a.b) list.get(i12);
                if (bVar.k() == a.d.DRAWABLE) {
                    if (this.Q + this.f١٢٨٥٩k > paddingRight) {
                        n(paddingLeft);
                    }
                    int i13 = this.Q;
                    int i14 = this.f١٢٨٥٩k;
                    this.Q = i13 + i14;
                    if (paddingRight - paddingLeft < i14) {
                        this.E = true;
                    }
                } else if (bVar.k() == a.d.TEXT) {
                    t(bVar.i(), paddingLeft, paddingRight);
                } else if (bVar.k() == a.d.SPAN) {
                    a.c f10 = bVar.f();
                    bVar.j();
                    if (f10 != null && f10.b().size() > 0) {
                        f(f10.b(), i10);
                    }
                } else if (bVar.k() == a.d.NEXTLINE) {
                    o(paddingLeft, true);
                } else if (bVar.k() == a.d.SPECIAL_BOUNDS_DRAWABLE) {
                    int intrinsicWidth = bVar.h().getIntrinsicWidth();
                    if (i12 != 0 && i12 != list.size() - 1) {
                        i11 = this.I * 2;
                    } else {
                        i11 = this.I;
                    }
                    int i15 = intrinsicWidth + i11;
                    int i16 = this.Q;
                    if (i16 + i15 > paddingRight) {
                        n(paddingLeft);
                        this.Q += i15;
                    } else if (i16 + i15 == paddingRight) {
                        n(paddingLeft);
                    } else {
                        this.Q = i16 + i15;
                    }
                    if (paddingRight - paddingLeft < i15) {
                        this.E = true;
                    }
                }
            } else {
                return;
            }
        }
    }

    private void g(int i10) {
        int i11 = this.f١٢٨٦٣o;
        this.f١٢٨٧٤z = i11;
        boolean z10 = true;
        if (this.f١٢٨٦٢n) {
            this.f١٢٨٧٤z = Math.min(1, i11);
        } else if (i10 < i11) {
            this.f١٢٨٧٤z = i10;
        }
        if (this.f١٢٨٦٣o <= this.f١٢٨٧٤z) {
            z10 = false;
        }
        this.f١٢٨٧٣y = z10;
    }

    private int getMiddleEllipsizeLine() {
        int i10 = this.f١٢٨٧٤z;
        if (i10 % 2 == 0) {
            return i10 / 2;
        }
        return (i10 + 1) / 2;
    }

    private void h(Canvas canvas, List list, int i10) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int paddingLeft = getPaddingLeft();
        int i11 = i10 + paddingLeft;
        if (this.f١٢٨٧٣y && this.f١٢٨٧٢x == TextUtils.TruncateAt.START) {
            canvas.drawText("...", 0, 3, paddingLeft, this.f١٢٨٦٠l, (Paint) this.f١٢٨٥٠e);
        }
        for (int i12 = 0; i12 < list.size(); i12++) {
            a.b bVar = (a.b) list.get(i12);
            a.d k10 = bVar.k();
            if (k10 == a.d.DRAWABLE) {
                int g10 = bVar.g();
                if (i12 == 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (i12 == list.size() - 1) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                u(canvas, g10, null, paddingLeft, i11, z12, z13);
            } else if (k10 == a.d.SPECIAL_BOUNDS_DRAWABLE) {
                Drawable h10 = bVar.h();
                if (i12 == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (i12 == list.size() - 1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                u(canvas, 0, h10, paddingLeft, i11, z10, z11);
            } else if (k10 == a.d.TEXT) {
                CharSequence i13 = bVar.i();
                float[] fArr = new float[i13.length()];
                this.f١٢٨٥٠e.getTextWidths(i13.toString(), fArr);
                v(canvas, i13, fArr, 0, paddingLeft, i11);
            } else if (k10 == a.d.SPAN) {
                a.c f10 = bVar.f();
                bVar.j();
                if (f10 != null && !f10.b().isEmpty()) {
                    h(canvas, f10.b(), i10);
                }
            } else if (k10 == a.d.NEXTLINE) {
                int i14 = this.f١٢٨٧١w;
                int i15 = this.f١٢٨٧٠v + i14;
                if (this.f١٢٨٧٣y && this.f١٢٨٧٢x == TextUtils.TruncateAt.END && this.f١٢٨٤٧c0 <= i11 - i15 && this.f١٢٨٤٥b0 == this.f١٢٨٧٤z) {
                    k(canvas, "...", 0, 3, i14);
                    this.f١٢٨٤٧c0 += this.f١٢٨٧١w;
                    i(canvas, i11);
                    return;
                }
                C(paddingLeft, true, i10);
            } else {
                continue;
            }
        }
    }

    private void i(Canvas canvas, int i10) {
        int i11;
        if (!g.f(this.f١٢٨٦٧s)) {
            ColorStateList colorStateList = this.f١٢٨٦٨t;
            if (colorStateList == null) {
                colorStateList = this.f١٢٨٥٦h;
            }
            int i12 = 0;
            if (colorStateList != null) {
                i11 = colorStateList.getDefaultColor();
                if (this.f١٢٨٦٥q) {
                    i11 = colorStateList.getColorForState(this.K, i11);
                }
            } else {
                i11 = 0;
            }
            ColorStateList colorStateList2 = this.f١٢٨٦٩u;
            if (colorStateList2 != null) {
                i12 = colorStateList2.getDefaultColor();
                if (this.f١٢٨٦٥q) {
                    i12 = this.f١٢٨٦٩u.getColorForState(this.K, i12);
                }
            }
            int paddingTop = getPaddingTop();
            int i13 = this.f١٢٨٤٥b0;
            if (i13 > 1) {
                paddingTop += (i13 - 1) * (this.f١٢٨٥٨j + this.f١٢٨٥٧i);
            }
            Rect rect = this.f١٢٨٦٦r;
            int i14 = this.f١٢٨٤٧c0;
            rect.set(i14, paddingTop, this.f١٢٨٧٠v + i14, this.f١٢٨٥٨j + paddingTop);
            if (i12 != 0) {
                this.f١٢٨٥٢f.setColor(i12);
                this.f١٢٨٥٢f.setStyle(Paint.Style.FILL);
                canvas.drawRect(this.f١٢٨٦٦r, this.f١٢٨٥٢f);
            }
            this.f١٢٨٥٠e.setColor(i11);
            String str = this.f١٢٨٦٧s;
            canvas.drawText(str, 0, str.length(), this.f١٢٨٤٧c0, this.f١٢٨٤٣a0, (Paint) this.f١٢٨٥٠e);
            if (this.L && this.N > 0) {
                ColorStateList colorStateList3 = this.M;
                if (colorStateList3 == null) {
                    colorStateList3 = this.f١٢٨٥٦h;
                }
                if (colorStateList3 != null) {
                    int defaultColor = colorStateList3.getDefaultColor();
                    if (this.f١٢٨٦٥q) {
                        defaultColor = colorStateList3.getColorForState(this.K, defaultColor);
                    }
                    this.f١٢٨٥٢f.setColor(defaultColor);
                    this.f١٢٨٥٢f.setStyle(Paint.Style.STROKE);
                    this.f١٢٨٥٢f.setStrokeWidth(this.N);
                    Rect rect2 = this.f١٢٨٦٦r;
                    float f10 = rect2.left;
                    int i15 = rect2.bottom;
                    canvas.drawLine(f10, i15, rect2.right, i15, this.f١٢٨٥٢f);
                }
            }
            y();
        }
    }

    private void j(Canvas canvas, int i10, Drawable drawable, int i11, boolean z10, boolean z11) {
        Drawable drawable2;
        if (i10 != 0) {
            drawable2 = androidx.core.content.a.getDrawable(getContext(), i10);
        } else {
            drawable2 = drawable;
        }
        if (i10 == 0 && drawable != null) {
            drawable.getIntrinsicWidth();
        }
        if (drawable2 == null) {
            return;
        }
        int i12 = 0;
        if (i10 != 0) {
            int i13 = this.f١٢٨٥٨j;
            int i14 = this.f١٢٨٥٩k;
            int i15 = (i13 - i14) / 2;
            drawable2.setBounds(0, i15, i14, i15 + i14);
        } else {
            if (z11) {
                i12 = this.I;
            }
            int intrinsicWidth = drawable2.getIntrinsicWidth();
            int intrinsicHeight = drawable2.getIntrinsicHeight();
            int i16 = this.f١٢٨٥٨j;
            if (intrinsicHeight > i16) {
                intrinsicWidth = (int) (intrinsicWidth * (i16 / intrinsicHeight));
                intrinsicHeight = i16;
            }
            int i17 = (i16 - intrinsicHeight) / 2;
            drawable2.setBounds(i12, i17, intrinsicWidth + i12, intrinsicHeight + i17);
        }
        int paddingTop = getPaddingTop();
        if (i11 > 1) {
            paddingTop = this.f١٢٨٤٣a0 - this.f١٢٨٦٠l;
        }
        canvas.save();
        canvas.translate(this.f١٢٨٤٧c0, paddingTop);
        drawable2.draw(canvas);
        canvas.restore();
    }

    private void k(Canvas canvas, CharSequence charSequence, int i10, int i11, int i12) {
        if (i11 > i10 && i11 <= charSequence.length() && i10 < charSequence.length()) {
            canvas.drawText(charSequence, i10, i11, this.f١٢٨٤٧c0, this.f١٢٨٤٣a0, this.f١٢٨٥٠e);
        }
    }

    private void n(int i10) {
        o(i10, false);
    }

    private void o(int i10, boolean z10) {
        this.R++;
        setContentCalMaxWidth(this.Q);
        this.Q = i10;
        if (z10) {
            TextUtils.TruncateAt truncateAt = this.f١٢٨٧٢x;
            if (truncateAt == null) {
                this.A++;
            } else if (truncateAt == TextUtils.TruncateAt.END && this.R <= this.f١٢٨٦١m) {
                this.A++;
            }
        }
    }

    private void p(Canvas canvas, int i10, Drawable drawable, int i11, int i12, int i13, boolean z10, boolean z11) {
        int i14;
        int i15;
        int i16;
        if (i10 != 0) {
            i15 = this.f١٢٨٥٩k;
        } else {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (!z10 && !z11) {
                i14 = this.I * 2;
            } else {
                i14 = this.I;
            }
            i15 = intrinsicWidth + i14;
        }
        int i17 = this.f١٢٨٥١e0;
        if (i17 == -1) {
            w(canvas, i10, drawable, i13 - this.f١٢٨٥٥g0, i11, i12, z10, z11);
            return;
        }
        int i18 = this.f١٢٨٧٤z - i13;
        int i19 = this.Q;
        int i20 = (i12 - i19) - (i17 - i11);
        boolean z12 = true;
        int i21 = this.f١٢٨٦٣o - i18;
        if (i20 > 0) {
            i21--;
        }
        if (i20 > 0) {
            i16 = i12 - i20;
        } else {
            i16 = i17 - (i12 - i19);
        }
        int i22 = this.f١٢٨٤٥b0;
        if (i22 < i21) {
            int i23 = this.f١٢٨٤٧c0;
            if (i15 + i23 > i12) {
                B(i11, i12 - i11);
                u(canvas, i10, drawable, i11, i12, z10, z11);
                return;
            } else {
                this.f١٢٨٤٧c0 = i23 + i15;
                return;
            }
        }
        if (i22 == i21) {
            int i24 = this.f١٢٨٤٧c0;
            if (i15 + i24 <= i16) {
                this.f١٢٨٤٧c0 = i24 + i15;
                return;
            }
            if (i24 < i16) {
                z12 = false;
            }
            this.f١٢٨٤٧c0 = i17;
            this.f١٢٨٥١e0 = -1;
            this.f١٢٨٥٥g0 = i21;
            if (z12) {
                u(canvas, i10, drawable, i11, i12, z10, z11);
                return;
            }
            return;
        }
        w(canvas, i10, drawable, i13 - i21, i11, i12, z10, z11);
    }

    private void q(Canvas canvas, CharSequence charSequence, float[] fArr, int i10, int i11, int i12, int i13) {
        int i14;
        int i15 = i10;
        if (i15 >= charSequence.length()) {
            return;
        }
        int i16 = this.f١٢٨٥١e0;
        if (i16 == -1) {
            x(canvas, charSequence, fArr, i10, i12, i13);
            return;
        }
        int i17 = this.f١٢٨٧٤z - i11;
        int i18 = this.Q;
        int i19 = (i13 - i18) - (i16 - i12);
        int i20 = this.f١٢٨٦٣o - i17;
        if (i19 > 0) {
            i20--;
        }
        if (i19 > 0) {
            i14 = i13 - i19;
        } else {
            i14 = i16 - (i13 - i18);
        }
        int i21 = this.f١٢٨٤٥b0;
        if (i21 < i20) {
            while (i15 < fArr.length) {
                int i22 = this.f١٢٨٤٧c0;
                float f10 = fArr[i15];
                if (i22 + f10 <= i13) {
                    this.f١٢٨٤٧c0 = (int) (i22 + f10);
                    i15++;
                } else {
                    B(i12, i12 - i13);
                    q(canvas, charSequence, fArr, i15, i11, i12, i13);
                    return;
                }
            }
            return;
        }
        if (i21 == i20) {
            while (i15 < fArr.length) {
                int i23 = this.f١٢٨٤٧c0;
                float f11 = fArr[i15];
                if (i23 + f11 <= i14) {
                    this.f١٢٨٤٧c0 = (int) (i23 + f11);
                    i15++;
                } else {
                    int i24 = i15 + 1;
                    if (i23 < i14) {
                        i15 = i24;
                    }
                    this.f١٢٨٤٧c0 = this.f١٢٨٥١e0;
                    this.f١٢٨٥١e0 = -1;
                    this.f١٢٨٥٥g0 = i20;
                    x(canvas, charSequence, fArr, i15, i12, i13);
                    return;
                }
            }
            return;
        }
        x(canvas, charSequence, fArr, i10, i12, i13);
    }

    private boolean r() {
        a.c cVar = this.f١٢٨٤٤b;
        if (cVar != null && cVar.b() != null && !this.f١٢٨٤٤b.b().isEmpty()) {
            return false;
        }
        return true;
    }

    private void s() {
        if (g.f(this.f١٢٨٦٧s)) {
            this.f١٢٨٧٠v = 0;
        } else {
            this.f١٢٨٧٠v = (int) Math.ceil(this.f١٢٨٥٠e.measureText(this.f١٢٨٦٧s));
        }
    }

    private void setContentCalMaxWidth(int i10) {
        this.S = Math.max(i10, this.S);
    }

    private void t(CharSequence charSequence, int i10, int i11) {
        int length = charSequence.length();
        float[] fArr = new float[length];
        this.f١٢٨٥٠e.getTextWidths(charSequence.toString(), fArr);
        int i12 = i11 - i10;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i13 = 0; i13 < length; i13++) {
            if (i12 < fArr[i13]) {
                this.E = true;
                return;
            }
            if (System.currentTimeMillis() - currentTimeMillis > 2000) {
                yb.b.a("QMUIQQFaceView", "measureText: text = %s, mCurrentCalWidth = %d, widthStart = %d, widthEnd = %d", charSequence, Integer.valueOf(this.Q), Integer.valueOf(i10), Integer.valueOf(i11));
                this.E = true;
                return;
            } else {
                if (this.Q + fArr[i13] > i11) {
                    n(i10);
                }
                this.Q = (int) (this.Q + Math.ceil(fArr[i13]));
            }
        }
    }

    private void u(Canvas canvas, int i10, Drawable drawable, int i11, int i12, boolean z10, boolean z11) {
        int i13;
        int i14;
        if (i10 == 0 && drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (!z10 && !z11) {
                i14 = this.I * 2;
            } else {
                i14 = this.I;
            }
            i13 = intrinsicWidth + i14;
        } else {
            i13 = this.f١٢٨٥٩k;
        }
        int i15 = i13;
        if (this.f١٢٨٧٣y) {
            TextUtils.TruncateAt truncateAt = this.f١٢٨٧٢x;
            if (truncateAt == TextUtils.TruncateAt.START) {
                int i16 = this.f١٢٨٤٥b0;
                int i17 = this.f١٢٨٦٣o;
                int i18 = this.f١٢٨٧٤z;
                if (i16 > i17 - i18) {
                    w(canvas, i10, drawable, i18 - i17, i11, i12, z10, z11);
                    return;
                }
                if (i16 < i17 - i18) {
                    int i19 = this.f١٢٨٤٧c0;
                    if (i15 + i19 > i12) {
                        B(i11, i12 - i11);
                        u(canvas, i10, drawable, i11, i12, z10, z11);
                        return;
                    } else {
                        this.f١٢٨٤٧c0 = i19 + i15;
                        return;
                    }
                }
                int i20 = this.Q;
                int i21 = this.f١٢٨٧١w;
                int i22 = i20 + i21;
                int i23 = this.f١٢٨٤٧c0;
                if (i15 + i23 < i22) {
                    this.f١٢٨٤٧c0 = i23 + i15;
                    return;
                } else {
                    B(i11 + i21, i12 - i11);
                    return;
                }
            }
            if (truncateAt == TextUtils.TruncateAt.MIDDLE) {
                int middleEllipsizeLine = getMiddleEllipsizeLine();
                int i24 = this.f١٢٨٤٥b0;
                if (i24 < middleEllipsizeLine) {
                    if (this.f١٢٨٤٧c0 + i15 > i12) {
                        w(canvas, i10, drawable, 0, i11, i12, z10, z11);
                        return;
                    } else {
                        j(canvas, i10, drawable, i24, z10, z11);
                        this.f١٢٨٤٧c0 += i15;
                        return;
                    }
                }
                if (i24 == middleEllipsizeLine) {
                    int width = getWidth() / 2;
                    int i25 = this.f١٢٨٧١w;
                    int i26 = width - (i25 / 2);
                    if (this.f١٢٨٥٣f0) {
                        p(canvas, i10, drawable, i11, i12, middleEllipsizeLine, z10, z11);
                        return;
                    }
                    if (this.f١٢٨٤٧c0 + i15 <= i26) {
                        j(canvas, i10, drawable, this.f١٢٨٤٥b0, z10, z11);
                        this.f١٢٨٤٧c0 += i15;
                        return;
                    } else {
                        k(canvas, "...", 0, 3, i25);
                        this.f١٢٨٥١e0 = this.f١٢٨٤٧c0 + this.f١٢٨٧١w;
                        this.f١٢٨٥٣f0 = true;
                        p(canvas, i10, drawable, i11, i12, middleEllipsizeLine, z10, z11);
                        return;
                    }
                }
                p(canvas, i10, drawable, i11, i12, middleEllipsizeLine, z10, z11);
                return;
            }
            int i27 = this.f١٢٨٤٥b0;
            int i28 = this.f١٢٨٧٤z;
            if (i27 == i28) {
                int i29 = this.f١٢٨٧٠v;
                TextUtils.TruncateAt truncateAt2 = TextUtils.TruncateAt.END;
                if (truncateAt == truncateAt2) {
                    i29 += this.f١٢٨٧١w;
                }
                int i30 = this.f١٢٨٤٧c0;
                int i31 = i12 - i29;
                if (i15 + i30 >= i31) {
                    if (i30 + i15 == i31) {
                        j(canvas, i10, drawable, i27, z10, z11);
                        this.f١٢٨٤٧c0 += i15;
                    }
                    if (this.f١٢٨٧٢x == truncateAt2) {
                        k(canvas, "...", 0, 3, this.f١٢٨٧١w);
                        this.f١٢٨٤٧c0 += this.f١٢٨٧١w;
                    }
                    i(canvas, i12);
                    B(i11, i12 - i11);
                    return;
                }
                j(canvas, i10, drawable, i27, z10, z11);
                this.f١٢٨٤٧c0 += i15;
                return;
            }
            if (i27 < i28) {
                if (this.f١٢٨٤٧c0 + i15 > i12) {
                    w(canvas, i10, drawable, 0, i11, i12, z10, z11);
                    return;
                } else {
                    j(canvas, i10, drawable, i27, z10, z11);
                    this.f١٢٨٤٧c0 += i15;
                    return;
                }
            }
            return;
        }
        w(canvas, i10, drawable, 0, i11, i12, z10, z11);
    }

    private void v(Canvas canvas, CharSequence charSequence, float[] fArr, int i10, int i11, int i12) {
        int i13 = i10;
        if (i13 >= charSequence.length()) {
            return;
        }
        if (this.f١٢٨٧٣y) {
            TextUtils.TruncateAt truncateAt = this.f١٢٨٧٢x;
            if (truncateAt == TextUtils.TruncateAt.START) {
                int i14 = this.f١٢٨٤٥b0;
                int i15 = this.f١٢٨٦٣o;
                int i16 = this.f١٢٨٧٤z;
                if (i14 > i15 - i16) {
                    x(canvas, charSequence, fArr, i10, i11, i12);
                    return;
                }
                if (i14 < i15 - i16) {
                    while (i13 < charSequence.length()) {
                        int i17 = this.f١٢٨٤٧c0;
                        float f10 = fArr[i13];
                        if (i17 + f10 <= i12) {
                            this.f١٢٨٤٧c0 = (int) (i17 + f10);
                            i13++;
                        } else {
                            B(i11, i12 - i11);
                            v(canvas, charSequence, fArr, i13, i11, i12);
                            return;
                        }
                    }
                    return;
                }
                int i18 = this.Q + this.f١٢٨٧١w;
                while (i13 < charSequence.length()) {
                    int i19 = this.f١٢٨٤٧c0;
                    float f11 = fArr[i13];
                    if (i19 + f11 <= i18) {
                        this.f١٢٨٤٧c0 = (int) (i19 + f11);
                        i13++;
                    } else {
                        int i20 = i13 + 1;
                        if (i19 <= i18) {
                            i13 = i20;
                        }
                        B(this.f١٢٨٧١w + i11, i12 - i11);
                        v(canvas, charSequence, fArr, i13, i11, i12);
                        return;
                    }
                }
                return;
            }
            if (truncateAt == TextUtils.TruncateAt.MIDDLE) {
                int middleEllipsizeLine = getMiddleEllipsizeLine();
                int i21 = this.f١٢٨٤٥b0;
                if (i21 < middleEllipsizeLine) {
                    int i22 = this.f١٢٨٤٧c0;
                    for (int i23 = i13; i23 < fArr.length; i23++) {
                        float f12 = i22;
                        float f13 = fArr[i23];
                        if (f12 + f13 <= i12) {
                            i22 = (int) (f12 + f13);
                        } else {
                            int i24 = i23;
                            k(canvas, charSequence, i10, i24, i12 - this.f١٢٨٤٧c0);
                            B(i11, i12 - i11);
                            v(canvas, charSequence, fArr, i24, i11, i12);
                            return;
                        }
                    }
                    k(canvas, charSequence, i10, charSequence.length(), i22 - this.f١٢٨٤٧c0);
                    this.f١٢٨٤٧c0 = i22;
                    return;
                }
                if (i21 == middleEllipsizeLine) {
                    if (this.f١٢٨٥٣f0) {
                        q(canvas, charSequence, fArr, i10, middleEllipsizeLine, i11, i12);
                        return;
                    }
                    int i25 = ((i12 + i11) / 2) - (this.f١٢٨٧١w / 2);
                    int i26 = this.f١٢٨٤٧c0;
                    for (int i27 = i13; i27 < fArr.length; i27++) {
                        float f14 = i26;
                        float f15 = fArr[i27];
                        if (f14 + f15 <= i25) {
                            i26 = (int) (f14 + f15);
                        } else {
                            k(canvas, charSequence, i10, i27, i26 - this.f١٢٨٤٧c0);
                            this.f١٢٨٤٧c0 = i26;
                            k(canvas, "...", 0, 3, this.f١٢٨٧١w);
                            this.f١٢٨٥١e0 = this.f١٢٨٤٧c0 + this.f١٢٨٧١w;
                            this.f١٢٨٥٣f0 = true;
                            q(canvas, charSequence, fArr, i27, middleEllipsizeLine, i11, i12);
                            return;
                        }
                    }
                    k(canvas, charSequence, i10, charSequence.length(), i26 - this.f١٢٨٤٧c0);
                    this.f١٢٨٤٧c0 = i26;
                    return;
                }
                q(canvas, charSequence, fArr, i10, middleEllipsizeLine, i11, i12);
                return;
            }
            int i28 = this.f١٢٨٤٥b0;
            int i29 = this.f١٢٨٧٤z;
            if (i28 < i29) {
                int i30 = this.f١٢٨٤٧c0;
                for (int i31 = i13; i31 < fArr.length; i31++) {
                    float f16 = i30;
                    float f17 = fArr[i31];
                    if (f16 + f17 <= i12) {
                        i30 = (int) (f16 + f17);
                    } else {
                        int i32 = i31;
                        k(canvas, charSequence, i10, i32, i12 - this.f١٢٨٤٧c0);
                        B(i11, i12 - i11);
                        v(canvas, charSequence, fArr, i32, i11, i12);
                        return;
                    }
                }
                k(canvas, charSequence, i10, fArr.length, i30 - this.f١٢٨٤٧c0);
                this.f١٢٨٤٧c0 = i30;
                return;
            }
            if (i28 == i29) {
                int i33 = this.f١٢٨٧٠v;
                if (truncateAt == TextUtils.TruncateAt.END) {
                    i33 += this.f١٢٨٧١w;
                }
                int i34 = this.f١٢٨٤٧c0;
                for (int i35 = i13; i35 < fArr.length; i35++) {
                    float f18 = i34;
                    float f19 = fArr[i35];
                    if (f18 + f19 <= i12 - i33) {
                        i34 = (int) (f18 + f19);
                    } else {
                        k(canvas, charSequence, i10, i35, i34 - this.f١٢٨٤٧c0);
                        this.f١٢٨٤٧c0 = i34;
                        if (this.f١٢٨٧٢x == TextUtils.TruncateAt.END) {
                            k(canvas, "...", 0, 3, this.f١٢٨٧١w);
                            this.f١٢٨٤٧c0 += this.f١٢٨٧١w;
                        }
                        i(canvas, i12);
                        B(i11, i12 - i11);
                        return;
                    }
                }
                k(canvas, charSequence, i10, fArr.length, i34 - this.f١٢٨٤٧c0);
                this.f١٢٨٤٧c0 = i34;
                return;
            }
            return;
        }
        x(canvas, charSequence, fArr, 0, i11, i12);
    }

    private void w(Canvas canvas, int i10, Drawable drawable, int i11, int i12, int i13, boolean z10, boolean z11) {
        int i14;
        int i15;
        if (i10 == 0 && drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (!z10 && !z11) {
                i15 = this.I * 2;
            } else {
                i15 = this.I;
            }
            i14 = intrinsicWidth + i15;
        } else {
            i14 = this.f١٢٨٥٩k;
        }
        int i16 = i14;
        if (this.f١٢٨٤٧c0 + i16 > i13) {
            B(i12, i13 - i12);
        }
        j(canvas, i10, drawable, this.f١٢٨٤٥b0 + i11, z10, z11);
        this.f١٢٨٤٧c0 += i16;
    }

    private void x(Canvas canvas, CharSequence charSequence, float[] fArr, int i10, int i11, int i12) {
        int i13 = this.f١٢٨٤٧c0;
        int i14 = i10;
        while (i10 < fArr.length) {
            if (i13 + fArr[i10] > i12) {
                k(canvas, charSequence, i14, i10, i12 - this.f١٢٨٤٧c0);
                B(i11, i12 - i11);
                i13 = this.f١٢٨٤٧c0;
                i14 = i10;
            }
            i13 = (int) (i13 + fArr[i10]);
            i10++;
        }
        if (i14 < fArr.length) {
            k(canvas, charSequence, i14, fArr.length, i13 - this.f١٢٨٤٧c0);
            this.f١٢٨٤٧c0 = i13;
        }
    }

    private void y() {
        ColorStateList colorStateList = this.f١٢٨٥٦h;
        if (colorStateList != null) {
            int defaultColor = colorStateList.getDefaultColor();
            if (isPressed()) {
                this.f١٢٨٥٠e.setColor(this.f١٢٨٥٦h.getColorForState(this.K, defaultColor));
            } else {
                this.f١٢٨٥٠e.setColor(defaultColor);
            }
        }
    }

    private void z(int i10, int i11) {
        if (this.f١٢٨٧٣y) {
            this.f١٢٨٤٧c0 = i10;
            return;
        }
        if (this.f١٢٨٤٥b0 == this.f١٢٨٧٤z) {
            int i12 = this.J;
            if (i12 == 17) {
                this.f١٢٨٤٧c0 = ((i11 - (this.Q - i10)) / 2) + i10;
                return;
            } else if (i12 == 5) {
                this.f١٢٨٤٧c0 = (i11 - (this.Q - i10)) + i10;
                return;
            } else {
                this.f١٢٨٤٧c0 = i10;
                return;
            }
        }
        this.f١٢٨٤٧c0 = i10;
    }

    protected int d() {
        if (this.P) {
            Paint.FontMetricsInt fontMetricsInt = this.f١٢٨٥٠e.getFontMetricsInt();
            if (fontMetricsInt == null) {
                this.f١٢٨٥٩k = 0;
                this.f١٢٨٥٨j = 0;
            } else {
                this.P = false;
                int m10 = m(fontMetricsInt, this.F);
                int l10 = l(fontMetricsInt, this.F) - m10;
                this.f١٢٨٥٩k = this.f١٢٨٤١B + l10;
                int max = Math.max(this.f١٢٨٥٩k, this.f١٢٨٤٦c.g());
                if (l10 >= max) {
                    this.f١٢٨٥٨j = l10;
                    this.f١٢٨٦٠l = -m10;
                } else {
                    this.f١٢٨٥٨j = max;
                    this.f١٢٨٦٠l = (-m10) + ((max - l10) / 2);
                }
            }
        }
        return this.f١٢٨٥٨j;
    }

    protected int e(int i10) {
        if (i10 > getPaddingRight() + getPaddingLeft() && !r()) {
            if (!this.T && this.U == i10) {
                this.f١٢٨٦٣o = this.W;
                return this.V;
            }
            this.U = i10;
            List b10 = this.f١٢٨٤٤b.b();
            this.R = 1;
            this.Q = getPaddingLeft();
            f(b10, i10);
            int i11 = this.R;
            if (i11 != this.f١٢٨٦٣o) {
                this.f١٢٨٦٣o = i11;
            }
            if (this.f١٢٨٦٣o == 1) {
                this.V = this.Q + getPaddingRight();
            } else {
                this.V = i10;
            }
            this.W = this.f١٢٨٦٣o;
            return this.V;
        }
        this.f١٢٨٦٣o = 0;
        this.A = 0;
        this.W = 0;
        this.V = 0;
        return 0;
    }

    public int getFontHeight() {
        return this.f١٢٨٥٨j;
    }

    public int getGravity() {
        return this.J;
    }

    public int getLineCount() {
        return this.f١٢٨٦٣o;
    }

    public int getLineSpace() {
        return this.f١٢٨٥٧i;
    }

    public int getMaxLine() {
        return this.f١٢٨٦١m;
    }

    public int getMaxWidth() {
        return this.C;
    }

    public Rect getMoreHitRect() {
        return this.f١٢٨٦٦r;
    }

    public TextPaint getPaint() {
        return this.f١٢٨٥٠e;
    }

    public CharSequence getText() {
        return this.f١٢٨٤٢a;
    }

    public int getTextSize() {
        return this.f١٢٨٥٤g;
    }

    protected int l(Paint.FontMetricsInt fontMetricsInt, boolean z10) {
        if (z10) {
            return fontMetricsInt.bottom;
        }
        return fontMetricsInt.descent;
    }

    protected int m(Paint.FontMetricsInt fontMetricsInt, boolean z10) {
        if (z10) {
            return fontMetricsInt.top;
        }
        return fontMetricsInt.ascent;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.E && this.f١٢٨٤٢a != null && this.f١٢٨٦٣o != 0 && !r()) {
            y();
            List b10 = this.f١٢٨٤٤b.b();
            this.f١٢٨٤٣a0 = getPaddingTop() + this.f١٢٨٦٠l;
            this.f١٢٨٤٥b0 = 1;
            z(getPaddingLeft(), (getWidth() - getPaddingLeft()) - getPaddingRight());
            this.f١٢٨٥٣f0 = false;
            h(canvas, b10, (getWidth() - getPaddingLeft()) - getPaddingRight());
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int paddingTop;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        System.currentTimeMillis();
        int i18 = 0;
        this.E = false;
        d();
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        this.f١٢٨٦٣o = 0;
        this.A = 0;
        if (mode != 0 && mode != 1073741824) {
            CharSequence charSequence = this.f١٢٨٤٢a;
            if (charSequence != null && charSequence.length() != 0) {
                size = e(Math.min(size, this.C));
            } else {
                size = 0;
            }
        } else {
            e(size);
        }
        if (this.E) {
            if (mode2 != Integer.MIN_VALUE) {
                i18 = size2;
            }
            setMeasuredDimension(size, i18);
            return;
        }
        int i19 = this.f١٢٨٦١m;
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 != 1073741824) {
                g(i19);
                paddingTop = getPaddingTop() + getPaddingBottom();
                i12 = this.f١٢٨٧٤z;
                if (i12 < 2) {
                    i16 = this.f١٢٨٥٨j;
                    i17 = i12 * i16;
                } else {
                    int i20 = this.f١٢٨٥٨j;
                    i13 = ((i12 - 1) * (this.f١٢٨٥٧i + i20)) + i20;
                    i14 = this.A;
                    i15 = this.H;
                    i17 = i13 + (i14 * i15);
                }
            } else {
                int paddingTop2 = (size2 - getPaddingTop()) - getPaddingBottom();
                int i21 = this.f١٢٨٥٧i;
                g(Math.min((paddingTop2 + i21) / (this.f١٢٨٥٨j + i21), this.f١٢٨٦١m));
                setMeasuredDimension(size, size2);
            }
        } else {
            int paddingTop3 = (size2 - getPaddingTop()) - getPaddingBottom();
            int i22 = this.f١٢٨٥٧i;
            g(Math.min((paddingTop3 + i22) / (this.f١٢٨٥٨j + i22), this.f١٢٨٦١m));
            paddingTop = getPaddingTop() + getPaddingBottom();
            i12 = this.f١٢٨٧٤z;
            if (i12 < 2) {
                i16 = this.f١٢٨٥٨j;
                i17 = i12 * i16;
            } else {
                int i23 = this.f١٢٨٥٨j;
                i13 = ((i12 - 1) * (this.f١٢٨٥٧i + i23)) + i23;
                i14 = this.A;
                i15 = this.H;
                i17 = i13 + (i14 * i15);
            }
        }
        size2 = paddingTop + i17;
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        if (this.f١٢٨٦٤p.isEmpty() && this.f١٢٨٦٦r.isEmpty()) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0 && !this.f١٢٨٦٥q && this.O == null) {
            return super.onTouchEvent(motionEvent);
        }
        b bVar = this.D;
        if (bVar != null) {
            bVar.run();
            this.D = null;
        }
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        this.D = null;
                        d dVar = this.O;
                        if (dVar != null) {
                            dVar.d(false);
                            this.O.a();
                        } else if (this.f١٢٨٦٥q) {
                            this.f١٢٨٦٥q = false;
                            invalidate(this.f١٢٨٦٦r);
                        }
                    }
                } else {
                    d dVar2 = this.O;
                    if (dVar2 != null && !dVar2.c(x10, y10)) {
                        this.O.d(false);
                        this.O.a();
                        this.O = null;
                    } else if (this.f١٢٨٦٥q && !this.f١٢٨٦٦r.contains(x10, y10)) {
                        this.f١٢٨٦٥q = false;
                        invalidate(this.f١٢٨٦٦r);
                    }
                }
            } else {
                d dVar3 = this.O;
                if (dVar3 != null) {
                    dVar3.b();
                    this.D = new b(this.O);
                    postDelayed(new a(), 100L);
                } else if (this.f١٢٨٦٥q) {
                    if (isClickable()) {
                        performClick();
                    }
                    this.f١٢٨٦٥q = false;
                    invalidate(this.f١٢٨٦٦r);
                }
            }
        } else {
            this.O = null;
            this.f١٢٨٦٥q = false;
            if (this.f١٢٨٦٦r.contains(x10, y10)) {
                this.f١٢٨٦٥q = true;
                invalidate(this.f١٢٨٦٦r);
            } else {
                Iterator it = this.f١٢٨٦٤p.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d dVar4 = (d) it.next();
                    if (dVar4.c(x10, y10)) {
                        this.O = dVar4;
                        break;
                    }
                }
            }
            d dVar5 = this.O;
            if (dVar5 != null) {
                dVar5.d(true);
                this.O.a();
            } else if (!this.f١٢٨٦٥q) {
                return super.onTouchEvent(motionEvent);
            }
        }
        return true;
    }

    public void setCompiler(com.qmuiteam.qmui.qqface.a aVar) {
        if (this.f١٢٨٤٦c != aVar) {
            this.f١٢٨٤٦c = aVar;
            A(this.f١٢٨٤٢a, false);
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f١٢٨٧٢x != truncateAt) {
            this.f١٢٨٧٢x = truncateAt;
            requestLayout();
            invalidate();
        }
    }

    public void setGravity(int i10) {
        this.J = i10;
    }

    public void setIncludeFontPadding(boolean z10) {
        if (this.F != z10) {
            this.P = true;
            this.F = z10;
            requestLayout();
            invalidate();
        }
    }

    public void setLineSpace(int i10) {
        if (this.f١٢٨٥٧i != i10) {
            this.f١٢٨٥٧i = i10;
            requestLayout();
            invalidate();
        }
    }

    public void setLinkUnderLineColor(int i10) {
        setLinkUnderLineColor(ColorStateList.valueOf(i10));
    }

    public void setLinkUnderLineHeight(int i10) {
        if (this.N != i10) {
            this.N = i10;
            invalidate();
        }
    }

    public void setListener(c cVar) {
    }

    public void setMaxLine(int i10) {
        if (this.f١٢٨٦١m != i10) {
            this.f١٢٨٦١m = i10;
            requestLayout();
            invalidate();
        }
    }

    public void setMaxWidth(int i10) {
        if (this.C != i10) {
            this.C = i10;
            requestLayout();
        }
    }

    public void setMoreActionBgColor(int i10) {
        setMoreActionBgColor(ColorStateList.valueOf(i10));
    }

    public void setMoreActionColor(int i10) {
        setMoreActionColor(ColorStateList.valueOf(i10));
    }

    public void setMoreActionText(String str) {
        String str2 = this.f١٢٨٦٧s;
        if (str2 == null || !str2.equals(str)) {
            this.f١٢٨٦٧s = str;
            s();
            requestLayout();
            invalidate();
        }
    }

    public void setNeedUnderlineForMoreText(boolean z10) {
        if (this.L != z10) {
            this.L = z10;
            invalidate();
        }
    }

    public void setOpenQQFace(boolean z10) {
        this.f١٢٨٤٨d = z10;
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        if (getPaddingLeft() != i10 || getPaddingRight() != i12) {
            this.T = true;
        }
        super.setPadding(i10, i11, i12, i13);
    }

    public void setParagraphSpace(int i10) {
        if (this.H != i10) {
            this.H = i10;
            requestLayout();
            invalidate();
        }
    }

    public void setQQFaceSizeAddon(int i10) {
        if (this.f١٢٨٤١B != i10) {
            this.f١٢٨٤١B = i10;
            this.T = true;
            requestLayout();
            invalidate();
        }
    }

    public void setSingleLine(boolean z10) {
        if (this.f١٢٨٦٢n != z10) {
            this.f١٢٨٦٢n = z10;
            requestLayout();
            invalidate();
        }
    }

    public void setSpecialDrawablePadding(int i10) {
        if (this.I != i10) {
            this.I = i10;
            requestLayout();
            invalidate();
        }
    }

    public void setText(CharSequence charSequence) {
        A(charSequence, true);
    }

    public void setTextColor(int i10) {
        setTextColor(ColorStateList.valueOf(i10));
    }

    public void setTextSize(int i10) {
        if (this.f١٢٨٥٤g != i10) {
            this.f١٢٨٥٤g = i10;
            this.f١٢٨٥٠e.setTextSize(i10);
            this.P = true;
            this.T = true;
            this.f١٢٨٧١w = (int) Math.ceil(this.f١٢٨٥٠e.measureText("..."));
            s();
            requestLayout();
            invalidate();
        }
    }

    public void setTypeface(Typeface typeface) {
        if (this.G != typeface) {
            this.G = typeface;
            this.P = true;
            this.f١٢٨٥٠e.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public QMUIQQFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUIQQFaceStyle);
    }

    public void setLinkUnderLineColor(ColorStateList colorStateList) {
        if (this.M != colorStateList) {
            this.M = colorStateList;
            invalidate();
        }
    }

    public void setMoreActionBgColor(ColorStateList colorStateList) {
        if (this.f١٢٨٦٩u != colorStateList) {
            this.f١٢٨٦٩u = colorStateList;
            invalidate();
        }
    }

    public void setMoreActionColor(ColorStateList colorStateList) {
        if (this.f١٢٨٦٨t != colorStateList) {
            this.f١٢٨٦٨t = colorStateList;
            invalidate();
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (this.f١٢٨٥٦h != colorStateList) {
            this.f١٢٨٥٦h = colorStateList;
            invalidate();
        }
    }

    public QMUIQQFaceView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٢٨٤٨d = true;
        this.f١٢٨٥٧i = -1;
        this.f١٢٨٥٩k = 0;
        this.f١٢٨٦١m = Integer.MAX_VALUE;
        this.f١٢٨٦٢n = false;
        this.f١٢٨٦٣o = 0;
        this.f١٢٨٦٤p = new HashMap();
        this.f١٢٨٦٥q = false;
        this.f١٢٨٦٦r = new Rect();
        this.f١٢٨٧٠v = 0;
        this.f١٢٨٧١w = 0;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        this.f١٢٨٧٢x = truncateAt;
        this.f١٢٨٧٣y = false;
        this.f١٢٨٧٤z = 0;
        this.A = 0;
        this.f١٢٨٤١B = 0;
        this.C = Integer.MAX_VALUE;
        this.D = null;
        this.E = false;
        this.F = true;
        this.G = null;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled};
        this.L = false;
        this.N = 1;
        this.O = null;
        this.P = true;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = false;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.f١٢٨٤٩d0 = false;
        this.f١٢٨٥١e0 = -1;
        this.f١٢٨٥٣f0 = false;
        this.f١٢٨٥٥g0 = -1;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.QMUIQQFaceView, i10, 0);
        this.f١٢٨٤١B = -e.a(context, 2);
        this.f١٢٨٥٤g = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIQQFaceView_android_textSize, e.a(context, 14));
        this.f١٢٨٥٦h = obtainStyledAttributes.getColorStateList(R.styleable.QMUIQQFaceView_android_textColor);
        this.f١٢٨٦٢n = obtainStyledAttributes.getBoolean(R.styleable.QMUIQQFaceView_android_singleLine, false);
        this.f١٢٨٦١m = obtainStyledAttributes.getInt(R.styleable.QMUIQQFaceView_android_maxLines, this.f١٢٨٦١m);
        setLineSpace(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.QMUIQQFaceView_android_lineSpacingExtra, 0));
        int i11 = obtainStyledAttributes.getInt(R.styleable.QMUIQQFaceView_android_ellipsize, -1);
        if (i11 == 1) {
            this.f١٢٨٧٢x = TextUtils.TruncateAt.START;
        } else if (i11 == 2) {
            this.f١٢٨٧٢x = TextUtils.TruncateAt.MIDDLE;
        } else if (i11 != 3) {
            this.f١٢٨٧٢x = null;
        } else {
            this.f١٢٨٧٢x = truncateAt;
        }
        this.C = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIQQFaceView_android_maxWidth, this.C);
        this.I = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIQQFaceView_qmui_special_drawable_padding, 0);
        String string = obtainStyledAttributes.getString(R.styleable.QMUIQQFaceView_android_text);
        if (!g.f(string)) {
            this.f١٢٨٤٢a = string;
        }
        this.f١٢٨٦٧s = obtainStyledAttributes.getString(R.styleable.QMUIQQFaceView_qmui_more_action_text);
        this.f١٢٨٦٨t = obtainStyledAttributes.getColorStateList(R.styleable.QMUIQQFaceView_qmui_more_action_color);
        this.f١٢٨٦٩u = obtainStyledAttributes.getColorStateList(R.styleable.QMUIQQFaceView_qmui_more_action_bg_color);
        obtainStyledAttributes.recycle();
        TextPaint textPaint = new TextPaint();
        this.f١٢٨٥٠e = textPaint;
        textPaint.setAntiAlias(true);
        this.f١٢٨٥٠e.setTextSize(this.f١٢٨٥٤g);
        this.f١٢٨٧١w = (int) Math.ceil(this.f١٢٨٥٠e.measureText("..."));
        s();
        Paint paint = new Paint();
        this.f١٢٨٥٢f = paint;
        paint.setAntiAlias(true);
        this.f١٢٨٥٢f.setStyle(Paint.Style.FILL);
        setCompiler(com.qmuiteam.qmui.qqface.a.e());
    }
}
