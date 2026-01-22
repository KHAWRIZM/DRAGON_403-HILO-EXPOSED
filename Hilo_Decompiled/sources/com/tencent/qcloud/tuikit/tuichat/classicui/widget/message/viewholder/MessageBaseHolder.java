package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.ShapeUtil;
import com.tencent.qcloud.tuicore.util.DateTimeUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.MessageProperties;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.ICommonMessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.ChatFlowReactView;
import com.tencent.qcloud.tuikit.tuichat.hilo.dialog.IMMessageClickBottomDialog;
import com.tencent.qcloud.tuikit.tuichat.hilo.dialog.IMMessageListener;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IMCheckDataListener;
import java.util.Date;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class MessageBaseHolder extends RecyclerView.ViewHolder {
    public static final int MSG_TYPE_HEADER_VIEW = -99;
    public TextView chatTimeText;
    private ValueAnimator highLightAnimator;
    public ICommonMessageAdapter mAdapter;
    public RelativeLayout mContentLayout;
    public String mGroupID;
    public CheckBox mMutiSelectCheckBox;
    public LinearLayout msgArea;
    public LinearLayout msgAreaAndReply;
    public FrameLayout msgContentFrame;
    public LinearLayout msgReplyDetailLayout;
    protected OnItemClickListener onItemClickListener;
    protected IMCheckDataListener onItemDateListener;
    public MessageProperties properties;
    public ChatFlowReactView reactView;
    public RelativeLayout rightGroupLayout;

    public MessageBaseHolder(View view) {
        super(view);
        this.properties = MessageProperties.getInstance();
        this.mGroupID = "";
        this.chatTimeText = (TextView) view.findViewById(R.id.message_top_time_tv);
        this.msgContentFrame = (FrameLayout) view.findViewById(R.id.msg_content_fl);
        this.msgReplyDetailLayout = (LinearLayout) view.findViewById(R.id.msg_reply_detail_fl);
        this.reactView = (ChatFlowReactView) view.findViewById(R.id.reacts_view);
        this.msgArea = (LinearLayout) view.findViewById(R.id.msg_area);
        this.msgAreaAndReply = (LinearLayout) view.findViewById(R.id.msg_area_and_reply);
        this.mMutiSelectCheckBox = (CheckBox) view.findViewById(R.id.select_checkbox);
        this.rightGroupLayout = (RelativeLayout) view.findViewById(R.id.right_group_layout);
        this.mContentLayout = (RelativeLayout) view.findViewById(R.id.message_content_layout);
        initVariableLayout();
    }

    private void initVariableLayout() {
        if (getVariableLayout() != 0) {
            setVariableLayout(getVariableLayout());
        }
        if (getBindingLayout() != null && this.msgContentFrame.getChildCount() == 0) {
            this.msgContentFrame.addView(getBindingLayout());
        }
    }

    private void setVariableLayout(int i) {
        if (this.msgContentFrame.getChildCount() == 0) {
            View.inflate(((RecyclerView.ViewHolder) this).itemView.getContext(), i, this.msgContentFrame);
        }
    }

    public boolean checkIsStrangeGroup() {
        boolean z;
        IMCheckDataListener iMCheckDataListener = this.onItemDateListener;
        if (iMCheckDataListener != null) {
            z = iMCheckDataListener.checkBoolean("isStrangeGroup");
        } else {
            z = false;
        }
        if (TextUtils.isEmpty(this.mGroupID) || !z) {
            return false;
        }
        return true;
    }

    public boolean checkStrange() {
        boolean z;
        IMCheckDataListener iMCheckDataListener = this.onItemDateListener;
        if (iMCheckDataListener != null) {
            z = iMCheckDataListener.checkBoolean("isStrange");
        } else {
            z = false;
        }
        if (TextUtils.isEmpty(this.mGroupID) || !z) {
            return false;
        }
        return true;
    }

    public void clearHighLightBackground() {
        Drawable background = this.msgArea.getBackground();
        if (background != null) {
            background.setColorFilter(null);
        }
    }

    public View getBindingLayout() {
        return null;
    }

    public OnItemClickListener getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public IMCheckDataListener getOnItemDateListener() {
        return this.onItemDateListener;
    }

    public abstract int getVariableLayout();

    public void layoutViews(TUIMessageBean tUIMessageBean, int i) {
        if (!TextUtils.isEmpty(tUIMessageBean.getGroupId())) {
            this.mGroupID = tUIMessageBean.getGroupId();
        }
        if (this.chatTimeText == null) {
            return;
        }
        if (this.properties.getChatTimeBubble() != null) {
            this.chatTimeText.setBackground(this.properties.getChatTimeBubble());
        }
        if (checkStrange()) {
            this.chatTimeText.setBackground(ShapeUtil.INSTANCE.createShape("#2B2839", "#2B2839", 11, GradientDrawable.Orientation.LEFT_RIGHT));
            this.chatTimeText.setIncludeFontPadding(true);
            this.chatTimeText.setPadding(18, 2, 18, 4);
        } else {
            this.chatTimeText.setBackground(null);
            this.chatTimeText.setIncludeFontPadding(false);
            this.chatTimeText.setPadding(0, 0, 0, 0);
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

    public void setHighLightBackground(int i) {
        Drawable background = this.msgArea.getBackground();
        if (background != null) {
            background.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemDateListener(IMCheckDataListener iMCheckDataListener) {
        this.onItemDateListener = iMCheckDataListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showDialog(final TUIMessageBean tUIMessageBean, final int i, final View view, boolean z, boolean z2, boolean z3) {
        boolean z4;
        try {
            AppController appController = AppController.INSTANCE;
            if (appController.getService() == null) {
                return;
            }
            AppService service = appController.getService();
            Objects.requireNonNull(service);
            boolean z5 = false;
            if (service.getServerTime() - tUIMessageBean.getMessageTime() < 120) {
                z4 = true;
            } else {
                z4 = false;
            }
            BaseActivity activity = HiloUtils.INSTANCE.getActivity(((RecyclerView.ViewHolder) this).itemView.getContext());
            if (activity != null && !activity.isFinishing()) {
                IMMessageClickBottomDialog iMMessageClickBottomDialog = new IMMessageClickBottomDialog(activity);
                iMMessageClickBottomDialog.setMShowCopy(z);
                iMMessageClickBottomDialog.setMShowDelete(z2);
                if (z3 && z4) {
                    z5 = true;
                }
                iMMessageClickBottomDialog.setMShowRevocation(z5);
                iMMessageClickBottomDialog.setClickListener(new IMMessageListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder.3
                    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.dialog.IMMessageListener
                    public void copy() {
                        OnItemClickListener onItemClickListener = MessageBaseHolder.this.onItemClickListener;
                        if (onItemClickListener != null) {
                            onItemClickListener.onTypeClick(view, i, tUIMessageBean, 1);
                        }
                    }

                    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.dialog.IMMessageListener
                    public void delete() {
                        OnItemClickListener onItemClickListener = MessageBaseHolder.this.onItemClickListener;
                        if (onItemClickListener != null) {
                            onItemClickListener.onTypeClick(view, i, tUIMessageBean, 2);
                        }
                    }

                    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.dialog.IMMessageListener
                    public void revocation() {
                        OnItemClickListener onItemClickListener = MessageBaseHolder.this.onItemClickListener;
                        if (onItemClickListener != null) {
                            onItemClickListener.onTypeClick(view, i, tUIMessageBean, 7);
                        }
                    }
                });
                iMMessageClickBottomDialog.show();
            }
        } catch (Exception e) {
            n5.e.b(e.getMessage());
        }
    }

    public void startHighLight() {
        int color = ((RecyclerView.ViewHolder) this).itemView.getResources().getColor(R.color.chat_message_bubble_high_light_dark_color);
        int color2 = ((RecyclerView.ViewHolder) this).itemView.getResources().getColor(R.color.chat_message_bubble_high_light_light_color);
        if (this.highLightAnimator == null) {
            ArgbEvaluator argbEvaluator = new ArgbEvaluator();
            ValueAnimator valueAnimator = new ValueAnimator();
            this.highLightAnimator = valueAnimator;
            valueAnimator.setIntValues(color, color2);
            this.highLightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    MessageBaseHolder.this.setHighLightBackground(((Integer) valueAnimator2.getAnimatedValue()).intValue());
                }
            });
            this.highLightAnimator.addListener(new Animator.AnimatorListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder.2
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
