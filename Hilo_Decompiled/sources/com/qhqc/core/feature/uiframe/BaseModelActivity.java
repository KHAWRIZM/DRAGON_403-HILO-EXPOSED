package com.qhqc.core.feature.uiframe;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import com.qhqc.core.basic.expand.ViewBindUtilKt;
import com.qhqc.core.basic.uiframe.ui.BasicVBActivity;
import com.qhqc.core.basic.uiframe.viewmodel.BaseViewModel;
import com.qhqc.core.basic.widget.svprogresshud.SVProgressHUD;
import com.qhqc.core.basic.widget.toolbar.ICommonToolbar;
import j3.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0010\u0010\u0007J\u0019\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0015\u0010\u0007J\u0015\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001cR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R$\u0010(\u001a\u0004\u0018\u00010\n8\u0014@\u0014X\u0094\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\f\"\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/qhqc/core/feature/uiframe/BaseModelActivity;", "Lj3/a;", "VB", "Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;", "VM", "Lcom/qhqc/core/basic/uiframe/ui/BasicVBActivity;", "<init>", "()V", "", "initContentView", "Lcom/qhqc/core/basic/widget/toolbar/ICommonToolbar;", "onCreateCommonToolbar", "()Lcom/qhqc/core/basic/widget/toolbar/ICommonToolbar;", "", "isDarkTheme", "()Z", "onBindingView", "", "s", "showLoading", "(Ljava/lang/String;)V", "dismissLoading", "isLight", "setNavigationBarIconColor", "(Z)V", "Landroid/view/Window;", "window", "transparentStatusBar", "(Landroid/view/Window;)V", "transparentNavigationBar", "Landroid/view/View;", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "Lcom/qhqc/core/basic/widget/svprogresshud/SVProgressHUD;", "mLoadingView", "Lcom/qhqc/core/basic/widget/svprogresshud/SVProgressHUD;", "commonToolbar", "Lcom/qhqc/core/basic/widget/toolbar/ICommonToolbar;", "getCommonToolbar", "setCommonToolbar", "(Lcom/qhqc/core/basic/widget/toolbar/ICommonToolbar;)V", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class BaseModelActivity<VB extends a, VM extends BaseViewModel> extends BasicVBActivity<VB, VM> {

    @Nullable
    private ICommonToolbar commonToolbar;

    @Nullable
    private SVProgressHUD mLoadingView;

    @Nullable
    private View rootView;

    private final void initContentView() {
        Toolbar toolbar;
        View view = this.rootView;
        if (view != null) {
            setCommonToolbar(onCreateCommonToolbar());
            if (getCommonToolbar() != null) {
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                linearLayout.setOrientation(1);
                linearLayout.setFitsSystemWindows(true);
                ICommonToolbar commonToolbar = getCommonToolbar();
                Intrinsics.checkNotNull(commonToolbar);
                linearLayout.addView(commonToolbar.getRootView());
                linearLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
                setContentView(linearLayout);
                ICommonToolbar commonToolbar2 = getCommonToolbar();
                if (commonToolbar2 != null) {
                    toolbar = commonToolbar2.getToolbar();
                } else {
                    toolbar = null;
                }
                setSupportActionBar(toolbar);
                androidx.appcompat.app.a supportActionBar = getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.t(false);
                    return;
                }
                return;
            }
            setContentView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMActivity
    public void dismissLoading() {
        SVProgressHUD sVProgressHUD = this.mLoadingView;
        if (sVProgressHUD != null && sVProgressHUD.isShowing()) {
            sVProgressHUD.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public ICommonToolbar getCommonToolbar() {
        return this.commonToolbar;
    }

    @Nullable
    protected final View getRootView() {
        return this.rootView;
    }

    @Override // com.qhqc.core.basic.uiframe.ui.BasicActivity
    protected boolean isDarkTheme() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicVBActivity, com.qhqc.core.basic.uiframe.ui.BasicVMActivity
    protected void onBindingView() {
        LayoutInflater layoutInflater = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "getLayoutInflater(...)");
        setBinding(ViewBindUtilKt.inflateWithGeneric(this, layoutInflater));
        this.rootView = getBinding().getRoot();
        initContentView();
    }

    @Nullable
    protected ICommonToolbar onCreateCommonToolbar() {
        return null;
    }

    protected void setCommonToolbar(@Nullable ICommonToolbar iCommonToolbar) {
        this.commonToolbar = iCommonToolbar;
    }

    public final void setNavigationBarIconColor(boolean isLight) {
        int i10;
        WindowInsetsController insetsController;
        int i11;
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 30) {
            insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                if (isLight) {
                    i11 = 16;
                } else {
                    i11 = 0;
                }
                insetsController.setSystemBarsAppearance(i11, 16);
                return;
            }
            return;
        }
        if (i12 >= 23) {
            int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            if (isLight) {
                i10 = systemUiVisibility | 16;
            } else {
                i10 = systemUiVisibility & (-17);
            }
            getWindow().getDecorView().setSystemUiVisibility(i10);
        }
    }

    protected final void setRootView(@Nullable View view) {
        this.rootView = view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMActivity
    public void showLoading(@Nullable String s10) {
        if (this.mLoadingView == null) {
            this.mLoadingView = new SVProgressHUD(this);
        }
        SVProgressHUD sVProgressHUD = this.mLoadingView;
        if (sVProgressHUD != null) {
            sVProgressHUD.showWithStatus(s10);
        }
    }

    public final void transparentNavigationBar(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        if (Build.VERSION.SDK_INT >= 29) {
            window.setNavigationBarContrastEnforced(false);
        }
        window.clearFlags(134217728);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 16);
        window.setNavigationBarColor(-16777216);
    }

    public final void transparentStatusBar(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1280);
        window.setStatusBarColor(0);
    }
}
