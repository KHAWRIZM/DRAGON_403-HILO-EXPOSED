package com.hjq.permissions.permission.special;

import android.app.Activity;
import android.content.Context;
import android.net.VpnService;
import android.os.Parcel;
import android.os.Parcelable;
import com.hjq.permissions.permission.common.SpecialPermission;
import ea.d;
import ea.f;
import ea.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class BindVpnServicePermission extends SpecialPermission {
    public static final Parcelable.Creator<BindVpnServicePermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BindVpnServicePermission createFromParcel(Parcel parcel) {
            return new BindVpnServicePermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BindVpnServicePermission[] newArray(int i10) {
            return new BindVpnServicePermission[i10];
        }
    }

    /* synthetic */ BindVpnServicePermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public List L(Context context, boolean z10) {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(VpnService.prepare(context));
        arrayList.add(p());
        return arrayList;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public boolean T(Context context, boolean z10) {
        if (VpnService.prepare(context) == null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void g(Activity activity, List list, da.a aVar, List list2, f fVar) {
        super.g(activity, list, aVar, list2, fVar);
        List list3 = aVar.f١٣٦٦٦g;
        for (int i10 = 0; i10 < list3.size(); i10++) {
            g gVar = (g) list3.get(i10);
            String str = gVar.f١٣٩٩٠b;
            if (str != null && ka.g.j(this, str)) {
                List list4 = gVar.f١٣٩٩١c;
                if (list4 != null) {
                    Iterator it = list4.iterator();
                    while (it.hasNext()) {
                        if (((d) it.next()).f١٣٩٨٠a.contains("android.net.VpnService")) {
                            return;
                        }
                    }
                }
                throw new IllegalArgumentException("Please add an intent filter for \"" + gVar.f١٣٩٨٩a + "\" in the AndroidManifest.xml file.\n" + ("\t\t<intent-filter>\n\t\t    <action android:name=\"android.net.VpnService\" />\n\t\t</intent-filter>"));
            }
        }
        throw new IllegalArgumentException("No Service was found to have registered the android:permission=\"" + x() + "\" property, Please register this property to VpnService subclass by AndroidManifest.xml file, otherwise it will lead to can't apply for the permission");
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 14;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.BIND_VPN_SERVICE";
    }

    private BindVpnServicePermission(Parcel parcel) {
        super(parcel);
    }
}
