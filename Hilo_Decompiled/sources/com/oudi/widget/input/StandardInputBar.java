package com.oudi.widget.input;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.oudi.utils.KeyboardUtils;
import com.oudi.widget.input.InputBar;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u000eJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u0017H\u0016J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u0017H\u0016J\b\u0010,\u001a\u00020\u001eH\u0016R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R+\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00188DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Lcom/oudi/widget/input/StandardInputBar;", "Landroid/widget/FrameLayout;", "Lcom/oudi/widget/input/InputBar;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "inputContext", "Lcom/oudi/widget/input/InputContext;", "getInputContext", "()Lcom/oudi/widget/input/InputContext;", "setInputContext", "(Lcom/oudi/widget/input/InputContext;)V", "inputListeners", "Ljava/util/ArrayList;", "Lcom/oudi/widget/input/OnInputListener;", "Lkotlin/collections/ArrayList;", "getInputListeners", "()Ljava/util/ArrayList;", "inputListeners$delegate", "Lkotlin/Lazy;", "showSoftInput", "", "closeSoftInput", "getContentView", "Landroid/view/View;", "onAttachInputLayout", "appendInput", "content", "", "deleteInput", "isAll", "", "addInputListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeInputListener", "onCleared", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class StandardInputBar extends FrameLayout implements InputBar {

    @Nullable
    private InputContext inputContext;

    /* renamed from: inputListeners$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy inputListeners;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StandardInputBar(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.inputListeners = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.input.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ArrayList inputListeners_delegate$lambda$0;
                inputListeners_delegate$lambda$0 = StandardInputBar.inputListeners_delegate$lambda$0();
                return inputListeners_delegate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList inputListeners_delegate$lambda$0() {
        return new ArrayList();
    }

    @Override // com.oudi.widget.input.InputBar
    public void addInputListener(@NotNull OnInputListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getInputListeners().add(listener);
    }

    @Override // com.oudi.widget.input.InputBar
    public void appendInput(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        EditText inputEditText = getInputEditText();
        inputEditText.getEditableText().insert(inputEditText.getSelectionStart(), content);
    }

    @Override // com.oudi.widget.input.InputBar
    public void closeSoftInput() {
        KeyboardUtils.hideSoftInput(getInputEditText());
    }

    @Override // com.oudi.widget.input.InputBar
    public void deleteInput(boolean isAll) {
        EditText inputEditText = getInputEditText();
        if (!TextUtils.isEmpty(inputEditText.getText())) {
            if (isAll) {
                inputEditText.setText((CharSequence) null);
            } else {
                inputEditText.dispatchKeyEvent(new KeyEvent(0L, 0L, 0, 67, 0, 0, 0, 0, 6));
            }
        }
    }

    @Override // com.oudi.widget.input.InputBar
    @NotNull
    public View getContentView() {
        return this;
    }

    @Nullable
    public final InputContext getInputContext() {
        return this.inputContext;
    }

    @NotNull
    public final ArrayList<OnInputListener> getInputListeners() {
        return (ArrayList) this.inputListeners.getValue();
    }

    @Override // com.oudi.widget.input.InputBar
    public void onAttachInputLayout(@NotNull InputContext inputContext) {
        Intrinsics.checkNotNullParameter(inputContext, "inputContext");
        this.inputContext = inputContext;
    }

    @Override // com.oudi.utils.ICleared
    public void onCleared() {
        InputBar.DefaultImpls.onCleared(this);
        getInputListeners().clear();
    }

    @Override // com.oudi.widget.input.InputBar
    public void removeInputListener(@NotNull OnInputListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getInputListeners().remove(listener);
    }

    public final void setInputContext(@Nullable InputContext inputContext) {
        this.inputContext = inputContext;
    }

    @Override // com.oudi.widget.input.InputBar
    public void showSoftInput() {
        KeyboardUtils.showSoftInput(getInputEditText());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StandardInputBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.inputListeners = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.input.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ArrayList inputListeners_delegate$lambda$0;
                inputListeners_delegate$lambda$0 = StandardInputBar.inputListeners_delegate$lambda$0();
                return inputListeners_delegate$lambda$0;
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StandardInputBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.inputListeners = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.input.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ArrayList inputListeners_delegate$lambda$0;
                inputListeners_delegate$lambda$0 = StandardInputBar.inputListeners_delegate$lambda$0();
                return inputListeners_delegate$lambda$0;
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StandardInputBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.inputListeners = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.input.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ArrayList inputListeners_delegate$lambda$0;
                inputListeners_delegate$lambda$0 = StandardInputBar.inputListeners_delegate$lambda$0();
                return inputListeners_delegate$lambda$0;
            }
        });
    }
}
