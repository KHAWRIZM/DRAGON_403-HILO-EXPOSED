package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.common.internal.Preconditions;
import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzat {
    final /* synthetic */ zzav zza;
    private final String zzb;
    private long zzc;

    public zzat(zzav zzavVar, String str) {
        Objects.requireNonNull(zzavVar);
        this.zza = zzavVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d5 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zza() {
        boolean z10;
        List arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = this.zza.zze().query("raw_events", new String[]{"rowid", "name", HeaderInterceptor.TIMESTAMP, "metadata_fingerprint", "data", "realtime"}, "app_id = ? and rowid > ?", new String[]{this.zzb, String.valueOf(this.zzc)}, null, null, "rowid", "1000");
            } catch (SQLiteException e10) {
                this.zza.zzu.zzaV().zzb().zzc("Data loss. Error querying raw events batch. appId", zzgt.zzl(this.zzb), e10);
            }
            if (!cursor.moveToFirst()) {
                arrayList = Collections.emptyList();
                return arrayList;
            }
            do {
                long j10 = cursor.getLong(0);
                long j11 = cursor.getLong(3);
                if (cursor.getLong(5) == 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                byte[] blob = cursor.getBlob(4);
                if (j10 > this.zzc) {
                    this.zzc = j10;
                }
                try {
                    com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzpj.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), blob);
                    String string = cursor.getString(1);
                    if (string == null) {
                        string = "";
                    }
                    zzhrVar.zzl(string);
                    zzhrVar.zzo(cursor.getLong(2));
                    arrayList.add(new zzas(j10, j11, z10, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc()));
                } catch (IOException e11) {
                    this.zza.zzu.zzaV().zzb().zzc("Data loss. Failed to merge raw event. appId", zzgt.zzl(this.zzb), e11);
                }
            } while (cursor.moveToNext());
            return arrayList;
        } finally {
            if (0 != 0) {
                cursor.close();
            }
        }
    }

    public zzat(zzav zzavVar, String str, long j10) {
        Objects.requireNonNull(zzavVar);
        this.zza = zzavVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = zzavVar.zzaj("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j10)}, -1L);
    }
}
