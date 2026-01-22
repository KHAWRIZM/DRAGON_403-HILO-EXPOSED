package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.VisibleForTesting;
import anet.channel.util.HttpConstant;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzlp extends zzg {
    private JobScheduler zza;

    public zzlp(zzib zzibVar) {
        super(zzibVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    @TargetApi(24)
    protected final void zzf() {
        this.zza = (JobScheduler) this.zzu.zzaY().getSystemService("jobscheduler");
    }

    @TargetApi(24)
    public final void zzh(long j10) {
        String str;
        JobInfo pendingJob;
        zzb();
        zzg();
        JobScheduler jobScheduler = this.zza;
        if (jobScheduler != null) {
            pendingJob = jobScheduler.getPendingJob(zzi());
            if (pendingJob != null) {
                this.zzu.zzaV().zzk().zza("[sgtm] There's an existing pending job, skip this schedule.");
                return;
            }
        }
        com.google.android.gms.internal.measurement.zzin zzj = zzj();
        if (zzj == com.google.android.gms.internal.measurement.zzin.CLIENT_UPLOAD_ELIGIBLE) {
            zzib zzibVar = this.zzu;
            zzibVar.zzaV().zzk().zzb("[sgtm] Scheduling Scion upload, millis", Long.valueOf(j10));
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "com.google.android.gms.measurement.SCION_UPLOAD");
            int schedule = ((JobScheduler) Preconditions.checkNotNull(this.zza)).schedule(new JobInfo.Builder(zzi(), new ComponentName(zzibVar.zzaY(), "com.google.android.gms.measurement.AppMeasurementJobService")).setRequiredNetworkType(1).setMinimumLatency(j10).setOverrideDeadline(j10 + j10).setExtras(persistableBundle).build());
            zzgr zzk = zzibVar.zzaV().zzk();
            if (schedule == 1) {
                str = HttpConstant.SUCCESS;
            } else {
                str = "FAILURE";
            }
            zzk.zzb("[sgtm] Scion upload job scheduled with result", str);
            return;
        }
        this.zzu.zzaV().zzk().zzb("[sgtm] Not eligible for Scion upload", zzj.name());
    }

    @VisibleForTesting
    final int zzi() {
        return "measurement-client".concat(String.valueOf(this.zzu.zzaY().getPackageName())).hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.google.android.gms.internal.measurement.zzin zzj() {
        zzb();
        zzg();
        if (this.zza != null) {
            zzib zzibVar = this.zzu;
            if (zzibVar.zzc().zzx()) {
                zzib zzibVar2 = this.zzu;
                if (zzibVar2.zzv().zzn() >= 119000) {
                    if (!zzpo.zzR(zzibVar.zzaY(), "com.google.android.gms.measurement.AppMeasurementJobService")) {
                        return com.google.android.gms.internal.measurement.zzin.MEASUREMENT_SERVICE_NOT_ENABLED;
                    }
                    if (Build.VERSION.SDK_INT >= 24) {
                        if (!zzibVar2.zzt().zzK()) {
                            return com.google.android.gms.internal.measurement.zzin.NON_PLAY_MODE;
                        }
                        return com.google.android.gms.internal.measurement.zzin.CLIENT_UPLOAD_ELIGIBLE;
                    }
                    return com.google.android.gms.internal.measurement.zzin.ANDROID_TOO_OLD;
                }
                return com.google.android.gms.internal.measurement.zzin.SDK_TOO_OLD;
            }
            return com.google.android.gms.internal.measurement.zzin.NOT_ENABLED_IN_MANIFEST;
        }
        return com.google.android.gms.internal.measurement.zzin.MISSING_JOB_SCHEDULER;
    }
}
