package androidx.room;

import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00008\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a<\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\"\u0010\u0003\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086@¢\u0006\u0002\u0010\b\u001a<\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\"\u0010\u0003\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086@¢\u0006\u0002\u0010\b\u001a$\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0000\u001a\u0014\u0010\u0010\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a\u0014\u0010\u0013\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¨\u0006\u0014"}, d2 = {"useReaderConnection", "R", "Landroidx/room/RoomDatabase;", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function2;", "Landroidx/room/Transactor;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/room/RoomDatabase;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "useWriterConnection", "validateMigrationsNotRequired", "", "migrationStartAndEndVersions", "", "", "migrationsNotRequiredFrom", "validateAutoMigrations", "configuration", "Landroidx/room/DatabaseConfiguration;", "validateTypeConverters", "room-runtime_release"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/room/RoomDatabaseKt")
@SourceDebugExtension({"SMAP\nRoomDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomDatabase.kt\nandroidx/room/RoomDatabaseKt__RoomDatabaseKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,596:1\n1#2:597\n216#3,2:598\n*S KotlinDebug\n*F\n+ 1 RoomDatabase.kt\nandroidx/room/RoomDatabaseKt__RoomDatabaseKt\n*L\n565#1:598,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final /* synthetic */ class RoomDatabaseKt__RoomDatabaseKt {
    @Nullable
    public static final <R> Object useReaderConnection(@NotNull RoomDatabase roomDatabase, @NotNull Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
        return BuildersKt.withContext(roomDatabase.getCoroutineScope().getCoroutineContext(), new RoomDatabaseKt__RoomDatabaseKt$useReaderConnection$2(roomDatabase, function2, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R> Object useWriterConnection(@NotNull RoomDatabase roomDatabase, @NotNull Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
        RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1 roomDatabaseKt__RoomDatabaseKt$useWriterConnection$1;
        int i10;
        if (continuation instanceof RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1) {
            roomDatabaseKt__RoomDatabaseKt$useWriterConnection$1 = (RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1) continuation;
            int i11 = roomDatabaseKt__RoomDatabaseKt$useWriterConnection$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                roomDatabaseKt__RoomDatabaseKt$useWriterConnection$1.label = i11 - Integer.MIN_VALUE;
                Object obj = roomDatabaseKt__RoomDatabaseKt$useWriterConnection$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i10 = roomDatabaseKt__RoomDatabaseKt$useWriterConnection$1.label;
                if (i10 == 0) {
                    if (i10 == 1) {
                        roomDatabase = (RoomDatabase) roomDatabaseKt__RoomDatabaseKt$useWriterConnection$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext coroutineContext = roomDatabase.getCoroutineScope().getCoroutineContext();
                    RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2 roomDatabaseKt__RoomDatabaseKt$useWriterConnection$2 = new RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$2(roomDatabase, function2, null);
                    roomDatabaseKt__RoomDatabaseKt$useWriterConnection$1.L$0 = roomDatabase;
                    roomDatabaseKt__RoomDatabaseKt$useWriterConnection$1.label = 1;
                    obj = BuildersKt.withContext(coroutineContext, roomDatabaseKt__RoomDatabaseKt$useWriterConnection$2, roomDatabaseKt__RoomDatabaseKt$useWriterConnection$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                roomDatabase.getInvalidationTracker().refreshAsync();
                return obj;
            }
        }
        roomDatabaseKt__RoomDatabaseKt$useWriterConnection$1 = new RoomDatabaseKt__RoomDatabaseKt$useWriterConnection$1(continuation);
        Object obj2 = roomDatabaseKt__RoomDatabaseKt$useWriterConnection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = roomDatabaseKt__RoomDatabaseKt$useWriterConnection$1.label;
        if (i10 == 0) {
        }
        roomDatabase.getInvalidationTracker().refreshAsync();
        return obj2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0098, code lost:
    
        throw new java.lang.IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void validateAutoMigrations(@NotNull RoomDatabase roomDatabase, @NotNull DatabaseConfiguration configuration) {
        Intrinsics.checkNotNullParameter(roomDatabase, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set<KClass<? extends AutoMigrationSpec>> requiredAutoMigrationSpecClasses = roomDatabase.getRequiredAutoMigrationSpecClasses();
        int size = requiredAutoMigrationSpecClasses.size();
        boolean[] zArr = new boolean[size];
        Iterator<KClass<? extends AutoMigrationSpec>> it = requiredAutoMigrationSpecClasses.iterator();
        while (true) {
            int i10 = -1;
            if (it.hasNext()) {
                KClass<? extends AutoMigrationSpec> next = it.next();
                int size2 = configuration.autoMigrationSpecs.size() - 1;
                if (size2 >= 0) {
                    while (true) {
                        int i11 = size2 - 1;
                        if (next.isInstance(configuration.autoMigrationSpecs.get(size2))) {
                            zArr[size2] = true;
                            i10 = size2;
                            break;
                        } else if (i11 < 0) {
                            break;
                        } else {
                            size2 = i11;
                        }
                    }
                }
                if (i10 >= 0) {
                    linkedHashMap.put(next, configuration.autoMigrationSpecs.get(i10));
                } else {
                    throw new IllegalArgumentException(("A required auto migration spec (" + next.getQualifiedName() + ") is missing in the database configuration.").toString());
                }
            } else {
                int size3 = configuration.autoMigrationSpecs.size() - 1;
                if (size3 >= 0) {
                    while (true) {
                        int i12 = size3 - 1;
                        if (size3 >= size || !zArr[size3]) {
                            break;
                        } else if (i12 < 0) {
                            break;
                        } else {
                            size3 = i12;
                        }
                    }
                }
                for (Migration migration : roomDatabase.createAutoMigrations(linkedHashMap)) {
                    if (!configuration.migrationContainer.contains(migration.startVersion, migration.endVersion)) {
                        configuration.migrationContainer.addMigration(migration);
                    }
                }
                return;
            }
        }
    }

    public static final void validateMigrationsNotRequired(@NotNull Set<Integer> migrationStartAndEndVersions, @NotNull Set<Integer> migrationsNotRequiredFrom) {
        Intrinsics.checkNotNullParameter(migrationStartAndEndVersions, "migrationStartAndEndVersions");
        Intrinsics.checkNotNullParameter(migrationsNotRequiredFrom, "migrationsNotRequiredFrom");
        if (!migrationStartAndEndVersions.isEmpty()) {
            Iterator<Integer> it = migrationStartAndEndVersions.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                if (migrationsNotRequiredFrom.contains(Integer.valueOf(intValue))) {
                    throw new IllegalArgumentException(("Inconsistency detected. A Migration was supplied to addMigration() that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(). Start version is: " + intValue).toString());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0068 A[LOOP:1: B:5:0x0039->B:17:0x0068, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0072 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void validateTypeConverters(@NotNull RoomDatabase roomDatabase, @NotNull DatabaseConfiguration configuration) {
        Intrinsics.checkNotNullParameter(roomDatabase, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Map<KClass<?>, List<KClass<?>>> requiredTypeConverterClassesMap$room_runtime_release = roomDatabase.getRequiredTypeConverterClassesMap$room_runtime_release();
        boolean[] zArr = new boolean[requiredTypeConverterClassesMap$room_runtime_release.size()];
        for (Map.Entry<KClass<?>, List<KClass<?>>> entry : requiredTypeConverterClassesMap$room_runtime_release.entrySet()) {
            KClass<?> key = entry.getKey();
            for (KClass<?> kClass : entry.getValue()) {
                int size = configuration.typeConverters.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i10 = size - 1;
                        if (kClass.isInstance(configuration.typeConverters.get(size))) {
                            zArr[size] = true;
                            break;
                        } else if (i10 < 0) {
                            break;
                        } else {
                            size = i10;
                        }
                    }
                    if (size < 0) {
                        roomDatabase.addTypeConverter$room_runtime_release(kClass, configuration.typeConverters.get(size));
                    } else {
                        throw new IllegalArgumentException(("A required type converter (" + kClass.getQualifiedName() + ") for " + key.getQualifiedName() + " is missing in the database configuration.").toString());
                    }
                }
                size = -1;
                if (size < 0) {
                }
            }
        }
        int size2 = configuration.typeConverters.size() - 1;
        if (size2 < 0) {
            return;
        }
        while (true) {
            int i11 = size2 - 1;
            if (zArr[size2]) {
                if (i11 >= 0) {
                    size2 = i11;
                } else {
                    return;
                }
            } else {
                throw new IllegalArgumentException("Unexpected type converter " + configuration.typeConverters.get(size2) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
            }
        }
    }
}
