package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityNumberOfMicBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final TextView confirm;
    protected View.OnClickListener mClick;
    public final RoundedImageView micTypeImage;
    public final TextView text1;
    public final TextView text10;
    public final TextView text11;
    public final TextView text12;
    public final TextView text13;
    public final TextView text15;
    public final TextView text16;
    public final TextView text17;
    public final TextView text18;
    public final TextView text2;
    public final TextView text20;
    public final TextView text3;
    public final TextView text4;
    public final TextView text5;
    public final TextView text6;
    public final TextView text7;
    public final TextView text8;
    public final TextView text9;
    public final AppCompatTextView title;
    public final Toolbar titleBar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityNumberOfMicBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, TextView textView, RoundedImageView roundedImageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, AppCompatTextView appCompatTextView, Toolbar toolbar) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.confirm = textView;
        this.micTypeImage = roundedImageView;
        this.text1 = textView2;
        this.text10 = textView3;
        this.text11 = textView4;
        this.text12 = textView5;
        this.text13 = textView6;
        this.text15 = textView7;
        this.text16 = textView8;
        this.text17 = textView9;
        this.text18 = textView10;
        this.text2 = textView11;
        this.text20 = textView12;
        this.text3 = textView13;
        this.text4 = textView14;
        this.text5 = textView15;
        this.text6 = textView16;
        this.text7 = textView17;
        this.text8 = textView18;
        this.text9 = textView19;
        this.title = appCompatTextView;
        this.titleBar = toolbar;
    }

    public static ActivityNumberOfMicBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityNumberOfMicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static ActivityNumberOfMicBinding bind(View view, Object obj) {
        return (ActivityNumberOfMicBinding) ViewDataBinding.bind(obj, view, R.layout.activity_number_of_mic);
    }

    @Deprecated
    public static ActivityNumberOfMicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityNumberOfMicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_number_of_mic, viewGroup, z, obj);
    }

    public static ActivityNumberOfMicBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityNumberOfMicBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityNumberOfMicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_number_of_mic, (ViewGroup) null, false, obj);
    }
}
