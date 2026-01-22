package com.qiahao.nextvideo.ui.home.community;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/community/CommunityTabData;", "", "title", "", "selectColor", "defaultColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getSelectColor", "setSelectColor", "getDefaultColor", "setDefaultColor", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CommunityTabData {

    @Nullable
    private String defaultColor;

    @Nullable
    private String selectColor;

    @Nullable
    private String title;

    public CommunityTabData() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CommunityTabData copy$default(CommunityTabData communityTabData, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = communityTabData.title;
        }
        if ((i & 2) != 0) {
            str2 = communityTabData.selectColor;
        }
        if ((i & 4) != 0) {
            str3 = communityTabData.defaultColor;
        }
        return communityTabData.copy(str, str2, str3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getSelectColor() {
        return this.selectColor;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getDefaultColor() {
        return this.defaultColor;
    }

    @NotNull
    public final CommunityTabData copy(@Nullable String title, @Nullable String selectColor, @Nullable String defaultColor) {
        return new CommunityTabData(title, selectColor, defaultColor);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommunityTabData)) {
            return false;
        }
        CommunityTabData communityTabData = (CommunityTabData) other;
        return Intrinsics.areEqual(this.title, communityTabData.title) && Intrinsics.areEqual(this.selectColor, communityTabData.selectColor) && Intrinsics.areEqual(this.defaultColor, communityTabData.defaultColor);
    }

    @Nullable
    public final String getDefaultColor() {
        return this.defaultColor;
    }

    @Nullable
    public final String getSelectColor() {
        return this.selectColor;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.selectColor;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.defaultColor;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setDefaultColor(@Nullable String str) {
        this.defaultColor = str;
    }

    public final void setSelectColor(@Nullable String str) {
        this.selectColor = str;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    @NotNull
    public String toString() {
        return "CommunityTabData(title=" + this.title + ", selectColor=" + this.selectColor + ", defaultColor=" + this.defaultColor + ")";
    }

    public CommunityTabData(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.title = str;
        this.selectColor = str2;
        this.defaultColor = str3;
    }

    public /* synthetic */ CommunityTabData(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }
}
