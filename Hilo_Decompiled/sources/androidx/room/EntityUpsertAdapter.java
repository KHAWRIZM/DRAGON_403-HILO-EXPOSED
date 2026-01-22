package androidx.room;

import android.database.SQLException;
import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteConnection;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 $*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001$B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000eJ'\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u000f\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0012J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0015J'\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u000f\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0010¢\u0006\u0002\u0010\u0018J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0019J-\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u001b2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u000f\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0010¢\u0006\u0002\u0010\u001cJ&\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u001b2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0019J/\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u000f\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0010¢\u0006\u0002\u0010\u001eJ-\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0019¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u00020\n2\n\u0010!\u001a\u00060\"j\u0002`#H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/room/EntityUpsertAdapter;", "T", "", "entityInsertAdapter", "Landroidx/room/EntityInsertAdapter;", "updateAdapter", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "<init>", "(Landroidx/room/EntityInsertAdapter;Landroidx/room/EntityDeleteOrUpdateAdapter;)V", "upsert", "", "connection", "Landroidx/sqlite/SQLiteConnection;", "entity", "(Landroidx/sqlite/SQLiteConnection;Ljava/lang/Object;)V", "entities", "", "(Landroidx/sqlite/SQLiteConnection;[Ljava/lang/Object;)V", "", "upsertAndReturnId", "", "(Landroidx/sqlite/SQLiteConnection;Ljava/lang/Object;)J", "upsertAndReturnIdsArray", "", "(Landroidx/sqlite/SQLiteConnection;[Ljava/lang/Object;)[J", "", "upsertAndReturnIdsList", "", "(Landroidx/sqlite/SQLiteConnection;[Ljava/lang/Object;)Ljava/util/List;", "upsertAndReturnIdsArrayBox", "(Landroidx/sqlite/SQLiteConnection;[Ljava/lang/Object;)[Ljava/lang/Long;", "(Landroidx/sqlite/SQLiteConnection;Ljava/util/Collection;)[Ljava/lang/Long;", "checkUniquenessException", "ex", "Landroid/database/SQLException;", "Landroidx/sqlite/SQLiteException;", "Companion", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@SourceDebugExtension({"SMAP\nEntityUpsertAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityUpsertAdapter.kt\nandroidx/room/EntityUpsertAdapter\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,238:1\n13402#2,2:239\n13402#2,2:243\n1863#3,2:241\n1863#3,2:245\n*S KotlinDebug\n*F\n+ 1 EntityUpsertAdapter.kt\nandroidx/room/EntityUpsertAdapter\n*L\n61#1:239,2\n139#1:243,2\n73#1:241,2\n157#1:245,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class EntityUpsertAdapter<T> {

    @NotNull
    private static final String ErrorMsg = "unique";

    @NotNull
    private static final String SQLITE_CONSTRAINT_PRIMARYKEY = "1555";

    @NotNull
    private static final String SQLITE_CONSTRAINT_UNIQUE = "2067";

    @NotNull
    private final EntityInsertAdapter<T> entityInsertAdapter;

    @NotNull
    private final EntityDeleteOrUpdateAdapter<T> updateAdapter;

    public EntityUpsertAdapter(@NotNull EntityInsertAdapter<T> entityInsertAdapter, @NotNull EntityDeleteOrUpdateAdapter<T> updateAdapter) {
        Intrinsics.checkNotNullParameter(entityInsertAdapter, "entityInsertAdapter");
        Intrinsics.checkNotNullParameter(updateAdapter, "updateAdapter");
        this.entityInsertAdapter = entityInsertAdapter;
        this.updateAdapter = updateAdapter;
    }

    private final void checkUniquenessException(SQLException ex) {
        String message = ex.getMessage();
        if (message != null) {
            if (!StringsKt.contains((CharSequence) message, (CharSequence) ErrorMsg, true) && !StringsKt.contains$default((CharSequence) message, (CharSequence) SQLITE_CONSTRAINT_UNIQUE, false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) message, (CharSequence) SQLITE_CONSTRAINT_PRIMARYKEY, false, 2, (Object) null)) {
                throw ex;
            }
            return;
        }
        throw ex;
    }

    public final void upsert(@NotNull SQLiteConnection connection, @Nullable T entity) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        try {
            this.entityInsertAdapter.insert(connection, (SQLiteConnection) entity);
        } catch (SQLException e10) {
            checkUniquenessException(e10);
            this.updateAdapter.handle(connection, entity);
        }
    }

    public final long upsertAndReturnId(@NotNull SQLiteConnection connection, @Nullable T entity) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        try {
            return this.entityInsertAdapter.insertAndReturnId(connection, entity);
        } catch (SQLException e10) {
            checkUniquenessException(e10);
            this.updateAdapter.handle(connection, entity);
            return -1L;
        }
    }

    @NotNull
    public final long[] upsertAndReturnIdsArray(@NotNull SQLiteConnection connection, @Nullable T[] entities) {
        long j10;
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (entities == null) {
            return new long[0];
        }
        int length = entities.length;
        long[] jArr = new long[length];
        for (int i10 = 0; i10 < length; i10++) {
            try {
                j10 = this.entityInsertAdapter.insertAndReturnId(connection, entities[i10]);
            } catch (SQLException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(connection, entities[i10]);
                j10 = -1;
            }
            jArr[i10] = j10;
        }
        return jArr;
    }

    @NotNull
    public final Long[] upsertAndReturnIdsArrayBox(@NotNull SQLiteConnection connection, @Nullable T[] entities) {
        long j10;
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (entities == null) {
            return new Long[0];
        }
        int length = entities.length;
        Long[] lArr = new Long[length];
        for (int i10 = 0; i10 < length; i10++) {
            try {
                j10 = this.entityInsertAdapter.insertAndReturnId(connection, entities[i10]);
            } catch (SQLException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(connection, entities[i10]);
                j10 = -1;
            }
            lArr[i10] = Long.valueOf(j10);
        }
        return lArr;
    }

    @NotNull
    public final List<Long> upsertAndReturnIdsList(@NotNull SQLiteConnection connection, @Nullable T[] entities) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (entities == null) {
            return CollectionsKt.emptyList();
        }
        List createListBuilder = CollectionsKt.createListBuilder();
        for (T t10 : entities) {
            try {
                createListBuilder.add(Long.valueOf(this.entityInsertAdapter.insertAndReturnId(connection, t10)));
            } catch (SQLException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(connection, t10);
                createListBuilder.add(-1L);
            }
        }
        return CollectionsKt.build(createListBuilder);
    }

    public final void upsert(@NotNull SQLiteConnection connection, @Nullable T[] entities) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (entities == null) {
            return;
        }
        for (T t10 : entities) {
            try {
                this.entityInsertAdapter.insert(connection, (SQLiteConnection) t10);
            } catch (SQLException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(connection, t10);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final long[] upsertAndReturnIdsArray(@NotNull SQLiteConnection connection, @Nullable Collection<? extends T> entities) {
        long j10;
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (entities == null) {
            return new long[0];
        }
        int size = entities.size();
        long[] jArr = new long[size];
        for (int i10 = 0; i10 < size; i10++) {
            try {
                j10 = this.entityInsertAdapter.insertAndReturnId(connection, CollectionsKt.elementAt(entities, i10));
            } catch (SQLException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(connection, CollectionsKt.elementAt(entities, i10));
                j10 = -1;
            }
            jArr[i10] = j10;
        }
        return jArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final Long[] upsertAndReturnIdsArrayBox(@NotNull SQLiteConnection connection, @Nullable Collection<? extends T> entities) {
        long j10;
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (entities == null) {
            return new Long[0];
        }
        int size = entities.size();
        Long[] lArr = new Long[size];
        for (int i10 = 0; i10 < size; i10++) {
            try {
                j10 = this.entityInsertAdapter.insertAndReturnId(connection, CollectionsKt.elementAt(entities, i10));
            } catch (SQLException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(connection, CollectionsKt.elementAt(entities, i10));
                j10 = -1;
            }
            lArr[i10] = Long.valueOf(j10);
        }
        return lArr;
    }

    public final void upsert(@NotNull SQLiteConnection connection, @Nullable Iterable<? extends T> entities) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (entities == null) {
            return;
        }
        for (T t10 : entities) {
            try {
                this.entityInsertAdapter.insert(connection, (SQLiteConnection) t10);
            } catch (SQLException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(connection, t10);
            }
        }
    }

    @NotNull
    public final List<Long> upsertAndReturnIdsList(@NotNull SQLiteConnection connection, @Nullable Collection<? extends T> entities) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (entities == null) {
            return CollectionsKt.emptyList();
        }
        List createListBuilder = CollectionsKt.createListBuilder();
        for (T t10 : entities) {
            try {
                createListBuilder.add(Long.valueOf(this.entityInsertAdapter.insertAndReturnId(connection, t10)));
            } catch (SQLException e10) {
                checkUniquenessException(e10);
                this.updateAdapter.handle(connection, t10);
                createListBuilder.add(-1L);
            }
        }
        return CollectionsKt.build(createListBuilder);
    }
}
