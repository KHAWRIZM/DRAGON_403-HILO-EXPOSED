package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewAristocracyPermissionListBinding extends ViewDataBinding {
    public final ConstraintLayout aristocracyLayout8;
    public final ConstraintLayout aristocracyLayout9;
    public final TextView aristocracyLayoutSubTitle;
    public final TextView aristocracyLayoutSubTitle9;
    public final TextView aristocracyLayoutTitle;
    public final TextView aristocracyLayoutTitle9;
    public final ImageView image;
    public final ImageView image9;
    public final TextView number;
    public final TextView number9;
    public final TextView permissionNumber;
    public final TextView receive;
    public final TextView receive9;
    public final RecyclerView recycler;
    public final TextView tip2;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewAristocracyPermissionListBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView, ImageView imageView2, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, RecyclerView recyclerView, TextView textView10) {
        super(obj, view, i);
        this.aristocracyLayout8 = constraintLayout;
        this.aristocracyLayout9 = constraintLayout2;
        this.aristocracyLayoutSubTitle = textView;
        this.aristocracyLayoutSubTitle9 = textView2;
        this.aristocracyLayoutTitle = textView3;
        this.aristocracyLayoutTitle9 = textView4;
        this.image = imageView;
        this.image9 = imageView2;
        this.number = textView5;
        this.number9 = textView6;
        this.permissionNumber = textView7;
        this.receive = textView8;
        this.receive9 = textView9;
        this.recycler = recyclerView;
        this.tip2 = textView10;
    }

    public static ViewAristocracyPermissionListBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewAristocracyPermissionListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewAristocracyPermissionListBinding bind(View view, Object obj) {
        return (ViewAristocracyPermissionListBinding) ViewDataBinding.bind(obj, view, R.layout.view_aristocracy_permission_list);
    }

    @Deprecated
    public static ViewAristocracyPermissionListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewAristocracyPermissionListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_aristocracy_permission_list, viewGroup, z, obj);
    }

    public static ViewAristocracyPermissionListBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewAristocracyPermissionListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewAristocracyPermissionListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_aristocracy_permission_list, (ViewGroup) null, false, obj);
    }
}
