package com.oudi.core.window;

import com.oudi.core.component.ICleared;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\fH&¨\u0006\u0010"}, d2 = {"Lcom/oudi/core/window/IWindowTask;", "Lcom/oudi/core/component/ICleared;", "getTag", "", "getGroup", "getPriority", "", "getWindow", "Lcom/oudi/core/window/IWindow;", "isCanShow", "", "show", "", "isShowing", "register", "unregister", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface IWindowTask extends ICleared {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class DefaultImpls {
        public static boolean isShowing(@NotNull IWindowTask iWindowTask) {
            IWindow window = iWindowTask.getWindow();
            if (window != null) {
                return window.isShowing();
            }
            return false;
        }

        public static void onCleared(@NotNull IWindowTask iWindowTask) {
            ICleared.DefaultImpls.onCleared(iWindowTask);
        }
    }

    @Nullable
    String getGroup();

    int getPriority();

    @Nullable
    String getTag();

    @Nullable
    IWindow getWindow();

    boolean isCanShow();

    boolean isShowing();

    void register();

    void show();

    void unregister();
}
