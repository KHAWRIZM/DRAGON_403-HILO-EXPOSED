package com.qiahao.hilo_message.data;

import androidx.annotation.Keep;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003JJ\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001b¨\u0006*"}, d2 = {"Lcom/qiahao/hilo_message/data/ImageInfo;", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "size", "", "url", "", "localPath", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getWidth", "()Ljava/lang/Integer;", "setWidth", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHeight", "setHeight", "getSize", "()Ljava/lang/Long;", "setSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getLocalPath", "setLocalPath", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/qiahao/hilo_message/data/ImageInfo;", "equals", "", "other", "hashCode", "toString", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class ImageInfo {

    @Nullable
    private Integer height;

    @Nullable
    private String localPath;

    @Nullable
    private Long size;

    @Nullable
    private String url;

    @Nullable
    private Integer width;

    public ImageInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ImageInfo copy$default(ImageInfo imageInfo, Integer num, Integer num2, Long l10, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = imageInfo.width;
        }
        if ((i10 & 2) != 0) {
            num2 = imageInfo.height;
        }
        Integer num3 = num2;
        if ((i10 & 4) != 0) {
            l10 = imageInfo.size;
        }
        Long l11 = l10;
        if ((i10 & 8) != 0) {
            str = imageInfo.url;
        }
        String str3 = str;
        if ((i10 & 16) != 0) {
            str2 = imageInfo.localPath;
        }
        return imageInfo.copy(num, num3, l11, str3, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getWidth() {
        return this.width;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getSize() {
        return this.size;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getLocalPath() {
        return this.localPath;
    }

    @NotNull
    public final ImageInfo copy(@Nullable Integer width, @Nullable Integer height, @Nullable Long size, @Nullable String url, @Nullable String localPath) {
        return new ImageInfo(width, height, size, url, localPath);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageInfo)) {
            return false;
        }
        ImageInfo imageInfo = (ImageInfo) other;
        return Intrinsics.areEqual(this.width, imageInfo.width) && Intrinsics.areEqual(this.height, imageInfo.height) && Intrinsics.areEqual(this.size, imageInfo.size) && Intrinsics.areEqual(this.url, imageInfo.url) && Intrinsics.areEqual(this.localPath, imageInfo.localPath);
    }

    @Nullable
    public final Integer getHeight() {
        return this.height;
    }

    @Nullable
    public final String getLocalPath() {
        return this.localPath;
    }

    @Nullable
    public final Long getSize() {
        return this.size;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final Integer getWidth() {
        return this.width;
    }

    public int hashCode() {
        Integer num = this.width;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.height;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l10 = this.size;
        int hashCode3 = (hashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str = this.url;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.localPath;
        return hashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setHeight(@Nullable Integer num) {
        this.height = num;
    }

    public final void setLocalPath(@Nullable String str) {
        this.localPath = str;
    }

    public final void setSize(@Nullable Long l10) {
        this.size = l10;
    }

    public final void setUrl(@Nullable String str) {
        this.url = str;
    }

    public final void setWidth(@Nullable Integer num) {
        this.width = num;
    }

    @NotNull
    public String toString() {
        return "ImageInfo(width=" + this.width + ", height=" + this.height + ", size=" + this.size + ", url=" + this.url + ", localPath=" + this.localPath + ")";
    }

    public ImageInfo(@Nullable Integer num, @Nullable Integer num2, @Nullable Long l10, @Nullable String str, @Nullable String str2) {
        this.width = num;
        this.height = num2;
        this.size = l10;
        this.url = str;
        this.localPath = str2;
    }

    public /* synthetic */ ImageInfo(Integer num, Integer num2, Long l10, String str, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : num2, (i10 & 4) != 0 ? null : l10, (i10 & 8) != 0 ? null : str, (i10 & 16) != 0 ? null : str2);
    }
}
