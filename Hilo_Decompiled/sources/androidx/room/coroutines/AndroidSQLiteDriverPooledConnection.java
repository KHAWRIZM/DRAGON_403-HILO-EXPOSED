package androidx.room.coroutines;

import android.database.sqlite.SQLiteDatabase;
import androidx.room.TransactionScope;
import androidx.room.Transactor;
import androidx.room.coroutines.ConnectionPool;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.driver.AndroidSQLiteConnection;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001#B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J0\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002H\u00100\u0014H\u0096@¢\u0006\u0002\u0010\u0016JK\u0010\u0017\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0018\u001a\u00020\n2-\u0010\u0013\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019¢\u0006\u0002\b\u001dH\u0096@¢\u0006\u0002\u0010\u001eJK\u0010\u001f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0018\u001a\u00020\n2-\u0010\u0013\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019¢\u0006\u0002\b\u001dH\u0082@¢\u0006\u0002\u0010\u001eJ\u000e\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006$"}, d2 = {"Landroidx/room/coroutines/AndroidSQLiteDriverPooledConnection;", "Landroidx/room/Transactor;", "Landroidx/room/coroutines/RawConnectionAccessor;", "delegate", "Landroidx/sqlite/driver/AndroidSQLiteConnection;", "<init>", "(Landroidx/sqlite/driver/AndroidSQLiteConnection;)V", "getDelegate", "()Landroidx/sqlite/driver/AndroidSQLiteConnection;", "currentTransactionType", "Landroidx/room/Transactor$SQLiteTransactionType;", "rawConnection", "Landroidx/sqlite/SQLiteConnection;", "getRawConnection", "()Landroidx/sqlite/SQLiteConnection;", "usePrepared", "R", "sql", "", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function1;", "Landroidx/sqlite/SQLiteStatement;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTransaction", "type", "Lkotlin/Function2;", "Landroidx/room/TransactionScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/room/Transactor$SQLiteTransactionType;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transaction", "inTransaction", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AndroidSQLiteDriverTransactor", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAndroidSQLiteDriverConnectionPool.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidSQLiteDriverConnectionPool.android.kt\nandroidx/room/coroutines/AndroidSQLiteDriverPooledConnection\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,125:1\n1#2:126\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class AndroidSQLiteDriverPooledConnection implements Transactor, RawConnectionAccessor {

    @Nullable
    private Transactor.SQLiteTransactionType currentTransactionType;

    @NotNull
    private final AndroidSQLiteConnection delegate;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0001\u0010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002H\u000b0\u000fH\u0096@¢\u0006\u0002\u0010\u0011J>\u0010\u0012\u001a\u0002H\u000b\"\u0004\b\u0001\u0010\u000b2(\u0010\u000e\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013H\u0096@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"Landroidx/room/coroutines/AndroidSQLiteDriverPooledConnection$AndroidSQLiteDriverTransactor;", "T", "Landroidx/room/TransactionScope;", "Landroidx/room/coroutines/RawConnectionAccessor;", "<init>", "(Landroidx/room/coroutines/AndroidSQLiteDriverPooledConnection;)V", "rawConnection", "Landroidx/sqlite/SQLiteConnection;", "getRawConnection", "()Landroidx/sqlite/SQLiteConnection;", "usePrepared", "R", "sql", "", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function1;", "Landroidx/sqlite/SQLiteStatement;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withNestedTransaction", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rollback", "", "result", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public final class AndroidSQLiteDriverTransactor<T> implements TransactionScope<T>, RawConnectionAccessor {
        public AndroidSQLiteDriverTransactor() {
        }

        @Override // androidx.room.coroutines.RawConnectionAccessor
        @NotNull
        public SQLiteConnection getRawConnection() {
            return AndroidSQLiteDriverPooledConnection.this.getRawConnection();
        }

        @Override // androidx.room.TransactionScope
        @Nullable
        public Object rollback(T t10, @NotNull Continuation<?> continuation) {
            throw new ConnectionPool.RollbackException(t10);
        }

        @Override // androidx.room.PooledConnection
        @Nullable
        public <R> Object usePrepared(@NotNull String str, @NotNull Function1<? super SQLiteStatement, ? extends R> function1, @NotNull Continuation<? super R> continuation) {
            return AndroidSQLiteDriverPooledConnection.this.usePrepared(str, function1, continuation);
        }

        @Override // androidx.room.TransactionScope
        @Nullable
        public <R> Object withNestedTransaction(@NotNull Function2<? super TransactionScope<R>, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
            AndroidSQLiteDriverPooledConnection androidSQLiteDriverPooledConnection = AndroidSQLiteDriverPooledConnection.this;
            Transactor.SQLiteTransactionType sQLiteTransactionType = androidSQLiteDriverPooledConnection.currentTransactionType;
            if (sQLiteTransactionType != null) {
                return androidSQLiteDriverPooledConnection.transaction(sQLiteTransactionType, function2, continuation);
            }
            throw new IllegalStateException("Required value was null.");
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

    public AndroidSQLiteDriverPooledConnection(@NotNull AndroidSQLiteConnection delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <R> Object transaction(Transactor.SQLiteTransactionType sQLiteTransactionType, Function2<? super TransactionScope<R>, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        AndroidSQLiteDriverPooledConnection$transaction$1 androidSQLiteDriverPooledConnection$transaction$1;
        int i10;
        AndroidSQLiteDriverPooledConnection androidSQLiteDriverPooledConnection;
        ConnectionPool.RollbackException e10;
        SQLiteDatabase sQLiteDatabase;
        try {
            if (continuation instanceof AndroidSQLiteDriverPooledConnection$transaction$1) {
                androidSQLiteDriverPooledConnection$transaction$1 = (AndroidSQLiteDriverPooledConnection$transaction$1) continuation;
                int i11 = androidSQLiteDriverPooledConnection$transaction$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    androidSQLiteDriverPooledConnection$transaction$1.label = i11 - Integer.MIN_VALUE;
                    Object obj = androidSQLiteDriverPooledConnection$transaction$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i10 = androidSQLiteDriverPooledConnection$transaction$1.label;
                    if (i10 == 0) {
                        if (i10 == 1) {
                            sQLiteDatabase = (SQLiteDatabase) androidSQLiteDriverPooledConnection$transaction$1.L$1;
                            androidSQLiteDriverPooledConnection = (AndroidSQLiteDriverPooledConnection) androidSQLiteDriverPooledConnection$transaction$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                            } catch (ConnectionPool.RollbackException e11) {
                                e10 = e11;
                                Object result = e10.getResult();
                                sQLiteDatabase.endTransaction();
                                if (!sQLiteDatabase.inTransaction()) {
                                    androidSQLiteDriverPooledConnection.currentTransactionType = null;
                                }
                                return result;
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        SQLiteDatabase db2 = this.delegate.getDb();
                        if (!db2.inTransaction()) {
                            this.currentTransactionType = sQLiteTransactionType;
                        }
                        int i12 = WhenMappings.$EnumSwitchMapping$0[sQLiteTransactionType.ordinal()];
                        if (i12 != 1) {
                            if (i12 != 2) {
                                if (i12 == 3) {
                                    db2.beginTransaction();
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else {
                                db2.beginTransactionNonExclusive();
                            }
                        } else {
                            db2.beginTransactionNonExclusive();
                        }
                        try {
                            AndroidSQLiteDriverTransactor androidSQLiteDriverTransactor = new AndroidSQLiteDriverTransactor();
                            androidSQLiteDriverPooledConnection$transaction$1.L$0 = this;
                            androidSQLiteDriverPooledConnection$transaction$1.L$1 = db2;
                            androidSQLiteDriverPooledConnection$transaction$1.label = 1;
                            Object invoke = function2.invoke(androidSQLiteDriverTransactor, androidSQLiteDriverPooledConnection$transaction$1);
                            if (invoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            androidSQLiteDriverPooledConnection = this;
                            obj = invoke;
                            sQLiteDatabase = db2;
                        } catch (ConnectionPool.RollbackException e12) {
                            androidSQLiteDriverPooledConnection = this;
                            e10 = e12;
                            sQLiteDatabase = db2;
                            Object result2 = e10.getResult();
                            sQLiteDatabase.endTransaction();
                            if (!sQLiteDatabase.inTransaction()) {
                            }
                            return result2;
                        } catch (Throwable th) {
                            function2 = (Function2<? super TransactionScope<R>, ? super Continuation<? super R>, ? extends Object>) this;
                            th = th;
                            sQLiteTransactionType = db2;
                            sQLiteTransactionType.endTransaction();
                            if (!sQLiteTransactionType.inTransaction()) {
                                function2.currentTransactionType = null;
                            }
                            throw th;
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                    if (!sQLiteDatabase.inTransaction()) {
                        androidSQLiteDriverPooledConnection.currentTransactionType = null;
                    }
                    return obj;
                }
            }
            if (i10 == 0) {
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            if (!sQLiteDatabase.inTransaction()) {
            }
            return obj;
        } catch (Throwable th2) {
            th = th2;
        }
        androidSQLiteDriverPooledConnection$transaction$1 = new AndroidSQLiteDriverPooledConnection$transaction$1(this, continuation);
        Object obj2 = androidSQLiteDriverPooledConnection$transaction$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = androidSQLiteDriverPooledConnection$transaction$1.label;
    }

    @NotNull
    public final AndroidSQLiteConnection getDelegate() {
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
        return Boxing.boxBoolean(this.delegate.getDb().inTransaction());
    }

    @Override // androidx.room.PooledConnection
    @Nullable
    public <R> Object usePrepared(@NotNull String str, @NotNull Function1<? super SQLiteStatement, ? extends R> function1, @NotNull Continuation<? super R> continuation) {
        SQLiteStatement prepare = this.delegate.prepare(str);
        try {
            R invoke = function1.invoke(prepare);
            AutoCloseableKt.closeFinally(prepare, null);
            return invoke;
        } finally {
        }
    }

    @Override // androidx.room.Transactor
    @Nullable
    public <R> Object withTransaction(@NotNull Transactor.SQLiteTransactionType sQLiteTransactionType, @NotNull Function2<? super TransactionScope<R>, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
        return transaction(sQLiteTransactionType, function2, continuation);
    }
}
