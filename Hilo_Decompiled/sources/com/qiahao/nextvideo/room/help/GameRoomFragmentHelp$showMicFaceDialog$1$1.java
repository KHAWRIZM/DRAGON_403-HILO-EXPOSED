package com.qiahao.nextvideo.room.help;

import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.model.EmojiBean;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.dialog.MicFaceDialogListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/qiahao/nextvideo/room/help/GameRoomFragmentHelp$showMicFaceDialog$1$1", "Lcom/qiahao/nextvideo/room/dialog/MicFaceDialogListener;", "sendFace", "", "emojiBean", "Lcom/qiahao/nextvideo/data/model/EmojiBean;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameRoomFragmentHelp$showMicFaceDialog$1$1 implements MicFaceDialogListener {
    final /* synthetic */ GameRoomFragmentHelp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GameRoomFragmentHelp$showMicFaceDialog$1$1(GameRoomFragmentHelp gameRoomFragmentHelp) {
        this.this$0 = gameRoomFragmentHelp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendFace$lambda$0(GameRoomFragmentHelp gameRoomFragmentHelp, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        GameRoomFragmentHelp.showToastOrLog$default(gameRoomFragmentHelp, null, " 发送表情成功", false, 5, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendFace$lambda$1(GameRoomFragmentHelp gameRoomFragmentHelp, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        GameRoomFragmentHelp.showToastOrLog$default(gameRoomFragmentHelp, null, "onError: ---发送失败 " + th.getLocalizedMessage(), false, 5, null);
        return Unit.INSTANCE;
    }

    @Override // com.qiahao.nextvideo.room.dialog.MicFaceDialogListener
    public void sendFace(EmojiBean emojiBean) {
        Intrinsics.checkNotNullParameter(emojiBean, "emojiBean");
        io.reactivex.rxjava3.core.i0<ApiResponse<String>> sendMicEmoji = AppServer.INSTANCE.getApis().sendMicEmoji(this.this$0.getFragment().getMViewModel().getMGroupId(), emojiBean.getId());
        final GameRoomFragmentHelp gameRoomFragmentHelp = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.room.help.k6
            public final Object invoke(Object obj) {
                Unit sendFace$lambda$0;
                sendFace$lambda$0 = GameRoomFragmentHelp$showMicFaceDialog$1$1.sendFace$lambda$0(GameRoomFragmentHelp.this, (ApiResponse) obj);
                return sendFace$lambda$0;
            }
        };
        final GameRoomFragmentHelp gameRoomFragmentHelp2 = this.this$0;
        RxUtilsKt.observeOnMainThread$default(sendMicEmoji, function1, new Function1() { // from class: com.qiahao.nextvideo.room.help.l6
            public final Object invoke(Object obj) {
                Unit sendFace$lambda$1;
                sendFace$lambda$1 = GameRoomFragmentHelp$showMicFaceDialog$1$1.sendFace$lambda$1(GameRoomFragmentHelp.this, (Throwable) obj);
                return sendFace$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null);
    }
}
