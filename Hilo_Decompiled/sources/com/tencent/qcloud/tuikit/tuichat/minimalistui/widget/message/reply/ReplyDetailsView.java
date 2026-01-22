package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.reply;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c5.h;
import com.bumptech.glide.Glide;
import com.tencent.qcloud.tuicore.util.DateTimeUtil;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageRepliesBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.component.MessageProperties;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.TimeInLineTextLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

        void optimizeBackgroundAndAvatar(ReplyDetailsViewHolder replyDetailsViewHolder, List<MessageRepliesBean.ReplyBean> list, int i) {
            MessageRepliesBean.ReplyBean replyBean;
            MessageRepliesBean.ReplyBean replyBean2 = list.get(i);
            boolean z = true;
            int i2 = i + 1;
            if (list.size() > i2) {
                replyBean = list.get(i2);
            } else {
                replyBean = null;
            }
            String messageSender = replyBean2.getMessageSender();
            if (replyBean != null && TextUtils.equals(messageSender, replyBean.getMessageSender())) {
                z = false;
            }
            int dip2px = ScreenUtil.dip2px(36.0f);
            int dip2px2 = ScreenUtil.dip2px(20.0f);
            if (z) {
                replyDetailsViewHolder.userFaceView.setVisibility(0);
                replyDetailsViewHolder.msgContent.setBackgroundResource(R.drawable.chat_message_popup_stroke_border_left);
            } else {
                dip2px = ScreenUtil.dip2px(36.0f);
                dip2px2 = ScreenUtil.dip2px(2.0f);
                replyDetailsViewHolder.userFaceView.setVisibility(4);
                replyDetailsViewHolder.msgContent.setBackgroundResource(R.drawable.chat_message_popup_stroke_border);
            }
            ((RecyclerView.ViewHolder) replyDetailsViewHolder).itemView.setPadding(0, 0, dip2px, dip2px2);
        }

        public void setData(Map<MessageRepliesBean.ReplyBean, TUIMessageBean> map) {
            this.data = map;
        }

        public void onBindViewHolder(ReplyDetailsViewHolder replyDetailsViewHolder, int i) {
            int i2;
            String str;
            String str2;
            ArrayList arrayList = new ArrayList(this.data.keySet());
            MessageRepliesBean.ReplyBean replyBean = arrayList.get(i);
            TUIMessageBean tUIMessageBean = this.data.get(replyBean);
            if (tUIMessageBean == null) {
                String messageAbstract = replyBean.getMessageAbstract();
                str = replyBean.getSenderFaceUrl();
                str2 = messageAbstract;
                i2 = 0;
            } else {
                int translationStatus = tUIMessageBean.getTranslationStatus();
                String extra = tUIMessageBean.getExtra();
                String faceUrl = tUIMessageBean.getFaceUrl();
                replyDetailsViewHolder.timeInLineTextLayout.setTimeText(DateTimeUtil.getTimeFormatText(new Date(tUIMessageBean.getMessageTime() * 1000)));
                i2 = translationStatus;
                str = faceUrl;
                str2 = extra;
            }
            Glide.with(((RecyclerView.ViewHolder) replyDetailsViewHolder).itemView.getContext()).q(str).q0(new h().j(com.tencent.qcloud.tuicore.R.drawable.core_default_user_icon_light)).D0(replyDetailsViewHolder.userFaceView);
            FaceManager.handlerEmojiText(replyDetailsViewHolder.timeInLineTextLayout.getTextView(), str2, false);
            if (i2 == 3) {
                ReplyDetailsView.this.translationContentFrameLayout.setVisibility(0);
                ReplyDetailsView.this.translationResultLayout.setVisibility(0);
                TextView textView = (TextView) ReplyDetailsView.this.translationContentFrameLayout.findViewById(R.id.translate_tv);
                textView.setTextSize(0, textView.getResources().getDimension(R.dimen.chat_minimalist_message_text_size));
                if (MessageProperties.getInstance().getChatContextFontSize() != 0) {
                    textView.setTextSize(MessageProperties.getInstance().getChatContextFontSize());
                }
                FaceManager.handlerEmojiText(textView, tUIMessageBean.getTranslation(), false);
            } else if (i2 == 2) {
                ReplyDetailsView.this.translationContentFrameLayout.setVisibility(0);
                ReplyDetailsView.this.translationResultLayout.setVisibility(8);
            } else {
                ReplyDetailsView.this.translationContentFrameLayout.setVisibility(8);
            }
            optimizeBackgroundAndAvatar(replyDetailsViewHolder, arrayList, i);
        }

        public ReplyDetailsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_minimalist_reply_details_item_layout, viewGroup, false);
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
        public View msgContent;
        public TimeInLineTextLayout timeInLineTextLayout;
        public ImageView userFaceView;

        public ReplyDetailsViewHolder(View view) {
            super(view);
            this.userFaceView = (ImageView) view.findViewById(R.id.user_icon);
            this.timeInLineTextLayout = (TimeInLineTextLayout) view.findViewById(R.id.time_in_line_text);
            this.msgContent = view.findViewById(R.id.msg_content);
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
