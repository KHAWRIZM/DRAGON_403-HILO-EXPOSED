package androidx.datastore.rxjava3;

import androidx.annotation.RestrictTo;
import androidx.datastore.core.DataStore;
import io.reactivex.rxjava3.core.h;
import io.reactivex.rxjava3.core.i0;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.rx3.RxConvertKt;
import nd.c;
import org.jetbrains.annotations.NotNull;
import pd.o;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\u001dB\u001f\b\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u0016H\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001c¨\u0006\u001e"}, d2 = {"Landroidx/datastore/rxjava3/RxDataStore;", "", "T", "Lnd/c;", "Landroidx/datastore/core/DataStore;", "delegateDs", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Landroidx/datastore/core/DataStore;Lkotlinx/coroutines/CoroutineScope;)V", "", "dispose", "()V", "", "isDisposed", "()Z", "Lio/reactivex/rxjava3/core/b;", "shutdownComplete", "()Lio/reactivex/rxjava3/core/b;", "Lio/reactivex/rxjava3/core/h;", "data", "()Lio/reactivex/rxjava3/core/h;", "Lpd/o;", "Lio/reactivex/rxjava3/core/i0;", "transform", "updateDataAsync", "(Lpd/o;)Lio/reactivex/rxjava3/core/i0;", "Landroidx/datastore/core/DataStore;", "Lkotlinx/coroutines/CoroutineScope;", "Companion", "datastore-rxjava3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class RxDataStore<T> implements c {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final DataStore<T> delegateDs;

    @NotNull
    private final CoroutineScope scope;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Landroidx/datastore/rxjava3/RxDataStore$Companion;", "", "()V", "create", "Landroidx/datastore/rxjava3/RxDataStore;", "T", "delegateDs", "Landroidx/datastore/core/DataStore;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "datastore-rxjava3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public final <T> RxDataStore<T> create(@NotNull DataStore<T> delegateDs, @NotNull CoroutineScope scope) {
            Intrinsics.checkNotNullParameter(delegateDs, "delegateDs");
            Intrinsics.checkNotNullParameter(scope, "scope");
            return new RxDataStore<>(delegateDs, scope, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ RxDataStore(DataStore dataStore, CoroutineScope coroutineScope, DefaultConstructorMarker defaultConstructorMarker) {
        this(dataStore, coroutineScope);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final h<T> data() {
        return RxConvertKt.asFlowable(this.delegateDs.getData(), this.scope.getCoroutineContext());
    }

    @Override // nd.c
    public void dispose() {
        Job.DefaultImpls.cancel$default(JobKt.getJob(this.scope.getCoroutineContext()), (CancellationException) null, 1, (Object) null);
    }

    @Override // nd.c
    public boolean isDisposed() {
        return !JobKt.getJob(this.scope.getCoroutineContext()).isActive();
    }

    @NotNull
    public final io.reactivex.rxjava3.core.b shutdownComplete() {
        return RxConvertKt.asCompletable(JobKt.getJob(this.scope.getCoroutineContext()), this.scope.getCoroutineContext().minusKey(Job.INSTANCE));
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final i0<T> updateDataAsync(@NotNull o transform) {
        Deferred async$default;
        Intrinsics.checkNotNullParameter(transform, "transform");
        async$default = BuildersKt__Builders_commonKt.async$default(this.scope, SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null), null, new RxDataStore$updateDataAsync$1(this, transform, null), 2, null);
        return RxConvertKt.asSingle(async$default, this.scope.getCoroutineContext().minusKey(Job.INSTANCE));
    }

    private RxDataStore(DataStore<T> dataStore, CoroutineScope coroutineScope) {
        this.delegateDs = dataStore;
        this.scope = coroutineScope;
    }
}
