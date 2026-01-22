package com.qiahao.nextvideo.data.service.agora;

import android.util.Log;
import com.oudi.utils.log.LogUtil;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.HiloApplication;
import com.qiahao.nextvideo.agoraadapter.IRTCEngine;
import com.qiahao.nextvideo.agoraadapter.IRTCEngineAdapter;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.tencent.qcloud.tuicore.TUIConstants;
import io.agora.rtc.models.ChannelMediaOptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import n5.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001d\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ&\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\rJ\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0015J\u0016\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u000fJ\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000fJ\u000e\u0010!\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u000fJ\u000e\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u0015J\u000e\u0010&\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u0015J\u0006\u0010'\u001a\u00020\u0015J\u0006\u0010(\u001a\u00020\u0015J\u0006\u0010)\u001a\u00020\u0015J\u0006\u0010*\u001a\u00020\u0015J\u0006\u0010+\u001a\u00020\u0015J\u000e\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u0015J \u0010.\u001a\u00020\u00152\b\u0010/\u001a\u0004\u0018\u00010\u00052\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u00062"}, d2 = {"Lcom/qiahao/nextvideo/data/service/agora/HiloRtcEngine;", "", "<init>", "()V", "TAG", "", "engine", "Lcom/qiahao/nextvideo/agoraadapter/IRTCEngine;", "getEngine", "()Lcom/qiahao/nextvideo/agoraadapter/IRTCEngine;", "setEngine", "(Lcom/qiahao/nextvideo/agoraadapter/IRTCEngine;)V", "initRtcEngine", "", "enableTRTC", "", TUIConstants.TUIBeauty.METHOD_DESTROY_XMAGIC, "joinChannel", "agoraToken", "channelName", "agoraId", "", "provider", "leaveChannel", "setClientRole", "role", "setRemoteMute", "isMute", "muteAllRemoteAudioStreams", "enableLocalAudio", "isOpenLocalAudio", "setEnableAiNoiseReduction", "enable", "adjustRecordingSignalVolume", "muteLocalAudio", "mute", "adjustAudioMixingVolume", "volume", "adjustAudioMixingPlayOutVolume", "resumeAudioMixing", "pauseAudioMixing", "stopAudioMixing", "audioMixingCurrentPosition", "audioMixingDuration", "setAudioMixingPosition", "position", "startAudioMixing", "filePath", "loopback", "cycle", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HiloRtcEngine {

    @NotNull
    public static final HiloRtcEngine INSTANCE = new HiloRtcEngine();

    @NotNull
    public static final String TAG = "HiloRtcEngine";

    @Nullable
    private static IRTCEngine engine;

    private HiloRtcEngine() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void destroy$lambda$0() {
        try {
            if (engine != null) {
                IRTCEngineAdapter.destroy();
                engine = null;
            }
        } catch (Exception e) {
            LogUtil logUtil = LogUtil.INSTANCE;
            e.printStackTrace();
            LogUtil.e$default(logUtil, TAG, "关闭rtc 失败:" + Unit.INSTANCE, false, 4, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void joinChannel$lambda$1(int i, String str, String str2, int i2) {
        boolean z;
        int i3;
        String str3;
        String str4;
        String str5;
        int i4;
        HiloRtcEngine hiloRtcEngine = INSTANCE;
        if (i == 1) {
            z = true;
        } else {
            z = false;
        }
        hiloRtcEngine.initRtcEngine(z);
        IRTCEngine iRTCEngine = engine;
        if (iRTCEngine != null) {
            iRTCEngine.setParameters("{\"che.audio.SL.outStereo\":false}");
        }
        IRTCEngine iRTCEngine2 = engine;
        if (iRTCEngine2 != null) {
            if (i == 1) {
                i4 = 2;
            } else {
                i4 = 0;
            }
            iRTCEngine2.setAudioProfile(i4, 3);
        }
        IRTCEngine iRTCEngine3 = engine;
        if (iRTCEngine3 != null) {
            iRTCEngine3.enableAudioVolumeIndication(1000, 3, false);
        }
        IRTCEngine iRTCEngine4 = engine;
        if (iRTCEngine4 != null) {
            iRTCEngine4.setChannelProfile(1);
        }
        ChannelMediaOptions channelMediaOptions = new ChannelMediaOptions();
        IRTCEngine iRTCEngine5 = engine;
        if (iRTCEngine5 != null) {
            i3 = iRTCEngine5.joinChannel(str, str2, "Extra Optional Data", i2, channelMediaOptions);
        } else {
            i3 = -1;
        }
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        String str6 = null;
        if (user != null) {
            str3 = user.getCode();
        } else {
            str3 = null;
        }
        e.c("groupJoinChannel()进入声网通道 channelName= " + str2 + " resultCode= " + i3 + ", optionalUid:" + str3);
        if (i3 < 0) {
            User user2 = companion.getShared().getUser();
            if (user2 != null) {
                str4 = user2.getCode();
            } else {
                str4 = null;
            }
            e.c("加入声网通道失败-joinChannel(): " + i3 + ", optionalUid:" + str4);
            if (i3 == -5) {
                User user3 = companion.getShared().getUser();
                if (user3 != null) {
                    str5 = user3.getCode();
                } else {
                    str5 = null;
                }
                e.c("加入声网通道失败-joinChannel(): " + i3 + ", optionalUid:" + str5);
            }
        } else {
            e.c("加入声网通道成功");
        }
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        User user4 = companion.getShared().getUser();
        if (user4 != null) {
            str6 = user4.getExternalId();
        }
        hiloRtcEngine.setEnableAiNoiseReduction(((Boolean) IStore.DefaultImpls.getValue$default(mMKVStore, "noiseReduction" + str6, Boolean.FALSE, (String) null, 4, (Object) null)).booleanValue());
    }

    public final void adjustAudioMixingPlayOutVolume(int volume) {
        IRTCEngine iRTCEngine = engine;
        if (iRTCEngine != null) {
            iRTCEngine.adjustAudioMixingPlayoutVolume(volume);
        }
    }

    public final void adjustAudioMixingVolume(int volume) {
        IRTCEngine iRTCEngine = engine;
        if (iRTCEngine != null) {
            iRTCEngine.adjustAudioMixingVolume(volume);
        }
    }

    public final void adjustRecordingSignalVolume(boolean isMute) {
        e.c("adjustRecordingSignalVolume() rtcEngine不为null 静音自己" + isMute);
        if (isMute) {
            IRTCEngine iRTCEngine = engine;
            if (iRTCEngine != null) {
                iRTCEngine.adjustRecordingSignalVolume(0);
                return;
            }
            return;
        }
        IRTCEngine iRTCEngine2 = engine;
        if (iRTCEngine2 != null) {
            iRTCEngine2.adjustRecordingSignalVolume(100);
        }
    }

    public final int audioMixingCurrentPosition() {
        IRTCEngine iRTCEngine = engine;
        if (iRTCEngine != null) {
            return iRTCEngine.getAudioMixingCurrentPosition();
        }
        return 0;
    }

    public final int audioMixingDuration() {
        IRTCEngine iRTCEngine = engine;
        if (iRTCEngine != null) {
            return iRTCEngine.getAudioMixingDuration();
        }
        return 0;
    }

    public final void destroy() {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.data.service.agora.b
            @Override // java.lang.Runnable
            public final void run() {
                HiloRtcEngine.destroy$lambda$0();
            }
        });
    }

    public final void enableLocalAudio(boolean isOpenLocalAudio) {
        IRTCEngine iRTCEngine = engine;
        if (iRTCEngine != null) {
            iRTCEngine.enableLocalAudio(isOpenLocalAudio);
        }
    }

    @Nullable
    public final IRTCEngine getEngine() {
        return engine;
    }

    public final void initRtcEngine(boolean enableTRTC) {
        engine = IRTCEngineAdapter.create(HiloApplication.INSTANCE.getCONTEXT(), new HiloRtcEventHandler(), enableTRTC);
    }

    public final void joinChannel(@NotNull final String agoraToken, @NotNull final String channelName, final int agoraId, final int provider) {
        Intrinsics.checkNotNullParameter(agoraToken, "agoraToken");
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.data.service.agora.a
            @Override // java.lang.Runnable
            public final void run() {
                HiloRtcEngine.joinChannel$lambda$1(provider, agoraToken, channelName, agoraId);
            }
        });
    }

    public final void leaveChannel() {
        try {
            IRTCEngine iRTCEngine = engine;
            if (iRTCEngine != null) {
                iRTCEngine.leaveChannel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void muteAllRemoteAudioStreams(boolean isMute) {
        IRTCEngine iRTCEngine = engine;
        if (iRTCEngine != null) {
            iRTCEngine.muteAllRemoteAudioStreams(isMute);
        }
    }

    public final void muteLocalAudio(boolean mute) {
        IRTCEngine iRTCEngine = engine;
        if (iRTCEngine != null) {
            iRTCEngine.muteLocalAudioStream(mute);
        }
    }

    public final int pauseAudioMixing() {
        AppRequestUtils.INSTANCE.roomStopMusic();
        IRTCEngine iRTCEngine = engine;
        if (iRTCEngine != null) {
            return iRTCEngine.pauseAudioMixing();
        }
        return -1;
    }

    public final int resumeAudioMixing() {
        AppRequestUtils.INSTANCE.roomStartMusic();
        IRTCEngine iRTCEngine = engine;
        if (iRTCEngine != null) {
            return iRTCEngine.resumeAudioMixing();
        }
        return -1;
    }

    public final void setAudioMixingPosition(int position) {
        IRTCEngine iRTCEngine = engine;
        if (iRTCEngine != null) {
            iRTCEngine.setAudioMixingPosition(position);
        }
    }

    public final void setClientRole(int role) {
        Log.d(TAG, "findMicUserMuteOrMute:  setRole " + role);
        IRTCEngine iRTCEngine = engine;
        if (iRTCEngine != null) {
            iRTCEngine.setClientRole(role);
        }
    }

    public final void setEnableAiNoiseReduction(boolean enable) {
        String str;
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "noiseReduction" + str, Boolean.valueOf(enable), (String) null, 4, (Object) null);
        IRTCEngine iRTCEngine = engine;
        if (iRTCEngine != null) {
            iRTCEngine.setEnableAiNoiseReduction(enable);
        }
    }

    public final void setEngine(@Nullable IRTCEngine iRTCEngine) {
        engine = iRTCEngine;
    }

    public final void setRemoteMute(int agoraId, boolean isMute) {
        IRTCEngine iRTCEngine = engine;
        if (iRTCEngine != null) {
            iRTCEngine.muteRemoteAudioStream(agoraId, isMute);
        }
    }

    public final int startAudioMixing(@Nullable String filePath, boolean loopback, int cycle) {
        IRTCEngine iRTCEngine = engine;
        if (iRTCEngine != null) {
            iRTCEngine.stopAudioMixing();
        }
        try {
            AppRequestUtils.INSTANCE.roomStartMusic();
            IRTCEngine iRTCEngine2 = engine;
            if (iRTCEngine2 == null) {
                return -1;
            }
            return iRTCEngine2.startAudioMixing(filePath, loopback, false, cycle);
        } catch (Exception unused) {
            return -1;
        }
    }

    public final int stopAudioMixing() {
        AppRequestUtils.INSTANCE.roomStopMusic();
        IRTCEngine iRTCEngine = engine;
        if (iRTCEngine != null) {
            return iRTCEngine.stopAudioMixing();
        }
        return -1;
    }
}
