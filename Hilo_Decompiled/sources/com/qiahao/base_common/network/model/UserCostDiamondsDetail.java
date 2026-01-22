package com.qiahao.base_common.network.model;

import androidx.annotation.Keep;
import com.google.firebase.sessions.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003JQ\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\bHÖ\u0001J\t\u0010(\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/qiahao/base_common/network/model/UserCostDiamondsDetail;", "", "id", "", "createdAt", "uid", "", "operationType", "", "amount", "", "useType", "desc", "<init>", "(JJLjava/lang/String;IDILjava/lang/String;)V", "getId", "()J", "getCreatedAt", "getUid", "()Ljava/lang/String;", "getOperationType", "()I", "getAmount", "()D", "getUseType", "getDesc", "setDesc", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class UserCostDiamondsDetail {

    @c("diamondNum")
    private final double amount;

    @c("createdTime")
    private final long createdAt;

    @Nullable
    private String desc;

    @c("id")
    private final long id;

    @c("addReduce")
    private final int operationType;

    @NotNull
    @c("user_id")
    private final String uid;

    @c("operateType")
    private final int useType;

    public UserCostDiamondsDetail(long j10, long j11, @NotNull String uid, int i10, double d10, int i11, @Nullable String str) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        this.id = j10;
        this.createdAt = j11;
        this.uid = uid;
        this.operationType = i10;
        this.amount = d10;
        this.useType = i11;
        this.desc = str;
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    /* renamed from: component4, reason: from getter */
    public final int getOperationType() {
        return this.operationType;
    }

    /* renamed from: component5, reason: from getter */
    public final double getAmount() {
        return this.amount;
    }

    /* renamed from: component6, reason: from getter */
    public final int getUseType() {
        return this.useType;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final UserCostDiamondsDetail copy(long id, long createdAt, @NotNull String uid, int operationType, double amount, int useType, @Nullable String desc) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        return new UserCostDiamondsDetail(id, createdAt, uid, operationType, amount, useType, desc);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserCostDiamondsDetail)) {
            return false;
        }
        UserCostDiamondsDetail userCostDiamondsDetail = (UserCostDiamondsDetail) other;
        return this.id == userCostDiamondsDetail.id && this.createdAt == userCostDiamondsDetail.createdAt && Intrinsics.areEqual(this.uid, userCostDiamondsDetail.uid) && this.operationType == userCostDiamondsDetail.operationType && Double.compare(this.amount, userCostDiamondsDetail.amount) == 0 && this.useType == userCostDiamondsDetail.useType && Intrinsics.areEqual(this.desc, userCostDiamondsDetail.desc);
    }

    public final double getAmount() {
        return this.amount;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    public final long getId() {
        return this.id;
    }

    public final int getOperationType() {
        return this.operationType;
    }

    @NotNull
    public final String getUid() {
        return this.uid;
    }

    public final int getUseType() {
        return this.useType;
    }

    public int hashCode() {
        int a10 = ((((((((((androidx.collection.c.a(this.id) * 31) + androidx.collection.c.a(this.createdAt)) * 31) + this.uid.hashCode()) * 31) + this.operationType) * 31) + a.a(this.amount)) * 31) + this.useType) * 31;
        String str = this.desc;
        return a10 + (str == null ? 0 : str.hashCode());
    }

    public final void setDesc(@Nullable String str) {
        this.desc = str;
    }

    @NotNull
    public String toString() {
        return "UserCostDiamondsDetail(id=" + this.id + ", createdAt=" + this.createdAt + ", uid=" + this.uid + ", operationType=" + this.operationType + ", amount=" + this.amount + ", useType=" + this.useType + ", desc=" + this.desc + ")";
    }

    public /* synthetic */ UserCostDiamondsDetail(long j10, long j11, String str, int i10, double d10, int i11, String str2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j10, j11, str, i10, d10, i11, (i12 & 64) != 0 ? null : str2);
    }
}
