package com.qiahao.nextvideo.data.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bj\b\u0086\b\u0018\u0000 \u0092\u00012\u00020\u00012\u00020\u0002:\u0002\u0092\u0001B¹\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u001f\u001a\u00020\t\u0012\b\b\u0002\u0010 \u001a\u00020\t\u0012\u0006\u0010!\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u001b\u0012\u0006\u0010$\u001a\u00020\t\u0012\b\b\u0002\u0010%\u001a\u00020\t\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001b\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b+\u0010,J\u0006\u0010k\u001a\u00020\u0017J\u000b\u0010l\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010m\u001a\u00020\u0006HÆ\u0003J\t\u0010n\u001a\u00020\u0006HÆ\u0003J\t\u0010o\u001a\u00020\tHÆ\u0003J\t\u0010p\u001a\u00020\tHÆ\u0003J\t\u0010q\u001a\u00020\u0006HÆ\u0003J\t\u0010r\u001a\u00020\u0006HÆ\u0003J\t\u0010s\u001a\u00020\u0006HÆ\u0003J\t\u0010t\u001a\u00020\tHÆ\u0003J\t\u0010u\u001a\u00020\tHÆ\u0003J\t\u0010v\u001a\u00020\tHÆ\u0003J\t\u0010w\u001a\u00020\u0006HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010y\u001a\u00020\tHÆ\u0003J\t\u0010z\u001a\u00020\u0006HÆ\u0003J\t\u0010{\u001a\u00020\u0006HÆ\u0003J\t\u0010|\u001a\u00020\u0017HÆ\u0003J\t\u0010}\u001a\u00020\tHÆ\u0003J\t\u0010~\u001a\u00020\tHÆ\u0003J\u000f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bHÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\tHÆ\u0003J\u0011\u0010\u0081\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010RJ\n\u0010\u0082\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0006HÆ\u0003J\u0012\u0010\u0085\u0001\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u001bHÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\tHÆ\u0003J\u0012\u0010\u0088\u0001\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001bHÆ\u0003J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010)HÆ\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jò\u0002\u0010\u008c\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\t2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u001f\u001a\u00020\t2\b\b\u0002\u0010 \u001a\u00020\t2\b\b\u0002\u0010!\u001a\u00020\u00062\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u001b2\b\b\u0002\u0010$\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\t2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0003\u0010\u008d\u0001J\u0015\u0010\u008e\u0001\u001a\u00020\u00172\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0004HÖ\u0003J\n\u0010\u0090\u0001\u001a\u00020\tHÖ\u0001J\n\u0010\u0091\u0001\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b5\u00100R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u00100R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b7\u00100R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b8\u00103R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b9\u00103R\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b:\u00103R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b;\u00100R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00100\"\u0004\b=\u0010>R\u0011\u0010\u0013\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b?\u00103R\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b@\u00100R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bA\u00100R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010\u0018\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00103\"\u0004\bG\u0010HR\u001a\u0010\u0019\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00103\"\u0004\bJ\u0010HR \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010\u001d\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u00103\"\u0004\bP\u0010HR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010U\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010\u001f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00103\"\u0004\bW\u0010HR\u001a\u0010 \u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00103\"\u0004\bY\u0010HR\u001a\u0010!\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u00100\"\u0004\b[\u0010>R\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010L\"\u0004\b]\u0010NR\u0014\u0010$\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u00103R\u001a\u0010%\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u00103\"\u0004\b`\u0010HR\"\u0010&\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010L\"\u0004\bb\u0010NR\u001c\u0010'\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u00100\"\u0004\bd\u0010>R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001c\u0010*\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u00100\"\u0004\bj\u0010>¨\u0006\u0093\u0001"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MultiHotGroupBean;", "Ljava/io/Serializable;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "MemberList", "", Constants.KEY_HTTP_CODE, "", "countryIcon", "createTime", "", "entryLevel", TUIConstants.TUIChat.FACE_URL, "groupId", "introduction", "lastMsgTime", "maxMemberNum", "memberNum", "name", "password", "nextMsgSeq", "notification", "ownerAccount", "hasOnMic", "", "groupInUserDuration", "supportLevel", "micUsers", "", "Lcom/qiahao/nextvideo/data/model/MicUsers;", "roomUserCount", "maxStage", "groupPowerId", "cornerMark", "groupPowerName", "groupMedals", "Lcom/qiahao/nextvideo/data/model/GroupMedalDetailBean;", "itemType", "matchNumber", "gameTypes", "gameTypeIcon", "groupPower", "Lcom/qiahao/base_common/model/common/FamilyInfo;", "groupHeadwear", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZIILjava/util/List;ILjava/lang/Integer;IILjava/lang/String;Ljava/util/List;IILjava/util/List;Ljava/lang/String;Lcom/qiahao/base_common/model/common/FamilyInfo;Ljava/lang/String;)V", "getMemberList", "()Ljava/lang/Object;", "getCode", "()Ljava/lang/String;", "getCountryIcon", "getCreateTime", "()I", "getEntryLevel", "getFaceUrl", "getGroupId", "getIntroduction", "getLastMsgTime", "getMaxMemberNum", "getMemberNum", "getName", "getPassword", "setPassword", "(Ljava/lang/String;)V", "getNextMsgSeq", "getNotification", "getOwnerAccount", "getHasOnMic", "()Z", "setHasOnMic", "(Z)V", "getGroupInUserDuration", "setGroupInUserDuration", "(I)V", "getSupportLevel", "setSupportLevel", "getMicUsers", "()Ljava/util/List;", "setMicUsers", "(Ljava/util/List;)V", "getRoomUserCount", "setRoomUserCount", "getMaxStage", "()Ljava/lang/Integer;", "setMaxStage", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getGroupPowerId", "setGroupPowerId", "getCornerMark", "setCornerMark", "getGroupPowerName", "setGroupPowerName", "getGroupMedals", "setGroupMedals", "getItemType", "getMatchNumber", "setMatchNumber", "getGameTypes", "setGameTypes", "getGameTypeIcon", "setGameTypeIcon", "getGroupPower", "()Lcom/qiahao/base_common/model/common/FamilyInfo;", "setGroupPower", "(Lcom/qiahao/base_common/model/common/FamilyInfo;)V", "getGroupHeadwear", "setGroupHeadwear", "getHasPassWord", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "copy", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZIILjava/util/List;ILjava/lang/Integer;IILjava/lang/String;Ljava/util/List;IILjava/util/List;Ljava/lang/String;Lcom/qiahao/base_common/model/common/FamilyInfo;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/model/MultiHotGroupBean;", "equals", "other", "hashCode", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MultiHotGroupBean implements Serializable, MultiItemEntity {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final Object MemberList;

    @NotNull
    private final String code;
    private int cornerMark;

    @NotNull
    private final String countryIcon;
    private final int createTime;
    private final int entryLevel;

    @NotNull
    private final String faceUrl;

    @Nullable
    private String gameTypeIcon;

    @Nullable
    private List<Integer> gameTypes;

    @Nullable
    private String groupHeadwear;

    @NotNull
    private final String groupId;
    private int groupInUserDuration;

    @Nullable
    private List<GroupMedalDetailBean> groupMedals;

    @Nullable
    private FamilyInfo groupPower;
    private int groupPowerId;

    @NotNull
    private String groupPowerName;
    private boolean hasOnMic;

    @NotNull
    private final String introduction;
    private final int itemType;
    private final int lastMsgTime;
    private int matchNumber;
    private final int maxMemberNum;

    @Nullable
    private Integer maxStage;
    private final int memberNum;

    @NotNull
    private List<MicUsers> micUsers;

    @NotNull
    private final String name;
    private final int nextMsgSeq;

    @NotNull
    private final String notification;

    @NotNull
    private final String ownerAccount;

    @Nullable
    private String password;
    private int roomUserCount;
    private int supportLevel;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MultiHotGroupBean$Companion;", "", "<init>", "()V", "newMultiHotGroupBean", "Lcom/qiahao/nextvideo/data/model/MultiHotGroupBean;", "hotGroupBean", "Lcom/qiahao/nextvideo/data/model/HotGroupBean;", "matchTime", "", "itemType", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ MultiHotGroupBean newMultiHotGroupBean$default(Companion companion, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            return companion.newMultiHotGroupBean(i, i2);
        }

        @NotNull
        public final MultiHotGroupBean newMultiHotGroupBean(@NotNull HotGroupBean hotGroupBean) {
            Intrinsics.checkNotNullParameter(hotGroupBean, "hotGroupBean");
            Object memberList = hotGroupBean.getMemberList();
            String code = hotGroupBean.getCode();
            String countryIcon = hotGroupBean.getCountryIcon();
            int createTime = hotGroupBean.getCreateTime();
            int entryLevel = hotGroupBean.getEntryLevel();
            String faceUrl = hotGroupBean.getFaceUrl();
            String groupId = hotGroupBean.getGroupId();
            String introduction = hotGroupBean.getIntroduction();
            int lastMsgTime = hotGroupBean.getLastMsgTime();
            int maxMemberNum = hotGroupBean.getMaxMemberNum();
            int memberNum = hotGroupBean.getMemberNum();
            String name = hotGroupBean.getName();
            int nextMsgSeq = hotGroupBean.getNextMsgSeq();
            String notification = hotGroupBean.getNotification();
            String ownerAccount = hotGroupBean.getOwnerAccount();
            boolean hasOnMic = hotGroupBean.getHasOnMic();
            int groupInUserDuration = hotGroupBean.getGroupInUserDuration();
            int supportLevel = hotGroupBean.getSupportLevel();
            List<MicUsers> micUsers = hotGroupBean.getMicUsers();
            int roomUserCount = hotGroupBean.getRoomUserCount();
            Integer maxStage = hotGroupBean.getMaxStage();
            Integer groupPowerId = hotGroupBean.getGroupPowerId();
            int intValue = groupPowerId != null ? groupPowerId.intValue() : 0;
            String groupPowerName = hotGroupBean.getGroupPowerName();
            if (groupPowerName == null) {
                groupPowerName = "";
            }
            List<GroupMedalDetailBean> groupMedals = hotGroupBean.getGroupMedals();
            return new MultiHotGroupBean(memberList, code, countryIcon, createTime, entryLevel, faceUrl, groupId, introduction, lastMsgTime, maxMemberNum, memberNum, name, hotGroupBean.getPassword(), nextMsgSeq, notification, ownerAccount, hasOnMic, groupInUserDuration, supportLevel, micUsers, roomUserCount, maxStage, intValue, hotGroupBean.getCornerMark(), groupPowerName, groupMedals, 1, 0, hotGroupBean.getGameTypes(), hotGroupBean.getGameTypeIcon(), hotGroupBean.getGroupPower(), hotGroupBean.getGroupHeadwear());
        }

        private Companion() {
        }

        @NotNull
        public final MultiHotGroupBean newMultiHotGroupBean(int matchTime, int itemType) {
            return new MultiHotGroupBean("", MessageService.MSG_DB_READY_REPORT, MessageService.MSG_DB_READY_REPORT, 0, 0, "", "", "", 0, 0, 0, "", null, 0, "", "", false, 0, 0, new ArrayList(), 0, 0, 0, 0, "", null, itemType, matchTime, null, null, null, null, -260046848, null);
        }
    }

    public MultiHotGroupBean(@Nullable Object obj, @NotNull String str, @NotNull String str2, int i, int i2, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i3, int i4, int i5, @NotNull String str6, @Nullable String str7, int i6, @NotNull String str8, @NotNull String str9, boolean z, int i7, int i8, @NotNull List<MicUsers> list, int i9, @Nullable Integer num, int i10, int i11, @NotNull String str10, @Nullable List<GroupMedalDetailBean> list2, int i12, int i13, @Nullable List<Integer> list3, @Nullable String str11, @Nullable FamilyInfo familyInfo, @Nullable String str12) {
        Intrinsics.checkNotNullParameter(str, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str2, "countryIcon");
        Intrinsics.checkNotNullParameter(str3, TUIConstants.TUIChat.FACE_URL);
        Intrinsics.checkNotNullParameter(str4, "groupId");
        Intrinsics.checkNotNullParameter(str5, "introduction");
        Intrinsics.checkNotNullParameter(str6, "name");
        Intrinsics.checkNotNullParameter(str8, "notification");
        Intrinsics.checkNotNullParameter(str9, "ownerAccount");
        Intrinsics.checkNotNullParameter(list, "micUsers");
        Intrinsics.checkNotNullParameter(str10, "groupPowerName");
        this.MemberList = obj;
        this.code = str;
        this.countryIcon = str2;
        this.createTime = i;
        this.entryLevel = i2;
        this.faceUrl = str3;
        this.groupId = str4;
        this.introduction = str5;
        this.lastMsgTime = i3;
        this.maxMemberNum = i4;
        this.memberNum = i5;
        this.name = str6;
        this.password = str7;
        this.nextMsgSeq = i6;
        this.notification = str8;
        this.ownerAccount = str9;
        this.hasOnMic = z;
        this.groupInUserDuration = i7;
        this.supportLevel = i8;
        this.micUsers = list;
        this.roomUserCount = i9;
        this.maxStage = num;
        this.groupPowerId = i10;
        this.cornerMark = i11;
        this.groupPowerName = str10;
        this.groupMedals = list2;
        this.itemType = i12;
        this.matchNumber = i13;
        this.gameTypes = list3;
        this.gameTypeIcon = str11;
        this.groupPower = familyInfo;
        this.groupHeadwear = str12;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Object getMemberList() {
        return this.MemberList;
    }

    /* renamed from: component10, reason: from getter */
    public final int getMaxMemberNum() {
        return this.maxMemberNum;
    }

    /* renamed from: component11, reason: from getter */
    public final int getMemberNum() {
        return this.memberNum;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final String getPassword() {
        return this.password;
    }

    /* renamed from: component14, reason: from getter */
    public final int getNextMsgSeq() {
        return this.nextMsgSeq;
    }

    @NotNull
    /* renamed from: component15, reason: from getter */
    public final String getNotification() {
        return this.notification;
    }

    @NotNull
    /* renamed from: component16, reason: from getter */
    public final String getOwnerAccount() {
        return this.ownerAccount;
    }

    /* renamed from: component17, reason: from getter */
    public final boolean getHasOnMic() {
        return this.hasOnMic;
    }

    /* renamed from: component18, reason: from getter */
    public final int getGroupInUserDuration() {
        return this.groupInUserDuration;
    }

    /* renamed from: component19, reason: from getter */
    public final int getSupportLevel() {
        return this.supportLevel;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final List<MicUsers> component20() {
        return this.micUsers;
    }

    /* renamed from: component21, reason: from getter */
    public final int getRoomUserCount() {
        return this.roomUserCount;
    }

    @Nullable
    /* renamed from: component22, reason: from getter */
    public final Integer getMaxStage() {
        return this.maxStage;
    }

    /* renamed from: component23, reason: from getter */
    public final int getGroupPowerId() {
        return this.groupPowerId;
    }

    /* renamed from: component24, reason: from getter */
    public final int getCornerMark() {
        return this.cornerMark;
    }

    @NotNull
    /* renamed from: component25, reason: from getter */
    public final String getGroupPowerName() {
        return this.groupPowerName;
    }

    @Nullable
    public final List<GroupMedalDetailBean> component26() {
        return this.groupMedals;
    }

    /* renamed from: component27, reason: from getter */
    public final int getItemType() {
        return this.itemType;
    }

    /* renamed from: component28, reason: from getter */
    public final int getMatchNumber() {
        return this.matchNumber;
    }

    @Nullable
    public final List<Integer> component29() {
        return this.gameTypes;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    @Nullable
    /* renamed from: component30, reason: from getter */
    public final String getGameTypeIcon() {
        return this.gameTypeIcon;
    }

    @Nullable
    /* renamed from: component31, reason: from getter */
    public final FamilyInfo getGroupPower() {
        return this.groupPower;
    }

    @Nullable
    /* renamed from: component32, reason: from getter */
    public final String getGroupHeadwear() {
        return this.groupHeadwear;
    }

    /* renamed from: component4, reason: from getter */
    public final int getCreateTime() {
        return this.createTime;
    }

    /* renamed from: component5, reason: from getter */
    public final int getEntryLevel() {
        return this.entryLevel;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getIntroduction() {
        return this.introduction;
    }

    /* renamed from: component9, reason: from getter */
    public final int getLastMsgTime() {
        return this.lastMsgTime;
    }

    @NotNull
    public final MultiHotGroupBean copy(@Nullable Object MemberList, @NotNull String code, @NotNull String countryIcon, int createTime, int entryLevel, @NotNull String faceUrl, @NotNull String groupId, @NotNull String introduction, int lastMsgTime, int maxMemberNum, int memberNum, @NotNull String name, @Nullable String password, int nextMsgSeq, @NotNull String notification, @NotNull String ownerAccount, boolean hasOnMic, int groupInUserDuration, int supportLevel, @NotNull List<MicUsers> micUsers, int roomUserCount, @Nullable Integer maxStage, int groupPowerId, int cornerMark, @NotNull String groupPowerName, @Nullable List<GroupMedalDetailBean> groupMedals, int itemType, int matchNumber, @Nullable List<Integer> gameTypes, @Nullable String gameTypeIcon, @Nullable FamilyInfo groupPower, @Nullable String groupHeadwear) {
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(countryIcon, "countryIcon");
        Intrinsics.checkNotNullParameter(faceUrl, TUIConstants.TUIChat.FACE_URL);
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(introduction, "introduction");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(notification, "notification");
        Intrinsics.checkNotNullParameter(ownerAccount, "ownerAccount");
        Intrinsics.checkNotNullParameter(micUsers, "micUsers");
        Intrinsics.checkNotNullParameter(groupPowerName, "groupPowerName");
        return new MultiHotGroupBean(MemberList, code, countryIcon, createTime, entryLevel, faceUrl, groupId, introduction, lastMsgTime, maxMemberNum, memberNum, name, password, nextMsgSeq, notification, ownerAccount, hasOnMic, groupInUserDuration, supportLevel, micUsers, roomUserCount, maxStage, groupPowerId, cornerMark, groupPowerName, groupMedals, itemType, matchNumber, gameTypes, gameTypeIcon, groupPower, groupHeadwear);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiHotGroupBean)) {
            return false;
        }
        MultiHotGroupBean multiHotGroupBean = (MultiHotGroupBean) other;
        return Intrinsics.areEqual(this.MemberList, multiHotGroupBean.MemberList) && Intrinsics.areEqual(this.code, multiHotGroupBean.code) && Intrinsics.areEqual(this.countryIcon, multiHotGroupBean.countryIcon) && this.createTime == multiHotGroupBean.createTime && this.entryLevel == multiHotGroupBean.entryLevel && Intrinsics.areEqual(this.faceUrl, multiHotGroupBean.faceUrl) && Intrinsics.areEqual(this.groupId, multiHotGroupBean.groupId) && Intrinsics.areEqual(this.introduction, multiHotGroupBean.introduction) && this.lastMsgTime == multiHotGroupBean.lastMsgTime && this.maxMemberNum == multiHotGroupBean.maxMemberNum && this.memberNum == multiHotGroupBean.memberNum && Intrinsics.areEqual(this.name, multiHotGroupBean.name) && Intrinsics.areEqual(this.password, multiHotGroupBean.password) && this.nextMsgSeq == multiHotGroupBean.nextMsgSeq && Intrinsics.areEqual(this.notification, multiHotGroupBean.notification) && Intrinsics.areEqual(this.ownerAccount, multiHotGroupBean.ownerAccount) && this.hasOnMic == multiHotGroupBean.hasOnMic && this.groupInUserDuration == multiHotGroupBean.groupInUserDuration && this.supportLevel == multiHotGroupBean.supportLevel && Intrinsics.areEqual(this.micUsers, multiHotGroupBean.micUsers) && this.roomUserCount == multiHotGroupBean.roomUserCount && Intrinsics.areEqual(this.maxStage, multiHotGroupBean.maxStage) && this.groupPowerId == multiHotGroupBean.groupPowerId && this.cornerMark == multiHotGroupBean.cornerMark && Intrinsics.areEqual(this.groupPowerName, multiHotGroupBean.groupPowerName) && Intrinsics.areEqual(this.groupMedals, multiHotGroupBean.groupMedals) && this.itemType == multiHotGroupBean.itemType && this.matchNumber == multiHotGroupBean.matchNumber && Intrinsics.areEqual(this.gameTypes, multiHotGroupBean.gameTypes) && Intrinsics.areEqual(this.gameTypeIcon, multiHotGroupBean.gameTypeIcon) && Intrinsics.areEqual(this.groupPower, multiHotGroupBean.groupPower) && Intrinsics.areEqual(this.groupHeadwear, multiHotGroupBean.groupHeadwear);
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    public final int getCornerMark() {
        return this.cornerMark;
    }

    @NotNull
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    public final int getCreateTime() {
        return this.createTime;
    }

    public final int getEntryLevel() {
        return this.entryLevel;
    }

    @NotNull
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    @Nullable
    public final String getGameTypeIcon() {
        return this.gameTypeIcon;
    }

    @Nullable
    public final List<Integer> getGameTypes() {
        return this.gameTypes;
    }

    @Nullable
    public final String getGroupHeadwear() {
        return this.groupHeadwear;
    }

    @NotNull
    public final String getGroupId() {
        return this.groupId;
    }

    public final int getGroupInUserDuration() {
        return this.groupInUserDuration;
    }

    @Nullable
    public final List<GroupMedalDetailBean> getGroupMedals() {
        return this.groupMedals;
    }

    @Nullable
    public final FamilyInfo getGroupPower() {
        return this.groupPower;
    }

    public final int getGroupPowerId() {
        return this.groupPowerId;
    }

    @NotNull
    public final String getGroupPowerName() {
        return this.groupPowerName;
    }

    public final boolean getHasOnMic() {
        return this.hasOnMic;
    }

    public final boolean getHasPassWord() {
        if (this.password != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getIntroduction() {
        return this.introduction;
    }

    public int getItemType() {
        return this.itemType;
    }

    public final int getLastMsgTime() {
        return this.lastMsgTime;
    }

    public final int getMatchNumber() {
        return this.matchNumber;
    }

    public final int getMaxMemberNum() {
        return this.maxMemberNum;
    }

    @Nullable
    public final Integer getMaxStage() {
        return this.maxStage;
    }

    @Nullable
    public final Object getMemberList() {
        return this.MemberList;
    }

    public final int getMemberNum() {
        return this.memberNum;
    }

    @NotNull
    public final List<MicUsers> getMicUsers() {
        return this.micUsers;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getNextMsgSeq() {
        return this.nextMsgSeq;
    }

    @NotNull
    public final String getNotification() {
        return this.notification;
    }

    @NotNull
    public final String getOwnerAccount() {
        return this.ownerAccount;
    }

    @Nullable
    public final String getPassword() {
        return this.password;
    }

    public final int getRoomUserCount() {
        return this.roomUserCount;
    }

    public final int getSupportLevel() {
        return this.supportLevel;
    }

    public int hashCode() {
        Object obj = this.MemberList;
        int hashCode = (((((((((((((((((((((((obj == null ? 0 : obj.hashCode()) * 31) + this.code.hashCode()) * 31) + this.countryIcon.hashCode()) * 31) + this.createTime) * 31) + this.entryLevel) * 31) + this.faceUrl.hashCode()) * 31) + this.groupId.hashCode()) * 31) + this.introduction.hashCode()) * 31) + this.lastMsgTime) * 31) + this.maxMemberNum) * 31) + this.memberNum) * 31) + this.name.hashCode()) * 31;
        String str = this.password;
        int hashCode2 = (((((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.nextMsgSeq) * 31) + this.notification.hashCode()) * 31) + this.ownerAccount.hashCode()) * 31) + a.a(this.hasOnMic)) * 31) + this.groupInUserDuration) * 31) + this.supportLevel) * 31) + this.micUsers.hashCode()) * 31) + this.roomUserCount) * 31;
        Integer num = this.maxStage;
        int hashCode3 = (((((((hashCode2 + (num == null ? 0 : num.hashCode())) * 31) + this.groupPowerId) * 31) + this.cornerMark) * 31) + this.groupPowerName.hashCode()) * 31;
        List<GroupMedalDetailBean> list = this.groupMedals;
        int hashCode4 = (((((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.itemType) * 31) + this.matchNumber) * 31;
        List<Integer> list2 = this.gameTypes;
        int hashCode5 = (hashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str2 = this.gameTypeIcon;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        FamilyInfo familyInfo = this.groupPower;
        int hashCode7 = (hashCode6 + (familyInfo == null ? 0 : familyInfo.hashCode())) * 31;
        String str3 = this.groupHeadwear;
        return hashCode7 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setCornerMark(int i) {
        this.cornerMark = i;
    }

    public final void setGameTypeIcon(@Nullable String str) {
        this.gameTypeIcon = str;
    }

    public final void setGameTypes(@Nullable List<Integer> list) {
        this.gameTypes = list;
    }

    public final void setGroupHeadwear(@Nullable String str) {
        this.groupHeadwear = str;
    }

    public final void setGroupInUserDuration(int i) {
        this.groupInUserDuration = i;
    }

    public final void setGroupMedals(@Nullable List<GroupMedalDetailBean> list) {
        this.groupMedals = list;
    }

    public final void setGroupPower(@Nullable FamilyInfo familyInfo) {
        this.groupPower = familyInfo;
    }

    public final void setGroupPowerId(int i) {
        this.groupPowerId = i;
    }

    public final void setGroupPowerName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupPowerName = str;
    }

    public final void setHasOnMic(boolean z) {
        this.hasOnMic = z;
    }

    public final void setMatchNumber(int i) {
        this.matchNumber = i;
    }

    public final void setMaxStage(@Nullable Integer num) {
        this.maxStage = num;
    }

    public final void setMicUsers(@NotNull List<MicUsers> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.micUsers = list;
    }

    public final void setPassword(@Nullable String str) {
        this.password = str;
    }

    public final void setRoomUserCount(int i) {
        this.roomUserCount = i;
    }

    public final void setSupportLevel(int i) {
        this.supportLevel = i;
    }

    @NotNull
    public String toString() {
        return "MultiHotGroupBean(MemberList=" + this.MemberList + ", code=" + this.code + ", countryIcon=" + this.countryIcon + ", createTime=" + this.createTime + ", entryLevel=" + this.entryLevel + ", faceUrl=" + this.faceUrl + ", groupId=" + this.groupId + ", introduction=" + this.introduction + ", lastMsgTime=" + this.lastMsgTime + ", maxMemberNum=" + this.maxMemberNum + ", memberNum=" + this.memberNum + ", name=" + this.name + ", password=" + this.password + ", nextMsgSeq=" + this.nextMsgSeq + ", notification=" + this.notification + ", ownerAccount=" + this.ownerAccount + ", hasOnMic=" + this.hasOnMic + ", groupInUserDuration=" + this.groupInUserDuration + ", supportLevel=" + this.supportLevel + ", micUsers=" + this.micUsers + ", roomUserCount=" + this.roomUserCount + ", maxStage=" + this.maxStage + ", groupPowerId=" + this.groupPowerId + ", cornerMark=" + this.cornerMark + ", groupPowerName=" + this.groupPowerName + ", groupMedals=" + this.groupMedals + ", itemType=" + this.itemType + ", matchNumber=" + this.matchNumber + ", gameTypes=" + this.gameTypes + ", gameTypeIcon=" + this.gameTypeIcon + ", groupPower=" + this.groupPower + ", groupHeadwear=" + this.groupHeadwear + ")";
    }

    public /* synthetic */ MultiHotGroupBean(Object obj, String str, String str2, int i, int i2, String str3, String str4, String str5, int i3, int i4, int i5, String str6, String str7, int i6, String str8, String str9, boolean z, int i7, int i8, List list, int i9, Integer num, int i10, int i11, String str10, List list2, int i12, int i13, List list3, String str11, FamilyInfo familyInfo, String str12, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, str, str2, i, i2, str3, str4, str5, i3, i4, i5, str6, str7, i6, str8, str9, z, i7, i8, list, i9, (i14 & 2097152) != 0 ? -1 : num, i10, (i14 & 8388608) != 0 ? 0 : i11, str10, (i14 & 33554432) != 0 ? null : list2, i12, (i14 & 134217728) != 0 ? 0 : i13, (i14 & 268435456) != 0 ? null : list3, (i14 & 536870912) != 0 ? null : str11, (i14 & 1073741824) != 0 ? null : familyInfo, (i14 & Integer.MIN_VALUE) != 0 ? null : str12);
    }
}
