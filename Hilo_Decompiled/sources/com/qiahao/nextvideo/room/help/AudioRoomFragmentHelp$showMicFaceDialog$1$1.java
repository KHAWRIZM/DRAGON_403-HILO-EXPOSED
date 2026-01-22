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

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/qiahao/nextvideo/room/help/AudioRoomFragmentHelp$showMicFaceDialog$1$1", "Lcom/qiahao/nextvideo/room/dialog/MicFaceDialogListener;", "sendFace", "", "emojiBean", "Lcom/qiahao/nextvideo/data/model/EmojiBean;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AudioRoomFragmentHelp$showMicFaceDialog$1$1 implements MicFaceDialogListener {
    final /* synthetic */ AudioRoomFragmentHelp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioRoomFragmentHelp$showMicFaceDialog$1$1(AudioRoomFragmentHelp audioRoomFragmentHelp) {
        this.this$0 = audioRoomFragmentHelp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendFace$lambda$0(AudioRoomFragmentHelp audioRoomFragmentHelp, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        AudioRoomFragmentHelp.showToastOrLog$default(audioRoomFragmentHelp, null, " 发送表情成功", false, 5, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendFace$lambda$1(AudioRoomFragmentHelp audioRoomFragmentHelp, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        AudioRoomFragmentHelp.showToastOrLog$default(audioRoomFragmentHelp, null, "onError: ---发送失败 " + th.getLocalizedMessage(), false, 5, null);
        return Unit.INSTANCE;
    }

    @Override // com.qiahao.nextvideo.room.dialog.MicFaceDialogListener
    public void sendFace(EmojiBean emojiBean) {
        Intrinsics.checkNotNullParameter(emojiBean, "emojiBean");
        io.reactivex.rxjava3.core.i0<ApiResponse<String>> sendMicEmoji = AppServer.INSTANCE.getApis().sendMicEmoji(this.this$0.getFragment().getMViewModel().getMGroupId(), emojiBean.getId());
        final AudioRoomFragmentHelp audioRoomFragmentHelp = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.room.help.d3
            public final Object invoke(Object obj) {
                Unit sendFace$lambda$0;
                sendFace$lambda$0 = AudioRoomFragmentHelp$showMicFaceDialog$1$1.sendFace$lambda$0(AudioRoomFragmentHelp.this, (ApiResponse) obj);
                return sendFace$lambda$0;
            }
        };
        final AudioRoomFragmentHelp audioRoomFragmentHelp2 = this.this$0;
        RxUtilsKt.observeOnMainThread$default(sendMicEmoji, function1, new Function1() { // from class: com.qiahao.nextvideo.room.help.e3
            public final Object invoke(Object obj) {
                Unit sendFace$lambda$1;
                sendFace$lambda$1 = AudioRoomFragmentHelp$showMicFaceDialog$1$1.sendFace$lambda$1(AudioRoomFragmentHelp.this, (Throwable) obj);
                return sendFace$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null);
    }
}
