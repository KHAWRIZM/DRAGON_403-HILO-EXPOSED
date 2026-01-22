package com.tencent.liteav.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.live2.impl.V2TXLivePlayerImpl;
import com.tencent.live2.impl.V2TXLiveProperty;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLContext;
import org.json.JSONArray;
import org.json.JSONObject;

@JNINamespace("liteav")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TXLivePlayerJni extends V2TXLivePlayer {
    private static final String TAG = "V2TXLivePlayerJni";
    private boolean mClearLastImage = true;
    protected long mNativeV2TXLivePlayerJni;
    private V2TXLivePlayerObserver mObserver;
    private V2TXLivePlayerImpl mProxy;

    /* renamed from: com.tencent.liteav.live.V2TXLivePlayerJni$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;
        static final /* synthetic */ int[] d;
        static final /* synthetic */ int[] e;

        static {
            int[] iArr = new int[k.values().length];
            e = iArr;
            try {
                iArr[k.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                e[k.ROTATION_90.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                e[k.ROTATION_180.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                e[k.ROTATION_270.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[GLConstants.a.values().length];
            d = iArr2;
            try {
                iArr2[GLConstants.a.BYTE_BUFFER.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                d[GLConstants.a.BYTE_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                d[GLConstants.a.TEXTURE_2D.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[GLConstants.PixelFormatType.values().length];
            c = iArr3;
            try {
                iArr3[GLConstants.PixelFormatType.I420.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                c[GLConstants.PixelFormatType.RGBA.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr4 = new int[V2TXLiveDef.V2TXLiveFillMode.values().length];
            b = iArr4;
            try {
                iArr4[V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFill.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeScaleFill.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr5 = new int[V2TXLiveDef.V2TXLiveRotation.values().length];
            a = iArr5;
            try {
                iArr5[V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation90.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation180.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation270.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public V2TXLivePlayerJni(Context context, V2TXLivePlayerImpl v2TXLivePlayerImpl) {
        this.mNativeV2TXLivePlayerJni = 0L;
        this.mProxy = v2TXLivePlayerImpl;
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        this.mNativeV2TXLivePlayerJni = nativeCreate(new WeakReference(this));
    }

    private void enableExtensionCallback(boolean z) {
        synchronized (this) {
            nativeEnableExtensionCallback(this.mNativeV2TXLivePlayerJni, z);
        }
    }

    public static V2TXLiveDef.V2TXLivePlayerStatistics getJavaV2TXLivePlayerStatistics(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        V2TXLiveDef.V2TXLivePlayerStatistics v2TXLivePlayerStatistics = new V2TXLiveDef.V2TXLivePlayerStatistics();
        v2TXLivePlayerStatistics.appCpu = i;
        v2TXLivePlayerStatistics.systemCpu = i2;
        v2TXLivePlayerStatistics.rtt = i3;
        v2TXLivePlayerStatistics.width = i4;
        v2TXLivePlayerStatistics.height = i5;
        v2TXLivePlayerStatistics.fps = i6;
        v2TXLivePlayerStatistics.videoBitrate = i7;
        v2TXLivePlayerStatistics.audioBitrate = i8;
        v2TXLivePlayerStatistics.audioPacketLoss = i9;
        v2TXLivePlayerStatistics.videoPacketLoss = i10;
        v2TXLivePlayerStatistics.jitterBufferDelay = i11;
        v2TXLivePlayerStatistics.audioTotalBlockTime = i12;
        v2TXLivePlayerStatistics.audioBlockRate = i13;
        v2TXLivePlayerStatistics.videoTotalBlockTime = i14;
        v2TXLivePlayerStatistics.videoBlockRate = i15;
        v2TXLivePlayerStatistics.netSpeed = i16;
        return v2TXLivePlayerStatistics;
    }

    private static ArrayList<V2TXLiveDef.V2TXLiveStreamInfo> getStreamListFormJsonString(String str) {
        ArrayList<V2TXLiveDef.V2TXLiveStreamInfo> arrayList = new ArrayList<>();
        if (str != null && !str.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(new V2TXLiveDef.V2TXLiveStreamInfo(jSONObject.getInt("width"), jSONObject.getInt("height"), jSONObject.getInt("bitrate"), (float) jSONObject.getDouble("framerate"), jSONObject.getString("url")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    private static native long nativeCreate(WeakReference<V2TXLivePlayerJni> weakReference);

    private static native void nativeDestroy(long j);

    private static native int nativeEnableCustomRendering(long j, boolean z, int i, int i2);

    private static native void nativeEnableExtensionCallback(long j, boolean z);

    private static native int nativeEnableObserveAudioFrame(long j, boolean z);

    private static native int nativeEnableReceiveSeiMessage(long j, boolean z, int i);

    private static native int nativeEnableVolumeEvaluation(long j, int i);

    private static native String nativeGetStreamList(long j);

    private static native int nativeIsPlaying(long j);

    private static native int nativePauseAudio(long j);

    private static native int nativePauseVideo(long j);

    private static native int nativeResumeAudio(long j);

    private static native int nativeResumeVideo(long j);

    private static native int nativeSetCacheParams(long j, float f, float f2);

    private static native int nativeSetPlayoutVolume(long j, int i);

    private static native int nativeSetProperty(long j, String str, Object obj);

    private static native int nativeSetRenderFillMode(long j, int i);

    private static native int nativeSetRenderMirrorMode(long j, boolean z);

    private static native int nativeSetRenderRotation(long j, int i);

    private static native int nativeSetRenderView(long j, DisplayTarget displayTarget);

    private static native void nativeSetSharedEGLContext(long j, Object obj);

    private static native void nativeShowDebugView(long j, boolean z);

    private static native int nativeSnapshot(long j);

    private static native int nativeStartPlay(long j, String str);

    private static native int nativeStartRecord(long j, String str, int i, int i2);

    private static native int nativeStopPlay(long j, boolean z);

    private static native void nativeStopRecord(long j);

    private static native int nativeSwitchStream(long j, String str);

    public static V2TXLivePlayerJni weakToStrongReference(WeakReference<V2TXLivePlayerJni> weakReference) {
        return weakReference.get();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableObserveAudioFrame(boolean z) {
        return nativeEnableObserveAudioFrame(this.mNativeV2TXLivePlayerJni, z);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableObserveVideoFrame(boolean z, V2TXLiveDef.V2TXLivePixelFormat v2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType v2TXLiveBufferType) {
        GLConstants.PixelFormatType pixelFormatType;
        GLConstants.a aVar;
        V2TXLiveDef.V2TXLivePixelFormat v2TXLivePixelFormat2 = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420;
        if (v2TXLivePixelFormat == v2TXLivePixelFormat2 && v2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray) {
            pixelFormatType = GLConstants.PixelFormatType.I420;
            aVar = GLConstants.a.BYTE_ARRAY;
        } else if (v2TXLivePixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D && v2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture) {
            pixelFormatType = GLConstants.PixelFormatType.RGBA;
            aVar = GLConstants.a.TEXTURE_2D;
        } else if (v2TXLivePixelFormat == v2TXLivePixelFormat2 && v2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer) {
            pixelFormatType = GLConstants.PixelFormatType.I420;
            aVar = GLConstants.a.BYTE_BUFFER;
        } else {
            LiteavLog.e(TAG, "Enable custom render failed, invalid params. format:" + v2TXLivePixelFormat + " type:" + v2TXLiveBufferType);
            return -4;
        }
        return nativeEnableCustomRendering(this.mNativeV2TXLivePlayerJni, z, pixelFormatType.getValue(), aVar.ordinal());
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableReceiveSeiMessage(boolean z, int i) {
        return nativeEnableReceiveSeiMessage(this.mNativeV2TXLivePlayerJni, z, i);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableVolumeEvaluation(int i) {
        return nativeEnableVolumeEvaluation(this.mNativeV2TXLivePlayerJni, i);
    }

    protected void finalize() {
        nativeDestroy(this.mNativeV2TXLivePlayerJni);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public ArrayList<V2TXLiveDef.V2TXLiveStreamInfo> getStreamList() {
        return getStreamListFormJsonString(nativeGetStreamList(this.mNativeV2TXLivePlayerJni));
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int isPlaying() {
        return nativeIsPlaying(this.mNativeV2TXLivePlayerJni);
    }

    public void onAudioLoading(Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onAudioLoading(this.mProxy, bundle);
        }
    }

    public void onAudioPlaying(boolean z, Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onAudioPlaying(this.mProxy, z, bundle);
        }
    }

    public void onConnected(Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onConnected(this.mProxy, bundle);
        }
    }

    public void onError(int i, String str, Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onError(this.mProxy, i, str, bundle);
        }
    }

    public void onNetworkQuality(int i) {
    }

    public void onPlayEvent(int i, Bundle bundle) {
    }

    public void onPlayNetStatus(Bundle bundle) {
    }

    public void onPlayoutAudioFrame(byte[] bArr, int i, int i2) {
        V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame = new V2TXLiveDef.V2TXLiveAudioFrame();
        v2TXLiveAudioFrame.data = bArr;
        v2TXLiveAudioFrame.sampleRate = i;
        v2TXLiveAudioFrame.channel = i2;
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onPlayoutAudioFrame(this.mProxy, v2TXLiveAudioFrame);
        }
    }

    public void onPlayoutVolumeUpdate(int i) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onPlayoutVolumeUpdate(this.mProxy, i);
        }
    }

    public void onReceiveSeiMessage(int i, byte[] bArr) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onReceiveSeiMessage(this.mProxy, i, bArr);
        }
    }

    public void onRecordBegin(int i, String str) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onLocalRecordBegin(this.mProxy, i, str);
        }
    }

    public void onRecordComplete(int i, String str) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onLocalRecordComplete(this.mProxy, i, str);
        }
    }

    public void onRecordProgress(long j, String str) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onLocalRecording(this.mProxy, j, str);
        }
    }

    public void onRenderVideoFrame(int i, int i2, Object obj, int i3, int i4, int i5, int i6, long j, byte[] bArr, ByteBuffer byteBuffer) {
        V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame = new V2TXLiveDef.V2TXLiveVideoFrame();
        GLConstants.PixelFormatType a = GLConstants.PixelFormatType.a(i);
        int i7 = AnonymousClass1.c[a.ordinal()];
        if (i7 != 1) {
            if (i7 != 2) {
                LiteavLog.e(TAG, "Invalid pixelFormat. pixelFormat:" + a + ".");
            } else {
                v2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D;
            }
        } else {
            v2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420;
        }
        GLConstants.a a2 = GLConstants.a.a(i2);
        int i8 = AnonymousClass1.d[a2.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    LiteavLog.e(TAG, "Invalid bufferType. bufferType:" + a2 + ".");
                } else {
                    v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture;
                }
            } else {
                v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray;
            }
        } else {
            v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer;
        }
        V2TXLiveDef.V2TXLiveTexture v2TXLiveTexture = new V2TXLiveDef.V2TXLiveTexture();
        v2TXLiveTexture.textureId = i3;
        if (obj instanceof EGLContext) {
            v2TXLiveTexture.eglContext10 = (EGLContext) obj;
        } else if (obj instanceof android.opengl.EGLContext) {
            v2TXLiveTexture.eglContext14 = (android.opengl.EGLContext) obj;
        }
        v2TXLiveVideoFrame.texture = v2TXLiveTexture;
        v2TXLiveVideoFrame.data = bArr;
        v2TXLiveVideoFrame.buffer = byteBuffer;
        v2TXLiveVideoFrame.width = i4;
        v2TXLiveVideoFrame.height = i5;
        int i9 = AnonymousClass1.e[k.a(i6).ordinal()];
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 != 3) {
                    if (i9 != 4) {
                        v2TXLiveVideoFrame.rotation = 0;
                    } else {
                        v2TXLiveVideoFrame.rotation = 270;
                    }
                } else {
                    v2TXLiveVideoFrame.rotation = 180;
                }
            } else {
                v2TXLiveVideoFrame.rotation = 90;
            }
        } else {
            v2TXLiveVideoFrame.rotation = 0;
        }
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onRenderVideoFrame(this.mProxy, v2TXLiveVideoFrame);
        }
    }

    public void onSnapshotComplete(Bitmap bitmap) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onSnapshotComplete(this.mProxy, bitmap);
        }
    }

    public void onStatisticsUpdate(V2TXLiveDef.V2TXLivePlayerStatistics v2TXLivePlayerStatistics) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onStatisticsUpdate(this.mProxy, v2TXLivePlayerStatistics);
        }
    }

    public void onStreamSwitched(int i, String str) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onStreamSwitched(this.mProxy, str, i);
        }
    }

    public void onVideoLoading(Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onVideoLoading(this.mProxy, bundle);
        }
    }

    public void onVideoPlaying(boolean z, Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onVideoPlaying(this.mProxy, z, bundle);
        }
    }

    public void onVideoResolutionChanged(int i, int i2) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onVideoResolutionChanged(this.mProxy, i, i2);
        }
    }

    public void onWarning(int i, String str, Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onWarning(this.mProxy, i, str, bundle);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int pauseAudio() {
        return nativePauseAudio(this.mNativeV2TXLivePlayerJni);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int pauseVideo() {
        return nativePauseVideo(this.mNativeV2TXLivePlayerJni);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int resumeAudio() {
        return nativeResumeAudio(this.mNativeV2TXLivePlayerJni);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int resumeVideo() {
        return nativeResumeVideo(this.mNativeV2TXLivePlayerJni);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setCacheParams(float f, float f2) {
        if (f >= 0.0f && f2 >= 0.0f) {
            return nativeSetCacheParams(this.mNativeV2TXLivePlayerJni, f, f2);
        }
        return -2;
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public void setObserver(V2TXLivePlayerObserver v2TXLivePlayerObserver) {
        this.mObserver = v2TXLivePlayerObserver;
        if (v2TXLivePlayerObserver != null && (v2TXLivePlayerObserver instanceof com.tencent.live2.impl.a.a)) {
            enableExtensionCallback(true);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setPlayoutVolume(int i) {
        return nativeSetPlayoutVolume(this.mNativeV2TXLivePlayerJni, i);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setProperty(String str, Object obj) {
        char c;
        synchronized (this) {
            try {
                switch (str.hashCode()) {
                    case 480042124:
                        if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurfaceSize)) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 582452376:
                        if (str.equals(V2TXLiveProperty.kV2ClearLastImage)) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1120433643:
                        if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1615550654:
                        if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetOpenGLContext)) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c != 2) {
                            if (c != 3) {
                                return nativeSetProperty(this.mNativeV2TXLivePlayerJni, str, obj);
                            }
                            if (!(obj instanceof EGLContext) && !(obj instanceof android.opengl.EGLContext)) {
                                LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                                return -2;
                            }
                            nativeSetSharedEGLContext(this.mNativeV2TXLivePlayerJni, obj);
                        } else {
                            LiteavLog.i(TAG, "set surface size is unnecessary");
                        }
                    } else {
                        if (obj == null) {
                            return nativeSetRenderView(this.mNativeV2TXLivePlayerJni, null);
                        }
                        if (!(obj instanceof Surface)) {
                            LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                            return -2;
                        }
                        return nativeSetRenderView(this.mNativeV2TXLivePlayerJni, new DisplayTarget((Surface) obj));
                    }
                } else {
                    if (!(obj instanceof Boolean)) {
                        LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                        return -2;
                    }
                    this.mClearLastImage = ((Boolean) obj).booleanValue();
                }
                return 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderFillMode(V2TXLiveDef.V2TXLiveFillMode v2TXLiveFillMode) {
        GLConstants.GLScaleType gLScaleType;
        int i = AnonymousClass1.b[v2TXLiveFillMode.ordinal()];
        if (i != 1) {
            if (i != 2) {
                gLScaleType = GLConstants.GLScaleType.FIT_CENTER;
            } else {
                gLScaleType = GLConstants.GLScaleType.FILL;
            }
        } else {
            gLScaleType = GLConstants.GLScaleType.CENTER_CROP;
        }
        return nativeSetRenderFillMode(this.mNativeV2TXLivePlayerJni, gLScaleType.mValue);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderMirrorMode(boolean z) {
        return nativeSetRenderMirrorMode(this.mNativeV2TXLivePlayerJni, z);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation v2TXLiveRotation) {
        k kVar;
        int i = AnonymousClass1.a[v2TXLiveRotation.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    kVar = k.NORMAL;
                } else {
                    kVar = k.ROTATION_270;
                }
            } else {
                kVar = k.ROTATION_180;
            }
        } else {
            kVar = k.ROTATION_90;
        }
        return nativeSetRenderRotation(this.mNativeV2TXLivePlayerJni, kVar.mValue);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderView(TXCloudVideoView tXCloudVideoView) {
        return nativeSetRenderView(this.mNativeV2TXLivePlayerJni, tXCloudVideoView != null ? new DisplayTarget(tXCloudVideoView) : null);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public void showDebugView(boolean z) {
        nativeShowDebugView(this.mNativeV2TXLivePlayerJni, z);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int snapshot() {
        return nativeSnapshot(this.mNativeV2TXLivePlayerJni);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int startLivePlay(String str) {
        return nativeStartPlay(this.mNativeV2TXLivePlayerJni, str);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int startLocalRecording(V2TXLiveDef.V2TXLiveLocalRecordingParams v2TXLiveLocalRecordingParams) {
        if (v2TXLiveLocalRecordingParams != null && !TextUtils.isEmpty(v2TXLiveLocalRecordingParams.filePath)) {
            return nativeStartRecord(this.mNativeV2TXLivePlayerJni, v2TXLiveLocalRecordingParams.filePath, v2TXLiveLocalRecordingParams.recordMode.ordinal(), v2TXLiveLocalRecordingParams.interval);
        }
        return -2;
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public void stopLocalRecording() {
        nativeStopRecord(this.mNativeV2TXLivePlayerJni);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int stopPlay() {
        return nativeStopPlay(this.mNativeV2TXLivePlayerJni, this.mClearLastImage);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int switchStream(String str) {
        if (TextUtils.isEmpty(str)) {
            LiteavLog.e(TAG, "Invalid params.");
            return -2;
        }
        return nativeSwitchStream(this.mNativeV2TXLivePlayerJni, str);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderView(TextureView textureView) {
        return nativeSetRenderView(this.mNativeV2TXLivePlayerJni, textureView != null ? new DisplayTarget(textureView) : null);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderView(SurfaceView surfaceView) {
        return nativeSetRenderView(this.mNativeV2TXLivePlayerJni, surfaceView != null ? new DisplayTarget(surfaceView) : null);
    }
}
