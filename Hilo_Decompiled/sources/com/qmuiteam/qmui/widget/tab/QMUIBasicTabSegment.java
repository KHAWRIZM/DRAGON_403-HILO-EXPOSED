package com.qmuiteam.qmui.widget.tab;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.collection.SimpleArrayMap;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qmuiteam.qmui.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIBasicTabSegment extends HorizontalScrollView implements bc.a, dc.c, fc.a {

    /* renamed from: o, reason: collision with root package name */
    private static SimpleArrayMap f١٣٢٩٦o;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f١٣٢٩٧a;

    /* renamed from: b, reason: collision with root package name */
    private Container f١٣٢٩٨b;

    /* renamed from: c, reason: collision with root package name */
    protected int f١٣٢٩٩c;

    /* renamed from: d, reason: collision with root package name */
    protected int f١٣٣٠٠d;

    /* renamed from: e, reason: collision with root package name */
    private e f١٣٣٠١e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f١٣٣٠٢f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٣٣٠٣g;

    /* renamed from: h, reason: collision with root package name */
    private int f١٣٣٠٤h;

    /* renamed from: i, reason: collision with root package name */
    private com.qmuiteam.qmui.widget.tab.b f١٣٣٠٥i;

    /* renamed from: j, reason: collision with root package name */
    protected com.qmuiteam.qmui.widget.tab.c f١٣٣٠٦j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f١٣٣٠٧k;

    /* renamed from: l, reason: collision with root package name */
    protected Animator f١٣٣٠٨l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f١٣٣٠٩m;

    /* renamed from: n, reason: collision with root package name */
    private bc.d f١٣٣١٠n;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public final class Container extends ViewGroup {
        public Container(Context context) {
            super(context);
            setClipChildren(false);
            setWillNotDraw(false);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (QMUIBasicTabSegment.this.f١٣٣٠١e != null) {
                if (!QMUIBasicTabSegment.this.f١٣٣٠٢f || QMUIBasicTabSegment.this.f١٣٣٠٥i.j() > 1) {
                    QMUIBasicTabSegment.this.f١٣٣٠١e.a(this, canvas, getPaddingTop(), getHeight() - getPaddingBottom());
                }
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            int i14;
            List l10 = QMUIBasicTabSegment.this.f١٣٣٠٥i.l();
            int size = l10.size();
            int i15 = 0;
            for (int i16 = 0; i16 < size; i16++) {
                if (((View) l10.get(i16)).getVisibility() == 0) {
                    i15++;
                }
            }
            if (size != 0 && i15 != 0) {
                int paddingLeft = getPaddingLeft();
                for (int i17 = 0; i17 < size; i17++) {
                    QMUITabView qMUITabView = (QMUITabView) l10.get(i17);
                    if (qMUITabView.getVisibility() == 0) {
                        int measuredWidth = qMUITabView.getMeasuredWidth();
                        com.qmuiteam.qmui.widget.tab.a aVar = (com.qmuiteam.qmui.widget.tab.a) QMUIBasicTabSegment.this.f١٣٣٠٥i.i(i17);
                        int i18 = paddingLeft + aVar.G;
                        int i19 = i18 + measuredWidth;
                        qMUITabView.layout(i18, getPaddingTop(), i19, (i13 - i11) - getPaddingBottom());
                        int i20 = aVar.f١٣٣٨٩v;
                        int i21 = aVar.f١٣٣٨٨u;
                        if (QMUIBasicTabSegment.this.f١٣٣٠٣g == 1 && QMUIBasicTabSegment.this.f١٣٣٠١e != null && QMUIBasicTabSegment.this.f١٣٣٠١e.c()) {
                            i18 += qMUITabView.getContentViewLeft();
                            measuredWidth = qMUITabView.getContentViewWidth();
                        }
                        if (i20 != i18 || i21 != measuredWidth) {
                            aVar.f١٣٣٨٩v = i18;
                            aVar.f١٣٣٨٨u = measuredWidth;
                        }
                        int i22 = i19 + aVar.H;
                        if (QMUIBasicTabSegment.this.f١٣٣٠٣g == 0) {
                            i14 = QMUIBasicTabSegment.this.f١٣٣٠٤h;
                        } else {
                            i14 = 0;
                        }
                        paddingLeft = i22 + i14;
                    }
                }
                QMUIBasicTabSegment qMUIBasicTabSegment = QMUIBasicTabSegment.this;
                if (qMUIBasicTabSegment.f١٣٢٩٩c != -1 && qMUIBasicTabSegment.f١٣٣٠٨l == null && !qMUIBasicTabSegment.y()) {
                    QMUIBasicTabSegment qMUIBasicTabSegment2 = QMUIBasicTabSegment.this;
                    qMUIBasicTabSegment2.w((com.qmuiteam.qmui.widget.tab.a) qMUIBasicTabSegment2.f١٣٣٠٥i.i(QMUIBasicTabSegment.this.f١٣٢٩٩c), false);
                }
            }
        }

        @Override // android.view.View
        protected void onMeasure(int i10, int i11) {
            int size = View.MeasureSpec.getSize(i10);
            int size2 = View.MeasureSpec.getSize(i11);
            List l10 = QMUIBasicTabSegment.this.f١٣٣٠٥i.l();
            int size3 = l10.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size3; i13++) {
                if (((View) l10.get(i13)).getVisibility() == 0) {
                    i12++;
                }
            }
            if (size3 != 0 && i12 != 0) {
                int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
                if (QMUIBasicTabSegment.this.f١٣٣٠٣g == 1) {
                    int i14 = size / i12;
                    for (int i15 = 0; i15 < size3; i15++) {
                        View view = (View) l10.get(i15);
                        if (view.getVisibility() == 0) {
                            view.measure(View.MeasureSpec.makeMeasureSpec(i14, 1073741824), View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824));
                            com.qmuiteam.qmui.widget.tab.a aVar = (com.qmuiteam.qmui.widget.tab.a) QMUIBasicTabSegment.this.f١٣٣٠٥i.i(i15);
                            aVar.G = 0;
                            aVar.H = 0;
                        }
                    }
                } else {
                    int i16 = 0;
                    float f10 = DownloadProgress.UNKNOWN_PROGRESS;
                    for (int i17 = 0; i17 < size3; i17++) {
                        View view2 = (View) l10.get(i17);
                        if (view2.getVisibility() == 0) {
                            view2.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824));
                            i16 += view2.getMeasuredWidth() + QMUIBasicTabSegment.this.f١٣٣٠٤h;
                            com.qmuiteam.qmui.widget.tab.a aVar2 = (com.qmuiteam.qmui.widget.tab.a) QMUIBasicTabSegment.this.f١٣٣٠٥i.i(i17);
                            f10 += aVar2.F + aVar2.E;
                            aVar2.G = 0;
                            aVar2.H = 0;
                        }
                    }
                    int i18 = i16 - QMUIBasicTabSegment.this.f١٣٣٠٤h;
                    if (f10 > DownloadProgress.UNKNOWN_PROGRESS && i18 < size) {
                        int i19 = size - i18;
                        for (int i20 = 0; i20 < size3; i20++) {
                            if (((View) l10.get(i20)).getVisibility() == 0) {
                                com.qmuiteam.qmui.widget.tab.a aVar3 = (com.qmuiteam.qmui.widget.tab.a) QMUIBasicTabSegment.this.f١٣٣٠٥i.i(i20);
                                float f11 = i19;
                                aVar3.G = (int) ((aVar3.F * f11) / f10);
                                aVar3.H = (int) ((f11 * aVar3.E) / f10);
                            }
                        }
                    } else {
                        size = i18;
                    }
                }
                setMeasuredDimension(size, size2);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QMUITabView f١٣٣١٢a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QMUITabView f١٣٣١٣b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.qmuiteam.qmui.widget.tab.a f١٣٣١٤c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.qmuiteam.qmui.widget.tab.a f١٣٣١٥d;

        a(QMUITabView qMUITabView, QMUITabView qMUITabView2, com.qmuiteam.qmui.widget.tab.a aVar, com.qmuiteam.qmui.widget.tab.a aVar2) {
            this.f١٣٣١٢a = qMUITabView;
            this.f١٣٣١٣b = qMUITabView2;
            this.f١٣٣١٤c = aVar;
            this.f١٣٣١٥d = aVar2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f١٣٣١٢a.setSelectFraction(1.0f - floatValue);
            this.f١٣٣١٣b.setSelectFraction(floatValue);
            QMUIBasicTabSegment.this.x(this.f١٣٣١٤c, this.f١٣٣١٥d, floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QMUITabView f١٣٣١٧a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QMUITabView f١٣٣١٨b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f١٣٣١٩c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f١٣٣٢٠d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.qmuiteam.qmui.widget.tab.a f١٣٣٢١e;

        b(QMUITabView qMUITabView, QMUITabView qMUITabView2, int i10, int i11, com.qmuiteam.qmui.widget.tab.a aVar) {
            this.f١٣٣١٧a = qMUITabView;
            this.f١٣٣١٨b = qMUITabView2;
            this.f١٣٣١٩c = i10;
            this.f١٣٣٢٠d = i11;
            this.f١٣٣٢١e = aVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            QMUIBasicTabSegment.this.f١٣٣٠٨l = null;
            this.f١٣٣١٧a.setSelectFraction(1.0f);
            this.f١٣٣١٧a.setSelected(true);
            this.f١٣٣١٨b.setSelectFraction(DownloadProgress.UNKNOWN_PROGRESS);
            this.f١٣٣١٨b.setSelected(false);
            QMUIBasicTabSegment.this.w(this.f١٣٣٢١e, true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f١٣٣١٧a.setSelectFraction(DownloadProgress.UNKNOWN_PROGRESS);
            this.f١٣٣١٧a.setSelected(false);
            this.f١٣٣١٨b.setSelectFraction(1.0f);
            this.f١٣٣١٨b.setSelected(true);
            QMUIBasicTabSegment qMUIBasicTabSegment = QMUIBasicTabSegment.this;
            qMUIBasicTabSegment.f١٣٣٠٨l = null;
            int i10 = this.f١٣٣١٩c;
            qMUIBasicTabSegment.f١٣٢٩٩c = i10;
            qMUIBasicTabSegment.t(i10);
            QMUIBasicTabSegment.this.u(this.f١٣٣٢٠d);
            QMUIBasicTabSegment qMUIBasicTabSegment2 = QMUIBasicTabSegment.this;
            if (qMUIBasicTabSegment2.f١٣٣٠٠d != -1 && !qMUIBasicTabSegment2.y()) {
                QMUIBasicTabSegment qMUIBasicTabSegment3 = QMUIBasicTabSegment.this;
                qMUIBasicTabSegment3.F(qMUIBasicTabSegment3.f١٣٣٠٠d, true, false);
                QMUIBasicTabSegment.this.f١٣٣٠٠d = -1;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QMUIBasicTabSegment.this.f١٣٣٠٨l = animator;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface c {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface d {
        void a(int i10);

        void b(int i10);

        void c(int i10);

        void d(int i10);
    }

    static {
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap(3);
        f١٣٢٩٦o = simpleArrayMap;
        int i10 = R.attr.qmui_skin_support_tab_separator_color;
        simpleArrayMap.put("bottomSeparator", Integer.valueOf(i10));
        f١٣٢٩٦o.put("topSeparator", Integer.valueOf(i10));
        f١٣٢٩٦o.put("background", Integer.valueOf(R.attr.qmui_skin_support_tab_bg));
    }

    public QMUIBasicTabSegment(Context context) {
        this(context, null);
    }

    private void r(int i10) {
        for (int size = this.f١٣٢٩٧a.size() - 1; size >= 0; size--) {
            ((d) this.f١٣٢٩٧a.get(size)).a(i10);
        }
    }

    private void s(int i10) {
        for (int size = this.f١٣٢٩٧a.size() - 1; size >= 0; size--) {
            ((d) this.f١٣٢٩٧a.get(size)).c(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i10) {
        for (int size = this.f١٣٢٩٧a.size() - 1; size >= 0; size--) {
            ((d) this.f١٣٢٩٧a.get(size)).b(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i10) {
        for (int size = this.f١٣٢٩٧a.size() - 1; size >= 0; size--) {
            ((d) this.f١٣٢٩٧a.get(size)).d(i10);
        }
    }

    private void v(Context context, AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUITabSegment, i10, 0);
        this.f١٣٣٠١e = q(obtainStyledAttributes.getBoolean(R.styleable.QMUITabSegment_qmui_tab_has_indicator, false), obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITabSegment_qmui_tab_indicator_height, getResources().getDimensionPixelSize(R.dimen.qmui_tab_segment_indicator_height)), obtainStyledAttributes.getBoolean(R.styleable.QMUITabSegment_qmui_tab_indicator_top, false), obtainStyledAttributes.getBoolean(R.styleable.QMUITabSegment_qmui_tab_indicator_with_follow_content, false));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITabSegment_qmui_tab_normal_text_size, obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITabSegment_android_textSize, getResources().getDimensionPixelSize(R.dimen.qmui_tab_segment_text_size)));
        this.f١٣٣٠٦j = new com.qmuiteam.qmui.widget.tab.c(context).e(dimensionPixelSize, obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITabSegment_qmui_tab_selected_text_size, dimensionPixelSize)).c(obtainStyledAttributes.getInt(R.styleable.QMUITabSegment_qmui_tab_icon_position, 0));
        this.f١٣٣٠٣g = obtainStyledAttributes.getInt(R.styleable.QMUITabSegment_qmui_tab_mode, 1);
        this.f١٣٣٠٤h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITabSegment_qmui_tab_space, ic.e.a(context, 10));
        this.f١٣٣٠٧k = obtainStyledAttributes.getBoolean(R.styleable.QMUITabSegment_qmui_tab_select_no_animation, false);
        obtainStyledAttributes.recycle();
        Container container = new Container(context);
        this.f١٣٢٩٨b = container;
        addView(container, new FrameLayout.LayoutParams(-2, -1));
        this.f١٣٣٠٥i = p(this.f١٣٢٩٨b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(com.qmuiteam.qmui.widget.tab.a aVar, boolean z10) {
        e eVar;
        int a10;
        if (aVar != null && (eVar = this.f١٣٣٠١e) != null) {
            int i10 = aVar.f١٣٣٨٩v;
            int i11 = aVar.f١٣٣٨٨u;
            int i12 = aVar.f١٣٣٧٨k;
            if (i12 == 0) {
                a10 = aVar.f١٣٣٧٦i;
            } else {
                a10 = dc.d.a(this, i12);
            }
            eVar.f(i10, i11, a10, DownloadProgress.UNKNOWN_PROGRESS);
            if (z10) {
                this.f١٣٢٩٨b.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(com.qmuiteam.qmui.widget.tab.a aVar, com.qmuiteam.qmui.widget.tab.a aVar2, float f10) {
        int a10;
        int a11;
        if (this.f١٣٣٠١e == null) {
            return;
        }
        int i10 = aVar2.f١٣٣٨٩v;
        int i11 = aVar.f١٣٣٨٩v;
        int i12 = aVar2.f١٣٣٨٨u;
        int i13 = (int) (i11 + ((i10 - i11) * f10));
        int i14 = (int) (aVar.f١٣٣٨٨u + ((i12 - r3) * f10));
        int i15 = aVar.f١٣٣٧٨k;
        if (i15 == 0) {
            a10 = aVar.f١٣٣٧٦i;
        } else {
            a10 = dc.d.a(this, i15);
        }
        int i16 = aVar2.f١٣٣٧٨k;
        if (i16 == 0) {
            a11 = aVar2.f١٣٣٧٦i;
        } else {
            a11 = dc.d.a(this, i16);
        }
        this.f١٣٣٠١e.f(i13, i14, ic.c.a(a10, a11, f10), f10);
        this.f١٣٢٩٨b.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(QMUITabView qMUITabView, int i10) {
        if (this.f١٣٣٠٨l == null && !y() && ((com.qmuiteam.qmui.widget.tab.a) this.f١٣٣٠٥i.i(i10)) != null) {
            F(i10, this.f١٣٣٠٧k, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(int i10) {
        if (!this.f١٣٢٩٧a.isEmpty() && ((com.qmuiteam.qmui.widget.tab.a) this.f١٣٣٠٥i.i(i10)) != null) {
            r(i10);
        }
    }

    public void C() {
        this.f١٣٣٠٥i.f();
        this.f١٣٢٩٩c = -1;
        Animator animator = this.f١٣٣٠٨l;
        if (animator != null) {
            animator.cancel();
            this.f١٣٣٠٨l = null;
        }
    }

    public void D() {
        this.f١٣٢٩٩c = -1;
        this.f١٣٣٠٠d = -1;
        Animator animator = this.f١٣٣٠٨l;
        if (animator != null) {
            animator.cancel();
            this.f١٣٣٠٨l = null;
        }
    }

    public void E(int i10) {
        F(i10, this.f١٣٣٠٧k, false);
    }

    public void F(int i10, boolean z10, boolean z11) {
        if (this.f١٣٣٠٩m) {
            return;
        }
        this.f١٣٣٠٩m = true;
        List l10 = this.f١٣٣٠٥i.l();
        if (l10.size() != this.f١٣٣٠٥i.j()) {
            this.f١٣٣٠٥i.n();
            l10 = this.f١٣٣٠٥i.l();
        }
        if (l10.size() != 0 && l10.size() > i10) {
            if (this.f١٣٣٠٨l == null && !y()) {
                int i11 = this.f١٣٢٩٩c;
                if (i11 == i10) {
                    if (z11) {
                        s(i10);
                    }
                    this.f١٣٣٠٩m = false;
                    this.f١٣٢٩٨b.invalidate();
                    return;
                }
                if (i11 > l10.size()) {
                    Log.i("QMUIBasicTabSegment", "selectTab: current selected index is bigger than views size.");
                    this.f١٣٢٩٩c = -1;
                }
                int i12 = this.f١٣٢٩٩c;
                if (i12 == -1) {
                    w((com.qmuiteam.qmui.widget.tab.a) this.f١٣٣٠٥i.i(i10), true);
                    QMUITabView qMUITabView = (QMUITabView) l10.get(i10);
                    qMUITabView.setSelected(true);
                    qMUITabView.setSelectFraction(1.0f);
                    t(i10);
                    this.f١٣٢٩٩c = i10;
                    this.f١٣٣٠٩m = false;
                    return;
                }
                com.qmuiteam.qmui.widget.tab.a aVar = (com.qmuiteam.qmui.widget.tab.a) this.f١٣٣٠٥i.i(i12);
                QMUITabView qMUITabView2 = (QMUITabView) l10.get(i12);
                com.qmuiteam.qmui.widget.tab.a aVar2 = (com.qmuiteam.qmui.widget.tab.a) this.f١٣٣٠٥i.i(i10);
                QMUITabView qMUITabView3 = (QMUITabView) l10.get(i10);
                if (z10) {
                    u(i12);
                    t(i10);
                    qMUITabView2.setSelectFraction(DownloadProgress.UNKNOWN_PROGRESS);
                    qMUITabView2.setSelected(false);
                    qMUITabView3.setSelectFraction(1.0f);
                    qMUITabView3.setSelected(true);
                    if (this.f١٣٣٠٣g == 0) {
                        int scrollX = getScrollX();
                        int width = getWidth();
                        int width2 = this.f١٣٢٩٨b.getWidth();
                        int left = qMUITabView3.getLeft();
                        int width3 = qMUITabView3.getWidth();
                        int paddingLeft = getPaddingLeft() + getPaddingRight();
                        int j10 = this.f١٣٣٠٥i.j();
                        int i13 = (width2 - width) + paddingLeft;
                        if (i10 > i12) {
                            if (i10 >= j10 - 2) {
                                smoothScrollBy(i13 - scrollX, 0);
                            } else {
                                int width4 = ((QMUITabView) l10.get(i10 + 1)).getWidth();
                                int min = Math.min(i13, left - ((((width - (getPaddingRight() * 2)) - width4) - width3) - this.f١٣٣٠٤h)) - (width4 - width3);
                                if (scrollX < min) {
                                    smoothScrollBy(min - scrollX, 0);
                                }
                            }
                        } else if (i10 <= 1) {
                            smoothScrollBy(-scrollX, 0);
                        } else {
                            int max = Math.max(0, (left - ((QMUITabView) l10.get(i10 - 1)).getWidth()) - this.f١٣٣٠٤h);
                            if (max < scrollX) {
                                smoothScrollBy(max - scrollX, 0);
                            }
                        }
                    }
                    this.f١٣٢٩٩c = i10;
                    this.f١٣٣٠٩m = false;
                    w(aVar2, true);
                    return;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
                ofFloat.setInterpolator(yb.a.f١٩٢٣١a);
                ofFloat.addUpdateListener(new a(qMUITabView2, qMUITabView3, aVar, aVar2));
                ofFloat.addListener(new b(qMUITabView2, qMUITabView3, i10, i12, aVar));
                ofFloat.setDuration(200L);
                ofFloat.start();
                this.f١٣٣٠٩m = false;
                return;
            }
            this.f١٣٣٠٠d = i10;
            this.f١٣٣٠٩m = false;
            return;
        }
        this.f١٣٣٠٩m = false;
    }

    public void G(int i10, float f10) {
        int i11;
        if (this.f١٣٣٠٨l == null && !this.f١٣٣٠٩m && f10 != DownloadProgress.UNKNOWN_PROGRESS) {
            if (f10 < DownloadProgress.UNKNOWN_PROGRESS) {
                i11 = i10 - 1;
                f10 = -f10;
            } else {
                i11 = i10 + 1;
            }
            List l10 = this.f١٣٣٠٥i.l();
            if (l10.size() > i10 && l10.size() > i11) {
                com.qmuiteam.qmui.widget.tab.a aVar = (com.qmuiteam.qmui.widget.tab.a) this.f١٣٣٠٥i.i(i10);
                com.qmuiteam.qmui.widget.tab.a aVar2 = (com.qmuiteam.qmui.widget.tab.a) this.f١٣٣٠٥i.i(i11);
                QMUITabView qMUITabView = (QMUITabView) l10.get(i10);
                QMUITabView qMUITabView2 = (QMUITabView) l10.get(i11);
                qMUITabView.setSelectFraction(1.0f - f10);
                qMUITabView2.setSelectFraction(f10);
                x(aVar, aVar2, f10);
            }
        }
    }

    @Override // dc.c
    public void a(dc.e eVar, int i10, Resources.Theme theme, SimpleArrayMap simpleArrayMap) {
        eVar.d(this, theme, simpleArrayMap);
        e eVar2 = this.f١٣٣٠١e;
        if (eVar2 != null) {
            eVar2.b(eVar, i10, theme, (com.qmuiteam.qmui.widget.tab.a) this.f١٣٣٠٥i.i(this.f١٣٢٩٩c));
            this.f١٣٢٩٨b.invalidate();
        }
    }

    public void addOnTabSelectedListener(d dVar) {
        if (!this.f١٣٢٩٧a.contains(dVar)) {
            this.f١٣٢٩٧a.add(dVar);
        }
    }

    @Override // bc.a
    public void d(int i10) {
        this.f١٣٣١٠n.d(i10);
    }

    @Override // bc.a
    public void f(int i10) {
        this.f١٣٣١٠n.f(i10);
    }

    @Override // fc.a
    public SimpleArrayMap<String, Integer> getDefaultSkinAttrs() {
        return f١٣٢٩٦o;
    }

    public int getHideRadiusSide() {
        return this.f١٣٣١٠n.r();
    }

    public int getMode() {
        return this.f١٣٣٠٣g;
    }

    public int getRadius() {
        return this.f١٣٣١٠n.u();
    }

    public int getSelectedIndex() {
        return this.f١٣٢٩٩c;
    }

    public float getShadowAlpha() {
        return this.f١٣٣١٠n.w();
    }

    public int getShadowColor() {
        return this.f١٣٣١٠n.x();
    }

    public int getShadowElevation() {
        return this.f١٣٣١٠n.y();
    }

    public int getTabCount() {
        return this.f١٣٣٠٥i.j();
    }

    @Override // bc.a
    public void i(int i10) {
        this.f١٣٣١٠n.i(i10);
    }

    @Override // bc.a
    public void j(int i10) {
        this.f١٣٣١٠n.j(i10);
    }

    public QMUIBasicTabSegment o(com.qmuiteam.qmui.widget.tab.a aVar) {
        this.f١٣٣٠٥i.d(aVar);
        return this;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f١٣٣١٠n.p(canvas, getWidth(), getHeight());
        this.f١٣٣١٠n.o(canvas);
        super.onDraw(canvas);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.f١٣٢٩٩c != -1 && this.f١٣٣٠٣g == 0) {
            QMUITabView qMUITabView = (QMUITabView) this.f١٣٣٠٥i.l().get(this.f١٣٢٩٩c);
            if (getScrollX() > qMUITabView.getLeft()) {
                scrollTo(qMUITabView.getLeft(), 0);
                return;
            }
            int width = (getWidth() - getPaddingRight()) - getPaddingLeft();
            if (getScrollX() + width < qMUITabView.getRight()) {
                scrollBy((qMUITabView.getRight() - width) - getScrollX(), 0);
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            childAt.measure(View.MeasureSpec.makeMeasureSpec(size - paddingLeft, 1073741824), i11);
            if (mode == Integer.MIN_VALUE) {
                setMeasuredDimension(Math.min(size, childAt.getMeasuredWidth() + paddingLeft), i11);
                return;
            }
        }
        setMeasuredDimension(i10, i11);
    }

    protected com.qmuiteam.qmui.widget.tab.b p(ViewGroup viewGroup) {
        return new com.qmuiteam.qmui.widget.tab.b(this, viewGroup);
    }

    protected e q(boolean z10, int i10, boolean z11, boolean z12) {
        if (!z10) {
            return null;
        }
        return new e(i10, z11, z12);
    }

    public void removeOnTabSelectedListener(d dVar) {
        this.f١٣٢٩٧a.remove(dVar);
    }

    @Override // bc.a
    public void setBorderColor(int i10) {
        this.f١٣٣١٠n.setBorderColor(i10);
        invalidate();
    }

    public void setBorderWidth(int i10) {
        this.f١٣٣١٠n.E(i10);
        invalidate();
    }

    public void setBottomDividerAlpha(int i10) {
        this.f١٣٣١٠n.F(i10);
        invalidate();
    }

    public void setDefaultTabIconPosition(int i10) {
        this.f١٣٣٠٦j.c(i10);
    }

    public void setHideIndicatorWhenTabCountLessTwo(boolean z10) {
        this.f١٣٣٠٢f = z10;
    }

    public void setHideRadiusSide(int i10) {
        this.f١٣٣١٠n.G(i10);
    }

    public void setIndicator(e eVar) {
        this.f١٣٣٠١e = eVar;
        this.f١٣٢٩٨b.requestLayout();
    }

    public void setItemSpaceInScrollMode(int i10) {
        this.f١٣٣٠٤h = i10;
    }

    public void setLeftDividerAlpha(int i10) {
        this.f١٣٣١٠n.H(i10);
        invalidate();
    }

    public void setMode(int i10) {
        if (this.f١٣٣٠٣g != i10) {
            this.f١٣٣٠٣g = i10;
            if (i10 == 0) {
                this.f١٣٣٠٦j.b(3);
            }
            this.f١٣٢٩٨b.invalidate();
        }
    }

    public void setOnTabClickListener(c cVar) {
    }

    public void setOuterNormalColor(int i10) {
        this.f١٣٣١٠n.I(i10);
    }

    public void setOutlineExcludePadding(boolean z10) {
        this.f١٣٣١٠n.J(z10);
    }

    public void setRadius(int i10) {
        this.f١٣٣١٠n.K(i10);
    }

    public void setRightDividerAlpha(int i10) {
        this.f١٣٣١٠n.P(i10);
        invalidate();
    }

    public void setSelectNoAnimation(boolean z10) {
        this.f١٣٣٠٧k = z10;
    }

    public void setShadowAlpha(float f10) {
        this.f١٣٣١٠n.Q(f10);
    }

    public void setShadowColor(int i10) {
        this.f١٣٣١٠n.R(i10);
    }

    public void setShadowElevation(int i10) {
        this.f١٣٣١٠n.T(i10);
    }

    public void setShowBorderOnlyBeforeL(boolean z10) {
        this.f١٣٣١٠n.U(z10);
        invalidate();
    }

    public void setTopDividerAlpha(int i10) {
        this.f١٣٣١٠n.V(i10);
        invalidate();
    }

    protected boolean y() {
        return false;
    }

    public void z() {
        int i10 = this.f١٣٢٩٩c;
        int i11 = this.f١٣٣٠٠d;
        if (i11 != -1) {
            i10 = i11;
        }
        D();
        this.f١٣٣٠٥i.n();
        E(i10);
    }

    public QMUIBasicTabSegment(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUITabSegmentStyle);
    }

    public QMUIBasicTabSegment(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٣٢٩٧a = new ArrayList();
        this.f١٣٢٩٩c = -1;
        this.f١٣٣٠٠d = -1;
        this.f١٣٣٠١e = null;
        this.f١٣٣٠٢f = true;
        this.f١٣٣٠٣g = 1;
        this.f١٣٣٠٩m = false;
        setWillNotDraw(false);
        this.f١٣٣١٠n = new bc.d(context, attributeSet, i10, this);
        v(context, attributeSet, i10);
        setHorizontalScrollBarEnabled(false);
        setClipToPadding(false);
        setClipChildren(false);
    }
}
