package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuicore.util.DateTimeUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageRepliesBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.component.MessageProperties;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ReplyDetailsView extends RecyclerView {
    private ReplyDetailsAdapter adapter;
    private LinearLayoutManager layoutManager;
    private FrameLayout translationContentFrameLayout;
    private LinearLayout translationResultLayout;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class ReplyDetailsAdapter extends RecyclerView.Adapter<ReplyDetailsViewHolder> {
        Map<MessageRepliesBean.ReplyBean, TUIMessageBean> data;

        public ReplyDetailsAdapter() {
        }

        public int getItemCount() {
            Map<MessageRepliesBean.ReplyBean, TUIMessageBean> map = this.data;
            if (map == null) {
                return 0;
            }
            return map.size();
        }

        public void setData(Map<MessageRepliesBean.ReplyBean, TUIMessageBean> map) {
            this.data = map;
        }

        public void onBindViewHolder(ReplyDetailsViewHolder replyDetailsViewHolder, int i) {
            int translationStatus;
            String extra;
            String userDisplayName;
            MessageRepliesBean.ReplyBean replyBean = (MessageRepliesBean.ReplyBean) new ArrayList(this.data.keySet()).get(i);
            TUIMessageBean tUIMessageBean = this.data.get(replyBean);
            ArrayList arrayList = new ArrayList();
            if (tUIMessageBean == null) {
                userDisplayName = replyBean.getSenderShowName();
                extra = replyBean.getMessageAbstract();
                arrayList.add(replyBean.getSenderFaceUrl());
                translationStatus = 0;
            } else {
                translationStatus = tUIMessageBean.getTranslationStatus();
                extra = tUIMessageBean.getExtra();
                userDisplayName = tUIMessageBean.getUserDisplayName();
                arrayList.add(tUIMessageBean.getFaceUrl());
                replyDetailsViewHolder.timeText.setText(DateTimeUtil.getTimeFormatText(new Date(tUIMessageBean.getMessageTime() * 1000)));
            }
            replyDetailsViewHolder.userFaceView.setIconUrls(arrayList);
            replyDetailsViewHolder.userNameTv.setText(userDisplayName);
            FaceManager.handlerEmojiText(replyDetailsViewHolder.messageText, extra, false);
            if (translationStatus != 3) {
                if (translationStatus == 2) {
                    ReplyDetailsView.this.translationContentFrameLayout.setVisibility(0);
                    ReplyDetailsView.this.translationResultLayout.setVisibility(8);
                    return;
                } else {
                    ReplyDetailsView.this.translationContentFrameLayout.setVisibility(8);
                    return;
                }
            }
            ReplyDetailsView.this.translationContentFrameLayout.setVisibility(0);
            ReplyDetailsView.this.translationResultLayout.setVisibility(0);
            TextView textView = (TextView) ReplyDetailsView.this.translationContentFrameLayout.findViewById(R.id.translate_tv);
            if (MessageProperties.getInstance().getChatContextFontSize() != 0) {
                textView.setTextSize(MessageProperties.getInstance().getChatContextFontSize());
            }
            FaceManager.handlerEmojiText(textView, tUIMessageBean.getTranslation(), false);
        }

        public ReplyDetailsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_reply_details_item_layout, viewGroup, false);
            ReplyDetailsView.this.translationContentFrameLayout = (FrameLayout) inflate.findViewById(R.id.translate_content_fl);
            LayoutInflater.from(inflate.getContext()).inflate(R.layout.translation_contant_layout, ReplyDetailsView.this.translationContentFrameLayout);
            ReplyDetailsView replyDetailsView = ReplyDetailsView.this;
            replyDetailsView.translationResultLayout = (LinearLayout) replyDetailsView.translationContentFrameLayout.findViewById(R.id.translate_result_ll);
            return new ReplyDetailsViewHolder(inflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class ReplyDetailsViewHolder extends RecyclerView.ViewHolder {
        protected TextView messageText;
        protected TextView timeText;
        public UserIconView userFaceView;
        protected TextView userNameTv;

        public ReplyDetailsViewHolder(View view) {
            super(view);
            this.userFaceView = (UserIconView) view.findViewById(R.id.user_icon);
            this.userNameTv = (TextView) view.findViewById(R.id.user_name_tv);
            this.messageText = (TextView) view.findViewById(R.id.msg_abstract);
            this.timeText = (TextView) view.findViewById(R.id.msg_time);
        }
    }

    public ReplyDetailsView(Context context) {
        super(context);
        initView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.layoutManager = linearLayoutManager;
        setLayoutManager(linearLayoutManager);
        ReplyDetailsAdapter replyDetailsAdapter = new ReplyDetailsAdapter();
        this.adapter = replyDetailsAdapter;
        setAdapter(replyDetailsAdapter);
    }

    public void setData(Map<MessageRepliesBean.ReplyBean, TUIMessageBean> map) {
        this.adapter.setData(map);
        this.adapter.notifyDataSetChanged();
    }

    public ReplyDetailsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public ReplyDetailsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
