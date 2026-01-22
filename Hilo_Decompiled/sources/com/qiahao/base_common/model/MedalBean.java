package com.qiahao.base_common.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/qiahao/base_common/model/MedalBean;", "", "medalId", "", "name", "", "picUrl", "svgaUrl", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMedalId", "()I", "getName", "()Ljava/lang/String;", "getPicUrl", "getSvgaUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class MedalBean {
    private final int medalId;

    @NotNull
    private final String name;

    @NotNull
    private final String picUrl;

    @NotNull
    private final String svgaUrl;

    public MedalBean(int i10, @NotNull String name, @NotNull String picUrl, @NotNull String svgaUrl) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        Intrinsics.checkNotNullParameter(svgaUrl, "svgaUrl");
        this.medalId = i10;
        this.name = name;
        this.picUrl = picUrl;
        this.svgaUrl = svgaUrl;
    }

    public static /* synthetic */ MedalBean copy$default(MedalBean medalBean, int i10, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = medalBean.medalId;
        }
        if ((i11 & 2) != 0) {
            str = medalBean.name;
        }
        if ((i11 & 4) != 0) {
            str2 = medalBean.picUrl;
        }
        if ((i11 & 8) != 0) {
            str3 = medalBean.svgaUrl;
        }
        return medalBean.copy(i10, str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMedalId() {
        return this.medalId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    @NotNull
    public final MedalBean copy(int medalId, @NotNull String name, @NotNull String picUrl, @NotNull String svgaUrl) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        Intrinsics.checkNotNullParameter(svgaUrl, "svgaUrl");
        return new MedalBean(medalId, name, picUrl, svgaUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MedalBean)) {
            return false;
        }
        MedalBean medalBean = (MedalBean) other;
        return this.medalId == medalBean.medalId && Intrinsics.areEqual(this.name, medalBean.name) && Intrinsics.areEqual(this.picUrl, medalBean.picUrl) && Intrinsics.areEqual(this.svgaUrl, medalBean.svgaUrl);
    }

    public final int getMedalId() {
        return this.medalId;
    }

    @NotNull
    public final String getName() {
        return this.name;
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
        return (((((this.medalId * 31) + this.name.hashCode()) * 31) + this.picUrl.hashCode()) * 31) + this.svgaUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "MedalBean(medalId=" + this.medalId + ", name=" + this.name + ", picUrl=" + this.picUrl + ", svgaUrl=" + this.svgaUrl + ")";
    }
}
