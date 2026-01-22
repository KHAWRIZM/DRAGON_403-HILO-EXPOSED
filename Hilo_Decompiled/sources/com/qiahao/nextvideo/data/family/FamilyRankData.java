package com.qiahao.nextvideo.data.family;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lcom/qiahao/nextvideo/data/family/FamilyRankData;", "Landroid/os/Parcelable;", "items", "", "Lcom/qiahao/nextvideo/data/family/FamilyRankItem;", "myGroupPower", "Lcom/qiahao/base_common/model/common/FamilyInfo;", "<init>", "(Ljava/util/List;Lcom/qiahao/base_common/model/common/FamilyInfo;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getMyGroupPower", "()Lcom/qiahao/base_common/model/common/FamilyInfo;", "setMyGroupPower", "(Lcom/qiahao/base_common/model/common/FamilyInfo;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class FamilyRankData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<FamilyRankData> CREATOR = new Creator();

    @Nullable
    private List<FamilyRankItem> items;

    @Nullable
    private FamilyInfo myGroupPower;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<FamilyRankData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyRankData createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList2.add(FamilyRankItem.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new FamilyRankData(arrayList, parcel.readParcelable(FamilyRankData.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyRankData[] newArray(int i) {
            return new FamilyRankData[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FamilyRankData() {
        this(r0, r0, 3, r0);
        List list = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FamilyRankData copy$default(FamilyRankData familyRankData, List list, FamilyInfo familyInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            list = familyRankData.items;
        }
        if ((i & 2) != 0) {
            familyInfo = familyRankData.myGroupPower;
        }
        return familyRankData.copy(list, familyInfo);
    }

    @Nullable
    public final List<FamilyRankItem> component1() {
        return this.items;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final FamilyInfo getMyGroupPower() {
        return this.myGroupPower;
    }

    @NotNull
    public final FamilyRankData copy(@Nullable List<FamilyRankItem> items, @Nullable FamilyInfo myGroupPower) {
        return new FamilyRankData(items, myGroupPower);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FamilyRankData)) {
            return false;
        }
        FamilyRankData familyRankData = (FamilyRankData) other;
        return Intrinsics.areEqual(this.items, familyRankData.items) && Intrinsics.areEqual(this.myGroupPower, familyRankData.myGroupPower);
    }

    @Nullable
    public final List<FamilyRankItem> getItems() {
        return this.items;
    }

    @Nullable
    public final FamilyInfo getMyGroupPower() {
        return this.myGroupPower;
    }

    public int hashCode() {
        List<FamilyRankItem> list = this.items;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        FamilyInfo familyInfo = this.myGroupPower;
        return hashCode + (familyInfo != null ? familyInfo.hashCode() : 0);
    }

    public final void setItems(@Nullable List<FamilyRankItem> list) {
        this.items = list;
    }

    public final void setMyGroupPower(@Nullable FamilyInfo familyInfo) {
        this.myGroupPower = familyInfo;
    }

    @NotNull
    public String toString() {
        return "FamilyRankData(items=" + this.items + ", myGroupPower=" + this.myGroupPower + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        List<FamilyRankItem> list = this.items;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<FamilyRankItem> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        dest.writeParcelable(this.myGroupPower, flags);
    }

    public FamilyRankData(@Nullable List<FamilyRankItem> list, @Nullable FamilyInfo familyInfo) {
        this.items = list;
        this.myGroupPower = familyInfo;
    }

    public /* synthetic */ FamilyRankData(List list, FamilyInfo familyInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : familyInfo);
    }
}
