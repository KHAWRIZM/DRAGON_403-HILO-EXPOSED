package com.qiahao.nextvideo.utilities;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.GroupGiftDetail;
import com.qiahao.base_common.model.common.CanChat;
import com.qiahao.base_common.model.common.ChannelEvent1v1AddTime;
import com.qiahao.base_common.model.common.ChannelEventStartup;
import com.qiahao.base_common.model.common.CountryManager;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.model.common.HeadWearBean;
import com.qiahao.base_common.model.common.MyGameLevel;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.PhoneInfo;
import com.qiahao.base_common.model.common.RelationUserData;
import com.qiahao.base_common.model.common.RideBean;
import com.qiahao.base_common.model.common.Special;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.common.VideoSetting;
import com.qiahao.base_common.model.cp.CpInfo;
import com.qiahao.base_common.model.cp.CpLevel;
import com.qiahao.base_common.model.cp.CpSpace;
import com.qiahao.base_common.model.cp.MyCp;
import com.qiahao.base_common.model.cp.TextStyles;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.qiahao.base_common.model.im.TIMUserBean;
import com.qiahao.base_common.model.im.TIMUserExtBean;
import com.qiahao.base_common.model.svip.Privilege;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.network.model.UserCostDiamondsDetail;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.hilo_message.data.CloudCustomData;
import com.qiahao.hilo_message.data.CustomElemContent;
import com.qiahao.hilo_message.data.GMSvipDetail;
import com.qiahao.hilo_message.data.GroupMessageNew;
import com.qiahao.hilo_message.data.ImageElemContent;
import com.qiahao.hilo_message.data.MsgBody;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.hilo_message.data.TextElemContent;
import com.qiahao.hilo_message.data.VideoElemContent;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.foodie.FoodieHotBean;
import com.qiahao.nextvideo.data.foodie.FoodieHotMessage;
import com.qiahao.nextvideo.data.model.BeanChangeDetail;
import com.qiahao.nextvideo.data.model.CurrentRoomOnlineBean;
import com.qiahao.nextvideo.data.model.CurrentRoomOnlineBeanList;
import com.qiahao.nextvideo.data.model.EmojiBean;
import com.qiahao.nextvideo.data.model.EnterEffectData;
import com.qiahao.nextvideo.data.model.ExchangeDetailData;
import com.qiahao.nextvideo.data.model.GiftDateItem;
import com.qiahao.nextvideo.data.model.GroupBroadCastBean;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.MeetingRoomReceiveGiftCustomContent;
import com.qiahao.nextvideo.data.model.MicBanner;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.model.MicroUserBean;
import com.qiahao.nextvideo.data.model.PurchaseDiamondDetail;
import com.qiahao.nextvideo.data.model.PurchaseItem;
import com.qiahao.nextvideo.data.model.UserInRoom;
import com.qiahao.nextvideo.data.model.UserSummaryInfo;
import com.qiahao.nextvideo.data.room.PKInviteCancel;
import com.qiahao.nextvideo.data.signaling.RoomAllGift;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.ui.cp.CpSpaceActivity;
import com.qiahao.nextvideo.ui.purchase.DiamondCellUIModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import okhttp3.HttpUrl;
import okhttp3.internal.http2.Settings;
import org.apache.commons.sudcompress.archivers.zip.UnixStat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import userProxy.UserProxy;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000ø\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\b\u001a\u00020\t*\u00020\n\u001a\n\u0010\u000b\u001a\u00020\f*\u00020\r\u001a\n\u0010\b\u001a\u00020\t*\u00020\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012\u001a\n\u0010\u0013\u001a\u00020\u0014*\u00020\u0015\u001a\f\u0010\u0016\u001a\u0004\u0018\u00010\u0010*\u00020\u0015\u001a\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0010*\u00020\u00012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0012\u001a\u001a\u0010\u0019\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010\u001a\u001e\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00102\b\b\u0002\u0010!\u001a\u00020\u0010\u001a\n\u0010\"\u001a\u00020#*\u00020$\u001a\u0012\u0010%\u001a\u00020#*\u00020\u00012\u0006\u0010&\u001a\u00020'\u001a`\u0010(\u001a\u00020)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u0012\u001a\n\u00102\u001a\u000203*\u000204\u001a\n\u00105\u001a\u000206*\u000207\u001a\f\u00108\u001a\u0004\u0018\u000109*\u00020:\u001a\n\u0010;\u001a\u00020<*\u00020=\u001a\n\u0010>\u001a\u00020?*\u00020@\u001a\u0014\u0010A\u001a\u00020B*\u0004\u0018\u00010\u00102\u0006\u0010C\u001a\u00020\u001b\u001a\u0016\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u001b\u001a\n\u0010I\u001a\u00020'*\u00020J\u001a\n\u0010I\u001a\u00020'*\u00020K\u001a\n\u0010L\u001a\u00020K*\u00020M\u001a\u0016\u0010N\u001a\u00020O*\u00020P2\b\b\u0002\u0010Q\u001a\u00020RH\u0007\u001a\n\u0010N\u001a\u00020O*\u00020S\u001a\n\u0010N\u001a\u00020O*\u00020T\u001a\u0012\u0010U\u001a\u00020V*\u00020W2\u0006\u0010X\u001a\u00020\u001b\u001a\u0010\u0010Y\u001a\b\u0012\u0004\u0012\u0002010\u0012*\u00020Z\u001a\n\u0010[\u001a\u00020\\*\u00020]\u001a\n\u0010^\u001a\u00020\u0015*\u00020_\u001a\n\u0010;\u001a\u00020<*\u00020`\u001a\n\u0010a\u001a\u00020b*\u00020c\u001a\n\u0010d\u001a\u00020e*\u00020f\u001a\n\u0010g\u001a\u00020h*\u00020i\u001a\n\u0010j\u001a\u00020k*\u00020l\u001a\n\u0010m\u001a\u00020n*\u00020o\u001a\n\u0010p\u001a\u00020q*\u00020r\u001a\n\u0010s\u001a\u00020t*\u00020u\u001a\n\u0010v\u001a\u00020w*\u00020\u0015\u001a\n\u0010x\u001a\u00020y*\u00020\u0015\u001a\n\u0010z\u001a\u00020\u0010*\u00020{¨\u0006|"}, d2 = {"toUser", "Lcom/qiahao/base_common/model/common/User;", "LuserProxy/UserProxy$MatchSuccess;", "LuserProxy/UserProxy$User;", "Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "toChannelEvent1v1AddTime", "Lcom/qiahao/base_common/model/common/ChannelEvent1v1AddTime;", "LuserProxy/UserProxy$VideoTimeMinuteSuccess;", "toChannelEventStartup", "Lcom/qiahao/base_common/model/common/ChannelEventStartup;", "LuserProxy/UserProxy$CallReady;", "toVideoSet", "Lcom/qiahao/base_common/model/common/VideoSetting;", "LuserProxy/UserProxy$VideoSetting;", "LuserProxy/UserProxy$VideoCallReady;", "arrayListToString", "", "list", "", "toGroupRoomImCustomBean", "Lcom/qiahao/base_common/model/im/GroupRoomImCustomBean;", "Lcom/qiahao/nextvideo/data/model/MeetingRoomReceiveGiftCustomContent;", "imExtBean", "mentionUsers", "Lcom/qiahao/base_common/model/im/TIMUserBean;", "maxLengthSuffix", "maxLength", "", "suffix", "setDynamicImageEntity", "", "Lcom/opensource/svgaplayer/SVGADynamicEntity;", "url", "imgKey", "roomEventToEnterEffectData", "Lcom/qiahao/nextvideo/data/model/EnterEffectData;", "Lcom/qiahao/nextvideo/data/model/UserInRoom;", "userToEnterEffectData", "data", "Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "chatToGift", "Lcom/qiahao/nextvideo/data/model/GiftDateItem;", "giftUrl", "sendUserAvatar", "receiveUserAvatar", "sendUserNick", "receiveUserNick", "giftText", "textStyleList", "Lcom/qiahao/base_common/model/cp/TextStyles;", "toMicroBean", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "LuserProxy/UserProxy1$GroupMicChange;", "toRoomBanner", "Lcom/qiahao/nextvideo/data/model/MicBanner;", "LuserProxy/UserProxy$XjsRoomBanner;", "toMicroUserBean", "Lcom/qiahao/nextvideo/data/model/MicroUserBean;", "LuserProxy/UserProxy$MicUserData;", "toSvipData", "Lcom/qiahao/base_common/model/svip/SvipData;", "LuserProxy/UserProxy$Svip;", "toGroupBroadCastBean", "Lcom/qiahao/nextvideo/data/model/GroupBroadCastBean;", "LuserProxy/UserProxy$GroupSendNotice;", "createExitRoom", "LuserProxy/UserProxy1$QuitRoom;", "reason", "toUIModel", "Lcom/qiahao/nextvideo/ui/purchase/DiamondCellUIModel;", "diamondDetail", "Lcom/qiahao/nextvideo/data/model/PurchaseDiamondDetail;", "diamondImageRes", "toGroupDetailBean", "LuserProxy/UserProxy1$GroupPkInvite;", "Lcom/qiahao/nextvideo/data/room/PKInviteCancel;", "toPKInviteCancel", "LuserProxy/UserProxy1$GamePkInviteCancel;", "toExchangeDetailData", "Lcom/qiahao/nextvideo/data/model/ExchangeDetailData;", "Lcom/qiahao/base_common/network/model/UserCostDiamondsDetail;", "isDiamond", "", "Lcom/qiahao/nextvideo/data/model/BeanChangeDetail;", "Lcom/qiahao/nextvideo/data/model/PurchaseItem;", "toSpecial", "Lcom/qiahao/base_common/model/common/Special;", "Lcom/qiahao/base_common/model/cp/CpSpace;", CpSpaceActivity.RELATION_TYPE, "toTextStyleList", "LuserProxy/UserProxy$GiftInfo;", "toFoodieHotMessage", "Lcom/qiahao/nextvideo/data/foodie/FoodieHotMessage;", "LuserProxy/UserProxy1$FoodieTopHotMessage;", "toMeetingRoomReceiveGiftCustomContent", "LuserProxy/UserProxy1$GiftContentMessage;", "LuserProxy/UserProxy$CvSvip;", "toGroupGiftDetail", "Lcom/qiahao/base_common/model/GroupGiftDetail;", "LuserProxy/UserProxy$GiftDetailInfo;", "toFamilyInfo", "Lcom/qiahao/base_common/model/common/FamilyInfo;", "LuserProxy/UserProxy$CvGroupPowerInfo;", "toCurrentRoomOnlineBeanList", "Lcom/qiahao/nextvideo/data/model/CurrentRoomOnlineBeanList;", "LuserProxy/UserProxy1$RoomOnlineUser;", "toCurrentRoomOnlineBean", "Lcom/qiahao/nextvideo/data/model/CurrentRoomOnlineBean;", "LuserProxy/UserProxy$RoomOnlineUserMsg;", "toNobleInfo", "Lcom/qiahao/base_common/model/common/NobleInfo;", "LuserProxy/UserProxy$RoomUserNoble;", "toEmojiBean", "Lcom/qiahao/nextvideo/data/model/EmojiBean;", "LuserProxy/UserProxy1$MicEmoji;", "toRoomAllGift", "Lcom/qiahao/nextvideo/data/signaling/RoomAllGift;", "LuserProxy/UserProxy1$RoomGiftEffect;", "toCloudCustomData", "Lcom/qiahao/hilo_message/data/CloudCustomData;", "toMessageMulti", "Lcom/qiahao/hilo_message/data/RoomMessageMulti;", "checkData", "LuserProxy/UserProxy1$GlobalGameBanner;", "app_googleRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDataExternal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataExternal.kt\ncom/qiahao/nextvideo/utilities/DataExternalKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,827:1\n1869#2,2:828\n1869#2,2:830\n1869#2,2:832\n1869#2,2:834\n1563#2:836\n1634#2,3:837\n1869#2,2:840\n1563#2:842\n1634#2,3:843\n1869#2,2:846\n*S KotlinDebug\n*F\n+ 1 DataExternal.kt\ncom/qiahao/nextvideo/utilities/DataExternalKt\n*L\n446#1:828,2\n602#1:830,2\n619#1:832,2\n631#1:834,2\n662#1:836\n662#1:837,3\n676#1:840,2\n720#1:842\n720#1:843,3\n783#1:846,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DataExternalKt {
    @NotNull
    public static final String arrayListToString(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (list.isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i == list.size() - 1) {
                sb2.append("\"");
                sb2.append(list.get(i));
                sb2.append("\"");
            } else {
                sb2.append("\"");
                sb2.append(list.get(i));
                sb2.append("\",");
            }
        }
        sb2.append("]");
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        return sb3;
    }

    @NotNull
    public static final GiftDateItem chatToGift(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable List<TextStyles> list) {
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        if (str == null) {
            str7 = "";
        } else {
            str7 = str;
        }
        if (str2 == null) {
            str8 = "";
        } else {
            str8 = str2;
        }
        if (str3 == null) {
            str9 = "";
        } else {
            str9 = str3;
        }
        if (str4 == null) {
            str10 = "";
        } else {
            str10 = str4;
        }
        if (str5 == null) {
            str11 = "";
        } else {
            str11 = str5;
        }
        return new GiftDateItem(str7, str8, str9, null, null, null, null, null, null, null, null, list, str11, str10, str6, 2040, null);
    }

    public static /* synthetic */ GiftDateItem chatToGift$default(String str, String str2, String str3, String str4, String str5, String str6, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        if ((i & 16) != 0) {
            str5 = null;
        }
        if ((i & 32) != 0) {
            str6 = null;
        }
        if ((i & 64) != 0) {
            list = null;
        }
        return chatToGift(str, str2, str3, str4, str5, str6, list);
    }

    @NotNull
    public static final String checkData(@NotNull UserProxy1.GlobalGameBanner globalGameBanner) {
        Intrinsics.checkNotNullParameter(globalGameBanner, "<this>");
        return globalGameBanner.getAvatar() + globalGameBanner.getGameId() + globalGameBanner.getGameType() + globalGameBanner.getUserId() + globalGameBanner.getDiamond() + globalGameBanner.getBannerUrl();
    }

    @NotNull
    public static final UserProxy1.QuitRoom createExitRoom(@Nullable String str, int i) {
        UserProxy1.QuitRoom.Builder newBuilder = UserProxy1.QuitRoom.newBuilder();
        newBuilder.setReason(i);
        if (str == null) {
            str = "";
        }
        newBuilder.setGroupId(str);
        UserProxy1.QuitRoom quitRoom = newBuilder.m٥٠٥١build();
        Intrinsics.checkNotNullExpressionValue(quitRoom, "build(...)");
        return quitRoom;
    }

    @Nullable
    public static final String imExtBean(@NotNull MeetingRoomReceiveGiftCustomContent meetingRoomReceiveGiftCustomContent) {
        Intrinsics.checkNotNullParameter(meetingRoomReceiveGiftCustomContent, "<this>");
        com.google.gson.d dVar = new com.google.gson.d();
        long senderCharmGrade = meetingRoomReceiveGiftCustomContent.getSenderCharmGrade();
        long senderWealthGrade = meetingRoomReceiveGiftCustomContent.getSenderWealthGrade();
        boolean senderIsPrettyCode = meetingRoomReceiveGiftCustomContent.getSenderIsPrettyCode();
        boolean senderIsVip = meetingRoomReceiveGiftCustomContent.getSenderIsVip();
        String senderGroupPowerName = meetingRoomReceiveGiftCustomContent.getSenderGroupPowerName();
        if (senderGroupPowerName == null) {
            senderGroupPowerName = "";
        }
        String str = senderGroupPowerName;
        int senderNobleLevel = meetingRoomReceiveGiftCustomContent.getSenderNobleLevel();
        ArrayList<Integer> senderMedalIds = meetingRoomReceiveGiftCustomContent.getSenderMedalIds();
        int senderSvipLevel = meetingRoomReceiveGiftCustomContent.getSenderSvipLevel();
        SvipData svip = meetingRoomReceiveGiftCustomContent.getSvip();
        FamilyInfo senderPower = meetingRoomReceiveGiftCustomContent.getSenderPower();
        String nameplate = senderPower != null ? senderPower.getNameplate() : null;
        FamilyInfo senderPower2 = meetingRoomReceiveGiftCustomContent.getSenderPower();
        return dVar.s(new TIMUserExtBean(Long.valueOf(senderCharmGrade), Boolean.valueOf(senderIsPrettyCode), Boolean.valueOf(senderIsVip), senderMedalIds, str, Integer.valueOf(senderNobleLevel), Long.valueOf(senderWealthGrade), senderSvipLevel, svip, (List) null, nameplate, senderPower2 != null ? senderPower2.getGrade() : null));
    }

    public static /* synthetic */ String imExtBean$default(User user, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        return imExtBean(user, list);
    }

    @NotNull
    public static final String maxLengthSuffix(@NotNull String str, int i, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "suffix");
        if (str.length() > i) {
            return ((Object) str.subSequence(0, i)) + str2;
        }
        return str;
    }

    @NotNull
    public static final EnterEffectData roomEventToEnterEffectData(@NotNull UserInRoom userInRoom) {
        Intrinsics.checkNotNullParameter(userInRoom, "<this>");
        return new EnterEffectData(userInRoom.getNick(), userInRoom.isVip(), userInRoom.getNobleLevel(), userInRoom.getSvip(), userInRoom.getUserAvatar(), userInRoom.getCpLevel(), userInRoom.getCpUserAvatar(), userInRoom.getEntryEffectType(), null, null, null, 1792, null);
    }

    public static final void setDynamicImageEntity(@NotNull SVGADynamicEntity sVGADynamicEntity, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(sVGADynamicEntity, "<this>");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "imgKey");
        if (!TextUtils.isEmpty(str)) {
            sVGADynamicEntity.setDynamicImage(ImageSizeKt.imageCircle(str, 100), str2);
        }
    }

    public static /* synthetic */ void setDynamicImageEntity$default(SVGADynamicEntity sVGADynamicEntity, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = SVGAUtil.SENDER_AVATAR;
        }
        setDynamicImageEntity(sVGADynamicEntity, str, str2);
    }

    @NotNull
    public static final ChannelEvent1v1AddTime toChannelEvent1v1AddTime(@NotNull UserProxy.VideoTimeMinuteSuccess videoTimeMinuteSuccess) {
        Intrinsics.checkNotNullParameter(videoTimeMinuteSuccess, "<this>");
        long endTimestamp = videoTimeMinuteSuccess.getEndTimestamp() - (System.currentTimeMillis() / 1000);
        String token = videoTimeMinuteSuccess.getToken();
        Intrinsics.checkNotNullExpressionValue(token, "getToken(...)");
        int duration = videoTimeMinuteSuccess.getDuration();
        long endTimestamp2 = videoTimeMinuteSuccess.getEndTimestamp();
        String channelId = videoTimeMinuteSuccess.getChannelId();
        Intrinsics.checkNotNullExpressionValue(channelId, "getChannelId(...)");
        int senderAgoraId = videoTimeMinuteSuccess.getSenderAgoraId();
        String videoUniqueId = videoTimeMinuteSuccess.getVideoUniqueId();
        Intrinsics.checkNotNullExpressionValue(videoUniqueId, "getVideoUniqueId(...)");
        return new ChannelEvent1v1AddTime(token, duration, endTimestamp2, channelId, senderAgoraId, videoUniqueId, videoTimeMinuteSuccess.getIsSend(), endTimestamp);
    }

    @NotNull
    public static final ChannelEventStartup toChannelEventStartup(@NotNull UserProxy.CallReady callReady) {
        Intrinsics.checkNotNullParameter(callReady, "<this>");
        long startTimestamp = callReady.getStartTimestamp() - (System.currentTimeMillis() / 1000);
        String channelId = callReady.getChannelId();
        Intrinsics.checkNotNullExpressionValue(channelId, "getChannelId(...)");
        long callDuration = callReady.getCallDuration();
        long endTimestamp = callReady.getEndTimestamp();
        long startTimestamp2 = callReady.getStartTimestamp();
        UserProxy.VideoSetting videoSetting = callReady.getVideoSetting();
        Intrinsics.checkNotNullExpressionValue(videoSetting, "getVideoSetting(...)");
        VideoSetting videoSet = toVideoSet(videoSetting);
        UserProxy.VideoSetting otherVideoSetting = callReady.getOtherVideoSetting();
        Intrinsics.checkNotNullExpressionValue(otherVideoSetting, "getOtherVideoSetting(...)");
        return new ChannelEventStartup(channelId, callDuration, endTimestamp, startTimestamp2, startTimestamp, (String) null, videoSet, toVideoSet(otherVideoSetting), 32, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final CloudCustomData toCloudCustomData(@NotNull MeetingRoomReceiveGiftCustomContent meetingRoomReceiveGiftCustomContent) {
        String str;
        String str2;
        long j;
        Integer grade;
        Intrinsics.checkNotNullParameter(meetingRoomReceiveGiftCustomContent, "<this>");
        CloudCustomData cloudCustomData = new CloudCustomData((Long) null, (Long) null, (Boolean) null, (Boolean) null, (List) null, (String) null, (Long) null, (Long) null, (String) null, (Long) null, (GMSvipDetail) null, 0, UnixStat.PERM_MASK, (DefaultConstructorMarker) null);
        cloudCustomData.setWealthGrade(Long.valueOf(meetingRoomReceiveGiftCustomContent.getSenderWealthGrade()));
        cloudCustomData.setCharmGrade(Long.valueOf(meetingRoomReceiveGiftCustomContent.getSenderCharmGrade()));
        cloudCustomData.setVip(Boolean.valueOf(meetingRoomReceiveGiftCustomContent.getSenderIsVip()));
        cloudCustomData.setPretty(Boolean.valueOf(meetingRoomReceiveGiftCustomContent.getSenderIsPrettyCode()));
        ArrayList arrayList = new ArrayList();
        ArrayList<Integer> senderMedalIds = meetingRoomReceiveGiftCustomContent.getSenderMedalIds();
        if (senderMedalIds != null) {
            Iterator<T> it = senderMedalIds.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Number) it.next()).intValue()));
            }
        }
        cloudCustomData.setMedals(arrayList);
        FamilyInfo senderPower = meetingRoomReceiveGiftCustomContent.getSenderPower();
        String str3 = null;
        if (senderPower != null) {
            str = senderPower.getName();
        } else {
            str = null;
        }
        cloudCustomData.setPowerName(str);
        cloudCustomData.setNobleLevel(Long.valueOf(meetingRoomReceiveGiftCustomContent.getSenderNobleLevel()));
        cloudCustomData.setSvipLevel(Long.valueOf(meetingRoomReceiveGiftCustomContent.getSenderSvipLevel()));
        FamilyInfo senderPower2 = meetingRoomReceiveGiftCustomContent.getSenderPower();
        if (senderPower2 != null) {
            str2 = senderPower2.getNameplate();
        } else {
            str2 = null;
        }
        cloudCustomData.setPowerNameplate(str2);
        FamilyInfo senderPower3 = meetingRoomReceiveGiftCustomContent.getSenderPower();
        long j2 = 0;
        if (senderPower3 != null && (grade = senderPower3.getGrade()) != null) {
            j = Long.valueOf(grade.intValue());
        } else {
            j = 0L;
        }
        cloudCustomData.setPowerGrade(j);
        SvipData svip = meetingRoomReceiveGiftCustomContent.getSvip();
        if (svip != null) {
            j2 = svip.getSvipLevel();
        }
        Long valueOf = Long.valueOf(j2);
        SvipData svip2 = meetingRoomReceiveGiftCustomContent.getSvip();
        if (svip2 != null) {
            str3 = svip2.mysteryNumber();
        }
        cloudCustomData.setSvip(new GMSvipDetail(valueOf, str3));
        cloudCustomData.setCornerMark(meetingRoomReceiveGiftCustomContent.getSenderCornerMark());
        return cloudCustomData;
    }

    @NotNull
    public static final CurrentRoomOnlineBean toCurrentRoomOnlineBean(@NotNull UserProxy.RoomOnlineUserMsg roomOnlineUserMsg) {
        Intrinsics.checkNotNullParameter(roomOnlineUserMsg, "<this>");
        long id2 = roomOnlineUserMsg.getId();
        String nick = roomOnlineUserMsg.getNick();
        String avatar = roomOnlineUserMsg.getAvatar();
        String code = roomOnlineUserMsg.getCode();
        String country = roomOnlineUserMsg.getCountry();
        String countryIcon = roomOnlineUserMsg.getCountryIcon();
        String externalId = roomOnlineUserMsg.getExternalId();
        boolean isLogout = roomOnlineUserMsg.getIsLogout();
        boolean isPrettyCode = roomOnlineUserMsg.getIsPrettyCode();
        boolean isVip = roomOnlineUserMsg.getIsVip();
        UserProxy.RoomUserNoble noble = roomOnlineUserMsg.getNoble();
        Intrinsics.checkNotNullExpressionValue(noble, "getNoble(...)");
        NobleInfo nobleInfo = toNobleInfo(noble);
        int sex = roomOnlineUserMsg.getSex();
        long vipExpireTime = roomOnlineUserMsg.getVipExpireTime();
        int svipLevel = roomOnlineUserMsg.getSvipLevel();
        UserProxy.CvSvip svip = roomOnlineUserMsg.getSvip();
        Intrinsics.checkNotNullExpressionValue(svip, "getSvip(...)");
        return new CurrentRoomOnlineBean(Long.valueOf(id2), avatar, code, country, countryIcon, externalId, Boolean.valueOf(isLogout), Boolean.valueOf(isPrettyCode), Boolean.valueOf(isVip), nick, nobleInfo, Integer.valueOf(sex), Long.valueOf(vipExpireTime), Integer.valueOf(svipLevel), toSvipData(svip));
    }

    @NotNull
    public static final CurrentRoomOnlineBeanList toCurrentRoomOnlineBeanList(@NotNull UserProxy1.RoomOnlineUser roomOnlineUser) {
        Intrinsics.checkNotNullParameter(roomOnlineUser, "<this>");
        ArrayList arrayList = new ArrayList();
        List<UserProxy.RoomOnlineUserMsg> usersList = roomOnlineUser.getUsersList();
        Intrinsics.checkNotNullExpressionValue(usersList, "getUsersList(...)");
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(usersList, 10));
        for (UserProxy.RoomOnlineUserMsg roomOnlineUserMsg : usersList) {
            Intrinsics.checkNotNull(roomOnlineUserMsg);
            arrayList2.add(Boolean.valueOf(arrayList.add(toCurrentRoomOnlineBean(roomOnlineUserMsg))));
        }
        return new CurrentRoomOnlineBeanList(roomOnlineUser.getTotal(), arrayList, roomOnlineUser.getServiceTime());
    }

    @NotNull
    public static final EmojiBean toEmojiBean(@NotNull UserProxy1.MicEmoji micEmoji) {
        Intrinsics.checkNotNullParameter(micEmoji, "<this>");
        long id2 = micEmoji.getId();
        String iconUrl = micEmoji.getIconUrl();
        Intrinsics.checkNotNullExpressionValue(iconUrl, "getIconUrl(...)");
        String name = micEmoji.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String svagUrl = micEmoji.getSvagUrl();
        Intrinsics.checkNotNullExpressionValue(svagUrl, "getSvagUrl(...)");
        return new EmojiBean(id2, iconUrl, name, svagUrl);
    }

    @SuppressLint({"DefaultLocale"})
    @NotNull
    public static final ExchangeDetailData toExchangeDetailData(@NotNull UserCostDiamondsDetail userCostDiamondsDetail, boolean z) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(userCostDiamondsDetail, "<this>");
        if (userCostDiamondsDetail.getOperationType() == 1) {
            str = "+";
        } else {
            str = "-";
        }
        String desc = userCostDiamondsDetail.getDesc();
        String dateHmsInSecond$default = DateTimeUtilityKt.getDateHmsInSecond$default(userCostDiamondsDetail.getCreatedAt(), (Locale) null, (String) null, 6, (Object) null);
        if (z) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(userCostDiamondsDetail.getAmount())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            str2 = str + format + " " + ResourcesKtxKt.getStringById(userCostDiamondsDetail, 2131952567);
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(userCostDiamondsDetail.getAmount())}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            str2 = str + format2 + " " + ResourcesKtxKt.getStringById(userCostDiamondsDetail, 2131952924);
        }
        return new ExchangeDetailData(desc, dateHmsInSecond$default, str2, z);
    }

    public static /* synthetic */ ExchangeDetailData toExchangeDetailData$default(UserCostDiamondsDetail userCostDiamondsDetail, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return toExchangeDetailData(userCostDiamondsDetail, z);
    }

    @NotNull
    public static final FamilyInfo toFamilyInfo(@NotNull UserProxy.CvGroupPowerInfo cvGroupPowerInfo) {
        Intrinsics.checkNotNullParameter(cvGroupPowerInfo, "<this>");
        long id2 = cvGroupPowerInfo.getId();
        String name = cvGroupPowerInfo.getName();
        String nameplate = cvGroupPowerInfo.getNameplate();
        long nextExp = cvGroupPowerInfo.getNextExp();
        boolean showExp = cvGroupPowerInfo.getShowExp();
        int memberMax = cvGroupPowerInfo.getMemberMax();
        int memberNum = cvGroupPowerInfo.getMemberNum();
        long exp = cvGroupPowerInfo.getExp();
        String expireAt = cvGroupPowerInfo.getExpireAt();
        int grade = cvGroupPowerInfo.getGrade();
        return new FamilyInfo(Long.valueOf(exp), expireAt, Integer.valueOf(grade), Long.valueOf(id2), cvGroupPowerInfo.getIcon(), name, nameplate, 0, Long.valueOf(nextExp), (Integer) null, Boolean.valueOf(showExp), Integer.valueOf(memberMax), Integer.valueOf(memberNum), (String) null, (String) null, (String) null, 0, false, 57856, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final FoodieHotMessage toFoodieHotMessage(@NotNull UserProxy1.FoodieTopHotMessage foodieTopHotMessage) {
        Intrinsics.checkNotNullParameter(foodieTopHotMessage, "<this>");
        FoodieHotMessage foodieHotMessage = new FoodieHotMessage(null, null, 3, null);
        ArrayList<FoodieHotBean> arrayList = new ArrayList<>();
        foodieHotMessage.setRound(Integer.valueOf(foodieTopHotMessage.getRound()));
        List<UserProxy.FoodieHotData> hotFoodiesList = foodieTopHotMessage.getHotFoodiesList();
        Intrinsics.checkNotNullExpressionValue(hotFoodiesList, "getHotFoodiesList(...)");
        for (UserProxy.FoodieHotData foodieHotData : hotFoodiesList) {
            FoodieHotBean foodieHotBean = new FoodieHotBean();
            foodieHotBean.setFoodieId((int) foodieHotData.getFoodieId());
            foodieHotBean.setHot(foodieHotData.getHot());
            foodieHotBean.setFlamesNumber(foodieHotData.getFlamesNumber());
            arrayList.add(foodieHotBean);
        }
        foodieHotMessage.setHotFoodies(arrayList);
        return foodieHotMessage;
    }

    @NotNull
    public static final GroupBroadCastBean toGroupBroadCastBean(@NotNull UserProxy.GroupSendNotice groupSendNotice) {
        Intrinsics.checkNotNullParameter(groupSendNotice, "<this>");
        String senderExtId = groupSendNotice.getSenderExtId();
        Intrinsics.checkNotNullExpressionValue(senderExtId, "getSenderExtId(...)");
        String senderCode = groupSendNotice.getSenderCode();
        Intrinsics.checkNotNullExpressionValue(senderCode, "getSenderCode(...)");
        int senderSex = groupSendNotice.getSenderSex();
        String senderAvatar = groupSendNotice.getSenderAvatar();
        Intrinsics.checkNotNullExpressionValue(senderAvatar, "getSenderAvatar(...)");
        String text = groupSendNotice.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        String groupName = groupSendNotice.getGroupName();
        Intrinsics.checkNotNullExpressionValue(groupName, "getGroupName(...)");
        String groupCode = groupSendNotice.getGroupCode();
        Intrinsics.checkNotNullExpressionValue(groupCode, "getGroupCode(...)");
        String groupAvatar = groupSendNotice.getGroupAvatar();
        Intrinsics.checkNotNullExpressionValue(groupAvatar, "getGroupAvatar(...)");
        int userInNum = groupSendNotice.getUserInNum();
        String groupId = groupSendNotice.getGroupId();
        Intrinsics.checkNotNullExpressionValue(groupId, "getGroupId(...)");
        return new GroupBroadCastBean(senderExtId, senderCode, senderSex, senderAvatar, text, groupName, groupCode, groupAvatar, userInNum, groupId);
    }

    @NotNull
    public static final GroupDetailBean toGroupDetailBean(@NotNull UserProxy1.GroupPkInvite groupPkInvite) {
        Intrinsics.checkNotNullParameter(groupPkInvite, "<this>");
        String groupId = groupPkInvite.getGroupId();
        String name = groupPkInvite.getName();
        return new GroupDetailBean(groupPkInvite.getGroupCode(), null, null, groupPkInvite.getFaceUrl(), groupId, null, null, null, null, null, false, name, null, groupPkInvite.getNotification(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, -10266, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
    }

    @NotNull
    public static final GroupGiftDetail toGroupGiftDetail(@NotNull UserProxy.GiftDetailInfo giftDetailInfo) {
        Intrinsics.checkNotNullParameter(giftDetailInfo, "<this>");
        return new GroupGiftDetail(giftDetailInfo.getSvgaUrl(), giftDetailInfo.getIconUrl(), giftDetailInfo.getSenderAvatar(), giftDetailInfo.getReceiverAvatar());
    }

    @NotNull
    public static final GroupRoomImCustomBean toGroupRoomImCustomBean(@NotNull MeetingRoomReceiveGiftCustomContent meetingRoomReceiveGiftCustomContent) {
        String str;
        Integer num;
        Intrinsics.checkNotNullParameter(meetingRoomReceiveGiftCustomContent, "<this>");
        String receiveUserAvatar = meetingRoomReceiveGiftCustomContent.getReceiveUserAvatar();
        String receiveUserExternalId = meetingRoomReceiveGiftCustomContent.getReceiveUserExternalId();
        String receiveUserNick = meetingRoomReceiveGiftCustomContent.getReceiveUserNick();
        String sendUserAvatar = meetingRoomReceiveGiftCustomContent.getSendUserAvatar();
        String sendUserExternalId = meetingRoomReceiveGiftCustomContent.getSendUserExternalId();
        String sendUserNick = meetingRoomReceiveGiftCustomContent.getSendUserNick();
        long resGiftId = meetingRoomReceiveGiftCustomContent.getResGiftId();
        long resGiftNum = meetingRoomReceiveGiftCustomContent.getResGiftNum();
        boolean senderIsVip = meetingRoomReceiveGiftCustomContent.getSenderIsVip();
        int senderNobleLevel = meetingRoomReceiveGiftCustomContent.getSenderNobleLevel();
        long senderWealthGrade = meetingRoomReceiveGiftCustomContent.getSenderWealthGrade();
        long senderCharmGrade = meetingRoomReceiveGiftCustomContent.getSenderCharmGrade();
        boolean senderIsPrettyCode = meetingRoomReceiveGiftCustomContent.getSenderIsPrettyCode();
        FamilyInfo senderPower = meetingRoomReceiveGiftCustomContent.getSenderPower();
        if (senderPower != null) {
            str = senderPower.getNameplate();
        } else {
            str = null;
        }
        FamilyInfo senderPower2 = meetingRoomReceiveGiftCustomContent.getSenderPower();
        if (senderPower2 != null) {
            num = senderPower2.getGrade();
        } else {
            num = null;
        }
        String senderGroupPowerName = meetingRoomReceiveGiftCustomContent.getSenderGroupPowerName();
        if (senderGroupPowerName == null) {
            senderGroupPowerName = "";
        }
        ArrayList<Integer> senderMedalIds = meetingRoomReceiveGiftCustomContent.getSenderMedalIds();
        GroupGiftDetail giftDetail = meetingRoomReceiveGiftCustomContent.getGiftDetail();
        int senderSvipLevel = meetingRoomReceiveGiftCustomContent.getSenderSvipLevel();
        return new GroupRoomImCustomBean(receiveUserAvatar, receiveUserExternalId, receiveUserNick, sendUserAvatar, sendUserExternalId, sendUserNick, "6", 1, Long.valueOf(resGiftId), Long.valueOf(resGiftNum), Boolean.valueOf(senderIsVip), (ArrayList) null, "", "", "", "", "", "", 0, 0, 0, "", (Long) null, Integer.valueOf(senderNobleLevel), Long.valueOf(senderWealthGrade), Long.valueOf(senderCharmGrade), Boolean.valueOf(senderIsPrettyCode), senderGroupPowerName, str, num, senderMedalIds, (String) null, giftDetail, (String) null, Integer.valueOf(senderSvipLevel), meetingRoomReceiveGiftCustomContent.getSvip(), meetingRoomReceiveGiftCustomContent.getReceiveSvip(), meetingRoomReceiveGiftCustomContent.getSenderCornerMark(), -2143289344, 2, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final MeetingRoomReceiveGiftCustomContent toMeetingRoomReceiveGiftCustomContent(@NotNull UserProxy1.GiftContentMessage giftContentMessage) {
        String str;
        boolean z;
        String str2;
        long j;
        int i;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(giftContentMessage, "<this>");
        ArrayList arrayList2 = new ArrayList();
        List<Long> senderMedalIdsList = giftContentMessage.getSenderMedalIdsList();
        Intrinsics.checkNotNullExpressionValue(senderMedalIdsList, "getSenderMedalIdsList(...)");
        Iterator<T> it = senderMedalIdsList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf((int) ((Long) it.next()).longValue()));
        }
        String receiveUserExternalId = giftContentMessage.getReceiveUserExternalId();
        Intrinsics.checkNotNullExpressionValue(receiveUserExternalId, "getReceiveUserExternalId(...)");
        String receiveUserAvatar = giftContentMessage.getReceiveUserAvatar();
        Intrinsics.checkNotNullExpressionValue(receiveUserAvatar, "getReceiveUserAvatar(...)");
        String receiveUserNick = giftContentMessage.getReceiveUserNick();
        Intrinsics.checkNotNullExpressionValue(receiveUserNick, "getReceiveUserNick(...)");
        long resGiftId = giftContentMessage.getResGiftId();
        long resGiftNum = giftContentMessage.getResGiftNum();
        String sendUserExternalId = giftContentMessage.getSendUserExternalId();
        Intrinsics.checkNotNullExpressionValue(sendUserExternalId, "getSendUserExternalId(...)");
        String sendUserAvatar = giftContentMessage.getSendUserAvatar();
        Intrinsics.checkNotNullExpressionValue(sendUserAvatar, "getSendUserAvatar(...)");
        String sendUserNick = giftContentMessage.getSendUserNick();
        Intrinsics.checkNotNullExpressionValue(sendUserNick, "getSendUserNick(...)");
        boolean giftGroupBroadcast = giftContentMessage.getGiftGroupBroadcast();
        String sourceGroupId = giftContentMessage.getSourceGroupId();
        Intrinsics.checkNotNullExpressionValue(sourceGroupId, "getSourceGroupId(...)");
        int senderNobleLevel = giftContentMessage.getSenderNobleLevel();
        long senderWealthGrade = giftContentMessage.getSenderWealthGrade();
        long senderCharmGrade = giftContentMessage.getSenderCharmGrade();
        boolean senderIsPrettyCode = giftContentMessage.getSenderIsPrettyCode();
        boolean senderIsVip = giftContentMessage.getSenderIsVip();
        int senderSvipLevel = giftContentMessage.getSenderSvipLevel();
        UserProxy.CvSvip svip = giftContentMessage.getSvip();
        Intrinsics.checkNotNullExpressionValue(svip, "getSvip(...)");
        SvipData svipData = toSvipData(svip);
        UserProxy.CvSvip receiveSvip = giftContentMessage.getReceiveSvip();
        Intrinsics.checkNotNullExpressionValue(receiveSvip, "getReceiveSvip(...)");
        SvipData svipData2 = toSvipData(receiveSvip);
        String senderGroupPowerName = giftContentMessage.getSenderGroupPowerName();
        long groupConsume = giftContentMessage.getGroupConsume();
        UserProxy.GiftDetailInfo giftDetail = giftContentMessage.getGiftDetail();
        Intrinsics.checkNotNullExpressionValue(giftDetail, "getGiftDetail(...)");
        GroupGiftDetail groupGiftDetail = toGroupGiftDetail(giftDetail);
        UserProxy.CvGroupPowerInfo senderPower = giftContentMessage.getSenderPower();
        Intrinsics.checkNotNullExpressionValue(senderPower, "getSenderPower(...)");
        FamilyInfo familyInfo = toFamilyInfo(senderPower);
        int senderSex = giftContentMessage.getSenderSex();
        int receiveSex = giftContentMessage.getReceiveSex();
        int giftType = giftContentMessage.getGiftType();
        String giftText = giftContentMessage.getGiftText();
        List<UserProxy.TextStyle> textStyleListList = giftContentMessage.getTextStyleListList();
        if (textStyleListList != null) {
            j = senderWealthGrade;
            i = senderNobleLevel;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(textStyleListList, 10));
            Iterator it2 = textStyleListList.iterator();
            while (it2.hasNext()) {
                UserProxy.TextStyle textStyle = (UserProxy.TextStyle) it2.next();
                arrayList3.add(new TextStyles(textStyle.getTextColor(), Float.valueOf(textStyle.getTextSize()), Boolean.valueOf(textStyle.getIsBold()), textStyle.getTextKey()));
                it2 = it2;
                sourceGroupId = sourceGroupId;
                giftGroupBroadcast = giftGroupBroadcast;
                sendUserNick = sendUserNick;
            }
            str = sendUserNick;
            z = giftGroupBroadcast;
            str2 = sourceGroupId;
            arrayList = arrayList3;
        } else {
            str = sendUserNick;
            z = giftGroupBroadcast;
            str2 = sourceGroupId;
            j = senderWealthGrade;
            i = senderNobleLevel;
            arrayList = null;
        }
        return new MeetingRoomReceiveGiftCustomContent(receiveUserExternalId, receiveUserAvatar, receiveUserNick, resGiftId, resGiftNum, sendUserExternalId, sendUserAvatar, str, z, str2, i, j, senderCharmGrade, senderIsPrettyCode, senderIsVip, senderSvipLevel, svipData, svipData2, senderGroupPowerName, arrayList2, groupConsume, groupGiftDetail, familyInfo, Integer.valueOf(senderSex), Integer.valueOf(receiveSex), Integer.valueOf(giftType), arrayList, giftText, giftContentMessage.getSenderCornerMark());
    }

    @NotNull
    public static final RoomMessageMulti toMessageMulti(@NotNull MeetingRoomReceiveGiftCustomContent meetingRoomReceiveGiftCustomContent) {
        long j;
        String str;
        Intrinsics.checkNotNullParameter(meetingRoomReceiveGiftCustomContent, "<this>");
        GroupMessageNew groupMessageNew = new GroupMessageNew((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (CloudCustomData) null, (Long) null, (Long) null, (Integer) null, (Integer) null, UnixStat.PERM_MASK, (DefaultConstructorMarker) null);
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            j = service.getServerTime();
        } else {
            j = 0;
        }
        long random = (j * 1000) + RangesKt.random(new IntRange(0, 1000), Random.Default);
        GroupRoomImCustomBean groupRoomImCustomBean = toGroupRoomImCustomBean(meetingRoomReceiveGiftCustomContent);
        MsgBody msgBody = new MsgBody((String) null, (CustomElemContent) null, (TextElemContent) null, (VideoElemContent) null, (ImageElemContent) null, 31, (DefaultConstructorMarker) null);
        msgBody.setCustomContent(new CustomElemContent(BaseApplication.Companion.getGSON().s(groupRoomImCustomBean), groupRoomImCustomBean));
        ArrayList arrayList = new ArrayList();
        arrayList.add(msgBody);
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        groupMessageNew.setMsgId(str + "_" + random);
        groupMessageNew.setFromAccount(meetingRoomReceiveGiftCustomContent.getSendUserExternalId());
        groupMessageNew.setSenderNick(meetingRoomReceiveGiftCustomContent.getSendUserNick());
        groupMessageNew.setSenderAvatar(meetingRoomReceiveGiftCustomContent.getSendUserAvatar());
        groupMessageNew.setMsgBody(arrayList);
        groupMessageNew.setOperatorAccount(meetingRoomReceiveGiftCustomContent.getSendUserExternalId());
        groupMessageNew.setStatus(1);
        groupMessageNew.setEventTime(Long.valueOf(random));
        groupMessageNew.setGroupId(MeetingRoomManager.INSTANCE.getMGroupId());
        groupMessageNew.setCloudCustomData(toCloudCustomData(meetingRoomReceiveGiftCustomContent));
        groupMessageNew.setMsgTab(0);
        return new RoomMessageMulti(groupMessageNew, 8);
    }

    @NotNull
    public static final MicroBean toMicroBean(@NotNull UserProxy1.GroupMicChange groupMicChange) {
        Intrinsics.checkNotNullParameter(groupMicChange, "<this>");
        String groupId = groupMicChange.getGroupId();
        Intrinsics.checkNotNullExpressionValue(groupId, "getGroupId(...)");
        int i = groupMicChange.getI();
        String externalId = groupMicChange.getExternalId();
        Boolean valueOf = Boolean.valueOf(groupMicChange.getForbid());
        boolean lock = groupMicChange.getLock();
        int agoraId = groupMicChange.getAgoraId();
        long timestamp = groupMicChange.getTimestamp();
        boolean micForbid = groupMicChange.getMicForbid();
        UserProxy.MicUserData user = groupMicChange.getUser();
        Intrinsics.checkNotNullExpressionValue(user, "getUser(...)");
        MicroBean microBean = new MicroBean(groupId, i, externalId, valueOf, lock, agoraId, timestamp, micForbid, toMicroUserBean(user), false, null, 1536, null);
        if (groupMicChange.getRoomBanner() != null && !TextUtils.isEmpty(groupMicChange.getRoomBanner().getUrl())) {
            UserProxy.XjsRoomBanner roomBanner = groupMicChange.getRoomBanner();
            Intrinsics.checkNotNullExpressionValue(roomBanner, "getRoomBanner(...)");
            microBean.setRoomBanner(toRoomBanner(roomBanner));
        }
        return microBean;
    }

    @Nullable
    public static final MicroUserBean toMicroUserBean(@NotNull UserProxy.MicUserData micUserData) {
        Intrinsics.checkNotNullParameter(micUserData, "<this>");
        if (TextUtils.isEmpty(micUserData.getExternalId())) {
            return null;
        }
        String externalId = micUserData.getExternalId();
        Intrinsics.checkNotNullExpressionValue(externalId, "getExternalId(...)");
        String avatar = micUserData.getAvatar();
        Intrinsics.checkNotNullExpressionValue(avatar, "getAvatar(...)");
        String nick = micUserData.getNick();
        Intrinsics.checkNotNullExpressionValue(nick, "getNick(...)");
        int sex = micUserData.getSex();
        String code = micUserData.getCode();
        Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
        boolean isVip = micUserData.getIsVip();
        int noble = micUserData.getNoble();
        String headwearPicUrl = micUserData.getHeadwearPicUrl();
        Intrinsics.checkNotNullExpressionValue(headwearPicUrl, "getHeadwearPicUrl(...)");
        String headwearEffectUrl = micUserData.getHeadwearEffectUrl();
        Intrinsics.checkNotNullExpressionValue(headwearEffectUrl, "getHeadwearEffectUrl(...)");
        String headwearReverseEffectUrl = micUserData.getHeadwearReverseEffectUrl();
        Intrinsics.checkNotNullExpressionValue(headwearReverseEffectUrl, "getHeadwearReverseEffectUrl(...)");
        int svipLevel = micUserData.getSvipLevel();
        UserProxy.Svip svip = micUserData.getSvip();
        Intrinsics.checkNotNullExpressionValue(svip, "getSvip(...)");
        return new MicroUserBean(0, externalId, avatar, nick, sex, code, isVip, noble, headwearPicUrl, headwearEffectUrl, headwearReverseEffectUrl, svipLevel, toSvipData(svip), micUserData.getMicEffect(), micUserData.getHeadwearIcon(), Boolean.valueOf(micUserData.getMusic()));
    }

    @NotNull
    public static final NobleInfo toNobleInfo(@NotNull UserProxy.RoomUserNoble roomUserNoble) {
        Intrinsics.checkNotNullParameter(roomUserNoble, "<this>");
        return new NobleInfo(Integer.valueOf(roomUserNoble.getLevel()), Long.valueOf(roomUserNoble.getEndTime()), (String) null, 4, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final PKInviteCancel toPKInviteCancel(@NotNull UserProxy1.GamePkInviteCancel gamePkInviteCancel) {
        Intrinsics.checkNotNullParameter(gamePkInviteCancel, "<this>");
        int type = gamePkInviteCancel.getType();
        int gameId = (int) gamePkInviteCancel.getGameId();
        String groupId = gamePkInviteCancel.getGroupId();
        String code = gamePkInviteCancel.getCode();
        String name = gamePkInviteCancel.getName();
        String avatar = gamePkInviteCancel.getAvatar();
        int mode = gamePkInviteCancel.getMode();
        int gameType = gamePkInviteCancel.getGameType();
        String externalId = gamePkInviteCancel.getExternalId();
        String country = gamePkInviteCancel.getCountry();
        long birthDay = gamePkInviteCancel.getBirthDay();
        return new PKInviteCancel(Integer.valueOf(type), Integer.valueOf(gameId), groupId, code, name, Integer.valueOf(gameType), avatar, Integer.valueOf(mode), externalId, country, Long.valueOf(birthDay), gamePkInviteCancel.getSex(), Integer.valueOf(gamePkInviteCancel.getSvipLevel()));
    }

    @NotNull
    public static final RoomAllGift toRoomAllGift(@NotNull UserProxy1.RoomGiftEffect roomGiftEffect) {
        Intrinsics.checkNotNullParameter(roomGiftEffect, "<this>");
        return new RoomAllGift(roomGiftEffect.getGiftIcon());
    }

    @NotNull
    public static final MicBanner toRoomBanner(@NotNull UserProxy.XjsRoomBanner xjsRoomBanner) {
        Intrinsics.checkNotNullParameter(xjsRoomBanner, "<this>");
        return new MicBanner(null, xjsRoomBanner.getNick(), xjsRoomBanner.getMyAvatar(), Integer.valueOf((int) xjsRoomBanner.getVote()), xjsRoomBanner.getAvatar1(), xjsRoomBanner.getAvatar2(), xjsRoomBanner.getAvatar3(), xjsRoomBanner.getUrl(), 1, null);
    }

    @NotNull
    public static final Special toSpecial(@NotNull CpSpace cpSpace, int i) {
        Long l;
        Integer num;
        Integer num2;
        String str;
        Long l2;
        Intrinsics.checkNotNullParameter(cpSpace, "<this>");
        CpInfo cpInfo = cpSpace.getCpInfo();
        User user = null;
        if (cpInfo != null) {
            l = cpInfo.getCreatedUnix();
        } else {
            l = null;
        }
        CpInfo cpInfo2 = cpSpace.getCpInfo();
        if (cpInfo2 != null) {
            num = cpInfo2.getCpDays();
        } else {
            num = null;
        }
        CpLevel cpLevel = cpSpace.getCpLevel();
        if (cpLevel != null) {
            num2 = cpLevel.getLevel();
        } else {
            num2 = null;
        }
        CpLevel cpLevel2 = cpSpace.getCpLevel();
        if (cpLevel2 != null) {
            str = cpLevel2.getTitle();
        } else {
            str = null;
        }
        CpLevel cpLevel3 = cpSpace.getCpLevel();
        if (cpLevel3 != null) {
            l2 = cpLevel3.getPoints();
        } else {
            l2 = null;
        }
        CpInfo cpInfo3 = cpSpace.getCpInfo();
        if (cpInfo3 != null) {
            user = cpInfo3.getCpUserInfo();
        }
        return new Special((String) null, l, num, (String) null, num2, str, l2, Integer.valueOf(i), user, 9, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final SvipData toSvipData(@NotNull UserProxy.Svip svip) {
        Intrinsics.checkNotNullParameter(svip, "<this>");
        ArrayList arrayList = new ArrayList();
        List<UserProxy.SvipPrivilege> privilegesList = svip.getPrivilegesList();
        if (privilegesList != null) {
            for (UserProxy.SvipPrivilege svipPrivilege : privilegesList) {
                arrayList.add(new Privilege(svipPrivilege.getType(), svipPrivilege.getCanSwitch(), svipPrivilege.getUserSwitch(), svipPrivilege.getMysteryCode()));
            }
        }
        return new SvipData((int) svip.getSvipLevel(), arrayList, (String) null, 4, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final List<TextStyles> toTextStyleList(@NotNull UserProxy.GiftInfo giftInfo) {
        Intrinsics.checkNotNullParameter(giftInfo, "<this>");
        ArrayList arrayList = new ArrayList();
        List<UserProxy.GiftTextStyle> textStyleListList = giftInfo.getTextStyleListList();
        if (textStyleListList != null) {
            for (UserProxy.GiftTextStyle giftTextStyle : textStyleListList) {
                arrayList.add(new TextStyles(giftTextStyle.getTextColor(), Float.valueOf(giftTextStyle.getTextSize()), Boolean.valueOf(giftTextStyle.getIsBold()), giftTextStyle.getTextKey()));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final DiamondCellUIModel toUIModel(@NotNull PurchaseDiamondDetail purchaseDiamondDetail, int i) {
        Intrinsics.checkNotNullParameter(purchaseDiamondDetail, "diamondDetail");
        long id2 = purchaseDiamondDetail.getId();
        String productID = purchaseDiamondDetail.getProductID();
        return new DiamondCellUIModel(id2, i, String.valueOf(purchaseDiamondDetail.getPrice()), StringUtilityKt.format2Bit(purchaseDiamondDetail.getPrice()), String.valueOf((int) purchaseDiamondDetail.getAmount()), productID, purchaseDiamondDetail.getExtraAmount());
    }

    @NotNull
    public static final User toUser(@NotNull UserProxy.MatchSuccess matchSuccess) {
        Intrinsics.checkNotNullParameter(matchSuccess, "<this>");
        String avatar = matchSuccess.getRemoteUser().getAvatar();
        long birthday = matchSuccess.getRemoteUser().getBirthday();
        String country = matchSuccess.getRemoteUser().getCountry();
        String countryIcon = matchSuccess.getRemoteUser().getCountryIcon();
        String nick = matchSuccess.getRemoteUser().getNick();
        String externalId = matchSuccess.getRemoteUser().getExternalId();
        if (externalId == null) {
            externalId = "";
        }
        String str = externalId;
        boolean isLikeMe = matchSuccess.getRemoteUser().getIsLikeMe();
        boolean isLike = matchSuccess.getRemoteUser().getIsLike();
        IntRange intRange = new IntRange(0, 1);
        Random.Default r11 = Random.Default;
        return new User(avatar, Long.valueOf(birthday), country, countryIcon, 0.0d, str, 0L, "", 0, 0, 0, nick, 0, "description", Integer.valueOf(RangesKt.random(intRange, r11)), (Boolean) null, (Integer) null, (Boolean) null, (Boolean) null, Boolean.valueOf(isLike), Boolean.valueOf(isLikeMe), (Boolean) null, (Boolean) null, RangesKt.random(new IntRange(100000, 999999), r11), ((Number) CollectionsKt.random(CollectionsKt.listOf(new Integer[]{0, 25, 50, 75, 100}), r11)).intValue(), 100, (Integer) null, 0L, 0L, 0L, false, 0L, (List) null, (List) null, (HeadWearBean) null, (Boolean) null, (String) null, 0L, new RideBean(0, "", "", false, 0, (String) null, (String) null, (String) null, (String) null, (List) null, 1016, (DefaultConstructorMarker) null), (String) null, (NobleInfo) null, false, (String) null, (Double) null, (PhoneInfo) null, (ArrayList) null, (CountryManager) null, (Double) null, (Integer) null, (SvipData) null, (FamilyInfo) null, (MyCp) null, (Boolean) null, 0, (Boolean) null, (Integer) null, (RelationUserData) null, (String) null, (String) null, (String) null, (String) null, (CanChat) null, (MyGameLevel) null, (Integer) null, (Boolean) null, 0, 0, -60487872, -577, 7, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final VideoSetting toVideoSet(@NotNull UserProxy.VideoSetting videoSetting) {
        Intrinsics.checkNotNullParameter(videoSetting, "<this>");
        return new VideoSetting(Integer.valueOf(videoSetting.getFrontOrBack()), Integer.valueOf(videoSetting.getCameraOnOff()));
    }

    @NotNull
    public static final EnterEffectData userToEnterEffectData(@NotNull User user, @NotNull GroupDetailBean groupDetailBean) {
        int i;
        Integer level;
        Intrinsics.checkNotNullParameter(user, "<this>");
        Intrinsics.checkNotNullParameter(groupDetailBean, "data");
        String nick = user.getNick();
        boolean isVip = user.isVip();
        NobleInfo noble = user.getNoble();
        if (noble != null && (level = noble.getLevel()) != null) {
            i = level.intValue();
        } else {
            i = 0;
        }
        return new EnterEffectData(nick, isVip, i, user.getSvip(), user.getAvatar(), groupDetailBean.getCpLevel(), groupDetailBean.getCpUserAvatar(), groupDetailBean.getEntryEffectType(), null, null, null, 1792, null);
    }

    @NotNull
    public static final GroupDetailBean toGroupDetailBean(@NotNull PKInviteCancel pKInviteCancel) {
        Intrinsics.checkNotNullParameter(pKInviteCancel, "<this>");
        String groupId = pKInviteCancel.getGroupId();
        String name = pKInviteCancel.getName();
        return new GroupDetailBean(pKInviteCancel.getCode(), null, null, pKInviteCancel.getAvatar(), groupId, null, null, null, null, null, false, name, null, "", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, -10266, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
    }

    @NotNull
    public static final ChannelEventStartup toChannelEventStartup(@NotNull UserProxy.VideoCallReady videoCallReady) {
        Intrinsics.checkNotNullParameter(videoCallReady, "<this>");
        long startTimestamp = videoCallReady.getStartTimestamp() - (System.currentTimeMillis() / 1000);
        String channelId = videoCallReady.getChannelId();
        Intrinsics.checkNotNullExpressionValue(channelId, "getChannelId(...)");
        long callDuration = videoCallReady.getCallDuration();
        long endTimestamp = videoCallReady.getEndTimestamp();
        long startTimestamp2 = videoCallReady.getStartTimestamp();
        UserProxy.VideoSetting videoSetting = videoCallReady.getVideoSetting();
        Intrinsics.checkNotNullExpressionValue(videoSetting, "getVideoSetting(...)");
        VideoSetting videoSet = toVideoSet(videoSetting);
        UserProxy.VideoSetting otherVideoSetting = videoCallReady.getOtherVideoSetting();
        Intrinsics.checkNotNullExpressionValue(otherVideoSetting, "getOtherVideoSetting(...)");
        return new ChannelEventStartup(channelId, callDuration, endTimestamp, startTimestamp2, startTimestamp, (String) null, videoSet, toVideoSet(otherVideoSetting), 32, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final ExchangeDetailData toExchangeDetailData(@NotNull BeanChangeDetail beanChangeDetail) {
        String str;
        String stringById;
        Intrinsics.checkNotNullParameter(beanChangeDetail, "<this>");
        if (beanChangeDetail.getOperationType() == 1) {
            str = "+";
        } else {
            str = "-";
        }
        int useType = beanChangeDetail.getUseType();
        if (useType == 1) {
            stringById = ResourcesKtxKt.getStringById(beanChangeDetail, 2131952894);
        } else if (useType == 2) {
            stringById = ResourcesKtxKt.getStringById(beanChangeDetail, 2131952561);
        } else if (useType != 6 && useType != 7) {
            stringById = ResourcesKtxKt.getStringById(beanChangeDetail, 2131953595);
        } else {
            stringById = ResourcesKtxKt.getStringById(beanChangeDetail, 2131952885);
        }
        return new ExchangeDetailData(stringById, DateTimeUtilityKt.getDateHmsInSecond$default(beanChangeDetail.getCreatedAt(), (Locale) null, (String) null, 6, (Object) null), str + StringUtilityKt.format2Bit(beanChangeDetail.getAmount()) + " " + ResourcesKtxKt.getStringById(beanChangeDetail, 2131952458), true);
    }

    @NotNull
    public static final SvipData toSvipData(@NotNull UserProxy.CvSvip cvSvip) {
        Intrinsics.checkNotNullParameter(cvSvip, "<this>");
        ArrayList arrayList = new ArrayList();
        List<UserProxy.CVSvipPrivilege> privilegesList = cvSvip.getPrivilegesList();
        if (privilegesList != null) {
            for (UserProxy.CVSvipPrivilege cVSvipPrivilege : privilegesList) {
                arrayList.add(new Privilege(cVSvipPrivilege.getType(), cVSvipPrivilege.getCanSwitch(), cVSvipPrivilege.getUserSwitch(), cVSvipPrivilege.getMysteryCode()));
            }
        }
        return new SvipData(cvSvip.getSvipLevel(), arrayList, cvSvip.getMedalEffect());
    }

    @NotNull
    public static final User toUser(@NotNull UserProxy.User user) {
        Intrinsics.checkNotNullParameter(user, "<this>");
        long id2 = user.getId();
        String externalId = user.getExternalId();
        if (externalId == null) {
            externalId = "";
        }
        String str = externalId;
        String nick = user.getNick();
        String avatar = user.getAvatar();
        long birthday = user.getBirthday();
        String countryIcon = user.getCountryIcon();
        String country = user.getCountry();
        boolean isVip = user.getIsVip();
        boolean isLike = user.getIsLike();
        String code = user.getCode();
        Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
        boolean isLikeMe = user.getIsLikeMe();
        IntRange intRange = new IntRange(0, 1);
        Random.Default r6 = Random.Default;
        return new User(avatar, Long.valueOf(birthday), country, countryIcon, 0.0d, str, id2, code, 0, 0, 0, nick, 0, "description", Integer.valueOf(RangesKt.random(intRange, r6)), (Boolean) null, (Integer) null, (Boolean) null, (Boolean) null, Boolean.valueOf(isLike), Boolean.valueOf(isLikeMe), (Boolean) null, (Boolean) null, RangesKt.random(new IntRange(100000, 999999), r6), ((Number) CollectionsKt.random(CollectionsKt.listOf(new Integer[]{0, 25, 50, 75, 100}), r6)).intValue(), 100, (Integer) null, 0L, 0L, 0L, isVip, 0L, (List) null, (List) null, (HeadWearBean) null, (Boolean) null, (String) null, 0L, new RideBean(0, "", "", false, 0, (String) null, (String) null, (String) null, (String) null, (List) null, 1016, (DefaultConstructorMarker) null), (String) null, (NobleInfo) null, false, (String) null, (Double) null, (PhoneInfo) null, (ArrayList) null, (CountryManager) null, (Double) null, (Integer) null, (SvipData) null, (FamilyInfo) null, (MyCp) null, (Boolean) null, 0, (Boolean) null, (Integer) null, (RelationUserData) null, (String) null, (String) null, user.getMaskAvatar(), user.getMaskNick(), (CanChat) null, (MyGameLevel) null, (Integer) null, (Boolean) null, 0, 0, -1134229760, -402653761, 7, (DefaultConstructorMarker) null);
    }

    @Nullable
    public static final String imExtBean(@NotNull User user, @Nullable List<TIMUserBean> list) {
        Intrinsics.checkNotNullParameter(user, "<this>");
        com.google.gson.d dVar = new com.google.gson.d();
        long charmUserGrade = user.getCharmUserGrade();
        long wealthUserGrade = user.getWealthUserGrade();
        Boolean isPrettyCode = user.isPrettyCode();
        boolean isVip = user.isVip();
        String myGroupPowerName = user.getMyGroupPowerName();
        NobleInfo noble = user.getNoble();
        Integer level = noble != null ? noble.getLevel() : null;
        List medals = user.getMedals();
        SvipData svip = user.getSvip();
        return dVar.s(new TIMUserExtBean(Long.valueOf(charmUserGrade), isPrettyCode, Boolean.valueOf(isVip), medals, myGroupPowerName, level, Long.valueOf(wealthUserGrade), svip != null ? svip.getSvipLevel() : 0, user.getSvip(), list, (String) null, (Integer) null, 3072, (DefaultConstructorMarker) null));
    }

    @NotNull
    public static final ExchangeDetailData toExchangeDetailData(@NotNull PurchaseItem purchaseItem) {
        String format2Bit;
        String str;
        Intrinsics.checkNotNullParameter(purchaseItem, "<this>");
        String stringById = ResourcesKtxKt.getStringById(purchaseItem, 2131953850);
        String dateHmsInSecond$default = DateTimeUtilityKt.getDateHmsInSecond$default(purchaseItem.getCreatedAt(), (Locale) null, (String) null, 6, (Object) null);
        if (purchaseItem.getIsCoin()) {
            Float diamonds = purchaseItem.getDiamonds();
            format2Bit = diamonds != null ? StringUtilityKt.format2Bit(diamonds.floatValue()) : null;
            str = "+" + format2Bit + " " + ResourcesKtxKt.getStringById(purchaseItem, 2131952924);
        } else {
            Float diamonds2 = purchaseItem.getDiamonds();
            format2Bit = diamonds2 != null ? StringUtilityKt.format2Bit(diamonds2.floatValue()) : null;
            str = "+" + format2Bit + " " + ResourcesKtxKt.getStringById(purchaseItem, 2131952567);
        }
        return new ExchangeDetailData(stringById, dateHmsInSecond$default, str, !purchaseItem.getIsCoin());
    }

    @NotNull
    public static final User toUser(@NotNull UserSummaryInfo userSummaryInfo) {
        Intrinsics.checkNotNullParameter(userSummaryInfo, "<this>");
        String avatar = userSummaryInfo.getAvatar();
        Long birthday = userSummaryInfo.getBirthday();
        String countryName = userSummaryInfo.getCountryName();
        Integer sex = userSummaryInfo.getSex();
        int intValue = sex != null ? sex.intValue() : 0;
        String name = userSummaryInfo.getName();
        String externalId = userSummaryInfo.getExternalId();
        String str = externalId == null ? "" : externalId;
        String code = userSummaryInfo.getCode();
        String str2 = code == null ? "" : code;
        Boolean isLikeMe = userSummaryInfo.isLikeMe();
        Boolean isLike = userSummaryInfo.isLike();
        IntRange intRange = new IntRange(0, 1);
        Random.Default r7 = Random.Default;
        int random = RangesKt.random(intRange, r7);
        int random2 = RangesKt.random(new IntRange(100000, 999999), r7);
        int intValue2 = ((Number) CollectionsKt.random(CollectionsKt.listOf(new Integer[]{0, 25, 50, 75, 100}), r7)).intValue();
        RideBean rideBean = new RideBean(0, "", "", false, 0, (String) null, (String) null, (String) null, (String) null, (List) null, 1016, (DefaultConstructorMarker) null);
        Boolean isOfficialStaff = userSummaryInfo.isOfficialStaff();
        boolean booleanValue = isOfficialStaff != null ? isOfficialStaff.booleanValue() : false;
        Boolean isVip = userSummaryInfo.isVip();
        return new User(avatar, birthday, countryName, "", 0.0d, str, 0L, str2, 0, 0, 0, name, intValue, "description", Integer.valueOf(random), (Boolean) null, (Integer) null, (Boolean) null, (Boolean) null, isLike, isLikeMe, (Boolean) null, (Boolean) null, random2, intValue2, 100, (Integer) null, 0L, 0L, 0L, isVip != null ? isVip.booleanValue() : false, 0L, (List) null, (List) null, (HeadWearBean) null, (Boolean) null, (String) null, 0L, rideBean, (String) null, (NobleInfo) null, booleanValue, (String) null, (Double) null, (PhoneInfo) null, (ArrayList) null, (CountryManager) null, (Double) null, (Integer) null, (SvipData) null, (FamilyInfo) null, (MyCp) null, (Boolean) null, 0, (Boolean) null, (Integer) null, (RelationUserData) null, (String) null, (String) null, (String) null, (String) null, (CanChat) null, (MyGameLevel) null, (Integer) null, (Boolean) null, 0, 0, -1134229696, -577, 7, (DefaultConstructorMarker) null);
    }
}
