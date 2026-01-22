package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzgt extends zzje {
    private char zza;
    private long zzb;

    @GuardedBy("this")
    private String zzc;
    private final zzgr zzd;
    private final zzgr zze;
    private final zzgr zzf;
    private final zzgr zzg;
    private final zzgr zzh;
    private final zzgr zzi;
    private final zzgr zzj;
    private final zzgr zzk;
    private final zzgr zzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgt(zzib zzibVar) {
        super(zzibVar);
        this.zza = (char) 0;
        this.zzb = -1L;
        this.zzd = new zzgr(this, 6, false, false);
        this.zze = new zzgr(this, 6, true, false);
        this.zzf = new zzgr(this, 6, false, true);
        this.zzg = new zzgr(this, 5, false, false);
        this.zzh = new zzgr(this, 5, true, false);
        this.zzi = new zzgr(this, 5, false, true);
        this.zzj = new zzgr(this, 4, false, false);
        this.zzk = new zzgr(this, 3, false, false);
        this.zzl = new zzgr(this, 2, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zzl(String str) {
        if (str == null) {
            return null;
        }
        return new zzgs(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzo(boolean z10, String str, Object obj, Object obj2, Object obj3) {
        String zzp = zzp(z10, obj);
        String zzp2 = zzp(z10, obj2);
        String zzp3 = zzp(z10, obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(zzp)) {
            sb.append(str2);
            sb.append(zzp);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzp2)) {
            sb.append(str2);
            sb.append(zzp2);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(zzp3)) {
            sb.append(str3);
            sb.append(zzp3);
        }
        return sb.toString();
    }

    @VisibleForTesting
    static String zzp(boolean z10, Object obj) {
        String th;
        String className;
        String str = "";
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i10 = 0;
        if (obj instanceof Long) {
            if (!z10) {
                return obj.toString();
            }
            Long l10 = (Long) obj;
            if (Math.abs(l10.longValue()) < 100) {
                return obj.toString();
            }
            char charAt = obj.toString().charAt(0);
            String valueOf = String.valueOf(Math.abs(l10.longValue()));
            long round = Math.round(Math.pow(10.0d, valueOf.length() - 1));
            long round2 = Math.round(Math.pow(10.0d, valueOf.length()) - 1.0d);
            int length = String.valueOf(round).length();
            if (charAt == '-') {
                str = "-";
            }
            StringBuilder sb = new StringBuilder(str.length() + length + 3 + str.length() + String.valueOf(round2).length());
            sb.append(str);
            sb.append(round);
            sb.append("...");
            sb.append(str);
            sb.append(round2);
            return sb.toString();
        }
        if (obj instanceof Boolean) {
            return obj.toString();
        }
        if (obj instanceof Throwable) {
            Throwable th2 = (Throwable) obj;
            if (z10) {
                th = th2.getClass().getName();
            } else {
                th = th2.toString();
            }
            StringBuilder sb2 = new StringBuilder(th);
            String zzq = zzq(zzib.class.getCanonicalName());
            StackTraceElement[] stackTrace = th2.getStackTrace();
            int length2 = stackTrace.length;
            while (true) {
                if (i10 >= length2) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i10];
                if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && zzq(className).equals(zzq)) {
                    sb2.append(": ");
                    sb2.append(stackTraceElement);
                    break;
                }
                i10++;
            }
            return sb2.toString();
        }
        if (obj instanceof zzgs) {
            return ((zzgs) obj).zza();
        }
        if (z10) {
            return "-";
        }
        return obj.toString();
    }

    @VisibleForTesting
    static String zzq(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(46)) == -1) {
            return "";
        }
        return str.substring(0, lastIndexOf);
    }

    @Override // com.google.android.gms.measurement.internal.zzje
    protected final boolean zza() {
        return false;
    }

    public final zzgr zzb() {
        return this.zzd;
    }

    public final zzgr zzc() {
        return this.zze;
    }

    public final zzgr zzd() {
        return this.zzf;
    }

    public final zzgr zze() {
        return this.zzg;
    }

    public final zzgr zzf() {
        return this.zzh;
    }

    public final zzgr zzh() {
        return this.zzi;
    }

    public final zzgr zzi() {
        return this.zzj;
    }

    public final zzgr zzj() {
        return this.zzk;
    }

    public final zzgr zzk() {
        return this.zzl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzm(int i10, boolean z10, boolean z11, String str, Object obj, Object obj2, Object obj3) {
        int i11;
        if (!z10 && Log.isLoggable(zzn(), i10)) {
            Log.println(i10, zzn(), zzo(false, str, obj, obj2, obj3));
        }
        if (!z11 && i10 >= 5) {
            Preconditions.checkNotNull(str);
            zzhy zzi = this.zzu.zzi();
            if (zzi == null) {
                Log.println(6, zzn(), "Scheduler not set. Not logging error/warn");
                return;
            }
            if (!zzi.zzv()) {
                Log.println(6, zzn(), "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i10 >= 9) {
                i11 = 8;
            } else {
                i11 = i10;
            }
            zzi.zzj(new zzgq(this, i11, str, obj, obj2, obj3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public final String zzn() {
        String str;
        synchronized (this) {
            try {
                if (this.zzc == null) {
                    this.zzc = this.zzu.zzc().zzb();
                }
                Preconditions.checkNotNull(this.zzc);
                str = this.zzc;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ char zzr() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzs(char c10) {
        this.zza = c10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ long zzt() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzu(long j10) {
        this.zzb = 130000L;
    }
}
