package com.qiahao.base_common.utils;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0011\u0010\r\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/qiahao/base_common/utils/CancellableSVGAJob;", "", "job", "Lkotlinx/coroutines/Job;", "<init>", "(Lkotlinx/coroutines/Job;)V", "getJob$base_common_release", "()Lkotlinx/coroutines/Job;", "cancel", "", "isCompleted", "", "()Z", "isCancelled", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CancellableSVGAJob {

    @NotNull
    private final Job job;

    public CancellableSVGAJob(@NotNull Job job) {
        Intrinsics.checkNotNullParameter(job, "job");
        this.job = job;
    }

    public final void cancel() {
        Job.DefaultImpls.cancel$default(this.job, (CancellationException) null, 1, (Object) null);
    }

    @NotNull
    /* renamed from: getJob$base_common_release, reason: from getter */
    public final Job getJob() {
        return this.job;
    }

    public final boolean isCancelled() {
        return this.job.isCancelled();
    }

    public final boolean isCompleted() {
        return this.job.isCompleted();
    }
}
