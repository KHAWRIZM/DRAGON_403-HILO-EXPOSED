package androidx.datastore.rxjava3;

import androidx.datastore.migrations.SharedPreferencesView;
import io.reactivex.rxjava3.core.i0;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0003"}, d2 = {"Landroidx/datastore/rxjava3/RxSharedPreferencesMigration;", "T", "", "currentData", "Lio/reactivex/rxjava3/core/i0;", "", "shouldMigrate", "(Ljava/lang/Object;)Lio/reactivex/rxjava3/core/i0;", "Landroidx/datastore/migrations/SharedPreferencesView;", "sharedPreferencesView", "migrate", "(Landroidx/datastore/migrations/SharedPreferencesView;Ljava/lang/Object;)Lio/reactivex/rxjava3/core/i0;", "datastore-rxjava3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface RxSharedPreferencesMigration<T> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class DefaultImpls {
        @Deprecated
        @NotNull
        public static <T> i0<Boolean> shouldMigrate(@NotNull RxSharedPreferencesMigration<T> rxSharedPreferencesMigration, T t10) {
            i0<Boolean> a10;
            a10 = b.a(rxSharedPreferencesMigration, t10);
            return a10;
        }
    }

    @NotNull
    i0<T> migrate(@NotNull SharedPreferencesView sharedPreferencesView, T currentData);

    @NotNull
    i0<Boolean> shouldMigrate(T currentData);
}
