package com.qiahao.nextvideo.data.model;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB;\u0012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003JC\u0010\u0014\u001a\u00020\u00002$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R2\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/data/model/SystemMatchEvent;", "", "matchedUseridPairs", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "offlineUserId", "matchConfig", "Lcom/qiahao/nextvideo/data/model/MatchConfig;", "<init>", "(Ljava/util/HashMap;Ljava/lang/String;Lcom/qiahao/nextvideo/data/model/MatchConfig;)V", "getMatchedUseridPairs", "()Ljava/util/HashMap;", "getOfflineUserId", "()Ljava/lang/String;", "getMatchConfig", "()Lcom/qiahao/nextvideo/data/model/MatchConfig;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class SystemMatchEvent {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    @c("match_config")
    private final MatchConfig matchConfig;

    @NotNull
    @c("matched_userid_pairs")
    private final HashMap<String, String> matchedUseridPairs;

    @NotNull
    @c("offline_user_id")
    private final String offlineUserId;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/nextvideo/data/model/SystemMatchEvent$Companion;", "", "<init>", "()V", "fake", "Lcom/qiahao/nextvideo/data/model/SystemMatchEvent;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SystemMatchEvent fake() {
            return new SystemMatchEvent(new HashMap(), String.valueOf(System.currentTimeMillis()), MatchConfig.INSTANCE.fake());
        }

        private Companion() {
        }
    }

    public SystemMatchEvent(@NotNull HashMap<String, String> hashMap, @NotNull String str, @NotNull MatchConfig matchConfig) {
        Intrinsics.checkNotNullParameter(hashMap, "matchedUseridPairs");
        Intrinsics.checkNotNullParameter(str, "offlineUserId");
        Intrinsics.checkNotNullParameter(matchConfig, "matchConfig");
        this.matchedUseridPairs = hashMap;
        this.offlineUserId = str;
        this.matchConfig = matchConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SystemMatchEvent copy$default(SystemMatchEvent systemMatchEvent, HashMap hashMap, String str, MatchConfig matchConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            hashMap = systemMatchEvent.matchedUseridPairs;
        }
        if ((i & 2) != 0) {
            str = systemMatchEvent.offlineUserId;
        }
        if ((i & 4) != 0) {
            matchConfig = systemMatchEvent.matchConfig;
        }
        return systemMatchEvent.copy(hashMap, str, matchConfig);
    }

    @NotNull
    public final HashMap<String, String> component1() {
        return this.matchedUseridPairs;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getOfflineUserId() {
        return this.offlineUserId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final MatchConfig getMatchConfig() {
        return this.matchConfig;
    }

    @NotNull
    public final SystemMatchEvent copy(@NotNull HashMap<String, String> matchedUseridPairs, @NotNull String offlineUserId, @NotNull MatchConfig matchConfig) {
        Intrinsics.checkNotNullParameter(matchedUseridPairs, "matchedUseridPairs");
        Intrinsics.checkNotNullParameter(offlineUserId, "offlineUserId");
        Intrinsics.checkNotNullParameter(matchConfig, "matchConfig");
        return new SystemMatchEvent(matchedUseridPairs, offlineUserId, matchConfig);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SystemMatchEvent)) {
            return false;
        }
        SystemMatchEvent systemMatchEvent = (SystemMatchEvent) other;
        return Intrinsics.areEqual(this.matchedUseridPairs, systemMatchEvent.matchedUseridPairs) && Intrinsics.areEqual(this.offlineUserId, systemMatchEvent.offlineUserId) && Intrinsics.areEqual(this.matchConfig, systemMatchEvent.matchConfig);
    }

    @NotNull
    public final MatchConfig getMatchConfig() {
        return this.matchConfig;
    }

    @NotNull
    public final HashMap<String, String> getMatchedUseridPairs() {
        return this.matchedUseridPairs;
    }

    @NotNull
    public final String getOfflineUserId() {
        return this.offlineUserId;
    }

    public int hashCode() {
        return (((this.matchedUseridPairs.hashCode() * 31) + this.offlineUserId.hashCode()) * 31) + this.matchConfig.hashCode();
    }

    @NotNull
    public String toString() {
        return "SystemMatchEvent(matchedUseridPairs=" + this.matchedUseridPairs + ", offlineUserId=" + this.offlineUserId + ", matchConfig=" + this.matchConfig + ")";
    }
}
