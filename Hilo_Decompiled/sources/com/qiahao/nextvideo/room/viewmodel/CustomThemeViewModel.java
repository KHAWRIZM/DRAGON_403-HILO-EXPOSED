package com.qiahao.nextvideo.room.viewmodel;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;
import androidx.lifecycle.ViewModelKt;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.GroupThemeCustomConfig;
import com.qiahao.nextvideo.data.model.UploadCustomThemeBean;
import com.qiahao.nextvideo.data.service.AliCloudService;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.yalantis.ucrop.util.FileUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0003R\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#¨\u0006)"}, d2 = {"Lcom/qiahao/nextvideo/room/viewmodel/CustomThemeViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "", "uploadImage", "", "ossFileUri", "md5", "spendMoneyToUploadTheme", "(Ljava/lang/String;Ljava/lang/String;)V", "getConfig", "mFilePath", "Ljava/lang/String;", "getMFilePath", "()Ljava/lang/String;", "setMFilePath", "(Ljava/lang/String;)V", "mGroupId", "getMGroupId", "setMGroupId", "", "mNowSize", "I", "getMNowSize", "()I", "setMNowSize", "(I)V", "Lma/b;", "Lcom/qiahao/nextvideo/data/model/GroupThemeCustomConfig;", "mCustomConfigUnPeekLiveData", "Lma/b;", "getMCustomConfigUnPeekLiveData", "()Lma/b;", "setMCustomConfigUnPeekLiveData", "(Lma/b;)V", "", "mUploadSuccessUnPeekLiveData", "getMUploadSuccessUnPeekLiveData", "setMUploadSuccessUnPeekLiveData", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CustomThemeViewModel extends BaseViewModel {

    @NotNull
    private static final String TAG = "CustomThemeViewModel";
    private int mNowSize;

    @NotNull
    private String mFilePath = "";

    @NotNull
    private String mGroupId = "";

    @NotNull
    private ma.b mCustomConfigUnPeekLiveData = new ma.b();

    @NotNull
    private ma.b mUploadSuccessUnPeekLiveData = new ma.b();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getConfig$lambda$6(CustomThemeViewModel customThemeViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        GroupThemeCustomConfig groupThemeCustomConfig = (GroupThemeCustomConfig) apiResponse.getData();
        if (groupThemeCustomConfig != null) {
            customThemeViewModel.mCustomConfigUnPeekLiveData.setValue(groupThemeCustomConfig);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getConfig$lambda$7(CustomThemeViewModel customThemeViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(customThemeViewModel, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit spendMoneyToUploadTheme$lambda$3(CustomThemeViewModel customThemeViewModel, ApiResponse apiResponse) {
        Double d;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UploadCustomThemeBean uploadCustomThemeBean = (UploadCustomThemeBean) apiResponse.getData();
        if (uploadCustomThemeBean != null) {
            cf.c.c().l(new RoomEvent().updateGroupBackGroup(uploadCustomThemeBean.getThemeId(), uploadCustomThemeBean.getThemeUrl(), 2));
            MeetingRoomManager.INSTANCE.getWsFlow().tryEmit(new RoomEvent().setEventId(RoomEvent.UPDATE_CUSTOM_THEME));
            UserStore.Companion companion = UserStore.INSTANCE;
            User user = companion.getShared().getUser();
            if (user != null) {
                d = Double.valueOf(user.getDiamondNum());
            } else {
                d = null;
            }
            if (!Intrinsics.areEqual(d, uploadCustomThemeBean.getDiamondNum())) {
                UserStore.refreshDiamondOrGem$default(companion.getShared(), uploadCustomThemeBean.getDiamondNum(), 0.0d, 2, null);
            }
            customThemeViewModel.mUploadSuccessUnPeekLiveData.setValue(Boolean.TRUE);
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(customThemeViewModel, 2131954176), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            Log.d(TAG, "spendMoneyToUploadTheme: " + uploadCustomThemeBean.getDiamondNum());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit spendMoneyToUploadTheme$lambda$4(CustomThemeViewModel customThemeViewModel, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(customThemeViewModel, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, currentActivity, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit uploadImage$lambda$0(CustomThemeViewModel customThemeViewModel, File file, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        if (((Boolean) pair.getFirst()).booleanValue()) {
            Log.d(TAG, "uploadImage: " + pair.getSecond());
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(customThemeViewModel), (CoroutineContext) null, (CoroutineStart) null, new CustomThemeViewModel$uploadImage$1$1(file, customThemeViewModel, pair, null), 3, (Object) null);
        } else {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(customThemeViewModel, 2131952667), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit uploadImage$lambda$1(CustomThemeViewModel customThemeViewModel, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        String message = th.getMessage();
        if (message == null) {
            str = ResourcesKtxKt.getStringById(customThemeViewModel, 2131952667);
        } else {
            str = message;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, currentActivity, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public final void getConfig() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getCustomThemeConfig(), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.a
            public final Object invoke(Object obj) {
                Unit config$lambda$6;
                config$lambda$6 = CustomThemeViewModel.getConfig$lambda$6(CustomThemeViewModel.this, (ApiResponse) obj);
                return config$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.b
            public final Object invoke(Object obj) {
                Unit config$lambda$7;
                config$lambda$7 = CustomThemeViewModel.getConfig$lambda$7(CustomThemeViewModel.this, (Throwable) obj);
                return config$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final ma.b getMCustomConfigUnPeekLiveData() {
        return this.mCustomConfigUnPeekLiveData;
    }

    @NotNull
    public final String getMFilePath() {
        return this.mFilePath;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    public final int getMNowSize() {
        return this.mNowSize;
    }

    @NotNull
    public final ma.b getMUploadSuccessUnPeekLiveData() {
        return this.mUploadSuccessUnPeekLiveData;
    }

    public final void setMCustomConfigUnPeekLiveData(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mCustomConfigUnPeekLiveData = bVar;
    }

    public final void setMFilePath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mFilePath = str;
    }

    public final void setMGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGroupId = str;
    }

    public final void setMNowSize(int i) {
        this.mNowSize = i;
    }

    public final void setMUploadSuccessUnPeekLiveData(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mUploadSuccessUnPeekLiveData = bVar;
    }

    public final void spendMoneyToUploadTheme(@NotNull String ossFileUri, @NotNull String md5) {
        Intrinsics.checkNotNullParameter(ossFileUri, "ossFileUri");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Log.d(TAG, "spendMoneyToUploadPic: 上传themes到后台");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().uploadThemeCustom(ossFileUri, this.mGroupId, md5), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.e
            public final Object invoke(Object obj) {
                Unit spendMoneyToUploadTheme$lambda$3;
                spendMoneyToUploadTheme$lambda$3 = CustomThemeViewModel.spendMoneyToUploadTheme$lambda$3(CustomThemeViewModel.this, (ApiResponse) obj);
                return spendMoneyToUploadTheme$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.f
            public final Object invoke(Object obj) {
                Unit spendMoneyToUploadTheme$lambda$4;
                spendMoneyToUploadTheme$lambda$4 = CustomThemeViewModel.spendMoneyToUploadTheme$lambda$4(CustomThemeViewModel.this, (Throwable) obj);
                return spendMoneyToUploadTheme$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void uploadImage() {
        final File file = new File(this.mFilePath);
        if (!file.exists()) {
            return;
        }
        String str = this.mFilePath;
        String str2 = FileUtils.GIF;
        if (!StringsKt.endsWith$default(str, FileUtils.GIF, false, 2, (Object) null)) {
            str2 = ".png";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AliCloudService.INSTANCE.getShared().uploadFileToAWS(AliCloudService.OSS_FOLDER_GROUP, file, str2), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.c
            public final Object invoke(Object obj) {
                Unit uploadImage$lambda$0;
                uploadImage$lambda$0 = CustomThemeViewModel.uploadImage$lambda$0(CustomThemeViewModel.this, file, (Pair) obj);
                return uploadImage$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.d
            public final Object invoke(Object obj) {
                Unit uploadImage$lambda$1;
                uploadImage$lambda$1 = CustomThemeViewModel.uploadImage$lambda$1(CustomThemeViewModel.this, (Throwable) obj);
                return uploadImage$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }
}
