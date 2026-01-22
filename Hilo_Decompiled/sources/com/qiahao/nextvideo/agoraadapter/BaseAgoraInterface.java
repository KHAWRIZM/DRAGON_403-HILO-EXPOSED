package com.qiahao.nextvideo.agoraadapter;

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
public interface BaseAgoraInterface {
    void addHandler(IRtcEngineEventHandler iRtcEngineEventHandler);

    int addInjectStreamUrl(String str, LiveInjectStreamConfig liveInjectStreamConfig);

    int addPublishStreamUrl(String str, boolean z);

    @Deprecated
    int addVideoWatermark(AgoraImage agoraImage);

    int addVideoWatermark(String str, WatermarkOptions watermarkOptions);

    int adjustAudioMixingPlayoutVolume(int i);

    int adjustAudioMixingPublishVolume(int i);

    int adjustAudioMixingVolume(int i);

    int adjustPlaybackSignalVolume(int i);

    int adjustRecordingSignalVolume(int i);

    int clearVideoWatermarks();

    int complain(String str, String str2);

    int createDataStream(DataStreamConfig dataStreamConfig);

    @Deprecated
    int createDataStream(boolean z, boolean z2);

    int disableAudio();

    int disableLastmileTest();

    int disableVideo();

    int enableAudio();

    @Deprecated
    int enableAudioQualityIndication(boolean z);

    int enableAudioVolumeIndication(int i, int i2, boolean z);

    int enableDeepLearningDenoise(boolean z);

    int enableDualStreamMode(boolean z);

    @Deprecated
    boolean enableHighPerfWifiMode(boolean z);

    int enableInEarMonitoring(boolean z);

    int enableLastmileTest();

    int enableLocalAudio(boolean z);

    int enableLocalVideo(boolean z);

    int enableSoundPositionIndication(boolean z);

    int enableVideo();

    int enableWebSdkInteroperability(boolean z);

    IAudioEffectManager getAudioEffectManager();

    int getAudioMixingCurrentPosition();

    int getAudioMixingDuration();

    int getAudioMixingPlayoutVolume();

    int getAudioMixingPublishVolume();

    String getCallId();

    float getCameraMaxZoomFactor();

    int getConnectionState();

    long getNativeHandle();

    String getParameter(String str, String str2);

    int getUserInfoByUid(int i, UserInfo userInfo);

    int getUserInfoByUserAccount(String str, UserInfo userInfo);

    boolean isCameraAutoFocusFaceModeSupported();

    boolean isCameraExposurePositionSupported();

    boolean isCameraFocusSupported();

    boolean isCameraTorchSupported();

    boolean isCameraZoomSupported();

    boolean isSpeakerphoneEnabled();

    boolean isTextureEncodeSupported();

    int joinChannel(String str, String str2, String str3, int i);

    int joinChannel(String str, String str2, String str3, int i, ChannelMediaOptions channelMediaOptions);

    int joinChannelWithUserAccount(String str, String str2, String str3);

    int joinChannelWithUserAccount(String str, String str2, String str3, ChannelMediaOptions channelMediaOptions);

    int leaveChannel();

    @Deprecated
    void monitorBluetoothHeadsetEvent(boolean z);

    @Deprecated
    void monitorHeadsetEvent(boolean z);

    int muteAllRemoteAudioStreams(boolean z);

    int muteAllRemoteVideoStreams(boolean z);

    int muteLocalAudioStream(boolean z);

    int muteLocalVideoStream(boolean z);

    int muteRemoteAudioStream(int i, boolean z);

    int muteRemoteVideoStream(int i, boolean z);

    int pauseAllChannelMediaRelay();

    @Deprecated
    int pauseAudio();

    int pauseAudioMixing();

    int pullPlaybackAudioFrame(byte[] bArr, int i);

    int pushExternalAudioFrame(byte[] bArr, long j);

    boolean pushExternalVideoFrame(AgoraVideoFrame agoraVideoFrame);

    int rate(String str, int i, String str2);

    int registerAudioFrameObserver(IAudioFrameObserver iAudioFrameObserver);

    int registerLocalUserAccount(String str, String str2);

    int registerMediaMetadataObserver(IMetadataObserver iMetadataObserver, int i);

    void removeHandler(IRtcEngineEventHandler iRtcEngineEventHandler);

    int removeInjectStreamUrl(String str);

    int removePublishStreamUrl(String str);

    int renewToken(String str);

    int resumeAllChannelMediaRelay();

    @Deprecated
    int resumeAudio();

    int resumeAudioMixing();

    int sendCustomReportMessage(String str, String str2, String str3, String str4, int i);

    int sendStreamMessage(int i, byte[] bArr);

    int setAudioEffectParameters(int i, int i2, int i3);

    int setAudioMixingPitch(int i);

    int setAudioMixingPosition(int i);

    int setAudioProfile(int i, int i2);

    int setBeautyEffectOptions(boolean z, BeautyOptions beautyOptions);

    int setCameraAutoFocusFaceModeEnabled(boolean z);

    int setCameraCapturerConfiguration(CameraCapturerConfiguration cameraCapturerConfiguration);

    int setCameraExposurePosition(float f, float f2);

    int setCameraFocusPositionInPreview(float f, float f2);

    int setCameraTorchOn(boolean z);

    int setCameraZoomFactor(float f);

    int setChannelProfile(int i);

    int setClientRole(int i);

    int setClientRole(int i, ClientRoleOptions clientRoleOptions);

    int setCloudProxy(int i);

    int setDefaultAudioRoutetoSpeakerphone(boolean z);

    int setDefaultMuteAllRemoteAudioStreams(boolean z);

    int setDefaultMuteAllRemoteVideoStreams(boolean z);

    void setEnableAiNoiseReduction(boolean z);

    int setEnableSpeakerphone(boolean z);

    int setEncryptionMode(String str);

    int setEncryptionSecret(String str);

    int setExternalAudioSink(boolean z, int i, int i2);

    int setExternalAudioSource(boolean z, int i, int i2);

    void setExternalVideoSource(boolean z, boolean z2, boolean z3);

    @Deprecated
    int setHighQualityAudioParameters(boolean z, boolean z2, boolean z3);

    int setInEarMonitoringVolume(int i);

    int setLiveTranscoding(LiveTranscoding liveTranscoding);

    int setLocalPublishFallbackOption(int i);

    @Deprecated
    int setLocalRenderMode(int i);

    int setLocalRenderMode(int i, int i2);

    int setLocalVideoMirrorMode(int i);

    int setLocalVideoRenderer(IVideoSink iVideoSink);

    int setLocalVoiceChanger(int i);

    int setLocalVoiceEqualization(int i, int i2);

    int setLocalVoicePitch(double d);

    int setLocalVoiceReverb(int i, int i2);

    int setLocalVoiceReverbPreset(int i);

    int setLogFile(String str);

    int setLogFileSize(int i);

    int setLogFilter(int i);

    int setMixedAudioFrameParameters(int i, int i2);

    int setParameters(String str);

    int setPlaybackAudioFrameParameters(int i, int i2, int i3, int i4);

    @Deprecated
    void setPreferHeadset(boolean z);

    int setRecordingAudioFrameParameters(int i, int i2, int i3, int i4);

    int setRemoteDefaultVideoStreamType(int i);

    @Deprecated
    int setRemoteRenderMode(int i, int i2);

    int setRemoteRenderMode(int i, int i2, int i3);

    int setRemoteSubscribeFallbackOption(int i);

    int setRemoteUserPriority(int i, int i2);

    int setRemoteVideoRenderer(int i, IVideoSink iVideoSink);

    int setRemoteVideoStreamType(int i, int i2);

    int setRemoteVoicePosition(int i, double d, double d2);

    int setVideoEncoderConfiguration(VideoEncoderConfiguration videoEncoderConfiguration);

    @Deprecated
    int setVideoProfile(int i, int i2, int i3, int i4);

    @Deprecated
    int setVideoProfile(int i, boolean z);

    @Deprecated
    int setVideoQualityParameters(boolean z);

    int setVideoSource(IVideoSource iVideoSource);

    int setVoiceBeautifierParameters(int i, int i2, int i3);

    int setupLocalVideo(VideoCanvas videoCanvas);

    int setupRemoteVideo(VideoCanvas videoCanvas);

    int startAudioMixing(String str, boolean z, boolean z2, int i);

    int startAudioMixing(String str, boolean z, boolean z2, int i, int i2);

    @Deprecated
    int startAudioRecording(String str, int i);

    int startAudioRecording(String str, int i, int i2);

    int startChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration);

    int startDumpVideoReceiveTrack(int i, String str);

    @Deprecated
    int startEchoTest();

    int startEchoTest(int i);

    int startLastmileProbeTest(LastmileProbeConfig lastmileProbeConfig);

    int startPreview();

    int startRtmpStreamWithTranscoding(String str, LiveTranscoding liveTranscoding);

    int stopAudioMixing();

    int stopAudioRecording();

    int stopChannelMediaRelay();

    int stopDumpVideoReceiveTrack();

    int stopEchoTest();

    int stopLastmileProbeTest();

    int stopPreview();

    int stopRtmpStream(String str);

    int switchCamera();

    int switchChannel(String str, String str2);

    int switchChannel(String str, String str2, ChannelMediaOptions channelMediaOptions);

    int updateChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration);

    int updateRtmpTranscoding(LiveTranscoding liveTranscoding);

    @Deprecated
    int useExternalAudioDevice();
}
