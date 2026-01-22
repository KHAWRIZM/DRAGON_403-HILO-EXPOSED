package com.qiahao.base_common.model.common;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/qiahao/base_common/model/common/LikeResult;", "", "isLikeEach", "", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "<init>", "(ZZ)V", "()Z", "setLikeEach", "(Z)V", "getStatus", "setStatus", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class LikeResult {
    private boolean isLikeEach;
    private boolean status;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LikeResult() {
        this(r2, r2, 3, null);
        boolean z10 = false;
    }

    public static /* synthetic */ LikeResult copy$default(LikeResult likeResult, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = likeResult.isLikeEach;
        }
        if ((i10 & 2) != 0) {
            z11 = likeResult.status;
        }
        return likeResult.copy(z10, z11);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsLikeEach() {
        return this.isLikeEach;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getStatus() {
        return this.status;
    }

    @NotNull
    public final LikeResult copy(boolean isLikeEach, boolean status) {
        return new LikeResult(isLikeEach, status);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LikeResult)) {
            return false;
        }
        LikeResult likeResult = (LikeResult) other;
        return this.isLikeEach == likeResult.isLikeEach && this.status == likeResult.status;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (a.a(this.isLikeEach) * 31) + a.a(this.status);
    }

    public final boolean isLikeEach() {
        return this.isLikeEach;
    }

    public final void setLikeEach(boolean z10) {
        this.isLikeEach = z10;
    }

    public final void setStatus(boolean z10) {
        this.status = z10;
    }

    @NotNull
    public String toString() {
        return "LikeResult(isLikeEach=" + this.isLikeEach + ", status=" + this.status + ")";
    }

    public LikeResult(boolean z10, boolean z11) {
        this.isLikeEach = z10;
        this.status = z11;
    }

    public /* synthetic */ LikeResult(boolean z10, boolean z11, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? true : z11);
    }
}
