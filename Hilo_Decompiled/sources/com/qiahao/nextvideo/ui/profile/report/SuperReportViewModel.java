package com.qiahao.nextvideo.ui.profile.report;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.luck.picture.lib.entity.LocalMedia;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.model.SelectImageData;
import com.qiahao.nextvideo.data.service.AliCloudService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.utilities.StorageUtils;
import io.reactivex.rxjava3.core.i0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cJ7\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010%R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00108F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00108F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/report/SuperReportViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "repository", "Lcom/qiahao/nextvideo/data/service/UserService;", "<init>", "(Lcom/qiahao/nextvideo/data/service/UserService;)V", "urlList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getUrlList", "()Ljava/util/ArrayList;", "showDialogMutable", "Landroidx/lifecycle/MutableLiveData;", "", "showDialog", "Landroidx/lifecycle/LiveData;", "getShowDialog", "()Landroidx/lifecycle/LiveData;", "uploadSuccessMutable", "uploadSuccess", "getUploadSuccess", "reportSuccessMutable", "reportSuccess", "getReportSuccess", "uploadFile", "", "list", "", "Lcom/qiahao/nextvideo/data/model/SelectImageData;", "superAdminReport", "toUserExternalId", "reasonType", "", "reason", "imageUrl", "hours", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSuperReportViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperReportViewModel.kt\ncom/qiahao/nextvideo/ui/profile/report/SuperReportViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,120:1\n1869#2,2:121\n*S KotlinDebug\n*F\n+ 1 SuperReportViewModel.kt\ncom/qiahao/nextvideo/ui/profile/report/SuperReportViewModel\n*L\n52#1:121,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SuperReportViewModel extends BaseViewModel {

    @NotNull
    private final MutableLiveData<Boolean> reportSuccessMutable;

    @Nullable
    private final UserService repository;

    @NotNull
    private final MutableLiveData<Boolean> showDialogMutable;

    @NotNull
    private final MutableLiveData<Boolean> uploadSuccessMutable;

    @NotNull
    private final ArrayList<String> urlList;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SuperReportViewModel() {
        this(r0, 1, r0);
        UserService userService = null;
    }

    public static /* synthetic */ void superAdminReport$default(SuperReportViewModel superReportViewModel, String str, int i, String str2, String str3, Integer num, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            num = null;
        }
        superReportViewModel.superAdminReport(str, i, str2, str3, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit superAdminReport$lambda$5(SuperReportViewModel superReportViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        superReportViewModel.showDialogMutable.setValue(Boolean.FALSE);
        superReportViewModel.reportSuccessMutable.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit superAdminReport$lambda$6(SuperReportViewModel superReportViewModel, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        superReportViewModel.showDialogMutable.setValue(Boolean.FALSE);
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(superReportViewModel, 2131952667);
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
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit uploadFile$lambda$4$lambda$3$lambda$1(Ref.IntRef intRef, SuperReportViewModel superReportViewModel, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        intRef.element--;
        if (((Boolean) pair.getFirst()).booleanValue()) {
            superReportViewModel.urlList.add(pair.getSecond());
        }
        if (intRef.element <= 0) {
            superReportViewModel.uploadSuccessMutable.setValue(Boolean.TRUE);
            superReportViewModel.showDialogMutable.setValue(Boolean.FALSE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit uploadFile$lambda$4$lambda$3$lambda$2(Ref.IntRef intRef, SuperReportViewModel superReportViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        int i = intRef.element - 1;
        intRef.element = i;
        if (i <= 0) {
            superReportViewModel.uploadSuccessMutable.setValue(Boolean.TRUE);
            superReportViewModel.showDialogMutable.setValue(Boolean.FALSE);
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public final LiveData<Boolean> getReportSuccess() {
        return this.reportSuccessMutable;
    }

    @NotNull
    public final LiveData<Boolean> getShowDialog() {
        return this.showDialogMutable;
    }

    @NotNull
    public final LiveData<Boolean> getUploadSuccess() {
        return this.uploadSuccessMutable;
    }

    @NotNull
    public final ArrayList<String> getUrlList() {
        return this.urlList;
    }

    public final void superAdminReport(@NotNull String toUserExternalId, int reasonType, @NotNull String reason, @NotNull String imageUrl, @Nullable Integer hours) {
        i0<ApiResponse<Object>> superAdminReport;
        nd.c observeOnMainThread$default;
        Intrinsics.checkNotNullParameter(toUserExternalId, "toUserExternalId");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        this.reportSuccessMutable.setValue(Boolean.FALSE);
        this.showDialogMutable.setValue(Boolean.TRUE);
        UserService userService = this.repository;
        if (userService != null && (superAdminReport = userService.superAdminReport(toUserExternalId, reasonType, reason, imageUrl, hours)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(superAdminReport, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.report.i
            public final Object invoke(Object obj) {
                Unit superAdminReport$lambda$5;
                superAdminReport$lambda$5 = SuperReportViewModel.superAdminReport$lambda$5(SuperReportViewModel.this, (ApiResponse) obj);
                return superAdminReport$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.report.j
            public final Object invoke(Object obj) {
                Unit superAdminReport$lambda$6;
                superAdminReport$lambda$6 = SuperReportViewModel.superAdminReport$lambda$6(SuperReportViewModel.this, (Throwable) obj);
                return superAdminReport$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void uploadFile(@NotNull List<SelectImageData> list) {
        String compressPath;
        Intrinsics.checkNotNullParameter(list, "list");
        final Ref.IntRef intRef = new Ref.IntRef();
        this.urlList.clear();
        this.uploadSuccessMutable.setValue(Boolean.FALSE);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            LocalMedia media = ((SelectImageData) it.next()).getMedia();
            if (media != null) {
                this.showDialogMutable.setValue(Boolean.TRUE);
                intRef.element++;
                if (media.isCut() && !media.isCompressed()) {
                    compressPath = media.getCutPath();
                } else if (!media.isCompressed() && (!media.isCut() || !media.isCompressed())) {
                    if (!TextUtils.isEmpty(media.getRealPath())) {
                        compressPath = media.getRealPath();
                    } else {
                        compressPath = media.getPath();
                    }
                } else {
                    compressPath = media.getCompressPath();
                }
                File fileCompat = StorageUtils.INSTANCE.getFileCompat(compressPath);
                if (fileCompat != null && fileCompat.exists()) {
                    AliCloudService shared = AliCloudService.INSTANCE.getShared();
                    String mimeType = media.getMimeType();
                    if (mimeType == null) {
                        mimeType = "";
                    }
                    RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AliCloudService.uploadFile$default(shared, AliCloudService.OSS_USER_REPORTS, fileCompat, StringsKt.contains$default(mimeType, "video", false, 2, (Object) null), null, 8, null), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.report.k
                        public final Object invoke(Object obj) {
                            Unit uploadFile$lambda$4$lambda$3$lambda$1;
                            uploadFile$lambda$4$lambda$3$lambda$1 = SuperReportViewModel.uploadFile$lambda$4$lambda$3$lambda$1(intRef, this, (Pair) obj);
                            return uploadFile$lambda$4$lambda$3$lambda$1;
                        }
                    }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.report.l
                        public final Object invoke(Object obj) {
                            Unit uploadFile$lambda$4$lambda$3$lambda$2;
                            uploadFile$lambda$4$lambda$3$lambda$2 = SuperReportViewModel.uploadFile$lambda$4$lambda$3$lambda$2(intRef, this, (Throwable) obj);
                            return uploadFile$lambda$4$lambda$3$lambda$2;
                        }
                    }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
                } else {
                    return;
                }
            }
        }
    }

    public SuperReportViewModel(@Nullable UserService userService) {
        this.repository = userService;
        this.urlList = new ArrayList<>();
        this.showDialogMutable = new MutableLiveData<>();
        this.uploadSuccessMutable = new MutableLiveData<>();
        this.reportSuccessMutable = new MutableLiveData<>();
    }

    public /* synthetic */ SuperReportViewModel(UserService userService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserService() : userService);
    }
}
