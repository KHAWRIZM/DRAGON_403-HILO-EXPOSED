package com.tencent.qcloud.tuikit.tuichat.minimalistui.page;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import com.tencent.qcloud.tuicore.component.activities.BaseMinimalistLightActivity;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupMemberInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageReceiptInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.GroupMessageReadMembersInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.MinimalistUIService;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageViewHolderFactory;
import com.tencent.qcloud.tuikit.tuichat.presenter.MessageReceiptPresenter;
import com.tencent.qcloud.tuikit.tuichat.presenter.ReplyPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageDetailMinimalistActivity extends BaseMinimalistLightActivity {
    private static final String TAG = "MessageDetailMinimalistActivity";
    private ChatInfo chatInfo;
    private FrameLayout messageArea;
    private TUIMessageBean messageBean;
    private MessageReceiptPresenter presenter;
    private MemberAdapter readAdapter;
    private RecyclerView readList;
    private long readNextSeq;
    private View readStatusArea;
    private View readTitle;
    private ReplyPresenter replyPresenter;
    private MemberAdapter unreadAdapter;
    private RecyclerView unreadList;
    private long unreadNextSeq;
    private View unreadtitle;
    private final List<GroupMemberInfo> readMemberList = new ArrayList();
    private final List<GroupMemberInfo> unreadMemberList = new ArrayList();
    private boolean readFinished = false;
    private boolean unreadFinished = false;
    private boolean readLoading = false;
    private boolean unreadLoading = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class MemberAdapter extends RecyclerView.Adapter<MemberViewHolder> {
        private List<GroupMemberInfo> data;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public static class MemberViewHolder extends RecyclerView.ViewHolder {
            private final ImageView face;
            private final TextView name;

            public MemberViewHolder(View view) {
                super(view);
                this.face = (ImageView) view.findViewById(R.id.avatar_img);
                this.name = (TextView) view.findViewById(R.id.name_tv);
            }
        }

        MemberAdapter() {
        }

        private String getDisplayName(GroupMemberInfo groupMemberInfo) {
            if (!TextUtils.isEmpty(groupMemberInfo.getNameCard())) {
                return groupMemberInfo.getNameCard();
            }
            if (!TextUtils.isEmpty(groupMemberInfo.getFriendRemark())) {
                return groupMemberInfo.getFriendRemark();
            }
            if (!TextUtils.isEmpty(groupMemberInfo.getNickName())) {
                return groupMemberInfo.getNickName();
            }
            return groupMemberInfo.getAccount();
        }

        public int getItemCount() {
            List<GroupMemberInfo> list = this.data;
            if (list != null && !list.isEmpty()) {
                return this.data.size();
            }
            return 0;
        }

        public void setData(List<GroupMemberInfo> list) {
            this.data = list;
        }

        public void onBindViewHolder(MemberViewHolder memberViewHolder, int i) {
            final GroupMemberInfo groupMemberInfo = this.data.get(i);
            GlideEngine.loadUserIcon(memberViewHolder.face, groupMemberInfo.getIconUrl());
            memberViewHolder.name.setText(getDisplayName(groupMemberInfo));
            ((RecyclerView.ViewHolder) memberViewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.MessageDetailMinimalistActivity.MemberAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString("chatId", groupMemberInfo.getAccount());
                    TUICore.startActivity("FriendProfileMinimalistActivity", bundle);
                }
            });
        }

        public MemberViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new MemberViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_minimalist_group_receipt_member_item, viewGroup, false));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initData() {
        Intent intent = getIntent();
        this.messageBean = (TUIMessageBean) intent.getSerializableExtra("messageBean");
        this.chatInfo = (ChatInfo) intent.getSerializableExtra(TUIChatConstants.CHAT_INFO);
        MessageReceiptPresenter messageReceiptPresenter = new MessageReceiptPresenter();
        this.presenter = messageReceiptPresenter;
        messageReceiptPresenter.setChatInfo(this.chatInfo);
        this.presenter.setMessageReplyBean(this.messageBean, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.MessageDetailMinimalistActivity.2
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                MessageDetailMinimalistActivity.this.setMessageAndReceiptDetail();
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r1) {
                MessageDetailMinimalistActivity.this.setMessageAndReceiptDetail();
            }
        });
    }

    private void initView() {
        this.messageArea = (FrameLayout) findViewById(R.id.message_area);
        this.readStatusArea = findViewById(R.id.read_status_area);
        this.readList = findViewById(R.id.read_list);
        this.unreadList = findViewById(R.id.unread_list);
        this.unreadtitle = findViewById(R.id.unread_title);
        this.readTitle = findViewById(R.id.read_title);
        findViewById(R.id.back_btn_area).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.MessageDetailMinimalistActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageDetailMinimalistActivity.this.onBackPressed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadGroupMessageReadMembers(long j) {
        if (this.readLoading) {
            return;
        }
        this.readLoading = true;
        this.presenter.getGroupMessageReadMembers(this.messageBean, true, j, new IUIKitCallback<GroupMessageReadMembersInfo>() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.MessageDetailMinimalistActivity.6
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                MessageDetailMinimalistActivity.this.readLoading = false;
                TUIChatLog.e(MessageDetailMinimalistActivity.TAG, "errCode " + i + " errMsg " + str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(GroupMessageReadMembersInfo groupMessageReadMembersInfo) {
                MessageDetailMinimalistActivity.this.readNextSeq = groupMessageReadMembersInfo.getNextSeq();
                MessageDetailMinimalistActivity.this.readFinished = groupMessageReadMembersInfo.isFinished();
                MessageDetailMinimalistActivity.this.readMemberList.addAll(groupMessageReadMembersInfo.getGroupMemberInfoList());
                MessageDetailMinimalistActivity.this.readAdapter.setData(MessageDetailMinimalistActivity.this.readMemberList);
                MessageDetailMinimalistActivity.this.readAdapter.notifyDataSetChanged();
                MessageDetailMinimalistActivity.this.readLoading = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadGroupMessageUnreadMembers(long j) {
        if (this.unreadLoading) {
            return;
        }
        this.unreadLoading = true;
        this.presenter.getGroupMessageReadMembers(this.messageBean, false, j, new IUIKitCallback<GroupMessageReadMembersInfo>() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.MessageDetailMinimalistActivity.7
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                MessageDetailMinimalistActivity.this.unreadLoading = false;
                TUIChatLog.e(MessageDetailMinimalistActivity.TAG, "errCode " + i + " errMsg " + str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(GroupMessageReadMembersInfo groupMessageReadMembersInfo) {
                MessageDetailMinimalistActivity.this.unreadNextSeq = groupMessageReadMembersInfo.getNextSeq();
                MessageDetailMinimalistActivity.this.unreadFinished = groupMessageReadMembersInfo.isFinished();
                MessageDetailMinimalistActivity.this.unreadMemberList.addAll(groupMessageReadMembersInfo.getGroupMemberInfoList());
                MessageDetailMinimalistActivity.this.unreadAdapter.setData(MessageDetailMinimalistActivity.this.unreadMemberList);
                MessageDetailMinimalistActivity.this.unreadAdapter.notifyDataSetChanged();
                MessageDetailMinimalistActivity.this.unreadLoading = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void setMessageAndReceiptDetail() {
        setMsgAbstract();
        if (!this.messageBean.isSelf()) {
            this.readStatusArea.setVisibility(8);
            return;
        }
        this.readAdapter = new MemberAdapter();
        this.unreadAdapter = new MemberAdapter();
        this.readList.setLayoutManager(new CustomLinearLayoutManager(this));
        this.unreadList.setLayoutManager(new CustomLinearLayoutManager(this));
        this.readList.setAdapter(this.readAdapter);
        this.unreadList.setAdapter(this.unreadAdapter);
        if (!this.messageBean.isGroup()) {
            setUserReadStatus(this.messageBean);
            return;
        }
        this.presenter.getGroupMessageReadReceipt(this.messageBean, new IUIKitCallback<List<MessageReceiptInfo>>() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.MessageDetailMinimalistActivity.3
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(int i, String str, List<MessageReceiptInfo> list) {
                super.onError(i, str, (String) list);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<MessageReceiptInfo> list) {
                MessageReceiptInfo messageReceiptInfo = list.get(0);
                if (messageReceiptInfo.getReadCount() <= 0) {
                    MessageDetailMinimalistActivity.this.readTitle.setVisibility(8);
                }
                if (messageReceiptInfo.getUnreadCount() <= 0) {
                    MessageDetailMinimalistActivity.this.unreadtitle.setVisibility(8);
                }
            }
        });
        this.readList.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.MessageDetailMinimalistActivity.4
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0) {
                    MessageDetailMinimalistActivity messageDetailMinimalistActivity = MessageDetailMinimalistActivity.this;
                    if (messageDetailMinimalistActivity.isLastItemVisibleCompleted(messageDetailMinimalistActivity.readList) && !MessageDetailMinimalistActivity.this.readFinished) {
                        MessageDetailMinimalistActivity messageDetailMinimalistActivity2 = MessageDetailMinimalistActivity.this;
                        messageDetailMinimalistActivity2.loadGroupMessageReadMembers(messageDetailMinimalistActivity2.readNextSeq);
                    }
                }
            }
        });
        this.unreadList.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.MessageDetailMinimalistActivity.5
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0) {
                    MessageDetailMinimalistActivity messageDetailMinimalistActivity = MessageDetailMinimalistActivity.this;
                    if (messageDetailMinimalistActivity.isLastItemVisibleCompleted(messageDetailMinimalistActivity.unreadList) && !MessageDetailMinimalistActivity.this.unreadFinished) {
                        MessageDetailMinimalistActivity messageDetailMinimalistActivity2 = MessageDetailMinimalistActivity.this;
                        messageDetailMinimalistActivity2.loadGroupMessageUnreadMembers(messageDetailMinimalistActivity2.unreadNextSeq);
                    }
                }
            }
        });
        loadGroupMessageReadMembers(0L);
        loadGroupMessageUnreadMembers(0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setMsgAbstract() {
        RecyclerView.ViewHolder messageViewHolderFactory = MessageViewHolderFactory.getInstance(this.messageArea, null, MinimalistUIService.getInstance().getViewType(this.messageBean.getClass()));
        if (messageViewHolderFactory instanceof MessageContentHolder) {
            MessageContentHolder messageContentHolder = (MessageContentHolder) messageViewHolderFactory;
            messageContentHolder.layoutViews(this.messageBean, 0);
            messageContentHolder.setTranslationContent(this.messageBean, 0);
        }
        this.messageArea.addView(messageViewHolderFactory.itemView);
    }

    private void setUserReadStatus(TUIMessageBean tUIMessageBean) {
        String userId = tUIMessageBean.getUserId();
        GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
        groupMemberInfo.setAccount(userId);
        groupMemberInfo.setFriendRemark(this.chatInfo.getChatName());
        groupMemberInfo.setIconUrl(this.chatInfo.getFaceUrl());
        if (tUIMessageBean.isPeerRead()) {
            this.unreadtitle.setVisibility(8);
            this.readMemberList.add(groupMemberInfo);
            this.readAdapter.setData(this.readMemberList);
            this.readAdapter.notifyDataSetChanged();
            return;
        }
        this.readTitle.setVisibility(8);
        this.unreadMemberList.add(groupMemberInfo);
        this.unreadAdapter.setData(this.unreadMemberList);
        this.unreadAdapter.notifyDataSetChanged();
    }

    public boolean isLastItemVisibleCompleted(RecyclerView recyclerView) {
        LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            return false;
        }
        if (layoutManager.findLastCompletelyVisibleItemPosition() < (layoutManager.findFirstVisibleItemPosition() + layoutManager.getChildCount()) - 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcloud.tuicore.component.activities.BaseMinimalistLightActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TUIChatLog.i(TAG, "onCreate " + this);
        setContentView(R.layout.chat_minimalist_message_detail_layout);
        initView();
        initData();
    }
}
