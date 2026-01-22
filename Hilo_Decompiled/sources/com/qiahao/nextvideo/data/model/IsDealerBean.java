package com.qiahao.nextvideo.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.c;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.data.promote.PromoteData;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Parcelize
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00105\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u00106\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jf\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00108J\u0006\u00109\u001a\u00020\u000bJ\u0013\u0010:\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020\u000bHÖ\u0001J\t\u0010>\u001a\u00020?HÖ\u0001J\u0016\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006E"}, d2 = {"Lcom/qiahao/nextvideo/data/model/IsDealerBean;", "Landroid/os/Parcelable;", ExchangeDetailActivity.TYPE_DIAMOND, "", "diamondPink", "isdl", "", "hasInvite", "pt", "Lcom/qiahao/nextvideo/data/promote/PromoteData;", "level", "", "hasSecond", "plr", "Lcom/qiahao/base_common/model/common/User;", "<init>", "(JJZZLcom/qiahao/nextvideo/data/promote/PromoteData;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/qiahao/base_common/model/common/User;)V", "getDiamond", "()J", "setDiamond", "(J)V", "getDiamondPink", "setDiamondPink", "getIsdl", "()Z", "setIsdl", "(Z)V", "getHasInvite", "setHasInvite", "getPt", "()Lcom/qiahao/nextvideo/data/promote/PromoteData;", "setPt", "(Lcom/qiahao/nextvideo/data/promote/PromoteData;)V", "getLevel", "()Ljava/lang/Integer;", "setLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHasSecond", "()Ljava/lang/Boolean;", "setHasSecond", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getPlr", "()Lcom/qiahao/base_common/model/common/User;", "setPlr", "(Lcom/qiahao/base_common/model/common/User;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(JJZZLcom/qiahao/nextvideo/data/promote/PromoteData;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/qiahao/base_common/model/common/User;)Lcom/qiahao/nextvideo/data/model/IsDealerBean;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class IsDealerBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<IsDealerBean> CREATOR = new Creator();
    private long diamond;
    private long diamondPink;
    private boolean hasInvite;

    @Nullable
    private Boolean hasSecond;
    private boolean isdl;

    @Nullable
    private Integer level;

    @Nullable
    private User plr;

    @Nullable
    private PromoteData pt;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<IsDealerBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IsDealerBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            boolean z = parcel.readInt() != 0;
            boolean z2 = parcel.readInt() != 0;
            Boolean bool = null;
            PromoteData createFromParcel = parcel.readInt() == 0 ? null : PromoteData.CREATOR.createFromParcel(parcel);
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new IsDealerBean(readLong, readLong2, z, z2, createFromParcel, valueOf, bool, parcel.readParcelable(IsDealerBean.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IsDealerBean[] newArray(int i) {
            return new IsDealerBean[i];
        }
    }

    public IsDealerBean() {
        this(0L, 0L, false, false, null, null, null, null, 255, null);
    }

    /* renamed from: component1, reason: from getter */
    public final long getDiamond() {
        return this.diamond;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDiamondPink() {
        return this.diamondPink;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsdl() {
        return this.isdl;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getHasInvite() {
        return this.hasInvite;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final PromoteData getPt() {
        return this.pt;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Boolean getHasSecond() {
        return this.hasSecond;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final User getPlr() {
        return this.plr;
    }

    @NotNull
    public final IsDealerBean copy(long diamond, long diamondPink, boolean isdl, boolean hasInvite, @Nullable PromoteData pt, @Nullable Integer level, @Nullable Boolean hasSecond, @Nullable User plr) {
        return new IsDealerBean(diamond, diamondPink, isdl, hasInvite, pt, level, hasSecond, plr);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IsDealerBean)) {
            return false;
        }
        IsDealerBean isDealerBean = (IsDealerBean) other;
        return this.diamond == isDealerBean.diamond && this.diamondPink == isDealerBean.diamondPink && this.isdl == isDealerBean.isdl && this.hasInvite == isDealerBean.hasInvite && Intrinsics.areEqual(this.pt, isDealerBean.pt) && Intrinsics.areEqual(this.level, isDealerBean.level) && Intrinsics.areEqual(this.hasSecond, isDealerBean.hasSecond) && Intrinsics.areEqual(this.plr, isDealerBean.plr);
    }

    public final long getDiamond() {
        return this.diamond;
    }

    public final long getDiamondPink() {
        return this.diamondPink;
    }

    public final boolean getHasInvite() {
        return this.hasInvite;
    }

    @Nullable
    public final Boolean getHasSecond() {
        return this.hasSecond;
    }

    public final boolean getIsdl() {
        return this.isdl;
    }

    @Nullable
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    public final User getPlr() {
        return this.plr;
    }

    @Nullable
    public final PromoteData getPt() {
        return this.pt;
    }

    public int hashCode() {
        int a = ((((((c.a(this.diamond) * 31) + c.a(this.diamondPink)) * 31) + a.a(this.isdl)) * 31) + a.a(this.hasInvite)) * 31;
        PromoteData promoteData = this.pt;
        int hashCode = (a + (promoteData == null ? 0 : promoteData.hashCode())) * 31;
        Integer num = this.level;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.hasSecond;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        User user = this.plr;
        return hashCode3 + (user != null ? user.hashCode() : 0);
    }

    public final void setDiamond(long j) {
        this.diamond = j;
    }

    public final void setDiamondPink(long j) {
        this.diamondPink = j;
    }

    public final void setHasInvite(boolean z) {
        this.hasInvite = z;
    }

    public final void setHasSecond(@Nullable Boolean bool) {
        this.hasSecond = bool;
    }

    public final void setIsdl(boolean z) {
        this.isdl = z;
    }

    public final void setLevel(@Nullable Integer num) {
        this.level = num;
    }

    public final void setPlr(@Nullable User user) {
        this.plr = user;
    }

    public final void setPt(@Nullable PromoteData promoteData) {
        this.pt = promoteData;
    }

    @NotNull
    public String toString() {
        return "IsDealerBean(diamond=" + this.diamond + ", diamondPink=" + this.diamondPink + ", isdl=" + this.isdl + ", hasInvite=" + this.hasInvite + ", pt=" + this.pt + ", level=" + this.level + ", hasSecond=" + this.hasSecond + ", plr=" + this.plr + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.diamond);
        dest.writeLong(this.diamondPink);
        dest.writeInt(this.isdl ? 1 : 0);
        dest.writeInt(this.hasInvite ? 1 : 0);
        PromoteData promoteData = this.pt;
        if (promoteData == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            promoteData.writeToParcel(dest, flags);
        }
        Integer num = this.level;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Boolean bool = this.hasSecond;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        dest.writeParcelable(this.plr, flags);
    }

    public IsDealerBean(long j, long j2, boolean z, boolean z2, @Nullable PromoteData promoteData, @Nullable Integer num, @Nullable Boolean bool, @Nullable User user) {
        this.diamond = j;
        this.diamondPink = j2;
        this.isdl = z;
        this.hasInvite = z2;
        this.pt = promoteData;
        this.level = num;
        this.hasSecond = bool;
        this.plr = user;
    }

    public /* synthetic */ IsDealerBean(long j, long j2, boolean z, boolean z2, PromoteData promoteData, Integer num, Boolean bool, User user, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) == 0 ? j2 : 0L, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? null : promoteData, (i & 32) != 0 ? 0 : num, (i & 64) != 0 ? Boolean.FALSE : bool, (i & 128) == 0 ? user : null);
    }
}
