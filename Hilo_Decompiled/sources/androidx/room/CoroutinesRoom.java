package androidx.room;

import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import androidx.room.CoroutinesRoom;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteConnection;
import com.facebook.appevents.UserDataStore;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/room/CoroutinesRoom;", "", "<init>", "()V", "Companion", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class CoroutinesRoom {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bH\u0087@¢\u0006\u0002\u0010\fJ<\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bH\u0087@¢\u0006\u0002\u0010\u000fJJ\u0010\u0010\u001a\r\u0012\t\u0012\u0007H\u0005¢\u0006\u0002\b\u00120\u0011\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bH\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/room/CoroutinesRoom$Companion;", "", "<init>", "()V", "execute", "R", UserDataStore.DATE_OF_BIRTH, "Landroidx/room/RoomDatabase;", "inTransaction", "", "callable", "Ljava/util/concurrent/Callable;", "(Landroidx/room/RoomDatabase;ZLjava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Landroidx/room/RoomDatabase;ZLandroid/os/CancellationSignal;Ljava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/jvm/JvmSuppressWildcards;", "tableNames", "", "", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lkotlinx/coroutines/flow/Flow;", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nCoroutinesRoom.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutinesRoom.android.kt\nandroidx/room/CoroutinesRoom$Companion\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,93:1\n314#2,11:94\n*S KotlinDebug\n*F\n+ 1 CoroutinesRoom.android.kt\nandroidx/room/CoroutinesRoom$Companion\n*L\n65#1:94,11\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object createFlow$lambda$1(Callable callable, SQLiteConnection it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return callable.call();
        }

        @Deprecated(message = "No longer called by generated implementation")
        @JvmStatic
        @NotNull
        public final <R> Flow<R> createFlow(@NotNull RoomDatabase db2, boolean inTransaction, @NotNull String[] tableNames, @NotNull final Callable<R> callable) {
            Intrinsics.checkNotNullParameter(db2, "db");
            Intrinsics.checkNotNullParameter(tableNames, "tableNames");
            Intrinsics.checkNotNullParameter(callable, "callable");
            return FlowUtil.createFlow(db2, inTransaction, tableNames, new Function1() { // from class: androidx.room.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object createFlow$lambda$1;
                    createFlow$lambda$1 = CoroutinesRoom.Companion.createFlow$lambda$1(callable, (SQLiteConnection) obj);
                    return createFlow$lambda$1;
                }
            });
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x006f A[PHI: r9
  0x006f: PHI (r9v8 java.lang.Object) = (r9v7 java.lang.Object), (r9v1 java.lang.Object) binds: [B:17:0x006c, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x006e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        @Deprecated(message = "No longer called by generated implementation")
        @JvmStatic
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z10, @NotNull Callable<R> callable, @NotNull Continuation<? super R> continuation) {
            CoroutinesRoom$Companion$execute$1 coroutinesRoom$Companion$execute$1;
            int i10;
            if (continuation instanceof CoroutinesRoom$Companion$execute$1) {
                coroutinesRoom$Companion$execute$1 = (CoroutinesRoom$Companion$execute$1) continuation;
                int i11 = coroutinesRoom$Companion$execute$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    coroutinesRoom$Companion$execute$1.label = i11 - Integer.MIN_VALUE;
                    Object obj = coroutinesRoom$Companion$execute$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i10 = coroutinesRoom$Companion$execute$1.label;
                    if (i10 != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (roomDatabase.isOpenInternal() && roomDatabase.inTransaction()) {
                            return callable.call();
                        }
                        coroutinesRoom$Companion$execute$1.L$0 = callable;
                        coroutinesRoom$Companion$execute$1.label = 1;
                        obj = DBUtil.getCoroutineContext(roomDatabase, z10, coroutinesRoom$Companion$execute$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i10 != 1) {
                            if (i10 == 2) {
                                ResultKt.throwOnFailure(obj);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        callable = (Callable) coroutinesRoom$Companion$execute$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    CoroutinesRoom$Companion$execute$2 coroutinesRoom$Companion$execute$2 = new CoroutinesRoom$Companion$execute$2(callable, null);
                    coroutinesRoom$Companion$execute$1.L$0 = null;
                    coroutinesRoom$Companion$execute$1.label = 2;
                    obj = BuildersKt.withContext((CoroutineContext) obj, coroutinesRoom$Companion$execute$2, coroutinesRoom$Companion$execute$1);
                    return obj != coroutine_suspended ? coroutine_suspended : obj;
                }
            }
            coroutinesRoom$Companion$execute$1 = new CoroutinesRoom$Companion$execute$1(this, continuation);
            Object obj2 = coroutinesRoom$Companion$execute$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i10 = coroutinesRoom$Companion$execute$1.label;
            if (i10 != 0) {
            }
            CoroutinesRoom$Companion$execute$2 coroutinesRoom$Companion$execute$22 = new CoroutinesRoom$Companion$execute$2(callable, null);
            coroutinesRoom$Companion$execute$1.L$0 = null;
            coroutinesRoom$Companion$execute$1.label = 2;
            obj2 = BuildersKt.withContext((CoroutineContext) obj2, coroutinesRoom$Companion$execute$22, coroutinesRoom$Companion$execute$1);
            if (obj2 != coroutine_suspended2) {
            }
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x00cd A[PHI: r1
  0x00cd: PHI (r1v7 java.lang.Object) = (r1v6 java.lang.Object), (r1v1 java.lang.Object) binds: [B:19:0x00ca, B:10:0x0030] A[DONT_GENERATE, DONT_INLINE], RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00cc A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
        @Deprecated(message = "No longer called by generated implementation")
        @JvmStatic
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z10, @Nullable CancellationSignal cancellationSignal, @NotNull Callable<R> callable, @NotNull Continuation<? super R> continuation) {
            CoroutinesRoom$Companion$execute$3 coroutinesRoom$Companion$execute$3;
            Object obj;
            int i10;
            final CancellationSignal cancellationSignal2;
            Callable<R> callable2;
            Object coroutineContext;
            final Job launch$default;
            RoomDatabase roomDatabase2 = roomDatabase;
            if (continuation instanceof CoroutinesRoom$Companion$execute$3) {
                coroutinesRoom$Companion$execute$3 = (CoroutinesRoom$Companion$execute$3) continuation;
                int i11 = coroutinesRoom$Companion$execute$3.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    coroutinesRoom$Companion$execute$3.label = i11 - Integer.MIN_VALUE;
                    obj = coroutinesRoom$Companion$execute$3.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i10 = coroutinesRoom$Companion$execute$3.label;
                    if (i10 != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (roomDatabase.isOpenInternal() && roomDatabase.inTransaction()) {
                            return callable.call();
                        }
                        coroutinesRoom$Companion$execute$3.L$0 = roomDatabase2;
                        cancellationSignal2 = cancellationSignal;
                        coroutinesRoom$Companion$execute$3.L$1 = cancellationSignal2;
                        callable2 = callable;
                        coroutinesRoom$Companion$execute$3.L$2 = callable2;
                        coroutinesRoom$Companion$execute$3.label = 1;
                        coroutineContext = DBUtil.getCoroutineContext(roomDatabase2, z10, coroutinesRoom$Companion$execute$3);
                        if (coroutineContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i10 != 1) {
                            if (i10 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        Callable<R> callable3 = (Callable) coroutinesRoom$Companion$execute$3.L$2;
                        CancellationSignal cancellationSignal3 = (CancellationSignal) coroutinesRoom$Companion$execute$3.L$1;
                        RoomDatabase roomDatabase3 = (RoomDatabase) coroutinesRoom$Companion$execute$3.L$0;
                        ResultKt.throwOnFailure(obj);
                        callable2 = callable3;
                        roomDatabase2 = roomDatabase3;
                        coroutineContext = obj;
                        cancellationSignal2 = cancellationSignal3;
                    }
                    CoroutineContext coroutineContext2 = (CoroutineContext) coroutineContext;
                    coroutinesRoom$Companion$execute$3.L$0 = roomDatabase2;
                    coroutinesRoom$Companion$execute$3.L$1 = cancellationSignal2;
                    coroutinesRoom$Companion$execute$3.L$2 = callable2;
                    coroutinesRoom$Companion$execute$3.L$3 = coroutineContext2;
                    coroutinesRoom$Companion$execute$3.label = 2;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(coroutinesRoom$Companion$execute$3), 1);
                    cancellableContinuationImpl.initCancellability();
                    launch$default = BuildersKt__Builders_commonKt.launch$default(roomDatabase2.getCoroutineScope(), coroutineContext2, null, new CoroutinesRoom$Companion$execute$4$job$1(callable2, cancellableContinuationImpl, null), 2, null);
                    cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.room.CoroutinesRoom$Companion$execute$4$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            CancellationSignal cancellationSignal4 = cancellationSignal2;
                            if (cancellationSignal4 != null) {
                                cancellationSignal4.cancel();
                            }
                            Job.DefaultImpls.cancel$default(launch$default, (CancellationException) null, 1, (Object) null);
                        }
                    });
                    obj = cancellableContinuationImpl.getResult();
                    if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(coroutinesRoom$Companion$execute$3);
                    }
                    return obj != coroutine_suspended ? coroutine_suspended : obj;
                }
            }
            coroutinesRoom$Companion$execute$3 = new CoroutinesRoom$Companion$execute$3(this, continuation);
            obj = coroutinesRoom$Companion$execute$3.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i10 = coroutinesRoom$Companion$execute$3.label;
            if (i10 != 0) {
            }
            CoroutineContext coroutineContext22 = (CoroutineContext) coroutineContext;
            coroutinesRoom$Companion$execute$3.L$0 = roomDatabase2;
            coroutinesRoom$Companion$execute$3.L$1 = cancellationSignal2;
            coroutinesRoom$Companion$execute$3.L$2 = callable2;
            coroutinesRoom$Companion$execute$3.L$3 = coroutineContext22;
            coroutinesRoom$Companion$execute$3.label = 2;
            CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(coroutinesRoom$Companion$execute$3), 1);
            cancellableContinuationImpl2.initCancellability();
            launch$default = BuildersKt__Builders_commonKt.launch$default(roomDatabase2.getCoroutineScope(), coroutineContext22, null, new CoroutinesRoom$Companion$execute$4$job$1(callable2, cancellableContinuationImpl2, null), 2, null);
            cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.room.CoroutinesRoom$Companion$execute$4$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    CancellationSignal cancellationSignal4 = cancellationSignal2;
                    if (cancellationSignal4 != null) {
                        cancellationSignal4.cancel();
                    }
                    Job.DefaultImpls.cancel$default(launch$default, (CancellationException) null, 1, (Object) null);
                }
            });
            obj = cancellableContinuationImpl2.getResult();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            }
            if (obj != coroutine_suspended2) {
            }
        }
    }

    private CoroutinesRoom() {
    }

    @Deprecated(message = "No longer called by generated implementation")
    @JvmStatic
    @NotNull
    public static final <R> Flow<R> createFlow(@NotNull RoomDatabase roomDatabase, boolean z10, @NotNull String[] strArr, @NotNull Callable<R> callable) {
        return INSTANCE.createFlow(roomDatabase, z10, strArr, callable);
    }

    @Deprecated(message = "No longer called by generated implementation")
    @JvmStatic
    @Nullable
    public static final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z10, @Nullable CancellationSignal cancellationSignal, @NotNull Callable<R> callable, @NotNull Continuation<? super R> continuation) {
        return INSTANCE.execute(roomDatabase, z10, cancellationSignal, callable, continuation);
    }

    @Deprecated(message = "No longer called by generated implementation")
    @JvmStatic
    @Nullable
    public static final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z10, @NotNull Callable<R> callable, @NotNull Continuation<? super R> continuation) {
        return INSTANCE.execute(roomDatabase, z10, callable, continuation);
    }
}
