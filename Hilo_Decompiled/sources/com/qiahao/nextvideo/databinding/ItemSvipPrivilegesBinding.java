package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemSvipPrivilegesBinding extends ViewDataBinding {
    public final ImageView img;
    public final TextView name;
    public final ImageView selectImage;
    public final SVGAImageView svga;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemSvipPrivilegesBinding(Object obj, View view, int i, ImageView imageView, TextView textView, ImageView imageView2, SVGAImageView sVGAImageView) {
        super(obj, view, i);
        this.img = imageView;
        this.name = textView;
        this.selectImage = imageView2;
        this.svga = sVGAImageView;
    }

    public static ItemSvipPrivilegesBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemSvipPrivilegesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemSvipPrivilegesBinding bind(View view, Object obj) {
        return (ItemSvipPrivilegesBinding) ViewDataBinding.bind(obj, view, R.layout.item_svip_privileges);
    }

    @Deprecated
    public static ItemSvipPrivilegesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSvipPrivilegesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_svip_privileges, viewGroup, z, obj);
    }

    public static ItemSvipPrivilegesBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemSvipPrivilegesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSvipPrivilegesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_svip_privileges, (ViewGroup) null, false, obj);
    }
}
