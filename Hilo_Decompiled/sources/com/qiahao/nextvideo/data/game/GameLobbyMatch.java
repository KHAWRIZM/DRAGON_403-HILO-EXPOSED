package com.qiahao.nextvideo.data.game;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJJ\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0006HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/qiahao/nextvideo/data/game/GameLobbyMatch;", "", "lastGroupId", "", "lastGameCode", "lastGameType", "", "lastMode", "remainSecond", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)V", "getLastGroupId", "()Ljava/lang/String;", "setLastGroupId", "(Ljava/lang/String;)V", "getLastGameCode", "setLastGameCode", "getLastGameType", "()Ljava/lang/Integer;", "setLastGameType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLastMode", "setLastMode", "getRemainSecond", "()Ljava/lang/Long;", "setRemainSecond", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/qiahao/nextvideo/data/game/GameLobbyMatch;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GameLobbyMatch {

    @Nullable
    private String lastGameCode;

    @Nullable
    private Integer lastGameType;

    @Nullable
    private String lastGroupId;

    @Nullable
    private Integer lastMode;

    @Nullable
    private Long remainSecond;

    public GameLobbyMatch() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ GameLobbyMatch copy$default(GameLobbyMatch gameLobbyMatch, String str, String str2, Integer num, Integer num2, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gameLobbyMatch.lastGroupId;
        }
        if ((i & 2) != 0) {
            str2 = gameLobbyMatch.lastGameCode;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            num = gameLobbyMatch.lastGameType;
        }
        Integer num3 = num;
        if ((i & 8) != 0) {
            num2 = gameLobbyMatch.lastMode;
        }
        Integer num4 = num2;
        if ((i & 16) != 0) {
            l = gameLobbyMatch.remainSecond;
        }
        return gameLobbyMatch.copy(str, str3, num3, num4, l);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getLastGroupId() {
        return this.lastGroupId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getLastGameCode() {
        return this.lastGameCode;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getLastGameType() {
        return this.lastGameType;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getLastMode() {
        return this.lastMode;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Long getRemainSecond() {
        return this.remainSecond;
    }

    @NotNull
    public final GameLobbyMatch copy(@Nullable String lastGroupId, @Nullable String lastGameCode, @Nullable Integer lastGameType, @Nullable Integer lastMode, @Nullable Long remainSecond) {
        return new GameLobbyMatch(lastGroupId, lastGameCode, lastGameType, lastMode, remainSecond);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameLobbyMatch)) {
            return false;
        }
        GameLobbyMatch gameLobbyMatch = (GameLobbyMatch) other;
        return Intrinsics.areEqual(this.lastGroupId, gameLobbyMatch.lastGroupId) && Intrinsics.areEqual(this.lastGameCode, gameLobbyMatch.lastGameCode) && Intrinsics.areEqual(this.lastGameType, gameLobbyMatch.lastGameType) && Intrinsics.areEqual(this.lastMode, gameLobbyMatch.lastMode) && Intrinsics.areEqual(this.remainSecond, gameLobbyMatch.remainSecond);
    }

    @Nullable
    public final String getLastGameCode() {
        return this.lastGameCode;
    }

    @Nullable
    public final Integer getLastGameType() {
        return this.lastGameType;
    }

    @Nullable
    public final String getLastGroupId() {
        return this.lastGroupId;
    }

    @Nullable
    public final Integer getLastMode() {
        return this.lastMode;
    }

    @Nullable
    public final Long getRemainSecond() {
        return this.remainSecond;
    }

    public int hashCode() {
        String str = this.lastGroupId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.lastGameCode;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.lastGameType;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.lastMode;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l = this.remainSecond;
        return hashCode4 + (l != null ? l.hashCode() : 0);
    }

    public final void setLastGameCode(@Nullable String str) {
        this.lastGameCode = str;
    }

    public final void setLastGameType(@Nullable Integer num) {
        this.lastGameType = num;
    }

    public final void setLastGroupId(@Nullable String str) {
        this.lastGroupId = str;
    }

    public final void setLastMode(@Nullable Integer num) {
        this.lastMode = num;
    }

    public final void setRemainSecond(@Nullable Long l) {
        this.remainSecond = l;
    }

    @NotNull
    public String toString() {
        return "GameLobbyMatch(lastGroupId=" + this.lastGroupId + ", lastGameCode=" + this.lastGameCode + ", lastGameType=" + this.lastGameType + ", lastMode=" + this.lastMode + ", remainSecond=" + this.remainSecond + ")";
    }

    public GameLobbyMatch(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2, @Nullable Long l) {
        this.lastGroupId = str;
        this.lastGameCode = str2;
        this.lastGameType = num;
        this.lastMode = num2;
        this.remainSecond = l;
    }

    public /* synthetic */ GameLobbyMatch(String str, String str2, Integer num, Integer num2, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) == 0 ? num2 : null, (i & 16) != 0 ? 0L : l);
    }
}
