package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.util.DateTimeUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanActivity;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class VideoMessageHolder extends MessageContentHolder {
    private static final int DEFAULT_MAX_SIZE = 540;
    private static final int DEFAULT_RADIUS = 10;
    private ImageView contentImage;
    private final List<String> downloadEles;
    private TextView videoDurationText;
    private ImageView videoPlayBtn;

    public VideoMessageHolder(View view) {
        super(view);
        this.downloadEles = new ArrayList();
        this.contentImage = (ImageView) view.findViewById(R.id.content_image_iv);
        this.videoPlayBtn = (ImageView) view.findViewById(R.id.video_play_btn);
        this.videoDurationText = (TextView) view.findViewById(R.id.video_duration_tv);
    }

    private ViewGroup.LayoutParams getImageParams(ViewGroup.LayoutParams layoutParams, VideoMessageBean videoMessageBean) {
        if (videoMessageBean.getImgWidth() != 0 && videoMessageBean.getImgHeight() != 0) {
            if (videoMessageBean.getImgWidth() > videoMessageBean.getImgHeight()) {
                layoutParams.width = DEFAULT_MAX_SIZE;
                layoutParams.height = (videoMessageBean.getImgHeight() * DEFAULT_MAX_SIZE) / videoMessageBean.getImgWidth();
            } else {
                layoutParams.width = (videoMessageBean.getImgWidth() * DEFAULT_MAX_SIZE) / videoMessageBean.getImgHeight();
                layoutParams.height = DEFAULT_MAX_SIZE;
            }
            return layoutParams;
        }
        layoutParams.width = DEFAULT_MAX_SIZE;
        layoutParams.height = DEFAULT_MAX_SIZE;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$performVideo$0(VideoMessageBean videoMessageBean, int i, View view) {
        showDialog(videoMessageBean, i, view, false, true, videoMessageBean.isSelf());
        return false;
    }

    private void performVideo(final VideoMessageBean videoMessageBean, final int i) {
        ImageView imageView = this.contentImage;
        imageView.setLayoutParams(getImageParams(imageView.getLayoutParams(), videoMessageBean));
        this.videoPlayBtn.setVisibility(0);
        this.videoDurationText.setVisibility(0);
        if (!TextUtils.isEmpty(videoMessageBean.getDataPath())) {
            GlideEngine.loadCornerImageWithoutPlaceHolder(this.contentImage, videoMessageBean.getDataPath(), null, 10.0f);
        } else {
            GlideEngine.clear(this.contentImage);
            synchronized (this.downloadEles) {
                try {
                    if (!this.downloadEles.contains(videoMessageBean.getSnapshotUUID())) {
                        this.downloadEles.add(videoMessageBean.getSnapshotUUID());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            final String str = TUIConfig.getImageDownloadDir() + videoMessageBean.getSnapshotUUID();
            videoMessageBean.downloadSnapshot(str, new VideoMessageBean.VideoDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.VideoMessageHolder.1
                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
                public void onError(int i2, String str2) {
                    VideoMessageHolder.this.downloadEles.remove(videoMessageBean.getSnapshotUUID());
                    TUIChatLog.e("MessageAdapter video getImage", i2 + ":" + str2);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
                public void onProgress(long j, long j2) {
                    TUIChatLog.i("downloadSnapshot progress current:", j + ", total:" + j2);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
                public void onSuccess() {
                    VideoMessageHolder.this.downloadEles.remove(videoMessageBean.getSnapshotUUID());
                    videoMessageBean.setDataPath(str);
                    GlideEngine.loadCornerImageWithoutPlaceHolder(VideoMessageHolder.this.contentImage, videoMessageBean.getDataPath(), null, 10.0f);
                }
            });
        }
        this.videoDurationText.setText(DateTimeUtil.formatSecondsTo00(videoMessageBean.getDuration()));
        File file = new File(TUIConfig.getVideoDownloadDir() + videoMessageBean.getVideoUUID());
        if (videoMessageBean.getStatus() == 2) {
            this.statusImage.setVisibility(8);
            this.sendingProgress.setVisibility(8);
        } else if (file.exists() && videoMessageBean.getStatus() == 1) {
            this.statusImage.setVisibility(8);
            this.sendingProgress.setVisibility(0);
        } else if (videoMessageBean.getStatus() == 3) {
            this.statusImage.setVisibility(0);
            this.sendingProgress.setVisibility(8);
        }
        if (this.isMultiSelectMode) {
            this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.VideoMessageHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OnItemClickListener onItemClickListener = VideoMessageHolder.this.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onMessageClick(view, i, videoMessageBean);
                    }
                }
            });
            return;
        }
        this.videoPlayBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.VideoMessageHolder.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(ServiceInitializer.getAppContext(), (Class<?>) ImageVideoScanActivity.class);
                intent.addFlags(268435456);
                VideoMessageHolder videoMessageHolder = VideoMessageHolder.this;
                if (videoMessageHolder.isForwardMode && videoMessageHolder.getDataSource() != null && !VideoMessageHolder.this.getDataSource().isEmpty()) {
                    intent.putExtra(TUIChatConstants.OPEN_MESSAGES_SCAN_FORWARD, (Serializable) VideoMessageHolder.this.getDataSource());
                }
                intent.putExtra(TUIChatConstants.OPEN_MESSAGE_SCAN, videoMessageBean);
                intent.putExtra(TUIChatConstants.FORWARD_MODE, VideoMessageHolder.this.isForwardMode);
                ServiceInitializer.getAppContext().startActivity(intent);
            }
        });
        if (videoMessageBean.getMessageReactBean() == null || videoMessageBean.getMessageReactBean().getReactSize() <= 0) {
            this.msgArea.setBackground(null);
            this.msgArea.setPadding(0, 0, 0, 0);
        }
        this.contentImage.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.e
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean lambda$performVideo$0;
                lambda$performVideo$0 = VideoMessageHolder.this.lambda$performVideo$0(videoMessageBean, i, view);
                return lambda$performVideo$0;
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void clearHighLightBackground() {
        Drawable drawable = this.contentImage.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter(null);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.message_adapter_content_image;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i) {
        performVideo((VideoMessageBean) tUIMessageBean, i);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void setHighLightBackground(int i) {
        Drawable drawable = this.contentImage.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        }
    }
}
