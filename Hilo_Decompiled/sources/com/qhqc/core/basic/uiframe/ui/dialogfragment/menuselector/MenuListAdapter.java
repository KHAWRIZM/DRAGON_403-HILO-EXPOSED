package com.qhqc.core.basic.uiframe.ui.dialogfragment.menuselector;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.qhqc.core.basic.databinding.BasicDialogMenuSelectItemBinding;
import com.qhqc.core.basic.rvadapter.BasicVBAdapter;
import com.qhqc.core.basic.rvadapter.BasicViewBindingHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\u0002H\u0014J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/MenuListAdapter;", "Lcom/qhqc/core/basic/rvadapter/BasicVBAdapter;", "Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/Menu;", "Lcom/qhqc/core/basic/databinding/BasicDialogMenuSelectItemBinding;", "()V", "convert", "", "holder", "Lcom/qhqc/core/basic/rvadapter/BasicViewBindingHolder;", "item", "onCreateViewBinding", "parent", "Landroid/view/ViewGroup;", "viewType", "", "layoutInflater", "Landroid/view/LayoutInflater;", "attachToParent", "", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class MenuListAdapter extends BasicVBAdapter<Menu, BasicDialogMenuSelectItemBinding> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BasicViewBindingHolder<BasicDialogMenuSelectItemBinding> holder, @NotNull Menu item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        BasicDialogMenuSelectItemBinding viewBinding = holder.getViewBinding();
        if (item.getContentRes() != 0) {
            viewBinding.mTvMenu.setText(item.getContentRes());
        } else {
            viewBinding.mTvMenu.setText(item.getContent());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qhqc.core.basic.rvadapter.BasicVBAdapter
    @NotNull
    public BasicDialogMenuSelectItemBinding onCreateViewBinding(@NotNull ViewGroup parent, int viewType, @NotNull LayoutInflater layoutInflater, boolean attachToParent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
        BasicDialogMenuSelectItemBinding inflate = BasicDialogMenuSelectItemBinding.inflate(layoutInflater, parent, attachToParent);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
