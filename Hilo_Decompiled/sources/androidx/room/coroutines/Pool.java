package androidx.room.coroutines;

import androidx.collection.CircularArray;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.google.android.gms.appinvite.PreviewActivity;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u001c\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0016J\u0006\u0010\"\u001a\u00020\u001fJ\u0012\u0010#\u001a\u00020\u001f2\n\u0010$\u001a\u00060%j\u0002`&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00060\u000ej\u0002`\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/room/coroutines/Pool;", "", "capacity", "", "connectionFactory", "Lkotlin/Function0;", "Landroidx/sqlite/SQLiteConnection;", "<init>", "(ILkotlin/jvm/functions/Function0;)V", "getCapacity", "()I", "getConnectionFactory", "()Lkotlin/jvm/functions/Function0;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroidx/room/concurrent/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "size", "isClosed", "", "connections", "", "Landroidx/room/coroutines/ConnectionWithLock;", "[Landroidx/room/coroutines/ConnectionWithLock;", "connectionPermits", "Lkotlinx/coroutines/sync/Semaphore;", "availableConnections", "Landroidx/collection/CircularArray;", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryOpenNewConnectionLocked", "", "recycle", "connection", PreviewActivity.ON_CLICK_LISTENER_CLOSE, "dump", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nConnectionPoolImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionPoolImpl.kt\nandroidx/room/coroutines/Pool\n+ 2 ReentrantLock.kt\nandroidx/room/concurrent/ReentrantLockKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,537:1\n28#2,5:538\n28#2,5:543\n28#2,3:548\n32#2:553\n28#2,3:554\n32#2:560\n13402#3,2:551\n13467#3,3:557\n*S KotlinDebug\n*F\n+ 1 ConnectionPoolImpl.kt\nandroidx/room/coroutines/Pool\n*L\n214#1:538,5\n240#1:543,5\n245#1:548,3\n245#1:553\n253#1:554,3\n253#1:560\n247#1:551,2\n266#1:557,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class Pool {

    @NotNull
    private final CircularArray<ConnectionWithLock> availableConnections;
    private final int capacity;

    @NotNull
    private final Function0<SQLiteConnection> connectionFactory;

    @NotNull
    private final Semaphore connectionPermits;

    @NotNull
    private final ConnectionWithLock[] connections;
    private boolean isClosed;

    @NotNull
    private final ReentrantLock lock;
    private int size;

    /* JADX WARN: Multi-variable type inference failed */
    public Pool(int i10, @NotNull Function0<? extends SQLiteConnection> connectionFactory) {
        Intrinsics.checkNotNullParameter(connectionFactory, "connectionFactory");
        this.capacity = i10;
        this.connectionFactory = connectionFactory;
        this.lock = new ReentrantLock();
        this.connections = new ConnectionWithLock[i10];
        this.connectionPermits = SemaphoreKt.Semaphore$default(i10, 0, 2, (Object) null);
        this.availableConnections = new CircularArray<>(i10);
    }

    private final void tryOpenNewConnectionLocked() {
        if (this.size >= this.capacity) {
            return;
        }
        Mutex mutex = null;
        ConnectionWithLock connectionWithLock = new ConnectionWithLock(this.connectionFactory.invoke(), mutex, 2, mutex);
        ConnectionWithLock[] connectionWithLockArr = this.connections;
        int i10 = this.size;
        this.size = i10 + 1;
        connectionWithLockArr[i10] = connectionWithLock;
        this.availableConnections.addLast(connectionWithLock);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004f A[Catch: all -> 0x005b, TryCatch #1 {all -> 0x005b, blocks: (B:13:0x004b, B:15:0x004f, B:17:0x0057, B:18:0x005d, B:22:0x006b, B:23:0x0077), top: B:12:0x004b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b A[Catch: all -> 0x005b, TRY_ENTER, TryCatch #1 {all -> 0x005b, blocks: (B:13:0x004b, B:15:0x004f, B:17:0x0057, B:18:0x005d, B:22:0x006b, B:23:0x0077), top: B:12:0x004b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object acquire(@NotNull Continuation<? super ConnectionWithLock> continuation) {
        Pool$acquire$1 pool$acquire$1;
        int i10;
        Pool pool;
        ReentrantLock reentrantLock;
        try {
            try {
                if (continuation instanceof Pool$acquire$1) {
                    pool$acquire$1 = (Pool$acquire$1) continuation;
                    int i11 = pool$acquire$1.label;
                    if ((i11 & Integer.MIN_VALUE) != 0) {
                        pool$acquire$1.label = i11 - Integer.MIN_VALUE;
                        Object obj = pool$acquire$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i10 = pool$acquire$1.label;
                        if (i10 == 0) {
                            if (i10 == 1) {
                                pool = (Pool) pool$acquire$1.L$0;
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            Semaphore semaphore = this.connectionPermits;
                            pool$acquire$1.L$0 = this;
                            pool$acquire$1.label = 1;
                            if (semaphore.acquire(pool$acquire$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            pool = this;
                        }
                        reentrantLock = pool.lock;
                        reentrantLock.lock();
                        if (pool.isClosed) {
                            if (pool.availableConnections.isEmpty()) {
                                pool.tryOpenNewConnectionLocked();
                            }
                            ConnectionWithLock popFirst = pool.availableConnections.popFirst();
                            reentrantLock.unlock();
                            return popFirst;
                        }
                        SQLite.throwSQLiteException(21, "Connection pool is closed");
                        throw new KotlinNothingValueException();
                    }
                }
                if (pool.isClosed) {
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
            reentrantLock = pool.lock;
            reentrantLock.lock();
        } catch (Throwable th2) {
            pool.connectionPermits.release();
            throw th2;
        }
        pool$acquire$1 = new Pool$acquire$1(this, continuation);
        Object obj2 = pool$acquire$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = pool$acquire$1.label;
        if (i10 == 0) {
        }
    }

    public final void close() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.isClosed = true;
            for (ConnectionWithLock connectionWithLock : this.connections) {
                if (connectionWithLock != null) {
                    connectionWithLock.close();
                }
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void dump(@NotNull StringBuilder builder) {
        String str;
        Intrinsics.checkNotNullParameter(builder, "builder");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            List createListBuilder = CollectionsKt.createListBuilder();
            int size = this.availableConnections.size();
            for (int i10 = 0; i10 < size; i10++) {
                createListBuilder.add(this.availableConnections.get(i10));
            }
            List build = CollectionsKt.build(createListBuilder);
            builder.append('\t' + super.toString() + " (");
            builder.append("capacity=" + this.capacity + ", ");
            builder.append("permits=" + this.connectionPermits.getAvailablePermits() + ", ");
            builder.append("queue=(size=" + build.size() + ")[" + CollectionsKt.joinToString$default(build, null, null, null, 0, null, null, 63, null) + "], ");
            builder.append(")");
            builder.append('\n');
            int i11 = 0;
            for (ConnectionWithLock connectionWithLock : this.connections) {
                i11++;
                StringBuilder sb = new StringBuilder();
                sb.append("\t\t[");
                sb.append(i11);
                sb.append("] - ");
                if (connectionWithLock != null) {
                    str = connectionWithLock.toString();
                } else {
                    str = null;
                }
                sb.append(str);
                builder.append(sb.toString());
                builder.append('\n');
                if (connectionWithLock != null) {
                    connectionWithLock.dump(builder);
                }
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final int getCapacity() {
        return this.capacity;
    }

    @NotNull
    public final Function0<SQLiteConnection> getConnectionFactory() {
        return this.connectionFactory;
    }

    public final void recycle(@NotNull ConnectionWithLock connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.availableConnections.addLast(connection);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            this.connectionPermits.release();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
