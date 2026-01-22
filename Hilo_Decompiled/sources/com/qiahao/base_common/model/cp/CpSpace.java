package com.qiahao.base_common.model.cp;

import android.os.Parcel;
import android.os.Parcelable;
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
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010!\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007HÆ\u0003J_\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007HÆ\u0001J\u0006\u0010%\u001a\u00020&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020&HÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020&R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0006\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001a¨\u00063"}, d2 = {"Lcom/qiahao/base_common/model/cp/CpSpace;", "Landroid/os/Parcelable;", "cpInfo", "Lcom/qiahao/base_common/model/cp/CpInfo;", "cpLevel", "Lcom/qiahao/base_common/model/cp/CpLevel;", "privilegeList", "", "Lcom/qiahao/base_common/model/cp/CpPrivilege;", "resLevelList", "Lcom/qiahao/base_common/model/cp/CpResLevel;", "cpAnniversary", "Lcom/qiahao/base_common/model/cp/CpMemorial;", "<init>", "(Lcom/qiahao/base_common/model/cp/CpInfo;Lcom/qiahao/base_common/model/cp/CpLevel;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getCpInfo", "()Lcom/qiahao/base_common/model/cp/CpInfo;", "setCpInfo", "(Lcom/qiahao/base_common/model/cp/CpInfo;)V", "getCpLevel", "()Lcom/qiahao/base_common/model/cp/CpLevel;", "setCpLevel", "(Lcom/qiahao/base_common/model/cp/CpLevel;)V", "getPrivilegeList", "()Ljava/util/List;", "setPrivilegeList", "(Ljava/util/List;)V", "getResLevelList", "setResLevelList", "getCpAnniversary", "setCpAnniversary", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class CpSpace implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<CpSpace> CREATOR = new Creator();

    @Nullable
    private List<CpMemorial> cpAnniversary;

    @Nullable
    private CpInfo cpInfo;

    @Nullable
    private CpLevel cpLevel;

    @Nullable
    private List<? extends List<CpPrivilege>> privilegeList;

    @Nullable
    private List<CpResLevel> resLevelList;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<CpSpace> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CpSpace createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            ArrayList arrayList3;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            ArrayList arrayList4 = null;
            CpInfo createFromParcel = parcel.readInt() == 0 ? null : CpInfo.CREATOR.createFromParcel(parcel);
            CpLevel createFromParcel2 = parcel.readInt() == 0 ? null : CpLevel.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    if (parcel.readInt() == 0) {
                        arrayList2 = null;
                    } else {
                        int readInt2 = parcel.readInt();
                        arrayList2 = new ArrayList(readInt2);
                        for (int i11 = 0; i11 != readInt2; i11++) {
                            arrayList2.add(CpPrivilege.CREATOR.createFromParcel(parcel));
                        }
                    }
                    arrayList.add(arrayList2);
                }
            }
            if (parcel.readInt() == 0) {
                arrayList3 = null;
            } else {
                int readInt3 = parcel.readInt();
                arrayList3 = new ArrayList(readInt3);
                for (int i12 = 0; i12 != readInt3; i12++) {
                    arrayList3.add(CpResLevel.CREATOR.createFromParcel(parcel));
                }
            }
            if (parcel.readInt() != 0) {
                int readInt4 = parcel.readInt();
                arrayList4 = new ArrayList(readInt4);
                for (int i13 = 0; i13 != readInt4; i13++) {
                    arrayList4.add(CpMemorial.CREATOR.createFromParcel(parcel));
                }
            }
            return new CpSpace(createFromParcel, createFromParcel2, arrayList, arrayList3, arrayList4);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CpSpace[] newArray(int i10) {
            return new CpSpace[i10];
        }
    }

    public CpSpace() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ CpSpace copy$default(CpSpace cpSpace, CpInfo cpInfo, CpLevel cpLevel, List list, List list2, List list3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cpInfo = cpSpace.cpInfo;
        }
        if ((i10 & 2) != 0) {
            cpLevel = cpSpace.cpLevel;
        }
        CpLevel cpLevel2 = cpLevel;
        if ((i10 & 4) != 0) {
            list = cpSpace.privilegeList;
        }
        List list4 = list;
        if ((i10 & 8) != 0) {
            list2 = cpSpace.resLevelList;
        }
        List list5 = list2;
        if ((i10 & 16) != 0) {
            list3 = cpSpace.cpAnniversary;
        }
        return cpSpace.copy(cpInfo, cpLevel2, list4, list5, list3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final CpInfo getCpInfo() {
        return this.cpInfo;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final CpLevel getCpLevel() {
        return this.cpLevel;
    }

    @Nullable
    public final List<List<CpPrivilege>> component3() {
        return this.privilegeList;
    }

    @Nullable
    public final List<CpResLevel> component4() {
        return this.resLevelList;
    }

    @Nullable
    public final List<CpMemorial> component5() {
        return this.cpAnniversary;
    }

    @NotNull
    public final CpSpace copy(@Nullable CpInfo cpInfo, @Nullable CpLevel cpLevel, @Nullable List<? extends List<CpPrivilege>> privilegeList, @Nullable List<CpResLevel> resLevelList, @Nullable List<CpMemorial> cpAnniversary) {
        return new CpSpace(cpInfo, cpLevel, privilegeList, resLevelList, cpAnniversary);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CpSpace)) {
            return false;
        }
        CpSpace cpSpace = (CpSpace) other;
        return Intrinsics.areEqual(this.cpInfo, cpSpace.cpInfo) && Intrinsics.areEqual(this.cpLevel, cpSpace.cpLevel) && Intrinsics.areEqual(this.privilegeList, cpSpace.privilegeList) && Intrinsics.areEqual(this.resLevelList, cpSpace.resLevelList) && Intrinsics.areEqual(this.cpAnniversary, cpSpace.cpAnniversary);
    }

    @Nullable
    public final List<CpMemorial> getCpAnniversary() {
        return this.cpAnniversary;
    }

    @Nullable
    public final CpInfo getCpInfo() {
        return this.cpInfo;
    }

    @Nullable
    public final CpLevel getCpLevel() {
        return this.cpLevel;
    }

    @Nullable
    public final List<List<CpPrivilege>> getPrivilegeList() {
        return this.privilegeList;
    }

    @Nullable
    public final List<CpResLevel> getResLevelList() {
        return this.resLevelList;
    }

    public int hashCode() {
        CpInfo cpInfo = this.cpInfo;
        int hashCode = (cpInfo == null ? 0 : cpInfo.hashCode()) * 31;
        CpLevel cpLevel = this.cpLevel;
        int hashCode2 = (hashCode + (cpLevel == null ? 0 : cpLevel.hashCode())) * 31;
        List<? extends List<CpPrivilege>> list = this.privilegeList;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<CpResLevel> list2 = this.resLevelList;
        int hashCode4 = (hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<CpMemorial> list3 = this.cpAnniversary;
        return hashCode4 + (list3 != null ? list3.hashCode() : 0);
    }

    public final void setCpAnniversary(@Nullable List<CpMemorial> list) {
        this.cpAnniversary = list;
    }

    public final void setCpInfo(@Nullable CpInfo cpInfo) {
        this.cpInfo = cpInfo;
    }

    public final void setCpLevel(@Nullable CpLevel cpLevel) {
        this.cpLevel = cpLevel;
    }

    public final void setPrivilegeList(@Nullable List<? extends List<CpPrivilege>> list) {
        this.privilegeList = list;
    }

    public final void setResLevelList(@Nullable List<CpResLevel> list) {
        this.resLevelList = list;
    }

    @NotNull
    public String toString() {
        return "CpSpace(cpInfo=" + this.cpInfo + ", cpLevel=" + this.cpLevel + ", privilegeList=" + this.privilegeList + ", resLevelList=" + this.resLevelList + ", cpAnniversary=" + this.cpAnniversary + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        CpInfo cpInfo = this.cpInfo;
        if (cpInfo == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            cpInfo.writeToParcel(dest, flags);
        }
        CpLevel cpLevel = this.cpLevel;
        if (cpLevel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            cpLevel.writeToParcel(dest, flags);
        }
        List<? extends List<CpPrivilege>> list = this.privilegeList;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            for (List<CpPrivilege> list2 : list) {
                if (list2 == null) {
                    dest.writeInt(0);
                } else {
                    dest.writeInt(1);
                    dest.writeInt(list2.size());
                    Iterator<CpPrivilege> it = list2.iterator();
                    while (it.hasNext()) {
                        it.next().writeToParcel(dest, flags);
                    }
                }
            }
        }
        List<CpResLevel> list3 = this.resLevelList;
        if (list3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list3.size());
            Iterator<CpResLevel> it2 = list3.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(dest, flags);
            }
        }
        List<CpMemorial> list4 = this.cpAnniversary;
        if (list4 == null) {
            dest.writeInt(0);
            return;
        }
        dest.writeInt(1);
        dest.writeInt(list4.size());
        Iterator<CpMemorial> it3 = list4.iterator();
        while (it3.hasNext()) {
            it3.next().writeToParcel(dest, flags);
        }
    }

    public CpSpace(@Nullable CpInfo cpInfo, @Nullable CpLevel cpLevel, @Nullable List<? extends List<CpPrivilege>> list, @Nullable List<CpResLevel> list2, @Nullable List<CpMemorial> list3) {
        this.cpInfo = cpInfo;
        this.cpLevel = cpLevel;
        this.privilegeList = list;
        this.resLevelList = list2;
        this.cpAnniversary = list3;
    }

    public /* synthetic */ CpSpace(CpInfo cpInfo, CpLevel cpLevel, List list, List list2, List list3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : cpInfo, (i10 & 2) != 0 ? null : cpLevel, (i10 & 4) != 0 ? null : list, (i10 & 8) != 0 ? null : list2, (i10 & 16) != 0 ? null : list3);
    }
}
