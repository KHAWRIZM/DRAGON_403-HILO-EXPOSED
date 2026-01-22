package com.oudi.core.common;

import com.oudi.core.common.ExpiringCache;
import com.oudi.utils.ServiceTime;
import com.oudi.utils.ktx.CollectionKtxKt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0000H$¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\bH\u0014J\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012J\u0013\u0010\u0013\u001a\u00020\u00102\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012J\u0015\u0010\u0016\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0017\u001a\u00020\u0007¢\u0006\u0002\u0010\u0018J\u001f\u0010\u0019\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\b¢\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001e\u001a\u00020\u0010R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/oudi/core/common/ExpiringCache;", "T", "", "<init>", "()V", "updateTime", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "entityMap", "getEntityId", "entity", "(Ljava/lang/Object;)Ljava/lang/String;", "getDefaultExpiredTime", "removeNot", "", "list", "", "put", "(Ljava/lang/Object;)V", "putAll", "getIfExist", "id", "(Ljava/lang/String;)Ljava/lang/Object;", "get", "expiredTime", "(Ljava/lang/String;J)Ljava/lang/Object;", "isExpired", "", "clear", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExpiringCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExpiringCache.kt\ncom/oudi/core/common/ExpiringCache\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,114:1\n1863#2,2:115\n*S KotlinDebug\n*F\n+ 1 ExpiringCache.kt\ncom/oudi/core/common/ExpiringCache\n*L\n62#1:115,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class ExpiringCache<T> {

    @NotNull
    private final HashMap<String, Long> updateTime = new HashMap<>();

    @NotNull
    private final HashMap<String, T> entityMap = new HashMap<>();

    public static /* synthetic */ Object get$default(ExpiringCache expiringCache, String str, long j10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 2) != 0) {
                j10 = expiringCache.getDefaultExpiredTime();
            }
            return expiringCache.get(str, j10);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
    }

    public static /* synthetic */ boolean isExpired$default(ExpiringCache expiringCache, String str, long j10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 2) != 0) {
                j10 = expiringCache.getDefaultExpiredTime();
            }
            return expiringCache.isExpired(str, j10);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isExpired");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeNot$lambda$0(List list, ExpiringCache expiringCache, Map.Entry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        boolean contains = list.contains(it.getKey());
        boolean z10 = !contains;
        if (!contains) {
            expiringCache.updateTime.remove(it.getKey());
        }
        return z10;
    }

    public final void clear() {
        this.entityMap.clear();
        this.updateTime.clear();
    }

    @Nullable
    public final T get(@NotNull String id, long expiredTime) {
        Intrinsics.checkNotNullParameter(id, "id");
        if (isExpired(id, expiredTime)) {
            return null;
        }
        return this.entityMap.get(id);
    }

    public long getDefaultExpiredTime() {
        return LongCompanionObject.MAX_VALUE;
    }

    @NotNull
    public abstract String getEntityId(T entity);

    @Nullable
    public final T getIfExist(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.entityMap.get(id);
    }

    public final boolean isExpired(@NotNull String id, long expiredTime) {
        Intrinsics.checkNotNullParameter(id, "id");
        Long l10 = this.updateTime.get(id);
        if (l10 == null) {
            return true;
        }
        long longValue = l10.longValue();
        if (!this.entityMap.containsKey(id) || System.currentTimeMillis() - longValue > expiredTime) {
            return true;
        }
        return false;
    }

    public final void put(T entity) {
        String entityId = getEntityId(entity);
        this.entityMap.put(entityId, entity);
        this.updateTime.put(entityId, Long.valueOf(ServiceTime.INSTANCE.getTime()));
    }

    public final void putAll(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        long time = ServiceTime.INSTANCE.getTime();
        for (T t10 : list) {
            String entityId = getEntityId(t10);
            this.entityMap.put(entityId, t10);
            this.updateTime.put(entityId, Long.valueOf(time));
        }
    }

    public final void removeNot(@NotNull final List<String> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        CollectionKtxKt.removeIf2(this.entityMap.entrySet().iterator(), new Function1() { // from class: ta.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean removeNot$lambda$0;
                removeNot$lambda$0 = ExpiringCache.removeNot$lambda$0(list, this, (Map.Entry) obj);
                return Boolean.valueOf(removeNot$lambda$0);
            }
        });
    }
}
