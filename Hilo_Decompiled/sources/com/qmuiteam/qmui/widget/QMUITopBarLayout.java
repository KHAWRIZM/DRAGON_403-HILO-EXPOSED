package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.d2;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.qqface.QMUIQQFaceView;
import com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView;
import ic.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUITopBarLayout extends QMUIFrameLayout implements fc.a {

    /* renamed from: c, reason: collision with root package name */
    private QMUITopBar f١٣١٠٤c;

    /* renamed from: d, reason: collision with root package name */
    private SimpleArrayMap f١٣١٠٥d;

    public QMUITopBarLayout(Context context) {
        this(context, null);
    }

    @Override // fc.a
    public SimpleArrayMap<String, Integer> getDefaultSkinAttrs() {
        return this.f١٣١٠٥d;
    }

    public QMUISpanTouchFixTextView getSubTitleView() {
        return this.f١٣١٠٤c.getSubTitleView();
    }

    public QMUIQQFaceView getTitleView() {
        return this.f١٣١٠٤c.getTitleView();
    }

    public QMUITopBar getTopBar() {
        return this.f١٣١٠٤c;
    }

    public void setBackgroundAlpha(int i10) {
        getBackground().mutate().setAlpha(i10);
    }

    public void setCenterView(View view) {
        this.f١٣١٠٤c.setCenterView(view);
    }

    public void setTitleGravity(int i10) {
        this.f١٣١٠٤c.setTitleGravity(i10);
    }

    public QMUITopBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUITopBarStyle);
    }

    public QMUITopBarLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap(2);
        this.f١٣١٠٥d = simpleArrayMap;
        simpleArrayMap.put("bottomSeparator", Integer.valueOf(R.attr.qmui_skin_support_topbar_separator_color));
        this.f١٣١٠٥d.put("background", Integer.valueOf(R.attr.qmui_skin_support_topbar_bg));
        QMUITopBar qMUITopBar = new QMUITopBar(context, attributeSet, i10);
        this.f١٣١٠٤c = qMUITopBar;
        qMUITopBar.setBackground(null);
        this.f١٣١٠٤c.setVisibility(0);
        this.f١٣١٠٤c.setFitsSystemWindows(false);
        this.f١٣١٠٤c.setId(View.generateViewId());
        this.f١٣١٠٤c.c(0, 0, 0, 0);
        addView(this.f١٣١٠٤c, new FrameLayout.LayoutParams(-1, this.f١٣١٠٤c.getTopBarHeight()));
        n.g(this, d2.m.f() | d2.m.a(), true, true);
    }
}
