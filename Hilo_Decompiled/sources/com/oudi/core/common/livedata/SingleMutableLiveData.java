package com.oudi.core.common.livedata;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\fH\u0016J\u0018\u0010\u0013\u001a\u00020\u000f2\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\fH\u0016J\u0018\u0010\u0014\u001a\u00020\u000f2\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\fH\u0016J\u0017\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R:\u0010\t\u001a.\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00028\u00000\f0\nj\u0016\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00028\u00000\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/oudi/core/common/livedata/SingleMutableLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "value", "<init>", "(Ljava/lang/Object;)V", "()V", "pending", "Ljava/util/concurrent/atomic/AtomicBoolean;", "foreverObservers", "Ljava/util/HashMap;", "", "Landroidx/lifecycle/Observer;", "Lkotlin/collections/HashMap;", "observe", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "observeForever", "removeObserver", "setValue", "setValueIfHasObservers", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SingleMutableLiveData<T> extends MutableLiveData<T> {

    @NotNull
    private final HashMap<Integer, Observer<? super T>> foreverObservers;

    @NotNull
    private final AtomicBoolean pending;

    public SingleMutableLiveData(T t10) {
        super(t10);
        this.pending = new AtomicBoolean(false);
        this.foreverObservers = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observe$lambda$0(SingleMutableLiveData singleMutableLiveData, Observer observer, Object obj) {
        if (singleMutableLiveData.pending.compareAndSet(true, false)) {
            observer.onChanged(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeForever$lambda$1(SingleMutableLiveData singleMutableLiveData, Observer observer, Object obj) {
        if (singleMutableLiveData.pending.compareAndSet(true, false)) {
            observer.onChanged(obj);
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(@NotNull LifecycleOwner owner, @NotNull final Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        super.observe(owner, new SingleMutableLiveData$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.oudi.core.common.livedata.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit observe$lambda$0;
                observe$lambda$0 = SingleMutableLiveData.observe$lambda$0(SingleMutableLiveData.this, observer, obj);
                return observe$lambda$0;
            }
        }));
    }

    @Override // androidx.lifecycle.LiveData
    public void observeForever(@NotNull final Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Observer<? super T> observer2 = new Observer() { // from class: com.oudi.core.common.livedata.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SingleMutableLiveData.observeForever$lambda$1(SingleMutableLiveData.this, observer, obj);
            }
        };
        this.foreverObservers.put(Integer.valueOf(observer.hashCode()), observer2);
        super.observeForever(observer2);
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

    public SingleMutableLiveData() {
        this.pending = new AtomicBoolean(false);
        this.foreverObservers = new HashMap<>();
    }
}
