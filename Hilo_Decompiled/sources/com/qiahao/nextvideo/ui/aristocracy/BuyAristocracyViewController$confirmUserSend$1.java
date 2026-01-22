package com.qiahao.nextvideo.ui.aristocracy;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.ChannelEventGiftAddTime;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.NobleBeanConfig;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewControllerKt;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/qiahao/nextvideo/ui/aristocracy/BuyAristocracyViewController$confirmUserSend$1", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "confirm", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class BuyAristocracyViewController$confirmUserSend$1 implements OnCommonDialogListener {
    final /* synthetic */ User $user;
    final /* synthetic */ BuyAristocracyViewController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BuyAristocracyViewController$confirmUserSend$1(User user, BuyAristocracyViewController buyAristocracyViewController) {
        this.$user = user;
        this.this$0 = buyAristocracyViewController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirm$lambda$0(BuyAristocracyViewController buyAristocracyViewController, ApiResponse apiResponse) {
        Double d;
        Double d2;
        double d3;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        if (user != null) {
            d = Double.valueOf(user.getDiamondNum());
        } else {
            d = null;
        }
        ChannelEventGiftAddTime channelEventGiftAddTime = (ChannelEventGiftAddTime) apiResponse.getData();
        if (channelEventGiftAddTime != null) {
            d2 = Double.valueOf(channelEventGiftAddTime.getDiamondNum());
        } else {
            d2 = null;
        }
        if (!Intrinsics.areEqual(d, d2)) {
            UserStore shared = companion.getShared();
            ChannelEventGiftAddTime channelEventGiftAddTime2 = (ChannelEventGiftAddTime) apiResponse.getData();
            if (channelEventGiftAddTime2 != null) {
                d3 = channelEventGiftAddTime2.getDiamondNum();
            } else {
                d3 = 0.0d;
            }
            UserStore.refreshDiamondOrGem$default(shared, d3, 0.0d, 2, null);
        }
        ViewController.dismiss$default(buyAristocracyViewController, true, null, 2, null);
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, buyAristocracyViewController.getContext(), BaseViewControllerKt.getString(buyAristocracyViewController, 2131954176, new Object[0]), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirm$lambda$1(BuyAristocracyViewController buyAristocracyViewController, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        ViewController.dismiss$default(buyAristocracyViewController, true, null, 2, null);
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = buyAristocracyViewController.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = BaseViewControllerKt.getString(buyAristocracyViewController, 2131952667, new Object[0]);
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public void cancel() {
        OnCommonDialogListener.DefaultImpls.cancel(this);
    }

    public void confirm() {
        int i;
        String externalId = this.$user.getExternalId();
        if (TextUtils.isEmpty(externalId)) {
            return;
        }
        UserService shared = UserService.INSTANCE.getShared();
        NobleBeanConfig mCurrentNobleBeanConfig = this.this$0.getMCurrentNobleBeanConfig();
        if (mCurrentNobleBeanConfig != null) {
            i = mCurrentNobleBeanConfig.getLevel();
        } else {
            i = 0;
        }
        io.reactivex.rxjava3.core.i0<ApiResponse<ChannelEventGiftAddTime>> sendNoble = shared.sendNoble(i, externalId);
        final BuyAristocracyViewController buyAristocracyViewController = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.r0
            public final Object invoke(Object obj) {
                Unit confirm$lambda$0;
                confirm$lambda$0 = BuyAristocracyViewController$confirmUserSend$1.confirm$lambda$0(BuyAristocracyViewController.this, (ApiResponse) obj);
                return confirm$lambda$0;
            }
        };
        final BuyAristocracyViewController buyAristocracyViewController2 = this.this$0;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(sendNoble, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.s0
            public final Object invoke(Object obj) {
                Unit confirm$lambda$1;
                confirm$lambda$1 = BuyAristocracyViewController$confirmUserSend$1.confirm$lambda$1(BuyAristocracyViewController.this, (Throwable) obj);
                return confirm$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), this.this$0.getCompositeDisposable());
    }
}
