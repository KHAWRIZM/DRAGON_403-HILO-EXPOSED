package com.hjq.permissions.permission.special;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.hjq.permissions.permission.base.BasePermission;
import com.hjq.permissions.permission.common.SpecialPermission;
import ea.f;
import java.util.ArrayList;
import java.util.List;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class NotificationServicePermission extends SpecialPermission {
    public static final Parcelable.Creator<NotificationServicePermission> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final String f١٢٠١٩a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NotificationServicePermission createFromParcel(Parcel parcel) {
            return new NotificationServicePermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public NotificationServicePermission[] newArray(int i10) {
            return new NotificationServicePermission[i10];
        }
    }

    /* synthetic */ NotificationServicePermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public List L(Context context, boolean z10) {
        Object systemService;
        NotificationChannel notificationChannel;
        boolean areNotificationsEnabled;
        String id;
        String conversationId;
        ArrayList arrayList = new ArrayList(8);
        if (h.p()) {
            Intent intent = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
            systemService = context.getSystemService((Class<Object>) NotificationManager.class);
            NotificationManager notificationManager = (NotificationManager) systemService;
            if (notificationManager != null && !TextUtils.isEmpty(this.f١٢٠١٩a)) {
                notificationChannel = notificationManager.getNotificationChannel(this.f١٢٠١٩a);
            } else {
                notificationChannel = null;
            }
            if (notificationChannel != null) {
                areNotificationsEnabled = notificationManager.areNotificationsEnabled();
                if (areNotificationsEnabled) {
                    intent.setAction("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
                    id = notificationChannel.getId();
                    intent.putExtra("android.provider.extra.CHANNEL_ID", id);
                    if (h.d()) {
                        conversationId = notificationChannel.getConversationId();
                        intent.putExtra("android.provider.extra.CONVERSATION_ID", conversationId);
                    }
                    arrayList.add(intent);
                }
            }
            Intent intent2 = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            intent2.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
            arrayList.add(intent2);
        }
        if (h.l()) {
            Intent intent3 = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            intent3.putExtra("app_package", context.getPackageName());
            intent3.putExtra("app_uid", context.getApplicationInfo().uid);
            arrayList.add(intent3);
        }
        if (h.f()) {
            arrayList.add(new Intent("android.settings.ALL_APPS_NOTIFICATION_SETTINGS"));
        }
        arrayList.add(r(context));
        arrayList.add(BasePermission.y());
        arrayList.add(BasePermission.v());
        arrayList.add(p());
        return arrayList;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public boolean T(Context context, boolean z10) {
        Object systemService;
        boolean areNotificationsEnabled;
        NotificationChannel notificationChannel;
        int importance;
        if (!h.k()) {
            return true;
        }
        if (h.o()) {
            systemService = context.getSystemService((Class<Object>) NotificationManager.class);
            NotificationManager notificationManager = (NotificationManager) systemService;
            if (notificationManager != null) {
                areNotificationsEnabled = notificationManager.areNotificationsEnabled();
                if (!areNotificationsEnabled) {
                    return false;
                }
                if (!TextUtils.isEmpty(this.f١٢٠١٩a) && h.p()) {
                    notificationChannel = notificationManager.getNotificationChannel(this.f١٢٠١٩a);
                    if (notificationChannel != null) {
                        importance = notificationChannel.getImportance();
                        if (importance != 0) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
            return BasePermission.a(context, "OP_POST_NOTIFICATION", 11, true);
        }
        return BasePermission.a(context, "OP_POST_NOTIFICATION", 11, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void g(Activity activity, List list, da.a aVar, List list2, f fVar) {
        super.g(activity, list, aVar, list2, fVar);
        if (h.b(activity) >= 33) {
            BasePermission.d(BasePermission.n(list2, "android.permission.POST_NOTIFICATIONS"), "android.permission.POST_NOTIFICATIONS", Integer.MAX_VALUE);
        }
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 19;
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f١٢٠١٩a);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.NOTIFICATION_SERVICE";
    }

    public NotificationServicePermission() {
        this((String) null);
    }

    public NotificationServicePermission(String str) {
        this.f١٢٠١٩a = str;
    }

    private NotificationServicePermission(Parcel parcel) {
        this(parcel.readString());
    }
}
