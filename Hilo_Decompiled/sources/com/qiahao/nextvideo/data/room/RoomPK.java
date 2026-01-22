package com.qiahao.nextvideo.data.room;

import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJH\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\bHÖ\u0001J\t\u00105\u001a\u000206HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00067"}, d2 = {"Lcom/qiahao/nextvideo/data/room/RoomPK;", "", "endTimeUnix", "", "inviteGroup", "Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "receiveGroup", "status", "", "punishEndTimeUnix", "<init>", "(Ljava/lang/Long;Lcom/qiahao/nextvideo/data/model/GroupDetailBean;Lcom/qiahao/nextvideo/data/model/GroupDetailBean;ILjava/lang/Long;)V", "getEndTimeUnix", "()Ljava/lang/Long;", "setEndTimeUnix", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getInviteGroup", "()Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "setInviteGroup", "(Lcom/qiahao/nextvideo/data/model/GroupDetailBean;)V", "getReceiveGroup", "setReceiveGroup", "getStatus", "()I", "setStatus", "(I)V", "getPunishEndTimeUnix", "setPunishEndTimeUnix", "roomPKPro", "Lcom/qiahao/nextvideo/data/room/RoomPKScoreRes;", "getRoomPKPro", "()Lcom/qiahao/nextvideo/data/room/RoomPKScoreRes;", "setRoomPKPro", "(Lcom/qiahao/nextvideo/data/room/RoomPKScoreRes;)V", "pkExternalData", "Lcom/qiahao/nextvideo/data/room/PKInviteCancel;", "getPkExternalData", "()Lcom/qiahao/nextvideo/data/room/PKInviteCancel;", "setPkExternalData", "(Lcom/qiahao/nextvideo/data/room/PKInviteCancel;)V", "checkIsInvite", "", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Lcom/qiahao/nextvideo/data/model/GroupDetailBean;Lcom/qiahao/nextvideo/data/model/GroupDetailBean;ILjava/lang/Long;)Lcom/qiahao/nextvideo/data/room/RoomPK;", "equals", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class RoomPK {

    @Nullable
    private Long endTimeUnix;

    @Nullable
    private GroupDetailBean inviteGroup;

    @Nullable
    private PKInviteCancel pkExternalData;

    @Nullable
    private Long punishEndTimeUnix;

    @Nullable
    private GroupDetailBean receiveGroup;

    @Nullable
    private RoomPKScoreRes roomPKPro;
    private int status;

    public RoomPK() {
        this(null, null, null, 0, null, 31, null);
    }

    public static /* synthetic */ RoomPK copy$default(RoomPK roomPK, Long l, GroupDetailBean groupDetailBean, GroupDetailBean groupDetailBean2, int i, Long l2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            l = roomPK.endTimeUnix;
        }
        if ((i2 & 2) != 0) {
            groupDetailBean = roomPK.inviteGroup;
        }
        GroupDetailBean groupDetailBean3 = groupDetailBean;
        if ((i2 & 4) != 0) {
            groupDetailBean2 = roomPK.receiveGroup;
        }
        GroupDetailBean groupDetailBean4 = groupDetailBean2;
        if ((i2 & 8) != 0) {
            i = roomPK.status;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            l2 = roomPK.punishEndTimeUnix;
        }
        return roomPK.copy(l, groupDetailBean3, groupDetailBean4, i3, l2);
    }

    public final boolean checkIsInvite() {
        String str;
        GroupDetailBean groupDetailBean = this.inviteGroup;
        if (groupDetailBean != null) {
            str = groupDetailBean.getGroupId();
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, MeetingRoomManager.INSTANCE.getMGroupId());
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getEndTimeUnix() {
        return this.endTimeUnix;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final GroupDetailBean getInviteGroup() {
        return this.inviteGroup;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final GroupDetailBean getReceiveGroup() {
        return this.receiveGroup;
    }

    /* renamed from: component4, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Long getPunishEndTimeUnix() {
        return this.punishEndTimeUnix;
    }

    @NotNull
    public final RoomPK copy(@Nullable Long endTimeUnix, @Nullable GroupDetailBean inviteGroup, @Nullable GroupDetailBean receiveGroup, int status, @Nullable Long punishEndTimeUnix) {
        return new RoomPK(endTimeUnix, inviteGroup, receiveGroup, status, punishEndTimeUnix);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomPK)) {
            return false;
        }
        RoomPK roomPK = (RoomPK) other;
        return Intrinsics.areEqual(this.endTimeUnix, roomPK.endTimeUnix) && Intrinsics.areEqual(this.inviteGroup, roomPK.inviteGroup) && Intrinsics.areEqual(this.receiveGroup, roomPK.receiveGroup) && this.status == roomPK.status && Intrinsics.areEqual(this.punishEndTimeUnix, roomPK.punishEndTimeUnix);
    }

    @Nullable
    public final Long getEndTimeUnix() {
        return this.endTimeUnix;
    }

    @Nullable
    public final GroupDetailBean getInviteGroup() {
        return this.inviteGroup;
    }

    @Nullable
    public final PKInviteCancel getPkExternalData() {
        return this.pkExternalData;
    }

    @Nullable
    public final Long getPunishEndTimeUnix() {
        return this.punishEndTimeUnix;
    }

    @Nullable
    public final GroupDetailBean getReceiveGroup() {
        return this.receiveGroup;
    }

    @Nullable
    public final RoomPKScoreRes getRoomPKPro() {
        return this.roomPKPro;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        Long l = this.endTimeUnix;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        GroupDetailBean groupDetailBean = this.inviteGroup;
        int hashCode2 = (hashCode + (groupDetailBean == null ? 0 : groupDetailBean.hashCode())) * 31;
        GroupDetailBean groupDetailBean2 = this.receiveGroup;
        int hashCode3 = (((hashCode2 + (groupDetailBean2 == null ? 0 : groupDetailBean2.hashCode())) * 31) + this.status) * 31;
        Long l2 = this.punishEndTimeUnix;
        return hashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public final void setEndTimeUnix(@Nullable Long l) {
        this.endTimeUnix = l;
    }

    public final void setInviteGroup(@Nullable GroupDetailBean groupDetailBean) {
        this.inviteGroup = groupDetailBean;
    }

    public final void setPkExternalData(@Nullable PKInviteCancel pKInviteCancel) {
        this.pkExternalData = pKInviteCancel;
    }

    public final void setPunishEndTimeUnix(@Nullable Long l) {
        this.punishEndTimeUnix = l;
    }

    public final void setReceiveGroup(@Nullable GroupDetailBean groupDetailBean) {
        this.receiveGroup = groupDetailBean;
    }

    public final void setRoomPKPro(@Nullable RoomPKScoreRes roomPKScoreRes) {
        this.roomPKPro = roomPKScoreRes;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    @NotNull
    public String toString() {
        return "RoomPK(endTimeUnix=" + this.endTimeUnix + ", inviteGroup=" + this.inviteGroup + ", receiveGroup=" + this.receiveGroup + ", status=" + this.status + ", punishEndTimeUnix=" + this.punishEndTimeUnix + ")";
    }

    public RoomPK(@Nullable Long l, @Nullable GroupDetailBean groupDetailBean, @Nullable GroupDetailBean groupDetailBean2, int i, @Nullable Long l2) {
        this.endTimeUnix = l;
        this.inviteGroup = groupDetailBean;
        this.receiveGroup = groupDetailBean2;
        this.status = i;
        this.punishEndTimeUnix = l2;
    }

    public /* synthetic */ RoomPK(Long l, GroupDetailBean groupDetailBean, GroupDetailBean groupDetailBean2, int i, Long l2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : l, (i2 & 2) != 0 ? null : groupDetailBean, (i2 & 4) != 0 ? null : groupDetailBean2, (i2 & 8) != 0 ? -1 : i, (i2 & 16) != 0 ? null : l2);
    }
}
