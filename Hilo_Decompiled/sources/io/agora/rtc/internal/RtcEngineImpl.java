package io.agora.rtc.internal;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import anetwork.channel.util.RequestConstant;
import com.luck.picture.lib.config.PictureMimeType;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import io.agora.rtc.AgoraMediaRecorder;
import io.agora.rtc.Constants;
import io.agora.rtc.IAudioEffectManager;
import io.agora.rtc.IAudioFrameObserver;
import io.agora.rtc.ILogWriter;
import io.agora.rtc.IMetadataObserver;
import io.agora.rtc.IRtcChannelEventHandler;
import io.agora.rtc.IRtcEngineEventHandler;
import io.agora.rtc.IRtcEngineEventHandlerEx;
import io.agora.rtc.IVideoEncodedFrameObserver;
import io.agora.rtc.IVideoFrameObserver;
import io.agora.rtc.RtcChannel;
import io.agora.rtc.RtcEngine;
import io.agora.rtc.RtcEngineConfig;
import io.agora.rtc.RtcEngineEx;
import io.agora.rtc.ScreenCaptureParameters;
import io.agora.rtc.audio.AgoraRhythmPlayerConfig;
import io.agora.rtc.audio.AudioParams;
import io.agora.rtc.audio.AudioRecordingConfiguration;
import io.agora.rtc.audio.SpatialAudioParams;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.internal.RtcEngineEvent;
import io.agora.rtc.internal.RtcEngineMessage;
import io.agora.rtc.live.LiveInjectStreamConfig;
import io.agora.rtc.live.LiveTranscoding;
import io.agora.rtc.mediaio.AgoraDefaultRender;
import io.agora.rtc.mediaio.AgoraDefaultSource;
import io.agora.rtc.mediaio.IVideoSink;
import io.agora.rtc.mediaio.IVideoSource;
import io.agora.rtc.models.ChannelMediaOptions;
import io.agora.rtc.models.ClientRoleOptions;
import io.agora.rtc.models.ContentInspectConfig;
import io.agora.rtc.models.DataStreamConfig;
import io.agora.rtc.models.EchoTestConfiguration;
import io.agora.rtc.models.UserInfo;
import io.agora.rtc.proxy.LocalAccessPointConfiguration;
import io.agora.rtc.video.AgoraImage;
import io.agora.rtc.video.AgoraVideoFrame;
import io.agora.rtc.video.BeautyOptions;
import io.agora.rtc.video.CameraCapturerConfiguration;
import io.agora.rtc.video.ChannelMediaInfo;
import io.agora.rtc.video.ChannelMediaRelayConfiguration;
import io.agora.rtc.video.ColorEnhanceOptions;
import io.agora.rtc.video.LowLightEnhanceOptions;
import io.agora.rtc.video.ViETextureViewWrapper;
import io.agora.rtc.video.VideoCanvas;
import io.agora.rtc.video.VideoDenoiserOptions;
import io.agora.rtc.video.VideoEncoderConfiguration;
import io.agora.rtc.video.VirtualBackgroundSource;
import io.agora.rtc.video.WatermarkOptions;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.microedition.khronos.egl.EGLContext;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class RtcEngineImpl extends RtcEngineEx implements IAudioEffectManager {
    private static final String TAG = "RtcEngine";
    public static final int VIDEO_SOURCE_TYPE_CUSTOMIZED = 2;
    public static final int VIDEO_SOURCE_TYPE_DEFAULT = 1;
    private static final int VIDEO_SOURCE_TYPE_EXTERNAL_DEPRECATED = 3;
    public static final int VIDEO_SOURCE_TYPE_NULL = 0;
    private static boolean sLibLoaded;
    static float[] sMatrix = {1.0f, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f};
    IRtcEngineEventHandler.AgoraFacePositionInfo[] faceRectArr;
    private WeakReference<Context> mContext;
    private long mNativeHandle;
    private int mVideoSourceType = 1;
    private boolean mLocalVideoEnabled = false;
    private boolean mUseLocalView = false;
    private int mExAudioSourceSampleRate = 0;
    private int mExAudioSourceChannels = 0;
    private int mExAudioSinkChannels = -1;
    private int mExAudioSinkSampleRate = -1;
    private long lastOrientationTs = 0;
    private int mTotalRotation = 1000;
    private final ConcurrentHashMap<IRtcEngineEventHandler, Integer> mRtcHandlers = new ConcurrentHashMap<>();
    private RtcChannelImpl mDefaultRtcChannel = null;
    private final LinkedList<RtcChannelImpl> mRtcChannels = new LinkedList<>();
    private IRtcEngineEventHandler.RtcStats mRtcStats = null;
    private WifiManager.WifiLock mWifiLock = null;
    private int mChannelProfile = 1;
    private int mClientRole = 2;
    private IntentFilter filter = new IntentFilter();
    private BroadcastReceiver mUsbStateChangeReceiver = new BroadcastReceiver() { // from class: io.agora.rtc.internal.RtcEngineImpl.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action) || "android.hardware.usb.action.USB_ACCESSORY_ATTACHED".equals(action)) {
                Logging.i(RtcEngineImpl.TAG, "device attached");
                RtcEngineImpl.this.refresh_device_list();
            }
            if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action) || "android.hardware.usb.action.USB_ACCESSORY_DETACHED".equals(action)) {
                Logging.i(RtcEngineImpl.TAG, "device detached");
                RtcEngineImpl.this.refresh_device_list();
            }
        }
    };

    public RtcEngineImpl(Context context, String str, IRtcEngineEventHandler iRtcEngineEventHandler) throws Exception {
        this.mNativeHandle = 0L;
        this.mContext = new WeakReference<>(context);
        addHandler(iRtcEngineEventHandler);
        this.mNativeHandle = nativeObjectInit(context, str, "", "", "", "", "", "");
        initDeviceNotify(context);
        setParameter("che.android_app_external_storage_path", CommonUtility.getAppPrivateStorageDir(context));
        if (RtcEngine.externalLibPath != null) {
            setParameter("rtc.android_dynamic_loading", 1);
        }
    }

    private int adjustEffectsPlayoutVolume(int i10) {
        return setParameter("che.audio.set_effect_file_playout_volume", i10);
    }

    private int adjustEffectsPublishVolume(int i10) {
        return setParameter("che.audio.set_effect_file_publish_volume", i10);
    }

    public static boolean checkIfInUIThread(String str) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            Logging.i(TAG, str + " in UI Thread");
            return true;
        }
        Logging.i(TAG, str + " not in UI Thread");
        return false;
    }

    private synchronized boolean checkStatus() {
        if (this.mNativeHandle == 0) {
            throw new IllegalStateException("RtcEngine does not initialize or it may be destroyed");
        }
        return true;
    }

    private void checkVoipPermissions(Context context, String str) throws SecurityException {
        if (context != null && context.checkPermission(str, Process.myPid(), Process.myUid()) == 0) {
            return;
        }
        throw new SecurityException(str + " is not granted");
    }

    private native int deliverFrame(long j10, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j11, int i17);

    private int doCheckPermission(Context context) {
        try {
            checkVoipPermissions(context, "android.permission.INTERNET");
            return 0;
        } catch (SecurityException unused) {
            Logging.e(TAG, "can't join channel because no permission");
            return -9;
        }
    }

    private void doJoinChannelCheck(Context context) {
        if (joinChannelFirstTimeOrAllChannelLeft()) {
            doMonitorSystemEvent(context);
            doCheckPermission(context);
        }
    }

    private void doLeaveChannelCheck() {
        if (joinChannelFirstTimeOrAllChannelLeft()) {
            doStopMonitorSystemEvent();
        }
    }

    private void doMonitorSystemEvent(Context context) {
        WifiManager.WifiLock wifiLock;
        if (context != null && context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) == 0 && Connectivity.getNetworkType(context) == 2 && context.checkPermission("android.permission.ACCESS_WIFI_STATE", Process.myPid(), Process.myUid()) == 0 && (wifiLock = this.mWifiLock) != null) {
            wifiLock.acquire();
            Logging.i(TAG, "hp connection mode detected");
        }
    }

    private void doStopMonitorSystemEvent() {
        WifiManager.WifiLock wifiLock = this.mWifiLock;
        if (wifiLock != null && wifiLock.isHeld()) {
            this.mWifiLock.release();
            Logging.i(TAG, "hp connection mode ended");
        }
    }

    private static String formatString(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private String getAssetsCacheFile(Context context, String str) {
        try {
            File file = new File(context.getCacheDir(), "wm_" + str.replace(File.separator, "_"));
            if (file.exists()) {
                file.delete();
            }
            InputStream open = context.getAssets().open(str);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            open.close();
                            return file.getAbsolutePath();
                        }
                    }
                } finally {
                    fileOutputStream.close();
                }
            } catch (Throwable th) {
                open.close();
                throw th;
            }
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    private int getEffectsPlayoutVolume() {
        int nativeGetIntParameter = nativeGetIntParameter(this.mNativeHandle, "che.audio.get_effect_file_playout_volume", null);
        if (nativeGetIntParameter < 0) {
            return 0;
        }
        return nativeGetIntParameter;
    }

    protected static String getLocalHost() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (!networkInterface.getName().startsWith("usb")) {
                    Iterator it = Collections.list(networkInterface.getInetAddresses()).iterator();
                    while (it.hasNext()) {
                        String inetAddressToIpAddress = inetAddressToIpAddress((InetAddress) it.next());
                        if (inetAddressToIpAddress != null && !inetAddressToIpAddress.isEmpty()) {
                            return inetAddressToIpAddress;
                        }
                    }
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private RtcEngineMessage.PVideoNetOptions getOptionsByVideoProfile(int i10) {
        try {
            byte[] nativeGetOptionsByVideoProfile = nativeGetOptionsByVideoProfile(this.mNativeHandle, i10);
            if (nativeGetOptionsByVideoProfile != null) {
                RtcEngineMessage.PVideoNetOptions pVideoNetOptions = new RtcEngineMessage.PVideoNetOptions();
                pVideoNetOptions.unmarshall(nativeGetOptionsByVideoProfile);
                return pVideoNetOptions;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private static String inetAddressToIpAddress(InetAddress inetAddress) {
        if (!inetAddress.isLoopbackAddress()) {
            if (inetAddress instanceof Inet4Address) {
                return ((Inet4Address) inetAddress).getHostAddress();
            }
            boolean z10 = inetAddress instanceof Inet6Address;
            return null;
        }
        return null;
    }

    private void initDeviceNotify(Context context) {
        this.filter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        this.filter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        this.filter.addAction("android.hardware.usb.action.USB_ACCESSORY_ATTACHED");
        this.filter.addAction("android.hardware.usb.action.USB_ACCESSORY_DETACHED");
        this.filter.addAction("android.hardware.usb.action.USB_STATE");
        context.registerReceiver(this.mUsbStateChangeReceiver, this.filter);
    }

    public static synchronized boolean initializeNativeLibs() {
        boolean z10;
        boolean z11;
        synchronized (RtcEngineImpl.class) {
            try {
                if (!sLibLoaded) {
                    loadNativeLibrary();
                    if (nativeClassInit() == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    sLibLoaded = z11;
                }
                z10 = sLibLoaded;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    private boolean joinChannelFirstTimeOrAllChannelLeft() {
        synchronized (this) {
            try {
                boolean z10 = false;
                if (this.mDefaultRtcChannel != null) {
                    return false;
                }
                Iterator<RtcChannelImpl> it = this.mRtcChannels.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().hasJoined()) {
                        }
                    } else {
                        z10 = true;
                        break;
                    }
                }
                return z10;
            } finally {
            }
        }
    }

    private static void loadLibrary(String str) {
        if (RtcEngine.externalLibPath != null) {
            System.load(String.format(RtcEngine.externalLibPath + File.separator + "lib%s.so", str));
            return;
        }
        System.loadLibrary(str);
    }

    public static synchronized void loadNativeLibrary() {
        synchronized (RtcEngineImpl.class) {
            loadLibrary("agora-core");
            loadLibrary("agora-ffmpeg");
            loadLibrary("agora-soundtouch");
            loadLibrary("agora-rtc-sdk");
            try {
                loadLibrary("agora_mpg123");
                Logging.i(TAG, "agora mpg123 module loaded.");
            } catch (Throwable unused) {
            }
            try {
                loadLibrary("agora_fd_extension");
                Logging.i(TAG, "libagora_fd_extension module loaded.");
            } catch (Throwable unused2) {
            }
            try {
                loadLibrary("agora_super_resolution_extension");
                Logging.i(TAG, "Agora super resolution module loaded.");
            } catch (Throwable unused3) {
                Logging.e(TAG, "Agora super resolution module load failed.");
            }
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    loadLibrary("agora-agb");
                    Logging.i(TAG, "agora agb module loaded.");
                } catch (Throwable unused4) {
                }
            }
            try {
                loadLibrary("agora_segmentation_extension");
                Logging.i(TAG, "Agora segmentation module loaded.");
            } catch (Throwable unused5) {
                Logging.e(TAG, "Agora segmentation module load failed.");
            }
            try {
                loadLibrary("agora_ci_extension");
                Logging.i(TAG, "Agora JH module loaded.");
            } catch (Throwable unused6) {
                Logging.e(TAG, "Agora JH module load failed.");
            }
            try {
                loadLibrary("agora_ai_denoise_extension");
                Logging.i(TAG, "AgoraAI Denoise module loaded.");
            } catch (Throwable unused7) {
            }
            try {
                loadLibrary("agora_spatial_audio_extension");
                Logging.i(TAG, "agora_spatial_audio_extension module loaded.");
            } catch (Throwable unused8) {
            }
            try {
                loadLibrary("agora_fdkaac");
                Logging.i(TAG, "AgoraFdkaac module loaded.");
            } catch (Throwable unused9) {
            }
            try {
                loadLibrary("agora_full_audio_format_extension");
                Logging.i(TAG, "agora_full_audio_format_extension module loaded");
            } catch (Throwable unused10) {
                Logging.e(TAG, "agora_full_audio_format_extension module load failed.");
            }
            try {
                loadLibrary("agora_jnd_extension");
                Logging.i(TAG, "libagora_jnd_extension module loaded.");
            } catch (Throwable unused11) {
            }
            try {
                loadLibrary("agora_dav1d_extension");
                Logging.i(TAG, "AgoraDav1d module loaded.");
            } catch (Throwable unused12) {
            }
            try {
                loadLibrary("agora_video_process_extension");
                Logging.i(TAG, "AgoraVideoProcess module loaded.");
            } catch (Throwable unused13) {
                Logging.e(TAG, "AgoraVideoProcess module load failed.");
            }
        }
    }

    private native int nativeAddInjectStreamUrl(long j10, String str, byte[] bArr);

    private native int nativeAddLocalVideoRender(long j10, IVideoSink iVideoSink, int i10);

    private native int nativeAddPublishStreamUrl(long j10, String str, boolean z10);

    private native int nativeAddRemoteVideoRender(long j10, int i10, IVideoSink iVideoSink, int i11);

    private native int nativeAddVideoCapturer(long j10, IVideoSource iVideoSource, int i10);

    private native int nativeAddVideoWatermark(long j10, String str, boolean z10, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17);

    private static native int nativeClassInit();

    private native int nativeClearVideoWatermarks(long j10);

    private native int nativeComplain(long j10, String str, String str2);

    private native int nativeCreateDataStream(long j10, boolean z10, boolean z11);

    private native int nativeCreateDataStream2(long j10, boolean z10, boolean z11);

    private native long nativeCreateRtcChannel(long j10, String str);

    private native int nativeDestroy(long j10);

    private static native int nativeDeviceChanged(long j10);

    private native int nativeDisableAudio(long j10);

    private native int nativeDisableVideo(long j10);

    private native int nativeEnableAudio(long j10);

    private native int nativeEnableContentInspect(long j10, boolean z10, byte[] bArr);

    private native int nativeEnableDeepLearningDenoise(long j10, boolean z10);

    private native int nativeEnableEncryption(long j10, boolean z10, int i10, String str, byte[] bArr);

    private native int nativeEnableLocalAudio(long j10, boolean z10);

    private native int nativeEnableRemoteSuperResolution(long j10, boolean z10, int i10, int i11);

    private native int nativeEnableRemoteSuperResolutionDepercated(long j10, int i10, boolean z10);

    private native int nativeEnableSoundPositionIndication(long j10, boolean z10);

    private native int nativeEnableSpatialAudio(long j10, boolean z10);

    private native int nativeEnableVideo(long j10);

    private native int nativeEnableVirtualBackground(long j10, boolean z10, Object obj);

    private native String nativeGetCallId(long j10);

    private native float nativeGetCameraMaxZoomFactor(long j10);

    public static native String nativeGetChatEngineVersion();

    private native int nativeGetConncetionState(long j10);

    private native long nativeGetDefaultRtcChannel(long j10);

    public static native String nativeGetErrorDescription(int i10);

    private native long nativeGetHandle(long j10);

    private native int nativeGetIntParameter(long j10, String str, String str2);

    private native int nativeGetMediaRecorder(long j10, Object obj);

    private static native byte[] nativeGetOptionsByVideoProfile(long j10, int i10);

    private native String nativeGetParameter(long j10, String str, String str2);

    private native String nativeGetParameters(long j10, String str);

    private native String nativeGetProfile(long j10);

    public static native String nativeGetSdkVersion();

    private native int nativeGetUserInfoByUid(long j10, int i10, Object obj);

    private native int nativeGetUserInfoByUserAccount(long j10, String str, Object obj);

    private native boolean nativeIsCameraAutoFocusFaceModeSupported(long j10);

    private native boolean nativeIsCameraExposurePositionSupported(long j10);

    private native boolean nativeIsCameraFocusSupported(long j10);

    private native boolean nativeIsCameraTorchSupported(long j10);

    private native boolean nativeIsCameraZoomSupported(long j10);

    private native boolean nativeIsSpeakerphoneEnabled(long j10);

    private native int nativeJoinChannel(long j10, byte[] bArr, String str, String str2, String str3, int i10, Object obj);

    private native int nativeJoinChannelWithUserAccount(long j10, String str, String str2, String str3, Object obj);

    private native int nativeLeaveChannel(long j10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int nativeLog(int i10, String str);

    private native String nativeMakeQualityReportUrl(long j10, String str, int i10, int i11, int i12);

    private native int nativeMuteAllRemoteVideoStreams(long j10, boolean z10);

    private native int nativeMuteLocalAudioStream(long j10, boolean z10);

    private native int nativeMuteLocalVideoStream(long j10, boolean z10);

    private native long nativeObjectInit(Object obj, String str, String str2, String str3, String str4, String str5, String str6, String str7);

    private native long nativeObjectInitWithConfig(Object obj);

    private native int nativePauseAllChannelMediaRelay(long j10);

    private native int nativePullAudioFrame(long j10, byte[] bArr, int i10, int i11);

    private native int nativePushExternalAudioFrameRawData(long j10, byte[] bArr, long j11, int i10, int i11);

    private native int nativePushExternalAudioFrameRawDataExt(long j10, byte[] bArr, long j11, int i10, int i11, int i12, int i13);

    private native int nativeRate(long j10, String str, int i10, String str2);

    private native int nativeRegisterAudioFrameObserver(long j10, Object obj);

    private native int nativeRegisterLocalUserAccount(long j10, String str, String str2);

    private native int nativeRegisterMediaMetadataObserver(long j10, Object obj, int i10);

    private native int nativeRegisterVideoEncodedFrameObserver(long j10, Object obj);

    private native int nativeRegisterVideoFrameObserver(long j10, Object obj);

    private native int nativeReleaseLogWriter(long j10);

    private native int nativeReleaseRecorder(long j10);

    private native int nativeRemoveInjectStreamUrl(long j10, String str);

    private native int nativeRemovePublishStreamUrl(long j10, String str);

    private native int nativeRemoveVideoReceiveTrack(long j10, int i10);

    private native int nativeRenewChannelKey(long j10, String str);

    private native int nativeRenewToken(long j10, String str);

    private native int nativeResumeAllChannelMediaRelay(long j10);

    private native int nativeRtcChannelRelease(long j10);

    private native int nativeSendCustomReportMessage(long j10, String str, String str2, String str3, String str4, int i10);

    private native int nativeSendStreamMessage(long j10, int i10, byte[] bArr);

    private native int nativeSetAVSyncSource(long j10, String str, int i10);

    private native int nativeSetApiCallMode(long j10, int i10);

    private native int nativeSetAppType(long j10, int i10);

    private native int nativeSetAudioProfile(long j10, int i10, int i11);

    private native int nativeSetBeautyEffectOptions(long j10, boolean z10, int i10, float f10, float f11, float f12, float f13);

    private native int nativeSetCameraAutoFocusFaceModeEnabled(long j10, boolean z10);

    private native int nativeSetCameraCaptureRotation(long j10, int i10);

    private native int nativeSetCameraExposurePosition(long j10, float f10, float f11);

    private native int nativeSetCameraFocusPositionInPreview(long j10, float f10, float f11);

    private native int nativeSetCameraTorchOn(long j10, boolean z10);

    private native int nativeSetCameraZoomFactor(long j10, float f10);

    private native int nativeSetChannelProfile(long j10, int i10);

    private native int nativeSetClientRole(long j10, int i10);

    private native int nativeSetClientRoleOptions(long j10, int i10, Object obj);

    private native int nativeSetCloudProxy(long j10, int i10);

    private native int nativeSetColorEnhanceOptions(long j10, boolean z10, float f10, float f11);

    private native int nativeSetDefaultAudioRoutetoSpeakerphone(long j10, boolean z10);

    private native int nativeSetEGL10Context(long j10, EGLContext eGLContext);

    private native int nativeSetEGL10TextureId(long j10, int i10, EGLContext eGLContext, int i11, int i12, int i13, long j11, float[] fArr);

    private native int nativeSetEGL14Context(long j10, android.opengl.EGLContext eGLContext);

    private native int nativeSetEGL14TextureId(long j10, int i10, android.opengl.EGLContext eGLContext, int i11, int i12, int i13, long j11, float[] fArr);

    private native int nativeSetEglBaseRootContext(long j10, EglBase.Context context);

    private native int nativeSetEnableSpeakerphone(long j10, boolean z10);

    private native int nativeSetEncryptionSecret(long j10, String str);

    private native int nativeSetExternalAudioSourceVolume(long j10, int i10, int i11);

    private native int nativeSetLiveTranscoding(long j10, byte[] bArr);

    private native int nativeSetLocalAccessPoint(long j10, ArrayList<String> arrayList, ArrayList<String> arrayList2, String str, int i10, Object obj);

    private native int nativeSetLocalVideoMirrorMode(long j10, int i10);

    private native int nativeSetLogWriter(long j10, Object obj);

    private native int nativeSetLowlightEnhanceOptions(long j10, boolean z10, int i10, int i11);

    private native int nativeSetParameters(long j10, String str);

    private native int nativeSetProfile(long j10, String str, boolean z10);

    private native int nativeSetRemoteRenderMode(long j10, int i10, int i11);

    private native int nativeSetRemoteRenderModeWithMirrorMode(long j10, int i10, int i11, int i12);

    private native int nativeSetRemoteUserPriority(long j10, int i10, int i11);

    private native int nativeSetRemoteUserSpatialAudioParams(long j10, int i10, Object obj);

    private native int nativeSetScreenCaptureContentHint(long j10, int i10);

    private native int nativeSetVideoDenoiserOptions(long j10, boolean z10, int i10, int i11);

    private native int nativeSetVideoEncoderConfiguration(long j10, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18);

    private native int nativeSetVideoProfileEx(long j10, int i10, int i11, int i12, int i13);

    private native int nativeSetupVideoLocal(long j10, Object obj, int i10, int i11);

    private native int nativeSetupVideoRemote(long j10, Object obj, int i10, String str, int i11, int i12);

    private native int nativeStartAudioRecording(long j10, String str, int i10, int i11, int i12, int i13);

    private native int nativeStartChannelMediaRelay(long j10, byte[] bArr);

    private native int nativeStartDumpVideoReceiveTrack(long j10, int i10, String str);

    private native int nativeStartEchoTest(long j10, byte[] bArr);

    private native int nativeStartEchoTestWithConfig(long j10, Object obj);

    private native int nativeStartEchoTestWithInterval(long j10, byte[] bArr, int i10);

    private native int nativeStartLastmileProbeTest(long j10, byte[] bArr, boolean z10, boolean z11, int i10, int i11);

    private native int nativeStartPreview(long j10);

    private native int nativeStartRecording(long j10, String str, int i10, int i11, int i12, int i13);

    private native int nativeStartRtmpStreamWithTranscoding(long j10, String str, byte[] bArr);

    private native int nativeStartRtmpStreamWithoutTranscoding(long j10, String str);

    private native int nativeStopAudioRecording(long j10);

    private native int nativeStopChannelMediaRelay(long j10);

    private native int nativeStopDumpVideoReceiveTrack(long j10);

    private native int nativeStopEchoTest(long j10);

    private native int nativeStopLastmileProbeTest(long j10);

    private native int nativeStopRecording(long j10);

    private native int nativeStopRtmpStream(long j10, String str);

    private native int nativeSwitchCamera(long j10);

    private native int nativeSwitchCameraByDirection(long j10, int i10);

    private native int nativeSwitchChannel(long j10, String str, String str2, Object obj);

    private native int nativeTakeSnapshot(long j10, String str, int i10, String str2);

    private native int nativeUpdateChannelMediaRelay(long j10, byte[] bArr);

    private native int nativeUpdateRtmpTranscoding(long j10, byte[] bArr);

    private native String nativeUploadLogFile(long j10);

    private void onApiCallExecuted(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PApiCallExecuted pApiCallExecuted = new RtcEngineMessage.PApiCallExecuted();
        pApiCallExecuted.unmarshall(bArr);
        iRtcEngineEventHandler.onApiCallExecuted(pApiCallExecuted.error, pApiCallExecuted.api, pApiCallExecuted.result);
    }

    private void onAudioPublishStateChanged(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PPublishAudioState pPublishAudioState = new RtcEngineMessage.PPublishAudioState();
        pPublishAudioState.unmarshall(bArr);
        iRtcEngineEventHandler.onAudioPublishStateChanged(pPublishAudioState.channel, pPublishAudioState.oldstate, pPublishAudioState.newstate, pPublishAudioState.elapsed);
    }

    private void onAudioSubscribeStateChanged(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PSubscribeAudioState pSubscribeAudioState = new RtcEngineMessage.PSubscribeAudioState();
        pSubscribeAudioState.unmarshall(bArr);
        iRtcEngineEventHandler.onAudioSubscribeStateChanged(pSubscribeAudioState.channel, pSubscribeAudioState.uid, pSubscribeAudioState.oldstate, pSubscribeAudioState.newstate, pSubscribeAudioState.elapsed);
    }

    private void onCameraExposureAreaChanged(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PCameraExposureAreaChanged pCameraExposureAreaChanged = new RtcEngineMessage.PCameraExposureAreaChanged();
        pCameraExposureAreaChanged.unmarshall(bArr);
        int i10 = pCameraExposureAreaChanged.f١٤٩٤٣x;
        int i11 = pCameraExposureAreaChanged.f١٤٩٤٤y;
        iRtcEngineEventHandler.onCameraExposureAreaChanged(new Rect(i10, i11, pCameraExposureAreaChanged.width + i10, pCameraExposureAreaChanged.height + i11));
    }

    private void onCameraFocusAreaChanged(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PCameraFocusAreaChanged pCameraFocusAreaChanged = new RtcEngineMessage.PCameraFocusAreaChanged();
        pCameraFocusAreaChanged.unmarshall(bArr);
        int i10 = pCameraFocusAreaChanged.f١٤٩٤٥x;
        int i11 = pCameraFocusAreaChanged.f١٤٩٤٦y;
        iRtcEngineEventHandler.onCameraFocusAreaChanged(new Rect(i10, i11, pCameraFocusAreaChanged.width + i10, pCameraFocusAreaChanged.height + i11));
    }

    private void onChannelMediaRelayEvent(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PCrossChannelEvent pCrossChannelEvent = new RtcEngineMessage.PCrossChannelEvent();
        pCrossChannelEvent.unmarshall(bArr);
        iRtcEngineEventHandler.onChannelMediaRelayEvent(pCrossChannelEvent.code);
    }

    private void onChannelMediaRelayStateChanged(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PCrossChannelState pCrossChannelState = new RtcEngineMessage.PCrossChannelState();
        pCrossChannelState.unmarshall(bArr);
        iRtcEngineEventHandler.onChannelMediaRelayStateChanged(pCrossChannelState.state, pCrossChannelState.code);
    }

    private void onContentInspectResult(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PContentInspectResult pContentInspectResult = new RtcEngineMessage.PContentInspectResult();
        pContentInspectResult.unmarshall(bArr);
        iRtcEngineEventHandler.onContentInspectResult(pContentInspectResult.result);
    }

    private void onFacePositionChanged(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        if (bArr == null) {
            return;
        }
        RtcEngineMessage.PFaceDetectValue pFaceDetectValue = new RtcEngineMessage.PFaceDetectValue();
        pFaceDetectValue.unmarshall(bArr);
        this.faceRectArr = null;
        RtcEngineMessage.PFaceDetectValue.FaceRect[] faceRectArr = pFaceDetectValue.rectArr;
        int i10 = 0;
        if (faceRectArr != null && faceRectArr.length > 0) {
            this.faceRectArr = new IRtcEngineEventHandler.AgoraFacePositionInfo[faceRectArr.length];
            while (true) {
                RtcEngineMessage.PFaceDetectValue.FaceRect[] faceRectArr2 = pFaceDetectValue.rectArr;
                if (i10 >= faceRectArr2.length) {
                    break;
                }
                RtcEngineMessage.PFaceDetectValue.FaceRect faceRect = faceRectArr2[i10];
                IRtcEngineEventHandler.AgoraFacePositionInfo agoraFacePositionInfo = new IRtcEngineEventHandler.AgoraFacePositionInfo();
                agoraFacePositionInfo.f١٤٩٤١x = faceRect.f١٤٩٤٧x;
                agoraFacePositionInfo.f١٤٩٤٢y = faceRect.f١٤٩٤٨y;
                agoraFacePositionInfo.width = faceRect.width;
                agoraFacePositionInfo.height = faceRect.height;
                agoraFacePositionInfo.distance = pFaceDetectValue.disArr[i10];
                this.faceRectArr[i10] = agoraFacePositionInfo;
                i10++;
            }
        } else {
            this.faceRectArr = new IRtcEngineEventHandler.AgoraFacePositionInfo[0];
        }
        iRtcEngineEventHandler.onFacePositionChanged(pFaceDetectValue.imageWidth, pFaceDetectValue.imageHeight, this.faceRectArr);
    }

    private void onFirstLocalAudioFrame(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PFirstLocalAudioFrame pFirstLocalAudioFrame = new RtcEngineMessage.PFirstLocalAudioFrame();
        pFirstLocalAudioFrame.unmarshall(bArr);
        iRtcEngineEventHandler.onFirstLocalAudioFrame(pFirstLocalAudioFrame.elapsed);
    }

    private void onFirstLocalAudioFramePublished(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PFirstLocalAudioFramePublished pFirstLocalAudioFramePublished = new RtcEngineMessage.PFirstLocalAudioFramePublished();
        pFirstLocalAudioFramePublished.unmarshall(bArr);
        iRtcEngineEventHandler.onFirstLocalAudioFramePublished(pFirstLocalAudioFramePublished.elapsed);
    }

    private void onFirstLocalVideoFrame(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PFirstLocalVideoFrame pFirstLocalVideoFrame = new RtcEngineMessage.PFirstLocalVideoFrame();
        pFirstLocalVideoFrame.unmarshall(bArr);
        iRtcEngineEventHandler.onFirstLocalVideoFrame(pFirstLocalVideoFrame.width, pFirstLocalVideoFrame.height, pFirstLocalVideoFrame.elapsed);
    }

    private void onFirstLocalVideoFramePublished(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PFirstLocalVideoFramePublished pFirstLocalVideoFramePublished = new RtcEngineMessage.PFirstLocalVideoFramePublished();
        pFirstLocalVideoFramePublished.unmarshall(bArr);
        iRtcEngineEventHandler.onFirstLocalVideoFramePublished(pFirstLocalVideoFramePublished.elapsed);
    }

    private void onFirstRemoteAudioFrame(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PFirstRemoteAudioFrame pFirstRemoteAudioFrame = new RtcEngineMessage.PFirstRemoteAudioFrame();
        pFirstRemoteAudioFrame.unmarshall(bArr);
        iRtcEngineEventHandler.onFirstRemoteAudioFrame(pFirstRemoteAudioFrame.uid, pFirstRemoteAudioFrame.elapsed);
    }

    private void onFirstRemoteVideoDecoded(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PFirstRemoteVideoDecoded pFirstRemoteVideoDecoded = new RtcEngineMessage.PFirstRemoteVideoDecoded();
        pFirstRemoteVideoDecoded.unmarshall(bArr);
        iRtcEngineEventHandler.onFirstRemoteVideoDecoded(pFirstRemoteVideoDecoded.uid, pFirstRemoteVideoDecoded.width, pFirstRemoteVideoDecoded.height, pFirstRemoteVideoDecoded.elapsed);
    }

    private void onFirstRemoteVideoFrame(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PFirstRemoteVideoFrame pFirstRemoteVideoFrame = new RtcEngineMessage.PFirstRemoteVideoFrame();
        pFirstRemoteVideoFrame.unmarshall(bArr);
        iRtcEngineEventHandler.onFirstRemoteVideoFrame(pFirstRemoteVideoFrame.uid, pFirstRemoteVideoFrame.width, pFirstRemoteVideoFrame.height, pFirstRemoteVideoFrame.elapsed);
    }

    private void onLocalAudioStat(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PLocalAudioStat pLocalAudioStat = new RtcEngineMessage.PLocalAudioStat();
        pLocalAudioStat.unmarshall(bArr);
        iRtcEngineEventHandler.onLocalAudioStats(pLocalAudioStat.stats);
    }

    private void onLocalVideoStat(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PLocalVideoStat pLocalVideoStat = new RtcEngineMessage.PLocalVideoStat();
        pLocalVideoStat.unmarshall(bArr);
        iRtcEngineEventHandler.onLocalVideoStats(pLocalVideoStat.stats);
    }

    private void onLocalVoicePitchInHz(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        if (bArr == null) {
            return;
        }
        RtcEngineMessage.PLocalVoicePitch pLocalVoicePitch = new RtcEngineMessage.PLocalVoicePitch();
        pLocalVoicePitch.unmarshall(bArr);
        iRtcEngineEventHandler.onLocalVoicePitchInHz(pLocalVoicePitch.pitchInHz);
    }

    private void onLogEvent(int i10, String str) {
    }

    private void onRemoteAudioStat(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PRemoteAudioStat pRemoteAudioStat = new RtcEngineMessage.PRemoteAudioStat();
        pRemoteAudioStat.unmarshall(bArr);
        IRtcEngineEventHandler.RemoteAudioStats remoteAudioStats = pRemoteAudioStat.stats;
        if (remoteAudioStats.uid == 0) {
            return;
        }
        iRtcEngineEventHandler.onRemoteAudioStats(remoteAudioStats);
    }

    private void onRemoteAudioStateChanged(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PRemoteAudioState pRemoteAudioState = new RtcEngineMessage.PRemoteAudioState();
        pRemoteAudioState.unmarshall(bArr);
        iRtcEngineEventHandler.onRemoteAudioStateChanged(pRemoteAudioState.uid, pRemoteAudioState.state, pRemoteAudioState.reason, pRemoteAudioState.elapsed);
    }

    private void onRemoteVideoStat(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PRemoteVideoStat pRemoteVideoStat = new RtcEngineMessage.PRemoteVideoStat();
        pRemoteVideoStat.unmarshall(bArr);
        IRtcEngineEventHandler.RemoteVideoStats remoteVideoStats = pRemoteVideoStat.stats;
        if (remoteVideoStats.uid == 0) {
            return;
        }
        iRtcEngineEventHandler.onRemoteVideoStats(remoteVideoStats);
    }

    private void onRemoteVideoStateChangedExt(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PRemoteVideoStateExt pRemoteVideoStateExt = new RtcEngineMessage.PRemoteVideoStateExt();
        pRemoteVideoStateExt.unmarshall(bArr);
        iRtcEngineEventHandler.onRemoteVideoStateChanged(pRemoteVideoStateExt.uid, pRemoteVideoStateExt.state, pRemoteVideoStateExt.reason, pRemoteVideoStateExt.elapsed);
    }

    private void onRequestAudioFileInfo(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PAudioFileInfo pAudioFileInfo = new RtcEngineMessage.PAudioFileInfo();
        pAudioFileInfo.unmarshall(bArr);
        IRtcEngineEventHandler.AudioFileInfo audioFileInfo = new IRtcEngineEventHandler.AudioFileInfo();
        audioFileInfo.filePath = pAudioFileInfo.filePath;
        audioFileInfo.durationMs = pAudioFileInfo.durationMs;
        iRtcEngineEventHandler.onRequestAudioFileInfo(audioFileInfo, pAudioFileInfo.error);
    }

    private void onRtcChannelAudioPublishStateChanged(byte[] bArr, IRtcChannelEventHandler iRtcChannelEventHandler, RtcChannelImpl rtcChannelImpl) {
        RtcEngineMessage.PPublishAudioState pPublishAudioState = new RtcEngineMessage.PPublishAudioState();
        pPublishAudioState.unmarshall(bArr);
        iRtcChannelEventHandler.onAudioPublishStateChanged(rtcChannelImpl, pPublishAudioState.oldstate, pPublishAudioState.newstate, pPublishAudioState.elapsed);
    }

    private void onRtcChannelAudioSubscribeStateChanged(byte[] bArr, IRtcChannelEventHandler iRtcChannelEventHandler, RtcChannelImpl rtcChannelImpl) {
        RtcEngineMessage.PSubscribeAudioState pSubscribeAudioState = new RtcEngineMessage.PSubscribeAudioState();
        pSubscribeAudioState.unmarshall(bArr);
        iRtcChannelEventHandler.onAudioSubscribeStateChanged(rtcChannelImpl, pSubscribeAudioState.uid, pSubscribeAudioState.oldstate, pSubscribeAudioState.newstate, pSubscribeAudioState.elapsed);
    }

    private void onRtcChannelChannelMediaRelayEvent(byte[] bArr, IRtcChannelEventHandler iRtcChannelEventHandler, RtcChannelImpl rtcChannelImpl) {
        RtcEngineMessage.PCrossChannelEvent pCrossChannelEvent = new RtcEngineMessage.PCrossChannelEvent();
        pCrossChannelEvent.unmarshall(bArr);
        iRtcChannelEventHandler.onChannelMediaRelayEvent(rtcChannelImpl, pCrossChannelEvent.code);
    }

    private void onRtcChannelChannelMediaRelayStateChanged(byte[] bArr, IRtcChannelEventHandler iRtcChannelEventHandler, RtcChannelImpl rtcChannelImpl) {
        RtcEngineMessage.PCrossChannelState pCrossChannelState = new RtcEngineMessage.PCrossChannelState();
        pCrossChannelState.unmarshall(bArr);
        iRtcChannelEventHandler.onChannelMediaRelayStateChanged(rtcChannelImpl, pCrossChannelState.state, pCrossChannelState.code);
    }

    private void onRtcChannelFirstRemoteVideoFrame(byte[] bArr, IRtcChannelEventHandler iRtcChannelEventHandler, RtcChannelImpl rtcChannelImpl) {
        RtcEngineMessage.PFirstRemoteVideoFrame pFirstRemoteVideoFrame = new RtcEngineMessage.PFirstRemoteVideoFrame();
        pFirstRemoteVideoFrame.unmarshall(bArr);
        iRtcChannelEventHandler.onFirstRemoteVideoFrame(rtcChannelImpl, pFirstRemoteVideoFrame.uid, pFirstRemoteVideoFrame.width, pFirstRemoteVideoFrame.height, pFirstRemoteVideoFrame.elapsed);
    }

    private void onRtcChannelRemoteAudioStat(byte[] bArr, IRtcChannelEventHandler iRtcChannelEventHandler, RtcChannelImpl rtcChannelImpl) {
        RtcEngineMessage.PRemoteAudioStat pRemoteAudioStat = new RtcEngineMessage.PRemoteAudioStat();
        pRemoteAudioStat.unmarshall(bArr);
        IRtcEngineEventHandler.RemoteAudioStats remoteAudioStats = pRemoteAudioStat.stats;
        if (remoteAudioStats.uid == 0) {
            return;
        }
        iRtcChannelEventHandler.onRemoteAudioStats(rtcChannelImpl, remoteAudioStats);
    }

    private void onRtcChannelRemoteAudioStateChanged(byte[] bArr, IRtcChannelEventHandler iRtcChannelEventHandler, RtcChannelImpl rtcChannelImpl) {
        RtcEngineMessage.PRemoteAudioState pRemoteAudioState = new RtcEngineMessage.PRemoteAudioState();
        pRemoteAudioState.unmarshall(bArr);
        iRtcChannelEventHandler.onRemoteAudioStateChanged(rtcChannelImpl, pRemoteAudioState.uid, pRemoteAudioState.state, pRemoteAudioState.reason, pRemoteAudioState.elapsed);
    }

    private void onRtcChannelRemoteVideoStat(byte[] bArr, IRtcChannelEventHandler iRtcChannelEventHandler, RtcChannelImpl rtcChannelImpl) {
        RtcEngineMessage.PRemoteVideoStat pRemoteVideoStat = new RtcEngineMessage.PRemoteVideoStat();
        pRemoteVideoStat.unmarshall(bArr);
        IRtcEngineEventHandler.RemoteVideoStats remoteVideoStats = pRemoteVideoStat.stats;
        if (remoteVideoStats.uid == 0) {
            return;
        }
        iRtcChannelEventHandler.onRemoteVideoStats(rtcChannelImpl, remoteVideoStats);
    }

    private void onRtcChannelRemoteVideoStateChangedExt(byte[] bArr, IRtcChannelEventHandler iRtcChannelEventHandler, RtcChannelImpl rtcChannelImpl) {
        RtcEngineMessage.PRemoteVideoStateExt pRemoteVideoStateExt = new RtcEngineMessage.PRemoteVideoStateExt();
        pRemoteVideoStateExt.unmarshall(bArr);
        iRtcChannelEventHandler.onRemoteVideoStateChanged(rtcChannelImpl, pRemoteVideoStateExt.uid, pRemoteVideoStateExt.state, pRemoteVideoStateExt.reason, pRemoteVideoStateExt.elapsed);
    }

    private void onRtcChannelStreamMessage(byte[] bArr, IRtcChannelEventHandler iRtcChannelEventHandler, RtcChannelImpl rtcChannelImpl) {
        RtcEngineMessage.PStreamMessage pStreamMessage = new RtcEngineMessage.PStreamMessage();
        pStreamMessage.unmarshall(bArr);
        iRtcChannelEventHandler.onStreamMessage(rtcChannelImpl, pStreamMessage.uid, pStreamMessage.streamId, pStreamMessage.payload);
    }

    private void onRtcChannelStreamMessageError(byte[] bArr, IRtcChannelEventHandler iRtcChannelEventHandler, RtcChannelImpl rtcChannelImpl) {
        RtcEngineMessage.PStreamMessageError pStreamMessageError = new RtcEngineMessage.PStreamMessageError();
        pStreamMessageError.unmarshall(bArr);
        iRtcChannelEventHandler.onStreamMessageError(rtcChannelImpl, pStreamMessageError.uid, pStreamMessageError.streamId, pStreamMessageError.error, pStreamMessageError.missed, pStreamMessageError.cached);
    }

    private void onRtcChannelUserSuperResolutionEnabledExt(byte[] bArr, IRtcChannelEventHandler iRtcChannelEventHandler, RtcChannelImpl rtcChannelImpl) {
        RtcEngineMessage.PUserSuperResolutionEnabled pUserSuperResolutionEnabled = new RtcEngineMessage.PUserSuperResolutionEnabled();
        pUserSuperResolutionEnabled.unmarshall(bArr);
        iRtcChannelEventHandler.onUserSuperResolutionEnabled(rtcChannelImpl, pUserSuperResolutionEnabled.uid, pUserSuperResolutionEnabled.enabled, pUserSuperResolutionEnabled.reason);
    }

    private void onRtcChannelVideoPublishStateChanged(byte[] bArr, IRtcChannelEventHandler iRtcChannelEventHandler, RtcChannelImpl rtcChannelImpl) {
        RtcEngineMessage.PPublishVideoState pPublishVideoState = new RtcEngineMessage.PPublishVideoState();
        pPublishVideoState.unmarshall(bArr);
        iRtcChannelEventHandler.onVideoPublishStateChanged(rtcChannelImpl, pPublishVideoState.oldstate, pPublishVideoState.newstate, pPublishVideoState.elapsed);
    }

    private void onRtcChannelVideoSizeChanged(byte[] bArr, IRtcChannelEventHandler iRtcChannelEventHandler, RtcChannelImpl rtcChannelImpl) {
        RtcEngineMessage.PVideoSizeChanged pVideoSizeChanged = new RtcEngineMessage.PVideoSizeChanged();
        pVideoSizeChanged.unmarshall(bArr);
        iRtcChannelEventHandler.onVideoSizeChanged(rtcChannelImpl, pVideoSizeChanged.uid, pVideoSizeChanged.width, pVideoSizeChanged.height, pVideoSizeChanged.rotation);
    }

    private void onRtcChannelVideoSubscribeStateChanged(byte[] bArr, IRtcChannelEventHandler iRtcChannelEventHandler, RtcChannelImpl rtcChannelImpl) {
        RtcEngineMessage.PSubscribeVideoState pSubscribeVideoState = new RtcEngineMessage.PSubscribeVideoState();
        pSubscribeVideoState.unmarshall(bArr);
        iRtcChannelEventHandler.onVideoSubscribeStateChanged(rtcChannelImpl, pSubscribeVideoState.uid, pSubscribeVideoState.oldstate, pSubscribeVideoState.newstate, pSubscribeVideoState.elapsed);
    }

    private void onSnapshotTaken(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PSnapshotTaken pSnapshotTaken = new RtcEngineMessage.PSnapshotTaken();
        pSnapshotTaken.unmarshall(bArr);
        iRtcEngineEventHandler.onSnapshotTaken(pSnapshotTaken.channel, pSnapshotTaken.uid, pSnapshotTaken.filepath, pSnapshotTaken.width, pSnapshotTaken.height, pSnapshotTaken.errCode);
    }

    private void onSpeakersReport(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        if (bArr == null) {
            return;
        }
        RtcEngineMessage.PMediaResSpeakersReport pMediaResSpeakersReport = new RtcEngineMessage.PMediaResSpeakersReport();
        pMediaResSpeakersReport.unmarshall(bArr);
        RtcEngineMessage.PMediaResSpeakersReport.Speaker[] speakerArr = pMediaResSpeakersReport.speakers;
        if (speakerArr != null && speakerArr.length >= 0) {
            IRtcEngineEventHandler.AudioVolumeInfo[] audioVolumeInfoArr = new IRtcEngineEventHandler.AudioVolumeInfo[speakerArr.length];
            for (int i10 = 0; i10 < pMediaResSpeakersReport.speakers.length; i10++) {
                IRtcEngineEventHandler.AudioVolumeInfo audioVolumeInfo = new IRtcEngineEventHandler.AudioVolumeInfo();
                audioVolumeInfoArr[i10] = audioVolumeInfo;
                RtcEngineMessage.PMediaResSpeakersReport.Speaker speaker = pMediaResSpeakersReport.speakers[i10];
                audioVolumeInfo.uid = speaker.uid;
                audioVolumeInfo.volume = speaker.volume;
                audioVolumeInfo.vad = speaker.vad;
                audioVolumeInfo.channelId = speaker.channelId;
            }
            iRtcEngineEventHandler.onAudioVolumeIndication(audioVolumeInfoArr, pMediaResSpeakersReport.mixVolume);
            return;
        }
        iRtcEngineEventHandler.onAudioVolumeIndication(new IRtcEngineEventHandler.AudioVolumeInfo[0], 0);
    }

    private void onStreamMessage(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PStreamMessage pStreamMessage = new RtcEngineMessage.PStreamMessage();
        pStreamMessage.unmarshall(bArr);
        iRtcEngineEventHandler.onStreamMessage(pStreamMessage.uid, pStreamMessage.streamId, pStreamMessage.payload);
    }

    private void onStreamMessageError(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PStreamMessageError pStreamMessageError = new RtcEngineMessage.PStreamMessageError();
        pStreamMessageError.unmarshall(bArr);
        iRtcEngineEventHandler.onStreamMessageError(pStreamMessageError.uid, pStreamMessageError.streamId, pStreamMessageError.error, pStreamMessageError.missed, pStreamMessageError.cached);
    }

    private void onUploadLogResult(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PUploadLogResult pUploadLogResult = new RtcEngineMessage.PUploadLogResult();
        pUploadLogResult.unmarshall(bArr);
        iRtcEngineEventHandler.onUploadLogResult(pUploadLogResult.requestId, pUploadLogResult.success, pUploadLogResult.reason);
    }

    private void onUserSuperResolutionEnabled(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PUserSuperResolutionEnabled pUserSuperResolutionEnabled = new RtcEngineMessage.PUserSuperResolutionEnabled();
        pUserSuperResolutionEnabled.unmarshall(bArr);
        iRtcEngineEventHandler.onUserSuperResolutionEnabled(pUserSuperResolutionEnabled.uid, pUserSuperResolutionEnabled.enabled, pUserSuperResolutionEnabled.reason);
    }

    private void onVideoPublishStateChanged(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PPublishVideoState pPublishVideoState = new RtcEngineMessage.PPublishVideoState();
        pPublishVideoState.unmarshall(bArr);
        iRtcEngineEventHandler.onVideoPublishStateChanged(pPublishVideoState.channel, pPublishVideoState.oldstate, pPublishVideoState.newstate, pPublishVideoState.elapsed);
    }

    private void onVideoSizeChanged(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PVideoSizeChanged pVideoSizeChanged = new RtcEngineMessage.PVideoSizeChanged();
        pVideoSizeChanged.unmarshall(bArr);
        iRtcEngineEventHandler.onVideoSizeChanged(pVideoSizeChanged.uid, pVideoSizeChanged.width, pVideoSizeChanged.height, pVideoSizeChanged.rotation);
    }

    private void onVideoSubscribeStateChanged(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PSubscribeVideoState pSubscribeVideoState = new RtcEngineMessage.PSubscribeVideoState();
        pSubscribeVideoState.unmarshall(bArr);
        iRtcEngineEventHandler.onVideoSubscribeStateChanged(pSubscribeVideoState.channel, pSubscribeVideoState.uid, pSubscribeVideoState.oldstate, pSubscribeVideoState.newstate, pSubscribeVideoState.elapsed);
    }

    private void onVirtualBackgroundSourceEnabled(byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        RtcEngineMessage.PVirtualBackgroundSourceEnabled pVirtualBackgroundSourceEnabled = new RtcEngineMessage.PVirtualBackgroundSourceEnabled();
        pVirtualBackgroundSourceEnabled.unmarshall(bArr);
        iRtcEngineEventHandler.onVirtualBackgroundSourceEnabled(pVirtualBackgroundSourceEnabled.enabled, pVirtualBackgroundSourceEnabled.reason);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh_device_list() {
        nativeDeviceChanged(this.mNativeHandle);
    }

    private void sendLogEvent(byte[] bArr) {
        try {
            onLogEvent(0, new String(bArr, "ISO-8859-1"));
        } catch (UnsupportedEncodingException unused) {
        }
    }

    private native int setExtVideoSource(long j10, int i10, int i11);

    private int setParameter(String str, boolean z10) {
        return setParameters(formatString("{\"%s\":%b}", str, Boolean.valueOf(z10)));
    }

    private int setParameterObject(String str, String str2) {
        return setParameters(formatString("{\"%s\":%s}", str, str2));
    }

    private int setRootContext(EglBase.Context context) {
        return nativeSetEglBaseRootContext(this.mNativeHandle, context);
    }

    private int setVideoRotateCapturedFrames(int i10, int i11) {
        return setParameterObject("che.video.local.rotate_video", formatString("{\"degree\":%d,\"rotation\":%d}", Integer.valueOf(i10), Integer.valueOf(i11)));
    }

    private void unRegisterBroadcstReceiver(Context context) {
        context.unregisterReceiver(this.mUsbStateChangeReceiver);
    }

    @Override // io.agora.rtc.RtcEngine
    public void addHandler(IRtcEngineEventHandler iRtcEngineEventHandler) {
        this.mRtcHandlers.put(iRtcEngineEventHandler, 0);
    }

    @Override // io.agora.rtc.RtcEngine
    public int addInjectStreamUrl(String str, LiveInjectStreamConfig liveInjectStreamConfig) {
        if (str != null && liveInjectStreamConfig != null) {
            return nativeAddInjectStreamUrl(this.mNativeHandle, str, new RtcEngineMessage.PInjectStreamConfig().marshall(liveInjectStreamConfig));
        }
        return -2;
    }

    @Override // io.agora.rtc.RtcEngine
    public int addPublishStreamUrl(String str, boolean z10) {
        return nativeAddPublishStreamUrl(this.mNativeHandle, str, z10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int addVideoWatermark(AgoraImage agoraImage) {
        String str;
        WatermarkOptions watermarkOptions;
        if (agoraImage != null) {
            str = agoraImage.url;
            watermarkOptions = new WatermarkOptions();
            watermarkOptions.visibleInPreview = false;
            WatermarkOptions.Rectangle rectangle = new WatermarkOptions.Rectangle(agoraImage.f١٤٩٥٢x, agoraImage.f١٤٩٥٣y, agoraImage.width, agoraImage.height);
            watermarkOptions.positionInLandscapeMode = rectangle;
            watermarkOptions.positionInPortraitMode = rectangle;
        } else {
            str = null;
            watermarkOptions = null;
        }
        return addVideoWatermark(str, watermarkOptions);
    }

    @Override // io.agora.rtc.RtcEngine
    public int adjustAudioMixingPlayoutVolume(int i10) {
        return setParameter("che.audio.set_file_as_playout_volume", i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int adjustAudioMixingPublishVolume(int i10) {
        return setParameter("che.audio.set_file_as_playout_publish_volume", i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int adjustAudioMixingVolume(int i10) {
        int adjustAudioMixingPlayoutVolume = adjustAudioMixingPlayoutVolume(i10);
        if (adjustAudioMixingPlayoutVolume == 0) {
            adjustAudioMixingPublishVolume(i10);
        }
        return adjustAudioMixingPlayoutVolume;
    }

    @Override // io.agora.rtc.RtcEngine
    public int adjustPlaybackSignalVolume(int i10) {
        if (i10 < 0) {
            i10 = 0;
        } else if (i10 > 400) {
            i10 = 400;
        }
        if (i10 < 100) {
            setParameter("che.audio.farend.compression", 100);
            return setParameter("che.audio.playout.signal.volume", i10);
        }
        setParameter("che.audio.playout.signal.volume", 100);
        return setParameter("che.audio.farend.compression", (((i10 - 100) / 3) * 7) + 100);
    }

    @Override // io.agora.rtc.RtcEngine
    public int adjustRecordingSignalVolume(int i10) {
        if (i10 < 0) {
            i10 = 0;
        } else if (i10 > 400) {
            i10 = 400;
        }
        return setParameter("che.audio.record.signal.volume", i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int adjustUserPlaybackSignalVolume(int i10, int i11) {
        return setParameters(formatString("{\"che.audio.playout.uid.volume\":{\"uid\":%d,\"volume\":%d}}", Long.valueOf(i10 & 4294967295L), Integer.valueOf(i11)));
    }

    @Override // io.agora.rtc.RtcEngine
    public int clearVideoWatermarks() {
        return nativeClearVideoWatermarks(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcEngine
    public int complain(String str, String str2) {
        return nativeComplain(this.mNativeHandle, str, str2);
    }

    @Override // io.agora.rtc.IAudioEffectManager
    public int configRhythmPlayer(AgoraRhythmPlayerConfig agoraRhythmPlayerConfig) {
        return setParameterObject("che.audio.config_rhythm", formatString("{\"beatsPerMeasure\":%d,\"beatsPerMinute\":%d,\"publish\":%d}", Integer.valueOf(agoraRhythmPlayerConfig.beatsPerMeasure), Integer.valueOf(agoraRhythmPlayerConfig.beatsPerMinute), Integer.valueOf(agoraRhythmPlayerConfig.publish ? 1 : 0)));
    }

    @Override // io.agora.rtc.RtcEngine
    public int createDataStream(boolean z10, boolean z11) {
        return nativeCreateDataStream(this.mNativeHandle, z10, z11);
    }

    @Override // io.agora.rtc.RtcEngine
    public RtcChannel createRtcChannel(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        synchronized (this) {
            try {
                RtcChannelImpl rtcChannelImpl = this.mDefaultRtcChannel;
                if (rtcChannelImpl != null && rtcChannelImpl.channelId().equals(str) && this.mDefaultRtcChannel.isInitialized()) {
                    return this.mDefaultRtcChannel;
                }
                Iterator<RtcChannelImpl> it = this.mRtcChannels.iterator();
                while (it.hasNext()) {
                    RtcChannelImpl next = it.next();
                    if (next.channelId() != null && next.channelId().equals(str) && next.isInitialized()) {
                        return next;
                    }
                }
                long nativeCreateRtcChannel = nativeCreateRtcChannel(this.mNativeHandle, str);
                if (nativeCreateRtcChannel == 0) {
                    return null;
                }
                RtcChannelImpl rtcChannelImpl2 = new RtcChannelImpl();
                rtcChannelImpl2.initialize(this, nativeCreateRtcChannel);
                this.mRtcChannels.add(rtcChannelImpl2);
                return rtcChannelImpl2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int destroyRtcChannel(String str) {
        if (str != null && str.length() > 0) {
            synchronized (this) {
                try {
                    RtcChannelImpl rtcChannelImpl = this.mDefaultRtcChannel;
                    if (rtcChannelImpl != null && rtcChannelImpl.channelId().equals(str)) {
                        return -5;
                    }
                    Iterator<RtcChannelImpl> it = this.mRtcChannels.iterator();
                    while (it.hasNext()) {
                        RtcChannelImpl next = it.next();
                        if (next.channelId() != null && next.channelId().equals(str)) {
                            int nativeRtcChannelRelease = nativeRtcChannelRelease(next.getNativeHandle());
                            this.mRtcChannels.remove(next);
                            return nativeRtcChannelRelease;
                        }
                    }
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return -102;
    }

    @Override // io.agora.rtc.RtcEngine
    public int disableAudio() {
        return nativeDisableAudio(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcEngine
    public int disableLastmileTest() {
        return setParameter("rtc.lastmile_test", false);
    }

    @Override // io.agora.rtc.RtcEngine
    public int disableVideo() {
        this.mLocalVideoEnabled = false;
        return nativeDisableVideo(this.mNativeHandle);
    }

    public void doDestroy() {
        try {
            Context context = this.mContext.get();
            if (context != null) {
                unRegisterBroadcstReceiver(context);
            }
        } catch (Exception e10) {
            Logging.e(e10.getMessage());
        }
        setExternalVideoSource(false, false, true);
        doStopMonitorSystemEvent();
        synchronized (this) {
            try {
                RtcChannelImpl rtcChannelImpl = this.mDefaultRtcChannel;
                if (rtcChannelImpl != null) {
                    rtcChannelImpl.onEngineDestroy();
                }
                Iterator<RtcChannelImpl> it = this.mRtcChannels.iterator();
                while (it.hasNext()) {
                    it.next().onEngineDestroy();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        stopScreenCapture();
        nativeDestroy(this.mNativeHandle);
        this.mNativeHandle = 0L;
    }

    @Override // io.agora.rtc.RtcEngine
    public int enableAudio() {
        return nativeEnableAudio(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcEngine
    @Deprecated
    public int enableAudioQualityIndication(boolean z10) {
        return setParameter("rtc.audio_quality_indication", z10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int enableAudioVolumeIndication(int i10, int i11, boolean z10) {
        if (i10 < 0) {
            i10 = 0;
        }
        if (z10) {
            return setParameterObject("che.audio.volume_indication", formatString("{\"interval\":%d,\"smooth\":%d,\"vad\":%d}", Integer.valueOf(i10), Integer.valueOf(i11), 1));
        }
        return setParameterObject("che.audio.volume_indication", formatString("{\"interval\":%d,\"smooth\":%d,\"vad\":%d}", Integer.valueOf(i10), Integer.valueOf(i11), 0));
    }

    @Override // io.agora.rtc.RtcEngine
    public int enableContentInspect(boolean z10, ContentInspectConfig contentInspectConfig) {
        byte[] bArr;
        if (z10) {
            if (contentInspectConfig == null) {
                return -2;
            }
            bArr = new RtcEngineMessage.PContentInspectConfig().marshall(contentInspectConfig);
        } else {
            bArr = null;
        }
        return nativeEnableContentInspect(this.mNativeHandle, z10, bArr);
    }

    @Override // io.agora.rtc.RtcEngine
    public int enableDeepLearningDenoise(boolean z10) {
        return nativeEnableDeepLearningDenoise(this.mNativeHandle, z10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int enableDualStreamMode(boolean z10) {
        return setParameters(String.format("{\"rtc.dual_stream_mode\":%b,\"che.video.enableLowBitRateStream\":%d}", Boolean.valueOf(z10), Integer.valueOf(z10 ? 1 : 0)));
    }

    @Override // io.agora.rtc.RtcEngine
    public int enableEncryption(boolean z10, EncryptionConfig encryptionConfig) {
        return nativeEnableEncryption(this.mNativeHandle, z10, encryptionConfig.encryptionMode.getValue(), encryptionConfig.encryptionKey, encryptionConfig.encryptionKdfSalt);
    }

    @Override // io.agora.rtc.RtcEngine
    public int enableFaceDetection(boolean z10) {
        return setParameter("che.video.faceDistance", z10);
    }

    @Override // io.agora.rtc.RtcEngine
    public boolean enableHighPerfWifiMode(boolean z10) {
        Context context = this.mContext.get();
        if (context == null) {
            return false;
        }
        if (z10) {
            if (context.checkPermission("android.permission.WAKE_LOCK", Process.myPid(), Process.myUid()) != 0) {
                this.mWifiLock = null;
                return false;
            }
            if (this.mWifiLock == null) {
                this.mWifiLock = ((WifiManager) context.getSystemService("wifi")).createWifiLock(3, "agora.voip.lock");
                return true;
            }
            return true;
        }
        this.mWifiLock = null;
        return true;
    }

    @Override // io.agora.rtc.RtcEngine
    public int enableInEarMonitoring(boolean z10) {
        return setParameter("che.audio.headset.monitoring", z10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int enableLastmileTest() {
        return setParameter("rtc.lastmile_test", true);
    }

    @Override // io.agora.rtc.RtcEngine
    public int enableLocalAudio(boolean z10) {
        return nativeEnableLocalAudio(this.mNativeHandle, z10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int enableLocalVideo(boolean z10) {
        this.mLocalVideoEnabled = z10;
        return setParameters(String.format("{\"rtc.video.capture\":%b,\"che.video.local.capture\":%b,\"che.video.local.render\":%b,\"che.video.local.send\":%b}", Boolean.valueOf(z10), Boolean.valueOf(z10), Boolean.valueOf(z10), Boolean.valueOf(z10)));
    }

    @Override // io.agora.rtc.RtcEngine
    public int enableLocalVoicePitchCallback(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        return setParameterObject("che.audio.local_pitch_callback", formatString("{\"interval\":%d}", Integer.valueOf(i10)));
    }

    @Override // io.agora.rtc.RtcEngineEx
    public int enableRecap(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        return setParameter("che.audio.recap.interval", i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int enableRemoteSuperResolution(int i10, boolean z10) {
        return nativeEnableRemoteSuperResolutionDepercated(this.mNativeHandle, i10, z10);
    }

    public int enableRemoteVideo(boolean z10, int i10) {
        return setParameterObject("che.video.peer.receive", formatString("{\"enable\":%b, \"uid\":%d}", Boolean.valueOf(z10), Long.valueOf(i10 & 4294967295L)));
    }

    @Override // io.agora.rtc.RtcEngine
    public int enableSoundPositionIndication(boolean z10) {
        return nativeEnableSoundPositionIndication(this.mNativeHandle, z10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int enableSpatialAudio(boolean z10) {
        return nativeEnableSpatialAudio(this.mNativeHandle, z10);
    }

    @Override // io.agora.rtc.RtcEngineEx
    public int enableTransportQualityIndication(boolean z10) {
        return setParameter("rtc.transport_quality_indication", z10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int enableVideo() {
        this.mLocalVideoEnabled = true;
        return nativeEnableVideo(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcEngine
    public int enableVirtualBackground(boolean z10, VirtualBackgroundSource virtualBackgroundSource) {
        if (virtualBackgroundSource == null) {
            if (z10) {
                return -2;
            }
            virtualBackgroundSource = new VirtualBackgroundSource();
        }
        return nativeEnableVirtualBackground(this.mNativeHandle, z10, virtualBackgroundSource);
    }

    @Override // io.agora.rtc.RtcEngine
    public int enableWebSdkInteroperability(boolean z10) {
        return setParameters(String.format("{\"rtc.video.web_h264_interop_enable\":%b,\"che.video.web_h264_interop_enable\":%b}", Boolean.valueOf(z10), Boolean.valueOf(z10)));
    }

    @Override // io.agora.rtc.RtcEngine
    public int enableWirelessAccelerate(boolean z10) {
        String str;
        if (z10) {
            str = "true";
        } else {
            str = RequestConstant.FALSE;
        }
        return setParameters(formatString("{\"rtc.video.wifi_acc_enable\":%s}", str));
    }

    public void finalize() {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            nativeDestroy(j10);
        }
    }

    protected ActivityManager getActivityManager(Context context) {
        if (context == null) {
            return null;
        }
        return (ActivityManager) context.getSystemService("activity");
    }

    @Override // io.agora.rtc.RtcEngine
    public int getAudioDeviceLatency(int i10) {
        return nativeGetIntParameter(this.mNativeHandle, "che.audio.get_audio_device_latency", Integer.toString(i10));
    }

    @Override // io.agora.rtc.RtcEngine
    public IAudioEffectManager getAudioEffectManager() {
        return this;
    }

    @Override // io.agora.rtc.RtcEngine
    public int getAudioFileInfo(String str) {
        return setParameterObject("che.audio.get_file_info", formatString("{\"url\":\"%s\"}", str));
    }

    protected AudioManager getAudioManager(Context context) {
        if (context == null) {
            return null;
        }
        return (AudioManager) context.getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
    }

    @Override // io.agora.rtc.RtcEngine
    public int getAudioMixingCurrentPosition() {
        return nativeGetIntParameter(this.mNativeHandle, "che.audio.get_mixing_file_played_ms", null);
    }

    @Override // io.agora.rtc.RtcEngine
    @Deprecated
    public int getAudioMixingDuration() {
        return nativeGetIntParameter(this.mNativeHandle, "che.audio.get_mixing_file_length_ms", null);
    }

    @Override // io.agora.rtc.RtcEngine
    public int getAudioMixingPlayoutVolume() {
        return nativeGetIntParameter(this.mNativeHandle, "che.audio.get_file_as_playout_volume", null);
    }

    @Override // io.agora.rtc.RtcEngine
    public int getAudioMixingPublishVolume() {
        return nativeGetIntParameter(this.mNativeHandle, "che.audio.get_file_as_playout_publish_volume", null);
    }

    @Override // io.agora.rtc.RtcEngine
    public int getAudioTrackCount() {
        return nativeGetIntParameter(this.mNativeHandle, "che.audio.get_audio_track_count", null);
    }

    @Override // io.agora.rtc.RtcEngine
    public String getCallId() {
        return nativeGetCallId(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcEngine
    public float getCameraMaxZoomFactor() {
        return nativeGetCameraMaxZoomFactor(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcEngine
    public int getConnectionState() {
        return nativeGetConncetionState(this.mNativeHandle);
    }

    public Context getContext() {
        return this.mContext.get();
    }

    @Override // io.agora.rtc.IAudioEffectManager
    public int getEffectCurrentPosition(int i10) {
        int nativeGetIntParameter = nativeGetIntParameter(this.mNativeHandle, "che.audio.get_effect_file_position", formatString("%d", Integer.valueOf(i10)));
        if (nativeGetIntParameter < 0) {
            return 0;
        }
        return nativeGetIntParameter;
    }

    @Override // io.agora.rtc.IAudioEffectManager
    public int getEffectDuration(String str) {
        int nativeGetIntParameter = nativeGetIntParameter(this.mNativeHandle, "che.audio.get_effect_file_duration", formatString("%s", str));
        if (nativeGetIntParameter < 0) {
            return 0;
        }
        return nativeGetIntParameter;
    }

    @Override // io.agora.rtc.IAudioEffectManager
    public double getEffectsVolume() {
        return getEffectsPlayoutVolume();
    }

    public int getMediaRecorder(AgoraMediaRecorder.IMediaRecorderCallback iMediaRecorderCallback) {
        return nativeGetMediaRecorder(this.mNativeHandle, iMediaRecorderCallback);
    }

    @Override // io.agora.rtc.RtcEngine
    public long getNativeHandle() {
        return nativeGetHandle(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcEngine
    public String getParameter(String str, String str2) {
        return nativeGetParameter(this.mNativeHandle, str, str2);
    }

    @Override // io.agora.rtc.RtcEngineEx
    public String getParameters(String str) {
        return nativeGetParameters(this.mNativeHandle, str);
    }

    public String getProfile() {
        return nativeGetProfile(this.mNativeHandle);
    }

    public IRtcEngineEventHandler.RtcStats getRtcStats() {
        if (this.mRtcStats == null) {
            this.mRtcStats = new IRtcEngineEventHandler.RtcStats();
        }
        return this.mRtcStats;
    }

    @Override // io.agora.rtc.RtcEngine
    public int getUserInfoByUid(int i10, UserInfo userInfo) {
        return nativeGetUserInfoByUid(this.mNativeHandle, i10, userInfo);
    }

    @Override // io.agora.rtc.RtcEngine
    public int getUserInfoByUserAccount(String str, UserInfo userInfo) {
        return nativeGetUserInfoByUserAccount(this.mNativeHandle, str, userInfo);
    }

    protected void handleChannelEvent(int i10, byte[] bArr, IRtcChannelEventHandler iRtcChannelEventHandler, RtcChannelImpl rtcChannelImpl) {
        if (iRtcChannelEventHandler != null && rtcChannelImpl != null) {
            switch (i10) {
                case 101:
                    RtcEngineMessage.PError pError = new RtcEngineMessage.PError();
                    pError.unmarshall(bArr);
                    iRtcChannelEventHandler.onChannelError(rtcChannelImpl, pError.err);
                    return;
                case 102:
                    RtcEngineMessage.PError pError2 = new RtcEngineMessage.PError();
                    pError2.unmarshall(bArr);
                    iRtcChannelEventHandler.onChannelWarning(rtcChannelImpl, pError2.err);
                    return;
                case RtcEngineEvent.EvtType.EVT_REQUEST_TOKEN /* 1108 */:
                    iRtcChannelEventHandler.onRequestToken(rtcChannelImpl);
                    return;
                case RtcEngineEvent.EvtType.EVT_CLIENT_ROLE_CHANGED /* 1109 */:
                    RtcEngineMessage.PClientRoleChanged pClientRoleChanged = new RtcEngineMessage.PClientRoleChanged();
                    pClientRoleChanged.unmarshall(bArr);
                    iRtcChannelEventHandler.onClientRoleChanged(rtcChannelImpl, pClientRoleChanged.oldRole, pClientRoleChanged.newRole);
                    return;
                case RtcEngineEvent.EvtType.EVT_LIVE_TRANSCODING /* 1112 */:
                    iRtcChannelEventHandler.onTranscodingUpdated(rtcChannelImpl);
                    return;
                case RtcEngineEvent.EvtType.EVT_STREAM_INJECTED_STATUS /* 1116 */:
                    RtcEngineMessage.PStreamInjectedStatus pStreamInjectedStatus = new RtcEngineMessage.PStreamInjectedStatus();
                    pStreamInjectedStatus.unmarshall(bArr);
                    iRtcChannelEventHandler.onStreamInjectedStatus(rtcChannelImpl, pStreamInjectedStatus.url, pStreamInjectedStatus.uid, pStreamInjectedStatus.status);
                    return;
                case RtcEngineEvent.EvtType.EVT_PRIVILEGE_WILL_EXPIRE /* 1117 */:
                    RtcEngineMessage.PPrivilegeWillExpire pPrivilegeWillExpire = new RtcEngineMessage.PPrivilegeWillExpire();
                    pPrivilegeWillExpire.unmarshall(bArr);
                    iRtcChannelEventHandler.onTokenPrivilegeWillExpire(rtcChannelImpl, pPrivilegeWillExpire.token);
                    return;
                case RtcEngineEvent.EvtType.EVT_RTMP_STREAMING_STATE /* 1119 */:
                    RtcEngineMessage.PRtmpStreamingState pRtmpStreamingState = new RtcEngineMessage.PRtmpStreamingState();
                    pRtmpStreamingState.unmarshall(bArr);
                    iRtcChannelEventHandler.onRtmpStreamingStateChanged(rtcChannelImpl, pRtmpStreamingState.url, pRtmpStreamingState.state, pRtmpStreamingState.error);
                    return;
                case RtcEngineEvent.EvtType.EVT_STREAM_EVENT /* 1120 */:
                    RtcEngineMessage.PStreamEvent pStreamEvent = new RtcEngineMessage.PStreamEvent();
                    pStreamEvent.unmarshall(bArr);
                    iRtcChannelEventHandler.onRtmpStreamingEvent(rtcChannelImpl, pStreamEvent.url, pStreamEvent.error);
                    return;
                case RtcEngineEvent.EvtType.EVT_OPEN_CHANNEL_SUCCESS /* 13001 */:
                    RtcEngineMessage.PMediaResJoinMedia pMediaResJoinMedia = new RtcEngineMessage.PMediaResJoinMedia();
                    pMediaResJoinMedia.unmarshall(bArr);
                    if (pMediaResJoinMedia.firstSuccess) {
                        iRtcChannelEventHandler.onJoinChannelSuccess(rtcChannelImpl, pMediaResJoinMedia.uid, pMediaResJoinMedia.elapsed);
                        return;
                    } else {
                        iRtcChannelEventHandler.onRejoinChannelSuccess(rtcChannelImpl, pMediaResJoinMedia.uid, pMediaResJoinMedia.elapsed);
                        return;
                    }
                case RtcEngineEvent.EvtType.EVT_LEAVE_CHANNEL /* 13006 */:
                    Context context = this.mContext.get();
                    if (context != null) {
                        getAudioManager(context).setMode(0);
                    }
                    RtcEngineMessage.PMediaResRtcStats pMediaResRtcStats = new RtcEngineMessage.PMediaResRtcStats();
                    pMediaResRtcStats.unmarshall(bArr);
                    updateRtcStats(pMediaResRtcStats);
                    iRtcChannelEventHandler.onLeaveChannel(rtcChannelImpl, getRtcStats());
                    return;
                case RtcEngineEvent.EvtType.EVT_NETWORK_QUALITY /* 13007 */:
                    RtcEngineMessage.PMediaResNetworkQuality pMediaResNetworkQuality = new RtcEngineMessage.PMediaResNetworkQuality();
                    pMediaResNetworkQuality.unmarshall(bArr);
                    iRtcChannelEventHandler.onNetworkQuality(rtcChannelImpl, pMediaResNetworkQuality.uid, pMediaResNetworkQuality.txQuality, pMediaResNetworkQuality.rxQuality);
                    return;
                case RtcEngineEvent.EvtType.EVT_USER_OFFLINE /* 13008 */:
                    RtcEngineMessage.PMediaResUserOfflineEvent pMediaResUserOfflineEvent = new RtcEngineMessage.PMediaResUserOfflineEvent();
                    pMediaResUserOfflineEvent.unmarshall(bArr);
                    iRtcChannelEventHandler.onUserOffline(rtcChannelImpl, pMediaResUserOfflineEvent.uid, pMediaResUserOfflineEvent.reason);
                    return;
                case RtcEngineEvent.EvtType.EVT_RTC_STATS /* 13010 */:
                    RtcEngineMessage.PMediaResRtcStats pMediaResRtcStats2 = new RtcEngineMessage.PMediaResRtcStats();
                    pMediaResRtcStats2.unmarshall(bArr);
                    updateRtcStats(pMediaResRtcStats2);
                    iRtcChannelEventHandler.onRtcStats(rtcChannelImpl, getRtcStats());
                    return;
                case RtcEngineEvent.EvtType.EVT_USER_JOINED /* 13013 */:
                    RtcEngineMessage.PMediaResUserJoinedEvent pMediaResUserJoinedEvent = new RtcEngineMessage.PMediaResUserJoinedEvent();
                    pMediaResUserJoinedEvent.unmarshall(bArr);
                    iRtcChannelEventHandler.onUserJoined(rtcChannelImpl, pMediaResUserJoinedEvent.uid, pMediaResUserJoinedEvent.elapsed);
                    return;
                case RtcEngineEvent.EvtType.EVT_FIRST_REMOTE_VIDEO_FRAME /* 14002 */:
                    onRtcChannelFirstRemoteVideoFrame(bArr, iRtcChannelEventHandler, rtcChannelImpl);
                    return;
                case RtcEngineEvent.EvtType.EVT_REMOTE_VIDEO_STAT /* 14004 */:
                    onRtcChannelRemoteVideoStat(bArr, iRtcChannelEventHandler, rtcChannelImpl);
                    return;
                case RtcEngineEvent.EvtType.EVT_CONNECTION_LOST /* 14008 */:
                    iRtcChannelEventHandler.onConnectionLost(rtcChannelImpl);
                    return;
                case RtcEngineEvent.EvtType.EVT_STREAM_MESSAGE /* 14009 */:
                    onRtcChannelStreamMessage(bArr, iRtcChannelEventHandler, rtcChannelImpl);
                    return;
                case RtcEngineEvent.EvtType.EVT_STREAM_MESSAGE_ERROR /* 14012 */:
                    onRtcChannelStreamMessageError(bArr, iRtcChannelEventHandler, rtcChannelImpl);
                    return;
                case RtcEngineEvent.EvtType.EVT_VIDEO_SIZE_CHANGED /* 14013 */:
                    onRtcChannelVideoSizeChanged(bArr, iRtcChannelEventHandler, rtcChannelImpl);
                    return;
                case RtcEngineEvent.EvtType.EVT_ACTIVE_SPEAKER /* 14016 */:
                    RtcEngineMessage.PActiveSpeaker pActiveSpeaker = new RtcEngineMessage.PActiveSpeaker();
                    pActiveSpeaker.unmarshall(bArr);
                    iRtcChannelEventHandler.onActiveSpeaker(rtcChannelImpl, pActiveSpeaker.uid);
                    return;
                case RtcEngineEvent.EvtType.EVT_LOCAL_PUBLISH_FALLBACK_TO_AUDIO_ONLY /* 14022 */:
                    RtcEngineMessage.PLocalFallbackStatus pLocalFallbackStatus = new RtcEngineMessage.PLocalFallbackStatus();
                    pLocalFallbackStatus.unmarshall(bArr);
                    iRtcChannelEventHandler.onLocalPublishFallbackToAudioOnly(rtcChannelImpl, pLocalFallbackStatus.state);
                    return;
                case RtcEngineEvent.EvtType.EVT_REMOTE_SUBSCRIBE_FALLBACK_TO_AUDIO_ONLY /* 14023 */:
                    RtcEngineMessage.PMediaResUserState pMediaResUserState = new RtcEngineMessage.PMediaResUserState();
                    pMediaResUserState.unmarshall(bArr);
                    iRtcChannelEventHandler.onRemoteSubscribeFallbackToAudioOnly(rtcChannelImpl, pMediaResUserState.uid, pMediaResUserState.state);
                    return;
                case RtcEngineEvent.EvtType.EVT_CONNECTION_STATE_CHANGED /* 14028 */:
                    RtcEngineMessage.PConnectionState pConnectionState = new RtcEngineMessage.PConnectionState();
                    pConnectionState.unmarshall(bArr);
                    iRtcChannelEventHandler.onConnectionStateChanged(rtcChannelImpl, pConnectionState.state, pConnectionState.reason);
                    return;
                case RtcEngineEvent.EvtType.EVT_REMOTE_AUDIO_STAT /* 14030 */:
                    onRtcChannelRemoteAudioStat(bArr, iRtcChannelEventHandler, rtcChannelImpl);
                    return;
                case RtcEngineEvent.EvtType.EVT_REMOTE_VIDEO_STATE_CHANGED_EXT /* 14036 */:
                    onRtcChannelRemoteVideoStateChangedExt(bArr, iRtcChannelEventHandler, rtcChannelImpl);
                    return;
                case RtcEngineEvent.EvtType.EVT_CROSS_CHANNEL_STATE /* 14037 */:
                    onRtcChannelChannelMediaRelayStateChanged(bArr, iRtcChannelEventHandler, rtcChannelImpl);
                    return;
                case RtcEngineEvent.EvtType.EVT_CROSS_CHANNEL_EVENT /* 14038 */:
                    onRtcChannelChannelMediaRelayEvent(bArr, iRtcChannelEventHandler, rtcChannelImpl);
                    return;
                case RtcEngineEvent.EvtType.EVT_REMOTE_AUDIO_STATE_CHANGED /* 14040 */:
                    onRtcChannelRemoteAudioStateChanged(bArr, iRtcChannelEventHandler, rtcChannelImpl);
                    return;
                case RtcEngineEvent.EvtType.EVT_PUBLISH_AUDIO_STATE_CHANGED /* 14045 */:
                    onRtcChannelAudioPublishStateChanged(bArr, iRtcChannelEventHandler, rtcChannelImpl);
                    return;
                case RtcEngineEvent.EvtType.EVT_PUBLISH_VIDEO_STATE_CHANGED /* 14046 */:
                    onRtcChannelVideoPublishStateChanged(bArr, iRtcChannelEventHandler, rtcChannelImpl);
                    return;
                case RtcEngineEvent.EvtType.EVT_SUBSCRIBE_AUDIO_STATE_CHANGED /* 14047 */:
                    onRtcChannelAudioSubscribeStateChanged(bArr, iRtcChannelEventHandler, rtcChannelImpl);
                    return;
                case RtcEngineEvent.EvtType.EVT_SUBSCRIBE_VIDEO_STATE_CHANGED /* 14048 */:
                    onRtcChannelVideoSubscribeStateChanged(bArr, iRtcChannelEventHandler, rtcChannelImpl);
                    return;
                case RtcEngineEvent.EvtType.EVT_USER_SUPER_RESOLUTION_ENABLED /* 14049 */:
                    onRtcChannelUserSuperResolutionEnabledExt(bArr, iRtcChannelEventHandler, rtcChannelImpl);
                    return;
                case RtcEngineEvent.EvtType.EVT_PROXY_CONNECTED /* 14055 */:
                    RtcEngineMessage.PProxyConnect pProxyConnect = new RtcEngineMessage.PProxyConnect();
                    pProxyConnect.unmarshall(bArr);
                    iRtcChannelEventHandler.onProxyConnected(rtcChannelImpl, pProxyConnect.uid, pProxyConnect.proxyType, pProxyConnect.localProxyIp, pProxyConnect.elapsed);
                    return;
                case RtcEngineEvent.EvtType.EVT_CLIENT_ROLE_CHANGE_FAILED /* 14057 */:
                    RtcEngineMessage.PClientRoleChangeFailed pClientRoleChangeFailed = new RtcEngineMessage.PClientRoleChangeFailed();
                    pClientRoleChangeFailed.unmarshall(bArr);
                    iRtcChannelEventHandler.onClientRoleChangeFailed(rtcChannelImpl, pClientRoleChangeFailed.reason, pClientRoleChangeFailed.currentRole);
                    return;
                default:
                    return;
            }
        }
    }

    protected void handleEvent(int i10, byte[] bArr, IRtcEngineEventHandler iRtcEngineEventHandler) {
        if (iRtcEngineEventHandler == null) {
            return;
        }
        if (i10 != 1101) {
            if (i10 != 1102) {
                switch (i10) {
                    case 100:
                        sendLogEvent(bArr);
                        return;
                    case 101:
                        RtcEngineMessage.PError pError = new RtcEngineMessage.PError();
                        pError.unmarshall(bArr);
                        iRtcEngineEventHandler.onError(pError.err);
                        return;
                    case 102:
                        RtcEngineMessage.PError pError2 = new RtcEngineMessage.PError();
                        pError2.unmarshall(bArr);
                        iRtcEngineEventHandler.onWarning(pError2.err);
                        return;
                    default:
                        switch (i10) {
                            case 1002:
                                break;
                            case RtcEngineEvent.EvtType.EVT_MEDIA_ENGINE_EVENT /* 1104 */:
                                RtcEngineMessage.PMediaEngineEvent pMediaEngineEvent = new RtcEngineMessage.PMediaEngineEvent();
                                pMediaEngineEvent.unmarshall(bArr);
                                int i11 = pMediaEngineEvent.code;
                                if (i11 != 10) {
                                    if (i11 != 14) {
                                        if (i11 == 15) {
                                            iRtcEngineEventHandler.onMicrophoneEnabled(false);
                                            return;
                                        }
                                        switch (i11) {
                                            case 20:
                                            case 21:
                                            case 22:
                                            case 23:
                                                return;
                                            default:
                                                switch (i11) {
                                                    case 701:
                                                    case 702:
                                                    case 703:
                                                        iRtcEngineEventHandler.onAudioMixingStateChanged(Constants.MEDIA_ENGINE_AUDIO_EVENT_MIXING_ERROR, i11);
                                                        return;
                                                    default:
                                                        switch (i11) {
                                                            case 720:
                                                            case 721:
                                                            case 722:
                                                            case 726:
                                                                iRtcEngineEventHandler.onAudioMixingStateChanged(Constants.MEDIA_ENGINE_AUDIO_EVENT_MIXING_PLAY, i11);
                                                                return;
                                                            case 723:
                                                            case 724:
                                                                iRtcEngineEventHandler.onAudioMixingStateChanged(Constants.MEDIA_ENGINE_AUDIO_EVENT_MIXING_STOPPED, i11);
                                                                return;
                                                            case 725:
                                                                iRtcEngineEventHandler.onAudioMixingStateChanged(Constants.MEDIA_ENGINE_AUDIO_EVENT_MIXING_PAUSED, i11);
                                                                return;
                                                            default:
                                                                Logging.d(TAG, "Unknown media engine event " + pMediaEngineEvent.code);
                                                                return;
                                                        }
                                                }
                                        }
                                    }
                                    iRtcEngineEventHandler.onMicrophoneEnabled(true);
                                    return;
                                }
                                iRtcEngineEventHandler.onAudioMixingFinished();
                                return;
                            case RtcEngineEvent.EvtType.EVT_API_CALL_EXECUTED /* 1106 */:
                                onApiCallExecuted(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_LOOKUP_CHANNEL_SUCCESS /* 10001 */:
                                new RtcEngineMessage.MediaResSetupTime().unmarshall(bArr);
                                return;
                            case RtcEngineEvent.EvtType.EVT_OPEN_CHANNEL_SUCCESS /* 13001 */:
                                RtcEngineMessage.PMediaResJoinMedia pMediaResJoinMedia = new RtcEngineMessage.PMediaResJoinMedia();
                                pMediaResJoinMedia.unmarshall(bArr);
                                if (pMediaResJoinMedia.firstSuccess) {
                                    iRtcEngineEventHandler.onJoinChannelSuccess(pMediaResJoinMedia.channel, pMediaResJoinMedia.uid, pMediaResJoinMedia.elapsed);
                                    return;
                                } else {
                                    iRtcEngineEventHandler.onRejoinChannelSuccess(pMediaResJoinMedia.channel, pMediaResJoinMedia.uid, pMediaResJoinMedia.elapsed);
                                    return;
                                }
                            case RtcEngineEvent.EvtType.EVT_RTC_STATS /* 13010 */:
                                RtcEngineMessage.PMediaResRtcStats pMediaResRtcStats = new RtcEngineMessage.PMediaResRtcStats();
                                pMediaResRtcStats.unmarshall(bArr);
                                updateRtcStats(pMediaResRtcStats);
                                iRtcEngineEventHandler.onRtcStats(getRtcStats());
                                return;
                            case RtcEngineEvent.EvtType.EVT_RECAP_INDICATION /* 14000 */:
                                ((IRtcEngineEventHandlerEx) iRtcEngineEventHandler).onRecap(bArr);
                                return;
                            case RtcEngineEvent.EvtType.EVT_AUDIO_VOLUME_INDICATION /* 14001 */:
                                onSpeakersReport(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_FIRST_REMOTE_VIDEO_FRAME /* 14002 */:
                                onFirstRemoteVideoFrame(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_LOCAL_VIDEO_STAT /* 14003 */:
                                onLocalVideoStat(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_REMOTE_VIDEO_STAT /* 14004 */:
                                onRemoteVideoStat(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_FIRST_LOCAL_VIDEO_FRAME /* 14005 */:
                                onFirstLocalVideoFrame(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_FIRST_LOCAL_VIDEO_FRAME_PUBLISH /* 14006 */:
                                onFirstLocalVideoFramePublished(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_FIRST_REMOTE_VIDEO_DECODED /* 14007 */:
                                onFirstRemoteVideoDecoded(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_CONNECTION_LOST /* 14008 */:
                                iRtcEngineEventHandler.onConnectionLost();
                                return;
                            case RtcEngineEvent.EvtType.EVT_STREAM_MESSAGE /* 14009 */:
                                onStreamMessage(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_CONNECTION_INTERRUPTED /* 14010 */:
                                iRtcEngineEventHandler.onConnectionInterrupted();
                                return;
                            case RtcEngineEvent.EvtType.EVT_CONNECTION_STATE_CHANGED /* 14028 */:
                                RtcEngineMessage.PConnectionState pConnectionState = new RtcEngineMessage.PConnectionState();
                                pConnectionState.unmarshall(bArr);
                                iRtcEngineEventHandler.onConnectionStateChanged(pConnectionState.state, pConnectionState.reason);
                                return;
                            case RtcEngineEvent.EvtType.EVT_CAMERA_EXPOSURE_AREA_CHANGED /* 14029 */:
                                onCameraExposureAreaChanged(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_REMOTE_AUDIO_STAT /* 14030 */:
                                onRemoteAudioStat(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_NETWORK_TYPE_CHANGED /* 14031 */:
                                RtcEngineMessage.PNetworkTypeChanged pNetworkTypeChanged = new RtcEngineMessage.PNetworkTypeChanged();
                                pNetworkTypeChanged.unmarshall(bArr);
                                iRtcEngineEventHandler.onNetworkTypeChanged(pNetworkTypeChanged.type);
                                return;
                            case RtcEngineEvent.EvtType.EVT_AUDIO_ROUTING_CHANGED /* 14032 */:
                                RtcEngineMessage.PAudioRoutingChanged pAudioRoutingChanged = new RtcEngineMessage.PAudioRoutingChanged();
                                pAudioRoutingChanged.unmarshall(bArr);
                                iRtcEngineEventHandler.onAudioRouteChanged(pAudioRoutingChanged.routing);
                                return;
                            case RtcEngineEvent.EvtType.EVT_FIRST_REMOTE_AUDIO_DECODED /* 14033 */:
                                RtcEngineMessage.PMediaResFirstRemoteAudioDecoded pMediaResFirstRemoteAudioDecoded = new RtcEngineMessage.PMediaResFirstRemoteAudioDecoded();
                                pMediaResFirstRemoteAudioDecoded.unmarshall(bArr);
                                iRtcEngineEventHandler.onFirstRemoteAudioDecoded(pMediaResFirstRemoteAudioDecoded.uid, pMediaResFirstRemoteAudioDecoded.elapsed);
                                return;
                            case RtcEngineEvent.EvtType.EVT_LOCAL_USER_REGISTERED /* 14034 */:
                                RtcEngineMessage.PUserAccountInfo pUserAccountInfo = new RtcEngineMessage.PUserAccountInfo();
                                pUserAccountInfo.unmarshall(bArr);
                                iRtcEngineEventHandler.onLocalUserRegistered(pUserAccountInfo.uid, pUserAccountInfo.userAccount);
                                return;
                            case RtcEngineEvent.EvtType.EVT_USER_INFO_UPDATED /* 14035 */:
                                RtcEngineMessage.PUserAccountInfo pUserAccountInfo2 = new RtcEngineMessage.PUserAccountInfo();
                                pUserAccountInfo2.unmarshall(bArr);
                                UserInfo userInfo = new UserInfo();
                                int i12 = pUserAccountInfo2.uid;
                                userInfo.uid = i12;
                                userInfo.userAccount = pUserAccountInfo2.userAccount;
                                iRtcEngineEventHandler.onUserInfoUpdated(i12, userInfo);
                                return;
                            case RtcEngineEvent.EvtType.EVT_REMOTE_VIDEO_STATE_CHANGED_EXT /* 14036 */:
                                onRemoteVideoStateChangedExt(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_CROSS_CHANNEL_STATE /* 14037 */:
                                onChannelMediaRelayStateChanged(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_CROSS_CHANNEL_EVENT /* 14038 */:
                                onChannelMediaRelayEvent(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_REMOTE_AUDIO_STATE_CHANGED /* 14040 */:
                                onRemoteAudioStateChanged(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_LOCAL_AUDIO_STAT /* 14041 */:
                                onLocalAudioStat(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_LOCAL_AUDIO_STATE_CHANGED /* 14042 */:
                                RtcEngineMessage.PMediaResLocalAudioStateChanged pMediaResLocalAudioStateChanged = new RtcEngineMessage.PMediaResLocalAudioStateChanged();
                                pMediaResLocalAudioStateChanged.unmarshall(bArr);
                                iRtcEngineEventHandler.onLocalAudioStateChanged(pMediaResLocalAudioStateChanged.state, pMediaResLocalAudioStateChanged.error);
                                return;
                            case RtcEngineEvent.EvtType.EVT_FACE_DETECT_VALUE /* 14043 */:
                                onFacePositionChanged(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.FIRST_LOCAL_AUDIO_FRAME_PUBLISHED /* 14044 */:
                                onFirstLocalAudioFramePublished(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_PUBLISH_AUDIO_STATE_CHANGED /* 14045 */:
                                onAudioPublishStateChanged(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_PUBLISH_VIDEO_STATE_CHANGED /* 14046 */:
                                onVideoPublishStateChanged(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_SUBSCRIBE_AUDIO_STATE_CHANGED /* 14047 */:
                                onAudioSubscribeStateChanged(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_SUBSCRIBE_VIDEO_STATE_CHANGED /* 14048 */:
                                onVideoSubscribeStateChanged(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_USER_SUPER_RESOLUTION_ENABLED /* 14049 */:
                                onUserSuperResolutionEnabled(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_UPLOAD_LOG_RESULT /* 14050 */:
                                onUploadLogResult(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_VIRTUAL_BACKGROUND_SOURCE_ENABLED /* 14051 */:
                                onVirtualBackgroundSourceEnabled(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_AUDIO_FILE_INFO /* 14052 */:
                                onRequestAudioFileInfo(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_SNAPSHOT_TAKEN /* 14053 */:
                                onSnapshotTaken(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_CONTENT_INSPECT_RESULT /* 14054 */:
                                onContentInspectResult(bArr, iRtcEngineEventHandler);
                                return;
                            case RtcEngineEvent.EvtType.EVT_PROXY_CONNECTED /* 14055 */:
                                RtcEngineMessage.PProxyConnect pProxyConnect = new RtcEngineMessage.PProxyConnect();
                                pProxyConnect.unmarshall(bArr);
                                iRtcEngineEventHandler.onProxyConnected(pProxyConnect.channel, pProxyConnect.uid, pProxyConnect.proxyType, pProxyConnect.localProxyIp, pProxyConnect.elapsed);
                                return;
                            case RtcEngineEvent.EvtType.EVT_CLIENT_ROLE_CHANGE_FAILED /* 14057 */:
                                RtcEngineMessage.PClientRoleChangeFailed pClientRoleChangeFailed = new RtcEngineMessage.PClientRoleChangeFailed();
                                pClientRoleChangeFailed.unmarshall(bArr);
                                iRtcEngineEventHandler.onClientRoleChangeFailed(pClientRoleChangeFailed.reason, pClientRoleChangeFailed.currentRole);
                                return;
                            default:
                                switch (i10) {
                                    case 1005:
                                        iRtcEngineEventHandler.onCameraReady();
                                        return;
                                    case 1006:
                                        iRtcEngineEventHandler.onMediaEngineStartCallSuccess();
                                        return;
                                    case 1007:
                                        iRtcEngineEventHandler.onVideoStopped();
                                        return;
                                    default:
                                        switch (i10) {
                                            case RtcEngineEvent.EvtType.EVT_REQUEST_TOKEN /* 1108 */:
                                                iRtcEngineEventHandler.onRequestToken();
                                                return;
                                            case RtcEngineEvent.EvtType.EVT_CLIENT_ROLE_CHANGED /* 1109 */:
                                                RtcEngineMessage.PClientRoleChanged pClientRoleChanged = new RtcEngineMessage.PClientRoleChanged();
                                                pClientRoleChanged.unmarshall(bArr);
                                                iRtcEngineEventHandler.onClientRoleChanged(pClientRoleChanged.oldRole, pClientRoleChanged.newRole);
                                                return;
                                            case RtcEngineEvent.EvtType.EVT_PUBLISH_URL /* 1110 */:
                                                RtcEngineMessage.PStreamPublished pStreamPublished = new RtcEngineMessage.PStreamPublished();
                                                pStreamPublished.unmarshall(bArr);
                                                iRtcEngineEventHandler.onStreamPublished(pStreamPublished.url, pStreamPublished.error);
                                                return;
                                            case RtcEngineEvent.EvtType.EVT_UNPUBLISH_URL /* 1111 */:
                                                RtcEngineMessage.PStreamUnPublished pStreamUnPublished = new RtcEngineMessage.PStreamUnPublished();
                                                pStreamUnPublished.unmarshall(bArr);
                                                iRtcEngineEventHandler.onStreamUnpublished(pStreamUnPublished.url);
                                                return;
                                            case RtcEngineEvent.EvtType.EVT_LIVE_TRANSCODING /* 1112 */:
                                                iRtcEngineEventHandler.onTranscodingUpdated();
                                                return;
                                            default:
                                                switch (i10) {
                                                    case RtcEngineEvent.EvtType.EVT_STREAM_INJECTED_STATUS /* 1116 */:
                                                        RtcEngineMessage.PStreamInjectedStatus pStreamInjectedStatus = new RtcEngineMessage.PStreamInjectedStatus();
                                                        pStreamInjectedStatus.unmarshall(bArr);
                                                        iRtcEngineEventHandler.onStreamInjectedStatus(pStreamInjectedStatus.url, pStreamInjectedStatus.uid, pStreamInjectedStatus.status);
                                                        return;
                                                    case RtcEngineEvent.EvtType.EVT_PRIVILEGE_WILL_EXPIRE /* 1117 */:
                                                        RtcEngineMessage.PPrivilegeWillExpire pPrivilegeWillExpire = new RtcEngineMessage.PPrivilegeWillExpire();
                                                        pPrivilegeWillExpire.unmarshall(bArr);
                                                        iRtcEngineEventHandler.onTokenPrivilegeWillExpire(pPrivilegeWillExpire.token);
                                                        break;
                                                    case RtcEngineEvent.EvtType.EVT_LOCAL_VIDEO_STATE_CHANGED /* 1118 */:
                                                        RtcEngineMessage.PMediaResLocalVideoStateChanged pMediaResLocalVideoStateChanged = new RtcEngineMessage.PMediaResLocalVideoStateChanged();
                                                        pMediaResLocalVideoStateChanged.unmarshall(bArr);
                                                        iRtcEngineEventHandler.onLocalVideoStateChanged(pMediaResLocalVideoStateChanged.localVideoState, pMediaResLocalVideoStateChanged.error);
                                                        return;
                                                    case RtcEngineEvent.EvtType.EVT_RTMP_STREAMING_STATE /* 1119 */:
                                                        RtcEngineMessage.PRtmpStreamingState pRtmpStreamingState = new RtcEngineMessage.PRtmpStreamingState();
                                                        pRtmpStreamingState.unmarshall(bArr);
                                                        iRtcEngineEventHandler.onRtmpStreamingStateChanged(pRtmpStreamingState.url, pRtmpStreamingState.state, pRtmpStreamingState.error);
                                                        return;
                                                    case RtcEngineEvent.EvtType.EVT_STREAM_EVENT /* 1120 */:
                                                        RtcEngineMessage.PStreamEvent pStreamEvent = new RtcEngineMessage.PStreamEvent();
                                                        pStreamEvent.unmarshall(bArr);
                                                        iRtcEngineEventHandler.onRtmpStreamingEvent(pStreamEvent.url, pStreamEvent.error);
                                                        return;
                                                    default:
                                                        switch (i10) {
                                                            case RtcEngineEvent.EvtType.EVT_LEAVE_CHANNEL /* 13006 */:
                                                                RtcEngineMessage.PMediaResRtcStats pMediaResRtcStats2 = new RtcEngineMessage.PMediaResRtcStats();
                                                                pMediaResRtcStats2.unmarshall(bArr);
                                                                updateRtcStats(pMediaResRtcStats2);
                                                                iRtcEngineEventHandler.onLeaveChannel(getRtcStats());
                                                                return;
                                                            case RtcEngineEvent.EvtType.EVT_NETWORK_QUALITY /* 13007 */:
                                                                RtcEngineMessage.PMediaResNetworkQuality pMediaResNetworkQuality = new RtcEngineMessage.PMediaResNetworkQuality();
                                                                pMediaResNetworkQuality.unmarshall(bArr);
                                                                iRtcEngineEventHandler.onNetworkQuality(pMediaResNetworkQuality.uid, pMediaResNetworkQuality.txQuality, pMediaResNetworkQuality.rxQuality);
                                                                return;
                                                            case RtcEngineEvent.EvtType.EVT_USER_OFFLINE /* 13008 */:
                                                                RtcEngineMessage.PMediaResUserOfflineEvent pMediaResUserOfflineEvent = new RtcEngineMessage.PMediaResUserOfflineEvent();
                                                                pMediaResUserOfflineEvent.unmarshall(bArr);
                                                                iRtcEngineEventHandler.onUserOffline(pMediaResUserOfflineEvent.uid, pMediaResUserOfflineEvent.reason);
                                                                return;
                                                            default:
                                                                switch (i10) {
                                                                    case RtcEngineEvent.EvtType.EVT_USER_JOINED /* 13013 */:
                                                                        RtcEngineMessage.PMediaResUserJoinedEvent pMediaResUserJoinedEvent = new RtcEngineMessage.PMediaResUserJoinedEvent();
                                                                        pMediaResUserJoinedEvent.unmarshall(bArr);
                                                                        iRtcEngineEventHandler.onUserJoined(pMediaResUserJoinedEvent.uid, pMediaResUserJoinedEvent.elapsed);
                                                                        return;
                                                                    case RtcEngineEvent.EvtType.EVT_USER_MUTE_AUDIO /* 13014 */:
                                                                        RtcEngineMessage.PMediaResUserState pMediaResUserState = new RtcEngineMessage.PMediaResUserState();
                                                                        pMediaResUserState.unmarshall(bArr);
                                                                        iRtcEngineEventHandler.onUserMuteAudio(pMediaResUserState.uid, pMediaResUserState.state);
                                                                        return;
                                                                    case RtcEngineEvent.EvtType.EVT_USER_MUTE_VIDEO /* 13015 */:
                                                                        RtcEngineMessage.PMediaResUserState pMediaResUserState2 = new RtcEngineMessage.PMediaResUserState();
                                                                        pMediaResUserState2.unmarshall(bArr);
                                                                        iRtcEngineEventHandler.onUserMuteVideo(pMediaResUserState2.uid, pMediaResUserState2.state);
                                                                        return;
                                                                    case RtcEngineEvent.EvtType.EVT_USER_ENABLE_VIDEO /* 13016 */:
                                                                        RtcEngineMessage.PMediaResUserState pMediaResUserState3 = new RtcEngineMessage.PMediaResUserState();
                                                                        pMediaResUserState3.unmarshall(bArr);
                                                                        iRtcEngineEventHandler.onUserEnableVideo(pMediaResUserState3.uid, pMediaResUserState3.state);
                                                                        return;
                                                                    case RtcEngineEvent.EvtType.EVT_LASTMILE_QUALITY /* 13017 */:
                                                                        RtcEngineMessage.PMediaResLastmileQuality pMediaResLastmileQuality = new RtcEngineMessage.PMediaResLastmileQuality();
                                                                        pMediaResLastmileQuality.unmarshall(bArr);
                                                                        iRtcEngineEventHandler.onLastmileQuality(pMediaResLastmileQuality.quality);
                                                                        return;
                                                                    case RtcEngineEvent.EvtType.AUDIO_EFFECT_FINISHED /* 13018 */:
                                                                        RtcEngineMessage.PMediaResAudioEffectFinished pMediaResAudioEffectFinished = new RtcEngineMessage.PMediaResAudioEffectFinished();
                                                                        pMediaResAudioEffectFinished.unmarshall(bArr);
                                                                        iRtcEngineEventHandler.onAudioEffectFinished(pMediaResAudioEffectFinished.soundId);
                                                                        return;
                                                                    case RtcEngineEvent.EvtType.EVT_USER_ENABLE_LOCAL_VIDEO /* 13019 */:
                                                                        RtcEngineMessage.PMediaResUserState pMediaResUserState4 = new RtcEngineMessage.PMediaResUserState();
                                                                        pMediaResUserState4.unmarshall(bArr);
                                                                        iRtcEngineEventHandler.onUserEnableLocalVideo(pMediaResUserState4.uid, pMediaResUserState4.state);
                                                                        return;
                                                                    case RtcEngineEvent.EvtType.EVT_LASTMILE_PROBE_RESULT /* 13020 */:
                                                                        RtcEngineMessage.PMediaResLastmileProbeResult pMediaResLastmileProbeResult = new RtcEngineMessage.PMediaResLastmileProbeResult();
                                                                        pMediaResLastmileProbeResult.unmarshall(bArr);
                                                                        IRtcEngineEventHandler.LastmileProbeResult lastmileProbeResult = new IRtcEngineEventHandler.LastmileProbeResult();
                                                                        lastmileProbeResult.state = pMediaResLastmileProbeResult.state;
                                                                        lastmileProbeResult.rtt = pMediaResLastmileProbeResult.rtt;
                                                                        IRtcEngineEventHandler.LastmileProbeResult.LastmileProbeOneWayResult lastmileProbeOneWayResult = lastmileProbeResult.uplinkReport;
                                                                        RtcEngineMessage.PMediaResLastmileProbeResult.LastmileProbeOneWayResult lastmileProbeOneWayResult2 = pMediaResLastmileProbeResult.uplinkReport;
                                                                        lastmileProbeOneWayResult.packetLossRate = lastmileProbeOneWayResult2.packetLossRate;
                                                                        lastmileProbeOneWayResult.jitter = lastmileProbeOneWayResult2.jitter;
                                                                        lastmileProbeOneWayResult.availableBandwidth = lastmileProbeOneWayResult2.availableBandwidth;
                                                                        IRtcEngineEventHandler.LastmileProbeResult.LastmileProbeOneWayResult lastmileProbeOneWayResult3 = lastmileProbeResult.downlinkReport;
                                                                        RtcEngineMessage.PMediaResLastmileProbeResult.LastmileProbeOneWayResult lastmileProbeOneWayResult4 = pMediaResLastmileProbeResult.downlinkReport;
                                                                        lastmileProbeOneWayResult3.packetLossRate = lastmileProbeOneWayResult4.packetLossRate;
                                                                        lastmileProbeOneWayResult3.jitter = lastmileProbeOneWayResult4.jitter;
                                                                        lastmileProbeOneWayResult3.availableBandwidth = lastmileProbeOneWayResult4.availableBandwidth;
                                                                        iRtcEngineEventHandler.onLastmileProbeResult(lastmileProbeResult);
                                                                        return;
                                                                    case RtcEngineEvent.EvtType.EVT_WLACC_MESSAGE /* 13021 */:
                                                                        RtcEngineMessage.PMediaResWlAccMessage pMediaResWlAccMessage = new RtcEngineMessage.PMediaResWlAccMessage();
                                                                        pMediaResWlAccMessage.unmarshall(bArr);
                                                                        iRtcEngineEventHandler.onWlAccMessage(pMediaResWlAccMessage.reason, pMediaResWlAccMessage.action, pMediaResWlAccMessage.wlAccMsg);
                                                                        return;
                                                                    case RtcEngineEvent.EvtType.EVT_WLACC_STATS /* 13022 */:
                                                                        RtcEngineMessage.PMediaResWlAccStats pMediaResWlAccStats = new RtcEngineMessage.PMediaResWlAccStats();
                                                                        pMediaResWlAccStats.unmarshall(bArr);
                                                                        IRtcEngineEventHandler.WlAccStats wlAccStats = new IRtcEngineEventHandler.WlAccStats();
                                                                        wlAccStats.e2eDelayPercent = pMediaResWlAccStats.e2eDelayPercentCur;
                                                                        wlAccStats.frozenRatioPercent = pMediaResWlAccStats.frozenRatioPercentCur;
                                                                        wlAccStats.lossRatePercent = pMediaResWlAccStats.lossRatePercentCur;
                                                                        IRtcEngineEventHandler.WlAccStats wlAccStats2 = new IRtcEngineEventHandler.WlAccStats();
                                                                        wlAccStats2.e2eDelayPercent = pMediaResWlAccStats.e2eDelayPercentAve;
                                                                        wlAccStats2.frozenRatioPercent = pMediaResWlAccStats.frozenRatioPercentAve;
                                                                        wlAccStats2.lossRatePercent = pMediaResWlAccStats.lossRatePercentAve;
                                                                        iRtcEngineEventHandler.onWlAccStats(wlAccStats, wlAccStats2);
                                                                        return;
                                                                    default:
                                                                        switch (i10) {
                                                                            case RtcEngineEvent.EvtType.EVT_STREAM_MESSAGE_ERROR /* 14012 */:
                                                                                onStreamMessageError(bArr, iRtcEngineEventHandler);
                                                                                return;
                                                                            case RtcEngineEvent.EvtType.EVT_VIDEO_SIZE_CHANGED /* 14013 */:
                                                                                onVideoSizeChanged(bArr, iRtcEngineEventHandler);
                                                                                return;
                                                                            case RtcEngineEvent.EvtType.FIRST_LOCAL_AUDIO_FRAME /* 14014 */:
                                                                                onFirstLocalAudioFrame(bArr, iRtcEngineEventHandler);
                                                                                return;
                                                                            case RtcEngineEvent.EvtType.FIRST_REMOTE_AUDIO_FRAME /* 14015 */:
                                                                                onFirstRemoteAudioFrame(bArr, iRtcEngineEventHandler);
                                                                                return;
                                                                            case RtcEngineEvent.EvtType.EVT_ACTIVE_SPEAKER /* 14016 */:
                                                                                RtcEngineMessage.PActiveSpeaker pActiveSpeaker = new RtcEngineMessage.PActiveSpeaker();
                                                                                pActiveSpeaker.unmarshall(bArr);
                                                                                iRtcEngineEventHandler.onActiveSpeaker(pActiveSpeaker.uid);
                                                                                return;
                                                                            default:
                                                                                switch (i10) {
                                                                                    case RtcEngineEvent.EvtType.EVT_CONNECTION_BANNED /* 14019 */:
                                                                                        iRtcEngineEventHandler.onConnectionBanned();
                                                                                        return;
                                                                                    case RtcEngineEvent.EvtType.EVT_CAMERA_FOCUS_AREA_CHANGED /* 14020 */:
                                                                                        onCameraFocusAreaChanged(bArr, iRtcEngineEventHandler);
                                                                                        return;
                                                                                    case RtcEngineEvent.EvtType.EVT_LOCAL_VOICE_PITCH /* 14021 */:
                                                                                        onLocalVoicePitchInHz(bArr, iRtcEngineEventHandler);
                                                                                        return;
                                                                                    case RtcEngineEvent.EvtType.EVT_LOCAL_PUBLISH_FALLBACK_TO_AUDIO_ONLY /* 14022 */:
                                                                                        RtcEngineMessage.PLocalFallbackStatus pLocalFallbackStatus = new RtcEngineMessage.PLocalFallbackStatus();
                                                                                        pLocalFallbackStatus.unmarshall(bArr);
                                                                                        iRtcEngineEventHandler.onLocalPublishFallbackToAudioOnly(pLocalFallbackStatus.state);
                                                                                        return;
                                                                                    case RtcEngineEvent.EvtType.EVT_REMOTE_SUBSCRIBE_FALLBACK_TO_AUDIO_ONLY /* 14023 */:
                                                                                        RtcEngineMessage.PMediaResUserState pMediaResUserState5 = new RtcEngineMessage.PMediaResUserState();
                                                                                        pMediaResUserState5.unmarshall(bArr);
                                                                                        iRtcEngineEventHandler.onRemoteSubscribeFallbackToAudioOnly(pMediaResUserState5.uid, pMediaResUserState5.state);
                                                                                        return;
                                                                                    case RtcEngineEvent.EvtType.EVT_USER_TRANSPORT_STAT /* 14024 */:
                                                                                        RtcEngineMessage.PUserTransportStat pUserTransportStat = new RtcEngineMessage.PUserTransportStat();
                                                                                        pUserTransportStat.unmarshall(bArr);
                                                                                        if (pUserTransportStat.isAudio) {
                                                                                            iRtcEngineEventHandler.onRemoteAudioTransportStats(pUserTransportStat.peer_uid, pUserTransportStat.delay, pUserTransportStat.lost, pUserTransportStat.rxKBitRate);
                                                                                            return;
                                                                                        } else {
                                                                                            iRtcEngineEventHandler.onRemoteVideoTransportStats(pUserTransportStat.peer_uid, pUserTransportStat.delay, pUserTransportStat.lost, pUserTransportStat.rxKBitRate);
                                                                                            return;
                                                                                        }
                                                                                    default:
                                                                                        return;
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                        iRtcEngineEventHandler.onMediaEngineLoadSuccess();
                        return;
                }
            }
            RtcEngineMessage.PMediaResAudioQuality pMediaResAudioQuality = new RtcEngineMessage.PMediaResAudioQuality();
            pMediaResAudioQuality.unmarshall(bArr);
            iRtcEngineEventHandler.onAudioQuality(pMediaResAudioQuality.peer_uid, pMediaResAudioQuality.quality, pMediaResAudioQuality.delay, pMediaResAudioQuality.lost);
            return;
        }
        RtcEngineMessage.PMediaResTransportQuality pMediaResTransportQuality = new RtcEngineMessage.PMediaResTransportQuality();
        pMediaResTransportQuality.unmarshall(bArr);
        if (pMediaResTransportQuality.isAudio) {
            ((IRtcEngineEventHandlerEx) iRtcEngineEventHandler).onAudioTransportQuality(pMediaResTransportQuality.peer_uid, pMediaResTransportQuality.bitrate, pMediaResTransportQuality.delay, pMediaResTransportQuality.lost);
        } else {
            ((IRtcEngineEventHandlerEx) iRtcEngineEventHandler).onVideoTransportQuality(pMediaResTransportQuality.peer_uid, pMediaResTransportQuality.bitrate, pMediaResTransportQuality.delay, pMediaResTransportQuality.lost);
        }
    }

    @Override // io.agora.rtc.RtcEngine
    public boolean isCameraAutoFocusFaceModeSupported() {
        return nativeIsCameraAutoFocusFaceModeSupported(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcEngine
    public boolean isCameraExposurePositionSupported() {
        return nativeIsCameraExposurePositionSupported(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcEngine
    public boolean isCameraFocusSupported() {
        return nativeIsCameraFocusSupported(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcEngine
    public boolean isCameraTorchSupported() {
        return nativeIsCameraTorchSupported(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcEngine
    public boolean isCameraZoomSupported() {
        return nativeIsCameraZoomSupported(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcEngine
    public boolean isSpeakerphoneEnabled() {
        return nativeIsSpeakerphoneEnabled(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcEngine
    public boolean isTextureEncodeSupported() {
        if (DeviceUtils.getRecommendedEncoderType() == 0) {
            return true;
        }
        return false;
    }

    @Override // io.agora.rtc.RtcEngine
    public int joinChannel(String str, String str2, String str3, int i10) {
        Context context = this.mContext.get();
        if (context == null) {
            return -7;
        }
        doJoinChannelCheck(context);
        int nativeJoinChannel = nativeJoinChannel(this.mNativeHandle, null, str, str2, str3, i10, null);
        synchronized (this) {
            try {
                if (this.mDefaultRtcChannel == null) {
                    this.mDefaultRtcChannel = new RtcChannelImpl();
                }
                if (nativeJoinChannel == 0) {
                    this.mDefaultRtcChannel.initialize(this, nativeGetDefaultRtcChannel(this.mNativeHandle));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nativeJoinChannel;
    }

    @Override // io.agora.rtc.RtcEngine
    public int joinChannelWithUserAccount(String str, String str2, String str3) {
        int nativeJoinChannelWithUserAccount = nativeJoinChannelWithUserAccount(this.mNativeHandle, str, str2, str3, null);
        synchronized (this) {
            try {
                if (this.mDefaultRtcChannel == null) {
                    this.mDefaultRtcChannel = new RtcChannelImpl();
                }
                if (nativeJoinChannelWithUserAccount == 0) {
                    this.mDefaultRtcChannel.initialize(this, nativeGetDefaultRtcChannel(this.mNativeHandle));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nativeJoinChannelWithUserAccount;
    }

    @Override // io.agora.rtc.RtcEngine
    public int leaveChannel() {
        synchronized (this) {
            try {
                if (this.mDefaultRtcChannel != null) {
                    this.mDefaultRtcChannel = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        doLeaveChannelCheck();
        return nativeLeaveChannel(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcEngineEx
    public String makeQualityReportUrl(String str, int i10, int i11, int i12) {
        return nativeMakeQualityReportUrl(this.mNativeHandle, str, i10, i11, i12);
    }

    @Override // io.agora.rtc.RtcEngineEx
    public int monitorAudioRouteChange(boolean z10) {
        Logging.i("API call monitorAudioRouteChange:" + z10);
        return 0;
    }

    @Override // io.agora.rtc.RtcEngine
    @TargetApi(11)
    @Deprecated
    public void monitorBluetoothHeadsetEvent(boolean z10) {
        Logging.i(TAG, "enter monitorBluetoothHeadsetEvent:" + z10);
    }

    @Override // io.agora.rtc.RtcEngine
    @Deprecated
    public void monitorHeadsetEvent(boolean z10) {
        Logging.i(TAG, "enter monitorHeadsetEvent:" + z10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int muteAllRemoteAudioStreams(boolean z10) {
        return setParameter("rtc.audio.mute_peers", z10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int muteAllRemoteVideoStreams(boolean z10) {
        return nativeMuteAllRemoteVideoStreams(this.mNativeHandle, z10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int muteLocalAudioStream(boolean z10) {
        return nativeMuteLocalAudioStream(this.mNativeHandle, z10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int muteLocalVideoStream(boolean z10) {
        return nativeMuteLocalVideoStream(this.mNativeHandle, z10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int muteRemoteAudioStream(int i10, boolean z10) {
        return setParameters(formatString("{\"rtc.audio.mute_peer\":{\"uid\":%d,\"mute\":%b}}", Long.valueOf(i10 & 4294967295L), Boolean.valueOf(z10)));
    }

    @Override // io.agora.rtc.RtcEngine
    public int muteRemoteVideoStream(int i10, boolean z10) {
        return setParameters(formatString("{\"rtc.video.mute_peer\":{\"uid\":%d,\"mute\":%b}}", Long.valueOf(i10 & 4294967295L), Boolean.valueOf(z10)));
    }

    protected void onChannelEvent(String str, int i10, byte[] bArr) {
        RtcChannelImpl rtcChannelImpl;
        if (str != null && str.length() > 0) {
            synchronized (this) {
                try {
                    Iterator<RtcChannelImpl> it = this.mRtcChannels.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            rtcChannelImpl = it.next();
                            if (rtcChannelImpl.channelId() != null && rtcChannelImpl.channelId().equals(str)) {
                                break;
                            }
                        } else {
                            rtcChannelImpl = null;
                            break;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (rtcChannelImpl == null || !rtcChannelImpl.isInitialized() || rtcChannelImpl.getEventHandler() == null) {
                return;
            }
            handleChannelEvent(i10, bArr, rtcChannelImpl.getEventHandler(), rtcChannelImpl);
        }
    }

    protected void onEvent(int i10, byte[] bArr) {
        Iterator<IRtcEngineEventHandler> it = this.mRtcHandlers.keySet().iterator();
        while (it.hasNext()) {
            IRtcEngineEventHandler next = it.next();
            if (next == null) {
                it.remove();
            } else {
                handleEvent(i10, bArr, next);
            }
        }
    }

    public void onRtcChannelJoinChannel() {
        doJoinChannelCheck(getContext());
    }

    public void onRtcChannelLeaveChannel() {
        doLeaveChannelCheck();
    }

    @Override // io.agora.rtc.RtcEngine
    public int pauseAllChannelMediaRelay() {
        return nativePauseAllChannelMediaRelay(this.mNativeHandle);
    }

    @Override // io.agora.rtc.IAudioEffectManager
    public int pauseAllEffects() {
        return setParameter("che.audio.game_pause_all_effects", true);
    }

    @Override // io.agora.rtc.RtcEngine
    public int pauseAudio() {
        return setParameter("rtc.audio.paused", true);
    }

    @Override // io.agora.rtc.RtcEngine
    public int pauseAudioMixing() {
        return setParameter("che.audio.pause_file_as_playout", true);
    }

    @Override // io.agora.rtc.IAudioEffectManager
    public int pauseEffect(int i10) {
        return setParameter("che.audio.game_pause_effect", i10);
    }

    @Override // io.agora.rtc.IAudioEffectManager
    @Deprecated
    public int playEffect(int i10, String str, int i11, double d10, double d11, double d12) {
        return playEffect(i10, str, i11, d10, d11, d12, false, 0);
    }

    @Override // io.agora.rtc.RtcEngineEx
    public int playRecap() {
        return setParameter("che.audio.recap.start_play", true);
    }

    @Override // io.agora.rtc.IAudioEffectManager
    public int preloadEffect(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            return -2;
        }
        return setParameterObject("che.audio.game_preload_effect", formatString("{\"soundId\":%d,\"filePath\":\"%s\"}", Integer.valueOf(i10), str));
    }

    @Override // io.agora.rtc.RtcEngine
    public int pullPlaybackAudioFrame(byte[] bArr, int i10) {
        int i11 = this.mExAudioSinkChannels;
        if (i11 != 1 && i11 != 2) {
            return -1;
        }
        return nativePullAudioFrame(this.mNativeHandle, bArr, i10, i11);
    }

    @Override // io.agora.rtc.RtcEngine
    @Deprecated
    public int pushExternalAudioFrame(byte[] bArr, long j10) {
        return nativePushExternalAudioFrameRawData(this.mNativeHandle, bArr, j10, this.mExAudioSourceSampleRate, this.mExAudioSourceChannels);
    }

    @Override // io.agora.rtc.RtcEngine
    public boolean pushExternalVideoFrame(AgoraVideoFrame agoraVideoFrame) {
        int i10;
        if (agoraVideoFrame != null && (i10 = agoraVideoFrame.format) != 12) {
            if (this.mVideoSourceType != 3) {
                Logging.e("pushExternalVideoFrame failed!! Call setExternalVideoSource to enable enable external video source!!");
                return false;
            }
            if (i10 != 10 && i10 != 11) {
                if (((i10 <= 0 || i10 > 8) && i10 != 16) || deliverFrame(this.mNativeHandle, agoraVideoFrame.buf, agoraVideoFrame.stride, agoraVideoFrame.height, agoraVideoFrame.cropLeft, agoraVideoFrame.cropTop, agoraVideoFrame.cropRight, agoraVideoFrame.cropBottom, agoraVideoFrame.rotation, agoraVideoFrame.timeStamp, i10) != 0) {
                    return false;
                }
                return true;
            }
            if (agoraVideoFrame.textureID == 0) {
                Logging.e("pushExternalVideoFrame failed!! invalid texture ID.");
                return false;
            }
            android.opengl.EGLContext eGLContext = agoraVideoFrame.eglContext14;
            if (eGLContext != null) {
                if (updateSharedContext(eGLContext) != 0 || setTextureIdWithMatrix(agoraVideoFrame.textureID, agoraVideoFrame.eglContext14, agoraVideoFrame.format, agoraVideoFrame.stride, agoraVideoFrame.height, agoraVideoFrame.timeStamp, agoraVideoFrame.transform) != 0) {
                    return false;
                }
                return true;
            }
            EGLContext eGLContext2 = agoraVideoFrame.eglContext11;
            if (eGLContext2 == null || updateSharedContext(eGLContext2) != 0 || setTextureIdWithMatrix(agoraVideoFrame.textureID, agoraVideoFrame.eglContext11, agoraVideoFrame.format, agoraVideoFrame.stride, agoraVideoFrame.height, agoraVideoFrame.timeStamp, agoraVideoFrame.transform) != 0) {
                return false;
            }
            return true;
        }
        Logging.e("pushExternalVideoFrame failed!! invalid video frame.");
        return false;
    }

    @Override // io.agora.rtc.RtcEngine
    public int rate(String str, int i10, String str2) {
        return nativeRate(this.mNativeHandle, str, i10, str2);
    }

    @Override // io.agora.rtc.RtcEngine
    public int registerAudioFrameObserver(IAudioFrameObserver iAudioFrameObserver) {
        if (iAudioFrameObserver != null) {
            AudioParams mixedAudioParams = iAudioFrameObserver.getMixedAudioParams();
            if (mixedAudioParams != null) {
                setMixedAudioFrameParameters(mixedAudioParams.sampleRate, mixedAudioParams.samplesPerCall);
            }
            AudioParams recordAudioParams = iAudioFrameObserver.getRecordAudioParams();
            if (recordAudioParams != null) {
                setRecordingAudioFrameParameters(recordAudioParams.sampleRate, recordAudioParams.channel, recordAudioParams.mode, recordAudioParams.samplesPerCall);
            }
            AudioParams playbackAudioParams = iAudioFrameObserver.getPlaybackAudioParams();
            if (playbackAudioParams != null) {
                setPlaybackAudioFrameParameters(playbackAudioParams.sampleRate, playbackAudioParams.channel, playbackAudioParams.mode, playbackAudioParams.samplesPerCall);
            }
        }
        return nativeRegisterAudioFrameObserver(this.mNativeHandle, iAudioFrameObserver);
    }

    @Override // io.agora.rtc.RtcEngine
    public int registerLocalUserAccount(String str, String str2) {
        if (str != null && str2 != null) {
            return nativeRegisterLocalUserAccount(this.mNativeHandle, str, str2);
        }
        return -2;
    }

    @Override // io.agora.rtc.RtcEngine
    public int registerMediaMetadataObserver(IMetadataObserver iMetadataObserver, int i10) {
        return nativeRegisterMediaMetadataObserver(this.mNativeHandle, iMetadataObserver, i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int registerVideoEncodedFrameObserver(IVideoEncodedFrameObserver iVideoEncodedFrameObserver) {
        return nativeRegisterVideoEncodedFrameObserver(this.mNativeHandle, iVideoEncodedFrameObserver);
    }

    @Override // io.agora.rtc.RtcEngine
    public int registerVideoFrameObserver(IVideoFrameObserver iVideoFrameObserver) {
        return nativeRegisterVideoFrameObserver(this.mNativeHandle, iVideoFrameObserver);
    }

    public void reinitialize(Context context, String str, IRtcEngineEventHandler iRtcEngineEventHandler) {
        addHandler(iRtcEngineEventHandler);
    }

    @Override // io.agora.rtc.RtcEngine
    public int releaseLogWriter() {
        return nativeReleaseLogWriter(this.mNativeHandle);
    }

    public void releaseRecorder() {
        nativeReleaseRecorder(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcEngine
    public void removeHandler(IRtcEngineEventHandler iRtcEngineEventHandler) {
        if (this.mRtcHandlers.containsKey(iRtcEngineEventHandler)) {
            this.mRtcHandlers.remove(iRtcEngineEventHandler);
        }
    }

    @Override // io.agora.rtc.RtcEngine
    public int removeInjectStreamUrl(String str) {
        if (str == null) {
            return -2;
        }
        return nativeRemoveInjectStreamUrl(this.mNativeHandle, str);
    }

    @Override // io.agora.rtc.RtcEngine
    public int removePublishStreamUrl(String str) {
        return nativeRemovePublishStreamUrl(this.mNativeHandle, str);
    }

    public int removeRemoteVideoTrack(int i10) {
        return nativeRemoveVideoReceiveTrack(this.mNativeHandle, i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int renewToken(String str) {
        if (str == null) {
            return -2;
        }
        return setParameter("rtc.renew_token", str);
    }

    @Override // io.agora.rtc.RtcEngine
    public int resumeAllChannelMediaRelay() {
        return nativeResumeAllChannelMediaRelay(this.mNativeHandle);
    }

    @Override // io.agora.rtc.IAudioEffectManager
    public int resumeAllEffects() {
        return setParameter("che.audio.game_resume_all_effects", true);
    }

    @Override // io.agora.rtc.RtcEngine
    public int resumeAudio() {
        return setParameter("rtc.audio.paused", false);
    }

    @Override // io.agora.rtc.RtcEngine
    public int resumeAudioMixing() {
        return setParameter("che.audio.pause_file_as_playout", false);
    }

    @Override // io.agora.rtc.IAudioEffectManager
    public int resumeEffect(int i10) {
        return setParameter("che.audio.game_resume_effect", i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int selectAudioTrack(int i10) {
        if (i10 < 0) {
            return -2;
        }
        return setParameter("che.audio.select_audio_track", i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int sendCustomReportMessage(String str, String str2, String str3, String str4, int i10) {
        return nativeSendCustomReportMessage(this.mNativeHandle, str, str2, str3, str4, i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int sendStreamMessage(int i10, byte[] bArr) {
        return nativeSendStreamMessage(this.mNativeHandle, i10, bArr);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setAVSyncSource(String str, int i10) {
        return nativeSetAVSyncSource(this.mNativeHandle, str, i10);
    }

    @Override // io.agora.rtc.RtcEngineEx
    public int setApiCallMode(int i10) {
        return nativeSetApiCallMode(this.mNativeHandle, i10);
    }

    @Override // io.agora.rtc.RtcEngineEx
    public int setAppType(int i10) {
        return nativeSetAppType(this.mNativeHandle, i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setAudioEffectParameters(int i10, int i11, int i12) {
        if (i10 == 33816832) {
            return setParameterObject("che.audio.morph.electronic_voice", formatString("{\"key\":%d,\"value\":%d}", Integer.valueOf(i11), Integer.valueOf(i12)));
        }
        if (i10 == 33622016) {
            return setParameter("che.audio.morph.threedim_voice", i11);
        }
        return -2;
    }

    @Override // io.agora.rtc.RtcEngine
    public int setAudioEffectPreset(int i10) {
        if (i10 == 0) {
            return setParameter("che.audio.morph.voice_changer", 0);
        }
        if (i10 == 33620224) {
            return setParameter("che.audio.morph.reverb_preset", 1);
        }
        if (i10 == 33620480) {
            return setParameter("che.audio.morph.reverb_preset", 2);
        }
        if (i10 == 33620736) {
            return setParameter("che.audio.morph.reverb_preset", 5);
        }
        if (i10 == 33620992) {
            return setParameter("che.audio.morph.reverb_preset", 8);
        }
        if (i10 == 33621248) {
            return setParameter("che.audio.morph.virtual_stereo", 1);
        }
        if (i10 == 33621504) {
            return setParameter("che.audio.morph.voice_changer", 15);
        }
        if (i10 == 33621760) {
            return setParameter("che.audio.morph.voice_changer", 5);
        }
        if (i10 == 33622016) {
            return setParameter("che.audio.morph.threedim_voice", 10);
        }
        if (i10 == 33685760) {
            return setParameter("che.audio.morph.reverb_preset", 3);
        }
        if (i10 == 33686016) {
            return setParameter("che.audio.morph.voice_changer", 1);
        }
        if (i10 == 33686272) {
            return setParameter("che.audio.morph.voice_changer", 2);
        }
        if (i10 == 33686528) {
            return setParameter("che.audio.morph.reverb_preset", 4);
        }
        if (i10 == 33686784) {
            return setParameter("che.audio.morph.voice_changer", 3);
        }
        if (i10 == 33687040) {
            return setParameter("che.audio.morph.voice_changer", 4);
        }
        if (i10 == 33687296) {
            return setParameter("che.audio.morph.voice_changer", 6);
        }
        if (i10 == 33751296) {
            return setParameter("che.audio.morph.reverb_preset", 7);
        }
        if (i10 == 33751552) {
            return setParameter("che.audio.morph.reverb_preset", 6);
        }
        if (i10 == 33816832) {
            return setParameterObject("che.audio.morph.electronic_voice", formatString("{\"key\":%d,\"value\":%d}", 1, 4));
        }
        return -2;
    }

    @Override // io.agora.rtc.RtcEngine
    public int setAudioMixingDualMonoMode(int i10) {
        if (i10 >= 0 && i10 <= 3) {
            return setParameter("che.audio.set_dual_mono_mode", i10);
        }
        return -2;
    }

    @Override // io.agora.rtc.RtcEngine
    public int setAudioMixingPitch(int i10) {
        if (i10 <= 12 && i10 >= -12) {
            return setParameter("che.audio.set_playout_file_pitch_semitones", i10);
        }
        return -2;
    }

    @Override // io.agora.rtc.RtcEngine
    public int setAudioMixingPlaybackSpeed(int i10) {
        return setParameter("che.audio.set_audio_mixing_play_tempo", i10 / 100.0d);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setAudioMixingPosition(int i10) {
        return setParameter("che.audio.mixing.file.position", i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setAudioProfile(int i10, int i11) {
        return nativeSetAudioProfile(this.mNativeHandle, i10, i11);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setBeautyEffectOptions(boolean z10, BeautyOptions beautyOptions) {
        if (beautyOptions == null) {
            if (z10) {
                return -2;
            }
            beautyOptions = new BeautyOptions();
        }
        return nativeSetBeautyEffectOptions(this.mNativeHandle, z10, beautyOptions.lighteningContrastLevel, beautyOptions.lighteningLevel, beautyOptions.smoothnessLevel, beautyOptions.rednessLevel, beautyOptions.sharpnessLevel);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setCameraAutoFocusFaceModeEnabled(boolean z10) {
        return nativeSetCameraAutoFocusFaceModeEnabled(this.mNativeHandle, z10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setCameraCaptureRotation(int i10) {
        return nativeSetCameraCaptureRotation(this.mNativeHandle, i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setCameraCapturerConfiguration(CameraCapturerConfiguration cameraCapturerConfiguration) {
        CameraCapturerConfiguration.CaptureDimensions captureDimensions;
        int parameter = setParameter("che.video.camera_capture_mode", cameraCapturerConfiguration.preference.getValue());
        if (cameraCapturerConfiguration.preference == CameraCapturerConfiguration.CAPTURER_OUTPUT_PREFERENCE.CAPTURER_OUTPUT_PREFERENCE_MANUAL && (captureDimensions = cameraCapturerConfiguration.dimensions) != null) {
            setParameter("che.video.capture_width", captureDimensions.width);
            setParameter("che.video.capture_height", cameraCapturerConfiguration.dimensions.height);
        }
        if (parameter == 0) {
            return switchCamera(cameraCapturerConfiguration.cameraDirection);
        }
        return parameter;
    }

    @Override // io.agora.rtc.RtcEngine
    public int setCameraExposurePosition(float f10, float f11) {
        return nativeSetCameraExposurePosition(this.mNativeHandle, f10, f11);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setCameraFocusPositionInPreview(float f10, float f11) {
        return nativeSetCameraFocusPositionInPreview(this.mNativeHandle, f10, f11);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setCameraTorchOn(boolean z10) {
        return nativeSetCameraTorchOn(this.mNativeHandle, z10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setCameraZoomFactor(float f10) {
        return nativeSetCameraZoomFactor(this.mNativeHandle, f10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setChannelProfile(int i10) {
        if (i10 == 0) {
            setClientRole(1);
        }
        return nativeSetChannelProfile(this.mNativeHandle, i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setClientRole(int i10) {
        return nativeSetClientRole(this.mNativeHandle, i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setCloudProxy(int i10) {
        return nativeSetCloudProxy(this.mNativeHandle, i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setColorEnhanceOptions(boolean z10, ColorEnhanceOptions colorEnhanceOptions) {
        if (colorEnhanceOptions == null) {
            if (z10) {
                return -2;
            }
            colorEnhanceOptions = new ColorEnhanceOptions();
        }
        return nativeSetColorEnhanceOptions(this.mNativeHandle, z10, colorEnhanceOptions.strengthLevel, colorEnhanceOptions.skinProtectLevel);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setDefaultAudioRoutetoSpeakerphone(boolean z10) {
        Logging.i(String.format("API call to setDefaultAudioRoutetoSpeakerphone :%b", Boolean.valueOf(z10)));
        return nativeSetDefaultAudioRoutetoSpeakerphone(this.mNativeHandle, z10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setDefaultMuteAllRemoteAudioStreams(boolean z10) {
        return setParameter("rtc.audio.set_default_mute_peers", z10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setDefaultMuteAllRemoteVideoStreams(boolean z10) {
        return setParameter("rtc.video.set_default_mute_peers", z10);
    }

    @Override // io.agora.rtc.IAudioEffectManager
    public int setEffectPosition(int i10, int i11) {
        return setParameterObject("che.audio.set_effect_file_position", formatString("{\"soundId\":%d,\"effectPos\":%d}", Integer.valueOf(i10), Integer.valueOf(i11)));
    }

    @Override // io.agora.rtc.IAudioEffectManager
    public int setEffectsVolume(double d10) {
        int i10 = (int) d10;
        int adjustEffectsPlayoutVolume = adjustEffectsPlayoutVolume(i10);
        if (adjustEffectsPlayoutVolume == 0) {
            return adjustEffectsPublishVolume(i10);
        }
        return adjustEffectsPlayoutVolume;
    }

    @Override // io.agora.rtc.RtcEngine
    public int setEnableSpeakerphone(boolean z10) {
        Logging.i(String.format("API call to setEnableSpeakerphone to %b", Boolean.valueOf(z10)));
        return nativeSetEnableSpeakerphone(this.mNativeHandle, z10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setEncryptionMode(String str) {
        return setParameter("rtc.encryption.mode", str);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setEncryptionSecret(String str) {
        return nativeSetEncryptionSecret(this.mNativeHandle, str);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setExternalAudioSink(boolean z10, int i10, int i11) {
        if (i11 != 1 && i11 != 2) {
            return -1;
        }
        if (i10 != 8000 && i10 != 16000 && i10 != 32000 && i10 != 44100 && i10 != 48000) {
            return -2;
        }
        this.mExAudioSinkChannels = i11;
        this.mExAudioSinkSampleRate = i10;
        if (z10) {
            return setParameters(formatString("{\"che.audio.external_render\":%b,\"che.audio.external_render.pull\":%b,\"che.audio.set_render_raw_audio_format\":{\"sampleRate\":%d,\"channelCnt\":%d,\"mode\":%d}}", Boolean.valueOf(z10), Boolean.valueOf(z10), Integer.valueOf(i10), Integer.valueOf(i11), 0));
        }
        return setParameters(formatString("{\"che.audio.external_render\":%b,\"che.audio.external_render\":%b,\"che.audio.external_render.pull\":%b}", Boolean.valueOf(z10), Boolean.valueOf(z10), Boolean.valueOf(z10)));
    }

    @Override // io.agora.rtc.RtcEngine
    public int setExternalAudioSource(boolean z10, int i10, int i11) {
        this.mExAudioSourceSampleRate = i10;
        this.mExAudioSourceChannels = i11;
        if (z10) {
            return setParameters(formatString("{\"che.audio.external_capture\":%b,\"che.audio.set_external_source_format\":{\"sampleRate\":%d,\"channelCnt\":%d}}", Boolean.valueOf(z10), Integer.valueOf(i10), Integer.valueOf(i11)));
        }
        return setParameters(formatString("{\"che.audio.external_capture\":%b,\"che.audio.external_capture\":%b}", Boolean.valueOf(z10), Boolean.valueOf(z10)));
    }

    @Override // io.agora.rtc.RtcEngine
    public int setExternalAudioSourceVolume(int i10, int i11) {
        return nativeSetExternalAudioSourceVolume(this.mNativeHandle, i10, i11);
    }

    @Override // io.agora.rtc.RtcEngine
    public void setExternalVideoSource(boolean z10, boolean z11, boolean z12) {
        if (z10) {
            this.mVideoSourceType = 3;
        } else {
            this.mVideoSourceType = 1;
        }
        if (z11) {
            if (z10) {
                setParameter("che.video.enable_external_texture_input", true);
            } else {
                setParameter("che.video.enable_external_texture_input", false);
                Logging.w("setExternalVideoSource: on Android, texture mode cannot be disabled once enabled.");
            }
        }
        setExtVideoSource(this.mNativeHandle, z10 ? 1 : 0, z12 ? 1 : 0);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setHighQualityAudioParameters(boolean z10, boolean z11, boolean z12) {
        return setParameterObject("che.audio.codec.hq", formatString("{\"fullband\":%b,\"stereo\":%b,\"fullBitrate\":%b}", Boolean.valueOf(z10), Boolean.valueOf(z11), Boolean.valueOf(z12)));
    }

    @Override // io.agora.rtc.RtcEngine
    public int setInEarMonitoringVolume(int i10) {
        return setParameter("che.audio.headset.monitoring.parameter", i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setLiveTranscoding(LiveTranscoding liveTranscoding) {
        if (liveTranscoding == null) {
            return -2;
        }
        return nativeSetLiveTranscoding(this.mNativeHandle, new RtcEngineMessage.PLiveTranscoding().marshall(liveTranscoding));
    }

    @Override // io.agora.rtc.RtcEngine
    public int setLocalAccessPoint(LocalAccessPointConfiguration localAccessPointConfiguration) {
        if (localAccessPointConfiguration.ipList == null) {
            localAccessPointConfiguration.ipList = new ArrayList<>();
        }
        if (localAccessPointConfiguration.domainList == null) {
            localAccessPointConfiguration.domainList = new ArrayList<>();
        }
        if (localAccessPointConfiguration.verifyDomainName == null) {
            localAccessPointConfiguration.verifyDomainName = "";
        }
        if (localAccessPointConfiguration.advancedConfig == null) {
            localAccessPointConfiguration.advancedConfig = new LocalAccessPointConfiguration.AdvancedConfigInfo();
        }
        return nativeSetLocalAccessPoint(this.mNativeHandle, localAccessPointConfiguration.ipList, localAccessPointConfiguration.domainList, localAccessPointConfiguration.verifyDomainName, localAccessPointConfiguration.mode, localAccessPointConfiguration.advancedConfig);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setLocalPublishFallbackOption(int i10) {
        return setParameter("rtc.local_publish_fallback_option", i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setLocalRenderMode(int i10) {
        return setRemoteRenderMode(0, i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setLocalVideoMirrorMode(int i10) {
        return nativeSetLocalVideoMirrorMode(this.mNativeHandle, i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setLocalVideoRenderer(IVideoSink iVideoSink) {
        int i10;
        if (iVideoSink == null) {
            i10 = 0;
        } else if (iVideoSink instanceof AgoraDefaultRender) {
            i10 = 1;
        } else {
            i10 = 2;
        }
        return nativeAddLocalVideoRender(this.mNativeHandle, iVideoSink, i10);
    }

    @Override // io.agora.rtc.RtcEngine
    @Deprecated
    public int setLocalVoiceChanger(int i10) {
        if (i10 == 0) {
            return setParameter("che.audio.morph.voice_changer", i10);
        }
        if (i10 > 0 && i10 < 1048576) {
            return setParameter("che.audio.morph.voice_changer", i10);
        }
        if (i10 > 1048576 && i10 < 2097152) {
            return setParameter("che.audio.morph.voice_changer", i10 - 1048570);
        }
        if (i10 > 2097152 && i10 < 3145728) {
            return setParameter("che.audio.morph.beauty_voice", i10 - 2097152);
        }
        return -2;
    }

    @Override // io.agora.rtc.RtcEngine
    public int setLocalVoiceEqualization(int i10, int i11) {
        return setParameterObject("che.audio.morph.equalization", formatString("{\"index\":%d,\"gain\":%d}", Integer.valueOf(i10), Integer.valueOf(i11)));
    }

    @Override // io.agora.rtc.RtcEngine
    public int setLocalVoicePitch(double d10) {
        return setParameter("che.audio.morph.pitch_shift", (int) (d10 * 100.0d));
    }

    @Override // io.agora.rtc.RtcEngine
    public int setLocalVoiceReverb(int i10, int i11) {
        return setParameterObject("che.audio.morph.reverb", formatString("{\"key\":%d,\"value\":%d}", Integer.valueOf(i10), Integer.valueOf(i11)));
    }

    @Override // io.agora.rtc.RtcEngine
    @Deprecated
    public int setLocalVoiceReverbPreset(int i10) {
        if (i10 == 0) {
            return setParameter("che.audio.morph.reverb_preset", i10);
        }
        if (i10 > 0 && i10 < 1048576) {
            return setParameter("che.audio.morph.reverb_preset", i10 + 8);
        }
        if (i10 > 1048576 && i10 < 2097152) {
            return setParameter("che.audio.morph.reverb_preset", i10 - com.amazonaws.services.s3.internal.Constants.MB);
        }
        if (i10 > 2097152 && i10 < 2097154) {
            return setParameter("che.audio.morph.virtual_stereo", i10 - 2097152);
        }
        if (i10 > 3145728 && i10 < 3145730) {
            return setParameterObject("che.audio.morph.electronic_voice", formatString("{\"key\":%d,\"value\":%d}", 1, 4));
        }
        if (i10 > 4194304 && i10 < 4194306) {
            return setParameter("che.audio.morph.threedim_voice", 10);
        }
        return -2;
    }

    @Override // io.agora.rtc.RtcEngine
    public int setLogFile(String str) {
        int parameter = setParameter("rtc.log_file", str);
        if (parameter == 0) {
            getParameters("[\"rtc.log_file\"]").equals(str);
        }
        return parameter;
    }

    @Override // io.agora.rtc.RtcEngine
    public int setLogFileSize(int i10) {
        return setParameter("rtc.log_size", i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setLogFilter(int i10) {
        return setParameter("rtc.log_filter", i10 & Constants.LOG_FILTER_DEBUG);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setLogWriter(ILogWriter iLogWriter) {
        return nativeSetLogWriter(this.mNativeHandle, iLogWriter);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setLowlightEnhanceOptions(boolean z10, LowLightEnhanceOptions lowLightEnhanceOptions) {
        if (lowLightEnhanceOptions == null) {
            if (z10) {
                return -2;
            }
            lowLightEnhanceOptions = new LowLightEnhanceOptions();
        }
        return nativeSetLowlightEnhanceOptions(this.mNativeHandle, z10, lowLightEnhanceOptions.lowlightEnhanceMode, lowLightEnhanceOptions.lowlightEnhanceLevel);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setMixedAudioFrameParameters(int i10, int i11) {
        return setParameterObject("che.audio.set_mixed_raw_audio_format", formatString("{\"sampleRate\":%d,\"samplesPerCall\":%d}", Integer.valueOf(i10), Integer.valueOf(i11)));
    }

    @Override // io.agora.rtc.RtcEngine
    public int setParameters(String str) {
        return nativeSetParameters(this.mNativeHandle, str);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setPlaybackAudioFrameParameters(int i10, int i11, int i12, int i13) {
        return setParameterObject("che.audio.set_render_raw_audio_format", formatString("{\"sampleRate\":%d,\"channelCnt\":%d,\"mode\":%d,\"samplesPerCall\":%d}", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)));
    }

    @Override // io.agora.rtc.RtcEngine
    @Deprecated
    public void setPreferHeadset(boolean z10) {
    }

    @Override // io.agora.rtc.RtcEngineEx
    public int setProfile(String str, boolean z10) {
        return nativeSetProfile(this.mNativeHandle, str, z10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setRecordingAudioFrameParameters(int i10, int i11, int i12, int i13) {
        return setParameterObject("che.audio.set_capture_raw_audio_format", formatString("{\"sampleRate\":%d,\"channelCnt\":%d,\"mode\":%d,\"samplesPerCall\":%d}", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)));
    }

    @Override // io.agora.rtc.RtcEngine
    public int setRemoteDefaultVideoStreamType(int i10) {
        return setParameter("rtc.video.set_remote_default_video_stream_type", i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setRemoteRenderMode(int i10, int i11) {
        return nativeSetRemoteRenderMode(this.mNativeHandle, (int) (i10 & 4294967295L), i11);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setRemoteSubscribeFallbackOption(int i10) {
        return setParameter("rtc.remote_subscribe_fallback_option", i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setRemoteUserPriority(int i10, int i11) {
        return nativeSetRemoteUserPriority(this.mNativeHandle, i10, i11);
    }

    @Override // io.agora.rtc.RtcEngine
    public synchronized int setRemoteUserSpatialAudioParams(int i10, SpatialAudioParams spatialAudioParams) {
        return nativeSetRemoteUserSpatialAudioParams(this.mNativeHandle, i10, spatialAudioParams);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setRemoteVideoRenderer(int i10, IVideoSink iVideoSink) {
        int i11;
        if (iVideoSink == null) {
            i11 = 0;
        } else if (iVideoSink instanceof AgoraDefaultRender) {
            i11 = 1;
        } else {
            i11 = 2;
        }
        return nativeAddRemoteVideoRender(this.mNativeHandle, i10, iVideoSink, i11);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setRemoteVideoStreamType(int i10, int i11) {
        long j10 = i10 & 4294967295L;
        return setParameters(formatString("{\"rtc.video.set_remote_video_stream\":{\"uid\":%d,\"stream\":%d},\"che.video.setstream\":{\"uid\":%d,\"stream\":%d}}", Long.valueOf(j10), Integer.valueOf(i11), Long.valueOf(j10), Integer.valueOf(i11)));
    }

    @Override // io.agora.rtc.RtcEngine
    public int setRemoteVoicePosition(int i10, double d10, double d11) {
        return setParameterObject("che.audio.game_place_sound_position", formatString("{\"uid\":%d,\"pan\":%f,\"gain\":%f}", Long.valueOf(i10 & 4294967295L), Double.valueOf(d10), Double.valueOf(d11)));
    }

    @Override // io.agora.rtc.RtcEngineEx
    public int setTextureId(int i10, EGLContext eGLContext, int i11, int i12, long j10) {
        return nativeSetEGL10TextureId(this.mNativeHandle, i10, eGLContext, 10, i11, i12, j10, sMatrix);
    }

    public int setTextureIdWithMatrix(int i10, EGLContext eGLContext, int i11, int i12, int i13, long j10, float[] fArr) {
        if (fArr == null) {
            return nativeSetEGL10TextureId(this.mNativeHandle, i10, eGLContext, i11, i12, i13, j10, sMatrix);
        }
        if (fArr.length < 16) {
            return -2;
        }
        return nativeSetEGL10TextureId(this.mNativeHandle, i10, eGLContext, i11, i12, i13, j10, fArr);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setVideoDenoiserOptions(boolean z10, VideoDenoiserOptions videoDenoiserOptions) {
        if (videoDenoiserOptions == null) {
            if (z10) {
                return -2;
            }
            videoDenoiserOptions = new VideoDenoiserOptions();
        }
        return nativeSetVideoDenoiserOptions(this.mNativeHandle, z10, videoDenoiserOptions.denoiserMode, videoDenoiserOptions.denoiserLevel);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setVideoEncoderConfiguration(VideoEncoderConfiguration videoEncoderConfiguration) {
        long j10 = this.mNativeHandle;
        VideoEncoderConfiguration.VideoDimensions videoDimensions = videoEncoderConfiguration.dimensions;
        return nativeSetVideoEncoderConfiguration(j10, videoDimensions.width, videoDimensions.height, videoEncoderConfiguration.frameRate, videoEncoderConfiguration.minFrameRate, videoEncoderConfiguration.bitrate, videoEncoderConfiguration.minBitrate, videoEncoderConfiguration.orientationMode.getValue(), videoEncoderConfiguration.degradationPrefer.getValue(), videoEncoderConfiguration.mirrorMode);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setVideoProfile(int i10, boolean z10) {
        if (i10 < 0) {
            return -2;
        }
        return setParameters(formatString("{\"rtc.video.profile\":[%d,%b]}", Integer.valueOf(i10), Boolean.valueOf(z10)));
    }

    @Override // io.agora.rtc.RtcEngine
    public int setVideoQualityParameters(boolean z10) {
        return setParameters(String.format("{\"rtc.video.prefer_frame_rate\":%b,\"che.video.prefer_frame_rate\":%b}", Boolean.valueOf(z10), Boolean.valueOf(z10)));
    }

    @Override // io.agora.rtc.RtcEngine
    public int setVideoSource(IVideoSource iVideoSource) {
        if (iVideoSource == null) {
            this.mVideoSourceType = 0;
        } else if (iVideoSource instanceof AgoraDefaultSource) {
            this.mVideoSourceType = 1;
        } else {
            this.mVideoSourceType = 2;
        }
        return nativeAddVideoCapturer(this.mNativeHandle, iVideoSource, this.mVideoSourceType);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setVoiceBeautifierParameters(int i10, int i11, int i12) {
        if (i10 != 16908544 && i10 != 16908800) {
            return -2;
        }
        return setParameterObject("che.audio.morph.beauty_sing", formatString("{\"key\":%d,\"value\":%d}", Integer.valueOf(i11), Integer.valueOf(i12)));
    }

    @Override // io.agora.rtc.RtcEngine
    public int setVoiceBeautifierPreset(int i10) {
        if (i10 == 0) {
            return setParameter("che.audio.morph.voice_changer", 0);
        }
        if (i10 == 16843008) {
            return setParameter("che.audio.morph.beauty_voice", 1);
        }
        if (i10 == 16843264) {
            return setParameter("che.audio.morph.beauty_voice", 2);
        }
        if (i10 == 16843520) {
            return setParameter("che.audio.morph.beauty_voice", 3);
        }
        if (i10 == 16908544) {
            return setParameterObject("che.audio.morph.beauty_sing", formatString("{\"key\":%d,\"value\":%d}", 1, 1));
        }
        if (i10 == 16908800) {
            return setParameterObject("che.audio.morph.beauty_sing", formatString("{\"key\":%d,\"value\":%d}", 2, 1));
        }
        if (i10 == 16974080) {
            return setParameter("che.audio.morph.voice_changer", 7);
        }
        if (i10 == 16974336) {
            return setParameter("che.audio.morph.voice_changer", 8);
        }
        if (i10 == 16974592) {
            return setParameter("che.audio.morph.voice_changer", 9);
        }
        if (i10 == 16974848) {
            return setParameter("che.audio.morph.voice_changer", 10);
        }
        if (i10 == 16975104) {
            return setParameter("che.audio.morph.voice_changer", 11);
        }
        if (i10 == 16975360) {
            return setParameter("che.audio.morph.voice_changer", 12);
        }
        if (i10 == 16975616) {
            return setParameter("che.audio.morph.voice_changer", 13);
        }
        if (i10 == 16975872) {
            return setParameter("che.audio.morph.voice_changer", 14);
        }
        return -2;
    }

    @Override // io.agora.rtc.RtcEngine
    public int setVoiceConversionPreset(int i10) {
        if (i10 == 0) {
            return setParameter("che.audio.morph.voice_changer", 0);
        }
        if (i10 == 50397440) {
            return setParameter("che.audio.morph.vocal_changer", 1);
        }
        if (i10 == 50397696) {
            return setParameter("che.audio.morph.vocal_changer", 2);
        }
        if (i10 == 50397952) {
            return setParameter("che.audio.morph.vocal_changer", 3);
        }
        if (i10 == 50398208) {
            return setParameter("che.audio.morph.vocal_changer", 4);
        }
        return -2;
    }

    @Override // io.agora.rtc.IAudioEffectManager
    public int setVolumeOfEffect(int i10, double d10) {
        return setParameterObject("che.audio.game_adjust_effect_volume", formatString("{\"soundId\":%d,\"gain\":%f}", Integer.valueOf(i10), Double.valueOf(d10)));
    }

    @Override // io.agora.rtc.RtcEngine
    public int setupLocalVideo(VideoCanvas videoCanvas) {
        checkIfInUIThread("setupLocalVideo");
        if (this.mVideoSourceType == 3) {
            return -1;
        }
        if (videoCanvas != null) {
            this.mUseLocalView = true;
            View view = videoCanvas.view;
            if (view != null && view.getClass().getName().equals(TextureView.class.getName())) {
                nativeSetupVideoLocal(this.mNativeHandle, new ViETextureViewWrapper((TextureView) videoCanvas.view), videoCanvas.renderMode, videoCanvas.mirrorMode);
            } else {
                nativeSetupVideoLocal(this.mNativeHandle, videoCanvas.view, videoCanvas.renderMode, videoCanvas.mirrorMode);
            }
        } else {
            this.mUseLocalView = false;
            nativeSetupVideoLocal(this.mNativeHandle, null, 1, 0);
        }
        return 0;
    }

    @Override // io.agora.rtc.RtcEngine
    public int setupRemoteVideo(VideoCanvas videoCanvas) {
        checkIfInUIThread("setupRemoteVideo");
        if (videoCanvas != null) {
            Object obj = videoCanvas.view;
            if (obj != null && obj.getClass().getName().equals(TextureView.class.getName())) {
                obj = new ViETextureViewWrapper((TextureView) videoCanvas.view);
            }
            Object obj2 = obj;
            String str = videoCanvas.channelId;
            if (str != null) {
                return nativeSetupVideoRemote(this.mNativeHandle, obj2, videoCanvas.renderMode, str, videoCanvas.uid, videoCanvas.mirrorMode);
            }
            return nativeSetupVideoRemote(this.mNativeHandle, obj2, videoCanvas.renderMode, "", videoCanvas.uid, videoCanvas.mirrorMode);
        }
        return -1;
    }

    @Override // io.agora.rtc.RtcEngine
    public int startAudioMixing(String str, boolean z10, boolean z11, int i10, int i11) {
        return setParameterObject("che.audio.start_file_as_playout", formatString("{\"filePath\":\"%s\", \"loopback\":%b, \"replace\":%b, \"cycle\":%d, \"startPos\": %d}", str, Boolean.valueOf(z10), Boolean.valueOf(z11), Integer.valueOf(i10), Integer.valueOf(i11)));
    }

    @Override // io.agora.rtc.RtcEngine
    public int startAudioRecording(String str, int i10) {
        return startAudioRecording(str, 32000, i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int startChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        if (channelMediaRelayConfiguration == null || channelMediaRelayConfiguration.getDestChannelMediaInfos().size() == 0 || channelMediaRelayConfiguration.getSrcChannelMediaInfo() == null) {
            return -2;
        }
        for (Map.Entry<String, ChannelMediaInfo> entry : channelMediaRelayConfiguration.getDestChannelMediaInfos().entrySet()) {
            if (entry.getValue().channelName == null || entry.getValue().channelName.length() == 0) {
                return -2;
            }
        }
        return nativeStartChannelMediaRelay(this.mNativeHandle, new RtcEngineMessage.PChannelMediaRelayConfiguration().marshall(channelMediaRelayConfiguration));
    }

    @Override // io.agora.rtc.RtcEngine
    public int startDumpVideoReceiveTrack(int i10, String str) {
        return nativeStartDumpVideoReceiveTrack(this.mNativeHandle, i10, str);
    }

    @Override // io.agora.rtc.RtcEngine
    public int startEchoTest() {
        Context context = this.mContext.get();
        if (context == null) {
            return -7;
        }
        doMonitorSystemEvent(context);
        return nativeStartEchoTest(this.mNativeHandle, null);
    }

    @Override // io.agora.rtc.RtcEngine
    public int startLastmileProbeTest(LastmileProbeConfig lastmileProbeConfig) {
        Context context = this.mContext.get();
        if (context == null) {
            return -7;
        }
        doMonitorSystemEvent(context);
        return nativeStartLastmileProbeTest(this.mNativeHandle, null, lastmileProbeConfig.probeUplink, lastmileProbeConfig.probeDownlink, lastmileProbeConfig.expectedUplinkBitrate, lastmileProbeConfig.expectedDownlinkBitrate);
    }

    @Override // io.agora.rtc.RtcEngine
    public int startPreview() {
        if (this.mVideoSourceType == 3) {
            return -4;
        }
        return nativeStartPreview(this.mNativeHandle);
    }

    public int startRecording(String str, int i10, int i11, int i12, int i13) {
        return nativeStartRecording(this.mNativeHandle, str, i10, i11, i12, i13);
    }

    @Override // io.agora.rtc.IAudioEffectManager
    public int startRhythmPlayer(String str, String str2, AgoraRhythmPlayerConfig agoraRhythmPlayerConfig) {
        return setParameterObject("che.audio.play_rhythm", formatString("{\"file1\":\"%s\",\"file2\":\"%s\",\"beatsPerMeasure\":%d, \"beatsPerMinute\":%d,\"publish\":%d}", str, str2, Integer.valueOf(agoraRhythmPlayerConfig.beatsPerMeasure), Integer.valueOf(agoraRhythmPlayerConfig.beatsPerMinute), Integer.valueOf(agoraRhythmPlayerConfig.publish ? 1 : 0)));
    }

    @Override // io.agora.rtc.RtcEngine
    public int startRtmpStreamWithTranscoding(String str, LiveTranscoding liveTranscoding) {
        if (liveTranscoding == null) {
            return -2;
        }
        return nativeStartRtmpStreamWithTranscoding(this.mNativeHandle, str, new RtcEngineMessage.PLiveTranscoding().marshall(liveTranscoding));
    }

    @Override // io.agora.rtc.RtcEngine
    public int startRtmpStreamWithoutTranscoding(String str) {
        return nativeStartRtmpStreamWithoutTranscoding(this.mNativeHandle, str);
    }

    @Override // io.agora.rtc.RtcEngine
    public int startScreenCapture(ScreenCaptureParameters screenCaptureParameters) {
        int i10;
        if (Build.VERSION.SDK_INT < 29 && screenCaptureParameters.captureAudio) {
            Logging.e("current android version not support for capture audio!, set enableSystemPlayoutAudio to false");
            screenCaptureParameters.captureAudio = false;
            if (!screenCaptureParameters.captureVideo) {
                Logging.e("both enableScreenCapture and enableSystemPlayoutAudio are false, return!!!");
                return 3;
            }
            i10 = 3;
        } else {
            i10 = 0;
        }
        try {
            try {
                Method method = Class.forName("io.agora.rtc.ss.ScreenSharingClient").getMethod("startScreenCapture", Context.class, RtcEngine.class, ScreenCaptureParameters.class, ExternalScreenSharingCallback.class);
                if (method == null) {
                    Logging.e("cannot find startScreenCapture method");
                    return 4;
                }
                if (screenCaptureParameters == null) {
                    Logging.i("screen capture parameter is null ,start screen capture using default parameters");
                    screenCaptureParameters = new ScreenCaptureParameters();
                }
                try {
                    method.invoke(null, this.mContext.get(), this, screenCaptureParameters, new ExternalScreenSharingCallback() { // from class: io.agora.rtc.internal.RtcEngineImpl.2
                        @Override // io.agora.rtc.internal.ExternalScreenSharingCallback
                        public void onExtenalScreenCaptureEvent(int i11, int i12) {
                            Iterator it = RtcEngineImpl.this.mRtcHandlers.keySet().iterator();
                            while (it.hasNext()) {
                                IRtcEngineEventHandler iRtcEngineEventHandler = (IRtcEngineEventHandler) it.next();
                                if (iRtcEngineEventHandler == null) {
                                    it.remove();
                                } else if (i12 == 16) {
                                    iRtcEngineEventHandler.onLocalVideoStateChanged(3, 16);
                                }
                            }
                        }
                    });
                    return i10;
                } catch (IllegalAccessException e10) {
                    e10.printStackTrace();
                    Logging.e("cannot start startScreenCapture method");
                    return 4;
                } catch (InvocationTargetException e11) {
                    e11.printStackTrace();
                    Logging.e("cannot start startScreenCapture method");
                    return 4;
                }
            } catch (NoSuchMethodException e12) {
                e12.printStackTrace();
                Logging.e("cannot find startScreenCapture method");
                return 4;
            }
        } catch (ClassNotFoundException e13) {
            e13.printStackTrace();
            Logging.e("Screen Sharing Module not found! ");
            return Constants.ERR_MODULE_NOT_FOUND;
        }
    }

    @Override // io.agora.rtc.IAudioEffectManager
    public int stopAllEffects() {
        return setParameter("che.audio.game_stop_all_effects", true);
    }

    public int stopAllRemoteVideo() {
        return setParameter("che.video.peer.stop_all_renders", true);
    }

    @Override // io.agora.rtc.RtcEngine
    public int stopAudioMixing() {
        return setParameter("che.audio.stop_file_as_playout", true);
    }

    @Override // io.agora.rtc.RtcEngine
    public int stopAudioRecording() {
        return nativeStopAudioRecording(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcEngine
    public int stopChannelMediaRelay() {
        return nativeStopChannelMediaRelay(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcEngine
    public int stopDumpVideoReceiveTrack() {
        return nativeStopDumpVideoReceiveTrack(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcEngine
    public int stopEchoTest() {
        return nativeStopEchoTest(this.mNativeHandle);
    }

    @Override // io.agora.rtc.IAudioEffectManager
    public int stopEffect(int i10) {
        return setParameter("che.audio.game_stop_effect", i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int stopLastmileProbeTest() {
        return nativeStopLastmileProbeTest(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcEngine
    public int stopPreview() {
        return setParameter("rtc.video.preview", false);
    }

    public int stopRecording() {
        return nativeStopRecording(this.mNativeHandle);
    }

    public int stopRemoteVideo(int i10) {
        return setParameter("che.video.peer.stop_video", i10 & 4294967295L);
    }

    @Override // io.agora.rtc.IAudioEffectManager
    public int stopRhythmPlayer() {
        return setParameter("che.audio.stop_rhythm", true);
    }

    @Override // io.agora.rtc.RtcEngine
    public int stopRtmpStream(String str) {
        return nativeStopRtmpStream(this.mNativeHandle, str);
    }

    @Override // io.agora.rtc.RtcEngine
    public int stopScreenCapture() {
        try {
            try {
                Method method = Class.forName("io.agora.rtc.ss.ScreenSharingClient").getMethod("stopScreenCapture", null);
                if (method == null) {
                    Logging.e("cannot find stopScreenCapture method");
                    return 4;
                }
                try {
                    method.invoke(null, null);
                    return 0;
                } catch (IllegalAccessException unused) {
                    Logging.e("cannot start stopScreenCapture method");
                    return 4;
                } catch (InvocationTargetException unused2) {
                    Logging.e("cannot start stopScreenCapture method");
                    return 4;
                }
            } catch (NoSuchMethodException unused3) {
                Logging.e("cannot find stopScreenCapture method");
                return 4;
            }
        } catch (ClassNotFoundException unused4) {
            Logging.e("Screen Sharing Module not found! ");
            return Constants.ERR_MODULE_NOT_FOUND;
        }
    }

    @Override // io.agora.rtc.RtcEngine
    public int switchCamera() {
        if (this.mVideoSourceType != 1) {
            return -1;
        }
        return nativeSwitchCamera(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcEngine
    public int switchChannel(String str, String str2) {
        ChannelMediaOptions channelMediaOptions = new ChannelMediaOptions();
        channelMediaOptions.autoSubscribeAudio = true;
        channelMediaOptions.autoSubscribeVideo = true;
        return switchChannel(str, str2, channelMediaOptions);
    }

    @Override // io.agora.rtc.RtcEngine
    public int takeSnapshot(String str, int i10, String str2) {
        return nativeTakeSnapshot(this.mNativeHandle, str, i10, str2);
    }

    @Override // io.agora.rtc.IAudioEffectManager
    public int unloadEffect(int i10) {
        return setParameter("che.audio.game_unload_effect", i10);
    }

    @Override // io.agora.rtc.RtcEngine
    public int updateChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        if (channelMediaRelayConfiguration == null || channelMediaRelayConfiguration.getDestChannelMediaInfos().size() == 0 || channelMediaRelayConfiguration.getSrcChannelMediaInfo() == null) {
            return -2;
        }
        for (Map.Entry<String, ChannelMediaInfo> entry : channelMediaRelayConfiguration.getDestChannelMediaInfos().entrySet()) {
            if (entry.getValue().channelName == null || entry.getValue().channelName.length() == 0) {
                return -2;
            }
        }
        return nativeUpdateChannelMediaRelay(this.mNativeHandle, new RtcEngineMessage.PChannelMediaRelayConfiguration().marshall(channelMediaRelayConfiguration));
    }

    public synchronized void updateRtcStats(RtcEngineMessage.PMediaResRtcStats pMediaResRtcStats) {
        IRtcEngineEventHandler.RtcStats rtcStats = getRtcStats();
        if (rtcStats == null) {
            return;
        }
        rtcStats.totalDuration = pMediaResRtcStats.totalDuration;
        rtcStats.txBytes = pMediaResRtcStats.totalTxBytes;
        rtcStats.rxBytes = pMediaResRtcStats.totalRxBytes;
        rtcStats.txAudioBytes = pMediaResRtcStats.txAudioBytes;
        rtcStats.txVideoBytes = pMediaResRtcStats.txVideoBytes;
        rtcStats.rxAudioBytes = pMediaResRtcStats.rxAudioBytes;
        rtcStats.rxVideoBytes = pMediaResRtcStats.rxVideoBytes;
        rtcStats.txKBitRate = pMediaResRtcStats.txKBitRate;
        rtcStats.rxKBitRate = pMediaResRtcStats.rxKBitRate;
        rtcStats.txAudioKBitRate = pMediaResRtcStats.txAudioKBitRate;
        rtcStats.rxAudioKBitRate = pMediaResRtcStats.rxAudioKBitRate;
        rtcStats.txVideoKBitRate = pMediaResRtcStats.txVideoKBitRate;
        rtcStats.rxVideoKBitRate = pMediaResRtcStats.rxVideoKBitRate;
        rtcStats.lastmileDelay = pMediaResRtcStats.lastmileDelay;
        rtcStats.txPacketLossRate = pMediaResRtcStats.txPacketLossRate;
        rtcStats.rxPacketLossRate = pMediaResRtcStats.rxPacketLossRate;
        rtcStats.users = pMediaResRtcStats.users;
        rtcStats.cpuTotalUsage = pMediaResRtcStats.cpuTotalUsage / 100.0d;
        rtcStats.cpuAppUsage = pMediaResRtcStats.cpuAppUsage / 100.0d;
        rtcStats.gatewayRtt = pMediaResRtcStats.gatewayRtt;
        rtcStats.memoryAppUsageRatio = pMediaResRtcStats.memoryAppUsageRatio;
        rtcStats.memoryTotalUsageRatio = pMediaResRtcStats.memoryTotalUsageRatio;
        rtcStats.memoryAppUsageInKbytes = pMediaResRtcStats.memoryAppUsageInKbytes;
    }

    @Override // io.agora.rtc.RtcEngine
    public int updateRtmpTranscoding(LiveTranscoding liveTranscoding) {
        if (liveTranscoding == null) {
            return -2;
        }
        return nativeUpdateRtmpTranscoding(this.mNativeHandle, new RtcEngineMessage.PLiveTranscoding().marshall(liveTranscoding));
    }

    @Override // io.agora.rtc.RtcEngine
    public int updateScreenCaptureParameters(boolean z10, boolean z11, ScreenCaptureParameters.VideoCaptureParameters videoCaptureParameters) {
        try {
            Class<?> cls = Class.forName("io.agora.rtc.ss.ScreenSharingClient");
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method method = cls.getMethod("updateScreenCaptureParameters", cls2, cls2, ScreenCaptureParameters.VideoCaptureParameters.class);
                if (method == null) {
                    Logging.e("cannot find stopScreenCapture method");
                    return 4;
                }
                if (!z11 && !z10) {
                    Logging.e("Both enableAudio and enableVideo are false , do you mean stopScreenCapture?");
                    return 2;
                }
                try {
                    method.invoke(null, Boolean.valueOf(z10), Boolean.valueOf(z11), videoCaptureParameters);
                    return 0;
                } catch (IllegalAccessException e10) {
                    e10.printStackTrace();
                    Logging.e("cannot start stopScreenCapture method");
                    return 4;
                } catch (InvocationTargetException e11) {
                    e11.printStackTrace();
                    Logging.e("cannot start stopScreenCapture method");
                    return 4;
                }
            } catch (NoSuchMethodException e12) {
                e12.printStackTrace();
                Logging.e("cannot find stopScreenCapture method");
                return 4;
            }
        } catch (ClassNotFoundException e13) {
            e13.printStackTrace();
            Logging.e("Screen Sharing Module not found! ");
            return Constants.ERR_MODULE_NOT_FOUND;
        }
    }

    @Override // io.agora.rtc.RtcEngineEx
    public int updateSharedContext(EGLContext eGLContext) {
        return nativeSetEGL10Context(this.mNativeHandle, eGLContext);
    }

    @Override // io.agora.rtc.RtcEngine
    public String uploadLogFile() {
        return nativeUploadLogFile(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcEngine
    public int useExternalAudioDevice() {
        return setParameters("{\"che.audio.audioSampleRate\":32000, \"che.audio.external_device\":true}");
    }

    private int setParameter(String str, int i10) {
        return setParameters(formatString("{\"%s\":%d}", str, Integer.valueOf(i10)));
    }

    @Override // io.agora.rtc.RtcEngine
    public int createDataStream(DataStreamConfig dataStreamConfig) {
        return nativeCreateDataStream2(this.mNativeHandle, dataStreamConfig.ordered, dataStreamConfig.syncWithAudio);
    }

    @Override // io.agora.rtc.RtcEngine
    public int enableRemoteSuperResolution(boolean z10, int i10, int i11) {
        return nativeEnableRemoteSuperResolution(this.mNativeHandle, z10, i10, i11);
    }

    @Override // io.agora.rtc.IAudioEffectManager
    @Deprecated
    public int playEffect(int i10, String str, int i11, double d10, double d11, double d12, boolean z10) {
        return playEffect(i10, str, i11, d10, d11, d12, z10, 0);
    }

    @Override // io.agora.rtc.RtcEngine
    public int pushExternalAudioFrame(byte[] bArr, long j10, int i10, int i11, int i12, int i13) {
        return nativePushExternalAudioFrameRawDataExt(this.mNativeHandle, bArr, j10, i10, i11, i12, i13);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setClientRole(int i10, ClientRoleOptions clientRoleOptions) {
        return nativeSetClientRoleOptions(this.mNativeHandle, i10, clientRoleOptions);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setLocalRenderMode(int i10, int i11) {
        return setRemoteRenderMode(0, i10, i11);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setRemoteRenderMode(int i10, int i11, int i12) {
        return nativeSetRemoteRenderModeWithMirrorMode(this.mNativeHandle, (int) (i10 & 4294967295L), i11, i12);
    }

    @Override // io.agora.rtc.RtcEngineEx
    public int setTextureId(int i10, android.opengl.EGLContext eGLContext, int i11, int i12, long j10) {
        return nativeSetEGL14TextureId(this.mNativeHandle, i10, eGLContext, 11, i11, i12, j10, sMatrix);
    }

    @Override // io.agora.rtc.RtcEngine
    public int setVideoProfile(int i10, int i11, int i12, int i13) {
        return nativeSetVideoProfileEx(this.mNativeHandle, i10, i11, i12, i13);
    }

    @Override // io.agora.rtc.RtcEngine
    @Deprecated
    public int startAudioMixing(String str, boolean z10, boolean z11, int i10) {
        return startAudioMixing(str, z10, z11, i10, 0);
    }

    @Override // io.agora.rtc.RtcEngine
    public int startAudioRecording(String str, int i10, int i11) {
        if (TextUtils.isEmpty(str)) {
            return -2;
        }
        return setParameterObject("che.audio.start_recording", formatString("{\"filePath\":\"%s\", \"sampleRate\":%d, \"quality\":%d}", str, Integer.valueOf(i10), Integer.valueOf(i11)));
    }

    @Override // io.agora.rtc.RtcEngineEx
    public int updateSharedContext(android.opengl.EGLContext eGLContext) {
        return nativeSetEGL14Context(this.mNativeHandle, eGLContext);
    }

    private int setParameter(String str, long j10) {
        return setParameters(formatString("{\"%s\":%d}", str, Long.valueOf(j10)));
    }

    private int switchCamera(CameraCapturerConfiguration.CAMERA_DIRECTION camera_direction) {
        if (this.mVideoSourceType != 1) {
            return -1;
        }
        return nativeSwitchCameraByDirection(this.mNativeHandle, camera_direction.getValue());
    }

    @Override // io.agora.rtc.IAudioEffectManager
    public int playEffect(int i10, String str, int i11, double d10, double d11, double d12, boolean z10, int i12) {
        return setParameterObject("che.audio.game_play_effect", formatString("{\"soundId\":%d,\"filePath\":\"%s\",\"loopCount\":%d, \"pitch\":%f,\"pan\":%f,\"gain\":%f, \"send2far\":%d, \"startPos\":%d}", Integer.valueOf(i10), str, Integer.valueOf(i11), Double.valueOf(d10), Double.valueOf(d11), Double.valueOf(d12), Integer.valueOf(z10 ? 1 : 0), Integer.valueOf(i12)));
    }

    private int setParameter(String str, double d10) {
        return setParameters(formatString("{\"%s\":%f}", str, Double.valueOf(d10)));
    }

    public int setTextureIdWithMatrix(int i10, android.opengl.EGLContext eGLContext, int i11, int i12, int i13, long j10, float[] fArr) {
        if (fArr == null) {
            return nativeSetEGL14TextureId(this.mNativeHandle, i10, eGLContext, i11, i12, i13, j10, sMatrix);
        }
        if (fArr.length < 16) {
            return -2;
        }
        return nativeSetEGL14TextureId(this.mNativeHandle, i10, eGLContext, i11, i12, i13, j10, fArr);
    }

    @Override // io.agora.rtc.RtcEngine
    public int startAudioRecording(AudioRecordingConfiguration audioRecordingConfiguration) {
        return nativeStartAudioRecording(this.mNativeHandle, audioRecordingConfiguration.filePath, audioRecordingConfiguration.recordingQuality, audioRecordingConfiguration.recordingPosition, audioRecordingConfiguration.recordingSampleRate, audioRecordingConfiguration.recordingChannel);
    }

    @Override // io.agora.rtc.RtcEngine
    public int startEchoTest(int i10) {
        Context context = this.mContext.get();
        if (context == null) {
            return -7;
        }
        doMonitorSystemEvent(context);
        return nativeStartEchoTestWithInterval(this.mNativeHandle, null, i10);
    }

    private int setParameter(String str, String str2) {
        return setParameters(formatString("{\"%s\":\"%s\"}", str, str2));
    }

    @Override // io.agora.rtc.RtcEngine
    public int switchChannel(String str, String str2, ChannelMediaOptions channelMediaOptions) {
        if (channelMediaOptions == null) {
            return -2;
        }
        return nativeSwitchChannel(this.mNativeHandle, str, str2, channelMediaOptions);
    }

    @Override // io.agora.rtc.RtcEngine
    public int joinChannelWithUserAccount(String str, String str2, String str3, ChannelMediaOptions channelMediaOptions) {
        if (channelMediaOptions == null) {
            return -2;
        }
        int nativeJoinChannelWithUserAccount = nativeJoinChannelWithUserAccount(this.mNativeHandle, str, str2, str3, channelMediaOptions);
        synchronized (this) {
            try {
                if (this.mDefaultRtcChannel == null) {
                    this.mDefaultRtcChannel = new RtcChannelImpl();
                }
                if (nativeJoinChannelWithUserAccount == 0) {
                    this.mDefaultRtcChannel.initialize(this, nativeGetDefaultRtcChannel(this.mNativeHandle));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nativeJoinChannelWithUserAccount;
    }

    @Override // io.agora.rtc.RtcEngine
    public int addVideoWatermark(String str, WatermarkOptions watermarkOptions) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        RtcEngineImpl rtcEngineImpl;
        if (str == null || TextUtils.isEmpty(str) || watermarkOptions == null) {
            return -2;
        }
        WatermarkOptions.Rectangle rectangle = watermarkOptions.positionInLandscapeMode;
        if (rectangle != null) {
            int i18 = rectangle.f١٤٩٥٥x;
            int i19 = rectangle.f١٤٩٥٦y;
            int i20 = rectangle.width;
            i13 = rectangle.height;
            i11 = i19;
            i12 = i20;
            i10 = i18;
        } else {
            i10 = 0;
            i11 = 0;
            i12 = 0;
            i13 = 0;
        }
        WatermarkOptions.Rectangle rectangle2 = watermarkOptions.positionInPortraitMode;
        if (rectangle2 != null) {
            int i21 = rectangle2.f١٤٩٥٥x;
            int i22 = rectangle2.f١٤٩٥٦y;
            int i23 = rectangle2.width;
            rtcEngineImpl = this;
            i17 = rectangle2.height;
            i14 = i21;
            i15 = i22;
            i16 = i23;
        } else {
            i14 = 0;
            i15 = 0;
            i16 = 0;
            i17 = 0;
            rtcEngineImpl = this;
        }
        return nativeAddVideoWatermark(rtcEngineImpl.mNativeHandle, str, watermarkOptions.visibleInPreview, i10, i11, i12, i13, i14, i15, i16, i17);
    }

    @Override // io.agora.rtc.RtcEngine
    public int startEchoTest(EchoTestConfiguration echoTestConfiguration) {
        Context context = this.mContext.get();
        if (context == null) {
            return -7;
        }
        String str = echoTestConfiguration.channelId;
        if (str == null || str.length() == 0) {
            return -2;
        }
        doMonitorSystemEvent(context);
        return nativeStartEchoTestWithConfig(this.mNativeHandle, echoTestConfiguration);
    }

    @Override // io.agora.rtc.RtcEngine
    public int joinChannel(String str, String str2, String str3, int i10, ChannelMediaOptions channelMediaOptions) {
        Context context = this.mContext.get();
        if (context == null) {
            return -7;
        }
        if (channelMediaOptions == null) {
            return -2;
        }
        doJoinChannelCheck(context);
        int nativeJoinChannel = nativeJoinChannel(this.mNativeHandle, null, str, str2, str3, i10, channelMediaOptions);
        synchronized (this) {
            try {
                if (this.mDefaultRtcChannel == null) {
                    this.mDefaultRtcChannel = new RtcChannelImpl();
                }
                if (nativeJoinChannel == 0) {
                    this.mDefaultRtcChannel.initialize(this, nativeGetDefaultRtcChannel(this.mNativeHandle));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nativeJoinChannel;
    }

    public RtcEngineImpl(RtcEngineConfig rtcEngineConfig) throws Exception {
        this.mNativeHandle = 0L;
        this.mContext = new WeakReference<>(rtcEngineConfig.mContext);
        addHandler(rtcEngineConfig.mEventHandler);
        this.mNativeHandle = nativeObjectInitWithConfig(rtcEngineConfig);
        initDeviceNotify(rtcEngineConfig.mContext);
        setParameter("che.android_app_external_storage_path", CommonUtility.getAppPrivateStorageDir(rtcEngineConfig.mContext));
        if (RtcEngine.externalLibPath != null) {
            setParameter("rtc.android_dynamic_loading", 1);
        }
    }
}
