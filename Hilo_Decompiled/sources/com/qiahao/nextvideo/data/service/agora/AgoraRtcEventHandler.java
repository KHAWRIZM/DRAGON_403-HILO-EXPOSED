package com.qiahao.nextvideo.data.service.agora;

import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import cf.c;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.ui.videocall.VideoCallMessage;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.taobao.accs.utl.BaseMonitor;
import io.agora.rtc.IRtcEngineEventHandler;
import io.agora.rtc.models.UserInfo;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import n5.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nH\u0016J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\"\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u001b\u001a\u00020\nH\u0016J2\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0016J(\u0010&\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nH\u0016J\u0018\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0016J$\u0010,\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010\u00152\b\u0010.\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010/\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u000100H\u0016J\u0012\u00101\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0015H\u0016J\"\u00102\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00152\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\nH\u0016J\u0010\u00103\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u000204H\u0016J\"\u00105\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00152\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\nH\u0016J\u0018\u00106\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010-\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0019H\u0016J\u0018\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\nH\u0016J\u0010\u0010=\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\nH\u0016J\u0018\u0010>\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J(\u0010?\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010@\u001a\u00020\nH\u0016J-\u0010A\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010-\u001a\u00020\n2\u000e\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020D0CH\u0016¢\u0006\u0002\u0010EJ\u0010\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020HH\u0016J \u0010I\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nH\u0016J\b\u0010J\u001a\u00020\u0005H\u0016J \u0010K\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020NH\u0016J\u0012\u0010O\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010P\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010-\u001a\u000207H\u0016J\"\u0010Q\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00152\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\nH\u0016J'\u0010R\u001a\u00020\u00052\u0010\u0010S\u001a\f\u0012\u0006\b\u0001\u0012\u00020T\u0018\u00010C2\u0006\u0010U\u001a\u00020\nH\u0016¢\u0006\u0002\u0010VJ\u0010\u0010W\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0018\u0010X\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nH\u0016J\u0012\u0010Y\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0015H\u0016J\u0018\u0010Z\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010[\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\\H\u0016J*\u0010]\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u00152\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0016J\u0018\u0010^\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010-\u001a\u00020\nH\u0016J\u001a\u0010_\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010`\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010aH\u0016J(\u0010b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nH\u0016J\"\u0010c\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nH\u0016¨\u0006d"}, d2 = {"Lcom/qiahao/nextvideo/data/service/agora/AgoraRtcEventHandler;", "Lio/agora/rtc/IRtcEngineEventHandler;", "<init>", "()V", "onLocalAudioStats", "", "p0", "Lio/agora/rtc/IRtcEngineEventHandler$LocalAudioStats;", "onAudioMixingStateChanged", "state", "", "reason", "onAudioEffectFinished", "soundId", "onNetworkQuality", "uid", "txQuality", "rxQuality", "onWlAccMessage", "action", "wlAccMsg", "", "onNetworkTypeChanged", "type", "onRtcStats", "Lio/agora/rtc/IRtcEngineEventHandler$RtcStats;", "onLocalAudioStateChanged", BaseMonitor.COUNT_ERROR, "onCameraExposureAreaChanged", "Landroid/graphics/Rect;", "onRequestAudioFileInfo", "info", "Lio/agora/rtc/IRtcEngineEventHandler$AudioFileInfo;", "onAudioSubscribeStateChanged", "channel", "oldState", "newState", "elapseSinceLastState", "onFirstRemoteVideoFrame", "width", "height", "elapsed", "onLocalVideoStateChanged", "localVideoState", "onApiCallExecuted", "p1", "p2", "onRemoteAudioStats", "Lio/agora/rtc/IRtcEngineEventHandler$RemoteAudioStats;", "onStreamUnpublished", "onRejoinChannelSuccess", "onLocalVideoStats", "Lio/agora/rtc/IRtcEngineEventHandler$LocalVideoStats;", "onStreamInjectedStatus", "onUserMuteVideo", "", "onLeaveChannel", "rtcStats", "onClientRoleChanged", "oldRole", "newRole", "onFirstLocalVideoFramePublished", "onConnectionStateChanged", "onRemoteVideoStateChanged", "p3", "onFacePositionChanged", "faces", "", "Lio/agora/rtc/IRtcEngineEventHandler$AgoraFacePositionInfo;", "(II[Lio/agora/rtc/IRtcEngineEventHandler$AgoraFacePositionInfo;)V", "onRemoteVideoStats", "remoteVideoStats", "Lio/agora/rtc/IRtcEngineEventHandler$RemoteVideoStats;", "onFirstLocalVideoFrame", "onCameraReady", "onStreamMessage", "streamId", "bytesArray", "", "onCameraFocusAreaChanged", "onUserEnableLocalVideo", "onRtmpStreamingStateChanged", "onAudioVolumeIndication", "speakers", "Lio/agora/rtc/IRtcEngineEventHandler$AudioVolumeInfo;", "totalVolume", "([Lio/agora/rtc/IRtcEngineEventHandler$AudioVolumeInfo;I)V", "onActiveSpeaker", "onUserJoined", "onTokenPrivilegeWillExpire", "onUserOffline", "onLastmileProbeResult", "Lio/agora/rtc/IRtcEngineEventHandler$LastmileProbeResult;", "onVideoPublishStateChanged", "onFirstRemoteAudioDecoded", "onLocalUserRegistered", "onUserInfoUpdated", "Lio/agora/rtc/models/UserInfo;", "onRemoteAudioStateChanged", "onJoinChannelSuccess", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AgoraRtcEventHandler extends IRtcEngineEventHandler {
    public void onActiveSpeaker(int uid) {
        super.onActiveSpeaker(uid);
    }

    public void onApiCallExecuted(int p0, @Nullable String p1, @Nullable String p2) {
        super.onApiCallExecuted(p0, p1, p2);
    }

    public void onAudioEffectFinished(int soundId) {
        super.onAudioEffectFinished(soundId);
    }

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

    public void onAudioSubscribeStateChanged(@Nullable String channel, int uid, int oldState, int newState, int elapseSinceLastState) {
        super.onAudioSubscribeStateChanged(channel, uid, oldState, newState, elapseSinceLastState);
    }

    public void onAudioVolumeIndication(@Nullable IRtcEngineEventHandler.AudioVolumeInfo[] speakers, int totalVolume) {
        super.onAudioVolumeIndication(speakers, totalVolume);
    }

    public void onCameraExposureAreaChanged(@Nullable Rect p0) {
        super.onCameraExposureAreaChanged(p0);
    }

    public void onCameraFocusAreaChanged(@Nullable Rect p0) {
        super.onCameraFocusAreaChanged(p0);
    }

    public void onCameraReady() {
        super.onCameraReady();
        DebugToolsKt.printf(AgoraRtcService.TAG, "onCameraReady()");
    }

    public void onClientRoleChanged(int oldRole, int newRole) {
        super.onClientRoleChanged(oldRole, newRole);
    }

    public void onConnectionStateChanged(int state, int reason) {
        super.onConnectionStateChanged(state, reason);
        e.b("声网的网络状态：" + state + "   原因：" + reason);
    }

    public void onFacePositionChanged(int p0, int p1, @NotNull IRtcEngineEventHandler.AgoraFacePositionInfo[] faces) {
        boolean z;
        Intrinsics.checkNotNullParameter(faces, "faces");
        super.onFacePositionChanged(p0, p1, faces);
        la.b faceDetectionStateRelay = AgoraRtcService.INSTANCE.getFaceDetectionStateRelay();
        if (faces.length == 0) {
            z = true;
        } else {
            z = false;
        }
        faceDetectionStateRelay.accept(Boolean.valueOf(!z));
    }

    public void onFirstLocalVideoFrame(int width, int height, int elapsed) {
        super.onFirstLocalVideoFrame(width, height, elapsed);
    }

    public void onFirstLocalVideoFramePublished(int elapsed) {
        super.onFirstLocalVideoFramePublished(elapsed);
        DebugToolsKt.printf(AgoraRtcService.TAG, "onFirstLocalVideoFramePublished(" + elapsed + ": Int)");
    }

    public void onFirstRemoteAudioDecoded(int p0, int p1) {
        super.onFirstRemoteAudioDecoded(p0, p1);
        DebugToolsKt.printf(AgoraRtcService.TAG, "onFirstRemoteAudioDecoded(" + p0 + ": Int, " + p1 + ": Int)");
    }

    public void onFirstRemoteVideoFrame(int uid, int width, int height, int elapsed) {
        super.onFirstRemoteVideoFrame(uid, width, height, elapsed);
        DebugToolsKt.printf(AgoraRtcService.TAG, "onFirstRemoteVideoFrame(" + uid + ": Int, " + width + ": Int, " + height + ": Int, " + elapsed + ": Int)");
    }

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

    public void onLastmileProbeResult(@Nullable IRtcEngineEventHandler.LastmileProbeResult p0) {
        super.onLastmileProbeResult(p0);
    }

    public void onLeaveChannel(@NotNull IRtcEngineEventHandler.RtcStats rtcStats) {
        Intrinsics.checkNotNullParameter(rtcStats, "rtcStats");
        super.onLeaveChannel(rtcStats);
    }

    public void onLocalAudioStateChanged(int state, int error) {
        super.onLocalAudioStateChanged(state, error);
        e.b("本地音频状态发生改变回调:" + state + " 本地音频出错原因：" + error);
    }

    public void onLocalAudioStats(@Nullable IRtcEngineEventHandler.LocalAudioStats p0) {
        super.onLocalAudioStats(p0);
    }

    public void onLocalUserRegistered(int p0, @Nullable String p1) {
        super.onLocalUserRegistered(p0, p1);
    }

    public void onLocalVideoStateChanged(int localVideoState, int error) {
        super.onLocalVideoStateChanged(localVideoState, error);
        DebugToolsKt.printf(AgoraRtcService.TAG, "onLocalVideoStateChanged(" + localVideoState + ": Int, " + error + ": Int)");
        AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
        agoraRtcService.setLocalVideoState(localVideoState);
        agoraRtcService.getLocalVideoStateRelay().accept(new Pair(Integer.valueOf(localVideoState), Integer.valueOf(error)));
    }

    public void onLocalVideoStats(@NotNull IRtcEngineEventHandler.LocalVideoStats p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        super.onLocalVideoStats(p0);
    }

    public void onNetworkQuality(int uid, int txQuality, int rxQuality) {
        super.onNetworkQuality(uid, txQuality, rxQuality);
        if (txQuality > 1 || rxQuality > 1) {
            e.b("用户:" + uid + "      上行网络质量" + txQuality + "   该用户的下行网络质量" + rxQuality);
        }
    }

    public void onNetworkTypeChanged(int type) {
        super.onNetworkTypeChanged(type);
        e.b("本地网络类型发生改变回调:" + type);
    }

    public void onRejoinChannelSuccess(@Nullable String p0, int p1, int p2) {
        super.onRejoinChannelSuccess(p0, p1, p2);
    }

    public void onRemoteAudioStateChanged(int uid, int state, int reason, int elapsed) {
        super.onRemoteAudioStateChanged(uid, state, reason, elapsed);
    }

    public void onRemoteAudioStats(@Nullable IRtcEngineEventHandler.RemoteAudioStats p0) {
        super.onRemoteAudioStats(p0);
    }

    public void onRemoteVideoStateChanged(int uid, int state, int reason, int p3) {
        super.onRemoteVideoStateChanged(uid, state, reason, p3);
        DebugToolsKt.printf(AgoraRtcService.TAG, "远端视频回调onRemoteVideoStateChanged(" + uid + ": Int, state: " + state + ", reason: " + reason + ", " + p3 + ": Int)");
        AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
        agoraRtcService.getRemoteVideoStateRelay().accept(new Pair(Integer.valueOf(state), Integer.valueOf(reason)));
        if (state == 1) {
            Log.d(AgoraRtcService.TAG, "onRemoteVideoStateChanged: 收到视频首帧-----");
            agoraRtcService.getRemoteVideoStatusRelay().accept(Integer.valueOf(AgoraRtcService.CUSTOM_REMOTE_VIDEO_FIRST_FRAME));
        }
    }

    public void onRemoteVideoStats(@NotNull IRtcEngineEventHandler.RemoteVideoStats remoteVideoStats) {
        Intrinsics.checkNotNullParameter(remoteVideoStats, "remoteVideoStats");
        super.onRemoteVideoStats(remoteVideoStats);
        VideoCallMessage.INSTANCE.setTotalActiveTimeInMills(remoteVideoStats.totalActiveTime);
    }

    public void onRequestAudioFileInfo(@Nullable IRtcEngineEventHandler.AudioFileInfo info, int error) {
        super.onRequestAudioFileInfo(info, error);
    }

    public void onRtcStats(@NotNull IRtcEngineEventHandler.RtcStats p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        super.onRtcStats(p0);
    }

    public void onRtmpStreamingStateChanged(@Nullable String p0, int p1, int p2) {
        super.onRtmpStreamingStateChanged(p0, p1, p2);
    }

    public void onStreamInjectedStatus(@Nullable String p0, int p1, int p2) {
        super.onStreamInjectedStatus(p0, p1, p2);
    }

    public void onStreamMessage(int uid, int streamId, @NotNull byte[] bytesArray) {
        Intrinsics.checkNotNullParameter(bytesArray, "bytesArray");
        super.onStreamMessage(uid, streamId, bytesArray);
        AgoraRtcService.INSTANCE.getRemoteFaceStatusRelay().accept(new Pair(Integer.valueOf(uid), StringsKt.decodeToString(bytesArray)));
    }

    public void onStreamUnpublished(@Nullable String p0) {
        super.onStreamUnpublished(p0);
    }

    public void onTokenPrivilegeWillExpire(@Nullable String p0) {
        super.onTokenPrivilegeWillExpire(p0);
    }

    public void onUserEnableLocalVideo(int p0, boolean p1) {
        super.onUserEnableLocalVideo(p0, p1);
        DebugToolsKt.printf(AgoraRtcService.TAG, "onUserEnableLocalVideo(" + p0 + ": Int, " + p1 + ": Boolean)");
    }

    public void onUserInfoUpdated(int p0, @Nullable UserInfo p1) {
        super.onUserInfoUpdated(p0, p1);
    }

    public void onUserJoined(int uid, int elapsed) {
        super.onUserJoined(uid, elapsed);
    }

    public void onUserMuteVideo(int p0, boolean p1) {
        super.onUserMuteVideo(p0, p1);
        DebugToolsKt.printf(AgoraRtcService.TAG, "onUserMuteVideo(" + p0 + ": Int, " + p1 + ": Boolean)");
    }

    public void onUserOffline(int uid, int reason) {
        super.onUserOffline(uid, reason);
        AgoraRtcService.INSTANCE.getRemoteVideoStateRelay().accept(new Pair(Integer.valueOf(AgoraRtcService.CUSTOM_REMOTE_VIDEO_IDLE), 5));
    }

    public void onVideoPublishStateChanged(@Nullable String channel, int oldState, int newState, int elapseSinceLastState) {
        super.onVideoPublishStateChanged(channel, oldState, newState, elapseSinceLastState);
        DebugToolsKt.printf(AgoraRtcService.TAG, "onVideoPublishStateChanged(" + channel + ": String?, " + oldState + ": Int, " + newState + ": Int, " + elapseSinceLastState + ": Int)");
    }

    public void onWlAccMessage(int reason, int action, @Nullable String wlAccMsg) {
        super.onWlAccMessage(reason, action, wlAccMsg);
        e.b("Wi-Fi 连接质量" + reason + " ");
    }
}
