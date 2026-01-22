package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import c5.g;
import com.bumptech.glide.request.target.j;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.component.RoundCornerImageView;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.util.ImageUtil;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanActivity;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.TimeInLineTextLayout;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import m4.a;
import o4.q;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ImageMessageHolder extends MessageContentHolder {
    protected static final int DEFAULT_MAX_SIZE = 540;
    protected static final int DEFAULT_RADIUS = 0;
    public RoundCornerImageView contentImage;
    protected final List<String> downloadEles;
    private String mImagePath;
    protected ImageView videoPlayBtn;

    public ImageMessageHolder(View view) {
        super(view);
        this.downloadEles = new ArrayList();
        this.mImagePath = null;
        this.contentImage = (RoundCornerImageView) view.findViewById(R.id.content_image_iv);
        this.videoPlayBtn = (ImageView) view.findViewById(R.id.video_play_btn);
        TimeInLineTextLayout timeInLineTextLayout = (TimeInLineTextLayout) view.findViewById(R.id.image_msg_time_in_line_text);
        this.timeInLineTextLayout = timeInLineTextLayout;
        timeInLineTextLayout.setTimeColor(-1);
    }

    private ViewGroup.LayoutParams getImageParams(ViewGroup.LayoutParams layoutParams, ImageMessageBean imageMessageBean) {
        if (imageMessageBean.getImgWidth() != 0 && imageMessageBean.getImgHeight() != 0) {
            if (imageMessageBean.getImgWidth() > imageMessageBean.getImgHeight()) {
                layoutParams.width = DEFAULT_MAX_SIZE;
                layoutParams.height = (imageMessageBean.getImgHeight() * DEFAULT_MAX_SIZE) / imageMessageBean.getImgWidth();
            } else {
                layoutParams.width = (imageMessageBean.getImgWidth() * DEFAULT_MAX_SIZE) / imageMessageBean.getImgHeight();
                layoutParams.height = DEFAULT_MAX_SIZE;
            }
            return layoutParams;
        }
        layoutParams.width = DEFAULT_MAX_SIZE;
        layoutParams.height = DEFAULT_MAX_SIZE;
        return layoutParams;
    }

    private void performImage(final ImageMessageBean imageMessageBean, final int i) {
        AppCompatImageView appCompatImageView = this.contentImage;
        appCompatImageView.setLayoutParams(getImageParams(appCompatImageView.getLayoutParams(), imageMessageBean));
        this.videoPlayBtn.setVisibility(8);
        List<ImageMessageBean.ImageBean> imageBeanList = imageMessageBean.getImageBeanList();
        String dataPath = imageMessageBean.getDataPath();
        String originImagePath = TUIChatUtils.getOriginImagePath(imageMessageBean);
        if (!TextUtils.isEmpty(originImagePath)) {
            dataPath = originImagePath;
        }
        if (!TextUtils.isEmpty(dataPath)) {
            GlideEngine.loadCornerImageWithoutPlaceHolder(this.contentImage, dataPath, null, 0.0f);
        } else {
            GlideEngine.clear(this.contentImage);
            int i2 = 0;
            while (true) {
                if (i2 >= imageBeanList.size()) {
                    break;
                }
                final ImageMessageBean.ImageBean imageBean = imageBeanList.get(i2);
                if (imageBean.getType() == 1) {
                    synchronized (this.downloadEles) {
                        try {
                            if (!this.downloadEles.contains(imageBean.getUUID())) {
                                this.downloadEles.add(imageBean.getUUID());
                                final String generateImagePath = ImageUtil.generateImagePath(imageBean.getUUID(), 1);
                                if (!generateImagePath.equals(this.mImagePath)) {
                                    GlideEngine.clear(this.contentImage);
                                }
                                imageBean.downloadImage(generateImagePath, new ImageMessageBean.ImageBean.ImageDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.ImageMessageHolder.1
                                    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.ImageDownloadCallback
                                    public void onError(int i3, String str) {
                                        ImageMessageHolder.this.downloadEles.remove(imageBean.getUUID());
                                        TUIChatLog.e("MessageAdapter img getImage", i3 + ":" + str);
                                    }

                                    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.ImageDownloadCallback
                                    public void onProgress(long j, long j2) {
                                        TUIChatLog.i("downloadImage progress current:", j + ", total:" + j2);
                                    }

                                    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.ImageDownloadCallback
                                    public void onSuccess() {
                                        ImageMessageHolder.this.downloadEles.remove(imageBean.getUUID());
                                        imageMessageBean.setDataPath(generateImagePath);
                                        GlideEngine.loadCornerImageWithoutPlaceHolder(ImageMessageHolder.this.contentImage, imageMessageBean.getDataPath(), new g() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.ImageMessageHolder.1.1
                                            public boolean onLoadFailed(q qVar, Object obj, j jVar, boolean z) {
                                                ImageMessageHolder.this.mImagePath = null;
                                                return false;
                                            }

                                            public boolean onResourceReady(Object obj, Object obj2, j jVar, a aVar, boolean z) {
                                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                                ImageMessageHolder.this.mImagePath = generateImagePath;
                                                return false;
                                            }
                                        }, 0.0f);
                                    }
                                });
                            }
                        } finally {
                        }
                    }
                } else {
                    i2++;
                }
            }
        }
        if (this.isMultiSelectMode) {
            this.contentImage.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.ImageMessageHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OnItemClickListener onItemClickListener = ImageMessageHolder.this.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onMessageClick(view, i, imageMessageBean);
                    }
                }
            });
        } else {
            this.contentImage.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.ImageMessageHolder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent(ServiceInitializer.getAppContext(), (Class<?>) ImageVideoScanActivity.class);
                    intent.addFlags(268435456);
                    ImageMessageHolder imageMessageHolder = ImageMessageHolder.this;
                    if (imageMessageHolder.isForwardMode && imageMessageHolder.getDataSource() != null && !ImageMessageHolder.this.getDataSource().isEmpty()) {
                        intent.putExtra(TUIChatConstants.OPEN_MESSAGES_SCAN_FORWARD, (Serializable) ImageMessageHolder.this.getDataSource());
                    }
                    intent.putExtra(TUIChatConstants.OPEN_MESSAGE_SCAN, imageMessageBean);
                    intent.putExtra(TUIChatConstants.FORWARD_MODE, ImageMessageHolder.this.isForwardMode);
                    ServiceInitializer.getAppContext().startActivity(intent);
                }
            });
            this.contentImage.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.ImageMessageHolder.4
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    ImageMessageHolder imageMessageHolder = ImageMessageHolder.this;
                    OnItemClickListener onItemClickListener = imageMessageHolder.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onMessageLongClick(imageMessageHolder.msgArea, i, imageMessageBean);
                        return true;
                    }
                    return true;
                }
            });
        }
        setImagePadding(imageMessageBean);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder
    public void clearHighLightBackground() {
        Drawable drawable = this.contentImage.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter(null);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.minimalist_message_adapter_content_image;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i) {
        performImage((ImageMessageBean) tUIMessageBean, i);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder
    protected void optimizeMessageContent(boolean z) {
        if (!z) {
            this.contentImage.setRadius(ScreenUtil.dip2px(16.0f));
        } else if (this.isShowStart) {
            this.contentImage.setRadius(ScreenUtil.dip2px(16.0f));
            this.contentImage.setLeftBottomRadius(0);
        } else {
            this.contentImage.setRadius(ScreenUtil.dip2px(16.0f));
            this.contentImage.setRightBottomRadius(0);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder
    public void setHighLightBackground(int i) {
        Drawable drawable = this.contentImage.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setImagePadding(TUIMessageBean tUIMessageBean) {
        int dip2px = ScreenUtil.dip2px(1.0f);
        this.msgArea.setPadding(dip2px, dip2px, dip2px, dip2px);
    }
}
