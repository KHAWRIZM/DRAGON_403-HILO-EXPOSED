package com.qiahao.nextvideo.ui.home.chat.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcelable;
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
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.StringKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.interfaceing.SendGiftListener;
import com.qiahao.base_common.model.GiftData;
import com.qiahao.base_common.model.common.CanChat;
import com.qiahao.base_common.model.common.ChannelEventGiftAddTime;
import com.qiahao.base_common.model.common.CheckSessionBean;
import com.qiahao.base_common.model.common.LikeResult;
import com.qiahao.base_common.model.common.User;
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
import com.qiahao.nextvideo.databinding.ActivityChatBinding;
import com.qiahao.nextvideo.room.help.GameJum;
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

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u0010 \u001a\u00020\u0019H\u0002J\u0006\u0010!\u001a\u00020\u0019J\u0006\u0010\"\u001a\u00020\u0019J\u0006\u0010#\u001a\u00020\u0019J\u0018\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0017H\u0002J\b\u0010(\u001a\u00020\u0019H\u0002J\u001a\u0010)\u001a\u00020\u00192\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010+H\u0002J\u0016\u0010,\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0017J\b\u0010-\u001a\u00020\u0019H\u0014J\b\u0010.\u001a\u00020\u0019H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u00060"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/activity/ChatActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityChatBinding;", "<init>", "()V", "presenter", "Lcom/tencent/qcloud/tuikit/tuichat/presenter/C2CChatPresenter;", TUIChatConstants.CHAT_INFO, "Lcom/tencent/qcloud/tuikit/tuichat/bean/ChatInfo;", "mUser", "Lcom/qiahao/base_common/model/common/User;", "isDialog", "", "()Z", "setDialog", "(Z)V", "viewModel", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewModel/ChatViewModel;", "getViewModel", "()Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewModel/ChatViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getLayoutResId", "", "onInitialize", "", "onC2CEvent", "event", "Lcom/qiahao/base_common/model/eventBus/C2CEvent;", "initChatDialog", "initView", "initChatView", "showMenuDialog", "showReportDialog", TUIConstants.TUIConversation.METHOD_DELETE_CONVERSATION, "showGiftDialog", "begGiftSuccess", "selectedGiftItem", "Lcom/qiahao/base_common/model/GiftData;", FamilySettingFragment.FAMILY_NUMBER, "videoCallButtonPressed", "requestLikeUser", com.taobao.agoo.a.a.b.JSON_SUCCESS, "Lkotlin/Function0;", "sendGift", "onPause", "onDestroy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nChatActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChatActivity.kt\ncom/qiahao/nextvideo/ui/home/chat/activity/ChatActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,682:1\n61#2,9:683\n61#2,9:692\n1#3:701\n*S KotlinDebug\n*F\n+ 1 ChatActivity.kt\ncom/qiahao/nextvideo/ui/home/chat/activity/ChatActivity\n*L\n186#1:683,9\n189#1:692,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ChatActivity extends HiloBaseBindingActivity<ActivityChatBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String IS_DIALOG = "isDialog";

    @NotNull
    public static final String USER = "user";

    @Nullable
    private ChatInfo chatInfo;
    private boolean isDialog;

    @Nullable
    private User mUser;

    @Nullable
    private C2CChatPresenter presenter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.o
        public final Object invoke() {
            ChatViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = ChatActivity.viewModel_delegate$lambda$0(ChatActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/activity/ChatActivity$Companion;", "", "<init>", "()V", "USER", "", StrangeMatchActivity.IS_DIALOG, "start", "", "context", "Landroid/content/Context;", "user", "Lcom/qiahao/base_common/model/common/User;", "isDialog", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, User user, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            companion.start(context, user, z);
        }

        public final void start(@NotNull Context context, @NotNull User user, boolean isDialog) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(user, "user");
            Intent intent = new Intent(context, (Class<?>) ChatActivity.class);
            intent.putExtra("user", (Parcelable) user);
            intent.putExtra("isDialog", isDialog);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00dd A[Catch: Exception -> 0x013b, TryCatch #0 {Exception -> 0x013b, blocks: (B:34:0x00a4, B:36:0x00b2, B:40:0x00bc, B:42:0x00c0, B:46:0x00ca, B:48:0x00dd, B:50:0x00e3, B:53:0x00f5, B:55:0x00fb, B:57:0x0101, B:59:0x0110, B:61:0x0116, B:63:0x011c, B:65:0x012c, B:69:0x0134), top: B:33:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fb A[Catch: Exception -> 0x013b, TryCatch #0 {Exception -> 0x013b, blocks: (B:34:0x00a4, B:36:0x00b2, B:40:0x00bc, B:42:0x00c0, B:46:0x00ca, B:48:0x00dd, B:50:0x00e3, B:53:0x00f5, B:55:0x00fb, B:57:0x0101, B:59:0x0110, B:61:0x0116, B:63:0x011c, B:65:0x012c, B:69:0x0134), top: B:33:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0116 A[Catch: Exception -> 0x013b, TryCatch #0 {Exception -> 0x013b, blocks: (B:34:0x00a4, B:36:0x00b2, B:40:0x00bc, B:42:0x00c0, B:46:0x00ca, B:48:0x00dd, B:50:0x00e3, B:53:0x00f5, B:55:0x00fb, B:57:0x0101, B:59:0x0110, B:61:0x0116, B:63:0x011c, B:65:0x012c, B:69:0x0134), top: B:33:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void begGiftSuccess(GiftData selectedGiftItem, int r13) {
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
        String svgaUrl3;
        String urlMP4;
        String nick;
        String nick2;
        User user2;
        User user3;
        String str7;
        selectedGiftItem.setNum(r13);
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
        String str8 = "";
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
            String svgaUrl4 = selectedGiftItem.getSvgaUrl();
            User user7 = companion.getShared().getUser();
            if (user7 != null && (nick2 = user7.getNick()) != null) {
                str5 = nick2;
                user = this.mUser;
                if (user != null && (nick = user.getNick()) != null) {
                    str6 = nick;
                    GiftDateItem chatToGift = DataExternalKt.chatToGift(svgaUrl4, str3, str4, str5, str6, selectedGiftItem.getGiftText(), selectedGiftItem.getTextStyleList());
                    svgaUrl = selectedGiftItem.getSvgaUrl();
                    if (svgaUrl == null && StringKtxKt.checkEndSVGA(svgaUrl)) {
                        ((ActivityChatBinding) getBinding()).queuePlayer.addQueue(GiftHelp.INSTANCE.getSVGAData(chatToGift));
                        return;
                    }
                    svgaUrl2 = selectedGiftItem.getSvgaUrl();
                    if (svgaUrl2 == null && StringKtxKt.checkEndMP4(svgaUrl2)) {
                        GiftHelp.INSTANCE.getVAP2(chatToGift, LifecycleOwnerKt.getLifecycleScope(this), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.d
                            public final Object invoke(Object obj) {
                                Unit begGiftSuccess$lambda$17;
                                begGiftSuccess$lambda$17 = ChatActivity.begGiftSuccess$lambda$17(ChatActivity.this, (VapMediaSource) obj);
                                return begGiftSuccess$lambda$17;
                            }
                        }, this);
                        return;
                    }
                    svgaUrl3 = selectedGiftItem.getSvgaUrl();
                    if (svgaUrl3 == null && StringKtxKt.checkDefaultMP4(svgaUrl3)) {
                        LightQueueCombinationPlayer lightQueueCombinationPlayer = ((ActivityChatBinding) getBinding()).queuePlayer;
                        String svgaUrl5 = selectedGiftItem.getSvgaUrl();
                        if (svgaUrl5 != null && (urlMP4 = StringKtxKt.urlMP4(svgaUrl5)) != null) {
                            str8 = urlMP4;
                        }
                        lightQueueCombinationPlayer.addQueue(new VideoMediaSource(str8));
                        return;
                    }
                    return;
                }
                str6 = "";
                GiftDateItem chatToGift2 = DataExternalKt.chatToGift(svgaUrl4, str3, str4, str5, str6, selectedGiftItem.getGiftText(), selectedGiftItem.getTextStyleList());
                svgaUrl = selectedGiftItem.getSvgaUrl();
                if (svgaUrl == null) {
                }
                svgaUrl2 = selectedGiftItem.getSvgaUrl();
                if (svgaUrl2 == null) {
                }
                svgaUrl3 = selectedGiftItem.getSvgaUrl();
                if (svgaUrl3 == null) {
                    return;
                } else {
                    return;
                }
            }
            str5 = "";
            user = this.mUser;
            if (user != null) {
                str6 = nick;
                GiftDateItem chatToGift22 = DataExternalKt.chatToGift(svgaUrl4, str3, str4, str5, str6, selectedGiftItem.getGiftText(), selectedGiftItem.getTextStyleList());
                svgaUrl = selectedGiftItem.getSvgaUrl();
                if (svgaUrl == null) {
                }
                svgaUrl2 = selectedGiftItem.getSvgaUrl();
                if (svgaUrl2 == null) {
                }
                svgaUrl3 = selectedGiftItem.getSvgaUrl();
                if (svgaUrl3 == null) {
                }
            }
            str6 = "";
            GiftDateItem chatToGift222 = DataExternalKt.chatToGift(svgaUrl4, str3, str4, str5, str6, selectedGiftItem.getGiftText(), selectedGiftItem.getTextStyleList());
            svgaUrl = selectedGiftItem.getSvgaUrl();
            if (svgaUrl == null) {
            }
            svgaUrl2 = selectedGiftItem.getSvgaUrl();
            if (svgaUrl2 == null) {
            }
            svgaUrl3 = selectedGiftItem.getSvgaUrl();
            if (svgaUrl3 == null) {
            }
        } catch (Exception unused) {
            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "播放礼物出错", false, 4, (Object) null);
        }
    }

    public static final Unit begGiftSuccess$lambda$17(ChatActivity chatActivity, VapMediaSource vapMediaSource) {
        Intrinsics.checkNotNullParameter(vapMediaSource, "it");
        chatActivity.getBinding().queuePlayer.addQueue(vapMediaSource);
        return Unit.INSTANCE;
    }

    public final ChatViewModel getViewModel() {
        return (ChatViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initChatDialog() {
        User parcelableExtra = getIntent().getParcelableExtra("user");
        this.mUser = parcelableExtra;
        if (parcelableExtra == null) {
            finish();
        }
        boolean booleanExtra = getIntent().getBooleanExtra("isDialog", false);
        this.isDialog = booleanExtra;
        if (booleanExtra) {
            getWindow().addFlags(128);
            getWindow().setLayout(-1, -1);
            getWindow().setGravity(80);
            getWindow().setSoftInputMode(32);
            ViewGroup.LayoutParams layoutParams = ((ActivityChatBinding) getBinding()).activityMainContainer.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            Dimens dimens = Dimens.INSTANCE;
            layoutParams2.height = ((dimens.getScreenHeight() / 5) * 4) - dimens.dpToPx(48);
            layoutParams2.width = dimens.getScreenWidth();
            layoutParams2.gravity = 80;
            ((ActivityChatBinding) getBinding()).activityMainContainer.setLayoutParams(layoutParams2);
            ((ActivityChatBinding) getBinding()).constraint.setBackground(androidx.core.content.a.getDrawable(this, R.drawable.shape_commom_frame_view));
            return;
        }
        View view = ((ActivityChatBinding) getBinding()).bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.e
            public final Object invoke(Object obj, Object obj2) {
                Unit initChatDialog$lambda$1;
                initChatDialog$lambda$1 = ChatActivity.initChatDialog$lambda$1(ChatActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initChatDialog$lambda$1;
            }
        });
        getTheme().applyStyle(0, true);
    }

    public static final Unit initChatDialog$lambda$1(ChatActivity chatActivity, int i, int i2) {
        chatActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0141  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initChatView() {
        String str;
        boolean z;
        boolean z2;
        User user;
        int i;
        User user2;
        User user3;
        C2CChatPresenter c2CChatPresenter;
        User user4;
        String externalId;
        CanChat chat;
        CanChat chat2;
        SvipData svip;
        boolean z3;
        Boolean isLikeMe;
        Boolean isLike;
        long j;
        int i2;
        String str2;
        String str3;
        C2CChatPresenter c2CChatPresenter2 = new C2CChatPresenter();
        this.presenter = c2CChatPresenter2;
        c2CChatPresenter2.initListener();
        ChatInfo chatInfo = new ChatInfo();
        this.chatInfo = chatInfo;
        User user5 = this.mUser;
        if (user5 != null) {
            str = user5.getNick();
        } else {
            str = null;
        }
        chatInfo.setChatName(str);
        ChatInfo chatInfo2 = this.chatInfo;
        String str4 = "";
        if (chatInfo2 != null) {
            User user6 = this.mUser;
            if (user6 == null || (str3 = user6.getExternalId()) == null) {
                str3 = "";
            }
            chatInfo2.setId(str3);
        }
        ChatInfo chatInfo3 = this.chatInfo;
        if (chatInfo3 != null) {
            User user7 = this.mUser;
            if (user7 == null || (str2 = user7.getAvatar()) == null) {
                str2 = "";
            }
            chatInfo3.setFaceUrl(str2);
        }
        getBinding().chatView.initDefault();
        getBinding().chatView.mMessageRecyclerView.setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatActivity$initChatView$1
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
            public void onMessageClick(View view, int position, TUIMessageBean messageInfo) {
                super.onMessageClick(view, position, messageInfo);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
            public void onMessageLongClick(View view, int position, TUIMessageBean messageInfo) {
                super.onMessageLongClick(view, position, messageInfo);
            }

            /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
            
                r1 = r0.this$0.presenter;
             */
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onTypeClick(View view, int position, TUIMessageBean messageInfo, int type) {
                C2CChatPresenter c2CChatPresenter3;
                C2CChatPresenter c2CChatPresenter4;
                super.onTypeClick(view, position, messageInfo, type);
                if (type != 1) {
                    if (type == 2) {
                        c2CChatPresenter3 = ChatActivity.this.presenter;
                        if (c2CChatPresenter3 != null) {
                            c2CChatPresenter3.deleteMessage(messageInfo);
                            return;
                        }
                        return;
                    }
                    if (type == 7 && c2CChatPresenter4 != null) {
                        c2CChatPresenter4.revokeMessage(messageInfo);
                        return;
                    }
                    return;
                }
                Object systemService = ChatActivity.this.getSystemService("clipboard");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                Intrinsics.checkNotNull(messageInfo, "null cannot be cast to non-null type com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean");
                String text = ((TextMessageBean) messageInfo).getText();
                Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(Constants.SHARED_MESSAGE_ID_FILE, text));
                if (!TextUtils.isEmpty(text)) {
                    String string = ChatActivity.this.getResources().getString(2131954177);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    ToastUtil.toastShortMessage(string);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
            public void onUserIconClick(View view, int position, TUIMessageBean messageInfo) {
                String str5;
                super.onUserIconClick(view, position, messageInfo);
                AppRequestUtils appRequestUtils = AppRequestUtils.INSTANCE;
                if (messageInfo != null) {
                    str5 = messageInfo.getSender();
                } else {
                    str5 = null;
                }
                appRequestUtils.openPersonPage(str5, true);
            }
        });
        UserStore.Companion companion = UserStore.INSTANCE;
        User user8 = companion.getShared().getUser();
        int i3 = 0;
        if (user8 != null && user8.isAr()) {
            HiloChatView hiloChatView = getBinding().chatView;
            User user9 = companion.getShared().getUser();
            if (user9 != null) {
                j = user9.getWealthUserGrade();
            } else {
                j = 0;
            }
            if (j > 10) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            hiloChatView.showVideo(i2);
        } else {
            getBinding().chatView.showVideo(0);
        }
        User user10 = this.mUser;
        if (user10 != null && (isLike = user10.isLike()) != null) {
            z = isLike.booleanValue();
        } else {
            z = false;
        }
        if (z) {
            User user11 = this.mUser;
            if (user11 != null && (isLikeMe = user11.isLikeMe()) != null) {
                z3 = isLikeMe.booleanValue();
            } else {
                z3 = false;
            }
            if (z3) {
                z2 = true;
                HiloChatView hiloChatView2 = getBinding().chatView;
                Boolean valueOf = Boolean.valueOf(!z2);
                user = companion.getShared().getUser();
                if (user == null && (svip = user.getSvip()) != null) {
                    i = svip.getSvipLevel();
                } else {
                    i = 0;
                }
                user2 = this.mUser;
                if (user2 != null && (chat2 = user2.getChat()) != null) {
                    i3 = chat2.getChatLeftUserCnt();
                }
                hiloChatView2.showSvip(valueOf, i, i3);
                HiloChatView hiloChatView3 = getBinding().chatView;
                user3 = this.mUser;
                if (user3 != null || (chat = user3.getChat()) == null || (r2 = chat.getChatTips()) == null) {
                    String str5 = "";
                }
                hiloChatView3.showTip(str5);
                getBinding().chatView.mInputView.setOnInputViewListener(new C2CInputView.OnInputViewListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatActivity$initChatView$2
                    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.OnInputViewListener
                    public void onClickGame(int gameId) {
                        ChatViewModel viewModel;
                        User user12;
                        String str6;
                        viewModel = ChatActivity.this.getViewModel();
                        user12 = ChatActivity.this.mUser;
                        if (user12 == null || (str6 = user12.getExternalId()) == null) {
                            str6 = "";
                        }
                        ChatViewModel.inviteSheep$default(viewModel, str6, gameId, null, 4, null);
                    }

                    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.OnInputViewListener
                    public void onClickGift() {
                        ChatActivity.this.showGiftDialog();
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
                    
                        if (r0 == false) goto L١٢;
                     */
                    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.OnInputViewListener
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void onClickImage() {
                        User user12;
                        boolean z4;
                        User user13;
                        boolean z5;
                        ActivityChatBinding binding;
                        User user14;
                        boolean z6;
                        user12 = ChatActivity.this.mUser;
                        boolean z7 = false;
                        if (user12 != null) {
                            z4 = Intrinsics.areEqual(user12.isLike(), Boolean.TRUE);
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            user14 = ChatActivity.this.mUser;
                            if (user14 != null) {
                                z6 = Intrinsics.areEqual(user14.isLikeMe(), Boolean.TRUE);
                            } else {
                                z6 = false;
                            }
                        }
                        user13 = ChatActivity.this.mUser;
                        if (user13 != null && user13.isOfficialStaff()) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (!z5) {
                            User user15 = UserStore.INSTANCE.getShared().getUser();
                            if (user15 != null && user15.isOfficialStaff()) {
                                z7 = true;
                            }
                            if (!z7) {
                                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ChatActivity.this, ResourcesKtxKt.getStringById(this, 2131953224), false, 4, (Object) null);
                                if (normal$default != null) {
                                    normal$default.show();
                                    return;
                                }
                                return;
                            }
                        }
                        binding = ChatActivity.this.getBinding();
                        binding.chatView.mInputView.sendPicture();
                    }

                    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.OnInputViewListener
                    public void onClickVideo() {
                        ChatActivity.this.videoCallButtonPressed();
                    }

                    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.OnInputViewListener
                    public void onStartGroupMemberSelectActivity() {
                    }

                    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.OnInputViewListener
                    public void onUpdateChatBackground() {
                    }
                });
                getBinding().chatView.setPresenter(this.presenter);
                c2CChatPresenter = this.presenter;
                if (c2CChatPresenter != null) {
                    c2CChatPresenter.setChatInfo(this.chatInfo);
                }
                getBinding().chatView.setChatInfo(this.chatInfo);
                getBinding().chatView.markMessageAsRead();
                getViewModel().getMSheepId().observe(this, new ChatActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.a
                    public final Object invoke(Object obj) {
                        Unit initChatView$lambda$6;
                        initChatView$lambda$6 = ChatActivity.initChatView$lambda$6((Integer) obj);
                        return initChatView$lambda$6;
                    }
                }));
                getViewModel().getMSnakeId().observe(this, new ChatActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.h
                    public final Object invoke(Object obj) {
                        Unit initChatView$lambda$8;
                        initChatView$lambda$8 = ChatActivity.initChatView$lambda$8((Integer) obj);
                        return initChatView$lambda$8;
                    }
                }));
                getViewModel().getMException().observe(this, new ChatActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.i
                    public final Object invoke(Object obj) {
                        Unit initChatView$lambda$9;
                        initChatView$lambda$9 = ChatActivity.initChatView$lambda$9(ChatActivity.this, (Pair) obj);
                        return initChatView$lambda$9;
                    }
                }));
                getViewModel().getImType().observe(this, new ChatActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.j
                    public final Object invoke(Object obj) {
                        Unit initChatView$lambda$11;
                        initChatView$lambda$11 = ChatActivity.initChatView$lambda$11(ChatActivity.this, (CpMessageData) obj);
                        return initChatView$lambda$11;
                    }
                }));
                getViewModel().getImRelation().observe(this, new ChatActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.k
                    public final Object invoke(Object obj) {
                        Unit initChatView$lambda$13;
                        initChatView$lambda$13 = ChatActivity.initChatView$lambda$13(ChatActivity.this, (RelationMessageData) obj);
                        return initChatView$lambda$13;
                    }
                }));
                getViewModel().getCanChat().observe(this, new ChatActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.l
                    public final Object invoke(Object obj) {
                        Unit initChatView$lambda$15;
                        initChatView$lambda$15 = ChatActivity.initChatView$lambda$15(ChatActivity.this, (CheckSessionBean) obj);
                        return initChatView$lambda$15;
                    }
                }));
                ChatViewModel viewModel = getViewModel();
                user4 = this.mUser;
                if (user4 != null && (externalId = user4.getExternalId()) != null) {
                    str4 = externalId;
                }
                viewModel.checkChat(str4);
            }
        }
        z2 = false;
        HiloChatView hiloChatView22 = getBinding().chatView;
        Boolean valueOf2 = Boolean.valueOf(!z2);
        user = companion.getShared().getUser();
        if (user == null) {
        }
        i = 0;
        user2 = this.mUser;
        if (user2 != null) {
            i3 = chat2.getChatLeftUserCnt();
        }
        hiloChatView22.showSvip(valueOf2, i, i3);
        HiloChatView hiloChatView32 = getBinding().chatView;
        user3 = this.mUser;
        if (user3 != null) {
        }
        String str52 = "";
        hiloChatView32.showTip(str52);
        getBinding().chatView.mInputView.setOnInputViewListener(new C2CInputView.OnInputViewListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatActivity$initChatView$2
            @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.OnInputViewListener
            public void onClickGame(int gameId) {
                ChatViewModel viewModel2;
                User user12;
                String str6;
                viewModel2 = ChatActivity.this.getViewModel();
                user12 = ChatActivity.this.mUser;
                if (user12 == null || (str6 = user12.getExternalId()) == null) {
                    str6 = "";
                }
                ChatViewModel.inviteSheep$default(viewModel2, str6, gameId, null, 4, null);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.OnInputViewListener
            public void onClickGift() {
                ChatActivity.this.showGiftDialog();
            }

            /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
            
                if (r0 == false) goto L١٢;
             */
            @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.OnInputViewListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onClickImage() {
                User user12;
                boolean z4;
                User user13;
                boolean z5;
                ActivityChatBinding binding;
                User user14;
                boolean z6;
                user12 = ChatActivity.this.mUser;
                boolean z7 = false;
                if (user12 != null) {
                    z4 = Intrinsics.areEqual(user12.isLike(), Boolean.TRUE);
                } else {
                    z4 = false;
                }
                if (z4) {
                    user14 = ChatActivity.this.mUser;
                    if (user14 != null) {
                        z6 = Intrinsics.areEqual(user14.isLikeMe(), Boolean.TRUE);
                    } else {
                        z6 = false;
                    }
                }
                user13 = ChatActivity.this.mUser;
                if (user13 != null && user13.isOfficialStaff()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (!z5) {
                    User user15 = UserStore.INSTANCE.getShared().getUser();
                    if (user15 != null && user15.isOfficialStaff()) {
                        z7 = true;
                    }
                    if (!z7) {
                        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ChatActivity.this, ResourcesKtxKt.getStringById(this, 2131953224), false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                            return;
                        }
                        return;
                    }
                }
                binding = ChatActivity.this.getBinding();
                binding.chatView.mInputView.sendPicture();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.OnInputViewListener
            public void onClickVideo() {
                ChatActivity.this.videoCallButtonPressed();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.OnInputViewListener
            public void onStartGroupMemberSelectActivity() {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.OnInputViewListener
            public void onUpdateChatBackground() {
            }
        });
        getBinding().chatView.setPresenter(this.presenter);
        c2CChatPresenter = this.presenter;
        if (c2CChatPresenter != null) {
        }
        getBinding().chatView.setChatInfo(this.chatInfo);
        getBinding().chatView.markMessageAsRead();
        getViewModel().getMSheepId().observe(this, new ChatActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.a
            public final Object invoke(Object obj) {
                Unit initChatView$lambda$6;
                initChatView$lambda$6 = ChatActivity.initChatView$lambda$6((Integer) obj);
                return initChatView$lambda$6;
            }
        }));
        getViewModel().getMSnakeId().observe(this, new ChatActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.h
            public final Object invoke(Object obj) {
                Unit initChatView$lambda$8;
                initChatView$lambda$8 = ChatActivity.initChatView$lambda$8((Integer) obj);
                return initChatView$lambda$8;
            }
        }));
        getViewModel().getMException().observe(this, new ChatActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.i
            public final Object invoke(Object obj) {
                Unit initChatView$lambda$9;
                initChatView$lambda$9 = ChatActivity.initChatView$lambda$9(ChatActivity.this, (Pair) obj);
                return initChatView$lambda$9;
            }
        }));
        getViewModel().getImType().observe(this, new ChatActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.j
            public final Object invoke(Object obj) {
                Unit initChatView$lambda$11;
                initChatView$lambda$11 = ChatActivity.initChatView$lambda$11(ChatActivity.this, (CpMessageData) obj);
                return initChatView$lambda$11;
            }
        }));
        getViewModel().getImRelation().observe(this, new ChatActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.k
            public final Object invoke(Object obj) {
                Unit initChatView$lambda$13;
                initChatView$lambda$13 = ChatActivity.initChatView$lambda$13(ChatActivity.this, (RelationMessageData) obj);
                return initChatView$lambda$13;
            }
        }));
        getViewModel().getCanChat().observe(this, new ChatActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.l
            public final Object invoke(Object obj) {
                Unit initChatView$lambda$15;
                initChatView$lambda$15 = ChatActivity.initChatView$lambda$15(ChatActivity.this, (CheckSessionBean) obj);
                return initChatView$lambda$15;
            }
        }));
        ChatViewModel viewModel2 = getViewModel();
        user4 = this.mUser;
        if (user4 != null) {
            str4 = externalId;
        }
        viewModel2.checkChat(str4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initChatView$lambda$11(ChatActivity chatActivity, CpMessageData cpMessageData) {
        Integer msgType = cpMessageData.getMsgType();
        if (msgType != null && msgType.intValue() == 1) {
            User user = chatActivity.mUser;
            if (user != null) {
                String msg = cpMessageData.getMsg();
                if (msg == null) {
                    msg = "";
                }
                new CpInvitationReceiveDialog(chatActivity, user, msg).show();
            }
        } else {
            Integer msgType2 = cpMessageData.getMsgType();
            if (msgType2 != null && msgType2.intValue() == 2) {
                BaseControlUtils.INSTANCE.showCpDialog(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatActivity$initChatView$6$2
                    public void cancel() {
                        OnCommonDialogListener.DefaultImpls.cancel(this);
                    }

                    public void confirm() {
                        ChatViewModel viewModel;
                        User user2;
                        String str;
                        viewModel = ChatActivity.this.getViewModel();
                        user2 = ChatActivity.this.mUser;
                        if (user2 == null || (str = user2.getExternalId()) == null) {
                            str = "";
                        }
                        viewModel.cpReply(str, 2);
                    }
                }, ResourcesKtxKt.getStringById(chatActivity, 2131952448));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initChatView$lambda$13(ChatActivity chatActivity, final RelationMessageData relationMessageData) {
        Integer msgType = relationMessageData.getMsgType();
        if (msgType != null && msgType.intValue() == 1) {
            User user = chatActivity.mUser;
            if (user != null) {
                new RelationInvitationReceiveDialog(chatActivity, user, relationMessageData).show();
            }
        } else {
            Integer msgType2 = relationMessageData.getMsgType();
            if (msgType2 != null && msgType2.intValue() == 2) {
                BaseControlUtils.INSTANCE.showRelationDialog(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatActivity$initChatView$7$2
                    public void cancel() {
                        OnCommonDialogListener.DefaultImpls.cancel(this);
                    }

                    public void confirm() {
                        ChatViewModel viewModel;
                        User user2;
                        String str;
                        int i;
                        viewModel = ChatActivity.this.getViewModel();
                        user2 = ChatActivity.this.mUser;
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
                }, ResourcesKtxKt.getStringById(chatActivity, 2131954186));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initChatView$lambda$15(ChatActivity chatActivity, CheckSessionBean checkSessionBean) {
        Integer num;
        if (checkSessionBean != null) {
            num = Integer.valueOf(checkSessionBean.getCanTalk());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 2) {
            TipDialog confirmContent = new TipDialog(chatActivity).setTipContent(ResourcesKtxKt.getStringById(chatActivity, 2131953227)).setConfirmContent(ResourcesKtxKt.getStringById(chatActivity, 2131953219));
            confirmContent.setCanceledOnTouchOutside(false);
            confirmContent.setDialogListener(new ChatActivity$initChatView$8$2(chatActivity)).show();
        } else if (num != null && num.intValue() == 3) {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, chatActivity, ResourcesKtxKt.getStringById(chatActivity, 2131953227), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            chatActivity.finish();
        }
        return Unit.INSTANCE;
    }

    public static final Unit initChatView$lambda$6(Integer num) {
        int intValue;
        if (num != null && (intValue = num.intValue()) > 0) {
            GameJum.matchGame$default(GameJum.INSTANCE, intValue, 9, 0, 0, null, 28, null);
        }
        return Unit.INSTANCE;
    }

    public static final Unit initChatView$lambda$8(Integer num) {
        int intValue;
        if (num != null && (intValue = num.intValue()) > 0) {
            GameJum.matchGame$default(GameJum.INSTANCE, intValue, 15, 0, 0, null, 28, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0053, code lost:
    
        r7 = com.qiahao.base_common.utils.HiloToasty.Companion.normal$default(r1, r7, r8, false, 4, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x005c, code lost:
    
        if (r7 == null) goto L٥٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005e, code lost:
    
        r7.show();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
    
        if (r0.equals(com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.ChatViewModel.CP_CANCEL) == false) goto L٥٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
    
        if (r0.equals(com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.ChatViewModel.RELATION_INVITE) == false) goto L٥٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        if (r0.equals(com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.ChatViewModel.RELATION_CANCEL) != false) goto L٤٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
    
        if (r0.equals(com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.ChatViewModel.CP_INVITE) == false) goto L٥٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0037, code lost:
    
        if ((r8.getSecond() instanceof com.qiahao.base_common.network.interceptors.HiloException) == false) goto L٥٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0039, code lost:
    
        r1 = com.qiahao.base_common.utils.HiloToasty.Companion;
        r8 = r8.getSecond();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
        r8 = ((com.qiahao.base_common.network.interceptors.HiloException) r8).getErrorMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x004a, code lost:
    
        if (r8 != null) goto L٤٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004c, code lost:
    
        r8 = com.oudi.utils.ktx.ResourcesKtxKt.getStringById(r7, 2131952667);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit initChatView$lambda$9(ChatActivity chatActivity, Pair pair) {
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
                ((ActivityChatBinding) getBinding()).svipType.setImageDrawable(androidx.core.content.a.getDrawable(this, svipType.intValue()));
            }
            ((ActivityChatBinding) getBinding()).svipType.setVisibility(0);
        } else {
            ((ActivityChatBinding) getBinding()).svipType.setVisibility(8);
        }
        TextView textView = ((ActivityChatBinding) getBinding()).newUser;
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
        ((ActivityChatBinding) getBinding()).newUser.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#27d1ad", "#5df2a0", 6, (GradientDrawable.Orientation) null, 8, (Object) null));
        AppCompatTextView appCompatTextView = ((ActivityChatBinding) getBinding()).title;
        User user4 = this.mUser;
        if (user4 == null || (str = user4.getNick()) == null) {
            str = "";
        }
        appCompatTextView.setText(str);
        final AppCompatImageView appCompatImageView = ((ActivityChatBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatActivity$initView$$inlined$singleClick$default$1
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
        final AppCompatImageView appCompatImageView2 = ((ActivityChatBinding) getBinding()).endImage;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatActivity$initView$$inlined$singleClick$default$2
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
    }

    public final void requestLikeUser(final Function0<Unit> r11) {
        String str;
        ChatViewModel viewModel = getViewModel();
        User user = this.mUser;
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(viewModel.requestLike(str, false), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.p
            public final Object invoke(Object obj) {
                Unit requestLikeUser$lambda$20;
                requestLikeUser$lambda$20 = ChatActivity.requestLikeUser$lambda$20(ChatActivity.this, r11, (ApiResponse) obj);
                return requestLikeUser$lambda$20;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.b
            public final Object invoke(Object obj) {
                Unit requestLikeUser$lambda$21;
                requestLikeUser$lambda$21 = ChatActivity.requestLikeUser$lambda$21(ChatActivity.this, (Throwable) obj);
                return requestLikeUser$lambda$21;
            }
        }, (Function0) null, false, 12, (Object) null), getViewModel().getMCompositeDisposable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void requestLikeUser$default(ChatActivity chatActivity, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        chatActivity.requestLikeUser(function0);
    }

    public static final Unit requestLikeUser$lambda$20(ChatActivity chatActivity, Function0 function0, ApiResponse apiResponse) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        User user = chatActivity.mUser;
        if (user != null) {
            LikeResult likeResult = (LikeResult) apiResponse.getData();
            if (likeResult != null) {
                bool = Boolean.valueOf(likeResult.getStatus());
            } else {
                bool = null;
            }
            user.setLike(bool);
        }
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit requestLikeUser$lambda$21(ChatActivity chatActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            int code = hiloException.getCode();
            if (code != 9004) {
                if (code != 9005) {
                    HiloToasty.Companion companion = HiloToasty.Companion;
                    String localizedMessage = hiloException.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = ResourcesKtxKt.getStringById(chatActivity, 2131952667);
                    }
                    Toast normal$default = HiloToasty.Companion.normal$default(companion, chatActivity, localizedMessage, false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                } else {
                    Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, chatActivity, ResourcesKtxKt.getStringById(chatActivity, 2131953231), false, 4, (Object) null);
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
                localizedMessage2 = ResourcesKtxKt.getStringById(chatActivity, 2131952667);
            }
            Toast normal$default3 = HiloToasty.Companion.normal$default(companion2, chatActivity, localizedMessage2, false, 4, (Object) null);
            if (normal$default3 != null) {
                normal$default3.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fc A[Catch: Exception -> 0x012f, TryCatch #0 {Exception -> 0x012f, blocks: (B:38:0x00c3, B:40:0x00d1, B:44:0x00db, B:46:0x00df, B:50:0x00e9, B:52:0x00fc, B:54:0x0102, B:58:0x0114, B:60:0x011a, B:62:0x0120), top: B:37:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011a A[Catch: Exception -> 0x012f, TryCatch #0 {Exception -> 0x012f, blocks: (B:38:0x00c3, B:40:0x00d1, B:44:0x00db, B:46:0x00df, B:50:0x00e9, B:52:0x00fc, B:54:0x0102, B:58:0x0114, B:60:0x011a, B:62:0x0120), top: B:37:0x00c3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit sendGift$lambda$23(GiftData giftData, int i, ChatActivity chatActivity, ApiResponse apiResponse) {
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
        GiftDateItem chatToGift;
        String svgaUrl2;
        String svgaUrl3;
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
        User user6 = chatActivity.mUser;
        if (user6 != null) {
            str2 = user6.getAvatar();
        } else {
            str2 = null;
        }
        giftData.setReceiverAvatar(str2);
        String s = BaseApplication.Companion.getGSON().s(TIMGiftMessage.Companion.init$default(TIMGiftMessage.Companion, "TIMGiftMessage", giftData, 0, 4, (Object) null));
        C2CChatPresenter c2CChatPresenter = chatActivity.presenter;
        if (c2CChatPresenter != null) {
            TUIMessageBean buildCustomMessage = ChatMessageBuilder.buildCustomMessage(s, ResourcesKtxKt.getStringById(chatActivity, 2131952885), null);
            User user7 = chatActivity.mUser;
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
        if (receiverAvatar2 == null || receiverAvatar2.length() != 0 ? (receiverAvatar = giftData.getReceiverAvatar()) == null : !((user3 = chatActivity.mUser) != null && (receiverAvatar = user3.getAvatar()) != null)) {
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
            user2 = chatActivity.mUser;
            if (user2 != null && (nick = user2.getNick()) != null) {
                str6 = nick;
                chatToGift = DataExternalKt.chatToGift(svgaUrl, str3, str4, str5, str6, giftData.getGiftText(), giftData.getTextStyleList());
                svgaUrl2 = giftData.getSvgaUrl();
                if (svgaUrl2 == null && StringKtxKt.checkEndSVGA(svgaUrl2)) {
                    ((ActivityChatBinding) chatActivity.getBinding()).queuePlayer.addQueue(GiftHelp.INSTANCE.getSVGAData(chatToGift));
                } else {
                    svgaUrl3 = giftData.getSvgaUrl();
                    if (svgaUrl3 != null && StringKtxKt.checkEndMP4(svgaUrl3)) {
                        GiftHelp.INSTANCE.getVAP2(chatToGift, LifecycleOwnerKt.getLifecycleScope(chatActivity), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.g
                            public final Object invoke(Object obj) {
                                Unit sendGift$lambda$23$lambda$22;
                                sendGift$lambda$23$lambda$22 = ChatActivity.sendGift$lambda$23$lambda$22(ChatActivity.this, (VapMediaSource) obj);
                                return sendGift$lambda$23$lambda$22;
                            }
                        }, chatActivity);
                    }
                }
                return Unit.INSTANCE;
            }
            str6 = "";
            chatToGift = DataExternalKt.chatToGift(svgaUrl, str3, str4, str5, str6, giftData.getGiftText(), giftData.getTextStyleList());
            svgaUrl2 = giftData.getSvgaUrl();
            if (svgaUrl2 == null) {
            }
            svgaUrl3 = giftData.getSvgaUrl();
            if (svgaUrl3 != null) {
                GiftHelp.INSTANCE.getVAP2(chatToGift, LifecycleOwnerKt.getLifecycleScope(chatActivity), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.g
                    public final Object invoke(Object obj) {
                        Unit sendGift$lambda$23$lambda$22;
                        sendGift$lambda$23$lambda$22 = ChatActivity.sendGift$lambda$23$lambda$22(ChatActivity.this, (VapMediaSource) obj);
                        return sendGift$lambda$23$lambda$22;
                    }
                }, chatActivity);
            }
            return Unit.INSTANCE;
        }
        str5 = "";
        user2 = chatActivity.mUser;
        if (user2 != null) {
            str6 = nick;
            chatToGift = DataExternalKt.chatToGift(svgaUrl, str3, str4, str5, str6, giftData.getGiftText(), giftData.getTextStyleList());
            svgaUrl2 = giftData.getSvgaUrl();
            if (svgaUrl2 == null) {
            }
            svgaUrl3 = giftData.getSvgaUrl();
            if (svgaUrl3 != null) {
            }
            return Unit.INSTANCE;
        }
        str6 = "";
        chatToGift = DataExternalKt.chatToGift(svgaUrl, str3, str4, str5, str6, giftData.getGiftText(), giftData.getTextStyleList());
        svgaUrl2 = giftData.getSvgaUrl();
        if (svgaUrl2 == null) {
        }
        svgaUrl3 = giftData.getSvgaUrl();
        if (svgaUrl3 != null) {
        }
        return Unit.INSTANCE;
    }

    public static final Unit sendGift$lambda$23$lambda$22(ChatActivity chatActivity, VapMediaSource vapMediaSource) {
        Intrinsics.checkNotNullParameter(vapMediaSource, "it");
        chatActivity.getBinding().queuePlayer.addQueue(vapMediaSource);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit sendGift$lambda$24(ChatActivity chatActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(chatActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, chatActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showMenuDialog() {
        new ChatMenuDialog(this, false, false, 6, (DefaultConstructorMarker) null).setListener(new ChatMenuDialogListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatActivity$showMenuDialog$1
            public void clickType(String type) {
                User user;
                String str;
                Intrinsics.checkNotNullParameter(type, "type");
                switch (type.hashCode()) {
                    case -1335458389:
                        if (type.equals("delete")) {
                            TipDialog tipContent = new TipDialog(ChatActivity.this).setTipContent(ResourcesKtxKt.getStringById(this, 2131952335));
                            final ChatActivity chatActivity = ChatActivity.this;
                            tipContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatActivity$showMenuDialog$1$clickType$1
                                public void cancel() {
                                    OnCommonDialogListener.DefaultImpls.cancel(this);
                                }

                                public void confirm() {
                                    ChatActivity.this.deleteConversation();
                                }
                            }).show();
                            return;
                        }
                        return;
                    case -934521548:
                        if (type.equals("report")) {
                            ChatActivity.this.showReportDialog();
                            return;
                        }
                        return;
                    case -309425751:
                        if (type.equals(FamilyMoreDialog.CLICK_PROFILE)) {
                            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                            user = ChatActivity.this.mUser;
                            if (user == null || (str = user.getExternalId()) == null) {
                                str = "";
                            }
                            baseControlUtils.openPersonPage(str);
                            return;
                        }
                        return;
                    case 93832333:
                        if (type.equals(MessageMenuDialog.BLOCK)) {
                            new TipDialog(ChatActivity.this).setTipContent(ResourcesKtxKt.getStringById(this, 2131952131)).setDialogListener(new ChatActivity$showMenuDialog$1$clickType$2(ChatActivity.this)).show();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void videoCallButtonPressed() {
        String str;
        BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
        User user = this.mUser;
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        BaseControlUtils.newStartVideo$default(baseControlUtils, this, str, new Function2() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.c
            public final Object invoke(Object obj, Object obj2) {
                Unit videoCallButtonPressed$lambda$19;
                videoCallButtonPressed$lambda$19 = ChatActivity.videoCallButtonPressed$lambda$19(ChatActivity.this, (String) obj, ((Boolean) obj2).booleanValue());
                return videoCallButtonPressed$lambda$19;
            }
        }, (Function0) null, 8, (Object) null);
    }

    public static final Unit videoCallButtonPressed$lambda$19(ChatActivity chatActivity, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        chatActivity.requestLikeUser(new Function0() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.f
            public final Object invoke() {
                Unit videoCallButtonPressed$lambda$19$lambda$18;
                videoCallButtonPressed$lambda$19$lambda$18 = ChatActivity.videoCallButtonPressed$lambda$19$lambda$18(ChatActivity.this);
                return videoCallButtonPressed$lambda$19$lambda$18;
            }
        });
        return Unit.INSTANCE;
    }

    public static final Unit videoCallButtonPressed$lambda$19$lambda$18(ChatActivity chatActivity) {
        chatActivity.videoCallButtonPressed();
        return Unit.INSTANCE;
    }

    public static final ChatViewModel viewModel_delegate$lambda$0(ChatActivity chatActivity) {
        return new ViewModelProvider(chatActivity).get(ChatViewModel.class);
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
        conversationManager.deleteConversation(format, new V2TIMCallback() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatActivity$deleteConversation$1
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int code, String desc) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                MessageProvide.INSTANCE.displayData(MessageProvide.MESSAGE_DEFAULT);
                ChatActivity.this.finish();
            }
        });
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_chat;
    }

    /* renamed from: isDialog, reason: from getter */
    public final boolean getIsDialog() {
        return this.isDialog;
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

    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        getBinding().chatView.exitChat();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initChatDialog();
        initView();
        initChatView();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onPause() {
        super.onPause();
        getBinding().chatView.mInputView.setDraft();
        getBinding().chatView.markMessageAsRead();
        MessageProvide.displayData$default(MessageProvide.INSTANCE, null, 1, null);
    }

    public final void sendGift(@NotNull final GiftData selectedGiftItem, final int r22) {
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
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(ChatApi.DefaultImpls.userChatSendGift$default(apis, str, j, str2, r22, selectedGiftItem.getGiftText(), null, 32, null), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.m
            public final Object invoke(Object obj) {
                Unit sendGift$lambda$23;
                sendGift$lambda$23 = ChatActivity.sendGift$lambda$23(selectedGiftItem, r22, this, (ApiResponse) obj);
                return sendGift$lambda$23;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.n
            public final Object invoke(Object obj) {
                Unit sendGift$lambda$24;
                sendGift$lambda$24 = ChatActivity.sendGift$lambda$24(ChatActivity.this, (Throwable) obj);
                return sendGift$lambda$24;
            }
        }, (Function0) null, false, 12, (Object) null), getViewModel().getMCompositeDisposable());
    }

    public final void setDialog(boolean z) {
        this.isDialog = z;
    }

    public final void showGiftDialog() {
        User user = this.mUser;
        if (user != null) {
            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            BaseControlUtils.showChatGiftDialog$default(baseControlUtils, supportFragmentManager, user, new SendGiftListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.ChatActivity$showGiftDialog$1$1
                public void begGift(GiftData data, int number) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SendGiftListener.DefaultImpls.begGift(this, data, number);
                    ChatActivity.this.begGiftSuccess(data, number);
                }

                public void giftsChoose(GiftData selectedGiftItem, int number, ArrayList<String> extraIdList, boolean isAllMic) {
                    Intrinsics.checkNotNullParameter(selectedGiftItem, "selectedGiftItem");
                    Intrinsics.checkNotNullParameter(extraIdList, "extraIdList");
                    ChatActivity.this.sendGift(selectedGiftItem, number);
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
        new ReportWhiteDialog(this).setListener(new ChatActivity$showReportDialog$1(this)).show();
    }
}
