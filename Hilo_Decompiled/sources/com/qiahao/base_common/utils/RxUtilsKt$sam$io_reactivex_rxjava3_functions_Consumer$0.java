package com.qiahao.base_common.utils;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class RxUtilsKt$sam$io_reactivex_rxjava3_functions_Consumer$0 implements pd.g {
    private final /* synthetic */ Function1 function;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RxUtilsKt$sam$io_reactivex_rxjava3_functions_Consumer$0(Function1 function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.function = function;
    }

    @Override // pd.g
    public final /* synthetic */ void accept(Object obj) {
        this.function.invoke(obj);
    }
}
