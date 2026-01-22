package com.qiahao.nextvideo.ui.power;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.databinding.ViewControllerPowerMenuBinding;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentationStyle;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentingAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/power/PowerMenuViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "<init>", "()V", "mPowerMenuViewControllerDelegate", "Lcom/qiahao/nextvideo/ui/power/PowerMenuViewControllerDelegate;", "getMPowerMenuViewControllerDelegate", "()Lcom/qiahao/nextvideo/ui/power/PowerMenuViewControllerDelegate;", "setMPowerMenuViewControllerDelegate", "(Lcom/qiahao/nextvideo/ui/power/PowerMenuViewControllerDelegate;)V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerPowerMenuBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "viewDidLoad", "", "view", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PowerMenuViewController extends BaseViewController {

    @NotNull
    private static final String TAG = "PowerMenuViewController";
    private ViewControllerPowerMenuBinding binding;

    @Nullable
    private PowerMenuViewControllerDelegate mPowerMenuViewControllerDelegate;

    public PowerMenuViewController() {
        setTag(TAG);
        PresentationStyle presentationStyle = getPresentationStyle();
        presentationStyle.setDim(true);
        presentationStyle.setFullscreen(false);
        presentationStyle.setGravity(80);
        presentationStyle.setOverCurrentContext(true);
        presentationStyle.setMinimumSideMargin(Dimens.INSTANCE.getMarginLarge());
        presentationStyle.setAnimation(PresentingAnimation.BOTTOM_FADE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$2(PowerMenuViewController powerMenuViewController, View view) {
        PowerMenuViewControllerDelegate powerMenuViewControllerDelegate = powerMenuViewController.mPowerMenuViewControllerDelegate;
        if (powerMenuViewControllerDelegate != null) {
            powerMenuViewControllerDelegate.confirmleave();
        }
    }

    @Nullable
    public final PowerMenuViewControllerDelegate getMPowerMenuViewControllerDelegate() {
        return this.mPowerMenuViewControllerDelegate;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerPowerMenuBinding inflate = ViewControllerPowerMenuBinding.inflate(inflater, container, false);
        this.binding = inflate;
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public final void setMPowerMenuViewControllerDelegate(@Nullable PowerMenuViewControllerDelegate powerMenuViewControllerDelegate) {
        this.mPowerMenuViewControllerDelegate = powerMenuViewControllerDelegate;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        ViewControllerPowerMenuBinding viewControllerPowerMenuBinding = this.binding;
        ViewControllerPowerMenuBinding viewControllerPowerMenuBinding2 = null;
        if (viewControllerPowerMenuBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerMenuBinding = null;
        }
        viewControllerPowerMenuBinding.leaveButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.power.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PowerMenuViewController.viewDidLoad$lambda$2(PowerMenuViewController.this, view2);
            }
        });
        ViewControllerPowerMenuBinding viewControllerPowerMenuBinding3 = this.binding;
        if (viewControllerPowerMenuBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerPowerMenuBinding2 = viewControllerPowerMenuBinding3;
        }
        viewControllerPowerMenuBinding2.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.power.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ViewController.dismiss$default(PowerMenuViewController.this, true, null, 2, null);
            }
        });
    }
}
