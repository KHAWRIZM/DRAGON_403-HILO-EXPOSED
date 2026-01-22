package com.oudi.core.common.livedata;

import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a1\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0002¢\u0006\u0002\u0010\u0006\u001a\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"tryWait", "Lcom/oudi/core/common/livedata/WaitUpdateBuilder;", "T", "liveData", "Lcom/oudi/core/common/livedata/WaitLiveData;", "value", "(Lcom/oudi/core/common/livedata/WaitUpdateBuilder;Lcom/oudi/core/common/livedata/WaitLiveData;Ljava/lang/Object;)Lcom/oudi/core/common/livedata/WaitUpdateBuilder;", "tryCompleteListener", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function0;", "", "lib_core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class WaitUpdateBuilderKt {
    @Nullable
    public static final WaitUpdateBuilder tryCompleteListener(@Nullable WaitUpdateBuilder waitUpdateBuilder, @NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (waitUpdateBuilder == null) {
            block.invoke();
        } else {
            waitUpdateBuilder.completeListener(block);
        }
        return waitUpdateBuilder;
    }

    @Nullable
    public static final <T> WaitUpdateBuilder tryWait(@Nullable WaitUpdateBuilder waitUpdateBuilder, @NotNull WaitLiveData<T> liveData, @Nullable T t10) {
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        if (waitUpdateBuilder == null) {
            liveData.setValue(t10);
        } else {
            waitUpdateBuilder.wait((WaitLiveData<WaitLiveData<T>>) liveData, (WaitLiveData<T>) t10);
        }
        return waitUpdateBuilder;
    }
}
