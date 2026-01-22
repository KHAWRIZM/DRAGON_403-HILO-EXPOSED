package com.qiahao.nextvideo.data.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b]\b\u0086\b\u0018\u00002\u00020\u0001B¥\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\u001c\b\u0002\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\r\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b!\u0010\"J\u0010\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\t\u0010^\u001a\u00020\u0005HÆ\u0003J\t\u0010_\u001a\u00020\u0005HÆ\u0003J\t\u0010`\u001a\u00020\u0005HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001d\u0010c\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rHÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010g\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010?J\u000b\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001d\u0010k\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\rHÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u0010\u0010q\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010?J\u0010\u0010r\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010?J\u000b\u0010s\u001a\u0004\u0018\u00010\u0005HÆ\u0003JÀ\u0002\u0010t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u001c\b\u0002\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010uJ\u0013\u0010v\u001a\u00020\u00122\b\u0010w\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010x\u001a\u00020\u0003HÖ\u0001J\t\u0010y\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010)\"\u0004\b3\u0010+R.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010)\"\u0004\b9\u0010+R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010)\"\u0004\b;\u0010+R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010)\"\u0004\b=\u0010+R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010B\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010)\"\u0004\bD\u0010+R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010)\"\u0004\bF\u0010+R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010)\"\u0004\bH\u0010+R.\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00105\"\u0004\bJ\u00107R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010)\"\u0004\bL\u0010+R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010)\"\u0004\bN\u0010+R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010)\"\u0004\bP\u0010+R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010)\"\u0004\bR\u0010+R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010B\u001a\u0004\bW\u0010?\"\u0004\bX\u0010AR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010B\u001a\u0004\bY\u0010?\"\u0004\bZ\u0010AR\u001c\u0010 \u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010)\"\u0004\b\\\u0010+¨\u0006z"}, d2 = {"Lcom/qiahao/nextvideo/data/model/ConfigurationParam;", "", "unionUserScreenCaptureInSec", "", "userLevelH5", "", "defaultAvatarUrlMan", "defaultAvatarUrlWoman", "groupSupportH5", "luckyWheelH5", "videoTradeUnionGiftIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "guildDataUrl", "mgrGuildDataUrl", "rankingPinkDiamondUrl", "agentAllow", "", "chargeUrl", "groupPowerActUrl", "groupPowerGradeUrl", "gameUrlConfigs", "Lcom/qiahao/nextvideo/data/model/GameUrlConfig;", "idUrl", "cpUrl", "lobbyUrl", "taskUrl", "skin", "Lcom/qiahao/nextvideo/data/model/SkinConfiguration;", "showGameLudoUno", "showDiscoverCountry", "familyWheelUrl", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/qiahao/nextvideo/data/model/SkinConfiguration;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getUnionUserScreenCaptureInSec", "()Ljava/lang/Integer;", "setUnionUserScreenCaptureInSec", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUserLevelH5", "()Ljava/lang/String;", "setUserLevelH5", "(Ljava/lang/String;)V", "getDefaultAvatarUrlMan", "setDefaultAvatarUrlMan", "getDefaultAvatarUrlWoman", "setDefaultAvatarUrlWoman", "getGroupSupportH5", "setGroupSupportH5", "getLuckyWheelH5", "setLuckyWheelH5", "getVideoTradeUnionGiftIds", "()Ljava/util/ArrayList;", "setVideoTradeUnionGiftIds", "(Ljava/util/ArrayList;)V", "getGuildDataUrl", "setGuildDataUrl", "getMgrGuildDataUrl", "setMgrGuildDataUrl", "getRankingPinkDiamondUrl", "setRankingPinkDiamondUrl", "getAgentAllow", "()Ljava/lang/Boolean;", "setAgentAllow", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getChargeUrl", "setChargeUrl", "getGroupPowerActUrl", "setGroupPowerActUrl", "getGroupPowerGradeUrl", "setGroupPowerGradeUrl", "getGameUrlConfigs", "setGameUrlConfigs", "getIdUrl", "setIdUrl", "getCpUrl", "setCpUrl", "getLobbyUrl", "setLobbyUrl", "getTaskUrl", "setTaskUrl", "getSkin", "()Lcom/qiahao/nextvideo/data/model/SkinConfiguration;", "setSkin", "(Lcom/qiahao/nextvideo/data/model/SkinConfiguration;)V", "getShowGameLudoUno", "setShowGameLudoUno", "getShowDiscoverCountry", "setShowDiscoverCountry", "getFamilyWheelUrl", "setFamilyWheelUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/qiahao/nextvideo/data/model/SkinConfiguration;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/model/ConfigurationParam;", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class ConfigurationParam {

    @Nullable
    private Boolean agentAllow;

    @Nullable
    private String chargeUrl;

    @Nullable
    private String cpUrl;

    @NotNull
    private String defaultAvatarUrlMan;

    @NotNull
    private String defaultAvatarUrlWoman;

    @Nullable
    private String familyWheelUrl;

    @Nullable
    private ArrayList<GameUrlConfig> gameUrlConfigs;

    @Nullable
    private String groupPowerActUrl;

    @Nullable
    private String groupPowerGradeUrl;

    @Nullable
    private String groupSupportH5;

    @Nullable
    private String guildDataUrl;

    @Nullable
    private String idUrl;

    @Nullable
    private String lobbyUrl;

    @Nullable
    private String luckyWheelH5;

    @Nullable
    private String mgrGuildDataUrl;

    @Nullable
    private String rankingPinkDiamondUrl;

    @Nullable
    private Boolean showDiscoverCountry;

    @Nullable
    private Boolean showGameLudoUno;

    @Nullable
    private SkinConfiguration skin;

    @Nullable
    private String taskUrl;

    @Nullable
    @c("screenCapture")
    private Integer unionUserScreenCaptureInSec;

    @NotNull
    private String userLevelH5;

    @Nullable
    private ArrayList<Long> videoTradeUnionGiftIds;

    public ConfigurationParam(@Nullable Integer num, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable ArrayList<Long> arrayList, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable Boolean bool, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable ArrayList<GameUrlConfig> arrayList2, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable SkinConfiguration skinConfiguration, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str16) {
        Intrinsics.checkNotNullParameter(str, "userLevelH5");
        Intrinsics.checkNotNullParameter(str2, "defaultAvatarUrlMan");
        Intrinsics.checkNotNullParameter(str3, "defaultAvatarUrlWoman");
        this.unionUserScreenCaptureInSec = num;
        this.userLevelH5 = str;
        this.defaultAvatarUrlMan = str2;
        this.defaultAvatarUrlWoman = str3;
        this.groupSupportH5 = str4;
        this.luckyWheelH5 = str5;
        this.videoTradeUnionGiftIds = arrayList;
        this.guildDataUrl = str6;
        this.mgrGuildDataUrl = str7;
        this.rankingPinkDiamondUrl = str8;
        this.agentAllow = bool;
        this.chargeUrl = str9;
        this.groupPowerActUrl = str10;
        this.groupPowerGradeUrl = str11;
        this.gameUrlConfigs = arrayList2;
        this.idUrl = str12;
        this.cpUrl = str13;
        this.lobbyUrl = str14;
        this.taskUrl = str15;
        this.skin = skinConfiguration;
        this.showGameLudoUno = bool2;
        this.showDiscoverCountry = bool3;
        this.familyWheelUrl = str16;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getUnionUserScreenCaptureInSec() {
        return this.unionUserScreenCaptureInSec;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getRankingPinkDiamondUrl() {
        return this.rankingPinkDiamondUrl;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Boolean getAgentAllow() {
        return this.agentAllow;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getChargeUrl() {
        return this.chargeUrl;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final String getGroupPowerActUrl() {
        return this.groupPowerActUrl;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final String getGroupPowerGradeUrl() {
        return this.groupPowerGradeUrl;
    }

    @Nullable
    public final ArrayList<GameUrlConfig> component15() {
        return this.gameUrlConfigs;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final String getIdUrl() {
        return this.idUrl;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final String getCpUrl() {
        return this.cpUrl;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final String getLobbyUrl() {
        return this.lobbyUrl;
    }

    @Nullable
    /* renamed from: component19, reason: from getter */
    public final String getTaskUrl() {
        return this.taskUrl;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getUserLevelH5() {
        return this.userLevelH5;
    }

    @Nullable
    /* renamed from: component20, reason: from getter */
    public final SkinConfiguration getSkin() {
        return this.skin;
    }

    @Nullable
    /* renamed from: component21, reason: from getter */
    public final Boolean getShowGameLudoUno() {
        return this.showGameLudoUno;
    }

    @Nullable
    /* renamed from: component22, reason: from getter */
    public final Boolean getShowDiscoverCountry() {
        return this.showDiscoverCountry;
    }

    @Nullable
    /* renamed from: component23, reason: from getter */
    public final String getFamilyWheelUrl() {
        return this.familyWheelUrl;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getDefaultAvatarUrlMan() {
        return this.defaultAvatarUrlMan;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getDefaultAvatarUrlWoman() {
        return this.defaultAvatarUrlWoman;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getGroupSupportH5() {
        return this.groupSupportH5;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getLuckyWheelH5() {
        return this.luckyWheelH5;
    }

    @Nullable
    public final ArrayList<Long> component7() {
        return this.videoTradeUnionGiftIds;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getGuildDataUrl() {
        return this.guildDataUrl;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getMgrGuildDataUrl() {
        return this.mgrGuildDataUrl;
    }

    @NotNull
    public final ConfigurationParam copy(@Nullable Integer unionUserScreenCaptureInSec, @NotNull String userLevelH5, @NotNull String defaultAvatarUrlMan, @NotNull String defaultAvatarUrlWoman, @Nullable String groupSupportH5, @Nullable String luckyWheelH5, @Nullable ArrayList<Long> videoTradeUnionGiftIds, @Nullable String guildDataUrl, @Nullable String mgrGuildDataUrl, @Nullable String rankingPinkDiamondUrl, @Nullable Boolean agentAllow, @Nullable String chargeUrl, @Nullable String groupPowerActUrl, @Nullable String groupPowerGradeUrl, @Nullable ArrayList<GameUrlConfig> gameUrlConfigs, @Nullable String idUrl, @Nullable String cpUrl, @Nullable String lobbyUrl, @Nullable String taskUrl, @Nullable SkinConfiguration skin, @Nullable Boolean showGameLudoUno, @Nullable Boolean showDiscoverCountry, @Nullable String familyWheelUrl) {
        Intrinsics.checkNotNullParameter(userLevelH5, "userLevelH5");
        Intrinsics.checkNotNullParameter(defaultAvatarUrlMan, "defaultAvatarUrlMan");
        Intrinsics.checkNotNullParameter(defaultAvatarUrlWoman, "defaultAvatarUrlWoman");
        return new ConfigurationParam(unionUserScreenCaptureInSec, userLevelH5, defaultAvatarUrlMan, defaultAvatarUrlWoman, groupSupportH5, luckyWheelH5, videoTradeUnionGiftIds, guildDataUrl, mgrGuildDataUrl, rankingPinkDiamondUrl, agentAllow, chargeUrl, groupPowerActUrl, groupPowerGradeUrl, gameUrlConfigs, idUrl, cpUrl, lobbyUrl, taskUrl, skin, showGameLudoUno, showDiscoverCountry, familyWheelUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigurationParam)) {
            return false;
        }
        ConfigurationParam configurationParam = (ConfigurationParam) other;
        return Intrinsics.areEqual(this.unionUserScreenCaptureInSec, configurationParam.unionUserScreenCaptureInSec) && Intrinsics.areEqual(this.userLevelH5, configurationParam.userLevelH5) && Intrinsics.areEqual(this.defaultAvatarUrlMan, configurationParam.defaultAvatarUrlMan) && Intrinsics.areEqual(this.defaultAvatarUrlWoman, configurationParam.defaultAvatarUrlWoman) && Intrinsics.areEqual(this.groupSupportH5, configurationParam.groupSupportH5) && Intrinsics.areEqual(this.luckyWheelH5, configurationParam.luckyWheelH5) && Intrinsics.areEqual(this.videoTradeUnionGiftIds, configurationParam.videoTradeUnionGiftIds) && Intrinsics.areEqual(this.guildDataUrl, configurationParam.guildDataUrl) && Intrinsics.areEqual(this.mgrGuildDataUrl, configurationParam.mgrGuildDataUrl) && Intrinsics.areEqual(this.rankingPinkDiamondUrl, configurationParam.rankingPinkDiamondUrl) && Intrinsics.areEqual(this.agentAllow, configurationParam.agentAllow) && Intrinsics.areEqual(this.chargeUrl, configurationParam.chargeUrl) && Intrinsics.areEqual(this.groupPowerActUrl, configurationParam.groupPowerActUrl) && Intrinsics.areEqual(this.groupPowerGradeUrl, configurationParam.groupPowerGradeUrl) && Intrinsics.areEqual(this.gameUrlConfigs, configurationParam.gameUrlConfigs) && Intrinsics.areEqual(this.idUrl, configurationParam.idUrl) && Intrinsics.areEqual(this.cpUrl, configurationParam.cpUrl) && Intrinsics.areEqual(this.lobbyUrl, configurationParam.lobbyUrl) && Intrinsics.areEqual(this.taskUrl, configurationParam.taskUrl) && Intrinsics.areEqual(this.skin, configurationParam.skin) && Intrinsics.areEqual(this.showGameLudoUno, configurationParam.showGameLudoUno) && Intrinsics.areEqual(this.showDiscoverCountry, configurationParam.showDiscoverCountry) && Intrinsics.areEqual(this.familyWheelUrl, configurationParam.familyWheelUrl);
    }

    @Nullable
    public final Boolean getAgentAllow() {
        return this.agentAllow;
    }

    @Nullable
    public final String getChargeUrl() {
        return this.chargeUrl;
    }

    @Nullable
    public final String getCpUrl() {
        return this.cpUrl;
    }

    @NotNull
    public final String getDefaultAvatarUrlMan() {
        return this.defaultAvatarUrlMan;
    }

    @NotNull
    public final String getDefaultAvatarUrlWoman() {
        return this.defaultAvatarUrlWoman;
    }

    @Nullable
    public final String getFamilyWheelUrl() {
        return this.familyWheelUrl;
    }

    @Nullable
    public final ArrayList<GameUrlConfig> getGameUrlConfigs() {
        return this.gameUrlConfigs;
    }

    @Nullable
    public final String getGroupPowerActUrl() {
        return this.groupPowerActUrl;
    }

    @Nullable
    public final String getGroupPowerGradeUrl() {
        return this.groupPowerGradeUrl;
    }

    @Nullable
    public final String getGroupSupportH5() {
        return this.groupSupportH5;
    }

    @Nullable
    public final String getGuildDataUrl() {
        return this.guildDataUrl;
    }

    @Nullable
    public final String getIdUrl() {
        return this.idUrl;
    }

    @Nullable
    public final String getLobbyUrl() {
        return this.lobbyUrl;
    }

    @Nullable
    public final String getLuckyWheelH5() {
        return this.luckyWheelH5;
    }

    @Nullable
    public final String getMgrGuildDataUrl() {
        return this.mgrGuildDataUrl;
    }

    @Nullable
    public final String getRankingPinkDiamondUrl() {
        return this.rankingPinkDiamondUrl;
    }

    @Nullable
    public final Boolean getShowDiscoverCountry() {
        return this.showDiscoverCountry;
    }

    @Nullable
    public final Boolean getShowGameLudoUno() {
        return this.showGameLudoUno;
    }

    @Nullable
    public final SkinConfiguration getSkin() {
        return this.skin;
    }

    @Nullable
    public final String getTaskUrl() {
        return this.taskUrl;
    }

    @Nullable
    public final Integer getUnionUserScreenCaptureInSec() {
        return this.unionUserScreenCaptureInSec;
    }

    @NotNull
    public final String getUserLevelH5() {
        return this.userLevelH5;
    }

    @Nullable
    public final ArrayList<Long> getVideoTradeUnionGiftIds() {
        return this.videoTradeUnionGiftIds;
    }

    public int hashCode() {
        Integer num = this.unionUserScreenCaptureInSec;
        int hashCode = (((((((num == null ? 0 : num.hashCode()) * 31) + this.userLevelH5.hashCode()) * 31) + this.defaultAvatarUrlMan.hashCode()) * 31) + this.defaultAvatarUrlWoman.hashCode()) * 31;
        String str = this.groupSupportH5;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.luckyWheelH5;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        ArrayList<Long> arrayList = this.videoTradeUnionGiftIds;
        int hashCode4 = (hashCode3 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        String str3 = this.guildDataUrl;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.mgrGuildDataUrl;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.rankingPinkDiamondUrl;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.agentAllow;
        int hashCode8 = (hashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str6 = this.chargeUrl;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.groupPowerActUrl;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.groupPowerGradeUrl;
        int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        ArrayList<GameUrlConfig> arrayList2 = this.gameUrlConfigs;
        int hashCode12 = (hashCode11 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
        String str9 = this.idUrl;
        int hashCode13 = (hashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.cpUrl;
        int hashCode14 = (hashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.lobbyUrl;
        int hashCode15 = (hashCode14 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.taskUrl;
        int hashCode16 = (hashCode15 + (str12 == null ? 0 : str12.hashCode())) * 31;
        SkinConfiguration skinConfiguration = this.skin;
        int hashCode17 = (hashCode16 + (skinConfiguration == null ? 0 : skinConfiguration.hashCode())) * 31;
        Boolean bool2 = this.showGameLudoUno;
        int hashCode18 = (hashCode17 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.showDiscoverCountry;
        int hashCode19 = (hashCode18 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str13 = this.familyWheelUrl;
        return hashCode19 + (str13 != null ? str13.hashCode() : 0);
    }

    public final void setAgentAllow(@Nullable Boolean bool) {
        this.agentAllow = bool;
    }

    public final void setChargeUrl(@Nullable String str) {
        this.chargeUrl = str;
    }

    public final void setCpUrl(@Nullable String str) {
        this.cpUrl = str;
    }

    public final void setDefaultAvatarUrlMan(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.defaultAvatarUrlMan = str;
    }

    public final void setDefaultAvatarUrlWoman(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.defaultAvatarUrlWoman = str;
    }

    public final void setFamilyWheelUrl(@Nullable String str) {
        this.familyWheelUrl = str;
    }

    public final void setGameUrlConfigs(@Nullable ArrayList<GameUrlConfig> arrayList) {
        this.gameUrlConfigs = arrayList;
    }

    public final void setGroupPowerActUrl(@Nullable String str) {
        this.groupPowerActUrl = str;
    }

    public final void setGroupPowerGradeUrl(@Nullable String str) {
        this.groupPowerGradeUrl = str;
    }

    public final void setGroupSupportH5(@Nullable String str) {
        this.groupSupportH5 = str;
    }

    public final void setGuildDataUrl(@Nullable String str) {
        this.guildDataUrl = str;
    }

    public final void setIdUrl(@Nullable String str) {
        this.idUrl = str;
    }

    public final void setLobbyUrl(@Nullable String str) {
        this.lobbyUrl = str;
    }

    public final void setLuckyWheelH5(@Nullable String str) {
        this.luckyWheelH5 = str;
    }

    public final void setMgrGuildDataUrl(@Nullable String str) {
        this.mgrGuildDataUrl = str;
    }

    public final void setRankingPinkDiamondUrl(@Nullable String str) {
        this.rankingPinkDiamondUrl = str;
    }

    public final void setShowDiscoverCountry(@Nullable Boolean bool) {
        this.showDiscoverCountry = bool;
    }

    public final void setShowGameLudoUno(@Nullable Boolean bool) {
        this.showGameLudoUno = bool;
    }

    public final void setSkin(@Nullable SkinConfiguration skinConfiguration) {
        this.skin = skinConfiguration;
    }

    public final void setTaskUrl(@Nullable String str) {
        this.taskUrl = str;
    }

    public final void setUnionUserScreenCaptureInSec(@Nullable Integer num) {
        this.unionUserScreenCaptureInSec = num;
    }

    public final void setUserLevelH5(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userLevelH5 = str;
    }

    public final void setVideoTradeUnionGiftIds(@Nullable ArrayList<Long> arrayList) {
        this.videoTradeUnionGiftIds = arrayList;
    }

    @NotNull
    public String toString() {
        return "ConfigurationParam(unionUserScreenCaptureInSec=" + this.unionUserScreenCaptureInSec + ", userLevelH5=" + this.userLevelH5 + ", defaultAvatarUrlMan=" + this.defaultAvatarUrlMan + ", defaultAvatarUrlWoman=" + this.defaultAvatarUrlWoman + ", groupSupportH5=" + this.groupSupportH5 + ", luckyWheelH5=" + this.luckyWheelH5 + ", videoTradeUnionGiftIds=" + this.videoTradeUnionGiftIds + ", guildDataUrl=" + this.guildDataUrl + ", mgrGuildDataUrl=" + this.mgrGuildDataUrl + ", rankingPinkDiamondUrl=" + this.rankingPinkDiamondUrl + ", agentAllow=" + this.agentAllow + ", chargeUrl=" + this.chargeUrl + ", groupPowerActUrl=" + this.groupPowerActUrl + ", groupPowerGradeUrl=" + this.groupPowerGradeUrl + ", gameUrlConfigs=" + this.gameUrlConfigs + ", idUrl=" + this.idUrl + ", cpUrl=" + this.cpUrl + ", lobbyUrl=" + this.lobbyUrl + ", taskUrl=" + this.taskUrl + ", skin=" + this.skin + ", showGameLudoUno=" + this.showGameLudoUno + ", showDiscoverCountry=" + this.showDiscoverCountry + ", familyWheelUrl=" + this.familyWheelUrl + ")";
    }

    public /* synthetic */ ConfigurationParam(Integer num, String str, String str2, String str3, String str4, String str5, ArrayList arrayList, String str6, String str7, String str8, Boolean bool, String str9, String str10, String str11, ArrayList arrayList2, String str12, String str13, String str14, String str15, SkinConfiguration skinConfiguration, Boolean bool2, Boolean bool3, String str16, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, str, str2, str3, str4, str5, arrayList, str6, str7, str8, (i & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? Boolean.FALSE : bool, (i & 2048) != 0 ? "" : str9, (i & 4096) != 0 ? "" : str10, (i & 8192) != 0 ? "" : str11, (i & 16384) != 0 ? null : arrayList2, (32768 & i) != 0 ? "" : str12, (65536 & i) != 0 ? "" : str13, (131072 & i) != 0 ? "" : str14, (262144 & i) != 0 ? "" : str15, (524288 & i) != 0 ? null : skinConfiguration, (1048576 & i) != 0 ? null : bool2, (2097152 & i) != 0 ? null : bool3, (i & 4194304) != 0 ? "" : str16);
    }
}
