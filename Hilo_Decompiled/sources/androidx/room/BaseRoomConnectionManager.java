package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.room.BaseRoomConnectionManager;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenDelegate;
import androidx.room.concurrent.ExclusiveLock;
import androidx.room.migration.Migration;
import androidx.room.util.MigrationUtil;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.SQLiteStatement;
import anet.channel.entity.ConnType;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.liulishuo.okdownload.core.breakpoint.BreakpointSQLiteKey;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 ;2\u00020\u0001:\u0002:;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\u0006\u0010\u0016\u001a\u00020\u00122\"\u0010\u0017\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018H¦@¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0010¢\u0006\u0002\b\u001fJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010%\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010'\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010(\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0004J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010*\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010+\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J \u0010,\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0004J\u0010\u00100\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u00101\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0004J\u0010\u00102\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u00103\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0002J\f\u00104\u001a\u00020.*\u000205H\u0004J\f\u00106\u001a\u00020.*\u000205H\u0004J\u0010\u00107\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u00108\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u00109\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002R\u0012\u0010\u0004\u001a\u00020\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¤\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Landroidx/room/BaseRoomConnectionManager;", "", "<init>", "()V", "configuration", "Landroidx/room/DatabaseConfiguration;", "getConfiguration", "()Landroidx/room/DatabaseConfiguration;", "openDelegate", "Landroidx/room/RoomOpenDelegate;", "getOpenDelegate", "()Landroidx/room/RoomOpenDelegate;", "callbacks", "", "Landroidx/room/RoomDatabase$Callback;", "getCallbacks", "()Ljava/util/List;", "isConfigured", "", "isInitializing", "useConnection", "R", "isReadOnly", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function2;", "Landroidx/room/Transactor;", "Lkotlin/coroutines/Continuation;", "(ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveFileName", "", "fileName", "resolveFileName$room_runtime_release", "configureDatabase", "", "connection", "Landroidx/sqlite/SQLiteConnection;", "configurationConnection", "configureJournalMode", "configureSynchronousFlag", "configureBusyTimeout", "onCreate", "hasEmptySchema", "updateIdentity", "createMasterTableIfNotExists", "onMigrate", "oldVersion", "", "newVersion", "dropAllTables", "onOpen", "checkIdentity", "hasRoomMasterTable", "getMaxNumberOfReaders", "Landroidx/room/RoomDatabase$JournalMode;", "getMaxNumberOfWriters", "invokeCreateCallback", "invokeDestructiveMigrationCallback", "invokeOpenCallback", "DriverWrapper", "Companion", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nRoomConnectionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomConnectionManager.kt\nandroidx/room/BaseRoomConnectionManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,362:1\n1#2:363\n1863#3,2:364\n1863#3,2:366\n1863#3,2:368\n1863#3,2:370\n1863#3,2:372\n*S KotlinDebug\n*F\n+ 1 RoomConnectionManager.kt\nandroidx/room/BaseRoomConnectionManager\n*L\n209#1:364,2\n253#1:366,2\n342#1:368,2\n346#1:370,2\n350#1:372,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class BaseRoomConnectionManager {
    public static final int BUSY_TIMEOUT_MS = 3000;
    private boolean isConfigured;
    private boolean isInitializing;

    /* JADX INFO: Access modifiers changed from: protected */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0084\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/room/BaseRoomConnectionManager$DriverWrapper;", "Landroidx/sqlite/SQLiteDriver;", "actual", "<init>", "(Landroidx/room/BaseRoomConnectionManager;Landroidx/sqlite/SQLiteDriver;)V", ConnType.PK_OPEN, "Landroidx/sqlite/SQLiteConnection;", "fileName", "", "openLocked", BreakpointSQLiteKey.FILENAME, "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public final class DriverWrapper implements SQLiteDriver {

        @NotNull
        private final SQLiteDriver actual;
        final /* synthetic */ BaseRoomConnectionManager this$0;

        public DriverWrapper(@NotNull BaseRoomConnectionManager baseRoomConnectionManager, SQLiteDriver actual) {
            Intrinsics.checkNotNullParameter(actual, "actual");
            this.this$0 = baseRoomConnectionManager;
            this.actual = actual;
        }

        private final SQLiteConnection openLocked(final String filename) {
            boolean z10;
            if (!this.this$0.isConfigured && !this.this$0.isInitializing && !Intrinsics.areEqual(filename, ":memory:")) {
                z10 = true;
            } else {
                z10 = false;
            }
            ExclusiveLock exclusiveLock = new ExclusiveLock(filename, z10);
            final BaseRoomConnectionManager baseRoomConnectionManager = this.this$0;
            return (SQLiteConnection) exclusiveLock.withLock(new Function0() { // from class: androidx.room.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    SQLiteConnection openLocked$lambda$1;
                    openLocked$lambda$1 = BaseRoomConnectionManager.DriverWrapper.openLocked$lambda$1(BaseRoomConnectionManager.this, this, filename);
                    return openLocked$lambda$1;
                }
            }, new Function1() { // from class: androidx.room.BaseRoomConnectionManager$DriverWrapper$openLocked$2
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(Throwable error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    throw new IllegalStateException("Unable to open database '" + filename + "'. Was a proper path / name used in Room's database builder?", error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SQLiteConnection openLocked$lambda$1(BaseRoomConnectionManager baseRoomConnectionManager, DriverWrapper driverWrapper, String str) {
            if (!baseRoomConnectionManager.isInitializing) {
                SQLiteConnection open = driverWrapper.actual.open(str);
                if (baseRoomConnectionManager.isConfigured) {
                    baseRoomConnectionManager.configurationConnection(open);
                } else {
                    try {
                        baseRoomConnectionManager.isInitializing = true;
                        baseRoomConnectionManager.configureDatabase(open);
                    } finally {
                        baseRoomConnectionManager.isInitializing = false;
                    }
                }
                return open;
            }
            throw new IllegalStateException("Recursive database initialization detected. Did you try to use the database instance during initialization? Maybe in one of the callbacks?");
        }

        @Override // androidx.sqlite.SQLiteDriver
        @NotNull
        public SQLiteConnection open(@NotNull String fileName) {
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            return openLocked(this.this$0.resolveFileName$room_runtime_release(fileName));
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RoomDatabase.JournalMode.values().length];
            try {
                iArr[RoomDatabase.JournalMode.TRUNCATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void checkIdentity(SQLiteConnection connection) {
        Object obj;
        RoomOpenDelegate.ValidationResult onValidateSchema;
        String str;
        if (hasRoomMasterTable(connection)) {
            SQLiteStatement prepare = connection.prepare(RoomMasterTable.READ_QUERY);
            try {
                if (prepare.step()) {
                    str = prepare.getText(0);
                } else {
                    str = null;
                }
                AutoCloseableKt.closeFinally(prepare, null);
                if (!Intrinsics.areEqual(getOpenDelegate().getIdentityHash(), str) && !Intrinsics.areEqual(getOpenDelegate().getLegacyIdentityHash(), str)) {
                    throw new IllegalStateException(("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + getOpenDelegate().getIdentityHash() + ", found: " + str).toString());
                }
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(prepare, th);
                    throw th2;
                }
            }
        }
        SQLite.execSQL(connection, "BEGIN EXCLUSIVE TRANSACTION");
        try {
            Result.Companion companion = Result.INSTANCE;
            onValidateSchema = getOpenDelegate().onValidateSchema(connection);
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.INSTANCE;
            obj = Result.m٥٤٤constructorimpl(ResultKt.createFailure(th3));
        }
        if (onValidateSchema.isValid) {
            getOpenDelegate().onPostMigrate(connection);
            updateIdentity(connection);
            obj = Result.m٥٤٤constructorimpl(Unit.INSTANCE);
            if (Result.m٥٥١isSuccessimpl(obj)) {
                SQLite.execSQL(connection, "END TRANSACTION");
            }
            Throwable th4 = Result.m٥٤٧exceptionOrNullimpl(obj);
            if (th4 == null) {
                Result.m٥٤٣boximpl(obj);
                return;
            } else {
                SQLite.execSQL(connection, "ROLLBACK TRANSACTION");
                throw th4;
            }
        }
        throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configurationConnection(SQLiteConnection connection) {
        configureSynchronousFlag(connection);
        configureBusyTimeout(connection);
        getOpenDelegate().onOpen(connection);
    }

    private final void configureBusyTimeout(SQLiteConnection connection) {
        SQLiteStatement prepare = connection.prepare("PRAGMA busy_timeout");
        try {
            prepare.step();
            long j10 = prepare.getLong(0);
            AutoCloseableKt.closeFinally(prepare, null);
            if (j10 < 3000) {
                SQLite.execSQL(connection, "PRAGMA busy_timeout = 3000");
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(prepare, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configureDatabase(SQLiteConnection connection) {
        Object obj;
        configureJournalMode(connection);
        configureSynchronousFlag(connection);
        configureBusyTimeout(connection);
        SQLiteStatement prepare = connection.prepare("PRAGMA user_version");
        try {
            prepare.step();
            int i10 = (int) prepare.getLong(0);
            AutoCloseableKt.closeFinally(prepare, null);
            if (i10 != getOpenDelegate().getVersion()) {
                SQLite.execSQL(connection, "BEGIN EXCLUSIVE TRANSACTION");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    if (i10 == 0) {
                        onCreate(connection);
                    } else {
                        onMigrate(connection, i10, getOpenDelegate().getVersion());
                    }
                    SQLite.execSQL(connection, "PRAGMA user_version = " + getOpenDelegate().getVersion());
                    obj = Result.m٥٤٤constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    obj = Result.m٥٤٤constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m٥٥١isSuccessimpl(obj)) {
                    SQLite.execSQL(connection, "END TRANSACTION");
                }
                Throwable th2 = Result.m٥٤٧exceptionOrNullimpl(obj);
                if (th2 != null) {
                    SQLite.execSQL(connection, "ROLLBACK TRANSACTION");
                    throw th2;
                }
            }
            onOpen(connection);
        } finally {
        }
    }

    private final void configureJournalMode(SQLiteConnection connection) {
        if (getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            SQLite.execSQL(connection, "PRAGMA journal_mode = WAL");
        } else {
            SQLite.execSQL(connection, "PRAGMA journal_mode = TRUNCATE");
        }
    }

    private final void configureSynchronousFlag(SQLiteConnection connection) {
        if (getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            SQLite.execSQL(connection, "PRAGMA synchronous = NORMAL");
        } else {
            SQLite.execSQL(connection, "PRAGMA synchronous = FULL");
        }
    }

    private final void createMasterTableIfNotExists(SQLiteConnection connection) {
        SQLite.execSQL(connection, RoomMasterTable.CREATE_QUERY);
    }

    private final void dropAllTables(SQLiteConnection connection) {
        if (getConfiguration().allowDestructiveMigrationForAllTables) {
            SQLiteStatement prepare = connection.prepare("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
            try {
                List createListBuilder = CollectionsKt.createListBuilder();
                while (prepare.step()) {
                    String text = prepare.getText(0);
                    if (!StringsKt.startsWith$default(text, "sqlite_", false, 2, (Object) null) && !Intrinsics.areEqual(text, "android_metadata")) {
                        createListBuilder.add(TuplesKt.to(text, Boolean.valueOf(Intrinsics.areEqual(prepare.getText(1), ViewHierarchyConstants.VIEW_KEY))));
                    }
                }
                List<Pair> build = CollectionsKt.build(createListBuilder);
                AutoCloseableKt.closeFinally(prepare, null);
                for (Pair pair : build) {
                    String str = (String) pair.component1();
                    if (((Boolean) pair.component2()).booleanValue()) {
                        SQLite.execSQL(connection, "DROP VIEW IF EXISTS " + str);
                    } else {
                        SQLite.execSQL(connection, "DROP TABLE IF EXISTS " + str);
                    }
                }
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(prepare, th);
                    throw th2;
                }
            }
        }
        getOpenDelegate().dropAllTables(connection);
    }

    private final boolean hasEmptySchema(SQLiteConnection connection) {
        SQLiteStatement prepare = connection.prepare("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z10 = false;
            if (prepare.step()) {
                if (prepare.getLong(0) == 0) {
                    z10 = true;
                }
            }
            AutoCloseableKt.closeFinally(prepare, null);
            return z10;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(prepare, th);
                throw th2;
            }
        }
    }

    private final boolean hasRoomMasterTable(SQLiteConnection connection) {
        SQLiteStatement prepare = connection.prepare("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name = 'room_master_table'");
        try {
            boolean z10 = false;
            if (prepare.step()) {
                if (prepare.getLong(0) != 0) {
                    z10 = true;
                }
            }
            AutoCloseableKt.closeFinally(prepare, null);
            return z10;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(prepare, th);
                throw th2;
            }
        }
    }

    private final void invokeCreateCallback(SQLiteConnection connection) {
        Iterator<T> it = getCallbacks().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.Callback) it.next()).onCreate(connection);
        }
    }

    private final void invokeDestructiveMigrationCallback(SQLiteConnection connection) {
        Iterator<T> it = getCallbacks().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.Callback) it.next()).onDestructiveMigration(connection);
        }
    }

    private final void invokeOpenCallback(SQLiteConnection connection) {
        Iterator<T> it = getCallbacks().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.Callback) it.next()).onOpen(connection);
        }
    }

    private final void updateIdentity(SQLiteConnection connection) {
        createMasterTableIfNotExists(connection);
        SQLite.execSQL(connection, RoomMasterTable.createInsertQuery(getOpenDelegate().getIdentityHash()));
    }

    @NotNull
    protected abstract List<RoomDatabase.Callback> getCallbacks();

    @NotNull
    protected abstract DatabaseConfiguration getConfiguration();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getMaxNumberOfReaders(@NotNull RoomDatabase.JournalMode journalMode) {
        Intrinsics.checkNotNullParameter(journalMode, "<this>");
        int i10 = WhenMappings.$EnumSwitchMapping$0[journalMode.ordinal()];
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2) {
            return 4;
        }
        throw new IllegalStateException(("Can't get max number of reader for journal mode '" + journalMode + '\'').toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getMaxNumberOfWriters(@NotNull RoomDatabase.JournalMode journalMode) {
        Intrinsics.checkNotNullParameter(journalMode, "<this>");
        int i10 = WhenMappings.$EnumSwitchMapping$0[journalMode.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return 1;
        }
        throw new IllegalStateException(("Can't get max number of writers for journal mode '" + journalMode + '\'').toString());
    }

    @NotNull
    protected abstract RoomOpenDelegate getOpenDelegate();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void onCreate(@NotNull SQLiteConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        boolean hasEmptySchema = hasEmptySchema(connection);
        getOpenDelegate().createAllTables(connection);
        if (!hasEmptySchema) {
            RoomOpenDelegate.ValidationResult onValidateSchema = getOpenDelegate().onValidateSchema(connection);
            if (!onValidateSchema.isValid) {
                throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg).toString());
            }
        }
        updateIdentity(connection);
        getOpenDelegate().onCreate(connection);
        invokeCreateCallback(connection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void onMigrate(@NotNull SQLiteConnection connection, int oldVersion, int newVersion) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        List<Migration> findMigrationPath = MigrationUtil.findMigrationPath(getConfiguration().migrationContainer, oldVersion, newVersion);
        if (findMigrationPath != null) {
            getOpenDelegate().onPreMigrate(connection);
            Iterator<T> it = findMigrationPath.iterator();
            while (it.hasNext()) {
                ((Migration) it.next()).migrate(connection);
            }
            RoomOpenDelegate.ValidationResult onValidateSchema = getOpenDelegate().onValidateSchema(connection);
            if (onValidateSchema.isValid) {
                getOpenDelegate().onPostMigrate(connection);
                updateIdentity(connection);
                return;
            } else {
                throw new IllegalStateException(("Migration didn't properly handle: " + onValidateSchema.expectedFoundMsg).toString());
            }
        }
        if (!MigrationUtil.isMigrationRequired(getConfiguration(), oldVersion, newVersion)) {
            dropAllTables(connection);
            invokeDestructiveMigrationCallback(connection);
            getOpenDelegate().createAllTables(connection);
        } else {
            throw new IllegalStateException(("A migration from " + oldVersion + " to " + newVersion + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* functions.").toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void onOpen(@NotNull SQLiteConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        checkIdentity(connection);
        getOpenDelegate().onOpen(connection);
        invokeOpenCallback(connection);
        this.isConfigured = true;
    }

    @NotNull
    public String resolveFileName$room_runtime_release(@NotNull String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return fileName;
    }

    @Nullable
    public abstract <R> Object useConnection(boolean z10, @NotNull Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation);
}
