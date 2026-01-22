package com.oudi.core.common.livedata;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\nH\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\nH\u0016J\u0018\u0010\u0012\u001a\u00020\r2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\nH\u0016J\u0017\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\rJ\u0015\u0010\u0017\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R:\u0010\u0007\u001a.\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n0\bj\u0016\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/oudi/core/common/livedata/SingleMediatorLiveData;", "T", "Landroidx/lifecycle/MediatorLiveData;", "<init>", "()V", "pending", "Ljava/util/concurrent/atomic/AtomicBoolean;", "foreverObservers", "Ljava/util/HashMap;", "", "Landroidx/lifecycle/Observer;", "Lkotlin/collections/HashMap;", "observe", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "observeForever", "removeObserver", "setValue", "value", "(Ljava/lang/Object;)V", "removeAllObserverForever", "setValueIfHasObservers", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSingleMediatorLiveData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SingleMediatorLiveData.kt\ncom/oudi/core/common/livedata/SingleMediatorLiveData\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,65:1\n216#2,2:66\n*S KotlinDebug\n*F\n+ 1 SingleMediatorLiveData.kt\ncom/oudi/core/common/livedata/SingleMediatorLiveData\n*L\n54#1:66,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SingleMediatorLiveData<T> extends MediatorLiveData<T> {

    @NotNull
    private final AtomicBoolean pending = new AtomicBoolean(false);

    @NotNull
    private final HashMap<Integer, Observer<? super T>> foreverObservers = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observe$lambda$0(SingleMediatorLiveData singleMediatorLiveData, Observer observer, Object obj) {
        if (singleMediatorLiveData.pending.compareAndSet(true, false)) {
            observer.onChanged(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeForever$lambda$1(SingleMediatorLiveData singleMediatorLiveData, Observer observer, Object obj) {
        if (singleMediatorLiveData.pending.compareAndSet(true, false)) {
            observer.onChanged(obj);
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(@NotNull LifecycleOwner owner, @NotNull final Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        super.observe(owner, new SingleMediatorLiveData$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.oudi.core.common.livedata.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit observe$lambda$0;
                observe$lambda$0 = SingleMediatorLiveData.observe$lambda$0(SingleMediatorLiveData.this, observer, obj);
                return observe$lambda$0;
            }
        }));
    }

    @Override // androidx.lifecycle.LiveData
    public void observeForever(@NotNull final Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Observer<? super T> observer2 = new Observer() { // from class: com.oudi.core.common.livedata.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SingleMediatorLiveData.observeForever$lambda$1(SingleMediatorLiveData.this, observer, obj);
            }
        };
        this.foreverObservers.put(Integer.valueOf(observer.hashCode()), observer2);
        super.observeForever(observer2);
    }

    public final void removeAllObserverForever() {
        Iterator<Map.Entry<Integer, Observer<? super T>>> it = this.foreverObservers.entrySet().iterator();
        while (it.hasNext()) {
            super.removeObserver(it.next().getValue());
        }
        this.foreverObservers.clear();
    }

    @Override // androidx.lifecycle.LiveData
    public void removeObserver(@NotNull Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Observer<? super T> remove = this.foreverObservers.remove(Integer.valueOf(observer.hashCode()));
        if (remove != null) {
            super.removeObserver(remove);
        } else {
            super.removeObserver(observer);
        }
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(@Nullable T value) {
        this.pending.set(true);
        super.setValue(value);
    }

    public final void setValueIfHasObservers(@Nullable T value) {
        if (hasObservers()) {
            setValue(value);
        }
    }
}
