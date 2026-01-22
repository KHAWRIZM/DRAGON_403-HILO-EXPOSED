package androidx.room;

import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u001a\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001bH\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00018\u0000H¦@¢\u0006\u0002\u0010\u001cJ\b\u0010\u001f\u001a\u00020\u001bH\u0014J\b\u0010 \u001a\u00020\u001bH\u0014R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0002!\"¨\u0006#"}, d2 = {"Landroidx/room/RoomTrackingLiveData;", "T", "Landroidx/lifecycle/LiveData;", "database", "Landroidx/room/RoomDatabase;", "container", "Landroidx/room/InvalidationLiveDataContainer;", "inTransaction", "", "tableNames", "", "", "<init>", "(Landroidx/room/RoomDatabase;Landroidx/room/InvalidationLiveDataContainer;Z[Ljava/lang/String;)V", "getDatabase", "()Landroidx/room/RoomDatabase;", "getInTransaction", "()Z", "observer", "Landroidx/room/InvalidationTracker$Observer;", "invalid", "Ljava/util/concurrent/atomic/AtomicBoolean;", "computing", "registeredObserver", "launchContext", "Lkotlin/coroutines/CoroutineContext;", "refresh", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidated", "compute", "onActive", "onInactive", "Landroidx/room/RoomCallableTrackingLiveData;", "Landroidx/room/RoomLambdaTrackingLiveData;", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class RoomTrackingLiveData<T> extends LiveData<T> {

    @NotNull
    private final AtomicBoolean computing;

    @NotNull
    private final InvalidationLiveDataContainer container;

    @NotNull
    private final RoomDatabase database;
    private final boolean inTransaction;

    @NotNull
    private final AtomicBoolean invalid;

    @NotNull
    private final CoroutineContext launchContext;

    @NotNull
    private final InvalidationTracker.Observer observer;

    @NotNull
    private final AtomicBoolean registeredObserver;

    public /* synthetic */ RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z10, String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(roomDatabase, invalidationLiveDataContainer, z10, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidated() {
        boolean hasActiveObservers = hasActiveObservers();
        if (this.invalid.compareAndSet(false, true) && hasActiveObservers) {
            BuildersKt__Builders_commonKt.launch$default(this.database.getCoroutineScope(), this.launchContext, null, new RoomTrackingLiveData$invalidated$1(this, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0069 A[Catch: all -> 0x0033, Exception -> 0x0035, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x0035, blocks: (B:12:0x002c, B:17:0x0069), top: B:11:0x002c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0083 A[Catch: all -> 0x0033, TRY_LEAVE, TryCatch #0 {all -> 0x0033, blocks: (B:12:0x002c, B:15:0x0061, B:17:0x0069, B:26:0x0083, B:39:0x0079, B:40:0x0080), top: B:7:0x0022, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x005e -> B:14:0x0061). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0092 -> B:25:0x0094). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refresh(Continuation<? super Unit> continuation) {
        RoomTrackingLiveData$refresh$1 roomTrackingLiveData$refresh$1;
        int i10;
        RoomTrackingLiveData roomTrackingLiveData;
        RoomTrackingLiveData<T> roomTrackingLiveData2;
        RoomTrackingLiveData<T> roomTrackingLiveData3;
        try {
            if (continuation instanceof RoomTrackingLiveData$refresh$1) {
                roomTrackingLiveData$refresh$1 = (RoomTrackingLiveData$refresh$1) continuation;
                int i11 = roomTrackingLiveData$refresh$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    roomTrackingLiveData$refresh$1.label = i11 - Integer.MIN_VALUE;
                    Object obj = roomTrackingLiveData$refresh$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i10 = roomTrackingLiveData$refresh$1.label;
                    if (i10 == 0) {
                        if (i10 == 1) {
                            int i12 = roomTrackingLiveData$refresh$1.I$0;
                            roomTrackingLiveData = (RoomTrackingLiveData) roomTrackingLiveData$refresh$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                Object obj2 = obj;
                                int i13 = i12;
                                roomTrackingLiveData = roomTrackingLiveData;
                                while (roomTrackingLiveData.invalid.compareAndSet(true, false)) {
                                    roomTrackingLiveData$refresh$1.L$0 = roomTrackingLiveData;
                                    roomTrackingLiveData$refresh$1.I$0 = 1;
                                    roomTrackingLiveData$refresh$1.label = 1;
                                    Object compute = roomTrackingLiveData.compute(roomTrackingLiveData$refresh$1);
                                    if (compute == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj2 = compute;
                                    i13 = 1;
                                }
                                if (i13 != 0) {
                                    roomTrackingLiveData.postValue(obj2);
                                }
                                if (i13 == 0 && roomTrackingLiveData3.invalid.get()) {
                                    roomTrackingLiveData2 = roomTrackingLiveData3;
                                    if (!roomTrackingLiveData2.computing.compareAndSet(false, true)) {
                                        obj2 = null;
                                        roomTrackingLiveData = roomTrackingLiveData2;
                                        i13 = 0;
                                        while (roomTrackingLiveData.invalid.compareAndSet(true, false)) {
                                        }
                                        if (i13 != 0) {
                                        }
                                        if (i13 == 0) {
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    roomTrackingLiveData3 = roomTrackingLiveData2;
                                    i13 = 0;
                                    if (i13 == 0) {
                                    }
                                    return Unit.INSTANCE;
                                }
                                return Unit.INSTANCE;
                            } catch (Exception e10) {
                                throw new RuntimeException("Exception while computing database live data.", e10);
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    if (this.registeredObserver.compareAndSet(false, true)) {
                        this.database.getInvalidationTracker().addWeakObserver(this.observer);
                    }
                    roomTrackingLiveData2 = this;
                    if (!roomTrackingLiveData2.computing.compareAndSet(false, true)) {
                    }
                }
            }
            if (i10 == 0) {
            }
        } finally {
            roomTrackingLiveData.computing.set(false);
        }
        roomTrackingLiveData$refresh$1 = new RoomTrackingLiveData$refresh$1(this, continuation);
        Object obj3 = roomTrackingLiveData$refresh$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = roomTrackingLiveData$refresh$1.label;
    }

    @Nullable
    public abstract Object compute(@NotNull Continuation<? super T> continuation);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final RoomDatabase getDatabase() {
        return this.database;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean getInTransaction() {
        return this.inTransaction;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        this.container.onActive(this);
        BuildersKt__Builders_commonKt.launch$default(this.database.getCoroutineScope(), this.launchContext, null, new RoomTrackingLiveData$onActive$1(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        this.container.onInactive(this);
    }

    private RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z10, String[] strArr) {
        CoroutineContext coroutineContext;
        this.database = roomDatabase;
        this.container = invalidationLiveDataContainer;
        this.inTransaction = z10;
        this.observer = new RoomTrackingLiveData$observer$1(strArr, this);
        this.invalid = new AtomicBoolean(true);
        this.computing = new AtomicBoolean(false);
        this.registeredObserver = new AtomicBoolean(false);
        if (!roomDatabase.inCompatibilityMode$room_runtime_release()) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        } else if (z10) {
            coroutineContext = roomDatabase.getTransactionContext$room_runtime_release();
        } else {
            coroutineContext = roomDatabase.getQueryContext();
        }
        this.launchContext = coroutineContext;
    }
}
