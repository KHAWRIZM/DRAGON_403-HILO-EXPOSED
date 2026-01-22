package com.qiahao.nextvideo.ui.wallet;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.CommonTextDialog;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.BeanBaseBean;
import com.qiahao.nextvideo.data.model.BeanSet;
import com.qiahao.nextvideo.data.model.PurchaseFeeDetailsX;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ActivityExchangeDiamondsBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\u0004J\r\u0010\n\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\u0004R\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/ui/wallet/ExchangeDiamondsActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityExchangeDiamondsBinding;", "<init>", "()V", "", "getLayoutResId", "()I", "", "onInitialize", "confirmToChange", "onDestroy", "", "mChangeBean", "J", "getMChangeBean", "()J", "setMChangeBean", "(J)V", "", ExchangeDiamondsActivity.BEAN_NUM, "D", "getBeanNum", "()D", "setBeanNum", "(D)V", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExchangeDiamondsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExchangeDiamondsActivity.kt\ncom/qiahao/nextvideo/ui/wallet/ExchangeDiamondsActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,159:1\n167#2,2:160\n1#3:162\n*S KotlinDebug\n*F\n+ 1 ExchangeDiamondsActivity.kt\ncom/qiahao/nextvideo/ui/wallet/ExchangeDiamondsActivity\n*L\n53#1:160,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ExchangeDiamondsActivity extends HiloBaseBindingActivity<ActivityExchangeDiamondsBinding> {

    @NotNull
    public static final String BEAN_NUM = "beanNum";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private double beanNum;

    @NotNull
    private final nd.a compositeDisposable = new nd.a();
    private long mChangeBean;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/wallet/ExchangeDiamondsActivity$Companion;", "", "<init>", "()V", "BEAN_NUM", "", "start", "", "context", "Landroid/content/Context;", ExchangeDiamondsActivity.BEAN_NUM, "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context, double beanNum) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) ExchangeDiamondsActivity.class);
            intent.putExtra(ExchangeDiamondsActivity.BEAN_NUM, beanNum);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirmToChange$lambda$7(ExchangeDiamondsActivity exchangeDiamondsActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        BeanBaseBean beanBaseBean = (BeanBaseBean) apiResponse.getData();
        if (beanBaseBean != null) {
            exchangeDiamondsActivity.beanNum = Double.parseDouble(beanBaseBean.getBeanNum());
            double diamondNum = beanBaseBean.getDiamondNum();
            ((ActivityExchangeDiamondsBinding) exchangeDiamondsActivity.getBinding()).beansBalance.setText(String.valueOf((long) exchangeDiamondsActivity.beanNum));
            ((ActivityExchangeDiamondsBinding) exchangeDiamondsActivity.getBinding()).diamondBalance.setText(String.valueOf((long) beanBaseBean.getDiamondNum()));
            ((ActivityExchangeDiamondsBinding) exchangeDiamondsActivity.getBinding()).diamondEdit.setText(MessageService.MSG_DB_READY_REPORT);
            ((ActivityExchangeDiamondsBinding) exchangeDiamondsActivity.getBinding()).beansEdit.setText("");
            ((ActivityExchangeDiamondsBinding) exchangeDiamondsActivity.getBinding()).exchangeDiamonds.setEnabled(false);
            cf.c.c().l(new EventBusKey("REFRESH_EXCHANGE", Double.valueOf(exchangeDiamondsActivity.beanNum)));
            UserStore.Companion companion = UserStore.INSTANCE;
            User user = companion.getShared().getUser();
            if (user != null) {
                UserStore shared = companion.getShared();
                user.setDiamondNum(diamondNum);
                UserStore.refreshUserInfo$default(shared, user, null, null, false, 14, null);
            }
            HiloToasty.Companion companion2 = HiloToasty.Companion;
            String string = exchangeDiamondsActivity.getString(2131954177);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Toast normal$default = HiloToasty.Companion.normal$default(companion2, exchangeDiamondsActivity, string, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirmToChange$lambda$8(ExchangeDiamondsActivity exchangeDiamondsActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = exchangeDiamondsActivity.getString(2131952667);
                Intrinsics.checkNotNullExpressionValue(errorMessage, "getString(...)");
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, exchangeDiamondsActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$0(ExchangeDiamondsActivity exchangeDiamondsActivity, int i, int i2) {
        Toolbar toolbar = exchangeDiamondsActivity.getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        toolbar.setPadding(0, i, 0, 0);
        ViewKtxKt.setMargin(exchangeDiamondsActivity.getBinding().linearLayout, 0, 0, 0, Integer.valueOf(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
    public static final void onInitialize$lambda$2(final ExchangeDiamondsActivity exchangeDiamondsActivity, View view) {
        ?? commonTextDialog = new CommonTextDialog(exchangeDiamondsActivity, 0.0f, 2, null);
        String string = exchangeDiamondsActivity.getString(2131952352);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        commonTextDialog.setContentText(string, true, new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.wallet.ExchangeDiamondsActivity$onInitialize$3$1$1
            public void cancel() {
                OnCommonDialogListener.DefaultImpls.cancel(this);
            }

            public void confirm() {
                ExchangeDiamondsActivity.this.confirmToChange();
            }
        });
        commonTextDialog.show();
    }

    @JvmStatic
    public static final void start(@NotNull Context context, double d) {
        INSTANCE.start(context, d);
    }

    public final void confirmToChange() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().changeBeanToDiamond(this.mChangeBean), new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.h
            public final Object invoke(Object obj) {
                Unit confirmToChange$lambda$7;
                confirmToChange$lambda$7 = ExchangeDiamondsActivity.confirmToChange$lambda$7(ExchangeDiamondsActivity.this, (ApiResponse) obj);
                return confirmToChange$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.i
            public final Object invoke(Object obj) {
                Unit confirmToChange$lambda$8;
                confirmToChange$lambda$8 = ExchangeDiamondsActivity.confirmToChange$lambda$8(ExchangeDiamondsActivity.this, (Throwable) obj);
                return confirmToChange$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    public final double getBeanNum() {
        return this.beanNum;
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_exchange_diamonds;
    }

    public final long getMChangeBean() {
        return this.mChangeBean;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        this.compositeDisposable.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        final float f;
        Long l;
        BeanSet beanSet;
        super.onInitialize();
        this.beanNum = getIntent().getDoubleExtra(BEAN_NUM, 0.0d);
        Toolbar toolbar = ((ActivityExchangeDiamondsBinding) getBinding()).toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        getStatusBarTopOrBottom(toolbar, new Function2() { // from class: com.qiahao.nextvideo.ui.wallet.j
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$0;
                onInitialize$lambda$0 = ExchangeDiamondsActivity.onInitialize$lambda$0(ExchangeDiamondsActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$0;
            }
        });
        ((ActivityExchangeDiamondsBinding) getBinding()).exchangeDiamonds.setEnabled(false);
        PurchaseFeeDetailsX purchaseFeeDetail = PurchaseService.INSTANCE.getShared().getPurchaseFeeDetail();
        if (purchaseFeeDetail != null && (beanSet = purchaseFeeDetail.getBeanSet()) != null) {
            f = beanSet.getBeanToDiamond();
        } else {
            f = 0.0f;
        }
        ((ActivityExchangeDiamondsBinding) getBinding()).beansBalance.setText(String.valueOf((long) this.beanNum));
        TextView textView = ((ActivityExchangeDiamondsBinding) getBinding()).diamondBalance;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            l = Long.valueOf((long) user.getDiamondNum());
        } else {
            l = null;
        }
        textView.setText(String.valueOf(l));
        ((ActivityExchangeDiamondsBinding) getBinding()).beansEdit.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.ui.wallet.ExchangeDiamondsActivity$onInitialize$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                long beanNum;
                ActivityExchangeDiamondsBinding binding;
                ActivityExchangeDiamondsBinding binding2;
                ActivityExchangeDiamondsBinding binding3;
                ActivityExchangeDiamondsBinding binding4;
                ActivityExchangeDiamondsBinding binding5;
                ActivityExchangeDiamondsBinding binding6;
                ActivityExchangeDiamondsBinding binding7;
                ActivityExchangeDiamondsBinding binding8;
                ActivityExchangeDiamondsBinding binding9;
                ActivityExchangeDiamondsBinding binding10;
                if (String.valueOf(s).length() == 0) {
                    return;
                }
                long parseLong = Long.parseLong(String.valueOf(s));
                if (parseLong == 0) {
                    binding9 = ExchangeDiamondsActivity.this.getBinding();
                    binding9.beansEdit.setText((CharSequence) null);
                    binding10 = ExchangeDiamondsActivity.this.getBinding();
                    binding10.exchangeDiamonds.setEnabled(false);
                    return;
                }
                if (ExchangeDiamondsActivity.this.getBeanNum() < 10.0d) {
                    return;
                }
                if (ExchangeDiamondsActivity.this.getBeanNum() > 1.0E8d) {
                    beanNum = 100000000;
                } else {
                    long j = 10;
                    if (((long) ExchangeDiamondsActivity.this.getBeanNum()) % j == 0) {
                        beanNum = (long) ExchangeDiamondsActivity.this.getBeanNum();
                    } else {
                        beanNum = (((long) ExchangeDiamondsActivity.this.getBeanNum()) / j) * j;
                    }
                }
                if (parseLong > beanNum) {
                    ExchangeDiamondsActivity.this.setMChangeBean(beanNum);
                    binding5 = ExchangeDiamondsActivity.this.getBinding();
                    binding5.beansEdit.setText(String.valueOf(ExchangeDiamondsActivity.this.getMChangeBean()));
                    binding6 = ExchangeDiamondsActivity.this.getBinding();
                    binding6.beansEdit.setSelection(String.valueOf(ExchangeDiamondsActivity.this.getMChangeBean()).length());
                    binding7 = ExchangeDiamondsActivity.this.getBinding();
                    binding7.diamondEdit.setText(String.valueOf((long) (beanNum * f * 0.01d)));
                    binding8 = ExchangeDiamondsActivity.this.getBinding();
                    binding8.exchangeDiamonds.setEnabled(true);
                    return;
                }
                if (parseLong % 10 != 0) {
                    binding = ExchangeDiamondsActivity.this.getBinding();
                    binding.diamondEdit.setText(MessageService.MSG_DB_READY_REPORT);
                    binding2 = ExchangeDiamondsActivity.this.getBinding();
                    binding2.exchangeDiamonds.setEnabled(false);
                    return;
                }
                ExchangeDiamondsActivity exchangeDiamondsActivity = ExchangeDiamondsActivity.this;
                if (parseLong >= 100000000) {
                    parseLong = 100000000;
                }
                exchangeDiamondsActivity.setMChangeBean(parseLong);
                binding3 = ExchangeDiamondsActivity.this.getBinding();
                binding3.diamondEdit.setText(String.valueOf((long) (ExchangeDiamondsActivity.this.getMChangeBean() * f * 0.01d)));
                binding4 = ExchangeDiamondsActivity.this.getBinding();
                binding4.exchangeDiamonds.setEnabled(true);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        ((ActivityExchangeDiamondsBinding) getBinding()).exchangeDiamonds.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExchangeDiamondsActivity.onInitialize$lambda$2(ExchangeDiamondsActivity.this, view);
            }
        });
        ((ActivityExchangeDiamondsBinding) getBinding()).backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExchangeDiamondsActivity.this.finish();
            }
        });
    }

    public final void setBeanNum(double d) {
        this.beanNum = d;
    }

    public final void setMChangeBean(long j) {
        this.mChangeBean = j;
    }
}
