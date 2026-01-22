package io.agora.rtc;

import io.agora.rtc.audio.SpatialAudioParams;
import io.agora.rtc.internal.EncryptionConfig;
import io.agora.rtc.live.LiveInjectStreamConfig;
import io.agora.rtc.live.LiveTranscoding;
import io.agora.rtc.mediaio.IVideoSink;
import io.agora.rtc.models.ChannelMediaOptions;
import io.agora.rtc.models.ClientRoleOptions;
import io.agora.rtc.models.DataStreamConfig;
import io.agora.rtc.video.ChannelMediaRelayConfiguration;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class RtcChannel {
    private IRtcChannelEventHandler mEventHandler = null;

    public abstract int addInjectStreamUrl(String str, LiveInjectStreamConfig liveInjectStreamConfig);

    public abstract int addPublishStreamUrl(String str, boolean z10);

    public abstract int adjustUserPlaybackSignalVolume(int i10, int i11);

    public abstract String channelId();

    public abstract int createDataStream(DataStreamConfig dataStreamConfig);

    public abstract int createDataStream(boolean z10, boolean z11);

    public abstract int destroy();

    public abstract int enableEncryption(boolean z10, EncryptionConfig encryptionConfig);

    public abstract int enableRemoteSuperResolution(int i10, boolean z10);

    public abstract int enableRemoteSuperResolution(boolean z10, int i10, int i11);

    public abstract String getCallId();

    public abstract int getConnectionState();

    public IRtcChannelEventHandler getEventHandler() {
        return this.mEventHandler;
    }

    public abstract int joinChannel(String str, String str2, int i10, ChannelMediaOptions channelMediaOptions);

    public abstract int joinChannelWithUserAccount(String str, String str2, ChannelMediaOptions channelMediaOptions);

    public abstract int leaveChannel();

    public abstract int muteAllRemoteAudioStreams(boolean z10);

    public abstract int muteAllRemoteVideoStreams(boolean z10);

    public abstract int muteLocalAudioStream(boolean z10);

    public abstract int muteLocalVideoStream(boolean z10);

    public abstract int muteRemoteAudioStream(int i10, boolean z10);

    public abstract int muteRemoteVideoStream(int i10, boolean z10);

    public abstract int pauseAllChannelMediaRelay();

    public abstract int publish();

    public abstract int registerMediaMetadataObserver(IMetadataObserver iMetadataObserver, int i10);

    public abstract int removeInjectStreamUrl(String str);

    public abstract int removePublishStreamUrl(String str);

    public abstract int renewToken(String str);

    public abstract int resumeAllChannelMediaRelay();

    public abstract int sendStreamMessage(int i10, byte[] bArr);

    public abstract int setAVSyncSource(String str, int i10);

    public abstract int setClientRole(int i10);

    public abstract int setClientRole(int i10, ClientRoleOptions clientRoleOptions);

    public abstract int setDefaultMuteAllRemoteAudioStreams(boolean z10);

    public abstract int setDefaultMuteAllRemoteVideoStreams(boolean z10);

    @Deprecated
    public abstract int setEncryptionMode(String str);

    @Deprecated
    public abstract int setEncryptionSecret(String str);

    public abstract int setLiveTranscoding(LiveTranscoding liveTranscoding);

    public abstract int setRemoteDefaultVideoStreamType(int i10);

    public abstract int setRemoteRenderMode(int i10, int i11, int i12);

    public abstract int setRemoteUserPriority(int i10, int i11);

    public abstract int setRemoteUserSpatialAudioParams(int i10, SpatialAudioParams spatialAudioParams);

    public abstract int setRemoteVideoRenderer(int i10, IVideoSink iVideoSink);

    public abstract int setRemoteVideoStreamType(int i10, int i11);

    public abstract int setRemoteVoicePosition(int i10, double d10, double d11);

    public void setRtcChannelEventHandler(IRtcChannelEventHandler iRtcChannelEventHandler) {
        this.mEventHandler = iRtcChannelEventHandler;
    }

    public abstract int startChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration);

    public abstract int startRtmpStreamWithTranscoding(String str, LiveTranscoding liveTranscoding);

    public abstract int startRtmpStreamWithoutTranscoding(String str);

    public abstract int stopChannelMediaRelay();

    public abstract int stopRtmpStream(String str);

    public abstract int unpublish();

    public abstract int updateChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration);

    public abstract int updateRtmpTranscoding(LiveTranscoding liveTranscoding);
}
