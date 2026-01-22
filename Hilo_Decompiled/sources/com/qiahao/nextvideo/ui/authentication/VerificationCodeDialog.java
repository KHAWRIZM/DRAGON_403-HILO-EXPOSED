package com.qiahao.nextvideo.ui.authentication;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogVerificationBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0013\u001a\u00020\bH\u0014J\b\u0010\u0014\u001a\u00020\u000eH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/ui/authentication/VerificationCodeDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogVerificationBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mSelectType", "", "mListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "selectType", "", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "(Lkotlin/jvm/functions/Function1;)V", "getLayoutResId", "onInitialize", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVerificationCodeDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerificationCodeDialog.kt\ncom/qiahao/nextvideo/ui/authentication/VerificationCodeDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,54:1\n61#2,9:55\n61#2,9:64\n61#2,9:73\n61#2,9:82\n*S KotlinDebug\n*F\n+ 1 VerificationCodeDialog.kt\ncom/qiahao/nextvideo/ui/authentication/VerificationCodeDialog\n*L\n36#1:55,9\n41#1:64,9\n46#1:73,9\n50#1:82,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VerificationCodeDialog extends BaseBindingDialog<DialogVerificationBinding> {

    @Nullable
    private Function1<? super Integer, Unit> mListener;
    private int mSelectType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerificationCodeDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSelectType = 1;
    }

    public static final /* synthetic */ DialogVerificationBinding access$getBinding(VerificationCodeDialog verificationCodeDialog) {
        return (DialogVerificationBinding) verificationCodeDialog.getBinding();
    }

    protected int getLayoutResId() {
        return R.layout.dialog_verification;
    }

    @Nullable
    public final Function1<Integer, Unit> getMListener() {
        return this.mListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        ((DialogVerificationBinding) getBinding()).select1.setSelected(true);
        TextView textView = ((DialogVerificationBinding) getBinding()).recommend;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setBackground(shapeUtil.createShape(context, 2131099943, 2131099942, 7, 7, 7, 0, GradientDrawable.Orientation.TOP_BOTTOM));
        final ConstraintLayout constraintLayout = ((DialogVerificationBinding) getBinding()).whatsLayout;
        final long j = 800;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.authentication.VerificationCodeDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    this.mSelectType = 1;
                    VerificationCodeDialog.access$getBinding(this).select1.setSelected(true);
                    VerificationCodeDialog.access$getBinding(this).select2.setSelected(false);
                }
            }
        });
        final ConstraintLayout constraintLayout2 = ((DialogVerificationBinding) getBinding()).smsLayout;
        constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.authentication.VerificationCodeDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout2) > j || (constraintLayout2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout2, currentTimeMillis);
                    ConstraintLayout constraintLayout3 = constraintLayout2;
                    this.mSelectType = 0;
                    VerificationCodeDialog.access$getBinding(this).select1.setSelected(false);
                    VerificationCodeDialog.access$getBinding(this).select2.setSelected(true);
                }
            }
        });
        final TextView textView2 = ((DialogVerificationBinding) getBinding()).confirm;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.authentication.VerificationCodeDialog$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    Function1<Integer, Unit> mListener = this.getMListener();
                    if (mListener != null) {
                        i = this.mSelectType;
                        mListener.invoke(Integer.valueOf(i));
                    }
                    this.dismiss();
                }
            }
        });
        final TextView textView3 = ((DialogVerificationBinding) getBinding()).cancel;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.authentication.VerificationCodeDialog$onInitialize$$inlined$singleClick$default$4
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

    public final void setMListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.mListener = function1;
    }
}
