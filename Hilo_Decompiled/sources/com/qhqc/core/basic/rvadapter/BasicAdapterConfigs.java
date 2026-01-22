package com.qhqc.core.basic.rvadapter;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012R@\u0010\u0016\u001a.\u0012\u0004\u0012\u00020\u0014\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0013j\u0016\u0012\u0004\u0012\u00020\u0014\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004`\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/qhqc/core/basic/rvadapter/BasicAdapterConfigs;", "", "<init>", "()V", "Ljava/lang/Class;", "Lcom/qhqc/core/basic/rvadapter/IBasicAdapterStateView;", "clazz", "", "registerStateView", "(Ljava/lang/Class;)V", "Lcom/qhqc/core/basic/rvadapter/IBasicAdapterStateViewEmpty;", "getStatViewEmpty", "()Lcom/qhqc/core/basic/rvadapter/IBasicAdapterStateViewEmpty;", "Lcom/qhqc/core/basic/rvadapter/d;", "getStatViewLoading", "()Lcom/qhqc/core/basic/rvadapter/d;", "Lcom/qhqc/core/basic/rvadapter/IBasicAdapterStateViewError;", "getStatViewError", "()Lcom/qhqc/core/basic/rvadapter/IBasicAdapterStateViewError;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "defStateViewsImpl", "Ljava/util/HashMap;", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BasicAdapterConfigs {

    @NotNull
    public static final BasicAdapterConfigs INSTANCE = new BasicAdapterConfigs();

    @NotNull
    private static final HashMap<Integer, Class<? extends IBasicAdapterStateView>> defStateViewsImpl = new HashMap<>();

    private BasicAdapterConfigs() {
    }

    @Nullable
    public final IBasicAdapterStateViewEmpty getStatViewEmpty() {
        Class<? extends IBasicAdapterStateView> cls;
        HashMap<Integer, Class<? extends IBasicAdapterStateView>> hashMap = defStateViewsImpl;
        if (hashMap.containsKey(2) && (cls = hashMap.get(2)) != null) {
            try {
                Constructor<? extends IBasicAdapterStateView> declaredConstructor = cls.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                IBasicAdapterStateView newInstance = declaredConstructor.newInstance(null);
                if (!(newInstance instanceof IBasicAdapterStateViewEmpty)) {
                    return null;
                }
                return (IBasicAdapterStateViewEmpty) newInstance;
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    @Nullable
    public final IBasicAdapterStateViewError getStatViewError() {
        Class<? extends IBasicAdapterStateView> cls;
        HashMap<Integer, Class<? extends IBasicAdapterStateView>> hashMap = defStateViewsImpl;
        if (hashMap.containsKey(3) && (cls = hashMap.get(3)) != null) {
            try {
                Constructor<? extends IBasicAdapterStateView> declaredConstructor = cls.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                IBasicAdapterStateView newInstance = declaredConstructor.newInstance(null);
                if (!(newInstance instanceof IBasicAdapterStateViewError)) {
                    return null;
                }
                return (IBasicAdapterStateViewError) newInstance;
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    @Nullable
    public final d getStatViewLoading() {
        Class<? extends IBasicAdapterStateView> cls;
        HashMap<Integer, Class<? extends IBasicAdapterStateView>> hashMap = defStateViewsImpl;
        if (hashMap.containsKey(1) && (cls = hashMap.get(1)) != null) {
            try {
                Constructor<? extends IBasicAdapterStateView> declaredConstructor = cls.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                IBasicAdapterStateView newInstance = declaredConstructor.newInstance(null);
                if (!(newInstance instanceof d)) {
                    return null;
                }
                return (d) newInstance;
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    public final void registerStateView(@NotNull Class<? extends IBasicAdapterStateView> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (IBasicAdapterStateViewEmpty.class.isAssignableFrom(clazz)) {
            defStateViewsImpl.put(2, clazz);
        } else if (d.class.isAssignableFrom(clazz)) {
            defStateViewsImpl.put(1, clazz);
        } else if (IBasicAdapterStateViewError.class.isAssignableFrom(clazz)) {
            defStateViewsImpl.put(3, clazz);
        }
    }
}
