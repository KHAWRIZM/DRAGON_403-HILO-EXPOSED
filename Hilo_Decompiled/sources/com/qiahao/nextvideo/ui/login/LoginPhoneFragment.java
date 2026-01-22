package com.qiahao.nextvideo.ui.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.oudi.core.utils.FragmentUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserObjectEventType;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.UserResponse;
import com.qiahao.nextvideo.databinding.FragmentLoginPhoneBinding;
import com.qiahao.nextvideo.databinding.IncludeTitleBinding;
import com.qiahao.nextvideo.utilities.data_utils.CountryUtils;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0007J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u000eR\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/login/LoginPhoneFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentLoginPhoneBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/ui/login/LoginViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/login/LoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getLayoutResId", "", "onInitialize", "", "refreshView", "onCountryEvent", "event", "Lcom/qiahao/base_common/model/common/Country;", "checkButtonIsClick", "", "login", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLoginPhoneFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoginPhoneFragment.kt\ncom/qiahao/nextvideo/ui/login/LoginPhoneFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,206:1\n1#2:207\n61#3,9:208\n61#3,9:217\n61#3,9:226\n61#3,9:235\n61#3,9:244\n61#3,9:253\n*S KotlinDebug\n*F\n+ 1 LoginPhoneFragment.kt\ncom/qiahao/nextvideo/ui/login/LoginPhoneFragment\n*L\n61#1:208,9\n64#1:217,9\n65#1:226,9\n76#1:235,9\n91#1:244,9\n126#1:253,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LoginPhoneFragment extends BaseBindingFragment<FragmentLoginPhoneBinding> {

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.login.f
        public final Object invoke() {
            LoginViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = LoginPhoneFragment.viewModel_delegate$lambda$0(LoginPhoneFragment.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkButtonIsClick() {
        Editable editable;
        boolean z;
        FragmentLoginPhoneBinding fragmentLoginPhoneBinding;
        TextView textView;
        Editable editable2;
        AppCompatEditText appCompatEditText;
        AppCompatEditText appCompatEditText2;
        AppCompatEditText appCompatEditText3;
        FragmentLoginPhoneBinding fragmentLoginPhoneBinding2 = (FragmentLoginPhoneBinding) getBinding();
        Editable editable3 = null;
        if (fragmentLoginPhoneBinding2 != null && (appCompatEditText3 = fragmentLoginPhoneBinding2.phoneNumber) != null) {
            editable = appCompatEditText3.getText();
        } else {
            editable = null;
        }
        if (!TextUtils.isEmpty(editable)) {
            FragmentLoginPhoneBinding fragmentLoginPhoneBinding3 = (FragmentLoginPhoneBinding) getBinding();
            if (fragmentLoginPhoneBinding3 != null && (appCompatEditText2 = fragmentLoginPhoneBinding3.password) != null) {
                editable2 = appCompatEditText2.getText();
            } else {
                editable2 = null;
            }
            if (!TextUtils.isEmpty(editable2)) {
                FragmentLoginPhoneBinding fragmentLoginPhoneBinding4 = (FragmentLoginPhoneBinding) getBinding();
                if (fragmentLoginPhoneBinding4 != null && (appCompatEditText = fragmentLoginPhoneBinding4.password) != null) {
                    editable3 = appCompatEditText.getText();
                }
                if (String.valueOf(editable3).length() >= 6) {
                    z = true;
                    fragmentLoginPhoneBinding = (FragmentLoginPhoneBinding) getBinding();
                    if (fragmentLoginPhoneBinding != null && (textView = fragmentLoginPhoneBinding.confirmButton) != null) {
                        textView.setEnabled(z);
                    }
                    return z;
                }
            }
        }
        z = false;
        fragmentLoginPhoneBinding = (FragmentLoginPhoneBinding) getBinding();
        if (fragmentLoginPhoneBinding != null) {
            textView.setEnabled(z);
        }
        return z;
    }

    private final LoginViewModel getViewModel() {
        return (LoginViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$12(UserResponse userResponse) {
        if (userResponse != null) {
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "keyRongCloudToken", userResponse.getRongCloudToken(), (String) null, 4, (Object) null);
            UserStore.INSTANCE.getShared().refreshUserInfo(userResponse.getUser(), userResponse.getToken(), UserObjectEventType.LOGIN, false);
            cf.c.c().l(new EventBusKey("login_phone_success", (Object) null, 2, (DefaultConstructorMarker) null));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$14(LoginPhoneFragment loginPhoneFragment, Throwable th) {
        String str;
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            int code = hiloException.getCode();
            if (code != 9000) {
                if (code != 26004) {
                    if (code != 26041 && code != 26047) {
                        HiloToasty.Companion companion = HiloToasty.Companion;
                        Context context = loginPhoneFragment.getContext();
                        String errorMessage = hiloException.getErrorMessage();
                        if (errorMessage == null) {
                            str = ResourcesKtxKt.getStringById(loginPhoneFragment, 2131952667);
                        } else {
                            str = errorMessage;
                        }
                        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                        }
                    } else {
                        Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, loginPhoneFragment.getContext(), ResourcesKtxKt.getStringById(loginPhoneFragment, 2131953627), false, 4, (Object) null);
                        if (normal$default2 != null) {
                            normal$default2.show();
                        }
                    }
                } else {
                    Toast normal$default3 = HiloToasty.Companion.normal$default(HiloToasty.Companion, loginPhoneFragment.getContext(), ResourcesKtxKt.getStringById(loginPhoneFragment, 2131953625), false, 4, (Object) null);
                    if (normal$default3 != null) {
                        normal$default3.show();
                    }
                }
            } else {
                Context context2 = loginPhoneFragment.getContext();
                if (context2 != null) {
                    TipDialog tipDialog = new TipDialog(context2);
                    String errorMessage2 = hiloException.getErrorMessage();
                    if (errorMessage2 == null) {
                        errorMessage2 = ResourcesKtxKt.getStringById(loginPhoneFragment, 2131952667);
                    }
                    tipDialog.setTipContent(errorMessage2).show();
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$2(LoginPhoneFragment loginPhoneFragment, int i, int i2) {
        IncludeTitleBinding includeTitleBinding;
        View view;
        FragmentLoginPhoneBinding fragmentLoginPhoneBinding = (FragmentLoginPhoneBinding) loginPhoneFragment.getBinding();
        if (fragmentLoginPhoneBinding != null && (includeTitleBinding = fragmentLoginPhoneBinding.titleBar) != null && (view = includeTitleBinding.bar) != null) {
            view.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LoginViewModel viewModel_delegate$lambda$0(LoginPhoneFragment loginPhoneFragment) {
        return new ViewModelProvider(loginPhoneFragment).get(LoginViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_login_phone;
    }

    public final void login() {
        String str;
        Editable editable;
        AppCompatEditText appCompatEditText;
        AppCompatEditText appCompatEditText2;
        LoginViewModel viewModel = getViewModel();
        Country selectCountry = getViewModel().getSelectCountry();
        if (selectCountry == null || (str = selectCountry.getName()) == null) {
            str = "";
        }
        FragmentLoginPhoneBinding fragmentLoginPhoneBinding = (FragmentLoginPhoneBinding) getBinding();
        Editable editable2 = null;
        if (fragmentLoginPhoneBinding != null && (appCompatEditText2 = fragmentLoginPhoneBinding.phoneNumber) != null) {
            editable = appCompatEditText2.getText();
        } else {
            editable = null;
        }
        String valueOf = String.valueOf(editable);
        FragmentLoginPhoneBinding fragmentLoginPhoneBinding2 = (FragmentLoginPhoneBinding) getBinding();
        if (fragmentLoginPhoneBinding2 != null && (appCompatEditText = fragmentLoginPhoneBinding2.password) != null) {
            editable2 = appCompatEditText.getText();
        }
        viewModel.loginPhone(str, valueOf, String.valueOf(editable2));
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onCountryEvent(@NotNull Country event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getCountryType(), SelectCountryFragment.TYPE_LOGIN)) {
            getViewModel().setSelectCountry(event);
            refreshView();
        }
    }

    public void onInitialize() {
        Country country;
        final TextView textView;
        AppCompatEditText appCompatEditText;
        AppCompatEditText appCompatEditText2;
        final TextView textView2;
        final ImageView imageView;
        final LinearLayout linearLayout;
        final View root;
        IncludeTitleBinding includeTitleBinding;
        final AppCompatImageView appCompatImageView;
        IncludeTitleBinding includeTitleBinding2;
        AppCompatTextView appCompatTextView;
        IncludeTitleBinding includeTitleBinding3;
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        LoginViewModel viewModel = getViewModel();
        Context context = getContext();
        View view = null;
        if (context != null) {
            country = CountryUtils.INSTANCE.getDefaultCountryISO(context);
        } else {
            country = null;
        }
        viewModel.setSelectCountry(country);
        FragmentLoginPhoneBinding fragmentLoginPhoneBinding = (FragmentLoginPhoneBinding) getBinding();
        if (fragmentLoginPhoneBinding != null && (includeTitleBinding3 = fragmentLoginPhoneBinding.titleBar) != null) {
            view = includeTitleBinding3.bar;
        }
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.login.g
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$2;
                onInitialize$lambda$2 = LoginPhoneFragment.onInitialize$lambda$2(LoginPhoneFragment.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$2;
            }
        });
        FragmentLoginPhoneBinding fragmentLoginPhoneBinding2 = (FragmentLoginPhoneBinding) getBinding();
        if (fragmentLoginPhoneBinding2 != null && (includeTitleBinding2 = fragmentLoginPhoneBinding2.titleBar) != null && (appCompatTextView = includeTitleBinding2.title) != null) {
            appCompatTextView.setText(ResourcesKtxKt.getStringById(this, 2131953249));
        }
        FragmentLoginPhoneBinding fragmentLoginPhoneBinding3 = (FragmentLoginPhoneBinding) getBinding();
        final long j = 800;
        if (fragmentLoginPhoneBinding3 != null && (includeTitleBinding = fragmentLoginPhoneBinding3.titleBar) != null && (appCompatImageView = includeTitleBinding.backImageView) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.LoginPhoneFragment$onInitialize$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                        AppCompatImageView appCompatImageView2 = appCompatImageView;
                        FragmentActivity activity = this.getActivity();
                        if (activity != null) {
                            activity.finish();
                        }
                    }
                }
            });
        }
        FragmentLoginPhoneBinding fragmentLoginPhoneBinding4 = (FragmentLoginPhoneBinding) getBinding();
        if (fragmentLoginPhoneBinding4 != null && (root = fragmentLoginPhoneBinding4.getRoot()) != null) {
            root.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.LoginPhoneFragment$onInitialize$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                    }
                }
            });
        }
        FragmentLoginPhoneBinding fragmentLoginPhoneBinding5 = (FragmentLoginPhoneBinding) getBinding();
        if (fragmentLoginPhoneBinding5 != null && (linearLayout = fragmentLoginPhoneBinding5.selectCountryLayout) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.LoginPhoneFragment$onInitialize$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout) > j || (linearLayout instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(linearLayout, currentTimeMillis);
                        FragmentUtils.INSTANCE.showHideFragmentBackStack(this.requireActivity().getSupportFragmentManager(), R.id.loginFrameLayout, this, SelectCountryFragment.Companion.createFragment(SelectCountryFragment.TYPE_LOGIN), "SelectCountryFragment");
                    }
                }
            });
        }
        FragmentLoginPhoneBinding fragmentLoginPhoneBinding6 = (FragmentLoginPhoneBinding) getBinding();
        if (fragmentLoginPhoneBinding6 != null && (imageView = fragmentLoginPhoneBinding6.viewPassword) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.LoginPhoneFragment$onInitialize$$inlined$singleClick$default$4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AppCompatEditText appCompatEditText3;
                    AppCompatEditText appCompatEditText4;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                        ImageView imageView2 = (ImageView) imageView;
                        Drawable drawable = null;
                        if (Intrinsics.areEqual(imageView2.getTag(), 1)) {
                            imageView2.setTag(2);
                            Context context2 = this.getContext();
                            if (context2 != null) {
                                drawable = androidx.core.content.a.getDrawable(context2, R.drawable.login_icon_display);
                            }
                            imageView2.setImageDrawable(drawable);
                            FragmentLoginPhoneBinding fragmentLoginPhoneBinding7 = (FragmentLoginPhoneBinding) this.getBinding();
                            if (fragmentLoginPhoneBinding7 != null && (appCompatEditText4 = fragmentLoginPhoneBinding7.password) != null) {
                                appCompatEditText4.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                                return;
                            }
                            return;
                        }
                        imageView2.setTag(1);
                        Context context3 = this.getContext();
                        if (context3 != null) {
                            drawable = androidx.core.content.a.getDrawable(context3, R.drawable.login_icon_donotshow);
                        }
                        imageView2.setImageDrawable(drawable);
                        FragmentLoginPhoneBinding fragmentLoginPhoneBinding8 = (FragmentLoginPhoneBinding) this.getBinding();
                        if (fragmentLoginPhoneBinding8 != null && (appCompatEditText3 = fragmentLoginPhoneBinding8.password) != null) {
                            appCompatEditText3.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        }
                    }
                }
            });
        }
        FragmentLoginPhoneBinding fragmentLoginPhoneBinding7 = (FragmentLoginPhoneBinding) getBinding();
        if (fragmentLoginPhoneBinding7 != null && (textView2 = fragmentLoginPhoneBinding7.forgotPassword) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.LoginPhoneFragment$onInitialize$$inlined$singleClick$default$5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                        VerificationCodeFragment verificationCodeFragment = new VerificationCodeFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("type", VerificationCodeFragment.TYPE_FORGOT_PASSWORD);
                        verificationCodeFragment.setArguments(bundle);
                        FragmentUtils.INSTANCE.showHideFragmentBackStack(this.requireActivity().getSupportFragmentManager(), R.id.loginFrameLayout, this, verificationCodeFragment, VerificationCodeFragment.TYPE_FORGOT_PASSWORD);
                    }
                }
            });
        }
        FragmentLoginPhoneBinding fragmentLoginPhoneBinding8 = (FragmentLoginPhoneBinding) getBinding();
        if (fragmentLoginPhoneBinding8 != null && (appCompatEditText2 = fragmentLoginPhoneBinding8.phoneNumber) != null) {
            appCompatEditText2.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.ui.login.LoginPhoneFragment$onInitialize$8
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    LoginPhoneFragment.this.checkButtonIsClick();
                }
            });
        }
        FragmentLoginPhoneBinding fragmentLoginPhoneBinding9 = (FragmentLoginPhoneBinding) getBinding();
        if (fragmentLoginPhoneBinding9 != null && (appCompatEditText = fragmentLoginPhoneBinding9.password) != null) {
            appCompatEditText.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.ui.login.LoginPhoneFragment$onInitialize$9
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    LoginPhoneFragment.this.checkButtonIsClick();
                }
            });
        }
        FragmentLoginPhoneBinding fragmentLoginPhoneBinding10 = (FragmentLoginPhoneBinding) getBinding();
        if (fragmentLoginPhoneBinding10 != null && (textView = fragmentLoginPhoneBinding10.confirmButton) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.LoginPhoneFragment$onInitialize$$inlined$singleClick$default$6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                        this.login();
                    }
                }
            });
        }
        refreshView();
        getViewModel().getLoginPhone().observe(this, new LoginPhoneFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.login.h
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$12;
                onInitialize$lambda$12 = LoginPhoneFragment.onInitialize$lambda$12((UserResponse) obj);
                return onInitialize$lambda$12;
            }
        }));
        getViewModel().getError().observe(this, new LoginPhoneFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.login.i
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$14;
                onInitialize$lambda$14 = LoginPhoneFragment.onInitialize$lambda$14(LoginPhoneFragment.this, (Throwable) obj);
                return onInitialize$lambda$14;
            }
        }));
    }

    @SuppressLint({"SetTextI18n"})
    public final void refreshView() {
        TextView textView;
        QMUIRadiusImageView2 qMUIRadiusImageView2;
        String str;
        FragmentLoginPhoneBinding fragmentLoginPhoneBinding = (FragmentLoginPhoneBinding) getBinding();
        String str2 = null;
        if (fragmentLoginPhoneBinding != null && (qMUIRadiusImageView2 = fragmentLoginPhoneBinding.countryIcon) != null) {
            Country selectCountry = getViewModel().getSelectCountry();
            if (selectCountry != null) {
                str = selectCountry.getIcon();
            } else {
                str = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        }
        FragmentLoginPhoneBinding fragmentLoginPhoneBinding2 = (FragmentLoginPhoneBinding) getBinding();
        if (fragmentLoginPhoneBinding2 != null && (textView = fragmentLoginPhoneBinding2.countryPhone) != null) {
            Country selectCountry2 = getViewModel().getSelectCountry();
            if (selectCountry2 != null) {
                str2 = selectCountry2.getAreaCode();
            }
            textView.setText("+" + str2);
        }
    }
}
