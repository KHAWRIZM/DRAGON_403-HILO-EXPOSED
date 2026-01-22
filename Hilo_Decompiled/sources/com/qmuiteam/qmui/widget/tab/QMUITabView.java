package com.qmuiteam.qmui.widget.tab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.d1;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import ic.g;
import ic.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUITabView extends FrameLayout implements dc.c {

    /* renamed from: a, reason: collision with root package name */
    private com.qmuiteam.qmui.widget.tab.a f١٣٣٤٣a;

    /* renamed from: b, reason: collision with root package name */
    private ic.b f١٣٣٤٤b;

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f١٣٣٤٥c;

    /* renamed from: d, reason: collision with root package name */
    private GestureDetector f١٣٣٤٦d;

    /* renamed from: e, reason: collision with root package name */
    private b f١٣٣٤٧e;

    /* renamed from: f, reason: collision with root package name */
    private float f١٣٣٤٨f;

    /* renamed from: g, reason: collision with root package name */
    private float f١٣٣٤٩g;

    /* renamed from: h, reason: collision with root package name */
    private float f١٣٣٥٠h;

    /* renamed from: i, reason: collision with root package name */
    private float f١٣٣٥١i;

    /* renamed from: j, reason: collision with root package name */
    private float f١٣٣٥٢j;

    /* renamed from: k, reason: collision with root package name */
    private float f١٣٣٥٣k;

    /* renamed from: l, reason: collision with root package name */
    private float f١٣٣٥٤l;

    /* renamed from: m, reason: collision with root package name */
    private float f١٣٣٥٥m;

    /* renamed from: n, reason: collision with root package name */
    private float f١٣٣٥٦n;

    /* renamed from: o, reason: collision with root package name */
    private float f١٣٣٥٧o;

    /* renamed from: p, reason: collision with root package name */
    private float f١٣٣٥٨p;

    /* renamed from: q, reason: collision with root package name */
    private float f١٣٣٥٩q;

    /* renamed from: r, reason: collision with root package name */
    private float f١٣٣٦٠r;

    /* renamed from: s, reason: collision with root package name */
    private float f١٣٣٦١s;

    /* renamed from: t, reason: collision with root package name */
    private float f١٣٣٦٢t;

    /* renamed from: u, reason: collision with root package name */
    private float f١٣٣٦٣u;

    /* renamed from: v, reason: collision with root package name */
    private float f١٣٣٦٤v;

    /* renamed from: w, reason: collision with root package name */
    private QMUIRoundButton f١٣٣٦٥w;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (QMUITabView.this.f١٣٣٤٧e != null) {
                QMUITabView.this.f١٣٣٤٧e.c(QMUITabView.this);
                return true;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (QMUITabView.this.f١٣٣٤٧e != null) {
                return true;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (QMUITabView.this.f١٣٣٤٧e != null) {
                QMUITabView.this.f١٣٣٤٧e.b(QMUITabView.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (QMUITabView.this.f١٣٣٤٧e != null) {
                QMUITabView.this.f١٣٣٤٧e.a(QMUITabView.this);
            }
            return false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface b {
        void a(QMUITabView qMUITabView);

        void b(QMUITabView qMUITabView);

        void c(QMUITabView qMUITabView);
    }

    public QMUITabView(Context context) {
        super(context);
        this.f١٣٣٤٨f = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٣٣٤٩g = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٣٣٥٠h = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٣٣٥١i = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٣٣٥٢j = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٣٣٥٣k = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٣٣٥٤l = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٣٣٥٥m = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٣٣٥٦n = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٣٣٥٧o = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٣٣٥٨p = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٣٣٥٩q = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٣٣٦٠r = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٣٣٦١s = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٣٣٦٢t = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٣٣٦٣u = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٣٣٦٤v = DownloadProgress.UNKNOWN_PROGRESS;
        setFocusable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        this.f١٣٣٤٤b = new ic.b(this, 1.0f);
        this.f١٣٣٤٦d = new GestureDetector(getContext(), new a());
    }

    private Point d() {
        int i10;
        float f10;
        d h10 = this.f١٣٣٤٣a.h();
        int a10 = this.f١٣٣٤٣a.a();
        if (h10 != null && a10 != 3 && a10 != 0) {
            i10 = (int) (this.f١٣٣٤٨f + this.f١٣٣٥٢j);
            f10 = this.f١٣٣٤٩g;
        } else {
            i10 = (int) (this.f١٣٣٥٠h + this.f١٣٣٥٤l);
            f10 = this.f١٣٣٥١i;
        }
        Point point = new Point(i10, (int) f10);
        com.qmuiteam.qmui.widget.tab.a aVar = this.f١٣٣٤٣a;
        int i11 = aVar.C;
        int i12 = aVar.f١٣٣٦٧B;
        if (i11 == 1) {
            point.offset(aVar.A, i12 + this.f١٣٣٦٥w.getMeasuredHeight());
        } else if (i11 == 2) {
            point.y = getMeasuredHeight() - ((getMeasuredHeight() - this.f١٣٣٦٥w.getMeasuredHeight()) / 2);
            point.offset(this.f١٣٣٤٣a.A, i12);
        } else {
            point.offset(aVar.A, i12);
        }
        return point;
    }

    private QMUIRoundButton f(Context context) {
        FrameLayout.LayoutParams layoutParams;
        if (this.f١٣٣٦٥w == null) {
            QMUIRoundButton e10 = e(context);
            this.f١٣٣٦٥w = e10;
            if (e10.getLayoutParams() != null) {
                layoutParams = new FrameLayout.LayoutParams(this.f١٣٣٦٥w.getLayoutParams());
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            addView(this.f١٣٣٦٥w, layoutParams);
        }
        return this.f١٣٣٦٥w;
    }

    private void k(float f10) {
        this.f١٣٣٤٨f = ic.b.x(this.f١٣٣٥٦n, this.f١٣٣٦٠r, f10, this.f١٣٣٤٥c);
        this.f١٣٣٤٩g = ic.b.x(this.f١٣٣٥٧o, this.f١٣٣٦١s, f10, this.f١٣٣٤٥c);
        int e10 = this.f١٣٣٤٣a.e();
        int d10 = this.f١٣٣٤٣a.d();
        float g10 = this.f١٣٣٤٣a.g();
        float f11 = e10;
        this.f١٣٣٥٢j = ic.b.x(f11, f11 * g10, f10, this.f١٣٣٤٥c);
        float f12 = d10;
        this.f١٣٣٥٣k = ic.b.x(f12, g10 * f12, f10, this.f١٣٣٤٥c);
        this.f١٣٣٥٠h = ic.b.x(this.f١٣٣٥٨p, this.f١٣٣٦٢t, f10, this.f١٣٣٤٥c);
        this.f١٣٣٥١i = ic.b.x(this.f١٣٣٥٩q, this.f١٣٣٦٣u, f10, this.f١٣٣٤٥c);
        float k10 = this.f١٣٣٤٤b.k();
        float j10 = this.f١٣٣٤٤b.j();
        float q10 = this.f١٣٣٤٤b.q();
        float p10 = this.f١٣٣٤٤b.p();
        this.f١٣٣٥٤l = ic.b.x(k10, q10, f10, this.f١٣٣٤٥c);
        this.f١٣٣٥٥m = ic.b.x(j10, p10, f10, this.f١٣٣٤٥c);
    }

    private void l(com.qmuiteam.qmui.widget.tab.a aVar) {
        Drawable c10;
        Drawable c11;
        Drawable c12;
        int c13 = aVar.c(this);
        int f10 = aVar.f(this);
        this.f١٣٣٤٤b.S(ColorStateList.valueOf(c13), ColorStateList.valueOf(f10), true);
        d dVar = aVar.f١٣٣٨٢o;
        if (dVar != null) {
            if (!aVar.f١٣٣٨٣p && (!aVar.f١٣٣٨٤q || !aVar.f١٣٣٨٥r)) {
                if (dVar.a()) {
                    if (aVar.f١٣٣٨٤q) {
                        aVar.f١٣٣٨٢o.g(c13);
                    } else {
                        int i10 = aVar.f١٣٣٨٦s;
                        if (i10 != 0 && (c11 = dc.d.c(this, i10)) != null) {
                            aVar.f١٣٣٨٢o.d(c11);
                        }
                    }
                    if (aVar.f١٣٣٨٥r) {
                        aVar.f١٣٣٨٢o.h(c13);
                        return;
                    }
                    int i11 = aVar.f١٣٣٨٧t;
                    if (i11 != 0 && (c12 = dc.d.c(this, i11)) != null) {
                        aVar.f١٣٣٨٢o.e(c12);
                        return;
                    }
                    return;
                }
                if (aVar.f١٣٣٨٤q) {
                    aVar.f١٣٣٨٢o.f(c13, f10);
                    return;
                }
                int i12 = aVar.f١٣٣٨٦s;
                if (i12 != 0 && (c10 = dc.d.c(this, i12)) != null) {
                    aVar.f١٣٣٨٢o.c(c10, c13, f10);
                    return;
                }
                return;
            }
            dVar.f(c13, f10);
        }
    }

    @Override // dc.c
    public void a(dc.e eVar, int i10, Resources.Theme theme, SimpleArrayMap simpleArrayMap) {
        com.qmuiteam.qmui.widget.tab.a aVar = this.f١٣٣٤٣a;
        if (aVar != null) {
            l(aVar);
            invalidate();
        }
    }

    public void c(com.qmuiteam.qmui.widget.tab.a aVar) {
        boolean z10;
        this.f١٣٣٤٤b.T(aVar.f١٣٣٧٠c, aVar.f١٣٣٧١d, false);
        this.f١٣٣٤٤b.V(aVar.f١٣٣٧٢e, aVar.f١٣٣٧٣f, false);
        this.f١٣٣٤٤b.W(aVar.f١٣٣٧٤g);
        this.f١٣٣٤٤b.N(51, 51, false);
        this.f١٣٣٤٤b.R(aVar.i());
        this.f١٣٣٤٣a = aVar;
        d dVar = aVar.f١٣٣٨٢o;
        if (dVar != null) {
            dVar.setCallback(this);
        }
        int i10 = this.f١٣٣٤٣a.D;
        boolean z11 = true;
        if (i10 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (i10 <= 0) {
            z11 = false;
        }
        if (!z10 && !z11) {
            QMUIRoundButton qMUIRoundButton = this.f١٣٣٦٥w;
            if (qMUIRoundButton != null) {
                qMUIRoundButton.setVisibility(8);
            }
        } else {
            f(getContext());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f١٣٣٦٥w.getLayoutParams();
            if (z11) {
                QMUIRoundButton qMUIRoundButton2 = this.f١٣٣٦٥w;
                com.qmuiteam.qmui.widget.tab.a aVar2 = this.f١٣٣٤٣a;
                qMUIRoundButton2.setText(g.d(aVar2.D, aVar2.f١٣٣٩٣z));
                QMUIRoundButton qMUIRoundButton3 = this.f١٣٣٦٥w;
                Context context = getContext();
                int i11 = R.attr.qmui_tab_sign_count_view_min_size_with_text;
                qMUIRoundButton3.setMinWidth(i.e(context, i11));
                layoutParams.width = -2;
                layoutParams.height = i.e(getContext(), i11);
            } else {
                this.f١٣٣٦٥w.setText((CharSequence) null);
                int e10 = i.e(getContext(), R.attr.qmui_tab_sign_count_view_min_size);
                layoutParams.width = e10;
                layoutParams.height = e10;
            }
            this.f١٣٣٦٥w.setLayoutParams(layoutParams);
            this.f١٣٣٦٥w.setVisibility(0);
        }
        l(aVar);
        requestLayout();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        g(canvas);
        super.draw(canvas);
    }

    protected QMUIRoundButton e(Context context) {
        QMUIRoundButton qMUIRoundButton = new QMUIRoundButton(context, null, R.attr.qmui_tab_sign_count_view);
        fc.b bVar = new fc.b();
        bVar.a("background", R.attr.qmui_skin_support_tab_sign_count_view_bg_color);
        bVar.a("textColor", R.attr.qmui_skin_support_tab_sign_count_view_text_color);
        qMUIRoundButton.setTag(R.id.qmui_skin_default_attr_provider, bVar);
        return qMUIRoundButton;
    }

    protected void g(Canvas canvas) {
        com.qmuiteam.qmui.widget.tab.a aVar = this.f١٣٣٤٣a;
        if (aVar == null) {
            return;
        }
        d h10 = aVar.h();
        if (h10 != null) {
            canvas.save();
            canvas.translate(this.f١٣٣٤٨f, this.f١٣٣٤٩g);
            h10.setBounds(0, 0, (int) this.f١٣٣٥٢j, (int) this.f١٣٣٥٣k);
            h10.draw(canvas);
            canvas.restore();
        }
        canvas.save();
        canvas.translate(this.f١٣٣٥٠h, this.f١٣٣٥١i);
        this.f١٣٣٤٤b.g(canvas);
        canvas.restore();
    }

    public int getContentViewLeft() {
        com.qmuiteam.qmui.widget.tab.a aVar = this.f١٣٣٤٣a;
        if (aVar == null) {
            return 0;
        }
        if (aVar.h() == null) {
            return (int) (this.f١٣٣٦٢t + 0.5d);
        }
        int a10 = this.f١٣٣٤٣a.a();
        if (a10 != 3 && a10 != 1) {
            if (a10 == 0) {
                return (int) (this.f١٣٣٦٠r + 0.5d);
            }
            return (int) (this.f١٣٣٦٢t + 0.5d);
        }
        return (int) Math.min(this.f١٣٣٦٢t, this.f١٣٣٦٠r + 0.5d);
    }

    public int getContentViewWidth() {
        double b10;
        if (this.f١٣٣٤٣a == null) {
            return 0;
        }
        float q10 = this.f١٣٣٤٤b.q();
        if (this.f١٣٣٤٣a.h() != null) {
            int a10 = this.f١٣٣٤٣a.a();
            float e10 = this.f١٣٣٤٣a.e() * this.f١٣٣٤٣a.g();
            if (a10 != 3 && a10 != 1) {
                b10 = e10 + q10 + this.f١٣٣٤٣a.b();
                return (int) (b10 + 0.5d);
            }
            q10 = Math.max(e10, q10);
        }
        b10 = q10;
        return (int) (b10 + 0.5d);
    }

    public float getSelectFraction() {
        return this.f١٣٣٦٤v;
    }

    protected void h(int i10, int i11) {
        if (this.f١٣٣٦٥w != null && this.f١٣٣٤٣a != null) {
            Point d10 = d();
            int i12 = d10.x;
            int i13 = d10.y;
            if (this.f١٣٣٦٥w.getMeasuredWidth() + i12 > i10) {
                i12 = i10 - this.f١٣٣٦٥w.getMeasuredWidth();
            }
            if (d10.y - this.f١٣٣٦٥w.getMeasuredHeight() < 0) {
                i13 = this.f١٣٣٦٥w.getMeasuredHeight();
            }
            QMUIRoundButton qMUIRoundButton = this.f١٣٣٦٥w;
            qMUIRoundButton.layout(i12, i13 - qMUIRoundButton.getMeasuredHeight(), this.f١٣٣٦٥w.getMeasuredWidth() + i12, i13);
        }
    }

    protected void i(int i10, int i11) {
        if (this.f١٣٣٤٣a == null) {
            return;
        }
        this.f١٣٣٤٤b.b();
        d h10 = this.f١٣٣٤٣a.h();
        float k10 = this.f١٣٣٤٤b.k();
        float j10 = this.f١٣٣٤٤b.j();
        float q10 = this.f١٣٣٤٤b.q();
        float p10 = this.f١٣٣٤٤b.p();
        if (h10 == null) {
            this.f١٣٣٦١s = DownloadProgress.UNKNOWN_PROGRESS;
            this.f١٣٣٦٠r = DownloadProgress.UNKNOWN_PROGRESS;
            this.f١٣٣٥٧o = DownloadProgress.UNKNOWN_PROGRESS;
            this.f١٣٣٥٦n = DownloadProgress.UNKNOWN_PROGRESS;
            int i12 = this.f١٣٣٤٣a.f١٣٣٩١x;
            int i13 = i12 & 112;
            if (i13 != 48) {
                if (i13 != 80) {
                    float f10 = i11;
                    this.f١٣٣٥٩q = (f10 - j10) / 2.0f;
                    this.f١٣٣٦٣u = (f10 - p10) / 2.0f;
                } else {
                    float f11 = i11;
                    this.f١٣٣٥٩q = f11 - j10;
                    this.f١٣٣٦٣u = f11 - p10;
                }
            } else {
                this.f١٣٣٥٩q = DownloadProgress.UNKNOWN_PROGRESS;
                this.f١٣٣٦٣u = DownloadProgress.UNKNOWN_PROGRESS;
            }
            int i14 = i12 & 8388615;
            if (i14 != 3) {
                if (i14 != 5) {
                    float f12 = i10;
                    this.f١٣٣٥٨p = (f12 - k10) / 2.0f;
                    this.f١٣٣٦٢t = (f12 - q10) / 2.0f;
                } else {
                    float f13 = i10;
                    this.f١٣٣٥٨p = f13 - k10;
                    this.f١٣٣٦٢t = f13 - q10;
                }
            } else {
                this.f١٣٣٥٨p = DownloadProgress.UNKNOWN_PROGRESS;
                this.f١٣٣٦٢t = DownloadProgress.UNKNOWN_PROGRESS;
            }
        } else {
            int b10 = this.f١٣٣٤٣a.b();
            com.qmuiteam.qmui.widget.tab.a aVar = this.f١٣٣٤٣a;
            int i15 = aVar.f١٣٣٩٠w;
            float e10 = aVar.e();
            float d10 = this.f١٣٣٤٣a.d();
            float g10 = this.f١٣٣٤٣a.g() * e10;
            float g11 = this.f١٣٣٤٣a.g() * d10;
            float f14 = b10;
            float f15 = k10 + f14;
            float f16 = f15 + e10;
            float f17 = j10 + f14;
            float f18 = f17 + d10;
            float f19 = q10 + f14;
            float f20 = f19 + g10;
            float f21 = p10 + f14;
            float f22 = f21 + g11;
            if (i15 != 1 && i15 != 3) {
                int i16 = this.f١٣٣٤٣a.f١٣٣٩١x;
                int i17 = i16 & 112;
                if (i17 != 48) {
                    if (i17 != 80) {
                        float f23 = i11;
                        this.f١٣٣٥٧o = (f23 - d10) / 2.0f;
                        this.f١٣٣٥٩q = (f23 - j10) / 2.0f;
                        this.f١٣٣٦١s = (f23 - g11) / 2.0f;
                        this.f١٣٣٦٣u = (f23 - p10) / 2.0f;
                    } else {
                        float f24 = i11;
                        this.f١٣٣٥٧o = f24 - d10;
                        this.f١٣٣٥٩q = f24 - j10;
                        this.f١٣٣٦١s = f24 - g11;
                        this.f١٣٣٦٣u = f24 - p10;
                    }
                } else {
                    this.f١٣٣٥٧o = DownloadProgress.UNKNOWN_PROGRESS;
                    this.f١٣٣٥٩q = DownloadProgress.UNKNOWN_PROGRESS;
                    this.f١٣٣٦١s = DownloadProgress.UNKNOWN_PROGRESS;
                    this.f١٣٣٦٣u = DownloadProgress.UNKNOWN_PROGRESS;
                }
                int i18 = 8388615 & i16;
                if (i18 != 3) {
                    if (i18 != 5) {
                        if (i15 == 2) {
                            float f25 = i10;
                            float f26 = (f25 - f16) / 2.0f;
                            this.f١٣٣٥٨p = f26;
                            float f27 = (f25 - f20) / 2.0f;
                            this.f١٣٣٦٢t = f27;
                            this.f١٣٣٥٦n = f26 + k10 + f14;
                            this.f١٣٣٦٠r = f27 + q10 + f14;
                        } else {
                            float f28 = i10;
                            float f29 = (f28 - f16) / 2.0f;
                            this.f١٣٣٥٦n = f29;
                            float f30 = (f28 - f20) / 2.0f;
                            this.f١٣٣٦٠r = f30;
                            this.f١٣٣٥٨p = f29 + e10 + f14;
                            this.f١٣٣٦٢t = f30 + g10 + f14;
                        }
                    } else if (i15 == 2) {
                        float f31 = i10;
                        this.f١٣٣٥٨p = f31 - f16;
                        this.f١٣٣٦٢t = f31 - f20;
                        this.f١٣٣٥٦n = f31 - e10;
                        this.f١٣٣٦٠r = f31 - g10;
                    } else {
                        float f32 = i10;
                        this.f١٣٣٥٦n = f32 - f16;
                        this.f١٣٣٦٠r = f32 - f20;
                        this.f١٣٣٥٨p = f32 - k10;
                        this.f١٣٣٦٢t = f32 - q10;
                    }
                } else if (i15 == 2) {
                    this.f١٣٣٥٨p = DownloadProgress.UNKNOWN_PROGRESS;
                    this.f١٣٣٦٢t = DownloadProgress.UNKNOWN_PROGRESS;
                    this.f١٣٣٥٦n = f15;
                    this.f١٣٣٦٠r = f19;
                } else {
                    this.f١٣٣٥٦n = DownloadProgress.UNKNOWN_PROGRESS;
                    this.f١٣٣٦٠r = DownloadProgress.UNKNOWN_PROGRESS;
                    this.f١٣٣٥٨p = e10 + f14;
                    this.f١٣٣٦٢t = g10 + f14;
                }
                if (i15 == 0) {
                    float f33 = i10;
                    if (f16 >= f33) {
                        this.f١٣٣٥٦n = f33 - f16;
                    } else {
                        this.f١٣٣٥٦n = (f33 - f16) / 2.0f;
                    }
                    this.f١٣٣٥٨p = this.f١٣٣٥٦n + e10 + f14;
                    if (f20 >= f33) {
                        this.f١٣٣٦٠r = f33 - f20;
                    } else {
                        this.f١٣٣٦٠r = (f33 - f20) / 2.0f;
                    }
                    this.f١٣٣٦٢t = this.f١٣٣٦٠r + g10 + f14;
                } else {
                    float f34 = i10;
                    if (f16 >= f34) {
                        this.f١٣٣٥٨p = DownloadProgress.UNKNOWN_PROGRESS;
                    } else {
                        this.f١٣٣٥٨p = (f34 - f16) / 2.0f;
                    }
                    this.f١٣٣٥٦n = this.f١٣٣٥٨p + k10 + f14;
                    if (f20 >= f34) {
                        this.f١٣٣٦٢t = DownloadProgress.UNKNOWN_PROGRESS;
                    } else {
                        this.f١٣٣٦٢t = (f34 - f20) / 2.0f;
                    }
                    this.f١٣٣٦٠r = this.f١٣٣٦٢t + q10 + f14;
                }
            } else {
                int i19 = this.f١٣٣٤٣a.f١٣٣٩١x;
                int i20 = 8388615 & i19;
                if (i20 != 3) {
                    if (i20 != 5) {
                        float f35 = i10;
                        this.f١٣٣٥٦n = (f35 - e10) / 2.0f;
                        this.f١٣٣٥٨p = (f35 - k10) / 2.0f;
                        this.f١٣٣٦٠r = (f35 - g10) / 2.0f;
                        this.f١٣٣٦٢t = (f35 - q10) / 2.0f;
                    } else {
                        float f36 = i10;
                        this.f١٣٣٥٦n = f36 - e10;
                        this.f١٣٣٥٨p = f36 - k10;
                        this.f١٣٣٦٠r = f36 - g10;
                        this.f١٣٣٦٢t = f36 - q10;
                    }
                } else {
                    this.f١٣٣٥٦n = DownloadProgress.UNKNOWN_PROGRESS;
                    this.f١٣٣٥٨p = DownloadProgress.UNKNOWN_PROGRESS;
                    this.f١٣٣٦٠r = DownloadProgress.UNKNOWN_PROGRESS;
                    this.f١٣٣٦٢t = DownloadProgress.UNKNOWN_PROGRESS;
                }
                int i21 = i19 & 112;
                if (i21 != 48) {
                    if (i21 != 80) {
                        if (i15 == 1) {
                            float f37 = i11;
                            if (f18 >= f37) {
                                this.f١٣٣٥٧o = f37 - f18;
                            } else {
                                this.f١٣٣٥٧o = (f37 - f18) / 2.0f;
                            }
                            this.f١٣٣٥٩q = this.f١٣٣٥٧o + f14 + d10;
                            if (f22 >= f37) {
                                this.f١٣٣٦١s = f37 - f22;
                            } else {
                                this.f١٣٣٦١s = (f37 - f22) / 2.0f;
                            }
                            this.f١٣٣٦٣u = this.f١٣٣٦١s + f14 + g11;
                        } else {
                            float f38 = i11;
                            if (f18 >= f38) {
                                this.f١٣٣٥٩q = DownloadProgress.UNKNOWN_PROGRESS;
                            } else {
                                this.f١٣٣٥٩q = (f38 - f18) / 2.0f;
                            }
                            this.f١٣٣٥٧o = this.f١٣٣٥٩q + f14 + j10;
                            if (f22 >= f38) {
                                this.f١٣٣٥٩q = DownloadProgress.UNKNOWN_PROGRESS;
                            } else {
                                this.f١٣٣٥٩q = (f38 - f22) / 2.0f;
                            }
                            this.f١٣٣٥٧o = this.f١٣٣٥٩q + f14 + p10;
                        }
                    } else if (i15 == 1) {
                        float f39 = i11;
                        float f40 = f39 - j10;
                        this.f١٣٣٥٩q = f40;
                        float f41 = f39 - p10;
                        this.f١٣٣٦٣u = f41;
                        this.f١٣٣٥٧o = (f40 - f14) - d10;
                        this.f١٣٣٦١s = (f41 - f14) - g11;
                    } else {
                        float f42 = i11;
                        float f43 = f42 - d10;
                        this.f١٣٣٥٧o = f43;
                        float f44 = f42 - g11;
                        this.f١٣٣٦١s = f44;
                        this.f١٣٣٥٩q = (f43 - f14) - j10;
                        this.f١٣٣٦٣u = (f44 - f14) - p10;
                    }
                } else if (i15 == 1) {
                    this.f١٣٣٥٧o = DownloadProgress.UNKNOWN_PROGRESS;
                    this.f١٣٣٦١s = DownloadProgress.UNKNOWN_PROGRESS;
                    this.f١٣٣٥٩q = d10 + f14;
                    this.f١٣٣٦٣u = g11 + f14;
                } else {
                    this.f١٣٣٥٩q = DownloadProgress.UNKNOWN_PROGRESS;
                    this.f١٣٣٦٣u = DownloadProgress.UNKNOWN_PROGRESS;
                    this.f١٣٣٥٧o = f17;
                    this.f١٣٣٦١s = f21;
                }
            }
        }
        k(1.0f - this.f١٣٣٤٤b.s());
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidate();
    }

    protected void j(int i10, int i11) {
        if (this.f١٣٣٤٣a.h() != null && !this.f١٣٣٤٣a.j()) {
            float e10 = this.f١٣٣٤٣a.e();
            com.qmuiteam.qmui.widget.tab.a aVar = this.f١٣٣٤٣a;
            float f10 = e10 * aVar.f١٣٣٨١n;
            float d10 = aVar.d();
            com.qmuiteam.qmui.widget.tab.a aVar2 = this.f١٣٣٤٣a;
            float f11 = d10 * aVar2.f١٣٣٨١n;
            int i12 = aVar2.f١٣٣٩٠w;
            if (i12 != 1 && i12 != 3) {
                i10 = (int) (i10 - (f10 - aVar2.b()));
            } else {
                i11 = (int) (i11 - (f11 - aVar2.b()));
            }
        }
        this.f١٣٣٤٤b.C(0, 0, i10, i11);
        this.f١٣٣٤٤b.H(0, 0, i10, i11);
        this.f١٣٣٤٤b.a();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setContentDescription(this.f١٣٣٤٣a.i());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        i(i14, i15);
        h(i14, i15);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        float max;
        float max2;
        if (this.f١٣٣٤٣a == null) {
            super.onMeasure(i10, i11);
            return;
        }
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        j(size, size2);
        d h10 = this.f١٣٣٤٣a.h();
        int a10 = this.f١٣٣٤٣a.a();
        if (mode == Integer.MIN_VALUE) {
            if (h10 == null) {
                max2 = this.f١٣٣٤٤b.q();
            } else if (a10 != 3 && a10 != 1) {
                max2 = this.f١٣٣٤٤b.q() + this.f١٣٣٤٣a.b() + (this.f١٣٣٤٣a.e() * this.f١٣٣٤٣a.g());
            } else {
                max2 = Math.max(this.f١٣٣٤٣a.e() * this.f١٣٣٤٣a.g(), this.f١٣٣٤٤b.q());
            }
            int i12 = (int) max2;
            QMUIRoundButton qMUIRoundButton = this.f١٣٣٦٥w;
            if (qMUIRoundButton != null && qMUIRoundButton.getVisibility() != 8) {
                this.f١٣٣٦٥w.measure(0, 0);
                i12 = Math.max(i12, this.f١٣٣٦٥w.getMeasuredWidth() + i12 + this.f١٣٣٤٣a.A);
            }
            i10 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (h10 == null) {
                max = this.f١٣٣٤٤b.p();
            } else if (a10 != 0 && a10 != 2) {
                max = this.f١٣٣٤٤b.p() + this.f١٣٣٤٣a.b() + (this.f١٣٣٤٣a.d() * this.f١٣٣٤٣a.g());
            } else {
                max = Math.max(this.f١٣٣٤٣a.d() * this.f١٣٣٤٣a.g(), this.f١٣٣٤٤b.q());
            }
            i11 = View.MeasureSpec.makeMeasureSpec((int) max, 1073741824);
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f١٣٣٤٦d.onTouchEvent(motionEvent) && !super.onTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    public void setCallback(b bVar) {
        this.f١٣٣٤٧e = bVar;
    }

    public void setPositionInterpolator(Interpolator interpolator) {
        this.f١٣٣٤٥c = interpolator;
        this.f١٣٣٤٤b.P(interpolator);
    }

    public void setSelectFraction(float f10) {
        float b10 = g.b(f10, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        this.f١٣٣٦٤v = b10;
        d h10 = this.f١٣٣٤٣a.h();
        if (h10 != null) {
            h10.b(b10, ic.c.a(this.f١٣٣٤٣a.c(this), this.f١٣٣٤٣a.f(this), b10));
        }
        k(b10);
        this.f١٣٣٤٤b.M(1.0f - b10);
        if (this.f١٣٣٦٥w != null) {
            Point d10 = d();
            int i10 = d10.x;
            int i11 = d10.y;
            if (this.f١٣٣٦٥w.getMeasuredWidth() + i10 > getMeasuredWidth()) {
                i10 = getMeasuredWidth() - this.f١٣٣٦٥w.getMeasuredWidth();
            }
            if (d10.y - this.f١٣٣٦٥w.getMeasuredHeight() < 0) {
                i11 = this.f١٣٣٦٥w.getMeasuredHeight();
            }
            QMUIRoundButton qMUIRoundButton = this.f١٣٣٦٥w;
            d1.a0(qMUIRoundButton, i10 - qMUIRoundButton.getLeft());
            QMUIRoundButton qMUIRoundButton2 = this.f١٣٣٦٥w;
            d1.b0(qMUIRoundButton2, i11 - qMUIRoundButton2.getBottom());
        }
    }
}
