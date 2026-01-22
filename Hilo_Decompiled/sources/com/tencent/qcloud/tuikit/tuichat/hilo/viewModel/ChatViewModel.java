package com.tencent.qcloud.tuikit.tuichat.hilo.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.common.CheckSessionBean;
import com.qiahao.base_common.model.common.LikeResult;
import com.qiahao.base_common.model.im.CpMessageData;
import com.qiahao.base_common.model.im.RelationMessageData;
import com.qiahao.base_common.network.CommonServer;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.ui.cp.CpSpaceActivity;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.tencent.qcloud.tuikit.tuichat.hilo.network.ChatApi;
import com.tencent.qcloud.tuikit.tuichat.hilo.network.ChatServer;
import io.reactivex.rxjava3.core.i0;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0012¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010#J%\u0010&\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0004¢\u0006\u0004\b&\u0010\u0015J\u0015\u0010(\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u0004¢\u0006\u0004\b(\u0010#R(\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00120)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R(\u00100\u001a\b\u0012\u0004\u0012\u00020\u00120)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u0018038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u001f038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00105R\u001c\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u000107038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00105R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020\u0018098F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001f098F¢\u0006\u0006\u001a\u0004\b=\u0010;R\u0019\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u000107098F¢\u0006\u0006\u001a\u0004\b?\u0010;¨\u0006B"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewModel/ChatViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "", "toUID", "", "isLiked", "Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/base_common/network/model/ApiResponse;", "Lcom/qiahao/base_common/model/common/LikeResult;", "requestLike", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/i0;", SupportGiftRankActivity.EXTERNAL_ID, "groupId", "", "getUserInfo", "(Ljava/lang/String;Ljava/lang/String;)V", "", "type", "inviteSheep", "(Ljava/lang/String;ILjava/lang/String;)V", "cpReply", "(Ljava/lang/String;I)V", "Lcom/qiahao/base_common/model/im/CpMessageData;", "data", "checkCpIm", "(Lcom/qiahao/base_common/model/im/CpMessageData;)V", CpSpaceActivity.RELATION_TYPE, "relationReply", "(Ljava/lang/String;II)V", "Lcom/qiahao/base_common/model/im/RelationMessageData;", "checkRelationIm", "(Lcom/qiahao/base_common/model/im/RelationMessageData;)V", "exitStrangeChat", "(Ljava/lang/String;)V", "msgType", "content", "sendStrangeMessage", "userExternalId", "checkChat", "Lma/b;", "mSheepId", "Lma/b;", "getMSheepId", "()Lma/b;", "setMSheepId", "(Lma/b;)V", "mSnakeId", "getMSnakeId", "setMSnakeId", "Landroidx/lifecycle/MutableLiveData;", "imTypeMutable", "Landroidx/lifecycle/MutableLiveData;", "imRelationMutable", "Lcom/qiahao/base_common/model/common/CheckSessionBean;", "canChatMutable", "Landroidx/lifecycle/LiveData;", "getImType", "()Landroidx/lifecycle/LiveData;", "imType", "getImRelation", "imRelation", "getCanChat", "canChat", "Companion", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class ChatViewModel extends BaseViewModel {

    @NotNull
    public static final String CLOSE_STRANGE_CHAT = "close_chat";

    @NotNull
    public static final String CP_CANCEL = "cp_cancel";

    @NotNull
    public static final String CP_INVITE = "cp_invite";

    @NotNull
    public static final String RELATION_CANCEL = "relation_cancel";

    @NotNull
    public static final String RELATION_INVITE = "relation_invite";

    @NotNull
    public static final String USER_INFO = "USER_INFO";

    @NotNull
    private ma.b mSheepId = new ma.b();

    @NotNull
    private ma.b mSnakeId = new ma.b();

    @NotNull
    private final MutableLiveData<CpMessageData> imTypeMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<RelationMessageData> imRelationMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<CheckSessionBean> canChatMutable = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkChat$lambda$16(ChatViewModel chatViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        chatViewModel.canChatMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkChat$lambda$17(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkCpIm$lambda$6(ChatViewModel chatViewModel, CpMessageData cpMessageData, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        chatViewModel.imTypeMutable.setValue(cpMessageData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkCpIm$lambda$7(ChatViewModel chatViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        chatViewModel.getMException().setValue(new Pair(CP_CANCEL, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkRelationIm$lambda$10(ChatViewModel chatViewModel, RelationMessageData relationMessageData, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        chatViewModel.imRelationMutable.setValue(relationMessageData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkRelationIm$lambda$11(ChatViewModel chatViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        chatViewModel.getMException().setValue(new Pair(RELATION_CANCEL, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cpReply$lambda$4(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cpReply$lambda$5(ChatViewModel chatViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        chatViewModel.getMException().setValue(new Pair(CP_CANCEL, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit exitStrangeChat$lambda$12(ChatViewModel chatViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        chatViewModel.getMSuccess().setValue(new Pair(CLOSE_STRANGE_CHAT, apiResponse));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit exitStrangeChat$lambda$13(ChatViewModel chatViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        chatViewModel.getMException().setValue(new Pair(CLOSE_STRANGE_CHAT, th));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getUserInfo$default(ChatViewModel chatViewModel, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        chatViewModel.getUserInfo(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getUserInfo$lambda$0(ChatViewModel chatViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        chatViewModel.getMSuccess().setValue(new Pair("USER_INFO", apiResponse.getData()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getUserInfo$lambda$1(ChatViewModel chatViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        chatViewModel.getMException().setValue(new Pair("USER_INFO", th));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void inviteSheep$default(ChatViewModel chatViewModel, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 9;
        }
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        chatViewModel.inviteSheep(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inviteSheep$lambda$2(int i, ChatViewModel chatViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Integer num = 0;
        if (i == 9) {
            ma.b bVar = chatViewModel.mSheepId;
            Integer num2 = (Integer) apiResponse.getData();
            if (num2 != null) {
                num = num2;
            }
            bVar.setValue(num);
        } else {
            ma.b bVar2 = chatViewModel.mSnakeId;
            Integer num3 = (Integer) apiResponse.getData();
            if (num3 != null) {
                num = num3;
            }
            bVar2.setValue(num);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inviteSheep$lambda$3(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit relationReply$lambda$8(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit relationReply$lambda$9(ChatViewModel chatViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        chatViewModel.getMException().setValue(new Pair(RELATION_CANCEL, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendStrangeMessage$lambda$14(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendStrangeMessage$lambda$15(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public final void checkChat(@NotNull String userExternalId) {
        Intrinsics.checkNotNullParameter(userExternalId, "userExternalId");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(CommonServer.INSTANCE.getApis().checkCanSession(userExternalId), new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.h
            public final Object invoke(Object obj) {
                Unit checkChat$lambda$16;
                checkChat$lambda$16 = ChatViewModel.checkChat$lambda$16(ChatViewModel.this, (ApiResponse) obj);
                return checkChat$lambda$16;
            }
        }, new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.i
            public final Object invoke(Object obj) {
                Unit checkChat$lambda$17;
                checkChat$lambda$17 = ChatViewModel.checkChat$lambda$17((Throwable) obj);
                return checkChat$lambda$17;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void checkCpIm(@NotNull final CpMessageData data) {
        int i;
        Intrinsics.checkNotNullParameter(data, "data");
        ChatApi apis = ChatServer.INSTANCE.getApis();
        Integer msgType = data.getMsgType();
        int i2 = 0;
        if (msgType != null) {
            i = msgType.intValue();
        } else {
            i = 0;
        }
        Integer msgId = data.getMsgId();
        if (msgId != null) {
            i2 = msgId.intValue();
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.checkCpIm(i, i2), new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.b
            public final Object invoke(Object obj) {
                Unit checkCpIm$lambda$6;
                checkCpIm$lambda$6 = ChatViewModel.checkCpIm$lambda$6(ChatViewModel.this, data, (ApiResponse) obj);
                return checkCpIm$lambda$6;
            }
        }, new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.c
            public final Object invoke(Object obj) {
                Unit checkCpIm$lambda$7;
                checkCpIm$lambda$7 = ChatViewModel.checkCpIm$lambda$7(ChatViewModel.this, (Throwable) obj);
                return checkCpIm$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void checkRelationIm(@NotNull final RelationMessageData data) {
        int i;
        Intrinsics.checkNotNullParameter(data, "data");
        ChatApi apis = ChatServer.INSTANCE.getApis();
        Integer msgType = data.getMsgType();
        int i2 = 0;
        if (msgType != null) {
            i = msgType.intValue();
        } else {
            i = 0;
        }
        Integer msgId = data.getMsgId();
        if (msgId != null) {
            i2 = msgId.intValue();
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.checkRelationIm(i, i2), new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.a
            public final Object invoke(Object obj) {
                Unit checkRelationIm$lambda$10;
                checkRelationIm$lambda$10 = ChatViewModel.checkRelationIm$lambda$10(ChatViewModel.this, data, (ApiResponse) obj);
                return checkRelationIm$lambda$10;
            }
        }, new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.j
            public final Object invoke(Object obj) {
                Unit checkRelationIm$lambda$11;
                checkRelationIm$lambda$11 = ChatViewModel.checkRelationIm$lambda$11(ChatViewModel.this, (Throwable) obj);
                return checkRelationIm$lambda$11;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void cpReply(@NotNull String externalId, int type) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(ChatServer.INSTANCE.getApis().cpReply(externalId, type), new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.f
            public final Object invoke(Object obj) {
                Unit cpReply$lambda$4;
                cpReply$lambda$4 = ChatViewModel.cpReply$lambda$4((ApiResponse) obj);
                return cpReply$lambda$4;
            }
        }, new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.g
            public final Object invoke(Object obj) {
                Unit cpReply$lambda$5;
                cpReply$lambda$5 = ChatViewModel.cpReply$lambda$5(ChatViewModel.this, (Throwable) obj);
                return cpReply$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void exitStrangeChat(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(ChatServer.INSTANCE.getApis().exitStrangeChat(groupId), new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.k
            public final Object invoke(Object obj) {
                Unit exitStrangeChat$lambda$12;
                exitStrangeChat$lambda$12 = ChatViewModel.exitStrangeChat$lambda$12(ChatViewModel.this, (ApiResponse) obj);
                return exitStrangeChat$lambda$12;
            }
        }, new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.l
            public final Object invoke(Object obj) {
                Unit exitStrangeChat$lambda$13;
                exitStrangeChat$lambda$13 = ChatViewModel.exitStrangeChat$lambda$13(ChatViewModel.this, (Throwable) obj);
                return exitStrangeChat$lambda$13;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final LiveData<CheckSessionBean> getCanChat() {
        return this.canChatMutable;
    }

    @NotNull
    public final LiveData<RelationMessageData> getImRelation() {
        return this.imRelationMutable;
    }

    @NotNull
    public final LiveData<CpMessageData> getImType() {
        return this.imTypeMutable;
    }

    @NotNull
    public final ma.b getMSheepId() {
        return this.mSheepId;
    }

    @NotNull
    public final ma.b getMSnakeId() {
        return this.mSnakeId;
    }

    public final void getUserInfo(@NotNull String externalId, @NotNull String groupId) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(ChatServer.INSTANCE.getApis().fetchUserDetail(externalId, groupId), new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.o
            public final Object invoke(Object obj) {
                Unit userInfo$lambda$0;
                userInfo$lambda$0 = ChatViewModel.getUserInfo$lambda$0(ChatViewModel.this, (ApiResponse) obj);
                return userInfo$lambda$0;
            }
        }, new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.p
            public final Object invoke(Object obj) {
                Unit userInfo$lambda$1;
                userInfo$lambda$1 = ChatViewModel.getUserInfo$lambda$1(ChatViewModel.this, (Throwable) obj);
                return userInfo$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void inviteSheep(@NotNull String externalId, final int type, @Nullable String groupId) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(ChatServer.INSTANCE.getApis().inviteSheep(externalId, type, groupId), new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.q
            public final Object invoke(Object obj) {
                Unit inviteSheep$lambda$2;
                inviteSheep$lambda$2 = ChatViewModel.inviteSheep$lambda$2(type, this, (ApiResponse) obj);
                return inviteSheep$lambda$2;
            }
        }, new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.r
            public final Object invoke(Object obj) {
                Unit inviteSheep$lambda$3;
                inviteSheep$lambda$3 = ChatViewModel.inviteSheep$lambda$3((Throwable) obj);
                return inviteSheep$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void relationReply(@NotNull String externalId, int type, int relationType) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(ChatServer.INSTANCE.getApis().relationReply(externalId, type, relationType), new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.d
            public final Object invoke(Object obj) {
                Unit relationReply$lambda$8;
                relationReply$lambda$8 = ChatViewModel.relationReply$lambda$8((ApiResponse) obj);
                return relationReply$lambda$8;
            }
        }, new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.e
            public final Object invoke(Object obj) {
                Unit relationReply$lambda$9;
                relationReply$lambda$9 = ChatViewModel.relationReply$lambda$9(ChatViewModel.this, (Throwable) obj);
                return relationReply$lambda$9;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final i0<ApiResponse<LikeResult>> requestLike(@NotNull String toUID, boolean isLiked) {
        Intrinsics.checkNotNullParameter(toUID, "toUID");
        if (isLiked) {
            i0<ApiResponse<LikeResult>> j = ChatServer.INSTANCE.getApis().unlike(toUID).j(new pd.o() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.ChatViewModel$requestLike$1
                public final ApiResponse<LikeResult> apply(ApiResponse<LikeResult> apiResponse) {
                    Intrinsics.checkNotNullParameter(apiResponse, "it");
                    if (!apiResponse.isOk()) {
                        return apiResponse;
                    }
                    BaseControlUtils.INSTANCE.refreshLikeCount(-1);
                    return ApiResponse.Companion.success(new LikeResult(false, false));
                }
            });
            Intrinsics.checkNotNull(j);
            return j;
        }
        i0<ApiResponse<LikeResult>> j2 = ChatServer.INSTANCE.getApis().like(toUID).j(new pd.o() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.ChatViewModel$requestLike$2
            public final ApiResponse<LikeResult> apply(ApiResponse<LikeResult> apiResponse) {
                Intrinsics.checkNotNullParameter(apiResponse, "it");
                BaseControlUtils.INSTANCE.refreshLikeCount(1);
                LikeResult likeResult = (LikeResult) apiResponse.getData();
                if (likeResult != null) {
                    likeResult.setStatus(true);
                }
                return apiResponse;
            }
        });
        Intrinsics.checkNotNull(j2);
        return j2;
    }

    public final void sendStrangeMessage(@NotNull String groupId, int msgType, @NotNull String content) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(content, "content");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(ChatServer.INSTANCE.getApis().sendStrangeMessage(groupId, msgType, content), new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.m
            public final Object invoke(Object obj) {
                Unit sendStrangeMessage$lambda$14;
                sendStrangeMessage$lambda$14 = ChatViewModel.sendStrangeMessage$lambda$14((ApiResponse) obj);
                return sendStrangeMessage$lambda$14;
            }
        }, new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.n
            public final Object invoke(Object obj) {
                Unit sendStrangeMessage$lambda$15;
                sendStrangeMessage$lambda$15 = ChatViewModel.sendStrangeMessage$lambda$15((Throwable) obj);
                return sendStrangeMessage$lambda$15;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void setMSheepId(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mSheepId = bVar;
    }

    public final void setMSnakeId(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mSnakeId = bVar;
    }
}
