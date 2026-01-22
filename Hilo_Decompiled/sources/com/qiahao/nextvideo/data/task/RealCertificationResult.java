package com.qiahao.nextvideo.data.task;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/data/task/RealCertificationResult;", "", "status", "", "<init>", "(Ljava/lang/Integer;)V", "getStatus", "()Ljava/lang/Integer;", "setStatus", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/task/RealCertificationResult;", "equals", "", "other", "hashCode", "toString", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class RealCertificationResult {
    public static final int STATUS_DEFAULT = 3;
    public static final int STATUS_NOT_EXAMINE = 0;
    public static final int STATUS_PASS_EXAMINE = 1;
    public static final int STATUS_REJECT_EXAMINE = 2;

    @Nullable
    private Integer status;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RealCertificationResult() {
        this(r0, 1, r0);
        Integer num = null;
    }

    public static /* synthetic */ RealCertificationResult copy$default(RealCertificationResult realCertificationResult, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = realCertificationResult.status;
        }
        return realCertificationResult.copy(num);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getStatus() {
        return this.status;
    }

    @NotNull
    public final RealCertificationResult copy(@Nullable Integer status) {
        return new RealCertificationResult(status);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RealCertificationResult) && Intrinsics.areEqual(this.status, ((RealCertificationResult) other).status);
    }

    @Nullable
    public final Integer getStatus() {
        return this.status;
    }

    public int hashCode() {
        Integer num = this.status;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public final void setStatus(@Nullable Integer num) {
        this.status = num;
    }

    @NotNull
    public String toString() {
        return "RealCertificationResult(status=" + this.status + ")";
    }

    public RealCertificationResult(@Nullable Integer num) {
        this.status = num;
    }

    public /* synthetic */ RealCertificationResult(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num);
    }
}
