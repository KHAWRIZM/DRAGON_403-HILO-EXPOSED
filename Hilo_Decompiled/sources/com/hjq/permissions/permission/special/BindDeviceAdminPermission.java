package com.hjq.permissions.permission.special;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.hjq.permissions.permission.common.SpecialPermission;
import ea.c;
import ea.d;
import ea.e;
import ea.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import ka.g;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class BindDeviceAdminPermission extends SpecialPermission {
    public static final Parcelable.Creator<BindDeviceAdminPermission> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final String f١٢٠١٦a;

    /* renamed from: b, reason: collision with root package name */
    private final String f١٢٠١٧b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BindDeviceAdminPermission createFromParcel(Parcel parcel) {
            return new BindDeviceAdminPermission(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BindDeviceAdminPermission[] newArray(int i10) {
            return new BindDeviceAdminPermission[i10];
        }
    }

    /* synthetic */ BindDeviceAdminPermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public List L(Context context, boolean z10) {
        ArrayList arrayList = new ArrayList(2);
        Intent intent = new Intent("android.app.action.ADD_DEVICE_ADMIN");
        intent.putExtra("android.app.extra.DEVICE_ADMIN", new ComponentName(context, this.f١٢٠١٦a));
        intent.putExtra("android.app.extra.ADD_EXPLANATION", this.f١٢٠١٧b);
        arrayList.add(intent);
        arrayList.add(p());
        return arrayList;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public boolean T(Context context, boolean z10) {
        DevicePolicyManager devicePolicyManager;
        Object systemService;
        if (h.n()) {
            systemService = context.getSystemService((Class<Object>) DevicePolicyManager.class);
            devicePolicyManager = (DevicePolicyManager) systemService;
        } else {
            devicePolicyManager = (DevicePolicyManager) context.getSystemService("device_policy");
        }
        if (devicePolicyManager == null) {
            return false;
        }
        return devicePolicyManager.isAdminActive(new ComponentName(context, this.f١٢٠١٦a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void g(Activity activity, List list, da.a aVar, List list2, f fVar) {
        super.g(activity, list, aVar, list2, fVar);
        for (c cVar : aVar.f١٣٦٦٧h) {
            if (cVar != null && g.t(this.f١٢٠١٦a, cVar.f١٣٩٧٦a)) {
                String str = cVar.f١٣٩٧٧b;
                if (str != null && g.j(this, str)) {
                    List list3 = cVar.f١٣٩٧٨c;
                    if (list3 != null) {
                        Iterator it = list3.iterator();
                        while (it.hasNext()) {
                            if (((d) it.next()).f١٣٩٨٠a.contains("android.app.action.DEVICE_ADMIN_ENABLED")) {
                                List<e> list4 = cVar.f١٣٩٧٩d;
                                if (list4 != null) {
                                    for (e eVar : list4) {
                                        if ("android.app.device_admin".equals(eVar.f١٣٩٨٢a) && eVar.f١٣٩٨٤c != 0) {
                                            return;
                                        }
                                    }
                                }
                                throw new IllegalArgumentException("Please add an meta data for \"" + this.f١٢٠١٦a + "\" in the AndroidManifest.xml file.\n" + ("\t\t<meta-data>\n\t\t    android:name=\"android.app.device_admin\"\n\t\t    android:resource=\"@xml/device_admin_config\" />"));
                            }
                        }
                    }
                    throw new IllegalArgumentException("Please add an intent filter for \"" + this.f١٢٠١٦a + "\" in the AndroidManifest.xml file.\n" + ("\t\t<intent-filter>\n\t\t    <action android:name=\"android.app.action.DEVICE_ADMIN_ENABLED\" />\n\t\t</intent-filter>"));
                }
                throw new IllegalArgumentException("Please register permission node in the AndroidManifest.xml file, for example: <receiver android:name=\"" + this.f١٢٠١٦a + "\" android:permission=\"" + x() + "\" />");
            }
        }
        throw new IllegalArgumentException("The \"" + this.f١٢٠١٦a + "\" component is not registered in the AndroidManifest.xml file");
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 8;
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public void s(Activity activity, List list, da.a aVar) {
        super.s(activity, list, aVar);
        if (!TextUtils.isEmpty(this.f١٢٠١٦a)) {
            if (g.p(this.f١٢٠١٦a)) {
                return;
            }
            throw new IllegalArgumentException("The passed-in " + this.f١٢٠١٦a + " is an invalid class");
        }
        throw new IllegalArgumentException("Pass the BroadcastReceiverClass parameter as empty");
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f١٢٠١٦a);
        parcel.writeString(this.f١٢٠١٧b);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.BIND_DEVICE_ADMIN";
    }

    public BindDeviceAdminPermission(String str, String str2) {
        this.f١٢٠١٦a = str;
        this.f١٢٠١٧b = str2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private BindDeviceAdminPermission(Parcel parcel) {
        this(r0, parcel.readString());
        String readString = parcel.readString();
        Objects.requireNonNull(readString);
    }
}
