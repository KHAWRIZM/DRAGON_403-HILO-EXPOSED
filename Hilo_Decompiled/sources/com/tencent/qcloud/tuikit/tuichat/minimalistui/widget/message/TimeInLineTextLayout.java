package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.qcloud.tuikit.tuichat.R;
import tech.sud.gip.core.view.round.RoundedDrawable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TimeInLineTextLayout extends FrameLayout {
    private MessageStatusTimeView statusArea;
    private TextView textView;

    public TimeInLineTextLayout(Context context) {
        super(context);
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TextView textView = new TextView(context, null, R.style.ChatMinimalistMessageTextStyle);
        this.textView = textView;
        textView.setTextColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        TextView textView2 = this.textView;
        textView2.setTextSize(0, textView2.getResources().getDimension(R.dimen.chat_minimalist_message_text_size));
        addView(this.textView, new FrameLayout.LayoutParams(-2, -2));
        this.statusArea = new MessageStatusTimeView(context);
        addView(this.statusArea, new FrameLayout.LayoutParams(-2, -2));
    }

    public TextView getTextView() {
        return this.textView;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.textView.layout(0, 0, this.textView.getMeasuredWidth(), this.textView.getMeasuredHeight());
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.statusArea.layout(i5 - this.statusArea.getMeasuredWidth(), i6 - this.statusArea.getMeasuredHeight(), i5, i6);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int max;
        int max2;
        measureChildren(i, i2);
        int measuredWidth = this.textView.getMeasuredWidth();
        int measuredHeight = this.textView.getMeasuredHeight();
        int lineCount = this.textView.getLineCount();
        Layout layout = this.textView.getLayout();
        if (layout != null) {
            int i4 = lineCount - 1;
            int lineStart = layout.getLineStart(i4);
            i3 = (int) (layout.getSecondaryHorizontal(layout.getLineEnd(i4)) - layout.getPrimaryHorizontal(lineStart));
        } else {
            i3 = 0;
        }
        int measuredWidth2 = this.statusArea.getMeasuredWidth();
        int measuredHeight2 = this.statusArea.getMeasuredHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.statusArea.getLayoutParams();
        int i5 = measuredWidth2 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        int i6 = i3 + i5;
        if (i6 > View.MeasureSpec.getSize(i)) {
            max = measuredHeight + measuredHeight2;
            max2 = Math.max(measuredWidth, i5);
        } else {
            max = Math.max(measuredHeight, measuredHeight2);
            max2 = Math.max(measuredWidth, i6);
        }
        setMeasuredDimension(max2, max);
    }

    public void setOnStatusAreaClickListener(View.OnClickListener onClickListener) {
        this.statusArea.setOnClickListener(onClickListener);
    }

    public void setOnStatusAreaLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.statusArea.setOnLongClickListener(onLongClickListener);
    }

    public void setStatusIcon(int i) {
        this.statusArea.setStatusIcon(i);
    }

    public void setText(CharSequence charSequence) {
        this.textView.setText(charSequence);
    }

    public void setTextColor(int i) {
        this.textView.setTextColor(i);
    }

    public void setTextSize(int i) {
        this.textView.setTextSize(i);
    }

    public void setTimeColor(int i) {
        this.statusArea.setTimeColor(i);
    }

    public void setTimeText(CharSequence charSequence) {
        this.statusArea.setTimeText(charSequence);
    }

    public void setText(int i) {
        this.textView.setText(i);
    }

    public TimeInLineTextLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public TimeInLineTextLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
