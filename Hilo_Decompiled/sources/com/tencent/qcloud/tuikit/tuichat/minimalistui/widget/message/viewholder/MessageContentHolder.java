package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuicore.util.DateTimeUtil;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageReactBean;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageRepliesBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.ICommonMessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.page.MessageDetailMinimalistActivity;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MinimalistMessageLayout;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.TimeInLineTextLayout;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.reply.ReplyPreviewView;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class MessageContentHolder extends MessageBaseHolder {
    protected static final int READ_STATUS_ALL_READ = 3;
    protected static final int READ_STATUS_HIDE = 4;
    protected static final int READ_STATUS_PART_READ = 2;
    protected static final int READ_STATUS_SENDING = 5;
    protected static final int READ_STATUS_UNREAD = 1;
    public LinearLayout extraInfoArea;
    public ImageView fileStatusImage;
    public boolean isForwardMode;
    public boolean isMessageDetailMode;
    public boolean isMultiSelectMode;
    public boolean isOptimize;
    public boolean isShowSelfAvatar;
    public UserIconView leftUserIcon;
    private List<TUIMessageBean> mDataSource;
    public TextView messageDetailsTimeTv;
    public ImageView messageStatusImage;
    public LinearLayout msgContentLinear;
    protected ChatPresenter presenter;
    protected ReplyPreviewView replyPreviewView;
    public UserIconView rightUserIcon;
    protected MinimalistMessageLayout rootLayout;
    protected TimeInLineTextLayout timeInLineTextLayout;
    private FrameLayout translationContentFrameLayout;
    private ImageView translationLoadingImage;
    private LinearLayout translationResultLayout;
    private RotateAnimation translationRotateAnimation;
    public TextView usernameText;

    public MessageContentHolder(View view) {
        super(view);
        this.isForwardMode = false;
        this.isMessageDetailMode = false;
        this.isMultiSelectMode = false;
        this.isOptimize = true;
        this.isShowSelfAvatar = false;
        this.mDataSource = new ArrayList();
        this.rootLayout = (MinimalistMessageLayout) view;
        this.leftUserIcon = (UserIconView) view.findViewById(R.id.left_user_icon_view);
        this.rightUserIcon = (UserIconView) view.findViewById(R.id.right_user_icon_view);
        this.usernameText = (TextView) view.findViewById(R.id.user_name_tv);
        this.msgContentLinear = (LinearLayout) view.findViewById(R.id.msg_content_ll);
        this.messageStatusImage = (ImageView) view.findViewById(R.id.message_status_iv);
        this.fileStatusImage = (ImageView) view.findViewById(R.id.file_status_iv);
        this.messageDetailsTimeTv = (TextView) view.findViewById(R.id.msg_detail_time_tv);
        this.replyPreviewView = (ReplyPreviewView) view.findViewById(R.id.msg_reply_preview);
        this.extraInfoArea = (LinearLayout) view.findViewById(R.id.extra_info_area);
        this.translationContentFrameLayout = (FrameLayout) view.findViewById(R.id.translate_content_fl);
        LayoutInflater.from(view.getContext()).inflate(R.layout.translation_contant_layout, this.translationContentFrameLayout);
        this.translationLoadingImage = (ImageView) this.translationContentFrameLayout.findViewById(R.id.translate_loading_iv);
        this.translationResultLayout = (LinearLayout) this.translationContentFrameLayout.findViewById(R.id.translate_result_ll);
    }

    private void loadAvatar(TUIMessageBean tUIMessageBean) {
        if (!TextUtils.isEmpty(tUIMessageBean.getFaceUrl())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(tUIMessageBean.getFaceUrl());
            if (!this.isForwardMode && !this.isMessageDetailMode) {
                if (tUIMessageBean.isSelf()) {
                    this.rightUserIcon.setIconUrls(arrayList);
                } else {
                    this.leftUserIcon.setIconUrls(arrayList);
                }
            } else {
                this.leftUserIcon.setIconUrls(arrayList);
            }
        } else {
            this.rightUserIcon.setIconUrls(null);
            this.leftUserIcon.setIconUrls(null);
        }
        if (this.isShowSelfAvatar) {
            this.rightUserIcon.setVisibility(0);
        } else {
            this.rightUserIcon.setVisibility(8);
        }
    }

    private void optimizeAvatarAndPadding(int i, TUIMessageBean tUIMessageBean) {
        boolean z;
        ICommonMessageAdapter iCommonMessageAdapter = this.mAdapter;
        if (iCommonMessageAdapter != null && !this.isMessageDetailMode && this.isOptimize) {
            boolean z2 = true;
            TUIMessageBean item = iCommonMessageAdapter.getItem(i + 1);
            if (item != null && TextUtils.equals(tUIMessageBean.getSender(), item.getSender())) {
                if (item.getMessageTime() - tUIMessageBean.getMessageTime() >= 300) {
                    z = true;
                } else {
                    z = false;
                }
                if (!(item instanceof TipsMessageBean) && item.getStatus() != 275 && !z) {
                    z2 = false;
                }
            }
            boolean z3 = tUIMessageBean instanceof MergeMessageBean;
            int dip2px = ScreenUtil.dip2px(16.0f);
            int dip2px2 = ScreenUtil.dip2px(25.0f);
            if (z2) {
                if (this.isShowStart) {
                    this.leftUserIcon.setVisibility(0);
                    this.rightUserIcon.setVisibility(4);
                    if (!z3) {
                        this.msgArea.setBackgroundResource(R.drawable.chat_message_popup_stroke_border_left);
                    }
                } else {
                    this.leftUserIcon.setVisibility(4);
                    this.rightUserIcon.setVisibility(0);
                    if (!z3) {
                        this.msgArea.setBackgroundResource(R.drawable.chat_message_popup_fill_border_right);
                    }
                }
            } else {
                if (!z3) {
                    if (this.isShowStart) {
                        this.msgArea.setBackgroundResource(R.drawable.chat_message_popup_stroke_border);
                    } else {
                        this.msgArea.setBackgroundResource(R.drawable.chat_message_popup_fill_border);
                    }
                }
                dip2px = ScreenUtil.dip2px(16.0f);
                dip2px2 = ScreenUtil.dip2px(2.0f);
                this.leftUserIcon.setVisibility(4);
                this.rightUserIcon.setVisibility(4);
            }
            this.rootLayout.setPadding(dip2px, 0, dip2px, dip2px2);
            optimizeMessageContent(z2);
        }
    }

    private void processReadStatus(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean.isGroup()) {
            if (tUIMessageBean.isAllRead()) {
                setReadStatus(3);
                return;
            } else if (tUIMessageBean.isUnread()) {
                setReadStatus(1);
                return;
            } else {
                if (tUIMessageBean.getReadCount() > 0) {
                    setReadStatus(2);
                    return;
                }
                return;
            }
        }
        if (tUIMessageBean.isPeerRead()) {
            setReadStatus(3);
        } else {
            setReadStatus(1);
        }
    }

    private void setMessageGravity(TUIMessageBean tUIMessageBean) {
        if (!this.isForwardMode && !this.isMessageDetailMode) {
            if (tUIMessageBean.isSelf()) {
                this.msgContentLinear.setGravity(8388613);
                this.leftUserIcon.setVisibility(8);
                this.rightUserIcon.setVisibility(0);
                this.extraInfoArea.setGravity(8388613);
            } else {
                this.msgContentLinear.setGravity(8388611);
                this.leftUserIcon.setVisibility(0);
                this.rightUserIcon.setVisibility(8);
                this.extraInfoArea.setGravity(8388611);
            }
        } else {
            this.leftUserIcon.setVisibility(0);
            this.rightUserIcon.setVisibility(8);
        }
        if (this.properties.getAvatar() != 0) {
            this.leftUserIcon.setDefaultImageResId(this.properties.getAvatar());
            this.rightUserIcon.setDefaultImageResId(this.properties.getAvatar());
        } else {
            UserIconView userIconView = this.leftUserIcon;
            Context context = userIconView.getContext();
            int i = com.tencent.qcloud.tuicore.R.attr.core_default_user_icon;
            userIconView.setDefaultImageResId(TUIThemeManager.getAttrResId(context, i));
            UserIconView userIconView2 = this.rightUserIcon;
            userIconView2.setDefaultImageResId(TUIThemeManager.getAttrResId(userIconView2.getContext(), i));
        }
        if (this.properties.getAvatarRadius() != 0) {
            this.leftUserIcon.setRadius(this.properties.getAvatarRadius());
            this.rightUserIcon.setRadius(this.properties.getAvatarRadius());
        } else {
            int dip2px = ScreenUtil.dip2px(4.0f);
            this.leftUserIcon.setRadius(dip2px);
            this.rightUserIcon.setRadius(dip2px);
        }
        if (this.properties.getAvatarSize() != null && this.properties.getAvatarSize().length == 2) {
            ViewGroup.LayoutParams layoutParams = this.leftUserIcon.getLayoutParams();
            layoutParams.width = this.properties.getAvatarSize()[0];
            layoutParams.height = this.properties.getAvatarSize()[1];
            this.leftUserIcon.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.rightUserIcon.getLayoutParams();
            layoutParams2.width = this.properties.getAvatarSize()[0];
            layoutParams2.height = this.properties.getAvatarSize()[1];
            this.rightUserIcon.setLayoutParams(layoutParams2);
        }
    }

    private void setReactContent(final TUIMessageBean tUIMessageBean) {
        MessageReactBean messageReactBean = tUIMessageBean.getMessageReactBean();
        if (messageReactBean != null && messageReactBean.getReactSize() > 0) {
            this.reactView.setVisibility(0);
            this.reactView.setData(messageReactBean);
            this.reactView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder.9
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    MessageContentHolder messageContentHolder = MessageContentHolder.this;
                    OnItemClickListener onItemClickListener = messageContentHolder.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onMessageLongClick(messageContentHolder.msgArea, 0, tUIMessageBean);
                        return true;
                    }
                    return true;
                }
            });
            this.reactView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OnItemClickListener onItemClickListener = MessageContentHolder.this.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onReactOnClick(null, tUIMessageBean);
                    }
                }
            });
            if (this.isForwardMode) {
                this.reactView.setOnLongClickListener(null);
                return;
            }
            return;
        }
        this.reactView.setVisibility(8);
        this.reactView.setOnLongClickListener(null);
    }

    private void setReplyContent(final TUIMessageBean tUIMessageBean) {
        MessageRepliesBean messageRepliesBean = tUIMessageBean.getMessageRepliesBean();
        if (messageRepliesBean != null && messageRepliesBean.getRepliesSize() > 0) {
            this.extraInfoArea.setVisibility(0);
            this.replyPreviewView.setVisibility(0);
            this.replyPreviewView.setMessageRepliesBean(messageRepliesBean);
            this.replyPreviewView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OnItemClickListener onItemClickListener = MessageContentHolder.this.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onReplyDetailClick(tUIMessageBean);
                    }
                }
            });
            return;
        }
        this.replyPreviewView.setVisibility(8);
    }

    private void setShowReadStatusClickListener(final TUIMessageBean tUIMessageBean) {
        if (this.timeInLineTextLayout != null) {
            if (tUIMessageBean.isSelf()) {
                this.timeInLineTextLayout.setOnStatusAreaClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageContentHolder.this.showMessageDetail(tUIMessageBean);
                    }
                });
            } else {
                this.timeInLineTextLayout.setOnStatusAreaClickListener(null);
            }
            this.timeInLineTextLayout.setOnStatusAreaLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder.12
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    MessageContentHolder messageContentHolder = MessageContentHolder.this;
                    OnItemClickListener onItemClickListener = messageContentHolder.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onMessageLongClick(messageContentHolder.msgArea, 0, tUIMessageBean);
                        return true;
                    }
                    return true;
                }
            });
            this.timeInLineTextLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder.13
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    MessageContentHolder messageContentHolder = MessageContentHolder.this;
                    OnItemClickListener onItemClickListener = messageContentHolder.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onMessageLongClick(messageContentHolder.msgArea, 0, tUIMessageBean);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    private void setTimeInLineStatus(TUIMessageBean tUIMessageBean) {
        if (TUIChatConfigs.getConfigs().getGeneralConfig().isShowRead()) {
            if (tUIMessageBean.isSelf()) {
                if (2 == tUIMessageBean.getStatus()) {
                    if (!tUIMessageBean.isNeedReadReceipt()) {
                        setReadStatus(4);
                        return;
                    } else {
                        processReadStatus(tUIMessageBean);
                        return;
                    }
                }
                if (1 == tUIMessageBean.getStatus()) {
                    setReadStatus(5);
                    return;
                } else {
                    setReadStatus(4);
                    return;
                }
            }
            setReadStatus(4);
        }
    }

    private void startTranslationLoading() {
        this.translationLoadingImage.setVisibility(0);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.translationRotateAnimation = rotateAnimation;
        rotateAnimation.setRepeatCount(-1);
        this.translationRotateAnimation.setDuration(1000L);
        this.translationRotateAnimation.setInterpolator(new LinearInterpolator());
        this.translationLoadingImage.startAnimation(this.translationRotateAnimation);
    }

    private void stopTranslationLoading() {
        this.translationLoadingImage.clearAnimation();
        this.translationLoadingImage.setVisibility(8);
    }

    public List<TUIMessageBean> getDataSource() {
        return this.mDataSource;
    }

    public abstract void layoutVariableViews(TUIMessageBean tUIMessageBean, int i);

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(final TUIMessageBean tUIMessageBean, final int i) {
        super.layoutViews(tUIMessageBean, i);
        if (!this.isForwardMode && !this.isMessageDetailMode) {
            if (tUIMessageBean.isSelf()) {
                this.isShowStart = false;
            } else {
                this.isShowStart = true;
            }
        } else {
            this.isShowStart = true;
        }
        setMessageGravity(tUIMessageBean);
        if (!this.isForwardMode && !this.isMessageDetailMode) {
            if (tUIMessageBean.isSelf()) {
                if (this.properties.getRightNameVisibility() == 0) {
                    this.usernameText.setVisibility(8);
                } else {
                    this.usernameText.setVisibility(this.properties.getRightNameVisibility());
                }
            } else if (this.properties.getLeftNameVisibility() == 0) {
                if (tUIMessageBean.isGroup()) {
                    this.usernameText.setVisibility(8);
                } else {
                    this.usernameText.setVisibility(8);
                }
            } else {
                this.usernameText.setVisibility(this.properties.getLeftNameVisibility());
            }
        } else {
            this.usernameText.setVisibility(8);
        }
        if (this.properties.getNameFontColor() != 0) {
            this.usernameText.setTextColor(this.properties.getNameFontColor());
        }
        if (this.properties.getNameFontSize() != 0) {
            this.usernameText.setTextSize(this.properties.getNameFontSize());
        }
        if (!TextUtils.isEmpty(tUIMessageBean.getNameCard())) {
            this.usernameText.setText(tUIMessageBean.getNameCard());
        } else if (!TextUtils.isEmpty(tUIMessageBean.getFriendRemark())) {
            this.usernameText.setText(tUIMessageBean.getFriendRemark());
        } else if (!TextUtils.isEmpty(tUIMessageBean.getNickName())) {
            this.usernameText.setText(tUIMessageBean.getNickName());
        } else {
            this.usernameText.setText(tUIMessageBean.getSender());
        }
        if (!this.isForwardMode && !this.isMessageDetailMode) {
            if (tUIMessageBean.isSelf()) {
                if (this.properties.getRightBubble() != null && this.properties.getRightBubble().getConstantState() != null) {
                    this.msgArea.setBackground(this.properties.getRightBubble().getConstantState().newDrawable());
                } else {
                    this.msgArea.setBackgroundResource(R.drawable.chat_message_popup_fill_border_right);
                }
            } else if (this.properties.getLeftBubble() != null && this.properties.getLeftBubble().getConstantState() != null) {
                this.msgArea.setBackground(this.properties.getLeftBubble().getConstantState().newDrawable());
            } else {
                this.msgArea.setBackgroundResource(R.drawable.chat_message_popup_stroke_border_left);
            }
            if (this.onItemClickListener != null) {
                this.msgContentFrame.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder.1
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        MessageContentHolder messageContentHolder = MessageContentHolder.this;
                        messageContentHolder.onItemClickListener.onMessageLongClick(messageContentHolder.msgArea, i, tUIMessageBean);
                        return true;
                    }
                });
                this.msgArea.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder.2
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        MessageContentHolder messageContentHolder = MessageContentHolder.this;
                        messageContentHolder.onItemClickListener.onMessageLongClick(messageContentHolder.msgArea, i, tUIMessageBean);
                        return true;
                    }
                });
                this.leftUserIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageContentHolder.this.onItemClickListener.onUserIconClick(view, i, tUIMessageBean);
                    }
                });
                this.leftUserIcon.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder.4
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        MessageContentHolder.this.onItemClickListener.onUserIconLongClick(view, i, tUIMessageBean);
                        return true;
                    }
                });
                this.rightUserIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageContentHolder.this.onItemClickListener.onUserIconClick(view, i, tUIMessageBean);
                    }
                });
            }
            if (tUIMessageBean.getStatus() == 3) {
                this.messageStatusImage.setVisibility(0);
                this.messageStatusImage.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageContentHolder messageContentHolder = MessageContentHolder.this;
                        OnItemClickListener onItemClickListener = messageContentHolder.onItemClickListener;
                        if (onItemClickListener != null) {
                            onItemClickListener.onSendFailBtnClick(messageContentHolder.messageStatusImage, i, tUIMessageBean);
                        }
                    }
                });
            } else {
                this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageContentHolder messageContentHolder = MessageContentHolder.this;
                        OnItemClickListener onItemClickListener = messageContentHolder.onItemClickListener;
                        if (onItemClickListener != null) {
                            onItemClickListener.onMessageClick(messageContentHolder.msgContentFrame, i, tUIMessageBean);
                        }
                    }
                });
                this.messageStatusImage.setVisibility(8);
            }
        } else {
            this.msgArea.setBackgroundResource(R.drawable.chat_message_popup_stroke_border_left);
            this.messageStatusImage.setVisibility(8);
        }
        if (!this.isForwardMode && !this.isMessageDetailMode) {
            if (tUIMessageBean.isSelf()) {
                this.msgContentLinear.removeView(this.msgAreaAndReply);
                this.msgContentLinear.addView(this.msgAreaAndReply);
            } else {
                this.msgContentLinear.removeView(this.msgAreaAndReply);
                this.msgContentLinear.addView(this.msgAreaAndReply, 0);
            }
        } else {
            this.rootLayout.setIsStart(true);
            this.msgContentLinear.removeView(this.msgAreaAndReply);
            this.msgContentLinear.addView(this.msgAreaAndReply);
        }
        setGravity(this.isShowStart);
        this.rootLayout.setIsStart(this.isShowStart);
        this.msgContentLinear.setVisibility(0);
        if (!this.isForwardMode && !this.isMessageDetailMode) {
            setTimeInLineStatus(tUIMessageBean);
            setShowReadStatusClickListener(tUIMessageBean);
        }
        TimeInLineTextLayout timeInLineTextLayout = this.timeInLineTextLayout;
        if (timeInLineTextLayout != null) {
            timeInLineTextLayout.setTimeText(DateTimeUtil.getHMTimeString(new Date(tUIMessageBean.getMessageTime() * 1000)));
        }
        this.extraInfoArea.setVisibility(8);
        setReplyContent(tUIMessageBean);
        setReactContent(tUIMessageBean);
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null && chatPresenter.isNeedShowTranslation()) {
            setTranslationContent(tUIMessageBean, i);
        }
        setMessageAreaPadding();
        if (this.floatMode) {
            ((RecyclerView.ViewHolder) this).itemView.setPadding(0, 0, 0, 0);
            this.leftUserIcon.setVisibility(8);
            this.rightUserIcon.setVisibility(8);
            this.usernameText.setVisibility(8);
            this.messageStatusImage.setVisibility(8);
            this.replyPreviewView.setVisibility(8);
            this.reactView.setVisibility(8);
            this.chatTimeText.setVisibility(8);
        }
        if (this.isMessageDetailMode) {
            this.replyPreviewView.setVisibility(8);
        }
        optimizeAvatarAndPadding(i, tUIMessageBean);
        loadAvatar(tUIMessageBean);
        layoutVariableViews(tUIMessageBean, i);
    }

    public void onRecycled() {
    }

    protected void optimizeMessageContent(boolean z) {
    }

    public void setDataSource(List<TUIMessageBean> list) {
        if (list == null || list.isEmpty()) {
            this.mDataSource = null;
        }
        ArrayList arrayList = new ArrayList();
        for (TUIMessageBean tUIMessageBean : list) {
            int msgType = tUIMessageBean.getMsgType();
            if (msgType == 3 || msgType == 5) {
                arrayList.add(tUIMessageBean);
            }
        }
        this.mDataSource = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setGravity(boolean z) {
        int i;
        if (z) {
            i = 8388611;
        } else {
            i = 8388613;
        }
        this.msgAreaAndReply.setGravity(i);
        ViewGroup.LayoutParams layoutParams = this.msgContentFrame.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).gravity = i;
        }
        this.msgContentFrame.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMessageAreaPadding() {
        int dimensionPixelSize = ((RecyclerView.ViewHolder) this).itemView.getResources().getDimensionPixelSize(R.dimen.chat_minimalist_message_area_padding_left_right);
        int dimensionPixelSize2 = ((RecyclerView.ViewHolder) this).itemView.getResources().getDimensionPixelSize(R.dimen.chat_minimalist_message_area_padding_top_bottom);
        this.msgArea.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
    }

    public void setPresenter(ChatPresenter chatPresenter) {
        this.presenter = chatPresenter;
    }

    protected void setReadStatus(int i) {
        int i2;
        TimeInLineTextLayout timeInLineTextLayout = this.timeInLineTextLayout;
        if (timeInLineTextLayout != null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 5) {
                            i2 = 0;
                        } else {
                            i2 = R.drawable.chat_minimalist_status_loading_anim;
                        }
                    } else {
                        i2 = R.drawable.chat_minimalist_message_status_send_all_read;
                    }
                } else {
                    i2 = R.drawable.chat_minimalist_message_status_send_part_read;
                }
            } else {
                i2 = R.drawable.chat_minimalist_message_status_send_no_read;
            }
            timeInLineTextLayout.setStatusIcon(i2);
        }
    }

    public void setTranslationContent(final TUIMessageBean tUIMessageBean, final int i) {
        int translationStatus = tUIMessageBean.getTranslationStatus();
        if (translationStatus == 3) {
            this.extraInfoArea.setVisibility(0);
            this.translationContentFrameLayout.setVisibility(0);
            stopTranslationLoading();
            this.translationResultLayout.setVisibility(0);
            TextView textView = (TextView) this.translationContentFrameLayout.findViewById(R.id.translate_tv);
            textView.setTextSize(0, textView.getResources().getDimension(R.dimen.chat_minimalist_message_text_size));
            if (this.properties.getChatContextFontSize() != 0) {
                textView.setTextSize(this.properties.getChatContextFontSize());
            }
            FaceManager.handlerEmojiText(textView, tUIMessageBean.getTranslation(), false);
            this.translationContentFrameLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder.14
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    OnItemClickListener onItemClickListener = MessageContentHolder.this.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onTranslationLongClick(view, i, tUIMessageBean);
                        return true;
                    }
                    return true;
                }
            });
            return;
        }
        if (translationStatus == 2) {
            this.extraInfoArea.setVisibility(0);
            this.translationContentFrameLayout.setVisibility(0);
            startTranslationLoading();
            this.translationResultLayout.setVisibility(8);
            this.translationContentFrameLayout.setOnLongClickListener(null);
            return;
        }
        stopTranslationLoading();
        this.translationContentFrameLayout.setVisibility(8);
        this.translationContentFrameLayout.setOnLongClickListener(null);
    }

    public void showMessageDetail(TUIMessageBean tUIMessageBean) {
        if (this.presenter != null) {
            Intent intent = new Intent(((RecyclerView.ViewHolder) this).itemView.getContext(), (Class<?>) MessageDetailMinimalistActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("messageBean", tUIMessageBean);
            intent.putExtra(TUIChatConstants.CHAT_INFO, this.presenter.getChatInfo());
            ((RecyclerView.ViewHolder) this).itemView.getContext().startActivity(intent);
        }
    }
}
