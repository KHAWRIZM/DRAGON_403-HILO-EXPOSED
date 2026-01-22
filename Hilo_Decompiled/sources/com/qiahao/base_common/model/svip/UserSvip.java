package com.qiahao.base_common.model.svip;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0013\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011Jv\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00101J\u0006\u00102\u001a\u00020\u0005J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u00020\u0005HÖ\u0001J\t\u00108\u001a\u000209HÖ\u0001J\u0016\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0005R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R$\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013¨\u0006?"}, d2 = {"Lcom/qiahao/base_common/model/svip/UserSvip;", "Landroid/os/Parcelable;", "expireAtUnix", "", FirebaseAnalytics.Param.LEVEL, "", "points", "privileges", "", "Lcom/qiahao/base_common/model/svip/Privilege;", "userId", "nextLevelPoints", "leftPoints", "continuePoints", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getExpireAtUnix", "()Ljava/lang/Long;", "setExpireAtUnix", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLevel", "()Ljava/lang/Integer;", "setLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPoints", "setPoints", "getPrivileges", "()Ljava/util/List;", "setPrivileges", "(Ljava/util/List;)V", "getUserId", "setUserId", "getNextLevelPoints", "setNextLevelPoints", "getLeftPoints", "setLeftPoints", "getContinuePoints", "setContinuePoints", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/qiahao/base_common/model/svip/UserSvip;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class UserSvip implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<UserSvip> CREATOR = new Creator();

    @Nullable
    private Long continuePoints;

    @Nullable
    private Long expireAtUnix;

    @Nullable
    private Long leftPoints;

    @Nullable
    private Integer level;

    @Nullable
    private Long nextLevelPoints;

    @Nullable
    private Long points;

    @Nullable
    private List<Privilege> privileges;

    @Nullable
    private Integer userId;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<UserSvip> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UserSvip createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Long valueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Long valueOf3 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList2.add(parcel.readInt() == 0 ? null : Privilege.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new UserSvip(valueOf, valueOf2, valueOf3, arrayList, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UserSvip[] newArray(int i10) {
            return new UserSvip[i10];
        }
    }

    public UserSvip() {
        this(null, null, null, null, null, null, null, null, KotlinVersion.MAX_COMPONENT_VALUE, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getExpireAtUnix() {
        return this.expireAtUnix;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getPoints() {
        return this.points;
    }

    @Nullable
    public final List<Privilege> component4() {
        return this.privileges;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getUserId() {
        return this.userId;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Long getNextLevelPoints() {
        return this.nextLevelPoints;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Long getLeftPoints() {
        return this.leftPoints;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Long getContinuePoints() {
        return this.continuePoints;
    }

    @NotNull
    public final UserSvip copy(@Nullable Long expireAtUnix, @Nullable Integer level, @Nullable Long points, @Nullable List<Privilege> privileges, @Nullable Integer userId, @Nullable Long nextLevelPoints, @Nullable Long leftPoints, @Nullable Long continuePoints) {
        return new UserSvip(expireAtUnix, level, points, privileges, userId, nextLevelPoints, leftPoints, continuePoints);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserSvip)) {
            return false;
        }
        UserSvip userSvip = (UserSvip) other;
        return Intrinsics.areEqual(this.expireAtUnix, userSvip.expireAtUnix) && Intrinsics.areEqual(this.level, userSvip.level) && Intrinsics.areEqual(this.points, userSvip.points) && Intrinsics.areEqual(this.privileges, userSvip.privileges) && Intrinsics.areEqual(this.userId, userSvip.userId) && Intrinsics.areEqual(this.nextLevelPoints, userSvip.nextLevelPoints) && Intrinsics.areEqual(this.leftPoints, userSvip.leftPoints) && Intrinsics.areEqual(this.continuePoints, userSvip.continuePoints);
    }

    @Nullable
    public final Long getContinuePoints() {
        return this.continuePoints;
    }

    @Nullable
    public final Long getExpireAtUnix() {
        return this.expireAtUnix;
    }

    @Nullable
    public final Long getLeftPoints() {
        return this.leftPoints;
    }

    @Nullable
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    public final Long getNextLevelPoints() {
        return this.nextLevelPoints;
    }

    @Nullable
    public final Long getPoints() {
        return this.points;
    }

    @Nullable
    public final List<Privilege> getPrivileges() {
        return this.privileges;
    }

    @Nullable
    public final Integer getUserId() {
        return this.userId;
    }

    public int hashCode() {
        Long l10 = this.expireAtUnix;
        int hashCode = (l10 == null ? 0 : l10.hashCode()) * 31;
        Integer num = this.level;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Long l11 = this.points;
        int hashCode3 = (hashCode2 + (l11 == null ? 0 : l11.hashCode())) * 31;
        List<Privilege> list = this.privileges;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num2 = this.userId;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l12 = this.nextLevelPoints;
        int hashCode6 = (hashCode5 + (l12 == null ? 0 : l12.hashCode())) * 31;
        Long l13 = this.leftPoints;
        int hashCode7 = (hashCode6 + (l13 == null ? 0 : l13.hashCode())) * 31;
        Long l14 = this.continuePoints;
        return hashCode7 + (l14 != null ? l14.hashCode() : 0);
    }

    public final void setContinuePoints(@Nullable Long l10) {
        this.continuePoints = l10;
    }

    public final void setExpireAtUnix(@Nullable Long l10) {
        this.expireAtUnix = l10;
    }

    public final void setLeftPoints(@Nullable Long l10) {
        this.leftPoints = l10;
    }

    public final void setLevel(@Nullable Integer num) {
        this.level = num;
    }

    public final void setNextLevelPoints(@Nullable Long l10) {
        this.nextLevelPoints = l10;
    }

    public final void setPoints(@Nullable Long l10) {
        this.points = l10;
    }

    public final void setPrivileges(@Nullable List<Privilege> list) {
        this.privileges = list;
    }

    public final void setUserId(@Nullable Integer num) {
        this.userId = num;
    }

    @NotNull
    public String toString() {
        return "UserSvip(expireAtUnix=" + this.expireAtUnix + ", level=" + this.level + ", points=" + this.points + ", privileges=" + this.privileges + ", userId=" + this.userId + ", nextLevelPoints=" + this.nextLevelPoints + ", leftPoints=" + this.leftPoints + ", continuePoints=" + this.continuePoints + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Long l10 = this.expireAtUnix;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        Integer num = this.level;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Long l11 = this.points;
        if (l11 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l11.longValue());
        }
        List<Privilege> list = this.privileges;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            for (Privilege privilege : list) {
                if (privilege == null) {
                    dest.writeInt(0);
                } else {
                    dest.writeInt(1);
                    privilege.writeToParcel(dest, flags);
                }
            }
        }
        Integer num2 = this.userId;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        Long l12 = this.nextLevelPoints;
        if (l12 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l12.longValue());
        }
        Long l13 = this.leftPoints;
        if (l13 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l13.longValue());
        }
        Long l14 = this.continuePoints;
        if (l14 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l14.longValue());
        }
    }

    public UserSvip(@Nullable Long l10, @Nullable Integer num, @Nullable Long l11, @Nullable List<Privilege> list, @Nullable Integer num2, @Nullable Long l12, @Nullable Long l13, @Nullable Long l14) {
        this.expireAtUnix = l10;
        this.level = num;
        this.points = l11;
        this.privileges = list;
        this.userId = num2;
        this.nextLevelPoints = l12;
        this.leftPoints = l13;
        this.continuePoints = l14;
    }

    public /* synthetic */ UserSvip(Long l10, Integer num, Long l11, List list, Integer num2, Long l12, Long l13, Long l14, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : l11, (i10 & 8) != 0 ? null : list, (i10 & 16) != 0 ? null : num2, (i10 & 32) != 0 ? null : l12, (i10 & 64) != 0 ? null : l13, (i10 & 128) == 0 ? l14 : null);
    }
}
