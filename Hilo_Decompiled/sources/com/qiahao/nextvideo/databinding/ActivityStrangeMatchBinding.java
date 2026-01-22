package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityStrangeMatchBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final QMUIRadiusImageView avatar;
    public final TextView avatarTip;
    public final ConstraintLayout centerLayout;
    public final ImageView close;
    public final TextView content;
    public final TextView match;
    public final SVGAImageView matchSvga;
    public final TextView name;
    public final TextView nameTip;
    public final TextView next;
    public final ImageView setting;
    public final Group settingGroup;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityStrangeMatchBinding(Object obj, View view, int i, FrameLayout frameLayout, QMUIRadiusImageView qMUIRadiusImageView, TextView textView, ConstraintLayout constraintLayout, ImageView imageView, TextView textView2, TextView textView3, SVGAImageView sVGAImageView, TextView textView4, TextView textView5, TextView textView6, ImageView imageView2, Group group, TextView textView7) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.avatar = qMUIRadiusImageView;
        this.avatarTip = textView;
        this.centerLayout = constraintLayout;
        this.close = imageView;
        this.content = textView2;
        this.match = textView3;
        this.matchSvga = sVGAImageView;
        this.name = textView4;
        this.nameTip = textView5;
        this.next = textView6;
        this.setting = imageView2;
        this.settingGroup = group;
        this.title = textView7;
    }

    public static ActivityStrangeMatchBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityStrangeMatchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityStrangeMatchBinding bind(View view, Object obj) {
        return (ActivityStrangeMatchBinding) ViewDataBinding.bind(obj, view, R.layout.activity_strange_match);
    }

    @Deprecated
    public static ActivityStrangeMatchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityStrangeMatchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_strange_match, viewGroup, z, obj);
    }

    public static ActivityStrangeMatchBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityStrangeMatchBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityStrangeMatchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_strange_match, (ViewGroup) null, false, obj);
    }
}
