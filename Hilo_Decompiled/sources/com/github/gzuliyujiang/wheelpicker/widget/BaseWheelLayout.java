package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.github.gzuliyujiang.wheelpicker.R;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import u6.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class BaseWheelLayout extends LinearLayout implements a {

    /* renamed from: a, reason: collision with root package name */
    private final List f٧٩٧٦a;

    public BaseWheelLayout(Context context) {
        super(context);
        this.f٧٩٧٦a = new ArrayList();
        e(context, null, R.attr.WheelStyle, R.style.WheelDefault);
    }

    private void e(Context context, AttributeSet attributeSet, int i10, int i11) {
        setOrientation(1);
        View.inflate(context, i(), this);
        h(context);
        this.f٧٩٧٦a.clear();
        this.f٧٩٧٦a.addAll(j());
        f(context, attributeSet, i10, i11);
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setOnWheelChangedListener(this);
        }
    }

    private void f(Context context, AttributeSet attributeSet, int i10, int i11) {
        float f10 = context.getResources().getDisplayMetrics().density;
        float f11 = context.getResources().getDisplayMetrics().scaledDensity;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BaseWheelLayout, i10, i11);
        setVisibleItemCount(obtainStyledAttributes.getInt(R.styleable.BaseWheelLayout_wheel_visibleItemCount, 5));
        setSameWidthEnabled(obtainStyledAttributes.getBoolean(R.styleable.BaseWheelLayout_wheel_sameWidthEnabled, false));
        setMaxWidthText(obtainStyledAttributes.getString(R.styleable.BaseWheelLayout_wheel_maxWidthText));
        setTextColor(obtainStyledAttributes.getColor(R.styleable.BaseWheelLayout_wheel_itemTextColor, -7829368));
        setSelectedTextColor(obtainStyledAttributes.getColor(R.styleable.BaseWheelLayout_wheel_itemTextColorSelected, -16777216));
        float f12 = f11 * 15.0f;
        setTextSize(obtainStyledAttributes.getDimension(R.styleable.BaseWheelLayout_wheel_itemTextSize, f12));
        setSelectedTextSize(obtainStyledAttributes.getDimension(R.styleable.BaseWheelLayout_wheel_itemTextSizeSelected, f12));
        setSelectedTextBold(obtainStyledAttributes.getBoolean(R.styleable.BaseWheelLayout_wheel_itemTextBoldSelected, false));
        setTextAlign(obtainStyledAttributes.getInt(R.styleable.BaseWheelLayout_wheel_itemTextAlign, 0));
        setItemSpace(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BaseWheelLayout_wheel_itemSpace, (int) (20.0f * f10)));
        setCyclicEnabled(obtainStyledAttributes.getBoolean(R.styleable.BaseWheelLayout_wheel_cyclicEnabled, false));
        setIndicatorEnabled(obtainStyledAttributes.getBoolean(R.styleable.BaseWheelLayout_wheel_indicatorEnabled, false));
        setIndicatorColor(obtainStyledAttributes.getColor(R.styleable.BaseWheelLayout_wheel_indicatorColor, -3552823));
        float f13 = f10 * 1.0f;
        setIndicatorSize(obtainStyledAttributes.getDimension(R.styleable.BaseWheelLayout_wheel_indicatorSize, f13));
        setCurvedIndicatorSpace(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BaseWheelLayout_wheel_curvedIndicatorSpace, (int) f13));
        setCurtainEnabled(obtainStyledAttributes.getBoolean(R.styleable.BaseWheelLayout_wheel_curtainEnabled, false));
        setCurtainColor(obtainStyledAttributes.getColor(R.styleable.BaseWheelLayout_wheel_curtainColor, -1996488705));
        setCurtainCorner(obtainStyledAttributes.getInt(R.styleable.BaseWheelLayout_wheel_curtainCorner, 0));
        setCurtainRadius(obtainStyledAttributes.getDimension(R.styleable.BaseWheelLayout_wheel_curtainRadius, DownloadProgress.UNKNOWN_PROGRESS));
        setAtmosphericEnabled(obtainStyledAttributes.getBoolean(R.styleable.BaseWheelLayout_wheel_atmosphericEnabled, false));
        setCurvedEnabled(obtainStyledAttributes.getBoolean(R.styleable.BaseWheelLayout_wheel_curvedEnabled, false));
        setCurvedMaxAngle(obtainStyledAttributes.getInteger(R.styleable.BaseWheelLayout_wheel_curvedMaxAngle, 90));
        obtainStyledAttributes.recycle();
        g(context, attributeSet);
    }

    @Override // u6.a
    public void a(WheelView wheelView) {
    }

    @Override // u6.a
    public void b(WheelView wheelView, int i10) {
    }

    @Override // u6.a
    public void c(WheelView wheelView, int i10) {
    }

    protected void g(Context context, AttributeSet attributeSet) {
    }

    protected void h(Context context) {
    }

    protected abstract int i();

    protected abstract List j();

    public void setAtmosphericEnabled(boolean z10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setAtmosphericEnabled(z10);
        }
    }

    public void setCurtainColor(int i10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setCurtainColor(i10);
        }
    }

    public void setCurtainCorner(int i10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setCurtainCorner(i10);
        }
    }

    public void setCurtainEnabled(boolean z10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setCurtainEnabled(z10);
        }
    }

    public void setCurtainRadius(float f10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setCurtainRadius(f10);
        }
    }

    public void setCurvedEnabled(boolean z10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setCurvedEnabled(z10);
        }
    }

    public void setCurvedIndicatorSpace(int i10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setCurvedIndicatorSpace(i10);
        }
    }

    public void setCurvedMaxAngle(int i10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setCurvedMaxAngle(i10);
        }
    }

    public void setCyclicEnabled(boolean z10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setCyclicEnabled(z10);
        }
    }

    public void setDefaultItemPosition(int i10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setDefaultPosition(i10);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setEnabled(z10);
        }
    }

    public void setIndicatorColor(int i10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setIndicatorColor(i10);
        }
    }

    public void setIndicatorEnabled(boolean z10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setIndicatorEnabled(z10);
        }
    }

    public void setIndicatorSize(float f10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setIndicatorSize(f10);
        }
    }

    public void setItemSpace(int i10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setItemSpace(i10);
        }
    }

    public void setMaxWidthText(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setMaxWidthText(str);
        }
    }

    public void setSameWidthEnabled(boolean z10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setSameWidthEnabled(z10);
        }
    }

    public void setSelectedTextBold(boolean z10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setSelectedTextBold(z10);
        }
    }

    public void setSelectedTextColor(int i10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setSelectedTextColor(i10);
        }
    }

    public void setSelectedTextSize(float f10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setSelectedTextSize(f10);
        }
    }

    public void setStyle(int i10) {
        f(getContext(), null, R.attr.WheelStyle, i10);
        requestLayout();
        invalidate();
    }

    public void setTextAlign(int i10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setTextAlign(i10);
        }
    }

    public void setTextColor(int i10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setTextColor(i10);
        }
    }

    public void setTextSize(float f10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setTextSize(f10);
        }
    }

    public void setVisibleItemCount(int i10) {
        Iterator it = this.f٧٩٧٦a.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setVisibleItemCount(i10);
        }
    }

    public BaseWheelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٧٩٧٦a = new ArrayList();
        e(context, attributeSet, R.attr.WheelStyle, R.style.WheelDefault);
    }

    public BaseWheelLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٧٩٧٦a = new ArrayList();
        e(context, attributeSet, i10, R.style.WheelDefault);
    }
}
