package com.qiahao.nextvideo.data.room;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/data/room/YouTuGoRoomData;", "", "groupId", "", "videoUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "getVideoUrl", "setVideoUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class YouTuGoRoomData {

    @Nullable
    private String groupId;

    @Nullable
    private String videoUrl;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public YouTuGoRoomData() {
        this(r0, r0, 3, r0);
        String str = null;
    }

    public static /* synthetic */ YouTuGoRoomData copy$default(YouTuGoRoomData youTuGoRoomData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = youTuGoRoomData.groupId;
        }
        if ((i & 2) != 0) {
            str2 = youTuGoRoomData.videoUrl;
        }
        return youTuGoRoomData.copy(str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    @NotNull
    public final YouTuGoRoomData copy(@Nullable String groupId, @Nullable String videoUrl) {
        return new YouTuGoRoomData(groupId, videoUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof YouTuGoRoomData)) {
            return false;
        }
        YouTuGoRoomData youTuGoRoomData = (YouTuGoRoomData) other;
        return Intrinsics.areEqual(this.groupId, youTuGoRoomData.groupId) && Intrinsics.areEqual(this.videoUrl, youTuGoRoomData.videoUrl);
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public int hashCode() {
        String str = this.groupId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.videoUrl;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    public final void setVideoUrl(@Nullable String str) {
        this.videoUrl = str;
    }

    @NotNull
    public String toString() {
        return "YouTuGoRoomData(groupId=" + this.groupId + ", videoUrl=" + this.videoUrl + ")";
    }

    public YouTuGoRoomData(@Nullable String str, @Nullable String str2) {
        this.groupId = str;
        this.videoUrl = str2;
    }

    public /* synthetic */ YouTuGoRoomData(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }
}
