package com.qiahao.nextvideo.data;

import android.app.Activity;
import android.os.CancellationSignal;
import android.text.TextUtils;
import androidx.core.app.r;
import androidx.credentials.ClearCredentialStateRequest;
import androidx.credentials.CredentialManager;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.exceptions.ClearCredentialException;
import com.alibaba.sdk.android.push.CommonCallback;
import com.alibaba.sdk.android.push.noonesdk.PushServiceFactory;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.google.gson.d;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.common.PhoneInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.model.UserSummaryInfo;
import com.qiahao.nextvideo.data.service.TIMService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.data.service.agora.HiloRtcEngine;
import com.qiahao.nextvideo.data.service.match.MatchingProvide;
import com.qiahao.nextvideo.data.service.match.WebSocketProvide;
import com.qiahao.nextvideo.data.strange.StrangeConfirm;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.ui.transfer.TransferCenterFragment;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 Q2\u00020\u0001:\u0001QB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ7\u0010\u0011\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0003J\u0017\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u0011\u0010\u001fJ\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020 2\u0006\u0010!\u001a\u00020\b¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\b¢\u0006\u0004\b,\u0010\u001cR(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010-\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u0010.\u001a\u0004\b/\u00100R.\u00101\u001a\u0004\u0018\u00010\u00062\b\u0010-\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00107\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00102\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\"\u0010:\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u00102\u001a\u0004\b;\u00104\"\u0004\b<\u00106R%\u0010@\u001a\u0010\u0012\f\u0012\n ?*\u0004\u0018\u00010>0>0=8\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR=\u0010F\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020  ?*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020 \u0018\u00010E0E0D8\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR=\u0010J\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b ?*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010E0E0D8\u0006¢\u0006\f\n\u0004\bJ\u0010G\u001a\u0004\bK\u0010IR%\u0010L\u001a\u0010\u0012\f\u0012\n ?*\u0004\u0018\u00010\u001d0\u001d0D8\u0006¢\u0006\f\n\u0004\bL\u0010G\u001a\u0004\bM\u0010IR%\u0010N\u001a\u0010\u0012\f\u0012\n ?*\u0004\u0018\u00010\b0\b0D8\u0006¢\u0006\f\n\u0004\bN\u0010G\u001a\u0004\bO\u0010IR\u0011\u0010P\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bP\u0010\u001c¨\u0006R"}, d2 = {"Lcom/qiahao/nextvideo/data/UserStore;", "", "<init>", "()V", "", "persistUserObject", "", "extraId", "", "isMySelf", "(Ljava/lang/String;)Z", "Lcom/qiahao/base_common/model/common/User;", "user", "token", "Lcom/qiahao/nextvideo/data/UserObjectEventType;", "type", "shouldSilence", "refreshUserInfo", "(Lcom/qiahao/base_common/model/common/User;Ljava/lang/String;Lcom/qiahao/nextvideo/data/UserObjectEventType;Z)V", "", TransferCenterFragment.TYPE_DIAMONDS, "pinkDiamondNum", "refreshDiamondOrGem", "(DD)V", "logout", "fetchUserDetailInfo", "(Z)V", "hasMatchingNotificationOpened", "()Z", "Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "userSummaryInfo", "(Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;)V", "", "isBind", "bindOrUnBindThirdSuccess", "(IZ)V", "Lcom/qiahao/base_common/model/common/PhoneInfo;", "data", "changeBindPhone", "(Lcom/qiahao/base_common/model/common/PhoneInfo;)V", "Lcom/qiahao/nextvideo/data/strange/StrangeConfirm;", "confirm", "changeNameAndAvatar", "(Lcom/qiahao/nextvideo/data/strange/StrangeConfirm;)V", "checkSvipAndWealth", "value", "Lcom/qiahao/base_common/model/common/User;", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "authenticationToken", "Ljava/lang/String;", "getAuthenticationToken", "()Ljava/lang/String;", "setAuthenticationToken", "(Ljava/lang/String;)V", "mNormalWomanAvatarUrl", "getMNormalWomanAvatarUrl", "setMNormalWomanAvatarUrl", "mNormalManAvatarUrl", "getMNormalManAvatarUrl", "setMNormalManAvatarUrl", "Lla/b;", "Lcom/qiahao/nextvideo/data/UserObjectEvent;", "kotlin.jvm.PlatformType", "userObjectRelay", "Lla/b;", "getUserObjectRelay", "()Lla/b;", "Lla/c;", "Lkotlin/Pair;", "foreverHeartRelay", "Lla/c;", "getForeverHeartRelay", "()Lla/c;", "likeEventRelay", "getLikeEventRelay", "createdSessionEventRelay", "getCreatedSessionEventRelay", "viewPagePublicRelay", "getViewPagePublicRelay", "isAuthenticated", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUserStore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserStore.kt\ncom/qiahao/nextvideo/data/UserStore\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,357:1\n1#2:358\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class UserStore {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "UserStore";

    @NotNull
    private static final UserStore shared = new UserStore();

    @Nullable
    private String authenticationToken;

    @NotNull
    private final la.c createdSessionEventRelay;

    @NotNull
    private final la.c foreverHeartRelay;

    @NotNull
    private final la.c likeEventRelay;

    @Nullable
    private User user;

    @NotNull
    private final la.b userObjectRelay;

    @NotNull
    private final la.c viewPagePublicRelay;

    @NotNull
    private String mNormalWomanAvatarUrl = "";

    @NotNull
    private String mNormalManAvatarUrl = "";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/data/UserStore$Companion;", "", "<init>", "()V", "TAG", "", "getTAG$annotations", "getTAG", "()Ljava/lang/String;", "shared", "Lcom/qiahao/nextvideo/data/UserStore;", "getShared", "()Lcom/qiahao/nextvideo/data/UserStore;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getTAG$annotations() {
        }

        @NotNull
        public final UserStore getShared() {
            return UserStore.shared;
        }

        @NotNull
        public final String getTAG() {
            return UserStore.TAG;
        }

        private Companion() {
        }
    }

    public UserStore() {
        la.b e = la.b.e();
        Intrinsics.checkNotNullExpressionValue(e, "create(...)");
        this.userObjectRelay = e;
        la.c e2 = la.c.e();
        Intrinsics.checkNotNullExpressionValue(e2, "create(...)");
        this.foreverHeartRelay = e2;
        la.c e3 = la.c.e();
        Intrinsics.checkNotNullExpressionValue(e3, "create(...)");
        this.likeEventRelay = e3;
        la.c e4 = la.c.e();
        Intrinsics.checkNotNullExpressionValue(e4, "create(...)");
        this.createdSessionEventRelay = e4;
        la.c e5 = la.c.e();
        Intrinsics.checkNotNullExpressionValue(e5, "create(...)");
        this.viewPagePublicRelay = e5;
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        String str = (String) IStore.DefaultImpls.getValue$default(mMKVStore, "keyUser", "", (String) null, 4, (Object) null);
        setAuthenticationToken((String) IStore.DefaultImpls.getValue$default(mMKVStore, "keyAuthToken", "", (String) null, 4, (Object) null));
        try {
            User user = (User) new d().j(str, User.class);
            this.user = user;
            if (user == null) {
                setAuthenticationToken(null);
                IStore.DefaultImpls.setValue$default(mMKVStore, "user_id", "", (String) null, 4, (Object) null);
            } else if (TextUtils.isEmpty(getAuthenticationToken())) {
                this.user = null;
            }
        } catch (Exception e6) {
            DebugToolsKt.printf(e6);
        }
        this.userObjectRelay.accept(new UserObjectEvent(this.user, System.currentTimeMillis(), UserObjectEventType.REFRESH));
    }

    public static /* synthetic */ void fetchUserDetailInfo$default(UserStore userStore, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        userStore.fetchUserDetailInfo(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fetchUserDetailInfo$lambda$6(UserStore userStore, boolean z, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        refreshUserInfo$default(userStore, (User) apiResponse.getData(), null, UserObjectEventType.REFRESH, z, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fetchUserDetailInfo$lambda$7(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = "";
        }
        DebugToolsKt.printfE(TAG, localizedMessage);
        return Unit.INSTANCE;
    }

    @NotNull
    public static final String getTAG() {
        return INSTANCE.getTAG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logout$lambda$4$lambda$3() {
    }

    private final void persistUserObject() {
        User user = this.user;
        if (user != null) {
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "keyUser", BaseApplication.Companion.getGSON().s(user), (String) null, 4, (Object) null);
        }
    }

    public static /* synthetic */ void refreshDiamondOrGem$default(UserStore userStore, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = -1.0d;
        }
        if ((i & 2) != 0) {
            d2 = -1.0d;
        }
        userStore.refreshDiamondOrGem(d, d2);
    }

    public static /* synthetic */ void refreshUserInfo$default(UserStore userStore, User user, String str, UserObjectEventType userObjectEventType, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            userObjectEventType = UserObjectEventType.REFRESH;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        userStore.refreshUserInfo(user, str, userObjectEventType, z);
    }

    public final void bindOrUnBindThirdSuccess(int type, boolean isBind) {
        Iterator it;
        ArrayList thirdList;
        ArrayList thirdList2;
        if (isBind) {
            User user = this.user;
            if (user != null && (thirdList2 = user.getThirdList()) != null) {
                thirdList2.add(Integer.valueOf(type));
            }
        } else {
            User user2 = this.user;
            if (user2 != null && (thirdList = user2.getThirdList()) != null) {
                it = thirdList.iterator();
            } else {
                it = null;
            }
            while (it != null && it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                if (((Number) next).intValue() == type) {
                    it.remove();
                }
            }
        }
        persistUserObject();
    }

    public final void changeBindPhone(@Nullable PhoneInfo data) {
        ArrayList thirdList;
        if (data != null) {
            User user = this.user;
            if (user != null && (thirdList = user.getThirdList()) != null) {
                thirdList.add(1);
            }
            User user2 = this.user;
            if (user2 != null) {
                user2.setPhoneInfo(data);
            }
            persistUserObject();
        }
    }

    public final void changeNameAndAvatar(@Nullable StrangeConfirm confirm) {
        if (confirm != null) {
            User user = this.user;
            if (user != null) {
                user.setMaskAvatar(confirm.getAvatar());
            }
            User user2 = this.user;
            if (user2 != null) {
                user2.setMaskNick(confirm.getNick());
            }
            persistUserObject();
        }
    }

    public final boolean checkSvipAndWealth() {
        int i;
        long j;
        SvipData svip;
        User user = this.user;
        if (user != null && (svip = user.getSvip()) != null) {
            i = svip.getSvipLevel();
        } else {
            i = 0;
        }
        if (i <= 0) {
            User user2 = this.user;
            if (user2 != null) {
                j = user2.getWealthUserGrade();
            } else {
                j = 0;
            }
            if (j <= 10) {
                return false;
            }
        }
        return true;
    }

    public final void fetchUserDetailInfo(final boolean shouldSilence) {
        if (isAuthenticated()) {
            RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().fetchUserDetailInfo(), new Function1() { // from class: com.qiahao.nextvideo.data.b
                public final Object invoke(Object obj) {
                    Unit fetchUserDetailInfo$lambda$6;
                    fetchUserDetailInfo$lambda$6 = UserStore.fetchUserDetailInfo$lambda$6(UserStore.this, shouldSilence, (ApiResponse) obj);
                    return fetchUserDetailInfo$lambda$6;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.data.c
                public final Object invoke(Object obj) {
                    Unit fetchUserDetailInfo$lambda$7;
                    fetchUserDetailInfo$lambda$7 = UserStore.fetchUserDetailInfo$lambda$7((Throwable) obj);
                    return fetchUserDetailInfo$lambda$7;
                }
            }, (Function0) null, false, 12, (Object) null);
        }
    }

    @Nullable
    public final String getAuthenticationToken() {
        return (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "keyAuthToken", this.authenticationToken, (String) null, 4, (Object) null);
    }

    @NotNull
    public final la.c getCreatedSessionEventRelay() {
        return this.createdSessionEventRelay;
    }

    @NotNull
    public final la.c getForeverHeartRelay() {
        return this.foreverHeartRelay;
    }

    @NotNull
    public final la.c getLikeEventRelay() {
        return this.likeEventRelay;
    }

    @NotNull
    public final String getMNormalManAvatarUrl() {
        return this.mNormalManAvatarUrl;
    }

    @NotNull
    public final String getMNormalWomanAvatarUrl() {
        return this.mNormalWomanAvatarUrl;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    @NotNull
    public final la.b getUserObjectRelay() {
        return this.userObjectRelay;
    }

    @NotNull
    public final la.c getViewPagePublicRelay() {
        return this.viewPagePublicRelay;
    }

    public final boolean hasMatchingNotificationOpened() {
        User user = this.user;
        if (user != null) {
            return Intrinsics.areEqual(user.isTradeUnionMatchNotification(), Boolean.TRUE);
        }
        return false;
    }

    public final boolean isAuthenticated() {
        User user;
        if (!Intrinsics.areEqual(IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "keyUser", "", (String) null, 4, (Object) null), "") && (user = this.user) != null && user.isCompleteMaterial()) {
            return true;
        }
        return false;
    }

    public final boolean isMySelf(@NotNull String extraId) {
        String str;
        Intrinsics.checkNotNullParameter(extraId, "extraId");
        User user = this.user;
        if (user == null) {
            return false;
        }
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, extraId);
    }

    public final void logout() {
        if (this.user == null) {
            return;
        }
        this.user = null;
        setAuthenticationToken(null);
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        IStore.DefaultImpls.setValue$default(mMKVStore, "user_id", "", (String) null, 4, (Object) null);
        if (FacebookSdk.isInitialized() && AccessToken.Companion.getCurrentAccessToken() != null) {
            LoginManager.Companion.getInstance().logOut();
        }
        ActivityLifecycleManager activityLifecycleManager = ActivityLifecycleManager.INSTANCE;
        Activity currentActivity = activityLifecycleManager.currentActivity();
        if (currentActivity != null) {
            ClearCredentialStateRequest clearCredentialStateRequest = new ClearCredentialStateRequest();
            CredentialManager create = CredentialManager.Companion.create(currentActivity);
            CancellationSignal cancellationSignal = new CancellationSignal();
            cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: com.qiahao.nextvideo.data.a
                @Override // android.os.CancellationSignal.OnCancelListener
                public final void onCancel() {
                    UserStore.logout$lambda$4$lambda$3();
                }
            });
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor(...)");
            create.clearCredentialStateAsync(clearCredentialStateRequest, cancellationSignal, newSingleThreadExecutor, new CredentialManagerCallback<Void, ClearCredentialException>() { // from class: com.qiahao.nextvideo.data.UserStore$logout$1$2
                public void onError(ClearCredentialException e) {
                    Intrinsics.checkNotNullParameter(e, "e");
                }

                public void onResult(Void result) {
                }
            });
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "keyUser", "", (String) null, 4, (Object) null);
        IStore.DefaultImpls.setValue$default(mMKVStore, "keyAuthToken", "", (String) null, 4, (Object) null);
        IStore.DefaultImpls.setValue$default(mMKVStore, "google_token", "", (String) null, 4, (Object) null);
        IStore.DefaultImpls.setValue$default(mMKVStore, "main_activity_data", "", (String) null, 4, (Object) null);
        try {
            Activity currentActivity2 = activityLifecycleManager.currentActivity();
            if (currentActivity2 != null) {
                r.d(currentActivity2).b();
            }
            PushServiceFactory.getCloudPushService().unbindAccount((CommonCallback) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MatchingProvide.INSTANCE.exitMatchingPool();
        WebSocketProvide.INSTANCE.disconnect();
        TIMService.INSTANCE.logout();
        HiloRtcEngine.INSTANCE.destroy();
        MeetingRoomManager.leaveRoom$default(MeetingRoomManager.INSTANCE, false, 1, null);
        BaseControlUtils.INSTANCE.exitToMainActivity();
    }

    public final void refreshDiamondOrGem(double diamonds, double pinkDiamondNum) {
        User user;
        User user2;
        if (diamonds >= 0.0d && (user2 = this.user) != null) {
            user2.setDiamondNum(diamonds);
        }
        if (pinkDiamondNum >= 0.0d && (user = this.user) != null) {
            user.setPinkDiamondNum(Double.valueOf(pinkDiamondNum));
        }
        persistUserObject();
        User user3 = this.user;
        if (user3 != null) {
            this.userObjectRelay.accept(new UserObjectEvent(user3, System.currentTimeMillis(), UserObjectEventType.REFRESH_MONEY));
        }
    }

    public final void refreshUserInfo(@Nullable User user, @Nullable String token, @NotNull UserObjectEventType type, boolean shouldSilence) {
        User user2;
        Intrinsics.checkNotNullParameter(type, "type");
        if (user == null) {
            return;
        }
        this.user = user;
        if (type == UserObjectEventType.AUTHENTICATE || type == UserObjectEventType.LOGIN || type == UserObjectEventType.FILLUESRINFO) {
            setAuthenticationToken(token);
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "user_id", String.valueOf(user.getId()), (String) null, 4, (Object) null);
        }
        persistUserObject();
        if (shouldSilence || (user2 = this.user) == null) {
            return;
        }
        this.userObjectRelay.accept(new UserObjectEvent(user2, System.currentTimeMillis(), type));
    }

    public final void setAuthenticationToken(@Nullable String str) {
        this.authenticationToken = str;
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        if (str == null) {
            str = "";
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "keyAuthToken", str, (String) null, 4, (Object) null);
    }

    public final void setMNormalManAvatarUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mNormalManAvatarUrl = str;
    }

    public final void setMNormalWomanAvatarUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mNormalWomanAvatarUrl = str;
    }

    public final void refreshUserInfo(@NotNull UserSummaryInfo userSummaryInfo) {
        Intrinsics.checkNotNullParameter(userSummaryInfo, "userSummaryInfo");
        User user = this.user;
        if (user != null) {
            user.setCountryIcon(userSummaryInfo.getCountryImage());
            user.setCountry(userSummaryInfo.getCountryName());
            user.setNick(userSummaryInfo.getName());
            String avatar = userSummaryInfo.getAvatar();
            if (avatar == null) {
                avatar = user.getAvatar();
            }
            user.setAvatar(avatar);
            user.setDescription(userSummaryInfo.getDescription());
            user.setShowAge(userSummaryInfo.isShowAge());
            Integer sex = userSummaryInfo.getSex();
            user.setSex(sex != null ? sex.intValue() : 0);
            refreshUserInfo$default(this, user, null, null, false, 14, null);
        }
    }
}
