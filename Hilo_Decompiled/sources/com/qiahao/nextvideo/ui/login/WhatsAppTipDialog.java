package com.qiahao.nextvideo.ui.login;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogWhatsTipBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/ui/login/WhatsAppTipDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogWhatsTipBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getLayoutResId", "", "isNeedFullScreen", "", "onInitialize", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWhatsAppTipDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WhatsAppTipDialog.kt\ncom/qiahao/nextvideo/ui/login/WhatsAppTipDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,40:1\n61#2,9:41\n61#2,9:50\n61#2,9:59\n*S KotlinDebug\n*F\n+ 1 WhatsAppTipDialog.kt\ncom/qiahao/nextvideo/ui/login/WhatsAppTipDialog\n*L\n30#1:41,9\n31#1:50,9\n34#1:59,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class WhatsAppTipDialog extends BaseBindingDialog<DialogWhatsTipBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WhatsAppTipDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    protected int getLayoutResId() {
        return R.layout.dialog_whats_tip;
    }

    protected boolean isNeedFullScreen() {
        return true;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        ConstraintLayout constraintLayout = ((DialogWhatsTipBinding) getBinding()).constraint;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        constraintLayout.setBackground(ShapeUtil.createShape$default(shapeUtil, "#ffffff", "#ffffff", 15, (GradientDrawable.Orientation) null, 8, (Object) null));
        ((DialogWhatsTipBinding) getBinding()).confirm.setBackground(ShapeUtil.createShape$default(shapeUtil, "#9036FF", "#9036FF", 18, (GradientDrawable.Orientation) null, 8, (Object) null));
        ImageView imageView = ((DialogWhatsTipBinding) getBinding()).handIcon;
        Intrinsics.checkNotNullExpressionValue(imageView, "handIcon");
        ImageKtxKt.toHorizontalMirror(imageView, R.drawable.whats_hand_icon);
        final ConstraintLayout constraintLayout2 = ((DialogWhatsTipBinding) getBinding()).constraint;
        final long j = 800;
        constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.WhatsAppTipDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout2) > j || (constraintLayout2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout2, currentTimeMillis);
                    ConstraintLayout constraintLayout3 = constraintLayout2;
                }
            }
        });
        final FrameLayout frameLayout = ((DialogWhatsTipBinding) getBinding()).frameLayout;
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.WhatsAppTipDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j || (frameLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        final TextView textView = ((DialogWhatsTipBinding) getBinding()).confirm;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.WhatsAppTipDialog$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
    }
}
