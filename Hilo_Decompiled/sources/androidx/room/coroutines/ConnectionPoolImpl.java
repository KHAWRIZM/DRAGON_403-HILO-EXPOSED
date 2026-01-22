package androidx.room.coroutines;

import androidx.room.Transactor;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import com.google.android.gms.appinvite.PreviewActivity;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u000bJ@\u0010\"\u001a\u0002H#\"\u0004\b\u0000\u0010#2\u0006\u0010$\u001a\u00020\u00192\"\u0010%\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H#0(\u0012\u0006\u0012\u0004\u0018\u00010)0&H\u0096@¢\u0006\u0002\u0010*J\"\u0010+\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010-\u0012\u0006\u0012\u0004\u0018\u00010.0,*\u00020\rH\u0082H¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0011H\u0002J\u0010\u00103\u001a\u0002042\u0006\u0010$\u001a\u00020\u0019H\u0002J\b\u00105\u001a\u000206H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u001c\u0010\u001b\u001a\u00020\u001cX\u0080\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00067"}, d2 = {"Landroidx/room/coroutines/ConnectionPoolImpl;", "Landroidx/room/coroutines/ConnectionPool;", "driver", "Landroidx/sqlite/SQLiteDriver;", "fileName", "", "<init>", "(Landroidx/sqlite/SQLiteDriver;Ljava/lang/String;)V", "maxNumOfReaders", "", "maxNumOfWriters", "(Landroidx/sqlite/SQLiteDriver;Ljava/lang/String;II)V", "readers", "Landroidx/room/coroutines/Pool;", "writers", "threadLocal", "Ljava/lang/ThreadLocal;", "Landroidx/room/coroutines/PooledConnectionImpl;", "Landroidx/room/concurrent/ThreadLocal;", "Ljava/lang/ThreadLocal;", "_isClosed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroidx/room/concurrent/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isClosed", "", "()Z", "timeout", "Lkotlin/time/Duration;", "getTimeout-UwyO8pc$room_runtime_release", "()J", "setTimeout-LRDsOJo$room_runtime_release", "(J)V", "J", "useConnection", "R", "isReadOnly", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function2;", "Landroidx/room/Transactor;", "Lkotlin/coroutines/Continuation;", "", "(ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireWithTimeout", "Lkotlin/Pair;", "Landroidx/room/coroutines/ConnectionWithLock;", "", "(Landroidx/room/coroutines/Pool;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createConnectionContext", "Lkotlin/coroutines/CoroutineContext;", "connection", "throwTimeoutException", "", PreviewActivity.ON_CLICK_LISTENER_CLOSE, "", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nConnectionPoolImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionPoolImpl.kt\nandroidx/room/coroutines/ConnectionPoolImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,537:1\n168#1,8:539\n1#2:538\n*S KotlinDebug\n*F\n+ 1 ConnectionPoolImpl.kt\nandroidx/room/coroutines/ConnectionPoolImpl\n*L\n132#1:539,8\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class ConnectionPoolImpl implements ConnectionPool {

    @NotNull
    private final AtomicBoolean _isClosed;

    @NotNull
    private final SQLiteDriver driver;

    @NotNull
    private final Pool readers;

    @NotNull
    private final ThreadLocal<PooledConnectionImpl> threadLocal;
    private long timeout;

    @NotNull
    private final Pool writers;

    public ConnectionPoolImpl(@NotNull final SQLiteDriver driver, @NotNull final String fileName) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.threadLocal = new ThreadLocal<>();
        this._isClosed = new AtomicBoolean(false);
        Duration.Companion companion = Duration.INSTANCE;
        this.timeout = DurationKt.toDuration(30, DurationUnit.SECONDS);
        this.driver = driver;
        Pool pool = new Pool(1, new Function0() { // from class: androidx.room.coroutines.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SQLiteConnection open;
                open = SQLiteDriver.this.open(fileName);
                return open;
            }
        });
        this.readers = pool;
        this.writers = pool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SQLiteConnection _init_$lambda$4(SQLiteDriver sQLiteDriver, String str) {
        SQLiteConnection open = sQLiteDriver.open(str);
        SQLite.execSQL(open, "PRAGMA query_only = 1");
        return open;
    }

    private final Object acquireWithTimeout(Pool pool, Continuation<? super Pair<ConnectionWithLock, ? extends Throwable>> continuation) {
        Object obj;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        try {
            long j10 = this.timeout;
            obj = null;
            ConnectionPoolImpl$acquireWithTimeout$2 connectionPoolImpl$acquireWithTimeout$2 = new ConnectionPoolImpl$acquireWithTimeout$2(objectRef, pool, null);
            InlineMarker.mark(0);
            TimeoutKt.m٢١٥٣withTimeoutKLykuaI(j10, connectionPoolImpl$acquireWithTimeout$2, continuation);
            InlineMarker.mark(1);
        } catch (Throwable th) {
            obj = th;
        }
        return TuplesKt.to(objectRef.element, obj);
    }

    private final CoroutineContext createConnectionContext(PooledConnectionImpl connection) {
        return new ConnectionElement(connection).plus(ThreadLocal_jvmAndroidKt.asContextElement(this.threadLocal, connection));
    }

    private final boolean isClosed() {
        return this._isClosed.get();
    }

    private final Void throwTimeoutException(boolean isReadOnly) {
        String str;
        if (isReadOnly) {
            str = "reader";
        } else {
            str = "writer";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Timed out attempting to acquire a " + str + " connection.");
        sb.append('\n');
        sb.append('\n');
        sb.append("Writer pool:");
        sb.append('\n');
        this.writers.dump(sb);
        sb.append("Reader pool:");
        sb.append('\n');
        this.readers.dump(sb);
        SQLite.throwSQLiteException(5, sb.toString());
        throw new KotlinNothingValueException();
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        if (this._isClosed.compareAndSet(false, true)) {
            this.readers.close();
            this.writers.close();
        }
    }

    /* renamed from: getTimeout-UwyO8pc$room_runtime_release, reason: not valid java name and from getter */
    public final long getTimeout() {
        return this.timeout;
    }

    /* renamed from: setTimeout-LRDsOJo$room_runtime_release, reason: not valid java name */
    public final void m٧٢setTimeoutLRDsOJo$room_runtime_release(long j10) {
        this.timeout = j10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x018e A[Catch: all -> 0x019f, TRY_LEAVE, TryCatch #7 {all -> 0x019f, blocks: (B:17:0x0188, B:19:0x018e), top: B:16:0x0188 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0145 A[Catch: all -> 0x015a, TryCatch #5 {all -> 0x015a, blocks: (B:48:0x0130, B:50:0x0145, B:54:0x0156, B:55:0x015f, B:59:0x0169, B:63:0x01a0, B:64:0x01a7, B:65:0x01a8, B:66:0x01a9, B:67:0x01b1), top: B:47:0x0130 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01a9 A[Catch: all -> 0x015a, TryCatch #5 {all -> 0x015a, blocks: (B:48:0x0130, B:50:0x0145, B:54:0x0156, B:55:0x015f, B:59:0x0169, B:63:0x01a0, B:64:0x01a7, B:65:0x01a8, B:66:0x01a9, B:67:0x01b1), top: B:47:0x0130 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [androidx.room.coroutines.PooledConnectionImpl, T] */
    /* JADX WARN: Type inference failed for: r15v3 */
    @Override // androidx.room.coroutines.ConnectionPool
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <R> Object useConnection(boolean z10, @NotNull Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
        ConnectionPoolImpl$useConnection$1 connectionPoolImpl$useConnection$1;
        int i10;
        Pool pool;
        Throwable th;
        Pool pool2;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Pool pool3;
        CoroutineContext coroutineContext;
        Object obj;
        ConnectionPoolImpl connectionPoolImpl;
        Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function22;
        Ref.ObjectRef objectRef4;
        ConnectionPoolImpl connectionPoolImpl2;
        ConnectionPoolImpl connectionPoolImpl3;
        boolean z11;
        Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function23;
        ConnectionWithLock connectionWithLock;
        Throwable th2;
        ?? r15;
        boolean z12;
        PooledConnectionImpl pooledConnectionImpl;
        boolean z13 = z10;
        Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function24 = function2;
        try {
            if (continuation instanceof ConnectionPoolImpl$useConnection$1) {
                connectionPoolImpl$useConnection$1 = (ConnectionPoolImpl$useConnection$1) continuation;
                int i11 = connectionPoolImpl$useConnection$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    connectionPoolImpl$useConnection$1.label = i11 - Integer.MIN_VALUE;
                    Object obj2 = connectionPoolImpl$useConnection$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i10 = connectionPoolImpl$useConnection$1.label;
                    if (i10 == 0) {
                        if (i10 != 1 && i10 != 2) {
                            if (i10 != 3) {
                                if (i10 == 4) {
                                    objectRef = (Ref.ObjectRef) connectionPoolImpl$useConnection$1.L$1;
                                    pool2 = (Pool) connectionPoolImpl$useConnection$1.L$0;
                                    try {
                                        ResultKt.throwOnFailure(obj2);
                                        try {
                                            pooledConnectionImpl = (PooledConnectionImpl) objectRef.element;
                                            if (pooledConnectionImpl != null) {
                                                pooledConnectionImpl.markRecycled();
                                                pooledConnectionImpl.getDelegate().markReleased();
                                                pool2.recycle(pooledConnectionImpl.getDelegate());
                                            }
                                        } catch (Throwable unused) {
                                        }
                                        return obj2;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        try {
                                            throw th;
                                        } finally {
                                        }
                                    }
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                z13 = connectionPoolImpl$useConnection$1.Z$0;
                                objectRef4 = (Ref.ObjectRef) connectionPoolImpl$useConnection$1.L$5;
                                coroutineContext = (CoroutineContext) connectionPoolImpl$useConnection$1.L$4;
                                objectRef3 = (Ref.ObjectRef) connectionPoolImpl$useConnection$1.L$3;
                                pool3 = (Pool) connectionPoolImpl$useConnection$1.L$2;
                                function22 = (Function2) connectionPoolImpl$useConnection$1.L$1;
                                ConnectionPoolImpl connectionPoolImpl4 = (ConnectionPoolImpl) connectionPoolImpl$useConnection$1.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj2);
                                    connectionPoolImpl2 = connectionPoolImpl4;
                                    z11 = z13;
                                    objectRef = objectRef3;
                                    function23 = function22;
                                    obj = null;
                                    connectionPoolImpl3 = connectionPoolImpl2;
                                } catch (Throwable th4) {
                                    obj = th4;
                                    connectionPoolImpl = connectionPoolImpl4;
                                    objectRef2 = objectRef4;
                                    function24 = function22;
                                    Ref.ObjectRef objectRef5 = objectRef2;
                                    connectionPoolImpl3 = connectionPoolImpl;
                                    z11 = z13;
                                    objectRef = objectRef3;
                                    function23 = function24;
                                    objectRef4 = objectRef5;
                                    Pair pair = TuplesKt.to(objectRef4.element, obj);
                                    connectionWithLock = (ConnectionWithLock) pair.component1();
                                    th2 = (Throwable) pair.component2();
                                    if (connectionWithLock == null) {
                                    }
                                    objectRef.element = r15;
                                    if (th2 instanceof TimeoutCancellationException) {
                                    }
                                }
                            }
                        } else {
                            ResultKt.throwOnFailure(obj2);
                            return obj2;
                        }
                    } else {
                        ResultKt.throwOnFailure(obj2);
                        if (!isClosed()) {
                            PooledConnectionImpl pooledConnectionImpl2 = this.threadLocal.get();
                            if (pooledConnectionImpl2 == null) {
                                ConnectionElement connectionElement = (ConnectionElement) connectionPoolImpl$useConnection$1.getContext().get(ConnectionElement.INSTANCE);
                                if (connectionElement != null) {
                                    pooledConnectionImpl2 = connectionElement.getConnectionWrapper();
                                } else {
                                    pooledConnectionImpl2 = null;
                                }
                            }
                            if (pooledConnectionImpl2 != null) {
                                if (!z13 && pooledConnectionImpl2.getIsReadOnly()) {
                                    SQLite.throwSQLiteException(1, "Cannot upgrade connection from reader to writer");
                                    throw new KotlinNothingValueException();
                                }
                                if (connectionPoolImpl$useConnection$1.getContext().get(ConnectionElement.INSTANCE) == null) {
                                    CoroutineContext createConnectionContext = createConnectionContext(pooledConnectionImpl2);
                                    ConnectionPoolImpl$useConnection$2 connectionPoolImpl$useConnection$2 = new ConnectionPoolImpl$useConnection$2(function24, pooledConnectionImpl2, null);
                                    connectionPoolImpl$useConnection$1.label = 1;
                                    obj2 = BuildersKt.withContext(createConnectionContext, connectionPoolImpl$useConnection$2, connectionPoolImpl$useConnection$1);
                                    if (obj2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    connectionPoolImpl$useConnection$1.label = 2;
                                    obj2 = function24.invoke(pooledConnectionImpl2, connectionPoolImpl$useConnection$1);
                                    if (obj2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                return obj2;
                            }
                            if (z13) {
                                pool = this.readers;
                            } else {
                                pool = this.writers;
                            }
                            Pool pool4 = pool;
                            Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
                            try {
                                CoroutineContext context = connectionPoolImpl$useConnection$1.getContext();
                                objectRef2 = new Ref.ObjectRef();
                                try {
                                    long j10 = this.timeout;
                                    ConnectionPoolImpl$acquireWithTimeout$2 connectionPoolImpl$acquireWithTimeout$2 = new ConnectionPoolImpl$acquireWithTimeout$2(objectRef2, pool4, null);
                                    connectionPoolImpl$useConnection$1.L$0 = this;
                                    connectionPoolImpl$useConnection$1.L$1 = function24;
                                    connectionPoolImpl$useConnection$1.L$2 = pool4;
                                    connectionPoolImpl$useConnection$1.L$3 = objectRef6;
                                    connectionPoolImpl$useConnection$1.L$4 = context;
                                    connectionPoolImpl$useConnection$1.L$5 = objectRef2;
                                    connectionPoolImpl$useConnection$1.Z$0 = z13;
                                    connectionPoolImpl$useConnection$1.label = 3;
                                    if (TimeoutKt.m٢١٥٣withTimeoutKLykuaI(j10, connectionPoolImpl$acquireWithTimeout$2, connectionPoolImpl$useConnection$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    objectRef3 = objectRef6;
                                    pool3 = pool4;
                                    coroutineContext = context;
                                    function22 = function24;
                                    objectRef4 = objectRef2;
                                    connectionPoolImpl2 = this;
                                    z11 = z13;
                                    objectRef = objectRef3;
                                    function23 = function22;
                                    obj = null;
                                    connectionPoolImpl3 = connectionPoolImpl2;
                                } catch (Throwable th5) {
                                    objectRef3 = objectRef6;
                                    pool3 = pool4;
                                    coroutineContext = context;
                                    obj = th5;
                                    connectionPoolImpl = this;
                                    Ref.ObjectRef objectRef52 = objectRef2;
                                    connectionPoolImpl3 = connectionPoolImpl;
                                    z11 = z13;
                                    objectRef = objectRef3;
                                    function23 = function24;
                                    objectRef4 = objectRef52;
                                    Pair pair2 = TuplesKt.to(objectRef4.element, obj);
                                    connectionWithLock = (ConnectionWithLock) pair2.component1();
                                    th2 = (Throwable) pair2.component2();
                                    if (connectionWithLock == null) {
                                    }
                                    objectRef.element = r15;
                                    if (th2 instanceof TimeoutCancellationException) {
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                pool2 = pool4;
                                objectRef = objectRef6;
                                throw th;
                            }
                        } else {
                            SQLite.throwSQLiteException(21, "Connection pool is closed");
                            throw new KotlinNothingValueException();
                        }
                    }
                    Pair pair22 = TuplesKt.to(objectRef4.element, obj);
                    connectionWithLock = (ConnectionWithLock) pair22.component1();
                    th2 = (Throwable) pair22.component2();
                    if (connectionWithLock == null) {
                        ConnectionWithLock markAcquired = connectionWithLock.markAcquired(coroutineContext);
                        if (connectionPoolImpl3.readers != connectionPoolImpl3.writers && z11) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        r15 = new PooledConnectionImpl(markAcquired, z12);
                    } else {
                        r15 = 0;
                    }
                    objectRef.element = r15;
                    if (th2 instanceof TimeoutCancellationException) {
                        if (th2 == null) {
                            if (r15 != 0) {
                                CoroutineContext createConnectionContext2 = connectionPoolImpl3.createConnectionContext(r15);
                                ConnectionPoolImpl$useConnection$4 connectionPoolImpl$useConnection$4 = new ConnectionPoolImpl$useConnection$4(function23, objectRef, null);
                                connectionPoolImpl$useConnection$1.L$0 = pool3;
                                connectionPoolImpl$useConnection$1.L$1 = objectRef;
                                connectionPoolImpl$useConnection$1.L$2 = null;
                                connectionPoolImpl$useConnection$1.L$3 = null;
                                connectionPoolImpl$useConnection$1.L$4 = null;
                                connectionPoolImpl$useConnection$1.L$5 = null;
                                connectionPoolImpl$useConnection$1.label = 4;
                                obj2 = BuildersKt.withContext(createConnectionContext2, connectionPoolImpl$useConnection$4, connectionPoolImpl$useConnection$1);
                                if (obj2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                pool2 = pool3;
                                pooledConnectionImpl = (PooledConnectionImpl) objectRef.element;
                                if (pooledConnectionImpl != null) {
                                }
                                return obj2;
                            }
                            throw new IllegalArgumentException("Required value was null.");
                        }
                        throw th2;
                    }
                    connectionPoolImpl3.throwTimeoutException(z11);
                    throw new KotlinNothingValueException();
                }
            }
            Pair pair222 = TuplesKt.to(objectRef4.element, obj);
            connectionWithLock = (ConnectionWithLock) pair222.component1();
            th2 = (Throwable) pair222.component2();
            if (connectionWithLock == null) {
            }
            objectRef.element = r15;
            if (th2 instanceof TimeoutCancellationException) {
            }
        } catch (Throwable th7) {
            th = th7;
            pool2 = pool3;
            throw th;
        }
        connectionPoolImpl$useConnection$1 = new ConnectionPoolImpl$useConnection$1(this, continuation);
        Object obj22 = connectionPoolImpl$useConnection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = connectionPoolImpl$useConnection$1.label;
        if (i10 == 0) {
        }
    }

    public ConnectionPoolImpl(@NotNull final SQLiteDriver driver, @NotNull final String fileName, int i10, int i11) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.threadLocal = new ThreadLocal<>();
        this._isClosed = new AtomicBoolean(false);
        Duration.Companion companion = Duration.INSTANCE;
        this.timeout = DurationKt.toDuration(30, DurationUnit.SECONDS);
        if (i10 <= 0) {
            throw new IllegalArgumentException("Maximum number of readers must be greater than 0");
        }
        if (i11 > 0) {
            this.driver = driver;
            this.readers = new Pool(i10, new Function0() { // from class: androidx.room.coroutines.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    SQLiteConnection _init_$lambda$4;
                    _init_$lambda$4 = ConnectionPoolImpl._init_$lambda$4(SQLiteDriver.this, fileName);
                    return _init_$lambda$4;
                }
            });
            this.writers = new Pool(i11, new Function0() { // from class: androidx.room.coroutines.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    SQLiteConnection open;
                    open = SQLiteDriver.this.open(fileName);
                    return open;
                }
            });
            return;
        }
        throw new IllegalArgumentException("Maximum number of writers must be greater than 0");
    }
}
