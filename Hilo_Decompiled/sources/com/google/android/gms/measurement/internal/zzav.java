package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.alibaba.sdk.android.tbrest.rest.RestUrlWrapper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzql;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import io.agora.rtc.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzav extends zzor {
    private final zzau zzm;
    private final zzof zzn;
    private static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    static final String[] zza = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;", "last_upload_timestamp", "ALTER TABLE upload_queue ADD COLUMN last_upload_timestamp INTEGER;"};
    private static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzd = {RestUrlWrapper.FIELD_APPVERSION, "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;", "gmp_version_for_remote_config", "ALTER TABLE apps ADD COLUMN gmp_version_for_remote_config INTEGER;"};
    private static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzj = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private static final String[] zzk = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    private static final String[] zzl = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzav(zzpf zzpfVar) {
        super(zzpfVar);
        this.zzn = new zzof(this.zzu.zzaZ());
        this.zzu.zzc();
        this.zzm = new zzau(this, this.zzu.zzaY(), "google_app_measurement.db");
    }

    private final long zzaA(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = zze().rawQuery(str, strArr);
                if (rawQuery.moveToFirst()) {
                    long j10 = rawQuery.getLong(0);
                    rawQuery.close();
                    return j10;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e10) {
                this.zzu.zzaV().zzb().zzc("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zzaB(String str, String[] strArr, long j10) {
        Cursor cursor = null;
        try {
            try {
                cursor = zze().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    j10 = cursor.getLong(0);
                }
                cursor.close();
                return j10;
            } catch (SQLiteException e10) {
                this.zzu.zzaV().zzb().zzc("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final String zzaC(String str, String[] strArr, String str2) {
        Cursor cursor = null;
        try {
            try {
                cursor = zze().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    String string = cursor.getString(0);
                    cursor.close();
                    return string;
                }
                cursor.close();
                return "";
            } catch (SQLiteException e10) {
                this.zzu.zzaV().zzb().zzc("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final void zzaD(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase zze2 = zze();
            if (contentValues.getAsString("app_id") == null) {
                this.zzu.zzaV().zzd().zzb("Value of the primary key is not set.", zzgt.zzl("app_id"));
                return;
            }
            StringBuilder sb = new StringBuilder(10);
            sb.append("app_id");
            sb.append(" = ?");
            if (zze2.update("consent_settings", contentValues, sb.toString(), new String[]{r2}) == 0 && zze2.insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                this.zzu.zzaV().zzb().zzc("Failed to insert/update table (got -1). key", zzgt.zzl("consent_settings"), zzgt.zzl("app_id"));
            }
        } catch (SQLiteException e10) {
            this.zzu.zzaV().zzb().zzd("Error storing into table. key", zzgt.zzl("consent_settings"), zzgt.zzl("app_id"), e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final zzbc zzaE(String str, String str2, String str3) {
        Cursor cursor;
        boolean z10;
        long j10;
        Long valueOf;
        Long valueOf2;
        Long valueOf3;
        Boolean bool;
        long j11;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        zzg();
        zzay();
        Cursor cursor2 = null;
        try {
            z10 = false;
            cursor = zze().query(str, (String[]) new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count")).toArray(new String[0]), "app_id=? and name=?", new String[]{str2, str3}, null, null, null);
            try {
                try {
                } catch (SQLiteException e10) {
                    e = e10;
                    zzib zzibVar = this.zzu;
                    zzibVar.zzaV().zzb().zzd("Error querying events. appId", zzgt.zzl(str2), zzibVar.zzl().zza(str3), e);
                    if (cursor != null) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e11) {
            e = e11;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
        if (cursor.moveToFirst()) {
            long j12 = cursor.getLong(0);
            long j13 = cursor.getLong(1);
            long j14 = cursor.getLong(2);
            if (cursor.isNull(3)) {
                j10 = 0;
            } else {
                j10 = cursor.getLong(3);
            }
            if (cursor.isNull(4)) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(cursor.getLong(4));
            }
            if (cursor.isNull(5)) {
                valueOf2 = null;
            } else {
                valueOf2 = Long.valueOf(cursor.getLong(5));
            }
            if (cursor.isNull(6)) {
                valueOf3 = null;
            } else {
                valueOf3 = Long.valueOf(cursor.getLong(6));
            }
            if (!cursor.isNull(7)) {
                if (cursor.getLong(7) == 1) {
                    z10 = true;
                }
                bool = Boolean.valueOf(z10);
            } else {
                bool = null;
            }
            if (cursor.isNull(8)) {
                j11 = 0;
            } else {
                j11 = cursor.getLong(8);
            }
            zzbc zzbcVar = new zzbc(str2, str3, j12, j13, j11, j14, j10, valueOf, valueOf2, valueOf3, bool);
            if (cursor.moveToNext()) {
                this.zzu.zzaV().zzb().zzb("Got multiple records for event aggregates, expected one. appId", zzgt.zzl(str2));
            }
            cursor.close();
            return zzbcVar;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    private final void zzaF(String str, zzbc zzbcVar) {
        Long l10;
        Preconditions.checkNotNull(zzbcVar);
        zzg();
        zzay();
        ContentValues contentValues = new ContentValues();
        String str2 = zzbcVar.zza;
        contentValues.put("app_id", str2);
        contentValues.put("name", zzbcVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzbcVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzbcVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzbcVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzbcVar.zzg));
        contentValues.put("last_bundled_day", zzbcVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzbcVar.zzi);
        contentValues.put("last_sampling_rate", zzbcVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzbcVar.zze));
        Boolean bool = zzbcVar.zzk;
        if (bool != null && bool.booleanValue()) {
            l10 = 1L;
        } else {
            l10 = null;
        }
        contentValues.put("last_exempt_from_sampling", l10);
        try {
            if (zze().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                this.zzu.zzaV().zzb().zzb("Failed to insert/update event aggregates (got -1). appId", zzgt.zzl(str2));
            }
        } catch (SQLiteException e10) {
            this.zzu.zzaV().zzb().zzc("Error storing event aggregates. appId", zzgt.zzl(zzbcVar.zza), e10);
        }
    }

    private final void zzaG(String str, String str2) {
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzay();
        try {
            zze().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e10) {
            this.zzu.zzaV().zzb().zzc("Error deleting snapshot. appId", zzgt.zzl(str2), e10);
        }
    }

    private final zzpi zzaH(String str, long j10, byte[] bArr, String str2, String str3, int i10, int i11, long j11, long j12, long j13) {
        if (TextUtils.isEmpty(str2)) {
            this.zzu.zzaV().zzj().zza("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            com.google.android.gms.internal.measurement.zzhz zzhzVar = (com.google.android.gms.internal.measurement.zzhz) zzpj.zzw(com.google.android.gms.internal.measurement.zzib.zzh(), bArr);
            zzlr zzb2 = zzlr.zzb(i10);
            if (zzb2 != zzlr.GOOGLE_SIGNAL && zzb2 != zzlr.GOOGLE_SIGNAL_PENDING && i11 > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it = zzhzVar.zza().iterator();
                while (it.hasNext()) {
                    com.google.android.gms.internal.measurement.zzic zzicVar = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) it.next()).zzcl();
                    zzicVar.zzao(i11);
                    arrayList.add((com.google.android.gms.internal.measurement.zzid) zzicVar.zzbc());
                }
                zzhzVar.zzg();
                zzhzVar.zzf(arrayList);
            }
            HashMap hashMap = new HashMap();
            if (str3 != null) {
                String[] split = str3.split("\r\n");
                int length = split.length;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        break;
                    }
                    String str4 = split[i12];
                    if (str4.isEmpty()) {
                        break;
                    }
                    String[] split2 = str4.split("=", 2);
                    if (split2.length != 2) {
                        this.zzu.zzaV().zzb().zzb("Invalid upload header: ", str4);
                        break;
                    }
                    hashMap.put(split2[0], split2[1]);
                    i12++;
                }
            }
            zzph zzphVar = new zzph();
            zzphVar.zzb(j10);
            zzphVar.zzc((com.google.android.gms.internal.measurement.zzib) zzhzVar.zzbc());
            zzphVar.zzd(str2);
            zzphVar.zze(hashMap);
            zzphVar.zzf(zzb2);
            zzphVar.zzg(j11);
            zzphVar.zzh(j12);
            zzphVar.zzi(j13);
            zzphVar.zzj(i11);
            return zzphVar.zza();
        } catch (IOException e10) {
            this.zzu.zzaV().zzb().zzc("Failed to queued MeasurementBatch from upload_queue. appId", str, e10);
            return null;
        }
    }

    private final String zzaI() {
        zzib zzibVar = this.zzu;
        long currentTimeMillis = zzibVar.zzaZ().currentTimeMillis();
        Locale locale = Locale.US;
        zzlr zzlrVar = zzlr.GOOGLE_SIGNAL;
        Integer valueOf = Integer.valueOf(zzlrVar.zza());
        Long valueOf2 = Long.valueOf(currentTimeMillis);
        zzibVar.zzc();
        Long l10 = (Long) zzfx.zzS.zzb(null);
        l10.longValue();
        String format = String.format(locale, "(upload_type = %d AND ABS(creation_timestamp - %d) > %d)", valueOf, valueOf2, l10);
        Integer valueOf3 = Integer.valueOf(zzlrVar.zza());
        zzibVar.zzc();
        String format2 = String.format(locale, "(upload_type != %d AND ABS(creation_timestamp - %d) > %d)", valueOf3, valueOf2, Long.valueOf(zzal.zzI()));
        StringBuilder sb = new StringBuilder(format.length() + 5 + format2.length() + 1);
        sb.append("(");
        sb.append(format);
        sb.append(" OR ");
        sb.append(format2);
        sb.append(")");
        return sb.toString();
    }

    private static final String zzaJ(List list) {
        if (list.isEmpty()) {
            return "";
        }
        return String.format(" AND (upload_type IN (%s))", TextUtils.join(", ", list));
    }

    static final void zzaw(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty("value");
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            if (obj instanceof Double) {
                contentValues.put("value", (Double) obj);
                return;
            }
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    public final long zzA(String str, com.google.android.gms.internal.measurement.zzib zzibVar, String str2, Map map, zzlr zzlrVar, Long l10) {
        int delete;
        zzg();
        zzay();
        Preconditions.checkNotNull(zzibVar);
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        if (zzai()) {
            zzpf zzpfVar = this.zzg;
            long zza2 = zzpfVar.zzq().zzb.zza();
            zzib zzibVar2 = this.zzu;
            long elapsedRealtime = zzibVar2.zzaZ().elapsedRealtime();
            long abs = Math.abs(elapsedRealtime - zza2);
            zzibVar2.zzc();
            if (abs > zzal.zzJ()) {
                zzpfVar.zzq().zzb.zzb(elapsedRealtime);
                zzg();
                zzay();
                if (zzai() && (delete = zze().delete("upload_queue", zzaI(), new String[0])) > 0) {
                    zzibVar2.zzaV().zzk().zzb("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", Integer.valueOf(delete));
                }
                Preconditions.checkNotEmpty(str);
                zzg();
                zzay();
                try {
                    int zzm = zzibVar2.zzc().zzm(str, zzfx.zzz);
                    if (zzm > 0) {
                        zze().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(zzm)});
                    }
                } catch (SQLiteException e10) {
                    this.zzu.zzaV().zzb().zzc("Error deleting over the limit queued batches. appId", zzgt.zzl(str), e10);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getKey();
            String str4 = (String) entry.getValue();
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 1 + String.valueOf(str4).length());
            sb.append(str3);
            sb.append("=");
            sb.append(str4);
            arrayList.add(sb.toString());
        }
        byte[] zzcc = zzibVar.zzcc();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("measurement_batch", zzcc);
        contentValues.put("upload_uri", str2);
        contentValues.put("upload_headers", a.a("\r\n", arrayList));
        contentValues.put("upload_type", Integer.valueOf(zzlrVar.zza()));
        zzib zzibVar3 = this.zzu;
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzibVar3.zzaZ().currentTimeMillis()));
        contentValues.put("retry_count", (Integer) 0);
        if (l10 != null) {
            contentValues.put("associated_row_id", l10);
        }
        try {
            long insert = zze().insert("upload_queue", null, contentValues);
            if (insert == -1) {
                zzibVar3.zzaV().zzb().zzb("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", str);
                return -1L;
            }
            return insert;
        } catch (SQLiteException e11) {
            this.zzu.zzaV().zzb().zzc("Error storing MeasurementBatch to upload_queue. appId", str, e11);
            return -1L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzpi zzB(long j10) {
        zzav zzavVar;
        Cursor cursor;
        zzg();
        zzay();
        Cursor cursor2 = null;
        try {
            cursor = zze().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "associated_row_id", "last_upload_timestamp"}, "rowId=?", new String[]{String.valueOf(j10)}, null, null, null, "1");
            try {
            } catch (SQLiteException e10) {
                e = e10;
                zzavVar = this;
                try {
                    zzavVar.zzu.zzaV().zzb().zzc("Error to querying MeasurementBatch from upload_queue. rowId", Long.valueOf(j10), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e11) {
            e = e11;
            zzavVar = this;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
            throw th;
        }
        if (cursor.moveToFirst()) {
            zzpi zzaH = zzaH((String) Preconditions.checkNotNull(cursor.getString(1)), j10, cursor.getBlob(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5), cursor.getInt(6), cursor.getLong(7), cursor.getLong(8), cursor.getLong(9));
            cursor.close();
            return zzaH;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzC(String str, zzon zzonVar, int i10) {
        List emptyList;
        String str2;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        Cursor cursor = null;
        try {
            SQLiteDatabase zze2 = zze();
            String[] strArr = {"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "associated_row_id", "last_upload_timestamp"};
            String zzaJ = zzaJ(zzonVar.zza);
            String zzaI = zzaI();
            StringBuilder sb = new StringBuilder(String.valueOf(zzaJ).length() + 17 + zzaI.length());
            sb.append("app_id=?");
            sb.append(zzaJ);
            sb.append(" AND NOT ");
            sb.append(zzaI);
            String sb2 = sb.toString();
            String[] strArr2 = {str};
            if (i10 > 0) {
                str2 = String.valueOf(i10);
            } else {
                str2 = null;
            }
            cursor = zze2.query("upload_queue", strArr, sb2, strArr2, null, null, "creation_timestamp ASC", str2);
            emptyList = new ArrayList();
            while (cursor.moveToNext()) {
                zzpi zzaH = zzaH(str, cursor.getLong(0), cursor.getBlob(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5), cursor.getInt(6), cursor.getLong(7), cursor.getLong(8), cursor.getLong(9));
                if (zzaH != null) {
                    emptyList.add(zzaH);
                }
            }
        } catch (SQLiteException e10) {
            try {
                this.zzu.zzaV().zzb().zzc("Error to querying MeasurementBatch from upload_queue. appId", str, e10);
                emptyList = Collections.emptyList();
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
        return emptyList;
    }

    public final boolean zzD(String str) {
        zzlr[] zzlrVarArr = {zzlr.GOOGLE_SIGNAL};
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(zzlrVarArr[0].zza()));
        String zzaJ = zzaJ(arrayList);
        String zzaI = zzaI();
        StringBuilder sb = new StringBuilder(String.valueOf(zzaJ).length() + 61 + zzaI.length());
        sb.append("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?");
        sb.append(zzaJ);
        sb.append(" AND NOT ");
        sb.append(zzaI);
        if (zzaA(sb.toString(), new String[]{str}) != 0) {
            return true;
        }
        return false;
    }

    public final void zzE(Long l10) {
        zzg();
        zzay();
        Preconditions.checkNotNull(l10);
        try {
            if (zze().delete("upload_queue", "rowid=?", new String[]{l10.toString()}) != 1) {
                this.zzu.zzaV().zze().zza("Deleted fewer rows from upload_queue than expected");
            }
        } catch (SQLiteException e10) {
            this.zzu.zzaV().zzb().zzb("Failed to delete a MeasurementBatch in a upload_queue table", e10);
            throw e10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String zzF() {
        SQLiteException e10;
        Cursor cursor;
        SQLiteDatabase zze2 = zze();
        ?? r12 = 0;
        try {
            try {
                cursor = zze2.rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(0);
                        cursor.close();
                        return string;
                    }
                } catch (SQLiteException e11) {
                    e10 = e11;
                    this.zzu.zzaV().zzb().zzb("Database error getting next bundle app id", e10);
                    if (cursor != null) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                r12 = zze2;
                th = th;
                if (r12 != 0) {
                    r12.close();
                }
                throw th;
            }
        } catch (SQLiteException e12) {
            e10 = e12;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (r12 != 0) {
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    public final boolean zzG() {
        if (zzaA("select count(1) > 0 from queue where has_realtime = 1", null) != 0) {
            return true;
        }
        return false;
    }

    public final void zzH(long j10) {
        zzg();
        zzay();
        try {
            if (zze().delete("queue", "rowid=?", new String[]{String.valueOf(j10)}) == 1) {
            } else {
                throw new SQLiteException("Deleted fewer rows from queue than expected");
            }
        } catch (SQLiteException e10) {
            this.zzu.zzaV().zzb().zzb("Failed to delete a bundle in a queue table", e10);
            throw e10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzI() {
        zzg();
        zzay();
        if (zzai()) {
            zzpf zzpfVar = this.zzg;
            long zza2 = zzpfVar.zzq().zza.zza();
            zzib zzibVar = this.zzu;
            long elapsedRealtime = zzibVar.zzaZ().elapsedRealtime();
            long abs = Math.abs(elapsedRealtime - zza2);
            zzibVar.zzc();
            if (abs > zzal.zzJ()) {
                zzpfVar.zzq().zza.zzb(elapsedRealtime);
                zzg();
                zzay();
                if (zzai()) {
                    SQLiteDatabase zze2 = zze();
                    String valueOf = String.valueOf(zzibVar.zzaZ().currentTimeMillis());
                    zzibVar.zzc();
                    int delete = zze2.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{valueOf, String.valueOf(zzal.zzI())});
                    if (delete > 0) {
                        zzibVar.zzaV().zzk().zzb("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzJ(List list) {
        zzg();
        zzay();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (!zzai()) {
            return;
        }
        String join = TextUtils.join(",", list);
        StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
        sb.append("(");
        sb.append(join);
        sb.append(")");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder(sb2.length() + 80);
        sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
        sb3.append(sb2);
        sb3.append(" AND retry_count =  2147483647 LIMIT 1");
        if (zzaA(sb3.toString(), null) > 0) {
            this.zzu.zzaV().zze().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
        }
        try {
            SQLiteDatabase zze2 = zze();
            StringBuilder sb4 = new StringBuilder(sb2.length() + Constants.ERR_WATERMARKR_INFO);
            sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
            sb4.append(sb2);
            sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
            zze2.execSQL(sb4.toString());
        } catch (SQLiteException e10) {
            this.zzu.zzaV().zzb().zzb("Error incrementing retry count. error", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzK(Long l10) {
        zzg();
        zzay();
        Preconditions.checkNotNull(l10);
        if (!zzai()) {
            return;
        }
        StringBuilder sb = new StringBuilder(l10.toString().length() + 86);
        sb.append("SELECT COUNT(1) FROM upload_queue WHERE rowid = ");
        sb.append(l10);
        sb.append(" AND retry_count =  2147483647 LIMIT 1");
        if (zzaA(sb.toString(), null) > 0) {
            this.zzu.zzaV().zze().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
        }
        try {
            SQLiteDatabase zze2 = zze();
            long currentTimeMillis = this.zzu.zzaZ().currentTimeMillis();
            StringBuilder sb2 = new StringBuilder(String.valueOf(currentTimeMillis).length() + 60);
            sb2.append(" SET retry_count = retry_count + 1, last_upload_timestamp = ");
            sb2.append(currentTimeMillis);
            String sb3 = sb2.toString();
            StringBuilder sb4 = new StringBuilder(sb3.length() + 34 + l10.toString().length() + 29);
            sb4.append("UPDATE upload_queue");
            sb4.append(sb3);
            sb4.append(" WHERE rowid = ");
            sb4.append(l10);
            sb4.append(" AND retry_count < 2147483647");
            zze2.execSQL(sb4.toString());
        } catch (SQLiteException e10) {
            this.zzu.zzaV().zzb().zzb("Error incrementing retry count. error", e10);
        }
    }

    @VisibleForTesting
    final Object zzL(Cursor cursor, int i10) {
        int type = cursor.getType(i10);
        if (type != 0) {
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type != 4) {
                            this.zzu.zzaV().zzb().zzb("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                            return null;
                        }
                        this.zzu.zzaV().zzb().zza("Loaded invalid blob type value, ignoring it");
                        return null;
                    }
                    return cursor.getString(i10);
                }
                return Double.valueOf(cursor.getDouble(i10));
            }
            return Long.valueOf(cursor.getLong(i10));
        }
        this.zzu.zzaV().zzb().zza("Loaded invalid null value from database");
        return null;
    }

    public final long zzM() {
        return zzaB("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(12:1|2|3|4|(2:6|(3:8|10|11)(1:14))|15|16|(1:18)(2:21|22)|19|10|11|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b1, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b8, code lost:
    
        r6 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b9, code lost:
    
        r15.zzu.zzaV().zzb().zzd("Error inserting column. appId", com.google.android.gms.measurement.internal.zzgt.zzl(r16), "first_open_count", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00cc, code lost:
    
        r8 = r6;
     */
    @VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long zzN(String str, String str2) {
        long j10;
        long zzaB;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty("first_open_count");
        zzg();
        zzay();
        SQLiteDatabase zze2 = zze();
        zze2.beginTransaction();
        long j11 = 0;
        try {
            try {
                StringBuilder sb = new StringBuilder(48);
                sb.append("select ");
                sb.append("first_open_count");
                sb.append(" from app2 where app_id=?");
                j10 = -1;
                zzaB = zzaB(sb.toString(), new String[]{str}, -1L);
            } catch (SQLiteException e10) {
                e = e10;
            }
            if (zzaB == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", (Integer) 0);
                contentValues.put("previous_install_count", (Integer) 0);
                if (zze2.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                    this.zzu.zzaV().zzb().zzc("Failed to insert column (got -1). appId", zzgt.zzl(str), "first_open_count");
                    return j10;
                }
                zzaB = 0;
            }
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str);
            contentValues2.put("first_open_count", Long.valueOf(1 + zzaB));
            if (zze2.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                this.zzu.zzaV().zzb().zzc("Failed to update column (got 0). appId", zzgt.zzl(str), "first_open_count");
            } else {
                zze2.setTransactionSuccessful();
                j10 = zzaB;
            }
            return j10;
        } finally {
            zze2.endTransaction();
        }
    }

    public final long zzO() {
        return zzaB("select max(timestamp) from raw_events", null, 0L);
    }

    public final boolean zzP() {
        if (zzaA("select count(1) > 0 from raw_events", null) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzQ(String str, String str2) {
        if (zzaA("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0) {
            return true;
        }
        return false;
    }

    public final boolean zzR() {
        if (zzaA("select count(1) > 0 from raw_events where realtime = 1", null) != 0) {
            return true;
        }
        return false;
    }

    public final void zzS(List list) {
        Preconditions.checkNotNull(list);
        zzg();
        zzay();
        StringBuilder sb = new StringBuilder("rowid in (");
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (i10 != 0) {
                sb.append(",");
            }
            sb.append(((Long) list.get(i10)).longValue());
        }
        sb.append(")");
        int delete = zze().delete("raw_events", sb.toString(), null);
        if (delete != list.size()) {
            this.zzu.zzaV().zzb().zzc("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    public final void zzT(String str) {
        try {
            zze().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str, str});
        } catch (SQLiteException e10) {
            this.zzu.zzaV().zzb().zzc("Failed to remove unused event metadata. appId", zzgt.zzl(str), e10);
        }
    }

    public final long zzU(String str) {
        Preconditions.checkNotEmpty(str);
        return zzaB("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final boolean zzV(String str, Long l10, long j10, com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        zzg();
        zzay();
        Preconditions.checkNotNull(zzhsVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l10);
        zzib zzibVar = this.zzu;
        byte[] zzcc = zzhsVar.zzcc();
        zzibVar.zzaV().zzk().zzc("Saving complex main event, appId, data size", zzibVar.zzl().zza(str), Integer.valueOf(zzcc.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l10);
        contentValues.put("children_to_process", Long.valueOf(j10));
        contentValues.put("main_event", zzcc);
        try {
            if (zze().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                zzibVar.zzaV().zzb().zzb("Failed to insert complex main event (got -1). appId", zzgt.zzl(str));
                return false;
            }
            return true;
        } catch (SQLiteException e10) {
            this.zzu.zzaV().zzb().zzc("Error storing complex main event. appId", zzgt.zzl(str), e10);
            return false;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x006a: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:107), block:B:27:0x006a */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bundle zzW(String str) {
        Cursor cursor;
        Cursor cursor2;
        zzg();
        zzay();
        Cursor cursor3 = null;
        try {
            try {
                cursor = zze().rawQuery("select parameters from default_event_params where app_id=?", new String[]{str});
                try {
                    if (!cursor.moveToFirst()) {
                        this.zzu.zzaV().zzk().zza("Default event parameters not found");
                    } else {
                        try {
                            com.google.android.gms.internal.measurement.zzhs zzhsVar = (com.google.android.gms.internal.measurement.zzhs) ((com.google.android.gms.internal.measurement.zzhr) zzpj.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), cursor.getBlob(0))).zzbc();
                            this.zzg.zzp();
                            Bundle zzE = zzpj.zzE(zzhsVar.zza());
                            cursor.close();
                            return zzE;
                        } catch (IOException e10) {
                            this.zzu.zzaV().zzb().zzc("Failed to retrieve default event parameters. appId", zzgt.zzl(str), e10);
                        }
                    }
                } catch (SQLiteException e11) {
                    e = e11;
                    this.zzu.zzaV().zzb().zzb("Error selecting default event parameters", e);
                    if (cursor != null) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor3 = cursor2;
                if (cursor3 != null) {
                    cursor3.close();
                }
                throw th;
            }
        } catch (SQLiteException e12) {
            e = e12;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor3 != null) {
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzX(String str, long j10) {
        try {
            if (zzaB("select count(*) from raw_events where app_id=? and timestamp >= ? and name not like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j10)}, 0L) > 0) {
                return false;
            }
            if (zzaB("select count(*) from raw_events where app_id=? and timestamp >= ? and name like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j10)}, 0L) <= 0) {
                return false;
            }
            return true;
        } catch (SQLiteException e10) {
            this.zzu.zzaV().zzb().zzb("Error checking backfill conditions", e10);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x002e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzY(String str, Long l10, String str2, Bundle bundle) {
        zzat zzatVar;
        String string;
        String str3;
        Bundle bundle2;
        long update;
        com.google.android.gms.internal.measurement.zzid zzidVar;
        Cursor query;
        Preconditions.checkNotNull(bundle);
        zzg();
        zzay();
        if (l10 != null) {
            zzatVar = new zzat(this, str, l10.longValue());
        } else {
            zzatVar = new zzat(this, str);
        }
        zzat zzatVar2 = zzatVar;
        for (List<zzas> zza2 = zzatVar2.zza(); !zza2.isEmpty(); zza2 = zzatVar2.zza()) {
            for (zzas zzasVar : zza2) {
                if (!TextUtils.isEmpty(str2)) {
                    Cursor cursor = null;
                    com.google.android.gms.internal.measurement.zzid zzidVar2 = null;
                    Cursor cursor2 = null;
                    try {
                        try {
                            query = zze().query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str, Long.toString(zzasVar.zzb)}, null, null, "rowid", "2");
                            try {
                                try {
                                } catch (Throwable th) {
                                    th = th;
                                    cursor = query;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    throw th;
                                }
                            } catch (SQLiteException e10) {
                                e = e10;
                                zzidVar = null;
                            }
                        } catch (SQLiteException e11) {
                            e = e11;
                            zzidVar = null;
                        }
                        if (!query.moveToFirst()) {
                            this.zzu.zzaV().zzb().zzb("Raw event metadata record is missing. appId", zzgt.zzl(str));
                        } else {
                            try {
                                zzidVar = (com.google.android.gms.internal.measurement.zzid) ((com.google.android.gms.internal.measurement.zzic) zzpj.zzw(com.google.android.gms.internal.measurement.zzid.zzaE(), query.getBlob(0))).zzbc();
                                try {
                                    if (query.moveToNext()) {
                                        this.zzu.zzaV().zze().zzb("Get multiple raw event metadata records, expected one. appId", zzgt.zzl(str));
                                    }
                                    query.close();
                                    query.close();
                                } catch (SQLiteException e12) {
                                    e = e12;
                                    cursor2 = query;
                                    this.zzu.zzaV().zzb().zzc("Data loss. Error selecting raw event. appId", zzgt.zzl(str), e);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    zzidVar2 = zzidVar;
                                    if (zzidVar2 != null) {
                                    }
                                    zzpf zzpfVar = this.zzg;
                                    zzpj zzp = zzpfVar.zzp();
                                    com.google.android.gms.internal.measurement.zzhs zzhsVar = zzasVar.zzd;
                                    Bundle bundle3 = new Bundle();
                                    while (r4.hasNext()) {
                                    }
                                    string = bundle3.getString("_o");
                                    bundle3.remove("_o");
                                    String zzd2 = zzhsVar.zzd();
                                    if (string == null) {
                                    }
                                    zzgu zzguVar = new zzgu(zzd2, string, bundle3, zzhsVar.zzf());
                                    zzib zzibVar = this.zzu;
                                    Bundle bundle4 = zzguVar.zzd;
                                    str3 = zzguVar.zza;
                                    zzpo zzk2 = zzibVar.zzk();
                                    if (str3.equals("_cmp")) {
                                    }
                                    zzk2.zzI(bundle4, bundle2);
                                    zzbb zzbbVar = new zzbb(this.zzu, zzguVar.zzb, str, zzhsVar.zzd(), zzhsVar.zzf(), zzhsVar.zzh(), bundle4);
                                    long j10 = zzasVar.zza;
                                    long j11 = zzasVar.zzb;
                                    boolean z10 = zzasVar.zzc;
                                    zzg();
                                    zzay();
                                    Preconditions.checkNotNull(zzbbVar);
                                    String str4 = zzbbVar.zza;
                                    Preconditions.checkNotEmpty(str4);
                                    byte[] zzcc = zzpfVar.zzp().zzh(zzbbVar).zzcc();
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("app_id", str4);
                                    contentValues.put("name", zzbbVar.zzb);
                                    contentValues.put(HeaderInterceptor.TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                    contentValues.put("metadata_fingerprint", Long.valueOf(j11));
                                    contentValues.put("data", zzcc);
                                    contentValues.put("realtime", Integer.valueOf(z10 ? 1 : 0));
                                    update = zze().update("raw_events", contentValues, "rowid = ?", new String[]{String.valueOf(j10)});
                                    if (update == 1) {
                                    }
                                }
                                zzidVar2 = zzidVar;
                            } catch (IOException e13) {
                                this.zzu.zzaV().zzb().zzc("Data loss. Failed to merge raw event metadata. appId", zzgt.zzl(str), e13);
                            }
                            if (zzidVar2 != null) {
                                Iterator it = zzidVar2.zzf().iterator();
                                while (it.hasNext()) {
                                    if (((com.google.android.gms.internal.measurement.zziu) it.next()).zzc().equals(str2)) {
                                        break;
                                    }
                                }
                            }
                        }
                        query.close();
                        if (zzidVar2 != null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                zzpf zzpfVar2 = this.zzg;
                zzpj zzp2 = zzpfVar2.zzp();
                com.google.android.gms.internal.measurement.zzhs zzhsVar2 = zzasVar.zzd;
                Bundle bundle32 = new Bundle();
                for (com.google.android.gms.internal.measurement.zzhw zzhwVar : zzhsVar2.zza()) {
                    if (zzhwVar.zzi()) {
                        bundle32.putDouble(zzhwVar.zzb(), zzhwVar.zzj());
                    } else if (zzhwVar.zzg()) {
                        bundle32.putFloat(zzhwVar.zzb(), zzhwVar.zzh());
                    } else if (zzhwVar.zze()) {
                        bundle32.putLong(zzhwVar.zzb(), zzhwVar.zzf());
                    } else if (zzhwVar.zzc()) {
                        bundle32.putString(zzhwVar.zzb(), zzhwVar.zzd());
                    } else if (!zzhwVar.zzk().isEmpty()) {
                        bundle32.putParcelableArray(zzhwVar.zzb(), zzpj.zzy(zzhwVar.zzk()));
                    } else {
                        zzp2.zzu.zzaV().zzb().zzb("Unexpected parameter type for parameter", zzhwVar);
                    }
                }
                string = bundle32.getString("_o");
                bundle32.remove("_o");
                String zzd22 = zzhsVar2.zzd();
                if (string == null) {
                    string = "";
                }
                zzgu zzguVar2 = new zzgu(zzd22, string, bundle32, zzhsVar2.zzf());
                zzib zzibVar2 = this.zzu;
                Bundle bundle42 = zzguVar2.zzd;
                str3 = zzguVar2.zza;
                zzpo zzk22 = zzibVar2.zzk();
                if (str3.equals("_cmp")) {
                    bundle2 = bundle;
                } else {
                    bundle2 = new Bundle(bundle);
                    Iterator<String> it2 = bundle.keySet().iterator();
                    while (it2.hasNext()) {
                        String next = it2.next();
                        Iterator<String> it3 = it2;
                        if (next.startsWith("gad_")) {
                            bundle2.remove(next);
                        }
                        it2 = it3;
                    }
                }
                zzk22.zzI(bundle42, bundle2);
                zzbb zzbbVar2 = new zzbb(this.zzu, zzguVar2.zzb, str, zzhsVar2.zzd(), zzhsVar2.zzf(), zzhsVar2.zzh(), bundle42);
                long j102 = zzasVar.zza;
                long j112 = zzasVar.zzb;
                boolean z102 = zzasVar.zzc;
                zzg();
                zzay();
                Preconditions.checkNotNull(zzbbVar2);
                String str42 = zzbbVar2.zza;
                Preconditions.checkNotEmpty(str42);
                byte[] zzcc2 = zzpfVar2.zzp().zzh(zzbbVar2).zzcc();
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str42);
                contentValues2.put("name", zzbbVar2.zzb);
                contentValues2.put(HeaderInterceptor.TIMESTAMP, Long.valueOf(zzbbVar2.zzd));
                contentValues2.put("metadata_fingerprint", Long.valueOf(j112));
                contentValues2.put("data", zzcc2);
                contentValues2.put("realtime", Integer.valueOf(z102 ? 1 : 0));
                try {
                    update = zze().update("raw_events", contentValues2, "rowid = ?", new String[]{String.valueOf(j102)});
                    if (update == 1) {
                        zzibVar2.zzaV().zzb().zzc("Failed to update raw event. appId, updatedRows", zzgt.zzl(str42), Long.valueOf(update));
                    }
                } catch (SQLiteException e14) {
                    this.zzu.zzaV().zzb().zzc("Error updating raw event. appId", zzgt.zzl(zzbbVar2.zza), e14);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
    
        if (r5 == 0) goto L٢٣;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v9, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzjk zzZ(String str) {
        Throwable th;
        SQLiteException e10;
        Preconditions.checkNotNull(str);
        zzg();
        zzay();
        ?? r52 = {str};
        Cursor cursor = null;
        r1 = null;
        r1 = null;
        zzjk zzjkVar = null;
        try {
            try {
                r52 = zze().rawQuery("select consent_state, consent_source from consent_settings where app_id=? limit 1;", r52);
                try {
                    if (!r52.moveToFirst()) {
                        this.zzu.zzaV().zzk().zza("No data found");
                    } else {
                        zzjkVar = zzjk.zzf(r52.getString(0), r52.getInt(1));
                    }
                } catch (SQLiteException e11) {
                    e10 = e11;
                    this.zzu.zzaV().zzb().zzb("Error querying database.", e10);
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = r52;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e12) {
            e10 = e12;
            r52 = 0;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
            }
            throw th;
        }
        r52.close();
        if (zzjkVar == null) {
            return zzjk.zza;
        }
        return zzjkVar;
    }

    public final boolean zzaa(String str, zzog zzogVar) {
        zzg();
        zzay();
        Preconditions.checkNotNull(zzogVar);
        Preconditions.checkNotEmpty(str);
        zzib zzibVar = this.zzu;
        long currentTimeMillis = zzibVar.zzaZ().currentTimeMillis();
        zzfw zzfwVar = zzfx.zzav;
        long longValue = currentTimeMillis - ((Long) zzfwVar.zzb(null)).longValue();
        long j10 = zzogVar.zzb;
        if (j10 < longValue || j10 > ((Long) zzfwVar.zzb(null)).longValue() + currentTimeMillis) {
            zzibVar.zzaV().zze().zzd("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzgt.zzl(str), Long.valueOf(currentTimeMillis), Long.valueOf(j10));
        }
        zzibVar.zzaV().zzk().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzogVar.zza);
        contentValues.put("source", Integer.valueOf(zzogVar.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(j10));
        try {
            if (zze().insert("trigger_uris", null, contentValues) == -1) {
                zzibVar.zzaV().zzb().zzb("Failed to insert trigger URI (got -1). appId", zzgt.zzl(str));
                return false;
            }
            return true;
        } catch (SQLiteException e10) {
            this.zzu.zzaV().zzb().zzc("Error storing trigger URI. appId", zzgt.zzl(str), e10);
            return false;
        }
    }

    public final void zzab(String str, zzjk zzjkVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjkVar);
        zzg();
        zzay();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzjkVar.zzl());
        contentValues.put("consent_source", Integer.valueOf(zzjkVar.zzb()));
        zzaD("consent_settings", "app_id", contentValues);
    }

    public final zzaz zzac(String str) {
        Preconditions.checkNotNull(str);
        zzg();
        zzay();
        return zzaz.zzg(zzaC("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final void zzad(String str, zzaz zzazVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzazVar);
        zzg();
        zzay();
        zzjk zzZ = zzZ(str);
        zzjk zzjkVar = zzjk.zza;
        if (zzZ == zzjkVar) {
            zzab(str, zzjkVar);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", zzazVar.zze());
        zzaD("consent_settings", "app_id", contentValues);
    }

    public final void zzae(String str, zzjk zzjkVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjkVar);
        zzg();
        zzay();
        zzab(str, zzZ(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", zzjkVar.zzl());
        zzaD("consent_settings", "app_id", contentValues);
    }

    public final zzjk zzaf(String str) {
        Preconditions.checkNotNull(str);
        zzg();
        zzay();
        return zzjk.zzf(zzaC("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""), 100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0254, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0238, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01e2, code lost:
    
        r0 = r23.zzu.zzaV().zze();
        r10 = com.google.android.gms.measurement.internal.zzgt.zzl(r24);
        r12 = java.lang.Integer.valueOf(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01fa, code lost:
    
        if (r11.zza() == false) goto L٦٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01fc, code lost:
    
        r16 = java.lang.Integer.valueOf(r11.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0209, code lost:
    
        r0.zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r10, r12, java.lang.String.valueOf(r16));
        r21 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0207, code lost:
    
        r16 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x029a, code lost:
    
        r21 = r7;
        r0 = r0.zzc().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02a8, code lost:
    
        if (r0.hasNext() == false) goto L١٧٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02aa, code lost:
    
        r3 = (com.google.android.gms.internal.measurement.zzfn) r0.next();
        zzay();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x02c4, code lost:
    
        if (r3.zzc().isEmpty() == false) goto L٩٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02f6, code lost:
    
        r7 = r3.zzcc();
        r10 = new android.content.ContentValues();
        r10.put("app_id", r24);
        r10.put("audience_id", java.lang.Integer.valueOf(r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x030d, code lost:
    
        if (r3.zza() == false) goto L٩٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x030f, code lost:
    
        r11 = java.lang.Integer.valueOf(r3.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0319, code lost:
    
        r10.put("filter_id", r11);
        r22 = r0;
        r10.put("property_name", r3.zzc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x032b, code lost:
    
        if (r3.zzg() == false) goto L٩٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x032d, code lost:
    
        r0 = java.lang.Boolean.valueOf(r3.zzh());
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0337, code lost:
    
        r10.put("session_scoped", r0);
        r10.put("data", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x034b, code lost:
    
        if (zze().insertWithOnConflict("property_filters", null, r10, 5) != (-1)) goto L١٠٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0363, code lost:
    
        r0 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x034d, code lost:
    
        r23.zzu.zzaV().zzb().zzb("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.zzgt.zzl(r24));
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0361, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0367, code lost:
    
        r23.zzu.zzaV().zzb().zzc("Error storing property filter. appId", com.google.android.gms.measurement.internal.zzgt.zzl(r24), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0336, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0318, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x02c6, code lost:
    
        r0 = r23.zzu.zzaV().zze();
        r8 = com.google.android.gms.measurement.internal.zzgt.zzl(r24);
        r10 = java.lang.Integer.valueOf(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x02de, code lost:
    
        if (r3.zza() == false) goto L٩٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x02e0, code lost:
    
        r16 = java.lang.Integer.valueOf(r3.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x02ed, code lost:
    
        r0.zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r8, r10, java.lang.String.valueOf(r16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02eb, code lost:
    
        r16 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x017b, code lost:
    
        r10 = r0.zzc().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0187, code lost:
    
        if (r10.hasNext() == false) goto L١٦٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0193, code lost:
    
        if (((com.google.android.gms.internal.measurement.zzfn) r10.next()).zza() != false) goto L١٧١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0195, code lost:
    
        r23.zzu.zzaV().zze().zzc("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.zzgt.zzl(r24), java.lang.Integer.valueOf(r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01ae, code lost:
    
        r10 = r0.zzf().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01c4, code lost:
    
        if (r10.hasNext() == false) goto L١٧٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01c6, code lost:
    
        r11 = (com.google.android.gms.internal.measurement.zzff) r10.next();
        zzay();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01e0, code lost:
    
        if (r11.zzc().isEmpty() == false) goto L٦٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0214, code lost:
    
        r3 = r11.zzcc();
        r21 = r7;
        r7 = new android.content.ContentValues();
        r7.put("app_id", r24);
        r7.put("audience_id", java.lang.Integer.valueOf(r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x022d, code lost:
    
        if (r11.zza() == false) goto L٧٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x022f, code lost:
    
        r8 = java.lang.Integer.valueOf(r11.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0239, code lost:
    
        r7.put("filter_id", r8);
        r7.put("event_name", r11.zzc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0249, code lost:
    
        if (r11.zzk() == false) goto L٧٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x024b, code lost:
    
        r8 = java.lang.Boolean.valueOf(r11.zzm());
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0255, code lost:
    
        r7.put("session_scoped", r8);
        r7.put("data", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0269, code lost:
    
        if (zze().insertWithOnConflict("event_filters", null, r7, 5) != (-1)) goto L١٧٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x026b, code lost:
    
        r23.zzu.zzaV().zzb().zzb("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.zzgt.zzl(r24));
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x027e, code lost:
    
        r7 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0284, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0285, code lost:
    
        r23.zzu.zzaV().zzb().zzc("Error storing event filter. appId", com.google.android.gms.measurement.internal.zzgt.zzl(r24), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x037a, code lost:
    
        zzay();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        r0 = zze();
        r7 = r18;
        r0.delete("property_filters", r7, new java.lang.String[]{r24, java.lang.String.valueOf(r9)});
        r0.delete("event_filters", r7, new java.lang.String[]{r24, java.lang.String.valueOf(r9)});
        r18 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x03a3, code lost:
    
        r7 = r21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzag(String str, List list) {
        Integer num;
        boolean z10;
        String str2 = "app_id=? and audience_id=?";
        Preconditions.checkNotNull(list);
        int i10 = 0;
        while (i10 < list.size()) {
            com.google.android.gms.internal.measurement.zzfc zzfcVar = (com.google.android.gms.internal.measurement.zzfc) ((com.google.android.gms.internal.measurement.zzfd) list.get(i10)).zzcl();
            if (zzfcVar.zzd() != 0) {
                int i11 = 0;
                while (i11 < zzfcVar.zzd()) {
                    com.google.android.gms.internal.measurement.zzfe zzfeVar = (com.google.android.gms.internal.measurement.zzfe) zzfcVar.zze(i11).zzcl();
                    com.google.android.gms.internal.measurement.zzfe zzfeVar2 = (com.google.android.gms.internal.measurement.zzfe) zzfeVar.clone();
                    String zzb2 = zzjl.zzb(zzfeVar.zza());
                    if (zzb2 != null) {
                        zzfeVar2.zzb(zzb2);
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    int i12 = 0;
                    while (i12 < zzfeVar.zzc()) {
                        com.google.android.gms.internal.measurement.zzfh zzd2 = zzfeVar.zzd(i12);
                        com.google.android.gms.internal.measurement.zzfe zzfeVar3 = zzfeVar;
                        String str3 = str2;
                        String zzc2 = zzls.zzc(zzd2.zzh(), zzjm.zza, zzjm.zzb);
                        if (zzc2 != null) {
                            com.google.android.gms.internal.measurement.zzfg zzfgVar = (com.google.android.gms.internal.measurement.zzfg) zzd2.zzcl();
                            zzfgVar.zza(zzc2);
                            zzfeVar2.zze(i12, (com.google.android.gms.internal.measurement.zzfh) zzfgVar.zzbc());
                            z10 = true;
                        }
                        i12++;
                        zzfeVar = zzfeVar3;
                        str2 = str3;
                    }
                    String str4 = str2;
                    if (z10) {
                        zzfcVar.zzf(i11, zzfeVar2);
                        list.set(i10, (com.google.android.gms.internal.measurement.zzfd) zzfcVar.zzbc());
                    }
                    i11++;
                    str2 = str4;
                }
            }
            String str5 = str2;
            if (zzfcVar.zza() != 0) {
                for (int i13 = 0; i13 < zzfcVar.zza(); i13++) {
                    com.google.android.gms.internal.measurement.zzfn zzb3 = zzfcVar.zzb(i13);
                    String zzc3 = zzls.zzc(zzb3.zzc(), zzjn.zza, zzjn.zzb);
                    if (zzc3 != null) {
                        com.google.android.gms.internal.measurement.zzfm zzfmVar = (com.google.android.gms.internal.measurement.zzfm) zzb3.zzcl();
                        zzfmVar.zza(zzc3);
                        zzfcVar.zzc(i13, zzfmVar);
                        list.set(i10, (com.google.android.gms.internal.measurement.zzfd) zzfcVar.zzbc());
                    }
                }
            }
            i10++;
            str2 = str5;
        }
        String str6 = str2;
        zzay();
        zzg();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase zze2 = zze();
        zze2.beginTransaction();
        try {
            zzay();
            zzg();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase zze3 = zze();
            zze3.delete("property_filters", "app_id=?", new String[]{str});
            zze3.delete("event_filters", "app_id=?", new String[]{str});
            Iterator it = list.iterator();
            while (it.hasNext()) {
                com.google.android.gms.internal.measurement.zzfd zzfdVar = (com.google.android.gms.internal.measurement.zzfd) it.next();
                zzay();
                zzg();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzfdVar);
                if (!zzfdVar.zza()) {
                    this.zzu.zzaV().zze().zzb("Audience with no ID. appId", zzgt.zzl(str));
                } else {
                    int zzb4 = zzfdVar.zzb();
                    Iterator it2 = zzfdVar.zzf().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (!((com.google.android.gms.internal.measurement.zzff) it2.next()).zza()) {
                                this.zzu.zzaV().zze().zzc("Event filter with no ID. Audience definition ignored. appId, audienceId", zzgt.zzl(str), Integer.valueOf(zzb4));
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                com.google.android.gms.internal.measurement.zzfd zzfdVar2 = (com.google.android.gms.internal.measurement.zzfd) it3.next();
                if (zzfdVar2.zza()) {
                    num = Integer.valueOf(zzfdVar2.zzb());
                } else {
                    num = null;
                }
                arrayList.add(num);
            }
            Preconditions.checkNotEmpty(str);
            zzay();
            zzg();
            SQLiteDatabase zze4 = zze();
            try {
                long zzaA = zzaA("select count(1) from audience_filter_values where app_id=?", new String[]{str});
                int i14 = 0;
                int max = Math.max(0, Math.min(2000, this.zzu.zzc().zzm(str, zzfx.zzU)));
                if (zzaA > max) {
                    ArrayList arrayList2 = new ArrayList();
                    while (true) {
                        if (i14 < arrayList.size()) {
                            Integer num2 = (Integer) arrayList.get(i14);
                            if (num2 == null) {
                                break;
                            }
                            arrayList2.add(Integer.toString(num2.intValue()));
                            i14++;
                        } else {
                            String join = TextUtils.join(",", arrayList2);
                            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
                            sb.append("(");
                            sb.append(join);
                            sb.append(")");
                            String sb2 = sb.toString();
                            StringBuilder sb3 = new StringBuilder(sb2.length() + 140);
                            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
                            sb3.append(sb2);
                            sb3.append(" order by rowid desc limit -1 offset ?)");
                            zze4.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)});
                            break;
                        }
                    }
                }
            } catch (SQLiteException e10) {
                this.zzu.zzaV().zzb().zzc("Database error querying filters. appId", zzgt.zzl(str), e10);
            }
            zze2.setTransactionSuccessful();
            zze2.endTransaction();
        } catch (Throwable th) {
            zze2.endTransaction();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbc zzah(String str, com.google.android.gms.internal.measurement.zzhs zzhsVar, String str2) {
        zzbc zzaE = zzaE("events", str, zzhsVar.zzd());
        if (zzaE == null) {
            zzib zzibVar = this.zzu;
            zzibVar.zzaV().zze().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzgt.zzl(str), zzibVar.zzl().zza(str2));
            return new zzbc(str, zzhsVar.zzd(), 1L, 1L, 1L, zzhsVar.zzf(), 0L, null, null, null, null);
        }
        long j10 = zzaE.zze + 1;
        long j11 = zzaE.zzd + 1;
        return new zzbc(zzaE.zza, zzaE.zzb, zzaE.zzc + 1, j11, j10, zzaE.zzf, zzaE.zzg, zzaE.zzh, zzaE.zzi, zzaE.zzj, zzaE.zzk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public final boolean zzai() {
        zzib zzibVar = this.zzu;
        Context zzaY = zzibVar.zzaY();
        zzibVar.zzc();
        return zzaY.getDatabasePath("google_app_measurement.db").exists();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ long zzaj(String str, String[] strArr, long j10) {
        return zzaB("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", strArr, -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzof zzau() {
        return this.zzn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01fa A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzav(String str, long j10, long j11, zzpb zzpbVar) {
        ?? r72;
        String str2;
        SQLiteDatabase zze2;
        String str3;
        String[] strArr;
        String string;
        String str4;
        String[] strArr2;
        String[] strArr3;
        Preconditions.checkNotNull(zzpbVar);
        zzg();
        zzay();
        Cursor cursor = null;
        try {
            try {
                zze2 = zze();
                r72 = TextUtils.isEmpty(str);
                str3 = "";
            } catch (SQLiteException e10) {
                e = e10;
                r72 = str;
            }
            if (r72 != 0) {
                if (j11 != -1) {
                    strArr3 = new String[]{String.valueOf(j11), String.valueOf(j10)};
                } else {
                    strArr3 = new String[]{String.valueOf(j10)};
                }
                if (j11 != -1) {
                    str3 = "rowid <= ? and ";
                }
                StringBuilder sb = new StringBuilder(str3.length() + 148);
                sb.append("select app_id, metadata_fingerprint from raw_events where ");
                sb.append(str3);
                sb.append("app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;");
                cursor = zze2.rawQuery(sb.toString(), strArr3);
                try {
                } catch (SQLiteException e11) {
                    e = e11;
                    str2 = str;
                }
                if (cursor.moveToFirst()) {
                    str2 = cursor.getString(0);
                    try {
                        string = cursor.getString(1);
                        cursor.close();
                    } catch (SQLiteException e12) {
                        e = e12;
                        this.zzu.zzaV().zzb().zzc("Data loss. Error selecting raw event. appId", zzgt.zzl(str2), e);
                    }
                } else if (cursor != null) {
                    return;
                } else {
                    return;
                }
            } else {
                try {
                    if (j11 != -1) {
                        String str5 = str;
                        strArr = new String[]{str5, String.valueOf(j11)};
                        r72 = str5;
                    } else {
                        r72 = str;
                        strArr = new String[]{str};
                    }
                    if (j11 != -1) {
                        str3 = " and rowid <= ?";
                    }
                    StringBuilder sb2 = new StringBuilder(str3.length() + 84);
                    sb2.append("select metadata_fingerprint from raw_events where app_id = ?");
                    sb2.append(str3);
                    sb2.append(" order by rowid limit 1;");
                    cursor = zze2.rawQuery(sb2.toString(), strArr);
                } catch (SQLiteException e13) {
                    e = e13;
                    str2 = r72;
                    this.zzu.zzaV().zzb().zzc("Data loss. Error selecting raw event. appId", zzgt.zzl(str2), e);
                }
                if (cursor.moveToFirst()) {
                    string = cursor.getString(0);
                    cursor.close();
                    str2 = r72;
                }
            }
            cursor = zze2.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str2, string}, null, null, "rowid", "2");
            if (!cursor.moveToFirst()) {
                this.zzu.zzaV().zzb().zzb("Raw event metadata record is missing. appId", zzgt.zzl(str2));
            } else {
                try {
                    com.google.android.gms.internal.measurement.zzid zzidVar = (com.google.android.gms.internal.measurement.zzid) ((com.google.android.gms.internal.measurement.zzic) zzpj.zzw(com.google.android.gms.internal.measurement.zzid.zzaE(), cursor.getBlob(0))).zzbc();
                    if (cursor.moveToNext()) {
                        this.zzu.zzaV().zze().zzb("Get multiple raw event metadata records, expected one. appId", zzgt.zzl(str2));
                    }
                    cursor.close();
                    Preconditions.checkNotNull(zzidVar);
                    zzpbVar.zza = zzidVar;
                    if (j11 != -1) {
                        str4 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                        strArr2 = new String[]{str2, string, String.valueOf(j11)};
                    } else {
                        str4 = "app_id = ? and metadata_fingerprint = ?";
                        strArr2 = new String[]{str2, string};
                    }
                    cursor = zze2.query("raw_events", new String[]{"rowid", "name", HeaderInterceptor.TIMESTAMP, "data"}, str4, strArr2, null, null, "rowid", null);
                    if (!cursor.moveToFirst()) {
                        this.zzu.zzaV().zze().zzb("Raw event data disappeared while in transaction. appId", zzgt.zzl(str2));
                    }
                    do {
                        long j12 = cursor.getLong(0);
                        try {
                            com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzpj.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), cursor.getBlob(3));
                            zzhrVar.zzl(cursor.getString(1));
                            zzhrVar.zzo(cursor.getLong(2));
                            if (!zzpbVar.zza(j12, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc())) {
                                break;
                            }
                        } catch (IOException e14) {
                            this.zzu.zzaV().zzb().zzc("Data loss. Failed to merge raw event. appId", zzgt.zzl(str2), e14);
                        }
                    } while (cursor.moveToNext());
                } catch (IOException e15) {
                    this.zzu.zzaV().zzb().zzc("Data loss. Failed to merge raw event metadata. appId", zzgt.zzl(str2), e15);
                }
            }
        } finally {
            if (0 != 0) {
                cursor.close();
            }
        }
    }

    public final void zzb() {
        zzay();
        zze().beginTransaction();
    }

    @Override // com.google.android.gms.measurement.internal.zzor
    protected final boolean zzbb() {
        return false;
    }

    public final void zzc() {
        zzay();
        zze().setTransactionSuccessful();
    }

    public final void zzd() {
        zzay();
        zze().endTransaction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final SQLiteDatabase zze() {
        zzg();
        try {
            return this.zzm.getWritableDatabase();
        } catch (SQLiteException e10) {
            this.zzu.zzaV().zze().zzb("Error opening database", e10);
            throw e10;
        }
    }

    public final zzbc zzf(String str, String str2) {
        return zzaE("events", str, str2);
    }

    public final void zzh(zzbc zzbcVar) {
        zzaF("events", zzbcVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0049, code lost:
    
        if (r2.moveToNext() != false) goto L٢٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x002d, code lost:
    
        if (r2.moveToFirst() != false) goto L٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002f, code lost:
    
        r1 = r2.getString(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0033, code lost:
    
        if (r1 == null) goto L١٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0035, code lost:
    
        r1 = zzaE("events", r13, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003b, code lost:
    
        if (r1 == null) goto L١٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003d, code lost:
    
        zzaF("events_snapshot", r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzi(String str) {
        zzaG("events_snapshot", str);
        Cursor cursor = null;
        try {
            try {
                cursor = zze().query("events", (String[]) Collections.singletonList("name").toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
            } catch (SQLiteException e10) {
                this.zzu.zzaV().zzb().zzc("Error creating snapshot. appId", zzgt.zzl(str), e10);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0059, code lost:
    
        if (r8 != null) goto L٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005b, code lost:
    
        zzaF("events", r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c0, code lost:
    
        if (r8 != null) goto L٩;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzj(String str) {
        boolean z10;
        zzbc zzaE;
        ArrayList arrayList = new ArrayList(Arrays.asList("name", "lifetime_count"));
        zzbc zzaE2 = zzaE("events", str, "_f");
        zzbc zzaE3 = zzaE("events", str, "_v");
        zzaG("events", str);
        Cursor cursor = null;
        boolean z11 = false;
        try {
            cursor = zze().query("events_snapshot", (String[]) arrayList.toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
        } catch (SQLiteException e10) {
            e = e10;
            z10 = false;
        } catch (Throwable th) {
            th = th;
            z10 = false;
        }
        if (!cursor.moveToFirst()) {
            cursor.close();
            if (zzaE2 == null) {
            }
            zzaF("events", zzaE2);
            zzaG("events_snapshot", str);
        }
        boolean z12 = false;
        z10 = false;
        do {
            try {
                String string = cursor.getString(0);
                if (cursor.getLong(1) >= 1) {
                    if ("_f".equals(string)) {
                        z12 = true;
                    } else if ("_v".equals(string)) {
                        z10 = true;
                    }
                }
                if (string != null && (zzaE = zzaE("events_snapshot", str, string)) != null) {
                    zzaF("events", zzaE);
                }
            } catch (SQLiteException e11) {
                e = e11;
                z11 = z12;
                try {
                    this.zzu.zzaV().zzb().zzc("Error querying snapshot. appId", zzgt.zzl(str), e);
                    z12 = z11;
                    if (cursor != null) {
                    }
                    if (!z12) {
                    }
                    if (!z10) {
                    }
                    zzaG("events_snapshot", str);
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (z11 && zzaE2 != null) {
                        zzaF("events", zzaE2);
                    } else if (!z10 && zzaE3 != null) {
                        zzaF("events", zzaE3);
                    }
                    zzaG("events_snapshot", str);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z11 = z12;
                if (cursor != null) {
                }
                if (z11) {
                }
                if (!z10) {
                    zzaF("events", zzaE3);
                }
                zzaG("events_snapshot", str);
                throw th;
            }
        } while (cursor.moveToNext());
        if (cursor != null) {
            cursor.close();
        }
        if (!z12 || zzaE2 == null) {
            if (!z10) {
            }
            zzaG("events_snapshot", str);
        }
        zzaF("events", zzaE2);
        zzaG("events_snapshot", str);
    }

    public final void zzk(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzay();
        try {
            zze().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            zzib zzibVar = this.zzu;
            zzibVar.zzaV().zzb().zzd("Error deleting user property. appId", zzgt.zzl(str), zzibVar.zzl().zzc(str2), e10);
        }
    }

    public final boolean zzl(zzpm zzpmVar) {
        Preconditions.checkNotNull(zzpmVar);
        zzg();
        zzay();
        String str = zzpmVar.zza;
        String str2 = zzpmVar.zzc;
        if (zzm(str, str2) == null) {
            if (zzpo.zzh(str2)) {
                if (zzaA("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str}) >= this.zzu.zzc().zzn(str, zzfx.zzV, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(str2)) {
                long zzaA = zzaA("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str, zzpmVar.zzb});
                this.zzu.zzc();
                if (zzaA >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzpmVar.zzb);
        contentValues.put("name", str2);
        contentValues.put("set_timestamp", Long.valueOf(zzpmVar.zzd));
        zzaw(contentValues, "value", zzpmVar.zze);
        try {
            if (zze().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                this.zzu.zzaV().zzb().zzb("Failed to insert/update user property (got -1). appId", zzgt.zzl(str));
                return true;
            }
            return true;
        } catch (SQLiteException e10) {
            this.zzu.zzaV().zzb().zzc("Error storing user property. appId", zzgt.zzl(zzpmVar.zza), e10);
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzpm zzm(String str, String str2) {
        SQLiteException e10;
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzay();
        Cursor cursor2 = null;
        try {
            cursor = zze().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                try {
                    if (cursor.moveToFirst()) {
                        long j10 = cursor.getLong(0);
                        Object zzL = zzL(cursor, 1);
                        if (zzL != null) {
                            zzpm zzpmVar = new zzpm(str, cursor.getString(2), str2, j10, zzL);
                            if (cursor.moveToNext()) {
                                this.zzu.zzaV().zzb().zzb("Got multiple records for user property, expected one. appId", zzgt.zzl(str));
                            }
                            cursor.close();
                            return zzpmVar;
                        }
                    }
                } catch (SQLiteException e11) {
                    e10 = e11;
                    zzib zzibVar = this.zzu;
                    zzibVar.zzaV().zzb().zzd("Error querying user property. appId", zzgt.zzl(str), zzibVar.zzl().zzc(str2), e10);
                    if (cursor != null) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e12) {
            e10 = e12;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x005a, code lost:
    
        if (r8 != null) goto L١٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x005c, code lost:
    
        r11.zzaV().zzb().zzb("Read invalid user property value, ignoring it. appId", com.google.android.gms.measurement.internal.zzgt.zzl(r13));
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x007c, code lost:
    
        if (r10.moveToNext() != false) goto L٣٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006e, code lost:
    
        r0.add(new com.google.android.gms.measurement.internal.zzpm(r13, r4, r5, r6, r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x003a, code lost:
    
        if (r10.moveToFirst() != false) goto L٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x003c, code lost:
    
        r5 = r10.getString(0);
        r1 = r10.getString(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0046, code lost:
    
        if (r1 != null) goto L٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0048, code lost:
    
        r1 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x004a, code lost:
    
        r4 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0050, code lost:
    
        r6 = r10.getLong(2);
        r8 = zzL(r10, 3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzn(String str) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        List arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                zzib zzibVar = this.zzu;
                zzibVar.zzc();
                cursor = zze().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
            } catch (SQLiteException e10) {
                this.zzu.zzaV().zzb().zzc("Error querying user properties. appId", zzgt.zzl(str), e10);
                arrayList = Collections.emptyList();
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b6, code lost:
    
        r0 = r9.zzaV().zzb();
        r9.zzc();
        r0.zzb("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzo(String str, String str2, String str3) {
        Cursor cursor;
        String str4;
        Cursor cursor2;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        List arrayList = new ArrayList();
        try {
            try {
                ArrayList arrayList2 = new ArrayList(3);
                arrayList2.add(str);
                StringBuilder sb = new StringBuilder("app_id=?");
                if (!TextUtils.isEmpty(str2)) {
                    str4 = str2;
                    try {
                        arrayList2.add(str4);
                        sb.append(" and origin=?");
                    } catch (SQLiteException e10) {
                        e = e10;
                        cursor = null;
                        try {
                            this.zzu.zzaV().zzb().zzd("(2)Error querying user properties", zzgt.zzl(str), str4, e);
                            arrayList = Collections.emptyList();
                            cursor2 = cursor;
                            if (cursor2 != null) {
                            }
                            return arrayList;
                        } catch (Throwable th) {
                            th = th;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                } else {
                    str4 = str2;
                }
                if (!TextUtils.isEmpty(str3)) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 1);
                    sb2.append(str3);
                    sb2.append("*");
                    arrayList2.add(sb2.toString());
                    sb.append(" and name glob ?");
                }
                String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                String sb3 = sb.toString();
                zzib zzibVar = this.zzu;
                zzibVar.zzc();
                cursor2 = zze().query("user_attributes", new String[]{"name", "set_timestamp", "value", "origin"}, sb3, strArr, null, null, "rowid", "1001");
                try {
                    try {
                        if (cursor2.moveToFirst()) {
                            while (true) {
                                int size = arrayList.size();
                                zzibVar.zzc();
                                if (size >= 1000) {
                                    break;
                                }
                                String string = cursor2.getString(0);
                                long j10 = cursor2.getLong(1);
                                Object zzL = zzL(cursor2, 2);
                                String string2 = cursor2.getString(3);
                                if (zzL == null) {
                                    try {
                                        zzibVar.zzaV().zzb().zzd("(2)Read invalid user property value, ignoring it", zzgt.zzl(str), string2, str3);
                                    } catch (SQLiteException e11) {
                                        e = e11;
                                        cursor = cursor2;
                                        str4 = string2;
                                        this.zzu.zzaV().zzb().zzd("(2)Error querying user properties", zzgt.zzl(str), str4, e);
                                        arrayList = Collections.emptyList();
                                        cursor2 = cursor;
                                        if (cursor2 != null) {
                                        }
                                        return arrayList;
                                    }
                                } else {
                                    arrayList.add(new zzpm(str, string2, string, j10, zzL));
                                }
                                if (!cursor2.moveToNext()) {
                                    break;
                                }
                                str4 = string2;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursor2;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                } catch (SQLiteException e12) {
                    e = e12;
                    cursor = cursor2;
                }
            } catch (SQLiteException e13) {
                e = e13;
                str4 = str2;
            }
            if (cursor2 != null) {
                cursor2.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    public final boolean zzp(zzah zzahVar) {
        Preconditions.checkNotNull(zzahVar);
        zzg();
        zzay();
        String str = zzahVar.zza;
        Preconditions.checkNotNull(str);
        if (zzm(str, zzahVar.zzc.zzb) == null) {
            long zzaA = zzaA("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.zzu.zzc();
            if (zzaA >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzahVar.zzb);
        contentValues.put("name", zzahVar.zzc.zzb);
        zzaw(contentValues, "value", Preconditions.checkNotNull(zzahVar.zzc.zza()));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzahVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzahVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzahVar.zzh));
        zzib zzibVar = this.zzu;
        contentValues.put("timed_out_event", zzibVar.zzk().zzae(zzahVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzahVar.zzd));
        contentValues.put("triggered_event", zzibVar.zzk().zzae(zzahVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzahVar.zzc.zzc));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzahVar.zzj));
        contentValues.put("expired_event", zzibVar.zzk().zzae(zzahVar.zzk));
        try {
            if (zze().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzibVar.zzaV().zzb().zzb("Failed to insert/update conditional user property (got -1)", zzgt.zzl(str));
                return true;
            }
            return true;
        } catch (SQLiteException e10) {
            this.zzu.zzaV().zzb().zzc("Error storing conditional user property", zzgt.zzl(str), e10);
            return true;
        }
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x00f4: MOVE (r9 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]) (LINE:245), block:B:32:0x00f4 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzah zzq(String str, String str2) {
        Cursor cursor;
        Cursor cursor2;
        boolean z10;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzay();
        Cursor cursor3 = null;
        try {
            try {
                cursor = zze().query("conditional_properties", new String[]{"origin", "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                } catch (SQLiteException e10) {
                    e = e10;
                    zzib zzibVar = this.zzu;
                    zzibVar.zzaV().zzb().zzd("Error querying conditional property", zzgt.zzl(str), zzibVar.zzl().zzc(str2), e);
                    if (cursor != null) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor3 = cursor2;
                if (cursor3 != null) {
                    cursor3.close();
                }
                throw th;
            }
        } catch (SQLiteException e11) {
            e = e11;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor3 != null) {
            }
            throw th;
        }
        if (cursor.moveToFirst()) {
            String string = cursor.getString(0);
            if (string == null) {
                string = "";
            }
            String str3 = string;
            Object zzL = zzL(cursor, 1);
            if (cursor.getInt(2) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            String string2 = cursor.getString(3);
            long j10 = cursor.getLong(4);
            zzpf zzpfVar = this.zzg;
            zzpj zzp = zzpfVar.zzp();
            byte[] blob = cursor.getBlob(5);
            Parcelable.Creator<zzbg> creator = zzbg.CREATOR;
            zzbg zzbgVar = (zzbg) zzp.zzl(blob, creator);
            zzah zzahVar = new zzah(str, str3, new zzpk(str2, cursor.getLong(8), zzL, str3), cursor.getLong(6), z10, string2, zzbgVar, j10, (zzbg) zzpfVar.zzp().zzl(cursor.getBlob(7), creator), cursor.getLong(9), (zzbg) zzpfVar.zzp().zzl(cursor.getBlob(10), creator));
            if (cursor.moveToNext()) {
                zzib zzibVar2 = this.zzu;
                zzibVar2.zzaV().zzb().zzc("Got multiple records for conditional property, expected one", zzgt.zzl(str), zzibVar2.zzl().zzc(str2));
            }
            cursor.close();
            return zzahVar;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    public final int zzr(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzay();
        try {
            return zze().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            zzib zzibVar = this.zzu;
            zzibVar.zzaV().zzb().zzd("Error deleting conditional property", zzgt.zzl(str), zzibVar.zzl().zzc(str2), e10);
            return 0;
        }
    }

    public final List zzs(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zzt(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0092, code lost:
    
        r20 = r11.getString(5);
        r22 = r11.getLong(6);
        r2 = r28.zzg;
        r3 = r2.zzp();
        r4 = r11.getBlob(7);
        r6 = com.google.android.gms.measurement.internal.zzbg.CREATOR;
        r21 = (com.google.android.gms.measurement.internal.zzbg) r3.zzl(r4, r6);
        r17 = r11.getLong(8);
        r24 = (com.google.android.gms.measurement.internal.zzbg) r2.zzp().zzl(r11.getBlob(9), r6);
        r9 = r11.getLong(10);
        r0.add(new com.google.android.gms.measurement.internal.zzah(r14, r15, new com.google.android.gms.measurement.internal.zzpk(r5, r9, r8, r15), r17, r19, r20, r21, r22, r24, r11.getLong(11), (com.google.android.gms.measurement.internal.zzbg) r2.zzp().zzl(r11.getBlob(12), r6)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x00fd, code lost:
    
        if (r11.moveToNext() != false) goto L٣١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0090, code lost:
    
        r19 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0056, code lost:
    
        r2 = r12.zzaV().zzb();
        r12.zzc();
        r2.zzb("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0049, code lost:
    
        if (r11.moveToFirst() != false) goto L٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x004b, code lost:
    
        r2 = r0.size();
        r12.zzc();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0054, code lost:
    
        if (r2 < 1000) goto L١٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0072, code lost:
    
        r14 = r11.getString(0);
        r15 = r11.getString(1);
        r5 = r11.getString(2);
        r8 = zzL(r11, 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x008b, code lost:
    
        if (r11.getInt(4) == 0) goto L١٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x008d, code lost:
    
        r19 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzt(String str, String[] strArr) {
        zzg();
        zzay();
        List arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase zze2 = zze();
                String[] strArr2 = {"app_id", "origin", "name", "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"};
                zzib zzibVar = this.zzu;
                zzibVar.zzc();
                cursor = zze2.query("conditional_properties", strArr2, str, strArr, null, null, "rowid", "1001");
            } catch (SQLiteException e10) {
                this.zzu.zzaV().zzb().zzb("Error querying conditional user property value", e10);
                arrayList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0300  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzh zzu(String str) {
        Cursor cursor;
        boolean z10;
        long j10;
        boolean z11;
        long j11;
        boolean z12;
        boolean z13;
        Boolean valueOf;
        String str2;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        Cursor cursor2 = null;
        try {
            cursor = zze().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", RestUrlWrapper.FIELD_APPVERSION, "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "admob_app_id", "dynamite_version", "safelisted_events", "ga_app_id", "session_stitching_token", "sgtm_upload_enabled", "target_os_version", "session_stitching_token_hash", "ad_services_version", "unmatched_first_open_without_ad_id", "npa_metadata_value", "attribution_eligibility_status", "sgtm_preview_key", "dma_consent_state", "daily_realtime_dcu_count", "bundle_delivery_index", "serialized_npa_metadata", "unmatched_pfo", "unmatched_uwa", "ad_campaign_info", "client_upload_eligibility"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                } catch (SQLiteException e10) {
                    e = e10;
                    this.zzu.zzaV().zzb().zzc("Error querying app. appId", zzgt.zzl(str), e);
                    if (cursor != null) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e11) {
            e = e11;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
        if (cursor.moveToFirst()) {
            zzpf zzpfVar = this.zzg;
            zzh zzhVar = new zzh(zzpfVar.zzaf(), str);
            zzjk zzB = zzpfVar.zzB(str);
            zzjj zzjjVar = zzjj.ANALYTICS_STORAGE;
            boolean z14 = false;
            if (zzB.zzo(zzjjVar)) {
                zzhVar.zze(cursor.getString(0));
            }
            zzhVar.zzg(cursor.getString(1));
            if (zzpfVar.zzB(str).zzo(zzjj.AD_STORAGE)) {
                zzhVar.zzk(cursor.getString(2));
            }
            zzhVar.zzF(cursor.getLong(3));
            zzhVar.zzo(cursor.getLong(4));
            zzhVar.zzq(cursor.getLong(5));
            zzhVar.zzs(cursor.getString(6));
            zzhVar.zzw(cursor.getString(7));
            zzhVar.zzy(cursor.getLong(8));
            zzhVar.zzA(cursor.getLong(9));
            if (cursor.isNull(10) || cursor.getInt(10) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            zzhVar.zzE(z10);
            zzhVar.zzO(cursor.getLong(11));
            zzhVar.zzQ(cursor.getLong(12));
            zzhVar.zzS(cursor.getLong(13));
            zzhVar.zzU(cursor.getLong(14));
            zzhVar.zzI(cursor.getLong(15));
            zzhVar.zzK(cursor.getLong(16));
            if (cursor.isNull(17)) {
                j10 = -2147483648L;
            } else {
                j10 = cursor.getInt(17);
            }
            zzhVar.zzu(j10);
            zzhVar.zzm(cursor.getString(18));
            zzhVar.zzY(cursor.getLong(19));
            zzhVar.zzW(cursor.getLong(20));
            zzhVar.zzab(cursor.getString(21));
            if (cursor.isNull(23) || cursor.getInt(23) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            zzhVar.zzad(z11);
            if (cursor.isNull(25)) {
                j11 = 0;
            } else {
                j11 = cursor.getLong(25);
            }
            zzhVar.zzC(j11);
            if (!cursor.isNull(26)) {
                zzhVar.zzah(Arrays.asList(cursor.getString(26).split(",", -1)));
            }
            if (zzpfVar.zzB(str).zzo(zzjjVar)) {
                zzhVar.zzi(cursor.getString(28));
            }
            if (!cursor.isNull(29) && cursor.getInt(29) != 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            zzhVar.zzaj(z12);
            zzhVar.zzaE(cursor.getLong(39));
            zzhVar.zzaz(cursor.getString(36));
            zzhVar.zzal(cursor.getLong(30));
            zzhVar.zzan(cursor.getLong(31));
            zzql.zza();
            zzib zzibVar = this.zzu;
            if (zzibVar.zzc().zzp(str, zzfx.zzaP)) {
                zzhVar.zzap(cursor.getInt(32));
                zzhVar.zzax(cursor.getLong(35));
            }
            if (!cursor.isNull(33) && cursor.getInt(33) != 0) {
                z13 = true;
            } else {
                z13 = false;
            }
            zzhVar.zzar(z13);
            if (cursor.isNull(34)) {
                valueOf = null;
            } else {
                if (cursor.getInt(34) != 0) {
                    z14 = true;
                }
                valueOf = Boolean.valueOf(z14);
            }
            zzhVar.zzaf(valueOf);
            zzhVar.zzaB(cursor.getInt(37));
            zzhVar.zzaD(cursor.getInt(38));
            if (cursor.isNull(40)) {
                str2 = "";
            } else {
                str2 = (String) Preconditions.checkNotNull(cursor.getString(40));
            }
            zzhVar.zzaG(str2);
            if (!cursor.isNull(41)) {
                zzhVar.zzat(Long.valueOf(cursor.getLong(41)));
            }
            if (!cursor.isNull(42)) {
                zzhVar.zzav(Long.valueOf(cursor.getLong(42)));
            }
            zzhVar.zzaI(cursor.getBlob(43));
            if (!cursor.isNull(44)) {
                zzhVar.zzaK(cursor.getInt(44));
            }
            zzhVar.zzb();
            if (cursor.moveToNext()) {
                zzibVar.zzaV().zzb().zzb("Got multiple records for app, expected one. appId", zzgt.zzl(str));
            }
            cursor.close();
            return zzhVar;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    public final void zzv(zzh zzhVar, boolean z10, boolean z11) {
        Preconditions.checkNotNull(zzhVar);
        zzg();
        zzay();
        String zzc2 = zzhVar.zzc();
        Preconditions.checkNotNull(zzc2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzc2);
        if (z10) {
            contentValues.put("app_instance_id", (String) null);
        } else if (this.zzg.zzB(zzc2).zzo(zzjj.ANALYTICS_STORAGE)) {
            contentValues.put("app_instance_id", zzhVar.zzd());
        }
        contentValues.put("gmp_app_id", zzhVar.zzf());
        zzpf zzpfVar = this.zzg;
        if (zzpfVar.zzB(zzc2).zzo(zzjj.AD_STORAGE)) {
            contentValues.put("resettable_device_id_hash", zzhVar.zzj());
        }
        contentValues.put("last_bundle_index", Long.valueOf(zzhVar.zzG()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzhVar.zzn()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzhVar.zzp()));
        contentValues.put(RestUrlWrapper.FIELD_APPVERSION, zzhVar.zzr());
        contentValues.put("app_store", zzhVar.zzv());
        contentValues.put("gmp_version", Long.valueOf(zzhVar.zzx()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzhVar.zzz()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzhVar.zzD()));
        contentValues.put("day", Long.valueOf(zzhVar.zzN()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzhVar.zzP()));
        contentValues.put("daily_events_count", Long.valueOf(zzhVar.zzR()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzhVar.zzT()));
        contentValues.put("config_fetched_time", Long.valueOf(zzhVar.zzH()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzhVar.zzJ()));
        contentValues.put("app_version_int", Long.valueOf(zzhVar.zzt()));
        contentValues.put("firebase_instance_id", zzhVar.zzl());
        contentValues.put("daily_error_events_count", Long.valueOf(zzhVar.zzX()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzhVar.zzV()));
        contentValues.put("health_monitor_sample", zzhVar.zzZ());
        contentValues.put("android_id", (Long) 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzhVar.zzac()));
        contentValues.put("dynamite_version", Long.valueOf(zzhVar.zzB()));
        if (zzpfVar.zzB(zzc2).zzo(zzjj.ANALYTICS_STORAGE)) {
            contentValues.put("session_stitching_token", zzhVar.zzh());
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(zzhVar.zzai()));
        contentValues.put("target_os_version", Long.valueOf(zzhVar.zzak()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(zzhVar.zzam()));
        zzql.zza();
        zzib zzibVar = this.zzu;
        if (zzibVar.zzc().zzp(zzc2, zzfx.zzaP)) {
            contentValues.put("ad_services_version", Integer.valueOf(zzhVar.zzao()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(zzhVar.zzaw()));
        }
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(zzhVar.zzaq()));
        contentValues.put("npa_metadata_value", zzhVar.zzae());
        contentValues.put("bundle_delivery_index", Long.valueOf(zzhVar.zzaF()));
        contentValues.put("sgtm_preview_key", zzhVar.zzay());
        contentValues.put("dma_consent_state", Integer.valueOf(zzhVar.zzaA()));
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(zzhVar.zzaC()));
        contentValues.put("serialized_npa_metadata", zzhVar.zzaH());
        contentValues.put("client_upload_eligibility", Integer.valueOf(zzhVar.zzaL()));
        List zzag = zzhVar.zzag();
        if (zzag != null) {
            if (zzag.isEmpty()) {
                zzibVar.zzaV().zze().zzb("Safelisted events should not be an empty list. appId", zzc2);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzag));
            }
        }
        com.google.android.gms.internal.measurement.zzpn.zza();
        if (zzibVar.zzc().zzp(null, zzfx.zzaK) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        contentValues.put("unmatched_pfo", zzhVar.zzas());
        contentValues.put("unmatched_uwa", zzhVar.zzau());
        contentValues.put("ad_campaign_info", zzhVar.zzaJ());
        try {
            SQLiteDatabase zze2 = zze();
            if (zze2.update("apps", contentValues, "app_id = ?", new String[]{zzc2}) == 0 && zze2.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzibVar.zzaV().zzb().zzb("Failed to insert/update app (got -1). appId", zzgt.zzl(zzc2));
            }
        } catch (SQLiteException e10) {
            this.zzu.zzaV().zzb().zzc("Error storing app. appId", zzgt.zzl(zzc2), e10);
        }
    }

    public final zzar zzw(long j10, String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        return zzx(j10, str, 1L, false, false, z12, false, z14, z15, z16);
    }

    public final zzar zzx(long j10, String str, long j11, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        String[] strArr = {str};
        zzar zzarVar = new zzar();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase zze2 = zze();
                cursor = zze2.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursor.moveToFirst()) {
                    this.zzu.zzaV().zze().zzb("Not updating daily counts, app is not known. appId", zzgt.zzl(str));
                } else {
                    if (cursor.getLong(0) == j10) {
                        zzarVar.zzb = cursor.getLong(1);
                        zzarVar.zza = cursor.getLong(2);
                        zzarVar.zzc = cursor.getLong(3);
                        zzarVar.zzd = cursor.getLong(4);
                        zzarVar.zze = cursor.getLong(5);
                        zzarVar.zzf = cursor.getLong(6);
                        zzarVar.zzg = cursor.getLong(7);
                    }
                    if (z10) {
                        zzarVar.zzb += j11;
                    }
                    if (z11) {
                        zzarVar.zza += j11;
                    }
                    if (z12) {
                        zzarVar.zzc += j11;
                    }
                    if (z13) {
                        zzarVar.zzd += j11;
                    }
                    if (z14) {
                        zzarVar.zze += j11;
                    }
                    if (z15) {
                        zzarVar.zzf += j11;
                    }
                    if (z16) {
                        zzarVar.zzg += j11;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j10));
                    contentValues.put("daily_public_events_count", Long.valueOf(zzarVar.zza));
                    contentValues.put("daily_events_count", Long.valueOf(zzarVar.zzb));
                    contentValues.put("daily_conversions_count", Long.valueOf(zzarVar.zzc));
                    contentValues.put("daily_error_events_count", Long.valueOf(zzarVar.zzd));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(zzarVar.zze));
                    contentValues.put("daily_realtime_dcu_count", Long.valueOf(zzarVar.zzf));
                    contentValues.put("daily_registered_triggers_count", Long.valueOf(zzarVar.zzg));
                    zze2.update("apps", contentValues, "app_id=?", strArr);
                }
            } catch (SQLiteException e10) {
                this.zzu.zzaV().zzb().zzc("Error updating daily counts. appId", zzgt.zzl(str), e10);
            }
            if (cursor != null) {
                cursor.close();
            }
            return zzarVar;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzaq zzy(String str) {
        SQLiteException e10;
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        Cursor cursor2 = null;
        try {
            cursor = zze().query("apps", new String[]{"remote_config", "config_last_modified_time", "e_tag"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (cursor.moveToFirst()) {
                        byte[] blob = cursor.getBlob(0);
                        String string = cursor.getString(1);
                        String string2 = cursor.getString(2);
                        if (cursor.moveToNext()) {
                            this.zzu.zzaV().zzb().zzb("Got multiple records for app config, expected one. appId", zzgt.zzl(str));
                        }
                        if (blob != null) {
                            zzaq zzaqVar = new zzaq(blob, string, string2);
                            cursor.close();
                            return zzaqVar;
                        }
                    }
                } catch (SQLiteException e11) {
                    e10 = e11;
                    this.zzu.zzaV().zzb().zzc("Error querying remote config. appId", zzgt.zzl(str), e10);
                    if (cursor != null) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e12) {
            e10 = e12;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0043, code lost:
    
        if (r3 > (com.google.android.gms.measurement.internal.zzal.zzI() + r1)) goto L٦;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzz(com.google.android.gms.internal.measurement.zzid zzidVar, boolean z10) {
        zzg();
        zzay();
        Preconditions.checkNotNull(zzidVar);
        Preconditions.checkNotEmpty(zzidVar.zzA());
        Preconditions.checkState(zzidVar.zzn());
        zzI();
        zzib zzibVar = this.zzu;
        long currentTimeMillis = zzibVar.zzaZ().currentTimeMillis();
        long zzo = zzidVar.zzo();
        zzibVar.zzc();
        if (zzo >= currentTimeMillis - zzal.zzI()) {
            long zzo2 = zzidVar.zzo();
            zzibVar.zzc();
        }
        zzibVar.zzaV().zze().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzgt.zzl(zzidVar.zzA()), Long.valueOf(currentTimeMillis), Long.valueOf(zzidVar.zzo()));
        try {
            byte[] zzv = this.zzg.zzp().zzv(zzidVar.zzcc());
            zzib zzibVar2 = this.zzu;
            zzibVar2.zzaV().zzk().zzb("Saving bundle, size", Integer.valueOf(zzv.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzidVar.zzA());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzidVar.zzo()));
            contentValues.put("data", zzv);
            contentValues.put("has_realtime", Integer.valueOf(z10 ? 1 : 0));
            if (zzidVar.zzaa()) {
                contentValues.put("retry_count", Integer.valueOf(zzidVar.zzab()));
            }
            try {
                if (zze().insert("queue", null, contentValues) == -1) {
                    zzibVar2.zzaV().zzb().zzb("Failed to insert bundle (got -1). appId", zzgt.zzl(zzidVar.zzA()));
                    return false;
                }
                return true;
            } catch (SQLiteException e10) {
                this.zzu.zzaV().zzb().zzc("Error storing bundle. appId", zzgt.zzl(zzidVar.zzA()), e10);
                return false;
            }
        } catch (IOException e11) {
            this.zzu.zzaV().zzb().zzc("Data loss. Failed to serialize bundle. appId", zzgt.zzl(zzidVar.zzA()), e11);
            return false;
        }
    }
}
