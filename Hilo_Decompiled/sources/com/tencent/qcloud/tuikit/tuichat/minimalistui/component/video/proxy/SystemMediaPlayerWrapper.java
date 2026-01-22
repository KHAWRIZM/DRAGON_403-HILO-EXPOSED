package com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.IPlayer;
import java.io.IOException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class SystemMediaPlayerWrapper implements IPlayer {
    private MediaPlayer mMediaPlayer = new MediaPlayer();

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.IPlayer
    public int getCurrentPosition() {
        return this.mMediaPlayer.getCurrentPosition();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.IPlayer
    public int getDuration() {
        return this.mMediaPlayer.getDuration();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.IPlayer
    public int getVideoHeight() {
        return this.mMediaPlayer.getVideoHeight();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.IPlayer
    public int getVideoWidth() {
        return this.mMediaPlayer.getVideoWidth();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.IPlayer
    public boolean isPlaying() {
        return this.mMediaPlayer.isPlaying();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.IPlayer
    public void pause() {
        this.mMediaPlayer.pause();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.IPlayer
    public void prepareAsync() {
        this.mMediaPlayer.prepareAsync();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.IPlayer
    public void release() {
        this.mMediaPlayer.release();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.IPlayer
    public void seekTo(int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mMediaPlayer.seekTo(i, 3);
        } else {
            this.mMediaPlayer.seekTo(i);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.IPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mMediaPlayer.setDataSource(context, uri);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.IPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mMediaPlayer.setDisplay(surfaceHolder);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.IPlayer
    public void setOnCompletionListener(final IPlayer.OnCompletionListener onCompletionListener) {
        this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.SystemMediaPlayerWrapper.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                onCompletionListener.onCompletion(SystemMediaPlayerWrapper.this);
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.IPlayer
    public void setOnErrorListener(final IPlayer.OnErrorListener onErrorListener) {
        this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.SystemMediaPlayerWrapper.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                return onErrorListener.onError(SystemMediaPlayerWrapper.this, i, i2);
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.IPlayer
    public void setOnInfoListener(final IPlayer.OnInfoListener onInfoListener) {
        this.mMediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.SystemMediaPlayerWrapper.6
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                onInfoListener.onInfo(SystemMediaPlayerWrapper.this, i, i2);
                return false;
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.IPlayer
    public void setOnPreparedListener(final IPlayer.OnPreparedListener onPreparedListener) {
        this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.SystemMediaPlayerWrapper.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                onPreparedListener.onPrepared(SystemMediaPlayerWrapper.this);
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.IPlayer
    public void setOnSeekCompleteListener(final IPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mMediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.SystemMediaPlayerWrapper.4
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                onSeekCompleteListener.OnSeekComplete(SystemMediaPlayerWrapper.this);
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.IPlayer
    public void setOnVideoSizeChangedListener(final IPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mMediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.SystemMediaPlayerWrapper.5
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                onVideoSizeChangedListener.onVideoSizeChanged(SystemMediaPlayerWrapper.this, i, i2);
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.IPlayer
    public void setSurface(Surface surface) {
        this.mMediaPlayer.setSurface(surface);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.IPlayer
    public void start() {
        this.mMediaPlayer.start();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.video.proxy.IPlayer
    public void stop() {
        this.mMediaPlayer.stop();
    }
}
