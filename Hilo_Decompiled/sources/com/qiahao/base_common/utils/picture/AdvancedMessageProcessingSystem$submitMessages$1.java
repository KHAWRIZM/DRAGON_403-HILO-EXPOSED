package com.qiahao.base_common.utils.picture;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.base_common.utils.picture.AdvancedMessageProcessingSystem", f = "AdvancedMessageProcessingSystem.kt", i = {0, 0}, l = {120}, m = "submitMessages", n = {"this", "successCount"}, s = {"L$0", "L$1"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class AdvancedMessageProcessingSystem$submitMessages$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdvancedMessageProcessingSystem<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvancedMessageProcessingSystem$submitMessages$1(AdvancedMessageProcessingSystem<T> advancedMessageProcessingSystem, Continuation<? super AdvancedMessageProcessingSystem$submitMessages$1> continuation) {
        super(continuation);
        this.this$0 = advancedMessageProcessingSystem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.submitMessages(null, this);
    }
}
