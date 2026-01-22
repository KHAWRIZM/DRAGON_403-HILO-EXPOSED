package com.skydoves.balloon;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class BalloonKt$sam$i$com_skydoves_balloon_OnBalloonOutsideTouchListener$0 implements OnBalloonOutsideTouchListener, FunctionAdapter {
    private final /* synthetic */ Function2 function;

    public BalloonKt$sam$i$com_skydoves_balloon_OnBalloonOutsideTouchListener$0(Function2 function2) {
        this.function = function2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof OnBalloonOutsideTouchListener) && (obj instanceof FunctionAdapter) && Intrinsics.areEqual(this.function, ((FunctionAdapter) obj).getFunctionDelegate());
    }

    public Function getFunctionDelegate() {
        return this.function;
    }

    public int hashCode() {
        return this.function.hashCode();
    }

    @Override // com.skydoves.balloon.OnBalloonOutsideTouchListener
    public final /* synthetic */ void onBalloonOutsideTouch(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(view, motionEvent), "invoke(...)");
    }
}
