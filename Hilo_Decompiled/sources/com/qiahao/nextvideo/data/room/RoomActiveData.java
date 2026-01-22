package com.qiahao.nextvideo.data.room;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.qiahao.base_common.model.common.User;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J0\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/data/room/RoomActiveData;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "num", "", "userBase", "Lcom/qiahao/base_common/model/common/User;", "itemType", "", "<init>", "(Ljava/lang/Long;Lcom/qiahao/base_common/model/common/User;I)V", "getNum", "()Ljava/lang/Long;", "setNum", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getUserBase", "()Lcom/qiahao/base_common/model/common/User;", "setUserBase", "(Lcom/qiahao/base_common/model/common/User;)V", "getItemType", "()I", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Lcom/qiahao/base_common/model/common/User;I)Lcom/qiahao/nextvideo/data/room/RoomActiveData;", "equals", "", "other", "", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class RoomActiveData implements MultiItemEntity {
    private final int itemType;

    @Nullable
    private Long num;

    @Nullable
    private User userBase;

    public RoomActiveData(@Nullable Long l, @Nullable User user, int i) {
        this.num = l;
        this.userBase = user;
        this.itemType = i;
    }

    public static /* synthetic */ RoomActiveData copy$default(RoomActiveData roomActiveData, Long l, User user, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            l = roomActiveData.num;
        }
        if ((i2 & 2) != 0) {
            user = roomActiveData.userBase;
        }
        if ((i2 & 4) != 0) {
            i = roomActiveData.itemType;
        }
        return roomActiveData.copy(l, user, i);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getNum() {
        return this.num;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final User getUserBase() {
        return this.userBase;
    }

    /* renamed from: component3, reason: from getter */
    public final int getItemType() {
        return this.itemType;
    }

    @NotNull
    public final RoomActiveData copy(@Nullable Long num, @Nullable User userBase, int itemType) {
        return new RoomActiveData(num, userBase, itemType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomActiveData)) {
            return false;
        }
        RoomActiveData roomActiveData = (RoomActiveData) other;
        return Intrinsics.areEqual(this.num, roomActiveData.num) && Intrinsics.areEqual(this.userBase, roomActiveData.userBase) && this.itemType == roomActiveData.itemType;
    }

    public int getItemType() {
        return this.itemType;
    }

    @Nullable
    public final Long getNum() {
        return this.num;
    }

    @Nullable
    public final User getUserBase() {
        return this.userBase;
    }

    public int hashCode() {
        Long l = this.num;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        User user = this.userBase;
        return ((hashCode + (user != null ? user.hashCode() : 0)) * 31) + this.itemType;
    }

    public final void setNum(@Nullable Long l) {
        this.num = l;
    }

    public final void setUserBase(@Nullable User user) {
        this.userBase = user;
    }

    @NotNull
    public String toString() {
        return "RoomActiveData(num=" + this.num + ", userBase=" + this.userBase + ", itemType=" + this.itemType + ")";
    }

    public /* synthetic */ RoomActiveData(Long l, User user, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : l, (i2 & 2) != 0 ? null : user, i);
    }
}
