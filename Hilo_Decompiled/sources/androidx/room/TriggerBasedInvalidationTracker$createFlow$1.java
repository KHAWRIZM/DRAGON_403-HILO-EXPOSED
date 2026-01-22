package androidx.room;

import androidx.room.util.DBUtil;
import java.util.ArrayList;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker$createFlow$1", f = "InvalidationTracker.kt", i = {0, 1}, l = {233, 233, 237}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class TriggerBasedInvalidationTracker$createFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super Set<? extends String>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $emitInitialState;
    final /* synthetic */ String[] $resolvedTableNames;
    final /* synthetic */ int[] $tableIds;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1", f = "InvalidationTracker.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ TriggerBasedInvalidationTracker this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = triggerBasedInvalidationTracker;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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
                TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = this.this$0;
                this.label = 1;
                if (triggerBasedInvalidationTracker.syncTriggers$room_runtime_release(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nInvalidationTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/TriggerBasedInvalidationTracker$createFlow$1$2\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,604:1\n3912#2:605\n4011#2:606\n13467#2,2:607\n4012#2,2:609\n13469#2:611\n4014#2:612\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/TriggerBasedInvalidationTracker$createFlow$1$2\n*L\n245#1:605\n245#1:606\n245#1:607,2\n245#1:609,2\n245#1:611\n245#1:612\n*E\n"})
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<Set<String>> $$this$flow;
        final /* synthetic */ Ref.ObjectRef<int[]> $currentVersions;
        final /* synthetic */ boolean $emitInitialState;
        final /* synthetic */ String[] $resolvedTableNames;
        final /* synthetic */ int[] $tableIds;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Ref.ObjectRef<int[]> objectRef, boolean z10, FlowCollector<? super Set<String>> flowCollector, String[] strArr, int[] iArr) {
            this.$currentVersions = objectRef;
            this.$emitInitialState = z10;
            this.$$this$flow = flowCollector;
            this.$resolvedTableNames = strArr;
            this.$tableIds = iArr;
        }

        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((int[]) obj, (Continuation<? super Unit>) continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(int[] iArr, Continuation<? super Unit> continuation) {
            TriggerBasedInvalidationTracker$createFlow$1$2$emit$1 triggerBasedInvalidationTracker$createFlow$1$2$emit$1;
            int i10;
            AnonymousClass2<T> anonymousClass2;
            Object obj;
            if (continuation instanceof TriggerBasedInvalidationTracker$createFlow$1$2$emit$1) {
                triggerBasedInvalidationTracker$createFlow$1$2$emit$1 = (TriggerBasedInvalidationTracker$createFlow$1$2$emit$1) continuation;
                int i11 = triggerBasedInvalidationTracker$createFlow$1$2$emit$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    triggerBasedInvalidationTracker$createFlow$1$2$emit$1.label = i11 - Integer.MIN_VALUE;
                    Object obj2 = triggerBasedInvalidationTracker$createFlow$1$2$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i10 = triggerBasedInvalidationTracker$createFlow$1$2$emit$1.label;
                    if (i10 != 0) {
                        ResultKt.throwOnFailure(obj2);
                        Ref.ObjectRef<int[]> objectRef = this.$currentVersions;
                        if (objectRef.element == null) {
                            if (this.$emitInitialState) {
                                FlowCollector<Set<String>> flowCollector = this.$$this$flow;
                                Set set = ArraysKt.toSet(this.$resolvedTableNames);
                                triggerBasedInvalidationTracker$createFlow$1$2$emit$1.L$0 = this;
                                triggerBasedInvalidationTracker$createFlow$1$2$emit$1.L$1 = iArr;
                                triggerBasedInvalidationTracker$createFlow$1$2$emit$1.label = 1;
                                if (flowCollector.emit(set, triggerBasedInvalidationTracker$createFlow$1$2$emit$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            String[] strArr = this.$resolvedTableNames;
                            int[] iArr2 = this.$tableIds;
                            ArrayList arrayList = new ArrayList();
                            int length = strArr.length;
                            int i12 = 0;
                            int i13 = 0;
                            while (i12 < length) {
                                String str = strArr[i12];
                                int i14 = i13 + 1;
                                int[] iArr3 = objectRef.element;
                                if (iArr3 != null) {
                                    int i15 = iArr2[i13];
                                    if (iArr3[i15] != iArr[i15]) {
                                        arrayList.add(str);
                                    }
                                    i12++;
                                    i13 = i14;
                                } else {
                                    throw new IllegalStateException("Required value was null.");
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                FlowCollector<Set<String>> flowCollector2 = this.$$this$flow;
                                Set set2 = CollectionsKt.toSet(arrayList);
                                triggerBasedInvalidationTracker$createFlow$1$2$emit$1.L$0 = this;
                                triggerBasedInvalidationTracker$createFlow$1$2$emit$1.L$1 = iArr;
                                triggerBasedInvalidationTracker$createFlow$1$2$emit$1.label = 2;
                                if (flowCollector2.emit(set2, triggerBasedInvalidationTracker$createFlow$1$2$emit$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        }
                        anonymousClass2 = this;
                        obj = iArr;
                    } else {
                        if (i10 != 1 && i10 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Object obj3 = (T) ((int[]) triggerBasedInvalidationTracker$createFlow$1$2$emit$1.L$1);
                        anonymousClass2 = (AnonymousClass2) triggerBasedInvalidationTracker$createFlow$1$2$emit$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        obj = obj3;
                    }
                    anonymousClass2.$currentVersions.element = (T) obj;
                    return Unit.INSTANCE;
                }
            }
            triggerBasedInvalidationTracker$createFlow$1$2$emit$1 = new TriggerBasedInvalidationTracker$createFlow$1$2$emit$1(this, continuation);
            Object obj22 = triggerBasedInvalidationTracker$createFlow$1$2$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i10 = triggerBasedInvalidationTracker$createFlow$1$2$emit$1.label;
            if (i10 != 0) {
            }
            anonymousClass2.$currentVersions.element = (T) obj;
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$createFlow$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, int[] iArr, boolean z10, String[] strArr, Continuation<? super TriggerBasedInvalidationTracker$createFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = triggerBasedInvalidationTracker;
        this.$tableIds = iArr;
        this.$emitInitialState = z10;
        this.$resolvedTableNames = strArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TriggerBasedInvalidationTracker$createFlow$1 triggerBasedInvalidationTracker$createFlow$1 = new TriggerBasedInvalidationTracker$createFlow$1(this.this$0, this.$tableIds, this.$emitInitialState, this.$resolvedTableNames, continuation);
        triggerBasedInvalidationTracker$createFlow$1.L$0 = obj;
        return triggerBasedInvalidationTracker$createFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Set<? extends String>> flowCollector, Continuation<? super Unit> continuation) {
        return invoke2((FlowCollector<? super Set<String>>) flowCollector, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0094 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ObservedTableStates observedTableStates;
        ObservedTableStates observedTableStates2;
        FlowCollector flowCollector;
        RoomDatabase roomDatabase;
        FlowCollector flowCollector2;
        ObservedTableVersions observedTableVersions;
        AnonymousClass2 anonymousClass2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        try {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        throw new KotlinNothingValueException();
                    }
                    flowCollector2 = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    flowCollector = flowCollector2;
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    observedTableVersions = this.this$0.observedTableVersions;
                    anonymousClass2 = new AnonymousClass2(objectRef, this.$emitInitialState, flowCollector, this.$resolvedTableNames, this.$tableIds);
                    this.L$0 = null;
                    this.label = 3;
                    if (observedTableVersions.collect(anonymousClass2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    throw new KotlinNothingValueException();
                }
                flowCollector2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector3 = (FlowCollector) this.L$0;
                observedTableStates2 = this.this$0.observedTableStates;
                if (observedTableStates2.onObserverAdded$room_runtime_release(this.$tableIds)) {
                    roomDatabase = this.this$0.database;
                    this.L$0 = flowCollector3;
                    this.label = 1;
                    Object coroutineContext = DBUtil.getCoroutineContext(roomDatabase, false, this);
                    if (coroutineContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowCollector2 = flowCollector3;
                    obj = coroutineContext;
                } else {
                    flowCollector = flowCollector3;
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    observedTableVersions = this.this$0.observedTableVersions;
                    anonymousClass2 = new AnonymousClass2(objectRef2, this.$emitInitialState, flowCollector, this.$resolvedTableNames, this.$tableIds);
                    this.L$0 = null;
                    this.label = 3;
                    if (observedTableVersions.collect(anonymousClass2, this) == coroutine_suspended) {
                    }
                    throw new KotlinNothingValueException();
                }
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.L$0 = flowCollector2;
            this.label = 2;
            if (BuildersKt.withContext((CoroutineContext) obj, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowCollector = flowCollector2;
            Ref.ObjectRef objectRef22 = new Ref.ObjectRef();
            observedTableVersions = this.this$0.observedTableVersions;
            anonymousClass2 = new AnonymousClass2(objectRef22, this.$emitInitialState, flowCollector, this.$resolvedTableNames, this.$tableIds);
            this.L$0 = null;
            this.label = 3;
            if (observedTableVersions.collect(anonymousClass2, this) == coroutine_suspended) {
            }
            throw new KotlinNothingValueException();
        } catch (Throwable th) {
            observedTableStates = this.this$0.observedTableStates;
            observedTableStates.onObserverRemoved$room_runtime_release(this.$tableIds);
            throw th;
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super Set<String>> flowCollector, Continuation<? super Unit> continuation) {
        return ((TriggerBasedInvalidationTracker$createFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
