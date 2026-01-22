package com.qhqc.core.basic.rvadapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseQuickAdapter;
import j3.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0004B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0012\u001a\u00028\u00012\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/qhqc/core/basic/rvadapter/BasicVBAdapter;", "T", "Lj3/a;", "VB", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qhqc/core/basic/rvadapter/BasicViewBindingHolder;", "<init>", "()V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateDefViewHolder", "(Landroid/view/ViewGroup;I)Lcom/qhqc/core/basic/rvadapter/BasicViewBindingHolder;", "Landroid/view/LayoutInflater;", "layoutInflater", "", "attachToParent", "onCreateViewBinding", "(Landroid/view/ViewGroup;ILandroid/view/LayoutInflater;Z)Lj3/a;", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class BasicVBAdapter<T, VB extends j3.a> extends BaseQuickAdapter<T, BasicViewBindingHolder<VB>> {
    /* JADX WARN: Multi-variable type inference failed */
    public BasicVBAdapter() {
        super(0, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ j3.a onCreateViewBinding$default(BasicVBAdapter basicVBAdapter, ViewGroup viewGroup, int i10, LayoutInflater layoutInflater, boolean z10, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 8) != 0) {
                z10 = false;
            }
            return basicVBAdapter.onCreateViewBinding(viewGroup, i10, layoutInflater, z10);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCreateViewBinding");
    }

    @NotNull
    public abstract VB onCreateViewBinding(@NotNull ViewGroup parent, int viewType, @NotNull LayoutInflater layoutInflater, boolean attachToParent);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    @NotNull
    public BasicViewBindingHolder<VB> onCreateDefViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "from(...)");
        return new BasicViewBindingHolder<>(onCreateViewBinding$default(this, parent, viewType, from, false, 8, null));
    }
}
