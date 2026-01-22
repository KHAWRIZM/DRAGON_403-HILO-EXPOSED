package com.qiahao.nextvideo.ui.home.chat.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogImCleanMessageBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/dialog/IMCleanDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogImCleanMessageBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mListener", "Lcom/qiahao/nextvideo/ui/home/chat/dialog/IMMessageListener;", "getMListener", "()Lcom/qiahao/nextvideo/ui/home/chat/dialog/IMMessageListener;", "setMListener", "(Lcom/qiahao/nextvideo/ui/home/chat/dialog/IMMessageListener;)V", "getLayoutResId", "", "isBottomStyle", "", "onInitialize", "", "setClickListener", "iMMessageListener", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nIMCleanDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IMCleanDialog.kt\ncom/qiahao/nextvideo/ui/home/chat/dialog/IMCleanDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,50:1\n61#2,9:51\n61#2,9:60\n61#2,9:69\n*S KotlinDebug\n*F\n+ 1 IMCleanDialog.kt\ncom/qiahao/nextvideo/ui/home/chat/dialog/IMCleanDialog\n*L\n28#1:51,9\n32#1:60,9\n36#1:69,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class IMCleanDialog extends BaseBindingDialog<DialogImCleanMessageBinding> {

    @Nullable
    private IMMessageListener mListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMCleanDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    protected int getLayoutResId() {
        return R.layout.dialog_im_clean_message;
    }

    @Nullable
    public final IMMessageListener getMListener() {
        return this.mListener;
    }

    protected boolean isBottomStyle() {
        return true;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        final TextView textView = ((DialogImCleanMessageBinding) getBinding()).delete;
        final long j = 800;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.IMCleanDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    IMMessageListener mListener = this.getMListener();
                    if (mListener != null) {
                        mListener.delete();
                    }
                    this.dismiss();
                }
            }
        });
        final TextView textView2 = ((DialogImCleanMessageBinding) getBinding()).markRead;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.IMCleanDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    IMMessageListener mListener = this.getMListener();
                    if (mListener != null) {
                        mListener.markRead();
                    }
                    this.dismiss();
                }
            }
        });
        final TextView textView3 = ((DialogImCleanMessageBinding) getBinding()).cancel;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.IMCleanDialog$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView3) > j || (textView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView3, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
    }

    @NotNull
    public final IMCleanDialog setClickListener(@NotNull IMMessageListener iMMessageListener) {
        Intrinsics.checkNotNullParameter(iMMessageListener, "iMMessageListener");
        this.mListener = iMMessageListener;
        return this;
    }

    public final void setMListener(@Nullable IMMessageListener iMMessageListener) {
        this.mListener = iMMessageListener;
    }
}
