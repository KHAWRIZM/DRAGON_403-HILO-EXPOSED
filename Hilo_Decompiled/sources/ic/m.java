package ic;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class m {
    public static Object a(View view) {
        ViewParent parent;
        Object obj = null;
        if (Build.VERSION.SDK_INT > 28) {
            View rootView = view.getRootView();
            if (rootView != null && (parent = rootView.getParent()) != null) {
                Field declaredField = parent.getClass().getDeclaredField("mAttachInfo");
                declaredField.setAccessible(true);
                obj = declaredField.get(parent);
            }
            return obj;
        }
        Field declaredField2 = View.class.getDeclaredField("mAttachInfo");
        declaredField2.setAccessible(true);
        obj = declaredField2.get(view);
        return obj;
    }

    public static Rect b(View view) {
        Object a10 = a(view);
        if (a10 == null) {
            return null;
        }
        try {
            Field declaredField = a10.getClass().getDeclaredField("mContentInsets");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(a10);
            if (obj instanceof Rect) {
                return (Rect) obj;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static Rect c(View view) {
        Object a10 = a(view);
        if (a10 == null) {
            return null;
        }
        try {
            Field declaredField = a10.getClass().getDeclaredField("mVisibleInsets");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(a10);
            if (obj instanceof Rect) {
                return (Rect) obj;
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
