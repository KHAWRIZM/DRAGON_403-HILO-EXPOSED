package com.qiahao.nextvideo.utilities;

import android.app.Activity;
import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.room.manager.GroupEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/qiahao/nextvideo/utilities/AppRequestUtils$notRecommendRoom$1", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "confirm", "", "cancel", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AppRequestUtils$notRecommendRoom$1 implements OnCommonDialogListener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ boolean $isRoom;
    final /* synthetic */ Function2<Boolean, Integer, Unit> $listener;
    final /* synthetic */ int $notRecommend;
    final /* synthetic */ int $type;
    final /* synthetic */ String $uniqueKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public AppRequestUtils$notRecommendRoom$1(int i, String str, int i2, Function2<? super Boolean, ? super Integer, Unit> function2, boolean z, Activity activity) {
        this.$type = i;
        this.$uniqueKey = str;
        this.$notRecommend = i2;
        this.$listener = function2;
        this.$isRoom = z;
        this.$activity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirm$lambda$0(Function2 function2, boolean z, int i, Activity activity, AppRequestUtils$notRecommendRoom$1 appRequestUtils$notRecommendRoom$1, String str, ApiResponse apiResponse) {
        int i2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (function2 != null) {
            Boolean bool = Boolean.TRUE;
            if (z) {
                i2 = 100;
            } else {
                i2 = i;
            }
            function2.invoke(bool, Integer.valueOf(i2));
        }
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, activity, ResourcesKtxKt.getStringById(appRequestUtils$notRecommendRoom$1, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        if (z || i == 3) {
            GroupService.INSTANCE.getMGroupEventProcessorObservable().onNext(new GroupEvent().blockRoomToLocal(str));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirm$lambda$1(Function2 function2, boolean z, int i, Activity activity, AppRequestUtils$notRecommendRoom$1 appRequestUtils$notRecommendRoom$1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (function2 != null) {
            Boolean bool = Boolean.FALSE;
            if (z) {
                i = 100;
            }
            function2.invoke(bool, Integer.valueOf(i));
        }
        HiloToasty.Companion companion = HiloToasty.Companion;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(appRequestUtils$notRecommendRoom$1, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, activity, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public void cancel() {
        int i;
        Function2<Boolean, Integer, Unit> function2 = this.$listener;
        if (function2 != null) {
            Boolean bool = Boolean.FALSE;
            if (this.$isRoom) {
                i = 100;
            } else {
                i = this.$type;
            }
            function2.invoke(bool, Integer.valueOf(i));
        }
    }

    public void confirm() {
        int i;
        ServerApi apis = AppServer.INSTANCE.getApis();
        int i2 = this.$type;
        String str = this.$uniqueKey;
        if (this.$notRecommend == 0) {
            i = 1;
        } else {
            i = 0;
        }
        io.reactivex.rxjava3.core.i0<ApiResponse<Object>> notRecommend = apis.notRecommend(i2, str, i);
        final Function2<Boolean, Integer, Unit> function2 = this.$listener;
        final boolean z = this.$isRoom;
        final int i3 = this.$type;
        final Activity activity = this.$activity;
        final String str2 = this.$uniqueKey;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.utilities.y
            public final Object invoke(Object obj) {
                Unit confirm$lambda$0;
                confirm$lambda$0 = AppRequestUtils$notRecommendRoom$1.confirm$lambda$0(function2, z, i3, activity, this, str2, (ApiResponse) obj);
                return confirm$lambda$0;
            }
        };
        final Function2<Boolean, Integer, Unit> function22 = this.$listener;
        final boolean z2 = this.$isRoom;
        final int i4 = this.$type;
        final Activity activity2 = this.$activity;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(notRecommend, function1, new Function1() { // from class: com.qiahao.nextvideo.utilities.z
            public final Object invoke(Object obj) {
                Unit confirm$lambda$1;
                confirm$lambda$1 = AppRequestUtils$notRecommendRoom$1.confirm$lambda$1(function22, z2, i4, activity2, this, (Throwable) obj);
                return confirm$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), AppRequestUtils.INSTANCE.getMCompositeDisposable());
    }
}
