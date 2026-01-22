package com.qiahao.base_common.room.dataBase;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.qiahao.base_common.room.roomDao.DownloadFileDao;
import com.qiahao.base_common.room.roomModel.DownloadFile;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Database(entities = {DownloadFile.class}, exportSchema = false, version = 1)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/qiahao/base_common/room/dataBase/AppDataBase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "downloadFileDao", "Lcom/qiahao/base_common/room/roomDao/DownloadFileDao;", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class AppDataBase extends RoomDatabase {

    @Nullable
    private static volatile AppDataBase INSTANCE;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final AppDataBase$Companion$roomCallback$1 roomCallback = new RoomDatabase.Callback() { // from class: com.qiahao.base_common.room.dataBase.AppDataBase$Companion$roomCallback$1
        @Override // androidx.room.RoomDatabase.Callback
        public void onCreate(SupportSQLiteDatabase db2) {
            Intrinsics.checkNotNullParameter(db2, "db");
            super.onCreate(db2);
        }

        @Override // androidx.room.RoomDatabase.Callback
        public void onOpen(SupportSQLiteDatabase db2) {
            Intrinsics.checkNotNullParameter(db2, "db");
            super.onOpen(db2);
        }
    };

    @NotNull
    private static final AppDataBase$Companion$MIGRATION_1_2$1 MIGRATION_1_2 = new Migration() { // from class: com.qiahao.base_common.room.dataBase.AppDataBase$Companion$MIGRATION_1_2$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db2) {
            Intrinsics.checkNotNullParameter(db2, "db");
            db2.execSQL("ALTER TABLE users ADD COLUMN email TEXT");
        }
    };

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0002\n\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/qiahao/base_common/room/dataBase/AppDataBase$Companion;", "", "<init>", "()V", "INSTANCE", "Lcom/qiahao/base_common/room/dataBase/AppDataBase;", "getDatabase", "context", "Landroid/content/Context;", "roomCallback", "com/qiahao/base_common/room/dataBase/AppDataBase$Companion$roomCallback$1", "Lcom/qiahao/base_common/room/dataBase/AppDataBase$Companion$roomCallback$1;", "MIGRATION_1_2", "com/qiahao/base_common/room/dataBase/AppDataBase$Companion$MIGRATION_1_2$1", "Lcom/qiahao/base_common/room/dataBase/AppDataBase$Companion$MIGRATION_1_2$1;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AppDataBase getDatabase(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            AppDataBase appDataBase = AppDataBase.INSTANCE;
            if (appDataBase == null) {
                synchronized (this) {
                    appDataBase = (AppDataBase) Room.databaseBuilder(context, AppDataBase.class, "app_database").build();
                    AppDataBase.INSTANCE = appDataBase;
                }
            }
            return appDataBase;
        }

        private Companion() {
        }
    }

    @NotNull
    public abstract DownloadFileDao downloadFileDao();
}
