package com.qiahao.nextvideo.data.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GroupMedalBean;", "Ljava/io/Serializable;", "picUrl", "", "svgaUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPicUrl", "()Ljava/lang/String;", "getSvgaUrl", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GroupMedalBean implements Serializable {

    @NotNull
    private final String picUrl;

    @NotNull
    private final String svgaUrl;

    public GroupMedalBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "picUrl");
        Intrinsics.checkNotNullParameter(str2, "svgaUrl");
        this.picUrl = str;
        this.svgaUrl = str2;
    }

    public static /* synthetic */ GroupMedalBean copy$default(GroupMedalBean groupMedalBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = groupMedalBean.picUrl;
        }
        if ((i & 2) != 0) {
            str2 = groupMedalBean.svgaUrl;
        }
        return groupMedalBean.copy(str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    @NotNull
    public final GroupMedalBean copy(@NotNull String picUrl, @NotNull String svgaUrl) {
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        Intrinsics.checkNotNullParameter(svgaUrl, "svgaUrl");
        return new GroupMedalBean(picUrl, svgaUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupMedalBean)) {
            return false;
        }
        GroupMedalBean groupMedalBean = (GroupMedalBean) other;
        return Intrinsics.areEqual(this.picUrl, groupMedalBean.picUrl) && Intrinsics.areEqual(this.svgaUrl, groupMedalBean.svgaUrl);
    }

    @NotNull
    public final String getPicUrl() {
        return this.picUrl;
    }

    @NotNull
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    public int hashCode() {
        return (this.picUrl.hashCode() * 31) + this.svgaUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "GroupMedalBean(picUrl=" + this.picUrl + ", svgaUrl=" + this.svgaUrl + ")";
    }
}
