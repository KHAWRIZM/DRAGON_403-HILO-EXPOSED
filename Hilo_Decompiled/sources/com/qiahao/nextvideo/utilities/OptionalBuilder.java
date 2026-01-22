package com.qiahao.nextvideo.utilities;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000b\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000f\u001a\u00020\u0010J\r\u0010\u0011\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u0007J-\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\u0004\b\u0001\u0010\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00130\u0015H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0016R$\u0010\u0005\u001a\u0004\u0018\u00018\u00002\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/utilities/OptionalBuilder;", "T", "", "<init>", "()V", "value", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "exists", "", "getExists", "()Z", "build", "getOrBuild", "clear", "", "buildValue", "ifExists", "Ta", "function", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class OptionalBuilder<T> {

    @Nullable
    private T value;

    @NotNull
    public final T build() {
        T buildValue = buildValue();
        this.value = buildValue;
        return buildValue;
    }

    @NotNull
    protected abstract T buildValue();

    public final void clear() {
        this.value = null;
    }

    public final boolean getExists() {
        if (this.value != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public final T getOrBuild() {
        T t = this.value;
        if (t == null) {
            return build();
        }
        return t;
    }

    @Nullable
    public final T getValue() {
        return this.value;
    }

    @Nullable
    public final <Ta> Ta ifExists(@NotNull Function1<? super T, ? extends Ta> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        T value = getValue();
        if (value != null) {
            return (Ta) function.invoke(value);
        }
        return null;
    }
}
