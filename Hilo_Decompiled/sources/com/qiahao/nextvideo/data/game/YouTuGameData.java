package com.qiahao.nextvideo.data.game;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.apache.commons.sudcompress.archivers.zip.UnixStat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b.\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 B2\u00020\u0001:\u0001BBq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010+\u001a\u00020\u000bJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\u000bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010'Jx\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u00106J\u0006\u00107\u001a\u00020\u0005J\u0013\u00108\u001a\u00020\u000b2\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0005HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001J\u0016\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0005R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010!\"\u0004\b\"\u0010#R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006C"}, d2 = {"Lcom/qiahao/nextvideo/data/game/YouTuGameData;", "Landroid/os/Parcelable;", "videoId", "", "currentTime", "", "videoDuration", "type", "videoUrl", "groupId", "isOwner", "", SupportGiftRankActivity.EXTERNAL_ID, "live", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Boolean;)V", "getVideoId", "()Ljava/lang/String;", "setVideoId", "(Ljava/lang/String;)V", "getCurrentTime", "()Ljava/lang/Integer;", "setCurrentTime", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getVideoDuration", "setVideoDuration", "getType", "setType", "getVideoUrl", "setVideoUrl", "getGroupId", "setGroupId", "()Z", "setOwner", "(Z)V", "getExternalId", "setExternalId", "getLive", "()Ljava/lang/Boolean;", "setLive", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "checkMe", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Boolean;)Lcom/qiahao/nextvideo/data/game/YouTuGameData;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class YouTuGameData implements Parcelable {
    public static final int TYPE_END = 3;
    public static final int TYPE_EXIT = 4;
    public static final int TYPE_INIT = 0;
    public static final int TYPE_PAUSE = 2;
    public static final int TYPE_PLAY = 1;

    @Nullable
    private Integer currentTime;

    @Nullable
    private String externalId;

    @Nullable
    private String groupId;
    private boolean isOwner;

    @Nullable
    private Boolean live;

    @Nullable
    private Integer type;

    @Nullable
    private Integer videoDuration;

    @Nullable
    private String videoId;

    @Nullable
    private String videoUrl;

    @NotNull
    public static final Parcelable.Creator<YouTuGameData> CREATOR = new Creator();

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<YouTuGameData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final YouTuGameData createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf4 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            String readString4 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new YouTuGameData(readString, valueOf2, valueOf3, valueOf4, readString2, readString3, z, readString4, valueOf);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final YouTuGameData[] newArray(int i) {
            return new YouTuGameData[i];
        }
    }

    public YouTuGameData() {
        this(null, null, null, null, null, null, false, null, null, UnixStat.DEFAULT_LINK_PERM, null);
    }

    public final boolean checkMe() {
        String str;
        String str2 = this.externalId;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str2, str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getVideoId() {
        return this.videoId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getCurrentTime() {
        return this.currentTime;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getVideoDuration() {
        return this.videoDuration;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsOwner() {
        return this.isOwner;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Boolean getLive() {
        return this.live;
    }

    @NotNull
    public final YouTuGameData copy(@Nullable String videoId, @Nullable Integer currentTime, @Nullable Integer videoDuration, @Nullable Integer type, @Nullable String videoUrl, @Nullable String groupId, boolean isOwner, @Nullable String externalId, @Nullable Boolean live) {
        return new YouTuGameData(videoId, currentTime, videoDuration, type, videoUrl, groupId, isOwner, externalId, live);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof YouTuGameData)) {
            return false;
        }
        YouTuGameData youTuGameData = (YouTuGameData) other;
        return Intrinsics.areEqual(this.videoId, youTuGameData.videoId) && Intrinsics.areEqual(this.currentTime, youTuGameData.currentTime) && Intrinsics.areEqual(this.videoDuration, youTuGameData.videoDuration) && Intrinsics.areEqual(this.type, youTuGameData.type) && Intrinsics.areEqual(this.videoUrl, youTuGameData.videoUrl) && Intrinsics.areEqual(this.groupId, youTuGameData.groupId) && this.isOwner == youTuGameData.isOwner && Intrinsics.areEqual(this.externalId, youTuGameData.externalId) && Intrinsics.areEqual(this.live, youTuGameData.live);
    }

    @Nullable
    public final Integer getCurrentTime() {
        return this.currentTime;
    }

    @Nullable
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final Boolean getLive() {
        return this.live;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    @Nullable
    public final Integer getVideoDuration() {
        return this.videoDuration;
    }

    @Nullable
    public final String getVideoId() {
        return this.videoId;
    }

    @Nullable
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public int hashCode() {
        String str = this.videoId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.currentTime;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.videoDuration;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.type;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str2 = this.videoUrl;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.groupId;
        int hashCode6 = (((hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31) + a.a(this.isOwner)) * 31;
        String str4 = this.externalId;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.live;
        return hashCode7 + (bool != null ? bool.hashCode() : 0);
    }

    public final boolean isOwner() {
        return this.isOwner;
    }

    public final void setCurrentTime(@Nullable Integer num) {
        this.currentTime = num;
    }

    public final void setExternalId(@Nullable String str) {
        this.externalId = str;
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    public final void setLive(@Nullable Boolean bool) {
        this.live = bool;
    }

    public final void setOwner(boolean z) {
        this.isOwner = z;
    }

    public final void setType(@Nullable Integer num) {
        this.type = num;
    }

    public final void setVideoDuration(@Nullable Integer num) {
        this.videoDuration = num;
    }

    public final void setVideoId(@Nullable String str) {
        this.videoId = str;
    }

    public final void setVideoUrl(@Nullable String str) {
        this.videoUrl = str;
    }

    @NotNull
    public String toString() {
        return "YouTuGameData(videoId=" + this.videoId + ", currentTime=" + this.currentTime + ", videoDuration=" + this.videoDuration + ", type=" + this.type + ", videoUrl=" + this.videoUrl + ", groupId=" + this.groupId + ", isOwner=" + this.isOwner + ", externalId=" + this.externalId + ", live=" + this.live + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.videoId);
        Integer num = this.currentTime;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Integer num2 = this.videoDuration;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        Integer num3 = this.type;
        if (num3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num3.intValue());
        }
        dest.writeString(this.videoUrl);
        dest.writeString(this.groupId);
        dest.writeInt(this.isOwner ? 1 : 0);
        dest.writeString(this.externalId);
        Boolean bool = this.live;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
    }

    public YouTuGameData(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str2, @Nullable String str3, boolean z, @Nullable String str4, @Nullable Boolean bool) {
        this.videoId = str;
        this.currentTime = num;
        this.videoDuration = num2;
        this.type = num3;
        this.videoUrl = str2;
        this.groupId = str3;
        this.isOwner = z;
        this.externalId = str4;
        this.live = bool;
    }

    public /* synthetic */ YouTuGameData(String str, Integer num, Integer num2, Integer num3, String str2, String str3, boolean z, String str4, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? false : z, (i & 128) == 0 ? str4 : null, (i & 256) != 0 ? Boolean.FALSE : bool);
    }
}
