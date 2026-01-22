package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.videocall.videoIM.VideoRecycleView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class VideoImBinding extends ViewDataBinding {
    public final VideoRecycleView recyclerView;

    /* JADX INFO: Access modifiers changed from: protected */
    public VideoImBinding(Object obj, View view, int i, VideoRecycleView videoRecycleView) {
        super(obj, view, i);
        this.recyclerView = videoRecycleView;
    }

    public static VideoImBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static VideoImBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static VideoImBinding bind(View view, Object obj) {
        return (VideoImBinding) ViewDataBinding.bind(obj, view, R.layout.video_im);
    }

    @Deprecated
    public static VideoImBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideoImBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.video_im, viewGroup, z, obj);
    }

    public static VideoImBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static VideoImBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideoImBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.video_im, (ViewGroup) null, false, obj);
    }
}
