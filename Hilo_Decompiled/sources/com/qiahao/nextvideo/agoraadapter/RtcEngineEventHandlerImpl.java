package com.qiahao.nextvideo.agoraadapter;

import android.graphics.Rect;
import io.agora.rtc.IRtcEngineEventHandler;
import io.agora.rtc.models.UserInfo;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
class RtcEngineEventHandlerImpl extends IRtcEngineEventHandler {
    private IRTCEngineHandler engineAdapterEventHandler;

    public RtcEngineEventHandlerImpl(IRTCEngineHandler iRTCEngineHandler) {
        this.engineAdapterEventHandler = iRTCEngineHandler;
    }

    public void onActiveSpeaker(int i) {
        this.engineAdapterEventHandler.onActiveSpeaker(i);
    }

    public void onApiCallExecuted(int i, String str, String str2) {
        this.engineAdapterEventHandler.onApiCallExecuted(i, str, str2);
    }

    public void onAudioEffectFinished(int i) {
        this.engineAdapterEventHandler.onAudioEffectFinished(i);
    }

    public void onAudioMixingFinished() {
        this.engineAdapterEventHandler.onAudioMixingFinished();
    }

    public void onAudioMixingStateChanged(int i, int i2) {
        this.engineAdapterEventHandler.onAudioMixingStateChanged(i, i2);
    }

    public void onAudioQuality(int i, int i2, short s, short s2) {
        this.engineAdapterEventHandler.onAudioQuality(i, i2, s, s2);
    }

    public void onAudioRouteChanged(int i) {
        this.engineAdapterEventHandler.onAudioRouteChanged(i);
    }

    public void onAudioVolumeIndication(IRtcEngineEventHandler.AudioVolumeInfo[] audioVolumeInfoArr, int i) {
        this.engineAdapterEventHandler.onAudioVolumeIndication(audioVolumeInfoArr, i);
    }

    public void onCameraExposureAreaChanged(Rect rect) {
        this.engineAdapterEventHandler.onCameraExposureAreaChanged(rect);
    }

    public void onCameraFocusAreaChanged(Rect rect) {
        this.engineAdapterEventHandler.onCameraFocusAreaChanged(rect);
    }

    public void onCameraReady() {
        this.engineAdapterEventHandler.onCameraReady();
    }

    public void onChannelMediaRelayEvent(int i) {
        this.engineAdapterEventHandler.onChannelMediaRelayEvent(i);
    }

    public void onChannelMediaRelayStateChanged(int i, int i2) {
        this.engineAdapterEventHandler.onChannelMediaRelayStateChanged(i, i2);
    }

    public void onClientRoleChanged(int i, int i2) {
        this.engineAdapterEventHandler.onClientRoleChanged(i, i2);
    }

    public void onConnectionInterrupted() {
        this.engineAdapterEventHandler.onConnectionInterrupted();
    }

    public void onConnectionLost() {
        this.engineAdapterEventHandler.onConnectionLost();
    }

    public void onConnectionStateChanged(int i, int i2) {
        this.engineAdapterEventHandler.onConnectionStateChanged(i, i2);
    }

    public void onError(int i) {
        this.engineAdapterEventHandler.onError(i);
    }

    public void onFirstLocalAudioFrame(int i) {
        this.engineAdapterEventHandler.onFirstLocalAudioFrame(i);
    }

    public void onFirstLocalVideoFrame(int i, int i2, int i3) {
        this.engineAdapterEventHandler.onFirstLocalVideoFrame(i, i2, i3);
    }

    public void onFirstLocalVideoFramePublished(int i) {
        this.engineAdapterEventHandler.onFirstLocalVideoFramePublished(i);
    }

    public void onFirstRemoteAudioDecoded(int i, int i2) {
        this.engineAdapterEventHandler.onFirstRemoteAudioDecoded(i, i2);
    }

    public void onFirstRemoteAudioFrame(int i, int i2) {
        this.engineAdapterEventHandler.onFirstRemoteAudioFrame(i, i2);
    }

    public void onFirstRemoteVideoDecoded(int i, int i2, int i3, int i4) {
        this.engineAdapterEventHandler.onFirstRemoteVideoDecoded(i, i2, i3, i4);
    }

    public void onFirstRemoteVideoFrame(int i, int i2, int i3, int i4) {
        this.engineAdapterEventHandler.onFirstRemoteVideoFrame(i, i2, i3, i4);
    }

    public void onJoinChannelSuccess(String str, int i, int i2) {
        this.engineAdapterEventHandler.onJoinChannelSuccess(str, i, i2);
    }

    public void onLastmileProbeResult(IRtcEngineEventHandler.LastmileProbeResult lastmileProbeResult) {
        this.engineAdapterEventHandler.onLastmileProbeResult(lastmileProbeResult);
    }

    public void onLastmileQuality(int i) {
        this.engineAdapterEventHandler.onLastmileQuality(i);
    }

    public void onLeaveChannel(IRtcEngineEventHandler.RtcStats rtcStats) {
        this.engineAdapterEventHandler.onLeaveChannel(rtcStats);
    }

    public void onLocalAudioStateChanged(int i, int i2) {
        this.engineAdapterEventHandler.onLocalAudioStateChanged(i, i2);
    }

    public void onLocalAudioStats(IRtcEngineEventHandler.LocalAudioStats localAudioStats) {
        this.engineAdapterEventHandler.onLocalAudioStats(localAudioStats);
    }

    public void onLocalPublishFallbackToAudioOnly(boolean z) {
        this.engineAdapterEventHandler.onLocalPublishFallbackToAudioOnly(z);
    }

    public void onLocalUserRegistered(int i, String str) {
        this.engineAdapterEventHandler.onLocalUserRegistered(i, str);
    }

    public void onLocalVideoStateChanged(int i, int i2) {
        this.engineAdapterEventHandler.onLocalVideoStateChanged(i, i2);
    }

    public void onLocalVideoStats(IRtcEngineEventHandler.LocalVideoStats localVideoStats) {
        this.engineAdapterEventHandler.onLocalVideoStats(localVideoStats);
    }

    public void onMediaEngineLoadSuccess() {
        this.engineAdapterEventHandler.onMediaEngineLoadSuccess();
    }

    public void onMediaEngineStartCallSuccess() {
        this.engineAdapterEventHandler.onMediaEngineStartCallSuccess();
    }

    public void onMicrophoneEnabled(boolean z) {
        this.engineAdapterEventHandler.onMicrophoneEnabled(z);
    }

    public void onNetworkQuality(int i, int i2, int i3) {
        this.engineAdapterEventHandler.onNetworkQuality(i, i2, i3);
    }

    public void onRejoinChannelSuccess(String str, int i, int i2) {
        this.engineAdapterEventHandler.onRejoinChannelSuccess(str, i, i2);
    }

    public void onRemoteAudioStateChanged(int i, int i2, int i3, int i4) {
        this.engineAdapterEventHandler.onRemoteAudioStateChanged(i, i2, i3, i4);
    }

    public void onRemoteAudioStats(IRtcEngineEventHandler.RemoteAudioStats remoteAudioStats) {
        this.engineAdapterEventHandler.onRemoteAudioStats(remoteAudioStats);
    }

    public void onRemoteAudioTransportStats(int i, int i2, int i3, int i4) {
        this.engineAdapterEventHandler.onRemoteAudioTransportStats(i, i2, i3, i4);
    }

    public void onRemoteSubscribeFallbackToAudioOnly(int i, boolean z) {
        this.engineAdapterEventHandler.onRemoteSubscribeFallbackToAudioOnly(i, z);
    }

    public void onRemoteVideoStateChanged(int i, int i2, int i3, int i4) {
        this.engineAdapterEventHandler.onRemoteVideoStateChanged(i, i2, i3, i4);
    }

    public void onRemoteVideoStats(IRtcEngineEventHandler.RemoteVideoStats remoteVideoStats) {
        this.engineAdapterEventHandler.onRemoteVideoStats(remoteVideoStats);
    }

    public void onRemoteVideoTransportStats(int i, int i2, int i3, int i4) {
        this.engineAdapterEventHandler.onRemoteVideoTransportStats(i, i2, i3, i4);
    }

    public void onRequestToken() {
        this.engineAdapterEventHandler.onRequestToken();
    }

    public void onRtcStats(IRtcEngineEventHandler.RtcStats rtcStats) {
        this.engineAdapterEventHandler.onRtcStats(rtcStats);
    }

    public void onRtmpStreamingStateChanged(String str, int i, int i2) {
        this.engineAdapterEventHandler.onRtmpStreamingStateChanged(str, i, i2);
    }

    public void onStreamInjectedStatus(String str, int i, int i2) {
        this.engineAdapterEventHandler.onStreamInjectedStatus(str, i, i2);
    }

    public void onStreamMessage(int i, int i2, byte[] bArr) {
        this.engineAdapterEventHandler.onStreamMessage(i, i2, bArr);
    }

    public void onStreamMessageError(int i, int i2, int i3, int i4, int i5) {
        this.engineAdapterEventHandler.onStreamMessageError(i, i2, i3, i4, i5);
    }

    public void onStreamPublished(String str, int i) {
        this.engineAdapterEventHandler.onStreamPublished(str, i);
    }

    public void onStreamUnpublished(String str) {
        this.engineAdapterEventHandler.onStreamUnpublished(str);
    }

    public void onTokenPrivilegeWillExpire(String str) {
        this.engineAdapterEventHandler.onTokenPrivilegeWillExpire(str);
    }

    public void onTranscodingUpdated() {
        this.engineAdapterEventHandler.onTranscodingUpdated();
    }

    public void onUserEnableLocalVideo(int i, boolean z) {
        this.engineAdapterEventHandler.onUserEnableLocalVideo(i, z);
    }

    public void onUserEnableVideo(int i, boolean z) {
        this.engineAdapterEventHandler.onUserEnableVideo(i, z);
    }

    public void onUserInfoUpdated(int i, UserInfo userInfo) {
        this.engineAdapterEventHandler.onUserInfoUpdated(i, userInfo);
    }

    public void onUserJoined(int i, int i2) {
        this.engineAdapterEventHandler.onUserJoined(i, i2);
    }

    public void onUserMuteAudio(int i, boolean z) {
        this.engineAdapterEventHandler.onUserMuteAudio(i, z);
    }

    public void onUserMuteVideo(int i, boolean z) {
        this.engineAdapterEventHandler.onUserMuteVideo(i, z);
    }

    public void onUserOffline(int i, int i2) {
        this.engineAdapterEventHandler.onUserOffline(i, i2);
    }

    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        this.engineAdapterEventHandler.onVideoSizeChanged(i, i2, i3, i4);
    }

    public void onVideoStopped() {
        this.engineAdapterEventHandler.onVideoStopped();
    }

    public void onWarning(int i) {
        this.engineAdapterEventHandler.onWarning(i);
    }
}
