package com.qiahao.base_common.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u0002H\u000e2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020\r0\u0012¢\u0006\u0002\u0010\u0013J=\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u0002H\u000e2\u0006\u0010\u0014\u001a\u00020\u000b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020\r0\u0012¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/qiahao/base_common/utils/MultiTypeDataDebouncer;", "", "<init>", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "typeDebouncers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/qiahao/base_common/utils/MultiTypeDataDebouncer$TypeDebouncer;", "debounceDelay", "", "receiveData", "", "T", "type", "data", "onDataReceived", "Lkotlin/Function1;", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "delay", "(Ljava/lang/String;Ljava/lang/Object;JLkotlin/jvm/functions/Function1;)V", "clearType", "destroy", "TypeDebouncer", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMultiTypeDataDebouncer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiTypeDataDebouncer.kt\ncom/qiahao/base_common/utils/MultiTypeDataDebouncer\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,119:1\n72#2,2:120\n72#2,2:123\n1#3:122\n1#3:125\n1869#4,2:126\n*S KotlinDebug\n*F\n+ 1 MultiTypeDataDebouncer.kt\ncom/qiahao/base_common/utils/MultiTypeDataDebouncer\n*L\n16#1:120,2\n27#1:123,2\n16#1:122\n27#1:125\n45#1:126,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class MultiTypeDataDebouncer {

    @NotNull
    private final CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));

    @NotNull
    private final ConcurrentHashMap<String, TypeDebouncer<?>> typeDebouncers = new ConcurrentHashMap<>();
    private final long debounceDelay = 1000;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\u0006\u0010\u0018\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/qiahao/base_common/utils/MultiTypeDataDebouncer$TypeDebouncer;", "T", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "delay", "", "onDataReceived", "Lkotlin/Function1;", "", "<init>", "(Lkotlinx/coroutines/CoroutineScope;JLkotlin/jvm/functions/Function1;)V", "latestData", "Ljava/lang/Object;", "hasPendingData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isExecuting", "job", "Lkotlinx/coroutines/Job;", "receiveData", "data", "(Ljava/lang/Object;)V", "executeWithDelay", "executeDataProcessing", "cancel", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class TypeDebouncer<T> {
        private final long delay;

        @NotNull
        private final AtomicBoolean hasPendingData;

        @NotNull
        private final AtomicBoolean isExecuting;

        @Nullable
        private Job job;

        @Nullable
        private T latestData;

        @NotNull
        private final Function1<T, Unit> onDataReceived;

        @NotNull
        private final CoroutineScope scope;

        /* JADX WARN: Multi-variable type inference failed */
        public TypeDebouncer(@NotNull CoroutineScope scope, long j10, @NotNull Function1<? super T, Unit> onDataReceived) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(onDataReceived, "onDataReceived");
            this.scope = scope;
            this.delay = j10;
            this.onDataReceived = onDataReceived;
            this.hasPendingData = new AtomicBoolean(false);
            this.isExecuting = new AtomicBoolean(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void executeDataProcessing() {
            T t10 = this.latestData;
            if (t10 != null && this.hasPendingData.compareAndSet(true, false)) {
                try {
                    this.onDataReceived.invoke(t10);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void executeWithDelay() {
            Job launch$default;
            if (this.hasPendingData.get()) {
                launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new MultiTypeDataDebouncer$TypeDebouncer$executeWithDelay$1(this, null), 3, null);
                this.job = launch$default;
            }
        }

        public final void cancel() {
            Job job = this.job;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.latestData = null;
            this.hasPendingData.set(false);
            this.isExecuting.set(false);
        }

        public final void receiveData(T data) {
            this.latestData = data;
            this.hasPendingData.set(true);
            if (!this.isExecuting.get()) {
                executeWithDelay();
            }
        }
    }

    public final void clearType(@NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        TypeDebouncer<?> remove = this.typeDebouncers.remove(type);
        if (remove != null) {
            remove.cancel();
        }
    }

    public final void destroy() {
        Collection<TypeDebouncer<?>> values = this.typeDebouncers.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((TypeDebouncer) it.next()).cancel();
        }
        this.typeDebouncers.clear();
        CoroutineScopeKt.cancel$default(this.coroutineScope, null, 1, null);
    }

    public final <T> void receiveData(@NotNull String type, T data, @NotNull Function1<? super T, Unit> onDataReceived) {
        TypeDebouncer<?> putIfAbsent;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(onDataReceived, "onDataReceived");
        ConcurrentHashMap<String, TypeDebouncer<?>> concurrentHashMap = this.typeDebouncers;
        TypeDebouncer<?> typeDebouncer = concurrentHashMap.get(type);
        if (typeDebouncer == null && (putIfAbsent = concurrentHashMap.putIfAbsent(type, (typeDebouncer = new TypeDebouncer<>(this.coroutineScope, this.debounceDelay, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(onDataReceived, 1))))) != null) {
            typeDebouncer = putIfAbsent;
        }
        Intrinsics.checkNotNull(typeDebouncer, "null cannot be cast to non-null type com.qiahao.base_common.utils.MultiTypeDataDebouncer.TypeDebouncer<T of com.qiahao.base_common.utils.MultiTypeDataDebouncer.receiveData>");
        typeDebouncer.receiveData(data);
    }

    public final <T> void receiveData(@NotNull String type, T data, long delay, @NotNull Function1<? super T, Unit> onDataReceived) {
        TypeDebouncer<?> putIfAbsent;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(onDataReceived, "onDataReceived");
        ConcurrentHashMap<String, TypeDebouncer<?>> concurrentHashMap = this.typeDebouncers;
        TypeDebouncer<?> typeDebouncer = concurrentHashMap.get(type);
        if (typeDebouncer == null && (putIfAbsent = concurrentHashMap.putIfAbsent(type, (typeDebouncer = new TypeDebouncer<>(this.coroutineScope, delay, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(onDataReceived, 1))))) != null) {
            typeDebouncer = putIfAbsent;
        }
        Intrinsics.checkNotNull(typeDebouncer, "null cannot be cast to non-null type com.qiahao.base_common.utils.MultiTypeDataDebouncer.TypeDebouncer<T of com.qiahao.base_common.utils.MultiTypeDataDebouncer.receiveData>");
        typeDebouncer.receiveData(data);
    }
}
