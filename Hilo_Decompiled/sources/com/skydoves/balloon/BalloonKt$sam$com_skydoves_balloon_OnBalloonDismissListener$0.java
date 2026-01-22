package com.skydoves.balloon;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final class BalloonKt$sam$com_skydoves_balloon_OnBalloonDismissListener$0 implements OnBalloonDismissListener, FunctionAdapter {
    private final /* synthetic */ Function0 function;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BalloonKt$sam$com_skydoves_balloon_OnBalloonDismissListener$0(Function0 function0) {
        this.function = function0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof OnBalloonDismissListener) && (obj instanceof FunctionAdapter) && Intrinsics.areEqual(this.function, ((FunctionAdapter) obj).getFunctionDelegate());
    }

    public Function getFunctionDelegate() {
        return this.function;
    }

    public int hashCode() {
        return this.function.hashCode();
    }

    @Override // com.skydoves.balloon.OnBalloonDismissListener
    public final /* synthetic */ void onBalloonDismiss() {
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(), "invoke(...)");
    }
}
