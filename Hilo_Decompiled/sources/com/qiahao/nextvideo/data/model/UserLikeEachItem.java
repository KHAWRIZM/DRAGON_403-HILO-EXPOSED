package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;
import q2.a;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/data/model/UserLikeEachItem;", "", "hasRead", "", "likeEachTime", "", "userBase", "Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "<init>", "(ZILcom/qiahao/nextvideo/data/model/UserSummaryInfo;)V", "getHasRead", "()Z", "getLikeEachTime", "()I", "getUserBase", "()Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class UserLikeEachItem {

    @c("hasRead")
    private final boolean hasRead;

    @c("likeMeTime")
    private final int likeEachTime;

    @NotNull
    @c("userBase")
    private final UserSummaryInfo userBase;

    public UserLikeEachItem(boolean z, int i, @NotNull UserSummaryInfo userSummaryInfo) {
        Intrinsics.checkNotNullParameter(userSummaryInfo, "userBase");
        this.hasRead = z;
        this.likeEachTime = i;
        this.userBase = userSummaryInfo;
    }

    public static /* synthetic */ UserLikeEachItem copy$default(UserLikeEachItem userLikeEachItem, boolean z, int i, UserSummaryInfo userSummaryInfo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = userLikeEachItem.hasRead;
        }
        if ((i2 & 2) != 0) {
            i = userLikeEachItem.likeEachTime;
        }
        if ((i2 & 4) != 0) {
            userSummaryInfo = userLikeEachItem.userBase;
        }
        return userLikeEachItem.copy(z, i, userSummaryInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getHasRead() {
        return this.hasRead;
    }

    /* renamed from: component2, reason: from getter */
    public final int getLikeEachTime() {
        return this.likeEachTime;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final UserSummaryInfo getUserBase() {
        return this.userBase;
    }

    @NotNull
    public final UserLikeEachItem copy(boolean hasRead, int likeEachTime, @NotNull UserSummaryInfo userBase) {
        Intrinsics.checkNotNullParameter(userBase, "userBase");
        return new UserLikeEachItem(hasRead, likeEachTime, userBase);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserLikeEachItem)) {
            return false;
        }
        UserLikeEachItem userLikeEachItem = (UserLikeEachItem) other;
        return this.hasRead == userLikeEachItem.hasRead && this.likeEachTime == userLikeEachItem.likeEachTime && Intrinsics.areEqual(this.userBase, userLikeEachItem.userBase);
    }

    public final boolean getHasRead() {
        return this.hasRead;
    }

    public final int getLikeEachTime() {
        return this.likeEachTime;
    }

    @NotNull
    public final UserSummaryInfo getUserBase() {
        return this.userBase;
    }

    public int hashCode() {
        return (((a.a(this.hasRead) * 31) + this.likeEachTime) * 31) + this.userBase.hashCode();
    }

    @NotNull
    public String toString() {
        return "UserLikeEachItem(hasRead=" + this.hasRead + ", likeEachTime=" + this.likeEachTime + ", userBase=" + this.userBase + ")";
    }
}
