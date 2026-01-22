package com.qiahao.nextvideo.data.cp;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.cp.CpLevel;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011Jb\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00102J\u0006\u00103\u001a\u00020\u0003J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020\tHÖ\u0001J\u0016\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013¨\u0006?"}, d2 = {"Lcom/qiahao/nextvideo/data/cp/CpListData;", "Landroid/os/Parcelable;", "cpId", "", "cpLevel", "Lcom/qiahao/base_common/model/cp/CpLevel;", "score", "", "ranking", "", "user1", "Lcom/qiahao/base_common/model/common/User;", "user2", "type", "<init>", "(Ljava/lang/Integer;Lcom/qiahao/base_common/model/cp/CpLevel;Ljava/lang/Long;Ljava/lang/String;Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/common/User;Ljava/lang/Integer;)V", "getCpId", "()Ljava/lang/Integer;", "setCpId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCpLevel", "()Lcom/qiahao/base_common/model/cp/CpLevel;", "setCpLevel", "(Lcom/qiahao/base_common/model/cp/CpLevel;)V", "getScore", "()Ljava/lang/Long;", "setScore", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getRanking", "()Ljava/lang/String;", "setRanking", "(Ljava/lang/String;)V", "getUser1", "()Lcom/qiahao/base_common/model/common/User;", "setUser1", "(Lcom/qiahao/base_common/model/common/User;)V", "getUser2", "setUser2", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Lcom/qiahao/base_common/model/cp/CpLevel;Ljava/lang/Long;Ljava/lang/String;Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/common/User;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/cp/CpListData;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CpListData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<CpListData> CREATOR = new Creator();

    @Nullable
    private Integer cpId;

    @Nullable
    private CpLevel cpLevel;

    @Nullable
    private String ranking;

    @Nullable
    private Long score;

    @Nullable
    private Integer type;

    @Nullable
    private User user1;

    @Nullable
    private User user2;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<CpListData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CpListData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CpListData(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readParcelable(CpListData.class.getClassLoader()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readParcelable(CpListData.class.getClassLoader()), parcel.readParcelable(CpListData.class.getClassLoader()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CpListData[] newArray(int i) {
            return new CpListData[i];
        }
    }

    public CpListData() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ CpListData copy$default(CpListData cpListData, Integer num, CpLevel cpLevel, Long l, String str, User user, User user2, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = cpListData.cpId;
        }
        if ((i & 2) != 0) {
            cpLevel = cpListData.cpLevel;
        }
        CpLevel cpLevel2 = cpLevel;
        if ((i & 4) != 0) {
            l = cpListData.score;
        }
        Long l2 = l;
        if ((i & 8) != 0) {
            str = cpListData.ranking;
        }
        String str2 = str;
        if ((i & 16) != 0) {
            user = cpListData.user1;
        }
        User user3 = user;
        if ((i & 32) != 0) {
            user2 = cpListData.user2;
        }
        User user4 = user2;
        if ((i & 64) != 0) {
            num2 = cpListData.type;
        }
        return cpListData.copy(num, cpLevel2, l2, str2, user3, user4, num2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getCpId() {
        return this.cpId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final CpLevel getCpLevel() {
        return this.cpLevel;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getScore() {
        return this.score;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getRanking() {
        return this.ranking;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final User getUser1() {
        return this.user1;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final User getUser2() {
        return this.user2;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    @NotNull
    public final CpListData copy(@Nullable Integer cpId, @Nullable CpLevel cpLevel, @Nullable Long score, @Nullable String ranking, @Nullable User user1, @Nullable User user2, @Nullable Integer type) {
        return new CpListData(cpId, cpLevel, score, ranking, user1, user2, type);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CpListData)) {
            return false;
        }
        CpListData cpListData = (CpListData) other;
        return Intrinsics.areEqual(this.cpId, cpListData.cpId) && Intrinsics.areEqual(this.cpLevel, cpListData.cpLevel) && Intrinsics.areEqual(this.score, cpListData.score) && Intrinsics.areEqual(this.ranking, cpListData.ranking) && Intrinsics.areEqual(this.user1, cpListData.user1) && Intrinsics.areEqual(this.user2, cpListData.user2) && Intrinsics.areEqual(this.type, cpListData.type);
    }

    @Nullable
    public final Integer getCpId() {
        return this.cpId;
    }

    @Nullable
    public final CpLevel getCpLevel() {
        return this.cpLevel;
    }

    @Nullable
    public final String getRanking() {
        return this.ranking;
    }

    @Nullable
    public final Long getScore() {
        return this.score;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
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
        CpLevel cpLevel = this.cpLevel;
        int hashCode2 = (hashCode + (cpLevel == null ? 0 : cpLevel.hashCode())) * 31;
        Long l = this.score;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.ranking;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        User user = this.user1;
        int hashCode5 = (hashCode4 + (user == null ? 0 : user.hashCode())) * 31;
        User user2 = this.user2;
        int hashCode6 = (hashCode5 + (user2 == null ? 0 : user2.hashCode())) * 31;
        Integer num2 = this.type;
        return hashCode6 + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setCpId(@Nullable Integer num) {
        this.cpId = num;
    }

    public final void setCpLevel(@Nullable CpLevel cpLevel) {
        this.cpLevel = cpLevel;
    }

    public final void setRanking(@Nullable String str) {
        this.ranking = str;
    }

    public final void setScore(@Nullable Long l) {
        this.score = l;
    }

    public final void setType(@Nullable Integer num) {
        this.type = num;
    }

    public final void setUser1(@Nullable User user) {
        this.user1 = user;
    }

    public final void setUser2(@Nullable User user) {
        this.user2 = user;
    }

    @NotNull
    public String toString() {
        return "CpListData(cpId=" + this.cpId + ", cpLevel=" + this.cpLevel + ", score=" + this.score + ", ranking=" + this.ranking + ", user1=" + this.user1 + ", user2=" + this.user2 + ", type=" + this.type + ")";
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
        dest.writeParcelable(this.cpLevel, flags);
        Long l = this.score;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        dest.writeString(this.ranking);
        dest.writeParcelable(this.user1, flags);
        dest.writeParcelable(this.user2, flags);
        Integer num2 = this.type;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
    }

    public CpListData(@Nullable Integer num, @Nullable CpLevel cpLevel, @Nullable Long l, @Nullable String str, @Nullable User user, @Nullable User user2, @Nullable Integer num2) {
        this.cpId = num;
        this.cpLevel = cpLevel;
        this.score = l;
        this.ranking = str;
        this.user1 = user;
        this.user2 = user2;
        this.type = num2;
    }

    public /* synthetic */ CpListData(Integer num, CpLevel cpLevel, Long l, String str, User user, User user2, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : cpLevel, (i & 4) != 0 ? null : l, (i & 8) != 0 ? "" : str, (i & 16) != 0 ? null : user, (i & 32) != 0 ? null : user2, (i & 64) != 0 ? null : num2);
    }
}
