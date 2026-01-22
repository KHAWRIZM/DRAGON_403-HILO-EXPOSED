package com.qiahao.base_common.model.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.AuthenticationTokenClaims;
import com.liulishuo.okdownload.DownloadTask;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\bR\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B×\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0007HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010U\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010V\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00109J\u0010\u0010W\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010X\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\\\u001a\u00020\u0007HÆ\u0003J\t\u0010]\u001a\u00020\u0010HÆ\u0003Jà\u0001\u0010^\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u0010HÆ\u0001¢\u0006\u0002\u0010_J\u0006\u0010`\u001a\u00020\u0007J\u0013\u0010a\u001a\u00020\u00102\b\u0010b\u001a\u0004\u0018\u00010cHÖ\u0003J\t\u0010d\u001a\u00020\u0007HÖ\u0001J\t\u0010e\u001a\u00020\u0005HÖ\u0001J\u0016\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020\u0007R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010 \"\u0004\b-\u0010\"R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010 \"\u0004\b/\u0010\"R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b4\u0010\u001b\"\u0004\b5\u0010\u001dR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b6\u0010$\"\u0004\b7\u0010&R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b=\u0010$\"\u0004\b>\u0010&R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b?\u0010$\"\u0004\b@\u0010&R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010 \"\u0004\bB\u0010\"R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010 \"\u0004\bD\u0010\"R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010 \"\u0004\bF\u0010\"R\u001a\u0010\u0016\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u00101\"\u0004\bH\u00103R\u001a\u0010\u0017\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010I\"\u0004\bJ\u0010K¨\u0006k"}, d2 = {"Lcom/qiahao/base_common/model/common/FamilyInfo;", "Landroid/os/Parcelable;", AuthenticationTokenClaims.JSON_KEY_EXP, "", "expireAt", "", "grade", "", "id", "icon", "name", "nameplate", "monthRank", "nextExp", "rank", "showExp", "", "memberMax", "memberNum", "gradeMedal", "gradeName", "declaration", "role", "isApply", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "getExp", "()Ljava/lang/Long;", "setExp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getExpireAt", "()Ljava/lang/String;", "setExpireAt", "(Ljava/lang/String;)V", "getGrade", "()Ljava/lang/Integer;", "setGrade", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getId", "setId", "getIcon", "setIcon", "getName", "setName", "getNameplate", "setNameplate", "getMonthRank", "()I", "setMonthRank", "(I)V", "getNextExp", "setNextExp", "getRank", "setRank", "getShowExp", "()Ljava/lang/Boolean;", "setShowExp", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMemberMax", "setMemberMax", "getMemberNum", "setMemberNum", "getGradeMedal", "setGradeMedal", "getGradeName", "setGradeName", "getDeclaration", "setDeclaration", "getRole", "setRole", "()Z", "setApply", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)Lcom/qiahao/base_common/model/common/FamilyInfo;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class FamilyInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<FamilyInfo> CREATOR = new Creator();

    @Nullable
    private String declaration;

    @Nullable
    private Long exp;

    @Nullable
    private String expireAt;

    @Nullable
    private Integer grade;

    @Nullable
    private String gradeMedal;

    @Nullable
    private String gradeName;

    @Nullable
    private String icon;

    @Nullable
    private Long id;
    private boolean isApply;

    @Nullable
    private Integer memberMax;

    @Nullable
    private Integer memberNum;
    private int monthRank;

    @Nullable
    private String name;

    @Nullable
    private String nameplate;

    @Nullable
    private Long nextExp;

    @Nullable
    private Integer rank;
    private int role;

    @Nullable
    private Boolean showExp;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<FamilyInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyInfo createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Long valueOf2 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString = parcel.readString();
            Integer valueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Long valueOf4 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            int readInt = parcel.readInt();
            Long valueOf5 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Integer valueOf6 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new FamilyInfo(valueOf2, readString, valueOf3, valueOf4, readString2, readString3, readString4, readInt, valueOf5, valueOf6, valueOf, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyInfo[] newArray(int i10) {
            return new FamilyInfo[i10];
        }
    }

    public FamilyInfo(@Nullable Long l10, @Nullable String str, @Nullable Integer num, @Nullable Long l11, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i10, @Nullable Long l12, @Nullable Integer num2, @Nullable Boolean bool, @Nullable Integer num3, @Nullable Integer num4, @Nullable String str5, @Nullable String str6, @Nullable String str7, int i11, boolean z10) {
        this.exp = l10;
        this.expireAt = str;
        this.grade = num;
        this.id = l11;
        this.icon = str2;
        this.name = str3;
        this.nameplate = str4;
        this.monthRank = i10;
        this.nextExp = l12;
        this.rank = num2;
        this.showExp = bool;
        this.memberMax = num3;
        this.memberNum = num4;
        this.gradeMedal = str5;
        this.gradeName = str6;
        this.declaration = str7;
        this.role = i11;
        this.isApply = z10;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getExp() {
        return this.exp;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Integer getRank() {
        return this.rank;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Boolean getShowExp() {
        return this.showExp;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Integer getMemberMax() {
        return this.memberMax;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final Integer getMemberNum() {
        return this.memberNum;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final String getGradeMedal() {
        return this.gradeMedal;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final String getGradeName() {
        return this.gradeName;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final String getDeclaration() {
        return this.declaration;
    }

    /* renamed from: component17, reason: from getter */
    public final int getRole() {
        return this.role;
    }

    /* renamed from: component18, reason: from getter */
    public final boolean getIsApply() {
        return this.isApply;
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

    /* renamed from: component8, reason: from getter */
    public final int getMonthRank() {
        return this.monthRank;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Long getNextExp() {
        return this.nextExp;
    }

    @NotNull
    public final FamilyInfo copy(@Nullable Long exp, @Nullable String expireAt, @Nullable Integer grade, @Nullable Long id, @Nullable String icon, @Nullable String name, @Nullable String nameplate, int monthRank, @Nullable Long nextExp, @Nullable Integer rank, @Nullable Boolean showExp, @Nullable Integer memberMax, @Nullable Integer memberNum, @Nullable String gradeMedal, @Nullable String gradeName, @Nullable String declaration, int role, boolean isApply) {
        return new FamilyInfo(exp, expireAt, grade, id, icon, name, nameplate, monthRank, nextExp, rank, showExp, memberMax, memberNum, gradeMedal, gradeName, declaration, role, isApply);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FamilyInfo)) {
            return false;
        }
        FamilyInfo familyInfo = (FamilyInfo) other;
        return Intrinsics.areEqual(this.exp, familyInfo.exp) && Intrinsics.areEqual(this.expireAt, familyInfo.expireAt) && Intrinsics.areEqual(this.grade, familyInfo.grade) && Intrinsics.areEqual(this.id, familyInfo.id) && Intrinsics.areEqual(this.icon, familyInfo.icon) && Intrinsics.areEqual(this.name, familyInfo.name) && Intrinsics.areEqual(this.nameplate, familyInfo.nameplate) && this.monthRank == familyInfo.monthRank && Intrinsics.areEqual(this.nextExp, familyInfo.nextExp) && Intrinsics.areEqual(this.rank, familyInfo.rank) && Intrinsics.areEqual(this.showExp, familyInfo.showExp) && Intrinsics.areEqual(this.memberMax, familyInfo.memberMax) && Intrinsics.areEqual(this.memberNum, familyInfo.memberNum) && Intrinsics.areEqual(this.gradeMedal, familyInfo.gradeMedal) && Intrinsics.areEqual(this.gradeName, familyInfo.gradeName) && Intrinsics.areEqual(this.declaration, familyInfo.declaration) && this.role == familyInfo.role && this.isApply == familyInfo.isApply;
    }

    @Nullable
    public final String getDeclaration() {
        return this.declaration;
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
    public final String getGradeMedal() {
        return this.gradeMedal;
    }

    @Nullable
    public final String getGradeName() {
        return this.gradeName;
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
    public final Integer getMemberMax() {
        return this.memberMax;
    }

    @Nullable
    public final Integer getMemberNum() {
        return this.memberNum;
    }

    public final int getMonthRank() {
        return this.monthRank;
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

    public final int getRole() {
        return this.role;
    }

    @Nullable
    public final Boolean getShowExp() {
        return this.showExp;
    }

    public int hashCode() {
        Long l10 = this.exp;
        int hashCode = (l10 == null ? 0 : l10.hashCode()) * 31;
        String str = this.expireAt;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.grade;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Long l11 = this.id;
        int hashCode4 = (hashCode3 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str2 = this.icon;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.nameplate;
        int hashCode7 = (((hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.monthRank) * 31;
        Long l12 = this.nextExp;
        int hashCode8 = (hashCode7 + (l12 == null ? 0 : l12.hashCode())) * 31;
        Integer num2 = this.rank;
        int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.showExp;
        int hashCode10 = (hashCode9 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num3 = this.memberMax;
        int hashCode11 = (hashCode10 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.memberNum;
        int hashCode12 = (hashCode11 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str5 = this.gradeMedal;
        int hashCode13 = (hashCode12 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.gradeName;
        int hashCode14 = (hashCode13 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.declaration;
        return ((((hashCode14 + (str7 != null ? str7.hashCode() : 0)) * 31) + this.role) * 31) + a.a(this.isApply);
    }

    public final boolean isApply() {
        return this.isApply;
    }

    public final void setApply(boolean z10) {
        this.isApply = z10;
    }

    public final void setDeclaration(@Nullable String str) {
        this.declaration = str;
    }

    public final void setExp(@Nullable Long l10) {
        this.exp = l10;
    }

    public final void setExpireAt(@Nullable String str) {
        this.expireAt = str;
    }

    public final void setGrade(@Nullable Integer num) {
        this.grade = num;
    }

    public final void setGradeMedal(@Nullable String str) {
        this.gradeMedal = str;
    }

    public final void setGradeName(@Nullable String str) {
        this.gradeName = str;
    }

    public final void setIcon(@Nullable String str) {
        this.icon = str;
    }

    public final void setId(@Nullable Long l10) {
        this.id = l10;
    }

    public final void setMemberMax(@Nullable Integer num) {
        this.memberMax = num;
    }

    public final void setMemberNum(@Nullable Integer num) {
        this.memberNum = num;
    }

    public final void setMonthRank(int i10) {
        this.monthRank = i10;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setNameplate(@Nullable String str) {
        this.nameplate = str;
    }

    public final void setNextExp(@Nullable Long l10) {
        this.nextExp = l10;
    }

    public final void setRank(@Nullable Integer num) {
        this.rank = num;
    }

    public final void setRole(int i10) {
        this.role = i10;
    }

    public final void setShowExp(@Nullable Boolean bool) {
        this.showExp = bool;
    }

    @NotNull
    public String toString() {
        return "FamilyInfo(exp=" + this.exp + ", expireAt=" + this.expireAt + ", grade=" + this.grade + ", id=" + this.id + ", icon=" + this.icon + ", name=" + this.name + ", nameplate=" + this.nameplate + ", monthRank=" + this.monthRank + ", nextExp=" + this.nextExp + ", rank=" + this.rank + ", showExp=" + this.showExp + ", memberMax=" + this.memberMax + ", memberNum=" + this.memberNum + ", gradeMedal=" + this.gradeMedal + ", gradeName=" + this.gradeName + ", declaration=" + this.declaration + ", role=" + this.role + ", isApply=" + this.isApply + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Long l10 = this.exp;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        dest.writeString(this.expireAt);
        Integer num = this.grade;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Long l11 = this.id;
        if (l11 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l11.longValue());
        }
        dest.writeString(this.icon);
        dest.writeString(this.name);
        dest.writeString(this.nameplate);
        dest.writeInt(this.monthRank);
        Long l12 = this.nextExp;
        if (l12 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l12.longValue());
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
        Integer num3 = this.memberMax;
        if (num3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num3.intValue());
        }
        Integer num4 = this.memberNum;
        if (num4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num4.intValue());
        }
        dest.writeString(this.gradeMedal);
        dest.writeString(this.gradeName);
        dest.writeString(this.declaration);
        dest.writeInt(this.role);
        dest.writeInt(this.isApply ? 1 : 0);
    }

    public /* synthetic */ FamilyInfo(Long l10, String str, Integer num, Long l11, String str2, String str3, String str4, int i10, Long l12, Integer num2, Boolean bool, Integer num3, Integer num4, String str5, String str6, String str7, int i11, boolean z10, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? null : l10, (i12 & 2) != 0 ? null : str, (i12 & 4) != 0 ? null : num, (i12 & 8) != 0 ? null : l11, (i12 & 16) != 0 ? null : str2, (i12 & 32) != 0 ? null : str3, (i12 & 64) != 0 ? null : str4, (i12 & 128) != 0 ? 0 : i10, (i12 & 256) != 0 ? null : l12, (i12 & 512) != 0 ? null : num2, (i12 & 1024) != 0 ? null : bool, (i12 & 2048) != 0 ? null : num3, (i12 & 4096) != 0 ? null : num4, (i12 & 8192) != 0 ? null : str5, (i12 & DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE) != 0 ? null : str6, (32768 & i12) != 0 ? null : str7, (i12 & 65536) != 0 ? 0 : i11, z10);
    }
}
