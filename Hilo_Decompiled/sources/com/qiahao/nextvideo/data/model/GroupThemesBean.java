package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GroupThemesBean;", "", AgooConstants.MESSAGE_ID, "", "themeUrl", "", "<init>", "(ILjava/lang/String;)V", "getId", "()I", "getThemeUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GroupThemesBean {
    private final int id;

    @NotNull
    private final String themeUrl;

    public GroupThemesBean(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "themeUrl");
        this.id = i;
        this.themeUrl = str;
    }

    public static /* synthetic */ GroupThemesBean copy$default(GroupThemesBean groupThemesBean, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = groupThemesBean.id;
        }
        if ((i2 & 2) != 0) {
            str = groupThemesBean.themeUrl;
        }
        return groupThemesBean.copy(i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getThemeUrl() {
        return this.themeUrl;
    }

    @NotNull
    public final GroupThemesBean copy(int id2, @NotNull String themeUrl) {
        Intrinsics.checkNotNullParameter(themeUrl, "themeUrl");
        return new GroupThemesBean(id2, themeUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupThemesBean)) {
            return false;
        }
        GroupThemesBean groupThemesBean = (GroupThemesBean) other;
        return this.id == groupThemesBean.id && Intrinsics.areEqual(this.themeUrl, groupThemesBean.themeUrl);
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getThemeUrl() {
        return this.themeUrl;
    }

    public int hashCode() {
        return (this.id * 31) + this.themeUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "GroupThemesBean(id=" + this.id + ", themeUrl=" + this.themeUrl + ")";
    }
}
