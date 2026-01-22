package com.qiahao.nextvideo.ui.reusable.viewcontroller.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.qiahao.nextvideo.databinding.DialogStyledBinding;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentationStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0004R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseStyledDialogViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "<init>", "()V", "binding", "Lcom/qiahao/nextvideo/databinding/DialogStyledBinding;", "getBinding$app_googleRelease", "()Lcom/qiahao/nextvideo/databinding/DialogStyledBinding;", "setBinding$app_googleRelease", "(Lcom/qiahao/nextvideo/databinding/DialogStyledBinding;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCreateContentView", "addBottomNavigationButton", "", "button", "Landroid/widget/ImageButton;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class BaseStyledDialogViewController extends BaseViewController {
    public DialogStyledBinding binding;

    public BaseStyledDialogViewController() {
        PresentationStyle presentationStyle = getPresentationStyle();
        presentationStyle.setFullscreen(false);
        presentationStyle.setGravity(17);
    }

    protected final void addBottomNavigationButton(@NotNull ImageButton button) {
        Intrinsics.checkNotNullParameter(button, "button");
        getBinding$app_googleRelease().commonIdButtonContainer.addView(button);
    }

    @NotNull
    public final DialogStyledBinding getBinding$app_googleRelease() {
        DialogStyledBinding dialogStyledBinding = this.binding;
        if (dialogStyledBinding != null) {
            return dialogStyledBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @NotNull
    public abstract View onCreateContentView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container);

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public final View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        DialogStyledBinding inflate = DialogStyledBinding.inflate(inflater, container, false);
        setBinding$app_googleRelease(inflate);
        FrameLayout frameLayout = getBinding$app_googleRelease().commonIdContentContainer;
        FrameLayout frameLayout2 = getBinding$app_googleRelease().commonIdContentContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "commonIdContentContainer");
        frameLayout.addView(onCreateContentView(inflater, frameLayout2));
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public final void setBinding$app_googleRelease(@NotNull DialogStyledBinding dialogStyledBinding) {
        Intrinsics.checkNotNullParameter(dialogStyledBinding, "<set-?>");
        this.binding = dialogStyledBinding;
    }
}
