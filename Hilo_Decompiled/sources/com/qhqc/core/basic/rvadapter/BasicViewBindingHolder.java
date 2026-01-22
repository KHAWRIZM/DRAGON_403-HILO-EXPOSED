package com.qhqc.core.basic.rvadapter;

import android.view.View;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import j3.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0004\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/qhqc/core/basic/rvadapter/BasicViewBindingHolder;", "Lj3/a;", "VB", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "viewBinding", "<init>", "(Lj3/a;)V", "Lj3/a;", "getViewBinding", "()Lj3/a;", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BasicViewBindingHolder<VB extends j3.a> extends BaseViewHolder {

    @NotNull
    private final VB viewBinding;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BasicViewBindingHolder(@NotNull VB viewBinding) {
        super(r0);
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        View root = viewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.viewBinding = viewBinding;
    }

    @NotNull
    public final VB getViewBinding() {
        return this.viewBinding;
    }
}
