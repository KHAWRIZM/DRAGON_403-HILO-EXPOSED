package com.hjq.permissions.permission.dangerous;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.hjq.permissions.permission.base.BasePermission;
import com.hjq.permissions.permission.common.DangerousPermission;
import ea.f;
import fa.b;
import java.util.List;
import ka.g;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class NearbyWifiDevicesPermission extends DangerousPermission {
    public static final Parcelable.Creator<NearbyWifiDevicesPermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NearbyWifiDevicesPermission createFromParcel(Parcel parcel) {
            return new NearbyWifiDevicesPermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public NearbyWifiDevicesPermission[] newArray(int i10) {
            return new NearbyWifiDevicesPermission[i10];
        }
    }

    /* synthetic */ NearbyWifiDevicesPermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public List M(Context context) {
        return g.b(b.b());
    }

    @Override // com.hjq.permissions.permission.common.DangerousPermission
    protected boolean W(Activity activity) {
        return b.b().R(activity);
    }

    @Override // com.hjq.permissions.permission.common.DangerousPermission
    protected boolean Y(Context context, boolean z10) {
        return b.b().T(context, z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void g(Activity activity, List list, da.a aVar, List list2, f fVar) {
        String str;
        super.g(activity, list, aVar, list2, fVar);
        if (h(activity) > BasePermission.B(activity, aVar)) {
            BasePermission.f(list2, "android.permission.ACCESS_FINE_LOCATION", 32);
        }
        if (g.d(list, "android.permission.ACCESS_FINE_LOCATION") || fVar == null || fVar.a()) {
            return;
        }
        if (fVar.f١٣٩٨٧b != Integer.MAX_VALUE) {
            str = "android:maxSdkVersion=\"" + fVar.f١٣٩٨٧b + "\" ";
        } else {
            str = "";
        }
        throw new IllegalArgumentException("If your app doesn't use " + fVar.f١٣٩٨٦a + " to get physical location, please change the <uses-permission android:name=\"" + fVar.f١٣٩٨٦a + "\" " + str + "/> node in the manifest file to <uses-permission android:name=\"" + fVar.f١٣٩٨٦a + "\" android:usesPermissionFlags=\"neverForLocation\" " + str + "/> node, if your app need use \"" + fVar.f١٣٩٨٦a + "\" to get physical location, also need to add \"android.permission.ACCESS_FINE_LOCATION\" permissions");
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 33;
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public String k(Context context) {
        if (h.f()) {
            return "nearby_devices_group";
        }
        return "location_group";
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.NEARBY_WIFI_DEVICES";
    }

    private NearbyWifiDevicesPermission(Parcel parcel) {
        super(parcel);
    }
}
