package com.hjq.permissions.permission.dangerous;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.hjq.permissions.permission.base.IPermission;
import com.hjq.permissions.permission.common.DangerousPermission;
import com.luck.picture.lib.permissions.PermissionConfig;
import fa.b;
import java.util.List;
import ka.g;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class AccessMediaLocationPermission extends DangerousPermission {
    public static final Parcelable.Creator<AccessMediaLocationPermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AccessMediaLocationPermission createFromParcel(Parcel parcel) {
            return new AccessMediaLocationPermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AccessMediaLocationPermission[] newArray(int i10) {
            return new AccessMediaLocationPermission[i10];
        }
    }

    /* synthetic */ AccessMediaLocationPermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    private boolean a0(Context context, boolean z10) {
        if (h.f() && h.b(context) >= 33) {
            if (b.k().T(context, z10) || b.l().T(context, z10) || b.g().T(context, z10)) {
                return true;
            }
            return false;
        }
        if (h.d() && h.b(context) >= 30) {
            if (b.i().T(context, z10) || b.g().T(context, z10)) {
                return true;
            }
            return false;
        }
        return b.i().T(context, z10);
    }

    @Override // com.hjq.permissions.permission.common.DangerousPermission
    protected boolean W(Activity activity) {
        return b.i().R(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.common.DangerousPermission
    public boolean X(Activity activity) {
        if (a0(activity, true) && super.X(activity)) {
            return true;
        }
        return false;
    }

    @Override // com.hjq.permissions.permission.common.DangerousPermission
    protected boolean Y(Context context, boolean z10) {
        return b.i().T(context, z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.common.DangerousPermission
    public boolean Z(Context context, boolean z10) {
        if (a0(context, z10) && super.Z(context, z10)) {
            return true;
        }
        return false;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 29;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void i(Activity activity, List list) {
        List list2 = list;
        super.i(activity, list);
        int i10 = 0;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        int i15 = -1;
        int i16 = -1;
        int i17 = -1;
        while (i10 < list.size()) {
            IPermission iPermission = (IPermission) list2.get(i10);
            if (g.i(iPermission, this)) {
                i12 = i10;
            } else if (g.j(iPermission, PermissionConfig.READ_MEDIA_IMAGES)) {
                i11 = i10;
            } else if (g.j(iPermission, PermissionConfig.READ_MEDIA_VIDEO)) {
                i13 = i10;
            } else if (g.j(iPermission, PermissionConfig.READ_MEDIA_VISUAL_USER_SELECTED)) {
                i14 = i10;
            } else if (g.j(iPermission, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                i15 = i10;
            } else if (g.j(iPermission, PermissionConfig.READ_EXTERNAL_STORAGE)) {
                i16 = i10;
            } else if (g.j(iPermission, PermissionConfig.WRITE_EXTERNAL_STORAGE)) {
                i17 = i10;
            }
            i10++;
            list2 = list;
        }
        if (i11 != -1 && i11 > i12) {
            throw new IllegalArgumentException("Please place the " + x() + "\" permission after the \"" + PermissionConfig.READ_MEDIA_IMAGES + "\" permission");
        }
        int i18 = -1;
        if (i13 != -1) {
            if (i13 <= i12) {
                i18 = -1;
            } else {
                throw new IllegalArgumentException("Please place the \"" + x() + "\" permission after the \"" + PermissionConfig.READ_MEDIA_VIDEO + "\" permission");
            }
        }
        if (i14 != i18) {
            if (i14 <= i12) {
                i18 = -1;
            } else {
                throw new IllegalArgumentException("Please place the \"" + x() + "\" permission after the \"" + PermissionConfig.READ_MEDIA_VISUAL_USER_SELECTED + "\" permission");
            }
        }
        if (i15 != i18) {
            if (i15 <= i12) {
                i18 = -1;
            } else {
                throw new IllegalArgumentException("Please place the \"" + x() + "\" permission after the \"android.permission.MANAGE_EXTERNAL_STORAGE\" permission");
            }
        }
        if (i16 != i18) {
            if (i16 <= i12) {
                i18 = -1;
            } else {
                throw new IllegalArgumentException("Please place the \"" + x() + "\" permission after the \"" + PermissionConfig.READ_EXTERNAL_STORAGE + "\" permission");
            }
        }
        if (i17 != i18 && i17 > i12) {
            throw new IllegalArgumentException("Please place the \"" + x() + "\" permission after the \"" + PermissionConfig.WRITE_EXTERNAL_STORAGE + "\" permission");
        }
        if (h.b(activity) >= 33) {
            if (!g.d(list, PermissionConfig.READ_MEDIA_IMAGES) && !g.d(list, PermissionConfig.READ_MEDIA_VIDEO) && !g.d(list, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                throw new IllegalArgumentException("You must add \"android.permission.READ_MEDIA_IMAGES\" or \"android.permission.READ_MEDIA_VIDEO\" or \"android.permission.MANAGE_EXTERNAL_STORAGE\" rights to apply for \"" + x() + "\" rights");
            }
            return;
        }
        if (!g.d(list, PermissionConfig.READ_EXTERNAL_STORAGE) && !g.d(list, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
            throw new IllegalArgumentException("You must add \"android.permission.READ_EXTERNAL_STORAGE\" or \"android.permission.MANAGE_EXTERNAL_STORAGE\" rights to apply for \"" + x() + "\" rights");
        }
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.ACCESS_MEDIA_LOCATION";
    }

    private AccessMediaLocationPermission(Parcel parcel) {
        super(parcel);
    }
}
