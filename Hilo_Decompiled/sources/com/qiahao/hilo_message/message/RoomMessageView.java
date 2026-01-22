package com.qiahao.hilo_message.message;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.aliyun.ams.emas.push.AgooMessageReceiver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.R;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.hilo_message.adapter.RoomMessageAdapter;
import com.qiahao.hilo_message.data.GroupMessageNew;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.hilo_message.databinding.RoomMessageViewBinding;
import com.qiahao.hilo_message.listener.RoomMessageItemListener;
import com.qiahao.hilo_message.utils.MessageProcessor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import roomMessage.RoomMessage;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \\2\u00020\u0001:\u0001\\B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010=\u001a\u00020>H\u0003J\u0006\u0010?\u001a\u00020>J\u000e\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u000201J\u0006\u0010B\u001a\u000201J\u0006\u0010C\u001a\u00020>J\u0014\u0010D\u001a\u00020>2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020(0FJ\u0014\u0010G\u001a\u00020>2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020(0FJ\u0018\u0010G\u001a\u00020>2\u0006\u0010E\u001a\u00020(2\b\b\u0002\u0010H\u001a\u000201J\u0006\u0010I\u001a\u00020>J\u001a\u0010H\u001a\u00020>2\b\b\u0002\u0010J\u001a\u0002012\b\b\u0002\u0010K\u001a\u000201J\u0018\u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020\n2\b\b\u0002\u0010N\u001a\u00020OJ\b\u0010P\u001a\u0004\u0018\u00010\rJ\u0006\u0010K\u001a\u000201J\u000e\u0010Q\u001a\u00020>2\u0006\u0010E\u001a\u00020RJ\u0010\u0010Q\u001a\u00020>2\b\u0010E\u001a\u0004\u0018\u00010(J\u0010\u0010S\u001a\u0004\u0018\u00010(2\u0006\u0010T\u001a\u00020!J\u0018\u0010Q\u001a\u00020>2\b\u0010U\u001a\u0004\u0018\u00010!2\u0006\u0010V\u001a\u00020\nJ\u000e\u0010W\u001a\u00020>2\u0006\u0010X\u001a\u00020YJ\u0006\u0010Z\u001a\u00020>J\u0006\u0010[\u001a\u00020>R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R \u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010-\u001a\b\u0012\u0004\u0012\u00020(0'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R \u00107\u001a\b\u0012\u0004\u0012\u00020(08X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006]"}, d2 = {"Lcom/qiahao/hilo_message/message/RoomMessageView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBinding", "Lcom/qiahao/hilo_message/databinding/RoomMessageViewBinding;", "getMBinding", "()Lcom/qiahao/hilo_message/databinding/RoomMessageViewBinding;", "setMBinding", "(Lcom/qiahao/hilo_message/databinding/RoomMessageViewBinding;)V", "mAdapter", "Lcom/qiahao/hilo_message/adapter/RoomMessageAdapter;", "getMAdapter", "()Lcom/qiahao/hilo_message/adapter/RoomMessageAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "mFirstVisiblePosition", "getMFirstVisiblePosition", "()I", "setMFirstVisiblePosition", "(I)V", "mLastVisiblePosition", "getMLastVisiblePosition", "setMLastVisiblePosition", "mExternalId", "", "getMExternalId", "()Ljava/lang/String;", "setMExternalId", "(Ljava/lang/String;)V", "mAllMessageList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/qiahao/hilo_message/data/RoomMessageMulti;", "getMAllMessageList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setMAllMessageList", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "mMessageList", "getMMessageList", "setMMessageList", "isSmoothScrolling", "", "mLinearSmoothScroller", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "hasNewScroll", "mRecyclerViewEvent", "mMessageTab", "mMessageProcessor", "Lcom/qiahao/hilo_message/utils/MessageProcessor;", "getMMessageProcessor", "()Lcom/qiahao/hilo_message/utils/MessageProcessor;", "setMMessageProcessor", "(Lcom/qiahao/hilo_message/utils/MessageProcessor;)V", "initView", "", "refreshTabView", "hideOrShowTab", LiveEvent.SHOW_ANIMATION, "checkScrollToBottom", "stopScroll", "newData", "data", "", "addData", "scrollToBottom", "checkDeleteMessage", "isRightNowScroll", "isLastPosition", "smoothScrollToPosition", "position", TransferTable.COLUMN_SPEED, "", "messageBinding", "refreshMessageStatus", "LroomMessage/RoomMessage$GroupMessageSendRsp;", "getMessageById", AgooMessageReceiver.MESSAGE_ID, "msgId", "messageStatus", "setMessageItemListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/qiahao/hilo_message/listener/RoomMessageItemListener;", "clearAllData", "destroy", "Companion", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomMessageView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomMessageView.kt\ncom/qiahao/hilo_message/message/RoomMessageView\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,465:1\n61#2,9:466\n61#2,9:475\n774#3:484\n865#3,2:485\n774#3:487\n865#3,2:488\n1617#3,9:490\n1869#3:499\n1870#3:501\n1626#3:502\n1869#3,2:503\n774#3:505\n865#3,2:506\n1878#3,3:508\n1878#3,3:511\n1878#3,2:514\n1878#3,3:516\n1880#3:519\n1878#3,3:520\n1878#3,3:523\n1878#3,3:526\n1869#3,2:529\n1#4:500\n*S KotlinDebug\n*F\n+ 1 RoomMessageView.kt\ncom/qiahao/hilo_message/message/RoomMessageView\n*L\n127#1:466,9\n139#1:475,9\n197#1:484\n197#1:485,2\n209#1:487\n209#1:488,2\n210#1:490,9\n210#1:499\n210#1:501\n210#1:502\n213#1:503,2\n221#1:505\n221#1:506,2\n349#1:508,3\n358#1:511,3\n377#1:514,2\n386#1:516,3\n377#1:519\n404#1:520,3\n419#1:523,3\n428#1:526,3\n69#1:529,2\n210#1:500\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class RoomMessageView extends FrameLayout {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static int MAX_MESSAGE_COUNT = 600;
    private boolean hasNewScroll;
    private boolean isSmoothScrolling;

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;

    @NotNull
    private CopyOnWriteArrayList<RoomMessageMulti> mAllMessageList;

    @Nullable
    private RoomMessageViewBinding mBinding;

    @NotNull
    private String mExternalId;
    private int mFirstVisiblePosition;
    private int mLastVisiblePosition;

    @Nullable
    private LinearSmoothScroller mLinearSmoothScroller;

    @NotNull
    private CopyOnWriteArrayList<RoomMessageMulti> mMessageList;

    @NotNull
    private MessageProcessor<RoomMessageMulti> mMessageProcessor;
    private int mMessageTab;
    private int mRecyclerViewEvent;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/qiahao/hilo_message/message/RoomMessageView$Companion;", "", "<init>", "()V", "MAX_MESSAGE_COUNT", "", "getMAX_MESSAGE_COUNT", "()I", "setMAX_MESSAGE_COUNT", "(I)V", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getMAX_MESSAGE_COUNT() {
            return RoomMessageView.MAX_MESSAGE_COUNT;
        }

        public final void setMAX_MESSAGE_COUNT(int i10) {
            RoomMessageView.MAX_MESSAGE_COUNT = i10;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomMessageView(@NotNull Context context) {
        super(context);
        User user;
        String externalId;
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.hilo_message.message.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                RoomMessageAdapter mAdapter_delegate$lambda$0;
                mAdapter_delegate$lambda$0 = RoomMessageView.mAdapter_delegate$lambda$0();
                return mAdapter_delegate$lambda$0;
            }
        });
        this.mFirstVisiblePosition = -1;
        this.mLastVisiblePosition = -1;
        AppService service = AppController.INSTANCE.getService();
        this.mExternalId = (service == null || (user = service.getUser()) == null || (externalId = user.getExternalId()) == null) ? "" : externalId;
        this.mAllMessageList = new CopyOnWriteArrayList<>();
        this.mMessageList = new CopyOnWriteArrayList<>();
        this.mRecyclerViewEvent = 1;
        this.mMessageProcessor = new MessageProcessor<>(new Function1() { // from class: com.qiahao.hilo_message.message.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit mMessageProcessor$lambda$1;
                mMessageProcessor$lambda$1 = RoomMessageView.mMessageProcessor$lambda$1(RoomMessageView.this, (List) obj);
                return mMessageProcessor$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.hilo_message.message.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean mMessageProcessor$lambda$3;
                mMessageProcessor$lambda$3 = RoomMessageView.mMessageProcessor$lambda$3(RoomMessageView.this, (RoomMessageMulti) obj);
                return Boolean.valueOf(mMessageProcessor$lambda$3);
            }
        });
        initView();
    }

    public static /* synthetic */ void addData$default(RoomMessageView roomMessageView, RoomMessageMulti roomMessageMulti, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        roomMessageView.addData(roomMessageMulti, z10);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initView() {
        int i10;
        final TextView textView;
        final TextView textView2;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        RecyclerView recyclerView4;
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            i10 = service.roomMessageTab();
        } else {
            i10 = 0;
        }
        this.mMessageTab = i10;
        this.mBinding = RoomMessageViewBinding.inflate(LayoutInflater.from(getContext()), this, true);
        refreshTabView();
        RoomMessageViewBinding roomMessageViewBinding = this.mBinding;
        if (roomMessageViewBinding != null && (recyclerView4 = roomMessageViewBinding.recyclerView) != null) {
            recyclerView4.setAdapter(getMAdapter());
        }
        RoomMessageViewBinding roomMessageViewBinding2 = this.mBinding;
        if (roomMessageViewBinding2 != null && (recyclerView3 = roomMessageViewBinding2.recyclerView) != null) {
            recyclerView3.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.qiahao.hilo_message.message.RoomMessageView$initView$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView5, int dx, int dy) {
                    LinearLayoutManager linearLayoutManager;
                    int i11;
                    Intrinsics.checkNotNullParameter(recyclerView5, "recyclerView");
                    RecyclerView.LayoutManager layoutManager = recyclerView5.getLayoutManager();
                    if (layoutManager instanceof LinearLayoutManager) {
                        linearLayoutManager = (LinearLayoutManager) layoutManager;
                    } else {
                        linearLayoutManager = null;
                    }
                    RoomMessageView roomMessageView = RoomMessageView.this;
                    int i12 = -1;
                    if (linearLayoutManager != null) {
                        i11 = linearLayoutManager.findFirstVisibleItemPosition();
                    } else {
                        i11 = -1;
                    }
                    roomMessageView.setMFirstVisiblePosition(i11);
                    RoomMessageView roomMessageView2 = RoomMessageView.this;
                    if (linearLayoutManager != null) {
                        i12 = linearLayoutManager.findLastVisibleItemPosition();
                    }
                    roomMessageView2.setMLastVisiblePosition(i12);
                }
            });
        }
        RoomMessageViewBinding roomMessageViewBinding3 = this.mBinding;
        if (roomMessageViewBinding3 != null && (recyclerView2 = roomMessageViewBinding3.recyclerView) != null) {
            recyclerView2.setOnTouchListener(new View.OnTouchListener() { // from class: com.qiahao.hilo_message.message.d
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean initView$lambda$4;
                    initView$lambda$4 = RoomMessageView.initView$lambda$4(RoomMessageView.this, view, motionEvent);
                    return initView$lambda$4;
                }
            });
        }
        RoomMessageViewBinding roomMessageViewBinding4 = this.mBinding;
        if (roomMessageViewBinding4 != null && (recyclerView = roomMessageViewBinding4.recyclerView) != null) {
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.qiahao.hilo_message.message.RoomMessageView$initView$3
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.checkNotNullParameter(outRect, "outRect");
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(state, "state");
                    super.getItemOffsets(outRect, view, parent, state);
                    outRect.top = UiKtxKt.toPX(10);
                }
            });
        }
        RoomMessageViewBinding roomMessageViewBinding5 = this.mBinding;
        final long j10 = 800;
        if (roomMessageViewBinding5 != null && (textView2 = roomMessageViewBinding5.all) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.hilo_message.message.RoomMessageView$initView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i11;
                    int i12;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j10 || (textView2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                        i11 = this.mMessageTab;
                        if (i11 != 0) {
                            this.stopScroll();
                            this.mMessageTab = 0;
                            this.refreshTabView();
                            AppService service2 = AppController.INSTANCE.getService();
                            if (service2 != null) {
                                i12 = this.mMessageTab;
                                service2.changeRoomMessageTab(i12);
                            }
                            this.getMMessageList().clear();
                            this.getMMessageList().addAll(this.getMAllMessageList());
                            this.getMAdapter().setList(this.getMAllMessageList());
                            RoomMessageView.scrollToBottom$default(this, true, false, 2, null);
                        }
                    }
                }
            });
        }
        RoomMessageViewBinding roomMessageViewBinding6 = this.mBinding;
        if (roomMessageViewBinding6 != null && (textView = roomMessageViewBinding6.chat) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.hilo_message.message.RoomMessageView$initView$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i11;
                    Integer msgTab;
                    int i12;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j10 || (textView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                        i11 = this.mMessageTab;
                        if (i11 != 1) {
                            this.stopScroll();
                            this.mMessageTab = 1;
                            this.refreshTabView();
                            AppService service2 = AppController.INSTANCE.getService();
                            if (service2 != null) {
                                i12 = this.mMessageTab;
                                service2.changeRoomMessageTab(i12);
                            }
                            CopyOnWriteArrayList<RoomMessageMulti> mAllMessageList = this.getMAllMessageList();
                            ArrayList arrayList = new ArrayList();
                            for (Object obj : mAllMessageList) {
                                GroupMessageNew data = ((RoomMessageMulti) obj).getData();
                                if (data != null && (msgTab = data.getMsgTab()) != null && msgTab.intValue() == 1) {
                                    arrayList.add(obj);
                                }
                            }
                            this.getMMessageList().clear();
                            this.getMMessageList().addAll(arrayList);
                            this.getMAdapter().setList(arrayList);
                            RoomMessageView.scrollToBottom$default(this, true, false, 2, null);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$4(RoomMessageView roomMessageView, View view, MotionEvent motionEvent) {
        RecyclerView recyclerView;
        roomMessageView.mRecyclerViewEvent = motionEvent.getAction();
        if (motionEvent.getAction() == 0 && roomMessageView.isSmoothScrolling) {
            roomMessageView.isSmoothScrolling = false;
            roomMessageView.hasNewScroll = false;
            RoomMessageViewBinding roomMessageViewBinding = roomMessageView.mBinding;
            if (roomMessageViewBinding != null && (recyclerView = roomMessageViewBinding.recyclerView) != null) {
                recyclerView.stopScroll();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomMessageAdapter mAdapter_delegate$lambda$0() {
        return new RoomMessageAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mMessageProcessor$lambda$1(RoomMessageView roomMessageView, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        roomMessageView.addData(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mMessageProcessor$lambda$3(RoomMessageView roomMessageView, RoomMessageMulti data) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(data, "data");
        for (RoomMessageMulti roomMessageMulti : CollectionsKt.asReversedMutable(roomMessageView.mMessageList)) {
            GroupMessageNew data2 = roomMessageMulti.getData();
            String str3 = null;
            if (data2 != null) {
                str = data2.getMsgId();
            } else {
                str = null;
            }
            GroupMessageNew data3 = data.getData();
            if (data3 != null) {
                str2 = data3.getMsgId();
            } else {
                str2 = null;
            }
            if (Intrinsics.areEqual(str, str2)) {
                GroupMessageNew data4 = roomMessageMulti.getData();
                if (data4 != null) {
                    str3 = data4.getFromAccount();
                }
                if (Intrinsics.areEqual(str3, roomMessageView.mExternalId)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static /* synthetic */ void scrollToBottom$default(RoomMessageView roomMessageView, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        roomMessageView.scrollToBottom(z10, z11);
    }

    public static /* synthetic */ void smoothScrollToPosition$default(RoomMessageView roomMessageView, int i10, float f10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f10 = 100.0f;
        }
        roomMessageView.smoothScrollToPosition(i10, f10);
    }

    public final void addData(@NotNull List<RoomMessageMulti> data) {
        Integer msgTab;
        Intrinsics.checkNotNullParameter(data, "data");
        boolean isLastPosition = isLastPosition();
        checkDeleteMessage();
        CopyOnWriteArrayList<RoomMessageMulti> copyOnWriteArrayList = this.mAllMessageList;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            GroupMessageNew data2 = ((RoomMessageMulti) next).getData();
            if (Intrinsics.areEqual(data2 != null ? data2.getFromAccount() : null, this.mExternalId)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            GroupMessageNew data3 = ((RoomMessageMulti) it2.next()).getData();
            String msgId = data3 != null ? data3.getMsgId() : null;
            if (msgId != null) {
                arrayList2.add(msgId);
            }
        }
        Set set = CollectionsKt.toSet(arrayList2);
        for (RoomMessageMulti roomMessageMulti : data) {
            GroupMessageNew data4 = roomMessageMulti.getData();
            String msgId2 = data4 != null ? data4.getMsgId() : null;
            if (msgId2 == null || !set.contains(msgId2)) {
                this.mAllMessageList.add(roomMessageMulti);
            }
        }
        if (this.mMessageTab == 1) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : data) {
                GroupMessageNew data5 = ((RoomMessageMulti) obj).getData();
                if (data5 != null && (msgTab = data5.getMsgTab()) != null && msgTab.intValue() == 1) {
                    arrayList3.add(obj);
                }
            }
            data = arrayList3;
        }
        this.mMessageList.addAll(data);
        getMAdapter().addData((Collection) data);
        if (data.size() > 1) {
            isLastPosition = true;
        }
        scrollToBottom$default(this, false, isLastPosition, 1, null);
    }

    public final void checkDeleteMessage() {
        try {
            if (this.mAllMessageList.size() > MAX_MESSAGE_COUNT) {
                List<RoomMessageMulti> subList = this.mAllMessageList.subList(0, Math.min(400, this.mAllMessageList.size()));
                Intrinsics.checkNotNullExpressionValue(subList, "subList(...)");
                subList.clear();
            }
            if (this.mMessageList.size() > MAX_MESSAGE_COUNT) {
                List<RoomMessageMulti> subList2 = this.mMessageList.subList(0, Math.min(400, this.mMessageList.size()));
                Intrinsics.checkNotNullExpressionValue(subList2, "subList(...)");
                subList2.clear();
                getMAdapter().setList(this.mMessageList);
                getMAdapter().notifyDataSetChanged();
            }
        } catch (Exception e10) {
            LogUtil.e$default(LogUtil.INSTANCE, "RoomMessageView", "checkDeleteMessage: " + e10.getMessage(), false, 4, (Object) null);
        }
    }

    public final boolean checkScrollToBottom() {
        if (this.mLastVisiblePosition == getMAdapter().getData().size() - 1) {
            return true;
        }
        return false;
    }

    public final void clearAllData() {
        this.mAllMessageList.clear();
        this.mMessageList.clear();
        getMAdapter().setList(null);
    }

    public final void destroy() {
        this.mMessageProcessor.destroy();
        this.mAllMessageList.clear();
        this.mMessageList.clear();
    }

    @NotNull
    public final RoomMessageAdapter getMAdapter() {
        return (RoomMessageAdapter) this.mAdapter.getValue();
    }

    @NotNull
    public final CopyOnWriteArrayList<RoomMessageMulti> getMAllMessageList() {
        return this.mAllMessageList;
    }

    @Nullable
    public final RoomMessageViewBinding getMBinding() {
        return this.mBinding;
    }

    @NotNull
    public final String getMExternalId() {
        return this.mExternalId;
    }

    public final int getMFirstVisiblePosition() {
        return this.mFirstVisiblePosition;
    }

    public final int getMLastVisiblePosition() {
        return this.mLastVisiblePosition;
    }

    @NotNull
    public final CopyOnWriteArrayList<RoomMessageMulti> getMMessageList() {
        return this.mMessageList;
    }

    @NotNull
    public final MessageProcessor<RoomMessageMulti> getMMessageProcessor() {
        return this.mMessageProcessor;
    }

    @Nullable
    public final RoomMessageMulti getMessageById(@NotNull String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Iterator<T> it = this.mMessageList.iterator();
        int i10 = 0;
        while (true) {
            String str = null;
            if (!it.hasNext()) {
                return null;
            }
            Object next = it.next();
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            RoomMessageMulti roomMessageMulti = (RoomMessageMulti) next;
            GroupMessageNew data = roomMessageMulti.getData();
            if (data != null) {
                str = data.getMsgId();
            }
            if (Intrinsics.areEqual(str, messageId)) {
                return roomMessageMulti;
            }
            i10 = i11;
        }
    }

    public final void hideOrShowTab(boolean isShow) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        if (isShow) {
            RoomMessageViewBinding roomMessageViewBinding = this.mBinding;
            if (roomMessageViewBinding != null && (textView4 = roomMessageViewBinding.all) != null) {
                textView4.setVisibility(0);
            }
            RoomMessageViewBinding roomMessageViewBinding2 = this.mBinding;
            if (roomMessageViewBinding2 != null && (textView3 = roomMessageViewBinding2.chat) != null) {
                textView3.setVisibility(0);
                return;
            }
            return;
        }
        RoomMessageViewBinding roomMessageViewBinding3 = this.mBinding;
        if (roomMessageViewBinding3 != null && (textView2 = roomMessageViewBinding3.all) != null) {
            textView2.setVisibility(8);
        }
        RoomMessageViewBinding roomMessageViewBinding4 = this.mBinding;
        if (roomMessageViewBinding4 != null && (textView = roomMessageViewBinding4.chat) != null) {
            textView.setVisibility(8);
        }
    }

    public final boolean isLastPosition() {
        if (this.mLastVisiblePosition == getMAdapter().getData().size() - 1) {
            return true;
        }
        return false;
    }

    @Nullable
    public final RoomMessageViewBinding messageBinding() {
        return this.mBinding;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void newData(@NotNull List<RoomMessageMulti> data) {
        Collection<? extends RoomMessageMulti> collection;
        Integer msgTab;
        Intrinsics.checkNotNullParameter(data, "data");
        this.mAllMessageList.clear();
        this.mAllMessageList.addAll(data);
        if (this.mMessageTab == 1) {
            CopyOnWriteArrayList<RoomMessageMulti> copyOnWriteArrayList = this.mAllMessageList;
            collection = new ArrayList<>();
            for (Object obj : copyOnWriteArrayList) {
                GroupMessageNew data2 = ((RoomMessageMulti) obj).getData();
                if (data2 != null && (msgTab = data2.getMsgTab()) != null && msgTab.intValue() == 1) {
                    collection.add(obj);
                }
            }
        } else {
            collection = this.mAllMessageList;
        }
        this.mMessageList.clear();
        this.mMessageList.addAll(collection);
        getMAdapter().setList(collection);
        scrollToBottom$default(this, true, false, 2, null);
    }

    public final void refreshMessageStatus(@NotNull RoomMessage.GroupMessageSendRsp data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Iterator it = CollectionsKt.asReversedMutable(this.mAllMessageList).iterator();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            GroupMessageNew data2 = ((RoomMessageMulti) next).getData();
            if (Intrinsics.areEqual(data2 != null ? data2.getMsgId() : null, data.getMsgId())) {
                CopyOnWriteArrayList<RoomMessageMulti> copyOnWriteArrayList = this.mAllMessageList;
                GroupMessageNew data3 = copyOnWriteArrayList.get((copyOnWriteArrayList.size() - 1) - i11).getData();
                if (data3 != null) {
                    data3.setStatus(1);
                }
            }
            i11 = i12;
        }
        for (Object obj : CollectionsKt.asReversedMutable(this.mMessageList)) {
            int i13 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            GroupMessageNew data4 = ((RoomMessageMulti) obj).getData();
            if (Intrinsics.areEqual(data4 != null ? data4.getMsgId() : null, data.getMsgId())) {
                int size = (this.mMessageList.size() - 1) - i10;
                GroupMessageNew data5 = this.mMessageList.get(size).getData();
                if (data5 != null) {
                    data5.setStatus(1);
                    if (size < getMAdapter().getData().size()) {
                        ((RoomMessageMulti) getMAdapter().getData().get(size)).setData(data5);
                        getMAdapter().notifyItemChanged(size, RoomMessageAdapter.MESSAGE_STATUS);
                    }
                }
            }
            i10 = i13;
        }
    }

    public final void refreshTabView() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        if (this.mMessageTab == 0) {
            RoomMessageViewBinding roomMessageViewBinding = this.mBinding;
            if (roomMessageViewBinding != null && (textView4 = roomMessageViewBinding.all) != null) {
                textView4.setTextColor(androidx.core.content.a.getColor(getContext(), R.color.white));
            }
            RoomMessageViewBinding roomMessageViewBinding2 = this.mBinding;
            if (roomMessageViewBinding2 != null && (textView3 = roomMessageViewBinding2.chat) != null) {
                textView3.setTextColor(androidx.core.content.a.getColor(getContext(), R.color.configColor60White));
                return;
            }
            return;
        }
        RoomMessageViewBinding roomMessageViewBinding3 = this.mBinding;
        if (roomMessageViewBinding3 != null && (textView2 = roomMessageViewBinding3.all) != null) {
            textView2.setTextColor(androidx.core.content.a.getColor(getContext(), R.color.configColor60White));
        }
        RoomMessageViewBinding roomMessageViewBinding4 = this.mBinding;
        if (roomMessageViewBinding4 != null && (textView = roomMessageViewBinding4.chat) != null) {
            textView.setTextColor(androidx.core.content.a.getColor(getContext(), R.color.white));
        }
    }

    public final void scrollToBottom(boolean isRightNowScroll, boolean isLastPosition) {
        int size;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        if (isRightNowScroll) {
            if (this.isSmoothScrolling) {
                this.isSmoothScrolling = false;
                this.hasNewScroll = false;
                RoomMessageViewBinding roomMessageViewBinding = this.mBinding;
                if (roomMessageViewBinding != null && (recyclerView2 = roomMessageViewBinding.recyclerView) != null) {
                    recyclerView2.stopScroll();
                }
            }
            RoomMessageViewBinding roomMessageViewBinding2 = this.mBinding;
            if (roomMessageViewBinding2 != null && (recyclerView = roomMessageViewBinding2.recyclerView) != null) {
                recyclerView.scrollToPosition(getMAdapter().getData().size() - 1);
                return;
            }
            return;
        }
        if (isLastPosition && this.mRecyclerViewEvent == 1 && (size = getMAdapter().getData().size() - 1) > 0) {
            smoothScrollToPosition(size, 700.0f);
        }
    }

    public final void setMAllMessageList(@NotNull CopyOnWriteArrayList<RoomMessageMulti> copyOnWriteArrayList) {
        Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        this.mAllMessageList = copyOnWriteArrayList;
    }

    public final void setMBinding(@Nullable RoomMessageViewBinding roomMessageViewBinding) {
        this.mBinding = roomMessageViewBinding;
    }

    public final void setMExternalId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mExternalId = str;
    }

    public final void setMFirstVisiblePosition(int i10) {
        this.mFirstVisiblePosition = i10;
    }

    public final void setMLastVisiblePosition(int i10) {
        this.mLastVisiblePosition = i10;
    }

    public final void setMMessageList(@NotNull CopyOnWriteArrayList<RoomMessageMulti> copyOnWriteArrayList) {
        Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        this.mMessageList = copyOnWriteArrayList;
    }

    public final void setMMessageProcessor(@NotNull MessageProcessor<RoomMessageMulti> messageProcessor) {
        Intrinsics.checkNotNullParameter(messageProcessor, "<set-?>");
        this.mMessageProcessor = messageProcessor;
    }

    public final void setMessageItemListener(@NotNull RoomMessageItemListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getMAdapter().setMListener(listener);
    }

    public final void smoothScrollToPosition(int position, float speed) {
        Object obj;
        RecyclerView recyclerView;
        RoomMessageViewBinding roomMessageViewBinding = this.mBinding;
        LinearLayoutManager linearLayoutManager = null;
        if (roomMessageViewBinding != null && (recyclerView = roomMessageViewBinding.recyclerView) != null) {
            obj = recyclerView.getLayoutManager();
        } else {
            obj = null;
        }
        if (obj instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) obj;
        }
        if (linearLayoutManager != null) {
            if (this.isSmoothScrolling) {
                this.hasNewScroll = true;
                return;
            }
            if (this.mLinearSmoothScroller == null) {
                this.mLinearSmoothScroller = new RoomMessageView$smoothScrollToPosition$1$1(speed, this, getContext());
            }
            LinearSmoothScroller linearSmoothScroller = this.mLinearSmoothScroller;
            if (linearSmoothScroller != null) {
                linearSmoothScroller.setTargetPosition(position);
            }
            this.isSmoothScrolling = true;
            linearLayoutManager.startSmoothScroll(this.mLinearSmoothScroller);
        }
    }

    public final void stopScroll() {
        RecyclerView recyclerView;
        this.isSmoothScrolling = false;
        this.hasNewScroll = false;
        RoomMessageViewBinding roomMessageViewBinding = this.mBinding;
        if (roomMessageViewBinding != null && (recyclerView = roomMessageViewBinding.recyclerView) != null) {
            recyclerView.stopScroll();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomMessageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        User user;
        String externalId;
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.hilo_message.message.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                RoomMessageAdapter mAdapter_delegate$lambda$0;
                mAdapter_delegate$lambda$0 = RoomMessageView.mAdapter_delegate$lambda$0();
                return mAdapter_delegate$lambda$0;
            }
        });
        this.mFirstVisiblePosition = -1;
        this.mLastVisiblePosition = -1;
        AppService service = AppController.INSTANCE.getService();
        this.mExternalId = (service == null || (user = service.getUser()) == null || (externalId = user.getExternalId()) == null) ? "" : externalId;
        this.mAllMessageList = new CopyOnWriteArrayList<>();
        this.mMessageList = new CopyOnWriteArrayList<>();
        this.mRecyclerViewEvent = 1;
        this.mMessageProcessor = new MessageProcessor<>(new Function1() { // from class: com.qiahao.hilo_message.message.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit mMessageProcessor$lambda$1;
                mMessageProcessor$lambda$1 = RoomMessageView.mMessageProcessor$lambda$1(RoomMessageView.this, (List) obj);
                return mMessageProcessor$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.hilo_message.message.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean mMessageProcessor$lambda$3;
                mMessageProcessor$lambda$3 = RoomMessageView.mMessageProcessor$lambda$3(RoomMessageView.this, (RoomMessageMulti) obj);
                return Boolean.valueOf(mMessageProcessor$lambda$3);
            }
        });
        initView();
    }

    public final void refreshMessageStatus(@Nullable RoomMessageMulti data) {
        if (data == null) {
            return;
        }
        int i10 = 0;
        for (Object obj : CollectionsKt.asReversedMutable(this.mAllMessageList)) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            GroupMessageNew data2 = ((RoomMessageMulti) obj).getData();
            String msgId = data2 != null ? data2.getMsgId() : null;
            GroupMessageNew data3 = data.getData();
            if (Intrinsics.areEqual(msgId, data3 != null ? data3.getMsgId() : null)) {
                int size = (this.mAllMessageList.size() - 1) - i10;
                GroupMessageNew data4 = this.mAllMessageList.get(size).getData();
                if (data4 != null) {
                    data4.setStatus(1);
                } else {
                    data4 = null;
                }
                this.mAllMessageList.get(size).setData(data4);
                int i12 = 0;
                for (Object obj2 : CollectionsKt.asReversedMutable(this.mMessageList)) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    GroupMessageNew data5 = ((RoomMessageMulti) obj2).getData();
                    String msgId2 = data5 != null ? data5.getMsgId() : null;
                    GroupMessageNew data6 = data.getData();
                    if (Intrinsics.areEqual(msgId2, data6 != null ? data6.getMsgId() : null)) {
                        int size2 = (this.mMessageList.size() - 1) - i12;
                        this.mMessageList.set(size2, data);
                        getMAdapter().getData().set(size2, data);
                        getMAdapter().notifyItemChanged(size2, RoomMessageAdapter.MESSAGE_STATUS);
                    }
                    i12 = i13;
                }
            }
            i10 = i11;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomMessageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        User user;
        String externalId;
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.hilo_message.message.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                RoomMessageAdapter mAdapter_delegate$lambda$0;
                mAdapter_delegate$lambda$0 = RoomMessageView.mAdapter_delegate$lambda$0();
                return mAdapter_delegate$lambda$0;
            }
        });
        this.mFirstVisiblePosition = -1;
        this.mLastVisiblePosition = -1;
        AppService service = AppController.INSTANCE.getService();
        this.mExternalId = (service == null || (user = service.getUser()) == null || (externalId = user.getExternalId()) == null) ? "" : externalId;
        this.mAllMessageList = new CopyOnWriteArrayList<>();
        this.mMessageList = new CopyOnWriteArrayList<>();
        this.mRecyclerViewEvent = 1;
        this.mMessageProcessor = new MessageProcessor<>(new Function1() { // from class: com.qiahao.hilo_message.message.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit mMessageProcessor$lambda$1;
                mMessageProcessor$lambda$1 = RoomMessageView.mMessageProcessor$lambda$1(RoomMessageView.this, (List) obj);
                return mMessageProcessor$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.hilo_message.message.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean mMessageProcessor$lambda$3;
                mMessageProcessor$lambda$3 = RoomMessageView.mMessageProcessor$lambda$3(RoomMessageView.this, (RoomMessageMulti) obj);
                return Boolean.valueOf(mMessageProcessor$lambda$3);
            }
        });
        initView();
    }

    public final void addData(@NotNull RoomMessageMulti data, boolean scrollToBottom) {
        Object obj;
        GroupMessageNew data2;
        Integer msgTab;
        Intrinsics.checkNotNullParameter(data, "data");
        boolean isLastPosition = isLastPosition();
        checkDeleteMessage();
        CopyOnWriteArrayList<RoomMessageMulti> copyOnWriteArrayList = this.mAllMessageList;
        ListIterator<RoomMessageMulti> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            RoomMessageMulti previous = listIterator.previous();
            RoomMessageMulti roomMessageMulti = previous;
            GroupMessageNew data3 = roomMessageMulti.getData();
            String msgId = data3 != null ? data3.getMsgId() : null;
            GroupMessageNew data4 = data.getData();
            if (Intrinsics.areEqual(msgId, data4 != null ? data4.getMsgId() : null)) {
                GroupMessageNew data5 = roomMessageMulti.getData();
                if (Intrinsics.areEqual(data5 != null ? data5.getFromAccount() : null, this.mExternalId)) {
                    obj = previous;
                    break;
                }
            }
        }
        if (obj == null) {
            this.mAllMessageList.add(data);
        }
        if ((1 != this.mMessageTab || (data2 = data.getData()) == null || (msgTab = data2.getMsgTab()) == null || 1 != msgTab.intValue()) && this.mMessageTab != 0) {
            return;
        }
        this.mMessageList.add(data);
        getMAdapter().addData((RoomMessageAdapter) data);
        scrollToBottom(scrollToBottom, isLastPosition);
    }

    public final void refreshMessageStatus(@Nullable String msgId, int messageStatus) {
        if (TextUtils.isEmpty(msgId)) {
            return;
        }
        Iterator it = CollectionsKt.asReversedMutable(this.mAllMessageList).iterator();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            GroupMessageNew data = ((RoomMessageMulti) next).getData();
            if (Intrinsics.areEqual(data != null ? data.getMsgId() : null, msgId)) {
                GroupMessageNew data2 = this.mAllMessageList.get((this.mAllMessageList.size() - 1) - i11).getData();
                if (data2 != null) {
                    data2.setStatus(Integer.valueOf(messageStatus));
                }
            }
            i11 = i12;
        }
        for (Object obj : CollectionsKt.asReversedMutable(this.mMessageList)) {
            int i13 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            GroupMessageNew data3 = ((RoomMessageMulti) obj).getData();
            if (Intrinsics.areEqual(data3 != null ? data3.getMsgId() : null, msgId)) {
                int size = (this.mMessageList.size() - 1) - i10;
                GroupMessageNew data4 = this.mMessageList.get(size).getData();
                if (data4 != null) {
                    data4.setStatus(Integer.valueOf(messageStatus));
                }
                if (size < getMAdapter().getData().size()) {
                    GroupMessageNew data5 = ((RoomMessageMulti) getMAdapter().getData().get(size)).getData();
                    if (data5 != null) {
                        data5.setStatus(Integer.valueOf(messageStatus));
                    }
                    getMAdapter().notifyItemChanged(size, RoomMessageAdapter.MESSAGE_STATUS);
                }
            }
            i10 = i13;
        }
    }
}
