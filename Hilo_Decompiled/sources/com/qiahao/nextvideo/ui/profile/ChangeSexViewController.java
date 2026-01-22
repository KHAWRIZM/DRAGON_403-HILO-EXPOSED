package com.qiahao.nextvideo.ui.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.ViewControllerChangeSexBinding;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentationStyle;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentingAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/ChangeSexViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "<init>", "()V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerChangeSexBinding;", "delegate", "Lcom/qiahao/nextvideo/ui/profile/ChangeSexViewControllerDelegate;", "getDelegate", "()Lcom/qiahao/nextvideo/ui/profile/ChangeSexViewControllerDelegate;", "setDelegate", "(Lcom/qiahao/nextvideo/ui/profile/ChangeSexViewControllerDelegate;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "viewDidLoad", "", "view", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ChangeSexViewController extends BaseViewController {
    private ViewControllerChangeSexBinding binding;

    @Nullable
    private ChangeSexViewControllerDelegate delegate;

    public ChangeSexViewController() {
        PresentationStyle presentationStyle = getPresentationStyle();
        setTag("ChangeSexViewController");
        presentationStyle.setAnimation(PresentingAnimation.BOTTOM_FADE);
        presentationStyle.setFullscreen(false);
        presentationStyle.setGravity(17);
        presentationStyle.setOverCurrentContext(true);
        presentationStyle.setAllowTapOutsideToDismiss(false);
        presentationStyle.setMinimumSideMargin(Dimens.INSTANCE.getMarginXXLarge());
        presentationStyle.setDim(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$2(ChangeSexViewController changeSexViewController, View view) {
        ViewControllerChangeSexBinding viewControllerChangeSexBinding = changeSexViewController.binding;
        if (viewControllerChangeSexBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerChangeSexBinding = null;
        }
        int checkedRadioButtonId = viewControllerChangeSexBinding.sexRadioGroup.getCheckedRadioButtonId();
        ChangeSexViewControllerDelegate changeSexViewControllerDelegate = changeSexViewController.delegate;
        if (changeSexViewControllerDelegate != null) {
            int i = 1;
            if (checkedRadioButtonId != 2131362175 && checkedRadioButtonId == 2131363048) {
                i = 2;
            }
            changeSexViewControllerDelegate.changeSex(i);
        }
    }

    @Nullable
    public final ChangeSexViewControllerDelegate getDelegate() {
        return this.delegate;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerChangeSexBinding inflate = ViewControllerChangeSexBinding.inflate(inflater, container, false);
        this.binding = inflate;
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public final void setDelegate(@Nullable ChangeSexViewControllerDelegate changeSexViewControllerDelegate) {
        this.delegate = changeSexViewControllerDelegate;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        User user = UserStore.INSTANCE.getShared().getUser();
        ViewControllerChangeSexBinding viewControllerChangeSexBinding = null;
        if (user != null && user.getSex() == 1) {
            ViewControllerChangeSexBinding viewControllerChangeSexBinding2 = this.binding;
            if (viewControllerChangeSexBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewControllerChangeSexBinding2 = null;
            }
            viewControllerChangeSexBinding2.sexRadioGroup.check(R.id.boy_radio_button);
        } else {
            ViewControllerChangeSexBinding viewControllerChangeSexBinding3 = this.binding;
            if (viewControllerChangeSexBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewControllerChangeSexBinding3 = null;
            }
            viewControllerChangeSexBinding3.sexRadioGroup.check(R.id.girl_radio_button);
        }
        ViewControllerChangeSexBinding viewControllerChangeSexBinding4 = this.binding;
        if (viewControllerChangeSexBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerChangeSexBinding = viewControllerChangeSexBinding4;
        }
        viewControllerChangeSexBinding.confirmButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChangeSexViewController.viewDidLoad$lambda$2(ChangeSexViewController.this, view2);
            }
        });
    }
}
