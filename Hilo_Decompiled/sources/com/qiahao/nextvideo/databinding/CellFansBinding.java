package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class CellFansBinding extends ViewDataBinding {
    public final AppCompatImageView endIconImageView;
    public final AppCompatTextView endTextView;
    public final AppCompatTextView endTopTextView;
    public final QMUIRadiusImageView iconCircleImageView;
    public final AppCompatImageView iconCircleL2BImageView;
    public final ImageView iconNoble;
    public final ImageView iconVip;
    public final AppCompatButton likeCallButton;
    public final AppCompatTextView nicknameTextView;
    public final LinearLayoutCompat rootLinear;
    public final AppCompatImageView subtitleLeftIconImageView;
    public final AppCompatTextView subtitleTextView;
    public final ConstraintLayout textFrameLayout;
    public final ImageView textShade;
    public final AppCompatTextView timeTextView;
    public final View timeVerticalLineView;
    public final GenderAgeTextView titleRightTagTextView;
    public final AppCompatTextView titleTextView;
    public final View unreadPotView;
    public final AppCompatButton videoCallButton;

    /* JADX INFO: Access modifiers changed from: protected */
    public CellFansBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, QMUIRadiusImageView qMUIRadiusImageView, AppCompatImageView appCompatImageView2, ImageView imageView, ImageView imageView2, AppCompatButton appCompatButton, AppCompatTextView appCompatTextView3, LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView3, AppCompatTextView appCompatTextView4, ConstraintLayout constraintLayout, ImageView imageView3, AppCompatTextView appCompatTextView5, View view2, GenderAgeTextView genderAgeTextView, AppCompatTextView appCompatTextView6, View view3, AppCompatButton appCompatButton2) {
        super(obj, view, i);
        this.endIconImageView = appCompatImageView;
        this.endTextView = appCompatTextView;
        this.endTopTextView = appCompatTextView2;
        this.iconCircleImageView = qMUIRadiusImageView;
        this.iconCircleL2BImageView = appCompatImageView2;
        this.iconNoble = imageView;
        this.iconVip = imageView2;
        this.likeCallButton = appCompatButton;
        this.nicknameTextView = appCompatTextView3;
        this.rootLinear = linearLayoutCompat;
        this.subtitleLeftIconImageView = appCompatImageView3;
        this.subtitleTextView = appCompatTextView4;
        this.textFrameLayout = constraintLayout;
        this.textShade = imageView3;
        this.timeTextView = appCompatTextView5;
        this.timeVerticalLineView = view2;
        this.titleRightTagTextView = genderAgeTextView;
        this.titleTextView = appCompatTextView6;
        this.unreadPotView = view3;
        this.videoCallButton = appCompatButton2;
    }

    public static CellFansBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static CellFansBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static CellFansBinding bind(View view, Object obj) {
        return (CellFansBinding) ViewDataBinding.bind(obj, view, R.layout.cell_fans);
    }

    @Deprecated
    public static CellFansBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CellFansBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_fans, viewGroup, z, obj);
    }

    public static CellFansBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static CellFansBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CellFansBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_fans, (ViewGroup) null, false, obj);
    }
}
