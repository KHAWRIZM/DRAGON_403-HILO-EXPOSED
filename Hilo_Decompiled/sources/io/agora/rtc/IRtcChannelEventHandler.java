package io.agora.rtc;

import io.agora.rtc.IRtcEngineEventHandler;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class IRtcChannelEventHandler {
    public void onActiveSpeaker(RtcChannel rtcChannel, int i10) {
    }

    public void onAudioPublishStateChanged(RtcChannel rtcChannel, int i10, int i11, int i12) {
    }

    public void onAudioSubscribeStateChanged(RtcChannel rtcChannel, int i10, int i11, int i12, int i13) {
    }

    public void onChannelError(RtcChannel rtcChannel, int i10) {
    }

    public void onChannelMediaRelayEvent(RtcChannel rtcChannel, int i10) {
    }

    public void onChannelMediaRelayStateChanged(RtcChannel rtcChannel, int i10, int i11) {
    }

    public void onChannelWarning(RtcChannel rtcChannel, int i10) {
    }

    public void onClientRoleChangeFailed(RtcChannel rtcChannel, int i10, int i11) {
    }

    public void onClientRoleChanged(RtcChannel rtcChannel, int i10, int i11) {
    }

    public void onConnectionLost(RtcChannel rtcChannel) {
    }

    public void onConnectionStateChanged(RtcChannel rtcChannel, int i10, int i11) {
    }

    public void onFirstRemoteVideoFrame(RtcChannel rtcChannel, int i10, int i11, int i12, int i13) {
    }

    public void onJoinChannelSuccess(RtcChannel rtcChannel, int i10, int i11) {
    }

    public void onLeaveChannel(RtcChannel rtcChannel, IRtcEngineEventHandler.RtcStats rtcStats) {
    }

    public void onLocalPublishFallbackToAudioOnly(RtcChannel rtcChannel, boolean z10) {
    }

    public void onNetworkQuality(RtcChannel rtcChannel, int i10, int i11, int i12) {
    }

    public void onProxyConnected(RtcChannel rtcChannel, int i10, int i11, String str, int i12) {
    }

    public void onRejoinChannelSuccess(RtcChannel rtcChannel, int i10, int i11) {
    }

    public void onRemoteAudioStateChanged(RtcChannel rtcChannel, int i10, int i11, int i12, int i13) {
    }

    public void onRemoteAudioStats(RtcChannel rtcChannel, IRtcEngineEventHandler.RemoteAudioStats remoteAudioStats) {
    }

    public void onRemoteSubscribeFallbackToAudioOnly(RtcChannel rtcChannel, int i10, boolean z10) {
    }

    public void onRemoteVideoStateChanged(RtcChannel rtcChannel, int i10, int i11, int i12, int i13) {
    }

    public void onRemoteVideoStats(RtcChannel rtcChannel, IRtcEngineEventHandler.RemoteVideoStats remoteVideoStats) {
    }

    public void onRequestToken(RtcChannel rtcChannel) {
    }

    public void onRtcStats(RtcChannel rtcChannel, IRtcEngineEventHandler.RtcStats rtcStats) {
    }

    public void onRtmpStreamingEvent(RtcChannel rtcChannel, String str, int i10) {
    }

    public void onRtmpStreamingStateChanged(RtcChannel rtcChannel, String str, int i10, int i11) {
    }

    public void onStreamInjectedStatus(RtcChannel rtcChannel, String str, int i10, int i11) {
    }

    public void onStreamMessage(RtcChannel rtcChannel, int i10, int i11, byte[] bArr) {
    }

    public void onStreamMessageError(RtcChannel rtcChannel, int i10, int i11, int i12, int i13, int i14) {
    }

    public void onTokenPrivilegeWillExpire(RtcChannel rtcChannel, String str) {
    }

    public void onTranscodingUpdated(RtcChannel rtcChannel) {
    }

    public void onUserJoined(RtcChannel rtcChannel, int i10, int i11) {
    }

    public void onUserOffline(RtcChannel rtcChannel, int i10, int i11) {
    }

    public void onUserSuperResolutionEnabled(RtcChannel rtcChannel, int i10, boolean z10, int i11) {
    }

    public void onVideoPublishStateChanged(RtcChannel rtcChannel, int i10, int i11, int i12) {
    }

    public void onVideoSizeChanged(RtcChannel rtcChannel, int i10, int i11, int i12, int i13) {
    }

    public void onVideoSubscribeStateChanged(RtcChannel rtcChannel, int i10, int i11, int i12, int i13) {
    }
}
