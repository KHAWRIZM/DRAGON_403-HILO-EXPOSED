package com.qiahao.nextvideo.ui.debug.alertagoraconfigure;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.ViewControllerAlertAgoraConfigureBinding;
import com.qiahao.nextvideo.ui.debug.alertagoraconfigure.AlertAgoraConfigViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentationStyle;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentingAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/ui/debug/alertagoraconfigure/AlertAgoraConfigViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Lcom/qiahao/nextvideo/ui/debug/alertagoraconfigure/AlertAgoraConfigViewControllerDelegate;", "<init>", "()V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerAlertAgoraConfigureBinding;", "delegate", "getDelegate", "()Lcom/qiahao/nextvideo/ui/debug/alertagoraconfigure/AlertAgoraConfigViewControllerDelegate;", "setDelegate", "(Lcom/qiahao/nextvideo/ui/debug/alertagoraconfigure/AlertAgoraConfigViewControllerDelegate;)V", "tempToUserID", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "viewDidLoad", "", "view", "cancelButtonPressed", "confirmButtonPressed", "alertAgoraConfigViewControllerDelegateDidConfigure", "uiModel", "Lcom/qiahao/nextvideo/ui/debug/alertagoraconfigure/AlertAgoraConfigUIModel;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AlertAgoraConfigViewController extends BaseViewController implements AlertAgoraConfigViewControllerDelegate {
    private ViewControllerAlertAgoraConfigureBinding binding;

    @Nullable
    private AlertAgoraConfigViewControllerDelegate delegate;

    @NotNull
    private final String tempToUserID;

    public AlertAgoraConfigViewController() {
        PresentationStyle presentationStyle = getPresentationStyle();
        presentationStyle.setAnimation(PresentingAnimation.BOTTOM_FADE);
        presentationStyle.setFullscreen(false);
        presentationStyle.setGravity(17);
        presentationStyle.setDim(true);
        presentationStyle.setOverCurrentContext(true);
        setTag("alertAgoraConfigureViewController");
        presentationStyle.setAllowTapOutsideToDismiss(false);
        presentationStyle.setMinimumSideMargin(Dimens.INSTANCE.getMarginXXLarge());
        this.tempToUserID = String.valueOf(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelButtonPressed() {
        ViewController.dismiss$default(this, true, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void confirmButtonPressed() {
    }

    @Override // com.qiahao.nextvideo.ui.debug.alertagoraconfigure.AlertAgoraConfigViewControllerDelegate
    public void alertAgoraConfigViewControllerDelegateDidConfigure(@NotNull AlertAgoraConfigUIModel uiModel) {
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
    }

    @Nullable
    public final AlertAgoraConfigViewControllerDelegate getDelegate() {
        return this.delegate;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerAlertAgoraConfigureBinding inflate = ViewControllerAlertAgoraConfigureBinding.inflate(inflater, container, false);
        this.binding = inflate;
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public final void setDelegate(@Nullable AlertAgoraConfigViewControllerDelegate alertAgoraConfigViewControllerDelegate) {
        this.delegate = alertAgoraConfigViewControllerDelegate;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        String str;
        String externalId;
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        ViewControllerAlertAgoraConfigureBinding viewControllerAlertAgoraConfigureBinding = this.binding;
        ViewControllerAlertAgoraConfigureBinding viewControllerAlertAgoraConfigureBinding2 = null;
        if (viewControllerAlertAgoraConfigureBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerAlertAgoraConfigureBinding = null;
        }
        AppCompatEditText appCompatEditText = viewControllerAlertAgoraConfigureBinding.fromUserIdTextView;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (externalId = user.getExternalId()) == null || (str = externalId.toString()) == null) {
            str = "";
        }
        appCompatEditText.setText(str);
        ViewControllerAlertAgoraConfigureBinding viewControllerAlertAgoraConfigureBinding3 = this.binding;
        if (viewControllerAlertAgoraConfigureBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerAlertAgoraConfigureBinding3 = null;
        }
        viewControllerAlertAgoraConfigureBinding3.toUserIdTextView.setText(this.tempToUserID.toString());
        ViewControllerAlertAgoraConfigureBinding viewControllerAlertAgoraConfigureBinding4 = this.binding;
        if (viewControllerAlertAgoraConfigureBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerAlertAgoraConfigureBinding4 = null;
        }
        viewControllerAlertAgoraConfigureBinding4.channelIdEditText.setText(this.tempToUserID.toString());
        ViewControllerAlertAgoraConfigureBinding viewControllerAlertAgoraConfigureBinding5 = this.binding;
        if (viewControllerAlertAgoraConfigureBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerAlertAgoraConfigureBinding5 = null;
        }
        viewControllerAlertAgoraConfigureBinding5.confirmButton.setOnClickListener(new View.OnClickListener() { // from class: nb.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AlertAgoraConfigViewController.this.confirmButtonPressed();
            }
        });
        ViewControllerAlertAgoraConfigureBinding viewControllerAlertAgoraConfigureBinding6 = this.binding;
        if (viewControllerAlertAgoraConfigureBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerAlertAgoraConfigureBinding2 = viewControllerAlertAgoraConfigureBinding6;
        }
        viewControllerAlertAgoraConfigureBinding2.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: nb.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AlertAgoraConfigViewController.this.cancelButtonPressed();
            }
        });
    }
}
