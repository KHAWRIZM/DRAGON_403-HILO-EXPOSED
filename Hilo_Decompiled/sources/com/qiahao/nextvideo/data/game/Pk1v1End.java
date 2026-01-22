package com.qiahao.nextvideo.data.game;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001dJJ\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020\nJ\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\nHÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u00064"}, d2 = {"Lcom/qiahao/nextvideo/data/game/Pk1v1End;", "Landroid/os/Parcelable;", "groupId", "", "winUser", "Lcom/qiahao/base_common/model/common/User;", ExchangeDetailActivity.TYPE_DIAMOND, "", "endUnix", "status", "", "<init>", "(Ljava/lang/String;Lcom/qiahao/base_common/model/common/User;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)V", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "getWinUser", "()Lcom/qiahao/base_common/model/common/User;", "setWinUser", "(Lcom/qiahao/base_common/model/common/User;)V", "getDiamond", "()Ljava/lang/Long;", "setDiamond", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getEndUnix", "setEndUnix", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Lcom/qiahao/base_common/model/common/User;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/game/Pk1v1End;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class Pk1v1End implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<Pk1v1End> CREATOR = new Creator();

    @Nullable
    private Long diamond;

    @Nullable
    private Long endUnix;

    @Nullable
    private String groupId;

    @Nullable
    private Integer status;

    @Nullable
    private User winUser;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<Pk1v1End> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Pk1v1End createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Pk1v1End(parcel.readString(), parcel.readParcelable(Pk1v1End.class.getClassLoader()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Pk1v1End[] newArray(int i) {
            return new Pk1v1End[i];
        }
    }

    public Pk1v1End() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ Pk1v1End copy$default(Pk1v1End pk1v1End, String str, User user, Long l, Long l2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pk1v1End.groupId;
        }
        if ((i & 2) != 0) {
            user = pk1v1End.winUser;
        }
        User user2 = user;
        if ((i & 4) != 0) {
            l = pk1v1End.diamond;
        }
        Long l3 = l;
        if ((i & 8) != 0) {
            l2 = pk1v1End.endUnix;
        }
        Long l4 = l2;
        if ((i & 16) != 0) {
            num = pk1v1End.status;
        }
        return pk1v1End.copy(str, user2, l3, l4, num);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final User getWinUser() {
        return this.winUser;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getDiamond() {
        return this.diamond;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getEndUnix() {
        return this.endUnix;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getStatus() {
        return this.status;
    }

    @NotNull
    public final Pk1v1End copy(@Nullable String groupId, @Nullable User winUser, @Nullable Long diamond, @Nullable Long endUnix, @Nullable Integer status) {
        return new Pk1v1End(groupId, winUser, diamond, endUnix, status);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Pk1v1End)) {
            return false;
        }
        Pk1v1End pk1v1End = (Pk1v1End) other;
        return Intrinsics.areEqual(this.groupId, pk1v1End.groupId) && Intrinsics.areEqual(this.winUser, pk1v1End.winUser) && Intrinsics.areEqual(this.diamond, pk1v1End.diamond) && Intrinsics.areEqual(this.endUnix, pk1v1End.endUnix) && Intrinsics.areEqual(this.status, pk1v1End.status);
    }

    @Nullable
    public final Long getDiamond() {
        return this.diamond;
    }

    @Nullable
    public final Long getEndUnix() {
        return this.endUnix;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final Integer getStatus() {
        return this.status;
    }

    @Nullable
    public final User getWinUser() {
        return this.winUser;
    }

    public int hashCode() {
        String str = this.groupId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        User user = this.winUser;
        int hashCode2 = (hashCode + (user == null ? 0 : user.hashCode())) * 31;
        Long l = this.diamond;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.endUnix;
        int hashCode4 = (hashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Integer num = this.status;
        return hashCode4 + (num != null ? num.hashCode() : 0);
    }

    public final void setDiamond(@Nullable Long l) {
        this.diamond = l;
    }

    public final void setEndUnix(@Nullable Long l) {
        this.endUnix = l;
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    public final void setStatus(@Nullable Integer num) {
        this.status = num;
    }

    public final void setWinUser(@Nullable User user) {
        this.winUser = user;
    }

    @NotNull
    public String toString() {
        return "Pk1v1End(groupId=" + this.groupId + ", winUser=" + this.winUser + ", diamond=" + this.diamond + ", endUnix=" + this.endUnix + ", status=" + this.status + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.groupId);
        dest.writeParcelable(this.winUser, flags);
        Long l = this.diamond;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        Long l2 = this.endUnix;
        if (l2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l2.longValue());
        }
        Integer num = this.status;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
    }

    public Pk1v1End(@Nullable String str, @Nullable User user, @Nullable Long l, @Nullable Long l2, @Nullable Integer num) {
        this.groupId = str;
        this.winUser = user;
        this.diamond = l;
        this.endUnix = l2;
        this.status = num;
    }

    public /* synthetic */ Pk1v1End(String str, User user, Long l, Long l2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : user, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : num);
    }
}
