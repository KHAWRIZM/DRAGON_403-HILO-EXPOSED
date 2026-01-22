package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006\""}, d2 = {"Lcom/qiahao/nextvideo/data/model/MatchSetTypes;", "", "globalFee", "", "useBalanceSexMatchFee", "useFemaleMatchFee", "useMaleMatchFee", "userCountryFee", "<init>", "(IIIII)V", "getGlobalFee", "()I", "setGlobalFee", "(I)V", "getUseBalanceSexMatchFee", "setUseBalanceSexMatchFee", "getUseFemaleMatchFee", "setUseFemaleMatchFee", "getUseMaleMatchFee", "setUseMaleMatchFee", "getUserCountryFee", "setUserCountryFee", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MatchSetTypes {

    @c("globalFee")
    private int globalFee;

    @c("useBalanceSexMatchFee")
    private int useBalanceSexMatchFee;

    @c("useFemaleMatchFee")
    private int useFemaleMatchFee;

    @c("useMaleMatchFee")
    private int useMaleMatchFee;

    @c("userCountryFee")
    private int userCountryFee;

    public MatchSetTypes(int i, int i2, int i3, int i4, int i5) {
        this.globalFee = i;
        this.useBalanceSexMatchFee = i2;
        this.useFemaleMatchFee = i3;
        this.useMaleMatchFee = i4;
        this.userCountryFee = i5;
    }

    public static /* synthetic */ MatchSetTypes copy$default(MatchSetTypes matchSetTypes, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = matchSetTypes.globalFee;
        }
        if ((i6 & 2) != 0) {
            i2 = matchSetTypes.useBalanceSexMatchFee;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            i3 = matchSetTypes.useFemaleMatchFee;
        }
        int i8 = i3;
        if ((i6 & 8) != 0) {
            i4 = matchSetTypes.useMaleMatchFee;
        }
        int i9 = i4;
        if ((i6 & 16) != 0) {
            i5 = matchSetTypes.userCountryFee;
        }
        return matchSetTypes.copy(i, i7, i8, i9, i5);
    }

    /* renamed from: component1, reason: from getter */
    public final int getGlobalFee() {
        return this.globalFee;
    }

    /* renamed from: component2, reason: from getter */
    public final int getUseBalanceSexMatchFee() {
        return this.useBalanceSexMatchFee;
    }

    /* renamed from: component3, reason: from getter */
    public final int getUseFemaleMatchFee() {
        return this.useFemaleMatchFee;
    }

    /* renamed from: component4, reason: from getter */
    public final int getUseMaleMatchFee() {
        return this.useMaleMatchFee;
    }

    /* renamed from: component5, reason: from getter */
    public final int getUserCountryFee() {
        return this.userCountryFee;
    }

    @NotNull
    public final MatchSetTypes copy(int globalFee, int useBalanceSexMatchFee, int useFemaleMatchFee, int useMaleMatchFee, int userCountryFee) {
        return new MatchSetTypes(globalFee, useBalanceSexMatchFee, useFemaleMatchFee, useMaleMatchFee, userCountryFee);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatchSetTypes)) {
            return false;
        }
        MatchSetTypes matchSetTypes = (MatchSetTypes) other;
        return this.globalFee == matchSetTypes.globalFee && this.useBalanceSexMatchFee == matchSetTypes.useBalanceSexMatchFee && this.useFemaleMatchFee == matchSetTypes.useFemaleMatchFee && this.useMaleMatchFee == matchSetTypes.useMaleMatchFee && this.userCountryFee == matchSetTypes.userCountryFee;
    }

    public final int getGlobalFee() {
        return this.globalFee;
    }

    public final int getUseBalanceSexMatchFee() {
        return this.useBalanceSexMatchFee;
    }

    public final int getUseFemaleMatchFee() {
        return this.useFemaleMatchFee;
    }

    public final int getUseMaleMatchFee() {
        return this.useMaleMatchFee;
    }

    public final int getUserCountryFee() {
        return this.userCountryFee;
    }

    public int hashCode() {
        return (((((((this.globalFee * 31) + this.useBalanceSexMatchFee) * 31) + this.useFemaleMatchFee) * 31) + this.useMaleMatchFee) * 31) + this.userCountryFee;
    }

    public final void setGlobalFee(int i) {
        this.globalFee = i;
    }

    public final void setUseBalanceSexMatchFee(int i) {
        this.useBalanceSexMatchFee = i;
    }

    public final void setUseFemaleMatchFee(int i) {
        this.useFemaleMatchFee = i;
    }

    public final void setUseMaleMatchFee(int i) {
        this.useMaleMatchFee = i;
    }

    public final void setUserCountryFee(int i) {
        this.userCountryFee = i;
    }

    @NotNull
    public String toString() {
        return "MatchSetTypes(globalFee=" + this.globalFee + ", useBalanceSexMatchFee=" + this.useBalanceSexMatchFee + ", useFemaleMatchFee=" + this.useFemaleMatchFee + ", useMaleMatchFee=" + this.useMaleMatchFee + ", userCountryFee=" + this.userCountryFee + ")";
    }
}
