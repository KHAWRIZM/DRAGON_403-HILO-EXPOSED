package com.hjq.permissions.permission.special;

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
public final class PackageUsageStatsPermission extends SpecialPermission {
    public static final Parcelable.Creator<PackageUsageStatsPermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PackageUsageStatsPermission createFromParcel(Parcel parcel) {
            return new PackageUsageStatsPermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PackageUsageStatsPermission[] newArray(int i10) {
            return new PackageUsageStatsPermission[i10];
        }
    }

    /* synthetic */ PackageUsageStatsPermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public List L(Context context, boolean z10) {
        ArrayList arrayList = new ArrayList(3);
        if (h.c()) {
            Intent intent = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
            intent.setData(O(context));
            arrayList.add(intent);
        }
        if (h.l()) {
            arrayList.add(new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
        }
        arrayList.add(p());
        return arrayList;
    }

    @Override // com.hjq.permissions.permission.common.SpecialPermission, com.hjq.permissions.permission.base.BasePermission
    protected boolean S() {
        return true;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public boolean T(Context context, boolean z10) {
        if (!h.l()) {
            return true;
        }
        return BasePermission.b(context, "android:get_usage_stats", false);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 21;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.PACKAGE_USAGE_STATS";
    }

    private PackageUsageStatsPermission(Parcel parcel) {
        super(parcel);
    }
}
