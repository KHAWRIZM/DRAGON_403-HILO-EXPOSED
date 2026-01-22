package com.qiahao.nextvideo.utilities;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.log.LogUtil;
import com.qhqc.lib.indicate.IndicateService;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.interfaceing.SelectInterface;
import com.qiahao.base_common.model.common.ChannelEventGiftAddTime;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.model.im.StrangeChange;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.ReportWhiteDialog;
import com.qiahao.base_common.ui.dialog.TipBlackDialog;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.DialogItemData;
import com.qiahao.nextvideo.data.model.VideoResultData;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.manager.GroupEvent;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.qiahao.nextvideo.ui.base.BlockOrReportDialog;
import com.qiahao.nextvideo.ui.home.chat.activity.ChatActivity;
import com.qiahao.nextvideo.ui.home.chat.activity.ChatStrangeActivity;
import com.qiahao.nextvideo.ui.im.StrangerProvide;
import com.qiahao.nextvideo.ui.profile.activity.OtherUserActivity;
import com.qiahao.nextvideo.ui.profile.activity.OwnUserActivity;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.ui.videocall.VideoResultActivity;
import com.taobao.accs.utl.BaseMonitor;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMConversationManager;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.tuichat.hilo.network.ChatServer;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJH\u0010\u0015\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b0\u000e2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\fJ%\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\b¢\u0006\u0004\b \u0010\u0003J\u0015\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010\fJ\u001d\u0010%\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u001b¢\u0006\u0004\b%\u0010&JP\u0010*\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010'\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00042%\b\u0002\u0010)\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\b\u0018\u00010\u000e¢\u0006\u0004\b*\u0010+JN\u0010*\u001a\u00020\b2\u0006\u0010-\u001a\u00020,2\b\b\u0002\u0010'\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00042%\b\u0002\u0010)\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\b\u0018\u00010\u000e¢\u0006\u0004\b*\u0010.Jm\u00105\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00042<\b\u0002\u0010)\u001a6\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b((\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\b\u0018\u00010/2\u0018\b\u0002\u00104\u001a\u0012\u0012\u0004\u0012\u00020201j\b\u0012\u0004\u0012\u000202`3¢\u0006\u0004\b5\u00106Jk\u0010:\u001a\u00020\b2\u0006\u00108\u001a\u0002072\u0006\u0010\u0017\u001a\u00020\u00042<\b\u0002\u0010)\u001a6\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b((\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\b\u0018\u00010/2\u0006\u00109\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u001b¢\u0006\u0004\b:\u0010;Ju\u0010?\u001a\u00020\b2\u0006\u00108\u001a\u0002072\u0006\u00100\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u001b2<\b\u0002\u0010)\u001a6\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b((\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\b\u0018\u00010/2\b\b\u0002\u0010>\u001a\u00020\u0006¢\u0006\u0004\b?\u0010@J\u0015\u0010B\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u0004¢\u0006\u0004\bB\u0010\fJ\u001d\u0010G\u001a\u00020\b2\u0006\u0010D\u001a\u00020C2\u0006\u0010F\u001a\u00020E¢\u0006\u0004\bG\u0010HJ\r\u0010I\u001a\u00020\b¢\u0006\u0004\bI\u0010\u0003J\r\u0010J\u001a\u00020\b¢\u0006\u0004\bJ\u0010\u0003R\"\u0010L\u001a\u00020K8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010R\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006X"}, d2 = {"Lcom/qiahao/nextvideo/utilities/AppRequestUtils;", "", "<init>", "()V", "", SupportGiftRankActivity.EXTERNAL_ID, "", "fromChat", "", "openPersonPage", "(Ljava/lang/String;Z)V", "openChatActivity", "(Ljava/lang/String;)V", TUIConstants.TUILive.ROOM_ID, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isNeed", com.taobao.agoo.a.a.b.JSON_SUCCESS, "Lkotlin/Function0;", BaseMonitor.COUNT_ERROR, "checkRoomPassword", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "groupId", "callServiceLeaveRoom", "", GameMatchActivity.GAME_ID, "", "opt", "gameCode", "sudGameEnd", "(JILjava/lang/String;)V", "refreshDiamondOrGem", VideoResultActivity.VIDEO_MATCH_UNIQUE_ID, "videoEnd", "matchUniqueId", "endType", "endCallReport", "(Ljava/lang/String;I)V", "isDialog", "isSuccess", "listener", "openStrangeChatActivity", "(Ljava/lang/String;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Lcom/qiahao/base_common/model/common/User;", "user", "(Lcom/qiahao/base_common/model/common/User;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "type", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/DialogItemData;", "Lkotlin/collections/ArrayList;", "list", "roomReportOrBlack", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Ljava/util/ArrayList;)V", "Landroid/app/Activity;", AgooConstants.OPEN_ACTIIVTY_NAME, "isBlock", "showTipDialog", "(Landroid/app/Activity;Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZI)V", "uniqueKey", "notRecommend", "isRoom", "notRecommendRoom", "(Landroid/app/Activity;ILjava/lang/String;ILkotlin/jvm/functions/Function2;Z)V", "token", "uploadToken", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleCoroutineScope;", "appLifecycleScope", "serviceDeviceID", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleCoroutineScope;)V", "roomStartMusic", "roomStopMusic", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "startPersonPage", "Z", "getStartPersonPage", "()Z", "setStartPersonPage", "(Z)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppRequestUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppRequestUtils.kt\ncom/qiahao/nextvideo/utilities/AppRequestUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,533:1\n1#2:534\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AppRequestUtils {

    @NotNull
    public static final AppRequestUtils INSTANCE = new AppRequestUtils();

    @NotNull
    private static nd.a mCompositeDisposable = new nd.a();
    private static boolean startPersonPage;

    private AppRequestUtils() {
    }

    public static final Unit callServiceLeaveRoom$lambda$12(String str, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        n5.e.c(str + " callServiceLeaveRoom: 告诉后端离开房间-成功");
        return Unit.INSTANCE;
    }

    public static final Unit callServiceLeaveRoom$lambda$13(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        n5.e.c(str + "  callServiceLeaveRoom: 告诉后端离开房间-失败");
        return Unit.INSTANCE;
    }

    public static final Unit checkRoomPassword$lambda$10(Function1 function1, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        function1.invoke(Boolean.valueOf(Intrinsics.areEqual(apiResponse.getData(), Boolean.TRUE)));
        return Unit.INSTANCE;
    }

    public static final Unit checkRoomPassword$lambda$11(Function0 function0, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void notRecommendRoom$default(AppRequestUtils appRequestUtils, Activity activity, int i, String str, int i2, Function2 function2, boolean z, int i3, Object obj) {
        boolean z2;
        if ((i3 & 16) != 0) {
            function2 = null;
        }
        Function2 function22 = function2;
        if ((i3 & 32) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        appRequestUtils.notRecommendRoom(activity, i, str, i2, function22, z2);
    }

    public static /* synthetic */ void openChatActivity$default(AppRequestUtils appRequestUtils, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        appRequestUtils.openChatActivity(str);
    }

    public static final Unit openChatActivity$lambda$8(ApiResponse apiResponse) {
        User user;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null && (user = (User) apiResponse.getData()) != null) {
            ChatActivity.Companion.start$default(ChatActivity.INSTANCE, currentActivity, user, false, 4, null);
        }
        return Unit.INSTANCE;
    }

    public static final Unit openChatActivity$lambda$9(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void openPersonPage$default(AppRequestUtils appRequestUtils, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            z = false;
        }
        appRequestUtils.openPersonPage(str, z);
    }

    public static final void openPersonPage$lambda$5(String str) {
        String str2;
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        if (user != null) {
            str2 = user.getExternalId();
        } else {
            str2 = null;
        }
        if (Intrinsics.areEqual(str, str2)) {
            Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
            if (currentActivity != null) {
                OwnUserActivity.INSTANCE.start(currentActivity, companion.getShared().getUser());
            }
            startPersonPage = false;
            return;
        }
        UserService shared = UserService.INSTANCE.getShared();
        if (str == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.fetchUserDetail$default(shared, str, null, 2, null), new Function1() { // from class: com.qiahao.nextvideo.utilities.u
            public final Object invoke(Object obj) {
                Unit openPersonPage$lambda$5$lambda$3;
                openPersonPage$lambda$5$lambda$3 = AppRequestUtils.openPersonPage$lambda$5$lambda$3((ApiResponse) obj);
                return openPersonPage$lambda$5$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.utilities.v
            public final Object invoke(Object obj) {
                Unit openPersonPage$lambda$5$lambda$4;
                openPersonPage$lambda$5$lambda$4 = AppRequestUtils.openPersonPage$lambda$5$lambda$4((Throwable) obj);
                return openPersonPage$lambda$5$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null), mCompositeDisposable);
    }

    public static final Unit openPersonPage$lambda$5$lambda$3(ApiResponse apiResponse) {
        Activity currentActivity;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        User user = (User) apiResponse.getData();
        if (user != null && (currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity()) != null) {
            OtherUserActivity.INSTANCE.start(currentActivity, user);
        }
        startPersonPage = false;
        return Unit.INSTANCE;
    }

    public static final Unit openPersonPage$lambda$5$lambda$4(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        startPersonPage = false;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void openStrangeChatActivity$default(AppRequestUtils appRequestUtils, String str, boolean z, String str2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        appRequestUtils.openStrangeChatActivity(str, z, str2, (Function1<? super Boolean, Unit>) function1);
    }

    public static final Unit openStrangeChatActivity$lambda$21(boolean z, String str, Function1 function1, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        User user = (User) apiResponse.getData();
        if (user != null) {
            INSTANCE.openStrangeChatActivity(user, z, str, (Function1<? super Boolean, Unit>) function1);
        }
        return Unit.INSTANCE;
    }

    public static final Unit openStrangeChatActivity$lambda$22(Function1 function1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        return Unit.INSTANCE;
    }

    public static final Unit openStrangeChatActivity$lambda$25(Function1 function1, User user, boolean z, String str, ApiResponse apiResponse) {
        Activity currentActivity;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
        StrangeChange strangeChange = (StrangeChange) apiResponse.getData();
        if (strangeChange != null && (currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity()) != null) {
            ChatStrangeActivity.INSTANCE.start(currentActivity, user, z, str, strangeChange);
        }
        return Unit.INSTANCE;
    }

    public static final Unit openStrangeChatActivity$lambda$26(Function1 function1, final String str, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
            HiloException hiloException = (HiloException) th;
            String errorMessage = hiloException.getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(INSTANCE, 2131952751);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, currentActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            if (hiloException.getCode() == 27062 || hiloException.getCode() == 27063) {
                V2TIMManager.getInstance().quitGroup(str, null);
                V2TIMConversationManager conversationManager = V2TIMManager.getConversationManager();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("group_%s", Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                conversationManager.deleteConversation(format, new V2TIMCallback() { // from class: com.qiahao.nextvideo.utilities.AppRequestUtils$openStrangeChatActivity$4$1
                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onError(int code, String desc) {
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onSuccess() {
                        StrangerProvide strangerProvide = StrangerProvide.INSTANCE;
                        strangerProvide.getStrangerSet().remove(str);
                        strangerProvide.displayData();
                    }
                });
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0058, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1, r2) == false) goto L٥٢;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit refreshDiamondOrGem$lambda$16(ApiResponse apiResponse) {
        Double d;
        Double d2;
        double d3;
        Double d4;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        Double d5 = null;
        if (user != null) {
            d = Double.valueOf(user.getDiamondNum());
        } else {
            d = null;
        }
        ChannelEventGiftAddTime channelEventGiftAddTime = (ChannelEventGiftAddTime) apiResponse.getData();
        if (channelEventGiftAddTime != null) {
            d2 = Double.valueOf(channelEventGiftAddTime.getDiamondNum());
        } else {
            d2 = null;
        }
        if (Intrinsics.areEqual(d, d2)) {
            User user2 = companion.getShared().getUser();
            if (user2 != null) {
                d4 = user2.getPinkDiamondNum();
            } else {
                d4 = null;
            }
            ChannelEventGiftAddTime channelEventGiftAddTime2 = (ChannelEventGiftAddTime) apiResponse.getData();
            if (channelEventGiftAddTime2 != null) {
                d5 = Double.valueOf(channelEventGiftAddTime2.getPinkDiamondNum());
            }
        }
        UserStore shared = companion.getShared();
        ChannelEventGiftAddTime channelEventGiftAddTime3 = (ChannelEventGiftAddTime) apiResponse.getData();
        double d6 = 0.0d;
        if (channelEventGiftAddTime3 != null) {
            d3 = channelEventGiftAddTime3.getDiamondNum();
        } else {
            d3 = 0.0d;
        }
        ChannelEventGiftAddTime channelEventGiftAddTime4 = (ChannelEventGiftAddTime) apiResponse.getData();
        if (channelEventGiftAddTime4 != null) {
            d6 = channelEventGiftAddTime4.getPinkDiamondNum();
        }
        shared.refreshDiamondOrGem(d3, d6);
        return Unit.INSTANCE;
    }

    public static final Unit refreshDiamondOrGem$lambda$17(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void roomReportOrBlack$default(AppRequestUtils appRequestUtils, String str, Function2 function2, ArrayList arrayList, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            arrayList = BlockOrReportDialog.Companion.getTextList$default(BlockOrReportDialog.INSTANCE, BlockOrReportDialog.ROOM_LIST_REPORT_AND_DELETE, false, false, false, 14, null);
        }
        appRequestUtils.roomReportOrBlack(str, function2, arrayList);
    }

    public static final void roomStartMusic$lambda$32() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().roomStartMusic(), (Function1) null, (Function1) null, (Function0) null, false, 15, (Object) null), mCompositeDisposable);
    }

    public static final void roomStopMusic$lambda$33() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().roomStopMusic(), (Function1) null, (Function1) null, (Function0) null, false, 15, (Object) null), mCompositeDisposable);
    }

    public static /* synthetic */ void showTipDialog$default(AppRequestUtils appRequestUtils, Activity activity, String str, Function2 function2, boolean z, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function2 = null;
        }
        appRequestUtils.showTipDialog(activity, str, function2, z, i);
    }

    public static final Unit sudGameEnd$lambda$14(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "退出游戏成功", false, 4, (Object) null);
        return Unit.INSTANCE;
    }

    public static final Unit sudGameEnd$lambda$15(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "退出游戏失败", false, 4, (Object) null);
        return Unit.INSTANCE;
    }

    public static final void uploadToken$lambda$31(String str) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().uploadToken(str), new Function1() { // from class: com.qiahao.nextvideo.utilities.m
            public final Object invoke(Object obj) {
                Unit uploadToken$lambda$31$lambda$29;
                uploadToken$lambda$31$lambda$29 = AppRequestUtils.uploadToken$lambda$31$lambda$29((ApiResponse) obj);
                return uploadToken$lambda$31$lambda$29;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.utilities.n
            public final Object invoke(Object obj) {
                Unit uploadToken$lambda$31$lambda$30;
                uploadToken$lambda$31$lambda$30 = AppRequestUtils.uploadToken$lambda$31$lambda$30((Throwable) obj);
                return uploadToken$lambda$31$lambda$30;
            }
        }, (Function0) null, false, 12, (Object) null), mCompositeDisposable);
    }

    public static final Unit uploadToken$lambda$31$lambda$29(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        return Unit.INSTANCE;
    }

    public static final Unit uploadToken$lambda$31$lambda$30(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public static final Unit videoEnd$lambda$18(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        return Unit.INSTANCE;
    }

    public static final Unit videoEnd$lambda$19(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public final void callServiceLeaveRoom(@NotNull final String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().leaveRoom(groupId), new Function1() { // from class: com.qiahao.nextvideo.utilities.a
            public final Object invoke(Object obj) {
                Unit callServiceLeaveRoom$lambda$12;
                callServiceLeaveRoom$lambda$12 = AppRequestUtils.callServiceLeaveRoom$lambda$12(groupId, (ApiResponse) obj);
                return callServiceLeaveRoom$lambda$12;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.utilities.l
            public final Object invoke(Object obj) {
                Unit callServiceLeaveRoom$lambda$13;
                callServiceLeaveRoom$lambda$13 = AppRequestUtils.callServiceLeaveRoom$lambda$13(groupId, (Throwable) obj);
                return callServiceLeaveRoom$lambda$13;
            }
        }, (Function0) null, false, 12, (Object) null), mCompositeDisposable);
    }

    public final void checkRoomPassword(@NotNull String r9, @NotNull final Function1<? super Boolean, Unit> r10, @Nullable final Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r9, TUIConstants.TUILive.ROOM_ID);
        Intrinsics.checkNotNullParameter(r10, com.taobao.agoo.a.a.b.JSON_SUCCESS);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().checkGroupHasPassWord(r9), new Function1() { // from class: com.qiahao.nextvideo.utilities.f
            public final Object invoke(Object obj) {
                Unit checkRoomPassword$lambda$10;
                checkRoomPassword$lambda$10 = AppRequestUtils.checkRoomPassword$lambda$10(r10, (ApiResponse) obj);
                return checkRoomPassword$lambda$10;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.utilities.g
            public final Object invoke(Object obj) {
                Unit checkRoomPassword$lambda$11;
                checkRoomPassword$lambda$11 = AppRequestUtils.checkRoomPassword$lambda$11(r11, (Throwable) obj);
                return checkRoomPassword$lambda$11;
            }
        }, (Function0) null, false, 12, (Object) null), mCompositeDisposable);
    }

    public final void endCallReport(@NotNull final String matchUniqueId, int endType) {
        Intrinsics.checkNotNullParameter(matchUniqueId, "matchUniqueId");
        nd.c n = AppServer.INSTANCE.getApis().matchTalkingEnd(matchUniqueId, endType).p(ke.a.b()).k(ke.a.b()).n(new pd.g() { // from class: com.qiahao.nextvideo.utilities.AppRequestUtils$endCallReport$1
            public final void accept(ApiResponse<VideoResultData> apiResponse) {
                Intrinsics.checkNotNullParameter(apiResponse, "it");
                Log.d(AgoraRtcService.TAG, "MatchingService endCallReport: 调用视频结束接口结果 == " + matchUniqueId + " " + apiResponse.getCode());
            }
        }, new pd.g() { // from class: com.qiahao.nextvideo.utilities.AppRequestUtils$endCallReport$2
            public final void accept(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
                Log.d(AgoraRtcService.TAG, "MatchingService endCallReport: 调用视频结束接口结果 ==" + matchUniqueId + "  " + th.getMessage());
            }
        });
        Intrinsics.checkNotNullExpressionValue(n, "subscribe(...)");
        RxUtilsKt.addTo(n, mCompositeDisposable);
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return mCompositeDisposable;
    }

    public final boolean getStartPersonPage() {
        return startPersonPage;
    }

    public final void notRecommendRoom(@NotNull Activity r10, int type, @NotNull String uniqueKey, int notRecommend, @Nullable Function2<? super Boolean, ? super Integer, Unit> listener, boolean isRoom) {
        int i;
        Intrinsics.checkNotNullParameter(r10, AgooConstants.OPEN_ACTIIVTY_NAME);
        Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
        TipDialog tipDialog = new TipDialog(r10);
        if (notRecommend == 0) {
            i = 2131952339;
        } else {
            i = 2131952342;
        }
        tipDialog.setTipContent(ResourcesKtxKt.getStringById(this, i)).setDialogListener(new AppRequestUtils$notRecommendRoom$1(type, uniqueKey, notRecommend, listener, isRoom, r10)).show();
    }

    public final void openChatActivity(@NotNull String r11) {
        Intrinsics.checkNotNullParameter(r11, SupportGiftRankActivity.EXTERNAL_ID);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.fetchUserDetail$default(UserService.INSTANCE.getShared(), r11, null, 2, null), new Function1() { // from class: com.qiahao.nextvideo.utilities.d
            public final Object invoke(Object obj) {
                Unit openChatActivity$lambda$8;
                openChatActivity$lambda$8 = AppRequestUtils.openChatActivity$lambda$8((ApiResponse) obj);
                return openChatActivity$lambda$8;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.utilities.e
            public final Object invoke(Object obj) {
                Unit openChatActivity$lambda$9;
                openChatActivity$lambda$9 = AppRequestUtils.openChatActivity$lambda$9((Throwable) obj);
                return openChatActivity$lambda$9;
            }
        }, (Function0) null, false, 12, (Object) null), mCompositeDisposable);
    }

    public final void openPersonPage(@Nullable final String r2, boolean fromChat) {
        if (!startPersonPage && !TextUtils.isEmpty(r2)) {
            startPersonPage = true;
            HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.utilities.h
                @Override // java.lang.Runnable
                public final void run() {
                    AppRequestUtils.openPersonPage$lambda$5(r2);
                }
            });
        }
    }

    public final void openStrangeChatActivity(@NotNull String r11, final boolean isDialog, @NotNull final String groupId, @Nullable final Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(r11, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.fetchUserDetail$default(UserService.INSTANCE.getShared(), r11, null, 2, null), new Function1() { // from class: com.qiahao.nextvideo.utilities.w
            public final Object invoke(Object obj) {
                Unit openStrangeChatActivity$lambda$21;
                openStrangeChatActivity$lambda$21 = AppRequestUtils.openStrangeChatActivity$lambda$21(isDialog, groupId, listener, (ApiResponse) obj);
                return openStrangeChatActivity$lambda$21;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.utilities.x
            public final Object invoke(Object obj) {
                Unit openStrangeChatActivity$lambda$22;
                openStrangeChatActivity$lambda$22 = AppRequestUtils.openStrangeChatActivity$lambda$22(listener, (Throwable) obj);
                return openStrangeChatActivity$lambda$22;
            }
        }, (Function0) null, false, 12, (Object) null), mCompositeDisposable);
    }

    public final void refreshDiamondOrGem() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().fetchUserDiamond(), new Function1() { // from class: com.qiahao.nextvideo.utilities.q
            public final Object invoke(Object obj) {
                Unit refreshDiamondOrGem$lambda$16;
                refreshDiamondOrGem$lambda$16 = AppRequestUtils.refreshDiamondOrGem$lambda$16((ApiResponse) obj);
                return refreshDiamondOrGem$lambda$16;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.utilities.r
            public final Object invoke(Object obj) {
                Unit refreshDiamondOrGem$lambda$17;
                refreshDiamondOrGem$lambda$17 = AppRequestUtils.refreshDiamondOrGem$lambda$17((Throwable) obj);
                return refreshDiamondOrGem$lambda$17;
            }
        }, (Function0) null, false, 12, (Object) null), mCompositeDisposable);
    }

    public final void roomReportOrBlack(@NotNull final String groupId, @Nullable final Function2<? super Boolean, ? super Integer, Unit> listener, @NotNull ArrayList<DialogItemData> list) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(list, "list");
        final Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            BlockOrReportDialog blockOrReportDialog = new BlockOrReportDialog(currentActivity, list);
            blockOrReportDialog.setMListener(new SelectInterface() { // from class: com.qiahao.nextvideo.utilities.AppRequestUtils$roomReportOrBlack$1$1$1
                public void onSelect(int index) {
                    if (index != 0) {
                        if (index != 1) {
                            if (index == 100) {
                                AppRequestUtils.INSTANCE.notRecommendRoom(currentActivity, 2, groupId, 0, listener, true);
                                return;
                            }
                            return;
                        }
                        new TipBlackDialog(currentActivity, (Integer) null, 2, (DefaultConstructorMarker) null).setTipContent(ResourcesKtxKt.getStringById(this, 2131952131)).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131952331)).setDialogListener(new AppRequestUtils$roomReportOrBlack$1$1$1$onSelect$2(groupId, currentActivity, listener, index)).show();
                        return;
                    }
                    new ReportWhiteDialog(currentActivity).setListener(new AppRequestUtils$roomReportOrBlack$1$1$1$onSelect$1(groupId, currentActivity, listener, index)).show();
                }
            });
            blockOrReportDialog.show();
        }
    }

    public final void roomStartMusic() {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.utilities.b
            @Override // java.lang.Runnable
            public final void run() {
                AppRequestUtils.roomStartMusic$lambda$32();
            }
        });
    }

    public final void roomStopMusic() {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.utilities.c
            @Override // java.lang.Runnable
            public final void run() {
                AppRequestUtils.roomStopMusic$lambda$33();
            }
        });
    }

    public final void serviceDeviceID(@NotNull Context context, @NotNull LifecycleCoroutineScope appLifecycleScope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appLifecycleScope, "appLifecycleScope");
        IndicateService.Companion.init(context);
        BuildersKt.launch$default(appLifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new AppRequestUtils$serviceDeviceID$1(null), 3, (Object) null);
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        mCompositeDisposable = aVar;
    }

    public final void setStartPersonPage(boolean z) {
        startPersonPage = z;
    }

    public final void showTipDialog(@NotNull Activity r3, @NotNull final String groupId, @Nullable final Function2<? super Boolean, ? super Integer, Unit> listener, boolean isBlock, final int type) {
        Intrinsics.checkNotNullParameter(r3, AgooConstants.OPEN_ACTIIVTY_NAME);
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        if (isBlock) {
            GroupService.Companion companion = GroupService.INSTANCE;
            companion.getMGroupEventProcessorObservable().onNext(new GroupEvent().leaveGroup(groupId));
            cf.c.c().l(new LiveEvent("EXIT_ROOM", groupId));
            companion.getInstance().setBlockRoomIdList(groupId);
            companion.getMGroupEventProcessorObservable().onNext(new GroupEvent().blockRoomToLocal(groupId));
            if (listener != null) {
                listener.invoke(Boolean.TRUE, Integer.valueOf(type));
                return;
            }
            return;
        }
        new TipDialog(r3).setTipContent(ResourcesKtxKt.getStringById(this, 2131954490)).hideCancel(true).touchOutsideHide(false).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.utilities.AppRequestUtils$showTipDialog$1
            public void cancel() {
                OnCommonDialogListener.DefaultImpls.cancel(this);
            }

            public void confirm() {
                GroupService.Companion companion2 = GroupService.INSTANCE;
                companion2.getMGroupEventProcessorObservable().onNext(new GroupEvent().leaveGroup(groupId));
                cf.c.c().l(new LiveEvent("EXIT_ROOM", groupId));
                companion2.getInstance().setBlockRoomIdList(groupId);
                companion2.getMGroupEventProcessorObservable().onNext(new GroupEvent().blockRoomToLocal(groupId));
                Function2<Boolean, Integer, Unit> function2 = listener;
                if (function2 != null) {
                    function2.invoke(Boolean.TRUE, Integer.valueOf(type));
                }
            }
        }).show();
    }

    public final void sudGameEnd(long r15, int opt, @NotNull String gameCode) {
        Intrinsics.checkNotNullParameter(gameCode, "gameCode");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().reportSud(r15, opt, gameCode, MeetingRoomManager.INSTANCE.getMGroupId()), new Function1() { // from class: com.qiahao.nextvideo.utilities.o
            public final Object invoke(Object obj) {
                Unit sudGameEnd$lambda$14;
                sudGameEnd$lambda$14 = AppRequestUtils.sudGameEnd$lambda$14((ApiResponse) obj);
                return sudGameEnd$lambda$14;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.utilities.p
            public final Object invoke(Object obj) {
                Unit sudGameEnd$lambda$15;
                sudGameEnd$lambda$15 = AppRequestUtils.sudGameEnd$lambda$15((Throwable) obj);
                return sudGameEnd$lambda$15;
            }
        }, (Function0) null, false, 12, (Object) null), mCompositeDisposable);
    }

    public final void uploadToken(@NotNull final String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.utilities.i
            @Override // java.lang.Runnable
            public final void run() {
                AppRequestUtils.uploadToken$lambda$31(token);
            }
        });
    }

    public final void videoEnd(@NotNull String r9) {
        Intrinsics.checkNotNullParameter(r9, VideoResultActivity.VIDEO_MATCH_UNIQUE_ID);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().videoEnd(r9), new Function1() { // from class: com.qiahao.nextvideo.utilities.s
            public final Object invoke(Object obj) {
                Unit videoEnd$lambda$18;
                videoEnd$lambda$18 = AppRequestUtils.videoEnd$lambda$18((ApiResponse) obj);
                return videoEnd$lambda$18;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.utilities.t
            public final Object invoke(Object obj) {
                Unit videoEnd$lambda$19;
                videoEnd$lambda$19 = AppRequestUtils.videoEnd$lambda$19((Throwable) obj);
                return videoEnd$lambda$19;
            }
        }, (Function0) null, false, 12, (Object) null), mCompositeDisposable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void openStrangeChatActivity$default(AppRequestUtils appRequestUtils, User user, boolean z, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        appRequestUtils.openStrangeChatActivity(user, z, str, (Function1<? super Boolean, Unit>) function1);
    }

    public final void openStrangeChatActivity(@NotNull final User user, final boolean isDialog, @NotNull final String groupId, @Nullable final Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(ChatServer.INSTANCE.getApis().strangeGroupIn(groupId), new Function1() { // from class: com.qiahao.nextvideo.utilities.j
            public final Object invoke(Object obj) {
                Unit openStrangeChatActivity$lambda$25;
                openStrangeChatActivity$lambda$25 = AppRequestUtils.openStrangeChatActivity$lambda$25(listener, user, isDialog, groupId, (ApiResponse) obj);
                return openStrangeChatActivity$lambda$25;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.utilities.k
            public final Object invoke(Object obj) {
                Unit openStrangeChatActivity$lambda$26;
                openStrangeChatActivity$lambda$26 = AppRequestUtils.openStrangeChatActivity$lambda$26(listener, groupId, (Throwable) obj);
                return openStrangeChatActivity$lambda$26;
            }
        }, (Function0) null, false, 12, (Object) null), mCompositeDisposable);
    }
}
