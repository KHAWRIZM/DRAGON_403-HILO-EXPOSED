package com.qiahao.nextvideo.ui.login;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityChangePasswordBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/login/ChangePasswordActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityChangePasswordBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/ui/login/LoginViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/login/LoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getLayoutResId", "", "onInitialize", "", "checkButtonIsClick", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nChangePasswordActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChangePasswordActivity.kt\ncom/qiahao/nextvideo/ui/login/ChangePasswordActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,126:1\n61#2,9:127\n61#2,9:136\n61#2,9:145\n61#2,9:154\n*S KotlinDebug\n*F\n+ 1 ChangePasswordActivity.kt\ncom/qiahao/nextvideo/ui/login/ChangePasswordActivity\n*L\n45#1:127,9\n50#1:136,9\n63#1:145,9\n95#1:154,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ChangePasswordActivity extends HiloBaseBindingActivity<ActivityChangePasswordBinding> {

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.login.d
        public final Object invoke() {
            LoginViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = ChangePasswordActivity.viewModel_delegate$lambda$0(ChangePasswordActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkButtonIsClick() {
        boolean z;
        if (!TextUtils.isEmpty(getBinding().oldPassword.getText()) && String.valueOf(getBinding().oldPassword.getText()).length() >= 6 && !TextUtils.isEmpty(getBinding().newPassword.getText()) && String.valueOf(getBinding().newPassword.getText()).length() >= 6) {
            z = true;
        } else {
            z = false;
        }
        getBinding().confirmButton.setEnabled(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoginViewModel getViewModel() {
        return (LoginViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$1(ChangePasswordActivity changePasswordActivity, int i, int i2) {
        changePasswordActivity.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onInitialize$lambda$6(ChangePasswordActivity changePasswordActivity, Boolean bool) {
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, changePasswordActivity, ResourcesKtxKt.getStringById(changePasswordActivity, 2131954177), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            changePasswordActivity.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onInitialize$lambda$7(ChangePasswordActivity changePasswordActivity, Throwable th) {
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            hiloException.getCode();
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = hiloException.getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(changePasswordActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, changePasswordActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LoginViewModel viewModel_delegate$lambda$0(ChangePasswordActivity changePasswordActivity) {
        return new ViewModelProvider(changePasswordActivity).get(LoginViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_change_password;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        View view = getBinding().titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.login.a
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$1;
                onInitialize$lambda$1 = ChangePasswordActivity.onInitialize$lambda$1(ChangePasswordActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$1;
            }
        });
        getBinding().titleBar.title.setText(ResourcesKtxKt.getStringById(this, 2131953251));
        final AppCompatImageView appCompatImageView = getBinding().titleBar.backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.ChangePasswordActivity$onInitialize$$inlined$singleClick$default$1
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
        final ImageView imageView = getBinding().viewOldPassword;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.ChangePasswordActivity$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActivityChangePasswordBinding binding;
                ActivityChangePasswordBinding binding2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    ImageView imageView2 = (ImageView) imageView;
                    if (Intrinsics.areEqual(imageView2.getTag(), 1)) {
                        imageView2.setTag(2);
                        imageView2.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.login_icon_display));
                        binding2 = this.getBinding();
                        binding2.oldPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        return;
                    }
                    imageView2.setTag(1);
                    imageView2.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.login_icon_donotshow));
                    binding = this.getBinding();
                    binding.oldPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        final ImageView imageView2 = getBinding().viewNewPassword;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.ChangePasswordActivity$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActivityChangePasswordBinding binding;
                ActivityChangePasswordBinding binding2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j || (imageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                    ImageView imageView3 = (ImageView) imageView2;
                    if (Intrinsics.areEqual(imageView3.getTag(), 1)) {
                        imageView3.setTag(2);
                        imageView3.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.login_icon_display));
                        binding2 = this.getBinding();
                        binding2.newPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        return;
                    }
                    imageView3.setTag(1);
                    imageView3.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.login_icon_donotshow));
                    binding = this.getBinding();
                    binding.newPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        getBinding().oldPassword.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.ui.login.ChangePasswordActivity$onInitialize$5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ChangePasswordActivity.this.checkButtonIsClick();
            }
        });
        getBinding().newPassword.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.ui.login.ChangePasswordActivity$onInitialize$6
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ChangePasswordActivity.this.checkButtonIsClick();
            }
        });
        final TextView textView = getBinding().confirmButton;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.ChangePasswordActivity$onInitialize$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginViewModel viewModel;
                ActivityChangePasswordBinding binding;
                ActivityChangePasswordBinding binding2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    viewModel = this.getViewModel();
                    binding = this.getBinding();
                    String valueOf = String.valueOf(binding.oldPassword.getText());
                    binding2 = this.getBinding();
                    viewModel.changePwd(valueOf, String.valueOf(binding2.newPassword.getText()), "");
                }
            }
        });
        getViewModel().getChangePwd().observe(this, new ChangePasswordActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.login.b
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$6;
                onInitialize$lambda$6 = ChangePasswordActivity.onInitialize$lambda$6(ChangePasswordActivity.this, (Boolean) obj);
                return onInitialize$lambda$6;
            }
        }));
        getViewModel().getError().observe(this, new ChangePasswordActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.login.c
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$7;
                onInitialize$lambda$7 = ChangePasswordActivity.onInitialize$lambda$7(ChangePasswordActivity.this, (Throwable) obj);
                return onInitialize$lambda$7;
            }
        }));
    }
}
