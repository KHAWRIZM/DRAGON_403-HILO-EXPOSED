package com.qiahao.nextvideo.utilities.google.pay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J8\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011J\u0019\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0011J\u0016\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/utilities/google/pay/SQLiteHelperRecharge;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "onCreate", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "", "newVersion", "insert", "", "user_id", "", "other_id", "order_id", "product_id", "token", "queryAllFailure", "Landroid/database/Cursor;", "args", "", "([Ljava/lang/String;)Landroid/database/Cursor;", "delete", "updateStatus", "isSuccess", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SQLiteHelperRecharge extends SQLiteOpenHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static String DATABASE_NAME = "SC_DATABASE";
    private static int DATABASE_VERSION = 1;

    @NotNull
    private static String TABLE_NAME = "Recharge_Log";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/utilities/google/pay/SQLiteHelperRecharge$Companion;", "", "<init>", "()V", "DATABASE_NAME", "", "getDATABASE_NAME", "()Ljava/lang/String;", "setDATABASE_NAME", "(Ljava/lang/String;)V", "DATABASE_VERSION", "", "getDATABASE_VERSION", "()I", "setDATABASE_VERSION", "(I)V", "TABLE_NAME", "getTABLE_NAME", "setTABLE_NAME", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getDATABASE_NAME() {
            return SQLiteHelperRecharge.DATABASE_NAME;
        }

        public final int getDATABASE_VERSION() {
            return SQLiteHelperRecharge.DATABASE_VERSION;
        }

        @NotNull
        public final String getTABLE_NAME() {
            return SQLiteHelperRecharge.TABLE_NAME;
        }

        public final void setDATABASE_NAME(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            SQLiteHelperRecharge.DATABASE_NAME = str;
        }

        public final void setDATABASE_VERSION(int i) {
            SQLiteHelperRecharge.DATABASE_VERSION = i;
        }

        public final void setTABLE_NAME(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            SQLiteHelperRecharge.TABLE_NAME = str;
        }

        private Companion() {
        }
    }

    public SQLiteHelperRecharge(@Nullable Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, DATABASE_VERSION);
    }

    public final void delete(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        getWritableDatabase().delete(TABLE_NAME, "token = ?", new String[]{token});
    }

    public final long insert(@Nullable String user_id, @Nullable String other_id, @Nullable String order_id, @Nullable String product_id, @Nullable String token) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_id", user_id);
        contentValues.put("other_id", other_id);
        contentValues.put("order_id", order_id);
        contentValues.put("product_id", product_id);
        contentValues.put("token", token);
        contentValues.put(AgooConstants.MESSAGE_TIME, (Integer) 0);
        contentValues.put("status", (Integer) 0);
        return writableDatabase.insert(TABLE_NAME, null, contentValues);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(@NotNull SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(id INTEGER PRIMARY KEY,user_id VARCHAR(50) NOT NULL,other_id VARCHAR(50),order_id VARCHAR(255),product_id VARCHAR(50),token TEXT,time INTEGER NOT NULL,status INTEGER NOT NULL);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(@NotNull SQLiteDatabase db, int oldVersion, int newVersion) {
        Intrinsics.checkNotNullParameter(db, "db");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @NotNull
    public final Cursor queryAllFailure(@NotNull String[] args) {
        Intrinsics.checkNotNullParameter(args, "args");
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE user_id = ? AND time < 3 AND status != 1", args);
        Intrinsics.checkNotNullExpressionValue(rawQuery, "rawQuery(...)");
        return rawQuery;
    }

    public final void updateStatus(@NotNull String order_id, boolean isSuccess) {
        int i;
        Intrinsics.checkNotNullParameter(order_id, "order_id");
        SQLiteDatabase writableDatabase = getWritableDatabase();
        String[] strArr = {order_id};
        ContentValues contentValues = new ContentValues();
        if (isSuccess) {
            i = 1;
        } else {
            i = 2;
        }
        contentValues.put("status", Integer.valueOf(i));
        writableDatabase.update(TABLE_NAME, contentValues, "order_id = ?", strArr);
    }
}
