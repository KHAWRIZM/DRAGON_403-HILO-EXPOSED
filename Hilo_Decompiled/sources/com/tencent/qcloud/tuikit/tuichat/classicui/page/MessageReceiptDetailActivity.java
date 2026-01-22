package com.tencent.qcloud.tuikit.tuichat.classicui.page;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.activities.BaseLightActivity;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.DateTimeUtil;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupMemberInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageReceiptInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.GroupMessageReadMembersInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.presenter.MessageReceiptPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageReceiptDetailActivity extends BaseLightActivity {
    private static final String TAG = "MessageReceiptDetailActivity";
    private View c2cDetailArea;
    private ChatInfo chatInfo;
    private View groupDetailArea;
    private TUIMessageBean messageBean;
    private TextView msgAbstract;
    private ImageView msgAbstractImg;
    private TextView nameTv;
    private MessageReceiptPresenter presenter;
    private MemberAdapter readAdapter;
    private RecyclerView readList;
    private long readNextSeq;
    private View readTitle;
    private View readTitleLine;
    private TextView readTitleTv;
    private TextView timeTv;
    private TitleBarLayout titleBarLayout;
    private MemberAdapter unreadAdapter;
    private RecyclerView unreadList;
    private long unreadNextSeq;
    private View unreadTitle;
    private View unreadTitleLine;
    private TextView unreadTitleTv;
    private ImageView userFace;
    private TextView userName;
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
            ((RecyclerView.ViewHolder) memberViewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.MessageReceiptDetailActivity.MemberAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString("chatId", groupMemberInfo.getAccount());
                    TUICore.startActivity("FriendProfileActivity", bundle);
                }
            });
        }

        public MemberViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new MemberViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.group_receipt_member_item, viewGroup, false));
        }
    }

    private ViewGroup.LayoutParams getImageParams(ViewGroup.LayoutParams layoutParams, TUIMessageBean tUIMessageBean) {
        int imgWidth;
        int imgHeight;
        if (tUIMessageBean instanceof ImageMessageBean) {
            ImageMessageBean imageMessageBean = (ImageMessageBean) tUIMessageBean;
            imgWidth = imageMessageBean.getImgWidth();
            imgHeight = imageMessageBean.getImgHeight();
        } else {
            VideoMessageBean videoMessageBean = (VideoMessageBean) tUIMessageBean;
            imgWidth = videoMessageBean.getImgWidth();
            imgHeight = videoMessageBean.getImgHeight();
        }
        if (imgWidth != 0 && imgHeight != 0) {
            int dip2px = ScreenUtil.dip2px(40.32f);
            if (imgWidth > imgHeight) {
                layoutParams.width = dip2px;
                layoutParams.height = (dip2px * imgHeight) / imgWidth;
            } else {
                layoutParams.width = (imgWidth * dip2px) / imgHeight;
                layoutParams.height = dip2px;
            }
        }
        return layoutParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initData() {
        Intent intent = getIntent();
        this.messageBean = (TUIMessageBean) intent.getSerializableExtra("messageBean");
        this.chatInfo = (ChatInfo) intent.getSerializableExtra(TUIChatConstants.CHAT_INFO);
        this.presenter = new MessageReceiptPresenter();
        setMsgAbstract();
        this.nameTv.setText(this.messageBean.getUserDisplayName());
        this.timeTv.setText(DateTimeUtil.getTimeFormatText(new Date(this.messageBean.getMessageTime() * 1000)));
        if (!this.messageBean.isGroup()) {
            setUserDetail(this.messageBean);
            return;
        }
        this.readAdapter = new MemberAdapter();
        this.unreadAdapter = new MemberAdapter();
        this.readList.setLayoutManager(new CustomLinearLayoutManager(this));
        this.unreadList.setLayoutManager(new CustomLinearLayoutManager(this));
        this.readList.setAdapter(this.readAdapter);
        this.unreadList.setAdapter(this.unreadAdapter);
        this.presenter.getGroupMessageReadReceipt(this.messageBean, new IUIKitCallback<List<MessageReceiptInfo>>() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.MessageReceiptDetailActivity.4
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<MessageReceiptInfo> list) {
                MessageReceiptInfo messageReceiptInfo = list.get(0);
                MessageReceiptDetailActivity.this.readTitleTv.setText(MessageReceiptDetailActivity.this.getString(R.string.someone_have_read, Long.valueOf(messageReceiptInfo.getReadCount())));
                MessageReceiptDetailActivity.this.unreadTitleTv.setText(MessageReceiptDetailActivity.this.getString(R.string.someone_unread, Long.valueOf(messageReceiptInfo.getUnreadCount())));
            }
        });
        this.readList.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.MessageReceiptDetailActivity.5
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0) {
                    MessageReceiptDetailActivity messageReceiptDetailActivity = MessageReceiptDetailActivity.this;
                    if (messageReceiptDetailActivity.isLastItemVisibleCompleted(messageReceiptDetailActivity.readList) && !MessageReceiptDetailActivity.this.readFinished) {
                        MessageReceiptDetailActivity messageReceiptDetailActivity2 = MessageReceiptDetailActivity.this;
                        messageReceiptDetailActivity2.loadGroupMessageReadMembers(messageReceiptDetailActivity2.readNextSeq);
                    }
                }
            }
        });
        this.unreadList.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.MessageReceiptDetailActivity.6
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0) {
                    MessageReceiptDetailActivity messageReceiptDetailActivity = MessageReceiptDetailActivity.this;
                    if (messageReceiptDetailActivity.isLastItemVisibleCompleted(messageReceiptDetailActivity.unreadList) && !MessageReceiptDetailActivity.this.unreadFinished) {
                        MessageReceiptDetailActivity messageReceiptDetailActivity2 = MessageReceiptDetailActivity.this;
                        messageReceiptDetailActivity2.loadGroupMessageUnreadMembers(messageReceiptDetailActivity2.unreadNextSeq);
                    }
                }
            }
        });
        loadGroupMessageReadMembers(0L);
        loadGroupMessageUnreadMembers(0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.receipt_title);
        this.titleBarLayout = titleBarLayout;
        titleBarLayout.setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.MessageReceiptDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageReceiptDetailActivity.this.finish();
            }
        });
        this.titleBarLayout.setTitle(getString(R.string.chat_message_detail), ITitleBarLayout.Position.MIDDLE);
        this.groupDetailArea = findViewById(R.id.group_read_details);
        this.c2cDetailArea = findViewById(R.id.user_read_detail);
        this.userFace = (ImageView) findViewById(R.id.user_face);
        this.userName = (TextView) findViewById(R.id.user_name_tv);
        this.msgAbstract = (TextView) findViewById(R.id.msg_abstract);
        this.msgAbstractImg = (ImageView) findViewById(R.id.msg_abstract_iv);
        this.nameTv = (TextView) findViewById(R.id.name_tv);
        this.timeTv = (TextView) findViewById(R.id.time_tv);
        this.readTitleTv = (TextView) findViewById(R.id.read_title_tv);
        this.unreadTitleTv = (TextView) findViewById(R.id.unread_title_tv);
        this.readTitleLine = findViewById(R.id.read_title_line);
        this.unreadTitleLine = findViewById(R.id.unread_title_line);
        this.readList = findViewById(R.id.read_list);
        this.unreadList = findViewById(R.id.unread_list);
        this.readTitle = findViewById(R.id.read_title);
        this.unreadTitle = findViewById(R.id.unread_title);
        this.readTitle.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.MessageReceiptDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageReceiptDetailActivity.this.readTitleLine.setVisibility(0);
                MessageReceiptDetailActivity.this.readTitleTv.setTextColor(MessageReceiptDetailActivity.this.getResources().getColor(TUIThemeManager.getAttrResId(MessageReceiptDetailActivity.this, com.tencent.qcloud.tuicore.R.attr.core_primary_color)));
                MessageReceiptDetailActivity.this.readList.setVisibility(0);
                MessageReceiptDetailActivity.this.unreadList.setVisibility(8);
                MessageReceiptDetailActivity.this.unreadTitleLine.setVisibility(4);
                MessageReceiptDetailActivity.this.unreadTitleTv.setTextColor(-12303292);
            }
        });
        this.unreadTitle.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.MessageReceiptDetailActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageReceiptDetailActivity.this.unreadTitleLine.setVisibility(0);
                MessageReceiptDetailActivity.this.unreadTitleTv.setTextColor(MessageReceiptDetailActivity.this.getResources().getColor(TUIThemeManager.getAttrResId(MessageReceiptDetailActivity.this, com.tencent.qcloud.tuicore.R.attr.core_primary_color)));
                MessageReceiptDetailActivity.this.unreadList.setVisibility(0);
                MessageReceiptDetailActivity.this.readList.setVisibility(8);
                MessageReceiptDetailActivity.this.readTitleLine.setVisibility(4);
                MessageReceiptDetailActivity.this.readTitleTv.setTextColor(-12303292);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadGroupMessageReadMembers(long j) {
        if (this.readLoading) {
            return;
        }
        this.readLoading = true;
        this.presenter.getGroupMessageReadMembers(this.messageBean, true, j, new IUIKitCallback<GroupMessageReadMembersInfo>() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.MessageReceiptDetailActivity.8
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                MessageReceiptDetailActivity.this.readLoading = false;
                TUIChatLog.e(MessageReceiptDetailActivity.TAG, "errCode " + i + " errMsg " + str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(GroupMessageReadMembersInfo groupMessageReadMembersInfo) {
                MessageReceiptDetailActivity.this.readNextSeq = groupMessageReadMembersInfo.getNextSeq();
                MessageReceiptDetailActivity.this.readFinished = groupMessageReadMembersInfo.isFinished();
                MessageReceiptDetailActivity.this.readMemberList.addAll(groupMessageReadMembersInfo.getGroupMemberInfoList());
                MessageReceiptDetailActivity.this.readAdapter.setData(MessageReceiptDetailActivity.this.readMemberList);
                MessageReceiptDetailActivity.this.readAdapter.notifyDataSetChanged();
                MessageReceiptDetailActivity.this.readLoading = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadGroupMessageUnreadMembers(long j) {
        if (this.unreadLoading) {
            return;
        }
        this.unreadLoading = true;
        this.presenter.getGroupMessageReadMembers(this.messageBean, false, j, new IUIKitCallback<GroupMessageReadMembersInfo>() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.MessageReceiptDetailActivity.9
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                MessageReceiptDetailActivity.this.unreadLoading = false;
                TUIChatLog.e(MessageReceiptDetailActivity.TAG, "errCode " + i + " errMsg " + str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(GroupMessageReadMembersInfo groupMessageReadMembersInfo) {
                MessageReceiptDetailActivity.this.unreadNextSeq = groupMessageReadMembersInfo.getNextSeq();
                MessageReceiptDetailActivity.this.unreadFinished = groupMessageReadMembersInfo.isFinished();
                MessageReceiptDetailActivity.this.unreadMemberList.addAll(groupMessageReadMembersInfo.getGroupMemberInfoList());
                MessageReceiptDetailActivity.this.unreadAdapter.setData(MessageReceiptDetailActivity.this.unreadMemberList);
                MessageReceiptDetailActivity.this.unreadAdapter.notifyDataSetChanged();
                MessageReceiptDetailActivity.this.unreadLoading = false;
            }
        });
    }

    private void setMsgAbstract() {
        TUIMessageBean tUIMessageBean = this.messageBean;
        if (!(tUIMessageBean instanceof ImageMessageBean) && !(tUIMessageBean instanceof VideoMessageBean)) {
            this.msgAbstractImg.setVisibility(8);
            TUIMessageBean tUIMessageBean2 = this.messageBean;
            if (tUIMessageBean2 instanceof FileMessageBean) {
                this.msgAbstract.setText(this.messageBean.getExtra() + ((FileMessageBean) this.messageBean).getFileName());
                return;
            }
            FaceManager.handlerEmojiText(this.msgAbstract, tUIMessageBean2.getExtra(), false);
            return;
        }
        ImageView imageView = this.msgAbstractImg;
        imageView.setLayoutParams(getImageParams(imageView.getLayoutParams(), this.messageBean));
        this.msgAbstractImg.setVisibility(0);
        TUIMessageBean tUIMessageBean3 = this.messageBean;
        if (tUIMessageBean3 instanceof ImageMessageBean) {
            GlideEngine.loadImage(this.msgAbstractImg, ((ImageMessageBean) tUIMessageBean3).getDataPath());
        } else if (tUIMessageBean3 instanceof VideoMessageBean) {
            GlideEngine.loadImage(this.msgAbstractImg, ((VideoMessageBean) tUIMessageBean3).getDataPath());
        }
        this.msgAbstract.setText("");
    }

    private void setUserDetail(TUIMessageBean tUIMessageBean) {
        this.groupDetailArea.setVisibility(8);
        this.c2cDetailArea.setVisibility(0);
        final String userId = tUIMessageBean.getUserId();
        ChatInfo chatInfo = this.chatInfo;
        if (chatInfo != null) {
            GlideEngine.loadUserIcon(this.userFace, chatInfo.getFaceUrl());
            this.userName.setText(this.chatInfo.getChatName());
        }
        this.c2cDetailArea.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.MessageReceiptDetailActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("chatId", userId);
                TUICore.startActivity("FriendProfileActivity", bundle);
            }
        });
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
    @Override // com.tencent.qcloud.tuicore.component.activities.BaseLightActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TUIChatLog.i(TAG, "onCreate " + this);
        setContentView(R.layout.msg_receipt_detail_layout);
        initView();
        initData();
    }
}
