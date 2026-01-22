package com.qiahao.nextvideo.data.room;

import com.qiahao.base_common.model.common.User;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\f¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/data/room/RoomRecordData;", "", "beOperUser", "Lcom/qiahao/base_common/model/common/User;", "operTimeUnix", "", "operUser", "<init>", "(Lcom/qiahao/base_common/model/common/User;Ljava/lang/Long;Lcom/qiahao/base_common/model/common/User;)V", "getBeOperUser", "()Lcom/qiahao/base_common/model/common/User;", "setBeOperUser", "(Lcom/qiahao/base_common/model/common/User;)V", "getOperTimeUnix", "()Ljava/lang/Long;", "setOperTimeUnix", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getOperUser", "setOperUser", "component1", "component2", "component3", "copy", "(Lcom/qiahao/base_common/model/common/User;Ljava/lang/Long;Lcom/qiahao/base_common/model/common/User;)Lcom/qiahao/nextvideo/data/room/RoomRecordData;", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class RoomRecordData {

    @Nullable
    private User beOperUser;

    @Nullable
    private Long operTimeUnix;

    @Nullable
    private User operUser;

    public RoomRecordData() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ RoomRecordData copy$default(RoomRecordData roomRecordData, User user, Long l, User user2, int i, Object obj) {
        if ((i & 1) != 0) {
            user = roomRecordData.beOperUser;
        }
        if ((i & 2) != 0) {
            l = roomRecordData.operTimeUnix;
        }
        if ((i & 4) != 0) {
            user2 = roomRecordData.operUser;
        }
        return roomRecordData.copy(user, l, user2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final User getBeOperUser() {
        return this.beOperUser;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getOperTimeUnix() {
        return this.operTimeUnix;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final User getOperUser() {
        return this.operUser;
    }

    @NotNull
    public final RoomRecordData copy(@Nullable User beOperUser, @Nullable Long operTimeUnix, @Nullable User operUser) {
        return new RoomRecordData(beOperUser, operTimeUnix, operUser);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomRecordData)) {
            return false;
        }
        RoomRecordData roomRecordData = (RoomRecordData) other;
        return Intrinsics.areEqual(this.beOperUser, roomRecordData.beOperUser) && Intrinsics.areEqual(this.operTimeUnix, roomRecordData.operTimeUnix) && Intrinsics.areEqual(this.operUser, roomRecordData.operUser);
    }

    @Nullable
    public final User getBeOperUser() {
        return this.beOperUser;
    }

    @Nullable
    public final Long getOperTimeUnix() {
        return this.operTimeUnix;
    }

    @Nullable
    public final User getOperUser() {
        return this.operUser;
    }

    public int hashCode() {
        User user = this.beOperUser;
        int hashCode = (user == null ? 0 : user.hashCode()) * 31;
        Long l = this.operTimeUnix;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        User user2 = this.operUser;
        return hashCode2 + (user2 != null ? user2.hashCode() : 0);
    }

    public final void setBeOperUser(@Nullable User user) {
        this.beOperUser = user;
    }

    public final void setOperTimeUnix(@Nullable Long l) {
        this.operTimeUnix = l;
    }

    public final void setOperUser(@Nullable User user) {
        this.operUser = user;
    }

    @NotNull
    public String toString() {
        return "RoomRecordData(beOperUser=" + this.beOperUser + ", operTimeUnix=" + this.operTimeUnix + ", operUser=" + this.operUser + ")";
    }

    public RoomRecordData(@Nullable User user, @Nullable Long l, @Nullable User user2) {
        this.beOperUser = user;
        this.operTimeUnix = l;
        this.operUser = user2;
    }

    public /* synthetic */ RoomRecordData(User user, Long l, User user2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : user, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : user2);
    }
}
