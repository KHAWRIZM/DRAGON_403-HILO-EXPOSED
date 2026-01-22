package com.qiahao.nextvideo.data.family;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.base_common.model.common.User;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u0003J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/data/family/FamilyCenterMember;", "Landroid/os/Parcelable;", "rankingType", "", "role", "user", "Lcom/qiahao/base_common/model/common/User;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/qiahao/base_common/model/common/User;)V", "getRankingType", "()Ljava/lang/Integer;", "setRankingType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getRole", "setRole", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "setUser", "(Lcom/qiahao/base_common/model/common/User;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/qiahao/base_common/model/common/User;)Lcom/qiahao/nextvideo/data/family/FamilyCenterMember;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class FamilyCenterMember implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<FamilyCenterMember> CREATOR = new Creator();

    @Nullable
    private Integer rankingType;

    @Nullable
    private Integer role;

    @Nullable
    private User user;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<FamilyCenterMember> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyCenterMember createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FamilyCenterMember(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readParcelable(FamilyCenterMember.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyCenterMember[] newArray(int i) {
            return new FamilyCenterMember[i];
        }
    }

    public FamilyCenterMember() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ FamilyCenterMember copy$default(FamilyCenterMember familyCenterMember, Integer num, Integer num2, User user, int i, Object obj) {
        if ((i & 1) != 0) {
            num = familyCenterMember.rankingType;
        }
        if ((i & 2) != 0) {
            num2 = familyCenterMember.role;
        }
        if ((i & 4) != 0) {
            user = familyCenterMember.user;
        }
        return familyCenterMember.copy(num, num2, user);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getRankingType() {
        return this.rankingType;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getRole() {
        return this.role;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    @NotNull
    public final FamilyCenterMember copy(@Nullable Integer rankingType, @Nullable Integer role, @Nullable User user) {
        return new FamilyCenterMember(rankingType, role, user);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FamilyCenterMember)) {
            return false;
        }
        FamilyCenterMember familyCenterMember = (FamilyCenterMember) other;
        return Intrinsics.areEqual(this.rankingType, familyCenterMember.rankingType) && Intrinsics.areEqual(this.role, familyCenterMember.role) && Intrinsics.areEqual(this.user, familyCenterMember.user);
    }

    @Nullable
    public final Integer getRankingType() {
        return this.rankingType;
    }

    @Nullable
    public final Integer getRole() {
        return this.role;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        Integer num = this.rankingType;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.role;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        User user = this.user;
        return hashCode2 + (user != null ? user.hashCode() : 0);
    }

    public final void setRankingType(@Nullable Integer num) {
        this.rankingType = num;
    }

    public final void setRole(@Nullable Integer num) {
        this.role = num;
    }

    public final void setUser(@Nullable User user) {
        this.user = user;
    }

    @NotNull
    public String toString() {
        return "FamilyCenterMember(rankingType=" + this.rankingType + ", role=" + this.role + ", user=" + this.user + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Integer num = this.rankingType;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Integer num2 = this.role;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        dest.writeParcelable(this.user, flags);
    }

    public FamilyCenterMember(@Nullable Integer num, @Nullable Integer num2, @Nullable User user) {
        this.rankingType = num;
        this.role = num2;
        this.user = user;
    }

    public /* synthetic */ FamilyCenterMember(Integer num, Integer num2, User user, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : user);
    }
}
