package com.therouter.inject;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.therouter.TheRouterKt;
import com.therouter.router.IRouterMapAPT;
import dalvik.system.DexFile;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0000\u001a,\u0010\u0017\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\t0\u0007j\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\t`\nH\u0000\u001a\u0018\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010H\u0000\u001a\u0018\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u000ej\b\u0012\u0004\u0012\u00020\u0012`\u0010H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"2\u0010\u0006\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\t0\u0007j\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u000ej\b\u0012\u0004\u0012\u00020\u0012`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"PACKAGE", "", "PREFIX_ROUTER_MAP", "PREFIX_SERVICE_PROVIDER", "SUFFIX_AUTOWIRED", "SUFFIX_AUTOWIRED_DOT_CLASS", "autowiredIndex", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Ljava/lang/reflect/Method;", "Lkotlin/collections/HashMap;", "inited", "", "routerMapIndex", "Ljava/util/ArrayList;", "Lcom/therouter/router/IRouterMapAPT;", "Lkotlin/collections/ArrayList;", "serviceProviderIndex", "Lcom/therouter/inject/Interceptor;", "getAllDI", "", "context", "Landroid/content/Context;", "getAutowiredIndex", "getRouterMapIndex", "getServiceProviderIndex", "router_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class DebugOnlyKt {

    @NotNull
    public static final String PACKAGE = "a";

    @NotNull
    public static final String PREFIX_ROUTER_MAP = "RouterMap__TheRouter__";

    @NotNull
    public static final String PREFIX_SERVICE_PROVIDER = "ServiceProvider__TheRouter__";

    @NotNull
    public static final String SUFFIX_AUTOWIRED = "__TheRouter__Autowired";

    @NotNull
    public static final String SUFFIX_AUTOWIRED_DOT_CLASS = "__TheRouter__Autowired.class";

    @NotNull
    private static final ArrayList<Interceptor> serviceProviderIndex = new ArrayList<>();

    @NotNull
    private static final ArrayList<IRouterMapAPT> routerMapIndex = new ArrayList<>();

    @NotNull
    private static final HashMap<Class<?>, Method> autowiredIndex = new HashMap<>();
    private static volatile int inited = -1;

    public static final void getAllDI(@Nullable Context context) {
        Enumeration<String> entries;
        if (context != null && inited < 0) {
            inited = 0;
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
                Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
                entries = new DexFile(applicationInfo.sourceDir).entries();
            } catch (Exception e) {
                TheRouterKt.debug("RouterInject", "getAllDI error", new Function0<Unit>() { // from class: com.therouter.inject.DebugOnlyKt$getAllDI$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m١٧٦invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m١٧٦invoke() {
                        e.printStackTrace();
                    }
                });
                return;
            }
            while (entries.hasMoreElements()) {
                String nextElement = entries.nextElement();
                Intrinsics.checkNotNull(nextElement);
                if (StringsKt.startsWith$default(nextElement, "a.ServiceProvider__TheRouter__", false, 2, (Object) null) && !StringsKt.contains$default(nextElement, "$", false, 2, (Object) null)) {
                    try {
                        Class<?> cls = Class.forName(nextElement);
                        if (Interceptor.class.isAssignableFrom(cls) && !Intrinsics.areEqual(Interceptor.class, cls)) {
                            ArrayList<Interceptor> arrayList = serviceProviderIndex;
                            Object newInstance = cls.newInstance();
                            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.therouter.inject.Interceptor");
                            arrayList.add((Interceptor) newInstance);
                        }
                    } catch (Exception e2) {
                        TheRouterKt.debug("RouterInject", "create class error for " + nextElement, new Function0<Unit>() { // from class: com.therouter.inject.DebugOnlyKt$getAllDI$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m١٧٣invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: collision with other method in class */
                            public final void m١٧٣invoke() {
                                e2.printStackTrace();
                            }
                        });
                    }
                } else if (StringsKt.startsWith$default(nextElement, "a.RouterMap__TheRouter__", false, 2, (Object) null) && !StringsKt.contains$default(nextElement, "$", false, 2, (Object) null)) {
                    try {
                        Class<?> cls2 = Class.forName(nextElement);
                        if (IRouterMapAPT.class.isAssignableFrom(cls2) && !Intrinsics.areEqual(IRouterMapAPT.class, cls2)) {
                            ArrayList<IRouterMapAPT> arrayList2 = routerMapIndex;
                            Object newInstance2 = cls2.newInstance();
                            Intrinsics.checkNotNull(newInstance2, "null cannot be cast to non-null type com.therouter.router.IRouterMapAPT");
                            arrayList2.add((IRouterMapAPT) newInstance2);
                        }
                    } catch (Exception e3) {
                        TheRouterKt.debug("RouterInject", "create class error for " + nextElement, new Function0<Unit>() { // from class: com.therouter.inject.DebugOnlyKt$getAllDI$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m١٧٤invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: collision with other method in class */
                            public final void m١٧٤invoke() {
                                e3.printStackTrace();
                            }
                        });
                    }
                } else if (StringsKt.endsWith$default(nextElement, SUFFIX_AUTOWIRED, false, 2, (Object) null) && !StringsKt.contains$default(nextElement, "$", false, 2, (Object) null)) {
                    try {
                        Class<?> cls3 = Class.forName(nextElement);
                        Class<?> cls4 = Class.forName(StringsKt.replace$default(nextElement, SUFFIX_AUTOWIRED, "", false, 4, (Object) null));
                        HashMap<Class<?>, Method> hashMap = autowiredIndex;
                        Intrinsics.checkNotNull(cls4);
                        Method declaredMethod = cls3.getDeclaredMethod("autowiredInject", Object.class);
                        Intrinsics.checkNotNullExpressionValue(declaredMethod, "getDeclaredMethod(...)");
                        hashMap.put(cls4, declaredMethod);
                    } catch (Exception e4) {
                        TheRouterKt.debug("RouterInject", "create class error for " + nextElement, new Function0<Unit>() { // from class: com.therouter.inject.DebugOnlyKt$getAllDI$3
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m١٧٥invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: collision with other method in class */
                            public final void m١٧٥invoke() {
                                e4.printStackTrace();
                            }
                        });
                    }
                }
                TheRouterKt.debug("RouterInject", "getAllDI error", new Function0<Unit>() { // from class: com.therouter.inject.DebugOnlyKt$getAllDI$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m١٧٦invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m١٧٦invoke() {
                        e.printStackTrace();
                    }
                });
                return;
            }
            inited = 1;
        }
    }

    @NotNull
    public static final HashMap<Class<?>, Method> getAutowiredIndex() {
        return autowiredIndex;
    }

    @NotNull
    public static final ArrayList<IRouterMapAPT> getRouterMapIndex() {
        return routerMapIndex;
    }

    @NotNull
    public static final ArrayList<Interceptor> getServiceProviderIndex() {
        return serviceProviderIndex;
    }
}
