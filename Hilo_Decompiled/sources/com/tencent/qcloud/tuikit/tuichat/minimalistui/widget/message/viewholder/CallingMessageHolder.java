package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CallingMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class CallingMessageHolder extends TextMessageHolder {
    public CallingMessageHolder(View view) {
        super(view);
    }

    private void appendIcon(boolean z, SpannableStringBuilder spannableStringBuilder, int i) {
        if (z) {
            ImageSpan imageSpan = new ImageSpan(((RecyclerView.ViewHolder) this).itemView.getContext(), i);
            spannableStringBuilder.insert(0, "iconA");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(0), 4, 5, 33);
            spannableStringBuilder.setSpan(imageSpan, 0, 4, 33);
            return;
        }
        ImageSpan imageSpan2 = new ImageSpan(((RecyclerView.ViewHolder) this).itemView.getContext(), i);
        spannableStringBuilder.append("Aicon");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(0), spannableStringBuilder.length() - 5, spannableStringBuilder.length() - 4, 33);
        spannableStringBuilder.setSpan(imageSpan2, spannableStringBuilder.length() - 4, spannableStringBuilder.length(), 33);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.TextMessageHolder, com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(final TUIMessageBean tUIMessageBean, final int i) {
        super.layoutVariableViews(tUIMessageBean, i);
        if (!(tUIMessageBean instanceof CallingMessageBean)) {
            return;
        }
        final CallingMessageBean callingMessageBean = (CallingMessageBean) tUIMessageBean;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.timeInLineTextLayout.getTextView().getText());
        int i2 = R.drawable.ic_audio_call;
        if (tUIMessageBean.isSelf()) {
            if (callingMessageBean.getCallType() != 1 && callingMessageBean.getCallType() == 2) {
                i2 = R.drawable.ic_self_video_call;
            }
            appendIcon(false, spannableStringBuilder, i2);
            this.timeInLineTextLayout.setText(spannableStringBuilder);
        } else {
            if (callingMessageBean.getCallType() != 1 && callingMessageBean.getCallType() == 2) {
                i2 = R.drawable.ic_other_video_call;
            }
            appendIcon(true, spannableStringBuilder, i2);
            this.timeInLineTextLayout.setText(spannableStringBuilder);
        }
        if (callingMessageBean.getCallType() != 1 && callingMessageBean.getCallType() != 2) {
            this.timeInLineTextLayout.getTextView().setOnLongClickListener(null);
            this.timeInLineTextLayout.getTextView().setOnClickListener(null);
        } else {
            this.timeInLineTextLayout.getTextView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.CallingMessageHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OnItemClickListener onItemClickListener = CallingMessageHolder.this.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onRecallClick(view, i, tUIMessageBean);
                    }
                }
            });
            this.timeInLineTextLayout.getTextView().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.CallingMessageHolder.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    CallingMessageHolder callingMessageHolder = CallingMessageHolder.this;
                    OnItemClickListener onItemClickListener = callingMessageHolder.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onMessageLongClick(callingMessageHolder.msgArea, i, callingMessageBean);
                        return true;
                    }
                    return true;
                }
            });
        }
    }
}
