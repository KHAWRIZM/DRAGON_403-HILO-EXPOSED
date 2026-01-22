package com.qiahao.nextvideo.data.cp;

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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010.\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011Jn\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00103J\u0006\u00104\u001a\u00020\u0003J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020\u0003HÖ\u0001J\t\u0010:\u001a\u00020\tHÖ\u0001J\u0016\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013¨\u0006@"}, d2 = {"Lcom/qiahao/nextvideo/data/cp/CpRecord;", "Landroid/os/Parcelable;", "cpId", "", "score", "", "timeUnix", "type", "typeDesc", "", "user1", "Lcom/qiahao/base_common/model/common/User;", "user2", "cpLevel", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/common/User;Ljava/lang/Integer;)V", "getCpId", "()Ljava/lang/Integer;", "setCpId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getScore", "()Ljava/lang/Long;", "setScore", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getTimeUnix", "setTimeUnix", "getType", "setType", "getTypeDesc", "()Ljava/lang/String;", "setTypeDesc", "(Ljava/lang/String;)V", "getUser1", "()Lcom/qiahao/base_common/model/common/User;", "setUser1", "(Lcom/qiahao/base_common/model/common/User;)V", "getUser2", "setUser2", "getCpLevel", "setCpLevel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/common/User;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/cp/CpRecord;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CpRecord implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<CpRecord> CREATOR = new Creator();

    @Nullable
    private Integer cpId;

    @Nullable
    private Integer cpLevel;

    @Nullable
    private Long score;

    @Nullable
    private Long timeUnix;

    @Nullable
    private Integer type;

    @Nullable
    private String typeDesc;

    @Nullable
    private User user1;

    @Nullable
    private User user2;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<CpRecord> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CpRecord createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CpRecord(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readParcelable(CpRecord.class.getClassLoader()), parcel.readParcelable(CpRecord.class.getClassLoader()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CpRecord[] newArray(int i) {
            return new CpRecord[i];
        }
    }

    public CpRecord() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getCpId() {
        return this.cpId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getScore() {
        return this.score;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getTimeUnix() {
        return this.timeUnix;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getTypeDesc() {
        return this.typeDesc;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final User getUser1() {
        return this.user1;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final User getUser2() {
        return this.user2;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getCpLevel() {
        return this.cpLevel;
    }

    @NotNull
    public final CpRecord copy(@Nullable Integer cpId, @Nullable Long score, @Nullable Long timeUnix, @Nullable Integer type, @Nullable String typeDesc, @Nullable User user1, @Nullable User user2, @Nullable Integer cpLevel) {
        return new CpRecord(cpId, score, timeUnix, type, typeDesc, user1, user2, cpLevel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CpRecord)) {
            return false;
        }
        CpRecord cpRecord = (CpRecord) other;
        return Intrinsics.areEqual(this.cpId, cpRecord.cpId) && Intrinsics.areEqual(this.score, cpRecord.score) && Intrinsics.areEqual(this.timeUnix, cpRecord.timeUnix) && Intrinsics.areEqual(this.type, cpRecord.type) && Intrinsics.areEqual(this.typeDesc, cpRecord.typeDesc) && Intrinsics.areEqual(this.user1, cpRecord.user1) && Intrinsics.areEqual(this.user2, cpRecord.user2) && Intrinsics.areEqual(this.cpLevel, cpRecord.cpLevel);
    }

    @Nullable
    public final Integer getCpId() {
        return this.cpId;
    }

    @Nullable
    public final Integer getCpLevel() {
        return this.cpLevel;
    }

    @Nullable
    public final Long getScore() {
        return this.score;
    }

    @Nullable
    public final Long getTimeUnix() {
        return this.timeUnix;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    @Nullable
    public final String getTypeDesc() {
        return this.typeDesc;
    }

    @Nullable
    public final User getUser1() {
        return this.user1;
    }

    @Nullable
    public final User getUser2() {
        return this.user2;
    }

    public int hashCode() {
        Integer num = this.cpId;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Long l = this.score;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.timeUnix;
        int hashCode3 = (hashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Integer num2 = this.type;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.typeDesc;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        User user = this.user1;
        int hashCode6 = (hashCode5 + (user == null ? 0 : user.hashCode())) * 31;
        User user2 = this.user2;
        int hashCode7 = (hashCode6 + (user2 == null ? 0 : user2.hashCode())) * 31;
        Integer num3 = this.cpLevel;
        return hashCode7 + (num3 != null ? num3.hashCode() : 0);
    }

    public final void setCpId(@Nullable Integer num) {
        this.cpId = num;
    }

    public final void setCpLevel(@Nullable Integer num) {
        this.cpLevel = num;
    }

    public final void setScore(@Nullable Long l) {
        this.score = l;
    }

    public final void setTimeUnix(@Nullable Long l) {
        this.timeUnix = l;
    }

    public final void setType(@Nullable Integer num) {
        this.type = num;
    }

    public final void setTypeDesc(@Nullable String str) {
        this.typeDesc = str;
    }

    public final void setUser1(@Nullable User user) {
        this.user1 = user;
    }

    public final void setUser2(@Nullable User user) {
        this.user2 = user;
    }

    @NotNull
    public String toString() {
        return "CpRecord(cpId=" + this.cpId + ", score=" + this.score + ", timeUnix=" + this.timeUnix + ", type=" + this.type + ", typeDesc=" + this.typeDesc + ", user1=" + this.user1 + ", user2=" + this.user2 + ", cpLevel=" + this.cpLevel + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Integer num = this.cpId;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Long l = this.score;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        Long l2 = this.timeUnix;
        if (l2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l2.longValue());
        }
        Integer num2 = this.type;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        dest.writeString(this.typeDesc);
        dest.writeParcelable(this.user1, flags);
        dest.writeParcelable(this.user2, flags);
        Integer num3 = this.cpLevel;
        if (num3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num3.intValue());
        }
    }

    public CpRecord(@Nullable Integer num, @Nullable Long l, @Nullable Long l2, @Nullable Integer num2, @Nullable String str, @Nullable User user, @Nullable User user2, @Nullable Integer num3) {
        this.cpId = num;
        this.score = l;
        this.timeUnix = l2;
        this.type = num2;
        this.typeDesc = str;
        this.user1 = user;
        this.user2 = user2;
        this.cpLevel = num3;
    }

    public /* synthetic */ CpRecord(Integer num, Long l, Long l2, Integer num2, String str, User user, User user2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : user, (i & 64) != 0 ? null : user2, (i & 128) == 0 ? num3 : null);
    }
}
