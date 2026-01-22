package j7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class v0 extends SQLiteOpenHelper {

    /* renamed from: c, reason: collision with root package name */
    private static final String f١٥٣١٩c = "INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")";

    /* renamed from: d, reason: collision with root package name */
    static int f١٥٣٢٠d = 7;

    /* renamed from: e, reason: collision with root package name */
    private static final a f١٥٣٢١e;

    /* renamed from: f, reason: collision with root package name */
    private static final a f١٥٣٢٢f;

    /* renamed from: g, reason: collision with root package name */
    private static final a f١٥٣٢٣g;

    /* renamed from: h, reason: collision with root package name */
    private static final a f١٥٣٢٤h;

    /* renamed from: i, reason: collision with root package name */
    private static final a f١٥٣٢٥i;

    /* renamed from: j, reason: collision with root package name */
    private static final a f١٥٣٢٦j;

    /* renamed from: k, reason: collision with root package name */
    private static final a f١٥٣٢٧k;

    /* renamed from: l, reason: collision with root package name */
    private static final List f١٥٣٢٨l;

    /* renamed from: a, reason: collision with root package name */
    private final int f١٥٣٢٩a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f١٥٣٣٠b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        a aVar = new a() { // from class: j7.o0
            @Override // j7.v0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                v0.o(sQLiteDatabase);
            }
        };
        f١٥٣٢١e = aVar;
        a aVar2 = new a() { // from class: j7.p0
            @Override // j7.v0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                v0.q(sQLiteDatabase);
            }
        };
        f١٥٣٢٢f = aVar2;
        a aVar3 = new a() { // from class: j7.q0
            @Override // j7.v0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
            }
        };
        f١٥٣٢٣g = aVar3;
        a aVar4 = new a() { // from class: j7.r0
            @Override // j7.v0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                v0.t(sQLiteDatabase);
            }
        };
        f١٥٣٢٤h = aVar4;
        a aVar5 = new a() { // from class: j7.s0
            @Override // j7.v0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                v0.u(sQLiteDatabase);
            }
        };
        f١٥٣٢٥i = aVar5;
        a aVar6 = new a() { // from class: j7.t0
            @Override // j7.v0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN product_id INTEGER");
            }
        };
        f١٥٣٢٦j = aVar6;
        a aVar7 = new a() { // from class: j7.u0
            @Override // j7.v0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                v0.x(sQLiteDatabase);
            }
        };
        f١٥٣٢٧k = aVar7;
        f١٥٣٢٨l = Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v0(Context context, String str, int i10) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i10);
        this.f١٥٣٣٠b = false;
        this.f١٥٣٢٩a = i10;
    }

    private void A(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        List list = f١٥٣٢٨l;
        if (i11 <= list.size()) {
            while (i10 < i11) {
                ((a) f١٥٣٢٨l.get(i10)).a(sQLiteDatabase);
                i10++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i10 + " to " + i11 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    private void m(SQLiteDatabase sQLiteDatabase) {
        if (!this.f١٥٣٣٠b) {
            onConfigure(sQLiteDatabase);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        sQLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sQLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sQLiteDatabase.execSQL(f١٥٣١٩c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN pseudonymous_id TEXT");
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_clear_blob BLOB");
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_encrypted_blob BLOB");
    }

    private void z(SQLiteDatabase sQLiteDatabase, int i10) {
        m(sQLiteDatabase);
        A(sQLiteDatabase, 0, i10);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f١٥٣٣٠b = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        z(sQLiteDatabase, this.f١٥٣٢٩a);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        z(sQLiteDatabase, i11);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        m(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        m(sQLiteDatabase);
        A(sQLiteDatabase, i10, i11);
    }
}
