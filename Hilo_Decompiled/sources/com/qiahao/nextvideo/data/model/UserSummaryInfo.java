package com.qiahao.nextvideo.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.base_common.model.common.MedalInfo;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.RideBean;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.qiahao.nextvideo.ui.matchinghistoric.ProfileDetailUIModel;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;
import userProxy.UserProxy;

@Parcelize
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u0084\u00012\u00020\u0001:\u0002\u0084\u0001B\u009d\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\r\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0004\b\"\u0010#J\u0006\u0010_\u001a\u00020\u0010J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010h\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010i\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010j\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010k\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010l\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010m\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010n\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00108J\u000b\u0010o\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0011\u0010p\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0003J\t\u0010q\u001a\u00020\rHÆ\u0003J\t\u0010r\u001a\u00020\rHÆ\u0003J\u0010\u0010s\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010t\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u0010\u0010u\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00108J\u000b\u0010v\u001a\u0004\u0018\u00010!HÆ\u0003J¤\u0002\u0010w\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!HÆ\u0001¢\u0006\u0002\u0010xJ\u0006\u0010y\u001a\u00020\u0005J\u0013\u0010z\u001a\u00020\u00102\b\u0010{\u001a\u0004\u0018\u00010|HÖ\u0003J\t\u0010}\u001a\u00020\u0005HÖ\u0001J\t\u0010~\u001a\u00020\u0003HÖ\u0001J\u001a\u0010\u007f\u001a\u00030\u0080\u00012\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u0005R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010%R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010%\"\u0004\b2\u0010'R\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b\u000e\u0010)R\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b\u000f\u00108\"\u0004\b9\u0010:R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b\u0011\u00108\"\u0004\b<\u0010:R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b\u0012\u00108\"\u0004\b=\u0010:R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b\u0013\u00108\"\u0004\b>\u0010:R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b\u0014\u00108\"\u0004\b?\u0010:R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR&\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001e\u0010\u001a\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001e\u0010\u001b\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010I\"\u0004\bM\u0010KR\"\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\bN\u00104\"\u0004\bO\u00106R \u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010\u001f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b\u001f\u00108\"\u0004\bT\u0010:R\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0011\u0010Y\u001a\u00020Z8F¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0011\u0010]\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b^\u0010%¨\u0006\u0085\u0001"}, d2 = {"Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "Landroid/os/Parcelable;", "countryImage", "", "sex", "", Constants.KEY_HTTP_CODE, "countryName", "name", "avatar", SupportGiftRankActivity.EXTERNAL_ID, "description", "birthday", "", "isShowAge", "isLike", "", "isLikeMe", "isFreeMessage", "isVip", "isPrettyCode", "ride", "Lcom/qiahao/base_common/model/common/RideBean;", "medalInfo", "", "Lcom/qiahao/base_common/model/common/MedalInfo;", "wealthUserGrade", "charmUserGrade", "activityUserGrade", "noble", "Lcom/qiahao/base_common/model/common/NobleInfo;", "isOfficialStaff", "svip", "Lcom/qiahao/base_common/model/svip/SvipData;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/qiahao/base_common/model/common/RideBean;Ljava/util/List;JJLjava/lang/Long;Lcom/qiahao/base_common/model/common/NobleInfo;Ljava/lang/Boolean;Lcom/qiahao/base_common/model/svip/SvipData;)V", "getCountryImage", "()Ljava/lang/String;", "setCountryImage", "(Ljava/lang/String;)V", "getSex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCode", "getCountryName", "setCountryName", "getName", "getAvatar", "getExternalId", "getDescription", "setDescription", "getBirthday", "()Ljava/lang/Long;", "setBirthday", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "()Ljava/lang/Boolean;", "setLike", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setLikeMe", "setFreeMessage", "setVip", "setPrettyCode", "getRide", "()Lcom/qiahao/base_common/model/common/RideBean;", "setRide", "(Lcom/qiahao/base_common/model/common/RideBean;)V", "getMedalInfo", "()Ljava/util/List;", "setMedalInfo", "(Ljava/util/List;)V", "getWealthUserGrade", "()J", "setWealthUserGrade", "(J)V", "getCharmUserGrade", "setCharmUserGrade", "getActivityUserGrade", "setActivityUserGrade", "getNoble", "()Lcom/qiahao/base_common/model/common/NobleInfo;", "setNoble", "(Lcom/qiahao/base_common/model/common/NobleInfo;)V", "setOfficialStaff", "getSvip", "()Lcom/qiahao/base_common/model/svip/SvipData;", "setSvip", "(Lcom/qiahao/base_common/model/svip/SvipData;)V", "country", "Lcom/qiahao/base_common/model/common/Country;", "getCountry", "()Lcom/qiahao/base_common/model/common/Country;", "age", "getAge", "checkNotOfficialStaff", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/qiahao/base_common/model/common/RideBean;Ljava/util/List;JJLjava/lang/Long;Lcom/qiahao/base_common/model/common/NobleInfo;Ljava/lang/Boolean;Lcom/qiahao/base_common/model/svip/SvipData;)Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class UserSummaryInfo implements Parcelable {

    @Nullable
    @c("activityUserGrade")
    private Long activityUserGrade;

    @Nullable
    @c("avatar")
    private final String avatar;

    @Nullable
    @c("birthday")
    private Long birthday;

    @c("charmUserGrade")
    private long charmUserGrade;

    @Nullable
    @c(Constants.KEY_HTTP_CODE)
    private final String code;

    @Nullable
    @c("countryIcon")
    private String countryImage;

    @Nullable
    @c("country")
    private String countryName;

    @Nullable
    @c("description")
    private String description;

    @Nullable
    @c(SupportGiftRankActivity.EXTERNAL_ID)
    private final String externalId;

    @Nullable
    @c("isSession")
    private Boolean isFreeMessage;

    @Nullable
    @c("isLike")
    private Boolean isLike;

    @Nullable
    @c("isLikeMe")
    private Boolean isLikeMe;

    @Nullable
    @c("isOfficialStaff")
    private Boolean isOfficialStaff;

    @Nullable
    private Boolean isPrettyCode;

    @Nullable
    @c("isShowAge")
    private final Integer isShowAge;

    @Nullable
    @c("isVip")
    private Boolean isVip;

    @Nullable
    @c("medalInfo")
    private List<MedalInfo> medalInfo;

    @Nullable
    @c("nick")
    private final String name;

    @Nullable
    @c("noble")
    private NobleInfo noble;

    @Nullable
    private RideBean ride;

    @Nullable
    @c("sex")
    private final Integer sex;

    @Nullable
    private SvipData svip;

    @c("wealthUserGrade")
    private long wealthUserGrade;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<UserSummaryInfo> CREATOR = new Creator();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\bJ\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/data/model/UserSummaryInfo$Companion;", "", "<init>", "()V", "init", "Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "user", "Lcom/qiahao/base_common/model/common/User;", "Lcom/qiahao/nextvideo/ui/matchinghistoric/ProfileDetailUIModel;", "video", "LuserProxy/UserProxy$Video;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UserSummaryInfo init(@NotNull User user) {
            Intrinsics.checkNotNullParameter(user, "user");
            String name = user.getCountryInfo().getName();
            int sex = user.getSex();
            String icon = user.getCountryInfo().getIcon();
            String nick = user.getNick();
            if (nick == null) {
                nick = "";
            }
            String avatar = user.getAvatar();
            String externalId = user.getExternalId();
            String code = user.getCode();
            Boolean isLikeMe = user.isLikeMe();
            Boolean isLike = user.isLike();
            Long birthday = user.getBirthday();
            Integer isShowAge = user.isShowAge();
            RideBean ride = user.getRide();
            NobleInfo noble = user.getNoble();
            boolean isOfficialStaff = user.isOfficialStaff();
            SvipData svip = user.getSvip();
            return new UserSummaryInfo(icon, Integer.valueOf(sex), code, name, nick, avatar, externalId, null, birthday, isShowAge, isLike, isLikeMe, null, null, null, ride, null, 0L, 0L, null, noble, Boolean.valueOf(isOfficialStaff), svip, 1011840, null);
        }

        private Companion() {
        }

        @NotNull
        public final UserSummaryInfo init(@NotNull ProfileDetailUIModel user) {
            Intrinsics.checkNotNullParameter(user, "user");
            String countryName = user.getCountryName();
            int sex = user.getSex();
            String imageUrl = user.getCountryImageUIModel().getImageUrl();
            String nickname = user.getNickname();
            String imageUrl2 = user.getImageUIModel().getImageUrl();
            if (imageUrl2 == null) {
                imageUrl2 = "";
            }
            String str = imageUrl2;
            boolean isLikeMe = user.isLikeMe();
            boolean isLike = user.isLike();
            String uid = user.getUid();
            String code = user.getCode();
            String age = user.getAge();
            return new UserSummaryInfo(imageUrl, Integer.valueOf(sex), code, countryName, nickname, str, uid, null, 0L, Integer.valueOf(((age == null || StringsKt.isBlank(age)) ? 1 : 0) ^ 1), Boolean.valueOf(isLike), Boolean.valueOf(isLikeMe), null, null, null, new RideBean(0, "", "", false, 0, (String) null, (String) null, (String) null, (String) null, (List) null, 1016, (DefaultConstructorMarker) null), null, 0L, 0L, null, null, null, null, 8351872, null);
        }

        @NotNull
        public final UserSummaryInfo init(@NotNull UserProxy.Video video) {
            Intrinsics.checkNotNullParameter(video, "video");
            String country = video.getSendUser().getCountry();
            String countryIcon = video.getSendUser().getCountryIcon();
            String nick = video.getSendUser().getNick();
            String avatar = video.getSendUser().getAvatar();
            boolean isLikeMe = video.getSendUser().getIsLikeMe();
            boolean isLike = video.getSendUser().getIsLike();
            String externalId = video.getSendUser().getExternalId();
            long birthday = video.getSendUser().getBirthday();
            RideBean rideBean = new RideBean(0, "", "", false, 0, (String) null, (String) null, (String) null, (String) null, (List) null, 1016, (DefaultConstructorMarker) null);
            int i = 0;
            Long valueOf = Long.valueOf(birthday);
            Boolean valueOf2 = Boolean.valueOf(isLike);
            return new UserSummaryInfo(countryIcon, i, "", country, nick, avatar, externalId, null, valueOf, null, valueOf2, Boolean.valueOf(isLikeMe), null, null, null, rideBean, null, 0L, 0L, null, null, null, null, 8352384, null);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<UserSummaryInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UserSummaryInfo createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            Boolean valueOf3;
            Boolean valueOf4;
            Boolean valueOf5;
            ArrayList arrayList;
            Boolean valueOf6;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            Integer valueOf7 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            Long valueOf8 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Integer valueOf9 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf2 = null;
            } else {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf3 = null;
            } else {
                valueOf3 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf4 = null;
            } else {
                valueOf4 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf5 = null;
            } else {
                valueOf5 = Boolean.valueOf(parcel.readInt() != 0);
            }
            RideBean readParcelable = parcel.readParcelable(UserSummaryInfo.class.getClassLoader());
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                int i = 0;
                while (i != readInt) {
                    arrayList2.add(parcel.readParcelable(UserSummaryInfo.class.getClassLoader()));
                    i++;
                    readInt = readInt;
                }
                arrayList = arrayList2;
            }
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            Long valueOf10 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            NobleInfo readParcelable2 = parcel.readParcelable(UserSummaryInfo.class.getClassLoader());
            if (parcel.readInt() == 0) {
                valueOf6 = null;
            } else {
                valueOf6 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new UserSummaryInfo(readString, valueOf7, readString2, readString3, readString4, readString5, readString6, readString7, valueOf8, valueOf9, valueOf, valueOf2, valueOf3, valueOf4, valueOf5, readParcelable, arrayList, readLong, readLong2, valueOf10, readParcelable2, valueOf6, parcel.readParcelable(UserSummaryInfo.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UserSummaryInfo[] newArray(int i) {
            return new UserSummaryInfo[i];
        }
    }

    public UserSummaryInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, 0L, null, null, null, null, 8388607, null);
    }

    public final boolean checkNotOfficialStaff() {
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || user.isOfficialStaff()) {
            return false;
        }
        return true;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getCountryImage() {
        return this.countryImage;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Integer getIsShowAge() {
        return this.isShowAge;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Boolean getIsLike() {
        return this.isLike;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Boolean getIsLikeMe() {
        return this.isLikeMe;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final Boolean getIsFreeMessage() {
        return this.isFreeMessage;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final Boolean getIsVip() {
        return this.isVip;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final Boolean getIsPrettyCode() {
        return this.isPrettyCode;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final RideBean getRide() {
        return this.ride;
    }

    @Nullable
    public final List<MedalInfo> component17() {
        return this.medalInfo;
    }

    /* renamed from: component18, reason: from getter */
    public final long getWealthUserGrade() {
        return this.wealthUserGrade;
    }

    /* renamed from: component19, reason: from getter */
    public final long getCharmUserGrade() {
        return this.charmUserGrade;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getSex() {
        return this.sex;
    }

    @Nullable
    /* renamed from: component20, reason: from getter */
    public final Long getActivityUserGrade() {
        return this.activityUserGrade;
    }

    @Nullable
    /* renamed from: component21, reason: from getter */
    public final NobleInfo getNoble() {
        return this.noble;
    }

    @Nullable
    /* renamed from: component22, reason: from getter */
    public final Boolean getIsOfficialStaff() {
        return this.isOfficialStaff;
    }

    @Nullable
    /* renamed from: component23, reason: from getter */
    public final SvipData getSvip() {
        return this.svip;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getCountryName() {
        return this.countryName;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Long getBirthday() {
        return this.birthday;
    }

    @NotNull
    public final UserSummaryInfo copy(@Nullable String countryImage, @Nullable Integer sex, @Nullable String code, @Nullable String countryName, @Nullable String name, @Nullable String avatar, @Nullable String externalId, @Nullable String description, @Nullable Long birthday, @Nullable Integer isShowAge, @Nullable Boolean isLike, @Nullable Boolean isLikeMe, @Nullable Boolean isFreeMessage, @Nullable Boolean isVip, @Nullable Boolean isPrettyCode, @Nullable RideBean ride, @Nullable List<MedalInfo> medalInfo, long wealthUserGrade, long charmUserGrade, @Nullable Long activityUserGrade, @Nullable NobleInfo noble, @Nullable Boolean isOfficialStaff, @Nullable SvipData svip) {
        return new UserSummaryInfo(countryImage, sex, code, countryName, name, avatar, externalId, description, birthday, isShowAge, isLike, isLikeMe, isFreeMessage, isVip, isPrettyCode, ride, medalInfo, wealthUserGrade, charmUserGrade, activityUserGrade, noble, isOfficialStaff, svip);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserSummaryInfo)) {
            return false;
        }
        UserSummaryInfo userSummaryInfo = (UserSummaryInfo) other;
        return Intrinsics.areEqual(this.countryImage, userSummaryInfo.countryImage) && Intrinsics.areEqual(this.sex, userSummaryInfo.sex) && Intrinsics.areEqual(this.code, userSummaryInfo.code) && Intrinsics.areEqual(this.countryName, userSummaryInfo.countryName) && Intrinsics.areEqual(this.name, userSummaryInfo.name) && Intrinsics.areEqual(this.avatar, userSummaryInfo.avatar) && Intrinsics.areEqual(this.externalId, userSummaryInfo.externalId) && Intrinsics.areEqual(this.description, userSummaryInfo.description) && Intrinsics.areEqual(this.birthday, userSummaryInfo.birthday) && Intrinsics.areEqual(this.isShowAge, userSummaryInfo.isShowAge) && Intrinsics.areEqual(this.isLike, userSummaryInfo.isLike) && Intrinsics.areEqual(this.isLikeMe, userSummaryInfo.isLikeMe) && Intrinsics.areEqual(this.isFreeMessage, userSummaryInfo.isFreeMessage) && Intrinsics.areEqual(this.isVip, userSummaryInfo.isVip) && Intrinsics.areEqual(this.isPrettyCode, userSummaryInfo.isPrettyCode) && Intrinsics.areEqual(this.ride, userSummaryInfo.ride) && Intrinsics.areEqual(this.medalInfo, userSummaryInfo.medalInfo) && this.wealthUserGrade == userSummaryInfo.wealthUserGrade && this.charmUserGrade == userSummaryInfo.charmUserGrade && Intrinsics.areEqual(this.activityUserGrade, userSummaryInfo.activityUserGrade) && Intrinsics.areEqual(this.noble, userSummaryInfo.noble) && Intrinsics.areEqual(this.isOfficialStaff, userSummaryInfo.isOfficialStaff) && Intrinsics.areEqual(this.svip, userSummaryInfo.svip);
    }

    @Nullable
    public final Long getActivityUserGrade() {
        return this.activityUserGrade;
    }

    @NotNull
    public final String getAge() {
        long j;
        Long l = this.birthday;
        if (l != null) {
            if (l != null) {
                j = l.longValue();
            } else {
                j = 0;
            }
            if (j > 0) {
                long constantTimeSecs = DateTimeUtilityKt.getConstantTimeSecs();
                Long l2 = this.birthday;
                Intrinsics.checkNotNull(l2);
                return String.valueOf((constantTimeSecs - l2.longValue()) / 31536000);
            }
        }
        return "";
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final Long getBirthday() {
        return this.birthday;
    }

    public final long getCharmUserGrade() {
        return this.charmUserGrade;
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final Country getCountry() {
        String str;
        String str2;
        String str3;
        String str4 = this.countryName;
        if (str4 == null) {
            str = "";
        } else {
            str = str4;
        }
        if (str4 == null) {
            str2 = "";
        } else {
            str2 = str4;
        }
        String str5 = this.countryImage;
        if (str5 == null) {
            str3 = "";
        } else {
            str3 = str5;
        }
        return new Country(str, str3, str2, 0L, (String) null, (String) null, 56, (DefaultConstructorMarker) null);
    }

    @Nullable
    public final String getCountryImage() {
        return this.countryImage;
    }

    @Nullable
    public final String getCountryName() {
        return this.countryName;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    public final List<MedalInfo> getMedalInfo() {
        return this.medalInfo;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final NobleInfo getNoble() {
        return this.noble;
    }

    @Nullable
    public final RideBean getRide() {
        return this.ride;
    }

    @Nullable
    public final Integer getSex() {
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
        String str = this.countryImage;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.sex;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.code;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.countryName;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.name;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.avatar;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.externalId;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.description;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Long l = this.birthday;
        int hashCode9 = (hashCode8 + (l == null ? 0 : l.hashCode())) * 31;
        Integer num2 = this.isShowAge;
        int hashCode10 = (hashCode9 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.isLike;
        int hashCode11 = (hashCode10 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isLikeMe;
        int hashCode12 = (hashCode11 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isFreeMessage;
        int hashCode13 = (hashCode12 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.isVip;
        int hashCode14 = (hashCode13 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.isPrettyCode;
        int hashCode15 = (hashCode14 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        RideBean rideBean = this.ride;
        int hashCode16 = (hashCode15 + (rideBean == null ? 0 : rideBean.hashCode())) * 31;
        List<MedalInfo> list = this.medalInfo;
        int hashCode17 = (((((hashCode16 + (list == null ? 0 : list.hashCode())) * 31) + androidx.collection.c.a(this.wealthUserGrade)) * 31) + androidx.collection.c.a(this.charmUserGrade)) * 31;
        Long l2 = this.activityUserGrade;
        int hashCode18 = (hashCode17 + (l2 == null ? 0 : l2.hashCode())) * 31;
        NobleInfo nobleInfo = this.noble;
        int hashCode19 = (hashCode18 + (nobleInfo == null ? 0 : nobleInfo.hashCode())) * 31;
        Boolean bool6 = this.isOfficialStaff;
        int hashCode20 = (hashCode19 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        SvipData svipData = this.svip;
        return hashCode20 + (svipData != null ? svipData.hashCode() : 0);
    }

    @Nullable
    public final Boolean isFreeMessage() {
        return this.isFreeMessage;
    }

    @Nullable
    public final Boolean isLike() {
        return this.isLike;
    }

    @Nullable
    public final Boolean isLikeMe() {
        return this.isLikeMe;
    }

    @Nullable
    public final Boolean isOfficialStaff() {
        return this.isOfficialStaff;
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
    public final Boolean isVip() {
        return this.isVip;
    }

    public final void setActivityUserGrade(@Nullable Long l) {
        this.activityUserGrade = l;
    }

    public final void setBirthday(@Nullable Long l) {
        this.birthday = l;
    }

    public final void setCharmUserGrade(long j) {
        this.charmUserGrade = j;
    }

    public final void setCountryImage(@Nullable String str) {
        this.countryImage = str;
    }

    public final void setCountryName(@Nullable String str) {
        this.countryName = str;
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    public final void setFreeMessage(@Nullable Boolean bool) {
        this.isFreeMessage = bool;
    }

    public final void setLike(@Nullable Boolean bool) {
        this.isLike = bool;
    }

    public final void setLikeMe(@Nullable Boolean bool) {
        this.isLikeMe = bool;
    }

    public final void setMedalInfo(@Nullable List<MedalInfo> list) {
        this.medalInfo = list;
    }

    public final void setNoble(@Nullable NobleInfo nobleInfo) {
        this.noble = nobleInfo;
    }

    public final void setOfficialStaff(@Nullable Boolean bool) {
        this.isOfficialStaff = bool;
    }

    public final void setPrettyCode(@Nullable Boolean bool) {
        this.isPrettyCode = bool;
    }

    public final void setRide(@Nullable RideBean rideBean) {
        this.ride = rideBean;
    }

    public final void setSvip(@Nullable SvipData svipData) {
        this.svip = svipData;
    }

    public final void setVip(@Nullable Boolean bool) {
        this.isVip = bool;
    }

    public final void setWealthUserGrade(long j) {
        this.wealthUserGrade = j;
    }

    @NotNull
    public String toString() {
        return "UserSummaryInfo(countryImage=" + this.countryImage + ", sex=" + this.sex + ", code=" + this.code + ", countryName=" + this.countryName + ", name=" + this.name + ", avatar=" + this.avatar + ", externalId=" + this.externalId + ", description=" + this.description + ", birthday=" + this.birthday + ", isShowAge=" + this.isShowAge + ", isLike=" + this.isLike + ", isLikeMe=" + this.isLikeMe + ", isFreeMessage=" + this.isFreeMessage + ", isVip=" + this.isVip + ", isPrettyCode=" + this.isPrettyCode + ", ride=" + this.ride + ", medalInfo=" + this.medalInfo + ", wealthUserGrade=" + this.wealthUserGrade + ", charmUserGrade=" + this.charmUserGrade + ", activityUserGrade=" + this.activityUserGrade + ", noble=" + this.noble + ", isOfficialStaff=" + this.isOfficialStaff + ", svip=" + this.svip + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.countryImage);
        Integer num = this.sex;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        dest.writeString(this.code);
        dest.writeString(this.countryName);
        dest.writeString(this.name);
        dest.writeString(this.avatar);
        dest.writeString(this.externalId);
        dest.writeString(this.description);
        Long l = this.birthday;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        Integer num2 = this.isShowAge;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        Boolean bool = this.isLike;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.isLikeMe;
        if (bool2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Boolean bool3 = this.isFreeMessage;
        if (bool3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        Boolean bool4 = this.isVip;
        if (bool4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool4.booleanValue() ? 1 : 0);
        }
        Boolean bool5 = this.isPrettyCode;
        if (bool5 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool5.booleanValue() ? 1 : 0);
        }
        dest.writeParcelable(this.ride, flags);
        List<MedalInfo> list = this.medalInfo;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<MedalInfo> it = list.iterator();
            while (it.hasNext()) {
                dest.writeParcelable((Parcelable) it.next(), flags);
            }
        }
        dest.writeLong(this.wealthUserGrade);
        dest.writeLong(this.charmUserGrade);
        Long l2 = this.activityUserGrade;
        if (l2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l2.longValue());
        }
        dest.writeParcelable(this.noble, flags);
        Boolean bool6 = this.isOfficialStaff;
        if (bool6 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool6.booleanValue() ? 1 : 0);
        }
        dest.writeParcelable(this.svip, flags);
    }

    public UserSummaryInfo(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable Long l, @Nullable Integer num2, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable RideBean rideBean, @Nullable List<MedalInfo> list, long j, long j2, @Nullable Long l2, @Nullable NobleInfo nobleInfo, @Nullable Boolean bool6, @Nullable SvipData svipData) {
        this.countryImage = str;
        this.sex = num;
        this.code = str2;
        this.countryName = str3;
        this.name = str4;
        this.avatar = str5;
        this.externalId = str6;
        this.description = str7;
        this.birthday = l;
        this.isShowAge = num2;
        this.isLike = bool;
        this.isLikeMe = bool2;
        this.isFreeMessage = bool3;
        this.isVip = bool4;
        this.isPrettyCode = bool5;
        this.ride = rideBean;
        this.medalInfo = list;
        this.wealthUserGrade = j;
        this.charmUserGrade = j2;
        this.activityUserGrade = l2;
        this.noble = nobleInfo;
        this.isOfficialStaff = bool6;
        this.svip = svipData;
    }

    public /* synthetic */ UserSummaryInfo(String str, Integer num, String str2, String str3, String str4, String str5, String str6, String str7, Long l, Integer num2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, RideBean rideBean, List list, long j, long j2, Long l2, NobleInfo nobleInfo, Boolean bool6, SvipData svipData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0 : num, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? "" : str6, (i & 128) == 0 ? str7 : "", (i & 256) != 0 ? null : l, (i & 512) != 0 ? 1 : num2, (i & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? Boolean.FALSE : bool, (i & 2048) != 0 ? Boolean.FALSE : bool2, (i & 4096) != 0 ? Boolean.FALSE : bool3, (i & 8192) != 0 ? Boolean.FALSE : bool4, (i & 16384) != 0 ? Boolean.FALSE : bool5, (i & 32768) != 0 ? null : rideBean, (i & 65536) != 0 ? null : list, (i & 131072) != 0 ? 0L : j, (i & 262144) != 0 ? 0L : j2, (i & 524288) != 0 ? 0L : l2, (i & AgoraRtcService.CUSTOM_REMOTE_VIDEO_IDLE) != 0 ? null : nobleInfo, (i & 2097152) != 0 ? Boolean.FALSE : bool6, (i & 4194304) != 0 ? null : svipData);
    }
}
