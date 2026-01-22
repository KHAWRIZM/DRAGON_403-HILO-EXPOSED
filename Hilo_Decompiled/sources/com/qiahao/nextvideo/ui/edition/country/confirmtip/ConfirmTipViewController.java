package com.qiahao.nextvideo.ui.edition.country.confirmtip;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.data.service.FeedbackService;
import com.qiahao.nextvideo.databinding.ViewControllerConfirmTipBinding;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentationStyle;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentingAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/ui/edition/country/confirmtip/ConfirmTipViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "preloadModel", "Lcom/qiahao/nextvideo/ui/edition/country/confirmtip/ConfirmPreloadModel;", "tag2", "", "<init>", "(Lcom/qiahao/nextvideo/ui/edition/country/confirmtip/ConfirmPreloadModel;Ljava/lang/String;)V", "getPreloadModel", "()Lcom/qiahao/nextvideo/ui/edition/country/confirmtip/ConfirmPreloadModel;", "getTag2", "()Ljava/lang/String;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerConfirmTipBinding;", "delegate", "Lcom/qiahao/nextvideo/ui/edition/country/confirmtip/ConfirmTipViewControllerDelegate;", "getDelegate", "()Lcom/qiahao/nextvideo/ui/edition/country/confirmtip/ConfirmTipViewControllerDelegate;", "setDelegate", "(Lcom/qiahao/nextvideo/ui/edition/country/confirmtip/ConfirmTipViewControllerDelegate;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "viewDidLoad", "", "view", "confirmButtonPressed", "descriptionTextLongPressed", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nConfirmTipViewController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConfirmTipViewController.kt\ncom/qiahao/nextvideo/ui/edition/country/confirmtip/ConfirmTipViewController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,95:1\n1#2:96\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ConfirmTipViewController extends BaseViewController {
    public static final int ClearCacheFromCode = 8;
    public static final int MyBag = 26;
    public static final int NotificationFromCode = 9;
    public static final int ReportSubmittedFromCode = 11;
    private ViewControllerConfirmTipBinding binding;

    @Nullable
    private ConfirmTipViewControllerDelegate delegate;

    @NotNull
    private final ConfirmPreloadModel preloadModel;

    @NotNull
    private final String tag2;

    public ConfirmTipViewController(@NotNull ConfirmPreloadModel confirmPreloadModel, @NotNull String str) {
        Intrinsics.checkNotNullParameter(confirmPreloadModel, "preloadModel");
        Intrinsics.checkNotNullParameter(str, "tag2");
        this.preloadModel = confirmPreloadModel;
        this.tag2 = str;
        PresentationStyle presentationStyle = getPresentationStyle();
        presentationStyle.setAnimation(PresentingAnimation.BOTTOM_FADE);
        presentationStyle.setFullscreen(false);
        presentationStyle.setGravity(17);
        presentationStyle.setDim(true);
        presentationStyle.setOverCurrentContext(true);
        setTag(str);
        presentationStyle.setAllowTapOutsideToDismiss(false);
        presentationStyle.setMinimumSideMargin(Dimens.INSTANCE.getMarginXXLarge());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void confirmButtonPressed() {
        if (this.preloadModel.getFromCode() == 11) {
            String string = this.preloadModel.getExtra().getString(AgooConstants.ACK_BODY_NULL);
            Intrinsics.checkNotNull(string);
            FeedbackService.INSTANCE.getShared().getReportEventRelay().accept(string);
        }
        ConfirmTipViewControllerDelegate confirmTipViewControllerDelegate = this.delegate;
        if (confirmTipViewControllerDelegate != null) {
            confirmTipViewControllerDelegate.confirmTipViewControllerDidConfirm(this.preloadModel.getFromCode(), this.preloadModel.getExtra());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean descriptionTextLongPressed() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$5(ConfirmTipViewController confirmTipViewController, View view) {
        ConfirmTipViewControllerDelegate confirmTipViewControllerDelegate = confirmTipViewController.delegate;
        if (confirmTipViewControllerDelegate != null) {
            confirmTipViewControllerDelegate.confirmTipViewControllerDidCancel();
        }
    }

    @Nullable
    public final ConfirmTipViewControllerDelegate getDelegate() {
        return this.delegate;
    }

    @NotNull
    public final ConfirmPreloadModel getPreloadModel() {
        return this.preloadModel;
    }

    @NotNull
    public final String getTag2() {
        return this.tag2;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerConfirmTipBinding inflate = ViewControllerConfirmTipBinding.inflate(inflater, container, false);
        this.binding = inflate;
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public final void setDelegate(@Nullable ConfirmTipViewControllerDelegate confirmTipViewControllerDelegate) {
        this.delegate = confirmTipViewControllerDelegate;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        ViewControllerConfirmTipBinding viewControllerConfirmTipBinding = this.binding;
        ViewControllerConfirmTipBinding viewControllerConfirmTipBinding2 = null;
        if (viewControllerConfirmTipBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerConfirmTipBinding = null;
        }
        viewControllerConfirmTipBinding.descriptionText.setMovementMethod(ScrollingMovementMethod.getInstance());
        ViewControllerConfirmTipBinding viewControllerConfirmTipBinding3 = this.binding;
        if (viewControllerConfirmTipBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerConfirmTipBinding3 = null;
        }
        viewControllerConfirmTipBinding3.descriptionText.setText(this.preloadModel.getContentText());
        ViewControllerConfirmTipBinding viewControllerConfirmTipBinding4 = this.binding;
        if (viewControllerConfirmTipBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerConfirmTipBinding4 = null;
        }
        viewControllerConfirmTipBinding4.cancelButton.setText(this.preloadModel.getCancelText());
        if (this.preloadModel.getCancelText() != null) {
            ViewControllerConfirmTipBinding viewControllerConfirmTipBinding5 = this.binding;
            if (viewControllerConfirmTipBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewControllerConfirmTipBinding5 = null;
            }
            viewControllerConfirmTipBinding5.cancelButton.setVisibility(0);
        }
        if (this.preloadModel.getConfirmText() != null) {
            ViewControllerConfirmTipBinding viewControllerConfirmTipBinding6 = this.binding;
            if (viewControllerConfirmTipBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewControllerConfirmTipBinding6 = null;
            }
            viewControllerConfirmTipBinding6.confirmButton.setText(this.preloadModel.getConfirmText());
        }
        ViewControllerConfirmTipBinding viewControllerConfirmTipBinding7 = this.binding;
        if (viewControllerConfirmTipBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerConfirmTipBinding7 = null;
        }
        viewControllerConfirmTipBinding7.descriptionText.setOnLongClickListener(new View.OnLongClickListener() { // from class: ob.a
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean descriptionTextLongPressed;
                descriptionTextLongPressed = ConfirmTipViewController.this.descriptionTextLongPressed();
                return descriptionTextLongPressed;
            }
        });
        ViewControllerConfirmTipBinding viewControllerConfirmTipBinding8 = this.binding;
        if (viewControllerConfirmTipBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerConfirmTipBinding8 = null;
        }
        viewControllerConfirmTipBinding8.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: ob.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConfirmTipViewController.viewDidLoad$lambda$5(ConfirmTipViewController.this, view2);
            }
        });
        ViewControllerConfirmTipBinding viewControllerConfirmTipBinding9 = this.binding;
        if (viewControllerConfirmTipBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerConfirmTipBinding2 = viewControllerConfirmTipBinding9;
        }
        viewControllerConfirmTipBinding2.confirmButton.setOnClickListener(new View.OnClickListener() { // from class: ob.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConfirmTipViewController.this.confirmButtonPressed();
            }
        });
    }

    public /* synthetic */ ConfirmTipViewController(ConfirmPreloadModel confirmPreloadModel, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(confirmPreloadModel, (i & 2) != 0 ? "confirmTip" : str);
    }
}
