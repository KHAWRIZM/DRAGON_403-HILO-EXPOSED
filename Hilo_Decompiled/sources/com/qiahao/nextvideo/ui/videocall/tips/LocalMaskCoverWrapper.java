package com.qiahao.nextvideo.ui.videocall.tips;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.qiahao.nextvideo.databinding.ViewMaskCoverLocalSpecifyBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/tips/LocalMaskCoverWrapper;", "", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewMaskCoverLocalSpecifyBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewMaskCoverLocalSpecifyBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewMaskCoverLocalSpecifyBinding;)V", "show", "", "hide", "isShowing", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LocalMaskCoverWrapper {

    @NotNull
    private ViewMaskCoverLocalSpecifyBinding binding;

    public LocalMaskCoverWrapper(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ViewMaskCoverLocalSpecifyBinding inflate = ViewMaskCoverLocalSpecifyBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        hide();
    }

    @NotNull
    public final ViewMaskCoverLocalSpecifyBinding getBinding() {
        return this.binding;
    }

    public final void hide() {
        this.binding.getRoot().setVisibility(4);
    }

    public final boolean isShowing() {
        if (this.binding.getRoot().getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final void setBinding(@NotNull ViewMaskCoverLocalSpecifyBinding viewMaskCoverLocalSpecifyBinding) {
        Intrinsics.checkNotNullParameter(viewMaskCoverLocalSpecifyBinding, "<set-?>");
        this.binding = viewMaskCoverLocalSpecifyBinding;
    }

    public final void show() {
        this.binding.getRoot().setVisibility(0);
    }
}
