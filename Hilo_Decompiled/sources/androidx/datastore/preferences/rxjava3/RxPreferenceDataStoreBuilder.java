package androidx.datastore.preferences.rxjava3;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreFile;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.rxjava3.RxDataStore;
import io.reactivex.rxjava3.core.h0;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import ke.a;
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

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0005\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0013\u001a\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001b\u001a\u00020\u00002\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u001d¢\u0006\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010 R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010!R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\"R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010#R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010$R \u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00190%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006("}, d2 = {"Landroidx/datastore/preferences/rxjava3/RxPreferenceDataStoreBuilder;", "", "Ljava/util/concurrent/Callable;", "Ljava/io/File;", "produceFile", "<init>", "(Ljava/util/concurrent/Callable;)V", "Landroid/content/Context;", "context", "", "name", "(Landroid/content/Context;Ljava/lang/String;)V", "Lio/reactivex/rxjava3/core/h0;", "ioScheduler", "setIoScheduler", "(Lio/reactivex/rxjava3/core/h0;)Landroidx/datastore/preferences/rxjava3/RxPreferenceDataStoreBuilder;", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "Landroidx/datastore/preferences/core/Preferences;", "corruptionHandler", "setCorruptionHandler", "(Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;)Landroidx/datastore/preferences/rxjava3/RxPreferenceDataStoreBuilder;", "Landroidx/datastore/rxjava3/a;", "rxDataMigration", "addRxDataMigration", "(Landroidx/datastore/rxjava3/a;)Landroidx/datastore/preferences/rxjava3/RxPreferenceDataStoreBuilder;", "Landroidx/datastore/core/DataMigration;", "dataMigration", "addDataMigration", "(Landroidx/datastore/core/DataMigration;)Landroidx/datastore/preferences/rxjava3/RxPreferenceDataStoreBuilder;", "Landroidx/datastore/rxjava3/RxDataStore;", "build", "()Landroidx/datastore/rxjava3/RxDataStore;", "Ljava/util/concurrent/Callable;", "Landroid/content/Context;", "Ljava/lang/String;", "Lio/reactivex/rxjava3/core/h0;", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "", "dataMigrations", "Ljava/util/List;", "datastore-preferences-rxjava3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SuppressLint({"TopLevelBuilder"})
@SourceDebugExtension({"SMAP\nRxPreferenceDataStoreBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RxPreferenceDataStoreBuilder.kt\nandroidx/datastore/preferences/rxjava3/RxPreferenceDataStoreBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,182:1\n1#2:183\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class RxPreferenceDataStoreBuilder {

    @Nullable
    private Context context;

    @Nullable
    private ReplaceFileCorruptionHandler<Preferences> corruptionHandler;

    @NotNull
    private final List<DataMigration<Preferences>> dataMigrations;

    @NotNull
    private h0 ioScheduler;

    @Nullable
    private String name;

    @Nullable
    private Callable<File> produceFile;

    public RxPreferenceDataStoreBuilder(@NotNull Callable<File> produceFile) {
        Intrinsics.checkNotNullParameter(produceFile, "produceFile");
        h0 b10 = a.b();
        Intrinsics.checkNotNullExpressionValue(b10, "io()");
        this.ioScheduler = b10;
        this.dataMigrations = new ArrayList();
        this.produceFile = produceFile;
    }

    @NotNull
    public final RxPreferenceDataStoreBuilder addDataMigration(@NotNull DataMigration<Preferences> dataMigration) {
        Intrinsics.checkNotNullParameter(dataMigration, "dataMigration");
        this.dataMigrations.add(dataMigration);
        return this;
    }

    @NotNull
    public final RxPreferenceDataStoreBuilder addRxDataMigration(@NotNull androidx.datastore.rxjava3.a rxDataMigration) {
        Intrinsics.checkNotNullParameter(rxDataMigration, "rxDataMigration");
        this.dataMigrations.add(new DataMigrationFromRxDataMigration(rxDataMigration));
        return this;
    }

    @NotNull
    public final RxDataStore<Preferences> build() {
        CompletableJob Job$default;
        DataStore<Preferences> create;
        CoroutineDispatcher asCoroutineDispatcher = RxSchedulerKt.asCoroutineDispatcher(this.ioScheduler);
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(asCoroutineDispatcher.plus(Job$default));
        final Callable<File> callable = this.produceFile;
        final Context context = this.context;
        final String str = this.name;
        if (callable != null) {
            create = PreferenceDataStoreFactory.INSTANCE.create(this.corruptionHandler, this.dataMigrations, CoroutineScope, new Function0<File>() { // from class: androidx.datastore.preferences.rxjava3.RxPreferenceDataStoreBuilder$build$delegate$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final File invoke() {
                    File call = callable.call();
                    Intrinsics.checkNotNullExpressionValue(call, "produceFile.call()");
                    return call;
                }
            });
        } else if (context != null && str != null) {
            create = PreferenceDataStoreFactory.INSTANCE.create(this.corruptionHandler, this.dataMigrations, CoroutineScope, new Function0<File>() { // from class: androidx.datastore.preferences.rxjava3.RxPreferenceDataStoreBuilder$build$delegate$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final File invoke() {
                    return PreferenceDataStoreFile.preferencesDataStoreFile(context, str);
                }
            });
        } else {
            throw new IllegalStateException("Either produceFile or context and name must be set. This should never happen.");
        }
        return RxDataStore.INSTANCE.create(create, CoroutineScope);
    }

    @NotNull
    public final RxPreferenceDataStoreBuilder setCorruptionHandler(@NotNull ReplaceFileCorruptionHandler<Preferences> corruptionHandler) {
        Intrinsics.checkNotNullParameter(corruptionHandler, "corruptionHandler");
        this.corruptionHandler = corruptionHandler;
        return this;
    }

    @NotNull
    public final RxPreferenceDataStoreBuilder setIoScheduler(@NotNull h0 ioScheduler) {
        Intrinsics.checkNotNullParameter(ioScheduler, "ioScheduler");
        this.ioScheduler = ioScheduler;
        return this;
    }

    public RxPreferenceDataStoreBuilder(@NotNull Context context, @NotNull String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        h0 b10 = a.b();
        Intrinsics.checkNotNullExpressionValue(b10, "io()");
        this.ioScheduler = b10;
        this.dataMigrations = new ArrayList();
        this.context = context;
        this.name = name;
    }
}
