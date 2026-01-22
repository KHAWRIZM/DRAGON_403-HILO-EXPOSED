package com.qiahao.nextvideo.ui.gem;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.billingclient.api.e0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.common.BaseBindingDialogFragment;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserObjectEvent;
import com.qiahao.nextvideo.data.UserObjectEventType;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.CheckChargeData;
import com.qiahao.nextvideo.data.model.PurchaseDiamondDetail;
import com.qiahao.nextvideo.data.model.PurchaseGem;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.qiahao.nextvideo.databinding.DialogGemStoreBinding;
import com.qiahao.nextvideo.ui.feedback.FeedbackActivity;
import com.qiahao.nextvideo.ui.reusable.views.ProgressDialogWrapper;
import com.qiahao.nextvideo.ui.wallet.GemExchangeActivity;
import com.qiahao.nextvideo.ui.webview.DefaultWebActivity;
import com.qiahao.nextvideo.utilities.google.pay.BillingRepository;
import com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J3\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00132\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u0004R$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R*\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b1\u00102R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/qiahao/nextvideo/ui/gem/GemStoreDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialogFragment;", "Lcom/qiahao/nextvideo/databinding/DialogGemStoreBinding;", "<init>", "()V", "", "initView", "initData", "requestData", "Lcom/qiahao/nextvideo/data/model/PurchaseDiamondDetail;", "data", "checkWriteList", "(Lcom/qiahao/nextvideo/data/model/PurchaseDiamondDetail;)V", "", "getLayoutResId", "()I", "onInitialize", "", Constants.SHARED_MESSAGE_ID_FILE, "", "animated", "Lkotlin/Function0;", "completion", "showProgressDialog", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "dismissProgressDialog", "(ZLkotlin/jvm/functions/Function0;)V", "onDestroy", "Lcom/qiahao/nextvideo/utilities/google/pay/BillingRepository;", "mBillingRepository", "Lcom/qiahao/nextvideo/utilities/google/pay/BillingRepository;", "getMBillingRepository", "()Lcom/qiahao/nextvideo/utilities/google/pay/BillingRepository;", "setMBillingRepository", "(Lcom/qiahao/nextvideo/utilities/google/pay/BillingRepository;)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "mListener", "Lkotlin/jvm/functions/Function0;", "getMListener", "()Lkotlin/jvm/functions/Function0;", "setMListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/qiahao/nextvideo/ui/reusable/views/ProgressDialogWrapper;", "progressDialog", "Lcom/qiahao/nextvideo/ui/reusable/views/ProgressDialogWrapper;", "Lcom/qiahao/nextvideo/utilities/google/pay/GooglePayConsumeListener;", "listener$delegate", "Lkotlin/Lazy;", "getListener", "()Lcom/qiahao/nextvideo/utilities/google/pay/GooglePayConsumeListener;", "listener", "Lcom/qiahao/nextvideo/ui/gem/GemStoreAdapter;", "adapter$delegate", "getAdapter", "()Lcom/qiahao/nextvideo/ui/gem/GemStoreAdapter;", "adapter", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGemStoreDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GemStoreDialog.kt\ncom/qiahao/nextvideo/ui/gem/GemStoreDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,294:1\n61#2,9:295\n61#2,9:304\n61#2,9:313\n61#2,9:322\n61#2,9:331\n61#2,9:340\n1563#3:349\n1634#3,2:350\n1869#3,2:353\n1636#3:355\n1#4:352\n*S KotlinDebug\n*F\n+ 1 GemStoreDialog.kt\ncom/qiahao/nextvideo/ui/gem/GemStoreDialog\n*L\n143#1:295,9\n147#1:304,9\n153#1:313,9\n159#1:322,9\n166#1:331,9\n172#1:340,9\n213#1:349\n213#1:350,2\n215#1:353,2\n213#1:355\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GemStoreDialog extends BaseBindingDialogFragment<DialogGemStoreBinding> {

    @NotNull
    public static final String OTHER = "other";

    @NotNull
    public static final String VIDEO = "video";

    @Nullable
    private BillingRepository mBillingRepository;

    @Nullable
    private Function0<Unit> mListener;
    private ProgressDialogWrapper progressDialog;

    @NotNull
    private nd.a mCompositeDisposable = new nd.a();

    /* renamed from: listener$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy listener = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.gem.j
        public final Object invoke() {
            GemStoreDialog$listener$2$1 listener_delegate$lambda$0;
            listener_delegate$lambda$0 = GemStoreDialog.listener_delegate$lambda$0(GemStoreDialog.this);
            return listener_delegate$lambda$0;
        }
    });

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.gem.k
        public final Object invoke() {
            GemStoreAdapter adapter_delegate$lambda$1;
            adapter_delegate$lambda$1 = GemStoreDialog.adapter_delegate$lambda$1();
            return adapter_delegate$lambda$1;
        }
    });

    public static final /* synthetic */ DialogGemStoreBinding access$getBinding(GemStoreDialog gemStoreDialog) {
        return (DialogGemStoreBinding) gemStoreDialog.getBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GemStoreAdapter adapter_delegate$lambda$1() {
        return new GemStoreAdapter();
    }

    private final void checkWriteList(final PurchaseDiamondDetail data) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(PurchaseService.INSTANCE.getShared().checkIsChargeUser(data.getProductID()), new Function1() { // from class: com.qiahao.nextvideo.ui.gem.h
            public final Object invoke(Object obj) {
                Unit checkWriteList$lambda$22;
                checkWriteList$lambda$22 = GemStoreDialog.checkWriteList$lambda$22(GemStoreDialog.this, data, (ApiResponse) obj);
                return checkWriteList$lambda$22;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.gem.i
            public final Object invoke(Object obj) {
                Unit checkWriteList$lambda$23;
                checkWriteList$lambda$23 = GemStoreDialog.checkWriteList$lambda$23(GemStoreDialog.this, (Throwable) obj);
                return checkWriteList$lambda$23;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkWriteList$lambda$22(GemStoreDialog gemStoreDialog, PurchaseDiamondDetail purchaseDiamondDetail, final ApiResponse apiResponse) {
        boolean z;
        BillingRepository billingRepository;
        String str;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        CheckChargeData checkChargeData = (CheckChargeData) apiResponse.getData();
        if (checkChargeData != null) {
            z = Intrinsics.areEqual(checkChargeData.getInWhiteList(), Boolean.TRUE);
        } else {
            z = false;
        }
        if (z) {
            CheckChargeData checkChargeData2 = (CheckChargeData) apiResponse.getData();
            if (checkChargeData2 != null) {
                str = checkChargeData2.getChargeLink();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                dismissProgressDialog$default(gemStoreDialog, false, null, 3, null);
                final BaseActivity activity = HiloUtils.INSTANCE.getActivity(gemStoreDialog.getContext());
                if (activity != null) {
                    new TipDialog(activity).setTipContent(ResourcesKtxKt.getStringById(gemStoreDialog, 2131952204)).setConfirmContent(ResourcesKtxKt.getStringById(gemStoreDialog, 2131952331)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.gem.GemStoreDialog$checkWriteList$1$1$1
                        public void cancel() {
                            OnCommonDialogListener.DefaultImpls.cancel(this);
                        }

                        public void confirm() {
                            String str2;
                            DefaultWebActivity.Companion companion = DefaultWebActivity.INSTANCE;
                            BaseActivity baseActivity = activity;
                            CheckChargeData checkChargeData3 = (CheckChargeData) apiResponse.getData();
                            if (checkChargeData3 == null || (str2 = checkChargeData3.getChargeLink()) == null) {
                                str2 = "";
                            }
                            DefaultWebActivity.Companion.start$default(companion, baseActivity, str2, null, 4, null);
                        }
                    }).show();
                }
                return Unit.INSTANCE;
            }
        }
        BaseActivity activity2 = HiloUtils.INSTANCE.getActivity(gemStoreDialog.getContext());
        if (activity2 != null && (billingRepository = gemStoreDialog.mBillingRepository) != null) {
            BillingRepository.launchBillingFollow$default(billingRepository, activity2, purchaseDiamondDetail.getProductID(), null, 4, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkWriteList$lambda$23(GemStoreDialog gemStoreDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        dismissProgressDialog$default(gemStoreDialog, false, null, 3, null);
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = gemStoreDialog.getContext();
        String message = th.getMessage();
        if (message == null) {
            str = ResourcesKtxKt.getStringById(gemStoreDialog, 2131952667);
        } else {
            str = message;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void dismissProgressDialog$default(GemStoreDialog gemStoreDialog, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        gemStoreDialog.dismissProgressDialog(z, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dismissProgressDialog$lambda$25(GemStoreDialog gemStoreDialog, Function0 function0) {
        FrameLayout frameLayout = ((DialogGemStoreBinding) gemStoreDialog.getBinding()).frameLayout;
        ProgressDialogWrapper progressDialogWrapper = gemStoreDialog.progressDialog;
        if (progressDialogWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
            progressDialogWrapper = null;
        }
        frameLayout.removeView(progressDialogWrapper.getView());
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    private final GemStoreAdapter getAdapter() {
        return (GemStoreAdapter) this.adapter.getValue();
    }

    private final GooglePayConsumeListener getListener() {
        return (GooglePayConsumeListener) this.listener.getValue();
    }

    private final void initData() {
        Long l;
        Double pinkDiamondNum;
        UserStore.Companion companion = UserStore.INSTANCE;
        nd.c subscribe = companion.getShared().getUserObjectRelay().observeOn(RxUtilsKt.getMainThread()).subscribeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.gem.GemStoreDialog$initData$1
            public final void accept(UserObjectEvent userObjectEvent) {
                Double pinkDiamondNum2;
                if (userObjectEvent != null) {
                    GemStoreDialog gemStoreDialog = GemStoreDialog.this;
                    if (userObjectEvent.getType() == UserObjectEventType.REFRESH_MONEY) {
                        AppCompatTextView appCompatTextView = GemStoreDialog.access$getBinding(gemStoreDialog).gemNumber;
                        User user = UserStore.INSTANCE.getShared().getUser();
                        appCompatTextView.setText(String.valueOf((user == null || (pinkDiamondNum2 = user.getPinkDiamondNum()) == null) ? null : Long.valueOf(MathKt.roundToLong(pinkDiamondNum2.doubleValue()))));
                    }
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, this.mCompositeDisposable);
        requestData();
        Context context = getContext();
        if (context != null) {
            BillingRepository billingRepository = new BillingRepository(context);
            billingRepository.setDelegate(getListener());
            billingRepository.startDataSourceConnections();
            this.mBillingRepository = billingRepository;
        }
        AppCompatTextView appCompatTextView = ((DialogGemStoreBinding) getBinding()).gemNumber;
        User user = companion.getShared().getUser();
        if (user != null && (pinkDiamondNum = user.getPinkDiamondNum()) != null) {
            l = Long.valueOf(MathKt.roundToLong(pinkDiamondNum.doubleValue()));
        } else {
            l = null;
        }
        appCompatTextView.setText(String.valueOf(l));
    }

    private final void initView() {
        ((DialogGemStoreBinding) getBinding()).exchange.setText(ResourcesKtxKt.getStringById(this, 2131952459) + " >");
        ((DialogGemStoreBinding) getBinding()).recyclerView.setAdapter(getAdapter());
        final ImageView imageView = ((DialogGemStoreBinding) getBinding()).close;
        final long j = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.gem.GemStoreDialog$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        final ImageView imageView2 = ((DialogGemStoreBinding) getBinding()).gemIcon;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.gem.GemStoreDialog$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j || (imageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                    Context context = this.getContext();
                    if (context != null) {
                        String str = null;
                        new GemDetailsDialog(context, str, 2, str).show();
                        this.dismiss();
                    }
                }
            }
        });
        final AppCompatTextView appCompatTextView = ((DialogGemStoreBinding) getBinding()).gemNumber;
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.gem.GemStoreDialog$initView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatTextView) > j || (appCompatTextView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatTextView, currentTimeMillis);
                    AppCompatTextView appCompatTextView2 = appCompatTextView;
                    Context context = this.getContext();
                    if (context != null) {
                        String tag = this.getTag();
                        if (tag == null) {
                            tag = "";
                        }
                        new GemDetailsDialog(context, tag).show();
                        this.dismiss();
                    }
                }
            }
        });
        final ImageView imageView3 = ((DialogGemStoreBinding) getBinding()).toRecharge;
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.gem.GemStoreDialog$initView$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView3) > j || (imageView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView3, currentTimeMillis);
                    Context context = this.getContext();
                    if (context != null) {
                        String str = null;
                        new GemDetailsDialog(context, str, 2, str).show();
                        this.dismiss();
                    }
                }
            }
        });
        final ImageView imageView4 = ((DialogGemStoreBinding) getBinding()).contactUs;
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.gem.GemStoreDialog$initView$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView4) > j || (imageView4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView4, currentTimeMillis);
                    Context context = this.getContext();
                    if (context != null) {
                        context.startActivity(new Intent(context, (Class<?>) FeedbackActivity.class));
                    }
                }
            }
        });
        final TextView textView = ((DialogGemStoreBinding) getBinding()).exchange;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.gem.GemStoreDialog$initView$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    if (Intrinsics.areEqual(this.getTag(), "other")) {
                        this.startActivity(new Intent(this.getContext(), (Class<?>) GemExchangeActivity.class));
                    }
                }
            }
        });
        getAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.gem.n
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                GemStoreDialog.initView$lambda$12(GemStoreDialog.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$12(GemStoreDialog gemStoreDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        if (HiloUtils.INSTANCE.notFastClick()) {
            showProgressDialog$default(gemStoreDialog, null, false, null, 7, null);
            gemStoreDialog.checkWriteList((PurchaseDiamondDetail) gemStoreDialog.getAdapter().getData().get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GemStoreDialog$listener$2$1 listener_delegate$lambda$0(GemStoreDialog gemStoreDialog) {
        return new GemStoreDialog$listener$2$1(gemStoreDialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(PurchaseService.INSTANCE.getShared().requestGemDetails(), new Function1() { // from class: com.qiahao.nextvideo.ui.gem.f
            public final Object invoke(Object obj) {
                Unit requestData$lambda$18;
                requestData$lambda$18 = GemStoreDialog.requestData$lambda$18(GemStoreDialog.this, (ApiResponse) obj);
                return requestData$lambda$18;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.gem.g
            public final Object invoke(Object obj) {
                Unit requestData$lambda$19;
                requestData$lambda$19 = GemStoreDialog.requestData$lambda$19((Throwable) obj);
                return requestData$lambda$19;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestData$lambda$18(GemStoreDialog gemStoreDialog, ApiResponse apiResponse) {
        ArrayList<PurchaseDiamondDetail> buyList;
        Unit unit;
        BillingRepository billingRepository;
        List<e0> skuDetailsList;
        String str;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        PurchaseGem purchaseGem = (PurchaseGem) apiResponse.getData();
        ArrayList<PurchaseDiamondDetail> arrayList = null;
        if (purchaseGem != null && (buyList = purchaseGem.getBuyList()) != null) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(buyList, 10));
            for (PurchaseDiamondDetail purchaseDiamondDetail : buyList) {
                purchaseDiamondDetail.setShowPrice("USD " + purchaseDiamondDetail.getPrice());
                if (gemStoreDialog.getContext() != null && (billingRepository = gemStoreDialog.mBillingRepository) != null && (skuDetailsList = billingRepository.getSkuDetailsList()) != null) {
                    for (e0 e0Var : skuDetailsList) {
                        if (Intrinsics.areEqual(e0Var.b(), purchaseDiamondDetail.getProductID())) {
                            e0.b a = e0Var.a();
                            if (a == null || (str = a.a()) == null) {
                                str = "USD " + purchaseDiamondDetail.getPrice();
                            }
                            purchaseDiamondDetail.setShowPrice(str);
                        }
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                arrayList2.add(unit);
            }
        }
        GemStoreAdapter adapter = gemStoreDialog.getAdapter();
        PurchaseGem purchaseGem2 = (PurchaseGem) apiResponse.getData();
        if (purchaseGem2 != null) {
            arrayList = purchaseGem2.getBuyList();
        }
        adapter.setList(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestData$lambda$19(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showProgressDialog$default(GemStoreDialog gemStoreDialog, String str, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        gemStoreDialog.showProgressDialog(str, z, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showProgressDialog$lambda$24(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    public final void dismissProgressDialog(boolean animated, @Nullable final Function0<Unit> completion) {
        ProgressDialogWrapper progressDialogWrapper = this.progressDialog;
        ProgressDialogWrapper progressDialogWrapper2 = null;
        if (progressDialogWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
            progressDialogWrapper = null;
        }
        if (progressDialogWrapper.getView().getParent() != null) {
            ProgressDialogWrapper progressDialogWrapper3 = this.progressDialog;
            if (progressDialogWrapper3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
            } else {
                progressDialogWrapper2 = progressDialogWrapper3;
            }
            progressDialogWrapper2.hide(animated, new Function0() { // from class: com.qiahao.nextvideo.ui.gem.m
                public final Object invoke() {
                    Unit dismissProgressDialog$lambda$25;
                    dismissProgressDialog$lambda$25 = GemStoreDialog.dismissProgressDialog$lambda$25(GemStoreDialog.this, completion);
                    return dismissProgressDialog$lambda$25;
                }
            });
        }
    }

    protected int getLayoutResId() {
        return R.layout.dialog_gem_store;
    }

    @Nullable
    public final BillingRepository getMBillingRepository() {
        return this.mBillingRepository;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    @Nullable
    public final Function0<Unit> getMListener() {
        return this.mListener;
    }

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseDialogFragment*/.onDestroy();
        Function0<Unit> function0 = this.mListener;
        if (function0 != null) {
            function0.invoke();
        }
        this.mCompositeDisposable.d();
        BillingRepository billingRepository = this.mBillingRepository;
        if (billingRepository != null) {
            billingRepository.release();
        }
        this.mBillingRepository = null;
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseDialogFragment*/.onInitialize();
        initView();
        initData();
        FrameLayout frameLayout = ((DialogGemStoreBinding) getBinding()).frameLayout;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "frameLayout");
        this.progressDialog = new ProgressDialogWrapper(frameLayout);
    }

    public final void setMBillingRepository(@Nullable BillingRepository billingRepository) {
        this.mBillingRepository = billingRepository;
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }

    public final void setMListener(@Nullable Function0<Unit> function0) {
        this.mListener = function0;
    }

    public final void showProgressDialog(@NotNull String message, boolean animated, @Nullable final Function0<Unit> completion) {
        Intrinsics.checkNotNullParameter(message, Constants.SHARED_MESSAGE_ID_FILE);
        ProgressDialogWrapper progressDialogWrapper = this.progressDialog;
        ProgressDialogWrapper progressDialogWrapper2 = null;
        if (progressDialogWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
            progressDialogWrapper = null;
        }
        if (progressDialogWrapper.getView().getParent() == null) {
            ProgressDialogWrapper progressDialogWrapper3 = this.progressDialog;
            if (progressDialogWrapper3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
                progressDialogWrapper3 = null;
            }
            progressDialogWrapper3.getProgressText().setText(message);
            FrameLayout frameLayout = ((DialogGemStoreBinding) getBinding()).frameLayout;
            ProgressDialogWrapper progressDialogWrapper4 = this.progressDialog;
            if (progressDialogWrapper4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
                progressDialogWrapper4 = null;
            }
            frameLayout.addView(progressDialogWrapper4.getView());
            ProgressDialogWrapper progressDialogWrapper5 = this.progressDialog;
            if (progressDialogWrapper5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
            } else {
                progressDialogWrapper2 = progressDialogWrapper5;
            }
            progressDialogWrapper2.show(animated, new Function0() { // from class: com.qiahao.nextvideo.ui.gem.l
                public final Object invoke() {
                    Unit showProgressDialog$lambda$24;
                    showProgressDialog$lambda$24 = GemStoreDialog.showProgressDialog$lambda$24(completion);
                    return showProgressDialog$lambda$24;
                }
            });
        }
    }
}
