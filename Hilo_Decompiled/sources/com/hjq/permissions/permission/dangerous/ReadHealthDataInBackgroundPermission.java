package com.hjq.permissions.permission.dangerous;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.hjq.permissions.permission.base.BasePermission;
import com.hjq.permissions.permission.base.IPermission;
import ea.f;
import fa.b;
import java.util.List;
import ka.g;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class ReadHealthDataInBackgroundPermission extends HealthDataBasePermission {
    public static final Parcelable.Creator<ReadHealthDataInBackgroundPermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReadHealthDataInBackgroundPermission createFromParcel(Parcel parcel) {
            return new ReadHealthDataInBackgroundPermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ReadHealthDataInBackgroundPermission[] newArray(int i10) {
            return new ReadHealthDataInBackgroundPermission[i10];
        }
    }

    /* synthetic */ ReadHealthDataInBackgroundPermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public List M(Context context) {
        if (!h.g()) {
            return g.b(b.c());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.dangerous.HealthDataBasePermission, com.hjq.permissions.permission.base.BasePermission
    public void g(Activity activity, List list, da.a aVar, List list2, f fVar) {
        super.g(activity, list, aVar, list2, fVar);
        if (h(activity) > BasePermission.B(activity, aVar)) {
            BasePermission.f(list2, "android.permission.BODY_SENSORS_BACKGROUND", 34);
        }
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 35;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void i(Activity activity, List list) {
        super.i(activity, list);
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < list.size(); i13++) {
            IPermission iPermission = (IPermission) list.get(i13);
            if (g.i(iPermission, this)) {
                i11 = i13;
            } else if (g.j(iPermission, "android.permission.health.READ_HEALTH_DATA_HISTORY")) {
                i10 = i13;
            } else if (ka.a.i(iPermission)) {
                i12 = i13;
            }
        }
        if (i10 != -1 && i10 > i11) {
            throw new IllegalArgumentException("Please place the " + x() + "\" permission after the \"android.permission.health.READ_HEALTH_DATA_HISTORY\" permission");
        }
        if (i12 != -1 && i12 > i11) {
            throw new IllegalArgumentException("Please place the \"" + x() + "\" permission after the \"" + list.get(i12) + "\" permission");
        }
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.health.READ_HEALTH_DATA_IN_BACKGROUND";
    }

    private ReadHealthDataInBackgroundPermission(Parcel parcel) {
        super(parcel);
    }
}
