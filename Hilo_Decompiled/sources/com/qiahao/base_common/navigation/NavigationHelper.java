package com.qiahao.base_common.navigation;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.lifecycle.Lifecycle;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.HttpConstant;
import com.facebook.share.internal.ShareConstants;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.ktx.StringKtxKt;
import com.oudi.utils.log.ILog;
import com.oudi.utils.log.LogUtil;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.model.cache.MMKVKey;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import com.qiahao.base_common.utils.language.LanguageHelper;
import com.therouter.TheRouter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020'2\u0006\u0010\"\u001a\u00020\u0005H\u0002J\u0010\u0010+\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010,\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010-\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010.\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010/\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u00100\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u00101\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u00102\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0016\u00103\u001a\u00020'2\f\u00104\u001a\b\u0012\u0004\u0012\u00020'05H\u0002J\u0014\u00106\u001a\u00020!2\n\u00107\u001a\u0006\u0012\u0002\b\u000308H\u0002J?\u00109\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052*\u0010:\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050<0;\"\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050<¢\u0006\u0002\u0010=J\u000e\u0010>\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005J\u000e\u0010?\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005J\u0016\u0010@\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/qiahao/base_common/navigation/NavigationHelper;", "Lcom/oudi/utils/log/ILog;", "<init>", "()V", "SCHEME_HILO", "", "USER_ID", "GROUP_ID", "TOKEN", "LANGUAGE", "FAMILY_ID", "MATCH_ID", "CURRENT_ROOM_ID", "PATH_ROOM_LIVE", "PATH_USER_PERSON", "PATH_ROOM_SUPPORT", "PATH_VIDEO_CALL", "WALLET", "CHAT", "FAMILY", "GEM_STORE", "MEMORIAL", "CP_ZONE", "GAME", "TASK", "PRAISE", "SVIP", "NOBLE_BAG", "NOBLE", "GAME_LEVEL", "GAME_BAI_SHUN", "PEOPLE_CERTIFICATION", "jump", "", "url", "callback", "Lcom/oudi/core/callback/SuperCallBack;", "", "jumpNative", "", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "jumpH5", "jumpFamily", "jumpChat", "jumpGame", "jumpVideoCall", "jumpPerson", "jumpCpZone", "jumpGroupSupport", "jumpLive", "jumpHandler", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function0;", "equalsCurrentActivity", "targetActivity", "Ljava/lang/Class;", "addParams", "pair", "", "Lkotlin/Pair;", "(Ljava/lang/String;[Lkotlin/Pair;)Ljava/lang/String;", "addUserStatus", "addLanguage", "addGroupStatus", NavigationHelper.GROUP_ID, "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nNavigationHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavigationHelper.kt\ncom/qiahao/base_common/navigation/NavigationHelper\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,450:1\n13472#2,2:451\n*S KotlinDebug\n*F\n+ 1 NavigationHelper.kt\ncom/qiahao/base_common/navigation/NavigationHelper\n*L\n394#1:451,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class NavigationHelper implements ILog {

    @NotNull
    private static final String CHAT = "/chat";

    @NotNull
    private static final String CP_ZONE = "/cpZone";

    @NotNull
    public static final String CURRENT_ROOM_ID = "current_room_id";

    @NotNull
    private static final String FAMILY = "/family";

    @NotNull
    public static final String FAMILY_ID = "family_id";

    @NotNull
    private static final String GAME = "/matchGame";

    @NotNull
    private static final String GAME_BAI_SHUN = "/baiShunCenter";

    @NotNull
    private static final String GAME_LEVEL = "/gameLevel";

    @NotNull
    private static final String GEM_STORE = "/gemStore";

    @NotNull
    private static final String GROUP_ID = "groupId";

    @NotNull
    public static final NavigationHelper INSTANCE = new NavigationHelper();

    @NotNull
    private static final String LANGUAGE = "language";

    @NotNull
    public static final String MATCH_ID = "match_id";

    @NotNull
    private static final String MEMORIAL = "/memorial";

    @NotNull
    private static final String NOBLE = "/noble";

    @NotNull
    private static final String NOBLE_BAG = "/nobleBag";

    @NotNull
    private static final String PATH_ROOM_LIVE = "/room/live";

    @NotNull
    private static final String PATH_ROOM_SUPPORT = "/room/support";

    @NotNull
    private static final String PATH_USER_PERSON = "/user/person";

    @NotNull
    private static final String PATH_VIDEO_CALL = "/video/call";

    @NotNull
    private static final String PEOPLE_CERTIFICATION = "/peopleCertification";

    @NotNull
    private static final String PRAISE = "/praise";

    @NotNull
    private static final String SCHEME_HILO = "hilo";

    @NotNull
    private static final String SVIP = "/svip";

    @NotNull
    private static final String TASK = "/task";

    @NotNull
    private static final String TOKEN = "token";

    @NotNull
    private static final String USER_ID = "user_id";

    @NotNull
    private static final String WALLET = "/wallet";

    private NavigationHelper() {
    }

    private final boolean equalsCurrentActivity(Class<?> targetActivity) {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null && Intrinsics.areEqual(currentActivity.getClass().getSimpleName(), targetActivity.getSimpleName())) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean jump$default(NavigationHelper navigationHelper, String str, SuperCallBack superCallBack, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            superCallBack = null;
        }
        return navigationHelper.jump(str, superCallBack);
    }

    private final void jumpChat(Uri uri) {
        String queryParameter = uri.getQueryParameter("externalId");
        if (queryParameter != null) {
            String decode = URLDecoder.decode(queryParameter, "UTF-8");
            AppService service = AppController.INSTANCE.getService();
            if (service != null) {
                Intrinsics.checkNotNull(decode);
                service.toChat(decode);
            }
        }
    }

    private final void jumpCpZone(Uri uri) {
        String queryParameter = uri.getQueryParameter("externalId");
        if (queryParameter != null) {
            String decode = URLDecoder.decode(queryParameter, "UTF-8");
            AppService service = AppController.INSTANCE.getService();
            if (service != null) {
                Intrinsics.checkNotNull(decode);
                service.openCpZone(decode);
            }
        }
    }

    private final void jumpFamily(Uri uri) {
        String queryParameter = uri.getQueryParameter("familyId");
        if (queryParameter != null) {
            try {
                String decode = URLDecoder.decode(queryParameter, "UTF-8");
                AppService service = AppController.INSTANCE.getService();
                if (service != null) {
                    Intrinsics.checkNotNull(decode);
                    service.openFamily(Long.parseLong(decode));
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    private final void jumpGame(Uri uri) {
        try {
            BaseControlUtils.INSTANCE.matchGame(StringKtxKt.toDefaultInt$default(StringKtxKt.decode(uri.getQueryParameter("matchId")), 0, 1, null), StringKtxKt.toDefaultInt$default(StringKtxKt.decode(uri.getQueryParameter("gameId")), 0, 1, null), StringKtxKt.toDefaultInt$default(StringKtxKt.decode(uri.getQueryParameter("mode")), 0, 1, null), StringKtxKt.toDefaultInt$default(StringKtxKt.decode(uri.getQueryParameter("gameType")), 0, 1, null));
        } catch (Exception unused) {
            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "解析参数出错", false, 4, (Object) null);
        }
    }

    private final void jumpGroupSupport(Uri uri) {
        AppService service;
        User user;
        String queryParameter = uri.getQueryParameter(GROUP_ID);
        if ((queryParameter == null || queryParameter.length() == 0) && ((service = AppController.INSTANCE.getService()) == null || (user = service.getUser()) == null || (queryParameter = user.getGroupId()) == null)) {
            queryParameter = "";
        }
        if (!TextUtils.isEmpty(StringsKt.trim((CharSequence) queryParameter).toString())) {
            String decode = URLDecoder.decode(queryParameter, "UTF-8");
            AppService appService = (AppService) TheRouter.get(AppService.class, new Object[0]);
            if (appService != null) {
                Intrinsics.checkNotNull(decode);
                appService.openGroupSupport(decode);
            }
        }
    }

    private final void jumpH5(String url) {
        AppService service;
        String queryParameter = Uri.parse(url).getQueryParameter("direction");
        String queryParameter2 = Uri.parse(url).getQueryParameter("dbr");
        String str = "";
        if (queryParameter2 == null) {
            queryParameter2 = "";
        }
        String queryParameter3 = Uri.parse(url).getQueryParameter("gameType");
        if (queryParameter3 != null) {
            str = queryParameter3;
        }
        String decode = URLDecoder.decode(queryParameter2, "UTF-8");
        if (TextUtils.isEmpty(queryParameter)) {
            if (Intrinsics.areEqual(decode, "1")) {
                AppService service2 = AppController.INSTANCE.getService();
                if (service2 != null) {
                    service2.openDefaultBrowser(url);
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(str, "15")) {
                AppService service3 = AppController.INSTANCE.getService();
                if (service3 != null) {
                    service3.openBaiShunH5(url);
                    return;
                }
                return;
            }
            AppService service4 = AppController.INSTANCE.getService();
            if (service4 != null) {
                service4.openH5(url);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(URLDecoder.decode(queryParameter, "UTF-8"), "1") && (service = AppController.INSTANCE.getService()) != null) {
            service.openHorizontalH5(url);
        }
    }

    private final void jumpHandler(final Function0<Unit> block) {
        ActivityLifecycleManager activityLifecycleManager = ActivityLifecycleManager.INSTANCE;
        if (activityLifecycleManager.isAppOnBackground()) {
            ILog.DefaultImpls.logD$default(this, "jumpHandler() 应用处于后台", null, false, 6, null);
            activityLifecycleManager.addLifecycleTask(Lifecycle.Event.ON_START, new Function0() { // from class: cb.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit jumpHandler$lambda$6;
                    jumpHandler$lambda$6 = NavigationHelper.jumpHandler$lambda$6(Function0.this);
                    return jumpHandler$lambda$6;
                }
            });
        } else {
            block.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit jumpHandler$lambda$6(Function0 function0) {
        ILog.DefaultImpls.logD$default(INSTANCE, "jumpHandler() 应用从新可见，执行跳转", null, false, 6, null);
        function0.invoke();
        return Unit.INSTANCE;
    }

    private final void jumpLive(Uri uri) {
        String queryParameter = uri.getQueryParameter(GROUP_ID);
        if (queryParameter != null) {
            String decode = URLDecoder.decode(queryParameter, "UTF-8");
            AppService service = AppController.INSTANCE.getService();
            if (service != null) {
                Intrinsics.checkNotNull(decode);
                service.joinLive(decode);
            }
        }
    }

    private final void jumpNative(Uri uri) {
        String path = uri.getPath();
        if (path != null) {
            switch (path.hashCode()) {
                case -2032192280:
                    if (path.equals(WALLET)) {
                        AppService service = AppController.INSTANCE.getService();
                        if (service != null) {
                            service.openWallet();
                            return;
                        }
                        return;
                    }
                    break;
                case -1758161327:
                    if (path.equals(PATH_ROOM_LIVE)) {
                        jumpLive(uri);
                        return;
                    }
                    break;
                case -1580788735:
                    if (path.equals(GEM_STORE)) {
                        AppService service2 = AppController.INSTANCE.getService();
                        if (service2 != null) {
                            service2.openGemStore();
                            return;
                        }
                        return;
                    }
                    break;
                case -963801636:
                    if (path.equals(PEOPLE_CERTIFICATION)) {
                        AppService service3 = AppController.INSTANCE.getService();
                        if (service3 != null) {
                            service3.openPeopleCertification();
                            return;
                        }
                        return;
                    }
                    break;
                case -561450626:
                    if (path.equals(GAME_BAI_SHUN)) {
                        AppService service4 = AppController.INSTANCE.getService();
                        if (service4 != null) {
                            service4.openBaiShunCenter();
                            return;
                        }
                        return;
                    }
                    break;
                case -220062495:
                    if (path.equals(PATH_VIDEO_CALL)) {
                        jumpVideoCall(uri);
                        return;
                    }
                    break;
                case -32574456:
                    if (path.equals(GAME)) {
                        jumpGame(uri);
                        return;
                    }
                    break;
                case 46457863:
                    if (path.equals(CHAT)) {
                        jumpChat(uri);
                        return;
                    }
                    break;
                case 46948217:
                    if (path.equals(SVIP)) {
                        AppService service5 = AppController.INSTANCE.getService();
                        if (service5 != null) {
                            service5.openSVIP();
                            return;
                        }
                        return;
                    }
                    break;
                case 46958132:
                    if (path.equals(TASK)) {
                        AppService service6 = AppController.INSTANCE.getService();
                        if (service6 != null) {
                            service6.openTask();
                            return;
                        }
                        return;
                    }
                    break;
                case 311931403:
                    if (path.equals(MEMORIAL)) {
                        AppService service7 = AppController.INSTANCE.getService();
                        if (service7 != null) {
                            service7.openMemorial();
                            return;
                        }
                        return;
                    }
                    break;
                case 336972643:
                    if (path.equals(GAME_LEVEL)) {
                        AppService service8 = AppController.INSTANCE.getService();
                        if (service8 != null) {
                            service8.openGameLevel();
                            return;
                        }
                        return;
                    }
                    break;
                case 1450561835:
                    if (path.equals(NOBLE)) {
                        AppService service9 = AppController.INSTANCE.getService();
                        if (service9 != null) {
                            service9.openAristocracy();
                            return;
                        }
                        return;
                    }
                    break;
                case 1703511720:
                    if (path.equals(CP_ZONE)) {
                        jumpCpZone(uri);
                        return;
                    }
                    break;
                case 1776106579:
                    if (path.equals(FAMILY)) {
                        jumpFamily(uri);
                        return;
                    }
                    break;
                case 1871651466:
                    if (path.equals(PATH_USER_PERSON)) {
                        jumpPerson(uri);
                        return;
                    }
                    break;
                case 1998087242:
                    if (path.equals(PATH_ROOM_SUPPORT)) {
                        jumpGroupSupport(uri);
                        return;
                    }
                    break;
                case 2021727965:
                    if (path.equals(NOBLE_BAG)) {
                        AppService service10 = AppController.INSTANCE.getService();
                        if (service10 != null) {
                            service10.openAristocracyBag();
                            return;
                        }
                        return;
                    }
                    break;
                case 2077740651:
                    if (path.equals(PRAISE)) {
                        AppService service11 = AppController.INSTANCE.getService();
                        if (service11 != null) {
                            service11.openPraise();
                            return;
                        }
                        return;
                    }
                    break;
            }
        }
        throw new NavigationException(4);
    }

    private final void jumpPerson(Uri uri) {
        String queryParameter = uri.getQueryParameter("externalId");
        if (queryParameter != null) {
            String decode = URLDecoder.decode(queryParameter, "UTF-8");
            AppService service = AppController.INSTANCE.getService();
            if (service != null) {
                Intrinsics.checkNotNull(decode);
                service.openPersonPage(decode);
            }
        }
    }

    private final void jumpVideoCall(Uri uri) {
        String queryParameter = uri.getQueryParameter("externalId");
        if (queryParameter != null) {
            String decode = URLDecoder.decode(queryParameter, "UTF-8");
            AppService service = AppController.INSTANCE.getService();
            if (service != null) {
                Intrinsics.checkNotNull(decode);
                service.videoCall(decode);
            }
        }
    }

    @NotNull
    public final String addGroupStatus(@NotNull String url, @NotNull String groupId) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        if (!StringsKt.contains$default((CharSequence) url, (CharSequence) GROUP_ID, false, 2, (Object) null)) {
            return addParams(url, new Pair<>(GROUP_ID, groupId));
        }
        return url;
    }

    @NotNull
    public final String addLanguage(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (!StringsKt.contains$default((CharSequence) url, (CharSequence) "language", false, 2, (Object) null)) {
            return addParams(url, new Pair<>("language", URLEncoder.encode(LanguageHelper.INSTANCE.getSystemLanguage().getLanguage(), "UTF-8")));
        }
        return url;
    }

    @NotNull
    public final String addParams(@NotNull String url, @NotNull Pair<String, String>... pair) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(pair, "pair");
        if (url.length() == 0 || pair.length == 0) {
            return url;
        }
        StringBuilder sb = new StringBuilder(url);
        if (!StringsKt.contains$default((CharSequence) url, (CharSequence) "?", false, 2, (Object) null)) {
            sb.append("?");
        }
        for (Pair<String, String> pair2 : pair) {
            if (!Intrinsics.areEqual(String.valueOf(StringsKt.last(sb)), "?")) {
                sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            }
            String format = String.format("%s=%s", Arrays.copyOf(new Object[]{pair2.getFirst(), URLEncoder.encode(pair2.getSecond(), "UTF-8")}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            sb.append(format);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    @NotNull
    public final String addUserStatus(@NotNull String url) {
        String str;
        Intrinsics.checkNotNullParameter(url, "url");
        if (!StringsKt.contains$default((CharSequence) url, (CharSequence) "token", false, 2, (Object) null)) {
            str = addParams(url, new Pair<>("token", URLEncoder.encode((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVKey.USER_TOKEN, "", null, 4, null), "UTF-8")));
        } else {
            str = url;
        }
        if (!StringsKt.contains$default((CharSequence) url, (CharSequence) "user_id", false, 2, (Object) null)) {
            str = addParams(str, new Pair<>("user_id", URLEncoder.encode((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "user_id", "", null, 4, null), "UTF-8")));
        }
        return addLanguage(str);
    }

    @Override // com.oudi.utils.log.ILog
    @NotNull
    public String getLogTag() {
        return ILog.DefaultImpls.getLogTag(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:
    
        if (r2.equals(anet.channel.util.HttpConstant.HTTP) != false) goto L٢١;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:7:0x0003, B:9:0x0009, B:11:0x0013, B:17:0x0026, B:20:0x0039, B:22:0x004d, B:25:0x0031, B:27:0x003d, B:29:0x0045, B:30:0x0057, B:31:0x005c, B:3:0x005d, B:4:0x0062), top: B:6:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean jump(@Nullable String url, @Nullable SuperCallBack<Object> callback) {
        if (url != null) {
            try {
                if (url.length() != 0) {
                    Uri parse = Uri.parse(url);
                    String scheme = parse.getScheme();
                    if (scheme != null) {
                        int hashCode = scheme.hashCode();
                        if (hashCode != 3202628) {
                            if (hashCode != 3213448) {
                                if (hashCode == 99617003 && scheme.equals(HttpConstant.HTTPS)) {
                                    jumpH5(url);
                                }
                            }
                            if (callback == null) {
                                callback.onSuccess(new Object());
                                return true;
                            }
                            return true;
                        }
                        if (scheme.equals(SCHEME_HILO)) {
                            Intrinsics.checkNotNull(parse);
                            jumpNative(parse);
                            if (callback == null) {
                            }
                        }
                    }
                    throw new NavigationException(4);
                }
            } catch (Exception e10) {
                ILog.DefaultImpls.logE$default(this, "jump()-error url:" + url, e10, null, true, 4, null);
                if (callback != null) {
                    callback.onFailure(e10);
                    return false;
                }
                return false;
            }
        }
        throw new NavigationException(4);
    }

    @Override // com.oudi.utils.log.ILog
    public void logD(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logD(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logI(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logI(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logV(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logV(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logW(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logW(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, th, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
        ILog.DefaultImpls.logE(this, th, str, z10);
    }
}
