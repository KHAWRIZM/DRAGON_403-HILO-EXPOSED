package kotlin.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {"$this$iterator", "buffer", "e", "bufferInitialCapacity", "gap", "skip", "$this$iterator", "buffer", "bufferInitialCapacity", "gap", "skip", "$this$iterator", "buffer", "e", "bufferInitialCapacity", "gap", "$this$iterator", "buffer", "bufferInitialCapacity", "gap", "$this$iterator", "buffer", "bufferInitialCapacity", "gap"}, s = {"L$0", "L$1", "L$3", "I$0", "I$1", "I$2", "L$0", "L$1", "I$0", "I$1", "I$2", "L$0", "L$1", "L$3", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class SlidingWindowKt$windowedIterator$1<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Iterator<T> $iterator;
    final /* synthetic */ boolean $partialWindows;
    final /* synthetic */ boolean $reuseBuffer;
    final /* synthetic */ int $size;
    final /* synthetic */ int $step;
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SlidingWindowKt$windowedIterator$1(int i10, int i11, Iterator<? extends T> it, boolean z10, boolean z11, Continuation<? super SlidingWindowKt$windowedIterator$1> continuation) {
        super(2, continuation);
        this.$size = i10;
        this.$step = i11;
        this.$iterator = it;
        this.$reuseBuffer = z10;
        this.$partialWindows = z11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, continuation);
        slidingWindowKt$windowedIterator$1.L$0 = obj;
        return slidingWindowKt$windowedIterator$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00bb  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0174 -> B:16:0x0177). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0140 -> B:32:0x0143). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x00b0 -> B:52:0x005f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i10;
        Iterator<T> it;
        RingBuffer ringBuffer;
        int i11;
        Iterator<T> it2;
        ArrayList arrayList;
        int i12;
        int i13;
        int i14;
        RingBuffer ringBuffer2;
        RandomAccess arrayList2;
        RandomAccess arrayList3;
        SequenceScope sequenceScope = (SequenceScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i15 = this.label;
        if (i15 != 0) {
            if (i15 != 1) {
                if (i15 != 2) {
                    if (i15 != 3) {
                        if (i15 != 4) {
                            if (i15 == 5) {
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            i10 = this.I$1;
                            i14 = this.I$0;
                            ringBuffer2 = (RingBuffer) this.L$1;
                            ResultKt.throwOnFailure(obj);
                            ringBuffer2.removeFirst(this.$step);
                            if (ringBuffer2.size() <= this.$step) {
                                if (this.$reuseBuffer) {
                                    arrayList3 = ringBuffer2;
                                } else {
                                    arrayList3 = new ArrayList(ringBuffer2);
                                }
                                this.L$0 = sequenceScope;
                                this.L$1 = ringBuffer2;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.I$0 = i14;
                                this.I$1 = i10;
                                this.label = 4;
                                if (sequenceScope.yield(arrayList3, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                ringBuffer2.removeFirst(this.$step);
                                if (ringBuffer2.size() <= this.$step) {
                                    if (!ringBuffer2.isEmpty()) {
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                                        this.L$1 = SpillingKt.nullOutSpilledVariable(ringBuffer2);
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.I$0 = i14;
                                        this.I$1 = i10;
                                        this.label = 5;
                                        if (sequenceScope.yield(ringBuffer2, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                        }
                    } else {
                        i10 = this.I$1;
                        i11 = this.I$0;
                        it = (Iterator) this.L$2;
                        ringBuffer = (RingBuffer) this.L$1;
                        ResultKt.throwOnFailure(obj);
                        ringBuffer.removeFirst(this.$step);
                        while (it.hasNext()) {
                            T next = it.next();
                            ringBuffer.add((RingBuffer) next);
                            if (ringBuffer.isFull()) {
                                int size = ringBuffer.size();
                                int i16 = this.$size;
                                if (size < i16) {
                                    ringBuffer = ringBuffer.expanded(i16);
                                } else {
                                    if (this.$reuseBuffer) {
                                        arrayList2 = ringBuffer;
                                    } else {
                                        arrayList2 = new ArrayList(ringBuffer);
                                    }
                                    this.L$0 = sequenceScope;
                                    this.L$1 = ringBuffer;
                                    this.L$2 = it;
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(next);
                                    this.I$0 = i11;
                                    this.I$1 = i10;
                                    this.label = 3;
                                    if (sequenceScope.yield(arrayList2, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    ringBuffer.removeFirst(this.$step);
                                    while (it.hasNext()) {
                                    }
                                }
                            }
                        }
                        if (this.$partialWindows) {
                            i14 = i11;
                            ringBuffer2 = ringBuffer;
                            if (ringBuffer2.size() <= this.$step) {
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            i10 = this.I$1;
            i12 = this.I$0;
            it2 = (Iterator) this.L$2;
            arrayList = (ArrayList) this.L$1;
            ResultKt.throwOnFailure(obj);
            i13 = i10;
            if (!this.$reuseBuffer) {
                arrayList.clear();
            } else {
                arrayList = new ArrayList(this.$size);
            }
            i10 = i13;
            while (it2.hasNext()) {
                T next2 = it2.next();
                if (i13 > 0) {
                    i13--;
                } else {
                    arrayList.add(next2);
                    if (arrayList.size() == this.$size) {
                        this.L$0 = sequenceScope;
                        this.L$1 = arrayList;
                        this.L$2 = it2;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(next2);
                        this.I$0 = i12;
                        this.I$1 = i10;
                        this.I$2 = i13;
                        this.label = 1;
                        if (sequenceScope.yield(arrayList, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i13 = i10;
                        if (!this.$reuseBuffer) {
                        }
                        i10 = i13;
                        while (it2.hasNext()) {
                        }
                    }
                }
            }
            if (!arrayList.isEmpty() && (this.$partialWindows || arrayList.size() == this.$size)) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(arrayList);
                this.L$2 = null;
                this.L$3 = null;
                this.I$0 = i12;
                this.I$1 = i10;
                this.I$2 = i13;
                this.label = 2;
                if (sequenceScope.yield(arrayList, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        int coerceAtMost = RangesKt.coerceAtMost(this.$size, 1024);
        i10 = this.$step - this.$size;
        if (i10 >= 0) {
            ArrayList arrayList4 = new ArrayList(coerceAtMost);
            it2 = this.$iterator;
            arrayList = arrayList4;
            i12 = coerceAtMost;
            i13 = 0;
            while (it2.hasNext()) {
            }
            if (!arrayList.isEmpty()) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(arrayList);
                this.L$2 = null;
                this.L$3 = null;
                this.I$0 = i12;
                this.I$1 = i10;
                this.I$2 = i13;
                this.label = 2;
                if (sequenceScope.yield(arrayList, this) == coroutine_suspended) {
                }
            }
            return Unit.INSTANCE;
        }
        RingBuffer ringBuffer3 = new RingBuffer(coerceAtMost);
        it = this.$iterator;
        ringBuffer = ringBuffer3;
        i11 = coerceAtMost;
        while (it.hasNext()) {
        }
        if (this.$partialWindows) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super List<? extends T>> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SlidingWindowKt$windowedIterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
