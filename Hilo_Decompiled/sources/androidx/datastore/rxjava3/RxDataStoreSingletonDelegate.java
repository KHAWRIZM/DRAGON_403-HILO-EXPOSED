package androidx.datastore.rxjava3;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.Serializer;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import io.reactivex.rxjava3.core.h0;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003BY\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n\u0012 \b\u0002\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\r0\f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J*\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0014\u001a\u00020\u00042\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001aR\u001c\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001bR,\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Landroidx/datastore/rxjava3/RxDataStoreSingletonDelegate;", "", "T", "Lkotlin/properties/ReadOnlyProperty;", "Landroid/content/Context;", "Landroidx/datastore/rxjava3/RxDataStore;", "", "fileName", "Landroidx/datastore/core/Serializer;", "serializer", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "corruptionHandler", "Lkotlin/Function1;", "", "Landroidx/datastore/core/DataMigration;", "produceMigrations", "Lio/reactivex/rxjava3/core/h0;", "scheduler", "<init>", "(Ljava/lang/String;Landroidx/datastore/core/Serializer;Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;Lkotlin/jvm/functions/Function1;Lio/reactivex/rxjava3/core/h0;)V", "thisRef", "Lkotlin/reflect/KProperty;", "property", "getValue", "(Landroid/content/Context;Lkotlin/reflect/KProperty;)Landroidx/datastore/rxjava3/RxDataStore;", "Ljava/lang/String;", "Landroidx/datastore/core/Serializer;", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "Lkotlin/jvm/functions/Function1;", "Lio/reactivex/rxjava3/core/h0;", "lock", "Ljava/lang/Object;", "INSTANCE", "Landroidx/datastore/rxjava3/RxDataStore;", "datastore-rxjava3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRxDataStoreDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RxDataStoreDelegate.kt\nandroidx/datastore/rxjava3/RxDataStoreSingletonDelegate\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,117:1\n1855#2,2:118\n1#3:120\n*S KotlinDebug\n*F\n+ 1 RxDataStoreDelegate.kt\nandroidx/datastore/rxjava3/RxDataStoreSingletonDelegate\n*L\n106#1:118,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class RxDataStoreSingletonDelegate<T> implements ReadOnlyProperty<Context, RxDataStore<T>> {

    @GuardedBy("lock")
    @Nullable
    private volatile RxDataStore<T> INSTANCE;

    @Nullable
    private final ReplaceFileCorruptionHandler<T> corruptionHandler;

    @NotNull
    private final String fileName;

    @NotNull
    private final Object lock;

    @NotNull
    private final Function1<Context, List<DataMigration<T>>> produceMigrations;

    @NotNull
    private final h0 scheduler;

    @NotNull
    private final Serializer<T> serializer;

    /* JADX WARN: Multi-variable type inference failed */
    public RxDataStoreSingletonDelegate(@NotNull String fileName, @NotNull Serializer<T> serializer, @Nullable ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, @NotNull Function1<? super Context, ? extends List<? extends DataMigration<T>>> produceMigrations, @NotNull h0 scheduler) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(produceMigrations, "produceMigrations");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        this.fileName = fileName;
        this.serializer = serializer;
        this.corruptionHandler = replaceFileCorruptionHandler;
        this.produceMigrations = produceMigrations;
        this.scheduler = scheduler;
        this.lock = new Object();
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public /* bridge */ /* synthetic */ Object getValue(Context context, KProperty kProperty) {
        return getValue2(context, (KProperty<?>) kProperty);
    }

    @NotNull
    /* renamed from: getValue, reason: avoid collision after fix types in other method */
    public RxDataStore<T> getValue2(@NotNull Context thisRef, @NotNull KProperty<?> property) {
        RxDataStore<T> rxDataStore;
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        RxDataStore<T> rxDataStore2 = this.INSTANCE;
        if (rxDataStore2 != null) {
            return rxDataStore2;
        }
        synchronized (this.lock) {
            try {
                if (this.INSTANCE == null) {
                    Context applicationContext = thisRef.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
                    RxDataStoreBuilder rxDataStoreBuilder = new RxDataStoreBuilder(applicationContext, this.fileName, this.serializer);
                    rxDataStoreBuilder.setIoScheduler(this.scheduler);
                    Iterator<T> it = this.produceMigrations.invoke(applicationContext).iterator();
                    while (it.hasNext()) {
                        rxDataStoreBuilder.addDataMigration((DataMigration) it.next());
                    }
                    ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler = this.corruptionHandler;
                    if (replaceFileCorruptionHandler != null) {
                        rxDataStoreBuilder.setCorruptionHandler(replaceFileCorruptionHandler);
                    }
                    this.INSTANCE = rxDataStoreBuilder.build();
                }
                rxDataStore = this.INSTANCE;
                Intrinsics.checkNotNull(rxDataStore);
            } catch (Throwable th) {
                throw th;
            }
        }
        return rxDataStore;
    }

    public /* synthetic */ RxDataStoreSingletonDelegate(String str, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, Function1 function1, h0 h0Var, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, serializer, replaceFileCorruptionHandler, (i10 & 8) != 0 ? new Function1<Context, List<? extends DataMigration<T>>>() { // from class: androidx.datastore.rxjava3.RxDataStoreSingletonDelegate.1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final List<DataMigration<T>> invoke(@NotNull Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return CollectionsKt.emptyList();
            }
        } : function1, h0Var);
    }
}
