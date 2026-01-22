package com.qiahao.nextvideo.ui.videocall.matchinguser;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.common.VideoSetting;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.network.AppServer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011J.\u0010\u0007\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/matchinguser/VideoViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "videoSettingMutable", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qiahao/base_common/model/common/VideoSetting;", "videoSetting", "Landroidx/lifecycle/LiveData;", "getVideoSetting", "()Landroidx/lifecycle/LiveData;", "videoInter", "", "type", "", "num", "videoUid", "", "matchUid", "frontOrBack", "cameraOnOff", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoViewModel extends BaseViewModel {

    @NotNull
    private final MutableLiveData<VideoSetting> videoSettingMutable = new MutableLiveData<>();

    public static /* synthetic */ void videoInter$default(VideoViewModel videoViewModel, int i, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            str = null;
        }
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        videoViewModel.videoInter(i, i2, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit videoInter$lambda$0(int i, VideoViewModel videoViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (i == 1) {
            videoViewModel.getMSuccess().postValue(new Pair(String.valueOf(i), ""));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit videoInter$lambda$1(VideoViewModel videoViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        videoViewModel.getMException().postValue(new Pair("", th));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void videoSetting$default(VideoViewModel videoViewModel, int i, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str = null;
        }
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        videoViewModel.videoSetting(i, i2, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit videoSetting$lambda$2(VideoViewModel videoViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        videoViewModel.videoSettingMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit videoSetting$lambda$3(VideoViewModel videoViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        videoViewModel.getMException().postValue(new Pair("", th));
        return Unit.INSTANCE;
    }

    @NotNull
    public final LiveData<VideoSetting> getVideoSetting() {
        return this.videoSettingMutable;
    }

    public final void videoInter(final int type, int num, @Nullable String videoUid, @Nullable String matchUid) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().videoInter(type, num, videoUid, matchUid), new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.z
            public final Object invoke(Object obj) {
                Unit videoInter$lambda$0;
                videoInter$lambda$0 = VideoViewModel.videoInter$lambda$0(type, this, (ApiResponse) obj);
                return videoInter$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.a0
            public final Object invoke(Object obj) {
                Unit videoInter$lambda$1;
                videoInter$lambda$1 = VideoViewModel.videoInter$lambda$1(VideoViewModel.this, (Throwable) obj);
                return videoInter$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void videoSetting(int frontOrBack, int cameraOnOff, @Nullable String videoUid, @Nullable String matchUid) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().videoSetting(frontOrBack, cameraOnOff, videoUid, matchUid), new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.x
            public final Object invoke(Object obj) {
                Unit videoSetting$lambda$2;
                videoSetting$lambda$2 = VideoViewModel.videoSetting$lambda$2(VideoViewModel.this, (ApiResponse) obj);
                return videoSetting$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.y
            public final Object invoke(Object obj) {
                Unit videoSetting$lambda$3;
                videoSetting$lambda$3 = VideoViewModel.videoSetting$lambda$3(VideoViewModel.this, (Throwable) obj);
                return videoSetting$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }
}
