package com.oudi.core.common.livedata;

import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u0001H\u0003H&¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH&¨\u0006\f"}, d2 = {"Lcom/oudi/core/common/livedata/WaitUpdateBuilder;", "", "wait", "T", "liveData", "Lcom/oudi/core/common/livedata/WaitLiveData;", "value", "(Lcom/oudi/core/common/livedata/WaitLiveData;Ljava/lang/Object;)Lcom/oudi/core/common/livedata/WaitUpdateBuilder;", "completeListener", "", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function0;", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface WaitUpdateBuilder {
    void completeListener(@NotNull Function0<Unit> block);

    @NotNull
    <T> WaitUpdateBuilder wait(@Nullable WaitLiveData<T> liveData, @Nullable T value);
}
