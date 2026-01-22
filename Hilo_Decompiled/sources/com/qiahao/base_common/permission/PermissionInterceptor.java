package com.qiahao.base_common.permission;

import android.app.Activity;
import com.hjq.permissions.permission.base.IPermission;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.R;
import com.qiahao.base_common.ui.dialog.TipTitleDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w9.c;
import w9.d;
import w9.e;
import w9.f;
import w9.h;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJY\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/qiahao/base_common/permission/PermissionInterceptor;", "Lw9/f;", "<init>", "()V", "Landroid/app/Activity;", "activity", "", "Lcom/hjq/permissions/permission/base/IPermission;", "requestList", "deniedList", "Lw9/c;", "callback", "", "showPermissionSettingDialog", "(Landroid/app/Activity;Ljava/util/List;Ljava/util/List;Lw9/c;)V", "", "skipRequest", "grantedList", "onRequestPermissionEnd", "(Landroid/app/Activity;ZLjava/util/List;Ljava/util/List;Ljava/util/List;Lw9/c;)V", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PermissionInterceptor implements f {
    /* JADX INFO: Access modifiers changed from: private */
    public final void showPermissionSettingDialog(Activity activity, List<? extends IPermission> requestList, List<? extends IPermission> deniedList, c callback) {
        new TipTitleDialog(activity).setTitleContent(ResourcesKtxKt.getStringById(this, R.string.permission_alert)).setTipContent(ResourcesKtxKt.getStringById(this, R.string.go_to_authorization)).setDialogListener(new PermissionInterceptor$showPermissionSettingDialog$1(activity, deniedList, requestList, this, callback)).show();
    }

    @Override // w9.f
    public /* bridge */ /* synthetic */ void dispatchPermissionRequest(Activity activity, List list, z9.a aVar, d dVar, c cVar) {
        e.a(this, activity, list, aVar, dVar, cVar);
    }

    @Override // w9.f
    public void onRequestPermissionEnd(@NotNull Activity activity, boolean skipRequest, @NotNull List<? extends IPermission> requestList, @NotNull List<? extends IPermission> grantedList, @NotNull List<? extends IPermission> deniedList, @Nullable c callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(requestList, "requestList");
        Intrinsics.checkNotNullParameter(grantedList, "grantedList");
        Intrinsics.checkNotNullParameter(deniedList, "deniedList");
        if (callback != null) {
            callback.onResult(grantedList, deniedList);
        }
        if (deniedList.isEmpty() || !h.l(activity, deniedList)) {
            return;
        }
        showPermissionSettingDialog(activity, requestList, deniedList, callback);
    }

    @Override // w9.f
    public /* bridge */ /* synthetic */ void onRequestPermissionStart(Activity activity, List list, z9.a aVar, d dVar, c cVar) {
        e.c(this, activity, list, aVar, dVar, cVar);
    }
}
