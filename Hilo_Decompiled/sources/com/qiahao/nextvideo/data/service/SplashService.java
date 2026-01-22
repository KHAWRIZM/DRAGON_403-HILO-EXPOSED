package com.qiahao.nextvideo.data.service;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import com.oudi.core.support.ActivityLifecycleManager;
import com.qiahao.base_common.network.BaseServer;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.network.model.DownloadProgressModel;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.app.MainActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.cache.MMKVToLocalCache;
import com.qiahao.nextvideo.data.model.OpenScreenBean;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.utilities.FileManager;
import io.reactivex.rxjava3.core.i0;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\b2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0003J'\u0010\u0011\u001a\u00020\u000e2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0003J\u001f\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001a0\u00190\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00190\u0018¢\u0006\u0004\b\u001d\u0010\u001cR\u0017\u0010\u001f\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R%\u0010%\u001a\u0010\u0012\f\u0012\n $*\u0004\u0018\u00010\b0\b0#8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R%\u0010*\u001a\u0010\u0012\f\u0012\n $*\u0004\u0018\u00010\b0\b0)8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/qiahao/nextvideo/data/service/SplashService;", "", "<init>", "()V", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/OpenScreenBean;", "Lkotlin/collections/ArrayList;", "arraylist", "", "needChange", "(Ljava/util/ArrayList;)Z", "", "getMaxSize", "()I", "", "gotoDownloadGlobalOpenSource", "arrayList", "downloadDataToLocalFile", "(Ljava/util/ArrayList;)V", "needShowH5", "()Z", "getCurrentShowData", "()Lcom/qiahao/nextvideo/data/model/OpenScreenBean;", "clear", "Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/base_common/network/model/ApiResponse;", "", "getOpenScreenSource", "()Lio/reactivex/rxjava3/core/i0;", "getOperationWindow", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "Lla/b;", "kotlin.jvm.PlatformType", "imSDkLoginBehaviorRelay", "Lla/b;", "getImSDkLoginBehaviorRelay", "()Lla/b;", "Lla/c;", "mOperationDialogPublishRelay", "Lla/c;", "getMOperationDialogPublishRelay", "()Lla/c;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SplashService {

    @NotNull
    public static final String TAG = "SplashService";

    @NotNull
    private final la.b imSDkLoginBehaviorRelay;

    @NotNull
    private final nd.a mCompositeDisposable = new nd.a();

    @NotNull
    private final la.c mOperationDialogPublishRelay;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final SplashService shared = new SplashService();

    @NotNull
    private static String mAdvertisingH5 = "";

    @NotNull
    private static String mGroupId = "";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/data/service/SplashService$Companion;", "", "<init>", "()V", "TAG", "", "shared", "Lcom/qiahao/nextvideo/data/service/SplashService;", "getShared", "()Lcom/qiahao/nextvideo/data/service/SplashService;", "mAdvertisingH5", "getMAdvertisingH5", "()Ljava/lang/String;", "setMAdvertisingH5", "(Ljava/lang/String;)V", "mGroupId", "getMGroupId", "setMGroupId", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getMAdvertisingH5() {
            return SplashService.mAdvertisingH5;
        }

        @NotNull
        public final String getMGroupId() {
            return SplashService.mGroupId;
        }

        @NotNull
        public final SplashService getShared() {
            return SplashService.shared;
        }

        public final void setMAdvertisingH5(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            SplashService.mAdvertisingH5 = str;
        }

        public final void setMGroupId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            SplashService.mGroupId = str;
        }

        private Companion() {
        }
    }

    public SplashService() {
        la.b e = la.b.e();
        Intrinsics.checkNotNullExpressionValue(e, "create(...)");
        this.imSDkLoginBehaviorRelay = e;
        la.c e2 = la.c.e();
        Intrinsics.checkNotNullExpressionValue(e2, "create(...)");
        this.mOperationDialogPublishRelay = e2;
    }

    private final int getMaxSize() {
        ArrayList<OpenScreenBean> openSourceData = MMKVToLocalCache.INSTANCE.getOpenSourceData();
        if (openSourceData != null && !openSourceData.isEmpty()) {
            Intrinsics.checkNotNull(openSourceData);
            return openSourceData.size();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean needChange(ArrayList<OpenScreenBean> arraylist) {
        boolean z;
        boolean z2;
        String localPic2Url;
        boolean z3;
        String localPic1Url;
        boolean z4;
        ArrayList<OpenScreenBean> openSourceData = MMKVToLocalCache.INSTANCE.getOpenSourceData();
        if (openSourceData == null || arraylist.size() != openSourceData.size()) {
            return true;
        }
        int size = openSourceData.size();
        boolean z5 = false;
        for (int i = 0; i < size; i++) {
            int size2 = arraylist.size();
            boolean z6 = false;
            for (int i2 = 0; i2 < size2; i2++) {
                if (openSourceData.get(i).getId() == arraylist.get(i2).getId() && Intrinsics.areEqual(arraylist.get(i2).getPic1Url(), openSourceData.get(i).getPic1Url()) && Intrinsics.areEqual(arraylist.get(i2).getPic2Url(), openSourceData.get(i).getPic2Url()) && Intrinsics.areEqual(arraylist.get(i2).getNick1(), openSourceData.get(i).getNick1()) && Intrinsics.areEqual(arraylist.get(i2).getNick2(), openSourceData.get(i).getNick2()) && arraylist.get(i2).getType() == openSourceData.get(i).getType() && Intrinsics.areEqual(arraylist.get(i2).getH5Url(), openSourceData.get(i).getH5Url()) && Intrinsics.areEqual(arraylist.get(i2).getBannerUrl(), openSourceData.get(i).getBannerUrl()) && Intrinsics.areEqual(arraylist.get(i2).getGroupId(), openSourceData.get(i).getGroupId())) {
                    int type = openSourceData.get(i).getType();
                    if (type != 0) {
                        if (type != 1) {
                            if (type == 2 && (localPic1Url = openSourceData.get(i).getLocalPic1Url()) != null) {
                                if (localPic1Url.length() == 0) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                if (!(!z4)) {
                                }
                                z6 = true;
                            }
                        } else {
                            String localPic1Url2 = openSourceData.get(i).getLocalPic1Url();
                            if (localPic1Url2 != null) {
                                if (localPic1Url2.length() == 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if ((!z2) && (localPic2Url = openSourceData.get(i).getLocalPic2Url()) != null) {
                                    if (localPic2Url.length() == 0) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    if (!(!z3)) {
                                    }
                                    z6 = true;
                                }
                            }
                        }
                    } else {
                        String localFile = openSourceData.get(i).getLocalFile();
                        if (localFile != null) {
                            if (localFile.length() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!(!z)) {
                            }
                            z6 = true;
                        }
                    }
                }
            }
            if (!z6) {
                z5 = true;
            }
        }
        return z5;
    }

    public final void clear() {
        this.mCompositeDisposable.d();
    }

    @SuppressLint({"SuspiciousIndentation"})
    public final void downloadDataToLocalFile(@NotNull final ArrayList<OpenScreenBean> arrayList) {
        File file;
        String pic1Url;
        File cacheDir;
        Intrinsics.checkNotNullParameter(arrayList, "arrayList");
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null && (cacheDir = currentActivity.getCacheDir()) != null) {
            file = cacheDir.getAbsoluteFile();
        } else {
            file = null;
        }
        String str = file + File.separator + "open_file";
        if (!new File(str).exists()) {
            boolean mkdir = new File(str).mkdir();
            Log.d(MainActivity.TAG, "downloadDataToLocalFile: " + mkdir + " 是否创建文件成功");
            if (!mkdir) {
                return;
            }
        }
        int size = arrayList.size();
        for (final int i = 0; i < size; i++) {
            int type = arrayList.get(i).getType();
            if (type != 0) {
                if (type != 1) {
                    if (type == 2 && (pic1Url = arrayList.get(i).getPic1Url()) != null && pic1Url.length() > 0) {
                        String imageSize = ImageSizeKt.imageSize(arrayList.get(i).getPic1Url(), 110);
                        nd.c subscribe = BaseServer.INSTANCE.download(imageSize, FileManager.INSTANCE.getTempUrlFileName("pic_week_star_" + arrayList.get(i).getId())).subscribeOn(ke.a.b()).observeOn(md.b.c()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.data.service.SplashService$downloadDataToLocalFile$7
                            public final void accept(DownloadProgressModel downloadProgressModel) {
                                String str2;
                                String absolutePath;
                                Intrinsics.checkNotNullParameter(downloadProgressModel, "it");
                                if (downloadProgressModel.isComplete()) {
                                    OpenScreenBean openScreenBean = arrayList.get(i);
                                    File file2 = downloadProgressModel.getFile();
                                    String str3 = "";
                                    if (file2 == null || (str2 = file2.getAbsolutePath()) == null) {
                                        str2 = "";
                                    }
                                    openScreenBean.setLocalPic1Url(str2);
                                    File file3 = downloadProgressModel.getFile();
                                    if (file3 != null && (absolutePath = file3.getAbsolutePath()) != null) {
                                        str3 = absolutePath;
                                    }
                                    Log.d(MainActivity.TAG, "downloadDataToLocalFile: 保存下载数据到本地 " + str3);
                                    MMKVToLocalCache.INSTANCE.saveOpenSourceData(arrayList);
                                }
                            }
                        }, new pd.g() { // from class: com.qiahao.nextvideo.data.service.SplashService$downloadDataToLocalFile$8
                            public final void accept(Throwable th) {
                                Intrinsics.checkNotNullParameter(th, "it");
                                Log.d(MainActivity.TAG, "downloadDataToLocalFile:下载失败 " + th.getLocalizedMessage());
                            }
                        });
                        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
                        RxUtilsKt.addTo(subscribe, this.mCompositeDisposable);
                    }
                } else {
                    String pic1Url2 = arrayList.get(i).getPic1Url();
                    if (pic1Url2 != null && pic1Url2.length() > 0) {
                        String imageSize2 = ImageSizeKt.imageSize(arrayList.get(i).getPic1Url(), 84);
                        nd.c subscribe2 = BaseServer.INSTANCE.download(imageSize2, FileManager.INSTANCE.getTempUrlFileName("pic_cp_pic1_" + arrayList.get(i).getId())).subscribeOn(ke.a.b()).observeOn(md.b.c()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.data.service.SplashService$downloadDataToLocalFile$3
                            public final void accept(DownloadProgressModel downloadProgressModel) {
                                String str2;
                                String absolutePath;
                                Intrinsics.checkNotNullParameter(downloadProgressModel, "it");
                                if (downloadProgressModel.isComplete()) {
                                    OpenScreenBean openScreenBean = arrayList.get(i);
                                    File file2 = downloadProgressModel.getFile();
                                    String str3 = "";
                                    if (file2 == null || (str2 = file2.getAbsolutePath()) == null) {
                                        str2 = "";
                                    }
                                    openScreenBean.setLocalPic1Url(str2);
                                    File file3 = downloadProgressModel.getFile();
                                    if (file3 != null && (absolutePath = file3.getAbsolutePath()) != null) {
                                        str3 = absolutePath;
                                    }
                                    Log.d(MainActivity.TAG, "downloadDataToLocalFile: 保存下载数据到本地 " + str3);
                                    MMKVToLocalCache.INSTANCE.saveOpenSourceData(arrayList);
                                }
                            }
                        }, new pd.g() { // from class: com.qiahao.nextvideo.data.service.SplashService$downloadDataToLocalFile$4
                            public final void accept(Throwable th) {
                                Intrinsics.checkNotNullParameter(th, "it");
                                Log.d(MainActivity.TAG, "downloadDataToLocalFile:下载失败 " + th.getLocalizedMessage());
                            }
                        });
                        Intrinsics.checkNotNullExpressionValue(subscribe2, "subscribe(...)");
                        RxUtilsKt.addTo(subscribe2, this.mCompositeDisposable);
                    }
                    String pic2Url = arrayList.get(i).getPic2Url();
                    if (pic2Url != null && pic2Url.length() > 0) {
                        String imageSize3 = ImageSizeKt.imageSize(arrayList.get(i).getPic2Url(), 84);
                        nd.c subscribe3 = BaseServer.INSTANCE.download(imageSize3, FileManager.INSTANCE.getTempUrlFileName("pic_cp_pic2_" + arrayList.get(i).getId())).subscribeOn(ke.a.b()).observeOn(md.b.c()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.data.service.SplashService$downloadDataToLocalFile$5
                            public final void accept(DownloadProgressModel downloadProgressModel) {
                                String str2;
                                String absolutePath;
                                Intrinsics.checkNotNullParameter(downloadProgressModel, "it");
                                if (downloadProgressModel.isComplete()) {
                                    OpenScreenBean openScreenBean = arrayList.get(i);
                                    File file2 = downloadProgressModel.getFile();
                                    String str3 = "";
                                    if (file2 == null || (str2 = file2.getAbsolutePath()) == null) {
                                        str2 = "";
                                    }
                                    openScreenBean.setLocalPic2Url(str2);
                                    File file3 = downloadProgressModel.getFile();
                                    if (file3 != null && (absolutePath = file3.getAbsolutePath()) != null) {
                                        str3 = absolutePath;
                                    }
                                    Log.d(MainActivity.TAG, "downloadDataToLocalFile: 保存下载数据到本地 " + str3);
                                    MMKVToLocalCache.INSTANCE.saveOpenSourceData(arrayList);
                                }
                            }
                        }, new pd.g() { // from class: com.qiahao.nextvideo.data.service.SplashService$downloadDataToLocalFile$6
                            public final void accept(Throwable th) {
                                Intrinsics.checkNotNullParameter(th, "it");
                                Log.d(MainActivity.TAG, "downloadDataToLocalFile:下载失败 " + th.getLocalizedMessage());
                            }
                        });
                        Intrinsics.checkNotNullExpressionValue(subscribe3, "subscribe(...)");
                        RxUtilsKt.addTo(subscribe3, this.mCompositeDisposable);
                    }
                }
            } else {
                String imageSize4 = ImageSizeKt.imageSize(arrayList.get(i).getBannerUrl(), Dimens.INSTANCE.getScreenWidth());
                nd.c subscribe4 = BaseServer.INSTANCE.download(imageSize4, FileManager.INSTANCE.getTempUrlFileName("pic" + arrayList.get(i).getId())).subscribeOn(ke.a.b()).observeOn(md.b.c()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.data.service.SplashService$downloadDataToLocalFile$1
                    public final void accept(DownloadProgressModel downloadProgressModel) {
                        String str2;
                        String absolutePath;
                        Intrinsics.checkNotNullParameter(downloadProgressModel, "it");
                        if (downloadProgressModel.isComplete()) {
                            OpenScreenBean openScreenBean = arrayList.get(i);
                            File file2 = downloadProgressModel.getFile();
                            String str3 = "";
                            if (file2 == null || (str2 = file2.getAbsolutePath()) == null) {
                                str2 = "";
                            }
                            openScreenBean.setLocalFile(str2);
                            File file3 = downloadProgressModel.getFile();
                            if (file3 != null && (absolutePath = file3.getAbsolutePath()) != null) {
                                str3 = absolutePath;
                            }
                            Log.d(MainActivity.TAG, "downloadDataToLocalFile: 保存下载数据到本地 " + str3);
                            MMKVToLocalCache.INSTANCE.saveOpenSourceData(arrayList);
                        }
                    }
                }, new pd.g() { // from class: com.qiahao.nextvideo.data.service.SplashService$downloadDataToLocalFile$2
                    public final void accept(Throwable th) {
                        Intrinsics.checkNotNullParameter(th, "it");
                        Log.d(MainActivity.TAG, "downloadDataToLocalFile:下载失败 " + th.getLocalizedMessage());
                    }
                });
                Intrinsics.checkNotNullExpressionValue(subscribe4, "subscribe(...)");
                RxUtilsKt.addTo(subscribe4, this.mCompositeDisposable);
            }
        }
    }

    @Nullable
    public final OpenScreenBean getCurrentShowData() {
        OpenScreenBean openScreenBean;
        int i;
        String localFile;
        String localPic2Url;
        String localPic1Url;
        String localPic1Url2;
        MMKVToLocalCache.Companion companion = MMKVToLocalCache.INSTANCE;
        int currentOenAppTimes = companion.getCurrentOenAppTimes();
        int maxSize = currentOenAppTimes % getMaxSize();
        ArrayList<OpenScreenBean> openSourceData = companion.getOpenSourceData();
        OpenScreenBean openScreenBean2 = null;
        if (openSourceData != null) {
            openScreenBean = openSourceData.get(maxSize);
        } else {
            openScreenBean = null;
        }
        if (maxSize == 0) {
            i = 1;
        } else {
            i = currentOenAppTimes + 1;
        }
        if (openScreenBean == null) {
            companion.saveCurrentOpenAppTimes(0);
            return openScreenBean;
        }
        int type = openScreenBean.getType();
        if (type == 0 ? (localFile = openScreenBean.getLocalFile()) == null || localFile.length() != 0 : type == 1 ? ((localPic2Url = openScreenBean.getLocalPic2Url()) == null || localPic2Url.length() != 0) && ((localPic1Url = openScreenBean.getLocalPic1Url()) == null || localPic1Url.length() != 0) : type != 2 || (localPic1Url2 = openScreenBean.getLocalPic1Url()) == null || localPic1Url2.length() != 0) {
            openScreenBean2 = openScreenBean;
        }
        companion.saveCurrentOpenAppTimes(i);
        return openScreenBean2;
    }

    @NotNull
    public final la.b getImSDkLoginBehaviorRelay() {
        return this.imSDkLoginBehaviorRelay;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    @NotNull
    public final la.c getMOperationDialogPublishRelay() {
        return this.mOperationDialogPublishRelay;
    }

    @NotNull
    public final i0<ApiResponse<List<OpenScreenBean>>> getOpenScreenSource() {
        return AppServer.INSTANCE.getApis().getOpenScreenSource();
    }

    @NotNull
    public final i0<ApiResponse<OpenScreenBean>> getOperationWindow() {
        return AppServer.INSTANCE.getApis().getOperationWindow();
    }

    public final void gotoDownloadGlobalOpenSource() {
        final ArrayList arrayList = new ArrayList();
        nd.c n = getOpenScreenSource().p(ke.a.b()).k(ke.a.b()).n(new pd.g() { // from class: com.qiahao.nextvideo.data.service.SplashService$gotoDownloadGlobalOpenSource$1
            public final void accept(ApiResponse<List<OpenScreenBean>> apiResponse) {
                boolean needChange;
                Intrinsics.checkNotNullParameter(apiResponse, "it");
                arrayList.clear();
                List list = (List) apiResponse.getData();
                if (list != null) {
                    arrayList.addAll(list);
                }
                needChange = this.needChange(arrayList);
                if (needChange) {
                    if (arrayList.isEmpty()) {
                        MMKVToLocalCache.INSTANCE.saveOpenSourceData(arrayList);
                    } else {
                        this.downloadDataToLocalFile(arrayList);
                    }
                }
            }
        }, new pd.g() { // from class: com.qiahao.nextvideo.data.service.SplashService$gotoDownloadGlobalOpenSource$2
            public final void accept(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
            }
        });
        Intrinsics.checkNotNullExpressionValue(n, "subscribe(...)");
        RxUtilsKt.addTo(n, this.mCompositeDisposable);
    }

    public final boolean needShowH5() {
        ArrayList<OpenScreenBean> openSourceData;
        UserStore.Companion companion = UserStore.INSTANCE;
        if (!companion.getShared().isAuthenticated() || companion.getShared().getAuthenticationToken() == null || (openSourceData = MMKVToLocalCache.INSTANCE.getOpenSourceData()) == null || openSourceData.isEmpty()) {
            return false;
        }
        return true;
    }
}
