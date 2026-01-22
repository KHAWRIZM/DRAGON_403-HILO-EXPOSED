package com.qiahao.nextvideo.ui.setting.deleteaccount;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.DeleteAccountConditionBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ViewControllerDeleteAccount1Binding;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewControllerKt;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\u0016\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010!\u001a\u00020\u0018H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lcom/qiahao/nextvideo/ui/setting/deleteaccount/DeleteAccount1ViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Lcom/qiahao/nextvideo/ui/setting/deleteaccount/DeleteAccount2ViewControllerDelegate;", "<init>", "()V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerDeleteAccount1Binding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewControllerDeleteAccount1Binding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewControllerDeleteAccount1Binding;)V", "mDeleteAccountConditionBean", "Lcom/qiahao/nextvideo/data/model/DeleteAccountConditionBean;", "getMDeleteAccountConditionBean", "()Lcom/qiahao/nextvideo/data/model/DeleteAccountConditionBean;", "setMDeleteAccountConditionBean", "(Lcom/qiahao/nextvideo/data/model/DeleteAccountConditionBean;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "viewDidLoad", "", "view", "updateViewShow", "changeViewStatus", "imageView", "Landroid/widget/ImageView;", "status", "", "showStatusButton", "deleteAccount2ViewControllerDelegateDismiss", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDeleteAccount1ViewController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeleteAccount1ViewController.kt\ncom/qiahao/nextvideo/ui/setting/deleteaccount/DeleteAccount1ViewController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,136:1\n1#2:137\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DeleteAccount1ViewController extends BaseViewController implements DeleteAccount2ViewControllerDelegate {
    public ViewControllerDeleteAccount1Binding binding;

    @Nullable
    private DeleteAccountConditionBean mDeleteAccountConditionBean;

    public DeleteAccount1ViewController() {
        setTag("DeleteAccountViewController");
    }

    private final void updateViewShow() {
        DeleteAccountConditionBean deleteAccountConditionBean;
        DeleteAccountConditionBean deleteAccountConditionBean2;
        DeleteAccountConditionBean deleteAccountConditionBean3;
        DeleteAccountConditionBean deleteAccountConditionBean4;
        DeleteAccountConditionBean deleteAccountConditionBean5 = this.mDeleteAccountConditionBean;
        if (deleteAccountConditionBean5 == null) {
            return;
        }
        if (deleteAccountConditionBean5 != null && deleteAccountConditionBean5.getBanCondition()) {
            ImageView imageView = getBinding().condition1;
            Intrinsics.checkNotNullExpressionValue(imageView, "condition1");
            changeViewStatus(imageView, true);
        }
        DeleteAccountConditionBean deleteAccountConditionBean6 = this.mDeleteAccountConditionBean;
        if (deleteAccountConditionBean6 != null && deleteAccountConditionBean6.getDiamondCondition() && (deleteAccountConditionBean4 = this.mDeleteAccountConditionBean) != null && deleteAccountConditionBean4.getBeanCondition()) {
            ImageView imageView2 = getBinding().condition2;
            Intrinsics.checkNotNullExpressionValue(imageView2, "condition2");
            changeViewStatus(imageView2, true);
        }
        DeleteAccountConditionBean deleteAccountConditionBean7 = this.mDeleteAccountConditionBean;
        if (deleteAccountConditionBean7 != null && deleteAccountConditionBean7.getNobleCondition()) {
            ImageView imageView3 = getBinding().condition3;
            Intrinsics.checkNotNullExpressionValue(imageView3, "condition3");
            changeViewStatus(imageView3, true);
        }
        DeleteAccountConditionBean deleteAccountConditionBean8 = this.mDeleteAccountConditionBean;
        if (deleteAccountConditionBean8 != null && deleteAccountConditionBean8.getCpCondition()) {
            ImageView imageView4 = getBinding().condition4;
            Intrinsics.checkNotNullExpressionValue(imageView4, "condition4");
            changeViewStatus(imageView4, true);
        }
        DeleteAccountConditionBean deleteAccountConditionBean9 = this.mDeleteAccountConditionBean;
        if (deleteAccountConditionBean9 != null && deleteAccountConditionBean9.getBanCondition() && (deleteAccountConditionBean = this.mDeleteAccountConditionBean) != null && deleteAccountConditionBean.getDiamondCondition() && (deleteAccountConditionBean2 = this.mDeleteAccountConditionBean) != null && deleteAccountConditionBean2.getNobleCondition() && (deleteAccountConditionBean3 = this.mDeleteAccountConditionBean) != null && deleteAccountConditionBean3.getCpCondition()) {
            showStatusButton(true);
        } else {
            showStatusButton(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$5(DeleteAccount1ViewController deleteAccount1ViewController, View view) {
        DeleteAccountConditionBean deleteAccountConditionBean;
        DeleteAccountConditionBean deleteAccountConditionBean2;
        DeleteAccountConditionBean deleteAccountConditionBean3;
        DeleteAccountConditionBean deleteAccountConditionBean4;
        DeleteAccountConditionBean deleteAccountConditionBean5 = deleteAccount1ViewController.mDeleteAccountConditionBean;
        if (deleteAccountConditionBean5 != null && deleteAccountConditionBean5 != null && deleteAccountConditionBean5.getBanCondition() && (deleteAccountConditionBean = deleteAccount1ViewController.mDeleteAccountConditionBean) != null && deleteAccountConditionBean.getDiamondCondition() && (deleteAccountConditionBean2 = deleteAccount1ViewController.mDeleteAccountConditionBean) != null && deleteAccountConditionBean2.getBeanCondition() && (deleteAccountConditionBean3 = deleteAccount1ViewController.mDeleteAccountConditionBean) != null && deleteAccountConditionBean3.getNobleCondition() && (deleteAccountConditionBean4 = deleteAccount1ViewController.mDeleteAccountConditionBean) != null && deleteAccountConditionBean4.getCpCondition()) {
            DeleteAccount2ViewController deleteAccount2ViewController = new DeleteAccount2ViewController();
            deleteAccount2ViewController.setMDeleteAccount2ViewControllerDelegate(deleteAccount1ViewController);
            ViewController.present$default(deleteAccount1ViewController, deleteAccount2ViewController, true, null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit viewDidLoad$lambda$6(DeleteAccount1ViewController deleteAccount1ViewController, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        deleteAccount1ViewController.mDeleteAccountConditionBean = (DeleteAccountConditionBean) apiResponse.getData();
        deleteAccount1ViewController.updateViewShow();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit viewDidLoad$lambda$7(DeleteAccount1ViewController deleteAccount1ViewController, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context requireContext = deleteAccount1ViewController.getRequireContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = BaseViewControllerKt.getString(deleteAccount1ViewController, 2131952667, new Object[0]);
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, requireContext, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public final void changeViewStatus(@NotNull ImageView imageView, boolean status) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        if (status) {
            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.delet_account_check_small), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        } else {
            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.delet_account_uncomplete), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        }
    }

    @Override // com.qiahao.nextvideo.ui.setting.deleteaccount.DeleteAccount2ViewControllerDelegate
    public void deleteAccount2ViewControllerDelegateDismiss() {
        ViewController.dismiss$default(this, true, null, 2, null);
    }

    @NotNull
    public final ViewControllerDeleteAccount1Binding getBinding() {
        ViewControllerDeleteAccount1Binding viewControllerDeleteAccount1Binding = this.binding;
        if (viewControllerDeleteAccount1Binding != null) {
            return viewControllerDeleteAccount1Binding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @Nullable
    public final DeleteAccountConditionBean getMDeleteAccountConditionBean() {
        return this.mDeleteAccountConditionBean;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerDeleteAccount1Binding viewControllerDeleteAccount1Binding = (ViewControllerDeleteAccount1Binding) androidx.databinding.g.h(inflater, R.layout.view_controller_delete_account1, container, false);
        setBinding(viewControllerDeleteAccount1Binding);
        View root = viewControllerDeleteAccount1Binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public final void setBinding(@NotNull ViewControllerDeleteAccount1Binding viewControllerDeleteAccount1Binding) {
        Intrinsics.checkNotNullParameter(viewControllerDeleteAccount1Binding, "<set-?>");
        this.binding = viewControllerDeleteAccount1Binding;
    }

    public final void setMDeleteAccountConditionBean(@Nullable DeleteAccountConditionBean deleteAccountConditionBean) {
        this.mDeleteAccountConditionBean = deleteAccountConditionBean;
    }

    public final void showStatusButton(boolean status) {
        if (status) {
            getBinding().cancel.setVisibility(0);
            getBinding().next.setVisibility(0);
            getBinding().iUnderstand.setVisibility(8);
        } else {
            getBinding().cancel.setVisibility(8);
            getBinding().next.setVisibility(8);
            getBinding().iUnderstand.setVisibility(0);
        }
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        HiloBaseActivity requireActivity = getRequireActivity();
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        requireActivity.setStatusBarTopOrBottom(toolbar, false);
        getBinding().cancel.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.deleteaccount.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ViewController.dismiss$default(DeleteAccount1ViewController.this, true, null, 2, null);
            }
        });
        getBinding().iUnderstand.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.deleteaccount.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ViewController.dismiss$default(DeleteAccount1ViewController.this, true, null, 2, null);
            }
        });
        getBinding().backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.deleteaccount.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ViewController.dismiss$default(DeleteAccount1ViewController.this, true, null, 2, null);
            }
        });
        getBinding().next.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.deleteaccount.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeleteAccount1ViewController.viewDidLoad$lambda$5(DeleteAccount1ViewController.this, view2);
            }
        });
        TextView textView = getBinding().tipTitle;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getCode()) == null) {
            str = "";
        }
        textView.setText(BaseViewControllerKt.getString(this, 2131952545, str));
        ImageView imageView = getBinding().condition1;
        Intrinsics.checkNotNullExpressionValue(imageView, "condition1");
        changeViewStatus(imageView, false);
        ImageView imageView2 = getBinding().condition2;
        Intrinsics.checkNotNullExpressionValue(imageView2, "condition2");
        changeViewStatus(imageView2, false);
        ImageView imageView3 = getBinding().condition3;
        Intrinsics.checkNotNullExpressionValue(imageView3, "condition3");
        changeViewStatus(imageView3, false);
        ImageView imageView4 = getBinding().condition4;
        Intrinsics.checkNotNullExpressionValue(imageView4, "condition4");
        changeViewStatus(imageView4, false);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().userDeleteAccountCondition(), new Function1() { // from class: com.qiahao.nextvideo.ui.setting.deleteaccount.e
            public final Object invoke(Object obj) {
                Unit viewDidLoad$lambda$6;
                viewDidLoad$lambda$6 = DeleteAccount1ViewController.viewDidLoad$lambda$6(DeleteAccount1ViewController.this, (ApiResponse) obj);
                return viewDidLoad$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.setting.deleteaccount.f
            public final Object invoke(Object obj) {
                Unit viewDidLoad$lambda$7;
                viewDidLoad$lambda$7 = DeleteAccount1ViewController.viewDidLoad$lambda$7(DeleteAccount1ViewController.this, (Throwable) obj);
                return viewDidLoad$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }
}
