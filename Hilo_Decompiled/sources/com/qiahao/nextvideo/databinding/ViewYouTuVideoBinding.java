package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.youtube.YouTuBeSeekBar;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewYouTuVideoBinding extends ViewDataBinding {
    public final Group addGroup;
    public final TextView addVideo;
    public final ImageView addVideoIcon;
    public final ConstraintLayout constraint;
    public final View panel;
    public final ImageView playPauseButton;
    public final YouTuBeSeekBar seekbar;
    public final TextView title;
    public final ImageView videoExit;
    public final ImageView videoList;
    public final ImageView youTuBeIcon;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewYouTuVideoBinding(Object obj, View view, int i, Group group, TextView textView, ImageView imageView, ConstraintLayout constraintLayout, View view2, ImageView imageView2, YouTuBeSeekBar youTuBeSeekBar, TextView textView2, ImageView imageView3, ImageView imageView4, ImageView imageView5) {
        super(obj, view, i);
        this.addGroup = group;
        this.addVideo = textView;
        this.addVideoIcon = imageView;
        this.constraint = constraintLayout;
        this.panel = view2;
        this.playPauseButton = imageView2;
        this.seekbar = youTuBeSeekBar;
        this.title = textView2;
        this.videoExit = imageView3;
        this.videoList = imageView4;
        this.youTuBeIcon = imageView5;
    }

    public static ViewYouTuVideoBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewYouTuVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewYouTuVideoBinding bind(View view, Object obj) {
        return (ViewYouTuVideoBinding) ViewDataBinding.bind(obj, view, R.layout.view_you_tu_video);
    }

    @Deprecated
    public static ViewYouTuVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewYouTuVideoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_you_tu_video, viewGroup, z, obj);
    }

    public static ViewYouTuVideoBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewYouTuVideoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewYouTuVideoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_you_tu_video, (ViewGroup) null, false, obj);
    }
}
