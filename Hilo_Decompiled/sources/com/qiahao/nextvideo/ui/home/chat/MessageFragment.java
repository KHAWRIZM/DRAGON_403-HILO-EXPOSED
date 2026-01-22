package com.qiahao.nextvideo.ui.home.chat;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.oudi.adapter.IListAdapter;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qhqc.core.feature.community.CommunityManager;
import com.qhqc.core.feature.community.ui.activity.PostsNoticeActivity;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.eventBus.HomePageEvent;
import com.qiahao.base_common.model.im.CallStatus;
import com.qiahao.base_common.model.im.Identifier;
import com.qiahao.base_common.model.im.VideoCallTipsMessage;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.ui.dialog.ReportWhiteDialog;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.model.FlagBean;
import com.qiahao.nextvideo.data.model.MessageTopData;
import com.qiahao.nextvideo.data.model.PrivateRecordBean;
import com.qiahao.nextvideo.data.service.FeedbackService;
import com.qiahao.nextvideo.data.service.TIMService;
import com.qiahao.nextvideo.databinding.FragmentMessageBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.family.FamilyRecordingActivity;
import com.qiahao.nextvideo.ui.hiloassistant.HiloAssistantActivity;
import com.qiahao.nextvideo.ui.hiloinformation.HiloInformActivity;
import com.qiahao.nextvideo.ui.home.chat.activity.PeopleMatchActivity;
import com.qiahao.nextvideo.ui.home.chat.activity.StrangeListActivity;
import com.qiahao.nextvideo.ui.home.chat.dialog.MessageMenuDialog;
import com.qiahao.nextvideo.ui.home.onlinefeed.NotificationPermissionDialog;
import com.qiahao.nextvideo.ui.im.MessageDataListener;
import com.qiahao.nextvideo.ui.im.MessageListInfo;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMConversationManager;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00072\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0006J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u0006J\u000f\u0010\u001b\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u0006J\u000f\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u0006J\u0015\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\n¢\u0006\u0004\b \u0010\rJ\r\u0010!\u001a\u00020\u0007¢\u0006\u0004\b!\u0010\u0006J\u0017\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b&\u0010%J\u000f\u0010'\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010\u0006R\u0017\u0010)\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/MessageFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentMessageBinding;", "Lvc/g;", "Lvc/e;", "<init>", "()V", "", "initView", "initRecyclerView", "", SupportGiftRankActivity.EXTERNAL_ID, "showMenu", "(Ljava/lang/String;)V", "goToUserProfile", "", "Lcom/qiahao/nextvideo/ui/im/MessageListInfo;", "list", "refreshMessageAndScroll", "(Ljava/util/List;)V", "setupObserver", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "receivedMessage", "judgeReceiverMessage", "(Lcom/tencent/imsdk/v2/V2TIMMessage;)V", "checkNotificationPermission", "", "getLayoutResId", "()I", "onInitialize", "onResume", "uid", "deleteSession", "refreshGiftData", "Ltc/f;", "refreshLayout", "onRefresh", "(Ltc/f;)V", "onLoadMore", "onDestroyView", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "Lcom/qiahao/nextvideo/ui/home/chat/MessageListAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/home/chat/MessageListAdapter;", "mAdapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMessageFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageFragment.kt\ncom/qiahao/nextvideo/ui/home/chat/MessageFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,415:1\n1#2:416\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MessageFragment extends BaseBindingFragment<FragmentMessageBinding> implements vc.g, vc.e {

    @NotNull
    private final nd.a compositeDisposable = new nd.a();

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.chat.e0
        public final Object invoke() {
            MessageListAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = MessageFragment.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });

    private final void checkNotificationPermission() {
        final Context context = getContext();
        if (context != null && !androidx.core.app.r.d(context).a()) {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().judgeShowNotificationDialog(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.b0
                public final Object invoke(Object obj) {
                    Unit checkNotificationPermission$lambda$26$lambda$24;
                    checkNotificationPermission$lambda$26$lambda$24 = MessageFragment.checkNotificationPermission$lambda$26$lambda$24(context, (ApiResponse) obj);
                    return checkNotificationPermission$lambda$26$lambda$24;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.c0
                public final Object invoke(Object obj) {
                    Unit checkNotificationPermission$lambda$26$lambda$25;
                    checkNotificationPermission$lambda$26$lambda$25 = MessageFragment.checkNotificationPermission$lambda$26$lambda$25((Throwable) obj);
                    return checkNotificationPermission$lambda$26$lambda$25;
                }
            }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkNotificationPermission$lambda$26$lambda$24(Context context, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "data");
        FlagBean flagBean = (FlagBean) apiResponse.getData();
        if (flagBean != null && flagBean.getFlag()) {
            new NotificationPermissionDialog(context).show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkNotificationPermission$lambda$26$lambda$25(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MessageListAdapter getMAdapter() {
        return (MessageListAdapter) this.mAdapter.getValue();
    }

    private final void goToUserProfile(String externalId) {
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.openPersonPage(externalId);
        }
    }

    private final void initRecyclerView() {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        RecyclerView recyclerView;
        FragmentMessageBinding fragmentMessageBinding = (FragmentMessageBinding) getBinding();
        if (fragmentMessageBinding != null && (recyclerView = fragmentMessageBinding.recyclerView) != null) {
            recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(getMAdapter());
        }
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            footLoading.setBackground(androidx.core.content.a.getDrawable(footLoading.getContext(), 2131101214));
            FragmentMessageBinding fragmentMessageBinding2 = (FragmentMessageBinding) getBinding();
            if (fragmentMessageBinding2 != null && (smartRefreshLayout3 = fragmentMessageBinding2.smartRefreshLayout) != null) {
                smartRefreshLayout3.setRefreshFooter(footLoading);
            }
        }
        FragmentMessageBinding fragmentMessageBinding3 = (FragmentMessageBinding) getBinding();
        if (fragmentMessageBinding3 != null && (smartRefreshLayout2 = fragmentMessageBinding3.smartRefreshLayout) != null) {
            smartRefreshLayout2.setOnRefreshListener(this);
        }
        FragmentMessageBinding fragmentMessageBinding4 = (FragmentMessageBinding) getBinding();
        if (fragmentMessageBinding4 != null && (smartRefreshLayout = fragmentMessageBinding4.smartRefreshLayout) != null) {
            smartRefreshLayout.setOnLoadMoreListener(this);
        }
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.x
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MessageFragment.initRecyclerView$lambda$15(MessageFragment.this, baseQuickAdapter, view, i);
            }
        });
        getMAdapter().addChildClickViewIds(new int[]{R.id.user_avatar_cimage_view});
        getMAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.z
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MessageFragment.initRecyclerView$lambda$17(MessageFragment.this, baseQuickAdapter, view, i);
            }
        });
        getMAdapter().setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.a0
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                boolean initRecyclerView$lambda$18;
                initRecyclerView$lambda$18 = MessageFragment.initRecyclerView$lambda$18(MessageFragment.this, baseQuickAdapter, view, i);
                return initRecyclerView$lambda$18;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$15(MessageFragment messageFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        String id2;
        AppService service;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        if (FastClickOneUtils.INSTANCE.isFastClick()) {
            MessageListInfo messageListInfo = (MessageListInfo) messageFragment.getMAdapter().getItem(i);
            String messageType = messageListInfo.getMessageType();
            switch (messageType.hashCode()) {
                case -1979315295:
                    if (messageType.equals("Strange_list") && (context = messageFragment.getContext()) != null) {
                        StrangeListActivity.INSTANCE.start(context, false);
                        return;
                    }
                    return;
                case -1675218269:
                    if (messageType.equals("Hilo_Assistant") && (context2 = messageFragment.getContext()) != null) {
                        HiloAssistantActivity.INSTANCE.start(context2);
                        return;
                    }
                    return;
                case -1273866319:
                    if (messageType.equals("Hilo_Information") && (context3 = messageFragment.getContext()) != null) {
                        HiloInformActivity.INSTANCE.start(context3);
                        return;
                    }
                    return;
                case -1136986362:
                    if (messageType.equals("Hilo_Notification")) {
                        Context context6 = messageFragment.getContext();
                        if (context6 != null) {
                            CommunityManager.Companion.getInstance().setNoticeGoToPlazaClick(new Function0() { // from class: com.qiahao.nextvideo.ui.home.chat.f0
                                public final Object invoke() {
                                    Unit initRecyclerView$lambda$15$lambda$10$lambda$9;
                                    initRecyclerView$lambda$15$lambda$10$lambda$9 = MessageFragment.initRecyclerView$lambda$15$lambda$10$lambda$9();
                                    return initRecyclerView$lambda$15$lambda$10$lambda$9;
                                }
                            });
                            PostsNoticeActivity.Companion.start(context6);
                        }
                        MessageProvide.INSTANCE.clearUnreadMessageCount("Hilo_Notification");
                        return;
                    }
                    return;
                case -933217857:
                    if (messageType.equals("Hilo_Family") && (context4 = messageFragment.getContext()) != null) {
                        FamilyRecordingActivity.INSTANCE.startActivity(context4);
                        return;
                    }
                    return;
                case -271174614:
                    if (messageType.equals("Hilo_match") && (context5 = messageFragment.getContext()) != null) {
                        PeopleMatchActivity.INSTANCE.start(context5);
                        return;
                    }
                    return;
                case 248287468:
                    if (messageType.equals("HILO_Message") && (id2 = messageListInfo.getId()) != null && (service = AppController.INSTANCE.getService()) != null) {
                        service.toChat(id2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initRecyclerView$lambda$15$lambda$10$lambda$9() {
        cf.c.c().l(new HomePageEvent(3, 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$17(MessageFragment messageFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String id2;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.im.MessageListInfo");
        MessageListInfo messageListInfo = (MessageListInfo) item;
        if (view.getId() == 2131365539 && FastClickOneUtils.INSTANCE.isFastClick() && (id2 = messageListInfo.getId()) != null) {
            messageFragment.goToUserProfile(id2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initRecyclerView$lambda$18(MessageFragment messageFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        MessageListInfo messageListInfo = (MessageListInfo) messageFragment.getMAdapter().getItem(i);
        if (Intrinsics.areEqual(messageListInfo.getMessageType(), "HILO_Message")) {
            String id2 = messageListInfo.getId();
            if (id2 == null) {
                id2 = "";
            }
            messageFragment.showMenu(id2);
            return true;
        }
        return true;
    }

    private final void initView() {
        RecyclerView recyclerView;
        HorizontalInteractiveView horizontalInteractiveView;
        HorizontalInteractiveView horizontalInteractiveView2;
        MessageTopAdapter mAdapter;
        FragmentMessageBinding fragmentMessageBinding = (FragmentMessageBinding) getBinding();
        if (fragmentMessageBinding != null && (horizontalInteractiveView2 = fragmentMessageBinding.horizontalInteractiveView) != null && (mAdapter = horizontalInteractiveView2.getMAdapter()) != null) {
            mAdapter.setOnItemClickListener(new Function3() { // from class: com.qiahao.nextvideo.ui.home.chat.h0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit initView$lambda$1;
                    initView$lambda$1 = MessageFragment.initView$lambda$1((IListAdapter) obj, (View) obj2, ((Integer) obj3).intValue());
                    return initView$lambda$1;
                }
            });
        }
        initRecyclerView();
        setupObserver();
        FragmentMessageBinding fragmentMessageBinding2 = (FragmentMessageBinding) getBinding();
        if (fragmentMessageBinding2 != null && (horizontalInteractiveView = fragmentMessageBinding2.horizontalInteractiveView) != null) {
            horizontalInteractiveView.onRefreshView();
        }
        FragmentMessageBinding fragmentMessageBinding3 = (FragmentMessageBinding) getBinding();
        if (fragmentMessageBinding3 != null && (recyclerView = fragmentMessageBinding3.recyclerView) != null) {
            recyclerView.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.home.chat.y
                @Override // java.lang.Runnable
                public final void run() {
                    MessageFragment.initView$lambda$2();
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$1(IListAdapter iListAdapter, View view, int i) {
        MessageTopData messageTopData;
        AppService service;
        String externalId;
        String externalId2;
        Intrinsics.checkNotNullParameter(iListAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        if (FastClickOneUtils.INSTANCE.isFastClick()) {
            Object item = iListAdapter.getItem(i);
            Integer num = null;
            if (item instanceof MessageTopData) {
                messageTopData = (MessageTopData) item;
            } else {
                messageTopData = null;
            }
            if (messageTopData != null && messageTopData.getItemType() == 2) {
                PrivateRecordBean item2 = messageTopData.getItem();
                if (item2 != null) {
                    num = Integer.valueOf(item2.getRecordType());
                }
                String str = "";
                if ((num == null || num.intValue() != 1) && (num == null || num.intValue() != 3)) {
                    if (num != null && num.intValue() == 2 && (service = AppController.INSTANCE.getService()) != null) {
                        PrivateRecordBean item3 = messageTopData.getItem();
                        if (item3 != null && (externalId = item3.getExternalId()) != null) {
                            str = externalId;
                        }
                        service.openPersonPage(str);
                    }
                } else {
                    AppService service2 = AppController.INSTANCE.getService();
                    if (service2 != null) {
                        PrivateRecordBean item4 = messageTopData.getItem();
                        if (item4 != null && (externalId2 = item4.getExternalId()) != null) {
                            str = externalId2;
                        }
                        service2.toChat(str);
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2() {
        MessageProvide.INSTANCE.displayData(MessageProvide.MESSAGE_DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void judgeReceiverMessage(final V2TIMMessage receivedMessage) {
        HorizontalInteractiveView horizontalInteractiveView;
        FragmentMessageBinding fragmentMessageBinding = (FragmentMessageBinding) getBinding();
        if (fragmentMessageBinding != null && (horizontalInteractiveView = fragmentMessageBinding.horizontalInteractiveView) != null) {
            horizontalInteractiveView.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.home.chat.d0
                @Override // java.lang.Runnable
                public final void run() {
                    MessageFragment.judgeReceiverMessage$lambda$23(V2TIMMessage.this, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void judgeReceiverMessage$lambda$23(V2TIMMessage v2TIMMessage, MessageFragment messageFragment) {
        FragmentMessageBinding fragmentMessageBinding;
        HorizontalInteractiveView horizontalInteractiveView;
        HorizontalInteractiveView horizontalInteractiveView2;
        if (v2TIMMessage.getElemType() == 2 && v2TIMMessage.getCustomElem().getData() != null) {
            byte[] data = v2TIMMessage.getCustomElem().getData();
            Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
            String decodeToString = StringsKt.decodeToString(data);
            TIMService tIMService = TIMService.INSTANCE;
            if (tIMService.judgeCustomTimType(decodeToString, Identifier.TIMGiftMessage)) {
                FragmentMessageBinding fragmentMessageBinding2 = (FragmentMessageBinding) messageFragment.getBinding();
                if (fragmentMessageBinding2 != null && (horizontalInteractiveView2 = fragmentMessageBinding2.horizontalInteractiveView) != null) {
                    horizontalInteractiveView2.onRefreshView();
                    return;
                }
                return;
            }
            if (tIMService.judgeCustomTimType(decodeToString, Identifier.TIMVideoCallMessage)) {
                int callStatus = ((VideoCallTipsMessage) BaseApplication.Companion.getGSON().j(decodeToString, VideoCallTipsMessage.class)).getCallStatus();
                if ((callStatus == CallStatus.NORMAL.getCode() || callStatus == CallStatus.CANCELED.getCode()) && (fragmentMessageBinding = (FragmentMessageBinding) messageFragment.getBinding()) != null && (horizontalInteractiveView = fragmentMessageBinding.horizontalInteractiveView) != null) {
                    horizontalInteractiveView.onRefreshView();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MessageListAdapter mAdapter_delegate$lambda$0() {
        return new MessageListAdapter(R.layout.cell_conversation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshMessageAndScroll(List<MessageListInfo> list) {
        RecyclerView.LayoutManager layoutManager;
        int i;
        FragmentMessageBinding fragmentMessageBinding;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        FragmentMessageBinding fragmentMessageBinding2 = (FragmentMessageBinding) getBinding();
        LinearLayoutManager linearLayoutManager = null;
        if (fragmentMessageBinding2 != null && (recyclerView2 = fragmentMessageBinding2.recyclerView) != null) {
            layoutManager = recyclerView2.getLayoutManager();
        } else {
            layoutManager = null;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        }
        if (linearLayoutManager != null) {
            i = linearLayoutManager.findLastVisibleItemPosition();
        } else {
            i = 0;
        }
        if (list != null) {
            getMAdapter().setList(list);
            if (i != -1 && i > list.size() - 1 && (fragmentMessageBinding = (FragmentMessageBinding) getBinding()) != null && (recyclerView = fragmentMessageBinding.recyclerView) != null) {
                recyclerView.scrollToPosition(i);
            }
        }
    }

    private final void setupObserver() {
        nd.c subscribe = FeedbackService.INSTANCE.getShared().getReportEventRelay().observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.home.chat.MessageFragment$setupObserver$1
            public final void accept(String str) {
                try {
                    V2TIMManager.getMessageManager().markC2CMessageAsRead(str, new V2TIMCallback() { // from class: com.qiahao.nextvideo.ui.home.chat.MessageFragment$setupObserver$1.1
                        @Override // com.tencent.imsdk.v2.V2TIMCallback
                        public void onError(int p0, String p1) {
                        }

                        @Override // com.tencent.imsdk.v2.V2TIMCallback
                        public void onSuccess() {
                            MessageProvide.INSTANCE.displayData(MessageProvide.MESSAGE_DEFAULT);
                        }
                    });
                    MessageFragment messageFragment = MessageFragment.this;
                    Intrinsics.checkNotNull(str);
                    messageFragment.deleteSession(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, this.compositeDisposable);
        MessageProvide messageProvide = MessageProvide.INSTANCE;
        String name = MessageFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        messageProvide.registerListener(name, new MessageDataListener() { // from class: com.qiahao.nextvideo.ui.home.chat.MessageFragment$setupObserver$2
            @Override // com.qiahao.nextvideo.ui.im.MessageDataListener
            public void messageDataListener(ArrayList<MessageListInfo> listMessageDate, int unReadMessage, boolean isFinished) {
                SmartRefreshLayout smartRefreshLayout;
                SmartRefreshLayout smartRefreshLayout2;
                SmartRefreshLayout smartRefreshLayout3;
                Intrinsics.checkNotNullParameter(listMessageDate, "listMessageDate");
                MessageFragment.this.refreshMessageAndScroll(listMessageDate);
                FragmentMessageBinding fragmentMessageBinding = (FragmentMessageBinding) MessageFragment.this.getBinding();
                if (fragmentMessageBinding != null && (smartRefreshLayout3 = fragmentMessageBinding.smartRefreshLayout) != null) {
                    smartRefreshLayout3.finishLoadMore();
                }
                FragmentMessageBinding fragmentMessageBinding2 = (FragmentMessageBinding) MessageFragment.this.getBinding();
                if (fragmentMessageBinding2 != null && (smartRefreshLayout2 = fragmentMessageBinding2.smartRefreshLayout) != null) {
                    smartRefreshLayout2.finishRefresh();
                }
                FragmentMessageBinding fragmentMessageBinding3 = (FragmentMessageBinding) MessageFragment.this.getBinding();
                if (fragmentMessageBinding3 != null && (smartRefreshLayout = fragmentMessageBinding3.smartRefreshLayout) != null) {
                    smartRefreshLayout.setEnableLoadMore(!isFinished);
                }
            }
        });
        TIMService tIMService = TIMService.INSTANCE;
        nd.c subscribe2 = tIMService.getReceivedMessageRelay().observeOn(ke.a.b()).map(new pd.o() { // from class: com.qiahao.nextvideo.ui.home.chat.MessageFragment$setupObserver$3
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                apply((V2TIMMessage) obj);
                return Unit.INSTANCE;
            }

            public final void apply(V2TIMMessage v2TIMMessage) {
                MessageFragment messageFragment = MessageFragment.this;
                Intrinsics.checkNotNull(v2TIMMessage);
                messageFragment.judgeReceiverMessage(v2TIMMessage);
            }
        }).observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.home.chat.MessageFragment$setupObserver$4
            public final void accept(Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "it");
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe2, "subscribe(...)");
        RxUtilsKt.addTo(subscribe2, this.compositeDisposable);
        nd.c subscribe3 = tIMService.getGetDeleteConversation().observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.home.chat.MessageFragment$setupObserver$5
            public final void accept(String str) {
                MessageFragment messageFragment = MessageFragment.this;
                Intrinsics.checkNotNull(str);
                messageFragment.deleteSession(str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe3, "subscribe(...)");
        RxUtilsKt.addTo(subscribe3, this.compositeDisposable);
    }

    private final void showMenu(String externalId) {
        Context context = getContext();
        if (context != null) {
            final MessageMenuDialog messageMenuDialog = new MessageMenuDialog(context, externalId);
            messageMenuDialog.setMListener(new Function2() { // from class: com.qiahao.nextvideo.ui.home.chat.g0
                public final Object invoke(Object obj, Object obj2) {
                    Unit showMenu$lambda$21$lambda$20$lambda$19;
                    showMenu$lambda$21$lambda$20$lambda$19 = MessageFragment.showMenu$lambda$21$lambda$20$lambda$19(MessageMenuDialog.this, this, (String) obj, (String) obj2);
                    return showMenu$lambda$21$lambda$20$lambda$19;
                }
            });
            messageMenuDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit showMenu$lambda$21$lambda$20$lambda$19(MessageMenuDialog messageMenuDialog, MessageFragment messageFragment, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, SupportGiftRankActivity.EXTERNAL_ID);
        int hashCode = str.hashCode();
        if (hashCode != -1335458389) {
            if (hashCode != -934521548) {
                if (hashCode == 93832333 && str.equals(MessageMenuDialog.BLOCK)) {
                    Context context = messageMenuDialog.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(messageMenuDialog, 2131952131)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.chat.MessageFragment$showMenu$1$1$1$1
                        public void cancel() {
                            OnCommonDialogListener.DefaultImpls.cancel(this);
                        }

                        public void confirm() {
                        }
                    }).show();
                }
            } else if (str.equals("report")) {
                Context context2 = messageMenuDialog.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                new ReportWhiteDialog(context2).setListener(new MessageFragment$showMenu$1$1$1$2(str2, messageMenuDialog, messageFragment)).show();
            }
        } else if (str.equals("delete")) {
            messageFragment.deleteSession(str2);
        }
        return Unit.INSTANCE;
    }

    public final void deleteSession(@NotNull final String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        V2TIMConversationManager conversationManager = V2TIMManager.getConversationManager();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("c2c_%s", Arrays.copyOf(new Object[]{uid}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        conversationManager.deleteConversation(format, new V2TIMCallback() { // from class: com.qiahao.nextvideo.ui.home.chat.MessageFragment$deleteSession$1
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int code, String desc) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                MessageListAdapter mAdapter;
                MessageListAdapter mAdapter2;
                mAdapter = MessageFragment.this.getMAdapter();
                List data = mAdapter.getData();
                String str = uid;
                int i = 0;
                int i2 = -1;
                for (Object obj : data) {
                    int i3 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    if (Intrinsics.areEqual(((MessageListInfo) obj).getId(), str)) {
                        i2 = i;
                    }
                    i = i3;
                }
                if (i2 != -1) {
                    mAdapter2 = MessageFragment.this.getMAdapter();
                    mAdapter2.removeAt(i2);
                }
            }
        });
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    protected int getLayoutResId() {
        return R.layout.fragment_message;
    }

    public void onDestroyView() {
        RecyclerView recyclerView;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        HorizontalInteractiveView horizontalInteractiveView;
        MessageTopAdapter mAdapter;
        FragmentMessageBinding fragmentMessageBinding = (FragmentMessageBinding) getBinding();
        if (fragmentMessageBinding != null && (horizontalInteractiveView = fragmentMessageBinding.horizontalInteractiveView) != null && (mAdapter = horizontalInteractiveView.getMAdapter()) != null) {
            mAdapter.setOnItemClickListener((OnItemClickListener) null);
        }
        getMAdapter().setOnItemLongClickListener((OnItemLongClickListener) null);
        getMAdapter().setOnItemChildClickListener((OnItemChildClickListener) null);
        getMAdapter().setOnItemClickListener((OnItemClickListener) null);
        FragmentMessageBinding fragmentMessageBinding2 = (FragmentMessageBinding) getBinding();
        if (fragmentMessageBinding2 != null && (smartRefreshLayout2 = fragmentMessageBinding2.smartRefreshLayout) != null) {
            smartRefreshLayout2.setOnRefreshListener(null);
        }
        FragmentMessageBinding fragmentMessageBinding3 = (FragmentMessageBinding) getBinding();
        if (fragmentMessageBinding3 != null && (smartRefreshLayout = fragmentMessageBinding3.smartRefreshLayout) != null) {
            smartRefreshLayout.setOnLoadMoreListener(null);
        }
        MessageProvide messageProvide = MessageProvide.INSTANCE;
        String name = MessageFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        messageProvide.removeListener(name);
        this.compositeDisposable.d();
        FragmentMessageBinding fragmentMessageBinding4 = (FragmentMessageBinding) getBinding();
        if (fragmentMessageBinding4 != null && (recyclerView = fragmentMessageBinding4.recyclerView) != null) {
            recyclerView.setAdapter((RecyclerView.Adapter) null);
        }
        super.onDestroyView();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
    }

    @Override // vc.e
    public void onLoadMore(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        MessageProvide.INSTANCE.displayData(MessageProvide.MESSAGE_NEXT_PAGE);
    }

    @Override // vc.g
    public void onRefresh(@NotNull tc.f refreshLayout) {
        HorizontalInteractiveView horizontalInteractiveView;
        SmartRefreshLayout smartRefreshLayout;
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        FragmentMessageBinding fragmentMessageBinding = (FragmentMessageBinding) getBinding();
        if (fragmentMessageBinding != null && (smartRefreshLayout = fragmentMessageBinding.smartRefreshLayout) != null) {
            smartRefreshLayout.setEnableLoadMore(true);
        }
        MessageProvide.INSTANCE.displayData(MessageProvide.MESSAGE_RESECT);
        FragmentMessageBinding fragmentMessageBinding2 = (FragmentMessageBinding) getBinding();
        if (fragmentMessageBinding2 != null && (horizontalInteractiveView = fragmentMessageBinding2.horizontalInteractiveView) != null) {
            horizontalInteractiveView.onRefreshView();
        }
    }

    public void onResume() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        MessageProvide.INSTANCE.displayData(MessageProvide.MESSAGE_DEFAULT);
        checkNotificationPermission();
    }

    public final void refreshGiftData() {
        HorizontalInteractiveView horizontalInteractiveView;
        FragmentMessageBinding fragmentMessageBinding = (FragmentMessageBinding) getBinding();
        if (fragmentMessageBinding != null && (horizontalInteractiveView = fragmentMessageBinding.horizontalInteractiveView) != null) {
            horizontalInteractiveView.onRefreshView();
        }
    }
}
