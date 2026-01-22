package com.tencent.trtc.txcopyrightedmedia;

import android.content.Context;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia;

@JNINamespace("liteav::extensions")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TXCopyrightedMediaImpl extends TXCopyrightedMedia {
    private long mNativeTXCopyrightedMediaImpl = 0;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class TXSongScoreImpl implements TXCopyrightedMedia.ITXSongScore {
        private long mNativeTXCopyrightedSongScore;

        public TXSongScoreImpl(String str, int i, int i2, String str2, String str3, String str4) {
            this.mNativeTXCopyrightedSongScore = 0L;
            this.mNativeTXCopyrightedSongScore = TXCopyrightedMediaImpl.nativeCreateSongScore(TXCopyrightedMediaImpl.this.mNativeTXCopyrightedMediaImpl, this, str, i, i2, str2, str3, str4);
        }

        @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia.ITXSongScore
        public int calculateTotalScore() {
            return TXCopyrightedMediaImpl.nativeCalculateTotalScore(this.mNativeTXCopyrightedSongScore);
        }

        @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia.ITXSongScore
        public void destroy() {
            TXCopyrightedMediaImpl.nativeDestroySongScore(this.mNativeTXCopyrightedSongScore);
            this.mNativeTXCopyrightedSongScore = 0L;
        }

        @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia.ITXSongScore
        public void finish() {
            TXCopyrightedMediaImpl.nativeFinish(this.mNativeTXCopyrightedSongScore);
        }

        @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia.ITXSongScore
        public TXCopyrightedMedia.TXSongScoreNoteItem[] getAllGrove() {
            return TXCopyrightedMediaImpl.nativeGetAllGrove(this.mNativeTXCopyrightedSongScore);
        }

        public void onMIDIGroveAndHint(String str, boolean z, float f, float f2, int i, Object obj) {
            ((TXCopyrightedMedia.ITXSongScoreCallback) obj).onMIDIGroveAndHint(str, z, f, f2, i);
        }

        public void onMIDISCoreUpdate(String str, int i, int i2, int i3, Object obj) {
            ((TXCopyrightedMedia.ITXSongScoreCallback) obj).onMIDISCoreUpdate(str, i, i2, i3);
        }

        public void onMIDIScoreError(String str, int i, String str2, Object obj) {
            ((TXCopyrightedMedia.ITXSongScoreCallback) obj).onMIDIScoreError(str, i, str2);
        }

        public void onMIDIScoreFinish(String str, int[] iArr, int i, Object obj) {
            ((TXCopyrightedMedia.ITXSongScoreCallback) obj).onMIDIScoreFinish(str, iArr, i);
        }

        public void onMIDIScorePrepared(String str, Object obj) {
            ((TXCopyrightedMedia.ITXSongScoreCallback) obj).onMIDIScorePrepared(str);
        }

        @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia.ITXSongScore
        public void prepare() {
            TXCopyrightedMediaImpl.nativePrepare(this.mNativeTXCopyrightedSongScore);
        }

        @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia.ITXSongScore
        public void process(byte[] bArr, int i, float f) {
            TXCopyrightedMediaImpl.nativeProcess(this.mNativeTXCopyrightedSongScore, bArr, i, f);
        }

        @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia.ITXSongScore
        public void setKeyShift(int i) {
            TXCopyrightedMediaImpl.nativeSetKeyShift(this.mNativeTXCopyrightedSongScore, i);
        }

        @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia.ITXSongScore
        public void setSongScoreCallback(TXCopyrightedMedia.ITXSongScoreCallback iTXSongScoreCallback) {
            TXCopyrightedMediaImpl.nativeSetSongScoreCallback(this.mNativeTXCopyrightedSongScore, iTXSongScoreCallback);
        }
    }

    public static Object createClimaxTimeRange(int i, int i2) {
        TXCopyrightedMedia.TXClimaxTimeRange tXClimaxTimeRange = new TXCopyrightedMedia.TXClimaxTimeRange();
        tXClimaxTimeRange.startTime = i;
        tXClimaxTimeRange.endTime = i2;
        return tXClimaxTimeRange;
    }

    public static Object createSongScoreNoteItem(int i, int i2, int i3, int i4) {
        TXCopyrightedMedia.TXSongScoreNoteItem tXSongScoreNoteItem = new TXCopyrightedMedia.TXSongScoreNoteItem();
        tXSongScoreNoteItem.startTime = i;
        tXSongScoreNoteItem.duration = i2;
        tXSongScoreNoteItem.noteHeight = i3;
        tXSongScoreNoteItem.endTime = i4;
        return tXSongScoreNoteItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeCalculateTotalScore(long j);

    private static native void nativeCancelPreloadMusic(long j, String str, String str2);

    private static native void nativeClearMusicCache(long j);

    private static native void nativeClearMusicCacheByMusicId(long j, String str, String str2);

    private static native long nativeCreateCopyRightedMedia(TXCopyrightedMediaImpl tXCopyrightedMediaImpl);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeCreateSongScore(long j, TXSongScoreImpl tXSongScoreImpl, String str, int i, int i2, String str2, String str3, String str4);

    private static native void nativeDestroyCopyRightedMedia(TXCopyrightedMediaImpl tXCopyrightedMediaImpl, long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeDestroySongScore(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeFinish(long j);

    private static native String nativeGenMusicURI(long j, String str, int i, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native TXCopyrightedMedia.TXSongScoreNoteItem[] nativeGetAllGrove(long j);

    private static native TXCopyrightedMedia.TXClimaxTimeRange nativeGetClimaxSegmentTimeRange(long j, String str, int i, String str2);

    private static native boolean nativeIsMusicPreloaded(long j, String str, String str2);

    private static native void nativePreloadClimaxSegment(long j, String str, String str2, String str3);

    private static native void nativePreloadMusic(long j, String str, String str2, String str3);

    private static native void nativePreloadPitchAndLyricFile(long j, String str, String str2, String str3);

    private static native void nativePreloadYSDMusic(long j, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativePrepare(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProcess(long j, byte[] bArr, int i, float f);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetKeyShift(long j, int i);

    private static native void nativeSetLicense(long j, Context context, String str, String str2);

    private static native void nativeSetMusicCacheMaxCount(long j, int i);

    private static native void nativeSetMusicPreloadCallback(long j, Object obj);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetSongScoreCallback(long j, Object obj);

    private static native void nativeSetYSDAuthParams(long j, String str, String str2, String str3, String str4, String str5, boolean z);

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public void cancelPreloadMusic(String str, String str2) {
        nativeCancelPreloadMusic(this.mNativeTXCopyrightedMediaImpl, str, str2);
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public void clearMusicCache() {
        nativeClearMusicCache(this.mNativeTXCopyrightedMediaImpl);
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public TXCopyrightedMedia.ITXSongScore createSongScore(String str, int i, int i2, String str2, String str3, String str4) {
        return new TXSongScoreImpl(str, i, i2, str2, str3, str4);
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public void destroy() {
        long j = this.mNativeTXCopyrightedMediaImpl;
        if (j != 0) {
            nativeDestroyCopyRightedMedia(this, j);
            this.mNativeTXCopyrightedMediaImpl = 0L;
        }
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public String genMusicURI(String str, int i, String str2) {
        return nativeGenMusicURI(this.mNativeTXCopyrightedMediaImpl, str, i, str2);
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public TXCopyrightedMedia.TXClimaxTimeRange getClimaxSegmentTimeRange(String str, int i, String str2) {
        return nativeGetClimaxSegmentTimeRange(this.mNativeTXCopyrightedMediaImpl, str, i, str2);
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public void init() {
        if (this.mNativeTXCopyrightedMediaImpl == 0) {
            this.mNativeTXCopyrightedMediaImpl = nativeCreateCopyRightedMedia(this);
        }
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public boolean isMusicPreloaded(String str, String str2) {
        return nativeIsMusicPreloaded(this.mNativeTXCopyrightedMediaImpl, str, str2);
    }

    public void onPreloadComplete(String str, String str2, int i, String str3, Object obj) {
        ((TXCopyrightedMedia.ITXMusicPreloadCallback) obj).onPreloadComplete(str, str2, i, str3);
    }

    public void onPreloadProgress(String str, String str2, float f, Object obj) {
        ((TXCopyrightedMedia.ITXMusicPreloadCallback) obj).onPreloadProgress(str, str2, f);
    }

    public void onPreloadStart(String str, String str2, Object obj) {
        ((TXCopyrightedMedia.ITXMusicPreloadCallback) obj).onPreloadStart(str, str2);
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public void preloadClimaxSegment(String str, String str2, String str3) {
        nativePreloadClimaxSegment(this.mNativeTXCopyrightedMediaImpl, str, str2, str3);
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public void preloadMusic(String str, String str2) {
        nativePreloadYSDMusic(this.mNativeTXCopyrightedMediaImpl, str, str2);
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public void preloadPitchAndLyricFile(String str, String str2, String str3) {
        nativePreloadPitchAndLyricFile(this.mNativeTXCopyrightedMediaImpl, str, str2, str3);
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public void setLicense(Context context, String str, String str2) {
        nativeSetLicense(this.mNativeTXCopyrightedMediaImpl, context, str, str2);
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public void setMusicCacheMaxCount(int i) {
        nativeSetMusicCacheMaxCount(this.mNativeTXCopyrightedMediaImpl, i);
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public void setMusicPreloadCallback(TXCopyrightedMedia.ITXMusicPreloadCallback iTXMusicPreloadCallback) {
        nativeSetMusicPreloadCallback(this.mNativeTXCopyrightedMediaImpl, iTXMusicPreloadCallback);
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public void setYSDAuthParams(TXCopyrightedMedia.TXCopyrightedMediaYSDAuthParams tXCopyrightedMediaYSDAuthParams) {
        nativeSetYSDAuthParams(this.mNativeTXCopyrightedMediaImpl, tXCopyrightedMediaYSDAuthParams.appId, tXCopyrightedMediaYSDAuthParams.appKey, tXCopyrightedMediaYSDAuthParams.deviceId, tXCopyrightedMediaYSDAuthParams.userId, tXCopyrightedMediaYSDAuthParams.userToken, tXCopyrightedMediaYSDAuthParams.isChargedOnce);
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public void clearMusicCache(String str, String str2) {
        nativeClearMusicCacheByMusicId(this.mNativeTXCopyrightedMediaImpl, str, str2);
    }

    @Override // com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia
    public void preloadMusic(String str, String str2, String str3) {
        nativePreloadMusic(this.mNativeTXCopyrightedMediaImpl, str, str2, str3);
    }
}
