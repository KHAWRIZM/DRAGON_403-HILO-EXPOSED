package com.qiahao.nextvideo.data.game;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.base_common.model.common.User;
import com.taobao.accs.common.Constants;
import com.tencent.imsdk.v2.V2TIMManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010'\u001a\u00020\fJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010#Jb\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u00100J\u0006\u00101\u001a\u000202J\u0013\u00103\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u000202HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001J\u0016\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u000202R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001aR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006="}, d2 = {"Lcom/qiahao/nextvideo/data/game/Pk1v1Data;", "Landroid/os/Parcelable;", "groupId", "", "user1", "Lcom/qiahao/base_common/model/common/User;", "diamond1", "", "user2", "diamond2", "unix", "start", "", "<init>", "(Ljava/lang/String;Lcom/qiahao/base_common/model/common/User;Ljava/lang/Long;Lcom/qiahao/base_common/model/common/User;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)V", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "getUser1", "()Lcom/qiahao/base_common/model/common/User;", "setUser1", "(Lcom/qiahao/base_common/model/common/User;)V", "getDiamond1", "()Ljava/lang/Long;", "setDiamond1", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getUser2", "setUser2", "getDiamond2", "setDiamond2", "getUnix", "setUnix", "getStart", "()Ljava/lang/Boolean;", "setStart", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "checkIsPk", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Lcom/qiahao/base_common/model/common/User;Ljava/lang/Long;Lcom/qiahao/base_common/model/common/User;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/qiahao/nextvideo/data/game/Pk1v1Data;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class Pk1v1Data implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<Pk1v1Data> CREATOR = new Creator();

    @Nullable
    private Long diamond1;

    @Nullable
    private Long diamond2;

    @Nullable
    private String groupId;

    @Nullable
    private Boolean start;

    @Nullable
    private Long unix;

    @Nullable
    private User user1;

    @Nullable
    private User user2;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<Pk1v1Data> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Pk1v1Data createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            User readParcelable = parcel.readParcelable(Pk1v1Data.class.getClassLoader());
            Long valueOf2 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            User readParcelable2 = parcel.readParcelable(Pk1v1Data.class.getClassLoader());
            Long valueOf3 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Long valueOf4 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new Pk1v1Data(readString, readParcelable, valueOf2, readParcelable2, valueOf3, valueOf4, valueOf);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Pk1v1Data[] newArray(int i) {
            return new Pk1v1Data[i];
        }
    }

    public Pk1v1Data() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ Pk1v1Data copy$default(Pk1v1Data pk1v1Data, String str, User user, Long l, User user2, Long l2, Long l3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pk1v1Data.groupId;
        }
        if ((i & 2) != 0) {
            user = pk1v1Data.user1;
        }
        User user3 = user;
        if ((i & 4) != 0) {
            l = pk1v1Data.diamond1;
        }
        Long l4 = l;
        if ((i & 8) != 0) {
            user2 = pk1v1Data.user2;
        }
        User user4 = user2;
        if ((i & 16) != 0) {
            l2 = pk1v1Data.diamond2;
        }
        Long l5 = l2;
        if ((i & 32) != 0) {
            l3 = pk1v1Data.unix;
        }
        Long l6 = l3;
        if ((i & 64) != 0) {
            bool = pk1v1Data.start;
        }
        return pk1v1Data.copy(str, user3, l4, user4, l5, l6, bool);
    }

    public final boolean checkIsPk() {
        long j;
        Long l = this.unix;
        if (l != null) {
            if (l != null) {
                j = l.longValue();
            } else {
                j = 0;
            }
            if (j > V2TIMManager.getInstance().getServerTime()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final User getUser1() {
        return this.user1;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getDiamond1() {
        return this.diamond1;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final User getUser2() {
        return this.user2;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Long getDiamond2() {
        return this.diamond2;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Long getUnix() {
        return this.unix;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Boolean getStart() {
        return this.start;
    }

    @NotNull
    public final Pk1v1Data copy(@Nullable String groupId, @Nullable User user1, @Nullable Long diamond1, @Nullable User user2, @Nullable Long diamond2, @Nullable Long unix, @Nullable Boolean start) {
        return new Pk1v1Data(groupId, user1, diamond1, user2, diamond2, unix, start);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Pk1v1Data)) {
            return false;
        }
        Pk1v1Data pk1v1Data = (Pk1v1Data) other;
        return Intrinsics.areEqual(this.groupId, pk1v1Data.groupId) && Intrinsics.areEqual(this.user1, pk1v1Data.user1) && Intrinsics.areEqual(this.diamond1, pk1v1Data.diamond1) && Intrinsics.areEqual(this.user2, pk1v1Data.user2) && Intrinsics.areEqual(this.diamond2, pk1v1Data.diamond2) && Intrinsics.areEqual(this.unix, pk1v1Data.unix) && Intrinsics.areEqual(this.start, pk1v1Data.start);
    }

    @Nullable
    public final Long getDiamond1() {
        return this.diamond1;
    }

    @Nullable
    public final Long getDiamond2() {
        return this.diamond2;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final Boolean getStart() {
        return this.start;
    }

    @Nullable
    public final Long getUnix() {
        return this.unix;
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
        String str = this.groupId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        User user = this.user1;
        int hashCode2 = (hashCode + (user == null ? 0 : user.hashCode())) * 31;
        Long l = this.diamond1;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        User user2 = this.user2;
        int hashCode4 = (hashCode3 + (user2 == null ? 0 : user2.hashCode())) * 31;
        Long l2 = this.diamond2;
        int hashCode5 = (hashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.unix;
        int hashCode6 = (hashCode5 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Boolean bool = this.start;
        return hashCode6 + (bool != null ? bool.hashCode() : 0);
    }

    public final void setDiamond1(@Nullable Long l) {
        this.diamond1 = l;
    }

    public final void setDiamond2(@Nullable Long l) {
        this.diamond2 = l;
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    public final void setStart(@Nullable Boolean bool) {
        this.start = bool;
    }

    public final void setUnix(@Nullable Long l) {
        this.unix = l;
    }

    public final void setUser1(@Nullable User user) {
        this.user1 = user;
    }

    public final void setUser2(@Nullable User user) {
        this.user2 = user;
    }

    @NotNull
    public String toString() {
        return "Pk1v1Data(groupId=" + this.groupId + ", user1=" + this.user1 + ", diamond1=" + this.diamond1 + ", user2=" + this.user2 + ", diamond2=" + this.diamond2 + ", unix=" + this.unix + ", start=" + this.start + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.groupId);
        dest.writeParcelable(this.user1, flags);
        Long l = this.diamond1;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        dest.writeParcelable(this.user2, flags);
        Long l2 = this.diamond2;
        if (l2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l2.longValue());
        }
        Long l3 = this.unix;
        if (l3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l3.longValue());
        }
        Boolean bool = this.start;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
    }

    public Pk1v1Data(@Nullable String str, @Nullable User user, @Nullable Long l, @Nullable User user2, @Nullable Long l2, @Nullable Long l3, @Nullable Boolean bool) {
        this.groupId = str;
        this.user1 = user;
        this.diamond1 = l;
        this.user2 = user2;
        this.diamond2 = l2;
        this.unix = l3;
        this.start = bool;
    }

    public /* synthetic */ Pk1v1Data(String str, User user, Long l, User user2, Long l2, Long l3, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : user, (i & 4) != 0 ? 0L : l, (i & 8) != 0 ? null : user2, (i & 16) != 0 ? 0L : l2, (i & 32) == 0 ? l3 : null, (i & 64) != 0 ? Boolean.FALSE : bool);
    }
}
