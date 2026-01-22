package com.qiahao.nextvideo.ui.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.oudi.core.utils.FragmentUtils;
import com.oudi.utils.KeyboardUtils;
import com.oudi.utils.TimerTask;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.TimerKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.base_common.model.common.PhoneInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.FragmentVerificationCodeBinding;
import com.qiahao.nextvideo.databinding.IncludeTitleBinding;
import com.qiahao.nextvideo.ui.authentication.VerificationCodeDialog;
import com.qiahao.nextvideo.utilities.data_utils.CountryUtils;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;
import java.io.File;
import java.util.Arrays;
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
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001d\u001a\u00020\fH\u0014J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0006H\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\u0012\u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\u001fH\u0002J\b\u0010*\u001a\u00020\u001fH\u0003J\b\u0010+\u001a\u00020\u001fH\u0002J\u0010\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020.H\u0007J\b\u0010/\u001a\u00020\u001fH\u0007J\b\u00100\u001a\u00020\u001fH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a¨\u00062"}, d2 = {"Lcom/qiahao/nextvideo/ui/login/VerificationCodeFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentVerificationCodeBinding;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "mSelectType", "", "getMSelectType", "()I", "setMSelectType", "(I)V", "timerTask", "Lcom/oudi/utils/TimerTask;", "getTimerTask", "()Lcom/oudi/utils/TimerTask;", "setTimerTask", "(Lcom/oudi/utils/TimerTask;)V", "viewModel", "Lcom/qiahao/nextvideo/ui/login/LoginViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/login/LoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getLayoutResId", "onInitialize", "", "initView", "sendVerificationCode", "data", "confirmData", "setTextChangedListener", "editText", "Landroidx/appcompat/widget/AppCompatEditText;", "checkButtonIsClick", "", "startCount", "initObserve", "refreshView", "onCountryEvent", "event", "Lcom/qiahao/base_common/model/common/Country;", "refreshCountryView", "onDestroy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVerificationCodeFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerificationCodeFragment.kt\ncom/qiahao/nextvideo/ui/login/VerificationCodeFragment\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,531:1\n61#2,9:532\n61#2,9:541\n61#2,9:550\n61#2,9:559\n61#2,9:568\n61#2,9:577\n1#3:586\n*S KotlinDebug\n*F\n+ 1 VerificationCodeFragment.kt\ncom/qiahao/nextvideo/ui/login/VerificationCodeFragment\n*L\n74#1:532,9\n75#1:541,9\n101#1:550,9\n112#1:559,9\n125#1:568,9\n147#1:577,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VerificationCodeFragment extends BaseBindingFragment<FragmentVerificationCodeBinding> {

    @NotNull
    public static final String TYPE_BIND = "bind";

    @NotNull
    public static final String TYPE_BIND_THIRD = "bind_third";

    @NotNull
    public static final String TYPE_CHANGE_BIND = "change_bind";

    @NotNull
    public static final String TYPE_CHECK_OLD_MOBILE = "check_old_mobile";

    @NotNull
    public static final String TYPE_FORGOT_PASSWORD = "forgot_password";

    @NotNull
    public static final String VERIFICATION_TYPE = "type";
    private int mSelectType;

    @Nullable
    private TimerTask timerTask;

    @NotNull
    private String type = "";

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.login.f0
        public final Object invoke() {
            LoginViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = VerificationCodeFragment.viewModel_delegate$lambda$0(VerificationCodeFragment.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L١٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x009f, code lost:
    
        if (java.lang.String.valueOf(r3).length() >= 6) goto L١٩;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean checkButtonIsClick() {
        Editable editable;
        Editable editable2;
        Editable editable3;
        AppCompatEditText appCompatEditText;
        AppCompatEditText appCompatEditText2;
        AppCompatEditText appCompatEditText3;
        AppCompatEditText appCompatEditText4;
        Button button;
        Editable editable4;
        AppCompatEditText appCompatEditText5;
        AppCompatEditText appCompatEditText6;
        boolean z = false;
        Editable editable5 = null;
        if (Intrinsics.areEqual(this.type, TYPE_CHECK_OLD_MOBILE)) {
            FragmentVerificationCodeBinding fragmentVerificationCodeBinding = (FragmentVerificationCodeBinding) getBinding();
            if (fragmentVerificationCodeBinding != null && (appCompatEditText6 = fragmentVerificationCodeBinding.phoneNumber) != null) {
                editable4 = appCompatEditText6.getText();
            } else {
                editable4 = null;
            }
            if (!TextUtils.isEmpty(editable4)) {
                FragmentVerificationCodeBinding fragmentVerificationCodeBinding2 = (FragmentVerificationCodeBinding) getBinding();
                if (fragmentVerificationCodeBinding2 != null && (appCompatEditText5 = fragmentVerificationCodeBinding2.verificationCode) != null) {
                    editable5 = appCompatEditText5.getText();
                }
            }
        } else {
            FragmentVerificationCodeBinding fragmentVerificationCodeBinding3 = (FragmentVerificationCodeBinding) getBinding();
            if (fragmentVerificationCodeBinding3 != null && (appCompatEditText4 = fragmentVerificationCodeBinding3.phoneNumber) != null) {
                editable = appCompatEditText4.getText();
            } else {
                editable = null;
            }
            if (!TextUtils.isEmpty(editable)) {
                FragmentVerificationCodeBinding fragmentVerificationCodeBinding4 = (FragmentVerificationCodeBinding) getBinding();
                if (fragmentVerificationCodeBinding4 != null && (appCompatEditText3 = fragmentVerificationCodeBinding4.verificationCode) != null) {
                    editable2 = appCompatEditText3.getText();
                } else {
                    editable2 = null;
                }
                if (!TextUtils.isEmpty(editable2)) {
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding5 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding5 != null && (appCompatEditText2 = fragmentVerificationCodeBinding5.password) != null) {
                        editable3 = appCompatEditText2.getText();
                    } else {
                        editable3 = null;
                    }
                    if (!TextUtils.isEmpty(editable3)) {
                        FragmentVerificationCodeBinding fragmentVerificationCodeBinding6 = (FragmentVerificationCodeBinding) getBinding();
                        if (fragmentVerificationCodeBinding6 != null && (appCompatEditText = fragmentVerificationCodeBinding6.password) != null) {
                            editable5 = appCompatEditText.getText();
                        }
                    }
                }
            }
        }
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding7 = (FragmentVerificationCodeBinding) getBinding();
        if (fragmentVerificationCodeBinding7 != null && (button = fragmentVerificationCodeBinding7.confirmButton) != null) {
            button.setEnabled(z);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void confirmData() {
        Editable editable;
        Editable editable2;
        AppCompatEditText appCompatEditText;
        AppCompatEditText appCompatEditText2;
        AppCompatEditText appCompatEditText3;
        String areaCode;
        Editable editable3;
        String str;
        String str2;
        Editable editable4;
        AppCompatEditText appCompatEditText4;
        AppCompatEditText appCompatEditText5;
        String name;
        AppCompatEditText appCompatEditText6;
        Editable editable5;
        Editable editable6;
        String str3;
        AppCompatEditText appCompatEditText7;
        String name2;
        AppCompatEditText appCompatEditText8;
        AppCompatEditText appCompatEditText9;
        Editable editable7;
        Editable editable8;
        AppCompatEditText appCompatEditText10;
        AppCompatEditText appCompatEditText11;
        AppCompatEditText appCompatEditText12;
        String name3;
        String str4 = this.type;
        String str5 = "";
        Editable editable9 = null;
        switch (str4.hashCode()) {
            case -1714888649:
                if (str4.equals(TYPE_FORGOT_PASSWORD)) {
                    LoginViewModel viewModel = getViewModel();
                    Country selectCountry = getViewModel().getSelectCountry();
                    if (selectCountry != null && (areaCode = selectCountry.getAreaCode()) != null) {
                        str5 = areaCode;
                    }
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding != null && (appCompatEditText3 = fragmentVerificationCodeBinding.phoneNumber) != null) {
                        editable = appCompatEditText3.getText();
                    } else {
                        editable = null;
                    }
                    String valueOf = String.valueOf(editable);
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding2 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding2 != null && (appCompatEditText2 = fragmentVerificationCodeBinding2.password) != null) {
                        editable2 = appCompatEditText2.getText();
                    } else {
                        editable2 = null;
                    }
                    String valueOf2 = String.valueOf(editable2);
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding3 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding3 != null && (appCompatEditText = fragmentVerificationCodeBinding3.verificationCode) != null) {
                        editable9 = appCompatEditText.getText();
                    }
                    viewModel.forgotPwd(str5, valueOf, valueOf2, String.valueOf(editable9));
                    return;
                }
                return;
            case -1655007380:
                if (str4.equals(TYPE_CHANGE_BIND)) {
                    LoginViewModel viewModel2 = getViewModel();
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding4 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding4 != null && (appCompatEditText6 = fragmentVerificationCodeBinding4.phoneNumber) != null) {
                        editable3 = appCompatEditText6.getText();
                    } else {
                        editable3 = null;
                    }
                    String valueOf3 = String.valueOf(editable3);
                    Country selectCountry2 = getViewModel().getSelectCountry();
                    if (selectCountry2 == null || (name = selectCountry2.getName()) == null) {
                        str = "";
                    } else {
                        str = name;
                    }
                    String oldVerificationCode = getViewModel().getOldVerificationCode();
                    if (oldVerificationCode == null) {
                        str2 = "";
                    } else {
                        str2 = oldVerificationCode;
                    }
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding5 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding5 != null && (appCompatEditText5 = fragmentVerificationCodeBinding5.verificationCode) != null) {
                        editable4 = appCompatEditText5.getText();
                    } else {
                        editable4 = null;
                    }
                    String valueOf4 = String.valueOf(editable4);
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding6 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding6 != null && (appCompatEditText4 = fragmentVerificationCodeBinding6.password) != null) {
                        editable9 = appCompatEditText4.getText();
                    }
                    viewModel2.checkPhone(2, valueOf3, str, str2, valueOf4, String.valueOf(editable9));
                    return;
                }
                return;
            case -63082159:
                if (str4.equals(TYPE_CHECK_OLD_MOBILE)) {
                    LoginViewModel viewModel3 = getViewModel();
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding7 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding7 != null && (appCompatEditText9 = fragmentVerificationCodeBinding7.verificationCode) != null) {
                        editable5 = appCompatEditText9.getText();
                    } else {
                        editable5 = null;
                    }
                    viewModel3.setOldVerificationCode(String.valueOf(editable5));
                    LoginViewModel viewModel4 = getViewModel();
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding8 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding8 != null && (appCompatEditText8 = fragmentVerificationCodeBinding8.phoneNumber) != null) {
                        editable6 = appCompatEditText8.getText();
                    } else {
                        editable6 = null;
                    }
                    String valueOf5 = String.valueOf(editable6);
                    Country selectCountry3 = getViewModel().getSelectCountry();
                    if (selectCountry3 == null || (name2 = selectCountry3.getName()) == null) {
                        str3 = "";
                    } else {
                        str3 = name2;
                    }
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding9 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding9 != null && (appCompatEditText7 = fragmentVerificationCodeBinding9.verificationCode) != null) {
                        editable9 = appCompatEditText7.getText();
                    }
                    viewModel4.checkPhone(1, valueOf5, str3, "", String.valueOf(editable9), "");
                    return;
                }
                return;
            case 3023933:
                if (!str4.equals(TYPE_BIND)) {
                    return;
                }
                break;
            case 1234119397:
                if (!str4.equals(TYPE_BIND_THIRD)) {
                    return;
                }
                break;
            default:
                return;
        }
        LoginViewModel viewModel5 = getViewModel();
        Country selectCountry4 = getViewModel().getSelectCountry();
        if (selectCountry4 != null && (name3 = selectCountry4.getName()) != null) {
            str5 = name3;
        }
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding10 = (FragmentVerificationCodeBinding) getBinding();
        if (fragmentVerificationCodeBinding10 != null && (appCompatEditText12 = fragmentVerificationCodeBinding10.phoneNumber) != null) {
            editable7 = appCompatEditText12.getText();
        } else {
            editable7 = null;
        }
        String valueOf6 = String.valueOf(editable7);
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding11 = (FragmentVerificationCodeBinding) getBinding();
        if (fragmentVerificationCodeBinding11 != null && (appCompatEditText11 = fragmentVerificationCodeBinding11.password) != null) {
            editable8 = appCompatEditText11.getText();
        } else {
            editable8 = null;
        }
        String valueOf7 = String.valueOf(editable8);
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding12 = (FragmentVerificationCodeBinding) getBinding();
        if (fragmentVerificationCodeBinding12 != null && (appCompatEditText10 = fragmentVerificationCodeBinding12.verificationCode) != null) {
            editable9 = appCompatEditText10.getText();
        }
        viewModel5.binderPhoneAndPwd(str5, valueOf6, valueOf7, String.valueOf(editable9));
    }

    private final LoginViewModel getViewModel() {
        return (LoginViewModel) this.viewModel.getValue();
    }

    @SuppressLint({"SetTextI18n"})
    private final void initObserve() {
        getViewModel().getError().observe(this, new VerificationCodeFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.login.h0
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$11;
                initObserve$lambda$11 = VerificationCodeFragment.initObserve$lambda$11(VerificationCodeFragment.this, (Throwable) obj);
                return initObserve$lambda$11;
            }
        }));
        getViewModel().getChangeBindError().observe(this, new VerificationCodeFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.login.i0
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$12;
                initObserve$lambda$12 = VerificationCodeFragment.initObserve$lambda$12(VerificationCodeFragment.this, (Throwable) obj);
                return initObserve$lambda$12;
            }
        }));
        getViewModel().getCheckSendSMS().observe(this, new VerificationCodeFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.login.j0
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$14;
                initObserve$lambda$14 = VerificationCodeFragment.initObserve$lambda$14(VerificationCodeFragment.this, (Boolean) obj);
                return initObserve$lambda$14;
            }
        }));
        getViewModel().getForgotPwd().observe(this, new VerificationCodeFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.login.k0
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$15;
                initObserve$lambda$15 = VerificationCodeFragment.initObserve$lambda$15(VerificationCodeFragment.this, (Boolean) obj);
                return initObserve$lambda$15;
            }
        }));
        getViewModel().getCheckSMS().observe(this, new VerificationCodeFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.login.l0
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$17;
                initObserve$lambda$17 = VerificationCodeFragment.initObserve$lambda$17(VerificationCodeFragment.this, (Boolean) obj);
                return initObserve$lambda$17;
            }
        }));
        getViewModel().getBinderPhoneAndPwd().observe(this, new VerificationCodeFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.login.m0
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$18;
                initObserve$lambda$18 = VerificationCodeFragment.initObserve$lambda$18(VerificationCodeFragment.this, (Boolean) obj);
                return initObserve$lambda$18;
            }
        }));
        getViewModel().getCheckPhone().observe(this, new VerificationCodeFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.login.n0
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$19;
                initObserve$lambda$19 = VerificationCodeFragment.initObserve$lambda$19(VerificationCodeFragment.this, (Boolean) obj);
                return initObserve$lambda$19;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObserve$lambda$11(VerificationCodeFragment verificationCodeFragment, Throwable th) {
        String str;
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            int code = hiloException.getCode();
            if (code != 26003) {
                if (code != 26004) {
                    if (code != 26041) {
                        if (code != 26043) {
                            if (code != 26047) {
                                HiloToasty.Companion companion = HiloToasty.Companion;
                                Context context = verificationCodeFragment.getContext();
                                String errorMessage = hiloException.getErrorMessage();
                                if (errorMessage == null) {
                                    str = ResourcesKtxKt.getStringById(verificationCodeFragment, 2131952667);
                                } else {
                                    str = errorMessage;
                                }
                                Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
                                if (normal$default != null) {
                                    normal$default.show();
                                }
                            }
                        }
                    }
                    Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, verificationCodeFragment.getContext(), ResourcesKtxKt.getStringById(verificationCodeFragment, 2131953627), false, 4, (Object) null);
                    if (normal$default2 != null) {
                        normal$default2.show();
                    }
                } else {
                    Toast normal$default3 = HiloToasty.Companion.normal$default(HiloToasty.Companion, verificationCodeFragment.getContext(), ResourcesKtxKt.getStringById(verificationCodeFragment, 2131953625), false, 4, (Object) null);
                    if (normal$default3 != null) {
                        normal$default3.show();
                    }
                }
            } else {
                Toast normal$default4 = HiloToasty.Companion.normal$default(HiloToasty.Companion, verificationCodeFragment.getContext(), ResourcesKtxKt.getStringById(verificationCodeFragment, 2131954405), false, 4, (Object) null);
                if (normal$default4 != null) {
                    normal$default4.show();
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObserve$lambda$12(VerificationCodeFragment verificationCodeFragment, Throwable th) {
        TextView textView;
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            int code = hiloException.getCode();
            if (code != 26003) {
                if (code != 26004) {
                    if (code != 26041) {
                        if (code != 26043) {
                            if (code != 26047) {
                                if (code != 26051) {
                                    HiloToasty.Companion companion = HiloToasty.Companion;
                                    Context context = verificationCodeFragment.getContext();
                                    String errorMessage = hiloException.getErrorMessage();
                                    if (errorMessage == null) {
                                        errorMessage = ResourcesKtxKt.getStringById(verificationCodeFragment, 2131952667);
                                    }
                                    Toast normal$default = HiloToasty.Companion.normal$default(companion, context, errorMessage, false, 4, (Object) null);
                                    if (normal$default != null) {
                                        normal$default.show();
                                    }
                                } else {
                                    Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, verificationCodeFragment.getContext(), ResourcesKtxKt.getStringById(verificationCodeFragment, 2131953257), false, 4, (Object) null);
                                    if (normal$default2 != null) {
                                        normal$default2.show();
                                    }
                                }
                            }
                        }
                    }
                    Toast normal$default3 = HiloToasty.Companion.normal$default(HiloToasty.Companion, verificationCodeFragment.getContext(), ResourcesKtxKt.getStringById(verificationCodeFragment, 2131953627), false, 4, (Object) null);
                    if (normal$default3 != null) {
                        normal$default3.show();
                    }
                } else {
                    Toast normal$default4 = HiloToasty.Companion.normal$default(HiloToasty.Companion, verificationCodeFragment.getContext(), ResourcesKtxKt.getStringById(verificationCodeFragment, 2131953625), false, 4, (Object) null);
                    if (normal$default4 != null) {
                        normal$default4.show();
                    }
                }
            } else {
                Toast normal$default5 = HiloToasty.Companion.normal$default(HiloToasty.Companion, verificationCodeFragment.getContext(), ResourcesKtxKt.getStringById(verificationCodeFragment, 2131954405), false, 4, (Object) null);
                if (normal$default5 != null) {
                    normal$default5.show();
                }
            }
        }
        if (Intrinsics.areEqual(verificationCodeFragment.type, TYPE_CHANGE_BIND)) {
            verificationCodeFragment.getViewModel().resetCheckPhone();
            TimerTask timerTask = verificationCodeFragment.timerTask;
            if (timerTask != null) {
                timerTask.cancel();
            }
            FragmentVerificationCodeBinding fragmentVerificationCodeBinding = (FragmentVerificationCodeBinding) verificationCodeFragment.getBinding();
            if (fragmentVerificationCodeBinding != null && (textView = fragmentVerificationCodeBinding.sendButton) != null) {
                textView.setEnabled(true);
            }
            verificationCodeFragment.timerTask = null;
            verificationCodeFragment.type = TYPE_CHECK_OLD_MOBILE;
            verificationCodeFragment.initView();
            verificationCodeFragment.refreshView();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObserve$lambda$14(VerificationCodeFragment verificationCodeFragment, Boolean bool) {
        Context context;
        if (verificationCodeFragment.mSelectType == 1 && (context = verificationCodeFragment.getContext()) != null) {
            new WhatsAppTipDialog(context).show();
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            verificationCodeFragment.startCount();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObserve$lambda$15(VerificationCodeFragment verificationCodeFragment, Boolean bool) {
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, verificationCodeFragment.getContext(), ResourcesKtxKt.getStringById(verificationCodeFragment, 2131954177), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            verificationCodeFragment.getParentFragmentManager().popBackStack();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObserve$lambda$17(VerificationCodeFragment verificationCodeFragment, Boolean bool) {
        Context context;
        if (verificationCodeFragment.mSelectType == 1 && (context = verificationCodeFragment.getContext()) != null) {
            new WhatsAppTipDialog(context).show();
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            verificationCodeFragment.startCount();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObserve$lambda$18(VerificationCodeFragment verificationCodeFragment, Boolean bool) {
        FrameLayout frameLayout;
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, verificationCodeFragment.getContext(), ResourcesKtxKt.getStringById(verificationCodeFragment, 2131954177), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            if (Intrinsics.areEqual(verificationCodeFragment.type, TYPE_BIND)) {
                cf.c.c().l(new EventBusKey("refresh_account", (Object) null, 2, (DefaultConstructorMarker) null));
                FragmentActivity activity = verificationCodeFragment.getActivity();
                if (activity != null && (frameLayout = (FrameLayout) activity.findViewById(R.id.loginFrameLayout)) != null) {
                    frameLayout.setVisibility(8);
                }
            }
            verificationCodeFragment.getParentFragmentManager().popBackStack();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObserve$lambda$19(VerificationCodeFragment verificationCodeFragment, Boolean bool) {
        TextView textView;
        FrameLayout frameLayout;
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            String str = verificationCodeFragment.type;
            if (Intrinsics.areEqual(str, TYPE_CHANGE_BIND)) {
                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, verificationCodeFragment.getContext(), ResourcesKtxKt.getStringById(verificationCodeFragment, 2131954177), false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
                FragmentActivity activity = verificationCodeFragment.getActivity();
                if (activity != null && (frameLayout = (FrameLayout) activity.findViewById(R.id.loginFrameLayout)) != null) {
                    frameLayout.setVisibility(8);
                }
                verificationCodeFragment.getParentFragmentManager().popBackStack();
                return Unit.INSTANCE;
            }
            if (Intrinsics.areEqual(str, TYPE_CHECK_OLD_MOBILE)) {
                Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, verificationCodeFragment.getContext(), ResourcesKtxKt.getStringById(verificationCodeFragment, 2131954177), false, 4, (Object) null);
                if (normal$default2 != null) {
                    normal$default2.show();
                }
                verificationCodeFragment.getViewModel().resetCheckPhone();
                TimerTask timerTask = verificationCodeFragment.timerTask;
                if (timerTask != null) {
                    timerTask.cancel();
                }
                FragmentVerificationCodeBinding fragmentVerificationCodeBinding = (FragmentVerificationCodeBinding) verificationCodeFragment.getBinding();
                if (fragmentVerificationCodeBinding != null && (textView = fragmentVerificationCodeBinding.sendButton) != null) {
                    textView.setEnabled(true);
                }
                verificationCodeFragment.timerTask = null;
                verificationCodeFragment.type = TYPE_CHANGE_BIND;
                verificationCodeFragment.initView();
                verificationCodeFragment.refreshView();
            }
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        AppCompatEditText appCompatEditText;
        AppCompatEditText appCompatEditText2;
        final Button button;
        final TextView textView;
        final ImageView imageView;
        final LinearLayout linearLayout;
        IncludeTitleBinding includeTitleBinding;
        final AppCompatImageView appCompatImageView;
        final View root;
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding = (FragmentVerificationCodeBinding) getBinding();
        final long j = 800;
        if (fragmentVerificationCodeBinding != null && (root = fragmentVerificationCodeBinding.getRoot()) != null) {
            root.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.VerificationCodeFragment$initView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                    }
                }
            });
        }
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding2 = (FragmentVerificationCodeBinding) getBinding();
        if (fragmentVerificationCodeBinding2 != null && (includeTitleBinding = fragmentVerificationCodeBinding2.titleBar) != null && (appCompatImageView = includeTitleBinding.backImageView) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.VerificationCodeFragment$initView$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FrameLayout frameLayout;
                    FrameLayout frameLayout2;
                    FrameLayout frameLayout3;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                        AppCompatImageView appCompatImageView2 = appCompatImageView;
                        String type = this.getType();
                        switch (type.hashCode()) {
                            case -1714888649:
                                if (type.equals(VerificationCodeFragment.TYPE_FORGOT_PASSWORD)) {
                                    this.getParentFragmentManager().popBackStack();
                                    return;
                                }
                                return;
                            case -1655007380:
                                if (type.equals(VerificationCodeFragment.TYPE_CHANGE_BIND)) {
                                    FragmentActivity activity = this.getActivity();
                                    if (activity != null && (frameLayout = (FrameLayout) activity.findViewById(R.id.loginFrameLayout)) != null) {
                                        frameLayout.setVisibility(8);
                                    }
                                    this.getParentFragmentManager().popBackStack();
                                    return;
                                }
                                return;
                            case -63082159:
                                if (type.equals(VerificationCodeFragment.TYPE_CHECK_OLD_MOBILE)) {
                                    FragmentActivity activity2 = this.getActivity();
                                    if (activity2 != null && (frameLayout2 = (FrameLayout) activity2.findViewById(R.id.loginFrameLayout)) != null) {
                                        frameLayout2.setVisibility(8);
                                    }
                                    this.getParentFragmentManager().popBackStack();
                                    return;
                                }
                                return;
                            case 3023933:
                                if (type.equals(VerificationCodeFragment.TYPE_BIND)) {
                                    FragmentActivity activity3 = this.getActivity();
                                    if (activity3 != null && (frameLayout3 = (FrameLayout) activity3.findViewById(R.id.loginFrameLayout)) != null) {
                                        frameLayout3.setVisibility(8);
                                    }
                                    this.getParentFragmentManager().popBackStack();
                                    return;
                                }
                                return;
                            case 1234119397:
                                if (type.equals(VerificationCodeFragment.TYPE_BIND_THIRD)) {
                                    this.getParentFragmentManager().popBackStack();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding3 = (FragmentVerificationCodeBinding) getBinding();
        if (fragmentVerificationCodeBinding3 != null && (linearLayout = fragmentVerificationCodeBinding3.selectCountryLayout) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.VerificationCodeFragment$initView$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout) > j || (linearLayout instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(linearLayout, currentTimeMillis);
                        KeyboardUtils.hideSoftInput(this.getActivity());
                        FragmentUtils.INSTANCE.showHideFragmentBackStack(this.requireActivity().getSupportFragmentManager(), R.id.loginFrameLayout, this, SelectCountryFragment.Companion.createFragment(SelectCountryFragment.TYPE_VERIFICATION), "SelectCountryFragment");
                    }
                }
            });
        }
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding4 = (FragmentVerificationCodeBinding) getBinding();
        if (fragmentVerificationCodeBinding4 != null && (imageView = fragmentVerificationCodeBinding4.viewPassword) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.VerificationCodeFragment$initView$$inlined$singleClick$default$4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AppCompatEditText appCompatEditText3;
                    AppCompatEditText appCompatEditText4;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                        ImageView imageView2 = (ImageView) imageView;
                        if (Intrinsics.areEqual(imageView2.getTag(), 1)) {
                            imageView2.setTag(2);
                            imageView2.setImageDrawable(androidx.core.content.a.getDrawable(imageView2.getContext(), R.drawable.login_icon_display));
                            FragmentVerificationCodeBinding fragmentVerificationCodeBinding5 = (FragmentVerificationCodeBinding) this.getBinding();
                            if (fragmentVerificationCodeBinding5 != null && (appCompatEditText4 = fragmentVerificationCodeBinding5.password) != null) {
                                appCompatEditText4.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                                return;
                            }
                            return;
                        }
                        imageView2.setTag(1);
                        imageView2.setImageDrawable(androidx.core.content.a.getDrawable(imageView2.getContext(), R.drawable.login_icon_donotshow));
                        FragmentVerificationCodeBinding fragmentVerificationCodeBinding6 = (FragmentVerificationCodeBinding) this.getBinding();
                        if (fragmentVerificationCodeBinding6 != null && (appCompatEditText3 = fragmentVerificationCodeBinding6.password) != null) {
                            appCompatEditText3.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        }
                    }
                }
            });
        }
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding5 = (FragmentVerificationCodeBinding) getBinding();
        if (fragmentVerificationCodeBinding5 != null && (textView = fragmentVerificationCodeBinding5.sendButton) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.VerificationCodeFragment$initView$$inlined$singleClick$default$5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Editable editable;
                    AppCompatEditText appCompatEditText3;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                        FragmentVerificationCodeBinding fragmentVerificationCodeBinding6 = (FragmentVerificationCodeBinding) this.getBinding();
                        if (fragmentVerificationCodeBinding6 != null && (appCompatEditText3 = fragmentVerificationCodeBinding6.phoneNumber) != null) {
                            editable = appCompatEditText3.getText();
                        } else {
                            editable = null;
                        }
                        if (TextUtils.isEmpty(editable)) {
                            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.getContext(), ResourcesKtxKt.getStringById(this, 2131953625), false, 4, (Object) null);
                            if (normal$default != null) {
                                normal$default.show();
                                return;
                            }
                            return;
                        }
                        final Context context = this.getContext();
                        if (context != null) {
                            VerificationCodeDialog verificationCodeDialog = new VerificationCodeDialog(context);
                            final VerificationCodeFragment verificationCodeFragment = this;
                            verificationCodeDialog.setMListener(new Function1<Integer, Unit>() { // from class: com.qiahao.nextvideo.ui.login.VerificationCodeFragment$initView$5$1$1$1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(int i) {
                                    VerificationCodeFragment.this.setMSelectType(i);
                                    VerifyDialog verifyDialog = new VerifyDialog(context);
                                    final VerificationCodeFragment verificationCodeFragment2 = VerificationCodeFragment.this;
                                    verifyDialog.setListener(new Function1<String, Unit>() { // from class: com.qiahao.nextvideo.ui.login.VerificationCodeFragment$initView$5$1$1$1$1$1
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((String) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(String str) {
                                            Intrinsics.checkNotNullParameter(str, "it");
                                            VerificationCodeFragment.this.sendVerificationCode(str);
                                        }
                                    });
                                    verifyDialog.show();
                                }
                            });
                            verificationCodeDialog.show();
                        }
                    }
                }
            });
        }
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding6 = (FragmentVerificationCodeBinding) getBinding();
        if (fragmentVerificationCodeBinding6 != null && (button = fragmentVerificationCodeBinding6.confirmButton) != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.login.VerificationCodeFragment$initView$$inlined$singleClick$default$6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(button) > j || (button instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(button, currentTimeMillis);
                        this.confirmData();
                    }
                }
            });
        }
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding7 = (FragmentVerificationCodeBinding) getBinding();
        AppCompatEditText appCompatEditText3 = null;
        if (fragmentVerificationCodeBinding7 != null) {
            appCompatEditText = fragmentVerificationCodeBinding7.phoneNumber;
        } else {
            appCompatEditText = null;
        }
        setTextChangedListener(appCompatEditText);
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding8 = (FragmentVerificationCodeBinding) getBinding();
        if (fragmentVerificationCodeBinding8 != null) {
            appCompatEditText2 = fragmentVerificationCodeBinding8.verificationCode;
        } else {
            appCompatEditText2 = null;
        }
        setTextChangedListener(appCompatEditText2);
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding9 = (FragmentVerificationCodeBinding) getBinding();
        if (fragmentVerificationCodeBinding9 != null) {
            appCompatEditText3 = fragmentVerificationCodeBinding9.password;
        }
        setTextChangedListener(appCompatEditText3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
    
        if (r1.equals(com.qiahao.nextvideo.ui.login.VerificationCodeFragment.TYPE_BIND_THIRD) == false) goto L١٩٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006f, code lost:
    
        r1 = getViewModel();
        r2 = getContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0077, code lost:
    
        if (r2 == null) goto L٣٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0079, code lost:
    
        r2 = com.qiahao.nextvideo.utilities.data_utils.CountryUtils.INSTANCE.getDefaultCountryISO(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0081, code lost:
    
        r1.setSelectCountry(r2);
        r1 = (com.qiahao.nextvideo.databinding.FragmentVerificationCodeBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008a, code lost:
    
        if (r1 == null) goto L٤٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008c, code lost:
    
        r1 = r1.titleBar;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008e, code lost:
    
        if (r1 == null) goto L٤٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0090, code lost:
    
        r1 = r1.title;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0092, code lost:
    
        if (r1 == null) goto L٤٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0094, code lost:
    
        r1.setText(com.oudi.utils.ktx.ResourcesKtxKt.getStringById(r23, 2131952117));
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009b, code lost:
    
        r1 = (com.qiahao.nextvideo.databinding.FragmentVerificationCodeBinding) getBinding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a1, code lost:
    
        if (r1 == null) goto L١٩٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a3, code lost:
    
        r1 = r1.confirmButton;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a5, code lost:
    
        if (r1 == null) goto L١٩٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a7, code lost:
    
        r1.setText(com.oudi.utils.ktx.ResourcesKtxKt.getStringById(r23, 2131952115));
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0080, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006b, code lost:
    
        if (r1.equals(com.qiahao.nextvideo.ui.login.VerificationCodeFragment.TYPE_BIND) == false) goto L١٩٥;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void refreshView() {
        View view;
        TextView textView;
        QMUIRadiusImageView2 qMUIRadiusImageView2;
        String str;
        Country country;
        IncludeTitleBinding includeTitleBinding;
        AppCompatTextView appCompatTextView;
        PhoneInfo phoneInfo;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        IncludeTitleBinding includeTitleBinding2;
        AppCompatTextView appCompatTextView2;
        TextView textView2;
        AppCompatEditText appCompatEditText;
        AppCompatEditText appCompatEditText2;
        String phoneCountry;
        String areaCode;
        String phoneCountry2;
        String icon;
        String phoneCountry3;
        ConstraintLayout constraintLayout;
        PhoneInfo phoneInfo2;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        IncludeTitleBinding includeTitleBinding3;
        AppCompatTextView appCompatTextView3;
        TextView textView3;
        AppCompatEditText appCompatEditText3;
        AppCompatEditText appCompatEditText4;
        String str12;
        String phoneCountry4;
        String areaCode2;
        String phoneCountry5;
        String icon2;
        String phoneCountry6;
        ConstraintLayout constraintLayout2;
        IncludeTitleBinding includeTitleBinding4;
        AppCompatEditText appCompatEditText5;
        AppCompatEditText appCompatEditText6;
        AppCompatEditText appCompatEditText7;
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding = (FragmentVerificationCodeBinding) getBinding();
        if (fragmentVerificationCodeBinding != null && (appCompatEditText7 = fragmentVerificationCodeBinding.phoneNumber) != null) {
            appCompatEditText7.setText("");
        }
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding2 = (FragmentVerificationCodeBinding) getBinding();
        if (fragmentVerificationCodeBinding2 != null && (appCompatEditText6 = fragmentVerificationCodeBinding2.verificationCode) != null) {
            appCompatEditText6.setText("");
        }
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding3 = (FragmentVerificationCodeBinding) getBinding();
        if (fragmentVerificationCodeBinding3 != null && (appCompatEditText5 = fragmentVerificationCodeBinding3.password) != null) {
            appCompatEditText5.setText("");
        }
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding4 = (FragmentVerificationCodeBinding) getBinding();
        String str13 = null;
        if (fragmentVerificationCodeBinding4 != null && (includeTitleBinding4 = fragmentVerificationCodeBinding4.titleBar) != null) {
            view = includeTitleBinding4.bar;
        } else {
            view = null;
        }
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.login.o0
            public final Object invoke(Object obj, Object obj2) {
                Unit refreshView$lambda$20;
                refreshView$lambda$20 = VerificationCodeFragment.refreshView$lambda$20(VerificationCodeFragment.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return refreshView$lambda$20;
            }
        });
        String str14 = this.type;
        switch (str14.hashCode()) {
            case -1714888649:
                if (str14.equals(TYPE_FORGOT_PASSWORD)) {
                    LoginViewModel viewModel = getViewModel();
                    Context context = getContext();
                    if (context != null) {
                        country = CountryUtils.INSTANCE.getDefaultCountryISO(context);
                    } else {
                        country = null;
                    }
                    viewModel.setSelectCountry(country);
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding5 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding5 != null && (includeTitleBinding = fragmentVerificationCodeBinding5.titleBar) != null && (appCompatTextView = includeTitleBinding.title) != null) {
                        appCompatTextView.setText(ResourcesKtxKt.getStringById(this, 2131953261));
                        break;
                    }
                }
                break;
            case -1655007380:
                if (str14.equals(TYPE_CHANGE_BIND)) {
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding6 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding6 != null && (constraintLayout = fragmentVerificationCodeBinding6.passwordLayout) != null) {
                        constraintLayout.setVisibility(0);
                    }
                    User user = UserStore.INSTANCE.getShared().getUser();
                    if (user != null) {
                        phoneInfo = user.getPhoneInfo();
                    } else {
                        phoneInfo = null;
                    }
                    LoginViewModel viewModel2 = getViewModel();
                    if (phoneInfo == null || (phoneCountry3 = phoneInfo.getPhoneCountry()) == null) {
                        str2 = "";
                    } else {
                        str2 = phoneCountry3;
                    }
                    if (phoneInfo == null || (icon = phoneInfo.getIcon()) == null) {
                        str3 = "";
                    } else {
                        str3 = icon;
                    }
                    if (phoneInfo == null || (phoneCountry2 = phoneInfo.getPhoneCountry()) == null) {
                        str4 = "";
                    } else {
                        str4 = phoneCountry2;
                    }
                    if (phoneInfo == null || (areaCode = phoneInfo.getAreaCode()) == null) {
                        str5 = "";
                    } else {
                        str5 = areaCode;
                    }
                    if (phoneInfo == null || (phoneCountry = phoneInfo.getPhoneCountry()) == null) {
                        str6 = "";
                    } else {
                        str6 = phoneCountry;
                    }
                    viewModel2.setSelectCountry(new Country(str2, str3, str4, 0L, str5, str6));
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding7 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding7 != null && (appCompatEditText2 = fragmentVerificationCodeBinding7.phoneNumber) != null) {
                        appCompatEditText2.setText("");
                    }
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding8 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding8 != null && (appCompatEditText = fragmentVerificationCodeBinding8.verificationCode) != null) {
                        appCompatEditText.setText("");
                    }
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding9 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding9 != null && (textView2 = fragmentVerificationCodeBinding9.sendButton) != null) {
                        textView2.setText(ResourcesKtxKt.getStringById(this, 2131954022));
                    }
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding10 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding10 != null && (includeTitleBinding2 = fragmentVerificationCodeBinding10.titleBar) != null && (appCompatTextView2 = includeTitleBinding2.title) != null) {
                        appCompatTextView2.setText(ResourcesKtxKt.getStringById(this, 2131952117));
                        break;
                    }
                }
                break;
            case -63082159:
                if (str14.equals(TYPE_CHECK_OLD_MOBILE)) {
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding11 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding11 != null && (constraintLayout2 = fragmentVerificationCodeBinding11.passwordLayout) != null) {
                        constraintLayout2.setVisibility(8);
                    }
                    User user2 = UserStore.INSTANCE.getShared().getUser();
                    if (user2 != null) {
                        phoneInfo2 = user2.getPhoneInfo();
                    } else {
                        phoneInfo2 = null;
                    }
                    LoginViewModel viewModel3 = getViewModel();
                    if (phoneInfo2 == null || (phoneCountry6 = phoneInfo2.getPhoneCountry()) == null) {
                        str7 = "";
                    } else {
                        str7 = phoneCountry6;
                    }
                    if (phoneInfo2 == null || (icon2 = phoneInfo2.getIcon()) == null) {
                        str8 = "";
                    } else {
                        str8 = icon2;
                    }
                    if (phoneInfo2 == null || (phoneCountry5 = phoneInfo2.getPhoneCountry()) == null) {
                        str9 = "";
                    } else {
                        str9 = phoneCountry5;
                    }
                    if (phoneInfo2 == null || (areaCode2 = phoneInfo2.getAreaCode()) == null) {
                        str10 = "";
                    } else {
                        str10 = areaCode2;
                    }
                    if (phoneInfo2 == null || (phoneCountry4 = phoneInfo2.getPhoneCountry()) == null) {
                        str11 = "";
                    } else {
                        str11 = phoneCountry4;
                    }
                    viewModel3.setSelectCountry(new Country(str7, str8, str9, 0L, str10, str11));
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding12 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding12 != null && (appCompatEditText4 = fragmentVerificationCodeBinding12.phoneNumber) != null) {
                        if (phoneInfo2 == null || (str12 = phoneInfo2.getPhone()) == null) {
                            str12 = "";
                        }
                        appCompatEditText4.setText(str12);
                    }
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding13 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding13 != null && (appCompatEditText3 = fragmentVerificationCodeBinding13.verificationCode) != null) {
                        appCompatEditText3.setText("");
                    }
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding14 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding14 != null && (textView3 = fragmentVerificationCodeBinding14.sendButton) != null) {
                        textView3.setText(ResourcesKtxKt.getStringById(this, 2131954022));
                    }
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding15 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding15 != null && (includeTitleBinding3 = fragmentVerificationCodeBinding15.titleBar) != null && (appCompatTextView3 = includeTitleBinding3.title) != null) {
                        appCompatTextView3.setText(ResourcesKtxKt.getStringById(this, 2131952246));
                        break;
                    }
                }
                break;
            case 3023933:
                break;
            case 1234119397:
                break;
        }
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding16 = (FragmentVerificationCodeBinding) getBinding();
        if (fragmentVerificationCodeBinding16 != null && (qMUIRadiusImageView2 = fragmentVerificationCodeBinding16.countryIcon) != null) {
            Country selectCountry = getViewModel().getSelectCountry();
            if (selectCountry != null) {
                str = selectCountry.getIcon();
            } else {
                str = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        }
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding17 = (FragmentVerificationCodeBinding) getBinding();
        if (fragmentVerificationCodeBinding17 != null && (textView = fragmentVerificationCodeBinding17.countryPhone) != null) {
            Country selectCountry2 = getViewModel().getSelectCountry();
            if (selectCountry2 != null) {
                str13 = selectCountry2.getAreaCode();
            }
            textView.setText("+" + str13);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refreshView$lambda$20(VerificationCodeFragment verificationCodeFragment, int i, int i2) {
        IncludeTitleBinding includeTitleBinding;
        View view;
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding = (FragmentVerificationCodeBinding) verificationCodeFragment.getBinding();
        if (fragmentVerificationCodeBinding != null && (includeTitleBinding = fragmentVerificationCodeBinding.titleBar) != null && (view = includeTitleBinding.bar) != null) {
            view.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendVerificationCode(String data) {
        String str;
        String areaCode;
        AppCompatEditText appCompatEditText;
        Editable text;
        String str2;
        String name;
        AppCompatEditText appCompatEditText2;
        AppCompatEditText appCompatEditText3;
        String str3;
        String str4;
        String name2;
        AppCompatEditText appCompatEditText4;
        Editable text2;
        String obj;
        String str5 = this.type;
        Editable editable = null;
        String str6 = "";
        switch (str5.hashCode()) {
            case -1714888649:
                if (str5.equals(TYPE_FORGOT_PASSWORD)) {
                    LoginViewModel viewModel = getViewModel();
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding == null || (appCompatEditText = fragmentVerificationCodeBinding.phoneNumber) == null || (text = appCompatEditText.getText()) == null || (str = text.toString()) == null) {
                        str = "";
                    }
                    Country selectCountry = getViewModel().getSelectCountry();
                    if (selectCountry != null && (areaCode = selectCountry.getAreaCode()) != null) {
                        str6 = areaCode;
                    }
                    viewModel.checkSendSMS(str, str6, data, this.mSelectType);
                    return;
                }
                return;
            case -1655007380:
                if (str5.equals(TYPE_CHANGE_BIND)) {
                    LoginViewModel viewModel2 = getViewModel();
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding2 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding2 != null && (appCompatEditText2 = fragmentVerificationCodeBinding2.phoneNumber) != null) {
                        editable = appCompatEditText2.getText();
                    }
                    String valueOf = String.valueOf(editable);
                    Country selectCountry2 = getViewModel().getSelectCountry();
                    if (selectCountry2 == null || (name = selectCountry2.getName()) == null) {
                        str2 = "";
                    } else {
                        str2 = name;
                    }
                    viewModel2.checkSMS(2, valueOf, str2, data, this.mSelectType);
                    return;
                }
                return;
            case -63082159:
                if (str5.equals(TYPE_CHECK_OLD_MOBILE)) {
                    LoginViewModel viewModel3 = getViewModel();
                    FragmentVerificationCodeBinding fragmentVerificationCodeBinding3 = (FragmentVerificationCodeBinding) getBinding();
                    if (fragmentVerificationCodeBinding3 != null && (appCompatEditText3 = fragmentVerificationCodeBinding3.phoneNumber) != null) {
                        editable = appCompatEditText3.getText();
                    }
                    viewModel3.checkSMS(1, String.valueOf(editable), "", data, this.mSelectType);
                    return;
                }
                return;
            case 3023933:
                if (!str5.equals(TYPE_BIND)) {
                    return;
                }
                break;
            case 1234119397:
                if (!str5.equals(TYPE_BIND_THIRD)) {
                    return;
                }
                break;
            default:
                return;
        }
        LoginViewModel viewModel4 = getViewModel();
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding4 = (FragmentVerificationCodeBinding) getBinding();
        if (fragmentVerificationCodeBinding4 == null || (appCompatEditText4 = fragmentVerificationCodeBinding4.phoneNumber) == null || (text2 = appCompatEditText4.getText()) == null || (obj = text2.toString()) == null) {
            str3 = "";
        } else {
            str3 = obj;
        }
        Country selectCountry3 = getViewModel().getSelectCountry();
        if (selectCountry3 == null || (name2 = selectCountry3.getName()) == null) {
            str4 = "";
        } else {
            str4 = name2;
        }
        viewModel4.checkSMS(2, str3, str4, data, this.mSelectType);
    }

    private final void setTextChangedListener(AppCompatEditText editText) {
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.ui.login.VerificationCodeFragment$setTextChangedListener$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    VerificationCodeFragment.this.checkButtonIsClick();
                }
            });
        }
    }

    private final void startCount() {
        TextView textView;
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding = (FragmentVerificationCodeBinding) getBinding();
        if (fragmentVerificationCodeBinding != null && (textView = fragmentVerificationCodeBinding.sendButton) != null) {
            textView.setEnabled(false);
        }
        this.timerTask = TimerKtxKt.countTask(this, false, true, 60L, 1000L, new Function1() { // from class: com.qiahao.nextvideo.ui.login.p0
            public final Object invoke(Object obj) {
                Unit startCount$lambda$9;
                startCount$lambda$9 = VerificationCodeFragment.startCount$lambda$9(VerificationCodeFragment.this, ((Long) obj).longValue());
                return startCount$lambda$9;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.ui.login.g0
            public final Object invoke() {
                Unit startCount$lambda$10;
                startCount$lambda$10 = VerificationCodeFragment.startCount$lambda$10(VerificationCodeFragment.this);
                return startCount$lambda$10;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startCount$lambda$10(VerificationCodeFragment verificationCodeFragment) {
        TextView textView;
        TextView textView2;
        verificationCodeFragment.timerTask = null;
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding = (FragmentVerificationCodeBinding) verificationCodeFragment.getBinding();
        if (fragmentVerificationCodeBinding != null && (textView2 = fragmentVerificationCodeBinding.sendButton) != null) {
            textView2.setEnabled(true);
        }
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding2 = (FragmentVerificationCodeBinding) verificationCodeFragment.getBinding();
        if (fragmentVerificationCodeBinding2 != null && (textView = fragmentVerificationCodeBinding2.sendButton) != null) {
            textView.setText(ResourcesKtxKt.getStringById(verificationCodeFragment, 2131954022));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startCount$lambda$9(VerificationCodeFragment verificationCodeFragment, long j) {
        TextView textView;
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding = (FragmentVerificationCodeBinding) verificationCodeFragment.getBinding();
        if (fragmentVerificationCodeBinding != null && (textView = fragmentVerificationCodeBinding.sendButton) != null) {
            String format = String.format(ResourcesKtxKt.getStringById(verificationCodeFragment, 2131952390), Arrays.copyOf(new Object[]{Long.valueOf(j)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LoginViewModel viewModel_delegate$lambda$0(VerificationCodeFragment verificationCodeFragment) {
        return new ViewModelProvider(verificationCodeFragment).get(LoginViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_verification_code;
    }

    public final int getMSelectType() {
        return this.mSelectType;
    }

    @Nullable
    public final TimerTask getTimerTask() {
        return this.timerTask;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onCountryEvent(@NotNull Country event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getCountryType(), SelectCountryFragment.TYPE_VERIFICATION)) {
            getViewModel().setSelectCountry(event);
            refreshCountryView();
        }
    }

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        TimerTask timerTask = this.timerTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        this.timerTask = null;
    }

    public void onInitialize() {
        String str;
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("type")) == null) {
            str = "";
        }
        this.type = str;
        initView();
        initObserve();
        refreshView();
    }

    @SuppressLint({"SetTextI18n"})
    public final void refreshCountryView() {
        TextView textView;
        QMUIRadiusImageView2 qMUIRadiusImageView2;
        String str;
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding = (FragmentVerificationCodeBinding) getBinding();
        String str2 = null;
        if (fragmentVerificationCodeBinding != null && (qMUIRadiusImageView2 = fragmentVerificationCodeBinding.countryIcon) != null) {
            Country selectCountry = getViewModel().getSelectCountry();
            if (selectCountry != null) {
                str = selectCountry.getIcon();
            } else {
                str = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        }
        FragmentVerificationCodeBinding fragmentVerificationCodeBinding2 = (FragmentVerificationCodeBinding) getBinding();
        if (fragmentVerificationCodeBinding2 != null && (textView = fragmentVerificationCodeBinding2.countryPhone) != null) {
            Country selectCountry2 = getViewModel().getSelectCountry();
            if (selectCountry2 != null) {
                str2 = selectCountry2.getAreaCode();
            }
            textView.setText("+" + str2);
        }
    }

    public final void setMSelectType(int i) {
        this.mSelectType = i;
    }

    public final void setTimerTask(@Nullable TimerTask timerTask) {
        this.timerTask = timerTask;
    }

    public final void setType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }
}
