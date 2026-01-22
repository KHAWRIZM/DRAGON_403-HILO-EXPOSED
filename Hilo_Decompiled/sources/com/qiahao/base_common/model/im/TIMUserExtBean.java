package com.qiahao.base_common.model.im;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.entity.EventType;
import com.qiahao.base_common.model.svip.SvipData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0011\u0010A\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010E\u001a\u00020\tHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0011\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\bHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010*J¨\u0001\u0010J\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010KJ\u0006\u0010L\u001a\u00020\tJ\u0013\u0010M\u001a\u00020\u00052\b\u0010N\u001a\u0004\u0018\u00010OHÖ\u0003J\t\u0010P\u001a\u00020\tHÖ\u0001J\t\u0010Q\u001a\u00020\u000bHÖ\u0001J\u0016\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\tR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u0004\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u0006\u0010\u001c\"\u0004\b \u0010\u001eR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010\f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b.\u0010\u0018\"\u0004\b/\u0010\u001aR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\"\"\u0004\b9\u0010$R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010&\"\u0004\b;\u0010(R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b<\u0010*\"\u0004\b=\u0010,¨\u0006W"}, d2 = {"Lcom/qiahao/base_common/model/im/TIMUserExtBean;", "Landroid/os/Parcelable;", "charmGrade", "", "isPretty", "", "isVip", "medals", "", "", "powerName", "", "nobleLevel", "wealthGrade", "svipLevel", "svip", "Lcom/qiahao/base_common/model/svip/SvipData;", "mentionUsers", "Lcom/qiahao/base_common/model/im/TIMUserBean;", "powerNameplate", "powerGrade", "<init>", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;ILcom/qiahao/base_common/model/svip/SvipData;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;)V", "getCharmGrade", "()Ljava/lang/Long;", "setCharmGrade", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "()Ljava/lang/Boolean;", "setPretty", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setVip", "getMedals", "()Ljava/util/List;", "setMedals", "(Ljava/util/List;)V", "getPowerName", "()Ljava/lang/String;", "setPowerName", "(Ljava/lang/String;)V", "getNobleLevel", "()Ljava/lang/Integer;", "setNobleLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getWealthGrade", "setWealthGrade", "getSvipLevel", "()I", "setSvipLevel", "(I)V", "getSvip", "()Lcom/qiahao/base_common/model/svip/SvipData;", "setSvip", "(Lcom/qiahao/base_common/model/svip/SvipData;)V", "getMentionUsers", "setMentionUsers", "getPowerNameplate", "setPowerNameplate", "getPowerGrade", "setPowerGrade", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;ILcom/qiahao/base_common/model/svip/SvipData;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;)Lcom/qiahao/base_common/model/im/TIMUserExtBean;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class TIMUserExtBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<TIMUserExtBean> CREATOR = new Creator();

    @Nullable
    private Long charmGrade;

    @Nullable
    private Boolean isPretty;

    @Nullable
    private Boolean isVip;

    @Nullable
    private List<Integer> medals;

    @Nullable
    private List<TIMUserBean> mentionUsers;

    @Nullable
    private Integer nobleLevel;

    @Nullable
    private Integer powerGrade;

    @Nullable
    private String powerName;

    @Nullable
    private String powerNameplate;

    @Nullable
    private SvipData svip;
    private int svipLevel;

    @Nullable
    private Long wealthGrade;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<TIMUserExtBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TIMUserExtBean createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Long valueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Boolean valueOf2 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            Boolean valueOf3 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(Integer.valueOf(parcel.readInt()));
                }
            }
            String readString = parcel.readString();
            Integer valueOf4 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Long valueOf5 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            int readInt2 = parcel.readInt();
            SvipData createFromParcel = parcel.readInt() == 0 ? null : SvipData.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int readInt3 = parcel.readInt();
                arrayList2 = new ArrayList(readInt3);
                for (int i11 = 0; i11 != readInt3; i11++) {
                    arrayList2.add(TIMUserBean.CREATOR.createFromParcel(parcel));
                }
            }
            return new TIMUserExtBean(valueOf, valueOf2, valueOf3, arrayList, readString, valueOf4, valueOf5, readInt2, createFromParcel, arrayList2, parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TIMUserExtBean[] newArray(int i10) {
            return new TIMUserExtBean[i10];
        }
    }

    public TIMUserExtBean() {
        this(null, null, null, null, null, null, null, 0, null, null, null, null, EventType.ALL, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getCharmGrade() {
        return this.charmGrade;
    }

    @Nullable
    public final List<TIMUserBean> component10() {
        return this.mentionUsers;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getPowerNameplate() {
        return this.powerNameplate;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Integer getPowerGrade() {
        return this.powerGrade;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Boolean getIsPretty() {
        return this.isPretty;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Boolean getIsVip() {
        return this.isVip;
    }

    @Nullable
    public final List<Integer> component4() {
        return this.medals;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getPowerName() {
        return this.powerName;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Integer getNobleLevel() {
        return this.nobleLevel;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Long getWealthGrade() {
        return this.wealthGrade;
    }

    /* renamed from: component8, reason: from getter */
    public final int getSvipLevel() {
        return this.svipLevel;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final SvipData getSvip() {
        return this.svip;
    }

    @NotNull
    public final TIMUserExtBean copy(@Nullable Long charmGrade, @Nullable Boolean isPretty, @Nullable Boolean isVip, @Nullable List<Integer> medals, @Nullable String powerName, @Nullable Integer nobleLevel, @Nullable Long wealthGrade, int svipLevel, @Nullable SvipData svip, @Nullable List<TIMUserBean> mentionUsers, @Nullable String powerNameplate, @Nullable Integer powerGrade) {
        return new TIMUserExtBean(charmGrade, isPretty, isVip, medals, powerName, nobleLevel, wealthGrade, svipLevel, svip, mentionUsers, powerNameplate, powerGrade);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TIMUserExtBean)) {
            return false;
        }
        TIMUserExtBean tIMUserExtBean = (TIMUserExtBean) other;
        return Intrinsics.areEqual(this.charmGrade, tIMUserExtBean.charmGrade) && Intrinsics.areEqual(this.isPretty, tIMUserExtBean.isPretty) && Intrinsics.areEqual(this.isVip, tIMUserExtBean.isVip) && Intrinsics.areEqual(this.medals, tIMUserExtBean.medals) && Intrinsics.areEqual(this.powerName, tIMUserExtBean.powerName) && Intrinsics.areEqual(this.nobleLevel, tIMUserExtBean.nobleLevel) && Intrinsics.areEqual(this.wealthGrade, tIMUserExtBean.wealthGrade) && this.svipLevel == tIMUserExtBean.svipLevel && Intrinsics.areEqual(this.svip, tIMUserExtBean.svip) && Intrinsics.areEqual(this.mentionUsers, tIMUserExtBean.mentionUsers) && Intrinsics.areEqual(this.powerNameplate, tIMUserExtBean.powerNameplate) && Intrinsics.areEqual(this.powerGrade, tIMUserExtBean.powerGrade);
    }

    @Nullable
    public final Long getCharmGrade() {
        return this.charmGrade;
    }

    @Nullable
    public final List<Integer> getMedals() {
        return this.medals;
    }

    @Nullable
    public final List<TIMUserBean> getMentionUsers() {
        return this.mentionUsers;
    }

    @Nullable
    public final Integer getNobleLevel() {
        return this.nobleLevel;
    }

    @Nullable
    public final Integer getPowerGrade() {
        return this.powerGrade;
    }

    @Nullable
    public final String getPowerName() {
        return this.powerName;
    }

    @Nullable
    public final String getPowerNameplate() {
        return this.powerNameplate;
    }

    @Nullable
    public final SvipData getSvip() {
        return this.svip;
    }

    public final int getSvipLevel() {
        return this.svipLevel;
    }

    @Nullable
    public final Long getWealthGrade() {
        return this.wealthGrade;
    }

    public int hashCode() {
        Long l10 = this.charmGrade;
        int hashCode = (l10 == null ? 0 : l10.hashCode()) * 31;
        Boolean bool = this.isPretty;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isVip;
        int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        List<Integer> list = this.medals;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.powerName;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.nobleLevel;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        Long l11 = this.wealthGrade;
        int hashCode7 = (((hashCode6 + (l11 == null ? 0 : l11.hashCode())) * 31) + this.svipLevel) * 31;
        SvipData svipData = this.svip;
        int hashCode8 = (hashCode7 + (svipData == null ? 0 : svipData.hashCode())) * 31;
        List<TIMUserBean> list2 = this.mentionUsers;
        int hashCode9 = (hashCode8 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str2 = this.powerNameplate;
        int hashCode10 = (hashCode9 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num2 = this.powerGrade;
        return hashCode10 + (num2 != null ? num2.hashCode() : 0);
    }

    @Nullable
    public final Boolean isPretty() {
        return this.isPretty;
    }

    @Nullable
    public final Boolean isVip() {
        return this.isVip;
    }

    public final void setCharmGrade(@Nullable Long l10) {
        this.charmGrade = l10;
    }

    public final void setMedals(@Nullable List<Integer> list) {
        this.medals = list;
    }

    public final void setMentionUsers(@Nullable List<TIMUserBean> list) {
        this.mentionUsers = list;
    }

    public final void setNobleLevel(@Nullable Integer num) {
        this.nobleLevel = num;
    }

    public final void setPowerGrade(@Nullable Integer num) {
        this.powerGrade = num;
    }

    public final void setPowerName(@Nullable String str) {
        this.powerName = str;
    }

    public final void setPowerNameplate(@Nullable String str) {
        this.powerNameplate = str;
    }

    public final void setPretty(@Nullable Boolean bool) {
        this.isPretty = bool;
    }

    public final void setSvip(@Nullable SvipData svipData) {
        this.svip = svipData;
    }

    public final void setSvipLevel(int i10) {
        this.svipLevel = i10;
    }

    public final void setVip(@Nullable Boolean bool) {
        this.isVip = bool;
    }

    public final void setWealthGrade(@Nullable Long l10) {
        this.wealthGrade = l10;
    }

    @NotNull
    public String toString() {
        return "TIMUserExtBean(charmGrade=" + this.charmGrade + ", isPretty=" + this.isPretty + ", isVip=" + this.isVip + ", medals=" + this.medals + ", powerName=" + this.powerName + ", nobleLevel=" + this.nobleLevel + ", wealthGrade=" + this.wealthGrade + ", svipLevel=" + this.svipLevel + ", svip=" + this.svip + ", mentionUsers=" + this.mentionUsers + ", powerNameplate=" + this.powerNameplate + ", powerGrade=" + this.powerGrade + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Long l10 = this.charmGrade;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        Boolean bool = this.isPretty;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.isVip;
        if (bool2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        List<Integer> list = this.medals;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                dest.writeInt(it.next().intValue());
            }
        }
        dest.writeString(this.powerName);
        Integer num = this.nobleLevel;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Long l11 = this.wealthGrade;
        if (l11 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l11.longValue());
        }
        dest.writeInt(this.svipLevel);
        SvipData svipData = this.svip;
        if (svipData == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            svipData.writeToParcel(dest, flags);
        }
        List<TIMUserBean> list2 = this.mentionUsers;
        if (list2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list2.size());
            Iterator<TIMUserBean> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(dest, flags);
            }
        }
        dest.writeString(this.powerNameplate);
        Integer num2 = this.powerGrade;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
    }

    public TIMUserExtBean(@Nullable Long l10, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable List<Integer> list, @Nullable String str, @Nullable Integer num, @Nullable Long l11, int i10, @Nullable SvipData svipData, @Nullable List<TIMUserBean> list2, @Nullable String str2, @Nullable Integer num2) {
        this.charmGrade = l10;
        this.isPretty = bool;
        this.isVip = bool2;
        this.medals = list;
        this.powerName = str;
        this.nobleLevel = num;
        this.wealthGrade = l11;
        this.svipLevel = i10;
        this.svip = svipData;
        this.mentionUsers = list2;
        this.powerNameplate = str2;
        this.powerGrade = num2;
    }

    public /* synthetic */ TIMUserExtBean(Long l10, Boolean bool, Boolean bool2, List list, String str, Integer num, Long l11, int i10, SvipData svipData, List list2, String str2, Integer num2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : l10, (i11 & 2) != 0 ? null : bool, (i11 & 4) != 0 ? null : bool2, (i11 & 8) != 0 ? null : list, (i11 & 16) != 0 ? null : str, (i11 & 32) != 0 ? null : num, (i11 & 64) != 0 ? null : l11, (i11 & 128) != 0 ? 0 : i10, (i11 & 256) != 0 ? null : svipData, (i11 & 512) != 0 ? null : list2, (i11 & 1024) != 0 ? null : str2, (i11 & 2048) == 0 ? num2 : null);
    }
}
