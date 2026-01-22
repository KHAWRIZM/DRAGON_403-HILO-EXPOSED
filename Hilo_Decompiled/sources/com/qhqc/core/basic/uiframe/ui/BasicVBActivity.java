package com.qhqc.core.basic.uiframe.ui;

import android.view.LayoutInflater;
import com.qhqc.core.basic.expand.ViewBindUtilKt;
import com.qhqc.core.basic.uiframe.viewmodel.BaseViewModel;
import j3.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00010\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\u0007R\"\u0010\r\u001a\u00028\u00008\u0014@\u0014X\u0094.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/qhqc/core/basic/uiframe/ui/BasicVBActivity;", "Lj3/a;", "VB", "Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;", "VM", "Lcom/qhqc/core/basic/uiframe/ui/BasicVMActivity;", "<init>", "()V", "", "getIndexViewModelParameterized", "()I", "", "onBindingView", "binding", "Lj3/a;", "getBinding", "()Lj3/a;", "setBinding", "(Lj3/a;)V", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class BasicVBActivity<VB extends j3.a, VM extends BaseViewModel> extends BasicVMActivity<VM> {
    protected VB binding;

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public VB getBinding() {
        VB vb = this.binding;
        if (vb != null) {
            return vb;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMActivity
    protected int getIndexViewModelParameterized() {
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMActivity
    protected void onBindingView() {
        LayoutInflater layoutInflater = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "getLayoutInflater(...)");
        setBinding(ViewBindUtilKt.inflateWithGeneric(this, layoutInflater));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setBinding(@NotNull VB vb) {
        Intrinsics.checkNotNullParameter(vb, "<set-?>");
        this.binding = vb;
    }
}
