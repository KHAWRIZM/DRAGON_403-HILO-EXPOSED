package r0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.liulishuo.okdownload.core.breakpoint.BreakpointSQLiteKey;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public final j f١٧٢٧٥a;

    /* renamed from: b, reason: collision with root package name */
    public final k f١٧٢٧٦b = new k();

    public c(Context context) {
        this.f١٧٢٧٥a = new j(context.getApplicationContext());
        new b(this).start();
    }

    @Override // r0.d
    public final void a() {
        this.f١٧٢٧٦b.getClass();
    }

    @Override // r0.d
    public final g b(n0.e eVar) {
        g b10 = this.f١٧٢٧٦b.b(eVar);
        this.f١٧٢٧٥a.a(b10);
        return b10;
    }

    @Override // r0.d
    public final boolean c(g gVar) {
        Cursor rawQuery;
        Cursor rawQuery2;
        boolean c10 = this.f١٧٢٧٦b.c(gVar);
        j jVar = this.f١٧٢٧٥a;
        SQLiteDatabase writableDatabase = jVar.getWritableDatabase();
        writableDatabase.beginTransaction();
        Cursor cursor = null;
        try {
            rawQuery = jVar.getWritableDatabase().rawQuery("SELECT id FROM breakpoint WHERE id = ? LIMIT 1", new String[]{Integer.toString(gVar.f١٧٢٨٢a)});
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (!rawQuery.moveToNext()) {
                rawQuery.close();
                writableDatabase.endTransaction();
            } else {
                int i10 = gVar.f١٧٢٨٢a;
                jVar.getWritableDatabase().delete("breakpoint", "id = ?", new String[]{String.valueOf(i10)});
                jVar.getWritableDatabase().delete(ChatMenuDialog.CLICK_BLOCK, "breakpoint_id = ?", new String[]{String.valueOf(i10)});
                jVar.a(gVar);
                writableDatabase.setTransactionSuccessful();
                rawQuery.close();
                writableDatabase.endTransaction();
            }
            String str = gVar.f١٧٢٨٧f.f١٨٨٢٤a;
            gVar.toString();
            if (gVar.f١٧٢٨٩h && str != null) {
                j jVar2 = this.f١٧٢٧٥a;
                String str2 = gVar.f١٧٢٨٣b;
                SQLiteDatabase writableDatabase2 = jVar2.getWritableDatabase();
                ContentValues contentValues = new ContentValues(2);
                contentValues.put("url", str2);
                contentValues.put(BreakpointSQLiteKey.FILENAME, str);
                synchronized (str2.intern()) {
                    try {
                        try {
                            rawQuery2 = writableDatabase2.rawQuery("SELECT filename FROM okdownloadResponseFilename WHERE url = ?", new String[]{str2});
                        } finally {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        if (rawQuery2.moveToFirst()) {
                            if (!str.equals(rawQuery2.getString(rawQuery2.getColumnIndex(BreakpointSQLiteKey.FILENAME)))) {
                                writableDatabase2.replace("okdownloadResponseFilename", null, contentValues);
                            }
                        } else {
                            writableDatabase2.insert("okdownloadResponseFilename", null, contentValues);
                        }
                        rawQuery2.close();
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = rawQuery2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                return c10;
            }
            return c10;
        } catch (Throwable th4) {
            th = th4;
            cursor = rawQuery;
            if (cursor != null) {
                cursor.close();
            }
            writableDatabase.endTransaction();
            throw th;
        }
    }

    @Override // r0.d
    public final boolean d(int i10) {
        if (this.f١٧٢٧٦b.d(i10)) {
            this.f١٧٢٧٥a.getWritableDatabase().delete("taskFileDirty", "id = ?", new String[]{String.valueOf(i10)});
            return true;
        }
        return false;
    }

    @Override // r0.d
    public final void e(int i10, int i11) {
        k kVar = this.f١٧٢٧٦b;
        if (i11 == 1) {
            kVar.remove(i10);
        } else {
            kVar.getClass();
        }
        if (i11 == 1) {
            j jVar = this.f١٧٢٧٥a;
            jVar.getWritableDatabase().delete("breakpoint", "id = ?", new String[]{String.valueOf(i10)});
            jVar.getWritableDatabase().delete(ChatMenuDialog.CLICK_BLOCK, "breakpoint_id = ?", new String[]{String.valueOf(i10)});
        }
    }

    @Override // r0.d
    public final boolean f(int i10) {
        if (this.f١٧٢٧٦b.f(i10)) {
            SQLiteDatabase writableDatabase = this.f١٧٢٧٥a.getWritableDatabase();
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("id", Integer.valueOf(i10));
            writableDatabase.insert("taskFileDirty", null, contentValues);
            return true;
        }
        return false;
    }

    @Override // r0.d
    public final void g(g gVar, int i10, long j10) {
        this.f١٧٢٧٦b.g(gVar, i10, j10);
        long j11 = ((e) gVar.f١٧٢٨٨g.get(i10)).f١٧٢٧٩c.get();
        j jVar = this.f١٧٢٧٥a;
        jVar.getClass();
        ContentValues contentValues = new ContentValues();
        contentValues.put(BreakpointSQLiteKey.CURRENT_OFFSET, Long.valueOf(j11));
        jVar.getWritableDatabase().update(ChatMenuDialog.CLICK_BLOCK, contentValues, "breakpoint_id = ? AND block_index = ?", new String[]{Integer.toString(gVar.f١٧٢٨٢a), Integer.toString(i10)});
    }

    @Override // r0.d
    public final g get(int i10) {
        return (g) this.f١٧٢٧٦b.f١٧٣٠٢a.get(i10);
    }

    @Override // r0.d
    public final void remove(int i10) {
        this.f١٧٢٧٦b.remove(i10);
        j jVar = this.f١٧٢٧٥a;
        jVar.getWritableDatabase().delete("breakpoint", "id = ?", new String[]{String.valueOf(i10)});
        jVar.getWritableDatabase().delete(ChatMenuDialog.CLICK_BLOCK, "breakpoint_id = ?", new String[]{String.valueOf(i10)});
    }
}
