package com.qiahao.nextvideo.ui.home.chat;

import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.service.match.MatchingProvide;
import com.qiahao.nextvideo.data.strange.StrangeConfirm;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/StrangeMatchViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "strangeConfirmChange", "", MatchingProvide.MATCH_START_MATCH, "exitMatch", "isSetting", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class StrangeMatchViewModel extends BaseViewModel {

    @NotNull
    public static final String CHANGE_AVATAR = "change_avatar";

    @NotNull
    public static final String EXIT_MATCH = "exit_match";

    @NotNull
    public static final String MATCH_SETTING = "match_setting";

    @NotNull
    public static final String START_MATCH = "start_match";

    public static /* synthetic */ void exitMatch$default(StrangeMatchViewModel strangeMatchViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        strangeMatchViewModel.exitMatch(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit exitMatch$lambda$4(StrangeMatchViewModel strangeMatchViewModel, boolean z, ApiResponse apiResponse) {
        String str;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ma.b mSuccess = strangeMatchViewModel.getMSuccess();
        if (z) {
            str = MATCH_SETTING;
        } else {
            str = EXIT_MATCH;
        }
        mSuccess.setValue(new Pair(str, apiResponse));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit exitMatch$lambda$5(StrangeMatchViewModel strangeMatchViewModel, boolean z, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        ma.b mException = strangeMatchViewModel.getMException();
        if (z) {
            str = MATCH_SETTING;
        } else {
            str = EXIT_MATCH;
        }
        mException.setValue(new Pair(str, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startMatch$lambda$2(StrangeMatchViewModel strangeMatchViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        strangeMatchViewModel.getMSuccess().setValue(new Pair(START_MATCH, apiResponse));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startMatch$lambda$3(StrangeMatchViewModel strangeMatchViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        strangeMatchViewModel.getMException().setValue(new Pair(START_MATCH, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit strangeConfirmChange$lambda$0(StrangeMatchViewModel strangeMatchViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore.INSTANCE.getShared().changeNameAndAvatar((StrangeConfirm) apiResponse.getData());
        strangeMatchViewModel.getMSuccess().setValue(new Pair(CHANGE_AVATAR, apiResponse));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit strangeConfirmChange$lambda$1(StrangeMatchViewModel strangeMatchViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        strangeMatchViewModel.getMException().setValue(new Pair(CHANGE_AVATAR, th));
        return Unit.INSTANCE;
    }

    public final void exitMatch(final boolean isSetting) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().exitStrangeMatch(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.r0
            public final Object invoke(Object obj) {
                Unit exitMatch$lambda$4;
                exitMatch$lambda$4 = StrangeMatchViewModel.exitMatch$lambda$4(StrangeMatchViewModel.this, isSetting, (ApiResponse) obj);
                return exitMatch$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.s0
            public final Object invoke(Object obj) {
                Unit exitMatch$lambda$5;
                exitMatch$lambda$5 = StrangeMatchViewModel.exitMatch$lambda$5(StrangeMatchViewModel.this, isSetting, (Throwable) obj);
                return exitMatch$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void startMatch() {
        String str;
        String maskAvatar;
        ServerApi apis = AppServer.INSTANCE.getApis();
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        String str2 = "";
        if (user == null || (str = user.getNick()) == null) {
            str = "";
        }
        User user2 = companion.getShared().getUser();
        if (user2 != null && (maskAvatar = user2.getMaskAvatar()) != null) {
            str2 = maskAvatar;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.starStrangeMatch(str, str2), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.p0
            public final Object invoke(Object obj) {
                Unit startMatch$lambda$2;
                startMatch$lambda$2 = StrangeMatchViewModel.startMatch$lambda$2(StrangeMatchViewModel.this, (ApiResponse) obj);
                return startMatch$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.q0
            public final Object invoke(Object obj) {
                Unit startMatch$lambda$3;
                startMatch$lambda$3 = StrangeMatchViewModel.startMatch$lambda$3(StrangeMatchViewModel.this, (Throwable) obj);
                return startMatch$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void strangeConfirmChange() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().strangeConfirmChange(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.t0
            public final Object invoke(Object obj) {
                Unit strangeConfirmChange$lambda$0;
                strangeConfirmChange$lambda$0 = StrangeMatchViewModel.strangeConfirmChange$lambda$0(StrangeMatchViewModel.this, (ApiResponse) obj);
                return strangeConfirmChange$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.u0
            public final Object invoke(Object obj) {
                Unit strangeConfirmChange$lambda$1;
                strangeConfirmChange$lambda$1 = StrangeMatchViewModel.strangeConfirmChange$lambda$1(StrangeMatchViewModel.this, (Throwable) obj);
                return strangeConfirmChange$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }
}
