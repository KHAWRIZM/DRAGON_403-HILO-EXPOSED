package com.therouter.inject;

import a.TheRouterServiceProvideInjecter;
import android.content.Context;
import androidx.annotation.Keep;
import com.therouter.TheRouterThreadPool;
import com.therouter.history.HistoryRecorder;
import com.therouter.history.ServiceProviderHistory;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0010\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ;\u0010\r\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00102\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0012\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010\u0013J<\u0010\u0014\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00102\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0012\"\u0004\u0018\u00010\u0001H\u0086\u0002¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\b\u0017J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0010\u0010\u0019\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/therouter/inject/RouterInject;", "", "()V", "mCustomInterceptors", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/therouter/inject/Interceptor;", "mInterceptors", "addInterceptor", "", "factory", "asyncInitRouterInject", "context", "Landroid/content/Context;", "createDI", "T", "tClass", "Ljava/lang/Class;", "params", "", "(Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "get", "clazz", "initServiceProvider", "initServiceProvider$router_release", "privateAddInterceptor", "syncInitRouterInject", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRouterInject.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RouterInject.kt\ncom/therouter/inject/RouterInject\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,88:1\n13309#2,2:89\n*S KotlinDebug\n*F\n+ 1 RouterInject.kt\ncom/therouter/inject/RouterInject\n*L\n51#1:89,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RouterInject {

    @NotNull
    private final CopyOnWriteArrayList<Interceptor> mInterceptors = new CopyOnWriteArrayList<>();

    @NotNull
    private final CopyOnWriteArrayList<Interceptor> mCustomInterceptors = new CopyOnWriteArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asyncInitRouterInject$lambda$0(RouterInject routerInject, Context context) {
        Intrinsics.checkNotNullParameter(routerInject, "this$0");
        routerInject.syncInitRouterInject(context);
    }

    private final <T> T createDI(Class<T> tClass, Object... params) {
        Iterator<Interceptor> it = this.mCustomInterceptors.iterator();
        T t = null;
        while (it.hasNext()) {
            t = (T) it.next().interception(tClass, Arrays.copyOf(params, params.length));
            if (t != null) {
                RouterInjectKt.routerInjectDebugLog$default("mCustomInterceptors::===" + tClass + "===" + t.getClass().getSimpleName() + t.hashCode(), null, 2, null);
                return t;
            }
        }
        Iterator<Interceptor> it2 = this.mInterceptors.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            t = (T) it2.next().interception(tClass, Arrays.copyOf(params, params.length));
            if (t != null) {
                RouterInjectKt.routerInjectDebugLog$default("interception::===" + tClass + "===" + t.getClass().getSimpleName() + t.hashCode(), null, 2, null);
                break;
            }
        }
        return t;
    }

    @Keep
    public final void addInterceptor(@NotNull Interceptor factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.mCustomInterceptors.add(factory);
    }

    public final void asyncInitRouterInject(@Nullable final Context context) {
        TheRouterThreadPool.execute(new Runnable() { // from class: com.therouter.inject.b
            @Override // java.lang.Runnable
            public final void run() {
                RouterInject.asyncInitRouterInject$lambda$0(RouterInject.this, context);
            }
        });
    }

    @Nullable
    public final <T> T get(@NotNull Class<T> clazz, @NotNull Object... params) {
        RecyclerBin recyclerBin;
        RecyclerBin recyclerBin2;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(params, "params");
        String str = "";
        for (Object obj : params) {
            str = ((Object) str) + obj + ", ";
        }
        HistoryRecorder.pushHistory(new ServiceProviderHistory(clazz + ".provider(" + ((Object) str) + ")"));
        recyclerBin = RouterInjectKt.mRecyclerBin;
        T t = (T) recyclerBin.get(clazz, Arrays.copyOf(params, params.length));
        if (t == null && (t = (T) createDI(clazz, Arrays.copyOf(params, params.length))) != null) {
            recyclerBin2 = RouterInjectKt.mRecyclerBin;
            recyclerBin2.put(clazz, t, Arrays.copyOf(params, params.length));
        }
        return t;
    }

    public final void initServiceProvider$router_release(@Nullable Context context) {
        DebugOnlyKt.getAllDI(context);
        this.mInterceptors.addAll(DebugOnlyKt.getServiceProviderIndex());
    }

    @Keep
    public final void privateAddInterceptor(@NotNull Interceptor factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.mInterceptors.add(factory);
    }

    public final void syncInitRouterInject(@Nullable Context context) {
        TheRouterServiceProvideInjecter.trojan();
        if (!TheRouterServiceProvideInjecter.asm) {
            initServiceProvider$router_release(context);
        }
    }
}
