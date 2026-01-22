package com.hjq.permissions.permission.base;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import fa.a;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface IPermission extends Parcelable {
    String D(Context context);

    boolean F(Context context);

    List G(Context context);

    int H(Context context);

    List L(Context context, boolean z10);

    List M(Context context);

    boolean R(Activity activity);

    boolean T(Context context, boolean z10);

    int h(Context context);

    String k(Context context);

    boolean m(Context context);

    int o(Context context);

    a q(Context context);

    void s(Activity activity, List list, da.a aVar);

    String x();

    boolean z(Context context);
}
