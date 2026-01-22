package com.hjq.permissions.permission.dangerous;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.hjq.permissions.permission.base.BasePermission;
import com.hjq.permissions.permission.common.DangerousPermission;
import com.luck.picture.lib.permissions.PermissionConfig;
import ea.f;
import fa.b;
import java.util.List;
import ka.g;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class ReadMediaVideoPermission extends DangerousPermission {
    public static final Parcelable.Creator<ReadMediaVideoPermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReadMediaVideoPermission createFromParcel(Parcel parcel) {
            return new ReadMediaVideoPermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ReadMediaVideoPermission[] newArray(int i10) {
            return new ReadMediaVideoPermission[i10];
        }
    }

    /* synthetic */ ReadMediaVideoPermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public List M(Context context) {
        return g.b(b.i());
    }

    @Override // com.hjq.permissions.permission.common.DangerousPermission
    protected boolean W(Activity activity) {
        return b.i().R(activity);
    }

    @Override // com.hjq.permissions.permission.common.DangerousPermission
    protected boolean Y(Context context, boolean z10) {
        return b.i().T(context, z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.common.DangerousPermission
    public boolean Z(Context context, boolean z10) {
        if (h.g() && !z10) {
            return b.m().T(context, false);
        }
        return super.Z(context, z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void g(Activity activity, List list, da.a aVar, List list2, f fVar) {
        super.g(activity, list, aVar, list2, fVar);
        if (h(activity) > BasePermission.B(activity, aVar)) {
            BasePermission.f(list2, PermissionConfig.READ_EXTERNAL_STORAGE, 32);
        }
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 33;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void i(Activity activity, List list) {
        super.i(activity, list);
        if (!g.d(list, PermissionConfig.READ_EXTERNAL_STORAGE)) {
            return;
        }
        throw new IllegalArgumentException("You have added the \"" + x() + "\" permission, please do not add the \"" + PermissionConfig.READ_EXTERNAL_STORAGE + "\" permission, this conflicts with the framework's automatic compatibility policy.");
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public String k(Context context) {
        return "image_and_video_media_group";
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return PermissionConfig.READ_MEDIA_VIDEO;
    }

    public ReadMediaVideoPermission() {
    }

    private ReadMediaVideoPermission(Parcel parcel) {
        super(parcel);
    }
}
