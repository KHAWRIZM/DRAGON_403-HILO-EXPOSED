package com.qiahao.nextvideo.data.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GemGameData;", "", "h5Icon", "", "h5Url", "games", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getH5Icon", "()Ljava/lang/String;", "setH5Icon", "(Ljava/lang/String;)V", "getH5Url", "setH5Url", "getGames", "()Ljava/util/ArrayList;", "setGames", "(Ljava/util/ArrayList;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GemGameData {

    @Nullable
    private ArrayList<GameConfiguration> games;

    @Nullable
    private String h5Icon;

    @Nullable
    private String h5Url;

    public GemGameData() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GemGameData copy$default(GemGameData gemGameData, String str, String str2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gemGameData.h5Icon;
        }
        if ((i & 2) != 0) {
            str2 = gemGameData.h5Url;
        }
        if ((i & 4) != 0) {
            arrayList = gemGameData.games;
        }
        return gemGameData.copy(str, str2, arrayList);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getH5Icon() {
        return this.h5Icon;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getH5Url() {
        return this.h5Url;
    }

    @Nullable
    public final ArrayList<GameConfiguration> component3() {
        return this.games;
    }

    @NotNull
    public final GemGameData copy(@Nullable String h5Icon, @Nullable String h5Url, @Nullable ArrayList<GameConfiguration> games) {
        return new GemGameData(h5Icon, h5Url, games);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GemGameData)) {
            return false;
        }
        GemGameData gemGameData = (GemGameData) other;
        return Intrinsics.areEqual(this.h5Icon, gemGameData.h5Icon) && Intrinsics.areEqual(this.h5Url, gemGameData.h5Url) && Intrinsics.areEqual(this.games, gemGameData.games);
    }

    @Nullable
    public final ArrayList<GameConfiguration> getGames() {
        return this.games;
    }

    @Nullable
    public final String getH5Icon() {
        return this.h5Icon;
    }

    @Nullable
    public final String getH5Url() {
        return this.h5Url;
    }

    public int hashCode() {
        String str = this.h5Icon;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.h5Url;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ArrayList<GameConfiguration> arrayList = this.games;
        return hashCode2 + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final void setGames(@Nullable ArrayList<GameConfiguration> arrayList) {
        this.games = arrayList;
    }

    public final void setH5Icon(@Nullable String str) {
        this.h5Icon = str;
    }

    public final void setH5Url(@Nullable String str) {
        this.h5Url = str;
    }

    @NotNull
    public String toString() {
        return "GemGameData(h5Icon=" + this.h5Icon + ", h5Url=" + this.h5Url + ", games=" + this.games + ")";
    }

    public GemGameData(@Nullable String str, @Nullable String str2, @Nullable ArrayList<GameConfiguration> arrayList) {
        this.h5Icon = str;
        this.h5Url = str2;
        this.games = arrayList;
    }

    public /* synthetic */ GemGameData(String str, String str2, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : arrayList);
    }
}
