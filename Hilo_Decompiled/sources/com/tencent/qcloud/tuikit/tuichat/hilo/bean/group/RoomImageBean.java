package com.tencent.qcloud.tuikit.tuichat.hilo.bean.group;

import android.net.Uri;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.tencent.imsdk.v2.V2TIMDownloadCallback;
import com.tencent.imsdk.v2.V2TIMElem;
import com.tencent.imsdk.v2.V2TIMImageElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.util.ImageUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.ImageReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomImageBean;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00182\b\u0010\f\u001a\u0004\u0018\u00010\u001cJ\b\u0010\u001e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u001f\u001a\u00020\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010 \u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020\u0005J\u0010\u0010$\u001a\u00020\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0016\u0010%\u001a\u00020\u00182\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J\b\u0010'\u001a\u0004\u0018\u00010\rJ\u0014\u0010(\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010*\u0018\u00010)H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomImageBean;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomTUIBean;", "<init>", "()V", "IMAGE_TYPE_ORIGIN", "", "getIMAGE_TYPE_ORIGIN", "()I", "IMAGE_TYPE_THUMB", "getIMAGE_TYPE_THUMB", "IMAGE_TYPE_LARGE", "getIMAGE_TYPE_LARGE", "dataUri", "", "dataPath", "imgWidth", "imgHeight", "imageElem", "Lcom/tencent/imsdk/v2/V2TIMImageElem;", "imageBeanList", "", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomImageBean$ImageBean;", "onGetDisplayString", "onProcessMessage", "", TUIConstants.TUIChat.V2TIMMESSAGE, "Lcom/tencent/imsdk/v2/V2TIMMessage;", "getDataUriObj", "Landroid/net/Uri;", "setDataUri", "getDataPath", "setDataPath", "setImgHeight", "setImgWidth", "getImgHeight", "getImgWidth", "setImageElem", "setImageBeanList", "getImageBeanList", "getPath", "getReplyQuoteBeanClass", "Ljava/lang/Class;", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/reply/TUIReplyQuoteBean;", "ImageBean", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomImageBean extends RoomTUIBean {
    private final int IMAGE_TYPE_ORIGIN;

    @Nullable
    private String dataPath;

    @Nullable
    private String dataUri;

    @Nullable
    private List<ImageBean> imageBeanList;

    @Nullable
    private V2TIMImageElem imageElem;
    private int imgHeight;
    private int imgWidth;
    private final int IMAGE_TYPE_THUMB = 1;
    private final int IMAGE_TYPE_LARGE = 2;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001e\u001a\u00020\u001fR \u0010\u0004\u001a\b\u0018\u00010\u0005R\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0019\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014¨\u0006!"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomImageBean$ImageBean;", "Ljava/io/Serializable;", "<init>", "()V", "v2TIMImage", "Lcom/tencent/imsdk/v2/V2TIMImageElem$V2TIMImage;", "Lcom/tencent/imsdk/v2/V2TIMImageElem;", "getV2TIMImage", "()Lcom/tencent/imsdk/v2/V2TIMImageElem$V2TIMImage;", "setV2TIMImage", "(Lcom/tencent/imsdk/v2/V2TIMImageElem$V2TIMImage;)V", "uUID", "", "getUUID", "()Ljava/lang/String;", "url", "getUrl", "type", "", "getType", "()I", "size", "getSize", "height", "getHeight", "width", "getWidth", "downloadImage", "", TUIConstants.TUICalling.PARAM_NAME_AUDIO_PATH, "callback", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomImageBean$ImageBean$ImageDownloadCallback;", "ImageDownloadCallback", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class ImageBean implements Serializable {

        @Nullable
        private V2TIMImageElem.V2TIMImage v2TIMImage;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¨\u0006\r"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomImageBean$ImageBean$ImageDownloadCallback;", "", "onProgress", "", "currentSize", "", "totalSize", "onSuccess", "onError", Constants.KEY_HTTP_CODE, "", "desc", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public interface ImageDownloadCallback {
            void onError(int code, @Nullable String desc);

            void onProgress(long currentSize, long totalSize);

            void onSuccess();
        }

        public final void downloadImage(@Nullable String path, @NotNull final ImageDownloadCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            V2TIMImageElem.V2TIMImage v2TIMImage = this.v2TIMImage;
            if (v2TIMImage != null && v2TIMImage != null) {
                v2TIMImage.downloadImage(path, new V2TIMDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomImageBean$ImageBean$downloadImage$1
                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onError(int code, String desc) {
                        Intrinsics.checkNotNullParameter(desc, "desc");
                        RoomImageBean.ImageBean.ImageDownloadCallback imageDownloadCallback = RoomImageBean.ImageBean.ImageDownloadCallback.this;
                        if (imageDownloadCallback != null) {
                            imageDownloadCallback.onError(code, desc);
                        }
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMDownloadCallback
                    public void onProgress(V2TIMElem.V2ProgressInfo progressInfo) {
                        Intrinsics.checkNotNullParameter(progressInfo, "progressInfo");
                        RoomImageBean.ImageBean.ImageDownloadCallback imageDownloadCallback = RoomImageBean.ImageBean.ImageDownloadCallback.this;
                        if (imageDownloadCallback != null) {
                            imageDownloadCallback.onProgress(progressInfo.getCurrentSize(), progressInfo.getTotalSize());
                        }
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onSuccess() {
                        RoomImageBean.ImageBean.ImageDownloadCallback imageDownloadCallback = RoomImageBean.ImageBean.ImageDownloadCallback.this;
                        if (imageDownloadCallback != null) {
                            imageDownloadCallback.onSuccess();
                        }
                    }
                });
            }
        }

        public final int getHeight() {
            V2TIMImageElem.V2TIMImage v2TIMImage = this.v2TIMImage;
            if (v2TIMImage == null || v2TIMImage == null) {
                return 0;
            }
            return v2TIMImage.getHeight();
        }

        public final int getSize() {
            V2TIMImageElem.V2TIMImage v2TIMImage = this.v2TIMImage;
            if (v2TIMImage == null || v2TIMImage == null) {
                return 0;
            }
            return v2TIMImage.getSize();
        }

        public final int getType() {
            V2TIMImageElem.V2TIMImage v2TIMImage = this.v2TIMImage;
            if (v2TIMImage == null || v2TIMImage == null) {
                return 1;
            }
            return v2TIMImage.getType();
        }

        @NotNull
        public final String getUUID() {
            String uuid;
            V2TIMImageElem.V2TIMImage v2TIMImage = this.v2TIMImage;
            if (v2TIMImage == null || v2TIMImage == null || (uuid = v2TIMImage.getUUID()) == null) {
                return "";
            }
            return uuid;
        }

        @NotNull
        public final String getUrl() {
            String url;
            V2TIMImageElem.V2TIMImage v2TIMImage = this.v2TIMImage;
            if (v2TIMImage == null || v2TIMImage == null || (url = v2TIMImage.getUrl()) == null) {
                return "";
            }
            return url;
        }

        @Nullable
        public final V2TIMImageElem.V2TIMImage getV2TIMImage() {
            return this.v2TIMImage;
        }

        public final int getWidth() {
            V2TIMImageElem.V2TIMImage v2TIMImage = this.v2TIMImage;
            if (v2TIMImage == null || v2TIMImage == null) {
                return 0;
            }
            return v2TIMImage.getWidth();
        }

        public final void setV2TIMImage(@Nullable V2TIMImageElem.V2TIMImage v2TIMImage) {
            this.v2TIMImage = v2TIMImage;
        }
    }

    @Nullable
    public final String getDataPath() {
        return this.dataPath;
    }

    @Nullable
    public final Uri getDataUriObj() {
        if (!TextUtils.isEmpty(this.dataUri)) {
            return Uri.parse(this.dataUri);
        }
        return null;
    }

    public final int getIMAGE_TYPE_LARGE() {
        return this.IMAGE_TYPE_LARGE;
    }

    public final int getIMAGE_TYPE_ORIGIN() {
        return this.IMAGE_TYPE_ORIGIN;
    }

    public final int getIMAGE_TYPE_THUMB() {
        return this.IMAGE_TYPE_THUMB;
    }

    @Nullable
    public final List<ImageBean> getImageBeanList() {
        return this.imageBeanList;
    }

    public final int getImgHeight() {
        return this.imgHeight;
    }

    public final int getImgWidth() {
        return this.imgWidth;
    }

    @Nullable
    public final String getPath() {
        V2TIMImageElem v2TIMImageElem = this.imageElem;
        if (v2TIMImageElem != null) {
            if (v2TIMImageElem != null) {
                return v2TIMImageElem.getPath();
            }
            return null;
        }
        return "";
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    @Nullable
    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return ImageReplyQuoteBean.class;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    @Nullable
    public String onGetDisplayString() {
        return getExtra();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public void onProcessMessage(@NotNull V2TIMMessage v2TIMMessage) {
        List<V2TIMImageElem.V2TIMImage> list;
        List<V2TIMImageElem.V2TIMImage> imageList;
        Intrinsics.checkNotNullParameter(v2TIMMessage, TUIConstants.TUIChat.V2TIMMESSAGE);
        V2TIMImageElem imageElem = v2TIMMessage.getImageElem();
        this.imageElem = imageElem;
        String str = null;
        if (imageElem != null) {
            list = imageElem.getImageList();
        } else {
            list = null;
        }
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (V2TIMImageElem.V2TIMImage v2TIMImage : list) {
                ImageBean imageBean = new ImageBean();
                imageBean.setV2TIMImage(v2TIMImage);
                arrayList.add(imageBean);
            }
            this.imageBeanList = arrayList;
        }
        V2TIMImageElem v2TIMImageElem = this.imageElem;
        if (v2TIMImageElem != null) {
            str = v2TIMImageElem.getPath();
        }
        if (isSelf() && !TextUtils.isEmpty(str) && new File(str).exists()) {
            this.dataPath = str;
            int[] imageSize = ImageUtil.getImageSize(str);
            this.imgWidth = imageSize[0];
            this.imgHeight = imageSize[1];
        } else {
            V2TIMImageElem v2TIMImageElem2 = this.imageElem;
            if (v2TIMImageElem2 != null && (imageList = v2TIMImageElem2.getImageList()) != null) {
                int size = imageList.size();
                for (int i = 0; i < size; i++) {
                    V2TIMImageElem.V2TIMImage v2TIMImage2 = imageList.get(i);
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
            } else {
                return;
            }
        }
        setExtra(ServiceInitializer.getAppContext().getString(R.string.picture_extra));
    }

    public final void setDataPath(@Nullable String dataPath) {
        this.dataPath = dataPath;
    }

    public final void setDataUri(@Nullable Uri dataUri) {
        if (dataUri != null) {
            this.dataUri = dataUri.toString();
        }
    }

    public final void setImageBeanList(@Nullable List<ImageBean> imageBeanList) {
        this.imageBeanList = imageBeanList;
    }

    public final void setImageElem(@Nullable V2TIMImageElem imageElem) {
        this.imageElem = imageElem;
    }

    public final void setImgHeight(int imgHeight) {
        this.imgHeight = imgHeight;
    }

    public final void setImgWidth(int imgWidth) {
        this.imgWidth = imgWidth;
    }
}
