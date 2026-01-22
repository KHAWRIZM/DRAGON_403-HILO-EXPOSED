package com.qiahao.nextvideo.ui.foodie;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ViewFoodieBigRewardRuleBinding;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/FoodieBigRewardRuleDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/ViewFoodieBigRewardRuleBinding;", "Landroid/content/Context;", "context", "Lcom/qiahao/nextvideo/ui/foodie/h;", "type", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/ui/foodie/h;)V", "", "setData", "()V", "", "getLayoutResId", "()I", "onInitialize", "Lcom/qiahao/nextvideo/ui/foodie/h;", "getType", "()Lcom/qiahao/nextvideo/ui/foodie/h;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieBigRewardRuleDialog extends BaseBindingDialog<ViewFoodieBigRewardRuleBinding> {

    @NotNull
    private final h type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FoodieBigRewardRuleDialog(@NotNull Context context, @NotNull h hVar) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hVar, "type");
        this.type = hVar;
    }

    private final void setData() {
        if (this.type == h.VEGETABLE) {
            ((ViewFoodieBigRewardRuleBinding) getBinding()).tvRule.setText(ResourcesKtxKt.getStringById(this, 2131952765));
            ImageView imageView = ((ViewFoodieBigRewardRuleBinding) getBinding()).iv1;
            Intrinsics.checkNotNullExpressionValue(imageView, "iv1");
            FoodieUtil foodieUtil = FoodieUtil.INSTANCE;
            ImageKtxKt.loadImage$default(imageView, foodieUtil.getFoodieIcon(1), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            ImageView imageView2 = ((ViewFoodieBigRewardRuleBinding) getBinding()).iv2;
            Intrinsics.checkNotNullExpressionValue(imageView2, "iv2");
            ImageKtxKt.loadImage$default(imageView2, foodieUtil.getFoodieIcon(2), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            ImageView imageView3 = ((ViewFoodieBigRewardRuleBinding) getBinding()).iv3;
            Intrinsics.checkNotNullExpressionValue(imageView3, "iv3");
            ImageKtxKt.loadImage$default(imageView3, foodieUtil.getFoodieIcon(3), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            ImageView imageView4 = ((ViewFoodieBigRewardRuleBinding) getBinding()).iv4;
            Intrinsics.checkNotNullExpressionValue(imageView4, "iv4");
            ImageKtxKt.loadImage$default(imageView4, foodieUtil.getFoodieIcon(4), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            return;
        }
        ((ViewFoodieBigRewardRuleBinding) getBinding()).tvRule.setText(ResourcesKtxKt.getStringById(this, 2131952764));
        ImageView imageView5 = ((ViewFoodieBigRewardRuleBinding) getBinding()).iv1;
        Intrinsics.checkNotNullExpressionValue(imageView5, "iv1");
        FoodieUtil foodieUtil2 = FoodieUtil.INSTANCE;
        ImageKtxKt.loadImage$default(imageView5, foodieUtil2.getFoodieIcon(5), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        ImageView imageView6 = ((ViewFoodieBigRewardRuleBinding) getBinding()).iv2;
        Intrinsics.checkNotNullExpressionValue(imageView6, "iv2");
        ImageKtxKt.loadImage$default(imageView6, foodieUtil2.getFoodieIcon(6), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        ImageView imageView7 = ((ViewFoodieBigRewardRuleBinding) getBinding()).iv3;
        Intrinsics.checkNotNullExpressionValue(imageView7, "iv3");
        ImageKtxKt.loadImage$default(imageView7, foodieUtil2.getFoodieIcon(7), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        ImageView imageView8 = ((ViewFoodieBigRewardRuleBinding) getBinding()).iv4;
        Intrinsics.checkNotNullExpressionValue(imageView8, "iv4");
        ImageKtxKt.loadImage$default(imageView8, foodieUtil2.getFoodieIcon(8), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
    }

    protected int getLayoutResId() {
        return R.layout.view_foodie_big_reward_rule;
    }

    @NotNull
    public final h getType() {
        return this.type;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        setSize(-1, -2);
        ((ViewFoodieBigRewardRuleBinding) getBinding()).ivCross.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FoodieBigRewardRuleDialog.this.dismiss();
            }
        });
        setData();
    }
}
