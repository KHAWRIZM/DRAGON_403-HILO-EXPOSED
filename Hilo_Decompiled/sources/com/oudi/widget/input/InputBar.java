package com.oudi.widget.input;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.oudi.utils.ICleared;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\nH&J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0005H&J\b\u0010\u0017\u001a\u00020\u0005H&J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH&¨\u0006\u001c"}, d2 = {"Lcom/oudi/widget/input/InputBar;", "Lcom/oudi/utils/ICleared;", "getContentView", "Landroid/view/View;", "onAttachInputLayout", "", "inputLayout", "Lcom/oudi/widget/input/InputContext;", "onPanelChanged", "panelType", "", "getInputEditText", "Landroid/widget/EditText;", "getSendTextView", "Landroid/widget/TextView;", "getEmojiImageView", "Landroid/widget/ImageView;", "appendInput", "content", "deleteInput", "isAll", "", "showSoftInput", "closeSoftInput", "addInputListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/oudi/widget/input/OnInputListener;", "removeInputListener", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface InputBar extends ICleared {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static void onCleared(@NotNull InputBar inputBar) {
            ICleared.DefaultImpls.onCleared(inputBar);
        }
    }

    void addInputListener(@NotNull OnInputListener listener);

    void appendInput(@NotNull String content);

    void closeSoftInput();

    void deleteInput(boolean isAll);

    @NotNull
    View getContentView();

    @NotNull
    ImageView getEmojiImageView();

    @NotNull
    EditText getInputEditText();

    @NotNull
    TextView getSendTextView();

    void onAttachInputLayout(@NotNull InputContext inputLayout);

    void onPanelChanged(@NotNull String panelType);

    void removeInputListener(@NotNull OnInputListener listener);

    void showSoftInput();
}
