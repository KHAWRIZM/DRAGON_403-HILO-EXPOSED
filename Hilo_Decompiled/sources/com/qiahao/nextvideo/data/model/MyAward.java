package com.qiahao.nextvideo.data.model;

import com.qiahao.nextvideo.ui.family.FamilySettingFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J8\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MyAward;", "", "awardType", "", FamilySettingFragment.FAMILY_NUMBER, "url", "", "hasAward", "", "<init>", "(IILjava/lang/String;Ljava/lang/Boolean;)V", "getAwardType", "()I", "getNumber", "getUrl", "()Ljava/lang/String;", "getHasAward", "()Ljava/lang/Boolean;", "setHasAward", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(IILjava/lang/String;Ljava/lang/Boolean;)Lcom/qiahao/nextvideo/data/model/MyAward;", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MyAward {
    private final int awardType;

    @Nullable
    private Boolean hasAward;
    private final int number;

    @NotNull
    private final String url;

    public MyAward(int i, int i2, @NotNull String str, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.awardType = i;
        this.number = i2;
        this.url = str;
        this.hasAward = bool;
    }

    public static /* synthetic */ MyAward copy$default(MyAward myAward, int i, int i2, String str, Boolean bool, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = myAward.awardType;
        }
        if ((i3 & 2) != 0) {
            i2 = myAward.number;
        }
        if ((i3 & 4) != 0) {
            str = myAward.url;
        }
        if ((i3 & 8) != 0) {
            bool = myAward.hasAward;
        }
        return myAward.copy(i, i2, str, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAwardType() {
        return this.awardType;
    }

    /* renamed from: component2, reason: from getter */
    public final int getNumber() {
        return this.number;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Boolean getHasAward() {
        return this.hasAward;
    }

    @NotNull
    public final MyAward copy(int awardType, int number, @NotNull String url, @Nullable Boolean hasAward) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new MyAward(awardType, number, url, hasAward);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyAward)) {
            return false;
        }
        MyAward myAward = (MyAward) other;
        return this.awardType == myAward.awardType && this.number == myAward.number && Intrinsics.areEqual(this.url, myAward.url) && Intrinsics.areEqual(this.hasAward, myAward.hasAward);
    }

    public final int getAwardType() {
        return this.awardType;
    }

    @Nullable
    public final Boolean getHasAward() {
        return this.hasAward;
    }

    public final int getNumber() {
        return this.number;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode = ((((this.awardType * 31) + this.number) * 31) + this.url.hashCode()) * 31;
        Boolean bool = this.hasAward;
        return hashCode + (bool == null ? 0 : bool.hashCode());
    }

    public final void setHasAward(@Nullable Boolean bool) {
        this.hasAward = bool;
    }

    @NotNull
    public String toString() {
        return "MyAward(awardType=" + this.awardType + ", number=" + this.number + ", url=" + this.url + ", hasAward=" + this.hasAward + ")";
    }

    public /* synthetic */ MyAward(int i, int i2, String str, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, str, (i3 & 8) != 0 ? null : bool);
    }
}
