package r0;

import android.database.Cursor;
import com.liulishuo.okdownload.core.breakpoint.BreakpointSQLiteKey;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final int f١٧٢٩٥a;

    /* renamed from: b, reason: collision with root package name */
    public final String f١٧٢٩٦b;

    /* renamed from: c, reason: collision with root package name */
    public final String f١٧٢٩٧c;

    /* renamed from: d, reason: collision with root package name */
    public final String f١٧٢٩٨d;

    /* renamed from: e, reason: collision with root package name */
    public final String f١٧٢٩٩e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f١٧٣٠٠f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f١٧٣٠١g;

    public i(Cursor cursor) {
        boolean z10;
        this.f١٧٢٩٥a = cursor.getInt(cursor.getColumnIndex("id"));
        this.f١٧٢٩٦b = cursor.getString(cursor.getColumnIndex("url"));
        this.f١٧٢٩٧c = cursor.getString(cursor.getColumnIndex("etag"));
        this.f١٧٢٩٨d = cursor.getString(cursor.getColumnIndex(BreakpointSQLiteKey.PARENT_PATH));
        this.f١٧٢٩٩e = cursor.getString(cursor.getColumnIndex(BreakpointSQLiteKey.FILENAME));
        if (cursor.getInt(cursor.getColumnIndex(BreakpointSQLiteKey.TASK_ONLY_PARENT_PATH)) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f١٧٣٠٠f = z10;
        this.f١٧٣٠١g = cursor.getInt(cursor.getColumnIndex("chunked")) == 1;
    }
}
