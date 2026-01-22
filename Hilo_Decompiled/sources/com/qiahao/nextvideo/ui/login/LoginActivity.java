package com.qiahao.nextvideo.ui.login;

import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityLoginBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/ui/login/LoginActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityLoginBinding;", "<init>", "()V", "loginPhoneFragment", "Lcom/qiahao/nextvideo/ui/login/LoginPhoneFragment;", "getLoginPhoneFragment", "()Lcom/qiahao/nextvideo/ui/login/LoginPhoneFragment;", "loginPhoneFragment$delegate", "Lkotlin/Lazy;", "getLayoutResId", "", "onInitialize", "", "onPageEvent", "event", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LoginActivity extends HiloBaseBindingActivity<ActivityLoginBinding> {

    /* renamed from: loginPhoneFragment$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy loginPhoneFragment = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.login.e
        public final Object invoke() {
            LoginPhoneFragment loginPhoneFragment_delegate$lambda$0;
            loginPhoneFragment_delegate$lambda$0 = LoginActivity.loginPhoneFragment_delegate$lambda$0();
            return loginPhoneFragment_delegate$lambda$0;
        }
    });

    private final LoginPhoneFragment getLoginPhoneFragment() {
        return (LoginPhoneFragment) this.loginPhoneFragment.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LoginPhoneFragment loginPhoneFragment_delegate$lambda$0() {
        return new LoginPhoneFragment();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        getSupportFragmentManager().beginTransaction().add(R.id.loginFrameLayout, getLoginPhoneFragment()).commit();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onPageEvent(@NotNull EventBusKey event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getType(), "login_phone_success")) {
            finish();
        }
    }
}
