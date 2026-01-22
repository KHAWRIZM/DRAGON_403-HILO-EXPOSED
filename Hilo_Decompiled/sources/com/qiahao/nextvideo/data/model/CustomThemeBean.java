package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/data/model/CustomThemeBean;", "", AgooConstants.MESSAGE_ID, "", "picUrl", "", "remainSecond", "", "<init>", "(ILjava/lang/String;J)V", "getId", "()I", "getPicUrl", "()Ljava/lang/String;", "getRemainSecond", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CustomThemeBean {
    private final int id;

    @NotNull
    private final String picUrl;
    private final long remainSecond;

    public CustomThemeBean(int i, @NotNull String str, long j) {
        Intrinsics.checkNotNullParameter(str, "picUrl");
        this.id = i;
        this.picUrl = str;
        this.remainSecond = j;
    }

    public static /* synthetic */ CustomThemeBean copy$default(CustomThemeBean customThemeBean, int i, String str, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = customThemeBean.id;
        }
        if ((i2 & 2) != 0) {
            str = customThemeBean.picUrl;
        }
        if ((i2 & 4) != 0) {
            j = customThemeBean.remainSecond;
        }
        return customThemeBean.copy(i, str, j);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final long getRemainSecond() {
        return this.remainSecond;
    }

    @NotNull
    public final CustomThemeBean copy(int id2, @NotNull String picUrl, long remainSecond) {
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        return new CustomThemeBean(id2, picUrl, remainSecond);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomThemeBean)) {
            return false;
        }
        CustomThemeBean customThemeBean = (CustomThemeBean) other;
        return this.id == customThemeBean.id && Intrinsics.areEqual(this.picUrl, customThemeBean.picUrl) && this.remainSecond == customThemeBean.remainSecond;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getPicUrl() {
        return this.picUrl;
    }

    public final long getRemainSecond() {
        return this.remainSecond;
    }

    public int hashCode() {
        return (((this.id * 31) + this.picUrl.hashCode()) * 31) + c.a(this.remainSecond);
    }

    @NotNull
    public String toString() {
        return "CustomThemeBean(id=" + this.id + ", picUrl=" + this.picUrl + ", remainSecond=" + this.remainSecond + ")";
    }
}
