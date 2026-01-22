package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzhw extends FutureTask implements Comparable {
    final boolean zza;
    final /* synthetic */ zzhy zzb;
    private final long zzc;
    private final String zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzhw(zzhy zzhyVar, Runnable runnable, boolean z10, String str) {
        super(runnable, null);
        AtomicLong atomicLong;
        Objects.requireNonNull(zzhyVar);
        this.zzb = zzhyVar;
        Preconditions.checkNotNull(str);
        atomicLong = zzhy.zzj;
        long andIncrement = atomicLong.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = str;
        this.zza = z10;
        if (andIncrement == LongCompanionObject.MAX_VALUE) {
            zzhyVar.zzu.zzaV().zzb().zza("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzhw zzhwVar = (zzhw) obj;
        boolean z10 = zzhwVar.zza;
        boolean z11 = this.zza;
        if (z11 != z10) {
            if (z11) {
                return -1;
            }
        } else {
            long j10 = this.zzc;
            long j11 = zzhwVar.zzc;
            if (j10 < j11) {
                return -1;
            }
            if (j10 <= j11) {
                this.zzb.zzu.zzaV().zzc().zzb("Two tasks share the same index. index", Long.valueOf(j10));
                return 0;
            }
        }
        return 1;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        this.zzb.zzu.zzaV().zzb().zzb(this.zzd, th);
        if ((th instanceof zzhu) && (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) != null) {
            defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzhw(zzhy zzhyVar, Callable callable, boolean z10, String str) {
        super(callable);
        AtomicLong atomicLong;
        Objects.requireNonNull(zzhyVar);
        this.zzb = zzhyVar;
        Preconditions.checkNotNull("Task exception on worker thread");
        atomicLong = zzhy.zzj;
        long andIncrement = atomicLong.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = "Task exception on worker thread";
        this.zza = z10;
        if (andIncrement == LongCompanionObject.MAX_VALUE) {
            zzhyVar.zzu.zzaV().zzb().zza("Tasks index overflow");
        }
    }
}
