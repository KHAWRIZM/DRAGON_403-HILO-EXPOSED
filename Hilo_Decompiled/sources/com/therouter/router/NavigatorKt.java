package com.therouter.router;

import com.therouter.router.interceptor.InterceptorCallback;
import com.therouter.router.interceptor.NavigationCallback;
import com.therouter.router.interceptor.NavigatorPathFixHandle;
import com.therouter.router.interceptor.PathReplaceInterceptor;
import com.therouter.router.interceptor.RouterInterceptor;
import com.therouter.router.interceptor.RouterReplaceInterceptor;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u001a\u001a\u000e\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u001c\u001a\u000e\u0010(\u001a\u00020!2\u0006\u0010'\u001a\u00020#\u001a\u0010\u0010)\u001a\u00020!2\b\u0010*\u001a\u0004\u0018\u00010\u0014\u001a\u000e\u0010+\u001a\u00020,2\u0006\u0010'\u001a\u00020\u001a\u001a\u000e\u0010-\u001a\u00020,2\u0006\u0010'\u001a\u00020\u001c\u001a\u000e\u0010.\u001a\u00020,2\u0006\u0010'\u001a\u00020#\u001a\u0006\u0010/\u001a\u00020!\u001aJ\u00100\u001a\u00020!2B\u0010'\u001a>\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020!0 ¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020!0\u001e\u001a\u000e\u00100\u001a\u00020!2\u0006\u0010'\u001a\u000204\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"<\u0010\f\u001a*\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rj\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e`\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000\",\u0010\u001d\u001a \u0012\u0004\u0012\u00020\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020!0 \u0012\u0004\u0012\u00020!0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000\"\u0016\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"DEFAULT_REQUEST_CODE", "", "KEY_ACTION", "", "KEY_ANIM_IN", "KEY_ANIM_OUT", "KEY_BUNDLE", "KEY_DESCRIPTION", "KEY_INTENT_FLAGS", "KEY_OBJECT_ACTIVITY", "KEY_OBJECT_NAVIGATOR", "KEY_PATH", "arguments", "Ljava/util/HashMap;", "Ljava/lang/ref/SoftReference;", "", "Lkotlin/collections/HashMap;", "getArguments", "()Ljava/util/HashMap;", "defaultCallback", "Lcom/therouter/router/interceptor/NavigationCallback;", "disposableQueue", "Ljava/util/LinkedList;", "Lcom/therouter/router/PendingNavigator;", "fixHandles", "", "Lcom/therouter/router/interceptor/NavigatorPathFixHandle;", "pathReplaceInterceptors", "Lcom/therouter/router/interceptor/PathReplaceInterceptor;", "routerInterceptor", "Lkotlin/Function2;", "Lcom/therouter/router/RouteItem;", "Lkotlin/Function1;", "", "routerReplaceInterceptors", "Lcom/therouter/router/interceptor/RouterReplaceInterceptor;", "addNavigatorPathFixHandle", "handle", "addPathReplaceInterceptor", "interceptor", "addRouterReplaceInterceptor", "defaultNavigationCallback", "callback", "removeNavigatorPathFixHandle", "", "removePathReplaceInterceptor", "removeRouterReplaceInterceptor", "sendPendingNavigator", "setRouterInterceptor", "Lkotlin/ParameterName;", "name", "routeItem", "Lcom/therouter/router/interceptor/RouterInterceptor;", "router_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nNavigator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Navigator.kt\ncom/therouter/router/NavigatorKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,866:1\n1855#2,2:867\n*S KotlinDebug\n*F\n+ 1 Navigator.kt\ncom/therouter/router/NavigatorKt\n*L\n864#1:867,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class NavigatorKt {
    public static final int DEFAULT_REQUEST_CODE = -1008600;

    @NotNull
    public static final String KEY_ACTION = "therouter_action";

    @NotNull
    public static final String KEY_ANIM_IN = "therouter_intent_animation_in";

    @NotNull
    public static final String KEY_ANIM_OUT = "therouter_intent_animation_out";

    @NotNull
    public static final String KEY_BUNDLE = "therouter_bundle";

    @NotNull
    public static final String KEY_DESCRIPTION = "therouter_description";

    @NotNull
    public static final String KEY_INTENT_FLAGS = "therouter_intent_flags";

    @NotNull
    public static final String KEY_OBJECT_ACTIVITY = "therouter_object_current_activity";

    @NotNull
    public static final String KEY_OBJECT_NAVIGATOR = "therouter_object_navigator";

    @NotNull
    public static final String KEY_PATH = "therouter_path";

    @NotNull
    private static final LinkedList<PendingNavigator> disposableQueue = new LinkedList<>();

    @NotNull
    private static final HashMap<String, SoftReference<Object>> arguments = new HashMap<>();

    @NotNull
    private static final List<NavigatorPathFixHandle> fixHandles = new ArrayList();

    @NotNull
    private static final List<PathReplaceInterceptor> pathReplaceInterceptors = new ArrayList();

    @NotNull
    private static final List<RouterReplaceInterceptor> routerReplaceInterceptors = new ArrayList();

    @NotNull
    private static NavigationCallback defaultCallback = new NavigationCallback();

    @NotNull
    private static Function2<? super RouteItem, ? super Function1<? super RouteItem, Unit>, Unit> routerInterceptor = new Function2<RouteItem, Function1<? super RouteItem, ? extends Unit>, Unit>() { // from class: com.therouter.router.NavigatorKt$routerInterceptor$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((RouteItem) obj, (Function1<? super RouteItem, Unit>) obj2);
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull RouteItem routeItem, @NotNull Function1<? super RouteItem, Unit> function1) {
            Intrinsics.checkNotNullParameter(routeItem, "route");
            Intrinsics.checkNotNullParameter(function1, "callback");
            function1.invoke(routeItem);
        }
    };

    public static final /* synthetic */ NavigationCallback access$getDefaultCallback$p() {
        return defaultCallback;
    }

    public static final /* synthetic */ LinkedList access$getDisposableQueue$p() {
        return disposableQueue;
    }

    public static final /* synthetic */ List access$getFixHandles$p() {
        return fixHandles;
    }

    public static final /* synthetic */ List access$getPathReplaceInterceptors$p() {
        return pathReplaceInterceptors;
    }

    public static final /* synthetic */ Function2 access$getRouterInterceptor$p() {
        return routerInterceptor;
    }

    public static final /* synthetic */ List access$getRouterReplaceInterceptors$p() {
        return routerReplaceInterceptors;
    }

    public static final void addNavigatorPathFixHandle(@NotNull NavigatorPathFixHandle navigatorPathFixHandle) {
        Intrinsics.checkNotNullParameter(navigatorPathFixHandle, "handle");
        List<NavigatorPathFixHandle> list = fixHandles;
        list.add(navigatorPathFixHandle);
        Collections.sort(list, new Comparator() { // from class: com.therouter.router.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int addNavigatorPathFixHandle$lambda$1;
                addNavigatorPathFixHandle$lambda$1 = NavigatorKt.addNavigatorPathFixHandle$lambda$1((NavigatorPathFixHandle) obj, (NavigatorPathFixHandle) obj2);
                return addNavigatorPathFixHandle$lambda$1;
            }
        });
    }

    public static final int addNavigatorPathFixHandle$lambda$1(NavigatorPathFixHandle navigatorPathFixHandle, NavigatorPathFixHandle navigatorPathFixHandle2) {
        if (navigatorPathFixHandle == null) {
            return -1;
        }
        if (navigatorPathFixHandle2 == null) {
            return 1;
        }
        return navigatorPathFixHandle2.getPriority() - navigatorPathFixHandle.getPriority();
    }

    public static final void addPathReplaceInterceptor(@NotNull PathReplaceInterceptor pathReplaceInterceptor) {
        Intrinsics.checkNotNullParameter(pathReplaceInterceptor, "interceptor");
        List<PathReplaceInterceptor> list = pathReplaceInterceptors;
        list.add(pathReplaceInterceptor);
        Collections.sort(list, new Comparator() { // from class: com.therouter.router.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int addPathReplaceInterceptor$lambda$2;
                addPathReplaceInterceptor$lambda$2 = NavigatorKt.addPathReplaceInterceptor$lambda$2((PathReplaceInterceptor) obj, (PathReplaceInterceptor) obj2);
                return addPathReplaceInterceptor$lambda$2;
            }
        });
    }

    public static final int addPathReplaceInterceptor$lambda$2(PathReplaceInterceptor pathReplaceInterceptor, PathReplaceInterceptor pathReplaceInterceptor2) {
        if (pathReplaceInterceptor == null) {
            return -1;
        }
        if (pathReplaceInterceptor2 == null) {
            return 1;
        }
        return pathReplaceInterceptor2.getPriority() - pathReplaceInterceptor.getPriority();
    }

    public static final void addRouterReplaceInterceptor(@NotNull RouterReplaceInterceptor routerReplaceInterceptor) {
        Intrinsics.checkNotNullParameter(routerReplaceInterceptor, "interceptor");
        List<RouterReplaceInterceptor> list = routerReplaceInterceptors;
        list.add(routerReplaceInterceptor);
        Collections.sort(list, new Comparator() { // from class: com.therouter.router.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int addRouterReplaceInterceptor$lambda$3;
                addRouterReplaceInterceptor$lambda$3 = NavigatorKt.addRouterReplaceInterceptor$lambda$3((RouterReplaceInterceptor) obj, (RouterReplaceInterceptor) obj2);
                return addRouterReplaceInterceptor$lambda$3;
            }
        });
    }

    public static final int addRouterReplaceInterceptor$lambda$3(RouterReplaceInterceptor routerReplaceInterceptor, RouterReplaceInterceptor routerReplaceInterceptor2) {
        if (routerReplaceInterceptor == null) {
            return -1;
        }
        if (routerReplaceInterceptor2 == null) {
            return 1;
        }
        return routerReplaceInterceptor2.getPriority() - routerReplaceInterceptor.getPriority();
    }

    public static final void defaultNavigationCallback(@Nullable NavigationCallback navigationCallback) {
        if (navigationCallback != null) {
            defaultCallback = navigationCallback;
        }
    }

    @NotNull
    public static final HashMap<String, SoftReference<Object>> getArguments() {
        return arguments;
    }

    public static final boolean removeNavigatorPathFixHandle(@NotNull NavigatorPathFixHandle navigatorPathFixHandle) {
        Intrinsics.checkNotNullParameter(navigatorPathFixHandle, "interceptor");
        return fixHandles.remove(navigatorPathFixHandle);
    }

    public static final boolean removePathReplaceInterceptor(@NotNull PathReplaceInterceptor pathReplaceInterceptor) {
        Intrinsics.checkNotNullParameter(pathReplaceInterceptor, "interceptor");
        return pathReplaceInterceptors.remove(pathReplaceInterceptor);
    }

    public static final boolean removeRouterReplaceInterceptor(@NotNull RouterReplaceInterceptor routerReplaceInterceptor) {
        Intrinsics.checkNotNullParameter(routerReplaceInterceptor, "interceptor");
        return routerReplaceInterceptors.remove(routerReplaceInterceptor);
    }

    public static final void sendPendingNavigator() {
        Iterator<T> it = disposableQueue.iterator();
        while (it.hasNext()) {
            ((PendingNavigator) it.next()).getAction().invoke();
        }
        disposableQueue.clear();
    }

    public static final void setRouterInterceptor(@NotNull final RouterInterceptor routerInterceptor2) {
        Intrinsics.checkNotNullParameter(routerInterceptor2, "interceptor");
        routerInterceptor = new Function2<RouteItem, Function1<? super RouteItem, ? extends Unit>, Unit>() { // from class: com.therouter.router.NavigatorKt$setRouterInterceptor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((RouteItem) obj, (Function1<? super RouteItem, Unit>) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull RouteItem routeItem, @NotNull final Function1<? super RouteItem, Unit> function1) {
                Intrinsics.checkNotNullParameter(routeItem, "route");
                Intrinsics.checkNotNullParameter(function1, "callback");
                RouterInterceptor.this.process(routeItem, new InterceptorCallback() { // from class: com.therouter.router.NavigatorKt$setRouterInterceptor$1.1
                    @Override // com.therouter.router.interceptor.InterceptorCallback
                    public void onContinue(@NotNull RouteItem routeItem2) {
                        Intrinsics.checkNotNullParameter(routeItem2, "routeItem");
                        function1.invoke(routeItem2);
                    }
                });
            }
        };
    }

    public static final void setRouterInterceptor(@NotNull Function2<? super RouteItem, ? super Function1<? super RouteItem, Unit>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "interceptor");
        routerInterceptor = function2;
    }
}
