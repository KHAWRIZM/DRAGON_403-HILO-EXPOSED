package j7;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import b7.i;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.facebook.bolts.AppLinks;
import e7.a;
import e7.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import k7.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class m0 implements j7.d, k7.b, j7.c {

    /* renamed from: f, reason: collision with root package name */
    private static final z6.c f١٥٢٩٤f = z6.c.b("proto");

    /* renamed from: a, reason: collision with root package name */
    private final v0 f١٥٢٩٥a;

    /* renamed from: b, reason: collision with root package name */
    private final l7.a f١٥٢٩٦b;

    /* renamed from: c, reason: collision with root package name */
    private final l7.a f١٥٢٩٧c;

    /* renamed from: d, reason: collision with root package name */
    private final e f١٥٢٩٨d;

    /* renamed from: e, reason: collision with root package name */
    private final ne.a f١٥٢٩٩e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface b {
        Object apply(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final String f١٥٣٠٠a;

        /* renamed from: b, reason: collision with root package name */
        final String f١٥٣٠١b;

        private c(String str, String str2) {
            this.f١٥٣٠٠a = str;
            this.f١٥٣٠١b = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface d {
        Object a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m0(l7.a aVar, l7.a aVar2, e eVar, v0 v0Var, ne.a aVar3) {
        this.f١٥٢٩٥a = v0Var;
        this.f١٥٢٩٦b = aVar;
        this.f١٥٢٩٧c = aVar2;
        this.f١٥٢٩٨d = eVar;
        this.f١٥٢٩٩e = aVar3;
    }

    private List A0(SQLiteDatabase sQLiteDatabase, final b7.p pVar, int i10) {
        final ArrayList arrayList = new ArrayList();
        Long X = X(sQLiteDatabase, pVar);
        if (X == null) {
            return arrayList;
        }
        I0(sQLiteDatabase.query("events", new String[]{TransferTable.COLUMN_ID, "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline", "product_id", "pseudonymous_id", "experiment_ids_clear_blob", "experiment_ids_encrypted_blob"}, "context_id = ?", new String[]{X.toString()}, null, null, null, String.valueOf(i10)), new b() { // from class: j7.q
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                Object q02;
                q02 = m0.this.q0(arrayList, pVar, (Cursor) obj);
                return q02;
            }
        });
        return arrayList;
    }

    private Map B0(SQLiteDatabase sQLiteDatabase, List list) {
        final HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i10 = 0; i10 < list.size(); i10++) {
            sb.append(((k) list.get(i10)).c());
            if (i10 < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        I0(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null), new b() { // from class: j7.s
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                Object r02;
                r02 = m0.r0(hashMap, (Cursor) obj);
                return r02;
            }
        });
        return hashMap;
    }

    private static byte[] C0(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private void D0(a.C٠١٥٨a r42, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            r42.a(e7.d.c().c((String) entry.getKey()).b((List) entry.getValue()).a());
        }
    }

    private byte[] E0(long j10) {
        return (byte[]) I0(T().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j10)}, null, null, "sequence_num"), new b() { // from class: j7.a0
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                byte[] t02;
                t02 = m0.t0((Cursor) obj);
                return t02;
            }
        });
    }

    private Object F0(d dVar, b bVar) {
        long a10 = this.f١٥٢٩٧c.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e10) {
                if (this.f١٥٢٩٧c.a() >= this.f١٥٢٩٨d.b() + a10) {
                    return bVar.apply(e10);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    private static z6.c G0(String str) {
        if (str == null) {
            return f١٥٢٩٤f;
        }
        return z6.c.b(str);
    }

    private static String H0(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((k) it.next()).c());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    static Object I0(Cursor cursor, b bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    private c.b P(int i10) {
        c.b bVar = c.b.REASON_UNKNOWN;
        if (i10 == bVar.getNumber()) {
            return bVar;
        }
        c.b bVar2 = c.b.MESSAGE_TOO_OLD;
        if (i10 == bVar2.getNumber()) {
            return bVar2;
        }
        c.b bVar3 = c.b.CACHE_FULL;
        if (i10 == bVar3.getNumber()) {
            return bVar3;
        }
        c.b bVar4 = c.b.PAYLOAD_TOO_BIG;
        if (i10 == bVar4.getNumber()) {
            return bVar4;
        }
        c.b bVar5 = c.b.MAX_RETRIES_REACHED;
        if (i10 == bVar5.getNumber()) {
            return bVar5;
        }
        c.b bVar6 = c.b.INVALID_PAYLOD;
        if (i10 == bVar6.getNumber()) {
            return bVar6;
        }
        c.b bVar7 = c.b.SERVER_ERROR;
        if (i10 == bVar7.getNumber()) {
            return bVar7;
        }
        f7.a.b("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i10));
        return bVar;
    }

    private void Q(final SQLiteDatabase sQLiteDatabase) {
        F0(new d() { // from class: j7.w
            @Override // j7.m0.d
            public final Object a() {
                Object d02;
                d02 = m0.d0(sQLiteDatabase);
                return d02;
            }
        }, new b() { // from class: j7.e0
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                Object e02;
                e02 = m0.e0((Throwable) obj);
                return e02;
            }
        });
    }

    private long R(SQLiteDatabase sQLiteDatabase, b7.p pVar) {
        Long X = X(sQLiteDatabase, pVar);
        if (X != null) {
            return X.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", pVar.b());
        contentValues.put("priority", Integer.valueOf(m7.a.a(pVar.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (pVar.c() != null) {
            contentValues.put(AppLinks.KEY_NAME_EXTRAS, Base64.encodeToString(pVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    private e7.b U() {
        return e7.b.b().b(e7.e.c().b(S()).c(e.f١٥٢٧٥a.f()).a()).a();
    }

    private long V() {
        return T().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    private e7.f W() {
        final long a10 = this.f١٥٢٩٦b.a();
        return (e7.f) Y(new b() { // from class: j7.b0
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                e7.f i02;
                i02 = m0.i0(a10, (SQLiteDatabase) obj);
                return i02;
            }
        });
    }

    private Long X(SQLiteDatabase sQLiteDatabase, b7.p pVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(pVar.b(), String.valueOf(m7.a.a(pVar.d()))));
        if (pVar.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(pVar.c(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) I0(sQLiteDatabase.query("transport_contexts", new String[]{TransferTable.COLUMN_ID}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), new b() { // from class: j7.u
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                Long j02;
                j02 = m0.j0((Cursor) obj);
                return j02;
            }
        });
    }

    private boolean Z() {
        if (V() * getPageSize() >= this.f١٥٢٩٨d.f()) {
            return true;
        }
        return false;
    }

    private List a0(List list, Map map) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            k kVar = (k) listIterator.next();
            if (map.containsKey(Long.valueOf(kVar.c()))) {
                i.a p10 = kVar.b().p();
                for (c cVar : (Set) map.get(Long.valueOf(kVar.c()))) {
                    p10.c(cVar.f١٥٣٠٠a, cVar.f١٥٣٠١b);
                }
                listIterator.set(k.a(kVar.c(), kVar.d(), p10.d()));
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object b0(Cursor cursor) {
        while (cursor.moveToNext()) {
            b(cursor.getInt(0), c.b.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer c0(long j10, SQLiteDatabase sQLiteDatabase) {
        String[] strArr = {String.valueOf(j10)};
        I0(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new b() { // from class: j7.c0
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                Object b02;
                b02 = m0.this.b0((Cursor) obj);
                return b02;
            }
        });
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object d0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object e0(Throwable th) {
        throw new k7.a("Timed out while trying to acquire the lock.", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SQLiteDatabase f0(Throwable th) {
        throw new k7.a("Timed out while trying to open db.", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long g0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    private long getPageSize() {
        return T().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e7.f h0(long j10, Cursor cursor) {
        cursor.moveToNext();
        return e7.f.c().c(cursor.getLong(0)).b(j10).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e7.f i0(final long j10, SQLiteDatabase sQLiteDatabase) {
        return (e7.f) I0(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new b() { // from class: j7.d0
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                e7.f h02;
                h02 = m0.h0(j10, (Cursor) obj);
                return h02;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long j0(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean k0(b7.p pVar, SQLiteDatabase sQLiteDatabase) {
        Long X = X(sQLiteDatabase, pVar);
        if (X == null) {
            return Boolean.FALSE;
        }
        return (Boolean) I0(T().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{X.toString()}), new b() { // from class: j7.o
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                return Boolean.valueOf(((Cursor) obj).moveToNext());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List l0(SQLiteDatabase sQLiteDatabase) {
        return (List) I0(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new b() { // from class: j7.z
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                List m02;
                m02 = m0.m0((Cursor) obj);
                return m02;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List m0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(b7.p.a().b(cursor.getString(1)).d(m7.a.b(cursor.getInt(2))).c(C0(cursor.getString(3))).a());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List n0(b7.p pVar, SQLiteDatabase sQLiteDatabase) {
        List A0 = A0(sQLiteDatabase, pVar, this.f١٥٢٩٨d.d());
        for (z6.f fVar : z6.f.values()) {
            if (fVar != pVar.d()) {
                int d10 = this.f١٥٢٩٨d.d() - A0.size();
                if (d10 <= 0) {
                    break;
                }
                A0.addAll(A0(sQLiteDatabase, pVar.f(fVar), d10));
            }
        }
        return a0(A0, B0(sQLiteDatabase, A0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ e7.a o0(Map map, a.C٠١٥٨a r72, Cursor cursor) {
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            c.b P = P(cursor.getInt(1));
            long j10 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(e7.c.c().c(P).b(j10).a());
        }
        D0(r72, map);
        return r72.e(W()).d(U()).c((String) this.f١٥٢٩٩e.get()).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ e7.a p0(String str, final Map map, final a.C٠١٥٨a r42, SQLiteDatabase sQLiteDatabase) {
        return (e7.a) I0(sQLiteDatabase.rawQuery(str, new String[0]), new b() { // from class: j7.x
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                e7.a o02;
                o02 = m0.this.o0(map, r42, (Cursor) obj);
                return o02;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object q0(List list, b7.p pVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            boolean z10 = false;
            long j10 = cursor.getLong(0);
            if (cursor.getInt(7) != 0) {
                z10 = true;
            }
            i.a o10 = b7.i.a().n(cursor.getString(1)).i(cursor.getLong(2)).o(cursor.getLong(3));
            if (z10) {
                o10.h(new b7.h(G0(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                o10.h(new b7.h(G0(cursor.getString(4)), E0(j10)));
            }
            if (!cursor.isNull(6)) {
                o10.g(Integer.valueOf(cursor.getInt(6)));
            }
            if (!cursor.isNull(8)) {
                o10.l(Integer.valueOf(cursor.getInt(8)));
            }
            if (!cursor.isNull(9)) {
                o10.m(cursor.getString(9));
            }
            if (!cursor.isNull(10)) {
                o10.j(cursor.getBlob(10));
            }
            if (!cursor.isNull(11)) {
                o10.k(cursor.getBlob(11));
            }
            list.add(k.a(j10, pVar, o10.d()));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object r0(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j10 = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j10));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j10), set);
            }
            set.add(new c(cursor.getString(1), cursor.getString(2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long s0(b7.i iVar, b7.p pVar, SQLiteDatabase sQLiteDatabase) {
        boolean z10;
        byte[] bArr;
        if (Z()) {
            b(1L, c.b.CACHE_FULL, iVar.n());
            return -1L;
        }
        long R = R(sQLiteDatabase, pVar);
        int e10 = this.f١٥٢٩٨d.e();
        byte[] a10 = iVar.e().a();
        if (a10.length <= e10) {
            z10 = true;
        } else {
            z10 = false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(R));
        contentValues.put("transport_name", iVar.n());
        contentValues.put("timestamp_ms", Long.valueOf(iVar.f()));
        contentValues.put("uptime_ms", Long.valueOf(iVar.o()));
        contentValues.put("payload_encoding", iVar.e().b().a());
        contentValues.put("code", iVar.d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z10));
        if (z10) {
            bArr = a10;
        } else {
            bArr = new byte[0];
        }
        contentValues.put("payload", bArr);
        contentValues.put("product_id", iVar.l());
        contentValues.put("pseudonymous_id", iVar.m());
        contentValues.put("experiment_ids_clear_blob", iVar.g());
        contentValues.put("experiment_ids_encrypted_blob", iVar.h());
        long insert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z10) {
            int ceil = (int) Math.ceil(a10.length / e10);
            for (int i10 = 1; i10 <= ceil; i10++) {
                byte[] copyOfRange = Arrays.copyOfRange(a10, (i10 - 1) * e10, Math.min(i10 * e10, a10.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i10));
                contentValues2.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry entry : iVar.k().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(insert));
            contentValues3.put("name", (String) entry.getKey());
            contentValues3.put("value", (String) entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] t0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i10 += blob.length;
        }
        byte[] bArr = new byte[i10];
        int i11 = 0;
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            byte[] bArr2 = (byte[]) arrayList.get(i12);
            System.arraycopy(bArr2, 0, bArr, i11, bArr2.length);
            i11 += bArr2.length;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object u0(Cursor cursor) {
        while (cursor.moveToNext()) {
            b(cursor.getInt(0), c.b.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object v0(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        I0(sQLiteDatabase.rawQuery(str2, null), new b() { // from class: j7.p
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                Object u02;
                u02 = m0.this.u0((Cursor) obj);
                return u02;
            }
        });
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean w0(Cursor cursor) {
        boolean z10;
        if (cursor.getCount() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object x0(String str, c.b bVar, long j10, SQLiteDatabase sQLiteDatabase) {
        if (!((Boolean) I0(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.getNumber())}), new b() { // from class: j7.r
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                Boolean w02;
                w02 = m0.w0((Cursor) obj);
                return w02;
            }
        })).booleanValue()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(bVar.getNumber()));
            contentValues.put("events_dropped_count", Long.valueOf(j10));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
        } else {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j10 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.getNumber())});
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object y0(long j10, b7.p pVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j10));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(m7.a.a(pVar.d()))}) < 1) {
            contentValues.put("backend_name", pVar.b());
            contentValues.put("priority", Integer.valueOf(m7.a.a(pVar.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object z0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + this.f١٥٢٩٦b.a()).execute();
        return null;
    }

    @Override // j7.d
    public long B(b7.p pVar) {
        return ((Long) I0(T().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(m7.a.a(pVar.d()))}), new b() { // from class: j7.m
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                Long g02;
                g02 = m0.g0((Cursor) obj);
                return g02;
            }
        })).longValue();
    }

    @Override // j7.d
    public k J(final b7.p pVar, final b7.i iVar) {
        f7.a.c("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", pVar.d(), iVar.n(), pVar.b());
        long longValue = ((Long) Y(new b() { // from class: j7.v
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                Long s02;
                s02 = m0.this.s0(iVar, pVar, (SQLiteDatabase) obj);
                return s02;
            }
        })).longValue();
        if (longValue < 1) {
            return null;
        }
        return k.a(longValue, pVar, iVar);
    }

    long S() {
        return V() * getPageSize();
    }

    SQLiteDatabase T() {
        final v0 v0Var = this.f١٥٢٩٥a;
        Objects.requireNonNull(v0Var);
        return (SQLiteDatabase) F0(new d() { // from class: j7.g0
            @Override // j7.m0.d
            public final Object a() {
                return v0.this.getWritableDatabase();
            }
        }, new b() { // from class: j7.h0
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                SQLiteDatabase f02;
                f02 = m0.f0((Throwable) obj);
                return f02;
            }
        });
    }

    Object Y(b bVar) {
        SQLiteDatabase T = T();
        T.beginTransaction();
        try {
            Object apply = bVar.apply(T);
            T.setTransactionSuccessful();
            return apply;
        } finally {
            T.endTransaction();
        }
    }

    @Override // j7.c
    public void a() {
        Y(new b() { // from class: j7.k0
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                Object z02;
                z02 = m0.this.z0((SQLiteDatabase) obj);
                return z02;
            }
        });
    }

    @Override // j7.c
    public void b(final long j10, final c.b bVar, final String str) {
        Y(new b() { // from class: j7.l0
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                Object x02;
                x02 = m0.x0(str, bVar, j10, (SQLiteDatabase) obj);
                return x02;
            }
        });
    }

    @Override // k7.b
    public Object c(b.a aVar) {
        SQLiteDatabase T = T();
        Q(T);
        try {
            Object execute = aVar.execute();
            T.setTransactionSuccessful();
            return execute;
        } finally {
            T.endTransaction();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f١٥٢٩٥a.close();
    }

    @Override // j7.d
    public int e() {
        final long a10 = this.f١٥٢٩٦b.a() - this.f١٥٢٩٨d.c();
        return ((Integer) Y(new b() { // from class: j7.y
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                Integer c02;
                c02 = m0.this.c0(a10, (SQLiteDatabase) obj);
                return c02;
            }
        })).intValue();
    }

    @Override // j7.d
    public void f(Iterable iterable) {
        if (!iterable.iterator().hasNext()) {
            return;
        }
        T().compileStatement("DELETE FROM events WHERE _id in " + H0(iterable)).execute();
    }

    @Override // j7.c
    public e7.a g() {
        final a.C٠١٥٨a e10 = e7.a.e();
        final HashMap hashMap = new HashMap();
        final String str = "SELECT log_source, reason, events_dropped_count FROM log_event_dropped";
        return (e7.a) Y(new b() { // from class: j7.n
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                e7.a p02;
                p02 = m0.this.p0(str, hashMap, e10, (SQLiteDatabase) obj);
                return p02;
            }
        });
    }

    @Override // j7.d
    public Iterable i(final b7.p pVar) {
        return (Iterable) Y(new b() { // from class: j7.f0
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                List n02;
                n02 = m0.this.n0(pVar, (SQLiteDatabase) obj);
                return n02;
            }
        });
    }

    @Override // j7.d
    public Iterable l() {
        return (Iterable) Y(new b() { // from class: j7.t
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                List l02;
                l02 = m0.l0((SQLiteDatabase) obj);
                return l02;
            }
        });
    }

    @Override // j7.d
    public void n(final b7.p pVar, final long j10) {
        Y(new b() { // from class: j7.j0
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                Object y02;
                y02 = m0.y0(j10, pVar, (SQLiteDatabase) obj);
                return y02;
            }
        });
    }

    @Override // j7.d
    public boolean v(final b7.p pVar) {
        return ((Boolean) Y(new b() { // from class: j7.i0
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                Boolean k02;
                k02 = m0.this.k0(pVar, (SQLiteDatabase) obj);
                return k02;
            }
        })).booleanValue();
    }

    @Override // j7.d
    public void y(Iterable iterable) {
        if (!iterable.iterator().hasNext()) {
            return;
        }
        final String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + H0(iterable);
        final String str2 = "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name";
        Y(new b() { // from class: j7.l
            @Override // j7.m0.b
            public final Object apply(Object obj) {
                Object v02;
                v02 = m0.this.v0(str, str2, (SQLiteDatabase) obj);
                return v02;
            }
        });
    }
}
