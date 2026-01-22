package com.qhqc.core.basic.aws;

import android.net.Uri;
import com.qhqc.core.basic.utils.StorageUtils;
import com.qhqc.core.basic.utils.UriUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/qhqc/core/basic/aws/S3UploadRequest;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.basic.aws.AwsS3Repository$startFlowRequest$2", f = "AwsS3Repository.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class AwsS3Repository$startFlowRequest$2 extends SuspendLambda implements Function2<FlowCollector<? super S3UploadRequest>, Continuation<? super Unit>, Object> {
    final /* synthetic */ S3UploadRequest $request;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AwsS3Repository$startFlowRequest$2(S3UploadRequest s3UploadRequest, Continuation<? super AwsS3Repository$startFlowRequest$2> continuation) {
        super(2, continuation);
        this.$request = s3UploadRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AwsS3Repository$startFlowRequest$2 awsS3Repository$startFlowRequest$2 = new AwsS3Repository$startFlowRequest$2(this.$request, continuation);
        awsS3Repository$startFlowRequest$2.L$0 = obj;
        return awsS3Repository$startFlowRequest$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            String availablePath = this.$request.getAvailablePath();
            Uri parseValidUri = UriUtils.INSTANCE.parseValidUri(availablePath);
            if (parseValidUri != null) {
                availablePath = StorageUtils.INSTANCE.getPathFromUriSync(parseValidUri);
            }
            if (availablePath != null && availablePath.length() != 0) {
                this.$request.setAvailablePath(availablePath);
                S3UploadRequest s3UploadRequest = this.$request;
                this.label = 1;
                if (flowCollector.emit(s3UploadRequest, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw new Exception("file path is not available!");
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super S3UploadRequest> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((AwsS3Repository$startFlowRequest$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
