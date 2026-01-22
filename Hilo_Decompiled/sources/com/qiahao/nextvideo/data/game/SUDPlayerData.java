package com.qiahao.nextvideo.data.game;

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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u0003J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u000b\"\u0004\b\u000e\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/qiahao/nextvideo/data/game/SUDPlayerData;", "Landroid/os/Parcelable;", "status", "", "isEscaped", "seatIdx", "userTiny", "Lcom/qiahao/base_common/model/common/User;", "<init>", "(IIILcom/qiahao/base_common/model/common/User;)V", "getStatus", "()I", "setStatus", "(I)V", "setEscaped", "getSeatIdx", "setSeatIdx", "getUserTiny", "()Lcom/qiahao/base_common/model/common/User;", "setUserTiny", "(Lcom/qiahao/base_common/model/common/User;)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class SUDPlayerData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SUDPlayerData> CREATOR = new Creator();
    private int isEscaped;
    private int seatIdx;
    private int status;

    @Nullable
    private User userTiny;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<SUDPlayerData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SUDPlayerData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SUDPlayerData(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readParcelable(SUDPlayerData.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SUDPlayerData[] newArray(int i) {
            return new SUDPlayerData[i];
        }
    }

    public SUDPlayerData() {
        this(0, 0, 0, null, 15, null);
    }

    public static /* synthetic */ SUDPlayerData copy$default(SUDPlayerData sUDPlayerData, int i, int i2, int i3, User user, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = sUDPlayerData.status;
        }
        if ((i4 & 2) != 0) {
            i2 = sUDPlayerData.isEscaped;
        }
        if ((i4 & 4) != 0) {
            i3 = sUDPlayerData.seatIdx;
        }
        if ((i4 & 8) != 0) {
            user = sUDPlayerData.userTiny;
        }
        return sUDPlayerData.copy(i, i2, i3, user);
    }

    /* renamed from: component1, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final int getIsEscaped() {
        return this.isEscaped;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSeatIdx() {
        return this.seatIdx;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final User getUserTiny() {
        return this.userTiny;
    }

    @NotNull
    public final SUDPlayerData copy(int status, int isEscaped, int seatIdx, @Nullable User userTiny) {
        return new SUDPlayerData(status, isEscaped, seatIdx, userTiny);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SUDPlayerData)) {
            return false;
        }
        SUDPlayerData sUDPlayerData = (SUDPlayerData) other;
        return this.status == sUDPlayerData.status && this.isEscaped == sUDPlayerData.isEscaped && this.seatIdx == sUDPlayerData.seatIdx && Intrinsics.areEqual(this.userTiny, sUDPlayerData.userTiny);
    }

    public final int getSeatIdx() {
        return this.seatIdx;
    }

    public final int getStatus() {
        return this.status;
    }

    @Nullable
    public final User getUserTiny() {
        return this.userTiny;
    }

    public int hashCode() {
        int i = ((((this.status * 31) + this.isEscaped) * 31) + this.seatIdx) * 31;
        User user = this.userTiny;
        return i + (user == null ? 0 : user.hashCode());
    }

    public final int isEscaped() {
        return this.isEscaped;
    }

    public final void setEscaped(int i) {
        this.isEscaped = i;
    }

    public final void setSeatIdx(int i) {
        this.seatIdx = i;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setUserTiny(@Nullable User user) {
        this.userTiny = user;
    }

    @NotNull
    public String toString() {
        return "SUDPlayerData(status=" + this.status + ", isEscaped=" + this.isEscaped + ", seatIdx=" + this.seatIdx + ", userTiny=" + this.userTiny + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.status);
        dest.writeInt(this.isEscaped);
        dest.writeInt(this.seatIdx);
        dest.writeParcelable(this.userTiny, flags);
    }

    public SUDPlayerData(int i, int i2, int i3, @Nullable User user) {
        this.status = i;
        this.isEscaped = i2;
        this.seatIdx = i3;
        this.userTiny = user;
    }

    public /* synthetic */ SUDPlayerData(int i, int i2, int i3, User user, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3, (i4 & 8) != 0 ? null : user);
    }
}
