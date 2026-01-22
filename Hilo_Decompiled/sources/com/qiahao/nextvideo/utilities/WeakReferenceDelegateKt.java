package com.qiahao.nextvideo.utilities;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"weak", "Lcom/qiahao/nextvideo/utilities/WeakReferenceDelegate;", "T", "value", "(Ljava/lang/Object;)Lcom/qiahao/nextvideo/utilities/WeakReferenceDelegate;", "app_googleRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class WeakReferenceDelegateKt {
    @NotNull
    public static final <T> WeakReferenceDelegate<T> weak() {
        return new WeakReferenceDelegate<>();
    }

    @NotNull
    public static final <T> WeakReferenceDelegate<T> weak(T t) {
        return new WeakReferenceDelegate<>(t);
    }
}
