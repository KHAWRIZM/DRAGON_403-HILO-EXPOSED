package com.qiahao.nextvideo.data.room;

import com.qiahao.nextvideo.ui.transfer.TransferCenterFragment;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010-\u001a\u00020\u0003HÆ\u0003Jd\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0003HÖ\u0001J\t\u00104\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010\u0013¨\u00065"}, d2 = {"Lcom/qiahao/nextvideo/data/room/RoomPKEnd;", "", "win", "", TransferCenterFragment.TYPE_DIAMONDS, "", "groupName", "", TUIConstants.TUIGroup.GROUP_FACE_URL, "top3", "", "Lcom/qiahao/nextvideo/data/room/RoomPKUser;", "punishEndTimeUnix", "boxLevel", "<init>", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;I)V", "getWin", "()I", "setWin", "(I)V", "getDiamonds", "()Ljava/lang/Long;", "setDiamonds", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getGroupName", "()Ljava/lang/String;", "setGroupName", "(Ljava/lang/String;)V", "getGroupFaceUrl", "setGroupFaceUrl", "getTop3", "()Ljava/util/List;", "setTop3", "(Ljava/util/List;)V", "getPunishEndTimeUnix", "setPunishEndTimeUnix", "getBoxLevel", "setBoxLevel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;I)Lcom/qiahao/nextvideo/data/room/RoomPKEnd;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class RoomPKEnd {
    private int boxLevel;

    @Nullable
    private Long diamonds;

    @Nullable
    private String groupFaceUrl;

    @Nullable
    private String groupName;

    @Nullable
    private Long punishEndTimeUnix;

    @Nullable
    private List<RoomPKUser> top3;
    private int win;

    public RoomPKEnd() {
        this(0, null, null, null, null, null, 0, 127, null);
    }

    public static /* synthetic */ RoomPKEnd copy$default(RoomPKEnd roomPKEnd, int i, Long l, String str, String str2, List list, Long l2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = roomPKEnd.win;
        }
        if ((i3 & 2) != 0) {
            l = roomPKEnd.diamonds;
        }
        Long l3 = l;
        if ((i3 & 4) != 0) {
            str = roomPKEnd.groupName;
        }
        String str3 = str;
        if ((i3 & 8) != 0) {
            str2 = roomPKEnd.groupFaceUrl;
        }
        String str4 = str2;
        if ((i3 & 16) != 0) {
            list = roomPKEnd.top3;
        }
        List list2 = list;
        if ((i3 & 32) != 0) {
            l2 = roomPKEnd.punishEndTimeUnix;
        }
        Long l4 = l2;
        if ((i3 & 64) != 0) {
            i2 = roomPKEnd.boxLevel;
        }
        return roomPKEnd.copy(i, l3, str3, str4, list2, l4, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getWin() {
        return this.win;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getDiamonds() {
        return this.diamonds;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getGroupName() {
        return this.groupName;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getGroupFaceUrl() {
        return this.groupFaceUrl;
    }

    @Nullable
    public final List<RoomPKUser> component5() {
        return this.top3;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Long getPunishEndTimeUnix() {
        return this.punishEndTimeUnix;
    }

    /* renamed from: component7, reason: from getter */
    public final int getBoxLevel() {
        return this.boxLevel;
    }

    @NotNull
    public final RoomPKEnd copy(int win, @Nullable Long diamonds, @Nullable String groupName, @Nullable String groupFaceUrl, @Nullable List<RoomPKUser> top3, @Nullable Long punishEndTimeUnix, int boxLevel) {
        return new RoomPKEnd(win, diamonds, groupName, groupFaceUrl, top3, punishEndTimeUnix, boxLevel);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomPKEnd)) {
            return false;
        }
        RoomPKEnd roomPKEnd = (RoomPKEnd) other;
        return this.win == roomPKEnd.win && Intrinsics.areEqual(this.diamonds, roomPKEnd.diamonds) && Intrinsics.areEqual(this.groupName, roomPKEnd.groupName) && Intrinsics.areEqual(this.groupFaceUrl, roomPKEnd.groupFaceUrl) && Intrinsics.areEqual(this.top3, roomPKEnd.top3) && Intrinsics.areEqual(this.punishEndTimeUnix, roomPKEnd.punishEndTimeUnix) && this.boxLevel == roomPKEnd.boxLevel;
    }

    public final int getBoxLevel() {
        return this.boxLevel;
    }

    @Nullable
    public final Long getDiamonds() {
        return this.diamonds;
    }

    @Nullable
    public final String getGroupFaceUrl() {
        return this.groupFaceUrl;
    }

    @Nullable
    public final String getGroupName() {
        return this.groupName;
    }

    @Nullable
    public final Long getPunishEndTimeUnix() {
        return this.punishEndTimeUnix;
    }

    @Nullable
    public final List<RoomPKUser> getTop3() {
        return this.top3;
    }

    public final int getWin() {
        return this.win;
    }

    public int hashCode() {
        int i = this.win * 31;
        Long l = this.diamonds;
        int hashCode = (i + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.groupName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.groupFaceUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<RoomPKUser> list = this.top3;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        Long l2 = this.punishEndTimeUnix;
        return ((hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31) + this.boxLevel;
    }

    public final void setBoxLevel(int i) {
        this.boxLevel = i;
    }

    public final void setDiamonds(@Nullable Long l) {
        this.diamonds = l;
    }

    public final void setGroupFaceUrl(@Nullable String str) {
        this.groupFaceUrl = str;
    }

    public final void setGroupName(@Nullable String str) {
        this.groupName = str;
    }

    public final void setPunishEndTimeUnix(@Nullable Long l) {
        this.punishEndTimeUnix = l;
    }

    public final void setTop3(@Nullable List<RoomPKUser> list) {
        this.top3 = list;
    }

    public final void setWin(int i) {
        this.win = i;
    }

    @NotNull
    public String toString() {
        return "RoomPKEnd(win=" + this.win + ", diamonds=" + this.diamonds + ", groupName=" + this.groupName + ", groupFaceUrl=" + this.groupFaceUrl + ", top3=" + this.top3 + ", punishEndTimeUnix=" + this.punishEndTimeUnix + ", boxLevel=" + this.boxLevel + ")";
    }

    public RoomPKEnd(int i, @Nullable Long l, @Nullable String str, @Nullable String str2, @Nullable List<RoomPKUser> list, @Nullable Long l2, int i2) {
        this.win = i;
        this.diamonds = l;
        this.groupName = str;
        this.groupFaceUrl = str2;
        this.top3 = list;
        this.punishEndTimeUnix = l2;
        this.boxLevel = i2;
    }

    public /* synthetic */ RoomPKEnd(int i, Long l, String str, String str2, List list, Long l2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? null : l, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : list, (i3 & 32) == 0 ? l2 : null, (i3 & 64) != 0 ? 0 : i2);
    }
}
