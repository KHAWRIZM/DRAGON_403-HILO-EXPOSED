package com.hjq.permissions.permission.common;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import com.hjq.permissions.permission.base.BasePermission;
import ka.h;
import v9.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class SpecialPermission extends BasePermission {
    /* JADX INFO: Access modifiers changed from: protected */
    public SpecialPermission() {
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public int H(Context context) {
        int i10;
        if (!m(context)) {
            return 0;
        }
        if (h.d()) {
            i10 = 200;
        } else {
            i10 = 300;
        }
        if (!a.j() && !a.l()) {
            return i10;
        }
        if (h.p()) {
            return 300;
        }
        return 500;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public boolean R(Activity activity) {
        return false;
    }

    @Override // com.hjq.permissions.permission.base.BasePermission
    protected boolean S() {
        return false;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public fa.a q(Context context) {
        return fa.a.START_ACTIVITY_FOR_RESULT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SpecialPermission(Parcel parcel) {
        super(parcel);
    }
}
