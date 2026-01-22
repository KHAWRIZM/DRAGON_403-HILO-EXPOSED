package com.qiahao.nextvideo.ui.rank;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.databinding.ViewControllerCpRankMenuBinding;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentationStyle;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentingAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/MyCpRankMenuViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "<init>", "()V", "delegate", "Lcom/qiahao/nextvideo/ui/rank/MyCpRankMenuViewControllerDelegate;", "getDelegate", "()Lcom/qiahao/nextvideo/ui/rank/MyCpRankMenuViewControllerDelegate;", "setDelegate", "(Lcom/qiahao/nextvideo/ui/rank/MyCpRankMenuViewControllerDelegate;)V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerCpRankMenuBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "viewDidLoad", "", "view", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MyCpRankMenuViewController extends BaseViewController {

    @NotNull
    private static final String TAG = "MyCpRankMenuViewControl";
    private ViewControllerCpRankMenuBinding binding;

    @Nullable
    private MyCpRankMenuViewControllerDelegate delegate;

    public MyCpRankMenuViewController() {
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
    public static final void viewDidLoad$lambda$2(MyCpRankMenuViewController myCpRankMenuViewController, View view) {
        MyCpRankMenuViewControllerDelegate myCpRankMenuViewControllerDelegate = myCpRankMenuViewController.delegate;
        if (myCpRankMenuViewControllerDelegate != null) {
            myCpRankMenuViewControllerDelegate.releaseCpRelationship();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$3(MyCpRankMenuViewController myCpRankMenuViewController, View view) {
        MyCpRankMenuViewControllerDelegate myCpRankMenuViewControllerDelegate = myCpRankMenuViewController.delegate;
        if (myCpRankMenuViewControllerDelegate != null) {
            myCpRankMenuViewControllerDelegate.myCpRankMenuViewControllerdismiss();
        }
    }

    @Nullable
    public final MyCpRankMenuViewControllerDelegate getDelegate() {
        return this.delegate;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerCpRankMenuBinding inflate = ViewControllerCpRankMenuBinding.inflate(inflater, container, false);
        this.binding = inflate;
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public final void setDelegate(@Nullable MyCpRankMenuViewControllerDelegate myCpRankMenuViewControllerDelegate) {
        this.delegate = myCpRankMenuViewControllerDelegate;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        ViewControllerCpRankMenuBinding viewControllerCpRankMenuBinding = this.binding;
        ViewControllerCpRankMenuBinding viewControllerCpRankMenuBinding2 = null;
        if (viewControllerCpRankMenuBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerCpRankMenuBinding = null;
        }
        viewControllerCpRankMenuBinding.releaseCpButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MyCpRankMenuViewController.viewDidLoad$lambda$2(MyCpRankMenuViewController.this, view2);
            }
        });
        ViewControllerCpRankMenuBinding viewControllerCpRankMenuBinding3 = this.binding;
        if (viewControllerCpRankMenuBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerCpRankMenuBinding2 = viewControllerCpRankMenuBinding3;
        }
        viewControllerCpRankMenuBinding2.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MyCpRankMenuViewController.viewDidLoad$lambda$3(MyCpRankMenuViewController.this, view2);
            }
        });
    }
}
