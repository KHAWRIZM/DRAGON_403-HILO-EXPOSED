package com.qiahao.nextvideo.ui.home.chat.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.StringKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.interfaceing.SendGiftListener;
import com.qiahao.base_common.model.GiftData;
import com.qiahao.base_common.model.common.ChannelEventGiftAddTime;
import com.qiahao.base_common.model.common.LikeResult;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.model.im.CpMessageData;
import com.qiahao.base_common.model.im.RelationMessageData;
import com.qiahao.base_common.model.im.StrangeChange;
import com.qiahao.base_common.model.im.TIMGiftMessage;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.base_common.player.vap.VapMediaSource;
import com.qiahao.base_common.player.video.VideoMediaSource;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import com.qiahao.base_common.ui.dialog.ChatMenuDialogListener;
import com.qiahao.base_common.ui.dialog.ReportWhiteDialog;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.GiftDateItem;
import com.qiahao.nextvideo.data.model.MeetingRoomCustomData;
import com.qiahao.nextvideo.databinding.ActivityChatStrangeBinding;
import com.qiahao.nextvideo.room.help.GameJum;
import com.qiahao.nextvideo.ui.cp.CpInvitationReceiveDialog;
import com.qiahao.nextvideo.ui.cp.RelationInvitationReceiveDialog;
import com.qiahao.nextvideo.ui.family.FamilyMoreDialog;
import com.qiahao.nextvideo.ui.family.FamilySettingFragment;
import com.qiahao.nextvideo.ui.home.chat.dialog.MessageMenuDialog;
import com.qiahao.nextvideo.ui.home.chat.dialog.StrangeLikeDialog;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.qiahao.nextvideo.ui.im.StrangerProvide;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.GiftHelp;
import com.taobao.accs.common.Constants;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMConversationManager;
import com.tencent.imsdk.v2.V2TIMGroupListener;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.hilo.StrangeInputView;
import com.tencent.qcloud.tuikit.tuichat.hilo.network.ChatApi;
import com.tencent.qcloud.tuikit.tuichat.hilo.network.ChatServer;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.ChatViewModel;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IMCheckDataListener;
import com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u001f\u0018\u0000 E2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001EB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010'\u001a\u00020(H\u0014J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020*H\u0002J\b\u0010,\u001a\u00020*H\u0002J\u0006\u0010-\u001a\u00020*J\b\u0010.\u001a\u00020*H\u0002J\u0012\u0010/\u001a\u00020*2\b\b\u0002\u00100\u001a\u00020\u0018H\u0002J\u0010\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020\u0012H\u0002J\u0010\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020(H\u0002J\b\u00105\u001a\u00020*H\u0002J\u0006\u00106\u001a\u00020*J$\u00107\u001a\u00020*2\b\b\u0002\u00108\u001a\u00020\u00182\b\b\u0002\u00109\u001a\u00020\u00182\b\b\u0002\u0010:\u001a\u00020\u0018J\u0006\u0010;\u001a\u00020*J\u0018\u0010<\u001a\u00020*2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020(H\u0002J\b\u0010@\u001a\u00020*H\u0002J\b\u0010A\u001a\u00020*H\u0002J\u0016\u0010B\u001a\u00020*2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020(J\b\u0010C\u001a\u00020*H\u0014J\b\u0010D\u001a\u00020*H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$¨\u0006F"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/activity/ChatStrangeActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityChatStrangeBinding;", "<init>", "()V", "presenter", "Lcom/tencent/qcloud/tuikit/tuichat/presenter/GroupChatPresenter;", "mGroupInfo", "Lcom/tencent/qcloud/tuikit/tuichat/bean/GroupInfo;", "mUser", "Lcom/qiahao/base_common/model/common/User;", "mChatScore", "Lcom/qiahao/base_common/model/im/StrangeChange;", "mLikeDialog", "Lcom/qiahao/nextvideo/ui/home/chat/dialog/StrangeLikeDialog;", "timerTask", "Landroid/os/CountDownTimer;", "mGroupId", "", "getMGroupId", "()Ljava/lang/String;", "setMGroupId", "(Ljava/lang/String;)V", "isDialog", "", "()Z", "setDialog", "(Z)V", "isStrange", "setStrange", "v2TIMGroupListener", "com/qiahao/nextvideo/ui/home/chat/activity/ChatStrangeActivity$v2TIMGroupListener$1", "Lcom/qiahao/nextvideo/ui/home/chat/activity/ChatStrangeActivity$v2TIMGroupListener$1;", "viewModel", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewModel/ChatViewModel;", "getViewModel", "()Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewModel/ChatViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getLayoutResId", "", "onInitialize", "", "initChatDialog", "initView", "initData", "initChatView", "refreshStrangeView", "isStart", "initSignaling", "str", "endPostEventBus", "closeType", "showMenuDialog", "showReportDialog", TUIConstants.TUIConversation.METHOD_DELETE_CONVERSATION, "deleteC2C", "deleteGroup", "isShowDialog", "showGiftDialog", "begGiftSuccess", "selectedGiftItem", "Lcom/qiahao/base_common/model/GiftData;", FamilySettingFragment.FAMILY_NUMBER, "videoCallButtonPressed", "requestLikeUser", "sendGift", "onPause", "onDestroy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nChatStrangeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChatStrangeActivity.kt\ncom/qiahao/nextvideo/ui/home/chat/activity/ChatStrangeActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,962:1\n61#2,9:963\n61#2,9:972\n61#2,9:981\n61#2,9:990\n1#3:999\n*S KotlinDebug\n*F\n+ 1 ChatStrangeActivity.kt\ncom/qiahao/nextvideo/ui/home/chat/activity/ChatStrangeActivity\n*L\n199#1:963,9\n202#1:972,9\n205#1:981,9\n215#1:990,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ChatStrangeActivity extends HiloBaseBindingActivity<ActivityChatStrangeBinding> {

    @NotNull
    public static final String CHAT_SCORE = "chatScore";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String GROUP_ID = "groupId";

    @NotNull
    public static final String IS_DIALOG = "isDialog";

    @NotNull
    public static final String USER = "user";
    private boolean isDialog;

    @Nullable
    private StrangeChange mChatScore;

    @Nullable
    private GroupInfo mGroupInfo;

    @Nullable
    private StrangeLikeDialog mLikeDialog;

    @Nullable
    private User mUser;

    @Nullable
    private GroupChatPresenter presenter;

    @Nullable
    private CountDownTimer timerTask;

    @NotNull
    private String mGroupId = "";
    private boolean isStrange = true;

    @NotNull
    private ChatStrangeActivity$v2TIMGroupListener$1 v2TIMGroupListener = new V2TIMGroupListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatStrangeActivity$v2TIMGroupListener$1
        @Override // com.tencent.imsdk.v2.V2TIMGroupListener
        public void onReceiveRESTCustomData(String groupID, byte[] customData) {
            String str;
            super.onReceiveRESTCustomData(groupID, customData);
            if (customData == null || (str = StringsKt.decodeToString(customData)) == null) {
                str = "";
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(ChatStrangeActivity.this.getMGroupId()) && Intrinsics.areEqual(ChatStrangeActivity.this.getMGroupId(), groupID) && !ChatStrangeActivity.this.isFinishing()) {
                ChatStrangeActivity.this.initSignaling(str);
            }
        }
    };

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.f1
        public final Object invoke() {
            ChatViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = ChatStrangeActivity.viewModel_delegate$lambda$0(ChatStrangeActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/activity/ChatStrangeActivity$Companion;", "", "<init>", "()V", "USER", "", "GROUP_ID", StrangeMatchActivity.IS_DIALOG, "CHAT_SCORE", "start", "", "context", "Landroid/content/Context;", "user", "Lcom/qiahao/base_common/model/common/User;", "isDialog", "", "groupId", ChatStrangeActivity.CHAT_SCORE, "Lcom/qiahao/base_common/model/im/StrangeChange;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, User user, boolean z, String str, StrangeChange strangeChange, int i, Object obj) {
            boolean z2;
            if ((i & 4) != 0) {
                z2 = false;
            } else {
                z2 = z;
            }
            companion.start(context, user, z2, str, strangeChange);
        }

        public final void start(@NotNull Context context, @NotNull User user, boolean isDialog, @NotNull String groupId, @NotNull StrangeChange chatScore) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Intrinsics.checkNotNullParameter(chatScore, ChatStrangeActivity.CHAT_SCORE);
            Intent intent = new Intent(context, (Class<?>) ChatStrangeActivity.class);
            intent.putExtra("user", (Parcelable) user);
            intent.putExtra("isDialog", isDialog);
            intent.putExtra("groupId", groupId);
            intent.putExtra(ChatStrangeActivity.CHAT_SCORE, (Parcelable) chatScore);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d3 A[Catch: Exception -> 0x0106, TryCatch #0 {Exception -> 0x0106, blocks: (B:29:0x009b, B:31:0x00a9, B:35:0x00b3, B:37:0x00b7, B:41:0x00c1, B:43:0x00d3, B:45:0x00d9, B:48:0x00eb, B:50:0x00f1, B:52:0x00f7), top: B:28:0x009b }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f1 A[Catch: Exception -> 0x0106, TryCatch #0 {Exception -> 0x0106, blocks: (B:29:0x009b, B:31:0x00a9, B:35:0x00b3, B:37:0x00b7, B:41:0x00c1, B:43:0x00d3, B:45:0x00d9, B:48:0x00eb, B:50:0x00f1, B:52:0x00f7), top: B:28:0x009b }] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void begGiftSuccess(GiftData selectedGiftItem, int number) {
        String str;
        String str2;
        String senderAvatar;
        String str3;
        String receiverAvatar;
        String str4;
        String str5;
        User user;
        String str6;
        String svgaUrl;
        String svgaUrl2;
        String nick;
        String nick2;
        User user2;
        User user3;
        selectedGiftItem.setNum(number);
        UserStore.Companion companion = UserStore.INSTANCE;
        User user4 = companion.getShared().getUser();
        if (user4 != null) {
            str = user4.getAvatar();
        } else {
            str = null;
        }
        selectedGiftItem.setSenderAvatar(str);
        User user5 = this.mUser;
        if (user5 != null) {
            str2 = user5.getAvatar();
        } else {
            str2 = null;
        }
        selectedGiftItem.setReceiverAvatar(str2);
        String s = BaseApplication.Companion.getGSON().s(TIMGiftMessage.Companion.init$default(TIMGiftMessage.Companion, "TIMGiftMessage", selectedGiftItem, 0, 4, (Object) null));
        GroupChatPresenter groupChatPresenter = this.presenter;
        if (groupChatPresenter != null) {
            groupChatPresenter.sendMessage(ChatMessageBuilder.buildCustomMessage(s, ResourcesKtxKt.getStringById(this, 2131952885), null), this.mGroupId, true);
        }
        String senderAvatar2 = selectedGiftItem.getSenderAvatar();
        if (senderAvatar2 == null || senderAvatar2.length() != 0 ? (senderAvatar = selectedGiftItem.getSenderAvatar()) == null : !((user3 = BaseControlUtils.INSTANCE.getUser()) != null && (senderAvatar = user3.getAvatar()) != null)) {
            str3 = "";
        } else {
            str3 = senderAvatar;
        }
        String receiverAvatar2 = selectedGiftItem.getReceiverAvatar();
        if (receiverAvatar2 == null || receiverAvatar2.length() != 0 ? (receiverAvatar = selectedGiftItem.getReceiverAvatar()) == null : !((user2 = this.mUser) != null && (receiverAvatar = user2.getAvatar()) != null)) {
            str4 = "";
        } else {
            str4 = receiverAvatar;
        }
        try {
            String svgaUrl3 = selectedGiftItem.getSvgaUrl();
            User user6 = companion.getShared().getUser();
            if (user6 != null && (nick2 = user6.getNick()) != null) {
                str5 = nick2;
                user = this.mUser;
                if (user != null && (nick = user.getNick()) != null) {
                    str6 = nick;
                    GiftDateItem chatToGift = DataExternalKt.chatToGift(svgaUrl3, str3, str4, str5, str6, selectedGiftItem.getGiftText(), selectedGiftItem.getTextStyleList());
                    svgaUrl = selectedGiftItem.getSvgaUrl();
                    if (svgaUrl == null && StringKtxKt.checkEndSVGA(svgaUrl)) {
                        ((ActivityChatStrangeBinding) getBinding()).queuePlayer.addQueue(GiftHelp.INSTANCE.getSVGAData(chatToGift));
                        return;
                    }
                    svgaUrl2 = selectedGiftItem.getSvgaUrl();
                    if (svgaUrl2 == null && StringKtxKt.checkEndMP4(svgaUrl2)) {
                        GiftHelp.INSTANCE.getVAP2(chatToGift, LifecycleOwnerKt.getLifecycleScope(this), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.x0
                            public final Object invoke(Object obj) {
                                Unit begGiftSuccess$lambda$20;
                                begGiftSuccess$lambda$20 = ChatStrangeActivity.begGiftSuccess$lambda$20(ChatStrangeActivity.this, (VapMediaSource) obj);
                                return begGiftSuccess$lambda$20;
                            }
                        }, this);
                        return;
                    }
                    return;
                }
                str6 = "";
                GiftDateItem chatToGift2 = DataExternalKt.chatToGift(svgaUrl3, str3, str4, str5, str6, selectedGiftItem.getGiftText(), selectedGiftItem.getTextStyleList());
                svgaUrl = selectedGiftItem.getSvgaUrl();
                if (svgaUrl == null) {
                }
                svgaUrl2 = selectedGiftItem.getSvgaUrl();
                if (svgaUrl2 == null) {
                    return;
                } else {
                    return;
                }
            }
            str5 = "";
            user = this.mUser;
            if (user != null) {
                str6 = nick;
                GiftDateItem chatToGift22 = DataExternalKt.chatToGift(svgaUrl3, str3, str4, str5, str6, selectedGiftItem.getGiftText(), selectedGiftItem.getTextStyleList());
                svgaUrl = selectedGiftItem.getSvgaUrl();
                if (svgaUrl == null) {
                }
                svgaUrl2 = selectedGiftItem.getSvgaUrl();
                if (svgaUrl2 == null) {
                }
            }
            str6 = "";
            GiftDateItem chatToGift222 = DataExternalKt.chatToGift(svgaUrl3, str3, str4, str5, str6, selectedGiftItem.getGiftText(), selectedGiftItem.getTextStyleList());
            svgaUrl = selectedGiftItem.getSvgaUrl();
            if (svgaUrl == null) {
            }
            svgaUrl2 = selectedGiftItem.getSvgaUrl();
            if (svgaUrl2 == null) {
            }
        } catch (Exception unused) {
            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "播放礼物出错", false, 4, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit begGiftSuccess$lambda$20(ChatStrangeActivity chatStrangeActivity, VapMediaSource vapMediaSource) {
        Intrinsics.checkNotNullParameter(vapMediaSource, "it");
        chatStrangeActivity.getBinding().queuePlayer.addQueue(vapMediaSource);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void deleteConversation$default(ChatStrangeActivity chatStrangeActivity, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        chatStrangeActivity.deleteConversation(z, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void endPostEventBus(int closeType) {
        StrangeChange strangeChange = this.mChatScore;
        if (strangeChange != null) {
            strangeChange.setCloseType(closeType);
        }
        StrangeChange strangeChange2 = this.mChatScore;
        if (strangeChange2 != null) {
            strangeChange2.setMOtherUser(this.mUser);
        }
        deleteConversation$default(this, false, false, true, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChatViewModel getViewModel() {
        return (ChatViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initChatDialog() {
        boolean z;
        this.mUser = getIntent().getParcelableExtra("user");
        String stringExtra = getIntent().getStringExtra("groupId");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mGroupId = stringExtra;
        this.mChatScore = getIntent().getParcelableExtra(CHAT_SCORE);
        if (this.mUser == null || TextUtils.isEmpty(this.mGroupId)) {
            finish();
        }
        StrangeChange strangeChange = this.mChatScore;
        if (strangeChange != null) {
            z = strangeChange.getUnlock();
        } else {
            z = false;
        }
        this.isStrange = !z;
        StrangerProvide.INSTANCE.getGroupIdSet().add(this.mGroupId);
        boolean booleanExtra = getIntent().getBooleanExtra("isDialog", false);
        this.isDialog = booleanExtra;
        if (booleanExtra) {
            getWindow().addFlags(128);
            getWindow().setLayout(-1, -1);
            getWindow().setGravity(80);
            getWindow().setSoftInputMode(32);
            ViewGroup.LayoutParams layoutParams = ((ActivityChatStrangeBinding) getBinding()).activityMainContainer.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            Dimens dimens = Dimens.INSTANCE;
            layoutParams2.height = ((dimens.getScreenHeight() / 5) * 4) - dimens.dpToPx(44);
            layoutParams2.width = dimens.getScreenWidth();
            layoutParams2.gravity = 80;
            ((ActivityChatStrangeBinding) getBinding()).activityMainContainer.setLayoutParams(layoutParams2);
            return;
        }
        getWindow().setBackgroundDrawable(androidx.core.content.a.getDrawable(this, R.drawable.shape_commom_frame_view2));
        View view = ((ActivityChatStrangeBinding) getBinding()).bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.u0
            public final Object invoke(Object obj, Object obj2) {
                Unit initChatDialog$lambda$1;
                initChatDialog$lambda$1 = ChatStrangeActivity.initChatDialog$lambda$1(ChatStrangeActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initChatDialog$lambda$1;
            }
        });
        getTheme().applyStyle(0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initChatDialog$lambda$1(ChatStrangeActivity chatStrangeActivity, int i, int i2) {
        chatStrangeActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initChatView() {
        GroupChatPresenter groupChatPresenter = new GroupChatPresenter();
        this.presenter = groupChatPresenter;
        groupChatPresenter.initListener();
        GroupInfo groupInfo = new GroupInfo();
        this.mGroupInfo = groupInfo;
        groupInfo.setGroupName("");
        GroupInfo groupInfo2 = this.mGroupInfo;
        if (groupInfo2 != null) {
            groupInfo2.setId(this.mGroupId);
        }
        GroupInfo groupInfo3 = this.mGroupInfo;
        if (groupInfo3 != null) {
            groupInfo3.setFaceUrl("");
        }
        GroupInfo groupInfo4 = this.mGroupInfo;
        if (groupInfo4 != null) {
            groupInfo4.setGroupType("Meeting");
        }
        getBinding().chatView.initDefault();
        V2TIMManager.getInstance().addGroupListener(this.v2TIMGroupListener);
        MessageRecyclerView mMessageRecyclerView = getBinding().chatView.getMMessageRecyclerView();
        if (mMessageRecyclerView != null) {
            mMessageRecyclerView.setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatStrangeActivity$initChatView$1
                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
                public void onMessageClick(View view, int position, TUIMessageBean messageInfo) {
                    super.onMessageClick(view, position, messageInfo);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
                public void onMessageLongClick(View view, int position, TUIMessageBean messageInfo) {
                    super.onMessageLongClick(view, position, messageInfo);
                }

                /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
                
                    r1 = r0.this$0.presenter;
                 */
                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onTypeClick(View view, int position, TUIMessageBean messageInfo, int type) {
                    GroupChatPresenter groupChatPresenter2;
                    super.onTypeClick(view, position, messageInfo, type);
                    if (type != 1) {
                        if (type == 2 && groupChatPresenter2 != null) {
                            groupChatPresenter2.deleteMessage(messageInfo);
                            return;
                        }
                        return;
                    }
                    Object systemService = ChatStrangeActivity.this.getSystemService("clipboard");
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                    Intrinsics.checkNotNull(messageInfo, "null cannot be cast to non-null type com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean");
                    String text = ((TextMessageBean) messageInfo).getText();
                    Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                    ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(Constants.SHARED_MESSAGE_ID_FILE, text));
                    if (!TextUtils.isEmpty(text)) {
                        String string = ChatStrangeActivity.this.getResources().getString(2131954177);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        ToastUtil.toastShortMessage(string);
                    }
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
                public void onUserIconClick(View view, int position, TUIMessageBean messageInfo) {
                    String str;
                    super.onUserIconClick(view, position, messageInfo);
                    AppRequestUtils appRequestUtils = AppRequestUtils.INSTANCE;
                    if (messageInfo != null) {
                        str = messageInfo.getSender();
                    } else {
                        str = null;
                    }
                    appRequestUtils.openPersonPage(str, true);
                }
            });
        }
        MessageRecyclerView mMessageRecyclerView2 = getBinding().chatView.getMMessageRecyclerView();
        if (mMessageRecyclerView2 != null) {
            mMessageRecyclerView2.setIMCheckDataListener(new IMCheckDataListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatStrangeActivity$initChatView$2
                @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.IMCheckDataListener
                public boolean checkBoolean(String type) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    if (Intrinsics.areEqual(type, "isStrange")) {
                        return ChatStrangeActivity.this.getIsStrange();
                    }
                    if (Intrinsics.areEqual(type, "isStrangeGroup")) {
                        return true;
                    }
                    return IMCheckDataListener.DefaultImpls.checkBoolean(this, type);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.IMCheckDataListener
                public int checkInt(String type) {
                    StrangeChange strangeChange;
                    Intrinsics.checkNotNullParameter(type, "type");
                    if (Intrinsics.areEqual(type, "textColor")) {
                        return 2131101214;
                    }
                    if (Intrinsics.areEqual(type, "process")) {
                        strangeChange = ChatStrangeActivity.this.mChatScore;
                        if (strangeChange != null) {
                            return strangeChange.getScoreProcess();
                        }
                        return 0;
                    }
                    return IMCheckDataListener.DefaultImpls.checkInt(this, type);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.IMCheckDataListener
                public String checkString(String type) {
                    User user;
                    String maskAvatar;
                    String maskAvatar2;
                    Intrinsics.checkNotNullParameter(type, "type");
                    if (Intrinsics.areEqual(type, "avatarMy")) {
                        User user2 = UserStore.INSTANCE.getShared().getUser();
                        if (user2 == null || (maskAvatar2 = user2.getMaskAvatar()) == null) {
                            return "";
                        }
                        return maskAvatar2;
                    }
                    if (Intrinsics.areEqual(type, "avatarReceive")) {
                        user = ChatStrangeActivity.this.mUser;
                        if (user == null || (maskAvatar = user.getMaskAvatar()) == null) {
                            return "";
                        }
                        return maskAvatar;
                    }
                    return IMCheckDataListener.DefaultImpls.checkString(this, type);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.IMCheckDataListener
                public void sendMessageSuccess(TUIMessageBean msg) {
                    ChatViewModel viewModel;
                    ChatViewModel viewModel2;
                    if (msg instanceof TextMessageBean) {
                        viewModel2 = ChatStrangeActivity.this.getViewModel();
                        viewModel2.sendStrangeMessage(ChatStrangeActivity.this.getMGroupId(), 0, "");
                    } else if (msg instanceof ImageMessageBean) {
                        viewModel = ChatStrangeActivity.this.getViewModel();
                        viewModel.sendStrangeMessage(ChatStrangeActivity.this.getMGroupId(), 2, "");
                    }
                }
            });
        }
        StrangeInputView mInputView = getBinding().chatView.getMInputView();
        if (mInputView != null) {
            mInputView.setOnInputViewListener(new StrangeInputView.OnInputViewListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatStrangeActivity$initChatView$3
                @Override // com.tencent.qcloud.tuikit.tuichat.hilo.StrangeInputView.OnInputViewListener
                public void onClickGame(int gameId) {
                    ChatViewModel viewModel;
                    User user;
                    String str;
                    viewModel = ChatStrangeActivity.this.getViewModel();
                    user = ChatStrangeActivity.this.mUser;
                    if (user == null || (str = user.getExternalId()) == null) {
                        str = "";
                    }
                    ChatViewModel.inviteSheep$default(viewModel, str, gameId, null, 4, null);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.hilo.StrangeInputView.OnInputViewListener
                public void onClickGift() {
                    ChatStrangeActivity.this.showGiftDialog();
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.hilo.StrangeInputView.OnInputViewListener
                public void onClickImage() {
                    ActivityChatStrangeBinding binding;
                    binding = ChatStrangeActivity.this.getBinding();
                    StrangeInputView mInputView2 = binding.chatView.getMInputView();
                    if (mInputView2 != null) {
                        mInputView2.sendPicture();
                    }
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.hilo.StrangeInputView.OnInputViewListener
                public void onClickVideo() {
                    ChatStrangeActivity.this.videoCallButtonPressed();
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.hilo.StrangeInputView.OnInputViewListener
                public void onStartGroupMemberSelectActivity() {
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.hilo.StrangeInputView.OnInputViewListener
                public void onUpdateChatBackground() {
                }
            });
        }
        GroupChatPresenter groupChatPresenter2 = this.presenter;
        if (groupChatPresenter2 != null) {
            getBinding().chatView.setPresenter(groupChatPresenter2);
        }
        GroupChatPresenter groupChatPresenter3 = this.presenter;
        if (groupChatPresenter3 != null) {
            groupChatPresenter3.setGroupInfo(this.mGroupInfo);
        }
        getBinding().chatView.setChatInfo(this.mGroupInfo);
        getBinding().chatView.markMessageAsRead();
        refreshStrangeView(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x006b, code lost:
    
        r7 = com.qiahao.base_common.utils.HiloToasty.Companion.normal$default(r1, r7, r8, false, 4, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0074, code lost:
    
        if (r7 == null) goto L٣٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0076, code lost:
    
        r7.show();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        if (r0.equals(com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.ChatViewModel.CP_CANCEL) == false) goto L٣٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        if (r0.equals(com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.ChatViewModel.RELATION_INVITE) == false) goto L٣٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
    
        if (r0.equals(com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.ChatViewModel.RELATION_CANCEL) != false) goto L٢٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
    
        if (r0.equals(com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.ChatViewModel.CLOSE_STRANGE_CHAT) == false) goto L٣٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0015, code lost:
    
        if (r0.equals(com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.ChatViewModel.CP_INVITE) == false) goto L٣٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x004f, code lost:
    
        if ((r8.getSecond() instanceof com.qiahao.base_common.network.interceptors.HiloException) == false) goto L٣٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0051, code lost:
    
        r1 = com.qiahao.base_common.utils.HiloToasty.Companion;
        r8 = r8.getSecond();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
        r8 = ((com.qiahao.base_common.network.interceptors.HiloException) r8).getErrorMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0062, code lost:
    
        if (r8 != null) goto L٢٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0064, code lost:
    
        r8 = com.oudi.utils.ktx.ResourcesKtxKt.getStringById(r7, 2131952667);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit initData$lambda$10(ChatStrangeActivity chatStrangeActivity, Pair pair) {
        String str = (String) pair.getFirst();
        switch (str.hashCode()) {
            case -2062063297:
                break;
            case -1880867299:
                break;
            case -1696842068:
                break;
            case -1139615582:
                if (str.equals("USER_INFO")) {
                    chatStrangeActivity.finish();
                    break;
                }
                break;
            case 417643148:
                break;
            case 601668379:
                break;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$11(ChatStrangeActivity chatStrangeActivity, Pair pair) {
        String str = (String) pair.getFirst();
        if (Intrinsics.areEqual(str, ChatViewModel.CLOSE_STRANGE_CHAT)) {
            deleteConversation$default(chatStrangeActivity, false, true, false, 4, null);
        } else if (Intrinsics.areEqual(str, "USER_INFO") && (pair.getSecond() instanceof User)) {
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.model.common.User");
            chatStrangeActivity.mUser = (User) second;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$13(final ChatStrangeActivity chatStrangeActivity, CpMessageData cpMessageData) {
        Integer msgType = cpMessageData.getMsgType();
        if (msgType != null && msgType.intValue() == 1) {
            User user = chatStrangeActivity.mUser;
            if (user != null) {
                String msg = cpMessageData.getMsg();
                if (msg == null) {
                    msg = "";
                }
                new CpInvitationReceiveDialog(chatStrangeActivity, user, msg).show();
            }
        } else {
            Integer msgType2 = cpMessageData.getMsgType();
            if (msgType2 != null && msgType2.intValue() == 2) {
                BaseControlUtils.INSTANCE.showCpDialog(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatStrangeActivity$initData$5$2
                    public void cancel() {
                        OnCommonDialogListener.DefaultImpls.cancel(this);
                    }

                    public void confirm() {
                        ChatViewModel viewModel;
                        User user2;
                        String str;
                        viewModel = ChatStrangeActivity.this.getViewModel();
                        user2 = ChatStrangeActivity.this.mUser;
                        if (user2 == null || (str = user2.getExternalId()) == null) {
                            str = "";
                        }
                        viewModel.cpReply(str, 2);
                    }
                }, ResourcesKtxKt.getStringById(chatStrangeActivity, 2131952448));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$15(final ChatStrangeActivity chatStrangeActivity, final RelationMessageData relationMessageData) {
        Integer msgType = relationMessageData.getMsgType();
        if (msgType != null && msgType.intValue() == 1) {
            User user = chatStrangeActivity.mUser;
            if (user != null) {
                new RelationInvitationReceiveDialog(chatStrangeActivity, user, relationMessageData).show();
            }
        } else {
            Integer msgType2 = relationMessageData.getMsgType();
            if (msgType2 != null && msgType2.intValue() == 2) {
                BaseControlUtils.INSTANCE.showRelationDialog(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatStrangeActivity$initData$6$2
                    public void cancel() {
                        OnCommonDialogListener.DefaultImpls.cancel(this);
                    }

                    public void confirm() {
                        ChatViewModel viewModel;
                        User user2;
                        String str;
                        int i;
                        viewModel = ChatStrangeActivity.this.getViewModel();
                        user2 = ChatStrangeActivity.this.mUser;
                        if (user2 == null || (str = user2.getExternalId()) == null) {
                            str = "";
                        }
                        Integer type = relationMessageData.getType();
                        if (type != null) {
                            i = type.intValue();
                        } else {
                            i = 0;
                        }
                        viewModel.relationReply(str, 2, i);
                    }
                }, ResourcesKtxKt.getStringById(chatStrangeActivity, 2131954186));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$7(Integer num) {
        int intValue;
        if (num != null && (intValue = num.intValue()) > 0) {
            GameJum.matchGame$default(GameJum.INSTANCE, intValue, 9, 0, 0, null, 28, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$9(Integer num) {
        int intValue;
        if (num != null && (intValue = num.intValue()) > 0) {
            GameJum.matchGame$default(GameJum.INSTANCE, intValue, 15, 0, 0, null, 28, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void initSignaling(String str) {
        try {
            BaseApplication.Companion companion = BaseApplication.Companion;
            MeetingRoomCustomData meetingRoomCustomData = (MeetingRoomCustomData) companion.getGSON().j(str, MeetingRoomCustomData.class);
            Integer msgId = meetingRoomCustomData.getMsgId();
            String str2 = null;
            boolean z = false;
            if (msgId != null && msgId.intValue() == 33) {
                this.isStrange = false;
                refreshStrangeView$default(this, false, 1, null);
                StrangeLikeDialog strangeLikeDialog = new StrangeLikeDialog(this, this.mUser);
                strangeLikeDialog.setMListener(new Function0() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.t0
                    public final Object invoke() {
                        Unit initSignaling$lambda$18$lambda$17;
                        initSignaling$lambda$18$lambda$17 = ChatStrangeActivity.initSignaling$lambda$18$lambda$17(ChatStrangeActivity.this);
                        return initSignaling$lambda$18$lambda$17;
                    }
                });
                this.mLikeDialog = strangeLikeDialog;
                strangeLikeDialog.show();
                return;
            }
            if (msgId != null && msgId.intValue() == 32) {
                StrangeChange strangeChange = (StrangeChange) companion.getGSON().j(meetingRoomCustomData.getContent(), StrangeChange.class);
                this.mChatScore = strangeChange;
                if (strangeChange != null) {
                    z = strangeChange.getUnlock();
                }
                this.isStrange = !z;
                refreshStrangeView(true);
                return;
            }
            if (msgId != null && msgId.intValue() == 34) {
                StrangeChange strangeChange2 = (StrangeChange) companion.getGSON().j(meetingRoomCustomData.getContent(), StrangeChange.class);
                if (strangeChange2.getCloseType() == 1) {
                    String closeExternalId = strangeChange2.getCloseExternalId();
                    User user = this.mUser;
                    if (user != null) {
                        str2 = user.getExternalId();
                    }
                    if (Intrinsics.areEqual(closeExternalId, str2)) {
                        endPostEventBus(1);
                        return;
                    } else {
                        deleteConversation$default(this, false, false, false, 7, null);
                        return;
                    }
                }
                if (strangeChange2.getCloseType() == 2) {
                    endPostEventBus(2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initSignaling$lambda$18$lambda$17(ChatStrangeActivity chatStrangeActivity) {
        chatStrangeActivity.requestLikeUser();
        return Unit.INSTANCE;
    }

    private final void initView() {
        getBinding().newUser.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#27d1ad", "#5df2a0", 6, (GradientDrawable.Orientation) null, 8, (Object) null));
        final AppCompatImageView appCompatImageView = getBinding().backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatStrangeActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.finish();
                }
            }
        });
        final AppCompatImageView appCompatImageView2 = getBinding().endImage;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatStrangeActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView2) > j || (appCompatImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView2, currentTimeMillis);
                    AppCompatImageView appCompatImageView3 = appCompatImageView2;
                    this.showMenuDialog();
                }
            }
        });
        final AppCompatImageView appCompatImageView3 = getBinding().closeImage;
        appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatStrangeActivity$initView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView3) > j || (appCompatImageView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView3, currentTimeMillis);
                    AppCompatImageView appCompatImageView4 = appCompatImageView3;
                    TipDialog tipContent = new TipDialog(this).setTipContent(ResourcesKtxKt.getStringById(this, 2131954152));
                    final ChatStrangeActivity chatStrangeActivity = this;
                    tipContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatStrangeActivity$initView$3$1
                        public void cancel() {
                            OnCommonDialogListener.DefaultImpls.cancel(this);
                        }

                        public void confirm() {
                            ChatViewModel viewModel;
                            viewModel = ChatStrangeActivity.this.getViewModel();
                            viewModel.exitStrangeChat(ChatStrangeActivity.this.getMGroupId());
                        }
                    }).show();
                }
            }
        });
        final AppCompatImageView appCompatImageView4 = getBinding().reportImage;
        appCompatImageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatStrangeActivity$initView$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView4) > j || (appCompatImageView4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView4, currentTimeMillis);
                    AppCompatImageView appCompatImageView5 = appCompatImageView4;
                    this.showReportDialog();
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void refreshStrangeView(boolean isStart) {
        long j;
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        String str = null;
        this.timerTask = null;
        ((ActivityChatStrangeBinding) getBinding()).svipType.setVisibility(8);
        ((ActivityChatStrangeBinding) getBinding()).newUser.setVisibility(8);
        setStatusBarIconColor(!this.isStrange);
        if (this.isStrange) {
            ((ActivityChatStrangeBinding) getBinding()).strangeTitleGroup.setVisibility(0);
            ((ActivityChatStrangeBinding) getBinding()).endImage.setVisibility(8);
            if (this.isDialog) {
                ((ActivityChatStrangeBinding) getBinding()).bg.setLeftTopRadius(UiKtxKt.toPX(10));
                ((ActivityChatStrangeBinding) getBinding()).bg.setRightTopRadius(UiKtxKt.toPX(10));
                ((ActivityChatStrangeBinding) getBinding()).bg.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.chat_strange_bg));
            } else {
                ((ActivityChatStrangeBinding) getBinding()).bg.setLeftTopRadius(0);
                ((ActivityChatStrangeBinding) getBinding()).bg.setRightTopRadius(0);
                ((ActivityChatStrangeBinding) getBinding()).bg.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.chat_strange_bg));
            }
            ((ActivityChatStrangeBinding) getBinding()).title.setTextColor(androidx.core.content.a.getColor(this, 2131101214));
            AppCompatTextView appCompatTextView = ((ActivityChatStrangeBinding) getBinding()).title;
            User user = this.mUser;
            if (user != null) {
                str = user.getMaskNick();
            }
            appCompatTextView.setText(str);
            ((ActivityChatStrangeBinding) getBinding()).backImageView.setImageDrawable(androidx.core.content.a.getDrawable(this, 2131232457));
            if (isStart) {
                StrangeChange strangeChange = this.mChatScore;
                if (strangeChange != null) {
                    j = strangeChange.getCountDownTimer(V2TIMManager.getInstance().getServerTime());
                } else {
                    j = 0;
                }
                final long j2 = j * 1000;
                CountDownTimer countDownTimer2 = new CountDownTimer(j2) { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatStrangeActivity$refreshStrangeView$1
                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        ChatStrangeActivity.this.endPostEventBus(2);
                    }

                    @Override // android.os.CountDownTimer
                    public void onTick(long millisUntilFinished) {
                        String valueOf;
                        ActivityChatStrangeBinding binding;
                        if (millisUntilFinished < 1000) {
                            valueOf = MessageService.MSG_DB_READY_REPORT;
                        } else {
                            valueOf = String.valueOf((int) (millisUntilFinished / 1000));
                        }
                        binding = ChatStrangeActivity.this.getBinding();
                        AppCompatTextView appCompatTextView2 = binding.time;
                        String format = String.format(ResourcesKtxKt.getStringById(this, 2131952391), Arrays.copyOf(new Object[]{com.qiahao.base_common.utils.f.c(Integer.parseInt(valueOf))}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        appCompatTextView2.setText(format);
                    }
                };
                this.timerTask = countDownTimer2;
                countDownTimer2.start();
            }
        } else {
            ((ActivityChatStrangeBinding) getBinding()).strangeTitleGroup.setVisibility(8);
            ((ActivityChatStrangeBinding) getBinding()).endImage.setVisibility(0);
            if (this.isDialog) {
                ((ActivityChatStrangeBinding) getBinding()).bg.setLeftTopRadius(UiKtxKt.toPX(10));
                ((ActivityChatStrangeBinding) getBinding()).bg.setRightTopRadius(UiKtxKt.toPX(10));
                ((ActivityChatStrangeBinding) getBinding()).bg.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.shape_commom_frame_view2));
            } else {
                ((ActivityChatStrangeBinding) getBinding()).bg.setLeftTopRadius(0);
                ((ActivityChatStrangeBinding) getBinding()).bg.setRightTopRadius(0);
                ((ActivityChatStrangeBinding) getBinding()).bg.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.shape_commom_frame_view2));
            }
            ((ActivityChatStrangeBinding) getBinding()).title.setTextColor(androidx.core.content.a.getColor(this, 2131099872));
            AppCompatTextView appCompatTextView2 = ((ActivityChatStrangeBinding) getBinding()).title;
            User user2 = this.mUser;
            if (user2 != null) {
                str = user2.getNick();
            }
            appCompatTextView2.setText(str);
            ((ActivityChatStrangeBinding) getBinding()).backImageView.setImageDrawable(androidx.core.content.a.getDrawable(this, 2131232456));
        }
        ((ActivityChatStrangeBinding) getBinding()).chatView.refreshStrangeView();
    }

    static /* synthetic */ void refreshStrangeView$default(ChatStrangeActivity chatStrangeActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        chatStrangeActivity.refreshStrangeView(z);
    }

    private final void requestLikeUser() {
        String str;
        ChatViewModel viewModel = getViewModel();
        User user = this.mUser;
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(viewModel.requestLike(str, false), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.r0
            public final Object invoke(Object obj) {
                Unit requestLikeUser$lambda$22;
                requestLikeUser$lambda$22 = ChatStrangeActivity.requestLikeUser$lambda$22(ChatStrangeActivity.this, (ApiResponse) obj);
                return requestLikeUser$lambda$22;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.y0
            public final Object invoke(Object obj) {
                Unit requestLikeUser$lambda$23;
                requestLikeUser$lambda$23 = ChatStrangeActivity.requestLikeUser$lambda$23(ChatStrangeActivity.this, (Throwable) obj);
                return requestLikeUser$lambda$23;
            }
        }, (Function0) null, false, 12, (Object) null), getViewModel().getMCompositeDisposable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit requestLikeUser$lambda$22(ChatStrangeActivity chatStrangeActivity, ApiResponse apiResponse) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        User user = chatStrangeActivity.mUser;
        if (user != null) {
            LikeResult likeResult = (LikeResult) apiResponse.getData();
            if (likeResult != null) {
                bool = Boolean.valueOf(likeResult.getStatus());
            } else {
                bool = null;
            }
            user.setLike(bool);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, chatStrangeActivity, ResourcesKtxKt.getStringById(chatStrangeActivity, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        StrangeLikeDialog strangeLikeDialog = chatStrangeActivity.mLikeDialog;
        if (strangeLikeDialog != null) {
            strangeLikeDialog.dismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit requestLikeUser$lambda$23(ChatStrangeActivity chatStrangeActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            int code = hiloException.getCode();
            if (code != 9004) {
                if (code != 9005) {
                    HiloToasty.Companion companion = HiloToasty.Companion;
                    String localizedMessage = hiloException.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = ResourcesKtxKt.getStringById(chatStrangeActivity, 2131952667);
                    }
                    Toast normal$default = HiloToasty.Companion.normal$default(companion, chatStrangeActivity, localizedMessage, false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                } else {
                    Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, chatStrangeActivity, ResourcesKtxKt.getStringById(chatStrangeActivity, 2131953231), false, 4, (Object) null);
                    if (normal$default2 != null) {
                        normal$default2.show();
                    }
                }
            } else {
                BaseControlUtils.INSTANCE.showVipDialog(5);
            }
        } else {
            HiloToasty.Companion companion2 = HiloToasty.Companion;
            String localizedMessage2 = th.getLocalizedMessage();
            if (localizedMessage2 == null) {
                localizedMessage2 = ResourcesKtxKt.getStringById(chatStrangeActivity, 2131952667);
            }
            Toast normal$default3 = HiloToasty.Companion.normal$default(companion2, chatStrangeActivity, localizedMessage2, false, 4, (Object) null);
            if (normal$default3 != null) {
                normal$default3.show();
            }
        }
        StrangeLikeDialog strangeLikeDialog = chatStrangeActivity.mLikeDialog;
        if (strangeLikeDialog != null) {
            strangeLikeDialog.dismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f2 A[Catch: Exception -> 0x0150, TryCatch #0 {Exception -> 0x0150, blocks: (B:33:0x00ba, B:35:0x00c8, B:39:0x00d2, B:41:0x00d6, B:45:0x00e0, B:47:0x00f2, B:49:0x00f8, B:53:0x010a, B:55:0x0110, B:57:0x0116, B:58:0x0125, B:60:0x012b, B:62:0x0131, B:64:0x0141, B:68:0x0149), top: B:32:0x00ba }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0110 A[Catch: Exception -> 0x0150, TryCatch #0 {Exception -> 0x0150, blocks: (B:33:0x00ba, B:35:0x00c8, B:39:0x00d2, B:41:0x00d6, B:45:0x00e0, B:47:0x00f2, B:49:0x00f8, B:53:0x010a, B:55:0x0110, B:57:0x0116, B:58:0x0125, B:60:0x012b, B:62:0x0131, B:64:0x0141, B:68:0x0149), top: B:32:0x00ba }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012b A[Catch: Exception -> 0x0150, TryCatch #0 {Exception -> 0x0150, blocks: (B:33:0x00ba, B:35:0x00c8, B:39:0x00d2, B:41:0x00d6, B:45:0x00e0, B:47:0x00f2, B:49:0x00f8, B:53:0x010a, B:55:0x0110, B:57:0x0116, B:58:0x0125, B:60:0x012b, B:62:0x0131, B:64:0x0141, B:68:0x0149), top: B:32:0x00ba }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit sendGift$lambda$25(GiftData giftData, int i, final ChatStrangeActivity chatStrangeActivity, ApiResponse apiResponse) {
        double d;
        String str;
        String str2;
        String senderAvatar;
        String str3;
        String receiverAvatar;
        String str4;
        String svgaUrl;
        User user;
        String str5;
        User user2;
        String str6;
        String svgaUrl2;
        String svgaUrl3;
        String svgaUrl4;
        String svgaUrl5;
        String urlMP4;
        String nick;
        String nick2;
        User user3;
        User user4;
        Intrinsics.checkNotNullParameter(apiResponse, "userCostMessage");
        BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
        ChannelEventGiftAddTime channelEventGiftAddTime = (ChannelEventGiftAddTime) apiResponse.getData();
        if (channelEventGiftAddTime != null) {
            d = channelEventGiftAddTime.getDiamondNum();
        } else {
            d = 0.0d;
        }
        BaseControlUtils.refreshDiamondOrGem$default(baseControlUtils, d, 0.0d, 2, (Object) null);
        giftData.setNum(i);
        UserStore.Companion companion = UserStore.INSTANCE;
        User user5 = companion.getShared().getUser();
        if (user5 != null) {
            str = user5.getAvatar();
        } else {
            str = null;
        }
        giftData.setSenderAvatar(str);
        User user6 = chatStrangeActivity.mUser;
        if (user6 != null) {
            str2 = user6.getAvatar();
        } else {
            str2 = null;
        }
        giftData.setReceiverAvatar(str2);
        String s = BaseApplication.Companion.getGSON().s(TIMGiftMessage.Companion.init$default(TIMGiftMessage.Companion, "TIMGiftMessage", giftData, 0, 4, (Object) null));
        GroupChatPresenter groupChatPresenter = chatStrangeActivity.presenter;
        if (groupChatPresenter != null) {
            groupChatPresenter.sendMessage(ChatMessageBuilder.buildCustomMessage(s, ResourcesKtxKt.getStringById(chatStrangeActivity, 2131952885), null), chatStrangeActivity.mGroupId, true);
        }
        String senderAvatar2 = giftData.getSenderAvatar();
        String str7 = "";
        if (senderAvatar2 == null || senderAvatar2.length() != 0 ? (senderAvatar = giftData.getSenderAvatar()) == null : !((user4 = baseControlUtils.getUser()) != null && (senderAvatar = user4.getAvatar()) != null)) {
            str3 = "";
        } else {
            str3 = senderAvatar;
        }
        String receiverAvatar2 = giftData.getReceiverAvatar();
        if (receiverAvatar2 == null || receiverAvatar2.length() != 0 ? (receiverAvatar = giftData.getReceiverAvatar()) == null : !((user3 = chatStrangeActivity.mUser) != null && (receiverAvatar = user3.getAvatar()) != null)) {
            str4 = "";
        } else {
            str4 = receiverAvatar;
        }
        try {
            svgaUrl = giftData.getSvgaUrl();
            user = companion.getShared().getUser();
        } catch (Exception unused) {
            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "播放礼物出错", false, 4, (Object) null);
        }
        if (user != null && (nick2 = user.getNick()) != null) {
            str5 = nick2;
            user2 = chatStrangeActivity.mUser;
            if (user2 != null && (nick = user2.getNick()) != null) {
                str6 = nick;
                GiftDateItem chatToGift = DataExternalKt.chatToGift(svgaUrl, str3, str4, str5, str6, giftData.getGiftText(), giftData.getTextStyleList());
                svgaUrl2 = giftData.getSvgaUrl();
                if (svgaUrl2 == null && StringKtxKt.checkEndSVGA(svgaUrl2)) {
                    ((ActivityChatStrangeBinding) chatStrangeActivity.getBinding()).queuePlayer.addQueue(GiftHelp.INSTANCE.getSVGAData(chatToGift));
                } else {
                    svgaUrl3 = giftData.getSvgaUrl();
                    if (svgaUrl3 == null && StringKtxKt.checkEndMP4(svgaUrl3)) {
                        GiftHelp.INSTANCE.getVAP2(chatToGift, LifecycleOwnerKt.getLifecycleScope(chatStrangeActivity), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.w0
                            public final Object invoke(Object obj) {
                                Unit sendGift$lambda$25$lambda$24;
                                sendGift$lambda$25$lambda$24 = ChatStrangeActivity.sendGift$lambda$25$lambda$24(ChatStrangeActivity.this, (VapMediaSource) obj);
                                return sendGift$lambda$25$lambda$24;
                            }
                        }, chatStrangeActivity);
                    } else {
                        svgaUrl4 = giftData.getSvgaUrl();
                        if (svgaUrl4 != null && StringKtxKt.checkDefaultMP4(svgaUrl4)) {
                            LightQueueCombinationPlayer lightQueueCombinationPlayer = ((ActivityChatStrangeBinding) chatStrangeActivity.getBinding()).queuePlayer;
                            svgaUrl5 = giftData.getSvgaUrl();
                            if (svgaUrl5 != null && (urlMP4 = StringKtxKt.urlMP4(svgaUrl5)) != null) {
                                str7 = urlMP4;
                            }
                            lightQueueCombinationPlayer.addQueue(new VideoMediaSource(str7));
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            str6 = "";
            GiftDateItem chatToGift2 = DataExternalKt.chatToGift(svgaUrl, str3, str4, str5, str6, giftData.getGiftText(), giftData.getTextStyleList());
            svgaUrl2 = giftData.getSvgaUrl();
            if (svgaUrl2 == null) {
            }
            svgaUrl3 = giftData.getSvgaUrl();
            if (svgaUrl3 == null) {
            }
            svgaUrl4 = giftData.getSvgaUrl();
            if (svgaUrl4 != null) {
                LightQueueCombinationPlayer lightQueueCombinationPlayer2 = ((ActivityChatStrangeBinding) chatStrangeActivity.getBinding()).queuePlayer;
                svgaUrl5 = giftData.getSvgaUrl();
                if (svgaUrl5 != null) {
                    str7 = urlMP4;
                }
                lightQueueCombinationPlayer2.addQueue(new VideoMediaSource(str7));
            }
            return Unit.INSTANCE;
        }
        str5 = "";
        user2 = chatStrangeActivity.mUser;
        if (user2 != null) {
            str6 = nick;
            GiftDateItem chatToGift22 = DataExternalKt.chatToGift(svgaUrl, str3, str4, str5, str6, giftData.getGiftText(), giftData.getTextStyleList());
            svgaUrl2 = giftData.getSvgaUrl();
            if (svgaUrl2 == null) {
            }
            svgaUrl3 = giftData.getSvgaUrl();
            if (svgaUrl3 == null) {
            }
            svgaUrl4 = giftData.getSvgaUrl();
            if (svgaUrl4 != null) {
            }
            return Unit.INSTANCE;
        }
        str6 = "";
        GiftDateItem chatToGift222 = DataExternalKt.chatToGift(svgaUrl, str3, str4, str5, str6, giftData.getGiftText(), giftData.getTextStyleList());
        svgaUrl2 = giftData.getSvgaUrl();
        if (svgaUrl2 == null) {
        }
        svgaUrl3 = giftData.getSvgaUrl();
        if (svgaUrl3 == null) {
        }
        svgaUrl4 = giftData.getSvgaUrl();
        if (svgaUrl4 != null) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendGift$lambda$25$lambda$24(ChatStrangeActivity chatStrangeActivity, VapMediaSource vapMediaSource) {
        Intrinsics.checkNotNullParameter(vapMediaSource, "it");
        chatStrangeActivity.getBinding().queuePlayer.addQueue(vapMediaSource);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit sendGift$lambda$26(ChatStrangeActivity chatStrangeActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(chatStrangeActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, chatStrangeActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showMenuDialog() {
        new ChatMenuDialog(this, false, false, 2, (DefaultConstructorMarker) null).setListener(new ChatMenuDialogListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatStrangeActivity$showMenuDialog$1
            public void clickType(String type) {
                User user;
                String str;
                Intrinsics.checkNotNullParameter(type, "type");
                switch (type.hashCode()) {
                    case -1335458389:
                        if (type.equals("delete")) {
                            TipDialog tipContent = new TipDialog(ChatStrangeActivity.this).setTipContent(ResourcesKtxKt.getStringById(this, 2131952335));
                            final ChatStrangeActivity chatStrangeActivity = ChatStrangeActivity.this;
                            tipContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatStrangeActivity$showMenuDialog$1$clickType$1
                                public void cancel() {
                                    OnCommonDialogListener.DefaultImpls.cancel(this);
                                }

                                public void confirm() {
                                    ChatStrangeActivity.deleteConversation$default(ChatStrangeActivity.this, false, true, false, 5, null);
                                }
                            }).show();
                            return;
                        }
                        return;
                    case -934521548:
                        if (type.equals("report")) {
                            ChatStrangeActivity.this.showReportDialog();
                            return;
                        }
                        return;
                    case -309425751:
                        if (type.equals(FamilyMoreDialog.CLICK_PROFILE)) {
                            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                            user = ChatStrangeActivity.this.mUser;
                            if (user == null || (str = user.getExternalId()) == null) {
                                str = "";
                            }
                            baseControlUtils.openPersonPage(str);
                            return;
                        }
                        return;
                    case 93832333:
                        if (type.equals(MessageMenuDialog.BLOCK)) {
                            new TipDialog(ChatStrangeActivity.this).setTipContent(ResourcesKtxKt.getStringById(this, 2131952131)).setDialogListener(new ChatStrangeActivity$showMenuDialog$1$clickType$2(ChatStrangeActivity.this)).show();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void videoCallButtonPressed() {
        String str;
        BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
        User user = this.mUser;
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        BaseControlUtils.newStartVideo$default(baseControlUtils, this, str, new Function2() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.v0
            public final Object invoke(Object obj, Object obj2) {
                Unit videoCallButtonPressed$lambda$21;
                videoCallButtonPressed$lambda$21 = ChatStrangeActivity.videoCallButtonPressed$lambda$21(ChatStrangeActivity.this, (String) obj, ((Boolean) obj2).booleanValue());
                return videoCallButtonPressed$lambda$21;
            }
        }, (Function0) null, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit videoCallButtonPressed$lambda$21(ChatStrangeActivity chatStrangeActivity, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        chatStrangeActivity.requestLikeUser();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatViewModel viewModel_delegate$lambda$0(ChatStrangeActivity chatStrangeActivity) {
        return new ViewModelProvider(chatStrangeActivity).get(ChatViewModel.class);
    }

    public final void deleteConversation(boolean deleteC2C, final boolean deleteGroup, final boolean isShowDialog) {
        String str;
        if (deleteC2C) {
            V2TIMConversationManager conversationManager = V2TIMManager.getConversationManager();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            User user = this.mUser;
            if (user != null) {
                str = user.getExternalId();
            } else {
                str = null;
            }
            String format = String.format("c2c_%s", Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            conversationManager.deleteConversation(format, null);
        }
        if (!deleteGroup) {
            V2TIMManager.getInstance().quitGroup(this.mGroupId, null);
        }
        V2TIMConversationManager conversationManager2 = V2TIMManager.getConversationManager();
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("group_%s", Arrays.copyOf(new Object[]{this.mGroupId}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        conversationManager2.deleteConversation(format2, new V2TIMCallback() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatStrangeActivity$deleteConversation$1
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int code, String desc) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                StrangeChange strangeChange;
                if (!ChatStrangeActivity.this.getIsStrange() && !deleteGroup) {
                    StrangerProvide.INSTANCE.getStrangerSet().remove(ChatStrangeActivity.this.getMGroupId());
                }
                MessageProvide.INSTANCE.displayData(MessageProvide.MESSAGE_DEFAULT);
                StrangerProvide.INSTANCE.displayData();
                if (isShowDialog) {
                    cf.c c = cf.c.c();
                    strangeChange = ChatStrangeActivity.this.mChatScore;
                    c.l(new EventBusKey("STRANGE_CHAT_END", strangeChange));
                }
                ChatStrangeActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_chat_strange;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    public final void initData() {
        getViewModel().getMSheepId().observe(this, new ChatStrangeActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.z0
            public final Object invoke(Object obj) {
                Unit initData$lambda$7;
                initData$lambda$7 = ChatStrangeActivity.initData$lambda$7((Integer) obj);
                return initData$lambda$7;
            }
        }));
        getViewModel().getMSnakeId().observe(this, new ChatStrangeActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.a1
            public final Object invoke(Object obj) {
                Unit initData$lambda$9;
                initData$lambda$9 = ChatStrangeActivity.initData$lambda$9((Integer) obj);
                return initData$lambda$9;
            }
        }));
        getViewModel().getMException().observe(this, new ChatStrangeActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.b1
            public final Object invoke(Object obj) {
                Unit initData$lambda$10;
                initData$lambda$10 = ChatStrangeActivity.initData$lambda$10(ChatStrangeActivity.this, (Pair) obj);
                return initData$lambda$10;
            }
        }));
        getViewModel().getMSuccess().observe(this, new ChatStrangeActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.c1
            public final Object invoke(Object obj) {
                Unit initData$lambda$11;
                initData$lambda$11 = ChatStrangeActivity.initData$lambda$11(ChatStrangeActivity.this, (Pair) obj);
                return initData$lambda$11;
            }
        }));
        getViewModel().getImType().observe(this, new ChatStrangeActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.d1
            public final Object invoke(Object obj) {
                Unit initData$lambda$13;
                initData$lambda$13 = ChatStrangeActivity.initData$lambda$13(ChatStrangeActivity.this, (CpMessageData) obj);
                return initData$lambda$13;
            }
        }));
        getViewModel().getImRelation().observe(this, new ChatStrangeActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.e1
            public final Object invoke(Object obj) {
                Unit initData$lambda$15;
                initData$lambda$15 = ChatStrangeActivity.initData$lambda$15(ChatStrangeActivity.this, (RelationMessageData) obj);
                return initData$lambda$15;
            }
        }));
    }

    /* renamed from: isDialog, reason: from getter */
    public final boolean getIsDialog() {
        return this.isDialog;
    }

    /* renamed from: isStrange, reason: from getter */
    public final boolean getIsStrange() {
        return this.isStrange;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timerTask = null;
        V2TIMManager.getInstance().removeGroupListener(this.v2TIMGroupListener);
        getBinding().chatView.exitChat();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        String externalId;
        super.onInitialize();
        initChatDialog();
        initView();
        initData();
        String str = "";
        V2TIMManager.getInstance().joinGroup(this.mGroupId, "", new V2TIMCallback() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatStrangeActivity$onInitialize$1
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int p0, String p1) {
                if (p0 == 10013) {
                    ChatStrangeActivity.this.initChatView();
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                ChatStrangeActivity.this.initChatView();
            }
        });
        ChatViewModel viewModel = getViewModel();
        User user = this.mUser;
        if (user != null && (externalId = user.getExternalId()) != null) {
            str = externalId;
        }
        ChatViewModel.getUserInfo$default(viewModel, str, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onPause() {
        super.onPause();
        StrangeInputView mInputView = getBinding().chatView.getMInputView();
        if (mInputView != null) {
            mInputView.setDraft();
        }
        getBinding().chatView.markMessageAsRead();
        StrangerProvide.INSTANCE.displayData();
    }

    public final void sendGift(@NotNull final GiftData selectedGiftItem, final int number) {
        String str;
        long j;
        String str2;
        Intrinsics.checkNotNullParameter(selectedGiftItem, "selectedGiftItem");
        ChatApi apis = ChatServer.INSTANCE.getApis();
        User user = this.mUser;
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        Long giftId = selectedGiftItem.getGiftId();
        if (giftId != null) {
            j = giftId.longValue();
        } else {
            j = 0;
        }
        User user2 = this.mUser;
        if (user2 == null || (str2 = user2.getExternalId()) == null) {
            str2 = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.userChatSendGift(str, j, str2, number, selectedGiftItem.getGiftText(), this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.g1
            public final Object invoke(Object obj) {
                Unit sendGift$lambda$25;
                sendGift$lambda$25 = ChatStrangeActivity.sendGift$lambda$25(selectedGiftItem, number, this, (ApiResponse) obj);
                return sendGift$lambda$25;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.s0
            public final Object invoke(Object obj) {
                Unit sendGift$lambda$26;
                sendGift$lambda$26 = ChatStrangeActivity.sendGift$lambda$26(ChatStrangeActivity.this, (Throwable) obj);
                return sendGift$lambda$26;
            }
        }, (Function0) null, false, 12, (Object) null), getViewModel().getMCompositeDisposable());
    }

    public final void setDialog(boolean z) {
        this.isDialog = z;
    }

    public final void setMGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGroupId = str;
    }

    public final void setStrange(boolean z) {
        this.isStrange = z;
    }

    public final void showGiftDialog() {
        User user = this.mUser;
        if (user != null) {
            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            baseControlUtils.showChatGiftDialog(supportFragmentManager, user, new SendGiftListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatStrangeActivity$showGiftDialog$1$1
                public void begGift(GiftData data, int number) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SendGiftListener.DefaultImpls.begGift(this, data, number);
                    ChatStrangeActivity.this.begGiftSuccess(data, number);
                }

                public void giftsChoose(GiftData selectedGiftItem, int number, ArrayList<String> extraIdList, boolean isAllMic) {
                    Intrinsics.checkNotNullParameter(selectedGiftItem, "selectedGiftItem");
                    Intrinsics.checkNotNullParameter(extraIdList, "extraIdList");
                    ChatStrangeActivity.this.sendGift(selectedGiftItem, number);
                }

                public void roomGiftsChoose(GiftData giftData, int i, ArrayList<String> arrayList, int i2) {
                    SendGiftListener.DefaultImpls.roomGiftsChoose(this, giftData, i, arrayList, i2);
                }

                public void showRechargeView() {
                    BaseControlUtils.INSTANCE.startWallet();
                }
            }, this.mGroupId, Boolean.valueOf(this.isStrange));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showReportDialog() {
        new ReportWhiteDialog(this).setListener(new ChatStrangeActivity$showReportDialog$1(this)).show();
    }
}
