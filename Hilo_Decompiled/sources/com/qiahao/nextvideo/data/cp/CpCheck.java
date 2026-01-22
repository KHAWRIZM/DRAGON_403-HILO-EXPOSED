package com.qiahao.nextvideo.data.cp;

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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001dHÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001dR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006)"}, d2 = {"Lcom/qiahao/nextvideo/data/cp/CpCheck;", "Landroid/os/Parcelable;", ExchangeDetailActivity.TYPE_DIAMOND, "", "msg", "", "user", "Lcom/qiahao/base_common/model/common/User;", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Lcom/qiahao/base_common/model/common/User;)V", "getDiamond", "()Ljava/lang/Long;", "setDiamond", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "setUser", "(Lcom/qiahao/base_common/model/common/User;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/String;Lcom/qiahao/base_common/model/common/User;)Lcom/qiahao/nextvideo/data/cp/CpCheck;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CpCheck implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<CpCheck> CREATOR = new Creator();

    @Nullable
    private Long diamond;

    @Nullable
    private String msg;

    @Nullable
    private User user;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<CpCheck> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CpCheck createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CpCheck(parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readParcelable(CpCheck.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CpCheck[] newArray(int i) {
            return new CpCheck[i];
        }
    }

    public CpCheck() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CpCheck copy$default(CpCheck cpCheck, Long l, String str, User user, int i, Object obj) {
        if ((i & 1) != 0) {
            l = cpCheck.diamond;
        }
        if ((i & 2) != 0) {
            str = cpCheck.msg;
        }
        if ((i & 4) != 0) {
            user = cpCheck.user;
        }
        return cpCheck.copy(l, str, user);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getDiamond() {
        return this.diamond;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    @NotNull
    public final CpCheck copy(@Nullable Long diamond, @Nullable String msg, @Nullable User user) {
        return new CpCheck(diamond, msg, user);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CpCheck)) {
            return false;
        }
        CpCheck cpCheck = (CpCheck) other;
        return Intrinsics.areEqual(this.diamond, cpCheck.diamond) && Intrinsics.areEqual(this.msg, cpCheck.msg) && Intrinsics.areEqual(this.user, cpCheck.user);
    }

    @Nullable
    public final Long getDiamond() {
        return this.diamond;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        Long l = this.diamond;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.msg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        User user = this.user;
        return hashCode2 + (user != null ? user.hashCode() : 0);
    }

    public final void setDiamond(@Nullable Long l) {
        this.diamond = l;
    }

    public final void setMsg(@Nullable String str) {
        this.msg = str;
    }

    public final void setUser(@Nullable User user) {
        this.user = user;
    }

    @NotNull
    public String toString() {
        return "CpCheck(diamond=" + this.diamond + ", msg=" + this.msg + ", user=" + this.user + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Long l = this.diamond;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        dest.writeString(this.msg);
        dest.writeParcelable(this.user, flags);
    }

    public CpCheck(@Nullable Long l, @Nullable String str, @Nullable User user) {
        this.diamond = l;
        this.msg = str;
        this.user = user;
    }

    public /* synthetic */ CpCheck(Long l, String str, User user, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : user);
    }
}
