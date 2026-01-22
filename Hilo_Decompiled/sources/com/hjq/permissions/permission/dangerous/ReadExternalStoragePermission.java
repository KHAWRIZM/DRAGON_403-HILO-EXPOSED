package com.hjq.permissions.permission.dangerous;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.hjq.permissions.permission.common.DangerousPermission;
import com.luck.picture.lib.permissions.PermissionConfig;
import ea.e;
import ea.f;
import fa.b;
import java.util.List;
import ka.g;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class ReadExternalStoragePermission extends DangerousPermission {
    public static final Parcelable.Creator<ReadExternalStoragePermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReadExternalStoragePermission createFromParcel(Parcel parcel) {
            return new ReadExternalStoragePermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ReadExternalStoragePermission[] newArray(int i10) {
            return new ReadExternalStoragePermission[i10];
        }
    }

    /* synthetic */ ReadExternalStoragePermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.common.DangerousPermission
    public boolean X(Activity activity) {
        if (h.f() && h.b(activity) >= 33) {
            if (b.k().R(activity) && b.l().R(activity) && b.j().R(activity)) {
                return true;
            }
            return false;
        }
        return super.X(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.common.DangerousPermission
    public boolean Z(Context context, boolean z10) {
        if (h.f() && h.b(context) >= 33) {
            if (b.k().T(context, z10) && b.l().T(context, z10) && b.j().T(context, z10)) {
                return true;
            }
            return false;
        }
        return super.Z(context, z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void g(Activity activity, List list, da.a aVar, List list2, f fVar) {
        ea.b bVar;
        boolean z10;
        super.g(activity, list, aVar, list2, fVar);
        if (g.d(list, "android.permission.ACCESS_MEDIA_LOCATION") || (bVar = aVar.f١٣٦٦٤e) == null) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void i(Activity activity, List list) {
        super.i(activity, list);
        if (h.b(activity) < 33) {
        } else {
            throw new IllegalArgumentException("When the project targetSdkVersion >= 33, the \"android.permission.READ_EXTERNAL_STORAGE\" permission cannot be applied for, and some problems will occur.Because after testing, if targetSdkVersion >= 33 applies for \"android.permission.READ_EXTERNAL_STORAGE\" or \"android.permission.WRITE_EXTERNAL_STORAGE\", it will be directly rejected by the system and no authorization dialog box will be displayed.If the App has been adapted for scoped storage, the should be requested \"android.permission.READ_MEDIA_IMAGES\" or \"android.permission.READ_MEDIA_VIDEO\" or \"android.permission.READ_MEDIA_AUDIO\" permission.If the App does not need to adapt scoped storage, the should be requested \"android.permission.MANAGE_EXTERNAL_STORAGE\" permission");
        }
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public String k(Context context) {
        return "storage_group";
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return PermissionConfig.READ_EXTERNAL_STORAGE;
    }

    public ReadExternalStoragePermission() {
    }

    private ReadExternalStoragePermission(Parcel parcel) {
        super(parcel);
    }
}
