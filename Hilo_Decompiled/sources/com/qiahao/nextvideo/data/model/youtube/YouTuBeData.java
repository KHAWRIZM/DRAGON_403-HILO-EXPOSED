package com.qiahao.nextvideo.data.model.youtube;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018Jb\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0007\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001a¨\u00061"}, d2 = {"Lcom/qiahao/nextvideo/data/model/youtube/YouTuBeData;", "", "videoPic", "", "videoId", "videoTitle", "videoUrl", "isPlay", "", "playTimes", "", "live", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;)V", "getVideoPic", "()Ljava/lang/String;", "setVideoPic", "(Ljava/lang/String;)V", "getVideoId", "setVideoId", "getVideoTitle", "setVideoTitle", "getVideoUrl", "setVideoUrl", "()Ljava/lang/Boolean;", "setPlay", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getPlayTimes", "()Ljava/lang/Long;", "setPlayTimes", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLive", "setLive", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/qiahao/nextvideo/data/model/youtube/YouTuBeData;", "equals", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class YouTuBeData {

    @Nullable
    private Boolean isPlay;

    @Nullable
    private Boolean live;

    @Nullable
    private Long playTimes;

    @Nullable
    private String videoId;

    @Nullable
    private String videoPic;

    @Nullable
    private String videoTitle;

    @Nullable
    private String videoUrl;

    public YouTuBeData() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ YouTuBeData copy$default(YouTuBeData youTuBeData, String str, String str2, String str3, String str4, Boolean bool, Long l, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = youTuBeData.videoPic;
        }
        if ((i & 2) != 0) {
            str2 = youTuBeData.videoId;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = youTuBeData.videoTitle;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = youTuBeData.videoUrl;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            bool = youTuBeData.isPlay;
        }
        Boolean bool3 = bool;
        if ((i & 32) != 0) {
            l = youTuBeData.playTimes;
        }
        Long l2 = l;
        if ((i & 64) != 0) {
            bool2 = youTuBeData.live;
        }
        return youTuBeData.copy(str, str5, str6, str7, bool3, l2, bool2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getVideoPic() {
        return this.videoPic;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getVideoId() {
        return this.videoId;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getVideoTitle() {
        return this.videoTitle;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Boolean getIsPlay() {
        return this.isPlay;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Long getPlayTimes() {
        return this.playTimes;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Boolean getLive() {
        return this.live;
    }

    @NotNull
    public final YouTuBeData copy(@Nullable String videoPic, @Nullable String videoId, @Nullable String videoTitle, @Nullable String videoUrl, @Nullable Boolean isPlay, @Nullable Long playTimes, @Nullable Boolean live) {
        return new YouTuBeData(videoPic, videoId, videoTitle, videoUrl, isPlay, playTimes, live);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof YouTuBeData)) {
            return false;
        }
        YouTuBeData youTuBeData = (YouTuBeData) other;
        return Intrinsics.areEqual(this.videoPic, youTuBeData.videoPic) && Intrinsics.areEqual(this.videoId, youTuBeData.videoId) && Intrinsics.areEqual(this.videoTitle, youTuBeData.videoTitle) && Intrinsics.areEqual(this.videoUrl, youTuBeData.videoUrl) && Intrinsics.areEqual(this.isPlay, youTuBeData.isPlay) && Intrinsics.areEqual(this.playTimes, youTuBeData.playTimes) && Intrinsics.areEqual(this.live, youTuBeData.live);
    }

    @Nullable
    public final Boolean getLive() {
        return this.live;
    }

    @Nullable
    public final Long getPlayTimes() {
        return this.playTimes;
    }

    @Nullable
    public final String getVideoId() {
        return this.videoId;
    }

    @Nullable
    public final String getVideoPic() {
        return this.videoPic;
    }

    @Nullable
    public final String getVideoTitle() {
        return this.videoTitle;
    }

    @Nullable
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public int hashCode() {
        String str = this.videoPic;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.videoId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.videoTitle;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.videoUrl;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.isPlay;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Long l = this.playTimes;
        int hashCode6 = (hashCode5 + (l == null ? 0 : l.hashCode())) * 31;
        Boolean bool2 = this.live;
        return hashCode6 + (bool2 != null ? bool2.hashCode() : 0);
    }

    @Nullable
    public final Boolean isPlay() {
        return this.isPlay;
    }

    public final void setLive(@Nullable Boolean bool) {
        this.live = bool;
    }

    public final void setPlay(@Nullable Boolean bool) {
        this.isPlay = bool;
    }

    public final void setPlayTimes(@Nullable Long l) {
        this.playTimes = l;
    }

    public final void setVideoId(@Nullable String str) {
        this.videoId = str;
    }

    public final void setVideoPic(@Nullable String str) {
        this.videoPic = str;
    }

    public final void setVideoTitle(@Nullable String str) {
        this.videoTitle = str;
    }

    public final void setVideoUrl(@Nullable String str) {
        this.videoUrl = str;
    }

    @NotNull
    public String toString() {
        return "YouTuBeData(videoPic=" + this.videoPic + ", videoId=" + this.videoId + ", videoTitle=" + this.videoTitle + ", videoUrl=" + this.videoUrl + ", isPlay=" + this.isPlay + ", playTimes=" + this.playTimes + ", live=" + this.live + ")";
    }

    public YouTuBeData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool, @Nullable Long l, @Nullable Boolean bool2) {
        this.videoPic = str;
        this.videoId = str2;
        this.videoTitle = str3;
        this.videoUrl = str4;
        this.isPlay = bool;
        this.playTimes = l;
        this.live = bool2;
    }

    public /* synthetic */ YouTuBeData(String str, String str2, String str3, String str4, Boolean bool, Long l, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) == 0 ? str4 : null, (i & 16) != 0 ? Boolean.FALSE : bool, (i & 32) != 0 ? 0L : l, (i & 64) != 0 ? Boolean.FALSE : bool2);
    }
}
