package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.room.DatabaseConfiguration;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000\u001a$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u00020\u00072\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0000\u001a:\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¨\u0006\u0013"}, d2 = {"isMigrationRequired", "", "Landroidx/room/DatabaseConfiguration;", "fromVersion", "", "toVersion", "contains", "Landroidx/room/RoomDatabase$MigrationContainer;", "startVersion", "endVersion", "findMigrationPath", "", "Landroidx/room/migration/Migration;", "start", "end", "findUpMigrationPath", "result", "", "upgrade", "room-runtime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@JvmName(name = "MigrationUtil")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class MigrationUtil {
    public static final boolean contains(@NotNull RoomDatabase.MigrationContainer migrationContainer, int i10, int i11) {
        Intrinsics.checkNotNullParameter(migrationContainer, "<this>");
        Map<Integer, Map<Integer, Migration>> migrations = migrationContainer.getMigrations();
        if (migrations.containsKey(Integer.valueOf(i10))) {
            Map<Integer, Migration> map = migrations.get(Integer.valueOf(i10));
            if (map == null) {
                map = MapsKt.emptyMap();
            }
            return map.containsKey(Integer.valueOf(i11));
        }
        return false;
    }

    @Nullable
    public static final List<Migration> findMigrationPath(@NotNull RoomDatabase.MigrationContainer migrationContainer, int i10, int i11) {
        boolean z10;
        Intrinsics.checkNotNullParameter(migrationContainer, "<this>");
        if (i10 == i11) {
            return CollectionsKt.emptyList();
        }
        if (i11 > i10) {
            z10 = true;
        } else {
            z10 = false;
        }
        return findUpMigrationPath(migrationContainer, new ArrayList(), z10, i10, i11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x005b, code lost:
    
        return r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x000e  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0009  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final List<Migration> findUpMigrationPath(RoomDatabase.MigrationContainer migrationContainer, List<Migration> list, boolean z10, int i10, int i11) {
        Pair<Map<Integer, Migration>, Iterable<Integer>> sortedNodes$room_runtime_release;
        int i12;
        boolean z11;
        while (true) {
            if (z10) {
                if (i10 >= i11) {
                    break;
                }
                if (!z10) {
                    sortedNodes$room_runtime_release = migrationContainer.getSortedDescendingNodes$room_runtime_release(i10);
                } else {
                    sortedNodes$room_runtime_release = migrationContainer.getSortedNodes$room_runtime_release(i10);
                }
                if (sortedNodes$room_runtime_release != null) {
                    return null;
                }
                Map<Integer, Migration> component1 = sortedNodes$room_runtime_release.component1();
                Iterator<Integer> it = sortedNodes$room_runtime_release.component2().iterator();
                while (it.hasNext()) {
                    i12 = it.next().intValue();
                    if (z10) {
                        if (i10 + 1 <= i12 && i12 <= i11) {
                            Migration migration = component1.get(Integer.valueOf(i12));
                            Intrinsics.checkNotNull(migration);
                            list.add(migration);
                            z11 = true;
                            break;
                        }
                    } else if (i11 <= i12 && i12 < i10) {
                        Migration migration2 = component1.get(Integer.valueOf(i12));
                        Intrinsics.checkNotNull(migration2);
                        list.add(migration2);
                        z11 = true;
                        break;
                    }
                }
                i12 = i10;
                z11 = false;
                if (!z11) {
                    return null;
                }
                i10 = i12;
            } else {
                if (i10 <= i11) {
                    break;
                }
                if (!z10) {
                }
                if (sortedNodes$room_runtime_release != null) {
                }
            }
        }
    }

    public static final boolean isMigrationRequired(@NotNull DatabaseConfiguration databaseConfiguration, int i10, int i11) {
        Intrinsics.checkNotNullParameter(databaseConfiguration, "<this>");
        if (i10 > i11 && databaseConfiguration.allowDestructiveMigrationOnDowngrade) {
            return false;
        }
        Set<Integer> migrationNotRequiredFrom$room_runtime_release = databaseConfiguration.getMigrationNotRequiredFrom$room_runtime_release();
        if (!databaseConfiguration.requireMigration) {
            return false;
        }
        if (migrationNotRequiredFrom$room_runtime_release != null && migrationNotRequiredFrom$room_runtime_release.contains(Integer.valueOf(i10))) {
            return false;
        }
        return true;
    }
}
