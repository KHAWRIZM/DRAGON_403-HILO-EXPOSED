package com.qiahao.base_common.common;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import androidx.fragment.app.FragmentActivity;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.oudi.core.component.SuperDialogFragment;
import com.oudi.core.component.bridge.ComponentAction;
import com.oudi.core.loading.ILoading;
import com.oudi.utils.KeyboardUtils;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.log.ILog;
import com.qiahao.base_common.R;
import com.qiahao.base_common.ui.loading.LoadingDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0014J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u000f\u001a\u00020\rH\u0014J!\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\bH\u0002J\b\u0010\u001e\u001a\u00020\bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/qiahao/base_common/common/BaseDialogFragment;", "Lcom/oudi/core/component/SuperDialogFragment;", "Lcom/oudi/utils/log/ILog;", "<init>", "()V", "loadingDialog", "Lcom/qiahao/base_common/ui/loading/LoadingDialog;", "onInitialize", "", "onInitializeBefore", "onInitializeAfter", "initTitleBar", "getTheme", "", "getWidth", "getHeight", "showLoading", "id", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "", "(Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "dismissLoading", "(Ljava/lang/Integer;)V", "onAction", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/oudi/core/component/bridge/ComponentAction;", "onDestroy", "isEnableEvent", "", "registerEventBus", "unRegisterEventBus", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaseDialogFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseDialogFragment.kt\ncom/qiahao/base_common/common/BaseDialogFragment\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,137:1\n61#2,9:138\n*S KotlinDebug\n*F\n+ 1 BaseDialogFragment.kt\ncom/qiahao/base_common/common/BaseDialogFragment\n*L\n23#1:138,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class BaseDialogFragment extends SuperDialogFragment implements ILog {

    @Nullable
    private LoadingDialog loadingDialog;

    private final void registerEventBus() {
        if (!cf.c.c().j(this)) {
            cf.c.c().p(this);
        }
    }

    private final void unRegisterEventBus() {
        if (cf.c.c().j(this)) {
            cf.c.c().r(this);
        }
    }

    @Override // com.oudi.core.component.SuperDialogFragment, com.oudi.core.loading.ILoading
    public void dismissLoading(@Nullable Integer id) {
        LoadingDialog loadingDialog;
        super.dismissLoading(id);
        LoadingDialog loadingDialog2 = this.loadingDialog;
        if (loadingDialog2 != null && loadingDialog2.isShowing() && (loadingDialog = this.loadingDialog) != null) {
            loadingDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oudi.core.component.SuperDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.oudi.utils.log.ILog
    @NotNull
    public String getLogTag() {
        return ILog.DefaultImpls.getLogTag(this);
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return R.style.base_dialog;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oudi.core.component.SuperDialogFragment
    public int getWidth() {
        return -1;
    }

    protected void initTitleBar() {
    }

    protected boolean isEnableEvent() {
        return false;
    }

    @Override // com.oudi.utils.log.ILog
    public void logD(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logD(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logI(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logI(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logV(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logV(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logW(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logW(this, str, str2, z10);
    }

    @Override // com.oudi.core.component.SuperDialogFragment, com.oudi.core.component.IVmComponent, com.oudi.core.component.bridge.ComponentActionHandler
    public void onAction(@NotNull ComponentAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        super.onAction(action);
        BaseActivity baseActivity = null;
        if (action instanceof FinishAction) {
            dismiss();
            FragmentActivity activity = getActivity();
            if (activity instanceof BaseActivity) {
                baseActivity = (BaseActivity) activity;
            }
            if (baseActivity != null) {
                baseActivity.onAction(action);
                return;
            }
            return;
        }
        if (action instanceof ComponentAction.Jump) {
            FragmentActivity activity2 = getActivity();
            if (activity2 instanceof BaseActivity) {
                baseActivity = (BaseActivity) activity2;
            }
            if (baseActivity != null) {
                baseActivity.onAction(action);
            }
        }
    }

    @Override // com.oudi.core.component.SuperDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ILog.DefaultImpls.logI$default(this, "DialogFragment-onDestroy()", null, true, 2, null);
        ILoading.DefaultImpls.dismissLoading$default(this, null, 1, null);
        this.loadingDialog = null;
        unRegisterEventBus();
    }

    @Override // com.oudi.core.component.SuperDialogFragment, com.oudi.core.component.IVmComponent, com.oudi.core.component.IComponent
    public void onInitialize() {
        super.onInitialize();
        final View view = getView();
        if (view != null) {
            final long j10 = 800;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.common.BaseDialogFragment$onInitialize$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(view) > j10 || (view instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(view, currentTimeMillis);
                        KeyboardUtils.hideSoftInput(view);
                    }
                }
            });
        }
        ILog.DefaultImpls.logI$default(this, "DialogFragment-onInitialize()", null, true, 2, null);
    }

    @Override // com.oudi.core.component.SuperDialogFragment, com.oudi.core.component.IComponent
    public void onInitializeAfter() {
        super.onInitializeAfter();
        if (isEnableEvent()) {
            registerEventBus();
        }
    }

    @Override // com.oudi.core.component.SuperDialogFragment, com.oudi.core.component.IComponent
    public void onInitializeBefore() {
        super.onInitializeBefore();
        initTitleBar();
    }

    @Override // com.oudi.core.component.SuperDialogFragment, com.oudi.core.loading.ILoading
    public void showLoading(@Nullable Integer id, @Nullable CharSequence message) {
        LoadingDialog loadingDialog;
        super.showLoading(id, message);
        if (this.loadingDialog == null) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            this.loadingDialog = new LoadingDialog(requireContext, false, 2, null);
        }
        LoadingDialog loadingDialog2 = this.loadingDialog;
        if ((loadingDialog2 == null || !loadingDialog2.isShowing()) && (loadingDialog = this.loadingDialog) != null) {
            loadingDialog.show();
        }
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, th, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
        ILog.DefaultImpls.logE(this, th, str, z10);
    }
}
