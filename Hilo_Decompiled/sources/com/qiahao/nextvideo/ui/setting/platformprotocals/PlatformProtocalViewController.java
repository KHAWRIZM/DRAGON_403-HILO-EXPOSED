package com.qiahao.nextvideo.ui.setting.platformprotocals;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.databinding.ViewControllerPlatformProtocalBinding;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewControllerKt;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import com.qiahao.nextvideo.ui.webview.DefaultWebActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/ui/setting/platformprotocals/PlatformProtocalViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "<init>", "()V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerPlatformProtocalBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "viewDidLoad", "", "view", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPlatformProtocalViewController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformProtocalViewController.kt\ncom/qiahao/nextvideo/ui/setting/platformprotocals/PlatformProtocalViewController\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,45:1\n61#2,9:46\n*S KotlinDebug\n*F\n+ 1 PlatformProtocalViewController.kt\ncom/qiahao/nextvideo/ui/setting/platformprotocals/PlatformProtocalViewController\n*L\n40#1:46,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PlatformProtocalViewController extends BaseViewController {
    private ViewControllerPlatformProtocalBinding binding;

    public PlatformProtocalViewController() {
        setTag("platformprotocal");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$1(PlatformProtocalViewController platformProtocalViewController, View view) {
        DefaultWebActivity.INSTANCE.start(platformProtocalViewController.getRequireActivity(), BaseViewControllerKt.getString(platformProtocalViewController, 2131954239, new Object[0]), BaseViewControllerKt.getString(platformProtocalViewController, 2131954238, new Object[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$2(PlatformProtocalViewController platformProtocalViewController, View view) {
        DefaultWebActivity.INSTANCE.start(platformProtocalViewController.getRequireActivity(), BaseViewControllerKt.getString(platformProtocalViewController, 2131953717, new Object[0]), BaseViewControllerKt.getString(platformProtocalViewController, 2131953716, new Object[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$3(PlatformProtocalViewController platformProtocalViewController, View view) {
        DefaultWebActivity.INSTANCE.start(platformProtocalViewController.getRequireActivity(), "https://hiloconn.com/action/policy/Copyright_Policy.html", BaseViewControllerKt.getString(platformProtocalViewController, 2131953661, new Object[0]));
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerPlatformProtocalBinding inflate = ViewControllerPlatformProtocalBinding.inflate(inflater, container, false);
        this.binding = inflate;
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        HiloBaseActivity requireActivity = getRequireActivity();
        ViewControllerPlatformProtocalBinding viewControllerPlatformProtocalBinding = this.binding;
        ViewControllerPlatformProtocalBinding viewControllerPlatformProtocalBinding2 = null;
        if (viewControllerPlatformProtocalBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPlatformProtocalBinding = null;
        }
        Toolbar toolbar = viewControllerPlatformProtocalBinding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        requireActivity.setStatusBarTopOrBottom(toolbar, false);
        ViewControllerPlatformProtocalBinding viewControllerPlatformProtocalBinding3 = this.binding;
        if (viewControllerPlatformProtocalBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPlatformProtocalBinding3 = null;
        }
        viewControllerPlatformProtocalBinding3.termsOfServiceButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.platformprotocals.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PlatformProtocalViewController.viewDidLoad$lambda$1(PlatformProtocalViewController.this, view2);
            }
        });
        ViewControllerPlatformProtocalBinding viewControllerPlatformProtocalBinding4 = this.binding;
        if (viewControllerPlatformProtocalBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPlatformProtocalBinding4 = null;
        }
        viewControllerPlatformProtocalBinding4.privacyPolicyButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.platformprotocals.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PlatformProtocalViewController.viewDidLoad$lambda$2(PlatformProtocalViewController.this, view2);
            }
        });
        ViewControllerPlatformProtocalBinding viewControllerPlatformProtocalBinding5 = this.binding;
        if (viewControllerPlatformProtocalBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPlatformProtocalBinding5 = null;
        }
        viewControllerPlatformProtocalBinding5.copyrightPolicyButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.platformprotocals.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PlatformProtocalViewController.viewDidLoad$lambda$3(PlatformProtocalViewController.this, view2);
            }
        });
        ViewControllerPlatformProtocalBinding viewControllerPlatformProtocalBinding6 = this.binding;
        if (viewControllerPlatformProtocalBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPlatformProtocalBinding6 = null;
        }
        final AppCompatButton appCompatButton = viewControllerPlatformProtocalBinding6.childSafetyPolicy;
        final long j = 800;
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.platformprotocals.PlatformProtocalViewController$viewDidLoad$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton) > j || (appCompatButton instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton, currentTimeMillis);
                    AppCompatButton appCompatButton2 = appCompatButton;
                    DefaultWebActivity.INSTANCE.start(this.getRequireActivity(), ResourcesKtxKt.getStringById(this, 2131952254), BaseViewControllerKt.getString(this, 2131952253, new Object[0]));
                }
            }
        });
        ViewControllerPlatformProtocalBinding viewControllerPlatformProtocalBinding7 = this.binding;
        if (viewControllerPlatformProtocalBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerPlatformProtocalBinding2 = viewControllerPlatformProtocalBinding7;
        }
        viewControllerPlatformProtocalBinding2.backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.platformprotocals.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ViewController.dismiss$default(PlatformProtocalViewController.this, true, null, 2, null);
            }
        });
    }
}
