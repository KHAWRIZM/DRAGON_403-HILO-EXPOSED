package androidx.datastore.rxjava3;

import androidx.datastore.core.DataMigration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\r\u001a\u00020\fH\u0096@¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/datastore/rxjava3/DataMigrationFromRxDataMigration;", "T", "Landroidx/datastore/core/DataMigration;", "Landroidx/datastore/rxjava3/a;", "migration", "<init>", "(Landroidx/datastore/rxjava3/a;)V", "currentData", "", "shouldMigrate", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "migrate", "", "cleanUp", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/datastore/rxjava3/a;", "datastore-rxjava3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class DataMigrationFromRxDataMigration<T> implements DataMigration<T> {

    @NotNull
    private final a migration;

    public DataMigrationFromRxDataMigration(@NotNull a migration) {
        Intrinsics.checkNotNullParameter(migration, "migration");
    }

    @Override // androidx.datastore.core.DataMigration
    @Nullable
    public Object cleanUp(@NotNull Continuation<? super Unit> continuation) {
        throw null;
    }

    @Override // androidx.datastore.core.DataMigration
    @Nullable
    public Object migrate(T t10, @NotNull Continuation<? super T> continuation) {
        throw null;
    }

    @Override // androidx.datastore.core.DataMigration
    @Nullable
    public Object shouldMigrate(T t10, @NotNull Continuation<? super Boolean> continuation) {
        throw null;
    }
}
