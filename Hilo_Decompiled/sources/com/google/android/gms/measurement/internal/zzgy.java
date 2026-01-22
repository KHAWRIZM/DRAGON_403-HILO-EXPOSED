package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzgy extends zzor {
    public zzgy(zzpf zzpfVar) {
        super(zzpfVar);
    }

    public final boolean zzb() {
        zzay();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.zzu.zzaY().getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzor
    protected final boolean zzbb() {
        return false;
    }

    public final void zzc(String str, zzos zzosVar, com.google.android.gms.internal.measurement.zzib zzibVar, zzgv zzgvVar) {
        zzg();
        zzay();
        try {
            URL url = new URI(zzosVar.zza()).toURL();
            this.zzg.zzp();
            this.zzu.zzaW().zzm(new zzgx(this, str, url, zzibVar.zzcc(), zzosVar.zzb(), zzgvVar));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            this.zzu.zzaV().zzb().zzc("Failed to parse URL. Not uploading MeasurementBatch. appId", zzgt.zzl(str), zzosVar.zza());
        }
    }

    public final void zzd(zzh zzhVar, Map map, zzgv zzgvVar) {
        zzg();
        zzay();
        Preconditions.checkNotNull(zzhVar);
        Preconditions.checkNotNull(zzgvVar);
        zzot zzf = this.zzg.zzf();
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder appendQueryParameter = builder.scheme((String) zzfx.zze.zzb(null)).encodedAuthority((String) zzfx.zzf.zzb(null)).path("config/app/".concat(String.valueOf(zzhVar.zzf()))).appendQueryParameter("platform", "android");
        zzf.zzu.zzc().zzi();
        appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(130000L)).appendQueryParameter("runtime_version", "0");
        String uri = builder.build().toString();
        try {
            this.zzu.zzaW().zzm(new zzgx(this, zzhVar.zzc(), new URI(uri).toURL(), null, map, zzgvVar));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            this.zzu.zzaV().zzb().zzc("Failed to parse config URL. Not fetching. appId", zzgt.zzl(zzhVar.zzc()), uri);
        }
    }
}
