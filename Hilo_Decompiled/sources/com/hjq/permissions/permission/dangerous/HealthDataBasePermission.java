package com.hjq.permissions.permission.dangerous;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import com.hjq.permissions.permission.common.DangerousPermission;
import da.a;
import ea.d;
import ea.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class HealthDataBasePermission extends DangerousPermission {
    /* JADX INFO: Access modifiers changed from: protected */
    public HealthDataBasePermission() {
    }

    @Override // com.hjq.permissions.permission.common.DangerousPermission, com.hjq.permissions.permission.base.IPermission
    public List L(Context context, boolean z10) {
        List L = super.L(context, z10);
        if (h.g() && !h.i()) {
            ArrayList arrayList = new ArrayList(3);
            if (!h.h()) {
                Intent intent = new Intent("android.health.connect.action.MANAGE_HEALTH_PERMISSIONS");
                intent.putExtra("android.intent.extra.PACKAGE_NAME", context.getPackageName());
                arrayList.add(intent);
                arrayList.add(new Intent("android.health.connect.action.MANAGE_HEALTH_PERMISSIONS"));
            }
            arrayList.add(new Intent("android.health.connect.action.HEALTH_HOME_SETTINGS"));
            L.addAll(0, arrayList);
        }
        return L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void g(Activity activity, List list, a aVar, List list2, f fVar) {
        super.g(activity, list, aVar, list2, fVar);
        h.i();
        h.i();
        Iterator it = aVar.f١٣٦٦٥f.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            List list3 = ((ea.a) it.next()).f١٣٩٧١c;
            if (list3 != null) {
                Iterator it2 = list3.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    d dVar = (d) it2.next();
                    if (dVar.f١٣٩٨٠a.contains("android.intent.action.VIEW_PERMISSION_USAGE") && dVar.f١٣٩٨١b.contains("android.intent.category.HEALTH_PERMISSIONS")) {
                        z10 = true;
                        break;
                    }
                }
                if (z10) {
                    break;
                }
            }
        }
        if (z10) {
            return;
        }
        throw new IllegalArgumentException("Please add an intent filter for \"" + activity.getClass() + "\" in the AndroidManifest.xml file.\n" + ("\t\t<intent-filter>\n\t\t    <action android:name=\"android.intent.action.VIEW_PERMISSION_USAGE\" />\n\t\t    <category android:name=\"android.intent.category.HEALTH_PERMISSIONS\" />\n\t\t</intent-filter>"));
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public String k(Context context) {
        return "health_group";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HealthDataBasePermission(Parcel parcel) {
        super(parcel);
    }
}
