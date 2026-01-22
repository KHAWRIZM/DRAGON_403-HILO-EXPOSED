package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzns {
    private final Context zza;

    public zzns(Context context) {
        Preconditions.checkNotNull(context);
        this.zza = context;
    }

    public static final void zzi(Intent intent) {
        if (intent == null) {
            Log.e("FA", "onRebind called with null intent");
        } else {
            Log.v("FA", "onRebind called. action: ".concat(String.valueOf(intent.getAction())));
        }
    }

    public static final boolean zzj(Intent intent) {
        if (intent == null) {
            Log.e("FA", "onUnbind called with null intent");
            return true;
        }
        Log.v("FA", "onUnbind called for intent. action: ".concat(String.valueOf(intent.getAction())));
        return true;
    }

    private final void zzk(zzpf zzpfVar, Runnable runnable) {
        zzpfVar.zzaW().zzj(new zznn(this, zzpfVar, runnable));
    }

    public final void zza() {
        Log.v("FA", this.zza.getClass().getSimpleName().concat(" is starting up."));
    }

    public final void zzb() {
        Log.v("FA", this.zza.getClass().getSimpleName().concat(" is shutting down."));
    }

    public final int zzc(final Intent intent, int i10, final int i11) {
        if (intent == null) {
            Log.w("FA", "AppMeasurementService started with null intent");
            return 2;
        }
        Context context = this.zza;
        zzib zzy = zzib.zzy(context, null, null);
        final zzgt zzaV = zzy.zzaV();
        String action = intent.getAction();
        zzy.zzaU();
        zzaV.zzk().zzc("Local AppMeasurementService called. startId, action", Integer.valueOf(i11), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zzk(zzpf.zza(context), new Runnable() { // from class: com.google.android.gms.measurement.internal.zznr
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzns.this.zzf(i11, zzaV, intent);
                }
            });
        }
        return 2;
    }

    public final IBinder zzd(Intent intent) {
        if (intent == null) {
            Log.e("FA", "onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzjc(zzpf.zza(this.zza), null);
        }
        Log.w("FA", "onBind received unknown action: ".concat(String.valueOf(action)));
        return null;
    }

    @TargetApi(24)
    public final boolean zze(final JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString(NativeProtocol.WEB_DIALOG_ACTION);
        Log.v("FA", "onStartJob received action: ".concat(String.valueOf(string)));
        if (Objects.equals(string, "com.google.android.gms.measurement.UPLOAD")) {
            String str = (String) Preconditions.checkNotNull(string);
            zzpf zza = zzpf.zza(this.zza);
            final zzgt zzaV = zza.zzaV();
            zza.zzaU();
            zzaV.zzk().zzb("Local AppMeasurementJobService called. action", str);
            zzk(zza, new Runnable() { // from class: com.google.android.gms.measurement.internal.zznp
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzns.this.zzg(zzaV, jobParameters);
                }
            });
        }
        if (Objects.equals(string, "com.google.android.gms.measurement.SCION_UPLOAD")) {
            com.google.android.gms.internal.measurement.zzfb.zza(this.zza, null).zzw(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznq
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzns.this.zzh(jobParameters);
                }
            });
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void zzf(int i10, zzgt zzgtVar, Intent intent) {
        Context context = this.zza;
        zzno zznoVar = (zzno) context;
        if (zznoVar.zza(i10)) {
            zzgtVar.zzk().zzb("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i10));
            zzib.zzy(context, null, null).zzaV().zzk().zza("Completed wakeful intent.");
            zznoVar.zzc(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzgt zzgtVar, JobParameters jobParameters) {
        zzgtVar.zzk().zza("AppMeasurementJobService processed last upload request.");
        ((zzno) this.zza).zzb(jobParameters, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(JobParameters jobParameters) {
        Log.v("FA", "[sgtm] AppMeasurementJobService processed last Scion upload request.");
        ((zzno) this.zza).zzb(jobParameters, false);
    }
}
