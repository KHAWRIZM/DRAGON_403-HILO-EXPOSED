package com.hjq.permissions.permission.dangerous;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.hjq.permissions.permission.base.BasePermission;
import com.hjq.permissions.permission.common.DangerousPermission;
import ea.f;
import java.util.List;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class BluetoothAdvertisePermission extends DangerousPermission {
    public static final Parcelable.Creator<BluetoothAdvertisePermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BluetoothAdvertisePermission createFromParcel(Parcel parcel) {
            return new BluetoothAdvertisePermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BluetoothAdvertisePermission[] newArray(int i10) {
            return new BluetoothAdvertisePermission[i10];
        }
    }

    /* synthetic */ BluetoothAdvertisePermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.BasePermission
    public int E(Context context) {
        return 23;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void g(Activity activity, List list, da.a aVar, List list2, f fVar) {
        super.g(activity, list, aVar, list2, fVar);
        if (h(activity) > BasePermission.B(activity, aVar)) {
            BasePermission.f(list2, "android.permission.BLUETOOTH_ADMIN", 30);
        }
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 31;
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public String k(Context context) {
        if (h.e()) {
            return "nearby_devices_group";
        }
        return "location_group";
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.BLUETOOTH_ADVERTISE";
    }

    private BluetoothAdvertisePermission(Parcel parcel) {
        super(parcel);
    }
}
