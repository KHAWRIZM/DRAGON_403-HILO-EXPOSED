package com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.IOException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface IPlayer {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnCompletionListener {
        void onCompletion(IPlayer iPlayer);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnErrorListener {
        boolean onError(IPlayer iPlayer, int i, int i2);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnInfoListener {
        void onInfo(IPlayer iPlayer, int i, int i2);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnPreparedListener {
        void onPrepared(IPlayer iPlayer);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnSeekCompleteListener {
        void OnSeekComplete(IPlayer iPlayer);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(IPlayer iPlayer, int i, int i2);
    }

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void pause();

    void prepareAsync();

    void release();

    void seekTo(int i);

    void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    void setDisplay(SurfaceHolder surfaceHolder);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setSurface(Surface surface);

    void start();

    void stop();
}
