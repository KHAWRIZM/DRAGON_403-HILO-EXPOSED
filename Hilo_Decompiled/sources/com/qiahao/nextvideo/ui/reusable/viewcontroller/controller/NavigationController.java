package com.qiahao.nextvideo.ui.reusable.viewcontroller.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.host.ControllerHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0019\u001a\u00020\u0014H\u0016R\u001a\u0010\u0002\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/NavigationController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/ViewController;", "root", "<init>", "(Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/ViewController;)V", "getRoot", "()Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/ViewController;", "setRoot", "controllerHost", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/host/ControllerHost;", "pendingRoot", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "viewWillAppear", "", "animated", "", "doDestroyView", "push", "viewController", "popViewController", "onBackPressed", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class NavigationController extends ViewController {

    @Nullable
    private ControllerHost controllerHost;

    @Nullable
    private ViewController pendingRoot;

    @NotNull
    private ViewController root;

    public NavigationController(@NotNull ViewController viewController) {
        Intrinsics.checkNotNullParameter(viewController, "root");
        this.root = viewController;
        this.pendingRoot = viewController;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void doDestroyView(@NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        ControllerHost controllerHost = this.controllerHost;
        if (controllerHost != null) {
            controllerHost.popAll();
        }
        this.root.setNavigationController(null);
        super.doDestroyView(container);
    }

    @NotNull
    public final ViewController getRoot() {
        return this.root;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public boolean onBackPressed() {
        ControllerHost controllerHost = this.controllerHost;
        if (controllerHost != null) {
            return controllerHost.onBackPressed();
        }
        return false;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ControllerHost controllerHost = new ControllerHost(getRequireActivity());
        this.controllerHost = controllerHost;
        Intrinsics.checkNotNull(controllerHost);
        return controllerHost;
    }

    public final void popViewController(boolean animated) {
        ControllerHost controllerHost = this.controllerHost;
        if (controllerHost != null) {
            controllerHost.pop(animated, null);
        }
    }

    public final void push(@NotNull ViewController viewController, boolean animated) {
        Intrinsics.checkNotNullParameter(viewController, "viewController");
        viewController.setNavigationController(this);
        ControllerHost controllerHost = this.controllerHost;
        if (controllerHost != null) {
            controllerHost.push(viewController, getRequireActivity(), animated, null);
        }
    }

    public final void setRoot(@NotNull ViewController viewController) {
        Intrinsics.checkNotNullParameter(viewController, "<set-?>");
        this.root = viewController;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewWillAppear(boolean animated) {
        super.viewWillAppear(animated);
        ViewController viewController = this.pendingRoot;
        if (viewController != null) {
            Intrinsics.checkNotNull(viewController);
            viewController.setNavigationController(this);
            ControllerHost controllerHost = this.controllerHost;
            Intrinsics.checkNotNull(controllerHost);
            ViewController viewController2 = this.pendingRoot;
            Intrinsics.checkNotNull(viewController2);
            controllerHost.push(viewController2, getRequireActivity(), false, null);
            this.pendingRoot = null;
        }
    }
}
