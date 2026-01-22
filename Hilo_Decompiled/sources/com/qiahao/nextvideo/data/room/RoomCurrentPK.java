package com.qiahao.nextvideo.data.room;

import androidx.collection.c;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003JA\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0006HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006+"}, d2 = {"Lcom/qiahao/nextvideo/data/room/RoomCurrentPK;", "", "inviteGroup", "Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "receiveGroup", "status", "", "totalPoints", "", "groupPkFinish", "Lcom/qiahao/nextvideo/data/room/RoomPKEnd;", "<init>", "(Lcom/qiahao/nextvideo/data/model/GroupDetailBean;Lcom/qiahao/nextvideo/data/model/GroupDetailBean;IJLcom/qiahao/nextvideo/data/room/RoomPKEnd;)V", "getInviteGroup", "()Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "setInviteGroup", "(Lcom/qiahao/nextvideo/data/model/GroupDetailBean;)V", "getReceiveGroup", "setReceiveGroup", "getStatus", "()I", "setStatus", "(I)V", "getTotalPoints", "()J", "setTotalPoints", "(J)V", "getGroupPkFinish", "()Lcom/qiahao/nextvideo/data/room/RoomPKEnd;", "setGroupPkFinish", "(Lcom/qiahao/nextvideo/data/room/RoomPKEnd;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class RoomCurrentPK {

    @Nullable
    private RoomPKEnd groupPkFinish;

    @Nullable
    private GroupDetailBean inviteGroup;

    @Nullable
    private GroupDetailBean receiveGroup;
    private int status;
    private long totalPoints;

    public RoomCurrentPK(@Nullable GroupDetailBean groupDetailBean, @Nullable GroupDetailBean groupDetailBean2, int i, long j, @Nullable RoomPKEnd roomPKEnd) {
        this.inviteGroup = groupDetailBean;
        this.receiveGroup = groupDetailBean2;
        this.status = i;
        this.totalPoints = j;
        this.groupPkFinish = roomPKEnd;
    }

    public static /* synthetic */ RoomCurrentPK copy$default(RoomCurrentPK roomCurrentPK, GroupDetailBean groupDetailBean, GroupDetailBean groupDetailBean2, int i, long j, RoomPKEnd roomPKEnd, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            groupDetailBean = roomCurrentPK.inviteGroup;
        }
        if ((i2 & 2) != 0) {
            groupDetailBean2 = roomCurrentPK.receiveGroup;
        }
        GroupDetailBean groupDetailBean3 = groupDetailBean2;
        if ((i2 & 4) != 0) {
            i = roomCurrentPK.status;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            j = roomCurrentPK.totalPoints;
        }
        long j2 = j;
        if ((i2 & 16) != 0) {
            roomPKEnd = roomCurrentPK.groupPkFinish;
        }
        return roomCurrentPK.copy(groupDetailBean, groupDetailBean3, i3, j2, roomPKEnd);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final GroupDetailBean getInviteGroup() {
        return this.inviteGroup;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final GroupDetailBean getReceiveGroup() {
        return this.receiveGroup;
    }

    /* renamed from: component3, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component4, reason: from getter */
    public final long getTotalPoints() {
        return this.totalPoints;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final RoomPKEnd getGroupPkFinish() {
        return this.groupPkFinish;
    }

    @NotNull
    public final RoomCurrentPK copy(@Nullable GroupDetailBean inviteGroup, @Nullable GroupDetailBean receiveGroup, int status, long totalPoints, @Nullable RoomPKEnd groupPkFinish) {
        return new RoomCurrentPK(inviteGroup, receiveGroup, status, totalPoints, groupPkFinish);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomCurrentPK)) {
            return false;
        }
        RoomCurrentPK roomCurrentPK = (RoomCurrentPK) other;
        return Intrinsics.areEqual(this.inviteGroup, roomCurrentPK.inviteGroup) && Intrinsics.areEqual(this.receiveGroup, roomCurrentPK.receiveGroup) && this.status == roomCurrentPK.status && this.totalPoints == roomCurrentPK.totalPoints && Intrinsics.areEqual(this.groupPkFinish, roomCurrentPK.groupPkFinish);
    }

    @Nullable
    public final RoomPKEnd getGroupPkFinish() {
        return this.groupPkFinish;
    }

    @Nullable
    public final GroupDetailBean getInviteGroup() {
        return this.inviteGroup;
    }

    @Nullable
    public final GroupDetailBean getReceiveGroup() {
        return this.receiveGroup;
    }

    public final int getStatus() {
        return this.status;
    }

    public final long getTotalPoints() {
        return this.totalPoints;
    }

    public int hashCode() {
        GroupDetailBean groupDetailBean = this.inviteGroup;
        int hashCode = (groupDetailBean == null ? 0 : groupDetailBean.hashCode()) * 31;
        GroupDetailBean groupDetailBean2 = this.receiveGroup;
        int hashCode2 = (((((hashCode + (groupDetailBean2 == null ? 0 : groupDetailBean2.hashCode())) * 31) + this.status) * 31) + c.a(this.totalPoints)) * 31;
        RoomPKEnd roomPKEnd = this.groupPkFinish;
        return hashCode2 + (roomPKEnd != null ? roomPKEnd.hashCode() : 0);
    }

    public final void setGroupPkFinish(@Nullable RoomPKEnd roomPKEnd) {
        this.groupPkFinish = roomPKEnd;
    }

    public final void setInviteGroup(@Nullable GroupDetailBean groupDetailBean) {
        this.inviteGroup = groupDetailBean;
    }

    public final void setReceiveGroup(@Nullable GroupDetailBean groupDetailBean) {
        this.receiveGroup = groupDetailBean;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setTotalPoints(long j) {
        this.totalPoints = j;
    }

    @NotNull
    public String toString() {
        return "RoomCurrentPK(inviteGroup=" + this.inviteGroup + ", receiveGroup=" + this.receiveGroup + ", status=" + this.status + ", totalPoints=" + this.totalPoints + ", groupPkFinish=" + this.groupPkFinish + ")";
    }

    public /* synthetic */ RoomCurrentPK(GroupDetailBean groupDetailBean, GroupDetailBean groupDetailBean2, int i, long j, RoomPKEnd roomPKEnd, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : groupDetailBean, (i2 & 2) != 0 ? null : groupDetailBean2, (i2 & 4) != 0 ? 0 : i, j, (i2 & 16) != 0 ? null : roomPKEnd);
    }
}
