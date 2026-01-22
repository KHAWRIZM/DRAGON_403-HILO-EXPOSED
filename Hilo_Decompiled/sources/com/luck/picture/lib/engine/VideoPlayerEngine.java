package com.luck.picture.lib.engine;

import android.content.Context;
import android.view.View;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnPlayerListener;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface VideoPlayerEngine<T> {
    void addPlayListener(OnPlayerListener onPlayerListener);

    void destroy(T t10);

    boolean isPlaying(T t10);

    View onCreateVideoPlayer(Context context);

    void onPause(T t10);

    void onPlayerAttachedToWindow(T t10);

    void onPlayerDetachedFromWindow(T t10);

    void onResume(T t10);

    void onStarPlayer(T t10, LocalMedia localMedia);

    void removePlayListener(OnPlayerListener onPlayerListener);
}
