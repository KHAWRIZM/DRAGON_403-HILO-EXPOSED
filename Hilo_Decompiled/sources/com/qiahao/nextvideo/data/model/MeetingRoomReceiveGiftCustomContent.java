package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import com.qiahao.base_common.model.GroupGiftDetail;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.model.cp.TextStyles;
import com.qiahao.base_common.model.svip.SvipData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bm\b\u0086\b\u0018\u00002\u00020\u0001B½\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010)\u001a\u00020\u0010¢\u0006\u0004\b*\u0010+J\t\u0010q\u001a\u00020\u0003HÆ\u0003J\t\u0010r\u001a\u00020\u0003HÆ\u0003J\t\u0010s\u001a\u00020\u0003HÆ\u0003J\t\u0010t\u001a\u00020\u0007HÆ\u0003J\t\u0010u\u001a\u00020\u0007HÆ\u0003J\t\u0010v\u001a\u00020\u0003HÆ\u0003J\t\u0010w\u001a\u00020\u0003HÆ\u0003J\t\u0010x\u001a\u00020\u0003HÆ\u0003J\t\u0010y\u001a\u00020\rHÆ\u0003J\t\u0010z\u001a\u00020\u0003HÆ\u0003J\t\u0010{\u001a\u00020\u0010HÆ\u0003J\t\u0010|\u001a\u00020\u0007HÆ\u0003J\t\u0010}\u001a\u00020\u0007HÆ\u0003J\t\u0010~\u001a\u00020\rHÆ\u0003J\t\u0010\u007f\u001a\u00020\rHÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0010HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001e\u0010\u0084\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u001cHÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010!HÆ\u0003J\u0011\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010aJ\u0011\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010aJ\u0011\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010aJ\u0012\u0010\u008b\u0001\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&HÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0010HÆ\u0003Jà\u0002\u0010\u008e\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010)\u001a\u00020\u0010HÆ\u0001¢\u0006\u0003\u0010\u008f\u0001J\u0015\u0010\u0090\u0001\u001a\u00020\r2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0010HÖ\u0001J\n\u0010\u0093\u0001\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010-R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b2\u00101R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010-R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010-R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010-R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010-R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00101\"\u0004\b>\u0010?R\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00101\"\u0004\bA\u0010?R\u001a\u0010\u0013\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00107\"\u0004\bC\u0010DR\u001a\u0010\u0014\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u00107\"\u0004\bF\u0010DR\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010:\"\u0004\bH\u0010<R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010J\"\u0004\bN\u0010LR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010-\"\u0004\bP\u0010QR.\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001a\u0010\u001d\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00101\"\u0004\bW\u0010?R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001e\u0010\"\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010d\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001e\u0010#\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010d\u001a\u0004\be\u0010a\"\u0004\bf\u0010cR\u001e\u0010$\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010d\u001a\u0004\bg\u0010a\"\u0004\bh\u0010cR\"\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u001c\u0010(\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010-\"\u0004\bn\u0010QR\u001a\u0010)\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010:\"\u0004\bp\u0010<¨\u0006\u0094\u0001"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MeetingRoomReceiveGiftCustomContent;", "", "receiveUserExternalId", "", "receiveUserAvatar", "receiveUserNick", "resGiftId", "", "resGiftNum", "sendUserExternalId", "sendUserAvatar", "sendUserNick", "giftGroupBroadcast", "", "sourceGroupId", "senderNobleLevel", "", "senderWealthGrade", "senderCharmGrade", "senderIsPrettyCode", "senderIsVip", "senderSvipLevel", "svip", "Lcom/qiahao/base_common/model/svip/SvipData;", "receiveSvip", "senderGroupPowerName", "senderMedalIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "groupConsume", "giftDetail", "Lcom/qiahao/base_common/model/GroupGiftDetail;", "senderPower", "Lcom/qiahao/base_common/model/common/FamilyInfo;", "senderSex", "receiveSex", "giftType", "textStyleList", "", "Lcom/qiahao/base_common/model/cp/TextStyles;", "giftText", "senderCornerMark", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;IJJZZILcom/qiahao/base_common/model/svip/SvipData;Lcom/qiahao/base_common/model/svip/SvipData;Ljava/lang/String;Ljava/util/ArrayList;JLcom/qiahao/base_common/model/GroupGiftDetail;Lcom/qiahao/base_common/model/common/FamilyInfo;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;I)V", "getReceiveUserExternalId", "()Ljava/lang/String;", "getReceiveUserAvatar", "getReceiveUserNick", "getResGiftId", "()J", "getResGiftNum", "getSendUserExternalId", "getSendUserAvatar", "getSendUserNick", "getGiftGroupBroadcast", "()Z", "getSourceGroupId", "getSenderNobleLevel", "()I", "setSenderNobleLevel", "(I)V", "getSenderWealthGrade", "setSenderWealthGrade", "(J)V", "getSenderCharmGrade", "setSenderCharmGrade", "getSenderIsPrettyCode", "setSenderIsPrettyCode", "(Z)V", "getSenderIsVip", "setSenderIsVip", "getSenderSvipLevel", "setSenderSvipLevel", "getSvip", "()Lcom/qiahao/base_common/model/svip/SvipData;", "setSvip", "(Lcom/qiahao/base_common/model/svip/SvipData;)V", "getReceiveSvip", "setReceiveSvip", "getSenderGroupPowerName", "setSenderGroupPowerName", "(Ljava/lang/String;)V", "getSenderMedalIds", "()Ljava/util/ArrayList;", "setSenderMedalIds", "(Ljava/util/ArrayList;)V", "getGroupConsume", "setGroupConsume", "getGiftDetail", "()Lcom/qiahao/base_common/model/GroupGiftDetail;", "setGiftDetail", "(Lcom/qiahao/base_common/model/GroupGiftDetail;)V", "getSenderPower", "()Lcom/qiahao/base_common/model/common/FamilyInfo;", "setSenderPower", "(Lcom/qiahao/base_common/model/common/FamilyInfo;)V", "getSenderSex", "()Ljava/lang/Integer;", "setSenderSex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getReceiveSex", "setReceiveSex", "getGiftType", "setGiftType", "getTextStyleList", "()Ljava/util/List;", "setTextStyleList", "(Ljava/util/List;)V", "getGiftText", "setGiftText", "getSenderCornerMark", "setSenderCornerMark", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;IJJZZILcom/qiahao/base_common/model/svip/SvipData;Lcom/qiahao/base_common/model/svip/SvipData;Ljava/lang/String;Ljava/util/ArrayList;JLcom/qiahao/base_common/model/GroupGiftDetail;Lcom/qiahao/base_common/model/common/FamilyInfo;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;I)Lcom/qiahao/nextvideo/data/model/MeetingRoomReceiveGiftCustomContent;", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MeetingRoomReceiveGiftCustomContent {

    @Nullable
    private GroupGiftDetail giftDetail;
    private final boolean giftGroupBroadcast;

    @Nullable
    private String giftText;

    @Nullable
    private Integer giftType;
    private long groupConsume;

    @Nullable
    private Integer receiveSex;

    @Nullable
    private SvipData receiveSvip;

    @NotNull
    private final String receiveUserAvatar;

    @NotNull
    private final String receiveUserExternalId;

    @NotNull
    private final String receiveUserNick;
    private final long resGiftId;
    private final long resGiftNum;

    @NotNull
    private final String sendUserAvatar;

    @NotNull
    private final String sendUserExternalId;

    @NotNull
    private final String sendUserNick;
    private long senderCharmGrade;
    private int senderCornerMark;

    @Nullable
    private String senderGroupPowerName;
    private boolean senderIsPrettyCode;
    private boolean senderIsVip;

    @Nullable
    private ArrayList<Integer> senderMedalIds;
    private int senderNobleLevel;

    @Nullable
    private FamilyInfo senderPower;

    @Nullable
    private Integer senderSex;
    private int senderSvipLevel;
    private long senderWealthGrade;

    @NotNull
    private final String sourceGroupId;

    @Nullable
    private SvipData svip;

    @Nullable
    private List<TextStyles> textStyleList;

    public MeetingRoomReceiveGiftCustomContent(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, long j2, @NotNull String str4, @NotNull String str5, @NotNull String str6, boolean z, @NotNull String str7, int i, long j3, long j4, boolean z2, boolean z3, int i2, @Nullable SvipData svipData, @Nullable SvipData svipData2, @Nullable String str8, @Nullable ArrayList<Integer> arrayList, long j5, @Nullable GroupGiftDetail groupGiftDetail, @Nullable FamilyInfo familyInfo, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable List<TextStyles> list, @Nullable String str9, int i3) {
        Intrinsics.checkNotNullParameter(str, "receiveUserExternalId");
        Intrinsics.checkNotNullParameter(str2, "receiveUserAvatar");
        Intrinsics.checkNotNullParameter(str3, "receiveUserNick");
        Intrinsics.checkNotNullParameter(str4, "sendUserExternalId");
        Intrinsics.checkNotNullParameter(str5, "sendUserAvatar");
        Intrinsics.checkNotNullParameter(str6, "sendUserNick");
        Intrinsics.checkNotNullParameter(str7, "sourceGroupId");
        this.receiveUserExternalId = str;
        this.receiveUserAvatar = str2;
        this.receiveUserNick = str3;
        this.resGiftId = j;
        this.resGiftNum = j2;
        this.sendUserExternalId = str4;
        this.sendUserAvatar = str5;
        this.sendUserNick = str6;
        this.giftGroupBroadcast = z;
        this.sourceGroupId = str7;
        this.senderNobleLevel = i;
        this.senderWealthGrade = j3;
        this.senderCharmGrade = j4;
        this.senderIsPrettyCode = z2;
        this.senderIsVip = z3;
        this.senderSvipLevel = i2;
        this.svip = svipData;
        this.receiveSvip = svipData2;
        this.senderGroupPowerName = str8;
        this.senderMedalIds = arrayList;
        this.groupConsume = j5;
        this.giftDetail = groupGiftDetail;
        this.senderPower = familyInfo;
        this.senderSex = num;
        this.receiveSex = num2;
        this.giftType = num3;
        this.textStyleList = list;
        this.giftText = str9;
        this.senderCornerMark = i3;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getReceiveUserExternalId() {
        return this.receiveUserExternalId;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getSourceGroupId() {
        return this.sourceGroupId;
    }

    /* renamed from: component11, reason: from getter */
    public final int getSenderNobleLevel() {
        return this.senderNobleLevel;
    }

    /* renamed from: component12, reason: from getter */
    public final long getSenderWealthGrade() {
        return this.senderWealthGrade;
    }

    /* renamed from: component13, reason: from getter */
    public final long getSenderCharmGrade() {
        return this.senderCharmGrade;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getSenderIsPrettyCode() {
        return this.senderIsPrettyCode;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getSenderIsVip() {
        return this.senderIsVip;
    }

    /* renamed from: component16, reason: from getter */
    public final int getSenderSvipLevel() {
        return this.senderSvipLevel;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final SvipData getSvip() {
        return this.svip;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final SvipData getReceiveSvip() {
        return this.receiveSvip;
    }

    @Nullable
    /* renamed from: component19, reason: from getter */
    public final String getSenderGroupPowerName() {
        return this.senderGroupPowerName;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getReceiveUserAvatar() {
        return this.receiveUserAvatar;
    }

    @Nullable
    public final ArrayList<Integer> component20() {
        return this.senderMedalIds;
    }

    /* renamed from: component21, reason: from getter */
    public final long getGroupConsume() {
        return this.groupConsume;
    }

    @Nullable
    /* renamed from: component22, reason: from getter */
    public final GroupGiftDetail getGiftDetail() {
        return this.giftDetail;
    }

    @Nullable
    /* renamed from: component23, reason: from getter */
    public final FamilyInfo getSenderPower() {
        return this.senderPower;
    }

    @Nullable
    /* renamed from: component24, reason: from getter */
    public final Integer getSenderSex() {
        return this.senderSex;
    }

    @Nullable
    /* renamed from: component25, reason: from getter */
    public final Integer getReceiveSex() {
        return this.receiveSex;
    }

    @Nullable
    /* renamed from: component26, reason: from getter */
    public final Integer getGiftType() {
        return this.giftType;
    }

    @Nullable
    public final List<TextStyles> component27() {
        return this.textStyleList;
    }

    @Nullable
    /* renamed from: component28, reason: from getter */
    public final String getGiftText() {
        return this.giftText;
    }

    /* renamed from: component29, reason: from getter */
    public final int getSenderCornerMark() {
        return this.senderCornerMark;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getReceiveUserNick() {
        return this.receiveUserNick;
    }

    /* renamed from: component4, reason: from getter */
    public final long getResGiftId() {
        return this.resGiftId;
    }

    /* renamed from: component5, reason: from getter */
    public final long getResGiftNum() {
        return this.resGiftNum;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getSendUserExternalId() {
        return this.sendUserExternalId;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getSendUserAvatar() {
        return this.sendUserAvatar;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getSendUserNick() {
        return this.sendUserNick;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getGiftGroupBroadcast() {
        return this.giftGroupBroadcast;
    }

    @NotNull
    public final MeetingRoomReceiveGiftCustomContent copy(@NotNull String receiveUserExternalId, @NotNull String receiveUserAvatar, @NotNull String receiveUserNick, long resGiftId, long resGiftNum, @NotNull String sendUserExternalId, @NotNull String sendUserAvatar, @NotNull String sendUserNick, boolean giftGroupBroadcast, @NotNull String sourceGroupId, int senderNobleLevel, long senderWealthGrade, long senderCharmGrade, boolean senderIsPrettyCode, boolean senderIsVip, int senderSvipLevel, @Nullable SvipData svip, @Nullable SvipData receiveSvip, @Nullable String senderGroupPowerName, @Nullable ArrayList<Integer> senderMedalIds, long groupConsume, @Nullable GroupGiftDetail giftDetail, @Nullable FamilyInfo senderPower, @Nullable Integer senderSex, @Nullable Integer receiveSex, @Nullable Integer giftType, @Nullable List<TextStyles> textStyleList, @Nullable String giftText, int senderCornerMark) {
        Intrinsics.checkNotNullParameter(receiveUserExternalId, "receiveUserExternalId");
        Intrinsics.checkNotNullParameter(receiveUserAvatar, "receiveUserAvatar");
        Intrinsics.checkNotNullParameter(receiveUserNick, "receiveUserNick");
        Intrinsics.checkNotNullParameter(sendUserExternalId, "sendUserExternalId");
        Intrinsics.checkNotNullParameter(sendUserAvatar, "sendUserAvatar");
        Intrinsics.checkNotNullParameter(sendUserNick, "sendUserNick");
        Intrinsics.checkNotNullParameter(sourceGroupId, "sourceGroupId");
        return new MeetingRoomReceiveGiftCustomContent(receiveUserExternalId, receiveUserAvatar, receiveUserNick, resGiftId, resGiftNum, sendUserExternalId, sendUserAvatar, sendUserNick, giftGroupBroadcast, sourceGroupId, senderNobleLevel, senderWealthGrade, senderCharmGrade, senderIsPrettyCode, senderIsVip, senderSvipLevel, svip, receiveSvip, senderGroupPowerName, senderMedalIds, groupConsume, giftDetail, senderPower, senderSex, receiveSex, giftType, textStyleList, giftText, senderCornerMark);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MeetingRoomReceiveGiftCustomContent)) {
            return false;
        }
        MeetingRoomReceiveGiftCustomContent meetingRoomReceiveGiftCustomContent = (MeetingRoomReceiveGiftCustomContent) other;
        return Intrinsics.areEqual(this.receiveUserExternalId, meetingRoomReceiveGiftCustomContent.receiveUserExternalId) && Intrinsics.areEqual(this.receiveUserAvatar, meetingRoomReceiveGiftCustomContent.receiveUserAvatar) && Intrinsics.areEqual(this.receiveUserNick, meetingRoomReceiveGiftCustomContent.receiveUserNick) && this.resGiftId == meetingRoomReceiveGiftCustomContent.resGiftId && this.resGiftNum == meetingRoomReceiveGiftCustomContent.resGiftNum && Intrinsics.areEqual(this.sendUserExternalId, meetingRoomReceiveGiftCustomContent.sendUserExternalId) && Intrinsics.areEqual(this.sendUserAvatar, meetingRoomReceiveGiftCustomContent.sendUserAvatar) && Intrinsics.areEqual(this.sendUserNick, meetingRoomReceiveGiftCustomContent.sendUserNick) && this.giftGroupBroadcast == meetingRoomReceiveGiftCustomContent.giftGroupBroadcast && Intrinsics.areEqual(this.sourceGroupId, meetingRoomReceiveGiftCustomContent.sourceGroupId) && this.senderNobleLevel == meetingRoomReceiveGiftCustomContent.senderNobleLevel && this.senderWealthGrade == meetingRoomReceiveGiftCustomContent.senderWealthGrade && this.senderCharmGrade == meetingRoomReceiveGiftCustomContent.senderCharmGrade && this.senderIsPrettyCode == meetingRoomReceiveGiftCustomContent.senderIsPrettyCode && this.senderIsVip == meetingRoomReceiveGiftCustomContent.senderIsVip && this.senderSvipLevel == meetingRoomReceiveGiftCustomContent.senderSvipLevel && Intrinsics.areEqual(this.svip, meetingRoomReceiveGiftCustomContent.svip) && Intrinsics.areEqual(this.receiveSvip, meetingRoomReceiveGiftCustomContent.receiveSvip) && Intrinsics.areEqual(this.senderGroupPowerName, meetingRoomReceiveGiftCustomContent.senderGroupPowerName) && Intrinsics.areEqual(this.senderMedalIds, meetingRoomReceiveGiftCustomContent.senderMedalIds) && this.groupConsume == meetingRoomReceiveGiftCustomContent.groupConsume && Intrinsics.areEqual(this.giftDetail, meetingRoomReceiveGiftCustomContent.giftDetail) && Intrinsics.areEqual(this.senderPower, meetingRoomReceiveGiftCustomContent.senderPower) && Intrinsics.areEqual(this.senderSex, meetingRoomReceiveGiftCustomContent.senderSex) && Intrinsics.areEqual(this.receiveSex, meetingRoomReceiveGiftCustomContent.receiveSex) && Intrinsics.areEqual(this.giftType, meetingRoomReceiveGiftCustomContent.giftType) && Intrinsics.areEqual(this.textStyleList, meetingRoomReceiveGiftCustomContent.textStyleList) && Intrinsics.areEqual(this.giftText, meetingRoomReceiveGiftCustomContent.giftText) && this.senderCornerMark == meetingRoomReceiveGiftCustomContent.senderCornerMark;
    }

    @Nullable
    public final GroupGiftDetail getGiftDetail() {
        return this.giftDetail;
    }

    public final boolean getGiftGroupBroadcast() {
        return this.giftGroupBroadcast;
    }

    @Nullable
    public final String getGiftText() {
        return this.giftText;
    }

    @Nullable
    public final Integer getGiftType() {
        return this.giftType;
    }

    public final long getGroupConsume() {
        return this.groupConsume;
    }

    @Nullable
    public final Integer getReceiveSex() {
        return this.receiveSex;
    }

    @Nullable
    public final SvipData getReceiveSvip() {
        return this.receiveSvip;
    }

    @NotNull
    public final String getReceiveUserAvatar() {
        return this.receiveUserAvatar;
    }

    @NotNull
    public final String getReceiveUserExternalId() {
        return this.receiveUserExternalId;
    }

    @NotNull
    public final String getReceiveUserNick() {
        return this.receiveUserNick;
    }

    public final long getResGiftId() {
        return this.resGiftId;
    }

    public final long getResGiftNum() {
        return this.resGiftNum;
    }

    @NotNull
    public final String getSendUserAvatar() {
        return this.sendUserAvatar;
    }

    @NotNull
    public final String getSendUserExternalId() {
        return this.sendUserExternalId;
    }

    @NotNull
    public final String getSendUserNick() {
        return this.sendUserNick;
    }

    public final long getSenderCharmGrade() {
        return this.senderCharmGrade;
    }

    public final int getSenderCornerMark() {
        return this.senderCornerMark;
    }

    @Nullable
    public final String getSenderGroupPowerName() {
        return this.senderGroupPowerName;
    }

    public final boolean getSenderIsPrettyCode() {
        return this.senderIsPrettyCode;
    }

    public final boolean getSenderIsVip() {
        return this.senderIsVip;
    }

    @Nullable
    public final ArrayList<Integer> getSenderMedalIds() {
        return this.senderMedalIds;
    }

    public final int getSenderNobleLevel() {
        return this.senderNobleLevel;
    }

    @Nullable
    public final FamilyInfo getSenderPower() {
        return this.senderPower;
    }

    @Nullable
    public final Integer getSenderSex() {
        return this.senderSex;
    }

    public final int getSenderSvipLevel() {
        return this.senderSvipLevel;
    }

    public final long getSenderWealthGrade() {
        return this.senderWealthGrade;
    }

    @NotNull
    public final String getSourceGroupId() {
        return this.sourceGroupId;
    }

    @Nullable
    public final SvipData getSvip() {
        return this.svip;
    }

    @Nullable
    public final List<TextStyles> getTextStyleList() {
        return this.textStyleList;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((this.receiveUserExternalId.hashCode() * 31) + this.receiveUserAvatar.hashCode()) * 31) + this.receiveUserNick.hashCode()) * 31) + c.a(this.resGiftId)) * 31) + c.a(this.resGiftNum)) * 31) + this.sendUserExternalId.hashCode()) * 31) + this.sendUserAvatar.hashCode()) * 31) + this.sendUserNick.hashCode()) * 31) + a.a(this.giftGroupBroadcast)) * 31) + this.sourceGroupId.hashCode()) * 31) + this.senderNobleLevel) * 31) + c.a(this.senderWealthGrade)) * 31) + c.a(this.senderCharmGrade)) * 31) + a.a(this.senderIsPrettyCode)) * 31) + a.a(this.senderIsVip)) * 31) + this.senderSvipLevel) * 31;
        SvipData svipData = this.svip;
        int hashCode2 = (hashCode + (svipData == null ? 0 : svipData.hashCode())) * 31;
        SvipData svipData2 = this.receiveSvip;
        int hashCode3 = (hashCode2 + (svipData2 == null ? 0 : svipData2.hashCode())) * 31;
        String str = this.senderGroupPowerName;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        ArrayList<Integer> arrayList = this.senderMedalIds;
        int hashCode5 = (((hashCode4 + (arrayList == null ? 0 : arrayList.hashCode())) * 31) + c.a(this.groupConsume)) * 31;
        GroupGiftDetail groupGiftDetail = this.giftDetail;
        int hashCode6 = (hashCode5 + (groupGiftDetail == null ? 0 : groupGiftDetail.hashCode())) * 31;
        FamilyInfo familyInfo = this.senderPower;
        int hashCode7 = (hashCode6 + (familyInfo == null ? 0 : familyInfo.hashCode())) * 31;
        Integer num = this.senderSex;
        int hashCode8 = (hashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.receiveSex;
        int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.giftType;
        int hashCode10 = (hashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
        List<TextStyles> list = this.textStyleList;
        int hashCode11 = (hashCode10 + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.giftText;
        return ((hashCode11 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.senderCornerMark;
    }

    public final void setGiftDetail(@Nullable GroupGiftDetail groupGiftDetail) {
        this.giftDetail = groupGiftDetail;
    }

    public final void setGiftText(@Nullable String str) {
        this.giftText = str;
    }

    public final void setGiftType(@Nullable Integer num) {
        this.giftType = num;
    }

    public final void setGroupConsume(long j) {
        this.groupConsume = j;
    }

    public final void setReceiveSex(@Nullable Integer num) {
        this.receiveSex = num;
    }

    public final void setReceiveSvip(@Nullable SvipData svipData) {
        this.receiveSvip = svipData;
    }

    public final void setSenderCharmGrade(long j) {
        this.senderCharmGrade = j;
    }

    public final void setSenderCornerMark(int i) {
        this.senderCornerMark = i;
    }

    public final void setSenderGroupPowerName(@Nullable String str) {
        this.senderGroupPowerName = str;
    }

    public final void setSenderIsPrettyCode(boolean z) {
        this.senderIsPrettyCode = z;
    }

    public final void setSenderIsVip(boolean z) {
        this.senderIsVip = z;
    }

    public final void setSenderMedalIds(@Nullable ArrayList<Integer> arrayList) {
        this.senderMedalIds = arrayList;
    }

    public final void setSenderNobleLevel(int i) {
        this.senderNobleLevel = i;
    }

    public final void setSenderPower(@Nullable FamilyInfo familyInfo) {
        this.senderPower = familyInfo;
    }

    public final void setSenderSex(@Nullable Integer num) {
        this.senderSex = num;
    }

    public final void setSenderSvipLevel(int i) {
        this.senderSvipLevel = i;
    }

    public final void setSenderWealthGrade(long j) {
        this.senderWealthGrade = j;
    }

    public final void setSvip(@Nullable SvipData svipData) {
        this.svip = svipData;
    }

    public final void setTextStyleList(@Nullable List<TextStyles> list) {
        this.textStyleList = list;
    }

    @NotNull
    public String toString() {
        return "MeetingRoomReceiveGiftCustomContent(receiveUserExternalId=" + this.receiveUserExternalId + ", receiveUserAvatar=" + this.receiveUserAvatar + ", receiveUserNick=" + this.receiveUserNick + ", resGiftId=" + this.resGiftId + ", resGiftNum=" + this.resGiftNum + ", sendUserExternalId=" + this.sendUserExternalId + ", sendUserAvatar=" + this.sendUserAvatar + ", sendUserNick=" + this.sendUserNick + ", giftGroupBroadcast=" + this.giftGroupBroadcast + ", sourceGroupId=" + this.sourceGroupId + ", senderNobleLevel=" + this.senderNobleLevel + ", senderWealthGrade=" + this.senderWealthGrade + ", senderCharmGrade=" + this.senderCharmGrade + ", senderIsPrettyCode=" + this.senderIsPrettyCode + ", senderIsVip=" + this.senderIsVip + ", senderSvipLevel=" + this.senderSvipLevel + ", svip=" + this.svip + ", receiveSvip=" + this.receiveSvip + ", senderGroupPowerName=" + this.senderGroupPowerName + ", senderMedalIds=" + this.senderMedalIds + ", groupConsume=" + this.groupConsume + ", giftDetail=" + this.giftDetail + ", senderPower=" + this.senderPower + ", senderSex=" + this.senderSex + ", receiveSex=" + this.receiveSex + ", giftType=" + this.giftType + ", textStyleList=" + this.textStyleList + ", giftText=" + this.giftText + ", senderCornerMark=" + this.senderCornerMark + ")";
    }

    public /* synthetic */ MeetingRoomReceiveGiftCustomContent(String str, String str2, String str3, long j, long j2, String str4, String str5, String str6, boolean z, String str7, int i, long j3, long j4, boolean z2, boolean z3, int i2, SvipData svipData, SvipData svipData2, String str8, ArrayList arrayList, long j5, GroupGiftDetail groupGiftDetail, FamilyInfo familyInfo, Integer num, Integer num2, Integer num3, List list, String str9, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, j, j2, str4, str5, str6, z, str7, (i4 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? 0 : i, (i4 & 2048) != 0 ? 0L : j3, (i4 & 4096) != 0 ? 0L : j4, (i4 & 8192) != 0 ? false : z2, (i4 & 16384) != 0 ? false : z3, (32768 & i4) != 0 ? 0 : i2, (65536 & i4) != 0 ? null : svipData, (131072 & i4) != 0 ? null : svipData2, str8, arrayList, j5, (2097152 & i4) != 0 ? null : groupGiftDetail, (4194304 & i4) != 0 ? null : familyInfo, (8388608 & i4) != 0 ? 0 : num, (16777216 & i4) != 0 ? 0 : num2, (33554432 & i4) != 0 ? 0 : num3, (67108864 & i4) != 0 ? null : list, (134217728 & i4) != 0 ? null : str9, (i4 & 268435456) != 0 ? 0 : i3);
    }
}
