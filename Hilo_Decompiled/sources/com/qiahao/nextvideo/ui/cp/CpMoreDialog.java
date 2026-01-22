package com.qiahao.nextvideo.ui.cp;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatButton;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.interfaceing.MoreDialogListener;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogCpMoreBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpMoreDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogCpMoreBinding;", "context", "Landroid/content/Context;", "mySpace", "", "<init>", "(Landroid/content/Context;Z)V", "getMySpace", "()Z", "setMySpace", "(Z)V", "listener", "Lcom/qiahao/base_common/interfaceing/MoreDialogListener;", "getLayoutResId", "", "onInitialize", "", "setListener", "dialogListener", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCpMoreDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpMoreDialog.kt\ncom/qiahao/nextvideo/ui/cp/CpMoreDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,54:1\n61#2,9:55\n61#2,9:64\n61#2,9:73\n61#2,9:82\n*S KotlinDebug\n*F\n+ 1 CpMoreDialog.kt\ncom/qiahao/nextvideo/ui/cp/CpMoreDialog\n*L\n32#1:55,9\n35#1:64,9\n39#1:73,9\n43#1:82,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpMoreDialog extends BaseBindingDialog<DialogCpMoreBinding> {

    @NotNull
    public static final String CLICK_EXIT = "exit";

    @NotNull
    public static final String CLICK_INTRODUCE = "introduce";

    @Nullable
    private MoreDialogListener listener;
    private boolean mySpace;

    public /* synthetic */ CpMoreDialog(Context context, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? false : z);
    }

    protected int getLayoutResId() {
        return R.layout.dialog_cp_more;
    }

    public final boolean getMySpace() {
        return this.mySpace;
    }

    public void onInitialize() {
        int i;
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        AppCompatButton appCompatButton = ((DialogCpMoreBinding) getBinding()).cpExit;
        int i2 = 8;
        if (this.mySpace) {
            i = 0;
        } else {
            i = 8;
        }
        appCompatButton.setVisibility(i);
        View view = ((DialogCpMoreBinding) getBinding()).cpExitLine;
        if (this.mySpace) {
            i2 = 0;
        }
        view.setVisibility(i2);
        final View view2 = ((DialogCpMoreBinding) getBinding()).backView;
        final long j = 800;
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpMoreDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(view2) > j || (view2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(view2, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        final AppCompatButton appCompatButton2 = ((DialogCpMoreBinding) getBinding()).cpIntroduce;
        appCompatButton2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpMoreDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                MoreDialogListener moreDialogListener;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton2) > j || (appCompatButton2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton2, currentTimeMillis);
                    AppCompatButton appCompatButton3 = appCompatButton2;
                    moreDialogListener = this.listener;
                    if (moreDialogListener != null) {
                        moreDialogListener.clickType(CpMoreDialog.CLICK_INTRODUCE);
                    }
                    this.dismiss();
                }
            }
        });
        final AppCompatButton appCompatButton3 = ((DialogCpMoreBinding) getBinding()).cpExit;
        appCompatButton3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpMoreDialog$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                MoreDialogListener moreDialogListener;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton3) > j || (appCompatButton3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton3, currentTimeMillis);
                    AppCompatButton appCompatButton4 = appCompatButton3;
                    moreDialogListener = this.listener;
                    if (moreDialogListener != null) {
                        moreDialogListener.clickType("exit");
                    }
                    this.dismiss();
                }
            }
        });
        final AppCompatButton appCompatButton4 = ((DialogCpMoreBinding) getBinding()).cancelButton;
        appCompatButton4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpMoreDialog$onInitialize$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton4) > j || (appCompatButton4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton4, currentTimeMillis);
                    AppCompatButton appCompatButton5 = appCompatButton4;
                    this.dismiss();
                }
            }
        });
    }

    @NotNull
    public final CpMoreDialog setListener(@NotNull MoreDialogListener dialogListener) {
        Intrinsics.checkNotNullParameter(dialogListener, "dialogListener");
        this.listener = dialogListener;
        return this;
    }

    public final void setMySpace(boolean z) {
        this.mySpace = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpMoreDialog(@NotNull Context context, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mySpace = z;
    }
}
