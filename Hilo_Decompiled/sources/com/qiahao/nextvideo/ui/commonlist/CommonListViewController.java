package com.qiahao.nextvideo.ui.commonlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.databinding.ViewControllerCommonListBinding;
import com.qiahao.nextvideo.ui.commonlist.CommonListViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapperDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000 $2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001$B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001aH\u0016J\b\u0010\"\u001a\u00020#H\u0016R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/qiahao/nextvideo/ui/commonlist/CommonListViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ItemListViewWrapperDelegate;", "Lcom/qiahao/nextvideo/ui/commonlist/CommonListCellUIModel;", "Lcom/qiahao/nextvideo/ui/commonlist/DoLoadNextPageDelegate;", "<init>", "()V", "pageTitle", "", "getPageTitle", "()Ljava/lang/String;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerCommonListBinding;", "commonListViewWrapper", "Lcom/qiahao/nextvideo/ui/commonlist/CommonListViewWrapper;", "getCommonListViewWrapper", "()Lcom/qiahao/nextvideo/ui/commonlist/CommonListViewWrapper;", "setCommonListViewWrapper", "(Lcom/qiahao/nextvideo/ui/commonlist/CommonListViewWrapper;)V", "pageSize", "", "getPageSize", "()I", "setPageSize", "(I)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "viewDidLoad", "", "view", "onBackPressed", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCommonListViewController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommonListViewController.kt\ncom/qiahao/nextvideo/ui/commonlist/CommonListViewController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,55:1\n1#2:56\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class CommonListViewController extends BaseViewController implements ItemListViewWrapperDelegate<CommonListCellUIModel>, DoLoadNextPageDelegate {

    @NotNull
    public static final String TAG = "commonList";
    private ViewControllerCommonListBinding binding;
    public CommonListViewWrapper commonListViewWrapper;
    private int pageSize = 20;

    public CommonListViewController() {
        setTag(TAG);
        getPresentationStyle().setGravity(17);
    }

    @NotNull
    public CommonListViewWrapper getCommonListViewWrapper() {
        CommonListViewWrapper commonListViewWrapper = this.commonListViewWrapper;
        if (commonListViewWrapper != null) {
            return commonListViewWrapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("commonListViewWrapper");
        return null;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    @NotNull
    public abstract String getPageTitle();

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public boolean onBackPressed() {
        ViewController.dismiss$default(this, true, null, 2, null);
        return true;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerCommonListBinding inflate = ViewControllerCommonListBinding.inflate(inflater, container, false);
        this.binding = inflate;
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void setCommonListViewWrapper(@NotNull CommonListViewWrapper commonListViewWrapper) {
        Intrinsics.checkNotNullParameter(commonListViewWrapper, "<set-?>");
        this.commonListViewWrapper = commonListViewWrapper;
    }

    public void setPageSize(int i) {
        this.pageSize = i;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        HiloBaseActivity hiloBaseActivity = get_activity();
        ViewControllerCommonListBinding viewControllerCommonListBinding = null;
        if (hiloBaseActivity != null) {
            ViewControllerCommonListBinding viewControllerCommonListBinding2 = this.binding;
            if (viewControllerCommonListBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewControllerCommonListBinding2 = null;
            }
            Toolbar toolbar = viewControllerCommonListBinding2.toolbar;
            Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
            hiloBaseActivity.setStatusBarTopOrBottom(toolbar, false);
        }
        ViewControllerCommonListBinding viewControllerCommonListBinding3 = this.binding;
        if (viewControllerCommonListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerCommonListBinding3 = null;
        }
        View root = viewControllerCommonListBinding3.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        CommonListViewWrapper commonListViewWrapper = new CommonListViewWrapper(root);
        commonListViewWrapper.getRecyclerView().setHasFixedSize(true);
        commonListViewWrapper.setPageSize(getPageSize());
        commonListViewWrapper.setDelegate(this);
        commonListViewWrapper.setDoLoadNextPageDelegate(this);
        setCommonListViewWrapper(commonListViewWrapper);
        ViewControllerCommonListBinding viewControllerCommonListBinding4 = this.binding;
        if (viewControllerCommonListBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerCommonListBinding4 = null;
        }
        viewControllerCommonListBinding4.toolbarTitleTextView.setText(getPageTitle());
        ViewControllerCommonListBinding viewControllerCommonListBinding5 = this.binding;
        if (viewControllerCommonListBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerCommonListBinding = viewControllerCommonListBinding5;
        }
        viewControllerCommonListBinding.backImageView.setOnClickListener(new View.OnClickListener() { // from class: mb.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CommonListViewController.this.onBackPressed();
            }
        });
    }
}
