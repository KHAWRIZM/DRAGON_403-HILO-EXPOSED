package androidx.datastore.rxjava3;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.migrations.SharedPreferencesMigration;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Arrays;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rJ%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0010\"\u00020\u0006¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/datastore/rxjava3/RxSharedPreferencesMigrationBuilder;", "T", "", "context", "Landroid/content/Context;", "sharedPreferencesName", "", "rxSharedPreferencesMigration", "Landroidx/datastore/rxjava3/RxSharedPreferencesMigration;", "(Landroid/content/Context;Ljava/lang/String;Landroidx/datastore/rxjava3/RxSharedPreferencesMigration;)V", "keysToMigrate", "", "build", "Landroidx/datastore/core/DataMigration;", "setKeysToMigrate", UserMetadata.KEYDATA_FILENAME, "", "([Ljava/lang/String;)Landroidx/datastore/rxjava3/RxSharedPreferencesMigrationBuilder;", "datastore-rxjava3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SuppressLint({"TopLevelBuilder"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class RxSharedPreferencesMigrationBuilder<T> {

    @NotNull
    private final Context context;

    @Nullable
    private Set<String> keysToMigrate;

    @NotNull
    private final RxSharedPreferencesMigration<T> rxSharedPreferencesMigration;

    @NotNull
    private final String sharedPreferencesName;

    public RxSharedPreferencesMigrationBuilder(@NotNull Context context, @NotNull String sharedPreferencesName, @NotNull RxSharedPreferencesMigration<T> rxSharedPreferencesMigration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sharedPreferencesName, "sharedPreferencesName");
        Intrinsics.checkNotNullParameter(rxSharedPreferencesMigration, "rxSharedPreferencesMigration");
        this.context = context;
        this.sharedPreferencesName = sharedPreferencesName;
        this.rxSharedPreferencesMigration = rxSharedPreferencesMigration;
    }

    @NotNull
    public final DataMigration<T> build() {
        Set<String> set = this.keysToMigrate;
        if (set == null) {
            return new SharedPreferencesMigration(this.context, this.sharedPreferencesName, null, new RxSharedPreferencesMigrationBuilder$build$1(this, null), new RxSharedPreferencesMigrationBuilder$build$2(this, null), 4, null);
        }
        Context context = this.context;
        String str = this.sharedPreferencesName;
        Intrinsics.checkNotNull(set);
        return new SharedPreferencesMigration(context, str, set, new RxSharedPreferencesMigrationBuilder$build$3(this, null), new RxSharedPreferencesMigrationBuilder$build$4(this, null));
    }

    @NotNull
    public final RxSharedPreferencesMigrationBuilder<T> setKeysToMigrate(@NotNull String... keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        this.keysToMigrate = SetsKt.setOf(Arrays.copyOf(keys, keys.length));
        return this;
    }
}
