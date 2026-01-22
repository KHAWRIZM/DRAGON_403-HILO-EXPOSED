package com.oudi.core.common.livedata;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\bR\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/oudi/core/common/livedata/NoNullWaitLiveData;", "T", "Lcom/oudi/core/common/livedata/WaitLiveData;", "defaultValue", "<init>", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class NoNullWaitLiveData<T> extends WaitLiveData<T> {
    private final T defaultValue;

    public NoNullWaitLiveData(T t10) {
        super(t10);
        this.defaultValue = t10;
    }

    @Override // com.oudi.core.common.livedata.WaitLiveData, androidx.lifecycle.LiveData
    public T getValue() {
        T t10 = (T) super.getValue();
        if (t10 == null) {
            return this.defaultValue;
        }
        return t10;
    }
}
