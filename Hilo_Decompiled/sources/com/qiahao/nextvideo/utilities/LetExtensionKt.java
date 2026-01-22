package com.qiahao.nextvideo.utilities;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aE\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0005\u001a\u0004\u0018\u0001H\u00032\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"ifNotNull", "", "T1", "T2", "value1", "value2", "bothNotNull", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "app_googleRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LetExtensionKt {
    public static final <T1, T2> void ifNotNull(@Nullable T1 t1, @Nullable T2 t2, @NotNull Function2<? super T1, ? super T2, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "bothNotNull");
        if (t1 != null && t2 != null) {
            function2.invoke(t1, t2);
        }
    }
}
