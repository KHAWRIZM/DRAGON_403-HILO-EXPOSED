package com.qiahao.nextvideo.data.model;

import com.qiahao.nextvideo.ui.reusable.views.MatchingFloatView;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MatchingFloatData;", "", "avatarUrl", "", Constants.KEY_MODE, "Lcom/qiahao/nextvideo/ui/reusable/views/MatchingFloatView$Mode;", "matchUniqueId", "<init>", "(Ljava/lang/String;Lcom/qiahao/nextvideo/ui/reusable/views/MatchingFloatView$Mode;Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "getMode", "()Lcom/qiahao/nextvideo/ui/reusable/views/MatchingFloatView$Mode;", "setMode", "(Lcom/qiahao/nextvideo/ui/reusable/views/MatchingFloatView$Mode;)V", "getMatchUniqueId", "setMatchUniqueId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MatchingFloatData {

    @NotNull
    private String avatarUrl;

    @NotNull
    private String matchUniqueId;

    @NotNull
    private MatchingFloatView.Mode mode;

    public MatchingFloatData(@NotNull String str, @NotNull MatchingFloatView.Mode mode, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "avatarUrl");
        Intrinsics.checkNotNullParameter(mode, Constants.KEY_MODE);
        Intrinsics.checkNotNullParameter(str2, "matchUniqueId");
        this.avatarUrl = str;
        this.mode = mode;
        this.matchUniqueId = str2;
    }

    public static /* synthetic */ MatchingFloatData copy$default(MatchingFloatData matchingFloatData, String str, MatchingFloatView.Mode mode, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = matchingFloatData.avatarUrl;
        }
        if ((i & 2) != 0) {
            mode = matchingFloatData.mode;
        }
        if ((i & 4) != 0) {
            str2 = matchingFloatData.matchUniqueId;
        }
        return matchingFloatData.copy(str, mode, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final MatchingFloatView.Mode getMode() {
        return this.mode;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getMatchUniqueId() {
        return this.matchUniqueId;
    }

    @NotNull
    public final MatchingFloatData copy(@NotNull String avatarUrl, @NotNull MatchingFloatView.Mode mode, @NotNull String matchUniqueId) {
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(mode, Constants.KEY_MODE);
        Intrinsics.checkNotNullParameter(matchUniqueId, "matchUniqueId");
        return new MatchingFloatData(avatarUrl, mode, matchUniqueId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatchingFloatData)) {
            return false;
        }
        MatchingFloatData matchingFloatData = (MatchingFloatData) other;
        return Intrinsics.areEqual(this.avatarUrl, matchingFloatData.avatarUrl) && this.mode == matchingFloatData.mode && Intrinsics.areEqual(this.matchUniqueId, matchingFloatData.matchUniqueId);
    }

    @NotNull
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @NotNull
    public final String getMatchUniqueId() {
        return this.matchUniqueId;
    }

    @NotNull
    public final MatchingFloatView.Mode getMode() {
        return this.mode;
    }

    public int hashCode() {
        return (((this.avatarUrl.hashCode() * 31) + this.mode.hashCode()) * 31) + this.matchUniqueId.hashCode();
    }

    public final void setAvatarUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatarUrl = str;
    }

    public final void setMatchUniqueId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.matchUniqueId = str;
    }

    public final void setMode(@NotNull MatchingFloatView.Mode mode) {
        Intrinsics.checkNotNullParameter(mode, "<set-?>");
        this.mode = mode;
    }

    @NotNull
    public String toString() {
        return "MatchingFloatData(avatarUrl=" + this.avatarUrl + ", mode=" + this.mode + ", matchUniqueId=" + this.matchUniqueId + ")";
    }

    public /* synthetic */ MatchingFloatData(String str, MatchingFloatView.Mode mode, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, mode, (i & 4) != 0 ? "" : str2);
    }
}
