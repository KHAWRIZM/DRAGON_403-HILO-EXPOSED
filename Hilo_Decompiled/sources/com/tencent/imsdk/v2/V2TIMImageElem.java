package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.message.DownloadParam;
import com.tencent.imsdk.message.DownloadProgressInfo;
import com.tencent.imsdk.message.ImageElement;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.v2.V2TIMElem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMImageElem extends V2TIMElem {
    public static final int V2TIM_IMAGE_TYPE_LARGE = 2;
    public static final int V2TIM_IMAGE_TYPE_ORIGIN = 0;
    public static final int V2TIM_IMAGE_TYPE_THUMB = 1;
    private ImageElement timImageElem;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class V2TIMImage implements Serializable {
        private int height;
        private int size;
        private int type;
        private String url;
        private String uuid;
        private int width;

        public V2TIMImage() {
        }

        public void downloadImage(String str, final V2TIMDownloadCallback v2TIMDownloadCallback) {
            DownloadParam downloadParam = new DownloadParam();
            downloadParam.setDownloadUrl(this.url);
            downloadParam.setFileSavePath(str);
            MessageCenter.getInstance().downloadMessageElement(downloadParam, new IMCallback<DownloadProgressInfo>(new V2TIMValueCallback<DownloadProgressInfo>() { // from class: com.tencent.imsdk.v2.V2TIMImageElem.V2TIMImage.1
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str2) {
                    V2TIMDownloadCallback v2TIMDownloadCallback2 = v2TIMDownloadCallback;
                    if (v2TIMDownloadCallback2 != null) {
                        v2TIMDownloadCallback2.onError(i, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(DownloadProgressInfo downloadProgressInfo) {
                    V2TIMElem.V2ProgressInfo v2ProgressInfo = new V2TIMElem.V2ProgressInfo(downloadProgressInfo.getCurrentSize(), downloadProgressInfo.getTotalSize());
                    V2TIMDownloadCallback v2TIMDownloadCallback2 = v2TIMDownloadCallback;
                    if (v2TIMDownloadCallback2 != null) {
                        v2TIMDownloadCallback2.onProgress(v2ProgressInfo);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMImageElem.V2TIMImage.3
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(DownloadProgressInfo downloadProgressInfo) {
                    super.success((AnonymousClass3) downloadProgressInfo);
                }
            }, new IMCallback(new V2TIMCallback() { // from class: com.tencent.imsdk.v2.V2TIMImageElem.V2TIMImage.2
                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onError(int i, String str2) {
                    V2TIMDownloadCallback v2TIMDownloadCallback2 = v2TIMDownloadCallback;
                    if (v2TIMDownloadCallback2 != null) {
                        v2TIMDownloadCallback2.onError(i, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onSuccess() {
                    V2TIMDownloadCallback v2TIMDownloadCallback2 = v2TIMDownloadCallback;
                    if (v2TIMDownloadCallback2 != null) {
                        v2TIMDownloadCallback2.onSuccess();
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMImageElem.V2TIMImage.4
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }

        public int getHeight() {
            return this.height;
        }

        public int getSize() {
            return this.size;
        }

        public int getType() {
            return this.type;
        }

        public String getUUID() {
            return this.uuid;
        }

        public String getUrl() {
            return this.url;
        }

        public int getWidth() {
            return this.width;
        }

        protected void setHeight(int i) {
            this.height = i;
        }

        protected void setSize(int i) {
            this.size = i;
        }

        protected void setType(int i) {
            this.type = i;
        }

        protected void setUUID(String str) {
            this.uuid = str;
        }

        protected void setUrl(String str) {
            this.url = str;
        }

        protected void setWidth(int i) {
            this.width = i;
        }
    }

    public List<V2TIMImage> getImageList() {
        if (getElement() == null) {
            return null;
        }
        this.timImageElem = (ImageElement) getElement();
        ArrayList arrayList = new ArrayList();
        V2TIMImage v2TIMImage = new V2TIMImage();
        v2TIMImage.setUUID(this.timImageElem.getOriginImageUUID());
        v2TIMImage.setType(0);
        v2TIMImage.setSize(this.timImageElem.getOriginImageFileSize());
        v2TIMImage.setWidth(this.timImageElem.getOriginImageWidth());
        v2TIMImage.setHeight(this.timImageElem.getOriginImageHeight());
        v2TIMImage.setUrl(this.timImageElem.getOriginImageUrl());
        arrayList.add(v2TIMImage);
        V2TIMImage v2TIMImage2 = new V2TIMImage();
        v2TIMImage2.setUUID(this.timImageElem.getLargeImageUUID());
        v2TIMImage2.setType(2);
        v2TIMImage2.setSize(this.timImageElem.getLargeImageFileSize());
        v2TIMImage2.setWidth(this.timImageElem.getLargeImageWidth());
        v2TIMImage2.setHeight(this.timImageElem.getLargeImageHeight());
        v2TIMImage2.setUrl(this.timImageElem.getLargeImageUrl());
        arrayList.add(v2TIMImage2);
        V2TIMImage v2TIMImage3 = new V2TIMImage();
        v2TIMImage3.setUUID(this.timImageElem.getThumbImageUUID());
        v2TIMImage3.setType(1);
        v2TIMImage3.setSize(this.timImageElem.getThumbImageFileSize());
        v2TIMImage3.setWidth(this.timImageElem.getThumbImageWidth());
        v2TIMImage3.setHeight(this.timImageElem.getThumbImageHeight());
        v2TIMImage3.setUrl(this.timImageElem.getThumbImageUrl());
        arrayList.add(v2TIMImage3);
        return arrayList;
    }

    public String getPath() {
        if (getElement() == null) {
            return null;
        }
        ImageElement imageElement = (ImageElement) getElement();
        this.timImageElem = imageElement;
        return imageElement.getOriginImageFilePath();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("V2TIMImageElem--->");
        sb2.append(", localPath=");
        sb2.append(getPath());
        for (V2TIMImage v2TIMImage : getImageList()) {
            sb2.append(", type:");
            sb2.append(v2TIMImage.getType());
            sb2.append(", uuid:");
            sb2.append(v2TIMImage.getUUID());
            sb2.append(", height:");
            sb2.append(v2TIMImage.getHeight());
            sb2.append(", width:");
            sb2.append(v2TIMImage.getWidth());
            sb2.append(", size:");
            sb2.append(v2TIMImage.getSize());
            sb2.append(", url:" + v2TIMImage.getUrl());
        }
        return sb2.toString();
    }
}
