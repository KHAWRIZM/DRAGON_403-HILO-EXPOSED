package androidx.room.migration;

import androidx.room.driver.SupportSQLiteConnection;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract /* synthetic */ class a {
    public static void a(AutoMigrationSpec autoMigrationSpec, SQLiteConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (connection instanceof SupportSQLiteConnection) {
            autoMigrationSpec.onPostMigrate(((SupportSQLiteConnection) connection).getDb());
        }
    }

    public static void b(AutoMigrationSpec autoMigrationSpec, SupportSQLiteDatabase db2) {
        Intrinsics.checkNotNullParameter(db2, "db");
    }
}
