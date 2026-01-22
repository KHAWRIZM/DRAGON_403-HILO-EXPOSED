package com.qiahao.nextvideo.ui.reusable.viewcontroller.controller;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentationStyle;
import com.taobao.accs.common.Constants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.apache.commons.sudcompress.archivers.zip.UnixStat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(message = "")
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 K2\u00020\u0001:\u0001KB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H&J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u000bH\u0016J\u0010\u00108\u001a\u0002062\u0006\u00107\u001a\u00020\u000bH\u0016J\u0010\u00109\u001a\u0002062\u0006\u0010:\u001a\u00020\u001dH\u0016J\u0010\u0010;\u001a\u0002062\u0006\u0010:\u001a\u00020\u001dH\u0016J\u0010\u0010<\u001a\u0002062\u0006\u0010:\u001a\u00020\u001dH\u0016J\u0010\u0010=\u001a\u0002062\u0006\u0010:\u001a\u00020\u001dH\u0016J\u0018\u0010>\u001a\u0002062\u0006\u00103\u001a\u0002042\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010?\u001a\u0002062\u0006\u00103\u001a\u000204H\u0016J\b\u0010@\u001a\u00020\u001dH\u0016J*\u0010A\u001a\u0002062\u0006\u0010B\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u001d2\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010DH\u0016J\"\u0010E\u001a\u0002062\u0006\u0010:\u001a\u00020\u001d2\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010DH\u0016J\b\u0010F\u001a\u00020GH\u0016J\u0010\u0010H\u001a\u0002062\u0006\u0010I\u001a\u00020JH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020-8F¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u0006L"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/ViewController;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", "navigationController", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/NavigationController;", "getNavigationController", "()Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/NavigationController;", "setNavigationController", "(Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/NavigationController;)V", "_view", "Landroid/view/View;", "requireView", "getRequireView", "()Landroid/view/View;", "_activity", "Lcom/qiahao/nextvideo/app/base/HiloBaseActivity;", "requireActivity", "getRequireActivity", "()Lcom/qiahao/nextvideo/app/base/HiloBaseActivity;", AgooConstants.OPEN_ACTIIVTY_NAME, "getActivity", "requireContext", "Landroid/content/Context;", "getRequireContext", "()Landroid/content/Context;", "context", "getContext", "_isVisible", "", "isVisible", "()Z", "presentationStyle", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/presentation/PresentationStyle;", "getPresentationStyle", "()Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/presentation/PresentationStyle;", "setPresentationStyle", "(Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/presentation/PresentationStyle;)V", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", Constants.SEND_TYPE_RES, "Landroid/content/res/Resources;", "getRes", "()Landroid/content/res/Resources;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "viewDidLoad", "", "view", "viewWillUnload", "viewWillAppear", "animated", "viewDidAppear", "viewWillDisappear", "viewDidDisappear", "doCreateView", "doDestroyView", "onBackPressed", "present", "viewController", "completion", "Lkotlin/Function0;", "dismiss", "processStatusBarCover", "", "onNewIntent", "newIntent", "Landroid/content/Intent;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewController implements LifecycleObserver {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static boolean verbose = true;

    @Nullable
    private HiloBaseActivity _activity;
    private boolean _isVisible;

    @Nullable
    private View _view;

    @Nullable
    private NavigationController navigationController;

    @NotNull
    private PresentationStyle presentationStyle = new PresentationStyle(null, false, 0, false, 0, false, false, false, 0, UnixStat.DEFAULT_LINK_PERM, null);

    @Nullable
    private String tag;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/ViewController$Companion;", "", "<init>", "()V", "verbose", "", "getVerbose", "()Z", "setVerbose", "(Z)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean getVerbose() {
            return ViewController.verbose;
        }

        public final void setVerbose(boolean z) {
            ViewController.verbose = z;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void dismiss$default(ViewController viewController, boolean z, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            viewController.dismiss(z, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dismiss");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void present$default(ViewController viewController, ViewController viewController2, boolean z, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                function0 = null;
            }
            viewController.present(viewController2, z, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: present");
    }

    public void dismiss(boolean animated, @Nullable Function0<Unit> completion) {
        if (get_activity() == null) {
            return;
        }
        BaseActivity baseActivity = get_activity();
        Intrinsics.checkNotNull(baseActivity);
        if (!baseActivity.isDestroyed()) {
            BaseActivity baseActivity2 = get_activity();
            Intrinsics.checkNotNull(baseActivity2);
            if (!baseActivity2.isFinishing()) {
                getRequireActivity().getControllerWindowNotNull().pop(animated, completion);
            }
        }
    }

    public void doCreateView(@NotNull ViewGroup container, @NotNull HiloBaseActivity activity) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
        this._activity = activity;
        LayoutInflater from = LayoutInflater.from(container.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "from(...)");
        this._view = onCreateView(from, container);
        viewDidLoad(getRequireView());
        if (verbose) {
            Log.i("oneHook", getClass().getSimpleName() + " (" + this.tag + ") CREATE VIEW");
        }
    }

    public void doDestroyView(@NotNull ViewGroup container) {
        Lifecycle myLifecycle;
        Intrinsics.checkNotNullParameter(container, "container");
        HiloBaseActivity hiloBaseActivity = this._activity;
        if (hiloBaseActivity != null && (myLifecycle = hiloBaseActivity.getMyLifecycle()) != null) {
            myLifecycle.removeObserver(this);
        }
        viewWillUnload(getRequireView());
        container.removeView(getRequireView());
        this._activity = null;
        this._view = null;
        this.navigationController = null;
        if (verbose) {
            Log.i("oneHook", getClass().getSimpleName() + " (" + this.tag + ") DESTROY VIEW");
        }
    }

    @Nullable
    /* renamed from: getActivity, reason: from getter */
    public final HiloBaseActivity get_activity() {
        return this._activity;
    }

    @Nullable
    public final Context getContext() {
        return this._activity;
    }

    @Nullable
    public final NavigationController getNavigationController() {
        return this.navigationController;
    }

    @NotNull
    public final PresentationStyle getPresentationStyle() {
        return this.presentationStyle;
    }

    @NotNull
    public final HiloBaseActivity getRequireActivity() {
        HiloBaseActivity hiloBaseActivity = this._activity;
        Intrinsics.checkNotNull(hiloBaseActivity);
        return hiloBaseActivity;
    }

    @NotNull
    public final Context getRequireContext() {
        BaseActivity baseActivity = this._activity;
        Intrinsics.checkNotNull(baseActivity);
        return baseActivity;
    }

    @NotNull
    public final View getRequireView() {
        View view = this._view;
        Intrinsics.checkNotNull(view);
        return view;
    }

    @NotNull
    public final Resources getRes() {
        HiloBaseActivity hiloBaseActivity = this._activity;
        Intrinsics.checkNotNull(hiloBaseActivity);
        Resources resources = hiloBaseActivity.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        return resources;
    }

    @Nullable
    public final String getTag() {
        return this.tag;
    }

    /* renamed from: isVisible, reason: from getter */
    public final boolean get_isVisible() {
        return this._isVisible;
    }

    public boolean onBackPressed() {
        return false;
    }

    @NotNull
    public abstract View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container);

    public void onNewIntent(@NotNull Intent newIntent) {
        Intrinsics.checkNotNullParameter(newIntent, "newIntent");
    }

    public void present(@NotNull ViewController viewController, boolean animated, @Nullable Function0<Unit> completion) {
        Intrinsics.checkNotNullParameter(viewController, "viewController");
        if (get_activity() == null) {
            return;
        }
        getRequireActivity().getControllerWindowNotNull().push(viewController, getRequireActivity(), animated, completion);
    }

    public int processStatusBarCover() {
        return 0;
    }

    public final void setNavigationController(@Nullable NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    public final void setPresentationStyle(@NotNull PresentationStyle presentationStyle) {
        Intrinsics.checkNotNullParameter(presentationStyle, "<set-?>");
        this.presentationStyle = presentationStyle;
    }

    public final void setTag(@Nullable String str) {
        this.tag = str;
    }

    public void viewDidAppear(boolean animated) {
        this._isVisible = true;
        if (verbose) {
            Log.i("oneHook", getClass().getSimpleName() + " (" + this.tag + ") VIEW DID APPEAR (" + getRequireView().getMeasuredWidth() + ", " + getRequireView().getMeasuredHeight() + ")");
        }
    }

    public void viewDidDisappear(boolean animated) {
        this._isVisible = false;
        if (verbose) {
            Log.i("oneHook", getClass().getSimpleName() + " (" + this.tag + ") VIEW DID DISAPPEAR");
        }
    }

    public void viewDidLoad(@NotNull View view) {
        Lifecycle myLifecycle;
        Intrinsics.checkNotNullParameter(view, "view");
        if (verbose) {
            Log.i("oneHook", getClass().getSimpleName() + " (" + this.tag + ") VIEW DID LOAD");
        }
        HiloBaseActivity hiloBaseActivity = this._activity;
        if (hiloBaseActivity != null && (myLifecycle = hiloBaseActivity.getMyLifecycle()) != null) {
            myLifecycle.addObserver(this);
        }
    }

    public void viewWillAppear(boolean animated) {
        if (verbose) {
            Log.i("oneHook", getClass().getSimpleName() + " (" + this.tag + ") VIEW WILL APPEAR (" + getRequireView().getMeasuredWidth() + ", " + getRequireView().getMeasuredHeight() + ")");
        }
    }

    public void viewWillDisappear(boolean animated) {
        if (verbose) {
            Log.i("oneHook", getClass().getSimpleName() + " (" + this.tag + ") VIEW WILL DISAPPEAR");
        }
    }

    public void viewWillUnload(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (verbose) {
            Log.i("oneHook", getClass().getSimpleName() + " (" + this.tag + ") VIEW WILL UNLOAD");
        }
    }
}
