package com.qiahao.nextvideo.data.model;

import com.qiahao.base_common.model.svip.Privilege;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import userProxy.UserProxy;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 Y2\u00020\u0001:\u0001YB\u0083\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010W\u001a\u00020XR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010(\"\u0004\b4\u0010*R\u001c\u0010\f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010,\"\u0004\b6\u0010.R\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010,\"\u0004\b8\u0010.R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010,\"\u0004\b:\u0010.R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010,\"\u0004\b<\u0010.R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010,\"\u0004\b>\u0010.R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010(\"\u0004\b@\u0010*R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010,\"\u0004\bB\u0010.R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010D\"\u0004\bH\u0010FR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\bI\u0010\u001f\"\u0004\bJ\u0010!R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\bK\u0010\u001f\"\u0004\bL\u0010!R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010,\"\u0004\bN\u0010.R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001a\u0010\u001a\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010(\"\u0004\bT\u0010*R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010,\"\u0004\bV\u0010.¨\u0006Z"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GiftBannerData;", "", "bannerLevel", "", "giftId", "", "giftNum", "sendUserId", "", "receiveUserId", "groupId", ExchangeDetailActivity.TYPE_DIAMOND, "roomRocketAvatar", "sendAvatar", "sendUserName", "receiverUserName", "sendCode", "type", "giftUrl", "svip", "Lcom/qiahao/base_common/model/svip/SvipData;", "receiveSvip", "bannerType", "cpLevel", "receiveUserAvatar", "otherData", "nobleLevel", "customEffectUrl", "<init>", "(Ljava/lang/Integer;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/qiahao/base_common/model/svip/SvipData;Lcom/qiahao/base_common/model/svip/SvipData;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;ILjava/lang/String;)V", "getBannerLevel", "()Ljava/lang/Integer;", "setBannerLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getGiftId", "()J", "setGiftId", "(J)V", "getGiftNum", "()I", "setGiftNum", "(I)V", "getSendUserId", "()Ljava/lang/String;", "setSendUserId", "(Ljava/lang/String;)V", "getReceiveUserId", "setReceiveUserId", "getGroupId", "setGroupId", "getDiamond", "setDiamond", "getRoomRocketAvatar", "setRoomRocketAvatar", "getSendAvatar", "setSendAvatar", "getSendUserName", "setSendUserName", "getReceiverUserName", "setReceiverUserName", "getSendCode", "setSendCode", "getType", "setType", "getGiftUrl", "setGiftUrl", "getSvip", "()Lcom/qiahao/base_common/model/svip/SvipData;", "setSvip", "(Lcom/qiahao/base_common/model/svip/SvipData;)V", "getReceiveSvip", "setReceiveSvip", "getBannerType", "setBannerType", "getCpLevel", "setCpLevel", "getReceiveUserAvatar", "setReceiveUserAvatar", "getOtherData", "()Ljava/lang/Object;", "setOtherData", "(Ljava/lang/Object;)V", "getNobleLevel", "setNobleLevel", "getCustomEffectUrl", "setCustomEffectUrl", "checkSupportType", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GiftBannerData {
    public static final int BANNER_BESTIE_GIFT = 4;
    public static final int BANNER_BROTHER_GIFT = 5;
    public static final int BANNER_COUNTRY_MSG = 102;
    public static final int BANNER_CP = 2;
    public static final int BANNER_CP_GIFT = 1;
    public static final int BANNER_DEFAULT_GIFT = 0;
    public static final int BANNER_PK = 103;
    public static final int BANNER_SOUL_GIFT = 3;
    public static final int BANNER_SVIP = 101;
    public static final int BANNER_UPGRADES = 100;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private Integer bannerLevel;

    @Nullable
    private Integer bannerType;

    @Nullable
    private Integer cpLevel;

    @Nullable
    private String customEffectUrl;
    private int diamond;
    private long giftId;
    private int giftNum;

    @Nullable
    private String giftUrl;

    @NotNull
    private String groupId;
    private int nobleLevel;

    @Nullable
    private Object otherData;

    @Nullable
    private SvipData receiveSvip;

    @Nullable
    private String receiveUserAvatar;

    @Nullable
    private String receiveUserId;

    @Nullable
    private String receiverUserName;

    @Nullable
    private String roomRocketAvatar;

    @Nullable
    private String sendAvatar;

    @Nullable
    private String sendCode;

    @Nullable
    private String sendUserId;

    @Nullable
    private String sendUserName;

    @Nullable
    private SvipData svip;
    private int type;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020!J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001a\u001a\u0004\u0018\u00010$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GiftBannerData$Companion;", "", "<init>", "()V", "BANNER_DEFAULT_GIFT", "", "BANNER_CP_GIFT", "BANNER_CP", "BANNER_SOUL_GIFT", "BANNER_BESTIE_GIFT", "BANNER_BROTHER_GIFT", "BANNER_UPGRADES", "BANNER_SVIP", "BANNER_COUNTRY_MSG", "BANNER_PK", "initGiftBeanData", "Lcom/qiahao/nextvideo/data/model/GiftBannerData;", "globalGiftbanner", "LuserProxy/UserProxy$GlobalGiftBanner;", "initLuckyWheelBeanData", "luckyWheelBanner", "LuserProxy/UserProxy$LuckyWheelBanner;", "initRocketBeanData", "globalRocketNotice", "LuserProxy/UserProxy$GlobalRocketNotice;", "initCpUpgrades", "data", "LuserProxy/UserProxy1$CpUpgrade;", "initSVIPUpgrades", "LuserProxy/UserProxy1$SvipUpgrade;", "initCountryMsg", "LuserProxy/UserProxy1$GlobalCountryMgrBanner;", "initPK", "LuserProxy/UserProxy1$GroupPkWinBanner;", "changeSvip", "Lcom/qiahao/base_common/model/svip/SvipData;", "LuserProxy/UserProxy$Svip;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nGiftBannerData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GiftBannerData.kt\ncom/qiahao/nextvideo/data/model/GiftBannerData$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,181:1\n1869#2,2:182\n*S KotlinDebug\n*F\n+ 1 GiftBannerData.kt\ncom/qiahao/nextvideo/data/model/GiftBannerData$Companion\n*L\n151#1:182,2\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final SvipData changeSvip(@Nullable UserProxy.Svip data) {
            if (data == null) {
                return null;
            }
            SvipData svipData = new SvipData((int) data.getSvipLevel(), new ArrayList(), (String) null, 4, (DefaultConstructorMarker) null);
            List<UserProxy.SvipPrivilege> privilegesList = data.getPrivilegesList();
            Intrinsics.checkNotNullExpressionValue(privilegesList, "getPrivilegesList(...)");
            for (UserProxy.SvipPrivilege svipPrivilege : privilegesList) {
                ArrayList privileges = svipData.getPrivileges();
                if (privileges != null) {
                    privileges.add(new Privilege(svipPrivilege.getType(), svipPrivilege.getCanSwitch(), svipPrivilege.getUserSwitch(), svipPrivilege.getMysteryCode()));
                }
            }
            return svipData;
        }

        @NotNull
        public final GiftBannerData initCountryMsg(@NotNull UserProxy1.GlobalCountryMgrBanner data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new GiftBannerData(null, 0L, 0, null, null, null, 0, null, null, null, null, null, 0, null, null, null, 102, null, null, data, 0, null, 3604479, null);
        }

        @NotNull
        public final GiftBannerData initCpUpgrades(@NotNull UserProxy1.CpUpgrade data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new GiftBannerData(null, 0L, 0, null, null, null, 0, null, null, null, null, null, 0, null, null, null, 100, null, null, data, 0, null, 3604479, null);
        }

        @NotNull
        public final GiftBannerData initGiftBeanData(@NotNull UserProxy.GlobalGiftBanner globalGiftbanner) {
            Intrinsics.checkNotNullParameter(globalGiftbanner, "globalGiftbanner");
            int bannerLevel = globalGiftbanner.getBannerLevel();
            long giftId = globalGiftbanner.getGiftId();
            int giftNum = globalGiftbanner.getGiftNum();
            String sendUserId = globalGiftbanner.getSendUserId();
            String receiveUserId = globalGiftbanner.getReceiveUserId();
            String groupId = globalGiftbanner.getGroupId();
            Intrinsics.checkNotNullExpressionValue(groupId, "getGroupId(...)");
            String sendUserAvatar = globalGiftbanner.getSendUserAvatar();
            String sendUserNick = globalGiftbanner.getSendUserNick();
            String sendUserCode = globalGiftbanner.getSendUserCode();
            String receiveUserNick = globalGiftbanner.getReceiveUserNick();
            String giftPicUrl = globalGiftbanner.getGiftPicUrl();
            SvipData changeSvip = changeSvip(globalGiftbanner.getSvip());
            SvipData changeSvip2 = changeSvip(globalGiftbanner.getReceiveSvip());
            int bannerType = globalGiftbanner.getBannerType();
            int cpLevel = globalGiftbanner.getCpLevel();
            return new GiftBannerData(Integer.valueOf(bannerLevel), giftId, giftNum, sendUserId, receiveUserId, groupId, 0, null, sendUserAvatar, sendUserNick, receiveUserNick, sendUserCode, 1, giftPicUrl, changeSvip, changeSvip2, Integer.valueOf(bannerType), Integer.valueOf(cpLevel), globalGiftbanner.getReceiveUserAvatar(), null, globalGiftbanner.getNobleLevel(), globalGiftbanner.getCustomEffectUrl(), 524480, null);
        }

        @NotNull
        public final GiftBannerData initLuckyWheelBeanData(@NotNull UserProxy.LuckyWheelBanner luckyWheelBanner) {
            Intrinsics.checkNotNullParameter(luckyWheelBanner, "luckyWheelBanner");
            String sendUserId = luckyWheelBanner.getSendUserId();
            String groupId = luckyWheelBanner.getGroupId();
            Intrinsics.checkNotNullExpressionValue(groupId, "getGroupId(...)");
            return new GiftBannerData(1, 0L, 0, sendUserId, "", groupId, luckyWheelBanner.getDiamondNum(), null, luckyWheelBanner.getAvatar(), luckyWheelBanner.getNick(), null, luckyWheelBanner.getCode(), 2, null, null, null, 0, null, null, null, 0, null, 4121732, null);
        }

        @NotNull
        public final GiftBannerData initPK(@NotNull UserProxy1.GroupPkWinBanner data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new GiftBannerData(null, 0L, 0, null, null, null, 0, null, null, null, null, null, 0, null, null, null, 103, null, null, data, 0, null, 3604479, null);
        }

        @NotNull
        public final GiftBannerData initRocketBeanData(@NotNull UserProxy.GlobalRocketNotice globalRocketNotice) {
            Intrinsics.checkNotNullParameter(globalRocketNotice, "globalRocketNotice");
            int stage = globalRocketNotice.getStage() + 1;
            String topUserIcon = globalRocketNotice.getTopUserIcon();
            String groupId = globalRocketNotice.getGroupId();
            Intrinsics.checkNotNullExpressionValue(groupId, "getGroupId(...)");
            return new GiftBannerData(Integer.valueOf(stage), 0L, 0, null, "", groupId, 0, topUserIcon, globalRocketNotice.getAvatar(), globalRocketNotice.getNick(), null, globalRocketNotice.getCode(), 3, null, null, null, 0, null, null, null, 0, null, 4121676, null);
        }

        @NotNull
        public final GiftBannerData initSVIPUpgrades(@NotNull UserProxy1.SvipUpgrade data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new GiftBannerData(null, 0L, 0, null, null, null, 0, null, null, null, null, null, 0, null, null, null, 101, null, null, data, 0, null, 3604479, null);
        }

        private Companion() {
        }
    }

    public GiftBannerData() {
        this(null, 0L, 0, null, null, null, 0, null, null, null, null, null, 0, null, null, null, null, null, null, null, 0, null, 4194303, null);
    }

    public final boolean checkSupportType() {
        Integer num = this.bannerType;
        if (num != null && num.intValue() == 0) {
            return true;
        }
        Integer num2 = this.bannerType;
        if (num2 != null && num2.intValue() == 1) {
            return true;
        }
        Integer num3 = this.bannerType;
        if (num3 != null && num3.intValue() == 2) {
            return true;
        }
        Integer num4 = this.bannerType;
        if (num4 != null && num4.intValue() == 100) {
            return true;
        }
        Integer num5 = this.bannerType;
        if (num5 != null && num5.intValue() == 101) {
            return true;
        }
        Integer num6 = this.bannerType;
        if (num6 != null && num6.intValue() == 102) {
            return true;
        }
        Integer num7 = this.bannerType;
        if (num7 != null && num7.intValue() == 103) {
            return true;
        }
        Integer num8 = this.bannerType;
        if (num8 != null && num8.intValue() == 3) {
            return true;
        }
        Integer num9 = this.bannerType;
        if (num9 != null && num9.intValue() == 4) {
            return true;
        }
        Integer num10 = this.bannerType;
        if (num10 != null && num10.intValue() == 5) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Integer getBannerLevel() {
        return this.bannerLevel;
    }

    @Nullable
    public final Integer getBannerType() {
        return this.bannerType;
    }

    @Nullable
    public final Integer getCpLevel() {
        return this.cpLevel;
    }

    @Nullable
    public final String getCustomEffectUrl() {
        return this.customEffectUrl;
    }

    public final int getDiamond() {
        return this.diamond;
    }

    public final long getGiftId() {
        return this.giftId;
    }

    public final int getGiftNum() {
        return this.giftNum;
    }

    @Nullable
    public final String getGiftUrl() {
        return this.giftUrl;
    }

    @NotNull
    public final String getGroupId() {
        return this.groupId;
    }

    public final int getNobleLevel() {
        return this.nobleLevel;
    }

    @Nullable
    public final Object getOtherData() {
        return this.otherData;
    }

    @Nullable
    public final SvipData getReceiveSvip() {
        return this.receiveSvip;
    }

    @Nullable
    public final String getReceiveUserAvatar() {
        return this.receiveUserAvatar;
    }

    @Nullable
    public final String getReceiveUserId() {
        return this.receiveUserId;
    }

    @Nullable
    public final String getReceiverUserName() {
        return this.receiverUserName;
    }

    @Nullable
    public final String getRoomRocketAvatar() {
        return this.roomRocketAvatar;
    }

    @Nullable
    public final String getSendAvatar() {
        return this.sendAvatar;
    }

    @Nullable
    public final String getSendCode() {
        return this.sendCode;
    }

    @Nullable
    public final String getSendUserId() {
        return this.sendUserId;
    }

    @Nullable
    public final String getSendUserName() {
        return this.sendUserName;
    }

    @Nullable
    public final SvipData getSvip() {
        return this.svip;
    }

    public final int getType() {
        return this.type;
    }

    public final void setBannerLevel(@Nullable Integer num) {
        this.bannerLevel = num;
    }

    public final void setBannerType(@Nullable Integer num) {
        this.bannerType = num;
    }

    public final void setCpLevel(@Nullable Integer num) {
        this.cpLevel = num;
    }

    public final void setCustomEffectUrl(@Nullable String str) {
        this.customEffectUrl = str;
    }

    public final void setDiamond(int i) {
        this.diamond = i;
    }

    public final void setGiftId(long j) {
        this.giftId = j;
    }

    public final void setGiftNum(int i) {
        this.giftNum = i;
    }

    public final void setGiftUrl(@Nullable String str) {
        this.giftUrl = str;
    }

    public final void setGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupId = str;
    }

    public final void setNobleLevel(int i) {
        this.nobleLevel = i;
    }

    public final void setOtherData(@Nullable Object obj) {
        this.otherData = obj;
    }

    public final void setReceiveSvip(@Nullable SvipData svipData) {
        this.receiveSvip = svipData;
    }

    public final void setReceiveUserAvatar(@Nullable String str) {
        this.receiveUserAvatar = str;
    }

    public final void setReceiveUserId(@Nullable String str) {
        this.receiveUserId = str;
    }

    public final void setReceiverUserName(@Nullable String str) {
        this.receiverUserName = str;
    }

    public final void setRoomRocketAvatar(@Nullable String str) {
        this.roomRocketAvatar = str;
    }

    public final void setSendAvatar(@Nullable String str) {
        this.sendAvatar = str;
    }

    public final void setSendCode(@Nullable String str) {
        this.sendCode = str;
    }

    public final void setSendUserId(@Nullable String str) {
        this.sendUserId = str;
    }

    public final void setSendUserName(@Nullable String str) {
        this.sendUserName = str;
    }

    public final void setSvip(@Nullable SvipData svipData) {
        this.svip = svipData;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public GiftBannerData(@Nullable Integer num, long j, int i, @Nullable String str, @Nullable String str2, @NotNull String str3, int i2, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, int i3, @Nullable String str9, @Nullable SvipData svipData, @Nullable SvipData svipData2, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str10, @Nullable Object obj, int i4, @Nullable String str11) {
        Intrinsics.checkNotNullParameter(str3, "groupId");
        this.bannerLevel = num;
        this.giftId = j;
        this.giftNum = i;
        this.sendUserId = str;
        this.receiveUserId = str2;
        this.groupId = str3;
        this.diamond = i2;
        this.roomRocketAvatar = str4;
        this.sendAvatar = str5;
        this.sendUserName = str6;
        this.receiverUserName = str7;
        this.sendCode = str8;
        this.type = i3;
        this.giftUrl = str9;
        this.svip = svipData;
        this.receiveSvip = svipData2;
        this.bannerType = num2;
        this.cpLevel = num3;
        this.receiveUserAvatar = str10;
        this.otherData = obj;
        this.nobleLevel = i4;
        this.customEffectUrl = str11;
    }

    public /* synthetic */ GiftBannerData(Integer num, long j, int i, String str, String str2, String str3, int i2, String str4, String str5, String str6, String str7, String str8, int i3, String str9, SvipData svipData, SvipData svipData2, Integer num2, Integer num3, String str10, Object obj, int i4, String str11, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : num, (i5 & 2) != 0 ? 0L : j, (i5 & 4) != 0 ? 0 : i, (i5 & 8) != 0 ? "" : str, (i5 & 16) != 0 ? "" : str2, (i5 & 32) != 0 ? "" : str3, (i5 & 64) != 0 ? 0 : i2, (i5 & 128) != 0 ? "" : str4, (i5 & 256) != 0 ? "" : str5, (i5 & 512) != 0 ? "" : str6, (i5 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? "" : str7, (i5 & 2048) != 0 ? "" : str8, (i5 & 4096) != 0 ? 0 : i3, (i5 & 8192) != 0 ? "" : str9, (i5 & 16384) != 0 ? null : svipData, (i5 & 32768) != 0 ? null : svipData2, (i5 & 65536) != 0 ? null : num2, (i5 & 131072) != 0 ? null : num3, (i5 & 262144) != 0 ? null : str10, (i5 & 524288) != 0 ? null : obj, (i5 & AgoraRtcService.CUSTOM_REMOTE_VIDEO_IDLE) != 0 ? 0 : i4, (i5 & 2097152) == 0 ? str11 : null);
    }
}
