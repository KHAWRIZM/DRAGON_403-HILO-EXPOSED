package com.qiahao.nextvideo.agoraadapter;

import android.graphics.Bitmap;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import io.agora.rtc.IAudioEffectManager;
import io.agora.rtc.IAudioFrameObserver;
import io.agora.rtc.IMetadataObserver;
import io.agora.rtc.IRtcEngineEventHandler;
import io.agora.rtc.internal.LastmileProbeConfig;
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
import io.agora.rtc.video.VideoCanvas;
import io.agora.rtc.video.VideoEncoderConfiguration;
import io.agora.rtc.video.WatermarkOptions;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class BaseAdapterImpl implements IRTCEngine {
    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void ConnectOtherRoom(String str) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void DisconnectOtherRoom() {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public void addHandler(IRtcEngineEventHandler iRtcEngineEventHandler) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int addInjectStreamUrl(String str, LiveInjectStreamConfig liveInjectStreamConfig) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int addPublishStreamUrl(String str, boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int addVideoWatermark(AgoraImage agoraImage) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int adjustAudioMixingPlayoutVolume(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int adjustAudioMixingPublishVolume(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int adjustAudioMixingVolume(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int adjustPlaybackSignalVolume(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int adjustRecordingSignalVolume(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int clearVideoWatermarks() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int complain(String str, String str2) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int createDataStream(DataStreamConfig dataStreamConfig) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int disableAudio() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int disableLastmileTest() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int disableVideo() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableAudio() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableAudioQualityIndication(boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableAudioVolumeIndication(int i, int i2, boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableDeepLearningDenoise(boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableDualStreamMode(boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean enableHighPerfWifiMode(boolean z) {
        return false;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableInEarMonitoring(boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableLastmileTest() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableLocalAudio(boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableLocalVideo(boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableSoundPositionIndication(boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableVideo() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableWebSdkInteroperability(boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public IAudioEffectManager getAudioEffectManager() {
        return null;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int getAudioMixingCurrentPosition() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int getAudioMixingDuration() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int getAudioMixingPlayoutVolume() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int getAudioMixingPublishVolume() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public String getCallId() {
        return null;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public float getCameraMaxZoomFactor() {
        return 0.0f;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int getConnectionState() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public long getNativeHandle() {
        return 0L;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public String getParameter(String str, String str2) {
        return null;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int getUserInfoByUid(int i, UserInfo userInfo) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int getUserInfoByUserAccount(String str, UserInfo userInfo) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean isCameraAutoFocusFaceModeSupported() {
        return false;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean isCameraExposurePositionSupported() {
        return false;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean isCameraFocusSupported() {
        return false;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean isCameraTorchSupported() {
        return false;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean isCameraZoomSupported() {
        return false;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean isSpeakerphoneEnabled() {
        return false;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean isTextureEncodeSupported() {
        return false;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int joinChannel(String str, String str2, String str3, int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int joinChannelWithUserAccount(String str, String str2, String str3) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int leaveChannel() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public void monitorBluetoothHeadsetEvent(boolean z) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public void monitorHeadsetEvent(boolean z) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int muteAllRemoteAudioStreams(boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int muteAllRemoteVideoStreams(boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int muteLocalAudioStream(boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int muteLocalVideoStream(boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int muteRemoteAudioStream(int i, boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int muteRemoteVideoStream(int i, boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int pauseAllChannelMediaRelay() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int pauseAudio() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int pauseAudioMixing() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int pullPlaybackAudioFrame(byte[] bArr, int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int pushExternalAudioFrame(byte[] bArr, long j) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean pushExternalVideoFrame(AgoraVideoFrame agoraVideoFrame) {
        return false;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int rate(String str, int i, String str2) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int registerAudioFrameObserver(IAudioFrameObserver iAudioFrameObserver) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int registerLocalUserAccount(String str, String str2) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int registerMediaMetadataObserver(IMetadataObserver iMetadataObserver, int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public void removeHandler(IRtcEngineEventHandler iRtcEngineEventHandler) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int removeInjectStreamUrl(String str) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int removePublishStreamUrl(String str) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int renewToken(String str) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int resumeAllChannelMediaRelay() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int resumeAudio() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int resumeAudioMixing() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void selectMotionTmpl(String str) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int sendCustomReportMessage(String str, String str2, String str3, String str4, int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int sendStreamMessage(int i, byte[] bArr) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setAudioEffectParameters(int i, int i2, int i3) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setAudioMixingPitch(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setAudioMixingPosition(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setAudioProfile(int i, int i2) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setBeautyEffectOptions(boolean z, BeautyOptions beautyOptions) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setCameraAutoFocusFaceModeEnabled(boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setCameraCapturerConfiguration(CameraCapturerConfiguration cameraCapturerConfiguration) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setCameraExposurePosition(float f, float f2) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setCameraFocusPositionInPreview(float f, float f2) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setCameraTorchOn(boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setCameraZoomFactor(float f) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setChannelProfile(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setChinLevel(int i) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setClientRole(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setCloudProxy(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setDebugViewMargin(int i, TRTCCloud.TRTCViewMargin tRTCViewMargin) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setDefaultAudioRoutetoSpeakerphone(boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setDefaultMuteAllRemoteAudioStreams(boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setDefaultMuteAllRemoteVideoStreams(boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public void setEnableAiNoiseReduction(boolean z) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setEnableSpeakerphone(boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setEncryptionMode(String str) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setEncryptionSecret(String str) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setExternalAudioSink(boolean z, int i, int i2) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setExternalAudioSource(boolean z, int i, int i2) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public void setExternalVideoSource(boolean z, boolean z2, boolean z3) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setEyeScaleLevel(int i) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setFaceShortLevel(int i) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setFaceSlimLevel(int i) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setFaceVLevel(int i) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setFilter(Bitmap bitmap) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setFilterConcentration(float f) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setGSensorMode(int i) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public boolean setGreenScreenFile(String str) {
        return false;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setHighQualityAudioParameters(boolean z, boolean z2, boolean z3) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setInEarMonitoringVolume(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLiveTranscoding(LiveTranscoding liveTranscoding) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalPublishFallbackOption(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalRenderMode(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalVideoMirrorMode(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalVideoRenderer(IVideoSink iVideoSink) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setLocalViewRotation(int i) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalVoiceChanger(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalVoiceEqualization(int i, int i2) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalVoicePitch(double d) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalVoiceReverb(int i, int i2) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalVoiceReverbPreset(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLogFile(String str) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLogFileSize(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLogFilter(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setMixTranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setMixedAudioFrameParameters(int i, int i2) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setMotionMute(boolean z) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setNoseSlimLevel(int i) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setParameters(String str) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setPlaybackAudioFrameParameters(int i, int i2, int i3, int i4) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public void setPreferHeadset(boolean z) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRecordingAudioFrameParameters(int i, int i2, int i3, int i4) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteDefaultVideoStreamType(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteRenderMode(int i, int i2) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setRemoteSubStreamViewFillMode(int i, int i2) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteSubscribeFallbackOption(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteUserPriority(int i, int i2) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteVideoRenderer(int i, IVideoSink iVideoSink) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteVideoStreamType(int i, int i2) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteVoicePosition(int i, double d, double d2) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setVideoEncoderConfiguration(VideoEncoderConfiguration videoEncoderConfiguration) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setVideoEncoderMirror(boolean z) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setVideoProfile(int i, int i2, int i3, int i4) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setVideoQualityParameters(boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setVideoSource(IVideoSource iVideoSource) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setVoiceBeautifierParameters(int i, int i2, int i3) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setupLocalVideo(VideoCanvas videoCanvas) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setupRemoteVideo(VideoCanvas videoCanvas) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void showDebugView(int i) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startAudioMixing(String str, boolean z, boolean z2, int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startAudioRecording(String str, int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void startCdnPlayerWithUrl(String str, TXCloudVideoView tXCloudVideoView) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startDumpVideoReceiveTrack(int i, String str) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startEchoTest() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startLastmileProbeTest(LastmileProbeConfig lastmileProbeConfig) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startPreview() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void startRemoteSubStreamView(int i, TXCloudVideoView tXCloudVideoView) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startRtmpStreamWithTranscoding(String str, LiveTranscoding liveTranscoding) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopAudioMixing() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopAudioRecording() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void stopCdnPlayer() {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopChannelMediaRelay() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopDumpVideoReceiveTrack() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopEchoTest() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopLastmileProbeTest() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopPreview() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void stopRemoteSubStreamView(int i) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopRtmpStream(String str) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int switchCamera() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int switchChannel(String str, String str2) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int updateChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int updateRtmpTranscoding(LiveTranscoding liveTranscoding) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int useExternalAudioDevice() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int addVideoWatermark(String str, WatermarkOptions watermarkOptions) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int createDataStream(boolean z, boolean z2) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int joinChannel(String str, String str2, String str3, int i, ChannelMediaOptions channelMediaOptions) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int joinChannelWithUserAccount(String str, String str2, String str3, ChannelMediaOptions channelMediaOptions) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setClientRole(int i, ClientRoleOptions clientRoleOptions) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalRenderMode(int i, int i2) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteRenderMode(int i, int i2, int i3) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setVideoProfile(int i, boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startAudioMixing(String str, boolean z, boolean z2, int i, int i2) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startAudioRecording(String str, int i, int i2) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startEchoTest(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int switchChannel(String str, String str2, ChannelMediaOptions channelMediaOptions) {
        return 0;
    }
}
