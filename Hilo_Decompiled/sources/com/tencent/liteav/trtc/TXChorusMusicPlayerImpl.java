package com.tencent.liteav.trtc;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TXChorusMusicPlayer;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@JNINamespace("liteav::chorus")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TXChorusMusicPlayerImpl extends TXChorusMusicPlayer {
    private static final String TAG = "TXChorusMusicPlayerImpl";
    private final ChorusPlayerListener mListener = new ChorusPlayerListener(0);
    private long mNativePtr;
    private TRTCCloud mSubTRTCCloud;
    private TRTCCloud mTRTCCloud;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.trtc.TXChorusMusicPlayerImpl$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[TXChorusMusicPlayer.TXChorusMusicTrack.values().length];
            b = iArr;
            try {
                iArr[TXChorusMusicPlayer.TXChorusMusicTrack.TXChorusAccompaniment.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[TXChorusMusicPlayer.TXChorusMusicTrack.TXChorusOriginalSong.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[TXChorusMusicPlayer.TXChorusRole.values().length];
            a = iArr2;
            try {
                iArr2[TXChorusMusicPlayer.TXChorusRole.TXChorusRoleLeadSinger.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[TXChorusMusicPlayer.TXChorusRole.TXChorusRoleBackSinger.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[TXChorusMusicPlayer.TXChorusRole.TXChorusRoleAnchor.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[TXChorusMusicPlayer.TXChorusRole.TXChorusRoleAudience.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class EnterRoomParams {
        private final TRTCCloudDef.TRTCParams a;

        public EnterRoomParams(TRTCCloudDef.TRTCParams tRTCParams) {
            this.a = tRTCParams;
        }

        public String getBusinessInfo() {
            return this.a.businessInfo;
        }

        public String getPrivateMapKey() {
            return this.a.privateMapKey;
        }

        public int getRole() {
            return this.a.role;
        }

        public int getRoomId() {
            return this.a.roomId;
        }

        public int getSdkAppId() {
            return this.a.sdkAppId;
        }

        public String getStrRoomId() {
            return this.a.strRoomId;
        }

        public String getStreamId() {
            return this.a.streamId;
        }

        public String getUserDefineRecordId() {
            return this.a.userDefineRecordId;
        }

        public String getUserId() {
            return this.a.userId;
        }

        public String getUserSig() {
            return this.a.userSig;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class TXChorusLyricCharacterList {
        final List<TXChorusMusicPlayer.TXChorusLyricCharacter> a;

        public TXChorusLyricCharacterList(int i) {
            this.a = new ArrayList(i);
        }

        public void add(int i, long j, long j2, String str) {
            TXChorusMusicPlayer.TXChorusLyricCharacter tXChorusLyricCharacter = new TXChorusMusicPlayer.TXChorusLyricCharacter();
            tXChorusLyricCharacter.startTimeMs = j;
            tXChorusLyricCharacter.durationMs = j2;
            tXChorusLyricCharacter.utf8Character = str;
            this.a.add(i, tXChorusLyricCharacter);
        }

        public List<TXChorusMusicPlayer.TXChorusLyricCharacter> getChorusLyricCharacterList() {
            return this.a;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class TXLyricLineList {
        final List<TXChorusMusicPlayer.TXLyricLine> a;

        public TXLyricLineList(int i) {
            this.a = new ArrayList(i);
        }

        public void add(int i, long j, long j2, List<TXChorusMusicPlayer.TXChorusLyricCharacter> list) {
            TXChorusMusicPlayer.TXLyricLine tXLyricLine = new TXChorusMusicPlayer.TXLyricLine();
            tXLyricLine.startTimeMs = j;
            tXLyricLine.durationMs = j2;
            tXLyricLine.characterArray = list;
            this.a.add(i, tXLyricLine);
        }

        public List<TXChorusMusicPlayer.TXLyricLine> getLyricLineList() {
            return this.a;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class TXReferencePitchList {
        final List<TXChorusMusicPlayer.TXReferencePitch> a;

        public TXReferencePitchList(int i) {
            this.a = new ArrayList(i);
        }

        public void add(int i, long j, long j2, int i2) {
            TXChorusMusicPlayer.TXReferencePitch tXReferencePitch = new TXChorusMusicPlayer.TXReferencePitch();
            tXReferencePitch.startTimeMs = j;
            tXReferencePitch.durationMs = j2;
            tXReferencePitch.referencePitch = i2;
            this.a.add(i, tXReferencePitch);
        }

        public List<TXChorusMusicPlayer.TXReferencePitch> getTXReferencePitchList() {
            return this.a;
        }
    }

    private TXChorusMusicPlayerImpl(TRTCCloud tRTCCloud, String str, TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener) {
        long j;
        long j2 = 0;
        this.mNativePtr = 0L;
        this.mTRTCCloud = null;
        this.mSubTRTCCloud = null;
        if (tRTCCloud == null) {
            return;
        }
        this.mTRTCCloud = tRTCCloud;
        try {
            j = parseNativePointer(tRTCCloud.callExperimentalAPI("{\"api\":\"getNativeHandle\"}"));
        } catch (Throwable th) {
            LiteavLog.e(TAG, "get main trtcCloud native handle fail.", th);
            j = 0;
        }
        try {
            TRTCCloud createSubCloud = tRTCCloud.createSubCloud();
            this.mSubTRTCCloud = createSubCloud;
            j2 = parseNativePointer(createSubCloud.callExperimentalAPI("{\"api\":\"getNativeHandle\"}"));
        } catch (Throwable th2) {
            LiteavLog.e(TAG, "get sub trtcCloud native handle fail.", th2);
        }
        long j3 = j2;
        ChorusPlayerListener chorusPlayerListener = this.mListener;
        chorusPlayerListener.a = iTXChorusPlayerListener;
        this.mNativePtr = nativeCreate(j, j3, str, chorusPlayerListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TXChorusMusicPlayer.TXChorusError convertIntValueToTXChorusError(int i) {
        switch (i) {
            case 1:
                return TXChorusMusicPlayer.TXChorusError.TXChorusErrorInvalidParameters;
            case 2:
                return TXChorusMusicPlayer.TXChorusError.TXChorusErrorTrtcCloudNotFound;
            case 3:
                return TXChorusMusicPlayer.TXChorusError.TXChorusErrorRestrictedToLeadSinger;
            case 4:
                return TXChorusMusicPlayer.TXChorusError.TXChorusErrorMusicPreloadRequired;
            case 5:
                return TXChorusMusicPlayer.TXChorusError.TXChorusErrorMusicLoadFailed;
            case 6:
                return TXChorusMusicPlayer.TXChorusError.TXChorusErrorMusicDecodeFailed;
            case 7:
                return TXChorusMusicPlayer.TXChorusError.TXChorusErrorEnterRoomFailed;
            case 8:
                return TXChorusMusicPlayer.TXChorusError.TXChorusErrorRoomDisconnected;
            case 9:
                return TXChorusMusicPlayer.TXChorusError.TXChorusErrorTrtcError;
            default:
                LiteavLog.w(TAG, "chorus error value is undefined. chorusErrorValue=".concat(String.valueOf(i)));
                return null;
        }
    }

    public static TXChorusMusicPlayer create(TRTCCloud tRTCCloud, String str, TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener) {
        return new TXChorusMusicPlayerImpl(tRTCCloud, str, iTXChorusPlayerListener);
    }

    private static int getTXChorusMusicTrackIntValue(TXChorusMusicPlayer.TXChorusMusicTrack tXChorusMusicTrack) {
        if (tXChorusMusicTrack == null) {
            LiteavLog.w(TAG, "music track enum is null. musicTrack=".concat(String.valueOf(tXChorusMusicTrack)));
            return -1;
        }
        int i = AnonymousClass1.b[tXChorusMusicTrack.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                LiteavLog.w(TAG, "music track enum is unknown. musicTrack=".concat(String.valueOf(tXChorusMusicTrack)));
                return -1;
            }
        }
        return i2;
    }

    private static int getTXChorusRoleIntValue(TXChorusMusicPlayer.TXChorusRole tXChorusRole) {
        if (tXChorusRole == null) {
            LiteavLog.w(TAG, "chorus role enum is null. chorusRole=".concat(String.valueOf(tXChorusRole)));
            return -1;
        }
        int i = AnonymousClass1.a[tXChorusRole.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        LiteavLog.w(TAG, "chorus role enum is unknown. chorusRole=".concat(String.valueOf(tXChorusRole)));
                        return -1;
                    }
                }
            }
        }
        return i2;
    }

    private static native void nativeCallExperimentalAPI(long j, String str);

    private static native long nativeCreate(long j, long j2, String str, ChorusPlayerListener chorusPlayerListener);

    private static native void nativeDestroy(long j);

    private static native void nativeLoadExternalMusic(long j, String str, String str2, String str3, boolean z, int i);

    private static native void nativeLoadMusic(long j, String str, String str2, String str3, String str4);

    private static native void nativeLoadYsdMusic(long j, String str, String str2, String str3, String str4, String str5, String str6, boolean z);

    private static native void nativePause(long j);

    private static native void nativeResume(long j);

    private static native void nativeSeek(long j, long j2);

    private static native void nativeSetChorusRole(long j, int i, EnterRoomParams enterRoomParams);

    private static native void nativeSetMusicPitch(long j, float f);

    private static native void nativeSetPlayoutVolume(long j, int i);

    private static native void nativeSetPublishVolume(long j, int i);

    private static native void nativeStart(long j);

    private static native void nativeStop(long j);

    private static native void nativeSwitchMusicTrack(long j, int i);

    private static long parseNativePointer(String str) {
        try {
            BigInteger bigInteger = new BigInteger(str);
            if (bigInteger.bitLength() > 64) {
                LiteavLog.e(TAG, "Parsing pointer exceeding 64 bits. native pointer is ".concat(String.valueOf(str)));
                return 0L;
            }
            return bigInteger.longValue();
        } catch (Throwable th) {
            LiteavLog.e(TAG, "Parsing pointer fail. native pointer is ".concat(String.valueOf(str)), th);
            return 0L;
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void callExperimentalAPI(String str) {
        long j = this.mNativePtr;
        if (j != 0) {
            nativeCallExperimentalAPI(j, str);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void destroy() {
        TRTCCloud tRTCCloud;
        try {
            long j = this.mNativePtr;
            if (j != 0) {
                nativeDestroy(j);
                this.mNativePtr = 0L;
            }
            TRTCCloud tRTCCloud2 = this.mTRTCCloud;
            if (tRTCCloud2 != null && (tRTCCloud = this.mSubTRTCCloud) != null) {
                tRTCCloud2.destroySubCloud(tRTCCloud);
                this.mSubTRTCCloud = null;
                this.mTRTCCloud = null;
            }
            this.mListener.a = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        long j = this.mNativePtr;
        if (j != 0) {
            LiteavLog.w(TAG, "object is not destroyed. will be memory leak. native pointer is %#x.", Long.valueOf(j));
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void loadExternalMusic(TXChorusMusicPlayer.TXChorusExternalMusicParams tXChorusExternalMusicParams) {
        long j = this.mNativePtr;
        if (j != 0 && tXChorusExternalMusicParams != null) {
            nativeLoadExternalMusic(j, tXChorusExternalMusicParams.musicId, tXChorusExternalMusicParams.musicUrl, tXChorusExternalMusicParams.accompanyUrl, tXChorusExternalMusicParams.isEncrypted, tXChorusExternalMusicParams.encryptBlockLength);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void loadMusic(TXChorusMusicPlayer.TXChorusCopyrightedMusicParams tXChorusCopyrightedMusicParams) {
        long j = this.mNativePtr;
        if (j != 0 && tXChorusCopyrightedMusicParams != null) {
            nativeLoadMusic(j, tXChorusCopyrightedMusicParams.musicId, tXChorusCopyrightedMusicParams.playToken, tXChorusCopyrightedMusicParams.copyrightedLicenseKey, tXChorusCopyrightedMusicParams.copyrightedLicenseUrl);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void loadYsdMusic(TXChorusMusicPlayer.TXChorusYsdMusicParams tXChorusYsdMusicParams) {
        long j = this.mNativePtr;
        if (j != 0 && tXChorusYsdMusicParams != null) {
            nativeLoadYsdMusic(j, tXChorusYsdMusicParams.musicId, tXChorusYsdMusicParams.userId, tXChorusYsdMusicParams.userToken, tXChorusYsdMusicParams.deviceId, tXChorusYsdMusicParams.appId, tXChorusYsdMusicParams.appKey, tXChorusYsdMusicParams.isChargedOnce);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void pause() {
        long j = this.mNativePtr;
        if (j != 0) {
            nativePause(j);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void resume() {
        long j = this.mNativePtr;
        if (j != 0) {
            nativeResume(j);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void seek(long j) {
        long j2 = this.mNativePtr;
        if (j2 != 0) {
            nativeSeek(j2, j);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void setChorusRole(TXChorusMusicPlayer.TXChorusRole tXChorusRole, TRTCCloudDef.TRTCParams tRTCParams) {
        EnterRoomParams enterRoomParams;
        try {
            if (this.mNativePtr != 0 && tXChorusRole != null) {
                if (tRTCParams != null) {
                    enterRoomParams = new EnterRoomParams(tRTCParams);
                } else {
                    enterRoomParams = null;
                }
                nativeSetChorusRole(this.mNativePtr, getTXChorusRoleIntValue(tXChorusRole), enterRoomParams);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public void setListener(TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener) {
        this.mListener.a = iTXChorusPlayerListener;
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void setMusicPitch(float f) {
        long j = this.mNativePtr;
        if (j != 0) {
            nativeSetMusicPitch(j, f);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void setPlayoutVolume(int i) {
        long j = this.mNativePtr;
        if (j != 0) {
            nativeSetPlayoutVolume(j, i);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void setPublishVolume(int i) {
        long j = this.mNativePtr;
        if (j != 0) {
            nativeSetPublishVolume(j, i);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void start() {
        long j = this.mNativePtr;
        if (j != 0) {
            nativeStart(j);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void stop() {
        long j = this.mNativePtr;
        if (j != 0) {
            nativeStop(j);
        }
    }

    @Override // com.tencent.trtc.TXChorusMusicPlayer
    public synchronized void switchMusicTrack(TXChorusMusicPlayer.TXChorusMusicTrack tXChorusMusicTrack) {
        long j = this.mNativePtr;
        if (j != 0 && tXChorusMusicTrack != null) {
            nativeSwitchMusicTrack(j, getTXChorusMusicTrackIntValue(tXChorusMusicTrack));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class ChorusPlayerListener {
        TXChorusMusicPlayer.ITXChorusPlayerListener a;

        private ChorusPlayerListener() {
            this.a = null;
        }

        public void onChorusError(int i, String str) {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onChorusError(TXChorusMusicPlayerImpl.convertIntValueToTXChorusError(i), str);
            }
        }

        public void onChorusMusicLoadProgress(String str, float f) {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onChorusMusicLoadProgress(str, f);
            }
        }

        public void onChorusMusicLoadSucceed(String str, List<TXChorusMusicPlayer.TXLyricLine> list, List<TXChorusMusicPlayer.TXReferencePitch> list2) {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onChorusMusicLoadSucceed(str, list, list2);
            }
        }

        public void onChorusPaused() {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onChorusPaused();
            }
        }

        public void onChorusRequireLoadMusic(String str) {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onChorusRequireLoadMusic(str);
            }
        }

        public void onChorusResumed() {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onChorusResumed();
            }
        }

        public void onChorusStarted() {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onChorusStarted();
            }
        }

        public void onChorusStopped() {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onChorusStopped();
            }
        }

        public void onMusicProgressUpdated(long j, long j2) {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onMusicProgressUpdated(j, j2);
            }
        }

        public void onNetworkQualityUpdated(int i, int i2, int i3) {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onNetworkQualityUpdated(i, i2, i3);
            }
        }

        public void onVoicePitchUpdated(int i, boolean z, long j) {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onVoicePitchUpdated(i, z, j);
            }
        }

        public void onVoiceScoreUpdated(int i, int i2, int i3) {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.onVoiceScoreUpdated(i, i2, i3);
            }
        }

        public void shouldDecryptAudioData(ByteBuffer byteBuffer) {
            TXChorusMusicPlayer.ITXChorusPlayerListener iTXChorusPlayerListener = this.a;
            if (iTXChorusPlayerListener != null) {
                iTXChorusPlayerListener.shouldDecryptAudioData(byteBuffer);
            }
        }

        /* synthetic */ ChorusPlayerListener(byte b) {
            this();
        }
    }
}
