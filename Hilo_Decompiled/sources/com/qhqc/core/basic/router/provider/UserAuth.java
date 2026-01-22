package com.qhqc.core.basic.router.provider;

import androidx.collection.c;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import io.agora.rtc.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003JY\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f¨\u0006,"}, d2 = {"Lcom/qhqc/core/basic/router/provider/UserAuth;", "", "uid", "", HeaderInterceptor.TOKEN, "", DispatchConstants.DEVICEID, HeaderInterceptor.LANGUAGE, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "clientVersion", "userInfoJson", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClientVersion", "()Ljava/lang/String;", "setClientVersion", "(Ljava/lang/String;)V", "getDeviceId", "setDeviceId", "getLanguage", "setLanguage", "getPackageName", "setPackageName", "getToken", "setToken", "getUid", "()J", "setUid", "(J)V", "getUserInfoJson", "setUserInfoJson", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class UserAuth {

    @Nullable
    private String clientVersion;

    @Nullable
    private String deviceId;

    @Nullable
    private String language;

    @NotNull
    private String packageName;

    @Nullable
    private String token;
    private long uid;

    @Nullable
    private String userInfoJson;

    public UserAuth() {
        this(0L, null, null, null, null, null, null, Constants.ERR_WATERMARKR_INFO, null);
    }

    /* renamed from: component1, reason: from getter */
    public final long getUid() {
        return this.uid;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getClientVersion() {
        return this.clientVersion;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getUserInfoJson() {
        return this.userInfoJson;
    }

    @NotNull
    public final UserAuth copy(long uid, @Nullable String token, @Nullable String deviceId, @Nullable String language, @NotNull String packageName, @Nullable String clientVersion, @Nullable String userInfoJson) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return new UserAuth(uid, token, deviceId, language, packageName, clientVersion, userInfoJson);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserAuth)) {
            return false;
        }
        UserAuth userAuth = (UserAuth) other;
        return this.uid == userAuth.uid && Intrinsics.areEqual(this.token, userAuth.token) && Intrinsics.areEqual(this.deviceId, userAuth.deviceId) && Intrinsics.areEqual(this.language, userAuth.language) && Intrinsics.areEqual(this.packageName, userAuth.packageName) && Intrinsics.areEqual(this.clientVersion, userAuth.clientVersion) && Intrinsics.areEqual(this.userInfoJson, userAuth.userInfoJson);
    }

    @Nullable
    public final String getClientVersion() {
        return this.clientVersion;
    }

    @Nullable
    public final String getDeviceId() {
        return this.deviceId;
    }

    @Nullable
    public final String getLanguage() {
        return this.language;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @Nullable
    public final String getToken() {
        return this.token;
    }

    public final long getUid() {
        return this.uid;
    }

    @Nullable
    public final String getUserInfoJson() {
        return this.userInfoJson;
    }

    public int hashCode() {
        int a10 = c.a(this.uid) * 31;
        String str = this.token;
        int hashCode = (a10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.deviceId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.language;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.packageName.hashCode()) * 31;
        String str4 = this.clientVersion;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.userInfoJson;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setClientVersion(@Nullable String str) {
        this.clientVersion = str;
    }

    public final void setDeviceId(@Nullable String str) {
        this.deviceId = str;
    }

    public final void setLanguage(@Nullable String str) {
        this.language = str;
    }

    public final void setPackageName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.packageName = str;
    }

    public final void setToken(@Nullable String str) {
        this.token = str;
    }

    public final void setUid(long j10) {
        this.uid = j10;
    }

    public final void setUserInfoJson(@Nullable String str) {
        this.userInfoJson = str;
    }

    @NotNull
    public String toString() {
        return "UserAuth(uid=" + this.uid + ", token=" + this.token + ", deviceId=" + this.deviceId + ", language=" + this.language + ", packageName=" + this.packageName + ", clientVersion=" + this.clientVersion + ", userInfoJson=" + this.userInfoJson + ")";
    }

    public UserAuth(long j10, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull String packageName, @Nullable String str4, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.uid = j10;
        this.token = str;
        this.deviceId = str2;
        this.language = str3;
        this.packageName = packageName;
        this.clientVersion = str4;
        this.userInfoJson = str5;
    }

    public /* synthetic */ UserAuth(long j10, String str, String str2, String str3, String str4, String str5, String str6, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? 0L : j10, (i10 & 2) != 0 ? "" : str, (i10 & 4) != 0 ? "" : str2, (i10 & 8) != 0 ? "en" : str3, (i10 & 16) != 0 ? "" : str4, (i10 & 32) != 0 ? "" : str5, (i10 & 64) == 0 ? str6 : "");
    }
}
