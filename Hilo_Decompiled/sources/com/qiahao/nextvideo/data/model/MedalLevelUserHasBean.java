package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003JY\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\nHÆ\u0001J\u0013\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\t\u0010(\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017¨\u0006)"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MedalLevelUserHasBean;", "Ljava/io/Serializable;", "threshold", "", "canHas", "", AgooConstants.MESSAGE_ID, "", "isHas", "noPicUrl", "", "yesPicUrl", "svgaUrl", "desc", "<init>", "(JZIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getThreshold", "()J", "getCanHas", "()Z", "getId", "()I", "getNoPicUrl", "()Ljava/lang/String;", "getYesPicUrl", "getSvgaUrl", "getDesc", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MedalLevelUserHasBean implements Serializable {
    private final boolean canHas;

    @NotNull
    private final String desc;
    private final int id;
    private final boolean isHas;

    @NotNull
    private final String noPicUrl;

    @NotNull
    private final String svgaUrl;
    private final long threshold;

    @NotNull
    private final String yesPicUrl;

    public MedalLevelUserHasBean(long j, boolean z, int i, boolean z2, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "noPicUrl");
        Intrinsics.checkNotNullParameter(str2, "yesPicUrl");
        Intrinsics.checkNotNullParameter(str3, "svgaUrl");
        Intrinsics.checkNotNullParameter(str4, "desc");
        this.threshold = j;
        this.canHas = z;
        this.id = i;
        this.isHas = z2;
        this.noPicUrl = str;
        this.yesPicUrl = str2;
        this.svgaUrl = str3;
        this.desc = str4;
    }

    /* renamed from: component1, reason: from getter */
    public final long getThreshold() {
        return this.threshold;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getCanHas() {
        return this.canHas;
    }

    /* renamed from: component3, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsHas() {
        return this.isHas;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getNoPicUrl() {
        return this.noPicUrl;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getYesPicUrl() {
        return this.yesPicUrl;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final MedalLevelUserHasBean copy(long threshold, boolean canHas, int id2, boolean isHas, @NotNull String noPicUrl, @NotNull String yesPicUrl, @NotNull String svgaUrl, @NotNull String desc) {
        Intrinsics.checkNotNullParameter(noPicUrl, "noPicUrl");
        Intrinsics.checkNotNullParameter(yesPicUrl, "yesPicUrl");
        Intrinsics.checkNotNullParameter(svgaUrl, "svgaUrl");
        Intrinsics.checkNotNullParameter(desc, "desc");
        return new MedalLevelUserHasBean(threshold, canHas, id2, isHas, noPicUrl, yesPicUrl, svgaUrl, desc);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MedalLevelUserHasBean)) {
            return false;
        }
        MedalLevelUserHasBean medalLevelUserHasBean = (MedalLevelUserHasBean) other;
        return this.threshold == medalLevelUserHasBean.threshold && this.canHas == medalLevelUserHasBean.canHas && this.id == medalLevelUserHasBean.id && this.isHas == medalLevelUserHasBean.isHas && Intrinsics.areEqual(this.noPicUrl, medalLevelUserHasBean.noPicUrl) && Intrinsics.areEqual(this.yesPicUrl, medalLevelUserHasBean.yesPicUrl) && Intrinsics.areEqual(this.svgaUrl, medalLevelUserHasBean.svgaUrl) && Intrinsics.areEqual(this.desc, medalLevelUserHasBean.desc);
    }

    public final boolean getCanHas() {
        return this.canHas;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getNoPicUrl() {
        return this.noPicUrl;
    }

    @NotNull
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    public final long getThreshold() {
        return this.threshold;
    }

    @NotNull
    public final String getYesPicUrl() {
        return this.yesPicUrl;
    }

    public int hashCode() {
        return (((((((((((((c.a(this.threshold) * 31) + a.a(this.canHas)) * 31) + this.id) * 31) + a.a(this.isHas)) * 31) + this.noPicUrl.hashCode()) * 31) + this.yesPicUrl.hashCode()) * 31) + this.svgaUrl.hashCode()) * 31) + this.desc.hashCode();
    }

    public final boolean isHas() {
        return this.isHas;
    }

    @NotNull
    public String toString() {
        return "MedalLevelUserHasBean(threshold=" + this.threshold + ", canHas=" + this.canHas + ", id=" + this.id + ", isHas=" + this.isHas + ", noPicUrl=" + this.noPicUrl + ", yesPicUrl=" + this.yesPicUrl + ", svgaUrl=" + this.svgaUrl + ", desc=" + this.desc + ")";
    }
}
