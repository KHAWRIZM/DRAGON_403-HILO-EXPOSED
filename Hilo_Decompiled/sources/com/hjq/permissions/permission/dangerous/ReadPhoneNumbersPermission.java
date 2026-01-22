package com.hjq.permissions.permission.dangerous;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.hjq.permissions.permission.base.BasePermission;
import com.hjq.permissions.permission.common.DangerousPermission;
import ea.f;
import fa.b;
import java.util.List;
import ka.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class ReadPhoneNumbersPermission extends DangerousPermission {
    public static final Parcelable.Creator<ReadPhoneNumbersPermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReadPhoneNumbersPermission createFromParcel(Parcel parcel) {
            return new ReadPhoneNumbersPermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ReadPhoneNumbersPermission[] newArray(int i10) {
            return new ReadPhoneNumbersPermission[i10];
        }
    }

    /* synthetic */ ReadPhoneNumbersPermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public List M(Context context) {
        return g.b(b.n());
    }

    @Override // com.hjq.permissions.permission.common.DangerousPermission
    protected boolean W(Activity activity) {
        return b.n().R(activity);
    }

    @Override // com.hjq.permissions.permission.common.DangerousPermission
    protected boolean Y(Context context, boolean z10) {
        return b.n().T(context, z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void g(Activity activity, List list, da.a aVar, List list2, f fVar) {
        super.g(activity, list, aVar, list2, fVar);
        if (h(activity) > BasePermission.B(activity, aVar)) {
            BasePermission.f(list2, "android.permission.READ_PHONE_STATE", 25);
        }
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 26;
    }

    @Override // com.hjq.permissions.permission.base.BasePermission, com.hjq.permissions.permission.base.IPermission
    public String k(Context context) {
        return "phone_group";
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.READ_PHONE_NUMBERS";
    }

    private ReadPhoneNumbersPermission(Parcel parcel) {
        super(parcel);
    }
}
