package com.hjq.permissions.permission.special;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.hjq.permissions.permission.base.BasePermission;
import com.hjq.permissions.permission.common.SpecialPermission;
import ea.f;
import java.util.ArrayList;
import java.util.List;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class ScheduleExactAlarmPermission extends SpecialPermission {
    public static final Parcelable.Creator<ScheduleExactAlarmPermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ScheduleExactAlarmPermission createFromParcel(Parcel parcel) {
            return new ScheduleExactAlarmPermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ScheduleExactAlarmPermission[] newArray(int i10) {
            return new ScheduleExactAlarmPermission[i10];
        }
    }

    /* synthetic */ ScheduleExactAlarmPermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public List L(Context context, boolean z10) {
        ArrayList arrayList = new ArrayList(6);
        if (h.e()) {
            Intent intent = new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM");
            intent.setData(O(context));
            arrayList.add(intent);
            arrayList.add(new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM"));
        }
        arrayList.add(r(context));
        arrayList.add(BasePermission.y());
        arrayList.add(BasePermission.v());
        arrayList.add(p());
        return arrayList;
    }

    @Override // com.hjq.permissions.permission.common.SpecialPermission, com.hjq.permissions.permission.base.BasePermission
    protected boolean S() {
        return false;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public boolean T(Context context, boolean z10) {
        Object systemService;
        boolean canScheduleExactAlarms;
        if (h.e()) {
            systemService = context.getSystemService((Class<Object>) AlarmManager.class);
            AlarmManager alarmManager = (AlarmManager) systemService;
            if (alarmManager != null) {
                canScheduleExactAlarms = alarmManager.canScheduleExactAlarms();
                return canScheduleExactAlarms;
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void g(Activity activity, List list, da.a aVar, List list2, f fVar) {
        super.g(activity, list, aVar, list2, fVar);
        h.f();
        if (h.b(activity) >= 33 && BasePermission.n(list2, "android.permission.USE_EXACT_ALARM") != null) {
            BasePermission.f(list2, x(), 32);
        } else {
            BasePermission.e(list2, x());
        }
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 31;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.SCHEDULE_EXACT_ALARM";
    }

    private ScheduleExactAlarmPermission(Parcel parcel) {
        super(parcel);
    }
}
