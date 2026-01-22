package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class IncludeCpItemBinding extends ViewDataBinding {
    public final HiloImageView avatar1;
    public final HiloImageView avatar2;
    public final ImageView bg1;
    public final ImageView bg2;
    public final SVGAImageView heartBg;
    public final ImageView medal;
    public final NickTextView userName1;
    public final NickTextView userName2;

    /* JADX INFO: Access modifiers changed from: protected */
    public IncludeCpItemBinding(Object obj, View view, int i, HiloImageView hiloImageView, HiloImageView hiloImageView2, ImageView imageView, ImageView imageView2, SVGAImageView sVGAImageView, ImageView imageView3, NickTextView nickTextView, NickTextView nickTextView2) {
        super(obj, view, i);
        this.avatar1 = hiloImageView;
        this.avatar2 = hiloImageView2;
        this.bg1 = imageView;
        this.bg2 = imageView2;
        this.heartBg = sVGAImageView;
        this.medal = imageView3;
        this.userName1 = nickTextView;
        this.userName2 = nickTextView2;
    }

    public static IncludeCpItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static IncludeCpItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static IncludeCpItemBinding bind(View view, Object obj) {
        return (IncludeCpItemBinding) ViewDataBinding.bind(obj, view, R.layout.include_cp_item);
    }

    @Deprecated
    public static IncludeCpItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludeCpItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_cp_item, viewGroup, z, obj);
    }

    public static IncludeCpItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static IncludeCpItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeCpItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_cp_item, (ViewGroup) null, false, obj);
    }
}
