package com.qiahao.nextvideo.room.record;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.room.RoomRecordData;
import com.qiahao.nextvideo.network.AppServer;
import com.taobao.accs.utl.BaseMonitor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0012\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u001aH\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00138F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/room/record/RoomRecordViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "mUser", "Lcom/qiahao/base_common/model/common/User;", "getMUser", "()Lcom/qiahao/base_common/model/common/User;", "setMUser", "(Lcom/qiahao/base_common/model/common/User;)V", "roomRecordData", "Lcom/qiahao/base_common/model/BaseListData;", "getRoomRecordData", "()Lcom/qiahao/base_common/model/BaseListData;", "roomRecordMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/nextvideo/data/room/RoomRecordData;", "roomRecord", "Landroidx/lifecycle/LiveData;", "getRoomRecord", "()Landroidx/lifecycle/LiveData;", "errorMutable", "", BaseMonitor.COUNT_ERROR, "getError", "", "groupId", "", "type", "", "onCleared", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomRecordViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomRecordViewModel.kt\ncom/qiahao/nextvideo/room/record/RoomRecordViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,58:1\n1#2:59\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomRecordViewModel extends BaseViewModel {

    @NotNull
    private final MutableLiveData<Throwable> errorMutable;

    @Nullable
    private User mUser;

    @NotNull
    private final BaseListData roomRecordData;

    @NotNull
    private final MutableLiveData<List<RoomRecordData>> roomRecordMutable;

    public RoomRecordViewModel() {
        BaseListData baseListData = new BaseListData();
        baseListData.setPageSize(20);
        this.roomRecordData = baseListData;
        this.roomRecordMutable = new MutableLiveData<>();
        this.errorMutable = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit roomRecord$lambda$2(RoomRecordViewModel roomRecordViewModel, ApiResponse apiResponse) {
        List data;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        roomRecordViewModel.roomRecordData.setList((ApiList) apiResponse.getData());
        ApiList apiList = (ApiList) apiResponse.getData();
        if (apiList != null && (data = apiList.getData()) != null) {
            roomRecordViewModel.roomRecordMutable.setValue(data);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit roomRecord$lambda$3(RoomRecordViewModel roomRecordViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomRecordViewModel.roomRecordData.requestError();
        return Unit.INSTANCE;
    }

    @NotNull
    public final LiveData<Throwable> getError() {
        return this.errorMutable;
    }

    @Nullable
    public final User getMUser() {
        return this.mUser;
    }

    @NotNull
    public final LiveData<List<RoomRecordData>> getRoomRecord() {
        return this.roomRecordMutable;
    }

    @NotNull
    public final BaseListData getRoomRecordData() {
        return this.roomRecordData;
    }

    protected void onCleared() {
        super.onCleared();
        this.roomRecordData.destroy();
    }

    public final void roomRecord(@NotNull String groupId, int type) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().roomRecord(groupId, type, this.roomRecordData.nextPage(), this.roomRecordData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.room.record.j
            public final Object invoke(Object obj) {
                Unit roomRecord$lambda$2;
                roomRecord$lambda$2 = RoomRecordViewModel.roomRecord$lambda$2(RoomRecordViewModel.this, (ApiResponse) obj);
                return roomRecord$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.record.k
            public final Object invoke(Object obj) {
                Unit roomRecord$lambda$3;
                roomRecord$lambda$3 = RoomRecordViewModel.roomRecord$lambda$3(RoomRecordViewModel.this, (Throwable) obj);
                return roomRecord$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void setMUser(@Nullable User user) {
        this.mUser = user;
    }
}
