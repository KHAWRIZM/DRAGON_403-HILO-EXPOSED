package com.qiahao.nextvideo.ui.profile.activity;

import android.widget.Toast;
import com.oudi.core.loading.ILoading;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.ui.userdetail.UserDetailPictureAdapterListener;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/qiahao/nextvideo/ui/profile/activity/UserInfoEditActivity$initRecyclerView$1$1", "Lcom/qiahao/nextvideo/ui/userdetail/UserDetailPictureAdapterListener;", "deleteUserDetailPhoto", "", "position", "", "editUserHead", "addUserDetailPhoto", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class UserInfoEditActivity$initRecyclerView$1$1 implements UserDetailPictureAdapterListener {
    final /* synthetic */ UserInfoEditActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UserInfoEditActivity$initRecyclerView$1$1(UserInfoEditActivity userInfoEditActivity) {
        this.this$0 = userInfoEditActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit deleteUserDetailPhoto$lambda$0(UserInfoEditActivity userInfoEditActivity, UserInfoEditActivity$initRecyclerView$1$1 userInfoEditActivity$initRecyclerView$1$1, ApiResponse apiResponse) {
        String str;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            userInfoEditActivity.getPhotoData(true);
        } else {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String message = apiResponse.getMessage();
            if (message == null) {
                str = ResourcesKtxKt.getStringById(userInfoEditActivity$initRecyclerView$1$1, 2131954177);
            } else {
                str = message;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, userInfoEditActivity, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit deleteUserDetailPhoto$lambda$1(UserInfoEditActivity userInfoEditActivity, UserInfoEditActivity$initRecyclerView$1$1 userInfoEditActivity$initRecyclerView$1$1, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = ResourcesKtxKt.getStringById(userInfoEditActivity$initRecyclerView$1$1, 2131952667);
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, userInfoEditActivity, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteUserDetailPhoto$lambda$2(UserInfoEditActivity userInfoEditActivity) {
        ILoading.DefaultImpls.dismissLoading$default(userInfoEditActivity, (Integer) null, 1, (Object) null);
        return Unit.INSTANCE;
    }

    @Override // com.qiahao.nextvideo.ui.userdetail.UserDetailPictureAdapterListener
    public void addUserDetailPhoto(int position) {
        boolean z;
        UserInfoEditActivity userInfoEditActivity = this.this$0;
        if (position == 0) {
            z = true;
        } else {
            z = false;
        }
        userInfoEditActivity.setUpdateHeadImage(z);
        this.this$0.checkUserNobel();
    }

    @Override // com.qiahao.nextvideo.ui.userdetail.UserDetailPictureAdapterListener
    public void deleteUserDetailPhoto(int position) {
        this.this$0.setUpdateHeadImage(false);
        if (!this.this$0.getPhotoList().isEmpty() && position != this.this$0.getPhotoList().size() && position <= this.this$0.getPhotoList().size()) {
            ArrayList arrayList = new ArrayList();
            int size = this.this$0.getPhotoList().size();
            for (int i = 0; i < size; i++) {
                arrayList.add(this.this$0.getPhotoList().get(i));
            }
            arrayList.remove(position);
            ILoading.DefaultImpls.showLoading$default(this.this$0, (Integer) null, (CharSequence) null, 3, (Object) null);
            io.reactivex.rxjava3.core.i0 fetchSetUserPhotos$default = UserService.fetchSetUserPhotos$default(UserService.INSTANCE.getShared(), DataExternalKt.arrayListToString(arrayList), null, 2, null);
            final UserInfoEditActivity userInfoEditActivity = this.this$0;
            Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.u2
                public final Object invoke(Object obj) {
                    Unit deleteUserDetailPhoto$lambda$0;
                    deleteUserDetailPhoto$lambda$0 = UserInfoEditActivity$initRecyclerView$1$1.deleteUserDetailPhoto$lambda$0(UserInfoEditActivity.this, this, (ApiResponse) obj);
                    return deleteUserDetailPhoto$lambda$0;
                }
            };
            final UserInfoEditActivity userInfoEditActivity2 = this.this$0;
            Function1 function12 = new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.v2
                public final Object invoke(Object obj) {
                    Unit deleteUserDetailPhoto$lambda$1;
                    deleteUserDetailPhoto$lambda$1 = UserInfoEditActivity$initRecyclerView$1$1.deleteUserDetailPhoto$lambda$1(UserInfoEditActivity.this, this, (Throwable) obj);
                    return deleteUserDetailPhoto$lambda$1;
                }
            };
            final UserInfoEditActivity userInfoEditActivity3 = this.this$0;
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(fetchSetUserPhotos$default, function1, function12, new Function0() { // from class: com.qiahao.nextvideo.ui.profile.activity.w2
                public final Object invoke() {
                    Unit deleteUserDetailPhoto$lambda$2;
                    deleteUserDetailPhoto$lambda$2 = UserInfoEditActivity$initRecyclerView$1$1.deleteUserDetailPhoto$lambda$2(UserInfoEditActivity.this);
                    return deleteUserDetailPhoto$lambda$2;
                }
            }, false, 8, (Object) null), this.this$0.getCompositeDisposable());
        }
    }

    @Override // com.qiahao.nextvideo.ui.userdetail.UserDetailPictureAdapterListener
    public void editUserHead() {
        this.this$0.setUpdateHeadImage(true);
        this.this$0.checkUserNobel();
    }
}
