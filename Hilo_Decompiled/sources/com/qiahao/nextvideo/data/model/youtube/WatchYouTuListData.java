package com.qiahao.nextvideo.data.model.youtube;

import com.qiahao.base_common.model.common.User;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jh\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\nHÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012¨\u0006/"}, d2 = {"Lcom/qiahao/nextvideo/data/model/youtube/WatchYouTuListData;", "", "groupId", "", "micUsers", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/common/User;", "Lkotlin/collections/ArrayList;", "picUrl", "roomUserCount", "", "title", "videoId", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "getMicUsers", "()Ljava/util/ArrayList;", "setMicUsers", "(Ljava/util/ArrayList;)V", "getPicUrl", "setPicUrl", "getRoomUserCount", "()Ljava/lang/Integer;", "setRoomUserCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTitle", "setTitle", "getVideoId", "setVideoId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/model/youtube/WatchYouTuListData;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class WatchYouTuListData {

    @Nullable
    private String groupId;

    @Nullable
    private ArrayList<User> micUsers;

    @Nullable
    private String picUrl;

    @Nullable
    private Integer roomUserCount;

    @Nullable
    private String title;

    @Nullable
    private String videoId;

    public WatchYouTuListData() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ WatchYouTuListData copy$default(WatchYouTuListData watchYouTuListData, String str, ArrayList arrayList, String str2, Integer num, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = watchYouTuListData.groupId;
        }
        if ((i & 2) != 0) {
            arrayList = watchYouTuListData.micUsers;
        }
        ArrayList arrayList2 = arrayList;
        if ((i & 4) != 0) {
            str2 = watchYouTuListData.picUrl;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            num = watchYouTuListData.roomUserCount;
        }
        Integer num2 = num;
        if ((i & 16) != 0) {
            str3 = watchYouTuListData.title;
        }
        String str6 = str3;
        if ((i & 32) != 0) {
            str4 = watchYouTuListData.videoId;
        }
        return watchYouTuListData.copy(str, arrayList2, str5, num2, str6, str4);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final ArrayList<User> component2() {
        return this.micUsers;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getRoomUserCount() {
        return this.roomUserCount;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getVideoId() {
        return this.videoId;
    }

    @NotNull
    public final WatchYouTuListData copy(@Nullable String groupId, @Nullable ArrayList<User> micUsers, @Nullable String picUrl, @Nullable Integer roomUserCount, @Nullable String title, @Nullable String videoId) {
        return new WatchYouTuListData(groupId, micUsers, picUrl, roomUserCount, title, videoId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WatchYouTuListData)) {
            return false;
        }
        WatchYouTuListData watchYouTuListData = (WatchYouTuListData) other;
        return Intrinsics.areEqual(this.groupId, watchYouTuListData.groupId) && Intrinsics.areEqual(this.micUsers, watchYouTuListData.micUsers) && Intrinsics.areEqual(this.picUrl, watchYouTuListData.picUrl) && Intrinsics.areEqual(this.roomUserCount, watchYouTuListData.roomUserCount) && Intrinsics.areEqual(this.title, watchYouTuListData.title) && Intrinsics.areEqual(this.videoId, watchYouTuListData.videoId);
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final ArrayList<User> getMicUsers() {
        return this.micUsers;
    }

    @Nullable
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    public final Integer getRoomUserCount() {
        return this.roomUserCount;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getVideoId() {
        return this.videoId;
    }

    public int hashCode() {
        String str = this.groupId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ArrayList<User> arrayList = this.micUsers;
        int hashCode2 = (hashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        String str2 = this.picUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.roomUserCount;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.title;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.videoId;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    public final void setMicUsers(@Nullable ArrayList<User> arrayList) {
        this.micUsers = arrayList;
    }

    public final void setPicUrl(@Nullable String str) {
        this.picUrl = str;
    }

    public final void setRoomUserCount(@Nullable Integer num) {
        this.roomUserCount = num;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setVideoId(@Nullable String str) {
        this.videoId = str;
    }

    @NotNull
    public String toString() {
        return "WatchYouTuListData(groupId=" + this.groupId + ", micUsers=" + this.micUsers + ", picUrl=" + this.picUrl + ", roomUserCount=" + this.roomUserCount + ", title=" + this.title + ", videoId=" + this.videoId + ")";
    }

    public WatchYouTuListData(@Nullable String str, @Nullable ArrayList<User> arrayList, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable String str4) {
        this.groupId = str;
        this.micUsers = arrayList;
        this.picUrl = str2;
        this.roomUserCount = num;
        this.title = str3;
        this.videoId = str4;
    }

    public /* synthetic */ WatchYouTuListData(String str, ArrayList arrayList, String str2, Integer num, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : arrayList, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
    }
}
