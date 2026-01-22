package com.qiahao.nextvideo.ui.setting;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.oudi.core.utils.FragmentUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.BinderThirdType;
import com.qiahao.nextvideo.databinding.FragmentBinderBinding;
import com.qiahao.nextvideo.databinding.IncludeTitleBinding;
import com.qiahao.nextvideo.ui.login.LoginViewModel;
import com.qiahao.nextvideo.ui.login.VerificationCodeFragment;
import java.util.ArrayList;
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
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/ui/setting/BinderFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentBinderBinding;", "<init>", "()V", "getLayoutResId", "", "viewModel", "Lcom/qiahao/nextvideo/ui/login/LoginViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/login/LoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onInitialize", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBinderFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BinderFragment.kt\ncom/qiahao/nextvideo/ui/setting/BinderFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,133:1\n1#2:134\n61#3,9:135\n61#3,9:144\n61#3,9:153\n*S KotlinDebug\n*F\n+ 1 BinderFragment.kt\ncom/qiahao/nextvideo/ui/setting/BinderFragment\n*L\n61#1:135,9\n64#1:144,9\n109#1:153,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class BinderFragment extends BaseBindingFragment<FragmentBinderBinding> {

    @NotNull
    public static final String BINDING_TYPE = "binding_type";

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.setting.f
        public final Object invoke() {
            LoginViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = BinderFragment.viewModel_delegate$lambda$0(BinderFragment.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final LoginViewModel getViewModel() {
        return (LoginViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$10(BinderFragment binderFragment, Boolean bool) {
        FrameLayout frameLayout;
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            UserStore.INSTANCE.getShared().bindOrUnBindThirdSuccess(binderFragment.getViewModel().getThirdType(), false);
            cf.c.c().l(new EventBusKey("refresh_account", (Object) null, 2, (DefaultConstructorMarker) null));
            FragmentActivity activity = binderFragment.getActivity();
            if (activity != null && (frameLayout = (FrameLayout) activity.findViewById(R.id.loginFrameLayout)) != null) {
                frameLayout.setVisibility(8);
            }
            binderFragment.getParentFragmentManager().popBackStack();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$11(BinderFragment binderFragment, Throwable th) {
        String str;
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = binderFragment.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(binderFragment, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$7(BinderFragment binderFragment, int i, int i2) {
        IncludeTitleBinding includeTitleBinding;
        View view;
        FragmentBinderBinding fragmentBinderBinding = (FragmentBinderBinding) binderFragment.getBinding();
        if (fragmentBinderBinding != null && (includeTitleBinding = fragmentBinderBinding.titleBar) != null && (view = includeTitleBinding.bar) != null) {
            view.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LoginViewModel viewModel_delegate$lambda$0(BinderFragment binderFragment) {
        return new ViewModelProvider(binderFragment).get(LoginViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_binder;
    }

    public void onInitialize() {
        int i;
        ImageView imageView;
        Drawable drawable;
        View root;
        Context context;
        IncludeTitleBinding includeTitleBinding;
        AppCompatTextView appCompatTextView;
        View view;
        IncludeTitleBinding includeTitleBinding2;
        final AppCompatImageView appCompatImageView;
        IncludeTitleBinding includeTitleBinding3;
        View root2;
        IncludeTitleBinding includeTitleBinding4;
        final ConstraintLayout constraintLayout;
        final View root3;
        ImageView imageView2;
        Drawable drawable2;
        View root4;
        Context context2;
        IncludeTitleBinding includeTitleBinding5;
        AppCompatTextView appCompatTextView2;
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        LoginViewModel viewModel = getViewModel();
        Bundle arguments = getArguments();
        if (arguments != null) {
            i = arguments.getInt(BINDING_TYPE);
        } else {
            i = -1;
        }
        viewModel.setThirdType(i);
        int thirdType = getViewModel().getThirdType();
        Drawable drawable3 = null;
        if (thirdType != 2) {
            if (thirdType == 3) {
                FragmentBinderBinding fragmentBinderBinding = (FragmentBinderBinding) getBinding();
                if (fragmentBinderBinding != null && (includeTitleBinding5 = fragmentBinderBinding.titleBar) != null && (appCompatTextView2 = includeTitleBinding5.title) != null) {
                    appCompatTextView2.setText(ResourcesKtxKt.getStringById(this, 2131952662));
                }
                FragmentBinderBinding fragmentBinderBinding2 = (FragmentBinderBinding) getBinding();
                if (fragmentBinderBinding2 != null && (imageView2 = fragmentBinderBinding2.centerImage) != null) {
                    FragmentBinderBinding fragmentBinderBinding3 = (FragmentBinderBinding) getBinding();
                    if (fragmentBinderBinding3 != null && (root4 = fragmentBinderBinding3.getRoot()) != null && (context2 = root4.getContext()) != null) {
                        drawable2 = androidx.core.content.a.getDrawable(context2, R.drawable.login_unbind_facebook);
                    } else {
                        drawable2 = null;
                    }
                    imageView2.setImageDrawable(drawable2);
                }
            }
        } else {
            FragmentBinderBinding fragmentBinderBinding4 = (FragmentBinderBinding) getBinding();
            if (fragmentBinderBinding4 != null && (includeTitleBinding = fragmentBinderBinding4.titleBar) != null && (appCompatTextView = includeTitleBinding.title) != null) {
                appCompatTextView.setText(ResourcesKtxKt.getStringById(this, 2131952926));
            }
            FragmentBinderBinding fragmentBinderBinding5 = (FragmentBinderBinding) getBinding();
            if (fragmentBinderBinding5 != null && (imageView = fragmentBinderBinding5.centerImage) != null) {
                FragmentBinderBinding fragmentBinderBinding6 = (FragmentBinderBinding) getBinding();
                if (fragmentBinderBinding6 != null && (root = fragmentBinderBinding6.getRoot()) != null && (context = root.getContext()) != null) {
                    drawable = androidx.core.content.a.getDrawable(context, R.drawable.login_unbind_google);
                } else {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
            }
        }
        FragmentBinderBinding fragmentBinderBinding7 = (FragmentBinderBinding) getBinding();
        final long j = 800;
        if (fragmentBinderBinding7 != null && (root3 = fragmentBinderBinding7.getRoot()) != null) {
            root3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.BinderFragment$onInitialize$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root3) > j || (root3 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root3, currentTimeMillis);
                    }
                }
            });
        }
        FragmentBinderBinding fragmentBinderBinding8 = (FragmentBinderBinding) getBinding();
        if (fragmentBinderBinding8 != null && (constraintLayout = fragmentBinderBinding8.unbindLayout) != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.BinderFragment$onInitialize$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ArrayList<Integer> arrayList;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                        ConstraintLayout constraintLayout2 = constraintLayout;
                        BinderThirdType binderThirdType = BinderThirdType.INSTANCE;
                        User user = UserStore.INSTANCE.getShared().getUser();
                        if (user != null) {
                            arrayList = user.getThirdList();
                        } else {
                            arrayList = null;
                        }
                        if (!binderThirdType.isBinderPhone(arrayList)) {
                            Context context3 = this.getContext();
                            if (context3 != null) {
                                TipDialog tipContent = new TipDialog(context3).setTipContent(ResourcesKtxKt.getStringById(this, 2131952120));
                                final BinderFragment binderFragment = this;
                                tipContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.setting.BinderFragment$onInitialize$4$1$1
                                    public void cancel() {
                                        OnCommonDialogListener.DefaultImpls.cancel(this);
                                    }

                                    public void confirm() {
                                        VerificationCodeFragment verificationCodeFragment = new VerificationCodeFragment();
                                        Bundle bundle = new Bundle();
                                        bundle.putString("type", VerificationCodeFragment.TYPE_BIND_THIRD);
                                        verificationCodeFragment.setArguments(bundle);
                                        FragmentUtils.INSTANCE.showHideFragmentBackStack(BinderFragment.this.requireActivity().getSupportFragmentManager(), R.id.loginFrameLayout, BinderFragment.this, verificationCodeFragment, VerificationCodeFragment.TYPE_BIND_THIRD);
                                    }
                                }).show();
                                return;
                            }
                            return;
                        }
                        Context context4 = this.getContext();
                        if (context4 != null) {
                            TipDialog tipContent2 = new TipDialog(context4).setTipContent(ResourcesKtxKt.getStringById(this, 2131952354));
                            final BinderFragment binderFragment2 = this;
                            tipContent2.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.setting.BinderFragment$onInitialize$4$2$1
                                public void cancel() {
                                    OnCommonDialogListener.DefaultImpls.cancel(this);
                                }

                                public void confirm() {
                                    LoginViewModel viewModel2;
                                    LoginViewModel viewModel3;
                                    LoginViewModel viewModel4;
                                    String str;
                                    viewModel2 = BinderFragment.this.getViewModel();
                                    viewModel3 = BinderFragment.this.getViewModel();
                                    int thirdType2 = viewModel3.getThirdType();
                                    viewModel4 = BinderFragment.this.getViewModel();
                                    if (viewModel4.getThirdType() != 2) {
                                        str = "";
                                    } else {
                                        str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "google_token", "", (String) null, 4, (Object) null);
                                    }
                                    viewModel2.binderOrUnBinderThird(2, thirdType2, "", str);
                                }
                            }).show();
                        }
                    }
                }
            });
        }
        FragmentBinderBinding fragmentBinderBinding9 = (FragmentBinderBinding) getBinding();
        if (fragmentBinderBinding9 != null && (includeTitleBinding4 = fragmentBinderBinding9.titleBar) != null) {
            view = includeTitleBinding4.bar;
        } else {
            view = null;
        }
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.setting.g
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$7;
                onInitialize$lambda$7 = BinderFragment.onInitialize$lambda$7(BinderFragment.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$7;
            }
        });
        FragmentBinderBinding fragmentBinderBinding10 = (FragmentBinderBinding) getBinding();
        if (fragmentBinderBinding10 != null && (includeTitleBinding3 = fragmentBinderBinding10.titleBar) != null && (root2 = includeTitleBinding3.getRoot()) != null) {
            Context context3 = getContext();
            if (context3 != null) {
                drawable3 = androidx.core.content.a.getDrawable(context3, 2131101214);
            }
            root2.setBackground(drawable3);
        }
        FragmentBinderBinding fragmentBinderBinding11 = (FragmentBinderBinding) getBinding();
        if (fragmentBinderBinding11 != null && (includeTitleBinding2 = fragmentBinderBinding11.titleBar) != null && (appCompatImageView = includeTitleBinding2.backImageView) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.BinderFragment$onInitialize$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FrameLayout frameLayout;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                        AppCompatImageView appCompatImageView2 = appCompatImageView;
                        FragmentActivity activity = this.getActivity();
                        if (activity != null && (frameLayout = (FrameLayout) activity.findViewById(R.id.loginFrameLayout)) != null) {
                            frameLayout.setVisibility(8);
                        }
                        this.getParentFragmentManager().popBackStack();
                    }
                }
            });
        }
        getViewModel().getBinderOrUnBinderThird().observe(this, new BinderFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.setting.h
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$10;
                onInitialize$lambda$10 = BinderFragment.onInitialize$lambda$10(BinderFragment.this, (Boolean) obj);
                return onInitialize$lambda$10;
            }
        }));
        getViewModel().getError().observe(this, new BinderFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.setting.i
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$11;
                onInitialize$lambda$11 = BinderFragment.onInitialize$lambda$11(BinderFragment.this, (Throwable) obj);
                return onInitialize$lambda$11;
            }
        }));
    }
}
