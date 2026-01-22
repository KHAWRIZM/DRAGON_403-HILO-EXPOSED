package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import c5.g;
import com.bumptech.glide.request.target.j;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.util.ImageUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.List;
import m4.a;
import o4.q;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ImageReplyQuoteView extends TUIReplyQuoteView {
    protected static final int DEFAULT_RADIUS = 2;
    protected final List<String> downloadEles;
    protected ImageView imageMsgIv;
    protected View imageMsgLayout;
    protected String mImagePath;
    protected ImageView videoPlayIv;

    public ImageReplyQuoteView(Context context) {
        super(context);
        this.downloadEles = new ArrayList();
        this.mImagePath = null;
        this.imageMsgLayout = findViewById(R.id.image_msg_layout);
        this.imageMsgIv = (ImageView) findViewById(R.id.image_msg_iv);
        this.videoPlayIv = (ImageView) findViewById(R.id.video_play_iv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewGroup.LayoutParams getImageParams(ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (i != 0 && i2 != 0) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.reply_message_image_size);
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

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.TUIReplyQuoteView
    public int getLayoutResourceId() {
        return R.layout.chat_reply_quote_image_layout;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.TUIReplyQuoteView
    public void onDrawReplyQuote(TUIReplyQuoteBean tUIReplyQuoteBean) {
        final ImageMessageBean imageMessageBean = (ImageMessageBean) tUIReplyQuoteBean.getMessageBean();
        this.imageMsgLayout.setVisibility(0);
        ImageView imageView = this.imageMsgIv;
        imageView.setLayoutParams(getImageParams(imageView.getLayoutParams(), imageMessageBean.getImgWidth(), imageMessageBean.getImgHeight()));
        List<ImageMessageBean.ImageBean> imageBeanList = imageMessageBean.getImageBeanList();
        String dataPath = imageMessageBean.getDataPath();
        String originImagePath = TUIChatUtils.getOriginImagePath(imageMessageBean);
        if (!TextUtils.isEmpty(originImagePath)) {
            dataPath = originImagePath;
        }
        if (!TextUtils.isEmpty(dataPath)) {
            GlideEngine.loadCornerImageWithoutPlaceHolder(this.imageMsgIv, dataPath, null, 2.0f);
            return;
        }
        GlideEngine.clear(this.imageMsgIv);
        for (int i = 0; i < imageBeanList.size(); i++) {
            final ImageMessageBean.ImageBean imageBean = imageBeanList.get(i);
            if (imageBean.getType() == 1) {
                synchronized (this.downloadEles) {
                    try {
                        if (!this.downloadEles.contains(imageBean.getUUID())) {
                            this.downloadEles.add(imageBean.getUUID());
                            final String generateImagePath = ImageUtil.generateImagePath(imageBean.getUUID(), 1);
                            if (!generateImagePath.equals(this.mImagePath)) {
                                GlideEngine.clear(this.imageMsgIv);
                            }
                            imageBean.downloadImage(generateImagePath, new ImageMessageBean.ImageBean.ImageDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.ImageReplyQuoteView.1
                                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.ImageDownloadCallback
                                public void onError(int i2, String str) {
                                    ImageReplyQuoteView.this.downloadEles.remove(imageBean.getUUID());
                                    TUIChatLog.e("MessageAdapter img getImage", i2 + ":" + str);
                                }

                                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.ImageDownloadCallback
                                public void onProgress(long j, long j2) {
                                    TUIChatLog.i("downloadImage progress current:", j + ", total:" + j2);
                                }

                                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.ImageDownloadCallback
                                public void onSuccess() {
                                    ImageReplyQuoteView.this.downloadEles.remove(imageBean.getUUID());
                                    imageMessageBean.setDataPath(generateImagePath);
                                    GlideEngine.loadCornerImageWithoutPlaceHolder(ImageReplyQuoteView.this.imageMsgIv, imageMessageBean.getDataPath(), new g() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.ImageReplyQuoteView.1.1
                                        public boolean onLoadFailed(q qVar, Object obj, j jVar, boolean z) {
                                            ImageReplyQuoteView.this.mImagePath = null;
                                            return false;
                                        }

                                        public boolean onResourceReady(Object obj, Object obj2, j jVar, a aVar, boolean z) {
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            ImageReplyQuoteView.this.mImagePath = generateImagePath;
                                            return false;
                                        }
                                    }, 2.0f);
                                }
                            });
                        }
                    } finally {
                    }
                }
                return;
            }
        }
    }
}
