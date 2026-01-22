package com.qiahao.nextvideo.room.luckyfruit;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDialog;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogLuckyFruitRuleBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitRuleDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "theme", "", "<init>", "(Landroid/content/Context;I)V", "binding", "Lcom/qiahao/nextvideo/databinding/DialogLuckyFruitRuleBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/DialogLuckyFruitRuleBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/DialogLuckyFruitRuleBinding;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initDataBinding", "initStyle", "onClick", "v", "Landroid/view/View;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LuckyFruitRuleDialog extends AppCompatDialog implements View.OnClickListener {
    public DialogLuckyFruitRuleBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LuckyFruitRuleDialog(@NotNull Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initDataBinding() {
        setBinding(DialogLuckyFruitRuleBinding.inflate(LayoutInflater.from(getContext()), null, false));
        setContentView(getBinding().getRoot());
        getBinding().setClick(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initStyle() {
        setCanceledOnTouchOutside(true);
        Object systemService = getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(attributes);
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        window3.setWindowAnimations(R.style.dialog_for_bottom_in_out_anim);
        Window window4 = getWindow();
        Intrinsics.checkNotNull(window4);
        window4.setDimAmount(0.0f);
    }

    @NotNull
    public final DialogLuckyFruitRuleBinding getBinding() {
        DialogLuckyFruitRuleBinding dialogLuckyFruitRuleBinding = this.binding;
        if (dialogLuckyFruitRuleBinding != null) {
            return dialogLuckyFruitRuleBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (v.getId() == 2131362039) {
            dismiss();
        }
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        initStyle();
    }

    public final void setBinding(@NotNull DialogLuckyFruitRuleBinding dialogLuckyFruitRuleBinding) {
        Intrinsics.checkNotNullParameter(dialogLuckyFruitRuleBinding, "<set-?>");
        this.binding = dialogLuckyFruitRuleBinding;
    }

    public /* synthetic */ LuckyFruitRuleDialog(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? R.style.HiloBottomSheetDialog : i);
    }
}
