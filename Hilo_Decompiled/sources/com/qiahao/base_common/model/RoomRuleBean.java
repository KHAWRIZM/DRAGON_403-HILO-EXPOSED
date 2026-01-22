package com.qiahao.base_common.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/qiahao/base_common/model/RoomRuleBean;", "", "externalId", "", "role", "", "<init>", "(Ljava/lang/String;I)V", "getExternalId", "()Ljava/lang/String;", "getRole", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class RoomRuleBean {

    @NotNull
    private final String externalId;
    private final int role;

    public RoomRuleBean(@NotNull String externalId, int i10) {
        Intrinsics.checkNotNullParameter(externalId, "externalId");
        this.externalId = externalId;
        this.role = i10;
    }

    public static /* synthetic */ RoomRuleBean copy$default(RoomRuleBean roomRuleBean, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = roomRuleBean.externalId;
        }
        if ((i11 & 2) != 0) {
            i10 = roomRuleBean.role;
        }
        return roomRuleBean.copy(str, i10);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRole() {
        return this.role;
    }

    @NotNull
    public final RoomRuleBean copy(@NotNull String externalId, int role) {
        Intrinsics.checkNotNullParameter(externalId, "externalId");
        return new RoomRuleBean(externalId, role);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomRuleBean)) {
            return false;
        }
        RoomRuleBean roomRuleBean = (RoomRuleBean) other;
        return Intrinsics.areEqual(this.externalId, roomRuleBean.externalId) && this.role == roomRuleBean.role;
    }

    @NotNull
    public final String getExternalId() {
        return this.externalId;
    }

    public final int getRole() {
        return this.role;
    }

    public int hashCode() {
        return (this.externalId.hashCode() * 31) + this.role;
    }

    @NotNull
    public String toString() {
        return "RoomRuleBean(externalId=" + this.externalId + ", role=" + this.role + ")";
    }
}
