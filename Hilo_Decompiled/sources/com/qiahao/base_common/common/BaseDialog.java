package com.qiahao.base_common.common;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.oudi.core.component.SuperDialog;
import com.oudi.core.window.IWindow;
import com.oudi.core.window.OnWindowDismissListener;
import com.oudi.utils.log.ILog;
import com.qiahao.base_common.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0006\u0010\u000fJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\fH\u0014J\b\u0010\u0017\u001a\u00020\fH\u0014J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\fH\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\u0012\u0010\u001f\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010\u0011H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/qiahao/base_common/common/BaseDialog;", "Lcom/oudi/core/component/SuperDialog;", "Lcom/oudi/utils/log/ILog;", "Lcom/oudi/core/window/IWindow;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "themeResId", "", "(Landroid/content/Context;I)V", "cancelable", "", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "(Landroid/content/Context;ZLandroid/content/DialogInterface$OnCancelListener;)V", "onWindowDismissListener", "Lcom/oudi/core/window/OnWindowDismissListener;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "isBottomStyle", "isNeedFullScreen", "setBackgroundDimEnabled", "enabled", "getActivity", "Landroid/app/Activity;", "show", "activity", "dismiss", "setOnDismissListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class BaseDialog extends SuperDialog implements ILog, IWindow {

    @Nullable
    private OnWindowDismissListener onWindowDismissListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseDialog(@NotNull Context context) {
        this(context, R.style.base_dialog);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.oudi.core.component.SuperDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        ILog.DefaultImpls.logI$default(this, "Dialog-dismiss()", null, true, 2, null);
        OnWindowDismissListener onWindowDismissListener = this.onWindowDismissListener;
        if (onWindowDismissListener != null) {
            onWindowDismissListener.onDismiss();
        }
        this.onWindowDismissListener = null;
    }

    @Nullable
    public Activity getActivity() {
        return getActivity(getContext());
    }

    @Override // com.oudi.utils.log.ILog
    @NotNull
    public String getLogTag() {
        return ILog.DefaultImpls.getLogTag(this);
    }

    protected boolean isBottomStyle() {
        return false;
    }

    protected boolean isNeedFullScreen() {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oudi.core.component.SuperDialog, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (isNeedFullScreen()) {
            SuperDialog.setFullScreen$default(this, 0, 1, null);
        }
        if (isBottomStyle()) {
            setGravity(80);
            setSize(-1, -2);
        }
        super.onCreate(savedInstanceState);
    }

    public void setBackgroundDimEnabled(boolean enabled) {
        float f10;
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null) {
            if (enabled) {
                Window window2 = getWindow();
                if (window2 != null && (attributes = window2.getAttributes()) != null) {
                    f10 = attributes.dimAmount;
                } else {
                    f10 = 0.5f;
                }
            } else {
                f10 = DownloadProgress.UNKNOWN_PROGRESS;
            }
            window.setDimAmount(f10);
        }
    }

    @Override // com.oudi.core.window.IWindow
    public void setOnDismissListener(@Nullable OnWindowDismissListener listener) {
        this.onWindowDismissListener = listener;
    }

    @Override // com.oudi.core.window.IWindow
    public void show(@Nullable Activity activity) {
        super.show();
        ILog.DefaultImpls.logI$default(this, "Dialog-show()", null, true, 2, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDialog(@NotNull Context context, int i10) {
        super(context, i10);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Activity getActivity(Context context) {
        if (context != null) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (context instanceof ContextWrapper) {
                return getActivity(((ContextWrapper) context).getBaseContext());
            }
        }
        return null;
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, th, str2, z10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDialog(@NotNull Context context, boolean z10, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        super(context, z10, onCancelListener);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
        ILog.DefaultImpls.logE(this, th, str, z10);
    }
}
