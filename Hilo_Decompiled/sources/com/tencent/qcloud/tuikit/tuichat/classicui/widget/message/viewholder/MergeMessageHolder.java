package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MergeMessageHolder extends MessageContentHolder {
    private LinearLayout mForwardMsgLayout;
    private TextView msgForwardContent;
    private TextView msgForwardTitle;

    public MergeMessageHolder(View view) {
        super(view);
        this.mForwardMsgLayout = (LinearLayout) view.findViewById(R.id.forward_msg_layout);
        this.msgForwardTitle = (TextView) view.findViewById(R.id.msg_forward_title);
        this.msgForwardContent = (TextView) view.findViewById(R.id.msg_forward_content);
        this.mForwardMsgLayout.setClickable(true);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.forward_msg_holder;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.ChatFlowReactView] */
    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(final TUIMessageBean tUIMessageBean, final int i) {
        if (tUIMessageBean == null) {
            return;
        }
        ?? r0 = this.reactView;
        r0.setThemeColorId(TUIThemeManager.getAttrResId(r0.getContext(), R.attr.chat_react_other_text_color));
        if (!this.isForwardMode && !this.isReplyDetailMode) {
            if (tUIMessageBean.isSelf()) {
                if (this.properties.getRightBubble() != null && this.properties.getRightBubble().getConstantState() != null) {
                    this.msgArea.setBackground(this.properties.getRightBubble().getConstantState().newDrawable());
                } else {
                    this.msgArea.setBackgroundResource(R.drawable.chat_bubble_self_cavity_bg);
                }
            } else if (this.properties.getLeftBubble() != null && this.properties.getLeftBubble().getConstantState() != null) {
                this.msgArea.setBackground(this.properties.getLeftBubble().getConstantState().newDrawable());
            } else {
                this.msgArea.setBackgroundResource(R.drawable.chat_bubble_other_cavity_bg);
            }
        } else {
            this.msgArea.setBackgroundResource(R.drawable.chat_bubble_other_cavity_bg);
            this.statusImage.setVisibility(8);
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
            this.mForwardMsgLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MergeMessageHolder.1
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
        this.mForwardMsgLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MergeMessageHolder.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                OnItemClickListener onItemClickListener = MergeMessageHolder.this.onItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onMessageLongClick(view, i, tUIMessageBean);
                    return true;
                }
                return true;
            }
        });
        this.mForwardMsgLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MergeMessageHolder.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(TUIChatConstants.FORWARD_MERGE_MESSAGE_KEY, tUIMessageBean);
                bundle.putSerializable(TUIChatConstants.CHAT_INFO, MergeMessageHolder.this.presenter.getChatInfo());
                TUICore.startActivity("TUIForwardChatActivity", bundle);
            }
        });
        setMessageAreaPadding();
    }
}
