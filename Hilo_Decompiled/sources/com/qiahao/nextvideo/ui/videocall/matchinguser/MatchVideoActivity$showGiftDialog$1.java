package com.qiahao.nextvideo.ui.videocall.matchinguser;

import android.widget.Toast;
import com.qiahao.base_common.interfaceing.SendGiftListener;
import com.qiahao.base_common.model.GiftData;
import com.qiahao.base_common.model.common.ChannelEventGiftAddTime;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.qiahao.nextvideo.ui.family.FamilySettingFragment;
import com.qiahao.nextvideo.ui.videocall.VideoCallPreloadModel;
import io.reactivex.rxjava3.core.i0;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, d2 = {"com/qiahao/nextvideo/ui/videocall/matchinguser/MatchVideoActivity$showGiftDialog$1", "Lcom/qiahao/base_common/interfaceing/SendGiftListener;", "giftsChoose", "", "selectedGiftItem", "Lcom/qiahao/base_common/model/GiftData;", FamilySettingFragment.FAMILY_NUMBER, "", "extraIdList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isAllMic", "", "showRechargeView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MatchVideoActivity$showGiftDialog$1 implements SendGiftListener {
    final /* synthetic */ MatchVideoActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatchVideoActivity$showGiftDialog$1(MatchVideoActivity matchVideoActivity) {
        this.this$0 = matchVideoActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit giftsChoose$lambda$0(ApiResponse apiResponse) {
        double d;
        Intrinsics.checkNotNullParameter(apiResponse, "userCostMessage");
        UserStore shared = UserStore.INSTANCE.getShared();
        ChannelEventGiftAddTime channelEventGiftAddTime = (ChannelEventGiftAddTime) apiResponse.getData();
        double d2 = 0.0d;
        if (channelEventGiftAddTime != null) {
            d = channelEventGiftAddTime.getDiamondNum();
        } else {
            d = 0.0d;
        }
        ChannelEventGiftAddTime channelEventGiftAddTime2 = (ChannelEventGiftAddTime) apiResponse.getData();
        if (channelEventGiftAddTime2 != null) {
            d2 = channelEventGiftAddTime2.getPinkDiamondNum();
        }
        shared.refreshDiamondOrGem(d, d2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit giftsChoose$lambda$1(MatchVideoActivity matchVideoActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if ((th instanceof HiloException) && ((HiloException) th).getCode() == 4000) {
            AppService service = AppController.INSTANCE.getService();
            if (service != null) {
                service.openWallet();
            }
        } else {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String localizedMessage = th.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = matchVideoActivity.getString(2131952667);
                Intrinsics.checkNotNullExpressionValue(localizedMessage, "getString(...)");
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, matchVideoActivity, localizedMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    public void begGift(GiftData giftData, int i) {
        SendGiftListener.DefaultImpls.begGift(this, giftData, i);
    }

    public void giftsChoose(GiftData selectedGiftItem, int number, ArrayList<String> extraIdList, boolean isAllMic) {
        String str;
        String str2;
        long j;
        nd.a aVar;
        String matchUniqueID;
        Intrinsics.checkNotNullParameter(selectedGiftItem, "selectedGiftItem");
        Intrinsics.checkNotNullParameter(extraIdList, "extraIdList");
        PurchaseService shared = PurchaseService.INSTANCE.getShared();
        VideoCallPreloadModel videoCallPreloadModel = this.this$0.preloadModel;
        if (videoCallPreloadModel == null || (str = videoCallPreloadModel.getToUID()) == null) {
            str = "";
        }
        VideoCallPreloadModel videoCallPreloadModel2 = this.this$0.preloadModel;
        if (videoCallPreloadModel2 == null || (matchUniqueID = videoCallPreloadModel2.getMatchUniqueID()) == null) {
            str2 = "";
        } else {
            str2 = matchUniqueID;
        }
        Long giftId = selectedGiftItem.getGiftId();
        if (giftId != null) {
            j = giftId.longValue();
        } else {
            j = 0;
        }
        i0<ApiResponse<ChannelEventGiftAddTime>> sendGift = shared.sendGift(str, j, 1, str2, number, selectedGiftItem.getGiftText());
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.v
            public final Object invoke(Object obj) {
                Unit giftsChoose$lambda$0;
                giftsChoose$lambda$0 = MatchVideoActivity$showGiftDialog$1.giftsChoose$lambda$0((ApiResponse) obj);
                return giftsChoose$lambda$0;
            }
        };
        final MatchVideoActivity matchVideoActivity = this.this$0;
        nd.c observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(sendGift, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.w
            public final Object invoke(Object obj) {
                Unit giftsChoose$lambda$1;
                giftsChoose$lambda$1 = MatchVideoActivity$showGiftDialog$1.giftsChoose$lambda$1(MatchVideoActivity.this, (Throwable) obj);
                return giftsChoose$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null);
        aVar = this.this$0.compositeDisposable;
        RxUtilsKt.addTo(observeOnMainThread$default, aVar);
    }

    public void roomGiftsChoose(GiftData giftData, int i, ArrayList<String> arrayList, int i2) {
        SendGiftListener.DefaultImpls.roomGiftsChoose(this, giftData, i, arrayList, i2);
    }

    public void showRechargeView() {
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.openWallet();
        }
    }
}
