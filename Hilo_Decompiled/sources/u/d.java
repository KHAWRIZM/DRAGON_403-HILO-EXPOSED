package u;

import android.app.Activity;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Map;
import tech.sud.gip.logger.SudLogger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f١٨٢١٦a = "SudGIP ".concat(d.class.getSimpleName());

    public static Object a() {
        Object obj;
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            obj = declaredField.get(null);
        } catch (Exception e10) {
            SudLogger.e(f١٨٢١٦a, "getActivityThreadInActivityThreadStaticField: " + e10.getMessage());
            obj = null;
        }
        if (obj != null) {
            return obj;
        }
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", null).invoke(null, null);
        } catch (Exception e11) {
            SudLogger.e(f١٨٢١٦a, "getActivityThreadInActivityThreadStaticMethod: " + e11.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Activity b() {
        Activity activity;
        Object a10;
        LinkedList<Activity> linkedList = new LinkedList();
        try {
            a10 = a();
        } catch (Exception e10) {
            e = e10;
            activity = null;
        }
        if (a10 != null) {
            Field declaredField = a10.getClass().getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(a10);
            if (obj instanceof Map) {
                activity = null;
                for (Object obj2 : ((Map) obj).values()) {
                    try {
                        Class<?> cls = obj2.getClass();
                        Field declaredField2 = cls.getDeclaredField("activity");
                        declaredField2.setAccessible(true);
                        Activity activity2 = (Activity) declaredField2.get(obj2);
                        if (activity == null) {
                            Field declaredField3 = cls.getDeclaredField("paused");
                            declaredField3.setAccessible(true);
                            if (!declaredField3.getBoolean(obj2)) {
                                activity = activity2;
                            } else {
                                linkedList.addFirst(activity2);
                            }
                        } else {
                            linkedList.addFirst(activity2);
                        }
                    } catch (Exception e11) {
                        e = e11;
                        SudLogger.e(f١٨٢١٦a, "getActivitiesByReflect: " + e.getMessage());
                        if (activity != null) {
                        }
                        while (r0.hasNext()) {
                        }
                        return null;
                    }
                }
                if (activity != null) {
                    linkedList.addFirst(activity);
                }
            }
        }
        for (Activity activity3 : linkedList) {
            if (activity3 != null && !activity3.isFinishing() && !activity3.isDestroyed()) {
                return activity3;
            }
        }
        return null;
    }
}
