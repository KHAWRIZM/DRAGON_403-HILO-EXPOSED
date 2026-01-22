package com.qiahao.nextvideo.ui.fillpersonaldata.safetiesreference;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogSafetiesReferenceBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0014¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/ui/fillpersonaldata/safetiesreference/SafetiesReferenceDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogSafetiesReferenceBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getLayoutResId", "", "onInitialize", "", "isNeedFullScreen", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSafetiesReferenceDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafetiesReferenceDialog.kt\ncom/qiahao/nextvideo/ui/fillpersonaldata/safetiesreference/SafetiesReferenceDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,35:1\n61#2,9:36\n*S KotlinDebug\n*F\n+ 1 SafetiesReferenceDialog.kt\ncom/qiahao/nextvideo/ui/fillpersonaldata/safetiesreference/SafetiesReferenceDialog\n*L\n26#1:36,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SafetiesReferenceDialog extends BaseBindingDialog<DialogSafetiesReferenceBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafetiesReferenceDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    protected int getLayoutResId() {
        return R.layout.dialog_safeties_reference;
    }

    protected boolean isNeedFullScreen() {
        return true;
    }

    public void onInitialize() {
        BaseActivity baseActivity;
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        BaseActivity activity = getActivity();
        if (activity instanceof BaseActivity) {
            baseActivity = activity;
        } else {
            baseActivity = null;
        }
        if (baseActivity != null) {
            Toolbar toolbar = ((DialogSafetiesReferenceBinding) getBinding()).toolbar;
            Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
            baseActivity.setStatusBarTopOrBottom(toolbar, false);
        }
        final AppCompatButton appCompatButton = ((DialogSafetiesReferenceBinding) getBinding()).agreeButton;
        final long j = 800;
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.fillpersonaldata.safetiesreference.SafetiesReferenceDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton) > j || (appCompatButton instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton, currentTimeMillis);
                    AppCompatButton appCompatButton2 = appCompatButton;
                    this.dismiss();
                }
            }
        });
    }
}
