package com.oudi.utils.store;

import android.content.SharedPreferences;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.oudi.utils.AppUtils;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u0002H\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u0011J-\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u0002H\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u001a\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016R'\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/oudi/utils/store/SPStore;", "Lcom/oudi/utils/store/IStore;", "Landroid/content/SharedPreferences;", "<init>", "()V", "preferenceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getPreferenceMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "preferenceMap$delegate", "Lkotlin/Lazy;", "getValue", "T", TransferTable.COLUMN_KEY, "default", "group", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Z", "clear", "", "clearAll", "removeValue", "containsKey", "getInstance", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class SPStore implements IStore<SharedPreferences> {
    public static final SPStore INSTANCE = new SPStore();

    /* renamed from: preferenceMap$delegate, reason: from kotlin metadata */
    private static final Lazy preferenceMap = LazyKt.lazy(new Function0() { // from class: com.oudi.utils.store.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ConcurrentHashMap preferenceMap_delegate$lambda$0;
            preferenceMap_delegate$lambda$0 = SPStore.preferenceMap_delegate$lambda$0();
            return preferenceMap_delegate$lambda$0;
        }
    });

    private SPStore() {
    }

    private final ConcurrentHashMap<String, SharedPreferences> getPreferenceMap() {
        return (ConcurrentHashMap) preferenceMap.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConcurrentHashMap preferenceMap_delegate$lambda$0() {
        return new ConcurrentHashMap();
    }

    @Override // com.oudi.utils.store.IStore
    public void clear(String group) {
        SharedPreferences sPStore = getInstance(group);
        if (sPStore == null) {
            return;
        }
        sPStore.edit().clear().apply();
    }

    @Override // com.oudi.utils.store.IStore
    public void clearAll() {
        SharedPreferences sPStore = getInstance("default");
        if (sPStore == null) {
            return;
        }
        sPStore.edit().clear().apply();
    }

    @Override // com.oudi.utils.store.IStore
    public boolean containsKey(String key, String group) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sPStore = getInstance(group);
        if (sPStore == null) {
            return false;
        }
        return sPStore.contains(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.oudi.utils.store.IStore
    public <T> T getValue(String key, T r42, String group) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sPStore = getInstance(group);
        if (sPStore == null) {
            return r42;
        }
        if (r42 instanceof String) {
            return (T) sPStore.getString(key, (String) r42);
        }
        if (r42 instanceof Integer) {
            return (T) Integer.valueOf(sPStore.getInt(key, ((Number) r42).intValue()));
        }
        if (r42 instanceof Long) {
            return (T) Long.valueOf(sPStore.getLong(key, ((Number) r42).longValue()));
        }
        if (r42 instanceof Float) {
            return (T) Float.valueOf(sPStore.getFloat(key, ((Number) r42).floatValue()));
        }
        if (r42 instanceof Boolean) {
            return (T) Boolean.valueOf(sPStore.getBoolean(key, ((Boolean) r42).booleanValue()));
        }
        if (r42 instanceof Set) {
            Intrinsics.checkNotNull(r42, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
            return (T) sPStore.getStringSet(key, (Set) r42);
        }
        throw new IllegalArgumentException("This type of data can not be get! ");
    }

    @Override // com.oudi.utils.store.IStore
    public boolean removeValue(String key, String group) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sPStore = getInstance(group);
        if (sPStore == null) {
            return false;
        }
        sPStore.edit().remove(key).apply();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.oudi.utils.store.IStore
    public <T> boolean setValue(String key, T value, String group) {
        SharedPreferences.Editor putStringSet;
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sPStore = getInstance(group);
        if (sPStore == null) {
            return false;
        }
        SharedPreferences.Editor edit = sPStore.edit();
        if (value instanceof String) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
            putStringSet = edit.putString(key, (String) value);
        } else if (value instanceof Integer) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Int");
            putStringSet = edit.putInt(key, ((Integer) value).intValue());
        } else if (value instanceof Long) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Long");
            putStringSet = edit.putLong(key, ((Long) value).longValue());
        } else if (value instanceof Float) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Float");
            putStringSet = edit.putFloat(key, ((Float) value).floatValue());
        } else if (value instanceof Boolean) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Boolean");
            putStringSet = edit.putBoolean(key, ((Boolean) value).booleanValue());
        } else if (value instanceof Set) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
            putStringSet = edit.putStringSet(key, (Set) value);
        } else {
            throw new IllegalArgumentException("This type of data can not be saved! ");
        }
        putStringSet.apply();
        return true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.oudi.utils.store.IStore
    public SharedPreferences getInstance(String group) {
        String str = group == null ? "default" : group;
        if (!getPreferenceMap().containsKey(str)) {
            synchronized (this) {
                try {
                    SPStore sPStore = INSTANCE;
                    if (!sPStore.getPreferenceMap().containsKey(str)) {
                        sPStore.getPreferenceMap().put(str, AppUtils.getApp().getSharedPreferences(group, 0));
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        SharedPreferences sharedPreferences = getPreferenceMap().get(str);
        Intrinsics.checkNotNull(sharedPreferences);
        return sharedPreferences;
    }
}
