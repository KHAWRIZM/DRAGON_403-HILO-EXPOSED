package com.qiahao.nextvideo.data.service.match;

import android.app.Activity;
import android.text.TextUtils;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.VideoEvent;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.game.SkinData;
import com.qiahao.nextvideo.data.model.ConfigurationParam;
import com.qiahao.nextvideo.data.model.MatchingFloatData;
import com.qiahao.nextvideo.data.model.RandomPairChatroomConfig;
import com.qiahao.nextvideo.data.model.SkinConfiguration;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.room.SkinMessage;
import com.qiahao.nextvideo.ui.reusable.views.MatchingFloatView;
import com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity;
import com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity;
import com.qiahao.nextvideo.utilities.SensitiveUtil;
import com.taobao.accs.common.Constants;
import io.reactivex.rxjava3.core.i0;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0003J9\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001a0\u00192\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\u001cJ;\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001a0\u00192\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0004¢\u0006\u0004\b#\u0010\u0003J\r\u0010$\u001a\u00020\u0004¢\u0006\u0004\b$\u0010\u0003J\r\u0010%\u001a\u00020\u0004¢\u0006\u0004\b%\u0010\u0003J\u0015\u0010&\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0014\u00106\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00108\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b8\u00107R\u0014\u00109\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b9\u00107R\u0014\u0010:\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b:\u00107R$\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010B\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bB\u0010\t\"\u0004\bD\u0010ER\"\u0010F\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u00107\u001a\u0004\bG\u0010H\"\u0004\bI\u0010'R\"\u0010J\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010C\u001a\u0004\bJ\u0010\t\"\u0004\bK\u0010ER$\u0010L\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u00107\u001a\u0004\bM\u0010H\"\u0004\bN\u0010'¨\u0006O"}, d2 = {"Lcom/qiahao/nextvideo/data/service/match/MatchingProvide;", "", "<init>", "()V", "", "enterMatchPool", "sendEventAndEnterMatchPool", "", "isStartMatching", "()Z", "", "avatarUrl", "Lcom/qiahao/nextvideo/ui/reusable/views/MatchingFloatView$Mode;", Constants.KEY_MODE, "matchUniqueId", "refreshMatchingFloatView", "(Ljava/lang/String;Lcom/qiahao/nextvideo/ui/reusable/views/MatchingFloatView$Mode;Ljava/lang/String;)V", "Landroid/app/Activity;", AgooConstants.OPEN_ACTIIVTY_NAME, "showMatchingFloatView", "(Landroid/app/Activity;)Z", "exitMatchingPool", "otherUserExternalId", "conditionCountry", "conditionSex", "Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/base_common/network/model/ApiResponse;", "accept", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "remoteUserID", "", "from", "rejectInviteType", "rejectInvite", "(Ljava/lang/String;Ljava/lang/String;II)Lio/reactivex/rxjava3/core/i0;", "getMatchConfigSendEvent", "getSensitiveWord", "fetchConfigurationParam", "cancelConnection", "(Ljava/lang/String;)V", "Lcom/qiahao/nextvideo/data/service/match/MatchConfigData;", "matchConfigData", "Lcom/qiahao/nextvideo/data/service/match/MatchConfigData;", "getMatchConfigData", "()Lcom/qiahao/nextvideo/data/service/match/MatchConfigData;", "setMatchConfigData", "(Lcom/qiahao/nextvideo/data/service/match/MatchConfigData;)V", "Lnd/a;", "mDisposables", "Lnd/a;", "getMDisposables", "()Lnd/a;", "setMDisposables", "(Lnd/a;)V", "MATCH_DEFAULT", "Ljava/lang/String;", "MATCH_START_MATCH", "MATCH_PENDING", "IS_VIDEO", "Lcom/qiahao/nextvideo/data/model/MatchingFloatData;", "matchingFloatData", "Lcom/qiahao/nextvideo/data/model/MatchingFloatData;", "getMatchingFloatData", "()Lcom/qiahao/nextvideo/data/model/MatchingFloatData;", "setMatchingFloatData", "(Lcom/qiahao/nextvideo/data/model/MatchingFloatData;)V", "isOpenDrawer", "Z", "setOpenDrawer", "(Z)V", "matchStatue", "getMatchStatue", "()Ljava/lang/String;", "setMatchStatue", "isMatching", "setMatching", "videoID", "getVideoID", "setVideoID", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MatchingProvide {

    @NotNull
    public static final String IS_VIDEO = "isVideo";

    @NotNull
    public static final String MATCH_DEFAULT = "default";

    @NotNull
    public static final String MATCH_PENDING = "pending";

    @NotNull
    public static final String MATCH_START_MATCH = "startMatch";
    private static boolean isMatching;
    private static boolean isOpenDrawer;

    @Nullable
    private static MatchConfigData matchConfigData;

    @Nullable
    private static MatchingFloatData matchingFloatData;

    @Nullable
    private static String videoID;

    @NotNull
    public static final MatchingProvide INSTANCE = new MatchingProvide();

    @NotNull
    private static nd.a mDisposables = new nd.a();

    @NotNull
    private static String matchStatue = "default";

    private MatchingProvide() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cancelConnection$lambda$12(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            n5.e.c("手动掉用关闭匹配最小化的弹窗 在连接状态时的操作接口 操作成功");
        } else {
            n5.e.c("手动掉用关闭匹配最小化的弹窗 在连接状态时的操作接口 操作失败");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cancelConnection$lambda$13(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        n5.e.c("手动掉用关闭匹配最小化的弹窗 在连接状态时的操作接口 操作失败");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit enterMatchPool$lambda$0(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        isMatching = false;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit enterMatchPool$lambda$1(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if ((th instanceof HiloException) && ((HiloException) th).getCode() == 4000) {
            cf.c.c().l(new VideoEvent("MATCH_SHOW_RECHARGE", new Object()));
        }
        isMatching = false;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02b0, code lost:
    
        if (android.text.TextUtils.isEmpty(r10.getResourceUrl()) == false) goto L١٦٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x02b8, code lost:
    
        r1 = r10.getResourceUrl();
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x02bc, code lost:
    
        if (r1 != null) goto L١٦٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02bf, code lost:
    
        r7 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02c0, code lost:
    
        r3.downloadSkin(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02c3, code lost:
    
        com.oudi.utils.store.IStore.DefaultImpls.setValue$default(r0, "skin_configuration", r8.getGSON().s(r10), (java.lang.String) null, 4, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02b6, code lost:
    
        if (r2.exists() == false) goto L١٦٢;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit fetchConfigurationParam$lambda$10(ApiResponse apiResponse) {
        Object obj;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Object obj2;
        String str7;
        ConfigurationParam configurationParam;
        String chargeUrl;
        String str8;
        String str9;
        String str10;
        Object obj3;
        String str11;
        String str12;
        String str13;
        String str14;
        boolean z;
        String str15;
        SkinConfiguration skin;
        String str16;
        String str17;
        String familyWheelUrl;
        Boolean showDiscoverCountry;
        Boolean showGameLudoUno;
        String taskUrl;
        String lobbyUrl;
        String cpUrl;
        String idUrl;
        String groupPowerActUrl;
        String groupPowerGradeUrl;
        Boolean agentAllow;
        String rankingPinkDiamondUrl;
        String mgrGuildDataUrl;
        String guildDataUrl;
        String defaultAvatarUrlWoman;
        String defaultAvatarUrlMan;
        Integer unionUserScreenCaptureInSec;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        ConfigurationParam configurationParam2 = (ConfigurationParam) apiResponse.getData();
        String str18 = "";
        if (configurationParam2 == null || (unionUserScreenCaptureInSec = configurationParam2.getUnionUserScreenCaptureInSec()) == null) {
            obj = "";
        } else {
            obj = unionUserScreenCaptureInSec;
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "screenCapture", obj, (String) null, 4, (Object) null);
        GroupService.Companion companion = GroupService.INSTANCE;
        GroupService companion2 = companion.getInstance();
        ConfigurationParam configurationParam3 = (ConfigurationParam) apiResponse.getData();
        if (configurationParam3 == null || (str = configurationParam3.getUserLevelH5()) == null) {
            str = "";
        }
        companion2.setLevelH5(str);
        GroupService companion3 = companion.getInstance();
        ConfigurationParam configurationParam4 = (ConfigurationParam) apiResponse.getData();
        if (configurationParam4 == null || (str2 = configurationParam4.getGroupSupportH5()) == null) {
            str2 = "";
        }
        companion3.setGroupSupportH5(str2);
        ConfigurationParam configurationParam5 = (ConfigurationParam) apiResponse.getData();
        if (configurationParam5 != null && (defaultAvatarUrlMan = configurationParam5.getDefaultAvatarUrlMan()) != null) {
            UserStore.INSTANCE.getShared().setMNormalManAvatarUrl(defaultAvatarUrlMan);
        }
        ConfigurationParam configurationParam6 = (ConfigurationParam) apiResponse.getData();
        if (configurationParam6 != null && (defaultAvatarUrlWoman = configurationParam6.getDefaultAvatarUrlWoman()) != null) {
            UserStore.INSTANCE.getShared().setMNormalWomanAvatarUrl(defaultAvatarUrlWoman);
        }
        GroupService companion4 = companion.getInstance();
        ConfigurationParam configurationParam7 = (ConfigurationParam) apiResponse.getData();
        if (configurationParam7 == null || (str3 = configurationParam7.getLuckyWheelH5()) == null) {
            str3 = "";
        }
        companion4.setLuckWheelH5(str3);
        ConfigurationParam configurationParam8 = (ConfigurationParam) apiResponse.getData();
        if (configurationParam8 == null || (guildDataUrl = configurationParam8.getGuildDataUrl()) == null) {
            str4 = "";
        } else {
            str4 = guildDataUrl;
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "guildDataUrl", str4, (String) null, 4, (Object) null);
        ConfigurationParam configurationParam9 = (ConfigurationParam) apiResponse.getData();
        if (configurationParam9 == null || (mgrGuildDataUrl = configurationParam9.getMgrGuildDataUrl()) == null) {
            str5 = "";
        } else {
            str5 = mgrGuildDataUrl;
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "mgrGuildDataUrl", str5, (String) null, 4, (Object) null);
        ConfigurationParam configurationParam10 = (ConfigurationParam) apiResponse.getData();
        if (configurationParam10 == null || (rankingPinkDiamondUrl = configurationParam10.getRankingPinkDiamondUrl()) == null) {
            str6 = "";
        } else {
            str6 = rankingPinkDiamondUrl;
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "rankingPinkDiamondUrl", str6, (String) null, 4, (Object) null);
        ConfigurationParam configurationParam11 = (ConfigurationParam) apiResponse.getData();
        if (configurationParam11 == null || (agentAllow = configurationParam11.getAgentAllow()) == null) {
            obj2 = "";
        } else {
            obj2 = agentAllow;
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "vc_allow", obj2, (String) null, 4, (Object) null);
        ConfigurationParam configurationParam12 = (ConfigurationParam) apiResponse.getData();
        if (configurationParam12 != null) {
            str7 = configurationParam12.getChargeUrl();
        } else {
            str7 = null;
        }
        if (TextUtils.isEmpty(str7) || (configurationParam = (ConfigurationParam) apiResponse.getData()) == null || (chargeUrl = configurationParam.getChargeUrl()) == null) {
            str8 = "";
        } else {
            str8 = chargeUrl;
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "charge_url", str8, (String) null, 4, (Object) null);
        ConfigurationParam configurationParam13 = (ConfigurationParam) apiResponse.getData();
        if (configurationParam13 == null || (groupPowerGradeUrl = configurationParam13.getGroupPowerGradeUrl()) == null) {
            str9 = "";
        } else {
            str9 = groupPowerGradeUrl;
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "family_level_url", str9, (String) null, 4, (Object) null);
        ConfigurationParam configurationParam14 = (ConfigurationParam) apiResponse.getData();
        if (configurationParam14 == null || (groupPowerActUrl = configurationParam14.getGroupPowerActUrl()) == null) {
            str10 = "";
        } else {
            str10 = groupPowerActUrl;
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "family_activity_url", str10, (String) null, 4, (Object) null);
        BaseApplication.Companion companion5 = BaseApplication.Companion;
        com.google.gson.d gson = companion5.getGSON();
        ConfigurationParam configurationParam15 = (ConfigurationParam) apiResponse.getData();
        if (configurationParam15 == null || (obj3 = configurationParam15.getGameUrlConfigs()) == null) {
            obj3 = "";
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "game_url", gson.s(obj3), (String) null, 4, (Object) null);
        ConfigurationParam configurationParam16 = (ConfigurationParam) apiResponse.getData();
        if (configurationParam16 == null || (idUrl = configurationParam16.getIdUrl()) == null) {
            str11 = "";
        } else {
            str11 = idUrl;
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "id_help_url", str11, (String) null, 4, (Object) null);
        ConfigurationParam configurationParam17 = (ConfigurationParam) apiResponse.getData();
        if (configurationParam17 == null || (cpUrl = configurationParam17.getCpUrl()) == null) {
            str12 = "";
        } else {
            str12 = cpUrl;
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "CP_activity_url", str12, (String) null, 4, (Object) null);
        ConfigurationParam configurationParam18 = (ConfigurationParam) apiResponse.getData();
        if (configurationParam18 == null || (lobbyUrl = configurationParam18.getLobbyUrl()) == null) {
            str13 = "";
        } else {
            str13 = lobbyUrl;
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "game_activity_url", str13, (String) null, 4, (Object) null);
        ConfigurationParam configurationParam19 = (ConfigurationParam) apiResponse.getData();
        if (configurationParam19 == null || (taskUrl = configurationParam19.getTaskUrl()) == null) {
            str14 = "";
        } else {
            str14 = taskUrl;
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "task_activity_url", str14, (String) null, 4, (Object) null);
        ConfigurationParam configurationParam20 = (ConfigurationParam) apiResponse.getData();
        boolean z2 = false;
        if (configurationParam20 != null && (showGameLudoUno = configurationParam20.getShowGameLudoUno()) != null) {
            z = showGameLudoUno.booleanValue();
        } else {
            z = false;
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "SHOW_lUDO_UNO", Boolean.valueOf(z), (String) null, 4, (Object) null);
        ConfigurationParam configurationParam21 = (ConfigurationParam) apiResponse.getData();
        if (configurationParam21 != null && (showDiscoverCountry = configurationParam21.getShowDiscoverCountry()) != null) {
            z2 = showDiscoverCountry.booleanValue();
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "SHOW_COUNTRY_DISCOVER", Boolean.valueOf(z2), (String) null, 4, (Object) null);
        ConfigurationParam configurationParam22 = (ConfigurationParam) apiResponse.getData();
        if (configurationParam22 == null || (familyWheelUrl = configurationParam22.getFamilyWheelUrl()) == null) {
            str15 = "";
        } else {
            str15 = familyWheelUrl;
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "FAMILY_WHEEL_URL", str15, (String) null, 4, (Object) null);
        ConfigurationParam configurationParam23 = (ConfigurationParam) apiResponse.getData();
        if (configurationParam23 != null && (skin = configurationParam23.getSkin()) != null) {
            SkinConfiguration skinConfiguration = (SkinConfiguration) companion5.getGSON().j((String) IStore.DefaultImpls.getValue$default(mMKVStore, "skin_configuration", "", (String) null, 4, (Object) null), SkinConfiguration.class);
            SkinMessage skinMessage = SkinMessage.INSTANCE;
            SkinData skinData = skinMessage.skinData();
            if (skinData == null || (str16 = skinData.getTabButtonBg()) == null) {
                str16 = "";
            }
            File file = new File(str16);
            if (skin.getOn()) {
                if (skinConfiguration == null || (str17 = skinConfiguration.getResourceUrl()) == null) {
                    str17 = "";
                }
                if (!Intrinsics.areEqual(str17, skin.getResourceUrl())) {
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fetchConfigurationParam$lambda$11(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMatchConfigSendEvent$lambda$2(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        matchConfigData = (MatchConfigData) apiResponse.getData();
        cf.c.c().l(new VideoEvent("MATCH_REFRESH_CARD", new Object()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMatchConfigSendEvent$lambda$3(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getSensitiveWord$lambda$5(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ArrayList<String> arrayList = (ArrayList) apiResponse.getData();
        if (arrayList != null) {
            SensitiveUtil.INSTANCE.saveData(arrayList);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getSensitiveWord$lambda$6(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void refreshMatchingFloatView$default(MatchingProvide matchingProvide, String str, MatchingFloatView.Mode mode, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        matchingProvide.refreshMatchingFloatView(str, mode, str2);
    }

    public static /* synthetic */ i0 rejectInvite$default(MatchingProvide matchingProvide, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        return matchingProvide.rejectInvite(str, str2, i, i2);
    }

    @NotNull
    public final i0<ApiResponse<Object>> accept(@NotNull String matchUniqueId, @NotNull String otherUserExternalId, @NotNull String conditionCountry, @NotNull String conditionSex) {
        Intrinsics.checkNotNullParameter(matchUniqueId, "matchUniqueId");
        Intrinsics.checkNotNullParameter(otherUserExternalId, "otherUserExternalId");
        Intrinsics.checkNotNullParameter(conditionCountry, "conditionCountry");
        Intrinsics.checkNotNullParameter(conditionSex, "conditionSex");
        return AppServer.INSTANCE.getApis().accept(matchUniqueId, otherUserExternalId, conditionSex, conditionCountry);
    }

    public final void cancelConnection(@NotNull String matchUniqueId) {
        Intrinsics.checkNotNullParameter(matchUniqueId, "matchUniqueId");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().close(matchUniqueId), new Function1() { // from class: com.qiahao.nextvideo.data.service.match.c
            public final Object invoke(Object obj) {
                Unit cancelConnection$lambda$12;
                cancelConnection$lambda$12 = MatchingProvide.cancelConnection$lambda$12((ApiResponse) obj);
                return cancelConnection$lambda$12;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.data.service.match.d
            public final Object invoke(Object obj) {
                Unit cancelConnection$lambda$13;
                cancelConnection$lambda$13 = MatchingProvide.cancelConnection$lambda$13((Throwable) obj);
                return cancelConnection$lambda$13;
            }
        }, (Function0) null, false, 12, (Object) null), mDisposables);
    }

    public final void enterMatchPool() {
        String str;
        Country countryInfo;
        if (!isMatching && isStartMatching()) {
            isMatching = true;
            ServerApi apis = AppServer.INSTANCE.getApis();
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user == null || (countryInfo = user.getCountryInfo()) == null || (str = countryInfo.getShortName()) == null) {
                str = "";
            }
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.joinMatch(0, str), new Function1() { // from class: com.qiahao.nextvideo.data.service.match.g
                public final Object invoke(Object obj) {
                    Unit enterMatchPool$lambda$0;
                    enterMatchPool$lambda$0 = MatchingProvide.enterMatchPool$lambda$0((ApiResponse) obj);
                    return enterMatchPool$lambda$0;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.data.service.match.h
                public final Object invoke(Object obj) {
                    Unit enterMatchPool$lambda$1;
                    enterMatchPool$lambda$1 = MatchingProvide.enterMatchPool$lambda$1((Throwable) obj);
                    return enterMatchPool$lambda$1;
                }
            }, (Function0) null, false, 12, (Object) null), mDisposables);
        }
    }

    public final void exitMatchingPool() {
        getMatchConfigSendEvent();
        cf.c.c().l(new VideoEvent("DEFAULT", new Object()));
        nd.c subscribe = AppServer.INSTANCE.getApis().exitMatchPool().subscribeOn(ke.a.b()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.data.service.match.MatchingProvide$exitMatchingPool$1
            public final void accept(ApiResponse<RandomPairChatroomConfig> apiResponse) {
                Intrinsics.checkNotNullParameter(apiResponse, "it");
                if (apiResponse.isOk()) {
                    n5.e.b("exitMatchingPool 退出匹配池成功");
                }
            }
        }, new pd.g() { // from class: com.qiahao.nextvideo.data.service.match.MatchingProvide$exitMatchingPool$2
            public final void accept(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
                n5.e.b("exitMatchingPool 退出匹配池失败");
                if (th instanceof HiloException) {
                    ((HiloException) th).getCode();
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, mDisposables);
    }

    public final void fetchConfigurationParam() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().fetchConfigurationParam(), new Function1() { // from class: com.qiahao.nextvideo.data.service.match.a
            public final Object invoke(Object obj) {
                Unit fetchConfigurationParam$lambda$10;
                fetchConfigurationParam$lambda$10 = MatchingProvide.fetchConfigurationParam$lambda$10((ApiResponse) obj);
                return fetchConfigurationParam$lambda$10;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.data.service.match.b
            public final Object invoke(Object obj) {
                Unit fetchConfigurationParam$lambda$11;
                fetchConfigurationParam$lambda$11 = MatchingProvide.fetchConfigurationParam$lambda$11((Throwable) obj);
                return fetchConfigurationParam$lambda$11;
            }
        }, (Function0) null, false, 12, (Object) null), mDisposables);
    }

    @NotNull
    public final nd.a getMDisposables() {
        return mDisposables;
    }

    @Nullable
    public final MatchConfigData getMatchConfigData() {
        return matchConfigData;
    }

    public final void getMatchConfigSendEvent() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getMatchConfigData(), new Function1() { // from class: com.qiahao.nextvideo.data.service.match.e
            public final Object invoke(Object obj) {
                Unit matchConfigSendEvent$lambda$2;
                matchConfigSendEvent$lambda$2 = MatchingProvide.getMatchConfigSendEvent$lambda$2((ApiResponse) obj);
                return matchConfigSendEvent$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.data.service.match.f
            public final Object invoke(Object obj) {
                Unit matchConfigSendEvent$lambda$3;
                matchConfigSendEvent$lambda$3 = MatchingProvide.getMatchConfigSendEvent$lambda$3((Throwable) obj);
                return matchConfigSendEvent$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), mDisposables);
    }

    @NotNull
    public final String getMatchStatue() {
        return matchStatue;
    }

    @Nullable
    public final MatchingFloatData getMatchingFloatData() {
        return matchingFloatData;
    }

    public final void getSensitiveWord() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getSensitiveWord(), new Function1() { // from class: com.qiahao.nextvideo.data.service.match.i
            public final Object invoke(Object obj) {
                Unit sensitiveWord$lambda$5;
                sensitiveWord$lambda$5 = MatchingProvide.getSensitiveWord$lambda$5((ApiResponse) obj);
                return sensitiveWord$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.data.service.match.j
            public final Object invoke(Object obj) {
                Unit sensitiveWord$lambda$6;
                sensitiveWord$lambda$6 = MatchingProvide.getSensitiveWord$lambda$6((Throwable) obj);
                return sensitiveWord$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null), mDisposables);
    }

    @Nullable
    public final String getVideoID() {
        return videoID;
    }

    public final boolean isMatching() {
        return isMatching;
    }

    public final boolean isOpenDrawer() {
        return isOpenDrawer;
    }

    public final boolean isStartMatching() {
        return Intrinsics.areEqual(matchStatue, MATCH_START_MATCH);
    }

    public final void refreshMatchingFloatView(@NotNull String avatarUrl, @NotNull MatchingFloatView.Mode mode, @NotNull String matchUniqueId) {
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(mode, Constants.KEY_MODE);
        Intrinsics.checkNotNullParameter(matchUniqueId, "matchUniqueId");
        matchingFloatData = new MatchingFloatData(avatarUrl, mode, matchUniqueId);
        cf.c.c().l(matchingFloatData);
    }

    @NotNull
    public final i0<ApiResponse<Object>> rejectInvite(@NotNull String matchUniqueId, @NotNull String remoteUserID, int from, int rejectInviteType) {
        Intrinsics.checkNotNullParameter(matchUniqueId, "matchUniqueId");
        Intrinsics.checkNotNullParameter(remoteUserID, "remoteUserID");
        return AppServer.INSTANCE.getApis().rejectInvite(matchUniqueId, remoteUserID, rejectInviteType, from);
    }

    public final void sendEventAndEnterMatchPool() {
        matchStatue = MATCH_START_MATCH;
        cf.c.c().l(new VideoEvent("START_MATCH", new Object()));
        enterMatchPool();
    }

    public final void setMDisposables(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        mDisposables = aVar;
    }

    public final void setMatchConfigData(@Nullable MatchConfigData matchConfigData2) {
        matchConfigData = matchConfigData2;
    }

    public final void setMatchStatue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        matchStatue = str;
    }

    public final void setMatching(boolean z) {
        isMatching = z;
    }

    public final void setMatchingFloatData(@Nullable MatchingFloatData matchingFloatData2) {
        matchingFloatData = matchingFloatData2;
    }

    public final void setOpenDrawer(boolean z) {
        isOpenDrawer = z;
    }

    public final void setVideoID(@Nullable String str) {
        videoID = str;
    }

    public final boolean showMatchingFloatView(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
        int oldHomeViewControllerTap = UserService.INSTANCE.getOldHomeViewControllerTap();
        if ((activity instanceof VideoCallActivity) || (activity instanceof MatchVideoActivity)) {
            return false;
        }
        boolean z = isOpenDrawer;
        if (z) {
            if (!Intrinsics.areEqual(matchStatue, MATCH_START_MATCH) && !Intrinsics.areEqual(matchStatue, MATCH_PENDING)) {
                return false;
            }
            return true;
        }
        if (z || oldHomeViewControllerTap == 0) {
            return false;
        }
        if (!Intrinsics.areEqual(matchStatue, MATCH_START_MATCH) && !Intrinsics.areEqual(matchStatue, MATCH_PENDING)) {
            return false;
        }
        return true;
    }
}
