package com.qiahao.nextvideo.data.model;

import androidx.annotation.Keep;
import androidx.collection.c;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2Connection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bR\b\u0087\b\u0018\u00002\u00020\u0001Bé\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0010\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\"\u0010#J\u0006\u0010P\u001a\u00020\u0019J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\t\u0010V\u001a\u00020\nHÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\t\u0010X\u001a\u00020\u0005HÆ\u0003J\t\u0010Y\u001a\u00020\u0005HÆ\u0003J\t\u0010Z\u001a\u00020\nHÆ\u0003J\t\u0010[\u001a\u00020\u0010HÆ\u0003J\t\u0010\\\u001a\u00020\u0010HÆ\u0003J\t\u0010]\u001a\u00020\u0010HÆ\u0003J\t\u0010^\u001a\u00020\u0010HÆ\u0003J\t\u0010_\u001a\u00020\u0005HÆ\u0003J\t\u0010`\u001a\u00020\u0010HÆ\u0003J\t\u0010a\u001a\u00020\u0005HÆ\u0003J\t\u0010b\u001a\u00020\u0005HÆ\u0003J\t\u0010c\u001a\u00020\u0019HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dHÆ\u0003J\t\u0010g\u001a\u00020\u0010HÆ\u0003J\u0010\u0010h\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010JJ\u000b\u0010i\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u009c\u0002\u0010j\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u00102\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010kJ\u0013\u0010l\u001a\u00020\u00192\b\u0010m\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010n\u001a\u00020\u0010HÖ\u0001J\t\u0010o\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010'R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010'R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b0\u0010,R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b3\u00102R\u001a\u0010\u0012\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00102\"\u0004\b5\u00106R\u0011\u0010\u0013\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b7\u00102R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010'R\u0011\u0010\u0015\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b9\u00102R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010'R\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010'R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010'\"\u0004\b?\u0010@R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010'\"\u0004\bB\u0010@R\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010\u001f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u00102\"\u0004\bH\u00106R\u001e\u0010 \u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010M\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010!\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010'\"\u0004\bO\u0010@¨\u0006p"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GroupBean;", "", "selfInfo", "Lcom/qiahao/nextvideo/data/model/SelfInfo;", "ownerAvatar", "", "ownerNick", "countryIcon", Constants.KEY_HTTP_CODE, "createTime", "", TUIConstants.TUIChat.FACE_URL, "groupId", "introduction", "lastMsgTime", "maxMemberNum", "", "memberNum", "msgStatus", "myRole", "name", "nextMsgSeq", "notification", "ownerAccount", "hasOnMic", "", "lastMemberUrl", "lastMemberName", "role_members", "", "Lcom/qiahao/nextvideo/data/model/RoleMember;", "supportLevel", "maxStage", "password", "<init>", "(Lcom/qiahao/nextvideo/data/model/SelfInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIIILjava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/Integer;Ljava/lang/String;)V", "getSelfInfo", "()Lcom/qiahao/nextvideo/data/model/SelfInfo;", "getOwnerAvatar", "()Ljava/lang/String;", "getOwnerNick", "getCountryIcon", "getCode", "getCreateTime", "()J", "getFaceUrl", "getGroupId", "getIntroduction", "getLastMsgTime", "getMaxMemberNum", "()I", "getMemberNum", "getMsgStatus", "setMsgStatus", "(I)V", "getMyRole", "getName", "getNextMsgSeq", "getNotification", "getOwnerAccount", "getHasOnMic", "()Z", "getLastMemberUrl", "setLastMemberUrl", "(Ljava/lang/String;)V", "getLastMemberName", "setLastMemberName", "getRole_members", "()Ljava/util/List;", "setRole_members", "(Ljava/util/List;)V", "getSupportLevel", "setSupportLevel", "getMaxStage", "()Ljava/lang/Integer;", "setMaxStage", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPassword", "setPassword", "getHasPassWord", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "(Lcom/qiahao/nextvideo/data/model/SelfInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIIILjava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/Integer;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/model/GroupBean;", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GroupBean {

    @NotNull
    private final String code;

    @NotNull
    private final String countryIcon;
    private final long createTime;

    @NotNull
    private final String faceUrl;

    @NotNull
    private final String groupId;
    private final boolean hasOnMic;

    @NotNull
    private final String introduction;

    @Nullable
    private String lastMemberName;

    @Nullable
    private String lastMemberUrl;
    private final long lastMsgTime;
    private final int maxMemberNum;

    @Nullable
    private Integer maxStage;
    private final int memberNum;
    private int msgStatus;
    private final int myRole;

    @NotNull
    private final String name;
    private final int nextMsgSeq;

    @NotNull
    private final String notification;

    @NotNull
    private final String ownerAccount;

    @Nullable
    private final String ownerAvatar;

    @Nullable
    private final String ownerNick;

    @Nullable
    private String password;

    @Nullable
    private List<RoleMember> role_members;

    @NotNull
    private final SelfInfo selfInfo;
    private int supportLevel;

    public GroupBean(@NotNull SelfInfo selfInfo, @Nullable String str, @Nullable String str2, @NotNull String str3, @NotNull String str4, long j, @NotNull String str5, @NotNull String str6, @NotNull String str7, long j2, int i, int i2, int i3, int i4, @NotNull String str8, int i5, @NotNull String str9, @NotNull String str10, boolean z, @Nullable String str11, @Nullable String str12, @Nullable List<RoleMember> list, int i6, @Nullable Integer num, @Nullable String str13) {
        Intrinsics.checkNotNullParameter(selfInfo, "selfInfo");
        Intrinsics.checkNotNullParameter(str3, "countryIcon");
        Intrinsics.checkNotNullParameter(str4, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str5, TUIConstants.TUIChat.FACE_URL);
        Intrinsics.checkNotNullParameter(str6, "groupId");
        Intrinsics.checkNotNullParameter(str7, "introduction");
        Intrinsics.checkNotNullParameter(str8, "name");
        Intrinsics.checkNotNullParameter(str9, "notification");
        Intrinsics.checkNotNullParameter(str10, "ownerAccount");
        this.selfInfo = selfInfo;
        this.ownerAvatar = str;
        this.ownerNick = str2;
        this.countryIcon = str3;
        this.code = str4;
        this.createTime = j;
        this.faceUrl = str5;
        this.groupId = str6;
        this.introduction = str7;
        this.lastMsgTime = j2;
        this.maxMemberNum = i;
        this.memberNum = i2;
        this.msgStatus = i3;
        this.myRole = i4;
        this.name = str8;
        this.nextMsgSeq = i5;
        this.notification = str9;
        this.ownerAccount = str10;
        this.hasOnMic = z;
        this.lastMemberUrl = str11;
        this.lastMemberName = str12;
        this.role_members = list;
        this.supportLevel = i6;
        this.maxStage = num;
        this.password = str13;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final SelfInfo getSelfInfo() {
        return this.selfInfo;
    }

    /* renamed from: component10, reason: from getter */
    public final long getLastMsgTime() {
        return this.lastMsgTime;
    }

    /* renamed from: component11, reason: from getter */
    public final int getMaxMemberNum() {
        return this.maxMemberNum;
    }

    /* renamed from: component12, reason: from getter */
    public final int getMemberNum() {
        return this.memberNum;
    }

    /* renamed from: component13, reason: from getter */
    public final int getMsgStatus() {
        return this.msgStatus;
    }

    /* renamed from: component14, reason: from getter */
    public final int getMyRole() {
        return this.myRole;
    }

    @NotNull
    /* renamed from: component15, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component16, reason: from getter */
    public final int getNextMsgSeq() {
        return this.nextMsgSeq;
    }

    @NotNull
    /* renamed from: component17, reason: from getter */
    public final String getNotification() {
        return this.notification;
    }

    @NotNull
    /* renamed from: component18, reason: from getter */
    public final String getOwnerAccount() {
        return this.ownerAccount;
    }

    /* renamed from: component19, reason: from getter */
    public final boolean getHasOnMic() {
        return this.hasOnMic;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getOwnerAvatar() {
        return this.ownerAvatar;
    }

    @Nullable
    /* renamed from: component20, reason: from getter */
    public final String getLastMemberUrl() {
        return this.lastMemberUrl;
    }

    @Nullable
    /* renamed from: component21, reason: from getter */
    public final String getLastMemberName() {
        return this.lastMemberName;
    }

    @Nullable
    public final List<RoleMember> component22() {
        return this.role_members;
    }

    /* renamed from: component23, reason: from getter */
    public final int getSupportLevel() {
        return this.supportLevel;
    }

    @Nullable
    /* renamed from: component24, reason: from getter */
    public final Integer getMaxStage() {
        return this.maxStage;
    }

    @Nullable
    /* renamed from: component25, reason: from getter */
    public final String getPassword() {
        return this.password;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getOwnerNick() {
        return this.ownerNick;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component6, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getIntroduction() {
        return this.introduction;
    }

    @NotNull
    public final GroupBean copy(@NotNull SelfInfo selfInfo, @Nullable String ownerAvatar, @Nullable String ownerNick, @NotNull String countryIcon, @NotNull String code, long createTime, @NotNull String faceUrl, @NotNull String groupId, @NotNull String introduction, long lastMsgTime, int maxMemberNum, int memberNum, int msgStatus, int myRole, @NotNull String name, int nextMsgSeq, @NotNull String notification, @NotNull String ownerAccount, boolean hasOnMic, @Nullable String lastMemberUrl, @Nullable String lastMemberName, @Nullable List<RoleMember> role_members, int supportLevel, @Nullable Integer maxStage, @Nullable String password) {
        Intrinsics.checkNotNullParameter(selfInfo, "selfInfo");
        Intrinsics.checkNotNullParameter(countryIcon, "countryIcon");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(faceUrl, TUIConstants.TUIChat.FACE_URL);
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(introduction, "introduction");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(notification, "notification");
        Intrinsics.checkNotNullParameter(ownerAccount, "ownerAccount");
        return new GroupBean(selfInfo, ownerAvatar, ownerNick, countryIcon, code, createTime, faceUrl, groupId, introduction, lastMsgTime, maxMemberNum, memberNum, msgStatus, myRole, name, nextMsgSeq, notification, ownerAccount, hasOnMic, lastMemberUrl, lastMemberName, role_members, supportLevel, maxStage, password);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupBean)) {
            return false;
        }
        GroupBean groupBean = (GroupBean) other;
        return Intrinsics.areEqual(this.selfInfo, groupBean.selfInfo) && Intrinsics.areEqual(this.ownerAvatar, groupBean.ownerAvatar) && Intrinsics.areEqual(this.ownerNick, groupBean.ownerNick) && Intrinsics.areEqual(this.countryIcon, groupBean.countryIcon) && Intrinsics.areEqual(this.code, groupBean.code) && this.createTime == groupBean.createTime && Intrinsics.areEqual(this.faceUrl, groupBean.faceUrl) && Intrinsics.areEqual(this.groupId, groupBean.groupId) && Intrinsics.areEqual(this.introduction, groupBean.introduction) && this.lastMsgTime == groupBean.lastMsgTime && this.maxMemberNum == groupBean.maxMemberNum && this.memberNum == groupBean.memberNum && this.msgStatus == groupBean.msgStatus && this.myRole == groupBean.myRole && Intrinsics.areEqual(this.name, groupBean.name) && this.nextMsgSeq == groupBean.nextMsgSeq && Intrinsics.areEqual(this.notification, groupBean.notification) && Intrinsics.areEqual(this.ownerAccount, groupBean.ownerAccount) && this.hasOnMic == groupBean.hasOnMic && Intrinsics.areEqual(this.lastMemberUrl, groupBean.lastMemberUrl) && Intrinsics.areEqual(this.lastMemberName, groupBean.lastMemberName) && Intrinsics.areEqual(this.role_members, groupBean.role_members) && this.supportLevel == groupBean.supportLevel && Intrinsics.areEqual(this.maxStage, groupBean.maxStage) && Intrinsics.areEqual(this.password, groupBean.password);
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    @NotNull
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    @NotNull
    public final String getGroupId() {
        return this.groupId;
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

    @Nullable
    public final String getLastMemberName() {
        return this.lastMemberName;
    }

    @Nullable
    public final String getLastMemberUrl() {
        return this.lastMemberUrl;
    }

    public final long getLastMsgTime() {
        return this.lastMsgTime;
    }

    public final int getMaxMemberNum() {
        return this.maxMemberNum;
    }

    @Nullable
    public final Integer getMaxStage() {
        return this.maxStage;
    }

    public final int getMemberNum() {
        return this.memberNum;
    }

    public final int getMsgStatus() {
        return this.msgStatus;
    }

    public final int getMyRole() {
        return this.myRole;
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
    public final String getOwnerAvatar() {
        return this.ownerAvatar;
    }

    @Nullable
    public final String getOwnerNick() {
        return this.ownerNick;
    }

    @Nullable
    public final String getPassword() {
        return this.password;
    }

    @Nullable
    public final List<RoleMember> getRole_members() {
        return this.role_members;
    }

    @NotNull
    public final SelfInfo getSelfInfo() {
        return this.selfInfo;
    }

    public final int getSupportLevel() {
        return this.supportLevel;
    }

    public int hashCode() {
        int hashCode = this.selfInfo.hashCode() * 31;
        String str = this.ownerAvatar;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.ownerNick;
        int hashCode3 = (((((((((((((((((((((((((((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.countryIcon.hashCode()) * 31) + this.code.hashCode()) * 31) + c.a(this.createTime)) * 31) + this.faceUrl.hashCode()) * 31) + this.groupId.hashCode()) * 31) + this.introduction.hashCode()) * 31) + c.a(this.lastMsgTime)) * 31) + this.maxMemberNum) * 31) + this.memberNum) * 31) + this.msgStatus) * 31) + this.myRole) * 31) + this.name.hashCode()) * 31) + this.nextMsgSeq) * 31) + this.notification.hashCode()) * 31) + this.ownerAccount.hashCode()) * 31) + a.a(this.hasOnMic)) * 31;
        String str3 = this.lastMemberUrl;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.lastMemberName;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<RoleMember> list = this.role_members;
        int hashCode6 = (((hashCode5 + (list == null ? 0 : list.hashCode())) * 31) + this.supportLevel) * 31;
        Integer num = this.maxStage;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.password;
        return hashCode7 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setLastMemberName(@Nullable String str) {
        this.lastMemberName = str;
    }

    public final void setLastMemberUrl(@Nullable String str) {
        this.lastMemberUrl = str;
    }

    public final void setMaxStage(@Nullable Integer num) {
        this.maxStage = num;
    }

    public final void setMsgStatus(int i) {
        this.msgStatus = i;
    }

    public final void setPassword(@Nullable String str) {
        this.password = str;
    }

    public final void setRole_members(@Nullable List<RoleMember> list) {
        this.role_members = list;
    }

    public final void setSupportLevel(int i) {
        this.supportLevel = i;
    }

    @NotNull
    public String toString() {
        return "GroupBean(selfInfo=" + this.selfInfo + ", ownerAvatar=" + this.ownerAvatar + ", ownerNick=" + this.ownerNick + ", countryIcon=" + this.countryIcon + ", code=" + this.code + ", createTime=" + this.createTime + ", faceUrl=" + this.faceUrl + ", groupId=" + this.groupId + ", introduction=" + this.introduction + ", lastMsgTime=" + this.lastMsgTime + ", maxMemberNum=" + this.maxMemberNum + ", memberNum=" + this.memberNum + ", msgStatus=" + this.msgStatus + ", myRole=" + this.myRole + ", name=" + this.name + ", nextMsgSeq=" + this.nextMsgSeq + ", notification=" + this.notification + ", ownerAccount=" + this.ownerAccount + ", hasOnMic=" + this.hasOnMic + ", lastMemberUrl=" + this.lastMemberUrl + ", lastMemberName=" + this.lastMemberName + ", role_members=" + this.role_members + ", supportLevel=" + this.supportLevel + ", maxStage=" + this.maxStage + ", password=" + this.password + ")";
    }

    public /* synthetic */ GroupBean(SelfInfo selfInfo, String str, String str2, String str3, String str4, long j, String str5, String str6, String str7, long j2, int i, int i2, int i3, int i4, String str8, int i5, String str9, String str10, boolean z, String str11, String str12, List list, int i6, Integer num, String str13, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(selfInfo, str, str2, str3, str4, j, str5, str6, str7, j2, i, i2, i3, i4, str8, i5, str9, str10, z, str11, str12, list, (i7 & 4194304) != 0 ? 0 : i6, (i7 & 8388608) != 0 ? -1 : num, (i7 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? null : str13);
    }
}
