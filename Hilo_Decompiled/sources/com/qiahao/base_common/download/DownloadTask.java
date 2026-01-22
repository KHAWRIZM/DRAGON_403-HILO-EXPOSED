package com.qiahao.base_common.download;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.oudi.core.component.ICleared;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0007H&J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0013"}, d2 = {"Lcom/qiahao/base_common/download/DownloadTask;", "Lcom/oudi/core/component/ICleared;", "getRequest", "Lcom/qiahao/base_common/download/DownloadRequest;", "getState", "", "getId", "", "getFilePath", "start", "", "stop", "isPause", "", "addListener", ViewHierarchyConstants.TAG_KEY, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/qiahao/base_common/download/DownloadListener;", "removeListener", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface DownloadTask extends ICleared {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void addListener$default(DownloadTask downloadTask, String str, DownloadListener downloadListener, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    str = null;
                }
                downloadTask.addListener(str, downloadListener);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addListener");
        }

        public static boolean isPause(@NotNull DownloadTask downloadTask) {
            if (downloadTask.getState() == 4) {
                return true;
            }
            return false;
        }

        public static void onCleared(@NotNull DownloadTask downloadTask) {
            ICleared.DefaultImpls.onCleared(downloadTask);
        }
    }

    void addListener(@Nullable String tag, @NotNull DownloadListener listener);

    @Nullable
    String getFilePath();

    @NotNull
    String getId();

    @NotNull
    DownloadRequest getRequest();

    int getState();

    boolean isPause();

    void removeListener(@NotNull DownloadListener listener);

    void removeListener(@NotNull String tag);

    void start();

    void stop();
}
