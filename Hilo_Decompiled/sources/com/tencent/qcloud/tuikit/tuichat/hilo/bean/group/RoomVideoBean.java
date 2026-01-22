package com.tencent.qcloud.tuikit.tuichat.hilo.bean.group;

import android.net.Uri;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.v2.V2TIMDownloadCallback;
import com.tencent.imsdk.v2.V2TIMElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.imsdk.v2.V2TIMVideoElem;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.util.FileUtil;
import com.tencent.qcloud.tuicore.util.ImageUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.VideoReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomVideoBean;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\b\u0010\u0004\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010 \u001a\u00020\u00182\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0018\u0010)\u001a\u00020\u00182\u0010\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010+J\u001a\u0010,\u001a\u00020\u00182\b\u0010-\u001a\u0004\u0018\u00010\u00052\b\u0010*\u001a\u0004\u0018\u00010.J\u001a\u0010/\u001a\u00020\u00182\b\u0010-\u001a\u0004\u0018\u00010\u00052\b\u0010*\u001a\u0004\u0018\u00010.J\u0012\u00100\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010201H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010!\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\"\u0010\bR\u0011\u0010#\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b$\u0010\bR\u0011\u0010%\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b&\u0010\u000eR\u0011\u0010'\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b(\u0010\u000e¨\u00064"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomVideoBean;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomTUIBean;", "<init>", "()V", "dataUri", "", "dataPath", "getDataPath", "()Ljava/lang/String;", "setDataPath", "(Ljava/lang/String;)V", "imgWidth", "", "getImgWidth", "()I", "setImgWidth", "(I)V", "imgHeight", "getImgHeight", "setImgHeight", "videoElem", "Lcom/tencent/imsdk/v2/V2TIMVideoElem;", "onGetDisplayString", "onProcessMessage", "", TUIConstants.TUIChat.V2TIMMESSAGE, "Lcom/tencent/imsdk/v2/V2TIMMessage;", "dataUriObj", "Landroid/net/Uri;", "getDataUriObj", "()Landroid/net/Uri;", "setDataUri", "setVideoElem", "snapshotUUID", "getSnapshotUUID", "videoUUID", "getVideoUUID", "duration", "getDuration", "videoSize", "getVideoSize", "getVideoUrl", "callback", "Lcom/tencent/imsdk/v2/V2TIMValueCallback;", "downloadSnapshot", TUIConstants.TUICalling.PARAM_NAME_AUDIO_PATH, "Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomVideoBean$VideoDownloadCallback;", "downloadVideo", "getReplyQuoteBeanClass", "Ljava/lang/Class;", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/reply/TUIReplyQuoteBean;", "VideoDownloadCallback", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomVideoBean extends RoomTUIBean {

    @Nullable
    private String dataPath;

    @Nullable
    private String dataUri;
    private int imgHeight;
    private int imgWidth;

    @Nullable
    private V2TIMVideoElem videoElem;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¨\u0006\r"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomVideoBean$VideoDownloadCallback;", "", "onProgress", "", "currentSize", "", "totalSize", "onSuccess", "onError", Constants.KEY_HTTP_CODE, "", "desc", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface VideoDownloadCallback {
        void onError(int code, @Nullable String desc);

        void onProgress(long currentSize, long totalSize);

        void onSuccess();
    }

    public final void downloadSnapshot(@Nullable String path, @Nullable final VideoDownloadCallback callback) {
        V2TIMVideoElem v2TIMVideoElem = this.videoElem;
        if (v2TIMVideoElem != null && v2TIMVideoElem != null) {
            v2TIMVideoElem.downloadSnapshot(path, new V2TIMDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomVideoBean$downloadSnapshot$1
                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onError(int code, String desc) {
                    Intrinsics.checkNotNullParameter(desc, "desc");
                    RoomVideoBean.VideoDownloadCallback videoDownloadCallback = RoomVideoBean.VideoDownloadCallback.this;
                    if (videoDownloadCallback != null) {
                        videoDownloadCallback.onError(code, desc);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMDownloadCallback
                public void onProgress(V2TIMElem.V2ProgressInfo progressInfo) {
                    Intrinsics.checkNotNullParameter(progressInfo, "progressInfo");
                    RoomVideoBean.VideoDownloadCallback videoDownloadCallback = RoomVideoBean.VideoDownloadCallback.this;
                    if (videoDownloadCallback != null) {
                        videoDownloadCallback.onProgress(progressInfo.getCurrentSize(), progressInfo.getTotalSize());
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onSuccess() {
                    RoomVideoBean.VideoDownloadCallback videoDownloadCallback = RoomVideoBean.VideoDownloadCallback.this;
                    if (videoDownloadCallback != null) {
                        videoDownloadCallback.onSuccess();
                    }
                }
            });
        }
    }

    public final void downloadVideo(@Nullable String path, @Nullable final VideoDownloadCallback callback) {
        V2TIMVideoElem v2TIMVideoElem = this.videoElem;
        if (v2TIMVideoElem != null && v2TIMVideoElem != null) {
            v2TIMVideoElem.downloadVideo(path, new V2TIMDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomVideoBean$downloadVideo$1
                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onError(int code, String desc) {
                    Intrinsics.checkNotNullParameter(desc, "desc");
                    RoomVideoBean.VideoDownloadCallback videoDownloadCallback = RoomVideoBean.VideoDownloadCallback.this;
                    if (videoDownloadCallback != null) {
                        videoDownloadCallback.onError(code, desc);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMDownloadCallback
                public void onProgress(V2TIMElem.V2ProgressInfo progressInfo) {
                    Intrinsics.checkNotNullParameter(progressInfo, "progressInfo");
                    RoomVideoBean.VideoDownloadCallback videoDownloadCallback = RoomVideoBean.VideoDownloadCallback.this;
                    if (videoDownloadCallback != null) {
                        videoDownloadCallback.onProgress(progressInfo.getCurrentSize(), progressInfo.getTotalSize());
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onSuccess() {
                    RoomVideoBean.VideoDownloadCallback videoDownloadCallback = RoomVideoBean.VideoDownloadCallback.this;
                    if (videoDownloadCallback != null) {
                        videoDownloadCallback.onSuccess();
                    }
                }
            });
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

    public final int getDuration() {
        V2TIMVideoElem v2TIMVideoElem = this.videoElem;
        if (v2TIMVideoElem == null || v2TIMVideoElem == null) {
            return 0;
        }
        return v2TIMVideoElem.getDuration();
    }

    public final int getImgHeight() {
        return this.imgHeight;
    }

    public final int getImgWidth() {
        return this.imgWidth;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    @NotNull
    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return VideoReplyQuoteBean.class;
    }

    @NotNull
    public final String getSnapshotUUID() {
        String snapshotUUID;
        V2TIMVideoElem v2TIMVideoElem = this.videoElem;
        if (v2TIMVideoElem == null || v2TIMVideoElem == null || (snapshotUUID = v2TIMVideoElem.getSnapshotUUID()) == null) {
            return "";
        }
        return snapshotUUID;
    }

    public final int getVideoSize() {
        V2TIMVideoElem v2TIMVideoElem = this.videoElem;
        if (v2TIMVideoElem == null || v2TIMVideoElem == null) {
            return 0;
        }
        return v2TIMVideoElem.getVideoSize();
    }

    @NotNull
    public final String getVideoUUID() {
        String videoUUID;
        V2TIMVideoElem v2TIMVideoElem = this.videoElem;
        if (v2TIMVideoElem == null || v2TIMVideoElem == null || (videoUUID = v2TIMVideoElem.getVideoUUID()) == null) {
            return "";
        }
        return videoUUID;
    }

    public final void getVideoUrl(@Nullable V2TIMValueCallback<String> callback) {
        if (callback == null) {
            return;
        }
        V2TIMVideoElem v2TIMVideoElem = this.videoElem;
        if (v2TIMVideoElem == null) {
            callback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "elem is null");
        } else if (v2TIMVideoElem != null) {
            v2TIMVideoElem.getVideoUrl(callback);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    @NotNull
    public String onGetDisplayString() {
        String extra = getExtra();
        Intrinsics.checkNotNullExpressionValue(extra, "getExtra(...)");
        return extra;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public void onProcessMessage(@NotNull V2TIMMessage v2TIMMessage) {
        Intrinsics.checkNotNullParameter(v2TIMMessage, TUIConstants.TUIChat.V2TIMMESSAGE);
        V2TIMVideoElem videoElem = v2TIMMessage.getVideoElem();
        if (isSelf() && !TextUtils.isEmpty(videoElem.getSnapshotPath())) {
            int[] imageSize = ImageUtil.getImageSize(videoElem.getSnapshotPath());
            this.imgWidth = imageSize[0];
            this.imgHeight = imageSize[1];
            this.dataPath = videoElem.getSnapshotPath();
            setDataUri(FileUtil.getUriFromPath(videoElem.getVideoPath()));
        } else {
            setDataUri(Uri.parse(TUIConfig.getVideoDownloadDir() + videoElem.getVideoUUID()));
            this.imgWidth = videoElem.getSnapshotWidth();
            this.imgHeight = videoElem.getSnapshotHeight();
            String str = TUIConfig.getImageDownloadDir() + videoElem.getSnapshotUUID();
            if (new File(str).exists()) {
                this.dataPath = str;
            }
        }
        if (v2TIMMessage.getElemType() == 5) {
            this.videoElem = v2TIMMessage.getVideoElem();
        }
        setExtra(ServiceInitializer.getAppContext().getString(R.string.video_extra));
    }

    public final void setDataPath(@Nullable String str) {
        this.dataPath = str;
    }

    public final void setDataUri(@Nullable Uri dataUri) {
        if (dataUri != null) {
            this.dataUri = dataUri.toString();
        }
    }

    public final void setImgHeight(int i) {
        this.imgHeight = i;
    }

    public final void setImgWidth(int i) {
        this.imgWidth = i;
    }

    public final void setVideoElem(@Nullable V2TIMVideoElem videoElem) {
        this.videoElem = videoElem;
    }
}
