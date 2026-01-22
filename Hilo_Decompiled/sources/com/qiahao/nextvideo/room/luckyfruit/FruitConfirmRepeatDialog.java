package com.qiahao.nextvideo.room.luckyfruit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ViewFruitConfirmRepeatDialogBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0006\u0010\u0012\u001a\u00020\u000eJ\b\u0010\u0013\u001a\u00020\u000eH\u0017J\u0014\u0010\u0014\u001a\u00020\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/room/luckyfruit/FruitConfirmRepeatDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/ViewFruitConfirmRepeatDialogBinding;", "context", "Landroid/content/Context;", "mMoney", "", "<init>", "(Landroid/content/Context;Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLayoutResId", "", "onConfirm", "Lkotlin/Function0;", "", "isDontShowNextTime", "", "onInitialize", "initView", "show", "setListener", "listener", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FruitConfirmRepeatDialog extends BaseBindingDialog<ViewFruitConfirmRepeatDialogBinding> {
    private boolean isDontShowNextTime;

    @Nullable
    private final Long mMoney;

    @Nullable
    private Function0<Unit> onConfirm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FruitConfirmRepeatDialog(@NotNull Context context, @Nullable Long l) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mMoney = l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$1(FruitConfirmRepeatDialog fruitConfirmRepeatDialog, View view) {
        boolean z = fruitConfirmRepeatDialog.isDontShowNextTime;
        fruitConfirmRepeatDialog.isDontShowNextTime = !z;
        if (!z) {
            ((ViewFruitConfirmRepeatDialogBinding) fruitConfirmRepeatDialog.getBinding()).ivCheckBox.setImageDrawable(androidx.core.content.a.getDrawable(fruitConfirmRepeatDialog.getContext(), R.drawable.fruit_one_again_select));
        } else {
            ((ViewFruitConfirmRepeatDialogBinding) fruitConfirmRepeatDialog.getBinding()).ivCheckBox.setImageDrawable(androidx.core.content.a.getDrawable(fruitConfirmRepeatDialog.getContext(), R.drawable.fruit_one_again_default));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$2(FruitConfirmRepeatDialog fruitConfirmRepeatDialog, View view) {
        boolean z = fruitConfirmRepeatDialog.isDontShowNextTime;
        fruitConfirmRepeatDialog.isDontShowNextTime = !z;
        if (!z) {
            ((ViewFruitConfirmRepeatDialogBinding) fruitConfirmRepeatDialog.getBinding()).ivCheckBox.setImageDrawable(androidx.core.content.a.getDrawable(fruitConfirmRepeatDialog.getContext(), R.drawable.fruit_one_again_select));
        } else {
            ((ViewFruitConfirmRepeatDialogBinding) fruitConfirmRepeatDialog.getBinding()).ivCheckBox.setImageDrawable(androidx.core.content.a.getDrawable(fruitConfirmRepeatDialog.getContext(), R.drawable.fruit_one_again_default));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(FruitConfirmRepeatDialog fruitConfirmRepeatDialog, View view) {
        if (fruitConfirmRepeatDialog.isDontShowNextTime) {
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "show_fruit_repeat", Boolean.TRUE, (String) null, 4, (Object) null);
        }
        Function0<Unit> function0 = fruitConfirmRepeatDialog.onConfirm;
        if (function0 != null) {
            function0.invoke();
        }
        fruitConfirmRepeatDialog.dismiss();
    }

    protected int getLayoutResId() {
        return R.layout.view_fruit_confirm_repeat_dialog;
    }

    public final void initView() {
        ((ViewFruitConfirmRepeatDialogBinding) getBinding()).constraint.setBackground(ShapeUtil.INSTANCE.createShape("#C43CFF", "#9C25E8", 10, GradientDrawable.Orientation.TOP_BOTTOM));
        ((ViewFruitConfirmRepeatDialogBinding) getBinding()).tvCancel.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.luckyfruit.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FruitConfirmRepeatDialog.this.dismiss();
            }
        });
        ((ViewFruitConfirmRepeatDialogBinding) getBinding()).ivCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.luckyfruit.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FruitConfirmRepeatDialog.initView$lambda$1(FruitConfirmRepeatDialog.this, view);
            }
        });
        ((ViewFruitConfirmRepeatDialogBinding) getBinding()).tvDontShowNext.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.luckyfruit.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FruitConfirmRepeatDialog.initView$lambda$2(FruitConfirmRepeatDialog.this, view);
            }
        });
        ((ViewFruitConfirmRepeatDialogBinding) getBinding()).tvConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.luckyfruit.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FruitConfirmRepeatDialog.initView$lambda$3(FruitConfirmRepeatDialog.this, view);
            }
        });
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        initView();
    }

    @NotNull
    public final FruitConfirmRepeatDialog setListener(@NotNull Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onConfirm = listener;
        return this;
    }

    @SuppressLint({"SetTextI18n"})
    public void show() {
        super/*com.oudi.core.component.SuperDialog*/.show();
        ((ViewFruitConfirmRepeatDialogBinding) getBinding()).diamond.setText(String.valueOf(this.mMoney));
    }
}
