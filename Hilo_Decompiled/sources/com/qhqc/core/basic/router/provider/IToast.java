package com.qhqc.core.basic.router.provider;

import android.content.Context;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/qhqc/core/basic/router/provider/IToast;", "", "showToast", "", "context", "Landroid/content/Context;", ViewHierarchyConstants.TEXT_KEY, "", "duration", "", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface IToast {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static void showToast(@NotNull IToast iToast, @NotNull Context context, @NotNull CharSequence text) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(text, "text");
        }

        public static void showToast(@NotNull IToast iToast, @NotNull Context context, @Nullable CharSequence charSequence, int i10) {
            Intrinsics.checkNotNullParameter(context, "context");
        }

        public static void showToast(@NotNull IToast iToast, @NotNull CharSequence text) {
            Intrinsics.checkNotNullParameter(text, "text");
        }
    }

    void showToast(@NotNull Context context, @NotNull CharSequence text);

    void showToast(@NotNull Context context, @Nullable CharSequence text, int duration);

    void showToast(@NotNull CharSequence text);
}
