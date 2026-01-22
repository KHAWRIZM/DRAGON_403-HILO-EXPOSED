package com.qiahao.nextvideo.agoraadapter;

import android.graphics.Rect;
import com.tencent.trtc.TRTCCloudDef;
import io.agora.rtc.IRtcEngineEventHandler;
import io.agora.rtc.models.UserInfo;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class BaseTRTCEngineAdapterEventHandler implements IRTCEngineHandler {
    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onActiveSpeaker(int i) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onApiCallExecuted(int i, String str, String str2) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onAudioEffectFinished(int i) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onAudioMixingFinished() {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onAudioMixingStateChanged(int i, int i2) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onAudioQuality(int i, int i2, short s, short s2) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onAudioRouteChanged(int i) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onAudioVolumeIndication(IRtcEngineEventHandler.AudioVolumeInfo[] audioVolumeInfoArr, int i) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onCameraExposureAreaChanged(Rect rect) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onCameraFocusAreaChanged(Rect rect) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onCameraReady() {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onChannelMediaRelayEvent(int i) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onChannelMediaRelayStateChanged(int i, int i2) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onClientRoleChanged(int i, int i2) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngineHandler
    public void onConnectOtherRoom(int i, int i2, String str) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onConnectionInterrupted() {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onConnectionLost() {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onConnectionStateChanged(int i, int i2) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngineHandler
    public void onDisConnectOtherRoom(int i, String str) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onError(int i) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onFirstLocalAudioFrame(int i) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onFirstLocalVideoFrame(int i, int i2, int i3) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onFirstLocalVideoFramePublished(int i) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onFirstRemoteAudioDecoded(int i, int i2) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onFirstRemoteAudioFrame(int i, int i2) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onFirstRemoteVideoDecoded(int i, int i2, int i3, int i4) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onFirstRemoteVideoFrame(int i, int i2, int i3, int i4) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onJoinChannelSuccess(String str, int i, int i2) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onLastmileProbeResult(IRtcEngineEventHandler.LastmileProbeResult lastmileProbeResult) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onLastmileQuality(int i) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onLeaveChannel(IRtcEngineEventHandler.RtcStats rtcStats) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onLocalAudioStateChanged(int i, int i2) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onLocalAudioStats(IRtcEngineEventHandler.LocalAudioStats localAudioStats) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onLocalPublishFallbackToAudioOnly(boolean z) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onLocalUserRegistered(int i, String str) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onLocalVideoStateChanged(int i, int i2) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onLocalVideoStats(IRtcEngineEventHandler.LocalVideoStats localVideoStats) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onMediaEngineLoadSuccess() {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onMediaEngineStartCallSuccess() {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onMicrophoneEnabled(boolean z) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onNetworkQuality(int i, int i2, int i3) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngineHandler
    public void onRecvSEIMsg(int i, byte[] bArr) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onRejoinChannelSuccess(String str, int i, int i2) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onRemoteAudioStateChanged(int i, int i2, int i3, int i4) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onRemoteAudioStats(IRtcEngineEventHandler.RemoteAudioStats remoteAudioStats) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onRemoteAudioTransportStats(int i, int i2, int i3, int i4) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onRemoteSubscribeFallbackToAudioOnly(int i, boolean z) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onRemoteVideoStateChanged(int i, int i2, int i3, int i4) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onRemoteVideoStats(IRtcEngineEventHandler.RemoteVideoStats remoteVideoStats) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onRemoteVideoTransportStats(int i, int i2, int i3, int i4) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onRequestToken() {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onRtcStats(IRtcEngineEventHandler.RtcStats rtcStats) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onRtmpStreamingStateChanged(String str, int i, int i2) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngineHandler
    public void onSetMixTranscodingConfig(int i, String str) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngineHandler
    public void onSpeedTest(TRTCCloudDef.TRTCSpeedTestResult tRTCSpeedTestResult, int i, int i2) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onStreamInjectedStatus(String str, int i, int i2) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onStreamMessage(int i, int i2, byte[] bArr) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onStreamMessageError(int i, int i2, int i3, int i4, int i5) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onStreamPublished(String str, int i) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onStreamUnpublished(String str) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onTokenPrivilegeWillExpire(String str) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onTranscodingUpdated() {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onUserEnableLocalVideo(int i, boolean z) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onUserEnableVideo(int i, boolean z) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onUserInfoUpdated(int i, UserInfo userInfo) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onUserJoined(int i, int i2) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onUserMuteAudio(int i, boolean z) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onUserMuteVideo(int i, boolean z) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onUserOffline(int i, int i2) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.IRTCEngineHandler
    public void onUserSubStreamAvailable(int i, boolean z) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onVideoStopped() {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onWarning(int i) {
    }
}
