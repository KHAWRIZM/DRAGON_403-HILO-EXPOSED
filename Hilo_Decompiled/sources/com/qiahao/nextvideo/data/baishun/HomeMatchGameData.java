package com.qiahao.nextvideo.data.baishun;

import com.qiahao.nextvideo.data.model.GameConfiguration;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u001d\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J8\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0002\u0010\n\"\u0004\b\u000b\u0010\fR.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/data/baishun/HomeMatchGameData;", "", "isOk", "", "list", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/Boolean;Ljava/util/ArrayList;)V", "()Ljava/lang/Boolean;", "setOk", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/util/ArrayList;)Lcom/qiahao/nextvideo/data/baishun/HomeMatchGameData;", "equals", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class HomeMatchGameData {

    @Nullable
    private Boolean isOk;

    @Nullable
    private ArrayList<GameConfiguration> list;

    /* JADX WARN: Multi-variable type inference failed */
    public HomeMatchGameData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HomeMatchGameData copy$default(HomeMatchGameData homeMatchGameData, Boolean bool, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = homeMatchGameData.isOk;
        }
        if ((i & 2) != 0) {
            arrayList = homeMatchGameData.list;
        }
        return homeMatchGameData.copy(bool, arrayList);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Boolean getIsOk() {
        return this.isOk;
    }

    @Nullable
    public final ArrayList<GameConfiguration> component2() {
        return this.list;
    }

    @NotNull
    public final HomeMatchGameData copy(@Nullable Boolean isOk, @Nullable ArrayList<GameConfiguration> list) {
        return new HomeMatchGameData(isOk, list);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeMatchGameData)) {
            return false;
        }
        HomeMatchGameData homeMatchGameData = (HomeMatchGameData) other;
        return Intrinsics.areEqual(this.isOk, homeMatchGameData.isOk) && Intrinsics.areEqual(this.list, homeMatchGameData.list);
    }

    @Nullable
    public final ArrayList<GameConfiguration> getList() {
        return this.list;
    }

    public int hashCode() {
        Boolean bool = this.isOk;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        ArrayList<GameConfiguration> arrayList = this.list;
        return hashCode + (arrayList != null ? arrayList.hashCode() : 0);
    }

    @Nullable
    public final Boolean isOk() {
        return this.isOk;
    }

    public final void setList(@Nullable ArrayList<GameConfiguration> arrayList) {
        this.list = arrayList;
    }

    public final void setOk(@Nullable Boolean bool) {
        this.isOk = bool;
    }

    @NotNull
    public String toString() {
        return "HomeMatchGameData(isOk=" + this.isOk + ", list=" + this.list + ")";
    }

    public HomeMatchGameData(@Nullable Boolean bool, @Nullable ArrayList<GameConfiguration> arrayList) {
        this.isOk = bool;
        this.list = arrayList;
    }

    public /* synthetic */ HomeMatchGameData(Boolean bool, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Boolean.FALSE : bool, (i & 2) != 0 ? null : arrayList);
    }
}
