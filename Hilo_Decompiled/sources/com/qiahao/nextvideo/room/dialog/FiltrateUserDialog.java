package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.view.View;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseBindingBottomSheetDialog;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogFiltrateUserBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/FiltrateUserDialog;", "Lcom/qiahao/base_common/common/BaseBindingBottomSheetDialog;", "Lcom/qiahao/nextvideo/databinding/DialogFiltrateUserBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "listener", "Lcom/qiahao/nextvideo/room/dialog/FiltrateUserDialog$FiltrateUserDialogListener;", "getListener", "()Lcom/qiahao/nextvideo/room/dialog/FiltrateUserDialog$FiltrateUserDialogListener;", "setListener", "(Lcom/qiahao/nextvideo/room/dialog/FiltrateUserDialog$FiltrateUserDialogListener;)V", "getLayoutResId", "", "onInitialize", "", "FiltrateUserDialogListener", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FiltrateUserDialog extends BaseBindingBottomSheetDialog<DialogFiltrateUserBinding> {

    @Nullable
    private FiltrateUserDialogListener listener;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/FiltrateUserDialog$FiltrateUserDialogListener;", "", "clickButton", "", "type", "", "title", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public interface FiltrateUserDialogListener {
        void clickButton(int type, @NotNull String title);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FiltrateUserDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$0(FiltrateUserDialog filtrateUserDialog, View view) {
        FiltrateUserDialogListener filtrateUserDialogListener = filtrateUserDialog.listener;
        if (filtrateUserDialogListener != null) {
            filtrateUserDialogListener.clickButton(100, ResourcesKtxKt.toStringRes(2131953001));
        }
        filtrateUserDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$1(FiltrateUserDialog filtrateUserDialog, View view) {
        FiltrateUserDialogListener filtrateUserDialogListener = filtrateUserDialog.listener;
        if (filtrateUserDialogListener != null) {
            filtrateUserDialogListener.clickButton(50, ResourcesKtxKt.toStringRes(2131952990));
        }
        filtrateUserDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$2(FiltrateUserDialog filtrateUserDialog, View view) {
        FiltrateUserDialogListener filtrateUserDialogListener = filtrateUserDialog.listener;
        if (filtrateUserDialogListener != null) {
            filtrateUserDialogListener.clickButton(10, ResourcesKtxKt.toStringRes(2131952947));
        }
        filtrateUserDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$3(FiltrateUserDialog filtrateUserDialog, View view) {
        FiltrateUserDialogListener filtrateUserDialogListener = filtrateUserDialog.listener;
        if (filtrateUserDialogListener != null) {
            filtrateUserDialogListener.clickButton(1, ResourcesKtxKt.toStringRes(2131953008));
        }
        filtrateUserDialog.dismiss();
    }

    protected int getLayoutResId() {
        return R.layout.dialog_filtrate_user;
    }

    @Nullable
    public final FiltrateUserDialogListener getListener() {
        return this.listener;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperBottomSheetDialog*/.onInitialize();
        ((DialogFiltrateUserBinding) getBinding()).ownButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FiltrateUserDialog.onInitialize$lambda$0(FiltrateUserDialog.this, view);
            }
        });
        ((DialogFiltrateUserBinding) getBinding()).manageButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FiltrateUserDialog.onInitialize$lambda$1(FiltrateUserDialog.this, view);
            }
        });
        ((DialogFiltrateUserBinding) getBinding()).adminButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FiltrateUserDialog.onInitialize$lambda$2(FiltrateUserDialog.this, view);
            }
        });
        ((DialogFiltrateUserBinding) getBinding()).memberButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FiltrateUserDialog.onInitialize$lambda$3(FiltrateUserDialog.this, view);
            }
        });
        ((DialogFiltrateUserBinding) getBinding()).cancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FiltrateUserDialog.this.dismiss();
            }
        });
    }

    public final void setListener(@Nullable FiltrateUserDialogListener filtrateUserDialogListener) {
        this.listener = filtrateUserDialogListener;
    }
}
