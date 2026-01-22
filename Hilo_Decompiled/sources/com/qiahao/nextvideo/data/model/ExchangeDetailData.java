package com.qiahao.nextvideo.data.model;

import com.qiahao.nextvideo.ui.family.FamilySettingFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/qiahao/nextvideo/data/model/ExchangeDetailData;", "", "title", "", AgooConstants.MESSAGE_TIME, FamilySettingFragment.FAMILY_NUMBER, "isDiamond", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getTime", "setTime", "getNumber", "setNumber", "()Z", "setDiamond", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class ExchangeDetailData {
    private boolean isDiamond;

    @Nullable
    private String number;

    @Nullable
    private String time;

    @Nullable
    private String title;

    public ExchangeDetailData() {
        this(null, null, null, false, 15, null);
    }

    public static /* synthetic */ ExchangeDetailData copy$default(ExchangeDetailData exchangeDetailData, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = exchangeDetailData.title;
        }
        if ((i & 2) != 0) {
            str2 = exchangeDetailData.time;
        }
        if ((i & 4) != 0) {
            str3 = exchangeDetailData.number;
        }
        if ((i & 8) != 0) {
            z = exchangeDetailData.isDiamond;
        }
        return exchangeDetailData.copy(str, str2, str3, z);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getNumber() {
        return this.number;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsDiamond() {
        return this.isDiamond;
    }

    @NotNull
    public final ExchangeDetailData copy(@Nullable String title, @Nullable String time, @Nullable String number, boolean isDiamond) {
        return new ExchangeDetailData(title, time, number, isDiamond);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExchangeDetailData)) {
            return false;
        }
        ExchangeDetailData exchangeDetailData = (ExchangeDetailData) other;
        return Intrinsics.areEqual(this.title, exchangeDetailData.title) && Intrinsics.areEqual(this.time, exchangeDetailData.time) && Intrinsics.areEqual(this.number, exchangeDetailData.number) && this.isDiamond == exchangeDetailData.isDiamond;
    }

    @Nullable
    public final String getNumber() {
        return this.number;
    }

    @Nullable
    public final String getTime() {
        return this.time;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.time;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.number;
        return ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + a.a(this.isDiamond);
    }

    public final boolean isDiamond() {
        return this.isDiamond;
    }

    public final void setDiamond(boolean z) {
        this.isDiamond = z;
    }

    public final void setNumber(@Nullable String str) {
        this.number = str;
    }

    public final void setTime(@Nullable String str) {
        this.time = str;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    @NotNull
    public String toString() {
        return "ExchangeDetailData(title=" + this.title + ", time=" + this.time + ", number=" + this.number + ", isDiamond=" + this.isDiamond + ")";
    }

    public ExchangeDetailData(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z) {
        this.title = str;
        this.time = str2;
        this.number = str3;
        this.isDiamond = z;
    }

    public /* synthetic */ ExchangeDetailData(String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? true : z);
    }
}
