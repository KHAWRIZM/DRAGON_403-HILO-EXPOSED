package com.qiahao.nextvideo.data.game;

import com.qiahao.nextvideo.data.model.GameConfiguration;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB1\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0012\u001a\u00020\u0013J\u001d\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/data/game/GameLobby;", "", "gameList", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "Lkotlin/collections/ArrayList;", "tab", "", "<init>", "(Ljava/util/ArrayList;Ljava/lang/String;)V", "getGameList", "()Ljava/util/ArrayList;", "setGameList", "(Ljava/util/ArrayList;)V", "getTab", "()Ljava/lang/String;", "setTab", "(Ljava/lang/String;)V", "checkGameTab", "", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GameLobby {

    @NotNull
    public static final String TAB_DOMINO = "domino";

    @NotNull
    public static final String TAB_LUDO = "ludo";

    @NotNull
    public static final String TAB_OTHER = "other";

    @NotNull
    public static final String TAB_UNO = "uno";

    @Nullable
    private ArrayList<GameConfiguration> gameList;

    @Nullable
    private String tab;

    /* JADX WARN: Multi-variable type inference failed */
    public GameLobby() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GameLobby copy$default(GameLobby gameLobby, ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = gameLobby.gameList;
        }
        if ((i & 2) != 0) {
            str = gameLobby.tab;
        }
        return gameLobby.copy(arrayList, str);
    }

    public final boolean checkGameTab() {
        if (!Intrinsics.areEqual(this.tab, TAB_LUDO) && !Intrinsics.areEqual(this.tab, TAB_UNO) && !Intrinsics.areEqual(this.tab, TAB_DOMINO) && !Intrinsics.areEqual(this.tab, "other")) {
            return false;
        }
        return true;
    }

    @Nullable
    public final ArrayList<GameConfiguration> component1() {
        return this.gameList;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getTab() {
        return this.tab;
    }

    @NotNull
    public final GameLobby copy(@Nullable ArrayList<GameConfiguration> gameList, @Nullable String tab) {
        return new GameLobby(gameList, tab);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameLobby)) {
            return false;
        }
        GameLobby gameLobby = (GameLobby) other;
        return Intrinsics.areEqual(this.gameList, gameLobby.gameList) && Intrinsics.areEqual(this.tab, gameLobby.tab);
    }

    @Nullable
    public final ArrayList<GameConfiguration> getGameList() {
        return this.gameList;
    }

    @Nullable
    public final String getTab() {
        return this.tab;
    }

    public int hashCode() {
        ArrayList<GameConfiguration> arrayList = this.gameList;
        int hashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        String str = this.tab;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final void setGameList(@Nullable ArrayList<GameConfiguration> arrayList) {
        this.gameList = arrayList;
    }

    public final void setTab(@Nullable String str) {
        this.tab = str;
    }

    @NotNull
    public String toString() {
        return "GameLobby(gameList=" + this.gameList + ", tab=" + this.tab + ")";
    }

    public GameLobby(@Nullable ArrayList<GameConfiguration> arrayList, @Nullable String str) {
        this.gameList = arrayList;
        this.tab = str;
    }

    public /* synthetic */ GameLobby(ArrayList arrayList, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : arrayList, (i & 2) != 0 ? null : str);
    }
}
