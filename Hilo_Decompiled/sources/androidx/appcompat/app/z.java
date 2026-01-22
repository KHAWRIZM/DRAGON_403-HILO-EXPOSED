package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class z {

    /* renamed from: a, reason: collision with root package name */
    private static Field f٨١١a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f٨١٢b;

    /* renamed from: c, reason: collision with root package name */
    private static Class f٨١٣c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f٨١٤d;

    /* renamed from: e, reason: collision with root package name */
    private static Field f٨١٥e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f٨١٦f;

    /* renamed from: g, reason: collision with root package name */
    private static Field f٨١٧g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f٨١٨h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Resources resources) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            return;
        }
        if (i10 >= 24) {
            d(resources);
        } else if (i10 >= 23) {
            c(resources);
        } else {
            b(resources);
        }
    }

    private static void b(Resources resources) {
        Map map;
        if (!f٨١٢b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f٨١١a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e10);
            }
            f٨١٢b = true;
        }
        Field field = f٨١١a;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e11) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e11);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void c(Resources resources) {
        Object obj;
        if (!f٨١٢b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f٨١١a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e10);
            }
            f٨١٢b = true;
        }
        Field field = f٨١١a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e11) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e11);
            }
            if (obj != null) {
                return;
            }
            e(obj);
            return;
        }
        obj = null;
        if (obj != null) {
        }
    }

    private static void d(Resources resources) {
        Object obj;
        if (!f٨١٨h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f٨١٧g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e10);
            }
            f٨١٨h = true;
        }
        Field field = f٨١٧g;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e11) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e11);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f٨١٢b) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f٨١١a = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e12) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e12);
            }
            f٨١٢b = true;
        }
        Field field2 = f٨١١a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e13) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e13);
            }
        }
        if (obj2 != null) {
            e(obj2);
        }
    }

    private static void e(Object obj) {
        LongSparseArray longSparseArray;
        if (!f٨١٤d) {
            try {
                f٨١٣c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e10) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e10);
            }
            f٨١٤d = true;
        }
        Class cls = f٨١٣c;
        if (cls == null) {
            return;
        }
        if (!f٨١٦f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f٨١٥e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e11) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e11);
            }
            f٨١٦f = true;
        }
        Field field = f٨١٥e;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e12) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e12);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }
}
