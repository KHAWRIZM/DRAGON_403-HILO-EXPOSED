package com.tencent.qcloud.tuikit.tuichat.hilo.bean.game;

import com.qiahao.nextvideo.sheep.GameMatchActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003JJ\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017¨\u0006&"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/game/RoomMatchGame;", "", "gameType", "", GameMatchActivity.GAME_ID, "matchId", "gameIcon", "", "msg", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getGameType", "()Ljava/lang/Integer;", "setGameType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getGameId", "setGameId", "getMatchId", "setMatchId", "getGameIcon", "()Ljava/lang/String;", "setGameIcon", "(Ljava/lang/String;)V", "getMsg", "setMsg", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/game/RoomMatchGame;", "equals", "", "other", "hashCode", "toString", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* data */ class RoomMatchGame {

    @Nullable
    private String gameIcon;

    @Nullable
    private Integer gameId;

    @Nullable
    private Integer gameType;

    @Nullable
    private Integer matchId;

    @Nullable
    private String msg;

    public RoomMatchGame() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ RoomMatchGame copy$default(RoomMatchGame roomMatchGame, Integer num, Integer num2, Integer num3, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = roomMatchGame.gameType;
        }
        if ((i & 2) != 0) {
            num2 = roomMatchGame.gameId;
        }
        Integer num4 = num2;
        if ((i & 4) != 0) {
            num3 = roomMatchGame.matchId;
        }
        Integer num5 = num3;
        if ((i & 8) != 0) {
            str = roomMatchGame.gameIcon;
        }
        String str3 = str;
        if ((i & 16) != 0) {
            str2 = roomMatchGame.msg;
        }
        return roomMatchGame.copy(num, num4, num5, str3, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getGameType() {
        return this.gameType;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getGameId() {
        return this.gameId;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getMatchId() {
        return this.matchId;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getGameIcon() {
        return this.gameIcon;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    @NotNull
    public final RoomMatchGame copy(@Nullable Integer gameType, @Nullable Integer gameId, @Nullable Integer matchId, @Nullable String gameIcon, @Nullable String msg) {
        return new RoomMatchGame(gameType, gameId, matchId, gameIcon, msg);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomMatchGame)) {
            return false;
        }
        RoomMatchGame roomMatchGame = (RoomMatchGame) other;
        return Intrinsics.areEqual(this.gameType, roomMatchGame.gameType) && Intrinsics.areEqual(this.gameId, roomMatchGame.gameId) && Intrinsics.areEqual(this.matchId, roomMatchGame.matchId) && Intrinsics.areEqual(this.gameIcon, roomMatchGame.gameIcon) && Intrinsics.areEqual(this.msg, roomMatchGame.msg);
    }

    @Nullable
    public final String getGameIcon() {
        return this.gameIcon;
    }

    @Nullable
    public final Integer getGameId() {
        return this.gameId;
    }

    @Nullable
    public final Integer getGameType() {
        return this.gameType;
    }

    @Nullable
    public final Integer getMatchId() {
        return this.matchId;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        Integer num = this.gameType;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.gameId;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.matchId;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str = this.gameIcon;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.msg;
        return hashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setGameIcon(@Nullable String str) {
        this.gameIcon = str;
    }

    public final void setGameId(@Nullable Integer num) {
        this.gameId = num;
    }

    public final void setGameType(@Nullable Integer num) {
        this.gameType = num;
    }

    public final void setMatchId(@Nullable Integer num) {
        this.matchId = num;
    }

    public final void setMsg(@Nullable String str) {
        this.msg = str;
    }

    @NotNull
    public String toString() {
        return "RoomMatchGame(gameType=" + this.gameType + ", gameId=" + this.gameId + ", matchId=" + this.matchId + ", gameIcon=" + this.gameIcon + ", msg=" + this.msg + ")";
    }

    public RoomMatchGame(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str, @Nullable String str2) {
        this.gameType = num;
        this.gameId = num2;
        this.matchId = num3;
        this.gameIcon = str;
        this.msg = str2;
    }

    public /* synthetic */ RoomMatchGame(Integer num, Integer num2, Integer num3, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2);
    }
}
