package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.utils.HiloToasty;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuicore.util.DateTimeUtil;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageReactBean;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageRepliesBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.SelectTextHelper;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.ChatFlowReactView;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class MessageContentHolder extends MessageBaseHolder {
    public boolean isForwardMode;
    public boolean isMultiSelectMode;
    public TextView isReadText;
    public boolean isReplyDetailMode;
    public UserIconView leftUserIcon;
    private List<TUIMessageBean> mDataSource;
    public TextView messageDetailsTimeTv;
    public LinearLayout msgContentLinear;
    protected ChatPresenter presenter;
    public UserIconView rightUserIcon;
    protected SelectTextHelper selectableTextHelper;
    public ProgressBar sendingProgress;
    public ImageView statusImage;
    private FrameLayout translationContentFrameLayout;
    private ImageView translationLoadingImage;
    private LinearLayout translationResultLayout;
    private RotateAnimation translationRotateAnimation;
    public TextView unreadAudioText;
    public TextView usernameText;

    public MessageContentHolder(View view) {
        super(view);
        this.isForwardMode = false;
        this.isReplyDetailMode = false;
        this.isMultiSelectMode = false;
        this.mDataSource = new ArrayList();
        this.leftUserIcon = (UserIconView) view.findViewById(R.id.left_user_icon_view);
        this.rightUserIcon = (UserIconView) view.findViewById(R.id.right_user_icon_view);
        this.usernameText = (TextView) view.findViewById(R.id.user_name_tv);
        this.msgContentLinear = (LinearLayout) view.findViewById(R.id.msg_content_ll);
        this.statusImage = (ImageView) view.findViewById(R.id.message_status_iv);
        this.sendingProgress = (ProgressBar) view.findViewById(R.id.message_sending_pb);
        this.isReadText = (TextView) view.findViewById(R.id.is_read_tv);
        this.unreadAudioText = (TextView) view.findViewById(R.id.audio_unread);
        this.messageDetailsTimeTv = (TextView) view.findViewById(R.id.msg_detail_time_tv);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.translate_content_fl);
        this.translationContentFrameLayout = frameLayout;
        if (frameLayout != null) {
            LayoutInflater.from(view.getContext()).inflate(R.layout.translation_contant_layout, this.translationContentFrameLayout);
            this.translationLoadingImage = (ImageView) this.translationContentFrameLayout.findViewById(R.id.translate_loading_iv);
            this.translationResultLayout = (LinearLayout) this.translationContentFrameLayout.findViewById(R.id.translate_result_ll);
        }
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [android.view.View, com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.ChatFlowReactView] */
    private void setReactContent(final TUIMessageBean tUIMessageBean) {
        MessageReactBean messageReactBean = tUIMessageBean.getMessageReactBean();
        if (messageReactBean != null && messageReactBean.getReactSize() > 0) {
            this.reactView.setVisibility(0);
            this.reactView.setData(messageReactBean);
            this.reactView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder.10
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    OnItemClickListener onItemClickListener = MessageContentHolder.this.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onMessageLongClick(view, 0, tUIMessageBean);
                        return true;
                    }
                    return true;
                }
            });
            if (!this.isForwardMode) {
                this.reactView.setReactOnClickListener(new ChatFlowReactView.ReactOnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder.11
                    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.ChatFlowReactView.ReactOnClickListener
                    public void onClick(String str) {
                        OnItemClickListener onItemClickListener = MessageContentHolder.this.onItemClickListener;
                        if (onItemClickListener != null) {
                            onItemClickListener.onReactOnClick(str, tUIMessageBean);
                        }
                    }
                });
            } else {
                this.reactView.setOnLongClickListener(null);
            }
        } else {
            this.reactView.setVisibility(8);
            this.reactView.setOnLongClickListener(null);
        }
        if (tUIMessageBean.isSelf() && !this.isForwardMode && !this.isReplyDetailMode) {
            this.reactView.setThemeColorId(0);
        } else {
            ?? r5 = this.reactView;
            r5.setThemeColorId(TUIThemeManager.getAttrResId(r5.getContext(), R.attr.chat_react_other_text_color));
        }
    }

    private void setReplyContent(final TUIMessageBean tUIMessageBean) {
        MessageRepliesBean messageRepliesBean = tUIMessageBean.getMessageRepliesBean();
        if (messageRepliesBean != null && messageRepliesBean.getRepliesSize() > 0) {
            TextView textView = (TextView) this.msgReplyDetailLayout.findViewById(R.id.reply_num);
            textView.setText(textView.getResources().getString(R.string.chat_reply_num, Integer.valueOf(messageRepliesBean.getRepliesSize())));
            this.msgReplyDetailLayout.setVisibility(0);
            this.msgReplyDetailLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OnItemClickListener onItemClickListener = MessageContentHolder.this.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onReplyDetailClick(tUIMessageBean);
                    }
                }
            });
        } else {
            this.msgReplyDetailLayout.setVisibility(8);
            this.msgReplyDetailLayout.setOnClickListener(null);
        }
        if (!this.isReplyDetailMode) {
            this.messageDetailsTimeTv.setVisibility(8);
            return;
        }
        this.messageDetailsTimeTv.setText(DateTimeUtil.getTimeFormatText(new Date(tUIMessageBean.getMessageTime() * 1000)));
        this.messageDetailsTimeTv.setVisibility(0);
        this.msgReplyDetailLayout.setVisibility(8);
    }

    private void showReadText(final TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean.isGroup()) {
            this.isReadText.setVisibility(0);
            if (tUIMessageBean.isAllRead()) {
                this.isReadText.setText(R.string.has_all_read);
                return;
            }
            if (tUIMessageBean.isUnread()) {
                TextView textView = this.isReadText;
                textView.setTextColor(textView.getResources().getColor(TUIThemeManager.getAttrResId(this.isReadText.getContext(), R.attr.chat_read_receipt_text_color)));
                this.isReadText.setText(R.string.unread);
                this.isReadText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageContentHolder.this.startShowUnread(tUIMessageBean);
                    }
                });
                return;
            }
            long readCount = tUIMessageBean.getReadCount();
            if (readCount > 0) {
                TextView textView2 = this.isReadText;
                textView2.setText(textView2.getResources().getString(R.string.someone_has_read, Long.valueOf(readCount)));
                TextView textView3 = this.isReadText;
                textView3.setTextColor(textView3.getResources().getColor(TUIThemeManager.getAttrResId(this.isReadText.getContext(), R.attr.chat_read_receipt_text_color)));
                this.isReadText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder.13
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageContentHolder.this.startShowUnread(tUIMessageBean);
                    }
                });
                return;
            }
            return;
        }
        this.isReadText.setVisibility(0);
        if (tUIMessageBean.isPeerRead()) {
            this.isReadText.setText(R.string.has_read);
            return;
        }
        this.isReadText.setText(R.string.unread);
        TextView textView4 = this.isReadText;
        textView4.setTextColor(textView4.getResources().getColor(TUIThemeManager.getAttrResId(this.isReadText.getContext(), R.attr.chat_read_receipt_text_color)));
        this.isReadText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageContentHolder.this.startShowUnread(tUIMessageBean);
            }
        });
    }

    private void startTranslationLoading() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.translationRotateAnimation = rotateAnimation;
        rotateAnimation.setRepeatCount(-1);
        this.translationRotateAnimation.setDuration(1000L);
        this.translationRotateAnimation.setInterpolator(new LinearInterpolator());
        ImageView imageView = this.translationLoadingImage;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.translationLoadingImage.startAnimation(this.translationRotateAnimation);
        }
    }

    private void stopTranslationLoading() {
        ImageView imageView = this.translationLoadingImage;
        if (imageView != null) {
            imageView.clearAnimation();
            this.translationLoadingImage.setVisibility(8);
        }
    }

    public List<TUIMessageBean> getDataSource() {
        return this.mDataSource;
    }

    public abstract void layoutVariableViews(TUIMessageBean tUIMessageBean, int i);

    /* JADX WARN: Removed duplicated region for block: B:103:0x024a A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0203 A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0196 A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x010c A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0082 A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0057 A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040 A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006b A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f2 A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0145 A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0158 A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x016c A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0177 A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a5 A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b1 A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01e9 A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x022d A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0238 A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0271 A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0292 A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02a5 A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02da A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02ed A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x000f, B:10:0x0015, B:11:0x0038, B:13:0x0040, B:14:0x0063, B:16:0x006b, B:17:0x0092, B:19:0x009c, B:21:0x00a5, B:22:0x00e3, B:24:0x00e7, B:27:0x00ec, B:29:0x00f2, B:31:0x00fa, B:32:0x013d, B:34:0x0145, B:35:0x0150, B:37:0x0158, B:38:0x0164, B:40:0x016c, B:43:0x0171, B:45:0x0177, B:47:0x017d, B:49:0x0183, B:52:0x018a, B:53:0x01a1, B:55:0x01a5, B:58:0x01aa, B:60:0x01b1, B:61:0x01e3, B:63:0x01e9, B:64:0x0229, B:66:0x022d, B:69:0x0232, B:71:0x0238, B:72:0x026d, B:74:0x0271, B:75:0x0274, B:77:0x0292, B:80:0x0297, B:82:0x02a5, B:84:0x02ab, B:86:0x02b1, B:88:0x02b7, B:89:0x02bd, B:90:0x02c1, B:91:0x02c6, B:92:0x02d6, B:94:0x02da, B:95:0x02df, B:97:0x02ed, B:98:0x02f0, B:102:0x02cc, B:103:0x024a, B:104:0x025c, B:105:0x0203, B:106:0x0213, B:107:0x0190, B:108:0x0196, B:109:0x019c, B:110:0x0100, B:111:0x010c, B:113:0x0114, B:115:0x011a, B:117:0x0120, B:118:0x0126, B:119:0x012c, B:120:0x0138, B:121:0x0082, B:122:0x0057, B:123:0x0023, B:124:0x002e), top: B:2:0x0004 }] */
    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    @SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutViews(final TUIMessageBean tUIMessageBean, final int i) {
        RelativeLayout relativeLayout;
        super.layoutViews(tUIMessageBean, i);
        try {
            if (!this.isForwardMode && !this.isReplyDetailMode) {
                if (tUIMessageBean.isSelf()) {
                    this.leftUserIcon.setVisibility(8);
                    this.rightUserIcon.setVisibility(0);
                } else {
                    this.leftUserIcon.setVisibility(0);
                    this.rightUserIcon.setVisibility(8);
                }
                if (this.properties.getAvatar() == 0) {
                    this.leftUserIcon.setDefaultImageResId(this.properties.getAvatar());
                    this.rightUserIcon.setDefaultImageResId(this.properties.getAvatar());
                } else {
                    UserIconView userIconView = this.leftUserIcon;
                    int i2 = R.drawable.default_user_icon;
                    userIconView.setDefaultImageResId(i2);
                    this.rightUserIcon.setDefaultImageResId(i2);
                }
                if (this.properties.getAvatarRadius() == 0) {
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
                if (!this.isForwardMode && !this.isReplyDetailMode) {
                    if (!tUIMessageBean.isSelf()) {
                        if (this.properties.getRightNameVisibility() == 0) {
                            this.usernameText.setVisibility(8);
                        } else {
                            this.usernameText.setVisibility(this.properties.getRightNameVisibility());
                        }
                    } else if (this.properties.getLeftNameVisibility() == 0) {
                        if (tUIMessageBean.isGroup() && !checkIsStrangeGroup()) {
                            this.usernameText.setVisibility(0);
                        } else {
                            this.usernameText.setVisibility(8);
                        }
                    } else {
                        this.usernameText.setVisibility(this.properties.getLeftNameVisibility());
                    }
                    if (this.properties.getNameFontColor() != 0) {
                        this.usernameText.setTextColor(this.properties.getNameFontColor());
                    }
                    if (this.properties.getNameFontSize() != 0) {
                        this.usernameText.setTextSize(this.properties.getNameFontSize());
                    }
                    refreshBaseView(tUIMessageBean);
                    if (!this.isForwardMode && !this.isReplyDetailMode) {
                        if (!tUIMessageBean.isSelf()) {
                            if (tUIMessageBean.getStatus() != 3 && tUIMessageBean.getStatus() != 2 && !tUIMessageBean.isPeerRead()) {
                                this.sendingProgress.setVisibility(0);
                            }
                            this.sendingProgress.setVisibility(8);
                        } else {
                            this.sendingProgress.setVisibility(8);
                        }
                        if (!this.isForwardMode && !this.isReplyDetailMode) {
                            refreshBubble(tUIMessageBean);
                            if (this.onItemClickListener != null) {
                                this.msgContentFrame.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder.1
                                    @Override // android.view.View.OnLongClickListener
                                    public boolean onLongClick(View view) {
                                        MessageContentHolder.this.onItemClickListener.onMessageLongClick(view, i, tUIMessageBean);
                                        return true;
                                    }
                                });
                                this.msgArea.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder.2
                                    @Override // android.view.View.OnLongClickListener
                                    public boolean onLongClick(View view) {
                                        MessageContentHolder messageContentHolder = MessageContentHolder.this;
                                        messageContentHolder.onItemClickListener.onMessageLongClick(messageContentHolder.msgArea, i, tUIMessageBean);
                                        return true;
                                    }
                                });
                                this.leftUserIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder.3
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        if (MessageContentHolder.this.checkStrange()) {
                                            Toast normal = HiloToasty.Companion.normal(((RecyclerView.ViewHolder) MessageContentHolder.this).itemView.getContext(), androidx.core.content.a.getString(((RecyclerView.ViewHolder) MessageContentHolder.this).itemView.getContext(), R.string.strange_click_avatar_tip), false);
                                            Objects.requireNonNull(normal);
                                            normal.show();
                                            return;
                                        }
                                        MessageContentHolder.this.onItemClickListener.onUserIconClick(view, i, tUIMessageBean);
                                    }
                                });
                                this.leftUserIcon.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder.4
                                    @Override // android.view.View.OnLongClickListener
                                    public boolean onLongClick(View view) {
                                        if (MessageContentHolder.this.checkStrange()) {
                                            Toast normal = HiloToasty.Companion.normal(((RecyclerView.ViewHolder) MessageContentHolder.this).itemView.getContext(), androidx.core.content.a.getString(((RecyclerView.ViewHolder) MessageContentHolder.this).itemView.getContext(), R.string.strange_click_avatar_tip), false);
                                            Objects.requireNonNull(normal);
                                            normal.show();
                                            return true;
                                        }
                                        MessageContentHolder.this.onItemClickListener.onUserIconLongClick(view, i, tUIMessageBean);
                                        return true;
                                    }
                                });
                                this.rightUserIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder.5
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        MessageContentHolder.this.onItemClickListener.onUserIconClick(view, i, tUIMessageBean);
                                    }
                                });
                            }
                            if (tUIMessageBean.getStatus() != 3) {
                                this.statusImage.setVisibility(0);
                                this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder.6
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        MessageContentHolder messageContentHolder = MessageContentHolder.this;
                                        OnItemClickListener onItemClickListener = messageContentHolder.onItemClickListener;
                                        if (onItemClickListener != null) {
                                            onItemClickListener.onMessageLongClick(messageContentHolder.msgContentFrame, i, tUIMessageBean);
                                        }
                                    }
                                });
                                this.statusImage.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder.7
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        MessageContentHolder messageContentHolder = MessageContentHolder.this;
                                        OnItemClickListener onItemClickListener = messageContentHolder.onItemClickListener;
                                        if (onItemClickListener != null) {
                                            onItemClickListener.onSendFailBtnClick(messageContentHolder.statusImage, i, tUIMessageBean);
                                        }
                                    }
                                });
                            } else {
                                this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder.8
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        MessageContentHolder messageContentHolder = MessageContentHolder.this;
                                        OnItemClickListener onItemClickListener = messageContentHolder.onItemClickListener;
                                        if (onItemClickListener != null) {
                                            onItemClickListener.onMessageClick(messageContentHolder.msgContentFrame, i, tUIMessageBean);
                                        }
                                    }
                                });
                                this.statusImage.setVisibility(8);
                            }
                            if (!this.isForwardMode && !this.isReplyDetailMode) {
                                if (!tUIMessageBean.isSelf()) {
                                    setGravity(false);
                                    this.msgContentLinear.removeView(this.msgAreaAndReply);
                                    this.msgContentLinear.addView(this.msgAreaAndReply);
                                } else {
                                    setGravity(true);
                                    this.msgContentLinear.removeView(this.msgAreaAndReply);
                                    this.msgContentLinear.addView(this.msgAreaAndReply, 0);
                                }
                                relativeLayout = this.rightGroupLayout;
                                if (relativeLayout != null) {
                                    relativeLayout.setVisibility(0);
                                }
                                this.msgContentLinear.setVisibility(0);
                                TextView textView = this.isReadText;
                                textView.setTextColor(textView.getResources().getColor(R.color.text_gray1));
                                this.isReadText.setOnClickListener(null);
                                if (!this.isForwardMode && !this.isReplyDetailMode) {
                                    if (TUIChatConfigs.getConfigs().getGeneralConfig().isShowRead()) {
                                        if (tUIMessageBean.isSelf() && 2 == tUIMessageBean.getStatus()) {
                                            if (!tUIMessageBean.isNeedReadReceipt()) {
                                                this.isReadText.setVisibility(8);
                                            } else {
                                                showReadText(tUIMessageBean);
                                            }
                                        } else {
                                            this.isReadText.setVisibility(8);
                                        }
                                    }
                                    this.unreadAudioText.setVisibility(8);
                                    if (this.isReplyDetailMode) {
                                        this.chatTimeText.setVisibility(8);
                                    }
                                    setReplyContent(tUIMessageBean);
                                    setReactContent(tUIMessageBean);
                                    if (this.presenter.isNeedShowTranslation()) {
                                        setTranslationContent(tUIMessageBean, i);
                                    }
                                    setMessageAreaPadding();
                                    layoutVariableViews(tUIMessageBean, i);
                                }
                                this.isReadText.setVisibility(8);
                                this.unreadAudioText.setVisibility(8);
                                if (this.isReplyDetailMode) {
                                }
                                setReplyContent(tUIMessageBean);
                                setReactContent(tUIMessageBean);
                                if (this.presenter.isNeedShowTranslation()) {
                                }
                                setMessageAreaPadding();
                                layoutVariableViews(tUIMessageBean, i);
                            }
                            setGravity(true);
                            this.msgContentLinear.removeView(this.msgAreaAndReply);
                            this.msgContentLinear.addView(this.msgAreaAndReply);
                            relativeLayout = this.rightGroupLayout;
                            if (relativeLayout != null) {
                            }
                            this.msgContentLinear.setVisibility(0);
                            TextView textView2 = this.isReadText;
                            textView2.setTextColor(textView2.getResources().getColor(R.color.text_gray1));
                            this.isReadText.setOnClickListener(null);
                            if (!this.isForwardMode) {
                                if (TUIChatConfigs.getConfigs().getGeneralConfig().isShowRead()) {
                                }
                                this.unreadAudioText.setVisibility(8);
                                if (this.isReplyDetailMode) {
                                }
                                setReplyContent(tUIMessageBean);
                                setReactContent(tUIMessageBean);
                                if (this.presenter.isNeedShowTranslation()) {
                                }
                                setMessageAreaPadding();
                                layoutVariableViews(tUIMessageBean, i);
                            }
                            this.isReadText.setVisibility(8);
                            this.unreadAudioText.setVisibility(8);
                            if (this.isReplyDetailMode) {
                            }
                            setReplyContent(tUIMessageBean);
                            setReactContent(tUIMessageBean);
                            if (this.presenter.isNeedShowTranslation()) {
                            }
                            setMessageAreaPadding();
                            layoutVariableViews(tUIMessageBean, i);
                        }
                        this.msgArea.setBackgroundResource(TUIThemeManager.getAttrResId(((RecyclerView.ViewHolder) this).itemView.getContext(), R.attr.chat_bubble_other_bg));
                        this.statusImage.setVisibility(8);
                        if (!this.isForwardMode) {
                            if (!tUIMessageBean.isSelf()) {
                            }
                            relativeLayout = this.rightGroupLayout;
                            if (relativeLayout != null) {
                            }
                            this.msgContentLinear.setVisibility(0);
                            TextView textView22 = this.isReadText;
                            textView22.setTextColor(textView22.getResources().getColor(R.color.text_gray1));
                            this.isReadText.setOnClickListener(null);
                            if (!this.isForwardMode) {
                            }
                            this.isReadText.setVisibility(8);
                            this.unreadAudioText.setVisibility(8);
                            if (this.isReplyDetailMode) {
                            }
                            setReplyContent(tUIMessageBean);
                            setReactContent(tUIMessageBean);
                            if (this.presenter.isNeedShowTranslation()) {
                            }
                            setMessageAreaPadding();
                            layoutVariableViews(tUIMessageBean, i);
                        }
                        setGravity(true);
                        this.msgContentLinear.removeView(this.msgAreaAndReply);
                        this.msgContentLinear.addView(this.msgAreaAndReply);
                        relativeLayout = this.rightGroupLayout;
                        if (relativeLayout != null) {
                        }
                        this.msgContentLinear.setVisibility(0);
                        TextView textView222 = this.isReadText;
                        textView222.setTextColor(textView222.getResources().getColor(R.color.text_gray1));
                        this.isReadText.setOnClickListener(null);
                        if (!this.isForwardMode) {
                        }
                        this.isReadText.setVisibility(8);
                        this.unreadAudioText.setVisibility(8);
                        if (this.isReplyDetailMode) {
                        }
                        setReplyContent(tUIMessageBean);
                        setReactContent(tUIMessageBean);
                        if (this.presenter.isNeedShowTranslation()) {
                        }
                        setMessageAreaPadding();
                        layoutVariableViews(tUIMessageBean, i);
                    }
                    this.sendingProgress.setVisibility(8);
                    if (!this.isForwardMode) {
                        refreshBubble(tUIMessageBean);
                        if (this.onItemClickListener != null) {
                        }
                        if (tUIMessageBean.getStatus() != 3) {
                        }
                        if (!this.isForwardMode) {
                        }
                        setGravity(true);
                        this.msgContentLinear.removeView(this.msgAreaAndReply);
                        this.msgContentLinear.addView(this.msgAreaAndReply);
                        relativeLayout = this.rightGroupLayout;
                        if (relativeLayout != null) {
                        }
                        this.msgContentLinear.setVisibility(0);
                        TextView textView2222 = this.isReadText;
                        textView2222.setTextColor(textView2222.getResources().getColor(R.color.text_gray1));
                        this.isReadText.setOnClickListener(null);
                        if (!this.isForwardMode) {
                        }
                        this.isReadText.setVisibility(8);
                        this.unreadAudioText.setVisibility(8);
                        if (this.isReplyDetailMode) {
                        }
                        setReplyContent(tUIMessageBean);
                        setReactContent(tUIMessageBean);
                        if (this.presenter.isNeedShowTranslation()) {
                        }
                        setMessageAreaPadding();
                        layoutVariableViews(tUIMessageBean, i);
                    }
                    this.msgArea.setBackgroundResource(TUIThemeManager.getAttrResId(((RecyclerView.ViewHolder) this).itemView.getContext(), R.attr.chat_bubble_other_bg));
                    this.statusImage.setVisibility(8);
                    if (!this.isForwardMode) {
                    }
                    setGravity(true);
                    this.msgContentLinear.removeView(this.msgAreaAndReply);
                    this.msgContentLinear.addView(this.msgAreaAndReply);
                    relativeLayout = this.rightGroupLayout;
                    if (relativeLayout != null) {
                    }
                    this.msgContentLinear.setVisibility(0);
                    TextView textView22222 = this.isReadText;
                    textView22222.setTextColor(textView22222.getResources().getColor(R.color.text_gray1));
                    this.isReadText.setOnClickListener(null);
                    if (!this.isForwardMode) {
                    }
                    this.isReadText.setVisibility(8);
                    this.unreadAudioText.setVisibility(8);
                    if (this.isReplyDetailMode) {
                    }
                    setReplyContent(tUIMessageBean);
                    setReactContent(tUIMessageBean);
                    if (this.presenter.isNeedShowTranslation()) {
                    }
                    setMessageAreaPadding();
                    layoutVariableViews(tUIMessageBean, i);
                }
                this.usernameText.setVisibility(0);
                if (this.properties.getNameFontColor() != 0) {
                }
                if (this.properties.getNameFontSize() != 0) {
                }
                refreshBaseView(tUIMessageBean);
                if (!this.isForwardMode) {
                    if (!tUIMessageBean.isSelf()) {
                    }
                    if (!this.isForwardMode) {
                    }
                    this.msgArea.setBackgroundResource(TUIThemeManager.getAttrResId(((RecyclerView.ViewHolder) this).itemView.getContext(), R.attr.chat_bubble_other_bg));
                    this.statusImage.setVisibility(8);
                    if (!this.isForwardMode) {
                    }
                    setGravity(true);
                    this.msgContentLinear.removeView(this.msgAreaAndReply);
                    this.msgContentLinear.addView(this.msgAreaAndReply);
                    relativeLayout = this.rightGroupLayout;
                    if (relativeLayout != null) {
                    }
                    this.msgContentLinear.setVisibility(0);
                    TextView textView222222 = this.isReadText;
                    textView222222.setTextColor(textView222222.getResources().getColor(R.color.text_gray1));
                    this.isReadText.setOnClickListener(null);
                    if (!this.isForwardMode) {
                    }
                    this.isReadText.setVisibility(8);
                    this.unreadAudioText.setVisibility(8);
                    if (this.isReplyDetailMode) {
                    }
                    setReplyContent(tUIMessageBean);
                    setReactContent(tUIMessageBean);
                    if (this.presenter.isNeedShowTranslation()) {
                    }
                    setMessageAreaPadding();
                    layoutVariableViews(tUIMessageBean, i);
                }
                this.sendingProgress.setVisibility(8);
                if (!this.isForwardMode) {
                }
                this.msgArea.setBackgroundResource(TUIThemeManager.getAttrResId(((RecyclerView.ViewHolder) this).itemView.getContext(), R.attr.chat_bubble_other_bg));
                this.statusImage.setVisibility(8);
                if (!this.isForwardMode) {
                }
                setGravity(true);
                this.msgContentLinear.removeView(this.msgAreaAndReply);
                this.msgContentLinear.addView(this.msgAreaAndReply);
                relativeLayout = this.rightGroupLayout;
                if (relativeLayout != null) {
                }
                this.msgContentLinear.setVisibility(0);
                TextView textView2222222 = this.isReadText;
                textView2222222.setTextColor(textView2222222.getResources().getColor(R.color.text_gray1));
                this.isReadText.setOnClickListener(null);
                if (!this.isForwardMode) {
                }
                this.isReadText.setVisibility(8);
                this.unreadAudioText.setVisibility(8);
                if (this.isReplyDetailMode) {
                }
                setReplyContent(tUIMessageBean);
                setReactContent(tUIMessageBean);
                if (this.presenter.isNeedShowTranslation()) {
                }
                setMessageAreaPadding();
                layoutVariableViews(tUIMessageBean, i);
            }
            this.leftUserIcon.setVisibility(0);
            this.rightUserIcon.setVisibility(8);
            if (this.properties.getAvatar() == 0) {
            }
            if (this.properties.getAvatarRadius() == 0) {
            }
            if (this.properties.getAvatarSize() != null) {
                ViewGroup.LayoutParams layoutParams3 = this.leftUserIcon.getLayoutParams();
                layoutParams3.width = this.properties.getAvatarSize()[0];
                layoutParams3.height = this.properties.getAvatarSize()[1];
                this.leftUserIcon.setLayoutParams(layoutParams3);
                ViewGroup.LayoutParams layoutParams22 = this.rightUserIcon.getLayoutParams();
                layoutParams22.width = this.properties.getAvatarSize()[0];
                layoutParams22.height = this.properties.getAvatarSize()[1];
                this.rightUserIcon.setLayoutParams(layoutParams22);
            }
            if (!this.isForwardMode) {
                if (!tUIMessageBean.isSelf()) {
                }
                if (this.properties.getNameFontColor() != 0) {
                }
                if (this.properties.getNameFontSize() != 0) {
                }
                refreshBaseView(tUIMessageBean);
                if (!this.isForwardMode) {
                }
                this.sendingProgress.setVisibility(8);
                if (!this.isForwardMode) {
                }
                this.msgArea.setBackgroundResource(TUIThemeManager.getAttrResId(((RecyclerView.ViewHolder) this).itemView.getContext(), R.attr.chat_bubble_other_bg));
                this.statusImage.setVisibility(8);
                if (!this.isForwardMode) {
                }
                setGravity(true);
                this.msgContentLinear.removeView(this.msgAreaAndReply);
                this.msgContentLinear.addView(this.msgAreaAndReply);
                relativeLayout = this.rightGroupLayout;
                if (relativeLayout != null) {
                }
                this.msgContentLinear.setVisibility(0);
                TextView textView22222222 = this.isReadText;
                textView22222222.setTextColor(textView22222222.getResources().getColor(R.color.text_gray1));
                this.isReadText.setOnClickListener(null);
                if (!this.isForwardMode) {
                }
                this.isReadText.setVisibility(8);
                this.unreadAudioText.setVisibility(8);
                if (this.isReplyDetailMode) {
                }
                setReplyContent(tUIMessageBean);
                setReactContent(tUIMessageBean);
                if (this.presenter.isNeedShowTranslation()) {
                }
                setMessageAreaPadding();
                layoutVariableViews(tUIMessageBean, i);
            }
            this.usernameText.setVisibility(0);
            if (this.properties.getNameFontColor() != 0) {
            }
            if (this.properties.getNameFontSize() != 0) {
            }
            refreshBaseView(tUIMessageBean);
            if (!this.isForwardMode) {
            }
            this.sendingProgress.setVisibility(8);
            if (!this.isForwardMode) {
            }
            this.msgArea.setBackgroundResource(TUIThemeManager.getAttrResId(((RecyclerView.ViewHolder) this).itemView.getContext(), R.attr.chat_bubble_other_bg));
            this.statusImage.setVisibility(8);
            if (!this.isForwardMode) {
            }
            setGravity(true);
            this.msgContentLinear.removeView(this.msgAreaAndReply);
            this.msgContentLinear.addView(this.msgAreaAndReply);
            relativeLayout = this.rightGroupLayout;
            if (relativeLayout != null) {
            }
            this.msgContentLinear.setVisibility(0);
            TextView textView222222222 = this.isReadText;
            textView222222222.setTextColor(textView222222222.getResources().getColor(R.color.text_gray1));
            this.isReadText.setOnClickListener(null);
            if (!this.isForwardMode) {
            }
            this.isReadText.setVisibility(8);
            this.unreadAudioText.setVisibility(8);
            if (this.isReplyDetailMode) {
            }
            setReplyContent(tUIMessageBean);
            setReactContent(tUIMessageBean);
            if (this.presenter.isNeedShowTranslation()) {
            }
            setMessageAreaPadding();
            layoutVariableViews(tUIMessageBean, i);
        } catch (Exception e) {
            LogUtil.INSTANCE.e("eTag", e.getMessage(), false);
        }
    }

    public void onRecycled() {
        SelectTextHelper selectTextHelper = this.selectableTextHelper;
        if (selectTextHelper != null) {
            selectTextHelper.destroy();
        }
    }

    protected void refreshBaseView(TUIMessageBean tUIMessageBean) {
        String checkString;
        if (checkStrange()) {
            if (tUIMessageBean.isSelf()) {
                checkString = this.onItemDateListener.checkString("avatarMy");
            } else {
                checkString = this.onItemDateListener.checkString("avatarReceive");
            }
            if (!TextUtils.isEmpty(checkString)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(checkString);
                if (!this.isForwardMode && !this.isReplyDetailMode) {
                    if (tUIMessageBean.isSelf()) {
                        this.rightUserIcon.setIconUrls(arrayList);
                        return;
                    } else {
                        this.leftUserIcon.setIconUrls(arrayList);
                        return;
                    }
                }
                this.leftUserIcon.setIconUrls(arrayList);
                return;
            }
            this.rightUserIcon.setIconUrls(null);
            this.leftUserIcon.setIconUrls(null);
            return;
        }
        if (!TextUtils.isEmpty(tUIMessageBean.getFaceUrl())) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(tUIMessageBean.getFaceUrl());
            if (!this.isForwardMode && !this.isReplyDetailMode) {
                if (tUIMessageBean.isSelf()) {
                    this.rightUserIcon.setIconUrls(arrayList2);
                    return;
                } else {
                    this.leftUserIcon.setIconUrls(arrayList2);
                    return;
                }
            }
            this.leftUserIcon.setIconUrls(arrayList2);
            return;
        }
        this.rightUserIcon.setIconUrls(null);
        this.leftUserIcon.setIconUrls(null);
    }

    protected void refreshBubble(TUIMessageBean tUIMessageBean) {
        int i;
        if (checkStrange()) {
            if (tUIMessageBean.isSelf()) {
                i = R.drawable.strange_bubble_right;
            } else {
                i = R.drawable.strange_bubble_left;
            }
            this.msgArea.setBackground(androidx.core.content.a.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), i));
            return;
        }
        if (tUIMessageBean.isSelf()) {
            if (this.properties.getRightBubble() != null && this.properties.getRightBubble().getConstantState() != null) {
                this.msgArea.setBackground(this.properties.getRightBubble().getConstantState().newDrawable());
                return;
            } else {
                this.msgArea.setBackgroundResource(TUIThemeManager.getAttrResId(((RecyclerView.ViewHolder) this).itemView.getContext(), R.attr.chat_bubble_self_bg));
                return;
            }
        }
        if (this.properties.getLeftBubble() != null && this.properties.getLeftBubble().getConstantState() != null) {
            this.msgArea.setBackground(this.properties.getLeftBubble().getConstantState().newDrawable());
        } else {
            this.msgArea.setBackgroundResource(TUIThemeManager.getAttrResId(((RecyclerView.ViewHolder) this).itemView.getContext(), R.attr.chat_bubble_other_bg));
        }
    }

    public void resetSelectableText() {
        SelectTextHelper selectTextHelper = this.selectableTextHelper;
        if (selectTextHelper != null) {
            selectTextHelper.reset();
        }
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
        int dimensionPixelSize = ((RecyclerView.ViewHolder) this).itemView.getResources().getDimensionPixelSize(R.dimen.chat_message_area_padding_left_right);
        int dimensionPixelSize2 = ((RecyclerView.ViewHolder) this).itemView.getResources().getDimensionPixelSize(R.dimen.chat_message_area_padding_top_bottom);
        this.msgArea.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
    }

    public void setPresenter(ChatPresenter chatPresenter) {
        this.presenter = chatPresenter;
    }

    protected void setSelectableTextHelper(final TUIMessageBean tUIMessageBean, TextView textView, final int i, boolean z) {
        SelectTextHelper selectTextHelper = this.selectableTextHelper;
        if (selectTextHelper != null) {
            selectTextHelper.destroy();
        }
        SelectTextHelper build = new SelectTextHelper.Builder(textView).setCursorHandleColor(ServiceInitializer.getAppContext().getResources().getColor(R.color.font_blue)).setCursorHandleSizeInDp(18.0f).setSelectedColor(ServiceInitializer.getAppContext().getResources().getColor(R.color.test_blue)).setSelectAll(true).setIsEmoji(z).setScrollShow(false).setSelectedAllNoPop(true).setMagnifierShow(false).build();
        this.selectableTextHelper = build;
        build.setSelectListener(new SelectTextHelper.OnSelectListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder.15
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.SelectTextHelper.OnSelectListener
            public void onClick(View view) {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.SelectTextHelper.OnSelectListener
            public void onClickUrl(String str) {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.SelectTextHelper.OnSelectListener
            public void onDismiss() {
                TUIMessageBean tUIMessageBean2 = tUIMessageBean;
                tUIMessageBean2.setSelectText(tUIMessageBean2.getExtra());
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.SelectTextHelper.OnSelectListener
            public void onDismissCustomPop() {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.SelectTextHelper.OnSelectListener
            public void onLongClick(View view) {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.SelectTextHelper.OnSelectListener
            public void onReset() {
                tUIMessageBean.setSelectText(null);
                TUIMessageBean tUIMessageBean2 = tUIMessageBean;
                tUIMessageBean2.setSelectText(tUIMessageBean2.getExtra());
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.SelectTextHelper.OnSelectListener
            public void onScrolling() {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.SelectTextHelper.OnSelectListener
            public void onSelectAllShowCustomPop() {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.SelectTextHelper.OnSelectListener
            public void onTextSelected(CharSequence charSequence) {
                String charSequence2 = charSequence.toString();
                tUIMessageBean.setSelectText(charSequence2);
                TUIChatLog.d("TextMessageHolder", "onTextSelected selectedText = " + charSequence2);
                MessageContentHolder messageContentHolder = MessageContentHolder.this;
                OnItemClickListener onItemClickListener = messageContentHolder.onItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onTextSelected(messageContentHolder.msgArea, i, tUIMessageBean);
                }
            }
        });
    }

    protected void setTranslationContent(final TUIMessageBean tUIMessageBean, final int i) {
        int translationStatus = tUIMessageBean.getTranslationStatus();
        if (translationStatus == 3) {
            this.translationContentFrameLayout.setVisibility(0);
            stopTranslationLoading();
            LinearLayout linearLayout = this.translationResultLayout;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            TextView textView = (TextView) this.translationContentFrameLayout.findViewById(R.id.translate_tv);
            if (this.properties.getChatContextFontSize() != 0) {
                textView.setTextSize(this.properties.getChatContextFontSize());
            }
            FaceManager.handlerEmojiText(textView, tUIMessageBean.getTranslation(), false);
            this.translationContentFrameLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder.16
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
            this.translationContentFrameLayout.setVisibility(0);
            startTranslationLoading();
            LinearLayout linearLayout2 = this.translationResultLayout;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            this.translationContentFrameLayout.setOnLongClickListener(null);
            return;
        }
        stopTranslationLoading();
        this.translationContentFrameLayout.setVisibility(8);
        this.translationContentFrameLayout.setOnLongClickListener(null);
    }

    public void startShowUnread(TUIMessageBean tUIMessageBean) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("messageBean", tUIMessageBean);
        bundle.putSerializable(TUIChatConstants.CHAT_INFO, this.presenter.getChatInfo());
        TUICore.startActivity("MessageReceiptDetailActivity", bundle);
    }
}
