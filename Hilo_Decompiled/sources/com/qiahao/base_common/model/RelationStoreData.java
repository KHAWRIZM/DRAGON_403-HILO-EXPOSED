package com.qiahao.base_common.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u001d\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJD\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000e¨\u0006!"}, d2 = {"Lcom/qiahao/base_common/model/RelationStoreData;", "", "curNum", "", FirebaseAnalytics.Param.ITEMS, "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/StoreBean;", "Lkotlin/collections/ArrayList;", "maxNum", "<init>", "(Ljava/lang/Integer;Ljava/util/ArrayList;Ljava/lang/Integer;)V", "getCurNum", "()Ljava/lang/Integer;", "setCurNum", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "getMaxNum", "setMaxNum", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/util/ArrayList;Ljava/lang/Integer;)Lcom/qiahao/base_common/model/RelationStoreData;", "equals", "", "other", "hashCode", "toString", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class RelationStoreData {

    @Nullable
    private Integer curNum;

    @Nullable
    private ArrayList<StoreBean> items;

    @Nullable
    private Integer maxNum;

    public RelationStoreData() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RelationStoreData copy$default(RelationStoreData relationStoreData, Integer num, ArrayList arrayList, Integer num2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = relationStoreData.curNum;
        }
        if ((i10 & 2) != 0) {
            arrayList = relationStoreData.items;
        }
        if ((i10 & 4) != 0) {
            num2 = relationStoreData.maxNum;
        }
        return relationStoreData.copy(num, arrayList, num2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getCurNum() {
        return this.curNum;
    }

    @Nullable
    public final ArrayList<StoreBean> component2() {
        return this.items;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getMaxNum() {
        return this.maxNum;
    }

    @NotNull
    public final RelationStoreData copy(@Nullable Integer curNum, @Nullable ArrayList<StoreBean> items, @Nullable Integer maxNum) {
        return new RelationStoreData(curNum, items, maxNum);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RelationStoreData)) {
            return false;
        }
        RelationStoreData relationStoreData = (RelationStoreData) other;
        return Intrinsics.areEqual(this.curNum, relationStoreData.curNum) && Intrinsics.areEqual(this.items, relationStoreData.items) && Intrinsics.areEqual(this.maxNum, relationStoreData.maxNum);
    }

    @Nullable
    public final Integer getCurNum() {
        return this.curNum;
    }

    @Nullable
    public final ArrayList<StoreBean> getItems() {
        return this.items;
    }

    @Nullable
    public final Integer getMaxNum() {
        return this.maxNum;
    }

    public int hashCode() {
        Integer num = this.curNum;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        ArrayList<StoreBean> arrayList = this.items;
        int hashCode2 = (hashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        Integer num2 = this.maxNum;
        return hashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setCurNum(@Nullable Integer num) {
        this.curNum = num;
    }

    public final void setItems(@Nullable ArrayList<StoreBean> arrayList) {
        this.items = arrayList;
    }

    public final void setMaxNum(@Nullable Integer num) {
        this.maxNum = num;
    }

    @NotNull
    public String toString() {
        return "RelationStoreData(curNum=" + this.curNum + ", items=" + this.items + ", maxNum=" + this.maxNum + ")";
    }

    public RelationStoreData(@Nullable Integer num, @Nullable ArrayList<StoreBean> arrayList, @Nullable Integer num2) {
        this.curNum = num;
        this.items = arrayList;
        this.maxNum = num2;
    }

    public /* synthetic */ RelationStoreData(Integer num, ArrayList arrayList, Integer num2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : arrayList, (i10 & 4) != 0 ? null : num2);
    }
}
