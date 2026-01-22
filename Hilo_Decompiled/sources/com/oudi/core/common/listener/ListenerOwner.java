package com.oudi.core.common.listener;

import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/oudi/core/common/listener/ListenerOwner;", "T", "Lcom/oudi/core/common/listener/ListenerStore;", "postEvent", "", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function1;", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface ListenerOwner<T> extends ListenerStore<T> {
    void postEvent(@NotNull Function1<? super T, Unit> block);
}
