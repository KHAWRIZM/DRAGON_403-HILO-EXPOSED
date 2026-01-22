package com.qiahao.nextvideo.ui.paired;

import androidx.annotation.Keep;
import androidx.collection.c;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.UserSummaryInfo;
import com.qiahao.nextvideo.ui.home.filter.genderpreference.GenderPreferenceViewController;
import com.qiahao.nextvideo.ui.home.filter.regoinpreference.RegionPreferenceViewController;
import com.qiahao.nextvideo.ui.videocall.VideoResultActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;
import userProxy.UserProxy;

@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b6\b\u0087\b\u0018\u0000 I2\u00020\u0001:\u0001IB\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\u000b\u0012\b\b\u0001\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\t\u00108\u001a\u00020\tHÆ\u0003J\t\u00109\u001a\u00020\u000bHÆ\u0003J\t\u0010:\u001a\u00020\u000bHÆ\u0003J\t\u0010;\u001a\u00020\u000bHÆ\u0003J\t\u0010<\u001a\u00020\u000fHÆ\u0003J\t\u0010=\u001a\u00020\u000fHÆ\u0003J\t\u0010>\u001a\u00020\u000fHÆ\u0003J\t\u0010?\u001a\u00020\u000fHÆ\u0003J\t\u0010@\u001a\u00020\u0014HÆ\u0003J\t\u0010A\u001a\u00020\u000bHÆ\u0003J\t\u0010B\u001a\u00020\u000bHÆ\u0003J\t\u0010C\u001a\u00020\u000bHÆ\u0003J\u009f\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u000b2\b\b\u0003\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000bHÆ\u0001J\u0013\u0010E\u001a\u00020\u00142\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020\u000bHÖ\u0001J\t\u0010H\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0011\u0010\u0011\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u001a\u0010\u0012\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010.R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010/R\u001a\u0010\u0015\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010%\"\u0004\b1\u00102R\u0011\u0010\u0016\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0011\u0010\u0017\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b4\u0010%¨\u0006J"}, d2 = {"Lcom/qiahao/nextvideo/ui/paired/MatchingActionPendingUIModel;", "", "toUser", "Lcom/qiahao/base_common/model/common/User;", "fromUser", "Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "waitDuration", "", "doneType", "Lcom/qiahao/nextvideo/ui/paired/DoneType;", "toUserSexBackgroundResID", "", "toUserSexIconDrawableResID", "toUserDefaultAvtarResID", VideoResultActivity.VIDEO_MATCH_UNIQUE_ID, "", "conditionGender", "conditionRegion", "debug", "isOnlineUser", "", "from", "singleWaitTimeInSec", "dualWaitTimeInSec", "<init>", "(Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;JLcom/qiahao/nextvideo/ui/paired/DoneType;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIII)V", "getToUser", "()Lcom/qiahao/base_common/model/common/User;", "getFromUser", "()Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "getWaitDuration", "()J", "getDoneType", "()Lcom/qiahao/nextvideo/ui/paired/DoneType;", "setDoneType", "(Lcom/qiahao/nextvideo/ui/paired/DoneType;)V", "getToUserSexBackgroundResID", "()I", "getToUserSexIconDrawableResID", "getToUserDefaultAvtarResID", "getMatchUniqueID", "()Ljava/lang/String;", "getConditionGender", "getConditionRegion", "getDebug", "setDebug", "(Ljava/lang/String;)V", "()Z", "getFrom", "setFrom", "(I)V", "getSingleWaitTimeInSec", "getDualWaitTimeInSec", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MatchingActionPendingUIModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String conditionGender;

    @NotNull
    private final String conditionRegion;

    @NotNull
    private String debug;

    @NotNull
    private DoneType doneType;
    private final int dualWaitTimeInSec;
    private int from;

    @NotNull
    private final UserSummaryInfo fromUser;
    private final boolean isOnlineUser;

    @NotNull
    private final String matchUniqueID;
    private final int singleWaitTimeInSec;

    @NotNull
    private final User toUser;
    private final int toUserDefaultAvtarResID;
    private final int toUserSexBackgroundResID;
    private final int toUserSexIconDrawableResID;
    private final long waitDuration;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/paired/MatchingActionPendingUIModel$Companion;", "", "<init>", "()V", "init", "Lcom/qiahao/nextvideo/ui/paired/MatchingActionPendingUIModel;", "toUser", "Lcom/qiahao/base_common/model/common/User;", "fromUser", "Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "inAppMatchEvent", "LuserProxy/UserProxy$MatchSuccess;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MatchingActionPendingUIModel init(@NotNull User toUser, @NotNull UserSummaryInfo fromUser, @NotNull UserProxy.MatchSuccess inAppMatchEvent) {
            int i;
            int i2;
            int i3;
            Intrinsics.checkNotNullParameter(toUser, "toUser");
            Intrinsics.checkNotNullParameter(fromUser, "fromUser");
            Intrinsics.checkNotNullParameter(inAppMatchEvent, "inAppMatchEvent");
            if (toUser.getSex() == 1) {
                i = R.drawable.bg_age_male;
            } else {
                i = R.drawable.bg_age_female;
            }
            if (toUser.getSex() == 1) {
                i2 = R.drawable.icon_boy;
            } else {
                i2 = R.drawable.icon_girl;
            }
            if (1 == toUser.getSex()) {
                i3 = R.drawable.icon_gender_boy;
            } else {
                i3 = R.drawable.icon_gender_girl;
            }
            long waitDuration = inAppMatchEvent.getWaitDuration();
            String matchUniqueId = inAppMatchEvent.getMatchUniqueId();
            Intrinsics.checkNotNullExpressionValue(matchUniqueId, "getMatchUniqueId(...)");
            return new MatchingActionPendingUIModel(toUser, fromUser, waitDuration, null, i, i2, i3, matchUniqueId, String.valueOf(GenderPreferenceViewController.INSTANCE.hasPreferenceCategory().getCode()), RegionPreferenceViewController.INSTANCE.hasPreferenceCategory(), null, inAppMatchEvent.getStatus(), 0, inAppMatchEvent.getSingleWaitTimeInSec(), inAppMatchEvent.getDualWaitTimeInSec(), 5128, null);
        }

        private Companion() {
        }
    }

    public MatchingActionPendingUIModel(@NotNull User user, @NotNull UserSummaryInfo userSummaryInfo, long j, @NotNull DoneType doneType, int i, int i2, int i3, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(user, "toUser");
        Intrinsics.checkNotNullParameter(userSummaryInfo, "fromUser");
        Intrinsics.checkNotNullParameter(doneType, "doneType");
        Intrinsics.checkNotNullParameter(str, VideoResultActivity.VIDEO_MATCH_UNIQUE_ID);
        Intrinsics.checkNotNullParameter(str2, "conditionGender");
        Intrinsics.checkNotNullParameter(str3, "conditionRegion");
        Intrinsics.checkNotNullParameter(str4, "debug");
        this.toUser = user;
        this.fromUser = userSummaryInfo;
        this.waitDuration = j;
        this.doneType = doneType;
        this.toUserSexBackgroundResID = i;
        this.toUserSexIconDrawableResID = i2;
        this.toUserDefaultAvtarResID = i3;
        this.matchUniqueID = str;
        this.conditionGender = str2;
        this.conditionRegion = str3;
        this.debug = str4;
        this.isOnlineUser = z;
        this.from = i4;
        this.singleWaitTimeInSec = i5;
        this.dualWaitTimeInSec = i6;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final User getToUser() {
        return this.toUser;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getConditionRegion() {
        return this.conditionRegion;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final String getDebug() {
        return this.debug;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIsOnlineUser() {
        return this.isOnlineUser;
    }

    /* renamed from: component13, reason: from getter */
    public final int getFrom() {
        return this.from;
    }

    /* renamed from: component14, reason: from getter */
    public final int getSingleWaitTimeInSec() {
        return this.singleWaitTimeInSec;
    }

    /* renamed from: component15, reason: from getter */
    public final int getDualWaitTimeInSec() {
        return this.dualWaitTimeInSec;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final UserSummaryInfo getFromUser() {
        return this.fromUser;
    }

    /* renamed from: component3, reason: from getter */
    public final long getWaitDuration() {
        return this.waitDuration;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final DoneType getDoneType() {
        return this.doneType;
    }

    /* renamed from: component5, reason: from getter */
    public final int getToUserSexBackgroundResID() {
        return this.toUserSexBackgroundResID;
    }

    /* renamed from: component6, reason: from getter */
    public final int getToUserSexIconDrawableResID() {
        return this.toUserSexIconDrawableResID;
    }

    /* renamed from: component7, reason: from getter */
    public final int getToUserDefaultAvtarResID() {
        return this.toUserDefaultAvtarResID;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getMatchUniqueID() {
        return this.matchUniqueID;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getConditionGender() {
        return this.conditionGender;
    }

    @NotNull
    public final MatchingActionPendingUIModel copy(@NotNull User toUser, @NotNull UserSummaryInfo fromUser, long waitDuration, @NotNull DoneType doneType, int toUserSexBackgroundResID, int toUserSexIconDrawableResID, int toUserDefaultAvtarResID, @NotNull String matchUniqueID, @NotNull String conditionGender, @NotNull String conditionRegion, @NotNull String debug, boolean isOnlineUser, int from, int singleWaitTimeInSec, int dualWaitTimeInSec) {
        Intrinsics.checkNotNullParameter(toUser, "toUser");
        Intrinsics.checkNotNullParameter(fromUser, "fromUser");
        Intrinsics.checkNotNullParameter(doneType, "doneType");
        Intrinsics.checkNotNullParameter(matchUniqueID, VideoResultActivity.VIDEO_MATCH_UNIQUE_ID);
        Intrinsics.checkNotNullParameter(conditionGender, "conditionGender");
        Intrinsics.checkNotNullParameter(conditionRegion, "conditionRegion");
        Intrinsics.checkNotNullParameter(debug, "debug");
        return new MatchingActionPendingUIModel(toUser, fromUser, waitDuration, doneType, toUserSexBackgroundResID, toUserSexIconDrawableResID, toUserDefaultAvtarResID, matchUniqueID, conditionGender, conditionRegion, debug, isOnlineUser, from, singleWaitTimeInSec, dualWaitTimeInSec);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatchingActionPendingUIModel)) {
            return false;
        }
        MatchingActionPendingUIModel matchingActionPendingUIModel = (MatchingActionPendingUIModel) other;
        return Intrinsics.areEqual(this.toUser, matchingActionPendingUIModel.toUser) && Intrinsics.areEqual(this.fromUser, matchingActionPendingUIModel.fromUser) && this.waitDuration == matchingActionPendingUIModel.waitDuration && this.doneType == matchingActionPendingUIModel.doneType && this.toUserSexBackgroundResID == matchingActionPendingUIModel.toUserSexBackgroundResID && this.toUserSexIconDrawableResID == matchingActionPendingUIModel.toUserSexIconDrawableResID && this.toUserDefaultAvtarResID == matchingActionPendingUIModel.toUserDefaultAvtarResID && Intrinsics.areEqual(this.matchUniqueID, matchingActionPendingUIModel.matchUniqueID) && Intrinsics.areEqual(this.conditionGender, matchingActionPendingUIModel.conditionGender) && Intrinsics.areEqual(this.conditionRegion, matchingActionPendingUIModel.conditionRegion) && Intrinsics.areEqual(this.debug, matchingActionPendingUIModel.debug) && this.isOnlineUser == matchingActionPendingUIModel.isOnlineUser && this.from == matchingActionPendingUIModel.from && this.singleWaitTimeInSec == matchingActionPendingUIModel.singleWaitTimeInSec && this.dualWaitTimeInSec == matchingActionPendingUIModel.dualWaitTimeInSec;
    }

    @NotNull
    public final String getConditionGender() {
        return this.conditionGender;
    }

    @NotNull
    public final String getConditionRegion() {
        return this.conditionRegion;
    }

    @NotNull
    public final String getDebug() {
        return this.debug;
    }

    @NotNull
    public final DoneType getDoneType() {
        return this.doneType;
    }

    public final int getDualWaitTimeInSec() {
        return this.dualWaitTimeInSec;
    }

    public final int getFrom() {
        return this.from;
    }

    @NotNull
    public final UserSummaryInfo getFromUser() {
        return this.fromUser;
    }

    @NotNull
    public final String getMatchUniqueID() {
        return this.matchUniqueID;
    }

    public final int getSingleWaitTimeInSec() {
        return this.singleWaitTimeInSec;
    }

    @NotNull
    public final User getToUser() {
        return this.toUser;
    }

    public final int getToUserDefaultAvtarResID() {
        return this.toUserDefaultAvtarResID;
    }

    public final int getToUserSexBackgroundResID() {
        return this.toUserSexBackgroundResID;
    }

    public final int getToUserSexIconDrawableResID() {
        return this.toUserSexIconDrawableResID;
    }

    public final long getWaitDuration() {
        return this.waitDuration;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.toUser.hashCode() * 31) + this.fromUser.hashCode()) * 31) + c.a(this.waitDuration)) * 31) + this.doneType.hashCode()) * 31) + this.toUserSexBackgroundResID) * 31) + this.toUserSexIconDrawableResID) * 31) + this.toUserDefaultAvtarResID) * 31) + this.matchUniqueID.hashCode()) * 31) + this.conditionGender.hashCode()) * 31) + this.conditionRegion.hashCode()) * 31) + this.debug.hashCode()) * 31) + a.a(this.isOnlineUser)) * 31) + this.from) * 31) + this.singleWaitTimeInSec) * 31) + this.dualWaitTimeInSec;
    }

    public final boolean isOnlineUser() {
        return this.isOnlineUser;
    }

    public final void setDebug(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.debug = str;
    }

    public final void setDoneType(@NotNull DoneType doneType) {
        Intrinsics.checkNotNullParameter(doneType, "<set-?>");
        this.doneType = doneType;
    }

    public final void setFrom(int i) {
        this.from = i;
    }

    @NotNull
    public String toString() {
        return "MatchingActionPendingUIModel(toUser=" + this.toUser + ", fromUser=" + this.fromUser + ", waitDuration=" + this.waitDuration + ", doneType=" + this.doneType + ", toUserSexBackgroundResID=" + this.toUserSexBackgroundResID + ", toUserSexIconDrawableResID=" + this.toUserSexIconDrawableResID + ", toUserDefaultAvtarResID=" + this.toUserDefaultAvtarResID + ", matchUniqueID=" + this.matchUniqueID + ", conditionGender=" + this.conditionGender + ", conditionRegion=" + this.conditionRegion + ", debug=" + this.debug + ", isOnlineUser=" + this.isOnlineUser + ", from=" + this.from + ", singleWaitTimeInSec=" + this.singleWaitTimeInSec + ", dualWaitTimeInSec=" + this.dualWaitTimeInSec + ")";
    }

    public /* synthetic */ MatchingActionPendingUIModel(User user, UserSummaryInfo userSummaryInfo, long j, DoneType doneType, int i, int i2, int i3, String str, String str2, String str3, String str4, boolean z, int i4, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, userSummaryInfo, j, (i7 & 8) != 0 ? DoneType.N_A : doneType, i, i2, i3, str, str2, str3, (i7 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? "" : str4, (i7 & 2048) != 0 ? false : z, (i7 & 4096) != 0 ? 0 : i4, (i7 & 8192) != 0 ? 5 : i5, (i7 & 16384) != 0 ? 5 : i6);
    }
}
