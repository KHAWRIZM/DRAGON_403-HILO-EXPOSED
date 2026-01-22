package com.oudi.core.component.bridge;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH&¨\u0006\u000b"}, d2 = {"Lcom/oudi/core/component/bridge/ComponentActionBridge;", "", "observe", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "Lcom/oudi/core/component/bridge/ComponentAction;", "sendAction", NativeProtocol.WEB_DIALOG_ACTION, "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface ComponentActionBridge {
    void observe(@NotNull LifecycleOwner owner, @NotNull Observer<ComponentAction> observer);

    void sendAction(@NotNull ComponentAction action);
}
