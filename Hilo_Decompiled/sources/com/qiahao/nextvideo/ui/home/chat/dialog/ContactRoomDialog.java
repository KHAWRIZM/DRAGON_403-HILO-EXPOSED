package com.qiahao.nextvideo.ui.home.chat.dialog;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.oudi.adapter.IListAdapter;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qhqc.core.feature.community.ui.activity.PostsNoticeActivity;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.im.CallStatus;
import com.qiahao.base_common.model.im.Identifier;
import com.qiahao.base_common.model.im.VideoCallTipsMessage;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.ui.dialog.ReportWhiteDialog;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.MessageTopData;
import com.qiahao.nextvideo.data.model.PrivateRecordBean;
import com.qiahao.nextvideo.data.service.FeedbackService;
import com.qiahao.nextvideo.data.service.TIMService;
import com.qiahao.nextvideo.databinding.RoomViewContactWrapperBinding;
import com.qiahao.nextvideo.ui.family.FamilyRecordingActivity;
import com.qiahao.nextvideo.ui.hiloassistant.HiloAssistantActivity;
import com.qiahao.nextvideo.ui.hiloinformation.HiloInformActivity;
import com.qiahao.nextvideo.ui.home.chat.MessageListAdapter;
import com.qiahao.nextvideo.ui.home.chat.activity.PeopleMatchActivity;
import com.qiahao.nextvideo.ui.home.chat.activity.StrangeListActivity;
import com.qiahao.nextvideo.ui.im.MessageDataListener;
import com.qiahao.nextvideo.ui.im.MessageListInfo;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.qiahao.nextvideo.utilities.FastClickUtils;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00072\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\tJ\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0015¢\u0006\u0004\b\u001e\u0010\u0018J\u0017\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0007H\u0016¢\u0006\u0004\b#\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010$\u001a\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00105\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010\u0018R\u001b\u0010?\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>¨\u0006A"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/dialog/ContactRoomDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Lvc/g;", "Landroid/content/Context;", "mContext", "<init>", "(Landroid/content/Context;)V", "", "initRecyclerView", "()V", "setupObserver", "", "Lcom/qiahao/nextvideo/ui/im/MessageListInfo;", "list", "refreshMessageAndScroll", "(Ljava/util/List;)V", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "receivedMessage", "judgeReceiverMessage", "(Lcom/tencent/imsdk/v2/V2TIMMessage;)V", "initStyle", "", SupportGiftRankActivity.EXTERNAL_ID, "showMenu", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "uid", "deleteSession", "Ltc/f;", "refreshLayout", "onRefresh", "(Ltc/f;)V", "dismiss", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "setCompositeDisposable", "(Lnd/a;)V", "Lcom/qiahao/nextvideo/databinding/RoomViewContactWrapperBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/RoomViewContactWrapperBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/RoomViewContactWrapperBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/RoomViewContactWrapperBinding;)V", "longSelectedUserExtraId", "Ljava/lang/String;", "getLongSelectedUserExtraId", "()Ljava/lang/String;", "setLongSelectedUserExtraId", "Lcom/qiahao/nextvideo/ui/home/chat/MessageListAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/home/chat/MessageListAdapter;", "mAdapter", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ContactRoomDialog extends AppCompatDialog implements vc.g {

    @NotNull
    private static final String TAG = "ContactRoomDialog";
    public RoomViewContactWrapperBinding binding;

    @NotNull
    private nd.a compositeDisposable;

    @NotNull
    private String longSelectedUserExtraId;

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;

    @NotNull
    private final Context mContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactRoomDialog(@NotNull Context context) {
        super(context, R.style.CommonDialogStyle);
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
        this.compositeDisposable = new nd.a();
        this.longSelectedUserExtraId = "";
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.h
            public final Object invoke() {
                MessageListAdapter mAdapter_delegate$lambda$0;
                mAdapter_delegate$lambda$0 = ContactRoomDialog.mAdapter_delegate$lambda$0();
                return mAdapter_delegate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MessageListAdapter getMAdapter() {
        return (MessageListAdapter) this.mAdapter.getValue();
    }

    private final void initRecyclerView() {
        RecyclerView recyclerView = getBinding().content.recyclerView;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getMAdapter());
        getBinding().content.smartRefreshLayout.setOnRefreshListener(this);
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.e
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ContactRoomDialog.initRecyclerView$lambda$5(ContactRoomDialog.this, baseQuickAdapter, view, i);
            }
        });
        getMAdapter().addChildClickViewIds(new int[]{R.id.user_avatar_cimage_view});
        getMAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.f
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ContactRoomDialog.initRecyclerView$lambda$6(baseQuickAdapter, view, i);
            }
        });
        getMAdapter().setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.g
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                boolean initRecyclerView$lambda$7;
                initRecyclerView$lambda$7 = ContactRoomDialog.initRecyclerView$lambda$7(ContactRoomDialog.this, baseQuickAdapter, view, i);
                return initRecyclerView$lambda$7;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initRecyclerView$lambda$5(ContactRoomDialog contactRoomDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String id2;
        AppService service;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        if (FastClickOneUtils.INSTANCE.isFastClick()) {
            MessageListInfo messageListInfo = (MessageListInfo) contactRoomDialog.getMAdapter().getItem(i);
            String messageType = messageListInfo.getMessageType();
            switch (messageType.hashCode()) {
                case -1979315295:
                    if (messageType.equals("Strange_list")) {
                        StrangeListActivity.Companion companion = StrangeListActivity.INSTANCE;
                        Context context = contactRoomDialog.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                        companion.start(context, true);
                        return;
                    }
                    return;
                case -1675218269:
                    if (messageType.equals("Hilo_Assistant")) {
                        HiloAssistantActivity.INSTANCE.start(contactRoomDialog.mContext);
                        return;
                    }
                    return;
                case -1273866319:
                    if (messageType.equals("Hilo_Information")) {
                        HiloInformActivity.INSTANCE.start(contactRoomDialog.mContext);
                        return;
                    }
                    return;
                case -1136986362:
                    if (messageType.equals("Hilo_Notification")) {
                        PostsNoticeActivity.Companion.start(contactRoomDialog.mContext);
                        return;
                    }
                    return;
                case -933217857:
                    if (messageType.equals("Hilo_Family")) {
                        FamilyRecordingActivity.INSTANCE.startActivity(contactRoomDialog.mContext);
                        return;
                    }
                    return;
                case -271174614:
                    if (messageType.equals("Hilo_match")) {
                        PeopleMatchActivity.INSTANCE.start(contactRoomDialog.mContext);
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
    public static final void initRecyclerView$lambda$6(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.im.MessageListInfo");
        MessageListInfo messageListInfo = (MessageListInfo) item;
        if (view.getId() == 2131365539) {
            AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, messageListInfo.getId(), false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initRecyclerView$lambda$7(ContactRoomDialog contactRoomDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        MessageListInfo messageListInfo = (MessageListInfo) contactRoomDialog.getMAdapter().getItem(i);
        if (Intrinsics.areEqual(messageListInfo.getMessageType(), "HILO_Message")) {
            String id2 = messageListInfo.getId();
            if (id2 == null) {
                id2 = "";
            }
            contactRoomDialog.showMenu(id2);
            return true;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initStyle() {
        setCanceledOnTouchOutside(true);
        Object systemService = getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = (Dimens.INSTANCE.getScreenHeight() / 5) * 4;
        attributes.gravity = 80;
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(attributes);
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        window3.setWindowAnimations(R.style.dialog_for_bottom_in_out_anim);
        Window window4 = getWindow();
        Intrinsics.checkNotNull(window4);
        window4.setDimAmount(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void judgeReceiverMessage(final V2TIMMessage receivedMessage) {
        getBinding().content.horizontalInteractiveView.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.a
            @Override // java.lang.Runnable
            public final void run() {
                ContactRoomDialog.judgeReceiverMessage$lambda$9(V2TIMMessage.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void judgeReceiverMessage$lambda$9(V2TIMMessage v2TIMMessage, ContactRoomDialog contactRoomDialog) {
        if (v2TIMMessage.getElemType() == 2) {
            byte[] data = v2TIMMessage.getCustomElem().getData();
            Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
            String decodeToString = StringsKt.decodeToString(data);
            TIMService tIMService = TIMService.INSTANCE;
            if (tIMService.judgeCustomTimType(decodeToString, Identifier.TIMGiftMessage)) {
                Log.d(TAG, "judgeReceiverMessage:针对最新收到的消息 去决定是否刷新当前的顶部的横向列表 礼物的情况");
                contactRoomDialog.getBinding().content.horizontalInteractiveView.onRefreshView();
            } else if (tIMService.judgeCustomTimType(decodeToString, Identifier.TIMVideoCallMessage)) {
                int callStatus = ((VideoCallTipsMessage) BaseApplication.Companion.getGSON().j(decodeToString, VideoCallTipsMessage.class)).getCallStatus();
                if (callStatus == CallStatus.NORMAL.getCode() || callStatus == CallStatus.CANCELED.getCode()) {
                    Log.d(TAG, "judgeReceiverMessage:针对最新收到的消息 去决定是否刷新当前的顶部的横向列表 视频的情况");
                    contactRoomDialog.getBinding().content.horizontalInteractiveView.onRefreshView();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MessageListAdapter mAdapter_delegate$lambda$0() {
        return new MessageListAdapter(R.layout.cell_conversation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1(IListAdapter iListAdapter, View view, int i) {
        Integer num;
        AppService service;
        String externalId;
        String externalId2;
        Intrinsics.checkNotNullParameter(iListAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        if (FastClickUtils.INSTANCE.isFastClick()) {
            Object item = iListAdapter.getItem(i);
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.MessageTopData");
            MessageTopData messageTopData = (MessageTopData) item;
            if (messageTopData.getItemType() == 2) {
                PrivateRecordBean item2 = messageTopData.getItem();
                if (item2 != null) {
                    num = Integer.valueOf(item2.getRecordType());
                } else {
                    num = null;
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
    public static final void onCreate$lambda$2() {
        MessageProvide.INSTANCE.displayData(MessageProvide.MESSAGE_DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshMessageAndScroll(List<MessageListInfo> list) {
        LinearLayoutManager layoutManager = getBinding().content.recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int findLastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
        if (list != null) {
            getMAdapter().setList(list);
            if (findLastVisibleItemPosition != -1 && findLastVisibleItemPosition > list.size() - 1) {
                getBinding().content.recyclerView.scrollToPosition(findLastVisibleItemPosition);
            }
        }
    }

    private final void setupObserver() {
        nd.c subscribe = FeedbackService.INSTANCE.getShared().getReportEventRelay().observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.ContactRoomDialog$setupObserver$1
            public final void accept(String str) {
                try {
                    V2TIMManager.getMessageManager().markC2CMessageAsRead(ContactRoomDialog.this.getLongSelectedUserExtraId(), new V2TIMCallback() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.ContactRoomDialog$setupObserver$1.1
                        @Override // com.tencent.imsdk.v2.V2TIMCallback
                        public void onError(int p0, String p1) {
                        }

                        @Override // com.tencent.imsdk.v2.V2TIMCallback
                        public void onSuccess() {
                            MessageProvide.INSTANCE.displayData(MessageProvide.MESSAGE_DEFAULT);
                        }
                    });
                    ContactRoomDialog contactRoomDialog = ContactRoomDialog.this;
                    Intrinsics.checkNotNull(str);
                    contactRoomDialog.deleteSession(str);
                } catch (Exception e) {
                    DebugToolsKt.printfE("ContactRoomDialog", "reportEventRelay 内部try()catch{}" + e.getLocalizedMessage());
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, this.compositeDisposable);
        MessageProvide messageProvide = MessageProvide.INSTANCE;
        String name = ContactRoomDialog.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        messageProvide.registerListener(name, new MessageDataListener() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.ContactRoomDialog$setupObserver$2
            @Override // com.qiahao.nextvideo.ui.im.MessageDataListener
            public void messageDataListener(ArrayList<MessageListInfo> listMessageDate, int unReadMessage, boolean isFinished) {
                Intrinsics.checkNotNullParameter(listMessageDate, "listMessageDate");
                ContactRoomDialog.this.refreshMessageAndScroll(listMessageDate);
                ContactRoomDialog.this.getBinding().content.smartRefreshLayout.finishLoadMore();
                ContactRoomDialog.this.getBinding().content.smartRefreshLayout.finishRefresh();
                ContactRoomDialog.this.getBinding().content.smartRefreshLayout.setEnableLoadMore(!isFinished);
            }
        });
        TIMService tIMService = TIMService.INSTANCE;
        nd.c subscribe2 = tIMService.getReceivedMessageRelay().observeOn(ke.a.b()).map(new pd.o() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.ContactRoomDialog$setupObserver$3
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                apply((V2TIMMessage) obj);
                return Unit.INSTANCE;
            }

            public final void apply(V2TIMMessage v2TIMMessage) {
                ContactRoomDialog contactRoomDialog = ContactRoomDialog.this;
                Intrinsics.checkNotNull(v2TIMMessage);
                contactRoomDialog.judgeReceiverMessage(v2TIMMessage);
            }
        }).observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.ContactRoomDialog$setupObserver$4
            public final void accept(Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "it");
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe2, "subscribe(...)");
        RxUtilsKt.addTo(subscribe2, this.compositeDisposable);
        nd.c subscribe3 = tIMService.getGetDeleteConversation().observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.ContactRoomDialog$setupObserver$5
            public final void accept(String str) {
                ContactRoomDialog contactRoomDialog = ContactRoomDialog.this;
                Intrinsics.checkNotNull(str);
                contactRoomDialog.deleteSession(str);
                Log.d("ContactRoomDialog", "setupObserver: 收到删除会话消息");
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe3, "subscribe(...)");
        RxUtilsKt.addTo(subscribe3, this.compositeDisposable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showMenu(String externalId) {
        Context context = getContext();
        if (context != null) {
            final MessageMenuDialog messageMenuDialog = new MessageMenuDialog(context, externalId);
            messageMenuDialog.setMListener(new Function2() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.d
                public final Object invoke(Object obj, Object obj2) {
                    Unit showMenu$lambda$12$lambda$11$lambda$10;
                    showMenu$lambda$12$lambda$11$lambda$10 = ContactRoomDialog.showMenu$lambda$12$lambda$11$lambda$10(MessageMenuDialog.this, this, (String) obj, (String) obj2);
                    return showMenu$lambda$12$lambda$11$lambda$10;
                }
            });
            messageMenuDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit showMenu$lambda$12$lambda$11$lambda$10(MessageMenuDialog messageMenuDialog, ContactRoomDialog contactRoomDialog, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, SupportGiftRankActivity.EXTERNAL_ID);
        int hashCode = str.hashCode();
        if (hashCode != -1335458389) {
            if (hashCode != -934521548) {
                if (hashCode == 93832333 && str.equals(MessageMenuDialog.BLOCK)) {
                    Context context = messageMenuDialog.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(messageMenuDialog, 2131952131)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.ContactRoomDialog$showMenu$1$1$1$1
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
                new ReportWhiteDialog(context2).setListener(new ContactRoomDialog$showMenu$1$1$1$2(str2, messageMenuDialog, contactRoomDialog)).show();
            }
        } else if (str.equals("delete")) {
            contactRoomDialog.deleteSession(str2);
        }
        return Unit.INSTANCE;
    }

    public final void deleteSession(@NotNull final String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        V2TIMConversationManager conversationManager = V2TIMManager.getConversationManager();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("c2c_%s", Arrays.copyOf(new Object[]{uid}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        conversationManager.deleteConversation(format, new V2TIMCallback() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.ContactRoomDialog$deleteSession$1
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int code, String desc) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                MessageListAdapter mAdapter;
                MessageListAdapter mAdapter2;
                mAdapter = ContactRoomDialog.this.getMAdapter();
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
                    mAdapter2 = ContactRoomDialog.this.getMAdapter();
                    mAdapter2.removeAt(i2);
                }
            }
        });
    }

    public void dismiss() {
        super.dismiss();
        MessageProvide messageProvide = MessageProvide.INSTANCE;
        String name = ContactRoomDialog.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        messageProvide.removeListener(name);
        this.compositeDisposable.d();
    }

    @NotNull
    public final RoomViewContactWrapperBinding getBinding() {
        RoomViewContactWrapperBinding roomViewContactWrapperBinding = this.binding;
        if (roomViewContactWrapperBinding != null) {
            return roomViewContactWrapperBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    @NotNull
    public final String getLongSelectedUserExtraId() {
        return this.longSelectedUserExtraId;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding((RoomViewContactWrapperBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.room_view_contact_wrapper, (ViewGroup) null, false));
        setContentView(getBinding().getRoot());
        initStyle();
        getBinding().content.horizontalInteractiveView.getMAdapter().setOnItemClickListener(new Function3() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.b
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit onCreate$lambda$1;
                onCreate$lambda$1 = ContactRoomDialog.onCreate$lambda$1((IListAdapter) obj, (View) obj2, ((Integer) obj3).intValue());
                return onCreate$lambda$1;
            }
        });
        initRecyclerView();
        setupObserver();
        getBinding().content.recyclerView.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.c
            @Override // java.lang.Runnable
            public final void run() {
                ContactRoomDialog.onCreate$lambda$2();
            }
        }, 500L);
    }

    @Override // vc.g
    public void onRefresh(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        getBinding().content.smartRefreshLayout.setEnableLoadMore(true);
        MessageProvide.INSTANCE.displayData(MessageProvide.MESSAGE_RESECT);
    }

    public final void setBinding(@NotNull RoomViewContactWrapperBinding roomViewContactWrapperBinding) {
        Intrinsics.checkNotNullParameter(roomViewContactWrapperBinding, "<set-?>");
        this.binding = roomViewContactWrapperBinding;
    }

    public final void setCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.compositeDisposable = aVar;
    }

    public final void setLongSelectedUserExtraId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.longSelectedUserExtraId = str;
    }
}
