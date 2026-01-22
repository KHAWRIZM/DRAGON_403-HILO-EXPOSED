package androidx.room.driver;

import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import anet.channel.entity.ConnType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Landroidx/room/driver/SupportSQLiteDriver;", "Landroidx/sqlite/SQLiteDriver;", "openHelper", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "<init>", "(Landroidx/sqlite/db/SupportSQLiteOpenHelper;)V", "getOpenHelper", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", ConnType.PK_OPEN, "Landroidx/room/driver/SupportSQLiteConnection;", "fileName", "", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class SupportSQLiteDriver implements SQLiteDriver {

    @NotNull
    private final SupportSQLiteOpenHelper openHelper;

    public SupportSQLiteDriver(@NotNull SupportSQLiteOpenHelper openHelper) {
        Intrinsics.checkNotNullParameter(openHelper, "openHelper");
        this.openHelper = openHelper;
    }

    @NotNull
    public final SupportSQLiteOpenHelper getOpenHelper() {
        return this.openHelper;
    }

    @Override // androidx.sqlite.SQLiteDriver
    @NotNull
    public SupportSQLiteConnection open(@NotNull String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return new SupportSQLiteConnection(this.openHelper.getWritableDatabase());
    }
}
