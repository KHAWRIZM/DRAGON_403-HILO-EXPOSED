package com.qiahao.nextvideo.data.model;

import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/data/model/VideoMinuteConfirm;", "Ljava/io/Serializable;", "videoUid", "", SupportGiftRankActivity.EXTERNAL_ID, "uuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getVideoUid", "()Ljava/lang/String;", "setVideoUid", "(Ljava/lang/String;)V", "getExternalId", "setExternalId", "getUuid", "setUuid", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class VideoMinuteConfirm implements Serializable {

    @NotNull
    private String externalId;

    @NotNull
    private String uuid;

    @NotNull
    private String videoUid;

    public VideoMinuteConfirm(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "videoUid");
        Intrinsics.checkNotNullParameter(str2, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(str3, "uuid");
        this.videoUid = str;
        this.externalId = str2;
        this.uuid = str3;
    }

    public static /* synthetic */ VideoMinuteConfirm copy$default(VideoMinuteConfirm videoMinuteConfirm, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = videoMinuteConfirm.videoUid;
        }
        if ((i & 2) != 0) {
            str2 = videoMinuteConfirm.externalId;
        }
        if ((i & 4) != 0) {
            str3 = videoMinuteConfirm.uuid;
        }
        return videoMinuteConfirm.copy(str, str2, str3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getVideoUid() {
        return this.videoUid;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    @NotNull
    public final VideoMinuteConfirm copy(@NotNull String videoUid, @NotNull String externalId, @NotNull String uuid) {
        Intrinsics.checkNotNullParameter(videoUid, "videoUid");
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return new VideoMinuteConfirm(videoUid, externalId, uuid);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoMinuteConfirm)) {
            return false;
        }
        VideoMinuteConfirm videoMinuteConfirm = (VideoMinuteConfirm) other;
        return Intrinsics.areEqual(this.videoUid, videoMinuteConfirm.videoUid) && Intrinsics.areEqual(this.externalId, videoMinuteConfirm.externalId) && Intrinsics.areEqual(this.uuid, videoMinuteConfirm.uuid);
    }

    @NotNull
    public final String getExternalId() {
        return this.externalId;
    }

    @NotNull
    public final String getUuid() {
        return this.uuid;
    }

    @NotNull
    public final String getVideoUid() {
        return this.videoUid;
    }

    public int hashCode() {
        return (((this.videoUid.hashCode() * 31) + this.externalId.hashCode()) * 31) + this.uuid.hashCode();
    }

    public final void setExternalId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.externalId = str;
    }

    public final void setUuid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uuid = str;
    }

    public final void setVideoUid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoUid = str;
    }

    @NotNull
    public String toString() {
        return "VideoMinuteConfirm(videoUid=" + this.videoUid + ", externalId=" + this.externalId + ", uuid=" + this.uuid + ")";
    }
}
