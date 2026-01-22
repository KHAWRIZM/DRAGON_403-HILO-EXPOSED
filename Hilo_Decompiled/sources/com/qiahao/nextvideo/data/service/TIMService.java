package com.qiahao.nextvideo.data.service;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.FirebaseCrashlyticsKt;
import com.google.firebase.messaging.FirebaseMessaging;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.qiahao.base_common.model.im.Identifier;
import com.qiahao.base_common.network.BaseServer;
import com.qiahao.base_common.network.ServerInfo;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.HiloApplication;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.UserStatusData;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.manager.GroupEvent;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.qiahao.nextvideo.ui.im.StrangerProvide;
import com.taobao.accs.common.Constants;
import com.tencent.imsdk.v2.V2TIMAdvancedMsgListener;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMOfflinePushConfig;
import com.tencent.imsdk.v2.V2TIMUserStatus;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.interfaces.TUICallback;
import com.tencent.qcloud.tuicore.interfaces.TUILoginListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0003J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0003J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b\u0018\u0010\u0015R\u001c\u0010\u001a\u001a\n \u0019*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R%\u0010\"\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00070\u00070!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R%\u0010&\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u000b0\u000b0!8\u0006¢\u0006\f\n\u0004\b&\u0010#\u001a\u0004\b'\u0010%R\u0017\u0010)\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010.\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00062"}, d2 = {"Lcom/qiahao/nextvideo/data/service/TIMService;", "", "<init>", "()V", "", "refreshTIMToken", "getFireBaseToken", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "it", "dealWithGroupCustomMessage", "(Lcom/tencent/imsdk/v2/V2TIMMessage;)V", "", Constants.SHARED_MESSAGE_ID_FILE, "Lcom/qiahao/base_common/model/im/Identifier;", "tim", "", "judgeCustomTimType", "(Ljava/lang/String;Lcom/qiahao/base_common/model/im/Identifier;)Z", "loginTIM", "isForground", "updateChatPushStatus", "(Z)V", "logout", "isHide", "setUserStatus", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "Lcom/google/gson/d;", "gson", "Lcom/google/gson/d;", "getGson", "()Lcom/google/gson/d;", "Lla/c;", "receivedMessageRelay", "Lla/c;", "getReceivedMessageRelay", "()Lla/c;", "getDeleteConversation", "getGetDeleteConversation", "Lcom/tencent/qcloud/tuicore/interfaces/TUILoginListener;", "listener", "Lcom/tencent/qcloud/tuicore/interfaces/TUILoginListener;", "getListener", "()Lcom/tencent/qcloud/tuicore/interfaces/TUILoginListener;", "Lcom/tencent/imsdk/v2/V2TIMAdvancedMsgListener;", "v2TIMAdvancedMsgListener", "Lcom/tencent/imsdk/v2/V2TIMAdvancedMsgListener;", "getV2TIMAdvancedMsgListener", "()Lcom/tencent/imsdk/v2/V2TIMAdvancedMsgListener;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TIMService {

    @NotNull
    private static final la.c getDeleteConversation;

    @NotNull
    private static final TUILoginListener listener;

    @NotNull
    private static final la.c receivedMessageRelay;

    @NotNull
    private static final V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener;

    @NotNull
    public static final TIMService INSTANCE = new TIMService();
    private static final String TAG = TIMService.class.getSimpleName();

    @NotNull
    private static final com.google.gson.d gson = new com.google.gson.d();

    static {
        la.c e = la.c.e();
        Intrinsics.checkNotNullExpressionValue(e, "create(...)");
        receivedMessageRelay = e;
        la.c e2 = la.c.e();
        Intrinsics.checkNotNullExpressionValue(e2, "create(...)");
        getDeleteConversation = e2;
        listener = new TUILoginListener() { // from class: com.qiahao.nextvideo.data.service.TIMService$listener$1
            @Override // com.tencent.qcloud.tuicore.interfaces.TUILoginListener
            public void onConnectFailed(int code, String error) {
                super.onConnectFailed(code, error);
            }

            @Override // com.tencent.qcloud.tuicore.interfaces.TUILoginListener
            public void onConnectSuccess() {
                super.onConnectSuccess();
            }

            @Override // com.tencent.qcloud.tuicore.interfaces.TUILoginListener
            public void onConnecting() {
                super.onConnecting();
            }

            @Override // com.tencent.qcloud.tuicore.interfaces.TUILoginListener
            public void onKickedOffline() {
                super.onKickedOffline();
                UserStore.INSTANCE.getShared().logout();
            }

            @Override // com.tencent.qcloud.tuicore.interfaces.TUILoginListener
            public void onUserSigExpired() {
                super.onUserSigExpired();
                TIMService.INSTANCE.refreshTIMToken();
            }
        };
        v2TIMAdvancedMsgListener = new TIMService$v2TIMAdvancedMsgListener$1();
    }

    private TIMService() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dealWithGroupCustomMessage(V2TIMMessage it) {
        String str;
        byte[] data = it.getCustomElem().getData();
        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
        GroupRoomImCustomBean groupRoomImCustomBean = (GroupRoomImCustomBean) gson.j(StringsKt.decodeToString(data), GroupRoomImCustomBean.class);
        if (Intrinsics.areEqual(groupRoomImCustomBean.getType(), "3")) {
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            String groupID = it.getGroupID();
            Intrinsics.checkNotNullExpressionValue(groupID, "getGroupID(...)");
            if (!meetingRoomManager.currentInRoom(groupID)) {
                String externalId = groupRoomImCustomBean.getExternalId();
                User user = UserStore.INSTANCE.getShared().getUser();
                if (user != null) {
                    str = user.getExternalId();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(externalId, str)) {
                    Log.d(TAG, "onRecvNewMessage:被拉黑,不在房间且被操作的是自己");
                    je.b mGroupEventProcessorObservable = GroupService.INSTANCE.getMGroupEventProcessorObservable();
                    GroupEvent groupEvent = new GroupEvent();
                    String groupID2 = it.getGroupID();
                    Intrinsics.checkNotNullExpressionValue(groupID2, "getGroupID(...)");
                    mGroupEventProcessorObservable.onNext(groupEvent.leaveGroup(groupID2));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getFireBaseToken() {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.qiahao.nextvideo.data.service.n
            public final void onComplete(Task task) {
                TIMService.getFireBaseToken$lambda$3(task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFireBaseToken$lambda$3(Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.isSuccessful()) {
            return;
        }
        V2TIMManager.getOfflinePushManager().setOfflinePushConfig(new V2TIMOfflinePushConfig(7016L, (String) task.getResult()), new V2TIMCallback() { // from class: com.qiahao.nextvideo.data.service.TIMService$getFireBaseToken$1$1
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int code, String desc) {
                String str;
                str = TIMService.TAG;
                Log.d(str, "onError: 上传到腾讯IM的fireBase 失败 " + code + " " + desc);
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                String str;
                str = TIMService.TAG;
                Log.d(str, "onError: 上传到腾讯IM的fireBase 成功");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshTIMToken() {
        RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().refreshTIMToken(), new Function1() { // from class: com.qiahao.nextvideo.data.service.p
            public final Object invoke(Object obj) {
                Unit refreshTIMToken$lambda$1;
                refreshTIMToken$lambda$1 = TIMService.refreshTIMToken$lambda$1((ApiResponse) obj);
                return refreshTIMToken$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.data.service.q
            public final Object invoke(Object obj) {
                Unit refreshTIMToken$lambda$2;
                refreshTIMToken$lambda$2 = TIMService.refreshTIMToken$lambda$2((Throwable) obj);
                return refreshTIMToken$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refreshTIMToken$lambda$1(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "keyRongCloudToken", apiResponse.getData(), (String) null, 4, (Object) null);
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.data.service.o
            @Override // java.lang.Runnable
            public final void run() {
                TIMService.refreshTIMToken$lambda$1$lambda$0();
            }
        }, 500L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshTIMToken$lambda$1$lambda$0() {
        INSTANCE.loginTIM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refreshTIMToken$lambda$2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    @NotNull
    public final la.c getGetDeleteConversation() {
        return getDeleteConversation;
    }

    @NotNull
    public final com.google.gson.d getGson() {
        return gson;
    }

    @NotNull
    public final TUILoginListener getListener() {
        return listener;
    }

    @NotNull
    public final la.c getReceivedMessageRelay() {
        return receivedMessageRelay;
    }

    @NotNull
    public final V2TIMAdvancedMsgListener getV2TIMAdvancedMsgListener() {
        return v2TIMAdvancedMsgListener;
    }

    public final boolean judgeCustomTimType(@NotNull String message, @NotNull Identifier tim) {
        Intrinsics.checkNotNullParameter(message, Constants.SHARED_MESSAGE_ID_FILE);
        Intrinsics.checkNotNullParameter(tim, "tim");
        return StringsKt.contains$default(message, "\"identifier\":\"" + tim.name() + "\"", false, 2, (Object) null);
    }

    public final void loginTIM() {
        String str;
        int i;
        String externalId;
        String str2 = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "keyRongCloudToken", "", (String) null, 4, (Object) null);
        if (!TextUtils.isEmpty(str2)) {
            UserStore.Companion companion = UserStore.INSTANCE;
            if (companion.getShared().getUser() != null) {
                FirebaseCrashlytics crashlytics = FirebaseCrashlyticsKt.getCrashlytics(Firebase.INSTANCE);
                User user = companion.getShared().getUser();
                String str3 = "";
                if (user == null || (str = user.getExternalId()) == null) {
                    str = "";
                }
                crashlytics.setUserId(str);
                TUILogin.addLoginListener(listener);
                Context context = HiloApplication.INSTANCE.getCONTEXT();
                ServerInfo selectedServerInfo = BaseServer.INSTANCE.getSelectedServerInfo();
                if (selectedServerInfo != null) {
                    i = selectedServerInfo.getTencentImAppKey();
                } else {
                    i = 0;
                }
                User user2 = companion.getShared().getUser();
                if (user2 != null && (externalId = user2.getExternalId()) != null) {
                    str3 = externalId;
                }
                TUILogin.login(context, i, str3, str2, new TUICallback() { // from class: com.qiahao.nextvideo.data.service.TIMService$loginTIM$1
                    @Override // com.tencent.qcloud.tuicore.interfaces.TUICallback
                    public void onError(int errorCode, String errorMessage) {
                        String str4;
                        User user3 = UserStore.INSTANCE.getShared().getUser();
                        if (user3 != null) {
                            str4 = user3.getExternalId();
                        } else {
                            str4 = null;
                        }
                        n5.e.b("IM登陆失败：" + errorCode + "  失败详情：" + errorMessage + "   UserId:" + str4);
                    }

                    @Override // com.tencent.qcloud.tuicore.interfaces.TUICallback
                    public void onSuccess() {
                        TIMService tIMService = TIMService.INSTANCE;
                        tIMService.getFireBaseToken();
                        SplashService.INSTANCE.getShared().getImSDkLoginBehaviorRelay().accept(Boolean.TRUE);
                        MessageProvide.INSTANCE.displayData(MessageProvide.MESSAGE_DEFAULT);
                        StrangerProvide.INSTANCE.displayData();
                        V2TIMManager.getMessageManager().addAdvancedMsgListener(tIMService.getV2TIMAdvancedMsgListener());
                    }
                });
            }
        }
    }

    public final void logout() {
        TUILogin.logout(new TUICallback() { // from class: com.qiahao.nextvideo.data.service.TIMService$logout$1
            @Override // com.tencent.qcloud.tuicore.interfaces.TUICallback
            public void onError(int errorCode, String errorMessage) {
            }

            @Override // com.tencent.qcloud.tuicore.interfaces.TUICallback
            public void onSuccess() {
                V2TIMManager.getMessageManager().removeAdvancedMsgListener(TIMService.INSTANCE.getV2TIMAdvancedMsgListener());
            }
        });
    }

    public final void setUserStatus(boolean isHide) {
        V2TIMUserStatus v2TIMUserStatus = new V2TIMUserStatus();
        v2TIMUserStatus.setCustomStatus(new com.google.gson.d().s(new UserStatusData(Boolean.valueOf(isHide))));
        V2TIMManager.getInstance().setSelfStatus(v2TIMUserStatus, null);
    }

    public final void updateChatPushStatus(boolean isForground) {
        if (isForground) {
            V2TIMManager.getOfflinePushManager().doForeground(null);
        } else {
            V2TIMManager.getOfflinePushManager().doBackground(0, null);
        }
    }
}
