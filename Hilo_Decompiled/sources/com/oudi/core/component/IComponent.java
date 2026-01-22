package com.oudi.core.component;

import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0017¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J#\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\b\b\u0000\u0010\f*\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/oudi/core/component/IComponent;", "", "getContext", "Landroid/content/Context;", "getThemeRes", "", "()Ljava/lang/Integer;", "onInitializeBefore", "", "onInitialize", "onInitializeAfter", "findViewById", "T", "Landroid/view/View;", "id", "(I)Landroid/view/View;", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface IComponent {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class DefaultImpls {
        @Nullable
        public static Integer getThemeRes(@NotNull IComponent iComponent) {
            return null;
        }

        public static void onInitialize(@NotNull IComponent iComponent) {
        }

        public static void onInitializeAfter(@NotNull IComponent iComponent) {
        }

        public static void onInitializeBefore(@NotNull IComponent iComponent) {
        }
    }

    @Nullable
    <T extends View> T findViewById(int id);

    @Nullable
    Context getContext();

    @Nullable
    Integer getThemeRes();

    void onInitialize();

    void onInitializeAfter();

    void onInitializeBefore();
}
