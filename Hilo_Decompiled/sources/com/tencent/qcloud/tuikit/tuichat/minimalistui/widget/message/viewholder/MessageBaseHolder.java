package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.support.BaseControlUtils;
import com.tencent.qcloud.tuicore.util.DateTimeUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.component.MessageProperties;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.ICommonMessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.reply.ChatReactView;
import java.util.Date;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class MessageBaseHolder extends RecyclerView.ViewHolder {
    public static final int MSG_TYPE_HEADER_VIEW = -99;
    public TextView chatTimeText;
    protected boolean floatMode;
    private ValueAnimator highLightAnimator;
    protected boolean isShowStart;
    public ICommonMessageAdapter mAdapter;
    public View mContentLayout;
    public String mGroupID;
    public CheckBox mMutiSelectCheckBox;
    public LinearLayout msgArea;
    public LinearLayout msgAreaAndReply;
    public FrameLayout msgContentFrame;
    public LinearLayout msgReplyDetailLayout;
    protected OnItemClickListener onItemClickListener;
    public MessageProperties properties;
    public ChatReactView reactView;

    public MessageBaseHolder(View view) {
        super(view);
        this.properties = MessageProperties.getInstance();
        this.mGroupID = "";
        this.floatMode = false;
        this.isShowStart = true;
        this.msgContentFrame = (FrameLayout) view.findViewById(R.id.msg_content_fl);
        this.msgReplyDetailLayout = (LinearLayout) view.findViewById(R.id.msg_reply_detail_fl);
        this.reactView = (ChatReactView) view.findViewById(R.id.reacts_view);
        this.msgArea = (LinearLayout) view.findViewById(R.id.msg_area);
        this.msgAreaAndReply = (LinearLayout) view.findViewById(R.id.msg_area_and_reply);
        this.mMutiSelectCheckBox = (CheckBox) view.findViewById(R.id.select_checkbox);
        this.chatTimeText = (TextView) view.findViewById(R.id.message_top_time_tv);
        this.mContentLayout = view.findViewById(R.id.message_content_layout);
        initVariableLayout();
    }

    private void initVariableLayout() {
        if (getVariableLayout() != 0) {
            setVariableLayout(getVariableLayout());
        }
    }

    private void setVariableLayout(int i) {
        if (this.msgContentFrame.getChildCount() == 0) {
            View.inflate(((RecyclerView.ViewHolder) this).itemView.getContext(), i, this.msgContentFrame);
        }
    }

    public boolean checkStrange() {
        if (!TextUtils.isEmpty(this.mGroupID) && BaseControlUtils.INSTANCE.checkStrangerGroupFromService(this.mGroupID)) {
            return true;
        }
        return false;
    }

    public void clearHighLightBackground() {
        Drawable background = this.msgArea.getBackground();
        if (background != null) {
            background.setColorFilter(null);
        }
    }

    public OnItemClickListener getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public abstract int getVariableLayout();

    public void layoutViews(TUIMessageBean tUIMessageBean, int i) {
        if (!TextUtils.isEmpty(tUIMessageBean.getGroupId())) {
            this.mGroupID = tUIMessageBean.getGroupId();
        }
        if (this.properties.getChatTimeBubble() != null) {
            this.chatTimeText.setBackground(this.properties.getChatTimeBubble());
        }
        if (this.properties.getChatTimeFontColor() != 0) {
            this.chatTimeText.setTextColor(this.properties.getChatTimeFontColor());
        }
        if (this.properties.getChatTimeFontSize() != 0) {
            this.chatTimeText.setTextSize(this.properties.getChatTimeFontSize());
        }
        if (i > 1) {
            TUIMessageBean item = this.mAdapter.getItem(i - 1);
            if (item != null) {
                if (tUIMessageBean.getMessageTime() - item.getMessageTime() >= 300) {
                    this.chatTimeText.setVisibility(0);
                    this.chatTimeText.setText(DateTimeUtil.getTimeFormatText(new Date(tUIMessageBean.getMessageTime() * 1000)));
                    return;
                } else {
                    this.chatTimeText.setVisibility(8);
                    return;
                }
            }
            return;
        }
        this.chatTimeText.setVisibility(0);
        this.chatTimeText.setText(DateTimeUtil.getTimeFormatText(new Date(tUIMessageBean.getMessageTime() * 1000)));
    }

    public void setAdapter(ICommonMessageAdapter iCommonMessageAdapter) {
        this.mAdapter = iCommonMessageAdapter;
    }

    public void setFloatMode(boolean z) {
        this.floatMode = z;
    }

    public void setHighLightBackground(int i) {
        Drawable background = this.msgArea.getBackground();
        if (background != null) {
            background.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void startHighLight() {
        int color = ((RecyclerView.ViewHolder) this).itemView.getResources().getColor(R.color.chat_message_bubble_high_light_dark_color);
        int color2 = ((RecyclerView.ViewHolder) this).itemView.getResources().getColor(R.color.chat_message_bubble_high_light_light_color);
        if (this.highLightAnimator == null) {
            ArgbEvaluator argbEvaluator = new ArgbEvaluator();
            ValueAnimator valueAnimator = new ValueAnimator();
            this.highLightAnimator = valueAnimator;
            valueAnimator.setIntValues(color, color2);
            this.highLightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    MessageBaseHolder.this.setHighLightBackground(((Integer) valueAnimator2.getAnimatedValue()).intValue());
                }
            });
            this.highLightAnimator.addListener(new Animator.AnimatorListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    MessageBaseHolder.this.clearHighLightBackground();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    MessageBaseHolder.this.clearHighLightBackground();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            this.highLightAnimator.setEvaluator(argbEvaluator);
            this.highLightAnimator.setRepeatCount(3);
            this.highLightAnimator.setDuration(250L);
            this.highLightAnimator.setRepeatMode(2);
        }
        this.highLightAnimator.start();
    }

    public void stopHighLight() {
        ValueAnimator valueAnimator = this.highLightAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        clearHighLightBackground();
    }
}
