package com.qiahao.base_common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.base_common.R;
import com.qiahao.base_common.wedgit.shineText.CountryShineTextView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class ViewCountryIdBinding extends ViewDataBinding {
    public final ConstraintLayout constraint;
    public final CountryShineTextView countryId;
    public final SVGAImageView glisten;
    public final Group group;
    public final SVGAImageView svga;
    public final ShineTextView userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewCountryIdBinding(Object obj, View view, int i10, ConstraintLayout constraintLayout, CountryShineTextView countryShineTextView, SVGAImageView sVGAImageView, Group group, SVGAImageView sVGAImageView2, ShineTextView shineTextView) {
        super(obj, view, i10);
        this.constraint = constraintLayout;
        this.countryId = countryShineTextView;
        this.glisten = sVGAImageView;
        this.group = group;
        this.svga = sVGAImageView2;
        this.userId = shineTextView;
    }

    public static ViewCountryIdBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewCountryIdBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static ViewCountryIdBinding bind(View view, Object obj) {
        return (ViewCountryIdBinding) ViewDataBinding.bind(obj, view, R.layout.view_country_id);
    }

    @Deprecated
    public static ViewCountryIdBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (ViewCountryIdBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_country_id, viewGroup, z10, obj);
    }

    public static ViewCountryIdBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewCountryIdBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewCountryIdBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_country_id, null, false, obj);
    }
}
