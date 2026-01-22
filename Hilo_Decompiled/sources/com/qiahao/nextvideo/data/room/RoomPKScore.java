package com.qiahao.nextvideo.data.room;

import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b\u0012(\b\u0002\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010&\u001a\u00020\u0007J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u001d\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bHÆ\u0003J)\u0010+\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u000eHÆ\u0003Jz\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2(\b\u0002\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u000eHÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0006\u0010\u001a\"\u0004\b\u001b\u0010\u001cR.\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R:\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00063"}, d2 = {"Lcom/qiahao/nextvideo/data/room/RoomPKScore;", "", "groupId", "", "score", "", "isMute", "", "topSupport", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/room/RoomPKUser;", "Lkotlin/collections/ArrayList;", "scoreReceive", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/ArrayList;Ljava/util/HashMap;)V", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "getScore", "()Ljava/lang/Long;", "setScore", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "()Ljava/lang/Boolean;", "setMute", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTopSupport", "()Ljava/util/ArrayList;", "setTopSupport", "(Ljava/util/ArrayList;)V", "getScoreReceive", "()Ljava/util/HashMap;", "setScoreReceive", "(Ljava/util/HashMap;)V", "checkIsInvite", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/ArrayList;Ljava/util/HashMap;)Lcom/qiahao/nextvideo/data/room/RoomPKScore;", "equals", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class RoomPKScore {

    @Nullable
    private String groupId;

    @Nullable
    private Boolean isMute;

    @Nullable
    private Long score;

    @Nullable
    private HashMap<String, Long> scoreReceive;

    @Nullable
    private ArrayList<RoomPKUser> topSupport;

    public RoomPKScore() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ RoomPKScore copy$default(RoomPKScore roomPKScore, String str, Long l, Boolean bool, ArrayList arrayList, HashMap hashMap, int i, Object obj) {
        if ((i & 1) != 0) {
            str = roomPKScore.groupId;
        }
        if ((i & 2) != 0) {
            l = roomPKScore.score;
        }
        Long l2 = l;
        if ((i & 4) != 0) {
            bool = roomPKScore.isMute;
        }
        Boolean bool2 = bool;
        if ((i & 8) != 0) {
            arrayList = roomPKScore.topSupport;
        }
        ArrayList arrayList2 = arrayList;
        if ((i & 16) != 0) {
            hashMap = roomPKScore.scoreReceive;
        }
        return roomPKScore.copy(str, l2, bool2, arrayList2, hashMap);
    }

    public final boolean checkIsInvite() {
        String str;
        GroupDetailBean inviteGroup;
        RoomPK mpk = MeetingRoomManager.INSTANCE.getMPK();
        String str2 = "";
        if (mpk == null || (inviteGroup = mpk.getInviteGroup()) == null || (str = inviteGroup.getGroupId()) == null) {
            str = "";
        }
        String str3 = this.groupId;
        if (str3 != null) {
            str2 = str3;
        }
        return Intrinsics.areEqual(str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getScore() {
        return this.score;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Boolean getIsMute() {
        return this.isMute;
    }

    @Nullable
    public final ArrayList<RoomPKUser> component4() {
        return this.topSupport;
    }

    @Nullable
    public final HashMap<String, Long> component5() {
        return this.scoreReceive;
    }

    @NotNull
    public final RoomPKScore copy(@Nullable String groupId, @Nullable Long score, @Nullable Boolean isMute, @Nullable ArrayList<RoomPKUser> topSupport, @Nullable HashMap<String, Long> scoreReceive) {
        return new RoomPKScore(groupId, score, isMute, topSupport, scoreReceive);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomPKScore)) {
            return false;
        }
        RoomPKScore roomPKScore = (RoomPKScore) other;
        return Intrinsics.areEqual(this.groupId, roomPKScore.groupId) && Intrinsics.areEqual(this.score, roomPKScore.score) && Intrinsics.areEqual(this.isMute, roomPKScore.isMute) && Intrinsics.areEqual(this.topSupport, roomPKScore.topSupport) && Intrinsics.areEqual(this.scoreReceive, roomPKScore.scoreReceive);
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final Long getScore() {
        return this.score;
    }

    @Nullable
    public final HashMap<String, Long> getScoreReceive() {
        return this.scoreReceive;
    }

    @Nullable
    public final ArrayList<RoomPKUser> getTopSupport() {
        return this.topSupport;
    }

    public int hashCode() {
        String str = this.groupId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.score;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        Boolean bool = this.isMute;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        ArrayList<RoomPKUser> arrayList = this.topSupport;
        int hashCode4 = (hashCode3 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        HashMap<String, Long> hashMap = this.scoreReceive;
        return hashCode4 + (hashMap != null ? hashMap.hashCode() : 0);
    }

    @Nullable
    public final Boolean isMute() {
        return this.isMute;
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    public final void setMute(@Nullable Boolean bool) {
        this.isMute = bool;
    }

    public final void setScore(@Nullable Long l) {
        this.score = l;
    }

    public final void setScoreReceive(@Nullable HashMap<String, Long> hashMap) {
        this.scoreReceive = hashMap;
    }

    public final void setTopSupport(@Nullable ArrayList<RoomPKUser> arrayList) {
        this.topSupport = arrayList;
    }

    @NotNull
    public String toString() {
        return "RoomPKScore(groupId=" + this.groupId + ", score=" + this.score + ", isMute=" + this.isMute + ", topSupport=" + this.topSupport + ", scoreReceive=" + this.scoreReceive + ")";
    }

    public RoomPKScore(@Nullable String str, @Nullable Long l, @Nullable Boolean bool, @Nullable ArrayList<RoomPKUser> arrayList, @Nullable HashMap<String, Long> hashMap) {
        this.groupId = str;
        this.score = l;
        this.isMute = bool;
        this.topSupport = arrayList;
        this.scoreReceive = hashMap;
    }

    public /* synthetic */ RoomPKScore(String str, Long l, Boolean bool, ArrayList arrayList, HashMap hashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0L : l, (i & 4) != 0 ? Boolean.FALSE : bool, (i & 8) != 0 ? null : arrayList, (i & 16) != 0 ? null : hashMap);
    }
}
