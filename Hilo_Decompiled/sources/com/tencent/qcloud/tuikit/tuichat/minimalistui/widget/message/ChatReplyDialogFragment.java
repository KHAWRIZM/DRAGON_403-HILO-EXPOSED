package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageRepliesBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IReplyMessageHandler;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.MinimalistUIService;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.reply.ReplyDetailsView;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageViewHolderFactory;
import com.tencent.qcloud.tuikit.tuichat.presenter.ReplyPresenter;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ChatReplyDialogFragment extends DialogFragment implements IReplyMessageHandler {
    private View cancelBtn;
    private ChatInfo chatInfo;
    private BottomSheetDialog dialog;
    private FrameLayout messageContent;
    private TUIMessageBean originMessage;
    private ReplyPresenter presenter;
    private ReplyDetailsView repliesList;
    private TextView title;

    /* JADX WARN: Multi-variable type inference failed */
    private void initData() {
        if (this.originMessage != null) {
            this.messageContent.removeAllViews();
            RecyclerView.ViewHolder messageViewHolderFactory = MessageViewHolderFactory.getInstance(this.messageContent, null, MinimalistUIService.getInstance().getViewType(this.originMessage.getClass()));
            if (messageViewHolderFactory instanceof MessageBaseHolder) {
                MessageContentHolder messageContentHolder = (MessageContentHolder) messageViewHolderFactory;
                messageContentHolder.isMessageDetailMode = true;
                messageContentHolder.setTranslationContent(this.originMessage, 0);
                ((MessageBaseHolder) messageViewHolderFactory).layoutViews(this.originMessage, 0);
            }
            this.messageContent.addView(messageViewHolderFactory.itemView);
            ReplyPresenter replyPresenter = new ReplyPresenter();
            this.presenter = replyPresenter;
            replyPresenter.setMessageId(this.originMessage.getId());
            this.presenter.setChatInfo(this.chatInfo);
            this.presenter.setChatEventListener();
            this.presenter.setReplyHandler(this);
            MessageRepliesBean messageRepliesBean = this.originMessage.getMessageRepliesBean();
            if (messageRepliesBean != null) {
                this.presenter.findReplyMessages(messageRepliesBean);
                this.title.setText(getResources().getString(R.string.chat_reply_num, Integer.valueOf(messageRepliesBean.getRepliesSize())));
            }
            this.cancelBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.ChatReplyDialogFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ChatReplyDialogFragment.this.dismiss();
                }
            });
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext(), R.style.ChatPopActivityStyle);
        this.dialog = bottomSheetDialog;
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        BottomSheetBehavior behavior = this.dialog.getBehavior();
        behavior.S0(false);
        behavior.U0(0.45f);
        behavior.c1(true);
        behavior.R0(ScreenUtil.dip2px(36.0f));
        behavior.c(3);
        return this.dialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.originMessage == null) {
            return super/*androidx.fragment.app.Fragment*/.onCreateView(layoutInflater, viewGroup, bundle);
        }
        View inflate = layoutInflater.inflate(R.layout.chat_reply_dialog_layout, viewGroup);
        this.cancelBtn = inflate.findViewById(R.id.cancel_btn);
        this.title = (TextView) inflate.findViewById(R.id.title);
        this.messageContent = (FrameLayout) inflate.findViewById(R.id.message_content);
        this.repliesList = (ReplyDetailsView) inflate.findViewById(R.id.replies_list);
        initData();
        return inflate;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.IReplyMessageHandler
    public void onRepliesMessageFound(Map<MessageRepliesBean.ReplyBean, TUIMessageBean> map) {
        ReplyDetailsView replyDetailsView = this.repliesList;
        if (replyDetailsView != null) {
            replyDetailsView.setData(map);
        }
    }

    public void setChatInfo(ChatInfo chatInfo) {
        this.chatInfo = chatInfo;
    }

    public void setOriginMessage(TUIMessageBean tUIMessageBean) {
        this.originMessage = tUIMessageBean;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.IReplyMessageHandler
    public void updateData(TUIMessageBean tUIMessageBean) {
        this.originMessage = tUIMessageBean;
        if (!isAdded()) {
            return;
        }
        initData();
    }
}
