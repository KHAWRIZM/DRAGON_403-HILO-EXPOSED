package com.hjq.permissions.permission.special;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import com.hjq.permissions.permission.common.SpecialPermission;
import ea.d;
import ea.e;
import ea.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import ka.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class BindAccessibilityServicePermission extends SpecialPermission {
    public static final Parcelable.Creator<BindAccessibilityServicePermission> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final String f١٢٠١٥a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BindAccessibilityServicePermission createFromParcel(Parcel parcel) {
            return new BindAccessibilityServicePermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BindAccessibilityServicePermission[] newArray(int i10) {
            return new BindAccessibilityServicePermission[i10];
        }
    }

    /* synthetic */ BindAccessibilityServicePermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public List L(Context context, boolean z10) {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
        arrayList.add(p());
        return arrayList;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public boolean T(Context context, boolean z10) {
        String str;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        if (g.p(this.f١٢٠١٥a)) {
            str = this.f١٢٠١٥a;
        } else {
            str = null;
        }
        for (String str2 : string.split(CertificateUtil.DELIMITER)) {
            ComponentName unflattenFromString = ComponentName.unflattenFromString(str2);
            if (unflattenFromString != null) {
                if (str != null) {
                    if (context.getPackageName().equals(unflattenFromString.getPackageName()) && str.equals(unflattenFromString.getClassName())) {
                        return true;
                    }
                } else if (context.getPackageName().equals(unflattenFromString.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void g(Activity activity, List list, da.a aVar, List list2, f fVar) {
        super.g(activity, list, aVar, list2, fVar);
        for (ea.g gVar : aVar.f١٣٦٦٦g) {
            if (gVar != null && g.t(this.f١٢٠١٥a, gVar.f١٣٩٨٩a)) {
                String str = gVar.f١٣٩٩٠b;
                if (str != null && g.j(this, str)) {
                    List list3 = gVar.f١٣٩٩١c;
                    if (list3 != null) {
                        Iterator it = list3.iterator();
                        while (it.hasNext()) {
                            if (((d) it.next()).f١٣٩٨٠a.contains("android.accessibilityservice.AccessibilityService")) {
                                List<e> list4 = gVar.f١٣٩٩٢d;
                                if (list4 != null) {
                                    for (e eVar : list4) {
                                        if ("android.accessibilityservice".equals(eVar.f١٣٩٨٢a) && eVar.f١٣٩٨٤c != 0) {
                                            return;
                                        }
                                    }
                                }
                                throw new IllegalArgumentException("Please add an meta data for \"" + this.f١٢٠١٥a + "\" in the AndroidManifest.xml file.\n" + ("\t\t<meta-data>\n\t\t    android:name=\"android.accessibilityservice\"\n\t\t    android:resource=\"@xml/accessibility_service_config\" />"));
                            }
                        }
                    }
                    throw new IllegalArgumentException("Please add an intent filter for \"" + this.f١٢٠١٥a + "\" in the AndroidManifest.xml file.\n" + ("\t\t<intent-filter>\n\t\t    <action android:name=\"android.accessibilityservice.AccessibilityService\" />\n\t\t</intent-filter>"));
                }
                throw new IllegalArgumentException("Please register permission node in the AndroidManifest.xml file, for example: <service android:name=\"" + this.f١٢٠١٥a + "\" android:permission=\"" + x() + "\" />");
            }
        }
        throw new IllegalArgumentException("The \"" + this.f١٢٠١٥a + "\" component is not registered in the AndroidManifest.xml file");
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 16;
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public void s(Activity activity, List list, da.a aVar) {
        super.s(activity, list, aVar);
        if (!TextUtils.isEmpty(this.f١٢٠١٥a)) {
            if (g.p(this.f١٢٠١٥a)) {
                return;
            }
            throw new IllegalArgumentException("The passed-in " + this.f١٢٠١٥a + " is an invalid class");
        }
        throw new IllegalArgumentException("Pass the ServiceClass parameter as empty");
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f١٢٠١٥a);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.BIND_ACCESSIBILITY_SERVICE";
    }

    public BindAccessibilityServicePermission(String str) {
        this.f١٢٠١٥a = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private BindAccessibilityServicePermission(Parcel parcel) {
        this(r1);
        String readString = parcel.readString();
        Objects.requireNonNull(readString);
    }
}
