package com.tencent.liteav.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;
import java.io.File;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

@JNINamespace("liteav")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TXLivePlayerJni implements com.tencent.rtmp.a, TXCloudVideoView.b {
    private static final String TAG = "TXLivePlayerJni";
    private TXLivePlayer.ITXAudioRawDataListener mAudioRawDataListener;
    private TXLivePlayer.ITXAudioVolumeEvaluationListener mAudioVolumeEvaluationListener;
    private Object mGLContext = null;
    private ITXLivePlayListener mListener;
    protected long mNativeTXLivePlayerJni;
    private TXLivePlayer.ITXSnapshotListener mSnapshotListener;
    private TXLivePlayer.ITXVideoRawDataListener mVideoRawDataListener;
    private TXRecordCommon.ITXVideoRecordListener mVideoRecordListener;
    private TXLivePlayer.ITXLivePlayVideoRenderListener mVideoRenderListener;

    public TXLivePlayerJni(Context context) {
        this.mNativeTXLivePlayerJni = 0L;
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        this.mNativeTXLivePlayerJni = nativeCreate(new WeakReference(this));
    }

    private static String genFilePath(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(Long.valueOf(valueOf + "000").longValue()));
            String diskFileDir = getDiskFileDir(context);
            if (TextUtils.isEmpty(diskFileDir)) {
                return null;
            }
            return new File(diskFileDir, String.format("TXUGC_%s".concat(String.valueOf(str)), format)).getAbsolutePath();
        } catch (Exception e) {
            LiteavLog.e(TAG, "create file path failed.", e);
            return null;
        }
    }

    private static String getDiskFileDir(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        if (!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
            return context.getFilesDir().getPath();
        }
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        if (externalFilesDir != null) {
            str = externalFilesDir.getPath();
        }
        return str;
    }

    public static String[] getMapKeys(Map<String, String> map) {
        String[] strArr = new String[map.size()];
        Iterator<String> it = map.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = it.next();
            i++;
        }
        return strArr;
    }

    public static String[] getMapValues(Map<String, String> map, String[] strArr) {
        String[] strArr2 = new String[map.size()];
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            strArr2[i2] = map.get(strArr[i]);
            i++;
            i2++;
        }
        return strArr2;
    }

    private static native void nativeCallExperimentalAPI(long j, String str);

    private static native long nativeCreate(WeakReference<TXLivePlayerJni> weakReference);

    private static native long nativeCreateByIdentifier(WeakReference<TXLivePlayerJni> weakReference, String str);

    private static native void nativeDestroy(long j);

    private static native void nativeEnableAudioVolumeEvaluation(long j, int i);

    private static native void nativeEnableCustomAudioProcess(long j, boolean z);

    private static native void nativeEnableCustomRenderI420(long j, boolean z);

    private static native void nativeEnableCustomRenderTexture(long j, boolean z, Object obj);

    private static native void nativeEnableHardwareDecode(long j, boolean z);

    private static native long nativeGetCurrentRenderPts(long j);

    private static native boolean nativeIsPlaying(long j);

    private static native void nativePause(long j);

    private static native void nativeResume(long j);

    private static native void nativeSetAudioRoute(long j, int i);

    private static native void nativeSetConfig(long j, float f, float f2, float f3, int i, int i2, int i3, boolean z, boolean z2, boolean z3, String str, Map map);

    private static native void nativeSetMute(long j, boolean z);

    private static native void nativeSetPlayerView(long j, DisplayTarget displayTarget);

    private static native void nativeSetRenderMode(long j, int i);

    private static native void nativeSetRenderRotation(long j, int i);

    private static native void nativeSetVolume(long j, int i);

    private static native void nativeShowDebugView(long j, boolean z);

    private static native void nativeSnapshot(long j);

    private static native int nativeStartPlay(long j, String str, int i);

    private static native void nativeStartRecord(long j, int i, String str);

    private static native void nativeStopPlay(long j, boolean z);

    private static native void nativeStopRecord(long j);

    private static native int nativeSwitchStream(long j, String str);

    public static TXLivePlayerJni weakToStrongReference(WeakReference<TXLivePlayerJni> weakReference) {
        return weakReference.get();
    }

    public boolean addVideoRawData(byte[] bArr) {
        return false;
    }

    @Override // com.tencent.rtmp.a
    public void callExperimentalAPI(String str) {
        nativeCallExperimentalAPI(this.mNativeTXLivePlayerJni, str);
    }

    @Override // com.tencent.rtmp.a
    public void enableAudioVolumeEvaluation(int i) {
        nativeEnableAudioVolumeEvaluation(this.mNativeTXLivePlayerJni, i);
    }

    @Override // com.tencent.rtmp.a
    public boolean enableHardwareDecode(boolean z) {
        nativeEnableHardwareDecode(this.mNativeTXLivePlayerJni, z);
        return true;
    }

    protected void finalize() {
        nativeDestroy(this.mNativeTXLivePlayerJni);
    }

    @Override // com.tencent.rtmp.a
    public long getCurrentRenderPts() {
        return nativeGetCurrentRenderPts(this.mNativeTXLivePlayerJni);
    }

    @Override // com.tencent.rtmp.a
    public boolean isPlaying() {
        return nativeIsPlaying(this.mNativeTXLivePlayerJni);
    }

    public void onAudioInfoChanged(int i, int i2, int i3) {
        TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener = this.mAudioRawDataListener;
        if (iTXAudioRawDataListener != null) {
            iTXAudioRawDataListener.onAudioInfoChanged(i, i2, i3);
        }
    }

    public void onAudioVolumeEvaluationNotify(int i) {
        TXLivePlayer.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener = this.mAudioVolumeEvaluationListener;
        if (iTXAudioVolumeEvaluationListener != null) {
            iTXAudioVolumeEvaluationListener.onAudioVolumeEvaluationNotify(i);
        }
    }

    public void onNetStatus(Bundle bundle) {
        ITXLivePlayListener iTXLivePlayListener = this.mListener;
        if (iTXLivePlayListener != null) {
            iTXLivePlayListener.onNetStatus(bundle);
        }
    }

    public void onPcmDataAvailable(byte[] bArr, long j) {
        TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener = this.mAudioRawDataListener;
        if (iTXAudioRawDataListener != null) {
            iTXAudioRawDataListener.onPcmDataAvailable(bArr, j);
        }
    }

    public void onPlayEvent(int i, Bundle bundle) {
        ITXLivePlayListener iTXLivePlayListener = this.mListener;
        if (iTXLivePlayListener != null) {
            iTXLivePlayListener.onPlayEvent(i, bundle);
        }
    }

    public void onRecordComplete(int i, String str, String str2, String str3) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            TXRecordCommon.TXRecordResult tXRecordResult = new TXRecordCommon.TXRecordResult();
            if (i == 0) {
                tXRecordResult.retCode = 0;
            } else {
                tXRecordResult.retCode = -1;
            }
            tXRecordResult.descMsg = str;
            tXRecordResult.videoPath = str2;
            tXRecordResult.coverPath = str3;
            iTXVideoRecordListener.onRecordComplete(tXRecordResult);
        }
    }

    public void onRecordEvent(int i, Bundle bundle) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            iTXVideoRecordListener.onRecordEvent(i, bundle);
        }
    }

    public void onRecordProgress(long j) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            iTXVideoRecordListener.onRecordProgress(j);
        }
    }

    public void onRenderVideoFrame(int i, int i2, Object obj, int i3, int i4, int i5, int i6, long j, byte[] bArr, ByteBuffer byteBuffer) {
        TXLivePlayer.ITXLivePlayVideoRenderListener iTXLivePlayVideoRenderListener = this.mVideoRenderListener;
        if (iTXLivePlayVideoRenderListener != null) {
            TXLivePlayer.TXLiteAVTexture tXLiteAVTexture = new TXLivePlayer.TXLiteAVTexture();
            tXLiteAVTexture.textureId = i3;
            tXLiteAVTexture.width = i4;
            tXLiteAVTexture.height = i5;
            tXLiteAVTexture.eglContext = obj;
            iTXLivePlayVideoRenderListener.onRenderVideoFrame(tXLiteAVTexture);
        }
        TXLivePlayer.ITXVideoRawDataListener iTXVideoRawDataListener = this.mVideoRawDataListener;
        if (iTXVideoRawDataListener != null) {
            iTXVideoRawDataListener.onVideoRawDataAvailable(bArr, i4, i5, j);
        }
    }

    @Override // com.tencent.rtmp.ui.TXCloudVideoView.b
    public void onShowLog(boolean z) {
        showDebugView(z);
    }

    public void onSnapshot(Bitmap bitmap) {
        TXLivePlayer.ITXSnapshotListener iTXSnapshotListener = this.mSnapshotListener;
        if (iTXSnapshotListener != null) {
            iTXSnapshotListener.onSnapshot(bitmap);
        }
    }

    @Override // com.tencent.rtmp.a
    public void pause() {
        nativePause(this.mNativeTXLivePlayerJni);
    }

    @Override // com.tencent.rtmp.a
    public void resume() {
        nativeResume(this.mNativeTXLivePlayerJni);
    }

    @Override // com.tencent.rtmp.a
    public void setAudioRawDataListener(TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener) {
        boolean z;
        this.mAudioRawDataListener = iTXAudioRawDataListener;
        long j = this.mNativeTXLivePlayerJni;
        if (iTXAudioRawDataListener != null) {
            z = true;
        } else {
            z = false;
        }
        nativeEnableCustomAudioProcess(j, z);
    }

    @Override // com.tencent.rtmp.a
    public void setAudioRoute(int i) {
        nativeSetAudioRoute(this.mNativeTXLivePlayerJni, i);
    }

    @Override // com.tencent.rtmp.a
    public void setAudioVolumeEvaluationListener(TXLivePlayer.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        this.mAudioVolumeEvaluationListener = iTXAudioVolumeEvaluationListener;
    }

    @Override // com.tencent.rtmp.a
    public void setConfig(TXLivePlayConfig tXLivePlayConfig) {
        if (tXLivePlayConfig == null) {
            return;
        }
        nativeSetConfig(this.mNativeTXLivePlayerJni, tXLivePlayConfig.getCacheTime(), tXLivePlayConfig.getMaxAutoAdjustCacheTime(), tXLivePlayConfig.getMinAutoAdjustCacheTime(), tXLivePlayConfig.getVideoBlockThreshold(), tXLivePlayConfig.getConnectRetryCount(), tXLivePlayConfig.getConnectRetryInterval(), tXLivePlayConfig.isAutoAdjustCacheTime(), tXLivePlayConfig.isEnableMessage(), tXLivePlayConfig.isEnableMetaData(), tXLivePlayConfig.getFlvSessionKey(), tXLivePlayConfig.getHeaders());
    }

    @Override // com.tencent.rtmp.a
    public void setMute(boolean z) {
        nativeSetMute(this.mNativeTXLivePlayerJni, z);
    }

    @Override // com.tencent.rtmp.a
    public void setPlayListener(ITXLivePlayListener iTXLivePlayListener) {
        this.mListener = iTXLivePlayListener;
    }

    @Override // com.tencent.rtmp.a
    public void setPlayerView(TXCloudVideoView tXCloudVideoView) {
        DisplayTarget displayTarget;
        if (tXCloudVideoView != null) {
            a.a(tXCloudVideoView, new WeakReference(this));
            showDebugView(a.a(tXCloudVideoView));
        }
        long j = this.mNativeTXLivePlayerJni;
        if (tXCloudVideoView != null) {
            displayTarget = new DisplayTarget(tXCloudVideoView);
        } else {
            displayTarget = null;
        }
        nativeSetPlayerView(j, displayTarget);
    }

    @Override // com.tencent.rtmp.a
    public void setRenderMode(int i) {
        nativeSetRenderMode(this.mNativeTXLivePlayerJni, i);
    }

    @Override // com.tencent.rtmp.a
    public void setRenderRotation(int i) {
        nativeSetRenderRotation(this.mNativeTXLivePlayerJni, i);
    }

    @Override // com.tencent.rtmp.a
    public void setSurface(Surface surface) {
        DisplayTarget displayTarget;
        long j = this.mNativeTXLivePlayerJni;
        if (surface != null) {
            displayTarget = new DisplayTarget(surface);
        } else {
            displayTarget = null;
        }
        nativeSetPlayerView(j, displayTarget);
    }

    @Override // com.tencent.rtmp.a
    public void setSurfaceSize(int i, int i2) {
    }

    @Override // com.tencent.rtmp.a
    public void setVideoRawDataListener(TXLivePlayer.ITXVideoRawDataListener iTXVideoRawDataListener) {
        synchronized (this) {
            try {
                boolean z = false;
                if (this.mVideoRenderListener != null) {
                    this.mVideoRenderListener = null;
                    this.mGLContext = null;
                    nativeEnableCustomRenderTexture(this.mNativeTXLivePlayerJni, false, null);
                }
                this.mVideoRawDataListener = iTXVideoRawDataListener;
                long j = this.mNativeTXLivePlayerJni;
                if (iTXVideoRawDataListener != null) {
                    z = true;
                }
                nativeEnableCustomRenderI420(j, z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        this.mVideoRecordListener = iTXVideoRecordListener;
    }

    @Override // com.tencent.rtmp.a
    public int setVideoRenderListener(TXLivePlayer.ITXLivePlayVideoRenderListener iTXLivePlayVideoRenderListener, Object obj) {
        boolean z;
        synchronized (this) {
            try {
                if (this.mVideoRawDataListener != null) {
                    this.mVideoRawDataListener = null;
                    nativeEnableCustomRenderI420(this.mNativeTXLivePlayerJni, false);
                }
                this.mVideoRenderListener = iTXLivePlayVideoRenderListener;
                if (iTXLivePlayVideoRenderListener == null) {
                    obj = null;
                }
                this.mGLContext = obj;
                long j = this.mNativeTXLivePlayerJni;
                if (iTXLivePlayVideoRenderListener != null) {
                    z = true;
                } else {
                    z = false;
                }
                nativeEnableCustomRenderTexture(j, z, obj);
            } catch (Throwable th) {
                throw th;
            }
        }
        return 0;
    }

    @Override // com.tencent.rtmp.a
    public void setVolume(int i) {
        nativeSetVolume(this.mNativeTXLivePlayerJni, i);
    }

    @Override // com.tencent.rtmp.a
    public void showDebugView(boolean z) {
        nativeShowDebugView(this.mNativeTXLivePlayerJni, z);
    }

    @Override // com.tencent.rtmp.a
    public void snapshot(TXLivePlayer.ITXSnapshotListener iTXSnapshotListener) {
        this.mSnapshotListener = iTXSnapshotListener;
        nativeSnapshot(this.mNativeTXLivePlayerJni);
    }

    @Override // com.tencent.rtmp.a
    public int startLivePlay(String str, int i) {
        return nativeStartPlay(this.mNativeTXLivePlayerJni, str, i);
    }

    @Override // com.tencent.rtmp.a
    public int startRecord(int i) {
        String genFilePath = genFilePath(ContextUtils.getApplicationContext(), ".mp4");
        if (TextUtils.isEmpty(genFilePath)) {
            return -1;
        }
        nativeStartRecord(this.mNativeTXLivePlayerJni, i, genFilePath);
        return 0;
    }

    @Override // com.tencent.rtmp.a
    public int stopPlay(boolean z) {
        nativeStopPlay(this.mNativeTXLivePlayerJni, z);
        return 0;
    }

    @Override // com.tencent.rtmp.a
    public int stopRecord() {
        nativeStopRecord(this.mNativeTXLivePlayerJni);
        return 0;
    }

    @Override // com.tencent.rtmp.a
    public int switchStream(String str) {
        if (TextUtils.isEmpty(str)) {
            LiteavLog.e(TAG, "Invalid params.");
            return -1;
        }
        return nativeSwitchStream(this.mNativeTXLivePlayerJni, str);
    }

    public TXLivePlayerJni(Context context, String str) {
        this.mNativeTXLivePlayerJni = 0L;
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        this.mNativeTXLivePlayerJni = nativeCreateByIdentifier(new WeakReference(this), str);
    }
}
