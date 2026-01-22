package com.qiahao.nextvideo.room.help;

import androidx.fragment.app.FragmentActivity;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.ChannelEventGiftAddTime;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.OnlineSet;
import com.qiahao.nextvideo.data.model.PurchaseFeeDetailsX;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.dialog.RoomTipDialog;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/qiahao/nextvideo/room/help/AudioRoomDialogHelp$showRoomMemberMass$1", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "confirm", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AudioRoomDialogHelp$showRoomMemberMass$1 implements OnCommonDialogListener {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ RoomTipDialog $tipDialog;
    final /* synthetic */ AudioRoomDialogHelp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioRoomDialogHelp$showRoomMemberMass$1(AudioRoomDialogHelp audioRoomDialogHelp, FragmentActivity fragmentActivity, RoomTipDialog roomTipDialog) {
        this.this$0 = audioRoomDialogHelp;
        this.$activity = fragmentActivity;
        this.$tipDialog = roomTipDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirm$lambda$0(AudioRoomDialogHelp audioRoomDialogHelp, AudioRoomDialogHelp$showRoomMemberMass$1 audioRoomDialogHelp$showRoomMemberMass$1, RoomTipDialog roomTipDialog, ApiResponse apiResponse) {
        double d;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore shared = UserStore.INSTANCE.getShared();
        ChannelEventGiftAddTime channelEventGiftAddTime = (ChannelEventGiftAddTime) apiResponse.getData();
        if (channelEventGiftAddTime != null) {
            d = channelEventGiftAddTime.getDiamondNum();
        } else {
            d = 0.0d;
        }
        UserStore.refreshDiamondOrGem$default(shared, d, 0.0d, 2, null);
        AudioRoomDialogHelp.showToastOrLog$default(audioRoomDialogHelp, ResourcesKtxKt.getStringById(audioRoomDialogHelp$showRoomMemberMass$1, 2131954177), null, false, 6, null);
        roomTipDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirm$lambda$1(AudioRoomDialogHelp audioRoomDialogHelp, AudioRoomDialogHelp$showRoomMemberMass$1 audioRoomDialogHelp$showRoomMemberMass$1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(audioRoomDialogHelp$showRoomMemberMass$1, 2131952667);
            }
            AudioRoomDialogHelp.showToastOrLog$default(audioRoomDialogHelp, errorMessage, null, false, 6, null);
        }
        return Unit.INSTANCE;
    }

    public void cancel() {
        OnCommonDialogListener.DefaultImpls.cancel(this);
    }

    public void confirm() {
        double d;
        int i;
        OnlineSet onlineSet;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            d = user.getDiamondNum();
        } else {
            d = 0.0d;
        }
        PurchaseFeeDetailsX purchaseFeeDetail = PurchaseService.INSTANCE.getShared().getPurchaseFeeDetail();
        if (purchaseFeeDetail != null && (onlineSet = purchaseFeeDetail.getOnlineSet()) != null) {
            i = onlineSet.getSessionPayFee();
        } else {
            i = 5;
        }
        if (d >= i) {
            io.reactivex.rxjava3.core.i0<ApiResponse<ChannelEventGiftAddTime>> roomPostBroadcast = AppServer.INSTANCE.getApis().roomPostBroadcast(this.this$0.getFragment().getMViewModel().getMGroupId(), ResourcesKtxKt.getStringById(this, 2131953142));
            final AudioRoomDialogHelp audioRoomDialogHelp = this.this$0;
            final RoomTipDialog roomTipDialog = this.$tipDialog;
            Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.room.help.t0
                public final Object invoke(Object obj) {
                    Unit confirm$lambda$0;
                    confirm$lambda$0 = AudioRoomDialogHelp$showRoomMemberMass$1.confirm$lambda$0(AudioRoomDialogHelp.this, this, roomTipDialog, (ApiResponse) obj);
                    return confirm$lambda$0;
                }
            };
            final AudioRoomDialogHelp audioRoomDialogHelp2 = this.this$0;
            RxUtilsKt.observeOnMainThread$default(roomPostBroadcast, function1, new Function1() { // from class: com.qiahao.nextvideo.room.help.u0
                public final Object invoke(Object obj) {
                    Unit confirm$lambda$1;
                    confirm$lambda$1 = AudioRoomDialogHelp$showRoomMemberMass$1.confirm$lambda$1(AudioRoomDialogHelp.this, this, (Throwable) obj);
                    return confirm$lambda$1;
                }
            }, (Function0) null, false, 12, (Object) null);
            return;
        }
        WalletActivity.INSTANCE.start(this.$activity);
    }
}
