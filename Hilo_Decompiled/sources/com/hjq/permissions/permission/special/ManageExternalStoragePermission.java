package com.hjq.permissions.permission.special;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import com.hjq.permissions.permission.base.BasePermission;
import com.hjq.permissions.permission.common.SpecialPermission;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.luck.picture.lib.permissions.PermissionUtil;
import ea.f;
import fa.b;
import java.util.ArrayList;
import java.util.List;
import ka.g;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class ManageExternalStoragePermission extends SpecialPermission {
    public static final Parcelable.Creator<ManageExternalStoragePermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ManageExternalStoragePermission createFromParcel(Parcel parcel) {
            return new ManageExternalStoragePermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ManageExternalStoragePermission[] newArray(int i10) {
            return new ManageExternalStoragePermission[i10];
        }
    }

    /* synthetic */ ManageExternalStoragePermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public List L(Context context, boolean z10) {
        ArrayList arrayList = new ArrayList(3);
        if (h.d()) {
            Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
            intent.setData(O(context));
            arrayList.add(intent);
            arrayList.add(new Intent(PermissionUtil.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION));
        }
        arrayList.add(p());
        return arrayList;
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public List M(Context context) {
        return g.b(b.i(), b.p());
    }

    @Override // com.hjq.permissions.permission.common.SpecialPermission, com.hjq.permissions.permission.base.BasePermission
    protected boolean S() {
        return true;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public boolean T(Context context, boolean z10) {
        boolean isExternalStorageManager;
        boolean isExternalStorageLegacy;
        if (h.d()) {
            isExternalStorageManager = Environment.isExternalStorageManager();
            return isExternalStorageManager;
        }
        if (h.c()) {
            isExternalStorageLegacy = Environment.isExternalStorageLegacy();
            if (!isExternalStorageLegacy) {
                return false;
            }
        }
        if (!b.i().T(context, z10) || !b.p().T(context, z10)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void g(Activity activity, List list, da.a aVar, List list2, f fVar) {
        ea.b bVar;
        super.g(activity, list, aVar, list2, fVar);
        if (h(activity) > BasePermission.B(activity, aVar)) {
            BasePermission.f(list2, PermissionConfig.READ_EXTERNAL_STORAGE, 29);
            BasePermission.f(list2, PermissionConfig.WRITE_EXTERNAL_STORAGE, 29);
        }
        if (!g.d(list, "android.permission.ACCESS_MEDIA_LOCATION") && (bVar = aVar.f١٣٦٦٤e) != null && h.b(activity) >= 29 && !bVar.f١٣٩٧٤b) {
            throw new IllegalStateException("Please register the android:requestLegacyExternalStorage=\"true\" attribute in the AndroidManifest.xml file, otherwise it will cause incompatibility with the old version");
        }
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 30;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void i(Activity activity, List list) {
        super.i(activity, list);
        if (!g.d(list, PermissionConfig.READ_EXTERNAL_STORAGE) && !g.d(list, PermissionConfig.WRITE_EXTERNAL_STORAGE)) {
            if (!g.d(list, PermissionConfig.READ_MEDIA_IMAGES) && !g.d(list, PermissionConfig.READ_MEDIA_VIDEO) && !g.d(list, PermissionConfig.READ_MEDIA_AUDIO)) {
                return;
            }
            throw new IllegalArgumentException("Because the \"" + x() + "\" permission range is very large, you can read media files with it, and there is no need to apply for additional media permissions.");
        }
        throw new IllegalArgumentException("If you have applied for \"" + x() + "\" permissions, do not apply for the \"" + PermissionConfig.READ_EXTERNAL_STORAGE + "\" or \"" + PermissionConfig.WRITE_EXTERNAL_STORAGE + "\" permissions");
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.MANAGE_EXTERNAL_STORAGE";
    }

    public ManageExternalStoragePermission() {
    }

    private ManageExternalStoragePermission(Parcel parcel) {
        super(parcel);
    }
}
