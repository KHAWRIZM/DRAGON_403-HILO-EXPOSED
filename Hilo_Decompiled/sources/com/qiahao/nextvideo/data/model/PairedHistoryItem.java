package com.qiahao.nextvideo.data.model;

import com.qiahao.base_common.model.common.User;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013J:\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0015\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006$"}, d2 = {"Lcom/qiahao/nextvideo/data/model/PairedHistoryItem;", "", "matchID", "", "matchAt", "", "user", "Lcom/qiahao/base_common/model/common/User;", "hasRead", "", "<init>", "(Ljava/lang/String;JLcom/qiahao/base_common/model/common/User;Ljava/lang/Boolean;)V", "getMatchID", "()Ljava/lang/String;", "getMatchAt", "()J", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "getHasRead", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "isFreeMessage", "()Z", "isLike", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;JLcom/qiahao/base_common/model/common/User;Ljava/lang/Boolean;)Lcom/qiahao/nextvideo/data/model/PairedHistoryItem;", "equals", "other", "hashCode", "", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class PairedHistoryItem {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    @c("hasRead")
    private final Boolean hasRead;
    private final boolean isLike;

    @c("matchTime")
    private final long matchAt;

    @NotNull
    @c(AgooConstants.MESSAGE_ID)
    private final String matchID;

    @Nullable
    @c("userDetail")
    private final User user;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/nextvideo/data/model/PairedHistoryItem$Companion;", "", "<init>", "()V", "fake", "Lcom/qiahao/nextvideo/data/model/PairedHistoryItem;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PairedHistoryItem fake() {
            return new PairedHistoryItem(String.valueOf(System.currentTimeMillis()), System.currentTimeMillis() / 1000, User.Companion.fake(), null, 8, null);
        }

        private Companion() {
        }
    }

    public PairedHistoryItem(@NotNull String str, long j, @Nullable User user, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "matchID");
        this.matchID = str;
        this.matchAt = j;
        this.user = user;
        this.hasRead = bool;
        this.isLike = user != null ? Intrinsics.areEqual(user.isLike(), Boolean.TRUE) : false;
    }

    public static /* synthetic */ PairedHistoryItem copy$default(PairedHistoryItem pairedHistoryItem, String str, long j, User user, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pairedHistoryItem.matchID;
        }
        if ((i & 2) != 0) {
            j = pairedHistoryItem.matchAt;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            user = pairedHistoryItem.user;
        }
        User user2 = user;
        if ((i & 8) != 0) {
            bool = pairedHistoryItem.hasRead;
        }
        return pairedHistoryItem.copy(str, j2, user2, bool);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getMatchID() {
        return this.matchID;
    }

    /* renamed from: component2, reason: from getter */
    public final long getMatchAt() {
        return this.matchAt;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Boolean getHasRead() {
        return this.hasRead;
    }

    @NotNull
    public final PairedHistoryItem copy(@NotNull String matchID, long matchAt, @Nullable User user, @Nullable Boolean hasRead) {
        Intrinsics.checkNotNullParameter(matchID, "matchID");
        return new PairedHistoryItem(matchID, matchAt, user, hasRead);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PairedHistoryItem)) {
            return false;
        }
        PairedHistoryItem pairedHistoryItem = (PairedHistoryItem) other;
        return Intrinsics.areEqual(this.matchID, pairedHistoryItem.matchID) && this.matchAt == pairedHistoryItem.matchAt && Intrinsics.areEqual(this.user, pairedHistoryItem.user) && Intrinsics.areEqual(this.hasRead, pairedHistoryItem.hasRead);
    }

    @Nullable
    public final Boolean getHasRead() {
        return this.hasRead;
    }

    public final long getMatchAt() {
        return this.matchAt;
    }

    @NotNull
    public final String getMatchID() {
        return this.matchID;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        int hashCode = ((this.matchID.hashCode() * 31) + androidx.collection.c.a(this.matchAt)) * 31;
        User user = this.user;
        int hashCode2 = (hashCode + (user == null ? 0 : user.hashCode())) * 31;
        Boolean bool = this.hasRead;
        return hashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public final boolean isFreeMessage() {
        User user = this.user;
        if (user != null) {
            return Intrinsics.areEqual(user.isSession(), Boolean.TRUE);
        }
        return false;
    }

    /* renamed from: isLike, reason: from getter */
    public final boolean getIsLike() {
        return this.isLike;
    }

    @NotNull
    public String toString() {
        return "PairedHistoryItem(matchID=" + this.matchID + ", matchAt=" + this.matchAt + ", user=" + this.user + ", hasRead=" + this.hasRead + ")";
    }

    public /* synthetic */ PairedHistoryItem(String str, long j, User user, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, user, (i & 8) != 0 ? null : bool);
    }
}
