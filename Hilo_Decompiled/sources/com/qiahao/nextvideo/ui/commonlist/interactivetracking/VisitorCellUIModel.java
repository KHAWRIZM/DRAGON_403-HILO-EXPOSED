package com.qiahao.nextvideo.ui.commonlist.interactivetracking;

import androidx.annotation.Keep;
import androidx.collection.c;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.medal.Sex;
import com.qiahao.nextvideo.data.model.VisitGuyItem;
import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.qiahao.nextvideo.ui.matchinghistoric.ProfileDetailUIModel;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Keep
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\bG\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 h2\u00020\u0001:\u0001hBù\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001f\u0010 J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010Q\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010(J\t\u0010Z\u001a\u00020\u0014HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010\\\u001a\u00020\u0005HÆ\u0003J\t\u0010]\u001a\u00020\u0019HÆ\u0003J\t\u0010^\u001a\u00020\u001bHÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0082\u0002\u0010a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010bJ\u0013\u0010c\u001a\u00020\u001b2\b\u0010d\u001a\u0004\u0018\u00010eHÖ\u0003J\t\u0010f\u001a\u00020\tHÖ\u0001J\t\u0010g\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010)\u001a\u0004\b*\u0010(R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010-R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010$R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b2\u0010(\"\u0004\b3\u00104R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010$R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b6\u0010(\"\u0004\b7\u00104R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0014\u0010\u0017\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010$R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010C\"\u0004\bD\u0010ER\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010$\"\u0004\bK\u0010-¨\u0006i"}, d2 = {"Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/VisitorCellUIModel;", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/CellUIModel;", "iconCircleDisplayImageUIModel", "Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "iconCircleR2TTagText", "", "title", "titleRightTagText", "titleRightTagDrawable", "", "titleDrawableStart", "endTopText", "subtitle", "endText", "endIconDisplayImageUIModel", "subtitleLeftIconImageUIModel", "titleRightTagBackgroundResID", "endIconClickTag", "endTextSize", "timeCount", "", "nextUIModel", "Lcom/qiahao/nextvideo/ui/matchinghistoric/ProfileDetailUIModel;", "itemId", "interactiveTrackingType", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingType;", "isVip", "", "noble", "Lcom/qiahao/base_common/model/common/NobleInfo;", "avatar", "<init>", "(Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;JLcom/qiahao/nextvideo/ui/matchinghistoric/ProfileDetailUIModel;Ljava/lang/String;Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingType;ZLcom/qiahao/base_common/model/common/NobleInfo;Ljava/lang/String;)V", "getIconCircleDisplayImageUIModel", "()Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "getIconCircleR2TTagText", "()Ljava/lang/String;", "getTitle", "getTitleRightTagText", "getTitleRightTagDrawable", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitleDrawableStart", "getEndTopText", "setEndTopText", "(Ljava/lang/String;)V", "getSubtitle", "getEndText", "getEndIconDisplayImageUIModel", "getSubtitleLeftIconImageUIModel", "getTitleRightTagBackgroundResID", "setTitleRightTagBackgroundResID", "(Ljava/lang/Integer;)V", "getEndIconClickTag", "getEndTextSize", "setEndTextSize", "getTimeCount", "()J", "setTimeCount", "(J)V", "getNextUIModel", "()Lcom/qiahao/nextvideo/ui/matchinghistoric/ProfileDetailUIModel;", "setNextUIModel", "(Lcom/qiahao/nextvideo/ui/matchinghistoric/ProfileDetailUIModel;)V", "getItemId", "getInteractiveTrackingType", "()Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingType;", "()Z", "setVip", "(Z)V", "getNoble", "()Lcom/qiahao/base_common/model/common/NobleInfo;", "setNoble", "(Lcom/qiahao/base_common/model/common/NobleInfo;)V", "getAvatar", "setAvatar", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;JLcom/qiahao/nextvideo/ui/matchinghistoric/ProfileDetailUIModel;Ljava/lang/String;Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingType;ZLcom/qiahao/base_common/model/common/NobleInfo;Ljava/lang/String;)Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/VisitorCellUIModel;", "equals", "other", "", "hashCode", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class VisitorCellUIModel extends CellUIModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private String avatar;

    @Nullable
    private final String endIconClickTag;

    @Nullable
    private final ImageUIModel endIconDisplayImageUIModel;

    @Nullable
    private final String endText;

    @Nullable
    private Integer endTextSize;

    @Nullable
    private String endTopText;

    @Nullable
    private final ImageUIModel iconCircleDisplayImageUIModel;

    @Nullable
    private final String iconCircleR2TTagText;

    @NotNull
    private final InteractiveTrackingType interactiveTrackingType;
    private boolean isVip;

    @NotNull
    private final String itemId;

    @Nullable
    private ProfileDetailUIModel nextUIModel;

    @Nullable
    private NobleInfo noble;

    @Nullable
    private final String subtitle;

    @Nullable
    private final ImageUIModel subtitleLeftIconImageUIModel;
    private long timeCount;

    @Nullable
    private final String title;

    @Nullable
    private final Integer titleDrawableStart;

    @Nullable
    private Integer titleRightTagBackgroundResID;

    @Nullable
    private final Integer titleRightTagDrawable;

    @Nullable
    private final String titleRightTagText;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/VisitorCellUIModel$Companion;", "", "<init>", "()V", "init", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/VisitorCellUIModel;", "it", "Lcom/qiahao/nextvideo/data/model/VisitGuyItem;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VisitorCellUIModel init(@NotNull VisitGuyItem it) {
            int i;
            int i2;
            int i3;
            Intrinsics.checkNotNullParameter(it, "it");
            Date date = new Date(it.getLikeAt() * 1000);
            Date date2 = new Date(System.currentTimeMillis());
            ProfileDetailUIModel.Companion companion = ProfileDetailUIModel.INSTANCE;
            User user = it.getUser();
            Intrinsics.checkNotNull(user);
            ProfileDetailUIModel init = companion.init(user);
            String avatar = it.getUser().getAvatar();
            String externalId = it.getUser().getExternalId();
            String nick = it.getUser().getNick();
            String age = it.getUser().getAge();
            int sex = it.getUser().getSex();
            if (sex == Sex.GIRL.getCode() || sex != Sex.BOY.getCode()) {
                i = R.drawable.icon_girl;
            } else {
                i = R.drawable.icon_boy;
            }
            String convert = DateTimeUtilityKt.convert(date, date2);
            String name = it.getUser().getCountryInfo().getName();
            ImageUIModel countryTag = ImageUIModel.INSTANCE.countryTag(it.getUser().getCountryInfo().getIcon());
            if (it.getUser().getSex() == 1) {
                i2 = R.drawable.bg_age_male;
            } else {
                i2 = R.drawable.bg_age_female;
            }
            VisitorCellUIModel visitorCellUIModel = new VisitorCellUIModel(null, null, nick, age, Integer.valueOf(i), null, convert, name, null, null, countryTag, Integer.valueOf(i2), null, null, it.getN(), init, externalId, null, it.getUser().isVip(), it.getUser().getNoble(), avatar, 144163, null);
            visitorCellUIModel.setHasRead(it.getHasRead());
            ProfileDetailUIModel nextUIModel = visitorCellUIModel.getNextUIModel();
            if (nextUIModel != null) {
                i3 = nextUIModel.getHeartPer();
            } else {
                i3 = -1;
            }
            visitorCellUIModel.setHeartPer(i3);
            return visitorCellUIModel;
        }

        private Companion() {
        }
    }

    public /* synthetic */ VisitorCellUIModel(ImageUIModel imageUIModel, String str, String str2, String str3, Integer num, Integer num2, String str4, String str5, String str6, ImageUIModel imageUIModel2, ImageUIModel imageUIModel3, Integer num3, String str7, Integer num4, long j, ProfileDetailUIModel profileDetailUIModel, String str8, InteractiveTrackingType interactiveTrackingType, boolean z, NobleInfo nobleInfo, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : imageUIModel, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : str6, (i & 512) != 0 ? null : imageUIModel2, (i & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : imageUIModel3, (i & 2048) != 0 ? null : num3, (i & 4096) != 0 ? null : str7, (i & 8192) != 0 ? null : num4, (i & 16384) != 0 ? 0L : j, (32768 & i) != 0 ? null : profileDetailUIModel, str8, (131072 & i) != 0 ? InteractiveTrackingType.Visitor : interactiveTrackingType, (262144 & i) != 0 ? false : z, (524288 & i) != 0 ? null : nobleInfo, (i & AgoraRtcService.CUSTOM_REMOTE_VIDEO_IDLE) != 0 ? null : str9);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final ImageUIModel getIconCircleDisplayImageUIModel() {
        return this.iconCircleDisplayImageUIModel;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final ImageUIModel getEndIconDisplayImageUIModel() {
        return this.endIconDisplayImageUIModel;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final ImageUIModel getSubtitleLeftIconImageUIModel() {
        return this.subtitleLeftIconImageUIModel;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Integer getTitleRightTagBackgroundResID() {
        return this.titleRightTagBackgroundResID;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final String getEndIconClickTag() {
        return this.endIconClickTag;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final Integer getEndTextSize() {
        return this.endTextSize;
    }

    /* renamed from: component15, reason: from getter */
    public final long getTimeCount() {
        return this.timeCount;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final ProfileDetailUIModel getNextUIModel() {
        return this.nextUIModel;
    }

    @NotNull
    /* renamed from: component17, reason: from getter */
    public final String getItemId() {
        return this.itemId;
    }

    @NotNull
    /* renamed from: component18, reason: from getter */
    public final InteractiveTrackingType getInteractiveTrackingType() {
        return this.interactiveTrackingType;
    }

    /* renamed from: component19, reason: from getter */
    public final boolean getIsVip() {
        return this.isVip;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getIconCircleR2TTagText() {
        return this.iconCircleR2TTagText;
    }

    @Nullable
    /* renamed from: component20, reason: from getter */
    public final NobleInfo getNoble() {
        return this.noble;
    }

    @Nullable
    /* renamed from: component21, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getTitleRightTagText() {
        return this.titleRightTagText;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getTitleRightTagDrawable() {
        return this.titleRightTagDrawable;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Integer getTitleDrawableStart() {
        return this.titleDrawableStart;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getEndTopText() {
        return this.endTopText;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getEndText() {
        return this.endText;
    }

    @NotNull
    public final VisitorCellUIModel copy(@Nullable ImageUIModel iconCircleDisplayImageUIModel, @Nullable String iconCircleR2TTagText, @Nullable String title, @Nullable String titleRightTagText, @Nullable Integer titleRightTagDrawable, @Nullable Integer titleDrawableStart, @Nullable String endTopText, @Nullable String subtitle, @Nullable String endText, @Nullable ImageUIModel endIconDisplayImageUIModel, @Nullable ImageUIModel subtitleLeftIconImageUIModel, @Nullable Integer titleRightTagBackgroundResID, @Nullable String endIconClickTag, @Nullable Integer endTextSize, long timeCount, @Nullable ProfileDetailUIModel nextUIModel, @NotNull String itemId, @NotNull InteractiveTrackingType interactiveTrackingType, boolean isVip, @Nullable NobleInfo noble, @Nullable String avatar) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(interactiveTrackingType, "interactiveTrackingType");
        return new VisitorCellUIModel(iconCircleDisplayImageUIModel, iconCircleR2TTagText, title, titleRightTagText, titleRightTagDrawable, titleDrawableStart, endTopText, subtitle, endText, endIconDisplayImageUIModel, subtitleLeftIconImageUIModel, titleRightTagBackgroundResID, endIconClickTag, endTextSize, timeCount, nextUIModel, itemId, interactiveTrackingType, isVip, noble, avatar);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VisitorCellUIModel)) {
            return false;
        }
        VisitorCellUIModel visitorCellUIModel = (VisitorCellUIModel) other;
        return Intrinsics.areEqual(this.iconCircleDisplayImageUIModel, visitorCellUIModel.iconCircleDisplayImageUIModel) && Intrinsics.areEqual(this.iconCircleR2TTagText, visitorCellUIModel.iconCircleR2TTagText) && Intrinsics.areEqual(this.title, visitorCellUIModel.title) && Intrinsics.areEqual(this.titleRightTagText, visitorCellUIModel.titleRightTagText) && Intrinsics.areEqual(this.titleRightTagDrawable, visitorCellUIModel.titleRightTagDrawable) && Intrinsics.areEqual(this.titleDrawableStart, visitorCellUIModel.titleDrawableStart) && Intrinsics.areEqual(this.endTopText, visitorCellUIModel.endTopText) && Intrinsics.areEqual(this.subtitle, visitorCellUIModel.subtitle) && Intrinsics.areEqual(this.endText, visitorCellUIModel.endText) && Intrinsics.areEqual(this.endIconDisplayImageUIModel, visitorCellUIModel.endIconDisplayImageUIModel) && Intrinsics.areEqual(this.subtitleLeftIconImageUIModel, visitorCellUIModel.subtitleLeftIconImageUIModel) && Intrinsics.areEqual(this.titleRightTagBackgroundResID, visitorCellUIModel.titleRightTagBackgroundResID) && Intrinsics.areEqual(this.endIconClickTag, visitorCellUIModel.endIconClickTag) && Intrinsics.areEqual(this.endTextSize, visitorCellUIModel.endTextSize) && this.timeCount == visitorCellUIModel.timeCount && Intrinsics.areEqual(this.nextUIModel, visitorCellUIModel.nextUIModel) && Intrinsics.areEqual(this.itemId, visitorCellUIModel.itemId) && this.interactiveTrackingType == visitorCellUIModel.interactiveTrackingType && this.isVip == visitorCellUIModel.isVip && Intrinsics.areEqual(this.noble, visitorCellUIModel.noble) && Intrinsics.areEqual(this.avatar, visitorCellUIModel.avatar);
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getEndIconClickTag() {
        return this.endIconClickTag;
    }

    @Nullable
    public final ImageUIModel getEndIconDisplayImageUIModel() {
        return this.endIconDisplayImageUIModel;
    }

    @Nullable
    public final String getEndText() {
        return this.endText;
    }

    @Nullable
    public final Integer getEndTextSize() {
        return this.endTextSize;
    }

    @Nullable
    public final String getEndTopText() {
        return this.endTopText;
    }

    @Nullable
    public final ImageUIModel getIconCircleDisplayImageUIModel() {
        return this.iconCircleDisplayImageUIModel;
    }

    @Nullable
    public final String getIconCircleR2TTagText() {
        return this.iconCircleR2TTagText;
    }

    @Override // com.qiahao.nextvideo.ui.commonlist.interactivetracking.CellUIModel
    @NotNull
    public InteractiveTrackingType getInteractiveTrackingType() {
        return this.interactiveTrackingType;
    }

    @Override // com.qiahao.nextvideo.ui.commonlist.interactivetracking.CellUIModel
    @NotNull
    public String getItemId() {
        return this.itemId;
    }

    @Override // com.qiahao.nextvideo.ui.commonlist.interactivetracking.CellUIModel
    @Nullable
    public ProfileDetailUIModel getNextUIModel() {
        return this.nextUIModel;
    }

    @Nullable
    public final NobleInfo getNoble() {
        return this.noble;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final ImageUIModel getSubtitleLeftIconImageUIModel() {
        return this.subtitleLeftIconImageUIModel;
    }

    public final long getTimeCount() {
        return this.timeCount;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Integer getTitleDrawableStart() {
        return this.titleDrawableStart;
    }

    @Nullable
    public final Integer getTitleRightTagBackgroundResID() {
        return this.titleRightTagBackgroundResID;
    }

    @Nullable
    public final Integer getTitleRightTagDrawable() {
        return this.titleRightTagDrawable;
    }

    @Nullable
    public final String getTitleRightTagText() {
        return this.titleRightTagText;
    }

    public int hashCode() {
        ImageUIModel imageUIModel = this.iconCircleDisplayImageUIModel;
        int hashCode = (imageUIModel == null ? 0 : imageUIModel.hashCode()) * 31;
        String str = this.iconCircleR2TTagText;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.title;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.titleRightTagText;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.titleRightTagDrawable;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.titleDrawableStart;
        int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str4 = this.endTopText;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.subtitle;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.endText;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        ImageUIModel imageUIModel2 = this.endIconDisplayImageUIModel;
        int hashCode10 = (hashCode9 + (imageUIModel2 == null ? 0 : imageUIModel2.hashCode())) * 31;
        ImageUIModel imageUIModel3 = this.subtitleLeftIconImageUIModel;
        int hashCode11 = (hashCode10 + (imageUIModel3 == null ? 0 : imageUIModel3.hashCode())) * 31;
        Integer num3 = this.titleRightTagBackgroundResID;
        int hashCode12 = (hashCode11 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str7 = this.endIconClickTag;
        int hashCode13 = (hashCode12 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num4 = this.endTextSize;
        int hashCode14 = (((hashCode13 + (num4 == null ? 0 : num4.hashCode())) * 31) + c.a(this.timeCount)) * 31;
        ProfileDetailUIModel profileDetailUIModel = this.nextUIModel;
        int hashCode15 = (((((((hashCode14 + (profileDetailUIModel == null ? 0 : profileDetailUIModel.hashCode())) * 31) + this.itemId.hashCode()) * 31) + this.interactiveTrackingType.hashCode()) * 31) + a.a(this.isVip)) * 31;
        NobleInfo nobleInfo = this.noble;
        int hashCode16 = (hashCode15 + (nobleInfo == null ? 0 : nobleInfo.hashCode())) * 31;
        String str8 = this.avatar;
        return hashCode16 + (str8 != null ? str8.hashCode() : 0);
    }

    public final boolean isVip() {
        return this.isVip;
    }

    public final void setAvatar(@Nullable String str) {
        this.avatar = str;
    }

    public final void setEndTextSize(@Nullable Integer num) {
        this.endTextSize = num;
    }

    public final void setEndTopText(@Nullable String str) {
        this.endTopText = str;
    }

    @Override // com.qiahao.nextvideo.ui.commonlist.interactivetracking.CellUIModel
    public void setNextUIModel(@Nullable ProfileDetailUIModel profileDetailUIModel) {
        this.nextUIModel = profileDetailUIModel;
    }

    public final void setNoble(@Nullable NobleInfo nobleInfo) {
        this.noble = nobleInfo;
    }

    public final void setTimeCount(long j) {
        this.timeCount = j;
    }

    public final void setTitleRightTagBackgroundResID(@Nullable Integer num) {
        this.titleRightTagBackgroundResID = num;
    }

    public final void setVip(boolean z) {
        this.isVip = z;
    }

    @NotNull
    public String toString() {
        return "VisitorCellUIModel(iconCircleDisplayImageUIModel=" + this.iconCircleDisplayImageUIModel + ", iconCircleR2TTagText=" + this.iconCircleR2TTagText + ", title=" + this.title + ", titleRightTagText=" + this.titleRightTagText + ", titleRightTagDrawable=" + this.titleRightTagDrawable + ", titleDrawableStart=" + this.titleDrawableStart + ", endTopText=" + this.endTopText + ", subtitle=" + this.subtitle + ", endText=" + this.endText + ", endIconDisplayImageUIModel=" + this.endIconDisplayImageUIModel + ", subtitleLeftIconImageUIModel=" + this.subtitleLeftIconImageUIModel + ", titleRightTagBackgroundResID=" + this.titleRightTagBackgroundResID + ", endIconClickTag=" + this.endIconClickTag + ", endTextSize=" + this.endTextSize + ", timeCount=" + this.timeCount + ", nextUIModel=" + this.nextUIModel + ", itemId=" + this.itemId + ", interactiveTrackingType=" + this.interactiveTrackingType + ", isVip=" + this.isVip + ", noble=" + this.noble + ", avatar=" + this.avatar + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisitorCellUIModel(@Nullable ImageUIModel imageUIModel, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable Integer num2, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable ImageUIModel imageUIModel2, @Nullable ImageUIModel imageUIModel3, @Nullable Integer num3, @Nullable String str7, @Nullable Integer num4, long j, @Nullable ProfileDetailUIModel profileDetailUIModel, @NotNull String str8, @NotNull InteractiveTrackingType interactiveTrackingType, boolean z, @Nullable NobleInfo nobleInfo, @Nullable String str9) {
        super(profileDetailUIModel, str8, interactiveTrackingType, false, 0, 24, null);
        Intrinsics.checkNotNullParameter(str8, "itemId");
        Intrinsics.checkNotNullParameter(interactiveTrackingType, "interactiveTrackingType");
        this.iconCircleDisplayImageUIModel = imageUIModel;
        this.iconCircleR2TTagText = str;
        this.title = str2;
        this.titleRightTagText = str3;
        this.titleRightTagDrawable = num;
        this.titleDrawableStart = num2;
        this.endTopText = str4;
        this.subtitle = str5;
        this.endText = str6;
        this.endIconDisplayImageUIModel = imageUIModel2;
        this.subtitleLeftIconImageUIModel = imageUIModel3;
        this.titleRightTagBackgroundResID = num3;
        this.endIconClickTag = str7;
        this.endTextSize = num4;
        this.timeCount = j;
        this.nextUIModel = profileDetailUIModel;
        this.itemId = str8;
        this.interactiveTrackingType = interactiveTrackingType;
        this.isVip = z;
        this.noble = nobleInfo;
        this.avatar = str9;
    }
}
