package com.qiahao.base_common.room.roomDao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.qiahao.base_common.room.roomModel.DownloadFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class DownloadFileDao_Impl implements DownloadFileDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<DownloadFile> __insertAdapterOfDownloadFile = new EntityInsertAdapter<DownloadFile>() { // from class: com.qiahao.base_common.room.roomDao.DownloadFileDao_Impl.1
        @Override // androidx.room.EntityInsertAdapter
        protected String createQuery() {
            return "INSERT OR REPLACE INTO `download_file` (`url`,`localPath`,`type`) VALUES (?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityInsertAdapter
        public void bind(SQLiteStatement sQLiteStatement, DownloadFile downloadFile) {
            if (downloadFile.getUrl() == null) {
                sQLiteStatement.mo٢٤٥bindNull(1);
            } else {
                sQLiteStatement.mo٢٤٦bindText(1, downloadFile.getUrl());
            }
            if (downloadFile.getLocalPath() == null) {
                sQLiteStatement.mo٢٤٥bindNull(2);
            } else {
                sQLiteStatement.mo٢٤٦bindText(2, downloadFile.getLocalPath());
            }
            sQLiteStatement.mo٢٤٤bindLong(3, downloadFile.getType());
        }
    };
    private final EntityDeleteOrUpdateAdapter<DownloadFile> __deleteAdapterOfDownloadFile = new EntityDeleteOrUpdateAdapter<DownloadFile>() { // from class: com.qiahao.base_common.room.roomDao.DownloadFileDao_Impl.2
        @Override // androidx.room.EntityDeleteOrUpdateAdapter
        protected String createQuery() {
            return "DELETE FROM `download_file` WHERE `url` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityDeleteOrUpdateAdapter
        public void bind(SQLiteStatement sQLiteStatement, DownloadFile downloadFile) {
            if (downloadFile.getUrl() == null) {
                sQLiteStatement.mo٢٤٥bindNull(1);
            } else {
                sQLiteStatement.mo٢٤٦bindText(1, downloadFile.getUrl());
            }
        }
    };
    private final EntityDeleteOrUpdateAdapter<DownloadFile> __updateAdapterOfDownloadFile = new EntityDeleteOrUpdateAdapter<DownloadFile>() { // from class: com.qiahao.base_common.room.roomDao.DownloadFileDao_Impl.3
        @Override // androidx.room.EntityDeleteOrUpdateAdapter
        protected String createQuery() {
            return "UPDATE OR ABORT `download_file` SET `url` = ?,`localPath` = ?,`type` = ? WHERE `url` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityDeleteOrUpdateAdapter
        public void bind(SQLiteStatement sQLiteStatement, DownloadFile downloadFile) {
            if (downloadFile.getUrl() == null) {
                sQLiteStatement.mo٢٤٥bindNull(1);
            } else {
                sQLiteStatement.mo٢٤٦bindText(1, downloadFile.getUrl());
            }
            if (downloadFile.getLocalPath() == null) {
                sQLiteStatement.mo٢٤٥bindNull(2);
            } else {
                sQLiteStatement.mo٢٤٦bindText(2, downloadFile.getLocalPath());
            }
            sQLiteStatement.mo٢٤٤bindLong(3, downloadFile.getType());
            if (downloadFile.getUrl() == null) {
                sQLiteStatement.mo٢٤٥bindNull(4);
            } else {
                sQLiteStatement.mo٢٤٦bindText(4, downloadFile.getUrl());
            }
        }
    };

    public DownloadFileDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$deleteAllDownloadFiles$6(SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("DELETE FROM download_file");
        try {
            prepare.step();
            return Unit.INSTANCE;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$deleteDownloadFile$2(DownloadFile downloadFile, SQLiteConnection sQLiteConnection) {
        this.__deleteAdapterOfDownloadFile.handle(sQLiteConnection, downloadFile);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$getAllFile$4(SQLiteConnection sQLiteConnection) {
        String text;
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT `download_file`.`url` AS `url`, `download_file`.`localPath` AS `localPath`, `download_file`.`type` AS `type` FROM download_file");
        try {
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String str = null;
                if (prepare.isNull(0)) {
                    text = null;
                } else {
                    text = prepare.getText(0);
                }
                if (!prepare.isNull(1)) {
                    str = prepare.getText(1);
                }
                arrayList.add(new DownloadFile(text, str, (int) prepare.getLong(2)));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DownloadFile lambda$getDownloadFileByUrl$5(String str, SQLiteConnection sQLiteConnection) {
        String text;
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT * FROM download_file WHERE url = ?");
        try {
            if (str == null) {
                prepare.mo٢٤٥bindNull(1);
            } else {
                prepare.mo٢٤٦bindText(1, str);
            }
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "url");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "localPath");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "type");
            DownloadFile downloadFile = null;
            String text2 = null;
            if (prepare.step()) {
                if (prepare.isNull(columnIndexOrThrow)) {
                    text = null;
                } else {
                    text = prepare.getText(columnIndexOrThrow);
                }
                if (!prepare.isNull(columnIndexOrThrow2)) {
                    text2 = prepare.getText(columnIndexOrThrow2);
                }
                downloadFile = new DownloadFile(text, text2, (int) prepare.getLong(columnIndexOrThrow3));
            }
            prepare.close();
            return downloadFile;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$insertDownloadFile$0(DownloadFile downloadFile, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfDownloadFile.insert(sQLiteConnection, (SQLiteConnection) downloadFile);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$insertDownloadFiles$1(List list, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfDownloadFile.insert(sQLiteConnection, list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$updateDownloadFile$3(DownloadFile downloadFile, SQLiteConnection sQLiteConnection) {
        this.__updateAdapterOfDownloadFile.handle(sQLiteConnection, downloadFile);
        return Unit.INSTANCE;
    }

    @Override // com.qiahao.base_common.room.roomDao.DownloadFileDao
    public Object deleteAllDownloadFiles(Continuation<? super Unit> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.qiahao.base_common.room.roomDao.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$deleteAllDownloadFiles$6;
                lambda$deleteAllDownloadFiles$6 = DownloadFileDao_Impl.lambda$deleteAllDownloadFiles$6((SQLiteConnection) obj);
                return lambda$deleteAllDownloadFiles$6;
            }
        }, continuation);
    }

    @Override // com.qiahao.base_common.room.roomDao.DownloadFileDao
    public Object deleteDownloadFile(final DownloadFile downloadFile, Continuation<? super Unit> continuation) {
        downloadFile.getClass();
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.qiahao.base_common.room.roomDao.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$deleteDownloadFile$2;
                lambda$deleteDownloadFile$2 = DownloadFileDao_Impl.this.lambda$deleteDownloadFile$2(downloadFile, (SQLiteConnection) obj);
                return lambda$deleteDownloadFile$2;
            }
        }, continuation);
    }

    @Override // com.qiahao.base_common.room.roomDao.DownloadFileDao
    public Object getAllFile(Continuation<? super List<DownloadFile>> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.qiahao.base_common.room.roomDao.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List lambda$getAllFile$4;
                lambda$getAllFile$4 = DownloadFileDao_Impl.lambda$getAllFile$4((SQLiteConnection) obj);
                return lambda$getAllFile$4;
            }
        }, continuation);
    }

    @Override // com.qiahao.base_common.room.roomDao.DownloadFileDao
    public Object getDownloadFileByUrl(final String str, Continuation<? super DownloadFile> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.qiahao.base_common.room.roomDao.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DownloadFile lambda$getDownloadFileByUrl$5;
                lambda$getDownloadFileByUrl$5 = DownloadFileDao_Impl.lambda$getDownloadFileByUrl$5(str, (SQLiteConnection) obj);
                return lambda$getDownloadFileByUrl$5;
            }
        }, continuation);
    }

    @Override // com.qiahao.base_common.room.roomDao.DownloadFileDao
    public Object insertDownloadFile(final DownloadFile downloadFile, Continuation<? super Unit> continuation) {
        downloadFile.getClass();
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.qiahao.base_common.room.roomDao.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$insertDownloadFile$0;
                lambda$insertDownloadFile$0 = DownloadFileDao_Impl.this.lambda$insertDownloadFile$0(downloadFile, (SQLiteConnection) obj);
                return lambda$insertDownloadFile$0;
            }
        }, continuation);
    }

    @Override // com.qiahao.base_common.room.roomDao.DownloadFileDao
    public Object insertDownloadFiles(final List<DownloadFile> list, Continuation<? super Unit> continuation) {
        list.getClass();
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.qiahao.base_common.room.roomDao.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$insertDownloadFiles$1;
                lambda$insertDownloadFiles$1 = DownloadFileDao_Impl.this.lambda$insertDownloadFiles$1(list, (SQLiteConnection) obj);
                return lambda$insertDownloadFiles$1;
            }
        }, continuation);
    }

    @Override // com.qiahao.base_common.room.roomDao.DownloadFileDao
    public Object updateDownloadFile(final DownloadFile downloadFile, Continuation<? super Unit> continuation) {
        downloadFile.getClass();
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.qiahao.base_common.room.roomDao.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$updateDownloadFile$3;
                lambda$updateDownloadFile$3 = DownloadFileDao_Impl.this.lambda$updateDownloadFile$3(downloadFile, (SQLiteConnection) obj);
                return lambda$updateDownloadFile$3;
            }
        }, continuation);
    }
}
