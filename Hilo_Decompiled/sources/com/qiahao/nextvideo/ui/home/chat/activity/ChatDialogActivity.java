package com.qiahao.nextvideo.ui.home.chat.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.StringKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.interfaceing.SendGiftListener;
import com.qiahao.base_common.model.GiftData;
import com.qiahao.base_common.model.common.ChannelEventGiftAddTime;
import com.qiahao.base_common.model.common.LikeResult;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.cp.TextStyles;
import com.qiahao.base_common.model.eventBus.C2CEvent;
import com.qiahao.base_common.model.im.CpMessageData;
import com.qiahao.base_common.model.im.RelationMessageData;
import com.qiahao.base_common.model.im.TIMGiftMessage;
import com.qiahao.base_common.model.svip.SvipData;
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
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.GiftDateItem;
import com.qiahao.nextvideo.databinding.ActivityChatDialogBinding;
import com.qiahao.nextvideo.room.help.GameJum;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.ui.cp.CpInvitationReceiveDialog;
import com.qiahao.nextvideo.ui.cp.CpSpaceActivity;
import com.qiahao.nextvideo.ui.cp.RelationInvitationReceiveDialog;
import com.qiahao.nextvideo.ui.family.FamilyMoreDialog;
import com.qiahao.nextvideo.ui.family.FamilySettingFragment;
import com.qiahao.nextvideo.ui.home.chat.dialog.MessageMenuDialog;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.GiftHelp;
import com.qiahao.nextvideo.utilities.SVGAUtil;
import com.taobao.accs.common.Constants;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMConversationManager;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView;
import com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatView;
import com.tencent.qcloud.tuikit.tuichat.hilo.network.ChatApi;
import com.tencent.qcloud.tuikit.tuichat.hilo.network.ChatServer;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.ChatViewModel;
import com.tencent.qcloud.tuikit.tuichat.presenter.C2CChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u001aH\u0007J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\b\u0010\u001c\u001a\u00020\u0014H\u0002J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\u0006\u0010\u001e\u001a\u00020\u0014J\u0006\u0010\u001f\u001a\u00020\u0014J\u0006\u0010 \u001a\u00020\u0014J\u0018\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012H\u0002J\b\u0010%\u001a\u00020\u0014H\u0002J\b\u0010&\u001a\u00020\u0014H\u0002J\u0016\u0010'\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012J&\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-J\b\u0010/\u001a\u00020\u0014H\u0014J\b\u00100\u001a\u00020\u0014H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u00062"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/activity/ChatDialogActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityChatDialogBinding;", "<init>", "()V", "presenter", "Lcom/tencent/qcloud/tuikit/tuichat/presenter/C2CChatPresenter;", TUIChatConstants.CHAT_INFO, "Lcom/tencent/qcloud/tuikit/tuichat/bean/ChatInfo;", "mUser", "Lcom/qiahao/base_common/model/common/User;", "viewModel", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewModel/ChatViewModel;", "getViewModel", "()Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewModel/ChatViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getLayoutResId", "", "onInitialize", "", "initChatDialog", "onRoomEvent", "event", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "onC2CEvent", "Lcom/qiahao/base_common/model/eventBus/C2CEvent;", "initView", "initChatView", "showMenuDialog", "showReportDialog", TUIConstants.TUIConversation.METHOD_DELETE_CONVERSATION, "showGiftDialog", "begGiftSuccess", "selectedGiftItem", "Lcom/qiahao/base_common/model/GiftData;", FamilySettingFragment.FAMILY_NUMBER, "videoCallButtonPressed", "requestLikeUser", "sendGift", "setGiftText", "dynamicEntity", "Lcom/opensource/svgaplayer/SVGADynamicEntity;", "data", "key", "", "text", "onPause", "onDestroy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nChatDialogActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChatDialogActivity.kt\ncom/qiahao/nextvideo/ui/home/chat/activity/ChatDialogActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,742:1\n61#2,9:743\n61#2,9:752\n1869#3,2:761\n1#4:763\n*S KotlinDebug\n*F\n+ 1 ChatDialogActivity.kt\ncom/qiahao/nextvideo/ui/home/chat/activity/ChatDialogActivity\n*L\n222#1:743,9\n225#1:752,9\n688#1:761,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ChatDialogActivity extends HiloBaseBindingActivity<ActivityChatDialogBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String USER = "user";

    @Nullable
    private ChatInfo chatInfo;

    @Nullable
    private User mUser;

    @Nullable
    private C2CChatPresenter presenter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.k0
        public final Object invoke() {
            ChatViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = ChatDialogActivity.viewModel_delegate$lambda$0(ChatDialogActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/activity/ChatDialogActivity$Companion;", "", "<init>", "()V", "USER", "", "start", "", "context", "Landroid/content/Context;", "user", "Lcom/qiahao/base_common/model/common/User;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context, @NotNull User user) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(user, "user");
            Intent intent = new Intent(context, (Class<?>) ChatDialogActivity.class);
            intent.putExtra("user", (Parcelable) user);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00dd A[Catch: Exception -> 0x0110, TryCatch #0 {Exception -> 0x0110, blocks: (B:34:0x00a4, B:36:0x00b2, B:40:0x00bc, B:42:0x00c0, B:46:0x00ca, B:48:0x00dd, B:50:0x00e3, B:53:0x00f5, B:55:0x00fb, B:57:0x0101), top: B:33:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fb A[Catch: Exception -> 0x0110, TryCatch #0 {Exception -> 0x0110, blocks: (B:34:0x00a4, B:36:0x00b2, B:40:0x00bc, B:42:0x00c0, B:46:0x00ca, B:48:0x00dd, B:50:0x00e3, B:53:0x00f5, B:55:0x00fb, B:57:0x0101), top: B:33:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
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
        String str7;
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
        C2CChatPresenter c2CChatPresenter = this.presenter;
        if (c2CChatPresenter != null) {
            TUIMessageBean buildCustomMessage = ChatMessageBuilder.buildCustomMessage(s, ResourcesKtxKt.getStringById(this, 2131952885), null);
            User user6 = this.mUser;
            if (user6 == null || (str7 = user6.getExternalId()) == null) {
                str7 = "";
            }
            c2CChatPresenter.sendMessage(buildCustomMessage, str7, false);
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
            User user7 = companion.getShared().getUser();
            if (user7 != null && (nick2 = user7.getNick()) != null) {
                str5 = nick2;
                user = this.mUser;
                if (user != null && (nick = user.getNick()) != null) {
                    str6 = nick;
                    GiftDateItem chatToGift = DataExternalKt.chatToGift(svgaUrl3, str3, str4, str5, str6, selectedGiftItem.getGiftText(), selectedGiftItem.getTextStyleList());
                    svgaUrl = selectedGiftItem.getSvgaUrl();
                    if (svgaUrl == null && StringKtxKt.checkEndSVGA(svgaUrl)) {
                        ((ActivityChatDialogBinding) getBinding()).queuePlayer.addQueue(GiftHelp.INSTANCE.getSVGAData(chatToGift));
                        return;
                    }
                    svgaUrl2 = selectedGiftItem.getSvgaUrl();
                    if (svgaUrl2 == null && StringKtxKt.checkEndMP4(svgaUrl2)) {
                        GiftHelp.INSTANCE.getVAP2(chatToGift, LifecycleOwnerKt.getLifecycleScope(this), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.a0
                            public final Object invoke(Object obj) {
                                Unit begGiftSuccess$lambda$15;
                                begGiftSuccess$lambda$15 = ChatDialogActivity.begGiftSuccess$lambda$15(ChatDialogActivity.this, (VapMediaSource) obj);
                                return begGiftSuccess$lambda$15;
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
    public static final Unit begGiftSuccess$lambda$15(ChatDialogActivity chatDialogActivity, VapMediaSource vapMediaSource) {
        Intrinsics.checkNotNullParameter(vapMediaSource, "it");
        chatDialogActivity.getBinding().queuePlayer.addQueue(vapMediaSource);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChatViewModel getViewModel() {
        return (ChatViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initChatDialog() {
        getWindow().setLayout(-1, -1);
        getWindow().setGravity(80);
        FrameLayout container = getContainer();
        if (container != null) {
            container.setBackgroundColor(0);
        }
        getWindow().setSoftInputMode(32);
        ViewGroup.LayoutParams layoutParams = ((ActivityChatDialogBinding) getBinding()).frameLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        Dimens dimens = Dimens.INSTANCE;
        layoutParams2.height = ((dimens.getScreenHeight() / 5) * 4) - dimens.dpToPx(48);
        layoutParams2.width = dimens.getScreenWidth();
        layoutParams2.gravity = 80;
        ((ActivityChatDialogBinding) getBinding()).frameLayout.setLayoutParams(layoutParams2);
    }

    private final void initChatView() {
        String str;
        long j;
        String avatar;
        String str2;
        C2CChatPresenter c2CChatPresenter = new C2CChatPresenter();
        this.presenter = c2CChatPresenter;
        c2CChatPresenter.initListener();
        ChatInfo chatInfo = new ChatInfo();
        this.chatInfo = chatInfo;
        User user = this.mUser;
        if (user != null) {
            str = user.getNick();
        } else {
            str = null;
        }
        chatInfo.setChatName(str);
        ChatInfo chatInfo2 = this.chatInfo;
        String str3 = "";
        if (chatInfo2 != null) {
            User user2 = this.mUser;
            if (user2 == null || (str2 = user2.getExternalId()) == null) {
                str2 = "";
            }
            chatInfo2.setId(str2);
        }
        ChatInfo chatInfo3 = this.chatInfo;
        if (chatInfo3 != null) {
            User user3 = this.mUser;
            if (user3 != null && (avatar = user3.getAvatar()) != null) {
                str3 = avatar;
            }
            chatInfo3.setFaceUrl(str3);
        }
        getBinding().chatView.initDefault();
        getBinding().chatView.mMessageRecyclerView.setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatDialogActivity$initChatView$1
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
                C2CChatPresenter c2CChatPresenter2;
                super.onTypeClick(view, position, messageInfo, type);
                if (type != 1) {
                    if (type == 2 && c2CChatPresenter2 != null) {
                        c2CChatPresenter2.deleteMessage(messageInfo);
                        return;
                    }
                    return;
                }
                Object systemService = ChatDialogActivity.this.getSystemService("clipboard");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                Intrinsics.checkNotNull(messageInfo, "null cannot be cast to non-null type com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean");
                String text = ((TextMessageBean) messageInfo).getText();
                Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(Constants.SHARED_MESSAGE_ID_FILE, text));
                if (!TextUtils.isEmpty(text)) {
                    String string = ChatDialogActivity.this.getResources().getString(2131954177);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    ToastUtil.toastShortMessage(string);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
            public void onUserIconClick(View view, int position, TUIMessageBean messageInfo) {
                String str4;
                super.onUserIconClick(view, position, messageInfo);
                AppRequestUtils appRequestUtils = AppRequestUtils.INSTANCE;
                if (messageInfo != null) {
                    str4 = messageInfo.getSender();
                } else {
                    str4 = null;
                }
                appRequestUtils.openPersonPage(str4, true);
            }
        });
        UserStore.Companion companion = UserStore.INSTANCE;
        User user4 = companion.getShared().getUser();
        int i = 0;
        if (user4 != null && user4.isAr()) {
            HiloChatView hiloChatView = getBinding().chatView;
            User user5 = companion.getShared().getUser();
            if (user5 != null) {
                j = user5.getWealthUserGrade();
            } else {
                j = 0;
            }
            if (j <= 10) {
                i = 8;
            }
            hiloChatView.showVideo(i);
        } else {
            getBinding().chatView.showVideo(0);
        }
        getBinding().chatView.mInputView.setOnInputViewListener(new C2CInputView.OnInputViewListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatDialogActivity$initChatView$2
            @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.OnInputViewListener
            public void onClickGame(int gameId) {
                ChatViewModel viewModel;
                User user6;
                String str4;
                viewModel = ChatDialogActivity.this.getViewModel();
                user6 = ChatDialogActivity.this.mUser;
                if (user6 == null || (str4 = user6.getExternalId()) == null) {
                    str4 = "";
                }
                ChatViewModel.inviteSheep$default(viewModel, str4, 9, null, 4, null);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.OnInputViewListener
            public void onClickGift() {
                ChatDialogActivity.this.showGiftDialog();
            }

            /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
            
                if (r0 == false) goto L١٢;
             */
            @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.OnInputViewListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onClickImage() {
                User user6;
                boolean z;
                User user7;
                boolean z2;
                ActivityChatDialogBinding binding;
                User user8;
                boolean z3;
                user6 = ChatDialogActivity.this.mUser;
                boolean z4 = false;
                if (user6 != null) {
                    z = Intrinsics.areEqual(user6.isLike(), Boolean.TRUE);
                } else {
                    z = false;
                }
                if (z) {
                    user8 = ChatDialogActivity.this.mUser;
                    if (user8 != null) {
                        z3 = Intrinsics.areEqual(user8.isLikeMe(), Boolean.TRUE);
                    } else {
                        z3 = false;
                    }
                }
                user7 = ChatDialogActivity.this.mUser;
                if (user7 != null && user7.isOfficialStaff()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    User user9 = UserStore.INSTANCE.getShared().getUser();
                    if (user9 != null && user9.isOfficialStaff()) {
                        z4 = true;
                    }
                    if (!z4) {
                        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ChatDialogActivity.this, ResourcesKtxKt.getStringById(this, 2131953224), false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                            return;
                        }
                        return;
                    }
                }
                binding = ChatDialogActivity.this.getBinding();
                binding.chatView.mInputView.sendPicture();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.OnInputViewListener
            public void onClickVideo() {
                ChatDialogActivity.this.videoCallButtonPressed();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.OnInputViewListener
            public void onStartGroupMemberSelectActivity() {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.OnInputViewListener
            public void onUpdateChatBackground() {
            }
        });
        getBinding().chatView.setPresenter(this.presenter);
        C2CChatPresenter c2CChatPresenter2 = this.presenter;
        if (c2CChatPresenter2 != null) {
            c2CChatPresenter2.setChatInfo(this.chatInfo);
        }
        getBinding().chatView.setChatInfo(this.chatInfo);
        getBinding().chatView.markMessageAsRead();
        getViewModel().getMSheepId().observe(this, new ChatDialogActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.c0
            public final Object invoke(Object obj) {
                Unit initChatView$lambda$6;
                initChatView$lambda$6 = ChatDialogActivity.initChatView$lambda$6((Integer) obj);
                return initChatView$lambda$6;
            }
        }));
        getViewModel().getMSnakeId().observe(this, new ChatDialogActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.d0
            public final Object invoke(Object obj) {
                Unit initChatView$lambda$8;
                initChatView$lambda$8 = ChatDialogActivity.initChatView$lambda$8((Integer) obj);
                return initChatView$lambda$8;
            }
        }));
        getViewModel().getMException().observe(this, new ChatDialogActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.e0
            public final Object invoke(Object obj) {
                Unit initChatView$lambda$9;
                initChatView$lambda$9 = ChatDialogActivity.initChatView$lambda$9(ChatDialogActivity.this, (Pair) obj);
                return initChatView$lambda$9;
            }
        }));
        getViewModel().getImType().observe(this, new ChatDialogActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.f0
            public final Object invoke(Object obj) {
                Unit initChatView$lambda$11;
                initChatView$lambda$11 = ChatDialogActivity.initChatView$lambda$11(ChatDialogActivity.this, (CpMessageData) obj);
                return initChatView$lambda$11;
            }
        }));
        getViewModel().getImRelation().observe(this, new ChatDialogActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.g0
            public final Object invoke(Object obj) {
                Unit initChatView$lambda$13;
                initChatView$lambda$13 = ChatDialogActivity.initChatView$lambda$13(ChatDialogActivity.this, (RelationMessageData) obj);
                return initChatView$lambda$13;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initChatView$lambda$11(final ChatDialogActivity chatDialogActivity, CpMessageData cpMessageData) {
        Integer msgType = cpMessageData.getMsgType();
        if (msgType != null && msgType.intValue() == 1) {
            User user = chatDialogActivity.mUser;
            if (user != null) {
                String msg = cpMessageData.getMsg();
                if (msg == null) {
                    msg = "";
                }
                new CpInvitationReceiveDialog(chatDialogActivity, user, msg).show();
            }
        } else {
            Integer msgType2 = cpMessageData.getMsgType();
            if (msgType2 != null && msgType2.intValue() == 2) {
                BaseControlUtils.INSTANCE.showCpDialog(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatDialogActivity$initChatView$6$2
                    public void cancel() {
                        OnCommonDialogListener.DefaultImpls.cancel(this);
                    }

                    public void confirm() {
                        ChatViewModel viewModel;
                        User user2;
                        String str;
                        viewModel = ChatDialogActivity.this.getViewModel();
                        user2 = ChatDialogActivity.this.mUser;
                        if (user2 == null || (str = user2.getExternalId()) == null) {
                            str = "";
                        }
                        viewModel.cpReply(str, 2);
                    }
                }, ResourcesKtxKt.getStringById(chatDialogActivity, 2131952448));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initChatView$lambda$13(final ChatDialogActivity chatDialogActivity, final RelationMessageData relationMessageData) {
        Integer msgType = relationMessageData.getMsgType();
        if (msgType != null && msgType.intValue() == 1) {
            User user = chatDialogActivity.mUser;
            if (user != null) {
                new RelationInvitationReceiveDialog(chatDialogActivity, user, relationMessageData).show();
            }
        } else {
            Integer msgType2 = relationMessageData.getMsgType();
            if (msgType2 != null && msgType2.intValue() == 2) {
                BaseControlUtils.INSTANCE.showRelationDialog(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatDialogActivity$initChatView$7$2
                    public void cancel() {
                        OnCommonDialogListener.DefaultImpls.cancel(this);
                    }

                    public void confirm() {
                        ChatViewModel viewModel;
                        User user2;
                        String str;
                        int i;
                        viewModel = ChatDialogActivity.this.getViewModel();
                        user2 = ChatDialogActivity.this.mUser;
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
                }, ResourcesKtxKt.getStringById(chatDialogActivity, 2131954186));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initChatView$lambda$6(Integer num) {
        int intValue;
        if (num != null && (intValue = num.intValue()) > 0) {
            GameJum.matchGame$default(GameJum.INSTANCE, intValue, 9, 0, 0, null, 28, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initChatView$lambda$8(Integer num) {
        int intValue;
        if (num != null && (intValue = num.intValue()) > 0) {
            GameJum.matchGame$default(GameJum.INSTANCE, intValue, 15, 0, 0, null, 28, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0053, code lost:
    
        r7 = com.qiahao.base_common.utils.HiloToasty.Companion.normal$default(r1, r7, r8, false, 4, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x005c, code lost:
    
        if (r7 == null) goto L٢٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005e, code lost:
    
        r7.show();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
    
        if (r0.equals(com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.ChatViewModel.CP_CANCEL) == false) goto L٢٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
    
        if (r0.equals(com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.ChatViewModel.RELATION_INVITE) == false) goto L٢٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        if (r0.equals(com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.ChatViewModel.RELATION_CANCEL) != false) goto L١٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
    
        if (r0.equals(com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.ChatViewModel.CP_INVITE) == false) goto L٢٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0037, code lost:
    
        if ((r8.getSecond() instanceof com.qiahao.base_common.network.interceptors.HiloException) == false) goto L٢٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0039, code lost:
    
        r1 = com.qiahao.base_common.utils.HiloToasty.Companion;
        r8 = r8.getSecond();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
        r8 = ((com.qiahao.base_common.network.interceptors.HiloException) r8).getErrorMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x004a, code lost:
    
        if (r8 != null) goto L٢١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004c, code lost:
    
        r8 = com.oudi.utils.ktx.ResourcesKtxKt.getStringById(r7, 2131952667);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit initChatView$lambda$9(ChatDialogActivity chatDialogActivity, Pair pair) {
        String str = (String) pair.getFirst();
        switch (str.hashCode()) {
            case -1880867299:
                break;
            case -1696842068:
                break;
            case 417643148:
                break;
            case 601668379:
                break;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        int i;
        boolean z;
        String str;
        int i2;
        SvipData svip;
        SvipData svip2;
        User parcelableExtra = getIntent().getParcelableExtra("user");
        this.mUser = parcelableExtra;
        if (parcelableExtra == null) {
            finish();
        }
        View view = ((ActivityChatDialogBinding) getBinding()).bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.x
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$1;
                initView$lambda$1 = ChatDialogActivity.initView$lambda$1(ChatDialogActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$1;
            }
        });
        User user = this.mUser;
        int i3 = 0;
        if (user != null && (svip2 = user.getSvip()) != null) {
            i = svip2.getSvipLevel();
        } else {
            i = 0;
        }
        if (i > 0) {
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            User user2 = this.mUser;
            if (user2 != null && (svip = user2.getSvip()) != null) {
                i2 = svip.getSvipLevel();
            } else {
                i2 = 0;
            }
            Integer svipType = svipTypeUtils.getSvipType(Integer.valueOf(i2));
            if (svipType != null) {
                ((ActivityChatDialogBinding) getBinding()).svipType.setImageDrawable(androidx.core.content.a.getDrawable(this, svipType.intValue()));
            }
            ((ActivityChatDialogBinding) getBinding()).svipType.setVisibility(0);
        } else {
            ((ActivityChatDialogBinding) getBinding()).svipType.setVisibility(8);
        }
        TextView textView = ((ActivityChatDialogBinding) getBinding()).newUser;
        User user3 = this.mUser;
        if (user3 != null) {
            z = Intrinsics.areEqual(user3.isNew(), Boolean.TRUE);
        } else {
            z = false;
        }
        if (!z) {
            i3 = 8;
        }
        textView.setVisibility(i3);
        ((ActivityChatDialogBinding) getBinding()).newUser.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#27d1ad", "#5df2a0", 6, (GradientDrawable.Orientation) null, 8, (Object) null));
        AppCompatTextView appCompatTextView = ((ActivityChatDialogBinding) getBinding()).title;
        User user4 = this.mUser;
        if (user4 == null || (str = user4.getNick()) == null) {
            str = "";
        }
        appCompatTextView.setText(str);
        final AppCompatImageView appCompatImageView = ((ActivityChatDialogBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatDialogActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.finish();
                }
            }
        });
        final AppCompatImageView appCompatImageView2 = ((ActivityChatDialogBinding) getBinding()).endImage;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatDialogActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView2) > j || (appCompatImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView2, currentTimeMillis);
                    AppCompatImageView appCompatImageView3 = appCompatImageView2;
                    this.showMenuDialog();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$1(ChatDialogActivity chatDialogActivity, int i, int i2) {
        chatDialogActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    private final void requestLikeUser() {
        String str;
        ChatViewModel viewModel = getViewModel();
        User user = this.mUser;
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(viewModel.requestLike(str, false), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.h0
            public final Object invoke(Object obj) {
                Unit requestLikeUser$lambda$17;
                requestLikeUser$lambda$17 = ChatDialogActivity.requestLikeUser$lambda$17(ChatDialogActivity.this, (ApiResponse) obj);
                return requestLikeUser$lambda$17;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.i0
            public final Object invoke(Object obj) {
                Unit requestLikeUser$lambda$18;
                requestLikeUser$lambda$18 = ChatDialogActivity.requestLikeUser$lambda$18(ChatDialogActivity.this, (Throwable) obj);
                return requestLikeUser$lambda$18;
            }
        }, (Function0) null, false, 12, (Object) null), getViewModel().getMCompositeDisposable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestLikeUser$lambda$17(ChatDialogActivity chatDialogActivity, ApiResponse apiResponse) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        User user = chatDialogActivity.mUser;
        if (user != null) {
            LikeResult likeResult = (LikeResult) apiResponse.getData();
            if (likeResult != null) {
                bool = Boolean.valueOf(likeResult.getStatus());
            } else {
                bool = null;
            }
            user.setLike(bool);
        }
        chatDialogActivity.videoCallButtonPressed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit requestLikeUser$lambda$18(ChatDialogActivity chatDialogActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            int code = hiloException.getCode();
            if (code != 9004) {
                if (code != 9005) {
                    HiloToasty.Companion companion = HiloToasty.Companion;
                    String localizedMessage = hiloException.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = ResourcesKtxKt.getStringById(chatDialogActivity, 2131952667);
                    }
                    Toast normal$default = HiloToasty.Companion.normal$default(companion, chatDialogActivity, localizedMessage, false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                } else {
                    Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, chatDialogActivity, ResourcesKtxKt.getStringById(chatDialogActivity, 2131953231), false, 4, (Object) null);
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
                localizedMessage2 = ResourcesKtxKt.getStringById(chatDialogActivity, 2131952667);
            }
            Toast normal$default3 = HiloToasty.Companion.normal$default(companion2, chatDialogActivity, localizedMessage2, false, 4, (Object) null);
            if (normal$default3 != null) {
                normal$default3.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fc A[Catch: Exception -> 0x015a, TryCatch #0 {Exception -> 0x015a, blocks: (B:38:0x00c3, B:40:0x00d1, B:44:0x00db, B:46:0x00df, B:50:0x00e9, B:52:0x00fc, B:54:0x0102, B:58:0x0114, B:60:0x011a, B:62:0x0120, B:63:0x012f, B:65:0x0135, B:67:0x013b, B:69:0x014b, B:73:0x0153), top: B:37:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011a A[Catch: Exception -> 0x015a, TryCatch #0 {Exception -> 0x015a, blocks: (B:38:0x00c3, B:40:0x00d1, B:44:0x00db, B:46:0x00df, B:50:0x00e9, B:52:0x00fc, B:54:0x0102, B:58:0x0114, B:60:0x011a, B:62:0x0120, B:63:0x012f, B:65:0x0135, B:67:0x013b, B:69:0x014b, B:73:0x0153), top: B:37:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0135 A[Catch: Exception -> 0x015a, TryCatch #0 {Exception -> 0x015a, blocks: (B:38:0x00c3, B:40:0x00d1, B:44:0x00db, B:46:0x00df, B:50:0x00e9, B:52:0x00fc, B:54:0x0102, B:58:0x0114, B:60:0x011a, B:62:0x0120, B:63:0x012f, B:65:0x0135, B:67:0x013b, B:69:0x014b, B:73:0x0153), top: B:37:0x00c3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit sendGift$lambda$20(GiftData giftData, int i, final ChatDialogActivity chatDialogActivity, ApiResponse apiResponse) {
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
        String str7;
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
        User user6 = chatDialogActivity.mUser;
        if (user6 != null) {
            str2 = user6.getAvatar();
        } else {
            str2 = null;
        }
        giftData.setReceiverAvatar(str2);
        String s = BaseApplication.Companion.getGSON().s(TIMGiftMessage.Companion.init$default(TIMGiftMessage.Companion, "TIMGiftMessage", giftData, 0, 4, (Object) null));
        C2CChatPresenter c2CChatPresenter = chatDialogActivity.presenter;
        String str8 = "";
        if (c2CChatPresenter != null) {
            TUIMessageBean buildCustomMessage = ChatMessageBuilder.buildCustomMessage(s, ResourcesKtxKt.getStringById(chatDialogActivity, 2131952885), null);
            User user7 = chatDialogActivity.mUser;
            if (user7 == null || (str7 = user7.getExternalId()) == null) {
                str7 = "";
            }
            c2CChatPresenter.sendMessage(buildCustomMessage, str7, false);
        }
        String senderAvatar2 = giftData.getSenderAvatar();
        if (senderAvatar2 == null || senderAvatar2.length() != 0 ? (senderAvatar = giftData.getSenderAvatar()) == null : !((user4 = baseControlUtils.getUser()) != null && (senderAvatar = user4.getAvatar()) != null)) {
            str3 = "";
        } else {
            str3 = senderAvatar;
        }
        String receiverAvatar2 = giftData.getReceiverAvatar();
        if (receiverAvatar2 == null || receiverAvatar2.length() != 0 ? (receiverAvatar = giftData.getReceiverAvatar()) == null : !((user3 = chatDialogActivity.mUser) != null && (receiverAvatar = user3.getAvatar()) != null)) {
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
            user2 = chatDialogActivity.mUser;
            if (user2 != null && (nick = user2.getNick()) != null) {
                str6 = nick;
                GiftDateItem chatToGift = DataExternalKt.chatToGift(svgaUrl, str3, str4, str5, str6, giftData.getGiftText(), giftData.getTextStyleList());
                svgaUrl2 = giftData.getSvgaUrl();
                if (svgaUrl2 == null && StringKtxKt.checkEndSVGA(svgaUrl2)) {
                    ((ActivityChatDialogBinding) chatDialogActivity.getBinding()).queuePlayer.addQueue(GiftHelp.INSTANCE.getSVGAData(chatToGift));
                } else {
                    svgaUrl3 = giftData.getSvgaUrl();
                    if (svgaUrl3 == null && StringKtxKt.checkEndMP4(svgaUrl3)) {
                        GiftHelp.INSTANCE.getVAP2(chatToGift, LifecycleOwnerKt.getLifecycleScope(chatDialogActivity), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.b0
                            public final Object invoke(Object obj) {
                                Unit sendGift$lambda$20$lambda$19;
                                sendGift$lambda$20$lambda$19 = ChatDialogActivity.sendGift$lambda$20$lambda$19(ChatDialogActivity.this, (VapMediaSource) obj);
                                return sendGift$lambda$20$lambda$19;
                            }
                        }, chatDialogActivity);
                    } else {
                        svgaUrl4 = giftData.getSvgaUrl();
                        if (svgaUrl4 != null && StringKtxKt.checkDefaultMP4(svgaUrl4)) {
                            LightQueueCombinationPlayer lightQueueCombinationPlayer = ((ActivityChatDialogBinding) chatDialogActivity.getBinding()).queuePlayer;
                            svgaUrl5 = giftData.getSvgaUrl();
                            if (svgaUrl5 != null && (urlMP4 = StringKtxKt.urlMP4(svgaUrl5)) != null) {
                                str8 = urlMP4;
                            }
                            lightQueueCombinationPlayer.addQueue(new VideoMediaSource(str8));
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
                LightQueueCombinationPlayer lightQueueCombinationPlayer2 = ((ActivityChatDialogBinding) chatDialogActivity.getBinding()).queuePlayer;
                svgaUrl5 = giftData.getSvgaUrl();
                if (svgaUrl5 != null) {
                    str8 = urlMP4;
                }
                lightQueueCombinationPlayer2.addQueue(new VideoMediaSource(str8));
            }
            return Unit.INSTANCE;
        }
        str5 = "";
        user2 = chatDialogActivity.mUser;
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
    public static final Unit sendGift$lambda$20$lambda$19(ChatDialogActivity chatDialogActivity, VapMediaSource vapMediaSource) {
        Intrinsics.checkNotNullParameter(vapMediaSource, "it");
        chatDialogActivity.getBinding().queuePlayer.addQueue(vapMediaSource);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit sendGift$lambda$21(ChatDialogActivity chatDialogActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(chatDialogActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, chatDialogActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showMenuDialog() {
        new ChatMenuDialog(this, false, false, 6, (DefaultConstructorMarker) null).setListener(new ChatMenuDialogListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatDialogActivity$showMenuDialog$1
            public void clickType(String type) {
                User user;
                String str;
                Intrinsics.checkNotNullParameter(type, "type");
                switch (type.hashCode()) {
                    case -1335458389:
                        if (type.equals("delete")) {
                            TipDialog tipContent = new TipDialog(ChatDialogActivity.this).setTipContent(ResourcesKtxKt.getStringById(this, 2131952335));
                            final ChatDialogActivity chatDialogActivity = ChatDialogActivity.this;
                            tipContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatDialogActivity$showMenuDialog$1$clickType$1
                                public void cancel() {
                                    OnCommonDialogListener.DefaultImpls.cancel(this);
                                }

                                public void confirm() {
                                    ChatDialogActivity.this.deleteConversation();
                                }
                            }).show();
                            return;
                        }
                        return;
                    case -934521548:
                        if (type.equals("report")) {
                            ChatDialogActivity.this.showReportDialog();
                            return;
                        }
                        return;
                    case -309425751:
                        if (type.equals(FamilyMoreDialog.CLICK_PROFILE)) {
                            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                            user = ChatDialogActivity.this.mUser;
                            if (user == null || (str = user.getExternalId()) == null) {
                                str = "";
                            }
                            baseControlUtils.openPersonPage(str);
                            return;
                        }
                        return;
                    case 93832333:
                        if (type.equals(MessageMenuDialog.BLOCK)) {
                            new TipDialog(ChatDialogActivity.this).setTipContent(ResourcesKtxKt.getStringById(this, 2131952131)).setDialogListener(new ChatDialogActivity$showMenuDialog$1$clickType$2(ChatDialogActivity.this)).show();
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
        BaseControlUtils.newStartVideo$default(baseControlUtils, this, str, new Function2() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.j0
            public final Object invoke(Object obj, Object obj2) {
                Unit videoCallButtonPressed$lambda$16;
                videoCallButtonPressed$lambda$16 = ChatDialogActivity.videoCallButtonPressed$lambda$16(ChatDialogActivity.this, (String) obj, ((Boolean) obj2).booleanValue());
                return videoCallButtonPressed$lambda$16;
            }
        }, (Function0) null, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit videoCallButtonPressed$lambda$16(ChatDialogActivity chatDialogActivity, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        chatDialogActivity.requestLikeUser();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatViewModel viewModel_delegate$lambda$0(ChatDialogActivity chatDialogActivity) {
        return new ViewModelProvider(chatDialogActivity).get(ChatViewModel.class);
    }

    public final void deleteConversation() {
        String str;
        V2TIMConversationManager conversationManager = V2TIMManager.getConversationManager();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        User user = this.mUser;
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        String format = String.format("c2c_%s", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        conversationManager.deleteConversation(format, new V2TIMCallback() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatDialogActivity$deleteConversation$1
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int code, String desc) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                MessageProvide.INSTANCE.displayData(MessageProvide.MESSAGE_DEFAULT);
                ChatDialogActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_chat_dialog;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onC2CEvent(@NotNull C2CEvent event) {
        String str;
        int i;
        String externalId;
        String str2;
        String externalId2;
        Intrinsics.checkNotNullParameter(event, "event");
        String type = event.getType();
        String str3 = "";
        switch (type.hashCode()) {
            case -1477698941:
                if (type.equals("relation_invite_or_cancel") && (event.getData() instanceof RelationMessageData)) {
                    ChatViewModel viewModel = getViewModel();
                    Object data = event.getData();
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.qiahao.base_common.model.im.RelationMessageData");
                    viewModel.checkRelationIm((RelationMessageData) data);
                    return;
                }
                return;
            case -594729792:
                if (type.equals("relation_success") && (event.getData() instanceof RelationMessageData)) {
                    Object data2 = event.getData();
                    Intrinsics.checkNotNull(data2, "null cannot be cast to non-null type com.qiahao.base_common.model.im.RelationMessageData");
                    RelationMessageData relationMessageData = (RelationMessageData) data2;
                    CpSpaceActivity.Companion companion = CpSpaceActivity.INSTANCE;
                    User receiver = relationMessageData.getReceiver();
                    if (receiver == null || (str = receiver.getExternalId()) == null) {
                        str = "";
                    }
                    User sender = relationMessageData.getSender();
                    if (sender != null && (externalId = sender.getExternalId()) != null) {
                        str3 = externalId;
                    }
                    Integer type2 = relationMessageData.getType();
                    if (type2 != null) {
                        i = type2.intValue();
                    } else {
                        i = 0;
                    }
                    companion.startActivity(this, str, str3, i);
                    return;
                }
                return;
            case 1185617970:
                if (type.equals("cp_invite_or_cancel") && (event.getData() instanceof CpMessageData)) {
                    ChatViewModel viewModel2 = getViewModel();
                    Object data3 = event.getData();
                    Intrinsics.checkNotNull(data3, "null cannot be cast to non-null type com.qiahao.base_common.model.im.CpMessageData");
                    viewModel2.checkCpIm((CpMessageData) data3);
                    return;
                }
                return;
            case 1939617329:
                if (type.equals("cp_success")) {
                    CpSpaceActivity.Companion companion2 = CpSpaceActivity.INSTANCE;
                    User user = UserStore.INSTANCE.getShared().getUser();
                    if (user == null || (externalId2 = user.getExternalId()) == null) {
                        str2 = "";
                    } else {
                        str2 = externalId2;
                    }
                    CpSpaceActivity.Companion.startActivity$default(companion2, this, str2, null, 0, 12, null);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        MessageProvide.displayData$default(MessageProvide.INSTANCE, null, 1, null);
        getBinding().chatView.exitChat();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        getWindow().addFlags(128);
        super.onInitialize();
        initChatDialog();
        initView();
        initChatView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onPause() {
        super.onPause();
        getBinding().chatView.mInputView.setDraft();
        getBinding().chatView.markMessageAsRead();
        MessageProvide.displayData$default(MessageProvide.INSTANCE, null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onRoomEvent(@NotNull RoomEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int mEventId = event.getMEventId();
        if (mEventId != 214) {
            if (mEventId != 501) {
                if (mEventId != 300) {
                    if (mEventId == 301) {
                        finish();
                        return;
                    }
                    return;
                }
                finish();
                return;
            }
            finish();
            return;
        }
        finish();
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
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(ChatApi.DefaultImpls.userChatSendGift$default(apis, str, j, str2, number, selectedGiftItem.getGiftText(), null, 32, null), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.y
            public final Object invoke(Object obj) {
                Unit sendGift$lambda$20;
                sendGift$lambda$20 = ChatDialogActivity.sendGift$lambda$20(selectedGiftItem, number, this, (ApiResponse) obj);
                return sendGift$lambda$20;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.z
            public final Object invoke(Object obj) {
                Unit sendGift$lambda$21;
                sendGift$lambda$21 = ChatDialogActivity.sendGift$lambda$21(ChatDialogActivity.this, (Throwable) obj);
                return sendGift$lambda$21;
            }
        }, (Function0) null, false, 12, (Object) null), getViewModel().getMCompositeDisposable());
    }

    public final void setGiftText(@NotNull SVGADynamicEntity dynamicEntity, @NotNull GiftData data, @NotNull String key, @NotNull String text) {
        int parseColor;
        Typeface typeface;
        Typeface typeface2;
        Intrinsics.checkNotNullParameter(dynamicEntity, "dynamicEntity");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(text, "text");
        List<TextStyles> textStyleList = data.getTextStyleList();
        TextStyles textStyles = null;
        if (textStyleList != null) {
            for (TextStyles textStyles2 : textStyleList) {
                if (Intrinsics.areEqual(textStyles2.getTextKey(), key)) {
                    textStyles = textStyles2;
                }
            }
        }
        if (textStyles == null) {
            return;
        }
        try {
            String textColor = textStyles.getTextColor();
            if (textColor == null) {
                textColor = "#000000";
            }
            parseColor = Color.parseColor(textColor);
        } catch (Exception unused) {
            parseColor = Color.parseColor("#000000");
        }
        float f = 15.0f;
        if (Intrinsics.areEqual(key, SVGAUtil.SENDER_NAME)) {
            SVGAUtil sVGAUtil = SVGAUtil.INSTANCE;
            String maxLengthSuffix = DataExternalKt.maxLengthSuffix(text, 8, "..");
            Integer valueOf = Integer.valueOf(parseColor);
            Float textSize = textStyles.getTextSize();
            if (textSize != null) {
                f = textSize.floatValue();
            }
            Float valueOf2 = Float.valueOf(f);
            if (Intrinsics.areEqual(textStyles.isBold(), Boolean.TRUE)) {
                typeface2 = Typeface.DEFAULT_BOLD;
            } else {
                typeface2 = Typeface.DEFAULT;
            }
            sVGAUtil.setText(dynamicEntity, maxLengthSuffix, key, valueOf, valueOf2, typeface2, Layout.Alignment.ALIGN_CENTER);
            return;
        }
        if (Intrinsics.areEqual(key, SVGAUtil.RECEIVER_NAME)) {
            SVGAUtil sVGAUtil2 = SVGAUtil.INSTANCE;
            String maxLengthSuffix2 = DataExternalKt.maxLengthSuffix(text, 8, "..");
            Integer valueOf3 = Integer.valueOf(parseColor);
            Float textSize2 = textStyles.getTextSize();
            if (textSize2 != null) {
                f = textSize2.floatValue();
            }
            Float valueOf4 = Float.valueOf(f);
            if (Intrinsics.areEqual(textStyles.isBold(), Boolean.TRUE)) {
                typeface = Typeface.DEFAULT_BOLD;
            } else {
                typeface = Typeface.DEFAULT;
            }
            sVGAUtil2.setText(dynamicEntity, maxLengthSuffix2, key, valueOf3, valueOf4, typeface, Layout.Alignment.ALIGN_CENTER);
        }
    }

    public final void showGiftDialog() {
        User user = this.mUser;
        if (user != null) {
            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            BaseControlUtils.showChatGiftDialog$default(baseControlUtils, supportFragmentManager, user, new SendGiftListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatDialogActivity$showGiftDialog$1$1
                public void begGift(GiftData data, int number) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SendGiftListener.DefaultImpls.begGift(this, data, number);
                    ChatDialogActivity.this.begGiftSuccess(data, number);
                }

                public void giftsChoose(GiftData selectedGiftItem, int number, ArrayList<String> extraIdList, boolean isAllMic) {
                    Intrinsics.checkNotNullParameter(selectedGiftItem, "selectedGiftItem");
                    Intrinsics.checkNotNullParameter(extraIdList, "extraIdList");
                    ChatDialogActivity.this.sendGift(selectedGiftItem, number);
                }

                public void roomGiftsChoose(GiftData giftData, int i, ArrayList<String> arrayList, int i2) {
                    SendGiftListener.DefaultImpls.roomGiftsChoose(this, giftData, i, arrayList, i2);
                }

                public void showRechargeView() {
                    BaseControlUtils.INSTANCE.startWallet();
                }
            }, (String) null, (Boolean) null, 24, (Object) null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showReportDialog() {
        new ReportWhiteDialog(this).setListener(new ChatDialogActivity$showReportDialog$1(this)).show();
    }
}
