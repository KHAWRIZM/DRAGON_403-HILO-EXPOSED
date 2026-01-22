package com.qiahao.nextvideo.room.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.oudi.utils.FragmentUtils;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.eventBus.ChatRoomStatusEvent;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.HiloApplication;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.model.EnterRoomData;
import com.qiahao.nextvideo.databinding.LiveRoomActivityBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.room.fragment.AudioRoomFragment;
import com.qiahao.nextvideo.room.fragment.GameRoomFragment;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.taobao.accs.messenger.MessengerService;
import com.tencent.imsdk.v2.V2TIMManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0015J\b\u0010\u000b\u001a\u00020\bH\u0014J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0002¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/RoomActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/LiveRoomActivityBinding;", "<init>", "()V", "getLayoutResId", "", "onNewIntent", "", MessengerService.INTENT, "Landroid/content/Intent;", "onCreateView", "onInitialize", "checkBluetoothPermission", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomActivity extends HiloBaseBindingActivity<LiveRoomActivityBinding> {

    @NotNull
    public static final String SERVICE_OPEN = "service_open";

    /* JADX WARN: Multi-variable type inference failed */
    private final void checkBluetoothPermission() {
        if (Build.VERSION.SDK_INT >= 31) {
            if (androidx.core.content.a.checkSelfPermission(this, "android.permission.BLUETOOTH_SCAN") != 0 || androidx.core.content.a.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") != 0) {
                androidx.core.app.b.g(this, new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"}, 22);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onNewIntent$lambda$0() {
        cf.c.c().l(new ChatRoomStatusEvent("start_service", (Object) null, 2, (DefaultConstructorMarker) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.live_room_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity
    public void onCreateView() {
        setMSetBottom(false);
        super.onCreateView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        HiloApplication.Companion companion = HiloApplication.INSTANCE;
        boolean z = false;
        if (companion.isRestartFlag() == -1) {
            companion.setRestartFlag(0);
            finish();
        }
        getWindow().addFlags(128);
        setStatusBarIconColor(false);
        String stringExtra = getIntent().getStringExtra(StartRoomUtils.ENTER_ROOM_DATA);
        BaseApplication.Companion companion2 = BaseApplication.Companion;
        EnterRoomData enterRoomData = (EnterRoomData) companion2.getGSON().j(stringExtra, EnterRoomData.class);
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        String str = (String) IStore.DefaultImpls.getValue$default(mMKVStore, SERVICE_OPEN, "", (String) null, 4, (Object) null);
        if (enterRoomData == null) {
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            if (Intrinsics.areEqual(str, meetingRoomManager.getMGroupId())) {
                enterRoomData = new EnterRoomData(str, true, 0, null, meetingRoomManager.getMPassword(), meetingRoomManager.getMRoomChannelId(), meetingRoomManager.getMAgoraToken(), meetingRoomManager.getMAgoraId(), 0, 0, null, null, false, 0, meetingRoomManager.is1V1(), 0, 48908, null);
            }
        }
        Boolean bool = Boolean.FALSE;
        IStore.DefaultImpls.setValue$default(mMKVStore, "SHOW_LUCKY_FRUIT", bool, (String) null, 4, (Object) null);
        IStore.DefaultImpls.setValue$default(mMKVStore, "show_foodie", bool, (String) null, 4, (Object) null);
        Fragment fragment = null;
        if (enterRoomData == null || !enterRoomData.isForSmallRoom()) {
            MeetingRoomManager meetingRoomManager2 = MeetingRoomManager.INSTANCE;
            meetingRoomManager2.setMRoomMute(false);
            meetingRoomManager2.setMOldPKGameID(-1);
            V2TIMManager.getMessageManager().clearGroupHistoryMessage(meetingRoomManager2.getMGroupId(), null);
        }
        Bundle bundle = new Bundle();
        bundle.putString(StartRoomUtils.ENTER_ROOM_DATA, companion2.getGSON().s(enterRoomData));
        MeetingRoomManager meetingRoomManager3 = MeetingRoomManager.INSTANCE;
        if (enterRoomData != null) {
            z = enterRoomData.is1V1();
        }
        meetingRoomManager3.set1V1(z);
        if (enterRoomData != null && !enterRoomData.is1V1()) {
            AudioRoomFragment audioRoomFragment = new AudioRoomFragment();
            audioRoomFragment.setArguments(bundle);
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("AudioRoomFragment");
            if (findFragmentByTag instanceof AudioRoomFragment) {
                fragment = (AudioRoomFragment) findFragmentByTag;
            }
            if (fragment != null) {
                FragmentUtils fragmentUtils = FragmentUtils.INSTANCE;
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                fragmentUtils.removeFragment(supportFragmentManager, fragment);
            }
            FragmentUtils fragmentUtils2 = FragmentUtils.INSTANCE;
            FragmentManager supportFragmentManager2 = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
            FragmentUtils.showFragment$default(fragmentUtils2, supportFragmentManager2, audioRoomFragment, R.id.activity_main_container, false, false, "AudioRoomFragment", 24, (Object) null);
        } else {
            GameRoomFragment gameRoomFragment = new GameRoomFragment();
            gameRoomFragment.setArguments(bundle);
            Fragment findFragmentByTag2 = getSupportFragmentManager().findFragmentByTag("GameRoomFragment");
            if (findFragmentByTag2 instanceof GameRoomFragment) {
                fragment = (GameRoomFragment) findFragmentByTag2;
            }
            if (fragment != null) {
                FragmentUtils fragmentUtils3 = FragmentUtils.INSTANCE;
                FragmentManager supportFragmentManager3 = getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager3, "getSupportFragmentManager(...)");
                fragmentUtils3.removeFragment(supportFragmentManager3, fragment);
            }
            FragmentUtils fragmentUtils4 = FragmentUtils.INSTANCE;
            FragmentManager supportFragmentManager4 = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager4, "getSupportFragmentManager(...)");
            FragmentUtils.showFragment$default(fragmentUtils4, supportFragmentManager4, gameRoomFragment, R.id.activity_main_container, false, false, "GameRoomFragment", 24, (Object) null);
        }
        checkBluetoothPermission();
    }

    @SuppressLint({"MissingSuperCall"})
    protected void onNewIntent(@Nullable Intent intent) {
        super/*androidx.activity.ComponentActivity*/.onNewIntent(intent);
        cf.c.c().l(new ChatRoomStatusEvent("stop_service", (Object) null, 2, (DefaultConstructorMarker) null));
        cf.c.c().l(new ChatRoomStatusEvent("bind_service", (Object) null, 2, (DefaultConstructorMarker) null));
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.room.activity.z0
            @Override // java.lang.Runnable
            public final void run() {
                RoomActivity.onNewIntent$lambda$0();
            }
        }, 1500L);
    }
}
