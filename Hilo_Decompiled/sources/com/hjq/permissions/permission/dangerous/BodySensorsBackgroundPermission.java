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
public final class BodySensorsBackgroundPermission extends DangerousPermission {
    public static final Parcelable.Creator<BodySensorsBackgroundPermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BodySensorsBackgroundPermission createFromParcel(Parcel parcel) {
            return new BodySensorsBackgroundPermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BodySensorsBackgroundPermission[] newArray(int i10) {
            return new BodySensorsBackgroundPermission[i10];
        }
    }

    /* synthetic */ BodySensorsBackgroundPermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public List G(Context context) {
        return g.b(b.d());
    }

    @Override // com.hjq.permissions.permission.common.DangerousPermission
    protected boolean W(Activity activity) {
        return b.d().R(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.common.DangerousPermission
    public boolean X(Activity activity) {
        if (!b.d().F(activity)) {
            return b.d().R(activity);
        }
        return super.X(activity);
    }

    @Override // com.hjq.permissions.permission.common.DangerousPermission
    protected boolean Y(Context context, boolean z10) {
        return b.d().T(context, z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.common.DangerousPermission
    public boolean Z(Context context, boolean z10) {
        if (!b.d().T(context, z10)) {
            return false;
        }
        return super.Z(context, z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void g(Activity activity, List list, da.a aVar, List list2, f fVar) {
        super.g(activity, list, aVar, list2, fVar);
        BasePermission.e(list2, "android.permission.BODY_SENSORS");
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 33;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void i(Activity activity, List list) {
        super.i(activity, list);
        if (h.b(activity) < 36) {
            if (g.d(list, "android.permission.BODY_SENSORS")) {
                int i10 = -1;
                int i11 = -1;
                for (int i12 = 0; i12 < list.size(); i12++) {
                    IPermission iPermission = (IPermission) list.get(i12);
                    if (g.i(iPermission, this)) {
                        i11 = i12;
                    } else if (g.j(iPermission, "android.permission.BODY_SENSORS")) {
                        i10 = i12;
                    }
                }
                if (i10 != -1 && i10 > i11) {
                    throw new IllegalArgumentException("Please place the " + x() + "\" permission after the \"android.permission.BODY_SENSORS\" permission");
                }
                return;
            }
            throw new IllegalArgumentException("Applying for background sensor permissions must contain \"android.permission.BODY_SENSORS\"");
        }
        throw new IllegalArgumentException("When the project targetSdkVersion is greater than or equal to 36, the \"" + x() + "\" permission cannot be requested, but the \"android.permission.health.READ_HEALTH_DATA_IN_BACKGROUND\" permission should be requested instead");
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public String k(Context context) {
        return "sensors_group";
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
        return "android.permission.BODY_SENSORS_BACKGROUND";
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public boolean z(Context context) {
        return true;
    }

    public BodySensorsBackgroundPermission() {
    }

    private BodySensorsBackgroundPermission(Parcel parcel) {
        super(parcel);
    }
}
