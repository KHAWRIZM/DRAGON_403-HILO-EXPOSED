package com.oudi.core.common.livedata;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u000f\u0010\t\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0005J\u0017\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0005J\u0015\u0010\u000e\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0005J\u0015\u0010\u000f\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0011R\u0012\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/oudi/core/common/livedata/WaitLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "value", "<init>", "(Ljava/lang/Object;)V", "()V", "data", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "postValue", "", "setValue", "onlySetValue", "waitUpdate", "Lcom/oudi/core/common/livedata/WaitUpdate;", "(Ljava/lang/Object;)Lcom/oudi/core/common/livedata/WaitUpdate;", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class WaitLiveData<T> extends MutableLiveData<T> {

    @Nullable
    private T data;

    public WaitLiveData(T t10) {
        super(t10);
    }

    @Override // androidx.lifecycle.LiveData
    @Nullable
    public T getValue() {
        T t10 = this.data;
        if (t10 == null) {
            return (T) super.getValue();
        }
        return t10;
    }

    public final void onlySetValue(@Nullable T value) {
        this.data = value;
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void postValue(@Nullable T value) {
        this.data = value;
        super.postValue(value);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(@Nullable T value) {
        this.data = value;
        super.setValue(value);
    }

    @NotNull
    public final WaitUpdate waitUpdate(@Nullable T value) {
        onlySetValue(value);
        return new WaitUpdate();
    }

    public WaitLiveData() {
    }
}
