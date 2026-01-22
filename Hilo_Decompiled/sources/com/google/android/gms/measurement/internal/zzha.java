package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzha extends BroadcastReceiver {
    private final zzpf zza;
    private boolean zzb;
    private boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzha(zzpf zzpfVar) {
        Preconditions.checkNotNull(zzpfVar);
        this.zza = zzpfVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        zzpf zzpfVar = this.zza;
        zzpfVar.zzu();
        String action = intent.getAction();
        zzpfVar.zzaV().zzk().zzb("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zzb = zzpfVar.zzi().zzb();
            if (this.zzc != zzb) {
                this.zzc = zzb;
                zzpfVar.zzaW().zzj(new zzgz(this, zzb));
                return;
            }
            return;
        }
        zzpfVar.zzaV().zze().zzb("NetworkBroadcastReceiver received unknown action", action);
    }

    public final void zza() {
        zzpf zzpfVar = this.zza;
        zzpfVar.zzu();
        zzpfVar.zzaW().zzg();
        if (this.zzb) {
            return;
        }
        zzpfVar.zzaY().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.zzc = zzpfVar.zzi().zzb();
        zzpfVar.zzaV().zzk().zzb("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzc));
        this.zzb = true;
    }

    public final void zzb() {
        zzpf zzpfVar = this.zza;
        zzpfVar.zzu();
        zzpfVar.zzaW().zzg();
        zzpfVar.zzaW().zzg();
        if (!this.zzb) {
            return;
        }
        zzpfVar.zzaV().zzk().zza("Unregistering connectivity change receiver");
        this.zzb = false;
        this.zzc = false;
        try {
            zzpfVar.zzaY().unregisterReceiver(this);
        } catch (IllegalArgumentException e10) {
            this.zza.zzaV().zzb().zzb("Failed to unregister the network broadcast receiver", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzpf zzc() {
        return this.zza;
    }
}
