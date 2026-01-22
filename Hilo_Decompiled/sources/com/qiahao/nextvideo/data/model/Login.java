package com.qiahao.nextvideo.data.model;

import android.net.Uri;
import com.facebook.AccessToken;
import com.facebook.Profile;
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.utilities.Debug;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(BE\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003JT\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0006HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u0013¨\u0006)"}, d2 = {"Lcom/qiahao/nextvideo/data/model/Login;", "", TUIConstants.TUILive.USER_ID, "", "token", "type", "", "nickname", "sex", "avatar", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getToken", "getType", "()I", "getNickname", "setNickname", "(Ljava/lang/String;)V", "getSex", "()Ljava/lang/Integer;", "setSex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getAvatar", "setAvatar", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/model/Login;", "equals", "", "other", "hashCode", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class Login {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private String avatar;

    @Nullable
    private String nickname;

    @Nullable
    private Integer sex;

    @Nullable
    private final String token;
    private final int type;

    @Nullable
    private final String userId;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000eJ7\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/data/model/Login$Companion;", "", "<init>", "()V", "fake", "Lcom/qiahao/nextvideo/data/model/Login;", "type", "Lcom/qiahao/nextvideo/data/model/LoginType;", "token", "", TUIConstants.TUILive.USER_ID, "init", "result", "Lcom/google/android/libraries/identity/googleid/GoogleIdTokenCredential;", "Lcom/facebook/AccessToken;", "Lcom/qiahao/nextvideo/data/model/WechatAuthorizedInfo;", "nickname", "sex", "", "avatar", "(Lcom/qiahao/nextvideo/data/model/WechatAuthorizedInfo;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/model/Login;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Login fake$default(Companion companion, LoginType loginType, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                loginType = LoginType.GOOGLE;
            }
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            return companion.fake(loginType, str, str2);
        }

        public static /* synthetic */ Login init$default(Companion companion, WechatAuthorizedInfo wechatAuthorizedInfo, String str, Integer num, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                num = null;
            }
            if ((i & 8) != 0) {
                str2 = null;
            }
            return companion.init(wechatAuthorizedInfo, str, num, str2);
        }

        @NotNull
        public final Login fake(@NotNull LoginType type, @Nullable String token, @Nullable String userId) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new Login(userId, token, type.getCode(), "nick", null, (String) CollectionsKt.random(Debug.INSTANCE.getImages(), Random.Default), 16, null);
        }

        @NotNull
        public final Login init(@NotNull GoogleIdTokenCredential result) {
            Intrinsics.checkNotNullParameter(result, "result");
            String id2 = result.getId();
            String idToken = result.getIdToken();
            int code = LoginType.GOOGLE.getCode();
            String displayName = result.getDisplayName();
            Uri profilePictureUri = result.getProfilePictureUri();
            return new Login(id2, idToken, code, displayName, null, profilePictureUri != null ? profilePictureUri.toString() : null, 16, null);
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x003e  */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Login init(@NotNull AccessToken result) {
            String str;
            Intrinsics.checkNotNullParameter(result, "result");
            AccessToken.Companion.setCurrentAccessToken(result);
            String userId = result.getUserId();
            String token = result.getToken();
            int code = LoginType.FACEBOOK.getCode();
            Profile.Companion companion = Profile.Companion;
            Profile currentProfile = companion.getCurrentProfile();
            if (currentProfile != null) {
                Dimens dimens = Dimens.INSTANCE;
                Uri profilePictureUri = currentProfile.getProfilePictureUri(dimens.getScreenWidth(), dimens.getScreenHeight());
                if (profilePictureUri != null) {
                    str = profilePictureUri.toString();
                    Profile currentProfile2 = companion.getCurrentProfile();
                    return new Login(userId, token, code, currentProfile2 == null ? currentProfile2.getName() : null, null, str, 16, null);
                }
            }
            str = null;
            Profile currentProfile22 = companion.getCurrentProfile();
            return new Login(userId, token, code, currentProfile22 == null ? currentProfile22.getName() : null, null, str, 16, null);
        }

        @NotNull
        public final Login init(@NotNull WechatAuthorizedInfo result, @Nullable String nickname, @Nullable Integer sex, @Nullable String avatar) {
            Intrinsics.checkNotNullParameter(result, "result");
            return new Login(result.getOpenid(), result.getAccessToken(), LoginType.WECHAT.getCode(), nickname, sex, avatar);
        }
    }

    public Login(@Nullable String str, @Nullable String str2, int i, @Nullable String str3, @Nullable Integer num, @Nullable String str4) {
        this.userId = str;
        this.token = str2;
        this.type = i;
        this.nickname = str3;
        this.sex = num;
        this.avatar = str4;
    }

    public static /* synthetic */ Login copy$default(Login login, String str, String str2, int i, String str3, Integer num, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = login.userId;
        }
        if ((i2 & 2) != 0) {
            str2 = login.token;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            i = login.type;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str3 = login.nickname;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            num = login.sex;
        }
        Integer num2 = num;
        if ((i2 & 32) != 0) {
            str4 = login.avatar;
        }
        return login.copy(str, str5, i3, str6, num2, str4);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component3, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getSex() {
        return this.sex;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final Login copy(@Nullable String userId, @Nullable String token, int type, @Nullable String nickname, @Nullable Integer sex, @Nullable String avatar) {
        return new Login(userId, token, type, nickname, sex, avatar);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Login)) {
            return false;
        }
        Login login = (Login) other;
        return Intrinsics.areEqual(this.userId, login.userId) && Intrinsics.areEqual(this.token, login.token) && this.type == login.type && Intrinsics.areEqual(this.nickname, login.nickname) && Intrinsics.areEqual(this.sex, login.sex) && Intrinsics.areEqual(this.avatar, login.avatar);
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getNickname() {
        return this.nickname;
    }

    @Nullable
    public final Integer getSex() {
        return this.sex;
    }

    @Nullable
    public final String getToken() {
        return this.token;
    }

    public final int getType() {
        return this.type;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.userId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.token;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.type) * 31;
        String str3 = this.nickname;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.sex;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.avatar;
        return hashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setAvatar(@Nullable String str) {
        this.avatar = str;
    }

    public final void setNickname(@Nullable String str) {
        this.nickname = str;
    }

    public final void setSex(@Nullable Integer num) {
        this.sex = num;
    }

    @NotNull
    public String toString() {
        return "Login(userId=" + this.userId + ", token=" + this.token + ", type=" + this.type + ", nickname=" + this.nickname + ", sex=" + this.sex + ", avatar=" + this.avatar + ")";
    }

    public /* synthetic */ Login(String str, String str2, int i, String str3, Integer num, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? 0 : num, str4);
    }
}
