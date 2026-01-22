package com.oudi.utils.ktx;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\nH\u0096\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/oudi/utils/ktx/DoElse;", "Lcom/oudi/utils/ktx/Else;", "boolean", "", "<init>", "(Z)V", "elseLet", "", "elseBlock", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class DoElse implements Else {
    private final boolean boolean;

    public DoElse(boolean z10) {
        this.boolean = z10;
    }

    @Override // com.oudi.utils.ktx.Else
    public void elseLet(Function1<? super Boolean, Unit> elseBlock) {
        Intrinsics.checkNotNullParameter(elseBlock, "elseBlock");
        elseBlock.invoke(Boolean.valueOf(this.boolean));
    }
}
