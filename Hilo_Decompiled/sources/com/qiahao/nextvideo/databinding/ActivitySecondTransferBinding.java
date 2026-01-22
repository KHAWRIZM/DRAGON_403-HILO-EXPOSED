package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivitySecondTransferBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final QMUIRadiusImageView avatar;
    public final AppCompatImageView backImageView;
    public final View bar;
    public final NickTextView nickName;
    public final RecyclerView recyclerView;
    public final TextView text1;
    public final TextView text2;
    public final AppCompatTextView title;
    public final LinearLayoutCompat topLayout;
    public final TextView transferSendButton;
    public final View userBg;
    public final TextView userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivitySecondTransferBinding(Object obj, View view, int i, FrameLayout frameLayout, QMUIRadiusImageView qMUIRadiusImageView, AppCompatImageView appCompatImageView, View view2, NickTextView nickTextView, RecyclerView recyclerView, TextView textView, TextView textView2, AppCompatTextView appCompatTextView, LinearLayoutCompat linearLayoutCompat, TextView textView3, View view3, TextView textView4) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.avatar = qMUIRadiusImageView;
        this.backImageView = appCompatImageView;
        this.bar = view2;
        this.nickName = nickTextView;
        this.recyclerView = recyclerView;
        this.text1 = textView;
        this.text2 = textView2;
        this.title = appCompatTextView;
        this.topLayout = linearLayoutCompat;
        this.transferSendButton = textView3;
        this.userBg = view3;
        this.userId = textView4;
    }

    public static ActivitySecondTransferBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivitySecondTransferBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivitySecondTransferBinding bind(View view, Object obj) {
        return (ActivitySecondTransferBinding) ViewDataBinding.bind(obj, view, R.layout.activity_second_transfer);
    }

    @Deprecated
    public static ActivitySecondTransferBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivitySecondTransferBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_second_transfer, viewGroup, z, obj);
    }

    public static ActivitySecondTransferBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivitySecondTransferBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivitySecondTransferBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_second_transfer, (ViewGroup) null, false, obj);
    }
}
