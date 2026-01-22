package com.oudi.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class ClearEditText extends AppCompatEditText implements View.OnTouchListener, View.OnFocusChangeListener, TextWatcher {
    private Drawable mClearTextIcon;
    private View.OnFocusChangeListener mOnFocusChangeListener;
    private View.OnTouchListener mOnTouchListener;
    private String mSuffixText;
    private OnTextWatcherLinstener mTextWatcherLinstener;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface OnTextWatcherLinstener {
        void onTextChanged(CharSequence charSequence, int i10, int i11, int i12);
    }

    public ClearEditText(Context context) {
        super(context);
        init(context, null, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClearEditText, i10, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ClearEditText_cet_clear_drawable);
        if (drawable == null) {
            drawable = getResources().getDrawable(R.drawable.base_ic_input_clear);
        }
        this.mClearTextIcon = drawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicHeight(), this.mClearTextIcon.getIntrinsicHeight());
        setClearIconVisible(false);
        setSuffixText(obtainStyledAttributes.getText(R.styleable.ClearEditText_cet_suffix_text));
        super.setOnTouchListener(this);
        super.setOnFocusChangeListener(this);
        addTextChangedListener(this);
        obtainStyledAttributes.recycle();
    }

    private void setClearIconVisible(boolean z10) {
        Drawable drawable;
        this.mClearTextIcon.setVisible(z10, false);
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable drawable2 = compoundDrawables[0];
        Drawable drawable3 = compoundDrawables[1];
        if (z10) {
            drawable = this.mClearTextIcon;
        } else {
            drawable = null;
        }
        setCompoundDrawables(drawable2, drawable3, drawable, compoundDrawables[3]);
    }

    private void setSuffixText(boolean z10) {
        String obj = getSuperText().toString();
        if (TextUtils.isEmpty(this.mSuffixText)) {
            return;
        }
        removeTextChangedListener(this);
        if (z10) {
            if (!obj.isEmpty() && obj.endsWith(this.mSuffixText)) {
                setText(obj.substring(0, obj.length() - this.mSuffixText.length()));
            }
        } else if (!obj.isEmpty() && !obj.endsWith(this.mSuffixText)) {
            setText(obj + this.mSuffixText);
        }
        addTextChangedListener(this);
    }

    private void updateSuffixSelection() {
        final int length;
        Editable superText = getSuperText();
        if (!TextUtils.isEmpty(this.mSuffixText) && superText.toString().endsWith(this.mSuffixText) && (length = superText.length() - this.mSuffixText.length()) >= 0 && length < superText.length()) {
            post(new Runnable() { // from class: com.oudi.widget.ClearEditText.1
                @Override // java.lang.Runnable
                public void run() {
                    ClearEditText.this.setSelection(length);
                }
            });
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public String getRealText() {
        String obj = getSuperText().toString();
        if (!TextUtils.isEmpty(this.mSuffixText) && !obj.isEmpty() && obj.endsWith(this.mSuffixText)) {
            return obj.substring(0, obj.length() - this.mSuffixText.length());
        }
        return obj;
    }

    public Editable getSuperText() {
        return super.getText();
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        boolean z11 = false;
        if (z10) {
            updateSuffixSelection();
            if (getText().length() > 0) {
                z11 = true;
            }
            setClearIconVisible(z11);
        } else {
            setClearIconVisible(false);
        }
        View.OnFocusChangeListener onFocusChangeListener = this.mOnFocusChangeListener;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(view, z10);
        }
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int i10, int i11) {
        int length;
        super.onSelectionChanged(i10, i11);
        if (!TextUtils.isEmpty(this.mSuffixText)) {
            String obj = getSuperText().toString();
            if (obj.endsWith(this.mSuffixText) && i10 > (length = obj.length() - this.mSuffixText.length())) {
                setSelection(length);
            }
        }
    }

    @Override // android.widget.TextView, android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        boolean z10;
        OnTextWatcherLinstener onTextWatcherLinstener = this.mTextWatcherLinstener;
        if (onTextWatcherLinstener != null) {
            onTextWatcherLinstener.onTextChanged(charSequence, i10, i11, i12);
        }
        if (isFocused()) {
            if (charSequence.length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            setClearIconVisible(z10);
        }
        if (!TextUtils.isEmpty(this.mSuffixText)) {
            removeTextChangedListener(this);
            if (charSequence.toString().equals(this.mSuffixText)) {
                setText("");
            } else if (!charSequence.toString().isEmpty() && !charSequence.toString().endsWith(this.mSuffixText)) {
                setText(((Object) charSequence) + this.mSuffixText);
            }
            addTextChangedListener(this);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        if (this.mClearTextIcon.isVisible() && x10 > (getWidth() - getPaddingRight()) - this.mClearTextIcon.getIntrinsicWidth()) {
            if (motionEvent.getAction() == 1) {
                setError(null);
                setText("");
            }
            return true;
        }
        View.OnTouchListener onTouchListener = this.mOnTouchListener;
        if (onTouchListener != null && onTouchListener.onTouch(view, motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.mOnFocusChangeListener = onFocusChangeListener;
    }

    public void setOnTextWatcherLinstener(OnTextWatcherLinstener onTextWatcherLinstener) {
        this.mTextWatcherLinstener = onTextWatcherLinstener;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.mOnTouchListener = onTouchListener;
    }

    public void setText(String str) {
        super.setText((CharSequence) str);
    }

    public ClearEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0);
    }

    public ClearEditText(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init(context, attributeSet, i10);
    }

    public void setSuffixText(CharSequence charSequence) {
        if (charSequence != null) {
            this.mSuffixText = charSequence.toString();
        } else {
            this.mSuffixText = null;
        }
    }
}
