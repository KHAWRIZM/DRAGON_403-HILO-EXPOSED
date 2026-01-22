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
public abstract class DialogStorePreviewBinding extends ViewDataBinding {
    public final ImageView bgContent;
    public final ImageView bigPic;
    public final LightQueueCombinationPlayer queuePlayer;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogStorePreviewBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, LightQueueCombinationPlayer lightQueueCombinationPlayer) {
        super(obj, view, i);
        this.bgContent = imageView;
        this.bigPic = imageView2;
        this.queuePlayer = lightQueueCombinationPlayer;
    }

    public static DialogStorePreviewBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogStorePreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogStorePreviewBinding bind(View view, Object obj) {
        return (DialogStorePreviewBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_store_preview);
    }

    @Deprecated
    public static DialogStorePreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogStorePreviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_store_preview, viewGroup, z, obj);
    }

    public static DialogStorePreviewBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogStorePreviewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogStorePreviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_store_preview, (ViewGroup) null, false, obj);
    }
}
