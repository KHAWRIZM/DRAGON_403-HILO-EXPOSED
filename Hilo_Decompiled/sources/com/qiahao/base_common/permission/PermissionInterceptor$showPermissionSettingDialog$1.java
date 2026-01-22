package com.qiahao.base_common.permission;

import android.app.Activity;
import com.hjq.permissions.permission.base.IPermission;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w9.c;
import w9.h;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/qiahao/base_common/permission/PermissionInterceptor$showPermissionSettingDialog$1", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "confirm", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PermissionInterceptor$showPermissionSettingDialog$1 implements OnCommonDialogListener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ c $callback;
    final /* synthetic */ List<IPermission> $deniedList;
    final /* synthetic */ List<IPermission> $requestList;
    final /* synthetic */ PermissionInterceptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public PermissionInterceptor$showPermissionSettingDialog$1(Activity activity, List<? extends IPermission> list, List<? extends IPermission> list2, PermissionInterceptor permissionInterceptor, c cVar) {
        this.$activity = activity;
        this.$deniedList = list;
        this.$requestList = list2;
        this.this$0 = permissionInterceptor;
        this.$callback = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void confirm$lambda$0(Activity activity, List list, PermissionInterceptor permissionInterceptor, c cVar, List grantedList, List deniedList) {
        Intrinsics.checkNotNullParameter(grantedList, "grantedList");
        Intrinsics.checkNotNullParameter(deniedList, "deniedList");
        List g10 = h.g(activity, list);
        if (!g10.isEmpty()) {
            Intrinsics.checkNotNull(g10);
            permissionInterceptor.showPermissionSettingDialog(activity, list, g10, cVar);
        } else {
            if (cVar == null) {
                return;
            }
            cVar.onResult(list, g10);
        }
    }

    @Override // com.qiahao.base_common.interfaceing.OnCommonDialogListener
    public void cancel() {
        OnCommonDialogListener.DefaultImpls.cancel(this);
    }

    @Override // com.qiahao.base_common.interfaceing.OnCommonDialogListener
    public void confirm() {
        final Activity activity = this.$activity;
        List<IPermission> list = this.$deniedList;
        final List<IPermission> list2 = this.$requestList;
        final PermissionInterceptor permissionInterceptor = this.this$0;
        final c cVar = this.$callback;
        h.s(activity, list, new c() { // from class: com.qiahao.base_common.permission.a
            @Override // w9.c
            public final void onResult(List list3, List list4) {
                PermissionInterceptor$showPermissionSettingDialog$1.confirm$lambda$0(activity, list2, permissionInterceptor, cVar, list3, list4);
            }
        });
    }
}
