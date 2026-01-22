package com.qiahao.nextvideo.data.family;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u001d\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003J]\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0006\u0010 \u001a\u00020!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020!HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020!R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R.\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006."}, d2 = {"Lcom/qiahao/nextvideo/data/family/FamilyCenterData;", "Landroid/os/Parcelable;", "info", "Lcom/qiahao/base_common/model/common/FamilyInfo;", "members", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/family/FamilyCenterMember;", "Lkotlin/collections/ArrayList;", "stars", "wheelDaily", "Lcom/qiahao/nextvideo/data/family/FamilyWheel;", "<init>", "(Lcom/qiahao/base_common/model/common/FamilyInfo;Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/qiahao/nextvideo/data/family/FamilyWheel;)V", "getInfo", "()Lcom/qiahao/base_common/model/common/FamilyInfo;", "setInfo", "(Lcom/qiahao/base_common/model/common/FamilyInfo;)V", "getMembers", "()Ljava/util/ArrayList;", "setMembers", "(Ljava/util/ArrayList;)V", "getStars", "setStars", "getWheelDaily", "()Lcom/qiahao/nextvideo/data/family/FamilyWheel;", "setWheelDaily", "(Lcom/qiahao/nextvideo/data/family/FamilyWheel;)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class FamilyCenterData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<FamilyCenterData> CREATOR = new Creator();

    @Nullable
    private FamilyInfo info;

    @Nullable
    private ArrayList<FamilyCenterMember> members;

    @Nullable
    private ArrayList<FamilyCenterMember> stars;

    @Nullable
    private FamilyWheel wheelDaily;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<FamilyCenterData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyCenterData createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            FamilyInfo readParcelable = parcel.readParcelable(FamilyCenterData.class.getClassLoader());
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(FamilyCenterMember.CREATOR.createFromParcel(parcel));
                }
            }
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int readInt2 = parcel.readInt();
                arrayList2 = new ArrayList(readInt2);
                for (int i2 = 0; i2 != readInt2; i2++) {
                    arrayList2.add(FamilyCenterMember.CREATOR.createFromParcel(parcel));
                }
            }
            return new FamilyCenterData(readParcelable, arrayList, arrayList2, parcel.readInt() != 0 ? FamilyWheel.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyCenterData[] newArray(int i) {
            return new FamilyCenterData[i];
        }
    }

    public FamilyCenterData() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FamilyCenterData copy$default(FamilyCenterData familyCenterData, FamilyInfo familyInfo, ArrayList arrayList, ArrayList arrayList2, FamilyWheel familyWheel, int i, Object obj) {
        if ((i & 1) != 0) {
            familyInfo = familyCenterData.info;
        }
        if ((i & 2) != 0) {
            arrayList = familyCenterData.members;
        }
        if ((i & 4) != 0) {
            arrayList2 = familyCenterData.stars;
        }
        if ((i & 8) != 0) {
            familyWheel = familyCenterData.wheelDaily;
        }
        return familyCenterData.copy(familyInfo, arrayList, arrayList2, familyWheel);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final FamilyInfo getInfo() {
        return this.info;
    }

    @Nullable
    public final ArrayList<FamilyCenterMember> component2() {
        return this.members;
    }

    @Nullable
    public final ArrayList<FamilyCenterMember> component3() {
        return this.stars;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final FamilyWheel getWheelDaily() {
        return this.wheelDaily;
    }

    @NotNull
    public final FamilyCenterData copy(@Nullable FamilyInfo info, @Nullable ArrayList<FamilyCenterMember> members, @Nullable ArrayList<FamilyCenterMember> stars, @Nullable FamilyWheel wheelDaily) {
        return new FamilyCenterData(info, members, stars, wheelDaily);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FamilyCenterData)) {
            return false;
        }
        FamilyCenterData familyCenterData = (FamilyCenterData) other;
        return Intrinsics.areEqual(this.info, familyCenterData.info) && Intrinsics.areEqual(this.members, familyCenterData.members) && Intrinsics.areEqual(this.stars, familyCenterData.stars) && Intrinsics.areEqual(this.wheelDaily, familyCenterData.wheelDaily);
    }

    @Nullable
    public final FamilyInfo getInfo() {
        return this.info;
    }

    @Nullable
    public final ArrayList<FamilyCenterMember> getMembers() {
        return this.members;
    }

    @Nullable
    public final ArrayList<FamilyCenterMember> getStars() {
        return this.stars;
    }

    @Nullable
    public final FamilyWheel getWheelDaily() {
        return this.wheelDaily;
    }

    public int hashCode() {
        FamilyInfo familyInfo = this.info;
        int hashCode = (familyInfo == null ? 0 : familyInfo.hashCode()) * 31;
        ArrayList<FamilyCenterMember> arrayList = this.members;
        int hashCode2 = (hashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<FamilyCenterMember> arrayList2 = this.stars;
        int hashCode3 = (hashCode2 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
        FamilyWheel familyWheel = this.wheelDaily;
        return hashCode3 + (familyWheel != null ? familyWheel.hashCode() : 0);
    }

    public final void setInfo(@Nullable FamilyInfo familyInfo) {
        this.info = familyInfo;
    }

    public final void setMembers(@Nullable ArrayList<FamilyCenterMember> arrayList) {
        this.members = arrayList;
    }

    public final void setStars(@Nullable ArrayList<FamilyCenterMember> arrayList) {
        this.stars = arrayList;
    }

    public final void setWheelDaily(@Nullable FamilyWheel familyWheel) {
        this.wheelDaily = familyWheel;
    }

    @NotNull
    public String toString() {
        return "FamilyCenterData(info=" + this.info + ", members=" + this.members + ", stars=" + this.stars + ", wheelDaily=" + this.wheelDaily + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeParcelable(this.info, flags);
        ArrayList<FamilyCenterMember> arrayList = this.members;
        if (arrayList == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(arrayList.size());
            Iterator<FamilyCenterMember> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        ArrayList<FamilyCenterMember> arrayList2 = this.stars;
        if (arrayList2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(arrayList2.size());
            Iterator<FamilyCenterMember> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(dest, flags);
            }
        }
        FamilyWheel familyWheel = this.wheelDaily;
        if (familyWheel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            familyWheel.writeToParcel(dest, flags);
        }
    }

    public FamilyCenterData(@Nullable FamilyInfo familyInfo, @Nullable ArrayList<FamilyCenterMember> arrayList, @Nullable ArrayList<FamilyCenterMember> arrayList2, @Nullable FamilyWheel familyWheel) {
        this.info = familyInfo;
        this.members = arrayList;
        this.stars = arrayList2;
        this.wheelDaily = familyWheel;
    }

    public /* synthetic */ FamilyCenterData(FamilyInfo familyInfo, ArrayList arrayList, ArrayList arrayList2, FamilyWheel familyWheel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : familyInfo, (i & 2) != 0 ? null : arrayList, (i & 4) != 0 ? null : arrayList2, (i & 8) != 0 ? null : familyWheel);
    }
}
