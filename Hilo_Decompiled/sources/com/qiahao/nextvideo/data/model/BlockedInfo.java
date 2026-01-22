package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/data/model/BlockedInfo;", "", "createdAt", "", "user", "Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "<init>", "(JLcom/qiahao/nextvideo/data/model/UserSummaryInfo;)V", "getCreatedAt", "()J", "getUser", "()Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class BlockedInfo {

    @c("blockTime")
    private final long createdAt;

    @NotNull
    @c("userBase")
    private final UserSummaryInfo user;

    public BlockedInfo(long j, @NotNull UserSummaryInfo userSummaryInfo) {
        Intrinsics.checkNotNullParameter(userSummaryInfo, "user");
        this.createdAt = j;
        this.user = userSummaryInfo;
    }

    public static /* synthetic */ BlockedInfo copy$default(BlockedInfo blockedInfo, long j, UserSummaryInfo userSummaryInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            j = blockedInfo.createdAt;
        }
        if ((i & 2) != 0) {
            userSummaryInfo = blockedInfo.user;
        }
        return blockedInfo.copy(j, userSummaryInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final UserSummaryInfo getUser() {
        return this.user;
    }

    @NotNull
    public final BlockedInfo copy(long createdAt, @NotNull UserSummaryInfo user) {
        Intrinsics.checkNotNullParameter(user, "user");
        return new BlockedInfo(createdAt, user);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlockedInfo)) {
            return false;
        }
        BlockedInfo blockedInfo = (BlockedInfo) other;
        return this.createdAt == blockedInfo.createdAt && Intrinsics.areEqual(this.user, blockedInfo.user);
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    @NotNull
    public final UserSummaryInfo getUser() {
        return this.user;
    }

    public int hashCode() {
        return (androidx.collection.c.a(this.createdAt) * 31) + this.user.hashCode();
    }

    @NotNull
    public String toString() {
        return "BlockedInfo(createdAt=" + this.createdAt + ", user=" + this.user + ")";
    }

    public /* synthetic */ BlockedInfo(long j, UserSummaryInfo userSummaryInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, userSummaryInfo);
    }
}
