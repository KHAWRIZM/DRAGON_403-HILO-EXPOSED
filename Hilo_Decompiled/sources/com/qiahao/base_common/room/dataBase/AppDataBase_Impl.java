package com.qiahao.base_common.room.dataBase;

import androidx.room.InvalidationTracker;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenDelegate;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.qiahao.base_common.room.roomDao.DownloadFileDao;
import com.qiahao.base_common.room.roomDao.DownloadFileDao_Impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class AppDataBase_Impl extends AppDataBase {

    /* renamed from: a, reason: collision with root package name */
    private volatile DownloadFileDao f١٢٥١٣a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class a extends RoomOpenDelegate {
        a(int i10, String str, String str2) {
            super(i10, str, str2);
        }

        @Override // androidx.room.RoomOpenDelegate
        public void createAllTables(SQLiteConnection sQLiteConnection) {
            SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `download_file` (`url` TEXT NOT NULL, `localPath` TEXT, `type` INTEGER NOT NULL, PRIMARY KEY(`url`))");
            SQLite.execSQL(sQLiteConnection, RoomMasterTable.CREATE_QUERY);
            SQLite.execSQL(sQLiteConnection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'd93c3769af03eef811f39cff76da38c4')");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void dropAllTables(SQLiteConnection sQLiteConnection) {
            SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `download_file`");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void onCreate(SQLiteConnection sQLiteConnection) {
        }

        @Override // androidx.room.RoomOpenDelegate
        public void onOpen(SQLiteConnection sQLiteConnection) {
            AppDataBase_Impl.this.internalInitInvalidationTracker(sQLiteConnection);
        }

        @Override // androidx.room.RoomOpenDelegate
        public void onPostMigrate(SQLiteConnection sQLiteConnection) {
        }

        @Override // androidx.room.RoomOpenDelegate
        public void onPreMigrate(SQLiteConnection sQLiteConnection) {
            DBUtil.dropFtsSyncTriggers(sQLiteConnection);
        }

        @Override // androidx.room.RoomOpenDelegate
        public RoomOpenDelegate.ValidationResult onValidateSchema(SQLiteConnection sQLiteConnection) {
            HashMap hashMap = new HashMap(3);
            hashMap.put("url", new TableInfo.Column("url", "TEXT", true, 1, null, 1));
            hashMap.put("localPath", new TableInfo.Column("localPath", "TEXT", false, 0, null, 1));
            hashMap.put("type", new TableInfo.Column("type", "INTEGER", true, 0, null, 1));
            TableInfo tableInfo = new TableInfo("download_file", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(sQLiteConnection, "download_file");
            if (!tableInfo.equals(read)) {
                return new RoomOpenDelegate.ValidationResult(false, "download_file(com.qiahao.base_common.room.roomModel.DownloadFile).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            return new RoomOpenDelegate.ValidationResult(true, null);
        }
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.performClear(false, "download_file");
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "download_file");
    }

    @Override // com.qiahao.base_common.room.dataBase.AppDataBase
    public DownloadFileDao downloadFileDao() {
        DownloadFileDao downloadFileDao;
        if (this.f١٢٥١٣a != null) {
            return this.f١٢٥١٣a;
        }
        synchronized (this) {
            try {
                if (this.f١٢٥١٣a == null) {
                    this.f١٢٥١٣a = new DownloadFileDao_Impl(this);
                }
                downloadFileDao = this.f١٢٥١٣a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return downloadFileDao;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.room.RoomDatabase
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public RoomOpenDelegate createOpenDelegate() {
        return new a(1, "d93c3769af03eef811f39cff76da38c4", "092ffb69fd14f8251467911650c37a8b");
    }

    @Override // androidx.room.RoomDatabase
    public List getAutoMigrations(Map map) {
        return new ArrayList();
    }

    @Override // androidx.room.RoomDatabase
    public Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    protected Map getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(DownloadFileDao.class, DownloadFileDao_Impl.getRequiredConverters());
        return hashMap;
    }
}
