package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import anet.channel.util.HttpConstant;
import anetwork.channel.util.RequestConstant;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzql;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.collect.m0;
import com.google.common.collect.t;
import com.google.common.collect.u;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.qiahao.base_common.network.BaseServer;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzli extends zzg {

    @VisibleForTesting
    protected zzkx zza;
    final zzx zzb;

    @VisibleForTesting
    protected boolean zzc;
    private zzjo zzd;
    private final Set zze;
    private boolean zzf;
    private final AtomicReference zzg;
    private final Object zzh;
    private boolean zzi;
    private int zzj;
    private zzay zzk;
    private zzay zzl;
    private PriorityQueue zzm;
    private boolean zzn;

    @GuardedBy("consentLock")
    private zzjk zzo;
    private final AtomicLong zzp;
    private long zzq;
    private zzay zzr;
    private SharedPreferences.OnSharedPreferenceChangeListener zzs;
    private zzay zzt;
    private final zzpn zzv;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzli(zzib zzibVar) {
        super(zzibVar);
        this.zze = new CopyOnWriteArraySet();
        this.zzh = new Object();
        this.zzi = false;
        this.zzj = 1;
        this.zzc = true;
        this.zzv = new zzkm(this);
        this.zzg = new AtomicReference();
        this.zzo = zzjk.zza;
        this.zzq = -1L;
        this.zzp = new AtomicLong(0L);
        this.zzb = new zzx(zzibVar);
    }

    private final zzlq zzaq(final zzol zzolVar) {
        try {
            URL url = new URI(zzolVar.zzc).toURL();
            final AtomicReference atomicReference = new AtomicReference();
            String zzl = this.zzu.zzv().zzl();
            zzib zzibVar = this.zzu;
            zzgr zzk = zzibVar.zzaV().zzk();
            Long valueOf = Long.valueOf(zzolVar.zza);
            zzk.zzd("[sgtm] Uploading data from app. row_id, url, uncompressed size", valueOf, zzolVar.zzc, Integer.valueOf(zzolVar.zzb.length));
            if (!TextUtils.isEmpty(zzolVar.zzg)) {
                zzibVar.zzaV().zzk().zzc("[sgtm] Uploading data from app. row_id", valueOf, zzolVar.zzg);
            }
            HashMap hashMap = new HashMap();
            Bundle bundle = zzolVar.zzd;
            for (String str : bundle.keySet()) {
                String string = bundle.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put(str, string);
                }
            }
            zzln zzn = zzibVar.zzn();
            byte[] bArr = zzolVar.zzb;
            zzlk zzlkVar = new zzlk() { // from class: com.google.android.gms.measurement.internal.zzky
                /* JADX WARN: Removed duplicated region for block: B:10:0x0065  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
                @Override // com.google.android.gms.measurement.internal.zzlk
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final /* synthetic */ void zza(String str2, int i10, Throwable th, byte[] bArr2, Map map) {
                    zzlq zzlqVar;
                    AtomicReference atomicReference2;
                    zzli zzliVar = zzli.this;
                    zzliVar.zzg();
                    zzol zzolVar2 = zzolVar;
                    if (i10 != 200 && i10 != 204) {
                        if (i10 == 304) {
                            i10 = HttpConstant.SC_NOT_MODIFIED;
                        }
                        zzliVar.zzu.zzaV().zze().zzd("[sgtm] Upload failed for row_id. response, exception", Long.valueOf(zzolVar2.zza), Integer.valueOf(i10), th);
                        if (!Arrays.asList(((String) zzfx.zzt.zzb(null)).split(",")).contains(String.valueOf(i10))) {
                            zzlqVar = zzlq.BACKOFF;
                        } else {
                            zzlqVar = zzlq.FAILURE;
                        }
                        atomicReference2 = atomicReference;
                        zznk zzt = zzliVar.zzu.zzt();
                        long j10 = zzolVar2.zza;
                        zzt.zzy(new zzaf(j10, zzlqVar.zza(), zzolVar2.zzf));
                        zzliVar.zzu.zzaV().zzk().zzc("[sgtm] Updated status for row_id", Long.valueOf(j10), zzlqVar);
                        synchronized (atomicReference2) {
                            atomicReference2.set(zzlqVar);
                            atomicReference2.notifyAll();
                        }
                        return;
                    }
                    if (th == null) {
                        zzliVar.zzu.zzaV().zzk().zzb("[sgtm] Upload succeeded for row_id", Long.valueOf(zzolVar2.zza));
                        zzlqVar = zzlq.SUCCESS;
                        atomicReference2 = atomicReference;
                        zznk zzt2 = zzliVar.zzu.zzt();
                        long j102 = zzolVar2.zza;
                        zzt2.zzy(new zzaf(j102, zzlqVar.zza(), zzolVar2.zzf));
                        zzliVar.zzu.zzaV().zzk().zzc("[sgtm] Updated status for row_id", Long.valueOf(j102), zzlqVar);
                        synchronized (atomicReference2) {
                        }
                    }
                    zzliVar.zzu.zzaV().zze().zzd("[sgtm] Upload failed for row_id. response, exception", Long.valueOf(zzolVar2.zza), Integer.valueOf(i10), th);
                    if (!Arrays.asList(((String) zzfx.zzt.zzb(null)).split(",")).contains(String.valueOf(i10))) {
                    }
                    atomicReference2 = atomicReference;
                    zznk zzt22 = zzliVar.zzu.zzt();
                    long j1022 = zzolVar2.zza;
                    zzt22.zzy(new zzaf(j1022, zzlqVar.zza(), zzolVar2.zzf));
                    zzliVar.zzu.zzaV().zzk().zzc("[sgtm] Updated status for row_id", Long.valueOf(j1022), zzlqVar);
                    synchronized (atomicReference2) {
                    }
                }
            };
            zzn.zzw();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(bArr);
            Preconditions.checkNotNull(zzlkVar);
            zzn.zzu.zzaW().zzm(new zzlm(zzn, zzl, url, bArr, hashMap, zzlkVar));
            try {
                zzib zzibVar2 = zzibVar.zzk().zzu;
                long currentTimeMillis = zzibVar2.zzaZ().currentTimeMillis() + 60000;
                synchronized (atomicReference) {
                    for (long j10 = 60000; atomicReference.get() == null && j10 > 0; j10 = currentTimeMillis - zzibVar2.zzaZ().currentTimeMillis()) {
                        try {
                            atomicReference.wait(j10);
                        } finally {
                        }
                    }
                }
            } catch (InterruptedException unused) {
                this.zzu.zzaV().zze().zza("[sgtm] Interrupted waiting for uploading batch");
            }
            if (atomicReference.get() == null) {
                return zzlq.UNKNOWN;
            }
            return (zzlq) atomicReference.get();
        } catch (MalformedURLException | URISyntaxException e10) {
            this.zzu.zzaV().zzb().zzd("[sgtm] Bad upload url for row_id", zzolVar.zzc, Long.valueOf(zzolVar.zza), e10);
            return zzlq.FAILURE;
        }
    }

    private final void zzar(Boolean bool, boolean z10) {
        zzg();
        zzb();
        zzib zzibVar = this.zzu;
        zzibVar.zzaV().zzj().zzb("Setting app measurement enabled (FE)", bool);
        zzibVar.zzd().zzh(bool);
        if (z10) {
            zzhg zzd = zzibVar.zzd();
            zzib zzibVar2 = zzd.zzu;
            zzd.zzg();
            SharedPreferences.Editor edit = zzd.zzd().edit();
            if (bool != null) {
                edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit.remove("measurement_enabled_from_api");
            }
            edit.apply();
        }
        if (!this.zzu.zzE() && (bool == null || bool.booleanValue())) {
            return;
        }
        zzak();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzas, reason: merged with bridge method [inline-methods] */
    public final void zzak() {
        long j10;
        zzg();
        zzib zzibVar = this.zzu;
        String zza = zzibVar.zzd().zzh.zza();
        if (zza != null) {
            if ("unset".equals(zza)) {
                zzN("app", "_npa", null, zzibVar.zzaZ().currentTimeMillis());
            } else {
                if (true != "true".equals(zza)) {
                    j10 = 0;
                } else {
                    j10 = 1;
                }
                zzN("app", "_npa", Long.valueOf(j10), zzibVar.zzaZ().currentTimeMillis());
            }
        }
        if (this.zzu.zzB() && this.zzc) {
            zzibVar.zzaV().zzj().zza("Recording app launch after enabling measurement for the first time (FE)");
            zzU();
            this.zzu.zzh().zza.zza();
            zzibVar.zzaW().zzj(new zzjy(this));
            return;
        }
        zzibVar.zzaV().zzj().zza("Updating Scion state (FE)");
        this.zzu.zzt().zzi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzA(zzjk zzjkVar) {
        boolean z10;
        Boolean bool;
        zzg();
        if ((zzjkVar.zzo(zzjj.ANALYTICS_STORAGE) && zzjkVar.zzo(zzjj.AD_STORAGE)) || this.zzu.zzt().zzO()) {
            z10 = true;
        } else {
            z10 = false;
        }
        zzib zzibVar = this.zzu;
        if (z10 != zzibVar.zzE()) {
            zzibVar.zzD(z10);
            zzhg zzd = this.zzu.zzd();
            zzib zzibVar2 = zzd.zzu;
            zzd.zzg();
            if (zzd.zzd().contains("measurement_enabled_from_api")) {
                bool = Boolean.valueOf(zzd.zzd().getBoolean("measurement_enabled_from_api", true));
            } else {
                bool = null;
            }
            if (!z10 || bool == null || bool.booleanValue()) {
                zzar(Boolean.valueOf(z10), false);
            }
        }
    }

    public final void zzB(String str, String str2, Bundle bundle) {
        zzC(str, str2, bundle, true, true, this.zzu.zzaZ().currentTimeMillis());
    }

    public final void zzC(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10) {
        Bundle bundle2;
        boolean z12;
        String str3;
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = bundle;
        }
        if (Objects.equals(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
            this.zzu.zzs().zzj(bundle2, j10);
            return;
        }
        if (!z11 || this.zzd == null || zzpo.zzZ(str2)) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (str == null) {
            str3 = "app";
        } else {
            str3 = str;
        }
        zzJ(str3, str2, j10, bundle2, z11, z12, z10, null);
    }

    public final void zzD() {
        zzib zzibVar;
        zzfw zzfwVar;
        zzoc zzocVar;
        zzoc zzocVar2;
        int i10;
        zzli zzliVar;
        boolean z10;
        boolean z11;
        com.google.android.gms.internal.measurement.zzkp zzkpVar;
        zzg();
        zzib zzibVar2 = this.zzu;
        zzibVar2.zzaV().zzj().zza("Handle tcf update.");
        SharedPreferences zze = zzibVar2.zzd().zze();
        HashMap hashMap = new HashMap();
        zzfw zzfwVar2 = zzfx.zzaZ;
        if (((Boolean) zzfwVar2.zzb(null)).booleanValue()) {
            int i11 = zzoe.zzb;
            com.google.android.gms.internal.measurement.zzko zzkoVar = com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
            zzod zzodVar = zzod.CONSENT;
            Map.Entry a10 = j.a(zzkoVar, zzodVar);
            com.google.android.gms.internal.measurement.zzko zzkoVar2 = com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_SELECT_BASIC_ADS;
            zzod zzodVar2 = zzod.FLEXIBLE_LEGITIMATE_INTEREST;
            zzfwVar = zzfwVar2;
            zzibVar = zzibVar2;
            t m10 = t.m(a10, j.a(zzkoVar2, zzodVar2), j.a(com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE, zzodVar), j.a(com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS, zzodVar), j.a(com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE, zzodVar2), j.a(com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_APPLY_MARKET_RESEARCH_TO_GENERATE_AUDIENCE_INSIGHTS, zzodVar2), j.a(com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_DEVELOP_AND_IMPROVE_PRODUCTS, zzodVar2));
            u r10 = u.r("CH");
            char[] cArr = new char[5];
            boolean contains = zze.contains("IABTCF_TCString");
            int zzb = zzoe.zzb(zze, "IABTCF_CmpSdkID");
            int zzb2 = zzoe.zzb(zze, "IABTCF_PolicyVersion");
            int zzb3 = zzoe.zzb(zze, "IABTCF_gdprApplies");
            int zzb4 = zzoe.zzb(zze, "IABTCF_PurposeOneTreatment");
            int zzb5 = zzoe.zzb(zze, "IABTCF_EnableAdvertiserConsentMode");
            String zza = zzoe.zza(zze, "IABTCF_PublisherCC");
            t.a c10 = t.c();
            m0 it = m10.keySet().iterator();
            while (it.hasNext()) {
                com.google.android.gms.internal.measurement.zzko zzkoVar3 = (com.google.android.gms.internal.measurement.zzko) it.next();
                int zza2 = zzkoVar3.zza();
                StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 28);
                sb.append("IABTCF_PublisherRestrictions");
                sb.append(zza2);
                String zza3 = zzoe.zza(zze, sb.toString());
                if (!TextUtils.isEmpty(zza3) && zza3.length() >= 755) {
                    int digit = Character.digit(zza3.charAt(754), 10);
                    if (digit >= 0 && digit <= com.google.android.gms.internal.measurement.zzkp.values().length && digit != 0) {
                        if (digit != 1) {
                            if (digit != 2) {
                                zzkpVar = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_UNDEFINED;
                            } else {
                                zzkpVar = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST;
                            }
                        } else {
                            zzkpVar = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
                        }
                    } else {
                        zzkpVar = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_NOT_ALLOWED;
                    }
                } else {
                    zzkpVar = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_UNDEFINED;
                }
                c10.f(zzkoVar3, zzkpVar);
            }
            t c11 = c10.c();
            String zza4 = zzoe.zza(zze, "IABTCF_PurposeConsents");
            String zza5 = zzoe.zza(zze, "IABTCF_VendorConsents");
            if (!TextUtils.isEmpty(zza5) && zza5.length() >= 755 && zza5.charAt(754) == '1') {
                z10 = true;
            } else {
                z10 = false;
            }
            String zza6 = zzoe.zza(zze, "IABTCF_PurposeLegitimateInterests");
            String zza7 = zzoe.zza(zze, "IABTCF_VendorLegitimateInterests");
            if (!TextUtils.isEmpty(zza7) && zza7.length() >= 755 && zza7.charAt(754) == '1') {
                z11 = true;
            } else {
                z11 = false;
            }
            cArr[0] = '2';
            zzocVar = new zzoc(zzoe.zzd(m10, c11, r10, cArr, zzb, zzb5, zzb3, zzb2, zzb4, zza, zza4, zza6, z10, z11, contains));
        } else {
            zzibVar = zzibVar2;
            zzfwVar = zzfwVar2;
            String zza8 = zzoe.zza(zze, "IABTCF_VendorConsents");
            if (!"".equals(zza8) && zza8.length() > 754) {
                hashMap.put("GoogleConsent", String.valueOf(zza8.charAt(754)));
            }
            int zzb6 = zzoe.zzb(zze, "IABTCF_gdprApplies");
            if (zzb6 != -1) {
                hashMap.put("gdprApplies", String.valueOf(zzb6));
            }
            int zzb7 = zzoe.zzb(zze, "IABTCF_EnableAdvertiserConsentMode");
            if (zzb7 != -1) {
                hashMap.put("EnableAdvertiserConsentMode", String.valueOf(zzb7));
            }
            int zzb8 = zzoe.zzb(zze, "IABTCF_PolicyVersion");
            if (zzb8 != -1) {
                hashMap.put("PolicyVersion", String.valueOf(zzb8));
            }
            String zza9 = zzoe.zza(zze, "IABTCF_PurposeConsents");
            if (!"".equals(zza9)) {
                hashMap.put("PurposeConsents", zza9);
            }
            int zzb9 = zzoe.zzb(zze, "IABTCF_CmpSdkID");
            if (zzb9 != -1) {
                hashMap.put("CmpSdkID", String.valueOf(zzb9));
            }
            zzocVar = new zzoc(hashMap);
        }
        zzibVar.zzaV().zzk().zzb("Tcf preferences read", zzocVar);
        if (zzibVar.zzc().zzp(null, zzfwVar)) {
            zzhg zzd = zzibVar.zzd();
            zzd.zzg();
            String string = zzd.zzd().getString("stored_tcf_param", "");
            HashMap hashMap2 = new HashMap();
            if (TextUtils.isEmpty(string)) {
                zzocVar2 = new zzoc(hashMap2);
            } else {
                String[] split = string.split(";");
                int length = split.length;
                int i12 = 0;
                while (i12 < length) {
                    String[] split2 = split[i12].split("=");
                    if (split2.length >= 2 && zzoe.zza.contains(split2[0])) {
                        i10 = 1;
                        hashMap2.put(split2[0], split2[1]);
                    } else {
                        i10 = 1;
                    }
                    i12 += i10;
                }
                zzocVar2 = new zzoc(hashMap2);
            }
            if (zzibVar.zzd().zzm(zzocVar)) {
                Bundle zzb10 = zzocVar.zzb();
                zzibVar.zzaV().zzk().zzb("Consent generated from Tcf", zzb10);
                if (zzb10 != Bundle.EMPTY) {
                    zzliVar = this;
                    zzliVar.zzp(zzb10, -30, zzibVar.zzaZ().currentTimeMillis());
                } else {
                    zzliVar = this;
                }
                Bundle bundle = new Bundle();
                bundle.putString("_tcfm", zzocVar.zzd(zzocVar2));
                bundle.putString("_tcfd2", zzocVar.zzc());
                bundle.putString("_tcfd", zzocVar.zze());
                zzliVar.zzF("auto", "_tcf", bundle);
                return;
            }
            return;
        }
        if (zzibVar.zzd().zzm(zzocVar)) {
            Bundle zzb11 = zzocVar.zzb();
            zzibVar.zzaV().zzk().zzb("Consent generated from Tcf", zzb11);
            if (zzb11 != Bundle.EMPTY) {
                zzp(zzb11, -30, zzibVar.zzaZ().currentTimeMillis());
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_tcfd", zzocVar.zze());
            zzF("auto", "_tcf", bundle2);
        }
    }

    public final void zzE() {
        zzg();
        zzib zzibVar = this.zzu;
        zzibVar.zzaV().zzj().zza("Register tcfPrefChangeListener.");
        if (this.zzs == null) {
            this.zzt = new zzka(this, this.zzu);
            this.zzs = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.measurement.internal.zzld
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final /* synthetic */ void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    zzli.this.zzaf(sharedPreferences, str);
                }
            };
        }
        zzibVar.zzd().zze().registerOnSharedPreferenceChangeListener(this.zzs);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzF(String str, String str2, Bundle bundle) {
        zzg();
        zzG(str, str2, this.zzu.zzaZ().currentTimeMillis(), bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzG(String str, String str2, long j10, Bundle bundle) {
        boolean z10;
        zzg();
        if (this.zzd == null || zzpo.zzZ(str2)) {
            z10 = true;
        } else {
            z10 = false;
        }
        zzH(str, str2, j10, bundle, true, z10, true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzH(String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        boolean z13;
        boolean zza;
        Bundle bundle2;
        String str4;
        long j11;
        Bundle[] bundleArr;
        int i10;
        Class<?> cls;
        String str5 = str;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzg();
        zzb();
        zzib zzibVar = this.zzu;
        if (zzibVar.zzB()) {
            List zzp = this.zzu.zzv().zzp();
            if (zzp != null && !zzp.contains(str2)) {
                this.zzu.zzaV().zzj().zzc("Dropping non-safelisted event. event name, origin", str2, str5);
                return;
            }
            if (!this.zzf) {
                this.zzf = true;
                try {
                    if (!zzibVar.zzp()) {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, this.zzu.zzaY().getClassLoader());
                    } else {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                    }
                    try {
                        cls.getDeclaredMethod("initialize", Context.class).invoke(null, this.zzu.zzaY());
                    } catch (Exception e10) {
                        this.zzu.zzaV().zze().zzb("Failed to invoke Tag Manager's initialize() method", e10);
                    }
                } catch (ClassNotFoundException unused) {
                    this.zzu.zzaV().zzi().zza("Tag Manager is not found and thus will not be used");
                }
            }
            zzib zzibVar2 = this.zzu;
            if (!zzibVar2.zzc().zzp(null, zzfx.zzbg) && "_cmp".equals(str2) && bundle.containsKey("gclid")) {
                zzibVar2.zzaU();
                zzN("auto", "_lgclid", bundle.getString("gclid"), zzibVar2.zzaZ().currentTimeMillis());
            }
            zzibVar2.zzaU();
            if (z10 && zzpo.zzaf(str2)) {
                zzibVar2.zzk().zzI(bundle, zzibVar2.zzd().zzt.zza());
            }
            if (!z12) {
                zzibVar2.zzaU();
                if (!"_iap".equals(str2)) {
                    zzib zzibVar3 = this.zzu;
                    zzpo zzk = zzibVar3.zzk();
                    if (zzk.zzj("event", str2)) {
                        if (zzk.zzl("event", zzjl.zza, zzjl.zzb, str2)) {
                            zzk.zzu.zzc();
                            if (zzk.zzm("event", 40, str2)) {
                                i10 = 0;
                            }
                        } else {
                            i10 = 13;
                        }
                        if (i10 != 0) {
                            zzibVar2.zzaV().zzd().zzb("Invalid public event name. Event will not be logged (FE)", zzibVar2.zzl().zza(str2));
                            zzpo zzk2 = zzibVar3.zzk();
                            zzibVar3.zzc();
                            zzibVar3.zzk().zzN(this.zzv, null, i10, "_ev", zzk2.zzC(str2, 40, true), str2 != null ? str2.length() : 0);
                            return;
                        }
                    }
                    i10 = 2;
                    if (i10 != 0) {
                    }
                }
            }
            zzibVar2.zzaU();
            zzib zzibVar4 = this.zzu;
            zzlt zzh = zzibVar4.zzs().zzh(false);
            if (zzh != null && !bundle.containsKey("_sc")) {
                zzh.zzd = true;
            }
            zzpo.zzav(zzh, bundle, z10 && !z12);
            boolean equals = "am".equals(str5);
            boolean zzZ = zzpo.zzZ(str2);
            if (!z10 || this.zzd == null || zzZ) {
                z13 = equals;
            } else {
                if (!equals) {
                    zzibVar2.zzaV().zzj().zzc("Passing event to registered event handler (FE)", zzibVar2.zzl().zza(str2), zzibVar2.zzl().zze(bundle));
                    Preconditions.checkNotNull(this.zzd);
                    this.zzd.interceptEvent(str, str2, bundle, j10);
                    return;
                }
                z13 = true;
            }
            zzib zzibVar5 = this.zzu;
            if (zzibVar5.zzH()) {
                int zzn = zzibVar2.zzk().zzn(str2);
                if (zzn != 0) {
                    zzibVar2.zzaV().zzd().zzb("Invalid event name. Event will not be logged (FE)", zzibVar2.zzl().zza(str2));
                    zzpo zzk3 = zzibVar2.zzk();
                    zzibVar2.zzc();
                    zzibVar5.zzk().zzN(this.zzv, str3, zzn, "_ev", zzk3.zzC(str2, 40, true), str2 != null ? str2.length() : 0);
                    return;
                }
                String str6 = "_o";
                Bundle zzF = zzibVar2.zzk().zzF(str3, str2, bundle, CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"}), z12);
                Preconditions.checkNotNull(zzF);
                zzibVar2.zzaU();
                if (zzibVar4.zzs().zzh(false) != null && "_ae".equals(str2)) {
                    zznz zznzVar = zzibVar4.zzh().zzb;
                    long elapsedRealtime = zznzVar.zzc.zzu.zzaZ().elapsedRealtime();
                    long j12 = elapsedRealtime - zznzVar.zzb;
                    zznzVar.zzb = elapsedRealtime;
                    if (j12 > 0) {
                        zzibVar2.zzk().zzak(zzF, j12);
                    }
                }
                if (!"auto".equals(str5) && "_ssr".equals(str2)) {
                    zzpo zzk4 = zzibVar2.zzk();
                    String string = zzF.getString("_ffr");
                    if (Strings.isEmptyOrWhitespace(string)) {
                        string = null;
                    } else if (string != null) {
                        string = string.trim();
                    }
                    zzib zzibVar6 = zzk4.zzu;
                    if (!Objects.equals(string, zzibVar6.zzd().zzq.zza())) {
                        zzibVar6.zzd().zzq.zzb(string);
                    } else {
                        zzibVar6.zzaV().zzj().zza("Not logging duplicate session_start_with_rollout event");
                        return;
                    }
                } else if ("_ae".equals(str2)) {
                    String zza2 = zzibVar2.zzk().zzu.zzd().zzq.zza();
                    if (!TextUtils.isEmpty(zza2)) {
                        zzF.putString("_ffr", zza2);
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(zzF);
                if (zzibVar2.zzc().zzp(null, zzfx.zzaU)) {
                    zza = zzibVar4.zzh().zzi();
                } else {
                    zza = zzibVar2.zzd().zzn.zza();
                }
                if (zzibVar2.zzd().zzk.zza() > 0 && zzibVar2.zzd().zzp(j10) && zza) {
                    zzibVar2.zzaV().zzk().zza("Current session is expired, remove the session number, ID, and engagement time");
                    j11 = 0;
                    bundle2 = zzF;
                    str4 = "_ae";
                    zzN("auto", "_sid", null, zzibVar2.zzaZ().currentTimeMillis());
                    zzN("auto", "_sno", null, zzibVar2.zzaZ().currentTimeMillis());
                    zzN("auto", "_se", null, zzibVar2.zzaZ().currentTimeMillis());
                    zzibVar2.zzd().zzl.zzb(0L);
                } else {
                    bundle2 = zzF;
                    str4 = "_ae";
                    j11 = 0;
                }
                Bundle bundle3 = bundle2;
                if (bundle3.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j11) == 1) {
                    zzibVar2.zzaV().zzk().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                    zzibVar5.zzh().zza.zzb(j10, true);
                }
                ArrayList arrayList2 = new ArrayList(bundle3.keySet());
                Collections.sort(arrayList2);
                int size = arrayList2.size();
                for (int i11 = 0; i11 < size; i11++) {
                    String str7 = (String) arrayList2.get(i11);
                    if (str7 != null) {
                        zzibVar2.zzk();
                        Object obj = bundle3.get(str7);
                        if (obj instanceof Bundle) {
                            bundleArr = new Bundle[]{(Bundle) obj};
                        } else if (obj instanceof Parcelable[]) {
                            Parcelable[] parcelableArr = (Parcelable[]) obj;
                            bundleArr = (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
                        } else if (obj instanceof ArrayList) {
                            ArrayList arrayList3 = (ArrayList) obj;
                            bundleArr = (Bundle[]) arrayList3.toArray(new Bundle[arrayList3.size()]);
                        } else {
                            bundleArr = null;
                        }
                        if (bundleArr != null) {
                            bundle3.putParcelableArray(str7, bundleArr);
                        }
                    }
                }
                int i12 = 0;
                while (i12 < arrayList.size()) {
                    Bundle bundle4 = (Bundle) arrayList.get(i12);
                    String str8 = i12 != 0 ? "_ep" : str2;
                    String str9 = str6;
                    bundle4.putString(str9, str5);
                    if (z11) {
                        bundle4 = zzibVar2.zzk().zzab(bundle4, null);
                    }
                    Bundle bundle5 = bundle4;
                    zzibVar4.zzt().zzn(new zzbg(str8, new zzbe(bundle5), str, j10), str3);
                    if (!z13) {
                        Iterator it = this.zze.iterator();
                        while (it.hasNext()) {
                            ((zzjp) it.next()).onEvent(str, str2, new Bundle(bundle5), j10);
                        }
                    }
                    i12++;
                    str5 = str;
                    str6 = str9;
                }
                zzibVar2.zzaU();
                if (zzibVar4.zzs().zzh(false) == null || !str4.equals(str2)) {
                    return;
                }
                zzibVar4.zzh().zzb.zzd(true, true, zzibVar2.zzaZ().elapsedRealtime());
                return;
            }
            return;
        }
        this.zzu.zzaV().zzj().zza("Event not sent since app measurement is disabled");
    }

    public final void zzI(String str, String str2, Bundle bundle, String str3) {
        zzib.zzL();
        zzJ("auto", str2, this.zzu.zzaZ().currentTimeMillis(), bundle, false, true, true, str3);
    }

    protected final void zzJ(String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        int i10 = zzpo.zza;
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i11 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i11 < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i11];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i11] = new Bundle((Bundle) parcelable);
                        }
                        i11++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i11 < list.size()) {
                        Object obj2 = list.get(i11);
                        if (obj2 instanceof Bundle) {
                            list.set(i11, new Bundle((Bundle) obj2));
                        }
                        i11++;
                    }
                }
            }
        }
        this.zzu.zzaW().zzj(new zzkb(this, str, str2, j10, bundle2, z10, z11, z12, str3));
    }

    public final void zzK(String str, String str2, Object obj, boolean z10) {
        zzL("auto", "_ldl", obj, true, this.zzu.zzaZ().currentTimeMillis());
    }

    public final void zzL(String str, String str2, Object obj, boolean z10, long j10) {
        int i10;
        String str3;
        int length;
        int i11;
        if (z10) {
            i10 = this.zzu.zzk().zzp(str2);
        } else {
            zzpo zzk = this.zzu.zzk();
            if (zzk.zzj("user property", str2)) {
                if (!zzk.zzl("user property", zzjn.zza, null, str2)) {
                    i10 = 15;
                } else {
                    zzk.zzu.zzc();
                    if (zzk.zzm("user property", 24, str2)) {
                        i10 = 0;
                    }
                }
            }
            i10 = 6;
        }
        if (i10 != 0) {
            zzib zzibVar = this.zzu;
            zzpo zzk2 = zzibVar.zzk();
            zzibVar.zzc();
            String zzC = zzk2.zzC(str2, 24, true);
            if (str2 != null) {
                i11 = str2.length();
            } else {
                i11 = 0;
            }
            zzib zzibVar2 = this.zzu;
            zzibVar2.zzk().zzN(this.zzv, null, i10, "_ev", zzC, i11);
            return;
        }
        if (str == null) {
            str3 = "app";
        } else {
            str3 = str;
        }
        if (obj != null) {
            zzib zzibVar3 = this.zzu;
            int zzK = zzibVar3.zzk().zzK(str2, obj);
            if (zzK != 0) {
                zzpo zzk3 = zzibVar3.zzk();
                zzibVar3.zzc();
                String zzC2 = zzk3.zzC(str2, 24, true);
                if (!(obj instanceof String) && !(obj instanceof CharSequence)) {
                    length = 0;
                } else {
                    length = obj.toString().length();
                }
                zzib zzibVar4 = this.zzu;
                zzibVar4.zzk().zzN(this.zzv, null, zzK, "_ev", zzC2, length);
                return;
            }
            Object zzL = zzibVar3.zzk().zzL(str2, obj);
            if (zzL != null) {
                zzM(str3, str2, j10, zzL);
                return;
            }
            return;
        }
        zzM(str3, str2, j10, null);
    }

    final void zzM(String str, String str2, long j10, Object obj) {
        this.zzu.zzaW().zzj(new zzkc(this, str, str2, obj, j10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzN(String str, String str2, Object obj, long j10) {
        long j11;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzb();
        Object obj2 = obj;
        if (FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS.equals(str2)) {
            if (obj instanceof String) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    String lowerCase = str3.toLowerCase(Locale.ENGLISH);
                    String str4 = RequestConstant.FALSE;
                    if (true != RequestConstant.FALSE.equals(lowerCase)) {
                        j11 = 0;
                    } else {
                        j11 = 1;
                    }
                    zzib zzibVar = this.zzu;
                    Long valueOf = Long.valueOf(j11);
                    zzhf zzhfVar = zzibVar.zzd().zzh;
                    if (valueOf.longValue() == 1) {
                        str4 = "true";
                    }
                    zzhfVar.zzb(str4);
                    obj = valueOf;
                    str2 = "_npa";
                    this.zzu.zzaV().zzk().zzc("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
                    obj2 = obj;
                }
            }
            if (obj == null) {
                this.zzu.zzd().zzh.zzb("unset");
                obj = obj;
                str2 = "_npa";
            }
            this.zzu.zzaV().zzk().zzc("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
            obj2 = obj;
        }
        String str5 = str2;
        Object obj3 = obj2;
        zzib zzibVar2 = this.zzu;
        if (!zzibVar2.zzB()) {
            this.zzu.zzaV().zzk().zza("User property not set since app measurement is disabled");
        } else {
            if (!zzibVar2.zzH()) {
                return;
            }
            this.zzu.zzt().zzA(new zzpk(str5, j10, obj3, str));
        }
    }

    public final List zzO(boolean z10) {
        zzb();
        zzib zzibVar = this.zzu;
        zzibVar.zzaV().zzk().zza("Getting user properties (FE)");
        if (!zzibVar.zzaW().zze()) {
            zzibVar.zzaU();
            if (zzae.zza()) {
                zzibVar.zzaV().zzb().zza("Cannot get all user properties from main thread");
                return Collections.emptyList();
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzaW().zzk(atomicReference, 5000L, "get user properties", new zzke(this, atomicReference, z10));
            List list = (List) atomicReference.get();
            if (list == null) {
                zzibVar.zzaV().zzb().zzb("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z10));
                return Collections.emptyList();
            }
            return list;
        }
        zzibVar.zzaV().zzb().zza("Cannot get all user properties from analytics worker thread");
        return Collections.emptyList();
    }

    public final Map zzP(String str, String str2, boolean z10) {
        zzib zzibVar = this.zzu;
        if (zzibVar.zzaW().zze()) {
            zzibVar.zzaV().zzb().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        zzibVar.zzaU();
        if (zzae.zza()) {
            zzibVar.zzaV().zzb().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzaW().zzk(atomicReference, 5000L, "get user properties", new zzkk(this, atomicReference, null, str, str2, z10));
        List<zzpk> list = (List) atomicReference.get();
        if (list == null) {
            zzibVar.zzaV().zzb().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z10));
            return Collections.emptyMap();
        }
        androidx.collection.a aVar = new androidx.collection.a(list.size());
        for (zzpk zzpkVar : list) {
            Object zza = zzpkVar.zza();
            if (zza != null) {
                aVar.put(zzpkVar.zzb, zza);
            }
        }
        return aVar;
    }

    public final String zzQ() {
        return (String) this.zzg.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzR(String str) {
        this.zzg.set(str);
    }

    public final void zzS() {
        zzg();
        zzib zzibVar = this.zzu;
        if (!zzibVar.zzd().zzo.zza()) {
            long zza = zzibVar.zzd().zzp.zza();
            zzibVar.zzd().zzp.zzb(1 + zza);
            zzibVar.zzc();
            if (zza >= 5) {
                zzibVar.zzaV().zze().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                zzibVar.zzd().zzo.zzb(true);
                return;
            } else {
                if (this.zzr == null) {
                    this.zzr = new zzkf(this, this.zzu);
                }
                this.zzr.zzb(0L);
                return;
            }
        }
        zzibVar.zzaV().zzj().zza("Deferred Deep Link already retrieved. Not fetching again.");
    }

    public final void zzT(long j10) {
        this.zzg.set(null);
        this.zzu.zzaW().zzj(new zzkg(this, j10));
    }

    public final void zzU() {
        zzg();
        zzb();
        if (this.zzu.zzH()) {
            zzib zzibVar = this.zzu;
            zzal zzc = zzibVar.zzc();
            zzc.zzu.zzaU();
            Boolean zzr = zzc.zzr("google_analytics_deferred_deep_link_enabled");
            if (zzr != null && zzr.booleanValue()) {
                zzibVar.zzaV().zzj().zza("Deferred Deep Link feature enabled.");
                zzibVar.zzaW().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlg
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzli.this.zzS();
                    }
                });
            }
            this.zzu.zzt().zzE();
            this.zzc = false;
            zzhg zzd = zzibVar.zzd();
            zzd.zzg();
            String string = zzd.zzd().getString("previous_os_version", null);
            zzd.zzu.zzu().zzw();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = zzd.zzd().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (!TextUtils.isEmpty(string)) {
                zzibVar.zzu().zzw();
                if (!string.equals(str)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", string);
                    zzF("auto", "_ou", bundle);
                }
            }
        }
    }

    public final void zzV(zzjo zzjoVar) {
        zzjo zzjoVar2;
        boolean z10;
        zzg();
        zzb();
        if (zzjoVar != null && zzjoVar != (zzjoVar2 = this.zzd)) {
            if (zzjoVar2 == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "EventInterceptor already set.");
        }
        this.zzd = zzjoVar;
    }

    public final void zzW(zzjp zzjpVar) {
        zzb();
        Preconditions.checkNotNull(zzjpVar);
        if (!this.zze.add(zzjpVar)) {
            this.zzu.zzaV().zze().zza("OnEventListener already registered");
        }
    }

    public final void zzX(zzjp zzjpVar) {
        zzb();
        Preconditions.checkNotNull(zzjpVar);
        if (!this.zze.remove(zzjpVar)) {
            this.zzu.zzaV().zze().zza("OnEventListener had not been registered");
        }
    }

    public final int zzY(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzu.zzc();
        return 25;
    }

    public final void zzZ(Bundle bundle) {
        zzaa(bundle, this.zzu.zzaZ().currentTimeMillis());
    }

    public final void zzaa(Bundle bundle, long j10) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.zzu.zzaV().zze().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzjg.zzb(bundle2, "app_id", String.class, null);
        zzjg.zzb(bundle2, "origin", String.class, null);
        zzjg.zzb(bundle2, "name", String.class, null);
        zzjg.zzb(bundle2, "value", Object.class, null);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzjg.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j10);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        zzib zzibVar = this.zzu;
        if (zzibVar.zzk().zzp(string) == 0) {
            if (zzibVar.zzk().zzK(string, obj) == 0) {
                Object zzL = zzibVar.zzk().zzL(string, obj);
                if (zzL == null) {
                    zzibVar.zzaV().zzb().zzc("Unable to normalize conditional user property value", zzibVar.zzl().zzc(string), obj);
                    return;
                }
                zzjg.zza(bundle2, zzL);
                long j11 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
                if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME))) {
                    zzibVar.zzc();
                    if (j11 > 15552000000L || j11 < 1) {
                        zzibVar.zzaV().zzb().zzc("Invalid conditional user property timeout", zzibVar.zzl().zzc(string), Long.valueOf(j11));
                        return;
                    }
                }
                long j12 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                zzibVar.zzc();
                if (j12 <= 15552000000L && j12 >= 1) {
                    zzibVar.zzaW().zzj(new zzkh(this, bundle2));
                    return;
                } else {
                    zzibVar.zzaV().zzb().zzc("Invalid conditional user property time to live", zzibVar.zzl().zzc(string), Long.valueOf(j12));
                    return;
                }
            }
            zzibVar.zzaV().zzb().zzc("Invalid conditional user property value", zzibVar.zzl().zzc(string), obj);
            return;
        }
        zzibVar.zzaV().zzb().zzb("Invalid conditional user property name", zzibVar.zzl().zzc(string));
    }

    public final void zzab(String str, String str2, Bundle bundle) {
        zzib zzibVar = this.zzu;
        long currentTimeMillis = zzibVar.zzaZ().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzibVar.zzaW().zzj(new zzki(this, bundle2));
    }

    public final ArrayList zzac(String str, String str2) {
        zzib zzibVar = this.zzu;
        if (zzibVar.zzaW().zze()) {
            zzibVar.zzaV().zzb().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        zzibVar.zzaU();
        if (zzae.zza()) {
            zzibVar.zzaV().zzb().zza("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzaW().zzk(atomicReference, 5000L, "get conditional user properties", new zzkj(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list == null) {
            zzibVar.zzaV().zzb().zzb("Timed out waiting for get conditional user properties", null);
            return new ArrayList();
        }
        return zzpo.zzas(list);
    }

    public final String zzad() {
        zzlt zzl = this.zzu.zzs().zzl();
        if (zzl != null) {
            return zzl.zza;
        }
        return null;
    }

    public final String zzae() {
        zzlt zzl = this.zzu.zzs().zzl();
        if (zzl != null) {
            return zzl.zzb;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaf(SharedPreferences sharedPreferences, String str) {
        zzib zzibVar = this.zzu;
        if (!zzibVar.zzc().zzp(null, zzfx.zzaZ)) {
            if (Objects.equals(str, "IABTCF_TCString")) {
                zzibVar.zzaV().zzk().zza("IABTCF_TCString change picked up in listener.");
                ((zzay) Preconditions.checkNotNull(this.zzt)).zzb(500L);
                return;
            }
            return;
        }
        if (!Objects.equals(str, "IABTCF_TCString") && !Objects.equals(str, "IABTCF_gdprApplies") && !Objects.equals(str, "IABTCF_EnableAdvertiserConsentMode")) {
            return;
        }
        zzibVar.zzaV().zzk().zza("IABTCF_TCString change picked up in listener.");
        ((zzay) Preconditions.checkNotNull(this.zzt)).zzb(500L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzag(Bundle bundle) {
        Bundle bundle2;
        int i10;
        if (bundle.isEmpty()) {
            bundle2 = bundle;
        } else {
            zzib zzibVar = this.zzu;
            bundle2 = new Bundle(zzibVar.zzd().zzt.zza());
            Iterator<String> it = bundle.keySet().iterator();
            while (true) {
                i10 = 0;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                Object obj = bundle.get(next);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    if (zzibVar.zzk().zzt(obj)) {
                        zzibVar.zzk().zzN(this.zzv, null, 27, null, null, 0);
                    }
                    zzibVar.zzaV().zzh().zzc("Invalid default event parameter type. Name, value", next, obj);
                } else if (zzpo.zzZ(next)) {
                    zzibVar.zzaV().zzh().zzb("Invalid default event parameter name. Name", next);
                } else if (obj == null) {
                    bundle2.remove(next);
                } else if (zzibVar.zzk().zzu("param", next, zzibVar.zzc().zze(null, false), obj)) {
                    zzibVar.zzk().zzM(bundle2, next, obj);
                }
            }
            zzibVar.zzk();
            int zzc = zzibVar.zzc().zzc();
            if (bundle2.size() > zzc) {
                for (String str : new TreeSet(bundle2.keySet())) {
                    i10++;
                    if (i10 > zzc) {
                        bundle2.remove(str);
                    }
                }
                zzibVar.zzk().zzN(this.zzv, null, 26, null, null, 0);
                zzibVar.zzaV().zzh().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
        }
        zzib zzibVar2 = this.zzu;
        zzibVar2.zzd().zzt.zzb(bundle2);
        if (bundle.isEmpty() && !zzibVar2.zzc().zzp(null, zzfx.zzaW)) {
            return;
        }
        this.zzu.zzt().zzH(bundle2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzah(int i10) {
        if (this.zzk == null) {
            this.zzk = new zzjw(this, this.zzu);
        }
        this.zzk.zzb(i10 * 1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzai(Boolean bool, boolean z10) {
        zzar(bool, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaj(zzjk zzjkVar, long j10, boolean z10, boolean z11) {
        zzg();
        zzb();
        zzib zzibVar = this.zzu;
        zzjk zzl = zzibVar.zzd().zzl();
        if (j10 <= this.zzq && zzjk.zzu(zzl.zzb(), zzjkVar.zzb())) {
            zzibVar.zzaV().zzi().zzb("Dropped out-of-date consent setting, proposed settings", zzjkVar);
            return;
        }
        zzhg zzd = zzibVar.zzd();
        zzib zzibVar2 = zzd.zzu;
        zzd.zzg();
        int zzb = zzjkVar.zzb();
        if (zzd.zzk(zzb)) {
            zzib zzibVar3 = this.zzu;
            SharedPreferences.Editor edit = zzd.zzd().edit();
            edit.putString("consent_settings", zzjkVar.zzl());
            edit.putInt("consent_source", zzb);
            edit.apply();
            zzibVar.zzaV().zzk().zzb("Setting storage consent(FE)", zzjkVar);
            this.zzq = j10;
            if (zzibVar3.zzt().zzP()) {
                zzibVar3.zzt().zzk(z10);
            } else {
                zzibVar3.zzt().zzj(z10);
            }
            if (z11) {
                zzibVar3.zzt().zzC(new AtomicReference());
                return;
            }
            return;
        }
        zzibVar.zzaV().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzjkVar.zzb()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzal(boolean z10) {
        this.zzi = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ int zzam() {
        return this.zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzan(int i10) {
        this.zzj = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzay zzao() {
        return this.zzr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ int zzap(Throwable th) {
        String message = th.getMessage();
        this.zzn = false;
        int i10 = 2;
        if (message != null) {
            if (!(th instanceof IllegalStateException) && !message.contains("garbage collected") && !th.getClass().getSimpleName().equals("ServiceUnavailableException")) {
                if ((th instanceof SecurityException) && !message.endsWith("READ_DEVICE_CONFIG")) {
                    return 3;
                }
            } else {
                i10 = 1;
                if (message.contains("Background")) {
                    this.zzn = true;
                    return 1;
                }
            }
        }
        return i10;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return false;
    }

    public final void zzh() {
        zzib zzibVar = this.zzu;
        if ((zzibVar.zzaY().getApplicationContext() instanceof Application) && this.zza != null) {
            ((Application) zzibVar.zzaY().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final Boolean zzi() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.zzu.zzaW().zzk(atomicReference, 15000L, "boolean test flag value", new zzkd(this, atomicReference));
    }

    public final String zzj() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.zzu.zzaW().zzk(atomicReference, 15000L, "String test flag value", new zzkn(this, atomicReference));
    }

    public final Long zzk() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.zzu.zzaW().zzk(atomicReference, 15000L, "long test flag value", new zzko(this, atomicReference));
    }

    public final Integer zzl() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.zzu.zzaW().zzk(atomicReference, 15000L, "int test flag value", new zzkp(this, atomicReference));
    }

    public final Double zzm() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.zzu.zzaW().zzk(atomicReference, 15000L, "double test flag value", new zzkq(this, atomicReference));
    }

    public final void zzn(Boolean bool) {
        zzb();
        this.zzu.zzaW().zzj(new zzkr(this, bool));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzp(Bundle bundle, int i10, long j10) {
        Object obj;
        String str;
        String string;
        zzb();
        zzjk zzjkVar = zzjk.zza;
        zzjj[] zzb = zzji.STORAGE.zzb();
        int length = zzb.length;
        int i11 = 0;
        while (true) {
            obj = null;
            if (i11 >= length) {
                break;
            }
            String str2 = zzb[i11].zze;
            if (bundle.containsKey(str2) && (string = bundle.getString(str2)) != null) {
                if (string.equals("granted")) {
                    obj = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    obj = Boolean.FALSE;
                }
                if (obj == null) {
                    obj = string;
                    break;
                }
            }
            i11++;
        }
        if (obj != null) {
            zzib zzibVar = this.zzu;
            zzibVar.zzaV().zzh().zzb("Ignoring invalid consent setting", obj);
            zzibVar.zzaV().zzh().zza("Valid consent values are 'granted', 'denied'");
        }
        boolean zze = this.zzu.zzaW().zze();
        zzjk zze2 = zzjk.zze(bundle, i10);
        if (zze2.zzc()) {
            zzs(zze2, zze);
        }
        zzaz zzh = zzaz.zzh(bundle, i10);
        if (zzh.zzd()) {
            zzq(zzh, zze);
        }
        Boolean zzi = zzaz.zzi(bundle);
        if (zzi != null) {
            if (i10 == -30) {
                str = "tcf";
            } else {
                str = "app";
            }
            String str3 = str;
            if (zze) {
                zzN(str3, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, zzi.toString(), j10);
            } else {
                zzL(str3, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, zzi.toString(), false, j10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzq(zzaz zzazVar, boolean z10) {
        zzks zzksVar = new zzks(this, zzazVar);
        if (z10) {
            zzg();
            zzksVar.run();
        } else {
            this.zzu.zzaW().zzj(zzksVar);
        }
    }

    public final void zzs(zzjk zzjkVar, boolean z10) {
        boolean z11;
        zzjk zzjkVar2;
        boolean z12;
        boolean z13;
        zzb();
        int zzb = zzjkVar.zzb();
        if (zzb != -10) {
            zzjh zzp = zzjkVar.zzp();
            zzjh zzjhVar = zzjh.UNINITIALIZED;
            if (zzp == zzjhVar && zzjkVar.zzq() == zzjhVar) {
                this.zzu.zzaV().zzh().zza("Ignoring empty consent settings");
                return;
            }
        }
        synchronized (this.zzh) {
            try {
                z11 = false;
                if (zzjk.zzu(zzb, this.zzo.zzb())) {
                    z12 = zzjkVar.zzr(this.zzo);
                    zzjj zzjjVar = zzjj.ANALYTICS_STORAGE;
                    if (zzjkVar.zzo(zzjjVar) && !this.zzo.zzo(zzjjVar)) {
                        z11 = true;
                    }
                    zzjk zzt = zzjkVar.zzt(this.zzo);
                    this.zzo = zzt;
                    zzjkVar2 = zzt;
                    z13 = z11;
                    z11 = true;
                } else {
                    zzjkVar2 = zzjkVar;
                    z12 = false;
                    z13 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z11) {
            this.zzu.zzaV().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", zzjkVar2);
            return;
        }
        long andIncrement = this.zzp.getAndIncrement();
        if (z12) {
            this.zzg.set(null);
            zzkt zzktVar = new zzkt(this, zzjkVar2, andIncrement, z13);
            if (z10) {
                zzg();
                zzktVar.run();
                return;
            } else {
                this.zzu.zzaW().zzl(zzktVar);
                return;
            }
        }
        zzku zzkuVar = new zzku(this, zzjkVar2, andIncrement, z13);
        if (z10) {
            zzg();
            zzkuVar.run();
        } else if (zzb != 30 && zzb != -10) {
            this.zzu.zzaW().zzj(zzkuVar);
        } else {
            this.zzu.zzaW().zzl(zzkuVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzt(Runnable runnable) {
        zzb();
        zzib zzibVar = this.zzu;
        if (!zzibVar.zzaW().zze()) {
            if (!zzibVar.zzaW().zzf()) {
                zzibVar.zzaU();
                if (!zzae.zza()) {
                    zzibVar.zzaV().zzk().zza("[sgtm] Started client-side batch upload work.");
                    boolean z10 = false;
                    int i10 = 0;
                    int i11 = 0;
                    while (!z10) {
                        zzibVar.zzaV().zzk().zza("[sgtm] Getting upload batches from service (FE)");
                        final AtomicReference atomicReference = new AtomicReference();
                        zzibVar.zzaW().zzk(atomicReference, BaseServer.TIMEOUT_DEBUG, "[sgtm] Getting upload batches", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlh
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzli.this.zzu.zzt().zzx(atomicReference, zzon.zza(zzlr.SGTM_CLIENT));
                            }
                        });
                        zzop zzopVar = (zzop) atomicReference.get();
                        if (zzopVar == null) {
                            break;
                        }
                        List list = zzopVar.zza;
                        if (!list.isEmpty()) {
                            zzibVar.zzaV().zzk().zzb("[sgtm] Retrieved upload batches. count", Integer.valueOf(list.size()));
                            i10 += list.size();
                            Iterator it = list.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    zzlq zzaq = zzaq((zzol) it.next());
                                    if (zzaq == zzlq.SUCCESS) {
                                        i11++;
                                    } else if (zzaq == zzlq.BACKOFF) {
                                        z10 = true;
                                        break;
                                    }
                                } else {
                                    z10 = false;
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                    }
                    zzibVar.zzaV().zzk().zzc("[sgtm] Completed client-side batch upload work. total, success", Integer.valueOf(i10), Integer.valueOf(i11));
                    runnable.run();
                    return;
                }
                zzibVar.zzaV().zzb().zza("Cannot retrieve and upload batches from main thread");
                return;
            }
            zzibVar.zzaV().zzb().zza("Cannot retrieve and upload batches from analytics network thread");
            return;
        }
        zzibVar.zzaV().zzb().zza("Cannot retrieve and upload batches from analytics worker thread");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzu(long j10) {
        zzg();
        if (this.zzl == null) {
            this.zzl = new zzjt(this, this.zzu);
        }
        this.zzl.zzb(j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzv() {
        zzg();
        zzay zzayVar = this.zzl;
        if (zzayVar != null) {
            zzayVar.zzd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzw() {
        zzql.zza();
        zzib zzibVar = this.zzu;
        if (zzibVar.zzc().zzp(null, zzfx.zzaQ)) {
            if (!zzibVar.zzaW().zze()) {
                zzibVar.zzaU();
                if (!zzae.zza()) {
                    zzb();
                    zzibVar.zzaV().zzk().zza("Getting trigger URIs (FE)");
                    final AtomicReference atomicReference = new AtomicReference();
                    zzibVar.zzaW().zzk(atomicReference, BaseServer.TIMEOUT_DEBUG, "get trigger URIs", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkz
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzli zzliVar = zzli.this;
                            zzliVar.zzu.zzt().zzw(atomicReference, zzliVar.zzu.zzd().zzi.zza());
                        }
                    });
                    final List list = (List) atomicReference.get();
                    if (list == null) {
                        zzibVar.zzaV().zzd().zza("Timed out waiting for get trigger URIs");
                        return;
                    } else {
                        zzibVar.zzaW().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzla
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                boolean contains;
                                zzli zzliVar = zzli.this;
                                zzliVar.zzg();
                                if (Build.VERSION.SDK_INT < 30) {
                                    return;
                                }
                                List<zzog> list2 = list;
                                SparseArray zzf = zzliVar.zzu.zzd().zzf();
                                for (zzog zzogVar : list2) {
                                    int i10 = zzogVar.zzc;
                                    contains = zzf.contains(i10);
                                    if (!contains || ((Long) zzf.get(i10)).longValue() < zzogVar.zzb) {
                                        zzliVar.zzy().add(zzogVar);
                                    }
                                }
                                zzliVar.zzz();
                            }
                        });
                        return;
                    }
                }
                zzibVar.zzaV().zzb().zza("Cannot get trigger URIs from main thread");
                return;
            }
            zzibVar.zzaV().zzb().zza("Cannot get trigger URIs from analytics worker thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzx() {
        return this.zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(30)
    public final PriorityQueue zzy() {
        Comparator comparing;
        if (this.zzm == null) {
            i.a();
            comparing = Comparator.comparing(zzlb.zza, zzlc.zza);
            this.zzm = h.a(comparing);
        }
        return this.zzm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(30)
    public final void zzz() {
        zzog zzogVar;
        zzg();
        this.zzn = false;
        if (!zzy().isEmpty() && !this.zzi && (zzogVar = (zzog) zzy().poll()) != null) {
            zzib zzibVar = this.zzu;
            MeasurementManagerFutures zzT = zzibVar.zzk().zzT();
            if (zzT != null) {
                this.zzi = true;
                zzgr zzk = zzibVar.zzaV().zzk();
                String str = zzogVar.zza;
                zzk.zzb("Registering trigger URI", str);
                m8.d registerTriggerAsync = zzT.registerTriggerAsync(Uri.parse(str));
                if (registerTriggerAsync == null) {
                    this.zzi = false;
                    zzy().add(zzogVar);
                } else {
                    m8.b.a(registerTriggerAsync, new zzjv(this, zzogVar), new zzju(this));
                }
            }
        }
    }
}
