package com.qiahao.nextvideo.ui.home.onlinefeed;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.DialogNotificationPermissionBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/onlinefeed/NotificationPermissionDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogNotificationPermissionBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getLayoutResId", "", "onInitialize", "", "dismiss", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nNotificationPermissionDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationPermissionDialog.kt\ncom/qiahao/nextvideo/ui/home/onlinefeed/NotificationPermissionDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,38:1\n61#2,9:39\n61#2,9:48\n*S KotlinDebug\n*F\n+ 1 NotificationPermissionDialog.kt\ncom/qiahao/nextvideo/ui/home/onlinefeed/NotificationPermissionDialog\n*L\n24#1:39,9\n28#1:48,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class NotificationPermissionDialog extends BaseBindingDialog<DialogNotificationPermissionBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationPermissionDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void dismiss() {
        super.dismiss();
        UserService.INSTANCE.getShared().userRecallWindow();
    }

    protected int getLayoutResId() {
        return R.layout.dialog_notification_permission;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        final AppCompatButton appCompatButton = ((DialogNotificationPermissionBinding) getBinding()).confirmButton;
        final long j = 800;
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.NotificationPermissionDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton) > j || (appCompatButton instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton, currentTimeMillis);
                    AppCompatButton appCompatButton2 = appCompatButton;
                    BaseActivity activity = HiloUtils.INSTANCE.getActivity(this.getContext());
                    if (activity != null) {
                        AppUtilitiesKt.toAppSetting(activity);
                    }
                    this.dismiss();
                }
            }
        });
        final AppCompatImageView appCompatImageView = ((DialogNotificationPermissionBinding) getBinding()).dismissImageView;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.NotificationPermissionDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.dismiss();
                }
            }
        });
    }
}
