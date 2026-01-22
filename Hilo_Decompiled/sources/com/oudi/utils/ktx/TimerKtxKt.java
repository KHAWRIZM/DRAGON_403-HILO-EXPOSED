package com.oudi.utils.ktx;

import androidx.lifecycle.LifecycleOwner;
import com.oudi.utils.TimerTask;
import com.oudi.utils.TimerUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ai\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072%\b\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\n2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010\u001aE\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00072%\b\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\n¨\u0006\u0013"}, d2 = {"countTask", "Lcom/oudi/utils/TimerTask;", "Landroidx/lifecycle/LifecycleOwner;", "isVisiblePost", "", "isDesc", "totalCount", "", "countUnit", "onTick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "", "onFinish", "Lkotlin/Function0;", "loopTask", "countInterval", "lib_utils_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class TimerKtxKt {
    public static final TimerTask countTask(LifecycleOwner lifecycleOwner, boolean z10, boolean z11, long j10, long j11, Function1<? super Long, Unit> function1, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        return TimerUtils.INSTANCE.count(lifecycleOwner, z10, z11, j10, j11, function1, function0);
    }

    public static /* synthetic */ TimerTask countTask$default(LifecycleOwner lifecycleOwner, boolean z10, boolean z11, long j10, long j11, Function1 function1, Function0 function0, int i10, Object obj) {
        boolean z12;
        boolean z13;
        long j12;
        Function1 function12;
        Function0 function02;
        if ((i10 & 1) != 0) {
            z12 = true;
        } else {
            z12 = z10;
        }
        if ((i10 & 2) != 0) {
            z13 = false;
        } else {
            z13 = z11;
        }
        if ((i10 & 8) != 0) {
            j12 = 1000;
        } else {
            j12 = j11;
        }
        if ((i10 & 16) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        if ((i10 & 32) != 0) {
            function02 = null;
        } else {
            function02 = function0;
        }
        return countTask(lifecycleOwner, z12, z13, j10, j12, function12, function02);
    }

    public static final TimerTask loopTask(LifecycleOwner lifecycleOwner, boolean z10, long j10, Function1<? super Long, Unit> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        return TimerUtils.INSTANCE.loop(lifecycleOwner, z10, j10, function1);
    }

    public static /* synthetic */ TimerTask loopTask$default(LifecycleOwner lifecycleOwner, boolean z10, long j10, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            j10 = 1000;
        }
        if ((i10 & 4) != 0) {
            function1 = null;
        }
        return loopTask(lifecycleOwner, z10, j10, function1);
    }
}
