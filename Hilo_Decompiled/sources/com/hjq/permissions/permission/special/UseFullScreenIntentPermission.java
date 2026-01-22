package com.hjq.permissions.permission.special;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.hjq.permissions.permission.base.BasePermission;
import com.hjq.permissions.permission.base.IPermission;
import com.hjq.permissions.permission.common.SpecialPermission;
import java.util.ArrayList;
import java.util.List;
import ka.g;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class UseFullScreenIntentPermission extends SpecialPermission {
    public static final Parcelable.Creator<UseFullScreenIntentPermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UseFullScreenIntentPermission createFromParcel(Parcel parcel) {
            return new UseFullScreenIntentPermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public UseFullScreenIntentPermission[] newArray(int i10) {
            return new UseFullScreenIntentPermission[i10];
        }
    }

    /* synthetic */ UseFullScreenIntentPermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public List L(Context context, boolean z10) {
        ArrayList arrayList = new ArrayList(6);
        if (h.g()) {
            Intent intent = new Intent("android.settings.MANAGE_APP_USE_FULL_SCREEN_INTENT");
            intent.setData(O(context));
            arrayList.add(intent);
        }
        if (!v9.a.m() && !v9.a.q()) {
            if (h.p()) {
                Intent intent2 = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
                intent2.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                arrayList.add(intent2);
            }
            arrayList.add(r(context));
            arrayList.add(BasePermission.y());
            arrayList.add(BasePermission.v());
            arrayList.add(p());
            return arrayList;
        }
        arrayList.add(p());
        return arrayList;
    }

    @Override // com.hjq.permissions.permission.common.SpecialPermission, com.hjq.permissions.permission.base.BasePermission
    protected boolean S() {
        return true;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public boolean T(Context context, boolean z10) {
        Object systemService;
        boolean canUseFullScreenIntent;
        if (h.g()) {
            systemService = context.getSystemService((Class<Object>) NotificationManager.class);
            NotificationManager notificationManager = (NotificationManager) systemService;
            if (notificationManager != null) {
                canUseFullScreenIntent = notificationManager.canUseFullScreenIntent();
                return canUseFullScreenIntent;
            }
            return false;
        }
        return true;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 34;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void i(Activity activity, List list) {
        super.i(activity, list);
        if (!g.d(list, "android.permission.NOTIFICATION_SERVICE") && !g.d(list, "android.permission.POST_NOTIFICATIONS")) {
            throw new IllegalArgumentException("The \"" + x() + "\" needs to be used together with the notification permission. (\"android.permission.NOTIFICATION_SERVICE\" or \"android.permission.POST_NOTIFICATIONS\")");
        }
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < list.size(); i13++) {
            IPermission iPermission = (IPermission) list.get(i13);
            if (g.j(iPermission, x())) {
                i11 = i13;
            } else if (g.j(iPermission, "android.permission.NOTIFICATION_SERVICE")) {
                i10 = i13;
            } else if (g.j(iPermission, "android.permission.POST_NOTIFICATIONS")) {
                i12 = i13;
            }
        }
        if (i10 != -1 && i10 > i11) {
            throw new IllegalArgumentException("Please place the " + x() + "\" permission after the \"android.permission.NOTIFICATION_SERVICE\" permission");
        }
        if (i12 != -1 && i12 > i11) {
            throw new IllegalArgumentException("Please place the \"" + x() + "\" permission after the \"android.permission.POST_NOTIFICATIONS\" permission");
        }
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.USE_FULL_SCREEN_INTENT";
    }

    private UseFullScreenIntentPermission(Parcel parcel) {
        super(parcel);
    }
}
