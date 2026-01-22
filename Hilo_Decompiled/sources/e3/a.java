package e3;

import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract /* synthetic */ class a {
    public static void a(SQLiteStatement sQLiteStatement, int i10, boolean z10) {
        long j10;
        if (z10) {
            j10 = 1;
        } else {
            j10 = 0;
        }
        sQLiteStatement.mo٢٤٤bindLong(i10, j10);
    }

    public static void b(SQLiteStatement sQLiteStatement, int i10, float f10) {
        sQLiteStatement.mo٢٤٣bindDouble(i10, f10);
    }

    public static void c(SQLiteStatement sQLiteStatement, int i10, int i11) {
        sQLiteStatement.mo٢٤٤bindLong(i10, i11);
    }

    public static boolean d(SQLiteStatement sQLiteStatement, int i10) {
        if (sQLiteStatement.getLong(i10) != 0) {
            return true;
        }
        return false;
    }

    public static List e(SQLiteStatement sQLiteStatement) {
        int columnCount = sQLiteStatement.getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i10 = 0; i10 < columnCount; i10++) {
            arrayList.add(sQLiteStatement.getColumnName(i10));
        }
        return arrayList;
    }

    public static float f(SQLiteStatement sQLiteStatement, int i10) {
        return (float) sQLiteStatement.getDouble(i10);
    }

    public static int g(SQLiteStatement sQLiteStatement, int i10) {
        return (int) sQLiteStatement.getLong(i10);
    }
}
