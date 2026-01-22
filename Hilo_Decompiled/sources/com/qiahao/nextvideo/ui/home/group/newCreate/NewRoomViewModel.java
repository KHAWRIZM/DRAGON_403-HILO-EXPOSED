package com.qiahao.nextvideo.ui.home.group.newCreate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.model.NewRoomBean;
import com.qiahao.nextvideo.network.AppServer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00060\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/group/newCreate/NewRoomViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "newUserMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/base_common/model/common/User;", "newUser", "Landroidx/lifecycle/LiveData;", "getNewUser", "()Landroidx/lifecycle/LiveData;", "newRoomMutable", "Lcom/qiahao/nextvideo/data/model/NewRoomBean;", "newRoom", "getNewRoom", "getNewUserList", "", "getNewRoomList", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class NewRoomViewModel extends BaseViewModel {

    @NotNull
    public static final String NEW_ROOM = "new_room";

    @NotNull
    public static final String NEW_USER = "new_user";

    @NotNull
    private final MutableLiveData<List<User>> newUserMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<List<NewRoomBean>> newRoomMutable = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getNewRoomList$lambda$4(NewRoomViewModel newRoomViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List list = (List) apiResponse.getData();
        if (list != null) {
            newRoomViewModel.newRoomMutable.setValue(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getNewRoomList$lambda$5(NewRoomViewModel newRoomViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        newRoomViewModel.getMException().setValue(new Pair(NEW_ROOM, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getNewUserList$lambda$1(NewRoomViewModel newRoomViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List list = (List) apiResponse.getData();
        if (list != null) {
            newRoomViewModel.newUserMutable.setValue(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getNewUserList$lambda$2(NewRoomViewModel newRoomViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        newRoomViewModel.getMException().setValue(new Pair(NEW_USER, th));
        return Unit.INSTANCE;
    }

    @NotNull
    public final LiveData<List<NewRoomBean>> getNewRoom() {
        return this.newRoomMutable;
    }

    public final void getNewRoomList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().newRoomList(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.newCreate.m
            public final Object invoke(Object obj) {
                Unit newRoomList$lambda$4;
                newRoomList$lambda$4 = NewRoomViewModel.getNewRoomList$lambda$4(NewRoomViewModel.this, (ApiResponse) obj);
                return newRoomList$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.newCreate.n
            public final Object invoke(Object obj) {
                Unit newRoomList$lambda$5;
                newRoomList$lambda$5 = NewRoomViewModel.getNewRoomList$lambda$5(NewRoomViewModel.this, (Throwable) obj);
                return newRoomList$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final LiveData<List<User>> getNewUser() {
        return this.newUserMutable;
    }

    public final void getNewUserList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().newUserList(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.newCreate.k
            public final Object invoke(Object obj) {
                Unit newUserList$lambda$1;
                newUserList$lambda$1 = NewRoomViewModel.getNewUserList$lambda$1(NewRoomViewModel.this, (ApiResponse) obj);
                return newUserList$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.newCreate.l
            public final Object invoke(Object obj) {
                Unit newUserList$lambda$2;
                newUserList$lambda$2 = NewRoomViewModel.getNewUserList$lambda$2(NewRoomViewModel.this, (Throwable) obj);
                return newUserList$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }
}
