package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzo {
    private static final Uri zza = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
    private final String zzb;
    private final String zzc;
    private final ComponentName zzd;
    private final int zze;
    private final boolean zzf;

    public zzo(ComponentName componentName, int i10) {
        this.zzb = null;
        this.zzc = null;
        Preconditions.checkNotNull(componentName);
        this.zzd = componentName;
        this.zze = 4225;
        this.zzf = false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzo)) {
            return false;
        }
        zzo zzoVar = (zzo) obj;
        if (Objects.equal(this.zzb, zzoVar.zzb) && Objects.equal(this.zzc, zzoVar.zzc) && Objects.equal(this.zzd, zzoVar.zzd) && this.zzf == zzoVar.zzf) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb, this.zzc, this.zzd, 4225, Boolean.valueOf(this.zzf));
    }

    public final String toString() {
        String str = this.zzb;
        if (str == null) {
            Preconditions.checkNotNull(this.zzd);
            return this.zzd.flattenToString();
        }
        return str;
    }

    public final ComponentName zza() {
        return this.zzd;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Intent zzb(Context context) throws zzaj {
        Bundle bundle;
        PendingIntent pendingIntent;
        ContentProviderClient acquireUnstableContentProviderClient;
        if (this.zzb != null) {
            Intent intent = null;
            if (this.zzf) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("serviceActionBundleKey", this.zzb);
                try {
                    acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(zza);
                } catch (RemoteException e10) {
                    e = e10;
                    bundle = null;
                    Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                    if (bundle == null) {
                    }
                    if (intent == null) {
                    }
                    if (intent == null) {
                    }
                } catch (IllegalArgumentException e11) {
                    e = e11;
                    bundle = null;
                    Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                    if (bundle == null) {
                    }
                    if (intent == null) {
                    }
                    if (intent == null) {
                    }
                }
                if (acquireUnstableContentProviderClient != null) {
                    try {
                        bundle = acquireUnstableContentProviderClient.call("serviceIntentCall", null, bundle2);
                        try {
                        } catch (RemoteException e12) {
                            e = e12;
                            Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                            if (bundle == null) {
                            }
                            if (intent == null) {
                            }
                            if (intent == null) {
                            }
                        } catch (IllegalArgumentException e13) {
                            e = e13;
                            Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                            if (bundle == null) {
                            }
                            if (intent == null) {
                            }
                            if (intent == null) {
                            }
                        }
                        if (bundle == null && (intent = (Intent) bundle.getParcelable("serviceResponseIntentKey")) == null && (pendingIntent = (PendingIntent) bundle.getParcelable("serviceMissingResolutionIntentKey")) != null) {
                            Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action " + this.zzb + " but has possible resolution");
                            throw new zzaj(new ConnectionResult(25, pendingIntent));
                        }
                        if (intent == null) {
                            Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.zzb)));
                        }
                    } finally {
                        acquireUnstableContentProviderClient.release();
                    }
                } else {
                    throw new RemoteException("Failed to acquire ContentProviderClient");
                }
            }
            if (intent == null) {
                return new Intent(this.zzb).setPackage(this.zzc);
            }
            return intent;
        }
        return new Intent().setComponent(this.zzd);
    }

    public final String zzc() {
        return this.zzc;
    }

    public zzo(String str, int i10, boolean z10) {
        this(str, "com.google.android.gms", 4225, false);
    }

    public zzo(String str, String str2, int i10, boolean z10) {
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        Preconditions.checkNotEmpty(str2);
        this.zzc = str2;
        this.zzd = null;
        this.zze = 4225;
        this.zzf = z10;
    }
}
