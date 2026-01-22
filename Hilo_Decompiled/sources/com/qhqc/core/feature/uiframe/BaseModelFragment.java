package com.qhqc.core.feature.uiframe;

import android.content.Context;
import com.qhqc.core.basic.uiframe.ui.BasicVBFragment;
import com.qhqc.core.basic.uiframe.viewmodel.BaseViewModel;
import com.qhqc.core.basic.widget.svprogresshud.SVProgressHUD;
import j3.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u0007J\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/qhqc/core/feature/uiframe/BaseModelFragment;", "Lj3/a;", "VB", "Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;", "VM", "Lcom/qhqc/core/basic/uiframe/ui/BasicVBFragment;", "<init>", "()V", "", "onDestroyView", "dismissLoading", "", "s", "showLoading", "(Ljava/lang/String;)V", "Lcom/qhqc/core/basic/widget/svprogresshud/SVProgressHUD;", "mLoadingView", "Lcom/qhqc/core/basic/widget/svprogresshud/SVProgressHUD;", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class BaseModelFragment<VB extends a, VM extends BaseViewModel> extends BasicVBFragment<VB, VM> {

    @Nullable
    private SVProgressHUD mLoadingView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMFragment
    public void dismissLoading() {
        SVProgressHUD sVProgressHUD = this.mLoadingView;
        if (sVProgressHUD != null && sVProgressHUD.isShowing()) {
            sVProgressHUD.dismiss();
        }
    }

    @Override // com.qhqc.core.basic.uiframe.ui.BasicVBFragment, com.qhqc.core.basic.uiframe.ui.BasicVMFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SVProgressHUD sVProgressHUD = this.mLoadingView;
        if (sVProgressHUD != null) {
            sVProgressHUD.dismissImmediately();
        }
        this.mLoadingView = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMFragment
    public void showLoading(@Nullable String s10) {
        if (!getIsViewPrepared()) {
            return;
        }
        if (this.mLoadingView == null) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            this.mLoadingView = new SVProgressHUD(requireContext);
        }
        SVProgressHUD sVProgressHUD = this.mLoadingView;
        if (sVProgressHUD != null) {
            sVProgressHUD.showWithStatus(s10);
        }
    }
}
