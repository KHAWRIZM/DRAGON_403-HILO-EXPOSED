package com.skydoves.balloon;

import android.view.View;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class BalloonKt$sam$i$com_skydoves_balloon_OnBalloonClickListener$0 implements OnBalloonClickListener, FunctionAdapter {
    private final /* synthetic */ Function1 function;

    public BalloonKt$sam$i$com_skydoves_balloon_OnBalloonClickListener$0(Function1 function1) {
        this.function = function1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof OnBalloonClickListener) && (obj instanceof FunctionAdapter) && Intrinsics.areEqual(this.function, ((FunctionAdapter) obj).getFunctionDelegate());
    }

    public Function getFunctionDelegate() {
        return this.function;
    }

    public int hashCode() {
        return this.function.hashCode();
    }

    @Override // com.skydoves.balloon.OnBalloonClickListener
    public final /* synthetic */ void onBalloonClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(view), "invoke(...)");
    }
}
