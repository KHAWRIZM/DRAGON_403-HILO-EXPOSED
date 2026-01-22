package com.hjq.permissions.permission.dangerous;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.hjq.permissions.permission.base.BasePermission;
import ea.f;
import fa.b;
import java.util.List;
import ka.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class ReadHealthRatePermission extends HealthDataBasePermission {
    public static final Parcelable.Creator<ReadHealthRatePermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReadHealthRatePermission createFromParcel(Parcel parcel) {
            return new ReadHealthRatePermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ReadHealthRatePermission[] newArray(int i10) {
            return new ReadHealthRatePermission[i10];
        }
    }

    /* synthetic */ ReadHealthRatePermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public List M(Context context) {
        return g.b(b.d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.dangerous.HealthDataBasePermission, com.hjq.permissions.permission.base.BasePermission
    public void g(Activity activity, List list, da.a aVar, List list2, f fVar) {
        super.g(activity, list, aVar, list2, fVar);
        if (h(activity) > BasePermission.B(activity, aVar)) {
            BasePermission.f(list2, "android.permission.BODY_SENSORS", 33);
        }
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 34;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.health.READ_HEART_RATE";
    }

    private ReadHealthRatePermission(Parcel parcel) {
        super(parcel);
    }
}
