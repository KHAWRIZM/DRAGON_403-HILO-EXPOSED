package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewGiftMemberRecyclerBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewGiftMemberRecyclerBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.recyclerView = recyclerView;
    }

    public static ViewGiftMemberRecyclerBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewGiftMemberRecyclerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewGiftMemberRecyclerBinding bind(View view, Object obj) {
        return (ViewGiftMemberRecyclerBinding) ViewDataBinding.bind(obj, view, R.layout.view_gift_member_recycler);
    }

    @Deprecated
    public static ViewGiftMemberRecyclerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewGiftMemberRecyclerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_gift_member_recycler, viewGroup, z, obj);
    }

    public static ViewGiftMemberRecyclerBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewGiftMemberRecyclerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewGiftMemberRecyclerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_gift_member_recycler, (ViewGroup) null, false, obj);
    }
}
