package com.hjq.permissions.permission.dangerous;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.hjq.permissions.permission.base.IPermission;
import java.util.List;
import ka.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class ReadHealthDataHistoryPermission extends HealthDataBasePermission {
    public static final Parcelable.Creator<ReadHealthDataHistoryPermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReadHealthDataHistoryPermission createFromParcel(Parcel parcel) {
            return new ReadHealthDataHistoryPermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ReadHealthDataHistoryPermission[] newArray(int i10) {
            return new ReadHealthDataHistoryPermission[i10];
        }
    }

    /* synthetic */ ReadHealthDataHistoryPermission(Parcel parcel, a aVar) {
        this(parcel);
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
        for (int i12 = 0; i12 < list.size(); i12++) {
            IPermission iPermission = (IPermission) list.get(i12);
            if (g.i(iPermission, this)) {
                i11 = i12;
            } else if (ka.a.i(iPermission) && !g.j(iPermission, "android.permission.health.READ_HEALTH_DATA_IN_BACKGROUND")) {
                i10 = i12;
            }
        }
        if (i10 != -1 && i10 > i11) {
            throw new IllegalArgumentException("Please place the \"" + x() + "\" permission after the \"" + list.get(i10) + "\" permission");
        }
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.health.READ_HEALTH_DATA_HISTORY";
    }

    private ReadHealthDataHistoryPermission(Parcel parcel) {
        super(parcel);
    }
}
