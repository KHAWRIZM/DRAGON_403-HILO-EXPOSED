package com.therouter.router.action;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.therouter.InnerTheRouterContentProviderKt;
import com.therouter.TheRouterKt;
import com.therouter.TheRouterThreadPool;
import com.therouter.history.ActionNavigatorHistory;
import com.therouter.history.HistoryRecorder;
import com.therouter.router.Navigator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\fJ\u001f\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0015J!\u0010\u0016\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\u0017J\u0017\u0010\u0018\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\u0019J\u0017\u0010\u001a\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\u001bR\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/therouter/router/action/ActionManager;", "", "()V", "actionHandleMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/therouter/router/action/interceptor/ActionInterceptor;", "addActionInterceptor", "", "action", "interceptor", "addActionInterceptor$router_release", "handleAction", "navigator", "Lcom/therouter/router/Navigator;", "context", "Landroid/content/Context;", "handleAction$router_release", "isAction", "", "isAction$router_release", "removeActionInterceptor", "removeActionInterceptor$router_release", "removeAllInterceptorForKey", "removeAllInterceptorForKey$router_release", "removeAllInterceptorForValue", "removeAllInterceptorForValue$router_release", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nActionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionManager.kt\ncom/therouter/router/action/ActionManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,117:1\n1#2:118\n1855#3,2:119\n1855#3,2:121\n*S KotlinDebug\n*F\n+ 1 ActionManager.kt\ncom/therouter/router/action/ActionManager\n*L\n51#1:119,2\n96#1:121,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class ActionManager {

    @NotNull
    public static final ActionManager INSTANCE = new ActionManager();

    @NotNull
    private static final ConcurrentHashMap<String, List<com.therouter.router.action.interceptor.ActionInterceptor>> actionHandleMap = new ConcurrentHashMap<>();

    private ActionManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addActionInterceptor$lambda$4(String str, com.therouter.router.action.interceptor.ActionInterceptor actionInterceptor) {
        String simpleUrl = new Navigator(str).getSimpleUrl();
        ConcurrentHashMap<String, List<com.therouter.router.action.interceptor.ActionInterceptor>> concurrentHashMap = actionHandleMap;
        List<com.therouter.router.action.interceptor.ActionInterceptor> list = concurrentHashMap.get(simpleUrl);
        if (list == null) {
            list = new ArrayList<>();
        }
        if (!list.contains(actionInterceptor)) {
            list.add(actionInterceptor);
            Collections.sort(list, new Comparator() { // from class: com.therouter.router.action.e
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int addActionInterceptor$lambda$4$lambda$3;
                    addActionInterceptor$lambda$4$lambda$3 = ActionManager.addActionInterceptor$lambda$4$lambda$3((com.therouter.router.action.interceptor.ActionInterceptor) obj, (com.therouter.router.action.interceptor.ActionInterceptor) obj2);
                    return addActionInterceptor$lambda$4$lambda$3;
                }
            });
            concurrentHashMap.put(simpleUrl, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int addActionInterceptor$lambda$4$lambda$3(com.therouter.router.action.interceptor.ActionInterceptor actionInterceptor, com.therouter.router.action.interceptor.ActionInterceptor actionInterceptor2) {
        if (actionInterceptor == null) {
            return -1;
        }
        if (actionInterceptor2 == null) {
            return 1;
        }
        return actionInterceptor2.getPriority() - actionInterceptor.getPriority();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleAction$lambda$2(Navigator navigator, Context context) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        Context context2;
        Intrinsics.checkNotNullParameter(navigator, "$navigator");
        ArrayList<com.therouter.router.action.interceptor.ActionInterceptor> arrayList = new ArrayList();
        List<com.therouter.router.action.interceptor.ActionInterceptor> list = actionHandleMap.get(navigator.getSimpleUrl());
        if (list != null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList(list);
        } else {
            copyOnWriteArrayList = null;
        }
        Bundle bundle = new Bundle();
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.therouter.router.action.interceptor.ActionInterceptor actionInterceptor = (com.therouter.router.action.interceptor.ActionInterceptor) it.next();
                if (actionInterceptor != null) {
                    actionInterceptor.setArguments$router_release(bundle);
                    HistoryRecorder.pushHistory(new ActionNavigatorHistory(navigator.getUrlWithParams()));
                    if (context == null) {
                        context2 = InnerTheRouterContentProviderKt.getApplicationContext();
                        Intrinsics.checkNotNull(context2);
                    } else {
                        context2 = context;
                    }
                    boolean handle = actionInterceptor.handle(context2, navigator);
                    Bundle args = actionInterceptor.getArgs();
                    arrayList.add(actionInterceptor);
                    if (handle) {
                        bundle = args;
                        break;
                    }
                    bundle = args;
                }
            }
        }
        for (com.therouter.router.action.interceptor.ActionInterceptor actionInterceptor2 : arrayList) {
            actionInterceptor2.setArguments$router_release(bundle);
            actionInterceptor2.onFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeActionInterceptor$lambda$8(String str, com.therouter.router.action.interceptor.ActionInterceptor actionInterceptor) {
        String simpleUrl = new Navigator(str).getSimpleUrl();
        ConcurrentHashMap<String, List<com.therouter.router.action.interceptor.ActionInterceptor>> concurrentHashMap = actionHandleMap;
        List<com.therouter.router.action.interceptor.ActionInterceptor> list = concurrentHashMap.get(simpleUrl);
        if (list != null) {
            list.remove(actionInterceptor);
            concurrentHashMap.put(simpleUrl, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeAllInterceptorForKey$lambda$5(String str) {
        actionHandleMap.remove(new Navigator(str).getSimpleUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeAllInterceptorForValue$lambda$7(com.therouter.router.action.interceptor.ActionInterceptor actionInterceptor) {
        Set<String> keySet = actionHandleMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
        for (String str : keySet) {
            ConcurrentHashMap<String, List<com.therouter.router.action.interceptor.ActionInterceptor>> concurrentHashMap = actionHandleMap;
            List<com.therouter.router.action.interceptor.ActionInterceptor> list = concurrentHashMap.get(str);
            if (list != null) {
                list.remove(actionInterceptor);
                Intrinsics.checkNotNull(str);
                concurrentHashMap.put(str, list);
            }
        }
    }

    public final void addActionInterceptor$router_release(@Nullable final String action, @Nullable final com.therouter.router.action.interceptor.ActionInterceptor interceptor) {
        if (TextUtils.isEmpty(action)) {
            return;
        }
        TheRouterThreadPool.executeInMainThread(new Runnable() { // from class: com.therouter.router.action.b
            @Override // java.lang.Runnable
            public final void run() {
                ActionManager.addActionInterceptor$lambda$4(action, interceptor);
            }
        });
    }

    public final void handleAction$router_release(@NotNull final Navigator navigator, @Nullable final Context context) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        if (TextUtils.isEmpty(navigator.getSimpleUrl())) {
            return;
        }
        TheRouterKt.debug("ActionManager", "handleAction->" + navigator.getUrlWithParams(), new Function0<Unit>() { // from class: com.therouter.router.action.ActionManager$handleAction$1
            public /* bridge */ /* synthetic */ Object invoke() {
                m١٨٧invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m١٨٧invoke() {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                Intrinsics.checkNotNullExpressionValue(stackTrace, "getStackTrace(...)");
                for (StackTraceElement stackTraceElement : stackTrace) {
                    TheRouterKt.debug$default("ActionManager", String.valueOf(stackTraceElement), null, 4, null);
                }
            }
        });
        TheRouterThreadPool.executeInMainThread(new Runnable() { // from class: com.therouter.router.action.a
            @Override // java.lang.Runnable
            public final void run() {
                ActionManager.handleAction$lambda$2(Navigator.this, context);
            }
        });
    }

    public final boolean isAction$router_release(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        if (actionHandleMap.get(navigator.getSimpleUrl()) != null) {
            return true;
        }
        return false;
    }

    public final void removeActionInterceptor$router_release(@Nullable final String action, @Nullable final com.therouter.router.action.interceptor.ActionInterceptor interceptor) {
        if (TextUtils.isEmpty(action)) {
            return;
        }
        TheRouterThreadPool.executeInMainThread(new Runnable() { // from class: com.therouter.router.action.d
            @Override // java.lang.Runnable
            public final void run() {
                ActionManager.removeActionInterceptor$lambda$8(action, interceptor);
            }
        });
    }

    public final void removeAllInterceptorForKey$router_release(@Nullable final String action) {
        if (TextUtils.isEmpty(action)) {
            return;
        }
        TheRouterThreadPool.executeInMainThread(new Runnable() { // from class: com.therouter.router.action.c
            @Override // java.lang.Runnable
            public final void run() {
                ActionManager.removeAllInterceptorForKey$lambda$5(action);
            }
        });
    }

    public final void removeAllInterceptorForValue$router_release(@Nullable final com.therouter.router.action.interceptor.ActionInterceptor interceptor) {
        TheRouterThreadPool.executeInMainThread(new Runnable() { // from class: com.therouter.router.action.f
            @Override // java.lang.Runnable
            public final void run() {
                ActionManager.removeAllInterceptorForValue$lambda$7(com.therouter.router.action.interceptor.ActionInterceptor.this);
            }
        });
    }
}
