package com.qiahao.nextvideo.ui.authentication;

import android.content.Context;
import android.content.Intent;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.model.Login;
import com.qiahao.nextvideo.data.service.SignInEvent;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ActivityAuthBinding;
import com.taobao.accs.messenger.MessengerService;
import com.taobao.accs.utl.BaseMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u001eB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000e\u001a\u00020\fH\u0016J\"\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\fH\u0014J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/qiahao/nextvideo/ui/authentication/AuthenticationActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityAuthBinding;", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/login/LoginResult;", "<init>", "()V", "getLayoutResId", "", "callbackManager", "Lcom/facebook/CallbackManager;", "onInitialize", "", "onResume", "onBackPressed", "onActivityResult", "requestCode", com.taobao.agoo.a.a.b.JSON_ERRORCODE, "data", "Landroid/content/Intent;", "onDestroy", "onSuccess", "result", "onCancel", "onError", BaseMonitor.COUNT_ERROR, "Lcom/facebook/FacebookException;", "onPageEvent", "event", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class AuthenticationActivity extends HiloBaseBindingActivity<ActivityAuthBinding> implements FacebookCallback<LoginResult> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String keyPreloadModel = "keyPreloadModel";

    @Nullable
    private CallbackManager callbackManager;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/authentication/AuthenticationActivity$Companion;", "", "<init>", "()V", "keyPreloadModel", "", MessengerService.INTENT, "Landroid/content/Intent;", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent intent(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, (Class<?>) AuthenticationActivity.class);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_auth;
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        CallbackManager callbackManager = this.callbackManager;
        if (callbackManager != null) {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
        super/*com.oudi.core.component.SuperActivity*/.onActivityResult(requestCode, resultCode, data);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onBackPressed() {
        if (!getControllerWindowNotNull().onBackPressed()) {
            finishAffinity();
        }
    }

    public void onCancel() {
        UserService.INSTANCE.getShared().signInByOtherMeans(new SignInEvent(SignInEvent.Type.FACEBOOK, null, 16, null, 8, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        CallbackManager callbackManager = this.callbackManager;
        if (callbackManager != null) {
            LoginManager.Companion.getInstance().unregisterCallback(callbackManager);
        }
        this.callbackManager = null;
        super.onDestroy();
    }

    public void onError(@NotNull FacebookException error) {
        Intrinsics.checkNotNullParameter(error, BaseMonitor.COUNT_ERROR);
        if (AccessToken.Companion.getCurrentAccessToken() != null) {
            LoginManager.Companion.getInstance().logOut();
        }
        UserService.INSTANCE.getShared().signInByOtherMeans(new SignInEvent(SignInEvent.Type.FACEBOOK, null, 13, error.getMessage()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        setMSetBottom(false);
        super.onInitialize();
        setShowGiftTip(false);
        if (FacebookSdk.isInitialized()) {
            this.callbackManager = CallbackManager.Factory.create();
            LoginManager.Companion.getInstance().registerCallback(this.callbackManager, this);
        }
        getControllerWindowNotNull().setRootViewController(new AuthenticationViewController(getIntent().getBooleanExtra("keyPreloadModel", false)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onPageEvent(@NotNull EventBusKey event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getType(), "login_phone_success")) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onResume() {
        super.onResume();
        getBinding().activityMainContainer.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.authentication.a
            @Override // java.lang.Runnable
            public final void run() {
                AuthenticationActivity.this.setStatusBarIconColor(false);
            }
        }, 1000L);
    }

    public void onSuccess(@NotNull LoginResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        UserService.INSTANCE.getShared().signInByOtherMeans(new SignInEvent(SignInEvent.Type.FACEBOOK, Login.INSTANCE.init(result.getAccessToken()), 0, null, 8, null));
    }
}
