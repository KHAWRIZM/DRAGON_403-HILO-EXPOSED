package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class TransferDBBase {
    private static final String BASE_PATH = "transfers";
    private static final int TRANSFERS = 10;
    private static final int TRANSFER_ID = 20;
    private static final int TRANSFER_PART = 30;
    private static final int TRANSFER_STATE = 40;
    private final Uri contentUri;
    private final Context context;
    private SQLiteDatabase database;
    private final TransferDatabaseHelper databaseHelper;
    private final UriMatcher uriMatcher;
    private static final Log LOGGER = LogFactory.getLog(TransferDBBase.class);
    private static final Object LOCK = new Object();

    public TransferDBBase(Context context) {
        this.context = context;
        String packageName = context.getApplicationContext().getPackageName();
        TransferDatabaseHelper transferDatabaseHelper = new TransferDatabaseHelper(context);
        this.databaseHelper = transferDatabaseHelper;
        this.database = transferDatabaseHelper.getWritableDatabase();
        this.contentUri = Uri.parse("content://" + packageName + "/" + BASE_PATH);
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.uriMatcher = uriMatcher;
        uriMatcher.addURI(packageName, BASE_PATH, 10);
        uriMatcher.addURI(packageName, "transfers/#", 20);
        uriMatcher.addURI(packageName, "transfers/part/#", 30);
        uriMatcher.addURI(packageName, "transfers/state/*", 40);
    }

    private void ensureDatabaseOpen() {
        synchronized (LOCK) {
            try {
                if (!this.database.isOpen()) {
                    this.database = this.databaseHelper.getWritableDatabase();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        int match = this.uriMatcher.match(uri);
        ensureDatabaseOpen();
        if (match == 10) {
            int i10 = 0;
            try {
                try {
                    this.database.beginTransaction();
                    i10 = (int) this.database.insertOrThrow(TransferTable.TABLE_TRANSFER, null, contentValuesArr[0]);
                    for (int i11 = 1; i11 < contentValuesArr.length; i11++) {
                        contentValuesArr[i11].put(TransferTable.COLUMN_MAIN_UPLOAD_ID, Integer.valueOf(i10));
                        this.database.insertOrThrow(TransferTable.TABLE_TRANSFER, null, contentValuesArr[i11]);
                    }
                    this.database.setTransactionSuccessful();
                } catch (Exception e10) {
                    LOGGER.error("bulkInsert error : ", e10);
                }
                this.database.endTransaction();
                return i10;
            } catch (Throwable th) {
                this.database.endTransaction();
                throw th;
            }
        }
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }

    public void closeDBHelper() {
        this.databaseHelper.close();
    }

    public int delete(Uri uri, String str, String[] strArr) {
        int match = this.uriMatcher.match(uri);
        ensureDatabaseOpen();
        if (match != 10) {
            if (match == 20) {
                String lastPathSegment = uri.getLastPathSegment();
                if (TextUtils.isEmpty(str)) {
                    return this.database.delete(TransferTable.TABLE_TRANSFER, "_id=" + lastPathSegment, null);
                }
                return this.database.delete(TransferTable.TABLE_TRANSFER, "_id=" + lastPathSegment + " and " + str, strArr);
            }
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        return this.database.delete(TransferTable.TABLE_TRANSFER, str, strArr);
    }

    public Uri getContentUri() {
        return this.contentUri;
    }

    SQLiteDatabase getDatabase() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (LOCK) {
            sQLiteDatabase = this.database;
        }
        return sQLiteDatabase;
    }

    TransferDatabaseHelper getDatabaseHelper() {
        return this.databaseHelper;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        int match = this.uriMatcher.match(uri);
        ensureDatabaseOpen();
        if (match == 10) {
            return Uri.parse("transfers/" + this.database.insertOrThrow(TransferTable.TABLE_TRANSFER, null, contentValues));
        }
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables(TransferTable.TABLE_TRANSFER);
        int match = this.uriMatcher.match(uri);
        if (match != 10) {
            if (match != 20) {
                if (match != 30) {
                    if (match == 40) {
                        sQLiteQueryBuilder.appendWhere("state=");
                        sQLiteQueryBuilder.appendWhereEscapeString(uri.getLastPathSegment());
                    } else {
                        throw new IllegalArgumentException("Unknown URI: " + uri);
                    }
                } else {
                    sQLiteQueryBuilder.appendWhere("main_upload_id=" + uri.getLastPathSegment());
                }
            } else {
                sQLiteQueryBuilder.appendWhere("_id=" + uri.getLastPathSegment());
            }
        } else {
            sQLiteQueryBuilder.appendWhere("part_num=0");
        }
        ensureDatabaseOpen();
        return sQLiteQueryBuilder.query(this.database, strArr, str, strArr2, null, null, str2);
    }

    public synchronized int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int update;
        try {
            int match = this.uriMatcher.match(uri);
            ensureDatabaseOpen();
            if (match != 10) {
                if (match == 20) {
                    String lastPathSegment = uri.getLastPathSegment();
                    if (TextUtils.isEmpty(str)) {
                        update = this.database.update(TransferTable.TABLE_TRANSFER, contentValues, "_id=" + lastPathSegment, null);
                    } else {
                        update = this.database.update(TransferTable.TABLE_TRANSFER, contentValues, "_id=" + lastPathSegment + " and " + str, strArr);
                    }
                } else {
                    throw new IllegalArgumentException("Unknown URI: " + uri);
                }
            } else {
                update = this.database.update(TransferTable.TABLE_TRANSFER, contentValues, str, strArr);
            }
        } catch (Throwable th) {
            throw th;
        }
        return update;
    }
}
