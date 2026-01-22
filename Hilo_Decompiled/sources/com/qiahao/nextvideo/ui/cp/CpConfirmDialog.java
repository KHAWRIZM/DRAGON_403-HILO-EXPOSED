package com.qiahao.nextvideo.ui.cp;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogCpConfirmBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0019\u001a\u00020\u001aH\u0014J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0011J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0011J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006$"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpConfirmDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogCpConfirmBinding;", "context", "Landroid/content/Context;", "isCP", "", "<init>", "(Landroid/content/Context;Z)V", "()Z", "listener", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "getListener", "()Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "setListener", "(Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;)V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "confirmText", "getConfirmText", "setConfirmText", "getLayoutResId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setTipContent", "tip", "setConfirmContent", "confirm", "setDialogListener", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpConfirmDialog extends BaseBindingDialog<DialogCpConfirmBinding> {

    @NotNull
    private String confirmText;

    @NotNull
    private String content;
    private final boolean isCP;

    @Nullable
    private OnCommonDialogListener listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpConfirmDialog(@NotNull Context context, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isCP = z;
        this.content = "";
        this.confirmText = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(CpConfirmDialog cpConfirmDialog, View view) {
        if (HiloUtils.INSTANCE.notFastClick()) {
            OnCommonDialogListener onCommonDialogListener = cpConfirmDialog.listener;
            if (onCommonDialogListener != null) {
                onCommonDialogListener.confirm();
            }
            cpConfirmDialog.dismiss();
        }
    }

    @NotNull
    public final String getConfirmText() {
        return this.confirmText;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_cp_confirm;
    }

    @Nullable
    public final OnCommonDialogListener getListener() {
        return this.listener;
    }

    /* renamed from: isCP, reason: from getter */
    public final boolean getIsCP() {
        return this.isCP;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super/*com.qiahao.base_common.common.BaseDialog*/.onCreate(savedInstanceState);
        if (this.isCP) {
            ((DialogCpConfirmBinding) getBinding()).confirm.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.cp_dialog_long_bg));
            ((DialogCpConfirmBinding) getBinding()).frameLayout.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.shape_ffa9d5_eb6fda_15dp));
        } else {
            ((DialogCpConfirmBinding) getBinding()).confirm.setBackground(androidx.core.content.a.getDrawable(getContext(), 2131233188));
            ((DialogCpConfirmBinding) getBinding()).frameLayout.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.shape_eca9ff_9c6af9_15dp));
        }
        ((DialogCpConfirmBinding) getBinding()).content.setText(this.content);
        if (!TextUtils.isEmpty(this.confirmText)) {
            ((DialogCpConfirmBinding) getBinding()).confirm.setText(this.confirmText);
        }
        ((DialogCpConfirmBinding) getBinding()).confirm.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CpConfirmDialog.onCreate$lambda$0(CpConfirmDialog.this, view);
            }
        });
    }

    @NotNull
    public final CpConfirmDialog setConfirmContent(@NotNull String confirm) {
        Intrinsics.checkNotNullParameter(confirm, "confirm");
        this.confirmText = confirm;
        return this;
    }

    public final void setConfirmText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.confirmText = str;
    }

    public final void setContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    @NotNull
    public final CpConfirmDialog setDialogListener(@NotNull OnCommonDialogListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        return this;
    }

    public final void setListener(@Nullable OnCommonDialogListener onCommonDialogListener) {
        this.listener = onCommonDialogListener;
    }

    @NotNull
    public final CpConfirmDialog setTipContent(@NotNull String tip) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        this.content = tip;
        return this;
    }

    public /* synthetic */ CpConfirmDialog(Context context, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? true : z);
    }
}
