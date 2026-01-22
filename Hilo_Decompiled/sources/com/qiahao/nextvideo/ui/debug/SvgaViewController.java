package com.qiahao.nextvideo.ui.debug;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import com.opensource.svgaplayer.SVGACallback;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.data.model.MyAward;
import com.qiahao.nextvideo.data.model.RocketResultBean;
import com.qiahao.nextvideo.data.model.TopContributor;
import com.qiahao.nextvideo.databinding.ViewControllerSvgaBinding;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/ui/debug/SvgaViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "<init>", "()V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerSvgaBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "viewDidLoad", "", "view", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SvgaViewController extends BaseViewController {
    private ViewControllerSvgaBinding binding;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$1(SvgaViewController svgaViewController, View view) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RocketResultBean("@TGS#3FD4MDPHH", new MyAward(0, 0, "", null, 8, null), "2022-02-25", 32, 0, 1645781482, new TopContributor(0, "", "", "", "", "", false, "", 0), 0, null, 384, null));
        arrayList.add(new RocketResultBean("@TGS#3FD4MDPHH", new MyAward(0, 0, "", null, 8, null), "2022-02-26", 32, 1, 1645781482, new TopContributor(0, "", "", "", "", "", false, "", 0), 0, null, 384, null));
        arrayList.add(new RocketResultBean("@TGS#3FD4MDPHH", new MyAward(0, 0, "", null, 8, null), "2022-02-27", 32, 2, 1645781482, new TopContributor(0, "", "", "", "", "", false, "", 0), 0, null, 384, null));
        arrayList.add(new RocketResultBean("@TGS#3FD4MDPHH", new MyAward(0, 0, "", null, 8, null), "2022-02-28", 32, 0, 1645781482, new TopContributor(0, "", "", "", "", "", false, "", 0), 0, null, 384, null));
        ViewControllerSvgaBinding viewControllerSvgaBinding = svgaViewController.binding;
        if (viewControllerSvgaBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerSvgaBinding = null;
        }
        viewControllerSvgaBinding.rocketSvga.setData(arrayList, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$2(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$3(SvgaViewController svgaViewController, View view) {
        ViewControllerSvgaBinding viewControllerSvgaBinding = svgaViewController.binding;
        if (viewControllerSvgaBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerSvgaBinding = null;
        }
        viewControllerSvgaBinding.addDurationSvgaImageView.startAnimation();
        es.dmoral.toasty.a.i(svgaViewController.getRequireContext(), "addDurationSvgaButtonPressed()").show();
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerSvgaBinding inflate = ViewControllerSvgaBinding.inflate(inflater, container, false);
        this.binding = inflate;
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        HiloBaseActivity hiloBaseActivity = get_activity();
        ViewControllerSvgaBinding viewControllerSvgaBinding = null;
        if (hiloBaseActivity != null) {
            ViewControllerSvgaBinding viewControllerSvgaBinding2 = this.binding;
            if (viewControllerSvgaBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewControllerSvgaBinding2 = null;
            }
            Toolbar toolbar = viewControllerSvgaBinding2.toolbar;
            Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
            hiloBaseActivity.setStatusBarTopOrBottom(toolbar, false);
        }
        ViewControllerSvgaBinding viewControllerSvgaBinding3 = this.binding;
        if (viewControllerSvgaBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerSvgaBinding3 = null;
        }
        viewControllerSvgaBinding3.allSvgaButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.debug.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SvgaViewController.viewDidLoad$lambda$1(SvgaViewController.this, view2);
            }
        });
        ViewControllerSvgaBinding viewControllerSvgaBinding4 = this.binding;
        if (viewControllerSvgaBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerSvgaBinding4 = null;
        }
        viewControllerSvgaBinding4.likeSvgaButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.debug.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SvgaViewController.viewDidLoad$lambda$2(view2);
            }
        });
        ViewControllerSvgaBinding viewControllerSvgaBinding5 = this.binding;
        if (viewControllerSvgaBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerSvgaBinding5 = null;
        }
        viewControllerSvgaBinding5.addDurationSvgaButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.debug.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SvgaViewController.viewDidLoad$lambda$3(SvgaViewController.this, view2);
            }
        });
        ViewControllerSvgaBinding viewControllerSvgaBinding6 = this.binding;
        if (viewControllerSvgaBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerSvgaBinding = viewControllerSvgaBinding6;
        }
        viewControllerSvgaBinding.addDurationSvgaImageView.setCallback(new SVGACallback() { // from class: com.qiahao.nextvideo.ui.debug.SvgaViewController$viewDidLoad$4
            public void onFinished() {
            }

            public void onPause() {
            }

            public void onRepeat() {
            }

            public void onStep(int frame, double percentage) {
            }
        });
    }
}
