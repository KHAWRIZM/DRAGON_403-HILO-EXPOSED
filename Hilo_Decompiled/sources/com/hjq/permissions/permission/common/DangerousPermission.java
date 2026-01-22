package com.hjq.permissions.permission.common;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import com.hjq.permissions.permission.base.BasePermission;
import java.util.ArrayList;
import java.util.List;
import ka.c;
import ka.h;
import v9.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class DangerousPermission extends BasePermission {
    /* JADX INFO: Access modifiers changed from: protected */
    public DangerousPermission() {
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public List L(Context context, boolean z10) {
        ArrayList arrayList = new ArrayList(5);
        if (a.r() && a.s()) {
            arrayList.add(c.m(context));
        } else if (a.n() && a.o() && !a.h().matches("^2\\.0\\.[0-5]\\.\\d+$")) {
            arrayList.add(c.m(context));
        }
        arrayList.add(r(context));
        arrayList.add(BasePermission.y());
        arrayList.add(BasePermission.v());
        arrayList.add(p());
        return arrayList;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public boolean R(Activity activity) {
        if (h(activity) > h.a()) {
            return W(activity);
        }
        return X(activity);
    }

    @Override // com.hjq.permissions.permission.base.BasePermission
    protected boolean S() {
        return true;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public boolean T(Context context, boolean z10) {
        if (h(context) > h.a()) {
            return Y(context, z10);
        }
        return Z(context, z10);
    }

    protected boolean W(Activity activity) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean X(Activity activity) {
        if (!h.n() || !ca.c.b(this) || BasePermission.l(activity, D(activity)) || BasePermission.V(activity, D(activity))) {
            return false;
        }
        return true;
    }

    protected boolean Y(Context context, boolean z10) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Z(Context context, boolean z10) {
        if (!h.n()) {
            return true;
        }
        return BasePermission.l(context, D(context));
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public fa.a q(Context context) {
        return fa.a.REQUEST_PERMISSIONS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DangerousPermission(Parcel parcel) {
        super(parcel);
    }
}
