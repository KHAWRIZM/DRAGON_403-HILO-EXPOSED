package com.qiahao.nextvideo.ui.debug;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qiahao.nextvideo.databinding.ViewControllerTestMicViewBinding;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/ui/debug/TestMicChangeTypeViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "<init>", "()V", "mBinding", "Lcom/qiahao/nextvideo/databinding/ViewControllerTestMicViewBinding;", "getMBinding", "()Lcom/qiahao/nextvideo/databinding/ViewControllerTestMicViewBinding;", "setMBinding", "(Lcom/qiahao/nextvideo/databinding/ViewControllerTestMicViewBinding;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "mPosition", "", "getMPosition", "()I", "setMPosition", "(I)V", "viewDidLoad", "", "view", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TestMicChangeTypeViewController extends BaseViewController {

    @NotNull
    private static final String TAG = "TestUploadFileViewContr";
    public ViewControllerTestMicViewBinding mBinding;
    private int mPosition = 1;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$1(TestMicChangeTypeViewController testMicChangeTypeViewController, View view) {
        int i = testMicChangeTypeViewController.mPosition + 1;
        testMicChangeTypeViewController.mPosition = i;
        testMicChangeTypeViewController.getMBinding().microView.changeMicType(i % 21);
    }

    @NotNull
    public final ViewControllerTestMicViewBinding getMBinding() {
        ViewControllerTestMicViewBinding viewControllerTestMicViewBinding = this.mBinding;
        if (viewControllerTestMicViewBinding != null) {
            return viewControllerTestMicViewBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        return null;
    }

    public final int getMPosition() {
        return this.mPosition;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerTestMicViewBinding inflate = ViewControllerTestMicViewBinding.inflate(inflater, container, false);
        setMBinding(inflate);
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public final void setMBinding(@NotNull ViewControllerTestMicViewBinding viewControllerTestMicViewBinding) {
        Intrinsics.checkNotNullParameter(viewControllerTestMicViewBinding, "<set-?>");
        this.mBinding = viewControllerTestMicViewBinding;
    }

    public final void setMPosition(int i) {
        this.mPosition = i;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        getMBinding().changeType.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.debug.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TestMicChangeTypeViewController.viewDidLoad$lambda$1(TestMicChangeTypeViewController.this, view2);
            }
        });
        ImageView imageView = getMBinding().userAvatar;
        Intrinsics.checkNotNullExpressionValue(imageView, "userAvatar");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        ViewUtilitiesKt.bind(imageView, ImageUIModel.Companion.displayUserAvatarImage$default(companion, "", null, 2, null));
        CircleImageView circleImageView = getMBinding().userAvatar1;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "userAvatar1");
        ViewUtilitiesKt.bind$default(circleImageView, ImageUIModel.Companion.displayUserAvatarImage$default(companion, "https://image.whoisamy.shop/hilo/avatar/36b9dabbb0a6440bb3e5c9cc7b1ef0d3-20220527-1653632490811.png", null, 2, null), null, 2, null);
    }
}
