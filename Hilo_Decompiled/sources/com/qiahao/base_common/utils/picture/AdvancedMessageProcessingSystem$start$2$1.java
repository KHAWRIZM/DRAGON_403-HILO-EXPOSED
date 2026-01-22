package com.qiahao.base_common.utils.picture;

import com.oudi.utils.log.LogUtil;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.selects.SelectImplementation;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.base_common.utils.picture.AdvancedMessageProcessingSystem$start$2$1", f = "AdvancedMessageProcessingSystem.kt", i = {0}, l = {259}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nAdvancedMessageProcessingSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdvancedMessageProcessingSystem.kt\ncom/qiahao/base_common/utils/picture/AdvancedMessageProcessingSystem$start$2$1\n+ 2 Select.kt\nkotlinx/coroutines/selects/SelectKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,250:1\n55#2,5:251\n62#2:259\n13537#3,3:256\n*S KotlinDebug\n*F\n+ 1 AdvancedMessageProcessingSystem.kt\ncom/qiahao/base_common/utils/picture/AdvancedMessageProcessingSystem$start$2$1\n*L\n80#1:251,5\n80#1:259\n82#1:256,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class AdvancedMessageProcessingSystem$start$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $workerId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AdvancedMessageProcessingSystem<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvancedMessageProcessingSystem$start$2$1(AdvancedMessageProcessingSystem<T> advancedMessageProcessingSystem, int i10, Continuation<? super AdvancedMessageProcessingSystem$start$2$1> continuation) {
        super(2, continuation);
        this.this$0 = advancedMessageProcessingSystem;
        this.$workerId = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AdvancedMessageProcessingSystem$start$2$1 advancedMessageProcessingSystem$start$2$1 = new AdvancedMessageProcessingSystem$start$2$1(this.this$0, this.$workerId, continuation);
        advancedMessageProcessingSystem$start$2$1.L$0 = obj;
        return advancedMessageProcessingSystem$start$2$1;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0061 -> B:7:0x0025). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        AtomicLong atomicLong;
        Channel[] channelArr;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e10) {
                    atomicLong = ((AdvancedMessageProcessingSystem) this.this$0).failedCount;
                    atomicLong.incrementAndGet();
                    LogUtil.e$default(LogUtil.INSTANCE, "eTag", "Worker " + this.$workerId + " 处理消息时出错: " + e10.getMessage(), false, 4, (Object) null);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
        }
        while (CoroutineScopeKt.isActive(coroutineScope)) {
            AdvancedMessageProcessingSystem<T> advancedMessageProcessingSystem = this.this$0;
            int i11 = this.$workerId;
            SelectImplementation selectImplementation = new SelectImplementation(get$context());
            channelArr = ((AdvancedMessageProcessingSystem) advancedMessageProcessingSystem).priorityChannels;
            int length = channelArr.length;
            int i12 = 0;
            int i13 = 0;
            while (i12 < length) {
                selectImplementation.invoke(channelArr[i12].getOnReceive(), new AdvancedMessageProcessingSystem$start$2$1$1$1$1(advancedMessageProcessingSystem, i11, i13, null));
                i12++;
                i13++;
            }
            this.L$0 = coroutineScope;
            this.label = 1;
            if (selectImplementation.doSelect(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AdvancedMessageProcessingSystem$start$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
