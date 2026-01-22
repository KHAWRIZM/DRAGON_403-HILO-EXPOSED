package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.planet.PlanetPortraitView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewPlanetBinding extends ViewDataBinding {
    public final QMUIRadiusImageView image;
    public final TextView nickName;
    public final PlanetPortraitView speakWave;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewPlanetBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, TextView textView, PlanetPortraitView planetPortraitView) {
        super(obj, view, i);
        this.image = qMUIRadiusImageView;
        this.nickName = textView;
        this.speakWave = planetPortraitView;
    }

    public static ViewPlanetBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewPlanetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewPlanetBinding bind(View view, Object obj) {
        return (ViewPlanetBinding) ViewDataBinding.bind(obj, view, R.layout.view_planet);
    }

    @Deprecated
    public static ViewPlanetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewPlanetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_planet, viewGroup, z, obj);
    }

    public static ViewPlanetBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewPlanetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewPlanetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_planet, (ViewGroup) null, false, obj);
    }
}
