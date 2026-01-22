package androidx.room;

import androidx.room.Transactor;
import com.qhqc.core.basic.net.exception.ApiErrorException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.RoomDatabase$performClear$1", f = "RoomDatabase.android.kt", i = {}, l = {ApiErrorException.BAD_GATEWAY}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class RoomDatabase$performClear$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $hasForeignKeys;
    final /* synthetic */ String[] $tableNames;
    int label;
    final /* synthetic */ RoomDatabase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "connection", "Landroidx/room/Transactor;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.RoomDatabase$performClear$1$1", f = "RoomDatabase.android.kt", i = {0, 1, 2, 3, 4}, l = {ApiErrorException.SERVICE_UNAVAILABLE, 504, 506, 512, 513, 514}, m = "invokeSuspend", n = {"connection", "connection", "connection", "connection", "connection"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0"})
    /* renamed from: androidx.room.RoomDatabase$performClear$1$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Transactor, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $hasForeignKeys;
        final /* synthetic */ String[] $tableNames;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RoomDatabase this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/room/TransactionScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.room.RoomDatabase$performClear$1$1$1", f = "RoomDatabase.android.kt", i = {0, 1, 1}, l = {508, 510}, m = "invokeSuspend", n = {"$this$withTransaction", "$this$withTransaction", "$this$forEach$iv"}, s = {"L$0", "L$0", "L$1"})
        @SourceDebugExtension({"SMAP\nRoomDatabase.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomDatabase.android.kt\nandroidx/room/RoomDatabase$performClear$1$1$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,2120:1\n13402#2,2:2121\n*S KotlinDebug\n*F\n+ 1 RoomDatabase.android.kt\nandroidx/room/RoomDatabase$performClear$1$1$1\n*L\n510#1:2121,2\n*E\n"})
        /* renamed from: androidx.room.RoomDatabase$performClear$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public static final class C٠٠٥٢1 extends SuspendLambda implements Function2<TransactionScope<Unit>, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $hasForeignKeys;
            final /* synthetic */ String[] $tableNames;
            int I$0;
            int I$1;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C٠٠٥٢1(boolean z10, String[] strArr, Continuation<? super C٠٠٥٢1> continuation) {
                super(2, continuation);
                this.$hasForeignKeys = z10;
                this.$tableNames = strArr;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C٠٠٥٢1 r02 = new C٠٠٥٢1(this.$hasForeignKeys, this.$tableNames, continuation);
                r02.L$0 = obj;
                return r02;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(TransactionScope<Unit> transactionScope, Continuation<? super Unit> continuation) {
                return ((C٠٠٥٢1) create(transactionScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:12:0x007c  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0051  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0077 -> B:6:0x007a). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                TransactionScope transactionScope;
                String[] strArr;
                TransactionScope transactionScope2;
                int length;
                int i10;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i11 = this.label;
                if (i11 != 0) {
                    if (i11 != 1) {
                        if (i11 == 2) {
                            length = this.I$1;
                            i10 = this.I$0;
                            strArr = (String[]) this.L$1;
                            transactionScope2 = (TransactionScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            i10++;
                            if (i10 < length) {
                                String str = "DELETE FROM `" + strArr[i10] + '`';
                                this.L$0 = transactionScope2;
                                this.L$1 = strArr;
                                this.I$0 = i10;
                                this.I$1 = length;
                                this.label = 2;
                                if (TransactorKt.execSQL(transactionScope2, str, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                i10++;
                                if (i10 < length) {
                                    return Unit.INSTANCE;
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        transactionScope = (TransactionScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    transactionScope = (TransactionScope) this.L$0;
                    if (this.$hasForeignKeys) {
                        this.L$0 = transactionScope;
                        this.label = 1;
                        if (TransactorKt.execSQL(transactionScope, "PRAGMA defer_foreign_keys = TRUE", this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                String[] strArr2 = this.$tableNames;
                strArr = strArr2;
                transactionScope2 = transactionScope;
                length = strArr2.length;
                i10 = 0;
                if (i10 < length) {
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RoomDatabase roomDatabase, boolean z10, String[] strArr, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = roomDatabase;
            this.$hasForeignKeys = z10;
            this.$tableNames = strArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$hasForeignKeys, this.$tableNames, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Transactor transactor, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(transactor, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:13:0x00b6 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0092 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0086 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Transactor transactor;
            Transactor.SQLiteTransactionType sQLiteTransactionType;
            C٠٠٥٢1 r32;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    Transactor transactor2 = (Transactor) this.L$0;
                    this.L$0 = transactor2;
                    this.label = 1;
                    Object inTransaction = transactor2.inTransaction(this);
                    if (inTransaction == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    transactor = transactor2;
                    obj = inTransaction;
                    if (!((Boolean) obj).booleanValue()) {
                        InvalidationTracker invalidationTracker = this.this$0.getInvalidationTracker();
                        this.L$0 = transactor;
                        this.label = 2;
                        if (invalidationTracker.sync$room_runtime_release(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    sQLiteTransactionType = Transactor.SQLiteTransactionType.IMMEDIATE;
                    r32 = new C٠٠٥٢1(this.$hasForeignKeys, this.$tableNames, null);
                    this.L$0 = transactor;
                    this.label = 3;
                    if (transactor.withTransaction(sQLiteTransactionType, r32, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.L$0 = transactor;
                    this.label = 4;
                    obj = transactor.inTransaction(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        this.L$0 = transactor;
                        this.label = 5;
                        if (TransactorKt.execSQL(transactor, "PRAGMA wal_checkpoint(FULL)", this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        this.L$0 = null;
                        this.label = 6;
                        if (TransactorKt.execSQL(transactor, "VACUUM", this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        this.this$0.getInvalidationTracker().refreshAsync();
                    }
                    return Unit.INSTANCE;
                case 1:
                    transactor = (Transactor) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    sQLiteTransactionType = Transactor.SQLiteTransactionType.IMMEDIATE;
                    r32 = new C٠٠٥٢1(this.$hasForeignKeys, this.$tableNames, null);
                    this.L$0 = transactor;
                    this.label = 3;
                    if (transactor.withTransaction(sQLiteTransactionType, r32, this) == coroutine_suspended) {
                    }
                    this.L$0 = transactor;
                    this.label = 4;
                    obj = transactor.inTransaction(this);
                    if (obj == coroutine_suspended) {
                    }
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                case 2:
                    transactor = (Transactor) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    sQLiteTransactionType = Transactor.SQLiteTransactionType.IMMEDIATE;
                    r32 = new C٠٠٥٢1(this.$hasForeignKeys, this.$tableNames, null);
                    this.L$0 = transactor;
                    this.label = 3;
                    if (transactor.withTransaction(sQLiteTransactionType, r32, this) == coroutine_suspended) {
                    }
                    this.L$0 = transactor;
                    this.label = 4;
                    obj = transactor.inTransaction(this);
                    if (obj == coroutine_suspended) {
                    }
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                case 3:
                    transactor = (Transactor) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = transactor;
                    this.label = 4;
                    obj = transactor.inTransaction(this);
                    if (obj == coroutine_suspended) {
                    }
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                case 4:
                    transactor = (Transactor) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                case 5:
                    transactor = (Transactor) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = null;
                    this.label = 6;
                    if (TransactorKt.execSQL(transactor, "VACUUM", this) == coroutine_suspended) {
                    }
                    this.this$0.getInvalidationTracker().refreshAsync();
                    return Unit.INSTANCE;
                case 6:
                    ResultKt.throwOnFailure(obj);
                    this.this$0.getInvalidationTracker().refreshAsync();
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomDatabase$performClear$1(RoomDatabase roomDatabase, boolean z10, String[] strArr, Continuation<? super RoomDatabase$performClear$1> continuation) {
        super(2, continuation);
        this.this$0 = roomDatabase;
        this.$hasForeignKeys = z10;
        this.$tableNames = strArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomDatabase$performClear$1(this.this$0, this.$hasForeignKeys, this.$tableNames, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        RoomConnectionManager roomConnectionManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            roomConnectionManager = this.this$0.connectionManager;
            if (roomConnectionManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("connectionManager");
                roomConnectionManager = null;
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$hasForeignKeys, this.$tableNames, null);
            this.label = 1;
            if (roomConnectionManager.useConnection(false, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RoomDatabase$performClear$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
