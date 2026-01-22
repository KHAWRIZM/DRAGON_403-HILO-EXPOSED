package com.qiahao.nextvideo.data.baishun;

import com.qiahao.base_common.utils.language.LanguageHelper;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;
import org.apache.commons.sudcompress.archivers.zip.UnixStat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010,\u001a\u00020\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u00105\u001a\u00020\u000eHÆ\u0003Jx\u00106\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u000eHÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006="}, d2 = {"Lcom/qiahao/nextvideo/data/baishun/GetConfigData;", "", "appChannel", "", "appId", "", TUIConstants.TUILive.USER_ID, Constants.KEY_HTTP_CODE, TUIConstants.TUILive.ROOM_ID, "gameMode", "language", "gameConfig", "Lcom/qiahao/nextvideo/data/baishun/GameConfig;", "gsp", "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/qiahao/nextvideo/data/baishun/GameConfig;I)V", "getAppChannel", "()Ljava/lang/String;", "setAppChannel", "(Ljava/lang/String;)V", "getAppId", "()Ljava/lang/Long;", "setAppId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getUserId", "setUserId", "getCode", "setCode", "getRoomId", "setRoomId", "getGameMode", "setGameMode", "getLanguage", "setLanguage", "getGameConfig", "()Lcom/qiahao/nextvideo/data/baishun/GameConfig;", "setGameConfig", "(Lcom/qiahao/nextvideo/data/baishun/GameConfig;)V", "getGsp", "()I", "setGsp", "(I)V", "checkLanguage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/qiahao/nextvideo/data/baishun/GameConfig;I)Lcom/qiahao/nextvideo/data/baishun/GetConfigData;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GetConfigData {

    @Nullable
    private String appChannel;

    @Nullable
    private Long appId;

    @Nullable
    private String code;

    @Nullable
    private GameConfig gameConfig;

    @Nullable
    private String gameMode;
    private int gsp;

    @Nullable
    private String language;

    @Nullable
    private String roomId;

    @Nullable
    private String userId;

    public GetConfigData() {
        this(null, null, null, null, null, null, null, null, 0, UnixStat.DEFAULT_LINK_PERM, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0078 A[RETURN, SYNTHETIC] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String checkLanguage() {
        String language = LanguageHelper.INSTANCE.getSystemLanguage().getLanguage();
        if (language == null) {
            return MessageService.MSG_DB_NOTIFY_CLICK;
        }
        switch (language.hashCode()) {
            case 3121:
                if (!language.equals("ar")) {
                    return MessageService.MSG_DB_NOTIFY_CLICK;
                }
                return "7";
            case 3241:
                language.equals(TUIThemeManager.LANGUAGE_EN);
                return MessageService.MSG_DB_NOTIFY_CLICK;
            case 3246:
                if (!language.equals("es")) {
                    return MessageService.MSG_DB_NOTIFY_CLICK;
                }
                return AgooConstants.ACK_PACK_NOBIND;
            case 3355:
                if (!language.equals(AgooConstants.MESSAGE_ID)) {
                    return MessageService.MSG_DB_NOTIFY_CLICK;
                }
                return "3";
            case 3365:
                if (!language.equals("in")) {
                    return MessageService.MSG_DB_NOTIFY_CLICK;
                }
                break;
            case 3588:
                if (!language.equals("pt")) {
                    return MessageService.MSG_DB_NOTIFY_CLICK;
                }
                return MessageService.MSG_ACCS_NOTIFY_DISMISS;
            case 3651:
                if (!language.equals("ru")) {
                    return MessageService.MSG_DB_NOTIFY_CLICK;
                }
                return AgooConstants.ACK_FLAG_NULL;
            case 3700:
                if (!language.equals("th")) {
                    return MessageService.MSG_DB_NOTIFY_CLICK;
                }
                return "5";
            case 3710:
                if (!language.equals("tr")) {
                    return MessageService.MSG_DB_NOTIFY_CLICK;
                }
                return AgooConstants.ACK_REMOVE_PACKAGE;
            case 3741:
                if (!language.equals("ur")) {
                    return MessageService.MSG_DB_NOTIFY_CLICK;
                }
                return AgooConstants.ACK_BODY_NULL;
            case 3763:
                if (!language.equals("vi")) {
                    return MessageService.MSG_DB_NOTIFY_CLICK;
                }
                return "6";
            default:
                return MessageService.MSG_DB_NOTIFY_CLICK;
        }
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getAppChannel() {
        return this.appChannel;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getAppId() {
        return this.appId;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getGameMode() {
        return this.gameMode;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final GameConfig getGameConfig() {
        return this.gameConfig;
    }

    /* renamed from: component9, reason: from getter */
    public final int getGsp() {
        return this.gsp;
    }

    @NotNull
    public final GetConfigData copy(@Nullable String appChannel, @Nullable Long appId, @Nullable String userId, @Nullable String code, @Nullable String roomId, @Nullable String gameMode, @Nullable String language, @Nullable GameConfig gameConfig, int gsp) {
        return new GetConfigData(appChannel, appId, userId, code, roomId, gameMode, language, gameConfig, gsp);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetConfigData)) {
            return false;
        }
        GetConfigData getConfigData = (GetConfigData) other;
        return Intrinsics.areEqual(this.appChannel, getConfigData.appChannel) && Intrinsics.areEqual(this.appId, getConfigData.appId) && Intrinsics.areEqual(this.userId, getConfigData.userId) && Intrinsics.areEqual(this.code, getConfigData.code) && Intrinsics.areEqual(this.roomId, getConfigData.roomId) && Intrinsics.areEqual(this.gameMode, getConfigData.gameMode) && Intrinsics.areEqual(this.language, getConfigData.language) && Intrinsics.areEqual(this.gameConfig, getConfigData.gameConfig) && this.gsp == getConfigData.gsp;
    }

    @Nullable
    public final String getAppChannel() {
        return this.appChannel;
    }

    @Nullable
    public final Long getAppId() {
        return this.appId;
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final GameConfig getGameConfig() {
        return this.gameConfig;
    }

    @Nullable
    public final String getGameMode() {
        return this.gameMode;
    }

    public final int getGsp() {
        return this.gsp;
    }

    @Nullable
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    public final String getRoomId() {
        return this.roomId;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.appChannel;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.appId;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.userId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.code;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.roomId;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.gameMode;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.language;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        GameConfig gameConfig = this.gameConfig;
        return ((hashCode7 + (gameConfig != null ? gameConfig.hashCode() : 0)) * 31) + this.gsp;
    }

    public final void setAppChannel(@Nullable String str) {
        this.appChannel = str;
    }

    public final void setAppId(@Nullable Long l) {
        this.appId = l;
    }

    public final void setCode(@Nullable String str) {
        this.code = str;
    }

    public final void setGameConfig(@Nullable GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public final void setGameMode(@Nullable String str) {
        this.gameMode = str;
    }

    public final void setGsp(int i) {
        this.gsp = i;
    }

    public final void setLanguage(@Nullable String str) {
        this.language = str;
    }

    public final void setRoomId(@Nullable String str) {
        this.roomId = str;
    }

    public final void setUserId(@Nullable String str) {
        this.userId = str;
    }

    @NotNull
    public String toString() {
        return "GetConfigData(appChannel=" + this.appChannel + ", appId=" + this.appId + ", userId=" + this.userId + ", code=" + this.code + ", roomId=" + this.roomId + ", gameMode=" + this.gameMode + ", language=" + this.language + ", gameConfig=" + this.gameConfig + ", gsp=" + this.gsp + ")";
    }

    public GetConfigData(@Nullable String str, @Nullable Long l, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable GameConfig gameConfig, int i) {
        this.appChannel = str;
        this.appId = l;
        this.userId = str2;
        this.code = str3;
        this.roomId = str4;
        this.gameMode = str5;
        this.language = str6;
        this.gameConfig = gameConfig;
        this.gsp = i;
    }

    public /* synthetic */ GetConfigData(String str, Long l, String str2, String str3, String str4, String str5, String str6, GameConfig gameConfig, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? 0L : l, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? null : str6, (i2 & 128) == 0 ? gameConfig : null, (i2 & 256) != 0 ? 101 : i);
    }
}
