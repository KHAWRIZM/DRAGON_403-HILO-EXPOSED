package com.qiahao.nextvideo.utilities;

import android.app.Activity;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.service.GroupService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/qiahao/nextvideo/utilities/AppRequestUtils$roomReportOrBlack$1$1$1$onSelect$2", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "confirm", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AppRequestUtils$roomReportOrBlack$1$1$1$onSelect$2 implements OnCommonDialogListener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $groupId;
    final /* synthetic */ int $index;
    final /* synthetic */ Function2<Boolean, Integer, Unit> $listener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public AppRequestUtils$roomReportOrBlack$1$1$1$onSelect$2(String str, Activity activity, Function2<? super Boolean, ? super Integer, Unit> function2, int i) {
        this.$groupId = str;
        this.$activity = activity;
        this.$listener = function2;
        this.$index = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirm$lambda$0(Activity activity, String str, Function2 function2, int i, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            AppRequestUtils.INSTANCE.showTipDialog(activity, str, function2, true, i);
        } else if (function2 != null) {
            function2.invoke(Boolean.FALSE, 1);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirm$lambda$1(Function2 function2, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (function2 != null) {
            function2.invoke(Boolean.FALSE, 1);
        }
        return Unit.INSTANCE;
    }

    public void cancel() {
        OnCommonDialogListener.DefaultImpls.cancel(this);
    }

    public void confirm() {
        io.reactivex.rxjava3.core.i0<ApiResponse<Object>> leaveGroup = GroupService.INSTANCE.getInstance().leaveGroup(this.$groupId);
        final Activity activity = this.$activity;
        final String str = this.$groupId;
        final Function2<Boolean, Integer, Unit> function2 = this.$listener;
        final int i = this.$index;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.utilities.c0
            public final Object invoke(Object obj) {
                Unit confirm$lambda$0;
                confirm$lambda$0 = AppRequestUtils$roomReportOrBlack$1$1$1$onSelect$2.confirm$lambda$0(activity, str, function2, i, (ApiResponse) obj);
                return confirm$lambda$0;
            }
        };
        final Function2<Boolean, Integer, Unit> function22 = this.$listener;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(leaveGroup, function1, new Function1() { // from class: com.qiahao.nextvideo.utilities.d0
            public final Object invoke(Object obj) {
                Unit confirm$lambda$1;
                confirm$lambda$1 = AppRequestUtils$roomReportOrBlack$1$1$1$onSelect$2.confirm$lambda$1(function22, (Throwable) obj);
                return confirm$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), AppRequestUtils.INSTANCE.getMCompositeDisposable());
    }
}
