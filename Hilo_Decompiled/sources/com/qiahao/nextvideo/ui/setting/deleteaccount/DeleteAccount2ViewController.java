package com.qiahao.nextvideo.ui.setting.deleteaccount;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.data.model.DeleteAccountSuccessBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ViewControllerDeleteAccount2Binding;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmPreloadModel;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewController;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewControllerKt;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\u0018\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u001eH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/ui/setting/deleteaccount/DeleteAccount2ViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Lcom/qiahao/nextvideo/ui/edition/country/confirmtip/ConfirmTipViewControllerDelegate;", "<init>", "()V", "mDeleteAccount2ViewControllerDelegate", "Lcom/qiahao/nextvideo/ui/setting/deleteaccount/DeleteAccount2ViewControllerDelegate;", "getMDeleteAccount2ViewControllerDelegate", "()Lcom/qiahao/nextvideo/ui/setting/deleteaccount/DeleteAccount2ViewControllerDelegate;", "setMDeleteAccount2ViewControllerDelegate", "(Lcom/qiahao/nextvideo/ui/setting/deleteaccount/DeleteAccount2ViewControllerDelegate;)V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerDeleteAccount2Binding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewControllerDeleteAccount2Binding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewControllerDeleteAccount2Binding;)V", "mCheckAgreement", "", "getMCheckAgreement", "()Z", "setMCheckAgreement", "(Z)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "viewDidLoad", "", "view", "confirmTipViewControllerDidConfirm", "fromCode", "", "extra", "Landroid/os/Bundle;", "confirmTipViewControllerDidCancel", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDeleteAccount2ViewController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeleteAccount2ViewController.kt\ncom/qiahao/nextvideo/ui/setting/deleteaccount/DeleteAccount2ViewController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,107:1\n1#2:108\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DeleteAccount2ViewController extends BaseViewController implements ConfirmTipViewControllerDelegate {
    public ViewControllerDeleteAccount2Binding binding;
    private boolean mCheckAgreement;

    @Nullable
    private DeleteAccount2ViewControllerDelegate mDeleteAccount2ViewControllerDelegate;

    public DeleteAccount2ViewController() {
        setTag("DeleteAccount2ViewController");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmTipViewControllerDidConfirm$lambda$10(DeleteAccount2ViewController deleteAccount2ViewController, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context requireContext = deleteAccount2ViewController.getRequireContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = BaseViewControllerKt.getString(deleteAccount2ViewController, 2131952667, new Object[0]);
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, requireContext, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmTipViewControllerDidConfirm$lambda$9(DeleteAccount2ViewController deleteAccount2ViewController, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        DeleteAccountSuccessBean deleteAccountSuccessBean = (DeleteAccountSuccessBean) apiResponse.getData();
        if (deleteAccountSuccessBean != null) {
            ViewController.present$default(deleteAccount2ViewController, new DeleteAccount3ViewController(deleteAccountSuccessBean.getLogoutFinishTime()), true, null, 4, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$2(final DeleteAccount2ViewController deleteAccount2ViewController, View view) {
        deleteAccount2ViewController.dismiss(true, new Function0() { // from class: com.qiahao.nextvideo.ui.setting.deleteaccount.k
            public final Object invoke() {
                Unit viewDidLoad$lambda$2$lambda$1;
                viewDidLoad$lambda$2$lambda$1 = DeleteAccount2ViewController.viewDidLoad$lambda$2$lambda$1(DeleteAccount2ViewController.this);
                return viewDidLoad$lambda$2$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit viewDidLoad$lambda$2$lambda$1(DeleteAccount2ViewController deleteAccount2ViewController) {
        DeleteAccount2ViewControllerDelegate deleteAccount2ViewControllerDelegate = deleteAccount2ViewController.mDeleteAccount2ViewControllerDelegate;
        if (deleteAccount2ViewControllerDelegate != null) {
            deleteAccount2ViewControllerDelegate.deleteAccount2ViewControllerDelegateDismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$4(final DeleteAccount2ViewController deleteAccount2ViewController, View view) {
        deleteAccount2ViewController.dismiss(true, new Function0() { // from class: com.qiahao.nextvideo.ui.setting.deleteaccount.n
            public final Object invoke() {
                Unit viewDidLoad$lambda$4$lambda$3;
                viewDidLoad$lambda$4$lambda$3 = DeleteAccount2ViewController.viewDidLoad$lambda$4$lambda$3(DeleteAccount2ViewController.this);
                return viewDidLoad$lambda$4$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit viewDidLoad$lambda$4$lambda$3(DeleteAccount2ViewController deleteAccount2ViewController) {
        DeleteAccount2ViewControllerDelegate deleteAccount2ViewControllerDelegate = deleteAccount2ViewController.mDeleteAccount2ViewControllerDelegate;
        if (deleteAccount2ViewControllerDelegate != null) {
            deleteAccount2ViewControllerDelegate.deleteAccount2ViewControllerDelegateDismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$5(DeleteAccount2ViewController deleteAccount2ViewController, View view) {
        if (deleteAccount2ViewController.getBinding().check.isSelected()) {
            deleteAccount2ViewController.mCheckAgreement = false;
            deleteAccount2ViewController.getBinding().check.setSelected(false);
        } else {
            deleteAccount2ViewController.mCheckAgreement = true;
            deleteAccount2ViewController.getBinding().check.setSelected(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$7(DeleteAccount2ViewController deleteAccount2ViewController, View view) {
        if (FastClickOneUtils.INSTANCE.isFastClick()) {
            if (deleteAccount2ViewController.mCheckAgreement) {
                ConfirmTipViewController confirmTipViewController = new ConfirmTipViewController(ConfirmPreloadModel.INSTANCE.init(BaseViewControllerKt.getString(deleteAccount2ViewController, 2131954501, new Object[0]), BaseViewControllerKt.getString(deleteAccount2ViewController, 2131953574, new Object[0]), BaseViewControllerKt.getString(deleteAccount2ViewController, 2131952171, new Object[0])), null, 2, null);
                confirmTipViewController.setDelegate(deleteAccount2ViewController);
                ViewController.present$default(deleteAccount2ViewController, confirmTipViewController, true, null, 4, null);
            } else {
                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, deleteAccount2ViewController.getRequireContext(), BaseViewControllerKt.getString(deleteAccount2ViewController, 2131953684, new Object[0]), false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            }
        }
    }

    @Override // com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate
    public void confirmTipViewControllerDidCancel() {
        ViewController.dismiss$default(this, true, null, 2, null);
    }

    @Override // com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate
    public void confirmTipViewControllerDidConfirm(int fromCode, @NotNull Bundle extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().userDeleteAccount(), new Function1() { // from class: com.qiahao.nextvideo.ui.setting.deleteaccount.l
            public final Object invoke(Object obj) {
                Unit confirmTipViewControllerDidConfirm$lambda$9;
                confirmTipViewControllerDidConfirm$lambda$9 = DeleteAccount2ViewController.confirmTipViewControllerDidConfirm$lambda$9(DeleteAccount2ViewController.this, (ApiResponse) obj);
                return confirmTipViewControllerDidConfirm$lambda$9;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.setting.deleteaccount.m
            public final Object invoke(Object obj) {
                Unit confirmTipViewControllerDidConfirm$lambda$10;
                confirmTipViewControllerDidConfirm$lambda$10 = DeleteAccount2ViewController.confirmTipViewControllerDidConfirm$lambda$10(DeleteAccount2ViewController.this, (Throwable) obj);
                return confirmTipViewControllerDidConfirm$lambda$10;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }

    @NotNull
    public final ViewControllerDeleteAccount2Binding getBinding() {
        ViewControllerDeleteAccount2Binding viewControllerDeleteAccount2Binding = this.binding;
        if (viewControllerDeleteAccount2Binding != null) {
            return viewControllerDeleteAccount2Binding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final boolean getMCheckAgreement() {
        return this.mCheckAgreement;
    }

    @Nullable
    public final DeleteAccount2ViewControllerDelegate getMDeleteAccount2ViewControllerDelegate() {
        return this.mDeleteAccount2ViewControllerDelegate;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerDeleteAccount2Binding viewControllerDeleteAccount2Binding = (ViewControllerDeleteAccount2Binding) androidx.databinding.g.h(inflater, R.layout.view_controller_delete_account2, container, false);
        setBinding(viewControllerDeleteAccount2Binding);
        View root = viewControllerDeleteAccount2Binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public final void setBinding(@NotNull ViewControllerDeleteAccount2Binding viewControllerDeleteAccount2Binding) {
        Intrinsics.checkNotNullParameter(viewControllerDeleteAccount2Binding, "<set-?>");
        this.binding = viewControllerDeleteAccount2Binding;
    }

    public final void setMCheckAgreement(boolean z) {
        this.mCheckAgreement = z;
    }

    public final void setMDeleteAccount2ViewControllerDelegate(@Nullable DeleteAccount2ViewControllerDelegate deleteAccount2ViewControllerDelegate) {
        this.mDeleteAccount2ViewControllerDelegate = deleteAccount2ViewControllerDelegate;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        HiloBaseActivity requireActivity = getRequireActivity();
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        requireActivity.setStatusBarTopOrBottom(toolbar, false);
        getBinding().check.setSelected(this.mCheckAgreement);
        getBinding().cancel.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.deleteaccount.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeleteAccount2ViewController.viewDidLoad$lambda$2(DeleteAccount2ViewController.this, view2);
            }
        });
        getBinding().backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.deleteaccount.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeleteAccount2ViewController.viewDidLoad$lambda$4(DeleteAccount2ViewController.this, view2);
            }
        });
        getBinding().checkAgreement.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.deleteaccount.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeleteAccount2ViewController.viewDidLoad$lambda$5(DeleteAccount2ViewController.this, view2);
            }
        });
        getBinding().deleteMyAccount.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.deleteaccount.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeleteAccount2ViewController.viewDidLoad$lambda$7(DeleteAccount2ViewController.this, view2);
            }
        });
    }
}
