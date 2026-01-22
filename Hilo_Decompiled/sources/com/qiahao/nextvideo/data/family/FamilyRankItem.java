package com.qiahao.nextvideo.data.family;

import android.os.Parcel;
import android.os.Parcelable;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b0\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010:\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010-J\u0086\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010<J\u0006\u0010=\u001a\u00020\u0007J\u0013\u0010>\u001a\u00020\u000f2\b\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\t\u0010A\u001a\u00020\u0007HÖ\u0001J\t\u0010B\u001a\u00020\u0005HÖ\u0001J\u0016\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0007R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010\u001aR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0018\"\u0004\b'\u0010\u001aR\u001e\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010\u0015R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001eR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006H"}, d2 = {"Lcom/qiahao/nextvideo/data/family/FamilyRankItem;", "Landroid/os/Parcelable;", "exp", "", "expireAt", "", "grade", "", AgooConstants.MESSAGE_ID, TUIConstants.TUIChat.INPUT_MORE_ICON, "name", "nameplate", "nextExp", "rank", "showExp", "", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getExp", "()Ljava/lang/Long;", "setExp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getExpireAt", "()Ljava/lang/String;", "setExpireAt", "(Ljava/lang/String;)V", "getGrade", "()Ljava/lang/Integer;", "setGrade", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getId", "setId", "getIcon", "setIcon", "getName", "setName", "getNameplate", "setNameplate", "getNextExp", "setNextExp", "getRank", "setRank", "getShowExp", "()Ljava/lang/Boolean;", "setShowExp", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/qiahao/nextvideo/data/family/FamilyRankItem;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class FamilyRankItem implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<FamilyRankItem> CREATOR = new Creator();

    @Nullable
    private Long exp;

    @Nullable
    private String expireAt;

    @Nullable
    private Integer grade;

    @Nullable
    private String icon;

    @Nullable
    private Long id;

    @Nullable
    private String name;

    @Nullable
    private String nameplate;

    @Nullable
    private Long nextExp;

    @Nullable
    private Integer rank;

    @Nullable
    private Boolean showExp;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<FamilyRankItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyRankItem createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Long valueOf2 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString = parcel.readString();
            Integer valueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Long valueOf4 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            Long valueOf5 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Integer valueOf6 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new FamilyRankItem(valueOf2, readString, valueOf3, valueOf4, readString2, readString3, readString4, valueOf5, valueOf6, valueOf);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyRankItem[] newArray(int i) {
            return new FamilyRankItem[i];
        }
    }

    public FamilyRankItem() {
        this(null, null, null, null, null, null, null, null, null, null, Message.EXT_HEADER_VALUE_MAX_LEN, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getExp() {
        return this.exp;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Boolean getShowExp() {
        return this.showExp;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getExpireAt() {
        return this.expireAt;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getGrade() {
        return this.grade;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getNameplate() {
        return this.nameplate;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Long getNextExp() {
        return this.nextExp;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Integer getRank() {
        return this.rank;
    }

    @NotNull
    public final FamilyRankItem copy(@Nullable Long exp, @Nullable String expireAt, @Nullable Integer grade, @Nullable Long id2, @Nullable String icon, @Nullable String name, @Nullable String nameplate, @Nullable Long nextExp, @Nullable Integer rank, @Nullable Boolean showExp) {
        return new FamilyRankItem(exp, expireAt, grade, id2, icon, name, nameplate, nextExp, rank, showExp);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FamilyRankItem)) {
            return false;
        }
        FamilyRankItem familyRankItem = (FamilyRankItem) other;
        return Intrinsics.areEqual(this.exp, familyRankItem.exp) && Intrinsics.areEqual(this.expireAt, familyRankItem.expireAt) && Intrinsics.areEqual(this.grade, familyRankItem.grade) && Intrinsics.areEqual(this.id, familyRankItem.id) && Intrinsics.areEqual(this.icon, familyRankItem.icon) && Intrinsics.areEqual(this.name, familyRankItem.name) && Intrinsics.areEqual(this.nameplate, familyRankItem.nameplate) && Intrinsics.areEqual(this.nextExp, familyRankItem.nextExp) && Intrinsics.areEqual(this.rank, familyRankItem.rank) && Intrinsics.areEqual(this.showExp, familyRankItem.showExp);
    }

    @Nullable
    public final Long getExp() {
        return this.exp;
    }

    @Nullable
    public final String getExpireAt() {
        return this.expireAt;
    }

    @Nullable
    public final Integer getGrade() {
        return this.grade;
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    public final Long getId() {
        return this.id;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getNameplate() {
        return this.nameplate;
    }

    @Nullable
    public final Long getNextExp() {
        return this.nextExp;
    }

    @Nullable
    public final Integer getRank() {
        return this.rank;
    }

    @Nullable
    public final Boolean getShowExp() {
        return this.showExp;
    }

    public int hashCode() {
        Long l = this.exp;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.expireAt;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.grade;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Long l2 = this.id;
        int hashCode4 = (hashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str2 = this.icon;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.nameplate;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l3 = this.nextExp;
        int hashCode8 = (hashCode7 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Integer num2 = this.rank;
        int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.showExp;
        return hashCode9 + (bool != null ? bool.hashCode() : 0);
    }

    public final void setExp(@Nullable Long l) {
        this.exp = l;
    }

    public final void setExpireAt(@Nullable String str) {
        this.expireAt = str;
    }

    public final void setGrade(@Nullable Integer num) {
        this.grade = num;
    }

    public final void setIcon(@Nullable String str) {
        this.icon = str;
    }

    public final void setId(@Nullable Long l) {
        this.id = l;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setNameplate(@Nullable String str) {
        this.nameplate = str;
    }

    public final void setNextExp(@Nullable Long l) {
        this.nextExp = l;
    }

    public final void setRank(@Nullable Integer num) {
        this.rank = num;
    }

    public final void setShowExp(@Nullable Boolean bool) {
        this.showExp = bool;
    }

    @NotNull
    public String toString() {
        return "FamilyRankItem(exp=" + this.exp + ", expireAt=" + this.expireAt + ", grade=" + this.grade + ", id=" + this.id + ", icon=" + this.icon + ", name=" + this.name + ", nameplate=" + this.nameplate + ", nextExp=" + this.nextExp + ", rank=" + this.rank + ", showExp=" + this.showExp + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Long l = this.exp;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        dest.writeString(this.expireAt);
        Integer num = this.grade;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Long l2 = this.id;
        if (l2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l2.longValue());
        }
        dest.writeString(this.icon);
        dest.writeString(this.name);
        dest.writeString(this.nameplate);
        Long l3 = this.nextExp;
        if (l3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l3.longValue());
        }
        Integer num2 = this.rank;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        Boolean bool = this.showExp;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
    }

    public FamilyRankItem(@Nullable Long l, @Nullable String str, @Nullable Integer num, @Nullable Long l2, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Long l3, @Nullable Integer num2, @Nullable Boolean bool) {
        this.exp = l;
        this.expireAt = str;
        this.grade = num;
        this.id = l2;
        this.icon = str2;
        this.name = str3;
        this.nameplate = str4;
        this.nextExp = l3;
        this.rank = num2;
        this.showExp = bool;
    }

    public /* synthetic */ FamilyRankItem(Long l, String str, Integer num, Long l2, String str2, String str3, String str4, Long l3, Integer num2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : l3, (i & 256) != 0 ? null : num2, (i & 512) == 0 ? bool : null);
    }
}
