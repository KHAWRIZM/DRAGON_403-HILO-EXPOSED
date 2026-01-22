package com.qiahao.nextvideo.utilities;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0006"}, d2 = {"optionalBuilder", "Lcom/qiahao/nextvideo/utilities/OptionalBuilder;", "T", "", "builder", "Lkotlin/Function0;", "app_googleRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class OptionalKt {
    @NotNull
    public static final <T> OptionalBuilder<T> optionalBuilder(@NotNull final Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "builder");
        return new OptionalBuilder<T>() { // from class: com.qiahao.nextvideo.utilities.OptionalKt$optionalBuilder$1
            @Override // com.qiahao.nextvideo.utilities.OptionalBuilder
            protected T buildValue() {
                return (T) function0.invoke();
            }
        };
    }
}
