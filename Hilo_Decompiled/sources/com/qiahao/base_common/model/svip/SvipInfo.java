package com.qiahao.base_common.model.svip;

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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001aHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001aR$\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/qiahao/base_common/model/svip/SvipInfo;", "Landroid/os/Parcelable;", "svipCards", "", "Lcom/qiahao/base_common/model/svip/SvipCard;", "svipPrivilege", "Lcom/qiahao/base_common/model/svip/SvipPrivilege;", "userSvip", "Lcom/qiahao/base_common/model/svip/UserSvip;", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/qiahao/base_common/model/svip/UserSvip;)V", "getSvipCards", "()Ljava/util/List;", "setSvipCards", "(Ljava/util/List;)V", "getSvipPrivilege", "setSvipPrivilege", "getUserSvip", "()Lcom/qiahao/base_common/model/svip/UserSvip;", "setUserSvip", "(Lcom/qiahao/base_common/model/svip/UserSvip;)V", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class SvipInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SvipInfo> CREATOR = new Creator();

    @Nullable
    private List<SvipCard> svipCards;

    @Nullable
    private List<SvipPrivilege> svipPrivilege;

    @Nullable
    private UserSvip userSvip;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<SvipInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SvipInfo createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readInt() == 0 ? null : SvipCard.CREATOR.createFromParcel(parcel));
                }
            }
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int readInt2 = parcel.readInt();
                arrayList2 = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList2.add(SvipPrivilege.CREATOR.createFromParcel(parcel));
                }
            }
            return new SvipInfo(arrayList, arrayList2, parcel.readInt() != 0 ? UserSvip.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SvipInfo[] newArray(int i10) {
            return new SvipInfo[i10];
        }
    }

    public SvipInfo() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SvipInfo copy$default(SvipInfo svipInfo, List list, List list2, UserSvip userSvip, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = svipInfo.svipCards;
        }
        if ((i10 & 2) != 0) {
            list2 = svipInfo.svipPrivilege;
        }
        if ((i10 & 4) != 0) {
            userSvip = svipInfo.userSvip;
        }
        return svipInfo.copy(list, list2, userSvip);
    }

    @Nullable
    public final List<SvipCard> component1() {
        return this.svipCards;
    }

    @Nullable
    public final List<SvipPrivilege> component2() {
        return this.svipPrivilege;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final UserSvip getUserSvip() {
        return this.userSvip;
    }

    @NotNull
    public final SvipInfo copy(@Nullable List<SvipCard> svipCards, @Nullable List<SvipPrivilege> svipPrivilege, @Nullable UserSvip userSvip) {
        return new SvipInfo(svipCards, svipPrivilege, userSvip);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SvipInfo)) {
            return false;
        }
        SvipInfo svipInfo = (SvipInfo) other;
        return Intrinsics.areEqual(this.svipCards, svipInfo.svipCards) && Intrinsics.areEqual(this.svipPrivilege, svipInfo.svipPrivilege) && Intrinsics.areEqual(this.userSvip, svipInfo.userSvip);
    }

    @Nullable
    public final List<SvipCard> getSvipCards() {
        return this.svipCards;
    }

    @Nullable
    public final List<SvipPrivilege> getSvipPrivilege() {
        return this.svipPrivilege;
    }

    @Nullable
    public final UserSvip getUserSvip() {
        return this.userSvip;
    }

    public int hashCode() {
        List<SvipCard> list = this.svipCards;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<SvipPrivilege> list2 = this.svipPrivilege;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        UserSvip userSvip = this.userSvip;
        return hashCode2 + (userSvip != null ? userSvip.hashCode() : 0);
    }

    public final void setSvipCards(@Nullable List<SvipCard> list) {
        this.svipCards = list;
    }

    public final void setSvipPrivilege(@Nullable List<SvipPrivilege> list) {
        this.svipPrivilege = list;
    }

    public final void setUserSvip(@Nullable UserSvip userSvip) {
        this.userSvip = userSvip;
    }

    @NotNull
    public String toString() {
        return "SvipInfo(svipCards=" + this.svipCards + ", svipPrivilege=" + this.svipPrivilege + ", userSvip=" + this.userSvip + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        List<SvipCard> list = this.svipCards;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            for (SvipCard svipCard : list) {
                if (svipCard == null) {
                    dest.writeInt(0);
                } else {
                    dest.writeInt(1);
                    svipCard.writeToParcel(dest, flags);
                }
            }
        }
        List<SvipPrivilege> list2 = this.svipPrivilege;
        if (list2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list2.size());
            Iterator<SvipPrivilege> it = list2.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        UserSvip userSvip = this.userSvip;
        if (userSvip == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            userSvip.writeToParcel(dest, flags);
        }
    }

    public SvipInfo(@Nullable List<SvipCard> list, @Nullable List<SvipPrivilege> list2, @Nullable UserSvip userSvip) {
        this.svipCards = list;
        this.svipPrivilege = list2;
        this.userSvip = userSvip;
    }

    public /* synthetic */ SvipInfo(List list, List list2, UserSvip userSvip, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : list, (i10 & 2) != 0 ? null : list2, (i10 & 4) != 0 ? null : userSvip);
    }
}
