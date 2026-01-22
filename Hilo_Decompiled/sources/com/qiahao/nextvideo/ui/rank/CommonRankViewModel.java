package com.qiahao.nextvideo.ui.rank;

import androidx.annotation.Keep;
import com.qiahao.base_common.model.common.MedalInfo;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bH\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010J\u001a\u00020\fJ\u0006\u0010K\u001a\u00020\fJ\t\u0010L\u001a\u00020\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0007HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\nHÆ\u0003J\t\u0010R\u001a\u00020\fHÆ\u0003J\t\u0010S\u001a\u00020\nHÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010V\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00100J\t\u0010X\u001a\u00020\nHÆ\u0003J\t\u0010Y\u001a\u00020\nHÆ\u0003J\t\u0010Z\u001a\u00020\nHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u0010\u0010^\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010_\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010+Jð\u0001\u0010`\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010aJ\u0013\u0010b\u001a\u00020\f2\b\u0010c\u001a\u0004\u0018\u00010dHÖ\u0003J\t\u0010e\u001a\u00020\u0007HÖ\u0001J\t\u0010f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010)R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010,\u001a\u0004\b\u000e\u0010+R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b\u0013\u00100\"\u0004\b1\u00102R\u001a\u0010\u0014\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010(\"\u0004\b5\u00106R\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010(\"\u0004\b8\u00106R\u001a\u0010\u0016\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010(\"\u0004\b:\u00106R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010!\"\u0004\b@\u0010AR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001e\u0010\u001c\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b\u001c\u00100\"\u0004\bF\u00102R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\bG\u0010+\"\u0004\bH\u0010I¨\u0006g"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/CommonRankViewModel;", "Ljava/io/Serializable;", SupportGiftRankActivity.EXTERNAL_ID, "", TUIConstants.TUIChat.FACE_URL, "name", "sex", "", AgooConstants.MESSAGE_ID, ExchangeDetailActivity.TYPE_DIAMOND, "", "isVip", "", "birthday", "isShowAge", "country", "medalInfo", "", "Lcom/qiahao/base_common/model/common/MedalInfo;", "isPrettyCode", "wealthUserGrade", "charmUserGrade", "activityUserGrade", "noble", "Lcom/qiahao/base_common/model/common/NobleInfo;", "password", "svip", "Lcom/qiahao/base_common/model/svip/SvipData;", "isCountryId", "idFrameType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JZJLjava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;JJJLcom/qiahao/base_common/model/common/NobleInfo;Ljava/lang/String;Lcom/qiahao/base_common/model/svip/SvipData;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getExternalId", "()Ljava/lang/String;", "getFaceUrl", "getName", "getSex", "()I", "getId", "getDiamond", "()J", "()Z", "getBirthday", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCountry", "getMedalInfo", "()Ljava/util/List;", "()Ljava/lang/Boolean;", "setPrettyCode", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getWealthUserGrade", "setWealthUserGrade", "(J)V", "getCharmUserGrade", "setCharmUserGrade", "getActivityUserGrade", "setActivityUserGrade", "getNoble", "()Lcom/qiahao/base_common/model/common/NobleInfo;", "setNoble", "(Lcom/qiahao/base_common/model/common/NobleInfo;)V", "getPassword", "setPassword", "(Ljava/lang/String;)V", "getSvip", "()Lcom/qiahao/base_common/model/svip/SvipData;", "setSvip", "(Lcom/qiahao/base_common/model/svip/SvipData;)V", "setCountryId", "getIdFrameType", "setIdFrameType", "(Ljava/lang/Integer;)V", "getHasPassWord", "checkNotOfficialStaff", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JZJLjava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;JJJLcom/qiahao/base_common/model/common/NobleInfo;Ljava/lang/String;Lcom/qiahao/base_common/model/svip/SvipData;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/ui/rank/CommonRankViewModel;", "equals", "other", "", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CommonRankViewModel implements Serializable {
    private long activityUserGrade;
    private final long birthday;
    private long charmUserGrade;

    @Nullable
    private final String country;
    private final long diamond;

    @NotNull
    private final String externalId;

    @Nullable
    private final String faceUrl;

    @NotNull
    private final String id;

    @Nullable
    private Integer idFrameType;

    @Nullable
    private Boolean isCountryId;

    @Nullable
    private Boolean isPrettyCode;

    @Nullable
    private final Integer isShowAge;
    private final boolean isVip;

    @Nullable
    private final List<MedalInfo> medalInfo;

    @NotNull
    private final String name;

    @Nullable
    private NobleInfo noble;

    @Nullable
    private String password;
    private final int sex;

    @Nullable
    private SvipData svip;
    private long wealthUserGrade;

    public CommonRankViewModel(@NotNull String str, @Nullable String str2, @NotNull String str3, int i, @NotNull String str4, long j, boolean z, long j2, @Nullable Integer num, @Nullable String str5, @Nullable List<MedalInfo> list, @Nullable Boolean bool, long j3, long j4, long j5, @Nullable NobleInfo nobleInfo, @Nullable String str6, @Nullable SvipData svipData, @Nullable Boolean bool2, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(str, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, AgooConstants.MESSAGE_ID);
        this.externalId = str;
        this.faceUrl = str2;
        this.name = str3;
        this.sex = i;
        this.id = str4;
        this.diamond = j;
        this.isVip = z;
        this.birthday = j2;
        this.isShowAge = num;
        this.country = str5;
        this.medalInfo = list;
        this.isPrettyCode = bool;
        this.wealthUserGrade = j3;
        this.charmUserGrade = j4;
        this.activityUserGrade = j5;
        this.noble = nobleInfo;
        this.password = str6;
        this.svip = svipData;
        this.isCountryId = bool2;
        this.idFrameType = num2;
    }

    public final boolean checkNotOfficialStaff() {
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || user.isOfficialStaff()) {
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    public final List<MedalInfo> component11() {
        return this.medalInfo;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Boolean getIsPrettyCode() {
        return this.isPrettyCode;
    }

    /* renamed from: component13, reason: from getter */
    public final long getWealthUserGrade() {
        return this.wealthUserGrade;
    }

    /* renamed from: component14, reason: from getter */
    public final long getCharmUserGrade() {
        return this.charmUserGrade;
    }

    /* renamed from: component15, reason: from getter */
    public final long getActivityUserGrade() {
        return this.activityUserGrade;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final NobleInfo getNoble() {
        return this.noble;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final String getPassword() {
        return this.password;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final SvipData getSvip() {
        return this.svip;
    }

    @Nullable
    /* renamed from: component19, reason: from getter */
    public final Boolean getIsCountryId() {
        return this.isCountryId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    @Nullable
    /* renamed from: component20, reason: from getter */
    public final Integer getIdFrameType() {
        return this.idFrameType;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component6, reason: from getter */
    public final long getDiamond() {
        return this.diamond;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsVip() {
        return this.isVip;
    }

    /* renamed from: component8, reason: from getter */
    public final long getBirthday() {
        return this.birthday;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Integer getIsShowAge() {
        return this.isShowAge;
    }

    @NotNull
    public final CommonRankViewModel copy(@NotNull String externalId, @Nullable String faceUrl, @NotNull String name, int sex, @NotNull String id2, long diamond, boolean isVip, long birthday, @Nullable Integer isShowAge, @Nullable String country, @Nullable List<MedalInfo> medalInfo, @Nullable Boolean isPrettyCode, long wealthUserGrade, long charmUserGrade, long activityUserGrade, @Nullable NobleInfo noble, @Nullable String password, @Nullable SvipData svip, @Nullable Boolean isCountryId, @Nullable Integer idFrameType) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id2, AgooConstants.MESSAGE_ID);
        return new CommonRankViewModel(externalId, faceUrl, name, sex, id2, diamond, isVip, birthday, isShowAge, country, medalInfo, isPrettyCode, wealthUserGrade, charmUserGrade, activityUserGrade, noble, password, svip, isCountryId, idFrameType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonRankViewModel)) {
            return false;
        }
        CommonRankViewModel commonRankViewModel = (CommonRankViewModel) other;
        return Intrinsics.areEqual(this.externalId, commonRankViewModel.externalId) && Intrinsics.areEqual(this.faceUrl, commonRankViewModel.faceUrl) && Intrinsics.areEqual(this.name, commonRankViewModel.name) && this.sex == commonRankViewModel.sex && Intrinsics.areEqual(this.id, commonRankViewModel.id) && this.diamond == commonRankViewModel.diamond && this.isVip == commonRankViewModel.isVip && this.birthday == commonRankViewModel.birthday && Intrinsics.areEqual(this.isShowAge, commonRankViewModel.isShowAge) && Intrinsics.areEqual(this.country, commonRankViewModel.country) && Intrinsics.areEqual(this.medalInfo, commonRankViewModel.medalInfo) && Intrinsics.areEqual(this.isPrettyCode, commonRankViewModel.isPrettyCode) && this.wealthUserGrade == commonRankViewModel.wealthUserGrade && this.charmUserGrade == commonRankViewModel.charmUserGrade && this.activityUserGrade == commonRankViewModel.activityUserGrade && Intrinsics.areEqual(this.noble, commonRankViewModel.noble) && Intrinsics.areEqual(this.password, commonRankViewModel.password) && Intrinsics.areEqual(this.svip, commonRankViewModel.svip) && Intrinsics.areEqual(this.isCountryId, commonRankViewModel.isCountryId) && Intrinsics.areEqual(this.idFrameType, commonRankViewModel.idFrameType);
    }

    public final long getActivityUserGrade() {
        return this.activityUserGrade;
    }

    public final long getBirthday() {
        return this.birthday;
    }

    public final long getCharmUserGrade() {
        return this.charmUserGrade;
    }

    @Nullable
    public final String getCountry() {
        return this.country;
    }

    public final long getDiamond() {
        return this.diamond;
    }

    @NotNull
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    public final boolean getHasPassWord() {
        if (this.password != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final Integer getIdFrameType() {
        return this.idFrameType;
    }

    @Nullable
    public final List<MedalInfo> getMedalInfo() {
        return this.medalInfo;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final NobleInfo getNoble() {
        return this.noble;
    }

    @Nullable
    public final String getPassword() {
        return this.password;
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
        int hashCode = this.externalId.hashCode() * 31;
        String str = this.faceUrl;
        int hashCode2 = (((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.name.hashCode()) * 31) + this.sex) * 31) + this.id.hashCode()) * 31) + androidx.collection.c.a(this.diamond)) * 31) + q2.a.a(this.isVip)) * 31) + androidx.collection.c.a(this.birthday)) * 31;
        Integer num = this.isShowAge;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.country;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<MedalInfo> list = this.medalInfo;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.isPrettyCode;
        int hashCode6 = (((((((hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31) + androidx.collection.c.a(this.wealthUserGrade)) * 31) + androidx.collection.c.a(this.charmUserGrade)) * 31) + androidx.collection.c.a(this.activityUserGrade)) * 31;
        NobleInfo nobleInfo = this.noble;
        int hashCode7 = (hashCode6 + (nobleInfo == null ? 0 : nobleInfo.hashCode())) * 31;
        String str3 = this.password;
        int hashCode8 = (hashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        SvipData svipData = this.svip;
        int hashCode9 = (hashCode8 + (svipData == null ? 0 : svipData.hashCode())) * 31;
        Boolean bool2 = this.isCountryId;
        int hashCode10 = (hashCode9 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num2 = this.idFrameType;
        return hashCode10 + (num2 != null ? num2.hashCode() : 0);
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

    public final void setNoble(@Nullable NobleInfo nobleInfo) {
        this.noble = nobleInfo;
    }

    public final void setPassword(@Nullable String str) {
        this.password = str;
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
        return "CommonRankViewModel(externalId=" + this.externalId + ", faceUrl=" + this.faceUrl + ", name=" + this.name + ", sex=" + this.sex + ", id=" + this.id + ", diamond=" + this.diamond + ", isVip=" + this.isVip + ", birthday=" + this.birthday + ", isShowAge=" + this.isShowAge + ", country=" + this.country + ", medalInfo=" + this.medalInfo + ", isPrettyCode=" + this.isPrettyCode + ", wealthUserGrade=" + this.wealthUserGrade + ", charmUserGrade=" + this.charmUserGrade + ", activityUserGrade=" + this.activityUserGrade + ", noble=" + this.noble + ", password=" + this.password + ", svip=" + this.svip + ", isCountryId=" + this.isCountryId + ", idFrameType=" + this.idFrameType + ")";
    }

    public /* synthetic */ CommonRankViewModel(String str, String str2, String str3, int i, String str4, long j, boolean z, long j2, Integer num, String str5, List list, Boolean bool, long j3, long j4, long j5, NobleInfo nobleInfo, String str6, SvipData svipData, Boolean bool2, Integer num2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i, str4, j, (i2 & 64) != 0 ? false : z, (i2 & 128) != 0 ? 0L : j2, (i2 & 256) != 0 ? null : num, (i2 & 512) != 0 ? "" : str5, (i2 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : list, (i2 & 2048) != 0 ? Boolean.FALSE : bool, (i2 & 4096) != 0 ? -1L : j3, (i2 & 8192) != 0 ? -1L : j4, (i2 & 16384) != 0 ? -1L : j5, (32768 & i2) != 0 ? null : nobleInfo, (65536 & i2) != 0 ? null : str6, (131072 & i2) != 0 ? null : svipData, (262144 & i2) != 0 ? null : bool2, (i2 & 524288) != 0 ? null : num2);
    }
}
