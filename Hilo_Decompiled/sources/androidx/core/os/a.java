package androidx.core.os;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a {

    /* renamed from: androidx.core.os.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class C٠٠٢٥a {
        static Object a(Bundle bundle, String str, Class cls) {
            return bundle.getParcelable(str, cls);
        }

        static Object[] b(Bundle bundle, String str, Class cls) {
            return bundle.getParcelableArray(str, cls);
        }

        static ArrayList c(Bundle bundle, String str, Class cls) {
            return bundle.getParcelableArrayList(str, cls);
        }

        static Serializable d(Bundle bundle, String str, Class cls) {
            return bundle.getSerializable(str, cls);
        }

        static SparseArray e(Bundle bundle, String str, Class cls) {
            return bundle.getSparseParcelableArray(str, cls);
        }
    }

    public static Object a(Bundle bundle, String str, Class cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return C٠٠٢٥a.a(bundle, str, cls);
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (!cls.isInstance(parcelable)) {
            return null;
        }
        return parcelable;
    }

    public static Parcelable[] b(Bundle bundle, String str, Class cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return (Parcelable[]) C٠٠٢٥a.b(bundle, str, cls);
        }
        return bundle.getParcelableArray(str);
    }

    public static ArrayList c(Bundle bundle, String str, Class cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return C٠٠٢٥a.c(bundle, str, cls);
        }
        return bundle.getParcelableArrayList(str);
    }

    public static Serializable d(Bundle bundle, String str, Class cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return C٠٠٢٥a.d(bundle, str, cls);
        }
        Serializable serializable = bundle.getSerializable(str);
        if (!cls.isInstance(serializable)) {
            return null;
        }
        return serializable;
    }

    public static SparseArray e(Bundle bundle, String str, Class cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return C٠٠٢٥a.e(bundle, str, cls);
        }
        return bundle.getSparseParcelableArray(str);
    }
}
