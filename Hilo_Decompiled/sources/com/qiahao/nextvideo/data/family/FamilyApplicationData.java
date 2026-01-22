package com.qiahao.nextvideo.data.family;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.base_common.model.common.User;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003JJ\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020\u0005J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0005HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0005R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00064"}, d2 = {"Lcom/qiahao/nextvideo/data/family/FamilyApplicationData;", "Landroid/os/Parcelable;", "mgrName", "", "status", "", "quitType", AgooConstants.MESSAGE_TIME, "", "user", "Lcom/qiahao/base_common/model/common/User;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Lcom/qiahao/base_common/model/common/User;)V", "getMgrName", "()Ljava/lang/String;", "setMgrName", "(Ljava/lang/String;)V", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getQuitType", "setQuitType", "getTime", "()Ljava/lang/Long;", "setTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "setUser", "(Lcom/qiahao/base_common/model/common/User;)V", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Lcom/qiahao/base_common/model/common/User;)Lcom/qiahao/nextvideo/data/family/FamilyApplicationData;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class FamilyApplicationData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<FamilyApplicationData> CREATOR = new Creator();

    @Nullable
    private String mgrName;

    @Nullable
    private Integer quitType;

    @Nullable
    private Integer status;

    @Nullable
    private Long time;

    @Nullable
    private User user;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<FamilyApplicationData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyApplicationData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FamilyApplicationData(parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readParcelable(FamilyApplicationData.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyApplicationData[] newArray(int i) {
            return new FamilyApplicationData[i];
        }
    }

    public FamilyApplicationData() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ FamilyApplicationData copy$default(FamilyApplicationData familyApplicationData, String str, Integer num, Integer num2, Long l, User user, int i, Object obj) {
        if ((i & 1) != 0) {
            str = familyApplicationData.mgrName;
        }
        if ((i & 2) != 0) {
            num = familyApplicationData.status;
        }
        Integer num3 = num;
        if ((i & 4) != 0) {
            num2 = familyApplicationData.quitType;
        }
        Integer num4 = num2;
        if ((i & 8) != 0) {
            l = familyApplicationData.time;
        }
        Long l2 = l;
        if ((i & 16) != 0) {
            user = familyApplicationData.user;
        }
        return familyApplicationData.copy(str, num3, num4, l2, user);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getMgrName() {
        return this.mgrName;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getStatus() {
        return this.status;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getQuitType() {
        return this.quitType;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getTime() {
        return this.time;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    @NotNull
    public final FamilyApplicationData copy(@Nullable String mgrName, @Nullable Integer status, @Nullable Integer quitType, @Nullable Long time, @Nullable User user) {
        return new FamilyApplicationData(mgrName, status, quitType, time, user);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FamilyApplicationData)) {
            return false;
        }
        FamilyApplicationData familyApplicationData = (FamilyApplicationData) other;
        return Intrinsics.areEqual(this.mgrName, familyApplicationData.mgrName) && Intrinsics.areEqual(this.status, familyApplicationData.status) && Intrinsics.areEqual(this.quitType, familyApplicationData.quitType) && Intrinsics.areEqual(this.time, familyApplicationData.time) && Intrinsics.areEqual(this.user, familyApplicationData.user);
    }

    @Nullable
    public final String getMgrName() {
        return this.mgrName;
    }

    @Nullable
    public final Integer getQuitType() {
        return this.quitType;
    }

    @Nullable
    public final Integer getStatus() {
        return this.status;
    }

    @Nullable
    public final Long getTime() {
        return this.time;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        String str = this.mgrName;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.status;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.quitType;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l = this.time;
        int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        User user = this.user;
        return hashCode4 + (user != null ? user.hashCode() : 0);
    }

    public final void setMgrName(@Nullable String str) {
        this.mgrName = str;
    }

    public final void setQuitType(@Nullable Integer num) {
        this.quitType = num;
    }

    public final void setStatus(@Nullable Integer num) {
        this.status = num;
    }

    public final void setTime(@Nullable Long l) {
        this.time = l;
    }

    public final void setUser(@Nullable User user) {
        this.user = user;
    }

    @NotNull
    public String toString() {
        return "FamilyApplicationData(mgrName=" + this.mgrName + ", status=" + this.status + ", quitType=" + this.quitType + ", time=" + this.time + ", user=" + this.user + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.mgrName);
        Integer num = this.status;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Integer num2 = this.quitType;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        Long l = this.time;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        dest.writeParcelable(this.user, flags);
    }

    public FamilyApplicationData(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable Long l, @Nullable User user) {
        this.mgrName = str;
        this.status = num;
        this.quitType = num2;
        this.time = l;
        this.user = user;
    }

    public /* synthetic */ FamilyApplicationData(String str, Integer num, Integer num2, Long l, User user, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : user);
    }
}
