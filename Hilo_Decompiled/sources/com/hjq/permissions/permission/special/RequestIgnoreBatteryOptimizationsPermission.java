package com.hjq.permissions.permission.special;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import com.hjq.permissions.permission.base.BasePermission;
import com.hjq.permissions.permission.common.SpecialPermission;
import java.util.ArrayList;
import java.util.List;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class RequestIgnoreBatteryOptimizationsPermission extends SpecialPermission {
    public static final Parcelable.Creator<RequestIgnoreBatteryOptimizationsPermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RequestIgnoreBatteryOptimizationsPermission createFromParcel(Parcel parcel) {
            return new RequestIgnoreBatteryOptimizationsPermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RequestIgnoreBatteryOptimizationsPermission[] newArray(int i10) {
            return new RequestIgnoreBatteryOptimizationsPermission[i10];
        }
    }

    /* synthetic */ RequestIgnoreBatteryOptimizationsPermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.common.SpecialPermission, com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public int H(Context context) {
        if (!m(context)) {
            return 0;
        }
        if (v9.a.m()) {
            if (h.h()) {
                return super.H(context);
            }
            if (!h.g() || v9.a.g() < 2) {
                return 1000;
            }
            return super.H(context);
        }
        if (v9.a.q() && h.d()) {
            return 1000;
        }
        return super.H(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0025, code lost:
    
        if (v9.a.m() == false) goto L٨;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    @Override // com.hjq.permissions.permission.base.IPermission
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List L(Context context, boolean z10) {
        Intent intent;
        Intent intent2;
        ArrayList arrayList = new ArrayList(7);
        Intent intent3 = null;
        if (h.n()) {
            intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
            intent.setData(O(context));
            if (T(context, z10)) {
            }
            if (!h.e()) {
                intent2 = new Intent("android.settings.VIEW_ADVANCED_POWER_USAGE_DETAIL");
                intent2.setData(O(context));
            } else {
                intent2 = null;
            }
            if (h.n()) {
                intent3 = new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
            }
            if (!z10 && (!h.d() || (!v9.a.m() && !v9.a.q()))) {
                if (intent2 != null) {
                    arrayList.add(intent2);
                }
                if (intent3 != null) {
                    arrayList.add(intent3);
                }
                if (intent != null) {
                    arrayList.add(intent);
                }
            } else {
                if (intent != null) {
                    arrayList.add(intent);
                }
                if (intent2 != null) {
                    arrayList.add(intent2);
                }
                if (intent3 != null) {
                    arrayList.add(intent3);
                }
            }
            if (!v9.a.m() || v9.a.q()) {
                arrayList.add(r(context));
                arrayList.add(BasePermission.y());
                arrayList.add(BasePermission.v());
            }
            arrayList.add(p());
            return arrayList;
        }
        intent = null;
        if (!h.e()) {
        }
        if (h.n()) {
        }
        if (!z10) {
        }
        if (intent != null) {
        }
        if (intent2 != null) {
        }
        if (intent3 != null) {
        }
        if (!v9.a.m()) {
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
        boolean isIgnoringBatteryOptimizations;
        if (h.n()) {
            systemService = context.getSystemService((Class<Object>) PowerManager.class);
            PowerManager powerManager = (PowerManager) systemService;
            if (powerManager != null) {
                isIgnoringBatteryOptimizations = powerManager.isIgnoringBatteryOptimizations(context.getPackageName());
                return isIgnoringBatteryOptimizations;
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
        return "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS";
    }

    private RequestIgnoreBatteryOptimizationsPermission(Parcel parcel) {
        super(parcel);
    }
}
