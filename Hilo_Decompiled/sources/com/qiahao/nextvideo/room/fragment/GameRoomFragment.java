package com.qiahao.nextvideo.room.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.log.LogUtil;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.eventBus.ChatRoomStatusEvent;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.permission.PermissionInterceptor;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.hilo_message.message.RoomMessageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.EnterRoomData;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.qiahao.nextvideo.data.service.match.WebSocketProvide;
import com.qiahao.nextvideo.databinding.FragmentGameRoomBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.room.help.GameRoomFragmentHelp;
import com.qiahao.nextvideo.room.help.MatchGameHelp;
import com.qiahao.nextvideo.room.help.VideoUploadManager;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.room.view.GroupInputLayoutView;
import com.qiahao.nextvideo.room.view.micro.GameMicroView;
import com.qiahao.nextvideo.room.viewmodel.RoomViewModel;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.game.RoomMatchGame;
import io.agora.rtc.RtcEngine;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.android.agoo.common.AgooConstants;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020%H\u0002J\u0006\u0010'\u001a\u00020%J\b\u0010(\u001a\u0004\u0018\u00010\u0002J\u0010\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020+H\u0007J\u0010\u0010,\u001a\u00020%2\u0006\u0010*\u001a\u00020-H\u0007J\u0018\u0010.\u001a\u00020/2\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020%\u0018\u000101J\u0006\u00102\u001a\u00020/J\b\u00103\u001a\u00020%H\u0016J\b\u00104\u001a\u00020%H\u0007J\b\u00105\u001a\u00020/H\u0016J\u0006\u00106\u001a\u00020%J\u0010\u00107\u001a\u00020%2\b\b\u0002\u00108\u001a\u00020/J\b\u00109\u001a\u00020%H\u0002J\b\u0010:\u001a\u00020%H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006;"}, d2 = {"Lcom/qiahao/nextvideo/room/fragment/GameRoomFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentGameRoomBinding;", "<init>", "()V", "enterRoomData", "Lcom/qiahao/nextvideo/data/model/EnterRoomData;", "getEnterRoomData", "()Lcom/qiahao/nextvideo/data/model/EnterRoomData;", "setEnterRoomData", "(Lcom/qiahao/nextvideo/data/model/EnterRoomData;)V", "mViewModel", "Lcom/qiahao/nextvideo/room/viewmodel/RoomViewModel;", "getMViewModel", "()Lcom/qiahao/nextvideo/room/viewmodel/RoomViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "mAudioHelp", "Lcom/qiahao/nextvideo/room/help/GameRoomFragmentHelp;", "getMAudioHelp", "()Lcom/qiahao/nextvideo/room/help/GameRoomFragmentHelp;", "setMAudioHelp", "(Lcom/qiahao/nextvideo/room/help/GameRoomFragmentHelp;)V", "mGameHelp", "Lcom/qiahao/nextvideo/room/help/MatchGameHelp;", "getMGameHelp", "()Lcom/qiahao/nextvideo/room/help/MatchGameHelp;", "mGameHelp$delegate", "mChatLayout", "Lcom/qiahao/hilo_message/message/RoomMessageView;", "getMChatLayout", "()Lcom/qiahao/hilo_message/message/RoomMessageView;", "setMChatLayout", "(Lcom/qiahao/hilo_message/message/RoomMessageView;)V", "getLayoutResId", "", "onInitialize", "", "initData", "initChatLayout", "getBinding", "onRoomEvent", "event", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "onLiveEvent", "Lcom/qiahao/base_common/model/eventBus/LiveEvent;", "checkAudioPermission", "", "listener", "Lkotlin/Function0;", "checkMicPermission", "onResume", "showSoftKeyBoard", "onBackPressedIntercept", "exit", "leaveRoom", "needFetchLeaveRoom", "releaseViewReference", "onDestroy", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGameRoomFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GameRoomFragment.kt\ncom/qiahao/nextvideo/room/fragment/GameRoomFragment\n+ 2 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,372:1\n48#2:373\n1#3:374\n167#4,2:375\n*S KotlinDebug\n*F\n+ 1 GameRoomFragment.kt\ncom/qiahao/nextvideo/room/fragment/GameRoomFragment\n*L\n128#1:373\n82#1:375,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameRoomFragment extends BaseBindingFragment<FragmentGameRoomBinding> {

    @Nullable
    private EnterRoomData enterRoomData;

    @Nullable
    private GameRoomFragmentHelp mAudioHelp;

    @Nullable
    private RoomMessageView mChatLayout;

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.fragment.h
        public final Object invoke() {
            RoomViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = GameRoomFragment.mViewModel_delegate$lambda$0(GameRoomFragment.this);
            return mViewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mGameHelp$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mGameHelp = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.fragment.i
        public final Object invoke() {
            MatchGameHelp mGameHelp_delegate$lambda$1;
            mGameHelp_delegate$lambda$1 = GameRoomFragment.mGameHelp_delegate$lambda$1(GameRoomFragment.this);
            return mGameHelp_delegate$lambda$1;
        }
    });

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean checkAudioPermission$default(GameRoomFragment gameRoomFragment, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        return gameRoomFragment.checkAudioPermission(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkAudioPermission$lambda$6$lambda$5(GameRoomFragment gameRoomFragment, Function0 function0, List list, List list2) {
        Intrinsics.checkNotNullParameter(list, "grantedList");
        Intrinsics.checkNotNullParameter(list2, "deniedList");
        if (list2.isEmpty()) {
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            meetingRoomManager.setMicPermission(true);
            cf.c.c().l(new ChatRoomStatusEvent("start_service", (Object) null, 2, (DefaultConstructorMarker) null));
            if (meetingRoomManager.getLocalRoomMicStatus()) {
                gameRoomFragment.getMViewModel().setRemoteAllMute(false);
            } else {
                gameRoomFragment.getMViewModel().setRemoteAllMute(true);
            }
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    private final void initData() {
        String str;
        String str2;
        String groupId;
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString(StartRoomUtils.ENTER_ROOM_DATA);
        } else {
            str = null;
        }
        EnterRoomData enterRoomData = (EnterRoomData) BaseApplication.Companion.getGSON().j(str, EnterRoomData.class);
        this.enterRoomData = enterRoomData;
        if (enterRoomData != null && !enterRoomData.isForSmallRoom()) {
            MeetingRoomManager.INSTANCE.setMRoomChatTab(0);
        }
        RoomViewModel mViewModel = getMViewModel();
        EnterRoomData enterRoomData2 = this.enterRoomData;
        String str3 = "";
        if (enterRoomData2 == null || (str2 = enterRoomData2.getGroupId()) == null) {
            str2 = "";
        }
        mViewModel.setMGroupId(str2);
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        EnterRoomData enterRoomData3 = this.enterRoomData;
        if (enterRoomData3 != null && (groupId = enterRoomData3.getGroupId()) != null) {
            str3 = groupId;
        }
        meetingRoomManager.setMGroupId(str3);
        meetingRoomManager.setMicPermission(checkMicPermission());
        meetingRoomManager.changeRoomStatus(2);
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        Boolean bool = Boolean.FALSE;
        IStore.DefaultImpls.setValue$default(mMKVStore, "open_game", bool, (String) null, 4, (Object) null);
        IStore.DefaultImpls.setValue$default(mMKVStore, "open_pk", bool, (String) null, 4, (Object) null);
        IStore.DefaultImpls.setValue$default(mMKVStore, "open_video", bool, (String) null, 4, (Object) null);
        Boolean bool2 = Boolean.TRUE;
        meetingRoomManager.setShowGiftEffect(((Boolean) IStore.DefaultImpls.getValue$default(mMKVStore, "GiftEffect", bool2, (String) null, 4, (Object) null)).booleanValue());
        meetingRoomManager.setShowEnterEffect(((Boolean) IStore.DefaultImpls.getValue$default(mMKVStore, "EnterEffect", bool2, (String) null, 4, (Object) null)).booleanValue());
        meetingRoomManager.setShowRocketEffect(((Boolean) IStore.DefaultImpls.getValue$default(mMKVStore, "RocketEffect", bool2, (String) null, 4, (Object) null)).booleanValue());
    }

    public static /* synthetic */ void leaveRoom$default(GameRoomFragment gameRoomFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        gameRoomFragment.leaveRoom(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MatchGameHelp mGameHelp_delegate$lambda$1(GameRoomFragment gameRoomFragment) {
        return new MatchGameHelp(gameRoomFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomViewModel mViewModel_delegate$lambda$0(GameRoomFragment gameRoomFragment) {
        return new ViewModelProvider(gameRoomFragment).get(RoomViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$3$lambda$2(GameRoomFragment gameRoomFragment, int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        FrameLayout frameLayout;
        ImageView imageView;
        FragmentGameRoomBinding fragmentGameRoomBinding = (FragmentGameRoomBinding) gameRoomFragment.getBinding();
        if (fragmentGameRoomBinding != null && (imageView = fragmentGameRoomBinding.gameIcon) != null) {
            layoutParams = imageView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ConstraintLayout.b) layoutParams).setMargins(0, i + UiKtxKt.toPX(10), 0, 0);
        FragmentGameRoomBinding fragmentGameRoomBinding2 = (FragmentGameRoomBinding) gameRoomFragment.getBinding();
        if (fragmentGameRoomBinding2 != null && (frameLayout = fragmentGameRoomBinding2.frameLayout) != null) {
            frameLayout.setPadding(0, 0, 0, i2);
        }
        return Unit.INSTANCE;
    }

    private final void releaseViewReference() {
        FrameLayout frameLayout;
        LightQueueCombinationPlayer lightQueueCombinationPlayer;
        FragmentGameRoomBinding fragmentGameRoomBinding = (FragmentGameRoomBinding) getBinding();
        if (fragmentGameRoomBinding != null && (lightQueueCombinationPlayer = fragmentGameRoomBinding.queuePlayer) != null) {
            lightQueueCombinationPlayer.onCleared();
        }
        FragmentGameRoomBinding fragmentGameRoomBinding2 = (FragmentGameRoomBinding) getBinding();
        if (fragmentGameRoomBinding2 != null && (frameLayout = fragmentGameRoomBinding2.chatBack) != null) {
            frameLayout.removeAllViews();
        }
        GameRoomFragmentHelp gameRoomFragmentHelp = this.mAudioHelp;
        if (gameRoomFragmentHelp != null) {
            gameRoomFragmentHelp.release();
        }
        MatchGameHelp mGameHelp = getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.releaseAnimation();
        }
    }

    public final boolean checkAudioPermission(@Nullable final Function0<Unit> listener) {
        boolean checkMicPermission = checkMicPermission();
        if (HiloUtils.INSTANCE.getActivity(getContext()) != null) {
            if (!checkMicPermission) {
                w9.h.u(this).p(fa.b.o()).j(new PermissionInterceptor()).r(new w9.c() { // from class: com.qiahao.nextvideo.room.fragment.j
                    public final void onResult(List list, List list2) {
                        GameRoomFragment.checkAudioPermission$lambda$6$lambda$5(GameRoomFragment.this, listener, list, list2);
                    }
                });
            } else if (listener != null) {
                listener.invoke();
            }
        }
        return checkMicPermission;
    }

    public final boolean checkMicPermission() {
        FragmentActivity activity = getActivity();
        if (activity == null || !w9.h.m(activity, fa.b.o())) {
            return false;
        }
        return true;
    }

    public final void exit() {
        leaveRoom$default(this, false, 1, null);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Nullable
    public final FragmentGameRoomBinding getBinding() {
        return (FragmentGameRoomBinding) getBinding();
    }

    @Nullable
    public final EnterRoomData getEnterRoomData() {
        return this.enterRoomData;
    }

    protected int getLayoutResId() {
        return R.layout.fragment_game_room;
    }

    @Nullable
    public final GameRoomFragmentHelp getMAudioHelp() {
        return this.mAudioHelp;
    }

    @Nullable
    public final RoomMessageView getMChatLayout() {
        return this.mChatLayout;
    }

    @Nullable
    public final MatchGameHelp getMGameHelp() {
        return (MatchGameHelp) this.mGameHelp.getValue();
    }

    @NotNull
    public final RoomViewModel getMViewModel() {
        return (RoomViewModel) this.mViewModel.getValue();
    }

    public final void initChatLayout() {
        FrameLayout frameLayout;
        ViewParent viewParent;
        FrameLayout frameLayout2;
        Context context;
        if (this.mChatLayout == null && (context = getContext()) != null) {
            this.mChatLayout = new RoomMessageView(context);
        }
        FragmentGameRoomBinding fragmentGameRoomBinding = (FragmentGameRoomBinding) getBinding();
        if (fragmentGameRoomBinding != null && (frameLayout = fragmentGameRoomBinding.chatBack) != null && frameLayout.getChildCount() == 0) {
            RoomMessageView roomMessageView = this.mChatLayout;
            ViewParent viewParent2 = null;
            if (roomMessageView != null) {
                viewParent = roomMessageView.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent != null) {
                RoomMessageView roomMessageView2 = this.mChatLayout;
                if (roomMessageView2 != null) {
                    viewParent2 = roomMessageView2.getParent();
                }
                Intrinsics.checkNotNull(viewParent2, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) viewParent2).removeAllViews();
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            RoomMessageView roomMessageView3 = this.mChatLayout;
            if (roomMessageView3 != null) {
                roomMessageView3.setPaddingRelative(0, UiKtxKt.toPX(5), 0, 0);
            }
            FragmentGameRoomBinding fragmentGameRoomBinding2 = (FragmentGameRoomBinding) getBinding();
            if (fragmentGameRoomBinding2 != null && (frameLayout2 = fragmentGameRoomBinding2.chatBack) != null) {
                frameLayout2.addView((View) this.mChatLayout, (ViewGroup.LayoutParams) layoutParams);
            }
        }
    }

    public final void leaveRoom(boolean needFetchLeaveRoom) {
        GameRoomFragmentHelp gameRoomFragmentHelp = this.mAudioHelp;
        if (gameRoomFragmentHelp != null) {
            GameRoomFragmentHelp.showToastOrLog$default(gameRoomFragmentHelp, null, "leaveRoomAfterPreper: 离开房间", true, 1, null);
        }
        WebSocketProvide webSocketProvide = WebSocketProvide.INSTANCE;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        WebSocketProvide.roomWebSocket$default(webSocketProvide, 153, meetingRoomManager.getMGroupId(), null, null, 12, null);
        MatchGameHelp mGameHelp = getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.releaseGame();
        }
        getMViewModel().leaveRoom(needFetchLeaveRoom);
        RoomMessageView roomMessageView = this.mChatLayout;
        if (roomMessageView != null) {
            roomMessageView.destroy();
        }
        meetingRoomManager.getMRoomMessageData().clear();
        releaseViewReference();
        VideoUploadManager.INSTANCE.destroy();
    }

    public boolean onBackPressedIntercept() {
        GameRoomFragmentHelp gameRoomFragmentHelp = this.mAudioHelp;
        if (gameRoomFragmentHelp != null) {
            gameRoomFragmentHelp.showLeaveRoomDialog();
            return true;
        }
        return true;
    }

    public void onDestroy() {
        CoroutineScope fragmentScope;
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        GameRoomFragmentHelp gameRoomFragmentHelp = this.mAudioHelp;
        if (gameRoomFragmentHelp != null && (fragmentScope = gameRoomFragmentHelp.getFragmentScope()) != null) {
            CoroutineScopeKt.cancel$default(fragmentScope, (CancellationException) null, 1, (Object) null);
        }
    }

    public void onInitialize() {
        ImageView imageView;
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        FragmentGameRoomBinding fragmentGameRoomBinding = (FragmentGameRoomBinding) getBinding();
        if (fragmentGameRoomBinding != null && (imageView = fragmentGameRoomBinding.gameIcon) != null) {
            getStatusBarTopOrBottom(imageView, new Function2() { // from class: com.qiahao.nextvideo.room.fragment.k
                public final Object invoke(Object obj, Object obj2) {
                    Unit onInitialize$lambda$3$lambda$2;
                    onInitialize$lambda$3$lambda$2 = GameRoomFragment.onInitialize$lambda$3$lambda$2(GameRoomFragment.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                    return onInitialize$lambda$3$lambda$2;
                }
            });
        }
        cf.c.c().l(new ChatRoomStatusEvent("bind_service", (Object) null, 2, (DefaultConstructorMarker) null));
        try {
            checkAudioPermission$default(this, null, 1, null);
            initData();
            initChatLayout();
            GameRoomFragmentHelp gameRoomFragmentHelp = new GameRoomFragmentHelp(this);
            this.mAudioHelp = gameRoomFragmentHelp;
            gameRoomFragmentHelp.initHelp();
        } catch (Exception e) {
            LogUtil logUtil = LogUtil.INSTANCE;
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            LogUtil.e$default(logUtil, "GameRoomFragment", message, false, 4, (Object) null);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onLiveEvent(@NotNull LiveEvent event) {
        int i;
        String str;
        int i2;
        GameMicroView gameMicroView;
        GameRoomFragmentHelp gameRoomFragmentHelp;
        Intrinsics.checkNotNullParameter(event, "event");
        String type = event.getType();
        int i3 = 0;
        boolean z = false;
        switch (type.hashCode()) {
            case -165873567:
                if (type.equals("join_match_game") && (event.getData() instanceof RoomMatchGame)) {
                    Object data = event.getData();
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.tencent.qcloud.tuikit.tuichat.hilo.bean.game.RoomMatchGame");
                    RoomMatchGame roomMatchGame = (RoomMatchGame) data;
                    RoomViewModel mViewModel = getMViewModel();
                    Integer matchId = roomMatchGame.getMatchId();
                    if (matchId != null) {
                        i = matchId.intValue();
                    } else {
                        i = 0;
                    }
                    String mGroupId = getMViewModel().getMGroupId();
                    Integer gameId = roomMatchGame.getGameId();
                    if (gameId != null) {
                        i3 = gameId.intValue();
                    }
                    mViewModel.roomMatchGameJoin(i, mGroupId, i3);
                    return;
                }
                return;
            case 1303516781:
                if (type.equals("local_mute") && (event.getData() instanceof String)) {
                    MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                    Object data2 = event.getData();
                    Intrinsics.checkNotNull(data2, "null cannot be cast to non-null type kotlin.String");
                    int findMicPositionFromExtraId = meetingRoomManager.findMicPositionFromExtraId((String) data2);
                    MicroBean microBean = (MicroBean) MeetingRoomManager.getMicQueue$default(meetingRoomManager, false, 1, null).get(Integer.valueOf(findMicPositionFromExtraId));
                    if (microBean == null || (str = microBean.getExternalId()) == null) {
                        str = "";
                    }
                    if (microBean != null) {
                        i2 = microBean.getAgoraId();
                    } else {
                        i2 = 0;
                    }
                    if (microBean != null) {
                        z = microBean.getMicForbid();
                    }
                    meetingRoomManager.localMute(str, i2, z);
                    FragmentGameRoomBinding fragmentGameRoomBinding = (FragmentGameRoomBinding) getBinding();
                    if (fragmentGameRoomBinding != null && (gameMicroView = fragmentGameRoomBinding.gameMic) != null) {
                        gameMicroView.refreshMicByPosition(findMicPositionFromExtraId);
                    }
                    MatchGameHelp mGameHelp = getMGameHelp();
                    if (mGameHelp != null) {
                        mGameHelp.refreshPosition(findMicPositionFromExtraId - 1);
                        return;
                    }
                    return;
                }
                return;
            case 1446544220:
                if (type.equals("EXIT_ROOM") && (event.getData() instanceof UserProxy1.QuitRoom)) {
                    Object data3 = event.getData();
                    Intrinsics.checkNotNull(data3, "null cannot be cast to non-null type userProxy.UserProxy1.QuitRoom");
                    UserProxy1.QuitRoom quitRoom = (UserProxy1.QuitRoom) data3;
                    FragmentActivity activity = getActivity();
                    if (activity != null && activity.isFinishing() && !Intrinsics.areEqual(getMViewModel().getMGroupId(), quitRoom.getGroupId())) {
                        return;
                    }
                    if (quitRoom.getReason() == 1) {
                        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, getContext(), ResourcesKtxKt.getStringById(this, 2131953029), false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                        }
                    } else if (quitRoom.getReason() == 2) {
                        HiloToasty.Companion companion = HiloToasty.Companion;
                        Context context = getContext();
                        String format = String.format(ResourcesKtxKt.getStringById(this, 2131952985), Arrays.copyOf(new Object[]{AgooConstants.ACK_REMOVE_PACKAGE}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        Toast normal$default2 = HiloToasty.Companion.normal$default(companion, context, format, false, 4, (Object) null);
                        if (normal$default2 != null) {
                            normal$default2.show();
                        }
                    }
                    MeetingRoomManager.INSTANCE.getWsFlow().tryEmit(new RoomEvent().closeRoomFloatView());
                    leaveRoom(true);
                    FragmentActivity activity2 = getActivity();
                    if (activity2 != null) {
                        activity2.finish();
                        return;
                    }
                    return;
                }
                return;
            case 1545944263:
                if (type.equals("open_game") && (event.getData() instanceof Integer)) {
                    Object data4 = event.getData();
                    if (Intrinsics.areEqual(data4, "101")) {
                        GameRoomFragmentHelp gameRoomFragmentHelp2 = this.mAudioHelp;
                        if (gameRoomFragmentHelp2 != null) {
                            gameRoomFragmentHelp2.showLudoGameView();
                            return;
                        }
                        return;
                    }
                    if (Intrinsics.areEqual(data4, "102")) {
                        GameRoomFragmentHelp gameRoomFragmentHelp3 = this.mAudioHelp;
                        if (gameRoomFragmentHelp3 != null) {
                            gameRoomFragmentHelp3.showUnoGameView();
                            return;
                        }
                        return;
                    }
                    if (Intrinsics.areEqual(data4, "103")) {
                        GameRoomFragmentHelp gameRoomFragmentHelp4 = this.mAudioHelp;
                        if (gameRoomFragmentHelp4 != null) {
                            gameRoomFragmentHelp4.showDominoGameView();
                            return;
                        }
                        return;
                    }
                    if (Intrinsics.areEqual(data4, "104")) {
                        GameRoomFragmentHelp gameRoomFragmentHelp5 = this.mAudioHelp;
                        if (gameRoomFragmentHelp5 != null) {
                            gameRoomFragmentHelp5.showCrushGameView();
                            return;
                        }
                        return;
                    }
                    if (Intrinsics.areEqual(data4, "124")) {
                        GameRoomFragmentHelp gameRoomFragmentHelp6 = this.mAudioHelp;
                        if (gameRoomFragmentHelp6 != null) {
                            gameRoomFragmentHelp6.showBalootGameView();
                            return;
                        }
                        return;
                    }
                    if (Intrinsics.areEqual(data4, "127")) {
                        GameRoomFragmentHelp gameRoomFragmentHelp7 = this.mAudioHelp;
                        if (gameRoomFragmentHelp7 != null) {
                            gameRoomFragmentHelp7.showCarromGameView();
                            return;
                        }
                        return;
                    }
                    if (Intrinsics.areEqual(data4, "131")) {
                        GameRoomFragmentHelp gameRoomFragmentHelp8 = this.mAudioHelp;
                        if (gameRoomFragmentHelp8 != null) {
                            gameRoomFragmentHelp8.showJackaroGameView();
                            return;
                        }
                        return;
                    }
                    if (Intrinsics.areEqual(data4, "133") && (gameRoomFragmentHelp = this.mAudioHelp) != null) {
                        gameRoomFragmentHelp.showBackgammonGameView();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onResume() {
        RtcEngine rtcEngine;
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
        if (agoraRtcService.getRtcEngineInit() && (rtcEngine = agoraRtcService.getRtcEngine()) != null) {
            rtcEngine.disableVideo();
        }
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onRoomEvent(@NotNull RoomEvent event) {
        int i;
        ImageView imageView;
        ImageView imageView2;
        Intrinsics.checkNotNullParameter(event, "event");
        int mEventId = event.getMEventId();
        if (mEventId != 214) {
            String str = null;
            boolean z = true;
            if (mEventId != 502) {
                if (mEventId != 300) {
                    if (mEventId == 301) {
                        leaveRoom$default(this, false, 1, null);
                        FragmentActivity activity = getActivity();
                        if (activity != null) {
                            activity.finish();
                            return;
                        }
                        return;
                    }
                    return;
                }
                leaveRoom$default(this, false, 1, null);
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    activity2.finish();
                    return;
                }
                return;
            }
            GroupDetailBean groupDetailBean = (GroupDetailBean) getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean != null) {
                int mThemeId = event.getMThemeId();
                if (mThemeId == null) {
                    mThemeId = 0;
                }
                groupDetailBean.setThemeId(mThemeId);
            }
            GroupDetailBean groupDetailBean2 = (GroupDetailBean) getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean2 != null) {
                String mThemeUrl = event.getMThemeUrl();
                if (mThemeUrl == null) {
                    mThemeUrl = "";
                }
                groupDetailBean2.setThemeUrl(mThemeUrl);
            }
            GroupDetailBean groupDetailBean3 = (GroupDetailBean) getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean3 != null) {
                int mThemeType = event.getMThemeType();
                if (mThemeType == null) {
                    mThemeType = 0;
                }
                groupDetailBean3.setThemeType(mThemeType);
            }
            Integer mThemeId2 = event.getMThemeId();
            if (mThemeId2 != null) {
                i = mThemeId2.intValue();
            } else {
                i = 0;
            }
            if (i > 0) {
                String mThemeUrl2 = event.getMThemeUrl();
                if (mThemeUrl2 != null && mThemeUrl2.length() != 0) {
                    z = false;
                }
                if (!z) {
                    FragmentGameRoomBinding binding = getBinding();
                    if (binding != null && (imageView2 = binding.meetingRoomThemBackGroup) != null) {
                        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
                        GroupDetailBean groupDetailBean4 = (GroupDetailBean) getMViewModel().getMGroupDetailBean().getValue();
                        if (groupDetailBean4 != null) {
                            str = groupDetailBean4.getThemeUrl();
                        }
                        ViewUtilitiesKt.bind(imageView2, companion.roomBackGroupFull(str, R.drawable.bg_meeting_room1));
                        return;
                    }
                    return;
                }
            }
            FragmentGameRoomBinding binding2 = getBinding();
            if (binding2 != null && (imageView = binding2.meetingRoomThemBackGroup) != null) {
                ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.bg_meeting_room1), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(getMViewModel().getMGroupId(), event.getMGroupId())) {
            leaveRoom(event.getMNeedFetchLeaveRoom());
            FragmentActivity activity3 = getActivity();
            if (activity3 != null) {
                activity3.finish();
            }
        }
    }

    public final void setEnterRoomData(@Nullable EnterRoomData enterRoomData) {
        this.enterRoomData = enterRoomData;
    }

    public final void setMAudioHelp(@Nullable GameRoomFragmentHelp gameRoomFragmentHelp) {
        this.mAudioHelp = gameRoomFragmentHelp;
    }

    public final void setMChatLayout(@Nullable RoomMessageView roomMessageView) {
        this.mChatLayout = roomMessageView;
    }

    @SuppressLint({"WrongConstant"})
    public final void showSoftKeyBoard() {
        Object obj;
        GroupInputLayoutView groupInputLayoutView;
        GroupInputLayoutView groupInputLayoutView2;
        FragmentActivity activity = getActivity();
        IBinder iBinder = null;
        if (activity != null) {
            obj = activity.getSystemService("input_method");
        } else {
            obj = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) obj;
        FragmentGameRoomBinding fragmentGameRoomBinding = (FragmentGameRoomBinding) getBinding();
        if (fragmentGameRoomBinding != null) {
            groupInputLayoutView = fragmentGameRoomBinding.groupInput;
        } else {
            groupInputLayoutView = null;
        }
        inputMethodManager.showSoftInput(groupInputLayoutView, 2);
        FragmentGameRoomBinding fragmentGameRoomBinding2 = (FragmentGameRoomBinding) getBinding();
        if (fragmentGameRoomBinding2 != null && (groupInputLayoutView2 = fragmentGameRoomBinding2.groupInput) != null) {
            iBinder = groupInputLayoutView2.getWindowToken();
        }
        inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
        inputMethodManager.toggleSoftInput(0, 2);
    }
}
