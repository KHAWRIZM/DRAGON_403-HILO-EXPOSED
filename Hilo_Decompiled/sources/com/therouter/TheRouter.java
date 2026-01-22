package com.therouter;

import a.TheRouterServiceProvideInjecter;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.therouter.flow.Digraph;
import com.therouter.inject.DebugOnlyKt;
import com.therouter.inject.RouterInject;
import com.therouter.router.Navigator;
import com.therouter.router.RouteMapKt;
import com.therouter.router.action.ActionManager;
import com.therouter.router.action.interceptor.ActionInterceptor;
import com.therouter.router.autowired.DefaultIdParser;
import com.therouter.router.autowired.DefaultObjectParser;
import com.therouter.router.autowired.DefaultServiceParser;
import com.therouter.router.autowired.DefaultUrlParser;
import com.therouter.router.interceptor.AutowiredParser;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.codec.language.bm.Languages;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010%\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010\u000f2\b\u0010'\u001a\u0004\u0018\u00010(H\u0007J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u001cH\u0007J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0007J\u0012\u0010+\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010\u000fH\u0007J;\u00100\u001a\u0004\u0018\u0001H1\"\u0004\b\u0000\u001012\f\u00102\u001a\b\u0012\u0004\u0012\u0002H1032\u0016\u00104\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000105\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u00106J\u0012\u00107\u001a\u00020\u00142\b\u00108\u001a\u0004\u0018\u000109H\u0007J\u001a\u00107\u001a\u00020\u00142\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\bH\u0007J\u0012\u0010;\u001a\u00020\u00142\b\u0010<\u001a\u0004\u0018\u00010\u0001H\u0007J\u0012\u0010=\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010>\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010\u000fH\u0007J\u001c\u0010?\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010\u000f2\b\u0010'\u001a\u0004\u0018\u00010(H\u0007J\u0012\u0010@\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010A\u001a\u00020\u00142\b\u0010'\u001a\u0004\u0018\u00010(H\u0007J\u0010\u0010B\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u000fH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\u0007\u0010\n\"\u0004\b\u000b\u0010\fRV\u0010\r\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0002\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u00020!8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0002\u001a\u0004\b#\u0010$¨\u0006D"}, d2 = {"Lcom/therouter/TheRouter;", "", "()V", "digraph", "Lcom/therouter/flow/Digraph;", "getDigraph", "()Lcom/therouter/flow/Digraph;", "isDebug", "", "isDebug$annotations", "()Z", "setDebug", "(Z)V", "logCat", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "tag", "msg", "", "getLogCat$annotations", "getLogCat", "()Lkotlin/jvm/functions/Function2;", "setLogCat", "(Lkotlin/jvm/functions/Function2;)V", "parserList", "Ljava/util/LinkedList;", "Lcom/therouter/router/interceptor/AutowiredParser;", "getParserList$annotations", "getParserList", "()Ljava/util/LinkedList;", "routerInject", "Lcom/therouter/inject/RouterInject;", "getRouterInject$annotations", "getRouterInject", "()Lcom/therouter/inject/RouterInject;", "addActionInterceptor", "action", "interceptor", "Lcom/therouter/router/action/interceptor/ActionInterceptor;", "addAutowiredParser", "parser", "build", "Lcom/therouter/router/Navigator;", "it", "Landroid/content/Intent;", "url", "get", "T", "clazz", "Ljava/lang/Class;", "params", "", "(Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "init", "context", "Landroid/content/Context;", "asyncInitRouterInject", "inject", Languages.ANY, "isRouterAction", "isRouterPath", "removeActionInterceptor", "removeAllInterceptorForKey", "removeAllInterceptorForValue", "runTask", "taskName", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTheRouter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TheRouter.kt\ncom/therouter/TheRouter\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,233:1\n215#2,2:234\n*S KotlinDebug\n*F\n+ 1 TheRouter.kt\ncom/therouter/TheRouter\n*L\n196#1:234,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class TheRouter {
    private static boolean isDebug;

    @NotNull
    public static final TheRouter INSTANCE = new TheRouter();

    @NotNull
    private static final LinkedList<AutowiredParser> parserList = new LinkedList<>();

    @NotNull
    private static final RouterInject routerInject = new RouterInject();

    @NotNull
    private static Function2<? super String, ? super String, Unit> logCat = new Function2<String, String, Unit>() { // from class: com.therouter.TheRouter$logCat$1
        public final void invoke(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(str2, "<anonymous parameter 1>");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((String) obj, (String) obj2);
            return Unit.INSTANCE;
        }
    };

    @NotNull
    private static final Digraph digraph = new Digraph();

    private TheRouter() {
    }

    @JvmStatic
    public static final void addActionInterceptor(@Nullable String action, @Nullable ActionInterceptor interceptor) {
        ActionManager.INSTANCE.addActionInterceptor$router_release(action, interceptor);
    }

    @JvmStatic
    public static final void addAutowiredParser(@NotNull AutowiredParser parser) {
        Intrinsics.checkNotNullParameter(parser, "parser");
        parserList.addFirst(parser);
    }

    @JvmStatic
    @NotNull
    public static final Navigator build(@Nullable String url) {
        return new Navigator(url);
    }

    @JvmStatic
    @Nullable
    public static final <T> T get(@NotNull Class<T> clazz, @NotNull Object... params) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(params, "params");
        return (T) routerInject.get(clazz, Arrays.copyOf(params, params.length));
    }

    @NotNull
    public static final Function2<String, String, Unit> getLogCat() {
        return logCat;
    }

    @JvmStatic
    public static /* synthetic */ void getLogCat$annotations() {
    }

    @NotNull
    public static final LinkedList<AutowiredParser> getParserList() {
        return parserList;
    }

    @JvmStatic
    public static /* synthetic */ void getParserList$annotations() {
    }

    @NotNull
    public static final RouterInject getRouterInject() {
        return routerInject;
    }

    @JvmStatic
    public static /* synthetic */ void getRouterInject$annotations() {
    }

    @JvmStatic
    public static final void init(@Nullable Context context) {
        init(context, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$1(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(TheRouterLifecycleCallback.INSTANCE);
        }
        LinkedList<AutowiredParser> linkedList = parserList;
        linkedList.addFirst(new DefaultObjectParser());
        linkedList.addFirst(new DefaultServiceParser());
        linkedList.addFirst(new DefaultUrlParser());
        linkedList.addFirst(new DefaultIdParser());
    }

    @JvmStatic
    public static final void inject(@Nullable Object any) {
        TheRouterServiceProvideInjecter.autowiredInject(any);
        if (!TheRouterServiceProvideInjecter.asm && any != null) {
            for (Map.Entry<Class<?>, Method> entry : DebugOnlyKt.getAutowiredIndex().entrySet()) {
                if (entry.getKey().isInstance(any)) {
                    entry.getValue().invoke(null, any);
                }
            }
        }
    }

    public static final boolean isDebug() {
        return isDebug;
    }

    @JvmStatic
    public static /* synthetic */ void isDebug$annotations() {
    }

    @JvmStatic
    public static final boolean isRouterAction(@Nullable String url) {
        return ActionManager.INSTANCE.isAction$router_release(build(url));
    }

    @JvmStatic
    public static final boolean isRouterPath(@Nullable String url) {
        if (RouteMapKt.matchRouteMap(url) != null) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final void removeActionInterceptor(@Nullable String action, @Nullable ActionInterceptor interceptor) {
        ActionManager.INSTANCE.removeActionInterceptor$router_release(action, interceptor);
    }

    @JvmStatic
    public static final void removeAllInterceptorForKey(@Nullable String action) {
        ActionManager.INSTANCE.removeAllInterceptorForKey$router_release(action);
    }

    @JvmStatic
    public static final void removeAllInterceptorForValue(@Nullable ActionInterceptor interceptor) {
        ActionManager.INSTANCE.removeAllInterceptorForValue$router_release(interceptor);
    }

    @JvmStatic
    public static final void runTask(@NotNull final String taskName) {
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Digraph digraph2 = digraph;
        if (digraph2.getInited()) {
            digraph2.getVirtualTask(taskName).run$router_release();
        } else {
            digraph2.addPendingRunnable(new Runnable() { // from class: com.therouter.b
                @Override // java.lang.Runnable
                public final void run() {
                    TheRouter.runTask$lambda$2(taskName);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runTask$lambda$2(String str) {
        Intrinsics.checkNotNullParameter(str, "$taskName");
        digraph.getVirtualTask(str).run$router_release();
    }

    public static final void setDebug(boolean z) {
        isDebug = z;
    }

    public static final void setLogCat(@NotNull Function2<? super String, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        logCat = function2;
    }

    @NotNull
    public final Digraph getDigraph() {
        return digraph;
    }

    @JvmStatic
    @NotNull
    public static final Navigator build(@NotNull Intent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new Navigator(RouteMapKt.foundPathFromIntent(it), it);
    }

    @JvmStatic
    public static final void init(@Nullable final Context context, boolean asyncInitRouterInject) {
        boolean z;
        z = TheRouterKt.inited;
        if (z) {
            return;
        }
        TheRouterKt.debug$default("init", "TheRouter init start!", null, 4, null);
        digraph.beforeInit(context);
        if (asyncInitRouterInject) {
            routerInject.asyncInitRouterInject(context);
        } else {
            routerInject.syncInitRouterInject(context);
        }
        RouteMapKt.asyncInitRouteMap(context);
        TheRouterThreadPool.execute(new Runnable() { // from class: com.therouter.a
            @Override // java.lang.Runnable
            public final void run() {
                TheRouter.init$lambda$1(context);
            }
        });
        TheRouterKt.debug$default("init", "TheRouter init finish!", null, 4, null);
        TheRouterKt.inited = true;
    }
}
