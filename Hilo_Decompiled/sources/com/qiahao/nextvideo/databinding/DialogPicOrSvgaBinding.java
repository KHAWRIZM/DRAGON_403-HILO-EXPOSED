package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogPicOrSvgaBinding extends ViewDataBinding {
    public final ImageView bgContent;
    public final ImageView bigPic;
    public final LightQueueCombinationPlayer queuePlayer;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogPicOrSvgaBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, LightQueueCombinationPlayer lightQueueCombinationPlayer) {
        super(obj, view, i);
        this.bgContent = imageView;
        this.bigPic = imageView2;
        this.queuePlayer = lightQueueCombinationPlayer;
    }

    public static DialogPicOrSvgaBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogPicOrSvgaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogPicOrSvgaBinding bind(View view, Object obj) {
        return (DialogPicOrSvgaBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_pic_or_svga);
    }

    @Deprecated
    public static DialogPicOrSvgaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogPicOrSvgaBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_pic_or_svga, viewGroup, z, obj);
    }

    public static DialogPicOrSvgaBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogPicOrSvgaBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogPicOrSvgaBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_pic_or_svga, (ViewGroup) null, false, obj);
    }
}
