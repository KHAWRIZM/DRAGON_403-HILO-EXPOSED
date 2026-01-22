package r0;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.liulishuo.okdownload.core.breakpoint.BreakpointSQLiteKey;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class j extends SQLiteOpenHelper {
    public j(Context context) {
        super(context, "sud-okdownload-breakpoint.db", (SQLiteDatabase.CursorFactory) null, 3);
    }

    public final void a(g gVar) {
        int size = gVar.f١٧٢٨٨g.size();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        for (int i10 = 0; i10 < size; i10++) {
            e eVar = (e) gVar.f١٧٢٨٨g.get(i10);
            int i11 = gVar.f١٧٢٨٢a;
            ContentValues contentValues = new ContentValues();
            contentValues.put(BreakpointSQLiteKey.HOST_ID, Integer.valueOf(i11));
            contentValues.put(BreakpointSQLiteKey.BLOCK_INDEX, Integer.valueOf(i10));
            contentValues.put(BreakpointSQLiteKey.START_OFFSET, Long.valueOf(eVar.f١٧٢٧٧a));
            contentValues.put(BreakpointSQLiteKey.CONTENT_LENGTH, Long.valueOf(eVar.f١٧٢٧٨b));
            contentValues.put(BreakpointSQLiteKey.CURRENT_OFFSET, Long.valueOf(eVar.f١٧٢٧٩c.get()));
            if (writableDatabase.insert(ChatMenuDialog.CLICK_BLOCK, null, contentValues) == -1) {
                throw new z.a("insert block " + eVar + " failed!");
            }
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("id", Integer.valueOf(gVar.f١٧٢٨٢a));
        contentValues2.put("url", gVar.f١٧٢٨٣b);
        contentValues2.put("etag", gVar.f١٧٢٨٤c);
        contentValues2.put(BreakpointSQLiteKey.PARENT_PATH, gVar.f١٧٢٨٥d.getAbsolutePath());
        contentValues2.put(BreakpointSQLiteKey.FILENAME, gVar.f١٧٢٨٧f.f١٨٨٢٤a);
        contentValues2.put(BreakpointSQLiteKey.TASK_ONLY_PARENT_PATH, Integer.valueOf(gVar.f١٧٢٨٩h ? 1 : 0));
        contentValues2.put("chunked", Integer.valueOf(gVar.f١٧٢٩٠i ? 1 : 0));
        if (writableDatabase.insert("breakpoint", null, contentValues2) != -1) {
            return;
        }
        throw new z.a("insert info " + gVar + " failed!");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS breakpoint( id INTEGER PRIMARY KEY, url VARCHAR NOT NULL, etag VARCHAR, parent_path VARCHAR NOT NULL, filename VARCHAR, task_only_parent_path TINYINT(1) DEFAULT 0, chunked TINYINT(1) DEFAULT 0)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS block( id INTEGER PRIMARY KEY AUTOINCREMENT, breakpoint_id INTEGER, block_index INTEGER, start_offset INTEGER, content_length INTEGER, current_offset INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS okdownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        setWriteAheadLoggingEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 == 1 && i11 == 2) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS okdownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
        }
        if (i10 <= 2) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
