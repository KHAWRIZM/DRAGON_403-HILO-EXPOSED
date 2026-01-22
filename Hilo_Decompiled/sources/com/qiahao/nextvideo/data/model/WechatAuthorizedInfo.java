package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/data/model/WechatAuthorizedInfo;", "", "accessToken", "", "expiresIn", "", "openid", "refreshToken", "scope", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "getExpiresIn", "()I", "getOpenid", "getRefreshToken", "getScope", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class WechatAuthorizedInfo {

    @NotNull
    @c("access_token")
    private final String accessToken;

    @c("expires_in")
    private final int expiresIn;

    @NotNull
    @c("openid")
    private final String openid;

    @NotNull
    @c("refresh_token")
    private final String refreshToken;

    @NotNull
    @c("scope")
    private final String scope;

    public WechatAuthorizedInfo(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "accessToken");
        Intrinsics.checkNotNullParameter(str2, "openid");
        Intrinsics.checkNotNullParameter(str3, "refreshToken");
        Intrinsics.checkNotNullParameter(str4, "scope");
        this.accessToken = str;
        this.expiresIn = i;
        this.openid = str2;
        this.refreshToken = str3;
        this.scope = str4;
    }

    public static /* synthetic */ WechatAuthorizedInfo copy$default(WechatAuthorizedInfo wechatAuthorizedInfo, String str, int i, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = wechatAuthorizedInfo.accessToken;
        }
        if ((i2 & 2) != 0) {
            i = wechatAuthorizedInfo.expiresIn;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str2 = wechatAuthorizedInfo.openid;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            str3 = wechatAuthorizedInfo.refreshToken;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = wechatAuthorizedInfo.scope;
        }
        return wechatAuthorizedInfo.copy(str, i3, str5, str6, str4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* renamed from: component2, reason: from getter */
    public final int getExpiresIn() {
        return this.expiresIn;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getOpenid() {
        return this.openid;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getScope() {
        return this.scope;
    }

    @NotNull
    public final WechatAuthorizedInfo copy(@NotNull String accessToken, int expiresIn, @NotNull String openid, @NotNull String refreshToken, @NotNull String scope) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(openid, "openid");
        Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return new WechatAuthorizedInfo(accessToken, expiresIn, openid, refreshToken, scope);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WechatAuthorizedInfo)) {
            return false;
        }
        WechatAuthorizedInfo wechatAuthorizedInfo = (WechatAuthorizedInfo) other;
        return Intrinsics.areEqual(this.accessToken, wechatAuthorizedInfo.accessToken) && this.expiresIn == wechatAuthorizedInfo.expiresIn && Intrinsics.areEqual(this.openid, wechatAuthorizedInfo.openid) && Intrinsics.areEqual(this.refreshToken, wechatAuthorizedInfo.refreshToken) && Intrinsics.areEqual(this.scope, wechatAuthorizedInfo.scope);
    }

    @NotNull
    public final String getAccessToken() {
        return this.accessToken;
    }

    public final int getExpiresIn() {
        return this.expiresIn;
    }

    @NotNull
    public final String getOpenid() {
        return this.openid;
    }

    @NotNull
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    @NotNull
    public final String getScope() {
        return this.scope;
    }

    public int hashCode() {
        return (((((((this.accessToken.hashCode() * 31) + this.expiresIn) * 31) + this.openid.hashCode()) * 31) + this.refreshToken.hashCode()) * 31) + this.scope.hashCode();
    }

    @NotNull
    public String toString() {
        return "WechatAuthorizedInfo(accessToken=" + this.accessToken + ", expiresIn=" + this.expiresIn + ", openid=" + this.openid + ", refreshToken=" + this.refreshToken + ", scope=" + this.scope + ")";
    }
}
