package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentUserPropsHeadBinding extends ViewDataBinding {
    public final AppCompatTextView gift;
    public final LinearLayoutCompat hideGiftLayout;
    public final ImageView image;
    public final LinearLayout llGift;
    public final LinearLayout llMounts;
    public final AppCompatTextView mounts;
    public final RecyclerView mountsRecyclerView;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentUserPropsHeadBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView, LinearLayoutCompat linearLayoutCompat, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, AppCompatTextView appCompatTextView2, RecyclerView recyclerView) {
        super(obj, view, i);
        this.gift = appCompatTextView;
        this.hideGiftLayout = linearLayoutCompat;
        this.image = imageView;
        this.llGift = linearLayout;
        this.llMounts = linearLayout2;
        this.mounts = appCompatTextView2;
        this.mountsRecyclerView = recyclerView;
    }

    public static FragmentUserPropsHeadBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentUserPropsHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentUserPropsHeadBinding bind(View view, Object obj) {
        return (FragmentUserPropsHeadBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_user_props_head);
    }

    @Deprecated
    public static FragmentUserPropsHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentUserPropsHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_user_props_head, viewGroup, z, obj);
    }

    public static FragmentUserPropsHeadBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentUserPropsHeadBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentUserPropsHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_user_props_head, (ViewGroup) null, false, obj);
    }
}
