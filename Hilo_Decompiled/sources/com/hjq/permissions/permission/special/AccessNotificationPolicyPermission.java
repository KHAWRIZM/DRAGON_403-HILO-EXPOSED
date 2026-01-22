package com.hjq.permissions.permission.special;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.hjq.permissions.permission.base.BasePermission;
import com.hjq.permissions.permission.common.SpecialPermission;
import java.util.ArrayList;
import java.util.List;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class AccessNotificationPolicyPermission extends SpecialPermission {
    public static final Parcelable.Creator<AccessNotificationPolicyPermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AccessNotificationPolicyPermission createFromParcel(Parcel parcel) {
            return new AccessNotificationPolicyPermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AccessNotificationPolicyPermission[] newArray(int i10) {
            return new AccessNotificationPolicyPermission[i10];
        }
    }

    /* synthetic */ AccessNotificationPolicyPermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public List L(Context context, boolean z10) {
        ArrayList arrayList = new ArrayList(6);
        if (h.c() && !v9.a.l() && !v9.a.p() && !v9.a.j()) {
            Intent intent = new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_DETAIL_SETTINGS");
            intent.setData(O(context));
            arrayList.add(intent);
        }
        if (h.n()) {
            arrayList.add(new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS"));
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
        Object systemService;
        boolean isNotificationPolicyAccessGranted;
        if (h.n()) {
            systemService = context.getSystemService((Class<Object>) NotificationManager.class);
            NotificationManager notificationManager = (NotificationManager) systemService;
            if (notificationManager != null) {
                isNotificationPolicyAccessGranted = notificationManager.isNotificationPolicyAccessGranted();
                return isNotificationPolicyAccessGranted;
            }
            return false;
        }
        return true;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 23;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.ACCESS_NOTIFICATION_POLICY";
    }

    private AccessNotificationPolicyPermission(Parcel parcel) {
        super(parcel);
    }
}
