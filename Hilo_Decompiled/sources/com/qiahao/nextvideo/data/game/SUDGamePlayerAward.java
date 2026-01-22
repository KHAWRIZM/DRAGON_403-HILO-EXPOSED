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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018JD\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020\u0003J\u0013\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\b\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006/"}, d2 = {"Lcom/qiahao/nextvideo/data/game/SUDGamePlayerAward;", "Landroid/os/Parcelable;", "rank", "", "score", ExchangeDetailActivity.TYPE_DIAMOND, "userTiny", "Lcom/qiahao/base_common/model/common/User;", "isWin", "", "<init>", "(IIILcom/qiahao/base_common/model/common/User;Ljava/lang/Boolean;)V", "getRank", "()I", "setRank", "(I)V", "getScore", "setScore", "getDiamond", "setDiamond", "getUserTiny", "()Lcom/qiahao/base_common/model/common/User;", "setUserTiny", "(Lcom/qiahao/base_common/model/common/User;)V", "()Ljava/lang/Boolean;", "setWin", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(IIILcom/qiahao/base_common/model/common/User;Ljava/lang/Boolean;)Lcom/qiahao/nextvideo/data/game/SUDGamePlayerAward;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class SUDGamePlayerAward implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SUDGamePlayerAward> CREATOR = new Creator();
    private int diamond;

    @Nullable
    private Boolean isWin;
    private int rank;
    private int score;

    @Nullable
    private User userTiny;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<SUDGamePlayerAward> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SUDGamePlayerAward createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            User readParcelable = parcel.readParcelable(SUDGamePlayerAward.class.getClassLoader());
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new SUDGamePlayerAward(readInt, readInt2, readInt3, readParcelable, valueOf);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SUDGamePlayerAward[] newArray(int i) {
            return new SUDGamePlayerAward[i];
        }
    }

    public SUDGamePlayerAward() {
        this(0, 0, 0, null, null, 31, null);
    }

    public static /* synthetic */ SUDGamePlayerAward copy$default(SUDGamePlayerAward sUDGamePlayerAward, int i, int i2, int i3, User user, Boolean bool, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = sUDGamePlayerAward.rank;
        }
        if ((i4 & 2) != 0) {
            i2 = sUDGamePlayerAward.score;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = sUDGamePlayerAward.diamond;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            user = sUDGamePlayerAward.userTiny;
        }
        User user2 = user;
        if ((i4 & 16) != 0) {
            bool = sUDGamePlayerAward.isWin;
        }
        return sUDGamePlayerAward.copy(i, i5, i6, user2, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final int getRank() {
        return this.rank;
    }

    /* renamed from: component2, reason: from getter */
    public final int getScore() {
        return this.score;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDiamond() {
        return this.diamond;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final User getUserTiny() {
        return this.userTiny;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Boolean getIsWin() {
        return this.isWin;
    }

    @NotNull
    public final SUDGamePlayerAward copy(int rank, int score, int diamond, @Nullable User userTiny, @Nullable Boolean isWin) {
        return new SUDGamePlayerAward(rank, score, diamond, userTiny, isWin);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SUDGamePlayerAward)) {
            return false;
        }
        SUDGamePlayerAward sUDGamePlayerAward = (SUDGamePlayerAward) other;
        return this.rank == sUDGamePlayerAward.rank && this.score == sUDGamePlayerAward.score && this.diamond == sUDGamePlayerAward.diamond && Intrinsics.areEqual(this.userTiny, sUDGamePlayerAward.userTiny) && Intrinsics.areEqual(this.isWin, sUDGamePlayerAward.isWin);
    }

    public final int getDiamond() {
        return this.diamond;
    }

    public final int getRank() {
        return this.rank;
    }

    public final int getScore() {
        return this.score;
    }

    @Nullable
    public final User getUserTiny() {
        return this.userTiny;
    }

    public int hashCode() {
        int i = ((((this.rank * 31) + this.score) * 31) + this.diamond) * 31;
        User user = this.userTiny;
        int hashCode = (i + (user == null ? 0 : user.hashCode())) * 31;
        Boolean bool = this.isWin;
        return hashCode + (bool != null ? bool.hashCode() : 0);
    }

    @Nullable
    public final Boolean isWin() {
        return this.isWin;
    }

    public final void setDiamond(int i) {
        this.diamond = i;
    }

    public final void setRank(int i) {
        this.rank = i;
    }

    public final void setScore(int i) {
        this.score = i;
    }

    public final void setUserTiny(@Nullable User user) {
        this.userTiny = user;
    }

    public final void setWin(@Nullable Boolean bool) {
        this.isWin = bool;
    }

    @NotNull
    public String toString() {
        return "SUDGamePlayerAward(rank=" + this.rank + ", score=" + this.score + ", diamond=" + this.diamond + ", userTiny=" + this.userTiny + ", isWin=" + this.isWin + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        int i;
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.rank);
        dest.writeInt(this.score);
        dest.writeInt(this.diamond);
        dest.writeParcelable(this.userTiny, flags);
        Boolean bool = this.isWin;
        if (bool == null) {
            i = 0;
        } else {
            dest.writeInt(1);
            i = bool.booleanValue();
        }
        dest.writeInt(i);
    }

    public SUDGamePlayerAward(int i, int i2, int i3, @Nullable User user, @Nullable Boolean bool) {
        this.rank = i;
        this.score = i2;
        this.diamond = i3;
        this.userTiny = user;
        this.isWin = bool;
    }

    public /* synthetic */ SUDGamePlayerAward(int i, int i2, int i3, User user, Boolean bool, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) == 0 ? i3 : 0, (i4 & 8) != 0 ? null : user, (i4 & 16) != 0 ? Boolean.FALSE : bool);
    }
}
