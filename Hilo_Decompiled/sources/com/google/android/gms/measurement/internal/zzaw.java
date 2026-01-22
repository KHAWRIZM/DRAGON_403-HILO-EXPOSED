package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzaw {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
    
        if (r2 == false) goto L٢٠;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void zza(zzgt zzgtVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        SQLiteException e10;
        Cursor cursor;
        if (zzgtVar != null) {
            Cursor cursor2 = null;
            try {
                cursor = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    try {
                        boolean moveToFirst = cursor.moveToFirst();
                        cursor.close();
                    } catch (SQLiteException e11) {
                        e10 = e11;
                        zzgtVar.zze().zzc("Error querying for table", str, e10);
                        if (cursor != null) {
                            cursor.close();
                        }
                        sQLiteDatabase.execSQL(str2);
                        try {
                            HashSet hashSet = new HashSet();
                            StringBuilder sb = new StringBuilder(str.length() + 22);
                            sb.append("SELECT * FROM ");
                            sb.append(str);
                            sb.append(" LIMIT 0");
                            Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
                            try {
                                Collections.addAll(hashSet, rawQuery.getColumnNames());
                                rawQuery.close();
                                for (String str4 : str3.split(",")) {
                                    if (!hashSet.remove(str4)) {
                                        StringBuilder sb2 = new StringBuilder(str.length() + 35 + String.valueOf(str4).length());
                                        sb2.append("Table ");
                                        sb2.append(str);
                                        sb2.append(" is missing required column: ");
                                        sb2.append(str4);
                                        throw new SQLiteException(sb2.toString());
                                    }
                                }
                                if (strArr != null) {
                                    for (int i10 = 0; i10 < strArr.length; i10 += 2) {
                                        if (!hashSet.remove(strArr[i10])) {
                                            sQLiteDatabase.execSQL(strArr[i10 + 1]);
                                        }
                                    }
                                }
                                if (!hashSet.isEmpty()) {
                                    zzgtVar.zze().zzc("Table has extra columns. table, columns", str, TextUtils.join(", ", hashSet));
                                }
                            } catch (Throwable th) {
                                rawQuery.close();
                                throw th;
                            }
                        } catch (SQLiteException e12) {
                            zzgtVar.zzb().zzb("Failed to verify columns on table that was just created", str);
                            throw e12;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e13) {
                e10 = e13;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                if (cursor2 != null) {
                }
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Monitor must not be null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(zzgt zzgtVar, SQLiteDatabase sQLiteDatabase) {
        if (zzgtVar != null) {
            com.google.android.gms.internal.measurement.zzbv.zza();
            String path = sQLiteDatabase.getPath();
            int i10 = com.google.android.gms.internal.measurement.zzca.zzb;
            File file = new File(path);
            if (!file.setReadable(false, false)) {
                zzgtVar.zze().zza("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                zzgtVar.zze().zza("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                zzgtVar.zze().zza("Failed to turn on database read permission for owner");
            }
            if (!file.setWritable(true, true)) {
                zzgtVar.zze().zza("Failed to turn on database write permission for owner");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }
}
