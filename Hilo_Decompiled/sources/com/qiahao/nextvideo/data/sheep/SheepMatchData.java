package com.qiahao.nextvideo.data.sheep;

import com.qiahao.base_common.model.common.User;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J5\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/data/sheep/SheepMatchData;", "", "matchId", "", "user", "Lcom/qiahao/base_common/model/common/User;", "otherUser", "remainSecond", "<init>", "(ILcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/common/User;I)V", "getMatchId", "()I", "setMatchId", "(I)V", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "setUser", "(Lcom/qiahao/base_common/model/common/User;)V", "getOtherUser", "setOtherUser", "getRemainSecond", "setRemainSecond", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class SheepMatchData {
    private int matchId;

    @Nullable
    private User otherUser;
    private int remainSecond;

    @Nullable
    private User user;

    public SheepMatchData() {
        this(0, null, null, 0, 15, null);
    }

    public static /* synthetic */ SheepMatchData copy$default(SheepMatchData sheepMatchData, int i, User user, User user2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = sheepMatchData.matchId;
        }
        if ((i3 & 2) != 0) {
            user = sheepMatchData.user;
        }
        if ((i3 & 4) != 0) {
            user2 = sheepMatchData.otherUser;
        }
        if ((i3 & 8) != 0) {
            i2 = sheepMatchData.remainSecond;
        }
        return sheepMatchData.copy(i, user, user2, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMatchId() {
        return this.matchId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final User getOtherUser() {
        return this.otherUser;
    }

    /* renamed from: component4, reason: from getter */
    public final int getRemainSecond() {
        return this.remainSecond;
    }

    @NotNull
    public final SheepMatchData copy(int matchId, @Nullable User user, @Nullable User otherUser, int remainSecond) {
        return new SheepMatchData(matchId, user, otherUser, remainSecond);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SheepMatchData)) {
            return false;
        }
        SheepMatchData sheepMatchData = (SheepMatchData) other;
        return this.matchId == sheepMatchData.matchId && Intrinsics.areEqual(this.user, sheepMatchData.user) && Intrinsics.areEqual(this.otherUser, sheepMatchData.otherUser) && this.remainSecond == sheepMatchData.remainSecond;
    }

    public final int getMatchId() {
        return this.matchId;
    }

    @Nullable
    public final User getOtherUser() {
        return this.otherUser;
    }

    public final int getRemainSecond() {
        return this.remainSecond;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        int i = this.matchId * 31;
        User user = this.user;
        int hashCode = (i + (user == null ? 0 : user.hashCode())) * 31;
        User user2 = this.otherUser;
        return ((hashCode + (user2 != null ? user2.hashCode() : 0)) * 31) + this.remainSecond;
    }

    public final void setMatchId(int i) {
        this.matchId = i;
    }

    public final void setOtherUser(@Nullable User user) {
        this.otherUser = user;
    }

    public final void setRemainSecond(int i) {
        this.remainSecond = i;
    }

    public final void setUser(@Nullable User user) {
        this.user = user;
    }

    @NotNull
    public String toString() {
        return "SheepMatchData(matchId=" + this.matchId + ", user=" + this.user + ", otherUser=" + this.otherUser + ", remainSecond=" + this.remainSecond + ")";
    }

    public SheepMatchData(int i, @Nullable User user, @Nullable User user2, int i2) {
        this.matchId = i;
        this.user = user;
        this.otherUser = user2;
        this.remainSecond = i2;
    }

    public /* synthetic */ SheepMatchData(int i, User user, User user2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? null : user, (i3 & 4) != 0 ? null : user2, (i3 & 8) != 0 ? 0 : i2);
    }
}
