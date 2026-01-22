package com.qiahao.nextvideo.agoraadapter;

import android.content.Context;
import android.util.Log;
import android.view.SurfaceView;
import io.agora.rtc.IAudioEffectManager;
import io.agora.rtc.IAudioFrameObserver;
import io.agora.rtc.IMetadataObserver;
import io.agora.rtc.IRtcEngineEventHandler;
import io.agora.rtc.RtcEngine;
import io.agora.rtc.internal.LastmileProbeConfig;
import io.agora.rtc.internal.RtcEngineImpl;
import io.agora.rtc.live.LiveInjectStreamConfig;
import io.agora.rtc.live.LiveTranscoding;
import io.agora.rtc.mediaio.IVideoSink;
import io.agora.rtc.mediaio.IVideoSource;
import io.agora.rtc.models.ChannelMediaOptions;
import io.agora.rtc.models.ClientRoleOptions;
import io.agora.rtc.models.DataStreamConfig;
import io.agora.rtc.models.UserInfo;
import io.agora.rtc.video.AgoraImage;
import io.agora.rtc.video.AgoraVideoFrame;
import io.agora.rtc.video.BeautyOptions;
import io.agora.rtc.video.CameraCapturerConfiguration;
import io.agora.rtc.video.ChannelMediaRelayConfiguration;
import io.agora.rtc.video.ViEAndroidGLES20;
import io.agora.rtc.video.VideoCanvas;
import io.agora.rtc.video.VideoEncoderConfiguration;
import io.agora.rtc.video.WatermarkOptions;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ARTCEngineAdapter extends BaseAdapterImpl {
    private static final String TAG = "ARTCEngineAdapter";
    private static ARTCEngineAdapter sInstance;
    private IRtcEngineEventHandler ARTCEventHandler;
    private RtcEngine ARtcEngine;

    public ARTCEngineAdapter(Context context, String str, IRTCEngineHandler iRTCEngineHandler) {
        this.ARtcEngine = null;
        RtcEngineEventHandlerImpl rtcEngineEventHandlerImpl = new RtcEngineEventHandlerImpl(iRTCEngineHandler);
        this.ARTCEventHandler = rtcEngineEventHandlerImpl;
        try {
            this.ARtcEngine = RtcEngine.create(context, str, rtcEngineEventHandlerImpl);
            setEnableAiNoiseReduction(true);
        } catch (Exception e) {
            Log.e(TAG, Log.getStackTraceString(e));
            throw new RuntimeException("NEED TO check rtc sdk init fatal error\n" + Log.getStackTraceString(e));
        }
    }

    public static SurfaceView CreateRendererView(Context context) {
        ViEAndroidGLES20 surfaceView;
        RtcEngineImpl.checkIfInUIThread("CreateRendererView");
        if (ViEAndroidGLES20.IsSupported(context)) {
            surfaceView = new ViEAndroidGLES20(context);
        } else {
            surfaceView = new SurfaceView(context);
        }
        surfaceView.setVisibility(0);
        return surfaceView;
    }

    public static ARTCEngineAdapter create(Context context, String str, IRTCEngineHandler iRTCEngineHandler) {
        if (sInstance == null) {
            sInstance = new ARTCEngineAdapter(context, str, iRTCEngineHandler);
        }
        return sInstance;
    }

    public static void destroy() {
        ARTCEngineAdapter aRTCEngineAdapter = sInstance;
        if (aRTCEngineAdapter != null) {
            aRTCEngineAdapter.uninit();
        }
        sInstance = null;
    }

    public static String getErrorDescription(int i) {
        return RtcEngine.getErrorDescription(i);
    }

    public static String getSDKVersion() {
        return RtcEngine.getSdkVersion();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public void addHandler(IRtcEngineEventHandler iRtcEngineEventHandler) {
        this.ARtcEngine.addHandler(iRtcEngineEventHandler);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int addInjectStreamUrl(String str, LiveInjectStreamConfig liveInjectStreamConfig) {
        return this.ARtcEngine.addInjectStreamUrl(str, liveInjectStreamConfig);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int addPublishStreamUrl(String str, boolean z) {
        return this.ARtcEngine.addPublishStreamUrl(str, z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int addVideoWatermark(AgoraImage agoraImage) {
        return this.ARtcEngine.addVideoWatermark(agoraImage);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int adjustAudioMixingPlayoutVolume(int i) {
        return this.ARtcEngine.adjustAudioMixingPlayoutVolume(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int adjustAudioMixingPublishVolume(int i) {
        return this.ARtcEngine.adjustAudioMixingPublishVolume(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int adjustAudioMixingVolume(int i) {
        return this.ARtcEngine.adjustAudioMixingVolume(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int adjustPlaybackSignalVolume(int i) {
        return this.ARtcEngine.adjustPlaybackSignalVolume(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int adjustRecordingSignalVolume(int i) {
        return this.ARtcEngine.adjustRecordingSignalVolume(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int clearVideoWatermarks() {
        return this.ARtcEngine.clearVideoWatermarks();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int complain(String str, String str2) {
        return this.ARtcEngine.complain(str, str2);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int createDataStream(DataStreamConfig dataStreamConfig) {
        return this.ARtcEngine.createDataStream(dataStreamConfig);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int disableAudio() {
        return this.ARtcEngine.disableAudio();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int disableLastmileTest() {
        return this.ARtcEngine.disableLastmileTest();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int disableVideo() {
        return this.ARtcEngine.disableVideo();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableAudio() {
        return this.ARtcEngine.enableAudio();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableAudioQualityIndication(boolean z) {
        return this.ARtcEngine.enableAudioQualityIndication(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableAudioVolumeIndication(int i, int i2, boolean z) {
        return this.ARtcEngine.enableAudioVolumeIndication(i, i2, z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableDeepLearningDenoise(boolean z) {
        return this.ARtcEngine.enableDeepLearningDenoise(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableDualStreamMode(boolean z) {
        return this.ARtcEngine.enableDualStreamMode(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean enableHighPerfWifiMode(boolean z) {
        return this.ARtcEngine.enableHighPerfWifiMode(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableInEarMonitoring(boolean z) {
        return this.ARtcEngine.enableInEarMonitoring(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableLastmileTest() {
        return this.ARtcEngine.enableLastmileTest();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableLocalAudio(boolean z) {
        return this.ARtcEngine.enableLocalAudio(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableLocalVideo(boolean z) {
        return this.ARtcEngine.enableLocalVideo(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableSoundPositionIndication(boolean z) {
        return this.ARtcEngine.enableSoundPositionIndication(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableVideo() {
        return this.ARtcEngine.enableVideo();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableWebSdkInteroperability(boolean z) {
        return this.ARtcEngine.enableWebSdkInteroperability(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public IAudioEffectManager getAudioEffectManager() {
        return this.ARtcEngine.getAudioEffectManager();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int getAudioMixingCurrentPosition() {
        return this.ARtcEngine.getAudioMixingCurrentPosition();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int getAudioMixingDuration() {
        return this.ARtcEngine.getAudioMixingDuration();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int getAudioMixingPlayoutVolume() {
        return this.ARtcEngine.getAudioMixingPlayoutVolume();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int getAudioMixingPublishVolume() {
        return this.ARtcEngine.getAudioMixingPublishVolume();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public String getCallId() {
        return this.ARtcEngine.getCallId();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public float getCameraMaxZoomFactor() {
        return this.ARtcEngine.getCameraMaxZoomFactor();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int getConnectionState() {
        return this.ARtcEngine.getConnectionState();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public long getNativeHandle() {
        return this.ARtcEngine.getNativeHandle();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public String getParameter(String str, String str2) {
        return this.ARtcEngine.getParameter(str, str2);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int getUserInfoByUid(int i, UserInfo userInfo) {
        return this.ARtcEngine.getUserInfoByUid(i, userInfo);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int getUserInfoByUserAccount(String str, UserInfo userInfo) {
        return this.ARtcEngine.getUserInfoByUserAccount(str, userInfo);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean isCameraAutoFocusFaceModeSupported() {
        return this.ARtcEngine.isCameraAutoFocusFaceModeSupported();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean isCameraExposurePositionSupported() {
        return this.ARtcEngine.isCameraExposurePositionSupported();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean isCameraFocusSupported() {
        return this.ARtcEngine.isCameraFocusSupported();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean isCameraTorchSupported() {
        return this.ARtcEngine.isCameraTorchSupported();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean isCameraZoomSupported() {
        return this.ARtcEngine.isCameraZoomSupported();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean isSpeakerphoneEnabled() {
        return this.ARtcEngine.isSpeakerphoneEnabled();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean isTextureEncodeSupported() {
        return this.ARtcEngine.isTextureEncodeSupported();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int joinChannel(String str, String str2, String str3, int i, ChannelMediaOptions channelMediaOptions) {
        return this.ARtcEngine.joinChannel(str, str2, str3, i, channelMediaOptions);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int joinChannelWithUserAccount(String str, String str2, String str3, ChannelMediaOptions channelMediaOptions) {
        return this.ARtcEngine.joinChannelWithUserAccount(str, str2, str3, channelMediaOptions);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int leaveChannel() {
        return this.ARtcEngine.leaveChannel();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public void monitorBluetoothHeadsetEvent(boolean z) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public void monitorHeadsetEvent(boolean z) {
        this.ARtcEngine.monitorHeadsetEvent(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int muteAllRemoteAudioStreams(boolean z) {
        return this.ARtcEngine.muteAllRemoteAudioStreams(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int muteAllRemoteVideoStreams(boolean z) {
        return this.ARtcEngine.muteAllRemoteVideoStreams(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int muteLocalAudioStream(boolean z) {
        return this.ARtcEngine.muteLocalAudioStream(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int muteLocalVideoStream(boolean z) {
        return this.ARtcEngine.muteLocalVideoStream(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int muteRemoteAudioStream(int i, boolean z) {
        return this.ARtcEngine.muteRemoteAudioStream(i, z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int muteRemoteVideoStream(int i, boolean z) {
        return this.ARtcEngine.muteRemoteVideoStream(i, z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int pauseAllChannelMediaRelay() {
        return this.ARtcEngine.pauseAllChannelMediaRelay();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int pauseAudio() {
        return this.ARtcEngine.pauseAudio();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int pauseAudioMixing() {
        return this.ARtcEngine.pauseAudioMixing();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int pullPlaybackAudioFrame(byte[] bArr, int i) {
        return this.ARtcEngine.pullPlaybackAudioFrame(bArr, i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int pushExternalAudioFrame(byte[] bArr, long j) {
        return this.ARtcEngine.pushExternalAudioFrame(bArr, j);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean pushExternalVideoFrame(AgoraVideoFrame agoraVideoFrame) {
        return this.ARtcEngine.pushExternalVideoFrame(agoraVideoFrame);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int rate(String str, int i, String str2) {
        return this.ARtcEngine.rate(str, i, str2);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int registerAudioFrameObserver(IAudioFrameObserver iAudioFrameObserver) {
        return this.ARtcEngine.registerAudioFrameObserver(iAudioFrameObserver);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int registerLocalUserAccount(String str, String str2) {
        return this.ARtcEngine.registerLocalUserAccount(str, str2);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int registerMediaMetadataObserver(IMetadataObserver iMetadataObserver, int i) {
        return this.ARtcEngine.registerMediaMetadataObserver(iMetadataObserver, i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public void removeHandler(IRtcEngineEventHandler iRtcEngineEventHandler) {
        this.ARtcEngine.removeHandler(iRtcEngineEventHandler);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int removeInjectStreamUrl(String str) {
        return this.ARtcEngine.removeInjectStreamUrl(str);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int removePublishStreamUrl(String str) {
        return this.ARtcEngine.removePublishStreamUrl(str);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int renewToken(String str) {
        return this.ARtcEngine.renewToken(str);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int resumeAllChannelMediaRelay() {
        return this.ARtcEngine.resumeAllChannelMediaRelay();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int resumeAudio() {
        return this.ARtcEngine.resumeAudio();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int resumeAudioMixing() {
        return this.ARtcEngine.resumeAudioMixing();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int sendCustomReportMessage(String str, String str2, String str3, String str4, int i) {
        return this.ARtcEngine.sendCustomReportMessage(str, str2, str3, str4, i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int sendStreamMessage(int i, byte[] bArr) {
        return this.ARtcEngine.sendStreamMessage(i, bArr);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setAudioEffectParameters(int i, int i2, int i3) {
        return this.ARtcEngine.setAudioEffectParameters(i, i2, i3);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setAudioMixingPitch(int i) {
        return this.ARtcEngine.setAudioMixingPitch(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setAudioMixingPosition(int i) {
        return this.ARtcEngine.setAudioMixingPosition(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setAudioProfile(int i, int i2) {
        return this.ARtcEngine.setAudioProfile(i, i2);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setBeautyEffectOptions(boolean z, BeautyOptions beautyOptions) {
        return this.ARtcEngine.setBeautyEffectOptions(z, beautyOptions);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setCameraAutoFocusFaceModeEnabled(boolean z) {
        return this.ARtcEngine.setCameraAutoFocusFaceModeEnabled(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setCameraCapturerConfiguration(CameraCapturerConfiguration cameraCapturerConfiguration) {
        return this.ARtcEngine.setCameraCapturerConfiguration(cameraCapturerConfiguration);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setCameraExposurePosition(float f, float f2) {
        return this.ARtcEngine.setCameraExposurePosition(f, f2);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setCameraFocusPositionInPreview(float f, float f2) {
        return this.ARtcEngine.setCameraFocusPositionInPreview(f, f2);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setCameraTorchOn(boolean z) {
        return this.ARtcEngine.setCameraTorchOn(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setCameraZoomFactor(float f) {
        return this.ARtcEngine.setCameraZoomFactor(f);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setChannelProfile(int i) {
        return this.ARtcEngine.setChannelProfile(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setClientRole(int i, ClientRoleOptions clientRoleOptions) {
        return this.ARtcEngine.setClientRole(i, clientRoleOptions);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setCloudProxy(int i) {
        return this.ARtcEngine.setCloudProxy(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setDefaultAudioRoutetoSpeakerphone(boolean z) {
        return this.ARtcEngine.setDefaultAudioRoutetoSpeakerphone(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setDefaultMuteAllRemoteAudioStreams(boolean z) {
        return this.ARtcEngine.setDefaultMuteAllRemoteAudioStreams(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setDefaultMuteAllRemoteVideoStreams(boolean z) {
        return this.ARtcEngine.setDefaultMuteAllRemoteVideoStreams(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public void setEnableAiNoiseReduction(boolean z) {
        if (z) {
            this.ARtcEngine.setParameters("{\"che.audio.set_apm_para\":{\"function\":\"sw_ans\",\"param\":[{\"force\": false,\"enable\":false}]}}");
            this.ARtcEngine.setParameters("{\"che.audio.enable.nsng\":true}");
            this.ARtcEngine.setParameters("{\"che.audio.ains_mode\":2}");
            this.ARtcEngine.setParameters("{\"che.audio.ns.mode\":2}");
            this.ARtcEngine.setParameters("{\"che.audio.nsng.lowerBound\":10}");
            this.ARtcEngine.setParameters("{\"che.audio.nsng.lowerMask\":10}");
            this.ARtcEngine.setParameters("{\"che.audio.nsng.statisticalbound\":0}");
            this.ARtcEngine.setParameters("{\"che.audio.nsng.finallowermask\":8}");
            this.ARtcEngine.setParameters("{\"che.audio.set_apm_para\": {\"function\": \"music_detection\", \"param\": [{\"force\": true, \"enable\": false}]}}");
            return;
        }
        this.ARtcEngine.setParameters("{\"che.audio.ains_mode\":0}");
        this.ARtcEngine.setParameters("{\"che.audio.ns.mode\":0}");
        this.ARtcEngine.setParameters("{\"che.audio.nsng.lowerBound\":80}");
        this.ARtcEngine.setParameters("{\"che.audio.nsng.lowerMask\":50}");
        this.ARtcEngine.setParameters("{\"che.audio.nsng.statisticalbound\":5}");
        this.ARtcEngine.setParameters("{\"che.audio.nsng.finallowermask\":30}");
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setEnableSpeakerphone(boolean z) {
        return this.ARtcEngine.setEnableSpeakerphone(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setEncryptionMode(String str) {
        return this.ARtcEngine.setEncryptionMode(str);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setEncryptionSecret(String str) {
        return this.ARtcEngine.setEncryptionSecret(str);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setExternalAudioSink(boolean z, int i, int i2) {
        return this.ARtcEngine.setExternalAudioSink(z, i, i2);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setExternalAudioSource(boolean z, int i, int i2) {
        return this.ARtcEngine.setExternalAudioSource(z, i, i2);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public void setExternalVideoSource(boolean z, boolean z2, boolean z3) {
        this.ARtcEngine.setExternalVideoSource(z, z2, z3);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setHighQualityAudioParameters(boolean z, boolean z2, boolean z3) {
        return this.ARtcEngine.setHighQualityAudioParameters(z, z2, z3);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setInEarMonitoringVolume(int i) {
        return this.ARtcEngine.setInEarMonitoringVolume(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLiveTranscoding(LiveTranscoding liveTranscoding) {
        return this.ARtcEngine.setLiveTranscoding(liveTranscoding);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalPublishFallbackOption(int i) {
        return this.ARtcEngine.setLocalPublishFallbackOption(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalRenderMode(int i, int i2) {
        return this.ARtcEngine.setLocalRenderMode(i, i2);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalVideoMirrorMode(int i) {
        return this.ARtcEngine.setLocalVideoMirrorMode(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalVideoRenderer(IVideoSink iVideoSink) {
        return this.ARtcEngine.setLocalVideoRenderer(iVideoSink);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalVoiceChanger(int i) {
        return this.ARtcEngine.setLocalVoiceChanger(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalVoiceEqualization(int i, int i2) {
        return this.ARtcEngine.setLocalVoiceEqualization(i, i2);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalVoicePitch(double d) {
        return this.ARtcEngine.setLocalVoicePitch(d);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalVoiceReverb(int i, int i2) {
        return this.ARtcEngine.setLocalVoiceReverb(i, i2);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalVoiceReverbPreset(int i) {
        return this.ARtcEngine.setLocalVoiceReverbPreset(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLogFile(String str) {
        return this.ARtcEngine.setLogFile(str);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLogFileSize(int i) {
        return this.ARtcEngine.setLogFileSize(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLogFilter(int i) {
        return this.ARtcEngine.setLogFilter(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setMixedAudioFrameParameters(int i, int i2) {
        return this.ARtcEngine.setMixedAudioFrameParameters(i, i2);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setParameters(String str) {
        return this.ARtcEngine.setParameters(str);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setPlaybackAudioFrameParameters(int i, int i2, int i3, int i4) {
        return this.ARtcEngine.setPlaybackAudioFrameParameters(i, i2, i3, i4);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public void setPreferHeadset(boolean z) {
        this.ARtcEngine.setPreferHeadset(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRecordingAudioFrameParameters(int i, int i2, int i3, int i4) {
        return this.ARtcEngine.setRecordingAudioFrameParameters(i, i2, i3, i4);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteDefaultVideoStreamType(int i) {
        return this.ARtcEngine.setRemoteDefaultVideoStreamType(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteRenderMode(int i, int i2, int i3) {
        return this.ARtcEngine.setRemoteRenderMode(i, i2, i3);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteSubscribeFallbackOption(int i) {
        return this.ARtcEngine.setRemoteSubscribeFallbackOption(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteUserPriority(int i, int i2) {
        return this.ARtcEngine.setRemoteUserPriority(i, i2);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteVideoRenderer(int i, IVideoSink iVideoSink) {
        return this.ARtcEngine.setRemoteVideoRenderer(i, iVideoSink);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteVideoStreamType(int i, int i2) {
        return this.ARtcEngine.setRemoteVideoStreamType(i, i2);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteVoicePosition(int i, double d, double d2) {
        return this.ARtcEngine.setRemoteVoicePosition(i, d, d2);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setVideoEncoderConfiguration(VideoEncoderConfiguration videoEncoderConfiguration) {
        return this.ARtcEngine.setVideoEncoderConfiguration(videoEncoderConfiguration);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setVideoProfile(int i, boolean z) {
        return this.ARtcEngine.setVideoProfile(i, z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setVideoQualityParameters(boolean z) {
        return this.ARtcEngine.setVideoQualityParameters(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setVideoSource(IVideoSource iVideoSource) {
        return this.ARtcEngine.setVideoSource(iVideoSource);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setVoiceBeautifierParameters(int i, int i2, int i3) {
        return this.ARtcEngine.setVoiceBeautifierParameters(i, i2, i3);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setupLocalVideo(VideoCanvas videoCanvas) {
        return this.ARtcEngine.setupLocalVideo(videoCanvas);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setupRemoteVideo(VideoCanvas videoCanvas) {
        return this.ARtcEngine.setupRemoteVideo(videoCanvas);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startAudioMixing(String str, boolean z, boolean z2, int i) {
        return this.ARtcEngine.startAudioMixing(str, z, z2, i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startAudioRecording(String str, int i) {
        return this.ARtcEngine.startAudioRecording(str, i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        return this.ARtcEngine.startChannelMediaRelay(channelMediaRelayConfiguration);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startDumpVideoReceiveTrack(int i, String str) {
        return this.ARtcEngine.startDumpVideoReceiveTrack(i, str);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startEchoTest() {
        return this.ARtcEngine.startEchoTest();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startLastmileProbeTest(LastmileProbeConfig lastmileProbeConfig) {
        return this.ARtcEngine.startLastmileProbeTest(lastmileProbeConfig);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startPreview() {
        return this.ARtcEngine.startPreview();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startRtmpStreamWithTranscoding(String str, LiveTranscoding liveTranscoding) {
        return this.ARtcEngine.startRtmpStreamWithTranscoding(str, liveTranscoding);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopAudioMixing() {
        return this.ARtcEngine.stopAudioMixing();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopAudioRecording() {
        return this.ARtcEngine.stopAudioRecording();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopChannelMediaRelay() {
        return this.ARtcEngine.stopChannelMediaRelay();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopDumpVideoReceiveTrack() {
        return this.ARtcEngine.stopDumpVideoReceiveTrack();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopEchoTest() {
        return this.ARtcEngine.stopEchoTest();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopLastmileProbeTest() {
        return this.ARtcEngine.stopLastmileProbeTest();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopPreview() {
        return this.ARtcEngine.stopPreview();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopRtmpStream(String str) {
        return this.ARtcEngine.stopRtmpStream(str);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int switchCamera() {
        return this.ARtcEngine.switchCamera();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int switchChannel(String str, String str2, ChannelMediaOptions channelMediaOptions) {
        return this.ARtcEngine.switchChannel(str, str2, channelMediaOptions);
    }

    public void uninit() {
        RtcEngine.destroy();
        this.ARTCEventHandler = null;
        this.ARtcEngine = null;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int updateChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        return this.ARtcEngine.updateChannelMediaRelay(channelMediaRelayConfiguration);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int updateRtmpTranscoding(LiveTranscoding liveTranscoding) {
        return this.ARtcEngine.updateRtmpTranscoding(liveTranscoding);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int useExternalAudioDevice() {
        return this.ARtcEngine.useExternalAudioDevice();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int addVideoWatermark(String str, WatermarkOptions watermarkOptions) {
        return this.ARtcEngine.addVideoWatermark(str, watermarkOptions);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int createDataStream(boolean z, boolean z2) {
        return this.ARtcEngine.createDataStream(z, z2);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int joinChannel(String str, String str2, String str3, int i) {
        return this.ARtcEngine.joinChannel(str, str2, str3, i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int joinChannelWithUserAccount(String str, String str2, String str3) {
        return this.ARtcEngine.joinChannelWithUserAccount(str, str2, str3);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setClientRole(int i) {
        return this.ARtcEngine.setClientRole(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalRenderMode(int i) {
        return this.ARtcEngine.setLocalRenderMode(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteRenderMode(int i, int i2) {
        return this.ARtcEngine.setRemoteRenderMode(i, i2);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setVideoProfile(int i, int i2, int i3, int i4) {
        return this.ARtcEngine.setVideoProfile(i, i2, i3, i4);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startAudioRecording(String str, int i, int i2) {
        return this.ARtcEngine.startAudioRecording(str, i, i2);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startEchoTest(int i) {
        return this.ARtcEngine.startEchoTest(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int switchChannel(String str, String str2) {
        return this.ARtcEngine.switchChannel(str, str2);
    }
}
