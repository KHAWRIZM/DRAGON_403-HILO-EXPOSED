package com.qiahao.nextvideo.data.game;

import com.qiahao.base_common.model.common.User;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/data/game/GemGameRank;", "", "h5Url", "", "rank", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/common/User;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getH5Url", "()Ljava/lang/String;", "setH5Url", "(Ljava/lang/String;)V", "getRank", "()Ljava/util/ArrayList;", "setRank", "(Ljava/util/ArrayList;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GemGameRank {

    @Nullable
    private String h5Url;

    @Nullable
    private ArrayList<User> rank;

    /* JADX WARN: Multi-variable type inference failed */
    public GemGameRank() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GemGameRank copy$default(GemGameRank gemGameRank, String str, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gemGameRank.h5Url;
        }
        if ((i & 2) != 0) {
            arrayList = gemGameRank.rank;
        }
        return gemGameRank.copy(str, arrayList);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getH5Url() {
        return this.h5Url;
    }

    @Nullable
    public final ArrayList<User> component2() {
        return this.rank;
    }

    @NotNull
    public final GemGameRank copy(@Nullable String h5Url, @Nullable ArrayList<User> rank) {
        return new GemGameRank(h5Url, rank);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GemGameRank)) {
            return false;
        }
        GemGameRank gemGameRank = (GemGameRank) other;
        return Intrinsics.areEqual(this.h5Url, gemGameRank.h5Url) && Intrinsics.areEqual(this.rank, gemGameRank.rank);
    }

    @Nullable
    public final String getH5Url() {
        return this.h5Url;
    }

    @Nullable
    public final ArrayList<User> getRank() {
        return this.rank;
    }

    public int hashCode() {
        String str = this.h5Url;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ArrayList<User> arrayList = this.rank;
        return hashCode + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final void setH5Url(@Nullable String str) {
        this.h5Url = str;
    }

    public final void setRank(@Nullable ArrayList<User> arrayList) {
        this.rank = arrayList;
    }

    @NotNull
    public String toString() {
        return "GemGameRank(h5Url=" + this.h5Url + ", rank=" + this.rank + ")";
    }

    public GemGameRank(@Nullable String str, @Nullable ArrayList<User> arrayList) {
        this.h5Url = str;
        this.rank = arrayList;
    }

    public /* synthetic */ GemGameRank(String str, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : arrayList);
    }
}
