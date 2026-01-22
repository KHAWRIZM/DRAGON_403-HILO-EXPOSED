package com.qiahao.nextvideo.ui.foodie;

import android.content.Context;
import android.view.View;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ViewFoodieIntroBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0016J\u0006\u0010\u000b\u001a\u00020\n¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/FoodieIntroDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/ViewFoodieIntroBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getLayoutResId", "", "onInitialize", "", "initView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieIntroDialog extends BaseBindingDialog<ViewFoodieIntroBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FoodieIntroDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    protected int getLayoutResId() {
        return R.layout.view_foodie_intro;
    }

    public final void initView() {
        ((ViewFoodieIntroBinding) getBinding()).ivClose.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FoodieIntroDialog.this.dismiss();
            }
        });
        StringBuilder sb2 = new StringBuilder();
        sb2.append(ResourcesKtxKt.getStringById(this, 2131952767));
        sb2.append("\n");
        sb2.append(ResourcesKtxKt.getStringById(this, 2131952768));
        sb2.append("\n");
        sb2.append(ResourcesKtxKt.getStringById(this, 2131952769));
        sb2.append("\n");
        sb2.append(ResourcesKtxKt.getStringById(this, 2131952770));
        sb2.append("\n");
        sb2.append(ResourcesKtxKt.getStringById(this, 2131952771));
        ((ViewFoodieIntroBinding) getBinding()).tvContent.setText(sb2);
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        setSize(-1, -2);
        initView();
    }
}
