package com.oudi.utils;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0005J&\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/oudi/utils/ClassUtils;", "", "<init>", "()V", "getSuperClassGenericType", "Ljava/lang/Class;", "T", "clazz", FirebaseAnalytics.Param.INDEX, "", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ClassUtils {
    public static final ClassUtils INSTANCE = new ClassUtils();

    private ClassUtils() {
    }

    public final <T> Class<T> getSuperClassGenericType(Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return getSuperClassGenericType(clazz, 0);
    }

    public final <T> Class<T> getSuperClassGenericType(Class<?> clazz, int index) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Type genericSuperclass = clazz.getGenericSuperclass();
        while (!(genericSuperclass instanceof ParameterizedType)) {
            clazz = clazz.getSuperclass();
            if (clazz != null) {
                genericSuperclass = clazz.getGenericSuperclass();
            } else {
                throw new IllegalArgumentException("Required value was null.");
            }
        }
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        if (index < actualTypeArguments.length && index >= 0) {
            Type type = actualTypeArguments[index];
            if (type instanceof Class) {
                Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<T of com.oudi.utils.ClassUtils.getSuperClassGenericType>");
                return (Class) type;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException("Failed requirement.");
    }
}
