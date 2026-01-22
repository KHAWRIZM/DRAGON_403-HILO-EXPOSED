package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogGroupMusicBinding extends ViewDataBinding {
    public final ImageView audio;
    public final TextView cancel;
    public final ImageView close;
    public final TextView emptyAddMusic;
    public final LinearLayout emptyPalylist;
    public final TextView endText;
    public final LinearLayout llMusicPlay;
    protected View.OnClickListener mClick;
    public final ImageView musicList;
    public final TextView musicName;
    public final ImageView musicRotationType;
    public final ImageView nextMusic;
    public final ImageView oldMusic;
    public final ImageView playPauseMusic;
    public final SeekBar playProgress;
    public final LinearLayout seekLayout;
    public final TextView startText;
    public final TextView title;
    public final ConstraintLayout voiceLayout;
    public final SeekBar voiceSeek;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogGroupMusicBinding(Object obj, View view, int i, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2, LinearLayout linearLayout, TextView textView3, LinearLayout linearLayout2, ImageView imageView3, TextView textView4, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, SeekBar seekBar, LinearLayout linearLayout3, TextView textView5, TextView textView6, ConstraintLayout constraintLayout, SeekBar seekBar2) {
        super(obj, view, i);
        this.audio = imageView;
        this.cancel = textView;
        this.close = imageView2;
        this.emptyAddMusic = textView2;
        this.emptyPalylist = linearLayout;
        this.endText = textView3;
        this.llMusicPlay = linearLayout2;
        this.musicList = imageView3;
        this.musicName = textView4;
        this.musicRotationType = imageView4;
        this.nextMusic = imageView5;
        this.oldMusic = imageView6;
        this.playPauseMusic = imageView7;
        this.playProgress = seekBar;
        this.seekLayout = linearLayout3;
        this.startText = textView5;
        this.title = textView6;
        this.voiceLayout = constraintLayout;
        this.voiceSeek = seekBar2;
    }

    public static DialogGroupMusicBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogGroupMusicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogGroupMusicBinding bind(View view, Object obj) {
        return (DialogGroupMusicBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_group_music);
    }

    @Deprecated
    public static DialogGroupMusicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogGroupMusicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_group_music, viewGroup, z, obj);
    }

    public static DialogGroupMusicBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogGroupMusicBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogGroupMusicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_group_music, (ViewGroup) null, false, obj);
    }
}
