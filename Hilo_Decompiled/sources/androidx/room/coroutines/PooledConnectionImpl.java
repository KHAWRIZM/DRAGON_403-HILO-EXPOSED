package androidx.room.coroutines;

import android.database.SQLException;
import androidx.room.TransactionScope;
import androidx.room.Transactor;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.room.coroutines.ConnectionPool;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.google.android.gms.appinvite.PreviewActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.Mutex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0003678B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u0002H\u00190\u001dH\u0096@¢\u0006\u0002\u0010\u001fJK\u0010 \u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\u0006\u0010!\u001a\u00020\"2-\u0010\u001c\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00190$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00190%\u0012\u0006\u0012\u0004\u0018\u00010&0#¢\u0006\u0002\b'H\u0096@¢\u0006\u0002\u0010(J\u000e\u0010)\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010*J\u0006\u0010+\u001a\u00020,JM\u0010-\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\b\u0010!\u001a\u0004\u0018\u00010\"2-\u0010\u001c\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00190$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00190%\u0012\u0006\u0012\u0004\u0018\u00010&0#¢\u0006\u0002\b'H\u0082@¢\u0006\u0002\u0010(J\u0016\u0010.\u001a\u00020,2\u0006\u0010!\u001a\u00020\"H\u0082@¢\u0006\u0002\u0010/J\u0016\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u00102J\"\u00103\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001904H\u0082H¢\u0006\u0002\u00105R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u00069"}, d2 = {"Landroidx/room/coroutines/PooledConnectionImpl;", "Landroidx/room/Transactor;", "Landroidx/room/coroutines/RawConnectionAccessor;", "delegate", "Landroidx/room/coroutines/ConnectionWithLock;", "isReadOnly", "", "<init>", "(Landroidx/room/coroutines/ConnectionWithLock;Z)V", "getDelegate", "()Landroidx/room/coroutines/ConnectionWithLock;", "()Z", "transactionStack", "Lkotlin/collections/ArrayDeque;", "Landroidx/room/coroutines/PooledConnectionImpl$TransactionItem;", "_isRecycled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroidx/room/concurrent/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRecycled", "rawConnection", "Landroidx/sqlite/SQLiteConnection;", "getRawConnection", "()Landroidx/sqlite/SQLiteConnection;", "usePrepared", "R", "sql", "", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function1;", "Landroidx/sqlite/SQLiteStatement;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTransaction", "type", "Landroidx/room/Transactor$SQLiteTransactionType;", "Lkotlin/Function2;", "Landroidx/room/TransactionScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/room/Transactor$SQLiteTransactionType;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inTransaction", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markRecycled", "", "transaction", "beginTransaction", "(Landroidx/room/Transactor$SQLiteTransactionType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endTransaction", "success", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withStateCheck", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TransactionItem", "TransactionImpl", "StatementWrapper", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nConnectionPoolImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionPoolImpl.kt\nandroidx/room/coroutines/PooledConnectionImpl\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,537:1\n462#1,11:538\n462#1,11:559\n462#1,11:570\n120#2,8:549\n129#2:558\n120#2,10:581\n120#2,10:591\n1#3:557\n*S KotlinDebug\n*F\n+ 1 ConnectionPoolImpl.kt\nandroidx/room/coroutines/PooledConnectionImpl\n*L\n341#1:538,11\n350#1:559,11\n352#1:570,11\n342#1:549,8\n342#1:558\n401#1:581,10\n418#1:591,10\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class PooledConnectionImpl implements Transactor, RawConnectionAccessor {

    @NotNull
    private final AtomicBoolean _isRecycled;

    @NotNull
    private final ConnectionWithLock delegate;
    private final boolean isReadOnly;

    @NotNull
    private final ArrayDeque<TransactionItem> transactionStack;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\"\u0010 \u001a\u0002H!\"\u0004\b\u0000\u0010!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0#H\u0082\b¢\u0006\u0002\u0010$R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/room/coroutines/PooledConnectionImpl$StatementWrapper;", "Landroidx/sqlite/SQLiteStatement;", "delegate", "<init>", "(Landroidx/room/coroutines/PooledConnectionImpl;Landroidx/sqlite/SQLiteStatement;)V", "threadId", "", "bindBlob", "", FirebaseAnalytics.Param.INDEX, "", "value", "", "bindDouble", "", "bindLong", "bindText", "", "bindNull", "getBlob", "getDouble", "getLong", "getText", "isNull", "", "getColumnCount", "getColumnName", "getColumnType", "step", "reset", "clearBindings", PreviewActivity.ON_CLICK_LISTENER_CLOSE, "withStateCheck", "R", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nConnectionPoolImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionPoolImpl.kt\nandroidx/room/coroutines/PooledConnectionImpl$StatementWrapper\n*L\n1#1,537:1\n524#1,10:538\n524#1,10:548\n524#1,10:558\n524#1,10:568\n524#1,10:578\n524#1,10:588\n524#1,10:598\n524#1,10:608\n524#1,10:618\n524#1,10:628\n524#1,10:638\n524#1,10:648\n524#1,10:658\n524#1,10:668\n524#1,10:678\n524#1,10:688\n524#1,10:698\n*S KotlinDebug\n*F\n+ 1 ConnectionPoolImpl.kt\nandroidx/room/coroutines/PooledConnectionImpl$StatementWrapper\n*L\n481#1:538,10\n485#1:548,10\n489#1:558,10\n493#1:568,10\n497#1:578,10\n499#1:588,10\n501#1:598,10\n503#1:608,10\n505#1:618,10\n507#1:628,10\n509#1:638,10\n511#1:648,10\n513#1:658,10\n515#1:668,10\n517#1:678,10\n519#1:688,10\n521#1:698,10\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public final class StatementWrapper implements SQLiteStatement {

        @NotNull
        private final SQLiteStatement delegate;
        final /* synthetic */ PooledConnectionImpl this$0;
        private final long threadId;

        public StatementWrapper(@NotNull PooledConnectionImpl pooledConnectionImpl, SQLiteStatement delegate) {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.this$0 = pooledConnectionImpl;
            this.delegate = delegate;
            this.threadId = ThreadLocal_jvmAndroidKt.currentThreadId();
        }

        private final <R> R withStateCheck(Function0<? extends R> block) {
            if (!this.this$0.isRecycled()) {
                if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                    return block.invoke();
                }
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
            SQLite.throwSQLiteException(21, "Statement is recycled");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindBlob */
        public void mo٢٤٢bindBlob(int index, @NotNull byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (!this.this$0.isRecycled()) {
                if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                    this.delegate.mo٢٤٢bindBlob(index, value);
                    return;
                } else {
                    SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                    throw new KotlinNothingValueException();
                }
            }
            SQLite.throwSQLiteException(21, "Statement is recycled");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public /* synthetic */ void bindBoolean(int i10, boolean z10) {
            e3.a.a(this, i10, z10);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindDouble */
        public void mo٢٤٣bindDouble(int index, double value) {
            if (!this.this$0.isRecycled()) {
                if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                    this.delegate.mo٢٤٣bindDouble(index, value);
                    return;
                } else {
                    SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                    throw new KotlinNothingValueException();
                }
            }
            SQLite.throwSQLiteException(21, "Statement is recycled");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public /* synthetic */ void bindFloat(int i10, float f10) {
            e3.a.b(this, i10, f10);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public /* synthetic */ void bindInt(int i10, int i11) {
            e3.a.c(this, i10, i11);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindLong */
        public void mo٢٤٤bindLong(int index, long value) {
            if (!this.this$0.isRecycled()) {
                if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                    this.delegate.mo٢٤٤bindLong(index, value);
                    return;
                } else {
                    SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                    throw new KotlinNothingValueException();
                }
            }
            SQLite.throwSQLiteException(21, "Statement is recycled");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindNull */
        public void mo٢٤٥bindNull(int index) {
            if (!this.this$0.isRecycled()) {
                if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                    this.delegate.mo٢٤٥bindNull(index);
                    return;
                } else {
                    SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                    throw new KotlinNothingValueException();
                }
            }
            SQLite.throwSQLiteException(21, "Statement is recycled");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindText */
        public void mo٢٤٦bindText(int index, @NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (!this.this$0.isRecycled()) {
                if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                    this.delegate.mo٢٤٦bindText(index, value);
                    return;
                } else {
                    SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                    throw new KotlinNothingValueException();
                }
            }
            SQLite.throwSQLiteException(21, "Statement is recycled");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: clearBindings */
        public void mo٢٤٧clearBindings() {
            if (!this.this$0.isRecycled()) {
                if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                    this.delegate.mo٢٤٧clearBindings();
                    return;
                } else {
                    SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                    throw new KotlinNothingValueException();
                }
            }
            SQLite.throwSQLiteException(21, "Statement is recycled");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            if (!this.this$0.isRecycled()) {
                if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                    this.delegate.close();
                    return;
                } else {
                    SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                    throw new KotlinNothingValueException();
                }
            }
            SQLite.throwSQLiteException(21, "Statement is recycled");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        @NotNull
        public byte[] getBlob(int index) {
            if (!this.this$0.isRecycled()) {
                if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                    return this.delegate.getBlob(index);
                }
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
            SQLite.throwSQLiteException(21, "Statement is recycled");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public /* synthetic */ boolean getBoolean(int i10) {
            return e3.a.d(this, i10);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            if (!this.this$0.isRecycled()) {
                if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                    return this.delegate.getColumnCount();
                }
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
            SQLite.throwSQLiteException(21, "Statement is recycled");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        @NotNull
        public String getColumnName(int index) {
            if (!this.this$0.isRecycled()) {
                if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                    return this.delegate.getColumnName(index);
                }
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
            SQLite.throwSQLiteException(21, "Statement is recycled");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public /* synthetic */ List getColumnNames() {
            return e3.a.e(this);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnType(int index) {
            if (!this.this$0.isRecycled()) {
                if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                    return this.delegate.getColumnType(index);
                }
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
            SQLite.throwSQLiteException(21, "Statement is recycled");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int index) {
            if (!this.this$0.isRecycled()) {
                if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                    return this.delegate.getDouble(index);
                }
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
            SQLite.throwSQLiteException(21, "Statement is recycled");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public /* synthetic */ float getFloat(int i10) {
            return e3.a.f(this, i10);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public /* synthetic */ int getInt(int i10) {
            return e3.a.g(this, i10);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int index) {
            if (!this.this$0.isRecycled()) {
                if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                    return this.delegate.getLong(index);
                }
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
            SQLite.throwSQLiteException(21, "Statement is recycled");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        @NotNull
        public String getText(int index) {
            if (!this.this$0.isRecycled()) {
                if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                    return this.delegate.getText(index);
                }
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
            SQLite.throwSQLiteException(21, "Statement is recycled");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int index) {
            if (!this.this$0.isRecycled()) {
                if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                    return this.delegate.isNull(index);
                }
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
            SQLite.throwSQLiteException(21, "Statement is recycled");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            if (!this.this$0.isRecycled()) {
                if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                    this.delegate.reset();
                    return;
                } else {
                    SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                    throw new KotlinNothingValueException();
                }
            }
            SQLite.throwSQLiteException(21, "Statement is recycled");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            if (!this.this$0.isRecycled()) {
                if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                    return this.delegate.step();
                }
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
            SQLite.throwSQLiteException(21, "Statement is recycled");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0001\u0010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002H\u000b0\u000fH\u0096@¢\u0006\u0002\u0010\u0011J>\u0010\u0012\u001a\u0002H\u000b\"\u0004\b\u0001\u0010\u000b2(\u0010\u000e\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013H\u0096@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"Landroidx/room/coroutines/PooledConnectionImpl$TransactionImpl;", "T", "Landroidx/room/TransactionScope;", "Landroidx/room/coroutines/RawConnectionAccessor;", "<init>", "(Landroidx/room/coroutines/PooledConnectionImpl;)V", "rawConnection", "Landroidx/sqlite/SQLiteConnection;", "getRawConnection", "()Landroidx/sqlite/SQLiteConnection;", "usePrepared", "R", "sql", "", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function1;", "Landroidx/sqlite/SQLiteStatement;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withNestedTransaction", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rollback", "", "result", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nConnectionPoolImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionPoolImpl.kt\nandroidx/room/coroutines/PooledConnectionImpl$TransactionImpl\n+ 2 ConnectionPoolImpl.kt\nandroidx/room/coroutines/PooledConnectionImpl\n+ 3 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,537:1\n462#2,11:538\n462#2,11:549\n120#3,10:560\n*S KotlinDebug\n*F\n+ 1 ConnectionPoolImpl.kt\nandroidx/room/coroutines/PooledConnectionImpl$TransactionImpl\n*L\n450#1:538,11\n452#1:549,11\n456#1:560,10\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public final class TransactionImpl<T> implements TransactionScope<T>, RawConnectionAccessor {
        public TransactionImpl() {
        }

        @Override // androidx.room.coroutines.RawConnectionAccessor
        @NotNull
        public SQLiteConnection getRawConnection() {
            return PooledConnectionImpl.this.getRawConnection();
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        @Override // androidx.room.TransactionScope
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object rollback(T t10, @NotNull Continuation<?> continuation) {
            PooledConnectionImpl$TransactionImpl$rollback$1 pooledConnectionImpl$TransactionImpl$rollback$1;
            int i10;
            Object obj;
            PooledConnectionImpl pooledConnectionImpl;
            Mutex mutex;
            try {
                if (continuation instanceof PooledConnectionImpl$TransactionImpl$rollback$1) {
                    pooledConnectionImpl$TransactionImpl$rollback$1 = (PooledConnectionImpl$TransactionImpl$rollback$1) continuation;
                    int i11 = pooledConnectionImpl$TransactionImpl$rollback$1.label;
                    if ((i11 & Integer.MIN_VALUE) != 0) {
                        pooledConnectionImpl$TransactionImpl$rollback$1.label = i11 - Integer.MIN_VALUE;
                        Object obj2 = pooledConnectionImpl$TransactionImpl$rollback$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i10 = pooledConnectionImpl$TransactionImpl$rollback$1.label;
                        if (i10 == 0) {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            mutex = (Mutex) pooledConnectionImpl$TransactionImpl$rollback$1.L$2;
                            pooledConnectionImpl = (PooledConnectionImpl) pooledConnectionImpl$TransactionImpl$rollback$1.L$1;
                            obj = pooledConnectionImpl$TransactionImpl$rollback$1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        } else {
                            ResultKt.throwOnFailure(obj2);
                            PooledConnectionImpl pooledConnectionImpl2 = PooledConnectionImpl.this;
                            if (!pooledConnectionImpl2.isRecycled()) {
                                ConnectionElement connectionElement = (ConnectionElement) pooledConnectionImpl$TransactionImpl$rollback$1.get$context().get(ConnectionElement.INSTANCE);
                                if (connectionElement != null && connectionElement.getConnectionWrapper() == pooledConnectionImpl2) {
                                    if (!pooledConnectionImpl2.transactionStack.isEmpty()) {
                                        ConnectionWithLock delegate = pooledConnectionImpl2.getDelegate();
                                        pooledConnectionImpl$TransactionImpl$rollback$1.L$0 = t10;
                                        pooledConnectionImpl$TransactionImpl$rollback$1.L$1 = pooledConnectionImpl2;
                                        pooledConnectionImpl$TransactionImpl$rollback$1.L$2 = delegate;
                                        pooledConnectionImpl$TransactionImpl$rollback$1.label = 1;
                                        if (delegate.lock((Object) null, pooledConnectionImpl$TransactionImpl$rollback$1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        obj = t10;
                                        pooledConnectionImpl = pooledConnectionImpl2;
                                        mutex = delegate;
                                    } else {
                                        throw new IllegalStateException("Not in a transaction");
                                    }
                                } else {
                                    SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
                                    throw new KotlinNothingValueException();
                                }
                            } else {
                                SQLite.throwSQLiteException(21, "Connection is recycled");
                                throw new KotlinNothingValueException();
                            }
                        }
                        ((TransactionItem) pooledConnectionImpl.transactionStack.last()).setShouldRollback(true);
                        Unit unit = Unit.INSTANCE;
                        mutex.unlock((Object) null);
                        throw new ConnectionPool.RollbackException(obj);
                    }
                }
                ((TransactionItem) pooledConnectionImpl.transactionStack.last()).setShouldRollback(true);
                Unit unit2 = Unit.INSTANCE;
                mutex.unlock((Object) null);
                throw new ConnectionPool.RollbackException(obj);
            } catch (Throwable th) {
                mutex.unlock((Object) null);
                throw th;
            }
            pooledConnectionImpl$TransactionImpl$rollback$1 = new PooledConnectionImpl$TransactionImpl$rollback$1(this, continuation);
            Object obj22 = pooledConnectionImpl$TransactionImpl$rollback$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i10 = pooledConnectionImpl$TransactionImpl$rollback$1.label;
            if (i10 == 0) {
            }
        }

        @Override // androidx.room.PooledConnection
        @Nullable
        public <R> Object usePrepared(@NotNull String str, @NotNull Function1<? super SQLiteStatement, ? extends R> function1, @NotNull Continuation<? super R> continuation) {
            return PooledConnectionImpl.this.usePrepared(str, function1, continuation);
        }

        @Override // androidx.room.TransactionScope
        @Nullable
        public <R> Object withNestedTransaction(@NotNull Function2<? super TransactionScope<R>, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
            PooledConnectionImpl pooledConnectionImpl = PooledConnectionImpl.this;
            if (!pooledConnectionImpl.isRecycled()) {
                ConnectionElement connectionElement = (ConnectionElement) continuation.get$context().get(ConnectionElement.INSTANCE);
                if (connectionElement != null && connectionElement.getConnectionWrapper() == pooledConnectionImpl) {
                    return pooledConnectionImpl.transaction(null, function2, continuation);
                }
                SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
                throw new KotlinNothingValueException();
            }
            SQLite.throwSQLiteException(21, "Connection is recycled");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/room/coroutines/PooledConnectionImpl$TransactionItem;", "", "id", "", "shouldRollback", "", "<init>", "(IZ)V", "getId", "()I", "getShouldRollback", "()Z", "setShouldRollback", "(Z)V", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class TransactionItem {
        private final int id;
        private boolean shouldRollback;

        public TransactionItem(int i10, boolean z10) {
            this.id = i10;
            this.shouldRollback = z10;
        }

        public final int getId() {
            return this.id;
        }

        public final boolean getShouldRollback() {
            return this.shouldRollback;
        }

        public final void setShouldRollback(boolean z10) {
            this.shouldRollback = z10;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Transactor.SQLiteTransactionType.values().length];
            try {
                iArr[Transactor.SQLiteTransactionType.DEFERRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.IMMEDIATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.EXCLUSIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PooledConnectionImpl(@NotNull ConnectionWithLock delegate, boolean z10) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.isReadOnly = z10;
        this.transactionStack = new ArrayDeque<>();
        this._isRecycled = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0063 A[Catch: all -> 0x007b, TryCatch #0 {all -> 0x007b, blocks: (B:11:0x0055, B:13:0x0063, B:19:0x0073, B:20:0x00ae, B:24:0x007d, B:25:0x0082, B:26:0x0083, B:27:0x008b, B:28:0x0093), top: B:10:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0093 A[Catch: all -> 0x007b, TryCatch #0 {all -> 0x007b, blocks: (B:11:0x0055, B:13:0x0063, B:19:0x0073, B:20:0x00ae, B:24:0x007d, B:25:0x0082, B:26:0x0083, B:27:0x008b, B:28:0x0093), top: B:10:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r6v14, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object beginTransaction(Transactor.SQLiteTransactionType sQLiteTransactionType, Continuation<? super Unit> continuation) {
        PooledConnectionImpl$beginTransaction$1 pooledConnectionImpl$beginTransaction$1;
        int i10;
        ConnectionWithLock connectionWithLock;
        PooledConnectionImpl pooledConnectionImpl;
        try {
            if (continuation instanceof PooledConnectionImpl$beginTransaction$1) {
                pooledConnectionImpl$beginTransaction$1 = (PooledConnectionImpl$beginTransaction$1) continuation;
                int i11 = pooledConnectionImpl$beginTransaction$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    pooledConnectionImpl$beginTransaction$1.label = i11 - Integer.MIN_VALUE;
                    Object obj = pooledConnectionImpl$beginTransaction$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i10 = pooledConnectionImpl$beginTransaction$1.label;
                    if (i10 == 0) {
                        if (i10 == 1) {
                            ?? r62 = (Mutex) pooledConnectionImpl$beginTransaction$1.L$2;
                            Transactor.SQLiteTransactionType sQLiteTransactionType2 = (Transactor.SQLiteTransactionType) pooledConnectionImpl$beginTransaction$1.L$1;
                            pooledConnectionImpl = (PooledConnectionImpl) pooledConnectionImpl$beginTransaction$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            connectionWithLock = r62;
                            sQLiteTransactionType = sQLiteTransactionType2;
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        connectionWithLock = this.delegate;
                        pooledConnectionImpl$beginTransaction$1.L$0 = this;
                        pooledConnectionImpl$beginTransaction$1.L$1 = sQLiteTransactionType;
                        pooledConnectionImpl$beginTransaction$1.L$2 = connectionWithLock;
                        pooledConnectionImpl$beginTransaction$1.label = 1;
                        if (connectionWithLock.lock((Object) null, pooledConnectionImpl$beginTransaction$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pooledConnectionImpl = this;
                    }
                    int size = pooledConnectionImpl.transactionStack.size();
                    if (!pooledConnectionImpl.transactionStack.isEmpty()) {
                        int i12 = WhenMappings.$EnumSwitchMapping$0[sQLiteTransactionType.ordinal()];
                        if (i12 != 1) {
                            if (i12 != 2) {
                                if (i12 == 3) {
                                    SQLite.execSQL(pooledConnectionImpl.delegate, "BEGIN EXCLUSIVE TRANSACTION");
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else {
                                SQLite.execSQL(pooledConnectionImpl.delegate, "BEGIN IMMEDIATE TRANSACTION");
                            }
                        } else {
                            SQLite.execSQL(pooledConnectionImpl.delegate, "BEGIN DEFERRED TRANSACTION");
                        }
                    } else {
                        SQLite.execSQL(pooledConnectionImpl.delegate, "SAVEPOINT '" + size + '\'');
                    }
                    pooledConnectionImpl.transactionStack.addLast(new TransactionItem(size, false));
                    Unit unit = Unit.INSTANCE;
                    connectionWithLock.unlock((Object) null);
                    return unit;
                }
            }
            int size2 = pooledConnectionImpl.transactionStack.size();
            if (!pooledConnectionImpl.transactionStack.isEmpty()) {
            }
            pooledConnectionImpl.transactionStack.addLast(new TransactionItem(size2, false));
            Unit unit2 = Unit.INSTANCE;
            connectionWithLock.unlock((Object) null);
            return unit2;
        } catch (Throwable th) {
            connectionWithLock.unlock((Object) null);
            throw th;
        }
        pooledConnectionImpl$beginTransaction$1 = new PooledConnectionImpl$beginTransaction$1(this, continuation);
        Object obj2 = pooledConnectionImpl$beginTransaction$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = pooledConnectionImpl$beginTransaction$1.label;
        if (i10 == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005a A[Catch: all -> 0x007c, TryCatch #0 {all -> 0x007c, blocks: (B:11:0x0052, B:13:0x005a, B:15:0x0066, B:17:0x006c, B:19:0x0074, B:20:0x00c9, B:24:0x007e, B:25:0x009c, B:27:0x00a4, B:28:0x00ac, B:29:0x00cf, B:30:0x00d6), top: B:10:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cf A[Catch: all -> 0x007c, TRY_ENTER, TryCatch #0 {all -> 0x007c, blocks: (B:11:0x0052, B:13:0x005a, B:15:0x0066, B:17:0x006c, B:19:0x0074, B:20:0x00c9, B:24:0x007e, B:25:0x009c, B:27:0x00a4, B:28:0x00ac, B:29:0x00cf, B:30:0x00d6), top: B:10:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object endTransaction(boolean z10, Continuation<? super Unit> continuation) {
        PooledConnectionImpl$endTransaction$1 pooledConnectionImpl$endTransaction$1;
        int i10;
        PooledConnectionImpl pooledConnectionImpl;
        Mutex mutex;
        try {
            if (continuation instanceof PooledConnectionImpl$endTransaction$1) {
                pooledConnectionImpl$endTransaction$1 = (PooledConnectionImpl$endTransaction$1) continuation;
                int i11 = pooledConnectionImpl$endTransaction$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    pooledConnectionImpl$endTransaction$1.label = i11 - Integer.MIN_VALUE;
                    Object obj = pooledConnectionImpl$endTransaction$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i10 = pooledConnectionImpl$endTransaction$1.label;
                    if (i10 == 0) {
                        if (i10 == 1) {
                            z10 = pooledConnectionImpl$endTransaction$1.Z$0;
                            mutex = (Mutex) pooledConnectionImpl$endTransaction$1.L$1;
                            pooledConnectionImpl = (PooledConnectionImpl) pooledConnectionImpl$endTransaction$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        ConnectionWithLock connectionWithLock = this.delegate;
                        pooledConnectionImpl$endTransaction$1.L$0 = this;
                        pooledConnectionImpl$endTransaction$1.L$1 = connectionWithLock;
                        pooledConnectionImpl$endTransaction$1.Z$0 = z10;
                        pooledConnectionImpl$endTransaction$1.label = 1;
                        if (connectionWithLock.lock((Object) null, pooledConnectionImpl$endTransaction$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pooledConnectionImpl = this;
                        mutex = connectionWithLock;
                    }
                    if (pooledConnectionImpl.transactionStack.isEmpty()) {
                        TransactionItem transactionItem = (TransactionItem) CollectionsKt.removeLast(pooledConnectionImpl.transactionStack);
                        if (z10 && !transactionItem.getShouldRollback()) {
                            if (pooledConnectionImpl.transactionStack.isEmpty()) {
                                SQLite.execSQL(pooledConnectionImpl.delegate, "END TRANSACTION");
                            } else {
                                SQLite.execSQL(pooledConnectionImpl.delegate, "RELEASE SAVEPOINT '" + transactionItem.getId() + '\'');
                            }
                        } else if (pooledConnectionImpl.transactionStack.isEmpty()) {
                            SQLite.execSQL(pooledConnectionImpl.delegate, "ROLLBACK TRANSACTION");
                        } else {
                            SQLite.execSQL(pooledConnectionImpl.delegate, "ROLLBACK TRANSACTION TO SAVEPOINT '" + transactionItem.getId() + '\'');
                        }
                        Unit unit = Unit.INSTANCE;
                        mutex.unlock((Object) null);
                        return unit;
                    }
                    throw new IllegalStateException("Not in a transaction");
                }
            }
            if (pooledConnectionImpl.transactionStack.isEmpty()) {
            }
        } catch (Throwable th) {
            mutex.unlock((Object) null);
            throw th;
        }
        pooledConnectionImpl$endTransaction$1 = new PooledConnectionImpl$endTransaction$1(this, continuation);
        Object obj2 = pooledConnectionImpl$endTransaction$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = pooledConnectionImpl$endTransaction$1.label;
        if (i10 == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isRecycled() {
        return this._isRecycled.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b4 A[Catch: all -> 0x00c8, TRY_LEAVE, TryCatch #3 {all -> 0x00c8, blocks: (B:42:0x00b0, B:44:0x00b4), top: B:41:0x00b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <R> Object transaction(Transactor.SQLiteTransactionType sQLiteTransactionType, Function2<? super TransactionScope<R>, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        PooledConnectionImpl$transaction$1 pooledConnectionImpl$transaction$1;
        Object obj;
        Object coroutine_suspended;
        int i10;
        PooledConnectionImpl pooledConnectionImpl;
        PooledConnectionImpl pooledConnectionImpl2;
        ConnectionPool.RollbackException th;
        int i11;
        Throwable th2;
        try {
            if (continuation instanceof PooledConnectionImpl$transaction$1) {
                pooledConnectionImpl$transaction$1 = (PooledConnectionImpl$transaction$1) continuation;
                int i12 = pooledConnectionImpl$transaction$1.label;
                if ((i12 & Integer.MIN_VALUE) != 0) {
                    pooledConnectionImpl$transaction$1.label = i12 - Integer.MIN_VALUE;
                    obj = pooledConnectionImpl$transaction$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i10 = pooledConnectionImpl$transaction$1.label;
                    boolean z10 = false;
                    ConnectionPool.RollbackException rollbackException = null;
                    if (i10 == 0) {
                        if (i10 != 1) {
                            if (i10 != 2) {
                                if (i10 != 3) {
                                    if (i10 != 4) {
                                        if (i10 != 5) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        th = (Throwable) pooledConnectionImpl$transaction$1.L$1;
                                        th2 = (Throwable) pooledConnectionImpl$transaction$1.L$0;
                                        try {
                                            ResultKt.throwOnFailure(obj);
                                        } catch (SQLException e10) {
                                            e = e10;
                                            if (th2 == null) {
                                                ExceptionsKt.addSuppressed(th2, e);
                                                throw th;
                                            }
                                            throw e;
                                        }
                                        throw th;
                                    }
                                    Object obj2 = pooledConnectionImpl$transaction$1.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    return obj2;
                                }
                                Object obj3 = pooledConnectionImpl$transaction$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                return obj3;
                            }
                            i11 = pooledConnectionImpl$transaction$1.I$0;
                            pooledConnectionImpl2 = (PooledConnectionImpl) pooledConnectionImpl$transaction$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                if (i11 != 0) {
                                    z10 = true;
                                }
                                pooledConnectionImpl$transaction$1.L$0 = obj;
                                pooledConnectionImpl$transaction$1.label = 3;
                                if (pooledConnectionImpl2.endTransaction(z10, pooledConnectionImpl$transaction$1) != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return obj;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    if (!(th instanceof ConnectionPool.RollbackException)) {
                                        Object result = th.getResult();
                                        pooledConnectionImpl$transaction$1.L$0 = result;
                                        pooledConnectionImpl$transaction$1.L$1 = null;
                                        pooledConnectionImpl$transaction$1.label = 4;
                                        if (pooledConnectionImpl2.endTransaction(false, pooledConnectionImpl$transaction$1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        return result;
                                    }
                                    try {
                                        throw th;
                                    } catch (Throwable th4) {
                                        rollbackException = th;
                                        th = th4;
                                        try {
                                            pooledConnectionImpl$transaction$1.L$0 = rollbackException;
                                            pooledConnectionImpl$transaction$1.L$1 = th;
                                            pooledConnectionImpl$transaction$1.label = 5;
                                            if (pooledConnectionImpl2.endTransaction(false, pooledConnectionImpl$transaction$1) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        } catch (SQLException e11) {
                                            e = e11;
                                            th2 = rollbackException;
                                            if (th2 == null) {
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                }
                            }
                        } else {
                            function2 = (Function2) pooledConnectionImpl$transaction$1.L$1;
                            pooledConnectionImpl = (PooledConnectionImpl) pooledConnectionImpl$transaction$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        if (sQLiteTransactionType == null) {
                            sQLiteTransactionType = Transactor.SQLiteTransactionType.DEFERRED;
                        }
                        pooledConnectionImpl$transaction$1.L$0 = this;
                        pooledConnectionImpl$transaction$1.L$1 = function2;
                        pooledConnectionImpl$transaction$1.label = 1;
                        if (beginTransaction(sQLiteTransactionType, pooledConnectionImpl$transaction$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pooledConnectionImpl = this;
                    }
                    TransactionImpl transactionImpl = new TransactionImpl();
                    pooledConnectionImpl$transaction$1.L$0 = pooledConnectionImpl;
                    pooledConnectionImpl$transaction$1.L$1 = null;
                    pooledConnectionImpl$transaction$1.I$0 = 1;
                    pooledConnectionImpl$transaction$1.label = 2;
                    obj = function2.invoke(transactionImpl, pooledConnectionImpl$transaction$1);
                    if (obj != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pooledConnectionImpl2 = pooledConnectionImpl;
                    i11 = 1;
                    if (i11 != 0) {
                    }
                    pooledConnectionImpl$transaction$1.L$0 = obj;
                    pooledConnectionImpl$transaction$1.label = 3;
                    if (pooledConnectionImpl2.endTransaction(z10, pooledConnectionImpl$transaction$1) != coroutine_suspended) {
                    }
                }
            }
            TransactionImpl transactionImpl2 = new TransactionImpl();
            pooledConnectionImpl$transaction$1.L$0 = pooledConnectionImpl;
            pooledConnectionImpl$transaction$1.L$1 = null;
            pooledConnectionImpl$transaction$1.I$0 = 1;
            pooledConnectionImpl$transaction$1.label = 2;
            obj = function2.invoke(transactionImpl2, pooledConnectionImpl$transaction$1);
            if (obj != coroutine_suspended) {
            }
        } catch (Throwable th6) {
            pooledConnectionImpl2 = pooledConnectionImpl;
            th = th6;
            if (!(th instanceof ConnectionPool.RollbackException)) {
            }
        }
        pooledConnectionImpl$transaction$1 = new PooledConnectionImpl$transaction$1(this, continuation);
        obj = pooledConnectionImpl$transaction$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = pooledConnectionImpl$transaction$1.label;
        boolean z102 = false;
        ConnectionPool.RollbackException rollbackException2 = null;
        if (i10 == 0) {
        }
    }

    private final <R> Object withStateCheck(Function0<? extends R> function0, Continuation<? super R> continuation) {
        if (isRecycled()) {
            SQLite.throwSQLiteException(21, "Connection is recycled");
            throw new KotlinNothingValueException();
        }
        InlineMarker.mark(3);
        throw null;
    }

    @NotNull
    public final ConnectionWithLock getDelegate() {
        return this.delegate;
    }

    @Override // androidx.room.coroutines.RawConnectionAccessor
    @NotNull
    public SQLiteConnection getRawConnection() {
        return this.delegate;
    }

    @Override // androidx.room.Transactor
    @Nullable
    public Object inTransaction(@NotNull Continuation<? super Boolean> continuation) {
        if (!isRecycled()) {
            ConnectionElement connectionElement = (ConnectionElement) continuation.get$context().get(ConnectionElement.INSTANCE);
            if (connectionElement != null && connectionElement.getConnectionWrapper() == this) {
                return Boxing.boxBoolean(!this.transactionStack.isEmpty());
            }
            SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
            throw new KotlinNothingValueException();
        }
        SQLite.throwSQLiteException(21, "Connection is recycled");
        throw new KotlinNothingValueException();
    }

    /* renamed from: isReadOnly, reason: from getter */
    public final boolean getIsReadOnly() {
        return this.isReadOnly;
    }

    public final void markRecycled() {
        if (this._isRecycled.compareAndSet(false, true)) {
            try {
                SQLite.execSQL(this.delegate, "ROLLBACK TRANSACTION");
            } catch (SQLException unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r7v12, types: [kotlinx.coroutines.sync.Mutex] */
    @Override // androidx.room.PooledConnection
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <R> Object usePrepared(@NotNull String str, @NotNull Function1<? super SQLiteStatement, ? extends R> function1, @NotNull Continuation<? super R> continuation) {
        PooledConnectionImpl$usePrepared$1 pooledConnectionImpl$usePrepared$1;
        int i10;
        ConnectionWithLock connectionWithLock;
        PooledConnectionImpl pooledConnectionImpl;
        try {
            try {
                if (continuation instanceof PooledConnectionImpl$usePrepared$1) {
                    pooledConnectionImpl$usePrepared$1 = (PooledConnectionImpl$usePrepared$1) continuation;
                    int i11 = pooledConnectionImpl$usePrepared$1.label;
                    if ((i11 & Integer.MIN_VALUE) != 0) {
                        pooledConnectionImpl$usePrepared$1.label = i11 - Integer.MIN_VALUE;
                        Object obj = pooledConnectionImpl$usePrepared$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i10 = pooledConnectionImpl$usePrepared$1.label;
                        if (i10 == 0) {
                            if (i10 == 1) {
                                ?? r72 = (Mutex) pooledConnectionImpl$usePrepared$1.L$3;
                                function1 = (Function1) pooledConnectionImpl$usePrepared$1.L$2;
                                String str2 = (String) pooledConnectionImpl$usePrepared$1.L$1;
                                pooledConnectionImpl = (PooledConnectionImpl) pooledConnectionImpl$usePrepared$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                connectionWithLock = r72;
                                str = str2;
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            if (!isRecycled()) {
                                ConnectionElement connectionElement = (ConnectionElement) pooledConnectionImpl$usePrepared$1.get$context().get(ConnectionElement.INSTANCE);
                                if (connectionElement != null && connectionElement.getConnectionWrapper() == this) {
                                    connectionWithLock = this.delegate;
                                    pooledConnectionImpl$usePrepared$1.L$0 = this;
                                    pooledConnectionImpl$usePrepared$1.L$1 = str;
                                    pooledConnectionImpl$usePrepared$1.L$2 = function1;
                                    pooledConnectionImpl$usePrepared$1.L$3 = connectionWithLock;
                                    pooledConnectionImpl$usePrepared$1.label = 1;
                                    if (connectionWithLock.lock((Object) null, pooledConnectionImpl$usePrepared$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    pooledConnectionImpl = this;
                                } else {
                                    SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
                                    throw new KotlinNothingValueException();
                                }
                            } else {
                                SQLite.throwSQLiteException(21, "Connection is recycled");
                                throw new KotlinNothingValueException();
                            }
                        }
                        StatementWrapper statementWrapper = new StatementWrapper(pooledConnectionImpl, pooledConnectionImpl.delegate.prepare(str));
                        R invoke = function1.invoke(statementWrapper);
                        AutoCloseableKt.closeFinally(statementWrapper, null);
                        return invoke;
                    }
                }
                R invoke2 = function1.invoke(statementWrapper);
                AutoCloseableKt.closeFinally(statementWrapper, null);
                return invoke2;
            } finally {
            }
            StatementWrapper statementWrapper2 = new StatementWrapper(pooledConnectionImpl, pooledConnectionImpl.delegate.prepare(str));
        } finally {
            connectionWithLock.unlock((Object) null);
        }
        pooledConnectionImpl$usePrepared$1 = new PooledConnectionImpl$usePrepared$1(this, continuation);
        Object obj2 = pooledConnectionImpl$usePrepared$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = pooledConnectionImpl$usePrepared$1.label;
        if (i10 == 0) {
        }
    }

    @Override // androidx.room.Transactor
    @Nullable
    public <R> Object withTransaction(@NotNull Transactor.SQLiteTransactionType sQLiteTransactionType, @NotNull Function2<? super TransactionScope<R>, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
        if (!isRecycled()) {
            ConnectionElement connectionElement = (ConnectionElement) continuation.get$context().get(ConnectionElement.INSTANCE);
            if (connectionElement != null && connectionElement.getConnectionWrapper() == this) {
                return transaction(sQLiteTransactionType, function2, continuation);
            }
            SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
            throw new KotlinNothingValueException();
        }
        SQLite.throwSQLiteException(21, "Connection is recycled");
        throw new KotlinNothingValueException();
    }
}
