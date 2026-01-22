package com.hjq.permissions.permission.dangerous;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.hjq.permissions.permission.base.BasePermission;
import com.hjq.permissions.permission.base.IPermission;
import com.hjq.permissions.permission.common.DangerousPermission;
import ea.f;
import fa.b;
import java.util.List;
import ka.g;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class AccessBackgroundLocationPermission extends DangerousPermission {
    public static final Parcelable.Creator<AccessBackgroundLocationPermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AccessBackgroundLocationPermission createFromParcel(Parcel parcel) {
            return new AccessBackgroundLocationPermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AccessBackgroundLocationPermission[] newArray(int i10) {
            return new AccessBackgroundLocationPermission[i10];
        }
    }

    /* synthetic */ AccessBackgroundLocationPermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public List G(Context context) {
        if (h.e()) {
            return g.b(b.b(), b.a());
        }
        return g.b(b.b());
    }

    @Override // com.hjq.permissions.permission.common.DangerousPermission
    protected boolean W(Activity activity) {
        return b.b().R(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.common.DangerousPermission
    public boolean X(Activity activity) {
        if (h.e()) {
            if (!b.b().F(activity) && !b.a().F(activity)) {
                if (b.b().R(activity) && b.a().R(activity)) {
                    return true;
                }
                return false;
            }
        } else if (!b.b().F(activity)) {
            return b.b().R(activity);
        }
        return super.X(activity);
    }

    @Override // com.hjq.permissions.permission.common.DangerousPermission
    protected boolean Y(Context context, boolean z10) {
        return b.b().T(context, z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.common.DangerousPermission
    public boolean Z(Context context, boolean z10) {
        if (h.e()) {
            if (!b.b().T(context, z10) && !b.a().T(context, z10)) {
                return false;
            }
        } else if (!b.b().T(context, z10)) {
            return false;
        }
        return super.Z(context, z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void g(Activity activity, List list, da.a aVar, List list2, f fVar) {
        super.g(activity, list, aVar, list2, fVar);
        if (h.b(activity) >= 31) {
            BasePermission.e(list2, "android.permission.ACCESS_COARSE_LOCATION");
            BasePermission.e(list2, "android.permission.ACCESS_FINE_LOCATION");
        } else {
            BasePermission.e(list2, "android.permission.ACCESS_FINE_LOCATION");
        }
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 29;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void i(Activity activity, List list) {
        super.i(activity, list);
        if (h.b(activity) >= 31 && g.d(list, "android.permission.ACCESS_COARSE_LOCATION") && !g.d(list, "android.permission.ACCESS_FINE_LOCATION")) {
            throw new IllegalArgumentException("Applying for background positioning permissions must include \"android.permission.ACCESS_FINE_LOCATION\"");
        }
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < list.size(); i13++) {
            IPermission iPermission = (IPermission) list.get(i13);
            if (g.i(iPermission, this)) {
                i11 = i13;
            } else if (g.j(iPermission, "android.permission.ACCESS_FINE_LOCATION")) {
                i10 = i13;
            } else if (g.j(iPermission, "android.permission.ACCESS_COARSE_LOCATION")) {
                i12 = i13;
            }
        }
        if (i10 != -1 && i10 > i11) {
            throw new IllegalArgumentException("Please place the " + x() + "\" permission after the \"android.permission.ACCESS_FINE_LOCATION\" permission");
        }
        if (i12 != -1 && i12 > i11) {
            throw new IllegalArgumentException("Please place the \"" + x() + "\" permission after the \"android.permission.ACCESS_COARSE_LOCATION\" permission");
        }
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public String k(Context context) {
        return "location_group";
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public int o(Context context) {
        if (m(context)) {
            return 150;
        }
        return 0;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.ACCESS_BACKGROUND_LOCATION";
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public boolean z(Context context) {
        return true;
    }

    private AccessBackgroundLocationPermission(Parcel parcel) {
        super(parcel);
    }
}
