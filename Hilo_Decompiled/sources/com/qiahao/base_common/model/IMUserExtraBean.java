package com.qiahao.base_common.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003JN\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\tHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0002\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0004\u0010\rR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/qiahao/base_common/model/IMUserExtraBean;", "", "isVip", "", "isPretty", "medals", "", "", "powerName", "", "nobleLevel", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;I)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMedals", "()Ljava/util/List;", "getPowerName", "()Ljava/lang/String;", "getNobleLevel", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;I)Lcom/qiahao/base_common/model/IMUserExtraBean;", "equals", "other", "hashCode", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class IMUserExtraBean {

    @Nullable
    private final Boolean isPretty;

    @Nullable
    private final Boolean isVip;

    @Nullable
    private final List<Integer> medals;
    private final int nobleLevel;

    @Nullable
    private final String powerName;

    public IMUserExtraBean() {
        this(null, null, null, null, 0, 31, null);
    }

    public static /* synthetic */ IMUserExtraBean copy$default(IMUserExtraBean iMUserExtraBean, Boolean bool, Boolean bool2, List list, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = iMUserExtraBean.isVip;
        }
        if ((i11 & 2) != 0) {
            bool2 = iMUserExtraBean.isPretty;
        }
        Boolean bool3 = bool2;
        if ((i11 & 4) != 0) {
            list = iMUserExtraBean.medals;
        }
        List list2 = list;
        if ((i11 & 8) != 0) {
            str = iMUserExtraBean.powerName;
        }
        String str2 = str;
        if ((i11 & 16) != 0) {
            i10 = iMUserExtraBean.nobleLevel;
        }
        return iMUserExtraBean.copy(bool, bool3, list2, str2, i10);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Boolean getIsVip() {
        return this.isVip;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Boolean getIsPretty() {
        return this.isPretty;
    }

    @Nullable
    public final List<Integer> component3() {
        return this.medals;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getPowerName() {
        return this.powerName;
    }

    /* renamed from: component5, reason: from getter */
    public final int getNobleLevel() {
        return this.nobleLevel;
    }

    @NotNull
    public final IMUserExtraBean copy(@Nullable Boolean isVip, @Nullable Boolean isPretty, @Nullable List<Integer> medals, @Nullable String powerName, int nobleLevel) {
        return new IMUserExtraBean(isVip, isPretty, medals, powerName, nobleLevel);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IMUserExtraBean)) {
            return false;
        }
        IMUserExtraBean iMUserExtraBean = (IMUserExtraBean) other;
        return Intrinsics.areEqual(this.isVip, iMUserExtraBean.isVip) && Intrinsics.areEqual(this.isPretty, iMUserExtraBean.isPretty) && Intrinsics.areEqual(this.medals, iMUserExtraBean.medals) && Intrinsics.areEqual(this.powerName, iMUserExtraBean.powerName) && this.nobleLevel == iMUserExtraBean.nobleLevel;
    }

    @Nullable
    public final List<Integer> getMedals() {
        return this.medals;
    }

    public final int getNobleLevel() {
        return this.nobleLevel;
    }

    @Nullable
    public final String getPowerName() {
        return this.powerName;
    }

    public int hashCode() {
        Boolean bool = this.isVip;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.isPretty;
        int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        List<Integer> list = this.medals;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.powerName;
        return ((hashCode3 + (str != null ? str.hashCode() : 0)) * 31) + this.nobleLevel;
    }

    @Nullable
    public final Boolean isPretty() {
        return this.isPretty;
    }

    @Nullable
    public final Boolean isVip() {
        return this.isVip;
    }

    @NotNull
    public String toString() {
        return "IMUserExtraBean(isVip=" + this.isVip + ", isPretty=" + this.isPretty + ", medals=" + this.medals + ", powerName=" + this.powerName + ", nobleLevel=" + this.nobleLevel + ")";
    }

    public IMUserExtraBean(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable List<Integer> list, @Nullable String str, int i10) {
        this.isVip = bool;
        this.isPretty = bool2;
        this.medals = list;
        this.powerName = str;
        this.nobleLevel = i10;
    }

    public /* synthetic */ IMUserExtraBean(Boolean bool, Boolean bool2, List list, String str, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Boolean.FALSE : bool, (i11 & 2) != 0 ? Boolean.FALSE : bool2, (i11 & 4) != 0 ? null : list, (i11 & 8) == 0 ? str : null, (i11 & 16) != 0 ? 0 : i10);
    }
}
