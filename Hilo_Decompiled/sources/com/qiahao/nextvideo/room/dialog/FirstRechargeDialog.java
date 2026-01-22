package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.view.View;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.interfaceing.BaseDialogInterface;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogFirstRechargeBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/FirstRechargeDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogFirstRechargeBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "listener", "Lcom/qiahao/base_common/interfaceing/BaseDialogInterface;", "getListener", "()Lcom/qiahao/base_common/interfaceing/BaseDialogInterface;", "setListener", "(Lcom/qiahao/base_common/interfaceing/BaseDialogInterface;)V", "getLayoutResId", "", "onInitialize", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FirstRechargeDialog extends BaseBindingDialog<DialogFirstRechargeBinding> {

    @Nullable
    private BaseDialogInterface listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirstRechargeDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$0(FirstRechargeDialog firstRechargeDialog, View view) {
        BaseDialogInterface baseDialogInterface = firstRechargeDialog.listener;
        if (baseDialogInterface != null) {
            baseDialogInterface.clickConfirm();
        }
        firstRechargeDialog.dismiss();
    }

    protected int getLayoutResId() {
        return R.layout.dialog_first_recharge;
    }

    @Nullable
    public final BaseDialogInterface getListener() {
        return this.listener;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        ((DialogFirstRechargeBinding) getBinding()).image.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FirstRechargeDialog.onInitialize$lambda$0(FirstRechargeDialog.this, view);
            }
        });
        ((DialogFirstRechargeBinding) getBinding()).closeImage.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FirstRechargeDialog.this.dismiss();
            }
        });
    }

    public final void setListener(@Nullable BaseDialogInterface baseDialogInterface) {
        this.listener = baseDialogInterface;
    }
}
