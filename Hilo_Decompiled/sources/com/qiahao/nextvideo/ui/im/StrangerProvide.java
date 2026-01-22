package com.qiahao.nextvideo.ui.im;

import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxJava;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.strange.StrangeItemData;
import com.qiahao.nextvideo.data.strange.StrangeUserData;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.imsdk.v2.V2TIMConversationListFilter;
import com.tencent.imsdk.v2.V2TIMConversationManager;
import com.tencent.imsdk.v2.V2TIMConversationResult;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import io.reactivex.rxjava3.core.b0;
import io.reactivex.rxjava3.core.c0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0003J3\u0010\u0018\u001a\u00020\u00062\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u0003R\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010#R2\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R(\u0010/\u001a\b\u0012\u0004\u0012\u00020\n0.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R(\u00105\u001a\b\u0012\u0004\u0012\u00020\n0.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00100\u001a\u0004\b6\u00102\"\u0004\b7\u00104R\u0016\u00108\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R0\u0010<\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0:j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f`;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006>"}, d2 = {"Lcom/qiahao/nextvideo/ui/im/StrangerProvide;", "", "<init>", "()V", "Lio/reactivex/rxjava3/core/b0;", "e", "", "runCheckMessage", "(Lio/reactivex/rxjava3/core/b0;)V", "displayData", "", "clazz", "Lcom/qiahao/nextvideo/ui/im/StrangeDataListener;", "listener", "registerListener", "(Ljava/lang/String;Lcom/qiahao/nextvideo/ui/im/StrangeDataListener;)V", "removeListener", "(Ljava/lang/String;)V", "resetState", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/strange/StrangeItemData;", "Lkotlin/collections/ArrayList;", "list", "emitter", "checkUserInfo", "(Ljava/util/ArrayList;Lio/reactivex/rxjava3/core/b0;)V", "", "getUnReadMessage", "()I", "release", "Lnd/a;", "mDisposables", "Lnd/a;", "", "isRunning", "Z", "()Z", "setRunning", "(Z)V", "hasNewMessage", "mMessageData", "Ljava/util/ArrayList;", "getMMessageData", "()Ljava/util/ArrayList;", "setMMessageData", "(Ljava/util/ArrayList;)V", "Ljava/util/concurrent/CopyOnWriteArraySet;", "groupIdSet", "Ljava/util/concurrent/CopyOnWriteArraySet;", "getGroupIdSet", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "setGroupIdSet", "(Ljava/util/concurrent/CopyOnWriteArraySet;)V", "strangerSet", "getStrangerSet", "setStrangerSet", "mUnReadMessage", "I", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mHashMapListener", "Ljava/util/HashMap;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStrangerProvide.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StrangerProvide.kt\ncom/qiahao/nextvideo/ui/im/StrangerProvide\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,247:1\n1878#2,3:248\n1869#2:251\n1869#2,2:252\n1870#2:254\n*S KotlinDebug\n*F\n+ 1 StrangerProvide.kt\ncom/qiahao/nextvideo/ui/im/StrangerProvide\n*L\n141#1:248,3\n151#1:251\n152#1:252,2\n151#1:254\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class StrangerProvide {
    private static boolean hasNewMessage;
    private static boolean isRunning;
    private static int mUnReadMessage;

    @NotNull
    public static final StrangerProvide INSTANCE = new StrangerProvide();

    @NotNull
    private static nd.a mDisposables = new nd.a();

    @NotNull
    private static ArrayList<StrangeItemData> mMessageData = new ArrayList<>();

    @NotNull
    private static CopyOnWriteArraySet<String> groupIdSet = new CopyOnWriteArraySet<>();

    @NotNull
    private static CopyOnWriteArraySet<String> strangerSet = new CopyOnWriteArraySet<>();

    @NotNull
    private static final HashMap<String, StrangeDataListener> mHashMapListener = new HashMap<>();

    private StrangerProvide() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkUserInfo$lambda$4(ArrayList arrayList, b0 b0Var, ArrayList arrayList2, ApiResponse apiResponse) {
        boolean z;
        boolean z2;
        long j;
        Long closeTimeUnix;
        String str;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ArrayList<StrangeUserData> arrayList3 = (ArrayList) apiResponse.getData();
        if (arrayList3 != null) {
            for (StrangeUserData strangeUserData : arrayList3) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    StrangeItemData strangeItemData = (StrangeItemData) it.next();
                    if (Intrinsics.areEqual(strangeUserData.getGroupId(), strangeItemData.getGroupId())) {
                        strangeItemData.setStrangeData(strangeUserData);
                        User otherUser = strangeUserData.getOtherUser();
                        if (otherUser == null || (str = otherUser.getExternalId()) == null) {
                            str = "";
                        }
                        arrayList2.add(str);
                    }
                }
            }
        }
        strangerSet.clear();
        Iterator it2 = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            Object next = it2.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            StrangeItemData strangeItemData2 = (StrangeItemData) next;
            StrangeUserData strangeData = strangeItemData2.getStrangeData();
            if (strangeData != null) {
                z = Intrinsics.areEqual(strangeData.getUnlock(), Boolean.FALSE);
            } else {
                z = false;
            }
            if (z) {
                StrangeUserData strangeData2 = strangeItemData2.getStrangeData();
                if (strangeData2 != null && (closeTimeUnix = strangeData2.getCloseTimeUnix()) != null) {
                    j = closeTimeUnix.longValue();
                } else {
                    j = 0;
                }
                if (j < V2TIMManager.getInstance().getServerTime()) {
                    V2TIMManager.getInstance().quitGroup(strangeItemData2.getGroupId(), null);
                    V2TIMConversationManager conversationManager = V2TIMManager.getConversationManager();
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("group_%s", Arrays.copyOf(new Object[]{strangeItemData2.getGroupId()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    conversationManager.deleteConversation(format, null);
                    strangerSet.remove(strangeItemData2.getGroupId());
                    groupIdSet.remove(strangeItemData2.getGroupId());
                    it2.remove();
                }
            }
            StrangeUserData strangeData3 = strangeItemData2.getStrangeData();
            if (strangeData3 != null) {
                z2 = Intrinsics.areEqual(strangeData3.getUnlock(), Boolean.TRUE);
            } else {
                z2 = false;
            }
            if (z2) {
                strangerSet.add(strangeItemData2.getGroupId());
            }
        }
        mMessageData.clear();
        mMessageData.addAll(arrayList);
        isRunning = false;
        b0Var.onNext(1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkUserInfo$lambda$5(b0 b0Var, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        isRunning = false;
        b0Var.onNext(1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void displayData$lambda$0(b0 b0Var) {
        Intrinsics.checkNotNullParameter(b0Var, "e");
        INSTANCE.runCheckMessage(b0Var);
    }

    private final void runCheckMessage(final b0 e) {
        hasNewMessage = false;
        V2TIMConversationListFilter v2TIMConversationListFilter = new V2TIMConversationListFilter();
        v2TIMConversationListFilter.setConversationType(2);
        V2TIMManager.getConversationManager().getConversationListByFilter(v2TIMConversationListFilter, 0L, 100, new V2TIMValueCallback<V2TIMConversationResult>() { // from class: com.qiahao.nextvideo.ui.im.StrangerProvide$runCheckMessage$1
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int code, String desc) {
                Intrinsics.checkNotNullParameter(desc, "desc");
                StrangerProvide.INSTANCE.setRunning(false);
                e.onNext(1);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMConversationResult v2TIMConversationResult) {
                int i;
                Intrinsics.checkNotNullParameter(v2TIMConversationResult, "v2TIMConversationResult");
                ArrayList<StrangeItemData> arrayList = new ArrayList<>();
                List<V2TIMConversation> conversationList = v2TIMConversationResult.getConversationList();
                StrangerProvide.mUnReadMessage = 0;
                StrangerProvide.INSTANCE.getGroupIdSet().clear();
                for (V2TIMConversation v2TIMConversation : conversationList) {
                    if (Intrinsics.areEqual("Public", v2TIMConversation.getGroupType())) {
                        MessageInfoUtils messageInfoUtils = MessageInfoUtils.INSTANCE;
                        Intrinsics.checkNotNull(v2TIMConversation);
                        StrangeItemData conversationToStrange = messageInfoUtils.conversationToStrange(v2TIMConversation);
                        StrangerProvide.INSTANCE.getGroupIdSet().add(v2TIMConversation.getGroupID());
                        i = StrangerProvide.mUnReadMessage;
                        StrangerProvide.mUnReadMessage = i + conversationToStrange.getUnRead();
                        arrayList.add(conversationToStrange);
                    }
                }
                StrangerProvide.INSTANCE.checkUserInfo(arrayList, e);
            }
        });
    }

    public final void checkUserInfo(@NotNull final ArrayList<StrangeItemData> list, @NotNull final b0 emitter) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        StringBuilder sb2 = new StringBuilder();
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            StrangeItemData strangeItemData = (StrangeItemData) obj;
            if (i < 20) {
                sb2.append(strangeItemData.getGroupId());
                sb2.append(",");
            }
            i = i2;
        }
        final ArrayList arrayList = new ArrayList();
        ServerApi apis = AppServer.INSTANCE.getApis();
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.strangeChatList(sb3), new Function1() { // from class: com.qiahao.nextvideo.ui.im.g
            public final Object invoke(Object obj2) {
                Unit checkUserInfo$lambda$4;
                checkUserInfo$lambda$4 = StrangerProvide.checkUserInfo$lambda$4(list, emitter, arrayList, (ApiResponse) obj2);
                return checkUserInfo$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.im.h
            public final Object invoke(Object obj2) {
                Unit checkUserInfo$lambda$5;
                checkUserInfo$lambda$5 = StrangerProvide.checkUserInfo$lambda$5(emitter, (Throwable) obj2);
                return checkUserInfo$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), mDisposables);
    }

    public final void displayData() {
        if (isRunning) {
            hasNewMessage = true;
        } else {
            isRunning = true;
            mDisposables.a(RxJava.INSTANCE.rx(new c0() { // from class: com.qiahao.nextvideo.ui.im.i
                public final void a(b0 b0Var) {
                    StrangerProvide.displayData$lambda$0(b0Var);
                }
            }, new pd.g() { // from class: com.qiahao.nextvideo.ui.im.StrangerProvide$displayData$2
                public final void accept(Object obj) {
                    HashMap hashMap;
                    boolean z;
                    int i;
                    Intrinsics.checkNotNullParameter(obj, "it");
                    hashMap = StrangerProvide.mHashMapListener;
                    Iterator it = hashMap.entrySet().iterator();
                    while (it.hasNext()) {
                        StrangeDataListener strangeDataListener = (StrangeDataListener) ((Map.Entry) it.next()).getValue();
                        ArrayList<StrangeItemData> mMessageData2 = StrangerProvide.INSTANCE.getMMessageData();
                        i = StrangerProvide.mUnReadMessage;
                        strangeDataListener.messageDataListener(mMessageData2, i);
                    }
                    z = StrangerProvide.hasNewMessage;
                    if (z) {
                        StrangerProvide.hasNewMessage = false;
                        StrangerProvide.INSTANCE.displayData();
                    }
                    MessageProvide.INSTANCE.displayData(MessageProvide.MESSAGE_DEFAULT);
                }
            }, new pd.g() { // from class: com.qiahao.nextvideo.ui.im.StrangerProvide$displayData$3
                public final void accept(Throwable th) {
                    HashMap hashMap;
                    int i;
                    Intrinsics.checkNotNullParameter(th, "it");
                    hashMap = StrangerProvide.mHashMapListener;
                    Iterator it = hashMap.entrySet().iterator();
                    while (it.hasNext()) {
                        StrangeDataListener strangeDataListener = (StrangeDataListener) ((Map.Entry) it.next()).getValue();
                        ArrayList<StrangeItemData> mMessageData2 = StrangerProvide.INSTANCE.getMMessageData();
                        i = StrangerProvide.mUnReadMessage;
                        strangeDataListener.messageDataListener(mMessageData2, i);
                    }
                    StrangerProvide.INSTANCE.resetState();
                }
            }));
        }
    }

    @NotNull
    public final CopyOnWriteArraySet<String> getGroupIdSet() {
        return groupIdSet;
    }

    @NotNull
    public final ArrayList<StrangeItemData> getMMessageData() {
        return mMessageData;
    }

    @NotNull
    public final CopyOnWriteArraySet<String> getStrangerSet() {
        return strangerSet;
    }

    public final int getUnReadMessage() {
        return mUnReadMessage;
    }

    public final boolean isRunning() {
        return isRunning;
    }

    public final void registerListener(@NotNull String clazz, @NotNull StrangeDataListener listener) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(listener, "listener");
        HashMap<String, StrangeDataListener> hashMap = mHashMapListener;
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
        HashMap<String, StrangeDataListener> hashMap = mHashMapListener;
        if (hashMap.containsKey(clazz)) {
            hashMap.remove(clazz);
        }
    }

    public final void resetState() {
        isRunning = false;
        hasNewMessage = false;
    }

    public final void setGroupIdSet(@NotNull CopyOnWriteArraySet<String> copyOnWriteArraySet) {
        Intrinsics.checkNotNullParameter(copyOnWriteArraySet, "<set-?>");
        groupIdSet = copyOnWriteArraySet;
    }

    public final void setMMessageData(@NotNull ArrayList<StrangeItemData> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        mMessageData = arrayList;
    }

    public final void setRunning(boolean z) {
        isRunning = z;
    }

    public final void setStrangerSet(@NotNull CopyOnWriteArraySet<String> copyOnWriteArraySet) {
        Intrinsics.checkNotNullParameter(copyOnWriteArraySet, "<set-?>");
        strangerSet = copyOnWriteArraySet;
    }
}
