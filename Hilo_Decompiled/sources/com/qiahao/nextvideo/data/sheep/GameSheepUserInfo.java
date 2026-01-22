package com.qiahao.nextvideo.data.sheep;

import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001'Bc\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/qiahao/nextvideo/data/sheep/GameSheepUserInfo;", "", TUIConstants.TUILive.USER_ID, "", "userNo", "avatar", "nickname", "sex", "", "status", "countryFlag", "sourceNumber", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getUserNo", "setUserNo", "getAvatar", "setAvatar", "getNickname", "setNickname", "getSex", "()I", "setSex", "(I)V", "getStatus", "setStatus", "getCountryFlag", "setCountryFlag", "getSourceNumber", "setSourceNumber", "isWin", "", "()Z", "setWin", "(Z)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameSheepUserInfo {
    public static final int STATUS_NORMAL = 1;
    public static final int STATUS_PREPARING = 2;

    @Nullable
    private String avatar;

    @Nullable
    private String countryFlag;
    private transient boolean isWin;

    @Nullable
    private String nickname;
    private int sex;

    @Nullable
    private String sourceNumber;
    private int status;

    @Nullable
    private String userId;

    @Nullable
    private String userNo;

    public GameSheepUserInfo() {
        this(null, null, null, null, 0, 0, null, null, 255, null);
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getCountryFlag() {
        return this.countryFlag;
    }

    @Nullable
    public final String getNickname() {
        return this.nickname;
    }

    public final int getSex() {
        return this.sex;
    }

    @Nullable
    public final String getSourceNumber() {
        return this.sourceNumber;
    }

    public final int getStatus() {
        return this.status;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    @Nullable
    public final String getUserNo() {
        return this.userNo;
    }

    /* renamed from: isWin, reason: from getter */
    public final boolean getIsWin() {
        return this.isWin;
    }

    public final void setAvatar(@Nullable String str) {
        this.avatar = str;
    }

    public final void setCountryFlag(@Nullable String str) {
        this.countryFlag = str;
    }

    public final void setNickname(@Nullable String str) {
        this.nickname = str;
    }

    public final void setSex(int i) {
        this.sex = i;
    }

    public final void setSourceNumber(@Nullable String str) {
        this.sourceNumber = str;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setUserId(@Nullable String str) {
        this.userId = str;
    }

    public final void setUserNo(@Nullable String str) {
        this.userNo = str;
    }

    public final void setWin(boolean z) {
        this.isWin = z;
    }

    public GameSheepUserInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i, int i2, @Nullable String str5, @Nullable String str6) {
        this.userId = str;
        this.userNo = str2;
        this.avatar = str3;
        this.nickname = str4;
        this.sex = i;
        this.status = i2;
        this.countryFlag = str5;
        this.sourceNumber = str6;
    }

    public /* synthetic */ GameSheepUserInfo(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? 0 : i, (i3 & 32) == 0 ? i2 : 0, (i3 & 64) != 0 ? "" : str5, (i3 & 128) == 0 ? str6 : "");
    }
}
