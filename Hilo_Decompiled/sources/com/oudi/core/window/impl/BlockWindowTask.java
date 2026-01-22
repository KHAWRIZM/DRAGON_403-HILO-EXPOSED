package com.oudi.core.window.impl;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.oudi.core.window.IWindow;
import com.oudi.core.window.WindowTaskManager;
import com.oudi.utils.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B+\b\u0016\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u0006H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/oudi/core/window/impl/BlockWindowTask;", "Lcom/oudi/core/window/impl/BaseWindowTask;", "Lcom/oudi/utils/log/ILog;", "priority", "", ViewHierarchyConstants.TAG_KEY, "", "group", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "isCanShow", "", "ready", "", "window", "Lcom/oudi/core/window/IWindow;", "toString", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class BlockWindowTask extends BaseWindowTask implements ILog {
    private boolean isCanShow;

    public BlockWindowTask(int i10, @Nullable String str, @Nullable String str2) {
        super(i10, null, str, str2);
    }

    @Override // com.oudi.core.window.IWindowTask
    public boolean isCanShow() {
        if (getWindow() != null && this.isCanShow) {
            return true;
        }
        return false;
    }

    public final void ready(@NotNull IWindow window) {
        Intrinsics.checkNotNullParameter(window, "window");
        setWindow(window);
        this.isCanShow = true;
        WindowTaskManager.INSTANCE.loopTask();
    }

    @NotNull
    public String toString() {
        return "BlockWindowTask{priority:" + getPriority() + ",tag:" + getTag() + ",group:" + getGroup() + ",isCanShow:" + isCanShow() + "}";
    }

    public /* synthetic */ BlockWindowTask(int i10, String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2);
    }
}
