package tech.sud.runtime.component.file;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class SQLiteDBHelper {
    private static Map<Integer, SQLiteDatabase> a = new HashMap(5);
    private static int b = 0;

    public static void addColumn(int i, String str, String str2) {
        SQLiteDatabase sQLiteDatabase = a.get(Integer.valueOf(i));
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.execSQL("alter table " + str + " add " + str2 + " ");
    }

    public static void clear() {
        Iterator<Map.Entry<Integer, SQLiteDatabase>> it = a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().close();
        }
        a.clear();
    }

    public static void close(int i) {
        SQLiteDatabase sQLiteDatabase = a.get(Integer.valueOf(i));
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.close();
        a.remove(Integer.valueOf(i));
    }

    public static boolean columnExists(int i, String str, String str2) {
        SQLiteDatabase sQLiteDatabase = a.get(Integer.valueOf(i));
        boolean z = false;
        if (sQLiteDatabase == null) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.query(str, new String[]{str2}, null, null, null, null, null);
                if (cursor != null) {
                    if (cursor.getColumnIndex(str2) >= 0) {
                        z = true;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return z;
            } catch (Exception e) {
                e.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static long count(int i, String str, String str2) {
        String concat;
        long j;
        SQLiteDatabase sQLiteDatabase = a.get(Integer.valueOf(i));
        if (sQLiteDatabase == null) {
            return -1L;
        }
        if (str2.isEmpty()) {
            concat = "";
        } else {
            concat = "where id=".concat(str2);
        }
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("select count(*) " + concat, null);
            if (cursor != null && cursor.moveToFirst()) {
                j = cursor.getInt(0);
            } else {
                j = 0;
            }
            return j;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static int execSQL(int i, String str) {
        SQLiteDatabase sQLiteDatabase = a.get(Integer.valueOf(i));
        if (sQLiteDatabase == null) {
            return -1;
        }
        try {
            sQLiteDatabase.execSQL(str);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String getPrimaryKey(int i, String str) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase = a.get(Integer.valueOf(i));
        String str2 = "";
        if (sQLiteDatabase == null) {
            return "";
        }
        try {
            cursor = sQLiteDatabase.query(str, null, null, null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() >= 0) {
                        cursor.moveToFirst();
                        str2 = cursor.getColumnName(0);
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return str2;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public static int getVersion(int i) {
        SQLiteDatabase sQLiteDatabase = a.get(Integer.valueOf(i));
        if (sQLiteDatabase == null) {
            return -1;
        }
        return sQLiteDatabase.getVersion();
    }

    public static int open(String str) {
        int i = b + 1;
        b = i;
        if (!a.containsKey(Integer.valueOf(i))) {
            SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(str, (SQLiteDatabase.CursorFactory) null);
            if (openOrCreateDatabase == null) {
                return -1;
            }
            a.put(Integer.valueOf(i), openOrCreateDatabase);
        }
        return i;
    }

    public static String query(int i, String str, String str2, String str3, boolean z) {
        return query2(i, str, null, str2 + "=" + str3);
    }

    public static String query2(int i, String str, String str2, String str3) {
        Cursor query;
        SQLiteDatabase sQLiteDatabase = a.get(Integer.valueOf(i));
        String str4 = "";
        if (sQLiteDatabase == null) {
            return "";
        }
        Cursor cursor = null;
        try {
            if (str2.isEmpty()) {
                query = sQLiteDatabase.query(false, str, null, str3, null, null, null, null, null);
            } else {
                query = sQLiteDatabase.query(false, str, new String[]{str2}, str3, null, null, null, null, null);
            }
            cursor = query;
            if (cursor != null && cursor.moveToFirst()) {
                String str5 = "[";
                do {
                    String str6 = str5 + "{";
                    for (int i2 = 0; i2 < cursor.getColumnCount(); i2++) {
                        if (i2 > 0) {
                            str6 = str6 + ",";
                        }
                        str6 = str6 + '\"' + cursor.getColumnName(i2) + "\":" + cursor.getString(i2);
                    }
                    str5 = str6 + "},";
                } while (cursor.moveToNext());
                str4 = str5.substring(0, str5.length() - 1) + ']';
            }
            if (cursor != null) {
                cursor.close();
            }
            return str4;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static void setVersion(int i, int i2) {
        SQLiteDatabase sQLiteDatabase = a.get(Integer.valueOf(i));
        if (sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.setVersion(i2);
    }

    public static String sqliteStorageQueryItem(int i, String str) {
        SQLiteDatabase sQLiteDatabase = a.get(Integer.valueOf(i));
        Cursor cursor = null;
        r0 = null;
        String string = null;
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery(str, null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.moveToNext()) {
                        string = rawQuery.getString(0);
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = rawQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return string;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String sqliteStorageQueryList(int i, String str, String str2) {
        long j;
        SQLiteDatabase sQLiteDatabase = a.get(Integer.valueOf(i));
        if (sQLiteDatabase == null) {
            return "";
        }
        Cursor cursor = null;
        try {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("limitSize", 10240);
                File file = new File(str);
                if (file.exists()) {
                    j = file.length() / 1024;
                } else {
                    j = 2;
                }
                jSONObject.put("currentSize", j);
                JSONArray jSONArray = new JSONArray();
                cursor = sQLiteDatabase.rawQuery(str2, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        jSONArray.put(cursor.getString(0));
                    }
                }
                jSONObject.put("keys", jSONArray);
                String jSONObject2 = jSONObject.toString();
                if (cursor != null) {
                    cursor.close();
                }
                return jSONObject2;
            } catch (Exception e) {
                e.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                return "";
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static boolean tableExists(int i, String str) {
        SQLiteDatabase sQLiteDatabase = a.get(Integer.valueOf(i));
        boolean z = false;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return false;
        }
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '" + str + "'", null);
            if (cursor != null) {
                if (cursor.getCount() >= 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
