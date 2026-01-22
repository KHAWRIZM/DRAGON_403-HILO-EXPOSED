package com.google.protobuf;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class g0 extends com.google.protobuf.b {

    /* renamed from: a, reason: collision with root package name */
    private static Map f١١٠٠٧a = new ConcurrentHashMap();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a extends s {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    protected static final class b implements Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        private final Class f١١٠٠٨a;

        /* renamed from: b, reason: collision with root package name */
        private final String f١١٠٠٩b;

        /* renamed from: c, reason: collision with root package name */
        private final byte[] f١١٠١٠c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(e1 e1Var) {
            Class<?> cls = e1Var.getClass();
            this.f١١٠٠٨a = cls;
            this.f١١٠٠٩b = cls.getName();
            this.f١١٠١٠c = e1Var.toByteArray();
        }

        private Object a() {
            try {
                Field declaredField = b().getDeclaredField("defaultInstance");
                declaredField.setAccessible(true);
                return ((e1) declaredField.get(null)).newBuilderForType().mergeFrom(this.f١١٠١٠c).buildPartial();
            } catch (k0 e10) {
                throw new RuntimeException("Unable to understand proto buffer", e10);
            } catch (ClassNotFoundException e11) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.f١١٠٠٩b, e11);
            } catch (IllegalAccessException e12) {
                throw new RuntimeException("Unable to call parsePartialFrom", e12);
            } catch (NoSuchFieldException e13) {
                throw new RuntimeException("Unable to find defaultInstance in " + this.f١١٠٠٩b, e13);
            } catch (SecurityException e14) {
                throw new RuntimeException("Unable to call defaultInstance in " + this.f١١٠٠٩b, e14);
            }
        }

        private Class b() {
            Class cls = this.f١١٠٠٨a;
            if (cls == null) {
                return Class.forName(this.f١١٠٠٩b);
            }
            return cls;
        }

        protected Object readResolve() throws ObjectStreamException {
            try {
                Field declaredField = b().getDeclaredField("DEFAULT_INSTANCE");
                declaredField.setAccessible(true);
                return ((e1) declaredField.get(null)).newBuilderForType().mergeFrom(this.f١١٠١٠c).buildPartial();
            } catch (k0 e10) {
                throw new RuntimeException("Unable to understand proto buffer", e10);
            } catch (ClassNotFoundException e11) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.f١١٠٠٩b, e11);
            } catch (IllegalAccessException e12) {
                throw new RuntimeException("Unable to call parsePartialFrom", e12);
            } catch (NoSuchFieldException unused) {
                return a();
            } catch (SecurityException e13) {
                throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.f١١٠٠٩b, e13);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g0 b(Class cls) {
        androidx.appcompat.app.a0.a(f١١٠٠٧a.get(cls));
        try {
            Class.forName(cls.getName(), true, cls.getClassLoader());
            androidx.appcompat.app.a0.a(f١١٠٠٧a.get(cls));
            androidx.appcompat.app.a0.a(p2.l(cls));
            throw null;
        } catch (ClassNotFoundException e10) {
            throw new IllegalStateException("Class initialization cannot fail.", e10);
        }
    }
}
