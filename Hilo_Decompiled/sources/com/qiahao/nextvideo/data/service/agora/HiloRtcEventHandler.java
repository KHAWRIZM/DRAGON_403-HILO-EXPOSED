package com.qiahao.nextvideo.data.service.agora;

import android.graphics.Rect;
import android.text.TextUtils;
import cf.c;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.nextvideo.agoraadapter.BaseTRTCEngineAdapterEventHandler;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.ui.videocall.VideoCallMessage;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.taobao.accs.utl.BaseMonitor;
import io.agora.rtc.IRtcEngineEventHandler;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import n5.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J(\u0010\u0017\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010\u001c\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J'\u0010 \u001a\u00020\u00052\u0010\u0010!\u001a\f\u0012\u0006\b\u0001\u0012\u00020#\u0018\u00010\"2\u0006\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010%J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\"\u0010'\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0016¨\u0006+"}, d2 = {"Lcom/qiahao/nextvideo/data/service/agora/HiloRtcEventHandler;", "Lcom/qiahao/nextvideo/agoraadapter/BaseTRTCEngineAdapterEventHandler;", "<init>", "()V", "onAudioMixingStateChanged", "", "state", "", "reason", "onNetworkQuality", "uid", "txQuality", "rxQuality", "onLocalAudioStateChanged", BaseMonitor.COUNT_ERROR, "onCameraExposureAreaChanged", "p0", "Landroid/graphics/Rect;", "onLocalVideoStateChanged", "localVideoState", "onLeaveChannel", "rtcStats", "Lio/agora/rtc/IRtcEngineEventHandler$RtcStats;", "onRemoteVideoStateChanged", "p3", "onRemoteVideoStats", "remoteVideoStats", "Lio/agora/rtc/IRtcEngineEventHandler$RemoteVideoStats;", "onStreamMessage", "streamId", "bytesArray", "", "onAudioVolumeIndication", "speakers", "", "Lio/agora/rtc/IRtcEngineEventHandler$AudioVolumeInfo;", "totalVolume", "([Lio/agora/rtc/IRtcEngineEventHandler$AudioVolumeInfo;I)V", "onUserOffline", "onJoinChannelSuccess", "channel", "", "elapsed", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HiloRtcEventHandler extends BaseTRTCEngineAdapterEventHandler {
    @Override // com.qiahao.nextvideo.agoraadapter.BaseTRTCEngineAdapterEventHandler, com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onAudioMixingStateChanged(int state, int reason) {
        super.onAudioMixingStateChanged(state, reason);
        if (state == 713 && reason == 723) {
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager.isRoomOpen()) {
                meetingRoomManager.getWsFlow().tryEmit(new RoomEvent().setEventId(RoomEvent.ROOM_MUSIC_FINISH_NEXT));
            } else if (meetingRoomManager.isRoomSmall()) {
                meetingRoomManager.getMusicManager().p(true);
            }
        }
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseTRTCEngineAdapterEventHandler, com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onAudioVolumeIndication(@Nullable IRtcEngineEventHandler.AudioVolumeInfo[] speakers, int totalVolume) {
        super.onAudioVolumeIndication(speakers, totalVolume);
        if (speakers != null && speakers.length != 0) {
            MeetingRoomManager.INSTANCE.getWsFlow().tryEmit(new RoomEvent().Microspeak(speakers));
        }
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseTRTCEngineAdapterEventHandler, com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onCameraExposureAreaChanged(@Nullable Rect p0) {
        super.onCameraExposureAreaChanged(p0);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseTRTCEngineAdapterEventHandler, com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onJoinChannelSuccess(@Nullable String channel, int uid, int elapsed) {
        String str;
        super.onJoinChannelSuccess(channel, uid, elapsed);
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (!TextUtils.isEmpty(meetingRoomManager.getMRoomChannelId())) {
            if (channel == null) {
                str = "";
            } else {
                str = channel;
            }
            meetingRoomManager.setMCurrentAgoraChannelId(str);
            if (Intrinsics.areEqual(meetingRoomManager.getMRoomChannelId(), channel)) {
                meetingRoomManager.getWsFlow().tryEmit(new RoomEvent().setEventId(RoomEvent.ROOM_JOIN_AGORA_CHANNEL_SUCCESS));
            }
        }
        c.c().l(new EventBusKey("H5_JOIN_CHANNEL_SUCCESS", (Object) null, 2, (DefaultConstructorMarker) null));
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseTRTCEngineAdapterEventHandler, com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onLeaveChannel(@NotNull IRtcEngineEventHandler.RtcStats rtcStats) {
        Intrinsics.checkNotNullParameter(rtcStats, "rtcStats");
        super.onLeaveChannel(rtcStats);
        MeetingRoomManager.INSTANCE.getWsFlow().tryEmit(new RoomEvent().setEventId(RoomEvent.ROOM_LEAVE_AGORA_CHANNEL_SUCCESS));
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseTRTCEngineAdapterEventHandler, com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onLocalAudioStateChanged(int state, int error) {
        super.onLocalAudioStateChanged(state, error);
        e.b("本地音频状态发生改变回调:" + state + " 本地音频出错原因：" + error);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseTRTCEngineAdapterEventHandler, com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onLocalVideoStateChanged(int localVideoState, int error) {
        super.onLocalVideoStateChanged(localVideoState, error);
        DebugToolsKt.printf(HiloRtcEngine.TAG, "onLocalVideoStateChanged(" + localVideoState + ": Int, " + error + ": Int)");
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseTRTCEngineAdapterEventHandler, com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onNetworkQuality(int uid, int txQuality, int rxQuality) {
        super.onNetworkQuality(uid, txQuality, rxQuality);
        if (txQuality > 1 || rxQuality > 1) {
            e.b("用户:" + uid + "      上行网络质量" + txQuality + "   该用户的下行网络质量" + rxQuality);
        }
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseTRTCEngineAdapterEventHandler, com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onRemoteVideoStateChanged(int uid, int state, int reason, int p3) {
        super.onRemoteVideoStateChanged(uid, state, reason, p3);
        DebugToolsKt.printf(HiloRtcEngine.TAG, "远端视频回调onRemoteVideoStateChanged(" + uid + ": Int, state: " + state + ", reason: " + reason + ", " + p3 + ": Int)");
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseTRTCEngineAdapterEventHandler, com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onRemoteVideoStats(@NotNull IRtcEngineEventHandler.RemoteVideoStats remoteVideoStats) {
        Intrinsics.checkNotNullParameter(remoteVideoStats, "remoteVideoStats");
        super.onRemoteVideoStats(remoteVideoStats);
        VideoCallMessage.INSTANCE.setTotalActiveTimeInMills(remoteVideoStats.totalActiveTime);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseTRTCEngineAdapterEventHandler, com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onStreamMessage(int uid, int streamId, @NotNull byte[] bytesArray) {
        Intrinsics.checkNotNullParameter(bytesArray, "bytesArray");
        super.onStreamMessage(uid, streamId, bytesArray);
        DebugToolsKt.printf(HiloRtcEngine.TAG, "face remote " + new Pair(Integer.valueOf(uid), StringsKt.decodeToString(bytesArray)));
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseTRTCEngineAdapterEventHandler, com.qiahao.nextvideo.agoraadapter.BaseAgoraHandlerInterface
    public void onUserOffline(int uid, int reason) {
        super.onUserOffline(uid, reason);
    }
}
