package com.qiahao.nextvideo.ui.home.chat.activity;

import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.CommonApi;
import com.qiahao.base_common.network.CommonServer;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.ChatViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/qiahao/nextvideo/ui/home/chat/activity/ChatStrangeActivity$showMenuDialog$1$clickType$2", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "confirm", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ChatStrangeActivity$showMenuDialog$1$clickType$2 implements OnCommonDialogListener {
    final /* synthetic */ ChatStrangeActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatStrangeActivity$showMenuDialog$1$clickType$2(ChatStrangeActivity chatStrangeActivity) {
        this.this$0 = chatStrangeActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirm$lambda$0(ChatStrangeActivity chatStrangeActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ChatStrangeActivity.deleteConversation$default(chatStrangeActivity, true, false, false, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirm$lambda$1(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public void cancel() {
        OnCommonDialogListener.DefaultImpls.cancel(this);
    }

    public void confirm() {
        User user;
        String str;
        ChatViewModel viewModel;
        CommonApi apis = CommonServer.INSTANCE.getApis();
        user = this.this$0.mUser;
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        io.reactivex.rxjava3.core.i0 blockUser = apis.blockUser(str);
        final ChatStrangeActivity chatStrangeActivity = this.this$0;
        nd.c observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(blockUser, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.h1
            public final Object invoke(Object obj) {
                Unit confirm$lambda$0;
                confirm$lambda$0 = ChatStrangeActivity$showMenuDialog$1$clickType$2.confirm$lambda$0(ChatStrangeActivity.this, (ApiResponse) obj);
                return confirm$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.i1
            public final Object invoke(Object obj) {
                Unit confirm$lambda$1;
                confirm$lambda$1 = ChatStrangeActivity$showMenuDialog$1$clickType$2.confirm$lambda$1((Throwable) obj);
                return confirm$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null);
        viewModel = this.this$0.getViewModel();
        RxUtilsKt.addTo(observeOnMainThread$default, viewModel.getMCompositeDisposable());
    }
}
