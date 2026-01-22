package com.qiahao.nextvideo.data.model.gameLevel;

import android.os.Parcel;
import android.os.Parcelable;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014JV\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010%J\u0006\u0010&\u001a\u00020\u0006J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0006HÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0006R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016¨\u00063"}, d2 = {"Lcom/qiahao/nextvideo/data/model/gameLevel/UserGameLevel;", "Landroid/os/Parcelable;", "expireAtUnix", "", "leftPoints", "level", "", "nextLevelPoints", "points", TUIConstants.TUILive.USER_ID, "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)V", "getExpireAtUnix", "()Ljava/lang/Long;", "setExpireAtUnix", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLeftPoints", "setLeftPoints", "getLevel", "()Ljava/lang/Integer;", "setLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getNextLevelPoints", "setNextLevelPoints", "getPoints", "setPoints", "getUserId", "setUserId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/model/gameLevel/UserGameLevel;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class UserGameLevel implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<UserGameLevel> CREATOR = new Creator();

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
    private Integer userId;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<UserGameLevel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UserGameLevel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UserGameLevel(parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UserGameLevel[] newArray(int i) {
            return new UserGameLevel[i];
        }
    }

    public UserGameLevel() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ UserGameLevel copy$default(UserGameLevel userGameLevel, Long l, Long l2, Integer num, Long l3, Long l4, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = userGameLevel.expireAtUnix;
        }
        if ((i & 2) != 0) {
            l2 = userGameLevel.leftPoints;
        }
        Long l5 = l2;
        if ((i & 4) != 0) {
            num = userGameLevel.level;
        }
        Integer num3 = num;
        if ((i & 8) != 0) {
            l3 = userGameLevel.nextLevelPoints;
        }
        Long l6 = l3;
        if ((i & 16) != 0) {
            l4 = userGameLevel.points;
        }
        Long l7 = l4;
        if ((i & 32) != 0) {
            num2 = userGameLevel.userId;
        }
        return userGameLevel.copy(l, l5, num3, l6, l7, num2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getExpireAtUnix() {
        return this.expireAtUnix;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getLeftPoints() {
        return this.leftPoints;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getNextLevelPoints() {
        return this.nextLevelPoints;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Long getPoints() {
        return this.points;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Integer getUserId() {
        return this.userId;
    }

    @NotNull
    public final UserGameLevel copy(@Nullable Long expireAtUnix, @Nullable Long leftPoints, @Nullable Integer level, @Nullable Long nextLevelPoints, @Nullable Long points, @Nullable Integer userId) {
        return new UserGameLevel(expireAtUnix, leftPoints, level, nextLevelPoints, points, userId);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserGameLevel)) {
            return false;
        }
        UserGameLevel userGameLevel = (UserGameLevel) other;
        return Intrinsics.areEqual(this.expireAtUnix, userGameLevel.expireAtUnix) && Intrinsics.areEqual(this.leftPoints, userGameLevel.leftPoints) && Intrinsics.areEqual(this.level, userGameLevel.level) && Intrinsics.areEqual(this.nextLevelPoints, userGameLevel.nextLevelPoints) && Intrinsics.areEqual(this.points, userGameLevel.points) && Intrinsics.areEqual(this.userId, userGameLevel.userId);
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
    public final Integer getUserId() {
        return this.userId;
    }

    public int hashCode() {
        Long l = this.expireAtUnix;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.leftPoints;
        int hashCode2 = (hashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
        Integer num = this.level;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Long l3 = this.nextLevelPoints;
        int hashCode4 = (hashCode3 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.points;
        int hashCode5 = (hashCode4 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Integer num2 = this.userId;
        return hashCode5 + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setExpireAtUnix(@Nullable Long l) {
        this.expireAtUnix = l;
    }

    public final void setLeftPoints(@Nullable Long l) {
        this.leftPoints = l;
    }

    public final void setLevel(@Nullable Integer num) {
        this.level = num;
    }

    public final void setNextLevelPoints(@Nullable Long l) {
        this.nextLevelPoints = l;
    }

    public final void setPoints(@Nullable Long l) {
        this.points = l;
    }

    public final void setUserId(@Nullable Integer num) {
        this.userId = num;
    }

    @NotNull
    public String toString() {
        return "UserGameLevel(expireAtUnix=" + this.expireAtUnix + ", leftPoints=" + this.leftPoints + ", level=" + this.level + ", nextLevelPoints=" + this.nextLevelPoints + ", points=" + this.points + ", userId=" + this.userId + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Long l = this.expireAtUnix;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        Long l2 = this.leftPoints;
        if (l2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l2.longValue());
        }
        Integer num = this.level;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Long l3 = this.nextLevelPoints;
        if (l3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l3.longValue());
        }
        Long l4 = this.points;
        if (l4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l4.longValue());
        }
        Integer num2 = this.userId;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
    }

    public UserGameLevel(@Nullable Long l, @Nullable Long l2, @Nullable Integer num, @Nullable Long l3, @Nullable Long l4, @Nullable Integer num2) {
        this.expireAtUnix = l;
        this.leftPoints = l2;
        this.level = num;
        this.nextLevelPoints = l3;
        this.points = l4;
        this.userId = num2;
    }

    public /* synthetic */ UserGameLevel(Long l, Long l2, Integer num, Long l3, Long l4, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : l3, (i & 16) != 0 ? null : l4, (i & 32) != 0 ? null : num2);
    }
}
