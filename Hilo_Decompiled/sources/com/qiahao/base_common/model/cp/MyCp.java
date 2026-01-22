package com.qiahao.base_common.model.cp;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.base_common.model.common.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010%\u001a\u00020&J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010!JP\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010-J\u0006\u0010.\u001a\u00020\nJ\u0013\u0010/\u001a\u00020&2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\nHÖ\u0001J\t\u00103\u001a\u000204HÖ\u0001J\u0016\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006:"}, d2 = {"Lcom/qiahao/base_common/model/cp/MyCp;", "Landroid/os/Parcelable;", "cpUserInfo", "Lcom/qiahao/base_common/model/common/User;", "cpLevel", "Lcom/qiahao/base_common/model/cp/CpLevel;", "myPrivilegeList", "", "Lcom/qiahao/base_common/model/cp/CpPrivilege;", "cpDays", "", "createdUnix", "", "<init>", "(Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/cp/CpLevel;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Long;)V", "getCpUserInfo", "()Lcom/qiahao/base_common/model/common/User;", "setCpUserInfo", "(Lcom/qiahao/base_common/model/common/User;)V", "getCpLevel", "()Lcom/qiahao/base_common/model/cp/CpLevel;", "setCpLevel", "(Lcom/qiahao/base_common/model/cp/CpLevel;)V", "getMyPrivilegeList", "()Ljava/util/List;", "setMyPrivilegeList", "(Ljava/util/List;)V", "getCpDays", "()Ljava/lang/Integer;", "setCpDays", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCreatedUnix", "()Ljava/lang/Long;", "setCreatedUnix", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "isDynamicCard", "", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/cp/CpLevel;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/qiahao/base_common/model/cp/MyCp;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMyCp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyCp.kt\ncom/qiahao/base_common/model/cp/MyCp\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,27:1\n1869#2,2:28\n*S KotlinDebug\n*F\n+ 1 MyCp.kt\ncom/qiahao/base_common/model/cp/MyCp\n*L\n20#1:28,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class MyCp implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<MyCp> CREATOR = new Creator();

    @Nullable
    private Integer cpDays;

    @Nullable
    private CpLevel cpLevel;

    @Nullable
    private User cpUserInfo;

    @Nullable
    private Long createdUnix;

    @Nullable
    private List<CpPrivilege> myPrivilegeList;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<MyCp> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MyCp createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            User createFromParcel = parcel.readInt() == 0 ? null : User.CREATOR.createFromParcel(parcel);
            CpLevel createFromParcel2 = parcel.readInt() == 0 ? null : CpLevel.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList2.add(CpPrivilege.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new MyCp(createFromParcel, createFromParcel2, arrayList, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MyCp[] newArray(int i10) {
            return new MyCp[i10];
        }
    }

    public MyCp() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ MyCp copy$default(MyCp myCp, User user, CpLevel cpLevel, List list, Integer num, Long l10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = myCp.cpUserInfo;
        }
        if ((i10 & 2) != 0) {
            cpLevel = myCp.cpLevel;
        }
        CpLevel cpLevel2 = cpLevel;
        if ((i10 & 4) != 0) {
            list = myCp.myPrivilegeList;
        }
        List list2 = list;
        if ((i10 & 8) != 0) {
            num = myCp.cpDays;
        }
        Integer num2 = num;
        if ((i10 & 16) != 0) {
            l10 = myCp.createdUnix;
        }
        return myCp.copy(user, cpLevel2, list2, num2, l10);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final User getCpUserInfo() {
        return this.cpUserInfo;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final CpLevel getCpLevel() {
        return this.cpLevel;
    }

    @Nullable
    public final List<CpPrivilege> component3() {
        return this.myPrivilegeList;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getCpDays() {
        return this.cpDays;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Long getCreatedUnix() {
        return this.createdUnix;
    }

    @NotNull
    public final MyCp copy(@Nullable User cpUserInfo, @Nullable CpLevel cpLevel, @Nullable List<CpPrivilege> myPrivilegeList, @Nullable Integer cpDays, @Nullable Long createdUnix) {
        return new MyCp(cpUserInfo, cpLevel, myPrivilegeList, cpDays, createdUnix);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyCp)) {
            return false;
        }
        MyCp myCp = (MyCp) other;
        return Intrinsics.areEqual(this.cpUserInfo, myCp.cpUserInfo) && Intrinsics.areEqual(this.cpLevel, myCp.cpLevel) && Intrinsics.areEqual(this.myPrivilegeList, myCp.myPrivilegeList) && Intrinsics.areEqual(this.cpDays, myCp.cpDays) && Intrinsics.areEqual(this.createdUnix, myCp.createdUnix);
    }

    @Nullable
    public final Integer getCpDays() {
        return this.cpDays;
    }

    @Nullable
    public final CpLevel getCpLevel() {
        return this.cpLevel;
    }

    @Nullable
    public final User getCpUserInfo() {
        return this.cpUserInfo;
    }

    @Nullable
    public final Long getCreatedUnix() {
        return this.createdUnix;
    }

    @Nullable
    public final List<CpPrivilege> getMyPrivilegeList() {
        return this.myPrivilegeList;
    }

    public int hashCode() {
        User user = this.cpUserInfo;
        int hashCode = (user == null ? 0 : user.hashCode()) * 31;
        CpLevel cpLevel = this.cpLevel;
        int hashCode2 = (hashCode + (cpLevel == null ? 0 : cpLevel.hashCode())) * 31;
        List<CpPrivilege> list = this.myPrivilegeList;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num = this.cpDays;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Long l10 = this.createdUnix;
        return hashCode4 + (l10 != null ? l10.hashCode() : 0);
    }

    public final boolean isDynamicCard() {
        List<CpPrivilege> list = this.myPrivilegeList;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Integer type = ((CpPrivilege) it.next()).getType();
                if (type != null && type.intValue() == 7) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final void setCpDays(@Nullable Integer num) {
        this.cpDays = num;
    }

    public final void setCpLevel(@Nullable CpLevel cpLevel) {
        this.cpLevel = cpLevel;
    }

    public final void setCpUserInfo(@Nullable User user) {
        this.cpUserInfo = user;
    }

    public final void setCreatedUnix(@Nullable Long l10) {
        this.createdUnix = l10;
    }

    public final void setMyPrivilegeList(@Nullable List<CpPrivilege> list) {
        this.myPrivilegeList = list;
    }

    @NotNull
    public String toString() {
        return "MyCp(cpUserInfo=" + this.cpUserInfo + ", cpLevel=" + this.cpLevel + ", myPrivilegeList=" + this.myPrivilegeList + ", cpDays=" + this.cpDays + ", createdUnix=" + this.createdUnix + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        User user = this.cpUserInfo;
        if (user == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            user.writeToParcel(dest, flags);
        }
        CpLevel cpLevel = this.cpLevel;
        if (cpLevel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            cpLevel.writeToParcel(dest, flags);
        }
        List<CpPrivilege> list = this.myPrivilegeList;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<CpPrivilege> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        Integer num = this.cpDays;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Long l10 = this.createdUnix;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
    }

    public MyCp(@Nullable User user, @Nullable CpLevel cpLevel, @Nullable List<CpPrivilege> list, @Nullable Integer num, @Nullable Long l10) {
        this.cpUserInfo = user;
        this.cpLevel = cpLevel;
        this.myPrivilegeList = list;
        this.cpDays = num;
        this.createdUnix = l10;
    }

    public /* synthetic */ MyCp(User user, CpLevel cpLevel, List list, Integer num, Long l10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : user, (i10 & 2) != 0 ? null : cpLevel, (i10 & 4) != 0 ? null : list, (i10 & 8) != 0 ? null : num, (i10 & 16) != 0 ? null : l10);
    }
}
