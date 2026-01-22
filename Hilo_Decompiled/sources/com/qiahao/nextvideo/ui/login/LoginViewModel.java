package com.qiahao.nextvideo.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.base_common.model.common.PhoneInfo;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.UserResponse;
import com.qiahao.nextvideo.data.service.UserService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.BaseMonitor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u001d\u001a\u00020>2\u0006\u0010?\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000fJ6\u0010)\u001a\u00020>2\u0006\u0010B\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000fJ&\u0010,\u001a\u00020>2\u0006\u0010?\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020\u000fJ\u001e\u0010/\u001a\u00020>2\u0006\u0010E\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020\u000fJ&\u00102\u001a\u00020>2\u0006\u0010B\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\u00152\u0006\u0010G\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020\u000fJ0\u00105\u001a\u00020>2\u0006\u0010B\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u000f2\u0006\u0010I\u001a\u00020\u000f2\b\b\u0002\u0010J\u001a\u00020\u0015J&\u0010#\u001a\u00020>2\u0006\u0010K\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020\u000fJ(\u0010&\u001a\u00020>2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020\u000f2\u0006\u0010I\u001a\u00020\u000f2\b\b\u0002\u0010J\u001a\u00020\u0015J\u0006\u0010L\u001a\u00020>R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u001e8F¢\u0006\u0006\u001a\u0004\b$\u0010 R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0\u001e8F¢\u0006\u0006\u001a\u0004\b'\u0010 R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\"0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0\u001e8F¢\u0006\u0006\u001a\u0004\b*\u0010 R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\"0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\"0\u001e8F¢\u0006\u0006\u001a\u0004\b-\u0010 R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020\"0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\"0\u001e8F¢\u0006\u0006\u001a\u0004\b0\u0010 R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\"0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\"0\u001e8F¢\u0006\u0006\u001a\u0004\b3\u0010 R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\"0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\"0\u001e8F¢\u0006\u0006\u001a\u0004\b6\u0010 R\u0014\u00107\u001a\b\u0012\u0004\u0012\u0002080\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00109\u001a\b\u0012\u0004\u0012\u0002080\u001e8F¢\u0006\u0006\u001a\u0004\b:\u0010 R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u0002080\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u0002080\u001e8F¢\u0006\u0006\u001a\u0004\b=\u0010 ¨\u0006M"}, d2 = {"Lcom/qiahao/nextvideo/ui/login/LoginViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "repository", "Lcom/qiahao/nextvideo/data/service/UserService;", "<init>", "(Lcom/qiahao/nextvideo/data/service/UserService;)V", "getRepository", "()Lcom/qiahao/nextvideo/data/service/UserService;", "selectCountry", "Lcom/qiahao/base_common/model/common/Country;", "getSelectCountry", "()Lcom/qiahao/base_common/model/common/Country;", "setSelectCountry", "(Lcom/qiahao/base_common/model/common/Country;)V", "oldVerificationCode", "", "getOldVerificationCode", "()Ljava/lang/String;", "setOldVerificationCode", "(Ljava/lang/String;)V", "thirdType", "", "getThirdType", "()I", "setThirdType", "(I)V", "loginPhoneMutable", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qiahao/nextvideo/data/model/UserResponse;", "loginPhone", "Landroidx/lifecycle/LiveData;", "getLoginPhone", "()Landroidx/lifecycle/LiveData;", "forgotPwdMutable", "", "forgotPwd", "getForgotPwd", "checkSendSMSMutable", "checkSendSMS", "getCheckSendSMS", "checkPhoneMutable", "checkPhone", "getCheckPhone", "binderPhoneAndPwdMutable", "binderPhoneAndPwd", "getBinderPhoneAndPwd", "changePwdMutable", "changePwd", "getChangePwd", "binderOrUnBinderThirdMutable", "binderOrUnBinderThird", "getBinderOrUnBinderThird", "checkSMSMutable", "checkSMS", "getCheckSMS", "errorMutable", "", BaseMonitor.COUNT_ERROR, "getError", "changeBindErrorMutable", "changeBindError", "getChangeBindError", "", "country", "phone", "pwd", "type", "oldCode", Constants.KEY_HTTP_CODE, "oldPwd", "thirdPartyType", "thirdPartyId", "thirdPartyToken", "authen", "way", "areaCode", "resetCheckPhone", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LoginViewModel extends BaseViewModel {

    @NotNull
    private final MutableLiveData<Boolean> binderOrUnBinderThirdMutable;

    @NotNull
    private final MutableLiveData<Boolean> binderPhoneAndPwdMutable;

    @NotNull
    private final MutableLiveData<Throwable> changeBindErrorMutable;

    @NotNull
    private final MutableLiveData<Boolean> changePwdMutable;

    @NotNull
    private final MutableLiveData<Boolean> checkPhoneMutable;

    @NotNull
    private final MutableLiveData<Boolean> checkSMSMutable;

    @NotNull
    private final MutableLiveData<Boolean> checkSendSMSMutable;

    @NotNull
    private final MutableLiveData<Throwable> errorMutable;

    @NotNull
    private final MutableLiveData<Boolean> forgotPwdMutable;

    @NotNull
    private final MutableLiveData<UserResponse> loginPhoneMutable;

    @Nullable
    private String oldVerificationCode;

    @NotNull
    private final UserService repository;

    @Nullable
    private Country selectCountry;
    private int thirdType;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LoginViewModel() {
        this(r0, 1, r0);
        UserService userService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit binderOrUnBinderThird$lambda$8(LoginViewModel loginViewModel, int i, String str, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (loginViewModel.thirdType == 2 && apiResponse.isOk()) {
            if (i == 1) {
                IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "google_token", str, (String) null, 4, (Object) null);
            } else {
                IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "google_token", "", (String) null, 4, (Object) null);
            }
        }
        loginViewModel.binderOrUnBinderThirdMutable.setValue(Boolean.valueOf(apiResponse.isOk()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit binderOrUnBinderThird$lambda$9(LoginViewModel loginViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        loginViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit binderPhoneAndPwd$lambda$4(LoginViewModel loginViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore.INSTANCE.getShared().changeBindPhone((PhoneInfo) apiResponse.getData());
        loginViewModel.binderPhoneAndPwdMutable.setValue(Boolean.valueOf(apiResponse.isOk()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit binderPhoneAndPwd$lambda$5(LoginViewModel loginViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        loginViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit changePwd$lambda$6(LoginViewModel loginViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        loginViewModel.changePwdMutable.setValue(Boolean.valueOf(apiResponse.isOk()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit changePwd$lambda$7(LoginViewModel loginViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        loginViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkPhone$lambda$2(int i, LoginViewModel loginViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (i == 2) {
            UserStore.INSTANCE.getShared().changeBindPhone((PhoneInfo) apiResponse.getData());
            cf.c.c().l(new EventBusKey("refresh_account", (Object) null, 2, (DefaultConstructorMarker) null));
        }
        loginViewModel.checkPhoneMutable.setValue(Boolean.valueOf(apiResponse.isOk()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkPhone$lambda$3(int i, LoginViewModel loginViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (i == 2) {
            loginViewModel.changeBindErrorMutable.setValue(th);
        } else {
            loginViewModel.errorMutable.setValue(th);
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void checkSMS$default(LoginViewModel loginViewModel, int i, String str, String str2, String str3, int i2, int i3, Object obj) {
        int i4;
        if ((i3 & 16) != 0) {
            i4 = 0;
        } else {
            i4 = i2;
        }
        loginViewModel.checkSMS(i, str, str2, str3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkSMS$lambda$10(LoginViewModel loginViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        loginViewModel.checkSMSMutable.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkSMS$lambda$11(LoginViewModel loginViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        loginViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void checkSendSMS$default(LoginViewModel loginViewModel, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 0;
        }
        loginViewModel.checkSendSMS(str, str2, str3, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkSendSMS$lambda$14(LoginViewModel loginViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        loginViewModel.checkSendSMSMutable.setValue(Boolean.valueOf(apiResponse.isOk()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkSendSMS$lambda$15(LoginViewModel loginViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        loginViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit forgotPwd$lambda$12(LoginViewModel loginViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        loginViewModel.forgotPwdMutable.setValue(Boolean.valueOf(apiResponse.isOk()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit forgotPwd$lambda$13(LoginViewModel loginViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        loginViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loginPhone$lambda$0(LoginViewModel loginViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        loginViewModel.loginPhoneMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loginPhone$lambda$1(LoginViewModel loginViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        loginViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    public final void binderOrUnBinderThird(final int type, int thirdPartyType, @NotNull String thirdPartyId, @NotNull final String thirdPartyToken) {
        Intrinsics.checkNotNullParameter(thirdPartyId, "thirdPartyId");
        Intrinsics.checkNotNullParameter(thirdPartyToken, "thirdPartyToken");
        this.thirdType = thirdPartyType;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.binderOrUnBinderThird(type, thirdPartyType, thirdPartyId, thirdPartyToken), new Function1() { // from class: com.qiahao.nextvideo.ui.login.k
            public final Object invoke(Object obj) {
                Unit binderOrUnBinderThird$lambda$8;
                binderOrUnBinderThird$lambda$8 = LoginViewModel.binderOrUnBinderThird$lambda$8(LoginViewModel.this, type, thirdPartyToken, (ApiResponse) obj);
                return binderOrUnBinderThird$lambda$8;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.login.l
            public final Object invoke(Object obj) {
                Unit binderOrUnBinderThird$lambda$9;
                binderOrUnBinderThird$lambda$9 = LoginViewModel.binderOrUnBinderThird$lambda$9(LoginViewModel.this, (Throwable) obj);
                return binderOrUnBinderThird$lambda$9;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void binderPhoneAndPwd(@NotNull String country, @NotNull String phone, @NotNull String pwd, @NotNull String code) {
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(pwd, "pwd");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.binderPhoneAndPwd(country, phone, pwd, code), new Function1() { // from class: com.qiahao.nextvideo.ui.login.t
            public final Object invoke(Object obj) {
                Unit binderPhoneAndPwd$lambda$4;
                binderPhoneAndPwd$lambda$4 = LoginViewModel.binderPhoneAndPwd$lambda$4(LoginViewModel.this, (ApiResponse) obj);
                return binderPhoneAndPwd$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.login.u
            public final Object invoke(Object obj) {
                Unit binderPhoneAndPwd$lambda$5;
                binderPhoneAndPwd$lambda$5 = LoginViewModel.binderPhoneAndPwd$lambda$5(LoginViewModel.this, (Throwable) obj);
                return binderPhoneAndPwd$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void changePwd(@NotNull String oldPwd, @NotNull String pwd, @NotNull String code) {
        Intrinsics.checkNotNullParameter(oldPwd, "oldPwd");
        Intrinsics.checkNotNullParameter(pwd, "pwd");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.changePwd(oldPwd, pwd, code), new Function1() { // from class: com.qiahao.nextvideo.ui.login.j
            public final Object invoke(Object obj) {
                Unit changePwd$lambda$6;
                changePwd$lambda$6 = LoginViewModel.changePwd$lambda$6(LoginViewModel.this, (ApiResponse) obj);
                return changePwd$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.login.q
            public final Object invoke(Object obj) {
                Unit changePwd$lambda$7;
                changePwd$lambda$7 = LoginViewModel.changePwd$lambda$7(LoginViewModel.this, (Throwable) obj);
                return changePwd$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void checkPhone(final int type, @NotNull String phone, @NotNull String country, @NotNull String oldCode, @NotNull String code, @NotNull String pwd) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(oldCode, "oldCode");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(pwd, "pwd");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.checkPhone(type, phone, country, oldCode, code, pwd), new Function1() { // from class: com.qiahao.nextvideo.ui.login.m
            public final Object invoke(Object obj) {
                Unit checkPhone$lambda$2;
                checkPhone$lambda$2 = LoginViewModel.checkPhone$lambda$2(type, this, (ApiResponse) obj);
                return checkPhone$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.login.n
            public final Object invoke(Object obj) {
                Unit checkPhone$lambda$3;
                checkPhone$lambda$3 = LoginViewModel.checkPhone$lambda$3(type, this, (Throwable) obj);
                return checkPhone$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void checkSMS(int type, @NotNull String phone, @NotNull String country, @NotNull String authen, int way) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(authen, "authen");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.checkSMS(type, phone, country, authen, way), new Function1() { // from class: com.qiahao.nextvideo.ui.login.o
            public final Object invoke(Object obj) {
                Unit checkSMS$lambda$10;
                checkSMS$lambda$10 = LoginViewModel.checkSMS$lambda$10(LoginViewModel.this, (ApiResponse) obj);
                return checkSMS$lambda$10;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.login.p
            public final Object invoke(Object obj) {
                Unit checkSMS$lambda$11;
                checkSMS$lambda$11 = LoginViewModel.checkSMS$lambda$11(LoginViewModel.this, (Throwable) obj);
                return checkSMS$lambda$11;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void checkSendSMS(@NotNull String phone, @NotNull String areaCode, @NotNull String authen, int way) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(areaCode, "areaCode");
        Intrinsics.checkNotNullParameter(authen, "authen");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.checkSendSMS(phone, areaCode, authen, way), new Function1() { // from class: com.qiahao.nextvideo.ui.login.r
            public final Object invoke(Object obj) {
                Unit checkSendSMS$lambda$14;
                checkSendSMS$lambda$14 = LoginViewModel.checkSendSMS$lambda$14(LoginViewModel.this, (ApiResponse) obj);
                return checkSendSMS$lambda$14;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.login.s
            public final Object invoke(Object obj) {
                Unit checkSendSMS$lambda$15;
                checkSendSMS$lambda$15 = LoginViewModel.checkSendSMS$lambda$15(LoginViewModel.this, (Throwable) obj);
                return checkSendSMS$lambda$15;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void forgotPwd(@NotNull String areaCode, @NotNull String phone, @NotNull String pwd, @NotNull String code) {
        Intrinsics.checkNotNullParameter(areaCode, "areaCode");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(pwd, "pwd");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.forgotPwd(areaCode, phone, pwd, code), new Function1() { // from class: com.qiahao.nextvideo.ui.login.v
            public final Object invoke(Object obj) {
                Unit forgotPwd$lambda$12;
                forgotPwd$lambda$12 = LoginViewModel.forgotPwd$lambda$12(LoginViewModel.this, (ApiResponse) obj);
                return forgotPwd$lambda$12;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.login.w
            public final Object invoke(Object obj) {
                Unit forgotPwd$lambda$13;
                forgotPwd$lambda$13 = LoginViewModel.forgotPwd$lambda$13(LoginViewModel.this, (Throwable) obj);
                return forgotPwd$lambda$13;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final LiveData<Boolean> getBinderOrUnBinderThird() {
        return this.binderOrUnBinderThirdMutable;
    }

    @NotNull
    public final LiveData<Boolean> getBinderPhoneAndPwd() {
        return this.binderPhoneAndPwdMutable;
    }

    @NotNull
    public final LiveData<Throwable> getChangeBindError() {
        return this.changeBindErrorMutable;
    }

    @NotNull
    public final LiveData<Boolean> getChangePwd() {
        return this.changePwdMutable;
    }

    @NotNull
    public final LiveData<Boolean> getCheckPhone() {
        return this.checkPhoneMutable;
    }

    @NotNull
    public final LiveData<Boolean> getCheckSMS() {
        return this.checkSMSMutable;
    }

    @NotNull
    public final LiveData<Boolean> getCheckSendSMS() {
        return this.checkSendSMSMutable;
    }

    @NotNull
    public final LiveData<Throwable> getError() {
        return this.errorMutable;
    }

    @NotNull
    public final LiveData<Boolean> getForgotPwd() {
        return this.forgotPwdMutable;
    }

    @NotNull
    public final LiveData<UserResponse> getLoginPhone() {
        return this.loginPhoneMutable;
    }

    @Nullable
    public final String getOldVerificationCode() {
        return this.oldVerificationCode;
    }

    @NotNull
    public final UserService getRepository() {
        return this.repository;
    }

    @Nullable
    public final Country getSelectCountry() {
        return this.selectCountry;
    }

    public final int getThirdType() {
        return this.thirdType;
    }

    public final void loginPhone(@NotNull String country, @NotNull String phone, @NotNull String pwd) {
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(pwd, "pwd");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.loginPhone(country, phone, pwd), new Function1() { // from class: com.qiahao.nextvideo.ui.login.x
            public final Object invoke(Object obj) {
                Unit loginPhone$lambda$0;
                loginPhone$lambda$0 = LoginViewModel.loginPhone$lambda$0(LoginViewModel.this, (ApiResponse) obj);
                return loginPhone$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.login.y
            public final Object invoke(Object obj) {
                Unit loginPhone$lambda$1;
                loginPhone$lambda$1 = LoginViewModel.loginPhone$lambda$1(LoginViewModel.this, (Throwable) obj);
                return loginPhone$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void resetCheckPhone() {
        MutableLiveData<Boolean> mutableLiveData = this.checkPhoneMutable;
        Boolean bool = Boolean.FALSE;
        mutableLiveData.setValue(bool);
        this.checkSMSMutable.setValue(bool);
    }

    public final void setOldVerificationCode(@Nullable String str) {
        this.oldVerificationCode = str;
    }

    public final void setSelectCountry(@Nullable Country country) {
        this.selectCountry = country;
    }

    public final void setThirdType(int i) {
        this.thirdType = i;
    }

    public LoginViewModel(@NotNull UserService userService) {
        Intrinsics.checkNotNullParameter(userService, "repository");
        this.repository = userService;
        this.thirdType = -1;
        this.loginPhoneMutable = new MutableLiveData<>();
        this.forgotPwdMutable = new MutableLiveData<>();
        this.checkSendSMSMutable = new MutableLiveData<>();
        this.checkPhoneMutable = new MutableLiveData<>();
        this.binderPhoneAndPwdMutable = new MutableLiveData<>();
        this.changePwdMutable = new MutableLiveData<>();
        this.binderOrUnBinderThirdMutable = new MutableLiveData<>();
        this.checkSMSMutable = new MutableLiveData<>();
        this.errorMutable = new MutableLiveData<>();
        this.changeBindErrorMutable = new MutableLiveData<>();
    }

    public /* synthetic */ LoginViewModel(UserService userService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserService() : userService);
    }
}
