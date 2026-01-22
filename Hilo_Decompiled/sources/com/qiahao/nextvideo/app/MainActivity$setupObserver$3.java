package com.qiahao.nextvideo.app;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.UserObjectEvent;
import com.qiahao.nextvideo.data.UserObjectEventType;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.service.SplashService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MainActivity$setupObserver$3<T> implements pd.g {
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MainActivity$setupObserver$3(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void accept$lambda$0(Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            AppRequestUtils appRequestUtils = AppRequestUtils.INSTANCE;
            Object result = task.getResult();
            Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
            appRequestUtils.uploadToken((String) result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit accept$lambda$1(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit accept$lambda$2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public final void accept(UserObjectEvent userObjectEvent) {
        nd.a aVar;
        try {
            if (!userObjectEvent.isAuthenticated()) {
                this.this$0.presentAuthenticationController(false, userObjectEvent.getType() != UserObjectEventType.LOGOUT);
            }
            if (userObjectEvent.getType() == UserObjectEventType.LOGIN || userObjectEvent.getType() == UserObjectEventType.FILLUESRINFO) {
                SplashService.INSTANCE.getShared().gotoDownloadGlobalOpenSource();
                User user = UserStore.INSTANCE.getShared().getUser();
                if (user != null && user.isCompleteMaterial()) {
                    FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.qiahao.nextvideo.app.g
                        public final void onComplete(Task task) {
                            MainActivity$setupObserver$3.accept$lambda$0(task);
                        }
                    });
                }
                nd.c observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().vipDailyDiamond(), new Function1() { // from class: com.qiahao.nextvideo.app.h
                    public final Object invoke(Object obj) {
                        Unit accept$lambda$1;
                        accept$lambda$1 = MainActivity$setupObserver$3.accept$lambda$1((ApiResponse) obj);
                        return accept$lambda$1;
                    }
                }, new Function1() { // from class: com.qiahao.nextvideo.app.i
                    public final Object invoke(Object obj) {
                        Unit accept$lambda$2;
                        accept$lambda$2 = MainActivity$setupObserver$3.accept$lambda$2((Throwable) obj);
                        return accept$lambda$2;
                    }
                }, (Function0) null, false, 12, (Object) null);
                aVar = this.this$0.compositeDisposable;
                RxUtilsKt.addTo(observeOnMainThread$default, aVar);
                this.this$0.showAllList();
            }
        } catch (Exception e) {
            DebugToolsKt.printfE(MainActivity.TAG, "MainActivity#userObjectRelay内部try()catch{}" + e.getLocalizedMessage());
        }
    }
}
