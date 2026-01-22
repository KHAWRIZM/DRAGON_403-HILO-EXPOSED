package com.tencent.qcloud.tuicore.component.popupcard;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.util.SoftKeyBoardUtil;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class PopupInputCard {
    private View closeBtn;
    private TextView descriptionTv;
    private EditText editText;
    private String notMachRuleTip;
    private PopupWindow popupWindow;
    private Button positiveBtn;
    private OnClickListener positiveOnClickListener;
    private String rule;
    private OnTextExceedListener textExceedListener;
    private TextView titleTv;
    private int minLimit = 0;
    private int maxLimit = Integer.MAX_VALUE;
    private ByteLengthFilter lengthFilter = new ByteLengthFilter();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    class ByteLengthFilter implements InputFilter {
        private int length = Integer.MAX_VALUE;

        public ByteLengthFilter() {
        }

        private CharSequence getSource(CharSequence charSequence, int i, int i2) {
            int length = charSequence.length();
            int i3 = 0;
            for (int i4 = 1; i4 <= length && charSequence.subSequence(0, i4).toString().getBytes().length <= i2; i4++) {
                i3 = i4;
            }
            if (i3 > 0 && Character.isHighSurrogate(charSequence.charAt(i3 - 1)) && i3 - 1 == i) {
                return "";
            }
            return charSequence.subSequence(i, i3);
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int i5;
            int i6;
            int i7 = 0;
            if (!TextUtils.isEmpty(spanned)) {
                i6 = spanned.toString().getBytes().length;
                i5 = spanned.subSequence(i3, i4).toString().getBytes().length;
            } else {
                i5 = 0;
                i6 = 0;
            }
            if (!TextUtils.isEmpty(charSequence)) {
                i7 = charSequence.subSequence(i, i2).toString().getBytes().length;
            }
            int i8 = this.length - (i6 - i5);
            if (i8 <= 0) {
                if (PopupInputCard.this.textExceedListener != null) {
                    PopupInputCard.this.textExceedListener.onTextExceedMax();
                    return "";
                }
                return "";
            }
            if (i8 >= i7) {
                return null;
            }
            if (PopupInputCard.this.textExceedListener != null) {
                PopupInputCard.this.textExceedListener.onTextExceedMax();
            }
            return getSource(charSequence, i, i8);
        }

        public void setLength(int i) {
            this.length = i;
        }
    }

    @FunctionalInterface
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnClickListener {
        void onClick(String str);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnTextExceedListener {
        void onTextExceedMax();
    }

    public PopupInputCard(final Activity activity) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.layout_popup_card, (ViewGroup) null);
        this.titleTv = (TextView) inflate.findViewById(R.id.popup_card_title);
        this.editText = (EditText) inflate.findViewById(R.id.popup_card_edit);
        this.descriptionTv = (TextView) inflate.findViewById(R.id.popup_card_description);
        this.positiveBtn = (Button) inflate.findViewById(R.id.popup_card_positive_btn);
        this.closeBtn = inflate.findViewById(R.id.close_btn);
        PopupWindow popupWindow = new PopupWindow(inflate, -1, -2, true) { // from class: com.tencent.qcloud.tuicore.component.popupcard.PopupInputCard.1
            @Override // android.widget.PopupWindow
            public void dismiss() {
                Activity activity2 = activity;
                if (activity2 != null && !activity2.isFinishing()) {
                    PopupInputCard.this.startAnimation(activity.getWindow(), false);
                }
                super.dismiss();
            }

            @Override // android.widget.PopupWindow
            public void showAtLocation(View view, int i, int i2, int i3) {
                Activity activity2 = activity;
                if (activity2 != null && !activity2.isFinishing()) {
                    PopupInputCard.this.startAnimation(activity.getWindow(), true);
                }
                PopupInputCard.this.editText.requestFocus();
                if (activity.getWindow() != null) {
                    SoftKeyBoardUtil.showKeyBoard(activity.getWindow());
                }
                super.showAtLocation(view, i, i2, i3);
            }
        };
        this.popupWindow = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        this.popupWindow.setTouchable(true);
        this.popupWindow.setOutsideTouchable(false);
        this.popupWindow.setAnimationStyle(R.style.PopupInputCardAnim);
        this.popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.qcloud.tuicore.component.popupcard.PopupInputCard.2
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (activity.getWindow() != null) {
                    SoftKeyBoardUtil.hideKeyBoard(activity.getWindow());
                }
            }
        });
        this.positiveBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuicore.component.popupcard.PopupInputCard.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String obj = PopupInputCard.this.editText.getText().toString();
                if (obj.length() >= PopupInputCard.this.minLimit && obj.length() <= PopupInputCard.this.maxLimit) {
                    if (!TextUtils.isEmpty(PopupInputCard.this.rule) && !Pattern.matches(PopupInputCard.this.rule, obj)) {
                        ToastUtil.toastShortMessage(PopupInputCard.this.notMachRuleTip);
                        return;
                    }
                    if (PopupInputCard.this.positiveOnClickListener != null) {
                        PopupInputCard.this.positiveOnClickListener.onClick(PopupInputCard.this.editText.getText().toString());
                    }
                    PopupInputCard.this.popupWindow.dismiss();
                    return;
                }
                ToastUtil.toastShortMessage(PopupInputCard.this.notMachRuleTip);
            }
        });
        this.closeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuicore.component.popupcard.PopupInputCard.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PopupInputCard.this.popupWindow.dismiss();
            }
        });
        this.editText.setFilters(new InputFilter[]{this.lengthFilter});
        this.editText.addTextChangedListener(new TextWatcher() { // from class: com.tencent.qcloud.tuicore.component.popupcard.PopupInputCard.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!TextUtils.isEmpty(PopupInputCard.this.rule)) {
                    if (!Pattern.matches(PopupInputCard.this.rule, editable.toString())) {
                        PopupInputCard.this.positiveBtn.setEnabled(false);
                    } else {
                        PopupInputCard.this.positiveBtn.setEnabled(true);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnimation(final Window window, boolean z) {
        ValueAnimator ofFloat;
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        if (z) {
            ofFloat = ValueAnimator.ofFloat(1.0f, 0.5f);
        } else {
            ofFloat = ValueAnimator.ofFloat(0.5f, 1.0f);
        }
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qcloud.tuicore.component.popupcard.PopupInputCard.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.alpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                window.setAttributes(attributes);
            }
        });
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(linearInterpolator);
        ofFloat.start();
    }

    public void setContent(String str) {
        this.editText.setText(str);
    }

    public void setDescription(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.descriptionTv.setVisibility(0);
            this.descriptionTv.setText(str);
        }
    }

    public void setMaxLimit(int i) {
        this.maxLimit = i;
        this.lengthFilter.setLength(i);
    }

    public void setMinLimit(int i) {
        this.minLimit = i;
    }

    public void setNotMachRuleTip(String str) {
        this.notMachRuleTip = str;
    }

    public void setOnPositive(OnClickListener onClickListener) {
        this.positiveOnClickListener = onClickListener;
    }

    public void setRule(String str) {
        if (TextUtils.isEmpty(str)) {
            this.rule = "";
        } else {
            this.rule = str;
        }
    }

    public void setSingleLine(boolean z) {
        this.editText.setSingleLine(z);
    }

    public void setTextExceedListener(OnTextExceedListener onTextExceedListener) {
        this.textExceedListener = onTextExceedListener;
    }

    public void setTitle(String str) {
        this.titleTv.setText(str);
    }

    public void show(View view, int i) {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.showAtLocation(view, i, 0, 0);
        }
    }
}
