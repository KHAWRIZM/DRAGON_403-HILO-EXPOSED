package com.qiahao.nextvideo.room.help;

import android.text.TextUtils;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.hilo_message.data.RoomTip;
import com.qiahao.hilo_message.message.RoomMessageView;
import com.qiahao.hilo_message.utils.BuildMessageUtilsKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.service.match.WebSocketProvide;
import com.qiahao.nextvideo.databinding.FragmentAudioRoomBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.view.micro.NewMicroView;
import com.qiahao.nextvideo.utilities.im.RoomMessageUtil;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import com.taobao.accs.common.Constants;
import com.tencent.imsdk.v2.V2TIMCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/qiahao/nextvideo/room/help/AudioRoomFragmentHelp$mJoinGroupCallBack$1", "Lcom/tencent/imsdk/v2/V2TIMCallback;", "onError", "", Constants.KEY_HTTP_CODE, "", "desc", "", "onSuccess", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AudioRoomFragmentHelp$mJoinGroupCallBack$1 implements V2TIMCallback {
    final /* synthetic */ AudioRoomFragmentHelp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioRoomFragmentHelp$mJoinGroupCallBack$1(AudioRoomFragmentHelp audioRoomFragmentHelp) {
        this.this$0 = audioRoomFragmentHelp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSuccess$lambda$1() {
        WebSocketProvide.roomWebSocket$default(WebSocketProvide.INSTANCE, UserProxyUtility.roomReady, MeetingRoomManager.INSTANCE.getMGroupId(), null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSuccess$lambda$4(AudioRoomFragmentHelp audioRoomFragmentHelp) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        User user;
        RoomMessageView mChatLayout;
        User user2;
        String welcomeText;
        User owner;
        User owner2;
        RoomMessageView mChatLayout2;
        GroupDetailBean groupDetailBean = (GroupDetailBean) audioRoomFragmentHelp.getFragment().getMViewModel().getMGroupDetailBean().getValue();
        String str6 = "";
        if (groupDetailBean == null || (str = groupDetailBean.getNotification()) == null) {
            str = "";
        }
        RoomTip roomTip = new RoomTip("1000", 2, str);
        if (!TextUtils.isEmpty(roomTip.getNotice()) && (mChatLayout2 = audioRoomFragmentHelp.getFragment().getMChatLayout()) != null) {
            RoomMessageView.addData$default(mChatLayout2, BuildMessageUtilsKt.createCustomMessage$default(MeetingRoomManager.INSTANCE.getMGroupId(), "1000", roomTip, (User) null, 0, 24, (Object) null), false, 2, (Object) null);
        }
        if (audioRoomFragmentHelp.getMIMIsInit() && !audioRoomFragmentHelp.getMInsertWelcome()) {
            GroupDetailBean groupDetailBean2 = (GroupDetailBean) audioRoomFragmentHelp.getFragment().getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean2 != null && (owner2 = groupDetailBean2.getOwner()) != null) {
                str2 = owner2.getExternalId();
            } else {
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                GroupDetailBean groupDetailBean3 = (GroupDetailBean) audioRoomFragmentHelp.getFragment().getMViewModel().getMGroupDetailBean().getValue();
                if (groupDetailBean3 != null && (owner = groupDetailBean3.getOwner()) != null) {
                    str3 = owner.getExternalId();
                } else {
                    str3 = null;
                }
                UserStore.Companion companion = UserStore.INSTANCE;
                User user3 = companion.getShared().getUser();
                if (user3 != null) {
                    str4 = user3.getExternalId();
                } else {
                    str4 = null;
                }
                if (!Intrinsics.areEqual(str3, str4)) {
                    GroupDetailBean groupDetailBean4 = (GroupDetailBean) audioRoomFragmentHelp.getFragment().getMViewModel().getMGroupDetailBean().getValue();
                    if (groupDetailBean4 == null || (str5 = groupDetailBean4.getWelcomeText()) == null) {
                        str5 = "";
                    }
                    if (TextUtils.isEmpty(str5)) {
                        return;
                    }
                    RoomMessageUtil roomMessageUtil = RoomMessageUtil.INSTANCE;
                    GroupDetailBean groupDetailBean5 = (GroupDetailBean) audioRoomFragmentHelp.getFragment().getMViewModel().getMGroupDetailBean().getValue();
                    if (groupDetailBean5 != null && (welcomeText = groupDetailBean5.getWelcomeText()) != null) {
                        str6 = welcomeText;
                    }
                    GroupDetailBean groupDetailBean6 = (GroupDetailBean) audioRoomFragmentHelp.getFragment().getMViewModel().getMGroupDetailBean().getValue();
                    if (groupDetailBean6 != null) {
                        user = groupDetailBean6.getOwner();
                    } else {
                        user = null;
                    }
                    GroupRoomImCustomBean ownWelcome = roomMessageUtil.ownWelcome(str6, user, companion.getShared().getUser());
                    if (ownWelcome != null && (mChatLayout = audioRoomFragmentHelp.getFragment().getMChatLayout()) != null) {
                        String mGroupId = MeetingRoomManager.INSTANCE.getMGroupId();
                        GroupDetailBean groupDetailBean7 = (GroupDetailBean) audioRoomFragmentHelp.getFragment().getMViewModel().getMGroupDetailBean().getValue();
                        if (groupDetailBean7 != null) {
                            user2 = groupDetailBean7.getOwner();
                        } else {
                            user2 = null;
                        }
                        RoomMessageView.addData$default(mChatLayout, BuildMessageUtilsKt.createCustomMessage(mGroupId, "106", ownWelcome, user2, 1), false, 2, (Object) null);
                    }
                }
            }
        }
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        long longValue = ((Number) IStore.DefaultImpls.getValue$default(mMKVStore, "room_task_tip_time", 0L, (String) null, 4, (Object) null)).longValue();
        long e = com.qiahao.base_common.utils.f.e();
        if (!com.qiahao.base_common.utils.f.g(e, longValue)) {
            IStore.DefaultImpls.setValue$default(mMKVStore, "room_task_tip_time", Long.valueOf(e), (String) null, 4, (Object) null);
            RoomMessageView mChatLayout3 = audioRoomFragmentHelp.getFragment().getMChatLayout();
            if (mChatLayout3 != null) {
                RoomMessageView.addData$default(mChatLayout3, BuildMessageUtilsKt.createCustomMessage$default(MeetingRoomManager.INSTANCE.getMGroupId(), "132", RoomMessageUtil.INSTANCE.roomTaskTip(), (User) null, 0, 24, (Object) null), false, 2, (Object) null);
            }
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMCallback
    public void onError(int code, String desc) {
        String str;
        RoomMessageView mChatLayout;
        this.this$0.setMIMIsInit(false);
        if (code == 10013) {
            GroupDetailBean groupDetailBean = (GroupDetailBean) this.this$0.getFragment().getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean == null || (str = groupDetailBean.getNotification()) == null) {
                str = "";
            }
            RoomTip roomTip = new RoomTip("1000", 2, str);
            AudioRoomFragmentHelp audioRoomFragmentHelp = this.this$0;
            if (!TextUtils.isEmpty(roomTip.getNotice()) && (mChatLayout = audioRoomFragmentHelp.getFragment().getMChatLayout()) != null) {
                RoomMessageView.addData$default(mChatLayout, BuildMessageUtilsKt.createCustomMessage$default(MeetingRoomManager.INSTANCE.getMGroupId(), "1000", roomTip, (User) null, 0, 24, (Object) null), false, 2, (Object) null);
            }
        }
        AudioRoomFragmentHelp.showToastOrLog$default(this.this$0, null, "onError: " + code + " " + desc, false, 5, null);
    }

    @Override // com.tencent.imsdk.v2.V2TIMCallback
    public void onSuccess() {
        NewMicroView newMicroView;
        this.this$0.setMIMIsInit(true);
        FragmentAudioRoomBinding binding = this.this$0.getFragment().getBinding();
        if (binding != null && (newMicroView = binding.microView) != null) {
            newMicroView.post(new Runnable() { // from class: com.qiahao.nextvideo.room.help.b3
                @Override // java.lang.Runnable
                public final void run() {
                    AudioRoomFragmentHelp$mJoinGroupCallBack$1.onSuccess$lambda$1();
                }
            });
        }
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        final AudioRoomFragmentHelp audioRoomFragmentHelp = this.this$0;
        hiloUtils.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.room.help.c3
            @Override // java.lang.Runnable
            public final void run() {
                AudioRoomFragmentHelp$mJoinGroupCallBack$1.onSuccess$lambda$4(AudioRoomFragmentHelp.this);
            }
        }, 1000L);
    }
}
