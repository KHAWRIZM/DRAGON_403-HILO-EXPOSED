package com.qiahao.nextvideo.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.view.View;
import android.widget.Checkable;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.credentials.Credential;
import androidx.credentials.CustomCredential;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption;
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential;
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException;
import com.oudi.core.utils.FragmentUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.common.PhoneInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.BinderThirdType;
import com.qiahao.nextvideo.databinding.ActivityAccountBinding;
import com.qiahao.nextvideo.ui.login.LoginViewModel;
import com.qiahao.nextvideo.ui.login.VerificationCodeFragment;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.Window;
import com.qiahao.nextvideo.ui.setting.deleteaccount.DeleteAccount1ViewController;
import com.taobao.accs.utl.BaseMonitor;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\"\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020'H\u0007J\b\u0010(\u001a\u00020\u0015H\u0014R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/qiahao/nextvideo/ui/setting/AccountActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityAccountBinding;", "<init>", "()V", "facebookListener", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/login/LoginResult;", "getFacebookListener", "()Lcom/facebook/FacebookCallback;", "viewModel", "Lcom/qiahao/nextvideo/ui/login/LoginViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/login/LoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "callbackManager", "Lcom/facebook/CallbackManager;", "getLayoutResId", "", "onInitialize", "", "initData", "refreshView", "initView", "initThirdLogin", "deleteAccountButtonPressed", "bindFacebook", "bindGoogle", "handleSignIn", "result", "Landroidx/credentials/GetCredentialResponse;", "onActivityResult", "requestCode", com.taobao.agoo.a.a.b.JSON_ERRORCODE, "data", "Landroid/content/Intent;", "onPageEvent", "event", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "onDestroy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAccountActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AccountActivity.kt\ncom/qiahao/nextvideo/ui/setting/AccountActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,389:1\n61#2,9:390\n61#2,9:399\n61#2,9:408\n61#2,9:417\n61#2,9:426\n*S KotlinDebug\n*F\n+ 1 AccountActivity.kt\ncom/qiahao/nextvideo/ui/setting/AccountActivity\n*L\n173#1:390,9\n177#1:399,9\n197#1:408,9\n216#1:417,9\n235#1:426,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AccountActivity extends HiloBaseBindingActivity<ActivityAccountBinding> {
    public static final int GOOGLE_RESULT = 100;

    @Nullable
    private CallbackManager callbackManager;

    @NotNull
    private final FacebookCallback<LoginResult> facebookListener = new FacebookCallback<LoginResult>() { // from class: com.qiahao.nextvideo.ui.setting.AccountActivity$facebookListener$1
        public void onCancel() {
            HiloBaseActivity.dismissProgressDialog$default(AccountActivity.this, false, null, 3, null);
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, AccountActivity.this, ResourcesKtxKt.getStringById(this, 2131952171), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }

        public void onError(FacebookException error) {
            Intrinsics.checkNotNullParameter(error, BaseMonitor.COUNT_ERROR);
            HiloBaseActivity.dismissProgressDialog$default(AccountActivity.this, false, null, 3, null);
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, AccountActivity.this, ResourcesKtxKt.getStringById(this, 2131952667), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }

        public void onSuccess(LoginResult result) {
            LoginViewModel viewModel;
            Intrinsics.checkNotNullParameter(result, "result");
            HiloBaseActivity.dismissProgressDialog$default(AccountActivity.this, false, null, 3, null);
            viewModel = AccountActivity.this.getViewModel();
            viewModel.binderOrUnBinderThird(1, 3, result.getAccessToken().getUserId(), result.getAccessToken().getToken());
        }
    };

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.setting.e
        public final Object invoke() {
            LoginViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = AccountActivity.viewModel_delegate$lambda$0(AccountActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void bindFacebook() {
        if (FacebookSdk.isInitialized()) {
            HiloBaseActivity.showProgressDialog$default((HiloBaseActivity) this, (String) null, false, (Function0) null, 7, (Object) null);
            LoginManager.Companion.getInstance().logInWithReadPermissions(this, CollectionsKt.listOf(new String[]{"email", "public_profile", "user_friends"}));
        } else {
            Toast error$default = HiloToasty.Companion.error$default(HiloToasty.Companion, this, ResourcesKtxKt.getStringById(this, 2131952667), false, 4, (Object) null);
            if (error$default != null) {
                error$default.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void bindGoogle() {
        Toast error$default;
        int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
        if (isGooglePlayServicesAvailable == 0) {
            GetCredentialRequest build = new GetCredentialRequest.Builder().addCredentialOption(new GetSignInWithGoogleOption.Builder(ResourcesKtxKt.getStringById(this, 2131954063)).build()).build();
            new CancellationSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: com.qiahao.nextvideo.ui.setting.d
                @Override // android.os.CancellationSignal.OnCancelListener
                public final void onCancel() {
                    AccountActivity.bindGoogle$lambda$11();
                }
            });
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new AccountActivity$bindGoogle$2(this, build, null), 3, (Object) null);
            return;
        }
        if (isGooglePlayServicesAvailable != 1) {
            if (isGooglePlayServicesAvailable != 2) {
                if (isGooglePlayServicesAvailable != 3) {
                    if (isGooglePlayServicesAvailable != 7) {
                        if (isGooglePlayServicesAvailable != 9) {
                            if (isGooglePlayServicesAvailable == 18 && (error$default = HiloToasty.Companion.error$default(HiloToasty.Companion, this, ResourcesKtxKt.getStringById(this, 2131952931), false, 4, (Object) null)) != null) {
                                error$default.show();
                                return;
                            }
                            return;
                        }
                        Toast error$default2 = HiloToasty.Companion.error$default(HiloToasty.Companion, this, ResourcesKtxKt.getStringById(this, 2131954260), false, 4, (Object) null);
                        if (error$default2 != null) {
                            error$default2.show();
                            return;
                        }
                        return;
                    }
                    Toast error$default3 = HiloToasty.Companion.error$default(HiloToasty.Companion, this, ResourcesKtxKt.getStringById(this, 2131954249), false, 4, (Object) null);
                    if (error$default3 != null) {
                        error$default3.show();
                        return;
                    }
                    return;
                }
                Toast error$default4 = HiloToasty.Companion.error$default(HiloToasty.Companion, this, ResourcesKtxKt.getStringById(this, 2131954246), false, 4, (Object) null);
                if (error$default4 != null) {
                    error$default4.show();
                    return;
                }
                return;
            }
            Toast error$default5 = HiloToasty.Companion.error$default(HiloToasty.Companion, this, ResourcesKtxKt.getStringById(this, 2131954247), false, 4, (Object) null);
            if (error$default5 != null) {
                error$default5.show();
                return;
            }
            return;
        }
        Toast error$default6 = HiloToasty.Companion.error$default(HiloToasty.Companion, this, ResourcesKtxKt.getStringById(this, 2131952932), false, 4, (Object) null);
        if (error$default6 != null) {
            error$default6.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindGoogle$lambda$11() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteAccountButtonPressed() {
        Window controllerWindowNotNull = getControllerWindowNotNull();
        controllerWindowNotNull.setDismissControllerHost(true);
        controllerWindowNotNull.setRootViewController(new DeleteAccount1ViewController());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoginViewModel getViewModel() {
        return (LoginViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void handleSignIn(GetCredentialResponse result) {
        Credential credential = result.getCredential();
        if (credential instanceof CustomCredential) {
            if (Intrinsics.areEqual(credential.getType(), "com.google.android.libraries.identity.googleid.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL")) {
                try {
                    GoogleIdTokenCredential createFrom = GoogleIdTokenCredential.Companion.createFrom(credential.getData());
                    getViewModel().binderOrUnBinderThird(1, 2, createFrom.getId(), createFrom.getIdToken());
                    Unit unit = Unit.INSTANCE;
                    return;
                } catch (GoogleIdTokenParsingException e) {
                    HiloToasty.Companion companion = HiloToasty.Companion;
                    String localizedMessage = e.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = "Received an invalid google id token response";
                    }
                    Toast normal$default = HiloToasty.Companion.normal$default(companion, this, localizedMessage, false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                        Unit unit2 = Unit.INSTANCE;
                        return;
                    }
                    return;
                }
            }
            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, this, "Unexpected type of credential", false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
                return;
            }
            return;
        }
        Toast normal$default3 = HiloToasty.Companion.normal$default(HiloToasty.Companion, this, "Unexpected type of credential", false, 4, (Object) null);
        if (normal$default3 != null) {
            normal$default3.show();
        }
    }

    private final void initData() {
        getViewModel().getBinderOrUnBinderThird().observe(this, new AccountActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.setting.b
            public final Object invoke(Object obj) {
                Unit initData$lambda$1;
                initData$lambda$1 = AccountActivity.initData$lambda$1(AccountActivity.this, (Boolean) obj);
                return initData$lambda$1;
            }
        }));
        getViewModel().getError().observe(this, new AccountActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.setting.c
            public final Object invoke(Object obj) {
                Unit initData$lambda$2;
                initData$lambda$2 = AccountActivity.initData$lambda$2(AccountActivity.this, (Throwable) obj);
                return initData$lambda$2;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$1(AccountActivity accountActivity, Boolean bool) {
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            UserStore.INSTANCE.getShared().bindOrUnBindThirdSuccess(accountActivity.getViewModel().getThirdType(), true);
            accountActivity.refreshView();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$2(AccountActivity accountActivity, Throwable th) {
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            if (hiloException.getCode() == 9000) {
                TipDialog tipDialog = new TipDialog(accountActivity);
                String errorMessage = hiloException.getErrorMessage();
                if (errorMessage == null) {
                    errorMessage = ResourcesKtxKt.getStringById(accountActivity, 2131952667);
                }
                tipDialog.setTipContent(errorMessage).show();
            } else {
                HiloToasty.Companion companion = HiloToasty.Companion;
                String errorMessage2 = hiloException.getErrorMessage();
                if (errorMessage2 == null) {
                    errorMessage2 = ResourcesKtxKt.getStringById(accountActivity, 2131952667);
                }
                Toast normal$default = HiloToasty.Companion.normal$default(companion, accountActivity, errorMessage2, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            }
        }
        return Unit.INSTANCE;
    }

    private final void initThirdLogin() {
        if (FacebookSdk.isInitialized()) {
            this.callbackManager = CallbackManager.Factory.create();
            LoginManager.Companion.getInstance().registerCallback(this.callbackManager, this.facebookListener);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        View view = ((ActivityAccountBinding) getBinding()).titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.setting.a
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$4;
                initView$lambda$4 = AccountActivity.initView$lambda$4(AccountActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$4;
            }
        });
        ((ActivityAccountBinding) getBinding()).titleBar.title.setText(ResourcesKtxKt.getStringById(this, 2131951938));
        ((ActivityAccountBinding) getBinding()).titleBar.getRoot().setBackground(androidx.core.content.a.getDrawable(this, 2131101214));
        final AppCompatImageView appCompatImageView = ((ActivityAccountBinding) getBinding()).titleBar.backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.AccountActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.finish();
                }
            }
        });
        final View root = ((ActivityAccountBinding) getBinding()).phone.getRoot();
        root.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.AccountActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActivityAccountBinding binding;
                ArrayList<Integer> arrayList;
                String str;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                    binding = this.getBinding();
                    binding.loginFrameLayout.setVisibility(0);
                    VerificationCodeFragment verificationCodeFragment = new VerificationCodeFragment();
                    BinderThirdType binderThirdType = BinderThirdType.INSTANCE;
                    User user = UserStore.INSTANCE.getShared().getUser();
                    if (user != null) {
                        arrayList = user.getThirdList();
                    } else {
                        arrayList = null;
                    }
                    if (binderThirdType.isBinderPhone(arrayList)) {
                        str = VerificationCodeFragment.TYPE_CHECK_OLD_MOBILE;
                    } else {
                        str = VerificationCodeFragment.TYPE_BIND;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("type", str);
                    verificationCodeFragment.setArguments(bundle);
                    FragmentUtils.INSTANCE.addFragmentBackStack(this.getSupportFragmentManager(), R.id.loginFrameLayout, verificationCodeFragment, str);
                }
            }
        });
        final View root2 = ((ActivityAccountBinding) getBinding()).facebook.getRoot();
        root2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.AccountActivity$initView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ArrayList<Integer> arrayList;
                ActivityAccountBinding binding;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root2) > j || (root2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root2, currentTimeMillis);
                    BinderThirdType binderThirdType = BinderThirdType.INSTANCE;
                    User user = UserStore.INSTANCE.getShared().getUser();
                    if (user != null) {
                        arrayList = user.getThirdList();
                    } else {
                        arrayList = null;
                    }
                    if (binderThirdType.isBinderFacebook(arrayList)) {
                        binding = this.getBinding();
                        binding.loginFrameLayout.setVisibility(0);
                        BinderFragment binderFragment = new BinderFragment();
                        Bundle bundle = new Bundle();
                        bundle.putInt(BinderFragment.BINDING_TYPE, 3);
                        binderFragment.setArguments(bundle);
                        FragmentUtils.INSTANCE.addFragmentBackStack(this.getSupportFragmentManager(), R.id.loginFrameLayout, binderFragment, "BinderFragment");
                        return;
                    }
                    this.bindFacebook();
                }
            }
        });
        final View root3 = ((ActivityAccountBinding) getBinding()).google.getRoot();
        root3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.AccountActivity$initView$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ArrayList<Integer> arrayList;
                ActivityAccountBinding binding;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root3) > j || (root3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root3, currentTimeMillis);
                    BinderThirdType binderThirdType = BinderThirdType.INSTANCE;
                    User user = UserStore.INSTANCE.getShared().getUser();
                    if (user != null) {
                        arrayList = user.getThirdList();
                    } else {
                        arrayList = null;
                    }
                    if (binderThirdType.isBinderGoogle(arrayList)) {
                        binding = this.getBinding();
                        binding.loginFrameLayout.setVisibility(0);
                        BinderFragment binderFragment = new BinderFragment();
                        Bundle bundle = new Bundle();
                        bundle.putInt(BinderFragment.BINDING_TYPE, 2);
                        binderFragment.setArguments(bundle);
                        FragmentUtils.INSTANCE.addFragmentBackStack(this.getSupportFragmentManager(), R.id.loginFrameLayout, binderFragment, "BinderFragment");
                        return;
                    }
                    this.bindGoogle();
                }
            }
        });
        final View root4 = ((ActivityAccountBinding) getBinding()).deleteAccount.getRoot();
        root4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.AccountActivity$initView$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root4) > j || (root4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root4, currentTimeMillis);
                    this.deleteAccountButtonPressed();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$4(AccountActivity accountActivity, int i, int i2) {
        accountActivity.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void refreshView() {
        String str;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            BinderThirdType binderThirdType = BinderThirdType.INSTANCE;
            if (binderThirdType.isBinderPhone(user.getThirdList())) {
                ((ActivityAccountBinding) getBinding()).phone.startImage.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.account_phone_binder));
                AppCompatTextView appCompatTextView = ((ActivityAccountBinding) getBinding()).phone.subTitle;
                PhoneInfo phoneInfo = user.getPhoneInfo();
                if (phoneInfo == null || (str = phoneInfo.getPhone()) == null) {
                    str = "";
                }
                appCompatTextView.setText(str);
            } else {
                ((ActivityAccountBinding) getBinding()).phone.startImage.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.account_phone));
                ((ActivityAccountBinding) getBinding()).phone.subTitle.setText("");
            }
            if (binderThirdType.isBinderFacebook(user.getThirdList())) {
                ((ActivityAccountBinding) getBinding()).facebook.startImage.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.account_facebook_binder));
                ((ActivityAccountBinding) getBinding()).facebook.subTitle.setText(ResourcesKtxKt.getStringById(this, 2131952142));
            } else {
                ((ActivityAccountBinding) getBinding()).facebook.startImage.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.account_facebook));
                ((ActivityAccountBinding) getBinding()).facebook.subTitle.setText("");
            }
            if (binderThirdType.isBinderGoogle(user.getThirdList())) {
                ((ActivityAccountBinding) getBinding()).google.startImage.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.account_google_binder));
                ((ActivityAccountBinding) getBinding()).google.subTitle.setText(ResourcesKtxKt.getStringById(this, 2131952142));
            } else {
                ((ActivityAccountBinding) getBinding()).google.startImage.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.account_google));
                ((ActivityAccountBinding) getBinding()).google.subTitle.setText("");
            }
        }
        ((ActivityAccountBinding) getBinding()).deleteAccount.startImage.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.account_delect));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LoginViewModel viewModel_delegate$lambda$0(AccountActivity accountActivity) {
        return new ViewModelProvider(accountActivity).get(LoginViewModel.class);
    }

    @NotNull
    public final FacebookCallback<LoginResult> getFacebookListener() {
        return this.facebookListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_account;
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        CallbackManager callbackManager = this.callbackManager;
        if (callbackManager != null) {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
        super/*com.oudi.core.component.SuperActivity*/.onActivityResult(requestCode, resultCode, data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        CallbackManager callbackManager = this.callbackManager;
        if (callbackManager != null) {
            LoginManager.Companion.getInstance().unregisterCallback(callbackManager);
        }
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
        initThirdLogin();
        refreshView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onPageEvent(@NotNull EventBusKey event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getType(), "refresh_account")) {
            refreshView();
        } else if (Intrinsics.areEqual(event.getType(), "logout_success")) {
            finish();
        }
    }
}
