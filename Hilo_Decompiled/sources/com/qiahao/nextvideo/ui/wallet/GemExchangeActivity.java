package com.qiahao.nextvideo.ui.wallet;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.CommonTextDialog;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.GemBean;
import com.qiahao.nextvideo.data.model.PurchaseDiamondDetail;
import com.qiahao.nextvideo.data.model.PurchaseFeeDetailsX;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ActivityExchangeGemBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.gem.GemExchangeAdapter;
import java.util.Arrays;
import java.util.Collection;
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
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u0004J\r\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\u0004J\u0015\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0010\u0010\u0004R\"\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/qiahao/nextvideo/ui/wallet/GemExchangeActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityExchangeGemBinding;", "<init>", "()V", "", "showDialog", "", "getLayoutResId", "()I", "onInitialize", "initData", "Lcom/qiahao/nextvideo/data/model/PurchaseDiamondDetail;", "data", "exchangeGem", "(Lcom/qiahao/nextvideo/data/model/PurchaseDiamondDetail;)V", "onDestroy", "mChangeBean", "I", "getMChangeBean", "setMChangeBean", "(I)V", "", "mChange", "F", "getMChange", "()F", "setMChange", "(F)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Lcom/qiahao/nextvideo/ui/gem/GemExchangeAdapter;", "mExchangeAdapter$delegate", "Lkotlin/Lazy;", "getMExchangeAdapter", "()Lcom/qiahao/nextvideo/ui/gem/GemExchangeAdapter;", "mExchangeAdapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGemExchangeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GemExchangeActivity.kt\ncom/qiahao/nextvideo/ui/wallet/GemExchangeActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,231:1\n61#2,9:232\n*S KotlinDebug\n*F\n+ 1 GemExchangeActivity.kt\ncom/qiahao/nextvideo/ui/wallet/GemExchangeActivity\n*L\n136#1:232,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GemExchangeActivity extends HiloBaseBindingActivity<ActivityExchangeGemBinding> {
    private float mChange;
    private int mChangeBean;

    @NotNull
    private nd.a mCompositeDisposable = new nd.a();

    /* renamed from: mExchangeAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mExchangeAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.wallet.w
        public final Object invoke() {
            GemExchangeAdapter mExchangeAdapter_delegate$lambda$0;
            mExchangeAdapter_delegate$lambda$0 = GemExchangeActivity.mExchangeAdapter_delegate$lambda$0();
            return mExchangeAdapter_delegate$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit exchangeGem$lambda$10(GemExchangeActivity gemExchangeActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = gemExchangeActivity.getString(2131952667);
                Intrinsics.checkNotNullExpressionValue(errorMessage, "getString(...)");
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, gemExchangeActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit exchangeGem$lambda$9(GemExchangeActivity gemExchangeActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        GemBean gemBean = (GemBean) apiResponse.getData();
        if (gemBean != null) {
            ((ActivityExchangeGemBinding) gemExchangeActivity.getBinding()).beansBalance.setText(String.valueOf((long) gemBean.getDiamondNum()));
            ((ActivityExchangeGemBinding) gemExchangeActivity.getBinding()).diamondBalance.setText(String.valueOf((long) gemBean.getPinkDiamondNum()));
            ((ActivityExchangeGemBinding) gemExchangeActivity.getBinding()).diamondEdit.setText(MessageService.MSG_DB_READY_REPORT);
            ((ActivityExchangeGemBinding) gemExchangeActivity.getBinding()).beansEdit.setText("");
            UserStore.INSTANCE.getShared().refreshDiamondOrGem(gemBean.getDiamondNum(), gemBean.getPinkDiamondNum());
            HiloToasty.Companion companion = HiloToasty.Companion;
            String string = gemExchangeActivity.getString(2131954177);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Toast normal$default = HiloToasty.Companion.normal$default(companion, gemExchangeActivity, string, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            cf.c.c().l(new EventBusKey("refresh_h5", (Object) null, 2, (DefaultConstructorMarker) null));
        }
        return Unit.INSTANCE;
    }

    private final GemExchangeAdapter getMExchangeAdapter() {
        return (GemExchangeAdapter) this.mExchangeAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$6(GemExchangeActivity gemExchangeActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        gemExchangeActivity.getMExchangeAdapter().setList((Collection) apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$7(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GemExchangeAdapter mExchangeAdapter_delegate$lambda$0() {
        return new GemExchangeAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$1(GemExchangeActivity gemExchangeActivity, int i, int i2) {
        gemExchangeActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onInitialize$lambda$2(final GemExchangeActivity gemExchangeActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        double d;
        Double pinkDiamondNum;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        if (HiloUtils.INSTANCE.notFastClick()) {
            final PurchaseDiamondDetail purchaseDiamondDetail = (PurchaseDiamondDetail) gemExchangeActivity.getMExchangeAdapter().getData().get(i);
            double price = purchaseDiamondDetail.getPrice();
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user != null && (pinkDiamondNum = user.getPinkDiamondNum()) != null) {
                d = pinkDiamondNum.doubleValue();
            } else {
                d = 0.0d;
            }
            if (price > d) {
                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, gemExchangeActivity, ResourcesKtxKt.getStringById(gemExchangeActivity, 2131953125), false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                    return;
                }
                return;
            }
            TipDialog tipDialog = new TipDialog(gemExchangeActivity);
            String format = String.format(ResourcesKtxKt.getStringById(gemExchangeActivity, 2131952338), Arrays.copyOf(new Object[]{Integer.valueOf((int) purchaseDiamondDetail.getPrice()), Integer.valueOf((int) purchaseDiamondDetail.getAmount())}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            tipDialog.setTipContent(format).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.wallet.GemExchangeActivity$onInitialize$2$1
                public void cancel() {
                    OnCommonDialogListener.DefaultImpls.cancel(this);
                }

                public void confirm() {
                    GemExchangeActivity.this.exchangeGem(purchaseDiamondDetail);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
    public final void showDialog() {
        ?? commonTextDialog = new CommonTextDialog(this, 0.0f, 2, null);
        String string = getString(2131952352);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        commonTextDialog.setContentText(string, true, new GemExchangeActivity$showDialog$1$1(this));
        commonTextDialog.show();
    }

    public final void exchangeGem(@NotNull PurchaseDiamondDetail data) {
        Intrinsics.checkNotNullParameter(data, "data");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().changeGemToDiamond((int) data.getPrice()), new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.u
            public final Object invoke(Object obj) {
                Unit exchangeGem$lambda$9;
                exchangeGem$lambda$9 = GemExchangeActivity.exchangeGem$lambda$9(GemExchangeActivity.this, (ApiResponse) obj);
                return exchangeGem$lambda$9;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.v
            public final Object invoke(Object obj) {
                Unit exchangeGem$lambda$10;
                exchangeGem$lambda$10 = GemExchangeActivity.exchangeGem$lambda$10(GemExchangeActivity.this, (Throwable) obj);
                return exchangeGem$lambda$10;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_exchange_gem;
    }

    public final float getMChange() {
        return this.mChange;
    }

    public final int getMChangeBean() {
        return this.mChangeBean;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    public final void initData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().gemExchangeList(1), new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.x
            public final Object invoke(Object obj) {
                Unit initData$lambda$6;
                initData$lambda$6 = GemExchangeActivity.initData$lambda$6(GemExchangeActivity.this, (ApiResponse) obj);
                return initData$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.y
            public final Object invoke(Object obj) {
                Unit initData$lambda$7;
                initData$lambda$7 = GemExchangeActivity.initData$lambda$7((Throwable) obj);
                return initData$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        this.mCompositeDisposable.d();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        float f;
        Long l;
        Double pinkDiamondNum;
        super.onInitialize();
        View view = getBinding().bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.wallet.z
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$1;
                onInitialize$lambda$1 = GemExchangeActivity.onInitialize$lambda$1(GemExchangeActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$1;
            }
        });
        getBinding().exchangeRecyclerView.setAdapter(getMExchangeAdapter());
        getMExchangeAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.a0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                GemExchangeActivity.onInitialize$lambda$2(GemExchangeActivity.this, baseQuickAdapter, view2, i);
            }
        });
        getBinding().exchangeDiamonds.setEnabled(false);
        PurchaseFeeDetailsX purchaseFeeDetail = PurchaseService.INSTANCE.getShared().getPurchaseFeeDetail();
        if (purchaseFeeDetail != null) {
            f = purchaseFeeDetail.getDiamondToGemFloat();
        } else {
            f = 0.0f;
        }
        this.mChange = f;
        TextView textView = getBinding().beansBalance;
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        Long l2 = null;
        if (user != null) {
            l = Long.valueOf((long) user.getDiamondNum());
        } else {
            l = null;
        }
        textView.setText(String.valueOf(l));
        TextView textView2 = getBinding().diamondBalance;
        User user2 = companion.getShared().getUser();
        if (user2 != null && (pinkDiamondNum = user2.getPinkDiamondNum()) != null) {
            l2 = Long.valueOf((long) pinkDiamondNum.doubleValue());
        }
        textView2.setText(String.valueOf(l2));
        getBinding().beansEdit.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.ui.wallet.GemExchangeActivity$onInitialize$3
            @Override // android.text.TextWatcher
            @SuppressLint({"SetTextI18n"})
            public void afterTextChanged(Editable s) {
                ActivityExchangeGemBinding binding;
                ActivityExchangeGemBinding binding2;
                ActivityExchangeGemBinding binding3;
                long j;
                int i;
                ActivityExchangeGemBinding binding4;
                ActivityExchangeGemBinding binding5;
                ActivityExchangeGemBinding binding6;
                ActivityExchangeGemBinding binding7;
                ActivityExchangeGemBinding binding8;
                ActivityExchangeGemBinding binding9;
                binding = GemExchangeActivity.this.getBinding();
                binding.exchangeDiamonds.setEnabled(false);
                binding2 = GemExchangeActivity.this.getBinding();
                binding2.diamondEdit.setText("");
                if (s != null && s.length() != 0) {
                    if (s.toString().length() > 9) {
                        binding9 = GemExchangeActivity.this.getBinding();
                        binding9.beansEdit.setText("10000000");
                        return;
                    }
                    int parseInt = Integer.parseInt(s.toString());
                    if (parseInt != 0 && parseInt % 10 == 0) {
                        binding3 = GemExchangeActivity.this.getBinding();
                        binding3.beansEdit.setSelection(s.length());
                        User user3 = UserStore.INSTANCE.getShared().getUser();
                        if (user3 != null) {
                            j = (long) user3.getDiamondNum();
                        } else {
                            j = 0;
                        }
                        if (j > 10000000) {
                            i = 10000000;
                        } else {
                            i = parseInt;
                        }
                        if (parseInt > i) {
                            GemExchangeActivity.this.setMChangeBean(i);
                            binding6 = GemExchangeActivity.this.getBinding();
                            binding6.beansEdit.setText(String.valueOf(GemExchangeActivity.this.getMChangeBean()));
                            binding7 = GemExchangeActivity.this.getBinding();
                            binding7.diamondEdit.setText(String.valueOf((int) (i * GemExchangeActivity.this.getMChange())));
                            binding8 = GemExchangeActivity.this.getBinding();
                            binding8.exchangeDiamonds.setEnabled(true);
                            return;
                        }
                        GemExchangeActivity gemExchangeActivity = GemExchangeActivity.this;
                        if (parseInt >= 10000000) {
                            parseInt = 10000000;
                        }
                        gemExchangeActivity.setMChangeBean(parseInt);
                        binding4 = GemExchangeActivity.this.getBinding();
                        binding4.diamondEdit.setText(String.valueOf((int) (GemExchangeActivity.this.getMChangeBean() * GemExchangeActivity.this.getMChange())));
                        binding5 = GemExchangeActivity.this.getBinding();
                        binding5.exchangeDiamonds.setEnabled(true);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        final TextView textView3 = getBinding().exchangeDiamonds;
        final long j = 800;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.GemExchangeActivity$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView3) > j || (textView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView3, currentTimeMillis);
                    this.showDialog();
                }
            }
        });
        getBinding().backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GemExchangeActivity.this.finish();
            }
        });
        initData();
    }

    public final void setMChange(float f) {
        this.mChange = f;
    }

    public final void setMChangeBean(int i) {
        this.mChangeBean = i;
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }
}
