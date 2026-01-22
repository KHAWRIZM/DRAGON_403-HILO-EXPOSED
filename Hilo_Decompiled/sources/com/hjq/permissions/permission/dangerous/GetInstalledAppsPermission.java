package com.hjq.permissions.permission.dangerous;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import com.hjq.permissions.permission.base.BasePermission;
import com.hjq.permissions.permission.common.DangerousPermission;
import ea.f;
import java.util.ArrayList;
import java.util.List;
import ka.c;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class GetInstalledAppsPermission extends DangerousPermission {
    public static final Parcelable.Creator<GetInstalledAppsPermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetInstalledAppsPermission createFromParcel(Parcel parcel) {
            return new GetInstalledAppsPermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GetInstalledAppsPermission[] newArray(int i10) {
            return new GetInstalledAppsPermission[i10];
        }
    }

    /* synthetic */ GetInstalledAppsPermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    private static boolean a0() {
        if (!v9.a.q()) {
            return false;
        }
        return BasePermission.P("OP_GET_INSTALLED_APPS");
    }

    private static boolean b0(Context context) {
        int i10;
        if (!v9.a.t()) {
            return false;
        }
        try {
            PermissionInfo permissionInfo = context.getPackageManager().getPermissionInfo("com.samsung.android.permission.GET_APP_LIST", 0);
            if (permissionInfo != null) {
                if (h.r()) {
                    i10 = permissionInfo.getProtection();
                } else {
                    i10 = permissionInfo.protectionLevel & 15;
                }
                if (i10 != 1) {
                    return false;
                }
                return true;
            }
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
        }
        return false;
    }

    private boolean c0(Context context) {
        int i10;
        try {
            PermissionInfo permissionInfo = context.getPackageManager().getPermissionInfo(x(), 0);
            if (permissionInfo != null) {
                if (h.r()) {
                    i10 = permissionInfo.getProtection();
                } else {
                    i10 = permissionInfo.protectionLevel & 15;
                }
                if (i10 == 1) {
                    return true;
                }
                return false;
            }
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
        }
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "oem_installed_apps_runtime_permission_enable") == 1) {
                return true;
            }
            return false;
        } catch (Settings.SettingNotFoundException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public String D(Context context) {
        if (h.n() && !c0(context) && b0(context)) {
            return "com.samsung.android.permission.GET_APP_LIST";
        }
        return super.D(context);
    }

    @Override // com.hjq.permissions.permission.common.DangerousPermission, com.hjq.permissions.permission.base.IPermission
    public List L(Context context, boolean z10) {
        ArrayList arrayList = new ArrayList();
        if ((v9.a.n() && v9.a.o()) || (v9.a.r() && v9.a.s())) {
            arrayList.add(c.m(context));
        }
        arrayList.add(r(context));
        arrayList.add(BasePermission.y());
        arrayList.add(BasePermission.v());
        arrayList.add(p());
        return arrayList;
    }

    @Override // com.hjq.permissions.permission.common.DangerousPermission, com.hjq.permissions.permission.base.IPermission
    public boolean R(Activity activity) {
        if (h.n() && (c0(activity) || b0(activity))) {
            return X(activity);
        }
        if (!h.k() || !v9.a.q() || !a0() || !v9.a.s()) {
            return false;
        }
        return !F(activity);
    }

    @Override // com.hjq.permissions.permission.common.DangerousPermission, com.hjq.permissions.permission.base.IPermission
    public boolean T(Context context, boolean z10) {
        if (h.n() && (c0(context) || b0(context))) {
            return BasePermission.l(context, D(context));
        }
        if (!h.k() || !a0() || !v9.a.s()) {
            return true;
        }
        return BasePermission.a(context, "OP_GET_INSTALLED_APPS", 10022, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void g(Activity activity, List list, da.a aVar, List list2, f fVar) {
        super.g(activity, list, aVar, list2, fVar);
        if (h.b(activity) < 30) {
            return;
        }
        h.d();
        if (BasePermission.n(list2, "android.permission.QUERY_ALL_PACKAGES") == null && aVar.f١٣٦٦٣d.isEmpty()) {
            throw new IllegalStateException("Please register permissions in the AndroidManifest.xml file <uses-permission android:name=\"android.permission.QUERY_ALL_PACKAGES\" />, or add the app package name to the <queries> tag in the AndroidManifest.xml file");
        }
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 17;
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public boolean m(Context context) {
        boolean m10 = super.m(context);
        if (m10) {
            if (h.n() && (c0(context) || b0(context))) {
                return true;
            }
            if (h.k() && v9.a.q() && a0()) {
                return v9.a.s();
            }
        }
        return m10;
    }

    @Override // com.hjq.permissions.permission.common.DangerousPermission, com.hjq.permissions.permission.base.IPermission
    public fa.a q(Context context) {
        if (h.n() && (c0(context) || b0(context))) {
            return fa.a.REQUEST_PERMISSIONS;
        }
        return fa.a.START_ACTIVITY_FOR_RESULT;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "com.android.permission.GET_INSTALLED_APPS";
    }

    private GetInstalledAppsPermission(Parcel parcel) {
        super(parcel);
    }
}
