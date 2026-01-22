package com.qiahao.nextvideo.ui.authentication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.credentials.Credential;
import androidx.credentials.CustomCredential;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.lifecycle.LifecycleOwnerKt;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption;
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential;
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.BaseServer;
import com.qiahao.base_common.network.ServerInfo;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.wedgit.videoView.LifecycleVideoView;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.data.UserObjectEventType;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.DeleteAccountTimeBean;
import com.qiahao.nextvideo.data.model.FillUserDataUIModel;
import com.qiahao.nextvideo.data.model.Login;
import com.qiahao.nextvideo.data.model.UserResponse;
import com.qiahao.nextvideo.data.service.SignInEvent;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ViewControllerAuthenticationBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmPreloadModel;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewController;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate;
import com.qiahao.nextvideo.ui.fillpersonaldata.FillUserDataViewController;
import com.qiahao.nextvideo.ui.fillpersonaldata.neighborhoodsnote.NeighborhoodsNoteViewController;
import com.qiahao.nextvideo.ui.fillpersonaldata.neighborhoodsnote.NeighborhoodsNoteViewControllerDelegate;
import com.qiahao.nextvideo.ui.login.LoginActivity;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import com.qiahao.nextvideo.ui.setting.deleteaccount.DeleteAccountDialog;
import com.qiahao.nextvideo.ui.webview.DefaultWebActivity;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;
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
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0003J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J+\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u0017\u001a\u00020\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010#\u001a\u00020\u0011H\u0002J\b\u0010$\u001a\u00020\u0011H\u0002J\u000e\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020\u0011H\u0002J\b\u0010)\u001a\u00020\u0011H\u0003J\b\u0010-\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020\u0011H\u0016J\b\u0010/\u001a\u00020\u0011H\u0016J\b\u00100\u001a\u00020\u0011H\u0016J\u0018\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020 2\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020\u0011H\u0016J\b\u00106\u001a\u00020 H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020 X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/qiahao/nextvideo/ui/authentication/AuthenticationViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Lcom/qiahao/nextvideo/ui/fillpersonaldata/neighborhoodsnote/NeighborhoodsNoteViewControllerDelegate;", "Lcom/qiahao/nextvideo/ui/edition/country/confirmtip/ConfirmTipViewControllerDelegate;", "uiModel", "", "<init>", "(Z)V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerAuthenticationBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "doCreateView", "", AgooConstants.OPEN_ACTIIVTY_NAME, "Lcom/qiahao/nextvideo/app/base/HiloBaseActivity;", "viewDidLoad", "view", "viewDidAppear", "animated", "processUserProtocalSpan", "login", "Lcom/qiahao/nextvideo/data/model/Login;", "showDeleteAccount", "startupAuthFlow", "user", "Lcom/qiahao/base_common/model/common/User;", "type", "", "(Lcom/qiahao/base_common/model/common/User;ZLjava/lang/Integer;)V", "doDestroyView", "loginByFacebookButtonPressed", "loginByGoogleButtonPressed", "handleSignIn", "result", "Landroidx/credentials/GetCredentialResponse;", "configureDebugTools", "observeServerStatusForDebug", "MIN_CLICK_DELAY_TIME", "lastClickTime", "", "onBackPressed", "neighborhoodsNoteViewControllerDelegateDidAgree", "neighborhoodsNoteViewControllerDelegateDidSignOut", "neighborhoodsNoteViewControllerDelegateDidBack", "confirmTipViewControllerDidConfirm", "fromCode", "extra", "Landroid/os/Bundle;", "confirmTipViewControllerDidCancel", "processStatusBarCover", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAuthenticationViewController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AuthenticationViewController.kt\ncom/qiahao/nextvideo/ui/authentication/AuthenticationViewController\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,501:1\n61#2,9:502\n1#3:511\n*S KotlinDebug\n*F\n+ 1 AuthenticationViewController.kt\ncom/qiahao/nextvideo/ui/authentication/AuthenticationViewController\n*L\n114#1:502,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AuthenticationViewController extends BaseViewController implements NeighborhoodsNoteViewControllerDelegate, ConfirmTipViewControllerDelegate {
    private final int MIN_CLICK_DELAY_TIME = HonorResultCode.ADVANCED_RECORD_SUCCESS;

    @Nullable
    private ViewControllerAuthenticationBinding binding;
    private long lastClickTime;
    private final boolean uiModel;

    public AuthenticationViewController(boolean z) {
        this.uiModel = z;
    }

    private final void configureDebugTools() {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding = this.binding;
        if (viewControllerAuthenticationBinding != null && (appCompatTextView2 = viewControllerAuthenticationBinding.versionTextView) != null) {
            appCompatTextView2.setVisibility(8);
        }
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding2 = this.binding;
        if (viewControllerAuthenticationBinding2 != null && (appCompatTextView = viewControllerAuthenticationBinding2.serverTextView) != null) {
            appCompatTextView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit doCreateView$lambda$2$lambda$1(AuthenticationViewController authenticationViewController, int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding = authenticationViewController.binding;
        if (viewControllerAuthenticationBinding != null && (appCompatTextView2 = viewControllerAuthenticationBinding.userProtocalTextView) != null) {
            layoutParams = appCompatTextView2.getLayoutParams();
        } else {
            layoutParams = null;
        }
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        bVar.setMargins(0, 0, 0, i2 + UiKtxKt.toPX(20));
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding2 = authenticationViewController.binding;
        if (viewControllerAuthenticationBinding2 != null && (appCompatTextView = viewControllerAuthenticationBinding2.userProtocalTextView) != null) {
            appCompatTextView.setLayoutParams(bVar);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void login(final Login login) {
        String str;
        String str2;
        showProgressDialog("");
        ServerApi apis = AppServer.INSTANCE.getApis();
        String userId = login.getUserId();
        if (userId == null) {
            str = "";
        } else {
            str = userId;
        }
        String token = login.getToken();
        if (token == null) {
            str2 = "";
        } else {
            str2 = token;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.login(str, login.getType(), str2, login.getSex(), login.getAvatar(), login.getNickname()), new Function1() { // from class: com.qiahao.nextvideo.ui.authentication.m
            public final Object invoke(Object obj) {
                Unit login$lambda$9;
                login$lambda$9 = AuthenticationViewController.login$lambda$9(AuthenticationViewController.this, login, (ApiResponse) obj);
                return login$lambda$9;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.authentication.c
            public final Object invoke(Object obj) {
                Unit login$lambda$11;
                login$lambda$11 = AuthenticationViewController.login$lambda$11(AuthenticationViewController.this, login, (Throwable) obj);
                return login$lambda$11;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.ui.authentication.d
            public final Object invoke() {
                Unit login$lambda$12;
                login$lambda$12 = AuthenticationViewController.login$lambda$12(AuthenticationViewController.this);
                return login$lambda$12;
            }
        }, false, 8, (Object) null), getCompositeDisposable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit login$lambda$11(AuthenticationViewController authenticationViewController, Login login, Throwable th) {
        String str;
        String str2;
        AppCompatTextView appCompatTextView;
        String str3;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            ViewControllerAuthenticationBinding viewControllerAuthenticationBinding = authenticationViewController.binding;
            if (viewControllerAuthenticationBinding != null && (appCompatTextView = viewControllerAuthenticationBinding.serverTextView) != null) {
                String stringById = ResourcesKtxKt.getStringById(authenticationViewController, 2131954062);
                ServerInfo selectedServerInfo = BaseServer.INSTANCE.getSelectedServerInfo();
                if (selectedServerInfo != null) {
                    str3 = selectedServerInfo.getBaseUrl();
                } else {
                    str3 = null;
                }
                appCompatTextView.setText(stringById + str3);
            }
            HiloException hiloException = (HiloException) th;
            n5.e.b(hiloException.getErrorMessage());
            int code = hiloException.getCode();
            if (code != 9000) {
                if (code != 9011) {
                    HiloToasty.Companion companion = HiloToasty.Companion;
                    Context context = authenticationViewController.getContext();
                    String errorMessage = hiloException.getErrorMessage();
                    if (errorMessage == null) {
                        str2 = ResourcesKtxKt.getStringById(authenticationViewController, 2131952667);
                    } else {
                        str2 = errorMessage;
                    }
                    Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str2, false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                } else {
                    authenticationViewController.showDeleteAccount(login);
                }
            } else {
                ConfirmPreloadModel.Companion companion2 = ConfirmPreloadModel.INSTANCE;
                String errorMessage2 = hiloException.getErrorMessage();
                if (errorMessage2 == null) {
                    errorMessage2 = ResourcesKtxKt.getStringById(authenticationViewController, 2131952667);
                }
                ConfirmTipViewController confirmTipViewController = new ConfirmTipViewController(companion2.init(errorMessage2, ResourcesKtxKt.getStringById(authenticationViewController, 2131952331), null), null, 2, null);
                confirmTipViewController.setDelegate(authenticationViewController);
                ViewController.present$default(authenticationViewController, confirmTipViewController, true, null, 4, null);
            }
        } else {
            HiloToasty.Companion companion3 = HiloToasty.Companion;
            Context context2 = authenticationViewController.getContext();
            String message = th.getMessage();
            if (message == null) {
                str = ResourcesKtxKt.getStringById(authenticationViewController, 2131952667);
            } else {
                str = message;
            }
            Toast normal$default2 = HiloToasty.Companion.normal$default(companion3, context2, str, false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit login$lambda$12(AuthenticationViewController authenticationViewController) {
        authenticationViewController.dismissProgressDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit login$lambda$9(AuthenticationViewController authenticationViewController, Login login, ApiResponse apiResponse) {
        boolean z;
        Intrinsics.checkNotNullParameter(apiResponse, "apiResponse");
        if (apiResponse.getData() == null) {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, authenticationViewController.getContext(), ResourcesKtxKt.getStringById(authenticationViewController, 2131952667), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            return Unit.INSTANCE;
        }
        UserResponse userResponse = (UserResponse) apiResponse.getData();
        if (userResponse != null) {
            if (userResponse.getUser().isCompleteMaterial() && NeighborhoodsNoteViewController.INSTANCE.isAgreeNeighborhoodsNote(userResponse.getUser().getExternalId())) {
                z = false;
            } else {
                z = true;
            }
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "keyRongCloudToken", userResponse.getRongCloudToken(), (String) null, 4, (Object) null);
            if (z) {
                UserStore.INSTANCE.getShared().refreshUserInfo(userResponse.getUser(), userResponse.getToken(), UserObjectEventType.AUTHENTICATE, z);
                startupAuthFlow$default(authenticationViewController, userResponse.getUser(), false, Integer.valueOf(login.getType()), 2, null);
            } else {
                UserStore.INSTANCE.getShared().refreshUserInfo(userResponse.getUser(), userResponse.getToken(), UserObjectEventType.LOGIN, z);
                authenticationViewController.getRequireActivity().finish();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loginByFacebookButtonPressed() {
        if (FacebookSdk.isInitialized()) {
            showProgressDialog("");
            LoginManager.Companion.getInstance().logInWithReadPermissions(getRequireActivity(), CollectionsKt.listOf(new String[]{"email", "public_profile", "user_friends"}));
        } else {
            Toast error$default = HiloToasty.Companion.error$default(HiloToasty.Companion, getContext(), ResourcesKtxKt.getStringById(this, 2131952667), false, 4, (Object) null);
            if (error$default != null) {
                error$default.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loginByGoogleButtonPressed() {
        Toast error$default;
        int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(getRequireContext());
        if (isGooglePlayServicesAvailable == 0) {
            GetCredentialRequest build = new GetCredentialRequest.Builder().addCredentialOption(new GetSignInWithGoogleOption.Builder(ResourcesKtxKt.getStringById(this, 2131954063)).build()).build();
            new CancellationSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: com.qiahao.nextvideo.ui.authentication.b
                @Override // android.os.CancellationSignal.OnCancelListener
                public final void onCancel() {
                    AuthenticationViewController.loginByGoogleButtonPressed$lambda$19();
                }
            });
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getRequireActivity()), (CoroutineContext) null, (CoroutineStart) null, new AuthenticationViewController$loginByGoogleButtonPressed$2(this, build, null), 3, (Object) null);
            return;
        }
        if (isGooglePlayServicesAvailable != 1) {
            if (isGooglePlayServicesAvailable != 2) {
                if (isGooglePlayServicesAvailable != 3) {
                    if (isGooglePlayServicesAvailable != 7) {
                        if (isGooglePlayServicesAvailable != 9) {
                            if (isGooglePlayServicesAvailable == 18 && (error$default = HiloToasty.Companion.error$default(HiloToasty.Companion, getContext(), ResourcesKtxKt.getStringById(this, 2131952931), false, 4, (Object) null)) != null) {
                                error$default.show();
                                return;
                            }
                            return;
                        }
                        Toast error$default2 = HiloToasty.Companion.error$default(HiloToasty.Companion, getContext(), ResourcesKtxKt.getStringById(this, 2131954260), false, 4, (Object) null);
                        if (error$default2 != null) {
                            error$default2.show();
                            return;
                        }
                        return;
                    }
                    Toast error$default3 = HiloToasty.Companion.error$default(HiloToasty.Companion, getContext(), ResourcesKtxKt.getStringById(this, 2131954249), false, 4, (Object) null);
                    if (error$default3 != null) {
                        error$default3.show();
                        return;
                    }
                    return;
                }
                Toast error$default4 = HiloToasty.Companion.error$default(HiloToasty.Companion, getContext(), ResourcesKtxKt.getStringById(this, 2131954246), false, 4, (Object) null);
                if (error$default4 != null) {
                    error$default4.show();
                    return;
                }
                return;
            }
            Toast error$default5 = HiloToasty.Companion.error$default(HiloToasty.Companion, getContext(), ResourcesKtxKt.getStringById(this, 2131954247), false, 4, (Object) null);
            if (error$default5 != null) {
                error$default5.show();
                return;
            }
            return;
        }
        Toast error$default6 = HiloToasty.Companion.error$default(HiloToasty.Companion, getContext(), ResourcesKtxKt.getStringById(this, 2131952932), false, 4, (Object) null);
        if (error$default6 != null) {
            error$default6.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loginByGoogleButtonPressed$lambda$19() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit neighborhoodsNoteViewControllerDelegateDidSignOut$lambda$23() {
        UserStore.INSTANCE.getShared().logout();
        return Unit.INSTANCE;
    }

    @SuppressLint({"SetTextI18n"})
    private final void observeServerStatusForDebug() {
        nd.c subscribe = BaseServer.INSTANCE.getSelectedServerChange().observeOn(md.b.c()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.authentication.AuthenticationViewController$observeServerStatusForDebug$1
            public final void accept(String str) {
                ViewControllerAuthenticationBinding viewControllerAuthenticationBinding;
                ViewControllerAuthenticationBinding viewControllerAuthenticationBinding2;
                AppCompatTextView appCompatTextView;
                AppCompatTextView appCompatTextView2;
                ServerInfo selectedServerInfo = BaseServer.INSTANCE.getSelectedServerInfo();
                viewControllerAuthenticationBinding = AuthenticationViewController.this.binding;
                if (viewControllerAuthenticationBinding != null && (appCompatTextView2 = viewControllerAuthenticationBinding.versionTextView) != null) {
                    appCompatTextView2.setText(ResourcesKtxKt.getStringById(AuthenticationViewController.this, 2131954408) + "4.41.0(503)");
                }
                viewControllerAuthenticationBinding2 = AuthenticationViewController.this.binding;
                if (viewControllerAuthenticationBinding2 == null || (appCompatTextView = viewControllerAuthenticationBinding2.serverTextView) == null) {
                    return;
                }
                appCompatTextView.setText(ResourcesKtxKt.getStringById(AuthenticationViewController.this, 2131954062) + (selectedServerInfo != null ? selectedServerInfo.getBaseUrl() : null));
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, getCompositeDisposable());
    }

    private final void processUserProtocalSpan() {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        AppCompatTextView appCompatTextView4;
        AppCompatTextView appCompatTextView5;
        AppCompatTextView appCompatTextView6;
        AppCompatTextView appCompatTextView7;
        AppCompatTextView appCompatTextView8;
        ClickableSpan clickableSpan = new ClickableSpan() { // from class: com.qiahao.nextvideo.ui.authentication.AuthenticationViewController$processUserProtocalSpan$privacyPolicyClickableSpan$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                DefaultWebActivity.INSTANCE.start(AuthenticationViewController.this.getRequireActivity(), ResourcesKtxKt.getStringById(this, 2131953717), ResourcesKtxKt.getStringById(this, 2131953715));
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.checkNotNullParameter(ds, "ds");
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
                ds.linkColor = 0;
            }
        };
        ClickableSpan clickableSpan2 = new ClickableSpan() { // from class: com.qiahao.nextvideo.ui.authentication.AuthenticationViewController$processUserProtocalSpan$termsOfServiceClickableSpan$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                DefaultWebActivity.INSTANCE.start(AuthenticationViewController.this.getRequireActivity(), ResourcesKtxKt.getStringById(this, 2131954239), ResourcesKtxKt.getStringById(this, 2131954238));
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.checkNotNullParameter(ds, "ds");
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
                ds.linkColor = 0;
            }
        };
        ClickableSpan clickableSpan3 = new ClickableSpan() { // from class: com.qiahao.nextvideo.ui.authentication.AuthenticationViewController$processUserProtocalSpan$childSafelyClickableSpan$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                DefaultWebActivity.INSTANCE.start(AuthenticationViewController.this.getRequireActivity(), ResourcesKtxKt.getStringById(this, 2131952254), ResourcesKtxKt.getStringById(this, 2131952253));
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.checkNotNullParameter(ds, "ds");
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
                ds.linkColor = 0;
            }
        };
        SpannableString spannableString = new SpannableString("Terms of Service");
        SpannableString spannableString2 = new SpannableString("Privacy Policy");
        SpannableString spannableString3 = new SpannableString("Child Safety Policy");
        spannableString.setSpan(clickableSpan2, 0, spannableString.length(), 33);
        spannableString2.setSpan(clickableSpan, 0, spannableString2.length(), 33);
        spannableString3.setSpan(clickableSpan3, 0, spannableString3.length(), 33);
        spannableString3.setSpan(new UnderlineSpan(), 0, spannableString3.length(), 33);
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding = this.binding;
        if (viewControllerAuthenticationBinding != null && (appCompatTextView8 = viewControllerAuthenticationBinding.userProtocalTextView) != null) {
            appCompatTextView8.append(" ");
        }
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding2 = this.binding;
        if (viewControllerAuthenticationBinding2 != null && (appCompatTextView7 = viewControllerAuthenticationBinding2.userProtocalTextView) != null) {
            appCompatTextView7.append(spannableString);
        }
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding3 = this.binding;
        if (viewControllerAuthenticationBinding3 != null && (appCompatTextView6 = viewControllerAuthenticationBinding3.userProtocalTextView) != null) {
            appCompatTextView6.append(" and ");
        }
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding4 = this.binding;
        if (viewControllerAuthenticationBinding4 != null && (appCompatTextView5 = viewControllerAuthenticationBinding4.userProtocalTextView) != null) {
            appCompatTextView5.append(spannableString2);
        }
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding5 = this.binding;
        if (viewControllerAuthenticationBinding5 != null && (appCompatTextView4 = viewControllerAuthenticationBinding5.userProtocalTextView) != null) {
            appCompatTextView4.append(" and ");
        }
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding6 = this.binding;
        if (viewControllerAuthenticationBinding6 != null && (appCompatTextView3 = viewControllerAuthenticationBinding6.userProtocalTextView) != null) {
            appCompatTextView3.append(spannableString3);
        }
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding7 = this.binding;
        if (viewControllerAuthenticationBinding7 != null && (appCompatTextView2 = viewControllerAuthenticationBinding7.userProtocalTextView) != null) {
            appCompatTextView2.setHighlightColor(0);
        }
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding8 = this.binding;
        if (viewControllerAuthenticationBinding8 != null && (appCompatTextView = viewControllerAuthenticationBinding8.userProtocalTextView) != null) {
            appCompatTextView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    private final void showDeleteAccount(final Login login) {
        UserService shared = UserService.INSTANCE.getShared();
        String userId = login.getUserId();
        String str = "";
        if (userId == null) {
            userId = "";
        }
        int type = login.getType();
        String token = login.getToken();
        if (token != null) {
            str = token;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.getDeleteAccountTime(userId, type, str), new Function1() { // from class: com.qiahao.nextvideo.ui.authentication.h
            public final Object invoke(Object obj) {
                Unit showDeleteAccount$lambda$16;
                showDeleteAccount$lambda$16 = AuthenticationViewController.showDeleteAccount$lambda$16(AuthenticationViewController.this, login, (ApiResponse) obj);
                return showDeleteAccount$lambda$16;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.authentication.i
            public final Object invoke(Object obj) {
                Unit showDeleteAccount$lambda$17;
                showDeleteAccount$lambda$17 = AuthenticationViewController.showDeleteAccount$lambda$17(AuthenticationViewController.this, (Throwable) obj);
                return showDeleteAccount$lambda$17;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showDeleteAccount$lambda$16(AuthenticationViewController authenticationViewController, final Login login, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        DeleteAccountTimeBean deleteAccountTimeBean = (DeleteAccountTimeBean) apiResponse.getData();
        if (deleteAccountTimeBean != null) {
            DeleteAccountDialog deleteAccountDialog = new DeleteAccountDialog(authenticationViewController.getRequireActivity(), deleteAccountTimeBean.getLogoutFinishTime(), deleteAccountTimeBean.getUserCode(), login);
            deleteAccountDialog.setListener(new Function0() { // from class: com.qiahao.nextvideo.ui.authentication.e
                public final Object invoke() {
                    Unit showDeleteAccount$lambda$16$lambda$15$lambda$14$lambda$13;
                    showDeleteAccount$lambda$16$lambda$15$lambda$14$lambda$13 = AuthenticationViewController.showDeleteAccount$lambda$16$lambda$15$lambda$14$lambda$13(Login.this);
                    return showDeleteAccount$lambda$16$lambda$15$lambda$14$lambda$13;
                }
            });
            deleteAccountDialog.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showDeleteAccount$lambda$16$lambda$15$lambda$14$lambda$13(Login login) {
        UserService.INSTANCE.getShared().signInByOtherMeans(new SignInEvent(SignInEvent.Type.GOOGLE, login, 0, null, 8, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showDeleteAccount$lambda$17(AuthenticationViewController authenticationViewController, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context requireContext = authenticationViewController.getRequireContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = ResourcesKtxKt.getStringById(authenticationViewController, 2131952667);
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, requireContext, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    private final void startupAuthFlow(User user, boolean animated, Integer type) {
        User user2 = UserStore.INSTANCE.getShared().getUser();
        if (user2 != null && !user2.isCompleteMaterial()) {
            ViewController.present$default(this, new FillUserDataViewController(FillUserDataUIModel.INSTANCE.init(user, type)), animated, null, 4, null);
        } else if (!NeighborhoodsNoteViewController.INSTANCE.isAgreeNeighborhoodsNote(user.getExternalId())) {
            NeighborhoodsNoteViewController neighborhoodsNoteViewController = new NeighborhoodsNoteViewController();
            neighborhoodsNoteViewController.setDelegate(this);
            ViewController.present$default(this, neighborhoodsNoteViewController, animated, null, 4, null);
        }
    }

    static /* synthetic */ void startupAuthFlow$default(AuthenticationViewController authenticationViewController, User user, boolean z, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            num = 0;
        }
        authenticationViewController.startupAuthFlow(user, z, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$6(AuthenticationViewController authenticationViewController) {
        AppCompatImageView appCompatImageView;
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding = authenticationViewController.binding;
        if (viewControllerAuthenticationBinding != null && (appCompatImageView = viewControllerAuthenticationBinding.bgLaunchImageView) != null) {
            appCompatImageView.setVisibility(8);
        }
    }

    @Override // com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate
    public void confirmTipViewControllerDidCancel() {
    }

    @Override // com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate
    public void confirmTipViewControllerDidConfirm(int fromCode, @NotNull Bundle extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        ViewController.dismiss$default(this, true, null, 2, null);
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void doCreateView(@NotNull ViewGroup container, @NotNull HiloBaseActivity activity) {
        LifecycleVideoView lifecycleVideoView;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
        super.doCreateView(container, activity);
        processUserProtocalSpan();
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding = this.binding;
        if (viewControllerAuthenticationBinding != null && (lifecycleVideoView = viewControllerAuthenticationBinding.videoView) != null) {
            activity.getStatusBarTopOrBottom(lifecycleVideoView, new Function2() { // from class: com.qiahao.nextvideo.ui.authentication.f
                public final Object invoke(Object obj, Object obj2) {
                    Unit doCreateView$lambda$2$lambda$1;
                    doCreateView$lambda$2$lambda$1 = AuthenticationViewController.doCreateView$lambda$2$lambda$1(AuthenticationViewController.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                    return doCreateView$lambda$2$lambda$1;
                }
            });
        }
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void doDestroyView(@NotNull ViewGroup container) {
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(container, "container");
        dismissProgressDialog();
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding = this.binding;
        if (viewControllerAuthenticationBinding != null && (frameLayout = viewControllerAuthenticationBinding.commonIdCoordinateLayout) != null) {
            frameLayout.removeAllViews();
        }
        getCompositeDisposable().d();
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding2 = this.binding;
        if (viewControllerAuthenticationBinding2 != null) {
            viewControllerAuthenticationBinding2.unbind();
        }
        super.doDestroyView(container);
    }

    public final void handleSignIn(@NotNull GetCredentialResponse result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Credential credential = result.getCredential();
        if (credential instanceof CustomCredential) {
            if (Intrinsics.areEqual(credential.getType(), "com.google.android.libraries.identity.googleid.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL")) {
                try {
                    GoogleIdTokenCredential createFrom = GoogleIdTokenCredential.Companion.createFrom(credential.getData());
                    SignInEvent signInEvent = new SignInEvent(SignInEvent.Type.GOOGLE, Login.INSTANCE.init(createFrom), 0, null, 8, null);
                    IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "google_token", createFrom.getIdToken(), (String) null, 4, (Object) null);
                    UserService.INSTANCE.getShared().signInByOtherMeans(signInEvent);
                    Unit unit = Unit.INSTANCE;
                    return;
                } catch (GoogleIdTokenParsingException e) {
                    HiloToasty.Companion companion = HiloToasty.Companion;
                    Context requireContext = getRequireContext();
                    String localizedMessage = e.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = "Received an invalid google id token response";
                    }
                    Toast normal$default = HiloToasty.Companion.normal$default(companion, requireContext, localizedMessage, false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                        Unit unit2 = Unit.INSTANCE;
                        return;
                    }
                    return;
                }
            }
            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, getRequireContext(), "Unexpected type of credential", false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
                return;
            }
            return;
        }
        Toast normal$default3 = HiloToasty.Companion.normal$default(HiloToasty.Companion, getRequireContext(), "Unexpected type of credential", false, 4, (Object) null);
        if (normal$default3 != null) {
            normal$default3.show();
        }
    }

    @Override // com.qiahao.nextvideo.ui.fillpersonaldata.neighborhoodsnote.NeighborhoodsNoteViewControllerDelegate
    public void neighborhoodsNoteViewControllerDelegateDidAgree() {
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        if (user != null) {
            UserStore.refreshUserInfo$default(companion.getShared(), user, companion.getShared().getAuthenticationToken(), UserObjectEventType.LOGIN, false, 8, null);
        }
        getRequireActivity().finish();
    }

    @Override // com.qiahao.nextvideo.ui.fillpersonaldata.neighborhoodsnote.NeighborhoodsNoteViewControllerDelegate
    public void neighborhoodsNoteViewControllerDelegateDidBack() {
        neighborhoodsNoteViewControllerDelegateDidSignOut();
    }

    @Override // com.qiahao.nextvideo.ui.fillpersonaldata.neighborhoodsnote.NeighborhoodsNoteViewControllerDelegate
    public void neighborhoodsNoteViewControllerDelegateDidSignOut() {
        dismiss(true, new Function0() { // from class: com.qiahao.nextvideo.ui.authentication.g
            public final Object invoke() {
                Unit neighborhoodsNoteViewControllerDelegateDidSignOut$lambda$23;
                neighborhoodsNoteViewControllerDelegateDidSignOut$lambda$23 = AuthenticationViewController.neighborhoodsNoteViewControllerDelegateDidSignOut$lambda$23();
                return neighborhoodsNoteViewControllerDelegateDidSignOut$lambda$23;
            }
        });
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public boolean onBackPressed() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime >= this.MIN_CLICK_DELAY_TIME) {
            this.lastClickTime = currentTimeMillis;
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, getContext(), ResourcesKtxKt.getStringById(this, 2131954329), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
                return true;
            }
            return true;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        getRequireActivity().startActivity(intent);
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @RequiresApi(24)
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        LifecycleVideoView lifecycleVideoView;
        LifecycleVideoView lifecycleVideoView2;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerAuthenticationBinding inflate = ViewControllerAuthenticationBinding.inflate(inflater, container, false);
        this.binding = inflate;
        if (inflate != null && (lifecycleVideoView2 = inflate.videoView) != null) {
            lifecycleVideoView2.setLooping(true);
        }
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding = this.binding;
        if (viewControllerAuthenticationBinding != null && (lifecycleVideoView = viewControllerAuthenticationBinding.videoView) != null) {
            lifecycleVideoView.bindLifecycle(getRequireActivity().getLifecycleOwner());
        }
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public int processStatusBarCover() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            startupAuthFlow$default(this, user, false, null, 4, null);
        }
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        View root;
        final ImageView imageView;
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        LifecycleVideoView lifecycleVideoView;
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding;
        AppCompatImageView appCompatImageView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        configureDebugTools();
        if (this.uiModel && (viewControllerAuthenticationBinding = this.binding) != null && (appCompatImageView = viewControllerAuthenticationBinding.bgLaunchImageView) != null) {
            appCompatImageView.setVisibility(0);
        }
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding2 = this.binding;
        if (viewControllerAuthenticationBinding2 != null && (lifecycleVideoView = viewControllerAuthenticationBinding2.videoView) != null) {
            lifecycleVideoView.safePlay(Uri.parse("android.resource://com.qiahao.nextvideo/raw/login_video"));
        }
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding3 = this.binding;
        if (viewControllerAuthenticationBinding3 != null && (frameLayout2 = viewControllerAuthenticationBinding3.loginByGoogleButton) != null) {
            frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.authentication.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AuthenticationViewController.this.loginByGoogleButtonPressed();
                }
            });
        }
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding4 = this.binding;
        if (viewControllerAuthenticationBinding4 != null && (frameLayout = viewControllerAuthenticationBinding4.loginByFacebookButton) != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.authentication.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AuthenticationViewController.this.loginByFacebookButtonPressed();
                }
            });
        }
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding5 = this.binding;
        if (viewControllerAuthenticationBinding5 != null && (imageView = viewControllerAuthenticationBinding5.loginPhone) != null) {
            final long j = 800;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.authentication.AuthenticationViewController$viewDidLoad$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                        this.getRequireActivity().startActivity(new Intent(this.getRequireContext(), (Class<?>) LoginActivity.class));
                    }
                }
            });
        }
        nd.c subscribe = UserService.INSTANCE.getShared().getSignInEventRelay().observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.authentication.AuthenticationViewController$viewDidLoad$4
            public final void accept(SignInEvent signInEvent) {
                try {
                    AuthenticationViewController.this.showProgressDialog("");
                    if (signInEvent.getData() != null) {
                        AuthenticationViewController.this.login(signInEvent.getData());
                        return;
                    }
                    AuthenticationViewController.this.dismissProgressDialog();
                    int error = signInEvent.getError();
                    if (error == 7) {
                        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, AuthenticationViewController.this.getContext(), ResourcesKtxKt.getStringById(AuthenticationViewController.this, 2131954249), false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                            return;
                        }
                        return;
                    }
                    if (error != 16) {
                        HiloToasty.Companion companion = HiloToasty.Companion;
                        Context context = AuthenticationViewController.this.getContext();
                        String errorMessage = signInEvent.getErrorMessage();
                        if (errorMessage == null) {
                            errorMessage = ResourcesKtxKt.getStringById(AuthenticationViewController.this, 2131952667);
                        }
                        Toast normal$default2 = HiloToasty.Companion.normal$default(companion, context, errorMessage, false, 4, (Object) null);
                        if (normal$default2 != null) {
                            normal$default2.show();
                            return;
                        }
                        return;
                    }
                    Toast normal = HiloToasty.Companion.normal(AuthenticationViewController.this.getContext(), ResourcesKtxKt.getStringById(AuthenticationViewController.this, 2131953250), false);
                    if (normal != null) {
                        normal.show();
                    }
                } catch (Exception e) {
                    DebugToolsKt.printfE("登录", "matchToggleStatusChangedEventRelay内部try()catch{}" + e.getLocalizedMessage());
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, getCompositeDisposable());
        ViewControllerAuthenticationBinding viewControllerAuthenticationBinding6 = this.binding;
        if (viewControllerAuthenticationBinding6 != null && (root = viewControllerAuthenticationBinding6.getRoot()) != null) {
            root.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.authentication.l
                @Override // java.lang.Runnable
                public final void run() {
                    AuthenticationViewController.viewDidLoad$lambda$6(AuthenticationViewController.this);
                }
            }, 400L);
        }
    }
}
