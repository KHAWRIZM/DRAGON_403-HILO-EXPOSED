package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGroupLuckyBoxBinding extends ViewDataBinding {
    public final FrameLayout bgContent;
    public final ImageButton image;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGroupLuckyBoxBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageButton imageButton) {
        super(obj, view, i);
        this.bgContent = frameLayout;
        this.image = imageButton;
    }

    public static ItemGroupLuckyBoxBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGroupLuckyBoxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGroupLuckyBoxBinding bind(View view, Object obj) {
        return (ItemGroupLuckyBoxBinding) ViewDataBinding.bind(obj, view, R.layout.item_group_lucky_box);
    }

    @Deprecated
    public static ItemGroupLuckyBoxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGroupLuckyBoxBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_lucky_box, viewGroup, z, obj);
    }

    public static ItemGroupLuckyBoxBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGroupLuckyBoxBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGroupLuckyBoxBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_lucky_box, (ViewGroup) null, false, obj);
    }
}
