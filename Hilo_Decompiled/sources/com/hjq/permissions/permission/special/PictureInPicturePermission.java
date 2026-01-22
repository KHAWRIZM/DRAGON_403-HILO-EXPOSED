package com.hjq.permissions.permission.special;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.hjq.permissions.permission.base.BasePermission;
import com.hjq.permissions.permission.common.SpecialPermission;
import ea.f;
import java.util.ArrayList;
import java.util.List;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class PictureInPicturePermission extends SpecialPermission {
    public static final Parcelable.Creator<PictureInPicturePermission> CREATOR = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PictureInPicturePermission createFromParcel(Parcel parcel) {
            return new PictureInPicturePermission(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PictureInPicturePermission[] newArray(int i10) {
            return new PictureInPicturePermission[i10];
        }
    }

    /* synthetic */ PictureInPicturePermission(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public List L(Context context, boolean z10) {
        ArrayList arrayList = new ArrayList(6);
        if (h.p()) {
            Intent intent = new Intent("android.settings.PICTURE_IN_PICTURE_SETTINGS");
            intent.setData(O(context));
            arrayList.add(intent);
            arrayList.add(new Intent("android.settings.PICTURE_IN_PICTURE_SETTINGS"));
        }
        arrayList.add(r(context));
        arrayList.add(BasePermission.y());
        arrayList.add(BasePermission.v());
        arrayList.add(p());
        return arrayList;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public boolean T(Context context, boolean z10) {
        if (!h.p()) {
            return true;
        }
        return BasePermission.b(context, "android:picture_in_picture", true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hjq.permissions.permission.base.BasePermission
    public void g(Activity activity, List list, da.a aVar, List list2, f fVar) {
        super.g(activity, list, aVar, list2, fVar);
        List list3 = aVar.f١٣٦٦٥f;
        for (int i10 = 0; i10 < list3.size(); i10++) {
            if (((ea.a) list3.get(i10)).f١٣٩٧٠b) {
                return;
            }
        }
        throw new IllegalArgumentException("No Activity was found to have registered the android:supportsPictureInPicture=\"true\" property, Please register this property to " + activity.getClass().getName() + " class by AndroidManifest.xml file, otherwise it will lead to can't apply for the permission");
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public int h(Context context) {
        return 26;
    }

    @Override // com.hjq.permissions.permission.base.IPermission
    public String x() {
        return "android.permission.PICTURE_IN_PICTURE";
    }

    private PictureInPicturePermission(Parcel parcel) {
        super(parcel);
    }
}
