package com.qiahao.nextvideo.ui.home;

import android.content.Context;
import android.widget.Toast;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.model.GlobalBroadCastBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewControllerKt;
import io.reactivex.rxjava3.core.i0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/qiahao/nextvideo/ui/home/GlobalBroadCastViewController$deleteBroadCast$1", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "confirm", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GlobalBroadCastViewController$deleteBroadCast$1 implements OnCommonDialogListener {
    final /* synthetic */ int $delType;
    final /* synthetic */ GlobalBroadCastBean $globalBroadCastBean;
    final /* synthetic */ GlobalBroadCastViewController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GlobalBroadCastViewController$deleteBroadCast$1(GlobalBroadCastBean globalBroadCastBean, int i, GlobalBroadCastViewController globalBroadCastViewController) {
        this.$globalBroadCastBean = globalBroadCastBean;
        this.$delType = i;
        this.this$0 = globalBroadCastViewController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirm$lambda$0(GlobalBroadCastViewController globalBroadCastViewController, ApiResponse apiResponse) {
        String str;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            if (globalBroadCastViewController.getMCurrentSelectIndex() != -1) {
                globalBroadCastViewController.getMAdapter().removeAt(globalBroadCastViewController.getMCurrentSelectIndex());
                globalBroadCastViewController.setMCurrentSelectIndex(-1);
            }
        } else {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = globalBroadCastViewController.getContext();
            String message = apiResponse.getMessage();
            if (message == null) {
                str = BaseViewControllerKt.getString(globalBroadCastViewController, 2131952667, new Object[0]);
            } else {
                str = message;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirm$lambda$1(GlobalBroadCastViewController globalBroadCastViewController, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = globalBroadCastViewController.getContext();
        String message = th.getMessage();
        if (message == null) {
            str = BaseViewControllerKt.getString(globalBroadCastViewController, 2131952667, new Object[0]);
        } else {
            str = message;
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
        i0<ApiResponse<Object>> deleteBroadcastMessage = UserService.INSTANCE.getShared().deleteBroadcastMessage(String.valueOf(this.$globalBroadCastBean.getUserGlobalBroadcastId()), this.$delType);
        final GlobalBroadCastViewController globalBroadCastViewController = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.home.q
            public final Object invoke(Object obj) {
                Unit confirm$lambda$0;
                confirm$lambda$0 = GlobalBroadCastViewController$deleteBroadCast$1.confirm$lambda$0(GlobalBroadCastViewController.this, (ApiResponse) obj);
                return confirm$lambda$0;
            }
        };
        final GlobalBroadCastViewController globalBroadCastViewController2 = this.this$0;
        RxUtilsKt.observeOnMainThread$default(deleteBroadcastMessage, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.home.r
            public final Object invoke(Object obj) {
                Unit confirm$lambda$1;
                confirm$lambda$1 = GlobalBroadCastViewController$deleteBroadCast$1.confirm$lambda$1(GlobalBroadCastViewController.this, (Throwable) obj);
                return confirm$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null);
    }
}
