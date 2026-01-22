package com.qiahao.base_common.model.im;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.qiahao.base_common.model.common.User;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Parcelize
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\nJ\u0006\u0010+\u001a\u00020\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001dJ\t\u00101\u001a\u00020\u0003HÆ\u0003JN\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u00103J\u0006\u00104\u001a\u00020\u0003J\u0013\u00105\u001a\u00020\b2\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020\u0005HÖ\u0001J\u0016\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006?"}, d2 = {"Lcom/qiahao/base_common/model/im/StrangeChange;", "Landroid/os/Parcelable;", "closeType", "", "closeExternalId", "", FirebaseAnalytics.Param.SCORE, "unlock", "", "closeTimeUnix", "", "scoreUnlock", "<init>", "(ILjava/lang/String;IZLjava/lang/Long;I)V", "getCloseType", "()I", "setCloseType", "(I)V", "getCloseExternalId", "()Ljava/lang/String;", "setCloseExternalId", "(Ljava/lang/String;)V", "getScore", "setScore", "getUnlock", "()Z", "setUnlock", "(Z)V", "getCloseTimeUnix", "()Ljava/lang/Long;", "setCloseTimeUnix", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getScoreUnlock", "setScoreUnlock", "mOtherUser", "Lcom/qiahao/base_common/model/common/User;", "getMOtherUser", "()Lcom/qiahao/base_common/model/common/User;", "setMOtherUser", "(Lcom/qiahao/base_common/model/common/User;)V", "getCountDownTimer", "currentTime", "getScoreProcess", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;IZLjava/lang/Long;I)Lcom/qiahao/base_common/model/im/StrangeChange;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class StrangeChange implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<StrangeChange> CREATOR = new Creator();

    @Nullable
    private String closeExternalId;

    @Nullable
    private Long closeTimeUnix;
    private int closeType;

    @Nullable
    private User mOtherUser;
    private int score;
    private int scoreUnlock;
    private boolean unlock;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<StrangeChange> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StrangeChange createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new StrangeChange(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StrangeChange[] newArray(int i10) {
            return new StrangeChange[i10];
        }
    }

    public StrangeChange() {
        this(0, null, 0, false, null, 0, 63, null);
    }

    public static /* synthetic */ StrangeChange copy$default(StrangeChange strangeChange, int i10, String str, int i11, boolean z10, Long l10, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = strangeChange.closeType;
        }
        if ((i13 & 2) != 0) {
            str = strangeChange.closeExternalId;
        }
        String str2 = str;
        if ((i13 & 4) != 0) {
            i11 = strangeChange.score;
        }
        int i14 = i11;
        if ((i13 & 8) != 0) {
            z10 = strangeChange.unlock;
        }
        boolean z11 = z10;
        if ((i13 & 16) != 0) {
            l10 = strangeChange.closeTimeUnix;
        }
        Long l11 = l10;
        if ((i13 & 32) != 0) {
            i12 = strangeChange.scoreUnlock;
        }
        return strangeChange.copy(i10, str2, i14, z11, l11, i12);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCloseType() {
        return this.closeType;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getCloseExternalId() {
        return this.closeExternalId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getScore() {
        return this.score;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getUnlock() {
        return this.unlock;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Long getCloseTimeUnix() {
        return this.closeTimeUnix;
    }

    /* renamed from: component6, reason: from getter */
    public final int getScoreUnlock() {
        return this.scoreUnlock;
    }

    @NotNull
    public final StrangeChange copy(int closeType, @Nullable String closeExternalId, int score, boolean unlock, @Nullable Long closeTimeUnix, int scoreUnlock) {
        return new StrangeChange(closeType, closeExternalId, score, unlock, closeTimeUnix, scoreUnlock);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StrangeChange)) {
            return false;
        }
        StrangeChange strangeChange = (StrangeChange) other;
        return this.closeType == strangeChange.closeType && Intrinsics.areEqual(this.closeExternalId, strangeChange.closeExternalId) && this.score == strangeChange.score && this.unlock == strangeChange.unlock && Intrinsics.areEqual(this.closeTimeUnix, strangeChange.closeTimeUnix) && this.scoreUnlock == strangeChange.scoreUnlock;
    }

    @Nullable
    public final String getCloseExternalId() {
        return this.closeExternalId;
    }

    @Nullable
    public final Long getCloseTimeUnix() {
        return this.closeTimeUnix;
    }

    public final int getCloseType() {
        return this.closeType;
    }

    public final long getCountDownTimer(long currentTime) {
        long j10;
        Long l10 = this.closeTimeUnix;
        if (l10 != null) {
            j10 = l10.longValue();
        } else {
            j10 = 0;
        }
        long j11 = j10 - currentTime;
        if (j11 < 0) {
            return 0L;
        }
        return j11;
    }

    @Nullable
    public final User getMOtherUser() {
        return this.mOtherUser;
    }

    public final int getScore() {
        return this.score;
    }

    public final int getScoreProcess() {
        int i10 = (this.score * 100) / this.scoreUnlock;
        if (i10 > 100) {
            return 100;
        }
        if (i10 < 0) {
            return 0;
        }
        return i10;
    }

    public final int getScoreUnlock() {
        return this.scoreUnlock;
    }

    public final boolean getUnlock() {
        return this.unlock;
    }

    public int hashCode() {
        int i10 = this.closeType * 31;
        String str = this.closeExternalId;
        int hashCode = (((((i10 + (str == null ? 0 : str.hashCode())) * 31) + this.score) * 31) + a.a(this.unlock)) * 31;
        Long l10 = this.closeTimeUnix;
        return ((hashCode + (l10 != null ? l10.hashCode() : 0)) * 31) + this.scoreUnlock;
    }

    public final void setCloseExternalId(@Nullable String str) {
        this.closeExternalId = str;
    }

    public final void setCloseTimeUnix(@Nullable Long l10) {
        this.closeTimeUnix = l10;
    }

    public final void setCloseType(int i10) {
        this.closeType = i10;
    }

    public final void setMOtherUser(@Nullable User user) {
        this.mOtherUser = user;
    }

    public final void setScore(int i10) {
        this.score = i10;
    }

    public final void setScoreUnlock(int i10) {
        this.scoreUnlock = i10;
    }

    public final void setUnlock(boolean z10) {
        this.unlock = z10;
    }

    @NotNull
    public String toString() {
        return "StrangeChange(closeType=" + this.closeType + ", closeExternalId=" + this.closeExternalId + ", score=" + this.score + ", unlock=" + this.unlock + ", closeTimeUnix=" + this.closeTimeUnix + ", scoreUnlock=" + this.scoreUnlock + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.closeType);
        dest.writeString(this.closeExternalId);
        dest.writeInt(this.score);
        dest.writeInt(this.unlock ? 1 : 0);
        Long l10 = this.closeTimeUnix;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        dest.writeInt(this.scoreUnlock);
    }

    public StrangeChange(int i10, @Nullable String str, int i11, boolean z10, @Nullable Long l10, int i12) {
        this.closeType = i10;
        this.closeExternalId = str;
        this.score = i11;
        this.unlock = z10;
        this.closeTimeUnix = l10;
        this.scoreUnlock = i12;
    }

    public /* synthetic */ StrangeChange(int i10, String str, int i11, boolean z10, Long l10, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0 : i10, (i13 & 2) != 0 ? null : str, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? false : z10, (i13 & 16) == 0 ? l10 : null, (i13 & 32) != 0 ? 0 : i12);
    }
}
