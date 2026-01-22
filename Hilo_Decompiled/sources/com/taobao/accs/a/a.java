package com.taobao.accs.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.UtilityImpl;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a extends SQLiteOpenHelper {
    private static volatile a c;
    private static final Lock e = new ReentrantLock();
    public int a;
    LinkedList<C٠٠٠٥a> b;
    private Context d;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.taobao.accs.a.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class C٠٠٠٥a {
        String a;
        Object[] b;

        private C٠٠٠٥a(String str, Object[] objArr) {
            this.a = str;
            this.b = objArr;
        }
    }

    private a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.a = 0;
        this.b = new LinkedList<>();
        this.d = context;
    }

    public static a a(Context context) {
        if (c == null) {
            synchronized (a.class) {
                try {
                    if (c == null) {
                        c = new a(context, Constants.DB_NAME, null, 3);
                    }
                } finally {
                }
            }
        }
        return c;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        if (!AdapterUtilityImpl.checkIsWritable(super.getWritableDatabase().getPath(), 102400)) {
            return null;
        }
        return super.getWritableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            Lock lock = e;
            if (lock.tryLock()) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS traffic(_id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT, host TEXT,serviceid TEXT, bid TEXT, isbackground TEXT, size TEXT)");
            }
            lock.unlock();
        } catch (Throwable th) {
            e.unlock();
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < i2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS service");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS network");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ping");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS msg");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ack");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS election");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bindApp");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bindUser");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS traffic");
            onCreate(sQLiteDatabase);
        }
    }

    public void a(String str, String str2, String str3, boolean z, long j, String str4) {
        if (!a(str, str3, z, str4)) {
            a("INSERT INTO traffic VALUES(null,?,?,?,?,?,?)", new Object[]{str4, str, str2, str3, String.valueOf(z), Long.valueOf(j)}, true);
        } else {
            a("UPDATE traffic SET size=? WHERE date=? AND host=? AND bid=? AND isbackground=?", new Object[]{Long.valueOf(j), str4, str, str3, String.valueOf(z)}, true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
    
        if (r1 == null) goto L٢٨;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean a(String str, String str2, boolean z, String str3) {
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase == null) {
                    return false;
                }
                cursor = writableDatabase.query("traffic", new String[]{"_id", "date", Constants.KEY_HOST, "serviceid", "bid", "isbackground", "size"}, "date=? AND host=? AND bid=? AND isbackground=?", new String[]{str3, str, str2, String.valueOf(z)}, null, null, null, String.valueOf(100));
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        cursor.close();
                        return true;
                    }
                }
            } catch (Exception e2) {
                ALog.w("DBHelper", e2.toString(), new Object[0]);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public void a() {
        a("DELETE FROM traffic", null, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x007a, code lost:
    
        if (r13.moveToFirst() != false) goto L٢٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007c, code lost:
    
        r3 = r13.getString(1);
        r7 = r13.getString(2);
        r5 = r13.getString(3);
        r4 = r13.getString(4);
        r6 = java.lang.Boolean.valueOf(r13.getString(5)).booleanValue();
        r8 = r13.getLong(6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a2, code lost:
    
        if (r4 == null) goto L٣٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a8, code lost:
    
        if (r8 <= 0) goto L٣٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00aa, code lost:
    
        r0.add(new com.taobao.accs.ut.monitor.TrafficsMonitor.a(r3, r4, r5, r6, r7, r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c1, code lost:
    
        if (r13.moveToNext() != false) goto L٥٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c3, code lost:
    
        r13.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<TrafficsMonitor.a> a(boolean z) {
        Cursor query;
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    if (writableDatabase == null) {
                        return null;
                    }
                    if (z) {
                        query = writableDatabase.query("traffic", new String[]{"_id", "date", Constants.KEY_HOST, "serviceid", "bid", "isbackground", "size"}, "date=?", new String[]{UtilityImpl.a(System.currentTimeMillis())}, null, null, null, String.valueOf(100));
                    } else {
                        query = writableDatabase.query("traffic", new String[]{"_id", "date", Constants.KEY_HOST, "serviceid", "bid", "isbackground", "size"}, null, null, null, null, null, String.valueOf(100));
                    }
                    if (query == null) {
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    }
                    try {
                    } catch (Exception e2) {
                        cursor = query;
                        e = e2;
                        ALog.w("DBHelper", e.toString(), new Object[0]);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        cursor = query;
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0055, code lost:
    
        com.taobao.accs.utl.ALog.d("DBHelper", "db is full!", new java.lang.Object[0]);
        onUpgrade(r5, 0, 1);
        r4.a = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void a(String str, Object[] objArr, boolean z) {
        try {
            this.b.add(new C٠٠٠٥a(str, objArr));
            if (this.b.size() > 5 || z) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase == null) {
                    return;
                }
                while (true) {
                    try {
                        if (this.b.size() <= 0) {
                            break;
                        }
                        C٠٠٠٥a removeFirst = this.b.removeFirst();
                        Object[] objArr2 = removeFirst.b;
                        if (objArr2 != null) {
                            writableDatabase.execSQL(removeFirst.a, objArr2);
                        } else {
                            writableDatabase.execSQL(removeFirst.a);
                        }
                        if (removeFirst.a.contains("INSERT")) {
                            int i = this.a + 1;
                            this.a = i;
                            if (i > 4000) {
                                break;
                            }
                        }
                    } catch (Throwable th) {
                        writableDatabase.close();
                        throw th;
                    }
                }
                writableDatabase.close();
            }
        } catch (Exception e2) {
            ALog.d("DBHelper", e2.toString(), new Object[0]);
        } finally {
        }
    }
}
