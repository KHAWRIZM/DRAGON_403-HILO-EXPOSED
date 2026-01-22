package ca;

import android.app.Activity;
import android.view.Display;
import android.view.WindowManager;
import java.util.HashMap;
import java.util.Map;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f٦٠١٦a = new HashMap();

    private static int a(Activity activity) {
        return activity.hashCode();
    }

    private static boolean b(Activity activity) {
        Display display;
        if (h.d()) {
            display = activity.getDisplay();
        } else {
            WindowManager windowManager = activity.getWindowManager();
            if (windowManager != null) {
                display = windowManager.getDefaultDisplay();
            } else {
                display = null;
            }
        }
        if (display == null) {
            return false;
        }
        int rotation = display.getRotation();
        if (rotation != 2 && rotation != 3) {
            return false;
        }
        return true;
    }

    public static synchronized void c(Activity activity) {
        int i10;
        synchronized (b.class) {
            try {
            } catch (IllegalStateException e10) {
                e10.printStackTrace();
            } finally {
            }
            if (activity.getRequestedOrientation() != -1) {
                return;
            }
            int i11 = activity.getResources().getConfiguration().orientation;
            int i12 = 1;
            if (i11 != 1) {
                if (i11 == 2) {
                    if (b(activity)) {
                        i10 = 8;
                    } else {
                        i10 = 0;
                    }
                    activity.setRequestedOrientation(i10);
                    f٦٠١٦a.put(Integer.valueOf(a(activity)), Integer.valueOf(i10));
                }
            } else {
                if (b(activity)) {
                    i12 = 9;
                }
                activity.setRequestedOrientation(i12);
                f٦٠١٦a.put(Integer.valueOf(a(activity)), Integer.valueOf(i12));
            }
        }
    }

    public static synchronized void d(Activity activity) {
        synchronized (b.class) {
            if (activity.getRequestedOrientation() == -1) {
                return;
            }
            Integer num = (Integer) f٦٠١٦a.get(Integer.valueOf(a(activity)));
            if (num == null) {
                return;
            }
            if (num.intValue() == -1) {
                return;
            }
            activity.setRequestedOrientation(-1);
        }
    }
}
