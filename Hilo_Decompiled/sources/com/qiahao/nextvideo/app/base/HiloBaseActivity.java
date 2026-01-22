package com.qiahao.nextvideo.app.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import cf.m;
import com.oudi.utils.LifecycleTask;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.eventBus.DelayEvent;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.model.eventBus.GlobalEvent;
import com.qiahao.base_common.model.im.StrangeChange;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.MainActivity;
import com.qiahao.nextvideo.data.game.CreateSudData;
import com.qiahao.nextvideo.data.model.GroupBroadCastBean;
import com.qiahao.nextvideo.data.model.MatchingFloatData;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.data.service.match.MatchingProvide;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.room.activity.RoomActivity;
import com.qiahao.nextvideo.room.dialog.JoinLockRoomBottomDialog;
import com.qiahao.nextvideo.room.dialog.RoomBroadCastDialog;
import com.qiahao.nextvideo.room.help.GameJum;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.p٠٠٠float.RoomFloatView;
import com.qiahao.nextvideo.ui.home.chat.activity.ChatActivity;
import com.qiahao.nextvideo.ui.home.chat.activity.ChatStrangeActivity;
import com.qiahao.nextvideo.ui.home.chat.activity.StrangeListActivity;
import com.qiahao.nextvideo.ui.home.chat.dialog.StrangeEndDialog;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.Window;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.host.RemoveRootControllerHost;
import com.qiahao.nextvideo.ui.reusable.views.GfitBannerButtonListener;
import com.qiahao.nextvideo.ui.reusable.views.GiftBannerButtonView;
import com.qiahao.nextvideo.ui.reusable.views.GlobalTipSvga2;
import com.qiahao.nextvideo.ui.reusable.views.GlobalTipSvgaListener;
import com.qiahao.nextvideo.ui.reusable.views.MatchingFloatView;
import com.qiahao.nextvideo.ui.reusable.views.ProgressDialogWrapper;
import com.qiahao.nextvideo.ui.upload.UploadDialog;
import com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity;
import com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity;
import com.qiahao.nextvideo.ui.vip.DailyRewardDialog;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import com.taobao.accs.common.Constants;
import com.taobao.accs.messenger.MessengerService;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.sud.gip.core.view.round.RoundedDrawable;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0003J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\u000eH\u0016¢\u0006\u0004\b \u0010\u0003J)\u0010%\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020!2\b\b\u0003\u0010#\u001a\u00020\b2\b\b\u0003\u0010$\u001a\u00020\b¢\u0006\u0004\b%\u0010&J4\u0010%\u001a\u00020\u000e\"\u0006\b\u0000\u0010'\u0018\u00012\u0006\u0010)\u001a\u00020(2\b\b\u0003\u0010#\u001a\u00020\b2\b\b\u0003\u0010$\u001a\u00020\bH\u0086\b¢\u0006\u0004\b%\u0010*J1\u0010/\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\b2\b\b\u0002\u0010,\u001a\u00020\u00042\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010-¢\u0006\u0004\b/\u00100J3\u0010/\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u0010,\u001a\u00020\u00042\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010-¢\u0006\u0004\b/\u00103J)\u00104\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u00042\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010-¢\u0006\u0004\b4\u00105J%\u0010:\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u00042\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\b¢\u0006\u0004\b:\u0010;J\u001d\u0010>\u001a\u00020\u000e2\u0006\u0010<\u001a\u0002012\u0006\u0010=\u001a\u00020\b¢\u0006\u0004\b>\u0010?R\u0018\u0010A\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\"\u0010E\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010D\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010HR\"\u0010I\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010D\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010HR$\u0010M\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001b\u0010X\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR$\u0010Y\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\r\"\u0004\b\\\u0010]R\u001b\u0010b\u001a\u00020^8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010U\u001a\u0004\b`\u0010aR\u001b\u0010g\u001a\u00020c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010U\u001a\u0004\be\u0010fR\u001b\u0010l\u001a\u00020h8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bi\u0010U\u001a\u0004\bj\u0010kR\u001b\u0010q\u001a\u00020m8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bn\u0010U\u001a\u0004\bo\u0010pR*\u0010s\u001a\u00020\u00042\u0006\u0010r\u001a\u00020\u00048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010D\u001a\u0004\bt\u0010\u0006\"\u0004\bu\u0010HR\u001b\u0010z\u001a\u00020v8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bw\u0010U\u001a\u0004\bx\u0010yR&\u0010|\u001a\u0004\u0018\u00010{8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0017\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0082\u00018F¢\u0006\b\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001¨\u0006\u0086\u0001"}, d2 = {"Lcom/qiahao/nextvideo/app/base/HiloBaseActivity;", "Lcom/qiahao/base_common/common/BaseActivity;", "<init>", "()V", "", "canShowGroupBroadCastDialog", "()Z", "checkGiftTip", "", "getLayoutResId", "()I", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/Window;", "getControllerWindowNotNull", "()Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/Window;", "", "onInitialize", "onResume", "Lcom/qiahao/nextvideo/data/model/MatchingFloatData;", "event", "onVideoEvent", "(Lcom/qiahao/nextvideo/data/model/MatchingFloatData;)V", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "onStrangeChatEvent", "(Lcom/qiahao/base_common/model/eventBus/EventBusKey;)V", "Lcom/qiahao/base_common/model/eventBus/GlobalEvent;", "onGlobalEvent", "(Lcom/qiahao/base_common/model/eventBus/GlobalEvent;)V", "Lcom/qiahao/base_common/model/eventBus/DelayEvent;", "onDelayEvent", "(Lcom/qiahao/base_common/model/eventBus/DelayEvent;)V", "onPause", "onDestroy", "onBackPressed", "Landroid/content/Intent;", MessengerService.INTENT, "enterAnim", "exitAnim", "startActivity", "(Landroid/content/Intent;II)V", "T", "Landroid/content/Context;", "context", "(Landroid/content/Context;II)V", "messageRes", "animated", "Lkotlin/Function0;", "completion", "showProgressDialog", "(IZLkotlin/jvm/functions/Function0;)V", "", Constants.SHARED_MESSAGE_ID_FILE, "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "dismissProgressDialog", "(ZLkotlin/jvm/functions/Function0;)V", "isVip", "", ExchangeDetailActivity.TYPE_DIAMOND, "matchCardNum", "showDailyGetDiamond", "(ZJI)V", "groupId", "sceneType", "openRoom", "(Ljava/lang/String;I)V", "Lcom/qiahao/nextvideo/ui/reusable/views/ProgressDialogWrapper;", "progressDialog", "Lcom/qiahao/nextvideo/ui/reusable/views/ProgressDialogWrapper;", "disableBackButton", "Z", "showGiftTip", "getShowGiftTip", "setShowGiftTip", "(Z)V", "mSetBottom", "getMSetBottom", "setMSetBottom", "Lcom/qiahao/base_common/model/im/StrangeChange;", "mStrangeChange", "Lcom/qiahao/base_common/model/im/StrangeChange;", "getMStrangeChange", "()Lcom/qiahao/base_common/model/im/StrangeChange;", "setMStrangeChange", "(Lcom/qiahao/base_common/model/im/StrangeChange;)V", "Lcom/qiahao/nextvideo/ui/upload/UploadDialog;", "mUploadDialog$delegate", "Lkotlin/Lazy;", "getMUploadDialog", "()Lcom/qiahao/nextvideo/ui/upload/UploadDialog;", "mUploadDialog", "controllerWindow", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/Window;", "getControllerWindow", "setControllerWindow", "(Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/Window;)V", "Lcom/qiahao/nextvideo/room/float/RoomFloatView;", "mRoomFloatView$delegate", "getMRoomFloatView", "()Lcom/qiahao/nextvideo/room/float/RoomFloatView;", "mRoomFloatView", "Lcom/qiahao/nextvideo/ui/reusable/views/MatchingFloatView;", "mMatchingFloatView$delegate", "getMMatchingFloatView", "()Lcom/qiahao/nextvideo/ui/reusable/views/MatchingFloatView;", "mMatchingFloatView", "Lcom/qiahao/nextvideo/ui/reusable/views/GlobalTipSvga2;", "mGlobalTipSvgaView$delegate", "getMGlobalTipSvgaView", "()Lcom/qiahao/nextvideo/ui/reusable/views/GlobalTipSvga2;", "mGlobalTipSvgaView", "Lcom/qiahao/nextvideo/ui/reusable/views/GiftBannerButtonView;", "mGlobalEnvelopeView$delegate", "getMGlobalEnvelopeView", "()Lcom/qiahao/nextvideo/ui/reusable/views/GiftBannerButtonView;", "mGlobalEnvelopeView", "value", "mCanShowGlobalDialog", "getMCanShowGlobalDialog", "setMCanShowGlobalDialog", "Lnd/a;", "disposable$delegate", "getDisposable", "()Lnd/a;", "disposable", "Lcom/qiahao/nextvideo/room/dialog/JoinLockRoomBottomDialog;", "mJoinedRoomInfoBottomSheetDialog", "Lcom/qiahao/nextvideo/room/dialog/JoinLockRoomBottomDialog;", "getMJoinedRoomInfoBottomSheetDialog", "()Lcom/qiahao/nextvideo/room/dialog/JoinLockRoomBottomDialog;", "setMJoinedRoomInfoBottomSheetDialog", "(Lcom/qiahao/nextvideo/room/dialog/JoinLockRoomBottomDialog;)V", "Landroid/widget/FrameLayout;", "getContainer", "()Landroid/widget/FrameLayout;", "container", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class HiloBaseActivity extends BaseActivity {

    @Nullable
    private Window controllerWindow;
    private boolean disableBackButton;

    @Nullable
    private JoinLockRoomBottomDialog mJoinedRoomInfoBottomSheetDialog;

    @Nullable
    private StrangeChange mStrangeChange;

    @Nullable
    private ProgressDialogWrapper progressDialog;
    private boolean showGiftTip = true;
    private boolean mSetBottom = true;

    /* renamed from: mUploadDialog$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mUploadDialog = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.app.base.f
        public final Object invoke() {
            UploadDialog mUploadDialog_delegate$lambda$0;
            mUploadDialog_delegate$lambda$0 = HiloBaseActivity.mUploadDialog_delegate$lambda$0(HiloBaseActivity.this);
            return mUploadDialog_delegate$lambda$0;
        }
    });

    /* renamed from: mRoomFloatView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mRoomFloatView = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.app.base.g
        public final Object invoke() {
            RoomFloatView mRoomFloatView_delegate$lambda$2;
            mRoomFloatView_delegate$lambda$2 = HiloBaseActivity.mRoomFloatView_delegate$lambda$2(HiloBaseActivity.this);
            return mRoomFloatView_delegate$lambda$2;
        }
    });

    /* renamed from: mMatchingFloatView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMatchingFloatView = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.app.base.h
        public final Object invoke() {
            MatchingFloatView mMatchingFloatView_delegate$lambda$3;
            mMatchingFloatView_delegate$lambda$3 = HiloBaseActivity.mMatchingFloatView_delegate$lambda$3(HiloBaseActivity.this);
            return mMatchingFloatView_delegate$lambda$3;
        }
    });

    /* renamed from: mGlobalTipSvgaView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mGlobalTipSvgaView = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.app.base.i
        public final Object invoke() {
            GlobalTipSvga2 mGlobalTipSvgaView_delegate$lambda$5;
            mGlobalTipSvgaView_delegate$lambda$5 = HiloBaseActivity.mGlobalTipSvgaView_delegate$lambda$5(HiloBaseActivity.this);
            return mGlobalTipSvgaView_delegate$lambda$5;
        }
    });

    /* renamed from: mGlobalEnvelopeView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mGlobalEnvelopeView = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.app.base.j
        public final Object invoke() {
            GiftBannerButtonView mGlobalEnvelopeView_delegate$lambda$7;
            mGlobalEnvelopeView_delegate$lambda$7 = HiloBaseActivity.mGlobalEnvelopeView_delegate$lambda$7(HiloBaseActivity.this);
            return mGlobalEnvelopeView_delegate$lambda$7;
        }
    });
    private boolean mCanShowGlobalDialog = true;

    /* renamed from: disposable$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy disposable = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.app.base.k
        public final Object invoke() {
            nd.a disposable_delegate$lambda$8;
            disposable_delegate$lambda$8 = HiloBaseActivity.disposable_delegate$lambda$8();
            return disposable_delegate$lambda$8;
        }
    });

    private final boolean canShowGroupBroadCastDialog() {
        if (!(this instanceof VideoCallActivity) && !(this instanceof MatchVideoActivity)) {
            return Intrinsics.areEqual(MatchingProvide.INSTANCE.getMatchStatue(), "default");
        }
        return false;
    }

    private final boolean checkGiftTip() {
        if (!this.showGiftTip || !((Boolean) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "open_gift_banner", Boolean.TRUE, (String) null, 4, (Object) null)).booleanValue()) {
            return false;
        }
        if (this instanceof MainActivity) {
            return this.mCanShowGlobalDialog;
        }
        if (this instanceof ChatActivity) {
            if (((ChatActivity) this).getIsDialog()) {
                return false;
            }
        } else if (this instanceof ChatStrangeActivity) {
            if (((ChatStrangeActivity) this).getIsDialog()) {
                return false;
            }
        } else if (this instanceof StrangeListActivity) {
            if (((StrangeListActivity) this).getIsDialog()) {
                return false;
            }
        } else if (this instanceof RoomActivity) {
            return MeetingRoomManager.INSTANCE.checkShowEffect();
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void dismissProgressDialog$default(HiloBaseActivity hiloBaseActivity, boolean z, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            hiloBaseActivity.dismissProgressDialog(z, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dismissProgressDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dismissProgressDialog$lambda$14(HiloBaseActivity hiloBaseActivity, Function0 function0) {
        View view;
        FrameLayout container = hiloBaseActivity.getContainer();
        if (container != null) {
            ProgressDialogWrapper progressDialogWrapper = hiloBaseActivity.progressDialog;
            if (progressDialogWrapper != null) {
                view = progressDialogWrapper.getView();
            } else {
                view = null;
            }
            container.removeView(view);
        }
        if (function0 != null) {
            function0.invoke();
        }
        hiloBaseActivity.disableBackButton = false;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final nd.a disposable_delegate$lambda$8() {
        return new nd.a();
    }

    private final nd.a getDisposable() {
        return (nd.a) this.disposable.getValue();
    }

    private final MatchingFloatView getMMatchingFloatView() {
        return (MatchingFloatView) this.mMatchingFloatView.getValue();
    }

    private final RoomFloatView getMRoomFloatView() {
        return (RoomFloatView) this.mRoomFloatView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UploadDialog getMUploadDialog() {
        return (UploadDialog) this.mUploadDialog.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final GiftBannerButtonView mGlobalEnvelopeView_delegate$lambda$7(final HiloBaseActivity hiloBaseActivity) {
        GiftBannerButtonView giftBannerButtonView = new GiftBannerButtonView(hiloBaseActivity, null, 0, 6, null);
        giftBannerButtonView.setMListener(new GfitBannerButtonListener() { // from class: com.qiahao.nextvideo.app.base.HiloBaseActivity$mGlobalEnvelopeView$2$1$1
            @Override // com.qiahao.nextvideo.ui.reusable.views.GfitBannerButtonListener
            public void openRoom(String groupId, int sceneType) {
                Intrinsics.checkNotNullParameter(groupId, "groupId");
                HiloBaseActivity.this.openRoom(groupId, sceneType);
            }
        });
        return giftBannerButtonView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final GlobalTipSvga2 mGlobalTipSvgaView_delegate$lambda$5(final HiloBaseActivity hiloBaseActivity) {
        GlobalTipSvga2 globalTipSvga2 = new GlobalTipSvga2(hiloBaseActivity, null, 0, 6, null);
        globalTipSvga2.setMListener(new GlobalTipSvgaListener() { // from class: com.qiahao.nextvideo.app.base.HiloBaseActivity$mGlobalTipSvgaView$2$1$1
            @Override // com.qiahao.nextvideo.ui.reusable.views.GlobalTipSvgaListener
            public void openRoom(String groupId, int sceneType) {
                Intrinsics.checkNotNullParameter(groupId, "groupId");
                HiloBaseActivity.this.openRoom(groupId, sceneType);
            }
        });
        return globalTipSvga2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MatchingFloatView mMatchingFloatView_delegate$lambda$3(HiloBaseActivity hiloBaseActivity) {
        return new MatchingFloatView(new WeakReference(hiloBaseActivity), null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final RoomFloatView mRoomFloatView_delegate$lambda$2(HiloBaseActivity hiloBaseActivity) {
        return new RoomFloatView(hiloBaseActivity, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final UploadDialog mUploadDialog_delegate$lambda$0(HiloBaseActivity hiloBaseActivity) {
        return new UploadDialog(hiloBaseActivity, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDelayEvent$lambda$12(HiloBaseActivity hiloBaseActivity, CreateSudData createSudData) {
        Lifecycle.Event event;
        int i;
        int i2;
        LifecycleTask lifecycleTask = hiloBaseActivity.getLifecycleTask();
        if (lifecycleTask != null) {
            event = lifecycleTask.getCurrentEvent();
        } else {
            event = null;
        }
        if (event == Lifecycle.Event.ON_RESUME) {
            GameJum gameJum = GameJum.INSTANCE;
            Long gameId = createSudData.getGameId();
            if (gameId != null) {
                i = (int) gameId.longValue();
            } else {
                i = 0;
            }
            Integer gameType = createSudData.getGameType();
            if (gameType != null) {
                i2 = gameType.intValue();
            } else {
                i2 = 0;
            }
            GameJum.matchGame$default(gameJum, 0, i, createSudData.getMode(), i2, null, 17, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$9(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "<unused var>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$11(DialogInterface dialogInterface) {
        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "SHOW_STRANGE_DIALOG", Boolean.FALSE, (String) null, 4, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showProgressDialog$default(HiloBaseActivity hiloBaseActivity, int i, boolean z, Function0 function0, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showProgressDialog");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            function0 = null;
        }
        hiloBaseActivity.showProgressDialog(i, z, (Function0<Unit>) function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showProgressDialog$lambda$13(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void startActivity$default(HiloBaseActivity hiloBaseActivity, Intent intent, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startActivity");
        }
        if ((i3 & 2) != 0) {
            i = R.anim.anim_slide_up;
        }
        if ((i3 & 4) != 0) {
            i2 = R.anim.anim_none;
        }
        hiloBaseActivity.startActivity(intent, i, i2);
    }

    public final void dismissProgressDialog(boolean animated, @Nullable final Function0<Unit> completion) {
        ViewParent viewParent;
        ProgressDialogWrapper progressDialogWrapper;
        View view;
        ProgressDialogWrapper progressDialogWrapper2 = this.progressDialog;
        if (progressDialogWrapper2 != null && (view = progressDialogWrapper2.getView()) != null) {
            viewParent = view.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null && (progressDialogWrapper = this.progressDialog) != null) {
            progressDialogWrapper.hide(animated, new Function0() { // from class: com.qiahao.nextvideo.app.base.e
                public final Object invoke() {
                    Unit dismissProgressDialog$lambda$14;
                    dismissProgressDialog$lambda$14 = HiloBaseActivity.dismissProgressDialog$lambda$14(HiloBaseActivity.this, completion);
                    return dismissProgressDialog$lambda$14;
                }
            });
        }
    }

    @Nullable
    public final FrameLayout getContainer() {
        return (FrameLayout) findViewById(R.id.activity_main_container);
    }

    @Nullable
    public final Window getControllerWindow() {
        return this.controllerWindow;
    }

    @NotNull
    public final Window getControllerWindowNotNull() {
        if (this.controllerWindow == null) {
            Window window = new Window(this);
            window.setRemoveRootControllerListener(new RemoveRootControllerHost() { // from class: com.qiahao.nextvideo.app.base.HiloBaseActivity$getControllerWindowNotNull$1$1
                @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.host.RemoveRootControllerHost
                public void removeRootControllerHost() {
                    FrameLayout container = HiloBaseActivity.this.getContainer();
                    if (container != null) {
                        container.removeView(HiloBaseActivity.this.getControllerWindow());
                    }
                    HiloBaseActivity.this.setControllerWindow(null);
                }
            });
            FrameLayout container = getContainer();
            if (container != null) {
                container.addView(window);
            }
            this.controllerWindow = window;
        }
        Window window2 = this.controllerWindow;
        Intrinsics.checkNotNull(window2);
        return window2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getLayoutResId() {
        return R.layout.activity_base;
    }

    public final boolean getMCanShowGlobalDialog() {
        return this.mCanShowGlobalDialog;
    }

    @NotNull
    public final GiftBannerButtonView getMGlobalEnvelopeView() {
        return (GiftBannerButtonView) this.mGlobalEnvelopeView.getValue();
    }

    @NotNull
    public final GlobalTipSvga2 getMGlobalTipSvgaView() {
        return (GlobalTipSvga2) this.mGlobalTipSvgaView.getValue();
    }

    @Nullable
    public final JoinLockRoomBottomDialog getMJoinedRoomInfoBottomSheetDialog() {
        return this.mJoinedRoomInfoBottomSheetDialog;
    }

    public final boolean getMSetBottom() {
        return this.mSetBottom;
    }

    @Nullable
    public final StrangeChange getMStrangeChange() {
        return this.mStrangeChange;
    }

    public final boolean getShowGiftTip() {
        return this.showGiftTip;
    }

    public void onBackPressed() {
        if (this.disableBackButton) {
            return;
        }
        Window window = this.controllerWindow;
        if (window != null && !window.onBackPressed()) {
            if (this.controllerWindow != null) {
                super/*com.oudi.core.component.SuperActivity*/.onBackPressed();
            }
        } else if (this.controllerWindow == null) {
            super/*com.oudi.core.component.SuperActivity*/.onBackPressed();
        }
    }

    @m(threadMode = ThreadMode.MAIN)
    public final void onDelayEvent(@NotNull DelayEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getType(), "HOME_OPEN_MATCH_GAME")) {
            Object data = event.getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.qiahao.nextvideo.data.game.CreateSudData");
            final CreateSudData createSudData = (CreateSudData) data;
            HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.app.base.b
                @Override // java.lang.Runnable
                public final void run() {
                    HiloBaseActivity.onDelayEvent$lambda$12(HiloBaseActivity.this, createSudData);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        getMGlobalTipSvgaView().setMListener(null);
        getMGlobalEnvelopeView().setMListener(null);
        getMRoomFloatView().hide();
        if (!getDisposable().isDisposed()) {
            getDisposable().dispose();
        }
        super.onDestroy();
        Window window = this.controllerWindow;
        if (window != null) {
            window.onDestroy();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m(threadMode = ThreadMode.MAIN)
    public final void onGlobalEvent(@NotNull GlobalEvent event) {
        Lifecycle.Event event2;
        Intrinsics.checkNotNullParameter(event, "event");
        LifecycleTask lifecycleTask = getLifecycleTask();
        if (lifecycleTask != null) {
            event2 = lifecycleTask.getCurrentEvent();
        } else {
            event2 = null;
        }
        if (event2 != Lifecycle.Event.ON_RESUME) {
            return;
        }
        String type = event.getType();
        int hashCode = type.hashCode();
        if (hashCode != -762010388) {
            if (hashCode != -277126529) {
                if (hashCode == 988099832 && type.equals("global_broad_cast")) {
                    MMKVStore mMKVStore = MMKVStore.INSTANCE;
                    Boolean bool = Boolean.FALSE;
                    if (((Boolean) IStore.DefaultImpls.getValue$default(mMKVStore, "SHOW_LUCKY_FRUIT", bool, (String) null, 4, (Object) null)).booleanValue() && (this instanceof RoomActivity)) {
                        return;
                    }
                    if ((!((Boolean) IStore.DefaultImpls.getValue$default(mMKVStore, "show_foodie", bool, (String) null, 4, (Object) null)).booleanValue() || !(this instanceof RoomActivity)) && canShowGroupBroadCastDialog() && (event.getData() instanceof GroupBroadCastBean)) {
                        Object data = event.getData();
                        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.GroupBroadCastBean");
                        GroupBroadCastBean groupBroadCastBean = (GroupBroadCastBean) data;
                        if (!MeetingRoomManager.INSTANCE.currentInRoom(groupBroadCastBean.getGroupId())) {
                            new RoomBroadCastDialog(this, groupBroadCastBean).show();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (type.equals("global_gift_banner")) {
                if (checkGiftTip()) {
                    getMGlobalTipSvgaView().show();
                    return;
                } else {
                    MeetingRoomManager.INSTANCE.getMReceiverGlobalGiftSvgaList().clear();
                    return;
                }
            }
            return;
        }
        if (type.equals("global_envelope")) {
            if (checkGiftTip()) {
                getMGlobalEnvelopeView().show();
            } else {
                MeetingRoomManager.INSTANCE.getMGiftBannerButtonList().clear();
            }
        }
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperActivity*/.onInitialize();
        Lifecycle myLifecycle = getMyLifecycle();
        if (myLifecycle != null) {
            myLifecycle.addObserver(new LifecycleEventObserver() { // from class: com.qiahao.nextvideo.app.base.d
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    HiloBaseActivity.onInitialize$lambda$9(lifecycleOwner, event);
                }
            });
        }
        FrameLayout container = getContainer();
        if (container != null) {
            container.setBackgroundColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
            this.progressDialog = new ProgressDialogWrapper(container);
            if (this.mSetBottom) {
                setStatusBarTopOrBottom(container, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
        if (!(this instanceof RoomActivity)) {
            getMRoomFloatView().hide();
        }
        getMMatchingFloatView().hide();
        getMGlobalTipSvgaView().hideImmediate();
        getDisposable().d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        nd.c subscribe = UserService.INSTANCE.getShared().getMUploadEventRelay().observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.app.base.HiloBaseActivity$onResume$1
            public final void accept(String str) {
                AppCompatDialog mUploadDialog;
                mUploadDialog = HiloBaseActivity.this.getMUploadDialog();
                mUploadDialog.show();
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, getDisposable());
        if (!(this instanceof RoomActivity)) {
            getMRoomFloatView().show();
        }
        if (MatchingProvide.INSTANCE.showMatchingFloatView(this)) {
            MatchingFloatView.show$default(getMMatchingFloatView(), null, 1, null);
        } else {
            getMMatchingFloatView().hide();
        }
        getMGlobalTipSvgaView().hideImmediate();
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (meetingRoomManager.getMReceiverGlobalGiftSvgaList().size() > 0) {
            if (checkGiftTip()) {
                getMGlobalTipSvgaView().show();
            } else {
                meetingRoomManager.getMReceiverGlobalGiftSvgaList().clear();
            }
        }
        getMGlobalEnvelopeView().hideImmediate();
        if (meetingRoomManager.getMGiftBannerButtonList().size() > 0) {
            if (checkGiftTip()) {
                getMGlobalEnvelopeView().show();
            } else {
                meetingRoomManager.getMGiftBannerButtonList().clear();
            }
        }
        if (((Boolean) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "SHOW_STRANGE_DIALOG", Boolean.FALSE, (String) null, 4, (Object) null)).booleanValue() && this.mStrangeChange != null) {
            BaseBindingDialog strangeEndDialog = new StrangeEndDialog(this, this.mStrangeChange);
            strangeEndDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.app.base.c
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    HiloBaseActivity.onResume$lambda$11(dialogInterface);
                }
            });
            strangeEndDialog.show();
        }
    }

    @m(threadMode = ThreadMode.MAIN)
    public final void onStrangeChatEvent(@NotNull EventBusKey event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getType(), "STRANGE_CHAT_END") && (event.getData() instanceof StrangeChange)) {
            Object data = event.getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.qiahao.base_common.model.im.StrangeChange");
            this.mStrangeChange = (StrangeChange) data;
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "SHOW_STRANGE_DIALOG", Boolean.TRUE, (String) null, 4, (Object) null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m(threadMode = ThreadMode.MAIN)
    public final void onVideoEvent(@NotNull MatchingFloatData event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (MatchingProvide.INSTANCE.showMatchingFloatView(this)) {
            MatchingFloatView.show$default(getMMatchingFloatView(), null, 1, null);
        } else {
            getMMatchingFloatView().hide();
        }
    }

    public final void openRoom(@NotNull String groupId, int sceneType) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        if ((this instanceof RoomActivity) && Intrinsics.areEqual(MeetingRoomManager.INSTANCE.getMGroupId(), groupId)) {
            return;
        }
        StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, groupId, null, null, null, null, null, null, null, sceneType, 0, null, 0, false, 7934, null);
    }

    public final void setControllerWindow(@Nullable Window window) {
        this.controllerWindow = window;
    }

    public final void setMCanShowGlobalDialog(boolean z) {
        this.mCanShowGlobalDialog = z;
        if (!z) {
            getMGlobalTipSvgaView().hideImmediate();
            getMGlobalEnvelopeView().hideImmediate();
        }
    }

    public final void setMJoinedRoomInfoBottomSheetDialog(@Nullable JoinLockRoomBottomDialog joinLockRoomBottomDialog) {
        this.mJoinedRoomInfoBottomSheetDialog = joinLockRoomBottomDialog;
    }

    public final void setMSetBottom(boolean z) {
        this.mSetBottom = z;
    }

    public final void setMStrangeChange(@Nullable StrangeChange strangeChange) {
        this.mStrangeChange = strangeChange;
    }

    public final void setShowGiftTip(boolean z) {
        this.showGiftTip = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showDailyGetDiamond(boolean isVip, long diamond, int matchCardNum) {
        new DailyRewardDialog(isVip, diamond, matchCardNum, this).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showProgressDialog(int messageRes, boolean animated, @Nullable Function0<Unit> completion) {
        String string = getString(messageRes);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        showProgressDialog(string, animated, completion);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void startActivity(@NotNull Intent intent, int enterAnim, int exitAnim) {
        Intrinsics.checkNotNullParameter(intent, MessengerService.INTENT);
        startActivity(intent);
        overridePendingTransition(enterAnim, exitAnim);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showProgressDialog$default(HiloBaseActivity hiloBaseActivity, String str, boolean z, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showProgressDialog");
        }
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        hiloBaseActivity.showProgressDialog(str, z, (Function0<Unit>) function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startActivity$default(HiloBaseActivity hiloBaseActivity, Context context, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = R.anim.anim_slide_up;
            }
            if ((i3 & 4) != 0) {
                i2 = R.anim.anim_none;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.reifiedOperationMarker(4, "T");
            context.startActivity(new Intent(context, (Class<?>) Object.class));
            hiloBaseActivity.overridePendingTransition(i, i2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startActivity");
    }

    public final void showProgressDialog(@NotNull String message, boolean animated, @Nullable final Function0<Unit> completion) {
        AppCompatTextView progressText;
        View view;
        Intrinsics.checkNotNullParameter(message, Constants.SHARED_MESSAGE_ID_FILE);
        this.disableBackButton = true;
        ProgressDialogWrapper progressDialogWrapper = this.progressDialog;
        if (((progressDialogWrapper == null || (view = progressDialogWrapper.getView()) == null) ? null : view.getParent()) == null) {
            ProgressDialogWrapper progressDialogWrapper2 = this.progressDialog;
            if (progressDialogWrapper2 != null && (progressText = progressDialogWrapper2.getProgressText()) != null) {
                progressText.setText(message);
            }
            FrameLayout container = getContainer();
            if (container != null) {
                ProgressDialogWrapper progressDialogWrapper3 = this.progressDialog;
                container.addView(progressDialogWrapper3 != null ? progressDialogWrapper3.getView() : null);
            }
            ProgressDialogWrapper progressDialogWrapper4 = this.progressDialog;
            if (progressDialogWrapper4 != null) {
                progressDialogWrapper4.show(animated, new Function0() { // from class: com.qiahao.nextvideo.app.base.a
                    public final Object invoke() {
                        Unit showProgressDialog$lambda$13;
                        showProgressDialog$lambda$13 = HiloBaseActivity.showProgressDialog$lambda$13(completion);
                        return showProgressDialog$lambda$13;
                    }
                });
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T> void startActivity(Context context, int enterAnim, int exitAnim) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.reifiedOperationMarker(4, "T");
        context.startActivity(new Intent(context, (Class<?>) Object.class));
        overridePendingTransition(enterAnim, exitAnim);
    }
}
