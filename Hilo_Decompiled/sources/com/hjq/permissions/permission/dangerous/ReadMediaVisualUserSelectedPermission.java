package com.hjq.permissions.permission.dangerous;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.hjq.permissions.permission.common.DangerousPermission;
import com.luck.picture.lib.permissions.PermissionConfig;
import java.util.List;
import ka.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class ReadMediaVisualUserSelectedPermission extends DangerousPermission {
    public static final Parcelable.Creator<ReadMediaVisualUserSelectedPermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReadMediaVisualUserSelectedPermission createFromParcel(Parcel parcel) {
            return new ReadMediaVisualUserSelectedPermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ReadMediaVisualUserSelectedPermission[] newArray(int i10) {
            return new ReadMediaVisualUserSelectedPermission[i10];
        }
    }

    /* synthetic */ ReadMediaVisualUserSelectedPermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.BasePermission
    public int E(Context context) {
        return 33;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 34;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void i(Activity activity, List list) {
        super.i(activity, list);
        if (!g.d(list, PermissionConfig.READ_MEDIA_IMAGES) && !g.d(list, PermissionConfig.READ_MEDIA_VIDEO)) {
            throw new IllegalArgumentException("You cannot request the \"" + x() + "\" permission alone. must add either \"" + PermissionConfig.READ_MEDIA_IMAGES + "\" or \"" + PermissionConfig.READ_MEDIA_VIDEO + "\" permission, or maybe both");
        }
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public String k(Context context) {
        return "image_and_video_media_group";
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return PermissionConfig.READ_MEDIA_VISUAL_USER_SELECTED;
    }

    public ReadMediaVisualUserSelectedPermission() {
    }

    private ReadMediaVisualUserSelectedPermission(Parcel parcel) {
        super(parcel);
    }
}
