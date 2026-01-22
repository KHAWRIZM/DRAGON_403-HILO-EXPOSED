package com.qhqc.core.basic.aws;

import com.facebook.internal.FacebookRequestErrorClassification;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "Lcom/qhqc/core/basic/aws/S3UploadRequest;", "mRequest"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.basic.aws.AwsS3Repository$startFlowRequest$3", f = "AwsS3Repository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class AwsS3Repository$startFlowRequest$3 extends SuspendLambda implements Function2<S3UploadRequest, Continuation<? super Flow<? extends S3UploadRequest>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AwsS3Repository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/qhqc/core/basic/aws/S3UploadRequest;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.qhqc.core.basic.aws.AwsS3Repository$startFlowRequest$3$1", f = "AwsS3Repository.kt", i = {}, l = {FacebookRequestErrorClassification.EC_INVALID_TOKEN}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.qhqc.core.basic.aws.AwsS3Repository$startFlowRequest$3$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super S3UploadRequest>, Continuation<? super Unit>, Object> {
        final /* synthetic */ S3UploadRequest $mRequest;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AwsS3Repository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AwsS3Repository awsS3Repository, S3UploadRequest s3UploadRequest, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = awsS3Repository;
            this.$mRequest = s3UploadRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$mRequest, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
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
                this.this$0.uploadCompat(this.$mRequest);
                S3UploadRequest s3UploadRequest = this.$mRequest;
                this.label = 1;
                if (flowCollector.emit(s3UploadRequest, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull FlowCollector<? super S3UploadRequest> flowCollector, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AwsS3Repository$startFlowRequest$3(AwsS3Repository awsS3Repository, Continuation<? super AwsS3Repository$startFlowRequest$3> continuation) {
        super(2, continuation);
        this.this$0 = awsS3Repository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AwsS3Repository$startFlowRequest$3 awsS3Repository$startFlowRequest$3 = new AwsS3Repository$startFlowRequest$3(this.this$0, continuation);
        awsS3Repository$startFlowRequest$3.L$0 = obj;
        return awsS3Repository$startFlowRequest$3;
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull S3UploadRequest s3UploadRequest, @Nullable Continuation<? super Flow<S3UploadRequest>> continuation) {
        return ((AwsS3Repository$startFlowRequest$3) create(s3UploadRequest, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(this.this$0, (S3UploadRequest) this.L$0, null)), Dispatchers.getIO());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(S3UploadRequest s3UploadRequest, Continuation<? super Flow<? extends S3UploadRequest>> continuation) {
        return invoke2(s3UploadRequest, (Continuation<? super Flow<S3UploadRequest>>) continuation);
    }
}
