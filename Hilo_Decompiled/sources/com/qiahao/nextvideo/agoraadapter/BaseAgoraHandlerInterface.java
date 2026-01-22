package com.qiahao.nextvideo.agoraadapter;

import android.graphics.Rect;
import io.agora.rtc.IRtcEngineEventHandler;
import io.agora.rtc.models.UserInfo;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
interface BaseAgoraHandlerInterface {
    void onActiveSpeaker(int i);

    void onApiCallExecuted(int i, String str, String str2);

    void onAudioEffectFinished(int i);

    void onAudioMixingFinished();

    void onAudioMixingStateChanged(int i, int i2);

    void onAudioQuality(int i, int i2, short s, short s2);

    void onAudioRouteChanged(int i);

    void onAudioVolumeIndication(IRtcEngineEventHandler.AudioVolumeInfo[] audioVolumeInfoArr, int i);

    void onCameraExposureAreaChanged(Rect rect);

    void onCameraFocusAreaChanged(Rect rect);

    void onCameraReady();

    void onChannelMediaRelayEvent(int i);

    void onChannelMediaRelayStateChanged(int i, int i2);

    void onClientRoleChanged(int i, int i2);

    void onConnectionInterrupted();

    void onConnectionLost();

    void onConnectionStateChanged(int i, int i2);

    void onError(int i);

    void onFirstLocalAudioFrame(int i);

    void onFirstLocalVideoFrame(int i, int i2, int i3);

    void onFirstLocalVideoFramePublished(int i);

    void onFirstRemoteAudioDecoded(int i, int i2);

    void onFirstRemoteAudioFrame(int i, int i2);

    void onFirstRemoteVideoDecoded(int i, int i2, int i3, int i4);

    void onFirstRemoteVideoFrame(int i, int i2, int i3, int i4);

    void onJoinChannelSuccess(String str, int i, int i2);

    void onLastmileProbeResult(IRtcEngineEventHandler.LastmileProbeResult lastmileProbeResult);

    void onLastmileQuality(int i);

    void onLeaveChannel(IRtcEngineEventHandler.RtcStats rtcStats);

    void onLocalAudioStateChanged(int i, int i2);

    void onLocalAudioStats(IRtcEngineEventHandler.LocalAudioStats localAudioStats);

    void onLocalPublishFallbackToAudioOnly(boolean z);

    void onLocalUserRegistered(int i, String str);

    void onLocalVideoStateChanged(int i, int i2);

    void onLocalVideoStats(IRtcEngineEventHandler.LocalVideoStats localVideoStats);

    void onMediaEngineLoadSuccess();

    void onMediaEngineStartCallSuccess();

    void onMicrophoneEnabled(boolean z);

    void onNetworkQuality(int i, int i2, int i3);

    void onRejoinChannelSuccess(String str, int i, int i2);

    void onRemoteAudioStateChanged(int i, int i2, int i3, int i4);

    void onRemoteAudioStats(IRtcEngineEventHandler.RemoteAudioStats remoteAudioStats);

    void onRemoteAudioTransportStats(int i, int i2, int i3, int i4);

    void onRemoteSubscribeFallbackToAudioOnly(int i, boolean z);

    void onRemoteVideoStateChanged(int i, int i2, int i3, int i4);

    void onRemoteVideoStats(IRtcEngineEventHandler.RemoteVideoStats remoteVideoStats);

    void onRemoteVideoTransportStats(int i, int i2, int i3, int i4);

    void onRequestToken();

    void onRtcStats(IRtcEngineEventHandler.RtcStats rtcStats);

    void onRtmpStreamingStateChanged(String str, int i, int i2);

    void onStreamInjectedStatus(String str, int i, int i2);

    void onStreamMessage(int i, int i2, byte[] bArr);

    void onStreamMessageError(int i, int i2, int i3, int i4, int i5);

    void onStreamPublished(String str, int i);

    void onStreamUnpublished(String str);

    void onTokenPrivilegeWillExpire(String str);

    void onTranscodingUpdated();

    void onUserEnableLocalVideo(int i, boolean z);

    void onUserEnableVideo(int i, boolean z);

    void onUserInfoUpdated(int i, UserInfo userInfo);

    void onUserJoined(int i, int i2);

    void onUserMuteAudio(int i, boolean z);

    void onUserMuteVideo(int i, boolean z);

    void onUserOffline(int i, int i2);

    void onVideoSizeChanged(int i, int i2, int i3, int i4);

    void onVideoStopped();

    void onWarning(int i);
}
