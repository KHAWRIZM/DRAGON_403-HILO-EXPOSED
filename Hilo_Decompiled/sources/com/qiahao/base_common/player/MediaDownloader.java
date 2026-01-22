package com.qiahao.base_common.player;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.oudi.core.component.ICleared;
import com.qiahao.base_common.download.DownloadListener;
import com.qiahao.base_common.download.DownloadManager;
import com.qiahao.base_common.download.DownloadRequest;
import com.qiahao.base_common.utils.PathHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\fJ)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\r"}, d2 = {"Lcom/qiahao/base_common/player/MediaDownloader;", "Lcom/oudi/core/component/ICleared;", "download", "", "url", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/qiahao/base_common/download/DownloadListener;", "tempFile", "", "(Ljava/lang/String;Lcom/qiahao/base_common/download/DownloadListener;Ljava/lang/Boolean;)V", "onCleared", "MediaDownloaderImpl", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface MediaDownloader extends ICleared {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void download$default(MediaDownloader mediaDownloader, String str, DownloadListener downloadListener, Boolean bool, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 4) != 0) {
                    bool = null;
                }
                mediaDownloader.download(str, downloadListener, bool);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: download");
        }

        public static void onCleared(@NotNull MediaDownloader mediaDownloader) {
            ICleared.DefaultImpls.onCleared(mediaDownloader);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/qiahao/base_common/player/MediaDownloader$MediaDownloaderImpl;", "Lcom/qiahao/base_common/player/MediaDownloader;", "timeout", "", "<init>", "(J)V", "download", "", "url", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/qiahao/base_common/download/DownloadListener;", "tempFile", "", "(Ljava/lang/String;Lcom/qiahao/base_common/download/DownloadListener;Ljava/lang/Boolean;)V", "onCleared", "getDownloadTag", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class MediaDownloaderImpl implements MediaDownloader {
        private final long timeout;

        public MediaDownloaderImpl() {
            this(0L, 1, null);
        }

        private final String getDownloadTag() {
            return String.valueOf(hashCode());
        }

        @Override // com.qiahao.base_common.player.MediaDownloader
        public void download(@NotNull String url, @NotNull DownloadListener listener, @Nullable Boolean tempFile) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(listener, "listener");
            if (url.length() == 0) {
                return;
            }
            DownloadManager.INSTANCE.download(DownloadRequest.INSTANCE.build(url, PathHelper.INSTANCE.getAppPrivateDownloadPath(), getDownloadTag(), null, Long.valueOf(this.timeout), tempFile), listener);
        }

        @Override // com.qiahao.base_common.player.MediaDownloader, com.oudi.utils.ICleared
        public void onCleared() {
            DefaultImpls.onCleared(this);
            DownloadManager.INSTANCE.stopTag(getDownloadTag());
        }

        public MediaDownloaderImpl(long j10) {
            this.timeout = j10;
        }

        public /* synthetic */ MediaDownloaderImpl(long j10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? 60000L : j10);
        }
    }

    void download(@NotNull String url, @NotNull DownloadListener listener, @Nullable Boolean tempFile);

    @Override // com.oudi.utils.ICleared
    void onCleared();
}
