package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c5.g;
import com.bumptech.glide.request.target.j;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.util.ImageUtil;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.QuoteMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.FaceReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.FileReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.ImageReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.MergeReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.SoundReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TextReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.VideoReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.List;
import m4.a;
import o4.q;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class QuoteMessageHolder extends TextMessageHolder {
    protected final List<String> downloadEles;
    private final FrameLayout fileFrame;
    private final ImageView fileIconIv;
    private final TextView fileNameTv;
    private final FrameLayout imageFrame;
    private final ImageView imageIv;
    protected String mImagePath;
    private final ImageView playIv;
    private FrameLayout quoteContentFrameLayout;
    private final TextView senderNameTv;
    private final FrameLayout soundFrame;
    private final ImageView soundIconIv;
    private final TextView soundTimeTv;
    private final FrameLayout textFrame;
    private final TextView textTv;

    public QuoteMessageHolder(View view) {
        super(view);
        this.downloadEles = new ArrayList();
        this.mImagePath = null;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.quote_content_fl);
        this.quoteContentFrameLayout = frameLayout;
        frameLayout.setVisibility(0);
        LayoutInflater.from(view.getContext()).inflate(R.layout.minimalist_quote_message_content_layout, this.quoteContentFrameLayout);
        this.senderNameTv = (TextView) this.quoteContentFrameLayout.findViewById(R.id.sender_name_tv);
        this.textFrame = (FrameLayout) this.quoteContentFrameLayout.findViewById(R.id.text_msg_area);
        this.textTv = (TextView) this.quoteContentFrameLayout.findViewById(R.id.msg_abstract_tv);
        this.imageFrame = (FrameLayout) this.quoteContentFrameLayout.findViewById(R.id.image_video_msg_area);
        this.imageIv = (ImageView) this.quoteContentFrameLayout.findViewById(R.id.msg_image_iv);
        this.playIv = (ImageView) this.quoteContentFrameLayout.findViewById(R.id.msg_play_iv);
        this.fileFrame = (FrameLayout) this.quoteContentFrameLayout.findViewById(R.id.file_msg_area);
        this.fileNameTv = (TextView) this.quoteContentFrameLayout.findViewById(R.id.file_name_tv);
        this.fileIconIv = (ImageView) this.quoteContentFrameLayout.findViewById(R.id.file_icon_iv);
        this.soundFrame = (FrameLayout) this.quoteContentFrameLayout.findViewById(R.id.sound_msg_area);
        this.soundTimeTv = (TextView) this.quoteContentFrameLayout.findViewById(R.id.sound_msg_time_tv);
        this.soundIconIv = (ImageView) this.quoteContentFrameLayout.findViewById(R.id.sound_msg_icon_iv);
    }

    private void performFile(FileReplyQuoteBean fileReplyQuoteBean) {
        this.fileFrame.setVisibility(0);
        this.fileNameTv.setText(fileReplyQuoteBean.getFileName());
    }

    private void performImage(TUIReplyQuoteBean tUIReplyQuoteBean) {
        this.imageFrame.setVisibility(0);
        final int dip2px = ScreenUtil.dip2px(1.92f);
        if (tUIReplyQuoteBean instanceof FaceReplyQuoteBean) {
            FaceReplyQuoteBean faceReplyQuoteBean = (FaceReplyQuoteBean) tUIReplyQuoteBean;
            String str = new String(faceReplyQuoteBean.getData());
            ViewGroup.LayoutParams layoutParams = this.imageIv.getLayoutParams();
            if (layoutParams != null) {
                int dimensionPixelSize = ((RecyclerView.ViewHolder) this).itemView.getResources().getDimensionPixelSize(R.dimen.reply_message_image_size);
                layoutParams.width = dimensionPixelSize;
                layoutParams.height = dimensionPixelSize;
                this.imageIv.setLayoutParams(layoutParams);
            }
            FaceManager.loadFace(faceReplyQuoteBean.getIndex(), str, this.imageIv);
            return;
        }
        if (tUIReplyQuoteBean instanceof ImageReplyQuoteBean) {
            final ImageMessageBean imageMessageBean = (ImageMessageBean) tUIReplyQuoteBean.getMessageBean();
            ImageView imageView = this.imageIv;
            imageView.setLayoutParams(getImageParams(imageView.getLayoutParams(), imageMessageBean.getImgWidth(), imageMessageBean.getImgHeight()));
            List<ImageMessageBean.ImageBean> imageBeanList = imageMessageBean.getImageBeanList();
            String dataPath = imageMessageBean.getDataPath();
            String originImagePath = TUIChatUtils.getOriginImagePath(imageMessageBean);
            if (!TextUtils.isEmpty(originImagePath)) {
                dataPath = originImagePath;
            }
            if (!TextUtils.isEmpty(dataPath)) {
                GlideEngine.loadCornerImageWithoutPlaceHolder(this.imageIv, dataPath, null, dip2px);
                return;
            }
            GlideEngine.clear(this.imageIv);
            for (int i = 0; i < imageBeanList.size(); i++) {
                final ImageMessageBean.ImageBean imageBean = imageBeanList.get(i);
                if (imageBean.getType() == 1) {
                    synchronized (this.downloadEles) {
                        try {
                            if (!this.downloadEles.contains(imageBean.getUUID())) {
                                this.downloadEles.add(imageBean.getUUID());
                                final String generateImagePath = ImageUtil.generateImagePath(imageBean.getUUID(), 1);
                                if (!generateImagePath.equals(this.mImagePath)) {
                                    GlideEngine.clear(this.imageIv);
                                }
                                imageBean.downloadImage(generateImagePath, new ImageMessageBean.ImageBean.ImageDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.QuoteMessageHolder.3
                                    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.ImageDownloadCallback
                                    public void onError(int i2, String str2) {
                                        QuoteMessageHolder.this.downloadEles.remove(imageBean.getUUID());
                                        TUIChatLog.e("MessageAdapter img getImage", i2 + ":" + str2);
                                    }

                                    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.ImageDownloadCallback
                                    public void onProgress(long j, long j2) {
                                        TUIChatLog.i("downloadImage progress current:", j + ", total:" + j2);
                                    }

                                    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.ImageDownloadCallback
                                    public void onSuccess() {
                                        QuoteMessageHolder.this.downloadEles.remove(imageBean.getUUID());
                                        imageMessageBean.setDataPath(generateImagePath);
                                        GlideEngine.loadCornerImageWithoutPlaceHolder(QuoteMessageHolder.this.imageIv, imageMessageBean.getDataPath(), new g() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.QuoteMessageHolder.3.1
                                            public boolean onLoadFailed(q qVar, Object obj, j jVar, boolean z) {
                                                QuoteMessageHolder.this.mImagePath = null;
                                                return false;
                                            }

                                            public boolean onResourceReady(Object obj, Object obj2, j jVar, a aVar, boolean z) {
                                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                                QuoteMessageHolder.this.mImagePath = generateImagePath;
                                                return false;
                                            }
                                        }, dip2px);
                                    }
                                });
                            }
                        } finally {
                        }
                    }
                    return;
                }
            }
            return;
        }
        if (tUIReplyQuoteBean instanceof VideoReplyQuoteBean) {
            final VideoMessageBean videoMessageBean = (VideoMessageBean) tUIReplyQuoteBean.getMessageBean();
            ViewGroup.LayoutParams imageParams = getImageParams(this.imageIv.getLayoutParams(), videoMessageBean.getImgWidth(), videoMessageBean.getImgHeight());
            this.imageIv.setLayoutParams(imageParams);
            this.playIv.setLayoutParams(imageParams);
            this.playIv.setVisibility(0);
            if (!TextUtils.isEmpty(videoMessageBean.getDataPath())) {
                GlideEngine.loadCornerImageWithoutPlaceHolder(this.imageIv, videoMessageBean.getDataPath(), null, dip2px);
                return;
            }
            GlideEngine.clear(this.imageIv);
            synchronized (this.downloadEles) {
                try {
                    if (!this.downloadEles.contains(videoMessageBean.getSnapshotUUID())) {
                        this.downloadEles.add(videoMessageBean.getSnapshotUUID());
                    }
                } finally {
                }
            }
            final String str2 = TUIConfig.getImageDownloadDir() + videoMessageBean.getSnapshotUUID();
            videoMessageBean.downloadSnapshot(str2, new VideoMessageBean.VideoDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.QuoteMessageHolder.4
                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
                public void onError(int i2, String str3) {
                    QuoteMessageHolder.this.downloadEles.remove(videoMessageBean.getSnapshotUUID());
                    TUIChatLog.e("MessageAdapter video getImage", i2 + ":" + str3);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
                public void onProgress(long j, long j2) {
                    TUIChatLog.i("downloadSnapshot progress current:", j + ", total:" + j2);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
                public void onSuccess() {
                    QuoteMessageHolder.this.downloadEles.remove(videoMessageBean.getSnapshotUUID());
                    videoMessageBean.setDataPath(str2);
                    GlideEngine.loadCornerImageWithoutPlaceHolder(QuoteMessageHolder.this.imageIv, videoMessageBean.getDataPath(), null, dip2px);
                }
            });
        }
    }

    private void performMsgAbstract(QuoteMessageBean quoteMessageBean) {
        resetAll();
        TUIMessageBean originMessageBean = quoteMessageBean.getOriginMessageBean();
        TUIReplyQuoteBean replyQuoteBean = quoteMessageBean.getReplyQuoteBean();
        if (originMessageBean != null) {
            performQuote(replyQuoteBean, quoteMessageBean);
        } else {
            performNotFound(replyQuoteBean, quoteMessageBean);
        }
    }

    private void performNotFound(TUIReplyQuoteBean tUIReplyQuoteBean, QuoteMessageBean quoteMessageBean) {
        String msgTypeStr = ChatMessageParser.getMsgTypeStr(tUIReplyQuoteBean.getMessageType());
        String defaultAbstract = tUIReplyQuoteBean.getDefaultAbstract();
        if (ChatMessageParser.isFileType(tUIReplyQuoteBean.getMessageType())) {
            defaultAbstract = "";
        }
        performTextMessage(msgTypeStr + defaultAbstract);
    }

    private void performQuote(TUIReplyQuoteBean tUIReplyQuoteBean, QuoteMessageBean quoteMessageBean) {
        String originMsgAbstract;
        boolean z = tUIReplyQuoteBean instanceof TextReplyQuoteBean;
        if (!z && !(tUIReplyQuoteBean instanceof MergeReplyQuoteBean)) {
            if (tUIReplyQuoteBean instanceof FileReplyQuoteBean) {
                performFile((FileReplyQuoteBean) tUIReplyQuoteBean);
                return;
            }
            if (tUIReplyQuoteBean instanceof SoundReplyQuoteBean) {
                performSound((SoundReplyQuoteBean) tUIReplyQuoteBean);
                return;
            } else {
                if ((tUIReplyQuoteBean instanceof ImageReplyQuoteBean) || (tUIReplyQuoteBean instanceof VideoReplyQuoteBean) || (tUIReplyQuoteBean instanceof FaceReplyQuoteBean)) {
                    performImage(tUIReplyQuoteBean);
                    return;
                }
                return;
            }
        }
        if (z) {
            originMsgAbstract = ((TextReplyQuoteBean) tUIReplyQuoteBean).getText();
        } else {
            originMsgAbstract = quoteMessageBean.getOriginMsgAbstract();
        }
        performTextMessage(originMsgAbstract);
    }

    private void performSound(SoundReplyQuoteBean soundReplyQuoteBean) {
        this.soundFrame.setVisibility(0);
        this.soundTimeTv.setText(soundReplyQuoteBean.getDuring() + "''");
    }

    private void performTextMessage(String str) {
        this.textFrame.setVisibility(0);
        FaceManager.handlerEmojiText(this.textTv, str, false);
    }

    private void resetAll() {
        this.textFrame.setVisibility(8);
        this.imageFrame.setVisibility(8);
        this.fileFrame.setVisibility(8);
        this.soundFrame.setVisibility(8);
        this.playIv.setVisibility(8);
    }

    protected ViewGroup.LayoutParams getImageParams(ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (i != 0 && i2 != 0) {
            int dimensionPixelSize = ((RecyclerView.ViewHolder) this).itemView.getResources().getDimensionPixelSize(R.dimen.reply_message_image_size);
            if (i > i2) {
                layoutParams.width = dimensionPixelSize;
                layoutParams.height = (dimensionPixelSize * i2) / i;
            } else {
                layoutParams.width = (i * dimensionPixelSize) / i2;
                layoutParams.height = dimensionPixelSize;
            }
        }
        return layoutParams;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.TextMessageHolder, com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(TUIMessageBean tUIMessageBean, final int i) {
        this.extraInfoArea.setVisibility(0);
        tUIMessageBean.setSelectText(tUIMessageBean.getExtra());
        final QuoteMessageBean quoteMessageBean = (QuoteMessageBean) tUIMessageBean;
        String extra = quoteMessageBean.getContentMessageBean().getExtra();
        FaceManager.handlerEmojiText(this.timeInLineTextLayout.getTextView(), extra, false);
        String originMsgSender = quoteMessageBean.getOriginMsgSender();
        this.senderNameTv.setText(originMsgSender + ": ");
        performMsgAbstract(quoteMessageBean);
        this.msgArea.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.QuoteMessageHolder.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.quoteContentFrameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.QuoteMessageHolder.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnItemClickListener onItemClickListener = QuoteMessageHolder.this.onItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onReplyMessageClick(view, i, quoteMessageBean);
                }
            }
        });
        if (!this.isForwardMode && !this.isMessageDetailMode) {
            if (!TextUtils.isEmpty(extra)) {
                FaceManager.handlerEmojiText(this.timeInLineTextLayout.getTextView(), extra, false);
            }
            if (this.floatMode) {
                this.quoteContentFrameLayout.setVisibility(8);
            }
        }
    }
}
