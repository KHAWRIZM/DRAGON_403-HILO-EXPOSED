package com.qiahao.nextvideo.data.firstCharge;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J'\u0010\f\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/data/firstCharge/FirstChargeDataList;", "", "list", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/firstCharge/FirstChargeData;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getList", "()Ljava/util/ArrayList;", "setList", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class FirstChargeDataList {

    @Nullable
    private ArrayList<FirstChargeData> list;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FirstChargeDataList() {
        this(r0, 1, r0);
        ArrayList arrayList = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FirstChargeDataList copy$default(FirstChargeDataList firstChargeDataList, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = firstChargeDataList.list;
        }
        return firstChargeDataList.copy(arrayList);
    }

    @Nullable
    public final ArrayList<FirstChargeData> component1() {
        return this.list;
    }

    @NotNull
    public final FirstChargeDataList copy(@Nullable ArrayList<FirstChargeData> list) {
        return new FirstChargeDataList(list);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FirstChargeDataList) && Intrinsics.areEqual(this.list, ((FirstChargeDataList) other).list);
    }

    @Nullable
    public final ArrayList<FirstChargeData> getList() {
        return this.list;
    }

    public int hashCode() {
        ArrayList<FirstChargeData> arrayList = this.list;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.hashCode();
    }

    public final void setList(@Nullable ArrayList<FirstChargeData> arrayList) {
        this.list = arrayList;
    }

    @NotNull
    public String toString() {
        return "FirstChargeDataList(list=" + this.list + ")";
    }

    public FirstChargeDataList(@Nullable ArrayList<FirstChargeData> arrayList) {
        this.list = arrayList;
    }

    public /* synthetic */ FirstChargeDataList(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : arrayList);
    }
}
