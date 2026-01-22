package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.RideBean;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2Connection;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bJ\b\u0086\b\u0018\u0000 k2\u00020\u0001:\u0001kBß\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r\u0012\b\b\u0002\u0010\u001c\u001a\u00020\r\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b#\u0010$J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0007HÆ\u0003J\t\u0010O\u001a\u00020\u0007HÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\rHÆ\u0003J\t\u0010T\u001a\u00020\u000fHÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u000fHÆ\u0003J\u0010\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00105J\t\u0010Y\u001a\u00020\u000fHÆ\u0003J\t\u0010Z\u001a\u00020\u000fHÆ\u0003J\t\u0010[\u001a\u00020\u0005HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u0007HÆ\u0003J\t\u0010`\u001a\u00020\rHÆ\u0003J\t\u0010a\u001a\u00020\rHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010 HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\"HÆ\u0003J\u0090\u0002\u0010e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"HÆ\u0001¢\u0006\u0002\u0010fJ\u0013\u0010g\u001a\u00020\r2\b\u0010h\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010i\u001a\u00020\u0003HÖ\u0001J\t\u0010j\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010(R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010&R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u00102R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00106\u001a\u0004\b\u0013\u00105R\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u00102R\u0011\u0010\u0015\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u00102R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010(R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010&R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010&R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010&R\u0011\u0010\u001a\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b;\u0010*R\u001a\u0010\u001b\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u00100\"\u0004\b<\u0010=R\u001a\u0010\u001c\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00100\"\u0004\b?\u0010=R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010K¨\u0006l"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MemberBean;", "Ljava/io/Serializable;", "activityUserGrade", "", "avatar", "", "birthday", "", "charmUserGrade", Constants.KEY_HTTP_CODE, "country", "countryIcon", "defaultAvatar", "", "description", "", SupportGiftRankActivity.EXTERNAL_ID, AgooConstants.MESSAGE_ID, "isAgentMgr", "isShowAge", "isTradeUnion", "isTradeUnionMatchNotification", "nick", "onlineStatus", "role", "sex", "wealthUserGrade", "isVip", "inRoom", "ride", "Lcom/qiahao/base_common/model/common/RideBean;", "noble", "Lcom/qiahao/base_common/model/common/NobleInfo;", "svip", "Lcom/qiahao/base_common/model/svip/SvipData;", "<init>", "(ILjava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;Ljava/lang/String;ILjava/lang/Object;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;IIIJZZLcom/qiahao/base_common/model/common/RideBean;Lcom/qiahao/base_common/model/common/NobleInfo;Lcom/qiahao/base_common/model/svip/SvipData;)V", "getActivityUserGrade", "()I", "getAvatar", "()Ljava/lang/String;", "getBirthday", "()J", "getCharmUserGrade", "getCode", "getCountry", "getCountryIcon", "getDefaultAvatar", "()Z", "getDescription", "()Ljava/lang/Object;", "getExternalId", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNick", "getOnlineStatus", "getRole", "getSex", "getWealthUserGrade", "setVip", "(Z)V", "getInRoom", "setInRoom", "getRide", "()Lcom/qiahao/base_common/model/common/RideBean;", "setRide", "(Lcom/qiahao/base_common/model/common/RideBean;)V", "getNoble", "()Lcom/qiahao/base_common/model/common/NobleInfo;", "setNoble", "(Lcom/qiahao/base_common/model/common/NobleInfo;)V", "getSvip", "()Lcom/qiahao/base_common/model/svip/SvipData;", "setSvip", "(Lcom/qiahao/base_common/model/svip/SvipData;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "(ILjava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;Ljava/lang/String;ILjava/lang/Object;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;IIIJZZLcom/qiahao/base_common/model/common/RideBean;Lcom/qiahao/base_common/model/common/NobleInfo;Lcom/qiahao/base_common/model/svip/SvipData;)Lcom/qiahao/nextvideo/data/model/MemberBean;", "equals", "other", "hashCode", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MemberBean implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int activityUserGrade;

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
    private final boolean defaultAvatar;

    @NotNull
    private final Object description;

    @NotNull
    private final String externalId;
    private final int id;
    private boolean inRoom;

    @NotNull
    private final Object isAgentMgr;

    @Nullable
    private final Integer isShowAge;

    @NotNull
    private final Object isTradeUnion;

    @NotNull
    private final Object isTradeUnionMatchNotification;
    private boolean isVip;

    @NotNull
    private final String nick;

    @Nullable
    private NobleInfo noble;
    private final int onlineStatus;

    @Nullable
    private RideBean ride;
    private final int role;
    private final int sex;

    @Nullable
    private SvipData svip;
    private final long wealthUserGrade;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MemberBean$Companion;", "", "<init>", "()V", "empty", "Lcom/qiahao/nextvideo/data/model/MemberBean;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MemberBean empty() {
            int i = 0;
            return new MemberBean(0, "", 0L, 0L, "", "", "", false, "", "", 0, i, i, i, i, "", 0, 0, 0, 0L, false, false, null, null, null, 25165824, null);
        }

        private Companion() {
        }
    }

    public MemberBean(int i, @NotNull String str, long j, long j2, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z, @NotNull Object obj, @NotNull String str5, int i2, @NotNull Object obj2, @Nullable Integer num, @NotNull Object obj3, @NotNull Object obj4, @NotNull String str6, int i3, int i4, int i5, long j3, boolean z2, boolean z3, @Nullable RideBean rideBean, @Nullable NobleInfo nobleInfo, @Nullable SvipData svipData) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str3, "country");
        Intrinsics.checkNotNullParameter(str4, "countryIcon");
        Intrinsics.checkNotNullParameter(obj, "description");
        Intrinsics.checkNotNullParameter(str5, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(obj2, "isAgentMgr");
        Intrinsics.checkNotNullParameter(obj3, "isTradeUnion");
        Intrinsics.checkNotNullParameter(obj4, "isTradeUnionMatchNotification");
        Intrinsics.checkNotNullParameter(str6, "nick");
        this.activityUserGrade = i;
        this.avatar = str;
        this.birthday = j;
        this.charmUserGrade = j2;
        this.code = str2;
        this.country = str3;
        this.countryIcon = str4;
        this.defaultAvatar = z;
        this.description = obj;
        this.externalId = str5;
        this.id = i2;
        this.isAgentMgr = obj2;
        this.isShowAge = num;
        this.isTradeUnion = obj3;
        this.isTradeUnionMatchNotification = obj4;
        this.nick = str6;
        this.onlineStatus = i3;
        this.role = i4;
        this.sex = i5;
        this.wealthUserGrade = j3;
        this.isVip = z2;
        this.inRoom = z3;
        this.ride = rideBean;
        this.noble = nobleInfo;
        this.svip = svipData;
    }

    /* renamed from: component1, reason: from getter */
    public final int getActivityUserGrade() {
        return this.activityUserGrade;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    /* renamed from: component11, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final Object getIsAgentMgr() {
        return this.isAgentMgr;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final Integer getIsShowAge() {
        return this.isShowAge;
    }

    @NotNull
    /* renamed from: component14, reason: from getter */
    public final Object getIsTradeUnion() {
        return this.isTradeUnion;
    }

    @NotNull
    /* renamed from: component15, reason: from getter */
    public final Object getIsTradeUnionMatchNotification() {
        return this.isTradeUnionMatchNotification;
    }

    @NotNull
    /* renamed from: component16, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* renamed from: component17, reason: from getter */
    public final int getOnlineStatus() {
        return this.onlineStatus;
    }

    /* renamed from: component18, reason: from getter */
    public final int getRole() {
        return this.role;
    }

    /* renamed from: component19, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component20, reason: from getter */
    public final long getWealthUserGrade() {
        return this.wealthUserGrade;
    }

    /* renamed from: component21, reason: from getter */
    public final boolean getIsVip() {
        return this.isVip;
    }

    /* renamed from: component22, reason: from getter */
    public final boolean getInRoom() {
        return this.inRoom;
    }

    @Nullable
    /* renamed from: component23, reason: from getter */
    public final RideBean getRide() {
        return this.ride;
    }

    @Nullable
    /* renamed from: component24, reason: from getter */
    public final NobleInfo getNoble() {
        return this.noble;
    }

    @Nullable
    /* renamed from: component25, reason: from getter */
    public final SvipData getSvip() {
        return this.svip;
    }

    /* renamed from: component3, reason: from getter */
    public final long getBirthday() {
        return this.birthday;
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

    /* renamed from: component8, reason: from getter */
    public final boolean getDefaultAvatar() {
        return this.defaultAvatar;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final Object getDescription() {
        return this.description;
    }

    @NotNull
    public final MemberBean copy(int activityUserGrade, @NotNull String avatar, long birthday, long charmUserGrade, @NotNull String code, @NotNull String country, @NotNull String countryIcon, boolean defaultAvatar, @NotNull Object description, @NotNull String externalId, int id2, @NotNull Object isAgentMgr, @Nullable Integer isShowAge, @NotNull Object isTradeUnion, @NotNull Object isTradeUnionMatchNotification, @NotNull String nick, int onlineStatus, int role, int sex, long wealthUserGrade, boolean isVip, boolean inRoom, @Nullable RideBean ride, @Nullable NobleInfo noble, @Nullable SvipData svip) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(countryIcon, "countryIcon");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(isAgentMgr, "isAgentMgr");
        Intrinsics.checkNotNullParameter(isTradeUnion, "isTradeUnion");
        Intrinsics.checkNotNullParameter(isTradeUnionMatchNotification, "isTradeUnionMatchNotification");
        Intrinsics.checkNotNullParameter(nick, "nick");
        return new MemberBean(activityUserGrade, avatar, birthday, charmUserGrade, code, country, countryIcon, defaultAvatar, description, externalId, id2, isAgentMgr, isShowAge, isTradeUnion, isTradeUnionMatchNotification, nick, onlineStatus, role, sex, wealthUserGrade, isVip, inRoom, ride, noble, svip);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberBean)) {
            return false;
        }
        MemberBean memberBean = (MemberBean) other;
        return this.activityUserGrade == memberBean.activityUserGrade && Intrinsics.areEqual(this.avatar, memberBean.avatar) && this.birthday == memberBean.birthday && this.charmUserGrade == memberBean.charmUserGrade && Intrinsics.areEqual(this.code, memberBean.code) && Intrinsics.areEqual(this.country, memberBean.country) && Intrinsics.areEqual(this.countryIcon, memberBean.countryIcon) && this.defaultAvatar == memberBean.defaultAvatar && Intrinsics.areEqual(this.description, memberBean.description) && Intrinsics.areEqual(this.externalId, memberBean.externalId) && this.id == memberBean.id && Intrinsics.areEqual(this.isAgentMgr, memberBean.isAgentMgr) && Intrinsics.areEqual(this.isShowAge, memberBean.isShowAge) && Intrinsics.areEqual(this.isTradeUnion, memberBean.isTradeUnion) && Intrinsics.areEqual(this.isTradeUnionMatchNotification, memberBean.isTradeUnionMatchNotification) && Intrinsics.areEqual(this.nick, memberBean.nick) && this.onlineStatus == memberBean.onlineStatus && this.role == memberBean.role && this.sex == memberBean.sex && this.wealthUserGrade == memberBean.wealthUserGrade && this.isVip == memberBean.isVip && this.inRoom == memberBean.inRoom && Intrinsics.areEqual(this.ride, memberBean.ride) && Intrinsics.areEqual(this.noble, memberBean.noble) && Intrinsics.areEqual(this.svip, memberBean.svip);
    }

    public final int getActivityUserGrade() {
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

    public final boolean getInRoom() {
        return this.inRoom;
    }

    @NotNull
    public final String getNick() {
        return this.nick;
    }

    @Nullable
    public final NobleInfo getNoble() {
        return this.noble;
    }

    public final int getOnlineStatus() {
        return this.onlineStatus;
    }

    @Nullable
    public final RideBean getRide() {
        return this.ride;
    }

    public final int getRole() {
        return this.role;
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
        int hashCode = ((((((((((((((((((((((this.activityUserGrade * 31) + this.avatar.hashCode()) * 31) + c.a(this.birthday)) * 31) + c.a(this.charmUserGrade)) * 31) + this.code.hashCode()) * 31) + this.country.hashCode()) * 31) + this.countryIcon.hashCode()) * 31) + a.a(this.defaultAvatar)) * 31) + this.description.hashCode()) * 31) + this.externalId.hashCode()) * 31) + this.id) * 31) + this.isAgentMgr.hashCode()) * 31;
        Integer num = this.isShowAge;
        int hashCode2 = (((((((((((((((((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.isTradeUnion.hashCode()) * 31) + this.isTradeUnionMatchNotification.hashCode()) * 31) + this.nick.hashCode()) * 31) + this.onlineStatus) * 31) + this.role) * 31) + this.sex) * 31) + c.a(this.wealthUserGrade)) * 31) + a.a(this.isVip)) * 31) + a.a(this.inRoom)) * 31;
        RideBean rideBean = this.ride;
        int hashCode3 = (hashCode2 + (rideBean == null ? 0 : rideBean.hashCode())) * 31;
        NobleInfo nobleInfo = this.noble;
        int hashCode4 = (hashCode3 + (nobleInfo == null ? 0 : nobleInfo.hashCode())) * 31;
        SvipData svipData = this.svip;
        return hashCode4 + (svipData != null ? svipData.hashCode() : 0);
    }

    @NotNull
    public final Object isAgentMgr() {
        return this.isAgentMgr;
    }

    @Nullable
    public final Integer isShowAge() {
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

    public final void setInRoom(boolean z) {
        this.inRoom = z;
    }

    public final void setNoble(@Nullable NobleInfo nobleInfo) {
        this.noble = nobleInfo;
    }

    public final void setRide(@Nullable RideBean rideBean) {
        this.ride = rideBean;
    }

    public final void setSvip(@Nullable SvipData svipData) {
        this.svip = svipData;
    }

    public final void setVip(boolean z) {
        this.isVip = z;
    }

    @NotNull
    public String toString() {
        return "MemberBean(activityUserGrade=" + this.activityUserGrade + ", avatar=" + this.avatar + ", birthday=" + this.birthday + ", charmUserGrade=" + this.charmUserGrade + ", code=" + this.code + ", country=" + this.country + ", countryIcon=" + this.countryIcon + ", defaultAvatar=" + this.defaultAvatar + ", description=" + this.description + ", externalId=" + this.externalId + ", id=" + this.id + ", isAgentMgr=" + this.isAgentMgr + ", isShowAge=" + this.isShowAge + ", isTradeUnion=" + this.isTradeUnion + ", isTradeUnionMatchNotification=" + this.isTradeUnionMatchNotification + ", nick=" + this.nick + ", onlineStatus=" + this.onlineStatus + ", role=" + this.role + ", sex=" + this.sex + ", wealthUserGrade=" + this.wealthUserGrade + ", isVip=" + this.isVip + ", inRoom=" + this.inRoom + ", ride=" + this.ride + ", noble=" + this.noble + ", svip=" + this.svip + ")";
    }

    public /* synthetic */ MemberBean(int i, String str, long j, long j2, String str2, String str3, String str4, boolean z, Object obj, String str5, int i2, Object obj2, Integer num, Object obj3, Object obj4, String str6, int i3, int i4, int i5, long j3, boolean z2, boolean z3, RideBean rideBean, NobleInfo nobleInfo, SvipData svipData, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, j, j2, str2, str3, str4, z, obj, str5, i2, obj2, num, obj3, obj4, str6, i3, i4, i5, j3, (i6 & AgoraRtcService.CUSTOM_REMOTE_VIDEO_IDLE) != 0 ? false : z2, (i6 & 2097152) != 0 ? false : z3, rideBean, (i6 & 8388608) != 0 ? null : nobleInfo, (i6 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? null : svipData);
    }
}
