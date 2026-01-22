package com.qiahao.base_common.common;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.annotation.Keep;
import androidx.core.graphics.b0;
import androidx.core.view.d1;
import androidx.core.view.d2;
import androidx.core.view.j0;
import androidx.core.view.p1;
import cf.m;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.oudi.core.component.SuperActivity;
import com.oudi.core.component.bridge.ComponentAction;
import com.oudi.core.loading.ILoading;
import com.oudi.utils.KeyboardUtils;
import com.oudi.utils.log.ILog;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.ui.loading.LoadingDialog;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RootViewDeferringInsetsCallback;
import com.qiahao.base_common.utils.language.LanguageHelper;
import com.therouter.TheRouter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\fH\u0014J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J!\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010!J\u0017\u0010\"\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\fH\u0014J\b\u0010(\u001a\u00020\fH\u0014J\b\u0010)\u001a\u00020\u0019H\u0014J\b\u0010*\u001a\u00020\fH\u0014J\u001a\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020\u0019H\u0007JH\u0010/\u001a\u00020\f2\u0006\u0010,\u001a\u00020-26\u00100\u001a2\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\f01H\u0007J\u0010\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\u0019H\u0007J\b\u0010\u0007\u001a\u0004\u0018\u000108R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u00069"}, d2 = {"Lcom/qiahao/base_common/common/BaseActivity;", "Lcom/oudi/core/component/SuperActivity;", "Lcom/oudi/utils/log/ILog;", "<init>", "()V", "loadingDialog", "Lcom/qiahao/base_common/ui/loading/LoadingDialog;", "getLoadingDialog", "()Lcom/qiahao/base_common/ui/loading/LoadingDialog;", "setLoadingDialog", "(Lcom/qiahao/base_common/ui/loading/LoadingDialog;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "attachBaseContext", "newBase", "Landroid/content/Context;", "onInitializeBefore", "onInitializeAfter", "onDestroy", "onEvent", "event", "", "isEnableEvent", "", "registerEventBus", "unRegisterEventBus", "showLoading", "id", "", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "", "(Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "dismissLoading", "(Ljava/lang/Integer;)V", "onAction", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/oudi/core/component/bridge/ComponentAction;", "initOrientation", "hideSoftInput", "isEnabledAutoHideSoftInput", "onTitleBarLeftClick", "setStatusBarTopOrBottom", "rootView", "Landroid/view/View;", "isBottom", "getStatusBarTopOrBottom", "onResult", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", ViewHierarchyConstants.DIMENSION_TOP_KEY, "bottom", "setStatusBarIconColor", "isLight", "Landroid/app/Dialog;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaseActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseActivity.kt\ncom/qiahao/base_common/common/BaseActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,275:1\n161#2,8:276\n161#2,8:284\n*S KotlinDebug\n*F\n+ 1 BaseActivity.kt\ncom/qiahao/base_common/common/BaseActivity\n*L\n171#1:276,8\n195#1:284,8\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class BaseActivity extends SuperActivity implements ILog {

    @Nullable
    private LoadingDialog loadingDialog;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getStatusBarTopOrBottom$lambda$6(BaseActivity baseActivity, final View view, final Function2 function2) {
        new RootViewDeferringInsetsCallback(d2.m.g(), d2.m.b());
        d1.E0(baseActivity.getWindow().getDecorView(), new j0() { // from class: com.qiahao.base_common.common.a
            @Override // androidx.core.view.j0
            public final d2 onApplyWindowInsets(View view2, d2 d2Var) {
                d2 statusBarTopOrBottom$lambda$6$lambda$5$lambda$4;
                statusBarTopOrBottom$lambda$6$lambda$5$lambda$4 = BaseActivity.getStatusBarTopOrBottom$lambda$6$lambda$5$lambda$4(view, function2, view2, d2Var);
                return statusBarTopOrBottom$lambda$6$lambda$5$lambda$4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d2 getStatusBarTopOrBottom$lambda$6$lambda$5$lambda$4(View view, Function2 function2, View view2, d2 insets) {
        BaseApplication companion;
        BaseApplication companion2;
        Intrinsics.checkNotNullParameter(view2, "<unused var>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        b0 f10 = insets.f(d2.m.g());
        Intrinsics.checkNotNullExpressionValue(f10, "getInsets(...)");
        int i10 = f10.f٢٧٩٤b;
        int i11 = f10.f٢٧٩٦d;
        if (i10 == 0) {
            HiloUtils hiloUtils = HiloUtils.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            int statusBarHeight = hiloUtils.getStatusBarHeight(context);
            if (i11 == 0) {
                Context context2 = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                i11 = hiloUtils.getNavigationBarHeight(context2);
            }
            i10 = statusBarHeight;
        }
        if (i10 > 0 && (companion2 = BaseApplication.INSTANCE.getInstance()) != null) {
            companion2.setMStatusHeight(i10);
        }
        if (i11 > 0 && (companion = BaseApplication.INSTANCE.getInstance()) != null) {
            companion.setMNavigationHeight(i11);
        }
        function2.invoke(Integer.valueOf(i10), Integer.valueOf(i11));
        return insets;
    }

    private final void registerEventBus() {
        if (!cf.c.c().j(this)) {
            cf.c.c().p(this);
        }
    }

    public static /* synthetic */ void setStatusBarTopOrBottom$default(BaseActivity baseActivity, View view, boolean z10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 2) != 0) {
                z10 = true;
            }
            baseActivity.setStatusBarTopOrBottom(view, z10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStatusBarTopOrBottom");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setStatusBarTopOrBottom$lambda$0(boolean z10, View view) {
        int i10;
        BaseApplication companion;
        BaseApplication companion2;
        int i11 = 0;
        if (z10 && (companion2 = BaseApplication.INSTANCE.getInstance()) != null) {
            i10 = companion2.getMNavigationHeight();
        } else {
            i10 = 0;
        }
        if (!z10 && (companion = BaseApplication.INSTANCE.getInstance()) != null) {
            i11 = companion.getMStatusHeight();
        }
        view.setPadding(view.getPaddingLeft(), i11, view.getPaddingRight(), i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setStatusBarTopOrBottom$lambda$3(BaseActivity baseActivity, final View view, final boolean z10) {
        new RootViewDeferringInsetsCallback(d2.m.g(), d2.m.b());
        d1.E0(baseActivity.getWindow().getDecorView(), new j0() { // from class: com.qiahao.base_common.common.e
            @Override // androidx.core.view.j0
            public final d2 onApplyWindowInsets(View view2, d2 d2Var) {
                d2 statusBarTopOrBottom$lambda$3$lambda$2$lambda$1;
                statusBarTopOrBottom$lambda$3$lambda$2$lambda$1 = BaseActivity.setStatusBarTopOrBottom$lambda$3$lambda$2$lambda$1(view, z10, view2, d2Var);
                return statusBarTopOrBottom$lambda$3$lambda$2$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d2 setStatusBarTopOrBottom$lambda$3$lambda$2$lambda$1(View view, boolean z10, View view2, d2 insets) {
        BaseApplication companion;
        BaseApplication companion2;
        Intrinsics.checkNotNullParameter(view2, "<unused var>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        b0 f10 = insets.f(d2.m.g());
        Intrinsics.checkNotNullExpressionValue(f10, "getInsets(...)");
        int i10 = f10.f٢٧٩٤b;
        int i11 = f10.f٢٧٩٦d;
        if (i10 == 0) {
            HiloUtils hiloUtils = HiloUtils.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            int statusBarHeight = hiloUtils.getStatusBarHeight(context);
            if (i11 == 0) {
                Context context2 = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                i11 = hiloUtils.getNavigationBarHeight(context2);
            }
            i10 = statusBarHeight;
        }
        if (i10 > 0 && (companion2 = BaseApplication.INSTANCE.getInstance()) != null) {
            companion2.setMStatusHeight(i10);
        }
        if (i11 > 0 && (companion = BaseApplication.INSTANCE.getInstance()) != null) {
            companion.setMNavigationHeight(i11);
        }
        if (!z10) {
            i11 = 0;
        }
        if (z10) {
            i10 = 0;
        }
        view.setPadding(view.getPaddingLeft(), i10, view.getPaddingRight(), i11);
        return insets;
    }

    private final void unRegisterEventBus() {
        if (cf.c.c().j(this)) {
            cf.c.c().r(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(@Nullable Context newBase) {
        super.attachBaseContext(LanguageHelper.INSTANCE.wrapContext(newBase));
    }

    @Override // com.oudi.core.component.SuperActivity, com.oudi.core.loading.ILoading
    public void dismissLoading(@Nullable Integer id) {
        LoadingDialog loadingDialog;
        super.dismissLoading(id);
        LoadingDialog loadingDialog2 = this.loadingDialog;
        if (loadingDialog2 != null && loadingDialog2.isShowing() && (loadingDialog = this.loadingDialog) != null) {
            loadingDialog.dismiss();
        }
    }

    @Nullable
    protected final LoadingDialog getLoadingDialog() {
        return this.loadingDialog;
    }

    @Override // com.oudi.utils.log.ILog
    @NotNull
    public String getLogTag() {
        return ILog.DefaultImpls.getLogTag(this);
    }

    @Keep
    public final void getStatusBarTopOrBottom(@NotNull final View rootView, @NotNull final Function2<? super Integer, ? super Integer, Unit> onResult) {
        int i10;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        BaseApplication.Companion companion = BaseApplication.INSTANCE;
        BaseApplication companion2 = companion.getInstance();
        if (companion2 != null && companion2.checkStatusAndNavigationHeight()) {
            BaseApplication companion3 = companion.getInstance();
            int i11 = 0;
            if (companion3 != null) {
                i10 = companion3.getMStatusHeight();
            } else {
                i10 = 0;
            }
            Integer valueOf = Integer.valueOf(i10);
            BaseApplication companion4 = companion.getInstance();
            if (companion4 != null) {
                i11 = companion4.getMNavigationHeight();
            }
            onResult.invoke(valueOf, Integer.valueOf(i11));
            return;
        }
        rootView.post(new Runnable() { // from class: com.qiahao.base_common.common.b
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.getStatusBarTopOrBottom$lambda$6(BaseActivity.this, rootView, onResult);
            }
        });
    }

    protected void hideSoftInput() {
        KeyboardUtils.hideSoftInput(this);
    }

    protected void initOrientation() {
        if (getRequestedOrientation() == -1 && Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
    }

    protected boolean isEnableEvent() {
        return true;
    }

    protected boolean isEnabledAutoHideSoftInput() {
        return true;
    }

    @Override // com.oudi.utils.log.ILog
    public void logD(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logD(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logI(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logI(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logV(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logV(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logW(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logW(this, str, str2, z10);
    }

    @Override // com.oudi.core.component.SuperActivity, com.oudi.core.component.IVmComponent, com.oudi.core.component.bridge.ComponentActionHandler
    public void onAction(@NotNull ComponentAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        super.onAction(action);
        if (action instanceof FinishAction) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oudi.core.component.SuperActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ILoading.DefaultImpls.dismissLoading$default(this, null, 1, null);
        unRegisterEventBus();
        this.loadingDialog = null;
        super.onDestroy();
    }

    @m(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull Object event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // com.oudi.core.component.SuperActivity, com.oudi.core.component.IComponent
    public void onInitializeAfter() {
        super.onInitializeAfter();
        if (isEnableEvent()) {
            registerEventBus();
        }
    }

    @Override // com.oudi.core.component.SuperActivity, com.oudi.core.component.IComponent
    public void onInitializeBefore() {
        super.onInitializeBefore();
        p1.b(getWindow(), false);
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        hiloUtils.transparentStatusBar(window);
        Window window2 = getWindow();
        Intrinsics.checkNotNullExpressionValue(window2, "getWindow(...)");
        hiloUtils.transparentNavigationBar(window2);
        setStatusBarIconColor(true);
        TheRouter.inject(this);
        initOrientation();
    }

    protected void onTitleBarLeftClick() {
        onBackPressed();
    }

    protected final void setLoadingDialog(@Nullable LoadingDialog loadingDialog) {
        this.loadingDialog = loadingDialog;
    }

    @Keep
    public final void setStatusBarIconColor(boolean isLight) {
        int i10;
        WindowInsetsController insetsController;
        int i11;
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 30) {
            insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                if (isLight) {
                    i11 = 8;
                } else {
                    i11 = 0;
                }
                insetsController.setSystemBarsAppearance(i11, 8);
                return;
            }
            return;
        }
        if (i12 >= 23) {
            int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            if (isLight) {
                i10 = systemUiVisibility | 8192;
            } else {
                i10 = systemUiVisibility & (-8193);
            }
            getWindow().getDecorView().setSystemUiVisibility(i10);
        }
    }

    @Keep
    public final void setStatusBarTopOrBottom(@NotNull final View rootView, final boolean isBottom) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        BaseApplication companion = BaseApplication.INSTANCE.getInstance();
        if (companion != null && companion.checkStatusAndNavigationHeight()) {
            rootView.post(new Runnable() { // from class: com.qiahao.base_common.common.c
                @Override // java.lang.Runnable
                public final void run() {
                    BaseActivity.setStatusBarTopOrBottom$lambda$0(isBottom, rootView);
                }
            });
        } else {
            rootView.post(new Runnable() { // from class: com.qiahao.base_common.common.d
                @Override // java.lang.Runnable
                public final void run() {
                    BaseActivity.setStatusBarTopOrBottom$lambda$3(BaseActivity.this, rootView, isBottom);
                }
            });
        }
    }

    @Override // com.oudi.core.component.SuperActivity, com.oudi.core.loading.ILoading
    public void showLoading(@Nullable Integer id, @Nullable CharSequence message) {
        LoadingDialog loadingDialog;
        super.showLoading(id, message);
        if (this.loadingDialog == null) {
            this.loadingDialog = new LoadingDialog(getContext(), false);
        }
        LoadingDialog loadingDialog2 = this.loadingDialog;
        if ((loadingDialog2 == null || !loadingDialog2.isShowing()) && (loadingDialog = this.loadingDialog) != null) {
            loadingDialog.show();
        }
    }

    @Nullable
    public final Dialog getLoadingDialog() {
        return this.loadingDialog;
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, th, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
        ILog.DefaultImpls.logE(this, th, str, z10);
    }
}
