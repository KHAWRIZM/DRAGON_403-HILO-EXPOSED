package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Dimension;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.i;
import f8.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class RadialViewGroup extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f١٠٣١٧a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٠٣١٨b;

    /* renamed from: c, reason: collision with root package name */
    private i f١٠٣١٩c;

    public RadialViewGroup(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        setBackground(o());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RadialViewGroup, i10, 0);
        this.f١٠٣١٨b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RadialViewGroup_materialCircleRadius, 0);
        this.f١٠٣١٧a = new Runnable() { // from class: com.google.android.material.timepicker.d
            @Override // java.lang.Runnable
            public final void run() {
                RadialViewGroup.this.r();
            }
        };
        obtainStyledAttributes.recycle();
    }

    private void n(List list, androidx.constraintlayout.widget.c cVar, int i10) {
        Iterator it = list.iterator();
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        while (it.hasNext()) {
            cVar.s(((View) it.next()).getId(), R.id.circle_center, i10, f10);
            f10 += 360.0f / list.size();
        }
    }

    private Drawable o() {
        i iVar = new i();
        this.f١٠٣١٩c = iVar;
        iVar.e0(new m(0.5f));
        this.f١٠٣١٩c.h0(ColorStateList.valueOf(-1));
        return this.f١٠٣١٩c;
    }

    private static boolean q(View view) {
        return "skip".equals(view.getTag());
    }

    private void s() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f١٠٣١٧a);
            handler.post(this.f١٠٣١٧a);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        if (view.getId() == -1) {
            view.setId(View.generateViewId());
        }
        s();
    }

    @Dimension
    public int getRadius() {
        return this.f١٠٣١٨b;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        r();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        s();
    }

    int p(int i10) {
        if (i10 == 2) {
            return Math.round(this.f١٠٣١٨b * 0.66f);
        }
        return this.f١٠٣١٨b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r() {
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        cVar.o(this);
        HashMap hashMap = new HashMap();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getId() != R.id.circle_center && !q(childAt)) {
                int i11 = (Integer) childAt.getTag(R.id.material_clock_level);
                if (i11 == null) {
                    i11 = 1;
                }
                if (!hashMap.containsKey(i11)) {
                    hashMap.put(i11, new ArrayList());
                }
                ((List) hashMap.get(i11)).add(childAt);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            n((List) entry.getValue(), cVar, p(((Integer) entry.getKey()).intValue()));
        }
        cVar.i(this);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.f١٠٣١٩c.h0(ColorStateList.valueOf(i10));
    }

    public void setRadius(@Dimension int i10) {
        this.f١٠٣١٨b = i10;
        r();
    }
}
