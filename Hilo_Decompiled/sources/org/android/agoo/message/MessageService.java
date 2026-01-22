package org.android.agoo.message;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteClosable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.UTMini;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.MsgDO;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class MessageService {
    public static final String MSG_ACCS_NOTIFY_CLICK = "8";
    public static final String MSG_ACCS_NOTIFY_DISMISS = "9";
    public static final String MSG_ACCS_READY_REPORT = "4";
    public static final String MSG_DB_COMPLETE = "100";
    public static final String MSG_DB_NOTIFY_CLICK = "2";
    public static final String MSG_DB_NOTIFY_DISMISS = "3";
    public static final String MSG_DB_NOTIFY_REACHED = "1";
    public static final String MSG_DB_READY_REPORT = "0";
    private static Context a;
    private static Map<String, Integer> c;
    private volatile SQLiteOpenHelper b = null;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    private static class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, "emas_message_accs_db", (SQLiteDatabase.CursorFactory) null, 3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public SQLiteDatabase getWritableDatabase() {
            if (!AdapterUtilityImpl.checkIsWritable(super.getWritableDatabase().getPath(), 102400)) {
                return null;
            }
            return super.getWritableDatabase();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.execSQL("create table message(id text UNIQUE not null,state integer,body_code integer,report long,target_time long,interval integer,type text,message text,notify integer,create_time date);");
                    sQLiteDatabase.execSQL("CREATE INDEX id_index ON message(id)");
                    sQLiteDatabase.execSQL("CREATE INDEX body_code_index ON message(body_code)");
                    sQLiteDatabase.execSQL("create table accs_message(id text UNIQUE not null,state text,message text,create_time date);");
                } catch (Throwable th) {
                    ALog.e("MessageService", "messagedbhelper create", th, new Object[0]);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.execSQL("delete from message where create_time< date('now','-7 day') and state=1");
                } catch (Throwable th) {
                    try {
                        ALog.e("MessageService", "messagedbhelper create", th, new Object[0]);
                        try {
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS accs_message");
                            sQLiteDatabase.execSQL("create table accs_message(id text UNIQUE not null,state text,message text,create_time date);");
                            return;
                        } catch (Throwable th2) {
                            ALog.e("MessageService", "MessageService onUpgrade is error", th2, new Object[0]);
                            return;
                        }
                    } catch (Throwable th3) {
                        try {
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS accs_message");
                            sQLiteDatabase.execSQL("create table accs_message(id text UNIQUE not null,state text,message text,create_time date);");
                        } catch (Throwable th4) {
                            ALog.e("MessageService", "MessageService onUpgrade is error", th4, new Object[0]);
                        }
                        throw th3;
                    }
                }
            }
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS accs_message");
                sQLiteDatabase.execSQL("create table accs_message(id text UNIQUE not null,state text,message text,create_time date);");
            } catch (Throwable th5) {
                ALog.e("MessageService", "MessageService onUpgrade is error", th5, new Object[0]);
            }
        }
    }

    private MsgDO b(String str, String str2) {
        boolean z;
        ALog.Level level = ALog.Level.I;
        if (ALog.isPrintLog(level)) {
            ALog.i("MessageService", "msgReceive,message--->[" + str + "],utdid=" + AdapterUtilityImpl.getDeviceId(a), new Object[0]);
        }
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.dealMessage", AdapterUtilityImpl.getDeviceId(a), "message==null");
            if (ALog.isPrintLog(level)) {
                ALog.i("MessageService", "handleMessage message==null,utdid=" + AdapterUtilityImpl.getDeviceId(a), new Object[0]);
            }
            return null;
        }
        MsgDO msgDO = new MsgDO();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            new Bundle();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String string = jSONObject.getString("p");
                    String string2 = jSONObject.getString("i");
                    String string3 = jSONObject.getString("b");
                    long j = jSONObject.getLong("f");
                    if (!jSONObject.isNull("ext")) {
                        str3 = jSONObject.getString("ext");
                    }
                    msgDO.msgIds = string2;
                    msgDO.extData = str3;
                    msgDO.messageSource = "accs";
                    msgDO.type = "cache";
                    if (TextUtils.isEmpty(string3)) {
                        msgDO.errorCode = AgooConstants.ACK_BODY_NULL;
                    } else if (TextUtils.isEmpty(string)) {
                        msgDO.errorCode = AgooConstants.ACK_PACK_NULL;
                    } else if (j == -1) {
                        msgDO.errorCode = AgooConstants.ACK_FLAG_NULL;
                    } else if (!a(a, string)) {
                        ALog.d("MessageService", "ondata checkpackage is del,pack=" + string, new Object[0]);
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.dealMessage", AdapterUtilityImpl.getDeviceId(a), "deletePack", string);
                        msgDO.removePacks = string;
                    } else {
                        String string4 = a(j, msgDO).getString(AgooConstants.MESSAGE_ENCRYPTED);
                        if (a.getPackageName().equals(string)) {
                            if (!TextUtils.equals(Integer.toString(0), string4) && !TextUtils.equals(Integer.toString(4), string4)) {
                                msgDO.errorCode = AgooConstants.ACK_PACK_ERROR;
                                ALog.e("MessageService", "error encrypted: " + string4, new Object[0]);
                            } else {
                                z = false;
                            }
                        } else {
                            z = true;
                        }
                        msgDO.agooFlag = z;
                        if (!TextUtils.isEmpty(str2)) {
                            msgDO.msgStatus = str2;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.e("MessageService", "createMsg is error,e: " + th, new Object[0]);
            }
        }
        return msgDO;
    }

    public void a(Context context) {
        c = new HashMap();
        a = context;
        this.b = new a(context);
    }

    public void deleteCacheMessage() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.b.getWritableDatabase();
        } catch (Throwable th) {
            try {
                ALog.e("MessageService", "deleteCacheMessage sql Throwable", th, new Object[0]);
                if (0 == 0) {
                    return;
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th2;
            }
        }
        if (sQLiteDatabase == null) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            }
            return;
        }
        sQLiteDatabase.execSQL("delete from message where create_time< date('now','-7 day') and state=1");
        sQLiteDatabase.execSQL("delete from accs_message where create_time< date('now','-1 day') ");
        try {
            sQLiteDatabase.close();
        } catch (Throwable unused3) {
        }
    }

    public void a(String str, String str2) {
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i("MessageService", "updateAccsMessage sqlite3--->[" + str + ",state=" + str2 + "]", new Object[0]);
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
        } catch (Throwable th) {
            try {
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.e("MessageService", "updateAccsMessage error,e--->[" + th + "],ex=" + th.getStackTrace().toString(), new Object[0]);
                }
                UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", AdapterUtilityImpl.getDeviceId(a), "updateAccsMessageFailed", th.toString());
                if (0 == 0) {
                    return;
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
                throw th2;
            }
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            sQLiteDatabase = this.b.getWritableDatabase();
            if (sQLiteDatabase == null) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            } else {
                if (TextUtils.equals(str2, MSG_DB_NOTIFY_REACHED)) {
                    sQLiteDatabase.execSQL("UPDATE accs_message set state = ? where id = ? and state = ?", new Object[]{str2, str, MSG_DB_READY_REPORT});
                } else {
                    sQLiteDatabase.execSQL("UPDATE accs_message set state = ? where id = ?", new Object[]{str2, str});
                }
                sQLiteDatabase.close();
            }
        }
    }

    public void a(String str, String str2, String str3) {
        Cursor cursor;
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i("MessageService", "addAccsMessage sqlite3--->[" + str + ",message=" + str2 + ",state=" + str3 + "]", new Object[0]);
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
                if (writableDatabase == null) {
                    if (writableDatabase != null) {
                        writableDatabase.close();
                        return;
                    }
                    return;
                }
                try {
                    Cursor rawQuery = writableDatabase.rawQuery("select count(1) from accs_message where id = ?", new String[]{str});
                    if (rawQuery != null && rawQuery.moveToFirst() && rawQuery.getInt(0) > 0) {
                        rawQuery.close();
                        rawQuery.close();
                        writableDatabase.close();
                    } else {
                        writableDatabase.execSQL("INSERT INTO accs_message VALUES(?,?,?,date('now'))", new Object[]{str, str3, str2});
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        writableDatabase.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = null;
                    sQLiteDatabase = writableDatabase;
                    try {
                        if (ALog.isPrintLog(ALog.Level.E)) {
                            ALog.e("MessageService", "addAccsMessage error,e--->[" + th + "],ex=" + a(th), new Object[0]);
                        }
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", AdapterUtilityImpl.getDeviceId(a), "addAccsMessageFailed", th.toString());
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                    } catch (Throwable th2) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    private String a(Throwable th) {
        StringBuilder sb2 = new StringBuilder();
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb2.append(stackTraceElement.toString());
                sb2.append("\n");
            }
        }
        return sb2.toString();
    }

    public void a(String str, String str2, String str3, int i) {
        a(str, str2, str3, 1, -1L, -1, i);
    }

    private void a(String str, String str2, String str3, int i, long j, int i2, int i3) {
        Throwable th;
        int hashCode;
        String str4;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("add sqlite3--->[");
        sb2.append(str);
        sb2.append("]");
        ALog.d("MessageService", sb2.toString(), new Object[0]);
        SQLiteClosable sQLiteClosable = null;
        try {
            String str5 = "";
            if (TextUtils.isEmpty(str2)) {
                str4 = "";
                hashCode = -1;
            } else {
                hashCode = str2.hashCode();
                str4 = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                str5 = str3;
            }
            if (!c.containsKey(str)) {
                c.put(str, Integer.valueOf(hashCode));
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i("MessageService", "addMessage,messageId=" + str + ",messageStores＝" + c.toString(), new Object[0]);
                }
            }
            try {
                SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
                if (writableDatabase == null) {
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.close();
                            return;
                        } catch (Throwable th2) {
                            if (ALog.isPrintLog(ALog.Level.E)) {
                                ALog.e("MessageService", "addMessage,db.close(),error,e--->[" + th2 + "]", new Object[0]);
                            }
                            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", AdapterUtilityImpl.getDeviceId(a), "addMessageDBcloseFailed", th2.toString());
                            return;
                        }
                    }
                    return;
                }
                writableDatabase.execSQL("INSERT INTO message VALUES(?,?,?,?,?,?,?,?,?,date('now'))", new Object[]{str, Integer.valueOf(i), Integer.valueOf(hashCode), 0, Long.valueOf(j), Integer.valueOf(i2), str5, str4, Integer.valueOf(i3)});
                try {
                    writableDatabase.close();
                } catch (Throwable th3) {
                    th = th3;
                    if (ALog.isPrintLog(ALog.Level.E)) {
                        ALog.e("MessageService", "addMessage,db.close(),error,e--->[" + th + "]", new Object[0]);
                    }
                    UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", AdapterUtilityImpl.getDeviceId(a), "addMessageDBcloseFailed", th.toString());
                }
            } catch (Throwable th4) {
                th = th4;
                try {
                    if (ALog.isPrintLog(ALog.Level.E)) {
                        ALog.e("MessageService", "addMessage error,e--->[" + th + "]", new Object[0]);
                    }
                    UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", AdapterUtilityImpl.getDeviceId(a), "addMessageFailed", th.toString());
                    if (0 != 0) {
                        try {
                            sQLiteClosable.close();
                        } catch (Throwable th5) {
                            th = th5;
                            if (ALog.isPrintLog(ALog.Level.E)) {
                                ALog.e("MessageService", "addMessage,db.close(),error,e--->[" + th + "]", new Object[0]);
                            }
                            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", AdapterUtilityImpl.getDeviceId(a), "addMessageDBcloseFailed", th.toString());
                        }
                    }
                } finally {
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0146 A[Catch: all -> 0x015e, TRY_LEAVE, TryCatch #7 {all -> 0x015e, blocks: (B:66:0x013e, B:68:0x0146), top: B:65:0x013e }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016b A[Catch: all -> 0x0167, TRY_LEAVE, TryCatch #4 {all -> 0x0167, blocks: (B:80:0x0163, B:72:0x016b), top: B:79:0x0163 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0163 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<MsgDO> a() {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        ArrayList<MsgDO> arrayList;
        int i;
        int i2;
        String str;
        try {
            sQLiteDatabase = this.b.getReadableDatabase();
        } catch (Throwable th) {
            th = th;
            cursor = null;
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase == null) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                } catch (Throwable th2) {
                    if (ALog.isPrintLog(ALog.Level.E)) {
                        ALog.e("MessageService", "getUnReportMsg close cursor or db, e: " + th2, new Object[0]);
                    }
                }
            }
            return null;
        }
        try {
            arrayList = new ArrayList<>();
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("select * from accs_message where state = ? or state = ? or state = ?", new String[]{MSG_DB_READY_REPORT, MSG_DB_NOTIFY_CLICK, "3"});
                if (rawQuery != null) {
                    try {
                        int columnIndex = rawQuery.getColumnIndex(AgooConstants.MESSAGE_ID);
                        int columnIndex2 = rawQuery.getColumnIndex("state");
                        int columnIndex3 = rawQuery.getColumnIndex(Constants.SHARED_MESSAGE_ID_FILE);
                        int columnIndex4 = rawQuery.getColumnIndex("create_time");
                        while (rawQuery.moveToNext() && !TextUtils.isEmpty(rawQuery.getString(columnIndex3))) {
                            String string = rawQuery.getString(columnIndex2);
                            String string2 = rawQuery.getString(columnIndex3);
                            if (ALog.isPrintLog(ALog.Level.I)) {
                                StringBuilder sb2 = new StringBuilder();
                                i2 = columnIndex2;
                                sb2.append("state: ");
                                sb2.append(string);
                                sb2.append(" ,cursor.message:");
                                sb2.append(string2);
                                sb2.append(" ,cursor.id:");
                                sb2.append(rawQuery.getString(columnIndex));
                                sb2.append(" ,cursor.time:");
                                sb2.append(rawQuery.getString(columnIndex4));
                                i = columnIndex;
                                ALog.i("MessageService", sb2.toString(), new Object[0]);
                            } else {
                                i = columnIndex;
                                i2 = columnIndex2;
                            }
                            if (TextUtils.equals(MSG_DB_READY_REPORT, string)) {
                                str = MSG_ACCS_READY_REPORT;
                            } else if (TextUtils.equals(MSG_DB_NOTIFY_CLICK, string)) {
                                str = MSG_ACCS_NOTIFY_CLICK;
                            } else {
                                str = TextUtils.equals("3", string) ? MSG_ACCS_NOTIFY_DISMISS : null;
                            }
                            new MsgDO();
                            if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(str)) {
                                MsgDO b = b(string2, str);
                                b.messageSource = "cache";
                                arrayList.add(b);
                            }
                            columnIndex2 = i2;
                            columnIndex = i;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = rawQuery;
                        try {
                            if (ALog.isPrintLog(ALog.Level.E)) {
                                ALog.e("MessageService", "getUnReportMsg, e: " + th, new Object[0]);
                            }
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Throwable th4) {
                                    if (ALog.isPrintLog(ALog.Level.E)) {
                                        ALog.e("MessageService", "getUnReportMsg close cursor or db, e: " + th4, new Object[0]);
                                    }
                                }
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            return arrayList;
                        } finally {
                        }
                    }
                }
                if (rawQuery != null) {
                    try {
                        rawQuery.close();
                    } catch (Throwable th5) {
                        if (ALog.isPrintLog(ALog.Level.E)) {
                            ALog.e("MessageService", "getUnReportMsg close cursor or db, e: " + th5, new Object[0]);
                        }
                    }
                }
                sQLiteDatabase.close();
            } catch (Throwable th6) {
                th = th6;
                cursor = null;
            }
        } catch (Throwable th7) {
            th = th7;
            cursor = null;
            arrayList = null;
            if (ALog.isPrintLog(ALog.Level.E)) {
            }
            if (cursor != null) {
            }
            if (sQLiteDatabase != null) {
            }
            return arrayList;
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
    
        if (r0.getInt(0) > 0) goto L٢٧;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str) {
        SQLiteDatabase sQLiteDatabase;
        boolean z;
        Cursor cursor = null;
        boolean z2 = false;
        try {
            boolean z3 = true;
            if (c.containsKey(str)) {
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.e("MessageService", "hasMessageDuplicate,msgid=" + str, new Object[0]);
                }
                z = true;
            } else {
                z = false;
            }
            try {
                sQLiteDatabase = this.b.getReadableDatabase();
                if (sQLiteDatabase == null) {
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.close();
                        } catch (Throwable unused) {
                        }
                    }
                    return z;
                }
                try {
                    cursor = sQLiteDatabase.rawQuery("select count(1) from message where id = ?", new String[]{str});
                    if (cursor != null && cursor.moveToFirst()) {
                    }
                    z3 = z;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Throwable unused2) {
                            return z3;
                        }
                    }
                    sQLiteDatabase.close();
                    return z3;
                } catch (Throwable unused3) {
                    z2 = z;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Throwable unused4) {
                            return z2;
                        }
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return z2;
                }
            } catch (Throwable unused5) {
                sQLiteDatabase = null;
            }
        } catch (Throwable unused6) {
            sQLiteDatabase = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        if (r0.getInt(0) > 0) goto L٢٩;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, int i) {
        SQLiteDatabase sQLiteDatabase;
        boolean z;
        Cursor cursor = null;
        boolean z2 = false;
        try {
            boolean z3 = true;
            if (c.containsKey(str) && c.containsValue(Integer.valueOf(i))) {
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i("MessageService", "addMessage,messageStores hasMessageDuplicate,msgid=" + str, new Object[0]);
                }
                z = true;
            } else {
                z = false;
            }
            try {
                sQLiteDatabase = this.b.getReadableDatabase();
                if (sQLiteDatabase == null) {
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.close();
                        } catch (Throwable unused) {
                        }
                    }
                    return z;
                }
                try {
                    cursor = sQLiteDatabase.rawQuery("select count(1) from message where id = ? and body_code=? and create_time< date('now','-1 day')", new String[]{str, "" + i});
                    if (cursor != null && cursor.moveToFirst()) {
                    }
                    z3 = z;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Throwable unused2) {
                            return z3;
                        }
                    }
                    sQLiteDatabase.close();
                    return z3;
                } catch (Throwable unused3) {
                    z2 = z;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Throwable unused4) {
                            return z2;
                        }
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return z2;
                }
            } catch (Throwable unused5) {
                sQLiteDatabase = null;
            }
        } catch (Throwable unused6) {
            sQLiteDatabase = null;
        }
    }

    public static boolean a(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 0) != null;
    }

    private static Bundle a(long j, MsgDO msgDO) {
        Bundle bundle = new Bundle();
        try {
            char[] charArray = Long.toBinaryString(j).toCharArray();
            if (charArray != null && 8 <= charArray.length) {
                if (8 <= charArray.length) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("");
                    sb2.append(Integer.parseInt("" + charArray[1] + charArray[2] + charArray[3] + charArray[4], 2));
                    bundle.putString(AgooConstants.MESSAGE_ENCRYPTED, sb2.toString());
                    if (charArray[6] == '1') {
                        bundle.putString("report", MSG_DB_NOTIFY_REACHED);
                        msgDO.reportStr = MSG_DB_NOTIFY_REACHED;
                    }
                    if (charArray[7] == '1') {
                        bundle.putString(AgooConstants.MESSAGE_NOTIFICATION, MSG_DB_NOTIFY_REACHED);
                    }
                }
                if (9 <= charArray.length && charArray[8] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_HAS_TEST, MSG_DB_NOTIFY_REACHED);
                }
                if (10 <= charArray.length && charArray[9] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_DUPLICATE, MSG_DB_NOTIFY_REACHED);
                }
                if (11 <= charArray.length && charArray[10] == '1') {
                    bundle.putInt(AgooConstants.MESSAGE_POPUP, 1);
                }
            }
        } catch (Throwable unused) {
        }
        return bundle;
    }
}
