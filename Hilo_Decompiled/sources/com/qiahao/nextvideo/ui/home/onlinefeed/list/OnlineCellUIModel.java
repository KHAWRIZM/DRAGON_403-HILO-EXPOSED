package com.qiahao.nextvideo.ui.home.onlinefeed.list;

import android.widget.ImageView;
import androidx.annotation.Keep;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.medal.Sex;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.views.ForeverHeartUIModel;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import com.taobao.accs.common.Constants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Keep
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bA\b\u0087\b\u0018\u0000 [2\u00020\u0001:\u0001[B±\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0007HÆ\u0003J\t\u0010E\u001a\u00020\tHÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\fHÆ\u0003J\t\u0010H\u001a\u00020\fHÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010K\u001a\u00020\tHÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u00102J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\tHÆ\u0003J\t\u0010Q\u001a\u00020\u0018HÆ\u0003J\t\u0010R\u001a\u00020\tHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\t\u0010T\u001a\u00020\tHÆ\u0003JÒ\u0001\u0010U\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010VJ\u0013\u0010W\u001a\u00020\t2\b\u0010X\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Y\u001a\u00020\fHÖ\u0001J\t\u0010Z\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010%\"\u0004\b&\u0010'R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010 R\u001a\u0010\u0010\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010%\"\u0004\b.\u0010'R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010 R\u001a\u0010\u0016\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010%\"\u0004\b5\u0010'R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001a\u0010\u0019\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010%\"\u0004\b8\u0010'R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010\u001c\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010%\"\u0004\b=\u0010'R\u001c\u0010>\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010 \"\u0004\b@\u0010A¨\u0006\\"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/onlinefeed/list/OnlineCellUIModel;", "", "uid", "", "thumbnail", "Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "thumbnailRatio", "", "isLiked", "", "nickname", "sexTag", "", "sex", "country", "age", "isFreeMessage", "countryName", "description", "birthday", "", Constants.KEY_HTTP_CODE, "isLikeMe", "foreverHeartUIModel", "Lcom/qiahao/nextvideo/ui/reusable/views/ForeverHeartUIModel;", "isVip", "noble", "Lcom/qiahao/base_common/model/common/NobleInfo;", "isOfficialStaff", "<init>", "(Ljava/lang/String;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;FZLjava/lang/String;IILcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ZLcom/qiahao/nextvideo/ui/reusable/views/ForeverHeartUIModel;ZLcom/qiahao/base_common/model/common/NobleInfo;Z)V", "getUid", "()Ljava/lang/String;", "getThumbnail", "()Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "getThumbnailRatio", "()F", "()Z", "setLiked", "(Z)V", "getNickname", "getSexTag", "()I", "getSex", "getCountry", "getAge", "setFreeMessage", "getCountryName", "getDescription", "getBirthday", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCode", "setLikeMe", "getForeverHeartUIModel", "()Lcom/qiahao/nextvideo/ui/reusable/views/ForeverHeartUIModel;", "setVip", "getNoble", "()Lcom/qiahao/base_common/model/common/NobleInfo;", "setNoble", "(Lcom/qiahao/base_common/model/common/NobleInfo;)V", "setOfficialStaff", "birthdayInFormat", "getBirthdayInFormat", "setBirthdayInFormat", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(Ljava/lang/String;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;FZLjava/lang/String;IILcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ZLcom/qiahao/nextvideo/ui/reusable/views/ForeverHeartUIModel;ZLcom/qiahao/base_common/model/common/NobleInfo;Z)Lcom/qiahao/nextvideo/ui/home/onlinefeed/list/OnlineCellUIModel;", "equals", "other", "hashCode", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class OnlineCellUIModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String tag = "OnlineCellUIModel";

    @Nullable
    private final String age;

    @Nullable
    private final Long birthday;

    @Nullable
    private String birthdayInFormat;

    @NotNull
    private final String code;

    @NotNull
    private final ImageUIModel country;

    @NotNull
    private final String countryName;

    @NotNull
    private final String description;

    @NotNull
    private final ForeverHeartUIModel foreverHeartUIModel;
    private boolean isFreeMessage;
    private boolean isLikeMe;
    private boolean isLiked;
    private boolean isOfficialStaff;
    private boolean isVip;

    @NotNull
    private final String nickname;

    @Nullable
    private NobleInfo noble;
    private final int sex;
    private final int sexTag;

    @NotNull
    private final ImageUIModel thumbnail;
    private final float thumbnailRatio;

    @NotNull
    private final String uid;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/onlinefeed/list/OnlineCellUIModel$Companion;", "", "<init>", "()V", "tag", "", "init", "Lcom/qiahao/nextvideo/ui/home/onlinefeed/list/OnlineCellUIModel;", "user", "Lcom/qiahao/base_common/model/common/User;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OnlineCellUIModel init(@NotNull User user) {
            String str;
            int i;
            String str2;
            boolean z;
            Intrinsics.checkNotNullParameter(user, "user");
            ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
            String avatar = user.getAvatar();
            ResizeMode.MFIT mfit = ResizeMode.MFIT.INSTANCE;
            Dimens dimens = Dimens.INSTANCE;
            int screenWidth = (dimens.getScreenWidth() - dimens.dpToPx(42)) / 2;
            mfit.setWidth(screenWidth);
            mfit.setHeight((int) (screenWidth * 1.5471698f));
            Unit unit = Unit.INSTANCE;
            ImageUIModel full = companion.full(avatar, mfit);
            full.setScaleType(ImageView.ScaleType.FIT_XY);
            Boolean isLike = user.isLike();
            Boolean bool = Boolean.TRUE;
            boolean areEqual = Intrinsics.areEqual(isLike, bool);
            String nick = user.getNick();
            if (nick == null) {
                str = "";
            } else {
                str = nick;
            }
            if (user.getSex() == Sex.GIRL.getCode()) {
                i = R.drawable.icon_girl;
            } else {
                i = R.drawable.icon_boy;
            }
            int sex = user.getSex();
            ImageUIModel onlineThumbnail = companion.onlineThumbnail(user.getCountryInfo().getIcon());
            onlineThumbnail.setPlaceholder(null);
            String externalId = user.getExternalId();
            String description = user.getDescription();
            if (description == null) {
                str2 = "";
            } else {
                str2 = description;
            }
            Long birthday = user.getBirthday();
            boolean areEqual2 = Intrinsics.areEqual(user.isSession(), bool);
            String name = user.getCountryInfo().getName();
            String code = user.getCode();
            String age = user.getAge();
            Boolean isLikeMe = user.isLikeMe();
            if (isLikeMe != null) {
                z = isLikeMe.booleanValue();
            } else {
                z = false;
            }
            return new OnlineCellUIModel(externalId, full, 1.42f, areEqual, str, i, sex, onlineThumbnail, age, areEqual2, name, str2, birthday, code, z, ForeverHeartUIModel.INSTANCE.init(user), user.isVip(), user.getNoble(), user.isOfficialStaff());
        }

        private Companion() {
        }
    }

    public OnlineCellUIModel(@NotNull String str, @NotNull ImageUIModel imageUIModel, float f, boolean z, @NotNull String str2, int i, int i2, @NotNull ImageUIModel imageUIModel2, @Nullable String str3, boolean z2, @NotNull String str4, @NotNull String str5, @Nullable Long l, @NotNull String str6, boolean z3, @NotNull ForeverHeartUIModel foreverHeartUIModel, boolean z4, @Nullable NobleInfo nobleInfo, boolean z5) {
        Intrinsics.checkNotNullParameter(str, "uid");
        Intrinsics.checkNotNullParameter(imageUIModel, "thumbnail");
        Intrinsics.checkNotNullParameter(str2, "nickname");
        Intrinsics.checkNotNullParameter(imageUIModel2, "country");
        Intrinsics.checkNotNullParameter(str4, "countryName");
        Intrinsics.checkNotNullParameter(str5, "description");
        Intrinsics.checkNotNullParameter(str6, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(foreverHeartUIModel, "foreverHeartUIModel");
        this.uid = str;
        this.thumbnail = imageUIModel;
        this.thumbnailRatio = f;
        this.isLiked = z;
        this.nickname = str2;
        this.sexTag = i;
        this.sex = i2;
        this.country = imageUIModel2;
        this.age = str3;
        this.isFreeMessage = z2;
        this.countryName = str4;
        this.description = str5;
        this.birthday = l;
        this.code = str6;
        this.isLikeMe = z3;
        this.foreverHeartUIModel = foreverHeartUIModel;
        this.isVip = z4;
        this.noble = nobleInfo;
        this.isOfficialStaff = z5;
        this.birthdayInFormat = l == null ? null : DateTimeUtilityKt.getDateInSecs$default(l.longValue(), (Locale) null, (String) null, 6, (Object) null);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsFreeMessage() {
        return this.isFreeMessage;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final String getCountryName() {
        return this.countryName;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final Long getBirthday() {
        return this.birthday;
    }

    @NotNull
    /* renamed from: component14, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getIsLikeMe() {
        return this.isLikeMe;
    }

    @NotNull
    /* renamed from: component16, reason: from getter */
    public final ForeverHeartUIModel getForeverHeartUIModel() {
        return this.foreverHeartUIModel;
    }

    /* renamed from: component17, reason: from getter */
    public final boolean getIsVip() {
        return this.isVip;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final NobleInfo getNoble() {
        return this.noble;
    }

    /* renamed from: component19, reason: from getter */
    public final boolean getIsOfficialStaff() {
        return this.isOfficialStaff;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final ImageUIModel getThumbnail() {
        return this.thumbnail;
    }

    /* renamed from: component3, reason: from getter */
    public final float getThumbnailRatio() {
        return this.thumbnailRatio;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsLiked() {
        return this.isLiked;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component6, reason: from getter */
    public final int getSexTag() {
        return this.sexTag;
    }

    /* renamed from: component7, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final ImageUIModel getCountry() {
        return this.country;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getAge() {
        return this.age;
    }

    @NotNull
    public final OnlineCellUIModel copy(@NotNull String uid, @NotNull ImageUIModel thumbnail, float thumbnailRatio, boolean isLiked, @NotNull String nickname, int sexTag, int sex, @NotNull ImageUIModel country, @Nullable String age, boolean isFreeMessage, @NotNull String countryName, @NotNull String description, @Nullable Long birthday, @NotNull String code, boolean isLikeMe, @NotNull ForeverHeartUIModel foreverHeartUIModel, boolean isVip, @Nullable NobleInfo noble, boolean isOfficialStaff) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(thumbnail, "thumbnail");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(countryName, "countryName");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(foreverHeartUIModel, "foreverHeartUIModel");
        return new OnlineCellUIModel(uid, thumbnail, thumbnailRatio, isLiked, nickname, sexTag, sex, country, age, isFreeMessage, countryName, description, birthday, code, isLikeMe, foreverHeartUIModel, isVip, noble, isOfficialStaff);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnlineCellUIModel)) {
            return false;
        }
        OnlineCellUIModel onlineCellUIModel = (OnlineCellUIModel) other;
        return Intrinsics.areEqual(this.uid, onlineCellUIModel.uid) && Intrinsics.areEqual(this.thumbnail, onlineCellUIModel.thumbnail) && Float.compare(this.thumbnailRatio, onlineCellUIModel.thumbnailRatio) == 0 && this.isLiked == onlineCellUIModel.isLiked && Intrinsics.areEqual(this.nickname, onlineCellUIModel.nickname) && this.sexTag == onlineCellUIModel.sexTag && this.sex == onlineCellUIModel.sex && Intrinsics.areEqual(this.country, onlineCellUIModel.country) && Intrinsics.areEqual(this.age, onlineCellUIModel.age) && this.isFreeMessage == onlineCellUIModel.isFreeMessage && Intrinsics.areEqual(this.countryName, onlineCellUIModel.countryName) && Intrinsics.areEqual(this.description, onlineCellUIModel.description) && Intrinsics.areEqual(this.birthday, onlineCellUIModel.birthday) && Intrinsics.areEqual(this.code, onlineCellUIModel.code) && this.isLikeMe == onlineCellUIModel.isLikeMe && Intrinsics.areEqual(this.foreverHeartUIModel, onlineCellUIModel.foreverHeartUIModel) && this.isVip == onlineCellUIModel.isVip && Intrinsics.areEqual(this.noble, onlineCellUIModel.noble) && this.isOfficialStaff == onlineCellUIModel.isOfficialStaff;
    }

    @Nullable
    public final String getAge() {
        return this.age;
    }

    @Nullable
    public final Long getBirthday() {
        return this.birthday;
    }

    @Nullable
    public final String getBirthdayInFormat() {
        return this.birthdayInFormat;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final ImageUIModel getCountry() {
        return this.country;
    }

    @NotNull
    public final String getCountryName() {
        return this.countryName;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final ForeverHeartUIModel getForeverHeartUIModel() {
        return this.foreverHeartUIModel;
    }

    @NotNull
    public final String getNickname() {
        return this.nickname;
    }

    @Nullable
    public final NobleInfo getNoble() {
        return this.noble;
    }

    public final int getSex() {
        return this.sex;
    }

    public final int getSexTag() {
        return this.sexTag;
    }

    @NotNull
    public final ImageUIModel getThumbnail() {
        return this.thumbnail;
    }

    public final float getThumbnailRatio() {
        return this.thumbnailRatio;
    }

    @NotNull
    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = ((((((((((((((this.uid.hashCode() * 31) + this.thumbnail.hashCode()) * 31) + Float.floatToIntBits(this.thumbnailRatio)) * 31) + a.a(this.isLiked)) * 31) + this.nickname.hashCode()) * 31) + this.sexTag) * 31) + this.sex) * 31) + this.country.hashCode()) * 31;
        String str = this.age;
        int i = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int a = (((((((hashCode3 + hashCode) * 31) + a.a(this.isFreeMessage)) * 31) + this.countryName.hashCode()) * 31) + this.description.hashCode()) * 31;
        Long l = this.birthday;
        if (l == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = l.hashCode();
        }
        int hashCode4 = (((((((((a + hashCode2) * 31) + this.code.hashCode()) * 31) + a.a(this.isLikeMe)) * 31) + this.foreverHeartUIModel.hashCode()) * 31) + a.a(this.isVip)) * 31;
        NobleInfo nobleInfo = this.noble;
        if (nobleInfo != null) {
            i = nobleInfo.hashCode();
        }
        return ((hashCode4 + i) * 31) + a.a(this.isOfficialStaff);
    }

    public final boolean isFreeMessage() {
        return this.isFreeMessage;
    }

    public final boolean isLikeMe() {
        return this.isLikeMe;
    }

    public final boolean isLiked() {
        return this.isLiked;
    }

    public final boolean isOfficialStaff() {
        return this.isOfficialStaff;
    }

    public final boolean isVip() {
        return this.isVip;
    }

    public final void setBirthdayInFormat(@Nullable String str) {
        this.birthdayInFormat = str;
    }

    public final void setFreeMessage(boolean z) {
        this.isFreeMessage = z;
    }

    public final void setLikeMe(boolean z) {
        this.isLikeMe = z;
    }

    public final void setLiked(boolean z) {
        this.isLiked = z;
    }

    public final void setNoble(@Nullable NobleInfo nobleInfo) {
        this.noble = nobleInfo;
    }

    public final void setOfficialStaff(boolean z) {
        this.isOfficialStaff = z;
    }

    public final void setVip(boolean z) {
        this.isVip = z;
    }

    @NotNull
    public String toString() {
        return "OnlineCellUIModel(uid=" + this.uid + ", thumbnail=" + this.thumbnail + ", thumbnailRatio=" + this.thumbnailRatio + ", isLiked=" + this.isLiked + ", nickname=" + this.nickname + ", sexTag=" + this.sexTag + ", sex=" + this.sex + ", country=" + this.country + ", age=" + this.age + ", isFreeMessage=" + this.isFreeMessage + ", countryName=" + this.countryName + ", description=" + this.description + ", birthday=" + this.birthday + ", code=" + this.code + ", isLikeMe=" + this.isLikeMe + ", foreverHeartUIModel=" + this.foreverHeartUIModel + ", isVip=" + this.isVip + ", noble=" + this.noble + ", isOfficialStaff=" + this.isOfficialStaff + ")";
    }

    public /* synthetic */ OnlineCellUIModel(String str, ImageUIModel imageUIModel, float f, boolean z, String str2, int i, int i2, ImageUIModel imageUIModel2, String str3, boolean z2, String str4, String str5, Long l, String str6, boolean z3, ForeverHeartUIModel foreverHeartUIModel, boolean z4, NobleInfo nobleInfo, boolean z5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, imageUIModel, f, (i3 & 8) != 0 ? false : z, str2, i, i2, imageUIModel2, str3, z2, str4, str5, l, str6, (i3 & 16384) != 0 ? false : z3, foreverHeartUIModel, (65536 & i3) != 0 ? false : z4, (131072 & i3) != 0 ? null : nobleInfo, (i3 & 262144) != 0 ? false : z5);
    }
}
