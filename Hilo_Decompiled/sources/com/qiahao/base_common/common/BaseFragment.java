package com.qiahao.base_common.common;

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
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import cf.m;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.oudi.core.component.SuperFragment;
import com.oudi.utils.ktx.ContextKtxKt;
import com.oudi.utils.log.ILog;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RootViewDeferringInsetsCallback;
import com.therouter.TheRouter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH\u0017J\u001c\u0010\u001c\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u0016H\u0007JJ\u0010\u001f\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b26\u0010 \u001a2\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00060!H\u0007J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0016H\u0007¨\u0006)"}, d2 = {"Lcom/qiahao/base_common/common/BaseFragment;", "Lcom/oudi/core/component/SuperFragment;", "Lcom/oudi/utils/log/ILog;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "onInitializeBefore", "onInitialize", "onInitializeAfter", "getMyLifecycle", "Landroidx/lifecycle/Lifecycle;", "onDestroyView", "onDestroy", "onResume", "onPause", "isEnableEvent", "", "registerEventBus", "unRegisterEventBus", "onEvent", "event", "", "setStatusBarTopOrBottom", "rootView", "isBottom", "getStatusBarTopOrBottom", "onResult", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", ViewHierarchyConstants.DIMENSION_TOP_KEY, "bottom", "setStatusBarIconColor", "isLight", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaseFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseFragment.kt\ncom/qiahao/base_common/common/BaseFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,218:1\n161#2,8:219\n161#2,8:227\n*S KotlinDebug\n*F\n+ 1 BaseFragment.kt\ncom/qiahao/base_common/common/BaseFragment\n*L\n114#1:219,8\n139#1:227,8\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class BaseFragment extends SuperFragment implements ILog {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void getStatusBarTopOrBottom$lambda$8(BaseFragment baseFragment, final View view, final Function2 function2) {
        Window window;
        View decorView;
        FragmentActivity activity = baseFragment.getActivity();
        if (activity != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            new RootViewDeferringInsetsCallback(d2.m.g(), d2.m.b());
            d1.E0(decorView, new j0() { // from class: com.qiahao.base_common.common.i
                @Override // androidx.core.view.j0
                public final d2 onApplyWindowInsets(View view2, d2 d2Var) {
                    d2 statusBarTopOrBottom$lambda$8$lambda$7$lambda$6$lambda$5;
                    statusBarTopOrBottom$lambda$8$lambda$7$lambda$6$lambda$5 = BaseFragment.getStatusBarTopOrBottom$lambda$8$lambda$7$lambda$6$lambda$5(view, function2, view2, d2Var);
                    return statusBarTopOrBottom$lambda$8$lambda$7$lambda$6$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d2 getStatusBarTopOrBottom$lambda$8$lambda$7$lambda$6$lambda$5(View view, Function2 function2, View view2, d2 insets) {
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

    public static /* synthetic */ void setStatusBarTopOrBottom$default(BaseFragment baseFragment, View view, boolean z10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 2) != 0) {
                z10 = true;
            }
            baseFragment.setStatusBarTopOrBottom(view, z10);
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
    public static final void setStatusBarTopOrBottom$lambda$4(BaseFragment baseFragment, final View view, final boolean z10) {
        Window window;
        View decorView;
        FragmentActivity activity = baseFragment.getActivity();
        if (activity != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            new RootViewDeferringInsetsCallback(d2.m.g(), d2.m.b());
            d1.E0(decorView, new j0() { // from class: com.qiahao.base_common.common.h
                @Override // androidx.core.view.j0
                public final d2 onApplyWindowInsets(View view2, d2 d2Var) {
                    d2 statusBarTopOrBottom$lambda$4$lambda$3$lambda$2$lambda$1;
                    statusBarTopOrBottom$lambda$4$lambda$3$lambda$2$lambda$1 = BaseFragment.setStatusBarTopOrBottom$lambda$4$lambda$3$lambda$2$lambda$1(view, z10, view2, d2Var);
                    return statusBarTopOrBottom$lambda$4$lambda$3$lambda$2$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d2 setStatusBarTopOrBottom$lambda$4$lambda$3$lambda$2$lambda$1(View view, boolean z10, View view2, d2 insets) {
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

    @Override // com.oudi.utils.log.ILog
    @NotNull
    public String getLogTag() {
        return ILog.DefaultImpls.getLogTag(this);
    }

    @Override // com.oudi.core.component.SuperFragment
    @Nullable
    public Lifecycle getMyLifecycle() {
        return ContextKtxKt.asLifecycle(getContext());
    }

    @Keep
    public final void getStatusBarTopOrBottom(@Nullable final View rootView, @NotNull final Function2<? super Integer, ? super Integer, Unit> onResult) {
        int i10;
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
        if (rootView != null) {
            rootView.post(new Runnable() { // from class: com.qiahao.base_common.common.j
                @Override // java.lang.Runnable
                public final void run() {
                    BaseFragment.getStatusBarTopOrBottom$lambda$8(BaseFragment.this, rootView, onResult);
                }
            });
        }
    }

    protected boolean isEnableEvent() {
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

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        ILog.DefaultImpls.logI$default(this, "Fragment-onCreate()", null, true, 2, null);
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        ILog.DefaultImpls.logI$default(this, "Fragment-onDestroy()", null, true, 2, null);
        super.onDestroy();
        unRegisterEventBus();
    }

    @Override // com.oudi.core.component.SuperLazyFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ILog.DefaultImpls.logI$default(this, "Fragment-onDestroyView()", null, true, 2, null);
        super.onDestroyView();
    }

    @m(threadMode = ThreadMode.MAIN)
    public void onEvent(@NotNull Object event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // com.oudi.core.component.SuperFragment, com.oudi.core.component.IVmComponent, com.oudi.core.component.IComponent
    public void onInitialize() {
        ILog.DefaultImpls.logI$default(this, "Fragment-onInitialize()", null, true, 2, null);
        super.onInitialize();
    }

    @Override // com.oudi.core.component.SuperFragment, com.oudi.core.component.IComponent
    public void onInitializeAfter() {
        super.onInitializeAfter();
        if (isEnableEvent()) {
            registerEventBus();
        }
    }

    @Override // com.oudi.core.component.SuperFragment, com.oudi.core.component.IComponent
    public void onInitializeBefore() {
        super.onInitializeBefore();
        TheRouter.inject(this);
    }

    @Override // com.oudi.core.component.SuperLazyFragment, androidx.fragment.app.Fragment
    public void onPause() {
        ILog.DefaultImpls.logI$default(this, "Fragment-onPause()", null, true, 2, null);
        super.onPause();
    }

    @Override // com.oudi.core.component.SuperLazyFragment, androidx.fragment.app.Fragment
    public void onResume() {
        ILog.DefaultImpls.logI$default(this, "Fragment-onResume()", null, true, 2, null);
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        ILog.DefaultImpls.logI$default(this, "Fragment-onViewCreated()", null, true, 2, null);
        super.onViewCreated(view, savedInstanceState);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
    
        r0 = r0.getInsetsController();
     */
    @Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setStatusBarIconColor(boolean isLight) {
        View view;
        int i10;
        Window window;
        WindowInsetsController insetsController;
        int i11;
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 30) {
            FragmentActivity activity = getActivity();
            if (activity != null && (r0 = activity.getWindow()) != null && insetsController != null) {
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
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (window = activity2.getWindow()) != null) {
                view = window.getDecorView();
            } else {
                view = null;
            }
            if (view != null) {
                int systemUiVisibility = view.getSystemUiVisibility();
                if (isLight) {
                    i10 = systemUiVisibility | 8192;
                } else {
                    i10 = systemUiVisibility & (-8193);
                }
                view.setSystemUiVisibility(i10);
            }
        }
    }

    @Keep
    public final void setStatusBarTopOrBottom(@Nullable final View rootView, final boolean isBottom) {
        BaseApplication companion = BaseApplication.INSTANCE.getInstance();
        if (companion != null && companion.checkStatusAndNavigationHeight()) {
            if (rootView != null) {
                rootView.post(new Runnable() { // from class: com.qiahao.base_common.common.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseFragment.setStatusBarTopOrBottom$lambda$0(isBottom, rootView);
                    }
                });
            }
        } else if (rootView != null) {
            rootView.post(new Runnable() { // from class: com.qiahao.base_common.common.g
                @Override // java.lang.Runnable
                public final void run() {
                    BaseFragment.setStatusBarTopOrBottom$lambda$4(BaseFragment.this, rootView, isBottom);
                }
            });
        }
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
