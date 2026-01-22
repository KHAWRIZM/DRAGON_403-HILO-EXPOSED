package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import io.agora.rtc.Constants;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzne implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zznk zza;
    private volatile boolean zzb;
    private volatile zzgn zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzne(zznk zznkVar) {
        Objects.requireNonNull(zznkVar);
        this.zza = zznkVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.zza.zzu.zzaW().zzd();
        synchronized (this) {
            try {
                Preconditions.checkNotNull(this.zzc);
                this.zza.zzu.zzaW().zzj(new zzmz(this, (zzga) this.zzc.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zzc = null;
                this.zzb = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zznk zznkVar = this.zza;
        zznkVar.zzu.zzaW().zzd();
        zzgt zzf = zznkVar.zzu.zzf();
        if (zzf != null) {
            zzf.zzk().zzb("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzb = false;
            this.zzc = null;
        }
        this.zza.zzu.zzaW().zzj(new zznd(this, connectionResult));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i10) {
        zzib zzibVar = this.zza.zzu;
        zzibVar.zzaW().zzd();
        zzibVar.zzaV().zzj().zza("Service connection suspended");
        zzibVar.zzaW().zzj(new zzna(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzga zzfyVar;
        this.zza.zzu.zzaW().zzd();
        synchronized (this) {
            if (iBinder == null) {
                this.zzb = false;
                this.zza.zzu.zzaV().zzb().zza("Service connected with null binder");
                return;
            }
            zzga zzgaVar = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (queryLocalInterface instanceof zzga) {
                        zzfyVar = (zzga) queryLocalInterface;
                    } else {
                        zzfyVar = new zzfy(iBinder);
                    }
                    zzgaVar = zzfyVar;
                    this.zza.zzu.zzaV().zzk().zza("Bound to IMeasurementService interface");
                } else {
                    this.zza.zzu.zzaV().zzb().zzb("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.zza.zzu.zzaV().zzb().zza("Service connect failed to get IMeasurementService");
            }
            if (zzgaVar == null) {
                this.zzb = false;
                try {
                    ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                    zznk zznkVar = this.zza;
                    connectionTracker.unbindService(zznkVar.zzu.zzaY(), zznkVar.zzY());
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.zza.zzu.zzaW().zzj(new zzmx(this, zzgaVar));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzib zzibVar = this.zza.zzu;
        zzibVar.zzaW().zzd();
        zzibVar.zzaV().zzj().zza("Service disconnected");
        zzibVar.zzaW().zzj(new zzmy(this, componentName));
    }

    public final void zza(Intent intent) {
        zznk zznkVar = this.zza;
        zznkVar.zzg();
        Context zzaY = zznkVar.zzu.zzaY();
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (this) {
            try {
                if (this.zzb) {
                    this.zza.zzu.zzaV().zzk().zza("Connection attempt already in progress");
                    return;
                }
                zznk zznkVar2 = this.zza;
                zznkVar2.zzu.zzaV().zzk().zza("Using local app measurement service");
                this.zzb = true;
                connectionTracker.bindService(zzaY, intent, zznkVar2.zzY(), Constants.ERR_WATERMARK_READ);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzb() {
        if (this.zzc != null && (this.zzc.isConnected() || this.zzc.isConnecting())) {
            this.zzc.disconnect();
        }
        this.zzc = null;
    }

    public final void zzc() {
        zznk zznkVar = this.zza;
        zznkVar.zzg();
        Context zzaY = zznkVar.zzu.zzaY();
        synchronized (this) {
            try {
                if (this.zzb) {
                    this.zza.zzu.zzaV().zzk().zza("Connection attempt already in progress");
                    return;
                }
                if (this.zzc != null && (this.zzc.isConnecting() || this.zzc.isConnected())) {
                    this.zza.zzu.zzaV().zzk().zza("Already awaiting connection attempt");
                    return;
                }
                this.zzc = new zzgn(zzaY, Looper.getMainLooper(), this, this);
                this.zza.zzu.zzaV().zzk().zza("Connecting to remote service");
                this.zzb = true;
                Preconditions.checkNotNull(this.zzc);
                this.zzc.checkAvailabilityAndConnect();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(boolean z10) {
        this.zzb = false;
    }
}
