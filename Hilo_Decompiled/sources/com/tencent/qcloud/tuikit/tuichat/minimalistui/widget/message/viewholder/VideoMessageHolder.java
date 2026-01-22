package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanActivity;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class VideoMessageHolder extends ImageMessageHolder {
    public VideoMessageHolder(View view) {
        super(view);
    }

    private ViewGroup.LayoutParams getImageParams(ViewGroup.LayoutParams layoutParams, VideoMessageBean videoMessageBean) {
        if (videoMessageBean.getImgWidth() != 0 && videoMessageBean.getImgHeight() != 0) {
            if (videoMessageBean.getImgWidth() > videoMessageBean.getImgHeight()) {
                layoutParams.width = 540;
                layoutParams.height = (videoMessageBean.getImgHeight() * 540) / videoMessageBean.getImgWidth();
            } else {
                layoutParams.width = (videoMessageBean.getImgWidth() * 540) / videoMessageBean.getImgHeight();
                layoutParams.height = 540;
            }
            return layoutParams;
        }
        layoutParams.width = 540;
        layoutParams.height = 540;
        return layoutParams;
    }

    private void performVideo(final VideoMessageBean videoMessageBean, final int i) {
        AppCompatImageView appCompatImageView = this.contentImage;
        appCompatImageView.setLayoutParams(getImageParams(appCompatImageView.getLayoutParams(), videoMessageBean));
        this.videoPlayBtn.setVisibility(0);
        if (!TextUtils.isEmpty(videoMessageBean.getDataPath())) {
            GlideEngine.loadCornerImageWithoutPlaceHolder(this.contentImage, videoMessageBean.getDataPath(), null, 0.0f);
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
            videoMessageBean.downloadSnapshot(str, new VideoMessageBean.VideoDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.VideoMessageHolder.1
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
                    GlideEngine.loadCornerImageWithoutPlaceHolder(VideoMessageHolder.this.contentImage, videoMessageBean.getDataPath(), null, 0.0f);
                }
            });
        }
        if (this.isMultiSelectMode) {
            this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.VideoMessageHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OnItemClickListener onItemClickListener = VideoMessageHolder.this.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onMessageClick(view, i, videoMessageBean);
                    }
                }
            });
        } else {
            this.videoPlayBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.VideoMessageHolder.3
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
        }
        setImagePadding(videoMessageBean);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.ImageMessageHolder, com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder
    public void clearHighLightBackground() {
        Drawable drawable = this.contentImage.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter(null);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.ImageMessageHolder, com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i) {
        performVideo((VideoMessageBean) tUIMessageBean, i);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.ImageMessageHolder, com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder
    public void setHighLightBackground(int i) {
        Drawable drawable = this.contentImage.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        }
    }
}
