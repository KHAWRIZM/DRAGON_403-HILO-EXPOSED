package com.qiahao.nextvideo.ui.home.chat.activity;

import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.ChatViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/qiahao/nextvideo/ui/home/chat/activity/ChatActivity$initChatView$8$2", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "confirm", "", "cancel", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ChatActivity$initChatView$8$2 implements OnCommonDialogListener {
    final /* synthetic */ ChatActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatActivity$initChatView$8$2(ChatActivity chatActivity) {
        this.this$0 = chatActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirm$lambda$0(ChatActivity chatActivity) {
        ChatViewModel viewModel;
        User user;
        String str;
        viewModel = chatActivity.getViewModel();
        user = chatActivity.mUser;
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        viewModel.checkChat(str);
        return Unit.INSTANCE;
    }

    public void cancel() {
        this.this$0.finish();
    }

    public void confirm() {
        final ChatActivity chatActivity = this.this$0;
        chatActivity.requestLikeUser(new Function0() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.q
            public final Object invoke() {
                Unit confirm$lambda$0;
                confirm$lambda$0 = ChatActivity$initChatView$8$2.confirm$lambda$0(ChatActivity.this);
                return confirm$lambda$0;
            }
        });
    }
}
