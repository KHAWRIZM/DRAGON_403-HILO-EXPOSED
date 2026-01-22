package com.qiahao.nextvideo.app.base;

import androidx.databinding.ViewDataBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014R\u001c\u0010\u0006\u001a\u00028\u0000X\u0084.¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "B", "Landroidx/databinding/ViewDataBinding;", "Lcom/qiahao/nextvideo/app/base/HiloBaseActivity;", "<init>", "()V", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "onCreateView", "", "onDestroy", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class HiloBaseBindingActivity<B extends ViewDataBinding> extends HiloBaseActivity {
    protected B binding;

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final B getBinding() {
        B b = this.binding;
        if (b != null) {
            return b;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onCreateView() {
        setBinding(androidx.databinding.g.j(this, getLayoutResId()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        getBinding().unbind();
    }

    protected final void setBinding(@NotNull B b) {
        Intrinsics.checkNotNullParameter(b, "<set-?>");
        this.binding = b;
    }
}
