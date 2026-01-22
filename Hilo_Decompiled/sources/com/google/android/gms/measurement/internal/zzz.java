package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzz {
    final /* synthetic */ zzad zza;
    private com.google.android.gms.internal.measurement.zzhs zzb;
    private Long zzc;
    private long zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzz(zzad zzadVar, byte[] bArr) {
        Objects.requireNonNull(zzadVar);
        this.zza = zzadVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00f1, code lost:
    
        if (r4 == null) goto L٢٢;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01d4  */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.google.android.gms.internal.measurement.zzhs zza(String str, com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        Cursor cursor;
        Pair pair;
        Object obj;
        String zzd = zzhsVar.zzd();
        List zza = zzhsVar.zza();
        zzad zzadVar = this.zza;
        zzpf zzpfVar = zzadVar.zzg;
        zzpfVar.zzp();
        Long l10 = (Long) zzpj.zzI(zzhsVar, "_eid");
        if (l10 != null) {
            if (zzd.equals("_ep")) {
                Preconditions.checkNotNull(l10);
                zzpfVar.zzp();
                String str2 = (String) zzpj.zzI(zzhsVar, "_en");
                ?? r72 = 0;
                if (TextUtils.isEmpty(str2)) {
                    zzadVar.zzu.zzaV().zzc().zzb("Extra parameter without an event name. eventId", l10);
                    return null;
                }
                if (this.zzb == null || this.zzc == null || l10.longValue() != this.zzc.longValue()) {
                    zzav zzj = zzpfVar.zzj();
                    zzj.zzg();
                    zzj.zzay();
                    try {
                        try {
                            cursor = zzj.zze().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, l10.toString()});
                            try {
                            } catch (SQLiteException e10) {
                                e = e10;
                                zzj.zzu.zzaV().zzb().zzb("Error selecting main event", e);
                            }
                        } catch (Throwable th) {
                            th = th;
                            r72 = zzpfVar;
                            if (r72 != 0) {
                                r72.close();
                            }
                            throw th;
                        }
                    } catch (SQLiteException e11) {
                        e = e11;
                        cursor = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (r72 != 0) {
                        }
                        throw th;
                    }
                    if (!cursor.moveToFirst()) {
                        zzj.zzu.zzaV().zzk().zza("Main event not found");
                    } else {
                        try {
                            pair = Pair.create((com.google.android.gms.internal.measurement.zzhs) ((com.google.android.gms.internal.measurement.zzhr) zzpj.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), cursor.getBlob(0))).zzbc(), Long.valueOf(cursor.getLong(1)));
                            cursor.close();
                        } catch (IOException e12) {
                            zzj.zzu.zzaV().zzb().zzd("Failed to merge main event. appId, eventId", zzgt.zzl(str), l10, e12);
                        }
                        if (pair == null && (obj = pair.first) != null) {
                            this.zzb = (com.google.android.gms.internal.measurement.zzhs) obj;
                            this.zzd = ((Long) pair.second).longValue();
                            this.zza.zzg.zzp();
                            this.zzc = (Long) zzpj.zzI(this.zzb, "_eid");
                        } else {
                            this.zza.zzu.zzaV().zzc().zzc("Extra parameter without existing main event. eventName, eventId", str2, l10);
                            return null;
                        }
                    }
                    cursor.close();
                    pair = null;
                    if (pair == null) {
                    }
                    this.zza.zzu.zzaV().zzc().zzc("Extra parameter without existing main event. eventName, eventId", str2, l10);
                    return null;
                }
                long j10 = this.zzd - 1;
                this.zzd = j10;
                if (j10 <= 0) {
                    zzav zzj2 = this.zza.zzg.zzj();
                    zzj2.zzg();
                    zzj2.zzu.zzaV().zzk().zzb("Clearing complex main event info. appId", str);
                    try {
                        zzj2.zze().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                    } catch (SQLiteException e13) {
                        zzj2.zzu.zzaV().zzb().zzb("Error clearing complex main event", e13);
                    }
                } else {
                    this.zza.zzg.zzj().zzV(str, l10, this.zzd, this.zzb);
                }
                ArrayList arrayList = new ArrayList();
                for (com.google.android.gms.internal.measurement.zzhw zzhwVar : this.zzb.zza()) {
                    this.zza.zzg.zzp();
                    if (zzpj.zzF(zzhsVar, zzhwVar.zzb()) == null) {
                        arrayList.add(zzhwVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    arrayList.addAll(zza);
                    zza = arrayList;
                } else {
                    this.zza.zzu.zzaV().zzc().zzb("No unique parameters in main event. eventName", str2);
                }
                zzd = str2;
            } else {
                this.zzc = l10;
                this.zzb = zzhsVar;
                zzpfVar.zzp();
                long longValue = ((Long) zzpj.zzJ(zzhsVar, "_epc", 0L)).longValue();
                this.zzd = longValue;
                if (longValue <= 0) {
                    zzadVar.zzu.zzaV().zzc().zzb("Complex event with zero extra param count. eventName", zzd);
                } else {
                    zzpfVar.zzj().zzV(str, (Long) Preconditions.checkNotNull(l10), this.zzd, zzhsVar);
                }
            }
        }
        com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzhsVar.zzcl();
        zzhrVar.zzl(zzd);
        zzhrVar.zzi();
        zzhrVar.zzh(zza);
        return (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc();
    }
}
