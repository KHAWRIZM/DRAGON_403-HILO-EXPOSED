package com.hjq.permissions.permission.dangerous;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import com.hjq.permissions.permission.base.BasePermission;
import com.hjq.permissions.permission.common.DangerousPermission;
import com.luck.picture.lib.permissions.PermissionConfig;
import ea.b;
import ea.e;
import ea.f;
import java.util.List;
import ka.g;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class WriteExternalStoragePermission extends DangerousPermission {
    public static final Parcelable.Creator<WriteExternalStoragePermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WriteExternalStoragePermission createFromParcel(Parcel parcel) {
            return new WriteExternalStoragePermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WriteExternalStoragePermission[] newArray(int i10) {
            return new WriteExternalStoragePermission[i10];
        }
    }

    /* synthetic */ WriteExternalStoragePermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.common.DangerousPermission, com.hjq.permissions.permission.base.BasePermission
    protected boolean S() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.common.DangerousPermission
    public boolean X(Activity activity) {
        boolean isExternalStorageLegacy;
        if (h.d() && h.b(activity) >= 30) {
            return false;
        }
        if (h.b(activity) >= 29 && h.c()) {
            isExternalStorageLegacy = Environment.isExternalStorageLegacy();
            if (!isExternalStorageLegacy) {
                return false;
            }
        }
        return super.X(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.common.DangerousPermission
    public boolean Z(Context context, boolean z10) {
        boolean isExternalStorageLegacy;
        if (h.d() && h.b(context) >= 30) {
            return true;
        }
        if (h.b(context) >= 29 && h.c()) {
            isExternalStorageLegacy = Environment.isExternalStorageLegacy();
            if (!isExternalStorageLegacy) {
                return true;
            }
        }
        return super.Z(context, z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void g(Activity activity, List list, da.a aVar, List list2, f fVar) {
        int i10;
        boolean z10;
        super.g(activity, list, aVar, list2, fVar);
        b bVar = aVar.f١٣٦٦٤e;
        if (bVar == null) {
            return;
        }
        if (h.b(activity) < 29) {
            BasePermission.e(list2, x());
            return;
        }
        if (h.b(activity) >= 30 && BasePermission.n(list2, "android.permission.MANAGE_EXTERNAL_STORAGE") != null) {
            BasePermission.f(list2, x(), 29);
        } else {
            String x10 = x();
            if (bVar.f١٣٩٧٤b) {
                i10 = 29;
            } else {
                i10 = 28;
            }
            BasePermission.f(list2, x10, i10);
        }
        if (g.d(list, "android.permission.ACCESS_MEDIA_LOCATION")) {
            return;
        }
        int b10 = h.b(activity);
        List<e> list3 = bVar.f١٣٩٧٥c;
        if (list3 != null) {
            for (e eVar : list3) {
                if ("ScopedStorage".equals(eVar.f١٣٩٨٢a)) {
                    z10 = Boolean.parseBoolean(eVar.f١٣٩٨٣b);
                    break;
                }
            }
        }
        z10 = false;
        if (b10 >= 29 && !bVar.f١٣٩٧٤b && !z10) {
            throw new IllegalStateException("Please register the android:requestLegacyExternalStorage=\"true\" attribute in the AndroidManifest.xml file, otherwise it will cause incompatibility with the old version");
        }
        if (b10 >= 30 && !z10) {
            throw new IllegalArgumentException("The storage permission application is abnormal. If you have adapted the scope storage, please register the <meta-data android:name=\"ScopedStorage\" android:value=\"true\" /> attribute in the AndroidManifest.xml file. If there is no adaptation scope storage, please use \"android.permission.MANAGE_EXTERNAL_STORAGE\" to apply for permission");
        }
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 23;
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public String k(Context context) {
        return "storage_group";
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return PermissionConfig.WRITE_EXTERNAL_STORAGE;
    }

    public WriteExternalStoragePermission() {
    }

    private WriteExternalStoragePermission(Parcel parcel) {
        super(parcel);
    }
}
