package io.agora.rtc.internal;

import io.agora.rtc.IMetadataObserver;
import io.agora.rtc.RtcChannel;
import io.agora.rtc.audio.SpatialAudioParams;
import io.agora.rtc.internal.RtcEngineMessage;
import io.agora.rtc.live.LiveInjectStreamConfig;
import io.agora.rtc.live.LiveTranscoding;
import io.agora.rtc.mediaio.AgoraDefaultRender;
import io.agora.rtc.mediaio.IVideoSink;
import io.agora.rtc.models.ChannelMediaOptions;
import io.agora.rtc.models.ClientRoleOptions;
import io.agora.rtc.models.DataStreamConfig;
import io.agora.rtc.video.ChannelMediaInfo;
import io.agora.rtc.video.ChannelMediaRelayConfiguration;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class RtcChannelImpl extends RtcChannel {
    private long mNativeHandle = 0;
    private boolean mInitialized = false;
    private RtcEngineImpl mRtcEngineImpl = null;
    private boolean mJoined = false;

    private native int nativeRtcChannelAddInjectStreamUrl(long j10, String str, byte[] bArr);

    private native int nativeRtcChannelAddPublishStreamUrl(long j10, String str, boolean z10);

    private native int nativeRtcChannelAddRemoteVideoRender(long j10, int i10, IVideoSink iVideoSink, int i11);

    private native int nativeRtcChannelAdjustUserPlaybackSignalVolume(long j10, int i10, int i11);

    private native String nativeRtcChannelChannelId(long j10);

    private native int nativeRtcChannelCreateDataStream(long j10, boolean z10, boolean z11);

    private native int nativeRtcChannelCreateDataStream2(long j10, boolean z10, boolean z11);

    private native int nativeRtcChannelEnableEncryption(long j10, boolean z10, int i10, String str, byte[] bArr);

    private native int nativeRtcChannelEnableRemoteSuperResolution(long j10, boolean z10, int i10, int i11);

    private native int nativeRtcChannelEnableRemoteSuperResolutionDepercated(long j10, int i10, boolean z10);

    private native String nativeRtcChannelGetCallId(long j10);

    private native int nativeRtcChannelGetConncetionState(long j10);

    private native int nativeRtcChannelJoinChannel(long j10, String str, String str2, int i10, Object obj);

    private native int nativeRtcChannelJoinChannelWithUserAccount(long j10, String str, String str2, Object obj);

    private native int nativeRtcChannelLeaveChannel(long j10);

    private native int nativeRtcChannelMuteAllRemoteAudioStreams(long j10, boolean z10);

    private native int nativeRtcChannelMuteAllRemoteVideoStreams(long j10, boolean z10);

    private native int nativeRtcChannelMuteLocalAudioStream(long j10, boolean z10);

    private native int nativeRtcChannelMuteLocalVideoStream(long j10, boolean z10);

    private native int nativeRtcChannelMuteRemoteAudioStream(long j10, int i10, boolean z10);

    private native int nativeRtcChannelMuteRemoteVideoStream(long j10, int i10, boolean z10);

    private native int nativeRtcChannelPauseAllChannelMediaRelay(long j10);

    private native int nativeRtcChannelPublish(long j10);

    private native int nativeRtcChannelRegisterMediaMetadataObserver(long j10, Object obj, int i10);

    private native int nativeRtcChannelRemoveInjectStreamUrl(long j10, String str);

    private native int nativeRtcChannelRemovePublishStreamUrl(long j10, String str);

    private native int nativeRtcChannelRenewToken(long j10, String str);

    private native int nativeRtcChannelResumeAllChannelMediaRelay(long j10);

    private native int nativeRtcChannelSendStreamMessage(long j10, int i10, byte[] bArr);

    private native int nativeRtcChannelSetAVSyncSource(long j10, String str, int i10);

    private native int nativeRtcChannelSetClientRole(long j10, int i10);

    private native int nativeRtcChannelSetClientRoleOptions(long j10, int i10, Object obj);

    private native int nativeRtcChannelSetDefaultMuteAllRemoteAudioStreams(long j10, boolean z10);

    private native int nativeRtcChannelSetDefaultMuteAllRemoteVideoStreams(long j10, boolean z10);

    private native int nativeRtcChannelSetEncryptionMode(long j10, String str);

    private native int nativeRtcChannelSetEncryptionSecret(long j10, String str);

    private native int nativeRtcChannelSetLiveTranscoding(long j10, byte[] bArr);

    private native int nativeRtcChannelSetRemoteDefaultVideoStreamType(long j10, int i10);

    private native int nativeRtcChannelSetRemoteRenderMode(long j10, int i10, int i11);

    private native int nativeRtcChannelSetRemoteRenderModeWithMirrorMode(long j10, int i10, int i11, int i12);

    private native int nativeRtcChannelSetRemoteUserPriority(long j10, int i10, int i11);

    private native int nativeRtcChannelSetRemoteUserSpatialAudioParams(long j10, int i10, Object obj);

    private native int nativeRtcChannelSetRemoteVideoStreamType(long j10, int i10, int i11);

    private native int nativeRtcChannelSetRemoteVoicePosition(long j10, int i10, double d10, double d11);

    private native int nativeRtcChannelStartChannelMediaRelay(long j10, byte[] bArr);

    private native int nativeRtcChannelStartRtmpStreamWithTranscoding(long j10, String str, byte[] bArr);

    private native int nativeRtcChannelStartRtmpStreamWithoutTranscoding(long j10, String str);

    private native int nativeRtcChannelStopChannelMediaRelay(long j10);

    private native int nativeRtcChannelStopRtmpStream(long j10, String str);

    private native int nativeRtcChannelUnpublish(long j10);

    private native int nativeRtcChannelUpdateChannelMediaRelay(long j10, byte[] bArr);

    private native int nativeRtcChannelUpdateRtmpTranscoding(long j10, byte[] bArr);

    @Override // io.agora.rtc.RtcChannel
    public int addInjectStreamUrl(String str, LiveInjectStreamConfig liveInjectStreamConfig) {
        if (!this.mInitialized) {
            return -7;
        }
        if (str != null && liveInjectStreamConfig != null) {
            return nativeRtcChannelAddInjectStreamUrl(this.mNativeHandle, str, new RtcEngineMessage.PInjectStreamConfig().marshall(liveInjectStreamConfig));
        }
        return -2;
    }

    @Override // io.agora.rtc.RtcChannel
    public int addPublishStreamUrl(String str, boolean z10) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelAddPublishStreamUrl(this.mNativeHandle, str, z10);
    }

    @Override // io.agora.rtc.RtcChannel
    public int adjustUserPlaybackSignalVolume(int i10, int i11) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelAdjustUserPlaybackSignalVolume(this.mNativeHandle, i10, i11);
    }

    @Override // io.agora.rtc.RtcChannel
    public String channelId() {
        if (!this.mInitialized) {
            return "";
        }
        return nativeRtcChannelChannelId(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcChannel
    public int createDataStream(boolean z10, boolean z11) {
        if (this.mInitialized) {
            return nativeRtcChannelCreateDataStream(this.mNativeHandle, z10, z11);
        }
        return -7;
    }

    @Override // io.agora.rtc.RtcChannel
    public int destroy() {
        if (this.mInitialized) {
            int destroyRtcChannel = this.mRtcEngineImpl.destroyRtcChannel(channelId());
            this.mInitialized = false;
            return destroyRtcChannel;
        }
        return -7;
    }

    @Override // io.agora.rtc.RtcChannel
    public int enableEncryption(boolean z10, EncryptionConfig encryptionConfig) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelEnableEncryption(this.mNativeHandle, z10, encryptionConfig.encryptionMode.getValue(), encryptionConfig.encryptionKey, encryptionConfig.encryptionKdfSalt);
    }

    @Override // io.agora.rtc.RtcChannel
    public int enableRemoteSuperResolution(int i10, boolean z10) {
        if (this.mInitialized) {
            return nativeRtcChannelEnableRemoteSuperResolutionDepercated(this.mNativeHandle, i10, z10);
        }
        return 1;
    }

    @Override // io.agora.rtc.RtcChannel
    public String getCallId() {
        if (!this.mInitialized) {
            return "";
        }
        return nativeRtcChannelGetCallId(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcChannel
    public int getConnectionState() {
        if (!this.mInitialized) {
            return 1;
        }
        return nativeRtcChannelGetConncetionState(this.mNativeHandle);
    }

    public long getNativeHandle() {
        return this.mNativeHandle;
    }

    public boolean hasJoined() {
        return this.mJoined;
    }

    public int initialize(RtcEngineImpl rtcEngineImpl, long j10) {
        this.mRtcEngineImpl = rtcEngineImpl;
        this.mNativeHandle = j10;
        this.mInitialized = true;
        return 0;
    }

    public boolean isInitialized() {
        return this.mInitialized;
    }

    @Override // io.agora.rtc.RtcChannel
    public int joinChannel(String str, String str2, int i10, ChannelMediaOptions channelMediaOptions) {
        if (!this.mInitialized || this.mRtcEngineImpl.getContext() == null) {
            return -7;
        }
        if (channelMediaOptions == null) {
            return -2;
        }
        this.mRtcEngineImpl.onRtcChannelJoinChannel();
        this.mJoined = true;
        return nativeRtcChannelJoinChannel(this.mNativeHandle, str, str2, i10, channelMediaOptions);
    }

    @Override // io.agora.rtc.RtcChannel
    public int joinChannelWithUserAccount(String str, String str2, ChannelMediaOptions channelMediaOptions) {
        if (!this.mInitialized || this.mRtcEngineImpl.getContext() == null) {
            return -7;
        }
        if (channelMediaOptions == null) {
            return -2;
        }
        this.mRtcEngineImpl.onRtcChannelJoinChannel();
        this.mJoined = true;
        return nativeRtcChannelJoinChannelWithUserAccount(this.mNativeHandle, str, str2, channelMediaOptions);
    }

    @Override // io.agora.rtc.RtcChannel
    public int leaveChannel() {
        if (!this.mInitialized) {
            return -7;
        }
        this.mJoined = false;
        this.mRtcEngineImpl.onRtcChannelLeaveChannel();
        return nativeRtcChannelLeaveChannel(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcChannel
    public int muteAllRemoteAudioStreams(boolean z10) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelMuteAllRemoteAudioStreams(this.mNativeHandle, z10);
    }

    @Override // io.agora.rtc.RtcChannel
    public int muteAllRemoteVideoStreams(boolean z10) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelMuteAllRemoteVideoStreams(this.mNativeHandle, z10);
    }

    @Override // io.agora.rtc.RtcChannel
    public int muteLocalAudioStream(boolean z10) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelMuteLocalAudioStream(this.mNativeHandle, z10);
    }

    @Override // io.agora.rtc.RtcChannel
    public int muteLocalVideoStream(boolean z10) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelMuteLocalVideoStream(this.mNativeHandle, z10);
    }

    @Override // io.agora.rtc.RtcChannel
    public int muteRemoteAudioStream(int i10, boolean z10) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelMuteRemoteAudioStream(this.mNativeHandle, i10, z10);
    }

    @Override // io.agora.rtc.RtcChannel
    public int muteRemoteVideoStream(int i10, boolean z10) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelMuteRemoteVideoStream(this.mNativeHandle, i10, z10);
    }

    public void onEngineDestroy() {
        this.mNativeHandle = 0L;
        this.mInitialized = false;
    }

    @Override // io.agora.rtc.RtcChannel
    public int pauseAllChannelMediaRelay() {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelPauseAllChannelMediaRelay(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcChannel
    public int publish() {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelPublish(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcChannel
    public int registerMediaMetadataObserver(IMetadataObserver iMetadataObserver, int i10) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelRegisterMediaMetadataObserver(this.mNativeHandle, iMetadataObserver, i10);
    }

    @Override // io.agora.rtc.RtcChannel
    public int removeInjectStreamUrl(String str) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelRemoveInjectStreamUrl(this.mNativeHandle, str);
    }

    @Override // io.agora.rtc.RtcChannel
    public int removePublishStreamUrl(String str) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelRemovePublishStreamUrl(this.mNativeHandle, str);
    }

    @Override // io.agora.rtc.RtcChannel
    public int renewToken(String str) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelRenewToken(this.mNativeHandle, str);
    }

    @Override // io.agora.rtc.RtcChannel
    public int resumeAllChannelMediaRelay() {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelResumeAllChannelMediaRelay(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcChannel
    public int sendStreamMessage(int i10, byte[] bArr) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSendStreamMessage(this.mNativeHandle, i10, bArr);
    }

    @Override // io.agora.rtc.RtcChannel
    public int setAVSyncSource(String str, int i10) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetAVSyncSource(this.mNativeHandle, str, i10);
    }

    @Override // io.agora.rtc.RtcChannel
    public int setClientRole(int i10) {
        if (this.mInitialized) {
            return nativeRtcChannelSetClientRole(this.mNativeHandle, i10);
        }
        return -7;
    }

    @Override // io.agora.rtc.RtcChannel
    public int setDefaultMuteAllRemoteAudioStreams(boolean z10) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetDefaultMuteAllRemoteAudioStreams(this.mNativeHandle, z10);
    }

    @Override // io.agora.rtc.RtcChannel
    public int setDefaultMuteAllRemoteVideoStreams(boolean z10) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetDefaultMuteAllRemoteVideoStreams(this.mNativeHandle, z10);
    }

    @Override // io.agora.rtc.RtcChannel
    public int setEncryptionMode(String str) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetEncryptionMode(this.mNativeHandle, str);
    }

    @Override // io.agora.rtc.RtcChannel
    public int setEncryptionSecret(String str) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetEncryptionSecret(this.mNativeHandle, str);
    }

    @Override // io.agora.rtc.RtcChannel
    public int setLiveTranscoding(LiveTranscoding liveTranscoding) {
        if (!this.mInitialized) {
            return -7;
        }
        if (liveTranscoding == null) {
            return -2;
        }
        if (liveTranscoding.getUsers() != null) {
            Iterator<LiveTranscoding.TranscodingUser> it = liveTranscoding.getUsers().iterator();
            while (it.hasNext()) {
                LiveTranscoding.TranscodingUser next = it.next();
                if (next.width <= 0 || next.height <= 0) {
                    throw new IllegalArgumentException("transcoding user's width and height must be >0");
                }
            }
        }
        return nativeRtcChannelSetLiveTranscoding(this.mNativeHandle, new RtcEngineMessage.PLiveTranscoding().marshall(liveTranscoding));
    }

    @Override // io.agora.rtc.RtcChannel
    public int setRemoteDefaultVideoStreamType(int i10) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetRemoteDefaultVideoStreamType(this.mNativeHandle, i10);
    }

    @Override // io.agora.rtc.RtcChannel
    public int setRemoteRenderMode(int i10, int i11, int i12) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetRemoteRenderModeWithMirrorMode(this.mNativeHandle, i10, i11, i12);
    }

    @Override // io.agora.rtc.RtcChannel
    public int setRemoteUserPriority(int i10, int i11) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetRemoteUserPriority(this.mNativeHandle, i10, i11);
    }

    @Override // io.agora.rtc.RtcChannel
    public synchronized int setRemoteUserSpatialAudioParams(int i10, SpatialAudioParams spatialAudioParams) {
        return nativeRtcChannelSetRemoteUserSpatialAudioParams(this.mNativeHandle, i10, spatialAudioParams);
    }

    @Override // io.agora.rtc.RtcChannel
    public int setRemoteVideoRenderer(int i10, IVideoSink iVideoSink) {
        int i11;
        if (!this.mInitialized) {
            return -7;
        }
        if (iVideoSink == null) {
            i11 = 0;
        } else if (iVideoSink instanceof AgoraDefaultRender) {
            i11 = 1;
        } else {
            i11 = 2;
        }
        return nativeRtcChannelAddRemoteVideoRender(this.mNativeHandle, i10, iVideoSink, i11);
    }

    @Override // io.agora.rtc.RtcChannel
    public int setRemoteVideoStreamType(int i10, int i11) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetRemoteVideoStreamType(this.mNativeHandle, i10, i11);
    }

    @Override // io.agora.rtc.RtcChannel
    public int setRemoteVoicePosition(int i10, double d10, double d11) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetRemoteVoicePosition(this.mNativeHandle, i10, d10, d11);
    }

    @Override // io.agora.rtc.RtcChannel
    public int startChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        if (!this.mInitialized) {
            return -7;
        }
        if (channelMediaRelayConfiguration == null || channelMediaRelayConfiguration.getDestChannelMediaInfos().size() == 0 || channelMediaRelayConfiguration.getSrcChannelMediaInfo() == null) {
            return -2;
        }
        for (Map.Entry<String, ChannelMediaInfo> entry : channelMediaRelayConfiguration.getDestChannelMediaInfos().entrySet()) {
            if (entry.getValue().channelName == null || entry.getValue().channelName.length() == 0) {
                return -2;
            }
        }
        return nativeRtcChannelStartChannelMediaRelay(this.mNativeHandle, new RtcEngineMessage.PChannelMediaRelayConfiguration().marshall(channelMediaRelayConfiguration));
    }

    @Override // io.agora.rtc.RtcChannel
    public int startRtmpStreamWithTranscoding(String str, LiveTranscoding liveTranscoding) {
        if (!this.mInitialized) {
            return -7;
        }
        if (liveTranscoding == null) {
            return -2;
        }
        if (liveTranscoding.getUsers() != null) {
            Iterator<LiveTranscoding.TranscodingUser> it = liveTranscoding.getUsers().iterator();
            while (it.hasNext()) {
                LiveTranscoding.TranscodingUser next = it.next();
                if (next.width <= 0 || next.height <= 0) {
                    throw new IllegalArgumentException("transcoding user's width and height must be >0");
                }
            }
        }
        return nativeRtcChannelStartRtmpStreamWithTranscoding(this.mNativeHandle, str, new RtcEngineMessage.PLiveTranscoding().marshall(liveTranscoding));
    }

    @Override // io.agora.rtc.RtcChannel
    public int startRtmpStreamWithoutTranscoding(String str) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelStartRtmpStreamWithoutTranscoding(this.mNativeHandle, str);
    }

    @Override // io.agora.rtc.RtcChannel
    public int stopChannelMediaRelay() {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelStopChannelMediaRelay(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcChannel
    public int stopRtmpStream(String str) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelStopRtmpStream(this.mNativeHandle, str);
    }

    @Override // io.agora.rtc.RtcChannel
    public int unpublish() {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelUnpublish(this.mNativeHandle);
    }

    @Override // io.agora.rtc.RtcChannel
    public int updateChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        if (!this.mInitialized) {
            return -7;
        }
        if (channelMediaRelayConfiguration == null || channelMediaRelayConfiguration.getDestChannelMediaInfos().size() == 0 || channelMediaRelayConfiguration.getSrcChannelMediaInfo() == null) {
            return -2;
        }
        for (Map.Entry<String, ChannelMediaInfo> entry : channelMediaRelayConfiguration.getDestChannelMediaInfos().entrySet()) {
            if (entry.getValue().channelName == null || entry.getValue().channelName.length() == 0) {
                return -2;
            }
        }
        return nativeRtcChannelUpdateChannelMediaRelay(this.mNativeHandle, new RtcEngineMessage.PChannelMediaRelayConfiguration().marshall(channelMediaRelayConfiguration));
    }

    @Override // io.agora.rtc.RtcChannel
    public int updateRtmpTranscoding(LiveTranscoding liveTranscoding) {
        if (!this.mInitialized) {
            return -7;
        }
        if (liveTranscoding == null) {
            return -2;
        }
        if (liveTranscoding.getUsers() != null) {
            Iterator<LiveTranscoding.TranscodingUser> it = liveTranscoding.getUsers().iterator();
            while (it.hasNext()) {
                LiveTranscoding.TranscodingUser next = it.next();
                if (next.width <= 0 || next.height <= 0) {
                    throw new IllegalArgumentException("transcoding user's width and height must be >0");
                }
            }
        }
        return nativeRtcChannelUpdateRtmpTranscoding(this.mNativeHandle, new RtcEngineMessage.PLiveTranscoding().marshall(liveTranscoding));
    }

    @Override // io.agora.rtc.RtcChannel
    public int createDataStream(DataStreamConfig dataStreamConfig) {
        if (this.mInitialized) {
            return nativeRtcChannelCreateDataStream2(this.mNativeHandle, dataStreamConfig.ordered, dataStreamConfig.syncWithAudio);
        }
        return -7;
    }

    @Override // io.agora.rtc.RtcChannel
    public int enableRemoteSuperResolution(boolean z10, int i10, int i11) {
        if (this.mInitialized) {
            return nativeRtcChannelEnableRemoteSuperResolution(this.mNativeHandle, z10, i10, i11);
        }
        return 1;
    }

    @Override // io.agora.rtc.RtcChannel
    public int setClientRole(int i10, ClientRoleOptions clientRoleOptions) {
        if (this.mInitialized) {
            return nativeRtcChannelSetClientRoleOptions(this.mNativeHandle, i10, clientRoleOptions);
        }
        return -7;
    }
}
