package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import com.facebook.internal.NativeProtocol;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzoj extends zzor {
    private final AlarmManager zza;
    private zzay zzb;
    private Integer zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzoj(zzpf zzpfVar) {
        super(zzpfVar);
        this.zza = (AlarmManager) this.zzu.zzaY().getSystemService("alarm");
    }

    private final zzay zzf() {
        if (this.zzb == null) {
            this.zzb = new zzoi(this, this.zzg.zzaf());
        }
        return this.zzb;
    }

    @TargetApi(24)
    private final void zzh() {
        JobScheduler jobScheduler = (JobScheduler) this.zzu.zzaY().getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(zzi());
        }
    }

    private final int zzi() {
        if (this.zzc == null) {
            this.zzc = Integer.valueOf("measurement".concat(String.valueOf(this.zzu.zzaY().getPackageName())).hashCode());
        }
        return this.zzc.intValue();
    }

    private final PendingIntent zzj() {
        Context zzaY = this.zzu.zzaY();
        return PendingIntent.getBroadcast(zzaY, 0, new Intent().setClassName(zzaY, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), com.google.android.gms.internal.measurement.zzcg.zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzor
    protected final boolean zzbb() {
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzj());
        }
        if (Build.VERSION.SDK_INT >= 24) {
            zzh();
            return false;
        }
        return false;
    }

    public final void zzc(long j10) {
        zzay();
        zzib zzibVar = this.zzu;
        zzibVar.zzaU();
        Context zzaY = zzibVar.zzaY();
        if (!zzpo.zzau(zzaY)) {
            zzibVar.zzaV().zzj().zza("Receiver not registered/enabled");
        }
        if (!zzpo.zzQ(zzaY, false)) {
            zzibVar.zzaV().zzj().zza("Service not registered/enabled");
        }
        zzd();
        zzibVar.zzaV().zzk().zzb("Scheduling upload, millis", Long.valueOf(j10));
        long elapsedRealtime = zzibVar.zzaZ().elapsedRealtime() + j10;
        zzibVar.zzc();
        if (j10 < Math.max(0L, ((Long) zzfx.zzL.zzb(null)).longValue()) && !zzf().zzc()) {
            zzf().zzb(j10);
        }
        zzibVar.zzaU();
        if (Build.VERSION.SDK_INT >= 24) {
            Context zzaY2 = zzibVar.zzaY();
            ComponentName componentName = new ComponentName(zzaY2, "com.google.android.gms.measurement.AppMeasurementJobService");
            int zzi = zzi();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "com.google.android.gms.measurement.UPLOAD");
            com.google.android.gms.internal.measurement.zzch.zza(zzaY2, new JobInfo.Builder(zzi, componentName).setMinimumLatency(j10).setOverrideDeadline(j10 + j10).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
            return;
        }
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            zzibVar.zzc();
            alarmManager.setInexactRepeating(2, elapsedRealtime, Math.max(((Long) zzfx.zzG.zzb(null)).longValue(), j10), zzj());
        }
    }

    public final void zzd() {
        zzay();
        this.zzu.zzaV().zzk().zza("Unscheduling upload");
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzj());
        }
        zzf().zzd();
        if (Build.VERSION.SDK_INT >= 24) {
            zzh();
        }
    }
}
