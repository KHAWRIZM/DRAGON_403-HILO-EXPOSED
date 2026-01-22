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
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class WriteSettingsPermission extends SpecialPermission {
    public static final Parcelable.Creator<WriteSettingsPermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WriteSettingsPermission createFromParcel(Parcel parcel) {
            return new WriteSettingsPermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WriteSettingsPermission[] newArray(int i10) {
            return new WriteSettingsPermission[i10];
        }
    }

    /* synthetic */ WriteSettingsPermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public List L(Context context, boolean z10) {
        ArrayList arrayList = new ArrayList(6);
        if (h.n()) {
            Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
            intent.setData(O(context));
            arrayList.add(intent);
            arrayList.add(new Intent("android.settings.action.MANAGE_WRITE_SETTINGS"));
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
        boolean canWrite;
        if (h.n()) {
            canWrite = Settings.System.canWrite(context);
            return canWrite;
        }
        return true;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 23;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.WRITE_SETTINGS";
    }

    private WriteSettingsPermission(Parcel parcel) {
        super(parcel);
    }
}
