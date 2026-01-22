package com.qiahao.nextvideo.room.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogPk1v1RuleBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0017¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/PK1v1RuleDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogPk1v1RuleBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getLayoutResId", "", "isBottomStyle", "", "onInitialize", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPK1v1RuleDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PK1v1RuleDialog.kt\ncom/qiahao/nextvideo/room/dialog/PK1v1RuleDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,53:1\n61#2,9:54\n*S KotlinDebug\n*F\n+ 1 PK1v1RuleDialog.kt\ncom/qiahao/nextvideo/room/dialog/PK1v1RuleDialog\n*L\n31#1:54,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PK1v1RuleDialog extends BaseBindingDialog<DialogPk1v1RuleBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PK1v1RuleDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    protected int getLayoutResId() {
        return R.layout.dialog_pk1v1_rule;
    }

    protected boolean isBottomStyle() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public void onInitialize() {
        Drawable createShape$default;
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        final AppCompatImageView appCompatImageView = ((DialogPk1v1RuleBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.PK1v1RuleDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.dismiss();
                }
            }
        });
        ((DialogPk1v1RuleBinding) getBinding()).content.setText(ResourcesKtxKt.getStringById(this, 2131953647) + "\n\n" + ResourcesKtxKt.getStringById(this, 2131953648) + "\n\n" + ResourcesKtxKt.getStringById(this, 2131953649));
        ConstraintLayout constraintLayout = ((DialogPk1v1RuleBinding) getBinding()).constraint;
        if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
            ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            createShape$default = ShapeUtil.createShape$default(shapeUtil, context, 2131099855, 2131099865, 14, 14, 0, 0, (GradientDrawable.Orientation) null, 128, (Object) null);
        } else {
            ShapeUtil shapeUtil2 = ShapeUtil.INSTANCE;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            createShape$default = ShapeUtil.createShape$default(shapeUtil2, context2, 2131099865, 2131099855, 14, 14, 0, 0, (GradientDrawable.Orientation) null, 128, (Object) null);
        }
        constraintLayout.setBackground(createShape$default);
    }
}
