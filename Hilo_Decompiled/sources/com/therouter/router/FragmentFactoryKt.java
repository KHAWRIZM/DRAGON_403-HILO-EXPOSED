package com.therouter.router;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0007\u001a\u00020\u0003H\u0000\u001a\u001a\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\u0007\u001a\u00020\u0003H\u0000\"*\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"sClassCacheMap", "Landroidx/collection/SimpleArrayMap;", "Ljava/lang/ClassLoader;", "", "Ljava/lang/Class;", "instantiate", "Landroidx/fragment/app/Fragment;", "className", "isFragmentClass", "", "loadClass", "loadFragmentClass", "router_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class FragmentFactoryKt {

    @NotNull
    private static final SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> sClassCacheMap = new SimpleArrayMap<>();

    @NotNull
    public static final Fragment instantiate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "className");
        try {
            Fragment newInstance = loadFragmentClass(str).getConstructor(null).newInstance(null);
            Intrinsics.checkNotNull(newInstance);
            return newInstance;
        } catch (IllegalAccessException e) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (InstantiationException e2) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }

    public static final boolean isFragmentClass(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "className");
        try {
            return Fragment.class.isAssignableFrom(loadClass(str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @NotNull
    public static final Class<?> loadClass(@NotNull String str) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(str, "className");
        ClassLoader classLoader = Fragment.class.getClassLoader();
        SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> simpleArrayMap = sClassCacheMap;
        SimpleArrayMap simpleArrayMap2 = (SimpleArrayMap) simpleArrayMap.get(classLoader);
        if (simpleArrayMap2 == null) {
            simpleArrayMap2 = new SimpleArrayMap();
            simpleArrayMap.put(classLoader, simpleArrayMap2);
        }
        Class<?> cls = (Class) simpleArrayMap2.get(str);
        if (cls == null) {
            cls = Class.forName(str, false, classLoader);
            simpleArrayMap2.put(str, cls);
        }
        Intrinsics.checkNotNull(cls);
        return cls;
    }

    @NotNull
    public static final Class<? extends Fragment> loadFragmentClass(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "className");
        try {
            Class loadClass = loadClass(str);
            Intrinsics.checkNotNull(loadClass, "null cannot be cast to non-null type java.lang.Class<out androidx.fragment.app.Fragment?>");
            return loadClass;
        } catch (ClassCastException e) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e);
        } catch (ClassNotFoundException e2) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists", e2);
        }
    }
}
