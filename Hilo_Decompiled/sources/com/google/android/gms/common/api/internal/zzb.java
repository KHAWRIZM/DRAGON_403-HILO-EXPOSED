package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzb implements Runnable {
    final /* synthetic */ LifecycleCallback zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzc zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(zzc zzcVar, LifecycleCallback lifecycleCallback, String str) {
        this.zza = lifecycleCallback;
        this.zzb = str;
        this.zzc = zzcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        zzc zzcVar = this.zzc;
        i10 = zzcVar.zzb;
        if (i10 > 0) {
            LifecycleCallback lifecycleCallback = this.zza;
            bundle = zzcVar.zzc;
            if (bundle != null) {
                String str = this.zzb;
                bundle3 = zzcVar.zzc;
                bundle2 = bundle3.getBundle(str);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.onCreate(bundle2);
        }
        i11 = this.zzc.zzb;
        if (i11 >= 2) {
            this.zza.onStart();
        }
        i12 = this.zzc.zzb;
        if (i12 >= 3) {
            this.zza.onResume();
        }
        i13 = this.zzc.zzb;
        if (i13 >= 4) {
            this.zza.onStop();
        }
        i14 = this.zzc.zzb;
        if (i14 >= 5) {
            this.zza.onDestroy();
        }
    }
}
