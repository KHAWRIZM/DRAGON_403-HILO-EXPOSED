package io.agora.rtc;

import android.content.Context;
import android.view.SurfaceView;
import android.view.TextureView;
import io.agora.rtc.ScreenCaptureParameters;
import io.agora.rtc.audio.AudioRecordingConfiguration;
import io.agora.rtc.audio.SpatialAudioParams;
import io.agora.rtc.internal.DeviceUtils;
import io.agora.rtc.internal.EncryptionConfig;
import io.agora.rtc.internal.LastmileProbeConfig;
import io.agora.rtc.internal.RtcEngineImpl;
import io.agora.rtc.live.LiveInjectStreamConfig;
import io.agora.rtc.live.LiveTranscoding;
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
import io.agora.rtc.video.ChannelMediaRelayConfiguration;
import io.agora.rtc.video.ColorEnhanceOptions;
import io.agora.rtc.video.GLTextureView;
import io.agora.rtc.video.LowLightEnhanceOptions;
import io.agora.rtc.video.ViEAndroidGLES20;
import io.agora.rtc.video.ViETextureView;
import io.agora.rtc.video.VideoCanvas;
import io.agora.rtc.video.VideoDenoiserOptions;
import io.agora.rtc.video.VideoEncoderConfiguration;
import io.agora.rtc.video.VirtualBackgroundSource;
import io.agora.rtc.video.WatermarkOptions;
import java.io.File;
import java.security.InvalidParameterException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class RtcEngine {
    protected static String externalLibPath;
    private static RtcEngineImpl mInstance;

    public static SurfaceView CreateRendererView(Context context) {
        SurfaceView surfaceView;
        if (context != null && RtcEngineImpl.initializeNativeLibs()) {
            RtcEngineImpl.checkIfInUIThread("CreateRendererView");
            if (ViEAndroidGLES20.IsSupported(context)) {
                surfaceView = new ViEAndroidGLES20(context);
            } else {
                surfaceView = new SurfaceView(context);
            }
            surfaceView.setVisibility(0);
            return surfaceView;
        }
        return null;
    }

    public static TextureView CreateTextureView(Context context) {
        TextureView gLTextureView;
        if (context != null && RtcEngineImpl.initializeNativeLibs()) {
            RtcEngineImpl.checkIfInUIThread("CreateTextureView");
            if (ViETextureView.IsSupported(context)) {
                gLTextureView = new ViETextureView(context);
            } else {
                gLTextureView = new GLTextureView(context);
            }
            gLTextureView.setVisibility(0);
            return gLTextureView;
        }
        return null;
    }

    public static synchronized RtcEngine create(Context context, String str, IRtcEngineEventHandler iRtcEngineEventHandler) throws Exception {
        synchronized (RtcEngine.class) {
            if (context != null) {
                try {
                    if (RtcEngineImpl.initializeNativeLibs()) {
                        RtcEngineImpl rtcEngineImpl = mInstance;
                        if (rtcEngineImpl == null) {
                            mInstance = new RtcEngineImpl(context, str, iRtcEngineEventHandler);
                        } else {
                            rtcEngineImpl.reinitialize(context, str, iRtcEngineEventHandler);
                        }
                        return mInstance;
                    }
                } finally {
                }
            }
            return null;
        }
    }

    public static synchronized void destroy() {
        synchronized (RtcEngine.class) {
            RtcEngineImpl rtcEngineImpl = mInstance;
            if (rtcEngineImpl == null) {
                return;
            }
            rtcEngineImpl.doDestroy();
            mInstance = null;
            System.gc();
        }
    }

    public static String getErrorDescription(int i10) {
        if (!RtcEngineImpl.initializeNativeLibs()) {
            return "";
        }
        return RtcEngineImpl.nativeGetErrorDescription(i10);
    }

    @Deprecated
    public static String getMediaEngineVersion() {
        if (!RtcEngineImpl.initializeNativeLibs()) {
            return "";
        }
        return RtcEngineImpl.nativeGetChatEngineVersion();
    }

    @Deprecated
    public static int getRecommendedEncoderType() {
        return DeviceUtils.getRecommendedEncoderType();
    }

    public static String getSdkVersion() {
        if (!RtcEngineImpl.initializeNativeLibs()) {
            return "";
        }
        return RtcEngineImpl.nativeGetSdkVersion();
    }

    public static void setAgoraLibPath(String str) {
        if (new File(str).exists()) {
            externalLibPath = str;
            return;
        }
        throw new InvalidParameterException("RtcEngine.setLibraryPath path: " + str + " does not exist!");
    }

    public void addHandler(IRtcEngineEventHandler iRtcEngineEventHandler) {
        mInstance.addHandler(iRtcEngineEventHandler);
    }

    public abstract int addInjectStreamUrl(String str, LiveInjectStreamConfig liveInjectStreamConfig);

    public abstract int addPublishStreamUrl(String str, boolean z10);

    @Deprecated
    public abstract int addVideoWatermark(AgoraImage agoraImage);

    public abstract int addVideoWatermark(String str, WatermarkOptions watermarkOptions);

    public abstract int adjustAudioMixingPlayoutVolume(int i10);

    public abstract int adjustAudioMixingPublishVolume(int i10);

    public abstract int adjustAudioMixingVolume(int i10);

    public abstract int adjustPlaybackSignalVolume(int i10);

    public abstract int adjustRecordingSignalVolume(int i10);

    public abstract int adjustUserPlaybackSignalVolume(int i10, int i11);

    public abstract int clearVideoWatermarks();

    public abstract int complain(String str, String str2);

    public abstract int createDataStream(DataStreamConfig dataStreamConfig);

    public abstract int createDataStream(boolean z10, boolean z11);

    public abstract RtcChannel createRtcChannel(String str);

    public abstract int disableAudio();

    public abstract int disableLastmileTest();

    public abstract int disableVideo();

    public abstract int enableAudio();

    @Deprecated
    public abstract int enableAudioQualityIndication(boolean z10);

    public abstract int enableAudioVolumeIndication(int i10, int i11, boolean z10);

    public abstract int enableContentInspect(boolean z10, ContentInspectConfig contentInspectConfig);

    public abstract int enableDeepLearningDenoise(boolean z10);

    public abstract int enableDualStreamMode(boolean z10);

    public abstract int enableEncryption(boolean z10, EncryptionConfig encryptionConfig);

    public abstract int enableFaceDetection(boolean z10);

    @Deprecated
    public abstract boolean enableHighPerfWifiMode(boolean z10);

    public abstract int enableInEarMonitoring(boolean z10);

    public abstract int enableLastmileTest();

    public abstract int enableLocalAudio(boolean z10);

    public abstract int enableLocalVideo(boolean z10);

    public abstract int enableLocalVoicePitchCallback(int i10);

    public abstract int enableRemoteSuperResolution(int i10, boolean z10);

    public abstract int enableRemoteSuperResolution(boolean z10, int i10, int i11);

    public abstract int enableSoundPositionIndication(boolean z10);

    public abstract int enableSpatialAudio(boolean z10);

    public abstract int enableVideo();

    public abstract int enableVirtualBackground(boolean z10, VirtualBackgroundSource virtualBackgroundSource);

    @Deprecated
    public abstract int enableWebSdkInteroperability(boolean z10);

    public abstract int enableWirelessAccelerate(boolean z10);

    public abstract int getAudioDeviceLatency(int i10);

    public abstract IAudioEffectManager getAudioEffectManager();

    public abstract int getAudioFileInfo(String str);

    public abstract int getAudioMixingCurrentPosition();

    @Deprecated
    public abstract int getAudioMixingDuration();

    public abstract int getAudioMixingPlayoutVolume();

    public abstract int getAudioMixingPublishVolume();

    public abstract int getAudioTrackCount();

    public abstract String getCallId();

    public abstract float getCameraMaxZoomFactor();

    public abstract int getConnectionState();

    public abstract long getNativeHandle();

    public abstract String getParameter(String str, String str2);

    public abstract int getUserInfoByUid(int i10, UserInfo userInfo);

    public abstract int getUserInfoByUserAccount(String str, UserInfo userInfo);

    public abstract boolean isCameraAutoFocusFaceModeSupported();

    public abstract boolean isCameraExposurePositionSupported();

    public abstract boolean isCameraFocusSupported();

    public abstract boolean isCameraTorchSupported();

    public abstract boolean isCameraZoomSupported();

    public abstract boolean isSpeakerphoneEnabled();

    public abstract boolean isTextureEncodeSupported();

    public abstract int joinChannel(String str, String str2, String str3, int i10);

    public abstract int joinChannel(String str, String str2, String str3, int i10, ChannelMediaOptions channelMediaOptions);

    public abstract int joinChannelWithUserAccount(String str, String str2, String str3);

    public abstract int joinChannelWithUserAccount(String str, String str2, String str3, ChannelMediaOptions channelMediaOptions);

    public abstract int leaveChannel();

    @Deprecated
    public abstract void monitorBluetoothHeadsetEvent(boolean z10);

    @Deprecated
    public abstract void monitorHeadsetEvent(boolean z10);

    public abstract int muteAllRemoteAudioStreams(boolean z10);

    public abstract int muteAllRemoteVideoStreams(boolean z10);

    public abstract int muteLocalAudioStream(boolean z10);

    public abstract int muteLocalVideoStream(boolean z10);

    public abstract int muteRemoteAudioStream(int i10, boolean z10);

    public abstract int muteRemoteVideoStream(int i10, boolean z10);

    public abstract int pauseAllChannelMediaRelay();

    @Deprecated
    public abstract int pauseAudio();

    public abstract int pauseAudioMixing();

    public abstract int pullPlaybackAudioFrame(byte[] bArr, int i10);

    @Deprecated
    public abstract int pushExternalAudioFrame(byte[] bArr, long j10);

    public abstract int pushExternalAudioFrame(byte[] bArr, long j10, int i10, int i11, int i12, int i13);

    public abstract boolean pushExternalVideoFrame(AgoraVideoFrame agoraVideoFrame);

    public abstract int rate(String str, int i10, String str2);

    public abstract int registerAudioFrameObserver(IAudioFrameObserver iAudioFrameObserver);

    public abstract int registerLocalUserAccount(String str, String str2);

    public abstract int registerMediaMetadataObserver(IMetadataObserver iMetadataObserver, int i10);

    public abstract int registerVideoEncodedFrameObserver(IVideoEncodedFrameObserver iVideoEncodedFrameObserver);

    public abstract int registerVideoFrameObserver(IVideoFrameObserver iVideoFrameObserver);

    public abstract int releaseLogWriter();

    public void removeHandler(IRtcEngineEventHandler iRtcEngineEventHandler) {
        mInstance.removeHandler(iRtcEngineEventHandler);
    }

    public abstract int removeInjectStreamUrl(String str);

    public abstract int removePublishStreamUrl(String str);

    public abstract int renewToken(String str);

    public abstract int resumeAllChannelMediaRelay();

    @Deprecated
    public abstract int resumeAudio();

    public abstract int resumeAudioMixing();

    public abstract int selectAudioTrack(int i10);

    public abstract int sendCustomReportMessage(String str, String str2, String str3, String str4, int i10);

    public abstract int sendStreamMessage(int i10, byte[] bArr);

    public abstract int setAVSyncSource(String str, int i10);

    public abstract int setAudioEffectParameters(int i10, int i11, int i12);

    public abstract int setAudioEffectPreset(int i10);

    public abstract int setAudioMixingDualMonoMode(int i10);

    public abstract int setAudioMixingPitch(int i10);

    public abstract int setAudioMixingPlaybackSpeed(int i10);

    public abstract int setAudioMixingPosition(int i10);

    public abstract int setAudioProfile(int i10, int i11);

    public abstract int setBeautyEffectOptions(boolean z10, BeautyOptions beautyOptions);

    public abstract int setCameraAutoFocusFaceModeEnabled(boolean z10);

    public abstract int setCameraCaptureRotation(int i10);

    public abstract int setCameraCapturerConfiguration(CameraCapturerConfiguration cameraCapturerConfiguration);

    public abstract int setCameraExposurePosition(float f10, float f11);

    public abstract int setCameraFocusPositionInPreview(float f10, float f11);

    public abstract int setCameraTorchOn(boolean z10);

    public abstract int setCameraZoomFactor(float f10);

    public abstract int setChannelProfile(int i10);

    public abstract int setClientRole(int i10);

    public abstract int setClientRole(int i10, ClientRoleOptions clientRoleOptions);

    public abstract int setCloudProxy(int i10);

    public abstract int setColorEnhanceOptions(boolean z10, ColorEnhanceOptions colorEnhanceOptions);

    public abstract int setDefaultAudioRoutetoSpeakerphone(boolean z10);

    public abstract int setDefaultMuteAllRemoteAudioStreams(boolean z10);

    public abstract int setDefaultMuteAllRemoteVideoStreams(boolean z10);

    public abstract int setEnableSpeakerphone(boolean z10);

    @Deprecated
    public abstract int setEncryptionMode(String str);

    @Deprecated
    public abstract int setEncryptionSecret(String str);

    public abstract int setExternalAudioSink(boolean z10, int i10, int i11);

    public abstract int setExternalAudioSource(boolean z10, int i10, int i11);

    public abstract int setExternalAudioSourceVolume(int i10, int i11);

    public abstract void setExternalVideoSource(boolean z10, boolean z11, boolean z12);

    @Deprecated
    public abstract int setHighQualityAudioParameters(boolean z10, boolean z11, boolean z12);

    public abstract int setInEarMonitoringVolume(int i10);

    public abstract int setLiveTranscoding(LiveTranscoding liveTranscoding);

    public abstract int setLocalAccessPoint(LocalAccessPointConfiguration localAccessPointConfiguration);

    public abstract int setLocalPublishFallbackOption(int i10);

    @Deprecated
    public abstract int setLocalRenderMode(int i10);

    public abstract int setLocalRenderMode(int i10, int i11);

    @Deprecated
    public abstract int setLocalVideoMirrorMode(int i10);

    public abstract int setLocalVideoRenderer(IVideoSink iVideoSink);

    @Deprecated
    public abstract int setLocalVoiceChanger(int i10);

    public abstract int setLocalVoiceEqualization(int i10, int i11);

    public abstract int setLocalVoicePitch(double d10);

    public abstract int setLocalVoiceReverb(int i10, int i11);

    @Deprecated
    public abstract int setLocalVoiceReverbPreset(int i10);

    public abstract int setLogFile(String str);

    public abstract int setLogFileSize(int i10);

    public abstract int setLogFilter(int i10);

    public abstract int setLogWriter(ILogWriter iLogWriter);

    public abstract int setLowlightEnhanceOptions(boolean z10, LowLightEnhanceOptions lowLightEnhanceOptions);

    public abstract int setMixedAudioFrameParameters(int i10, int i11);

    public abstract int setParameters(String str);

    public abstract int setPlaybackAudioFrameParameters(int i10, int i11, int i12, int i13);

    @Deprecated
    public abstract void setPreferHeadset(boolean z10);

    public abstract int setRecordingAudioFrameParameters(int i10, int i11, int i12, int i13);

    public abstract int setRemoteDefaultVideoStreamType(int i10);

    @Deprecated
    public abstract int setRemoteRenderMode(int i10, int i11);

    public abstract int setRemoteRenderMode(int i10, int i11, int i12);

    public abstract int setRemoteSubscribeFallbackOption(int i10);

    public abstract int setRemoteUserPriority(int i10, int i11);

    public abstract int setRemoteUserSpatialAudioParams(int i10, SpatialAudioParams spatialAudioParams);

    public abstract int setRemoteVideoRenderer(int i10, IVideoSink iVideoSink);

    public abstract int setRemoteVideoStreamType(int i10, int i11);

    public abstract int setRemoteVoicePosition(int i10, double d10, double d11);

    public abstract int setVideoDenoiserOptions(boolean z10, VideoDenoiserOptions videoDenoiserOptions);

    public abstract int setVideoEncoderConfiguration(VideoEncoderConfiguration videoEncoderConfiguration);

    @Deprecated
    public abstract int setVideoProfile(int i10, int i11, int i12, int i13);

    @Deprecated
    public abstract int setVideoProfile(int i10, boolean z10);

    @Deprecated
    public abstract int setVideoQualityParameters(boolean z10);

    public abstract int setVideoSource(IVideoSource iVideoSource);

    public abstract int setVoiceBeautifierParameters(int i10, int i11, int i12);

    public abstract int setVoiceBeautifierPreset(int i10);

    public abstract int setVoiceConversionPreset(int i10);

    public abstract int setupLocalVideo(VideoCanvas videoCanvas);

    public abstract int setupRemoteVideo(VideoCanvas videoCanvas);

    @Deprecated
    public abstract int startAudioMixing(String str, boolean z10, boolean z11, int i10);

    public abstract int startAudioMixing(String str, boolean z10, boolean z11, int i10, int i11);

    public abstract int startAudioRecording(AudioRecordingConfiguration audioRecordingConfiguration);

    @Deprecated
    public abstract int startAudioRecording(String str, int i10);

    @Deprecated
    public abstract int startAudioRecording(String str, int i10, int i11);

    public abstract int startChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration);

    public abstract int startDumpVideoReceiveTrack(int i10, String str);

    @Deprecated
    public abstract int startEchoTest();

    public abstract int startEchoTest(int i10);

    public abstract int startEchoTest(EchoTestConfiguration echoTestConfiguration);

    public abstract int startLastmileProbeTest(LastmileProbeConfig lastmileProbeConfig);

    public abstract int startPreview();

    public abstract int startRtmpStreamWithTranscoding(String str, LiveTranscoding liveTranscoding);

    public abstract int startRtmpStreamWithoutTranscoding(String str);

    public abstract int startScreenCapture(ScreenCaptureParameters screenCaptureParameters);

    public abstract int stopAudioMixing();

    public abstract int stopAudioRecording();

    public abstract int stopChannelMediaRelay();

    public abstract int stopDumpVideoReceiveTrack();

    public abstract int stopEchoTest();

    public abstract int stopLastmileProbeTest();

    public abstract int stopPreview();

    public abstract int stopRtmpStream(String str);

    public abstract int stopScreenCapture();

    public abstract int switchCamera();

    public abstract int switchChannel(String str, String str2);

    public abstract int switchChannel(String str, String str2, ChannelMediaOptions channelMediaOptions);

    public abstract int takeSnapshot(String str, int i10, String str2);

    public abstract int updateChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration);

    public abstract int updateRtmpTranscoding(LiveTranscoding liveTranscoding);

    public abstract int updateScreenCaptureParameters(boolean z10, boolean z11, ScreenCaptureParameters.VideoCaptureParameters videoCaptureParameters);

    public abstract String uploadLogFile();

    @Deprecated
    public abstract int useExternalAudioDevice();

    public static synchronized RtcEngine create(RtcEngineConfig rtcEngineConfig) throws Exception {
        synchronized (RtcEngine.class) {
            if (rtcEngineConfig != null) {
                try {
                    if (rtcEngineConfig.mContext != null && RtcEngineImpl.initializeNativeLibs()) {
                        RtcEngineImpl rtcEngineImpl = mInstance;
                        if (rtcEngineImpl == null) {
                            mInstance = new RtcEngineImpl(rtcEngineConfig);
                        } else {
                            rtcEngineImpl.reinitialize(rtcEngineConfig.mContext, rtcEngineConfig.mAppId, rtcEngineConfig.mEventHandler);
                        }
                        return mInstance;
                    }
                } finally {
                }
            }
            return null;
        }
    }
}
