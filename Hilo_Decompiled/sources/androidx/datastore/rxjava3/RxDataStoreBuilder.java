package androidx.datastore.rxjava3;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.datastore.DataStoreFile;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.Serializer;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import io.reactivex.rxjava3.core.h0;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.rx3.RxSchedulerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B%\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tB'\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\u000eJ\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001f¢\u0006\u0004\b \u0010!R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\"R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010&R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010'R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010(R \u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006,"}, d2 = {"Landroidx/datastore/rxjava3/RxDataStoreBuilder;", "", "T", "Ljava/util/concurrent/Callable;", "Ljava/io/File;", "produceFile", "Landroidx/datastore/core/Serializer;", "serializer", "<init>", "(Ljava/util/concurrent/Callable;Landroidx/datastore/core/Serializer;)V", "Landroid/content/Context;", "context", "", "fileName", "(Landroid/content/Context;Ljava/lang/String;Landroidx/datastore/core/Serializer;)V", "Lio/reactivex/rxjava3/core/h0;", "ioScheduler", "setIoScheduler", "(Lio/reactivex/rxjava3/core/h0;)Landroidx/datastore/rxjava3/RxDataStoreBuilder;", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "corruptionHandler", "setCorruptionHandler", "(Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;)Landroidx/datastore/rxjava3/RxDataStoreBuilder;", "Landroidx/datastore/rxjava3/a;", "rxDataMigration", "addRxDataMigration", "(Landroidx/datastore/rxjava3/a;)Landroidx/datastore/rxjava3/RxDataStoreBuilder;", "Landroidx/datastore/core/DataMigration;", "dataMigration", "addDataMigration", "(Landroidx/datastore/core/DataMigration;)Landroidx/datastore/rxjava3/RxDataStoreBuilder;", "Landroidx/datastore/rxjava3/RxDataStore;", "build", "()Landroidx/datastore/rxjava3/RxDataStore;", "Ljava/util/concurrent/Callable;", "Landroid/content/Context;", "name", "Ljava/lang/String;", "Landroidx/datastore/core/Serializer;", "Lio/reactivex/rxjava3/core/h0;", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "", "dataMigrations", "Ljava/util/List;", "datastore-rxjava3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SuppressLint({"TopLevelBuilder"})
@SourceDebugExtension({"SMAP\nRxDataStoreBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RxDataStoreBuilder.kt\nandroidx/datastore/rxjava3/RxDataStoreBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,183:1\n1#2:184\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class RxDataStoreBuilder<T> {

    @Nullable
    private Context context;

    @Nullable
    private ReplaceFileCorruptionHandler<T> corruptionHandler;

    @NotNull
    private final List<DataMigration<T>> dataMigrations;

    @NotNull
    private h0 ioScheduler;

    @Nullable
    private String name;

    @Nullable
    private Callable<File> produceFile;

    @Nullable
    private Serializer<T> serializer;

    public RxDataStoreBuilder(@NotNull Callable<File> produceFile, @NotNull Serializer<T> serializer) {
        Intrinsics.checkNotNullParameter(produceFile, "produceFile");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        h0 b10 = ke.a.b();
        Intrinsics.checkNotNullExpressionValue(b10, "io()");
        this.ioScheduler = b10;
        this.dataMigrations = new ArrayList();
        this.produceFile = produceFile;
        this.serializer = serializer;
    }

    @NotNull
    public final RxDataStoreBuilder<T> addDataMigration(@NotNull DataMigration<T> dataMigration) {
        Intrinsics.checkNotNullParameter(dataMigration, "dataMigration");
        this.dataMigrations.add(dataMigration);
        return this;
    }

    @NotNull
    public final RxDataStoreBuilder<T> addRxDataMigration(@NotNull a rxDataMigration) {
        Intrinsics.checkNotNullParameter(rxDataMigration, "rxDataMigration");
        this.dataMigrations.add(new DataMigrationFromRxDataMigration(rxDataMigration));
        return this;
    }

    @NotNull
    public final RxDataStore<T> build() {
        CompletableJob Job$default;
        DataStore<T> create;
        CoroutineDispatcher asCoroutineDispatcher = RxSchedulerKt.asCoroutineDispatcher(this.ioScheduler);
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(asCoroutineDispatcher.plus(Job$default));
        if (this.produceFile != null) {
            DataStoreFactory dataStoreFactory = DataStoreFactory.INSTANCE;
            Serializer<T> serializer = this.serializer;
            Intrinsics.checkNotNull(serializer);
            create = dataStoreFactory.create(serializer, this.corruptionHandler, this.dataMigrations, CoroutineScope, new Function0<File>(this) { // from class: androidx.datastore.rxjava3.RxDataStoreBuilder$build$delegateDs$1
                final /* synthetic */ RxDataStoreBuilder<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final File invoke() {
                    Callable callable;
                    callable = ((RxDataStoreBuilder) this.this$0).produceFile;
                    Intrinsics.checkNotNull(callable);
                    Object call = callable.call();
                    Intrinsics.checkNotNullExpressionValue(call, "produceFile!!.call()");
                    return (File) call;
                }
            });
        } else if (this.context != null && this.name != null) {
            DataStoreFactory dataStoreFactory2 = DataStoreFactory.INSTANCE;
            Serializer<T> serializer2 = this.serializer;
            Intrinsics.checkNotNull(serializer2);
            create = dataStoreFactory2.create(serializer2, this.corruptionHandler, this.dataMigrations, CoroutineScope, new Function0<File>(this) { // from class: androidx.datastore.rxjava3.RxDataStoreBuilder$build$delegateDs$2
                final /* synthetic */ RxDataStoreBuilder<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final File invoke() {
                    Context context;
                    String str;
                    context = ((RxDataStoreBuilder) this.this$0).context;
                    Intrinsics.checkNotNull(context);
                    str = ((RxDataStoreBuilder) this.this$0).name;
                    Intrinsics.checkNotNull(str);
                    return DataStoreFile.dataStoreFile(context, str);
                }
            });
        } else {
            throw new IllegalStateException("Either produceFile or context and name must be set. This should never happen.");
        }
        return RxDataStore.INSTANCE.create(create, CoroutineScope);
    }

    @NotNull
    public final RxDataStoreBuilder<T> setCorruptionHandler(@NotNull ReplaceFileCorruptionHandler<T> corruptionHandler) {
        Intrinsics.checkNotNullParameter(corruptionHandler, "corruptionHandler");
        this.corruptionHandler = corruptionHandler;
        return this;
    }

    @NotNull
    public final RxDataStoreBuilder<T> setIoScheduler(@NotNull h0 ioScheduler) {
        Intrinsics.checkNotNullParameter(ioScheduler, "ioScheduler");
        this.ioScheduler = ioScheduler;
        return this;
    }

    public RxDataStoreBuilder(@NotNull Context context, @NotNull String fileName, @NotNull Serializer<T> serializer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        h0 b10 = ke.a.b();
        Intrinsics.checkNotNullExpressionValue(b10, "io()");
        this.ioScheduler = b10;
        this.dataMigrations = new ArrayList();
        this.context = context;
        this.name = fileName;
        this.serializer = serializer;
    }
}
