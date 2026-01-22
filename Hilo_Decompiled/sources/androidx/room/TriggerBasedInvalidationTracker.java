package androidx.room;

import androidx.room.concurrent.CloseBarrier;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import anet.channel.request.Request;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u0000 O2\u00020\u0001:\u0001OBo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&J9\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\fH\u0000¢\u0006\u0004\b-\u0010.J1\u0010/\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n\u0012\u0004\u0012\u00020+002\u000e\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\nH\u0000¢\u0006\u0004\b2\u00103J#\u00104\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u000e\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\nH\u0002¢\u0006\u0002\u00105J\u0015\u00106\u001a\u00020\f2\u0006\u0010*\u001a\u00020+H\u0000¢\u0006\u0002\b7J\u0015\u00108\u001a\u00020\f2\u0006\u0010*\u001a\u00020+H\u0000¢\u0006\u0002\b9J\u0010\u0010:\u001a\u00020\u0010H\u0080@¢\u0006\u0004\b;\u0010<J\u001e\u0010=\u001a\u00020\u00102\u0006\u0010%\u001a\u00020>2\u0006\u0010?\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010@J\u001e\u0010A\u001a\u00020\u00102\u0006\u0010%\u001a\u00020>2\u0006\u0010?\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010@J@\u0010B\u001a\u00020\f2\u000e\u0010C\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\n2\u000e\b\u0002\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00100\u001f2\u000e\b\u0002\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00100\u001fH\u0080@¢\u0006\u0004\bF\u0010GJ-\u0010H\u001a\u00020\u00102\u000e\b\u0002\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00100\u001f2\u000e\b\u0002\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00100\u001fH\u0000¢\u0006\u0002\bIJ\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\u0082@¢\u0006\u0002\u0010<J\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\u0006\u0010%\u001a\u00020>H\u0082@¢\u0006\u0002\u0010LJ\r\u0010M\u001a\u00020\u0010H\u0000¢\u0006\u0002\bNR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00060\u001bj\u0002`\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006P"}, d2 = {"Landroidx/room/TriggerBasedInvalidationTracker;", "", "database", "Landroidx/room/RoomDatabase;", "shadowTablesMap", "", "", "viewTables", "", "tableNames", "", "useTempTable", "", "onInvalidatedTablesIds", "Lkotlin/Function1;", "", "", "<init>", "(Landroidx/room/RoomDatabase;Ljava/util/Map;Ljava/util/Map;[Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "tableIdLookup", "tablesNames", "[Ljava/lang/String;", "observedTableStates", "Landroidx/room/ObservedTableStates;", "observedTableVersions", "Landroidx/room/ObservedTableVersions;", "pendingRefresh", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroidx/room/concurrent/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onAllowRefresh", "Lkotlin/Function0;", "getOnAllowRefresh$room_runtime_release", "()Lkotlin/jvm/functions/Function0;", "setOnAllowRefresh$room_runtime_release", "(Lkotlin/jvm/functions/Function0;)V", "configureConnection", "connection", "Landroidx/sqlite/SQLiteConnection;", "createFlow", "Lkotlinx/coroutines/flow/Flow;", "resolvedTableNames", "tableIds", "", "emitInitialState", "createFlow$room_runtime_release", "([Ljava/lang/String;[IZ)Lkotlinx/coroutines/flow/Flow;", "validateTableNames", "Lkotlin/Pair;", "names", "validateTableNames$room_runtime_release", "([Ljava/lang/String;)Lkotlin/Pair;", "resolveViews", "([Ljava/lang/String;)[Ljava/lang/String;", "onObserverAdded", "onObserverAdded$room_runtime_release", "onObserverRemoved", "onObserverRemoved$room_runtime_release", "syncTriggers", "syncTriggers$room_runtime_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startTrackingTable", "Landroidx/room/PooledConnection;", "tableId", "(Landroidx/room/PooledConnection;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopTrackingTable", "refreshInvalidation", "tables", "onRefreshScheduled", "onRefreshCompleted", "refreshInvalidation$room_runtime_release", "([Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshInvalidationAsync", "refreshInvalidationAsync$room_runtime_release", "notifyInvalidation", "checkInvalidatedTables", "(Landroidx/room/PooledConnection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetSync", "resetSync$room_runtime_release", "Companion", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInvalidationTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/TriggerBasedInvalidationTracker\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 6 CloseBarrier.kt\nandroidx/room/concurrent/CloseBarrierKt\n*L\n1#1,604:1\n216#2,2:605\n13402#3:607\n13403#3:609\n12597#3,2:621\n1#4:608\n37#5:610\n36#5,3:611\n99#6,7:614\n99#6,5:623\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/TriggerBasedInvalidationTracker\n*L\n185#1:605,2\n283#1:607\n283#1:609\n369#1:621,2\n287#1:610\n287#1:611,3\n299#1:614,7\n402#1:623,5\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class TriggerBasedInvalidationTracker {

    @NotNull
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";

    @NotNull
    private static final String DROP_TRACKING_TABLE_SQL = "DROP TABLE IF EXISTS room_table_modification_log";

    @NotNull
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";

    @NotNull
    private static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1";

    @NotNull
    private static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1";

    @NotNull
    private static final String TABLE_ID_COLUMN_NAME = "table_id";

    @NotNull
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";

    @NotNull
    private final RoomDatabase database;

    @NotNull
    private final ObservedTableStates observedTableStates;

    @NotNull
    private final ObservedTableVersions observedTableVersions;

    @NotNull
    private Function0<Boolean> onAllowRefresh;

    @NotNull
    private final Function1<Set<Integer>, Unit> onInvalidatedTablesIds;

    @NotNull
    private final AtomicBoolean pendingRefresh;

    @NotNull
    private final Map<String, String> shadowTablesMap;

    @NotNull
    private final Map<String, Integer> tableIdLookup;

    @NotNull
    private final String[] tablesNames;
    private final boolean useTempTable;

    @NotNull
    private final Map<String, Set<String>> viewTables;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String[] TRIGGERS = {"INSERT", "UPDATE", Request.Method.DELETE};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/room/TriggerBasedInvalidationTracker$Companion;", "", "<init>", "()V", "TRIGGERS", "", "", "[Ljava/lang/String;", "UPDATE_TABLE_NAME", "TABLE_ID_COLUMN_NAME", "INVALIDATED_COLUMN_NAME", "CREATE_TRACKING_TABLE_SQL", "DROP_TRACKING_TABLE_SQL", "SELECT_UPDATED_TABLES_SQL", "RESET_UPDATED_TABLES_SQL", "getTriggerName", "tableName", "triggerType", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getTriggerName(String tableName, String triggerType) {
            return "room_table_modification_trigger_" + tableName + '_' + triggerType;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TriggerBasedInvalidationTracker(@NotNull RoomDatabase database, @NotNull Map<String, String> shadowTablesMap, @NotNull Map<String, ? extends Set<String>> viewTables, @NotNull String[] tableNames, boolean z10, @NotNull Function1<? super Set<Integer>, Unit> onInvalidatedTablesIds) {
        String str;
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(shadowTablesMap, "shadowTablesMap");
        Intrinsics.checkNotNullParameter(viewTables, "viewTables");
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        Intrinsics.checkNotNullParameter(onInvalidatedTablesIds, "onInvalidatedTablesIds");
        this.database = database;
        this.shadowTablesMap = shadowTablesMap;
        this.viewTables = viewTables;
        this.useTempTable = z10;
        this.onInvalidatedTablesIds = onInvalidatedTablesIds;
        this.pendingRefresh = new AtomicBoolean(false);
        this.onAllowRefresh = new Function0() { // from class: androidx.room.c0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean onAllowRefresh$lambda$0;
                onAllowRefresh$lambda$0 = TriggerBasedInvalidationTracker.onAllowRefresh$lambda$0();
                return Boolean.valueOf(onAllowRefresh$lambda$0);
            }
        };
        this.tableIdLookup = new LinkedHashMap();
        int length = tableNames.length;
        String[] strArr = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str2 = tableNames[i10];
            Locale locale = Locale.ROOT;
            String lowerCase = str2.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            this.tableIdLookup.put(lowerCase, Integer.valueOf(i10));
            String str3 = this.shadowTablesMap.get(tableNames[i10]);
            if (str3 != null) {
                str = str3.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
            } else {
                str = null;
            }
            if (str != null) {
                lowerCase = str;
            }
            strArr[i10] = lowerCase;
        }
        this.tablesNames = strArr;
        for (Map.Entry<String, String> entry : this.shadowTablesMap.entrySet()) {
            String value = entry.getValue();
            Locale locale2 = Locale.ROOT;
            String lowerCase2 = value.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (this.tableIdLookup.containsKey(lowerCase2)) {
                String lowerCase3 = entry.getKey().toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                Map<String, Integer> map = this.tableIdLookup;
                map.put(lowerCase3, MapsKt.getValue(map, lowerCase2));
            }
        }
        this.observedTableStates = new ObservedTableStates(this.tablesNames.length);
        this.observedTableVersions = new ObservedTableVersions(this.tablesNames.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkInvalidatedTables(PooledConnection pooledConnection, Continuation<? super Set<Integer>> continuation) {
        TriggerBasedInvalidationTracker$checkInvalidatedTables$1 triggerBasedInvalidationTracker$checkInvalidatedTables$1;
        int i10;
        Set set;
        Set set2;
        if (continuation instanceof TriggerBasedInvalidationTracker$checkInvalidatedTables$1) {
            triggerBasedInvalidationTracker$checkInvalidatedTables$1 = (TriggerBasedInvalidationTracker$checkInvalidatedTables$1) continuation;
            int i11 = triggerBasedInvalidationTracker$checkInvalidatedTables$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                triggerBasedInvalidationTracker$checkInvalidatedTables$1.label = i11 - Integer.MIN_VALUE;
                Object obj = triggerBasedInvalidationTracker$checkInvalidatedTables$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i10 = triggerBasedInvalidationTracker$checkInvalidatedTables$1.label;
                if (i10 == 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            set2 = (Set) triggerBasedInvalidationTracker$checkInvalidatedTables$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            return set2;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    pooledConnection = (PooledConnection) triggerBasedInvalidationTracker$checkInvalidatedTables$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    Function1 function1 = new Function1() { // from class: androidx.room.z
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Set checkInvalidatedTables$lambda$14;
                            checkInvalidatedTables$lambda$14 = TriggerBasedInvalidationTracker.checkInvalidatedTables$lambda$14((SQLiteStatement) obj2);
                            return checkInvalidatedTables$lambda$14;
                        }
                    };
                    triggerBasedInvalidationTracker$checkInvalidatedTables$1.L$0 = pooledConnection;
                    triggerBasedInvalidationTracker$checkInvalidatedTables$1.label = 1;
                    obj = pooledConnection.usePrepared(SELECT_UPDATED_TABLES_SQL, function1, triggerBasedInvalidationTracker$checkInvalidatedTables$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                set = (Set) obj;
                if (set.isEmpty()) {
                    triggerBasedInvalidationTracker$checkInvalidatedTables$1.L$0 = set;
                    triggerBasedInvalidationTracker$checkInvalidatedTables$1.label = 2;
                    if (TransactorKt.execSQL(pooledConnection, RESET_UPDATED_TABLES_SQL, triggerBasedInvalidationTracker$checkInvalidatedTables$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    set2 = set;
                    return set2;
                }
                return set;
            }
        }
        triggerBasedInvalidationTracker$checkInvalidatedTables$1 = new TriggerBasedInvalidationTracker$checkInvalidatedTables$1(this, continuation);
        Object obj2 = triggerBasedInvalidationTracker$checkInvalidatedTables$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = triggerBasedInvalidationTracker$checkInvalidatedTables$1.label;
        if (i10 == 0) {
        }
        set = (Set) obj2;
        if (set.isEmpty()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set checkInvalidatedTables$lambda$14(SQLiteStatement statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        Set createSetBuilder = SetsKt.createSetBuilder();
        while (statement.step()) {
            createSetBuilder.add(Integer.valueOf((int) statement.getLong(0)));
        }
        return SetsKt.build(createSetBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0096 A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:11:0x002d, B:12:0x008e, B:14:0x0096), top: B:10:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object notifyInvalidation(Continuation<? super Set<Integer>> continuation) {
        TriggerBasedInvalidationTracker$notifyInvalidation$1 triggerBasedInvalidationTracker$notifyInvalidation$1;
        int i10;
        CloseBarrier closeBarrier;
        Throwable th;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker;
        Set<Integer> set;
        if (continuation instanceof TriggerBasedInvalidationTracker$notifyInvalidation$1) {
            triggerBasedInvalidationTracker$notifyInvalidation$1 = (TriggerBasedInvalidationTracker$notifyInvalidation$1) continuation;
            int i11 = triggerBasedInvalidationTracker$notifyInvalidation$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                triggerBasedInvalidationTracker$notifyInvalidation$1.label = i11 - Integer.MIN_VALUE;
                Object obj = triggerBasedInvalidationTracker$notifyInvalidation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i10 = triggerBasedInvalidationTracker$notifyInvalidation$1.label;
                if (i10 == 0) {
                    if (i10 == 1) {
                        closeBarrier = (CloseBarrier) triggerBasedInvalidationTracker$notifyInvalidation$1.L$1;
                        triggerBasedInvalidationTracker = (TriggerBasedInvalidationTracker) triggerBasedInvalidationTracker$notifyInvalidation$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th2) {
                            th = th2;
                            closeBarrier.unblock$room_runtime_release();
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    CloseBarrier closeBarrier2 = this.database.getCloseBarrier();
                    if (closeBarrier2.block$room_runtime_release()) {
                        try {
                            if (!this.pendingRefresh.compareAndSet(true, false)) {
                                Set emptySet = SetsKt.emptySet();
                                closeBarrier2.unblock$room_runtime_release();
                                return emptySet;
                            }
                            if (!this.onAllowRefresh.invoke().booleanValue()) {
                                Set emptySet2 = SetsKt.emptySet();
                                closeBarrier2.unblock$room_runtime_release();
                                return emptySet2;
                            }
                            RoomDatabase roomDatabase = this.database;
                            TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 triggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 = new TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1(this, null);
                            triggerBasedInvalidationTracker$notifyInvalidation$1.L$0 = this;
                            triggerBasedInvalidationTracker$notifyInvalidation$1.L$1 = closeBarrier2;
                            triggerBasedInvalidationTracker$notifyInvalidation$1.label = 1;
                            Object useConnection$room_runtime_release = roomDatabase.useConnection$room_runtime_release(false, triggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1, triggerBasedInvalidationTracker$notifyInvalidation$1);
                            if (useConnection$room_runtime_release == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            closeBarrier = closeBarrier2;
                            obj = useConnection$room_runtime_release;
                            triggerBasedInvalidationTracker = this;
                        } catch (Throwable th3) {
                            closeBarrier = closeBarrier2;
                            th = th3;
                            closeBarrier.unblock$room_runtime_release();
                            throw th;
                        }
                    } else {
                        return SetsKt.emptySet();
                    }
                }
                set = (Set) obj;
                if (!set.isEmpty()) {
                    triggerBasedInvalidationTracker.observedTableVersions.increment(set);
                    triggerBasedInvalidationTracker.onInvalidatedTablesIds.invoke(set);
                }
                closeBarrier.unblock$room_runtime_release();
                return set;
            }
        }
        triggerBasedInvalidationTracker$notifyInvalidation$1 = new TriggerBasedInvalidationTracker$notifyInvalidation$1(this, continuation);
        Object obj2 = triggerBasedInvalidationTracker$notifyInvalidation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = triggerBasedInvalidationTracker$notifyInvalidation$1.label;
        if (i10 == 0) {
        }
        set = (Set) obj2;
        if (!set.isEmpty()) {
        }
        closeBarrier.unblock$room_runtime_release();
        return set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onAllowRefresh$lambda$0() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object refreshInvalidation$room_runtime_release$default(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, String[] strArr, Function0 function0, Function0 function02, Continuation continuation, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            function0 = new Function0() { // from class: androidx.room.x
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        if ((i10 & 4) != 0) {
            function02 = new Function0() { // from class: androidx.room.y
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        return triggerBasedInvalidationTracker.refreshInvalidation$room_runtime_release(strArr, function0, function02, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void refreshInvalidationAsync$room_runtime_release$default(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, Function0 function0, Function0 function02, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function0 = new Function0() { // from class: androidx.room.a0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        if ((i10 & 2) != 0) {
            function02 = new Function0() { // from class: androidx.room.b0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        triggerBasedInvalidationTracker.refreshInvalidationAsync$room_runtime_release(function0, function02);
    }

    private final String[] resolveViews(String[] names) {
        Set createSetBuilder = SetsKt.createSetBuilder();
        for (String str : names) {
            Map<String, Set<String>> map = this.viewTables;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Set<String> set = map.get(lowerCase);
            if (set != null) {
                createSetBuilder.addAll(set);
            } else {
                createSetBuilder.add(str);
            }
        }
        return (String[]) SetsKt.build(createSetBuilder).toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00fb -> B:11:0x0049). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startTrackingTable(PooledConnection pooledConnection, int i10, Continuation<? super Unit> continuation) {
        TriggerBasedInvalidationTracker$startTrackingTable$1 triggerBasedInvalidationTracker$startTrackingTable$1;
        int i11;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker;
        String[] strArr;
        PooledConnection pooledConnection2;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker2;
        int length;
        int i12;
        String str;
        int i13;
        String str2;
        PooledConnection pooledConnection3 = pooledConnection;
        int i14 = i10;
        if (continuation instanceof TriggerBasedInvalidationTracker$startTrackingTable$1) {
            triggerBasedInvalidationTracker$startTrackingTable$1 = (TriggerBasedInvalidationTracker$startTrackingTable$1) continuation;
            int i15 = triggerBasedInvalidationTracker$startTrackingTable$1.label;
            if ((i15 & Integer.MIN_VALUE) != 0) {
                triggerBasedInvalidationTracker$startTrackingTable$1.label = i15 - Integer.MIN_VALUE;
                Object obj = triggerBasedInvalidationTracker$startTrackingTable$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i11 = triggerBasedInvalidationTracker$startTrackingTable$1.label;
                if (i11 == 0) {
                    if (i11 != 1) {
                        if (i11 == 2) {
                            length = triggerBasedInvalidationTracker$startTrackingTable$1.I$2;
                            i13 = triggerBasedInvalidationTracker$startTrackingTable$1.I$1;
                            i12 = triggerBasedInvalidationTracker$startTrackingTable$1.I$0;
                            strArr = (String[]) triggerBasedInvalidationTracker$startTrackingTable$1.L$3;
                            str = (String) triggerBasedInvalidationTracker$startTrackingTable$1.L$2;
                            pooledConnection2 = (PooledConnection) triggerBasedInvalidationTracker$startTrackingTable$1.L$1;
                            triggerBasedInvalidationTracker2 = (TriggerBasedInvalidationTracker) triggerBasedInvalidationTracker$startTrackingTable$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            i13++;
                            if (i13 >= length) {
                                String str3 = strArr[i13];
                                if (triggerBasedInvalidationTracker2.useTempTable) {
                                    str2 = "TEMP";
                                } else {
                                    str2 = "";
                                }
                                String str4 = "CREATE " + str2 + " TRIGGER IF NOT EXISTS `" + INSTANCE.getTriggerName(str, str3) + "` AFTER " + str3 + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + i12 + " AND invalidated = 0; END";
                                triggerBasedInvalidationTracker$startTrackingTable$1.L$0 = triggerBasedInvalidationTracker2;
                                triggerBasedInvalidationTracker$startTrackingTable$1.L$1 = pooledConnection2;
                                triggerBasedInvalidationTracker$startTrackingTable$1.L$2 = str;
                                triggerBasedInvalidationTracker$startTrackingTable$1.L$3 = strArr;
                                triggerBasedInvalidationTracker$startTrackingTable$1.I$0 = i12;
                                triggerBasedInvalidationTracker$startTrackingTable$1.I$1 = i13;
                                triggerBasedInvalidationTracker$startTrackingTable$1.I$2 = length;
                                triggerBasedInvalidationTracker$startTrackingTable$1.label = 2;
                                if (TransactorKt.execSQL(pooledConnection2, str4, triggerBasedInvalidationTracker$startTrackingTable$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                i13++;
                                if (i13 >= length) {
                                    return Unit.INSTANCE;
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        int i16 = triggerBasedInvalidationTracker$startTrackingTable$1.I$0;
                        PooledConnection pooledConnection4 = (PooledConnection) triggerBasedInvalidationTracker$startTrackingTable$1.L$1;
                        triggerBasedInvalidationTracker = (TriggerBasedInvalidationTracker) triggerBasedInvalidationTracker$startTrackingTable$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        i14 = i16;
                        pooledConnection3 = pooledConnection4;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    String str5 = "INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i14 + ", 0)";
                    triggerBasedInvalidationTracker$startTrackingTable$1.L$0 = this;
                    triggerBasedInvalidationTracker$startTrackingTable$1.L$1 = pooledConnection3;
                    triggerBasedInvalidationTracker$startTrackingTable$1.I$0 = i14;
                    triggerBasedInvalidationTracker$startTrackingTable$1.label = 1;
                    if (TransactorKt.execSQL(pooledConnection3, str5, triggerBasedInvalidationTracker$startTrackingTable$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    triggerBasedInvalidationTracker = this;
                }
                String str6 = triggerBasedInvalidationTracker.tablesNames[i14];
                strArr = TRIGGERS;
                pooledConnection2 = pooledConnection3;
                triggerBasedInvalidationTracker2 = triggerBasedInvalidationTracker;
                length = strArr.length;
                i12 = i14;
                str = str6;
                i13 = 0;
                if (i13 >= length) {
                }
            }
        }
        triggerBasedInvalidationTracker$startTrackingTable$1 = new TriggerBasedInvalidationTracker$startTrackingTable$1(this, continuation);
        Object obj2 = triggerBasedInvalidationTracker$startTrackingTable$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i11 = triggerBasedInvalidationTracker$startTrackingTable$1.label;
        if (i11 == 0) {
        }
        String str62 = triggerBasedInvalidationTracker.tablesNames[i14];
        strArr = TRIGGERS;
        pooledConnection2 = pooledConnection3;
        triggerBasedInvalidationTracker2 = triggerBasedInvalidationTracker;
        length = strArr.length;
        i12 = i14;
        str = str62;
        i13 = 0;
        if (i13 >= length) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0085 -> B:10:0x0087). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object stopTrackingTable(PooledConnection pooledConnection, int i10, Continuation<? super Unit> continuation) {
        TriggerBasedInvalidationTracker$stopTrackingTable$1 triggerBasedInvalidationTracker$stopTrackingTable$1;
        int i11;
        int i12;
        PooledConnection pooledConnection2;
        int length;
        String[] strArr;
        String str;
        if (continuation instanceof TriggerBasedInvalidationTracker$stopTrackingTable$1) {
            triggerBasedInvalidationTracker$stopTrackingTable$1 = (TriggerBasedInvalidationTracker$stopTrackingTable$1) continuation;
            int i13 = triggerBasedInvalidationTracker$stopTrackingTable$1.label;
            if ((i13 & Integer.MIN_VALUE) != 0) {
                triggerBasedInvalidationTracker$stopTrackingTable$1.label = i13 - Integer.MIN_VALUE;
                Object obj = triggerBasedInvalidationTracker$stopTrackingTable$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i11 = triggerBasedInvalidationTracker$stopTrackingTable$1.label;
                if (i11 == 0) {
                    if (i11 == 1) {
                        length = triggerBasedInvalidationTracker$stopTrackingTable$1.I$1;
                        int i14 = triggerBasedInvalidationTracker$stopTrackingTable$1.I$0;
                        strArr = (String[]) triggerBasedInvalidationTracker$stopTrackingTable$1.L$2;
                        String str2 = (String) triggerBasedInvalidationTracker$stopTrackingTable$1.L$1;
                        PooledConnection pooledConnection3 = (PooledConnection) triggerBasedInvalidationTracker$stopTrackingTable$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        str = str2;
                        i12 = i14 + 1;
                        pooledConnection2 = pooledConnection3;
                        if (i12 < length) {
                            String str3 = "DROP TRIGGER IF EXISTS `" + INSTANCE.getTriggerName(str, strArr[i12]) + '`';
                            triggerBasedInvalidationTracker$stopTrackingTable$1.L$0 = pooledConnection2;
                            triggerBasedInvalidationTracker$stopTrackingTable$1.L$1 = str;
                            triggerBasedInvalidationTracker$stopTrackingTable$1.L$2 = strArr;
                            triggerBasedInvalidationTracker$stopTrackingTable$1.I$0 = i12;
                            triggerBasedInvalidationTracker$stopTrackingTable$1.I$1 = length;
                            triggerBasedInvalidationTracker$stopTrackingTable$1.label = 1;
                            if (TransactorKt.execSQL(pooledConnection2, str3, triggerBasedInvalidationTracker$stopTrackingTable$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            pooledConnection3 = pooledConnection2;
                            i14 = i12;
                            i12 = i14 + 1;
                            pooledConnection2 = pooledConnection3;
                            if (i12 < length) {
                                return Unit.INSTANCE;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    String str4 = this.tablesNames[i10];
                    String[] strArr2 = TRIGGERS;
                    i12 = 0;
                    pooledConnection2 = pooledConnection;
                    length = strArr2.length;
                    strArr = strArr2;
                    str = str4;
                    if (i12 < length) {
                    }
                }
            }
        }
        triggerBasedInvalidationTracker$stopTrackingTable$1 = new TriggerBasedInvalidationTracker$stopTrackingTable$1(this, continuation);
        Object obj2 = triggerBasedInvalidationTracker$stopTrackingTable$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i11 = triggerBasedInvalidationTracker$stopTrackingTable$1.label;
        if (i11 == 0) {
        }
    }

    public final void configureConnection(@NotNull SQLiteConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        SQLiteStatement prepare = connection.prepare("PRAGMA query_only");
        try {
            prepare.step();
            boolean z10 = prepare.getBoolean(0);
            AutoCloseableKt.closeFinally(prepare, null);
            if (!z10) {
                SQLite.execSQL(connection, "PRAGMA temp_store = MEMORY");
                SQLite.execSQL(connection, "PRAGMA recursive_triggers = 1");
                SQLite.execSQL(connection, DROP_TRACKING_TABLE_SQL);
                if (this.useTempTable) {
                    SQLite.execSQL(connection, CREATE_TRACKING_TABLE_SQL);
                } else {
                    SQLite.execSQL(connection, StringsKt.replace$default(CREATE_TRACKING_TABLE_SQL, "TEMP", "", false, 4, (Object) null));
                }
                this.observedTableStates.forceNeedSync$room_runtime_release();
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

    @NotNull
    public final Flow<Set<String>> createFlow$room_runtime_release(@NotNull String[] resolvedTableNames, @NotNull int[] tableIds, boolean emitInitialState) {
        Intrinsics.checkNotNullParameter(resolvedTableNames, "resolvedTableNames");
        Intrinsics.checkNotNullParameter(tableIds, "tableIds");
        return FlowKt.flow(new TriggerBasedInvalidationTracker$createFlow$1(this, tableIds, emitInitialState, resolvedTableNames, null));
    }

    @NotNull
    public final Function0<Boolean> getOnAllowRefresh$room_runtime_release() {
        return this.onAllowRefresh;
    }

    public final boolean onObserverAdded$room_runtime_release(@NotNull int[] tableIds) {
        Intrinsics.checkNotNullParameter(tableIds, "tableIds");
        return this.observedTableStates.onObserverAdded$room_runtime_release(tableIds);
    }

    public final boolean onObserverRemoved$room_runtime_release(@NotNull int[] tableIds) {
        Intrinsics.checkNotNullParameter(tableIds, "tableIds");
        return this.observedTableStates.onObserverRemoved$room_runtime_release(tableIds);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x007e, code lost:
    
        if (r8.isEmpty() == false) goto L٣٦;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0064 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:11:0x002e, B:12:0x0059, B:16:0x0064, B:18:0x0068, B:23:0x0080, B:20:0x0075, B:30:0x007a, B:36:0x004c), top: B:7:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007a A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:11:0x002e, B:12:0x0059, B:16:0x0064, B:18:0x0068, B:23:0x0080, B:20:0x0075, B:30:0x007a, B:36:0x004c), top: B:7:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshInvalidation$room_runtime_release(@NotNull String[] strArr, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, @NotNull Continuation<? super Boolean> continuation) {
        TriggerBasedInvalidationTracker$refreshInvalidation$1 triggerBasedInvalidationTracker$refreshInvalidation$1;
        int i10;
        int[] component2;
        boolean z10;
        try {
            if (continuation instanceof TriggerBasedInvalidationTracker$refreshInvalidation$1) {
                triggerBasedInvalidationTracker$refreshInvalidation$1 = (TriggerBasedInvalidationTracker$refreshInvalidation$1) continuation;
                int i11 = triggerBasedInvalidationTracker$refreshInvalidation$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    triggerBasedInvalidationTracker$refreshInvalidation$1.label = i11 - Integer.MIN_VALUE;
                    Object obj = triggerBasedInvalidationTracker$refreshInvalidation$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i10 = triggerBasedInvalidationTracker$refreshInvalidation$1.label;
                    boolean z11 = true;
                    if (i10 == 0) {
                        if (i10 == 1) {
                            component2 = (int[]) triggerBasedInvalidationTracker$refreshInvalidation$1.L$1;
                            function02 = (Function0) triggerBasedInvalidationTracker$refreshInvalidation$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        component2 = validateTableNames$room_runtime_release(strArr).component2();
                        function0.invoke();
                        triggerBasedInvalidationTracker$refreshInvalidation$1.L$0 = function02;
                        triggerBasedInvalidationTracker$refreshInvalidation$1.L$1 = component2;
                        triggerBasedInvalidationTracker$refreshInvalidation$1.label = 1;
                        obj = notifyInvalidation(triggerBasedInvalidationTracker$refreshInvalidation$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    Set set = (Set) obj;
                    if (component2.length != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        for (int i12 : component2) {
                            if (set.contains(Boxing.boxInt(i12))) {
                                break;
                            }
                        }
                        z11 = false;
                        return Boxing.boxBoolean(z11);
                    }
                }
            }
            if (i10 == 0) {
            }
            Set set2 = (Set) obj;
            if (component2.length != 0) {
            }
            if (z10) {
            }
        } finally {
            function02.invoke();
        }
        triggerBasedInvalidationTracker$refreshInvalidation$1 = new TriggerBasedInvalidationTracker$refreshInvalidation$1(this, continuation);
        Object obj2 = triggerBasedInvalidationTracker$refreshInvalidation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = triggerBasedInvalidationTracker$refreshInvalidation$1.label;
        boolean z112 = true;
    }

    public final void refreshInvalidationAsync$room_runtime_release(@NotNull Function0<Unit> onRefreshScheduled, @NotNull Function0<Unit> onRefreshCompleted) {
        Intrinsics.checkNotNullParameter(onRefreshScheduled, "onRefreshScheduled");
        Intrinsics.checkNotNullParameter(onRefreshCompleted, "onRefreshCompleted");
        if (this.pendingRefresh.compareAndSet(false, true)) {
            onRefreshScheduled.invoke();
            BuildersKt__Builders_commonKt.launch$default(this.database.getCoroutineScope(), new CoroutineName("Room Invalidation Tracker Refresh"), null, new TriggerBasedInvalidationTracker$refreshInvalidationAsync$3(this, onRefreshCompleted, null), 2, null);
        }
    }

    public final void resetSync$room_runtime_release() {
        this.observedTableStates.resetTriggerState$room_runtime_release();
    }

    public final void setOnAllowRefresh$room_runtime_release(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onAllowRefresh = function0;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object syncTriggers$room_runtime_release(@NotNull Continuation<? super Unit> continuation) {
        TriggerBasedInvalidationTracker$syncTriggers$1 triggerBasedInvalidationTracker$syncTriggers$1;
        int i10;
        CloseBarrier closeBarrier;
        Throwable th;
        if (continuation instanceof TriggerBasedInvalidationTracker$syncTriggers$1) {
            triggerBasedInvalidationTracker$syncTriggers$1 = (TriggerBasedInvalidationTracker$syncTriggers$1) continuation;
            int i11 = triggerBasedInvalidationTracker$syncTriggers$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                triggerBasedInvalidationTracker$syncTriggers$1.label = i11 - Integer.MIN_VALUE;
                Object obj = triggerBasedInvalidationTracker$syncTriggers$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i10 = triggerBasedInvalidationTracker$syncTriggers$1.label;
                if (i10 == 0) {
                    if (i10 == 1) {
                        closeBarrier = (CloseBarrier) triggerBasedInvalidationTracker$syncTriggers$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th2) {
                            th = th2;
                            closeBarrier.unblock$room_runtime_release();
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    CloseBarrier closeBarrier2 = this.database.getCloseBarrier();
                    if (closeBarrier2.block$room_runtime_release()) {
                        try {
                            RoomDatabase roomDatabase = this.database;
                            TriggerBasedInvalidationTracker$syncTriggers$2$1 triggerBasedInvalidationTracker$syncTriggers$2$1 = new TriggerBasedInvalidationTracker$syncTriggers$2$1(this, null);
                            triggerBasedInvalidationTracker$syncTriggers$1.L$0 = closeBarrier2;
                            triggerBasedInvalidationTracker$syncTriggers$1.label = 1;
                            if (roomDatabase.useConnection$room_runtime_release(false, triggerBasedInvalidationTracker$syncTriggers$2$1, triggerBasedInvalidationTracker$syncTriggers$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            closeBarrier = closeBarrier2;
                        } catch (Throwable th3) {
                            closeBarrier = closeBarrier2;
                            th = th3;
                            closeBarrier.unblock$room_runtime_release();
                            throw th;
                        }
                    }
                    return Unit.INSTANCE;
                }
                closeBarrier.unblock$room_runtime_release();
                return Unit.INSTANCE;
            }
        }
        triggerBasedInvalidationTracker$syncTriggers$1 = new TriggerBasedInvalidationTracker$syncTriggers$1(this, continuation);
        Object obj2 = triggerBasedInvalidationTracker$syncTriggers$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = triggerBasedInvalidationTracker$syncTriggers$1.label;
        if (i10 == 0) {
        }
        closeBarrier.unblock$room_runtime_release();
        return Unit.INSTANCE;
    }

    @NotNull
    public final Pair<String[], int[]> validateTableNames$room_runtime_release(@NotNull String[] names) {
        Intrinsics.checkNotNullParameter(names, "names");
        String[] resolveViews = resolveViews(names);
        int length = resolveViews.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str = resolveViews[i10];
            Map<String, Integer> map = this.tableIdLookup;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Integer num = map.get(lowerCase);
            if (num != null) {
                iArr[i10] = num.intValue();
            } else {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
        }
        return TuplesKt.to(resolveViews, iArr);
    }
}
