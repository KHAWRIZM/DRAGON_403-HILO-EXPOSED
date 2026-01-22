package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import com.qiahao.base_common.model.common.MedalInfo;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2Connection;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bR\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f\u0012\u001c\b\u0002\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b%\u0010&J\u0006\u0010T\u001a\u00020\nJ\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\nHÆ\u0003J\t\u0010[\u001a\u00020\fHÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u000fHÆ\u0003J\t\u0010^\u001a\u00020\fHÆ\u0003J\u0010\u0010_\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00105J\u000b\u0010`\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010a\u001a\u00020\fHÆ\u0003J\t\u0010b\u001a\u00020\nHÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u000fHÆ\u0003J\u001d\u0010e\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001aHÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010=J\t\u0010g\u001a\u00020\u0005HÆ\u0003J\t\u0010h\u001a\u00020\u0005HÆ\u0003J\t\u0010i\u001a\u00020\u0005HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010 HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\"HÆ\u0003J\u0010\u0010l\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010m\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00105J®\u0002\u0010n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\u001c\b\u0002\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010oJ\u0013\u0010p\u001a\u00020\n2\b\u0010q\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010r\u001a\u00020\u000fHÖ\u0001J\t\u0010s\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010(R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010(R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0010\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u00101R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u00106\u001a\u0004\b\u0011\u00105R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u00101R\u0011\u0010\u0013\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u00101R\u0011\u0010\u0014\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010/R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010(R\u0011\u0010\u0016\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b8\u00104R.\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010@\u001a\u0004\b\u001b\u0010=\"\u0004\b>\u0010?R\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010*\"\u0004\bB\u0010CR\u001a\u0010\u001d\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010*\"\u0004\bE\u0010CR\u001a\u0010\u001e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010*\"\u0004\bG\u0010CR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001e\u0010#\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010@\u001a\u0004\b#\u0010=\"\u0004\bP\u0010?R\u001e\u0010$\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\bQ\u00105\"\u0004\bR\u0010S¨\u0006t"}, d2 = {"Lcom/qiahao/nextvideo/data/model/CelebrityOrCharmUserBase;", "Ljava/io/Serializable;", "avatar", "", "birthday", "", Constants.KEY_HTTP_CODE, "country", "countryIcon", "defaultAvatar", "", "description", "", SupportGiftRankActivity.EXTERNAL_ID, AgooConstants.MESSAGE_ID, "", "isAgentMgr", "isShowAge", "isTradeUnion", "isTradeUnionMatchNotification", "isVip", "nick", "sex", "medalInfo", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/common/MedalInfo;", "Lkotlin/collections/ArrayList;", "isPrettyCode", "wealthUserGrade", "charmUserGrade", "activityUserGrade", "noble", "Lcom/qiahao/base_common/model/common/NobleInfo;", "svip", "Lcom/qiahao/base_common/model/svip/SvipData;", "isCountryId", "idFrameType", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;Ljava/lang/String;ILjava/lang/Object;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Object;ZLjava/lang/String;ILjava/util/ArrayList;Ljava/lang/Boolean;JJJLcom/qiahao/base_common/model/common/NobleInfo;Lcom/qiahao/base_common/model/svip/SvipData;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getAvatar", "()Ljava/lang/String;", "getBirthday", "()J", "getCode", "getCountry", "getCountryIcon", "getDefaultAvatar", "()Z", "getDescription", "()Ljava/lang/Object;", "getExternalId", "getId", "()I", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNick", "getSex", "getMedalInfo", "()Ljava/util/ArrayList;", "setMedalInfo", "(Ljava/util/ArrayList;)V", "()Ljava/lang/Boolean;", "setPrettyCode", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getWealthUserGrade", "setWealthUserGrade", "(J)V", "getCharmUserGrade", "setCharmUserGrade", "getActivityUserGrade", "setActivityUserGrade", "getNoble", "()Lcom/qiahao/base_common/model/common/NobleInfo;", "setNoble", "(Lcom/qiahao/base_common/model/common/NobleInfo;)V", "getSvip", "()Lcom/qiahao/base_common/model/svip/SvipData;", "setSvip", "(Lcom/qiahao/base_common/model/svip/SvipData;)V", "setCountryId", "getIdFrameType", "setIdFrameType", "(Ljava/lang/Integer;)V", "checkNotOfficialStaffAndMy", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;Ljava/lang/String;ILjava/lang/Object;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Object;ZLjava/lang/String;ILjava/util/ArrayList;Ljava/lang/Boolean;JJJLcom/qiahao/base_common/model/common/NobleInfo;Lcom/qiahao/base_common/model/svip/SvipData;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/model/CelebrityOrCharmUserBase;", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CelebrityOrCharmUserBase implements Serializable {
    private long activityUserGrade;

    @Nullable
    private final String avatar;
    private final long birthday;
    private long charmUserGrade;

    @NotNull
    private final String code;

    @NotNull
    private final String country;

    @NotNull
    private final String countryIcon;
    private final boolean defaultAvatar;

    @NotNull
    private final Object description;

    @NotNull
    private final String externalId;
    private final int id;

    @Nullable
    private Integer idFrameType;

    @NotNull
    private final Object isAgentMgr;

    @Nullable
    private Boolean isCountryId;

    @Nullable
    private Boolean isPrettyCode;

    @Nullable
    private final Integer isShowAge;

    @Nullable
    private final Object isTradeUnion;

    @NotNull
    private final Object isTradeUnionMatchNotification;
    private final boolean isVip;

    @Nullable
    private ArrayList<MedalInfo> medalInfo;

    @Nullable
    private final String nick;

    @Nullable
    private NobleInfo noble;
    private final int sex;

    @Nullable
    private SvipData svip;
    private long wealthUserGrade;

    public CelebrityOrCharmUserBase(@Nullable String str, long j, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z, @NotNull Object obj, @NotNull String str5, int i, @NotNull Object obj2, @Nullable Integer num, @Nullable Object obj3, @NotNull Object obj4, boolean z2, @Nullable String str6, int i2, @Nullable ArrayList<MedalInfo> arrayList, @Nullable Boolean bool, long j2, long j3, long j4, @Nullable NobleInfo nobleInfo, @Nullable SvipData svipData, @Nullable Boolean bool2, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(str2, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str3, "country");
        Intrinsics.checkNotNullParameter(str4, "countryIcon");
        Intrinsics.checkNotNullParameter(obj, "description");
        Intrinsics.checkNotNullParameter(str5, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(obj2, "isAgentMgr");
        Intrinsics.checkNotNullParameter(obj4, "isTradeUnionMatchNotification");
        this.avatar = str;
        this.birthday = j;
        this.code = str2;
        this.country = str3;
        this.countryIcon = str4;
        this.defaultAvatar = z;
        this.description = obj;
        this.externalId = str5;
        this.id = i;
        this.isAgentMgr = obj2;
        this.isShowAge = num;
        this.isTradeUnion = obj3;
        this.isTradeUnionMatchNotification = obj4;
        this.isVip = z2;
        this.nick = str6;
        this.sex = i2;
        this.medalInfo = arrayList;
        this.isPrettyCode = bool;
        this.wealthUserGrade = j2;
        this.charmUserGrade = j3;
        this.activityUserGrade = j4;
        this.noble = nobleInfo;
        this.svip = svipData;
        this.isCountryId = bool2;
        this.idFrameType = num2;
    }

    public final boolean checkNotOfficialStaffAndMy() {
        String str;
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        if (user != null && !user.isOfficialStaff()) {
            String str2 = this.externalId;
            User user2 = companion.getShared().getUser();
            if (user2 != null) {
                str = user2.getExternalId();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(str2, str)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final Object getIsAgentMgr() {
        return this.isAgentMgr;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Integer getIsShowAge() {
        return this.isShowAge;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Object getIsTradeUnion() {
        return this.isTradeUnion;
    }

    @NotNull
    /* renamed from: component13, reason: from getter */
    public final Object getIsTradeUnionMatchNotification() {
        return this.isTradeUnionMatchNotification;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getIsVip() {
        return this.isVip;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* renamed from: component16, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    @Nullable
    public final ArrayList<MedalInfo> component17() {
        return this.medalInfo;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final Boolean getIsPrettyCode() {
        return this.isPrettyCode;
    }

    /* renamed from: component19, reason: from getter */
    public final long getWealthUserGrade() {
        return this.wealthUserGrade;
    }

    /* renamed from: component2, reason: from getter */
    public final long getBirthday() {
        return this.birthday;
    }

    /* renamed from: component20, reason: from getter */
    public final long getCharmUserGrade() {
        return this.charmUserGrade;
    }

    /* renamed from: component21, reason: from getter */
    public final long getActivityUserGrade() {
        return this.activityUserGrade;
    }

    @Nullable
    /* renamed from: component22, reason: from getter */
    public final NobleInfo getNoble() {
        return this.noble;
    }

    @Nullable
    /* renamed from: component23, reason: from getter */
    public final SvipData getSvip() {
        return this.svip;
    }

    @Nullable
    /* renamed from: component24, reason: from getter */
    public final Boolean getIsCountryId() {
        return this.isCountryId;
    }

    @Nullable
    /* renamed from: component25, reason: from getter */
    public final Integer getIdFrameType() {
        return this.idFrameType;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getDefaultAvatar() {
        return this.defaultAvatar;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final Object getDescription() {
        return this.description;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    /* renamed from: component9, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    public final CelebrityOrCharmUserBase copy(@Nullable String avatar, long birthday, @NotNull String code, @NotNull String country, @NotNull String countryIcon, boolean defaultAvatar, @NotNull Object description, @NotNull String externalId, int id2, @NotNull Object isAgentMgr, @Nullable Integer isShowAge, @Nullable Object isTradeUnion, @NotNull Object isTradeUnionMatchNotification, boolean isVip, @Nullable String nick, int sex, @Nullable ArrayList<MedalInfo> medalInfo, @Nullable Boolean isPrettyCode, long wealthUserGrade, long charmUserGrade, long activityUserGrade, @Nullable NobleInfo noble, @Nullable SvipData svip, @Nullable Boolean isCountryId, @Nullable Integer idFrameType) {
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(countryIcon, "countryIcon");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(isAgentMgr, "isAgentMgr");
        Intrinsics.checkNotNullParameter(isTradeUnionMatchNotification, "isTradeUnionMatchNotification");
        return new CelebrityOrCharmUserBase(avatar, birthday, code, country, countryIcon, defaultAvatar, description, externalId, id2, isAgentMgr, isShowAge, isTradeUnion, isTradeUnionMatchNotification, isVip, nick, sex, medalInfo, isPrettyCode, wealthUserGrade, charmUserGrade, activityUserGrade, noble, svip, isCountryId, idFrameType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CelebrityOrCharmUserBase)) {
            return false;
        }
        CelebrityOrCharmUserBase celebrityOrCharmUserBase = (CelebrityOrCharmUserBase) other;
        return Intrinsics.areEqual(this.avatar, celebrityOrCharmUserBase.avatar) && this.birthday == celebrityOrCharmUserBase.birthday && Intrinsics.areEqual(this.code, celebrityOrCharmUserBase.code) && Intrinsics.areEqual(this.country, celebrityOrCharmUserBase.country) && Intrinsics.areEqual(this.countryIcon, celebrityOrCharmUserBase.countryIcon) && this.defaultAvatar == celebrityOrCharmUserBase.defaultAvatar && Intrinsics.areEqual(this.description, celebrityOrCharmUserBase.description) && Intrinsics.areEqual(this.externalId, celebrityOrCharmUserBase.externalId) && this.id == celebrityOrCharmUserBase.id && Intrinsics.areEqual(this.isAgentMgr, celebrityOrCharmUserBase.isAgentMgr) && Intrinsics.areEqual(this.isShowAge, celebrityOrCharmUserBase.isShowAge) && Intrinsics.areEqual(this.isTradeUnion, celebrityOrCharmUserBase.isTradeUnion) && Intrinsics.areEqual(this.isTradeUnionMatchNotification, celebrityOrCharmUserBase.isTradeUnionMatchNotification) && this.isVip == celebrityOrCharmUserBase.isVip && Intrinsics.areEqual(this.nick, celebrityOrCharmUserBase.nick) && this.sex == celebrityOrCharmUserBase.sex && Intrinsics.areEqual(this.medalInfo, celebrityOrCharmUserBase.medalInfo) && Intrinsics.areEqual(this.isPrettyCode, celebrityOrCharmUserBase.isPrettyCode) && this.wealthUserGrade == celebrityOrCharmUserBase.wealthUserGrade && this.charmUserGrade == celebrityOrCharmUserBase.charmUserGrade && this.activityUserGrade == celebrityOrCharmUserBase.activityUserGrade && Intrinsics.areEqual(this.noble, celebrityOrCharmUserBase.noble) && Intrinsics.areEqual(this.svip, celebrityOrCharmUserBase.svip) && Intrinsics.areEqual(this.isCountryId, celebrityOrCharmUserBase.isCountryId) && Intrinsics.areEqual(this.idFrameType, celebrityOrCharmUserBase.idFrameType);
    }

    public final long getActivityUserGrade() {
        return this.activityUserGrade;
    }

    @Nullable
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

    public final boolean getDefaultAvatar() {
        return this.defaultAvatar;
    }

    @NotNull
    public final Object getDescription() {
        return this.description;
    }

    @NotNull
    public final String getExternalId() {
        return this.externalId;
    }

    public final int getId() {
        return this.id;
    }

    @Nullable
    public final Integer getIdFrameType() {
        return this.idFrameType;
    }

    @Nullable
    public final ArrayList<MedalInfo> getMedalInfo() {
        return this.medalInfo;
    }

    @Nullable
    public final String getNick() {
        return this.nick;
    }

    @Nullable
    public final NobleInfo getNoble() {
        return this.noble;
    }

    public final int getSex() {
        return this.sex;
    }

    @Nullable
    public final SvipData getSvip() {
        return this.svip;
    }

    public final long getWealthUserGrade() {
        return this.wealthUserGrade;
    }

    public int hashCode() {
        String str = this.avatar;
        int hashCode = (((((((((((((((((((str == null ? 0 : str.hashCode()) * 31) + c.a(this.birthday)) * 31) + this.code.hashCode()) * 31) + this.country.hashCode()) * 31) + this.countryIcon.hashCode()) * 31) + a.a(this.defaultAvatar)) * 31) + this.description.hashCode()) * 31) + this.externalId.hashCode()) * 31) + this.id) * 31) + this.isAgentMgr.hashCode()) * 31;
        Integer num = this.isShowAge;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Object obj = this.isTradeUnion;
        int hashCode3 = (((((hashCode2 + (obj == null ? 0 : obj.hashCode())) * 31) + this.isTradeUnionMatchNotification.hashCode()) * 31) + a.a(this.isVip)) * 31;
        String str2 = this.nick;
        int hashCode4 = (((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.sex) * 31;
        ArrayList<MedalInfo> arrayList = this.medalInfo;
        int hashCode5 = (hashCode4 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        Boolean bool = this.isPrettyCode;
        int hashCode6 = (((((((hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31) + c.a(this.wealthUserGrade)) * 31) + c.a(this.charmUserGrade)) * 31) + c.a(this.activityUserGrade)) * 31;
        NobleInfo nobleInfo = this.noble;
        int hashCode7 = (hashCode6 + (nobleInfo == null ? 0 : nobleInfo.hashCode())) * 31;
        SvipData svipData = this.svip;
        int hashCode8 = (hashCode7 + (svipData == null ? 0 : svipData.hashCode())) * 31;
        Boolean bool2 = this.isCountryId;
        int hashCode9 = (hashCode8 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num2 = this.idFrameType;
        return hashCode9 + (num2 != null ? num2.hashCode() : 0);
    }

    @NotNull
    public final Object isAgentMgr() {
        return this.isAgentMgr;
    }

    @Nullable
    public final Boolean isCountryId() {
        return this.isCountryId;
    }

    @Nullable
    public final Boolean isPrettyCode() {
        return this.isPrettyCode;
    }

    @Nullable
    public final Integer isShowAge() {
        return this.isShowAge;
    }

    @Nullable
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

    public final void setActivityUserGrade(long j) {
        this.activityUserGrade = j;
    }

    public final void setCharmUserGrade(long j) {
        this.charmUserGrade = j;
    }

    public final void setCountryId(@Nullable Boolean bool) {
        this.isCountryId = bool;
    }

    public final void setIdFrameType(@Nullable Integer num) {
        this.idFrameType = num;
    }

    public final void setMedalInfo(@Nullable ArrayList<MedalInfo> arrayList) {
        this.medalInfo = arrayList;
    }

    public final void setNoble(@Nullable NobleInfo nobleInfo) {
        this.noble = nobleInfo;
    }

    public final void setPrettyCode(@Nullable Boolean bool) {
        this.isPrettyCode = bool;
    }

    public final void setSvip(@Nullable SvipData svipData) {
        this.svip = svipData;
    }

    public final void setWealthUserGrade(long j) {
        this.wealthUserGrade = j;
    }

    @NotNull
    public String toString() {
        return "CelebrityOrCharmUserBase(avatar=" + this.avatar + ", birthday=" + this.birthday + ", code=" + this.code + ", country=" + this.country + ", countryIcon=" + this.countryIcon + ", defaultAvatar=" + this.defaultAvatar + ", description=" + this.description + ", externalId=" + this.externalId + ", id=" + this.id + ", isAgentMgr=" + this.isAgentMgr + ", isShowAge=" + this.isShowAge + ", isTradeUnion=" + this.isTradeUnion + ", isTradeUnionMatchNotification=" + this.isTradeUnionMatchNotification + ", isVip=" + this.isVip + ", nick=" + this.nick + ", sex=" + this.sex + ", medalInfo=" + this.medalInfo + ", isPrettyCode=" + this.isPrettyCode + ", wealthUserGrade=" + this.wealthUserGrade + ", charmUserGrade=" + this.charmUserGrade + ", activityUserGrade=" + this.activityUserGrade + ", noble=" + this.noble + ", svip=" + this.svip + ", isCountryId=" + this.isCountryId + ", idFrameType=" + this.idFrameType + ")";
    }

    public /* synthetic */ CelebrityOrCharmUserBase(String str, long j, String str2, String str3, String str4, boolean z, Object obj, String str5, int i, Object obj2, Integer num, Object obj3, Object obj4, boolean z2, String str6, int i2, ArrayList arrayList, Boolean bool, long j2, long j3, long j4, NobleInfo nobleInfo, SvipData svipData, Boolean bool2, Integer num2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, str2, str3, str4, z, obj, str5, i, obj2, num, obj3, obj4, z2, str6, (i3 & 32768) != 0 ? 0 : i2, (i3 & 65536) != 0 ? null : arrayList, (i3 & 131072) != 0 ? Boolean.FALSE : bool, (i3 & 262144) != 0 ? -1L : j2, (i3 & 524288) != 0 ? -1L : j3, (i3 & AgoraRtcService.CUSTOM_REMOTE_VIDEO_IDLE) != 0 ? -1L : j4, (i3 & 2097152) != 0 ? null : nobleInfo, (i3 & 4194304) != 0 ? null : svipData, (i3 & 8388608) != 0 ? null : bool2, (i3 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? null : num2);
    }
}
