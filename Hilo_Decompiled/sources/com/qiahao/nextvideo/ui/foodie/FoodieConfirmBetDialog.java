package com.qiahao.nextvideo.ui.foodie;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ViewFoodieConfirmBetDialog2Binding;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0006H\u0014J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0006\u0010\u0010\u001a\u00020\rJ\b\u0010\u0011\u001a\u00020\rH\u0016J\u001a\u0010\u0012\u001a\u00020\r2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/FoodieConfirmBetDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/ViewFoodieConfirmBetDialog2Binding;", "context", "Landroid/content/Context;", "mMoney", "", "<init>", "(Landroid/content/Context;I)V", "getLayoutResId", "onConfirm", "Lkotlin/Function1;", "", "", "isDontShowNextTime", "onInitialize", "initView", "show", "showDialog", "listener", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieConfirmBetDialog extends BaseBindingDialog<ViewFoodieConfirmBetDialog2Binding> {
    private boolean isDontShowNextTime;
    private final int mMoney;

    @Nullable
    private Function1<? super Boolean, Unit> onConfirm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FoodieConfirmBetDialog(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mMoney = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$1(FoodieConfirmBetDialog foodieConfirmBetDialog, View view) {
        boolean z = foodieConfirmBetDialog.isDontShowNextTime;
        foodieConfirmBetDialog.isDontShowNextTime = !z;
        if (!z) {
            ((ViewFoodieConfirmBetDialog2Binding) foodieConfirmBetDialog.getBinding()).ivCheckBox.setImageDrawable(androidx.core.content.a.getDrawable(foodieConfirmBetDialog.getContext(), R.drawable.ic_daily_checked_in));
        } else {
            ((ViewFoodieConfirmBetDialog2Binding) foodieConfirmBetDialog.getBinding()).ivCheckBox.setImageDrawable(androidx.core.content.a.getDrawable(foodieConfirmBetDialog.getContext(), R.drawable.bg_foodie_confirmbet_white_circle));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$2(FoodieConfirmBetDialog foodieConfirmBetDialog, View view) {
        boolean z = foodieConfirmBetDialog.isDontShowNextTime;
        foodieConfirmBetDialog.isDontShowNextTime = !z;
        if (!z) {
            ((ViewFoodieConfirmBetDialog2Binding) foodieConfirmBetDialog.getBinding()).ivCheckBox.setImageDrawable(androidx.core.content.a.getDrawable(foodieConfirmBetDialog.getContext(), R.drawable.ic_daily_checked_in));
        } else {
            ((ViewFoodieConfirmBetDialog2Binding) foodieConfirmBetDialog.getBinding()).ivCheckBox.setImageDrawable(androidx.core.content.a.getDrawable(foodieConfirmBetDialog.getContext(), R.drawable.bg_foodie_confirmbet_white_circle));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(FoodieConfirmBetDialog foodieConfirmBetDialog, View view) {
        if (foodieConfirmBetDialog.isDontShowNextTime) {
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, FoodieConstants.KEY_DONT_SHOW_NEXT_TIME, Boolean.TRUE, (String) null, 4, (Object) null);
        }
        Function1<? super Boolean, Unit> function1 = foodieConfirmBetDialog.onConfirm;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(foodieConfirmBetDialog.isDontShowNextTime));
        }
        foodieConfirmBetDialog.dismiss();
    }

    protected int getLayoutResId() {
        return R.layout.view_foodie_confirm_bet_dialog_2;
    }

    public final void initView() {
        ((ViewFoodieConfirmBetDialog2Binding) getBinding()).tvCancel.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FoodieConfirmBetDialog.this.dismiss();
            }
        });
        ((ViewFoodieConfirmBetDialog2Binding) getBinding()).ivCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FoodieConfirmBetDialog.initView$lambda$1(FoodieConfirmBetDialog.this, view);
            }
        });
        ((ViewFoodieConfirmBetDialog2Binding) getBinding()).tvDontShowNext.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FoodieConfirmBetDialog.initView$lambda$2(FoodieConfirmBetDialog.this, view);
            }
        });
        ((ViewFoodieConfirmBetDialog2Binding) getBinding()).tvConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FoodieConfirmBetDialog.initView$lambda$3(FoodieConfirmBetDialog.this, view);
            }
        });
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        initView();
    }

    public void show() {
        super/*com.oudi.core.component.SuperDialog*/.show();
        AppCompatTextView appCompatTextView = ((ViewFoodieConfirmBetDialog2Binding) getBinding()).tvTitle;
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131952388), Arrays.copyOf(new Object[]{Integer.valueOf(this.mMoney)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        appCompatTextView.setText(format);
    }

    public final void showDialog(@NotNull Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onConfirm = listener;
        show();
    }
}
