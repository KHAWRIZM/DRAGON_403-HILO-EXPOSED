package com.qiahao.base_common.utils.picture;

import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.model.MessageTaskData;
import com.qiahao.base_common.utils.picture.AdvancedMessageProcessingSystem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"main", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class AdvancedMessageProcessingSystemKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00f9 -> B:18:0x00fa). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object main(@NotNull Continuation<? super Unit> continuation) {
        AdvancedMessageProcessingSystemKt$main$1 advancedMessageProcessingSystemKt$main$1;
        int i10;
        int i11;
        AdvancedMessageProcessingSystem advancedMessageProcessingSystem;
        ArrayList arrayList;
        int i12;
        AdvancedMessageProcessingSystemKt$main$1 advancedMessageProcessingSystemKt$main$12;
        AdvancedMessageProcessingSystem advancedMessageProcessingSystem2;
        if (continuation instanceof AdvancedMessageProcessingSystemKt$main$1) {
            advancedMessageProcessingSystemKt$main$1 = (AdvancedMessageProcessingSystemKt$main$1) continuation;
            int i13 = advancedMessageProcessingSystemKt$main$1.label;
            if ((i13 & Integer.MIN_VALUE) != 0) {
                advancedMessageProcessingSystemKt$main$1.label = i13 - Integer.MIN_VALUE;
                Object obj = advancedMessageProcessingSystemKt$main$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i10 = advancedMessageProcessingSystemKt$main$1.label;
                i11 = 0;
                int i14 = 2;
                if (i10 != 0) {
                    ResultKt.throwOnFailure(obj);
                    advancedMessageProcessingSystem = new AdvancedMessageProcessingSystem("订单处理系统", 25, 0, 0, new AdvancedMessageProcessingSystemKt$main$system$1(null), 12, null);
                    advancedMessageProcessingSystem.start();
                    ArrayList arrayList2 = new ArrayList(1000);
                    for (int i15 = 0; i15 < 1000; i15++) {
                        arrayList2.add(new MessageTaskData(String.valueOf(i15), "订单内容 " + i15, i15 % 5));
                    }
                    advancedMessageProcessingSystemKt$main$1.L$0 = advancedMessageProcessingSystem;
                    advancedMessageProcessingSystemKt$main$1.L$1 = arrayList2;
                    advancedMessageProcessingSystemKt$main$1.label = 1;
                    obj = advancedMessageProcessingSystem.submitMessages(arrayList2, advancedMessageProcessingSystemKt$main$1);
                    arrayList = arrayList2;
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i10 == 1) {
                    ?? r32 = (List) advancedMessageProcessingSystemKt$main$1.L$1;
                    advancedMessageProcessingSystem = (AdvancedMessageProcessingSystem) advancedMessageProcessingSystemKt$main$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    arrayList = r32;
                } else {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    int i16 = advancedMessageProcessingSystemKt$main$1.I$1;
                    int i17 = advancedMessageProcessingSystemKt$main$1.I$0;
                    AdvancedMessageProcessingSystem advancedMessageProcessingSystem3 = (AdvancedMessageProcessingSystem) advancedMessageProcessingSystemKt$main$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    advancedMessageProcessingSystemKt$main$12 = advancedMessageProcessingSystemKt$main$1;
                    i12 = i17;
                    advancedMessageProcessingSystem2 = advancedMessageProcessingSystem3;
                    AdvancedMessageProcessingSystem.SystemStatus status = advancedMessageProcessingSystem2.getStatus();
                    LogUtil.e$default(LogUtil.INSTANCE, "eTag", "系统状态: 已处理=" + status.getProcessed() + ", 失败=" + status.getFailed() + ", 队列大小=" + ArraysKt.joinToString$default(status.getQueueSizes(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null), false, 4, (Object) null);
                    i11 = i16 + 1;
                    i14 = 2;
                    if (i11 >= i12) {
                        advancedMessageProcessingSystemKt$main$12.L$0 = advancedMessageProcessingSystem2;
                        advancedMessageProcessingSystemKt$main$12.L$1 = null;
                        advancedMessageProcessingSystemKt$main$12.I$0 = i12;
                        advancedMessageProcessingSystemKt$main$12.I$1 = i11;
                        advancedMessageProcessingSystemKt$main$12.label = i14;
                        if (DelayKt.delay(1000L, advancedMessageProcessingSystemKt$main$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i16 = i11;
                        AdvancedMessageProcessingSystem.SystemStatus status2 = advancedMessageProcessingSystem2.getStatus();
                        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "系统状态: 已处理=" + status2.getProcessed() + ", 失败=" + status2.getFailed() + ", 队列大小=" + ArraysKt.joinToString$default(status2.getQueueSizes(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null), false, 4, (Object) null);
                        i11 = i16 + 1;
                        i14 = 2;
                        if (i11 >= i12) {
                            advancedMessageProcessingSystemKt$main$12.L$0 = null;
                            advancedMessageProcessingSystemKt$main$12.L$1 = null;
                            advancedMessageProcessingSystemKt$main$12.label = 3;
                            if (AdvancedMessageProcessingSystem.m٥٢٩shutdownVtjQ1oo$default(advancedMessageProcessingSystem2, 0L, advancedMessageProcessingSystemKt$main$12, 1, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }
                int intValue = ((Number) obj).intValue();
                LogUtil.e$default(LogUtil.INSTANCE, "eTag", "成功提交 " + intValue + "/" + arrayList.size() + " 条消息", false, 4, (Object) null);
                i12 = 5;
                advancedMessageProcessingSystemKt$main$12 = advancedMessageProcessingSystemKt$main$1;
                advancedMessageProcessingSystem2 = advancedMessageProcessingSystem;
                if (i11 >= i12) {
                }
            }
        }
        advancedMessageProcessingSystemKt$main$1 = new AdvancedMessageProcessingSystemKt$main$1(continuation);
        Object obj2 = advancedMessageProcessingSystemKt$main$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = advancedMessageProcessingSystemKt$main$1.label;
        i11 = 0;
        int i142 = 2;
        if (i10 != 0) {
        }
        int intValue2 = ((Number) obj2).intValue();
        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "成功提交 " + intValue2 + "/" + arrayList.size() + " 条消息", false, 4, (Object) null);
        i12 = 5;
        advancedMessageProcessingSystemKt$main$12 = advancedMessageProcessingSystemKt$main$1;
        advancedMessageProcessingSystem2 = advancedMessageProcessingSystem;
        if (i11 >= i12) {
        }
    }
}
