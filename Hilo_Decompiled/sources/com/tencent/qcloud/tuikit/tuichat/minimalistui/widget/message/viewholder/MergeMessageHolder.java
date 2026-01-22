package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.page.TUIForwardChatMinimalistActivity;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.TimeInLineTextLayout;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MergeMessageHolder extends MessageContentHolder {
    private View mForwardMsgLayout;
    private TextView msgForwardContent;
    private TextView msgForwardTitle;

    public MergeMessageHolder(View view) {
        super(view);
        this.mForwardMsgLayout = view.findViewById(R.id.forward_msg_layout);
        this.msgForwardTitle = (TextView) view.findViewById(R.id.msg_forward_title);
        this.msgForwardContent = (TextView) view.findViewById(R.id.msg_forward_content);
        this.timeInLineTextLayout = (TimeInLineTextLayout) view.findViewById(R.id.merge_msg_time_in_line_text);
        this.mForwardMsgLayout.setClickable(true);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.minimalist_forward_msg_holder;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(final TUIMessageBean tUIMessageBean, final int i) {
        if (tUIMessageBean == null) {
            return;
        }
        this.msgArea.setBackgroundResource(R.drawable.chat_minimalist_merge_message_border);
        if (!this.isForwardMode && !this.isMessageDetailMode) {
            if (tUIMessageBean.isSelf()) {
                if (this.properties.getRightBubble() != null && this.properties.getRightBubble().getConstantState() != null) {
                    this.msgArea.setBackground(this.properties.getRightBubble().getConstantState().newDrawable());
                }
            } else if (this.properties.getLeftBubble() != null && this.properties.getLeftBubble().getConstantState() != null) {
                this.msgArea.setBackground(this.properties.getLeftBubble().getConstantState().newDrawable());
            }
        }
        final MergeMessageBean mergeMessageBean = (MergeMessageBean) tUIMessageBean;
        String title = mergeMessageBean.getTitle();
        List<String> abstractList = mergeMessageBean.getAbstractList();
        this.msgForwardTitle.setText(title);
        String str = "";
        for (int i2 = 0; i2 < abstractList.size(); i2++) {
            if (i2 > 0) {
                str = str + "\n";
            }
            str = str + abstractList.get(i2);
        }
        this.msgForwardContent.setText(FaceManager.emojiJudge(str));
        if (this.isMultiSelectMode) {
            this.mForwardMsgLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MergeMessageHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OnItemClickListener onItemClickListener = MergeMessageHolder.this.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onMessageClick(view, i, mergeMessageBean);
                    }
                }
            });
            return;
        }
        if (!this.isMessageDetailMode) {
            this.mForwardMsgLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MergeMessageHolder.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    MergeMessageHolder mergeMessageHolder = MergeMessageHolder.this;
                    OnItemClickListener onItemClickListener = mergeMessageHolder.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onMessageLongClick(mergeMessageHolder.msgArea, i, tUIMessageBean);
                        return true;
                    }
                    return true;
                }
            });
            this.mForwardMsgLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MergeMessageHolder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ChatPresenter chatPresenter = MergeMessageHolder.this.presenter;
                    if (chatPresenter != null && chatPresenter.getChatInfo() != null) {
                        Intent intent = new Intent(view.getContext(), (Class<?>) TUIForwardChatMinimalistActivity.class);
                        intent.putExtra(TUIChatConstants.FORWARD_MERGE_MESSAGE_KEY, tUIMessageBean);
                        intent.putExtra(TUIChatConstants.CHAT_INFO, MergeMessageHolder.this.presenter.getChatInfo());
                        intent.addFlags(268435456);
                        view.getContext().startActivity(intent);
                    }
                }
            });
        }
        setMessageAreaPadding();
    }
}
