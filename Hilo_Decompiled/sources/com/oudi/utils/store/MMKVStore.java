package com.oudi.utils.store;

import android.os.Parcelable;
import android.util.Base64;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.tencent.mmkv.MMKV;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u0002H\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0014J-\u0010\u0015\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u0002H\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0018J0\u0010\u0019\u001a\u0004\u0018\u0001H\u0010\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0086\b¢\u0006\u0002\u0010\u001bJ6\u0010\u001c\u001a\u00020\u0016\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u0002H\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0086\b¢\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u001a\u0010!\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\"\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010#\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0017R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR'\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006$"}, d2 = {"Lcom/oudi/utils/store/MMKVStore;", "Lcom/oudi/utils/store/IStore;", "Lcom/tencent/mmkv/MMKV;", "<init>", "()V", "cKey", "", "getCKey", "()Ljava/lang/String;", "preferenceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getPreferenceMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "preferenceMap$delegate", "Lkotlin/Lazy;", "getValue", "T", TransferTable.COLUMN_KEY, "default", "group", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Z", "getParcelable", "Landroid/os/Parcelable;", "(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Parcelable;", "setParcelable", "(Ljava/lang/String;Landroid/os/Parcelable;Ljava/lang/String;)Z", "clear", "", "clearAll", "removeValue", "containsKey", "getInstance", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class MMKVStore implements IStore<MMKV> {
    public static final MMKVStore INSTANCE = new MMKVStore();
    private static final String cKey = "com.qiahao.nextvideo";

    /* renamed from: preferenceMap$delegate, reason: from kotlin metadata */
    private static final Lazy preferenceMap = LazyKt.lazy(new Function0() { // from class: com.oudi.utils.store.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ConcurrentHashMap preferenceMap_delegate$lambda$0;
            preferenceMap_delegate$lambda$0 = MMKVStore.preferenceMap_delegate$lambda$0();
            return preferenceMap_delegate$lambda$0;
        }
    });

    private MMKVStore() {
    }

    public static /* synthetic */ Parcelable getParcelable$default(MMKVStore mMKVStore, String key, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        MMKV mMKVStore2 = mMKVStore.getInstance(str);
        if (mMKVStore2 == null) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        return mMKVStore2.decodeParcelable(key, Parcelable.class);
    }

    private final ConcurrentHashMap<String, MMKV> getPreferenceMap() {
        return (ConcurrentHashMap) preferenceMap.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConcurrentHashMap preferenceMap_delegate$lambda$0() {
        return new ConcurrentHashMap();
    }

    public static /* synthetic */ boolean setParcelable$default(MMKVStore mMKVStore, String key, Parcelable value, String str, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        MMKV mMKVStore2 = mMKVStore.getInstance(str);
        if (mMKVStore2 == null) {
            return false;
        }
        return mMKVStore2.encode(key, value);
    }

    @Override // com.oudi.utils.store.IStore
    public void clear(String group) {
        MMKV mMKVStore = getInstance(group);
        if (mMKVStore == null) {
            return;
        }
        mMKVStore.clear();
    }

    @Override // com.oudi.utils.store.IStore
    public void clearAll() {
        MMKV mMKVStore = getInstance((String) null);
        if (mMKVStore == null) {
            return;
        }
        mMKVStore.clearAll();
    }

    @Override // com.oudi.utils.store.IStore
    public boolean containsKey(String key, String group) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKV mMKVStore = getInstance(group);
        if (mMKVStore == null) {
            return false;
        }
        return mMKVStore.containsKey(key);
    }

    public final String getCKey() {
        return cKey;
    }

    public final /* synthetic */ <T extends Parcelable> T getParcelable(String key, String group) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKV mMKVStore = getInstance(group);
        if (mMKVStore == null) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) mMKVStore.decodeParcelable(key, Parcelable.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.oudi.utils.store.IStore
    public <T> T getValue(String key, T r42, String group) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKV mMKVStore = getInstance(group);
        if (mMKVStore == null) {
            return r42;
        }
        if (r42 instanceof String) {
            return (T) mMKVStore.getString(key, (String) r42);
        }
        if (r42 instanceof Integer) {
            return (T) Integer.valueOf(mMKVStore.getInt(key, ((Number) r42).intValue()));
        }
        if (r42 instanceof Long) {
            return (T) Long.valueOf(mMKVStore.getLong(key, ((Number) r42).longValue()));
        }
        if (r42 instanceof Float) {
            return (T) Float.valueOf(mMKVStore.getFloat(key, ((Number) r42).floatValue()));
        }
        if (r42 instanceof Double) {
            return (T) Double.valueOf(mMKVStore.decodeDouble(key, ((Number) r42).doubleValue()));
        }
        if (r42 instanceof Boolean) {
            return (T) Boolean.valueOf(mMKVStore.getBoolean(key, ((Boolean) r42).booleanValue()));
        }
        if (r42 instanceof byte[]) {
            return (T) mMKVStore.getBytes(key, (byte[]) r42);
        }
        if (r42 instanceof Parcelable) {
            return (T) mMKVStore.decodeParcelable(key, r42.getClass());
        }
        return r42;
    }

    @Override // com.oudi.utils.store.IStore
    public boolean removeValue(String key, String group) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKV mMKVStore = getInstance(group);
        if (mMKVStore == null) {
            return false;
        }
        mMKVStore.remove(key);
        return true;
    }

    public final /* synthetic */ <T extends Parcelable> boolean setParcelable(String key, T value, String group) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        MMKV mMKVStore = getInstance(group);
        if (mMKVStore == null) {
            return false;
        }
        return mMKVStore.encode(key, value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.oudi.utils.store.IStore
    public <T> boolean setValue(String key, T value, String group) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKV mMKVStore = getInstance(group);
        if (mMKVStore == null) {
            return false;
        }
        if (value instanceof String) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
            mMKVStore.putString(key, (String) value);
            return true;
        }
        if (value instanceof Integer) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Int");
            mMKVStore.putInt(key, ((Integer) value).intValue());
            return true;
        }
        if (value instanceof Long) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Long");
            mMKVStore.putLong(key, ((Long) value).longValue());
            return true;
        }
        if (value instanceof Float) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Float");
            mMKVStore.putFloat(key, ((Float) value).floatValue());
            return true;
        }
        if (value instanceof Double) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Double");
            mMKVStore.encode(key, ((Double) value).doubleValue());
            return true;
        }
        if (value instanceof Boolean) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Boolean");
            mMKVStore.putBoolean(key, ((Boolean) value).booleanValue());
            return true;
        }
        if (value instanceof Parcelable) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.os.Parcelable");
            mMKVStore.encode(key, (Parcelable) value);
            return true;
        }
        throw new IllegalArgumentException("This type of data can not be saved! ");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.oudi.utils.store.IStore
    public MMKV getInstance(String group) {
        MMKV mmkvWithID;
        if (group == null) {
            group = "default";
        }
        try {
            if (!getPreferenceMap().containsKey(group)) {
                synchronized (this) {
                    try {
                        MMKVStore mMKVStore = INSTANCE;
                        if (!mMKVStore.getPreferenceMap().containsKey(group)) {
                            byte[] bytes = cKey.getBytes(Charsets.UTF_8);
                            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                            String encodeToString = Base64.encodeToString(bytes, 2);
                            ConcurrentHashMap<String, MMKV> preferenceMap2 = mMKVStore.getPreferenceMap();
                            if (Intrinsics.areEqual(group, "default")) {
                                mmkvWithID = MMKV.defaultMMKV(1, encodeToString);
                            } else {
                                mmkvWithID = MMKV.mmkvWithID(group, 1, encodeToString);
                            }
                            preferenceMap2.put(group, mmkvWithID);
                        }
                        Unit unit = Unit.INSTANCE;
                    } finally {
                    }
                }
            }
            MMKV mmkv = getPreferenceMap().get(group);
            Intrinsics.checkNotNull(mmkv);
            return mmkv;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
