package com.qiahao.base_common.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatButton;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.R;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.databinding.DialogImageTypeBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0014J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/qiahao/base_common/ui/dialog/ImageTypeDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/base_common/databinding/DialogImageTypeBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/qiahao/base_common/ui/dialog/ImageTypeDialogListener;", "getListener", "()Lcom/qiahao/base_common/ui/dialog/ImageTypeDialogListener;", "setListener", "(Lcom/qiahao/base_common/ui/dialog/ImageTypeDialogListener;)V", "getLayoutResId", "", "dialogListener", "onInitialize", "", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nImageTypeDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageTypeDialog.kt\ncom/qiahao/base_common/ui/dialog/ImageTypeDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,51:1\n61#2,9:52\n61#2,9:61\n61#2,9:70\n*S KotlinDebug\n*F\n+ 1 ImageTypeDialog.kt\ncom/qiahao/base_common/ui/dialog/ImageTypeDialog\n*L\n35#1:52,9\n36#1:61,9\n40#1:70,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ImageTypeDialog extends BaseBindingDialog<DialogImageTypeBinding> {

    @NotNull
    public static final String CLICK_GIFT = "gif";

    @NotNull
    public static final String CLICK_OTHER = "other";

    @Nullable
    private ImageTypeDialogListener listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageTypeDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oudi.core.component.SuperDialog
    public int getLayoutResId() {
        return R.layout.dialog_image_type;
    }

    @Nullable
    public final ImageTypeDialogListener getListener() {
        return this.listener;
    }

    @Override // com.oudi.core.component.SuperDialog, com.oudi.core.component.IComponent
    public void onInitialize() {
        super.onInitialize();
        final AppCompatButton appCompatButton = getBinding().cancelButton;
        final long j10 = 800;
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.ui.dialog.ImageTypeDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton) > j10 || (appCompatButton instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        final AppCompatButton appCompatButton2 = getBinding().gif;
        appCompatButton2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.ui.dialog.ImageTypeDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton2) > j10 || (appCompatButton2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton2, currentTimeMillis);
                    ImageTypeDialogListener listener = this.getListener();
                    if (listener != null) {
                        listener.clickType(ImageTypeDialog.CLICK_GIFT);
                    }
                    this.dismiss();
                }
            }
        });
        final AppCompatButton appCompatButton3 = getBinding().other;
        appCompatButton3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.ui.dialog.ImageTypeDialog$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton3) > j10 || (appCompatButton3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton3, currentTimeMillis);
                    ImageTypeDialogListener listener = this.getListener();
                    if (listener != null) {
                        listener.clickType("other");
                    }
                    this.dismiss();
                }
            }
        });
    }

    /* renamed from: setListener, reason: collision with other method in class */
    public final void m٥٢٧setListener(@Nullable ImageTypeDialogListener imageTypeDialogListener) {
        this.listener = imageTypeDialogListener;
    }

    @NotNull
    public final ImageTypeDialog setListener(@NotNull ImageTypeDialogListener dialogListener) {
        Intrinsics.checkNotNullParameter(dialogListener, "dialogListener");
        this.listener = dialogListener;
        return this;
    }
}
