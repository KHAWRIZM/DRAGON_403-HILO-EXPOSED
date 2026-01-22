package com.qiahao.base_common.model.cp;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.base_common.model.common.User;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010!JV\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010,J\u0006\u0010-\u001a\u00020\u0005J\u0013\u0010.\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u0005HÖ\u0001J\t\u00102\u001a\u000203HÖ\u0001J\u0016\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0005R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00069"}, d2 = {"Lcom/qiahao/base_common/model/cp/CpInfo;", "Landroid/os/Parcelable;", "applyToUnbind", "", "cpDays", "", "cpUserInfo", "Lcom/qiahao/base_common/model/common/User;", "userInfo", "visitTimes", "createdUnix", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/common/User;Ljava/lang/Integer;Ljava/lang/Long;)V", "getApplyToUnbind", "()Ljava/lang/Boolean;", "setApplyToUnbind", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getCpDays", "()Ljava/lang/Integer;", "setCpDays", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCpUserInfo", "()Lcom/qiahao/base_common/model/common/User;", "setCpUserInfo", "(Lcom/qiahao/base_common/model/common/User;)V", "getUserInfo", "setUserInfo", "getVisitTimes", "setVisitTimes", "getCreatedUnix", "()Ljava/lang/Long;", "setCreatedUnix", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/common/User;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/qiahao/base_common/model/cp/CpInfo;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class CpInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<CpInfo> CREATOR = new Creator();

    @Nullable
    private Boolean applyToUnbind;

    @Nullable
    private Integer cpDays;

    @Nullable
    private User cpUserInfo;

    @Nullable
    private Long createdUnix;

    @Nullable
    private User userInfo;

    @Nullable
    private Integer visitTimes;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<CpInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CpInfo createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new CpInfo(valueOf, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : User.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : User.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CpInfo[] newArray(int i10) {
            return new CpInfo[i10];
        }
    }

    public CpInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ CpInfo copy$default(CpInfo cpInfo, Boolean bool, Integer num, User user, User user2, Integer num2, Long l10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = cpInfo.applyToUnbind;
        }
        if ((i10 & 2) != 0) {
            num = cpInfo.cpDays;
        }
        Integer num3 = num;
        if ((i10 & 4) != 0) {
            user = cpInfo.cpUserInfo;
        }
        User user3 = user;
        if ((i10 & 8) != 0) {
            user2 = cpInfo.userInfo;
        }
        User user4 = user2;
        if ((i10 & 16) != 0) {
            num2 = cpInfo.visitTimes;
        }
        Integer num4 = num2;
        if ((i10 & 32) != 0) {
            l10 = cpInfo.createdUnix;
        }
        return cpInfo.copy(bool, num3, user3, user4, num4, l10);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Boolean getApplyToUnbind() {
        return this.applyToUnbind;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getCpDays() {
        return this.cpDays;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final User getCpUserInfo() {
        return this.cpUserInfo;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final User getUserInfo() {
        return this.userInfo;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getVisitTimes() {
        return this.visitTimes;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Long getCreatedUnix() {
        return this.createdUnix;
    }

    @NotNull
    public final CpInfo copy(@Nullable Boolean applyToUnbind, @Nullable Integer cpDays, @Nullable User cpUserInfo, @Nullable User userInfo, @Nullable Integer visitTimes, @Nullable Long createdUnix) {
        return new CpInfo(applyToUnbind, cpDays, cpUserInfo, userInfo, visitTimes, createdUnix);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CpInfo)) {
            return false;
        }
        CpInfo cpInfo = (CpInfo) other;
        return Intrinsics.areEqual(this.applyToUnbind, cpInfo.applyToUnbind) && Intrinsics.areEqual(this.cpDays, cpInfo.cpDays) && Intrinsics.areEqual(this.cpUserInfo, cpInfo.cpUserInfo) && Intrinsics.areEqual(this.userInfo, cpInfo.userInfo) && Intrinsics.areEqual(this.visitTimes, cpInfo.visitTimes) && Intrinsics.areEqual(this.createdUnix, cpInfo.createdUnix);
    }

    @Nullable
    public final Boolean getApplyToUnbind() {
        return this.applyToUnbind;
    }

    @Nullable
    public final Integer getCpDays() {
        return this.cpDays;
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
    public final User getUserInfo() {
        return this.userInfo;
    }

    @Nullable
    public final Integer getVisitTimes() {
        return this.visitTimes;
    }

    public int hashCode() {
        Boolean bool = this.applyToUnbind;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.cpDays;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        User user = this.cpUserInfo;
        int hashCode3 = (hashCode2 + (user == null ? 0 : user.hashCode())) * 31;
        User user2 = this.userInfo;
        int hashCode4 = (hashCode3 + (user2 == null ? 0 : user2.hashCode())) * 31;
        Integer num2 = this.visitTimes;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l10 = this.createdUnix;
        return hashCode5 + (l10 != null ? l10.hashCode() : 0);
    }

    public final void setApplyToUnbind(@Nullable Boolean bool) {
        this.applyToUnbind = bool;
    }

    public final void setCpDays(@Nullable Integer num) {
        this.cpDays = num;
    }

    public final void setCpUserInfo(@Nullable User user) {
        this.cpUserInfo = user;
    }

    public final void setCreatedUnix(@Nullable Long l10) {
        this.createdUnix = l10;
    }

    public final void setUserInfo(@Nullable User user) {
        this.userInfo = user;
    }

    public final void setVisitTimes(@Nullable Integer num) {
        this.visitTimes = num;
    }

    @NotNull
    public String toString() {
        return "CpInfo(applyToUnbind=" + this.applyToUnbind + ", cpDays=" + this.cpDays + ", cpUserInfo=" + this.cpUserInfo + ", userInfo=" + this.userInfo + ", visitTimes=" + this.visitTimes + ", createdUnix=" + this.createdUnix + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Boolean bool = this.applyToUnbind;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Integer num = this.cpDays;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        User user = this.cpUserInfo;
        if (user == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            user.writeToParcel(dest, flags);
        }
        User user2 = this.userInfo;
        if (user2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            user2.writeToParcel(dest, flags);
        }
        Integer num2 = this.visitTimes;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        Long l10 = this.createdUnix;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
    }

    public CpInfo(@Nullable Boolean bool, @Nullable Integer num, @Nullable User user, @Nullable User user2, @Nullable Integer num2, @Nullable Long l10) {
        this.applyToUnbind = bool;
        this.cpDays = num;
        this.cpUserInfo = user;
        this.userInfo = user2;
        this.visitTimes = num2;
        this.createdUnix = l10;
    }

    public /* synthetic */ CpInfo(Boolean bool, Integer num, User user, User user2, Integer num2, Long l10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? Boolean.FALSE : bool, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : user, (i10 & 8) != 0 ? null : user2, (i10 & 16) != 0 ? null : num2, (i10 & 32) == 0 ? l10 : null);
    }
}
