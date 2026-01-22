package com.qiahao.base_common.model.im;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/qiahao/base_common/model/im/SheepMatchMessage;", "", "identifier", "", "matchId", "", "coverUrl", "gameId", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getIdentifier", "()Ljava/lang/String;", "getMatchId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCoverUrl", "getGameId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/qiahao/base_common/model/im/SheepMatchMessage;", "equals", "", "other", "hashCode", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class SheepMatchMessage {

    @Nullable
    private final String coverUrl;

    @Nullable
    private final Integer gameId;

    @Nullable
    private final String identifier;

    @Nullable
    private final Integer matchId;

    public SheepMatchMessage() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SheepMatchMessage copy$default(SheepMatchMessage sheepMatchMessage, String str, Integer num, String str2, Integer num2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = sheepMatchMessage.identifier;
        }
        if ((i10 & 2) != 0) {
            num = sheepMatchMessage.matchId;
        }
        if ((i10 & 4) != 0) {
            str2 = sheepMatchMessage.coverUrl;
        }
        if ((i10 & 8) != 0) {
            num2 = sheepMatchMessage.gameId;
        }
        return sheepMatchMessage.copy(str, num, str2, num2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getMatchId() {
        return this.matchId;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getGameId() {
        return this.gameId;
    }

    @NotNull
    public final SheepMatchMessage copy(@Nullable String identifier, @Nullable Integer matchId, @Nullable String coverUrl, @Nullable Integer gameId) {
        return new SheepMatchMessage(identifier, matchId, coverUrl, gameId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SheepMatchMessage)) {
            return false;
        }
        SheepMatchMessage sheepMatchMessage = (SheepMatchMessage) other;
        return Intrinsics.areEqual(this.identifier, sheepMatchMessage.identifier) && Intrinsics.areEqual(this.matchId, sheepMatchMessage.matchId) && Intrinsics.areEqual(this.coverUrl, sheepMatchMessage.coverUrl) && Intrinsics.areEqual(this.gameId, sheepMatchMessage.gameId);
    }

    @Nullable
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @Nullable
    public final Integer getGameId() {
        return this.gameId;
    }

    @Nullable
    public final String getIdentifier() {
        return this.identifier;
    }

    @Nullable
    public final Integer getMatchId() {
        return this.matchId;
    }

    public int hashCode() {
        String str = this.identifier;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.matchId;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.coverUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num2 = this.gameId;
        return hashCode3 + (num2 != null ? num2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SheepMatchMessage(identifier=" + this.identifier + ", matchId=" + this.matchId + ", coverUrl=" + this.coverUrl + ", gameId=" + this.gameId + ")";
    }

    public SheepMatchMessage(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable Integer num2) {
        this.identifier = str;
        this.matchId = num;
        this.coverUrl = str2;
        this.gameId = num2;
    }

    public /* synthetic */ SheepMatchMessage(String str, Integer num, String str2, Integer num2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : num2);
    }
}
