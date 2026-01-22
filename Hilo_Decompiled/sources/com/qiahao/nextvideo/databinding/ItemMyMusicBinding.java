package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemMyMusicBinding extends ViewDataBinding {
    public final TextView musicAuthor;
    public final TextView musicName;
    public final ImageView playPauseMusic;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemMyMusicBinding(Object obj, View view, int i, TextView textView, TextView textView2, ImageView imageView) {
        super(obj, view, i);
        this.musicAuthor = textView;
        this.musicName = textView2;
        this.playPauseMusic = imageView;
    }

    public static ItemMyMusicBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemMyMusicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemMyMusicBinding bind(View view, Object obj) {
        return (ItemMyMusicBinding) ViewDataBinding.bind(obj, view, R.layout.item_my_music);
    }

    @Deprecated
    public static ItemMyMusicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMyMusicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_my_music, viewGroup, z, obj);
    }

    public static ItemMyMusicBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemMyMusicBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMyMusicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_my_music, (ViewGroup) null, false, obj);
    }
}
