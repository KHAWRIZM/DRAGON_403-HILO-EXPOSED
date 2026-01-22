package com.qiahao.base_common.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatButton;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.R;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.databinding.DialogChatMenuBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/qiahao/base_common/ui/dialog/ChatMenuDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/base_common/databinding/DialogChatMenuBinding;", "context", "Landroid/content/Context;", "showProfile", "", "showDelete", "<init>", "(Landroid/content/Context;ZZ)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/qiahao/base_common/ui/dialog/ChatMenuDialogListener;", "getListener", "()Lcom/qiahao/base_common/ui/dialog/ChatMenuDialogListener;", "setListener", "(Lcom/qiahao/base_common/ui/dialog/ChatMenuDialogListener;)V", "getLayoutResId", "", "dialogListener", "onInitialize", "", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nChatMenuDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChatMenuDialog.kt\ncom/qiahao/base_common/ui/dialog/ChatMenuDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,68:1\n61#2,9:69\n61#2,9:78\n61#2,9:87\n61#2,9:96\n61#2,9:105\n*S KotlinDebug\n*F\n+ 1 ChatMenuDialog.kt\ncom/qiahao/base_common/ui/dialog/ChatMenuDialog\n*L\n44#1:69,9\n45#1:78,9\n49#1:87,9\n53#1:96,9\n57#1:105,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ChatMenuDialog extends BaseBindingDialog<DialogChatMenuBinding> {

    @NotNull
    public static final String CLICK_BLOCK = "block";

    @NotNull
    public static final String CLICK_DELETE = "delete";

    @NotNull
    public static final String CLICK_PROFILE = "profile";

    @NotNull
    public static final String CLICK_REPORT = "report";

    @Nullable
    private ChatMenuDialogListener listener;
    private final boolean showDelete;
    private final boolean showProfile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatMenuDialog(@NotNull Context context, boolean z10, boolean z11) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.showProfile = z10;
        this.showDelete = z11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oudi.core.component.SuperDialog
    public int getLayoutResId() {
        return R.layout.dialog_chat_menu;
    }

    @Nullable
    public final ChatMenuDialogListener getListener() {
        return this.listener;
    }

    @Override // com.oudi.core.component.SuperDialog, com.oudi.core.component.IComponent
    public void onInitialize() {
        super.onInitialize();
        if (!this.showProfile) {
            getBinding().profileLine.setVisibility(8);
            getBinding().profileButton.setVisibility(8);
        }
        if (!this.showDelete) {
            getBinding().deleteButton.setVisibility(8);
            getBinding().deleteLine.setVisibility(8);
        }
        final AppCompatButton appCompatButton = getBinding().cancelButton;
        final long j10 = 800;
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.ui.dialog.ChatMenuDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton) > j10 || (appCompatButton instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        final AppCompatButton appCompatButton2 = getBinding().profileButton;
        appCompatButton2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.ui.dialog.ChatMenuDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton2) > j10 || (appCompatButton2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton2, currentTimeMillis);
                    ChatMenuDialogListener listener = this.getListener();
                    if (listener != null) {
                        listener.clickType("profile");
                    }
                    this.dismiss();
                }
            }
        });
        final AppCompatButton appCompatButton3 = getBinding().deleteButton;
        appCompatButton3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.ui.dialog.ChatMenuDialog$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton3) > j10 || (appCompatButton3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton3, currentTimeMillis);
                    ChatMenuDialogListener listener = this.getListener();
                    if (listener != null) {
                        listener.clickType(ChatMenuDialog.CLICK_DELETE);
                    }
                    this.dismiss();
                }
            }
        });
        final AppCompatButton appCompatButton4 = getBinding().reportButton;
        appCompatButton4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.ui.dialog.ChatMenuDialog$onInitialize$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton4) > j10 || (appCompatButton4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton4, currentTimeMillis);
                    ChatMenuDialogListener listener = this.getListener();
                    if (listener != null) {
                        listener.clickType(ChatMenuDialog.CLICK_REPORT);
                    }
                    this.dismiss();
                }
            }
        });
        final AppCompatButton appCompatButton5 = getBinding().blockButton;
        appCompatButton5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.ui.dialog.ChatMenuDialog$onInitialize$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton5) > j10 || (appCompatButton5 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton5, currentTimeMillis);
                    ChatMenuDialogListener listener = this.getListener();
                    if (listener != null) {
                        listener.clickType(ChatMenuDialog.CLICK_BLOCK);
                    }
                    this.dismiss();
                }
            }
        });
    }

    /* renamed from: setListener, reason: collision with other method in class */
    public final void m٥٢٦setListener(@Nullable ChatMenuDialogListener chatMenuDialogListener) {
        this.listener = chatMenuDialogListener;
    }

    public /* synthetic */ ChatMenuDialog(Context context, boolean z10, boolean z11, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? true : z10, (i10 & 4) != 0 ? true : z11);
    }

    @NotNull
    public final ChatMenuDialog setListener(@NotNull ChatMenuDialogListener dialogListener) {
        Intrinsics.checkNotNullParameter(dialogListener, "dialogListener");
        this.listener = dialogListener;
        return this;
    }
}
