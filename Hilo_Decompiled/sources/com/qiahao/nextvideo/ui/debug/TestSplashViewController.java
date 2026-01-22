package com.qiahao.nextvideo.ui.debug;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.app.AdvertisingContentView;
import com.qiahao.nextvideo.app.MainActivity;
import com.qiahao.nextvideo.databinding.LayoutTestShapeImageViewBinding;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R%\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u00178\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/qiahao/nextvideo/ui/debug/TestSplashViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "<init>", "()V", "", "showSplashView", "hideSplashView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;", "view", "viewDidLoad", "(Landroid/view/View;)V", "Lcom/qiahao/nextvideo/databinding/LayoutTestShapeImageViewBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/LayoutTestShapeImageViewBinding;", "Lcom/qiahao/nextvideo/app/AdvertisingContentView;", "mAdvertisingContentView", "Lcom/qiahao/nextvideo/app/AdvertisingContentView;", "Lla/b;", "", "kotlin.jvm.PlatformType", "mainViewInit", "Lla/b;", "getMainViewInit", "()Lla/b;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TestSplashViewController extends BaseViewController {

    @NotNull
    private static final String TAG = "TestShapeableImageView";
    private LayoutTestShapeImageViewBinding binding;

    @Nullable
    private AdvertisingContentView mAdvertisingContentView;

    @NotNull
    private final la.b mainViewInit;

    public TestSplashViewController() {
        setTag(TAG);
        la.b e = la.b.e();
        Intrinsics.checkNotNullExpressionValue(e, "create(...)");
        this.mainViewInit = e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideSplashView() {
        android.util.Log.d(MainActivity.TAG, "hideSplashView: ");
        AdvertisingContentView advertisingContentView = this.mAdvertisingContentView;
        if (advertisingContentView != null) {
            advertisingContentView.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSplashView() {
        this.mainViewInit.accept(Boolean.FALSE);
        LayoutTestShapeImageViewBinding layoutTestShapeImageViewBinding = this.binding;
        LayoutTestShapeImageViewBinding layoutTestShapeImageViewBinding2 = null;
        if (layoutTestShapeImageViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            layoutTestShapeImageViewBinding = null;
        }
        FrameLayout frameLayout = layoutTestShapeImageViewBinding.contentBg;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "contentBg");
        this.mAdvertisingContentView = new AdvertisingContentView(frameLayout, this.mainViewInit);
        LayoutTestShapeImageViewBinding layoutTestShapeImageViewBinding3 = this.binding;
        if (layoutTestShapeImageViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            layoutTestShapeImageViewBinding2 = layoutTestShapeImageViewBinding3;
        }
        FrameLayout frameLayout2 = layoutTestShapeImageViewBinding2.contentBg;
        AdvertisingContentView advertisingContentView = this.mAdvertisingContentView;
        Intrinsics.checkNotNull(advertisingContentView);
        frameLayout2.addView(advertisingContentView.getBinding().getRoot());
        AdvertisingContentView advertisingContentView2 = this.mAdvertisingContentView;
        Intrinsics.checkNotNull(advertisingContentView2);
        advertisingContentView2.show();
    }

    @NotNull
    public final la.b getMainViewInit() {
        return this.mainViewInit;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        LayoutTestShapeImageViewBinding inflate = LayoutTestShapeImageViewBinding.inflate(inflater, container, false);
        this.binding = inflate;
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        LayoutTestShapeImageViewBinding layoutTestShapeImageViewBinding = this.binding;
        if (layoutTestShapeImageViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            layoutTestShapeImageViewBinding = null;
        }
        layoutTestShapeImageViewBinding.showSplash.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.debug.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TestSplashViewController.this.showSplashView();
            }
        });
        nd.c subscribe = this.mainViewInit.observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.debug.TestSplashViewController$viewDidLoad$2
            public final void accept(Boolean bool) {
                if (bool.booleanValue()) {
                    TestSplashViewController.this.hideSplashView();
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, getCompositeDisposable());
    }
}
