package com.oudi.core.window.impl;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.oudi.core.window.IWindow;
import com.oudi.utils.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B3\b\u0016\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/oudi/core/window/impl/WindowTask;", "Lcom/oudi/core/window/impl/BaseWindowTask;", "Lcom/oudi/utils/log/ILog;", "priority", "", "window", "Lcom/oudi/core/window/IWindow;", ViewHierarchyConstants.TAG_KEY, "", "group", "<init>", "(ILcom/oudi/core/window/IWindow;Ljava/lang/String;Ljava/lang/String;)V", "isCanShow", "", "toString", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class WindowTask extends BaseWindowTask implements ILog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowTask(int i10, @NotNull IWindow window, @Nullable String str, @Nullable String str2) {
        super(i10, window, str, str2);
        Intrinsics.checkNotNullParameter(window, "window");
    }

    @Override // com.oudi.core.window.IWindowTask
    public boolean isCanShow() {
        if (getWindow() != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "WindowTask{priority:" + getPriority() + ",tag:" + getTag() + ",group:" + getGroup() + ",isCanShow:" + isCanShow() + "}";
    }

    public /* synthetic */ WindowTask(int i10, IWindow iWindow, String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0 : i10, iWindow, (i11 & 4) != 0 ? null : str, (i11 & 8) != 0 ? null : str2);
    }
}
