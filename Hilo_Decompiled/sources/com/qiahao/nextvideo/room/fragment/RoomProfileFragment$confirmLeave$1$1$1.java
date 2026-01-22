package com.qiahao.nextvideo.room.fragment;

import android.content.Context;
import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.app.base.CommonTextDialog;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.room.interfaces.RoomInfoDialogInterface;
import com.qiahao.nextvideo.room.manager.GroupEvent;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/qiahao/nextvideo/room/fragment/RoomProfileFragment$confirmLeave$1$1$1", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "confirm", "", "cancel", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomProfileFragment$confirmLeave$1$1$1 implements OnCommonDialogListener {
    final /* synthetic */ CommonTextDialog $this_apply;
    final /* synthetic */ RoomProfileFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoomProfileFragment$confirmLeave$1$1$1(RoomProfileFragment roomProfileFragment, CommonTextDialog commonTextDialog) {
        this.this$0 = roomProfileFragment;
        this.$this_apply = commonTextDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirm$lambda$0(CommonTextDialog commonTextDialog, RoomProfileFragment$confirmLeave$1$1$1 roomProfileFragment$confirmLeave$1$1$1, RoomProfileFragment roomProfileFragment, ApiResponse apiResponse) {
        String str;
        UserProxy1.QuitRoom quitRoom;
        String groupId;
        Intrinsics.checkNotNullParameter(apiResponse, "data");
        if (apiResponse.isOk()) {
            Toast normal = HiloToasty.Companion.normal(commonTextDialog.getContext(), ResourcesKtxKt.getStringById(roomProfileFragment$confirmLeave$1$1$1, 2131954177), false);
            if (normal != null) {
                normal.show();
            }
            je.b mGroupEventProcessorObservable = GroupService.INSTANCE.getMGroupEventProcessorObservable();
            GroupEvent groupEvent = new GroupEvent();
            GroupDetailBean mGroupDetail = roomProfileFragment.getMGroupDetail();
            if (mGroupDetail == null || (str = mGroupDetail.getGroupId()) == null) {
                str = "";
            }
            mGroupEventProcessorObservable.onNext(groupEvent.leaveGroup(str));
            cf.c c = cf.c.c();
            GroupDetailBean mGroupDetail2 = roomProfileFragment.getMGroupDetail();
            if (mGroupDetail2 != null && (groupId = mGroupDetail2.getGroupId()) != null) {
                quitRoom = DataExternalKt.createExitRoom(groupId, 0);
            } else {
                quitRoom = null;
            }
            c.l(new LiveEvent("EXIT_ROOM", quitRoom));
            RoomInfoDialogInterface listener = roomProfileFragment.getListener();
            if (listener != null) {
                listener.onDismiss();
            }
        } else {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = commonTextDialog.getContext();
            String message = apiResponse.getMessage();
            if (message == null) {
                message = ResourcesKtxKt.getStringById(roomProfileFragment$confirmLeave$1$1$1, 2131952667);
            }
            Toast normal2 = companion.normal(context, message, false);
            if (normal2 != null) {
                normal2.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirm$lambda$1(CommonTextDialog commonTextDialog, RoomProfileFragment$confirmLeave$1$1$1 roomProfileFragment$confirmLeave$1$1$1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = commonTextDialog.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(roomProfileFragment$confirmLeave$1$1$1, 2131952667);
        }
        Toast normal = companion.normal(context, localizedMessage, false);
        if (normal != null) {
            normal.show();
        }
        return Unit.INSTANCE;
    }

    public void cancel() {
    }

    public void confirm() {
        String str;
        nd.a aVar;
        GroupService companion = GroupService.INSTANCE.getInstance();
        GroupDetailBean mGroupDetail = this.this$0.getMGroupDetail();
        if (mGroupDetail == null || (str = mGroupDetail.getGroupId()) == null) {
            str = "";
        }
        io.reactivex.rxjava3.core.i0<ApiResponse<Object>> leaveGroup = companion.leaveGroup(str);
        final CommonTextDialog commonTextDialog = this.$this_apply;
        final RoomProfileFragment roomProfileFragment = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.room.fragment.c1
            public final Object invoke(Object obj) {
                Unit confirm$lambda$0;
                confirm$lambda$0 = RoomProfileFragment$confirmLeave$1$1$1.confirm$lambda$0(CommonTextDialog.this, this, roomProfileFragment, (ApiResponse) obj);
                return confirm$lambda$0;
            }
        };
        final CommonTextDialog commonTextDialog2 = this.$this_apply;
        nd.c observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(leaveGroup, function1, new Function1() { // from class: com.qiahao.nextvideo.room.fragment.d1
            public final Object invoke(Object obj) {
                Unit confirm$lambda$1;
                confirm$lambda$1 = RoomProfileFragment$confirmLeave$1$1$1.confirm$lambda$1(CommonTextDialog.this, this, (Throwable) obj);
                return confirm$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null);
        aVar = this.this$0.mCompositeDisposable;
        RxUtilsKt.addTo(observeOnMainThread$default, aVar);
    }
}
