package com.qiahao.nextvideo.room.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.hjq.permissions.permission.base.IPermission;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.log.LogUtil;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.ChatRoomStatusEvent;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.model.eventBus.VideoEvent;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.permission.PermissionInterceptor;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.hilo_message.adapter.RoomMessageAdapter;
import com.qiahao.hilo_message.data.CustomElemContent;
import com.qiahao.hilo_message.data.GroupMessageNew;
import com.qiahao.hilo_message.data.MsgBody;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.hilo_message.message.RoomMessageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.EnterRoomData;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.qiahao.nextvideo.data.service.match.WebSocketProvide;
import com.qiahao.nextvideo.databinding.FragmentAudioRoomBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.room.dialog.PermissionMicDialog;
import com.qiahao.nextvideo.room.dialog.UserInfoBottomSheetDialog;
import com.qiahao.nextvideo.room.help.AudioGameHelp;
import com.qiahao.nextvideo.room.help.AudioRoomDialogHelp;
import com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp;
import com.qiahao.nextvideo.room.help.EnvelopeHelper;
import com.qiahao.nextvideo.room.help.FullGiftHelper;
import com.qiahao.nextvideo.room.help.Pk1v1Help;
import com.qiahao.nextvideo.room.help.VideoUploadManager;
import com.qiahao.nextvideo.room.help.YouTuBeHelper;
import com.qiahao.nextvideo.room.luckybox.LuckyBoxDialog;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.room.view.GlobalRoomBroadCastLayout;
import com.qiahao.nextvideo.room.view.GroupInputLayoutView;
import com.qiahao.nextvideo.room.view.micro.NewMicroView;
import com.qiahao.nextvideo.room.viewmodel.RoomViewModel;
import com.qiahao.nextvideo.ui.balloon.LikeEachOtherBalloon;
import com.qiahao.nextvideo.ui.balloon.LikeEachOtherBalloonDelegate;
import com.qiahao.nextvideo.view.PKSearchView;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.game.RoomMatchGame;
import io.agora.rtc.RtcEngine;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010(\u001a\u00020)H\u0014J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020+H\u0002J\u0006\u0010-\u001a\u00020+J\b\u0010.\u001a\u0004\u0018\u00010\u0002J\u0010\u0010/\u001a\u00020+2\u0006\u00100\u001a\u000201H\u0007J\u0010\u00102\u001a\u00020+2\u0006\u00100\u001a\u000203H\u0007J\u0010\u00104\u001a\u00020+2\u0006\u00100\u001a\u000205H\u0007J\u0018\u00106\u001a\u0002072\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020+\u0018\u000109J\u0018\u0010:\u001a\u00020+2\u0010\b\u0002\u0010;\u001a\n\u0012\u0004\u0012\u00020+\u0018\u000109J\u0006\u0010<\u001a\u000207J\b\u0010=\u001a\u00020+H\u0016J\b\u0010>\u001a\u00020+H\u0016J-\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u00020)2\u000e\u0010A\u001a\n\u0012\u0006\b\u0001\u0012\u00020C0B2\u0006\u0010D\u001a\u00020EH\u0016¢\u0006\u0002\u0010FJ\b\u0010G\u001a\u00020+H\u0007J\"\u0010H\u001a\u00020+2\u0006\u0010@\u001a\u00020)2\u0006\u0010I\u001a\u00020)2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010L\u001a\u000207H\u0016J\u0006\u0010M\u001a\u00020+J\u0010\u0010N\u001a\u00020+2\b\b\u0002\u0010O\u001a\u000207J\b\u0010P\u001a\u00020+H\u0002J\b\u0010Q\u001a\u00020+H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0010\u001a\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006R"}, d2 = {"Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentAudioRoomBinding;", "<init>", "()V", "enterRoomData", "Lcom/qiahao/nextvideo/data/model/EnterRoomData;", "getEnterRoomData", "()Lcom/qiahao/nextvideo/data/model/EnterRoomData;", "setEnterRoomData", "(Lcom/qiahao/nextvideo/data/model/EnterRoomData;)V", "mViewModel", "Lcom/qiahao/nextvideo/room/viewmodel/RoomViewModel;", "getMViewModel", "()Lcom/qiahao/nextvideo/room/viewmodel/RoomViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "mAudioHelp", "Lcom/qiahao/nextvideo/room/help/AudioRoomFragmentHelp;", "getMAudioHelp", "()Lcom/qiahao/nextvideo/room/help/AudioRoomFragmentHelp;", "setMAudioHelp", "(Lcom/qiahao/nextvideo/room/help/AudioRoomFragmentHelp;)V", "mDialogHelp", "Lcom/qiahao/nextvideo/room/help/AudioRoomDialogHelp;", "getMDialogHelp", "()Lcom/qiahao/nextvideo/room/help/AudioRoomDialogHelp;", "setMDialogHelp", "(Lcom/qiahao/nextvideo/room/help/AudioRoomDialogHelp;)V", "mGameHelp", "Lcom/qiahao/nextvideo/room/help/AudioGameHelp;", "getMGameHelp", "()Lcom/qiahao/nextvideo/room/help/AudioGameHelp;", "mGameHelp$delegate", "mChatLayout", "Lcom/qiahao/hilo_message/message/RoomMessageView;", "getMChatLayout", "()Lcom/qiahao/hilo_message/message/RoomMessageView;", "setMChatLayout", "(Lcom/qiahao/hilo_message/message/RoomMessageView;)V", "getLayoutResId", "", "onInitialize", "", "initData", "initChatLayout", "getBinding", "onVideoEvent", "event", "Lcom/qiahao/base_common/model/eventBus/VideoEvent;", "onRoomEvent", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "onLiveEvent", "Lcom/qiahao/base_common/model/eventBus/LiveEvent;", "checkWriteOrStoragePermission", "", com.taobao.agoo.a.a.b.JSON_SUCCESS, "Lkotlin/Function0;", "checkMicrophonePermission", "listener", "checkMicPermission", "onResume", "onPause", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "showSoftKeyBoard", "onActivityResult", com.taobao.agoo.a.a.b.JSON_ERRORCODE, "data", "Landroid/content/Intent;", "onBackPressedIntercept", "smallRoom", "leaveRoom", "needFetchLeaveRoom", "releaseViewReference", "onDestroy", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAudioRoomFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudioRoomFragment.kt\ncom/qiahao/nextvideo/room/fragment/AudioRoomFragment\n+ 2 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 6 View.kt\nandroidx/core/view/ViewKt\n+ 7 LikeEachOtherBalloon.kt\ncom/qiahao/nextvideo/ui/balloon/LikeEachOtherBalloonKt\n*L\n1#1,628:1\n48#2:629\n1#3:630\n1869#4,2:631\n11228#5:633\n11563#5,3:634\n167#6,2:637\n35#7:639\n*S KotlinDebug\n*F\n+ 1 AudioRoomFragment.kt\ncom/qiahao/nextvideo/room/fragment/AudioRoomFragment\n*L\n164#1:629\n390#1:631,2\n526#1:633\n526#1:634,3\n107#1:637,2\n194#1:639\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AudioRoomFragment extends BaseBindingFragment<FragmentAudioRoomBinding> {

    @Nullable
    private EnterRoomData enterRoomData;

    @Nullable
    private AudioRoomFragmentHelp mAudioHelp;

    @Nullable
    private RoomMessageView mChatLayout;

    @Nullable
    private AudioRoomDialogHelp mDialogHelp;

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.fragment.c
        public final Object invoke() {
            RoomViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = AudioRoomFragment.mViewModel_delegate$lambda$0(AudioRoomFragment.this);
            return mViewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mGameHelp$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mGameHelp = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.fragment.d
        public final Object invoke() {
            AudioGameHelp mGameHelp_delegate$lambda$1;
            mGameHelp_delegate$lambda$1 = AudioRoomFragment.mGameHelp_delegate$lambda$1(AudioRoomFragment.this);
            return mGameHelp_delegate$lambda$1;
        }
    });

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void checkMicrophonePermission$default(AudioRoomFragment audioRoomFragment, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        audioRoomFragment.checkMicrophonePermission(function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean checkWriteOrStoragePermission$default(AudioRoomFragment audioRoomFragment, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        return audioRoomFragment.checkWriteOrStoragePermission(function0);
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
        IStore.DefaultImpls.setValue$default(mMKVStore, "hilo_game_open", bool, (String) null, 4, (Object) null);
        Boolean bool2 = Boolean.TRUE;
        meetingRoomManager.setShowGiftEffect(((Boolean) IStore.DefaultImpls.getValue$default(mMKVStore, "GiftEffect", bool2, (String) null, 4, (Object) null)).booleanValue());
        meetingRoomManager.setShowEnterEffect(((Boolean) IStore.DefaultImpls.getValue$default(mMKVStore, "EnterEffect", bool2, (String) null, 4, (Object) null)).booleanValue());
        meetingRoomManager.setShowRocketEffect(((Boolean) IStore.DefaultImpls.getValue$default(mMKVStore, "RocketEffect", bool2, (String) null, 4, (Object) null)).booleanValue());
    }

    public static /* synthetic */ void leaveRoom$default(AudioRoomFragment audioRoomFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        audioRoomFragment.leaveRoom(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AudioGameHelp mGameHelp_delegate$lambda$1(AudioRoomFragment audioRoomFragment) {
        return new AudioGameHelp(audioRoomFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomViewModel mViewModel_delegate$lambda$0(AudioRoomFragment audioRoomFragment) {
        return new ViewModelProvider(audioRoomFragment).get(RoomViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$3$lambda$2(AudioRoomFragment audioRoomFragment, int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        FrameLayout frameLayout;
        ConstraintLayout constraintLayout;
        FragmentAudioRoomBinding fragmentAudioRoomBinding = (FragmentAudioRoomBinding) audioRoomFragment.getBinding();
        if (fragmentAudioRoomBinding != null && (constraintLayout = fragmentAudioRoomBinding.titleBar) != null) {
            layoutParams = constraintLayout.getLayoutParams();
        } else {
            layoutParams = null;
        }
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ConstraintLayout.b) layoutParams).setMargins(0, i + UiKtxKt.toPX(10), 0, 0);
        FragmentAudioRoomBinding fragmentAudioRoomBinding2 = (FragmentAudioRoomBinding) audioRoomFragment.getBinding();
        if (fragmentAudioRoomBinding2 != null && (frameLayout = fragmentAudioRoomBinding2.frameLayout) != null) {
            frameLayout.setPadding(0, 0, 0, i2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onVideoEvent$lambda$10(final AudioRoomFragment audioRoomFragment, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "remoteUser");
        Activity activity = HiloUtils.INSTANCE.getActivity(audioRoomFragment.getContext());
        if (activity != null) {
            LikeEachOtherBalloon.Builder builder = new LikeEachOtherBalloon.Builder(activity);
            User user = (User) apiResponse.getData();
            if (user != null) {
                builder.setRemoteUser(user);
            }
            builder.setLocalUser(builder.getLocalUser());
            builder.setDelegate(new LikeEachOtherBalloonDelegate() { // from class: com.qiahao.nextvideo.room.fragment.AudioRoomFragment$onVideoEvent$1$1$1$2
                @Override // com.qiahao.nextvideo.ui.balloon.LikeEachOtherBalloonDelegate
                public void likeEachClick(User remoteUser) {
                    String str;
                    String externalId;
                    AudioRoomDialogHelp mDialogHelp = AudioRoomFragment.this.getMDialogHelp();
                    if (mDialogHelp != null) {
                        String str2 = "";
                        if (remoteUser == null || (str = remoteUser.getExternalId()) == null) {
                            str = "";
                        }
                        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                        if (remoteUser != null && (externalId = remoteUser.getExternalId()) != null) {
                            str2 = externalId;
                        }
                        mDialogHelp.showUserInfoDialog(str, meetingRoomManager.findMicPositionFromExtraId(str2));
                    }
                }
            });
            builder.build().show(activity);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onVideoEvent$lambda$11(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    private final void releaseViewReference() {
        PKSearchView pKSearchView;
        FrameLayout frameLayout;
        GlobalRoomBroadCastLayout globalRoomBroadCastLayout;
        LightQueueCombinationPlayer lightQueueCombinationPlayer;
        RoomMessageView roomMessageView = this.mChatLayout;
        if (roomMessageView != null) {
            roomMessageView.destroy();
        }
        FragmentAudioRoomBinding fragmentAudioRoomBinding = (FragmentAudioRoomBinding) getBinding();
        if (fragmentAudioRoomBinding != null && (lightQueueCombinationPlayer = fragmentAudioRoomBinding.queuePlayer) != null) {
            lightQueueCombinationPlayer.onCleared();
        }
        FragmentAudioRoomBinding fragmentAudioRoomBinding2 = (FragmentAudioRoomBinding) getBinding();
        if (fragmentAudioRoomBinding2 != null && (globalRoomBroadCastLayout = fragmentAudioRoomBinding2.globalRoomBroadLayout) != null) {
            globalRoomBroadCastLayout.release();
        }
        FragmentAudioRoomBinding fragmentAudioRoomBinding3 = (FragmentAudioRoomBinding) getBinding();
        if (fragmentAudioRoomBinding3 != null && (frameLayout = fragmentAudioRoomBinding3.chatBack) != null) {
            frameLayout.removeAllViews();
        }
        FragmentAudioRoomBinding fragmentAudioRoomBinding4 = (FragmentAudioRoomBinding) getBinding();
        if (fragmentAudioRoomBinding4 != null && (pKSearchView = fragmentAudioRoomBinding4.pkSearch) != null) {
            pKSearchView.stopAnimation();
        }
        AudioRoomFragmentHelp audioRoomFragmentHelp = this.mAudioHelp;
        if (audioRoomFragmentHelp != null) {
            audioRoomFragmentHelp.release();
        }
        AudioRoomDialogHelp audioRoomDialogHelp = this.mDialogHelp;
        if (audioRoomDialogHelp != null) {
            audioRoomDialogHelp.release();
        }
        AudioGameHelp mGameHelp = getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.releaseAnimation();
        }
        FragmentAudioRoomBinding fragmentAudioRoomBinding5 = (FragmentAudioRoomBinding) getBinding();
        if (fragmentAudioRoomBinding5 != null) {
            fragmentAudioRoomBinding5.unbind();
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public final boolean checkMicPermission() {
        FragmentActivity activity = getActivity();
        if (activity == null || !w9.h.m(activity, fa.b.o())) {
            return false;
        }
        return true;
    }

    public final void checkMicrophonePermission(@Nullable Function0<Unit> listener) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (!checkMicPermission()) {
                new PermissionMicDialog(activity, new AudioRoomFragment$checkMicrophonePermission$1$1(activity, listener)).show();
                return;
            }
            AudioRoomFragmentHelp audioRoomFragmentHelp = this.mAudioHelp;
            if (audioRoomFragmentHelp != null) {
                AudioRoomFragmentHelp.showToastOrLog$default(audioRoomFragmentHelp, null, "checkMicrophonePermission: 您已经申请了权限!", false, 5, null);
            }
            if (listener != null) {
                listener.invoke();
            }
        }
    }

    public final boolean checkWriteOrStoragePermission(@Nullable final Function0<Unit> success) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(fa.b.k());
            arrayList.add(fa.b.l());
            arrayList.add(fa.b.j());
            arrayList.add(fa.b.m());
            arrayList.add(fa.b.p());
            boolean n = w9.h.n(activity, arrayList);
            if (!n) {
                w9.h.t(activity).q(arrayList).j(new PermissionInterceptor()).r(new w9.c() { // from class: com.qiahao.nextvideo.room.fragment.AudioRoomFragment$checkWriteOrStoragePermission$permission$1$1
                    public void onResult(List<? extends IPermission> grantedList, List<? extends IPermission> deniedList) {
                        Function0<Unit> function0;
                        Intrinsics.checkNotNullParameter(grantedList, "grantedList");
                        Intrinsics.checkNotNullParameter(deniedList, "deniedList");
                        if (deniedList.isEmpty() && (function0 = success) != null) {
                            function0.invoke();
                        }
                    }
                });
                return n;
            }
            return n;
        }
        return false;
    }

    @Nullable
    public final FragmentAudioRoomBinding getBinding() {
        return (FragmentAudioRoomBinding) getBinding();
    }

    @Nullable
    public final EnterRoomData getEnterRoomData() {
        return this.enterRoomData;
    }

    protected int getLayoutResId() {
        return R.layout.fragment_audio_room;
    }

    @Nullable
    public final AudioRoomFragmentHelp getMAudioHelp() {
        return this.mAudioHelp;
    }

    @Nullable
    public final RoomMessageView getMChatLayout() {
        return this.mChatLayout;
    }

    @Nullable
    public final AudioRoomDialogHelp getMDialogHelp() {
        return this.mDialogHelp;
    }

    @Nullable
    public final AudioGameHelp getMGameHelp() {
        return (AudioGameHelp) this.mGameHelp.getValue();
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
        ViewParent viewParent2 = null;
        if (this.mChatLayout == null && (context = getContext()) != null) {
            final RoomMessageView roomMessageView = new RoomMessageView(context);
            EnterRoomData enterRoomData = this.enterRoomData;
            if (enterRoomData != null && enterRoomData.isForSmallRoom()) {
                roomMessageView.addData(MeetingRoomManager.INSTANCE.getMRoomMessageData());
                RoomMessageView.scrollToBottom$default(roomMessageView, true, false, 2, (Object) null);
            }
            roomMessageView.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.room.fragment.b
                @Override // java.lang.Runnable
                public final void run() {
                    roomMessageView.hideOrShowTab(true);
                }
            }, 500L);
            this.mChatLayout = roomMessageView;
        }
        FragmentAudioRoomBinding fragmentAudioRoomBinding = (FragmentAudioRoomBinding) getBinding();
        if (fragmentAudioRoomBinding != null && (frameLayout = fragmentAudioRoomBinding.chatBack) != null && frameLayout.getChildCount() == 0) {
            RoomMessageView roomMessageView2 = this.mChatLayout;
            if (roomMessageView2 != null) {
                viewParent = roomMessageView2.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent != null) {
                RoomMessageView roomMessageView3 = this.mChatLayout;
                if (roomMessageView3 != null) {
                    viewParent2 = roomMessageView3.getParent();
                }
                Intrinsics.checkNotNull(viewParent2, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) viewParent2).removeAllViews();
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            RoomMessageView roomMessageView4 = this.mChatLayout;
            if (roomMessageView4 != null) {
                roomMessageView4.setPaddingRelative(0, UiKtxKt.toPX(5), 0, 0);
            }
            FragmentAudioRoomBinding fragmentAudioRoomBinding2 = (FragmentAudioRoomBinding) getBinding();
            if (fragmentAudioRoomBinding2 != null && (frameLayout2 = fragmentAudioRoomBinding2.chatBack) != null) {
                frameLayout2.addView((View) this.mChatLayout, (ViewGroup.LayoutParams) layoutParams);
            }
        }
    }

    public final void leaveRoom(boolean needFetchLeaveRoom) {
        Pk1v1Help mPk1v1Help;
        EnvelopeHelper mEnvelopeHelper;
        AudioRoomFragmentHelp audioRoomFragmentHelp = this.mAudioHelp;
        if (audioRoomFragmentHelp != null) {
            AudioRoomFragmentHelp.showToastOrLog$default(audioRoomFragmentHelp, null, "leaveRoomAfterPreper: 离开房间", true, 1, null);
        }
        WebSocketProvide webSocketProvide = WebSocketProvide.INSTANCE;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        WebSocketProvide.roomWebSocket$default(webSocketProvide, 153, meetingRoomManager.getMGroupId(), null, null, 12, null);
        AudioGameHelp mGameHelp = getMGameHelp();
        if (mGameHelp != null && (mEnvelopeHelper = mGameHelp.getMEnvelopeHelper()) != null) {
            mEnvelopeHelper.releaseEnvelope();
        }
        AudioGameHelp mGameHelp2 = getMGameHelp();
        if (mGameHelp2 != null) {
            AudioGameHelp.releaseGame$default(mGameHelp2, false, true, 1, null);
        }
        AudioGameHelp mGameHelp3 = getMGameHelp();
        if (mGameHelp3 != null && (mPk1v1Help = mGameHelp3.getMPk1v1Help()) != null) {
            mPk1v1Help.release();
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

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String str;
        GroupInputLayoutView groupInputLayoutView;
        GroupInputLayoutView groupInputLayoutView2;
        String stringExtra;
        super/*com.oudi.core.component.SuperFragment*/.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 3 && resultCode == -1) {
            String str2 = "";
            if (data == null || (str = data.getStringExtra("user_name")) == null) {
                str = "";
            }
            if (data != null && (stringExtra = data.getStringExtra("user_id")) != null) {
                str2 = stringExtra;
            }
            if (str.length() != 0 && str2.length() != 0) {
                AudioRoomFragmentHelp audioRoomFragmentHelp = this.mAudioHelp;
                if (audioRoomFragmentHelp != null) {
                    audioRoomFragmentHelp.setShow(false);
                }
                FragmentAudioRoomBinding fragmentAudioRoomBinding = (FragmentAudioRoomBinding) getBinding();
                if (fragmentAudioRoomBinding != null && (groupInputLayoutView2 = fragmentAudioRoomBinding.groupInput) != null) {
                    groupInputLayoutView2.updateInputText(str, str2, false);
                }
                FragmentAudioRoomBinding fragmentAudioRoomBinding2 = (FragmentAudioRoomBinding) getBinding();
                if (fragmentAudioRoomBinding2 != null && (groupInputLayoutView = fragmentAudioRoomBinding2.groupInput) != null) {
                    groupInputLayoutView.showSoftInput();
                }
            }
        }
    }

    public boolean onBackPressedIntercept() {
        smallRoom();
        return true;
    }

    public void onDestroy() {
        CoroutineScope fragmentScope;
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        AudioRoomFragmentHelp audioRoomFragmentHelp = this.mAudioHelp;
        if (audioRoomFragmentHelp != null && (fragmentScope = audioRoomFragmentHelp.getFragmentScope()) != null) {
            CoroutineScopeKt.cancel$default(fragmentScope, (CancellationException) null, 1, (Object) null);
        }
    }

    public void onInitialize() {
        ConstraintLayout constraintLayout;
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        FragmentAudioRoomBinding fragmentAudioRoomBinding = (FragmentAudioRoomBinding) getBinding();
        if (fragmentAudioRoomBinding != null && (constraintLayout = fragmentAudioRoomBinding.titleBar) != null) {
            getStatusBarTopOrBottom(constraintLayout, new Function2() { // from class: com.qiahao.nextvideo.room.fragment.a
                public final Object invoke(Object obj, Object obj2) {
                    Unit onInitialize$lambda$3$lambda$2;
                    onInitialize$lambda$3$lambda$2 = AudioRoomFragment.onInitialize$lambda$3$lambda$2(AudioRoomFragment.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                    return onInitialize$lambda$3$lambda$2;
                }
            });
        }
        cf.c.c().l(new ChatRoomStatusEvent("bind_service", (Object) null, 2, (DefaultConstructorMarker) null));
        try {
            initData();
            initChatLayout();
            AudioRoomFragmentHelp audioRoomFragmentHelp = new AudioRoomFragmentHelp(this);
            this.mAudioHelp = audioRoomFragmentHelp;
            audioRoomFragmentHelp.initHelp();
            this.mDialogHelp = new AudioRoomDialogHelp(this);
        } catch (Exception e) {
            LogUtil logUtil = LogUtil.INSTANCE;
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            LogUtil.e$default(logUtil, "AudioRoomFragment", message, false, 4, (Object) null);
            BaseActivity activity = HiloUtils.INSTANCE.getActivity(getContext());
            if (activity != null) {
                activity.finish();
            }
        }
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onLiveEvent(@NotNull final LiveEvent event) {
        Context context;
        List msgBody;
        MsgBody msgBody2;
        CustomElemContent customContent;
        int i;
        Context context2;
        int i2;
        NewMicroView newMicroView;
        String externalId;
        AudioGameHelp mGameHelp;
        EnvelopeHelper mEnvelopeHelper;
        AudioRoomFragmentHelp audioRoomFragmentHelp;
        AudioRoomDialogHelp audioRoomDialogHelp;
        ImageView imageView;
        ImageView imageView2;
        Intrinsics.checkNotNullParameter(event, "event");
        String type = event.getType();
        String str = "";
        int i3 = 0;
        boolean z = false;
        switch (type.hashCode()) {
            case -1738072003:
                if (type.equals("two_subscribActivity") && (context = getContext()) != null) {
                    new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(this, 2131951950)).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131952331)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.fragment.AudioRoomFragment$onLiveEvent$2$1
                        public void cancel() {
                            OnCommonDialogListener.DefaultImpls.cancel(this);
                        }

                        public void confirm() {
                            if (event.getData() instanceof ActivityDetailData) {
                                MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                                Object data = event.getData();
                                Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.qiahao.base_common.model.ActivityDetailData");
                                meetingRoomManager.subscribActivity((ActivityDetailData) data);
                            }
                        }
                    }).show();
                    return;
                }
                return;
            case -560718166:
                if (type.equals("subscribActivity") && (event.getData() instanceof ActivityDetailData)) {
                    MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                    Object data = event.getData();
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.qiahao.base_common.model.ActivityDetailData");
                    meetingRoomManager.subscribActivity((ActivityDetailData) data);
                    return;
                }
                return;
            case -261741676:
                if (type.equals("refreshSubActivity") && (event.getData() instanceof ActivityDetailData)) {
                    Object data2 = event.getData();
                    Intrinsics.checkNotNull(data2, "null cannot be cast to non-null type com.qiahao.base_common.model.ActivityDetailData");
                    ActivityDetailData activityDetailData = (ActivityDetailData) data2;
                    RoomMessageView roomMessageView = this.mChatLayout;
                    if (roomMessageView != null) {
                        String messageId = activityDetailData.getMessageId();
                        if (messageId != null) {
                            str = messageId;
                        }
                        RoomMessageMulti messageById = roomMessageView.getMessageById(str);
                        if (messageById != null) {
                            GroupMessageNew data3 = messageById.getData();
                            if (data3 != null && (msgBody = data3.getMsgBody()) != null && (msgBody2 = (MsgBody) msgBody.get(0)) != null && (customContent = msgBody2.getCustomContent()) != null) {
                                customContent.setData(BaseApplication.Companion.getGSON().s(activityDetailData));
                            }
                            RoomMessageView roomMessageView2 = this.mChatLayout;
                            if (roomMessageView2 != null) {
                                roomMessageView2.refreshMessageStatus(messageById);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case -165873567:
                if (type.equals("join_match_game") && (event.getData() instanceof RoomMatchGame)) {
                    Object data4 = event.getData();
                    Intrinsics.checkNotNull(data4, "null cannot be cast to non-null type com.tencent.qcloud.tuikit.tuichat.hilo.bean.game.RoomMatchGame");
                    RoomMatchGame roomMatchGame = (RoomMatchGame) data4;
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
            case 743891007:
                if (type.equals("open_lucky_box") && (context2 = getContext()) != null) {
                    new LuckyBoxDialog(getMViewModel().getMGroupId(), context2, 0, 4, null).show();
                    return;
                }
                return;
            case 1303516781:
                if (type.equals("local_mute") && (event.getData() instanceof String)) {
                    MeetingRoomManager meetingRoomManager2 = MeetingRoomManager.INSTANCE;
                    Object data5 = event.getData();
                    Intrinsics.checkNotNull(data5, "null cannot be cast to non-null type kotlin.String");
                    int findMicPositionFromExtraId = meetingRoomManager2.findMicPositionFromExtraId((String) data5);
                    MicroBean microBean = (MicroBean) MeetingRoomManager.getMicQueue$default(meetingRoomManager2, false, 1, null).get(Integer.valueOf(findMicPositionFromExtraId));
                    if (microBean != null && (externalId = microBean.getExternalId()) != null) {
                        str = externalId;
                    }
                    if (microBean != null) {
                        i2 = microBean.getAgoraId();
                    } else {
                        i2 = 0;
                    }
                    if (microBean != null) {
                        z = microBean.getMicForbid();
                    }
                    meetingRoomManager2.localMute(str, i2, z);
                    FragmentAudioRoomBinding fragmentAudioRoomBinding = (FragmentAudioRoomBinding) getBinding();
                    if (fragmentAudioRoomBinding != null && (newMicroView = fragmentAudioRoomBinding.microView) != null) {
                        newMicroView.refreshMicByPosition(findMicPositionFromExtraId);
                    }
                    AudioGameHelp mGameHelp2 = getMGameHelp();
                    if (mGameHelp2 != null) {
                        mGameHelp2.refreshPosition(findMicPositionFromExtraId - 1);
                        return;
                    }
                    return;
                }
                return;
            case 1446544220:
                if (type.equals("EXIT_ROOM") && (event.getData() instanceof UserProxy1.QuitRoom)) {
                    Object data6 = event.getData();
                    Intrinsics.checkNotNull(data6, "null cannot be cast to non-null type userProxy.UserProxy1.QuitRoom");
                    UserProxy1.QuitRoom quitRoom = (UserProxy1.QuitRoom) data6;
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
                        Context context3 = getContext();
                        String format = String.format(ResourcesKtxKt.getStringById(this, 2131952985), Arrays.copyOf(new Object[]{AgooConstants.ACK_REMOVE_PACKAGE}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        Toast normal$default2 = HiloToasty.Companion.normal$default(companion, context3, format, false, 4, (Object) null);
                        if (normal$default2 != null) {
                            normal$default2.show();
                        }
                    }
                    MeetingRoomManager.INSTANCE.getWsFlow().tryEmit(new RoomEvent().closeRoomFloatView());
                    leaveRoom(true);
                    return;
                }
                return;
            case 1515402407:
                if (type.equals("click_envelope") && (mGameHelp = getMGameHelp()) != null && (mEnvelopeHelper = mGameHelp.getMEnvelopeHelper()) != null) {
                    mEnvelopeHelper.checkEnvelope(false);
                    return;
                }
                return;
            case 1545944263:
                if (type.equals("open_game") && (event.getData() instanceof String)) {
                    Object data7 = event.getData();
                    if (Intrinsics.areEqual(data7, "101")) {
                        AudioRoomFragmentHelp audioRoomFragmentHelp2 = this.mAudioHelp;
                        if (audioRoomFragmentHelp2 != null) {
                            audioRoomFragmentHelp2.showLudoGameView();
                            return;
                        }
                        return;
                    }
                    if (Intrinsics.areEqual(data7, "102")) {
                        AudioRoomFragmentHelp audioRoomFragmentHelp3 = this.mAudioHelp;
                        if (audioRoomFragmentHelp3 != null) {
                            audioRoomFragmentHelp3.showUnoGameView();
                            return;
                        }
                        return;
                    }
                    if (Intrinsics.areEqual(data7, "103")) {
                        AudioRoomFragmentHelp audioRoomFragmentHelp4 = this.mAudioHelp;
                        if (audioRoomFragmentHelp4 != null) {
                            audioRoomFragmentHelp4.showDominoGameView();
                            return;
                        }
                        return;
                    }
                    if (Intrinsics.areEqual(data7, "104")) {
                        AudioRoomFragmentHelp audioRoomFragmentHelp5 = this.mAudioHelp;
                        if (audioRoomFragmentHelp5 != null) {
                            audioRoomFragmentHelp5.showCrushGameView();
                            return;
                        }
                        return;
                    }
                    if (Intrinsics.areEqual(data7, "124")) {
                        AudioRoomFragmentHelp audioRoomFragmentHelp6 = this.mAudioHelp;
                        if (audioRoomFragmentHelp6 != null) {
                            audioRoomFragmentHelp6.showBalootGameView();
                            return;
                        }
                        return;
                    }
                    if (Intrinsics.areEqual(data7, "127")) {
                        AudioRoomFragmentHelp audioRoomFragmentHelp7 = this.mAudioHelp;
                        if (audioRoomFragmentHelp7 != null) {
                            audioRoomFragmentHelp7.showCarromGameView();
                            return;
                        }
                        return;
                    }
                    if (Intrinsics.areEqual(data7, "131")) {
                        AudioRoomFragmentHelp audioRoomFragmentHelp8 = this.mAudioHelp;
                        if (audioRoomFragmentHelp8 != null) {
                            audioRoomFragmentHelp8.showJackaroGameView();
                            return;
                        }
                        return;
                    }
                    if (Intrinsics.areEqual(data7, "133") && (audioRoomFragmentHelp = this.mAudioHelp) != null) {
                        audioRoomFragmentHelp.showBackgammonGameView();
                        return;
                    }
                    return;
                }
                return;
            case 1918470536:
                if (type.equals("open_lucky_fruit") && (audioRoomDialogHelp = this.mDialogHelp) != null) {
                    audioRoomDialogHelp.showLuckyFruitDialog();
                    return;
                }
                return;
            case 2000680663:
                if (type.equals("REFRESH_DIAMOND_GAME_ICON") && (event.getData() instanceof Integer)) {
                    Object data8 = event.getData();
                    Intrinsics.checkNotNull(data8, "null cannot be cast to non-null type kotlin.Int");
                    int intValue = ((Integer) data8).intValue();
                    ArrayList<GameConfiguration> arrayList = (ArrayList) getMViewModel().getMDiamondGameList().getValue();
                    if (arrayList != null) {
                        for (GameConfiguration gameConfiguration : arrayList) {
                            Integer gameId2 = gameConfiguration.getGameId();
                            if (gameId2 != null && gameId2.intValue() == intValue && MeetingRoomManager.INSTANCE.isLuckyGame(intValue)) {
                                FragmentAudioRoomBinding binding = getBinding();
                                if (binding != null && (imageView2 = binding.diamondGame) != null) {
                                    imageView2.setVisibility(0);
                                }
                                FragmentAudioRoomBinding binding2 = getBinding();
                                if (binding2 != null && (imageView = binding2.diamondGame) != null) {
                                    ImageKtxKt.loadImage$default(imageView, gameConfiguration.getIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onPause() {
        FullGiftHelper fullGiftHelper;
        PlayerConstants.PlayerState playerState;
        AudioGameHelp mGameHelp;
        YouTuBeHelper mYouTuBe;
        YouTuBeHelper mYouTuBe2;
        super/*com.qiahao.base_common.common.BaseFragment*/.onPause();
        if (MeetingRoomManager.INSTANCE.checkOwnOrManager()) {
            AudioGameHelp mGameHelp2 = getMGameHelp();
            if (mGameHelp2 != null && (mYouTuBe2 = mGameHelp2.getMYouTuBe()) != null) {
                playerState = mYouTuBe2.getMState();
            } else {
                playerState = null;
            }
            if (playerState == PlayerConstants.PlayerState.PLAYING && (mGameHelp = getMGameHelp()) != null && (mYouTuBe = mGameHelp.getMYouTuBe()) != null) {
                mYouTuBe.setMOwnResume(true);
            }
        }
        AudioRoomFragmentHelp audioRoomFragmentHelp = this.mAudioHelp;
        if (audioRoomFragmentHelp != null && (fullGiftHelper = audioRoomFragmentHelp.getFullGiftHelper()) != null) {
            fullGiftHelper.destroy();
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Context context;
        UserInfoBottomSheetDialog mUserInfoBottomSheetDialog;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super/*androidx.fragment.app.Fragment*/.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101) {
            if (grantResults.length == 0) {
                MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                User user = UserStore.INSTANCE.getShared().getUser();
                if (user == null || (str2 = user.getExternalId()) == null) {
                    str2 = "";
                }
                if (meetingRoomManager.checkUserOnMic(str2)) {
                    AudioRoomDialogHelp audioRoomDialogHelp = this.mDialogHelp;
                    if (audioRoomDialogHelp != null) {
                        audioRoomDialogHelp.showGroupMusicDialog();
                    }
                } else {
                    AudioRoomFragmentHelp audioRoomFragmentHelp = this.mAudioHelp;
                    if (audioRoomFragmentHelp != null) {
                        AudioRoomFragmentHelp.showToastOrLog$default(audioRoomFragmentHelp, ResourcesKtxKt.getStringById(this, 2131953694), null, false, 6, null);
                    }
                }
            } else if (grantResults[0] == 0) {
                MeetingRoomManager meetingRoomManager2 = MeetingRoomManager.INSTANCE;
                User user2 = UserStore.INSTANCE.getShared().getUser();
                if (user2 != null) {
                    str = user2.getExternalId();
                } else {
                    str = null;
                }
                if (meetingRoomManager2.checkUserOnMic(str)) {
                    AudioRoomDialogHelp audioRoomDialogHelp2 = this.mDialogHelp;
                    if (audioRoomDialogHelp2 != null) {
                        audioRoomDialogHelp2.showGroupMusicDialog();
                    }
                } else {
                    AudioRoomFragmentHelp audioRoomFragmentHelp2 = this.mAudioHelp;
                    if (audioRoomFragmentHelp2 != null) {
                        AudioRoomFragmentHelp.showToastOrLog$default(audioRoomFragmentHelp2, ResourcesKtxKt.getStringById(this, 2131953694), null, false, 6, null);
                    }
                }
            } else {
                AudioRoomFragmentHelp audioRoomFragmentHelp3 = this.mAudioHelp;
                if (audioRoomFragmentHelp3 != null) {
                    AudioRoomFragmentHelp.showToastOrLog$default(audioRoomFragmentHelp3, ResourcesKtxKt.getStringById(this, 2131953622), null, false, 6, null);
                }
            }
        }
        if (requestCode == 102 && (context = getContext()) != null) {
            ArrayList arrayList = new ArrayList(permissions.length);
            for (String str3 : permissions) {
                arrayList.add(Integer.valueOf(androidx.core.content.a.checkSelfPermission(context, str3)));
            }
            if (ArraysKt.contains(CollectionsKt.toIntArray(arrayList), -1)) {
                AudioRoomFragmentHelp audioRoomFragmentHelp4 = this.mAudioHelp;
                if (audioRoomFragmentHelp4 != null) {
                    AudioRoomFragmentHelp.showToastOrLog$default(audioRoomFragmentHelp4, ResourcesKtxKt.getStringById(this, 2131953622), null, false, 6, null);
                    return;
                }
                return;
            }
            AudioRoomDialogHelp audioRoomDialogHelp3 = this.mDialogHelp;
            if (audioRoomDialogHelp3 != null && (mUserInfoBottomSheetDialog = audioRoomDialogHelp3.getMUserInfoBottomSheetDialog()) != null) {
                mUserInfoBottomSheetDialog.toVideoCurrent();
            }
        }
    }

    public void onResume() {
        RtcEngine rtcEngine;
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
        if (agoraRtcService.getRtcEngineInit() && (rtcEngine = agoraRtcService.getRtcEngine()) != null) {
            rtcEngine.disableVideo();
        }
        if (MeetingRoomManager.INSTANCE.getMYouTuBe() != null) {
            getMViewModel().youTuBeProcess();
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
                    FragmentAudioRoomBinding binding = getBinding();
                    if (binding != null && (imageView2 = binding.meetingRoomThemBackGroup) != null) {
                        GroupDetailBean groupDetailBean4 = (GroupDetailBean) getMViewModel().getMGroupDetailBean().getValue();
                        if (groupDetailBean4 != null) {
                            str = groupDetailBean4.getThemeUrl();
                        }
                        ImageKtxKt.loadImage$default(imageView2, ImageSizeKt.imageSize(str, UiKtxKt.toPX(375)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(R.drawable.bg_meeting_room1), (c5.g) null, 49150, (Object) null);
                        return;
                    }
                    return;
                }
            }
            FragmentAudioRoomBinding binding2 = getBinding();
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

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onVideoEvent(@NotNull VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getType(), "LIKE_EACH_OTHER")) {
            try {
                UserService shared = UserService.INSTANCE.getShared();
                Object data = event.getData();
                Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.String");
                RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.fetchUserDetail$default(shared, (String) data, null, 2, null), new Function1() { // from class: com.qiahao.nextvideo.room.fragment.e
                    public final Object invoke(Object obj) {
                        Unit onVideoEvent$lambda$10;
                        onVideoEvent$lambda$10 = AudioRoomFragment.onVideoEvent$lambda$10(AudioRoomFragment.this, (ApiResponse) obj);
                        return onVideoEvent$lambda$10;
                    }
                }, new Function1() { // from class: com.qiahao.nextvideo.room.fragment.f
                    public final Object invoke(Object obj) {
                        Unit onVideoEvent$lambda$11;
                        onVideoEvent$lambda$11 = AudioRoomFragment.onVideoEvent$lambda$11((Throwable) obj);
                        return onVideoEvent$lambda$11;
                    }
                }, (Function0) null, false, 12, (Object) null), getMViewModel().getMCompositeDisposable());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void setEnterRoomData(@Nullable EnterRoomData enterRoomData) {
        this.enterRoomData = enterRoomData;
    }

    public final void setMAudioHelp(@Nullable AudioRoomFragmentHelp audioRoomFragmentHelp) {
        this.mAudioHelp = audioRoomFragmentHelp;
    }

    public final void setMChatLayout(@Nullable RoomMessageView roomMessageView) {
        this.mChatLayout = roomMessageView;
    }

    public final void setMDialogHelp(@Nullable AudioRoomDialogHelp audioRoomDialogHelp) {
        this.mDialogHelp = audioRoomDialogHelp;
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
        FragmentAudioRoomBinding fragmentAudioRoomBinding = (FragmentAudioRoomBinding) getBinding();
        if (fragmentAudioRoomBinding != null) {
            groupInputLayoutView = fragmentAudioRoomBinding.groupInput;
        } else {
            groupInputLayoutView = null;
        }
        inputMethodManager.showSoftInput(groupInputLayoutView, 2);
        FragmentAudioRoomBinding fragmentAudioRoomBinding2 = (FragmentAudioRoomBinding) getBinding();
        if (fragmentAudioRoomBinding2 != null && (groupInputLayoutView2 = fragmentAudioRoomBinding2.groupInput) != null) {
            iBinder = groupInputLayoutView2.getWindowToken();
        }
        inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
        inputMethodManager.toggleSoftInput(0, 2);
    }

    public final void smallRoom() {
        Collection<? extends RoomMessageMulti> arrayList;
        RoomMessageAdapter mAdapter;
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        AudioRoomFragmentHelp audioRoomFragmentHelp = this.mAudioHelp;
        if (audioRoomFragmentHelp != null) {
            AudioRoomFragmentHelp.showToastOrLog$default(audioRoomFragmentHelp, null, "smallRoomAfterPreper: 最小化房间", true, 1, null);
        }
        FragmentAudioRoomBinding fragmentAudioRoomBinding = (FragmentAudioRoomBinding) getBinding();
        if (fragmentAudioRoomBinding != null && (frameLayout2 = fragmentAudioRoomBinding.chatBack) != null) {
            frameLayout2.removeAllViews();
        }
        FragmentAudioRoomBinding fragmentAudioRoomBinding2 = (FragmentAudioRoomBinding) getBinding();
        if (fragmentAudioRoomBinding2 != null && (frameLayout = fragmentAudioRoomBinding2.gameChatLayout) != null) {
            frameLayout.removeAllViews();
        }
        getMViewModel().smallRoom();
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        meetingRoomManager.getMRoomMessageData().clear();
        CopyOnWriteArrayList<RoomMessageMulti> mRoomMessageData = meetingRoomManager.getMRoomMessageData();
        RoomMessageView roomMessageView = this.mChatLayout;
        if (roomMessageView == null || (mAdapter = roomMessageView.getMAdapter()) == null || (arrayList = mAdapter.getData()) == null) {
            arrayList = new ArrayList<>();
        }
        mRoomMessageData.addAll(arrayList);
        releaseViewReference();
    }
}
