package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import com.alibaba.sdk.android.tbrest.rest.RestUrlWrapper;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzgk extends zzg {
    private static final String[] zza = {RestUrlWrapper.FIELD_APPVERSION, "ALTER TABLE messages ADD COLUMN app_version TEXT;", "app_version_int", "ALTER TABLE messages ADD COLUMN app_version_int INTEGER;"};
    private final zzgi zzb;
    private boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgk(zzib zzibVar) {
        super(zzibVar);
        Context zzaY = this.zzu.zzaY();
        this.zzu.zzc();
        this.zzb = new zzgi(this, zzaY, "google_app_measurement_local.db");
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean zzs(int i10, byte[] bArr) {
        zzr zzrVar;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        zzg();
        boolean z10 = false;
        z10 = false;
        if (!this.zzc) {
            zzib zzibVar = this.zzu;
            zzal zzc = zzibVar.zzc();
            zzfw zzfwVar = zzfx.zzbc;
            Cursor cursor2 = null;
            if (zzc.zzp(null, zzfwVar)) {
                zzrVar = this.zzu.zzv().zzh(null);
            } else {
                zzrVar = null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("type", Integer.valueOf(i10));
            contentValues.put("entry", bArr);
            if (zzibVar.zzc().zzp(null, zzfwVar) && zzrVar != null) {
                contentValues.put(RestUrlWrapper.FIELD_APPVERSION, zzrVar.zzc);
                contentValues.put("app_version_int", Long.valueOf(zzrVar.zzj));
            }
            zzibVar.zzc();
            int i11 = 0;
            int i12 = 5;
            for (int i13 = 5; i11 < i13; i13 = 5) {
                try {
                    sQLiteDatabase = zzp();
                    if (sQLiteDatabase == null) {
                        this.zzc = true;
                    } else {
                        try {
                            sQLiteDatabase.beginTransaction();
                            cursor = sQLiteDatabase.rawQuery("select count(1) from messages", null);
                            long j10 = 0;
                            if (cursor != null) {
                                try {
                                    if (cursor.moveToFirst()) {
                                        j10 = cursor.getLong(z10 ? 1 : 0);
                                    }
                                } catch (SQLiteDatabaseLockedException unused) {
                                    SystemClock.sleep(i12);
                                    i12 += 20;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (sQLiteDatabase == null) {
                                        i11++;
                                        z10 = false;
                                    }
                                    sQLiteDatabase.close();
                                    i11++;
                                    z10 = false;
                                } catch (SQLiteFullException e10) {
                                    e = e10;
                                    this.zzu.zzaV().zzb().zzb("Error writing entry; local database full", e);
                                    this.zzc = true;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (sQLiteDatabase == null) {
                                        i11++;
                                        z10 = false;
                                    }
                                    sQLiteDatabase.close();
                                    i11++;
                                    z10 = false;
                                } catch (SQLiteException e11) {
                                    e = e11;
                                    if (sQLiteDatabase != null) {
                                        try {
                                            if (sQLiteDatabase.inTransaction()) {
                                                sQLiteDatabase.endTransaction();
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            cursor2 = cursor;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            if (sQLiteDatabase != null) {
                                                sQLiteDatabase.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    this.zzu.zzaV().zzb().zzb("Error writing entry to local database", e);
                                    this.zzc = true;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (sQLiteDatabase == null) {
                                        i11++;
                                        z10 = false;
                                    }
                                    sQLiteDatabase.close();
                                    i11++;
                                    z10 = false;
                                }
                            }
                            if (j10 >= 100000) {
                                zzibVar.zzaV().zzb().zza("Data loss, local db full");
                                long j11 = 100001 - j10;
                                long delete = sQLiteDatabase.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[]{Long.toString(j11)});
                                if (delete != j11) {
                                    zzibVar.zzaV().zzb().zzd("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j11), Long.valueOf(delete), Long.valueOf(j11 - delete));
                                }
                            }
                            sQLiteDatabase.insertOrThrow("messages", null, contentValues);
                            sQLiteDatabase.setTransactionSuccessful();
                            sQLiteDatabase.endTransaction();
                            if (cursor != null) {
                                cursor.close();
                            }
                            sQLiteDatabase.close();
                            return true;
                        } catch (SQLiteDatabaseLockedException unused2) {
                            cursor = null;
                        } catch (SQLiteFullException e12) {
                            e = e12;
                            cursor = null;
                        } catch (SQLiteException e13) {
                            e = e13;
                            cursor = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor2 != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            throw th;
                        }
                    }
                } catch (SQLiteDatabaseLockedException unused3) {
                    sQLiteDatabase = null;
                    cursor = null;
                } catch (SQLiteFullException e14) {
                    e = e14;
                    sQLiteDatabase = null;
                    cursor = null;
                } catch (SQLiteException e15) {
                    e = e15;
                    sQLiteDatabase = null;
                    cursor = null;
                } catch (Throwable th3) {
                    th = th3;
                    sQLiteDatabase = null;
                }
            }
            this.zzu.zzaV().zzk().zza("Failed to write entry to local database");
            return false;
        }
        return z10;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return false;
    }

    public final void zzh() {
        int delete;
        zzg();
        try {
            SQLiteDatabase zzp = zzp();
            if (zzp != null && (delete = zzp.delete("messages", null, null)) > 0) {
                this.zzu.zzaV().zzk().zzb("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e10) {
            this.zzu.zzaV().zzb().zzb("Error resetting local analytics data. error", e10);
        }
    }

    public final boolean zzi(zzbg zzbgVar) {
        Parcel obtain = Parcel.obtain();
        zzbh.zza(zzbgVar, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            this.zzu.zzaV().zzc().zza("Event is too long for local database. Sending event directly to service");
            return false;
        }
        return zzs(0, marshall);
    }

    public final boolean zzj(zzpk zzpkVar) {
        Parcel obtain = Parcel.obtain();
        zzpl.zza(zzpkVar, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            this.zzu.zzaV().zzc().zza("User property too long for local database. Sending directly to service");
            return false;
        }
        return zzs(1, marshall);
    }

    public final boolean zzk(zzah zzahVar) {
        zzib zzibVar = this.zzu;
        byte[] zzae = zzibVar.zzk().zzae(zzahVar);
        if (zzae.length > 131072) {
            zzibVar.zzaV().zzc().zza("Conditional user property too long for local database. Sending directly to service");
            return false;
        }
        return zzs(2, zzae);
    }

    public final boolean zzl(zzbe zzbeVar) {
        zzib zzibVar = this.zzu;
        byte[] zzae = zzibVar.zzk().zzae(zzbeVar);
        if (zzae == null) {
            zzibVar.zzaV().zzc().zza("Null default event parameters; not writing to database");
            return false;
        }
        if (zzae.length > 131072) {
            zzibVar.zzaV().zzc().zza("Default event parameters too long for local database. Sending directly to service");
            return false;
        }
        return zzs(4, zzae);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x02db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x035a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x035a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzm(int i10) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor2;
        SQLiteDatabase sQLiteDatabase2;
        int i11;
        Cursor cursor3;
        SQLiteDatabase sQLiteDatabase3;
        Cursor cursor4;
        Cursor cursor5;
        long j10;
        String str;
        String[] strArr;
        Cursor cursor6;
        long j11;
        String str2;
        Parcel obtain;
        zzbe zzbeVar;
        zzah zzahVar;
        zzpk zzpkVar;
        zzg();
        ?? r62 = 0;
        if (this.zzc) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (zzq()) {
            int i12 = 5;
            int i13 = 0;
            int i14 = 0;
            int i15 = 5;
            while (i14 < i12) {
                int i16 = 1;
                try {
                    SQLiteDatabase zzp = zzp();
                    if (zzp == null) {
                        this.zzc = true;
                        return r62;
                    }
                    try {
                        zzp.beginTransaction();
                        try {
                            try {
                                cursor5 = zzp.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, null, null, "rowid desc", "1");
                                try {
                                    long j12 = -1;
                                    if (cursor5.moveToFirst()) {
                                        j10 = cursor5.getLong(i13);
                                        try {
                                            cursor5.close();
                                        } catch (SQLiteDatabaseLockedException unused) {
                                            sQLiteDatabase = zzp;
                                            i11 = i14;
                                            sQLiteDatabase3 = sQLiteDatabase;
                                            cursor3 = null;
                                            SystemClock.sleep(i15);
                                            i15 += 20;
                                            if (cursor3 != null) {
                                            }
                                            if (sQLiteDatabase3 == null) {
                                            }
                                            i14 = i11 + 1;
                                            r62 = 0;
                                            i12 = 5;
                                            i13 = 0;
                                        } catch (SQLiteFullException e10) {
                                            e = e10;
                                            sQLiteDatabase = zzp;
                                            i11 = i14;
                                            cursor4 = null;
                                            try {
                                                this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                                                this.zzc = true;
                                                if (cursor4 != null) {
                                                }
                                                if (sQLiteDatabase == null) {
                                                }
                                                i14 = i11 + 1;
                                                r62 = 0;
                                                i12 = 5;
                                                i13 = 0;
                                            } catch (Throwable th) {
                                                th = th;
                                                cursor = cursor4;
                                                if (cursor != null) {
                                                    cursor.close();
                                                }
                                                if (sQLiteDatabase != null) {
                                                    sQLiteDatabase.close();
                                                }
                                                throw th;
                                            }
                                        } catch (SQLiteException e11) {
                                            e = e11;
                                            sQLiteDatabase = zzp;
                                            sQLiteDatabase2 = sQLiteDatabase;
                                            cursor2 = null;
                                            if (sQLiteDatabase2 != null) {
                                            }
                                            this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                                            this.zzc = true;
                                            if (cursor2 != null) {
                                            }
                                            if (sQLiteDatabase2 != null) {
                                            }
                                            i11 = i14;
                                            i14 = i11 + 1;
                                            r62 = 0;
                                            i12 = 5;
                                            i13 = 0;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            sQLiteDatabase = zzp;
                                            cursor = null;
                                            if (cursor != null) {
                                            }
                                            if (sQLiteDatabase != null) {
                                            }
                                            throw th;
                                        }
                                    } else {
                                        cursor5.close();
                                        j10 = -1;
                                    }
                                    if (j10 != -1) {
                                        String[] strArr2 = new String[1];
                                        strArr2[i13] = String.valueOf(j10);
                                        str = "rowid<?";
                                        strArr = strArr2;
                                    } else {
                                        str = r62;
                                        strArr = str;
                                    }
                                    String[] strArr3 = {"rowid", "type", "entry"};
                                    zzib zzibVar = this.zzu;
                                    zzal zzc = zzibVar.zzc();
                                    zzfw zzfwVar = zzfx.zzbc;
                                    boolean zzp2 = zzc.zzp(r62, zzfwVar);
                                    int i17 = 2;
                                    if (zzp2) {
                                        strArr3 = new String[i12];
                                        strArr3[i13] = "rowid";
                                        strArr3[1] = "type";
                                        strArr3[2] = "entry";
                                        strArr3[3] = RestUrlWrapper.FIELD_APPVERSION;
                                        strArr3[4] = "app_version_int";
                                    }
                                    Cursor query = zzp.query("messages", strArr3, str, strArr, null, null, "rowid asc", Integer.toString(100));
                                    while (query.moveToNext()) {
                                        try {
                                            try {
                                                j12 = query.getLong(i13);
                                                int i18 = query.getInt(i16);
                                                byte[] blob = query.getBlob(i17);
                                                if (zzibVar.zzc().zzp(null, zzfwVar)) {
                                                    String string = query.getString(3);
                                                    j11 = query.getLong(4);
                                                    str2 = string;
                                                } else {
                                                    j11 = 0;
                                                    str2 = null;
                                                }
                                                long j13 = j11;
                                                cursor6 = query;
                                                if (i18 == 0) {
                                                    try {
                                                        obtain = Parcel.obtain();
                                                        try {
                                                            try {
                                                                obtain.unmarshall(blob, i13, blob.length);
                                                                obtain.setDataPosition(i13);
                                                                zzbg createFromParcel = zzbg.CREATOR.createFromParcel(obtain);
                                                                if (createFromParcel != null) {
                                                                    arrayList.add(new zzgj(createFromParcel, str2, j13));
                                                                }
                                                            } finally {
                                                            }
                                                        } catch (SafeParcelReader.ParseException unused2) {
                                                            this.zzu.zzaV().zzb().zza("Failed to load event from local database");
                                                            obtain.recycle();
                                                        }
                                                    } catch (SQLiteDatabaseLockedException unused3) {
                                                        sQLiteDatabase = zzp;
                                                        i11 = i14;
                                                        sQLiteDatabase3 = sQLiteDatabase;
                                                        cursor3 = cursor6;
                                                        SystemClock.sleep(i15);
                                                        i15 += 20;
                                                        if (cursor3 != null) {
                                                        }
                                                        if (sQLiteDatabase3 == null) {
                                                        }
                                                        i14 = i11 + 1;
                                                        r62 = 0;
                                                        i12 = 5;
                                                        i13 = 0;
                                                    } catch (SQLiteFullException e12) {
                                                        e = e12;
                                                        sQLiteDatabase = zzp;
                                                        i11 = i14;
                                                        cursor4 = cursor6;
                                                        this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                                                        this.zzc = true;
                                                        if (cursor4 != null) {
                                                        }
                                                        if (sQLiteDatabase == null) {
                                                        }
                                                        i14 = i11 + 1;
                                                        r62 = 0;
                                                        i12 = 5;
                                                        i13 = 0;
                                                    } catch (SQLiteException e13) {
                                                        e = e13;
                                                        sQLiteDatabase = zzp;
                                                        sQLiteDatabase2 = sQLiteDatabase;
                                                        cursor2 = cursor6;
                                                        if (sQLiteDatabase2 != null) {
                                                        }
                                                        this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                                                        this.zzc = true;
                                                        if (cursor2 != null) {
                                                        }
                                                        if (sQLiteDatabase2 != null) {
                                                        }
                                                        i11 = i14;
                                                        i14 = i11 + 1;
                                                        r62 = 0;
                                                        i12 = 5;
                                                        i13 = 0;
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        sQLiteDatabase = zzp;
                                                        cursor = cursor6;
                                                        if (cursor != null) {
                                                        }
                                                        if (sQLiteDatabase != null) {
                                                        }
                                                        throw th;
                                                    }
                                                } else if (i18 == 1) {
                                                    obtain = Parcel.obtain();
                                                    try {
                                                        try {
                                                            obtain.unmarshall(blob, i13, blob.length);
                                                            obtain.setDataPosition(i13);
                                                            zzpkVar = zzpk.CREATOR.createFromParcel(obtain);
                                                        } finally {
                                                        }
                                                    } catch (SafeParcelReader.ParseException unused4) {
                                                        this.zzu.zzaV().zzb().zza("Failed to load user property from local database");
                                                        obtain.recycle();
                                                        zzpkVar = null;
                                                    }
                                                    if (zzpkVar != null) {
                                                        arrayList.add(new zzgj(zzpkVar, str2, j13));
                                                    }
                                                } else if (i18 == 2) {
                                                    obtain = Parcel.obtain();
                                                    try {
                                                        try {
                                                            obtain.unmarshall(blob, i13, blob.length);
                                                            obtain.setDataPosition(i13);
                                                            zzahVar = zzah.CREATOR.createFromParcel(obtain);
                                                        } finally {
                                                        }
                                                    } catch (SafeParcelReader.ParseException unused5) {
                                                        this.zzu.zzaV().zzb().zza("Failed to load conditional user property from local database");
                                                        obtain.recycle();
                                                        zzahVar = null;
                                                    }
                                                    if (zzahVar != null) {
                                                        arrayList.add(new zzgj(zzahVar, str2, j13));
                                                    }
                                                } else if (i18 == 4) {
                                                    obtain = Parcel.obtain();
                                                    try {
                                                        try {
                                                            obtain.unmarshall(blob, i13, blob.length);
                                                            obtain.setDataPosition(i13);
                                                            zzbeVar = zzbe.CREATOR.createFromParcel(obtain);
                                                        } finally {
                                                        }
                                                    } catch (SafeParcelReader.ParseException unused6) {
                                                        this.zzu.zzaV().zzb().zza("Failed to load default event parameters from local database");
                                                        obtain.recycle();
                                                        zzbeVar = null;
                                                    }
                                                    if (zzbeVar != null) {
                                                        arrayList.add(new zzgj(zzbeVar, str2, j13));
                                                    }
                                                } else {
                                                    if (i18 == 3) {
                                                        this.zzu.zzaV().zzk().zza("Skipping app launch break");
                                                    } else {
                                                        this.zzu.zzaV().zzb().zza("Unknown record type in local database");
                                                    }
                                                    query = cursor6;
                                                    i17 = 2;
                                                    i16 = 1;
                                                }
                                                query = cursor6;
                                                i17 = 2;
                                                i16 = 1;
                                            } catch (SQLiteDatabaseLockedException unused7) {
                                                cursor6 = query;
                                            } catch (SQLiteFullException e14) {
                                                e = e14;
                                                cursor6 = query;
                                            } catch (SQLiteException e15) {
                                                e = e15;
                                                cursor6 = query;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                cursor6 = query;
                                            }
                                        } catch (SQLiteDatabaseLockedException unused8) {
                                            sQLiteDatabase = zzp;
                                            cursor6 = query;
                                        } catch (SQLiteFullException e16) {
                                            e = e16;
                                            sQLiteDatabase = zzp;
                                            cursor6 = query;
                                        } catch (SQLiteException e17) {
                                            e = e17;
                                            sQLiteDatabase = zzp;
                                            cursor6 = query;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            sQLiteDatabase = zzp;
                                            cursor6 = query;
                                        }
                                    }
                                    cursor6 = query;
                                    sQLiteDatabase = zzp;
                                    try {
                                        if (sQLiteDatabase.delete("messages", "rowid <= ?", new String[]{Long.toString(j12)}) < arrayList.size()) {
                                            this.zzu.zzaV().zzb().zza("Fewer entries removed from local database than expected");
                                        }
                                        sQLiteDatabase.setTransactionSuccessful();
                                        sQLiteDatabase.endTransaction();
                                        cursor6.close();
                                        sQLiteDatabase.close();
                                        return arrayList;
                                    } catch (SQLiteDatabaseLockedException unused9) {
                                        i11 = i14;
                                        sQLiteDatabase3 = sQLiteDatabase;
                                        cursor3 = cursor6;
                                        SystemClock.sleep(i15);
                                        i15 += 20;
                                        if (cursor3 != null) {
                                        }
                                        if (sQLiteDatabase3 == null) {
                                        }
                                        i14 = i11 + 1;
                                        r62 = 0;
                                        i12 = 5;
                                        i13 = 0;
                                    } catch (SQLiteFullException e18) {
                                        e = e18;
                                        i11 = i14;
                                        cursor4 = cursor6;
                                        this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                                        this.zzc = true;
                                        if (cursor4 != null) {
                                        }
                                        if (sQLiteDatabase == null) {
                                        }
                                        i14 = i11 + 1;
                                        r62 = 0;
                                        i12 = 5;
                                        i13 = 0;
                                    } catch (SQLiteException e19) {
                                        e = e19;
                                        sQLiteDatabase2 = sQLiteDatabase;
                                        cursor2 = cursor6;
                                        if (sQLiteDatabase2 != null) {
                                        }
                                        this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                                        this.zzc = true;
                                        if (cursor2 != null) {
                                        }
                                        if (sQLiteDatabase2 != null) {
                                        }
                                        i11 = i14;
                                        i14 = i11 + 1;
                                        r62 = 0;
                                        i12 = 5;
                                        i13 = 0;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        cursor = cursor6;
                                        if (cursor != null) {
                                        }
                                        if (sQLiteDatabase != null) {
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    sQLiteDatabase = zzp;
                                    if (cursor5 != null) {
                                        try {
                                            cursor5.close();
                                        } catch (SQLiteDatabaseLockedException unused10) {
                                            i11 = i14;
                                            sQLiteDatabase3 = sQLiteDatabase;
                                            cursor3 = null;
                                            SystemClock.sleep(i15);
                                            i15 += 20;
                                            if (cursor3 != null) {
                                                cursor3.close();
                                            }
                                            if (sQLiteDatabase3 == null) {
                                                sQLiteDatabase3.close();
                                            }
                                            i14 = i11 + 1;
                                            r62 = 0;
                                            i12 = 5;
                                            i13 = 0;
                                        } catch (SQLiteFullException e20) {
                                            e = e20;
                                            i11 = i14;
                                            cursor4 = null;
                                            this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                                            this.zzc = true;
                                            if (cursor4 != null) {
                                                cursor4.close();
                                            }
                                            if (sQLiteDatabase == null) {
                                                sQLiteDatabase.close();
                                            }
                                            i14 = i11 + 1;
                                            r62 = 0;
                                            i12 = 5;
                                            i13 = 0;
                                        } catch (SQLiteException e21) {
                                            e = e21;
                                            sQLiteDatabase2 = sQLiteDatabase;
                                            cursor2 = null;
                                            if (sQLiteDatabase2 != null) {
                                                try {
                                                    if (sQLiteDatabase2.inTransaction()) {
                                                        sQLiteDatabase2.endTransaction();
                                                    }
                                                } catch (Throwable th8) {
                                                    th = th8;
                                                    cursor = cursor2;
                                                    sQLiteDatabase = sQLiteDatabase2;
                                                    if (cursor != null) {
                                                    }
                                                    if (sQLiteDatabase != null) {
                                                    }
                                                    throw th;
                                                }
                                            }
                                            this.zzu.zzaV().zzb().zzb("Error reading entries from local database", e);
                                            this.zzc = true;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            if (sQLiteDatabase2 != null) {
                                                sQLiteDatabase2.close();
                                            }
                                            i11 = i14;
                                            i14 = i11 + 1;
                                            r62 = 0;
                                            i12 = 5;
                                            i13 = 0;
                                        } catch (Throwable th9) {
                                            th = th9;
                                            cursor = null;
                                            if (cursor != null) {
                                            }
                                            if (sQLiteDatabase != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                    throw th;
                                    break;
                                }
                            } catch (Throwable th10) {
                                th = th10;
                                sQLiteDatabase = zzp;
                                cursor5 = null;
                                if (cursor5 != null) {
                                }
                                throw th;
                                break;
                                break;
                            }
                        } catch (Throwable th11) {
                            th = th11;
                            sQLiteDatabase = zzp;
                        }
                    } catch (SQLiteDatabaseLockedException unused11) {
                        sQLiteDatabase = zzp;
                    } catch (SQLiteFullException e22) {
                        e = e22;
                        sQLiteDatabase = zzp;
                    } catch (SQLiteException e23) {
                        e = e23;
                        sQLiteDatabase = zzp;
                    } catch (Throwable th12) {
                        th = th12;
                        sQLiteDatabase = zzp;
                    }
                } catch (SQLiteDatabaseLockedException unused12) {
                    i11 = i14;
                    cursor3 = null;
                    sQLiteDatabase3 = null;
                } catch (SQLiteFullException e24) {
                    e = e24;
                    i11 = i14;
                    sQLiteDatabase = null;
                } catch (SQLiteException e25) {
                    e = e25;
                    cursor2 = null;
                    sQLiteDatabase2 = null;
                } catch (Throwable th13) {
                    th = th13;
                    cursor = null;
                    sQLiteDatabase = null;
                }
            }
            this.zzu.zzaV().zze().zza("Failed to read events from database in reasonable time");
            return null;
        }
        return arrayList;
    }

    public final boolean zzn() {
        return zzs(3, new byte[0]);
    }

    public final boolean zzo() {
        zzg();
        if (!this.zzc && zzq()) {
            int i10 = 0;
            int i11 = 5;
            while (true) {
                if (i10 < 5) {
                    SQLiteDatabase sQLiteDatabase = null;
                    try {
                        try {
                            try {
                                SQLiteDatabase zzp = zzp();
                                if (zzp == null) {
                                    this.zzc = true;
                                } else {
                                    zzp.beginTransaction();
                                    zzp.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                                    zzp.setTransactionSuccessful();
                                    zzp.endTransaction();
                                    zzp.close();
                                    return true;
                                }
                            } catch (SQLiteException e10) {
                                if (0 != 0) {
                                    try {
                                        if (sQLiteDatabase.inTransaction()) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                    } catch (Throwable th) {
                                        if (0 != 0) {
                                            sQLiteDatabase.close();
                                        }
                                        throw th;
                                    }
                                }
                                this.zzu.zzaV().zzb().zzb("Error deleting app launch break from local database", e10);
                                this.zzc = true;
                                if (0 != 0) {
                                    sQLiteDatabase.close();
                                }
                            }
                        } catch (SQLiteDatabaseLockedException unused) {
                            SystemClock.sleep(i11);
                            i11 += 20;
                            if (0 == 0) {
                            }
                            sQLiteDatabase.close();
                        }
                    } catch (SQLiteFullException e11) {
                        this.zzu.zzaV().zzb().zzb("Error deleting app launch break from local database", e11);
                        this.zzc = true;
                        if (0 == 0) {
                        }
                        sQLiteDatabase.close();
                    }
                } else {
                    this.zzu.zzaV().zze().zza("Error deleting app launch break from local database in reasonable time");
                    break;
                }
                i10++;
            }
        }
        return false;
    }

    @VisibleForTesting
    final SQLiteDatabase zzp() throws SQLiteException {
        if (this.zzc) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzb.getWritableDatabase();
        if (writableDatabase == null) {
            this.zzc = true;
            return null;
        }
        return writableDatabase;
    }

    @VisibleForTesting
    final boolean zzq() {
        zzib zzibVar = this.zzu;
        Context zzaY = zzibVar.zzaY();
        zzibVar.zzc();
        return zzaY.getDatabasePath("google_app_measurement_local.db").exists();
    }
}
