package com.therouter.router;

import a.TheRouterServiceProvideInjecter;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.taobao.accs.messenger.MessengerService;
import com.therouter.Config;
import com.therouter.InnerTheRouterContentProviderKt;
import com.therouter.TheRouter;
import com.therouter.TheRouterKt;
import com.therouter.TheRouterThreadPool;
import com.therouter.inject.DebugOnlyKt;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0017\u0010\u0005\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\t\u001a\u0004\u0018\u00010\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\r\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a\u001b\u0010\t\u001a\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\u000f¢\u0006\u0004\b\t\u0010\u0010\u001a\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001d\u0010 \u001a\u00020\u00002\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001e¢\u0006\u0004\b \u0010!\u001a\u0015\u0010#\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0017¢\u0006\u0004\b#\u0010$\u001a\u000f\u0010&\u001a\u00020%H\u0000¢\u0006\u0004\b&\u0010'\"\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00170(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*\"\u0018\u0010+\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,\"\"\u0010-\u001a\u00020%8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u0010'\"\u0004\b0\u00101\"\u0018\u00102\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103\"\u0017\u00105\u001a\u0002048\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108¨\u00069"}, d2 = {"", "initRouteMap", "()V", "Landroid/content/Context;", "context", "asyncInitRouteMap", "(Landroid/content/Context;)V", "Lcom/therouter/router/RouterMapInitTask;", "task", "setRouteMapInitTask", "(Lcom/therouter/router/RouterMapInitTask;)Lkotlin/Unit;", "Lcom/therouter/router/OnRouteMapChangedListener;", "listener", "setOnRouteMapChangedListener", "(Lcom/therouter/router/OnRouteMapChangedListener;)V", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/content/Intent;", MessengerService.INTENT, "", "foundPathFromIntent", "(Landroid/content/Intent;)Ljava/lang/String;", "url", "Lcom/therouter/router/RouteItem;", "matchRouteMap", "(Ljava/lang/String;)Lcom/therouter/router/RouteItem;", "className", "", "matchRouteMapForClassName", "(Ljava/lang/String;)Ljava/util/List;", "", "routeItemArray", "addRouteMap", "(Ljava/util/Collection;)V", "routeItem", "addRouteItem", "(Lcom/therouter/router/RouteItem;)V", "", "isEmptyRouteMap", "()Z", "Lcom/therouter/router/RegexpKeyedMap;", "ROUTER_MAP", "Lcom/therouter/router/RegexpKeyedMap;", "initTask", "Lcom/therouter/router/RouterMapInitTask;", "initedRouteMap", "Z", "getInitedRouteMap", "setInitedRouteMap", "(Z)V", "onRouteMapChangedListener", "Lcom/therouter/router/OnRouteMapChangedListener;", "Lcom/google/gson/d;", "gson", "Lcom/google/gson/d;", "getGson", "()Lcom/google/gson/d;", "router_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRouteMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RouteMap.kt\ncom/therouter/router/RouteMapKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,230:1\n1#2:231\n1855#3,2:232\n1855#3,2:234\n1855#3,2:236\n*S KotlinDebug\n*F\n+ 1 RouteMap.kt\ncom/therouter/router/RouteMapKt\n*L\n72#1:232,2\n123#1:234,2\n176#1:236,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RouteMapKt {

    @NotNull
    private static final RegexpKeyedMap<RouteItem> ROUTER_MAP = new RegexpKeyedMap<>();

    @NotNull
    private static final com.google.gson.d gson = new com.google.gson.d();

    @Nullable
    private static RouterMapInitTask initTask;
    private static volatile boolean initedRouteMap;

    @Nullable
    private static OnRouteMapChangedListener onRouteMapChangedListener;

    public static final void addRouteItem(@NotNull RouteItem routeItem) {
        Intrinsics.checkNotNullParameter(routeItem, "routeItem");
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            addRouteItem$addRoute(routeItem);
            return;
        }
        synchronized (ROUTER_MAP) {
            addRouteItem$addRoute(routeItem);
        }
    }

    private static final void addRouteItem$addRoute(RouteItem routeItem) {
        String path = routeItem.getPath();
        if (StringsKt.endsWith$default(path, "/", false, 2, (Object) null)) {
            path = path.substring(0, path.length() - 1);
            Intrinsics.checkNotNullExpressionValue(path, "substring(...)");
        }
        TheRouterKt.debugOnly$default("addRouteItem", "add " + path, null, 4, null);
        ROUTER_MAP.put(path, routeItem);
        OnRouteMapChangedListener onRouteMapChangedListener2 = onRouteMapChangedListener;
        if (onRouteMapChangedListener2 != null) {
            onRouteMapChangedListener2.onChanged(routeItem);
        }
    }

    public static final void addRouteMap(@Nullable Collection<RouteItem> collection) {
        if (collection != null && !collection.isEmpty()) {
            Iterator<RouteItem> it = collection.iterator();
            while (it.hasNext()) {
                addRouteItem(it.next());
            }
        }
    }

    public static final void asyncInitRouteMap(@Nullable final Context context) {
        TheRouterThreadPool.execute(new Runnable() { // from class: com.therouter.router.f
            @Override // java.lang.Runnable
            public final void run() {
                RouteMapKt.asyncInitRouteMap$lambda$5(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asyncInitRouteMap$lambda$5(Context context) {
        TheRouterKt.debug$default("RouteMap", "will be add route map from： initDefaultRouteMap()", null, 4, null);
        TheRouterServiceProvideInjecter.initDefaultRouteMap();
        if (!TheRouterServiceProvideInjecter.asm) {
            DebugOnlyKt.getAllDI(context);
            Iterator<T> it = DebugOnlyKt.getRouterMapIndex().iterator();
            while (it.hasNext()) {
                ((IRouterMapAPT) it.next()).init();
            }
        }
        initedRouteMap = true;
        if (initTask == null) {
            initRouteMap();
        } else {
            TheRouterKt.debug$default("RouteMap", "will be add route map from： RouterMapInitTask", null, 4, null);
            RouterMapInitTask routerMapInitTask = initTask;
            if (routerMapInitTask != null) {
                routerMapInitTask.asyncInitRouteMap();
            }
        }
        TheRouterThreadPool.executeInMainThread(new Runnable() { // from class: com.therouter.router.e
            @Override // java.lang.Runnable
            public final void run() {
                NavigatorKt.sendPendingNavigator();
            }
        });
    }

    @Nullable
    public static final String foundPathFromIntent(@NotNull Intent intent) {
        String foundPathFromIntent$foundPath;
        Intrinsics.checkNotNullParameter(intent, MessengerService.INTENT);
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            return foundPathFromIntent$foundPath(intent);
        }
        synchronized (ROUTER_MAP) {
            foundPathFromIntent$foundPath = foundPathFromIntent$foundPath(intent);
        }
        return foundPathFromIntent$foundPath;
    }

    private static final String foundPathFromIntent$foundPath(Intent intent) {
        String str;
        String str2;
        ComponentName component = intent.getComponent();
        if (component != null) {
            str = component.getClassName();
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        Collection<RouteItem> values = ROUTER_MAP.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        for (RouteItem routeItem : values) {
            if (routeItem != null) {
                str2 = routeItem.getClassName();
            } else {
                str2 = null;
            }
            if (Intrinsics.areEqual(str2, str)) {
                return routeItem.getPath();
            }
        }
        RouteItem routeItem2 = new RouteItem(str, str, "", str);
        routeItem2.addAll$router_release(intent.getExtras());
        addRouteItem(routeItem2);
        return str;
    }

    @NotNull
    public static final com.google.gson.d getGson() {
        return gson;
    }

    public static final boolean getInitedRouteMap() {
        return initedRouteMap;
    }

    public static final void initRouteMap() {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(AssetUtilsKt.getStreamFromAssets(InnerTheRouterContentProviderKt.getApplicationContext(), Config.getROUTE_MAP_ASSETS_PATH()), Charset.forName("UTF-8"));
            try {
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb2.append(readLine);
                        sb2.append("\n");
                    }
                    String sb3 = sb2.toString();
                    Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
                    TheRouterKt.debug$default("RouteMap", "will be add route map from assets: " + sb3, null, 4, null);
                    if (!TextUtils.isEmpty(sb3)) {
                        Object k = gson.k(sb3, new TypeToken<List<? extends RouteItem>>() { // from class: com.therouter.router.RouteMapKt$initRouteMap$1$1$list$1
                        }.getType());
                        Intrinsics.checkNotNullExpressionValue(k, "fromJson(...)");
                        addRouteMap((List) k);
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                    CloseableKt.closeFinally(inputStreamReader, (Throwable) null);
                } finally {
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamReader, th);
                    throw th2;
                }
            }
        } catch (Exception e) {
            TheRouterKt.debug("RouteMap", "initRouteMap InputStreamReader error", new Function0<Unit>() { // from class: com.therouter.router.RouteMapKt$initRouteMap$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m١٨٦invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m١٨٦invoke() {
                    e.printStackTrace();
                }
            });
        }
    }

    public static final boolean isEmptyRouteMap() {
        return ROUTER_MAP.isEmpty();
    }

    @Nullable
    public static final RouteItem matchRouteMap(@Nullable String str) {
        RouteItem matchRouteMap$matchRoute;
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            return matchRouteMap$matchRoute(str);
        }
        synchronized (ROUTER_MAP) {
            matchRouteMap$matchRoute = matchRouteMap$matchRoute(str);
        }
        return matchRouteMap$matchRoute;
    }

    private static final RouteItem matchRouteMap$matchRoute(String str) {
        if (str == null) {
            str = "";
        }
        String simpleUrl = TheRouter.build(str).getSimpleUrl();
        RouteItem routeItem = null;
        if (StringsKt.endsWith$default(simpleUrl, "/", false, 2, (Object) null)) {
            simpleUrl = simpleUrl.substring(0, simpleUrl.length() - 1);
            Intrinsics.checkNotNullExpressionValue(simpleUrl, "substring(...)");
        }
        RouteItem routeItem2 = ROUTER_MAP.get((Object) simpleUrl);
        if (routeItem2 != null) {
            routeItem = routeItem2.copy();
        }
        if (routeItem != null) {
            routeItem.setPath(simpleUrl);
        }
        return routeItem;
    }

    @NotNull
    public static final List<RouteItem> matchRouteMapForClassName(@Nullable String str) {
        List<RouteItem> matchRouteMapForClassName$match;
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            return matchRouteMapForClassName$match(str);
        }
        synchronized (ROUTER_MAP) {
            matchRouteMapForClassName$match = matchRouteMapForClassName$match(str);
        }
        return matchRouteMapForClassName$match;
    }

    private static final List<RouteItem> matchRouteMapForClassName$match(String str) {
        ArrayList arrayList = new ArrayList();
        Collection<RouteItem> values = ROUTER_MAP.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        for (RouteItem routeItem : values) {
            if (routeItem != null && Intrinsics.areEqual(routeItem.getClassName(), str)) {
                arrayList.add(routeItem.copy());
            }
        }
        return arrayList;
    }

    public static final void setInitedRouteMap(boolean z) {
        initedRouteMap = z;
    }

    public static final void setOnRouteMapChangedListener(@Nullable OnRouteMapChangedListener onRouteMapChangedListener2) {
        onRouteMapChangedListener = onRouteMapChangedListener2;
    }

    @Nullable
    public static final Unit setRouteMapInitTask(@Nullable RouterMapInitTask routerMapInitTask) {
        if (routerMapInitTask == null) {
            return null;
        }
        initTask = routerMapInitTask;
        return Unit.INSTANCE;
    }

    public static final void setRouteMapInitTask(@NotNull final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "task");
        initTask = new RouterMapInitTask() { // from class: com.therouter.router.RouteMapKt$setRouteMapInitTask$2
            @Override // com.therouter.router.RouterMapInitTask
            public void asyncInitRouteMap() {
                function0.invoke();
            }
        };
    }
}
