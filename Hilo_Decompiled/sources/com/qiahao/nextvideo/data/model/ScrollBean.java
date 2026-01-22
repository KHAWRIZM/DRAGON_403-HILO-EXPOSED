package com.qiahao.nextvideo.data.model;

import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/data/model/ScrollBean;", "", "avatar", "", ExchangeDetailActivity.TYPE_DIAMOND, "nick", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getDiamond", "getNick", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class ScrollBean {

    @NotNull
    private final String avatar;

    @NotNull
    private final String diamond;

    @NotNull
    private final String nick;

    public ScrollBean(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, ExchangeDetailActivity.TYPE_DIAMOND);
        Intrinsics.checkNotNullParameter(str3, "nick");
        this.avatar = str;
        this.diamond = str2;
        this.nick = str3;
    }

    public static /* synthetic */ ScrollBean copy$default(ScrollBean scrollBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = scrollBean.avatar;
        }
        if ((i & 2) != 0) {
            str2 = scrollBean.diamond;
        }
        if ((i & 4) != 0) {
            str3 = scrollBean.nick;
        }
        return scrollBean.copy(str, str2, str3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getDiamond() {
        return this.diamond;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    @NotNull
    public final ScrollBean copy(@NotNull String avatar, @NotNull String diamond, @NotNull String nick) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(diamond, ExchangeDetailActivity.TYPE_DIAMOND);
        Intrinsics.checkNotNullParameter(nick, "nick");
        return new ScrollBean(avatar, diamond, nick);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScrollBean)) {
            return false;
        }
        ScrollBean scrollBean = (ScrollBean) other;
        return Intrinsics.areEqual(this.avatar, scrollBean.avatar) && Intrinsics.areEqual(this.diamond, scrollBean.diamond) && Intrinsics.areEqual(this.nick, scrollBean.nick);
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final String getDiamond() {
        return this.diamond;
    }

    @NotNull
    public final String getNick() {
        return this.nick;
    }

    public int hashCode() {
        return (((this.avatar.hashCode() * 31) + this.diamond.hashCode()) * 31) + this.nick.hashCode();
    }

    @NotNull
    public String toString() {
        return "ScrollBean(avatar=" + this.avatar + ", diamond=" + this.diamond + ", nick=" + this.nick + ")";
    }
}
