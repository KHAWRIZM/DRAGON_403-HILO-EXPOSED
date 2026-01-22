package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzkx implements Application.ActivityLifecycleCallbacks, zzkv {
    final /* synthetic */ zzli zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkx(zzli zzliVar) {
        Objects.requireNonNull(zzliVar);
        this.zza = zzliVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(com.google.android.gms.internal.measurement.zzdf.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzb(com.google.android.gms.internal.measurement.zzdf.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zzc(com.google.android.gms.internal.measurement.zzdf.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzd(com.google.android.gms.internal.measurement.zzdf.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zze(com.google.android.gms.internal.measurement.zzdf.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    @Override // com.google.android.gms.measurement.internal.zzkv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(com.google.android.gms.internal.measurement.zzdf zzdfVar, Bundle bundle) {
        zzib zzibVar;
        zzli zzliVar;
        zzib zzibVar2;
        Intent intent;
        Uri uri;
        String stringExtra;
        String str;
        boolean z10;
        try {
            try {
                zzliVar = this.zza;
                zzibVar2 = zzliVar.zzu;
                zzibVar2.zzaV().zzk().zza("onActivityCreated");
                intent = zzdfVar.zzc;
            } catch (RuntimeException e10) {
                this.zza.zzu.zzaV().zzb().zzb("Throwable caught in onActivityCreated", e10);
            }
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null) {
                    if (!data.isHierarchical()) {
                    }
                    uri = data;
                    if (uri != null && uri.isHierarchical()) {
                        zzibVar2.zzk();
                        stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                        if (!"android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) && !"https://www.google.com".equals(stringExtra) && !"android-app://com.google.appcrawler".equals(stringExtra)) {
                            str = "auto";
                            String str2 = str;
                            String queryParameter = uri.getQueryParameter("referrer");
                            if (bundle != null) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            zzibVar2.zzaW().zzj(new zzkw(this, z10, uri, str2, queryParameter));
                            zzibVar = this.zza.zzu;
                            zzibVar.zzs().zzm(zzdfVar, bundle);
                        }
                        str = "gs";
                        String str22 = str;
                        String queryParameter2 = uri.getQueryParameter("referrer");
                        if (bundle != null) {
                        }
                        zzibVar2.zzaW().zzj(new zzkw(this, z10, uri, str22, queryParameter2));
                        zzibVar = this.zza.zzu;
                        zzibVar.zzs().zzm(zzdfVar, bundle);
                    }
                }
                Bundle extras = intent.getExtras();
                uri = null;
                if (extras != null) {
                    String string = extras.getString("com.android.vending.referral_url");
                    if (!TextUtils.isEmpty(string)) {
                        data = Uri.parse(string);
                        uri = data;
                    }
                }
                if (uri != null) {
                    zzibVar2.zzk();
                    stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                    if (!"android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra)) {
                        str = "auto";
                        String str222 = str;
                        String queryParameter22 = uri.getQueryParameter("referrer");
                        if (bundle != null) {
                        }
                        zzibVar2.zzaW().zzj(new zzkw(this, z10, uri, str222, queryParameter22));
                        zzibVar = this.zza.zzu;
                        zzibVar.zzs().zzm(zzdfVar, bundle);
                    }
                    str = "gs";
                    String str2222 = str;
                    String queryParameter222 = uri.getQueryParameter("referrer");
                    if (bundle != null) {
                    }
                    zzibVar2.zzaW().zzj(new zzkw(this, z10, uri, str2222, queryParameter222));
                    zzibVar = this.zza.zzu;
                    zzibVar.zzs().zzm(zzdfVar, bundle);
                }
            }
            zzibVar = zzliVar.zzu;
            zzibVar.zzs().zzm(zzdfVar, bundle);
        } catch (Throwable th) {
            this.zza.zzu.zzs().zzm(zzdfVar, bundle);
            throw th;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzkv
    public final void zzb(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        this.zza.zzu.zzs().zzs(zzdfVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzkv
    public final void zzc(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        zzib zzibVar = this.zza.zzu;
        zzibVar.zzs().zzp(zzdfVar);
        zzob zzh = zzibVar.zzh();
        zzib zzibVar2 = zzh.zzu;
        zzibVar2.zzaW().zzj(new zznu(zzh, zzibVar2.zzaZ().elapsedRealtime()));
    }

    @Override // com.google.android.gms.measurement.internal.zzkv
    public final void zzd(com.google.android.gms.internal.measurement.zzdf zzdfVar) {
        zzib zzibVar = this.zza.zzu;
        zzob zzh = zzibVar.zzh();
        zzib zzibVar2 = zzh.zzu;
        zzibVar2.zzaW().zzj(new zznt(zzh, zzibVar2.zzaZ().elapsedRealtime()));
        zzibVar.zzs().zzn(zzdfVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzkv
    public final void zze(com.google.android.gms.internal.measurement.zzdf zzdfVar, Bundle bundle) {
        this.zza.zzu.zzs().zzq(zzdfVar, bundle);
    }
}
