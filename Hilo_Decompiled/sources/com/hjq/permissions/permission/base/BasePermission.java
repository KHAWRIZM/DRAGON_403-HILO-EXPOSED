package com.hjq.permissions.permission.base;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Parcel;
import da.a;
import ea.f;
import ea.h;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import ka.c;
import ka.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class BasePermission implements IPermission {
    /* JADX INFO: Access modifiers changed from: protected */
    public BasePermission() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int B(Context context, a aVar) {
        h hVar;
        int i10;
        if (ka.h.o()) {
            i10 = context.getApplicationInfo().minSdkVersion;
            return i10;
        }
        if (aVar != null && (hVar = aVar.f١٣٦٦١b) != null) {
            return hVar.f١٣٩٩٣a;
        }
        return 17;
    }

    public static int I(Context context, String str) {
        AppOpsManager appOpsManager;
        int unsafeCheckOpNoThrow;
        Object systemService;
        if (ka.h.n()) {
            systemService = context.getSystemService((Class<Object>) AppOpsManager.class);
            appOpsManager = (AppOpsManager) systemService;
        } else {
            appOpsManager = (AppOpsManager) context.getSystemService("appops");
        }
        if (appOpsManager == null) {
            return -1;
        }
        try {
            if (ka.h.c()) {
                unsafeCheckOpNoThrow = appOpsManager.unsafeCheckOpNoThrow(str, context.getApplicationInfo().uid, context.getPackageName());
                return unsafeCheckOpNoThrow;
            }
            return appOpsManager.checkOpNoThrow(str, context.getApplicationInfo().uid, context.getPackageName());
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static int J(Context context, String str, int i10) {
        AppOpsManager appOpsManager;
        Object systemService;
        if (ka.h.n()) {
            systemService = context.getSystemService((Class<Object>) AppOpsManager.class);
            appOpsManager = (AppOpsManager) systemService;
        } else {
            appOpsManager = (AppOpsManager) context.getSystemService("appops");
        }
        if (appOpsManager == null) {
            return -1;
        }
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            try {
                i10 = ((Integer) cls.getDeclaredField(str).get(Integer.class)).intValue();
            } catch (NoSuchFieldException unused) {
            }
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(i10), Integer.valueOf(context.getApplicationInfo().uid), context.getPackageName())).intValue();
        } catch (Exception e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public static boolean P(String str) {
        try {
            Class.forName(AppOpsManager.class.getName()).getDeclaredField(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean V(Activity activity, String str) {
        boolean shouldShowRequestPermissionRationale;
        if (ka.h.a() == 31) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
                e10.printStackTrace();
            }
        }
        shouldShowRequestPermissionRationale = activity.shouldShowRequestPermissionRationale(str);
        return shouldShowRequestPermissionRationale;
    }

    public static boolean a(Context context, String str, int i10, boolean z10) {
        int J = J(context, str, i10);
        if (J == -1) {
            return z10;
        }
        if (J == 0) {
            return true;
        }
        return false;
    }

    public static boolean b(Context context, String str, boolean z10) {
        int I = I(context, str);
        if (I == -1) {
            return z10;
        }
        if (I == 0) {
            return true;
        }
        return false;
    }

    protected static void c(f fVar, String str) {
        d(fVar, str, Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void d(f fVar, String str, int i10) {
        String str2;
        if (fVar != null) {
            int i11 = fVar.f١٣٩٨٧b;
            if (i11 < i10) {
                StringBuilder sb = new StringBuilder();
                sb.append("The AndroidManifest.xml file <uses-permission android:name=\"");
                sb.append(str);
                sb.append("\" android:maxSdkVersion=\"");
                sb.append(i11);
                sb.append("\" /> does not meet the requirements, ");
                if (i10 != Integer.MAX_VALUE) {
                    str2 = "the minimum requirement for maxSdkVersion is " + i10;
                } else {
                    str2 = "please delete the android:maxSdkVersion=\"" + i11 + "\" attribute";
                }
                sb.append(str2);
                throw new IllegalArgumentException(sb.toString());
            }
            return;
        }
        throw new IllegalStateException("Please register permissions in the AndroidManifest.xml file <uses-permission android:name=\"" + str + "\" />");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void e(List list, String str) {
        f(list, str, Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void f(List list, String str, int i10) {
        f fVar;
        if (list != null) {
            fVar = n(list, str);
        } else {
            fVar = null;
        }
        d(fVar, str, i10);
    }

    public static boolean l(Context context, String str) {
        int checkSelfPermission;
        checkSelfPermission = context.checkSelfPermission(str);
        if (checkSelfPermission == 0) {
            return true;
        }
        return false;
    }

    public static f n(List list, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (g.k(fVar.f١٣٩٨٦a, str)) {
                return fVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Intent v() {
        return c.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Intent y() {
        return c.g();
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public /* synthetic */ String D(Context context) {
        return ga.c.f(this, context);
    }

    public /* synthetic */ int E(Context context) {
        return ga.c.b(this, context);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public /* synthetic */ boolean F(Context context) {
        return ga.c.i(this, context);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public /* synthetic */ List G(Context context) {
        return ga.c.a(this, context);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public /* synthetic */ int H(Context context) {
        return ga.c.g(this, context);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public /* synthetic */ List M(Context context) {
        return ga.c.c(this, context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Uri O(Context context) {
        return g.n(context);
    }

    protected abstract boolean S();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof IPermission) {
            return g.i(this, (IPermission) obj);
        }
        if (obj instanceof String) {
            return g.j(this, (String) obj);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Activity activity, List list, a aVar, List list2, f fVar) {
        if (!S()) {
            return;
        }
        c(fVar, x());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(Activity activity, List list) {
    }

    protected void j(Context context) {
        int E = E(context);
        if (ka.h.b(context) >= E) {
            return;
        }
        throw new IllegalStateException("Request \"" + x() + "\" permission, The targetSdkVersion SDK must be " + E + " or more, if you do not want to upgrade targetSdkVersion, please apply with the old permission");
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public /* synthetic */ String k(Context context) {
        return ga.c.d(this, context);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public /* synthetic */ boolean m(Context context) {
        return ga.c.j(this, context);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public /* synthetic */ int o(Context context) {
        return ga.c.e(this, context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Intent p() {
        return c.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Intent r(Context context) {
        return c.b(context, this);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public void s(Activity activity, List list, a aVar) {
        j(activity);
        if (aVar != null) {
            List list2 = aVar.f١٣٦٦٢c;
            g(activity, list, aVar, list2, n(list2, x()));
        }
        i(activity, list);
    }

    public String toString() {
        return x();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public /* synthetic */ boolean z(Context context) {
        return ga.c.h(this, context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BasePermission(Parcel parcel) {
    }
}
