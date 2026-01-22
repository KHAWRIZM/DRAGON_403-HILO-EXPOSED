package com.qiahao.nextvideo.ui.reusable.viewcontroller;

import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.host.ControllerHost;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentationStyle;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentingAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/Window;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/host/ControllerHost;", AgooConstants.OPEN_ACTIIVTY_NAME, "Lcom/qiahao/nextvideo/app/base/HiloBaseActivity;", "<init>", "(Lcom/qiahao/nextvideo/app/base/HiloBaseActivity;)V", "setRootViewController", "", "controller", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/ViewController;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class Window extends ControllerHost {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Window(@NotNull HiloBaseActivity hiloBaseActivity) {
        super(hiloBaseActivity);
        Intrinsics.checkNotNullParameter(hiloBaseActivity, AgooConstants.OPEN_ACTIIVTY_NAME);
    }

    public final void setRootViewController(@NotNull ViewController controller) {
        String str;
        PresentationStyle presentationStyle;
        Intrinsics.checkNotNullParameter(controller, "controller");
        if (getActivity() == null) {
            return;
        }
        if (getTopViewController() == null) {
            HiloBaseActivity activity = getActivity();
            Intrinsics.checkNotNull(activity);
            push(controller, activity, false, null);
            return;
        }
        ViewController topViewController = getTopViewController();
        if (topViewController != null) {
            str = topViewController.getTag();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str, controller.getTag())) {
            popAllButTop();
            ViewController topViewController2 = getTopViewController();
            if (topViewController2 != null && (presentationStyle = topViewController2.getPresentationStyle()) != null) {
                presentationStyle.setAnimation(PresentingAnimation.BOTTOM);
            }
            HiloBaseActivity activity2 = getActivity();
            Intrinsics.checkNotNull(activity2);
            addBottom(controller, activity2);
            pop(true, null);
        }
    }
}
