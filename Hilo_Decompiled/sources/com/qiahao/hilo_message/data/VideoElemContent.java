package com.qiahao.hilo_message.data;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u00100\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\bHÆ\u0003Jz\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001c\u0010\f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001d\"\u0004\b)\u0010\u001f¨\u0006:"}, d2 = {"Lcom/qiahao/hilo_message/data/VideoElemContent;", "", "thumbWidth", "", "thumbHeight", "thumbSize", "", "thumbUrl", "", "videoSecond", "videoSize", "videoUrl", "localPath", "localThumbPath", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getThumbWidth", "()Ljava/lang/Integer;", "setThumbWidth", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getThumbHeight", "setThumbHeight", "getThumbSize", "()Ljava/lang/Long;", "setThumbSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getThumbUrl", "()Ljava/lang/String;", "setThumbUrl", "(Ljava/lang/String;)V", "getVideoSecond", "setVideoSecond", "getVideoSize", "setVideoSize", "getVideoUrl", "setVideoUrl", "getLocalPath", "setLocalPath", "getLocalThumbPath", "setLocalThumbPath", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/qiahao/hilo_message/data/VideoElemContent;", "equals", "", "other", "hashCode", "toString", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class VideoElemContent {

    @Nullable
    private String localPath;

    @Nullable
    private String localThumbPath;

    @Nullable
    private Integer thumbHeight;

    @Nullable
    private Long thumbSize;

    @Nullable
    private String thumbUrl;

    @Nullable
    private Integer thumbWidth;

    @Nullable
    private Integer videoSecond;

    @Nullable
    private Long videoSize;

    @Nullable
    private String videoUrl;

    public VideoElemContent() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getThumbWidth() {
        return this.thumbWidth;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getThumbHeight() {
        return this.thumbHeight;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getThumbSize() {
        return this.thumbSize;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getThumbUrl() {
        return this.thumbUrl;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getVideoSecond() {
        return this.videoSecond;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Long getVideoSize() {
        return this.videoSize;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getLocalPath() {
        return this.localPath;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getLocalThumbPath() {
        return this.localThumbPath;
    }

    @NotNull
    public final VideoElemContent copy(@Nullable Integer thumbWidth, @Nullable Integer thumbHeight, @Nullable Long thumbSize, @Nullable String thumbUrl, @Nullable Integer videoSecond, @Nullable Long videoSize, @Nullable String videoUrl, @Nullable String localPath, @Nullable String localThumbPath) {
        return new VideoElemContent(thumbWidth, thumbHeight, thumbSize, thumbUrl, videoSecond, videoSize, videoUrl, localPath, localThumbPath);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoElemContent)) {
            return false;
        }
        VideoElemContent videoElemContent = (VideoElemContent) other;
        return Intrinsics.areEqual(this.thumbWidth, videoElemContent.thumbWidth) && Intrinsics.areEqual(this.thumbHeight, videoElemContent.thumbHeight) && Intrinsics.areEqual(this.thumbSize, videoElemContent.thumbSize) && Intrinsics.areEqual(this.thumbUrl, videoElemContent.thumbUrl) && Intrinsics.areEqual(this.videoSecond, videoElemContent.videoSecond) && Intrinsics.areEqual(this.videoSize, videoElemContent.videoSize) && Intrinsics.areEqual(this.videoUrl, videoElemContent.videoUrl) && Intrinsics.areEqual(this.localPath, videoElemContent.localPath) && Intrinsics.areEqual(this.localThumbPath, videoElemContent.localThumbPath);
    }

    @Nullable
    public final String getLocalPath() {
        return this.localPath;
    }

    @Nullable
    public final String getLocalThumbPath() {
        return this.localThumbPath;
    }

    @Nullable
    public final Integer getThumbHeight() {
        return this.thumbHeight;
    }

    @Nullable
    public final Long getThumbSize() {
        return this.thumbSize;
    }

    @Nullable
    public final String getThumbUrl() {
        return this.thumbUrl;
    }

    @Nullable
    public final Integer getThumbWidth() {
        return this.thumbWidth;
    }

    @Nullable
    public final Integer getVideoSecond() {
        return this.videoSecond;
    }

    @Nullable
    public final Long getVideoSize() {
        return this.videoSize;
    }

    @Nullable
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public int hashCode() {
        Integer num = this.thumbWidth;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.thumbHeight;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l10 = this.thumbSize;
        int hashCode3 = (hashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str = this.thumbUrl;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num3 = this.videoSecond;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Long l11 = this.videoSize;
        int hashCode6 = (hashCode5 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str2 = this.videoUrl;
        int hashCode7 = (hashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.localPath;
        int hashCode8 = (hashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.localThumbPath;
        return hashCode8 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setLocalPath(@Nullable String str) {
        this.localPath = str;
    }

    public final void setLocalThumbPath(@Nullable String str) {
        this.localThumbPath = str;
    }

    public final void setThumbHeight(@Nullable Integer num) {
        this.thumbHeight = num;
    }

    public final void setThumbSize(@Nullable Long l10) {
        this.thumbSize = l10;
    }

    public final void setThumbUrl(@Nullable String str) {
        this.thumbUrl = str;
    }

    public final void setThumbWidth(@Nullable Integer num) {
        this.thumbWidth = num;
    }

    public final void setVideoSecond(@Nullable Integer num) {
        this.videoSecond = num;
    }

    public final void setVideoSize(@Nullable Long l10) {
        this.videoSize = l10;
    }

    public final void setVideoUrl(@Nullable String str) {
        this.videoUrl = str;
    }

    @NotNull
    public String toString() {
        return "VideoElemContent(thumbWidth=" + this.thumbWidth + ", thumbHeight=" + this.thumbHeight + ", thumbSize=" + this.thumbSize + ", thumbUrl=" + this.thumbUrl + ", videoSecond=" + this.videoSecond + ", videoSize=" + this.videoSize + ", videoUrl=" + this.videoUrl + ", localPath=" + this.localPath + ", localThumbPath=" + this.localThumbPath + ")";
    }

    public VideoElemContent(@Nullable Integer num, @Nullable Integer num2, @Nullable Long l10, @Nullable String str, @Nullable Integer num3, @Nullable Long l11, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.thumbWidth = num;
        this.thumbHeight = num2;
        this.thumbSize = l10;
        this.thumbUrl = str;
        this.videoSecond = num3;
        this.videoSize = l11;
        this.videoUrl = str2;
        this.localPath = str3;
        this.localThumbPath = str4;
    }

    public /* synthetic */ VideoElemContent(Integer num, Integer num2, Long l10, String str, Integer num3, Long l11, String str2, String str3, String str4, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : num2, (i10 & 4) != 0 ? null : l10, (i10 & 8) != 0 ? null : str, (i10 & 16) != 0 ? null : num3, (i10 & 32) != 0 ? null : l11, (i10 & 64) != 0 ? null : str2, (i10 & 128) != 0 ? null : str3, (i10 & 256) == 0 ? str4 : null);
    }
}
