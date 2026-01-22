package com.tencent.qcloud.tuikit.tuichat.bean.message;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMDownloadCallback;
import com.tencent.imsdk.v2.V2TIMElem;
import com.tencent.imsdk.v2.V2TIMImageElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.util.ImageUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.ImageReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ImageMessageBean extends TUIMessageBean {
    public static final int IMAGE_TYPE_LARGE = 2;
    public static final int IMAGE_TYPE_ORIGIN = 0;
    public static final int IMAGE_TYPE_THUMB = 1;
    private String dataPath;
    private String dataUri;
    private List<ImageBean> imageBeanList;
    private V2TIMImageElem imageElem;
    private int imgHeight;
    private int imgWidth;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class ImageBean implements Serializable {
        private V2TIMImageElem.V2TIMImage v2TIMImage;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public interface ImageDownloadCallback {
            void onError(int i, String str);

            void onProgress(long j, long j2);

            void onSuccess();
        }

        public void downloadImage(String str, final ImageDownloadCallback imageDownloadCallback) {
            V2TIMImageElem.V2TIMImage v2TIMImage = this.v2TIMImage;
            if (v2TIMImage != null) {
                v2TIMImage.downloadImage(str, new V2TIMDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.1
                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onError(int i, String str2) {
                        ImageDownloadCallback imageDownloadCallback2 = imageDownloadCallback;
                        if (imageDownloadCallback2 != null) {
                            imageDownloadCallback2.onError(i, str2);
                        }
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMDownloadCallback
                    public void onProgress(V2TIMElem.V2ProgressInfo v2ProgressInfo) {
                        ImageDownloadCallback imageDownloadCallback2 = imageDownloadCallback;
                        if (imageDownloadCallback2 != null) {
                            imageDownloadCallback2.onProgress(v2ProgressInfo.getCurrentSize(), v2ProgressInfo.getTotalSize());
                        }
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onSuccess() {
                        ImageDownloadCallback imageDownloadCallback2 = imageDownloadCallback;
                        if (imageDownloadCallback2 != null) {
                            imageDownloadCallback2.onSuccess();
                        }
                    }
                });
            }
        }

        public int getHeight() {
            V2TIMImageElem.V2TIMImage v2TIMImage = this.v2TIMImage;
            if (v2TIMImage != null) {
                return v2TIMImage.getHeight();
            }
            return 0;
        }

        public int getSize() {
            V2TIMImageElem.V2TIMImage v2TIMImage = this.v2TIMImage;
            if (v2TIMImage != null) {
                return v2TIMImage.getSize();
            }
            return 0;
        }

        public int getType() {
            V2TIMImageElem.V2TIMImage v2TIMImage = this.v2TIMImage;
            if (v2TIMImage != null) {
                return v2TIMImage.getType();
            }
            return 1;
        }

        public String getUUID() {
            V2TIMImageElem.V2TIMImage v2TIMImage = this.v2TIMImage;
            if (v2TIMImage != null) {
                return v2TIMImage.getUUID();
            }
            return "";
        }

        public String getUrl() {
            V2TIMImageElem.V2TIMImage v2TIMImage = this.v2TIMImage;
            if (v2TIMImage != null) {
                return v2TIMImage.getUrl();
            }
            return "";
        }

        public V2TIMImageElem.V2TIMImage getV2TIMImage() {
            return this.v2TIMImage;
        }

        public int getWidth() {
            V2TIMImageElem.V2TIMImage v2TIMImage = this.v2TIMImage;
            if (v2TIMImage != null) {
                return v2TIMImage.getWidth();
            }
            return 0;
        }

        public void setV2TIMImage(V2TIMImageElem.V2TIMImage v2TIMImage) {
            this.v2TIMImage = v2TIMImage;
        }
    }

    public String getDataPath() {
        return this.dataPath;
    }

    public Uri getDataUriObj() {
        if (!TextUtils.isEmpty(this.dataUri)) {
            return Uri.parse(this.dataUri);
        }
        return null;
    }

    public List<ImageBean> getImageBeanList() {
        return this.imageBeanList;
    }

    public int getImgHeight() {
        return this.imgHeight;
    }

    public int getImgWidth() {
        return this.imgWidth;
    }

    public String getPath() {
        V2TIMImageElem v2TIMImageElem = this.imageElem;
        if (v2TIMImageElem != null) {
            return v2TIMImageElem.getPath();
        }
        return "";
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return ImageReplyQuoteBean.class;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public String onGetDisplayString() {
        return getExtra();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        V2TIMImageElem imageElem = v2TIMMessage.getImageElem();
        this.imageElem = imageElem;
        List<V2TIMImageElem.V2TIMImage> imageList = imageElem.getImageList();
        if (imageList != null) {
            ArrayList arrayList = new ArrayList();
            for (V2TIMImageElem.V2TIMImage v2TIMImage : imageList) {
                ImageBean imageBean = new ImageBean();
                imageBean.setV2TIMImage(v2TIMImage);
                arrayList.add(imageBean);
            }
            this.imageBeanList = arrayList;
        }
        String path = this.imageElem.getPath();
        if (isSelf() && !TextUtils.isEmpty(path) && new File(path).exists()) {
            this.dataPath = path;
            int[] imageSize = ImageUtil.getImageSize(path);
            this.imgWidth = imageSize[0];
            this.imgHeight = imageSize[1];
        } else {
            List<V2TIMImageElem.V2TIMImage> imageList2 = this.imageElem.getImageList();
            for (int i = 0; i < imageList2.size(); i++) {
                V2TIMImageElem.V2TIMImage v2TIMImage2 = imageList2.get(i);
                if (v2TIMImage2.getType() == 0) {
                    this.imgWidth = v2TIMImage2.getWidth();
                    this.imgHeight = v2TIMImage2.getHeight();
                }
                if (v2TIMImage2.getType() == 1) {
                    String generateImagePath = ImageUtil.generateImagePath(v2TIMImage2.getUUID(), 1);
                    if (new File(generateImagePath).exists()) {
                        this.dataPath = generateImagePath;
                    }
                }
            }
        }
        setExtra(ServiceInitializer.getAppContext().getString(R.string.picture_extra));
    }

    public void setDataPath(String str) {
        this.dataPath = str;
    }

    public void setDataUri(Uri uri) {
        if (uri != null) {
            this.dataUri = uri.toString();
        }
    }

    public void setImageBeanList(List<ImageBean> list) {
        this.imageBeanList = list;
    }

    public void setImageElem(V2TIMImageElem v2TIMImageElem) {
        this.imageElem = v2TIMImageElem;
    }

    public void setImgHeight(int i) {
        this.imgHeight = i;
    }

    public void setImgWidth(int i) {
        this.imgWidth = i;
    }
}
