package f3;

import android.database.sqlite.SQLiteTransactionListener;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract /* synthetic */ class a {
    public static void a(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.beginTransaction();
    }

    public static void b(SupportSQLiteDatabase supportSQLiteDatabase, SQLiteTransactionListener transactionListener) {
        Intrinsics.checkNotNullParameter(transactionListener, "transactionListener");
        supportSQLiteDatabase.beginTransactionWithListener(transactionListener);
    }

    public static void c(SupportSQLiteDatabase supportSQLiteDatabase, String sql, Object[] objArr) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        throw new UnsupportedOperationException();
    }

    public static boolean d(SupportSQLiteDatabase supportSQLiteDatabase) {
        return false;
    }
}
