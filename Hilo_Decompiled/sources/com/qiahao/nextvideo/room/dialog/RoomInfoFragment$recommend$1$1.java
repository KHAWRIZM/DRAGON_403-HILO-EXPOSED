package com.qiahao.nextvideo.room.dialog;

import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/qiahao/nextvideo/room/dialog/RoomInfoFragment$recommend$1$1", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "confirm", "", "cancel", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomInfoFragment$recommend$1$1 implements OnCommonDialogListener {
    final /* synthetic */ RoomInfoFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoomInfoFragment$recommend$1$1(RoomInfoFragment roomInfoFragment) {
        this.this$0 = roomInfoFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirm$lambda$0(RoomInfoFragment roomInfoFragment, RoomInfoFragment$recommend$1$1 roomInfoFragment$recommend$1$1, ApiResponse apiResponse) {
        GroupDetailBean groupDetailBean;
        GroupDetailBean groupDetailBean2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, roomInfoFragment.getActivity(), ResourcesKtxKt.getStringById(roomInfoFragment$recommend$1$1, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        groupDetailBean = roomInfoFragment.mGroupDetail;
        if (groupDetailBean != null) {
            groupDetailBean2 = roomInfoFragment.mGroupDetail;
            int i = 0;
            if (groupDetailBean2 != null && groupDetailBean2.getNotRecommend() == 0) {
                i = 1;
            }
            groupDetailBean.setNotRecommend(i);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirm$lambda$1(RoomInfoFragment roomInfoFragment, RoomInfoFragment$recommend$1$1 roomInfoFragment$recommend$1$1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        FragmentActivity activity = roomInfoFragment.getActivity();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(roomInfoFragment$recommend$1$1, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, activity, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public void cancel() {
    }

    public void confirm() {
        GroupDetailBean groupDetailBean;
        String str;
        GroupDetailBean groupDetailBean2;
        nd.a aVar;
        ServerApi apis = AppServer.INSTANCE.getApis();
        groupDetailBean = this.this$0.mGroupDetail;
        if (groupDetailBean == null || (str = groupDetailBean.getGroupId()) == null) {
            str = "";
        }
        groupDetailBean2 = this.this$0.mGroupDetail;
        int i = 0;
        if (groupDetailBean2 != null && groupDetailBean2.getNotRecommend() == 0) {
            i = 1;
        }
        io.reactivex.rxjava3.core.i0<ApiResponse<Object>> notRecommend = apis.notRecommend(2, str, i);
        final RoomInfoFragment roomInfoFragment = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.room.dialog.e3
            public final Object invoke(Object obj) {
                Unit confirm$lambda$0;
                confirm$lambda$0 = RoomInfoFragment$recommend$1$1.confirm$lambda$0(RoomInfoFragment.this, this, (ApiResponse) obj);
                return confirm$lambda$0;
            }
        };
        final RoomInfoFragment roomInfoFragment2 = this.this$0;
        nd.c observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(notRecommend, function1, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.f3
            public final Object invoke(Object obj) {
                Unit confirm$lambda$1;
                confirm$lambda$1 = RoomInfoFragment$recommend$1$1.confirm$lambda$1(RoomInfoFragment.this, this, (Throwable) obj);
                return confirm$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null);
        aVar = this.this$0.mCompositeDisposable;
        RxUtilsKt.addTo(observeOnMainThread$default, aVar);
    }
}
