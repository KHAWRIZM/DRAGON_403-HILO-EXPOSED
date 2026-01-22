package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.ui.videocall.VideoResultActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;
import userProxy.UserProxy;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MatchConfig;", "", "waitDuration", "", "localUserID", "", "remoteUserID", VideoResultActivity.VIDEO_MATCH_UNIQUE_ID, "isAloneUser", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getWaitDuration", "()J", "getLocalUserID", "()Ljava/lang/String;", "getRemoteUserID", "getMatchUniqueID", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MatchConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final boolean isAloneUser;

    @NotNull
    private final String localUserID;

    @NotNull
    private final String matchUniqueID;

    @NotNull
    private final String remoteUserID;
    private final long waitDuration;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MatchConfig$Companion;", "", "<init>", "()V", "fake", "Lcom/qiahao/nextvideo/data/model/MatchConfig;", "init", "matchSuccess", "LuserProxy/UserProxy$MatchSuccess;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MatchConfig fake() {
            String str;
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user == null || (str = user.getExternalId()) == null) {
                str = "";
            }
            return new MatchConfig(15L, str, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis()), false, 16, null);
        }

        @NotNull
        public final MatchConfig init(@NotNull UserProxy.MatchSuccess matchSuccess) {
            Intrinsics.checkNotNullParameter(matchSuccess, "matchSuccess");
            String localUserId = matchSuccess.getLocalUserId();
            Intrinsics.checkNotNullExpressionValue(localUserId, "getLocalUserId(...)");
            String remoteUserId = matchSuccess.getRemoteUserId();
            Intrinsics.checkNotNullExpressionValue(remoteUserId, "getRemoteUserId(...)");
            String matchUniqueId = matchSuccess.getMatchUniqueId();
            Intrinsics.checkNotNullExpressionValue(matchUniqueId, "getMatchUniqueId(...)");
            return new MatchConfig(matchSuccess.getWaitDuration(), localUserId, remoteUserId, matchUniqueId, matchSuccess.getStatus());
        }

        private Companion() {
        }
    }

    public MatchConfig(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "localUserID");
        Intrinsics.checkNotNullParameter(str2, "remoteUserID");
        Intrinsics.checkNotNullParameter(str3, VideoResultActivity.VIDEO_MATCH_UNIQUE_ID);
        this.waitDuration = j;
        this.localUserID = str;
        this.remoteUserID = str2;
        this.matchUniqueID = str3;
        this.isAloneUser = z;
    }

    public static /* synthetic */ MatchConfig copy$default(MatchConfig matchConfig, long j, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = matchConfig.waitDuration;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = matchConfig.localUserID;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = matchConfig.remoteUserID;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = matchConfig.matchUniqueID;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            z = matchConfig.isAloneUser;
        }
        return matchConfig.copy(j2, str4, str5, str6, z);
    }

    /* renamed from: component1, reason: from getter */
    public final long getWaitDuration() {
        return this.waitDuration;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getLocalUserID() {
        return this.localUserID;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getRemoteUserID() {
        return this.remoteUserID;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getMatchUniqueID() {
        return this.matchUniqueID;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsAloneUser() {
        return this.isAloneUser;
    }

    @NotNull
    public final MatchConfig copy(long waitDuration, @NotNull String localUserID, @NotNull String remoteUserID, @NotNull String matchUniqueID, boolean isAloneUser) {
        Intrinsics.checkNotNullParameter(localUserID, "localUserID");
        Intrinsics.checkNotNullParameter(remoteUserID, "remoteUserID");
        Intrinsics.checkNotNullParameter(matchUniqueID, VideoResultActivity.VIDEO_MATCH_UNIQUE_ID);
        return new MatchConfig(waitDuration, localUserID, remoteUserID, matchUniqueID, isAloneUser);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatchConfig)) {
            return false;
        }
        MatchConfig matchConfig = (MatchConfig) other;
        return this.waitDuration == matchConfig.waitDuration && Intrinsics.areEqual(this.localUserID, matchConfig.localUserID) && Intrinsics.areEqual(this.remoteUserID, matchConfig.remoteUserID) && Intrinsics.areEqual(this.matchUniqueID, matchConfig.matchUniqueID) && this.isAloneUser == matchConfig.isAloneUser;
    }

    @NotNull
    public final String getLocalUserID() {
        return this.localUserID;
    }

    @NotNull
    public final String getMatchUniqueID() {
        return this.matchUniqueID;
    }

    @NotNull
    public final String getRemoteUserID() {
        return this.remoteUserID;
    }

    public final long getWaitDuration() {
        return this.waitDuration;
    }

    public int hashCode() {
        return (((((((c.a(this.waitDuration) * 31) + this.localUserID.hashCode()) * 31) + this.remoteUserID.hashCode()) * 31) + this.matchUniqueID.hashCode()) * 31) + a.a(this.isAloneUser);
    }

    public final boolean isAloneUser() {
        return this.isAloneUser;
    }

    @NotNull
    public String toString() {
        return "MatchConfig(waitDuration=" + this.waitDuration + ", localUserID=" + this.localUserID + ", remoteUserID=" + this.remoteUserID + ", matchUniqueID=" + this.matchUniqueID + ", isAloneUser=" + this.isAloneUser + ")";
    }

    public /* synthetic */ MatchConfig(long j, String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, str2, str3, (i & 16) != 0 ? false : z);
    }
}
