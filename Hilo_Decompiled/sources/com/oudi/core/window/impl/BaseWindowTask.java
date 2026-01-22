package com.oudi.core.window.impl;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.oudi.core.window.IWindow;
import com.oudi.core.window.IWindowTask;
import com.oudi.core.window.OnWindowDismissListener;
import com.oudi.core.window.WindowTaskManager;
import com.oudi.utils.log.ILog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B/\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0003\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0004J\n\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0014\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0004J\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0004J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0004J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/oudi/core/window/impl/BaseWindowTask;", "Lcom/oudi/core/window/IWindowTask;", "Lcom/oudi/utils/log/ILog;", "<init>", "()V", "priority", "", "window", "Lcom/oudi/core/window/IWindow;", ViewHierarchyConstants.TAG_KEY, "", "group", "(ILcom/oudi/core/window/IWindow;Ljava/lang/String;Ljava/lang/String;)V", "show", "", "getPriority", "getWindow", "getTag", "setTag", "getGroup", "setGroup", "setWindow", "setPriority", "register", "unregister", "onCleared", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class BaseWindowTask implements IWindowTask, ILog {

    @Nullable
    private String group;
    private int priority;

    @Nullable
    private String tag;

    @Nullable
    private IWindow window;

    public BaseWindowTask() {
    }

    @Override // com.oudi.core.window.IWindowTask
    @Nullable
    public String getGroup() {
        return this.group;
    }

    @Override // com.oudi.utils.log.ILog
    @NotNull
    public String getLogTag() {
        return ILog.DefaultImpls.getLogTag(this);
    }

    @Override // com.oudi.core.window.IWindowTask
    public int getPriority() {
        return this.priority;
    }

    @Override // com.oudi.core.window.IWindowTask
    @Nullable
    public String getTag() {
        return this.tag;
    }

    @Override // com.oudi.core.window.IWindowTask
    @Nullable
    public IWindow getWindow() {
        return this.window;
    }

    @Override // com.oudi.core.window.IWindowTask
    public boolean isShowing() {
        return IWindowTask.DefaultImpls.isShowing(this);
    }

    @Override // com.oudi.utils.log.ILog
    public void logD(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logD(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logI(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logI(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logV(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logV(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logW(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logW(this, str, str2, z10);
    }

    @Override // com.oudi.utils.ICleared
    public void onCleared() {
        IWindowTask.DefaultImpls.onCleared(this);
        ILog.DefaultImpls.logD$default(this, "onCleared()", null, false, 6, null);
        IWindow window = getWindow();
        if (window != null) {
            window.setOnDismissListener(null);
        }
        if (isShowing()) {
            ILog.DefaultImpls.logD$default(this, "onCleared() dismiss", null, false, 6, null);
            IWindow iWindow = this.window;
            if (iWindow != null) {
                iWindow.dismiss();
            }
        }
        this.window = null;
    }

    @Override // com.oudi.core.window.IWindowTask
    public void register() {
        WindowTaskManager.INSTANCE.registerTask(this);
    }

    public final void setGroup(@Nullable String group) {
        this.group = group;
    }

    public final void setPriority(int priority) {
        this.priority = priority;
    }

    public final void setTag(@Nullable String tag) {
        this.tag = tag;
    }

    public final void setWindow(@Nullable IWindow window) {
        this.window = window;
    }

    @Override // com.oudi.core.window.IWindowTask
    public void show() {
        ILog.DefaultImpls.logD$default(this, "show()", null, false, 6, null);
        IWindow window = getWindow();
        if (window != null) {
            window.setOnDismissListener(new OnWindowDismissListener() { // from class: com.oudi.core.window.impl.BaseWindowTask$show$1
                @Override // com.oudi.core.window.OnWindowDismissListener
                public void onDismiss() {
                    ILog.DefaultImpls.logD$default(BaseWindowTask.this, "show() onDismiss()", null, false, 6, null);
                    WindowTaskManager.INSTANCE.onWindowDismiss$lib_core_release(BaseWindowTask.this);
                    BaseWindowTask.this.onCleared();
                }
            });
        }
        IWindow window2 = getWindow();
        if (window2 != null) {
            window2.show(null);
        }
    }

    @Override // com.oudi.core.window.IWindowTask
    public void unregister() {
        WindowTaskManager.INSTANCE.unregisterTask(this);
    }

    public BaseWindowTask(int i10, @Nullable IWindow iWindow, @Nullable String str, @Nullable String str2) {
        this.tag = str;
        this.group = str2;
        this.priority = i10;
        this.window = iWindow;
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, th, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
        ILog.DefaultImpls.logE(this, th, str, z10);
    }
}
