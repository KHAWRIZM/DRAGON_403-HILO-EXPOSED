package com.tencent.trtc;

import com.tencent.liteav.trtc.TXChorusMusicPlayerImpl;
import com.tencent.trtc.TRTCCloudDef;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class TXChorusMusicPlayer {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface ITXChorusPlayerListener {
        void onChorusError(TXChorusError tXChorusError, String str);

        void onChorusMusicLoadProgress(String str, float f);

        void onChorusMusicLoadSucceed(String str, List<TXLyricLine> list, List<TXReferencePitch> list2);

        void onChorusPaused();

        void onChorusRequireLoadMusic(String str);

        void onChorusResumed();

        void onChorusStarted();

        void onChorusStopped();

        void onMusicProgressUpdated(long j, long j2);

        void onNetworkQualityUpdated(int i, int i2, int i3);

        void onVoicePitchUpdated(int i, boolean z, long j);

        void onVoiceScoreUpdated(int i, int i2, int i3);

        void shouldDecryptAudioData(ByteBuffer byteBuffer);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class TXChorusCopyrightedMusicParams {
        public String musicId = null;
        public String playToken = null;
        public String copyrightedLicenseKey = null;
        public String copyrightedLicenseUrl = null;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum TXChorusError {
        TXChorusErrorInvalidParameters,
        TXChorusErrorTrtcCloudNotFound,
        TXChorusErrorRestrictedToLeadSinger,
        TXChorusErrorMusicPreloadRequired,
        TXChorusErrorMusicLoadFailed,
        TXChorusErrorMusicDecodeFailed,
        TXChorusErrorEnterRoomFailed,
        TXChorusErrorRoomDisconnected,
        TXChorusErrorTrtcError
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class TXChorusExternalMusicParams {
        public String musicId = null;
        public String musicUrl = null;
        public String accompanyUrl = null;
        public boolean isEncrypted = false;
        public int encryptBlockLength = 0;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class TXChorusLyricCharacter {
        public long startTimeMs = 0;
        public long durationMs = 0;
        public String utf8Character = null;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum TXChorusMusicTrack {
        TXChorusAccompaniment,
        TXChorusOriginalSong
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum TXChorusRole {
        TXChorusRoleLeadSinger,
        TXChorusRoleBackSinger,
        TXChorusRoleAnchor,
        TXChorusRoleAudience
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class TXChorusYsdMusicParams {
        public String musicId = null;
        public String userId = null;
        public String userToken = null;
        public String deviceId = null;
        public String appId = null;
        public String appKey = null;
        public boolean isChargedOnce = false;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class TXLyricLine {
        public long startTimeMs = 0;
        public long durationMs = 0;
        public List<TXChorusLyricCharacter> characterArray = null;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class TXReferencePitch {
        public long startTimeMs = 0;
        public long durationMs = 0;
        public int referencePitch = 0;
    }

    public static TXChorusMusicPlayer create(TRTCCloud tRTCCloud, String str, ITXChorusPlayerListener iTXChorusPlayerListener) {
        return TXChorusMusicPlayerImpl.create(tRTCCloud, str, iTXChorusPlayerListener);
    }

    public abstract void callExperimentalAPI(String str);

    public abstract void destroy();

    public abstract void loadExternalMusic(TXChorusExternalMusicParams tXChorusExternalMusicParams);

    public abstract void loadMusic(TXChorusCopyrightedMusicParams tXChorusCopyrightedMusicParams);

    public abstract void loadYsdMusic(TXChorusYsdMusicParams tXChorusYsdMusicParams);

    public abstract void pause();

    public abstract void resume();

    public abstract void seek(long j);

    public abstract void setChorusRole(TXChorusRole tXChorusRole, TRTCCloudDef.TRTCParams tRTCParams);

    public abstract void setListener(ITXChorusPlayerListener iTXChorusPlayerListener);

    public abstract void setMusicPitch(float f);

    public abstract void setPlayoutVolume(int i);

    public abstract void setPublishVolume(int i);

    public abstract void start();

    public abstract void stop();

    public abstract void switchMusicTrack(TXChorusMusicTrack tXChorusMusicTrack);
}
