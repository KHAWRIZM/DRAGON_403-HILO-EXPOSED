package com.tencent.qcloud.tuikit.tuichat.hilo.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.databinding.DialogImMessageClickBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u000eH\u0014J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006 "}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/dialog/IMMessageClickBottomDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/DialogImMessageClickBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mListener", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/dialog/IMMessageListener;", "getMListener", "()Lcom/tencent/qcloud/tuikit/tuichat/hilo/dialog/IMMessageListener;", "setMListener", "(Lcom/tencent/qcloud/tuikit/tuichat/hilo/dialog/IMMessageListener;)V", "mShowDelete", "", "getMShowDelete", "()Z", "setMShowDelete", "(Z)V", "mShowCopy", "getMShowCopy", "setMShowCopy", "mShowRevocation", "getMShowRevocation", "setMShowRevocation", "getLayoutResId", "", "isBottomStyle", "onInitialize", "", "setClickListener", "iMMessageListener", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nIMMessageClickBottomDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IMMessageClickBottomDialog.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/dialog/IMMessageClickBottomDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,72:1\n61#2,9:73\n61#2,9:82\n61#2,9:91\n61#2,9:100\n*S KotlinDebug\n*F\n+ 1 IMMessageClickBottomDialog.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/dialog/IMMessageClickBottomDialog\n*L\n45#1:73,9\n49#1:82,9\n53#1:91,9\n57#1:100,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class IMMessageClickBottomDialog extends BaseBindingDialog<DialogImMessageClickBinding> {

    @Nullable
    private IMMessageListener mListener;
    private boolean mShowCopy;
    private boolean mShowDelete;
    private boolean mShowRevocation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMMessageClickBottomDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mShowDelete = true;
        this.mShowCopy = true;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_im_message_click;
    }

    @Nullable
    public final IMMessageListener getMListener() {
        return this.mListener;
    }

    public final boolean getMShowCopy() {
        return this.mShowCopy;
    }

    public final boolean getMShowDelete() {
        return this.mShowDelete;
    }

    public final boolean getMShowRevocation() {
        return this.mShowRevocation;
    }

    protected boolean isBottomStyle() {
        return true;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        if (!this.mShowDelete) {
            ((DialogImMessageClickBinding) getBinding()).delete.setVisibility(8);
            ((DialogImMessageClickBinding) getBinding()).deleteView.setVisibility(8);
        }
        if (!this.mShowCopy) {
            ((DialogImMessageClickBinding) getBinding()).copy.setVisibility(8);
            ((DialogImMessageClickBinding) getBinding()).deleteView.setVisibility(8);
        }
        if (!this.mShowRevocation) {
            ((DialogImMessageClickBinding) getBinding()).revocation.setVisibility(8);
            ((DialogImMessageClickBinding) getBinding()).revocationView.setVisibility(8);
        }
        final TextView textView = ((DialogImMessageClickBinding) getBinding()).copy;
        final long j = 800;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.dialog.IMMessageClickBottomDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    IMMessageListener mListener = this.getMListener();
                    if (mListener != null) {
                        mListener.copy();
                    }
                    this.dismiss();
                }
            }
        });
        final TextView textView2 = ((DialogImMessageClickBinding) getBinding()).delete;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.dialog.IMMessageClickBottomDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    IMMessageListener mListener = this.getMListener();
                    if (mListener != null) {
                        mListener.delete();
                    }
                    this.dismiss();
                }
            }
        });
        final TextView textView3 = ((DialogImMessageClickBinding) getBinding()).revocation;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.dialog.IMMessageClickBottomDialog$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView3) > j || (textView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView3, currentTimeMillis);
                    IMMessageListener mListener = this.getMListener();
                    if (mListener != null) {
                        mListener.revocation();
                    }
                    this.dismiss();
                }
            }
        });
        final TextView textView4 = ((DialogImMessageClickBinding) getBinding()).cancel;
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.dialog.IMMessageClickBottomDialog$onInitialize$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView4) > j || (textView4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView4, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
    }

    @NotNull
    public final IMMessageClickBottomDialog setClickListener(@NotNull IMMessageListener iMMessageListener) {
        Intrinsics.checkNotNullParameter(iMMessageListener, "iMMessageListener");
        this.mListener = iMMessageListener;
        return this;
    }

    public final void setMListener(@Nullable IMMessageListener iMMessageListener) {
        this.mListener = iMMessageListener;
    }

    public final void setMShowCopy(boolean z) {
        this.mShowCopy = z;
    }

    public final void setMShowDelete(boolean z) {
        this.mShowDelete = z;
    }

    public final void setMShowRevocation(boolean z) {
        this.mShowRevocation = z;
    }
}
