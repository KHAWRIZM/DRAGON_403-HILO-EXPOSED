package com.tencent.qcloud.tuikit.tuichat.classicui;

import android.content.Context;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CallingMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomEvaluationMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomLinkMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomOrderMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FaceMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.LocationMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MessageTypingBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.QuoteMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextAtMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.CustomEvaluationMessageReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.CustomLinkReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.CustomOrderMessageReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.FaceReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.FileReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.ImageReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.LocationReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.MergeReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.ReplyReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.SoundReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TextReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.VideoReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.FaceReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.FileReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.ImageReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.LocationReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.MergeReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.SoundReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.TUIReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.TextReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.VideoReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.CallingMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.CustomEvaluationMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.CustomLinkMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.CustomOrderMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.FaceMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.FileMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.ImageMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.LocationMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MergeMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.QuoteMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.ReplyMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.SoundMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.TextMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.TipsMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.VideoMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.BroadcastGroupMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.CpSuccessMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.CpTipMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.CpUnbindMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.FamilyInviteMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.GiftMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.HeadWearMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.InviteCpMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.InviteEnterRoomMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.LikeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.LinkMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.MountsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.NobleMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.PKInviteMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.PictureLinkMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.ReceiverGiftTimeOutMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.ReceiverSuperLikeTimeOutMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.RelationInviteMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.RelationSuccessMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.RelationTipMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.RelationUnbindMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.SendGiftTimeOutMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.SendSuperLikeTimeOutMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.SheepInviteMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.TextAndImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.UnionFirstMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.VideoCallMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.VideoTimeOutMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomActivityBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomAppointedBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomCreateLudoOrUnoBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomEnvelopeBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomEnvelopeGetBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomGiftBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomGlobalGiftBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomImageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomJoinBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomJumpBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomKickBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomLuckyBoxBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomLuckyFruitBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomMatchGameBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomOwnWelcomeBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomPK1v1Bean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomPKEndBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomRocketBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomRolledBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomSupportBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomTextBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomTipBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomUnNoBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomUserEnterBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomVideoBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.strange.StrangeGiftTimeOutMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.strange.StrangePlayTipMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomBroadcastMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomCommonTextMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomCpExitMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomCpInviteMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomCpSuccessMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomCpTipMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomFamilyInviteMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomGiftMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomHeadGearMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomHiloLinkMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomLikeMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomMountsMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomNobleMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomPKInviteMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomRelationExitMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomRelationInviteMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomRelationSuccessMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomRelationTipMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomShapeRoomMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomSheepInviteMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomTextImageMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomVideoCallMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.PictureLinkMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.UnionFirstMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomActivityHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomAppointedHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomEnvelopeGetHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomEnvelopeHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomGiftHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomGlobalGiftHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomImageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomJoinHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomJumpHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomKickHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomLuckyBoxHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomLuckyFruitHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomLudoOrUnoHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomMatchGameHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomOwnWelcomeHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomPKEndHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomPk1v1Holder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomRocketHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomRolledHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomSupportHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomTextHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomTipHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomUnNoHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomUserEnterHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomVideoHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.strange.StrangeCommonTextMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.strange.StrangePlayTipMessageHolder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0006\u0010\u0017\u001a\u00020\u0014JL\u0010\u0018\u001a\u00020\u00142\u0010\u0010\u0019\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u00062\u0012\u0010\u001a\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n\u0018\u00010\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\"\u0010 \u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00110\u00062\u0010\u0010!\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u0006J\u001a\u0010\"\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\bJ\u0018\u0010#\u001a\u00020\b2\u0010\u0010$\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006J\u000e\u0010%\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010&\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010'\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\bJ\b\u0010(\u001a\u00020\bH\u0016J\b\u0010)\u001a\u00020\bH\u0016J\b\u0010*\u001a\u00020\bH\u0016R$\u0010\u0004\u001a\u0018\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u000f\u001a\"\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u0006\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00110\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/classicui/ClassicUIService;", "Lcom/tencent/qcloud/tuicore/ServiceInitializer;", "<init>", "()V", "messageViewTypeMap", "", "Ljava/lang/Class;", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "", "messageViewHolderMap", "Lcom/tencent/qcloud/tuikit/tuichat/classicui/widget/message/viewholder/MessageBaseHolder;", "hiloViewType", "Ljava/util/HashSet;", "customizeViewType", "groupViewType", "replyMessageViewMap", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/reply/TUIReplyQuoteBean;", "Lcom/tencent/qcloud/tuikit/tuichat/classicui/widget/message/reply/TUIReplyQuoteView;", "viewType", "init", "", "context", "Landroid/content/Context;", "initMessage", "addMessageType", "beanClazz", "holderClazz", "isHilo", "", "isCustomize", "isGroup", "initReplyMessage", "getReplyMessageViewClass", "replyQuoteBeanType", "getMessageViewHolderClass", "getViewType", "messageBeanClass", "checkHiloViewType", "checkCustomizeViewType", "checkGroupViewType", "getLightThemeResId", "getLivelyThemeResId", "getSeriousThemeResId", "Companion", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class ClassicUIService extends ServiceInitializer {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static ClassicUIService instance;
    private int viewType;

    @NotNull
    private final Map<Class<? extends TUIMessageBean>, Integer> messageViewTypeMap = new HashMap();

    @NotNull
    private final Map<Integer, Class<? extends MessageBaseHolder>> messageViewHolderMap = new HashMap();

    @NotNull
    private final HashSet<Integer> hiloViewType = new HashSet<>();

    @NotNull
    private final HashSet<Integer> customizeViewType = new HashSet<>();

    @NotNull
    private final HashSet<Integer> groupViewType = new HashSet<>();

    @NotNull
    private final Map<Class<? extends TUIReplyQuoteBean>, Class<? extends TUIReplyQuoteView>> replyMessageViewMap = new HashMap();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R*\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/classicui/ClassicUIService$Companion;", "", "<init>", "()V", "value", "Lcom/tencent/qcloud/tuikit/tuichat/classicui/ClassicUIService;", "instance", "getInstance$annotations", "getInstance", "()Lcom/tencent/qcloud/tuikit/tuichat/classicui/ClassicUIService;", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @Nullable
        public final ClassicUIService getInstance() {
            return ClassicUIService.instance;
        }

        private Companion() {
        }
    }

    private final void addMessageType(Class<? extends TUIMessageBean> beanClazz, Class<? extends MessageBaseHolder> holderClazz, boolean isHilo, boolean isCustomize, boolean isGroup) {
        int i = this.viewType + 1;
        this.viewType = i;
        this.messageViewTypeMap.put(beanClazz, Integer.valueOf(i));
        this.messageViewHolderMap.put(Integer.valueOf(this.viewType), holderClazz);
        if (isHilo) {
            this.hiloViewType.add(Integer.valueOf(this.viewType));
        }
        if (isGroup) {
            this.groupViewType.add(Integer.valueOf(this.viewType));
        }
        if (isHilo && isCustomize) {
            this.customizeViewType.add(Integer.valueOf(this.viewType));
        }
    }

    static /* synthetic */ void addMessageType$default(ClassicUIService classicUIService, Class cls, Class cls2, boolean z, boolean z2, boolean z3, int i, Object obj) {
        boolean z4;
        boolean z5;
        boolean z6;
        if ((i & 4) != 0) {
            z4 = false;
        } else {
            z4 = z;
        }
        if ((i & 8) != 0) {
            z5 = true;
        } else {
            z5 = z2;
        }
        if ((i & 16) != 0) {
            z6 = false;
        } else {
            z6 = z3;
        }
        classicUIService.addMessageType(cls, cls2, z4, z5, z6);
    }

    @Nullable
    public static final ClassicUIService getInstance() {
        return INSTANCE.getInstance();
    }

    private final void initReplyMessage() {
        this.replyMessageViewMap.put(CustomEvaluationMessageReplyQuoteBean.class, TextReplyQuoteView.class);
        this.replyMessageViewMap.put(CustomLinkReplyQuoteBean.class, TextReplyQuoteView.class);
        this.replyMessageViewMap.put(CustomOrderMessageReplyQuoteBean.class, TextReplyQuoteView.class);
        this.replyMessageViewMap.put(FaceReplyQuoteBean.class, FaceReplyQuoteView.class);
        this.replyMessageViewMap.put(FileReplyQuoteBean.class, FileReplyQuoteView.class);
        this.replyMessageViewMap.put(ImageReplyQuoteBean.class, ImageReplyQuoteView.class);
        this.replyMessageViewMap.put(LocationReplyQuoteBean.class, LocationReplyQuoteView.class);
        this.replyMessageViewMap.put(MergeReplyQuoteBean.class, MergeReplyQuoteView.class);
        this.replyMessageViewMap.put(ReplyReplyQuoteBean.class, TextReplyQuoteView.class);
        this.replyMessageViewMap.put(SoundReplyQuoteBean.class, SoundReplyQuoteView.class);
        this.replyMessageViewMap.put(TextReplyQuoteBean.class, TextReplyQuoteView.class);
        this.replyMessageViewMap.put(VideoReplyQuoteBean.class, VideoReplyQuoteView.class);
    }

    public final boolean checkCustomizeViewType(int viewType) {
        return this.customizeViewType.contains(Integer.valueOf(viewType));
    }

    public final boolean checkGroupViewType(int viewType) {
        return this.groupViewType.contains(Integer.valueOf(viewType));
    }

    public final boolean checkHiloViewType(int viewType) {
        return this.hiloViewType.contains(Integer.valueOf(viewType));
    }

    @Override // com.tencent.qcloud.tuicore.ServiceInitializer
    public int getLightThemeResId() {
        return R.style.TUIChatLightTheme;
    }

    @Override // com.tencent.qcloud.tuicore.ServiceInitializer
    public int getLivelyThemeResId() {
        return R.style.TUIChatLivelyTheme;
    }

    @Nullable
    public final Class<? extends MessageBaseHolder> getMessageViewHolderClass(int viewType) {
        return this.messageViewHolderMap.get(Integer.valueOf(viewType));
    }

    @NotNull
    public final Class<? extends TUIReplyQuoteView> getReplyMessageViewClass(@NotNull Class<? extends TUIReplyQuoteBean> replyQuoteBeanType) {
        Intrinsics.checkNotNullParameter(replyQuoteBeanType, "replyQuoteBeanType");
        Class<? extends TUIReplyQuoteView> cls = this.replyMessageViewMap.get(replyQuoteBeanType);
        Intrinsics.checkNotNull(cls);
        return cls;
    }

    @Override // com.tencent.qcloud.tuicore.ServiceInitializer
    public int getSeriousThemeResId() {
        return R.style.TUIChatSeriousTheme;
    }

    public final int getViewType(@NotNull Class<? extends TUIMessageBean> messageBeanClass) {
        Intrinsics.checkNotNullParameter(messageBeanClass, "messageBeanClass");
        Integer num = this.messageViewTypeMap.get(messageBeanClass);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.tencent.qcloud.tuicore.ServiceInitializer
    public void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        instance = this;
        initMessage();
        initReplyMessage();
    }

    public final void initMessage() {
        addMessageType$default(this, FaceMessageBean.class, FaceMessageHolder.class, false, false, false, 28, null);
        addMessageType$default(this, FileMessageBean.class, FileMessageHolder.class, false, false, false, 28, null);
        addMessageType$default(this, ImageMessageBean.class, ImageMessageHolder.class, false, false, false, 28, null);
        addMessageType$default(this, LocationMessageBean.class, LocationMessageHolder.class, false, false, false, 28, null);
        addMessageType$default(this, MergeMessageBean.class, MergeMessageHolder.class, false, false, false, 28, null);
        addMessageType$default(this, SoundMessageBean.class, SoundMessageHolder.class, false, false, false, 28, null);
        addMessageType$default(this, TextAtMessageBean.class, TextMessageHolder.class, false, false, false, 28, null);
        addMessageType$default(this, TextMessageBean.class, TextMessageHolder.class, false, false, false, 28, null);
        addMessageType$default(this, TipsMessageBean.class, TipsMessageHolder.class, false, false, false, 28, null);
        addMessageType$default(this, VideoMessageBean.class, VideoMessageHolder.class, false, false, false, 28, null);
        addMessageType$default(this, ReplyMessageBean.class, ReplyMessageHolder.class, false, false, false, 28, null);
        addMessageType$default(this, QuoteMessageBean.class, QuoteMessageHolder.class, false, false, false, 28, null);
        addMessageType$default(this, CallingMessageBean.class, CallingMessageHolder.class, false, false, false, 28, null);
        addMessageType$default(this, CustomLinkMessageBean.class, CustomLinkMessageHolder.class, false, false, false, 28, null);
        addMessageType$default(this, CustomEvaluationMessageBean.class, CustomEvaluationMessageHolder.class, false, false, false, 28, null);
        addMessageType$default(this, CustomOrderMessageBean.class, CustomOrderMessageHolder.class, false, false, false, 28, null);
        addMessageType$default(this, MessageTypingBean.class, null, false, false, false, 28, null);
        addMessageType$default(this, GiftMessageBean.class, CustomGiftMessageHolder.class, true, false, false, 24, null);
        addMessageType$default(this, LinkMessageBean.class, CustomHiloLinkMessageHolder.class, true, false, false, 16, null);
        addMessageType$default(this, MountsMessageBean.class, CustomMountsMessageHolder.class, true, false, false, 16, null);
        addMessageType$default(this, NobleMessageBean.class, CustomNobleMessageHolder.class, true, false, false, 16, null);
        addMessageType$default(this, UnionFirstMessageBean.class, UnionFirstMessageHolder.class, true, false, false, 24, null);
        addMessageType$default(this, BroadcastGroupMessageBean.class, CustomBroadcastMessageHolder.class, true, false, false, 24, null);
        addMessageType$default(this, VideoTimeOutMessageBean.class, CustomCommonTextMessageHolder.class, true, false, false, 24, null);
        addMessageType$default(this, ReceiverGiftTimeOutMessageBean.class, CustomCommonTextMessageHolder.class, true, false, false, 24, null);
        addMessageType$default(this, SendGiftTimeOutMessageBean.class, CustomCommonTextMessageHolder.class, true, false, false, 24, null);
        addMessageType$default(this, HeadWearMessageBean.class, CustomHeadGearMessageHolder.class, true, false, false, 16, null);
        addMessageType$default(this, InviteEnterRoomMessageBean.class, CustomShapeRoomMessageHolder.class, true, false, false, 16, null);
        addMessageType$default(this, TextAndImageMessageBean.class, CustomTextImageMessageHolder.class, true, true, false, 16, null);
        addMessageType$default(this, VideoCallMessageBean.class, CustomVideoCallMessageHolder.class, true, false, false, 16, null);
        addMessageType$default(this, FamilyInviteMessageBean.class, CustomFamilyInviteMessageHolder.class, true, false, false, 16, null);
        addMessageType$default(this, SheepInviteMessageBean.class, CustomSheepInviteMessageHolder.class, true, true, false, 16, null);
        addMessageType$default(this, PKInviteMessageBean.class, CustomPKInviteMessageHolder.class, true, true, false, 16, null);
        addMessageType$default(this, CpSuccessMessageBean.class, CustomCpSuccessMessageHolder.class, true, true, false, 16, null);
        addMessageType$default(this, CpUnbindMessageBean.class, CustomCpExitMessageHolder.class, true, true, false, 16, null);
        addMessageType$default(this, InviteCpMessageBean.class, CustomCpInviteMessageHolder.class, true, true, false, 16, null);
        addMessageType$default(this, CpTipMessageBean.class, CustomCpTipMessageHolder.class, true, true, false, 16, null);
        addMessageType$default(this, PictureLinkMessageBean.class, PictureLinkMessageHolder.class, true, false, false, 16, null);
        addMessageType$default(this, RelationSuccessMessageBean.class, CustomRelationSuccessMessageHolder.class, true, true, false, 16, null);
        addMessageType$default(this, RelationUnbindMessageBean.class, CustomRelationExitMessageHolder.class, true, true, false, 16, null);
        addMessageType$default(this, RelationInviteMessageBean.class, CustomRelationInviteMessageHolder.class, true, true, false, 16, null);
        addMessageType$default(this, RelationTipMessageBean.class, CustomRelationTipMessageHolder.class, true, true, false, 16, null);
        addMessageType$default(this, LikeMessageBean.class, CustomLikeMessageHolder.class, true, true, false, 16, null);
        addMessageType$default(this, ReceiverSuperLikeTimeOutMessageBean.class, CustomCommonTextMessageHolder.class, true, false, false, 24, null);
        addMessageType$default(this, SendSuperLikeTimeOutMessageBean.class, CustomCommonTextMessageHolder.class, true, false, false, 24, null);
        addMessageType(RoomTextBean.class, RoomTextHolder.class, true, false, true);
        addMessageType(RoomImageBean.class, RoomImageHolder.class, true, false, true);
        addMessageType(RoomVideoBean.class, RoomVideoHolder.class, true, false, true);
        addMessageType(RoomJoinBean.class, RoomJoinHolder.class, true, true, true);
        addMessageType(RoomUserEnterBean.class, RoomUserEnterHolder.class, true, true, true);
        addMessageType(RoomKickBean.class, RoomKickHolder.class, true, true, true);
        addMessageType(RoomAppointedBean.class, RoomAppointedHolder.class, true, true, true);
        addMessageType(RoomGiftBean.class, RoomGiftHolder.class, true, false, true);
        addMessageType(RoomUnNoBean.class, RoomUnNoHolder.class, true, true, true);
        addMessageType(RoomTipBean.class, RoomTipHolder.class, true, true, true);
        addMessageType(RoomRolledBean.class, RoomRolledHolder.class, true, false, true);
        addMessageType(RoomRocketBean.class, RoomRocketHolder.class, true, false, true);
        addMessageType(RoomGlobalGiftBean.class, RoomGlobalGiftHolder.class, true, true, true);
        addMessageType(RoomSupportBean.class, RoomSupportHolder.class, true, true, true);
        addMessageType(RoomJumpBean.class, RoomJumpHolder.class, true, true, true);
        addMessageType(RoomLuckyBoxBean.class, RoomLuckyBoxHolder.class, true, true, true);
        addMessageType(RoomLuckyFruitBean.class, RoomLuckyFruitHolder.class, true, true, true);
        addMessageType(RoomActivityBean.class, RoomActivityHolder.class, true, true, true);
        addMessageType(RoomCreateLudoOrUnoBean.class, RoomLudoOrUnoHolder.class, true, false, true);
        addMessageType(RoomOwnWelcomeBean.class, RoomOwnWelcomeHolder.class, true, false, true);
        addMessageType(RoomMatchGameBean.class, RoomMatchGameHolder.class, true, false, true);
        addMessageType(RoomPKEndBean.class, RoomPKEndHolder.class, true, true, true);
        addMessageType(RoomEnvelopeBean.class, RoomEnvelopeHolder.class, true, false, true);
        addMessageType(RoomEnvelopeGetBean.class, RoomEnvelopeGetHolder.class, true, false, true);
        addMessageType(RoomPK1v1Bean.class, RoomPk1v1Holder.class, true, true, true);
        addMessageType$default(this, StrangePlayTipMessageBean.class, StrangePlayTipMessageHolder.class, true, true, false, 16, null);
        addMessageType$default(this, StrangeGiftTimeOutMessageBean.class, StrangeCommonTextMessageHolder.class, true, true, false, 16, null);
    }
}
