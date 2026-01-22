package com.oudi.widget.input;

import android.widget.EditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/oudi/widget/input/OnInputListener;", "", "onInputChanged", "", "editText", "Landroid/widget/EditText;", "onSend", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface OnInputListener {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static void onInputChanged(@NotNull OnInputListener onInputListener, @NotNull EditText editText) {
            Intrinsics.checkNotNullParameter(editText, "editText");
        }

        public static void onSend(@NotNull OnInputListener onInputListener, @NotNull EditText editText) {
            Intrinsics.checkNotNullParameter(editText, "editText");
        }
    }

    void onInputChanged(@NotNull EditText editText);

    void onSend(@NotNull EditText editText);
}
