package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.amazonaws.services.s3.internal.Constants;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzql;
import com.google.android.gms.internal.measurement.zzrg;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzgh extends zzg {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private final long zzh;
    private List zzi;
    private String zzj;
    private int zzk;
    private String zzl;
    private String zzm;
    private long zzn;
    private String zzo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgh(zzib zzibVar, long j10, long j11) {
        super(zzibVar);
        this.zzn = 0L;
        this.zzo = null;
        this.zzg = j10;
        this.zzh = j11;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(1:3)(6:59|60|(1:62)(2:77|(1:79))|63|64|(16:66|(1:68)(1:75)|69|70|5|(2:7|(2:9|(2:11|(2:13|(2:15|(2:17|(1:19)(1:52))(1:53))(1:54))(1:55))(1:56))(1:57))(1:58)|20|21|22|(1:24)(1:49)|25|(1:27)|29|(3:31|(1:33)(3:40|(3:43|(1:45)(1:46)|41)|47)|(2:35|36)(2:38|39))|48|(0)(0)))|4|5|(0)(0)|20|21|22|(0)(0)|25|(0)|29|(0)|48|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0199, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x019a, code lost:
    
        r11.zzu.zzaV().zzb().zzc("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.zzgt.zzl(r1), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0187 A[Catch: IllegalStateException -> 0x0199, TRY_LEAVE, TryCatch #2 {IllegalStateException -> 0x0199, blocks: (B:22:0x016d, B:25:0x0183, B:27:0x0187), top: B:21:0x016d }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00c7  */
    @Override // com.google.android.gms.measurement.internal.zzg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void zzf() {
        String str;
        String str2;
        PackageInfo packageInfo;
        int zzC;
        List zzs;
        String zza;
        zzib zzibVar = this.zzu;
        zzibVar.zzaV().zzk().zzc("sdkVersion bundled with app, dynamiteVersion", Long.valueOf(this.zzh), Long.valueOf(this.zzg));
        String packageName = zzibVar.zzaY().getPackageName();
        PackageManager packageManager = zzibVar.zzaY().getPackageManager();
        String str3 = "";
        int i10 = Integer.MIN_VALUE;
        String str4 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        String str5 = "unknown";
        if (packageManager == null) {
            zzibVar.zzaV().zzb().zzb("PackageManager is null, app identity information might be inaccurate. appId", zzgt.zzl(packageName));
        } else {
            try {
                str5 = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException unused) {
                this.zzu.zzaV().zzb().zzb("Error retrieving app installer package name. appId", zzgt.zzl(packageName));
            }
            if (str5 == null) {
                str5 = "manual_install";
            } else if ("com.android.vending".equals(str5)) {
                str5 = "";
            }
            try {
                packageInfo = packageManager.getPackageInfo(this.zzu.zzaY().getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused2) {
                str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            if (packageInfo != null) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    str2 = applicationLabel.toString();
                } else {
                    str2 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                }
                try {
                    str4 = packageInfo.versionName;
                    i10 = packageInfo.versionCode;
                } catch (PackageManager.NameNotFoundException unused3) {
                    str = str4;
                    str4 = str2;
                    this.zzu.zzaV().zzb().zzc("Error retrieving package info. appId, appName", zzgt.zzl(packageName), str4);
                    str2 = str4;
                    str4 = str;
                    this.zza = packageName;
                    this.zzd = str5;
                    this.zzb = str4;
                    this.zzc = i10;
                    this.zze = str2;
                    this.zzf = 0L;
                    zzib zzibVar2 = this.zzu;
                    zzC = zzibVar2.zzC();
                    if (zzC != 0) {
                    }
                    this.zzl = "";
                    zzib zzibVar3 = this.zzu;
                    zzibVar3.zzaU();
                    zza = zzls.zza(zzibVar3.zzaY(), "google_app_id", zzibVar2.zzq());
                    if (!TextUtils.isEmpty(zza)) {
                    }
                    this.zzl = str3;
                    if (zzC == 0) {
                    }
                    this.zzi = null;
                    zzib zzibVar4 = this.zzu;
                    zzibVar4.zzaU();
                    zzs = zzibVar4.zzc().zzs("analytics.safelisted_events");
                    if (zzs != null) {
                    }
                    this.zzi = zzs;
                    if (packageManager == null) {
                    }
                }
                this.zza = packageName;
                this.zzd = str5;
                this.zzb = str4;
                this.zzc = i10;
                this.zze = str2;
                this.zzf = 0L;
                zzib zzibVar22 = this.zzu;
                zzC = zzibVar22.zzC();
                if (zzC != 0) {
                    if (zzC != 1) {
                        if (zzC != 3) {
                            if (zzC != 4) {
                                if (zzC != 6) {
                                    if (zzC != 7) {
                                        if (zzC != 8) {
                                            zzib zzibVar5 = this.zzu;
                                            zzibVar5.zzaV().zzi().zza("App measurement disabled");
                                            zzibVar5.zzaV().zzc().zza("Invalid scion state in identity");
                                        } else {
                                            this.zzu.zzaV().zzi().zza("App measurement disabled due to denied storage consent");
                                        }
                                    } else {
                                        this.zzu.zzaV().zzi().zza("App measurement disabled via the global data collection setting");
                                    }
                                } else {
                                    this.zzu.zzaV().zzh().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                                }
                            } else {
                                this.zzu.zzaV().zzi().zza("App measurement disabled via the manifest");
                            }
                        } else {
                            this.zzu.zzaV().zzi().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                        }
                    } else {
                        this.zzu.zzaV().zzi().zza("App measurement deactivated via the manifest");
                    }
                } else {
                    this.zzu.zzaV().zzk().zza("App measurement collection enabled");
                }
                this.zzl = "";
                zzib zzibVar32 = this.zzu;
                zzibVar32.zzaU();
                zza = zzls.zza(zzibVar32.zzaY(), "google_app_id", zzibVar22.zzq());
                if (!TextUtils.isEmpty(zza)) {
                    str3 = zza;
                }
                this.zzl = str3;
                if (zzC == 0) {
                    zzibVar32.zzaV().zzk().zzc("App measurement enabled for app package, google app id", this.zza, this.zzl);
                }
                this.zzi = null;
                zzib zzibVar42 = this.zzu;
                zzibVar42.zzaU();
                zzs = zzibVar42.zzc().zzs("analytics.safelisted_events");
                if (zzs != null) {
                    if (zzs.isEmpty()) {
                        zzibVar42.zzaV().zzh().zza("Safelisted event list is empty. Ignoring");
                    } else {
                        Iterator it = zzs.iterator();
                        while (it.hasNext()) {
                            if (!zzibVar42.zzk().zzk("safelisted event", (String) it.next())) {
                                break;
                            }
                        }
                    }
                    if (packageManager == null) {
                        this.zzk = InstantApps.isInstantApp(zzibVar42.zzaY()) ? 1 : 0;
                        return;
                    } else {
                        this.zzk = 0;
                        return;
                    }
                }
                this.zzi = zzs;
                if (packageManager == null) {
                }
            }
        }
        str2 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        this.zza = packageName;
        this.zzd = str5;
        this.zzb = str4;
        this.zzc = i10;
        this.zze = str2;
        this.zzf = 0L;
        zzib zzibVar222 = this.zzu;
        zzC = zzibVar222.zzC();
        if (zzC != 0) {
        }
        this.zzl = "";
        zzib zzibVar322 = this.zzu;
        zzibVar322.zzaU();
        zza = zzls.zza(zzibVar322.zzaY(), "google_app_id", zzibVar222.zzq());
        if (!TextUtils.isEmpty(zza)) {
        }
        this.zzl = str3;
        if (zzC == 0) {
        }
        this.zzi = null;
        zzib zzibVar422 = this.zzu;
        zzibVar422.zzaU();
        zzs = zzibVar422.zzc().zzs("analytics.safelisted_events");
        if (zzs != null) {
        }
        this.zzi = zzs;
        if (packageManager == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0257 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0180  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzr zzh(String str) {
        String str2;
        Class<?> loadClass;
        long zza;
        long min;
        zzib zzibVar;
        boolean z10;
        boolean z11;
        long j10;
        long j11;
        String str3;
        zzib zzibVar2;
        int i10;
        long j12;
        ApplicationInfo applicationInfo;
        zzib zzibVar3;
        zzal zzc;
        zzfw zzfwVar;
        int i11;
        long j13;
        zzg();
        String zzj = zzj();
        String zzk = zzk();
        zzb();
        String str4 = this.zzb;
        zzb();
        long j14 = this.zzc;
        zzb();
        Preconditions.checkNotNull(this.zzd);
        String str5 = this.zzd;
        zzib zzibVar4 = this.zzu;
        zzibVar4.zzc().zzi();
        zzb();
        zzg();
        long j15 = this.zzf;
        if (j15 == 0) {
            zzpo zzk2 = this.zzu.zzk();
            Context zzaY = zzibVar4.zzaY();
            String packageName = zzibVar4.zzaY().getPackageName();
            zzk2.zzg();
            Preconditions.checkNotNull(zzaY);
            Preconditions.checkNotEmpty(packageName);
            PackageManager packageManager = zzaY.getPackageManager();
            MessageDigest zzO = zzpo.zzO();
            long j16 = -1;
            if (zzO == null) {
                zzk2.zzu.zzaV().zzb().zza("Could not get MD5 instance");
            } else {
                if (packageManager != null) {
                    try {
                        if (!zzk2.zzad(zzaY, packageName)) {
                            PackageManagerWrapper packageManager2 = Wrappers.packageManager(zzaY);
                            zzib zzibVar5 = zzk2.zzu;
                            Signature[] signatureArr = packageManager2.getPackageInfo(zzibVar5.zzaY().getPackageName(), 64).signatures;
                            if (signatureArr != null && signatureArr.length > 0) {
                                j16 = zzpo.zzP(zzO.digest(signatureArr[0].toByteArray()));
                            } else {
                                zzibVar5.zzaV().zze().zza("Could not get signatures");
                            }
                        } else {
                            j16 = 0;
                        }
                    } catch (PackageManager.NameNotFoundException e10) {
                        zzk2.zzu.zzaV().zzb().zzb("Package name not found", e10);
                    }
                }
                j15 = 0;
                this.zzf = j15;
            }
            j15 = j16;
            this.zzf = j15;
        }
        long j17 = j15;
        zzib zzibVar6 = this.zzu;
        boolean zzB = zzibVar6.zzB();
        boolean z12 = !zzibVar6.zzd().zzm;
        zzg();
        if (zzibVar6.zzB()) {
            zzrg.zza();
            if (zzibVar6.zzc().zzp(null, zzfx.zzaH)) {
                this.zzu.zzaV().zzk().zza("Disabled IID for tests.");
            } else {
                try {
                    loadClass = zzibVar6.zzaY().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                } catch (ClassNotFoundException unused) {
                }
                if (loadClass != null) {
                    try {
                        Object invoke = loadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, this.zzu.zzaY());
                        if (invoke == null) {
                            str2 = null;
                        } else {
                            try {
                                str2 = (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", null).invoke(invoke, null);
                            } catch (Exception unused2) {
                                this.zzu.zzaV().zzh().zza("Failed to retrieve Firebase Instance Id");
                                str2 = null;
                                zzib zzibVar7 = this.zzu;
                                zza = zzibVar7.zzd().zzc.zza();
                                if (zza == 0) {
                                }
                                long j18 = min;
                                zzb();
                                int i12 = this.zzk;
                                zzibVar = this.zzu;
                                boolean zzu = zzibVar.zzc().zzu();
                                zzhg zzd = zzibVar.zzd();
                                zzd.zzg();
                                boolean z13 = zzd.zzd().getBoolean("deferred_analytics_collection", false);
                                if (zzibVar.zzc().zzw("google_analytics_default_allow_ad_personalization_signals", true) != zzjh.GRANTED) {
                                }
                                long j19 = this.zzg;
                                Boolean valueOf = Boolean.valueOf(z11);
                                List list = this.zzi;
                                String zzl = zzibVar.zzd().zzl().zzl();
                                if (this.zzj == null) {
                                }
                                String str6 = this.zzj;
                                if (!zzibVar.zzd().zzl().zzo(zzjj.ANALYTICS_STORAGE)) {
                                }
                                boolean zzx = zzibVar.zzc().zzx();
                                zzpo zzk3 = zzibVar.zzk();
                                String zzj2 = zzj();
                                zzibVar2 = zzk3.zzu;
                                if (zzibVar2.zzaY().getPackageManager() == null) {
                                }
                                zzibVar3 = this.zzu;
                                int zzb = zzibVar3.zzd().zzl().zzb();
                                String zze = zzibVar3.zzd().zzj().zze();
                                zzql.zza();
                                zzc = zzibVar3.zzc();
                                zzfwVar = zzfx.zzaQ;
                                if (!zzc.zzp(null, zzfwVar)) {
                                }
                                zzql.zza();
                                if (!zzibVar3.zzc().zzp(null, zzfwVar)) {
                                }
                                String zzz = zzibVar3.zzc().zzz();
                                String zzb2 = new zze(zzibVar3.zzc().zzw("google_analytics_default_allow_ad_personalization_signals", true)).zzb();
                                zzib zzibVar8 = this.zzu;
                                return new zzr(zzj, zzk, str4, j14, str5, 130000L, j11, str, z10, z12, str2, j18, i12, zzu, z13, valueOf, j19, list, zzl, str6, str3, zzx, j12, zzb, zze, i11, j13, zzz, zzb2, zzibVar8.zza, zzibVar8.zzx().zzj().zza());
                            }
                        }
                    } catch (Exception unused3) {
                        this.zzu.zzaV().zzf().zza("Failed to obtain Firebase Analytics instance");
                    }
                    zzib zzibVar72 = this.zzu;
                    zza = zzibVar72.zzd().zzc.zza();
                    if (zza == 0) {
                        min = zzibVar72.zza;
                    } else {
                        min = Math.min(zzibVar72.zza, zza);
                    }
                    long j182 = min;
                    zzb();
                    int i122 = this.zzk;
                    zzibVar = this.zzu;
                    boolean zzu2 = zzibVar.zzc().zzu();
                    zzhg zzd2 = zzibVar.zzd();
                    zzd2.zzg();
                    boolean z132 = zzd2.zzd().getBoolean("deferred_analytics_collection", false);
                    if (zzibVar.zzc().zzw("google_analytics_default_allow_ad_personalization_signals", true) != zzjh.GRANTED) {
                        z10 = zzB;
                        z11 = true;
                    } else {
                        z10 = zzB;
                        z11 = false;
                    }
                    long j192 = this.zzg;
                    Boolean valueOf2 = Boolean.valueOf(z11);
                    List list2 = this.zzi;
                    String zzl2 = zzibVar.zzd().zzl().zzl();
                    if (this.zzj == null) {
                        this.zzj = zzibVar.zzk().zzaw();
                    }
                    String str62 = this.zzj;
                    if (!zzibVar.zzd().zzl().zzo(zzjj.ANALYTICS_STORAGE)) {
                        j11 = j17;
                        j10 = 0;
                        str3 = null;
                    } else {
                        zzg();
                        j10 = 0;
                        if (this.zzn == 0) {
                            j11 = j17;
                        } else {
                            j11 = j17;
                            long currentTimeMillis = zzibVar.zzaZ().currentTimeMillis() - this.zzn;
                            if (this.zzm != null && currentTimeMillis > 86400000 && this.zzo == null) {
                                zzi();
                            }
                        }
                        if (this.zzm == null) {
                            zzi();
                        }
                        str3 = this.zzm;
                    }
                    boolean zzx2 = zzibVar.zzc().zzx();
                    zzpo zzk32 = zzibVar.zzk();
                    String zzj22 = zzj();
                    zzibVar2 = zzk32.zzu;
                    if (zzibVar2.zzaY().getPackageManager() == null) {
                        j12 = j10;
                    } else {
                        try {
                            try {
                                applicationInfo = Wrappers.packageManager(zzibVar2.zzaY()).getApplicationInfo(zzj22, 0);
                            } catch (PackageManager.NameNotFoundException unused4) {
                                zzib zzibVar9 = zzk32.zzu;
                                zzibVar9.zzaU();
                                zzibVar9.zzaV().zzi().zzb("PackageManager failed to find running app: app_id", zzj22);
                                i10 = 0;
                                j12 = i10;
                                zzibVar3 = this.zzu;
                                int zzb3 = zzibVar3.zzd().zzl().zzb();
                                String zze2 = zzibVar3.zzd().zzj().zze();
                                zzql.zza();
                                zzc = zzibVar3.zzc();
                                zzfwVar = zzfx.zzaQ;
                                if (!zzc.zzp(null, zzfwVar)) {
                                }
                                zzql.zza();
                                if (!zzibVar3.zzc().zzp(null, zzfwVar)) {
                                }
                                String zzz2 = zzibVar3.zzc().zzz();
                                String zzb22 = new zze(zzibVar3.zzc().zzw("google_analytics_default_allow_ad_personalization_signals", true)).zzb();
                                zzib zzibVar82 = this.zzu;
                                return new zzr(zzj, zzk, str4, j14, str5, 130000L, j11, str, z10, z12, str2, j182, i122, zzu2, z132, valueOf2, j192, list2, zzl2, str62, str3, zzx2, j12, zzb3, zze2, i11, j13, zzz2, zzb22, zzibVar82.zza, zzibVar82.zzx().zzj().zza());
                            }
                        } catch (PackageManager.NameNotFoundException unused5) {
                        }
                        if (applicationInfo != null) {
                            i10 = applicationInfo.targetSdkVersion;
                            j12 = i10;
                        }
                        i10 = 0;
                        j12 = i10;
                    }
                    zzibVar3 = this.zzu;
                    int zzb32 = zzibVar3.zzd().zzl().zzb();
                    String zze22 = zzibVar3.zzd().zzj().zze();
                    zzql.zza();
                    zzc = zzibVar3.zzc();
                    zzfwVar = zzfx.zzaQ;
                    if (!zzc.zzp(null, zzfwVar)) {
                        i11 = zzibVar3.zzk().zzU();
                    } else {
                        i11 = 0;
                    }
                    zzql.zza();
                    if (!zzibVar3.zzc().zzp(null, zzfwVar)) {
                        j13 = zzibVar3.zzk().zzV();
                    } else {
                        j13 = j10;
                    }
                    String zzz22 = zzibVar3.zzc().zzz();
                    String zzb222 = new zze(zzibVar3.zzc().zzw("google_analytics_default_allow_ad_personalization_signals", true)).zzb();
                    zzib zzibVar822 = this.zzu;
                    return new zzr(zzj, zzk, str4, j14, str5, 130000L, j11, str, z10, z12, str2, j182, i122, zzu2, z132, valueOf2, j192, list2, zzl2, str62, str3, zzx2, j12, zzb32, zze22, i11, j13, zzz22, zzb222, zzibVar822.zza, zzibVar822.zzx().zzj().zza());
                }
            }
        }
        str2 = null;
        zzib zzibVar722 = this.zzu;
        zza = zzibVar722.zzd().zzc.zza();
        if (zza == 0) {
        }
        long j1822 = min;
        zzb();
        int i1222 = this.zzk;
        zzibVar = this.zzu;
        boolean zzu22 = zzibVar.zzc().zzu();
        zzhg zzd22 = zzibVar.zzd();
        zzd22.zzg();
        boolean z1322 = zzd22.zzd().getBoolean("deferred_analytics_collection", false);
        if (zzibVar.zzc().zzw("google_analytics_default_allow_ad_personalization_signals", true) != zzjh.GRANTED) {
        }
        long j1922 = this.zzg;
        Boolean valueOf22 = Boolean.valueOf(z11);
        List list22 = this.zzi;
        String zzl22 = zzibVar.zzd().zzl().zzl();
        if (this.zzj == null) {
        }
        String str622 = this.zzj;
        if (!zzibVar.zzd().zzl().zzo(zzjj.ANALYTICS_STORAGE)) {
        }
        boolean zzx22 = zzibVar.zzc().zzx();
        zzpo zzk322 = zzibVar.zzk();
        String zzj222 = zzj();
        zzibVar2 = zzk322.zzu;
        if (zzibVar2.zzaY().getPackageManager() == null) {
        }
        zzibVar3 = this.zzu;
        int zzb322 = zzibVar3.zzd().zzl().zzb();
        String zze222 = zzibVar3.zzd().zzj().zze();
        zzql.zza();
        zzc = zzibVar3.zzc();
        zzfwVar = zzfx.zzaQ;
        if (!zzc.zzp(null, zzfwVar)) {
        }
        zzql.zza();
        if (!zzibVar3.zzc().zzp(null, zzfwVar)) {
        }
        String zzz222 = zzibVar3.zzc().zzz();
        String zzb2222 = new zze(zzibVar3.zzc().zzw("google_analytics_default_allow_ad_personalization_signals", true)).zzb();
        zzib zzibVar8222 = this.zzu;
        return new zzr(zzj, zzk, str4, j14, str5, 130000L, j11, str, z10, z12, str2, j1822, i1222, zzu22, z1322, valueOf22, j1922, list22, zzl22, str622, str3, zzx22, j12, zzb322, zze222, i11, j13, zzz222, zzb2222, zzibVar8222.zza, zzibVar8222.zzx().zzj().zza());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzi() {
        String format;
        String str;
        zzg();
        zzib zzibVar = this.zzu;
        if (!zzibVar.zzd().zzl().zzo(zzjj.ANALYTICS_STORAGE)) {
            zzibVar.zzaV().zzj().zza("Analytics Storage consent is not granted");
            format = null;
        } else {
            byte[] bArr = new byte[16];
            zzibVar.zzk().zzf().nextBytes(bArr);
            format = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        zzgr zzj = zzibVar.zzaV().zzj();
        if (format == null) {
            str = Constants.NULL_VERSION_ID;
        } else {
            str = "not null";
        }
        zzj.zza(String.format("Resetting session stitching token to %s", str));
        this.zzm = format;
        this.zzn = zzibVar.zzaZ().currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzj() {
        zzb();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzk() {
        zzg();
        zzb();
        Preconditions.checkNotNull(this.zzl);
        return this.zzl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzl() {
        zzb();
        Preconditions.checkNotNull(this.zze);
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzm() {
        zzb();
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzn() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzo() {
        zzb();
        return this.zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List zzp() {
        return this.zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzq(String str) {
        String str2 = this.zzo;
        boolean z10 = false;
        if (str2 != null && !str2.equals(str)) {
            z10 = true;
        }
        this.zzo = str;
        return z10;
    }
}
