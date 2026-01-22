package com.tencent.qcloud.tuikit.tuichat.hilo.bean.game;

import com.qiahao.nextvideo.sheep.GameMatchActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/game/GameData;", "", GameMatchActivity.GAME_ID, "", "title", "", "iconRes", "<init>", "(ILjava/lang/String;I)V", "getGameId", "()I", "setGameId", "(I)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getIconRes", "setIconRes", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* data */ class GameData {
    private int gameId;
    private int iconRes;

    @Nullable
    private String title;

    public GameData() {
        this(0, null, 0, 7, null);
    }

    public static /* synthetic */ GameData copy$default(GameData gameData, int i, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = gameData.gameId;
        }
        if ((i3 & 2) != 0) {
            str = gameData.title;
        }
        if ((i3 & 4) != 0) {
            i2 = gameData.iconRes;
        }
        return gameData.copy(i, str, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getGameId() {
        return this.gameId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final int getIconRes() {
        return this.iconRes;
    }

    @NotNull
    public final GameData copy(int gameId, @Nullable String title, int iconRes) {
        return new GameData(gameId, title, iconRes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameData)) {
            return false;
        }
        GameData gameData = (GameData) other;
        return this.gameId == gameData.gameId && Intrinsics.areEqual(this.title, gameData.title) && this.iconRes == gameData.iconRes;
    }

    public final int getGameId() {
        return this.gameId;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i = this.gameId * 31;
        String str = this.title;
        return ((i + (str == null ? 0 : str.hashCode())) * 31) + this.iconRes;
    }

    public final void setGameId(int i) {
        this.gameId = i;
    }

    public final void setIconRes(int i) {
        this.iconRes = i;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    @NotNull
    public String toString() {
        return "GameData(gameId=" + this.gameId + ", title=" + this.title + ", iconRes=" + this.iconRes + ")";
    }

    public GameData(int i, @Nullable String str, int i2) {
        this.gameId = i;
        this.title = str;
        this.iconRes = i2;
    }

    public /* synthetic */ GameData(int i, String str, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1 : i, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? 0 : i2);
    }
}
