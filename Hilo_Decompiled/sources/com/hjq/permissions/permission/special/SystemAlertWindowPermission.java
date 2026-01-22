package com.hjq.permissions.permission.special;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import com.hjq.permissions.permission.base.BasePermission;
import com.hjq.permissions.permission.common.SpecialPermission;
import java.util.ArrayList;
import java.util.List;
import ka.c;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SystemAlertWindowPermission extends SpecialPermission {
    public static final Parcelable.Creator<SystemAlertWindowPermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SystemAlertWindowPermission createFromParcel(Parcel parcel) {
            return new SystemAlertWindowPermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SystemAlertWindowPermission[] newArray(int i10) {
            return new SystemAlertWindowPermission[i10];
        }
    }

    /* synthetic */ SystemAlertWindowPermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public List L(Context context, boolean z10) {
        ArrayList arrayList = new ArrayList(7);
        if (h.n()) {
            if (h.d() && !v9.a.m() && v9.a.q() && v9.a.s()) {
                arrayList.add(c.m(context));
            }
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent.setData(O(context));
            arrayList.add(intent);
            arrayList.add(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION"));
        } else if (v9.a.j()) {
            Intent intent2 = new Intent();
            intent2.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
            Intent intent3 = new Intent();
            intent3.setClassName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity");
            if (v9.a.h().startsWith("3.0")) {
                arrayList.add(intent3);
                arrayList.add(intent2);
            } else {
                arrayList.add(intent2);
                arrayList.add(intent3);
            }
            arrayList.addAll(c.f(context));
        } else if (v9.a.q()) {
            if (v9.a.s()) {
                arrayList.add(c.m(context));
            }
            arrayList.addAll(c.n(context));
        } else if (v9.a.i()) {
            Intent intent4 = new Intent();
            intent4.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionTopActivity");
            arrayList.add(intent4);
            arrayList.addAll(c.i(context));
        } else if (v9.a.k()) {
            arrayList.addAll(c.l(context));
        } else if (v9.a.t()) {
            arrayList.add(c.h(context));
        } else if (v9.a.u() && !h.m()) {
            arrayList.addAll(c.j());
            arrayList.addAll(c.k(context));
        }
        arrayList.add(r(context));
        arrayList.add(BasePermission.y());
        arrayList.add(BasePermission.v());
        arrayList.add(p());
        return arrayList;
    }

    @Override // com.hjq.permissions.permission.common.SpecialPermission, com.hjq.permissions.permission.base.BasePermission
    protected boolean S() {
        return true;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public boolean T(Context context, boolean z10) {
        boolean canDrawOverlays;
        if (h.n()) {
            canDrawOverlays = Settings.canDrawOverlays(context);
            return canDrawOverlays;
        }
        if (!h.k()) {
            return true;
        }
        return BasePermission.a(context, "OP_SYSTEM_ALERT_WINDOW", 24, true);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 17;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.SYSTEM_ALERT_WINDOW";
    }

    private SystemAlertWindowPermission(Parcel parcel) {
        super(parcel);
    }
}
