package com.therouter.inject;

import com.therouter.TheRouterKt;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J<\u0010\f\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000f2\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0011\"\u0004\u0018\u00010\u0001H\u0086\u0002¢\u0006\u0002\u0010\u0012J?\u0010\u0013\u001a\u00020\u0014\"\u0004\b\u0000\u0010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000f2\u0006\u0010\u0015\u001a\u0002H\r2\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0011\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0016R \u0010\u0003\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0016\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/therouter/inject/RecyclerBin;", "", "()V", "m2ndCacher", "Ljava/util/WeakHashMap;", "Lcom/therouter/inject/ClassWrapper;", "mCacher", "Lcom/therouter/inject/RecyclerLruCache;", "singletonMap", "Ljava/util/concurrent/ConcurrentHashMap;", "debug", "", "get", "T", "clazz", "Ljava/lang/Class;", "params", "", "(Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "put", "", "t", "(Ljava/lang/Class;Ljava/lang/Object;[Ljava/lang/Object;)V", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RecyclerBin {

    @NotNull
    private final WeakHashMap<ClassWrapper<?>, Object> m2ndCacher;

    @NotNull
    private final RecyclerLruCache<ClassWrapper<?>, Object> mCacher;

    @NotNull
    private final ConcurrentHashMap<ClassWrapper<?>, Object> singletonMap = new ConcurrentHashMap<>();

    public RecyclerBin() {
        RecyclerLruCache<ClassWrapper<?>, Object> recyclerLruCache = new RecyclerLruCache<>(10);
        recyclerLruCache.setOnEntryRemovedListener(new Function3<ClassWrapper<?>, Object, Object, Unit>() { // from class: com.therouter.inject.RecyclerBin$mCacher$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((ClassWrapper<?>) obj, obj2, obj3);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable ClassWrapper<?> classWrapper, @Nullable Object obj, @Nullable Object obj2) {
                WeakHashMap weakHashMap;
                WeakHashMap weakHashMap2;
                weakHashMap = RecyclerBin.this.m2ndCacher;
                RecyclerBin recyclerBin = RecyclerBin.this;
                synchronized (weakHashMap) {
                    weakHashMap2 = recyclerBin.m2ndCacher;
                    weakHashMap2.put(classWrapper, obj);
                    Unit unit = Unit.INSTANCE;
                }
            }
        });
        this.mCacher = recyclerLruCache;
        this.m2ndCacher = new WeakHashMap<>();
    }

    private final String debug() {
        int i;
        Class<?> unWrapper;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("singletonMap: ");
        sb2.append(this.singletonMap.size());
        sb2.append("\n");
        Iterator<ClassWrapper<?>> it = this.singletonMap.keySet().iterator();
        while (true) {
            int i2 = 0;
            if (!it.hasNext()) {
                break;
            }
            ClassWrapper<?> next = it.next();
            sb2.append(next.unWrapper().getSimpleName());
            sb2.append(" : ");
            Object obj = this.singletonMap.get(next);
            Intrinsics.checkNotNull(obj);
            sb2.append(obj.getClass().getSimpleName());
            sb2.append(" hash:: ");
            Object obj2 = this.singletonMap.get(next);
            if (obj2 != null) {
                i2 = obj2.hashCode();
            }
            sb2.append(i2);
            sb2.append("\n");
        }
        Map<ClassWrapper<?>, Object> snapshot = this.mCacher.snapshot();
        sb2.append("LRU: ");
        sb2.append(this.mCacher.size());
        sb2.append("\n");
        Iterator<ClassWrapper<?>> it2 = snapshot.keySet().iterator();
        while (true) {
            String str = null;
            if (!it2.hasNext()) {
                break;
            }
            ClassWrapper<?> next2 = it2.next();
            if (next2 != null && (unWrapper = next2.unWrapper()) != null) {
                str = unWrapper.getSimpleName();
            }
            sb2.append(str);
            sb2.append(" : ");
            Object obj3 = snapshot.get(next2);
            Intrinsics.checkNotNull(obj3);
            sb2.append(obj3.getClass().getSimpleName());
            sb2.append(" hash:: ");
            Object obj4 = snapshot.get(next2);
            if (obj4 != null) {
                i = obj4.hashCode();
            } else {
                i = 0;
            }
            sb2.append(i);
            sb2.append("\n");
        }
        sb2.append("2ndCacher: ");
        sb2.append(this.m2ndCacher.size());
        sb2.append("\n");
        for (ClassWrapper<?> classWrapper : this.m2ndCacher.keySet()) {
            if (this.m2ndCacher.get(classWrapper) == null) {
                sb2.append(classWrapper.unWrapper().getSimpleName());
                sb2.append(" recycled");
            } else {
                Object obj5 = this.m2ndCacher.get(classWrapper);
                sb2.append(classWrapper.unWrapper().getSimpleName());
                sb2.append(" : ");
                Intrinsics.checkNotNull(obj5);
                sb2.append(obj5.getClass().getSimpleName());
                sb2.append(" hash:: ");
                sb2.append(obj5.hashCode());
                sb2.append("\n");
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        TheRouterKt.debug$default("RecyclerBin", sb3, null, 4, null);
        String sb4 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "toString(...)");
        return sb4;
    }

    @Nullable
    public final <T> T get(@NotNull Class<T> clazz, @NotNull Object... params) {
        T t;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(params, "params");
        ClassWrapper<?> classWrapper = new ClassWrapper<>(clazz, Arrays.copyOf(params, params.length));
        T t2 = (T) this.singletonMap.get(classWrapper);
        if (t2 == null) {
            T t3 = (T) this.mCacher.get(classWrapper);
            if (t3 == null) {
                synchronized (this.m2ndCacher) {
                    t = (T) this.m2ndCacher.remove(classWrapper);
                    Unit unit = Unit.INSTANCE;
                }
                if (t != null) {
                    this.mCacher.put(classWrapper, t);
                }
                return t;
            }
            return t3;
        }
        return t2;
    }

    public final <T> void put(@NotNull Class<T> clazz, T t, @NotNull Object... params) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(params, "params");
        ClassWrapper<?> classWrapper = new ClassWrapper<>(clazz, Arrays.copyOf(params, params.length));
        if (clazz.isAnnotationPresent(c.class)) {
            if (t != null) {
                this.singletonMap.put(classWrapper, t);
            }
        } else if (!clazz.isAnnotationPresent(a.class)) {
            this.mCacher.put(classWrapper, t);
        }
    }
}
