package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewCpLevelBinding extends ViewDataBinding {
    public final TextView currentLevel;
    public final TextView currentLevelTip;
    public final ImageView level0;
    public final ImageView level1;
    public final ImageView level2;
    public final ImageView level3;
    public final ImageView level4;
    public final ImageView level5;
    public final ImageView level6;
    public final ImageView level7;
    public final View levelBg;
    public final TextView levelText0;
    public final TextView levelText1;
    public final TextView levelText2;
    public final TextView levelText3;
    public final TextView levelText4;
    public final TextView levelText5;
    public final TextView levelText6;
    public final TextView levelText7;
    public final ConstraintLayout rootLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewCpLevelBinding(Object obj, View view, int i, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, View view2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.currentLevel = textView;
        this.currentLevelTip = textView2;
        this.level0 = imageView;
        this.level1 = imageView2;
        this.level2 = imageView3;
        this.level3 = imageView4;
        this.level4 = imageView5;
        this.level5 = imageView6;
        this.level6 = imageView7;
        this.level7 = imageView8;
        this.levelBg = view2;
        this.levelText0 = textView3;
        this.levelText1 = textView4;
        this.levelText2 = textView5;
        this.levelText3 = textView6;
        this.levelText4 = textView7;
        this.levelText5 = textView8;
        this.levelText6 = textView9;
        this.levelText7 = textView10;
        this.rootLayout = constraintLayout;
    }

    public static ViewCpLevelBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewCpLevelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewCpLevelBinding bind(View view, Object obj) {
        return (ViewCpLevelBinding) ViewDataBinding.bind(obj, view, R.layout.view_cp_level);
    }

    @Deprecated
    public static ViewCpLevelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewCpLevelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_cp_level, viewGroup, z, obj);
    }

    public static ViewCpLevelBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewCpLevelBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewCpLevelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_cp_level, (ViewGroup) null, false, obj);
    }
}
