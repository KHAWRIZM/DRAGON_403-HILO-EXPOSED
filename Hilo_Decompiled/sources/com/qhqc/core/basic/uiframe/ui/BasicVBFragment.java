package com.qhqc.core.basic.uiframe.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.qhqc.core.basic.expand.ViewBindUtilKt;
import com.qhqc.core.basic.uiframe.viewmodel.BaseViewModel;
import j3.a;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00010\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u0004\u0018\u00018\u0000H\u0004¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u0007R\u0018\u0010\u001b\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR(\u0010\u001e\u001a\u00020\u001d8\u0004@\u0004X\u0085\u000e¢\u0006\u0018\n\u0004\b\u001e\u0010\u001f\u0012\u0004\b#\u0010\u0007\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u0011\u0010%\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b$\u0010\f¨\u0006&"}, d2 = {"Lcom/qhqc/core/basic/uiframe/ui/BasicVBFragment;", "Lj3/a;", "VB", "Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;", "VM", "Lcom/qhqc/core/basic/uiframe/ui/BasicVMFragment;", "<init>", "()V", "", "getIndexViewModelParameterized", "()I", "getRootBinding", "()Lj3/a;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "mBinding", "Lj3/a;", "", "isBindingNullWhenDestroyView", "Z", "()Z", "setBindingNullWhenDestroyView", "(Z)V", "isBindingNullWhenDestroyView$annotations", "getBinding", "binding", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class BasicVBFragment<VB extends j3.a, VM extends BaseViewModel> extends BasicVMFragment<VM> {
    private boolean isBindingNullWhenDestroyView = true;

    @Nullable
    private VB mBinding;

    @Deprecated(message = "")
    protected static /* synthetic */ void isBindingNullWhenDestroyView$annotations() {
    }

    @NotNull
    public final VB getBinding() {
        VB vb = this.mBinding;
        Intrinsics.checkNotNull(vb);
        return vb;
    }

    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMFragment
    protected int getIndexViewModelParameterized() {
        return 1;
    }

    @Nullable
    protected final VB getRootBinding() {
        return this.mBinding;
    }

    /* renamed from: isBindingNullWhenDestroyView, reason: from getter */
    protected final boolean getIsBindingNullWhenDestroyView() {
        return this.isBindingNullWhenDestroyView;
    }

    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewParent viewParent;
        ViewGroup viewGroup;
        View view;
        View root;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        VB vb = this.mBinding;
        if (vb != null) {
            if (vb != null && (root = vb.getRoot()) != null) {
                viewParent = root.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent instanceof ViewGroup) {
                viewGroup = (ViewGroup) viewParent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                VB vb2 = this.mBinding;
                if (vb2 != null) {
                    view = vb2.getRoot();
                } else {
                    view = null;
                }
                viewGroup.removeView(view);
            }
            VB vb3 = this.mBinding;
            if (vb3 == null) {
                return null;
            }
            return vb3.getRoot();
        }
        this.mBinding = (VB) ViewBindUtilKt.inflateWithGeneric(this, inflater, container, false);
        return getBinding().getRoot();
    }

    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.isBindingNullWhenDestroyView) {
            this.mBinding = null;
        }
    }

    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.mBinding == null) {
            return;
        }
        super.onViewCreated(view, savedInstanceState);
    }

    protected final void setBindingNullWhenDestroyView(boolean z10) {
        this.isBindingNullWhenDestroyView = z10;
    }
}
