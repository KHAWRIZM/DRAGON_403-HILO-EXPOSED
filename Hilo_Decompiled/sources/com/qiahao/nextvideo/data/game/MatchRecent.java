package com.qiahao.nextvideo.data.game;

import com.qiahao.base_common.model.common.User;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J<\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006'"}, d2 = {"Lcom/qiahao/nextvideo/data/game/MatchRecent;", "", "gameType", "", "user", "Lcom/qiahao/base_common/model/common/User;", "gameIcon", "", "position", "<init>", "(Ljava/lang/Integer;Lcom/qiahao/base_common/model/common/User;Ljava/lang/String;I)V", "getGameType", "()Ljava/lang/Integer;", "setGameType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "setUser", "(Lcom/qiahao/base_common/model/common/User;)V", "getGameIcon", "()Ljava/lang/String;", "setGameIcon", "(Ljava/lang/String;)V", "getPosition", "()I", "setPosition", "(I)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Lcom/qiahao/base_common/model/common/User;Ljava/lang/String;I)Lcom/qiahao/nextvideo/data/game/MatchRecent;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MatchRecent {

    @Nullable
    private String gameIcon;

    @Nullable
    private Integer gameType;
    private int position;

    @Nullable
    private User user;

    public MatchRecent() {
        this(null, null, null, 0, 15, null);
    }

    public static /* synthetic */ MatchRecent copy$default(MatchRecent matchRecent, Integer num, User user, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = matchRecent.gameType;
        }
        if ((i2 & 2) != 0) {
            user = matchRecent.user;
        }
        if ((i2 & 4) != 0) {
            str = matchRecent.gameIcon;
        }
        if ((i2 & 8) != 0) {
            i = matchRecent.position;
        }
        return matchRecent.copy(num, user, str, i);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getGameType() {
        return this.gameType;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getGameIcon() {
        return this.gameIcon;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    @NotNull
    public final MatchRecent copy(@Nullable Integer gameType, @Nullable User user, @Nullable String gameIcon, int position) {
        return new MatchRecent(gameType, user, gameIcon, position);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatchRecent)) {
            return false;
        }
        MatchRecent matchRecent = (MatchRecent) other;
        return Intrinsics.areEqual(this.gameType, matchRecent.gameType) && Intrinsics.areEqual(this.user, matchRecent.user) && Intrinsics.areEqual(this.gameIcon, matchRecent.gameIcon) && this.position == matchRecent.position;
    }

    @Nullable
    public final String getGameIcon() {
        return this.gameIcon;
    }

    @Nullable
    public final Integer getGameType() {
        return this.gameType;
    }

    public final int getPosition() {
        return this.position;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        Integer num = this.gameType;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        User user = this.user;
        int hashCode2 = (hashCode + (user == null ? 0 : user.hashCode())) * 31;
        String str = this.gameIcon;
        return ((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.position;
    }

    public final void setGameIcon(@Nullable String str) {
        this.gameIcon = str;
    }

    public final void setGameType(@Nullable Integer num) {
        this.gameType = num;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final void setUser(@Nullable User user) {
        this.user = user;
    }

    @NotNull
    public String toString() {
        return "MatchRecent(gameType=" + this.gameType + ", user=" + this.user + ", gameIcon=" + this.gameIcon + ", position=" + this.position + ")";
    }

    public MatchRecent(@Nullable Integer num, @Nullable User user, @Nullable String str, int i) {
        this.gameType = num;
        this.user = user;
        this.gameIcon = str;
        this.position = i;
    }

    public /* synthetic */ MatchRecent(Integer num, User user, String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : num, (i2 & 2) != 0 ? null : user, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? 0 : i);
    }
}
