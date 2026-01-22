package com.qiahao.nextvideo.data.service.agora;

import android.content.Context;
import com.qiahao.base_common.network.BaseServer;
import com.qiahao.base_common.network.ServerInfo;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.HiloApplication;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.tencent.qcloud.tuicore.TUIConstants;
import io.agora.rtc.Constants;
import io.agora.rtc.RtcEngine;
import io.agora.rtc.RtcEngineConfig;
import io.agora.rtc.models.ChannelMediaOptions;
import io.agora.rtc.models.DataStreamConfig;
import io.agora.rtc.video.BeautyOptions;
import io.agora.rtc.video.CameraCapturerConfiguration;
import io.reactivex.rxjava3.core.i0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import la.c;
import n5.e;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pd.g;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0018\u0010\u0010J\r\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u0003J\u0015\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\fJ\r\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u0003J\r\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\t¢\u0006\u0004\b!\u0010\fJ\u0015\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J)\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010)0(2\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\r¢\u0006\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010/R=\u00104\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014 3*\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010202018\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R%\u00108\u001a\u0010\u0012\f\u0012\n 3*\u0004\u0018\u00010\u00140\u0014018\u0006¢\u0006\f\n\u0004\b8\u00105\u001a\u0004\b9\u00107R=\u0010;\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\r 3*\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\r\u0018\u000102020:8\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R=\u0010?\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014 3*\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u000102020:8\u0006¢\u0006\f\n\u0004\b?\u0010<\u001a\u0004\b@\u0010>R\"\u0010A\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010/\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010F\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010/\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER(\u0010I\u001a\b\u0012\u0004\u0012\u00020\t0:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010<\u001a\u0004\bJ\u0010>\"\u0004\bK\u0010LR\"\u0010N\u001a\u00020M8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0018\u0010T\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\"\u0010V\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010\f¨\u0006["}, d2 = {"Lcom/qiahao/nextvideo/data/service/agora/AgoraRtcService;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "initEngine", "(Landroid/content/Context;)V", "", AgooConstants.MESSAGE_BODY_OPEN, "enableDeepLearning", "(Z)V", "", "videoId", "loggingAgora", "(Ljava/lang/String;)V", "token", "channelName", "optionalInfo", "", "agoraId", "joinChannel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "leaveChannel", "setBeautyOption", "isSetBeautyOptions", "enableVideo", "disableVideo", TUIConstants.TUIBeauty.METHOD_DESTROY_XMAGIC, "Lio/agora/rtc/RtcEngine;", "getRtcEngine", "()Lio/agora/rtc/RtcEngine;", "enableLocalVideo", "", "toByteArray", "sendStreamMessage", "([B)Z", "matchUniqueId", "picUrl", "Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/base_common/network/model/ApiResponse;", "postUnionUserPicture", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "TAG", "Ljava/lang/String;", "CUSTOM_REMOTE_VIDEO_IDLE", "I", "CUSTOM_REMOTE_VIDEO_FIRST_FRAME", "Lla/c;", "Lkotlin/Pair;", "kotlin.jvm.PlatformType", "remoteVideoStateRelay", "Lla/c;", "getRemoteVideoStateRelay", "()Lla/c;", "remoteVideoStatusRelay", "getRemoteVideoStatusRelay", "Lla/b;", "remoteFaceStatusRelay", "Lla/b;", "getRemoteFaceStatusRelay", "()Lla/b;", "localVideoStateRelay", "getLocalVideoStateRelay", "localVideoState", "getLocalVideoState", "()I", "setLocalVideoState", "(I)V", "dataStreamID", "getDataStreamID", "setDataStreamID", "faceDetectionStateRelay", "getFaceDetectionStateRelay", "setFaceDetectionStateRelay", "(Lla/b;)V", "Lio/agora/rtc/video/BeautyOptions;", "beautyOptions", "Lio/agora/rtc/video/BeautyOptions;", "getBeautyOptions", "()Lio/agora/rtc/video/BeautyOptions;", "setBeautyOptions", "(Lio/agora/rtc/video/BeautyOptions;)V", "rtcEngine", "Lio/agora/rtc/RtcEngine;", "rtcEngineInit", "Z", "getRtcEngineInit", "()Z", "setRtcEngineInit", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAgoraRtcService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AgoraRtcService.kt\ncom/qiahao/nextvideo/data/service/agora/AgoraRtcService\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,246:1\n1#2:247\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AgoraRtcService {
    public static final int CUSTOM_REMOTE_VIDEO_FIRST_FRAME = 1048577;
    public static final int CUSTOM_REMOTE_VIDEO_IDLE = 1048576;

    @NotNull
    public static final AgoraRtcService INSTANCE = new AgoraRtcService();

    @NotNull
    public static final String TAG = "AgoraRtcService";
    public static BeautyOptions beautyOptions;
    private static int dataStreamID;

    @NotNull
    private static la.b faceDetectionStateRelay;
    private static int localVideoState;

    @NotNull
    private static final la.b localVideoStateRelay;

    @NotNull
    private static final la.b remoteFaceStatusRelay;

    @NotNull
    private static final c remoteVideoStateRelay;

    @NotNull
    private static final c remoteVideoStatusRelay;

    @Nullable
    private static RtcEngine rtcEngine;
    private static boolean rtcEngineInit;

    static {
        c e = c.e();
        Intrinsics.checkNotNullExpressionValue(e, "create(...)");
        remoteVideoStateRelay = e;
        c e2 = c.e();
        Intrinsics.checkNotNullExpressionValue(e2, "create(...)");
        remoteVideoStatusRelay = e2;
        la.b e3 = la.b.e();
        Intrinsics.checkNotNullExpressionValue(e3, "create(...)");
        remoteFaceStatusRelay = e3;
        la.b e4 = la.b.e();
        Intrinsics.checkNotNullExpressionValue(e4, "create(...)");
        localVideoStateRelay = e4;
        la.b e5 = la.b.e();
        Intrinsics.checkNotNullExpressionValue(e5, "create(...)");
        faceDetectionStateRelay = e5;
    }

    private AgoraRtcService() {
    }

    private final void enableDeepLearning(boolean r2) {
        if (r2) {
            RtcEngine rtcEngine2 = rtcEngine;
            if (rtcEngine2 != null) {
                rtcEngine2.setParameters("{\"che.audio.set_apm_para\":{\"function\":\"sw_ans\",\"param\":[{\"force\": false,\"enable\":false}]}}");
            }
            RtcEngine rtcEngine3 = rtcEngine;
            if (rtcEngine3 != null) {
                rtcEngine3.setParameters("{\"che.audio.enable.nsng\":true}");
            }
            RtcEngine rtcEngine4 = rtcEngine;
            if (rtcEngine4 != null) {
                rtcEngine4.setParameters("{\"che.audio.ains_mode\":2}");
            }
            RtcEngine rtcEngine5 = rtcEngine;
            if (rtcEngine5 != null) {
                rtcEngine5.setParameters("{\"che.audio.ns.mode\":2}");
            }
            RtcEngine rtcEngine6 = rtcEngine;
            if (rtcEngine6 != null) {
                rtcEngine6.setParameters("{\"che.audio.nsng.lowerBound\":10}");
            }
            RtcEngine rtcEngine7 = rtcEngine;
            if (rtcEngine7 != null) {
                rtcEngine7.setParameters("{\"che.audio.nsng.lowerMask\":10}");
            }
            RtcEngine rtcEngine8 = rtcEngine;
            if (rtcEngine8 != null) {
                rtcEngine8.setParameters("{\"che.audio.nsng.statisticalbound\":0}");
            }
            RtcEngine rtcEngine9 = rtcEngine;
            if (rtcEngine9 != null) {
                rtcEngine9.setParameters("{\"che.audio.nsng.finallowermask\":8}");
            }
            RtcEngine rtcEngine10 = rtcEngine;
            if (rtcEngine10 != null) {
                rtcEngine10.setParameters("{\"che.audio.set_apm_para\": {\"function\": \"music_detection\", \"param\": [{\"force\": true, \"enable\": false}]}}");
                return;
            }
            return;
        }
        RtcEngine rtcEngine11 = rtcEngine;
        if (rtcEngine11 != null) {
            rtcEngine11.setParameters("{\"che.audio.ains_mode\":0}");
        }
        RtcEngine rtcEngine12 = rtcEngine;
        if (rtcEngine12 != null) {
            rtcEngine12.setParameters("{\"che.audio.ns.mode\":0}");
        }
        RtcEngine rtcEngine13 = rtcEngine;
        if (rtcEngine13 != null) {
            rtcEngine13.setParameters("{\"che.audio.nsng.lowerBound\":80}");
        }
        RtcEngine rtcEngine14 = rtcEngine;
        if (rtcEngine14 != null) {
            rtcEngine14.setParameters("{\"che.audio.nsng.lowerMask\":50}");
        }
        RtcEngine rtcEngine15 = rtcEngine;
        if (rtcEngine15 != null) {
            rtcEngine15.setParameters("{\"che.audio.nsng.statisticalbound\":5}");
        }
        RtcEngine rtcEngine16 = rtcEngine;
        if (rtcEngine16 != null) {
            rtcEngine16.setParameters("{\"che.audio.nsng.finallowermask\":30}");
        }
    }

    private final void initEngine(Context context) {
        String str;
        rtcEngineInit = true;
        RtcEngineConfig rtcEngineConfig = new RtcEngineConfig();
        rtcEngineConfig.mContext = context;
        rtcEngineConfig.mEventHandler = new AgoraRtcEventHandler();
        ServerInfo selectedServerInfo = BaseServer.INSTANCE.getSelectedServerInfo();
        if (selectedServerInfo == null || (str = selectedServerInfo.getAgoraAppID()) == null) {
            str = "";
        }
        rtcEngineConfig.mAppId = str;
        RtcEngineConfig.LogConfig logConfig = new RtcEngineConfig.LogConfig();
        logConfig.level = Constants.LogLevel.getValue(Constants.LogLevel.LOG_LEVEL_INFO);
        rtcEngineConfig.mLogConfig = logConfig;
        RtcEngine create = RtcEngine.create(rtcEngineConfig);
        rtcEngine = create;
        if (create != null) {
            create.setChannelProfile(1);
            INSTANCE.enableDeepLearning(true);
            int clientRole = create.setClientRole(1);
            if (clientRole < 0) {
                DebugToolsKt.printfE("修改声网用户的用户角色报错！！！" + clientRole);
            }
            create.setCameraCapturerConfiguration(new CameraCapturerConfiguration(CameraCapturerConfiguration.CD_1920x1080, CameraCapturerConfiguration.CAMERA_DIRECTION.CAMERA_FRONT));
        }
    }

    public static /* synthetic */ void joinChannel$default(AgoraRtcService agoraRtcService, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = "Extra Optional Data";
        }
        agoraRtcService.joinChannel(str, str2, str3, i);
    }

    public static /* synthetic */ void leaveChannel$default(AgoraRtcService agoraRtcService, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        agoraRtcService.leaveChannel(str);
    }

    private final void loggingAgora(String videoId) {
        String str;
        RtcEngine rtcEngine2 = getRtcEngine();
        if (rtcEngine2 != null) {
            str = rtcEngine2.uploadLogFile();
        } else {
            str = null;
        }
        DebugToolsKt.printf(TAG, "logginAgora " + str);
        if (str != null) {
            nd.c n = AppServer.INSTANCE.getApis().loggingAgora(videoId, str).p(ke.a.b()).n(new g() { // from class: com.qiahao.nextvideo.data.service.agora.AgoraRtcService$loggingAgora$1$1
                public final void accept(ApiResponse<Object> apiResponse) {
                    Intrinsics.checkNotNullParameter(apiResponse, "it");
                    DebugToolsKt.printf(AgoraRtcService.TAG, "logginAgora " + apiResponse);
                }
            }, new g() { // from class: com.qiahao.nextvideo.data.service.agora.AgoraRtcService$loggingAgora$1$2
                public final void accept(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "it");
                    String localizedMessage = th.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = "loggingAgora error";
                    }
                    DebugToolsKt.printfE(AgoraRtcService.TAG, "logginAgora", localizedMessage);
                }
            });
            Intrinsics.checkNotNullExpressionValue(n, "subscribe(...)");
            RxUtilsKt.addTo(n, new nd.a());
        }
    }

    public final void destroy() {
        RtcEngine.destroy();
        rtcEngineInit = false;
        rtcEngine = null;
    }

    public final void disableVideo() {
        RtcEngine rtcEngine2 = getRtcEngine();
        if (rtcEngine2 != null) {
            rtcEngine2.disableVideo();
        }
    }

    public final void enableLocalVideo(boolean enableLocalVideo) {
        RtcEngine rtcEngine2 = getRtcEngine();
        if (rtcEngine2 != null) {
            rtcEngine2.enableLocalVideo(enableLocalVideo);
        }
    }

    public final void enableVideo(boolean isSetBeautyOptions) {
        RtcEngine rtcEngine2 = getRtcEngine();
        if (rtcEngine2 != null) {
            rtcEngine2.enableVideo();
        }
        if (isSetBeautyOptions) {
            setBeautyOption();
        }
    }

    @NotNull
    public final BeautyOptions getBeautyOptions() {
        BeautyOptions beautyOptions2 = beautyOptions;
        if (beautyOptions2 != null) {
            return beautyOptions2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("beautyOptions");
        return null;
    }

    public final int getDataStreamID() {
        return dataStreamID;
    }

    @NotNull
    public final la.b getFaceDetectionStateRelay() {
        return faceDetectionStateRelay;
    }

    public final int getLocalVideoState() {
        return localVideoState;
    }

    @NotNull
    public final la.b getLocalVideoStateRelay() {
        return localVideoStateRelay;
    }

    @NotNull
    public final la.b getRemoteFaceStatusRelay() {
        return remoteFaceStatusRelay;
    }

    @NotNull
    public final c getRemoteVideoStateRelay() {
        return remoteVideoStateRelay;
    }

    @NotNull
    public final c getRemoteVideoStatusRelay() {
        return remoteVideoStatusRelay;
    }

    @Nullable
    public final RtcEngine getRtcEngine() {
        if (rtcEngine == null) {
            initEngine(HiloApplication.INSTANCE.getCONTEXT());
        }
        return rtcEngine;
    }

    public final boolean getRtcEngineInit() {
        return rtcEngineInit;
    }

    public final void joinChannel(@NotNull String token, @NotNull String channelName, @NotNull String optionalInfo, int agoraId) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(optionalInfo, "optionalInfo");
        RtcEngine rtcEngine2 = getRtcEngine();
        if (rtcEngine2 != null) {
            rtcEngine2.leaveChannel();
        }
        RtcEngine rtcEngine3 = getRtcEngine();
        if (rtcEngine3 != null) {
            rtcEngine3.setCameraCapturerConfiguration(new CameraCapturerConfiguration(CameraCapturerConfiguration.CAPTURER_OUTPUT_PREFERENCE.CAPTURER_OUTPUT_PREFERENCE_AUTO, CameraCapturerConfiguration.CAMERA_DIRECTION.CAMERA_FRONT));
        }
        RtcEngine rtcEngine4 = getRtcEngine();
        if (rtcEngine4 != null) {
            rtcEngine4.setChannelProfile(1);
        }
        ChannelMediaOptions channelMediaOptions = new ChannelMediaOptions();
        channelMediaOptions.autoSubscribeAudio = true;
        channelMediaOptions.autoSubscribeVideo = true;
        RtcEngine rtcEngine5 = rtcEngine;
        if (rtcEngine5 != null) {
            i = rtcEngine5.joinChannel(token, channelName, optionalInfo, agoraId, channelMediaOptions);
        } else {
            i = 0;
        }
        if (i < 0) {
            DebugToolsKt.printfE(TAG, "加入声网通道失败-joinChannel(): " + i + ", agoraid: " + agoraId + "， channelName：" + channelName + ",token:" + token);
            if (i == -5) {
                leaveChannel$default(this, null, 1, null);
            }
        }
        DebugToolsKt.printf(TAG, "joinChannel(): " + i + ", agoraid: " + agoraId);
        e.c("joinChannel()调用进入声网 channelName:" + channelName + ", resultCode:" + i + ", agoraid: " + agoraId);
        if (i == 0) {
            DataStreamConfig dataStreamConfig = new DataStreamConfig();
            dataStreamConfig.syncWithAudio = true;
            dataStreamConfig.ordered = true;
            RtcEngine rtcEngine6 = getRtcEngine();
            if (rtcEngine6 != null) {
                i2 = rtcEngine6.createDataStream(dataStreamConfig);
            } else {
                i2 = 0;
            }
            dataStreamID = i2;
            DebugToolsKt.printf(TAG, "createDataStream result: " + i2);
        }
        RtcEngine rtcEngine7 = getRtcEngine();
        if (rtcEngine7 != null) {
            rtcEngine7.setClientRole(1);
        }
    }

    public final void leaveChannel(@Nullable String videoId) {
        Integer num;
        RtcEngine rtcEngine2 = rtcEngine;
        String str = null;
        if (rtcEngine2 != null) {
            num = Integer.valueOf(rtcEngine2.leaveChannel());
        } else {
            num = null;
        }
        RtcEngine rtcEngine3 = rtcEngine;
        if (rtcEngine3 != null) {
            str = rtcEngine3.getCallId();
        }
        e.c("leaveChannel()调用离开声网: " + num + ", callId: " + str);
        RtcEngine rtcEngine4 = rtcEngine;
        if (rtcEngine4 != null) {
            rtcEngine4.stopAudioMixing();
        }
        if (videoId != null) {
            INSTANCE.loggingAgora(videoId);
        }
    }

    @NotNull
    public final i0<ApiResponse<Object>> postUnionUserPicture(@NotNull String matchUniqueId, @NotNull String picUrl) {
        Intrinsics.checkNotNullParameter(matchUniqueId, "matchUniqueId");
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        return AppServer.INSTANCE.getApis().matchPic(picUrl, matchUniqueId);
    }

    public final boolean sendStreamMessage(@NotNull byte[] toByteArray) {
        Intrinsics.checkNotNullParameter(toByteArray, "toByteArray");
        RtcEngine rtcEngine2 = getRtcEngine();
        if (rtcEngine2 == null || rtcEngine2.sendStreamMessage(dataStreamID, toByteArray) != 0) {
            return false;
        }
        return true;
    }

    public final void setBeautyOption() {
        setBeautyOptions(new BeautyOptions());
        getBeautyOptions().smoothnessLevel = 0.5f;
        getBeautyOptions().lighteningLevel = 0.25f;
        getBeautyOptions().rednessLevel = 0.0f;
        getBeautyOptions().lighteningContrastLevel = 1;
        RtcEngine rtcEngine2 = getRtcEngine();
        if (rtcEngine2 != null) {
            rtcEngine2.setBeautyEffectOptions(true, getBeautyOptions());
        }
    }

    public final void setBeautyOptions(@NotNull BeautyOptions beautyOptions2) {
        Intrinsics.checkNotNullParameter(beautyOptions2, "<set-?>");
        beautyOptions = beautyOptions2;
    }

    public final void setDataStreamID(int i) {
        dataStreamID = i;
    }

    public final void setFaceDetectionStateRelay(@NotNull la.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        faceDetectionStateRelay = bVar;
    }

    public final void setLocalVideoState(int i) {
        localVideoState = i;
    }

    public final void setRtcEngineInit(boolean z) {
        rtcEngineInit = z;
    }
}
