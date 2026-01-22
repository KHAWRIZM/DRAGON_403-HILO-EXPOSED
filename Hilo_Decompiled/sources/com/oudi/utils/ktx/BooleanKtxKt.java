package com.oudi.utils.ktx;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006H\u0086\fø\u0001\u0000\u001a)\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006H\u0086\fø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"trueLet", "Lcom/oudi/utils/ktx/Else;", "", "trueBlock", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "falseLet", "falseBlock", "lib_utils_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BooleanKtxKt {
    public static final Else falseLet(boolean z10, Function1<? super Boolean, Unit> falseBlock) {
        Intrinsics.checkNotNullParameter(falseBlock, "falseBlock");
        if (!z10) {
            falseBlock.invoke(Boolean.valueOf(z10));
            return new NotDoElse(z10);
        }
        return new DoElse(z10);
    }

    public static final Else trueLet(boolean z10, Function1<? super Boolean, Unit> trueBlock) {
        Intrinsics.checkNotNullParameter(trueBlock, "trueBlock");
        if (z10) {
            trueBlock.invoke(Boolean.valueOf(z10));
            return new NotDoElse(z10);
        }
        return new DoElse(z10);
    }
}
