package com.qiahao.nextvideo.ui.setting.deleteaccount;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.ViewControllerDeleteAccount3Binding;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewControllerKt;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/ui/setting/deleteaccount/DeleteAccount3ViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "mLogoutFinishTime", "", "<init>", "(J)V", "getMLogoutFinishTime", "()J", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerDeleteAccount3Binding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewControllerDeleteAccount3Binding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewControllerDeleteAccount3Binding;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "viewDidLoad", "", "view", "onBackPressed", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDeleteAccount3ViewController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeleteAccount3ViewController.kt\ncom/qiahao/nextvideo/ui/setting/deleteaccount/DeleteAccount3ViewController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,56:1\n1#2:57\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DeleteAccount3ViewController extends BaseViewController {
    public ViewControllerDeleteAccount3Binding binding;
    private final long mLogoutFinishTime;

    public DeleteAccount3ViewController() {
        this(0L, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$1(View view) {
        UserStore.INSTANCE.getShared().logout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$2(DeleteAccount3ViewController deleteAccount3ViewController, View view) {
        UserStore.INSTANCE.getShared().logout();
        cf.c.c().l(new EventBusKey("logout_success", (Object) null, 2, (DefaultConstructorMarker) null));
        ViewController.dismiss$default(deleteAccount3ViewController, true, null, 2, null);
    }

    @NotNull
    public final ViewControllerDeleteAccount3Binding getBinding() {
        ViewControllerDeleteAccount3Binding viewControllerDeleteAccount3Binding = this.binding;
        if (viewControllerDeleteAccount3Binding != null) {
            return viewControllerDeleteAccount3Binding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final long getMLogoutFinishTime() {
        return this.mLogoutFinishTime;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public boolean onBackPressed() {
        UserStore.INSTANCE.getShared().logout();
        cf.c.c().l(new EventBusKey("logout_success", (Object) null, 2, (DefaultConstructorMarker) null));
        ViewController.dismiss$default(this, true, null, 2, null);
        return true;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerDeleteAccount3Binding viewControllerDeleteAccount3Binding = (ViewControllerDeleteAccount3Binding) androidx.databinding.g.h(inflater, R.layout.view_controller_delete_account3, container, false);
        setBinding(viewControllerDeleteAccount3Binding);
        View root = viewControllerDeleteAccount3Binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public final void setBinding(@NotNull ViewControllerDeleteAccount3Binding viewControllerDeleteAccount3Binding) {
        Intrinsics.checkNotNullParameter(viewControllerDeleteAccount3Binding, "<set-?>");
        this.binding = viewControllerDeleteAccount3Binding;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        HiloBaseActivity requireActivity = getRequireActivity();
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        requireActivity.setStatusBarTopOrBottom(toolbar, false);
        UserStore.INSTANCE.getShared().logout();
        getBinding().text1.setText(BaseViewControllerKt.getString(this, 2131952651, String.valueOf(DateTimeUtilityKt.getDateFormatWithLocale$default(this.mLogoutFinishTime * 1000, (String) null, 2, (Object) null))));
        getBinding().backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.deleteaccount.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeleteAccount3ViewController.viewDidLoad$lambda$1(view2);
            }
        });
        getBinding().logOut.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.deleteaccount.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeleteAccount3ViewController.viewDidLoad$lambda$2(DeleteAccount3ViewController.this, view2);
            }
        });
    }

    public DeleteAccount3ViewController(long j) {
        this.mLogoutFinishTime = j;
        setTag("DeleteAccount2ViewController");
    }

    public /* synthetic */ DeleteAccount3ViewController(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j);
    }
}
