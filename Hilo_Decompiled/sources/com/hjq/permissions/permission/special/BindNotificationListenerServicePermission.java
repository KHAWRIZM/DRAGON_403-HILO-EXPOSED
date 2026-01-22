package com.hjq.permissions.permission.special;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.facebook.internal.security.CertificateUtil;
import com.hjq.permissions.permission.common.SpecialPermission;
import ea.d;
import ea.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import ka.g;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class BindNotificationListenerServicePermission extends SpecialPermission {
    public static final Parcelable.Creator<BindNotificationListenerServicePermission> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final String f١٢٠١٨a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BindNotificationListenerServicePermission createFromParcel(Parcel parcel) {
            return new BindNotificationListenerServicePermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BindNotificationListenerServicePermission[] newArray(int i10) {
            return new BindNotificationListenerServicePermission[i10];
        }
    }

    /* synthetic */ BindNotificationListenerServicePermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public List L(Context context, boolean z10) {
        ArrayList arrayList = new ArrayList(3);
        if (h.d() && g.p(this.f١٢٠١٨a)) {
            Intent intent = new Intent("android.settings.NOTIFICATION_LISTENER_DETAIL_SETTINGS");
            intent.putExtra("android.provider.extra.NOTIFICATION_LISTENER_COMPONENT_NAME", new ComponentName(context, this.f١٢٠١٨a).flattenToString());
            arrayList.add(intent);
        }
        h.m();
        arrayList.add(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
        arrayList.add(p());
        return arrayList;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public boolean T(Context context, boolean z10) {
        NotificationManager notificationManager;
        String str;
        boolean isNotificationListenerAccessGranted;
        Object systemService;
        if (!h.j()) {
            return true;
        }
        if (h.n()) {
            systemService = context.getSystemService((Class<Object>) NotificationManager.class);
            notificationManager = (NotificationManager) systemService;
        } else {
            notificationManager = (NotificationManager) context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        }
        if (g.p(this.f١٢٠١٨a)) {
            str = this.f١٢٠١٨a;
        } else {
            str = null;
        }
        if (h.q() && notificationManager != null && str != null) {
            isNotificationListenerAccessGranted = notificationManager.isNotificationListenerAccessGranted(new ComponentName(context, str));
            return isNotificationListenerAccessGranted;
        }
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (TextUtils.isEmpty(string)) {
            return false;
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
            if (gVar != null && g.t(this.f١٢٠١٨a, gVar.f١٣٩٨٩a)) {
                String str = gVar.f١٣٩٩٠b;
                if (str != null && g.j(this, str)) {
                    h.j();
                    List list3 = gVar.f١٣٩٩١c;
                    if (list3 != null) {
                        Iterator it = list3.iterator();
                        while (it.hasNext()) {
                            if (((d) it.next()).f١٣٩٨٠a.contains("android.service.notification.NotificationListenerService")) {
                                return;
                            }
                        }
                    }
                    throw new IllegalArgumentException("Please add an intent filter for \"" + this.f١٢٠١٨a + "\" in the AndroidManifest.xml file.\n" + ("\t\t<intent-filter>\n\t\t    <action android:name=\"android.service.notification.NotificationListenerService\" />\n\t\t</intent-filter>"));
                }
                throw new IllegalArgumentException("Please register permission node in the AndroidManifest.xml file, for example: <service android:name=\"" + this.f١٢٠١٨a + "\" android:permission=\"" + x() + "\" />");
            }
        }
        throw new IllegalArgumentException("The \"" + this.f١٢٠١٨a + "\" component is not registered in the AndroidManifest.xml file");
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 18;
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public void s(Activity activity, List list, da.a aVar) {
        super.s(activity, list, aVar);
        if (!TextUtils.isEmpty(this.f١٢٠١٨a)) {
            if (g.p(this.f١٢٠١٨a)) {
                return;
            }
            throw new IllegalArgumentException("The passed-in " + this.f١٢٠١٨a + " is an invalid class");
        }
        throw new IllegalArgumentException("Pass the ServiceClass parameter as empty");
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f١٢٠١٨a);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE";
    }

    public BindNotificationListenerServicePermission(String str) {
        this.f١٢٠١٨a = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private BindNotificationListenerServicePermission(Parcel parcel) {
        this(r1);
        String readString = parcel.readString();
        Objects.requireNonNull(readString);
    }
}
