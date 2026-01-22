package com.qmuiteam.qmui.widget.pullLayout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.g;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.widget.QMUILoadingView;
import com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout;
import dc.d;
import dc.f;
import ic.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIPullLoadMoreView extends ConstraintLayout implements QMUIPullLayout.c {

    /* renamed from: a, reason: collision with root package name */
    private boolean f١٣٢٣٥a;

    /* renamed from: b, reason: collision with root package name */
    private QMUILoadingView f١٣٢٣٦b;

    /* renamed from: c, reason: collision with root package name */
    private AppCompatImageView f١٣٢٣٧c;

    /* renamed from: d, reason: collision with root package name */
    private AppCompatTextView f١٣٢٣٨d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٣٢٣٩e;

    /* renamed from: f, reason: collision with root package name */
    private String f١٣٢٤٠f;

    /* renamed from: g, reason: collision with root package name */
    private String f١٣٢٤١g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f١٣٢٤٢h;

    public QMUIPullLoadMoreView(Context context) {
        this(context, null);
    }

    @Override // com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout.c
    public void a() {
        this.f١٣٢٣٥a = true;
        this.f١٣٢٣٦b.setVisibility(0);
        this.f١٣٢٣٦b.d();
        this.f١٣٢٣٧c.setVisibility(8);
        this.f١٣٢٣٨d.setVisibility(8);
    }

    @Override // com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout.c
    public void h(QMUIPullLayout.g gVar, int i10) {
        if (this.f١٣٢٣٥a) {
            return;
        }
        if (this.f١٣٢٤٢h) {
            if (gVar.n() > i10) {
                this.f١٣٢٤٢h = false;
                this.f١٣٢٣٨d.setText(this.f١٣٢٤٠f);
                this.f١٣٢٣٧c.animate().rotation(180.0f).start();
                return;
            }
            return;
        }
        if (gVar.n() <= i10) {
            this.f١٣٢٤٢h = true;
            this.f١٣٢٣٨d.setText(this.f١٣٢٤١g);
            this.f١٣٢٣٧c.animate().rotation(DownloadProgress.UNKNOWN_PROGRESS).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(this.f١٣٢٣٩e, 1073741824));
    }

    public QMUIPullLoadMoreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUIPullLoadMoreStyle);
    }

    public QMUIPullLoadMoreView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٣٢٣٥a = false;
        this.f١٣٢٤٢h = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIPullLoadMoreView, i10, 0);
        this.f١٣٢٤٠f = obtainStyledAttributes.getString(R.styleable.QMUIPullLoadMoreView_qmui_pull_load_more_pull_text);
        this.f١٣٢٤١g = obtainStyledAttributes.getString(R.styleable.QMUIPullLoadMoreView_qmui_pull_load_more_release_text);
        this.f١٣٢٣٩e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIPullLoadMoreView_qmui_pull_load_more_height, e.a(context, 56));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIPullLoadMoreView_qmui_pull_load_more_loading_size, e.a(context, 20));
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIPullLoadMoreView_qmui_pull_load_more_text_size, e.k(context, 14));
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIPullLoadMoreView_qmui_pull_load_more_arrow_text_gap, e.a(context, 10));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.QMUIPullLoadMoreView_qmui_pull_load_more_arrow);
        int color = obtainStyledAttributes.getColor(R.styleable.QMUIPullLoadMoreView_qmui_skin_support_pull_load_more_bg_color, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.QMUIPullLoadMoreView_qmui_skin_support_pull_load_more_loading_tint_color, -16777216);
        int color3 = obtainStyledAttributes.getColor(R.styleable.QMUIPullLoadMoreView_qmui_skin_support_pull_load_more_arrow_tint_color, -16777216);
        int color4 = obtainStyledAttributes.getColor(R.styleable.QMUIPullLoadMoreView_qmui_skin_support_pull_load_more_text_color, -16777216);
        obtainStyledAttributes.recycle();
        QMUILoadingView qMUILoadingView = new QMUILoadingView(context);
        this.f١٣٢٣٦b = qMUILoadingView;
        qMUILoadingView.setSize(dimensionPixelSize);
        this.f١٣٢٣٦b.setColor(color2);
        this.f١٣٢٣٦b.setVisibility(8);
        ConstraintLayout.b bVar = new ConstraintLayout.b(-2, -2);
        bVar.f٢٣٠٧e = 0;
        bVar.f٢٣١٣h = 0;
        bVar.f٢٣١٥i = 0;
        bVar.f٢٣٢١l = 0;
        addView(this.f١٣٢٣٦b, bVar);
        AppCompatImageView appCompatImageView = new AppCompatImageView(context);
        this.f١٣٢٣٧c = appCompatImageView;
        appCompatImageView.setId(View.generateViewId());
        this.f١٣٢٣٧c.setImageDrawable(drawable);
        this.f١٣٢٣٧c.setRotation(180.0f);
        g.c(this.f١٣٢٣٧c, ColorStateList.valueOf(color3));
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        this.f١٣٢٣٨d = appCompatTextView;
        appCompatTextView.setId(View.generateViewId());
        this.f١٣٢٣٨d.setTextSize(0, dimensionPixelSize2);
        this.f١٣٢٣٨d.setTextColor(color4);
        this.f١٣٢٣٨d.setText(this.f١٣٢٤٠f);
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(-2, -2);
        bVar2.f٢٣٠٧e = 0;
        bVar2.f٢٣١١g = this.f١٣٢٣٨d.getId();
        bVar2.f٢٣١٥i = 0;
        bVar2.f٢٣٢١l = 0;
        bVar2.N = 2;
        addView(this.f١٣٢٣٧c, bVar2);
        ConstraintLayout.b bVar3 = new ConstraintLayout.b(-2, -2);
        bVar3.f٢٣٠٩f = this.f١٣٢٣٧c.getId();
        bVar3.f٢٣١٣h = 0;
        bVar3.f٢٣١٥i = 0;
        bVar3.f٢٣٢١l = 0;
        ((ViewGroup.MarginLayoutParams) bVar3).leftMargin = dimensionPixelSize3;
        addView(this.f١٣٢٣٨d, bVar3);
        setBackgroundColor(color);
        f a10 = f.a();
        a10.b(R.attr.qmui_skin_support_pull_load_more_bg_color);
        d.g(this, a10);
        a10.d();
        a10.j(R.attr.qmui_skin_support_pull_load_more_loading_tint_color);
        d.g(this.f١٣٢٣٦b, a10);
        a10.d();
        a10.j(R.attr.qmui_skin_support_pull_load_more_arrow_tint_color);
        d.g(this.f١٣٢٣٧c, a10);
        a10.d();
        a10.i(R.attr.qmui_skin_support_pull_load_more_text_color);
        d.g(this.f١٣٢٣٨d, a10);
        a10.f();
    }
}
