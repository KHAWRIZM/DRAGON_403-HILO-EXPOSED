package com.qiahao.nextvideo.data.service;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.alibaba.sdk.android.push.CommonCallback;
import com.alibaba.sdk.android.push.noonesdk.PushServiceFactory;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.oudi.core.support.ActivityLifecycleManager;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.nextvideo.HiloApplication;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.service.match.MatchingProvide;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.tencent.qcloud.tuicore.TUIConstants;
import io.reactivex.rxjava3.core.i0;
import io.reactivex.rxjava3.core.j0;
import io.reactivex.rxjava3.core.l0;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J;\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\r0\f2\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ9\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\r0\f2\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u000fJ9\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\r0\f2\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u000fJ\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016Jw\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\r0\f2\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u00042:\b\u0002\u0010\u001e\u001a4\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0004\b\n\u0010\u001f¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/data/service/AliCloudService;", "", "<init>", "()V", "", "isNetworkAvailable", "()Z", "", "folder", "Ljava/io/File;", "uploadFile", "suffix", "Lio/reactivex/rxjava3/core/i0;", "Lkotlin/Pair;", "uploadFileToAWS", "(Ljava/lang/String;Ljava/io/File;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", TUIConstants.TUILive.USER_ID, "uploadAgoraFileToAWS", "uploadOperationFileToAWS", SupportGiftRankActivity.EXTERNAL_ID, "", "bindPushAccount", "(Ljava/lang/String;)V", MatchingProvide.IS_VIDEO, "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "current", "total", "progressListener", "(Ljava/lang/String;Ljava/io/File;ZLkotlin/jvm/functions/Function2;)Lio/reactivex/rxjava3/core/i0;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AliCloudService {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String IMAGE_PATH = "https://image.whoisamy.shop/";

    @NotNull
    public static final String OSS_FOLDER_AGOR_UNION = "hilo/agora_log/";

    @NotNull
    public static final String OSS_FOLDER_AVATAR = "hilo/avatar/";

    @NotNull
    public static final String OSS_FOLDER_CLIENT_LOG_LOGIN_E = "hilo/user_log/login/";

    @NotNull
    public static final String OSS_FOLDER_FEEDBACK = "hilo/feedbacks/";

    @NotNull
    public static final String OSS_FOLDER_GROUP = "hilo/group/";

    @NotNull
    public static final String OSS_FOLDER_OPERATION_UNION = "hilo/user_log/";

    @NotNull
    public static final String OSS_FOLDER_TRADE_UNION = "hilo/tradeunion/";

    @NotNull
    public static final String OSS_GIFT = "hilo/gift/";

    @NotNull
    public static final String OSS_MESSAGES = "hilo/messages/";

    @NotNull
    public static final String OSS_SCREENSHOT = "hilo/screenshot/";

    @NotNull
    public static final String OSS_USER_REPORTS = "hilo/user_reports/";

    @NotNull
    public static final String TAG = "AliOSSUtility";
    private static xb.a s3Utils;
    public static AliCloudService shared;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u0014\u0010\u001a\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u000fR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/qiahao/nextvideo/data/service/AliCloudService$Companion;", "", "<init>", "()V", "", "init", "Lcom/qiahao/nextvideo/data/service/AliCloudService;", "shared", "Lcom/qiahao/nextvideo/data/service/AliCloudService;", "getShared", "()Lcom/qiahao/nextvideo/data/service/AliCloudService;", "setShared", "(Lcom/qiahao/nextvideo/data/service/AliCloudService;)V", "", "OSS_FOLDER_AVATAR", "Ljava/lang/String;", "OSS_FOLDER_FEEDBACK", "OSS_FOLDER_TRADE_UNION", "OSS_FOLDER_AGOR_UNION", "OSS_FOLDER_OPERATION_UNION", "OSS_FOLDER_GROUP", "OSS_SCREENSHOT", "OSS_USER_REPORTS", "OSS_MESSAGES", "OSS_GIFT", "OSS_FOLDER_CLIENT_LOG_LOGIN_E", "IMAGE_PATH", "Lxb/a;", "s3Utils", "Lxb/a;", "TAG", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AliCloudService getShared() {
            AliCloudService aliCloudService = AliCloudService.shared;
            if (aliCloudService != null) {
                return aliCloudService;
            }
            Intrinsics.throwUninitializedPropertyAccessException("shared");
            return null;
        }

        public final void init() {
            setShared(new AliCloudService());
        }

        public final void setShared(@NotNull AliCloudService aliCloudService) {
            Intrinsics.checkNotNullParameter(aliCloudService, "<set-?>");
            AliCloudService.shared = aliCloudService;
        }

        private Companion() {
        }
    }

    public AliCloudService() {
        s3Utils = new xb.a();
    }

    private final boolean isNetworkAvailable() {
        Object systemService = HiloApplication.INSTANCE.getCONTEXT().getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ i0 uploadAgoraFileToAWS$default(AliCloudService aliCloudService, String str, File file, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = OSS_FOLDER_AGOR_UNION;
        }
        return aliCloudService.uploadAgoraFileToAWS(str, file, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uploadAgoraFileToAWS$lambda$1(String str, String str2, File file, final j0 j0Var) {
        Intrinsics.checkNotNullParameter(j0Var, "singleEmitter");
        final String str3 = str + str2 + "-" + DateTimeUtilityKt.getDateFormatWithLocale(System.currentTimeMillis(), "yyyy-MM-dd") + file.getName();
        Log.d(TAG, "uploadAgoraFile上传文件路径跟名字: " + str3);
        xb.a aVar = s3Utils;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("s3Utils");
            aVar = null;
        }
        aVar.d(ActivityLifecycleManager.INSTANCE.currentActivity()).upload(str3, file).setTransferListener(new TransferListener() { // from class: com.qiahao.nextvideo.data.service.AliCloudService$uploadAgoraFileToAWS$1$1
            public void onError(int id2, Exception ex) {
                j0 j0Var2 = j0Var;
                if (ex == null) {
                    ex = new Exception("exception fail");
                }
                j0Var2.onError(ex);
            }

            public void onProgressChanged(int id2, long bytesCurrent, long bytesTotal) {
            }

            public void onStateChanged(int id2, TransferState state) {
                Log.d(AliCloudService.TAG, "onStateChanged: " + id2 + " " + state);
                if (state == TransferState.COMPLETED) {
                    j0Var.onSuccess(new Pair(Boolean.TRUE, str3));
                    return;
                }
                if (state == TransferState.FAILED) {
                    j0Var.onError(new Exception("upload fail, state: " + state));
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ i0 uploadFile$default(AliCloudService aliCloudService, String str, File file, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = OSS_USER_REPORTS;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            function2 = null;
        }
        return aliCloudService.uploadFile(str, file, z, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uploadFile$lambda$3(AliCloudService aliCloudService, boolean z, String str, File file, final Function2 function2, final j0 j0Var) {
        final String str2;
        String externalId;
        String externalId2;
        xb.a aVar;
        String externalId3;
        Intrinsics.checkNotNullParameter(j0Var, "singleEmitter");
        if (!aliCloudService.isNetworkAvailable()) {
            j0Var.onError(new Exception("No network connection"));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String dateFormatWithLocale = DateTimeUtilityKt.getDateFormatWithLocale(currentTimeMillis, "yyyy-MM-dd");
        String str3 = "";
        if (z) {
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user != null && (externalId3 = user.getExternalId()) != null) {
                str3 = externalId3;
            }
            str2 = str + str3 + "-" + dateFormatWithLocale + "-" + file.getName();
        } else {
            String name = file.getName();
            Intrinsics.checkNotNull(name);
            if (StringsKt.contains$default(name, ".", false, 2, (Object) null)) {
                User user2 = UserStore.INSTANCE.getShared().getUser();
                if (user2 != null && (externalId2 = user2.getExternalId()) != null) {
                    str3 = externalId2;
                }
                String substring = name.substring(0, StringsKt.lastIndexOf$default(name, ".", 0, false, 6, (Object) null));
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                String substring2 = name.substring(StringsKt.lastIndexOf$default(name, ".", 0, false, 6, (Object) null), name.length());
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                str2 = str + str3 + "-" + dateFormatWithLocale + "-" + currentTimeMillis + substring + substring2;
            } else {
                User user3 = UserStore.INSTANCE.getShared().getUser();
                if (user3 != null && (externalId = user3.getExternalId()) != null) {
                    str3 = externalId;
                }
                str2 = str + str3 + "-" + dateFormatWithLocale + "-" + file.getName();
            }
        }
        Log.d(TAG, "uploadAgoraFile上传文件路径跟名字: " + str2);
        xb.a aVar2 = s3Utils;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("s3Utils");
            aVar = null;
        } else {
            aVar = aVar2;
        }
        aVar.d(ActivityLifecycleManager.INSTANCE.currentActivity()).upload(str2, file).setTransferListener(new TransferListener() { // from class: com.qiahao.nextvideo.data.service.AliCloudService$uploadFile$1$1
            public void onError(int id2, Exception ex) {
                j0Var.onSuccess(new Pair(Boolean.FALSE, str2));
            }

            public void onProgressChanged(int id2, long bytesCurrent, long bytesTotal) {
                Function2<Long, Long, Unit> function22 = function2;
                if (function22 != null) {
                    function22.invoke(Long.valueOf(bytesCurrent), Long.valueOf(bytesTotal));
                }
            }

            public void onStateChanged(int id2, TransferState state) {
                Log.d(AliCloudService.TAG, "onStateChanged: " + id2 + " " + state);
                if (state == TransferState.COMPLETED) {
                    j0Var.onSuccess(new Pair(Boolean.TRUE, str2));
                } else if (state == TransferState.FAILED) {
                    j0Var.onSuccess(new Pair(Boolean.FALSE, str2));
                }
            }
        });
    }

    public static /* synthetic */ i0 uploadFileToAWS$default(AliCloudService aliCloudService, String str, File file, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = OSS_FOLDER_AVATAR;
        }
        if ((i & 4) != 0) {
            str2 = ".png";
        }
        return aliCloudService.uploadFileToAWS(str, file, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uploadFileToAWS$lambda$0(String str, String str2, File file, final j0 j0Var) {
        String str3;
        Intrinsics.checkNotNullParameter(j0Var, "singleEmitter");
        long currentTimeMillis = System.currentTimeMillis();
        String dateFormatWithLocale = DateTimeUtilityKt.getDateFormatWithLocale(currentTimeMillis, "yyyyMMdd");
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str3 = user.getExternalId()) == null) {
            str3 = "";
        }
        final String str4 = str + str3 + "-" + dateFormatWithLocale + "-" + currentTimeMillis + str2;
        Log.d(TAG, "uploadFileToAWS: " + str4);
        xb.a aVar = s3Utils;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("s3Utils");
            aVar = null;
        }
        aVar.d(ActivityLifecycleManager.INSTANCE.currentActivity()).upload(str4, file).setTransferListener(new TransferListener() { // from class: com.qiahao.nextvideo.data.service.AliCloudService$uploadFileToAWS$1$1
            public void onError(int id2, Exception ex) {
                String str5;
                j0 j0Var2 = j0Var;
                Boolean bool = Boolean.FALSE;
                if (ex != null) {
                    str5 = ex.getMessage();
                } else {
                    str5 = null;
                }
                j0Var2.onSuccess(new Pair(bool, "upload fail, state: " + str5));
            }

            public void onProgressChanged(int id2, long bytesCurrent, long bytesTotal) {
            }

            public void onStateChanged(int id2, TransferState state) {
                Log.d(AliCloudService.TAG, "onStateChanged: " + id2 + " " + state);
                if (state == TransferState.COMPLETED) {
                    j0Var.onSuccess(new Pair(Boolean.TRUE, str4));
                    return;
                }
                if (state == TransferState.FAILED) {
                    j0Var.onSuccess(new Pair(Boolean.FALSE, "upload fail, state: " + state));
                }
            }
        });
    }

    public static /* synthetic */ i0 uploadOperationFileToAWS$default(AliCloudService aliCloudService, String str, File file, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = OSS_FOLDER_OPERATION_UNION;
        }
        return aliCloudService.uploadOperationFileToAWS(str, file, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uploadOperationFileToAWS$lambda$2(String str, String str2, File file, final j0 j0Var) {
        Intrinsics.checkNotNullParameter(j0Var, "singleEmitter");
        final String str3 = str + str2 + "-" + DateTimeUtilityKt.getDateFormatWithLocale(System.currentTimeMillis(), "yyyy-MM-dd") + file.getName();
        Log.d(TAG, "uploadOperationFileToAWS上传文件路径跟名字: " + str3);
        xb.a aVar = s3Utils;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("s3Utils");
            aVar = null;
        }
        aVar.d(ActivityLifecycleManager.INSTANCE.currentActivity()).upload(str3, file).setTransferListener(new TransferListener() { // from class: com.qiahao.nextvideo.data.service.AliCloudService$uploadOperationFileToAWS$1$1
            public void onError(int id2, Exception ex) {
                j0 j0Var2 = j0Var;
                if (ex == null) {
                    ex = new Exception("exception fail");
                }
                j0Var2.onError(ex);
            }

            public void onProgressChanged(int id2, long bytesCurrent, long bytesTotal) {
            }

            public void onStateChanged(int id2, TransferState state) {
                Log.d(AliCloudService.TAG, "onStateChanged: " + id2 + " " + state);
                if (state == TransferState.COMPLETED) {
                    j0Var.onSuccess(new Pair(Boolean.TRUE, str3));
                    return;
                }
                if (state == TransferState.FAILED) {
                    j0Var.onError(new Exception("upload fail, state: " + state));
                }
            }
        });
    }

    public final void bindPushAccount(@NotNull String externalId) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        PushServiceFactory.getCloudPushService().bindAccount(externalId, new CommonCallback() { // from class: com.qiahao.nextvideo.data.service.AliCloudService$bindPushAccount$1
            public void onFailed(String p0, String p1) {
                DebugToolsKt.printfE(AliCloudService.TAG, "AlisPUSHMessageReceiver bind account result failure: " + p0 + ", " + p1);
            }

            public void onSuccess(String p0) {
            }
        });
    }

    @NotNull
    public final i0<Pair<Boolean, String>> uploadAgoraFileToAWS(@NotNull final String folder, @NotNull final File uploadFile, @NotNull final String userId) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        Intrinsics.checkNotNullParameter(uploadFile, "uploadFile");
        Intrinsics.checkNotNullParameter(userId, TUIConstants.TUILive.USER_ID);
        i0<Pair<Boolean, String>> d = i0.d(new l0() { // from class: com.qiahao.nextvideo.data.service.d
            public final void a(j0 j0Var) {
                AliCloudService.uploadAgoraFileToAWS$lambda$1(folder, userId, uploadFile, j0Var);
            }
        });
        Intrinsics.checkNotNullExpressionValue(d, "create(...)");
        return d;
    }

    @NotNull
    public final i0<Pair<Boolean, String>> uploadFile(@NotNull final String folder, @NotNull final File uploadFile, final boolean isVideo, @Nullable final Function2<? super Long, ? super Long, Unit> progressListener) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        Intrinsics.checkNotNullParameter(uploadFile, "uploadFile");
        i0<Pair<Boolean, String>> d = i0.d(new l0() { // from class: com.qiahao.nextvideo.data.service.b
            public final void a(j0 j0Var) {
                AliCloudService.uploadFile$lambda$3(AliCloudService.this, isVideo, folder, uploadFile, progressListener, j0Var);
            }
        });
        Intrinsics.checkNotNullExpressionValue(d, "create(...)");
        return d;
    }

    @NotNull
    public final i0<Pair<Boolean, String>> uploadFileToAWS(@NotNull final String folder, @NotNull final File uploadFile, @NotNull final String suffix) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        Intrinsics.checkNotNullParameter(uploadFile, "uploadFile");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        i0<Pair<Boolean, String>> d = i0.d(new l0() { // from class: com.qiahao.nextvideo.data.service.a
            public final void a(j0 j0Var) {
                AliCloudService.uploadFileToAWS$lambda$0(folder, suffix, uploadFile, j0Var);
            }
        });
        Intrinsics.checkNotNullExpressionValue(d, "create(...)");
        return d;
    }

    @NotNull
    public final i0<Pair<Boolean, String>> uploadOperationFileToAWS(@NotNull final String folder, @NotNull final File uploadFile, @NotNull final String userId) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        Intrinsics.checkNotNullParameter(uploadFile, "uploadFile");
        Intrinsics.checkNotNullParameter(userId, TUIConstants.TUILive.USER_ID);
        i0<Pair<Boolean, String>> d = i0.d(new l0() { // from class: com.qiahao.nextvideo.data.service.c
            public final void a(j0 j0Var) {
                AliCloudService.uploadOperationFileToAWS$lambda$2(folder, userId, uploadFile, j0Var);
            }
        });
        Intrinsics.checkNotNullExpressionValue(d, "create(...)");
        return d;
    }
}
