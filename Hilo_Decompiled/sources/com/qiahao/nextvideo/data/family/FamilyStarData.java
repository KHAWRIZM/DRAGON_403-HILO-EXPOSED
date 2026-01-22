package com.qiahao.nextvideo.data.family;

import com.qiahao.base_common.model.common.User;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/data/family/FamilyStarData;", "", "user", "Lcom/qiahao/base_common/model/common/User;", "score", "", "<init>", "(Lcom/qiahao/base_common/model/common/User;Ljava/lang/Long;)V", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "setUser", "(Lcom/qiahao/base_common/model/common/User;)V", "getScore", "()Ljava/lang/Long;", "setScore", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "copy", "(Lcom/qiahao/base_common/model/common/User;Ljava/lang/Long;)Lcom/qiahao/nextvideo/data/family/FamilyStarData;", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class FamilyStarData {

    @Nullable
    private Long score;

    @Nullable
    private User user;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FamilyStarData() {
        this(r0, r0, 3, r0);
        User user = null;
    }

    public static /* synthetic */ FamilyStarData copy$default(FamilyStarData familyStarData, User user, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            user = familyStarData.user;
        }
        if ((i & 2) != 0) {
            l = familyStarData.score;
        }
        return familyStarData.copy(user, l);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getScore() {
        return this.score;
    }

    @NotNull
    public final FamilyStarData copy(@Nullable User user, @Nullable Long score) {
        return new FamilyStarData(user, score);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FamilyStarData)) {
            return false;
        }
        FamilyStarData familyStarData = (FamilyStarData) other;
        return Intrinsics.areEqual(this.user, familyStarData.user) && Intrinsics.areEqual(this.score, familyStarData.score);
    }

    @Nullable
    public final Long getScore() {
        return this.score;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        int hashCode = (user == null ? 0 : user.hashCode()) * 31;
        Long l = this.score;
        return hashCode + (l != null ? l.hashCode() : 0);
    }

    public final void setScore(@Nullable Long l) {
        this.score = l;
    }

    public final void setUser(@Nullable User user) {
        this.user = user;
    }

    @NotNull
    public String toString() {
        return "FamilyStarData(user=" + this.user + ", score=" + this.score + ")";
    }

    public FamilyStarData(@Nullable User user, @Nullable Long l) {
        this.user = user;
        this.score = l;
    }

    public /* synthetic */ FamilyStarData(User user, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : user, (i & 2) != 0 ? null : l);
    }
}
