package r0;

import android.database.Cursor;
import com.liulishuo.okdownload.core.breakpoint.BreakpointSQLiteKey;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final int f١٧٢٩١a;

    /* renamed from: b, reason: collision with root package name */
    public final long f١٧٢٩٢b;

    /* renamed from: c, reason: collision with root package name */
    public final long f١٧٢٩٣c;

    /* renamed from: d, reason: collision with root package name */
    public final long f١٧٢٩٤d;

    public h(Cursor cursor) {
        this.f١٧٢٩١a = cursor.getInt(cursor.getColumnIndex(BreakpointSQLiteKey.HOST_ID));
        this.f١٧٢٩٢b = cursor.getInt(cursor.getColumnIndex(BreakpointSQLiteKey.START_OFFSET));
        this.f١٧٢٩٣c = cursor.getInt(cursor.getColumnIndex(BreakpointSQLiteKey.CONTENT_LENGTH));
        this.f١٧٢٩٤d = cursor.getInt(cursor.getColumnIndex(BreakpointSQLiteKey.CURRENT_OFFSET));
    }
}
