package com.qiahao.nextvideo.ui.cp;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatButton;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.interfaceing.MoreDialogListener;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogCpDeleteBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\bR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpDeleteDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogCpDeleteBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "listener", "Lcom/qiahao/base_common/interfaceing/MoreDialogListener;", "getLayoutResId", "", "onInitialize", "", "setListener", "dialogListener", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCpDeleteDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpDeleteDialog.kt\ncom/qiahao/nextvideo/ui/cp/CpDeleteDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,49:1\n61#2,9:50\n61#2,9:59\n61#2,9:68\n*S KotlinDebug\n*F\n+ 1 CpDeleteDialog.kt\ncom/qiahao/nextvideo/ui/cp/CpDeleteDialog\n*L\n29#1:50,9\n33#1:59,9\n37#1:68,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpDeleteDialog extends BaseBindingDialog<DialogCpDeleteBinding> {

    @NotNull
    public static final String CLICK_DELETE = "delete";

    @Nullable
    private MoreDialogListener listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpDeleteDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    protected int getLayoutResId() {
        return R.layout.dialog_cp_delete;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        final View view = ((DialogCpDeleteBinding) getBinding()).backView;
        final long j = 800;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpDeleteDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(view) > j || (view instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(view, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        final AppCompatButton appCompatButton = ((DialogCpDeleteBinding) getBinding()).cancelButton;
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpDeleteDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton) > j || (appCompatButton instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton, currentTimeMillis);
                    AppCompatButton appCompatButton2 = appCompatButton;
                    this.dismiss();
                }
            }
        });
        final AppCompatButton appCompatButton2 = ((DialogCpDeleteBinding) getBinding()).delete;
        appCompatButton2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpDeleteDialog$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MoreDialogListener moreDialogListener;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton2) > j || (appCompatButton2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton2, currentTimeMillis);
                    AppCompatButton appCompatButton3 = appCompatButton2;
                    moreDialogListener = this.listener;
                    if (moreDialogListener != null) {
                        moreDialogListener.clickType("delete");
                    }
                    this.dismiss();
                }
            }
        });
    }

    @NotNull
    public final CpDeleteDialog setListener(@NotNull MoreDialogListener dialogListener) {
        Intrinsics.checkNotNullParameter(dialogListener, "dialogListener");
        this.listener = dialogListener;
        return this;
    }
}
