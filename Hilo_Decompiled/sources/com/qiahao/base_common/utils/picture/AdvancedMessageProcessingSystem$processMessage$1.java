package com.qiahao.base_common.utils.picture;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.base_common.utils.picture.AdvancedMessageProcessingSystem", f = "AdvancedMessageProcessingSystem.kt", i = {0, 0}, l = {131}, m = "processMessage", n = {"this", "priority"}, s = {"L$0", "I$0"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class AdvancedMessageProcessingSystem$processMessage$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdvancedMessageProcessingSystem<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvancedMessageProcessingSystem$processMessage$1(AdvancedMessageProcessingSystem<T> advancedMessageProcessingSystem, Continuation<? super AdvancedMessageProcessingSystem$processMessage$1> continuation) {
        super(continuation);
        this.this$0 = advancedMessageProcessingSystem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object processMessage;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        processMessage = this.this$0.processMessage(null, 0, 0, this);
        return processMessage;
    }
}
