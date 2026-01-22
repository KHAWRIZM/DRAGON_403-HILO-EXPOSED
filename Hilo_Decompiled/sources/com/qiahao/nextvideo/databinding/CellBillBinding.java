package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.CorneredImageView;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class CellBillBinding extends ViewDataBinding {
    public final AppCompatImageView endIconImageView;
    public final AppCompatTextView endTextView;
    public final AppCompatTextView endTopTextView;
    public final CorneredImageView iconCircleImageView;
    public final AppCompatImageView iconCircleL2BImageView;
    public final AppCompatTextView iconCircleR2TTextView;
    public final AppCompatImageView subtitleLeftIconImageView;
    public final AppCompatTextView subtitleTextView;
    public final GenderAgeTextView titleRightTagTextView;
    public final AppCompatTextView titleTextView;

    /* JADX INFO: Access modifiers changed from: protected */
    public CellBillBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, CorneredImageView corneredImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView3, AppCompatImageView appCompatImageView3, AppCompatTextView appCompatTextView4, GenderAgeTextView genderAgeTextView, AppCompatTextView appCompatTextView5) {
        super(obj, view, i);
        this.endIconImageView = appCompatImageView;
        this.endTextView = appCompatTextView;
        this.endTopTextView = appCompatTextView2;
        this.iconCircleImageView = corneredImageView;
        this.iconCircleL2BImageView = appCompatImageView2;
        this.iconCircleR2TTextView = appCompatTextView3;
        this.subtitleLeftIconImageView = appCompatImageView3;
        this.subtitleTextView = appCompatTextView4;
        this.titleRightTagTextView = genderAgeTextView;
        this.titleTextView = appCompatTextView5;
    }

    public static CellBillBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static CellBillBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static CellBillBinding bind(View view, Object obj) {
        return (CellBillBinding) ViewDataBinding.bind(obj, view, R.layout.cell_bill);
    }

    @Deprecated
    public static CellBillBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CellBillBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_bill, viewGroup, z, obj);
    }

    public static CellBillBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static CellBillBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CellBillBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_bill, (ViewGroup) null, false, obj);
    }
}
