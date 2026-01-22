package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.qiahao.base_common.network.BaseServer;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzpo extends zzje {
    public static final /* synthetic */ int zza = 0;
    private static final String[] zzb = {"firebase_", "google_", "ga_"};
    private static final String[] zzc = {"_err"};
    private SecureRandom zzd;
    private final AtomicLong zze;
    private int zzf;
    private MeasurementManagerFutures zzg;
    private Boolean zzh;
    private Integer zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpo(zzib zzibVar) {
        super(zzibVar);
        this.zzi = null;
        this.zze = new AtomicLong(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MessageDigest zzO() {
        MessageDigest messageDigest;
        for (int i10 = 0; i10 < 2; i10++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static long zzP(byte[] bArr) {
        boolean z10;
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        int i10 = 0;
        if (length > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10);
        long j10 = 0;
        for (int i11 = length - 1; i11 >= 0 && i11 >= bArr.length - 8; i11--) {
            j10 += (bArr[i11] & 255) << i10;
            i10 += 8;
        }
        return j10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzQ(Context context, boolean z10) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return zzR(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return zzR(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzR(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzZ(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("_")) {
            return true;
        }
        return false;
    }

    private static boolean zzaA(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean zzaf(String str) {
        if (zzc[0].equals(str)) {
            return false;
        }
        return true;
    }

    public static ArrayList zzas(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzah zzahVar = (zzah) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzahVar.zza);
            bundle.putString("origin", zzahVar.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, zzahVar.zzd);
            bundle.putString("name", zzahVar.zzc.zzb);
            zzjg.zza(bundle, Preconditions.checkNotNull(zzahVar.zzc.zza()));
            bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, zzahVar.zze);
            String str = zzahVar.zzf;
            if (str != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str);
            }
            zzbg zzbgVar = zzahVar.zzg;
            if (zzbgVar != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, zzbgVar.zza);
                zzbe zzbeVar = zzbgVar.zzb;
                if (zzbeVar != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, zzbeVar.zzf());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, zzahVar.zzh);
            zzbg zzbgVar2 = zzahVar.zzi;
            if (zzbgVar2 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, zzbgVar2.zza);
                zzbe zzbeVar2 = zzbgVar2.zzb;
                if (zzbeVar2 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, zzbeVar2.zzf());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, zzahVar.zzc.zzc);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, zzahVar.zzj);
            zzbg zzbgVar3 = zzahVar.zzk;
            if (zzbgVar3 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, zzbgVar3.zza);
                zzbe zzbeVar3 = zzbgVar3.zzb;
                if (zzbeVar3 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, zzbeVar3.zzf());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzau(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static void zzav(zzlt zzltVar, Bundle bundle, boolean z10) {
        if (bundle != null && zzltVar != null) {
            if (bundle.containsKey("_sc") && !z10) {
                z10 = false;
            } else {
                String str = zzltVar.zza;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = zzltVar.zzb;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", zzltVar.zzc);
                return;
            }
        }
        if (bundle != null && zzltVar == null && z10) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    static final boolean zzax(Bundle bundle, int i10) {
        if (bundle != null && bundle.getLong("_err") == 0) {
            bundle.putLong("_err", i10);
            return true;
        }
        return false;
    }

    private final Object zzay(int i10, Object obj, boolean z10, boolean z11, String str) {
        long j10;
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Long) && !(obj instanceof Double)) {
            if (obj instanceof Integer) {
                return Long.valueOf(((Integer) obj).intValue());
            }
            if (obj instanceof Byte) {
                return Long.valueOf(((Byte) obj).byteValue());
            }
            if (obj instanceof Short) {
                return Long.valueOf(((Short) obj).shortValue());
            }
            if (obj instanceof Boolean) {
                if (true != ((Boolean) obj).booleanValue()) {
                    j10 = 0;
                } else {
                    j10 = 1;
                }
                return Long.valueOf(j10);
            }
            if (obj instanceof Float) {
                return Double.valueOf(((Float) obj).doubleValue());
            }
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                if (!z11 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (Parcelable parcelable : (Parcelable[]) obj) {
                    if (parcelable instanceof Bundle) {
                        Bundle zzab = zzab((Bundle) parcelable, null);
                        if (!zzab.isEmpty()) {
                            arrayList.add(zzab);
                        }
                    }
                }
                return arrayList.toArray(new Bundle[arrayList.size()]);
            }
            return zzC(obj.toString(), i10, z10);
        }
        return obj;
    }

    private final int zzaz(String str) {
        if ("_ldl".equals(str)) {
            this.zzu.zzc();
            return 2048;
        }
        if (TransferTable.COLUMN_ID.equals(str)) {
            this.zzu.zzc();
            return 256;
        }
        if ("_lgclid".equals(str)) {
            this.zzu.zzc();
            return 100;
        }
        this.zzu.zzc();
        return 36;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzh(String str) {
        Preconditions.checkNotEmpty(str);
        if (str.charAt(0) == '_' && !str.equals("_ep")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzA(String str) {
        if (!TextUtils.isEmpty(str)) {
            Preconditions.checkNotNull(str);
            if (!str.matches("^1:\\d+:android:[a-f0-9]+$")) {
                this.zzu.zzaV().zzd().zzb("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzgt.zzl(str));
                return false;
            }
            return true;
        }
        this.zzu.zzaV().zzd().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzB(String str, String str2) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            Preconditions.checkNotNull(str);
            if (!str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public final String zzC(String str, int i10, boolean z10) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) > i10) {
            if (!z10) {
                return null;
            }
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i10))).concat("...");
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00d4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final int zzD(String str, String str2, String str3, Object obj, Bundle bundle, List list, boolean z10, boolean z11) {
        int i10;
        int zzf;
        Object obj2;
        int size;
        zzg();
        if (zzt(obj)) {
            if (z11) {
                if (!zzaA(str3, zzjm.zzc)) {
                    return 20;
                }
                zznk zzt = this.zzu.zzt();
                zzt.zzg();
                zzt.zzb();
                if (zzt.zzK() && zzt.zzu.zzk().zzah() < 200900) {
                    return 25;
                }
                zzib zzibVar = this.zzu;
                zzibVar.zzc();
                boolean z12 = obj instanceof Parcelable[];
                if (z12) {
                    size = ((Parcelable[]) obj).length;
                } else if (obj instanceof ArrayList) {
                    size = ((ArrayList) obj).size();
                }
                if (size > 200) {
                    zzibVar.zzaV().zzh().zzd("Parameter array is too long; discarded. Value kind, name, array length", "param", str3, Integer.valueOf(size));
                    zzibVar.zzc();
                    if (z12) {
                        Parcelable[] parcelableArr = (Parcelable[]) obj;
                        if (parcelableArr.length > 200) {
                            bundle.putParcelableArray(str3, (Parcelable[]) Arrays.copyOf(parcelableArr, 200));
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) obj;
                        if (arrayList.size() > 200) {
                            bundle.putParcelableArrayList(str3, new ArrayList<>(arrayList.subList(0, 200)));
                        }
                    }
                    i10 = 17;
                    if (zzZ(str2) && !zzZ(str3)) {
                        zzf = this.zzu.zzc().zze(null, false);
                    } else {
                        zzf = this.zzu.zzc().zzf(null, false);
                    }
                    if (!zzu("param", str3, zzf, obj)) {
                        return i10;
                    }
                    if (z11) {
                        if (obj instanceof Bundle) {
                            zzz(str, str2, str3, (Bundle) obj, list, z10);
                        } else if (obj instanceof Parcelable[]) {
                            for (Parcelable parcelable : (Parcelable[]) obj) {
                                if (!(parcelable instanceof Bundle)) {
                                    this.zzu.zzaV().zzh().zzc("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str3);
                                    return 4;
                                }
                                zzz(str, str2, str3, (Bundle) parcelable, list, z10);
                            }
                        } else if (obj instanceof ArrayList) {
                            ArrayList arrayList2 = (ArrayList) obj;
                            int size2 = arrayList2.size();
                            for (int i11 = 0; i11 < size2; i11++) {
                                Object obj3 = arrayList2.get(i11);
                                if (!(obj3 instanceof Bundle)) {
                                    zzgr zzh = this.zzu.zzaV().zzh();
                                    if (obj3 != null) {
                                        obj2 = obj3.getClass();
                                    } else {
                                        obj2 = Constants.NULL_VERSION_ID;
                                    }
                                    zzh.zzc("All ArrayList elements must be of type Bundle. Value type, name", obj2, str3);
                                    return 4;
                                }
                                zzz(str, str2, str3, (Bundle) obj3, list, z10);
                            }
                        } else {
                            return 4;
                        }
                        return i10;
                    }
                    return 4;
                }
            } else {
                return 21;
            }
        }
        i10 = 0;
        if (zzZ(str2)) {
        }
        zzf = this.zzu.zzc().zzf(null, false);
        if (!zzu("param", str3, zzf, obj)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object zzE(String str, Object obj) {
        int zze;
        if ("_ev".equals(str)) {
            return zzay(this.zzu.zzc().zzf(null, false), obj, true, true, null);
        }
        if (zzZ(str)) {
            zze = this.zzu.zzc().zzf(null, false);
        } else {
            zze = this.zzu.zzc().zze(null, false);
        }
        return zzay(zze, obj, false, true, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zzF(String str, String str2, Bundle bundle, List list, boolean z10) {
        int i10;
        int i11;
        zzib zzibVar;
        String str3;
        String str4;
        List list2 = list;
        boolean zzaA = zzaA(str2, zzjl.zzd);
        if (bundle != null) {
            Bundle bundle2 = new Bundle(bundle);
            zzib zzibVar2 = this.zzu;
            int zzc2 = zzibVar2.zzc().zzc();
            int i12 = 0;
            boolean z11 = false;
            for (String str5 : new TreeSet(bundle.keySet())) {
                if (list2 != null && list2.contains(str5)) {
                    i10 = 0;
                } else {
                    if (!z10) {
                        i10 = zzq(str5);
                    } else {
                        i10 = 0;
                    }
                    if (i10 == 0) {
                        i10 = zzs(str5);
                    }
                }
                if (i10 != 0) {
                    if (i10 == 3) {
                        str4 = str5;
                    } else {
                        str4 = null;
                    }
                    zzJ(bundle2, i10, str5, str4);
                    bundle2.remove(str5);
                    i11 = zzc2;
                    zzibVar = zzibVar2;
                } else {
                    i11 = zzc2;
                    zzibVar = zzibVar2;
                    int zzD = zzD(str, str2, str5, bundle.get(str5), bundle2, list, z10, zzaA);
                    if (zzD == 17) {
                        zzJ(bundle2, 17, str5, Boolean.FALSE);
                    } else if (zzD != 0 && !"_ev".equals(str5)) {
                        if (zzD == 21) {
                            str3 = str2;
                        } else {
                            str3 = str5;
                        }
                        zzJ(bundle2, zzD, str3, bundle.get(str5));
                        bundle2.remove(str5);
                    }
                    if (zzh(str5)) {
                        int i13 = i12 + 1;
                        if (i13 > i11) {
                            if (!zzibVar.zzc().zzp(null, zzfx.zzbf) || !z11) {
                                StringBuilder sb = new StringBuilder(String.valueOf(i11).length() + 37);
                                sb.append("Event can't contain more than ");
                                sb.append(i11);
                                sb.append(" params");
                                zzibVar.zzaV().zzd().zzc(sb.toString(), zzibVar.zzl().zza(str2), zzibVar.zzl().zze(bundle));
                            }
                            zzax(bundle2, 5);
                            bundle2.remove(str5);
                            z11 = true;
                        }
                        i12 = i13;
                        zzc2 = i11;
                        zzibVar2 = zzibVar;
                        list2 = list;
                    }
                }
                zzc2 = i11;
                zzibVar2 = zzibVar;
                list2 = list;
            }
            return bundle2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzG(zzgu zzguVar, int i10) {
        Bundle bundle = zzguVar.zzd;
        int i11 = 0;
        boolean z10 = false;
        for (String str : new TreeSet(bundle.keySet())) {
            if (zzh(str) && (i11 = i11 + 1) > i10) {
                zzib zzibVar = this.zzu;
                if (!zzibVar.zzc().zzp(null, zzfx.zzbf) || !z10) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 37);
                    sb.append("Event can't contain more than ");
                    sb.append(i10);
                    sb.append(" params");
                    zzibVar.zzaV().zzd().zzc(sb.toString(), zzibVar.zzl().zza(zzguVar.zza), zzibVar.zzl().zze(bundle));
                    zzax(bundle, 5);
                }
                bundle.remove(str);
                z10 = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzH(Parcelable[] parcelableArr, int i10) {
        Preconditions.checkNotNull(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            int i11 = 0;
            boolean z10 = false;
            for (String str : new TreeSet(bundle.keySet())) {
                if (zzh(str) && !zzaA(str, zzjm.zzd) && (i11 = i11 + 1) > i10) {
                    zzib zzibVar = this.zzu;
                    if (!zzibVar.zzc().zzp(null, zzfx.zzbf) || !z10) {
                        zzgr zzd = zzibVar.zzaV().zzd();
                        StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 60);
                        sb.append("Param can't contain more than ");
                        sb.append(i10);
                        sb.append(" item-scoped custom parameters");
                        zzd.zzc(sb.toString(), zzibVar.zzl().zzb(str), zzibVar.zzl().zze(bundle));
                    }
                    zzax(bundle, 28);
                    bundle.remove(str);
                    z10 = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzI(Bundle bundle, Bundle bundle2) {
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                if (!bundle.containsKey(str)) {
                    this.zzu.zzk().zzM(bundle, str, bundle2.get(str));
                }
            }
        }
    }

    final void zzJ(Bundle bundle, int i10, String str, Object obj) {
        if (zzax(bundle, i10)) {
            this.zzu.zzc();
            bundle.putString("_ev", zzC(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzK(String str, Object obj) {
        boolean zzu;
        if ("_ldl".equals(str)) {
            zzu = zzu("user property referrer", str, zzaz(str), obj);
        } else {
            zzu = zzu("user property", str, zzaz(str), obj);
        }
        if (zzu) {
            return 0;
        }
        return 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object zzL(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return zzay(zzaz(str), obj, true, false, null);
        }
        return zzay(zzaz(str), obj, false, false, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzM(Bundle bundle, String str, Object obj) {
        String str2;
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
                return;
            }
            if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
                return;
            }
            if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
                return;
            }
            if (obj instanceof Bundle[]) {
                bundle.putParcelableArray(str, (Bundle[]) obj);
                return;
            }
            if (str != null) {
                if (obj != null) {
                    str2 = obj.getClass().getSimpleName();
                } else {
                    str2 = null;
                }
                zzib zzibVar = this.zzu;
                zzibVar.zzaV().zzh().zzc("Not putting event parameter. Invalid value type. name, type", zzibVar.zzl().zzb(str), str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzN(zzpn zzpnVar, String str, int i10, String str2, String str3, int i11) {
        Bundle bundle = new Bundle();
        zzax(bundle, i10);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i10 == 6 || i10 == 7 || i10 == 2) {
            bundle.putLong("_el", i11);
        }
        zzpnVar.zza(str, "_err", bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzS() {
        zzg();
        if (zzV() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MeasurementManagerFutures zzT() {
        if (this.zzg == null) {
            this.zzg = MeasurementManagerFutures.from(this.zzu.zzaY());
        }
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzU() {
        int extensionVersion;
        int extensionVersion2;
        if (Build.VERSION.SDK_INT >= 30) {
            extensionVersion = SdkExtensions.getExtensionVersion(30);
            if (extensionVersion > 3) {
                extensionVersion2 = SdkExtensions.getExtensionVersion(1000000);
                return extensionVersion2;
            }
            return 0;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzV() {
        int extensionVersion;
        long j10;
        zzg();
        if (!zzX(this.zzu.zzv().zzj())) {
            return 0L;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            extensionVersion = SdkExtensions.getExtensionVersion(30);
            if (extensionVersion < 4) {
                j10 = 8;
            } else {
                zzib zzibVar = this.zzu;
                int zzU = zzU();
                zzibVar.zzc();
                if (zzU < ((Integer) zzfx.zzal.zzb(null)).intValue()) {
                    j10 = 16;
                } else {
                    j10 = 0;
                }
            }
        } else {
            j10 = 4;
        }
        if (!zzY("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")) {
            j10 |= 2;
        }
        if (j10 == 0 && !zzW()) {
            j10 = 64;
        }
        if (j10 == 0) {
            return 1L;
        }
        return j10;
    }

    @TargetApi(30)
    final boolean zzW() {
        Object e10;
        Integer num;
        if (this.zzh == null) {
            MeasurementManagerFutures zzT = zzT();
            boolean z10 = false;
            if (zzT == null) {
                return false;
            }
            try {
                num = (Integer) zzT.getMeasurementApiStatusAsync().get(BaseServer.TIMEOUT_DEBUG, TimeUnit.MILLISECONDS);
                if (num != null) {
                    try {
                        if (num.intValue() == 1) {
                            z10 = true;
                        }
                    } catch (InterruptedException e11) {
                        e10 = e11;
                        this.zzu.zzaV().zze().zzb("Measurement manager api exception", e10);
                        this.zzh = Boolean.FALSE;
                        this.zzu.zzaV().zzk().zzb("Measurement manager api status result", num);
                        return this.zzh.booleanValue();
                    } catch (CancellationException e12) {
                        e10 = e12;
                        this.zzu.zzaV().zze().zzb("Measurement manager api exception", e10);
                        this.zzh = Boolean.FALSE;
                        this.zzu.zzaV().zzk().zzb("Measurement manager api status result", num);
                        return this.zzh.booleanValue();
                    } catch (ExecutionException e13) {
                        e10 = e13;
                        this.zzu.zzaV().zze().zzb("Measurement manager api exception", e10);
                        this.zzh = Boolean.FALSE;
                        this.zzu.zzaV().zzk().zzb("Measurement manager api status result", num);
                        return this.zzh.booleanValue();
                    } catch (TimeoutException e14) {
                        e10 = e14;
                        this.zzu.zzaV().zze().zzb("Measurement manager api exception", e10);
                        this.zzh = Boolean.FALSE;
                        this.zzu.zzaV().zzk().zzb("Measurement manager api status result", num);
                        return this.zzh.booleanValue();
                    }
                }
                this.zzh = Boolean.valueOf(z10);
            } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException e15) {
                e10 = e15;
                num = null;
            }
            this.zzu.zzaV().zzk().zzb("Measurement manager api status result", num);
        }
        return this.zzh.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzX(String str) {
        String str2 = (String) zzfx.zzar.zzb(null);
        if (!str2.equals("*") && !Arrays.asList(str2.split(",")).contains(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzY(String str) {
        zzg();
        zzib zzibVar = this.zzu;
        if (Wrappers.packageManager(zzibVar.zzaY()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzibVar.zzaV().zzj().zzb("Permission not granted", str);
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzje
    protected final boolean zza() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzaa(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        zzib zzibVar = this.zzu;
        String zzA = zzibVar.zzc().zzA();
        zzibVar.zzaU();
        return zzA.equals(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zzab(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                Object zzE = zzE(str2, bundle.get(str2));
                if (zzE == null) {
                    zzib zzibVar = this.zzu;
                    zzibVar.zzaV().zzh().zzb("Param value can't be null", zzibVar.zzl().zzb(str2));
                } else {
                    zzM(bundle2, str2, zzE);
                }
            }
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbg zzac(String str, String str2, Bundle bundle, String str3, long j10, boolean z10, boolean z11) {
        Bundle bundle2;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zzn(str2) == 0) {
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            Bundle bundle3 = bundle2;
            bundle3.putString("_o", str3);
            Bundle zzF = zzF(str, str2, bundle3, CollectionUtils.listOf("_o"), true);
            if (z10) {
                zzF = zzab(zzF, str);
            }
            Preconditions.checkNotNull(zzF);
            return new zzbg(str2, new zzbe(zzF), str3, j10);
        }
        zzib zzibVar = this.zzu;
        zzibVar.zzaV().zzb().zzb("Invalid conditional property event name", zzibVar.zzl().zzc(str2));
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final boolean zzad(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
            }
            return true;
        } catch (PackageManager.NameNotFoundException e10) {
            this.zzu.zzaV().zzb().zzb("Package name not found", e10);
            return true;
        } catch (CertificateException e11) {
            this.zzu.zzaV().zzb().zzb("Error obtaining certificate", e11);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] zzae(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public final boolean zzag(int i10, boolean z10) {
        Boolean zzJ = this.zzu.zzt().zzJ();
        if (zzah() >= i10 / 1000) {
            return true;
        }
        if (zzJ != null && !zzJ.booleanValue()) {
            return true;
        }
        return false;
    }

    public final int zzah() {
        if (this.zzi == null) {
            this.zzi = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzu.zzaY()) / 1000);
        }
        return this.zzi.intValue();
    }

    public final int zzai(int i10) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(this.zzu.zzaY(), GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public final long zzaj(long j10, long j11) {
        return (j10 + (j11 * 60000)) / 86400000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzak(Bundle bundle, long j10) {
        long j11 = bundle.getLong("_et");
        if (j11 != 0) {
            this.zzu.zzaV().zze().zzb("Params already contained engagement", Long.valueOf(j11));
        } else {
            j11 = 0;
        }
        bundle.putLong("_et", j10 + j11);
    }

    public final void zzal(com.google.android.gms.internal.measurement.zzcu zzcuVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e10) {
            this.zzu.zzaV().zze().zzb("Error returning string value to wrapper", e10);
        }
    }

    public final void zzam(com.google.android.gms.internal.measurement.zzcu zzcuVar, long j10) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j10);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e10) {
            this.zzu.zzaV().zze().zzb("Error returning long value to wrapper", e10);
        }
    }

    public final void zzan(com.google.android.gms.internal.measurement.zzcu zzcuVar, int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i10);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e10) {
            this.zzu.zzaV().zze().zzb("Error returning int value to wrapper", e10);
        }
    }

    public final void zzao(com.google.android.gms.internal.measurement.zzcu zzcuVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e10) {
            this.zzu.zzaV().zze().zzb("Error returning byte array to wrapper", e10);
        }
    }

    public final void zzap(com.google.android.gms.internal.measurement.zzcu zzcuVar, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z10);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e10) {
            this.zzu.zzaV().zze().zzb("Error returning boolean value to wrapper", e10);
        }
    }

    public final void zzaq(com.google.android.gms.internal.measurement.zzcu zzcuVar, Bundle bundle) {
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e10) {
            this.zzu.zzaV().zze().zzb("Error returning bundle value to wrapper", e10);
        }
    }

    public final void zzar(com.google.android.gms.internal.measurement.zzcu zzcuVar, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e10) {
            this.zzu.zzaV().zze().zzb("Error returning bundle list to wrapper", e10);
        }
    }

    public final URL zzat(long j10, String str, String str2, long j11, String str3) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", 130000L, Integer.valueOf(zzah())), str2, str, Long.valueOf(j11));
            if (str.equals(this.zzu.zzc().zzB())) {
                format = format.concat("&ddl_test=1");
            }
            if (!str3.isEmpty()) {
                if (str3.charAt(0) != '&') {
                    format = format.concat(DispatchConstants.SIGN_SPLIT_SYMBOL);
                }
                format = format.concat(str3);
            }
            return new URL(format);
        } catch (IllegalArgumentException e10) {
            e = e10;
            this.zzu.zzaV().zzb().zzb("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        } catch (MalformedURLException e11) {
            e = e11;
            this.zzu.zzaV().zzb().zzb("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzaw() {
        byte[] bArr = new byte[16];
        zzf().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    @Override // com.google.android.gms.measurement.internal.zzje
    protected final void zzba() {
        zzg();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                this.zzu.zzaV().zze().zza("Utils falling back to Random for random id");
            }
        }
        this.zze.set(nextLong);
    }

    public final long zzd() {
        long andIncrement;
        long j10;
        AtomicLong atomicLong = this.zze;
        if (atomicLong.get() == 0) {
            synchronized (atomicLong) {
                long nextLong = new Random(System.nanoTime() ^ this.zzu.zzaZ().currentTimeMillis()).nextLong();
                int i10 = this.zzf + 1;
                this.zzf = i10;
                j10 = nextLong + i10;
            }
            return j10;
        }
        AtomicLong atomicLong2 = this.zze;
        synchronized (atomicLong2) {
            atomicLong2.compareAndSet(-1L, 1L);
            andIncrement = atomicLong2.getAndIncrement();
        }
        return andIncrement;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SecureRandom zzf() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new SecureRandom();
        }
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zzi(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str = uri.getQueryParameter("utm_campaign");
                str2 = uri.getQueryParameter("utm_source");
                str3 = uri.getQueryParameter("utm_medium");
                str4 = uri.getQueryParameter("gclid");
                str5 = uri.getQueryParameter("gbraid");
                str6 = uri.getQueryParameter("utm_id");
                str7 = uri.getQueryParameter("dclid");
                str8 = uri.getQueryParameter("srsltid");
                str9 = uri.getQueryParameter("sfmc_id");
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
                str7 = null;
                str8 = null;
                str9 = null;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str7) && TextUtils.isEmpty(str8) && TextUtils.isEmpty(str9)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                str10 = "sfmc_id";
                bundle.putString("campaign", str);
            } else {
                str10 = "sfmc_id";
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("source", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("medium", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("gclid", str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                bundle.putString("gbraid", str5);
            }
            String queryParameter = uri.getQueryParameter("gad_source");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("gad_source", queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter(DynamicLink.GoogleAnalyticsParameters.KEY_UTM_TERM);
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter(DynamicLink.GoogleAnalyticsParameters.KEY_UTM_CONTENT);
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("content", queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter(FirebaseAnalytics.Param.ACLID);
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter(FirebaseAnalytics.Param.CP1);
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter5);
            }
            String queryParameter6 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("anid", queryParameter6);
            }
            if (!TextUtils.isEmpty(str6)) {
                bundle.putString(FirebaseAnalytics.Param.CAMPAIGN_ID, str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                bundle.putString("dclid", str7);
            }
            String queryParameter7 = uri.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString(FirebaseAnalytics.Param.SOURCE_PLATFORM, queryParameter7);
            }
            String queryParameter8 = uri.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString(FirebaseAnalytics.Param.CREATIVE_FORMAT, queryParameter8);
            }
            String queryParameter9 = uri.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString(FirebaseAnalytics.Param.MARKETING_TACTIC, queryParameter9);
            }
            if (!TextUtils.isEmpty(str8)) {
                bundle.putString("srsltid", str8);
            }
            if (!TextUtils.isEmpty(str9)) {
                bundle.putString(str10, str9);
            }
            for (String str11 : uri.getQueryParameterNames()) {
                if (str11.startsWith("gad_")) {
                    String queryParameter10 = uri.getQueryParameter(str11);
                    if (!TextUtils.isEmpty(queryParameter10)) {
                        bundle.putString(str11, queryParameter10);
                    }
                }
            }
            return bundle;
        } catch (UnsupportedOperationException e10) {
            this.zzu.zzaV().zze().zzb("Install referrer url isn't a hierarchical URI", e10);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzj(String str, String str2) {
        if (str2 == null) {
            this.zzu.zzaV().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.zzu.zzaV().zzd().zzb("Name is required and can't be empty. Type", str);
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt)) {
            this.zzu.zzaV().zzd().zzc("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                this.zzu.zzaV().zzd().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzk(String str, String str2) {
        if (str2 == null) {
            this.zzu.zzaV().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.zzu.zzaV().zzd().zzb("Name is required and can't be empty. Type", str);
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt)) {
            if (codePointAt == 95) {
                codePointAt = 95;
            } else {
                this.zzu.zzaV().zzd().zzc("Name must start with a letter or _ (underscore). Type, name", str, str2);
                return false;
            }
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                this.zzu.zzaV().zzd().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzl(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.zzu.zzaV().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = zzb;
        for (int i10 = 0; i10 < 3; i10++) {
            if (str2.startsWith(strArr3[i10])) {
                this.zzu.zzaV().zzd().zzc("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr != null && zzaA(str2, strArr)) {
            if (strArr2 == null || !zzaA(str2, strArr2)) {
                this.zzu.zzaV().zzd().zzc("Name is reserved. Type, name", str, str2);
                return false;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzm(String str, int i10, String str2) {
        if (str2 == null) {
            this.zzu.zzaV().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) > i10) {
            this.zzu.zzaV().zzd().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i10), str2);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzn(String str) {
        if (!zzk("event", str)) {
            return 2;
        }
        if (!zzl("event", zzjl.zza, zzjl.zzb, str)) {
            return 13;
        }
        this.zzu.zzc();
        if (!zzm("event", 40, str)) {
            return 2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzp(String str) {
        if (!zzk("user property", str)) {
            return 6;
        }
        if (!zzl("user property", zzjn.zza, null, str)) {
            return 15;
        }
        this.zzu.zzc();
        if (!zzm("user property", 24, str)) {
            return 6;
        }
        return 0;
    }

    final int zzq(String str) {
        if (!zzj("event param", str)) {
            return 3;
        }
        if (!zzl("event param", null, null, str)) {
            return 14;
        }
        this.zzu.zzc();
        if (!zzm("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    final int zzs(String str) {
        if (!zzk("event param", str)) {
            return 3;
        }
        if (!zzl("event param", null, null, str)) {
            return 14;
        }
        this.zzu.zzc();
        if (!zzm("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzt(Object obj) {
        if (!(obj instanceof Parcelable[]) && !(obj instanceof ArrayList) && !(obj instanceof Bundle)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzu(String str, String str2, int i10, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String obj2 = obj.toString();
            if (obj2.codePointCount(0, obj2.length()) > i10) {
                this.zzu.zzaV().zzh().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(obj2.length()));
                return false;
            }
        }
        return true;
    }

    final void zzz(String str, String str2, String str3, Bundle bundle, List list, boolean z10) {
        int i10;
        int i11;
        int i12;
        String str4;
        int i13;
        int zzD;
        if (bundle != null) {
            zzib zzibVar = this.zzu;
            if (true != zzibVar.zzc().zzu.zzk().zzag(231100000, true)) {
                i10 = 0;
            } else {
                i10 = 35;
            }
            int i14 = 0;
            boolean z11 = false;
            for (String str5 : new TreeSet(bundle.keySet())) {
                if (list != null && list.contains(str5)) {
                    i11 = 0;
                } else {
                    if (!z10) {
                        i11 = zzq(str5);
                    } else {
                        i11 = 0;
                    }
                    if (i11 == 0) {
                        i11 = zzs(str5);
                    }
                }
                String str6 = null;
                if (i11 != 0) {
                    if (i11 == 3) {
                        str6 = str5;
                    }
                    zzJ(bundle, i11, str5, str6);
                    bundle.remove(str5);
                    i12 = i10;
                } else {
                    if (zzt(bundle.get(str5))) {
                        zzibVar.zzaV().zzh().zzd("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str5);
                        zzD = 22;
                        str4 = str5;
                        i13 = i10;
                    } else {
                        str4 = str5;
                        i13 = i10;
                        zzD = zzD(str, str2, str5, bundle.get(str5), bundle, list, z10, false);
                    }
                    if (zzD != 0 && !"_ev".equals(str4)) {
                        zzJ(bundle, zzD, str4, bundle.get(str4));
                        bundle.remove(str4);
                    } else if (zzh(str4) && !zzaA(str4, zzjm.zzd)) {
                        int i15 = i14 + 1;
                        if (!zzag(231100000, true)) {
                            zzibVar.zzaV().zzd().zzc("Item array not supported on client's version of Google Play Services (Android Only)", zzibVar.zzl().zza(str2), zzibVar.zzl().zze(bundle));
                            zzax(bundle, 23);
                            bundle.remove(str4);
                            i12 = i13;
                        } else {
                            i12 = i13;
                            if (i15 > i12) {
                                if (!zzibVar.zzc().zzp(null, zzfx.zzbf) || !z11) {
                                    zzgr zzd = zzibVar.zzaV().zzd();
                                    StringBuilder sb = new StringBuilder(String.valueOf(i12).length() + 55);
                                    sb.append("Item can't contain more than ");
                                    sb.append(i12);
                                    sb.append(" item-scoped custom params");
                                    zzd.zzc(sb.toString(), zzibVar.zzl().zza(str2), zzibVar.zzl().zze(bundle));
                                }
                                zzax(bundle, 28);
                                bundle.remove(str4);
                                i14 = i15;
                                i10 = i12;
                                z11 = true;
                            }
                        }
                        i14 = i15;
                        i10 = i12;
                    }
                    i12 = i13;
                }
                i10 = i12;
            }
        }
    }
}
