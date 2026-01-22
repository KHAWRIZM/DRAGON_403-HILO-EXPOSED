package com.qiahao.nextvideo.ui.im;

import android.text.TextUtils;
import android.util.Log;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qhqc.core.feature.community.CommunityManager;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxJava;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.model.GameMsg;
import com.qiahao.nextvideo.data.model.MsgForHiloOfficial;
import com.qiahao.nextvideo.data.model.UserStatusData;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.network.AppServer;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.imsdk.v2.V2TIMConversationListFilter;
import com.tencent.imsdk.v2.V2TIMConversationOperationResult;
import com.tencent.imsdk.v2.V2TIMConversationResult;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMUserStatus;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import io.reactivex.rxjava3.core.b0;
import io.reactivex.rxjava3.core.c0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ=\u0010\u000f\u001a\u00020\u00062\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0011¢\u0006\u0004\b\u001e\u0010\u0014J\r\u0010\u001f\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010\u0003J9\u0010$\u001a\u00020\u00062\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00110\tj\b\u0012\u0004\u0012\u00020\u0011`\u000b2\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!¢\u0006\u0004\b$\u0010%J\r\u0010'\u001a\u00020&¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0011¢\u0006\u0004\b*\u0010\u0014J\r\u0010+\u001a\u00020\u0006¢\u0006\u0004\b+\u0010\u0003J\r\u0010,\u001a\u00020\u0006¢\u0006\u0004\b,\u0010\u0003R\u0014\u0010-\u001a\u00020&8\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u00100R\u0014\u00102\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u00100R\"\u00104\u001a\u0002038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010;\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b;\u0010=\"\u0004\b>\u0010?R\"\u0010@\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010<\u001a\u0004\bA\u0010=\"\u0004\bB\u0010?R\"\u0010C\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010<\u001a\u0004\bD\u0010=\"\u0004\bE\u0010?R$\u0010G\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR2\u0010M\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010S\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010<\u001a\u0004\bS\u0010=\"\u0004\bT\u0010?R\"\u0010U\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010.\u001a\u0004\bV\u0010(\"\u0004\bW\u0010XR\u0016\u0010Y\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010.R0\u0010^\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001a0\\j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001a`]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_¨\u0006`"}, d2 = {"Lcom/qiahao/nextvideo/ui/im/MessageProvide;", "", "<init>", "()V", "Lio/reactivex/rxjava3/core/b0;", "e", "", "runCheckMessage", "(Lio/reactivex/rxjava3/core/b0;)V", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/ui/im/MessageListInfo;", "Lkotlin/collections/ArrayList;", "list", "Lcom/tencent/imsdk/v2/V2TIMConversationResult;", "v2TIMConversationResult", "extracted", "(Ljava/util/ArrayList;Lcom/tencent/imsdk/v2/V2TIMConversationResult;Lio/reactivex/rxjava3/core/b0;)V", "", "state", "displayData", "(Ljava/lang/String;)V", "", AgooConstants.MESSAGE_TIME, "delayDisplayData", "(Ljava/lang/String;J)V", "clazz", "Lcom/qiahao/nextvideo/ui/im/MessageDataListener;", "listener", "registerListener", "(Ljava/lang/String;Lcom/qiahao/nextvideo/ui/im/MessageDataListener;)V", "removeListener", "resetState", "idList", "Lcom/tencent/imsdk/v2/V2TIMValueCallback;", "", "Lcom/tencent/imsdk/v2/V2TIMUserStatus;", "getUserStatus", "(Ljava/util/ArrayList;Lcom/tencent/imsdk/v2/V2TIMValueCallback;)V", "", "getUnReadMessage", "()I", "messageType", "clearUnreadMessageCount", "cleanAllMessage", "release", "PageCount", "I", MessageProvide.MESSAGE_DEFAULT, "Ljava/lang/String;", MessageProvide.MESSAGE_NEXT_PAGE, MessageProvide.MESSAGE_RESECT, "Lnd/a;", "mDisposables", "Lnd/a;", "getMDisposables", "()Lnd/a;", "setMDisposables", "(Lnd/a;)V", "", "isRunning", "Z", "()Z", "setRunning", "(Z)V", "hasNewMessage", "getHasNewMessage", "setHasNewMessage", "hasNewSystemMessage", "getHasNewSystemMessage", "setHasNewSystemMessage", "Lcom/qiahao/nextvideo/data/model/MsgForHiloOfficial;", "msgForHiloOfficial", "Lcom/qiahao/nextvideo/data/model/MsgForHiloOfficial;", "getMsgForHiloOfficial", "()Lcom/qiahao/nextvideo/data/model/MsgForHiloOfficial;", "setMsgForHiloOfficial", "(Lcom/qiahao/nextvideo/data/model/MsgForHiloOfficial;)V", "mMessageData", "Ljava/util/ArrayList;", "getMMessageData", "()Ljava/util/ArrayList;", "setMMessageData", "(Ljava/util/ArrayList;)V", "isFinished", "setFinished", "mPageSize", "getMPageSize", "setMPageSize", "(I)V", "nextSeq", "J", "mUnReadMessage", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mHashMapListener", "Ljava/util/HashMap;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MessageProvide {

    @NotNull
    public static final String MESSAGE_DEFAULT = "MESSAGE_DEFAULT";

    @NotNull
    public static final String MESSAGE_NEXT_PAGE = "MESSAGE_NEXT_PAGE";

    @NotNull
    public static final String MESSAGE_RESECT = "MESSAGE_RESECT";
    private static final int PageCount = 10;
    private static boolean hasNewMessage;
    private static boolean hasNewSystemMessage;
    private static boolean isFinished;
    private static boolean isRunning;
    private static int mUnReadMessage;

    @Nullable
    private static MsgForHiloOfficial msgForHiloOfficial;
    private static long nextSeq;

    @NotNull
    public static final MessageProvide INSTANCE = new MessageProvide();

    @NotNull
    private static nd.a mDisposables = new nd.a();

    @NotNull
    private static ArrayList<MessageListInfo> mMessageData = new ArrayList<>();
    private static int mPageSize = 10;

    @NotNull
    private static final HashMap<String, MessageDataListener> mHashMapListener = new HashMap<>();

    private MessageProvide() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clearUnreadMessageCount$lambda$4(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        hasNewSystemMessage = true;
        displayData$default(INSTANCE, null, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clearUnreadMessageCount$lambda$5(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clearUnreadMessageCount$lambda$6(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        hasNewSystemMessage = true;
        displayData$default(INSTANCE, null, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clearUnreadMessageCount$lambda$7(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void delayDisplayData$default(MessageProvide messageProvide, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = MESSAGE_DEFAULT;
        }
        messageProvide.delayDisplayData(str, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delayDisplayData$lambda$1(String str) {
        INSTANCE.displayData(str);
    }

    public static /* synthetic */ void displayData$default(MessageProvide messageProvide, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = MESSAGE_DEFAULT;
        }
        messageProvide.displayData(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void displayData$lambda$0(b0 b0Var) {
        Intrinsics.checkNotNullParameter(b0Var, "e");
        INSTANCE.runCheckMessage(b0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void extracted(ArrayList<MessageListInfo> list, V2TIMConversationResult v2TIMConversationResult, b0 e) {
        int i;
        int i2;
        Integer msgNoRead;
        Integer msgNoRead2;
        mMessageData.clear();
        MsgForHiloOfficial msgForHiloOfficial2 = msgForHiloOfficial;
        if (msgForHiloOfficial2 != null) {
            list.add(0, new MessageListInfo().createSystem(msgForHiloOfficial2, "Hilo_Information"));
            list.add(1, new MessageListInfo().createSystem(msgForHiloOfficial2, "Hilo_Assistant"));
            list.add(2, new MessageListInfo().createSystem(msgForHiloOfficial2, "Hilo_Notification"));
            list.add(3, new MessageListInfo().createSystem(msgForHiloOfficial2, "Strange_list"));
            GameMsg gameMsg = msgForHiloOfficial2.getGameMsg();
            if (gameMsg != null && (msgNoRead2 = gameMsg.getMsgNoRead()) != null) {
                i = msgNoRead2.intValue();
            } else {
                i = -1;
            }
            if (i > -1) {
                list.add(4, new MessageListInfo().createSystem(msgForHiloOfficial2, "Hilo_match"));
            }
            if (msgForHiloOfficial2.getFamilyMsgNoRead() > -1) {
                list.add(4, new MessageListInfo().createSystem(msgForHiloOfficial2, "Hilo_Family"));
            }
            int i3 = mUnReadMessage;
            int userMsgNoRead = msgForHiloOfficial2.getUserMsgNoRead() + msgForHiloOfficial2.getSysMsgNotRead();
            GameMsg gameMsg2 = msgForHiloOfficial2.getGameMsg();
            if (gameMsg2 != null && (msgNoRead = gameMsg2.getMsgNoRead()) != null) {
                i2 = msgNoRead.intValue();
            } else {
                i2 = 0;
            }
            mUnReadMessage = i3 + userMsgNoRead + i2 + StrangerProvide.INSTANCE.getUnReadMessage() + msgForHiloOfficial2.getMomentMsgNoRead();
            if (msgForHiloOfficial2.getFamilyMsgNoRead() > -1) {
                mUnReadMessage += msgForHiloOfficial2.getFamilyMsgNoRead();
            }
        }
        mMessageData.addAll(list);
        isFinished = v2TIMConversationResult.isFinished();
        isRunning = false;
        e.onNext(1);
    }

    private final void runCheckMessage(final b0 e) {
        MsgForHiloOfficial msgForHiloOfficial2;
        hasNewMessage = false;
        try {
            if (hasNewSystemMessage || msgForHiloOfficial == null) {
                ApiResponse<MsgForHiloOfficial> body = AppServer.INSTANCE.getApis().fetchMsgLastForHiloOfficial().execute().body();
                if (body != null && (msgForHiloOfficial2 = (MsgForHiloOfficial) body.getData()) != null) {
                    msgForHiloOfficial = msgForHiloOfficial2;
                    IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "family_count", Integer.valueOf(msgForHiloOfficial2.getFamilyMsgNoRead()), (String) null, 4, (Object) null);
                    cf.c.c().l(new EventBusKey("family_point", (Object) null, 2, (DefaultConstructorMarker) null));
                }
                hasNewSystemMessage = false;
            }
        } catch (Exception unused) {
            Log.d(MessageProvide.class.getName(), "获取系统用户数据失败");
        }
        V2TIMConversationListFilter v2TIMConversationListFilter = new V2TIMConversationListFilter();
        v2TIMConversationListFilter.setConversationType(1);
        V2TIMManager.getConversationManager().getConversationListByFilter(v2TIMConversationListFilter, 0L, 200, new V2TIMValueCallback<V2TIMConversationResult>() { // from class: com.qiahao.nextvideo.ui.im.MessageProvide$runCheckMessage$2
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int code, String desc) {
                Intrinsics.checkNotNullParameter(desc, "desc");
                MessageProvide.INSTANCE.setRunning(false);
                e.onNext(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(final V2TIMConversationResult v2TIMConversationResult) {
                int i;
                Intrinsics.checkNotNullParameter(v2TIMConversationResult, "v2TIMConversationResult");
                final ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                List<V2TIMConversation> conversationList = v2TIMConversationResult.getConversationList();
                MessageProvide.mUnReadMessage = 0;
                for (V2TIMConversation v2TIMConversation : conversationList) {
                    MessageInfoUtils messageInfoUtils = MessageInfoUtils.INSTANCE;
                    Intrinsics.checkNotNull(v2TIMConversation);
                    MessageListInfo conversationToMessageListInfo = messageInfoUtils.conversationToMessageListInfo(v2TIMConversation);
                    if (!conversationToMessageListInfo.getIsGroup()) {
                        String id2 = conversationToMessageListInfo.getId();
                        if (id2 == null) {
                            id2 = "";
                        }
                        arrayList2.add(id2);
                        i = MessageProvide.mUnReadMessage;
                        MessageProvide.mUnReadMessage = i + conversationToMessageListInfo.getUnRead();
                        conversationToMessageListInfo.setType(1);
                        arrayList.add(conversationToMessageListInfo);
                    }
                }
                MessageProvide messageProvide = MessageProvide.INSTANCE;
                final b0 b0Var = e;
                messageProvide.getUserStatus(arrayList2, new V2TIMValueCallback<List<? extends V2TIMUserStatus>>() { // from class: com.qiahao.nextvideo.ui.im.MessageProvide$runCheckMessage$2$onSuccess$1
                    @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                    public void onError(int p0, String p1) {
                        MessageProvide.INSTANCE.extracted(arrayList, v2TIMConversationResult, b0Var);
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                    public void onSuccess(List<? extends V2TIMUserStatus> p0) {
                        for (MessageListInfo messageListInfo : arrayList) {
                            if (p0 != null) {
                                for (V2TIMUserStatus v2TIMUserStatus : p0) {
                                    if (Intrinsics.areEqual(messageListInfo.getId(), v2TIMUserStatus.getUserID())) {
                                        messageListInfo.setUserStatus(v2TIMUserStatus.getStatusType());
                                        if (!TextUtils.isEmpty(v2TIMUserStatus.getCustomStatus())) {
                                            try {
                                                Boolean invisible = ((UserStatusData) new com.google.gson.d().j(v2TIMUserStatus.getCustomStatus(), UserStatusData.class)).getInvisible();
                                                messageListInfo.setHide(invisible != null ? invisible.booleanValue() : false);
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        MessageProvide.INSTANCE.extracted(arrayList, v2TIMConversationResult, b0Var);
                    }
                });
            }
        });
    }

    public final void cleanAllMessage() {
        V2TIMManager.getConversationManager().getConversationList(0L, Integer.MAX_VALUE, new V2TIMValueCallback<V2TIMConversationResult>() { // from class: com.qiahao.nextvideo.ui.im.MessageProvide$cleanAllMessage$1
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int code, String desc) {
                Intrinsics.checkNotNullParameter(desc, "desc");
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMConversationResult v2TIMConversationResult) {
                Intrinsics.checkNotNullParameter(v2TIMConversationResult, "v2TIMConversationResult");
                ArrayList arrayList = new ArrayList();
                List<V2TIMConversation> conversationList = v2TIMConversationResult.getConversationList();
                Intrinsics.checkNotNullExpressionValue(conversationList, "getConversationList(...)");
                Iterator<T> it = conversationList.iterator();
                while (it.hasNext()) {
                    arrayList.add(((V2TIMConversation) it.next()).getConversationID());
                }
                V2TIMManager.getConversationManager().deleteConversationList(arrayList, true, new V2TIMValueCallback<List<? extends V2TIMConversationOperationResult>>() { // from class: com.qiahao.nextvideo.ui.im.MessageProvide$cleanAllMessage$1$onSuccess$2
                    @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                    public void onError(int code, String desc) {
                        Intrinsics.checkNotNullParameter(desc, "desc");
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                    public void onSuccess(List<? extends V2TIMConversationOperationResult> results) {
                        Intrinsics.checkNotNullParameter(results, "results");
                        MessageProvide.displayData$default(MessageProvide.INSTANCE, null, 1, null);
                        StrangerProvide.INSTANCE.displayData();
                    }
                });
            }
        });
    }

    public final void clearUnreadMessageCount(@NotNull String messageType) {
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        int hashCode = messageType.hashCode();
        if (hashCode != -1675218269) {
            if (hashCode != -1273866319) {
                if (hashCode == -1136986362 && messageType.equals("Hilo_Notification")) {
                    CommunityManager.Companion.getInstance().noticeReadAll(new CommunityManager.NoticeReadAllListener() { // from class: com.qiahao.nextvideo.ui.im.MessageProvide$clearUnreadMessageCount$5
                        public void noticeReadAll() {
                            MessageProvide messageProvide = MessageProvide.INSTANCE;
                            messageProvide.setHasNewSystemMessage(true);
                            MessageProvide.displayData$default(messageProvide, null, 1, null);
                        }
                    });
                    return;
                }
                return;
            }
            if (messageType.equals("Hilo_Information")) {
                RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().clearSysMessage(), new Function1() { // from class: com.qiahao.nextvideo.ui.im.b
                    public final Object invoke(Object obj) {
                        Unit clearUnreadMessageCount$lambda$4;
                        clearUnreadMessageCount$lambda$4 = MessageProvide.clearUnreadMessageCount$lambda$4((ApiResponse) obj);
                        return clearUnreadMessageCount$lambda$4;
                    }
                }, new Function1() { // from class: com.qiahao.nextvideo.ui.im.c
                    public final Object invoke(Object obj) {
                        Unit clearUnreadMessageCount$lambda$5;
                        clearUnreadMessageCount$lambda$5 = MessageProvide.clearUnreadMessageCount$lambda$5((Throwable) obj);
                        return clearUnreadMessageCount$lambda$5;
                    }
                }, (Function0) null, false, 12, (Object) null), mDisposables);
                return;
            }
            return;
        }
        if (messageType.equals("Hilo_Assistant")) {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().clearAssistantUnRead(), new Function1() { // from class: com.qiahao.nextvideo.ui.im.d
                public final Object invoke(Object obj) {
                    Unit clearUnreadMessageCount$lambda$6;
                    clearUnreadMessageCount$lambda$6 = MessageProvide.clearUnreadMessageCount$lambda$6((ApiResponse) obj);
                    return clearUnreadMessageCount$lambda$6;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.im.e
                public final Object invoke(Object obj) {
                    Unit clearUnreadMessageCount$lambda$7;
                    clearUnreadMessageCount$lambda$7 = MessageProvide.clearUnreadMessageCount$lambda$7((Throwable) obj);
                    return clearUnreadMessageCount$lambda$7;
                }
            }, (Function0) null, false, 12, (Object) null), mDisposables);
        }
    }

    public final void delayDisplayData(@Nullable final String state, long time) {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.ui.im.f
            @Override // java.lang.Runnable
            public final void run() {
                MessageProvide.delayDisplayData$lambda$1(state);
            }
        }, time);
    }

    public final void displayData(@Nullable String state) {
        String str;
        if (state != null) {
            int hashCode = state.hashCode();
            if (hashCode != -683048445) {
                if (hashCode != 1395310025) {
                    if (hashCode == 1416040014) {
                        str = MESSAGE_RESECT;
                    }
                } else {
                    str = MESSAGE_DEFAULT;
                }
            } else {
                str = MESSAGE_NEXT_PAGE;
            }
            state.equals(str);
        }
        if (isRunning) {
            hasNewMessage = true;
        } else {
            isRunning = true;
            mDisposables.a(RxJava.INSTANCE.rx(new c0() { // from class: com.qiahao.nextvideo.ui.im.a
                public final void a(b0 b0Var) {
                    MessageProvide.displayData$lambda$0(b0Var);
                }
            }, new pd.g() { // from class: com.qiahao.nextvideo.ui.im.MessageProvide$displayData$2
                public final void accept(Object obj) {
                    HashMap hashMap;
                    int i;
                    Intrinsics.checkNotNullParameter(obj, "it");
                    hashMap = MessageProvide.mHashMapListener;
                    Iterator it = hashMap.entrySet().iterator();
                    while (it.hasNext()) {
                        MessageDataListener messageDataListener = (MessageDataListener) ((Map.Entry) it.next()).getValue();
                        MessageProvide messageProvide = MessageProvide.INSTANCE;
                        ArrayList<MessageListInfo> mMessageData2 = messageProvide.getMMessageData();
                        i = MessageProvide.mUnReadMessage;
                        messageDataListener.messageDataListener(mMessageData2, i, messageProvide.isFinished());
                    }
                    MessageProvide messageProvide2 = MessageProvide.INSTANCE;
                    if (messageProvide2.getHasNewMessage()) {
                        messageProvide2.setHasNewMessage(false);
                        messageProvide2.displayData(MessageProvide.MESSAGE_DEFAULT);
                    }
                }
            }, new pd.g() { // from class: com.qiahao.nextvideo.ui.im.MessageProvide$displayData$3
                public final void accept(Throwable th) {
                    HashMap hashMap;
                    int i;
                    Intrinsics.checkNotNullParameter(th, "it");
                    hashMap = MessageProvide.mHashMapListener;
                    Iterator it = hashMap.entrySet().iterator();
                    while (it.hasNext()) {
                        MessageDataListener messageDataListener = (MessageDataListener) ((Map.Entry) it.next()).getValue();
                        MessageProvide messageProvide = MessageProvide.INSTANCE;
                        ArrayList<MessageListInfo> mMessageData2 = messageProvide.getMMessageData();
                        i = MessageProvide.mUnReadMessage;
                        messageDataListener.messageDataListener(mMessageData2, i, messageProvide.isFinished());
                    }
                    MessageProvide.INSTANCE.resetState();
                }
            }));
        }
    }

    public final boolean getHasNewMessage() {
        return hasNewMessage;
    }

    public final boolean getHasNewSystemMessage() {
        return hasNewSystemMessage;
    }

    @NotNull
    public final nd.a getMDisposables() {
        return mDisposables;
    }

    @NotNull
    public final ArrayList<MessageListInfo> getMMessageData() {
        return mMessageData;
    }

    public final int getMPageSize() {
        return mPageSize;
    }

    @Nullable
    public final MsgForHiloOfficial getMsgForHiloOfficial() {
        return msgForHiloOfficial;
    }

    public final int getUnReadMessage() {
        return mUnReadMessage;
    }

    public final void getUserStatus(@NotNull ArrayList<String> idList, @NotNull V2TIMValueCallback<List<V2TIMUserStatus>> listener) {
        Intrinsics.checkNotNullParameter(idList, "idList");
        Intrinsics.checkNotNullParameter(listener, "listener");
        V2TIMManager.getInstance().getUserStatus(idList, listener);
    }

    public final boolean isFinished() {
        return isFinished;
    }

    public final boolean isRunning() {
        return isRunning;
    }

    public final void registerListener(@NotNull String clazz, @NotNull MessageDataListener listener) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(listener, "listener");
        HashMap<String, MessageDataListener> hashMap = mHashMapListener;
        if (!hashMap.containsKey(clazz)) {
            hashMap.put(clazz, listener);
        }
    }

    public final void release() {
        mDisposables.d();
        mMessageData.clear();
        mUnReadMessage = 0;
        isRunning = false;
        hasNewMessage = false;
    }

    public final void removeListener(@NotNull String clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        HashMap<String, MessageDataListener> hashMap = mHashMapListener;
        if (hashMap.containsKey(clazz)) {
            hashMap.remove(clazz);
        }
    }

    public final void resetState() {
        isRunning = false;
        hasNewMessage = false;
    }

    public final void setFinished(boolean z) {
        isFinished = z;
    }

    public final void setHasNewMessage(boolean z) {
        hasNewMessage = z;
    }

    public final void setHasNewSystemMessage(boolean z) {
        hasNewSystemMessage = z;
    }

    public final void setMDisposables(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        mDisposables = aVar;
    }

    public final void setMMessageData(@NotNull ArrayList<MessageListInfo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        mMessageData = arrayList;
    }

    public final void setMPageSize(int i) {
        mPageSize = i;
    }

    public final void setMsgForHiloOfficial(@Nullable MsgForHiloOfficial msgForHiloOfficial2) {
        msgForHiloOfficial = msgForHiloOfficial2;
    }

    public final void setRunning(boolean z) {
        isRunning = z;
    }
}
