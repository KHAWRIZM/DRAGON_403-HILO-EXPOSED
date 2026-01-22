package androidx.room;

import androidx.room.InvalidationTracker;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011H\u0000¢\u0006\u0002\b\u0016J\u001b\u0010\u0017\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0000¢\u0006\u0002\b\u0019R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/room/ObserverWrapper;", "", "observer", "Landroidx/room/InvalidationTracker$Observer;", "tableIds", "", "tableNames", "", "", "<init>", "(Landroidx/room/InvalidationTracker$Observer;[I[Ljava/lang/String;)V", "getObserver$room_runtime_release", "()Landroidx/room/InvalidationTracker$Observer;", "getTableIds$room_runtime_release", "()[I", "[Ljava/lang/String;", "singleTableSet", "", "notifyByTableIds", "", "invalidatedTablesIds", "", "notifyByTableIds$room_runtime_release", "notifyByTableNames", "invalidatedTablesNames", "notifyByTableNames$room_runtime_release", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInvalidationTracker.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.android.kt\nandroidx/room/ObserverWrapper\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,592:1\n13497#2,3:593\n1755#3,3:596\n1863#3,2:599\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.android.kt\nandroidx/room/ObserverWrapper\n*L\n532#1:593,3\n550#1:596,3\n558#1:599,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class ObserverWrapper {

    @NotNull
    private final InvalidationTracker.Observer observer;

    @NotNull
    private final Set<String> singleTableSet;

    @NotNull
    private final int[] tableIds;

    @NotNull
    private final String[] tableNames;

    public ObserverWrapper(@NotNull InvalidationTracker.Observer observer, @NotNull int[] tableIds, @NotNull String[] tableNames) {
        boolean z10;
        Set<String> emptySet;
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(tableIds, "tableIds");
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        this.observer = observer;
        this.tableIds = tableIds;
        this.tableNames = tableNames;
        if (tableIds.length == tableNames.length) {
            if (tableNames.length == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                emptySet = SetsKt.setOf(tableNames[0]);
            } else {
                emptySet = SetsKt.emptySet();
            }
            this.singleTableSet = emptySet;
            return;
        }
        throw new IllegalStateException("Check failed.");
    }

    @NotNull
    /* renamed from: getObserver$room_runtime_release, reason: from getter */
    public final InvalidationTracker.Observer getObserver() {
        return this.observer;
    }

    @NotNull
    /* renamed from: getTableIds$room_runtime_release, reason: from getter */
    public final int[] getTableIds() {
        return this.tableIds;
    }

    public final void notifyByTableIds$room_runtime_release(@NotNull Set<Integer> invalidatedTablesIds) {
        Set<String> emptySet;
        Intrinsics.checkNotNullParameter(invalidatedTablesIds, "invalidatedTablesIds");
        int[] iArr = this.tableIds;
        int length = iArr.length;
        if (length != 0) {
            int i10 = 0;
            if (length != 1) {
                Set createSetBuilder = SetsKt.createSetBuilder();
                int[] iArr2 = this.tableIds;
                int length2 = iArr2.length;
                int i11 = 0;
                while (i10 < length2) {
                    int i12 = i11 + 1;
                    if (invalidatedTablesIds.contains(Integer.valueOf(iArr2[i10]))) {
                        createSetBuilder.add(this.tableNames[i11]);
                    }
                    i10++;
                    i11 = i12;
                }
                emptySet = SetsKt.build(createSetBuilder);
            } else if (invalidatedTablesIds.contains(Integer.valueOf(iArr[0]))) {
                emptySet = this.singleTableSet;
            } else {
                emptySet = SetsKt.emptySet();
            }
        } else {
            emptySet = SetsKt.emptySet();
        }
        if (!emptySet.isEmpty()) {
            this.observer.onInvalidated(emptySet);
        }
    }

    public final void notifyByTableNames$room_runtime_release(@NotNull Set<String> invalidatedTablesNames) {
        Set<String> emptySet;
        Intrinsics.checkNotNullParameter(invalidatedTablesNames, "invalidatedTablesNames");
        int length = this.tableNames.length;
        if (length != 0) {
            if (length != 1) {
                Set createSetBuilder = SetsKt.createSetBuilder();
                for (String str : invalidatedTablesNames) {
                    String[] strArr = this.tableNames;
                    int length2 = strArr.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 < length2) {
                            String str2 = strArr[i10];
                            if (StringsKt.equals(str2, str, true)) {
                                createSetBuilder.add(str2);
                                break;
                            }
                            i10++;
                        }
                    }
                }
                emptySet = SetsKt.build(createSetBuilder);
            } else {
                if (!(invalidatedTablesNames instanceof Collection) || !invalidatedTablesNames.isEmpty()) {
                    Iterator<T> it = invalidatedTablesNames.iterator();
                    while (it.hasNext()) {
                        if (StringsKt.equals((String) it.next(), this.tableNames[0], true)) {
                            emptySet = this.singleTableSet;
                            break;
                        }
                    }
                }
                emptySet = SetsKt.emptySet();
            }
        } else {
            emptySet = SetsKt.emptySet();
        }
        if (!emptySet.isEmpty()) {
            this.observer.onInvalidated(emptySet);
        }
    }
}
