package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\bS\b\u0086\b\u0018\u00002\u00020\u0001B\u00ad\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0001\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0001\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0001\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\r\u0012\u0006\u0010\u001a\u001a\u00020\r\u0012\u0006\u0010\u001b\u001a\u00020\u0013\u0012\u0006\u0010\u001c\u001a\u00020\r\u0012\u0006\u0010\u001d\u001a\u00020\u0001\u0012\u0006\u0010\u001e\u001a\u00020\u0001\u0012\u0006\u0010\u001f\u001a\u00020\u0001\u0012\u0006\u0010 \u001a\u00020\r\u0012\u0006\u0010!\u001a\u00020\u0001\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130#\u0012\u0006\u0010$\u001a\u00020\u0013\u0012\u0006\u0010%\u001a\u00020\u0013\u0012\u0006\u0010&\u001a\u00020\u0005\u0012\u0006\u0010'\u001a\u00020\u0013\u0012\u0006\u0010(\u001a\u00020\u0001\u0012\u0006\u0010)\u001a\u00020\u0001\u0012\u0006\u0010*\u001a\u00020\u0003¢\u0006\u0004\b+\u0010,J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\t\u0010U\u001a\u00020\rHÆ\u0003J\t\u0010V\u001a\u00020\u0001HÆ\u0003J\t\u0010W\u001a\u00020\u0001HÆ\u0003J\t\u0010X\u001a\u00020\u0005HÆ\u0003J\t\u0010Y\u001a\u00020\u0001HÆ\u0003J\t\u0010Z\u001a\u00020\u0013HÆ\u0003J\t\u0010[\u001a\u00020\u0013HÆ\u0003J\t\u0010\\\u001a\u00020\u0001HÆ\u0003J\t\u0010]\u001a\u00020\u0013HÆ\u0003J\t\u0010^\u001a\u00020\u0001HÆ\u0003J\t\u0010_\u001a\u00020\rHÆ\u0003J\t\u0010`\u001a\u00020\rHÆ\u0003J\t\u0010a\u001a\u00020\rHÆ\u0003J\t\u0010b\u001a\u00020\u0013HÆ\u0003J\t\u0010c\u001a\u00020\rHÆ\u0003J\t\u0010d\u001a\u00020\u0001HÆ\u0003J\t\u0010e\u001a\u00020\u0001HÆ\u0003J\t\u0010f\u001a\u00020\u0001HÆ\u0003J\t\u0010g\u001a\u00020\rHÆ\u0003J\t\u0010h\u001a\u00020\u0001HÆ\u0003J\u000f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00130#HÆ\u0003J\t\u0010j\u001a\u00020\u0013HÆ\u0003J\t\u0010k\u001a\u00020\u0013HÆ\u0003J\t\u0010l\u001a\u00020\u0005HÆ\u0003J\t\u0010m\u001a\u00020\u0013HÆ\u0003J\t\u0010n\u001a\u00020\u0001HÆ\u0003J\t\u0010o\u001a\u00020\u0001HÆ\u0003J\t\u0010p\u001a\u00020\u0003HÆ\u0003J÷\u0002\u0010q\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\u00012\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\u00012\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130#2\b\b\u0002\u0010$\u001a\u00020\u00132\b\b\u0002\u0010%\u001a\u00020\u00132\b\b\u0002\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u00132\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00012\b\b\u0002\u0010*\u001a\u00020\u0003HÆ\u0001J\u0013\u0010r\u001a\u00020\r2\b\u0010s\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010t\u001a\u00020\u0013HÖ\u0001J\t\u0010u\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010.R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010.R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u00100R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u00100R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u00100R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u00100R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u000e\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010\u000f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b;\u0010:R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u00100R\u0011\u0010\u0011\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b=\u0010:R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b@\u0010?R\u0011\u0010\u0015\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bA\u0010:R\u0011\u0010\u0016\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bB\u0010?R\u0011\u0010\u0017\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010:R\u0011\u0010\u0018\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u00108R\u0011\u0010\u0019\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u00108R\u0011\u0010\u001a\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u00108R\u0011\u0010\u001b\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010?R\u0011\u0010\u001c\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u00108R\u0011\u0010\u001d\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010:R\u0011\u0010\u001e\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010:R\u0011\u0010\u001f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010:R\u0011\u0010 \u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u00108R\u0011\u0010!\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bC\u0010:R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130#¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0011\u0010$\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bF\u0010?R\u0011\u0010%\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bG\u0010?R\u0011\u0010&\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bH\u00100R\u0011\u0010'\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bI\u0010?R\u0011\u0010(\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010:R\u0011\u0010)\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bK\u0010:R\u0011\u0010*\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u0010.¨\u0006v"}, d2 = {"Lcom/qiahao/nextvideo/data/model/PowerUser;", "", "activityUserGrade", "", "avatar", "", "birthday", "charmUserGrade", Constants.KEY_HTTP_CODE, "country", "countryIcon", "currentRoom", "defaultAvatar", "", "description", "diamondNum", SupportGiftRankActivity.EXTERNAL_ID, "headwear", "heartValue", "", "heartValueMax", "iLikeCount", AgooConstants.MESSAGE_ID, "isAgentMgr", "isLike", "isLikeMe", "isPrettyCode", "isPush", "isSession", "isShowAge", "isTradeUnion", "isTradeUnionMatchNotification", "isVip", "likeCount", "medals", "", "meetDays", "myGroupPower", "nick", "sex", "vipExpireTime", "visitCount", "wealthUserGrade", "<init>", "(JLjava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;IILjava/lang/Object;ILjava/lang/Object;ZZZIZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;ZLjava/lang/Object;Ljava/util/List;IILjava/lang/String;ILjava/lang/Object;Ljava/lang/Object;J)V", "getActivityUserGrade", "()J", "getAvatar", "()Ljava/lang/String;", "getBirthday", "getCharmUserGrade", "getCode", "getCountry", "getCountryIcon", "getCurrentRoom", "getDefaultAvatar", "()Z", "getDescription", "()Ljava/lang/Object;", "getDiamondNum", "getExternalId", "getHeadwear", "getHeartValue", "()I", "getHeartValueMax", "getILikeCount", "getId", "getLikeCount", "getMedals", "()Ljava/util/List;", "getMeetDays", "getMyGroupPower", "getNick", "getSex", "getVipExpireTime", "getVisitCount", "getWealthUserGrade", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "copy", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class PowerUser {
    private final long activityUserGrade;

    @NotNull
    private final String avatar;
    private final long birthday;
    private final long charmUserGrade;

    @NotNull
    private final String code;

    @NotNull
    private final String country;

    @NotNull
    private final String countryIcon;

    @NotNull
    private final String currentRoom;
    private final boolean defaultAvatar;

    @NotNull
    private final Object description;

    @NotNull
    private final Object diamondNum;

    @NotNull
    private final String externalId;

    @NotNull
    private final Object headwear;
    private final int heartValue;
    private final int heartValueMax;

    @NotNull
    private final Object iLikeCount;
    private final int id;

    @NotNull
    private final Object isAgentMgr;
    private final boolean isLike;
    private final boolean isLikeMe;
    private final boolean isPrettyCode;
    private final int isPush;
    private final boolean isSession;

    @NotNull
    private final Object isShowAge;

    @NotNull
    private final Object isTradeUnion;

    @NotNull
    private final Object isTradeUnionMatchNotification;
    private final boolean isVip;

    @NotNull
    private final Object likeCount;

    @NotNull
    private final List<Integer> medals;
    private final int meetDays;
    private final int myGroupPower;

    @NotNull
    private final String nick;
    private final int sex;

    @NotNull
    private final Object vipExpireTime;

    @NotNull
    private final Object visitCount;
    private final long wealthUserGrade;

    public PowerUser(long j, @NotNull String str, long j2, long j3, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, boolean z, @NotNull Object obj, @NotNull Object obj2, @NotNull String str6, @NotNull Object obj3, int i, int i2, @NotNull Object obj4, int i3, @NotNull Object obj5, boolean z2, boolean z3, boolean z4, int i4, boolean z5, @NotNull Object obj6, @NotNull Object obj7, @NotNull Object obj8, boolean z6, @NotNull Object obj9, @NotNull List<Integer> list, int i5, int i6, @NotNull String str7, int i7, @NotNull Object obj10, @NotNull Object obj11, long j4) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str3, "country");
        Intrinsics.checkNotNullParameter(str4, "countryIcon");
        Intrinsics.checkNotNullParameter(str5, "currentRoom");
        Intrinsics.checkNotNullParameter(obj, "description");
        Intrinsics.checkNotNullParameter(obj2, "diamondNum");
        Intrinsics.checkNotNullParameter(str6, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(obj3, "headwear");
        Intrinsics.checkNotNullParameter(obj4, "iLikeCount");
        Intrinsics.checkNotNullParameter(obj5, "isAgentMgr");
        Intrinsics.checkNotNullParameter(obj6, "isShowAge");
        Intrinsics.checkNotNullParameter(obj7, "isTradeUnion");
        Intrinsics.checkNotNullParameter(obj8, "isTradeUnionMatchNotification");
        Intrinsics.checkNotNullParameter(obj9, "likeCount");
        Intrinsics.checkNotNullParameter(list, "medals");
        Intrinsics.checkNotNullParameter(str7, "nick");
        Intrinsics.checkNotNullParameter(obj10, "vipExpireTime");
        Intrinsics.checkNotNullParameter(obj11, "visitCount");
        this.activityUserGrade = j;
        this.avatar = str;
        this.birthday = j2;
        this.charmUserGrade = j3;
        this.code = str2;
        this.country = str3;
        this.countryIcon = str4;
        this.currentRoom = str5;
        this.defaultAvatar = z;
        this.description = obj;
        this.diamondNum = obj2;
        this.externalId = str6;
        this.headwear = obj3;
        this.heartValue = i;
        this.heartValueMax = i2;
        this.iLikeCount = obj4;
        this.id = i3;
        this.isAgentMgr = obj5;
        this.isLike = z2;
        this.isLikeMe = z3;
        this.isPrettyCode = z4;
        this.isPush = i4;
        this.isSession = z5;
        this.isShowAge = obj6;
        this.isTradeUnion = obj7;
        this.isTradeUnionMatchNotification = obj8;
        this.isVip = z6;
        this.likeCount = obj9;
        this.medals = list;
        this.meetDays = i5;
        this.myGroupPower = i6;
        this.nick = str7;
        this.sex = i7;
        this.vipExpireTime = obj10;
        this.visitCount = obj11;
        this.wealthUserGrade = j4;
    }

    /* renamed from: component1, reason: from getter */
    public final long getActivityUserGrade() {
        return this.activityUserGrade;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final Object getDescription() {
        return this.description;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final Object getDiamondNum() {
        return this.diamondNum;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    @NotNull
    /* renamed from: component13, reason: from getter */
    public final Object getHeadwear() {
        return this.headwear;
    }

    /* renamed from: component14, reason: from getter */
    public final int getHeartValue() {
        return this.heartValue;
    }

    /* renamed from: component15, reason: from getter */
    public final int getHeartValueMax() {
        return this.heartValueMax;
    }

    @NotNull
    /* renamed from: component16, reason: from getter */
    public final Object getILikeCount() {
        return this.iLikeCount;
    }

    /* renamed from: component17, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component18, reason: from getter */
    public final Object getIsAgentMgr() {
        return this.isAgentMgr;
    }

    /* renamed from: component19, reason: from getter */
    public final boolean getIsLike() {
        return this.isLike;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component20, reason: from getter */
    public final boolean getIsLikeMe() {
        return this.isLikeMe;
    }

    /* renamed from: component21, reason: from getter */
    public final boolean getIsPrettyCode() {
        return this.isPrettyCode;
    }

    /* renamed from: component22, reason: from getter */
    public final int getIsPush() {
        return this.isPush;
    }

    /* renamed from: component23, reason: from getter */
    public final boolean getIsSession() {
        return this.isSession;
    }

    @NotNull
    /* renamed from: component24, reason: from getter */
    public final Object getIsShowAge() {
        return this.isShowAge;
    }

    @NotNull
    /* renamed from: component25, reason: from getter */
    public final Object getIsTradeUnion() {
        return this.isTradeUnion;
    }

    @NotNull
    /* renamed from: component26, reason: from getter */
    public final Object getIsTradeUnionMatchNotification() {
        return this.isTradeUnionMatchNotification;
    }

    /* renamed from: component27, reason: from getter */
    public final boolean getIsVip() {
        return this.isVip;
    }

    @NotNull
    /* renamed from: component28, reason: from getter */
    public final Object getLikeCount() {
        return this.likeCount;
    }

    @NotNull
    public final List<Integer> component29() {
        return this.medals;
    }

    /* renamed from: component3, reason: from getter */
    public final long getBirthday() {
        return this.birthday;
    }

    /* renamed from: component30, reason: from getter */
    public final int getMeetDays() {
        return this.meetDays;
    }

    /* renamed from: component31, reason: from getter */
    public final int getMyGroupPower() {
        return this.myGroupPower;
    }

    @NotNull
    /* renamed from: component32, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* renamed from: component33, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    @NotNull
    /* renamed from: component34, reason: from getter */
    public final Object getVipExpireTime() {
        return this.vipExpireTime;
    }

    @NotNull
    /* renamed from: component35, reason: from getter */
    public final Object getVisitCount() {
        return this.visitCount;
    }

    /* renamed from: component36, reason: from getter */
    public final long getWealthUserGrade() {
        return this.wealthUserGrade;
    }

    /* renamed from: component4, reason: from getter */
    public final long getCharmUserGrade() {
        return this.charmUserGrade;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getCurrentRoom() {
        return this.currentRoom;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getDefaultAvatar() {
        return this.defaultAvatar;
    }

    @NotNull
    public final PowerUser copy(long activityUserGrade, @NotNull String avatar, long birthday, long charmUserGrade, @NotNull String code, @NotNull String country, @NotNull String countryIcon, @NotNull String currentRoom, boolean defaultAvatar, @NotNull Object description, @NotNull Object diamondNum, @NotNull String externalId, @NotNull Object headwear, int heartValue, int heartValueMax, @NotNull Object iLikeCount, int id2, @NotNull Object isAgentMgr, boolean isLike, boolean isLikeMe, boolean isPrettyCode, int isPush, boolean isSession, @NotNull Object isShowAge, @NotNull Object isTradeUnion, @NotNull Object isTradeUnionMatchNotification, boolean isVip, @NotNull Object likeCount, @NotNull List<Integer> medals, int meetDays, int myGroupPower, @NotNull String nick, int sex, @NotNull Object vipExpireTime, @NotNull Object visitCount, long wealthUserGrade) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(countryIcon, "countryIcon");
        Intrinsics.checkNotNullParameter(currentRoom, "currentRoom");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(diamondNum, "diamondNum");
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(headwear, "headwear");
        Intrinsics.checkNotNullParameter(iLikeCount, "iLikeCount");
        Intrinsics.checkNotNullParameter(isAgentMgr, "isAgentMgr");
        Intrinsics.checkNotNullParameter(isShowAge, "isShowAge");
        Intrinsics.checkNotNullParameter(isTradeUnion, "isTradeUnion");
        Intrinsics.checkNotNullParameter(isTradeUnionMatchNotification, "isTradeUnionMatchNotification");
        Intrinsics.checkNotNullParameter(likeCount, "likeCount");
        Intrinsics.checkNotNullParameter(medals, "medals");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(vipExpireTime, "vipExpireTime");
        Intrinsics.checkNotNullParameter(visitCount, "visitCount");
        return new PowerUser(activityUserGrade, avatar, birthday, charmUserGrade, code, country, countryIcon, currentRoom, defaultAvatar, description, diamondNum, externalId, headwear, heartValue, heartValueMax, iLikeCount, id2, isAgentMgr, isLike, isLikeMe, isPrettyCode, isPush, isSession, isShowAge, isTradeUnion, isTradeUnionMatchNotification, isVip, likeCount, medals, meetDays, myGroupPower, nick, sex, vipExpireTime, visitCount, wealthUserGrade);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PowerUser)) {
            return false;
        }
        PowerUser powerUser = (PowerUser) other;
        return this.activityUserGrade == powerUser.activityUserGrade && Intrinsics.areEqual(this.avatar, powerUser.avatar) && this.birthday == powerUser.birthday && this.charmUserGrade == powerUser.charmUserGrade && Intrinsics.areEqual(this.code, powerUser.code) && Intrinsics.areEqual(this.country, powerUser.country) && Intrinsics.areEqual(this.countryIcon, powerUser.countryIcon) && Intrinsics.areEqual(this.currentRoom, powerUser.currentRoom) && this.defaultAvatar == powerUser.defaultAvatar && Intrinsics.areEqual(this.description, powerUser.description) && Intrinsics.areEqual(this.diamondNum, powerUser.diamondNum) && Intrinsics.areEqual(this.externalId, powerUser.externalId) && Intrinsics.areEqual(this.headwear, powerUser.headwear) && this.heartValue == powerUser.heartValue && this.heartValueMax == powerUser.heartValueMax && Intrinsics.areEqual(this.iLikeCount, powerUser.iLikeCount) && this.id == powerUser.id && Intrinsics.areEqual(this.isAgentMgr, powerUser.isAgentMgr) && this.isLike == powerUser.isLike && this.isLikeMe == powerUser.isLikeMe && this.isPrettyCode == powerUser.isPrettyCode && this.isPush == powerUser.isPush && this.isSession == powerUser.isSession && Intrinsics.areEqual(this.isShowAge, powerUser.isShowAge) && Intrinsics.areEqual(this.isTradeUnion, powerUser.isTradeUnion) && Intrinsics.areEqual(this.isTradeUnionMatchNotification, powerUser.isTradeUnionMatchNotification) && this.isVip == powerUser.isVip && Intrinsics.areEqual(this.likeCount, powerUser.likeCount) && Intrinsics.areEqual(this.medals, powerUser.medals) && this.meetDays == powerUser.meetDays && this.myGroupPower == powerUser.myGroupPower && Intrinsics.areEqual(this.nick, powerUser.nick) && this.sex == powerUser.sex && Intrinsics.areEqual(this.vipExpireTime, powerUser.vipExpireTime) && Intrinsics.areEqual(this.visitCount, powerUser.visitCount) && this.wealthUserGrade == powerUser.wealthUserGrade;
    }

    public final long getActivityUserGrade() {
        return this.activityUserGrade;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    public final long getBirthday() {
        return this.birthday;
    }

    public final long getCharmUserGrade() {
        return this.charmUserGrade;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getCountry() {
        return this.country;
    }

    @NotNull
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    @NotNull
    public final String getCurrentRoom() {
        return this.currentRoom;
    }

    public final boolean getDefaultAvatar() {
        return this.defaultAvatar;
    }

    @NotNull
    public final Object getDescription() {
        return this.description;
    }

    @NotNull
    public final Object getDiamondNum() {
        return this.diamondNum;
    }

    @NotNull
    public final String getExternalId() {
        return this.externalId;
    }

    @NotNull
    public final Object getHeadwear() {
        return this.headwear;
    }

    public final int getHeartValue() {
        return this.heartValue;
    }

    public final int getHeartValueMax() {
        return this.heartValueMax;
    }

    @NotNull
    public final Object getILikeCount() {
        return this.iLikeCount;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final Object getLikeCount() {
        return this.likeCount;
    }

    @NotNull
    public final List<Integer> getMedals() {
        return this.medals;
    }

    public final int getMeetDays() {
        return this.meetDays;
    }

    public final int getMyGroupPower() {
        return this.myGroupPower;
    }

    @NotNull
    public final String getNick() {
        return this.nick;
    }

    public final int getSex() {
        return this.sex;
    }

    @NotNull
    public final Object getVipExpireTime() {
        return this.vipExpireTime;
    }

    @NotNull
    public final Object getVisitCount() {
        return this.visitCount;
    }

    public final long getWealthUserGrade() {
        return this.wealthUserGrade;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((c.a(this.activityUserGrade) * 31) + this.avatar.hashCode()) * 31) + c.a(this.birthday)) * 31) + c.a(this.charmUserGrade)) * 31) + this.code.hashCode()) * 31) + this.country.hashCode()) * 31) + this.countryIcon.hashCode()) * 31) + this.currentRoom.hashCode()) * 31) + a.a(this.defaultAvatar)) * 31) + this.description.hashCode()) * 31) + this.diamondNum.hashCode()) * 31) + this.externalId.hashCode()) * 31) + this.headwear.hashCode()) * 31) + this.heartValue) * 31) + this.heartValueMax) * 31) + this.iLikeCount.hashCode()) * 31) + this.id) * 31) + this.isAgentMgr.hashCode()) * 31) + a.a(this.isLike)) * 31) + a.a(this.isLikeMe)) * 31) + a.a(this.isPrettyCode)) * 31) + this.isPush) * 31) + a.a(this.isSession)) * 31) + this.isShowAge.hashCode()) * 31) + this.isTradeUnion.hashCode()) * 31) + this.isTradeUnionMatchNotification.hashCode()) * 31) + a.a(this.isVip)) * 31) + this.likeCount.hashCode()) * 31) + this.medals.hashCode()) * 31) + this.meetDays) * 31) + this.myGroupPower) * 31) + this.nick.hashCode()) * 31) + this.sex) * 31) + this.vipExpireTime.hashCode()) * 31) + this.visitCount.hashCode()) * 31) + c.a(this.wealthUserGrade);
    }

    @NotNull
    public final Object isAgentMgr() {
        return this.isAgentMgr;
    }

    public final boolean isLike() {
        return this.isLike;
    }

    public final boolean isLikeMe() {
        return this.isLikeMe;
    }

    public final boolean isPrettyCode() {
        return this.isPrettyCode;
    }

    public final int isPush() {
        return this.isPush;
    }

    public final boolean isSession() {
        return this.isSession;
    }

    @NotNull
    public final Object isShowAge() {
        return this.isShowAge;
    }

    @NotNull
    public final Object isTradeUnion() {
        return this.isTradeUnion;
    }

    @NotNull
    public final Object isTradeUnionMatchNotification() {
        return this.isTradeUnionMatchNotification;
    }

    public final boolean isVip() {
        return this.isVip;
    }

    @NotNull
    public String toString() {
        return "PowerUser(activityUserGrade=" + this.activityUserGrade + ", avatar=" + this.avatar + ", birthday=" + this.birthday + ", charmUserGrade=" + this.charmUserGrade + ", code=" + this.code + ", country=" + this.country + ", countryIcon=" + this.countryIcon + ", currentRoom=" + this.currentRoom + ", defaultAvatar=" + this.defaultAvatar + ", description=" + this.description + ", diamondNum=" + this.diamondNum + ", externalId=" + this.externalId + ", headwear=" + this.headwear + ", heartValue=" + this.heartValue + ", heartValueMax=" + this.heartValueMax + ", iLikeCount=" + this.iLikeCount + ", id=" + this.id + ", isAgentMgr=" + this.isAgentMgr + ", isLike=" + this.isLike + ", isLikeMe=" + this.isLikeMe + ", isPrettyCode=" + this.isPrettyCode + ", isPush=" + this.isPush + ", isSession=" + this.isSession + ", isShowAge=" + this.isShowAge + ", isTradeUnion=" + this.isTradeUnion + ", isTradeUnionMatchNotification=" + this.isTradeUnionMatchNotification + ", isVip=" + this.isVip + ", likeCount=" + this.likeCount + ", medals=" + this.medals + ", meetDays=" + this.meetDays + ", myGroupPower=" + this.myGroupPower + ", nick=" + this.nick + ", sex=" + this.sex + ", vipExpireTime=" + this.vipExpireTime + ", visitCount=" + this.visitCount + ", wealthUserGrade=" + this.wealthUserGrade + ")";
    }
}
