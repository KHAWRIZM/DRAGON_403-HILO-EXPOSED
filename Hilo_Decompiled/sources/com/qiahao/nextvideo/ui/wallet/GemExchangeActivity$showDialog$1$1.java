package com.qiahao.nextvideo.ui.wallet;

import android.widget.TextView;
import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.ExchangeGem;
import com.qiahao.nextvideo.databinding.ActivityExchangeGemBinding;
import com.qiahao.nextvideo.network.AppServer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.message.MessageService;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/qiahao/nextvideo/ui/wallet/GemExchangeActivity$showDialog$1$1", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "confirm", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GemExchangeActivity$showDialog$1$1 implements OnCommonDialogListener {
    final /* synthetic */ GemExchangeActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GemExchangeActivity$showDialog$1$1(GemExchangeActivity gemExchangeActivity) {
        this.this$0 = gemExchangeActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirm$lambda$0(GemExchangeActivity gemExchangeActivity, ApiResponse apiResponse) {
        ActivityExchangeGemBinding binding;
        Long l;
        ActivityExchangeGemBinding binding2;
        ActivityExchangeGemBinding binding3;
        ActivityExchangeGemBinding binding4;
        double d;
        Double pinkDiamondNum;
        Double diamondNum;
        Double pinkDiamondNum2;
        Double diamondNum2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        binding = gemExchangeActivity.getBinding();
        TextView textView = binding.beansBalance;
        ExchangeGem exchangeGem = (ExchangeGem) apiResponse.getData();
        Long l2 = null;
        if (exchangeGem != null && (diamondNum2 = exchangeGem.getDiamondNum()) != null) {
            l = Long.valueOf((long) diamondNum2.doubleValue());
        } else {
            l = null;
        }
        textView.setText(String.valueOf(l));
        binding2 = gemExchangeActivity.getBinding();
        TextView textView2 = binding2.diamondBalance;
        ExchangeGem exchangeGem2 = (ExchangeGem) apiResponse.getData();
        if (exchangeGem2 != null && (pinkDiamondNum2 = exchangeGem2.getPinkDiamondNum()) != null) {
            l2 = Long.valueOf((long) pinkDiamondNum2.doubleValue());
        }
        textView2.setText(String.valueOf(l2));
        binding3 = gemExchangeActivity.getBinding();
        binding3.diamondEdit.setText(MessageService.MSG_DB_READY_REPORT);
        binding4 = gemExchangeActivity.getBinding();
        binding4.beansEdit.setText("");
        UserStore shared = UserStore.INSTANCE.getShared();
        ExchangeGem exchangeGem3 = (ExchangeGem) apiResponse.getData();
        double d2 = 0.0d;
        if (exchangeGem3 != null && (diamondNum = exchangeGem3.getDiamondNum()) != null) {
            d = diamondNum.doubleValue();
        } else {
            d = 0.0d;
        }
        ExchangeGem exchangeGem4 = (ExchangeGem) apiResponse.getData();
        if (exchangeGem4 != null && (pinkDiamondNum = exchangeGem4.getPinkDiamondNum()) != null) {
            d2 = pinkDiamondNum.doubleValue();
        }
        shared.refreshDiamondOrGem(d, d2);
        HiloToasty.Companion companion = HiloToasty.Companion;
        String string = gemExchangeActivity.getString(2131954177);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Toast normal$default = HiloToasty.Companion.normal$default(companion, gemExchangeActivity, string, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirm$lambda$1(GemExchangeActivity gemExchangeActivity, GemExchangeActivity$showDialog$1$1 gemExchangeActivity$showDialog$1$1, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            if (hiloException.getCode() != 1020) {
                HiloToasty.Companion companion = HiloToasty.Companion;
                String errorMessage = hiloException.getErrorMessage();
                if (errorMessage == null) {
                    str = ResourcesKtxKt.getStringById(gemExchangeActivity$showDialog$1$1, 2131952667);
                } else {
                    str = errorMessage;
                }
                Toast normal$default = HiloToasty.Companion.normal$default(companion, gemExchangeActivity, str, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            }
        }
        return Unit.INSTANCE;
    }

    public void cancel() {
        OnCommonDialogListener.DefaultImpls.cancel(this);
    }

    public void confirm() {
        io.reactivex.rxjava3.core.i0<ApiResponse<ExchangeGem>> exchangeGem = AppServer.INSTANCE.getApis().exchangeGem(this.this$0.getMChangeBean());
        final GemExchangeActivity gemExchangeActivity = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.c0
            public final Object invoke(Object obj) {
                Unit confirm$lambda$0;
                confirm$lambda$0 = GemExchangeActivity$showDialog$1$1.confirm$lambda$0(GemExchangeActivity.this, (ApiResponse) obj);
                return confirm$lambda$0;
            }
        };
        final GemExchangeActivity gemExchangeActivity2 = this.this$0;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(exchangeGem, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.d0
            public final Object invoke(Object obj) {
                Unit confirm$lambda$1;
                confirm$lambda$1 = GemExchangeActivity$showDialog$1$1.confirm$lambda$1(GemExchangeActivity.this, this, (Throwable) obj);
                return confirm$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), this.this$0.getMCompositeDisposable());
    }
}
