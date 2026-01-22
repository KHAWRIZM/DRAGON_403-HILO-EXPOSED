package androidx.room.util;

import androidx.room.InvalidationTracker;
import androidx.room.PooledConnection;
import androidx.room.RoomDatabase;
import androidx.room.Transactor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "R", "transactor", "Landroidx/room/Transactor;"}, k = 3, mv = {2, 0, 0}, xi = 176)
@DebugMetadata(c = "androidx.room.util.DBUtil__DBUtilKt$internalPerform$2", f = "DBUtil.kt", i = {0, 0, 1, 1, 2, 3}, l = {56, 57, 59, 60, 65}, m = "invokeSuspend", n = {"transactor", "type", "transactor", "type", "transactor", "result"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$0"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class DBUtil__DBUtilKt$internalPerform$2<R> extends SuspendLambda implements Function2<Transactor, Continuation<? super R>, Object> {
    final /* synthetic */ Function2<PooledConnection, Continuation<? super R>, Object> $block;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ boolean $isReadOnly;
    final /* synthetic */ RoomDatabase $this_internalPerform;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DBUtil__DBUtilKt$internalPerform$2(boolean z10, boolean z11, RoomDatabase roomDatabase, Function2<? super PooledConnection, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super DBUtil__DBUtilKt$internalPerform$2> continuation) {
        super(2, continuation);
        this.$inTransaction = z10;
        this.$isReadOnly = z11;
        this.$this_internalPerform = roomDatabase;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DBUtil__DBUtilKt$internalPerform$2 dBUtil__DBUtilKt$internalPerform$2 = new DBUtil__DBUtilKt$internalPerform$2(this.$inTransaction, this.$isReadOnly, this.$this_internalPerform, this.$block, continuation);
        dBUtil__DBUtilKt$internalPerform$2.L$0 = obj;
        return dBUtil__DBUtilKt$internalPerform$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Transactor transactor, Continuation<? super R> continuation) {
        return ((DBUtil__DBUtilKt$internalPerform$2) create(transactor, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a7 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Transactor.SQLiteTransactionType sQLiteTransactionType;
        Transactor transactor;
        Transactor transactor2;
        Transactor.SQLiteTransactionType sQLiteTransactionType2;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 == 5) {
                                ResultKt.throwOnFailure(obj);
                                return obj;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        obj2 = this.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            this.$this_internalPerform.getInvalidationTracker().refreshAsync();
                        }
                        return obj2;
                    }
                    transactor = (Transactor) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (this.$isReadOnly) {
                        this.L$0 = obj;
                        this.label = 4;
                        Object inTransaction = transactor.inTransaction(this);
                        if (inTransaction == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj2 = obj;
                        obj = inTransaction;
                        if (!((Boolean) obj).booleanValue()) {
                        }
                        return obj2;
                    }
                    return obj;
                }
                sQLiteTransactionType2 = (Transactor.SQLiteTransactionType) this.L$1;
                transactor2 = (Transactor) this.L$0;
                ResultKt.throwOnFailure(obj);
                Transactor transactor3 = transactor2;
                sQLiteTransactionType = sQLiteTransactionType2;
                transactor = transactor3;
                DBUtil__DBUtilKt$internalPerform$2$result$1 dBUtil__DBUtilKt$internalPerform$2$result$1 = new DBUtil__DBUtilKt$internalPerform$2$result$1(this.$block, null);
                this.L$0 = transactor;
                this.L$1 = null;
                this.label = 3;
                obj = transactor.withTransaction(sQLiteTransactionType, dBUtil__DBUtilKt$internalPerform$2$result$1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (this.$isReadOnly) {
                }
            } else {
                sQLiteTransactionType2 = (Transactor.SQLiteTransactionType) this.L$1;
                transactor2 = (Transactor) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Transactor transactor4 = (Transactor) this.L$0;
            if (this.$inTransaction) {
                boolean z10 = this.$isReadOnly;
                if (z10) {
                    sQLiteTransactionType = Transactor.SQLiteTransactionType.DEFERRED;
                } else {
                    sQLiteTransactionType = Transactor.SQLiteTransactionType.IMMEDIATE;
                }
                if (!z10) {
                    this.L$0 = transactor4;
                    this.L$1 = sQLiteTransactionType;
                    this.label = 1;
                    Object inTransaction2 = transactor4.inTransaction(this);
                    if (inTransaction2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Transactor.SQLiteTransactionType sQLiteTransactionType3 = sQLiteTransactionType;
                    transactor2 = transactor4;
                    obj = inTransaction2;
                    sQLiteTransactionType2 = sQLiteTransactionType3;
                } else {
                    transactor = transactor4;
                    DBUtil__DBUtilKt$internalPerform$2$result$1 dBUtil__DBUtilKt$internalPerform$2$result$12 = new DBUtil__DBUtilKt$internalPerform$2$result$1(this.$block, null);
                    this.L$0 = transactor;
                    this.L$1 = null;
                    this.label = 3;
                    obj = transactor.withTransaction(sQLiteTransactionType, dBUtil__DBUtilKt$internalPerform$2$result$12, this);
                    if (obj == coroutine_suspended) {
                    }
                    if (this.$isReadOnly) {
                    }
                }
            } else {
                Function2<PooledConnection, Continuation<? super R>, Object> function2 = this.$block;
                this.label = 5;
                Object invoke = function2.invoke(transactor4, this);
                if (invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return invoke;
            }
        }
        if (!((Boolean) obj).booleanValue()) {
            InvalidationTracker invalidationTracker = this.$this_internalPerform.getInvalidationTracker();
            this.L$0 = transactor2;
            this.L$1 = sQLiteTransactionType2;
            this.label = 2;
            if (invalidationTracker.sync$room_runtime_release(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Transactor transactor32 = transactor2;
        sQLiteTransactionType = sQLiteTransactionType2;
        transactor = transactor32;
        DBUtil__DBUtilKt$internalPerform$2$result$1 dBUtil__DBUtilKt$internalPerform$2$result$122 = new DBUtil__DBUtilKt$internalPerform$2$result$1(this.$block, null);
        this.L$0 = transactor;
        this.L$1 = null;
        this.label = 3;
        obj = transactor.withTransaction(sQLiteTransactionType, dBUtil__DBUtilKt$internalPerform$2$result$122, this);
        if (obj == coroutine_suspended) {
        }
        if (this.$isReadOnly) {
        }
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        Transactor.SQLiteTransactionType sQLiteTransactionType;
        Transactor transactor = (Transactor) this.L$0;
        if (this.$inTransaction) {
            boolean z10 = this.$isReadOnly;
            if (z10) {
                sQLiteTransactionType = Transactor.SQLiteTransactionType.DEFERRED;
            } else {
                sQLiteTransactionType = Transactor.SQLiteTransactionType.IMMEDIATE;
            }
            if (!z10) {
                InlineMarker.mark(0);
                Object inTransaction = transactor.inTransaction(this);
                InlineMarker.mark(1);
                if (!((Boolean) inTransaction).booleanValue()) {
                    InvalidationTracker invalidationTracker = this.$this_internalPerform.getInvalidationTracker();
                    InlineMarker.mark(0);
                    invalidationTracker.sync$room_runtime_release(this);
                    InlineMarker.mark(1);
                }
            }
            DBUtil__DBUtilKt$internalPerform$2$result$1 dBUtil__DBUtilKt$internalPerform$2$result$1 = new DBUtil__DBUtilKt$internalPerform$2$result$1(this.$block, null);
            InlineMarker.mark(0);
            Object withTransaction = transactor.withTransaction(sQLiteTransactionType, dBUtil__DBUtilKt$internalPerform$2$result$1, this);
            InlineMarker.mark(1);
            if (!this.$isReadOnly) {
                InlineMarker.mark(0);
                Object inTransaction2 = transactor.inTransaction(this);
                InlineMarker.mark(1);
                if (!((Boolean) inTransaction2).booleanValue()) {
                    this.$this_internalPerform.getInvalidationTracker().refreshAsync();
                    return withTransaction;
                }
                return withTransaction;
            }
            return withTransaction;
        }
        return this.$block.invoke(transactor, this);
    }
}
