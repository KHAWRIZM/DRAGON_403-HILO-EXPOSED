package com.therouter.router;

import com.therouter.router.interceptor.NavigatorParamsFixHandle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
/* synthetic */ class RouteItemKt$getUrlWithParams$2 extends FunctionReferenceImpl implements Function2<String, String, String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RouteItemKt$getUrlWithParams$2(Object obj) {
        super(2, obj, NavigatorParamsFixHandle.class, "fix", "fix(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    @NotNull
    public final String invoke(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "p0");
        Intrinsics.checkNotNullParameter(str2, "p1");
        return ((NavigatorParamsFixHandle) ((CallableReference) this).receiver).fix(str, str2);
    }
}
