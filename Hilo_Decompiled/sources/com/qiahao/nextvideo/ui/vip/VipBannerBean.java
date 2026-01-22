package com.qiahao.nextvideo.ui.vip;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/ui/vip/VipBannerBean;", "", "bannerIcon", "", "title", "", "content", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getBannerIcon", "()I", "setBannerIcon", "(I)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getContent", "setContent", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class VipBannerBean {
    private int bannerIcon;

    @NotNull
    private String content;

    @NotNull
    private String title;

    public VipBannerBean(int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "content");
        this.bannerIcon = i;
        this.title = str;
        this.content = str2;
    }

    public static /* synthetic */ VipBannerBean copy$default(VipBannerBean vipBannerBean, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = vipBannerBean.bannerIcon;
        }
        if ((i2 & 2) != 0) {
            str = vipBannerBean.title;
        }
        if ((i2 & 4) != 0) {
            str2 = vipBannerBean.content;
        }
        return vipBannerBean.copy(i, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getBannerIcon() {
        return this.bannerIcon;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final VipBannerBean copy(int bannerIcon, @NotNull String title, @NotNull String content) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        return new VipBannerBean(bannerIcon, title, content);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VipBannerBean)) {
            return false;
        }
        VipBannerBean vipBannerBean = (VipBannerBean) other;
        return this.bannerIcon == vipBannerBean.bannerIcon && Intrinsics.areEqual(this.title, vipBannerBean.title) && Intrinsics.areEqual(this.content, vipBannerBean.content);
    }

    public final int getBannerIcon() {
        return this.bannerIcon;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((this.bannerIcon * 31) + this.title.hashCode()) * 31) + this.content.hashCode();
    }

    public final void setBannerIcon(int i) {
        this.bannerIcon = i;
    }

    public final void setContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    @NotNull
    public String toString() {
        return "VipBannerBean(bannerIcon=" + this.bannerIcon + ", title=" + this.title + ", content=" + this.content + ")";
    }
}
