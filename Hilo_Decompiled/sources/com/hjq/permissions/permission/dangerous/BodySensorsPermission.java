package com.hjq.permissions.permission.dangerous;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.hjq.permissions.permission.common.DangerousPermission;
import java.util.List;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class BodySensorsPermission extends DangerousPermission {
    public static final Parcelable.Creator<BodySensorsPermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BodySensorsPermission createFromParcel(Parcel parcel) {
            return new BodySensorsPermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BodySensorsPermission[] newArray(int i10) {
            return new BodySensorsPermission[i10];
        }
    }

    /* synthetic */ BodySensorsPermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 23;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void i(Activity activity, List list) {
        super.i(activity, list);
        if (h.b(activity) < 36) {
            return;
        }
        throw new IllegalArgumentException("When the project targetSdkVersion is greater than or equal to 36, the \"" + x() + "\" permission cannot be requested, but the \"android.permission.health.READ_HEART_RATE\" permission should be requested instead");
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public String k(Context context) {
        return "sensors_group";
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.BODY_SENSORS";
    }

    public BodySensorsPermission() {
    }

    private BodySensorsPermission(Parcel parcel) {
        super(parcel);
    }
}
