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
public abstract class ItemLocalMusicBinding extends ViewDataBinding {
    public final ImageView addMusic;
    public final TextView musicAuthor;
    public final TextView musicName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemLocalMusicBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.addMusic = imageView;
        this.musicAuthor = textView;
        this.musicName = textView2;
    }

    public static ItemLocalMusicBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemLocalMusicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemLocalMusicBinding bind(View view, Object obj) {
        return (ItemLocalMusicBinding) ViewDataBinding.bind(obj, view, R.layout.item_local_music);
    }

    @Deprecated
    public static ItemLocalMusicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLocalMusicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_local_music, viewGroup, z, obj);
    }

    public static ItemLocalMusicBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemLocalMusicBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLocalMusicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_local_music, (ViewGroup) null, false, obj);
    }
}
