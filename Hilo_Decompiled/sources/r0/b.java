package r0;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import com.liulishuo.okdownload.core.breakpoint.BreakpointSQLiteKey;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tech.sud.gip.base.ThreadUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f١٧٢٧٤a;

    public b(c cVar) {
        this.f١٧٢٧٤a = cVar;
    }

    public final void a(SparseArray sparseArray, List list, HashMap hashMap) {
        ArrayList arrayList;
        HashMap hashMap2;
        SparseArray sparseArray2;
        ArrayList arrayList2;
        ArrayList arrayList3;
        k kVar = this.f١٧٢٧٤a.f١٧٢٧٦b;
        synchronized (kVar) {
            try {
                SparseArray sparseArray3 = kVar.f١٧٣٠٢a;
                if ((sparseArray3 == null || sparseArray3.size() <= 0) && (((arrayList = kVar.f١٧٣٠٧f) == null || arrayList.size() <= 0) && (((hashMap2 = kVar.f١٧٣٠٣b) == null || hashMap2.size() <= 0) && (((sparseArray2 = kVar.f١٧٣٠٥d) == null || sparseArray2.size() <= 0) && ((arrayList2 = kVar.f١٧٣٠٦e) == null || arrayList2.size() <= 0))))) {
                    if (sparseArray != null && kVar.f١٧٣٠٢a != null) {
                        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                            kVar.f١٧٣٠٢a.put(sparseArray.keyAt(i10), (g) sparseArray.valueAt(i10));
                        }
                        if (kVar.f١٧٣٠٦e != null) {
                            int size = sparseArray.size();
                            for (int i11 = 0; i11 < size; i11++) {
                                kVar.f١٧٣٠٦e.add(Integer.valueOf(((g) sparseArray.valueAt(i11)).f١٧٢٨٢a));
                            }
                            Collections.sort(kVar.f١٧٣٠٦e);
                        }
                    }
                    if (list != null && (arrayList3 = kVar.f١٧٣٠٧f) != null) {
                        arrayList3.addAll(list);
                    }
                    if (hashMap != null && kVar.f١٧٣٠٣b != null) {
                        for (String str : hashMap.keySet()) {
                            kVar.f١٧٣٠٣b.put(str, (String) hashMap.get(str));
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x014a  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3;
        Cursor cursor4;
        super.run();
        SQLiteDatabase writableDatabase = this.f١٧٢٧٤a.f١٧٢٧٥a.getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Cursor cursor5 = null;
        try {
            Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM breakpoint", null);
            while (rawQuery.moveToNext()) {
                try {
                    arrayList.add(new i(rawQuery));
                } catch (Throwable th) {
                    th = th;
                    cursor = null;
                }
            }
            cursor = writableDatabase.rawQuery("SELECT * FROM block", null);
            while (cursor.moveToNext()) {
                try {
                    arrayList2.add(new h(cursor));
                } catch (Throwable th2) {
                    th = th2;
                    cursor5 = rawQuery;
                    if (cursor5 != null) {
                        cursor5.close();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            rawQuery.close();
            cursor.close();
            final SparseArray sparseArray = new SparseArray();
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                i iVar = (i) obj;
                g gVar = new g(iVar.f١٧٢٩٥a, iVar.f١٧٢٩٦b, new File(iVar.f١٧٢٩٨d), iVar.f١٧٢٩٩e, iVar.f١٧٣٠٠f);
                gVar.f١٧٢٨٤c = iVar.f١٧٢٩٧c;
                gVar.f١٧٢٩٠i = iVar.f١٧٣٠١g;
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    h hVar = (h) it.next();
                    if (hVar.f١٧٢٩١a == gVar.f١٧٢٨٢a) {
                        gVar.f١٧٢٨٨g.add(new e(hVar.f١٧٢٩٢b, hVar.f١٧٢٩٣c, hVar.f١٧٢٩٤d));
                        it.remove();
                        size = size;
                    }
                }
                sparseArray.put(gVar.f١٧٢٨٢a, gVar);
            }
            j jVar = this.f١٧٢٧٤a.f١٧٢٧٥a;
            jVar.getClass();
            final ArrayList arrayList3 = new ArrayList();
            try {
                try {
                    Cursor rawQuery2 = jVar.getWritableDatabase().rawQuery("SELECT * FROM taskFileDirty", null);
                    while (rawQuery2.moveToNext()) {
                        try {
                            arrayList3.add(Integer.valueOf(rawQuery2.getInt(rawQuery2.getColumnIndex("id"))));
                        } catch (Throwable th3) {
                            th = th3;
                            cursor3 = rawQuery2;
                            if (cursor3 != null) {
                            }
                            throw th;
                        }
                    }
                    rawQuery2.close();
                    SQLiteDatabase writableDatabase2 = this.f١٧٢٧٤a.f١٧٢٧٥a.getWritableDatabase();
                    final HashMap hashMap = new HashMap();
                    try {
                        Cursor rawQuery3 = writableDatabase2.rawQuery("SELECT * FROM okdownloadResponseFilename", null);
                        while (rawQuery3.moveToNext()) {
                            try {
                                hashMap.put(rawQuery3.getString(rawQuery3.getColumnIndex("url")), rawQuery3.getString(rawQuery3.getColumnIndex(BreakpointSQLiteKey.FILENAME)));
                            } catch (Throwable th4) {
                                th = th4;
                                cursor4 = rawQuery3;
                                if (cursor4 != null) {
                                    cursor4.close();
                                }
                                throw th;
                            }
                        }
                        rawQuery3.close();
                        ThreadUtils.postUITask(new Runnable() { // from class: r0.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                b.this.a(sparseArray, arrayList3, hashMap);
                            }
                        });
                    } catch (Throwable th5) {
                        th = th5;
                        cursor4 = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    cursor2 = null;
                    cursor3 = cursor2;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                cursor2 = null;
            }
        } catch (Throwable th8) {
            th = th8;
            cursor = null;
        }
    }
}
