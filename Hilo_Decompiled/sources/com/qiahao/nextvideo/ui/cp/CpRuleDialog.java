package com.qiahao.nextvideo.ui.cp;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogCpRuleBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u0006H\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpRuleDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogCpRuleBinding;", "context", "Landroid/content/Context;", CpSpaceActivity.RELATION_TYPE, "", "<init>", "(Landroid/content/Context;I)V", "getRelationType", "()I", "setRelationType", "(I)V", "getLayoutResId", "isNeedFullScreen", "", "onInitialize", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCpRuleDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpRuleDialog.kt\ncom/qiahao/nextvideo/ui/cp/CpRuleDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,76:1\n61#2,9:77\n*S KotlinDebug\n*F\n+ 1 CpRuleDialog.kt\ncom/qiahao/nextvideo/ui/cp/CpRuleDialog\n*L\n71#1:77,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpRuleDialog extends BaseBindingDialog<DialogCpRuleBinding> {
    private int relationType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpRuleDialog(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.relationType = i;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_cp_rule;
    }

    public final int getRelationType() {
        return this.relationType;
    }

    protected boolean isNeedFullScreen() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        if (this.relationType == 1) {
            ((DialogCpRuleBinding) getBinding()).bindTitle.setText(ResourcesKtxKt.getStringById(this, 2131952417));
            ((DialogCpRuleBinding) getBinding()).bindContent.setText(ResourcesKtxKt.getStringById(this, 2131952434));
            ((DialogCpRuleBinding) getBinding()).unBindTitle.setText(ResourcesKtxKt.getStringById(this, 2131952418));
            ((DialogCpRuleBinding) getBinding()).unBindContent.setText(ResourcesKtxKt.getStringById(this, 2131952446));
            ((DialogCpRuleBinding) getBinding()).cpNickTitle.setText(ResourcesKtxKt.getStringById(this, 2131952414));
            ((DialogCpRuleBinding) getBinding()).cpNickContent.setText(ResourcesKtxKt.getStringById(this, 2131952413));
        } else {
            ((DialogCpRuleBinding) getBinding()).bindTitle.setText(ResourcesKtxKt.getStringById(this, 2131953893));
            ((DialogCpRuleBinding) getBinding()).bindContent.setText(ResourcesKtxKt.getStringById(this, 2131953890));
            ((DialogCpRuleBinding) getBinding()).unBindTitle.setText(ResourcesKtxKt.getStringById(this, 2131953894));
            ((DialogCpRuleBinding) getBinding()).unBindContent.setText(ResourcesKtxKt.getStringById(this, 2131953891));
            ((DialogCpRuleBinding) getBinding()).cpNickTitle.setText(ResourcesKtxKt.getStringById(this, 2131953895));
            ((DialogCpRuleBinding) getBinding()).cpNickContent.setText(ResourcesKtxKt.getStringById(this, 2131953892));
        }
        int i = this.relationType;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        ((DialogCpRuleBinding) getBinding()).constraint.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.brother_space_bg));
                        ((DialogCpRuleBinding) getBinding()).flower.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.brother_rule_flower));
                        ((DialogCpRuleBinding) getBinding()).title.setBackground(androidx.core.content.a.getDrawable(getContext(), 2131231217));
                        ((DialogCpRuleBinding) getBinding()).close.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.brother_close));
                    }
                } else {
                    ((DialogCpRuleBinding) getBinding()).constraint.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.bestie_space_bg));
                    ((DialogCpRuleBinding) getBinding()).flower.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.bestie_rule_flower));
                    ((DialogCpRuleBinding) getBinding()).title.setBackground(androidx.core.content.a.getDrawable(getContext(), 2131230931));
                    ((DialogCpRuleBinding) getBinding()).close.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.bestie_close));
                }
            } else {
                ((DialogCpRuleBinding) getBinding()).constraint.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.soul_space_bg));
                ((DialogCpRuleBinding) getBinding()).flower.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.soul_rule_flower));
                ((DialogCpRuleBinding) getBinding()).title.setBackground(androidx.core.content.a.getDrawable(getContext(), 2131233433));
                ((DialogCpRuleBinding) getBinding()).close.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.soul_close));
            }
        } else {
            ((DialogCpRuleBinding) getBinding()).constraint.setBackground(androidx.core.content.a.getDrawable(getContext(), 2131231630));
            ((DialogCpRuleBinding) getBinding()).flower.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.cp_rule_flower));
            ((DialogCpRuleBinding) getBinding()).title.setBackground(androidx.core.content.a.getDrawable(getContext(), 2131231623));
            ((DialogCpRuleBinding) getBinding()).close.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.cp_close));
        }
        final ImageView imageView = ((DialogCpRuleBinding) getBinding()).close;
        final long j = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpRuleDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
    }

    public final void setRelationType(int i) {
        this.relationType = i;
    }

    public /* synthetic */ CpRuleDialog(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? 1 : i);
    }
}
