package com.qiahao.nextvideo.room.viewmodel;

import android.widget.Toast;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.room.RoomCurrentPK;
import com.qiahao.nextvideo.data.service.agora.HiloRtcEngine;
import com.qiahao.nextvideo.data.service.match.MatchingProvide;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016J\u001f\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lcom/qiahao/nextvideo/room/viewmodel/RoomPKViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "pkListData", "Lcom/qiahao/base_common/model/BaseListData;", "getPkListData", "()Lcom/qiahao/base_common/model/BaseListData;", "setPkListData", "(Lcom/qiahao/base_common/model/BaseListData;)V", "onPKListMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/nextvideo/data/room/RoomCurrentPK;", "pkList", "Landroidx/lifecycle/LiveData;", "getPkList", "()Landroidx/lifecycle/LiveData;", "roomCurrentPK", "", MatchingProvide.MATCH_START_MATCH, "groupId", "", "exitPK", "acceptPK", "targetGroupId", "upMic", "micIndex", "", "micForbid", "", "(Ljava/lang/Integer;Z)V", "acceptStrangeChat", "targetExternalId", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomPKViewModel extends BaseViewModel {

    @NotNull
    public static final String PK_ACCEPT = "PK_ACCEPT";

    @NotNull
    public static final String PK_AUTO_MIC = "PK_AUTO_MIC";

    @NotNull
    public static final String PK_CREATE = "PK_CREATE";

    @NotNull
    public static final String PK_EXIT = "PK_EXIT";

    @NotNull
    public static final String PK_LIST = "PK_LIST";

    @NotNull
    public static final String STRANGE_CHAT = "STRANGE_CHAT";

    @NotNull
    private BaseListData pkListData = new BaseListData();

    @NotNull
    private final MutableLiveData<List<RoomCurrentPK>> onPKListMutable = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit acceptPK$lambda$6(RoomPKViewModel roomPKViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        roomPKViewModel.getMSuccess().setValue(new Pair(PK_ACCEPT, apiResponse));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit acceptPK$lambda$7(RoomPKViewModel roomPKViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomPKViewModel.getMException().setValue(new Pair(PK_ACCEPT, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit acceptStrangeChat$lambda$10(RoomPKViewModel roomPKViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        roomPKViewModel.getMSuccess().setValue(new Pair(STRANGE_CHAT, apiResponse.getData()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit acceptStrangeChat$lambda$11(RoomPKViewModel roomPKViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomPKViewModel.getMException().setValue(new Pair(STRANGE_CHAT, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit exitPK$lambda$4(RoomPKViewModel roomPKViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        roomPKViewModel.getMSuccess().setValue(new Pair(PK_EXIT, apiResponse));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit exitPK$lambda$5(RoomPKViewModel roomPKViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomPKViewModel.getMException().setValue(new Pair(PK_EXIT, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit roomCurrentPK$lambda$0(RoomPKViewModel roomPKViewModel, ApiResponse apiResponse) {
        List list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        roomPKViewModel.pkListData.setList((ApiList) apiResponse.getData());
        MutableLiveData<List<RoomCurrentPK>> mutableLiveData = roomPKViewModel.onPKListMutable;
        ApiList apiList = (ApiList) apiResponse.getData();
        if (apiList != null) {
            list = apiList.getData();
        } else {
            list = null;
        }
        mutableLiveData.setValue(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit roomCurrentPK$lambda$1(RoomPKViewModel roomPKViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomPKViewModel.getMException().setValue(new Pair(PK_LIST, th));
        roomPKViewModel.pkListData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startMatch$lambda$2(RoomPKViewModel roomPKViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        roomPKViewModel.getMSuccess().setValue(new Pair(PK_CREATE, apiResponse));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startMatch$lambda$3(RoomPKViewModel roomPKViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomPKViewModel.getMException().setValue(new Pair(PK_CREATE, th));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void upMic$default(RoomPKViewModel roomPKViewModel, Integer num, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        roomPKViewModel.upMic(num, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upMic$lambda$8(boolean z, RoomPKViewModel roomPKViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk() && !z) {
            roomPKViewModel.getMSuccess().setValue(new Pair(PK_AUTO_MIC, apiResponse));
            HiloRtcEngine.INSTANCE.setClientRole(1);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upMic$lambda$9(RoomPKViewModel roomPKViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            int code = ((HiloException) th).getCode();
            if (code != 12008) {
                if (code != 12009) {
                    roomPKViewModel.getMException().setValue(new Pair(RoomViewModel.INTERFACE_UP_MIC, th));
                } else {
                    Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(roomPKViewModel, 2131953000), false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                }
            } else {
                Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(roomPKViewModel, 2131953529), false, 4, (Object) null);
                if (normal$default2 != null) {
                    normal$default2.show();
                }
            }
        } else {
            roomPKViewModel.getMException().setValue(new Pair(RoomViewModel.INTERFACE_UP_MIC, th));
        }
        return Unit.INSTANCE;
    }

    public final void acceptPK(@NotNull String groupId, @NotNull String targetGroupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(targetGroupId, "targetGroupId");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().acceptPK(groupId, targetGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.r
            public final Object invoke(Object obj) {
                Unit acceptPK$lambda$6;
                acceptPK$lambda$6 = RoomPKViewModel.acceptPK$lambda$6(RoomPKViewModel.this, (ApiResponse) obj);
                return acceptPK$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.s
            public final Object invoke(Object obj) {
                Unit acceptPK$lambda$7;
                acceptPK$lambda$7 = RoomPKViewModel.acceptPK$lambda$7(RoomPKViewModel.this, (Throwable) obj);
                return acceptPK$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void acceptStrangeChat(@NotNull String targetExternalId) {
        Intrinsics.checkNotNullParameter(targetExternalId, "targetExternalId");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().acceptStrangeMatch(targetExternalId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.y
            public final Object invoke(Object obj) {
                Unit acceptStrangeChat$lambda$10;
                acceptStrangeChat$lambda$10 = RoomPKViewModel.acceptStrangeChat$lambda$10(RoomPKViewModel.this, (ApiResponse) obj);
                return acceptStrangeChat$lambda$10;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.z
            public final Object invoke(Object obj) {
                Unit acceptStrangeChat$lambda$11;
                acceptStrangeChat$lambda$11 = RoomPKViewModel.acceptStrangeChat$lambda$11(RoomPKViewModel.this, (Throwable) obj);
                return acceptStrangeChat$lambda$11;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void exitPK(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().exitPK(groupId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.q
            public final Object invoke(Object obj) {
                Unit exitPK$lambda$4;
                exitPK$lambda$4 = RoomPKViewModel.exitPK$lambda$4(RoomPKViewModel.this, (ApiResponse) obj);
                return exitPK$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.t
            public final Object invoke(Object obj) {
                Unit exitPK$lambda$5;
                exitPK$lambda$5 = RoomPKViewModel.exitPK$lambda$5(RoomPKViewModel.this, (Throwable) obj);
                return exitPK$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final LiveData<List<RoomCurrentPK>> getPkList() {
        return this.onPKListMutable;
    }

    @NotNull
    public final BaseListData getPkListData() {
        return this.pkListData;
    }

    public final void roomCurrentPK() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().roomCurrentPK(this.pkListData.nextPage(), this.pkListData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.a0
            public final Object invoke(Object obj) {
                Unit roomCurrentPK$lambda$0;
                roomCurrentPK$lambda$0 = RoomPKViewModel.roomCurrentPK$lambda$0(RoomPKViewModel.this, (ApiResponse) obj);
                return roomCurrentPK$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.b0
            public final Object invoke(Object obj) {
                Unit roomCurrentPK$lambda$1;
                roomCurrentPK$lambda$1 = RoomPKViewModel.roomCurrentPK$lambda$1(RoomPKViewModel.this, (Throwable) obj);
                return roomCurrentPK$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void setPkListData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.pkListData = baseListData;
    }

    public final void startMatch(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().createPK(groupId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.w
            public final Object invoke(Object obj) {
                Unit startMatch$lambda$2;
                startMatch$lambda$2 = RoomPKViewModel.startMatch$lambda$2(RoomPKViewModel.this, (ApiResponse) obj);
                return startMatch$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.x
            public final Object invoke(Object obj) {
                Unit startMatch$lambda$3;
                startMatch$lambda$3 = RoomPKViewModel.startMatch$lambda$3(RoomPKViewModel.this, (Throwable) obj);
                return startMatch$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void upMic(@Nullable Integer micIndex, final boolean micForbid) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().upMic(MeetingRoomManager.INSTANCE.getMGroupId(), micIndex), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.u
            public final Object invoke(Object obj) {
                Unit upMic$lambda$8;
                upMic$lambda$8 = RoomPKViewModel.upMic$lambda$8(micForbid, this, (ApiResponse) obj);
                return upMic$lambda$8;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.v
            public final Object invoke(Object obj) {
                Unit upMic$lambda$9;
                upMic$lambda$9 = RoomPKViewModel.upMic$lambda$9(RoomPKViewModel.this, (Throwable) obj);
                return upMic$lambda$9;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }
}
