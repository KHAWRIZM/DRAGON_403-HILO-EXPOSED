package com.qiahao.nextvideo.room.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialogFragment;
import com.qiahao.base_common.interfaceing.SendGiftListener;
import com.qiahao.base_common.model.GiftData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserObjectEvent;
import com.qiahao.nextvideo.data.UserObjectEventType;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.databinding.DialogVideoGiftBinding;
import com.qiahao.nextvideo.databinding.PopWindowGiftNumberRecyclerBinding;
import com.qiahao.nextvideo.room.adapter.PopUpGiftNumberAdapter;
import com.qiahao.nextvideo.room.adapter.VideoGiftAdapter;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.room.view.SetGroupSendGiftListener;
import com.qiahao.nextvideo.room.viewmodel.RoomGiftViewModel;
import com.qiahao.nextvideo.ui.reusable.views.recyclerview.PagerGridLayoutManager;
import com.qiahao.nextvideo.ui.reusable.views.recyclerview.PagerGridSnapHelper;
import com.tencent.qcloud.tuicore.util.PopWindowUtil;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020/H\u0014J\b\u00100\u001a\u00020/H\u0014J\b\u00101\u001a\u00020-H\u0016J\b\u00102\u001a\u00020-H\u0002J\b\u00103\u001a\u00020-H\u0002J\u0016\u00104\u001a\u00020-2\f\u00105\u001a\b\u0012\u0004\u0012\u00020-06H\u0002J\u000e\u00107\u001a\u00020-2\u0006\u00108\u001a\u00020/J\b\u00109\u001a\u00020-H\u0002J\u000e\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u00020<J\u000e\u0010=\u001a\u00020\u00002\u0006\u00105\u001a\u00020\"R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001` X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010'\u001a\u00020(8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0012\u001a\u0004\b)\u0010*¨\u0006>"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/VideoGiftDialogFragment;", "Lcom/qiahao/base_common/common/BaseBindingDialogFragment;", "Lcom/qiahao/nextvideo/databinding/DialogVideoGiftBinding;", "extraId", "", "userName", "isAllMic", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getExtraId", "()Ljava/lang/String;", "getUserName", "mPopUpGiftNumberAdapter", "Lcom/qiahao/nextvideo/room/adapter/PopUpGiftNumberAdapter;", "getMPopUpGiftNumberAdapter", "()Lcom/qiahao/nextvideo/room/adapter/PopUpGiftNumberAdapter;", "mPopUpGiftNumberAdapter$delegate", "Lkotlin/Lazy;", "gridLayoutManager", "Lcom/qiahao/nextvideo/ui/reusable/views/recyclerview/PagerGridLayoutManager;", "getGridLayoutManager", "()Lcom/qiahao/nextvideo/ui/reusable/views/recyclerview/PagerGridLayoutManager;", "gridLayoutManager$delegate", "mAdapter", "Lcom/qiahao/nextvideo/room/adapter/VideoGiftAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/room/adapter/VideoGiftAdapter;", "mAdapter$delegate", "giftList", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/GiftData;", "Lkotlin/collections/ArrayList;", "sendGiftListener", "Lcom/qiahao/base_common/interfaceing/SendGiftListener;", "getSendGiftListener", "()Lcom/qiahao/base_common/interfaceing/SendGiftListener;", "setSendGiftListener", "(Lcom/qiahao/base_common/interfaceing/SendGiftListener;)V", "viewModel", "Lcom/qiahao/nextvideo/room/viewmodel/RoomGiftViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/room/viewmodel/RoomGiftViewModel;", "viewModel$delegate", "onStart", "", "getLayoutResId", "", "getGravity", "onInitialize", "initRecycleView", "clickGift", "showGiftTextDialog", "listener", "Lkotlin/Function0;", "refreshData", "position", "initData", "showGiftNumberPopWindow", "view", "Landroid/view/View;", "setListener", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVideoGiftDialogFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VideoGiftDialogFragment.kt\ncom/qiahao/nextvideo/room/dialog/VideoGiftDialogFragment\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,299:1\n61#2,9:300\n61#2,9:309\n61#2,9:318\n1#3:327\n*S KotlinDebug\n*F\n+ 1 VideoGiftDialogFragment.kt\ncom/qiahao/nextvideo/room/dialog/VideoGiftDialogFragment\n*L\n102#1:300,9\n106#1:309,9\n110#1:318,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoGiftDialogFragment extends BaseBindingDialogFragment<DialogVideoGiftBinding> {

    @NotNull
    private final String extraId;

    @Nullable
    private ArrayList<GiftData> giftList;

    /* renamed from: gridLayoutManager$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy gridLayoutManager;
    private final boolean isAllMic;

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;

    /* renamed from: mPopUpGiftNumberAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mPopUpGiftNumberAdapter;

    @Nullable
    private SendGiftListener sendGiftListener;

    @NotNull
    private final String userName;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    public VideoGiftDialogFragment() {
        this(null, null, false, 7, null);
    }

    public static final /* synthetic */ DialogVideoGiftBinding access$getBinding(VideoGiftDialogFragment videoGiftDialogFragment) {
        return (DialogVideoGiftBinding) videoGiftDialogFragment.getBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clickGift() {
        Double pinkDiamondNum;
        Double pinkDiamondNum2;
        final GiftData selectedGift = getViewModel().getSelectedGift();
        if (selectedGift != null) {
            double d = 0.0d;
            if (getViewModel().getMIsAllMic()) {
                User user = UserStore.INSTANCE.getShared().getUser();
                if (user != null && (pinkDiamondNum2 = user.getPinkDiamondNum()) != null) {
                    d = pinkDiamondNum2.doubleValue();
                }
                if (d < selectedGift.getDiamondNum() * getViewModel().getGiftNumber() * getViewModel().getExtraIdList().size()) {
                    SendGiftListener sendGiftListener = this.sendGiftListener;
                    if (sendGiftListener != null) {
                        sendGiftListener.showRechargeView();
                    }
                    dismiss();
                    return;
                }
            } else {
                User user2 = UserStore.INSTANCE.getShared().getUser();
                if (user2 != null && (pinkDiamondNum = user2.getPinkDiamondNum()) != null) {
                    d = pinkDiamondNum.doubleValue();
                }
                if (d < selectedGift.getDiamondNum() * getViewModel().getGiftNumber()) {
                    SendGiftListener sendGiftListener2 = this.sendGiftListener;
                    if (sendGiftListener2 != null) {
                        sendGiftListener2.showRechargeView();
                    }
                    dismiss();
                    return;
                }
            }
            showGiftTextDialog(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.q5
                public final Object invoke() {
                    Unit clickGift$lambda$11$lambda$10;
                    clickGift$lambda$11$lambda$10 = VideoGiftDialogFragment.clickGift$lambda$11$lambda$10(VideoGiftDialogFragment.this, selectedGift);
                    return clickGift$lambda$11$lambda$10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clickGift$lambda$11$lambda$10(VideoGiftDialogFragment videoGiftDialogFragment, GiftData giftData) {
        SendGiftListener sendGiftListener = videoGiftDialogFragment.sendGiftListener;
        if (sendGiftListener != null) {
            sendGiftListener.giftsChoose(giftData, videoGiftDialogFragment.getViewModel().getGiftNumber(), videoGiftDialogFragment.getViewModel().getExtraIdList(), videoGiftDialogFragment.getViewModel().getMIsAllMic());
        }
        return Unit.INSTANCE;
    }

    private final PagerGridLayoutManager getGridLayoutManager() {
        return (PagerGridLayoutManager) this.gridLayoutManager.getValue();
    }

    private final VideoGiftAdapter getMAdapter() {
        return (VideoGiftAdapter) this.mAdapter.getValue();
    }

    private final PopUpGiftNumberAdapter getMPopUpGiftNumberAdapter() {
        return (PopUpGiftNumberAdapter) this.mPopUpGiftNumberAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagerGridLayoutManager gridLayoutManager_delegate$lambda$1() {
        return new PagerGridLayoutManager(2, 4, 1);
    }

    private final void initData() {
        Integer num;
        Double pinkDiamondNum;
        getViewModel().setMIsAllMic(this.isAllMic);
        if (getViewModel().getMIsAllMic()) {
            getViewModel().setSendAllMicMember(MeetingRoomManager.INSTANCE.getMicQueueMemberList());
        } else if (!TextUtils.isEmpty(this.extraId) && !TextUtils.isEmpty(this.userName)) {
            getViewModel().getExtraIdList().clear();
            getViewModel().getExtraIdList().add(this.extraId);
        }
        TextView textView = ((DialogVideoGiftBinding) getBinding()).diamondText;
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        if (user != null && (pinkDiamondNum = user.getPinkDiamondNum()) != null) {
            num = Integer.valueOf((int) pinkDiamondNum.doubleValue());
        } else {
            num = null;
        }
        textView.setText(String.valueOf(num));
        nd.c subscribe = companion.getShared().getUserObjectRelay().observeOn(RxUtilsKt.getMainThread()).subscribeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.room.dialog.VideoGiftDialogFragment$initData$1
            public final void accept(UserObjectEvent userObjectEvent) {
                Double pinkDiamondNum2;
                if (userObjectEvent != null) {
                    VideoGiftDialogFragment videoGiftDialogFragment = VideoGiftDialogFragment.this;
                    if (userObjectEvent.getType() == UserObjectEventType.REFRESH_MONEY) {
                        TextView textView2 = VideoGiftDialogFragment.access$getBinding(videoGiftDialogFragment).diamondText;
                        User user2 = UserStore.INSTANCE.getShared().getUser();
                        textView2.setText(String.valueOf((user2 == null || (pinkDiamondNum2 = user2.getPinkDiamondNum()) == null) ? null : Integer.valueOf((int) pinkDiamondNum2.doubleValue())));
                    }
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, getViewModel().getMCompositeDisposable());
        RxUtilsKt.observeOnMainThread$default(GroupService.INSTANCE.getInstance().giftListOfType(31), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.o5
            public final Object invoke(Object obj) {
                Unit initData$lambda$17;
                initData$lambda$17 = VideoGiftDialogFragment.initData$lambda$17(VideoGiftDialogFragment.this, (ApiResponse) obj);
                return initData$lambda$17;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.p5
            public final Object invoke(Object obj) {
                Unit initData$lambda$19;
                initData$lambda$19 = VideoGiftDialogFragment.initData$lambda$19(VideoGiftDialogFragment.this, (Throwable) obj);
                return initData$lambda$19;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$17(VideoGiftDialogFragment videoGiftDialogFragment, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        videoGiftDialogFragment.giftList = (ArrayList) apiResponse.getData();
        videoGiftDialogFragment.getMAdapter().setList(videoGiftDialogFragment.giftList);
        ArrayList<GiftData> arrayList = videoGiftDialogFragment.giftList;
        if (arrayList != null && !arrayList.isEmpty()) {
            ((DialogVideoGiftBinding) videoGiftDialogFragment.getBinding()).statusView.showContent();
        } else {
            ((DialogVideoGiftBinding) videoGiftDialogFragment.getBinding()).statusView.showEmpty();
            TextView textView = (TextView) ((DialogVideoGiftBinding) videoGiftDialogFragment.getBinding()).statusView.findViewById(2131362075);
            Context context = videoGiftDialogFragment.getContext();
            if (context != null && textView != null) {
                textView.setTextColor(androidx.core.content.a.getColor(context, 2131101214));
            }
        }
        videoGiftDialogFragment.refreshData(0);
        ((DialogVideoGiftBinding) videoGiftDialogFragment.getBinding()).pageIndicator.setPageCount((int) Math.ceil(videoGiftDialogFragment.getMAdapter().getItemCount() / 8));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$19(VideoGiftDialogFragment videoGiftDialogFragment, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        ((DialogVideoGiftBinding) videoGiftDialogFragment.getBinding()).statusView.showEmpty();
        TextView textView = (TextView) ((DialogVideoGiftBinding) videoGiftDialogFragment.getBinding()).statusView.findViewById(2131362075);
        Context context = videoGiftDialogFragment.getContext();
        if (context != null && textView != null) {
            textView.setTextColor(androidx.core.content.a.getColor(context, 2131101214));
        }
        return Unit.INSTANCE;
    }

    private final void initRecycleView() {
        RecyclerView recyclerView = ((DialogVideoGiftBinding) getBinding()).recyclerView;
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(0L);
        }
        recyclerView.setLayoutManager(getGridLayoutManager());
        recyclerView.setLayoutParams(new RelativeLayout.LayoutParams(-1, UiKtxKt.toPX(RoomEvent.ROOM_OPEN_USE_INFO)));
        new PagerGridSnapHelper().attachToRecyclerView(recyclerView);
        recyclerView.setLayoutDirection(3);
        recyclerView.setAdapter(getMAdapter());
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.qiahao.nextvideo.room.dialog.VideoGiftDialogFragment$initRecycleView$1$1
            private float scrollPosition;

            public final float getScrollPosition() {
                return this.scrollPosition;
            }

            public void onScrolled(RecyclerView recyclerView2, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                super.onScrolled(recyclerView2, dx, dy);
                this.scrollPosition += dx;
                int measuredWidth = recyclerView2.getMeasuredWidth();
                float f = this.scrollPosition;
                float f2 = measuredWidth;
                VideoGiftDialogFragment.access$getBinding(VideoGiftDialogFragment.this).pageIndicator.onPageScrolled((int) (f / f2), (f % f2) / f2);
            }

            public final void setScrollPosition(float f) {
                this.scrollPosition = f;
            }
        });
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.dialog.m5
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                VideoGiftDialogFragment.initRecycleView$lambda$9(VideoGiftDialogFragment.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecycleView$lambda$9(VideoGiftDialogFragment videoGiftDialogFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        videoGiftDialogFragment.refreshData(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoGiftAdapter mAdapter_delegate$lambda$2() {
        return new VideoGiftAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PopUpGiftNumberAdapter mPopUpGiftNumberAdapter_delegate$lambda$0() {
        return new PopUpGiftNumberAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGiftNumberPopWindow$lambda$20(VideoGiftDialogFragment videoGiftDialogFragment, PopupWindow popupWindow, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        videoGiftDialogFragment.getViewModel().setGiftNumber(((Number) videoGiftDialogFragment.getMPopUpGiftNumberAdapter().getData().get(i)).intValue());
        ((DialogVideoGiftBinding) videoGiftDialogFragment.getBinding()).sendGiftLinearLayout.getBinding().giftNumber.setText(String.valueOf(videoGiftDialogFragment.getViewModel().getGiftNumber()));
        popupWindow.dismiss();
    }

    private final void showGiftTextDialog(final Function0<Unit> listener) {
        boolean z;
        GiftData selectedGift = getViewModel().getSelectedGift();
        if (selectedGift != null) {
            z = Intrinsics.areEqual(selectedGift.getHasGiftText(), Boolean.TRUE);
        } else {
            z = false;
        }
        if (z) {
            Context context = getContext();
            if (context != null) {
                GiftTextDialog giftTextDialog = new GiftTextDialog(context);
                giftTextDialog.setListener(new Function1() { // from class: com.qiahao.nextvideo.room.dialog.h5
                    public final Object invoke(Object obj) {
                        Unit showGiftTextDialog$lambda$14$lambda$13$lambda$12;
                        showGiftTextDialog$lambda$14$lambda$13$lambda$12 = VideoGiftDialogFragment.showGiftTextDialog$lambda$14$lambda$13$lambda$12(VideoGiftDialogFragment.this, listener, (String) obj);
                        return showGiftTextDialog$lambda$14$lambda$13$lambda$12;
                    }
                });
                giftTextDialog.show();
                return;
            }
            return;
        }
        listener.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showGiftTextDialog$lambda$14$lambda$13$lambda$12(VideoGiftDialogFragment videoGiftDialogFragment, Function0 function0, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        GiftData selectedGift = videoGiftDialogFragment.getViewModel().getSelectedGift();
        if (selectedGift != null) {
            selectedGift.setGiftText(str);
        }
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomGiftViewModel viewModel_delegate$lambda$3(VideoGiftDialogFragment videoGiftDialogFragment) {
        return new ViewModelProvider(videoGiftDialogFragment).get(RoomGiftViewModel.class);
    }

    @NotNull
    public final String getExtraId() {
        return this.extraId;
    }

    protected int getGravity() {
        return 80;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_video_gift;
    }

    @Nullable
    public final SendGiftListener getSendGiftListener() {
        return this.sendGiftListener;
    }

    @NotNull
    public final String getUserName() {
        return this.userName;
    }

    @NotNull
    public final RoomGiftViewModel getViewModel() {
        return (RoomGiftViewModel) this.viewModel.getValue();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseDialogFragment*/.onInitialize();
        initRecycleView();
        initData();
        ((DialogVideoGiftBinding) getBinding()).sendGiftLinearLayout.setListener(new SetGroupSendGiftListener() { // from class: com.qiahao.nextvideo.room.dialog.VideoGiftDialogFragment$onInitialize$1
            @Override // com.qiahao.nextvideo.room.view.SetGroupSendGiftListener
            public void selectNumber(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                VideoGiftDialogFragment.this.showGiftNumberPopWindow(view);
            }

            @Override // com.qiahao.nextvideo.room.view.SetGroupSendGiftListener
            public void sendGift() {
                VideoGiftDialogFragment.this.clickGift();
            }
        });
        final TextView textView = ((DialogVideoGiftBinding) getBinding()).diamondText;
        final long j = 800;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.VideoGiftDialogFragment$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    SendGiftListener sendGiftListener = this.getSendGiftListener();
                    if (sendGiftListener != null) {
                        sendGiftListener.showRechargeView();
                    }
                    this.dismiss();
                }
            }
        });
        final TextView textView2 = ((DialogVideoGiftBinding) getBinding()).rechargeText;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.VideoGiftDialogFragment$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    SendGiftListener sendGiftListener = this.getSendGiftListener();
                    if (sendGiftListener != null) {
                        sendGiftListener.showRechargeView();
                    }
                    this.dismiss();
                }
            }
        });
        final ImageView imageView = ((DialogVideoGiftBinding) getBinding()).rechargeIcon;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.VideoGiftDialogFragment$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    SendGiftListener sendGiftListener = this.getSendGiftListener();
                    if (sendGiftListener != null) {
                        sendGiftListener.showRechargeView();
                    }
                    this.dismiss();
                }
            }
        });
    }

    public void onStart() {
        Window window;
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.0f;
            window.setAttributes(attributes);
        }
    }

    public final void refreshData(int position) {
        GiftData giftData;
        if (getMAdapter().getData().size() > position && position != -1) {
            getMAdapter().setSelectPosition(position);
            getMAdapter().notifyDataSetChanged();
            getMAdapter().setSelectPosition(position);
            ArrayList<GiftData> arrayList = this.giftList;
            if (arrayList != null && (giftData = arrayList.get(position)) != null) {
                getViewModel().setSelectedGift(giftData);
            }
        }
    }

    @NotNull
    public final VideoGiftDialogFragment setListener(@NotNull SendGiftListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.sendGiftListener = listener;
        return this;
    }

    public final void setSendGiftListener(@Nullable SendGiftListener sendGiftListener) {
        this.sendGiftListener = sendGiftListener;
    }

    public final void showGiftNumberPopWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(7);
        arrayList.add(17);
        arrayList.add(77);
        arrayList.add(111);
        arrayList.add(555);
        arrayList.add(777);
        PopWindowGiftNumberRecyclerBinding popWindowGiftNumberRecyclerBinding = (PopWindowGiftNumberRecyclerBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.pop_window_gift_number_recycler, (ViewGroup) null, false);
        popWindowGiftNumberRecyclerBinding.recyclerView.setAdapter(getMPopUpGiftNumberAdapter());
        final PopupWindow popupWindowAndShow = PopWindowUtil.popupWindowAndShow(popWindowGiftNumberRecyclerBinding.getRoot(), view, UiKtxKt.getDp(84), UiKtxKt.getDp(207));
        getMPopUpGiftNumberAdapter().setList(arrayList);
        getMPopUpGiftNumberAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.dialog.n5
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                VideoGiftDialogFragment.showGiftNumberPopWindow$lambda$20(VideoGiftDialogFragment.this, popupWindowAndShow, baseQuickAdapter, view2, i);
            }
        });
    }

    public /* synthetic */ VideoGiftDialogFragment(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z);
    }

    public VideoGiftDialogFragment(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "extraId");
        Intrinsics.checkNotNullParameter(str2, "userName");
        this.extraId = str;
        this.userName = str2;
        this.isAllMic = z;
        this.mPopUpGiftNumberAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.i5
            public final Object invoke() {
                PopUpGiftNumberAdapter mPopUpGiftNumberAdapter_delegate$lambda$0;
                mPopUpGiftNumberAdapter_delegate$lambda$0 = VideoGiftDialogFragment.mPopUpGiftNumberAdapter_delegate$lambda$0();
                return mPopUpGiftNumberAdapter_delegate$lambda$0;
            }
        });
        this.gridLayoutManager = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.j5
            public final Object invoke() {
                PagerGridLayoutManager gridLayoutManager_delegate$lambda$1;
                gridLayoutManager_delegate$lambda$1 = VideoGiftDialogFragment.gridLayoutManager_delegate$lambda$1();
                return gridLayoutManager_delegate$lambda$1;
            }
        });
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.k5
            public final Object invoke() {
                VideoGiftAdapter mAdapter_delegate$lambda$2;
                mAdapter_delegate$lambda$2 = VideoGiftDialogFragment.mAdapter_delegate$lambda$2();
                return mAdapter_delegate$lambda$2;
            }
        });
        this.viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.l5
            public final Object invoke() {
                RoomGiftViewModel viewModel_delegate$lambda$3;
                viewModel_delegate$lambda$3 = VideoGiftDialogFragment.viewModel_delegate$lambda$3(VideoGiftDialogFragment.this);
                return viewModel_delegate$lambda$3;
            }
        });
    }
}
