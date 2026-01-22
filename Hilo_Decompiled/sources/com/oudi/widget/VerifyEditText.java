package com.oudi.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.oudi.utils.AppUtils;
import com.oudi.utils.log.ILog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u000eJ\u0010\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u000bH\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010,\u001a\u00020\u000bH\u0002J\u0006\u0010/\u001a\u00020\u0018J\u0006\u00100\u001a\u00020\u0017J\u0006\u00101\u001a\u00020\u0018J\u000e\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u0017J\u0006\u00104\u001a\u00020\u000bJ\b\u00105\u001a\u00020\u0018H\u0002J\u0006\u00106\u001a\u00020\u0018R\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\u001f\u0010 R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/oudi/widget/VerifyEditText;", "Landroid/widget/FrameLayout;", "Lcom/oudi/utils/log/ILog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "editText", "Landroid/widget/EditText;", "getEditText", "()Landroid/widget/EditText;", "editText$delegate", "Lkotlin/Lazy;", "onInputListener", "Lkotlin/Function1;", "", "", "getOnInputListener", "()Lkotlin/jvm/functions/Function1;", "setOnInputListener", "(Lkotlin/jvm/functions/Function1;)V", "itemLayout", "Landroid/widget/LinearLayout;", "getItemLayout", "()Landroid/widget/LinearLayout;", "itemLayout$delegate", "itemBackgroundNormal", "Landroid/graphics/drawable/Drawable;", "itemBackgroundSelector", "itemBackgroundFocus", "itemCount", "initItemView", "typedArray", "Landroid/content/res/TypedArray;", "initEditText", "setFocusItem", FirebaseAnalytics.Param.INDEX, "getItemView", "Landroid/widget/TextView;", "showKeyBoard", "getContent", "clearContent", "setContent", "content", "getInputMaxLength", "showSoftKeyBoard", "hideKeyBoard", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVerifyEditText.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerifyEditText.kt\ncom/oudi/widget/VerifyEditText\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,253:1\n55#2,12:254\n84#2,3:266\n*S KotlinDebug\n*F\n+ 1 VerifyEditText.kt\ncom/oudi/widget/VerifyEditText\n*L\n156#1:254,12\n156#1:266,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class VerifyEditText extends FrameLayout implements ILog {

    /* renamed from: editText$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy editText;

    @Nullable
    private Drawable itemBackgroundFocus;

    @Nullable
    private Drawable itemBackgroundNormal;

    @Nullable
    private Drawable itemBackgroundSelector;
    private int itemCount;

    /* renamed from: itemLayout$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy itemLayout;

    @Nullable
    private Function1<? super String, Unit> onInputListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VerifyEditText(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EditText editText_delegate$lambda$0(VerifyEditText verifyEditText) {
        return new EditText(verifyEditText.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout getItemLayout() {
        return (LinearLayout) this.itemLayout.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getItemView(int index) {
        View childAt = getItemLayout().getChildAt(index);
        if (childAt instanceof TextView) {
            return (TextView) childAt;
        }
        return null;
    }

    private final void initEditText(TypedArray typedArray) {
        int i10 = typedArray.getInt(R.styleable.VerifyEditText_vet_inputType, 2);
        getEditText().setLayoutParams(new FrameLayout.LayoutParams(1, 1));
        getEditText().setInputType(i10);
        getEditText().setCursorVisible(false);
        getEditText().setBackground(null);
        getEditText().setMaxLines(1);
        getEditText().setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.itemCount)});
        getEditText().addTextChangedListener(new TextWatcher() { // from class: com.oudi.widget.VerifyEditText$initEditText$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s10) {
                LinearLayout itemLayout;
                TextView itemView;
                Drawable drawable;
                Drawable drawable2;
                char[] charArray = String.valueOf(s10).toCharArray();
                Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
                itemLayout = VerifyEditText.this.getItemLayout();
                int childCount = itemLayout.getChildCount();
                int i11 = 0;
                for (int i12 = 0; i12 < childCount; i12++) {
                    itemView = VerifyEditText.this.getItemView(i12);
                    if (itemView != null) {
                        if (i12 < charArray.length) {
                            itemView.setText(String.valueOf(charArray[i12]));
                            drawable2 = VerifyEditText.this.itemBackgroundSelector;
                            if (drawable2 == null) {
                                drawable2 = VerifyEditText.this.itemBackgroundNormal;
                            }
                            itemView.setBackground(drawable2);
                        } else {
                            itemView.setText("");
                            drawable = VerifyEditText.this.itemBackgroundNormal;
                            itemView.setBackground(drawable);
                        }
                    }
                }
                VerifyEditText verifyEditText = VerifyEditText.this;
                if (s10 != null) {
                    i11 = s10.length();
                }
                verifyEditText.setFocusItem(i11);
                Function1<String, Unit> onInputListener = VerifyEditText.this.getOnInputListener();
                if (onInputListener != null) {
                    onInputListener.invoke(String.valueOf(s10));
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: com.oudi.widget.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VerifyEditText.initEditText$lambda$5(VerifyEditText.this, view);
            }
        });
        addView(getEditText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initEditText$lambda$5(VerifyEditText verifyEditText, View view) {
        verifyEditText.getEditText().requestLayout();
        verifyEditText.showSoftKeyBoard();
    }

    private final void initItemView(TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.VerifyEditText_vet_item_width, 100);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(R.styleable.VerifyEditText_vet_item_height, dimensionPixelSize);
        int dimensionPixelSize3 = typedArray.getDimensionPixelSize(R.styleable.VerifyEditText_vet_text_size, -1);
        int color = typedArray.getColor(R.styleable.VerifyEditText_vet_text_color, -1);
        Drawable drawable = typedArray.getDrawable(R.styleable.VerifyEditText_vet_item_divider_drawable);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            getItemLayout().setDividerDrawable(drawable);
            getItemLayout().setShowDividers(2);
        }
        addView(getItemLayout());
        int i10 = this.itemCount;
        for (int i11 = 0; i11 < i10; i11++) {
            TextView textView = new TextView(getContext());
            textView.setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2));
            textView.setGravity(17);
            textView.setFocusable(false);
            textView.setBackground(this.itemBackgroundNormal);
            if (dimensionPixelSize3 != -1) {
                textView.setTextSize(0, dimensionPixelSize3);
            }
            if (color != -1) {
                textView.setTextColor(color);
            }
            getItemLayout().addView(textView);
        }
        setFocusItem(getEditText().length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinearLayout itemLayout_delegate$lambda$2(VerifyEditText verifyEditText) {
        LinearLayout linearLayout = new LinearLayout(verifyEditText.getContext());
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFocusItem(int index) {
        TextView itemView = getItemView(index);
        if (itemView != null) {
            Drawable drawable = this.itemBackgroundFocus;
            if (drawable == null) {
                drawable = this.itemBackgroundNormal;
            }
            itemView.setBackground(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSoftKeyBoard() {
        InputMethodManager inputMethodManager;
        getEditText().setFocusable(true);
        getEditText().setFocusableInTouchMode(true);
        getEditText().requestFocus();
        Object systemService = getContext().getSystemService("input_method");
        if (systemService instanceof InputMethodManager) {
            inputMethodManager = (InputMethodManager) systemService;
        } else {
            inputMethodManager = null;
        }
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(getEditText(), 0);
        }
    }

    public final void clearContent() {
        getEditText().setText("");
    }

    @NotNull
    public final String getContent() {
        Editable text = getEditText().getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        return StringsKt.trim(text).toString();
    }

    @NotNull
    public final EditText getEditText() {
        return (EditText) this.editText.getValue();
    }

    /* renamed from: getInputMaxLength, reason: from getter */
    public final int getItemCount() {
        return this.itemCount;
    }

    @Override // com.oudi.utils.log.ILog
    @NotNull
    public String getLogTag() {
        return ILog.DefaultImpls.getLogTag(this);
    }

    @Nullable
    public final Function1<String, Unit> getOnInputListener() {
        return this.onInputListener;
    }

    public final void hideKeyBoard() {
        Object systemService = AppUtils.getApp().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(getEditText().getWindowToken(), 0);
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

    public final void setContent(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        getEditText().setText(StringsKt.trim((CharSequence) content).toString());
        getEditText().setSelection(getEditText().length());
        getEditText().requestFocus();
    }

    public final void setOnInputListener(@Nullable Function1<? super String, Unit> function1) {
        this.onInputListener = function1;
    }

    public final void showKeyBoard() {
        getEditText().postDelayed(new Runnable() { // from class: com.oudi.widget.v
            @Override // java.lang.Runnable
            public final void run() {
                VerifyEditText.this.showSoftKeyBoard();
            }
        }, 300L);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VerifyEditText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, th, str2, z10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VerifyEditText(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
        ILog.DefaultImpls.logE(this, th, str, z10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerifyEditText(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.editText = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                EditText editText_delegate$lambda$0;
                editText_delegate$lambda$0 = VerifyEditText.editText_delegate$lambda$0(VerifyEditText.this);
                return editText_delegate$lambda$0;
            }
        });
        this.itemLayout = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                LinearLayout itemLayout_delegate$lambda$2;
                itemLayout_delegate$lambda$2 = VerifyEditText.itemLayout_delegate$lambda$2(VerifyEditText.this);
                return itemLayout_delegate$lambda$2;
            }
        });
        this.itemCount = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VerifyEditText);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.itemCount = obtainStyledAttributes.getInt(R.styleable.VerifyEditText_vet_item_count, this.itemCount);
        this.itemBackgroundNormal = obtainStyledAttributes.getDrawable(R.styleable.VerifyEditText_vet_item_background_normal);
        this.itemBackgroundSelector = obtainStyledAttributes.getDrawable(R.styleable.VerifyEditText_vet_item_background_selected);
        this.itemBackgroundFocus = obtainStyledAttributes.getDrawable(R.styleable.VerifyEditText_vet_item_background_focus);
        initEditText(obtainStyledAttributes);
        initItemView(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
