package com.qhqc.core.basic.aws;

import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.CheckResult;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import com.qhqc.core.basic.utils.LogUtil;
import com.qhqc.core.basic.utils.NetWorkUtils;
import com.qhqc.core.basic.utils.StorageUtils;
import java.io.File;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001*\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00172\u0006\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00118\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/qhqc/core/basic/aws/AwsS3Repository;", "", "<init>", "()V", "", "id", "Lcom/qhqc/core/basic/aws/S3UploadRequest;", "fetchRequestByTransferId", "(I)Lcom/qhqc/core/basic/aws/S3UploadRequest;", "Ljava/util/UUID;", "fetchRequestByRequestId", "(Ljava/util/UUID;)Lcom/qhqc/core/basic/aws/S3UploadRequest;", "request", "", "uploadCompat", "(Lcom/qhqc/core/basic/aws/S3UploadRequest;)V", "cancelRequest", "", "createVideoCompressCacheFilePath", "()Ljava/lang/String;", "any", "clear", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/Flow;", "startFlowRequest", "(Lcom/qhqc/core/basic/aws/S3UploadRequest;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/Job;", "start", "(Lcom/qhqc/core/basic/aws/S3UploadRequest;Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/Job;", "TAG", "Ljava/lang/String;", "Lcom/qhqc/core/basic/aws/a;", "mS3Util", "Lcom/qhqc/core/basic/aws/a;", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferUtility;", "mTransferUtility", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferUtility;", "Ljava/util/concurrent/ConcurrentHashMap;", "mUploadRequestMap", "Ljava/util/concurrent/ConcurrentHashMap;", "com/qhqc/core/basic/aws/AwsS3Repository$mOnTransferListener$1", "mOnTransferListener", "Lcom/qhqc/core/basic/aws/AwsS3Repository$mOnTransferListener$1;", "Companion", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAwsS3Repository.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AwsS3Repository.kt\ncom/qhqc/core/basic/aws/AwsS3Repository\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,269:1\n216#2,2:270\n1863#3,2:272\n*S KotlinDebug\n*F\n+ 1 AwsS3Repository.kt\ncom/qhqc/core/basic/aws/AwsS3Repository\n*L\n86#1:270,2\n104#1:272,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class AwsS3Repository {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<AwsS3Repository> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<AwsS3Repository>() { // from class: com.qhqc.core.basic.aws.AwsS3Repository$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final AwsS3Repository invoke() {
            return new AwsS3Repository();
        }
    });

    @NotNull
    private final String TAG = "AwsS3Repository";

    @NotNull
    private final AwsS3Repository$mOnTransferListener$1 mOnTransferListener;

    @NotNull
    private final a mS3Util;

    @NotNull
    private final TransferUtility mTransferUtility;

    @NotNull
    private final ConcurrentHashMap<UUID, S3UploadRequest> mUploadRequestMap;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/qhqc/core/basic/aws/AwsS3Repository$Companion;", "", "()V", "instance", "Lcom/qhqc/core/basic/aws/AwsS3Repository;", "getInstance$annotations", "getInstance", "()Lcom/qhqc/core/basic/aws/AwsS3Repository;", "instance$delegate", "Lkotlin/Lazy;", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final AwsS3Repository getInstance() {
            return (AwsS3Repository) AwsS3Repository.instance$delegate.getValue();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.qhqc.core.basic.aws.AwsS3Repository$mOnTransferListener$1] */
    public AwsS3Repository() {
        a aVar = new a();
        this.mS3Util = aVar;
        TransferUtility d10 = aVar.d(BasicModuleApp.application());
        Intrinsics.checkNotNullExpressionValue(d10, "getTransferUtility(...)");
        this.mTransferUtility = d10;
        this.mUploadRequestMap = new ConcurrentHashMap<>();
        this.mOnTransferListener = new TransferListener() { // from class: com.qhqc.core.basic.aws.AwsS3Repository$mOnTransferListener$1
            @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
            public void onError(int id, @Nullable Exception ex) {
                S3UploadRequest fetchRequestByTransferId;
                fetchRequestByTransferId = AwsS3Repository.this.fetchRequestByTransferId(id);
                if (fetchRequestByTransferId != null) {
                    AwsS3Repository awsS3Repository = AwsS3Repository.this;
                    fetchRequestByTransferId.onError(ex);
                    awsS3Repository.cancelRequest(fetchRequestByTransferId);
                }
            }

            @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
            public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {
                S3UploadRequest fetchRequestByTransferId;
                fetchRequestByTransferId = AwsS3Repository.this.fetchRequestByTransferId(id);
                if (fetchRequestByTransferId != null) {
                    fetchRequestByTransferId.onProgress(bytesCurrent, bytesTotal);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
            
                r2 = r1.this$0.fetchRequestByTransferId(r2);
             */
            @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onStateChanged(int id, @Nullable TransferState state) {
                S3UploadRequest fetchRequestByTransferId;
                if (state == TransferState.COMPLETED && fetchRequestByTransferId != null) {
                    AwsS3Repository awsS3Repository = AwsS3Repository.this;
                    fetchRequestByTransferId.onComplete();
                    awsS3Repository.cancelRequest(fetchRequestByTransferId);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelRequest(S3UploadRequest request) {
        request.setOnVideoCompressListener(null);
        request.setOnUploadRequestListener(null);
        if (this.mUploadRequestMap.containsKey(request.getRequestId())) {
            TypeIntrinsics.asMutableMap(this.mUploadRequestMap).remove(request.getRequestId());
            LogUtil.INSTANCE.d(this.TAG, "request was canceled " + request.getOwnerTag() + "_" + request.getUploadJobId() + "_" + request.getRequestId() + "， map size (" + this.mUploadRequestMap.size() + ")");
        }
    }

    private final String createVideoCompressCacheFilePath() {
        File file = new File(BasicModuleApp.application().getCacheDir(), "outputs");
        if (!file.exists()) {
            file.mkdir();
        }
        String path = File.createTempFile("compress", ".mp4", file).getPath();
        Intrinsics.checkNotNull(path);
        return path;
    }

    private final S3UploadRequest fetchRequestByRequestId(UUID id) {
        if (this.mUploadRequestMap.containsKey(id)) {
            return this.mUploadRequestMap.get(id);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final S3UploadRequest fetchRequestByTransferId(int id) {
        Collection<S3UploadRequest> values = this.mUploadRequestMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        for (S3UploadRequest s3UploadRequest : values) {
            if (s3UploadRequest.getUploadJobId() == id) {
                return s3UploadRequest;
            }
        }
        return null;
    }

    @NotNull
    public static final AwsS3Repository getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uploadCompat(S3UploadRequest request) {
        if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            request.onError(new Exception("current thread is main Thread"));
            return;
        }
        String key = request.getConfig().getKey();
        if (TextUtils.isEmpty(key)) {
            request.onError(new Exception("empty upload name"));
            return;
        }
        File fileCompat = StorageUtils.INSTANCE.getFileCompat(request.getAvailablePath());
        if (fileCompat != null && fileCompat.exists()) {
            if (!NetWorkUtils.INSTANCE.isNetworkAvailable()) {
                request.onError(new Exception("No network"));
                return;
            }
            TransferObserver upload = this.mTransferUtility.upload(key, fileCompat);
            request.setUploadJobId(upload.getId());
            LogUtil.INSTANCE.d(this.TAG, "request was added to uploadQueue " + request.getUploadJobId());
            upload.setTransferListener(this.mOnTransferListener);
            return;
        }
        request.onError(new Exception("File is not exists."));
    }

    public final void clear(@NotNull Object any) {
        Intrinsics.checkNotNullParameter(any, "any");
        String obj = any.toString();
        if (obj.length() == 0) {
            return;
        }
        for (Map.Entry<UUID, S3UploadRequest> entry : this.mUploadRequestMap.entrySet()) {
            if (Intrinsics.areEqual(entry.getValue().getOwnerTag(), obj)) {
                cancelRequest(entry.getValue());
            }
        }
    }

    @NotNull
    public final Job start(@NotNull final S3UploadRequest request, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Job launchIn = FlowKt.launchIn(startFlowRequest(request), coroutineScope);
        launchIn.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.qhqc.core.basic.aws.AwsS3Repository$start$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                if (th instanceof CancellationException) {
                    AwsS3Repository.this.cancelRequest(request);
                }
            }
        });
        return launchIn;
    }

    @CheckResult
    @NotNull
    public final Flow<S3UploadRequest> startFlowRequest(@NotNull S3UploadRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        UUID requestId = request.getRequestId();
        if (requestId != null) {
            this.mUploadRequestMap.put(requestId, request);
        }
        return FlowKt.catch(FlowKt.flatMapConcat(FlowKt.flowOn(FlowKt.flow(new AwsS3Repository$startFlowRequest$2(request, null)), Dispatchers.getIO()), new AwsS3Repository$startFlowRequest$3(this, null)), new AwsS3Repository$startFlowRequest$4(request, null));
    }
}
