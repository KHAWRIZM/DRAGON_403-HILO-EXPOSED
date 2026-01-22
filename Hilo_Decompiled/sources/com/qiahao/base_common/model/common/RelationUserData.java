package com.qiahao.base_common.model.common;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u001d\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J8\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0003J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lcom/qiahao/base_common/model/common/RelationUserData;", "Landroid/os/Parcelable;", "maxNum", "", "specialList", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/common/Special;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/Integer;Ljava/util/ArrayList;)V", "getMaxNum", "()Ljava/lang/Integer;", "setMaxNum", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSpecialList", "()Ljava/util/ArrayList;", "setSpecialList", "(Ljava/util/ArrayList;)V", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/util/ArrayList;)Lcom/qiahao/base_common/model/common/RelationUserData;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class RelationUserData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<RelationUserData> CREATOR = new Creator();

    @Nullable
    private Integer maxNum;

    @Nullable
    private ArrayList<Special> specialList;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<RelationUserData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RelationUserData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            ArrayList arrayList = null;
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList2.add(Special.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new RelationUserData(valueOf, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RelationUserData[] newArray(int i10) {
            return new RelationUserData[i10];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RelationUserData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RelationUserData copy$default(RelationUserData relationUserData, Integer num, ArrayList arrayList, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = relationUserData.maxNum;
        }
        if ((i10 & 2) != 0) {
            arrayList = relationUserData.specialList;
        }
        return relationUserData.copy(num, arrayList);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getMaxNum() {
        return this.maxNum;
    }

    @Nullable
    public final ArrayList<Special> component2() {
        return this.specialList;
    }

    @NotNull
    public final RelationUserData copy(@Nullable Integer maxNum, @Nullable ArrayList<Special> specialList) {
        return new RelationUserData(maxNum, specialList);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RelationUserData)) {
            return false;
        }
        RelationUserData relationUserData = (RelationUserData) other;
        return Intrinsics.areEqual(this.maxNum, relationUserData.maxNum) && Intrinsics.areEqual(this.specialList, relationUserData.specialList);
    }

    @Nullable
    public final Integer getMaxNum() {
        return this.maxNum;
    }

    @Nullable
    public final ArrayList<Special> getSpecialList() {
        return this.specialList;
    }

    public int hashCode() {
        Integer num = this.maxNum;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        ArrayList<Special> arrayList = this.specialList;
        return hashCode + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final void setMaxNum(@Nullable Integer num) {
        this.maxNum = num;
    }

    public final void setSpecialList(@Nullable ArrayList<Special> arrayList) {
        this.specialList = arrayList;
    }

    @NotNull
    public String toString() {
        return "RelationUserData(maxNum=" + this.maxNum + ", specialList=" + this.specialList + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Integer num = this.maxNum;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        ArrayList<Special> arrayList = this.specialList;
        if (arrayList == null) {
            dest.writeInt(0);
            return;
        }
        dest.writeInt(1);
        dest.writeInt(arrayList.size());
        Iterator<Special> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
    }

    public RelationUserData(@Nullable Integer num, @Nullable ArrayList<Special> arrayList) {
        this.maxNum = num;
        this.specialList = arrayList;
    }

    public /* synthetic */ RelationUserData(Integer num, ArrayList arrayList, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : arrayList);
    }
}
