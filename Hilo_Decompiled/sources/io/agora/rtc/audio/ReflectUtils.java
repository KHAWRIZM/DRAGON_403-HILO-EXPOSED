package io.agora.rtc.audio;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.facebook.internal.security.CertificateUtil;
import io.agora.rtc.internal.Logging;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class ReflectUtils {
    private static final String TAG = "ReflectUtils";

    public static Object safeCallMethod(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr) {
        Method method;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e10) {
            e10.printStackTrace();
            method = null;
        }
        if (method == null) {
            Logging.e(TAG, "cannot  find method:  " + cls.getSimpleName() + InstructionFileId.DOT + str + CertificateUtil.DELIMITER + Arrays.toString(clsArr));
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
            Logging.e(TAG, "cannot  execute method:  " + cls.getSimpleName() + InstructionFileId.DOT + str + CertificateUtil.DELIMITER + Arrays.toString(clsArr));
            return null;
        } catch (InvocationTargetException e12) {
            e12.printStackTrace();
            Logging.e(TAG, "cannot  execute method:  " + cls.getSimpleName() + InstructionFileId.DOT + str + CertificateUtil.DELIMITER + Arrays.toString(clsArr));
            return null;
        }
    }

    public static Class safeFindClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static Method safeGetMethod(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
