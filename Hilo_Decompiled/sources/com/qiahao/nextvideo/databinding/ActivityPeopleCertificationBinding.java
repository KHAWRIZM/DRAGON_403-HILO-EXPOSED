package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityPeopleCertificationBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final QMUIRadiusImageView cameraImg;
    public final TextView confirm;
    public final ImageView iconTip;
    public final LinearLayout linearLayout;
    public final IncludeTitleBinding titleLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityPeopleCertificationBinding(Object obj, View view, int i, FrameLayout frameLayout, QMUIRadiusImageView qMUIRadiusImageView, TextView textView, ImageView imageView, LinearLayout linearLayout, IncludeTitleBinding includeTitleBinding) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.cameraImg = qMUIRadiusImageView;
        this.confirm = textView;
        this.iconTip = imageView;
        this.linearLayout = linearLayout;
        this.titleLayout = includeTitleBinding;
    }

    public static ActivityPeopleCertificationBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityPeopleCertificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityPeopleCertificationBinding bind(View view, Object obj) {
        return (ActivityPeopleCertificationBinding) ViewDataBinding.bind(obj, view, R.layout.activity_people_certification);
    }

    @Deprecated
    public static ActivityPeopleCertificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityPeopleCertificationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_people_certification, viewGroup, z, obj);
    }

    public static ActivityPeopleCertificationBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityPeopleCertificationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityPeopleCertificationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_people_certification, (ViewGroup) null, false, obj);
    }
}
