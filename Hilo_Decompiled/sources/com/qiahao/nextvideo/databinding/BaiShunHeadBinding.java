package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.databinding.BaseStatusEmptyBinding;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class BaiShunHeadBinding extends ViewDataBinding {
    public final BaseStatusEmptyBinding empty;
    public final TextView gameActivity;
    public final RecyclerView gameRecyclerView;
    public final TextView recommend;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaiShunHeadBinding(Object obj, View view, int i, BaseStatusEmptyBinding baseStatusEmptyBinding, TextView textView, RecyclerView recyclerView, TextView textView2) {
        super(obj, view, i);
        this.empty = baseStatusEmptyBinding;
        this.gameActivity = textView;
        this.gameRecyclerView = recyclerView;
        this.recommend = textView2;
    }

    public static BaiShunHeadBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static BaiShunHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static BaiShunHeadBinding bind(View view, Object obj) {
        return (BaiShunHeadBinding) ViewDataBinding.bind(obj, view, R.layout.bai_shun_head);
    }

    @Deprecated
    public static BaiShunHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaiShunHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.bai_shun_head, viewGroup, z, obj);
    }

    public static BaiShunHeadBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static BaiShunHeadBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaiShunHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.bai_shun_head, (ViewGroup) null, false, obj);
    }
}
