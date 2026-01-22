package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import com.alibaba.sdk.android.tbrest.rest.RestUrlWrapper;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzhs extends zzor implements zzak {

    @VisibleForTesting
    final Map zza;

    @VisibleForTesting
    final Map zzb;

    @VisibleForTesting
    final Map zzc;

    @VisibleForTesting
    final LruCache zzd;
    final com.google.android.gms.internal.measurement.zzr zze;
    private final Map zzf;
    private final Map zzh;
    private final Map zzi;
    private final Map zzj;
    private final Map zzk;
    private final Map zzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhs(zzpf zzpfVar) {
        super(zzpfVar);
        this.zzf = new androidx.collection.a();
        this.zza = new androidx.collection.a();
        this.zzb = new androidx.collection.a();
        this.zzc = new androidx.collection.a();
        this.zzh = new androidx.collection.a();
        this.zzj = new androidx.collection.a();
        this.zzk = new androidx.collection.a();
        this.zzl = new androidx.collection.a();
        this.zzi = new androidx.collection.a();
        this.zzd = new zzhl(this, 20);
        this.zze = new zzhm(this);
    }

    private final void zzE(String str) {
        zzay();
        zzg();
        Preconditions.checkNotEmpty(str);
        Map map = this.zzh;
        if (map.get(str) == null) {
            zzaq zzy = this.zzg.zzj().zzy(str);
            if (zzy == null) {
                this.zzf.put(str, null);
                this.zzb.put(str, null);
                this.zza.put(str, null);
                this.zzc.put(str, null);
                map.put(str, null);
                this.zzj.put(str, null);
                this.zzk.put(str, null);
                this.zzl.put(str, null);
                this.zzi.put(str, null);
                return;
            }
            com.google.android.gms.internal.measurement.zzgk zzgkVar = (com.google.android.gms.internal.measurement.zzgk) zzH(str, zzy.zza).zzcl();
            zzF(str, zzgkVar);
            this.zzf.put(str, zzI((com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbc()));
            map.put(str, (com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbc());
            zzG(str, (com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbc());
            this.zzj.put(str, zzgkVar.zzh());
            this.zzk.put(str, zzy.zzb);
            this.zzl.put(str, zzy.zzc);
        }
    }

    private final void zzF(String str, com.google.android.gms.internal.measurement.zzgk zzgkVar) {
        HashSet hashSet = new HashSet();
        androidx.collection.a aVar = new androidx.collection.a();
        androidx.collection.a aVar2 = new androidx.collection.a();
        androidx.collection.a aVar3 = new androidx.collection.a();
        Iterator it = zzgkVar.zzg().iterator();
        while (it.hasNext()) {
            hashSet.add(((com.google.android.gms.internal.measurement.zzgh) it.next()).zza());
        }
        for (int i10 = 0; i10 < zzgkVar.zza(); i10++) {
            com.google.android.gms.internal.measurement.zzgi zzgiVar = (com.google.android.gms.internal.measurement.zzgi) zzgkVar.zzb(i10).zzcl();
            if (zzgiVar.zza().isEmpty()) {
                this.zzu.zzaV().zze().zza("EventConfig contained null event name");
            } else {
                String zza = zzgiVar.zza();
                String zzb = zzjl.zzb(zzgiVar.zza());
                if (!TextUtils.isEmpty(zzb)) {
                    zzgiVar.zzb(zzb);
                    zzgkVar.zzc(i10, zzgiVar);
                }
                if (zzgiVar.zzc() && zzgiVar.zzd()) {
                    aVar.put(zza, Boolean.TRUE);
                }
                if (zzgiVar.zze() && zzgiVar.zzf()) {
                    aVar2.put(zzgiVar.zza(), Boolean.TRUE);
                }
                if (zzgiVar.zzg()) {
                    if (zzgiVar.zzh() >= 2 && zzgiVar.zzh() <= 65535) {
                        aVar3.put(zzgiVar.zza(), Integer.valueOf(zzgiVar.zzh()));
                    } else {
                        this.zzu.zzaV().zze().zzc("Invalid sampling rate. Event name, sample rate", zzgiVar.zza(), Integer.valueOf(zzgiVar.zzh()));
                    }
                }
            }
        }
        this.zza.put(str, hashSet);
        this.zzb.put(str, aVar);
        this.zzc.put(str, aVar2);
        this.zzi.put(str, aVar3);
    }

    private final void zzG(final String str, com.google.android.gms.internal.measurement.zzgl zzglVar) {
        if (zzglVar.zzj() != 0) {
            zzib zzibVar = this.zzu;
            zzibVar.zzaV().zzk().zzb("EES programs found", Integer.valueOf(zzglVar.zzj()));
            com.google.android.gms.internal.measurement.zzja zzjaVar = (com.google.android.gms.internal.measurement.zzja) zzglVar.zzi().get(0);
            try {
                com.google.android.gms.internal.measurement.zzc zzcVar = new com.google.android.gms.internal.measurement.zzc();
                zzcVar.zza("internal.remoteConfig", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhr
                    @Override // java.util.concurrent.Callable
                    public final /* synthetic */ Object call() {
                        return new com.google.android.gms.internal.measurement.zzn("internal.remoteConfig", new zzhn(zzhs.this, str));
                    }
                });
                zzcVar.zza("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzho
                    @Override // java.util.concurrent.Callable
                    public final /* synthetic */ Object call() {
                        final zzhs zzhsVar = zzhs.this;
                        final String str2 = str;
                        return new com.google.android.gms.internal.measurement.zzu("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhq
                            @Override // java.util.concurrent.Callable
                            public final /* synthetic */ Object call() {
                                zzhs zzhsVar2 = zzhs.this;
                                zzav zzj = zzhsVar2.zzg.zzj();
                                String str3 = str2;
                                zzh zzu = zzj.zzu(str3);
                                HashMap hashMap = new HashMap();
                                hashMap.put("platform", "android");
                                hashMap.put("package_name", str3);
                                zzhsVar2.zzu.zzc().zzi();
                                hashMap.put("gmp_version", 130000L);
                                if (zzu != null) {
                                    String zzr = zzu.zzr();
                                    if (zzr != null) {
                                        hashMap.put(RestUrlWrapper.FIELD_APPVERSION, zzr);
                                    }
                                    hashMap.put("app_version_int", Long.valueOf(zzu.zzt()));
                                    hashMap.put("dynamite_version", Long.valueOf(zzu.zzB()));
                                }
                                return hashMap;
                            }
                        });
                    }
                });
                zzcVar.zza("internal.logger", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhp
                    @Override // java.util.concurrent.Callable
                    public final /* synthetic */ Object call() {
                        return new com.google.android.gms.internal.measurement.zzt(zzhs.this.zze);
                    }
                });
                zzcVar.zzf(zzjaVar);
                this.zzd.put(str, zzcVar);
                zzibVar.zzaV().zzk().zzc("EES program loaded for appId, activities", str, Integer.valueOf(zzjaVar.zzb().zzb()));
                Iterator it = zzjaVar.zzb().zza().iterator();
                while (it.hasNext()) {
                    zzibVar.zzaV().zzk().zzb("EES program activity", ((com.google.android.gms.internal.measurement.zziy) it.next()).zza());
                }
                return;
            } catch (com.google.android.gms.internal.measurement.zzd unused) {
                this.zzu.zzaV().zzb().zzb("Failed to load EES program. appId", str);
                return;
            }
        }
        this.zzd.remove(str);
    }

    private final com.google.android.gms.internal.measurement.zzgl zzH(String str, byte[] bArr) {
        Long l10;
        if (bArr == null) {
            return com.google.android.gms.internal.measurement.zzgl.zzs();
        }
        try {
            com.google.android.gms.internal.measurement.zzgl zzglVar = (com.google.android.gms.internal.measurement.zzgl) ((com.google.android.gms.internal.measurement.zzgk) zzpj.zzw(com.google.android.gms.internal.measurement.zzgl.zzr(), bArr)).zzbc();
            zzgr zzk = this.zzu.zzaV().zzk();
            String str2 = null;
            if (zzglVar.zza()) {
                l10 = Long.valueOf(zzglVar.zzb());
            } else {
                l10 = null;
            }
            if (zzglVar.zzc()) {
                str2 = zzglVar.zzd();
            }
            zzk.zzc("Parsed config. version, gmp_app_id", l10, str2);
            return zzglVar;
        } catch (com.google.android.gms.internal.measurement.zzmq e10) {
            this.zzu.zzaV().zze().zzc("Unable to merge remote config. appId", zzgt.zzl(str), e10);
            return com.google.android.gms.internal.measurement.zzgl.zzs();
        } catch (RuntimeException e11) {
            this.zzu.zzaV().zze().zzc("Unable to merge remote config. appId", zzgt.zzl(str), e11);
            return com.google.android.gms.internal.measurement.zzgl.zzs();
        }
    }

    private static final Map zzI(com.google.android.gms.internal.measurement.zzgl zzglVar) {
        androidx.collection.a aVar = new androidx.collection.a();
        if (zzglVar != null) {
            for (com.google.android.gms.internal.measurement.zzgt zzgtVar : zzglVar.zze()) {
                aVar.put(zzgtVar.zza(), zzgtVar.zzb());
            }
        }
        return aVar;
    }

    private static final zzjj zzJ(int i10) {
        int i11 = i10 - 1;
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 4) {
                        return null;
                    }
                    return zzjj.AD_PERSONALIZATION;
                }
                return zzjj.AD_USER_DATA;
            }
            return zzjj.ANALYTICS_STORAGE;
        }
        return zzjj.AD_STORAGE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzjh zzA(String str, zzjj zzjjVar) {
        zzg();
        zzE(str);
        com.google.android.gms.internal.measurement.zzgf zzx = zzx(str);
        if (zzx == null) {
            return zzjh.UNINITIALIZED;
        }
        for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzx.zzf()) {
            if (zzJ(zzfuVar.zzb()) == zzjjVar) {
                int zzc = zzfuVar.zzc() - 1;
                if (zzc != 1) {
                    if (zzc != 2) {
                        return zzjh.UNINITIALIZED;
                    }
                    return zzjh.DENIED;
                }
                return zzjh.GRANTED;
            }
        }
        return zzjh.UNINITIALIZED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzB(String str) {
        zzg();
        zzE(str);
        com.google.android.gms.internal.measurement.zzgf zzx = zzx(str);
        if (zzx == null) {
            return false;
        }
        for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzx.zza()) {
            if (zzfuVar.zzb() == 3 && zzfuVar.zzd() == 3) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzc zzC(String str) {
        zzay();
        Preconditions.checkNotEmpty(str);
        zzaq zzy = this.zzg.zzj().zzy(str);
        if (zzy == null) {
            return null;
        }
        this.zzu.zzaV().zzk().zzb("Populate EES config from database on cache miss. appId", str);
        zzG(str, zzH(str, zzy.zza));
        return (com.google.android.gms.internal.measurement.zzc) this.zzd.snapshot().get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Map zzD() {
        return this.zzf;
    }

    @Override // com.google.android.gms.measurement.internal.zzak
    public final String zza(String str, String str2) {
        zzg();
        zzE(str);
        Map map = (Map) this.zzf.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.google.android.gms.internal.measurement.zzgl zzb(String str) {
        zzay();
        zzg();
        Preconditions.checkNotEmpty(str);
        zzE(str);
        return (com.google.android.gms.internal.measurement.zzgl) this.zzh.get(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzor
    protected final boolean zzbb() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzc(String str) {
        zzg();
        zzE(str);
        return (String) this.zzj.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String zzd(String str) {
        zzg();
        return (String) this.zzk.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String zze(String str) {
        zzg();
        return (String) this.zzl.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzf(String str) {
        zzg();
        this.zzk.put(str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzh(String str) {
        zzg();
        this.zzh.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzi(String str, byte[] bArr, String str2, String str3) {
        zzay();
        zzg();
        Preconditions.checkNotEmpty(str);
        com.google.android.gms.internal.measurement.zzgk zzgkVar = (com.google.android.gms.internal.measurement.zzgk) zzH(str, bArr).zzcl();
        zzF(str, zzgkVar);
        zzG(str, (com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbc());
        this.zzh.put(str, (com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbc());
        this.zzj.put(str, zzgkVar.zzh());
        this.zzk.put(str, str2);
        this.zzl.put(str, str3);
        this.zzf.put(str, zzI((com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbc()));
        this.zzg.zzj().zzag(str, new ArrayList(zzgkVar.zzd()));
        try {
            zzgkVar.zze();
            bArr = ((com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbc()).zzcc();
        } catch (RuntimeException e10) {
            this.zzu.zzaV().zze().zzc("Unable to serialize reduced-size config. Storing full config instead. appId", zzgt.zzl(str), e10);
        }
        zzav zzj = this.zzg.zzj();
        Preconditions.checkNotEmpty(str);
        zzj.zzg();
        zzj.zzay();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (zzj.zze().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                zzj.zzu.zzaV().zzb().zzb("Failed to update remote config (got 0). appId", zzgt.zzl(str));
            }
        } catch (SQLiteException e11) {
            zzj.zzu.zzaV().zzb().zzc("Error storing remote config. appId", zzgt.zzl(str), e11);
        }
        zzgkVar.zzf();
        this.zzh.put(str, (com.google.android.gms.internal.measurement.zzgl) zzgkVar.zzbc());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzj(String str, String str2) {
        Boolean bool;
        zzg();
        zzE(str);
        if (zzn(str) && zzpo.zzZ(str2)) {
            return true;
        }
        if (zzo(str) && zzpo.zzh(str2)) {
            return true;
        }
        Map map = (Map) this.zzb.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzk(String str, String str2) {
        Boolean bool;
        zzg();
        zzE(str);
        if ("ecommerce_purchase".equals(str2) || FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2)) {
            return true;
        }
        Map map = (Map) this.zzc.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set zzl(String str) {
        zzg();
        zzE(str);
        return (Set) this.zza.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzm(String str, String str2) {
        Integer num;
        zzg();
        zzE(str);
        Map map = (Map) this.zzi.get(str);
        if (map != null && (num = (Integer) map.get(str2)) != null) {
            return num.intValue();
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzn(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzo(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzp(String str) {
        zzg();
        zzE(str);
        Map map = this.zza;
        if (map.get(str) == null) {
            return false;
        }
        if (!((Set) map.get(str)).contains("device_model") && !((Set) map.get(str)).contains(DeviceRequestsHelper.DEVICE_INFO_PARAM)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzq(String str) {
        zzg();
        zzE(str);
        Map map = this.zza;
        if (map.get(str) == null) {
            return false;
        }
        if (!((Set) map.get(str)).contains("os_version") && !((Set) map.get(str)).contains(DeviceRequestsHelper.DEVICE_INFO_PARAM)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzr(String str) {
        zzg();
        zzE(str);
        Map map = this.zza;
        if (map.get(str) != null && ((Set) map.get(str)).contains("user_id")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzs(String str) {
        zzg();
        zzE(str);
        Map map = this.zza;
        if (map.get(str) != null && ((Set) map.get(str)).contains("google_signals")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzt(String str) {
        zzg();
        zzE(str);
        Map map = this.zza;
        if (map.get(str) != null && ((Set) map.get(str)).contains("app_instance_id")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzu(String str) {
        zzg();
        zzE(str);
        Map map = this.zza;
        if (map.get(str) != null && ((Set) map.get(str)).contains("enhanced_user_id")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzv(String str, zzjj zzjjVar) {
        zzg();
        zzE(str);
        com.google.android.gms.internal.measurement.zzgf zzx = zzx(str);
        if (zzx == null) {
            return false;
        }
        Iterator it = zzx.zza().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.google.android.gms.internal.measurement.zzfu zzfuVar = (com.google.android.gms.internal.measurement.zzfu) it.next();
            if (zzjjVar == zzJ(zzfuVar.zzb())) {
                if (zzfuVar.zzc() == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzjj zzw(String str, zzjj zzjjVar) {
        zzg();
        zzE(str);
        com.google.android.gms.internal.measurement.zzgf zzx = zzx(str);
        if (zzx != null) {
            for (com.google.android.gms.internal.measurement.zzfw zzfwVar : zzx.zzb()) {
                if (zzjjVar == zzJ(zzfwVar.zzb())) {
                    return zzJ(zzfwVar.zzc());
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.google.android.gms.internal.measurement.zzgf zzx(String str) {
        zzg();
        zzE(str);
        com.google.android.gms.internal.measurement.zzgl zzb = zzb(str);
        if (zzb != null && zzb.zzn()) {
            return zzb.zzo();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzy(String str) {
        zzg();
        zzE(str);
        com.google.android.gms.internal.measurement.zzgf zzx = zzx(str);
        if (zzx == null || !zzx.zzd() || zzx.zze()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SortedSet zzz(String str) {
        zzg();
        zzE(str);
        TreeSet treeSet = new TreeSet();
        com.google.android.gms.internal.measurement.zzgf zzx = zzx(str);
        if (zzx != null) {
            Iterator it = zzx.zzc().iterator();
            while (it.hasNext()) {
                treeSet.add(((com.google.android.gms.internal.measurement.zzgc) it.next()).zza());
            }
        }
        return treeSet;
    }
}
