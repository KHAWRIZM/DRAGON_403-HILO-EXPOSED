package com.qiahao.nextvideo.data.model;

import com.qiahao.nextvideo.sheep.GameMatchActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GameUrlConfig;", "", GameMatchActivity.GAME_ID, "", "gameUrl", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getGameId", "()Ljava/lang/Integer;", "setGameId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getGameUrl", "()Ljava/lang/String;", "setGameUrl", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/model/GameUrlConfig;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GameUrlConfig {

    @Nullable
    private Integer gameId;

    @Nullable
    private String gameUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public GameUrlConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ GameUrlConfig copy$default(GameUrlConfig gameUrlConfig, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = gameUrlConfig.gameId;
        }
        if ((i & 2) != 0) {
            str = gameUrlConfig.gameUrl;
        }
        return gameUrlConfig.copy(num, str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getGameId() {
        return this.gameId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getGameUrl() {
        return this.gameUrl;
    }

    @NotNull
    public final GameUrlConfig copy(@Nullable Integer gameId, @Nullable String gameUrl) {
        return new GameUrlConfig(gameId, gameUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameUrlConfig)) {
            return false;
        }
        GameUrlConfig gameUrlConfig = (GameUrlConfig) other;
        return Intrinsics.areEqual(this.gameId, gameUrlConfig.gameId) && Intrinsics.areEqual(this.gameUrl, gameUrlConfig.gameUrl);
    }

    @Nullable
    public final Integer getGameId() {
        return this.gameId;
    }

    @Nullable
    public final String getGameUrl() {
        return this.gameUrl;
    }

    public int hashCode() {
        Integer num = this.gameId;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.gameUrl;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final void setGameId(@Nullable Integer num) {
        this.gameId = num;
    }

    public final void setGameUrl(@Nullable String str) {
        this.gameUrl = str;
    }

    @NotNull
    public String toString() {
        return "GameUrlConfig(gameId=" + this.gameId + ", gameUrl=" + this.gameUrl + ")";
    }

    public GameUrlConfig(@Nullable Integer num, @Nullable String str) {
        this.gameId = num;
        this.gameUrl = str;
    }

    public /* synthetic */ GameUrlConfig(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str);
    }
}
