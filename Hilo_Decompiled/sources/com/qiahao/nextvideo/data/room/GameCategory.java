package com.qiahao.nextvideo.data.room;

import com.qiahao.nextvideo.data.model.GameConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J8\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/qiahao/nextvideo/data/room/GameCategory;", "", "category", "", "gameList", "", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "title", "", "<init>", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/Integer;", "setCategory", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getGameList", "()Ljava/util/List;", "setGameList", "(Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/room/GameCategory;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GameCategory {

    @Nullable
    private Integer category;

    @Nullable
    private List<GameConfiguration> gameList;

    @Nullable
    private String title;

    public GameCategory() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GameCategory copy$default(GameCategory gameCategory, Integer num, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = gameCategory.category;
        }
        if ((i & 2) != 0) {
            list = gameCategory.gameList;
        }
        if ((i & 4) != 0) {
            str = gameCategory.title;
        }
        return gameCategory.copy(num, list, str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getCategory() {
        return this.category;
    }

    @Nullable
    public final List<GameConfiguration> component2() {
        return this.gameList;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final GameCategory copy(@Nullable Integer category, @Nullable List<GameConfiguration> gameList, @Nullable String title) {
        return new GameCategory(category, gameList, title);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameCategory)) {
            return false;
        }
        GameCategory gameCategory = (GameCategory) other;
        return Intrinsics.areEqual(this.category, gameCategory.category) && Intrinsics.areEqual(this.gameList, gameCategory.gameList) && Intrinsics.areEqual(this.title, gameCategory.title);
    }

    @Nullable
    public final Integer getCategory() {
        return this.category;
    }

    @Nullable
    public final List<GameConfiguration> getGameList() {
        return this.gameList;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        Integer num = this.category;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        List<GameConfiguration> list = this.gameList;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.title;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final void setCategory(@Nullable Integer num) {
        this.category = num;
    }

    public final void setGameList(@Nullable List<GameConfiguration> list) {
        this.gameList = list;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    @NotNull
    public String toString() {
        return "GameCategory(category=" + this.category + ", gameList=" + this.gameList + ", title=" + this.title + ")";
    }

    public GameCategory(@Nullable Integer num, @Nullable List<GameConfiguration> list, @Nullable String str) {
        this.category = num;
        this.gameList = list;
        this.title = str;
    }

    public /* synthetic */ GameCategory(Integer num, List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str);
    }
}
