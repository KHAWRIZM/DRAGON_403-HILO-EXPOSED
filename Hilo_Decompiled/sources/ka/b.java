package ka;

import android.app.Activity;
import android.app.Fragment;
import android.os.Parcelable;
import com.hjq.permissions.permission.base.IPermission;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b {
    public static void a(Activity activity) {
        if (activity != null) {
            if (!activity.isFinishing()) {
                if (!activity.isDestroyed()) {
                    return;
                } else {
                    throw new IllegalStateException("The activity has been destroyed, please manually determine the status of the activity");
                }
            }
            throw new IllegalStateException("The activity has been finishing, please manually determine the status of the activity");
        }
        throw new IllegalArgumentException("The instance of the context must be an activity object");
    }

    public static void b(Fragment fragment) {
        if (fragment.isAdded()) {
            if (!fragment.isRemoving()) {
                return;
            } else {
                throw new IllegalStateException("This app fragment has been removed, please manually determine the status of the app fragment");
            }
        }
        throw new IllegalStateException("This app fragment has no binding added, please manually determine the status of the app fragment");
    }

    public static void c(Activity activity, List list, da.a aVar) {
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                IPermission iPermission = (IPermission) it.next();
                d(iPermission);
                iPermission.s(activity, list, aVar);
            }
            return;
        }
        throw new IllegalArgumentException("The requested permission cannot be empty");
    }

    public static void d(IPermission iPermission) {
        Field field;
        Class<?> cls = iPermission.getClass();
        String name = cls.getName();
        try {
            field = iPermission.getClass().getDeclaredField("CREATOR");
        } catch (NoSuchFieldException e10) {
            e10.printStackTrace();
            field = null;
        }
        if (field != null) {
            try {
                Object obj = field.get(null);
                if (obj instanceof Parcelable.Creator) {
                    Type genericType = field.getGenericType();
                    if (genericType instanceof ParameterizedType) {
                        Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
                        if (actualTypeArguments.length == 1) {
                            Type type = actualTypeArguments[0];
                            if ((type instanceof Class) && cls.isAssignableFrom((Class) type)) {
                                if (((Parcelable.Creator) obj).newArray(0) != null) {
                                    return;
                                }
                                throw new IllegalArgumentException("The newArray method of the CREATOR field in this " + name + " returns an empty value. This method cannot return an empty value");
                            }
                            throw new IllegalArgumentException("The generic type defined in the CREATOR field of this " + name + " is incorrect");
                        }
                        throw new IllegalArgumentException("The number of generics defined in the CREATOR field of this " + name + " can only be one");
                    }
                    throw new IllegalArgumentException("The generic type defined for the CREATOR field in this " + name + " is empty");
                }
                throw new IllegalArgumentException("The CREATOR field in this " + name + " is not of type " + Parcelable.Creator.class.getName());
            } catch (Exception unused) {
                throw new IllegalArgumentException("The CREATOR field in the " + name + " has an access exception. Please modify CREATOR field with \"public static final\"");
            }
        }
        throw new IllegalArgumentException("This permission class does not define the CREATOR field");
    }

    public static void e(androidx.fragment.app.Fragment fragment) {
        if (fragment.isAdded()) {
            if (!fragment.isRemoving()) {
                return;
            } else {
                throw new IllegalStateException("This support fragment has been removed, please manually determine the status of the support fragment");
            }
        }
        throw new IllegalStateException("This support fragment has no binding added, please manually determine the status of the support fragment");
    }
}
